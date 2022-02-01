package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class SearchFriendListActivity$SearchFriendAdapter
  extends BaseAdapter
{
  private SearchFriendListActivity$SearchFriendAdapter(SearchFriendListActivity paramSearchFriendListActivity) {}
  
  public int getCount()
  {
    return SearchFriendListActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < SearchFriendListActivity.a(this.a).size())) {
      return SearchFriendListActivity.a(this.a).get(paramInt);
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
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131629221, paramViewGroup, false);
      paramView = new SearchFriendListActivity.ViewHolder();
      paramView.a = ((ImageView)localView.findViewById(2131434916));
      paramView.b = ((TextView)localView.findViewById(2131439319));
      paramView.c = ((TextView)localView.findViewById(2131431672));
      localView.setTag(paramView);
      localView.setOnClickListener(this.a);
    }
    this.a.a(localView, paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity.SearchFriendAdapter
 * JD-Core Version:    0.7.0.1
 */