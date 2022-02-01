package com.tencent.luggage.wxa.e;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.luggage.wxa.c.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static final Map<String, c> a = new HashMap(6);
  
  static
  {
    a.put("image/jpeg", c.a);
    a.put("image/gif", c.d);
    a.put("image/png", c.b);
    a.put("image/x-ms-bmp", c.c);
    a.put("image/bmp", c.c);
    a.put("image/webp", c.e);
  }
  
  public static com.github.henryye.nativeiv.bitmap.d a(@NonNull InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    InputStream localInputStream = e.a(paramInputStream);
    e.b(localInputStream);
    BitmapFactory.decodeStream(localInputStream, null, localOptions);
    Object localObject = (c)a.get(localOptions.outMimeType);
    paramInputStream = (InputStream)localObject;
    if (localObject == null) {
      paramInputStream = c.g;
    }
    try
    {
      localInputStream.reset();
    }
    catch (IOException paramInputStream)
    {
      b.a("Ni.FormatUtil", paramInputStream, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
      paramInputStream = c.g;
    }
    localObject = new com.github.henryye.nativeiv.bitmap.d();
    ((com.github.henryye.nativeiv.bitmap.d)localObject).a = paramInputStream;
    ((com.github.henryye.nativeiv.bitmap.d)localObject).c = localOptions.outHeight;
    ((com.github.henryye.nativeiv.bitmap.d)localObject).b = localOptions.outWidth;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.e.d
 * JD-Core Version:    0.7.0.1
 */