package com.tencent.biz.pubaccount.readinjoy.common;

import axrl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public final class ReadInJoyUtils$7
  implements Runnable
{
  public ReadInJoyUtils$7(JSONObject paramJSONObject, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_OrgJsonJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, this.jdField_a_of_type_OrgJsonJSONObject.optString(str));
      }
      axrl.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication()).a(null, "actKanDianViolaPageDataNew", this.jdField_a_of_type_Boolean, -1L, -1L, localException, null, true);
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyUtils", 2, "reportViolaPageProcessNew , error : " + localException.getMessage());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.7
 * JD-Core Version:    0.7.0.1
 */