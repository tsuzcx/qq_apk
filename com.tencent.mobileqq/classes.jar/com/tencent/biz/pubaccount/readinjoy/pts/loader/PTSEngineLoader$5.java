package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bace;
import com.tencent.qphone.base.util.QLog;
import pdu;

public class PTSEngineLoader$5
  implements Runnable
{
  public PTSEngineLoader$5(pdu parampdu) {}
  
  public void run()
  {
    if (pdu.b(this.this$0)) {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], jsc has loaded, do not load again.");
    }
    while (pdu.c(this.this$0))
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], has loaded, do not load again.");
      return;
      String str1 = pdu.b(this.this$0) + "/" + "libjsc.so";
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], jscSoFullPath = " + str1);
      try
      {
        if (!bace.a(str1)) {
          break label177;
        }
        System.load(str1);
        pdu.a(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], load jsc so success.");
        pdu.a(this.this$0, "[loadPTSEngine] jsc succeed.", "1");
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("PTSEngineLoader", 1, "[loadPTSEngine] error, t = " + localThrowable1);
        pdu.b(this.this$0, localThrowable1.toString(), "1");
      }
      continue;
      label177:
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], jsc so does not exists.");
    }
    String str2 = pdu.b(this.this$0) + "/" + "libpts.so";
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], soFullPath = " + str2);
    try
    {
      if (bace.a(str2))
      {
        System.load(str2);
        pdu.b(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], load so success.");
        pdu.a(this.this$0, "[loadPTSEngine] pts succeed.", "2");
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("PTSEngineLoader", 1, "[loadPTSEngine] error, t = " + localThrowable2);
      pdu.b(this.this$0, localThrowable2.toString(), "2");
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngine], pts so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5
 * JD-Core Version:    0.7.0.1
 */