package com.tencent.mobileqq.activity.aio;

import beqz;
import beyq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import java.io.File;
import java.net.URL;

class BaseBubbleBuilder$2
  implements Runnable
{
  BaseBubbleBuilder$2(BaseBubbleBuilder paramBaseBubbleBuilder, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    File localFile = beqz.a(beyq.a((MessageForPic)this.a, 1, null).toString());
    if ((localFile == null) || (!localFile.exists())) {
      this.this$0.a.a().a((MessageForPic)this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.2
 * JD-Core Version:    0.7.0.1
 */