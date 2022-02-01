package com.tencent.mobileqq.activity.qwallet;

import akws;
import akwt;
import akwu;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(akwu paramakwu) {}
  
  public void run()
  {
    Iterator localIterator = akwu.a(this.this$0).a().iterator();
    while (localIterator.hasNext())
    {
      akwt localakwt = (akwt)localIterator.next();
      akwu.a(this.this$0, localakwt);
      this.this$0.a(false, localakwt.a, localakwt.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */