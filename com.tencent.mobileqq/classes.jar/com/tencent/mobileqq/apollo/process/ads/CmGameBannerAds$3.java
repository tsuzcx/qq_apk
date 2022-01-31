package com.tencent.mobileqq.apollo.process.ads;

import ajah;
import ajaj;
import android.app.Activity;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$3
  implements Runnable
{
  public CmGameBannerAds$3(ajah paramajah, int paramInt) {}
  
  public void run()
  {
    try
    {
      ajaj localajaj = (ajaj)ajah.a(this.this$0).get(Integer.valueOf(this.a));
      Activity localActivity = ajah.a(this.this$0);
      if ((localajaj != null) && (localajaj.a != null))
      {
        if (localActivity == null) {
          return;
        }
        localajaj.a.setVisibility(8);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.3
 * JD-Core Version:    0.7.0.1
 */