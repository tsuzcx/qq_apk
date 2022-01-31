package com.tencent.mobileqq.app;

import VIP.AIOKeyWordReq;
import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPAioSendHandler
  extends BusinessHandler
{
  public static int a;
  public static String a;
  public static String b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "AIOSendSvc.CheckPopGrayStips";
    jdField_b_of_type_JavaLangString = "AIOSendSvc.getUserKeyWordStips";
  }
  
  protected VIPAioSendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return VIPAioSendObserver.class;
  }
  
  public void a(AIOSendReq paramAIOSendReq)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramAIOSendReq);
    super.a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      a(jdField_a_of_type_Int, false, null);
      return;
    }
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    if (jdField_a_of_type_JavaLangString.equals(paramToServiceMsg))
    {
      paramToServiceMsg = (AIOSendRes)paramObject;
      AioVipDonateHelper.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
    }
    for (;;)
    {
      a(jdField_a_of_type_Int, true, paramObject);
      return;
      if (jdField_b_of_type_JavaLangString.equals(paramToServiceMsg))
      {
        paramToServiceMsg = (AIOSendRes)paramObject;
        AioVipKeywordHelper.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = new AIOKeyWordReq(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), jdField_b_of_type_JavaLangString);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramString);
    super.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.VIPAioSendHandler
 * JD-Core Version:    0.7.0.1
 */