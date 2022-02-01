package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class SimpleUIChoiceView$ColorHolder
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  URLImageView b;
  
  public SimpleUIChoiceView$ColorHolder(SimpleUIChoiceView paramSimpleUIChoiceView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368591));
    this.b = ((URLImageView)paramView.findViewById(2131368606));
    this.b.setBackgroundDrawable(a());
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370360);
  }
  
  private Drawable a()
  {
    Resources localResources = this.itemView.getResources();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(5.0F, localResources));
    localGradientDrawable.setStroke(AIOUtils.b(1.5F, localResources), localResources.getColor(2131167166));
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorHolder
 * JD-Core Version:    0.7.0.1
 */