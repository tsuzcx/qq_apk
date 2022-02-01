package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GesturePWDCreateActivity$PromptAdapter
  extends BaseAdapter
{
  private LayoutInflater b;
  
  public int getCount()
  {
    if (this.a.d != null) {
      return this.a.d.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a.d != null) && (paramInt < this.a.d.length) && (paramInt >= 0)) {
      return Integer.valueOf(this.a.d[paramInt]);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.b.inflate(2131624958, null);
    }
    paramView = localView.findViewById(2131434166);
    if ((this.a.d != null) && (paramInt >= 0) && (paramInt < this.a.d.length) && (this.a.d[paramInt] > 0)) {
      paramView.setBackgroundResource(2130846705);
    } else {
      paramView.setBackgroundResource(2130853309);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity.PromptAdapter
 * JD-Core Version:    0.7.0.1
 */