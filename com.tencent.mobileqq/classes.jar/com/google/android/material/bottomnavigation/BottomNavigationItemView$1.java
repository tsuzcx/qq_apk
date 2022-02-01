package com.google.android.material.bottomnavigation;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;

class BottomNavigationItemView$1
  implements View.OnLayoutChangeListener
{
  BottomNavigationItemView$1(BottomNavigationItemView paramBottomNavigationItemView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (BottomNavigationItemView.a(this.a).getVisibility() == 0)
    {
      paramView = this.a;
      BottomNavigationItemView.a(paramView, BottomNavigationItemView.a(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationItemView.1
 * JD-Core Version:    0.7.0.1
 */