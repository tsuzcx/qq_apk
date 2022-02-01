package com.tencent.TMG.camera;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.TMG.camera.opengl.SurfaceTextureManager;
import com.tencent.TMG.config.ConfigSystemImpl;
import com.tencent.TMG.sdk.AVVideoCtrl.AfterPreviewListener;
import com.tencent.TMG.sdk.AVVideoCtrl.CameraPreviewChangeCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.TMG.utils.PhoneStatusTools;
import com.tencent.TMG.utils.QLog;
import com.tencent.TMG.utils.VcSystemInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;
import java.util.StringTokenizer;

public class VcCamera
{
  static final int BACK_CAMERA = 1;
  static final int CAMERA_NONE = -1;
  static final String CAMERA_THREAD_NAME = "CAMERA";
  static final int FRONT_CAMERA = 0;
  static VcCamera.CameraInformation Info = new VcCamera.CameraInformation();
  static final String TAG = "VcCamera";
  static boolean isCameraOpened = false;
  public static WeakReference<AVVideoCtrl.CameraPreviewChangeCallback> mCameraPreviewChangeCallback = null;
  public static WeakReference<SurfaceHolder> mHolder = null;
  static volatile int nInFPS;
  volatile int CUR_CAMERA = -1;
  int CameraId = -1;
  int CompenSateRecvAngle = 0;
  int CompenSateSendAngle = 0;
  String DEV_MANUFACTURER;
  String DEV_MODEL;
  volatile int LAST_CAMERA = -1;
  int NUM_CAMERA = 0;
  int SDK_VERSION;
  CameraCaptureSettings VideoChatSettings = new CameraCaptureSettings();
  public Object afterPreviewListener;
  public final Object afterPreviewListenerLock = new Object();
  private String androidSysOorientationConfig;
  private Camera.PreviewCallback cameraCallback = new VcCamera.7(this);
  boolean cameraInitialed = false;
  public final Object cameraPreviewChangeCallbackLock = new Object();
  Display devDisplay;
  public final Object holderLock = new Object();
  boolean isPreviewFpsPrint = false;
  boolean isPreviewSizePrint = false;
  int mBackCameraAngle = 0;
  CallbackBufferAddStrategy mCallbackBufferAddStrategy;
  Camera mCamera = null;
  private Handler mCameraHandler = null;
  HandlerThread mCameraThread = null;
  Context mContext = null;
  List<Camera.Size> mFrameSizes = null;
  int mFrontCameraAngle = 0;
  volatile SurfaceTextureManager mSurfaceTextureManager = null;
  private boolean mUseSurfaceTexture = false;
  boolean mbIsTablet = false;
  int nativeObj = 0;
  int screenOrientation = 1;
  
  public VcCamera() {}
  
  public VcCamera(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.e("VcCamera", 0, "VcCamera initial context is null");
      return;
    }
    this.mContext = paramContext;
    this.devDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    this.androidSysOorientationConfig = get(this.mContext, "ro.qq.orientation");
    this.mbIsTablet = PhoneStatusTools.isTablet(paramContext);
    this.SDK_VERSION = getVersion();
    this.DEV_MODEL = Build.MODEL;
    this.DEV_MANUFACTURER = Build.MANUFACTURER;
    paramContext = Info;
    paramContext.orientation = -1;
    paramContext.rotation = -1;
    this.screenOrientation = this.mContext.getResources().getConfiguration().orientation;
    this.mSurfaceTextureManager = new SurfaceTextureManager(this.mContext);
    this.mCallbackBufferAddStrategy = new CallbackBufferAddStrategy();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("Device_Tag = ");
      paramContext.append(this.DEV_MANUFACTURER);
      paramContext.append(": ");
      paramContext.append(this.DEV_MODEL);
      QLog.d("VcCamera", 0, paramContext.toString());
      paramContext = new StringBuilder();
      paramContext.append("Rom_Tag = ");
      paramContext.append(Build.VERSION.INCREMENTAL);
      QLog.d("VcCamera", 0, paramContext.toString());
      paramContext = new StringBuilder();
      paramContext.append("screenOrientation = ");
      paramContext.append(this.screenOrientation);
      QLog.d("VcCamera", 0, paramContext.toString());
    }
  }
  
  private static int GetNumberOfCamera()
  {
    try
    {
      int i = Integer.parseInt(Class.forName("android.hardware.Camera").getMethod("getNumberOfCameras", new Class[0]).invoke(null, (Object[])null).toString());
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "GetNumberOfCamera", localException);
      }
    }
    return 1;
  }
  
  private void adjustDirection(Camera paramCamera)
  {
    try
    {
      Method localMethod = paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      int i;
      if (this.CUR_CAMERA == 0) {
        i = getPreviewAngleForFrontCamera() % 360;
      } else {
        i = getPreviewAngleForBackCamera() % 360;
      }
      localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(i) });
      return;
    }
    catch (Exception paramCamera)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "adjustDirection", paramCamera);
      }
    }
  }
  
  private void afterCapture(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = this.afterPreviewListenerLock;
    byte[] arrayOfByte = paramArrayOfByte;
    int m = paramInt1;
    int k = paramInt2;
    int j = paramInt3;
    int i = paramInt5;
    try
    {
      if (this.afterPreviewListener != null)
      {
        AVVideoCtrl.VideoFrame localVideoFrame = new AVVideoCtrl.VideoFrame();
        localVideoFrame.data = paramArrayOfByte;
        localVideoFrame.dataLen = paramInt1;
        localVideoFrame.height = paramInt3;
        localVideoFrame.width = paramInt2;
        localVideoFrame.videoFormat = paramInt5;
        localVideoFrame.rotate = paramInt4;
        ((AVVideoCtrl.AfterPreviewListener)this.afterPreviewListener).onFrameReceive(localVideoFrame);
        arrayOfByte = localVideoFrame.data;
        m = localVideoFrame.dataLen;
        k = localVideoFrame.width;
        j = localVideoFrame.height;
        i = localVideoFrame.videoFormat;
      }
      onCaptureFrame(arrayOfByte, m, k, j, paramInt4, i);
      return;
    }
    finally {}
  }
  
  private boolean fitSdkVersion()
  {
    return this.SDK_VERSION >= 10;
  }
  
  public static String get(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      label53:
      break label53;
    }
    return "";
  }
  
  private VcCamera.CameraInformation getCameraDisplayOrientation(int paramInt, Camera paramCamera)
  {
    paramCamera = new VcCamera.CameraInformation();
    try
    {
      Object localObject2 = Class.forName("android.hardware.Camera");
      Class localClass = Class.forName("android.hardware.Camera$CameraInfo");
      if (localClass == null)
      {
        paramCamera.rotation = -1;
        paramCamera.orientation = -1;
        return paramCamera;
      }
      Object localObject1 = localClass.newInstance();
      if (localObject1 == null)
      {
        paramCamera.rotation = -1;
        paramCamera.orientation = -1;
        return paramCamera;
      }
      Field localField1 = localObject1.getClass().getField("facing");
      Field localField2 = localObject1.getClass().getField("orientation");
      if ((localField1 != null) && (localField2 != null))
      {
        localObject2 = ((Class)localObject2).getMethod("getCameraInfo", new Class[] { Integer.TYPE, localClass });
        if (localObject2 == null)
        {
          paramCamera.rotation = -1;
          paramCamera.orientation = -1;
          return paramCamera;
        }
        ((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(paramInt), localObject1 });
        paramCamera.facing = localField1.getInt(localObject1);
        paramCamera.orientation = localField2.getInt(localObject1);
        if (this.devDisplay == null)
        {
          paramCamera.rotation = -1;
          return paramCamera;
        }
        localObject1 = this.devDisplay.getClass().getMethod("getRotation", new Class[0]);
        if (localObject1 == null)
        {
          paramCamera.rotation = -1;
          return paramCamera;
        }
        paramInt = Integer.parseInt(((Method)localObject1).invoke(this.devDisplay, (Object[])null).toString());
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return paramCamera;
              }
              paramCamera.rotation = 270;
              return paramCamera;
            }
            paramCamera.rotation = 180;
            return paramCamera;
          }
          paramCamera.rotation = 90;
          return paramCamera;
        }
        paramCamera.rotation = 0;
        return paramCamera;
      }
      paramCamera.rotation = -1;
      paramCamera.orientation = -1;
      return paramCamera;
    }
    catch (Exception localException)
    {
      label312:
      break label312;
    }
    paramCamera.rotation = 0;
    return paramCamera;
  }
  
  public static int getCameraNum()
  {
    return GetNumberOfCamera();
  }
  
  private Camera getFrontCamera()
  {
    if (fitSdkVersion()) {
      return openFrontFacingCamera();
    }
    if (this.DEV_MANUFACTURER.equalsIgnoreCase("motorola")) {
      return tryMotoFrontCamera();
    }
    if (this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) {
      return trySamsungFrontCamera();
    }
    return null;
  }
  
  public static boolean getIsNeonSupported()
  {
    return VcSystemInfo.isNeonSupported();
  }
  
  private Camera.Size getOptimalEqualPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (!this.isPreviewSizePrint)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("previewsize ,w= ");
        localStringBuilder.append(((Camera.Size)localObject2).width);
        localStringBuilder.append(",h=");
        localStringBuilder.append(((Camera.Size)localObject2).height);
        QLog.d("VcCamera", 0, localStringBuilder.toString());
      }
      this.isPreviewSizePrint = true;
    }
    int j = paramInt1;
    int i = paramInt2;
    if (!VcSystemInfo.isNormalSharp()) {
      if (paramInt1 == 192)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt2 == 144) {}
      }
      else
      {
        j = 192;
        i = 144;
      }
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Camera.Size)((Iterator)localObject2).next();
      if ((((Camera.Size)localObject1).width == j) && (((Camera.Size)localObject1).height == i))
      {
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("previewsize ,w= ");
          paramList.append(j);
          paramList.append(",h=");
          paramList.append(i);
          QLog.d("VcCamera", 0, paramList.toString());
        }
        return localObject1;
      }
    }
    paramInt2 = j;
    paramInt1 = i;
    if (!VcSystemInfo.isNormalSharp()) {
      if (j == 320)
      {
        paramInt2 = j;
        paramInt1 = i;
        if (i == 240) {}
      }
      else
      {
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Camera.Size)((Iterator)localObject2).next();
          if ((((Camera.Size)localObject1).width == 320) && (((Camera.Size)localObject1).height == 240))
          {
            if (QLog.isColorLevel())
            {
              paramList = new StringBuilder();
              paramList.append("previewsize 2, w= ");
              paramList.append(320);
              paramList.append(",h=");
              paramList.append(240);
              QLog.d("VcCamera", 0, paramList.toString());
            }
            return localObject1;
          }
        }
        paramInt2 = 320;
        paramInt1 = 240;
      }
    }
    i = paramInt2;
    j = paramInt1;
    if (paramInt2 == 320)
    {
      i = paramInt2;
      j = paramInt1;
      if (paramInt1 == 240)
      {
        paramInt1 = 640;
        paramInt2 = 480;
        localObject2 = paramList.iterator();
        do
        {
          i = paramInt1;
          j = paramInt2;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (Camera.Size)((Iterator)localObject2).next();
        } while ((((Camera.Size)localObject1).width != 640) || (((Camera.Size)localObject1).height != 480));
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("previewsize ,w= ");
          paramList.append(640);
          paramList.append(",h=");
          paramList.append(480);
          QLog.d("VcCamera", 0, paramList.toString());
        }
        return localObject1;
      }
    }
    return getOptimalPreviewSize(paramList, i, j);
  }
  
  private Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new CameraSizeComparator());
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<Camera.Size>)localObject)
    {
      localSize = (Camera.Size)localIterator.next();
      if ((localSize.width < paramInt1) || (localSize.height <= paramInt2))
      {
        localObject = paramList;
        if (localSize.width > paramInt1)
        {
          localObject = paramList;
          if (localSize.height < paramInt2) {}
        }
      }
      else
      {
        localObject = paramList;
        if (paramList == null)
        {
          paramList = new StringBuilder();
          paramList.append("better size width: ");
          paramList.append(localSize.width);
          paramList.append("height: ");
          paramList.append(localSize.height);
          QLog.i("VcCamera", 0, paramList.toString());
          localObject = localSize;
        }
        long l1 = localSize.width;
        long l2 = paramInt2;
        long l3 = localSize.height;
        long l4 = paramInt1;
        if (l1 * l2 == l3 * l4)
        {
          paramList = new StringBuilder();
          paramList.append("best size width: ");
          paramList.append(localSize.width);
          paramList.append("height: ");
          paramList.append(localSize.height);
          paramList.append("w*h1: ");
          paramList.append(localSize.width * l2);
          paramList.append("w*h2: ");
          paramList.append(localSize.height * l4);
          QLog.i("VcCamera", 0, paramList.toString());
          paramList = (List<Camera.Size>)localObject;
          break label307;
        }
      }
    }
    Camera.Size localSize = null;
    label307:
    if (localSize != null) {
      return localSize;
    }
    if (paramList != null) {
      return paramList;
    }
    return null;
  }
  
  private int getPreviewFPS(int paramInt, Camera.Parameters paramParameters)
  {
    int i;
    try
    {
      Object localObject = paramParameters.getClass().getMethod("getSupportedPreviewFrameRates", new Class[0]);
      i = paramInt;
      if (localObject != null)
      {
        paramParameters = (List)((Method)localObject).invoke(paramParameters, (Object[])null);
        i = paramInt;
        if (paramParameters != null)
        {
          Integer localInteger;
          if (!this.isPreviewFpsPrint)
          {
            localObject = paramParameters.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localInteger = (Integer)((Iterator)localObject).next();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("supported fps = ");
              localStringBuilder.append(localInteger);
              QLog.i("VcCamera", 0, localStringBuilder.toString());
            }
            this.isPreviewFpsPrint = true;
          }
          localObject = paramParameters.iterator();
          int j = 0;
          i = 10;
          while (((Iterator)localObject).hasNext())
          {
            localInteger = (Integer)((Iterator)localObject).next();
            if ((localInteger.intValue() <= paramInt) && (localInteger.intValue() >= i))
            {
              i = localInteger.intValue();
              j = 1;
            }
          }
          if (j == 0)
          {
            QLog.i("VcCamera", 0, "not find valid fps = targetFPS");
            paramParameters = paramParameters.iterator();
            i = paramInt;
            while (paramParameters.hasNext())
            {
              localObject = (Integer)paramParameters.next();
              if (((Integer)localObject).intValue() >= paramInt)
              {
                j = ((Integer)localObject).intValue();
                if ((i == paramInt) || (j <= i)) {
                  i = j;
                }
              }
            }
          }
        }
      }
    }
    catch (Exception paramParameters)
    {
      QLog.e("VcCamera", 0, "getSupportedPreviewFrameRates error = ", paramParameters);
      i = paramInt;
    }
    paramParameters = new StringBuilder();
    paramParameters.append("getPreviewFPS fps = ");
    paramParameters.append(i);
    QLog.i("VcCamera", 0, paramParameters.toString());
    return i;
  }
  
  private int getRecvAngleCompensation()
  {
    return 0;
  }
  
  private int getSendAngleCompensation()
  {
    return 0;
  }
  
  public static int getVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  private boolean openBackCamera()
  {
    try
    {
      this.mCamera = Camera.open();
      this.CUR_CAMERA = 1;
      isCameraOpened = true;
      this.CameraId = 0;
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "openBackCamera success");
      }
      return true;
    }
    catch (Exception localException)
    {
      isCameraOpened = false;
      Object localObject = this.mCamera;
      if (localObject != null) {
        ((Camera)localObject).release();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openBackCamera exception");
        ((StringBuilder)localObject).append(localException.getStackTrace());
        QLog.d("VcCamera", 0, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  private boolean openFrontCamera()
  {
    this.mCamera = getFrontCamera();
    if (this.mCamera == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "openFrontCamera camera == null");
      }
      isCameraOpened = false;
      return false;
    }
    if (this.NUM_CAMERA == 0) {
      this.NUM_CAMERA = 2;
    }
    this.CUR_CAMERA = 0;
    isCameraOpened = true;
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 0, "openFrontCamera success");
    }
    return true;
  }
  
  private Camera openFrontFacingCamera()
  {
    this.CameraId = -1;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject3 = null;
    Object localObject6 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        Class localClass = Class.forName("android.hardware.Camera");
        if (this.NUM_CAMERA == 0) {
          this.NUM_CAMERA = GetNumberOfCamera();
        }
        Object localObject1 = localObject3;
        if (this.NUM_CAMERA < 1) {
          break label640;
        }
        Object localObject14 = Class.forName("android.hardware.Camera$CameraInfo");
        if (localObject14 == null) {
          break label642;
        }
        Object localObject4 = ((Class)localObject14).newInstance();
        if (localObject4 == null) {
          break label648;
        }
        localField = localObject4.getClass().getField("facing");
        Method localMethod = localClass.getMethod("getCameraInfo", new Class[] { Integer.TYPE, localObject14 });
        localObject1 = localObject3;
        if (localMethod == null) {
          break label640;
        }
        localObject1 = localObject3;
        if (localObject14 == null) {
          break label640;
        }
        localObject1 = localObject3;
        if (localField == null) {
          break label640;
        }
        localObject1 = null;
        int i = 0;
        try
        {
          if (i < this.NUM_CAMERA)
          {
            localMethod.invoke(null, new Object[] { Integer.valueOf(i), localObject4 });
            int j = localField.getInt(localObject4);
            localObject3 = localObject1;
            if (j == 1) {
              try
              {
                localObject14 = localClass.getMethod("open", new Class[] { Integer.TYPE });
                localObject3 = localObject1;
                if (localObject14 != null)
                {
                  localObject3 = (Camera)((Method)localObject14).invoke(null, new Object[] { Integer.valueOf(i) });
                  try
                  {
                    this.CameraId = i;
                  }
                  catch (Exception localException1)
                  {
                    continue;
                  }
                  catch (SecurityException localSecurityException1)
                  {
                    continue;
                  }
                  catch (InstantiationException localInstantiationException1)
                  {
                    continue;
                  }
                  catch (InvocationTargetException localInvocationTargetException1)
                  {
                    continue;
                  }
                  catch (IllegalAccessException localIllegalAccessException1)
                  {
                    continue;
                  }
                  catch (NoSuchFieldException localNoSuchFieldException1)
                  {
                    continue;
                  }
                  catch (NoSuchMethodException localNoSuchMethodException1)
                  {
                    continue;
                  }
                  catch (ClassNotFoundException localClassNotFoundException1)
                  {
                    break label617;
                  }
                }
                i += 1;
              }
              catch (RuntimeException localRuntimeException)
              {
                this.CameraId = 0;
                if (QLog.isColorLevel()) {
                  QLog.e("VcCamera", 0, "openFrontFacingCamera", localRuntimeException);
                }
                localObject3 = null;
              }
            } else {
              localObject2 = localObject3;
            }
          }
          else
          {
            return localObject2;
          }
        }
        catch (Exception localException2)
        {
          localObject3 = localObject2;
        }
        catch (SecurityException localSecurityException2)
        {
          localObject3 = localObject2;
        }
        catch (InstantiationException localInstantiationException2)
        {
          localObject3 = localObject2;
        }
        catch (InvocationTargetException localInvocationTargetException2)
        {
          localObject3 = localObject2;
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          localObject3 = localObject2;
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          localObject3 = localObject2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localObject3 = localObject2;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          localObject3 = localObject2;
        }
        localObject2 = localObject3;
      }
      catch (Exception localException3)
      {
        localObject3 = localObject6;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label640;
        }
        QLog.e("VcCamera", 0, "openFrontFacingCamera", localException3);
        return localObject3;
      }
      catch (SecurityException localSecurityException3)
      {
        localObject3 = localObject7;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label640;
        }
        QLog.e("VcCamera", 0, "openFrontFacingCamera SecurityException", localSecurityException3);
        return localObject3;
      }
      catch (InstantiationException localInstantiationException3)
      {
        localObject3 = localObject8;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label640;
        }
        QLog.e("VcCamera", 0, "openFrontFacingCamera InstantiationException", localInstantiationException3);
        return localObject3;
      }
      catch (InvocationTargetException localInvocationTargetException3)
      {
        localObject3 = localObject9;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label640;
        }
        QLog.e("VcCamera", 0, "openFrontFacingCamera InvocationTargetException", localInvocationTargetException3);
        return localObject3;
      }
      catch (IllegalAccessException localIllegalAccessException3)
      {
        localObject3 = localObject10;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label640;
        }
        QLog.e("VcCamera", 0, "openFrontFacingCamera IllegalAccessException", localIllegalAccessException3);
        return localObject3;
      }
      catch (NoSuchFieldException localNoSuchFieldException3)
      {
        localObject3 = localObject11;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label640;
        }
        QLog.e("VcCamera", 0, "openFrontFacingCamera NoSuchFieldException", localNoSuchFieldException3);
        return localObject3;
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        localObject3 = localObject12;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label640;
        }
        QLog.e("VcCamera", 0, "openFrontFacingCamera NoSuchMethodException", localNoSuchMethodException3);
        return localObject3;
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        localObject3 = localObject13;
      }
      label617:
      if (QLog.isColorLevel())
      {
        QLog.e("VcCamera", 0, "openFrontFacingCamera ClassNotFoundException", localClassNotFoundException3);
        localObject2 = localObject3;
      }
      label640:
      return localObject2;
      label642:
      Object localObject5 = null;
      continue;
      label648:
      Field localField = null;
    }
  }
  
  private boolean setCameraDisplayOrientation(int paramInt, Camera paramCamera)
  {
    VcCamera.CameraInformation localCameraInformation = getCameraDisplayOrientation(paramInt, paramCamera);
    this.CompenSateSendAngle = getSendAngleCompensation();
    this.CompenSateRecvAngle = getRecvAngleCompensation();
    Info.facing = localCameraInformation.facing;
    Info.orientation = localCameraInformation.orientation;
    if (localCameraInformation.facing == 1) {
      paramInt = (360 - (getOrientation() + getRotation()) % 360) % 360;
    } else {
      paramInt = (getOrientation() - getRotation() + 360) % 360;
    }
    if (localCameraInformation.facing == 1) {
      paramInt = (paramInt + getPreviewAngleForFrontCamera()) % 360;
    } else {
      paramInt = (paramInt + getPreviewAngleForBackCamera()) % 360;
    }
    setDisplayOrientation(paramCamera, paramInt);
    return true;
  }
  
  private void setCameraFps(int paramInt)
  {
    Camera.Parameters localParameters2;
    try
    {
      Camera.Parameters localParameters1 = this.mCamera.getParameters();
    }
    catch (Exception localException1)
    {
      QLog.d("VcCamera", 0, "getParameters exception", localException1);
      localParameters2 = null;
    }
    if (localParameters2 == null) {
      return;
    }
    nInFPS = getPreviewFPS(paramInt, localParameters2);
    localParameters2.setPreviewFrameRate(nInFPS);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCameraFps fps = ");
    localStringBuilder.append(nInFPS);
    QLog.i("VcCamera", 0, localStringBuilder.toString());
    try
    {
      this.mCamera.setParameters(localParameters2);
      return;
    }
    catch (Exception localException2)
    {
      QLog.i("VcCamera", 0, "setParameters exception", localException2);
    }
  }
  
  private void setCameraPara(int paramInt1, int paramInt2)
  {
    if (this.mCamera == null)
    {
      QLog.d("VcCamera", 0, "openCamera camera == null");
      return;
    }
    int i;
    label592:
    StringBuilder localStringBuilder1;
    label1534:
    synchronized (Info)
    {
      if (fitSdkVersion()) {
        setCameraDisplayOrientation(this.CameraId, this.mCamera);
      } else {
        adjustDirection(this.mCamera);
      }
      Object localObject2;
      try
      {
        ??? = this.mCamera.getParameters();
      }
      catch (Exception localException1)
      {
        QLog.d("VcCamera", 0, "getParameters exception", localException1);
        localObject2 = null;
      }
      if (localObject2 == null)
      {
        QLog.d("VcCamera", 0, "getParameters parameters == null ");
        if ((paramInt1 > this.VideoChatSettings.width) && (paramInt2 > this.VideoChatSettings.height))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("save parasw");
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append("h");
          ((StringBuilder)localObject2).append(paramInt2);
          QLog.d("VcCamera", 0, ((StringBuilder)localObject2).toString());
          localObject2 = this.VideoChatSettings;
          ((CameraCaptureSettings)localObject2).width = paramInt1;
          ((CameraCaptureSettings)localObject2).height = paramInt2;
        }
        return;
      }
      try
      {
        List localList = (List)localObject2.getClass().getMethod("getSupportedPreviewFormats", new Class[0]).invoke(localObject2, (Object[])null);
        if (localList != null)
        {
          i = 0;
          if (i < localList.size())
          {
            if (!QLog.isColorLevel()) {
              break label1534;
            }
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("format: ");
            localStringBuilder2.append(localList.get(i));
            QLog.d("VcCamera", 0, localStringBuilder2.toString());
            break label1534;
          }
          if (localList.contains(Integer.valueOf(17))) {
            break label1541;
          }
          if (localList.contains(Integer.valueOf(16))) {
            break label1547;
          }
          if (localList.contains(Integer.valueOf(20)))
          {
            i = 20;
            break label592;
          }
          if (localList.contains(Integer.valueOf(842094169)))
          {
            i = 842094169;
            break label592;
          }
          if (localList.contains(Integer.valueOf(4))) {
            break label1553;
          }
          if (localList.contains(Integer.valueOf(17))) {
            break label1541;
          }
          if (localList.contains(Integer.valueOf(16))) {
            break label1547;
          }
          if (localList.contains(Integer.valueOf(3)))
          {
            i = 3;
            break label592;
          }
          if (localList.contains(Integer.valueOf(2)))
          {
            i = 2;
            break label592;
          }
          if (localList.contains(Integer.valueOf(4))) {
            break label1553;
          }
          if (localList.contains(Integer.valueOf(100)))
          {
            i = 100;
            break label592;
          }
          if (localList.contains(Integer.valueOf(101)))
          {
            i = 101;
            break label592;
          }
          if (localList.contains(Integer.valueOf(102)))
          {
            i = 102;
            break label592;
          }
          if (localList.contains(Integer.valueOf(103)))
          {
            i = 103;
            break label592;
          }
          boolean bool = localList.contains(Integer.valueOf(104));
          if (bool)
          {
            i = 104;
            break label592;
          }
        }
        i = 0;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        i = 0;
      }
      try
      {
        Object localObject3 = localObject2.getClass().getMethod("getSupportedPreviewSizes", new Class[0]);
        if (localObject3 != null)
        {
          localObject3 = (List)((Method)localObject3).invoke(localObject2, (Object[])null);
          if (localObject3 != null)
          {
            this.mFrameSizes = ((List)localObject3);
            localObject3 = getOptimalEqualPreviewSize((List)localObject3, paramInt1, paramInt2);
            if (localObject3 != null)
            {
              this.VideoChatSettings.width = ((Camera.Size)localObject3).width;
              this.VideoChatSettings.height = ((Camera.Size)localObject3).height;
            }
            else
            {
              this.VideoChatSettings.width = 640;
              this.VideoChatSettings.height = 480;
            }
          }
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
      if (((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9003"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9220"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I7000"))))
      {
        localObject4 = this.VideoChatSettings;
        ((CameraCaptureSettings)localObject4).width = 320;
        ((CameraCaptureSettings)localObject4).height = 240;
      }
      else if ((this.DEV_MANUFACTURER.equalsIgnoreCase("OPPO")) && (this.DEV_MODEL.equalsIgnoreCase("OPPO R9s")))
      {
        QLog.i("VcCamera", 0, "oppo r9s");
        if ((this.VideoChatSettings.width == 320) && (this.VideoChatSettings.height == 240))
        {
          localObject4 = this.VideoChatSettings;
          ((CameraCaptureSettings)localObject4).width = 640;
          ((CameraCaptureSettings)localObject4).height = 480;
        }
      }
      ((Camera.Parameters)localObject2).setPreviewSize(this.VideoChatSettings.width, this.VideoChatSettings.height);
      if (((Camera.Parameters)localObject2).getSupportedFocusModes().contains("continuous-video")) {
        ((Camera.Parameters)localObject2).setFocusMode("continuous-video");
      }
      if ((nInFPS > 30) || (nInFPS < 10)) {
        nInFPS = 10;
      }
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("setCameraPara user setting of fps = ");
      ((StringBuilder)localObject4).append(nInFPS);
      QLog.i("VcCamera", 0, ((StringBuilder)localObject4).toString());
      nInFPS = getPreviewFPS(nInFPS, (Camera.Parameters)localObject2);
      if ((nInFPS > 30) || (nInFPS < 10)) {
        nInFPS = 10;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("setCameraPara fps = ");
      ((StringBuilder)localObject4).append(nInFPS);
      QLog.i("VcCamera", 0, ((StringBuilder)localObject4).toString());
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("supportFormat = ");
          ((StringBuilder)localObject4).append(i);
          QLog.d("VcCamera", 0, ((StringBuilder)localObject4).toString());
        }
        ((Camera.Parameters)localObject2).setPreviewFormat(i);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("VcCamera", 0, "supportFormat = 17(default value)");
        }
        ((Camera.Parameters)localObject2).setPreviewFormat(17);
      }
      ((Camera.Parameters)localObject2).setPreviewFrameRate(nInFPS);
      ((Camera.Parameters)localObject2).set("Rotation", 180);
      try
      {
        this.mCamera.setParameters((Camera.Parameters)localObject2);
        paramInt1 = 1;
      }
      catch (Exception localException5)
      {
        localException5.printStackTrace();
        paramInt1 = 0;
      }
      Camera.Size localSize = ((Camera.Parameters)localObject2).getPreviewSize();
      paramInt2 = ((Camera.Parameters)localObject2).getPreviewFormat();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("videoFormat = ");
        ((StringBuilder)localObject2).append(paramInt2);
        QLog.d("VcCamera", 0, ((StringBuilder)localObject2).toString());
      }
      this.VideoChatSettings.width = localSize.width;
      this.VideoChatSettings.height = localSize.height;
      this.VideoChatSettings.format = paramInt2;
      if ((this.DEV_MANUFACTURER.equalsIgnoreCase("meizu")) && (this.DEV_MODEL.equalsIgnoreCase("meizu_m9"))) {
        this.VideoChatSettings.format = 18;
      } else if ((this.DEV_MANUFACTURER.equalsIgnoreCase("ZTE")) && (this.DEV_MODEL.equalsIgnoreCase("ZTE-T U880"))) {
        this.VideoChatSettings.format = 100;
      }
      if (paramInt1 == 0) {
        try
        {
          localObject2 = this.mCamera.getParameters();
          if (localObject2 != null)
          {
            this.VideoChatSettings.width = ((Camera.Parameters)localObject2).getPreviewSize().width;
            this.VideoChatSettings.height = ((Camera.Parameters)localObject2).getPreviewSize().height;
            this.VideoChatSettings.format = ((Camera.Parameters)localObject2).getPreviewFormat();
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("setCameraPara width: ");
      localStringBuilder1.append(this.VideoChatSettings.width);
      localStringBuilder1.append("height: ");
      localStringBuilder1.append(this.VideoChatSettings.height);
      localStringBuilder1.append("format: ");
      localStringBuilder1.append(this.VideoChatSettings.format);
      QLog.d("VcCamera", 0, localStringBuilder1.toString());
      return;
    }
  }
  
  private void setDisplayOrientation(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE }).invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramCamera)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "setDisplayOrientation", paramCamera);
      }
    }
  }
  
  private static ArrayList<Integer> splitInt(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new StringTokenizer(paramString, ",");
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreElements()) {
      localArrayList.add(Integer.valueOf(Integer.parseInt(paramString.nextToken())));
    }
    return localArrayList;
  }
  
  private Camera tryMotoFrontCamera()
  {
    Camera localCamera2 = this.mCamera;
    Camera localCamera1;
    if (localCamera2 != null) {
      localCamera1 = localCamera2;
    }
    try
    {
      localCamera2.release();
      localCamera1 = localCamera2;
      localCamera2 = Camera.open();
      if (localCamera2 == null) {
        return null;
      }
      localCamera1 = localCamera2;
      Camera.Parameters localParameters = (Camera.Parameters)localCamera2.getClass().getMethod("getCustomParameters", new Class[0]).invoke(localCamera2, new Object[0]);
      localCamera1 = localCamera2;
      ArrayList localArrayList = splitInt(localParameters.get("camera-sensor-values"));
      localCamera1 = localCamera2;
      Method localMethod = localCamera2.getClass().getMethod("setCustomParameters", new Class[] { localParameters.getClass() });
      if (localArrayList != null)
      {
        localCamera1 = localCamera2;
        if (localArrayList.indexOf(Integer.valueOf(1)) != -1)
        {
          localCamera1 = localCamera2;
          localParameters.set("camera-sensor", "1");
          localCamera1 = localCamera2;
          localMethod.invoke(localCamera2, new Object[] { localParameters });
        }
      }
      return localCamera2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "tryMotoFrontCamera", localException);
      }
      if (localCamera1 != null) {
        localCamera1.release();
      }
    }
    return null;
  }
  
  private Camera trySamsungFrontCamera()
  {
    Camera localCamera = this.mCamera;
    if (localCamera != null) {}
    try
    {
      localCamera.release();
      localCamera = Camera.open();
      if (localCamera == null) {
        return null;
      }
      Camera.Parameters localParameters = localCamera.getParameters();
      localParameters.set("camera-id", 2);
      localCamera.setParameters(localParameters);
      this.mCamera = localCamera;
      return localCamera;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VcCamera", 0, "trySamsungFrontCamera", localException);
      }
    }
    return null;
  }
  
  public void close()
  {
    Handler localHandler = this.mCameraHandler;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new VcCamera.5(this));
  }
  
  void closeInternal()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 0, "closeCamera begin.");
    }
    if ((this.mCamera == null) && (!isCameraOpened) && (QLog.isColorLevel())) {
      QLog.d("VcCamera", 0, "Camera not open.");
    }
    if (this.mCamera != null)
    {
      if (isCameraOpened)
      {
        if (this.mCallbackBufferAddStrategy.getIsUseBuffer()) {
          this.mCamera.setPreviewCallbackWithBuffer(null);
        } else {
          this.mCamera.setPreviewCallback(null);
        }
        this.mCamera.stopPreview();
        this.mCamera.release();
      }
      this.mCamera = null;
    }
    if (this.mUseSurfaceTexture) {
      this.mSurfaceTextureManager.uninit();
    }
    isCameraOpened = false;
    this.CUR_CAMERA = -1;
    this.LAST_CAMERA = -1;
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 0, "closeCamera end.");
    }
  }
  
  public boolean finish()
  {
    Handler localHandler = this.mCameraHandler;
    if (localHandler == null) {
      return false;
    }
    localHandler.post(new VcCamera.6(this));
    return true;
  }
  
  public Object getCamera()
  {
    if (isCameraOpened)
    {
      Camera localCamera = this.mCamera;
      if (localCamera != null) {
        return localCamera;
      }
    }
    return null;
  }
  
  public Object getCameraHandler()
  {
    return this.mCameraHandler;
  }
  
  public Object getCameraParameter()
  {
    if (isCameraOpened)
    {
      Camera localCamera = this.mCamera;
      if (localCamera != null) {
        return localCamera.getParameters();
      }
    }
    return null;
  }
  
  public int getCompenSateRecvAngle()
  {
    return this.CompenSateRecvAngle;
  }
  
  public int getCompenSateSendAngle()
  {
    return this.CompenSateSendAngle;
  }
  
  public int getOrientation()
  {
    if (Info.orientation == -1)
    {
      if (this.CUR_CAMERA == 0) {
        return 270;
      }
      if (this.CUR_CAMERA == 1) {
        return 90;
      }
    }
    return Info.orientation;
  }
  
  int getPreviewAngleForBackCamera()
  {
    return ConfigSystemImpl.GetAngleForCamera(this.mContext, false, true, (byte)0) * 90;
  }
  
  int getPreviewAngleForFrontCamera()
  {
    return 360 - ConfigSystemImpl.GetAngleForCamera(this.mContext, true, true, (byte)0) * 90;
  }
  
  int getRemoteAngleForBackCamera(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 90) {
        break label39;
      }
      if (paramInt == 180) {
        break label34;
      }
      if (paramInt == 270) {}
    }
    else
    {
      b = 0;
      break label41;
    }
    byte b = 3;
    break label41;
    label34:
    b = 2;
    break label41;
    label39:
    b = 1;
    label41:
    return ConfigSystemImpl.GetAngleForCamera(this.mContext, false, false, b) * 90;
  }
  
  int getRemoteAngleForFrontCamera(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 90) {
        break label39;
      }
      if (paramInt == 180) {
        break label34;
      }
      if (paramInt == 270) {}
    }
    else
    {
      b = 0;
      break label41;
    }
    byte b = 3;
    break label41;
    label34:
    b = 2;
    break label41;
    label39:
    b = 1;
    label41:
    return ConfigSystemImpl.GetAngleForCamera(this.mContext, true, false, b) * 90;
  }
  
  public int getRotation()
  {
    if (Info.rotation == -1) {
      return 0;
    }
    return Info.rotation;
  }
  
  public int getUserCameraAngle(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.mFrontCameraAngle;
    }
    return this.mBackCameraAngle;
  }
  
  public void initCameraSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setWebConfigCameraSetting fps = ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("width = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("height = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("VcCamera", 0, ((StringBuilder)localObject).toString());
    nInFPS = paramInt3;
    localObject = this.VideoChatSettings;
    ((CameraCaptureSettings)localObject).width = paramInt1;
    ((CameraCaptureSettings)localObject).height = paramInt2;
  }
  
  public boolean isFrontCamera()
  {
    if (this.CUR_CAMERA == -1) {
      return true;
    }
    return this.CUR_CAMERA == 0;
  }
  
  native void onCaptureFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  native void onCloseCamera();
  
  native void onFinishCamera();
  
  native void onOpenCamera(boolean paramBoolean);
  
  public void open(int paramInt)
  {
    QLog.d("VcCamera", 0, "openCamera begin.");
    if (this.mCameraThread == null)
    {
      this.mCameraThread = new HandlerThread("CAMERA");
      this.mCameraThread.start();
      this.mCameraHandler = new Handler(this.mCameraThread.getLooper());
    }
    this.mCameraHandler.post(new VcCamera.4(this, paramInt));
  }
  
  /* Error */
  public void setAfterPreviewListener(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/tencent/TMG/camera/VcCamera:afterPreviewListenerLock	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 371	com/tencent/TMG/camera/VcCamera:afterPreviewListener	Ljava/lang/Object;
    //   14: aload_2
    //   15: monitorexit
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	VcCamera
    //   0	29	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	16	19	finally
    //   20	22	19	finally
    //   2	9	24	finally
    //   22	24	24	finally
  }
  
  public void setCameraAngleFix(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.mFrontCameraAngle = (paramInt % 360);
    } else {
      this.mBackCameraAngle = (paramInt % 360);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mFrontCameraAngle");
      localStringBuilder.append(this.mFrontCameraAngle);
      localStringBuilder.append("mBackCameraAngle");
      localStringBuilder.append(this.mBackCameraAngle);
      QLog.d("VcCamera", 0, localStringBuilder.toString());
    }
  }
  
  public void setCameraParaDynamic(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCameraParaDynamic w: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" h: ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("VcCamera", 0, ((StringBuilder)localObject).toString());
    localObject = this.mCameraHandler;
    if (localObject == null)
    {
      QLog.i("VcCamera", 0, "setCameraParaDynamic mCameraHandler == null");
      localObject = this.VideoChatSettings;
      ((CameraCaptureSettings)localObject).width = paramInt1;
      ((CameraCaptureSettings)localObject).height = paramInt2;
      return;
    }
    ((Handler)localObject).post(new VcCamera.2(this, paramInt1, paramInt2));
  }
  
  public void setCameraParaDynamic(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCameraParaDynamic fps: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("needRestartPreview: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("VcCamera", 0, ((StringBuilder)localObject).toString());
    localObject = this.mCameraHandler;
    if (localObject == null)
    {
      QLog.i("VcCamera", 0, "setCameraParaDynamic mCameraHandler == null");
      nInFPS = paramInt;
      return;
    }
    ((Handler)localObject).post(new VcCamera.1(this, paramBoolean, paramInt));
  }
  
  public void setCameraParameter(Object paramObject)
  {
    this.mCameraHandler.post(new VcCamera.3(this, paramObject));
  }
  
  public void setCameraPreviewChangeCallback(Object paramObject)
  {
    Object localObject = this.cameraPreviewChangeCallbackLock;
    if (paramObject == null) {}
    try
    {
      mCameraPreviewChangeCallback = null;
      break label32;
      mCameraPreviewChangeCallback = new WeakReference((AVVideoCtrl.CameraPreviewChangeCallback)paramObject);
      label32:
      return;
    }
    finally {}
  }
  
  public void setPreviewDisplay(Object paramObject)
  {
    synchronized (this.holderLock)
    {
      mHolder = new WeakReference((SurfaceHolder)paramObject);
      return;
    }
  }
  
  public void setRotation(int paramInt)
  {
    Info.rotation = ((paramInt + this.CompenSateSendAngle) % 360);
  }
  
  public void setUseSurfaceTexture(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUseSurfaceTexture useSurfaceTexture");
    localStringBuilder.append(paramBoolean);
    QLog.i("VcCamera", 0, localStringBuilder.toString());
    this.mUseSurfaceTexture = paramBoolean;
  }
  
  public void setWebConfigFps(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setWebConfigFps fps = ");
    localStringBuilder.append(paramInt);
    QLog.i("VcCamera", 0, localStringBuilder.toString());
    nInFPS = paramInt;
  }
  
  public void switchCamera(int paramInt)
  {
    this.mCameraHandler.post(new VcCamera.SwitchCameraRunnable(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera
 * JD-Core Version:    0.7.0.1
 */