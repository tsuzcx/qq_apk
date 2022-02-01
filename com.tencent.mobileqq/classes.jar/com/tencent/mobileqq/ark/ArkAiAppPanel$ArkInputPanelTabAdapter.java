package com.tencent.mobileqq.ark;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ArkAiAppPanel$ArkInputPanelTabAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<ArkAiInfo> jdField_a_of_type_JavaUtilList;
  
  public ArkAiAppPanel$ArkInputPanelTabAdapter(ArkAiAppPanel paramArkAiAppPanel, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ArkAiInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (ArkAiInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<ArkAiInfo> paramList)
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
    ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder(this);
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844895);
      paramView = new ViewGroup.LayoutParams(MessageForArkApp.dp2px(50.0F), -1);
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(MessageForArkApp.dp2px(28.0F), MessageForArkApp.dp2px(25.0F));
      paramView.addRule(13);
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramView);
      paramView = localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder)paramView.getTag();
    }
    ArkAiInfo localArkAiInfo = a(paramInt);
    if ((localArkAiInfo != null) && (!TextUtils.isEmpty(localArkAiInfo.d))) {
      ArkAppCacheMgr.getAppIcon(localArkAiInfo.a, new ArkAiAppPanel.ArkInputPanelTabAdapter.1(this, localViewHolder));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.ArkInputPanelTabAdapter
 * JD-Core Version:    0.7.0.1
 */