package com.tencent.biz.pubaccount.readinjoy.ad.utils;

import com.tencent.mobileqq.webprocess.WebProcessManager;
import nyg;
import obb;

public final class ReadInJoyAdUtils$1
  implements Runnable
{
  public void run()
  {
    boolean bool = WebProcessManager.c();
    Object localObject = obb.a(2);
    if ((localObject != null) && ((localObject instanceof nyg))) {
      ((nyg)localObject).a = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdUtils.1
 * JD-Core Version:    0.7.0.1
 */