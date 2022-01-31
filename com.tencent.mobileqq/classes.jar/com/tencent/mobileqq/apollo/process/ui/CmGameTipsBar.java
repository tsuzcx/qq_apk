package com.tencent.mobileqq.apollo.process.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.qphone.base.util.QLog;

public class CmGameTipsBar
  implements TipsBarTask
{
  public Context a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  public RelativeLayout a;
  public TextView a;
  private Animation b;
  public RelativeLayout b;
  public TextView b;
  public RelativeLayout c;
  
  public CmGameTipsBar(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new RelativeLayout.LayoutParams(-1, AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("等待好友加入");
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramOnClickListener = a(2130838078);
    paramOnClickListener.setBounds(0, 0, paramOnClickListener.getIntrinsicWidth(), paramOnClickListener.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnClickListener, null, null, null);
    paramContext = new RelativeLayout.LayoutParams(-2, AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramContext.addRule(15);
    paramContext.leftMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramContext.addRule(9);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramContext = new StateListDrawable();
    Drawable localDrawable1 = a(2130838166);
    Drawable localDrawable2 = a(2130838167);
    paramContext.addState(new int[] { 16842919, 16842910 }, localDrawable2);
    paramContext.addState(new int[0], localDrawable1);
    ((ImageView)localObject).setImageDrawable(paramContext);
    ((ImageView)localObject).setDuplicateParentStateEnabled(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    this.c = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("等待好友加入");
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnClickListener, null, null, null);
    paramOnClickListener = new RelativeLayout.LayoutParams(-2, AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramOnClickListener.addRule(15);
    paramOnClickListener.leftMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramOnClickListener.addRule(9);
    this.c.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramOnClickListener);
    paramOnClickListener = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramOnClickListener.setImageDrawable(paramContext);
    paramOnClickListener.setDuplicateParentStateEnabled(true);
    this.c.addView(paramOnClickListener, (ViewGroup.LayoutParams)localObject);
    this.c.setVisibility(4);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
    paramContext = new AlphaAnimation(0.0F, 1.0F);
    paramContext.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(paramContext);
    paramContext = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramContext.setDuration(500L);
    paramContext.setInterpolator(new OvershootInterpolator(1.3F));
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(paramContext);
  }
  
  public int a()
  {
    return 40;
  }
  
  public Drawable a(int paramInt)
  {
    try
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      ColorDrawable localColorDrawable = new ColorDrawable(-1);
      localThrowable.printStackTrace();
      QLog.e("CmGameTipsBar", 2, localThrowable.getMessage());
      return localColorDrawable;
    }
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.c.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
    this.c.clearAnimation();
    this.c.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 15;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.c.clearAnimation();
    this.c.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.CmGameTipsBar
 * JD-Core Version:    0.7.0.1
 */