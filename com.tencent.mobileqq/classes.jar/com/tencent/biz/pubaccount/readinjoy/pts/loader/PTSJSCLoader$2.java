package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import qzc;
import rag;

public class PTSJSCLoader$2
  implements Runnable
{
  public PTSJSCLoader$2(qzc paramqzc, Runnable paramRunnable) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (this.a != null) {
        ThreadManager.getFileThreadHandler().post(this.a);
      }
    }
    for (;;)
    {
      return;
      String str = qzc.a(this.this$0) + "/" + "libjsc.so";
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jscSoFullPath = " + str);
      try
      {
        if (FileUtils.fileExists(str))
        {
          System.load(str);
          qzc.a(this.this$0, true);
          QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], load jsc so success");
          rag.b("[loadPTSJSC] succeed", "1");
          if (this.a == null) {
            continue;
          }
          ThreadManager.getFileThreadHandler().post(this.a);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("PTSJSCLoader", 1, "[loadPTSJSC] error, t = " + localThrowable);
        rag.a(localThrowable.toString(), "1");
        return;
      }
    }
    QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.2
 * JD-Core Version:    0.7.0.1
 */