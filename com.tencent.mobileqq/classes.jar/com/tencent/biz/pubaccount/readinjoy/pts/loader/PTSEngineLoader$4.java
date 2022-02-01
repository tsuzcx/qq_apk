package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PTSEngineLoader$4
  implements Runnable
{
  PTSEngineLoader$4(PTSEngineLoader paramPTSEngineLoader) {}
  
  public void run()
  {
    if (!FileUtils.a(PTSEngineLoader.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!PTSOfflineUtil.a(PTSEngineLoader.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!PTSOfflineUtil.a(PTSEngineLoader.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (FileUtils.a(PTSEngineLoader.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + PTSEngineLoader.b(this.this$0));
      FileUtils.a(PTSEngineLoader.b(this.this$0));
    }
    try
    {
      boolean bool1 = FileUtils.d(PTSEngineLoader.a(this.this$0) + "/" + "libpts.so", PTSEngineLoader.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = FileUtils.d(PTSEngineLoader.a(this.this$0) + "/" + "pts_config.json", PTSEngineLoader.b(this.this$0) + "/" + "pts_config.json");
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], copySoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSEngineLoader", 1, "[handleDownloadPTSEngine], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.4
 * JD-Core Version:    0.7.0.1
 */