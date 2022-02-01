package com.tencent.biz.pubaccount.NativeAd.util;

import oau;
import oav;
import tqa;
import twp;
import txh;

public class ADBaseAppDownloadManager$3
  implements Runnable
{
  public ADBaseAppDownloadManager$3(oau paramoau, txh paramtxh) {}
  
  public void run()
  {
    if (tqa.a(this.a))
    {
      twp.a("ADBaseAppDownloadManager", "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
      return;
    }
    tqa.a(this.a, new oav(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */