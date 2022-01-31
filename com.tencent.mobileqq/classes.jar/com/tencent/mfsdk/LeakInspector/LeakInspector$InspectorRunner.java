package com.tencent.mfsdk.LeakInspector;

import abvc;
import abvf;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class LeakInspector$InspectorRunner
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private LeakInspector.InspectUUID jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID;
  
  LeakInspector$InspectorRunner(LeakInspector paramLeakInspector, LeakInspector.InspectUUID paramInspectUUID, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID = paramInspectUUID;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, new Object[] { "Inspecting ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), " Time=", Long.valueOf(System.currentTimeMillis()), " count=", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.weakObj.get() == null) {
        return;
      }
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i < LeakInspector.a())
      {
        System.runFinalization();
        Runtime.getRuntime().gc();
        LeakInspector.a(this.this$0).postDelayed(this, 5000L);
        return;
      }
      if (!LeakInspector.a(this.this$0).a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID))
      {
        LeakInspector.a().recycle(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LeakInspector", 2, localThrowable, new Object[] { "error, ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), " Time=", Long.valueOf(System.currentTimeMillis()), " count=", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      LeakInspector.a().recycle(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID);
      return;
    }
    if (!LeakInspector.a())
    {
      Object localObject1 = LeakInspector.a(this.this$0).a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString());
      Object localObject2 = this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString();
      Object[] arrayOfObject = abvc.b((String)localObject2);
      Object localObject3 = (Boolean)arrayOfObject[0];
      String str = "";
      if (((Boolean)localObject3).booleanValue())
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add((String)arrayOfObject[1]);
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          ((List)localObject3).addAll((Collection)localObject1);
        }
        localObject1 = abvc.a((List)localObject3, (String)localObject2);
        localObject3 = (Boolean)localObject1[0];
        str = (String)localObject1[1];
        localObject2 = localObject3;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          QLog.d("LeakInspector", 2, new Object[] { "leakFlag=true,ZipFile=", localObject3, ",leakName=", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), ",dumpPath=", str });
          localObject1 = str;
          localObject2 = localObject3;
        }
      }
      for (;;)
      {
        LeakInspector.a(this.this$0).a(((Boolean)localObject2).booleanValue(), this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), (String)localObject1);
        try
        {
          localObject2 = new JSONObject();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("fileObj1", localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("p_id", MagnifierSDK.a());
          ((JSONObject)localObject1).put("plugin", String.valueOf(7));
          ((JSONObject)localObject2).put("fileObj", localObject3);
          ((JSONObject)localObject2).put("clientinfo", localObject1);
          ((JSONObject)localObject2).put("newplugin", 107);
          ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject2, true, true, MagnifierSDK.a));
          QLog.d("LeakInspector", 1, new Object[] { "inspect ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), " leaked" });
          return;
          localObject2 = localObject3;
          localObject1 = str;
          if (QLog.isColorLevel())
          {
            QLog.e("LeakInspector", 2, new Object[] { "generateHprof error ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString() });
            localObject2 = localObject3;
            localObject1 = str;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("LeakInspector", 2, localJSONException, new Object[0]);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.LeakInspector.InspectorRunner
 * JD-Core Version:    0.7.0.1
 */