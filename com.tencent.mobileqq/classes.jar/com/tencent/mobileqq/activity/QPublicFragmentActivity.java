package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class QPublicFragmentActivity
  extends QBaseActivity
{
  public static final int BUSINESS_DESCRIPTION_MAX_LENGTH = 50;
  public static final String KEY_FRAGMENT_CLASS = "public_fragment_class";
  public static final String KEY_WINDOW_FEATURE = "public_fragment_window_feature";
  private static final String TAG = " QPublicFragmentActivity";
  private static ArrayMap<String, QPublicFragmentActivity.IViewCreator> viewCreators = new ArrayMap();
  private QPublicBaseFragment mFrag;
  
  public static void addViewCreator(String paramString, QPublicFragmentActivity.IViewCreator paramIViewCreator)
  {
    viewCreators.put(paramString, paramIViewCreator);
  }
  
  public static void closeQuietly(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  private QPublicBaseFragment createFragment()
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
  
  private void patchSavedInstanceState(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {}
    try
    {
      Object localObject2 = Class.forName("androidx.fragment.app.QFragmentManagerState");
      paramBundle = Class.forName("androidx.fragment.app.QFragmentState");
      if (!((Class)localObject2).isInstance(localObject1)) {
        break label188;
      }
      localObject2 = ((Class)localObject2).getDeclaredField("mActive");
      if (!((Field)localObject2).isAccessible()) {
        ((Field)localObject2).setAccessible(true);
      }
      if (!((Field)localObject2).getType().isArray()) {
        break label188;
      }
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
    catch (Exception paramBundle)
    {
      label180:
      label188:
      break label180;
    }
    QLog.d(" QPublicFragmentActivity", 2, "Patch error");
  }
  
  public static void start(Context paramContext, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, paramIntent, QPublicFragmentActivity.class, paramClass);
  }
  
  public static void start(Context paramContext, Class<? extends QPublicBaseFragment> paramClass)
  {
    start(paramContext, null, paramClass);
  }
  
  public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass, int paramInt)
  {
    QPublicFragmentActivity.Launcher.a(paramActivity, paramIntent, QPublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void startForResult(Activity paramActivity, Class<? extends QPublicBaseFragment> paramClass, int paramInt)
  {
    startForResult(paramActivity, null, paramClass, paramInt);
  }
  
  public static void startForResult(QBaseFragment paramQBaseFragment, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass, int paramInt)
  {
    QPublicFragmentActivity.Launcher.a(paramQBaseFragment, paramIntent, QPublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void startForResult(QBaseFragment paramQBaseFragment, Class<? extends QPublicBaseFragment> paramClass, int paramInt)
  {
    startForResult(paramQBaseFragment, null, paramClass, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = EventCollector.getInstance();
    boolean bool = true;
    ((EventCollector)localObject).onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    localObject = this.mFrag;
    if ((localObject == null) || (!((QPublicBaseFragment)localObject).needDispatchTouchEvent()) || (!this.mFrag.dispatchTouchEvent(paramMotionEvent))) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mFrag = createFragment();
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null)
    {
      this.mNeedStatusTrans = localQPublicBaseFragment.needStatusTrans();
      this.mActNeedImmersive = this.mFrag.needImmersive();
      this.mFrag.initWindowStyleAndAnimation(this);
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" QPublicFragmentActivity", 1, "Activity restored, set classloader.");
      }
      patchSavedInstanceState(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131624037);
    if (this.mFrag == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131433667, this.mFrag);
    paramBundle.commitAllowingStateLoss();
    this.mFrag.initSideFling(this, this.mFlingHandler);
    return true;
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if ((localQPublicBaseFragment != null) && (localQPublicBaseFragment.doOnKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onNewIntent(paramIntent);
    }
  }
  
  public void finish()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if ((localQPublicBaseFragment == null) || (!localQPublicBaseFragment.overrideFinish())) {
      superFinish();
    }
  }
  
  public String getCIOPageName()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      return localQPublicBaseFragment.getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public QPublicBaseFragment getFragment()
  {
    return this.mFrag;
  }
  
  public boolean isSupportScreenShot()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    return (localQPublicBaseFragment == null) || (localQPublicBaseFragment.isSupportScreenShot());
  }
  
  protected boolean isWrapContent()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      return localQPublicBaseFragment.isWrapContent();
    }
    return super.isWrapContent();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onAccountChanged();
    }
  }
  
  protected boolean onBackEvent()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment == null) {
      return super.onBackEvent();
    }
    return localQPublicBaseFragment.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (viewCreators.containsKey(paramString))
    {
      View localView = ((QPublicFragmentActivity.IViewCreator)viewCreators.get(paramString)).a(paramString, paramContext, paramAttributeSet);
      if (localView != null) {
        return localView;
      }
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onPostThemeChanged();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onPreThemeChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onWindowFocusChanged(paramBoolean);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    if (paramIntent.hasExtra("public_fragment_window_feature")) {
      requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
    }
  }
  
  public void superFinish()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.beforeFinish();
    }
    super.finish();
    localQPublicBaseFragment = this.mFrag;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onFinish();
    }
  }
  
  public String toString()
  {
    String str = super.toString();
    Object localObject1;
    if (this.mFrag != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append(this.mFrag.getClass().getName());
      ((StringBuilder)localObject1).append("@");
      ((StringBuilder)localObject1).append(Integer.toHexString(this.mFrag.hashCode()));
      str = ((StringBuilder)localObject1).toString();
      Object localObject2 = this.mFrag.getBusinessDescription();
      localObject1 = str;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).trim();
        localObject1 = localObject2;
        if (((String)localObject2).length() > 50) {
          localObject1 = ((String)localObject2).substring(0, 50);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("{");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("}");
        return ((StringBuilder)localObject2).toString();
      }
    }
    else
    {
      localObject1 = str;
      if (getIntent() != null)
      {
        localObject1 = str;
        if (getIntent().getStringExtra("public_fragment_class") != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("#");
          ((StringBuilder)localObject1).append(getIntent().getStringExtra("public_fragment_class"));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */