package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class SensorTrackManager
{
  public static final float[] a = new float[16];
  public static boolean b = true;
  private ARSensorManager c;
  private Context d;
  private ReentrantLock e = new ReentrantLock();
  private boolean f = false;
  private SensorTrackManager.ARSensorTrackCallback g = null;
  private float[] h = new float[16];
  private float[] i = null;
  private SimpleSensorChangeListener j = new SensorTrackManager.1(this);
  private float[] k = new float[4];
  
  static
  {
    Matrix.setIdentityM(a, 0);
  }
  
  public static boolean a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.ARCfg.name());
    boolean bool1 = TextUtils.isEmpty(str);
    boolean bool2 = true;
    if (!bool1)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "";
      int m = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsBySimpleStringParser(str, arrayOfString);
      if ((m >= 1) && (Integer.valueOf(arrayOfString[0]).intValue() == 1)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arCfg = ");
      localStringBuilder.append(str);
      localStringBuilder.append(", size = ");
      localStringBuilder.append(m);
      localStringBuilder.append(", params[0] = ");
      localStringBuilder.append(arrayOfString[0]);
      localStringBuilder.append(", isUseGameRotationVector = ");
      localStringBuilder.append(bool1);
      QLog.i("AREngine_SensorTrackManager", 1, localStringBuilder.toString());
    }
    else
    {
      bool1 = false;
    }
    if (!bool1)
    {
      if (g()) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  private static boolean g()
  {
    return (Build.MODEL.equalsIgnoreCase("HRY-AL00T")) || (Build.MODEL.equalsIgnoreCase("SM-G955F")) || (Build.MODEL.equalsIgnoreCase("AQM-AL00")) || (Build.MODEL.equalsIgnoreCase("MI CC9 Pro"));
  }
  
  public void a(Context paramContext, SensorTrackManager.ARSensorTrackCallback paramARSensorTrackCallback)
  {
    long l = System.currentTimeMillis();
    this.d = paramContext;
    this.g = paramARSensorTrackCallback;
    c();
    b = this.c.c();
    ARReport.a().c(System.currentTimeMillis() - l);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableSensor enabled: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("SensorTrackManager", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    a(true);
  }
  
  public void c()
  {
    if (this.c == null) {
      if (a()) {
        this.c = new ARSensorManager(this.d, 5);
      } else {
        this.c = new ARSensorManager(this.d, 4);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SensorTrackManager", 2, "startupSensor");
    }
    this.c.a(this.j, 1);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SensorTrackManager", 2, "stopSensor");
    }
    ARSensorManager localARSensorManager = this.c;
    if (localARSensorManager != null)
    {
      localARSensorManager.b();
      this.c = null;
    }
  }
  
  public void e()
  {
    a(false);
  }
  
  public void f()
  {
    d();
    this.d = null;
    this.f = false;
    this.i = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager
 * JD-Core Version:    0.7.0.1
 */