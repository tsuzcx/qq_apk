package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.QFragment;
import android.support.v4.app.QFragmentActivity;
import android.support.v4.app.QFragmentManager;
import android.support.v4.app.QFragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class QPublicFragmentActivity
  extends QFragmentActivity
{
  private static ArrayMap<String, QPublicFragmentActivity.IViewCreator> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private QPublicBaseFragment jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment;
  
  private QPublicBaseFragment a()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    if (QLog.isColorLevel()) {
      QLog.d(" QPublicFragmentActivity", 2, new Object[] { "creating fragment ", localObject });
    }
    try
    {
      localObject = (QPublicBaseFragment)Class.forName((String)localObject).newInstance();
      ((QPublicBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      CrashReportConstant.a = Log.getStackTraceString(localException);
      QLog.e(" QPublicFragmentActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass, int paramInt)
  {
    QPublicFragmentActivity.Launcher.a(paramActivity, paramIntent, QPublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, paramIntent, QPublicFragmentActivity.class, paramClass);
  }
  
  public static void a(Context paramContext, Class<? extends QPublicBaseFragment> paramClass)
  {
    a(paramContext, null, paramClass);
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {
      try
      {
        Object localObject2 = Class.forName("android.support.v4.app.QFragmentManagerState");
        paramBundle = Class.forName("android.support.v4.app.QFragmentState");
        if (((Class)localObject2).isInstance(localObject1))
        {
          localObject2 = ((Class)localObject2).getDeclaredField("mActive");
          if (!((Field)localObject2).isAccessible()) {
            ((Field)localObject2).setAccessible(true);
          }
          if (((Field)localObject2).getType().isArray())
          {
            localObject1 = ((Field)localObject2).get(localObject1);
            int j = Array.getLength(localObject1);
            int i = 0;
            while (i < j)
            {
              localObject2 = Array.get(localObject1, i);
              if ((localObject2 != null) && (paramBundle.isInstance(localObject2)))
              {
                Field localField = paramBundle.getDeclaredField("mArguments");
                if (!localField.isAccessible()) {
                  localField.setAccessible(true);
                }
                localObject2 = localField.get(localObject2);
                if ((localObject2 != null) && ((localObject2 instanceof Bundle))) {
                  ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
                }
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d(" QPublicFragmentActivity", 2, "Patch error");
      }
    }
  }
  
  public static void a(QFragment paramQFragment, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass, int paramInt)
  {
    QPublicFragmentActivity.Launcher.a(paramQFragment, paramIntent, QPublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.g()) && (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.a(paramMotionEvent))) {}
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment = a();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null)
    {
      this.mNeedStatusTrans = this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.d();
      this.mActNeedImmersive = this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.d_();
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.a(this);
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" QPublicFragmentActivity", 1, "Activity restored, set classloader.");
      }
      a(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131558459);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131367430, this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment);
    paramBundle.commit();
    this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.a(this, this.mFlingHandler);
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.a(paramIntent);
    }
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment == null) || (!this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.h())) {
      superFinish();
    }
  }
  
  public String getCIOPageName()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public boolean isSupportScreenShot()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.e());
  }
  
  public boolean isWrapContent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.f();
    }
    return super.isWrapContent();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.g();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment == null) {
      return super.onBackEvent();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.c();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramString))
    {
      View localView = ((QPublicFragmentActivity.IViewCreator)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString)).a(paramString, paramContext, paramAttributeSet);
      if (localView != null) {
        return localView;
      }
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.c(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.f();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.e();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.b(paramBoolean);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    if (paramIntent.hasExtra("public_fragment_window_feature")) {
      requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
    }
  }
  
  public void superFinish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.h();
    }
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.i();
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment != null) {
      str1 = str2 + "#" + this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.getClass().getName() + "@" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqFragmentQPublicBaseFragment.hashCode());
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (getIntent() == null);
      str1 = str2;
    } while (getIntent().getStringExtra("public_fragment_class") == null);
    return str2 + "#" + getIntent().getStringExtra("public_fragment_class");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */