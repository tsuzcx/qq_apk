package com.tencent.mobileqq.activity.qwallet;

import java.util.Iterator;
import java.util.List;

class PasswdRedBagManager$9
  implements Runnable
{
  PasswdRedBagManager$9(PasswdRedBagManager paramPasswdRedBagManager) {}
  
  public void run()
  {
    Iterator localIterator = PasswdRedBagManager.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)localIterator.next();
      PasswdRedBagManager.a(this.this$0, localPasswdRedBagInfo);
      this.this$0.a(false, localPasswdRedBagInfo.a, localPasswdRedBagInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */