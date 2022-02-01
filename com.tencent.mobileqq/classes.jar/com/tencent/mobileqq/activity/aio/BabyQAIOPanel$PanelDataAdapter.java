package com.tencent.mobileqq.activity.aio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class BabyQAIOPanel$PanelDataAdapter
  extends BaseAdapter
{
  BabyQAIOPanel$PanelDataAdapter(BabyQAIOPanel paramBabyQAIOPanel) {}
  
  public BabyQAIOPanel.GridItemData a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < BabyQAIOPanel.a(this.a).size())) {
      return (BabyQAIOPanel.GridItemData)BabyQAIOPanel.a(this.a).get(paramInt);
    }
    return new BabyQAIOPanel.GridItemData();
  }
  
  public int getCount()
  {
    return BabyQAIOPanel.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BabyQAIOPanel.GridItemViewHolder localGridItemViewHolder;
    if (paramView == null)
    {
      localGridItemViewHolder = new BabyQAIOPanel.GridItemViewHolder();
      paramView = LayoutInflater.from(BabyQAIOPanel.a(this.a)).inflate(2131558526, paramViewGroup, false);
      localGridItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369090));
      localGridItemViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368367));
      localGridItemViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378476));
      localGridItemViewHolder.b = ((ImageView)paramView.findViewById(2131371804));
      paramView.setTag(localGridItemViewHolder);
    }
    else
    {
      localGridItemViewHolder = (BabyQAIOPanel.GridItemViewHolder)paramView.getTag();
    }
    Object localObject = (RelativeLayout.LayoutParams)localGridItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (paramInt % 2 != 0)
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.a.getContext(), 8.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.a.getContext(), 12.0F);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.a.getContext(), 12.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.a.getContext(), 8.0F);
    }
    localGridItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a(paramInt);
    localGridItemViewHolder.jdField_a_of_type_Int = ((BabyQAIOPanel.GridItemData)localObject).jdField_a_of_type_Int;
    localGridItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((BabyQAIOPanel.GridItemData)localObject).jdField_a_of_type_JavaLangString);
    localGridItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((BabyQAIOPanel.GridItemData)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if (((BabyQAIOPanel.GridItemData)localObject).jdField_a_of_type_Boolean) {
      localGridItemViewHolder.b.setVisibility(0);
    } else {
      localGridItemViewHolder.b.setVisibility(8);
    }
    paramView.setOnClickListener(this.a);
    if (AppSetting.d) {
      paramView.setContentDescription(((BabyQAIOPanel.GridItemData)localObject).jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel.PanelDataAdapter
 * JD-Core Version:    0.7.0.1
 */