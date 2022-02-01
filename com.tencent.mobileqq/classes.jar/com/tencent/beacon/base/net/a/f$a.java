package com.tencent.beacon.base.net.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.HttpMethod;
import java.util.HashMap;
import java.util.Map;

public class f$a
{
  private HttpMethod a;
  private String b;
  private String c;
  private Map<String, String> d = new HashMap(3);
  private Map<String, String> e = new HashMap(3);
  private String f;
  private BodyType g;
  private byte[] h;
  
  private void a(BodyType paramBodyType)
  {
    if (this.g == null) {
      this.g = paramBodyType;
    }
    if (this.g == paramBodyType) {
      return;
    }
    throw new IllegalStateException("bodyType already set!");
  }
  
  public a a(HttpMethod paramHttpMethod)
  {
    this.a = paramHttpMethod;
    return this;
  }
  
  public a a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public a a(@NonNull Map<String, String> paramMap)
  {
    a(BodyType.FORM);
    this.d.putAll(paramMap);
    return this;
  }
  
  public f a()
  {
    if (this.a != null)
    {
      if (!TextUtils.isEmpty(this.b))
      {
        BodyType localBodyType = this.g;
        if (localBodyType != null)
        {
          int i = e.a[localBodyType.ordinal()];
          if (i != 1)
          {
            if (i != 2)
            {
              if ((i == 3) && (this.h == null)) {
                throw new NullPointerException("data request body == null");
              }
            }
            else if (this.d.isEmpty()) {
              throw new NullPointerException("form request body == null");
            }
          }
          else {
            if (TextUtils.isEmpty(this.f)) {
              break label149;
            }
          }
          return new f(this.a, this.b, this.e, this.g, this.f, this.d, this.h, this.c, null);
          label149:
          throw new NullPointerException("json request body == null");
        }
        throw new NullPointerException("bodyType == null");
      }
      throw new NullPointerException("request url == null!");
    }
    throw new NullPointerException("request method == null");
  }
  
  public a b(@NonNull String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.f.a
 * JD-Core Version:    0.7.0.1
 */