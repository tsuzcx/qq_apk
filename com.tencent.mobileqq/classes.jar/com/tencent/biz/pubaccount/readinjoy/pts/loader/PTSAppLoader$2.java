package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class PTSAppLoader$2
  implements Runnable
{
  PTSAppLoader$2(PTSAppLoader paramPTSAppLoader, String paramString) {}
  
  public void run()
  {
    PTSAppLoader.2.1 local1 = new PTSAppLoader.2.1(this);
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
          HtmlOffline.b(this.a, BaseApplicationImpl.getApplication().getRuntime(), local1, true, 0, true);
          return;
        }
        catch (Throwable localThrowable1)
        {
          QLog.i("PTSAppLoader", 1, "[updatePTSApp], t = " + localThrowable1);
        }
        localThrowable2 = localThrowable2;
        QLog.e("PTSAppLoader", 1, "[updatePTSApp], t = " + localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader.2
 * JD-Core Version:    0.7.0.1
 */