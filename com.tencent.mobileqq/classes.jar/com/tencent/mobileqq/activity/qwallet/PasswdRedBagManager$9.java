package com.tencent.mobileqq.activity.qwallet;

import agvv;
import agvw;
import agvx;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(agvx paramagvx) {}
  
  public void run()
  {
    Iterator localIterator = agvx.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      agvw localagvw = (agvw)localIterator.next();
      agvx.a(this.this$0, localagvw);
      this.this$0.a(false, localagvw.a, localagvw.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */