package com.tencent.biz.pubaccount.util;

import ajed;
import oab;
import oae;
import rtr;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (ajed.aP.equals(this.a))
    {
      oae.a();
      return;
    }
    if (ajed.aQ.equals(this.a))
    {
      oab.a();
      return;
    }
    rtr.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */