package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.mobileqq.webprocess.WebProcessManager;
import tmb;
import tqr;

public final class ReadInJoyAdUtils$1
  implements Runnable
{
  public void run()
  {
    boolean bool = WebProcessManager.c();
    Object localObject = tqr.a(2);
    if ((localObject != null) && ((localObject instanceof tmb))) {
      ((tmb)localObject).a = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils.1
 * JD-Core Version:    0.7.0.1
 */