package com.tencent.biz.widgets;

import android.util.SparseArray;
import android.view.View;

public class TabLayout$TabAdapter$TabViewHolder
{
  private SparseArray<View> a;
  private View b;
  
  private TabLayout$TabAdapter$TabViewHolder(View paramView)
  {
    this.b = paramView;
  }
  
  public View a()
  {
    return this.b;
  }
  
  public <T extends View> T a(int paramInt)
  {
    if (this.a == null) {
      this.a = new SparseArray();
    }
    if (this.a.get(paramInt) == null)
    {
      View localView = this.b;
      if (localView != null) {
        this.a.put(paramInt, localView.findViewById(paramInt));
      }
    }
    return (View)this.a.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.TabAdapter.TabViewHolder
 * JD-Core Version:    0.7.0.1
 */