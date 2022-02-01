package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import qmv;
import qob;

public class PTSEngineLoader$5
  implements Runnable
{
  public PTSEngineLoader$5(qmv paramqmv) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], has loaded, do not load again.");
      return;
    }
    String str = qmv.b(this.this$0) + "/" + "libpts.so";
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], soFullPath = " + str);
    try
    {
      if (FileUtils.fileExists(str))
      {
        System.load(str);
        qmv.a(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], load so success.");
        qob.b("[loadPTSEngineImpl] pts succeed.", "2");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PTSEngineLoader", 1, "[loadPTSEngineImpl] error, t = " + localThrowable);
      qob.a(localThrowable.toString(), "2");
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5
 * JD-Core Version:    0.7.0.1
 */