package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bhmi;
import com.tencent.qphone.base.util.QLog;
import qgu;
import qgy;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(qgu paramqgu) {}
  
  public void run()
  {
    if (!bhmi.a(qgu.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!qgy.a(qgu.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!qgy.a(qgu.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (bhmi.a(qgu.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + qgu.b(this.this$0));
      bhmi.a(qgu.b(this.this$0));
    }
    try
    {
      boolean bool1 = bhmi.d(qgu.a(this.this$0) + "/" + "libpts.so", qgu.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = bhmi.d(qgu.a(this.this$0) + "/" + "pts_config.json", qgu.b(this.this$0) + "/" + "pts_config.json");
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