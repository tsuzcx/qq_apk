package com.tencent.mobileqq.Doraemon.impl.webview;

import android.util.LruCache;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0xb60.CheckUrlReq;
import tencent.im.oidb.oidb_0xb60.ReqBody;

public class VerifyUrlJobSegment
  extends JobSegment<MiniAppInfo, MiniAppInfo>
{
  static LruCache<String, Long> a = new LruCache(16);
  String b;
  
  public VerifyUrlJobSegment(String paramString)
  {
    this.b = paramString;
  }
  
  protected void a(JobContext paramJobContext, MiniAppInfo paramMiniAppInfo)
  {
    paramJobContext = new StringBuilder();
    paramJobContext.append(paramMiniAppInfo.p);
    paramJobContext.append('_');
    paramJobContext.append(this.b);
    paramJobContext = paramJobContext.toString();
    Object localObject = (Long)a.get(paramJobContext);
    if ((localObject != null) && (((Long)localObject).longValue() > NetConnInfoCenter.getServerTimeMillis()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "cache hit");
      }
      notifyResult(paramMiniAppInfo);
      return;
    }
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null)
    {
      notifyError(new AppInfoError(7, "jobVerifyUrl app is null"));
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "app is null");
      }
      return;
    }
    try
    {
      int i = Integer.parseInt(paramMiniAppInfo.a);
      oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
      localReqBody.check_url_req.setHasFlag(true);
      localReqBody.check_url_req.url.set(this.b);
      localReqBody.check_url_req.appid.set(i);
      localReqBody.check_url_req.app_type.set(paramMiniAppInfo.b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send type=");
        localStringBuilder.append(paramMiniAppInfo.b);
        localStringBuilder.append(", appid=");
        localStringBuilder.append(paramMiniAppInfo.a);
        localStringBuilder.append(", url=");
        localStringBuilder.append(this.b);
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, localStringBuilder.toString());
      }
      ProtoUtils.a((AppRuntime)localObject, new VerifyUrlJobSegment.1(this, paramMiniAppInfo, paramJobContext), localReqBody.toByteArray(), "OidbSvc.0xb60_2", 2912, 2, null, 0L);
      return;
    }
    catch (NumberFormatException paramJobContext)
    {
      label308:
      break label308;
    }
    notifyError(new AppInfoError(7, "jobVerifyUrl parse appid error"));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "parse appid error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment
 * JD-Core Version:    0.7.0.1
 */