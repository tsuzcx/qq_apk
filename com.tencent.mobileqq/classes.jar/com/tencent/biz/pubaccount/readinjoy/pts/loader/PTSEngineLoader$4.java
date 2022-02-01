package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bgmg;
import com.tencent.qphone.base.util.QLog;
import qoi;
import qom;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(qoi paramqoi) {}
  
  public void run()
  {
    if (!bgmg.a(qoi.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!qom.a(qoi.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!qom.a(qoi.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (bgmg.a(qoi.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + qoi.b(this.this$0));
      bgmg.a(qoi.b(this.this$0));
    }
    try
    {
      boolean bool1 = bgmg.d(qoi.a(this.this$0) + "/" + "libpts.so", qoi.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = bgmg.d(qoi.a(this.this$0) + "/" + "pts_config.json", qoi.b(this.this$0) + "/" + "pts_config.json");
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