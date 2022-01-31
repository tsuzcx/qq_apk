package com.tencent.hlyyb.downloader.f;

import com.tencent.hlyyb.common.a.a.d;
import com.tencent.hlyyb.common.a.e;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static a f = new a();
  private Map<DownloaderTaskCategory, com.tencent.hlyyb.downloader.f.a.b> a = new HashMap();
  private Map<DownloaderTaskCategory, Integer> b = new HashMap();
  private d c;
  private d d;
  private d e;
  
  private com.tencent.hlyyb.downloader.f.a.b a(DownloaderTaskCategory paramDownloaderTaskCategory)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = (Integer)this.b.get(paramDownloaderTaskCategory);
        if (localObject1 == null)
        {
          if (paramDownloaderTaskCategory == DownloaderTaskCategory.Cate_DefaultEase)
          {
            i = 3;
            i = com.tencent.hlyyb.common.b.b.a(i, 1, 5);
            localObject1 = (com.tencent.hlyyb.downloader.f.a.b)this.a.get(paramDownloaderTaskCategory);
            if (localObject1 == null)
            {
              Object localObject2 = new com.tencent.hlyyb.downloader.f.a.a(64);
              localObject1 = new com.tencent.hlyyb.downloader.f.a.b(0, i, 5L, TimeUnit.SECONDS, (BlockingQueue)localObject2, new com.tencent.hlyyb.common.a.a.a(paramDownloaderTaskCategory.name()));
              ((com.tencent.hlyyb.downloader.f.a.a)localObject2).a((com.tencent.hlyyb.downloader.f.a.b)localObject1);
              this.a.put(paramDownloaderTaskCategory, localObject1);
              if (this.c != null) {
                continue;
              }
              localObject2 = new com.tencent.hlyyb.common.a.a.b(16);
              if (i > 0) {
                break label351;
              }
              j = 1;
              this.c = new d(0, j + 1, 5L, TimeUnit.SECONDS, (BlockingQueue)localObject2, new com.tencent.hlyyb.common.a.a.a("HallyDownload-DirectPool"));
              ((com.tencent.hlyyb.common.a.a.b)localObject2).a(this.c);
              if (paramDownloaderTaskCategory != DownloaderTaskCategory.Cate_DefaultEase)
              {
                if (this.d != null) {
                  break label330;
                }
                paramDownloaderTaskCategory = new com.tencent.hlyyb.common.a.a.b(16);
                j = i;
                if (i <= 0) {
                  j = 1;
                }
                this.d = new d(0, j + 1, 5L, TimeUnit.SECONDS, paramDownloaderTaskCategory, new com.tencent.hlyyb.common.a.a.a("HallyDownload-SchedulePool"));
                paramDownloaderTaskCategory.a(this.d);
              }
              if (this.e != null) {
                b();
              }
              return localObject1;
            }
          }
          else
          {
            i = 2;
            continue;
          }
        }
        else
        {
          i = ((Integer)localObject1).intValue();
          continue;
        }
        j = ((com.tencent.hlyyb.downloader.f.a.b)localObject1).getMaximumPoolSize();
        ((com.tencent.hlyyb.downloader.f.a.b)localObject1).setMaximumPoolSize(i);
        i -= j;
        continue;
        j = this.c.getMaximumPoolSize();
        this.c.setMaximumPoolSize(j + i);
        continue;
        j = this.d.getMaximumPoolSize();
      }
      finally {}
      label330:
      this.d.setMaximumPoolSize(i + j);
      continue;
      label351:
      int j = i;
    }
  }
  
  public static a a()
  {
    return f;
  }
  
  private void b()
  {
    Object localObject = this.a.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      DownloaderTaskCategory localDownloaderTaskCategory = (DownloaderTaskCategory)((Iterator)localObject).next();
      if (localDownloaderTaskCategory == DownloaderTaskCategory.Cate_DefaultEase) {
        break label148;
      }
      i = ((com.tencent.hlyyb.downloader.f.a.b)this.a.get(localDownloaderTaskCategory)).getMaximumPoolSize() + i;
    }
    label148:
    for (;;)
    {
      break;
      int j = i;
      if (i == 0) {
        j = 2;
      }
      if (this.e == null)
      {
        localObject = new com.tencent.hlyyb.common.a.a.b(16);
        this.e = new d(0, (j << 1) + 1, 5L, TimeUnit.SECONDS, (BlockingQueue)localObject, new com.tencent.hlyyb.common.a.a.a("HallyDownload-HijackPool"));
        ((com.tencent.hlyyb.common.a.a.b)localObject).a(this.e);
        return;
      }
      this.e.setMaximumPoolSize((j << 1) + 1);
      return;
    }
  }
  
  public final e a(Runnable paramRunnable)
  {
    return new b(this.c.submit(paramRunnable));
  }
  
  public final e a(Runnable paramRunnable, DownloaderTaskCategory paramDownloaderTaskCategory)
  {
    try
    {
      com.tencent.hlyyb.downloader.f.a.b localb2 = (com.tencent.hlyyb.downloader.f.a.b)this.a.get(paramDownloaderTaskCategory);
      com.tencent.hlyyb.downloader.f.a.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = a(paramDownloaderTaskCategory);
      }
      paramRunnable = new b(localb1.submit(paramRunnable));
      return paramRunnable;
    }
    finally {}
  }
  
  public final void a(DownloaderTaskCategory paramDownloaderTaskCategory, int paramInt)
  {
    if ((paramDownloaderTaskCategory == null) || (paramInt <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramInt = com.tencent.hlyyb.common.b.b.a(paramInt, 1, 5);
        this.b.put(paramDownloaderTaskCategory, Integer.valueOf(paramInt));
        if ((com.tencent.hlyyb.downloader.f.a.b)this.a.get(paramDownloaderTaskCategory) == null) {
          continue;
        }
        a(paramDownloaderTaskCategory);
      }
      finally {}
    }
  }
  
  public final e b(Runnable paramRunnable)
  {
    return new b(this.d.submit(paramRunnable));
  }
  
  public final e c(Runnable paramRunnable)
  {
    if (this.e == null) {
      b();
    }
    return new b(this.e.submit(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.f.a
 * JD-Core Version:    0.7.0.1
 */