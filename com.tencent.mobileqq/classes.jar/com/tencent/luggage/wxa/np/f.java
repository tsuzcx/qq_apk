package com.tencent.luggage.wxa.np;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.bd.c;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.luggage.wxa.jl.a.c;
import com.tencent.luggage.wxa.no.a;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import java.util.Map;

public class f
  extends c
{
  public Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    if (!a(paramString)) {
      return null;
    }
    if (paramRect != null) {
      paramRect = new a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    } else {
      paramRect = null;
    }
    Bitmap localBitmap = AppBrandSimpleImageLoader.instance().findCachedLocal(paramString, paramRect);
    if (localBitmap == null) {
      AppBrandSimpleImageLoader.instance().load(new f.1(this, paramb), paramString, null, paramRect);
    }
    return localBitmap;
  }
  
  public void a(String paramString, @Nullable Map<String, String> paramMap, a.c paramc)
  {
    AppBrandSimpleImageLoader.instance().loadIntoDiskCache(paramString, paramMap, new f.2(this, paramc));
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = paramString.toLowerCase();
      if (!paramString.startsWith("http://"))
      {
        bool1 = bool2;
        if (!paramString.startsWith("https://")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.np.f
 * JD-Core Version:    0.7.0.1
 */