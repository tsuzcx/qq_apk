package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class i$c
  implements LuggageActivityHelper.ActivityResultCallback
{
  i$c(Function2 paramFunction2) {}
  
  public final void onResult(int paramInt, Intent paramIntent)
  {
    this.a.invoke(Integer.valueOf(paramInt), paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i.c
 * JD-Core Version:    0.7.0.1
 */