package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import nuz;
import qzc;
import qzd;

public class PTSJSCLoader$3
  implements Runnable
{
  public PTSJSCLoader$3(qzc paramqzc) {}
  
  public void run()
  {
    qzd localqzd = new qzd(this);
    try
    {
      nuz.a();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          nuz.b("4044", BaseApplicationImpl.getApplication().getRuntime(), localqzd, true, 0, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3
 * JD-Core Version:    0.7.0.1
 */