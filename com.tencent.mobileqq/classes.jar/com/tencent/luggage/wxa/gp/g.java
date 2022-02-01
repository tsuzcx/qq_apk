package com.tencent.luggage.wxa.gp;

import com.tencent.luggage.wxa.gq.k;
import com.tencent.luggage.wxa.gw.a;
import com.tencent.luggage.wxa.gw.b;
import com.tencent.luggage.wxa.rt.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  public static final Long a = Long.valueOf(2592000000L);
  public static final Long b = Long.valueOf(604800000L);
  public static final Long c = Long.valueOf(259200000L);
  public static final Long d = Long.valueOf(172800000L);
  public static final Long e = Long.valueOf(86400000L);
  public static final Long f = Long.valueOf(43200000L);
  public static final Long g = Long.valueOf(240000L);
  public static final Long h = e;
  public static final Long i = Long.valueOf(60000L);
  private static long k = 0L;
  private List<String> j = new ArrayList(10);
  private String l;
  
  public g(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.j.addAll(paramList);
    }
  }
  
  private void a()
  {
    if (k == 0L) {
      k = 0L;
    }
    long l1 = System.currentTimeMillis();
    if (l1 - k <= h.longValue())
    {
      b.a("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
      return;
    }
    k = l1;
    b.b("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
    k.a(new g.a(this, "clean audio mix convert cache", 5));
  }
  
  private void b()
  {
    b.b("MicroMsg.Mix.AudioScanConvertCacheController", "clean mix convert file");
    b(a.a().b());
  }
  
  private void b(String paramString)
  {
    Object localObject1 = new File(paramString);
    int n;
    int m;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).list();
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        n = localObject1.length;
        m = 0;
      }
    }
    while (m < n)
    {
      String str = localObject1[m];
      if (c(str))
      {
        b.b("MicroMsg.Mix.AudioScanConvertCacheController", "file is the block file, don't delete");
      }
      else
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(str);
        str = ((StringBuilder)localObject2).toString();
        localObject2 = new File(str);
        if (!((File)localObject2).exists())
        {
          b.b("MicroMsg.Mix.AudioScanConvertCacheController", "file not exist");
        }
        else if (((File)localObject2).isDirectory())
        {
          b.b("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete subFilePath:%s", new Object[] { str });
          b(str);
        }
        else if (System.currentTimeMillis() - ((File)localObject2).lastModified() > d.longValue())
        {
          b.a("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", new Object[] { ((File)localObject2).getName(), ((File)localObject2).getAbsolutePath() });
          ((File)localObject2).delete();
        }
      }
      m += 1;
      continue;
      b.b("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
      return;
      b.b("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", new Object[] { paramString });
    }
  }
  
  private boolean c(String paramString)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.g
 * JD-Core Version:    0.7.0.1
 */