package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.app.AppConstants;
import ozh;
import ozk;
import ugf;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.a))
    {
      ozk.a();
      return;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.a))
    {
      ozh.a();
      return;
    }
    ugf.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */