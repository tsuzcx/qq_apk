package com.tencent.luggage.wxaapi.internal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/ui/WxaScanResultDelegateActivity;", "Landroid/app/Activity;", "Lcom/tencent/luggage/util/LuggageActivityHelper$ILuggageActivityHelper;", "()V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "ScanResultModel", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class WxaScanResultDelegateActivity
  extends Activity
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  public static final WxaScanResultDelegateActivity.a a = new WxaScanResultDelegateActivity.a(null);
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    LuggageActivityHelper.FOR((Context)this).onActivityResult(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    setTheme(2131952731);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = (ResultReceiver)paramBundle.getParcelableExtra("KEY_EXTRA_RESULT_RECEIVER");
      if (paramBundle != null)
      {
        Context localContext = (Context)this;
        LuggageActivityHelper.FOR(localContext).startActivityForResult(WxaScanResultDelegateActivity.a.a(a, localContext), (LuggageActivityHelper.ActivityResultCallback)new WxaScanResultDelegateActivity.b(this, paramBundle));
        return;
      }
    }
    ((WxaScanResultDelegateActivity)this).finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LuggageActivityHelper.REMOVE((Context)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.internal.ui.WxaScanResultDelegateActivity
 * JD-Core Version:    0.7.0.1
 */