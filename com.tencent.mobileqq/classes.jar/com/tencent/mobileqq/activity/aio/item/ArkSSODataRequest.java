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
  protected String f;
  protected ArkSSODataRequest.Request g;
  private final WeakReference<AppRuntime> h;
  
  ArkSSODataRequest(AppRuntime paramAppRuntime, String paramString)
  {
    this.h = new WeakReference(paramAppRuntime);
    this.f = paramString;
  }
  
  void a(ArkSSODataRequest.Request paramRequest)
  {
    WeakReference localWeakReference = new WeakReference(this);
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.f, new ArkSSODataRequest.2(this, localWeakReference, paramRequest));
  }
  
  protected void a(ArkSSODataRequest.Request paramRequest, int paramInt, String paramString)
  {
    if (paramRequest != this.g)
    {
      QLog.i("ArkApp.SSODataRequest", 1, String.format("# onComplete, req canceled, ret=%s, rsp=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
      return;
    }
    IArkQualityReport localIArkQualityReport = (IArkQualityReport)QRoute.api(IArkQualityReport.class);
    AppRuntime localAppRuntime = (AppRuntime)this.h.get();
    String str1 = this.f;
    String str2 = paramRequest.a;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localIArkQualityReport.reportAppSSOResult(localAppRuntime, str1, str2, bool, paramRequest.a());
    this.b = paramInt;
    this.d = paramString;
    this.g = null;
    paramRequest = this.e;
    this.e = null;
    if (paramRequest != null) {
      paramRequest.a();
    }
  }
  
  protected boolean a(ArkSSODataRequest.Request paramRequest, int paramInt)
  {
    Object localObject = (AppRuntime)this.h.get();
    if (localObject == null)
    {
      QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, app is null, url=%s, cmd=%s", new Object[] { this.c, paramRequest.a }));
      return false;
    }
    localObject = (IArkService)((AppRuntime)localObject).getRuntimeService(IArkService.class, "all");
    WeakReference localWeakReference = new WeakReference(this);
    ((IArkService)localObject).sendAppMsg(paramRequest.a, paramRequest.b, this.a, 0, new ArkSSODataRequest.1(this, localWeakReference, paramRequest));
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
    if ((this.g == null) && (!TextUtils.isEmpty(this.c)))
    {
      this.g = new ArkSSODataRequest.Request(c(this.c), paramString);
      if (TextUtils.isEmpty(this.g.a))
      {
        QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, cmd is empty, url=%s, reqData=%s", new Object[] { this.c, paramString }));
        a(this.g);
        return true;
      }
      if (!a(this.g, this.a))
      {
        QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, sso.sendAppMsg fail, url=%s, reqData=%s", new Object[] { this.c, paramString }));
        a(this.g);
      }
      return true;
    }
    QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, running url=%s, req=%s", new Object[] { this.c, paramString }));
    return false;
  }
  
  protected String c(String paramString)
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
  
  public void c()
  {
    this.c = null;
    this.b = -1;
    this.d = null;
    this.g = null;
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest
 * JD-Core Version:    0.7.0.1
 */