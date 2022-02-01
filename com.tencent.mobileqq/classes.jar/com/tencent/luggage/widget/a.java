package com.tencent.luggage.widget;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a
{
  private final Uri a;
  private final Bitmap b;
  private final Integer c;
  private boolean d;
  private int e;
  private int f;
  private Rect g;
  private boolean h;
  
  private a(@NonNull Uri paramUri)
  {
    String str = paramUri.toString();
    Uri localUri1 = paramUri;
    if (str.startsWith("file:///"))
    {
      localUri1 = paramUri;
      if (new File(str.substring(7)).exists()) {}
    }
    try
    {
      localUri1 = Uri.parse(URLDecoder.decode(str, "UTF-8"));
      this.b = null;
      this.a = localUri1;
      this.c = null;
      this.d = true;
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Uri localUri2 = paramUri;
      }
    }
  }
  
  @NonNull
  public static a a(@NonNull String paramString)
  {
    if (paramString != null)
    {
      String str = paramString;
      if (!paramString.contains("://"))
      {
        str = paramString;
        if (paramString.startsWith("/")) {
          str = paramString.substring(1);
        }
        paramString = new StringBuilder();
        paramString.append("file:///");
        paramString.append(str);
        str = paramString.toString();
      }
      return new a(Uri.parse(str));
    }
    throw new NullPointerException("Uri must not be null");
  }
  
  protected final Uri a()
  {
    return this.a;
  }
  
  protected final Bitmap b()
  {
    return this.b;
  }
  
  protected final Integer c()
  {
    return this.c;
  }
  
  protected final boolean d()
  {
    return this.d;
  }
  
  protected final int e()
  {
    return this.e;
  }
  
  protected final int f()
  {
    return this.f;
  }
  
  protected final Rect g()
  {
    return this.g;
  }
  
  protected final boolean h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.a
 * JD-Core Version:    0.7.0.1
 */