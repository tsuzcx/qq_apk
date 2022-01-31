package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bbdj;
import com.tencent.qphone.base.util.QLog;
import ppm;
import pqh;

public class PTSEngineLoader$5
  implements Runnable
{
  public PTSEngineLoader$5(ppm paramppm) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], has loaded, do not load again.");
      return;
    }
    String str = ppm.b(this.this$0) + "/" + "libpts.so";
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], soFullPath = " + str);
    try
    {
      if (bbdj.a(str))
      {
        System.load(str);
        ppm.a(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], load so success.");
        pqh.b("[loadPTSEngineImpl] pts succeed.", "2");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PTSEngineLoader", 1, "[loadPTSEngineImpl] error, t = " + localThrowable);
      pqh.a(localThrowable.toString(), "2");
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5
 * JD-Core Version:    0.7.0.1
 */