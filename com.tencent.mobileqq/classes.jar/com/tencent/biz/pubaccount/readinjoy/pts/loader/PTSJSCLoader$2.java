package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import android.os.Handler;
import bbdx;
import bejn;
import com.tencent.qphone.base.util.QLog;
import ppl;
import pqe;

public class PTSJSCLoader$2
  implements Runnable
{
  public PTSJSCLoader$2(ppl paramppl, Runnable paramRunnable) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (this.a != null) {
        bejn.b().post(this.a);
      }
    }
    for (;;)
    {
      return;
      String str = ppl.a(this.this$0) + "/" + "libjsc.so";
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jscSoFullPath = " + str);
      try
      {
        if (bbdx.a(str))
        {
          System.load(str);
          ppl.a(this.this$0, true);
          QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], load jsc so success");
          pqe.b("[loadPTSJSC] succeed", "1");
          if (this.a == null) {
            continue;
          }
          bejn.b().post(this.a);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("PTSJSCLoader", 1, "[loadPTSJSC] error, t = " + localThrowable);
        pqe.a(localThrowable.toString(), "1");
        return;
      }
    }
    QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.2
 * JD-Core Version:    0.7.0.1
 */