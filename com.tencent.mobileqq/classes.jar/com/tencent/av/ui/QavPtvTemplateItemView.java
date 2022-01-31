package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import azue;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.CircleProgress;
import lxd;
import lxf;

public class QavPtvTemplateItemView
  extends QavListItemBase
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  public boolean a;
  
  public QavPtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 100)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (paramInt < 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131494010, this);
    int k = getResources().getColor(2131101260);
    int j;
    if (!this.jdField_a_of_type_Boolean) {
      j = getResources().getColor(2131099760);
    }
    for (int i = 2130845079;; i = 2130845080)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131306711));
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131306552));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131306548));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131306554));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      b(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(1.6F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, k, 100, j);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof LinearLayout)) {
          ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).setGravity(83);
        }
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setDimmedColor(-47980);
      }
      return;
      j = getResources().getColor(2131100359);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, lxf paramlxf, lxd paramlxd)
  {
    if (paramlxf == null) {}
    do
    {
      return;
      super.a(paramInt, paramlxd);
      setId(paramInt);
      setTag(paramlxf);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setTag(paramlxf);
      if (!TextUtils.isEmpty(paramlxf.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if ("0".equals(paramlxf.jdField_a_of_type_JavaLangString)) {
      if (TextUtils.isEmpty(paramlxf.b)) {
        break label341;
      }
    }
    label330:
    label341:
    for (paramInt = Integer.valueOf(paramlxf.b).intValue();; paramInt = 0)
    {
      if (paramInt > 0)
      {
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(paramInt);
        if ((!paramlxf.jdField_a_of_type_Boolean) && (!paramlxf.jdField_a_of_type_JavaLangString.equals("0"))) {
          break label330;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        setDimmed(paramlxf.c);
        setHighlight(paramBoolean1);
        return;
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(2130849314);
        break;
        if (TextUtils.isEmpty(paramlxf.b)) {
          break;
        }
        paramlxd = URLDrawable.URLDrawableOptions.obtain();
        paramInt = getResources().getDimensionPixelSize(2131166455);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(getResources().getColor(2131100176));
        localGradientDrawable.setShape(1);
        localGradientDrawable.setSize(paramInt, paramInt);
        paramlxd.mRequestWidth = paramInt;
        paramlxd.mRequestHeight = paramInt;
        paramlxd.mFailedDrawable = localGradientDrawable;
        paramlxd.mLoadingDrawable = localGradientDrawable;
        paramlxd = URLDrawable.getDrawable(paramlxf.b, paramlxd);
        paramlxd.setTag(azue.a(paramInt, paramInt));
        if (paramBoolean2) {
          paramlxd.setDecodeHandler(azue.a);
        }
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(paramlxd);
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void a(lxf paramlxf, int paramInt)
  {
    if (paramInt % 2 == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(255, 224, 176, 216));
      if (this.jdField_a_of_type_Boolean) {
        break label105;
      }
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(Color.argb(255, 168, 168, 236));
    }
    for (;;)
    {
      if ((paramlxf == null) || (!"0".equals(paramlxf.jdField_a_of_type_JavaLangString))) {
        break label124;
      }
      setBackgroundColor(-16711681);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(155, 224, 176, 216));
      break;
      label105:
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(getResources().getColor(2131100359));
    }
    label124:
    if (paramInt % 2 == 0)
    {
      setBackgroundColor(-7829368);
      return;
    }
    setBackgroundColor(-3355444);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    View localView = findViewById(2131306712);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localView.setLayoutParams(localLayoutParams);
  }
  
  public void setDimmed(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setDimmed(paramBoolean);
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavPtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */