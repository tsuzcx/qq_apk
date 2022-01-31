package com.tencent.mobileqq.apollo.process.ads;

import akwg;
import akwi;
import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$2
  implements Runnable
{
  public CmGameBannerAds$2(akwg paramakwg, int paramInt) {}
  
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
        ((FrameLayout)localActivity.findViewById(2131363073)).removeView(localakwi.a);
        akwg.a(this.this$0).remove(Integer.valueOf(this.a));
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
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.2
 * JD-Core Version:    0.7.0.1
 */