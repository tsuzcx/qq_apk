package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.ui.BaseActivity.OptionMenuStyle;
import com.tencent.mm.ui.base.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import junit.framework.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberManagerLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "showDelete", "", "enableEditPhoneNumber", "", "enable", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "updateView", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class PhoneNumberManagerUI
  extends c
{
  public static final PhoneNumberManagerUI.a a = new PhoneNumberManagerUI.a(null);
  private o b;
  private boolean c;
  
  private final void a()
  {
    removeAllOptionMenu();
    o localo = this.b;
    if (localo != null) {
      localo.a(this.c);
    }
    if (this.c)
    {
      addTextOptionMenu(0, getString(2131886965), BaseActivity.OptionMenuStyle.TEXT, (MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.b(this), (View.OnLongClickListener)null);
      setBackBtn(2131230725, (MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.c(this));
      return;
    }
    addTextOptionMenu(0, getString(2131886972), BaseActivity.OptionMenuStyle.TEXT, (MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.d(this), (View.OnLongClickListener)null);
    setBackBtn((MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.e(this));
  }
  
  private final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    o localo = this.b;
    if (localo != null) {
      localo.b(paramBoolean);
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
  
  public void onBackPressed()
  {
    if (this.c)
    {
      a(false);
      a();
      return;
    }
    super.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    setTheme(2131952728);
    super.onCreate(paramBundle);
    setActionBarColor(getResources().getColor(2131165190));
    a(getResources().getColor(2131165189));
    d();
    setTitle(2131886973);
    paramBundle = getIntent().getStringExtra("APPID");
    af.c(paramBundle);
    a.b(false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate() appId:");
    ((StringBuilder)localObject).append(paramBundle);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.PhoneNumberManagerUI", ((StringBuilder)localObject).toString());
    localObject = getIntent().getStringExtra("PAGEPATH");
    n localn = v.a.a();
    Context localContext = (Context)this;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "appId");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "pagePath");
    this.b = localn.b(localContext, paramBundle, (String)localObject);
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
    o localo = this.b;
    if (localo != null) {
      localo.f();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI
 * JD-Core Version:    0.7.0.1
 */