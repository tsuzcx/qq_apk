package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public static long a;
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_Long = 1800L;
  }
  
  public AdMaterialHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    oidb_0x6cf.ReqAdvertisePara localReqAdvertisePara = new oidb_0x6cf.ReqAdvertisePara();
    oidb_0x885.AdReqInfo localAdReqInfo = new oidb_0x885.AdReqInfo();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() != 0L)) {
      localReqBody.uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    }
    try
    {
      localAdReqInfo.int32_req_type.set(3);
      localReqAdvertisePara.msg_ad_req_info.set(localAdReqInfo);
      localReqAdvertisePara.msg_phone_info.set(AdDeviceInfoUtil.a());
      localReqBody.req_advertise_para.set(localReqAdvertisePara);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new AdMaterialHandler.1(this), localReqBody.toByteArray(), "OidbSvc.0x6cf", 1743, 0, new Bundle(), 6000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialHandler", 2, "Exception error" + QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return AdMaterialObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialHandler
 * JD-Core Version:    0.7.0.1
 */