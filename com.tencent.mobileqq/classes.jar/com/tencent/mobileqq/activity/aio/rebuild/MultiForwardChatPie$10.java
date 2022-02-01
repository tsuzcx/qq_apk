package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.BizTroopObserver;

class MultiForwardChatPie$10
  extends BizTroopObserver
{
  MultiForwardChatPie$10(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  protected void a(Object paramObject)
  {
    if (MultiForwardChatPie.a(this.a) != null) {
      MultiForwardChatPie.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.10
 * JD-Core Version:    0.7.0.1
 */