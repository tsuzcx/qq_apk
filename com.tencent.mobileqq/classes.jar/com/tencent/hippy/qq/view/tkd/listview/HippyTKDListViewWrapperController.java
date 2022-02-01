package com.tencent.hippy.qq.view.tkd.listview;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;

@HippyController(name="QBListViewWrapper")
public class HippyTKDListViewWrapperController
  extends HippyViewGroupController
{
  public static final String CLASS_NAME = "QBListViewWrapper";
  private static final int LISTVIEW_INDEX = 1;
  View mCustomHippyRefreshView;
  int mCustomHippyRefreshViewHeight;
  View.OnLayoutChangeListener mLayoutChangeListener;
  
  protected void addView(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    super.addView(paramViewGroup, paramView, paramInt);
    if (paramInt == 0)
    {
      this.mCustomHippyRefreshView = paramView;
      paramView.setVisibility(8);
      if ((paramViewGroup.getChildCount() > 1) && (paramViewGroup.getChildAt(1) != null)) {
        ((HippyTKDListView)paramViewGroup.getChildAt(1)).setCustomHippyRefreshView(this.mCustomHippyRefreshView);
      }
    }
    else if ((paramView instanceof HippyTKDListView))
    {
      ((HippyTKDListView)paramView).setCustomHippyRefreshView(this.mCustomHippyRefreshView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewWrapperController
 * JD-Core Version:    0.7.0.1
 */