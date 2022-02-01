package com.tencent.mobileqq.adapter;

import alja;
import aljb;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.mini.widget.media.danmu.DecelerateAccelerateInterpolator;

public class ForwardRecentItemView
  extends RelativeLayout
{
  public int a;
  public View a;
  public CheckBox a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public ResultRecord a;
  public String a;
  public int b;
  public View b;
  public TextView b;
  
  public ForwardRecentItemView(Context paramContext)
  {
    super(paramContext);
    a();
    b();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131562697, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376541));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378368));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378370));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368236));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131364530));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379811);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = getResources().getDimensionPixelOffset(2131298198);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelOffset(2131296819);
  }
  
  public void a(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -this.jdField_a_of_type_Int, 0 });
    localValueAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new alja(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable, ResultRecord paramResultRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString1, paramString2, paramDrawable, paramResultRecord, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable, ResultRecord paramResultRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 8;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord = paramResultRecord;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    if (TextUtils.isEmpty(paramString2))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        paramString2 = this.jdField_b_of_type_AndroidViewView;
        if (paramBoolean3) {
          i = 0;
        }
        paramString2.setVisibility(i);
      }
      paramString2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramString2.leftMargin = (-this.jdField_a_of_type_Int);
      i = this.jdField_b_of_type_Int;
      if (!paramBoolean1) {
        break label207;
      }
      paramString2.leftMargin = 0;
      i -= this.jdField_a_of_type_Int;
    }
    label207:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramString2);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean2);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i);
      if (AppSetting.c) {
        setContentDescription(paramString1);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramString2.startsWith("("))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%s)", new Object[] { paramString2 }));
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
    Object localObject;
    if (AppSetting.c)
    {
      localObject = getResources();
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i = 2131690748;; i = 2131719368)
    {
      localObject = ((Resources)localObject).getString(i);
      setContentDescription(this.jdField_a_of_type_JavaLangString + (String)localObject);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.jdField_a_of_type_Int });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new aljb(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void setMultiSelectStatus()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentItemView
 * JD-Core Version:    0.7.0.1
 */