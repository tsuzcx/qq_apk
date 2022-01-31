package com.tencent.biz.ui;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.widget.XBaseAdapter;
import java.util.HashSet;
import pei;
import pej;

public class CustomAnimationAdapter
  extends XBaseAdapter
{
  private HashSet a = new HashSet();
  
  private void a(View paramView)
  {
    paramView = paramView.findViewById(2131362845);
    if (paramView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -paramView.getHeight(), 0 });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new pej(this, paramView));
    localValueAnimator.start();
  }
  
  public View a(View paramView, int paramInt)
  {
    View localView;
    if (paramView == null) {
      localView = null;
    }
    do
    {
      return localView;
      localView = paramView;
    } while (!this.a.contains(Integer.valueOf(paramInt)));
    this.a.remove(Integer.valueOf(paramInt));
    paramView.getViewTreeObserver().addOnPreDrawListener(new pei(this, paramView));
    return paramView;
  }
  
  public void c(int paramInt)
  {
    this.a.add(Integer.valueOf(paramInt));
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.CustomAnimationAdapter
 * JD-Core Version:    0.7.0.1
 */