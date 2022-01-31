package com.tencent.biz.pubaccount.readinjoy.config;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import osv;

public final class QQAladdinUtils$1
  implements Runnable
{
  public void run()
  {
    int[] arrayOfInt = osv.a;
    int k = arrayOfInt.length;
    int i = 0;
    if (i < k)
    {
      int m = arrayOfInt[i];
      AladdinConfigHandler localAladdinConfigHandler = Aladdin.getConfigHandlerById(m);
      if (m > 100) {}
      for (int j = 1;; j = 0)
      {
        if ((j & localAladdinConfigHandler instanceof SimpleConfigHandler) != 0) {
          Aladdin.getConfig(m);
        }
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils.1
 * JD-Core Version:    0.7.0.1
 */