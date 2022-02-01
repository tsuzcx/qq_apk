package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class RecentAdapter$7
  implements Runnable
{
  RecentAdapter$7(RecentAdapter paramRecentAdapter, String paramString, int paramInt) {}
  
  public void run()
  {
    ((MessageHandler)this.this$0.d.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(this.a, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.7
 * JD-Core Version:    0.7.0.1
 */