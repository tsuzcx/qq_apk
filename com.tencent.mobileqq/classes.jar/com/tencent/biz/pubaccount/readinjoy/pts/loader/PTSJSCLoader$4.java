package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bbdx;
import com.tencent.qphone.base.util.QLog;
import ppl;
import ppn;

public class PTSJSCLoader$4
  implements Runnable
{
  public PTSJSCLoader$4(ppl paramppl) {}
  
  public void run()
  {
    if (!bbdx.a(ppl.b(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir does not exist.");
      return;
    }
    if (!ppn.a(ppl.b(this.this$0), "4044"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir is not valid.");
      return;
    }
    if (!ppn.a(ppl.b(this.this$0) + "/" + "pts_jsc_config.json"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], offline version is not valid.");
      return;
    }
    if (bbdx.a(ppl.a(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], delete inner dir, dir = " + ppl.a(this.this$0));
      bbdx.a(ppl.a(this.this$0));
    }
    try
    {
      boolean bool1 = bbdx.d(ppl.b(this.this$0) + "/" + "libjsc.so", ppl.a(this.this$0) + "/" + "libjsc.so");
      boolean bool2 = bbdx.d(ppl.b(this.this$0) + "/" + "pts_jsc_config.json", ppl.a(this.this$0) + "/" + "pts_jsc_config.json");
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], copyJSCSoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSJSCLoader", 1, "[handleDownloadPTSJSC], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4
 * JD-Core Version:    0.7.0.1
 */