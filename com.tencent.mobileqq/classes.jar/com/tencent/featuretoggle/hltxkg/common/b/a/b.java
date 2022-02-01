package com.tencent.featuretoggle.hltxkg.common.b.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.c.c;
import com.tencent.featuretoggle.hltxkg.common.a.e;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public String a;
  private boolean b;
  private boolean c;
  private int d;
  private URL e;
  private String f;
  private int g;
  
  public b(URL paramURL, String paramString)
  {
    boolean bool2 = false;
    if (i.a("direct_access_use_schedule", 0, 1, 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    boolean bool1 = bool2;
    if (i.a("direct_https_use_sche", 0, 1, 1) == 1) {
      bool1 = true;
    }
    this.c = bool1;
    this.d = i.a("direct_access_domain_try_times", 1, 8, 2);
    this.a = "";
    this.e = paramURL;
    this.f = paramString;
  }
  
  public final String a(com.tencent.featuretoggle.hltxkg.common.a.a parama)
  {
    if (parama.e()) {
      return this.f;
    }
    int i;
    if (!this.e.getProtocol().startsWith("https"))
    {
      localObject = new StringBuilder("http://");
      ((StringBuilder)localObject).append(parama.a());
      ((StringBuilder)localObject).append(":");
      i = parama.c();
      parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
      parama.append(i);
    }
    for (;;)
    {
      localObject = parama.toString();
      break label148;
      if (this.g != 0)
      {
        localObject = new StringBuilder("https://");
        ((StringBuilder)localObject).append(parama.a());
        ((StringBuilder)localObject).append(":");
        i = this.g;
        parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
        break;
      }
      localObject = new StringBuilder("https://");
      ((StringBuilder)localObject).append(parama.a());
      ((StringBuilder)localObject).append(":443");
      parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
    }
    label148:
    String str = this.e.getFile();
    parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
    if (!TextUtils.isEmpty(str)) {
      if (str.startsWith("/"))
      {
        parama = new StringBuilder();
        parama.append((String)localObject);
        parama.append(str);
        parama = parama.toString();
      }
      else
      {
        parama = new StringBuilder();
        parama.append((String)localObject);
        parama.append("/");
        parama.append(str);
        parama = parama.toString();
      }
    }
    str = this.e.getRef();
    Object localObject = parama;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(parama);
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public final List<com.tencent.featuretoggle.hltxkg.common.a.a> a(com.tencent.featuretoggle.hltxkg.common.b.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama = new com.tencent.featuretoggle.hltxkg.common.a.a(this.e.getHost(), -1);
    int k = 3;
    parama.a((byte)3);
    int j = 0;
    for (;;)
    {
      try
      {
        localObject = new ArrayList();
        if (!paramBoolean1)
        {
          ((List)localObject).add(parama);
          parama.a = 1;
          return localObject;
        }
        if ((e.h()) || (!this.b) || ((paramBoolean2) && (!this.c))) {
          continue;
        }
        if ((paramBoolean2) && (Build.VERSION.SDK_INT <= 18))
        {
          i = 0;
          if (i < this.d)
          {
            ((List)localObject).add(parama);
            i += 1;
            continue;
          }
          parama.a = 10;
          return localObject;
        }
        localObject = com.tencent.featuretoggle.hltxkg.common.b.a.a(this.e.getHost());
        List localList = ((c)localObject).c;
        this.g = ((c)localObject).d;
        this.a = ((c)localObject).b;
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
      if (i >= this.d) {
        continue;
      }
      ((List)localObject).add(parama);
      i += 1;
    }
    if (e.h())
    {
      i = 2;
    }
    else
    {
      if (this.b) {
        break label297;
      }
      i = k;
    }
    parama.a = i;
    return localObject;
    localObject = new ArrayList();
    i = j;
    while (i < this.d)
    {
      ((List)localObject).add(parama);
      i += 1;
    }
    parama.a = 8;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b.a.b
 * JD-Core Version:    0.7.0.1
 */