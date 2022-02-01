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
  public static boolean a;
  public static final float[] a;
  private Context jdField_a_of_type_AndroidContentContext;
  private SensorTrackManager.ARSensorTrackCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager$ARSensorTrackCallback = null;
  private ARSensorManager jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager;
  private SimpleSensorChangeListener jdField_a_of_type_ComTencentMobileqqArmapSensorSimpleSensorChangeListener = new SensorTrackManager.1(this);
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private float[] c = null;
  private float[] d = new float[4];
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(jdField_a_of_type_ArrayOfFloat, 0);
    jdField_a_of_type_Boolean = true;
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
      int i = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsBySimpleStringParser(str, arrayOfString);
      if ((i >= 1) && (Integer.valueOf(arrayOfString[0]).intValue() == 1)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arCfg = ");
      localStringBuilder.append(str);
      localStringBuilder.append(", size = ");
      localStringBuilder.append(i);
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
      if (b()) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  private static boolean b()
  {
    return (Build.MODEL.equalsIgnoreCase("HRY-AL00T")) || (Build.MODEL.equalsIgnoreCase("SM-G955F")) || (Build.MODEL.equalsIgnoreCase("AQM-AL00")) || (Build.MODEL.equalsIgnoreCase("MI CC9 Pro"));
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(Context paramContext, SensorTrackManager.ARSensorTrackCallback paramARSensorTrackCallback)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager$ARSensorTrackCallback = paramARSensorTrackCallback;
    b();
    jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager.b();
    ARReport.a().c(System.currentTimeMillis() - l);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableSensor enabled: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("SensorTrackManager", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager == null) {
      if (a()) {
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager = new ARSensorManager(this.jdField_a_of_type_AndroidContentContext, 5);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager = new ARSensorManager(this.jdField_a_of_type_AndroidContentContext, 4);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SensorTrackManager", 2, "startupSensor");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager.a(this.jdField_a_of_type_ComTencentMobileqqArmapSensorSimpleSensorChangeListener, 1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SensorTrackManager", 2, "stopSensor");
    }
    ARSensorManager localARSensorManager = this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager;
    if (localARSensorManager != null)
    {
      localARSensorManager.a();
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager = null;
    }
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    c();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Boolean = false;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager
 * JD-Core Version:    0.7.0.1
 */