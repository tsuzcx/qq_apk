package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bbdj;
import com.tencent.qphone.base.util.QLog;
import ppm;
import ppq;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(ppm paramppm) {}
  
  public void run()
  {
    if (!bbdj.a(ppm.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!ppq.a(ppm.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!ppq.a(ppm.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (bbdj.a(ppm.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + ppm.b(this.this$0));
      bbdj.a(ppm.b(this.this$0));
    }
    try
    {
      boolean bool1 = bbdj.d(ppm.a(this.this$0) + "/" + "libpts.so", ppm.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = bbdj.d(ppm.a(this.this$0) + "/" + "pts_config.json", ppm.b(this.this$0) + "/" + "pts_config.json");
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