package com.tencent.mobileqq.activity.qwallet;

import aklh;
import akli;
import aklj;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(aklj paramaklj) {}
  
  public void run()
  {
    Iterator localIterator = aklj.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      akli localakli = (akli)localIterator.next();
      aklj.a(this.this$0, localakli);
      this.this$0.a(false, localakli.a, localakli.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */