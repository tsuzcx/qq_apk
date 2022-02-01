package com.tencent.luggage.wxa.d;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.ImageDecodeConfig;

public class b
  implements d
{
  public static final String a = "drawable://";
  private static final String b = "DrawableImageStreamFetcher";
  private Context c;
  
  public b(@NonNull Context paramContext)
  {
    this.c = paramContext;
  }
  
  public d.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    int i = Integer.valueOf(((String)paramObject).substring(11)).intValue();
    return new d.a(this.c.getResources().openRawResource(i));
  }
  
  public String a()
  {
    return "drawable";
  }
  
  public boolean a(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return false;
    }
    return ((String)paramObject).startsWith("drawable://");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.d.b
 * JD-Core Version:    0.7.0.1
 */