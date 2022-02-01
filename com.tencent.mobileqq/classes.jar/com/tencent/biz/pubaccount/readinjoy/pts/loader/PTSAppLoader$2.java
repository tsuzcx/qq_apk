package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import nko;
import qog;
import qoh;

public class PTSAppLoader$2
  implements Runnable
{
  public PTSAppLoader$2(qog paramqog, String paramString) {}
  
  public void run()
  {
    qoh localqoh = new qoh(this);
    try
    {
      nko.a();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          nko.b(this.a, BaseApplicationImpl.getApplication().getRuntime(), localqoh, true, 0, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader.2
 * JD-Core Version:    0.7.0.1
 */