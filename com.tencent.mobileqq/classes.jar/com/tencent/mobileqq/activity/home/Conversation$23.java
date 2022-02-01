package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

class Conversation$23
  implements Runnable
{
  Conversation$23(Conversation paramConversation) {}
  
  public void run()
  {
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).calcVisibleItemCount(Conversation.i(this.this$0).getMeasuredHeight(), Conversation.i(this.this$0).getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.23
 * JD-Core Version:    0.7.0.1
 */