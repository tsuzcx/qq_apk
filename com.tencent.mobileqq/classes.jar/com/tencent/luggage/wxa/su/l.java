package com.tencent.luggage.wxa.su;

import android.os.AsyncTask;
import com.tencent.xweb.internal.c;
import com.tencent.xweb.xwalk.updater.j.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask;
import org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask;

public class l
  extends AsyncTask<String, Integer, Integer>
{
  private final Object a = new Object();
  private l.a b = new l.a();
  private Map<String, l.b> c = new HashMap();
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private boolean i = false;
  private String j = "";
  private j k = null;
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("change status from ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" to ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" errcode: ");
    localStringBuilder.append(paramInt3);
    Log.i("XWalkPluginUp", localStringBuilder.toString());
    if (b()) {
      if ((paramInt1 == 0) && (paramInt2 == 1)) {
        this.k.a();
      } else if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.k.b(paramInt3);
      }
    }
    if (paramInt2 == 5)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.b);
      localStringBuilder.append(",");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",");
      localStringBuilder.append(this.f);
      localStringBuilder.append(",");
      localStringBuilder.append(this.g);
      localStringBuilder.append(",");
      localStringBuilder.append(this.h);
      com.tencent.xweb.util.h.a(15718, localStringBuilder.toString());
      k.g();
      this.i = true;
    }
  }
  
  private boolean a(int paramInt)
  {
    return a(paramInt, 1, null);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, null);
  }
  
  private boolean a(int paramInt1, int paramInt2, Map<String, l.b> paramMap)
  {
    synchronized (this.a)
    {
      int m = this.b.a;
      boolean bool = false;
      if (paramInt1 > m)
      {
        this.b.a = paramInt1;
        if (paramInt2 != 1) {
          this.b.b = paramInt2;
        }
        Object localObject2;
        if (this.b.a == 4)
        {
          if (this.c.size() == 0)
          {
            this.b.a = 5;
          }
          else
          {
            paramMap = this.c.entrySet().iterator();
            while (paramMap.hasNext())
            {
              localObject2 = (l.b)((Map.Entry)paramMap.next()).getValue();
              if ((localObject2 != null) && (!((l.b)localObject2).c)) {
                ((l.b)localObject2).a.cancel(true);
              }
            }
          }
        }
        else if ((this.b.a == 3) && (paramMap != null))
        {
          paramMap = paramMap.entrySet().iterator();
          while (paramMap.hasNext())
          {
            Object localObject3 = (Map.Entry)paramMap.next();
            localObject2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (l.b)((Map.Entry)localObject3).getValue();
            this.c.put(localObject2, localObject3);
            if (((l.b)localObject3).b == 1) {
              ((XWalkLibraryLoader.HttpDownloadTask)((l.b)localObject3).a).execute(new Void[0]);
            } else if (((l.b)localObject3).b == 2) {
              ((XWalkLibraryLoader.WXFileDownloaderTask)((l.b)localObject3).a).execute(new Void[0]);
            } else {
              this.c.remove(localObject2);
            }
          }
          this.d = this.c.size();
        }
      }
      paramInt1 = this.b.a;
      paramInt2 = this.b.b;
      a(m, paramInt1, paramInt2);
      if (paramInt1 > m) {
        bool = true;
      }
      return bool;
    }
    for (;;)
    {
      throw paramMap;
    }
  }
  
  private boolean a(int paramInt, Map<String, l.b> paramMap)
  {
    return a(paramInt, 1, paramMap);
  }
  
  private boolean b()
  {
    String str = this.j;
    return (str != null) && (!str.isEmpty()) && (this.k != null);
  }
  
  private void c()
  {
    if (!a(2))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "status change to fetch config failed");
      return;
    }
    j.a locala = new j.a();
    locala.a = XWalkEnvironment.getPluginConfigUrl();
    locala.b = XWalkEnvironment.getPluginUpdateConfigFilePath();
    locala.c = true;
    com.tencent.xweb.xwalk.updater.j.a(locala, new l.1(this));
  }
  
  protected Integer a(String... paramVarArgs)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "network not available");
      return Integer.valueOf(-2);
    }
    if (!k.c())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "too close, no need to fetch");
      return Integer.valueOf(-3);
    }
    if (k.e())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "is updating by others, return");
      return Integer.valueOf(-4);
    }
    k.f();
    if (c.a("plugin_clear_old_versions", 86400000L))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "try clear old plugin versions");
      h.e();
    }
    else
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no need to clear old plugin versions");
    }
    if (c.a("plugin_check_files", 43200000L))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "try check plugin files");
      h.d();
    }
    else
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no need to check plugin files");
    }
    return Integer.valueOf(0);
  }
  
  public void a()
  {
    a(4, -1);
  }
  
  protected void a(Integer paramInteger)
  {
    if ((paramInteger.intValue() != -2) && (paramInteger.intValue() != -3) && (paramInteger.intValue() != -4)) {
      c();
    } else {
      a(5, paramInteger.intValue());
    }
    super.onPostExecute(paramInteger);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.b.a == 3) && (b()) && (this.j.equals(paramString))) {
      this.k.a(paramInt);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap, String paramString, j paramj)
  {
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        k.a(0L);
      }
    }
    this.j = paramString;
    this.k = paramj;
  }
  
  public void b(String paramString, int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onNotifyResult: ");
    ((StringBuilder)???).append(paramString);
    ((StringBuilder)???).append(" install retCode: ");
    ((StringBuilder)???).append(paramInt);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)???).toString());
    label124:
    int m;
    synchronized (this.a)
    {
      if (this.b.a == 5)
      {
        return;
        this.h += 1;
        break label124;
        this.f += 1;
        break label124;
        this.g += 1;
        break label124;
        this.e += 1;
        ((l.b)this.c.get(paramString)).c = true;
        paramString = this.c.entrySet().iterator();
        l.b localb;
        do
        {
          paramInt = m;
          if (!paramString.hasNext()) {
            break;
          }
          localb = (l.b)((Map.Entry)paramString.next()).getValue();
        } while ((localb == null) || (localb.c));
        paramInt = 0;
        m = this.b.a;
        if (paramInt != 0)
        {
          this.c.clear();
          this.b.a = 5;
          if ((this.f > 0) || (this.g > 0)) {
            this.b.b = -9;
          }
        }
        paramInt = this.b.a;
        int n = this.b.b;
        a(m, paramInt, n);
        return;
      }
    }
  }
  
  protected void onPreExecute()
  {
    a(1);
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.l
 * JD-Core Version:    0.7.0.1
 */