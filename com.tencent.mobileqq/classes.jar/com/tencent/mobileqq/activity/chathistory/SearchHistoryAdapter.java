package com.tencent.mobileqq.activity.chathistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import wdk;

public class SearchHistoryAdapter
  extends BaseAdapter
{
  String[] a;
  
  public String a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = a(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969072, paramViewGroup, false);
    }
    for (paramViewGroup = new wdk(paramView);; paramViewGroup = (wdk)paramView.getTag())
    {
      paramViewGroup.a.setText(str);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */