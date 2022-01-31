package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.AVLog;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import jgq;
import jgr;

public class AndroidCamera
{
  public static int a;
  static jgr jdField_a_of_type_Jgr = new jgr();
  public static boolean a;
  static int jdField_b_of_type_Int = 15000;
  private static boolean jdField_f_of_type_Boolean;
  public static int k = 640;
  public static int l = 480;
  public static int m = 17;
  public Context a;
  private Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = new jgq(this);
  public Camera a;
  Display jdField_a_of_type_AndroidViewDisplay;
  public AndroidCamera.CameraPreviewCallback a;
  String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  public int c;
  public boolean c;
  int d;
  public boolean d;
  int e;
  public boolean e;
  int jdField_f_of_type_Int;
  int g = 0;
  int h = 0;
  public int i = 0;
  public int j = 0;
  
  public AndroidCamera(Context paramContext)
  {
    this.jdField_a_of_type_AndroidHardwareCamera = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_c_of_type_Boolean = PhoneStatusTools.f(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_Boolean = PhoneStatusTools.c();
    this.jdField_e_of_type_Int = DeviceInfoUtil.a();
    this.jdField_a_of_type_JavaLangString = Build.MODEL;
    this.jdField_b_of_type_JavaLangString = Build.MANUFACTURER;
    jdField_a_of_type_Jgr.jdField_b_of_type_Int = -1;
    jdField_a_of_type_Jgr.jdField_c_of_type_Int = -1;
    AVLog.c("AndroidCamera", "Device_Tag = " + this.jdField_b_of_type_JavaLangString + ": " + this.jdField_a_of_type_JavaLangString);
    AVLog.c("AndroidCamera", "Rom_Tag = " + Build.VERSION.INCREMENTAL);
  }
  
  private int a(int paramInt)
  {
    paramInt = ImageFormat.getBitsPerPixel(paramInt);
    float f1 = paramInt * 1.0F / 8.0F;
    int n = (int)(l * k * f1);
    if (QLog.isColorLevel()) {
      QLog.i("AndroidCamera", 2, "startPreview getPreviewBufferSize:bitpixel=" + paramInt + " byteNum=" + f1 + " bufSize=" + n);
    }
    return n;
  }
  
  private int a(Camera.Parameters paramParameters)
  {
    for (;;)
    {
      try
      {
        localList = (List)paramParameters.getClass().getMethod("getSupportedPreviewFormats", new Class[0]).invoke(paramParameters, (Object[])null);
        if (localList == null) {
          break label448;
        }
        n = 0;
        if (n < localList.size())
        {
          AVLog.c("AndroidCamera", "format: " + localList.get(n));
          n += 1;
          continue;
        }
        bool = localList.contains(Integer.valueOf(17));
        if (!bool) {
          continue;
        }
        n = 17;
      }
      catch (Exception localException)
      {
        List localList;
        boolean bool;
        n = 0;
        continue;
        AVLog.c("AndroidCamera", "supportFormat = 17(default value)");
        paramParameters.setPreviewFormat(17);
        return 17;
      }
      if (n != 0)
      {
        AVLog.c("AndroidCamera", "supportFormat = " + n);
        paramParameters.setPreviewFormat(n);
        return n;
        if (localList.contains(Integer.valueOf(16)))
        {
          n = 16;
          continue;
        }
        if (localList.contains(Integer.valueOf(20)))
        {
          n = 20;
          continue;
        }
        if (localList.contains(Integer.valueOf(842094169)))
        {
          n = 842094169;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          n = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(17)))
        {
          n = 17;
          continue;
        }
        if (localList.contains(Integer.valueOf(16)))
        {
          n = 16;
          continue;
        }
        if (localList.contains(Integer.valueOf(3)))
        {
          n = 3;
          continue;
        }
        if (localList.contains(Integer.valueOf(2)))
        {
          n = 2;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          n = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(100)))
        {
          n = 100;
          continue;
        }
        if (localList.contains(Integer.valueOf(101)))
        {
          n = 101;
          continue;
        }
        if (localList.contains(Integer.valueOf(102)))
        {
          n = 102;
          continue;
        }
        if (localList.contains(Integer.valueOf(103)))
        {
          n = 103;
          continue;
        }
        bool = localList.contains(Integer.valueOf(104));
        if (!bool) {
          break label448;
        }
        n = 104;
      }
      label448:
      int n = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, Camera.Parameters paramParameters)
  {
    try
    {
      Object localObject = paramParameters.getClass().getMethod("getSupportedPreviewSizes", new Class[0]);
      if (localObject != null)
      {
        localObject = (List)((Method)localObject).invoke(paramParameters, (Object[])null);
        if (localObject != null)
        {
          localObject = b((List)localObject, paramInt1, paramInt2);
          if (localObject != null)
          {
            k = ((Camera.Size)localObject).width;
            l = ((Camera.Size)localObject).height;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label71:
      break label71;
    }
    if (((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I9003"))) || ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I9220"))) || ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I7000"))))
    {
      k = 320;
      l = 240;
    }
    paramParameters.setPreviewSize(k, l);
  }
  
  @TargetApi(9)
  private void a(Camera.Parameters paramParameters, int paramInt)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      paramInt = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        AVLog.c("AndroidCamera", "setPreviewRate 11: " + localObject2[0] + "|" + localObject2[1]);
        int n = Math.abs(localObject2[0] - jdField_b_of_type_Int) + Math.abs(localObject2[1] - jdField_b_of_type_Int);
        if (paramInt <= n) {
          break label202;
        }
        localObject1 = localObject2;
        paramInt = n;
      }
    }
    label202:
    for (;;)
    {
      break;
      AVLog.c("AndroidCamera", "setPreviewRate result: " + localObject1[0] + "|" + localObject1[1]);
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
      return;
    }
  }
  
  @TargetApi(9)
  private void a(Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    jdField_b_of_type_Int = paramInt2;
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      paramInt1 = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        AVLog.c("AndroidCamera", "setPreviewRate 11: " + localObject2[0] + "|" + localObject2[1]);
        paramInt2 = Math.abs(localObject2[0] - jdField_b_of_type_Int) + Math.abs(localObject2[1] - jdField_b_of_type_Int);
        if (paramInt1 <= paramInt2) {
          break label206;
        }
        localObject1 = localObject2;
        paramInt1 = paramInt2;
      }
    }
    label206:
    for (;;)
    {
      break;
      AVLog.c("AndroidCamera", "setPreviewRate result: " + localObject1[0] + "|" + localObject1[1]);
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
      }
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == paramInt)) {
            break label81;
          }
          this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
          label81:
          if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte.length == paramInt)) {
            continue;
          }
          this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("AndroidCamera", 2, "allocateFrame failed , size:" + paramInt + ", " + localOutOfMemoryError2.getMessage());
        }
      }
    }
    return true;
    return false;
  }
  
  private void b()
  {
    if ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("meizu")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("meizu_m9"))) {
      m = 18;
    }
    while ((!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("ZTE")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("ZTE-T U880"))) {
      return;
    }
    m = 100;
  }
  
  private void c()
  {
    int n = 0;
    this.jdField_f_of_type_Int = 0;
    try
    {
      if (this.jdField_d_of_type_Int == 0) {
        this.jdField_d_of_type_Int = a();
      }
      if (this.jdField_d_of_type_Int > 0)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        for (;;)
        {
          if (n < this.jdField_d_of_type_Int)
          {
            Camera.getCameraInfo(n, localCameraInfo);
            int i1 = localCameraInfo.facing;
            if (i1 == 0) {}
            try
            {
              this.jdField_f_of_type_Int = n;
              n += 1;
            }
            catch (RuntimeException localRuntimeException)
            {
              for (;;)
              {
                this.jdField_f_of_type_Int = 0;
                AVLog.c("AndroidCamera", "openFrontFacingCamera: " + localRuntimeException.getMessage());
              }
            }
          }
        }
      }
      return;
    }
    catch (SecurityException localSecurityException)
    {
      AVLog.c("AndroidCamera", "findBackCameraId SecurityException:" + localSecurityException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      AVLog.c("AndroidCamera", "findBackCameraId:" + localException.getMessage());
    }
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_Boolean) && (a() != null))
    {
      if (a(a(a().getPreviewFormat())))
      {
        this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
        this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
        if (QLog.isColorLevel()) {
          QLog.d("AndroidCamera", 2, "UserBuffer success");
        }
        return;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
      return;
    }
    this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
  }
  
  private int g()
  {
    try
    {
      int n = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      return n;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCamera", "getSysRotation:" + localException.getMessage());
    }
    return 0;
  }
  
  protected int a()
  {
    if (!MobileIssueSettings.h) {
      return KapalaiAdapterUtil.a().a();
    }
    try
    {
      int n = Camera.getNumberOfCameras();
      return n;
    }
    catch (Exception localException)
    {
      AVLog.c("AndroidCamera", "GetNumberOfCamera:" + localException.getMessage());
    }
    return 1;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, true, false, b1, false) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, true, false, b1, false) * 90;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 360 - ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
    }
    return 360 - ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
  }
  
  public Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      AVLog.c("AndroidCamera", "trySamsungFrontCamera:" + localException.getMessage());
    }
    return null;
  }
  
  protected Camera.Size a(List paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    label33:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.05D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label205;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label33;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt2) < d1) {
        d1 = Math.abs(paramList.height - paramInt2);
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        paramList = (List)localObject1;
      }
    }
  }
  
  protected Camera a()
  {
    return b();
  }
  
  protected jgr a(int paramInt, Camera paramCamera)
  {
    paramCamera = new jgr();
    try
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, localCameraInfo);
      paramCamera.jdField_a_of_type_Int = localCameraInfo.facing;
      paramCamera.jdField_b_of_type_Int = localCameraInfo.orientation;
      if (this.jdField_a_of_type_AndroidViewDisplay == null)
      {
        paramCamera.jdField_c_of_type_Int = -1;
        return paramCamera;
      }
      switch (g())
      {
      case 0: 
        paramCamera.jdField_c_of_type_Int = 0;
        return paramCamera;
      }
    }
    catch (Exception localException)
    {
      paramCamera.jdField_c_of_type_Int = 0;
      return paramCamera;
    }
    paramCamera.jdField_c_of_type_Int = 90;
    return paramCamera;
    paramCamera.jdField_c_of_type_Int = 180;
    return paramCamera;
    paramCamera.jdField_c_of_type_Int = 270;
    return paramCamera;
    return paramCamera;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.i("AndroidCamera", 2, "releasePreviewFrameBuffer");
    }
  }
  
  @TargetApi(9)
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
    for (;;)
    {
      return;
      synchronized (jdField_a_of_type_Jgr)
      {
        a(this.jdField_f_of_type_Int, this.jdField_a_of_type_AndroidHardwareCamera);
      }
      try
      {
        ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (??? == null) {
          continue;
        }
        a((Camera.Parameters)???, a((Camera.Parameters)???), paramInt);
        ((Camera.Parameters)???).set("Rotation", 180);
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)???);
          label70:
          Object localObject3 = ((Camera.Parameters)???).getPreviewSize();
          paramInt = ((Camera.Parameters)???).getPreviewFormat();
          k = ((Camera.Size)localObject3).width;
          l = ((Camera.Size)localObject3).height;
          m = paramInt;
          localObject3 = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject3);
          jdField_a_of_type_Int = (localObject3[0] + localObject3[1]) / 2 / 1000;
          b();
          AVLog.c("AndroidCamera", "CameraPara: width=" + k + ", height=" + l + ", nInFPS=" + jdField_a_of_type_Int + "|" + localObject3[0] + "|" + localObject3[1] + ", videoFormat = " + m);
          return;
          localObject4 = finally;
          throw localObject4;
          localException1 = localException1;
          AVLog.c("AndroidCamera", "getParameters exception: " + localException1.getMessage());
          Object localObject2 = null;
        }
        catch (Exception localException2)
        {
          break label70;
        }
      }
    }
  }
  
  @TargetApi(9)
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
    for (;;)
    {
      return;
      synchronized (jdField_a_of_type_Jgr)
      {
        a(this.jdField_f_of_type_Int, this.jdField_a_of_type_AndroidHardwareCamera);
      }
      try
      {
        ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (??? == null) {
          continue;
        }
        a((Camera.Parameters)???, a((Camera.Parameters)???));
        a(paramInt1, paramInt2, (Camera.Parameters)???);
        ((Camera.Parameters)???).set("Rotation", 180);
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)???);
          label76:
          Object localObject3 = ((Camera.Parameters)???).getPreviewSize();
          paramInt1 = ((Camera.Parameters)???).getPreviewFormat();
          k = ((Camera.Size)localObject3).width;
          l = ((Camera.Size)localObject3).height;
          m = paramInt1;
          localObject3 = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject3);
          jdField_a_of_type_Int = (localObject3[0] + localObject3[1]) / 2 / 1000;
          b();
          QLog.w("AndroidCamera", 1, "setCameraPara, size[" + k + ", " + l + "], nInFPS[" + jdField_a_of_type_Int + "], fpsRange[" + localObject3[0] + "][" + localObject3[1] + "], videoFormat[" + m + "]");
          return;
          localObject4 = finally;
          throw localObject4;
          localException1 = localException1;
          AVLog.c("AndroidCamera", "getParameters exception: " + localException1.getMessage());
          Object localObject2 = null;
        }
        catch (Exception localException2)
        {
          break label76;
        }
      }
    }
  }
  
  protected void a(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE }).invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramCamera)
    {
      AVLog.c("AndroidCamera", "setDisplayOrientation:" + paramCamera.getMessage());
    }
  }
  
  public void a(AndroidCamera.CameraPreviewCallback paramCameraPreviewCallback)
  {
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = paramCameraPreviewCallback;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.i = (paramInt % 360);
    }
    for (;;)
    {
      AVLog.c("AndroidCamera", "mFrontCameraAngle: " + this.i + ", mBackCameraAngle: " + this.j);
      return;
      this.j = (paramInt % 360);
    }
  }
  
  protected boolean a()
  {
    jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareCamera = a();
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      AVLog.c("AndroidCamera", "openFrontCamera camera == null");
      jdField_a_of_type_Boolean = false;
      jdField_f_of_type_Boolean = false;
      return false;
    }
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = 2;
    }
    this.jdField_c_of_type_Int = 1;
    jdField_a_of_type_Boolean = true;
    jdField_f_of_type_Boolean = false;
    AVLog.c("AndroidCamera", "openFrontCamera success");
    return true;
  }
  
  protected boolean a(int paramInt, Camera paramCamera)
  {
    jgr localjgr = a(paramInt, paramCamera);
    AVLog.c("AndroidCamera", "getCameraDisplayOrientation orientation:" + localjgr.jdField_b_of_type_Int + ",rotation:" + localjgr.jdField_c_of_type_Int);
    this.h = b();
    this.g = c();
    if (localjgr.jdField_a_of_type_Int == 1)
    {
      paramInt = (360 - (d() + e()) % 360) % 360;
      if (localjgr.jdField_a_of_type_Int != 1) {
        break label166;
      }
    }
    label166:
    for (paramInt = (paramInt + a(this.jdField_e_of_type_Boolean)) % 360;; paramInt = (paramInt + b(this.jdField_e_of_type_Boolean)) % 360)
    {
      a(paramCamera, paramInt);
      jdField_a_of_type_Jgr.jdField_a_of_type_Int = localjgr.jdField_a_of_type_Int;
      jdField_a_of_type_Jgr.jdField_b_of_type_Int = localjgr.jdField_b_of_type_Int;
      return true;
      paramInt = (d() - e() + 360) % 360;
      break;
    }
  }
  
  @TargetApi(11)
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        QLog.w("AndroidCamera", 1, "openCamera begin.");
        boolean bool1;
        if (jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          jdField_a_of_type_Boolean = bool1;
          QLog.w("AndroidCamera", 1, "openCamera end, result[" + bool1 + "]");
          QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
          return bool1;
        }
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          QLog.w("AndroidCamera", 1, "openCamera context == null");
          bool1 = false;
        }
        else
        {
          if (this.jdField_c_of_type_Int == 0)
          {
            if ((!a()) && (!b()))
            {
              QLog.w("AndroidCamera", 1, "openCamera failed");
              bool1 = false;
              continue;
            }
            if (this.jdField_a_of_type_AndroidHardwareCamera == null)
            {
              QLog.w("AndroidCamera", 1, "openCamera camera == null");
              bool1 = false;
              continue;
            }
            a(k, l);
            bool1 = true;
            if (bool1) {
              continue;
            }
            this.jdField_c_of_type_Int = 0;
          }
          switch (this.jdField_c_of_type_Int)
          {
          case 1: 
            if (a())
            {
              a(k, l);
              bool1 = true;
            }
            break;
          case 2: 
            if (b())
            {
              a(k, l);
              bool1 = true;
              continue;
              try
              {
                d();
                this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
                this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
                bool1 = bool2;
              }
              catch (Exception paramSurfaceTexture)
              {
                AVLog.c("AndroidCamera", "setPreviewDisplay error:" + paramSurfaceTexture.getMessage());
                bool1 = false;
              }
            }
            break;
          default: 
            bool1 = false;
          }
        }
      }
      finally {}
    }
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        boolean bool1;
        int n;
        if (this.jdField_d_of_type_Int >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label307;
            QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
            return bool1;
          }
          else
          {
            QLog.w("AndroidCamera", 1, "reopenCamera, size[" + k + ", " + l + "], CUR_CAMERA[" + this.jdField_c_of_type_Int + "], isCameraOpened[" + jdField_a_of_type_Boolean + "], sizeFromParameter[" + paramInt1 + ", " + paramInt2 + "]");
            if (paramInt1 != -1)
            {
              n = paramInt1;
              paramInt1 = paramInt2;
              if (paramInt2 != -1) {}
            }
            else
            {
              n = k;
              paramInt1 = l;
            }
            c();
          }
        }
        switch (this.jdField_c_of_type_Int)
        {
        case 2: 
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          k = n;
          l = paramInt1;
        case 1: 
          try
          {
            d();
            if (paramSurfaceTexture != null) {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
            }
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            AVLog.c("AndroidCamera", "reopenCamera error: " + paramSurfaceTexture.getMessage());
            bool1 = false;
          }
          if (!b()) {
            break label313;
          }
          a(n, paramInt1);
          bool2 = true;
          continue;
          if (!a()) {
            break label313;
          }
          a(n, paramInt1);
          bool2 = true;
          continue;
          continue;
          bool1 = false;
        }
      }
      finally {}
      label307:
      continue;
      label313:
      boolean bool2 = false;
    }
  }
  
  protected int b()
  {
    return 0;
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, false, false, b1, false) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, false, false, b1, false) * 90;
  }
  
  int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
  }
  
  protected Camera.Size b(List paramList, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramList.iterator();
    Camera.Size localSize;
    while (localIterator.hasNext())
    {
      localSize = (Camera.Size)localIterator.next();
      if ((localSize.width == paramInt1) && (localSize.height == paramInt2))
      {
        AVLog.c("AndroidCamera", "previewsize, w= " + paramInt1 + ",h=" + paramInt2);
        return localSize;
      }
    }
    if ((paramInt1 == 320) && (paramInt2 == 240))
    {
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize.width == 640) && (localSize.height == 480))
        {
          AVLog.c("AndroidCamera", "previewsize ,w= " + 640 + ",h=" + 480);
          return localSize;
        }
      }
    }
    if (0 == 0) {
      return a(paramList, k, l);
    }
    return null;
  }
  
  /* Error */
  protected Camera b()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 345	com/tencent/av/camera/AndroidCamera:jdField_f_of_type_Int	I
    //   5: aload_0
    //   6: getfield 55	com/tencent/av/camera/AndroidCamera:jdField_d_of_type_Int	I
    //   9: ifne +11 -> 20
    //   12: aload_0
    //   13: aload_0
    //   14: invokevirtual 346	com/tencent/av/camera/AndroidCamera:a	()I
    //   17: putfield 55	com/tencent/av/camera/AndroidCamera:jdField_d_of_type_Int	I
    //   20: aload_0
    //   21: getfield 55	com/tencent/av/camera/AndroidCamera:jdField_d_of_type_Int	I
    //   24: ifle +222 -> 246
    //   27: new 348	android/hardware/Camera$CameraInfo
    //   30: dup
    //   31: invokespecial 349	android/hardware/Camera$CameraInfo:<init>	()V
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_1
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_3
    //   41: astore 6
    //   43: aload_3
    //   44: astore 4
    //   46: aload_3
    //   47: astore 5
    //   49: iload_1
    //   50: aload_0
    //   51: getfield 55	com/tencent/av/camera/AndroidCamera:jdField_d_of_type_Int	I
    //   54: if_icmpge +146 -> 200
    //   57: aload_3
    //   58: astore 4
    //   60: aload_3
    //   61: astore 5
    //   63: iload_1
    //   64: aload 7
    //   66: invokestatic 355	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   69: aload_3
    //   70: astore 4
    //   72: aload_3
    //   73: astore 5
    //   75: aload 7
    //   77: getfield 358	android/hardware/Camera$CameraInfo:facing	I
    //   80: istore_2
    //   81: aload_3
    //   82: astore 4
    //   84: iload_2
    //   85: iconst_1
    //   86: if_icmpne +28 -> 114
    //   89: aload_3
    //   90: astore 4
    //   92: aload_3
    //   93: astore 5
    //   95: iload_1
    //   96: invokestatic 621	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   99: astore_3
    //   100: aload_3
    //   101: astore 4
    //   103: aload_3
    //   104: astore 5
    //   106: aload_0
    //   107: iload_1
    //   108: putfield 345	com/tencent/av/camera/AndroidCamera:jdField_f_of_type_Int	I
    //   111: aload_3
    //   112: astore 4
    //   114: iload_1
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: aload 4
    //   120: astore_3
    //   121: goto -81 -> 40
    //   124: astore_3
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield 345	com/tencent/av/camera/AndroidCamera:jdField_f_of_type_Int	I
    //   130: ldc 123
    //   132: new 125	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 623
    //   142: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_3
    //   146: invokevirtual 361	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   149: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 143	com/tencent/av/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aconst_null
    //   159: astore 4
    //   161: goto -47 -> 114
    //   164: astore_3
    //   165: aconst_null
    //   166: astore 5
    //   168: ldc 123
    //   170: new 125	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 625
    //   180: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_3
    //   184: invokevirtual 364	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 143	com/tencent/av/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 5
    //   198: astore 6
    //   200: aload 6
    //   202: areturn
    //   203: astore_3
    //   204: aconst_null
    //   205: astore 4
    //   207: ldc 123
    //   209: new 125	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 360
    //   219: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_3
    //   223: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 143	com/tencent/av/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 4
    //   237: areturn
    //   238: astore_3
    //   239: goto -32 -> 207
    //   242: astore_3
    //   243: goto -75 -> 168
    //   246: aconst_null
    //   247: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	AndroidCamera
    //   37	81	1	n	int
    //   80	7	2	i1	int
    //   39	82	3	localObject1	Object
    //   124	22	3	localRuntimeException	RuntimeException
    //   164	20	3	localSecurityException1	SecurityException
    //   203	20	3	localException1	Exception
    //   238	1	3	localException2	Exception
    //   242	1	3	localSecurityException2	SecurityException
    //   44	192	4	localObject2	Object
    //   47	150	5	localObject3	Object
    //   41	160	6	localObject4	Object
    //   34	42	7	localCameraInfo	Camera.CameraInfo
    // Exception table:
    //   from	to	target	type
    //   95	100	124	java/lang/RuntimeException
    //   106	111	124	java/lang/RuntimeException
    //   5	20	164	java/lang/SecurityException
    //   20	36	164	java/lang/SecurityException
    //   125	158	164	java/lang/SecurityException
    //   5	20	203	java/lang/Exception
    //   20	36	203	java/lang/Exception
    //   125	158	203	java/lang/Exception
    //   49	57	238	java/lang/Exception
    //   63	69	238	java/lang/Exception
    //   75	81	238	java/lang/Exception
    //   95	100	238	java/lang/Exception
    //   106	111	238	java/lang/Exception
    //   49	57	242	java/lang/SecurityException
    //   63	69	242	java/lang/SecurityException
    //   75	81	242	java/lang/SecurityException
    //   95	100	242	java/lang/SecurityException
    //   106	111	242	java/lang/SecurityException
  }
  
  public void b(int paramInt)
  {
    jdField_a_of_type_Jgr.jdField_c_of_type_Int = ((this.h + paramInt) % 360);
  }
  
  protected boolean b()
  {
    boolean bool = jdField_a_of_type_Boolean;
    try
    {
      jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_c_of_type_Int = 2;
        jdField_a_of_type_Boolean = true;
        jdField_f_of_type_Boolean = false;
        c();
        AVLog.c("AndroidCamera", "openBackCamera success");
        return true;
      }
    }
    catch (Exception localException)
    {
      jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.release();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
      }
      QLog.w("AndroidCamera", 1, "openBackCamera Exception, srcIsCameraOpened[" + bool + "]", localException);
      return false;
    }
    jdField_f_of_type_Boolean = false;
    return false;
  }
  
  @TargetApi(11)
  public boolean b(SurfaceTexture paramSurfaceTexture)
  {
    label236:
    for (;;)
    {
      try
      {
        if (this.jdField_d_of_type_Int >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label236;
            QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
            return bool1;
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder().append("switchCamera: ");
            if (this.jdField_c_of_type_Int == 1)
            {
              str = "FRONT_CAMERA";
              AVLog.c("AndroidCamera", str);
              c();
              int n = this.jdField_c_of_type_Int;
              switch (n)
              {
              default: 
                bool2 = false;
                bool1 = bool2;
                if (!bool2) {
                  continue;
                }
              }
            }
            try
            {
              d();
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
              this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
              bool1 = true;
            }
            catch (Exception paramSurfaceTexture)
            {
              AVLog.c("AndroidCamera", "switchCamera error:" + paramSurfaceTexture.getMessage());
              bool1 = false;
            }
            String str = "BACK_CAMERA";
            continue;
            if (!b()) {
              continue;
            }
            a(k, l);
            boolean bool2 = true;
            continue;
            if (!a()) {
              continue;
            }
            a(k, l);
            bool2 = true;
            continue;
            continue;
          }
        }
        boolean bool1 = false;
      }
      finally {}
    }
  }
  
  protected int c()
  {
    return 0;
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.i;
    }
    return this.j;
  }
  
  public boolean c()
  {
    try
    {
      AVLog.c("AndroidCamera", "closeCamera begin.");
      if ((this.jdField_a_of_type_AndroidHardwareCamera == null) && (!jdField_a_of_type_Boolean)) {
        AVLog.c("AndroidCamera", "Camera not open.");
      }
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          if (jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
            this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
            this.jdField_a_of_type_AndroidHardwareCamera.release();
          }
          a();
          this.jdField_a_of_type_AndroidHardwareCamera = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AVLog.c("AndroidCamera", "closeCamera Exception:" + localException.getMessage());
        }
      }
      jdField_a_of_type_Boolean = false;
      AVLog.c("AndroidCamera", "closeCamera end.");
      QavCameraUsage.a(BaseApplicationImpl.getContext(), false);
      return true;
    }
    finally {}
  }
  
  public int d()
  {
    if (jdField_a_of_type_Jgr.jdField_b_of_type_Int == -1)
    {
      if (this.jdField_c_of_type_Int == 1) {
        return 270;
      }
      if (this.jdField_c_of_type_Int == 2) {
        return 90;
      }
    }
    return jdField_a_of_type_Jgr.jdField_b_of_type_Int;
  }
  
  public boolean d()
  {
    if (this.jdField_c_of_type_Int == 0) {}
    while (this.jdField_c_of_type_Int == 1) {
      return true;
    }
    return false;
  }
  
  public int e()
  {
    if (jdField_a_of_type_Jgr.jdField_c_of_type_Int == -1) {
      return 0;
    }
    return jdField_a_of_type_Jgr.jdField_c_of_type_Int;
  }
  
  public boolean e()
  {
    return jdField_f_of_type_Boolean;
  }
  
  public int f()
  {
    return a();
  }
  
  public boolean f()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.camera.AndroidCamera
 * JD-Core Version:    0.7.0.1
 */