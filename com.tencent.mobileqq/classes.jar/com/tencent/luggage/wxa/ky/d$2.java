package com.tencent.luggage.wxa.ky;

import android.os.Bundle;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.pd.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class d$2
  implements b.a
{
  d$2(d paramd, b paramb, String paramString) {}
  
  public void a(String paramString)
  {
    if (!af.c(paramString))
    {
      paramString = i.a(paramString, false);
      o.d("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("backgroundImage", paramString);
      this.a.b(localBundle);
      return;
    }
    o.d("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
    paramString = new HashMap();
    paramString.put("url", this.b);
    this.a.a(10004, "load background image fail", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.d.2
 * JD-Core Version:    0.7.0.1
 */