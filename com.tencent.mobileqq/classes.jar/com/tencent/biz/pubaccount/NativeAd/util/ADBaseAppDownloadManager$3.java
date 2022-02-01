package com.tencent.biz.pubaccount.NativeAd.util;

import oil;
import oim;
import udt;
import ukq;
import ule;

public class ADBaseAppDownloadManager$3
  implements Runnable
{
  public ADBaseAppDownloadManager$3(oil paramoil, ule paramule) {}
  
  public void run()
  {
    if (udt.a(this.a))
    {
      ukq.a("ADBaseAppDownloadManager", "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
      return;
    }
    udt.a(this.a, new oim(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */