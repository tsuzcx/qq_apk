package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.luggage.wxa.dc.h.a;
import com.tencent.mm.ui.a;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaAlertActivity;", "Landroid/app/Activity;", "()V", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaAlertActivity
  extends Activity
{
  public static final WxaAlertActivity.a a = new WxaAlertActivity.a(null);
  
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
    if (!isDestroyed())
    {
      if (isFinishing()) {
        return;
      }
      super.finish();
      overridePendingTransition(0, 0);
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
    setTheme(2131952522);
    super.onCreate(paramBundle);
    localContext = null;
    try
    {
      Intent localIntent = getIntent();
      paramBundle = localContext;
      if (localIntent != null) {
        paramBundle = (h.a)localIntent.getParcelableExtra("KEY_ALERT_PARCEL");
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle = localContext;
      }
    }
    if ((paramBundle != null) && (paramBundle.a()))
    {
      localContext = (Context)this;
      a.d(localContext);
      overridePendingTransition(0, 0);
      new MMAlertDialog.Builder(localContext).setTitle(paramBundle.b()).setMsg(paramBundle.c()).setCancelable(false).setPositiveBtnText(2131886911).setPositiveBtnListener((DialogInterface.OnClickListener)new WxaAlertActivity.b(this)).setOnDismissListener((DialogInterface.OnDismissListener)new WxaAlertActivity.c(this)).show();
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaAlertActivity
 * JD-Core Version:    0.7.0.1
 */