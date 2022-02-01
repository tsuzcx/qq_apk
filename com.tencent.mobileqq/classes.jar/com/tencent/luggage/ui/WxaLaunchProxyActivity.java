package com.tencent.luggage.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.luggage.wxa.cx.q;
import com.tencent.luggage.wxa.da.g;
import com.tencent.luggage.wxa.ew.b;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaLaunchProxyActivity;", "Lcom/tencent/mm/ui/base/BaseLuggageFullScreenActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaLaunchProxyActivity
  extends com.tencent.mm.ui.base.d
{
  public static final WxaLaunchProxyActivity.a a = new WxaLaunchProxyActivity.a(null);
  @NotNull
  private static final String b = "key_action";
  @NotNull
  private static final String c = "key_stat_object";
  @NotNull
  private static final String d = "key_referrer";
  
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
  
  @TargetApi(5)
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b localb = new b();
    paramBundle = getIntent();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "intent");
    g.b(localb, paramBundle, b);
    boolean bool = getIntent().hasExtra(c);
    j localj = null;
    if (bool) {
      paramBundle = (com.tencent.luggage.wxa.ou.d)getIntent().getParcelableExtra(c);
    } else {
      paramBundle = null;
    }
    if (getIntent().hasExtra(d)) {
      localj = (j)getIntent().getParcelableExtra(d);
    }
    q.a((Context)this, localb, paramBundle, localj);
  }
  
  protected void onDestroy()
  {
    super.overridePendingTransition(0, 0);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    overridePendingTransition(0, 0);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaLaunchProxyActivity
 * JD-Core Version:    0.7.0.1
 */