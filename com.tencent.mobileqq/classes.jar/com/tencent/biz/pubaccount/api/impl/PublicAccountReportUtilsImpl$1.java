package com.tencent.biz.pubaccount.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PublicAccountReportUtilsImpl$1
  implements Runnable
{
  PublicAccountReportUtilsImpl$1(PublicAccountReportUtilsImpl paramPublicAccountReportUtilsImpl, String paramString1, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject = str;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        if (localObject != null) {
          if (!((PublicAccountDataManager)((AppInterface)localObject).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(this.jdField_b_of_type_JavaLangString))) {
            break label140;
          }
        }
        label140:
        for (localObject = "1";; localObject = "0")
        {
          localJSONObject.put("fans", localObject);
          localObject = localJSONObject.toString();
          this.this$0.publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.e, this.f, this.g, (String)localObject, this.jdField_a_of_type_Boolean);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("PublicAccountReportUtils", 2, "doVideoDataReportWithFansInfoInR5() error exception = " + localException.getMessage());
          localObject = str;
          continue;
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountReportUtilsImpl.1
 * JD-Core Version:    0.7.0.1
 */