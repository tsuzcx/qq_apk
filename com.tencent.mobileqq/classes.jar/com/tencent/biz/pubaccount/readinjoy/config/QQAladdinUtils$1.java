package com.tencent.biz.pubaccount.readinjoy.config;

import com.tencent.aladdin.config.Aladdin;

final class QQAladdinUtils$1
  implements Runnable
{
  public void run()
  {
    int[] arrayOfInt = QQAladdinUtils.a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (k > 100) {
        Aladdin.getConfig(k);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils.1
 * JD-Core Version:    0.7.0.1
 */