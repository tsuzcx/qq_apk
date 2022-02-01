package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import java.util.Comparator;

class XViewPager$ViewPositionComparator
  implements Comparator<View>
{
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (XViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (XViewPager.LayoutParams)paramView2.getLayoutParams();
    if (paramView1.a != paramView2.a)
    {
      if (paramView1.a) {
        return 1;
      }
      return -1;
    }
    return paramView1.b - paramView2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.ViewPositionComparator
 * JD-Core Version:    0.7.0.1
 */