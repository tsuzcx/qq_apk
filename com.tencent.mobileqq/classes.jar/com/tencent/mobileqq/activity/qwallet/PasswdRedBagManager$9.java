package com.tencent.mobileqq.activity.qwallet;

import aiuj;
import aiuk;
import aiul;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(aiul paramaiul) {}
  
  public void run()
  {
    Iterator localIterator = aiul.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      aiuk localaiuk = (aiuk)localIterator.next();
      aiul.a(this.this$0, localaiuk);
      this.this$0.a(false, localaiuk.a, localaiuk.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */