package com.dataline.activities;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.FileUtils;

class LiteActivity$30
  implements Runnable
{
  LiteActivity$30(LiteActivity paramLiteActivity, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    MessageForPic localMessageForPic = this.a;
    localMessageForPic.md5 = FileUtils.calcMd5(localMessageForPic.path);
    this.this$0.runOnUiThread(new LiteActivity.30.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.30
 * JD-Core Version:    0.7.0.1
 */