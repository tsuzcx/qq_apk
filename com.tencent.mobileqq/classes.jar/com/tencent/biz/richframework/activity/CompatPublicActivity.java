package com.tencent.biz.richframework.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqcircle.utils.AndroidOUIWrapperUtil;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class CompatPublicActivity
  extends ComponentBaseActivity
{
  private static ArrayMap<String, CompatPublicActivity.IViewCreator> a = new ArrayMap();
  protected CompatPublicFragment b;
  
  private void a()
  {
    int i = getIntent().getIntExtra("key_theme_id", -1);
    if (i != -1) {
      getTheme().applyStyle(i, true);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {}
    try
    {
      Object localObject2 = Class.forName("android.support.v4.app.FragmentManagerState");
      paramBundle = Class.forName("android.support.v4.app.FragmentState");
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
    QLog.d("CompatPublicActivity", 2, "Patch error");
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent.hasExtra("public_fragment_window_feature")) {
      requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
    }
  }
  
  protected CompatPublicFragment b()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    QLog.d("CompatPublicActivity", 2, new Object[] { "creating fragment ", localObject });
    try
    {
      localObject = (CompatPublicFragment)Class.forName((String)localObject).newInstance();
      ((CompatPublicFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("CompatPublicActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void f()
  {
    CompatPublicFragment localCompatPublicFragment = this.b;
    if (localCompatPublicFragment != null) {
      localCompatPublicFragment.beforeFinish();
    }
    super.finish();
    localCompatPublicFragment = this.b;
    if (localCompatPublicFragment != null) {
      localCompatPublicFragment.onFinish();
    }
  }
  
  public void finish()
  {
    CompatPublicFragment localCompatPublicFragment = this.b;
    if ((localCompatPublicFragment == null) || (!localCompatPublicFragment.overrideFinish())) {
      f();
    }
  }
  
  public CompatPublicFragment g()
  {
    return this.b;
  }
  
  protected boolean h()
  {
    Object localObject = this.b;
    boolean bool;
    if ((localObject != null) && (((CompatPublicFragment)localObject).onBackEvent())) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDispatchKeyEvent fsActivity:");
    ((StringBuilder)localObject).append(bool);
    QLog.d("ASDynamicEngine_back", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    CompatPublicFragment localCompatPublicFragment = this.b;
    if (localCompatPublicFragment != null) {
      localCompatPublicFragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if (!h()) {
      try
      {
        super.onBackPressed();
        if (((this instanceof FragmentActivity)) && (!getSupportFragmentManager().popBackStackImmediate()))
        {
          QLog.d("ASDynamicEngine_back", 1, "doDispatchKeyEvent fsActivity finish this:");
          finish();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompatPublicActivity", 2, "", localThrowable);
        }
        finish();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    a(getIntent());
    if (AndroidOUIWrapperUtil.a(this)) {
      AndroidOUIWrapperUtil.b(this);
    }
    a();
    super.onCreate(paramBundle);
    this.b = b();
    CompatPublicFragment localCompatPublicFragment = this.b;
    if (localCompatPublicFragment != null) {
      localCompatPublicFragment.initWindowStyleAndAnimation(this);
    }
    if (paramBundle != null)
    {
      QLog.d("CompatPublicActivity", 1, "Activity restored, set classloader.");
      a(paramBundle);
    }
    setContentView(2131629198);
    if (this.b == null)
    {
      QLog.d("CompatPublicActivity", 1, "onCreate error frag null.");
      finish();
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131433667, this.b);
    paramBundle.commitAllowingStateLoss();
    QLog.d("CompatPublicActivity", 1, "onCreate success");
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (a.containsKey(paramString))
    {
      View localView = ((CompatPublicActivity.IViewCreator)a.get(paramString)).a(paramString, paramContext, paramAttributeSet);
      if (localView != null) {
        return localView;
      }
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    CompatPublicFragment localCompatPublicFragment = this.b;
    if ((localCompatPublicFragment != null) && (localCompatPublicFragment.doOnKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    CompatPublicFragment localCompatPublicFragment = this.b;
    if (localCompatPublicFragment != null) {
      localCompatPublicFragment.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    CompatPublicFragment localCompatPublicFragment = this.b;
    if (localCompatPublicFragment != null) {
      localCompatPublicFragment.onNewIntent(paramIntent);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    CompatPublicFragment localCompatPublicFragment = this.b;
    if (localCompatPublicFragment != null) {
      localCompatPublicFragment.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public String toString()
  {
    String str = super.toString();
    if (this.b != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(this.b.getClass().getName());
      ((StringBuilder)localObject).append("@");
      ((StringBuilder)localObject).append(Integer.toHexString(this.b.hashCode()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.activity.CompatPublicActivity
 * JD-Core Version:    0.7.0.1
 */