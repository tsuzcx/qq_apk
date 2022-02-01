package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoPlayActivity$15
  implements Runnable
{
  ShortVideoPlayActivity$15(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    this.this$0.mMsg.serial();
    this.this$0.app.getMessageFacade().a(this.this$0.mMsg.frienduin, this.this$0.mMsg.istroop, this.this$0.mMsg.uniseq, this.this$0.mMsg.msgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.15
 * JD-Core Version:    0.7.0.1
 */