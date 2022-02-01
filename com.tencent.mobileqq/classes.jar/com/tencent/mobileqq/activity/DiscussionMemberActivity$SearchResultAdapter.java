package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class DiscussionMemberActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List<DiscussionMemberActivity.DiscussionMember> jdField_a_of_type_JavaUtilList;
  
  public DiscussionMemberActivity$SearchResultAdapter(List<DiscussionMemberActivity.DiscussionMember> paramList)
  {
    super(paramList, paramList.app, paramList.a, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2131559069, paramViewGroup, false);
      paramView = new DiscussionMemberActivity.SearchViewHolder(null);
      paramView.c = ((ImageView)localView.findViewById(2131369373));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379778));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (DiscussionMemberActivity.SearchViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (DiscussionMemberActivity.DiscussionMember)getItem(paramInt);
    if (localObject != null)
    {
      if ((((DiscussionMemberActivity.DiscussionMember)localObject).b != null) && (!"".equals(((DiscussionMemberActivity.DiscussionMember)localObject).b.trim()))) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionMemberActivity.DiscussionMember)localObject).b);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionMemberActivity.DiscussionMember)localObject).jdField_a_of_type_JavaLangString);
      }
      paramView.jdField_a_of_type_JavaLangString = ((DiscussionMemberActivity.DiscussionMember)localObject).jdField_a_of_type_JavaLangString;
      paramView.c.setImageBitmap(a(1, ((DiscussionMemberActivity.DiscussionMember)localObject).jdField_a_of_type_JavaLangString));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */