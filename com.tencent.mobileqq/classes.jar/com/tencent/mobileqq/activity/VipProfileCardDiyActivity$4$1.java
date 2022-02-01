package com.tencent.mobileqq.activity;

import aest;
import bjng;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class VipProfileCardDiyActivity$4$1
  implements Runnable
{
  public VipProfileCardDiyActivity$4$1(aest paramaest, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aest.a.a((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet)) {
      this.jdField_a_of_type_Aest.a.a.sendEmptyMessage(0);
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "0", String.valueOf(this.jdField_a_of_type_Aest.a.j));
      return;
      this.jdField_a_of_type_Aest.a.a.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */