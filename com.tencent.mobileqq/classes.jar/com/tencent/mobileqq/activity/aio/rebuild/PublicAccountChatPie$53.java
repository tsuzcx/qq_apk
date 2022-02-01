package com.tencent.mobileqq.activity.aio.rebuild;

import android.widget.ImageView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class PublicAccountChatPie$53
  extends EcShopObserver
{
  PublicAccountChatPie$53(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (PublicAccountChatPie.D(this.a).getVisibility() != 0))
    {
      if (AIOTopRightButtonConfig.a().b(this.a.d.getCurrentAccountUin()))
      {
        PublicAccountChatPie.E(this.a).setVisibility(0);
        PublicAccountChatPie.F(this.a).setOnClickListener(this.a);
        this.a.p.setRight2Icon(2130848971, 2130848972);
        return;
      }
      PublicAccountChatPie.G(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.53
 * JD-Core Version:    0.7.0.1
 */