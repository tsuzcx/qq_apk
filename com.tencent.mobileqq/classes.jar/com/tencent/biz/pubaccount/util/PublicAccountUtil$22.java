package com.tencent.biz.pubaccount.util;

import ajsd;
import olj;
import olm;
import sgg;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (ajsd.aQ.equals(this.a))
    {
      olm.a();
      return;
    }
    if (ajsd.aR.equals(this.a))
    {
      olj.a();
      return;
    }
    sgg.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */