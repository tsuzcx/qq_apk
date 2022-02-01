package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.NewProgressControler;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.GroupHolderContainer;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;

class ProgressBarVideoInfoWidget$1
  extends SimpleActivityLifeCycle
{
  ProgressBarVideoInfoWidget$1(ProgressBarVideoInfoWidget paramProgressBarVideoInfoWidget) {}
  
  public void e()
  {
    super.e();
    if (LiuHaiUtils.c(this.a.y()))
    {
      LinearLayout localLinearLayout = (LinearLayout)this.a.d().b.findViewById(2131429674);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.height = ProgressBarVideoInfoWidget.a(this.a);
      if (!ScreenUtil.checkDeviceHasNavigationBar(this.a.b.getContext())) {
        localLinearLayout.setBackgroundColor(Color.parseColor("#181818"));
      }
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void h()
  {
    super.h();
    ProgressBarVideoInfoWidget.b(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.ProgressBarVideoInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */