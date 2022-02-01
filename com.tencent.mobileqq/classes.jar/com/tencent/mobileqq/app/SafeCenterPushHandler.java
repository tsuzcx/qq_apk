package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.ctsz.m;
import com.tencent.ims.AccountSecurityInfo.SecCheckBanner;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.secsrv.MQPIntChkService;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.sfcfg.QPTxVerifyApkTimerTask;
import tencent.im.s2c.msgtype0x210.submsgtype0x4a.MsgBody;

public class SafeCenterPushHandler
{
  public static int a;
  private QQAppInterface a;
  
  public SafeCenterPushHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject1 = new MsgBody();
    try
    {
      ((MsgBody)localObject1).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SafeCenterPushHandler", 2, "onReceive: onReceive push package: msgbody parse fail");
      }
      paramArrayOfByte.printStackTrace();
    }
    if (((MsgBody)localObject1).has())
    {
      if (!((MsgBody)localObject1).uint32_sec_cmd.has()) {
        return;
      }
      int i = ((MsgBody)localObject1).uint32_sec_cmd.get();
      if (i != 1)
      {
        Object localObject2;
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 6)
            {
              if (i != 7) {
                return;
              }
              if (((MsgBody)localObject1).bytes_data.get() != null) {
                QSecFramework.a().a(((MsgBody)localObject1).bytes_data.get().toByteArray());
              }
            }
            else
            {
              new QPTxVerifyApkTimerTask(this.a, true).a();
            }
          }
          else
          {
            localObject1 = ((MsgBody)localObject1).bytes_data.get().toByteArray();
            paramArrayOfByte = new AccountSecurityInfo.SecCheckBanner();
            try
            {
              paramArrayOfByte.mergeFrom((byte[])localObject1);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
            localObject2 = paramArrayOfByte.str_wording.get();
            i = paramArrayOfByte.u32_timeToShow.get();
            paramArrayOfByte = new Intent();
            paramArrayOfByte.putExtra("wording", (String)localObject2);
            paramArrayOfByte.putExtra("timetowait", i);
            this.a.setSecDetBannerIntent(paramArrayOfByte);
          }
        }
        else
        {
          paramArrayOfByte = (MSFNetTransportProvider)this.a.getBusinessHandler(BusinessHandlerFactory.MSF_NET_TRANSPORT_PROVIDER_HANDLER);
          paramArrayOfByte = (MQPIntChkService)new MQPSecServiceManager(this.a.getApp().getApplicationContext(), paramArrayOfByte).a("intchk");
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte.a(1, new MSFIntChkStrike(this.a, 1));
            paramArrayOfByte.a(2, new MSFIntChkStrike(this.a, 2));
            paramArrayOfByte.a(3, new MSFIntChkStrike(this.a, 3));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("8.7.0.");
            ((StringBuilder)localObject2).append(AppSetting.g());
            paramArrayOfByte.b(((StringBuilder)localObject2).toString());
          }
        }
      }
      else
      {
        new m(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SafeCenterPushHandler
 * JD-Core Version:    0.7.0.1
 */