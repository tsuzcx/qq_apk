package com.tencent.luggage.jsapi.file;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.jx.c;

class a$1
  implements LuggageActivityHelper.ActivityResultCallback
{
  a$1(a parama, c paramc, int paramInt) {}
  
  public void onResult(int paramInt, Intent paramIntent)
  {
    c localc = this.a;
    int i = this.b;
    a locala;
    if (paramInt == 0)
    {
      locala = this.c;
      paramIntent = "ok";
    }
    else
    {
      locala = this.c;
      paramIntent = "fail:internal error";
    }
    localc.a(i, locala.b(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.jsapi.file.a.1
 * JD-Core Version:    0.7.0.1
 */