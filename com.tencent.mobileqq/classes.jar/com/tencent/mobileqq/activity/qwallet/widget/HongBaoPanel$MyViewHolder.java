package com.tencent.mobileqq.activity.qwallet.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HongBaoPanel$MyViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  RelativeLayout hbRedPointContainer;
  ImageView hongbaoPic;
  TextView hongbaoText;
  ImageView imgFlag;
  HongBaoPanel.OnHolderItemClickListener mClickListener;
  
  public HongBaoPanel$MyViewHolder(HongBaoPanel paramHongBaoPanel, View paramView, HongBaoPanel.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.mClickListener = paramOnHolderItemClickListener;
    paramView.setOnClickListener(this);
    if (paramHongBaoPanel.isSoftKeyBoardHeight)
    {
      paramOnHolderItemClickListener = paramView.getLayoutParams();
      paramOnHolderItemClickListener.height += paramHongBaoPanel.itemTopMargin + 5;
    }
    this.hongbaoPic = ((ImageView)paramView.findViewById(2131367883));
    this.hongbaoText = ((TextView)paramView.findViewById(2131367901));
    if (HongBaoPanel.access$700(paramHongBaoPanel)) {
      this.hongbaoText.setTextColor(HongBaoPanel.access$800(paramHongBaoPanel));
    }
    this.hbRedPointContainer = ((RelativeLayout)paramView.findViewById(2131367892));
    this.imgFlag = ((ImageView)paramView.findViewById(2131368530));
  }
  
  public void onClick(View paramView)
  {
    if (this.mClickListener != null) {
      this.mClickListener.onItemClick(paramView, getPosition());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */