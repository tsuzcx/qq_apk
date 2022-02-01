package com.tencent.luggage.wxa.kz;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.o;

final class d$a
  implements d.b
{
  public com.tencent.luggage.wxa.rr.a a(d paramd, String paramString)
  {
    paramd = paramd.z().g(paramString);
    if (paramd == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramd.l(), localOptions);
    paramString = new d.c(null);
    paramString.a = localOptions.outWidth;
    paramString.b = localOptions.outHeight;
    paramString.d = com.tencent.luggage.wxa.bx.a.b(localOptions);
    if (com.tencent.luggage.wxa.bx.a.a(localOptions)) {
      paramd = com.tencent.luggage.wxa.bx.a.a(com.tencent.luggage.wxa.bx.a.a(paramd.l()));
    } else {
      paramd = "up";
    }
    paramString.c = paramd;
    return com.tencent.luggage.wxa.rr.a.a(d.e.c, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.d.a
 * JD-Core Version:    0.7.0.1
 */