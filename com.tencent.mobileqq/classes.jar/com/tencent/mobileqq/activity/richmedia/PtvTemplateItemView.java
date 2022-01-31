package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  PtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback;
  PtvTemplateItemView.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  View jdField_b_of_type_AndroidViewView;
  CircleProgress jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress;
  
  public PtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PtvTemplateItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    setOrientation(0);
    int k = AIOUtils.a(64.0F, getResources());
    int m = AIOUtils.a(60.0F, getResources());
    int j = AIOUtils.a(70.0F, getResources());
    int n = AIOUtils.a(20.0F, getResources());
    int i1 = getResources().getColor(2131494220);
    int i2 = getResources().getColor(2131493308);
    int i3 = AIOUtils.a(18.0F, getResources());
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = j;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new RelativeLayout.LayoutParams(m, m);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumWidth(m);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumHeight(m);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = new CircleProgress(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(n, n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumHeight(n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumWidth(n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, i1, 100, i2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(i3, i3);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843289);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(2.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress = new CircleProgress(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(3.0F);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, 1226741, 100, 1226741);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumWidth(k);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumHeight(k);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(k, k);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress, (ViewGroup.LayoutParams)localObject);
    paramInt2 = (paramInt1 - k) / 2;
    localObject = new LinearLayout.LayoutParams(paramInt2, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(k, k);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(paramInt2, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_b_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    if (AudioHelper.a(0) == 1) {
      QLog.d("PtvTemplateItemView", 4, String.format("[%s]初始化View, itemWidth[%s], fullHeight[%s], thumbWidthWithCircle[%s], thumbWidth[%s], itemHeight[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) }));
    }
  }
  
  public void a(int paramInt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateAdapter.IPtvTemplateItemCallback paramIPtvTemplateItemCallback)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback = paramIPtvTemplateItemCallback;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (!TextUtils.isEmpty(paramPtvTemplateInfo.iconurl))
    {
      paramIPtvTemplateItemCallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt = AIOUtils.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131493213));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramIPtvTemplateItemCallback.mRequestWidth = paramInt;
      paramIPtvTemplateItemCallback.mRequestHeight = paramInt;
      paramIPtvTemplateItemCallback.mFailedDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback.mLoadingDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, paramIPtvTemplateItemCallback);
      paramIPtvTemplateItemCallback.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
      paramIPtvTemplateItemCallback.setDecodeHandler(URLDrawableDecodeHandler.a);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramIPtvTemplateItemCallback);
      if ((!paramPtvTemplateInfo.usable) && (!paramPtvTemplateInfo.id.equals("0"))) {
        break label256;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      return;
      if (!"0".equals(paramPtvTemplateInfo.id)) {
        break;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130846489);
      break;
      label256:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
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
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback.a(this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void setHightlight(boolean paramBoolean)
  {
    CircleProgress localCircleProgress = this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localCircleProgress.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */