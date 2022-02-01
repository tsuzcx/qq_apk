package com.tencent.mobileqq.activity.aio.intimate.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;

class IntimateContentItemNewDnaView$FriendDnaViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnTouchListener
{
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public RoundRectImageView a;
  
  public IntimateContentItemNewDnaView$FriendDnaViewHolder(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView, @NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369011));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367306));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367303));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131369014));
    paramView.setOnClickListener(this);
    paramView.setOnTouchListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (IntimateContentItemNewDnaView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView) != null) {
      IntimateContentItemNewDnaView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView).a(paramView, getLayoutPosition(), (NewDnaInfo)this.itemView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView.FriendDnaViewHolder
 * JD-Core Version:    0.7.0.1
 */