package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import nbv;
import pvy;
import pvz;

public class PTSEngineLoader$3
  implements Runnable
{
  public PTSEngineLoader$3(pvy parampvy) {}
  
  public void run()
  {
    pvz localpvz = new pvz(this);
    try
    {
      nbv.a();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          nbv.b("3980", BaseApplicationImpl.getApplication().getRuntime(), localpvz, true, 0, true);
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