package com.tencent.biz.qqstory.takevideo.label;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import java.util.List;

public class RecommendLabelListAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList;
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    ((TextView)paramBaseViewHolder.a(2131371813)).setText("#" + (String)this.jdField_a_of_type_JavaUtilList.get(paramInt));
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
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (paramView = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970775, paramViewGroup, false));; paramView = (BaseViewHolder)paramView.getTag())
    {
      a(paramView, paramInt);
      return paramView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.label.RecommendLabelListAdapter
 * JD-Core Version:    0.7.0.1
 */