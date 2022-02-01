package com.tencent.luggage.wxa.np;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.k;

class f$1
  implements AppBrandSimpleImageLoader.k
{
  f$1(f paramf, a.b paramb) {}
  
  @NonNull
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaIcon");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.a == null) {
      return;
    }
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.a.a(paramBitmap);
      return;
    }
    this.a.a(null);
  }
  
  public void b() {}
  
  public void c()
  {
    a.b localb = this.a;
    if (localb == null) {
      return;
    }
    localb.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.np.f.1
 * JD-Core Version:    0.7.0.1
 */