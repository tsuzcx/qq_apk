package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import android.os.Handler;
import bdcs;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import pwa;
import pwx;

public class PTSJSCLoader$2
  implements Runnable
{
  public PTSJSCLoader$2(pwa parampwa, Runnable paramRunnable) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (this.a != null) {
        ThreadManager.b().post(this.a);
      }
    }
    for (;;)
    {
      return;
      String str = pwa.a(this.this$0) + "/" + "libjsc.so";
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jscSoFullPath = " + str);
      try
      {
        if (bdcs.a(str))
        {
          System.load(str);
          pwa.a(this.this$0, true);
          QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], load jsc so success");
          pwx.b("[loadPTSJSC] succeed", "1");
          if (this.a == null) {
            continue;
          }
          ThreadManager.b().post(this.a);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("PTSJSCLoader", 1, "[loadPTSJSC] error, t = " + localThrowable);
        pwx.a(localThrowable.toString(), "1");
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