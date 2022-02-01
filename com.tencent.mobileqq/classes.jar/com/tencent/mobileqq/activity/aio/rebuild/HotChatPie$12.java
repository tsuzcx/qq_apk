package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HotChatPie$12
  implements View.OnClickListener
{
  HotChatPie$12(HotChatPie paramHotChatPie, String paramString) {}
  
  public void onClick(View paramView)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.b.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(this.a);
    this.b.bV.handleShare(localHotChatInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.12
 * JD-Core Version:    0.7.0.1
 */