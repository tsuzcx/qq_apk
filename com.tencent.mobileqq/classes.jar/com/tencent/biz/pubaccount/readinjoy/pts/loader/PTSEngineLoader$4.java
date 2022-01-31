package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bace;
import com.tencent.qphone.base.util.QLog;
import pdu;
import pdw;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(pdu parampdu) {}
  
  public void run()
  {
    if (!bace.a(pdu.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!pdw.a(pdu.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (bace.a(pdu.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + pdu.b(this.this$0));
      bace.a(pdu.b(this.this$0));
    }
    try
    {
      boolean bool1 = bace.d(pdu.a(this.this$0) + "/" + "libpts.so", pdu.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = bace.d(pdu.a(this.this$0) + "/" + "pts_config.json", pdu.b(this.this$0) + "/" + "pts_config.json");
      boolean bool3 = bace.d(pdu.a(this.this$0) + "/" + "libjsc.so", pdu.b(this.this$0) + "/" + "libjsc.so");
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], copySoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2 + ", copyJscSoSuccess = " + bool3);
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