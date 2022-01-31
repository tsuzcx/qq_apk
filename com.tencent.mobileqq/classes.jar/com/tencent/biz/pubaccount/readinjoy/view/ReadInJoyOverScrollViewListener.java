package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public abstract interface ReadInJoyOverScrollViewListener
  extends OverScrollViewListener
{
  public abstract void a(int paramInt1, View paramView, ListView paramListView, int paramInt2);
  
  public abstract void a(View paramView, ListView paramListView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyOverScrollViewListener
 * JD-Core Version:    0.7.0.1
 */