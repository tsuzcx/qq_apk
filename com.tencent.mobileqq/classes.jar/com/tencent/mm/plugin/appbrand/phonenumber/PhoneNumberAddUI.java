package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.base.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class PhoneNumberAddUI
  extends c
{
  public static final PhoneNumberAddUI.a a = new PhoneNumberAddUI.a(null);
  private l b;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    if (k.a.a()) {
      setTheme(2131952729);
    } else {
      setTheme(2131952730);
    }
    super.onCreate(paramBundle);
    a(getResources().getColor(2131165189));
    setActionBarColor(getResources().getColor(2131165190));
    d();
    paramBundle = getIntent().getStringExtra("APPID");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate() appId:");
    ((StringBuilder)localObject).append(paramBundle);
    o.d("MicroMsg.PhoneNumberAddUI", ((StringBuilder)localObject).toString());
    setTitle(2131886957);
    setBackBtn((MenuItem.OnMenuItemClickListener)new PhoneNumberAddUI.b(this));
    localObject = v.a.a();
    Context localContext = (Context)this;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "appId");
    this.b = ((n)localObject).a(localContext, paramBundle, (Function0)new PhoneNumberAddUI.c(this));
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle.a();
    }
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle = paramBundle.b();
    } else {
      paramBundle = null;
    }
    setContentView(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    l locall = this.b;
    if (locall != null) {
      locall.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */