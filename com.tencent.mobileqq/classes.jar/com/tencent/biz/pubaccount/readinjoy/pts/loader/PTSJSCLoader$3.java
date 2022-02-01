package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class PTSJSCLoader$3
  implements Runnable
{
  PTSJSCLoader$3(PTSJSCLoader paramPTSJSCLoader) {}
  
  public void run()
  {
    PTSJSCLoader.3.1 local1 = new PTSJSCLoader.3.1(this);
    try
    {
      HtmlOffline.a();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          HtmlOffline.b("4044", BaseApplicationImpl.getApplication().getRuntime(), local1, true, 0, true);
          return;
        }
        catch (Throwable localThrowable1)
        {
          QLog.i("PTSJSCLoader", 1, "[updatePTSJSC], t = " + localThrowable1);
        }
        localThrowable2 = localThrowable2;
        QLog.e("PTSJSCLoader", 1, "[updatePTSJSC], t = " + localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3
 * JD-Core Version:    0.7.0.1
 */