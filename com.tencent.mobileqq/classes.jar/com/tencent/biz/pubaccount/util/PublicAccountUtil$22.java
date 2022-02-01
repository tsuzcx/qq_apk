package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.app.AppConstants;
import pin;
import piq;
import uuc;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.a))
    {
      piq.a();
      return;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.a))
    {
      pin.a();
      return;
    }
    uuc.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */