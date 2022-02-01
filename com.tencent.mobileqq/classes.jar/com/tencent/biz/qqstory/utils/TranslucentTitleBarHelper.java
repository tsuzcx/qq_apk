package com.tencent.biz.qqstory.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;

public class TranslucentTitleBarHelper
{
  float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  boolean jdField_a_of_type_Boolean = false;
  TextView b;
  TextView c;
  
  public TranslucentTitleBarHelper(BaseActivity paramBaseActivity, int paramInt)
  {
    int i = ImmersiveUtils.isSupporImmersive();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      paramBaseActivity.mActNeedImmersive = false;
      paramBaseActivity.mNeedStatusTrans = false;
      paramBaseActivity.getWindow().addFlags(67108864);
    }
    this.jdField_a_of_type_Int = DisplayUtil.a(paramBaseActivity, paramInt);
  }
  
  private void a(float paramFloat)
  {
    int i = (int)(255.0F * paramFloat);
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setAlpha(i);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.invalidateDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setAlpha(paramFloat);
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(paramFloat);
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
      this.jdField_a_of_type_AndroidContentResColorStateList = this.b.getTextColors();
    }
    if (paramFloat > 0.5D)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
      this.b.setBackgroundResource(2130851066);
      this.b.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      this.c.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
    this.b.setBackgroundResource(2130851066);
    localObject = this.b;
    ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColorStateList(2131167053));
    localObject = this.c;
    ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColorStateList(2131167053));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131378837));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369249));
    this.b = ((TextView)paramView.findViewById(2131369202));
    this.c = ((TextView)paramView.findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369216));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131378881));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramInt1 = -paramAbsListView.getChildAt(0).getTop();
      if ((paramInt1 > this.jdField_a_of_type_Int) && (!a()))
      {
        a(true, true);
        return;
      }
      if ((paramInt1 < this.jdField_a_of_type_Int) && (a())) {
        a(false, true);
      }
    }
    else if ((paramInt1 > 0) && (!a()))
    {
      a(true, true);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f;
    if (paramBoolean1) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    if (this.jdField_a_of_type_Float == f) {
      return;
    }
    if (paramBoolean2)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setFloatValues(new float[] { this.jdField_a_of_type_Float, f });
      localValueAnimator.addUpdateListener(new TranslucentTitleBarHelper.1(this));
      localValueAnimator.setDuration(500L);
      localValueAnimator.start();
    }
    else
    {
      a(f);
    }
    this.jdField_a_of_type_Float = f;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Float > 0.5D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper
 * JD-Core Version:    0.7.0.1
 */