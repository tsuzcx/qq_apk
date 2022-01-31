package com.tencent.biz.pubaccount.util;

import ajsf;
import olm;
import olp;
import sgj;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (ajsf.aQ.equals(this.a))
    {
      olp.a();
      return;
    }
    if (ajsf.aR.equals(this.a))
    {
      olm.a();
      return;
    }
    sgj.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */