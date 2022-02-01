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
  private Context b;
  private List<ArkAiInfo> c;
  
  public ArkAiAppPanel$ArkInputPanelTabAdapter(ArkAiAppPanel paramArkAiAppPanel, Context paramContext)
  {
    this.b = paramContext;
    this.c = new ArrayList();
  }
  
  public ArkAiInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c.size())) {
      return (ArkAiInfo)this.c.get(paramInt);
    }
    return null;
  }
  
  public void a(List<ArkAiInfo> paramList)
  {
    this.c.clear();
    this.c.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.c.size();
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
      localViewHolder.a = new RelativeLayout(this.b);
      localViewHolder.a.setBackgroundResource(2130846329);
      paramView = new ViewGroup.LayoutParams(MessageForArkApp.dp2px(50.0F), -1);
      localViewHolder.a.setLayoutParams(paramView);
      localViewHolder.b = new ImageView(this.b);
      paramView = new RelativeLayout.LayoutParams(MessageForArkApp.dp2px(28.0F), MessageForArkApp.dp2px(25.0F));
      paramView.addRule(13);
      localViewHolder.a.addView(localViewHolder.b, paramView);
      paramView = localViewHolder.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.ArkInputPanelTabAdapter
 * JD-Core Version:    0.7.0.1
 */