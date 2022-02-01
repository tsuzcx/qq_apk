package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bhmi;
import com.tencent.qphone.base.util.QLog;
import qgw;
import qgy;

public class PTSJSCLoader$4
  implements Runnable
{
  public PTSJSCLoader$4(qgw paramqgw) {}
  
  public void run()
  {
    if (!bhmi.a(qgw.b(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir does not exist.");
      return;
    }
    if (!qgy.a(qgw.b(this.this$0), "4044"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir is not valid.");
      return;
    }
    if (!qgy.a(qgw.b(this.this$0) + "/" + "pts_jsc_config.json"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], offline version is not valid.");
      return;
    }
    if (bhmi.a(qgw.a(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], delete inner dir, dir = " + qgw.a(this.this$0));
      bhmi.a(qgw.a(this.this$0));
    }
    try
    {
      boolean bool1 = bhmi.d(qgw.b(this.this$0) + "/" + "libjsc.so", qgw.a(this.this$0) + "/" + "libjsc.so");
      boolean bool2 = bhmi.d(qgw.b(this.this$0) + "/" + "pts_jsc_config.json", qgw.a(this.this$0) + "/" + "pts_jsc_config.json");
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], copyJSCSoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSJSCLoader", 1, "[handleDownloadPTSJSC], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4
 * JD-Core Version:    0.7.0.1
 */