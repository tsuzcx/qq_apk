package com.tencent.mobileqq.apollo.process.ads;

import akwg;
import akwi;
import android.app.Activity;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$3
  implements Runnable
{
  public CmGameBannerAds$3(akwg paramakwg, int paramInt) {}
  
  public void run()
  {
    try
    {
      akwi localakwi = (akwi)akwg.a(this.this$0).get(Integer.valueOf(this.a));
      Activity localActivity = akwg.a(this.this$0);
      if ((localakwi != null) && (localakwi.a != null))
      {
        if (localActivity == null) {
          return;
        }
        localakwi.a.setVisibility(8);
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