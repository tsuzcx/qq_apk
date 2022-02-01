package com.tencent.luggage.wxaapi.internal.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class WxaScanResultDelegateActivity$b
  implements LuggageActivityHelper.ActivityResultCallback
{
  WxaScanResultDelegateActivity$b(WxaScanResultDelegateActivity paramWxaScanResultDelegateActivity, ResultReceiver paramResultReceiver) {}
  
  public final void onResult(int paramInt, Intent paramIntent)
  {
    ResultReceiver localResultReceiver = this.b;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_EXTRA_ACTIVITY_RESULT_DATA", (Parcelable)paramIntent);
    localResultReceiver.send(paramInt, localBundle);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.internal.ui.WxaScanResultDelegateActivity.b
 * JD-Core Version:    0.7.0.1
 */