package com.tencent.luggage.wxaapi.internal.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.scanner.scanner.ui.BaseScanUI;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/ui/WxaScanResultDelegateActivity$Companion;", "", "()V", "KEY_EXTRA_ACTIVITY_RESULT_DATA", "", "KEY_EXTRA_RESULT_RECEIVER", "getIntentForScanUI", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "waitForScanResult", "", "callback", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class WxaScanResultDelegateActivity$a
{
  private final Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, BaseScanUI.class);
    paramContext.putExtra("key_only_from_camera", true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.internal.ui.WxaScanResultDelegateActivity.a
 * JD-Core Version:    0.7.0.1
 */