package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import nko;
import qoi;
import qoj;

public class PTSEngineLoader$3
  implements Runnable
{
  public PTSEngineLoader$3(qoi paramqoi) {}
  
  public void run()
  {
    qoj localqoj = new qoj(this);
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
          nko.b("3980", BaseApplicationImpl.getApplication().getRuntime(), localqoj, true, 0, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.3
 * JD-Core Version:    0.7.0.1
 */