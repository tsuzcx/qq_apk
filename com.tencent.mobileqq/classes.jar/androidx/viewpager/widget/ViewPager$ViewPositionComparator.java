package androidx.viewpager.widget;

import android.view.View;
import java.util.Comparator;

class ViewPager$ViewPositionComparator
  implements Comparator<View>
{
  public int compare(View paramView1, View paramView2)
  {
    paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager.widget.ViewPager.ViewPositionComparator
 * JD-Core Version:    0.7.0.1
 */