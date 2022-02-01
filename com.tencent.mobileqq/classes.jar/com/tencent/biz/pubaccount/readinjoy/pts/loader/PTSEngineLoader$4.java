package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import qza;
import qze;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(qza paramqza) {}
  
  public void run()
  {
    if (!FileUtils.fileExists(qza.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!qze.a(qza.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!qze.a(qza.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (FileUtils.fileExists(qza.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + qza.b(this.this$0));
      FileUtils.deleteDirectory(qza.b(this.this$0));
    }
    try
    {
      boolean bool1 = FileUtils.copyFile(qza.a(this.this$0) + "/" + "libpts.so", qza.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = FileUtils.copyFile(qza.a(this.this$0) + "/" + "pts_config.json", qza.b(this.this$0) + "/" + "pts_config.json");
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