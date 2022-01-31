package com.dataline.activities;

import bdcs;
import com.tencent.mobileqq.data.MessageForPic;

class LiteActivity$30
  implements Runnable
{
  LiteActivity$30(LiteActivity paramLiteActivity, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.a.md5 = bdcs.c(this.a.path);
    this.this$0.runOnUiThread(new LiteActivity.30.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.30
 * JD-Core Version:    0.7.0.1
 */