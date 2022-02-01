package com.tencent.mobileqq.activity;

import Override;
import adxq;
import adxr;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class PublicFragmentActivity
  extends FragmentActivity
{
  private static ArrayMap<String, adxq> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private PublicBaseFragment jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    adxr.a(paramActivity, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    a(paramActivity, null, paramClass, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    adxr.a(paramContext, paramIntent, PublicFragmentActivity.class, paramClass);
  }
  
  public static void a(Context paramContext, Class<? extends PublicBaseFragment> paramClass)
  {
    a(paramContext, null, paramClass);
  }
  
  private static void a(Context paramContext, String paramString) {}
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {
      try
      {
        Object localObject2 = Class.forName("android.support.v4.app.FragmentManagerState");
        paramBundle = Class.forName("android.support.v4.app.FragmentState");
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
        QLog.d("PublicFragmentActivity", 2, "Patch error");
      }
    }
  }
  
  public static void a(Fragment paramFragment, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    adxr.a(paramFragment, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(String paramString, adxq paramadxq)
  {
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString, paramadxq);
  }
  
  private PublicBaseFragment b()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    a(this, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PublicFragmentActivity", 2, new Object[] { "creating fragment ", localObject });
    }
    try
    {
      localObject = (PublicBaseFragment)Class.forName((String)localObject).newInstance();
      ((PublicBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.common.app.BaseApplicationImpl.sPublicFragmentEscapedMsg = Log.getStackTraceString(localException);
      QLog.e("PublicFragmentActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  public PublicBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.needDispatchTouchEvent()) && (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.dispatchTouchEvent(paramMotionEvent))) {}
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment = b();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null)
    {
      this.mNeedStatusTrans = this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.needStatusTrans();
      this.mActNeedImmersive = this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.needImmersive();
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.initWindowStyleAndAnimation(this);
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicFragmentActivity", 1, "Activity restored, set classloader.");
      }
      a(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131558456);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131367125, this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment);
    paramBundle.commit();
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.initSideFling(this, this.mFlingHandler);
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.doOnKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onNewIntent(paramIntent);
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null) || (!this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.overrideFinish())) {
      superFinish();
    }
  }
  
  public String getCIOPageName()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public boolean isSupportScreenShot()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.isSupportScreenShot());
  }
  
  public boolean isWrapContent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.isWrapContent();
    }
    return super.isWrapContent();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onAccountChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null) {
      return super.onBackEvent();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onBackEvent();
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
      View localView = ((adxq)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString)).onCreateView(paramString, paramContext, paramAttributeSet);
      if (localView != null) {
        return localView;
      }
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onPostThemeChanged();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onPreThemeChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onWindowFocusChanged(paramBoolean);
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
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.beforeFinish();
    }
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onFinish();
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      str1 = str2 + "#" + this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.getClass().getName() + "@" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.hashCode());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */