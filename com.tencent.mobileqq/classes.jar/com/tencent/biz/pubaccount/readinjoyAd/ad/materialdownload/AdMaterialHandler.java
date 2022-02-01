package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo;

public class AdMaterialHandler
  extends BusinessHandler
{
  public static long a = 1800L;
  private QQAppInterface a;
  
  public AdMaterialHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public void a()
  {
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    oidb_0x6cf.ReqAdvertisePara localReqAdvertisePara = new oidb_0x6cf.ReqAdvertisePara();
    Object localObject = new oidb_0x885.AdReqInfo();
    QQAppInterface localQQAppInterface = this.a;
    if ((localQQAppInterface != null) && (localQQAppInterface.getLongAccountUin() != 0L))
    {
      localReqBody.uint64_uin.set(this.a.getLongAccountUin());
      try
      {
        ((oidb_0x885.AdReqInfo)localObject).int32_req_type.set(3);
        localReqAdvertisePara.msg_ad_req_info.set((MessageMicro)localObject);
        localReqAdvertisePara.msg_phone_info.set(AdDeviceInfoUtil.a());
        localReqBody.req_advertise_para.set(localReqAdvertisePara);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Exception error");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(localException));
          QLog.d("AdMaterialHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
      ProtoUtils.a(this.a, new AdMaterialHandler.1(this), localReqBody.toByteArray(), "OidbSvc.0x6cf", 1743, 0, new Bundle(), 6000L);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AdMaterialObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialHandler
 * JD-Core Version:    0.7.0.1
 */