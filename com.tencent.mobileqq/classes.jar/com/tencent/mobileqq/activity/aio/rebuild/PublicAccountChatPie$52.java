package com.tencent.mobileqq.activity.aio.rebuild;

import android.widget.ImageView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class PublicAccountChatPie$52
  extends EcShopObserver
{
  PublicAccountChatPie$52(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (PublicAccountChatPie.a(this.a).getVisibility() != 0))
    {
      if (AIOTopRightButtonConfig.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        PublicAccountChatPie.b(this.a).setVisibility(0);
        PublicAccountChatPie.c(this.a).setOnClickListener(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130847451, 2130847452);
      }
    }
    else {
      return;
    }
    PublicAccountChatPie.d(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.52
 * JD-Core Version:    0.7.0.1
 */