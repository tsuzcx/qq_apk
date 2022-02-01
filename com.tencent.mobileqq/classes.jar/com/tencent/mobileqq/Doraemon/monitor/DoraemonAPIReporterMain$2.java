package com.tencent.mobileqq.Doraemon.monitor;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb6f.Identity;
import tencent.im.oidb.oidb_0xb6f.ReportFreqRspBody;
import tencent.im.oidb.oidb_0xb6f.RspBody;

class DoraemonAPIReporterMain$2
  extends ProtoUtils.TroopProtocolObserver
{
  DoraemonAPIReporterMain$2(DoraemonAPIReporterMain paramDoraemonAPIReporterMain, String paramString1, String paramString2, int paramInt) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onResult key=");
      paramBundle.append(this.a);
      paramBundle.append(", api=");
      paramBundle.append(this.b);
      paramBundle.append(", count=");
      paramBundle.append(this.c);
      paramBundle.append(", code=");
      paramBundle.append(paramInt);
      QLog.i("DoraemonOpenAPI.report", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xb6f.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.report_freq_rsp.has())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("DoraemonOpenAPI.report", 2, "rsp invalid");
          return;
        }
        DoraemonAPIReporterMain.a(this.d, this.a, paramBundle.report_freq_rsp.identity.apptype.get(), String.valueOf(paramBundle.report_freq_rsp.identity.appid.get()), paramBundle.report_freq_rsp.identity.apiName.get(), paramBundle.report_freq_rsp.remain_times.get(), 1000L * paramBundle.report_freq_rsp.expire_time.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.report", 2, "parse rsp error", paramArrayOfByte);
        }
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.report", 2, "req error");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.2
 * JD-Core Version:    0.7.0.1
 */