package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
  implements d.a
{
  private static final TimeUnit a = TimeUnit.SECONDS;
  private static final int b = Runtime.getRuntime().availableProcessors();
  private e c;
  private Map<String, List<a>> d = new HashMap();
  private Map<String, List<a>> e = new HashMap();
  private final BlockingQueue<Runnable> f = new LinkedBlockingQueue();
  private final BlockingQueue<Runnable> g = new LinkedBlockingQueue();
  private ExecutorService h;
  private ExecutorService i;
  private ThreadFactory j = new ThreadFactory()
  {
    private int a = 0;
    
    public final Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder("TileFetchThread#");
      int i = this.a;
      this.a = (i + 1);
      paramAnonymousRunnable = new Thread(paramAnonymousRunnable, i);
      paramAnonymousRunnable.setPriority(10);
      return paramAnonymousRunnable;
    }
  };
  
  public b(e parame)
  {
    this.c = parame;
    int k = b;
    k = b;
    if (b < 4) {}
    for (k = 3;; k = 4)
    {
      this.i = new ThreadPoolExecutor(k, m, 30L, TimeUnit.SECONDS, this.g, this.j);
      this.h = new ThreadPoolExecutor(1, 1, 30L, a, this.f);
      return;
      m = 4;
    }
  }
  
  public final void a()
  {
    if (this.f != null) {
      this.f.clear();
    }
    if (this.g != null) {
      this.g.clear();
    }
    if (this.h != null)
    {
      this.h.shutdownNow();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.shutdown();
      this.i = null;
    }
  }
  
  public final void a(d paramd)
  {
    if (paramd != null)
    {
      Object localObject2 = paramd.b();
      Bitmap localBitmap = paramd.a();
      synchronized (this.d)
      {
        List localList = (List)this.e.remove(localObject2);
        this.d.remove(localObject2);
        if ((localList != null) && (localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ??? = localList.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (a)((Iterator)???).next();
            if (!((a)localObject2).i()) {
              ((a)localObject2).a(localBitmap.copy(localBitmap.getConfig(), false));
            }
          }
        }
      }
    }
    this.c.c().postInvalidate();
  }
  
  public final void a(final ArrayList<MapTile> paramArrayList)
  {
    if (com.tencent.mapsdk.rastercore.f.b.a(paramArrayList)) {}
    for (;;)
    {
      return;
      this.f.clear();
      paramArrayList = new Runnable()
      {
        public final void run()
        {
          if ((b.a(b.this).z()) && (!b.a(b.this).A())) {
            return;
          }
          b.b(b.this).clear();
          for (;;)
          {
            int i;
            a locala;
            StringBuilder localStringBuilder;
            synchronized (b.c(b.this))
            {
              b.c(b.this).clear();
              b.c(b.this).putAll(b.d(b.this));
              i = 0;
              if (i >= paramArrayList.size()) {
                break;
              }
              Iterator localIterator = ((MapTile)paramArrayList.get(i)).b().iterator();
              if (!localIterator.hasNext()) {
                break label292;
              }
              locala = (a)localIterator.next();
              ??? = null;
              localStringBuilder = new StringBuilder();
              try
              {
                localBitmap = com.tencent.mapsdk.rastercore.tile.a.a.a().a(locala);
                ??? = localBitmap;
                localBitmap.setDensity(e.B());
              }
              catch (Throwable localThrowable)
              {
                Bitmap localBitmap;
                Object localObject3 = ???;
                if (TencentMap.getErrorListener() == null) {
                  continue;
                }
                TencentMap.getErrorListener().collectErrorInfo("TileEngineManager getTiles Runnable call CacheManager Get occured Exception,tileInfo:x=" + locala.b() + ",y=" + locala.c() + ",z=" + locala.d() + ";Get execute path:" + localStringBuilder.toString() + ";Exception Info:" + localThrowable.toString());
                localObject3 = ???;
                continue;
                b.a(b.this, locala);
              }
              if (localBitmap != null) {
                locala.a(localBitmap);
              }
            }
            continue;
            label292:
            b.a(b.this).c().postInvalidate();
            i += 1;
          }
        }
      };
      try
      {
        if (!this.h.isShutdown())
        {
          this.h.execute(paramArrayList);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        new StringBuilder("getTiles get error:").append(paramArrayList.getMessage());
      }
    }
  }
  
  public final void b(d arg1)
  {
    String str;
    if (??? != null) {
      str = ???.b();
    }
    synchronized (this.d)
    {
      List localList = (List)this.d.remove(str);
      this.e.put(str, localList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b
 * JD-Core Version:    0.7.0.1
 */