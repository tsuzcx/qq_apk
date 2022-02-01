package com.tencent.luggage.wxa.cq;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import java.io.IOException;

class g$3
  implements com.tencent.luggage.wxa.rl.b<Void, Bitmap>
{
  g$3(g paramg, Uri paramUri, String paramString) {}
  
  public Void a(Bitmap paramBitmap)
  {
    String str = this.a.toString();
    int j = -1;
    int i;
    if (paramBitmap == null) {
      i = -1;
    } else {
      i = paramBitmap.getWidth();
    }
    if (paramBitmap != null) {
      j = paramBitmap.getHeight();
    }
    o.e("Luggage.ShareWithSnapshot", "get screenshot uri %s, w %d h %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
    if (paramBitmap == null) {
      return g;
    }
    try
    {
      com.tencent.luggage.wxa.qz.b.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, this.b, true);
    }
    catch (IOException paramBitmap)
    {
      h.b().a(paramBitmap);
    }
    return g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.g.3
 * JD-Core Version:    0.7.0.1
 */