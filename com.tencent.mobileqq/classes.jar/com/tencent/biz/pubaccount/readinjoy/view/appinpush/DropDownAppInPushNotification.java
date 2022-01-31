package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import mpf;
import mpg;

public class DropDownAppInPushNotification
  extends AppInPushNotification
{
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mpf(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  
  DropDownAppInPushNotification(AppInPushNotification.Builder paramBuilder)
  {
    super(paramBuilder);
    d();
  }
  
  private void a(Runnable paramRunnable)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, 300L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  private void b(Runnable paramRunnable)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, 200L);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getRootView());
    Object localObject;
    TextView localTextView;
    ImageView localImageView;
    ReadInJoyHeadImageView localReadInJoyHeadImageView;
    ReadInJoyNickNameTextView localReadInJoyNickNameTextView;
    if (TextUtils.isEmpty(this.c))
    {
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969600, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131363852);
      this.jdField_a_of_type_AndroidViewView.setPadding(this.jdField_a_of_type_AndroidViewView.getPaddingLeft(), this.jdField_a_of_type_AndroidViewView.getPaddingTop() + ViewUtils.a(this.jdField_a_of_type_AndroidContentContext), this.jdField_a_of_type_AndroidViewView.getPaddingRight(), this.jdField_a_of_type_AndroidViewView.getPaddingBottom());
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject, -1, -2);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366934);
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367090);
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366936);
      localReadInJoyHeadImageView = (ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366939);
      localReadInJoyNickNameTextView = (ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366932);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label288;
      }
      localImageView.setVisibility(8);
    }
    for (;;)
    {
      ((TextView)localObject).setText(this.b);
      if (localTextView != null) {
        localTextView.setText(this.c);
      }
      localReadInJoyHeadImageView.setHeadImgByUin(this.f);
      localReadInJoyNickNameTextView.setText(this.e);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new mpg(this));
      return;
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969599, this.jdField_a_of_type_AndroidViewViewGroup, false);
      break;
      label288:
      localImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = new ColorDrawable(-1513241);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = new ColorDrawable(-1513241);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setImageDrawable(URLDrawable.getDrawable(ReadInJoyUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions));
    }
  }
  
  private void e()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  protected void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!a())
    {
      if (paramBoolean) {
        a(paramRunnable);
      }
    }
    else {
      return;
    }
    b(paramRunnable);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewViewGroup, 8388659, 0, 0);
    e();
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.DropDownAppInPushNotification
 * JD-Core Version:    0.7.0.1
 */