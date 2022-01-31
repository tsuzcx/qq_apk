package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mju;
import mjv;

public abstract class AppInPushNotification
{
  private static int jdField_c_of_type_Int = 7;
  protected final int a;
  protected final long a;
  protected Context a;
  public Handler a;
  public AppInPushNotification.OnClickListener a;
  protected AppInPushNotification.OnDismissListener a;
  protected URLDrawable.URLDrawableOptions a;
  protected QQAppInterface a;
  public final Runnable a;
  protected final String a;
  protected final int b;
  long b;
  protected final String b;
  long jdField_c_of_type_Long;
  protected final String c;
  protected final String d;
  protected final String e;
  protected final String f;
  protected final String g;
  protected final String h;
  protected final String i;
  
  AppInPushNotification(AppInPushNotification.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaLangRunnable = new mju(this);
    this.jdField_a_of_type_AndroidContentContext = AppInPushNotification.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangString = AppInPushNotification.Builder.a(paramBuilder);
    this.jdField_b_of_type_JavaLangString = AppInPushNotification.Builder.b(paramBuilder);
    this.jdField_c_of_type_JavaLangString = AppInPushNotification.Builder.c(paramBuilder);
    this.d = AppInPushNotification.Builder.d(paramBuilder);
    this.e = AppInPushNotification.Builder.e(paramBuilder);
    this.jdField_a_of_type_Long = AppInPushNotification.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = AppInPushNotification.Builder.a(paramBuilder);
    this.f = AppInPushNotification.Builder.f(paramBuilder);
    this.g = AppInPushNotification.Builder.g(paramBuilder);
    this.h = AppInPushNotification.Builder.h(paramBuilder);
    this.i = AppInPushNotification.Builder.i(paramBuilder);
    this.jdField_b_of_type_Int = AppInPushNotification.Builder.b(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = AppInPushNotification.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnClickListener = AppInPushNotification.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnDismissListener = AppInPushNotification.Builder.a(paramBuilder);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
  }
  
  public static int a()
  {
    return jdField_c_of_type_Int;
  }
  
  public static AppInPushNotification.Builder a()
  {
    return new AppInPushNotification.Builder();
  }
  
  public static void a(int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!a())
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      ReadinjoySPEventReport.a().a(jdField_c_of_type_Int, a());
      a(7);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnDismissListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnDismissListener.a(paramBoolean);
      }
      c();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long - this.jdField_b_of_type_Long;
  }
  
  public final void a()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    b();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
  }
  
  protected abstract void a(boolean paramBoolean, Runnable paramRunnable);
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("AppInPushNotification", 2, "dismiss: ");
    if (!a())
    {
      if (!paramBoolean1) {
        break label45;
      }
      a(paramBoolean2, new mjv(this, paramBoolean2));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label45:
      a(paramBoolean2);
    }
  }
  
  public abstract boolean a();
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected abstract void b();
  
  protected abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification
 * JD-Core Version:    0.7.0.1
 */