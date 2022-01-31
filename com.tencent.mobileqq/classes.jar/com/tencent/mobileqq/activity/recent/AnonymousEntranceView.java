package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import xic;
import xid;

public class AnonymousEntranceView
  extends RelativeLayout
{
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  private ImageView d;
  
  public AnonymousEntranceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AnonymousEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AnonymousEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    localObject = new RotateAnimation(-75.0F, 75.0F, 1, 0.5F, 1, 1.073F);
    ((Animation)localObject).setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(300L);
    ((Animation)localObject).setStartOffset(1200L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new xic(this));
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(400L);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(400L);
    ((Animation)localObject).setStartOffset(400L);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new xid(this));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, a(getContext(), 30.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838674);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838675);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    addView(this.jdField_b_of_type_AndroidWidgetImageView);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, a(getContext(), 59.0F), 0, 0);
    this.c = new ImageView(getContext());
    this.c.setImageResource(2130838676);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setPadding(0, 0, a(getContext(), 10.0F), 0);
    addView(this.c);
    this.d = new ImageView(getContext());
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setImageResource(2130838677);
    this.d.setPadding(0, 0, a(getContext(), 10.0F), 0);
    this.d.setVisibility(4);
    addView(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AnonymousEntranceView
 * JD-Core Version:    0.7.0.1
 */