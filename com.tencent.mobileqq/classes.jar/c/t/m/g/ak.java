package c.t.m.g;

import android.os.Build.VERSION;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class ak
{
  URL a;
  String b;
  int c;
  public String d;
  private boolean e;
  private boolean f;
  private int g;
  
  public ak(URL paramURL, String paramString)
  {
    boolean bool2 = false;
    if (x.a.a("direct_access_use_schedule", 0, 1, 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    boolean bool1 = bool2;
    if (x.a.a("direct_https_use_sche", 0, 1, 1) == 1) {
      bool1 = true;
    }
    this.f = bool1;
    this.g = x.a.a("direct_access_domain_try_times", 1, 8, 2);
    this.d = "";
    this.a = paramURL;
    this.b = paramString;
  }
  
  public final List<n> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    n localn = new n(this.a.getHost());
    int k = 3;
    localn.e = 3;
    int j = 0;
    for (;;)
    {
      try
      {
        localObject = new ArrayList();
        if (!paramBoolean1)
        {
          ((List)localObject).add(localn);
          localn.c = 1;
          return localObject;
        }
        if ((x.i()) || (!this.e) || ((paramBoolean2) && (!this.f))) {
          continue;
        }
        if ((paramBoolean2) && (Build.VERSION.SDK_INT <= 18))
        {
          i = 0;
          if (i < this.g)
          {
            ((List)localObject).add(localn);
            i += 1;
            continue;
          }
          localn.c = 10;
          return localObject;
        }
        localObject = ai.a(this.a.getHost());
        List localList = ((v)localObject).c;
        this.c = ((v)localObject).d;
        this.d = ((v)localObject).b;
        return localList;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
        int i = 0;
        continue;
        i = 4;
        continue;
      }
      if (i >= this.g) {
        continue;
      }
      ((List)localObject).add(localn);
      i += 1;
    }
    if (x.i())
    {
      i = 2;
    }
    else
    {
      if (this.e) {
        break label291;
      }
      i = k;
    }
    localn.c = i;
    return localObject;
    localObject = new ArrayList();
    i = j;
    while (i < this.g)
    {
      ((List)localObject).add(localn);
      i += 1;
    }
    localn.c = 8;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ak
 * JD-Core Version:    0.7.0.1
 */