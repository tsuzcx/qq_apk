package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BridgeActivity
  extends Activity
{
  public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
  public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
  public static final String EXTRA_INTENT = "intent.extra.intent";
  public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
  public static final String EXTRA_RESULT = "intent.extra.RESULT";
  public static final int b = a("ro.build.hw_emui_api_level", 0);
  public IBridgeActivityDelegate a;
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int i = ((Integer)localClass.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|InvocationTargetException|ClassCastException paramString)
    {
      label55:
      break label55;
    }
    HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
    return paramInt;
  }
  
  public static void a(Window paramWindow, boolean paramBoolean)
  {
    try
    {
      localObject = paramWindow.getClass();
      ((Class)localObject).getMethod("setHwFloating", new Class[] { Boolean.TYPE }).invoke(paramWindow, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (InvocationTargetException paramWindow) {}catch (IllegalArgumentException paramWindow) {}catch (IllegalAccessException paramWindow) {}catch (NoSuchMethodException paramWindow) {}
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("In setHwFloating, Failed to call Window.setHwFloating().");
    ((StringBuilder)localObject).append(paramWindow.getMessage());
    HMSLog.e("BridgeActivity", ((StringBuilder)localObject).toString());
  }
  
  public static Intent getIntentStartBridgeActivity(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, BridgeActivity.class);
    localIntent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", paramString);
    localIntent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(paramActivity));
    return localIntent;
  }
  
  public static Intent getIntentStartBridgeActivity(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, BridgeActivity.class);
    paramContext.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", paramString);
    paramContext.putExtra("intent.extra.isfullscreen", false);
    return paramContext;
  }
  
  public final void a()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().findViewById(16908290);
    if (localViewGroup == null)
    {
      HMSLog.e("BridgeActivity", "rootView is null");
      return;
    }
    Object localObject = getWindow().getAttributes();
    try
    {
      Class localClass = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
      localObject = localClass.getDeclaredConstructor(new Class[] { WindowManager.LayoutParams.class }).newInstance(new Object[] { localObject });
      localClass.getMethod("setDisplaySideMode", new Class[] { Integer.TYPE }).invoke(localObject, new Object[] { Integer.valueOf(1) });
    }
    catch (ClassNotFoundException localClassNotFoundException) {}catch (InstantiationException localInstantiationException) {}catch (ClassCastException localClassCastException) {}catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (NoSuchMethodException localNoSuchMethodException) {}
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("An exception occurred while reading: setDisplaySideMode");
    ((StringBuilder)localObject).append(localNoSuchMethodException.getMessage());
    HMSLog.e("BridgeActivity", ((StringBuilder)localObject).toString());
    if (Build.VERSION.SDK_INT >= 20) {
      getWindow().getDecorView().setOnApplyWindowInsetsListener(new BridgeActivity.a(this, localViewGroup));
    }
  }
  
  public final boolean b()
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null intent.");
      return false;
    }
    if (((Intent)localObject).getBooleanExtra("intent.extra.isfullscreen", false)) {
      getWindow().setFlags(1024, 1024);
    }
    localObject = ((Intent)localObject).getStringExtra("intent.extra.DELEGATE_CLASS_OBJECT");
    if (localObject == null)
    {
      HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
      return false;
    }
    StringBuilder localStringBuilder;
    try
    {
      this.a = ((IBridgeActivityDelegate)Class.forName((String)localObject).asSubclass(IBridgeActivityDelegate.class).newInstance());
      try
      {
        this.a.onBridgeActivityCreate(this);
        return true;
      }
      catch (RuntimeException localRuntimeException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Run time Exception.");
        localStringBuilder.append(localRuntimeException.getMessage());
        HMSLog.e("BridgeActivity", localStringBuilder.toString());
        return false;
      }
      localStringBuilder = new StringBuilder();
    }
    catch (ClassNotFoundException localClassNotFoundException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InstantiationException localInstantiationException) {}catch (ClassCastException localClassCastException) {}
    localStringBuilder.append("In initialize, Failed to create 'IUpdateWizard' instance.");
    localStringBuilder.append(localClassCastException.getMessage());
    HMSLog.e("BridgeActivity", localStringBuilder.toString());
    return false;
  }
  
  public final void c()
  {
    requestWindowFeature(1);
    Window localWindow = getWindow();
    if (b >= 9)
    {
      localWindow.addFlags(67108864);
      a(localWindow, true);
    }
    localWindow.getDecorView().setSystemUiVisibility(0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    HMSLog.i("BridgeActivity", "Enter finish.");
    super.finish();
  }
  
  public Intent getIntent()
  {
    Intent localIntent = super.getIntent();
    if (localIntent != null) {
      return new SafeIntent(localIntent);
    }
    return localIntent;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = new SafeIntent(paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    IBridgeActivityDelegate localIBridgeActivityDelegate = this.a;
    if ((localIBridgeActivityDelegate != null) && (!localIBridgeActivityDelegate.onBridgeActivityResult(paramInt1, paramInt2, paramIntent)) && (!isFinishing()))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    IBridgeActivityDelegate localIBridgeActivityDelegate = this.a;
    if (localIBridgeActivityDelegate != null) {
      localIBridgeActivityDelegate.onBridgeConfigurationChanged();
    }
    EventCollector.getInstance().onActivityConfigurationChanged(localIBridgeActivityDelegate, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null) {
      return;
    }
    c();
    a();
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(getApplicationContext());
    }
    if (!b())
    {
      setResult(1, null);
      finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IBridgeActivityDelegate localIBridgeActivityDelegate = this.a;
    if (localIBridgeActivityDelegate != null) {
      localIBridgeActivityDelegate.onBridgeActivityDestroy();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    IBridgeActivityDelegate localIBridgeActivityDelegate = this.a;
    if (localIBridgeActivityDelegate != null) {
      localIBridgeActivityDelegate.onKeyUp(paramInt, paramKeyEvent);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.activity.BridgeActivity
 * JD-Core Version:    0.7.0.1
 */