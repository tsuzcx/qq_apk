package com.tencent.luggage.util;

import android.content.Intent;

class LuggageActivityHelper$1
  implements LuggageActivityHelper.ActivityResultInterceptCallback
{
  LuggageActivityHelper$1(LuggageActivityHelper paramLuggageActivityHelper, LuggageActivityHelper.ActivityResultInterceptCallback paramActivityResultInterceptCallback) {}
  
  public boolean onResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.removeInterceptActivityResultCallback(this);
    return this.a.onResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper.1
 * JD-Core Version:    0.7.0.1
 */