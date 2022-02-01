package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import suz;
import svc;

public final class OfflineUtils$1
  implements Runnable
{
  public OfflineUtils$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      return;
    }
    suz.a();
    suz.a("default_feeds", true);
    new svc().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils.1
 * JD-Core Version:    0.7.0.1
 */