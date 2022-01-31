package com.tencent.mobileqq.apollo.process.ads;

import akrr;
import akrt;
import android.app.Activity;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$3
  implements Runnable
{
  public CmGameBannerAds$3(akrr paramakrr, int paramInt) {}
  
  public void run()
  {
    try
    {
      akrt localakrt = (akrt)akrr.a(this.this$0).get(Integer.valueOf(this.a));
      Activity localActivity = akrr.a(this.this$0);
      if ((localakrt != null) && (localakrt.a != null))
      {
        if (localActivity == null) {
          return;
        }
        localakrt.a.setVisibility(8);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.3
 * JD-Core Version:    0.7.0.1
 */