package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONObject;

class ViolaReportDelegate$1
  implements Runnable
{
  ViolaReportDelegate$1(ViolaReportDelegate paramViolaReportDelegate, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = ReadInJoyHelper.e();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = new JSONObject((String)localObject);; localObject = new JSONObject())
      {
        JSONObject localJSONObject = ViolaReportDelegate.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localJSONObject == null) {
          break;
        }
        ((JSONObject)localObject).put("" + this.jdField_a_of_type_Int, localJSONObject);
        ReadInJoyHelper.h(((JSONObject)localObject).toString());
        ReadInJoyHelper.f(true);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaReportDelegate.jdField_a_of_type_JavaLangString, 2, "cachePageOpenData Exception:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.1
 * JD-Core Version:    0.7.0.1
 */