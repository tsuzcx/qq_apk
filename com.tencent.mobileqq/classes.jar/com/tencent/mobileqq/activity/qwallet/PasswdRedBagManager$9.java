package com.tencent.mobileqq.activity.qwallet;

import agji;
import agjj;
import agjk;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(agjk paramagjk) {}
  
  public void run()
  {
    Iterator localIterator = agjk.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      agjj localagjj = (agjj)localIterator.next();
      agjk.a(this.this$0, localagjj);
      this.this$0.a(false, localagjj.a, localagjj.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */