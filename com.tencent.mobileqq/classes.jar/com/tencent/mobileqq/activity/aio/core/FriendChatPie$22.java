package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.AIOTipsController.AIOTipsListener;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;

class FriendChatPie$22
  implements AIOTipsController.AIOTipsListener
{
  FriendChatPie$22(FriendChatPie paramFriendChatPie) {}
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    ((C2CListenTogetherPanel)this.a.q(32)).b(1, paramTipsBarTask);
    ((TogetherControlHelper)this.a.q(43)).a(1, paramTipsBarTask);
  }
  
  public void a(TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    ((C2CListenTogetherPanel)this.a.q(32)).a(1, paramTipsBarTask2);
    ((TogetherControlHelper)this.a.q(43)).b(1, paramTipsBarTask2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.22
 * JD-Core Version:    0.7.0.1
 */