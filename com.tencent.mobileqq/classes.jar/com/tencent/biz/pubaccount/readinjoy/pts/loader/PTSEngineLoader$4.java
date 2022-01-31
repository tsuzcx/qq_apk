package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bbdx;
import com.tencent.qphone.base.util.QLog;
import ppj;
import ppn;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(ppj paramppj) {}
  
  public void run()
  {
    if (!bbdx.a(ppj.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!ppn.a(ppj.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!ppn.a(ppj.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (bbdx.a(ppj.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + ppj.b(this.this$0));
      bbdx.a(ppj.b(this.this$0));
    }
    try
    {
      boolean bool1 = bbdx.d(ppj.a(this.this$0) + "/" + "libpts.so", ppj.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = bbdx.d(ppj.a(this.this$0) + "/" + "pts_config.json", ppj.b(this.this$0) + "/" + "pts_config.json");
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], copySoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSEngineLoader", 1, "[handleDownloadPTSEngine], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.4
 * JD-Core Version:    0.7.0.1
 */