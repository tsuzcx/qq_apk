package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import moz;
import mpb;

public class BubbleAppInPushNotification
  extends AppInPushNotification
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private AppInPushBubbleFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushBubbleFrameLayout;
  
  BubbleAppInPushNotification(AppInPushNotification.Builder paramBuilder)
  {
    super(paramBuilder);
    d();
  }
  
  private void a(Runnable paramRunnable)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, 200L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getRootView());
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969552, this.jdField_a_of_type_AndroidViewViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363852);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushBubbleFrameLayout = ((AppInPushBubbleFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365675));
    f();
    e();
    g();
    h();
    i();
  }
  
  private void e()
  {
    TextView localTextView;
    if ((!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.i)))
    {
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366930);
      localTextView.setVisibility(0);
      localTextView.setText(this.h);
    }
    try
    {
      int i = Color.parseColor(this.i);
      int j = 0xFFFFFF & i;
      localTextView.setTextColor(i);
      GradientDrawable localGradientDrawable = (GradientDrawable)localTextView.getBackground();
      localGradientDrawable.setStroke(AIOUtils.a(1.0F, localTextView.getResources()), 0x80000000 | j);
      localGradientDrawable.setColor(0x33000000 | j);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("BubbleAppInPushNotification", 2, "setupTagText: ", localIllegalArgumentException);
    }
  }
  
  private void f()
  {
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366934)).setText(this.jdField_b_of_type_JavaLangString);
  }
  
  private void g()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366935);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366936);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366937);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localView.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 1) {
        localImageView2.setVisibility(0);
      }
      return;
      localView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth = AIOUtils.a(71.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight = AIOUtils.a(54.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView1.setImageDrawable(URLDrawable.getDrawable(ReadInJoyUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions));
    }
  }
  
  private void h()
  {
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366931);
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366938);
    if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.g)))
    {
      localView1.setVisibility(0);
      localView2.setVisibility(0);
      ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366939)).setHeadImgByUin(this.f);
      ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366932)).setText(this.e);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366933)).setText(this.g);
    }
  }
  
  private void i()
  {
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366929);
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366940);
    localView1.setOnClickListener(new moz(this));
    localView2.setOnClickListener(new mpb(this));
  }
  
  private void j()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushBubbleFrameLayout.a(), 1, 1.0F);
    localScaleAnimation.setDuration(400L);
    localScaleAnimation.setInterpolator(new OvershootInterpolator(1.65F));
    localScaleAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localScaleAnimation);
  }
  
  protected void a(boolean paramBoolean, Runnable paramRunnable)
  {
    a(paramRunnable);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing();
  }
  
  protected void b()
  {
    if ((BaseActivity.sTopActivity instanceof SplashActivity))
    {
      Object localObject = (MainFragment)((SplashActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((MainFragment)localObject).a("看点");
        if (localObject != null)
        {
          int[] arrayOfInt = new int[2];
          ((View)localObject).getLocationInWindow(arrayOfInt);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushBubbleFrameLayout.setTriPosition((arrayOfInt[0] + ((View)localObject).getWidth() / 2.0F) / this.jdField_a_of_type_AndroidViewViewGroup.getWidth());
          int i = ((View)localObject).getHeight();
          this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewViewGroup, 8388691, 0, i);
          j();
        }
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.BubbleAppInPushNotification
 * JD-Core Version:    0.7.0.1
 */