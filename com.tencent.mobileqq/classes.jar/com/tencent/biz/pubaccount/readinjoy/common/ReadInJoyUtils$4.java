package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import axrl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import noo;
import org.json.JSONObject;

public final class ReadInJoyUtils$4
  implements Runnable
{
  public ReadInJoyUtils$4(HashMap paramHashMap, boolean paramBoolean, Context paramContext, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(" ");
      }
      QLog.d("Q.readinjoy.video", 2, "reportKandianVideoInfo, success =" + this.jdField_a_of_type_Boolean + ", data=" + ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap(this.jdField_a_of_type_JavaUtilHashMap);
    axrl.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, "actKandianVideoWithExtraInfo", this.jdField_a_of_type_Boolean, -1L, 0L, (HashMap)localObject, null);
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("param_speedList")) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_speedList");
      }
      label185:
      axrl.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, "actKandianVideo", this.jdField_a_of_type_Boolean, -1L, 0L, this.jdField_a_of_type_JavaUtilHashMap, null);
      try
      {
        noo.a(null, null, "0X80096D9", "0X80096D9", 0, 0, "", "", "", new JSONObject(this.jdField_a_of_type_JavaUtilHashMap).toString(), false);
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      break label185;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.4
 * JD-Core Version:    0.7.0.1
 */