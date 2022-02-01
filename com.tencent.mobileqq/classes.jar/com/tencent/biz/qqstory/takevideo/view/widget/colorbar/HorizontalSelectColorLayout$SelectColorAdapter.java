package com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class HorizontalSelectColorLayout$SelectColorAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<HorizontalStroke> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public HorizontalSelectColorLayout$SelectColorAdapter(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<HorizontalStroke> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HorizontalStroke localHorizontalStroke = (HorizontalStroke)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561790, paramViewGroup, false);
      paramView = new HorizontalSelectColorLayout.SelectColorAdapter.ItemHold(this);
      paramView.a = ((ImageView)localView.findViewById(2131369274));
      paramView.b = ((ImageView)localView.findViewById(2131369424));
      localView.setTag(paramView);
      paramView.a.setImageDrawable(localHorizontalStroke.a);
      if (paramInt != this.jdField_a_of_type_Int) {
        break label137;
      }
      paramView.b.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      HorizontalSelectColorLayout.SelectColorAdapter.ItemHold localItemHold = (HorizontalSelectColorLayout.SelectColorAdapter.ItemHold)paramView.getTag();
      localView = paramView;
      paramView = localItemHold;
      break;
      label137:
      paramView.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.SelectColorAdapter
 * JD-Core Version:    0.7.0.1
 */