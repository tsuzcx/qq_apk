package com.tencent.luggage.wxa.qg;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rd.a;
import com.tencent.luggage.wxa.rt.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
  implements b
{
  private static long i;
  private List<String> h = new ArrayList(10);
  
  public f(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.h.addAll(paramList);
    }
  }
  
  private boolean a(String paramString)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (i == 0L) {
      i = e.c();
    }
    long l = System.currentTimeMillis();
    if (l - i <= f.longValue())
    {
      o.b("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      return;
    }
    i = l;
    o.d("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    a.b(new f.1(this, l), "PieceCacheCleanController");
  }
  
  private void c()
  {
    o.d("MicroMsg.Music.PieceCacheCleanController", "clean music piece file");
    String str1 = e.b();
    if (str1.endsWith("/"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("music");
      str1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append("music");
      str1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = new i(str1);
    int k;
    int j;
    if ((((i)localObject1).j()) && (((i)localObject1).n()))
    {
      localObject1 = ((i)localObject1).r();
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        k = localObject1.length;
        j = 0;
      }
    }
    while (j < k)
    {
      String str2 = localObject1[j];
      if (a(str2))
      {
        o.d("MicroMsg.Music.PieceCacheCleanController", "file is the block file, don't delete");
      }
      else
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(str2);
        localObject2 = new i(((StringBuilder)localObject2).toString());
        if (!((i)localObject2).j())
        {
          o.d("MicroMsg.Music.PieceCacheCleanController", "file not exist");
        }
        else if (((i)localObject2).n())
        {
          o.d("MicroMsg.Music.PieceCacheCleanController", "file is directory, don't delete");
        }
        else if (System.currentTimeMillis() - ((i)localObject2).p() > a.longValue())
        {
          o.b("MicroMsg.Music.PieceCacheCleanController", "Clean 7 days file in music file name=%s, path:%s", new Object[] { ((i)localObject2).d(), ((i)localObject2).l() });
          ((i)localObject2).w();
          if (str2.startsWith("piece"))
          {
            o.b("MicroMsg.Music.PieceCacheCleanController", "file is piece prefix, delete the piece info in db");
            e.c(str2);
          }
        }
        else
        {
          o.d("MicroMsg.Music.PieceCacheCleanController", "not delete the file, file is in valid time for 7 day");
        }
      }
      j += 1;
      continue;
      o.d("MicroMsg.Music.PieceCacheCleanController", "none files exist");
      return;
      o.d("MicroMsg.Music.PieceCacheCleanController", "musicFolder is not exist or not Directory");
    }
  }
  
  public void a()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qg.f
 * JD-Core Version:    0.7.0.1
 */