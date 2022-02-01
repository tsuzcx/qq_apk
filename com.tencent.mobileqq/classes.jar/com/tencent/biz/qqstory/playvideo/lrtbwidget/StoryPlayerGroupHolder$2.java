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
    if (LiuHaiUtils.b)
    {
      paramInt = StoryPlayerGroupHolder.b(this.a);
      paramView = (RelativeLayout.LayoutParams)this.a.j.getLayoutParams();
      paramView.bottomMargin = paramInt;
      this.a.j.setLayoutParams(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.2
 * JD-Core Version:    0.7.0.1
 */