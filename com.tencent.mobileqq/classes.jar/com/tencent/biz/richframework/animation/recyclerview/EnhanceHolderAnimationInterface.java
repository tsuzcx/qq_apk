package com.tencent.biz.richframework.animation.recyclerview;

import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract interface EnhanceHolderAnimationInterface
{
  public abstract ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract ViewPropertyAnimatorCompat a(EnhanceItemAnimator.ChangeInfo paramChangeInfo, long paramLong, boolean paramBoolean);
  
  public abstract ViewPropertyAnimatorCompat a(EnhanceItemAnimator.MoveInfo paramMoveInfo, long paramLong);
  
  public abstract boolean a(EnhanceItemAnimator.ChangeInfo paramChangeInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceHolderAnimationInterface
 * JD-Core Version:    0.7.0.1
 */