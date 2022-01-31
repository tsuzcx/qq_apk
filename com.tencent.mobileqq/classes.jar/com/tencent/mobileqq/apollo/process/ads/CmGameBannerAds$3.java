package com.tencent.mobileqq.apollo.process.ads;

import ainj;
import ainl;
import android.app.Activity;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$3
  implements Runnable
{
  public CmGameBannerAds$3(ainj paramainj, int paramInt) {}
  
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
        localainl.a.setVisibility(8);
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