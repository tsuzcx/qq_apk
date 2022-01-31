package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bdcs;
import com.tencent.qphone.base.util.QLog;
import pvy;
import pwc;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(pvy parampvy) {}
  
  public void run()
  {
    if (!bdcs.a(pvy.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!pwc.a(pvy.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!pwc.a(pvy.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (bdcs.a(pvy.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + pvy.b(this.this$0));
      bdcs.a(pvy.b(this.this$0));
    }
    try
    {
      boolean bool1 = bdcs.d(pvy.a(this.this$0) + "/" + "libpts.so", pvy.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = bdcs.d(pvy.a(this.this$0) + "/" + "pts_config.json", pvy.b(this.this$0) + "/" + "pts_config.json");
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], copySoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSEngineLoader", 1, "[handleDownloadPTSEngine], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.4
 * JD-Core Version:    0.7.0.1
 */