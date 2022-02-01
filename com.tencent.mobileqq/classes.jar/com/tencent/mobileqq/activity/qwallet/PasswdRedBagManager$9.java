package com.tencent.mobileqq.activity.qwallet;

import ajuj;
import ajuk;
import ajul;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(ajul paramajul) {}
  
  public void run()
  {
    Iterator localIterator = ajul.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      ajuk localajuk = (ajuk)localIterator.next();
      ajul.a(this.this$0, localajuk);
      this.this$0.a(false, localajuk.a, localajuk.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */