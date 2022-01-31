package com.tencent.mobileqq.apollo.process.ads;

import ajaf;
import ajah;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$1
  implements Runnable
{
  public CmGameBannerAds$1(ajaf paramajaf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    try
    {
      Object localObject = (ajah)ajaf.a(this.this$0).get(Integer.valueOf(this.a));
      Activity localActivity = ajaf.a(this.this$0);
      if ((localObject != null) && (((ajah)localObject).a != null))
      {
        if (localActivity == null) {
          return;
        }
        localObject = (RelativeLayout.LayoutParams)((ajah)localObject).a.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = this.b;
        ((RelativeLayout.LayoutParams)localObject).topMargin = this.c;
        ((RelativeLayout.LayoutParams)localObject).width = this.d;
        ((RelativeLayout.LayoutParams)localObject).height = this.e;
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
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.1
 * JD-Core Version:    0.7.0.1
 */