package com.tencent.biz.richframework.animation.recyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;

public class EnhanceItemAnimator$ChangeInfo
{
  public int a;
  public RecyclerView.ViewHolder a;
  public int b;
  public RecyclerView.ViewHolder b;
  public int c;
  public int d;
  
  private EnhanceItemAnimator$ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder1;
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder2;
  }
  
  private EnhanceItemAnimator$ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramViewHolder1, paramViewHolder2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChangeInfo{oldHolder=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    localStringBuilder.append(", newHolder=");
    localStringBuilder.append(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    localStringBuilder.append(", fromX=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", fromY=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", toX=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", toY=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.ChangeInfo
 * JD-Core Version:    0.7.0.1
 */