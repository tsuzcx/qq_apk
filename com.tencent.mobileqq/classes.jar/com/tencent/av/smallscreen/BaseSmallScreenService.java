package com.tencent.av.smallscreen;

import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import jpw;
import jpx;
import jpy;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements SmallScreenRelativeLayout.FloatListener
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new jpw(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  View jdField_a_of_type_AndroidViewView = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  public TextView a;
  SmallScreenRelativeLayout jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  SmallScreenToast jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  public SmallScreenRelativeLayout b;
  SmallScreenToast jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public boolean b;
  int c;
  public boolean c;
  int d;
  public boolean d;
  int e;
  public boolean e;
  int f;
  public boolean f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m = 0;
  int n = 7;
  int o = 0;
  
  public BaseSmallScreenService()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().x;
    }
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  void a()
  {
    if (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a()) {}
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.a();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.c();
      return;
    }
  }
  
  public boolean a()
  {
    return SmallScreenUtils.f(((AppInterface)this.app).getApp());
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().y;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onIsLockChanged mIsLock = " + this.jdField_c_of_type_Boolean);
    }
    f();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onHasSmartBarChanged mHasSmartBar = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) {
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void onCreate()
  {
    int i2 = 2002;
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onCreate start");
    }
    super.onCreate();
    this.jdField_d_of_type_Boolean = false;
    Object localObject2;
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      if (localLayoutInflater == null)
      {
        QLog.e("BaseSmallScreenService", 1, "onCreate cannot get inflate service!");
        stopSelf();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BaseSmallScreenService", 2, "onCreate e = " + localException);
        }
        Object localObject1 = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BaseSmallScreenService", 2, "onCreate e = " + localOutOfMemoryError);
        }
        localObject2 = null;
      }
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)getSystemService("phone"));
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 32);
      this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131559939);
      this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131559940);
      this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131559949);
      this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131559950);
      this.jdField_e_of_type_Int = getResources().getDimensionPixelSize(2131559951);
      this.jdField_f_of_type_Int = getResources().getDimensionPixelSize(2131559952);
      this.g = getResources().getDimensionPixelSize(2131559953);
      this.h = getResources().getDimensionPixelSize(2131559954);
      this.i = getResources().getDimensionPixelSize(2131559955);
      this.j = getResources().getDimensionPixelSize(2131559956);
      this.k = getResources().getDimensionPixelSize(2131559957);
      this.l = getResources().getDimensionPixelSize(2131559958);
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = ((SmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2130969351, null));
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = ((SmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2130969352, null));
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.b();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setFloatListener(this);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setFloatListener(this);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setTitleHeight(getResources().getDimensionPixelSize(2131558448) * 5 / 2);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131365384));
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = new SmallScreenToast(this, this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = new SmallScreenToast(this, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout);
      localObject2 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
      ((WindowManager.LayoutParams)localObject2).flags = 136;
      if (!SmallScreenUtils.a()) {}
    }
    for (int i1 = 2005;; i1 = 2002)
    {
      ((WindowManager.LayoutParams)localObject2).type = i1;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setIsRotateSize(true);
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      localObject2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
      ((WindowManager.LayoutParams)localObject2).flags = 136;
      i1 = i2;
      if (SmallScreenUtils.a()) {
        i1 = 2005;
      }
      ((WindowManager.LayoutParams)localObject2).type = i1;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131366266));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2131034265);
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131365388);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.NEW_OUTGOING_CALL");
      ((IntentFilter)localObject2).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
      this.jdField_b_of_type_Boolean = SmallScreenUtils.e();
      this.jdField_e_of_type_Boolean = SmallScreenUtils.c(((AppInterface)this.app).getApp());
      this.jdField_c_of_type_Boolean = SmallScreenUtils.b(((AppInterface)this.app).getApp());
      this.jdField_f_of_type_Boolean = SmallScreenUtils.f(((AppInterface)this.app).getApp());
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new jpx(this);
      }
      a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
      if (this.jdField_b_of_type_JavaLangRunnable == null) {
        this.jdField_b_of_type_JavaLangRunnable = new jpy(this);
      }
      a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseSmallScreenService", 2, "onCreate end");
      return;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy start");
    }
    super.onDestroy();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy end");
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onLowMemory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */