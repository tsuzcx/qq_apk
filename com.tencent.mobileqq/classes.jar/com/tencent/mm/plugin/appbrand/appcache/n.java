package com.tencent.mm.plugin.appbrand.appcache;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.apache.commons.lang.ArrayUtils;

public final class n
{
  private static String[] d = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String a;
  private final String b;
  private volatile String c;
  
  public n(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = a(paramString2);
  }
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 6)
      {
        if (paramInt != 12)
        {
          StringBuilder localStringBuilder;
          if (paramInt != 13)
          {
            if (paramInt != 22)
            {
              if (paramInt != 23)
              {
                this.b = a(paramString2);
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(a(paramString2));
                localStringBuilder.append('$');
                localStringBuilder.append("__WITHOUT_MULTI_PLUGINCODE__");
                this.b = localStringBuilder.toString();
              }
            }
            else {
              this.b = "__WITHOUT_MULTI_PLUGINCODE__";
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(a(paramString2));
            localStringBuilder.append('$');
            localStringBuilder.append("__WITHOUT_PLUGINCODE__");
            this.b = localStringBuilder.toString();
          }
        }
        else
        {
          this.b = "__WITHOUT_PLUGINCODE__";
        }
      }
      else {
        this.b = "__PLUGINCODE__";
      }
    }
    else {
      this.b = "";
    }
    this.a = paramString1;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (!af.c(paramString))
    {
      if (ArrayUtils.contains(d, paramString)) {
        return paramString;
      }
      str = b(paramString);
    }
    return str;
  }
  
  private static String b(String paramString)
  {
    int i = 0;
    o.e("Luggage.WXA.PkgQueryKey", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[] { paramString });
    if (af.c(paramString)) {
      return "";
    }
    paramString = paramString.trim();
    if (!paramString.startsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/");
    localStringBuilder.append(paramString.substring(i));
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  @NonNull
  public String toString()
  {
    if (af.c(this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      Object localObject;
      if (af.c(this.b))
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append('$');
        ((StringBuilder)localObject).append(this.b);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      this.c = localStringBuilder.toString();
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n
 * JD-Core Version:    0.7.0.1
 */