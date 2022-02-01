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
      paramView = LayoutInflater.from(BabyQAIOPanel.b(this.a)).inflate(2131624079, paramViewGroup, false);
      localGridItemViewHolder.a = ((RelativeLayout)paramView.findViewById(2131436054));
      localGridItemViewHolder.c = ((ImageView)paramView.findViewById(2131435246));
      localGridItemViewHolder.b = ((TextView)paramView.findViewById(2131447090));
      localGridItemViewHolder.d = ((ImageView)paramView.findViewById(2131439239));
      paramView.setTag(localGridItemViewHolder);
    }
    else
    {
      localGridItemViewHolder = (BabyQAIOPanel.GridItemViewHolder)paramView.getTag();
    }
    Object localObject = (RelativeLayout.LayoutParams)localGridItemViewHolder.a.getLayoutParams();
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
    localGridItemViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a(paramInt);
    localGridItemViewHolder.e = ((BabyQAIOPanel.GridItemData)localObject).d;
    localGridItemViewHolder.b.setText(((BabyQAIOPanel.GridItemData)localObject).a);
    localGridItemViewHolder.c.setImageDrawable(((BabyQAIOPanel.GridItemData)localObject).b);
    if (((BabyQAIOPanel.GridItemData)localObject).c) {
      localGridItemViewHolder.d.setVisibility(0);
    } else {
      localGridItemViewHolder.d.setVisibility(8);
    }
    paramView.setOnClickListener(this.a);
    if (AppSetting.e) {
      paramView.setContentDescription(((BabyQAIOPanel.GridItemData)localObject).a);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel.PanelDataAdapter
 * JD-Core Version:    0.7.0.1
 */