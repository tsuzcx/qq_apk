package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import qmv;
import qmz;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(qmv paramqmv) {}
  
  public void run()
  {
    if (!FileUtils.fileExists(qmv.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!qmz.a(qmv.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!qmz.a(qmv.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (FileUtils.fileExists(qmv.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + qmv.b(this.this$0));
      FileUtils.deleteDirectory(qmv.b(this.this$0));
    }
    try
    {
      boolean bool1 = FileUtils.copyFile(qmv.a(this.this$0) + "/" + "libpts.so", qmv.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = FileUtils.copyFile(qmv.a(this.this$0) + "/" + "pts_config.json", qmv.b(this.this$0) + "/" + "pts_config.json");
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