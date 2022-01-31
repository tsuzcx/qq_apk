package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bdhb;
import com.tencent.qphone.base.util.QLog;
import pwa;
import pwc;

public class PTSJSCLoader$4
  implements Runnable
{
  public PTSJSCLoader$4(pwa parampwa) {}
  
  public void run()
  {
    if (!bdhb.a(pwa.b(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir does not exist.");
      return;
    }
    if (!pwc.a(pwa.b(this.this$0), "4044"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir is not valid.");
      return;
    }
    if (!pwc.a(pwa.b(this.this$0) + "/" + "pts_jsc_config.json"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], offline version is not valid.");
      return;
    }
    if (bdhb.a(pwa.a(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], delete inner dir, dir = " + pwa.a(this.this$0));
      bdhb.a(pwa.a(this.this$0));
    }
    try
    {
      boolean bool1 = bdhb.d(pwa.b(this.this$0) + "/" + "libjsc.so", pwa.a(this.this$0) + "/" + "libjsc.so");
      boolean bool2 = bdhb.d(pwa.b(this.this$0) + "/" + "pts_jsc_config.json", pwa.a(this.this$0) + "/" + "pts_jsc_config.json");
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], copyJSCSoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSJSCLoader", 1, "[handleDownloadPTSJSC], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4
 * JD-Core Version:    0.7.0.1
 */