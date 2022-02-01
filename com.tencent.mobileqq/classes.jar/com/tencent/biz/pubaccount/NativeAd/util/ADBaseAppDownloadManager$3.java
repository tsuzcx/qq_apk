package com.tencent.biz.pubaccount.NativeAd.util;

import nxp;
import nxq;
import olc;
import oqh;
import orb;

public class ADBaseAppDownloadManager$3
  implements Runnable
{
  public ADBaseAppDownloadManager$3(nxp paramnxp, orb paramorb) {}
  
  public void run()
  {
    if (olc.a(this.a))
    {
      oqh.a("ADBaseAppDownloadManager", "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
      return;
    }
    olc.a(this.a, new nxq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */