package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emotionintegrate.EmotionKeywordLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommonStickerRecView
  implements View.OnClickListener, IStickerView
{
  public int a;
  Animator jdField_a_of_type_AndroidAnimationAnimator;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public URLImageView a;
  CommonStickerRecPresenter jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter;
  public int b;
  public int c;
  
  public CommonStickerRecView(IStickerPresenter paramIStickerPresenter, Activity paramActivity, BaseAIOContext paramBaseAIOContext, ViewGroup paramViewGroup, EditText paramEditText)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter = ((CommonStickerRecPresenter)paramIStickerPresenter);
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130838246);
    float f = paramActivity.getResources().getDisplayMetrics().density;
    int i = (int)(64.0F * f);
    this.jdField_a_of_type_Int = i;
    this.b = i;
    this.c = ((int)(6.0F * f));
    i = (int)(7.0F * f);
    int j = (int)(9.0F * f);
    int k = (int)(f * 8.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new EmotionKeywordLayout(paramActivity, paramBaseAIOContext, paramViewGroup);
    paramIStickerPresenter = new ViewGroup.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramIStickerPresenter);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, j, i, k);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramActivity);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131368591);
    paramIStickerPresenter = new RelativeLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
    paramIStickerPresenter.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, paramIStickerPresenter);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130837958));
    paramIStickerPresenter = new RelativeLayout.LayoutParams(-2, -2);
    paramIStickerPresenter.addRule(7, 2131368591);
    paramIStickerPresenter.addRule(8, 2131368591);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691884);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramActivity.getResources().getColor(2131167222));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramIStickerPresenter);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramActivity);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramActivity.getResources().getDrawable(2130838234));
    paramIStickerPresenter = new RelativeLayout.LayoutParams(-2, -2);
    paramIStickerPresenter.addRule(7, 2131368591);
    paramIStickerPresenter.addRule(8, 2131368591);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramIStickerPresenter);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramIStickerPresenter = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentImageURLImageView, "alpha", new float[] { 0.0F, 1.0F });
    paramIStickerPresenter.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationAnimator = paramIStickerPresenter;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public IStickerPresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter;
  }
  
  public void a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter.a();
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
    Object localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    int j = 0;
    ((URLImageView)localObject).setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidAnimationAnimator.start();
    }
    else
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter.b()) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter.c()) {
      i = j;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter.a());
  }
  
  public void onClick(View paramView)
  {
    CommonStickerRecPresenter localCommonStickerRecPresenter;
    if (QLog.isColorLevel())
    {
      localCommonStickerRecPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter;
      QLog.d("CommonStickerRec", 2, "onClick");
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText == null)
    {
      if (QLog.isColorLevel())
      {
        localCommonStickerRecPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter;
        QLog.e("CommonStickerRec", 2, "onClick input == null");
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecPresenter.a())
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecView
 * JD-Core Version:    0.7.0.1
 */