package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import bfgi;
import qyj;

class ADVideoAppDownloadManager$4
  implements Runnable
{
  ADVideoAppDownloadManager$4(ADVideoAppDownloadManager paramADVideoAppDownloadManager, qyj paramqyj) {}
  
  public void run()
  {
    this.a.c = ADVideoAppDownloadManager.a(this.this$0, this.a.b, 1);
    if (!TextUtils.isEmpty(this.a.c)) {
      bfgi.a().a(this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */