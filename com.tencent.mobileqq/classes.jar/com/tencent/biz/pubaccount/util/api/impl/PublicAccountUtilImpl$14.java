package com.tencent.biz.pubaccount.util.api.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountUtilImpl$14
  implements Runnable
{
  PublicAccountUtilImpl$14(PublicAccountUtilImpl paramPublicAccountUtilImpl, Uri paramUri, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3) {}
  
  public void run()
  {
    try
    {
      String str2 = this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id");
      int i = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int == 0) {
        i = 100;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
        String str1 = "null";
        if (bool) {
          localObject = "null";
        } else {
          localObject = this.jdField_a_of_type_JavaLangString;
        }
        localJSONObject.put("rowkey", localObject);
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          localObject = str1;
        } else {
          localObject = this.jdField_b_of_type_JavaLangString;
        }
        localJSONObject.put("isfan", localObject);
        Object localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        int j = this.jdField_b_of_type_Int;
        str1 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ((IPublicAccountReportUtils)localObject).publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X8007F1F", "0X8007F1F", j, 0, str2, str1, localStringBuilder.toString(), localJSONObject.toString(), false);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.14
 * JD-Core Version:    0.7.0.1
 */