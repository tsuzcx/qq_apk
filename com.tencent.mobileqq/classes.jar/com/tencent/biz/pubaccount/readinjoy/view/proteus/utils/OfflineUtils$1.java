package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import rpr;
import rpu;

public final class OfflineUtils$1
  implements Runnable
{
  public OfflineUtils$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      return;
    }
    rpr.a();
    rpr.a("default_feeds", true);
    new rpu().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils.1
 * JD-Core Version:    0.7.0.1
 */