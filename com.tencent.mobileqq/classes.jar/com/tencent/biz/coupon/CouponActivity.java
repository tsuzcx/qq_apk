package com.tencent.biz.coupon;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountBrowser;

public class CouponActivity
  extends PublicAccountBrowser
{
  static String a;
  public int a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://web.p.qq.com/qqmpmobile/coupon/shop.html?_bid=108";
  }
  
  public CouponActivity()
  {
    this.jdField_a_of_type_JavaLangClass = CouponActivity.CouponWebViewFragment.class;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = getIntent().getIntExtra("from", 10);
    return super.doOnCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity
 * JD-Core Version:    0.7.0.1
 */