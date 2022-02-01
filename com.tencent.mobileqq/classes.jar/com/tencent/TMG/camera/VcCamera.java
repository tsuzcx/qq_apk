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
    if (paramContext == null) {
      QLog.e("VcCamera", 0, "VcCamera initial context is null");
    }
    do
    {
      return;
      this.mContext = paramContext;
      this.devDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      this.androidSysOorientationConfig = get(this.mContext, "ro.qq.orientation");
      this.mbIsTablet = PhoneStatusTools.isTablet(paramContext);
      this.SDK_VERSION = getVersion();
      this.DEV_MODEL = Build.MODEL;
      this.DEV_MANUFACTURER = Build.MANUFACTURER;
      Info.orientation = -1;
      Info.rotation = -1;
      this.screenOrientation = this.mContext.getResources().getConfiguration().orientation;
      this.mSurfaceTextureManager = new SurfaceTextureManager(this.mContext);
      this.mCallbackBufferAddStrategy = new CallbackBufferAddStrategy();
    } while (!QLog.isColorLevel());
    QLog.d("VcCamera", 0, "Device_Tag = " + this.DEV_MANUFACTURER + ": " + this.DEV_MODEL);
    QLog.d("VcCamera", 0, "Rom_Tag = " + Build.VERSION.INCREMENTAL);
    QLog.d("VcCamera", 0, "screenOrientation = " + this.screenOrientation);
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
      if (this.CUR_CAMERA == 0) {}
      for (int i = getPreviewAngleForFrontCamera() % 360;; i = getPreviewAngleForBackCamera() % 360)
      {
        localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(i) });
        return;
      }
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
    for (;;)
    {
      synchronized (this.afterPreviewListenerLock)
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
          paramArrayOfByte = localVideoFrame.data;
          paramInt1 = localVideoFrame.dataLen;
          paramInt2 = localVideoFrame.width;
          paramInt3 = localVideoFrame.height;
          paramInt5 = localVideoFrame.videoFormat;
          onCaptureFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
          return;
        }
      }
    }
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
    catch (Exception paramContext) {}
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
      if ((localField1 == null) || (localField2 == null))
      {
        paramCamera.rotation = -1;
        paramCamera.orientation = -1;
        return paramCamera;
      }
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
      switch (Integer.parseInt(((Method)localObject1).invoke(this.devDisplay, (Object[])null).toString()))
      {
      case 0: 
        paramCamera.rotation = 0;
      }
    }
    catch (Exception localException)
    {
      paramCamera.rotation = 0;
      return paramCamera;
    }
    paramCamera.rotation = 90;
    return paramCamera;
    paramCamera.rotation = 180;
    return paramCamera;
    paramCamera.rotation = 270;
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
        QLog.d("VcCamera", 0, "previewsize ,w= " + ((Camera.Size)localObject2).width + ",h=" + ((Camera.Size)localObject2).height);
      }
      this.isPreviewSizePrint = true;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (!VcSystemInfo.isNormalSharp()) {
      if (paramInt1 == 192)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt2 == 144) {}
      }
      else
      {
        j = 144;
        i = 192;
      }
    }
    Object localObject2 = paramList.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Camera.Size)((Iterator)localObject2).next();
        if ((((Camera.Size)localObject1).width == i) && (((Camera.Size)localObject1).height == j))
        {
          paramList = (List<Camera.Size>)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("VcCamera", 0, "previewsize ,w= " + i + ",h=" + j);
            paramList = (List<Camera.Size>)localObject1;
          }
        }
      }
    }
    do
    {
      return paramList;
      if ((VcSystemInfo.isNormalSharp()) || ((i == 320) && (j == 240))) {
        break label523;
      }
      localObject2 = paramList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (Camera.Size)((Iterator)localObject2).next();
      } while ((((Camera.Size)localObject1).width != 320) || (((Camera.Size)localObject1).height != 240));
      paramList = (List<Camera.Size>)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("VcCamera", 0, "previewsize 2, w= " + 320 + ",h=" + 240);
    return localObject1;
    paramInt1 = 240;
    for (paramInt2 = 320;; paramInt2 = i)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt2 == 320)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt1 == 240)
        {
          localObject2 = paramList.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (Camera.Size)((Iterator)localObject2).next();
              if ((((Camera.Size)localObject1).width == 640) && (((Camera.Size)localObject1).height == 480))
              {
                paramList = (List<Camera.Size>)localObject1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("VcCamera", 0, "previewsize ,w= " + 640 + ",h=" + 480);
                return localObject1;
              }
            }
          }
          j = 480;
          i = 640;
        }
      }
      if (0 == 0) {
        return getOptimalPreviewSize(paramList, i, j);
      }
      return null;
      label523:
      paramInt1 = j;
    }
  }
  
  private Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new CameraSizeComparator());
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Camera.Size localSize;
    while (localIterator.hasNext())
    {
      localSize = (Camera.Size)localIterator.next();
      if (((localSize.width >= paramInt1) && (localSize.height > paramInt2)) || ((localSize.width > paramInt1) && (localSize.height >= paramInt2)))
      {
        Object localObject = paramList;
        if (paramList == null)
        {
          QLog.i("VcCamera", 0, "better size width: " + localSize.width + "height: " + localSize.height);
          localObject = localSize;
        }
        paramList = (List<Camera.Size>)localObject;
        if (localSize.width * paramInt2 == localSize.height * paramInt1)
        {
          QLog.i("VcCamera", 0, "best size width: " + localSize.width + "height: " + localSize.height + "w*h1: " + localSize.width * paramInt2 + "w*h2: " + localSize.height * paramInt1);
          paramList = (List<Camera.Size>)localObject;
        }
      }
    }
    for (;;)
    {
      if (localSize != null) {
        return localSize;
      }
      if (paramList == null) {
        break;
      }
      return paramList;
      localSize = null;
    }
  }
  
  private int getPreviewFPS(int paramInt, Camera.Parameters paramParameters)
  {
    Integer localInteger;
    try
    {
      localObject = paramParameters.getClass().getMethod("getSupportedPreviewFrameRates", new Class[0]);
      i = paramInt;
      if (localObject != null)
      {
        paramParameters = (List)((Method)localObject).invoke(paramParameters, (Object[])null);
        i = paramInt;
        if (paramParameters != null)
        {
          if (this.isPreviewFpsPrint) {
            break label156;
          }
          localObject = paramParameters.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localInteger = (Integer)((Iterator)localObject).next();
            QLog.i("VcCamera", 0, "supported fps = " + localInteger);
          }
        }
      }
      QLog.i("VcCamera", 0, "getPreviewFPS fps = " + i);
    }
    catch (Exception paramParameters)
    {
      QLog.e("VcCamera", 0, "getSupportedPreviewFrameRates error = ", paramParameters);
      i = paramInt;
    }
    return i;
    this.isPreviewFpsPrint = true;
    label156:
    int i = 10;
    Object localObject = paramParameters.iterator();
    int j = 0;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject).next();
        if ((localInteger.intValue() <= paramInt) && (localInteger.intValue() >= i))
        {
          j = localInteger.intValue();
          i = 1;
          break label334;
        }
      }
      else
      {
        if (j == 0)
        {
          QLog.i("VcCamera", 0, "not find valid fps = targetFPS");
          paramParameters = paramParameters.iterator();
          i = paramInt;
          j = i;
          if (paramParameters.hasNext())
          {
            localObject = (Integer)paramParameters.next();
            if (((Integer)localObject).intValue() >= paramInt)
            {
              k = ((Integer)localObject).intValue();
              if (i == paramInt) {
                j = k;
              }
            }
            for (;;)
            {
              i = j;
              break;
              j = k;
              if (k > i) {
                j = i;
              }
            }
          }
        }
        else
        {
          j = i;
        }
        i = j;
        break;
      }
      int k = j;
      j = i;
      i = k;
      label334:
      k = j;
      j = i;
      i = k;
    }
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
      if (this.mCamera != null) {
        this.mCamera.release();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "openBackCamera exception" + localException.getStackTrace());
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
  
  /* Error */
  private Camera openFrontFacingCamera()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 13
    //   21: aconst_null
    //   22: astore 14
    //   24: aconst_null
    //   25: astore 7
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 110	com/tencent/TMG/camera/VcCamera:CameraId	I
    //   32: ldc_w 274
    //   35: invokestatic 280	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore 15
    //   40: aload_0
    //   41: getfield 106	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   44: ifne +10 -> 54
    //   47: aload_0
    //   48: invokestatic 330	com/tencent/TMG/camera/VcCamera:GetNumberOfCamera	()I
    //   51: putfield 106	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   54: aload 4
    //   56: astore_3
    //   57: aload_0
    //   58: getfield 106	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   61: iconst_1
    //   62: if_icmplt +257 -> 319
    //   65: ldc_w 427
    //   68: invokestatic 280	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   71: astore 17
    //   73: aload 17
    //   75: ifnull +567 -> 642
    //   78: aload 17
    //   80: invokevirtual 431	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   83: astore 5
    //   85: aload 5
    //   87: ifnull +549 -> 636
    //   90: aload 5
    //   92: invokevirtual 352	java/lang/Object:getClass	()Ljava/lang/Class;
    //   95: ldc_w 433
    //   98: invokevirtual 437	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: astore 6
    //   103: aload 15
    //   105: ldc_w 440
    //   108: iconst_2
    //   109: anewarray 276	java/lang/Class
    //   112: dup
    //   113: iconst_0
    //   114: getstatic 358	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload 17
    //   122: aastore
    //   123: invokevirtual 286	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   126: astore 16
    //   128: aload 4
    //   130: astore_3
    //   131: aload 16
    //   133: ifnull +186 -> 319
    //   136: aload 4
    //   138: astore_3
    //   139: aload 17
    //   141: ifnull +178 -> 319
    //   144: aload 4
    //   146: astore_3
    //   147: aload 6
    //   149: ifnull +170 -> 319
    //   152: iconst_0
    //   153: istore_1
    //   154: aconst_null
    //   155: astore_3
    //   156: iload_1
    //   157: aload_0
    //   158: getfield 106	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   161: if_icmpge +473 -> 634
    //   164: aload 16
    //   166: aconst_null
    //   167: iconst_2
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: iload_1
    //   174: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload 5
    //   182: aastore
    //   183: invokevirtual 294	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: aload 6
    //   189: aload 5
    //   191: invokevirtual 446	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   194: istore_2
    //   195: iload_2
    //   196: iconst_1
    //   197: if_icmpne +431 -> 628
    //   200: aload 15
    //   202: ldc_w 599
    //   205: iconst_1
    //   206: anewarray 276	java/lang/Class
    //   209: dup
    //   210: iconst_0
    //   211: getstatic 358	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   214: aastore
    //   215: invokevirtual 286	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   218: astore 4
    //   220: aload 4
    //   222: ifnull +406 -> 628
    //   225: aload 4
    //   227: aconst_null
    //   228: iconst_1
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: iload_1
    //   235: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: invokevirtual 294	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   242: checkcast 562	android/hardware/Camera
    //   245: astore 4
    //   247: aload_0
    //   248: iload_1
    //   249: putfield 110	com/tencent/TMG/camera/VcCamera:CameraId	I
    //   252: iload_1
    //   253: iconst_1
    //   254: iadd
    //   255: istore_1
    //   256: aload 4
    //   258: astore_3
    //   259: goto -103 -> 156
    //   262: astore_3
    //   263: aload_0
    //   264: iconst_0
    //   265: putfield 110	com/tencent/TMG/camera/VcCamera:CameraId	I
    //   268: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   271: ifeq +13 -> 284
    //   274: ldc 20
    //   276: iconst_0
    //   277: ldc_w 600
    //   280: aload_3
    //   281: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   284: aconst_null
    //   285: astore 4
    //   287: goto -35 -> 252
    //   290: astore 5
    //   292: aload 7
    //   294: astore 4
    //   296: aload 4
    //   298: astore_3
    //   299: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   302: ifeq +17 -> 319
    //   305: ldc 20
    //   307: iconst_0
    //   308: ldc_w 602
    //   311: aload 5
    //   313: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   316: aload 4
    //   318: astore_3
    //   319: aload_3
    //   320: areturn
    //   321: astore 5
    //   323: aload 8
    //   325: astore 4
    //   327: aload 4
    //   329: astore_3
    //   330: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   333: ifeq -14 -> 319
    //   336: ldc 20
    //   338: iconst_0
    //   339: ldc_w 604
    //   342: aload 5
    //   344: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   347: aload 4
    //   349: areturn
    //   350: astore 5
    //   352: aload 9
    //   354: astore 4
    //   356: aload 4
    //   358: astore_3
    //   359: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   362: ifeq -43 -> 319
    //   365: ldc 20
    //   367: iconst_0
    //   368: ldc_w 606
    //   371: aload 5
    //   373: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   376: aload 4
    //   378: areturn
    //   379: astore 5
    //   381: aload 10
    //   383: astore 4
    //   385: aload 4
    //   387: astore_3
    //   388: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   391: ifeq -72 -> 319
    //   394: ldc 20
    //   396: iconst_0
    //   397: ldc_w 608
    //   400: aload 5
    //   402: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   405: aload 4
    //   407: areturn
    //   408: astore 5
    //   410: aload 11
    //   412: astore 4
    //   414: aload 4
    //   416: astore_3
    //   417: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   420: ifeq -101 -> 319
    //   423: ldc 20
    //   425: iconst_0
    //   426: ldc_w 610
    //   429: aload 5
    //   431: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   434: aload 4
    //   436: areturn
    //   437: astore 5
    //   439: aload 12
    //   441: astore 4
    //   443: aload 4
    //   445: astore_3
    //   446: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   449: ifeq -130 -> 319
    //   452: ldc 20
    //   454: iconst_0
    //   455: ldc_w 612
    //   458: aload 5
    //   460: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   463: aload 4
    //   465: areturn
    //   466: astore 5
    //   468: aload 13
    //   470: astore 4
    //   472: aload 4
    //   474: astore_3
    //   475: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   478: ifeq -159 -> 319
    //   481: ldc 20
    //   483: iconst_0
    //   484: ldc_w 614
    //   487: aload 5
    //   489: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   492: aload 4
    //   494: areturn
    //   495: astore 5
    //   497: aload 14
    //   499: astore 4
    //   501: aload 4
    //   503: astore_3
    //   504: invokestatic 239	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   507: ifeq -188 -> 319
    //   510: ldc 20
    //   512: iconst_0
    //   513: ldc_w 600
    //   516: aload 5
    //   518: invokestatic 548	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   521: aload 4
    //   523: areturn
    //   524: astore 5
    //   526: aload_3
    //   527: astore 4
    //   529: goto -28 -> 501
    //   532: astore 5
    //   534: goto -33 -> 501
    //   537: astore 5
    //   539: aload_3
    //   540: astore 4
    //   542: goto -70 -> 472
    //   545: astore 5
    //   547: goto -75 -> 472
    //   550: astore 5
    //   552: aload_3
    //   553: astore 4
    //   555: goto -112 -> 443
    //   558: astore 5
    //   560: goto -117 -> 443
    //   563: astore 5
    //   565: aload_3
    //   566: astore 4
    //   568: goto -154 -> 414
    //   571: astore 5
    //   573: goto -159 -> 414
    //   576: astore 5
    //   578: aload_3
    //   579: astore 4
    //   581: goto -196 -> 385
    //   584: astore 5
    //   586: goto -201 -> 385
    //   589: astore 5
    //   591: aload_3
    //   592: astore 4
    //   594: goto -238 -> 356
    //   597: astore 5
    //   599: goto -243 -> 356
    //   602: astore 5
    //   604: aload_3
    //   605: astore 4
    //   607: goto -280 -> 327
    //   610: astore 5
    //   612: goto -285 -> 327
    //   615: astore 5
    //   617: aload_3
    //   618: astore 4
    //   620: goto -324 -> 296
    //   623: astore 5
    //   625: goto -329 -> 296
    //   628: aload_3
    //   629: astore 4
    //   631: goto -379 -> 252
    //   634: aload_3
    //   635: areturn
    //   636: aconst_null
    //   637: astore 6
    //   639: goto -536 -> 103
    //   642: aconst_null
    //   643: astore 5
    //   645: goto -560 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	VcCamera
    //   153	103	1	i	int
    //   194	4	2	j	int
    //   56	203	3	localObject1	Object
    //   262	19	3	localRuntimeException	java.lang.RuntimeException
    //   298	337	3	localObject2	Object
    //   1	629	4	localObject3	Object
    //   83	107	5	localObject4	Object
    //   290	22	5	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   321	22	5	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   350	22	5	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   379	22	5	localIllegalAccessException1	java.lang.IllegalAccessException
    //   408	22	5	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   437	22	5	localInstantiationException1	java.lang.InstantiationException
    //   466	22	5	localSecurityException1	java.lang.SecurityException
    //   495	22	5	localException1	Exception
    //   524	1	5	localException2	Exception
    //   532	1	5	localException3	Exception
    //   537	1	5	localSecurityException2	java.lang.SecurityException
    //   545	1	5	localSecurityException3	java.lang.SecurityException
    //   550	1	5	localInstantiationException2	java.lang.InstantiationException
    //   558	1	5	localInstantiationException3	java.lang.InstantiationException
    //   563	1	5	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   571	1	5	localInvocationTargetException3	java.lang.reflect.InvocationTargetException
    //   576	1	5	localIllegalAccessException2	java.lang.IllegalAccessException
    //   584	1	5	localIllegalAccessException3	java.lang.IllegalAccessException
    //   589	1	5	localNoSuchFieldException2	java.lang.NoSuchFieldException
    //   597	1	5	localNoSuchFieldException3	java.lang.NoSuchFieldException
    //   602	1	5	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   610	1	5	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   615	1	5	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   623	1	5	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   643	1	5	localObject5	Object
    //   101	537	6	localField	Field
    //   25	268	7	localObject6	Object
    //   4	320	8	localObject7	Object
    //   7	346	9	localObject8	Object
    //   10	372	10	localObject9	Object
    //   13	398	11	localObject10	Object
    //   16	424	12	localObject11	Object
    //   19	450	13	localObject12	Object
    //   22	476	14	localObject13	Object
    //   38	163	15	localClass1	Class
    //   126	39	16	localMethod	Method
    //   71	69	17	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   200	220	262	java/lang/RuntimeException
    //   225	247	262	java/lang/RuntimeException
    //   247	252	262	java/lang/RuntimeException
    //   32	54	290	java/lang/ClassNotFoundException
    //   57	73	290	java/lang/ClassNotFoundException
    //   78	85	290	java/lang/ClassNotFoundException
    //   90	103	290	java/lang/ClassNotFoundException
    //   103	128	290	java/lang/ClassNotFoundException
    //   263	284	290	java/lang/ClassNotFoundException
    //   32	54	321	java/lang/NoSuchMethodException
    //   57	73	321	java/lang/NoSuchMethodException
    //   78	85	321	java/lang/NoSuchMethodException
    //   90	103	321	java/lang/NoSuchMethodException
    //   103	128	321	java/lang/NoSuchMethodException
    //   263	284	321	java/lang/NoSuchMethodException
    //   32	54	350	java/lang/NoSuchFieldException
    //   57	73	350	java/lang/NoSuchFieldException
    //   78	85	350	java/lang/NoSuchFieldException
    //   90	103	350	java/lang/NoSuchFieldException
    //   103	128	350	java/lang/NoSuchFieldException
    //   263	284	350	java/lang/NoSuchFieldException
    //   32	54	379	java/lang/IllegalAccessException
    //   57	73	379	java/lang/IllegalAccessException
    //   78	85	379	java/lang/IllegalAccessException
    //   90	103	379	java/lang/IllegalAccessException
    //   103	128	379	java/lang/IllegalAccessException
    //   263	284	379	java/lang/IllegalAccessException
    //   32	54	408	java/lang/reflect/InvocationTargetException
    //   57	73	408	java/lang/reflect/InvocationTargetException
    //   78	85	408	java/lang/reflect/InvocationTargetException
    //   90	103	408	java/lang/reflect/InvocationTargetException
    //   103	128	408	java/lang/reflect/InvocationTargetException
    //   263	284	408	java/lang/reflect/InvocationTargetException
    //   32	54	437	java/lang/InstantiationException
    //   57	73	437	java/lang/InstantiationException
    //   78	85	437	java/lang/InstantiationException
    //   90	103	437	java/lang/InstantiationException
    //   103	128	437	java/lang/InstantiationException
    //   263	284	437	java/lang/InstantiationException
    //   32	54	466	java/lang/SecurityException
    //   57	73	466	java/lang/SecurityException
    //   78	85	466	java/lang/SecurityException
    //   90	103	466	java/lang/SecurityException
    //   103	128	466	java/lang/SecurityException
    //   263	284	466	java/lang/SecurityException
    //   32	54	495	java/lang/Exception
    //   57	73	495	java/lang/Exception
    //   78	85	495	java/lang/Exception
    //   90	103	495	java/lang/Exception
    //   103	128	495	java/lang/Exception
    //   263	284	495	java/lang/Exception
    //   156	195	524	java/lang/Exception
    //   200	220	524	java/lang/Exception
    //   225	247	524	java/lang/Exception
    //   247	252	532	java/lang/Exception
    //   156	195	537	java/lang/SecurityException
    //   200	220	537	java/lang/SecurityException
    //   225	247	537	java/lang/SecurityException
    //   247	252	545	java/lang/SecurityException
    //   156	195	550	java/lang/InstantiationException
    //   200	220	550	java/lang/InstantiationException
    //   225	247	550	java/lang/InstantiationException
    //   247	252	558	java/lang/InstantiationException
    //   156	195	563	java/lang/reflect/InvocationTargetException
    //   200	220	563	java/lang/reflect/InvocationTargetException
    //   225	247	563	java/lang/reflect/InvocationTargetException
    //   247	252	571	java/lang/reflect/InvocationTargetException
    //   156	195	576	java/lang/IllegalAccessException
    //   200	220	576	java/lang/IllegalAccessException
    //   225	247	576	java/lang/IllegalAccessException
    //   247	252	584	java/lang/IllegalAccessException
    //   156	195	589	java/lang/NoSuchFieldException
    //   200	220	589	java/lang/NoSuchFieldException
    //   225	247	589	java/lang/NoSuchFieldException
    //   247	252	597	java/lang/NoSuchFieldException
    //   156	195	602	java/lang/NoSuchMethodException
    //   200	220	602	java/lang/NoSuchMethodException
    //   225	247	602	java/lang/NoSuchMethodException
    //   247	252	610	java/lang/NoSuchMethodException
    //   156	195	615	java/lang/ClassNotFoundException
    //   200	220	615	java/lang/ClassNotFoundException
    //   225	247	615	java/lang/ClassNotFoundException
    //   247	252	623	java/lang/ClassNotFoundException
  }
  
  private boolean setCameraDisplayOrientation(int paramInt, Camera paramCamera)
  {
    VcCamera.CameraInformation localCameraInformation = getCameraDisplayOrientation(paramInt, paramCamera);
    this.CompenSateSendAngle = getSendAngleCompensation();
    this.CompenSateRecvAngle = getRecvAngleCompensation();
    Info.facing = localCameraInformation.facing;
    Info.orientation = localCameraInformation.orientation;
    if (localCameraInformation.facing == 1)
    {
      paramInt = (360 - (getOrientation() + getRotation()) % 360) % 360;
      if (localCameraInformation.facing != 1) {
        break label121;
      }
    }
    label121:
    for (paramInt = (paramInt + getPreviewAngleForFrontCamera()) % 360;; paramInt = (paramInt + getPreviewAngleForBackCamera()) % 360)
    {
      setDisplayOrientation(paramCamera, paramInt);
      return true;
      paramInt = (getOrientation() - getRotation() + 360) % 360;
      break;
    }
  }
  
  private void setCameraFps(int paramInt)
  {
    try
    {
      Camera.Parameters localParameters1 = this.mCamera.getParameters();
      if (localParameters1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Camera.Parameters localParameters2;
      for (;;)
      {
        QLog.d("VcCamera", 0, "getParameters exception", localException1);
        localParameters2 = null;
      }
      nInFPS = getPreviewFPS(paramInt, localParameters2);
      localParameters2.setPreviewFrameRate(nInFPS);
      QLog.i("VcCamera", 0, "setCameraFps fps = " + nInFPS);
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
  }
  
  private void setCameraPara(int paramInt1, int paramInt2)
  {
    if (this.mCamera == null) {
      QLog.d("VcCamera", 0, "openCamera camera == null");
    }
    for (;;)
    {
      return;
      label45:
      synchronized (Info)
      {
        if (fitSdkVersion()) {
          setCameraDisplayOrientation(this.CameraId, this.mCamera);
        }
      }
      try
      {
        ??? = this.mCamera.getParameters();
        if (??? == null)
        {
          QLog.d("VcCamera", 0, "getParameters parameters == null ");
          if ((paramInt1 <= this.VideoChatSettings.width) || (paramInt2 <= this.VideoChatSettings.height)) {
            continue;
          }
          QLog.d("VcCamera", 0, "save parasw" + paramInt1 + "h" + paramInt2);
          this.VideoChatSettings.width = paramInt1;
          this.VideoChatSettings.height = paramInt2;
          return;
          adjustDirection(this.mCamera);
          break label45;
          localObject3 = finally;
          throw localObject3;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          QLog.d("VcCamera", 0, "getParameters exception", localException1);
          localObject2 = null;
        }
      }
    }
    try
    {
      localObject4 = (List)localObject2.getClass().getMethod("getSupportedPreviewFormats", new Class[0]).invoke(localObject2, (Object[])null);
      if (localObject4 == null) {
        break label1449;
      }
      i = 0;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        try
        {
          localObject4 = localObject2.getClass().getMethod("getSupportedPreviewSizes", new Class[0]);
          if (localObject4 != null)
          {
            localObject4 = (List)((Method)localObject4).invoke(localObject2, (Object[])null);
            if (localObject4 != null)
            {
              this.mFrameSizes = ((List)localObject4);
              localObject4 = getOptimalEqualPreviewSize((List)localObject4, paramInt1, paramInt2);
              if (localObject4 == null) {
                continue;
              }
              this.VideoChatSettings.width = ((Camera.Size)localObject4).width;
              this.VideoChatSettings.height = ((Camera.Size)localObject4).height;
            }
          }
          if (((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9003"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9220"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I7000"))))
          {
            this.VideoChatSettings.width = 320;
            this.VideoChatSettings.height = 240;
            ((Camera.Parameters)localObject2).setPreviewSize(this.VideoChatSettings.width, this.VideoChatSettings.height);
            if (((Camera.Parameters)localObject2).getSupportedFocusModes().contains("continuous-video")) {
              ((Camera.Parameters)localObject2).setFocusMode("continuous-video");
            }
            if ((nInFPS > 30) || (nInFPS < 10)) {
              nInFPS = 10;
            }
            QLog.i("VcCamera", 0, "setCameraPara user setting of fps = " + nInFPS);
            nInFPS = getPreviewFPS(nInFPS, (Camera.Parameters)localObject2);
            if ((nInFPS > 30) || (nInFPS < 10)) {
              nInFPS = 10;
            }
            QLog.i("VcCamera", 0, "setCameraPara fps = " + nInFPS);
            if (i == 0) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VcCamera", 0, "supportFormat = " + i);
            }
            ((Camera.Parameters)localObject2).setPreviewFormat(i);
            ((Camera.Parameters)localObject2).setPreviewFrameRate(nInFPS);
            ((Camera.Parameters)localObject2).set("Rotation", 180);
            paramInt1 = 1;
          }
        }
        catch (Exception localException4)
        {
          try
          {
            this.mCamera.setParameters((Camera.Parameters)localObject2);
            Object localObject4 = ((Camera.Parameters)localObject2).getPreviewSize();
            paramInt2 = ((Camera.Parameters)localObject2).getPreviewFormat();
            if (QLog.isColorLevel()) {
              QLog.d("VcCamera", 0, "videoFormat = " + paramInt2);
            }
            this.VideoChatSettings.width = ((Camera.Size)localObject4).width;
            this.VideoChatSettings.height = ((Camera.Size)localObject4).height;
            this.VideoChatSettings.format = paramInt2;
            if ((this.DEV_MANUFACTURER.equalsIgnoreCase("meizu")) && (this.DEV_MODEL.equalsIgnoreCase("meizu_m9")))
            {
              this.VideoChatSettings.format = 18;
              if (paramInt1 != 0) {}
            }
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
              continue;
            }
            QLog.d("VcCamera", 0, "setCameraPara width: " + this.VideoChatSettings.width + "height: " + this.VideoChatSettings.height + "format: " + this.VideoChatSettings.format);
            return;
            if (((List)localObject4).contains(Integer.valueOf(16)))
            {
              i = 16;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(20)))
            {
              i = 20;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(842094169)))
            {
              i = 842094169;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(4)))
            {
              i = 4;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(17)))
            {
              i = 17;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(16)))
            {
              i = 16;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(3)))
            {
              i = 3;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(2)))
            {
              i = 2;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(4)))
            {
              i = 4;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(100)))
            {
              i = 100;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(101)))
            {
              i = 101;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(102)))
            {
              i = 102;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(103)))
            {
              i = 103;
              continue;
            }
            boolean bool = ((List)localObject4).contains(Integer.valueOf(104));
            if (bool)
            {
              i = 104;
              continue;
              localException3 = localException3;
              localException3.printStackTrace();
              i = 0;
              continue;
              this.VideoChatSettings.width = 640;
              this.VideoChatSettings.height = 480;
              continue;
              localException4 = localException4;
              localException4.printStackTrace();
              continue;
              if ((!this.DEV_MANUFACTURER.equalsIgnoreCase("OPPO")) || (!this.DEV_MODEL.equalsIgnoreCase("OPPO R9s"))) {
                continue;
              }
              QLog.i("VcCamera", 0, "oppo r9s");
              if ((this.VideoChatSettings.width != 320) || (this.VideoChatSettings.height != 240)) {
                continue;
              }
              this.VideoChatSettings.width = 640;
              this.VideoChatSettings.height = 480;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("VcCamera", 0, "supportFormat = 17(default value)");
              }
              ((Camera.Parameters)localObject2).setPreviewFormat(17);
            }
          }
          catch (Exception localException5)
          {
            localException5.printStackTrace();
            paramInt1 = 0;
            continue;
            if ((!this.DEV_MANUFACTURER.equalsIgnoreCase("ZTE")) || (!this.DEV_MODEL.equalsIgnoreCase("ZTE-T U880"))) {
              continue;
            }
            this.VideoChatSettings.format = 100;
            continue;
          }
        }
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < ((List)localObject4).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "format: " + ((List)localObject4).get(i));
      }
    }
    else
    {
      bool = ((List)localObject4).contains(Integer.valueOf(17));
      if (bool) {
        i = 17;
      }
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
      while (!QLog.isColorLevel()) {}
      QLog.d("VcCamera", 0, "setDisplayOrientation", paramCamera);
    }
  }
  
  private static ArrayList<Integer> splitInt(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (!localStringTokenizer.hasMoreElements()) {
        break;
      }
      localArrayList.add(Integer.valueOf(Integer.parseInt(localStringTokenizer.nextToken())));
    }
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
          return localCamera2;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "tryMotoFrontCamera", localException);
      }
      if (localCamera1 != null) {
        localCamera1.release();
      }
      return null;
    }
    return localException;
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
    if (this.mCameraHandler == null) {
      return;
    }
    this.mCameraHandler.post(new VcCamera.5(this));
  }
  
  void closeInternal()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 0, "closeCamera begin.");
    }
    if ((this.mCamera == null) && (!isCameraOpened) && (QLog.isColorLevel())) {
      QLog.d("VcCamera", 0, "Camera not open.");
    }
    if (this.mCamera != null) {
      if (isCameraOpened)
      {
        if (!this.mCallbackBufferAddStrategy.getIsUseBuffer()) {
          break label137;
        }
        this.mCamera.setPreviewCallbackWithBuffer(null);
      }
    }
    for (;;)
    {
      this.mCamera.stopPreview();
      this.mCamera.release();
      this.mCamera = null;
      if (this.mUseSurfaceTexture) {
        this.mSurfaceTextureManager.uninit();
      }
      isCameraOpened = false;
      this.CUR_CAMERA = -1;
      this.LAST_CAMERA = -1;
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "closeCamera end.");
      }
      return;
      label137:
      this.mCamera.setPreviewCallback(null);
    }
  }
  
  public boolean finish()
  {
    if (this.mCameraHandler == null) {
      return false;
    }
    this.mCameraHandler.post(new VcCamera.6(this));
    return true;
  }
  
  public Object getCamera()
  {
    if ((!isCameraOpened) || (this.mCamera == null)) {
      return null;
    }
    return this.mCamera;
  }
  
  public Object getCameraHandler()
  {
    return this.mCameraHandler;
  }
  
  public Object getCameraParameter()
  {
    if ((!isCameraOpened) || (this.mCamera == null)) {
      return null;
    }
    return this.mCamera.getParameters();
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
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    for (;;)
    {
      return ConfigSystemImpl.GetAngleForCamera(this.mContext, false, false, b) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
  }
  
  int getRemoteAngleForFrontCamera(int paramInt)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    for (;;)
    {
      return ConfigSystemImpl.GetAngleForCamera(this.mContext, true, false, b) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
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
    QLog.i("VcCamera", 0, "setWebConfigCameraSetting fps = " + paramInt3 + "width = " + paramInt1 + "height = " + paramInt2);
    nInFPS = paramInt3;
    this.VideoChatSettings.width = paramInt1;
    this.VideoChatSettings.height = paramInt2;
  }
  
  public boolean isFrontCamera()
  {
    if (this.CUR_CAMERA == -1) {}
    while (this.CUR_CAMERA == 0) {
      return true;
    }
    return false;
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
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "mFrontCameraAngle" + this.mFrontCameraAngle + "mBackCameraAngle" + this.mBackCameraAngle);
      }
      return;
      this.mBackCameraAngle = (paramInt % 360);
    }
  }
  
  public void setCameraParaDynamic(int paramInt1, int paramInt2)
  {
    QLog.d("VcCamera", 0, "setCameraParaDynamic w: " + paramInt1 + " h: " + paramInt2);
    if (this.mCameraHandler == null)
    {
      QLog.i("VcCamera", 0, "setCameraParaDynamic mCameraHandler == null");
      this.VideoChatSettings.width = paramInt1;
      this.VideoChatSettings.height = paramInt2;
      return;
    }
    this.mCameraHandler.post(new VcCamera.2(this, paramInt1, paramInt2));
  }
  
  public void setCameraParaDynamic(int paramInt, boolean paramBoolean)
  {
    QLog.d("VcCamera", 0, "setCameraParaDynamic fps: " + paramInt + "needRestartPreview: " + paramBoolean);
    if (this.mCameraHandler == null)
    {
      QLog.i("VcCamera", 0, "setCameraParaDynamic mCameraHandler == null");
      nInFPS = paramInt;
      return;
    }
    this.mCameraHandler.post(new VcCamera.1(this, paramBoolean, paramInt));
  }
  
  public void setCameraParameter(Object paramObject)
  {
    this.mCameraHandler.post(new VcCamera.3(this, paramObject));
  }
  
  public void setCameraPreviewChangeCallback(Object paramObject)
  {
    localObject = this.cameraPreviewChangeCallbackLock;
    if (paramObject == null) {}
    for (;;)
    {
      try
      {
        mCameraPreviewChangeCallback = null;
        return;
      }
      finally {}
      mCameraPreviewChangeCallback = new WeakReference((AVVideoCtrl.CameraPreviewChangeCallback)paramObject);
    }
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
    Info.rotation = ((this.CompenSateSendAngle + paramInt) % 360);
  }
  
  public void setUseSurfaceTexture(boolean paramBoolean)
  {
    QLog.i("VcCamera", 0, "setUseSurfaceTexture useSurfaceTexture" + paramBoolean);
    this.mUseSurfaceTexture = paramBoolean;
  }
  
  public void setWebConfigFps(int paramInt)
  {
    QLog.i("VcCamera", 0, "setWebConfigFps fps = " + paramInt);
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