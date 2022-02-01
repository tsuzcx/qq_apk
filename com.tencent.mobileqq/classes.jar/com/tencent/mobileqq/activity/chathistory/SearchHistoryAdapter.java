package com.tencent.mobileqq.activity.chathistory;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SearchHistoryAdapter
  extends BaseAdapter
{
  Handler a;
  QQAppInterface b;
  String[] c;
  
  public String a(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public int getCount()
  {
    String[] arrayOfString = this.c;
    if (arrayOfString == null) {
      return 0;
    }
    return arrayOfString.length;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = a(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625300, paramViewGroup, false);
      paramView = new SearchHistoryAdapter.HistoryHolder(localView);
    }
    else
    {
      SearchHistoryAdapter.HistoryHolder localHistoryHolder = (SearchHistoryAdapter.HistoryHolder)paramView.getTag();
      localView = paramView;
      paramView = localHistoryHolder;
    }
    paramView.a.setText(str);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */