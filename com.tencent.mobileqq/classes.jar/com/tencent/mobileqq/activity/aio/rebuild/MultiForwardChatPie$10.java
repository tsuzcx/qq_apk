package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.BizTroopObserver;

class MultiForwardChatPie$10
  extends BizTroopObserver
{
  MultiForwardChatPie$10(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  protected void a(Object paramObject)
  {
    if (MultiForwardChatPie.f(this.a) != null) {
      MultiForwardChatPie.f(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.10
 * JD-Core Version:    0.7.0.1
 */