package com.sixgod.pluginsdk.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.a.g;
import com.sixgod.pluginsdk.b;
import com.sixgod.pluginsdk.exception.SixGodException;
import com.sixgod.pluginsdk.log.SGLog;
import com.sixgod.pluginsdk.log.SixGodReporter;
import java.io.File;
import java.util.HashMap;

public class ContainerActivity
  extends Activity
{
  String a = "";
  com.sixgod.pluginsdk.a.a b = null;
  com.sixgod.pluginsdk.apkmanager.a c = null;
  protected PluginLoadParams d = null;
  protected com.sixgod.pluginsdk.e e = null;
  boolean f = false;
  boolean g = false;
  boolean h;
  int i;
  protected BroadcastReceiver j;
  Bundle k;
  private Activity l;
  private ActivityInfo m;
  private String n;
  
  private Parcelable a(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBundle != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramBundle.containsKey("android:fragments"))
      {
        localObject1 = paramBundle.getParcelable("android:fragments");
        paramBundle.remove("android:fragments");
      }
      super.onCreate(paramBundle);
      return localObject1;
    }
    catch (Exception paramBundle)
    {
      SixGodReporter.reportException("CallSuperCreateExp", paramBundle);
      throw paramBundle;
    }
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = this.c.a(paramActivity.getComponentName());
    SGLog.a("ContainerActiivty createInnerActivity initUI...");
    setRequestedOrientation(((ActivityInfo)localObject).screenOrientation);
    getWindow().setSoftInputMode(((ActivityInfo)localObject).softInputMode);
    try
    {
      setContentView(paramActivity.getWindow().getDecorView());
      getWindow().setAttributes(this.l.getWindow().getAttributes());
      paramActivity = "start_activity_success class = " + paramActivity.getClass().getName();
      SixGodReporter.reportInfo("StartActivity", 0, 0, this.a, "", SixGodReporter.sDevInfo, paramActivity);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = "";
      if (paramActivity != null) {
        localObject = paramActivity.getClass().getName();
      }
      paramActivity = "setContentView or postCreate failed! class = " + (String)localObject;
      SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, paramActivity);
      SixGodReporter.reportException("CreateActivityExp", localException);
      throw new SixGodException("create activity failed!", localException);
    }
  }
  
  private boolean a(Intent paramIntent, Bundle paramBundle)
  {
    this.e = SixGodHelper.getPluginLoader(this.d.pkgName);
    if ((this.e != null) && (!new File(this.e.e().apkPath).exists()))
    {
      SGLog.a("initLoader apkfile not exists  unloadplugin");
      SixGodHelper.unLoadPlugin(this, this.d.pkgName, false);
      this.e = null;
    }
    this.e = SixGodHelper.getPluginLoader(this.d.pkgName);
    int i1;
    if (this.e == null)
    {
      i1 = paramIntent.getIntExtra("load_plugin_retry_idx", 1);
      if (i1 <= 2) {}
    }
    try
    {
      paramIntent = a(paramBundle);
      if (paramIntent != null) {
        paramBundle.putParcelable("android:fragments", paramIntent);
      }
      finish();
      return false;
    }
    catch (Exception paramIntent)
    {
      return false;
    }
    paramIntent.putExtra("load_plugin_retry_idx", i1 + 1);
    setTheme(16973840);
    new Thread(new c(this)).start();
    try
    {
      paramIntent = a(paramBundle);
      if (paramIntent != null) {
        paramBundle.putParcelable("android:fragments", paramIntent);
      }
      return true;
    }
    catch (Exception paramIntent) {}
    this.e = SixGodHelper.getPluginLoader(this.d.pkgName);
    if (this.e != null)
    {
      this.b = this.e.d();
      this.c = this.e.c();
      return true;
    }
    finish();
    return false;
    return false;
  }
  
  public void bindPlugin(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.l = paramActivity;
    if (paramBoolean1) {
      a(paramActivity);
    }
    if (this.c != null) {
      this.m = this.c.a(this.l.getComponentName());
    }
    this.n = this.l.getPackageName();
    paramActivity = SixGodHelper.getPluginLoader(this.n);
    this.e = paramActivity;
    this.b = paramActivity.d();
    this.c = paramActivity.c();
    this.d = paramActivity.e();
    this.m = this.c.a(this.l.getComponentName());
    if (paramBoolean2) {
      paramActivity.d().u.a(this.l, null);
    }
    if (paramBoolean3) {
      paramActivity.d().v.a(this.l, null);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.l != null) {
      try
      {
        boolean bool = this.l.dispatchKeyEvent(paramKeyEvent);
        return bool;
      }
      catch (Exception localException)
      {
        SGLog.b("dispacth exp " + localException + " e.msg = " + localException.getMessage());
        SGLog.b("event = " + paramKeyEvent.toString());
        return super.dispatchKeyEvent(paramKeyEvent);
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void finish()
  {
    if (this.l != null)
    {
      Integer localInteger = (Integer)this.b.aT.a(this.l);
      Intent localIntent = (Intent)this.b.aU.a(this.l);
      if (localInteger != null) {
        super.setResult(localInteger.intValue(), localIntent);
      }
    }
    super.finish();
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject1;
    Object localObject2;
    if (this.c != null)
    {
      localObject1 = this.c;
      localObject2 = this.n;
      localObject1 = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject2);
      if (localObject1 == null) {
        localObject1 = null;
      }
    }
    for (;;)
    {
      localObject2 = new StringBuilder("getClassLoader mPluginClassLoader == null ? ");
      if (localObject1 == null) {}
      for (boolean bool = true;; bool = false)
      {
        SGLog.a(bool + " mPkg = " + this.n);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = super.getClassLoader();
        }
        return localObject2;
        localObject1 = ((com.sixgod.pluginsdk.apkmanager.c)localObject1).b;
        break;
      }
      localObject1 = null;
    }
  }
  
  protected boolean isLoadPluginOnCreate()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.l != null)
    {
      if (paramIntent != null)
      {
        localObject = this.c;
        String str = this.m.packageName;
        localObject = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
        if (localObject != null) {
          break label93;
        }
      }
      label93:
      for (Object localObject = null;; localObject = ((com.sixgod.pluginsdk.apkmanager.c)localObject).b)
      {
        paramIntent.setExtrasClassLoader((ClassLoader)localObject);
        this.b.K.a(this.l, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
        return;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    super.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
    if (this.l != null) {
      this.b.J.a(this.l, new Object[] { paramTheme, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    }
  }
  
  protected void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.l != null) {
      this.l.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onContentChanged()
  {
    super.onContentChanged();
    if (this.l != null) {
      this.l.onContentChanged();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    SGLog.a("ContainerActivity onCreate; " + hashCode());
    this.k = paramBundle;
    if (paramBundle != null) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        paramBundle.containsKey("a");
        localObject1 = super.getIntent();
        this.d = PluginLoadParams.parseFromJson(((Intent)localObject1).getStringExtra("plugin_load_params"));
        this.h = ((Intent)localObject1).getBooleanExtra("is_special_activity", false);
        this.i = ((Intent)localObject1).getIntExtra("special_type", -1);
        this.n = ((Intent)localObject1).getStringExtra("packageName");
        this.f = ((Intent)localObject1).getBooleanExtra("is_main", false);
        if (!isLoadPluginOnCreate()) {
          break;
        }
        if (!a((Intent)localObject1, paramBundle))
        {
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        return;
      }
      if (this.e != null)
      {
        if (paramBundle != null) {
          paramBundle.getClassLoader();
        }
        Object localObject2;
        if (paramBundle != null)
        {
          localObject1 = this.c;
          localObject2 = this.n;
          localObject1 = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject2);
          if (localObject1 != null) {
            break label319;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject1 = this.c;
            localObject2 = this.n;
            localObject1 = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject2);
            if (localObject1 != null) {
              break label329;
            }
          }
        }
        label319:
        label329:
        for (localObject1 = null;; localObject1 = ((com.sixgod.pluginsdk.apkmanager.c)localObject1).b)
        {
          paramBundle.setClassLoader((ClassLoader)localObject1);
          if (paramBundle != null) {
            paramBundle.getClassLoader();
          }
          try
          {
            localObject1 = a(paramBundle);
            localObject2 = this.c;
            String str = this.n;
            if ((com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject2).e.get(str) != null) {
              break label345;
            }
            SGLog.b("create Activity Failed! msg = appInfo null, not installed or unLaunched!");
            SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, "get PluginAppInfo null");
            finish();
            return;
          }
          catch (Exception paramBundle)
          {
            finish();
            return;
          }
          localObject1 = ((com.sixgod.pluginsdk.apkmanager.c)localObject1).b;
          break;
        }
        label345:
        if (localObject1 != null) {}
        long l1;
        try
        {
          paramBundle.putParcelable("android:fragments", (Parcelable)localObject1);
          l1 = System.currentTimeMillis();
          this.l = this.e.a(this, getIntent(), paramBundle);
          if (this.l == null)
          {
            SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, "create InnerActivity failed");
            this.e.p.a(getClass().getName(), 1, "mActivity = null");
            finish();
            return;
          }
        }
        catch (Exception paramBundle)
        {
          SGLog.b("create Activity Failed! msg = " + paramBundle.getMessage());
          paramBundle.printStackTrace();
          localObject1 = "create ActivityFailed! msg = " + paramBundle.getMessage();
          SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, (String)localObject1);
          SixGodReporter.reportException("CreateActivityExp", paramBundle);
          if (this.f) {
            this.e.p.a(getClass().getName(), 5, paramBundle.getMessage());
          }
          finish();
        }
        while (this.j == null)
        {
          this.j = new e(this);
          paramBundle = new IntentFilter("com.sixgod.pluginsdk.unload_plugin.ACTION");
          registerReceiver(this.j, paramBundle);
          return;
          this.m = this.c.a(this.l.getComponentName());
          a(this.l);
          SGLog.a("sixgod_perf", "createInnerActivity dTime = " + (System.currentTimeMillis() - l1));
          if (this.f) {
            this.e.p.a(getClass().getName());
          }
        }
      }
    }
    try
    {
      a(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      finish();
    }
  }
  
  public CharSequence onCreateDescription()
  {
    if (this.l != null) {
      return this.l.onCreateDescription();
    }
    return super.onCreateDescription();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (this.l != null) {
      return (Dialog)this.b.H.a(this.l, new Object[] { Integer.valueOf(paramInt) });
    }
    return super.onCreateDialog(paramInt);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (this.l != null) {
      return this.l.onCreatePanelMenu(paramInt, paramMenu);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (this.l != null) {
      return this.l.onCreatePanelView(paramInt);
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas)
  {
    if (this.l != null) {
      return this.l.onCreateThumbnail(paramBitmap, paramCanvas);
    }
    return super.onCreateThumbnail(paramBitmap, paramCanvas);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (this.l != null) {
      return this.l.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.j != null) {
      unregisterReceiver(this.j);
    }
    if (this.l != null) {
      this.b.F.a(this.l, null);
    }
    if ((this.h) && (this.i != -1))
    {
      this.e.a(this.i, getClass().getName());
      this.e.b(this.i, this.l.getClass().getName());
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.l != null) {
      this.l.onLowMemory();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    ClassLoader localClassLoader = null;
    SGLog.a("ContainerActiivty onNewIntent");
    if (paramIntent != null) {}
    for (paramIntent = (Intent)paramIntent.getParcelableExtra("plugin_intent");; paramIntent = null)
    {
      Object localObject;
      if (this.l != null) {
        if (paramIntent != null)
        {
          localObject = this.c;
          String str = this.m.packageName;
          localObject = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
          if (localObject != null) {
            break label94;
          }
        }
      }
      for (;;)
      {
        paramIntent.setExtrasClassLoader(localClassLoader);
        this.b.z.a(this.l, new Object[] { paramIntent });
        return;
        label94:
        localClassLoader = ((com.sixgod.pluginsdk.apkmanager.c)localObject).b;
      }
    }
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    if (this.l != null) {
      this.l.onPanelClosed(paramInt, paramMenu);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.l != null) {
      this.b.C.a(this.l, null);
    }
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (this.l != null) {
      this.b.G.a(this.l, new Object[] { paramBundle });
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    super.onPrepareDialog(paramInt, paramDialog);
    if (this.l != null) {
      this.b.I.a(this.l, new Object[] { Integer.valueOf(paramInt), paramDialog });
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (this.l != null) {
      return this.l.onPreparePanel(paramInt, paramView, paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.l != null) {
      this.b.w.a(this.l, null);
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle.getParcelable("android:fragments") != null)
    {
      SGLog.a("onRestoreInstanceState fragments has");
      paramBundle.remove("android:fragments");
    }
  }
  
  protected void onResume()
  {
    SGLog.a("ContainerActiivty onResume; " + hashCode());
    super.onResume();
    if (this.l != null) {
      this.b.v.a(this.l, null);
    }
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    if (this.l != null) {
      return this.l.onRetainNonConfigurationInstance();
    }
    return super.onRetainNonConfigurationInstance();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    SGLog.a("ContainerActiivty onSaveInstanceState + " + hashCode());
    super.onSaveInstanceState(paramBundle);
    if (this.l != null) {
      if ((paramBundle != null) && (this.m != null) && (this.c != null))
      {
        localObject = this.c;
        String str = this.m.packageName;
        localObject = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
        if (localObject != null) {
          break label113;
        }
      }
    }
    label113:
    for (Object localObject = null;; localObject = ((com.sixgod.pluginsdk.apkmanager.c)localObject).b)
    {
      paramBundle.setClassLoader((ClassLoader)localObject);
      this.b.A.a(this.l, new Object[] { paramBundle });
      return;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.l != null)
    {
      if (!this.b.x.a()) {
        break label41;
      }
      this.b.x.a(this.l, null);
    }
    label41:
    while (!this.b.y.a()) {
      return;
    }
    this.b.y.a(this.l, new Object[] { Boolean.valueOf(true) });
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (this.l != null) {
      return this.l.onTrackballEvent(paramMotionEvent);
    }
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    super.onUserInteraction();
    if (this.l != null) {
      this.l.onUserInteraction();
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if (this.l != null) {
      this.b.D.a(this.l, null);
    }
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
    if (this.l != null) {
      this.l.onWindowAttributesChanged(paramLayoutParams);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.l != null) {
      this.l.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent = f.a(this, paramIntent);
    if (paramIntent == null)
    {
      SGLog.b("startActivity from child but intent got null");
      return;
    }
    super.startActivityFromChild(paramActivity, paramIntent, paramInt);
  }
  
  public void unbindPlugin()
  {
    this.l = null;
    this.m = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.ContainerActivity
 * JD-Core Version:    0.7.0.1
 */