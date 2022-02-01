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
    String str1;
    String str2;
    if ((paramInt1 == 20000) && (paramInt2 == -1))
    {
      paramIntent = BaseActivity.sActivityRoute;
      str1 = SplashActivity.class.getSimpleName();
      str2 = QQStoryMainActivity.class.getSimpleName();
      paramInt1 = paramIntent.size() - 1;
    }
    for (;;)
    {
      String str3;
      if (paramInt1 >= 0)
      {
        str3 = (String)paramIntent.get(paramInt1);
        if (TextUtils.isEmpty(str3)) {
          break label95;
        }
        if (str3.startsWith(str1)) {
          this.a.b();
        }
      }
      else
      {
        return;
      }
      if (TextUtils.equals(str3, str2))
      {
        this.a.c();
        return;
      }
      label95:
      paramInt1 -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureBannerVideoInfoController.BannerActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */