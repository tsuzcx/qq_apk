package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
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
    if (paramView == null)
    {
      HorizontalSelectColorLayout.SelectColorAdapter.ItemHold localItemHold = new HorizontalSelectColorLayout.SelectColorAdapter.ItemHold(this);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559074, paramViewGroup, false);
        localItemHold.b = ((ImageView)paramView.findViewById(2131369152));
      }
      else
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559073, paramViewGroup, false);
      }
      localItemHold.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369003));
      localItemHold.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369002));
      paramView.setTag(localItemHold);
      paramViewGroup = localItemHold;
    }
    else
    {
      paramViewGroup = (HorizontalSelectColorLayout.SelectColorAdapter.ItemHold)paramView.getTag();
    }
    if (Build.VERSION.SDK_INT < 21) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localHorizontalStroke.a);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
        paramViewGroup.b.setVisibility(0);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130845083));
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
      paramViewGroup.b.setVisibility(4);
    } else {
      paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
    }
    if (localHorizontalStroke.b != null) {
      paramView.setContentDescription(localHorizontalStroke.b);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.SelectColorAdapter
 * JD-Core Version:    0.7.0.1
 */