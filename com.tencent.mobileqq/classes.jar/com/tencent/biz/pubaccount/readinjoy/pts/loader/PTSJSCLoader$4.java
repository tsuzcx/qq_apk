package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bbdj;
import com.tencent.qphone.base.util.QLog;
import ppo;
import ppq;

public class PTSJSCLoader$4
  implements Runnable
{
  public PTSJSCLoader$4(ppo paramppo) {}
  
  public void run()
  {
    if (!bbdj.a(ppo.b(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir does not exist.");
      return;
    }
    if (!ppq.a(ppo.b(this.this$0), "4044"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir is not valid.");
      return;
    }
    if (!ppq.a(ppo.b(this.this$0) + "/" + "pts_jsc_config.json"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], offline version is not valid.");
      return;
    }
    if (bbdj.a(ppo.a(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], delete inner dir, dir = " + ppo.a(this.this$0));
      bbdj.a(ppo.a(this.this$0));
    }
    try
    {
      boolean bool1 = bbdj.d(ppo.b(this.this$0) + "/" + "libjsc.so", ppo.a(this.this$0) + "/" + "libjsc.so");
      boolean bool2 = bbdj.d(ppo.b(this.this$0) + "/" + "pts_jsc_config.json", ppo.a(this.this$0) + "/" + "pts_jsc_config.json");
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