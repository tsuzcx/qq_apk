package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bdhb;
import com.tencent.qphone.base.util.QLog;
import pvy;
import pwx;

public class PTSEngineLoader$5
  implements Runnable
{
  public PTSEngineLoader$5(pvy parampvy) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], has loaded, do not load again.");
      return;
    }
    String str = pvy.b(this.this$0) + "/" + "libpts.so";
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], soFullPath = " + str);
    try
    {
      if (bdhb.a(str))
      {
        System.load(str);
        pvy.a(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], load so success.");
        pwx.b("[loadPTSEngineImpl] pts succeed.", "2");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PTSEngineLoader", 1, "[loadPTSEngineImpl] error, t = " + localThrowable);
      pwx.a(localThrowable.toString(), "2");
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5
 * JD-Core Version:    0.7.0.1
 */