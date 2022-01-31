package com.tencent.av.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.utils.ClassLoaderUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import java.util.Map;
import jgs;
import mqq.app.MobileQQ;

public class GCameraAvailabilityMonitor
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  private Map jdField_a_of_type_JavaUtilMap;
  private jgs jdField_a_of_type_Jgs;
  
  public GCameraAvailabilityMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public Map a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    DexClassLoader localDexClassLoader = ClassLoaderUtil.a();
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if (this.jdField_a_of_type_Jgs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change receiver");
      }
      this.jdField_a_of_type_Jgs = new jgs(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.qav.camera.availability");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_Jgs, (IntentFilter)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change callback");
    }
    this.jdField_a_of_type_JavaLangObject = ClassLoaderUtil.a(localDexClassLoader, "com.tencent.av.camera2.CameraManagerWrapper");
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext();
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName();
    ClassLoaderUtil.a(localDexClassLoader, localObject, "registerAvailabilityCb", new Class[] { Context.class, String.class, Handler.class }, new Object[] { localContext, str, null });
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Jgs != null) {
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change receiver");
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_Jgs);
        this.jdField_a_of_type_Jgs = null;
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change callback");
        }
        if (this.jdField_a_of_type_JavaLangObject == null) {
          continue;
        }
        ClassLoaderUtil.a(ClassLoaderUtil.a(), this.jdField_a_of_type_JavaLangObject, "unRegisterAvailabilityCb", null, null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("GCameraAvailabilityMonitor", 2, "regist e = " + localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.app.GCameraAvailabilityMonitor
 * JD-Core Version:    0.7.0.1
 */