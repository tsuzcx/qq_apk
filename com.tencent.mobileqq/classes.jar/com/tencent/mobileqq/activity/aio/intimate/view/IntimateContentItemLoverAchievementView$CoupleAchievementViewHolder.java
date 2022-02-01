package com.tencent.mobileqq.activity.aio.intimate.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo.LoveAchievementItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;

class IntimateContentItemLoverAchievementView$CoupleAchievementViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnTouchListener
{
  public RoundRectImageView a;
  
  public IntimateContentItemLoverAchievementView$CoupleAchievementViewHolder(IntimateContentItemLoverAchievementView paramIntimateContentItemLoverAchievementView, @NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131365278));
    paramView.setOnClickListener(this);
    paramView.setOnTouchListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (IntimateContentItemLoverAchievementView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView) != null) {
      IntimateContentItemLoverAchievementView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView).a(paramView, getLayoutPosition(), (LoveAchievementInfo.LoveAchievementItem)paramView.getTag());
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView.CoupleAchievementViewHolder
 * JD-Core Version:    0.7.0.1
 */