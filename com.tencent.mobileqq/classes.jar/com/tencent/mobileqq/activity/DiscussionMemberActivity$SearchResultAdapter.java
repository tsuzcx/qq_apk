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
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
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
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2131559175, paramViewGroup, false);
      paramView = new DiscussionMemberActivity.SearchViewHolder(null);
      paramView.c = ((ImageView)localView.findViewById(2131369676));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380475));
      localView.setTag(paramView);
      localObject = (DiscussionMemberActivity.DiscussionMember)getItem(paramInt);
      if (localObject != null)
      {
        if ((((DiscussionMemberActivity.DiscussionMember)localObject).b != null) && (!"".equals(((DiscussionMemberActivity.DiscussionMember)localObject).b.trim()))) {
          break label176;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionMemberActivity.DiscussionMember)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = ((DiscussionMemberActivity.DiscussionMember)localObject).jdField_a_of_type_JavaLangString;
      paramView.c.setImageBitmap(a(1, ((DiscussionMemberActivity.DiscussionMember)localObject).jdField_a_of_type_JavaLangString));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (DiscussionMemberActivity.SearchViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label176:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionMemberActivity.DiscussionMember)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */