package com.tencent.luggage.util;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/PresentationActivityHelper;", "Lcom/tencent/luggage/util/LuggageActivityHelper;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "cleanUp", "", "cleanUpWhenDismissed", "startActivityForResult", "intent", "Landroid/content/Intent;", "cb", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;", "startActivityForResultThrows", "Companion", "IPC_LuggageActivityHelpInvoker", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
@Keep
public final class PresentationActivityHelper
  extends LuggageActivityHelper
{
  public static final PresentationActivityHelper.a Companion = new PresentationActivityHelper.a(null);
  private static final String TAG = "WMPF.WMPFActivityHelper";
  
  public PresentationActivityHelper(@Nullable Activity paramActivity)
  {
    super(paramActivity);
  }
  
  @JvmStatic
  public static final void setResult(int paramInt, @NotNull Intent paramIntent1, @Nullable Intent paramIntent2)
  {
    Companion.a(paramInt, paramIntent1, paramIntent2);
  }
  
  protected void cleanUp() {}
  
  public final void cleanUpWhenDismissed()
  {
    super.cleanUp();
  }
  
  public void startActivityForResult(@Nullable Intent paramIntent, @Nullable LuggageActivityHelper.ActivityResultCallback paramActivityResultCallback)
  {
    if (this.mActivity == null) {
      return;
    }
    int j = genRandomCodeFor(this.mActivityResultCallbacks);
    this.mActivityResultCallbacks.put(j, paramActivityResultCallback);
    if (paramIntent == null) {
      Intrinsics.throwNpe();
    }
    paramIntent.putExtra("Luggage.LuggageActivityHelperproc_name", r.c());
    paramActivityResultCallback = this.mActivity;
    int i;
    if (paramActivityResultCallback != null) {
      i = paramActivityResultCallback.hashCode();
    } else {
      i = 0;
    }
    paramIntent.putExtra("Luggage.LuggageActivityHelperinstance_id", i);
    paramIntent.putExtra("Luggage.LuggageActivityHelperreq_code", j);
    paramActivityResultCallback = this.mActivity;
    if (paramActivityResultCallback == null) {
      Intrinsics.throwNpe();
    }
    paramActivityResultCallback.startActivity(paramIntent);
  }
  
  public void startActivityForResultThrows(@Nullable Intent paramIntent, @Nullable LuggageActivityHelper.ActivityResultCallback paramActivityResultCallback)
  {
    startActivityForResult(paramIntent, paramActivityResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.PresentationActivityHelper
 * JD-Core Version:    0.7.0.1
 */