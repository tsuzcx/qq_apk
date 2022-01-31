package com.tencent.map.sdk.a;

import android.os.Build.VERSION;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class bd
{
  URL a;
  String b;
  int c;
  public String d;
  private boolean e;
  private boolean f;
  private int g;
  
  public bd(URL paramURL, String paramString)
  {
    if (as.a("direct_access_use_schedule", 0, 1, 1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.e = bool1;
      bool1 = bool2;
      if (as.a("direct_https_use_sche", 0, 1, 1) == 1) {
        bool1 = true;
      }
      this.f = bool1;
      this.g = as.a("direct_access_domain_try_times", 1, 8, 2);
      this.d = "";
      this.a = paramURL;
      this.b = paramString;
      return;
    }
  }
  
  public final List<ad> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 3;
    int j = 0;
    ad localad = new ad(this.a.getHost());
    localad.e = 3;
    for (;;)
    {
      try
      {
        Object localObject = new ArrayList();
        if (!paramBoolean1)
        {
          ((List)localObject).add(localad);
          localad.c = 1;
          return localObject;
        }
        if ((!ao.j()) && (this.e)) {
          if ((paramBoolean2) && (!this.f))
          {
            break label282;
            if (i < this.g)
            {
              ((List)localObject).add(localad);
              i += 1;
              continue;
            }
            if (ao.j())
            {
              i = 2;
              localad.c = i;
              return localObject;
            }
            i = k;
            if (!this.e) {
              continue;
            }
            i = 4;
            continue;
          }
          else
          {
            if ((paramBoolean2) && (Build.VERSION.SDK_INT <= 18))
            {
              i = 0;
              if (i < this.g)
              {
                ((List)localObject).add(localad);
                i += 1;
                continue;
              }
              localad.c = 10;
              return localObject;
            }
            localObject = bb.a(this.a.getHost());
            List localList = ((al)localObject).c;
            this.c = ((al)localObject).d;
            this.d = ((al)localObject).b;
            return localList;
          }
        }
      }
      catch (Exception localException)
      {
        ArrayList localArrayList = new ArrayList();
        i = j;
        if (i < this.g)
        {
          localArrayList.add(localad);
          i += 1;
          continue;
        }
        localad.c = 8;
        return localArrayList;
      }
      label282:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bd
 * JD-Core Version:    0.7.0.1
 */