package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;

final class RIJInjectImpl$2
  implements Runnable
{
  public void run()
  {
    try
    {
      ReadInJoyUtils.c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.RIJInjectImpl.2
 * JD-Core Version:    0.7.0.1
 */