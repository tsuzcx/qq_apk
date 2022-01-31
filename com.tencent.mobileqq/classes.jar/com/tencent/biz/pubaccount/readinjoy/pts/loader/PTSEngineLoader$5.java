package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import bbdx;
import com.tencent.qphone.base.util.QLog;
import ppj;
import pqe;

public class PTSEngineLoader$5
  implements Runnable
{
  public PTSEngineLoader$5(ppj paramppj) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], has loaded, do not load again.");
      return;
    }
    String str = ppj.b(this.this$0) + "/" + "libpts.so";
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], soFullPath = " + str);
    try
    {
      if (bbdx.a(str))
      {
        System.load(str);
        ppj.a(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], load so success.");
        pqe.b("[loadPTSEngineImpl] pts succeed.", "2");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PTSEngineLoader", 1, "[loadPTSEngineImpl] error, t = " + localThrowable);
      pqe.a(localThrowable.toString(), "2");
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5
 * JD-Core Version:    0.7.0.1
 */