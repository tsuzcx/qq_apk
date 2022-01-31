package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bhvy;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import rwt;

public class ViolaReportDelegate$1
  implements Runnable
{
  public ViolaReportDelegate$1(rwt paramrwt, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = bhvy.c();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = new JSONObject((String)localObject);; localObject = new JSONObject())
      {
        JSONObject localJSONObject = rwt.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localJSONObject == null) {
          break;
        }
        ((JSONObject)localObject).put("" + this.jdField_a_of_type_Int, localJSONObject);
        bhvy.h(((JSONObject)localObject).toString());
        bhvy.f(true);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(rwt.jdField_a_of_type_JavaLangString, 2, "cachePageOpenData Exception:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.1
 * JD-Core Version:    0.7.0.1
 */