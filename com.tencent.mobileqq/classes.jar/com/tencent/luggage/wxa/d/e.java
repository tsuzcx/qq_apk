package com.tencent.luggage.wxa.d;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.c.b;
import java.io.BufferedInputStream;

public class e
  implements d
{
  private static final String a = "URIImageStreamFetcher";
  private Context b;
  
  public e(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  public d.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    try
    {
      paramObject = new BufferedInputStream(this.b.getContentResolver().openInputStream((Uri)paramObject));
    }
    catch (Exception paramObject)
    {
      label25:
      break label25;
    }
    b.d("URIImageStreamFetcher", "can't open uri", new Object[0]);
    paramObject = null;
    return new d.a(paramObject);
  }
  
  public String a()
  {
    return "uri";
  }
  
  public boolean a(Object paramObject)
  {
    return paramObject instanceof Uri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.d.e
 * JD-Core Version:    0.7.0.1
 */