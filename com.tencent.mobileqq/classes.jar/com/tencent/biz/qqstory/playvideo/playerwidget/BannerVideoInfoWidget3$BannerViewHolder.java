package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BannerVideoInfoWidget3$BannerViewHolder
{
  public int a;
  public Drawable a;
  public View a;
  public ImageView a;
  public TextView a;
  public ImageView b;
  public TextView b;
  public TextView c;
  
  public BannerVideoInfoWidget3$BannerViewHolder(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370447);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370446));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370435));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370431));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370445));
    this.c = ((TextView)paramView.findViewById(2131361948));
    this.jdField_a_of_type_Int = paramView.getContext().getResources().getDimensionPixelOffset(2131299061);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramView.getContext().getResources().getDrawable(2130839756);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839751);
    this.jdField_a_of_type_AndroidViewView.setPadding(this.jdField_a_of_type_AndroidViewView.getPaddingLeft(), this.jdField_a_of_type_AndroidViewView.getPaddingTop(), this.jdField_a_of_type_AndroidViewView.getPaddingRight(), this.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839756);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(null, 1);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("");
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.BannerViewHolder
 * JD-Core Version:    0.7.0.1
 */