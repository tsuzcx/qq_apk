package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.util.TXCCommonUtil;

public class g
{
  private final int a = 5;
  private final int b = 2;
  private String c = "";
  private String d = "";
  private int e = 0;
  private String f = "";
  private Handler g;
  
  public g(Context paramContext)
  {
    if (paramContext != null) {
      this.g = new Handler(paramContext.getMainLooper());
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0))
    {
      paramString1 = paramString1.toLowerCase();
      paramString2 = paramString2.split("[?&]");
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramString2[i];
        if (localObject1.indexOf("=") != -1)
        {
          Object localObject2 = localObject1.split("[=]");
          if (localObject2.length == 2)
          {
            localObject1 = localObject2[0];
            localObject2 = localObject2[1];
            if ((localObject1 != null) && (localObject1.toLowerCase().equalsIgnoreCase(paramString1))) {
              return localObject2;
            }
          }
        }
        i += 1;
      }
      return "";
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, g.a parama)
  {
    new g.2(this, "getRTMPAccUrl", paramString2, paramString4, paramString3, paramString1, paramInt, parama).start();
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean) {
      return (paramString1 != null) && (!paramString1.isEmpty()) && (paramString2 != null) && (!paramString2.isEmpty()) && (paramString3 != null) && (!paramString3.isEmpty());
    }
    return (paramString1 != null) && (paramString2 != null) && (paramString3 != null);
  }
  
  private long e()
  {
    return c.a().a("Network", "AccRetryCountWithoutSecret");
  }
  
  public int a(String paramString, int paramInt, g.a parama)
  {
    this.c = "";
    this.d = "";
    this.e = 0;
    this.f = "";
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String str1 = TXCCommonUtil.getStreamIDByStreamUrl(paramString);
      if ((str1 != null) && (!str1.isEmpty()))
      {
        String str2 = a("bizid", paramString);
        String str3 = a("txSecret", paramString);
        paramString = a("txTime", paramString);
        boolean bool;
        if (e() <= 0L) {
          bool = true;
        } else {
          bool = false;
        }
        if (!a(bool, str2, paramString, str3)) {
          return -3;
        }
        a(str1, str2, str3, paramString, paramInt, new g.1(this, str1, str2, str3, paramString, parama));
        return 0;
      }
      return -2;
    }
    return -1;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.g
 * JD-Core Version:    0.7.0.1
 */