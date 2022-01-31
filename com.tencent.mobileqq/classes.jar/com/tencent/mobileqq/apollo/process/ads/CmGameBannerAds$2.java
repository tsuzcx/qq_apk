package com.tencent.mobileqq.apollo.process.ads;

import ainj;
import ainl;
import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$2
  implements Runnable
{
  public CmGameBannerAds$2(ainj paramainj, int paramInt) {}
  
  public void run()
  {
    try
    {
      ainl localainl = (ainl)ainj.a(this.this$0).get(Integer.valueOf(this.a));
      Activity localActivity = ainj.a(this.this$0);
      if ((localainl != null) && (localainl.a != null))
      {
        if (localActivity == null) {
          return;
        }
        ((FrameLayout)localActivity.findViewById(2131297497)).removeView(localainl.a);
        ainj.a(this.this$0).remove(Integer.valueOf(this.a));
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