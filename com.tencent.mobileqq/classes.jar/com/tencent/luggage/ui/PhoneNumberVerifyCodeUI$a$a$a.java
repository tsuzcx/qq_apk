package com.tencent.luggage.ui;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class PhoneNumberVerifyCodeUI$a$a$a
  implements LuggageActivityHelper.ActivityResultCallback
{
  PhoneNumberVerifyCodeUI$a$a$a(Function2 paramFunction2) {}
  
  public final void onResult(int paramInt, Intent paramIntent)
  {
    Map localMap;
    if (paramInt == -1)
    {
      localHashMap = new HashMap();
      localMap = (Map)localHashMap;
      localMap.put("errMsg", "ok");
      if (paramIntent == null) {
        Intrinsics.throwNpe();
      }
      String str = paramIntent.getStringExtra("encryptedData");
      Intrinsics.checkExpressionValueIsNotNull(str, "data!!.getStringExtra(Constants.ENCRYPTEDDATA)");
      localMap.put("encryptedData", str);
      paramIntent = paramIntent.getStringExtra("iv");
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "data.getStringExtra(Constants.IV)");
      localMap.put("iv", paramIntent);
      this.a.invoke(Boolean.valueOf(true), localHashMap);
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramIntent == null)
    {
      localMap = (Map)localHashMap;
      Intrinsics.throwNpe();
      paramIntent = paramIntent.getStringExtra("errMsg");
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "data!!.getStringExtra(Constants.ERRMSG)");
      localMap.put("errMsg", paramIntent);
    }
    else
    {
      ((Map)localHashMap).put("errMsg", "fail:data is null");
    }
    this.a.invoke(Boolean.valueOf(false), localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.a.a.a
 * JD-Core Version:    0.7.0.1
 */