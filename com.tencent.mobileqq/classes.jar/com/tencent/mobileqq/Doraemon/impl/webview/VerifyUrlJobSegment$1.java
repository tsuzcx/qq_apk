package com.tencent.mobileqq.Doraemon.impl.webview;

import android.os.Bundle;
import android.util.LruCache;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb60.CheckUrlRsp;
import tencent.im.oidb.oidb_0xb60.RspBody;

class VerifyUrlJobSegment$1
  extends ProtoUtils.TroopProtocolObserver
{
  VerifyUrlJobSegment$1(VerifyUrlJobSegment paramVerifyUrlJobSegment, MiniAppInfo paramMiniAppInfo, String paramString) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onResult type=");
      paramBundle.append(this.a.b);
      paramBundle.append(", appid=");
      paramBundle.append(this.a.a);
      paramBundle.append(", url=");
      paramBundle.append(this.c.b);
      paramBundle.append(", code=");
      paramBundle.append(paramInt);
      QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xb60.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.check_url_rsp.has())
        {
          VerifyUrlJobSegment.b(this.c, new AppInfoError(7, "jobVerifyUrl rsp invalid"));
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "rsp invalid");
          return;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("receive is_auth:");
          paramArrayOfByte.append(paramBundle.check_url_rsp.is_authed.get());
          paramArrayOfByte.append(", duration:");
          paramArrayOfByte.append(paramBundle.check_url_rsp.next_req_duration.get());
          QLog.d("DoraemonOpenAPI.jobVerifyUrl", 2, paramArrayOfByte.toString());
        }
        if (paramBundle.check_url_rsp.is_authed.get())
        {
          VerifyUrlJobSegment.a.put(this.b, Long.valueOf(NetConnInfoCenter.getServerTimeMillis() + paramBundle.check_url_rsp.next_req_duration.get() * 1000L));
          VerifyUrlJobSegment.a(this.c, this.a);
          return;
        }
        VerifyUrlJobSegment.c(this.c, new VerifyUrlJobSegment.UrlNotauthorizedError());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        VerifyUrlJobSegment.d(this.c, new AppInfoError(7, "jobVerifyUrl parse rsp error"));
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "parse rsp error", paramArrayOfByte);
        }
        return;
      }
    }
    else
    {
      paramBundle = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jobVerifyUrl req error ");
      localStringBuilder.append(paramInt);
      VerifyUrlJobSegment.a(paramBundle, new AppInfoError(7, localStringBuilder.toString()));
      if ((!QLog.isColorLevel()) || (paramArrayOfByte != null)) {}
      try
      {
        paramBundle = ((oidb_0xb60.RspBody)new oidb_0xb60.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        label419:
        break label419;
      }
      paramBundle = "";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("req error code=");
      localStringBuilder.append(paramInt);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = ", data=null";
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(", msg=");
        paramArrayOfByte.append(paramBundle);
        paramArrayOfByte = paramArrayOfByte.toString();
      }
      localStringBuilder.append(paramArrayOfByte);
      QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, localStringBuilder.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment.1
 * JD-Core Version:    0.7.0.1
 */