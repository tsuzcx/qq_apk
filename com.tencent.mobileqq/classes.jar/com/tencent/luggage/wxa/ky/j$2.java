package com.tencent.luggage.wxa.ky;

import android.os.Bundle;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.pd.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class j$2
  implements b.a
{
  j$2(j paramj, b paramb, String paramString) {}
  
  public void a(String paramString)
  {
    if (!af.c(paramString))
    {
      paramString = i.a(paramString, false);
      o.d("MicroMsg.JsApiUpdateLivePusher", "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("filterImage", paramString);
      this.a.b(localBundle);
      return;
    }
    o.d("MicroMsg.JsApiUpdateLivePusher", "convertFilterImageToLocalPath, load background image fail");
    paramString = new HashMap();
    paramString.put("url", this.b);
    this.a.a(10005, "load filter image fail", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.j.2
 * JD-Core Version:    0.7.0.1
 */