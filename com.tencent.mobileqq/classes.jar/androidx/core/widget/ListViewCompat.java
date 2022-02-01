package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;

public final class ListViewCompat
{
  public static boolean canScrollList(@NonNull ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramListView.canScrollList(paramInt);
    }
    int j = paramListView.getChildCount();
    boolean bool2 = false;
    boolean bool1 = false;
    if (j == 0) {
      return false;
    }
    int i = paramListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      paramInt = paramListView.getChildAt(j - 1).getBottom();
      if ((i + j < paramListView.getCount()) || (paramInt > paramListView.getHeight() - paramListView.getListPaddingBottom())) {
        bool1 = true;
      }
      return bool1;
    }
    paramInt = paramListView.getChildAt(0).getTop();
    if (i <= 0)
    {
      bool1 = bool2;
      if (paramInt >= paramListView.getListPaddingTop()) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void scrollListBy(@NonNull ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramListView.scrollListBy(paramInt);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    if (i == -1) {
      return;
    }
    View localView = paramListView.getChildAt(0);
    if (localView == null) {
      return;
    }
    paramListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.ListViewCompat
 * JD-Core Version:    0.7.0.1
 */