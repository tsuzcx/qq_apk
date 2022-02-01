package com.tencent.biz.pubaccount.readinjoyAd.ad.diversion;

import android.app.Activity;

public class DiversionManager
{
  private static volatile DiversionManager a;
  
  public static DiversionManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DiversionManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Activity paramActivity)
  {
    if (DiversionUtil.b()) {
      new ReadInJoyAdDiversionWindow(paramActivity).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.diversion.DiversionManager
 * JD-Core Version:    0.7.0.1
 */