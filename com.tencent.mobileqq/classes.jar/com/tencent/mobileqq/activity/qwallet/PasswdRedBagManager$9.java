package com.tencent.mobileqq.activity.qwallet;

import agvx;
import agvy;
import agvz;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(agvz paramagvz) {}
  
  public void run()
  {
    Iterator localIterator = agvz.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      agvy localagvy = (agvy)localIterator.next();
      agvz.a(this.this$0, localagvy);
      this.this$0.a(false, localagvy.a, localagvy.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */