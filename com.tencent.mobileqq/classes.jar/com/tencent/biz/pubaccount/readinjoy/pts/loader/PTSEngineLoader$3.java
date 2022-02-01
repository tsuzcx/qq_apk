package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class PTSEngineLoader$3
  implements Runnable
{
  PTSEngineLoader$3(PTSEngineLoader paramPTSEngineLoader) {}
  
  public void run()
  {
    PTSEngineLoader.3.1 local1 = new PTSEngineLoader.3.1(this);
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
          HtmlOffline.b("3980", BaseApplicationImpl.getApplication().getRuntime(), local1, true, 0, true);
          return;
        }
        catch (Throwable localThrowable1)
        {
          QLog.i("PTSEngineLoader", 1, "[updatePTSEngine], t = " + localThrowable1);
        }
        localThrowable2 = localThrowable2;
        QLog.e("PTSEngineLoader", 1, "[updatePTSEngine], t = " + localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.3
 * JD-Core Version:    0.7.0.1
 */