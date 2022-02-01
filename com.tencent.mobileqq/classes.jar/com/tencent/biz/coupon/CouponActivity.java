package com.tencent.biz.coupon;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CouponActivity
  extends PublicAccountBrowser
{
  static String a;
  public int a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://web.p.qq.com/qqmpmobile/coupon/shop.html?_bid=108";
  }
  
  public CouponActivity()
  {
    this.jdField_a_of_type_JavaLangClass = CouponActivity.CouponWebViewFragment.class;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = getIntent().getIntExtra("from", 10);
    return super.doOnCreate(paramBundle);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity
 * JD-Core Version:    0.7.0.1
 */