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
    Object localObject = paramln.b;
    String str = "";
    if ((localObject != null) && (paramln.b.aG != null))
    {
      str = paramln.b.aG.getSubKey();
      localObject = paramln.b.aG.getSubId();
    }
    else
    {
      localObject = "";
    }
    this.g = new hz(this.a, paramln, str);
    this.f.add(new hw(this.b.h, this, str, (String)localObject));
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
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
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
    }
    else
    {
      paramJSONArray.a.a("AIEnabled", paramJSONArray.b.a);
      paramJSONArray.a.a("AIType", paramJSONArray.b.b);
      if (paramJSONArray.b.c != null) {
        paramJSONArray.a.a("AIBuildingList", paramJSONArray.b.c.toString());
      }
      if (paramJSONArray.g != null)
      {
        int i;
        if ((paramJSONArray.b != null) && (paramJSONArray.b.a == 1)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 1) {
          paramJSONArray.g.a(paramJSONArray.a());
        }
      }
    }
    paramJSONArray.f.post(new kj.1(paramJSONArray));
    localObject1 = this.g;
    localObject2 = this.d;
    if (((jj)localObject2).b == null)
    {
      paramJSONArray = null;
    }
    else
    {
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
      paramJSONArray = paramJSONArray.toString();
    }
    localObject2 = ((hz)localObject1).a();
    if (hz.b.containsKey(localObject2))
    {
      ((hz)localObject1).a((String)localObject2, ((hz)localObject1).c);
      return;
    }
    ((hz)localObject1).a((String)localObject2, ((hz)localObject1).c);
    new hz.a((hz)localObject1, paramJSONArray, paramhh).start();
  }
  
  public final void a(boolean paramBoolean)
  {
    lu locallu = this.b;
    if (locallu == null) {
      return;
    }
    jr localjr;
    if ((locallu.d != null) && (locallu.b != null) && (locallu.b.az != null)) {
      if (paramBoolean)
      {
        localjr = locallu.d;
        jr.f.writeLock().lock();
        jr.e.clear();
      }
    }
    try
    {
      try
      {
        File localFile = new File(localjr.c());
        if (localFile.exists())
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localjr.a.getFilesDir().getAbsolutePath());
          ((StringBuilder)localObject2).append("/tencentMapSdk/oldLogos");
          localObject2 = new File(((StringBuilder)localObject2).toString());
          if (localFile.renameTo((File)localObject2)) {
            new jr.4(localjr, (File)localObject2).start();
          } else {
            on.c(localFile.getAbsolutePath());
          }
        }
      }
      finally
      {
        jr.f.writeLock().unlock();
      }
    }
    catch (Throwable localThrowable)
    {
      label180:
      break label180;
    }
    jr.f.writeLock().unlock();
    jr.a(jx.g());
    localObject1.d.a(localObject1.b.p(), localObject1.b.az.a());
    if (paramBoolean) {
      this.c.a();
    }
    this.c.e = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hv
 * JD-Core Version:    0.7.0.1
 */