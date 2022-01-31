package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import bccu;
import pxh;

class ADVideoAppDownloadManager$4
  implements Runnable
{
  ADVideoAppDownloadManager$4(ADVideoAppDownloadManager paramADVideoAppDownloadManager, pxh parampxh) {}
  
  public void run()
  {
    this.a.c = ADVideoAppDownloadManager.a(this.this$0, this.a.b, 1);
    if (!TextUtils.isEmpty(this.a.c)) {
      bccu.a().a(this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */