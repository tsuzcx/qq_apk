package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import androidx.core.graphics.BitmapCompat;
import com.tencent.luggage.wxa.gl.b;
import com.tencent.luggage.wxa.gl.d;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.Reference;
import java.lang.ref.Reference<Landroid.graphics.Bitmap;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class AppBrandSimpleImageLoader$d$1
  extends d<String, Reference<Bitmap>>
{
  private final Map<Reference<Bitmap>, Integer> b = new ConcurrentHashMap();
  
  AppBrandSimpleImageLoader$d$1(AppBrandSimpleImageLoader.d paramd, int paramInt)
  {
    super(paramInt);
  }
  
  public int a(String paramString, Reference<Bitmap> paramReference)
  {
    int j = 0;
    if (paramReference == null) {
      return 0;
    }
    paramString = (Integer)this.b.get(paramReference);
    if ((paramString != null) && (paramString.intValue() >= 0)) {
      return paramString.intValue();
    }
    paramString = (Bitmap)paramReference.get();
    int i = j;
    if (paramString != null) {
      if (paramString.isRecycled()) {
        i = j;
      } else {
        i = BitmapCompat.getAllocationByteCount(paramString);
      }
    }
    this.b.put(paramReference, Integer.valueOf(i));
    return i;
  }
  
  public void a(boolean paramBoolean, String paramString, Reference<Bitmap> paramReference1, Reference<Bitmap> paramReference2)
  {
    int i = AppBrandSimpleImageLoader.d.a(this.a).d() / 10;
    int j = AppBrandSimpleImageLoader.d.a(this.a).c() / 10;
    Object localObject2 = "null-ref";
    if (paramReference1 == null) {
      localObject1 = "null-ref";
    } else {
      localObject1 = paramReference1.get();
    }
    if (paramReference2 != null) {
      localObject2 = paramReference2.get();
    }
    o.e("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1, localObject2 });
    super.a(paramBoolean, paramString, paramReference1, paramReference2);
    Object localObject1 = null;
    if (paramReference1 == null) {
      paramString = null;
    } else {
      paramString = (Bitmap)paramReference1.get();
    }
    if (paramReference2 == null) {
      paramReference2 = (Reference<Bitmap>)localObject1;
    } else {
      paramReference2 = (Bitmap)paramReference2.get();
    }
    if (paramString != paramReference2) {
      this.a.a(paramString);
    }
    this.b.remove(paramReference1);
  }
  
  public void b()
  {
    o.e("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
    try
    {
      super.b();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      o.a("LRUMap", localIllegalStateException, "clear", new Object[0]);
    }
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.d.1
 * JD-Core Version:    0.7.0.1
 */