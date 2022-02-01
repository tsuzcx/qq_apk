package com.tencent.luggage.wxa.ev;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.luggage.wxa.qz.w;
import com.tencent.xweb.ISharedPreferenceProvider;

final class b$3
  implements ISharedPreferenceProvider
{
  public SharedPreferences a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    paramContext = w.a(paramString, paramInt);
    if (paramContext == null) {
      return null;
    }
    return new d(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ev.b.3
 * JD-Core Version:    0.7.0.1
 */