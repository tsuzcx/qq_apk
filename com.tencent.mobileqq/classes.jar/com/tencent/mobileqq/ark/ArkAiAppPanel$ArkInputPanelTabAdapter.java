package com.tencent.mobileqq.ark;

import aaru;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.List;

public class ArkAiAppPanel$ArkInputPanelTabAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList;
  
  public ArkAiAppPanel$ArkInputPanelTabAdapter(ArkAiAppPanel paramArkAiAppPanel, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ArkAiInfo a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (ArkAiInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842249);
      paramView = new ViewGroup.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.addRule(13);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, paramView);
      paramView = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ArkAiInfo localArkAiInfo = a(paramInt);
      if ((localArkAiInfo != null) && (!TextUtils.isEmpty(localArkAiInfo.d))) {
        ArkAppCenter.a(localArkAiInfo.d, new aaru(this, paramViewGroup));
      }
      return paramView;
      paramViewGroup = (ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.ArkInputPanelTabAdapter
 * JD-Core Version:    0.7.0.1
 */