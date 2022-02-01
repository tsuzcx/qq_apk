package com.tencent.biz.pubaccount.util;

import anhk;
import pfk;
import pfn;
import tzo;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (anhk.aQ.equals(this.a))
    {
      pfn.a();
      return;
    }
    if (anhk.aR.equals(this.a))
    {
      pfk.a();
      return;
    }
    tzo.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */