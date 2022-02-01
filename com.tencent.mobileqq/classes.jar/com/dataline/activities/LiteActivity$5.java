package com.dataline.activities;

import android.view.View;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class LiteActivity$5
  implements OverScrollViewListener
{
  LiteActivity$5(LiteActivity paramLiteActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.a.c();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.5
 * JD-Core Version:    0.7.0.1
 */