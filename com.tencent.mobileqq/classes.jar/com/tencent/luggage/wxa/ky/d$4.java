package com.tencent.luggage.wxa.ky;

import android.os.Bundle;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.pd.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class d$4
  implements b.a
{
  d$4(d paramd, b paramb) {}
  
  public void a(String paramString)
  {
    if (!af.c(paramString))
    {
      paramString = i.a(paramString, false);
      o.d("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("watermarkImage", paramString);
      this.a.b(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.d.4
 * JD-Core Version:    0.7.0.1
 */