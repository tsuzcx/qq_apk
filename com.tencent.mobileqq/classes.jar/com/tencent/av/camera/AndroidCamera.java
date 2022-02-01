package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.AVLog;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class AndroidCamera
{
  public static volatile boolean a = true;
  public static int b = 1280;
  public static int c = 720;
  public static int d = 17;
  protected static boolean e = false;
  protected static int f = 0;
  protected static int g = 15000;
  protected static boolean h = false;
  protected static CameraInformation i = new CameraInformation();
  private int A = 0;
  Context j = null;
  Camera k = null;
  int l = 0;
  int m = 0;
  int n;
  String o;
  String p;
  Display q;
  int r;
  int s = 0;
  int t = 0;
  int u = 0;
  int v = 0;
  boolean w = false;
  boolean x = false;
  public boolean y = false;
  private CameraCallback z = null;
  
  public AndroidCamera(Context paramContext)
  {
    this.j = paramContext;
    this.q = ((WindowManager)this.j.getSystemService("window")).getDefaultDisplay();
    this.w = PhoneStatusTools.i(this.j);
    this.x = PhoneStatusTools.c();
    this.n = Build.VERSION.SDK_INT;
    this.o = Build.MODEL;
    this.p = Build.MANUFACTURER;
    paramContext = i;
    paramContext.b = -1;
    paramContext.c = -1;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("AndroidCamera, Device_Tag[");
      paramContext.append(this.p);
      paramContext.append(": ");
      paramContext.append(this.o);
      paramContext.append("], Rom_Tag[");
      paramContext.append(Build.VERSION.INCREMENTAL);
      paramContext.append("]");
      QLog.w("AndroidCamera", 1, paramContext.toString());
    }
  }
  
  private int a(long paramLong, Camera.Parameters paramParameters)
  {
    try
    {
      localObject = paramParameters.getSupportedPreviewFormats();
      if (localObject != null)
      {
        if (AudioHelper.e())
        {
          StringBuilder localStringBuilder = new StringBuilder("setPreviewFormat[");
          i1 = 0;
          while (i1 < ((List)localObject).size())
          {
            localStringBuilder.append(((List)localObject).get(i1));
            localStringBuilder.append(";");
            i1 += 1;
          }
          localStringBuilder.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder.toString());
        }
        if (((List)localObject).contains(Integer.valueOf(17))) {
          break label559;
        }
        if (((List)localObject).contains(Integer.valueOf(16))) {
          break label566;
        }
        if (((List)localObject).contains(Integer.valueOf(20)))
        {
          i1 = 20;
        }
        else if (((List)localObject).contains(Integer.valueOf(842094169)))
        {
          i1 = 842094169;
        }
        else
        {
          if (((List)localObject).contains(Integer.valueOf(4))) {
            break label573;
          }
          if (((List)localObject).contains(Integer.valueOf(17))) {
            break label559;
          }
          if (((List)localObject).contains(Integer.valueOf(16))) {
            break label566;
          }
          if (((List)localObject).contains(Integer.valueOf(3)))
          {
            i1 = 3;
          }
          else if (((List)localObject).contains(Integer.valueOf(2)))
          {
            i1 = 2;
          }
          else
          {
            if (((List)localObject).contains(Integer.valueOf(4))) {
              break label573;
            }
            if (((List)localObject).contains(Integer.valueOf(100)))
            {
              i1 = 100;
            }
            else
            {
              i1 = 101;
              if (!((List)localObject).contains(Integer.valueOf(101)))
              {
                i1 = 102;
                if (!((List)localObject).contains(Integer.valueOf(102))) {
                  if (((List)localObject).contains(Integer.valueOf(103)))
                  {
                    i1 = 103;
                  }
                  else
                  {
                    boolean bool = ((List)localObject).contains(Integer.valueOf(104));
                    if (bool) {
                      i1 = 104;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        continue;
        label559:
        int i1 = 17;
        continue;
        label566:
        i1 = 16;
        continue;
        label573:
        i1 = 4;
      }
    }
    i1 = 0;
    if (i1 != 0)
    {
      if (AudioHelper.e())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setPreviewFormat, supportFormat[");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w("AndroidCamera", 1, ((StringBuilder)localObject).toString());
      }
      paramParameters.setPreviewFormat(i1);
      return i1;
    }
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPreviewFormat, default supportFormat[");
      ((StringBuilder)localObject).append(17);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("AndroidCamera", 1, ((StringBuilder)localObject).toString());
    }
    paramParameters.setPreviewFormat(17);
    return 17;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, Camera.Parameters paramParameters)
  {
    int i1 = b;
    int i2 = c;
    try
    {
      localObject = paramParameters.getSupportedPreviewSizes();
      if (localObject != null)
      {
        localObject = b((List)localObject, paramInt1, paramInt2);
        if (localObject != null) {
          a("setPreviewSize_support", paramLong, ((Camera.Size)localObject).width, ((Camera.Size)localObject).height);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label54:
      break label54;
    }
    if (((this.p.equalsIgnoreCase("samsung")) && (this.o.equalsIgnoreCase("GT-I9003"))) || ((this.p.equalsIgnoreCase("samsung")) && (this.o.equalsIgnoreCase("GT-I9220"))) || ((this.p.equalsIgnoreCase("samsung")) && (this.o.equalsIgnoreCase("GT-I7000")))) {
      a("setPreviewSize_hardcode", paramLong, 320, 240);
    }
    if (g()) {
      a("setPreviewSize_hardcode", paramLong, 1280, 720);
    }
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPreviewSize, in[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], before[");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append("], final[");
      ((StringBuilder)localObject).append(b);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("AndroidCamera", 1, ((StringBuilder)localObject).toString());
    }
    paramParameters.setPreviewSize(b, c);
  }
  
  private void a(long paramLong, Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    g = paramInt2;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = (int[])((List)localObject2).get(0);
      int i1 = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.e())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setPreviewRate2, Range[");
          localStringBuilder.append(localObject2[0]);
          localStringBuilder.append("->");
          localStringBuilder.append(localObject2[1]);
          localStringBuilder.append("], seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder.toString());
        }
        int i2 = Math.abs(localObject2[0] - g) + Math.abs(localObject2[1] - g);
        if (i1 > i2)
        {
          localObject1 = localObject2;
          i1 = i2;
        }
      }
      if (AudioHelper.e())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setPreviewRate2, Range[");
        ((StringBuilder)localObject2).append(localObject1[0]);
        ((StringBuilder)localObject2).append("->");
        ((StringBuilder)localObject2).append(localObject1[1]);
        ((StringBuilder)localObject2).append("], supportFormat[");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("], newFps[");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append("], seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w("AndroidCamera", 1, ((StringBuilder)localObject2).toString());
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
    }
  }
  
  @TargetApi(9)
  private void a(Camera.Parameters paramParameters, int paramInt)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = (int[])((List)localObject2).get(0);
      int i1 = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.e())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setPreviewRate1, Range[");
          localStringBuilder.append(localObject2[0]);
          localStringBuilder.append("->");
          localStringBuilder.append(localObject2[1]);
          localStringBuilder.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder.toString());
        }
        int i2 = Math.abs(localObject2[0] - g) + Math.abs(localObject2[1] - g);
        if (i1 > i2)
        {
          localObject1 = localObject2;
          i1 = i2;
        }
      }
      if (AudioHelper.e())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setPreviewRate1, Range[");
        ((StringBuilder)localObject2).append(localObject1[0]);
        ((StringBuilder)localObject2).append("->");
        ((StringBuilder)localObject2).append(localObject1[1]);
        ((StringBuilder)localObject2).append("], supportFormat[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("]");
        QLog.w("AndroidCamera", 1, ((StringBuilder)localObject2).toString());
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
    }
  }
  
  public static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      if ((b != paramInt1) || (c != paramInt2) || (QLog.isDevelopLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetPreViewSize, from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], src[");
        localStringBuilder.append(b);
        localStringBuilder.append("x");
        localStringBuilder.append(c);
        localStringBuilder.append("], final[");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("x");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder.toString());
      }
      b = paramInt1;
      c = paramInt2;
      return;
    }
    finally {}
  }
  
  public static boolean g()
  {
    return "1".equalsIgnoreCase(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.use720PCameraPreviewSize.name(), "0"));
  }
  
  private void n()
  {
    if ((this.p.equalsIgnoreCase("meizu")) && (this.o.equalsIgnoreCase("meizu_m9")))
    {
      d = 18;
      return;
    }
    if ((this.p.equalsIgnoreCase("ZTE")) && (this.o.equalsIgnoreCase("ZTE-T U880"))) {
      d = 100;
    }
  }
  
  private void o()
  {
    this.r = 0;
    try
    {
      if (this.m == 0) {
        this.m = c();
      }
      if (this.m > 0)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        int i1 = 0;
        while (i1 < this.m)
        {
          Camera.getCameraInfo(i1, localCameraInfo);
          int i2 = localCameraInfo.facing;
          if (i2 == 0) {
            try
            {
              this.r = i1;
            }
            catch (RuntimeException localRuntimeException)
            {
              this.r = 0;
              if (AudioHelper.e()) {
                QLog.w("AndroidCamera", 1, "findBackCameraId, RuntimeException", localRuntimeException);
              }
            }
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "findBackCameraId, Exception", localException);
      }
    }
  }
  
  public int a()
  {
    return this.A;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = ConfigSystemImpl.a(this.j, true, true, (byte)0, false);; i1 = ConfigSystemImpl.b(this.j, true, true, (byte)0, false)) {
      return 360 - i1 * 90;
    }
  }
  
  protected Camera.Size a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    double d3 = d1 / d2;
    Object localObject1 = null;
    if (paramList == null) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    d2 = 1.7976931348623157E+308D;
    d1 = 1.7976931348623157E+308D;
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      double d4 = ((Camera.Size)localObject2).width;
      double d5 = ((Camera.Size)localObject2).height;
      Double.isNaN(d4);
      Double.isNaN(d5);
      if ((Math.abs(d4 / d5 - d3) <= 0.05D) && (Math.abs(((Camera.Size)localObject2).height - paramInt2) < d1))
      {
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localIterator = paramList.iterator();
      d1 = d2;
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (Camera.Size)localIterator.next();
        if (Math.abs(paramList.height - paramInt2) < d1)
        {
          d1 = Math.abs(paramList.height - paramInt2);
          localObject1 = paramList;
        }
      }
    }
    return localObject2;
  }
  
  protected Camera a(long paramLong)
  {
    return b(paramLong);
  }
  
  protected CameraInformation a(int paramInt, Camera paramCamera)
  {
    paramCamera = new CameraInformation();
    try
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, localCameraInfo);
      paramCamera.a = localCameraInfo.facing;
      paramCamera.b = localCameraInfo.orientation;
      if (this.q == null)
      {
        paramCamera.c = -1;
        return paramCamera;
      }
      paramInt = d();
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return paramCamera;
            }
            paramCamera.c = 270;
            return paramCamera;
          }
          paramCamera.c = 180;
          return paramCamera;
        }
        paramCamera.c = 90;
        return paramCamera;
      }
      paramCamera.c = 0;
      return paramCamera;
    }
    catch (Exception localException)
    {
      label110:
      break label110;
    }
    paramCamera.c = 0;
    return paramCamera;
  }
  
  public void a(int paramInt)
  {
    int i1 = i.c;
    Object localObject = i;
    ((CameraInformation)localObject).c = ((paramInt + this.t) % 360);
    if (i1 != ((CameraInformation)localObject).c)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setMobileRotation, rotation[");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(i.c);
      ((StringBuilder)localObject).append("], mCompenSateSendAngle[");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append("]");
      QLog.w("AndroidCamera", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, CameraPreviewCallback paramCameraPreviewCallback)
  {
    int i1;
    if (this.A != paramInt)
    {
      this.A = paramInt;
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    int i2 = this.A;
    if (i2 == 0)
    {
      if ((this.z == null) || (i1 != 0)) {
        this.z = new MyPreviewCallback(this, paramCameraPreviewCallback);
      }
    }
    else if ((i2 == 1) && ((this.z == null) || (i1 != 0)))
    {
      CameraCallback localCameraCallback = this.z;
      if (localCameraCallback != null) {
        localCameraCallback.b();
      }
      this.z = new MySurfaceCallback(this, paramCameraPreviewCallback);
    }
    if (QLog.isColorLevel())
    {
      paramCameraPreviewCallback = new StringBuilder();
      paramCameraPreviewCallback.append("setCameraMode, mode[");
      paramCameraPreviewCallback.append(paramInt);
      paramCameraPreviewCallback.append("]");
      QLog.i("SurfaceTag", 2, paramCameraPreviewCallback.toString());
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.k == null) {
      return;
    }
    Camera.Size localSize;
    int i1;
    synchronized (i)
    {
      a(paramLong, this.r, this.k);
      localSize = null;
      try
      {
        ??? = this.k.getParameters();
      }
      catch (Exception localException2)
      {
        ??? = localSize;
        if (AudioHelper.e())
        {
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, Exception", localException2);
          ??? = localSize;
        }
      }
      if (??? == null)
      {
        if (AudioHelper.e()) {
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, parameters为空");
        }
        return;
      }
      i1 = a(paramLong, (Camera.Parameters)???);
      a(paramLong, (Camera.Parameters)???, i1, paramInt);
      ((Camera.Parameters)???).set("Rotation", 180);
    }
    try
    {
      this.k.setParameters((Camera.Parameters)???);
      label135:
      localSize = ((Camera.Parameters)???).getPreviewSize();
      paramInt = ((Camera.Parameters)???).getPreviewFormat();
      if (localSize != null)
      {
        a("setCameraParaFPS", paramLong, localSize.width, localSize.height);
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setCameraParaFPS, getPreviewSize fail, size[");
        ((StringBuilder)localObject3).append(((Camera.Parameters)???).get("preview-size"));
        ((StringBuilder)localObject3).append("]");
        QLog.w("AndroidCamera", 1, ((StringBuilder)localObject3).toString());
      }
      d = paramInt;
      Object localObject3 = new int[2];
      ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject3);
      f = (localObject3[0] + localObject3[1]) / 2 / 1000;
      n();
      if ((AudioHelper.e()) || (localSize == null))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("setCameraParaFPS, width[");
        ((StringBuilder)???).append(b);
        ((StringBuilder)???).append("], height[");
        ((StringBuilder)???).append(c);
        ((StringBuilder)???).append("], nInFPS[");
        ((StringBuilder)???).append(f);
        ((StringBuilder)???).append("], fpsRange[");
        ((StringBuilder)???).append(localObject3[0]);
        ((StringBuilder)???).append("|");
        ((StringBuilder)???).append(localObject3[1]);
        ((StringBuilder)???).append("], videoFormat[");
        ((StringBuilder)???).append(d);
        ((StringBuilder)???).append("], supportFormat[");
        ((StringBuilder)???).append(i1);
        ((StringBuilder)???).append("], seq[");
        ((StringBuilder)???).append(paramLong);
        ((StringBuilder)???).append("]");
        QLog.w("AndroidCamera", 1, ((StringBuilder)???).toString());
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException1)
    {
      break label135;
    }
  }
  
  @TargetApi(9)
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.k == null) {
      return;
    }
    synchronized (i)
    {
      a(paramLong, this.r, this.k);
      localObject2 = null;
      try
      {
        ??? = this.k.getParameters();
      }
      catch (Exception localException3)
      {
        ??? = localObject2;
        if (AudioHelper.e())
        {
          QLog.w("AndroidCamera", 1, "setCameraPara, Exception", localException3);
          ??? = localObject2;
        }
      }
      if (??? == null)
      {
        if (AudioHelper.e()) {
          QLog.w("AndroidCamera", 1, "setCameraPara, parameters为空");
        }
        return;
      }
      a((Camera.Parameters)???, a(paramLong, (Camera.Parameters)???));
      a(paramLong, paramInt1, paramInt2, (Camera.Parameters)???);
      try
      {
        ((Camera.Parameters)???).setRotation(180);
      }
      catch (Exception localException1)
      {
        try
        {
          this.k.setParameters((Camera.Parameters)???);
          localObject2 = ((Camera.Parameters)???).getPreviewSize();
          int i1 = ((Camera.Parameters)???).getPreviewFormat();
          a("setCameraPara", paramLong, ((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height);
          d = i1;
          localObject2 = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject2);
          f = (localObject2[0] + localObject2[1]) / 2 / 1000;
          n();
          ??? = new StringBuilder();
          ((StringBuilder)???).append("setCameraPara, size[");
          ((StringBuilder)???).append(b);
          ((StringBuilder)???).append("x");
          ((StringBuilder)???).append(c);
          ((StringBuilder)???).append("], src[");
          ((StringBuilder)???).append(paramInt1);
          ((StringBuilder)???).append("x");
          ((StringBuilder)???).append(paramInt2);
          ((StringBuilder)???).append("], nInFPS[");
          ((StringBuilder)???).append(f);
          ((StringBuilder)???).append("], fpsRange[");
          ((StringBuilder)???).append(localObject2[0]);
          ((StringBuilder)???).append("~");
          ((StringBuilder)???).append(localObject2[1]);
          ((StringBuilder)???).append("], videoFormat[");
          ((StringBuilder)???).append(d);
          ((StringBuilder)???).append("], seq[");
          ((StringBuilder)???).append(paramLong);
          ((StringBuilder)???).append("]");
          QLog.w("AndroidCamera", 1, ((StringBuilder)???).toString());
          return;
          localObject3 = finally;
          throw localObject3;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          break label150;
        }
      }
      ((Camera.Parameters)???).set("Rotation", 180);
    }
  }
  
  protected void a(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.setDisplayOrientation(paramInt);
      return;
    }
    catch (Exception paramCamera)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "setDisplayOrientation, Exception", paramCamera);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.u = (paramInt % 360);
    } else {
      this.v = (paramInt % 360);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mFrontCameraAngle: ");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", mBackCameraAngle: ");
    localStringBuilder.append(this.v);
    AVLog.printColorLog("AndroidCamera", localStringBuilder.toString());
  }
  
  protected boolean a(long paramLong, int paramInt, Camera paramCamera)
  {
    CameraInformation localCameraInformation = a(paramInt, paramCamera);
    this.t = e();
    this.s = f();
    int i2 = h();
    int i3 = i();
    int i1;
    if (localCameraInformation.a == 1) {
      i1 = (360 - (localCameraInformation.b + localCameraInformation.c) % 360) % 360;
    } else {
      i1 = (localCameraInformation.b - localCameraInformation.c + 360) % 360;
    }
    int i4 = a(this.y);
    int i5 = b(this.y);
    if (localCameraInformation.a == 1) {
      i1 = (i1 + i4) % 360;
    } else {
      i1 = (i1 + i5) % 360;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCameraDisplayOrientation, cameraId[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], orientation[");
    localStringBuilder.append(i.b);
    localStringBuilder.append("->");
    localStringBuilder.append(localCameraInformation.b);
    localStringBuilder.append("], rotation[");
    localStringBuilder.append(i.c);
    localStringBuilder.append("->");
    localStringBuilder.append(localCameraInformation.c);
    localStringBuilder.append("], mCompenSateSendAngle[");
    localStringBuilder.append(this.t);
    localStringBuilder.append("], mCompenSateRecvAngle[");
    localStringBuilder.append(this.s);
    localStringBuilder.append("], mSupportLandscape[");
    localStringBuilder.append(this.y);
    localStringBuilder.append("], previewAngleForFrontCamera[");
    localStringBuilder.append(i4);
    localStringBuilder.append("], previewAngleForBackCamera[");
    localStringBuilder.append(i5);
    localStringBuilder.append("], cameraImageOrientation[");
    localStringBuilder.append(i2);
    localStringBuilder.append("], mobileRotation[");
    localStringBuilder.append(i3);
    localStringBuilder.append("], result[");
    localStringBuilder.append(i1);
    localStringBuilder.append("], cameraMode[");
    localStringBuilder.append(this.A);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("AndroidCamera", 1, localStringBuilder.toString());
    a(paramCamera, i1);
    i.a = localCameraInformation.a;
    i.b = localCameraInformation.b;
    return true;
  }
  
  @TargetApi(11)
  public boolean a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("openCamera begin, Camera[");
      localStringBuilder.append(toString());
      localStringBuilder.append("], PreViewSize[");
      localStringBuilder.append(b);
      localStringBuilder.append("x");
      localStringBuilder.append(c);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("AndroidCamera", 1, localStringBuilder.toString());
      bool1 = e;
      bool2 = false;
      if (bool1) {
        break label697;
      }
      if (this.j == null)
      {
        paramSurfaceTexture = new StringBuilder();
        paramSurfaceTexture.append("openCamera, context为空, seq[");
        paramSurfaceTexture.append(paramLong);
        paramSurfaceTexture.append("]");
        QLog.w("AndroidCamera", 1, paramSurfaceTexture.toString());
        bool1 = bool2;
        break label580;
      }
      if (this.l == 0)
      {
        if ((!c(paramLong)) && (!d(paramLong)))
        {
          paramSurfaceTexture = new StringBuilder();
          paramSurfaceTexture.append("openCamera failed, seq[");
          paramSurfaceTexture.append(paramLong);
          paramSurfaceTexture.append("]");
          QLog.w("AndroidCamera", 1, paramSurfaceTexture.toString());
          bool1 = bool2;
          break label580;
        }
        if (this.k == null)
        {
          paramSurfaceTexture = new StringBuilder();
          paramSurfaceTexture.append("openCamera camera为空,setPreviewSize seq[");
          paramSurfaceTexture.append(paramLong);
          paramSurfaceTexture.append("]");
          QLog.w("AndroidCamera", 1, paramSurfaceTexture.toString());
          bool1 = bool2;
          break label580;
        }
        a(paramLong, b, c);
        break label703;
      }
      int i1 = this.l;
      if (i1 != 1)
      {
        if ((i1 != 2) || (!d(paramLong))) {
          break label709;
        }
        a(paramLong, b, c);
      }
      else
      {
        if (!c(paramLong)) {
          break label709;
        }
        a(paramLong, b, c);
      }
    }
    finally
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        boolean bool2;
        for (;;)
        {
          label580:
          throw paramSurfaceTexture;
        }
        label697:
        boolean bool1 = true;
        continue;
        label703:
        bool1 = true;
        continue;
        label709:
        bool1 = false;
        continue;
        label715:
        bool1 = false;
      }
    }
    if (!bool1)
    {
      this.l = 0;
    }
    else
    {
      try
      {
        if (this.z != null) {
          this.z.a(paramLong, paramSurfaceTexture);
        }
        if (paramSurfaceTexture != null) {
          this.k.setPreviewTexture(paramSurfaceTexture);
        }
        this.k.startPreview();
      }
      catch (Exception paramSurfaceTexture)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPreviewDisplay Exception, camera[");
        if (this.k == null) {
          break label715;
        }
      }
      bool1 = true;
      localStringBuilder.append(bool1);
      localStringBuilder.append("], isCameraOpened[");
      localStringBuilder.append(e);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("AndroidCamera", 1, localStringBuilder.toString(), paramSurfaceTexture);
      bool1 = bool2;
      if (this.k != null)
      {
        this.k.release();
        this.k = null;
        paramSurfaceTexture = new StringBuilder();
        paramSurfaceTexture.append("setPreviewDisplay fail, set camera null, seq[");
        paramSurfaceTexture.append(paramLong);
        paramSurfaceTexture.append("]");
        QLog.w("AndroidCamera", 1, paramSurfaceTexture.toString());
        bool1 = bool2;
      }
    }
    e = bool1;
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("openCamera end, result[");
    paramSurfaceTexture.append(bool1);
    paramSurfaceTexture.append("], Camera[");
    paramSurfaceTexture.append(toString());
    paramSurfaceTexture.append("], seq[");
    paramSurfaceTexture.append(paramLong);
    paramSurfaceTexture.append("]");
    QLog.w("AndroidCamera", 1, paramSurfaceTexture.toString());
    if (bool1) {
      QavCameraUsage.a(BaseApplication.getContext(), "openCamera");
    } else {
      QavCameraUsage.b(BaseApplication.getContext(), "openCamera");
    }
    return bool1;
  }
  
  public boolean a(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int i1 = this.m;
        boolean bool2 = false;
        bool1 = bool2;
        if (i1 >= 1) {
          if (this.k == null)
          {
            bool1 = bool2;
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("reopenCamera, size[");
            localStringBuilder.append(b);
            localStringBuilder.append(", ");
            localStringBuilder.append(c);
            localStringBuilder.append("], mCurCamera[");
            localStringBuilder.append(this.l);
            localStringBuilder.append("], isCameraOpened[");
            localStringBuilder.append(e);
            localStringBuilder.append("], sizeFromParameter[");
            localStringBuilder.append(paramInt1);
            localStringBuilder.append(", ");
            localStringBuilder.append(paramInt2);
            localStringBuilder.append("], seq[");
            localStringBuilder.append(paramLong);
            localStringBuilder.append("]");
            QLog.w("AndroidCamera", 1, localStringBuilder.toString());
            if (paramInt1 != -1)
            {
              i1 = paramInt1;
              paramInt1 = paramInt2;
              if (paramInt2 != -1) {}
            }
            else
            {
              i1 = b;
              paramInt1 = c;
            }
            e(paramLong);
            paramInt2 = this.l;
            if (paramInt2 != 1)
            {
              if ((paramInt2 != 2) || (!d(paramLong))) {
                break label436;
              }
              a(paramLong, i1, paramInt1);
              break label430;
            }
            if (!c(paramLong)) {
              break label436;
            }
            a(paramLong, i1, paramInt1);
            break label430;
            a("reopenCamera", paramLong, i1, paramInt1);
            try
            {
              if (this.z != null) {
                this.z.a(paramLong, paramSurfaceTexture);
              }
              if (paramSurfaceTexture != null) {
                this.k.setPreviewTexture(paramSurfaceTexture);
              }
              this.k.startPreview();
              bool1 = true;
            }
            catch (Exception paramSurfaceTexture)
            {
              bool1 = bool2;
              if (AudioHelper.e())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("reopenCamera, Exception, seq[");
                localStringBuilder.append(paramLong);
                localStringBuilder.append("]");
                QLog.w("AndroidCamera", 1, localStringBuilder.toString(), paramSurfaceTexture);
                bool1 = bool2;
              }
            }
          }
        }
        if (bool1) {
          QavCameraUsage.a(BaseApplication.getContext(), "reopenCamera");
        } else {
          QavCameraUsage.b(BaseApplication.getContext(), "reopenCamera");
        }
        return bool1;
      }
      finally {}
      label430:
      boolean bool1 = true;
      break label439;
      label436:
      bool1 = false;
      label439:
      if (bool1) {}
    }
  }
  
  int b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = ConfigSystemImpl.a(this.j, false, true, (byte)0, false);; i1 = ConfigSystemImpl.b(this.j, false, true, (byte)0, false)) {
      return i1 * 90;
    }
  }
  
  public Camera.Parameters b()
  {
    try
    {
      Camera.Parameters localParameters = this.k.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "getCameraParams, Exception", localException);
      }
    }
    return null;
  }
  
  protected Camera.Size b(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Camera.Size)localIterator.next();
      if ((((Camera.Size)localObject).width == paramInt1) && (((Camera.Size)localObject).height == paramInt2))
      {
        if (AudioHelper.e())
        {
          paramList = new StringBuilder();
          paramList.append("getOptimalEqualPreviewSize1, width[");
          paramList.append(((Camera.Size)localObject).width);
          paramList.append("], height[");
          paramList.append(((Camera.Size)localObject).height);
          paramList.append("]");
          QLog.w("AndroidCamera", 1, paramList.toString());
        }
        return localObject;
      }
    }
    int i1 = paramInt1;
    int i2 = paramInt2;
    if (paramInt1 == 320)
    {
      i1 = paramInt1;
      i2 = paramInt2;
      if (paramInt2 == 240)
      {
        paramInt1 = 640;
        paramInt2 = 480;
        localIterator = paramList.iterator();
        do
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Camera.Size)localIterator.next();
        } while ((((Camera.Size)localObject).width != 640) || (((Camera.Size)localObject).height != 480));
        if (AudioHelper.e())
        {
          paramList = new StringBuilder();
          paramList.append("getOptimalEqualPreviewSize2, width[");
          paramList.append(((Camera.Size)localObject).width);
          paramList.append("], height[");
          paramList.append(((Camera.Size)localObject).height);
          paramList.append("]");
          QLog.w("AndroidCamera", 1, paramList.toString());
        }
        return localObject;
      }
    }
    int i3 = b;
    int i4 = c;
    paramList = a(paramList, i3, i4);
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getOptimalEqualPreviewSize3, width[");
      paramInt2 = -1;
      if (paramList != null) {
        paramInt1 = paramList.width;
      } else {
        paramInt1 = -1;
      }
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], height[");
      paramInt1 = paramInt2;
      if (paramList != null) {
        paramInt1 = paramList.height;
      }
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], srcW[");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("], srcH[");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append("], fw[");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append("], fh[");
      ((StringBuilder)localObject).append(i4);
      ((StringBuilder)localObject).append("]");
      QLog.w("AndroidCamera", 1, ((StringBuilder)localObject).toString());
    }
    return paramList;
  }
  
  protected Camera b(long paramLong)
  {
    this.r = 0;
    Object localObject4 = null;
    Object localObject3 = null;
    for (;;)
    {
      int i1;
      Object localObject2;
      try
      {
        if (this.m == 0) {
          this.m = c();
        }
        i1 = this.m;
        if (i1 > 0)
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          i1 = 0;
          Object localObject1 = localObject4;
          if (i1 >= this.m) {
            break label468;
          }
          Camera.getCameraInfo(i1, localCameraInfo);
          int i2 = localCameraInfo.facing;
          if (AudioHelper.e())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("openFrontFacingCamera, camIdx[");
            ((StringBuilder)localObject1).append(i1);
            ((StringBuilder)localObject1).append("], facing[");
            ((StringBuilder)localObject1).append(i2);
            ((StringBuilder)localObject1).append("], seq[");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append("]");
            QLog.w("AndroidCamera", 1, ((StringBuilder)localObject1).toString());
          }
          if (i2 != 1) {
            break label471;
          }
          try
          {
            localObject1 = Camera.open(i1);
            StringBuilder localStringBuilder2;
            try
            {
              this.r = i1;
              if (AudioHelper.e())
              {
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("openFrontFacingCamera, c[");
                localStringBuilder2.append(localObject1);
                localStringBuilder2.append("], mCameraId[");
                localStringBuilder2.append(this.r);
                localStringBuilder2.append("], mCameraNum[");
                localStringBuilder2.append(this.m);
                localStringBuilder2.append("], seq[");
                localStringBuilder2.append(paramLong);
                localStringBuilder2.append("]");
                QLog.w("AndroidCamera", 1, localStringBuilder2.toString());
              }
              return localObject1;
            }
            catch (Exception localException1) {}
            localObject2 = localObject4;
          }
          catch (RuntimeException localRuntimeException)
          {
            this.r = 0;
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("openFrontFacingCamera, RuntimeException, seq[");
            localStringBuilder2.append(paramLong);
            localStringBuilder2.append("]");
            QLog.w("AndroidCamera", 1, localStringBuilder2.toString(), localRuntimeException);
          }
        }
        else
        {
          if (!AudioHelper.e()) {
            break label468;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("openFrontFacingCamera, fail, mCameraNum[");
          ((StringBuilder)localObject2).append(this.m);
          ((StringBuilder)localObject2).append("], seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w("AndroidCamera", 1, ((StringBuilder)localObject2).toString());
          return null;
        }
      }
      catch (Exception localException3)
      {
        localObject2 = localException1;
        Exception localException2 = localException3;
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("openFrontFacingCamera, Exception, seq[");
        localStringBuilder1.append(paramLong);
        localStringBuilder1.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder1.toString(), localException2);
      }
      label468:
      return localObject2;
      label471:
      i1 += 1;
    }
  }
  
  @TargetApi(11)
  public boolean b(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    boolean bool2;
    label171:
    label174:
    label219:
    try
    {
      int i1 = this.m;
      bool2 = false;
      bool1 = bool2;
      if (i1 >= 1) {
        if (this.k == null)
        {
          bool1 = bool2;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("switchCamera, mCurCamera[");
          localStringBuilder.append(this.l);
          localStringBuilder.append("], seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder.toString());
          e(paramLong);
          i1 = this.l;
          if (i1 != 1)
          {
            if ((i1 != 2) || (!c(paramLong))) {
              break label171;
            }
            a(paramLong, b, c);
          }
          else
          {
            if (!d(paramLong)) {
              break label171;
            }
            a(paramLong, b, c);
          }
          bool1 = true;
          break label174;
          bool1 = false;
          if (bool1) {}
        }
      }
    }
    finally {}
    try
    {
      if (this.z != null) {
        this.z.a(paramLong, paramSurfaceTexture);
      }
      this.k.setPreviewTexture(paramSurfaceTexture);
      this.k.startPreview();
      bool1 = true;
    }
    catch (Exception paramSurfaceTexture)
    {
      break label219;
    }
    boolean bool1 = bool2;
    if (AudioHelper.e())
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("switchCamera, Exception, seq[");
      paramSurfaceTexture.append(paramLong);
      paramSurfaceTexture.append("]");
      QLog.w("AndroidCamera", 1, paramSurfaceTexture.toString());
      bool1 = bool2;
    }
    if (bool1) {
      QavCameraUsage.a(BaseApplication.getContext(), "switchCamera");
    } else {
      QavCameraUsage.b(BaseApplication.getContext(), "switchCamera");
    }
    return bool1;
  }
  
  protected int c()
  {
    StringBuilder localStringBuilder;
    if (!MobileIssueSettings.h)
    {
      if (AudioHelper.e())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNumberOfCamera, hardcode[");
        localStringBuilder.append(KapalaiAdapterUtil.a().e());
        localStringBuilder.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder.toString());
      }
      return KapalaiAdapterUtil.a().e();
    }
    int i1;
    int i2;
    try
    {
      i1 = Camera.getNumberOfCameras();
      i2 = i1;
      try
      {
        if (!AudioHelper.e()) {
          return i2;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNumberOfCamera, count[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder.toString());
        return i1;
      }
      catch (Exception localException1) {}
      i2 = i1;
    }
    catch (Exception localException2)
    {
      i1 = 1;
    }
    if (AudioHelper.e())
    {
      QLog.w("AndroidCamera", 1, "getNumberOfCamera, Exception", localException2);
      i2 = i1;
    }
    return i2;
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.u;
    }
    return this.v;
  }
  
  protected boolean c(long paramLong)
  {
    h = true;
    this.k = a(paramLong);
    StringBuilder localStringBuilder;
    if (this.k == null)
    {
      if (AudioHelper.e())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("openFrontCamera, fail, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder.toString());
      }
      e = false;
      h = false;
      return false;
    }
    if (this.m == 0) {
      this.m = 2;
    }
    this.l = 1;
    e = true;
    h = false;
    if (AudioHelper.e())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("openFrontCamera, success, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("AndroidCamera", 1, localStringBuilder.toString());
    }
    return true;
  }
  
  protected int d()
  {
    if (a) {
      return 0;
    }
    try
    {
      int i1 = this.q.getRotation();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.w("AndroidCamera", 1, "getDisplayRotation Exception", localException);
    }
    return 0;
  }
  
  protected boolean d(long paramLong)
  {
    boolean bool = e;
    try
    {
      h = true;
      this.k = Camera.open();
      if (AudioHelper.e())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("openBackCamera, camera[");
        localStringBuilder1.append(this.k);
        localStringBuilder1.append("], seq[");
        localStringBuilder1.append(paramLong);
        localStringBuilder1.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder1.toString());
      }
    }
    catch (Exception localException)
    {
      e = false;
      Object localObject = this.k;
      if (localObject != null)
      {
        ((Camera)localObject).release();
        this.k = null;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openBackCamera Exception, set camera null, seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w("AndroidCamera", 1, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openBackCamera Exception, srcIsCameraOpened[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("AndroidCamera", 1, ((StringBuilder)localObject).toString(), localException);
    }
    if (this.k != null)
    {
      this.l = 2;
      e = true;
      h = false;
      o();
      if (AudioHelper.e())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("openBackCamera, success, seq[");
        localStringBuilder2.append(paramLong);
        localStringBuilder2.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder2.toString());
      }
      return true;
    }
    h = false;
    return false;
  }
  
  protected int e()
  {
    return 0;
  }
  
  public boolean e(long paramLong)
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("closeCamera begin, camera[");
      localStringBuilder1.append(toString());
      localStringBuilder1.append("], seq[");
      localStringBuilder1.append(paramLong);
      localStringBuilder1.append("]");
      QLog.w("AndroidCamera", 1, localStringBuilder1.toString());
      try
      {
        if (this.k != null)
        {
          if (e)
          {
            this.k.setPreviewCallbackWithBuffer(null);
            this.k.stopPreview();
            this.k.release();
          }
          if (this.z != null) {
            this.z.b();
          }
          this.k = null;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("closeCamera, set camera null, seq[");
          localStringBuilder1.append(paramLong);
          localStringBuilder1.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder1.toString());
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("closeCamera, Exception, seq[");
        localStringBuilder3.append(paramLong);
        localStringBuilder3.append("]");
        QLog.w("AndroidCamera", 1, localStringBuilder3.toString(), localException);
      }
      e = false;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("closeCamera end, camera[");
      localStringBuilder2.append(toString());
      localStringBuilder2.append("], seq[");
      localStringBuilder2.append(paramLong);
      localStringBuilder2.append("]");
      QLog.w("AndroidCamera", 1, localStringBuilder2.toString());
      QavCameraUsage.b(BaseApplication.getContext(), "closeCamera");
      return true;
    }
    finally {}
  }
  
  protected int f()
  {
    return 0;
  }
  
  public int h()
  {
    if (i.b == -1)
    {
      int i1 = this.l;
      if (i1 == 1) {
        return 270;
      }
      if (i1 == 2) {
        return 90;
      }
    }
    return i.b;
  }
  
  public int i()
  {
    if ((!PhoneStatusTools.d()) && (i.c != -1)) {
      return i.c;
    }
    return 0;
  }
  
  public boolean j()
  {
    int i1 = this.l;
    if (i1 == 0) {
      return true;
    }
    return i1 == 1;
  }
  
  public boolean k()
  {
    return h;
  }
  
  public boolean l()
  {
    return e;
  }
  
  public void m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetCamera, mCurCamera[");
    localStringBuilder.append(this.l);
    localStringBuilder.append("->0]");
    QLog.w("AndroidCamera", 1, localStringBuilder.toString());
    this.l = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCameraOpened[");
    localStringBuilder.append(e);
    localStringBuilder.append("], mCameraId[");
    localStringBuilder.append(this.r);
    localStringBuilder.append("], NUM[");
    localStringBuilder.append(this.m);
    localStringBuilder.append("], CUR[");
    localStringBuilder.append(this.l);
    localStringBuilder.append("], camera[");
    boolean bool;
    if (this.k != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.AndroidCamera
 * JD-Core Version:    0.7.0.1
 */