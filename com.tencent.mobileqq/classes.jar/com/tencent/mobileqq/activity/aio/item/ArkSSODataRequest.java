package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.api.IArkQualityReport;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class ArkSSODataRequest
  extends ArkDataRequest
{
  protected ArkSSODataRequest.Request a;
  private final WeakReference<AppRuntime> a;
  protected String c;
  
  ArkSSODataRequest(AppRuntime paramAppRuntime, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    this.c = paramString;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.length() < 6) {
      return null;
    }
    if (!paramString.substring(0, 6).equalsIgnoreCase("sso://")) {
      return null;
    }
    int i = paramString.indexOf('/', 6);
    if (i == -1) {
      return paramString.substring(6);
    }
    return paramString.substring(6, i);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request = null;
    a(null);
  }
  
  void a(ArkSSODataRequest.Request paramRequest)
  {
    WeakReference localWeakReference = new WeakReference(this);
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.c, new ArkSSODataRequest.2(this, localWeakReference, paramRequest));
  }
  
  protected void a(ArkSSODataRequest.Request paramRequest, int paramInt, String paramString)
  {
    if (paramRequest != this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request)
    {
      QLog.i("ArkApp.SSODataRequest", 1, String.format("# onComplete, req canceled, ret=%s, rsp=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
      return;
    }
    IArkQualityReport localIArkQualityReport = (IArkQualityReport)QRoute.api(IArkQualityReport.class);
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str1 = this.c;
    String str2 = paramRequest.jdField_a_of_type_JavaLangString;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localIArkQualityReport.reportAppSSOResult(localAppRuntime, str1, str2, bool, paramRequest.a());
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request = null;
    paramRequest = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest$IDataRequestCallback;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest$IDataRequestCallback = null;
    if (paramRequest != null) {
      paramRequest.a();
    }
  }
  
  protected boolean a(ArkSSODataRequest.Request paramRequest, int paramInt)
  {
    Object localObject = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, app is null, url=%s, cmd=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramRequest.jdField_a_of_type_JavaLangString }));
      return false;
    }
    localObject = (IArkService)((AppRuntime)localObject).getRuntimeService(IArkService.class, "all");
    WeakReference localWeakReference = new WeakReference(this);
    ((IArkService)localObject).sendAppMsg(paramRequest.jdField_a_of_type_JavaLangString, paramRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, 0, new ArkSSODataRequest.1(this, localWeakReference, paramRequest));
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (!super.a(paramString))
    {
      QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to open, url=%s", new Object[] { paramString }));
      return false;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request = new ArkSSODataRequest.Request(a(this.jdField_a_of_type_JavaLangString), paramString);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request.jdField_a_of_type_JavaLangString))
      {
        QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, cmd is empty, url=%s, reqData=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString }));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request);
        return true;
      }
      if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request, this.jdField_a_of_type_Int))
      {
        QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, sso.sendAppMsg fail, url=%s, reqData=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString }));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkSSODataRequest$Request);
      }
      return true;
    }
    QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, running url=%s, req=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest
 * JD-Core Version:    0.7.0.1
 */