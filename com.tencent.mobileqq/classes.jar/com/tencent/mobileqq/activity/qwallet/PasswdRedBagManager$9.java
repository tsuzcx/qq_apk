package com.tencent.mobileqq.activity.qwallet;

import akqc;
import akqd;
import akqe;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(akqe paramakqe) {}
  
  public void run()
  {
    Iterator localIterator = akqe.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      akqd localakqd = (akqd)localIterator.next();
      akqe.a(this.this$0, localakqd);
      this.this$0.a(false, localakqd.a, localakqd.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */