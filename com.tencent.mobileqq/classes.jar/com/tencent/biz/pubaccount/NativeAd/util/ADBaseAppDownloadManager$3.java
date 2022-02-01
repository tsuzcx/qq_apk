package com.tencent.biz.pubaccount.NativeAd.util;

import nzj;
import nzk;
import tkk;
import tpx;
import tqt;

public class ADBaseAppDownloadManager$3
  implements Runnable
{
  public ADBaseAppDownloadManager$3(nzj paramnzj, tqt paramtqt) {}
  
  public void run()
  {
    if (tkk.a(this.a))
    {
      tpx.a("ADBaseAppDownloadManager", "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
      return;
    }
    tkk.a(this.a, new nzk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */