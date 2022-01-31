package com.qq.im.poi;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class LbsPackItemView
  extends LinearLayout
{
  Context jdField_a_of_type_AndroidContentContext;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  Button jdField_b_of_type_AndroidWidgetButton;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  TextView c;
  
  public LbsPackItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public LbsPackItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt1 == 0) {
      i = paramInt4 + paramInt2;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, -1);
    localLayoutParams.gravity = 17;
    setLayoutParams(localLayoutParams);
    if (paramInt1 == 0) {}
    for (paramInt1 = paramInt3 + paramInt2;; paramInt1 = paramInt3)
    {
      localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(350.0F, getResources()));
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.rightMargin = paramInt3;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LbsPackListAdapter.LbsPackListAdpterHolder paramLbsPackListAdpterHolder)
  {
    int i = paramInt4;
    if (paramInt1 == 0) {
      i = paramInt4 + paramInt2;
    }
    Object localObject = new LinearLayout.LayoutParams(i, -1);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    setGravity(17);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramInt1 == 0) {}
    for (paramInt1 = paramInt3 + paramInt2;; paramInt1 = paramInt3)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131362914);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(1);
      localObject = new LinearLayout.LayoutParams(-1, AIOUtils.a(350.0F, getResources()));
      ((LinearLayout.LayoutParams)localObject).leftMargin = paramInt1;
      ((LinearLayout.LayoutParams)localObject).rightMargin = paramInt3;
      addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      localObject = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.a(109.0F, getResources()), AIOUtils.a(109.0F, getResources()));
      localLayoutParams.topMargin = AIOUtils.a(62.5F, getResources());
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(AIOUtils.a(109.0F, getResources()), AIOUtils.a(109.0F, getResources()));
      localLayoutParams1.gravity = 17;
      ((FrameLayout)localObject).addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams1);
      this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams1 = new FrameLayout.LayoutParams(AIOUtils.a(84.0F, getResources()), AIOUtils.a(84.0F, getResources()));
      localLayoutParams1.gravity = 17;
      ((FrameLayout)localObject).addView(this.jdField_b_of_type_ComTencentImageURLImageView, localLayoutParams1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
      localObject = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject).setOrientation(0);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.a(17.5F, getResources());
      localLayoutParams.leftMargin = AIOUtils.a(15.0F, getResources());
      localLayoutParams.rightMargin = AIOUtils.a(15.0F, getResources());
      localLayoutParams.gravity = 17;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setId(2131362916);
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      ((LinearLayout)localObject).addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362917);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(20.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-863840);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("的AR红包");
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      this.c = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.c.setId(2131362918);
      this.c.setSingleLine(true);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(20.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(15.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(15.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.c, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      localObject = new LinearLayout.LayoutParams(-1, AIOUtils.a(40.0F, getResources()));
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(40.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(AIOUtils.a(16.0F, getResources()), 0, AIOUtils.a(6.0F, getResources()), 0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetButton.setId(2131362919);
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(10.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetButton.setId(2131362920);
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(10.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject);
      if (paramLbsPackListAdpterHolder == null) {
        break;
      }
      paramLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      paramLbsPackListAdpterHolder.jdField_a_of_type_ComTencentImageURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      paramLbsPackListAdpterHolder.jdField_b_of_type_ComTencentImageURLImageView = this.jdField_b_of_type_ComTencentImageURLImageView;
      paramLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      paramLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView = this.c;
      paramLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton = this.jdField_a_of_type_AndroidWidgetButton;
      paramLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton = this.jdField_b_of_type_AndroidWidgetButton;
      return;
    }
    QLog.e(LbsPackItemView.class.getName(), 2, "LbsPackItemView holder=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackItemView
 * JD-Core Version:    0.7.0.1
 */