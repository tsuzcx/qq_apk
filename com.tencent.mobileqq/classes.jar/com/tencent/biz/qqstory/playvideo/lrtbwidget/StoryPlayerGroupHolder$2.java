package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.util.LiuHaiUtils;

class StoryPlayerGroupHolder$2
  implements XViewPager.OnVisibilityChangeListener
{
  StoryPlayerGroupHolder$2(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(@NonNull View paramView, int paramInt)
  {
    if (LiuHaiUtils.a)
    {
      paramInt = StoryPlayerGroupHolder.a(this.a);
      paramView = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
      paramView.bottomMargin = paramInt;
      this.a.a.setLayoutParams(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.2
 * JD-Core Version:    0.7.0.1
 */