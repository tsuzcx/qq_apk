package com.tencent.luggage.wxa.qa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.sj.g;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import java.io.InputStream;

class i$1
  implements g
{
  i$1(i parami, com.tencent.luggage.wxa.iu.d paramd) {}
  
  public String a()
  {
    return "PackageIconLoader";
  }
  
  public void run()
  {
    InputStream localInputStream = ad.c(this.a, this.b.a);
    Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
    if (localBitmap == null) {
      this.b.c.a("Failed to load icon via package path", this.b);
    } else {
      this.b.a(localBitmap);
    }
    if (localInputStream != null) {
      af.a(localInputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.i.1
 * JD-Core Version:    0.7.0.1
 */