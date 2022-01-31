package com.tencent.mobileqq.Doraemon.impl.webview;

import aado;
import android.util.LruCache;
import asiu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import mqq.app.AppRuntime;
import mxi;
import tencent.im.oidb.oidb_0xb60.CheckUrlReq;
import tencent.im.oidb.oidb_0xb60.ReqBody;

public class VerifyUrlJobSegment
  extends JobSegment<asiu, asiu>
{
  public static LruCache<String, Long> a;
  public String a;
  
  static
  {
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(16);
  }
  
  public VerifyUrlJobSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, asiu paramasiu)
  {
    paramJobContext = paramasiu.h + '_' + this.jdField_a_of_type_JavaLangString;
    Object localObject = (Long)jdField_a_of_type_AndroidUtilLruCache.get(paramJobContext);
    if ((localObject != null) && (((Long)localObject).longValue() > NetConnInfoCenter.getServerTimeMillis()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "cache hit");
      }
      notifyResult(paramasiu);
    }
    do
    {
      do
      {
        return;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null) {
          break;
        }
        notifyError(new AppInfoError(7, "jobVerifyUrl app is null"));
      } while (!QLog.isColorLevel());
      QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "app is null");
      return;
      try
      {
        int i = Integer.parseInt(paramasiu.jdField_a_of_type_JavaLangString);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.check_url_req.setHasFlag(true);
        localReqBody.check_url_req.url.set(this.jdField_a_of_type_JavaLangString);
        localReqBody.check_url_req.appid.set(i);
        localReqBody.check_url_req.app_type.set(paramasiu.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "send type=" + paramasiu.jdField_a_of_type_Int + ", appid=" + paramasiu.jdField_a_of_type_JavaLangString + ", url=" + this.jdField_a_of_type_JavaLangString);
        }
        mxi.a((AppRuntime)localObject, new aado(this, paramasiu, paramJobContext), localReqBody.toByteArray(), "OidbSvc.0xb60_2", 2912, 2, null, 0L);
        return;
      }
      catch (NumberFormatException paramJobContext)
      {
        notifyError(new AppInfoError(7, "jobVerifyUrl parse appid error"));
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "parse appid error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment
 * JD-Core Version:    0.7.0.1
 */