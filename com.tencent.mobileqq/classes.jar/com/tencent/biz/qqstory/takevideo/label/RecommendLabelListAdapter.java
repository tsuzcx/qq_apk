package com.tencent.biz.qqstory.takevideo.label;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class RecommendLabelListAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    ((TextView)paramBaseViewHolder.a(2131376758)).setText("#" + (String)this.jdField_a_of_type_JavaUtilList.get(paramInt));
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
    for (Object localObject = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561913, paramViewGroup, false));; localObject = (BaseViewHolder)paramView.getTag())
    {
      a((BaseViewHolder)localObject, paramInt);
      localObject = ((BaseViewHolder)localObject).a();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.label.RecommendLabelListAdapter
 * JD-Core Version:    0.7.0.1
 */