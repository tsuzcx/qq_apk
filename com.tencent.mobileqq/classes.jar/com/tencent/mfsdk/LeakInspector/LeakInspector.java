package com.tencent.mfsdk.LeakInspector;

import abuz;
import abvb;
import abvf;
import android.app.Activity;
import android.os.Environment;
import aztr;
import bdzf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;
import mqq.os.MqqHandler;

public class LeakInspector
{
  private static int jdField_a_of_type_Int = 100;
  private static RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  private static LeakInspector jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector;
  private static boolean jdField_a_of_type_Boolean = true;
  private static boolean b = true;
  private abvf jdField_a_of_type_Abvf;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  private LeakInspector(MqqHandler paramMqqHandler, abvf paramabvf)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Abvf = paramabvf;
  }
  
  private LeakInspector.InspectUUID a(Object paramObject, String paramString)
  {
    LeakInspector.InspectUUID localInspectUUID = (LeakInspector.InspectUUID)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(LeakInspector.InspectUUID.class);
    localInspectUUID.weakObj = new WeakReference(paramObject);
    localInspectUUID.uuid = UUID.randomUUID().toString().toCharArray();
    localInspectUUID.digest = paramString;
    localInspectUUID.classname = paramObject.getClass().getSimpleName();
    return localInspectUUID;
  }
  
  public static void a()
  {
    if ((new File(bdzf.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_02")).exists()) || (new File(bdzf.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists()) || (10 == BaseApplicationImpl.sProcessId)) {}
    for (jdField_a_of_type_Boolean = false; new File(bdzf.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists(); jdField_a_of_type_Boolean = true)
    {
      b = false;
      return;
    }
    b = true;
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, new Object[] { "afterOnDestroy ", paramActivity.getClass().getSimpleName() });
    }
    abvb.b(paramActivity);
    abvb.a(paramActivity);
    abvb.c(paramActivity);
    abvb.b(paramActivity);
    abvb.a(paramActivity);
    abvb.a();
    abvb.d(paramActivity);
    abvb.e(paramActivity);
    if (!MagnifierSDK.a()) {}
    try
    {
      a(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "afterOnDestroy error", paramActivity);
    }
  }
  
  public static void a(Object paramObject)
  {
    a(paramObject, "");
  }
  
  public static void a(Object paramObject, String paramString)
  {
    if (MagnifierSDK.a())
    {
      aztr.a().a(paramObject, paramString);
      return;
    }
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector == null) {
      throw new RuntimeException("Please call initInspector before this");
    }
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.jdField_a_of_type_Abvf == null) {
      throw new RuntimeException("Please init a listener first!");
    }
    jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.b(paramObject, paramString);
  }
  
  public static void a(MqqHandler paramMqqHandler, abvf paramabvf)
  {
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector != null) {
      throw new RuntimeException("Oh man, this only can be called once.");
    }
    jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector = new LeakInspector(paramMqqHandler, paramabvf);
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(LeakInspector.InspectUUID.class, 20);
    a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private void b(Object paramObject, String paramString)
  {
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.jdField_a_of_type_Abvf.a(paramObject)) {}
    for (;;)
    {
      return;
      try
      {
        if (Math.random() < abuz.a)
        {
          paramObject = new LeakInspector.InspectorRunner(this, a(paramObject, paramString), 0);
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(paramObject, 1000L);
          return;
        }
      }
      catch (Exception paramObject)
      {
        QLog.d("LeakInspector", 1, "newInspect ", paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.LeakInspector
 * JD-Core Version:    0.7.0.1
 */