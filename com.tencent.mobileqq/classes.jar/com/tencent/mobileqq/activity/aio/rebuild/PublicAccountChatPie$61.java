package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountChatPie$61
  implements View.OnClickListener
{
  PublicAccountChatPie$61(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mQidianClickListener ... mQidianKefu = ");
      localStringBuilder.append(this.a.cD);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.a.s(2131893010);
    this.a.bi.requestQidiKefu(this.a.f, this.a.ah.b, this.a.cx, this.a.cy, this.a.cz, new PublicAccountChatPie.61.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.61
 * JD-Core Version:    0.7.0.1
 */