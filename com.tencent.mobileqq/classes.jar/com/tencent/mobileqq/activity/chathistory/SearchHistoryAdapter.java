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
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
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
    View localView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559460, paramViewGroup, false);
    }
    SearchHistoryAdapter.HistoryHolder localHistoryHolder;
    for (paramView = new SearchHistoryAdapter.HistoryHolder(localView);; paramView = localHistoryHolder)
    {
      paramView.a.setText(str);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localHistoryHolder = (SearchHistoryAdapter.HistoryHolder)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */