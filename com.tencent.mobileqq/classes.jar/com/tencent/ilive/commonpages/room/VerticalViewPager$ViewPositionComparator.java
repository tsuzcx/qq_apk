package com.tencent.ilive.commonpages.room;

import android.view.View;
import java.util.Comparator;

class VerticalViewPager$ViewPositionComparator
  implements Comparator<View>
{
  public int compare(View paramView1, View paramView2)
  {
    paramView1 = (VerticalViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (VerticalViewPager.LayoutParams)paramView2.getLayoutParams();
    if (paramView1.isDecor != paramView2.isDecor)
    {
      if (paramView1.isDecor) {
        return 1;
      }
      return -1;
    }
    return paramView1.position - paramView2.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager.ViewPositionComparator
 * JD-Core Version:    0.7.0.1
 */