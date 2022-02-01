package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyContext;
import com.tencent.mobileqq.activity.aio.tips.NearbyMarketGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;

public class NearbyTipsHelper
  extends TipsHelper
{
  public NearbyTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    if (((NearbyContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).k()) {
      return;
    }
    super.a();
    NearbyMarketGrayTips localNearbyMarketGrayTips = new NearbyMarketGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
    localNearbyMarketGrayTips.a(((NearbyContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).f());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localNearbyMarketGrayTips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyTipsHelper
 * JD-Core Version:    0.7.0.1
 */