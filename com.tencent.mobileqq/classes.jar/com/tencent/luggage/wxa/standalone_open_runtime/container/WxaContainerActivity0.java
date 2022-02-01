package com.tencent.luggage.wxa.standalone_open_runtime.container;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.luggage.opensdk.d.b;
import com.tencent.luggage.wxa.bi.a;
import com.tencent.luggage.wxa.fq.j;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/container/WxaContainerActivity0;", "Lcom/tencent/luggage/container/BaseContainerActivity;", "()V", "appIdForCloseEvent", "", "mInitializingInflater", "", "mInitializingResources", "mOverrideInflater", "Landroid/view/LayoutInflater;", "mOverrideResources", "Landroid/content/res/Resources;", "mThemeWrapper", "Landroid/view/ContextThemeWrapper;", "timestampForCloseEvent", "", "getResources", "getRuntimeClass", "Ljava/lang/Class;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntimeContainerClass", "Lcom/tencent/luggage/container/AppBrandRuntimeContainerStandaloneImpl;", "getSystemService", "", "name", "initThemeWrapper", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "saveForCloseEvent", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public class WxaContainerActivity0
  extends com.tencent.luggage.wxa.bi.b
{
  @Deprecated
  public static final WxaContainerActivity0.a a = new WxaContainerActivity0.a(null);
  private long b;
  private String c = "";
  private ContextThemeWrapper d;
  private boolean e;
  private Resources f;
  private boolean g;
  private LayoutInflater h;
  
  static
  {
    com.tencent.luggage.opensdk.d.a(WXLaunchWxaRedirectingPage.Resp.class, (d.b)WxaContainerActivity0.b.a);
  }
  
  private final void l()
  {
    Object localObject1 = new com.tencent.luggage.wxa.ew.b();
    Object localObject2 = getIntent();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "intent");
    if ((com.tencent.luggage.wxa.da.g.b((com.tencent.luggage.wxa.ew.b)localObject1, (Intent)localObject2, "action")) && (((com.tencent.luggage.wxa.ew.b)localObject1).a != null))
    {
      localObject2 = ((com.tencent.luggage.wxa.ew.b)localObject1).a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "action.appId");
      int i;
      if (((CharSequence)localObject2).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.b = ((com.tencent.luggage.wxa.ew.b)localObject1).j;
        localObject1 = ((com.tencent.luggage.wxa.ew.b)localObject1).a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "action.appId");
        this.c = ((String)localObject1);
      }
    }
  }
  
  private final void m()
  {
    if (this.d != null) {
      return;
    }
    this.d = ((ContextThemeWrapper)new com.tencent.luggage.wxa.standalone_open_runtime.ui.g((Context)this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @NotNull
  protected Class<? extends com.tencent.luggage.wxa.ed.d> e()
  {
    return com.tencent.luggage.wxa.fk.e.class;
  }
  
  @NotNull
  protected Class<? extends a> f()
  {
    return com.tencent.luggage.wxa.standalone_open_runtime.ui.e.class;
  }
  
  @Nullable
  public Resources getResources()
  {
    if (this.e) {
      return super.getResources();
    }
    Object localObject = this.f;
    if (localObject != null) {
      return localObject;
    }
    this.e = true;
    m();
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.f = ((ContextThemeWrapper)localObject).getResources();
    this.e = false;
    return this.f;
  }
  
  @Nullable
  public Object getSystemService(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    if (Intrinsics.areEqual("layout_inflater", paramString))
    {
      if (this.g) {
        return super.getSystemService(paramString);
      }
      paramString = this.h;
      if (paramString != null) {
        return paramString;
      }
      this.g = true;
      m();
      this.h = LayoutInflater.from((Context)this.d);
      this.g = false;
      return this.h;
    }
    return super.getSystemService(paramString);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    setTheme(2131952947);
    super.onCreate(paramBundle);
    l();
  }
  
  public void onDestroy()
  {
    a locala = b();
    if (locala != null) {
      locala.e();
    }
    super.onDestroy();
    j.a.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity0
 * JD-Core Version:    0.7.0.1
 */