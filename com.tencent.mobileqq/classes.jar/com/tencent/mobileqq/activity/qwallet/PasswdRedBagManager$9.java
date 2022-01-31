package com.tencent.mobileqq.activity.qwallet;

import aipu;
import aipv;
import aipw;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(aipw paramaipw) {}
  
  public void run()
  {
    Iterator localIterator = aipw.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      aipv localaipv = (aipv)localIterator.next();
      aipw.a(this.this$0, localaipv);
      this.this$0.a(false, localaipv.a, localaipv.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */