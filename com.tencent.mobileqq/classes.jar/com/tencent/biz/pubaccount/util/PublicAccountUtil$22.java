package com.tencent.biz.pubaccount.util;

import aljq;
import opt;
import opw;
import syb;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (aljq.aR.equals(this.a))
    {
      opw.a();
      return;
    }
    if (aljq.aS.equals(this.a))
    {
      opt.a();
      return;
    }
    syb.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */