package com.tencent.luggage.setting.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.luggage.ui.WmpfPresentationActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.util.PresentationActivityHelper;
import com.tencent.luggage.wxa.di.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weui.base.preference.IPreferenceScreen;
import com.tencent.weui.base.preference.WeUIPreference;

public class WmpfAuthorizeDetailUI
  extends WeUIPreference
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  private int a;
  private boolean b = false;
  private IPreferenceScreen c;
  private Preference d;
  private b h;
  private b i;
  private b j;
  private Context k;
  
  private void a(Preference paramPreference)
  {
    if (paramPreference.getKey().equalsIgnoreCase("both"))
    {
      this.a = 2;
      this.h.a(false);
      this.i.a(false);
      paramPreference = this.j;
      if (paramPreference != null) {
        paramPreference.a(true);
      }
    }
    else if (paramPreference.getKey().equalsIgnoreCase("foreground"))
    {
      this.a = 1;
      this.i.a(true);
      this.h.a(false);
      paramPreference = this.j;
      if (paramPreference != null) {
        paramPreference.a(false);
      }
    }
    else
    {
      this.a = 0;
      this.h.a(true);
      this.i.a(false);
      paramPreference = this.j;
      if (paramPreference != null) {
        paramPreference.a(false);
      }
    }
    this.c.notifyDataSetChanged();
  }
  
  private void c()
  {
    setBackBtn(new WmpfAuthorizeDetailUI.1(this));
    if ((getIntent() != null) && (!af.c(getIntent().getStringExtra("key_title"))))
    {
      setTitle(getIntent().getStringExtra("key_title"));
      return;
    }
    setTitle(2131886769);
  }
  
  private void d()
  {
    this.c = getPreferenceScreen();
    this.c.removeAll();
    Object localObject = e();
    if (!af.c((String)localObject))
    {
      this.d = new Preference(this.k);
      this.d.setTitle((CharSequence)localObject);
      this.d.setLayoutResource(2131624000);
      this.c.addPreference(this.d);
    }
    this.h = new b(this.k);
    this.h.setKey("none");
    this.h.a(2131887135);
    this.c.addPreference(this.h);
    this.i = new b(this.k);
    this.i.setKey("foreground");
    this.i.a(2131887134);
    this.c.addPreference(this.i);
    if (f())
    {
      this.j = new b(this.k);
      this.j.setKey("both");
      this.j.a(2131887133);
      this.c.addPreference(this.j);
    }
    if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
      this.a = getIntent().getIntExtra("key_state", 0);
    }
    int m = this.a;
    if (m != 1)
    {
      if (m != 2)
      {
        this.h.a(true);
      }
      else
      {
        localObject = this.j;
        if (localObject != null) {
          ((b)localObject).a(true);
        }
      }
    }
    else {
      this.i.a(true);
    }
    this.c.notifyDataSetChanged();
  }
  
  private String e()
  {
    if ((getIntent() != null) && (!af.c(getIntent().getStringExtra("key_desc"))))
    {
      String str = getIntent().getStringExtra("key_desc");
      return String.format(getString(2131887145), new Object[] { str });
    }
    return null;
  }
  
  private boolean f()
  {
    if (getIntent() != null) {
      return getIntent().getBooleanExtra("key_three_state", false);
    }
    return false;
  }
  
  private void g()
  {
    if (this.b)
    {
      o.d("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.a) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.a);
      PresentationActivityHelper.setResult(-1, getIntent(), localIntent);
      return;
    }
    PresentationActivityHelper.setResult(0, getIntent(), null);
  }
  
  private void h()
  {
    WmpfPresentationActivityHelper.a.a(this);
    WmpfPresentationActivityHelper.a.b(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    g();
    super.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setTheme(2131952521);
    super.onCreate(paramBundle);
    int m = getIntent().getIntExtra("key_display_id", 0);
    this.k = ((com.tencent.mm.ui.base.e)com.tencent.luggage.wxa.ba.e.a(com.tencent.mm.ui.base.e.class)).a(this);
    c();
    d();
    if (m != 0)
    {
      paramBundle = (View)((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getParent();
      if ((paramBundle instanceof ViewGroup)) {
        WmpfPresentationActivityHelper.a.a(this, (ViewGroup)paramBundle, m, true);
      }
    }
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public boolean onPreferenceTreeClick(IPreferenceScreen paramIPreferenceScreen, Preference paramPreference)
  {
    o.d("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.getKey() });
    if ((paramPreference instanceof b))
    {
      this.b = true;
      a(paramPreference);
    }
    return false;
  }
  
  protected void onStart()
  {
    super.onStart();
    View localView = getWindow().getDecorView();
    if (localView != null) {
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFEFF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WmpfAuthorizeDetailUI
 * JD-Core Version:    0.7.0.1
 */