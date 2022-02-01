package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PTSJSCLoader$4
  implements Runnable
{
  PTSJSCLoader$4(PTSJSCLoader paramPTSJSCLoader) {}
  
  public void run()
  {
    if (!FileUtils.a(PTSJSCLoader.b(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir does not exist.");
      return;
    }
    if (!PTSOfflineUtil.a(PTSJSCLoader.b(this.this$0), "4044"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir is not valid.");
      return;
    }
    if (!PTSOfflineUtil.a(PTSJSCLoader.b(this.this$0) + "/" + "pts_jsc_config.json"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], offline version is not valid.");
      return;
    }
    if (FileUtils.a(PTSJSCLoader.a(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], delete inner dir, dir = " + PTSJSCLoader.a(this.this$0));
      FileUtils.a(PTSJSCLoader.a(this.this$0));
    }
    try
    {
      boolean bool1 = FileUtils.d(PTSJSCLoader.b(this.this$0) + "/" + "libjsc.so", PTSJSCLoader.a(this.this$0) + "/" + "libjsc.so");
      boolean bool2 = FileUtils.d(PTSJSCLoader.b(this.this$0) + "/" + "pts_jsc_config.json", PTSJSCLoader.a(this.this$0) + "/" + "pts_jsc_config.json");
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], copyJSCSoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSJSCLoader", 1, "[handleDownloadPTSJSC], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4
 * JD-Core Version:    0.7.0.1
 */