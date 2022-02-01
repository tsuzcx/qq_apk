package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzonePluginProxyActivity;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

@Deprecated
public class PublicFragmentActivity
  extends BaseActivity
{
  private static ArrayMap<String, PublicFragmentActivity.IViewCreator> b = new ArrayMap();
  private PublicBaseFragment a;
  private ClassLoader c = null;
  
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivity.class, paramClass);
  }
  
  public static void a(Context paramContext, Class<? extends PublicBaseFragment> paramClass)
  {
    a(paramContext, null, paramClass);
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {}
    try
    {
      Object localObject2 = Class.forName("androidx.fragment.app.FragmentManagerState");
      paramBundle = Class.forName("androidx.fragment.app.FragmentState");
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
    QLog.d("PublicFragmentActivity", 2, "Patch error");
  }
  
  public static void a(BaseFragment paramBaseFragment, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramBaseFragment, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(BaseFragment paramBaseFragment, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    a(paramBaseFragment, null, paramClass, paramInt);
  }
  
  public static void a(String paramString, PublicFragmentActivity.IViewCreator paramIViewCreator)
  {
    b.put(paramString, paramIViewCreator);
  }
  
  private PublicBaseFragment b()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
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
      CrashReportConstant.a = Log.getStackTraceString(localException);
      QLog.e("PublicFragmentActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  public PublicBaseFragment a()
  {
    return this.a;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = EventCollector.getInstance();
    boolean bool = true;
    ((EventCollector)localObject).onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    localObject = this.a;
    if ((localObject == null) || (!((PublicBaseFragment)localObject).needDispatchTouchEvent()) || (!this.a.dispatchTouchEvent(paramMotionEvent))) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.a = b();
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null)
    {
      this.mNeedStatusTrans = localPublicBaseFragment.needStatusTrans();
      this.mActNeedImmersive = this.a.needImmersive();
      this.a.initWindowStyleAndAnimation(this);
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicFragmentActivity", 1, "Activity restored, set classloader.");
      }
      a(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131624037);
    if (this.a == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131433667, this.a);
    paramBundle.commitAllowingStateLoss();
    this.a.initSideFling(this, this.mFlingHandler);
    return true;
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    PublicBaseFragment localPublicBaseFragment = this.a;
    if ((localPublicBaseFragment != null) && (localPublicBaseFragment.doOnKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onNewIntent(paramIntent);
    }
  }
  
  public void finish()
  {
    PublicBaseFragment localPublicBaseFragment = this.a;
    if ((localPublicBaseFragment == null) || (!localPublicBaseFragment.overrideFinish())) {
      superFinish();
    }
  }
  
  public String getCIOPageName()
  {
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      return localPublicBaseFragment.getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject = super.getClassLoader();
    ClassLoader localClassLoader2 = this.c;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.c = localClassLoader1;
      localObject = localClassLoader1;
    }
    return localObject;
  }
  
  public boolean isSupportScreenShot()
  {
    PublicBaseFragment localPublicBaseFragment = this.a;
    return (localPublicBaseFragment == null) || (localPublicBaseFragment.isSupportScreenShot());
  }
  
  protected boolean isWrapContent()
  {
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      return localPublicBaseFragment.isWrapContent();
    }
    return super.isWrapContent();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onAccountChanged();
    }
  }
  
  protected boolean onBackEvent()
  {
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment == null) {
      return super.onBackEvent();
    }
    return localPublicBaseFragment.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (b.containsKey(paramString))
    {
      View localView = ((PublicFragmentActivity.IViewCreator)b.get(paramString)).a(paramString, paramContext, paramAttributeSet);
      if (localView != null) {
        return localView;
      }
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onPostThemeChanged();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onPreThemeChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onWindowFocusChanged(paramBoolean);
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
    PublicBaseFragment localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.beforeFinish();
    }
    super.finish();
    localPublicBaseFragment = this.a;
    if (localPublicBaseFragment != null) {
      localPublicBaseFragment.onFinish();
    }
  }
  
  public String toString()
  {
    String str = super.toString();
    if (this.a != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(this.a.getClass().getName());
      ((StringBuilder)localObject).append("@");
      ((StringBuilder)localObject).append(Integer.toHexString(this.a.hashCode()));
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (getIntent() != null)
    {
      localObject = str;
      if (getIntent().getStringExtra("public_fragment_class") != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(getIntent().getStringExtra("public_fragment_class"));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */