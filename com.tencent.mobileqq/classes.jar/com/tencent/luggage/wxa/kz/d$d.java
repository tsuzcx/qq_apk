package com.tencent.luggage.wxa.kz;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import java.io.IOException;
import java.io.InputStream;

final class d$d
  implements d.b
{
  public com.tencent.luggage.wxa.rr.a a(d paramd, String paramString)
  {
    paramString = ad.c(paramd, paramString);
    d.c localc;
    boolean bool;
    if (paramString != null)
    {
      paramString.mark(0);
      paramd = new BitmapFactory.Options();
      paramd.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramString, new Rect(), paramd);
      localc = new d.c(null);
      localc.a = paramd.outWidth;
      localc.b = paramd.outHeight;
      localc.d = com.tencent.luggage.wxa.bx.a.b(paramd);
      bool = com.tencent.luggage.wxa.bx.a.a(paramd);
    }
    try
    {
      paramString.reset();
      label87:
      if (bool) {
        paramd = com.tencent.luggage.wxa.bx.a.a(com.tencent.luggage.wxa.bx.a.a(paramString));
      } else {
        paramd = "up";
      }
      localc.c = paramd;
      af.a(paramString);
      return com.tencent.luggage.wxa.rr.a.a(d.e.c, localc);
      return com.tencent.luggage.wxa.rr.a.a(d.e.a);
    }
    catch (IOException paramd)
    {
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.d.d
 * JD-Core Version:    0.7.0.1
 */