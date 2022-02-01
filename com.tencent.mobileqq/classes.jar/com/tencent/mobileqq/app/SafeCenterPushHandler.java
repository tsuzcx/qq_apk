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
import com.tencent.mqpsdk.secsrv.MQPAPPScanService;
import com.tencent.mqpsdk.secsrv.MQPIntChkService;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.sfcfg.QPTxVerifyApkTimerTask;
import tencent.im.s2c.msgtype0x210.submsgtype0x4a.MsgBody;

public class SafeCenterPushHandler
  extends BusinessHandler
{
  public static int a;
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  SafeCenterPushHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new MsgBody();
    do
    {
      try
      {
        ((MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if ((!((MsgBody)localObject).has()) || (!((MsgBody)localObject).uint32_sec_cmd.has())) {
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("SafeCenterPushHandler", 2, "onReceive: onReceive push package: msgbody parse fail");
                  }
                  paramArrayOfByte.printStackTrace();
                }
                switch (((MsgBody)localObject).uint32_sec_cmd.get())
                {
                case 5: 
                default: 
                  return;
                case 1: 
                  new m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
                  return;
                case 2: 
                  paramArrayOfByte = (MSFNetTransportProvider)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSF_NET_TRANSPORT_PROVIDER_HANDLER);
                  paramArrayOfByte = new MQPSecServiceManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramArrayOfByte);
                }
              } while (paramArrayOfByte == null);
              paramArrayOfByte = (MQPIntChkService)paramArrayOfByte.a("intchk");
            } while (paramArrayOfByte == null);
            paramArrayOfByte.a(1, new MSFIntChkStrike(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1));
            paramArrayOfByte.a(2, new MSFIntChkStrike(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2));
            paramArrayOfByte.a(3, new MSFIntChkStrike(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3));
            paramArrayOfByte.b("8.5.5." + AppSetting.g());
            return;
            paramArrayOfByte = (MSFNetTransportProvider)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSF_NET_TRANSPORT_PROVIDER_HANDLER);
            paramArrayOfByte = new MQPSecServiceManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramArrayOfByte);
          } while (paramArrayOfByte == null);
          paramArrayOfByte = (MQPAPPScanService)paramArrayOfByte.a("app_scan");
        } while (paramArrayOfByte == null);
        paramArrayOfByte.a(((MsgBody)localObject).bytes_data.get().toByteArray());
        return;
        localObject = ((MsgBody)localObject).bytes_data.get().toByteArray();
        paramArrayOfByte = new AccountSecurityInfo.SecCheckBanner();
        try
        {
          paramArrayOfByte.mergeFrom((byte[])localObject);
          localObject = paramArrayOfByte.str_wording.get();
          int i = paramArrayOfByte.u32_timeToShow.get();
          paramArrayOfByte = new Intent();
          paramArrayOfByte.putExtra("wording", (String)localObject);
          paramArrayOfByte.putExtra("timetowait", i);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setSecDetBannerIntent(paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
        new QPTxVerifyApkTimerTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true).a();
        return;
      }
    } while (localInvalidProtocolBufferMicroException.bytes_data.get() == null);
    QSecFramework.a().a(localInvalidProtocolBufferMicroException.bytes_data.get().toByteArray());
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SafeCenterPushHandler
 * JD-Core Version:    0.7.0.1
 */