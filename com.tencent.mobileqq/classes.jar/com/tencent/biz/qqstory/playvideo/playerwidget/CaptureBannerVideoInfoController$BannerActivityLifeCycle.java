package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;

public class CaptureBannerVideoInfoController$BannerActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  public CaptureBannerVideoInfoController$BannerActivityLifeCycle(CaptureBannerVideoInfoController paramCaptureBannerVideoInfoController) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 20000) && (paramInt2 == -1))
    {
      paramIntent = BaseActivity.sActivityRoute;
      String str1 = SplashActivity.class.getSimpleName();
      String str2 = QQStoryMainActivity.class.getSimpleName();
      paramInt1 = paramIntent.size() - 1;
      while (paramInt1 >= 0)
      {
        String str3 = (String)paramIntent.get(paramInt1);
        if (!TextUtils.isEmpty(str3))
        {
          if (str3.startsWith(str1))
          {
            this.a.d();
            return;
          }
          if (TextUtils.equals(str3, str2))
          {
            this.a.e();
            return;
          }
        }
        paramInt1 -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureBannerVideoInfoController.BannerActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */