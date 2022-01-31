package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import bdgv;
import qjf;

class ADVideoAppDownloadManager$4
  implements Runnable
{
  ADVideoAppDownloadManager$4(ADVideoAppDownloadManager paramADVideoAppDownloadManager, qjf paramqjf) {}
  
  public void run()
  {
    this.a.c = ADVideoAppDownloadManager.a(this.this$0, this.a.b, 1);
    if (!TextUtils.isEmpty(this.a.c)) {
      bdgv.a().a(this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */