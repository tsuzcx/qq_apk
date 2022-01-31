package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoAutoPlayController
{
  private static long jdField_a_of_type_Long;
  private static VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private static String jdField_a_of_type_JavaLangString;
  private static String b;
  private static String jdField_c_of_type_JavaLangString = ReadInJoyUtils.d;
  public float a;
  public Context a;
  protected boolean a;
  public float b;
  public boolean b;
  public float c;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e = true;
  
  static
  {
    jdField_b_of_type_JavaLangString = ReadInJoyUtils.d;
  }
  
  public VideoAutoPlayController(Context paramContext)
  {
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_c_of_type_Float = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / 16.0D * 9.0D));
    this.jdField_b_of_type_Float = (2.0F * this.jdField_c_of_type_Float * 1.2F);
    if (Build.VERSION.SDK_INT >= 14) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "mDeviceAutoPlaySwitch : " + this.jdField_a_of_type_Boolean);
      }
      return;
    }
  }
  
  public static VideoAutoPlayController a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = new VideoAutoPlayController(paramContext);
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  }
  
  private void a()
  {
    if (this.e) {
      jdField_b_of_type_JavaLangString = ReadInJoyUtils.b();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
        {
          int i = paramContext.getType();
          if (i == 1) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d(VideoAutoPlayController.class.getSimpleName(), 2, paramContext.toString());
    }
    return false;
  }
  
  public static boolean e()
  {
    if (jdField_a_of_type_Long == -1L) {
      return false;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
      if (!str.equals(jdField_a_of_type_JavaLangString))
      {
        jdField_a_of_type_JavaLangString = str;
        jdField_a_of_type_Long = -1L;
        return false;
      }
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long >= 600000L) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public View a(View paramView1, View paramView2)
  {
    if (paramView1 == null) {}
    label135:
    label139:
    for (;;)
    {
      return paramView2;
      if (paramView2 == null) {
        return paramView1;
      }
      float f4 = 0.0F;
      float f2 = this.jdField_b_of_type_Float;
      float f1 = f2;
      if (f2 > this.jdField_a_of_type_Float) {
        f1 = this.jdField_a_of_type_Float;
      }
      float f3 = paramView1.getTop();
      float f5 = this.jdField_c_of_type_Float + f3;
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = 0.0F;
      }
      f3 = f5;
      if (f5 > f1) {
        f3 = f1;
      }
      float f6 = paramView2.getTop();
      f5 = this.jdField_c_of_type_Float + f6;
      if (f6 < 0.0F) {
        if (f5 <= f1) {
          break label135;
        }
      }
      for (;;)
      {
        if (f3 - f2 < f1 - f4) {
          break label139;
        }
        return paramView1;
        f4 = f6;
        break;
        f1 = f5;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoAutoPlayController", 2, "canAutoPlayVideo：getKandianMode: " + ReadInJoyUtils.e());
    }
    if (ReadInJoyUtils.e() == 6)
    {
      jdField_c_of_type_JavaLangString = ReadInJoyUtils.b();
      if (!ReadInJoyUtils.d.equals(jdField_c_of_type_JavaLangString)) {}
    }
    do
    {
      return false;
      if ((ReadInJoyUtils.jdField_b_of_type_JavaLangString.equals(jdField_c_of_type_JavaLangString)) && (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
        return this.jdField_a_of_type_Boolean;
      }
      if ((this.d) && (this.jdField_a_of_type_Boolean)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      jdField_b_of_type_JavaLangString = ReadInJoyUtils.b();
    } while (ReadInJoyUtils.d.equals(jdField_b_of_type_JavaLangString));
    if ((ReadInJoyUtils.jdField_b_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) && (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
      return this.jdField_a_of_type_Boolean;
    }
    if ((this.d) && (this.jdField_a_of_type_Boolean)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean a(View paramView)
  {
    float f3 = paramView.getTop();
    float f4 = this.jdField_c_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    float f1 = f2;
    if (f2 > this.jdField_a_of_type_Float) {
      f1 = this.jdField_a_of_type_Float;
    }
    return (f3 >= -100.0F) && (f3 + f4 <= f1);
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean c()
  {
    if (ReadInJoyUtils.jdField_b_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) {}
    while ((NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) || (e())) {
      return false;
    }
    return true;
  }
  
  public boolean d()
  {
    if (ReadInJoyUtils.jdField_b_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) {}
    while ((NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_b_of_type_Boolean)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController
 * JD-Core Version:    0.7.0.1
 */