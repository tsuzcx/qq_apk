package com.tencent.mm.ui.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class c
  extends BaseActivity
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  private ContextThemeWrapper a;
  private boolean b = false;
  private Resources c = null;
  private boolean d = false;
  private LayoutInflater e;
  
  private boolean a()
  {
    return (a("y83a")) || (a("y83")) || (a("v1732a")) || (a("v1732t"));
  }
  
  private boolean a(String paramString)
  {
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null)) {
      return false;
    }
    return (a(str1, paramString)) || (a(str2, paramString));
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return af.b(paramString1.toLowerCase(), paramString2.toLowerCase());
    }
    return false;
  }
  
  private void b()
  {
    if (this.a != null) {
      return;
    }
    this.a = ((k)((e)com.tencent.luggage.wxa.ba.e.a(e.class)).a(this));
  }
  
  public void a(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (!a()))
    {
      getWindow().setNavigationBarColor(paramInt);
      boolean bool = com.tencent.mm.ui.e.a(paramInt);
      View localView = getWindow().getDecorView();
      paramInt = localView.getSystemUiVisibility();
      if (bool) {
        paramInt &= 0xFFFFFFEF;
      } else {
        paramInt |= 0x10;
      }
      localView.setSystemUiVisibility(paramInt);
    }
  }
  
  protected void d()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().setElevation(0.0F);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131624211;
  }
  
  public Resources getResources()
  {
    if (this.b) {
      return super.getResources();
    }
    Resources localResources = this.c;
    if (localResources != null) {
      return localResources;
    }
    this.b = true;
    b();
    this.c = this.a.getResources();
    this.b = false;
    return this.c;
  }
  
  public Object getSystemService(@NonNull String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.d) {
        return super.getSystemService(paramString);
      }
      paramString = this.e;
      if (paramString != null) {
        return paramString;
      }
      this.d = true;
      b();
      this.e = LayoutInflater.from(this.a);
      this.d = false;
      return this.e;
    }
    return super.getSystemService(paramString);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    LuggageActivityHelper.FOR(this).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LuggageActivityHelper.REMOVE(this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    LuggageActivityHelper.FOR(this).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    try
    {
      super.setRequestedOrientation(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("MicroMsg.BaseLuggageActivity", localThrowable, "AndroidOSafety.safety uncaught", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.c
 * JD-Core Version:    0.7.0.1
 */