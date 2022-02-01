package com.tencent.luggage.wxa.ky;

import android.os.Bundle;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.pd.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class d$3
  implements b.a
{
  d$3(d paramd, b paramb, String paramString) {}
  
  public void a(String paramString)
  {
    if (!af.c(paramString))
    {
      paramString = i.a(paramString, false);
      o.d("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("filterImage", paramString);
      this.a.b(localBundle);
      return;
    }
    o.d("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, load filter image fail");
    paramString = new HashMap();
    paramString.put("url", this.b);
    this.a.a(10005, "load filter image fail", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.d.3
 * JD-Core Version:    0.7.0.1
 */