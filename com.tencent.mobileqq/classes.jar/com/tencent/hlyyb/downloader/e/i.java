package com.tencent.hlyyb.downloader.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.common.a.f;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.DownloaderTaskPriority;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class i
  implements DownloaderTask, com.tencent.hlyyb.downloader.a.b, com.tencent.hlyyb.downloader.b.a, com.tencent.hlyyb.downloader.e.a.d, Comparable<i>, Runnable
{
  public long A = 0L;
  public boolean B = true;
  public boolean C = false;
  public boolean D = false;
  private com.tencent.hlyyb.downloader.e.d.c E;
  private DownloaderTaskCategory F = DownloaderTaskCategory.Cate_DefaultMass;
  private boolean G = true;
  private volatile DownloaderTaskPriority H = DownloaderTaskPriority.NORMAL;
  private volatile long I = 0L;
  private String J = "";
  private boolean K = false;
  private long L = -1L;
  private h M;
  private com.tencent.hlyyb.downloader.e.a.a N;
  private File O;
  private RandomAccessFile P;
  private File Q;
  private RandomAccessFile R;
  private volatile boolean S = false;
  private d T = new d(this);
  private boolean U = false;
  private a V;
  private int W = 0;
  private volatile boolean X = false;
  private AtomicInteger Y = new AtomicInteger(0);
  private Object Z = new Object();
  public int a = -1;
  private volatile boolean aa = false;
  private Object ab;
  private boolean ac = false;
  private k ad = new k(this, (byte)0);
  private com.tencent.hlyyb.downloader.e.c.a ae;
  private com.tencent.hlyyb.common.a.e af;
  private long ag = 0L;
  private String ah = "";
  private boolean ai = false;
  private volatile HashMap<String, Long> aj = new LinkedHashMap();
  private List<com.tencent.hlyyb.downloader.b.c> ak = Collections.synchronizedList(new ArrayList());
  private Map<com.tencent.hlyyb.downloader.e.d.a, com.tencent.hlyyb.downloader.b.c> al = new ConcurrentHashMap();
  private Map<com.tencent.hlyyb.downloader.e.d.a, List<String>> am = new ConcurrentHashMap();
  private volatile long an = -1L;
  private AtomicInteger ao = new AtomicInteger(0);
  private AtomicInteger ap = new AtomicInteger(0);
  private Object aq = new Object();
  private com.tencent.hlyyb.downloader.b.b ar = new com.tencent.hlyyb.downloader.b.b();
  private long as = 0L;
  private long at = 0L;
  private int au = -1;
  public String b = "";
  public String c = "";
  public String d = "";
  public Map<String, String> e = new HashMap();
  public long f = -1L;
  public volatile long g = -1L;
  public String h = "";
  public String i = "";
  public volatile long j = 0L;
  public volatile boolean k = true;
  public String l = "";
  public String m = "";
  public String n = null;
  public AtomicLong o = new AtomicLong(0L);
  public AtomicLong p = new AtomicLong(0L);
  public volatile int q = 0;
  public volatile int r = 0;
  public String s = "";
  public long t = -1L;
  public long u = -1L;
  public long v = -1L;
  public boolean w = false;
  public String x = "";
  public String y;
  public int z = -1;
  
  public i(com.tencent.hlyyb.downloader.e.d.c paramc, String paramString1, String paramString2, DownloaderTaskListener paramDownloaderTaskListener, long paramLong, String paramString3)
  {
    this.E = paramc;
    this.h = paramString1;
    this.i = paramString2;
    this.T.a(paramDownloaderTaskListener);
    if (paramLong > 0L) {}
    for (;;)
    {
      this.f = paramLong;
      TextUtils.isEmpty(paramString3);
      paramc = new StringBuilder("");
      paramc.append(com.tencent.hlyyb.common.b.b.b());
      paramc.append(com.tencent.hlyyb.common.b.b.c());
      paramc.append(System.currentTimeMillis());
      paramc.append(this.E.a.a);
      paramc.append(com.tencent.hlyyb.common.b.b.a());
      this.n = com.tencent.hlyyb.common.b.a.a(paramc.toString());
      return;
      paramLong = -1L;
    }
  }
  
  private boolean A()
  {
    int i3 = 1;
    int i2 = 1;
    int i1;
    for (;;)
    {
      synchronized (getClass())
      {
        this.aj.put("point0", Long.valueOf(0L));
        long l1 = System.currentTimeMillis();
        new File(this.h).mkdirs();
        if (!com.tencent.hlyyb.downloader.a.a.g(this.i))
        {
          this.J = f.a(this.E.a.a, this.l, this.m, "");
          Object localObject1 = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
          Object localObject3 = new File(this.h, this.J);
          if ((((File)localObject1).exists()) || (((File)localObject3).exists()))
          {
            i1 = this.J.lastIndexOf(".");
            localObject1 = "";
            String str3;
            if ((i1 > 0) && (this.J.length() > i1 + 1))
            {
              localObject3 = this.J.substring(0, i1);
              localObject1 = this.J.substring(i1);
              break label795;
              str3 = (String)localObject3 + "(" + i1 + ")" + (String)localObject1;
              File localFile1 = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(str3));
              File localFile2 = new File(this.h, str3);
              if (localFile1.exists()) {
                break label800;
              }
              if (localFile2.exists()) {
                break label800;
              }
            }
            else
            {
              localObject3 = this.J;
              break label795;
            }
            this.J = str3;
          }
          this.aj.put("point1", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          l1 = System.currentTimeMillis();
          if (!this.G) {
            break label533;
          }
          this.O = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
          this.Q = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
        }
        try
        {
          this.R = new j(this.Q, "rw");
          this.aj.put("point2", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          l1 = System.currentTimeMillis();
        }
        catch (Exception localException1)
        {
          this.r = -49;
          this.s = ("initFileOnDetected...create RandomAccessFile of path:" + this.Q.getAbsolutePath() + " fail.|" + localException1);
          if (!f.a(localException1)) {
            break;
          }
        }
        try
        {
          this.P = new j(this.O, "rw");
          this.aj.put("point3", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          l1 = System.currentTimeMillis();
          this.aj.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          System.currentTimeMillis();
          return true;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          this.r = -49;
          this.s = ("initFileOnDetected...create RandomAccessFile of path:" + this.O.getAbsolutePath() + " fail.|" + localException2);
          if (!f.a(localException2)) {
            break label744;
          }
        }
        this.J = this.i;
      }
      label533:
      this.O = new File(this.h, this.J);
      continue;
      this.r = -12;
    }
    label793:
    label795:
    label800:
    label810:
    for (;;)
    {
      label615:
      E();
      return false;
      if ((localException1 instanceof IOException))
      {
        String str1 = localException1.getMessage();
        if ((str1 == null) || (!str1.contains("Read-only file system"))) {}
      }
      for (i1 = i2;; i1 = 0)
      {
        if (i1 == 0) {
          break label810;
        }
        this.r = -13;
        break label615;
        this.r = -12;
        for (;;)
        {
          E();
          return false;
          label744:
          if ((localException2 instanceof IOException))
          {
            String str2 = localException2.getMessage();
            if ((str2 == null) || (!str2.contains("Read-only file system"))) {}
          }
          for (i1 = i3;; i1 = 0)
          {
            if (i1 == 0) {
              break label793;
            }
            this.r = -13;
            break;
          }
        }
        i1 = 2;
        break;
        i1 += 1;
        break;
      }
    }
  }
  
  private void B()
  {
    try
    {
      synchronized (this.Z)
      {
        this.Z.notifyAll();
        this.aa = false;
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void C()
  {
    int i2 = 0;
    I();
    for (;;)
    {
      synchronized (this.T)
      {
        if (this.T.a() != DownloaderTaskStatus.PAUSED)
        {
          if (!this.G) {
            break label172;
          }
          int i1 = 0;
          if (i1 < 3)
          {
            File localFile1 = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
            File localFile2 = new File(this.h, this.J);
            if (localFile2.exists()) {
              localFile2.delete();
            }
            boolean bool = localFile1.renameTo(localFile2);
            i2 = bool;
            if (!bool)
            {
              SystemClock.sleep(50L);
              i1 += 1;
              i2 = bool;
              continue;
            }
          }
          if (i2 != 0)
          {
            x();
            J();
            this.T.a(DownloaderTaskStatus.COMPLETE);
          }
        }
        else
        {
          return;
        }
        a(false, -72, "", DownloaderTaskStatus.FAILED);
      }
      label172:
      i2 = 1;
    }
  }
  
  private void D()
  {
    try
    {
      if ((this.M != null) && (this.O != null) && (this.Q != null))
      {
        this.M.b = this.O.lastModified();
        this.M.c = this.j;
        this.M.d = this.o.get();
        a(this.M.c());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void E()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 447	com/tencent/hlyyb/downloader/e/i:P	Ljava/io/RandomAccessFile;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 447	com/tencent/hlyyb/downloader/e/i:P	Ljava/io/RandomAccessFile;
    //   15: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 447	com/tencent/hlyyb/downloader/e/i:P	Ljava/io/RandomAccessFile;
    //   23: aload_0
    //   24: getfield 443	com/tencent/hlyyb/downloader/e/i:R	Ljava/io/RandomAccessFile;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: getfield 443	com/tencent/hlyyb/downloader/e/i:R	Ljava/io/RandomAccessFile;
    //   36: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 443	com/tencent/hlyyb/downloader/e/i:R	Ljava/io/RandomAccessFile;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 548	java/io/IOException:printStackTrace	()V
    //   52: goto -34 -> 18
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 548	java/io/IOException:printStackTrace	()V
    //   65: goto -26 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	i
    //   6	23	1	localRandomAccessFile	RandomAccessFile
    //   47	2	1	localIOException1	IOException
    //   55	4	1	localObject	Object
    //   60	2	1	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   11	18	47	java/io/IOException
    //   2	7	55	finally
    //   11	18	55	finally
    //   18	23	55	finally
    //   23	28	55	finally
    //   32	39	55	finally
    //   39	44	55	finally
    //   48	52	55	finally
    //   61	65	55	finally
    //   32	39	60	java/io/IOException
  }
  
  private String F()
  {
    for (Object localObject1 = "";; localObject1 = localObject2)
    {
      try
      {
        if ((this.ah == null) || (this.ah.length() == 0)) {
          break label41;
        }
        localObject2 = this.ah;
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          label41:
          localException.printStackTrace();
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "";
      }
      return localObject2;
      this.R.seek(0L);
      localObject2 = this.R.readUTF();
    }
  }
  
  private void G()
  {
    this.al.clear();
    synchronized (this.ak)
    {
      this.ak.clear();
      this.am.clear();
      return;
    }
  }
  
  private void H()
  {
    I();
    if (this.ad.a != null) {
      this.ad.a.a(false);
    }
    if (this.ad.b != null) {
      this.ad.b.a(false);
    }
  }
  
  private void I()
  {
    synchronized (this.ak)
    {
      Iterator localIterator = this.ak.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.hlyyb.downloader.b.c)localIterator.next()).a();
      }
    }
  }
  
  private void J()
  {
    Object localObject1 = this.E.d();
    if (this.E.a() < 0L)
    {
      this.au = -2;
      return;
    }
    if ((localObject1 == null) || (((List)localObject1).size() <= 0))
    {
      this.au = -3;
      return;
    }
    if (TextUtils.isEmpty(this.E.c()))
    {
      this.au = -3;
      return;
    }
    SystemClock.elapsedRealtime();
    j localj;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localj = new j(new File(this.h, this.J), "r");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.hlyyb.downloader.d.a)((Iterator)localObject1).next();
        long l1 = ((com.tencent.hlyyb.downloader.d.a)localObject2).a;
        int i1 = ((com.tencent.hlyyb.downloader.d.a)localObject2).b;
        localObject2 = new byte[i1];
        localj.seek(l1);
        localj.read((byte[])localObject2, 0, i1);
        localByteArrayOutputStream.write((byte[])localObject2, 0, i1);
      }
      SystemClock.elapsedRealtime();
    }
    catch (IOException localIOException1)
    {
      this.au = -4;
      localIOException1.printStackTrace();
    }
    return;
    localObject1 = localIOException1.toByteArray();
    if (com.tencent.hlyyb.common.b.b.a((byte[])localObject1)) {
      this.au = -4;
    }
    localObject1 = com.tencent.hlyyb.common.b.a.a((byte[])localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      this.au = -5;
    }
    for (;;)
    {
      try
      {
        localIOException1.close();
        localj.close();
      }
      catch (IOException localIOException2) {}
      break;
      if (((String)localObject1).toLowerCase().equals(this.E.c().toLowerCase())) {
        this.au = 1;
      } else {
        this.au = 0;
      }
    }
  }
  
  private int K()
  {
    if (com.tencent.hlyyb.common.a.a.g() == 1)
    {
      if (this.g > 0L)
      {
        int i1 = (int)(this.g * 0.2D);
        if (i1 > 41943040) {
          return i1;
        }
        return 41943040;
      }
      return 41943040;
    }
    return 20971520;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      this.ah = paramString;
      this.R.seek(0L);
      this.R.writeUTF(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private boolean v()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(getSavePath());
      if (localFile.exists()) {
        bool = localFile.delete();
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean w()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(getSaveDir(), com.tencent.hlyyb.downloader.a.a.f(this.J));
      if (localFile.exists()) {
        bool = localFile.delete();
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean x()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
      if (localFile.exists()) {
        bool = localFile.delete();
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean y()
  {
    int i2 = 1;
    int i1 = 1;
    try
    {
      this.R = new j(this.Q, "rw");
      String str1;
      this.r = -12;
    }
    catch (Exception localException1)
    {
      try
      {
        this.P = new j(this.O, "rw");
        return true;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.r = -49;
        this.s = ("initFileOnStart...create RandomAccessFile of path:" + this.O.getAbsolutePath() + " fail.|" + localException2);
        if (!f.a(localException2)) {
          break label220;
        }
      }
      localException1 = localException1;
      localException1.printStackTrace();
      this.r = -49;
      this.s = ("initFileOnStart...create RandomAccessFile of path:" + this.Q.getAbsolutePath() + " fail.|" + localException1);
      if (f.a(localException1)) {
        this.r = -12;
      }
      for (;;)
      {
        E();
        return false;
        if ((localException1 instanceof IOException))
        {
          str1 = localException1.getMessage();
          if ((str1 == null) || (!str1.contains("Read-only file system"))) {}
        }
        for (;;)
        {
          if (i1 == 0) {
            break label151;
          }
          this.r = -13;
          break;
          i1 = 0;
        }
      }
    }
    label264:
    for (;;)
    {
      label151:
      E();
      return false;
      label220:
      if ((localException2 instanceof IOException))
      {
        String str2 = localException2.getMessage();
        if ((str2 == null) || (!str2.contains("Read-only file system"))) {}
      }
      for (i1 = i2;; i1 = 0)
      {
        if (i1 == 0) {
          break label264;
        }
        this.r = -13;
        break;
      }
    }
  }
  
  private boolean z()
  {
    try
    {
      new File(this.h).mkdirs();
      this.O = null;
      this.Q = null;
      if (this.M != null)
      {
        if ((this.M.d() <= 0L) || (TextUtils.isEmpty(this.J))) {
          break label651;
        }
        if (this.G)
        {
          this.O = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
          this.Q = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
          i1 = 1;
          int i3 = 0;
          i2 = i1;
          i1 = i3;
          if (((i2 == 0) && (i1 == 0)) || (!this.O.exists())) {
            break label632;
          }
          if (y()) {
            break label262;
          }
          return false;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        this.O = new File(this.h, this.J);
        continue;
        if (com.tencent.hlyyb.downloader.a.a.g(this.i))
        {
          if (this.G) {}
          for (this.O = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.i));; this.O = new File(this.h, this.i))
          {
            this.Q = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.i));
            i1 = 1;
            i2 = 0;
            break;
          }
          label262:
          Object localObject = F();
          this.M = new h((String)localObject);
          long l1;
          boolean bool;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.M.e))
          {
            l1 = this.O.lastModified();
            if ((i1 != 0) && (l1 >= this.M.b) && (this.M.a > 0L) && (this.M.d() <= this.M.a)) {
              bool = true;
            }
          }
          for (;;)
          {
            if (bool)
            {
              if (TextUtils.isEmpty(this.J)) {
                this.J = this.i;
              }
              this.j = this.M.c;
              this.o.set(this.M.d);
              if ((i1 == 0) || (this.M.a <= 0L)) {
                break label602;
              }
              this.w = true;
            }
            for (;;)
            {
              if (!bool)
              {
                E();
                this.g = -1L;
                this.J = "";
                this.j = 0L;
                this.o.set(0L);
                this.k = true;
                this.l = "";
                this.m = "";
                this.q = 0;
                this.K = false;
                this.r = 0;
                this.s = "";
                this.M = new h("");
                this.w = false;
              }
              this.ac = bool;
              return true;
              if ((i2 == 0) || (l1 < this.M.b)) {
                break label638;
              }
              bool = true;
              break;
              localObject = new StringBuilder("resume failed. cfg:").append((String)localObject).append(",flm:").append(l1).append(",from:");
              if (i1 != 0) {}
              for (i1 = 0;; i1 = 1)
              {
                this.x = i1;
                label602:
                break;
              }
              this.x = ("resume failed. cfg:" + (String)localObject);
              label632:
              bool = false;
            }
            label638:
            bool = false;
          }
        }
        int i1 = 0;
        int i2 = 0;
        continue;
        label651:
        i1 = 0;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.W < paramInt) {
      this.W = paramInt;
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    if ((isRunning()) && (this.ae != null))
    {
      long l1 = System.currentTimeMillis();
      this.ae.a(new com.tencent.hlyyb.downloader.e.c.b(l1 - this.t, paramInt, paramString));
    }
  }
  
  public final void a(long paramLong)
  {
    synchronized (this.ad)
    {
      if (this.g == -1L)
      {
        if (paramLong > 0L) {
          this.an = paramLong;
        }
        while (this.f <= 0L) {
          return;
        }
        this.an = this.f;
      }
    }
    long l1 = this.g;
    long l2 = this.g;
    if (paramLong > 0L) {}
    while (this.g != paramLong)
    {
      for (;;)
      {
        this.g = -1L;
        this.an = paramLong;
        if (this.M == null) {
          break;
        }
        synchronized (this.aq)
        {
          paramLong = this.M.h();
          int i1 = this.M.i();
          this.ar.a = 1;
          this.ar.d = this.z;
          this.ar.c = l2;
          this.ar.b = this.o.get();
          if (this.ad.a != null)
          {
            this.ar.e = this.ad.a.k();
            String str = this.ad.a.l();
            if (!TextUtils.isEmpty(str)) {
              this.ar.f = com.tencent.hlyyb.common.b.b.b(str);
            }
          }
          this.M = new h("");
          if ((this.ad.a != null) && (this.ad.a.c)) {
            this.ad.a.e();
          }
          G();
          this.M.a(paramLong, i1);
          if (this.N != null) {
            this.N.c();
          }
        }
      }
      if (this.f > 0L) {
        paramLong = this.f;
      } else {
        paramLong = l1;
      }
    }
  }
  
  public final void a(com.tencent.hlyyb.downloader.e.d.a parama, com.tencent.hlyyb.downloader.b.c paramc)
  {
    if (this.M != null)
    {
      Object localObject1 = (List)this.am.get(parama);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        long l1 = this.M.d();
        int i1;
        if (l1 > K())
        {
          i1 = 1;
          if (i1 != 0)
          {
            this.as = l1;
            H();
            paramc.c();
          }
          localObject1 = ((List)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label224;
          }
          Object localObject2 = ((String)((Iterator)localObject1).next()).split(",");
          if (localObject2.length == 2)
          {
            l1 = Long.parseLong(localObject2[0]);
            long l2 = Long.parseLong(localObject2[1]);
            localObject2 = l1 + "-" + l2;
            com.tencent.hlyyb.downloader.e.b.a locala = new com.tencent.hlyyb.downloader.e.b.a(this.M, l1, l1, l1, l2);
            if (i1 == 0)
            {
              this.M.a(locala);
              paramc.a((String)localObject2);
              continue;
              i1 = 0;
              break;
            }
            paramc.b((String)localObject2);
          }
        }
      }
      label224:
      this.am.remove(parama);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (isDeleted()) {
      return;
    }
    if ((!isRunning()) && (paramBoolean))
    {
      x();
      v();
      if (this.G) {
        w();
      }
    }
    if (paramBoolean) {
      this.U = paramBoolean;
    }
    a(true, 0, "", DownloaderTaskStatus.DELETED);
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString, DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    this.S = true;
    this.K = paramBoolean;
    if (!this.K)
    {
      this.r = paramInt;
      this.s = paramString;
    }
    this.T.a(paramDownloaderTaskStatus);
    I();
    paramString = this.ad;
    try
    {
      if (paramString.a != null) {
        paramString.a.f();
      }
      if (paramString.b != null) {
        paramString.b.f();
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final boolean a()
  {
    return this.S;
  }
  
  public final boolean a(com.tencent.hlyyb.downloader.e.b.a parama, com.tencent.hlyyb.downloader.b.c paramc)
  {
    boolean bool = false;
    long l1;
    if (this.M != null)
    {
      l1 = this.M.d();
      if (l1 <= K()) {
        break label116;
      }
    }
    label116:
    for (int i1 = 1;; i1 = 0)
    {
      long l2 = parama.d;
      long l3 = parama.f;
      parama = l2 + "-" + l3;
      if (i1 != 0) {
        break;
      }
      com.tencent.hlyyb.downloader.e.b.a locala = new com.tencent.hlyyb.downloader.e.b.a(this.M, l2, l2, l2, l3);
      this.M.a(locala);
      paramc.a(parama);
      bool = true;
      return bool;
    }
    this.as = l1;
    H();
    paramc.c();
    paramc.b(parama);
    return false;
  }
  
  public final void addHeader(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equalsIgnoreCase("range"))) {
      this.e.put(paramString1, paramString2);
    }
  }
  
  public final void addListener(DownloaderTaskListener paramDownloaderTaskListener)
  {
    this.T.a(paramDownloaderTaskListener);
  }
  
  public final boolean b()
  {
    int i3 = 1;
    if ((this.S) || (isPaused()) || (isDeleted()) || (isCompleted()) || (isFailed()))
    {
      if (this.N != null) {
        this.N.c();
      }
      E();
      return false;
    }
    long l2 = SystemClock.elapsedRealtime();
    int i2 = 0;
    boolean bool;
    if ((this.S) || (isPaused()) || (isDeleted()) || (isCompleted()) || (isFailed()))
    {
      if (this.N != null) {
        this.N.c();
      }
      bool = false;
    }
    for (;;)
    {
      if (!bool) {
        B();
      }
      long l1 = SystemClock.elapsedRealtime();
      if (this.V != null) {
        this.V.a(i2, (int)(l1 - l2));
      }
      if (i2 > 0) {
        D();
      }
      if ((this.S) || (isPaused()) || (isDeleted()) || (isCompleted()) || (isFailed())) {
        E();
      }
      for (;;)
      {
        com.tencent.hlyyb.downloader.e.b.a locala;
        for (;;)
        {
          return bool;
          if (SystemClock.elapsedRealtime() - l2 > com.tencent.hlyyb.downloader.a.a.d)
          {
            this.Y.getAndIncrement();
            bool = true;
            break;
          }
          synchronized (this.aq)
          {
            com.tencent.hlyyb.downloader.e.a.b localb = this.N.b();
            if (localb == null)
            {
              bool = false;
              break;
            }
            locala = this.M.a(localb.a);
            if (locala == null)
            {
              a(false, -42, "inner error: getRange null for sectionId:" + localb.a, DownloaderTaskStatus.FAILED);
              return false;
            }
          }
        }
        if (locala.e != localObject2.b)
        {
          a(false, -42, "inner error: check offset fail for section:" + locala + ",buffer offset:" + localObject2.b + ",sectionId:" + localObject2.a, DownloaderTaskStatus.FAILED);
          return false;
        }
        for (;;)
        {
          try
          {
            if (this.P.getFilePointer() != localObject2.b) {
              this.P.seek(localObject2.b);
            }
            this.P.write(localObject2.c, 0, (int)localObject2.d);
            locala.e = (localObject2.b + localObject2.d);
            int i4 = (int)(i2 + localObject2.d);
            localObject2.c = null;
            i2 = i4;
            if (!this.aa) {
              break;
            }
            if (com.tencent.hlyyb.downloader.c.b.a().f() >= 2097152L) {
              break label642;
            }
            i1 = 1;
            i2 = i4;
            if (i1 == 0) {
              break;
            }
            B();
            i2 = i4;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if ((localException instanceof NullPointerException)) {
              break label842;
            }
          }
          int i1 = -50;
          if (!this.O.exists()) {
            i1 = -14;
          }
          label640:
          for (;;)
          {
            a(false, i1, "saveData fail.|" + localException, DownloaderTaskStatus.FAILED);
            bool = false;
            break;
            if (f.a(localException))
            {
              i1 = -12;
            }
            else
            {
              if ((localException instanceof IOException))
              {
                String str = localException.getMessage();
                if ((str == null) || (!str.contains("Read-only file system"))) {}
              }
              for (;;)
              {
                if (i3 == 0) {
                  break label640;
                }
                i1 = -17;
                break;
                i3 = 0;
              }
            }
          }
          label642:
          i1 = 0;
        }
        if (this.g > 0L)
        {
          l2 = this.M.d();
          if (((l1 - this.ag <= com.tencent.hlyyb.downloader.a.a.c()) && (l2 != this.g)) || ((i2 > 0) && (!this.B))) {}
          try
          {
            this.P.getFD().sync();
            label711:
            this.I = l2;
            this.M.a(this.I, getPercentage());
            this.T.a(DownloaderTaskStatus.DOWNLOADING);
            this.ag = l1;
            if (l2 == this.g)
            {
              this.V.c();
              this.v = l1;
              C();
            }
            else if (l2 > this.g)
            {
              a(false, -42, "inner error: receivedLength > detectLength:" + l2 + " > " + this.g, DownloaderTaskStatus.FAILED);
              x();
            }
          }
          catch (Throwable localThrowable)
          {
            break label711;
          }
        }
      }
      label842:
      bool = false;
    }
  }
  
  public final void c()
  {
    this.L = SystemClock.elapsedRealtime();
    try
    {
      this.T.a(DownloaderTaskStatus.PENDING);
      this.af = com.tencent.hlyyb.downloader.f.a.a().a(this, this.F);
      return;
    }
    catch (Exception localException)
    {
      throw new HalleyException(localException);
    }
  }
  
  public final int d()
  {
    return this.T.f();
  }
  
  public final boolean e()
  {
    if (isRunning()) {
      return b();
    }
    return false;
  }
  
  public final int f()
  {
    return this.W;
  }
  
  public final boolean g()
  {
    return this.X;
  }
  
  public final int getAverageSpeed()
  {
    if ((this.j <= 10L) || (this.g <= 0L)) {
      return -1;
    }
    return (int)(getReceivedLength() * 1000L / this.j);
  }
  
  public final DownloaderTaskCategory getCategory()
  {
    return this.F;
  }
  
  public final String getContentDisposition()
  {
    return this.m;
  }
  
  public final String getContentType()
  {
    return this.l;
  }
  
  public final long getCostTime()
  {
    return this.j;
  }
  
  public final int getFailCode()
  {
    return this.r;
  }
  
  public final String getFailInfo()
  {
    try
    {
      String str = this.s;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String getHtmlUrl()
  {
    return this.s;
  }
  
  public final String getId()
  {
    return this.b;
  }
  
  public final String getInitSaveName()
  {
    return this.i;
  }
  
  public final long getKnownSize()
  {
    return this.f;
  }
  
  public final int getPercentage()
  {
    long l2 = getTotalLength();
    long l1 = l2;
    if (l2 == -1L)
    {
      l1 = l2;
      if (this.M != null) {
        l1 = this.M.a;
      }
    }
    if (this.M != null) {}
    for (int i1 = this.M.i();; i1 = 0)
    {
      if (l1 <= 0L) {}
      for (int i2 = 0;; i2 = (int)(getReceivedLength() * 100L / l1))
      {
        int i3 = i2;
        if (i1 > i2) {
          i3 = i1;
        }
        return i3;
      }
    }
  }
  
  public final DownloaderTaskPriority getPriority()
  {
    return this.H;
  }
  
  public final String getRealSaveName()
  {
    return this.J;
  }
  
  public final int getRealTimeSpeed()
  {
    if ((this.T.a() != DownloaderTaskStatus.STARTED) && (this.T.a() != DownloaderTaskStatus.DOWNLOADING)) {
      return 0;
    }
    return this.q;
  }
  
  public final long getReceivedLength()
  {
    if (this.M != null)
    {
      long l1 = this.M.h();
      if ((l1 > this.I) && (l1 <= this.M.a)) {
        return l1;
      }
    }
    return this.I;
  }
  
  public final String getSaveDir()
  {
    return this.h;
  }
  
  public final String getSavePath()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = new File(this.h, this.J).getAbsolutePath();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label24:
      break label24;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.h + "/" + this.J;
    }
    return localObject2;
  }
  
  public final long getStartTime()
  {
    return this.t;
  }
  
  public final DownloaderTaskStatus getStatus()
  {
    return this.T.a();
  }
  
  public final Object getTag()
  {
    return this.ab;
  }
  
  public final long getTotalLength()
  {
    if (this.E.a() > 0L) {
      return this.E.a();
    }
    if (this.f > 0L) {
      return this.f;
    }
    if (this.g > 0L) {
      return this.g;
    }
    try
    {
      long l1 = this.M.a;
      return l1;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public final int getType()
  {
    return this.a;
  }
  
  public final String getUniqueKey()
  {
    return this.n;
  }
  
  public final String getUrl()
  {
    return this.E.a.a;
  }
  
  public final long h()
  {
    if (this.V != null) {
      return this.V.d();
    }
    return -1L;
  }
  
  public final long i()
  {
    if (this.N != null) {
      return this.N.a();
    }
    return 0L;
  }
  
  public final boolean isCompleted()
  {
    return this.T.a() == DownloaderTaskStatus.COMPLETE;
  }
  
  public final boolean isDeleted()
  {
    return this.T.a() == DownloaderTaskStatus.DELETED;
  }
  
  public final boolean isEaseTask()
  {
    return this.F == DownloaderTaskCategory.Cate_DefaultEase;
  }
  
  public final boolean isFailed()
  {
    return this.T.a() == DownloaderTaskStatus.FAILED;
  }
  
  public final boolean isPaused()
  {
    return this.T.a() == DownloaderTaskStatus.PAUSED;
  }
  
  public final boolean isPausedOnMobile()
  {
    return this.D;
  }
  
  public final boolean isRunning()
  {
    return (this.T.a() == DownloaderTaskStatus.STARTED) || (this.T.a() == DownloaderTaskStatus.DOWNLOADING);
  }
  
  public final boolean isSupportRange()
  {
    return this.k;
  }
  
  public final boolean isUsingTempFile()
  {
    return this.G;
  }
  
  public final boolean isWaiting()
  {
    return this.T.a() == DownloaderTaskStatus.PENDING;
  }
  
  public final long j()
  {
    if (this.M != null) {
      return this.M.g();
    }
    return 0L;
  }
  
  public final String k()
  {
    if (this.ae != null) {
      return this.ae.a();
    }
    return "";
  }
  
  public final String l()
  {
    if (this.E != null) {
      return this.E.g();
    }
    return "";
  }
  
  public final String m()
  {
    if (this.ad != null)
    {
      k localk = this.ad;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localk.a != null) {
        localStringBuilder.append(localk.a.h());
      }
      if (localk.b != null) {
        localStringBuilder.append(localk.b.h());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String n()
  {
    if (this.ad != null)
    {
      k localk = this.ad;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localk.a != null) {
        localStringBuilder.append(localk.a.i());
      }
      if (localk.b != null) {
        localStringBuilder.append(localk.b.i());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String o()
  {
    if (this.ad != null)
    {
      k localk = this.ad;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localk.a != null) {
        localStringBuilder.append(localk.a.j());
      }
      if (localk.b != null) {
        localStringBuilder.append(localk.b.j());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String p()
  {
    String str1;
    String str2;
    label47:
    Object localObject;
    if (this.E.f())
    {
      str1 = "1";
      if (this.E.a() <= 0L) {
        break label156;
      }
      str2 = this.E.a();
      localObject = this.E.d();
      if ((localObject == null) || (((List)localObject).size() <= 0) || (TextUtils.isEmpty(this.E.c()))) {
        break label163;
      }
      localObject = "1";
      label85:
      if (TextUtils.isEmpty(this.E.b())) {
        break label170;
      }
    }
    label156:
    label163:
    label170:
    for (String str3 = "1";; str3 = "0")
    {
      return str1 + "," + str2 + "," + (String)localObject + "," + str3;
      str1 = "0";
      break;
      str2 = "0";
      break label47;
      localObject = "0";
      break label85;
    }
  }
  
  public final void pause()
  {
    Object localObject = this.T.a();
    int i1;
    if ((localObject == DownloaderTaskStatus.PENDING) || (localObject == DownloaderTaskStatus.STARTED) || (localObject == DownloaderTaskStatus.DOWNLOADING))
    {
      if (this.M == null) {
        break label80;
      }
      localObject = this.M;
      long l1 = ((h)localObject).f();
      if ((l1 <= 0L) || (l1 != ((h)localObject).a)) {
        break label75;
      }
      i1 = 1;
      if (i1 == 0) {
        break label80;
      }
    }
    for (;;)
    {
      return;
      label75:
      i1 = 0;
      break;
      label80:
      a(true, 0, "", DownloaderTaskStatus.PAUSED);
      try
      {
        if (this.af != null)
        {
          this.af.a();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public final String q()
  {
    int i3 = 1;
    Object localObject3 = this.ar;
    Object localObject1 = this.M;
    Object localObject2 = this.ak;
    int i4 = this.au;
    long l1 = this.as;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((com.tencent.hlyyb.downloader.b.b)localObject3).a).append(",").append(((com.tencent.hlyyb.downloader.b.b)localObject3).b).append(",").append(((com.tencent.hlyyb.downloader.b.b)localObject3).d).append(",").append(((com.tencent.hlyyb.downloader.b.b)localObject3).c).append(",").append(((com.tencent.hlyyb.downloader.b.b)localObject3).e).append(",").append(((com.tencent.hlyyb.downloader.b.b)localObject3).f).append(",");
    localObject3 = ((List)localObject2).iterator();
    do
    {
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
    } while (!((com.tencent.hlyyb.downloader.b.c)((Iterator)localObject3).next()).c);
    for (int i2 = 1;; i2 = 0)
    {
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          i1 = i3;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (((com.tencent.hlyyb.downloader.b.c)((Iterator)localObject2).next()).c);
      }
      for (int i1 = 0;; i1 = 0)
      {
        i3 = ((h)localObject1).b();
        localObject2 = localStringBuilder.append(0).append(",");
        if (i2 != 0)
        {
          localObject1 = "1";
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(",");
          if (i1 == 0) {
            break label339;
          }
          localObject1 = "1";
          label267:
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(",").append(i3).append(",");
          if (l1 <= 0L) {
            break label347;
          }
        }
        label339:
        label347:
        for (localObject1 = Long.valueOf(l1);; localObject1 = "0")
        {
          ((StringBuilder)localObject2).append(localObject1).append(",").append(i4);
          return localStringBuilder.toString();
          localObject1 = "0";
          break;
          localObject1 = "0";
          break label267;
        }
      }
    }
  }
  
  public final String r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ak.size() > 0)
    {
      Iterator localIterator = this.ak.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((com.tencent.hlyyb.downloader.b.c)localIterator.next()).g.toString()).append(";");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public final void removeAllListeners()
  {
    this.T.b();
  }
  
  public final void removeListener(DownloaderTaskListener paramDownloaderTaskListener)
  {
    this.T.b(paramDownloaderTaskListener);
  }
  
  public final boolean resume()
  {
    synchronized (this.T)
    {
      DownloaderTaskStatus localDownloaderTaskStatus = this.T.a();
      if ((localDownloaderTaskStatus == DownloaderTaskStatus.STARTED) || (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING) || (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE) || (localDownloaderTaskStatus == DownloaderTaskStatus.PENDING)) {
        return true;
      }
      if ((localDownloaderTaskStatus == DownloaderTaskStatus.DELETED) || (this.T.e())) {
        return false;
      }
      this.K = false;
      this.S = false;
      this.k = true;
      this.q = 0;
      this.D = false;
      c();
      return true;
    }
  }
  
  public final void run()
  {
    this.r = 0;
    this.s = "";
    this.t = System.currentTimeMillis();
    this.u = SystemClock.elapsedRealtime();
    this.as = 0L;
    this.ak.clear();
    this.al.clear();
    this.am.clear();
    this.ao.set(0);
    this.ap.set(0);
    this.ar = new com.tencent.hlyyb.downloader.b.b();
    this.ag = 0L;
    synchronized (this.ad)
    {
      this.g = -1L;
      this.w = false;
      this.z = -1;
      this.p.set(0L);
      if (this.S) {
        return;
      }
    }
    this.T.c();
    this.N = new com.tencent.hlyyb.downloader.e.a.a();
    this.V = new a(this);
    this.V.a();
    boolean bool = z();
    this.T.a(DownloaderTaskStatus.STARTED);
    this.ae = new com.tencent.hlyyb.downloader.e.c.a();
    a(com.tencent.hlyyb.common.a.a.g(), com.tencent.hlyyb.common.a.a.b());
    if (!bool)
    {
      a(false, this.r, this.s, DownloaderTaskStatus.FAILED);
      this.T.d();
      if (this.N != null) {
        this.N.c();
      }
      E();
      if (!this.U) {
        break label378;
      }
      x();
      v();
      if (this.G) {
        w();
      }
    }
    for (;;)
    {
      G();
      this.p.set(0L);
      this.ae = null;
      ??? = this.ad;
      ((k)???).a = null;
      ((k)???).b = null;
      return;
      if (this.M.e())
      {
        this.I = this.M.a;
        C();
        break;
      }
      ??? = this.ad.b();
      if (((f)???).a == 0) {
        break;
      }
      a(false, ((f)???).a, ((f)???).b, DownloaderTaskStatus.FAILED);
      break;
      label378:
      if ((isCompleted()) || (this.r == -75)) {
        x();
      }
    }
  }
  
  public final String s()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ak.size() > 0)
    {
      Iterator localIterator = this.ak.iterator();
      while (localIterator.hasNext())
      {
        String str = ((com.tencent.hlyyb.downloader.b.c)localIterator.next()).b();
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append(str).append(";");
        }
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
    }
    return localStringBuilder.toString();
  }
  
  public final void setApkId(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.d = str;
  }
  
  public final void setAppId(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.c = str;
  }
  
  public final void setAppScene(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.y = str;
  }
  
  public final void setBakUrl(String paramString)
  {
    this.E.a(paramString);
  }
  
  public final void setCategory(DownloaderTaskCategory paramDownloaderTaskCategory)
  {
    if (paramDownloaderTaskCategory != null) {
      this.F = paramDownloaderTaskCategory;
    }
  }
  
  public final void setFullApkSize(long paramLong)
  {
    this.A = paramLong;
  }
  
  public final void setId(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.b = str;
  }
  
  public final void setMultiSectionOn(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public final void setNotPreOccupySpace() {}
  
  public final void setNotUseTempFile()
  {
    this.G = false;
  }
  
  public final void setPauseTaskOnMobile(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public final void setPriority(DownloaderTaskPriority paramDownloaderTaskPriority)
  {
    if (this.H != paramDownloaderTaskPriority) {
      this.H = paramDownloaderTaskPriority;
    }
  }
  
  public final void setReportMd5(boolean paramBoolean)
  {
    this.ai = paramBoolean;
  }
  
  public final void setTag(Object paramObject)
  {
    this.ab = paramObject;
  }
  
  public final void setType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void t()
  {
    if (!this.ai) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.h, this.J);
    } while (!localFile.exists());
    try
    {
      com.tencent.hlyyb.common.b.a.a(localFile);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final int u()
  {
    return this.E.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.i
 * JD-Core Version:    0.7.0.1
 */