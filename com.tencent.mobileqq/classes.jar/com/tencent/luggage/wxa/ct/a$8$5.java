package com.tencent.luggage.wxa.ct;

import android.content.Intent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultInterceptCallback;
import java.util.Map;

class a$8$5
  implements LuggageActivityHelper.ActivityResultInterceptCallback
{
  a$8$5(a.8 param8) {}
  
  public boolean onResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ValueCallback localValueCallback = (ValueCallback)a.i(this.a.a).get(Integer.valueOf(paramInt1));
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(paramInt2, paramIntent));
      a.i(this.a.a).remove(Integer.valueOf(paramInt1));
      if (a.i(this.a.a).isEmpty()) {
        a.a(this.a.a, null);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.8.5
 * JD-Core Version:    0.7.0.1
 */