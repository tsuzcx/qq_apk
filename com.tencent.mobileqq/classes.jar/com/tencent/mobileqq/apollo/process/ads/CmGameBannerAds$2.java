package com.tencent.mobileqq.apollo.process.ads;

import ajah;
import ajaj;
import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$2
  implements Runnable
{
  public CmGameBannerAds$2(ajah paramajah, int paramInt) {}
  
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
        ((FrameLayout)localActivity.findViewById(2131363038)).removeView(localajaj.a);
        ajah.a(this.this$0).remove(Integer.valueOf(this.a));
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
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.2
 * JD-Core Version:    0.7.0.1
 */