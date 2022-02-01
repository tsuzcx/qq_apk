package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View.MeasureSpec;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.json.JSONArray;

public final class hv
  implements hx.a
{
  private Context a;
  private lu b;
  private jz c;
  private jj d;
  private kj e;
  private List<AsyncTask> f;
  private hz g;
  
  public hv(ln paramln)
  {
    this.a = paramln.c;
    this.c = paramln.b.k;
    this.b = paramln.d;
    this.d = paramln.e;
    this.e = paramln.b.o;
    this.f = new ArrayList();
    String str3 = "";
    String str4 = "";
    String str2 = str4;
    String str1 = str3;
    if (paramln.b != null)
    {
      str2 = str4;
      str1 = str3;
      if (paramln.b.aG != null)
      {
        str1 = paramln.b.aG.getSubKey();
        str2 = paramln.b.aG.getSubId();
      }
    }
    this.g = new hz(this.a, paramln, str1);
    this.f.add(new hw(this.b.h, this, str1, str2));
    this.f.add(new hx(this.a, this));
  }
  
  public final void a()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((AsyncTask)localIterator.next()).execute(new Object[0]);
    }
  }
  
  public final void a(hv.a parama, TencentMapOptions paramTencentMapOptions)
  {
    lu locallu = this.b;
    if ((paramTencentMapOptions != null) && (paramTencentMapOptions.getExtSurface() != null))
    {
      locallu.f = parama;
      int i = paramTencentMapOptions.getExtSurfaceWidth();
      int j = paramTencentMapOptions.getExtSurfaceHeight();
      locallu.a.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
      locallu.a(i, j);
    }
  }
  
  public final void a(JSONArray paramJSONArray, hh paramhh)
  {
    if (this.d == null) {
      return;
    }
    Object localObject1 = this.d;
    Object localObject2 = ((jj)localObject1).c.a("mapStyleList");
    Object localObject3;
    if (paramJSONArray != null)
    {
      localObject3 = jj.a(paramJSONArray);
      if (localObject3 != null)
      {
        ((jj)localObject1).b.clear();
        ((jj)localObject1).b.addAll((Collection)localObject3);
        if (!paramJSONArray.toString().equals(localObject2))
        {
          ((jj)localObject1).c.a();
          ((jj)localObject1).c.a("mapStyleList", paramJSONArray.toString());
        }
      }
    }
    paramJSONArray = this.e;
    paramJSONArray.b = paramhh;
    if (paramJSONArray.b == null)
    {
      paramJSONArray.a.a(new String[] { "AIEnabled", "AIType", "AIBuildingList" });
      paramJSONArray.f.post(new kj.1(paramJSONArray));
      localObject1 = this.g;
      localObject2 = this.d;
      if (((jj)localObject2).b != null) {
        break label330;
      }
    }
    for (paramJSONArray = null;; paramJSONArray = paramJSONArray.toString())
    {
      localObject2 = ((hz)localObject1).a();
      if (!hz.b.containsKey(localObject2)) {
        break label460;
      }
      ((hz)localObject1).a((String)localObject2, ((hz)localObject1).c);
      return;
      paramJSONArray.a.a("AIEnabled", paramJSONArray.b.a);
      paramJSONArray.a.a("AIType", paramJSONArray.b.b);
      if (paramJSONArray.b.c != null) {
        paramJSONArray.a.a("AIBuildingList", paramJSONArray.b.c.toString());
      }
      if (paramJSONArray.g == null) {
        break;
      }
      if ((paramJSONArray.b != null) && (paramJSONArray.b.a == 1)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label328;
        }
        paramJSONArray.g.a(paramJSONArray.a());
        break;
      }
      label328:
      break;
      label330:
      paramJSONArray = new StringBuilder(128);
      localObject2 = ((jj)localObject2).b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ji)((Iterator)localObject2).next();
        if (((ji)localObject3).b != -1)
        {
          if (paramJSONArray.length() == 0)
          {
            paramJSONArray.append(((ji)localObject3).b);
          }
          else
          {
            paramJSONArray.append(",");
            paramJSONArray.append(((ji)localObject3).b);
          }
        }
        else if (paramJSONArray.length() == 0) {
          paramJSONArray.append(0);
        } else {
          paramJSONArray.append(",");
        }
      }
    }
    label460:
    ((hz)localObject1).a((String)localObject2, ((hz)localObject1).c);
    new hz.a((hz)localObject1, paramJSONArray, paramhh).start();
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    lu locallu = this.b;
    if ((locallu.d == null) || (locallu.b == null) || (locallu.b.az == null))
    {
      if (paramBoolean) {
        this.c.a();
      }
      this.c.e = true;
      return;
    }
    jr localjr;
    if (paramBoolean)
    {
      localjr = locallu.d;
      jr.f.writeLock().lock();
      jr.e.clear();
    }
    for (;;)
    {
      try
      {
        localFile1 = new File(localjr.c());
        if (localFile1.exists())
        {
          File localFile2 = new File(localjr.a.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos");
          if (!localFile1.renameTo(localFile2)) {
            continue;
          }
          new jr.4(localjr, localFile2).start();
        }
      }
      catch (Throwable localThrowable)
      {
        File localFile1;
        jr.f.writeLock().unlock();
        continue;
      }
      finally
      {
        jr.f.writeLock().unlock();
      }
      jr.a(jx.g());
      locallu.d.a(locallu.b.p(), locallu.b.az.a());
      break;
      on.c(localFile1.getAbsolutePath());
    }
  }
  
  public final void b()
  {
    if (this.f != null)
    {
      int i = 0;
      while (i < this.f.size())
      {
        ((AsyncTask)this.f.get(i)).cancel(true);
        i += 1;
      }
      this.f.clear();
    }
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.hv
 * JD-Core Version:    0.7.0.1
 */