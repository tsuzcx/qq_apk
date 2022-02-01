package com.tencent.luggage.wxa.bi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.wxa.da.g;
import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.or.h;
import com.tencent.luggage.wxa.ov.f;
import com.tencent.luggage.wxa.pp.ae;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.joor.Reflect;

public abstract class b
  extends AppCompatActivity
  implements LuggageActivityHelper.ILuggageActivityHelper, ae
{
  private FrameLayout a;
  private a b;
  private com.tencent.luggage.wxa.pp.a c = new com.tencent.luggage.wxa.pp.a(this);
  private Boolean d;
  
  private boolean a(Intent paramIntent, String paramString)
  {
    try
    {
      if (com.tencent.luggage.opensdk.d.a(this, paramIntent))
      {
        com.tencent.luggage.wxa.ef.a.a(this);
        o.d("Luggage.BaseContainerActivity", "handleOpenSDKApiClientResponse, intent:%s, activity:%d, reason:%s, handled", new Object[] { paramIntent, Integer.valueOf(hashCode()), paramString });
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      o.b("Luggage.BaseContainerActivity", "handleOpenSDKApiClientResponse, intent:%s, activity:%d, reason:%s, get exception:%s", new Object[] { paramIntent, Integer.valueOf(hashCode()), paramString, localException });
    }
    return false;
  }
  
  private boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {
      return false;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null) {
      return false;
    }
    try
    {
      boolean bool = localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      return bool;
    }
    catch (IllegalArgumentException paramView)
    {
      o.b("Luggage.BaseContainerActivity", "hide VKB(View) exception %s", new Object[] { paramView });
    }
    return false;
  }
  
  private boolean b(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    if (paramIntent.getBooleanExtra("intentForStartWxa", false)) {
      return false;
    }
    int i;
    if ((paramIntent.getFlags() & 0x10000000) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool3 = com.tencent.luggage.wxa.pd.d.a(paramIntent.getComponent()).equals(com.tencent.luggage.wxa.pd.d.a(getComponentName()));
    int j;
    if (c.d.c == c.i(paramString)) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool1;
    if (i != 0)
    {
      bool1 = bool2;
      if (!bool3) {}
    }
    else
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    paramActivity = paramActivity.getCurrentFocus();
    if (paramActivity == null) {
      return;
    }
    if (paramActivity.getWindowToken() == null) {
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 2);
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    setContentView(paramFrameLayout);
  }
  
  public boolean a()
  {
    Object localObject1 = this.d;
    if (localObject1 != null) {
      return ((Boolean)localObject1).booleanValue();
    }
    Object localObject4 = r.a().getPackageManager();
    Object localObject3 = null;
    try
    {
      localObject1 = ((PackageManager)localObject4).getActivityInfo(getComponentName(), 128);
      localObject3 = localObject1;
    }
    catch (Exception localException1)
    {
      o.b("Luggage.BaseContainerActivity", "runInStandaloneTask, resolve info e = %s", new Object[] { localException1 });
    }
    if (localObject3 == null)
    {
      o.b("Luggage.BaseContainerActivity", "runInStandaloneTask is null, return true");
      return true;
    }
    try
    {
      String str = ((PackageManager)localObject4).getPackageInfo(r.b(), 0).applicationInfo.taskAffinity;
    }
    catch (Exception localException2)
    {
      o.b("Luggage.BaseContainerActivity", "getPackageInfo fail, use default. e = %s", new Object[] { localException2 });
      localObject2 = "";
    }
    localObject4 = localObject2;
    if (((String)localObject2).isEmpty()) {
      localObject4 = r.b();
    }
    o.d("Luggage.BaseContainerActivity", "runInStandaloneTask targetAffinityName:%s info.taskAffinity:%s", new Object[] { r.b(), localObject3.taskAffinity });
    Object localObject2 = Boolean.valueOf(((String)localObject4).equals(localObject3.taskAffinity) ^ true);
    this.d = ((Boolean)localObject2);
    return ((Boolean)localObject2).booleanValue();
  }
  
  protected a b()
  {
    return this.b;
  }
  
  public final int c()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.o();
    }
    return 0;
  }
  
  @Nullable
  public final com.tencent.luggage.wxa.iu.d d()
  {
    a locala = this.b;
    if (locala != null) {
      return (com.tencent.luggage.wxa.ed.d)locala.getActiveRuntime();
    }
    return null;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Object localObject = b();
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.iu.n)localObject).getActiveRuntime();
      if ((localObject != null) && (((com.tencent.luggage.wxa.iu.d)localObject).a(paramKeyEvent.getKeyCode(), paramKeyEvent))) {
        return true;
      }
    }
    o.e("Luggage.BaseContainerActivity", "onKeyDown: keyCode = [%d], keyAction =[%d]", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected abstract Class<? extends com.tencent.luggage.wxa.ed.d> e();
  
  protected Class<? extends a> f()
  {
    return a.class;
  }
  
  public void finish()
  {
    if (!isDestroyed())
    {
      if (isFinishing()) {
        return;
      }
      this.b.j();
      this.b.f_();
      if ((a()) && (Build.VERSION.SDK_INT >= 21)) {
        super.finishAndRemoveTask();
      } else {
        super.finish();
      }
      overridePendingTransition(2130772043, 2130772044);
    }
  }
  
  protected com.tencent.luggage.wxa.pa.a g()
  {
    return new b.1(this);
  }
  
  protected FrameLayout h()
  {
    if (this.a == null) {
      this.a = new FrameLayout(this);
    }
    return this.a;
  }
  
  public final void hideVKB(View paramView)
  {
    a(paramView);
  }
  
  public final void i()
  {
    j();
  }
  
  public final boolean j()
  {
    View localView = getCurrentFocus();
    if (localView == null) {
      return a(h());
    }
    return a(localView);
  }
  
  public final void k()
  {
    a(this);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    paramBoolean = super.moveTaskToBack(paramBoolean);
    overridePendingTransition(2130772043, 2130772044);
    return paramBoolean;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    LuggageActivityHelper.FOR(this).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    a locala = this.b;
    if ((locala != null) && (locala.getActiveRuntime() != null))
    {
      this.b.h();
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.c.a(paramConfiguration);
    this.b.b(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (a(getIntent(), "onCreate"))
    {
      super.finish();
      return;
    }
    if ((getIntent().getBooleanExtra("com.tencent.luggage.container.BaseContainerActivity.INTENT_KEY_BRING_TO_FRONT", false)) && (!g.a(new com.tencent.luggage.wxa.ew.b(), getIntent())))
    {
      super.finish();
      return;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      getWindow().setFlags(16777216, 16777216);
    }
    if ((Build.VERSION.SDK_INT >= 28) && (getWindow() != null))
    {
      paramBundle = getWindow().getAttributes();
      paramBundle.layoutInDisplayCutoutMode = 1;
      getWindow().setAttributes(paramBundle);
    }
    this.c.a();
    this.a = h();
    a(this.a);
    this.c.a(this.a);
    this.b = ((a)Reflect.on(f()).create(new Object[] { g(), e() }).get());
    this.b.a(getIntent(), "onCreate");
    this.b.a(new com.tencent.luggage.wxa.pp.n(this, this.a));
    overridePendingTransition(2130772046, 2130772045);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a locala = this.b;
    if (locala != null)
    {
      locala.f_();
      o.b();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (a(paramIntent, "onNewIntent")) {
      return;
    }
    if (paramIntent.getBooleanExtra("com.tencent.luggage.container.BaseContainerActivity.INTENT_KEY_BRING_TO_FRONT", false))
    {
      com.tencent.luggage.wxa.ef.a.a(this);
      return;
    }
    if (this.b.a(paramIntent, "onNewIntent"))
    {
      setIntent(paramIntent);
      overridePendingTransition(2130772046, 2130772045);
      return;
    }
    com.tencent.luggage.wxa.iu.d locald = this.b.getActiveRuntime();
    if (locald != null) {
      c.a(locald.aa(), paramIntent);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.d();
    h.a(this).b();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.b.a(paramInt, paramArrayOfString, paramArrayOfInt);
    LuggageActivityHelper.FOR(this).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.c();
    h.a(this).a();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
    this.c.a(paramLayoutParams);
  }
  
  public final void setTaskDescription(ActivityManager.TaskDescription paramTaskDescription)
  {
    if (a()) {
      try
      {
        super.setTaskDescription(paramTaskDescription);
        return;
      }
      catch (Exception localException)
      {
        o.a("Luggage.BaseContainerActivity", localException, "setTaskDescription ", new Object[0]);
        if (paramTaskDescription == null) {}
      }
    }
    try
    {
      super.setTaskDescription(new ActivityManager.TaskDescription(paramTaskDescription.getLabel(), null, paramTaskDescription.getPrimaryColor()));
      return;
    }
    catch (Exception paramTaskDescription) {}
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    try
    {
      ((com.tencent.luggage.wxa.ed.d)b().getActiveRuntime()).k().getReporter().a(paramIntent);
      label22:
      Object localObject = (com.tencent.luggage.wxa.ed.d)this.b.getActiveRuntime();
      if ((localObject != null) && (paramIntent != null))
      {
        localObject = ((com.tencent.luggage.wxa.ed.d)localObject).aa();
        if (b(paramIntent, (String)localObject)) {
          c.a((String)localObject, c.d.g);
        }
      }
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.b
 * JD-Core Version:    0.7.0.1
 */