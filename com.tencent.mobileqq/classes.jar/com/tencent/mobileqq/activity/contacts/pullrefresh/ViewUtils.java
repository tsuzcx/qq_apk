package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;

public class ViewUtils
{
  public static boolean a(View paramView)
  {
    boolean bool2 = paramView instanceof HeaderScrollView;
    boolean bool1 = true;
    if (bool2) {
      return ((HeaderScrollView)paramView).b() ^ true;
    }
    if ((paramView instanceof ViewGroup))
    {
      View localView = ((ViewGroup)paramView).getChildAt(1);
      if ((localView != null) && ((localView instanceof HeaderScrollView))) {
        return ((HeaderScrollView)localView).b() ^ true;
      }
    }
    else if ((paramView instanceof AbsListView))
    {
      paramView = (AbsListView)paramView;
      if (paramView.getChildCount() > 0)
      {
        if (paramView.getFirstVisiblePosition() > 0) {
          break label103;
        }
        if (paramView.getChildAt(0).getTop() < paramView.getPaddingTop()) {
          return true;
        }
      }
      bool1 = false;
      label103:
      return bool1;
    }
    return ViewCompat.canScrollVertically(paramView, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.ViewUtils
 * JD-Core Version:    0.7.0.1
 */