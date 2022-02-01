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
    if ((paramInt < 0) || (paramInt >= SearchFriendListActivity.a(this.a).size())) {
      return null;
    }
    return SearchFriendListActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131562957, paramViewGroup, false);
      SearchFriendListActivity.ViewHolder localViewHolder = new SearchFriendListActivity.ViewHolder();
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368314));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372287));
      localViewHolder.b = ((TextView)paramView.findViewById(2131365616));
      paramView.setTag(localViewHolder);
      paramView.setOnClickListener(this.a);
    }
    for (;;)
    {
      this.a.a(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity.SearchFriendAdapter
 * JD-Core Version:    0.7.0.1
 */