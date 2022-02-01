package com.tencent.luggage.wxa.d;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.c.b;
import java.io.IOException;
import java.io.InputStream;

public class a
  implements d
{
  public static final String a = "assets://";
  private static final String b = "AssetsImageStreamFetcher";
  private Context c;
  
  public a(@NonNull Context paramContext)
  {
    this.c = paramContext;
  }
  
  private InputStream a(@NonNull Context paramContext, @NonNull String paramString)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      b.a("AssetsImageStreamFetcher", paramContext, "encountered exception!", new Object[0]);
    }
    return null;
  }
  
  public d.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    return new d.a(a(this.c, ((String)paramObject).substring(9)));
  }
  
  public String a()
  {
    return "assets";
  }
  
  public boolean a(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return false;
    }
    return ((String)paramObject).startsWith("assets://");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.d.a
 * JD-Core Version:    0.7.0.1
 */