package com.tencent.luggage.wxa.ky;

import android.os.Bundle;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.pd.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class j$1
  implements b.a
{
  j$1(j paramj, b paramb, String paramString) {}
  
  public void a(String paramString)
  {
    if (!af.c(paramString))
    {
      paramString = i.a(paramString, false);
      o.d("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("backgroundImage", paramString);
      this.a.b(localBundle);
      return;
    }
    o.d("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
    paramString = new HashMap();
    paramString.put("url", this.b);
    this.a.a(10004, "load background image fail", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.j.1
 * JD-Core Version:    0.7.0.1
 */