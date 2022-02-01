package androidx.recyclerview.widget;

import android.view.View;

class ScrollbarHelper
{
  static int computeScrollExtent(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    if ((paramLayoutManager.getChildCount() != 0) && (paramState.getItemCount() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2)) + 1;
      }
      int i = paramOrientationHelper.getDecoratedEnd(paramView2);
      int j = paramOrientationHelper.getDecoratedStart(paramView1);
      return Math.min(paramOrientationHelper.getTotalSpace(), i - j);
    }
    return 0;
  }
  
  static int computeScrollOffset(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramLayoutManager.getChildCount() != 0) && (paramState.getItemCount() != 0) && (paramView1 != null))
    {
      if (paramView2 == null) {
        return 0;
      }
      int i = Math.min(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
      int j = Math.max(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
      if (paramBoolean2) {
        i = Math.max(0, paramState.getItemCount() - j - 1);
      } else {
        i = Math.max(0, i);
      }
      if (!paramBoolean1) {
        return i;
      }
      j = Math.abs(paramOrientationHelper.getDecoratedEnd(paramView2) - paramOrientationHelper.getDecoratedStart(paramView1));
      int k = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramOrientationHelper.getStartAfterPadding() - paramOrientationHelper.getDecoratedStart(paramView1)));
    }
    return 0;
  }
  
  static int computeScrollRange(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    if ((paramLayoutManager.getChildCount() != 0) && (paramState.getItemCount() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return paramState.getItemCount();
      }
      int i = paramOrientationHelper.getDecoratedEnd(paramView2);
      int j = paramOrientationHelper.getDecoratedStart(paramView1);
      int k = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
      return (int)((i - j) / (k + 1) * paramState.getItemCount());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ScrollbarHelper
 * JD-Core Version:    0.7.0.1
 */