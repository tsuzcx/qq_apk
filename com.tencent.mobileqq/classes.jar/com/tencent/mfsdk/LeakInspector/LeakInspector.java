package com.tencent.mfsdk.LeakInspector;

import aknz;
import android.app.Activity;
import android.os.Environment;
import bbvj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;
import mqq.os.MqqHandler;
import zzp;
import zzt;

public class LeakInspector
{
  private static int jdField_a_of_type_Int = 100;
  private static RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  private static LeakInspector jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector;
  private static boolean jdField_a_of_type_Boolean = true;
  private static boolean b = true;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private zzt jdField_a_of_type_Zzt;
  
  private LeakInspector(MqqHandler paramMqqHandler, zzt paramzzt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Zzt = paramzzt;
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
  
  public static LeakInspector a()
  {
    return jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector;
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, new Object[] { "afterOnDestroy ", paramActivity.getClass().getSimpleName() });
    }
    zzp.b(paramActivity);
    zzp.a(paramActivity);
    zzp.c(paramActivity);
    zzp.b(paramActivity);
    zzp.a(paramActivity);
    zzp.a();
    zzp.d(paramActivity);
    zzp.e(paramActivity);
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
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector == null) {
      throw new RuntimeException("Please call initInspector before this");
    }
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.jdField_a_of_type_Zzt == null) {
      throw new RuntimeException("Please init a listener first!");
    }
    jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.b(paramObject, paramString);
  }
  
  public static void a(MqqHandler paramMqqHandler, zzt paramzzt)
  {
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector != null) {
      throw new RuntimeException("Oh man, this only can be called once.");
    }
    jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector = new LeakInspector(paramMqqHandler, paramzzt);
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(LeakInspector.InspectUUID.class, 20);
    if ((new File(bbvj.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_02")).exists()) || (new File(bbvj.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists()) || (10 == BaseApplicationImpl.sProcessId)) {}
    for (jdField_a_of_type_Boolean = false; new File(bbvj.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists(); jdField_a_of_type_Boolean = true)
    {
      b = false;
      return;
    }
    b = true;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private void b(Object paramObject, String paramString)
  {
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.jdField_a_of_type_Zzt.a(paramObject)) {}
    while (!aknz.a().jdField_a_of_type_Boolean) {
      return;
    }
    paramObject = new LeakInspector.InspectorRunner(this, a(paramObject, paramString), 0);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(paramObject, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.LeakInspector
 * JD-Core Version:    0.7.0.1
 */