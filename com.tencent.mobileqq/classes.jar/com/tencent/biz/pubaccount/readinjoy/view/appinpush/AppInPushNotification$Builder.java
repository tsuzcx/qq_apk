package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public final class AppInPushNotification$Builder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private AppInPushNotification.OnClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnClickListener;
  private AppInPushNotification.OnDismissListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnDismissListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    if (paramLong > 0L) {}
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this;
      paramLong = 7000L;
    }
  }
  
  public Builder a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public Builder a(AppInPushNotification.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder a(AppInPushNotification.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnDismissListener = paramOnDismissListener;
    return this;
  }
  
  public Builder a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public AppInPushNotification a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return new DropDownAppInPushNotification(this);
    case 2: 
      return new DialogAppInPushNotification(this);
    }
    return new BubbleAppInPushNotification(this);
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Builder f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder g(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public Builder h(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public Builder i(String paramString)
  {
    this.i = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification.Builder
 * JD-Core Version:    0.7.0.1
 */