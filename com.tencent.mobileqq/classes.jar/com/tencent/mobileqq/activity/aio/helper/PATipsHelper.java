package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;

public class PATipsHelper
  extends TipsHelper
{
  public PATipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    PubAccountTips localPubAccountTips = new PubAccountTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localPubAccountTips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PATipsHelper
 * JD-Core Version:    0.7.0.1
 */