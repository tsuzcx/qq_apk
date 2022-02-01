package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl
  implements Key
{
  private final Headers b;
  @Nullable
  private final URL c;
  @Nullable
  private final String d;
  @Nullable
  private String e;
  @Nullable
  private URL f;
  @Nullable
  private volatile byte[] g;
  private int h;
  
  public GlideUrl(String paramString)
  {
    this(paramString, Headers.b);
  }
  
  public GlideUrl(String paramString, Headers paramHeaders)
  {
    this.c = null;
    this.d = Preconditions.a(paramString);
    this.b = ((Headers)Preconditions.a(paramHeaders));
  }
  
  public GlideUrl(URL paramURL)
  {
    this(paramURL, Headers.b);
  }
  
  public GlideUrl(URL paramURL, Headers paramHeaders)
  {
    this.c = ((URL)Preconditions.a(paramURL));
    this.d = null;
    this.b = ((Headers)Preconditions.a(paramHeaders));
  }
  
  private URL d()
  {
    if (this.f == null) {
      this.f = new URL(e());
    }
    return this.f;
  }
  
  private String e()
  {
    if (TextUtils.isEmpty(this.e))
    {
      String str2 = this.d;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = ((URL)Preconditions.a(this.c)).toString();
      }
      this.e = Uri.encode(str1, "@#&=*+-_.,:!?()/~'%;$");
    }
    return this.e;
  }
  
  private byte[] f()
  {
    if (this.g == null) {
      this.g = c().getBytes(a);
    }
    return this.g;
  }
  
  public URL a()
  {
    return d();
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(f());
  }
  
  public Map<String, String> b()
  {
    return this.b.a();
  }
  
  public String c()
  {
    String str = this.d;
    if (str != null) {
      return str;
    }
    return ((URL)Preconditions.a(this.c)).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof GlideUrl;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (GlideUrl)paramObject;
      bool1 = bool2;
      if (c().equals(paramObject.c()))
      {
        bool1 = bool2;
        if (this.b.equals(paramObject.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    if (this.h == 0)
    {
      this.h = c().hashCode();
      this.h = (this.h * 31 + this.b.hashCode());
    }
    return this.h;
  }
  
  public String toString()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.GlideUrl
 * JD-Core Version:    0.7.0.1
 */