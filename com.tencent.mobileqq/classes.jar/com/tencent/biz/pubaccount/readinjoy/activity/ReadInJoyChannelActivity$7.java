package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

class ReadInJoyChannelActivity$7
  implements Runnable
{
  ReadInJoyChannelActivity$7(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    if (this.this$0.app != null)
    {
      QQMessageFacade localQQMessageFacade = this.this$0.app.a();
      if (localQQMessageFacade != null)
      {
        int i = localQQMessageFacade.b();
        ReadInJoyChannelActivity.a(this.this$0, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.7
 * JD-Core Version:    0.7.0.1
 */