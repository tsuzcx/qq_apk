package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bmhv;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tut;

public class ViolaReportDelegate$1
  implements Runnable
{
  public ViolaReportDelegate$1(tut paramtut, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = bmhv.d();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = new JSONObject((String)localObject);; localObject = new JSONObject())
      {
        JSONObject localJSONObject = tut.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localJSONObject == null) {
          break;
        }
        ((JSONObject)localObject).put("" + this.jdField_a_of_type_Int, localJSONObject);
        bmhv.h(((JSONObject)localObject).toString());
        bmhv.f(true);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(tut.jdField_a_of_type_JavaLangString, 2, "cachePageOpenData Exception:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.1
 * JD-Core Version:    0.7.0.1
 */