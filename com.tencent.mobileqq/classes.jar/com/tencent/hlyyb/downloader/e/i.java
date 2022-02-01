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
  public long A;
  public boolean B;
  public boolean C;
  public boolean D;
  private com.tencent.hlyyb.downloader.e.d.c E;
  private DownloaderTaskCategory F = DownloaderTaskCategory.Cate_DefaultMass;
  private boolean G = true;
  private volatile DownloaderTaskPriority H = DownloaderTaskPriority.NORMAL;
  private volatile long I;
  private String J;
  private boolean K;
  private long L;
  private h M;
  private com.tencent.hlyyb.downloader.e.a.a N;
  private File O;
  private RandomAccessFile P;
  private File Q;
  private RandomAccessFile R;
  private volatile boolean S;
  private d T;
  private boolean U;
  private a V;
  private int W;
  private volatile boolean X;
  private AtomicInteger Y;
  private Object Z;
  public int a = -1;
  private volatile boolean aa;
  private Object ab;
  private boolean ac;
  private k ad;
  private com.tencent.hlyyb.downloader.e.c.a ae;
  private com.tencent.hlyyb.common.a.e af;
  private long ag;
  private String ah;
  private boolean ai;
  private volatile HashMap<String, Long> aj;
  private List<com.tencent.hlyyb.downloader.b.c> ak;
  private Map<com.tencent.hlyyb.downloader.e.d.a, com.tencent.hlyyb.downloader.b.c> al;
  private Map<com.tencent.hlyyb.downloader.e.d.a, List<String>> am;
  private volatile long an;
  private AtomicInteger ao;
  private AtomicInteger ap;
  private Object aq;
  private com.tencent.hlyyb.downloader.b.b ar;
  private long as;
  private long at;
  private int au;
  public String b = "";
  public String c = "";
  public String d = "";
  public Map<String, String> e = new HashMap();
  public long f;
  public volatile long g;
  public String h;
  public String i;
  public volatile long j;
  public volatile boolean k;
  public String l;
  public String m;
  public String n;
  public AtomicLong o;
  public AtomicLong p;
  public volatile int q;
  public volatile int r;
  public String s;
  public long t;
  public long u;
  public long v;
  public boolean w;
  public String x;
  public String y;
  public int z;
  
  public i(com.tencent.hlyyb.downloader.e.d.c paramc, String paramString1, String paramString2, DownloaderTaskListener paramDownloaderTaskListener, long paramLong, String paramString3)
  {
    long l1 = -1L;
    this.f = -1L;
    this.g = -1L;
    this.I = 0L;
    this.h = "";
    this.i = "";
    this.J = "";
    this.j = 0L;
    this.k = true;
    this.l = "";
    this.m = "";
    this.n = null;
    this.o = new AtomicLong(0L);
    this.p = new AtomicLong(0L);
    this.q = 0;
    this.K = false;
    this.r = 0;
    this.s = "";
    this.L = -1L;
    this.t = -1L;
    this.u = -1L;
    this.v = -1L;
    this.S = false;
    this.T = new d(this);
    this.U = false;
    this.W = 0;
    this.X = false;
    this.Y = new AtomicInteger(0);
    this.Z = new Object();
    this.aa = false;
    this.w = false;
    this.x = "";
    this.ac = false;
    this.ad = new k(this, (byte)0);
    this.z = -1;
    this.A = 0L;
    this.ag = 0L;
    this.B = true;
    this.ah = "";
    this.ai = false;
    this.C = false;
    this.D = false;
    this.aj = new LinkedHashMap();
    this.ak = Collections.synchronizedList(new ArrayList());
    this.al = new ConcurrentHashMap();
    this.am = new ConcurrentHashMap();
    this.an = -1L;
    this.ao = new AtomicInteger(0);
    this.ap = new AtomicInteger(0);
    this.aq = new Object();
    this.ar = new com.tencent.hlyyb.downloader.b.b();
    this.as = 0L;
    this.at = 0L;
    this.au = -1;
    this.E = paramc;
    this.h = paramString1;
    this.i = paramString2;
    this.T.a(paramDownloaderTaskListener);
    if (paramLong > 0L) {
      l1 = paramLong;
    }
    this.f = l1;
    TextUtils.isEmpty(paramString3);
    paramc = new StringBuilder("");
    paramc.append(com.tencent.hlyyb.common.b.b.b());
    paramc.append(com.tencent.hlyyb.common.b.b.c());
    paramc.append(System.currentTimeMillis());
    paramc.append(this.E.a.a);
    paramc.append(com.tencent.hlyyb.common.b.b.a());
    this.n = com.tencent.hlyyb.common.b.a.a(paramc.toString());
  }
  
  private boolean A()
  {
    int i1;
    label688:
    label819:
    label842:
    label847:
    label854:
    label859:
    synchronized (getClass())
    {
      this.aj.put("point0", Long.valueOf(0L));
      long l1 = System.currentTimeMillis();
      new File(this.h).mkdirs();
      Object localObject3;
      if (!com.tencent.hlyyb.downloader.a.a.g(this.i))
      {
        this.J = f.a(this.E.a.a, this.l, this.m, "");
        localObject1 = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
        localObject3 = new File(this.h, this.J);
        if ((((File)localObject1).exists()) || (((File)localObject3).exists()))
        {
          i1 = this.J.lastIndexOf(".");
          if ((i1 > 0) && (this.J.length() > i1 + 1))
          {
            localObject3 = this.J.substring(0, i1);
            localObject1 = this.J.substring(i1);
            break label842;
          }
          localObject3 = this.J;
          localObject1 = "";
          break label842;
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append("(");
          ((StringBuilder)localObject4).append(i1);
          ((StringBuilder)localObject4).append(")");
          ((StringBuilder)localObject4).append((String)localObject1);
          localObject4 = ((StringBuilder)localObject4).toString();
          File localFile1 = new File(this.h, com.tencent.hlyyb.downloader.a.a.f((String)localObject4));
          File localFile2 = new File(this.h, (String)localObject4);
          if ((localFile1.exists()) || (localFile2.exists())) {
            break label847;
          }
          this.J = ((String)localObject4);
        }
      }
      else
      {
        this.J = this.i;
      }
      this.aj.put("point1", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
      l1 = System.currentTimeMillis();
      if (this.G) {}
      for (Object localObject1 = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));; localObject1 = new File(this.h, this.J))
      {
        this.O = ((File)localObject1);
        break;
      }
      this.Q = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
      int i2 = 1;
      i1 = 1;
      try
      {
        this.R = new j(this.Q, "rw");
        this.aj.put("point2", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        l1 = System.currentTimeMillis();
        try
        {
          this.P = new j(this.O, "rw");
          this.aj.put("point3", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          l1 = System.currentTimeMillis();
          this.aj.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          System.currentTimeMillis();
          return true;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          this.r = -49;
          localObject3 = new StringBuilder("initFileOnDetected...create RandomAccessFile of path:");
          ((StringBuilder)localObject3).append(this.O.getAbsolutePath());
          ((StringBuilder)localObject3).append(" fail.|");
          ((StringBuilder)localObject3).append(localException1);
          this.s = ((StringBuilder)localObject3).toString();
          if (f.a(localException1))
          {
            this.r = -12;
            break label688;
          }
          if (!(localException1 instanceof IOException)) {
            break label854;
          }
        }
        String str1 = localException1.getMessage();
        if ((str1 == null) || (!str1.contains("Read-only file system"))) {
          break label854;
        }
        if (i1 != 0) {
          this.r = -13;
        }
        E();
        return false;
      }
      catch (Exception localException2)
      {
        this.r = -49;
        localObject3 = new StringBuilder("initFileOnDetected...create RandomAccessFile of path:");
        ((StringBuilder)localObject3).append(this.Q.getAbsolutePath());
        ((StringBuilder)localObject3).append(" fail.|");
        ((StringBuilder)localObject3).append(localException2);
        this.s = ((StringBuilder)localObject3).toString();
        if (f.a(localException2))
        {
          this.r = -12;
          break label819;
        }
        if (!(localException2 instanceof IOException)) {
          break label859;
        }
      }
      String str2 = localException2.getMessage();
      if ((str2 != null) && (str2.contains("Read-only file system")))
      {
        i1 = i2;
        if (i1 != 0) {
          this.r = -13;
        }
        E();
        return false;
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
    I();
    int i2;
    label178:
    synchronized (this.T)
    {
      if (this.T.a() != DownloaderTaskStatus.PAUSED)
      {
        if (!this.G) {
          break label178;
        }
        int i1 = 0;
        boolean bool;
        for (i2 = 0; i1 < 3; i2 = bool)
        {
          File localFile1 = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
          File localFile2 = new File(this.h, this.J);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          bool = localFile1.renameTo(localFile2);
          i2 = bool;
          if (bool) {
            break;
          }
          SystemClock.sleep(50L);
          i1 += 1;
        }
        if (i2 != 0)
        {
          x();
          J();
          this.T.a(DownloaderTaskStatus.COMPLETE);
        }
        else
        {
          a(false, -72, "", DownloaderTaskStatus.FAILED);
        }
      }
      return;
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
  
  private void E()
  {
    try
    {
      RandomAccessFile localRandomAccessFile1 = this.P;
      if (localRandomAccessFile1 != null)
      {
        try
        {
          this.P.close();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
        this.P = null;
      }
      RandomAccessFile localRandomAccessFile2 = this.R;
      if (localRandomAccessFile2 != null)
      {
        try
        {
          this.R.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        this.R = null;
      }
      return;
    }
    finally {}
  }
  
  private String F()
  {
    String str2;
    try
    {
      String str1;
      if ((this.ah != null) && (this.ah.length() != 0))
      {
        str1 = this.ah;
      }
      else
      {
        this.R.seek(0L);
        str1 = this.R.readUTF();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = "";
    }
    if (TextUtils.isEmpty(str2)) {
      return "";
    }
    return str2;
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
      while (localIterator.hasNext()) {
        ((com.tencent.hlyyb.downloader.b.c)localIterator.next()).a();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
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
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (TextUtils.isEmpty(this.E.c()))
      {
        this.au = -3;
        return;
      }
      SystemClock.elapsedRealtime();
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        j localj = new j(new File(this.h, this.J), "r");
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
        localObject1 = localByteArrayOutputStream.toByteArray();
        if (com.tencent.hlyyb.common.b.b.a((byte[])localObject1)) {
          this.au = -4;
        }
        localObject1 = com.tencent.hlyyb.common.b.a.a((byte[])localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          this.au = -5;
        } else if (((String)localObject1).toLowerCase().equals(this.E.c().toLowerCase())) {
          this.au = 1;
        } else {
          this.au = 0;
        }
        SystemClock.elapsedRealtime();
      }
      catch (IOException localIOException1)
      {
        try
        {
          localByteArrayOutputStream.close();
          localj.close();
        }
        catch (IOException localIOException2)
        {
          break label287;
        }
        localIOException1 = localIOException1;
        this.au = -4;
        localIOException1.printStackTrace();
      }
    }
    else
    {
      label287:
      this.au = -3;
      return;
    }
  }
  
  private int K()
  {
    if (com.tencent.hlyyb.common.a.a.g() == 1)
    {
      if (this.g > 0L)
      {
        double d1 = this.g;
        Double.isNaN(d1);
        int i1 = (int)(d1 * 0.2D);
        if (i1 > 41943040) {
          return i1;
        }
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
    try
    {
      File localFile = new File(getSavePath());
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        return bool;
      }
      return true;
    }
    catch (Exception localException)
    {
      label28:
      break label28;
    }
    return false;
  }
  
  private boolean w()
  {
    try
    {
      File localFile = new File(getSaveDir(), com.tencent.hlyyb.downloader.a.a.f(this.J));
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        return bool;
      }
      return true;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    return false;
  }
  
  private boolean x()
  {
    try
    {
      File localFile = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        return bool;
      }
      return true;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    return false;
  }
  
  private boolean y()
  {
    int i2 = 1;
    int i1 = 1;
    try
    {
      this.R = new j(this.Q, "rw");
      StringBuilder localStringBuilder;
      try
      {
        this.P = new j(this.O, "rw");
        return true;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.r = -49;
        localStringBuilder = new StringBuilder("initFileOnStart...create RandomAccessFile of path:");
        localStringBuilder.append(this.O.getAbsolutePath());
        localStringBuilder.append(" fail.|");
        localStringBuilder.append(localException1);
        this.s = localStringBuilder.toString();
        if (f.a(localException1))
        {
          this.r = -12;
        }
        else
        {
          if ((localException1 instanceof IOException))
          {
            String str1 = localException1.getMessage();
            if ((str1 != null) && (str1.contains("Read-only file system"))) {}
          }
          else
          {
            i1 = 0;
          }
          if (i1 != 0) {
            this.r = -13;
          }
        }
        E();
        return false;
      }
      String str2;
      label276:
      return false;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      this.r = -49;
      localStringBuilder = new StringBuilder("initFileOnStart...create RandomAccessFile of path:");
      localStringBuilder.append(this.Q.getAbsolutePath());
      localStringBuilder.append(" fail.|");
      localStringBuilder.append(localException2);
      this.s = localStringBuilder.toString();
      if (f.a(localException2))
      {
        this.r = -12;
      }
      else
      {
        if ((localException2 instanceof IOException))
        {
          str2 = localException2.getMessage();
          if ((str2 != null) && (str2.contains("Read-only file system")))
          {
            i1 = i2;
            break label276;
          }
        }
        i1 = 0;
        if (i1 != 0) {
          this.r = -13;
        }
      }
      E();
    }
  }
  
  private boolean z()
  {
    try
    {
      new File(this.h).mkdirs();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.O = null;
    this.Q = null;
    Object localObject = this.M;
    if (localObject != null)
    {
      if ((((h)localObject).d() > 0L) && (!TextUtils.isEmpty(this.J)))
      {
        if (this.G) {
          localObject = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
        } else {
          localObject = new File(this.h, this.J);
        }
        this.O = ((File)localObject);
        this.Q = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
        i1 = 1;
        break label240;
      }
    }
    else if (com.tencent.hlyyb.downloader.a.a.g(this.i))
    {
      if (this.G) {
        localObject = new File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.i));
      } else {
        localObject = new File(this.h, this.i);
      }
      this.O = ((File)localObject);
      this.Q = new File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.i));
      i1 = 0;
      i2 = 1;
      break label242;
    }
    int i1 = 0;
    label240:
    int i2 = 0;
    label242:
    boolean bool2;
    if (((i1 != 0) || (i2 != 0)) && (this.O.exists()))
    {
      if (!y()) {
        return false;
      }
      localObject = F();
      this.M = new h((String)localObject);
      StringBuilder localStringBuilder;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.M.e))
      {
        long l1 = this.O.lastModified();
        boolean bool1;
        if (((i2 != 0) && (l1 >= this.M.b) && (this.M.a > 0L) && (this.M.d() <= this.M.a)) || ((i1 != 0) && (l1 >= this.M.b))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1)
        {
          if (TextUtils.isEmpty(this.J)) {
            this.J = this.i;
          }
          this.j = this.M.c;
          this.o.set(this.M.d);
          bool2 = bool1;
          if (i2 != 0)
          {
            bool2 = bool1;
            if (this.M.a > 0L)
            {
              this.w = true;
              bool2 = bool1;
            }
          }
        }
        else
        {
          localStringBuilder = new StringBuilder("resume failed. cfg:");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",flm:");
          localStringBuilder.append(l1);
          localStringBuilder.append(",from:");
          localStringBuilder.append(i2 ^ 0x1);
          this.x = localStringBuilder.toString();
          bool2 = bool1;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder("resume failed. cfg:");
        localStringBuilder.append((String)localObject);
        this.x = localStringBuilder.toString();
      }
    }
    else
    {
      bool2 = false;
    }
    if (!bool2)
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
    this.ac = bool2;
    return true;
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
    long l1;
    label349:
    synchronized (this.ad)
    {
      if (this.g == -1L)
      {
        if (paramLong > 0L) {}
        for (;;)
        {
          this.an = paramLong;
          break;
          if (this.f <= 0L) {
            break;
          }
          paramLong = this.f;
        }
      }
      l1 = this.g;
      long l2 = this.g;
      if (paramLong <= 0L)
      {
        if (this.f <= 0L) {
          break label349;
        }
        paramLong = this.f;
      }
      if (this.g != paramLong)
      {
        this.g = -1L;
        this.an = paramLong;
        if (this.M != null) {
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
      }
      return;
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
        if (l1 > K()) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          this.as = l1;
          H();
          paramc.c();
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((String)((Iterator)localObject1).next()).split(",");
          if (localObject2.length == 2)
          {
            l1 = Long.parseLong(localObject2[0]);
            long l2 = Long.parseLong(localObject2[1]);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append("-");
            ((StringBuilder)localObject2).append(l2);
            localObject2 = ((StringBuilder)localObject2).toString();
            com.tencent.hlyyb.downloader.e.b.a locala = new com.tencent.hlyyb.downloader.e.b.a(this.M, l1, l1, l1, l2);
            if (i1 == 0)
            {
              this.M.a(locala);
              paramc.a((String)localObject2);
            }
            else
            {
              paramc.b((String)localObject2);
            }
          }
        }
      }
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
    Object localObject = this.M;
    if (localObject != null)
    {
      long l1 = ((h)localObject).d();
      int i1;
      if (l1 > K()) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      long l2 = parama.d;
      long l3 = parama.f;
      parama = new StringBuilder();
      parama.append(l2);
      parama.append("-");
      parama.append(l3);
      parama = parama.toString();
      if (i1 == 0)
      {
        localObject = new com.tencent.hlyyb.downloader.e.b.a(this.M, l2, l2, l2, l3);
        this.M.a((com.tencent.hlyyb.downloader.e.b.a)localObject);
        paramc.a(parama);
        return true;
      }
      this.as = l1;
      H();
      paramc.c();
      paramc.b(parama);
    }
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
    long l2;
    boolean bool1;
    Object localObject2;
    label549:
    label552:
    long l1;
    if ((!this.S) && (!isPaused()) && (!isDeleted()) && (!isCompleted()) && (!isFailed()))
    {
      l2 = SystemClock.elapsedRealtime();
      int i2 = 0;
      for (;;)
      {
        boolean bool2 = this.S;
        int i3 = 1;
        bool1 = true;
        int i1 = 1;
        if ((!bool2) && (!isPaused()) && (!isDeleted()) && (!isCompleted()) && (!isFailed()))
        {
          if (SystemClock.elapsedRealtime() - l2 > com.tencent.hlyyb.downloader.a.a.d)
          {
            this.Y.getAndIncrement();
            break label552;
          }
          synchronized (this.aq)
          {
            Object localObject3 = this.N.b();
            if (localObject3 == null) {
              break label549;
            }
            com.tencent.hlyyb.downloader.e.b.a locala = this.M.a(((com.tencent.hlyyb.downloader.e.a.b)localObject3).a);
            if (locala == null) {
              ??? = new StringBuilder("inner error: getRange null for sectionId:");
            }
            for (;;)
            {
              ((StringBuilder)???).append(((com.tencent.hlyyb.downloader.e.a.b)localObject3).a);
              a(false, -42, ((StringBuilder)???).toString(), DownloaderTaskStatus.FAILED);
              return false;
              if (locala.e == ((com.tencent.hlyyb.downloader.e.a.b)localObject3).b) {
                break;
              }
              ??? = new StringBuilder("inner error: check offset fail for section:");
              ((StringBuilder)???).append(locala);
              ((StringBuilder)???).append(",buffer offset:");
              ((StringBuilder)???).append(((com.tencent.hlyyb.downloader.e.a.b)localObject3).b);
              ((StringBuilder)???).append(",sectionId:");
            }
            try
            {
              if (this.P.getFilePointer() != ((com.tencent.hlyyb.downloader.e.a.b)localObject3).b) {
                this.P.seek(((com.tencent.hlyyb.downloader.e.a.b)localObject3).b);
              }
              this.P.write(((com.tencent.hlyyb.downloader.e.a.b)localObject3).c, 0, (int)((com.tencent.hlyyb.downloader.e.a.b)localObject3).d);
              locala.e = (((com.tencent.hlyyb.downloader.e.a.b)localObject3).b + ((com.tencent.hlyyb.downloader.e.a.b)localObject3).d);
              i3 = (int)(i2 + ((com.tencent.hlyyb.downloader.e.a.b)localObject3).d);
              ((com.tencent.hlyyb.downloader.e.a.b)localObject3).c = null;
              i2 = i3;
              if (!this.aa) {
                continue;
              }
              if (com.tencent.hlyyb.downloader.c.b.a().f() >= 2097152L) {
                i1 = 0;
              }
              i2 = i3;
              if (i1 == 0) {
                continue;
              }
              B();
              i2 = i3;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              if ((localException instanceof NullPointerException)) {
                break label549;
              }
            }
            i1 = -50;
            if (!this.O.exists())
            {
              i1 = -14;
            }
            else if (f.a(localException))
            {
              i1 = -12;
            }
            else
            {
              if ((localException instanceof IOException))
              {
                localObject3 = localException.getMessage();
                if ((localObject3 != null) && (((String)localObject3).contains("Read-only file system"))) {}
              }
              else
              {
                i3 = 0;
              }
              if (i3 != 0) {
                i1 = -17;
              }
            }
            localObject3 = new StringBuilder("saveData fail.|");
            ((StringBuilder)localObject3).append(localException);
            a(false, i1, ((StringBuilder)localObject3).toString(), DownloaderTaskStatus.FAILED);
          }
        }
      }
      localObject2 = this.N;
      if (localObject2 != null) {
        ((com.tencent.hlyyb.downloader.e.a.a)localObject2).c();
      }
      bool1 = false;
      if (!bool1) {
        B();
      }
      l1 = SystemClock.elapsedRealtime();
      localObject2 = this.V;
      if (localObject2 != null) {
        ((a)localObject2).a(i2, (int)(l1 - l2));
      }
      if (i2 > 0) {
        D();
      }
      if ((!this.S) && (!isPaused()) && (!isDeleted()) && (!isCompleted()) && (!isFailed()))
      {
        if (this.g <= 0L) {
          break label842;
        }
        l2 = this.M.d();
        if (((l1 - this.ag > com.tencent.hlyyb.downloader.a.a.c()) || (l2 == this.g)) && ((i2 <= 0) || (this.B))) {}
      }
    }
    try
    {
      this.P.getFD().sync();
      label699:
      this.I = l2;
      this.M.a(this.I, getPercentage());
      this.T.a(DownloaderTaskStatus.DOWNLOADING);
      this.ag = l1;
      if (l2 == this.g)
      {
        this.V.c();
        this.v = l1;
        C();
        return bool1;
      }
      if (l2 > this.g)
      {
        localObject2 = new StringBuilder("inner error: receivedLength > detectLength:");
        ((StringBuilder)localObject2).append(l2);
        ((StringBuilder)localObject2).append(" > ");
        ((StringBuilder)localObject2).append(this.g);
        a(false, -42, ((StringBuilder)localObject2).toString(), DownloaderTaskStatus.FAILED);
        x();
        return bool1;
        E();
      }
      label842:
      return bool1;
      localObject2 = this.N;
      if (localObject2 != null) {
        ((com.tencent.hlyyb.downloader.e.a.a)localObject2).c();
      }
      E();
      return false;
    }
    catch (Throwable localThrowable)
    {
      break label699;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException);
      throw new HalleyException(localStringBuilder.toString());
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
    if ((this.j > 10L) && (this.g > 0L)) {
      return (int)(getReceivedLength() * 1000L / this.j);
    }
    return -1;
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
      localh = this.M;
      l1 = l2;
      if (localh != null) {
        l1 = localh.a;
      }
    }
    h localh = this.M;
    int i2 = 0;
    int i1;
    if (localh != null) {
      i1 = localh.i();
    } else {
      i1 = 0;
    }
    if (l1 > 0L) {
      i2 = (int)(getReceivedLength() * 100L / l1);
    }
    if (i1 > i2) {
      return i1;
    }
    return i2;
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
    h localh = this.M;
    if (localh != null)
    {
      long l1 = localh.h();
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
    try
    {
      localObject1 = new File(this.h, this.J).getAbsolutePath();
    }
    catch (Exception localException)
    {
      Object localObject1;
      label22:
      Object localObject2;
      break label22;
    }
    localObject1 = "";
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.h);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(this.J);
      localObject2 = ((StringBuilder)localObject1).toString();
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
    long l1 = this.f;
    if (l1 > 0L) {
      return l1;
    }
    if (this.g > 0L) {
      return this.g;
    }
    try
    {
      l1 = this.M.a;
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
    a locala = this.V;
    if (locala != null) {
      return locala.d();
    }
    return -1L;
  }
  
  public final long i()
  {
    com.tencent.hlyyb.downloader.e.a.a locala = this.N;
    if (locala != null) {
      return locala.a();
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
    h localh = this.M;
    if (localh != null) {
      return localh.g();
    }
    return 0L;
  }
  
  public final String k()
  {
    com.tencent.hlyyb.downloader.e.c.a locala = this.ae;
    if (locala != null) {
      return locala.a();
    }
    return "";
  }
  
  public final String l()
  {
    com.tencent.hlyyb.downloader.e.d.c localc = this.E;
    if (localc != null) {
      return localc.g();
    }
    return "";
  }
  
  public final String m()
  {
    k localk = this.ad;
    if (localk != null)
    {
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
    k localk = this.ad;
    if (localk != null)
    {
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
    k localk = this.ad;
    if (localk != null)
    {
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
    boolean bool = this.E.f();
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    Object localObject1;
    if (this.E.a() > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.E.a());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "0";
    }
    Object localObject2 = this.E.d();
    if ((localObject2 != null) && (((List)localObject2).size() > 0) && (!TextUtils.isEmpty(this.E.c()))) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    if (TextUtils.isEmpty(this.E.b())) {
      str2 = "0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(",");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(",");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public final void pause()
  {
    Object localObject = this.T.a();
    if ((localObject == DownloaderTaskStatus.PENDING) || (localObject == DownloaderTaskStatus.STARTED) || (localObject == DownloaderTaskStatus.DOWNLOADING))
    {
      localObject = this.M;
      if (localObject != null)
      {
        long l1 = ((h)localObject).f();
        int i1;
        if ((l1 > 0L) && (l1 == ((h)localObject).a)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          return;
        }
      }
      a(true, 0, "", DownloaderTaskStatus.PAUSED);
      try
      {
        if (this.af != null) {
          this.af.a();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public final String q()
  {
    Object localObject3 = this.ar;
    Object localObject1 = this.M;
    Object localObject2 = this.ak;
    int i4 = this.au;
    long l1 = this.as;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((com.tencent.hlyyb.downloader.b.b)localObject3).a);
    localStringBuilder.append(",");
    localStringBuilder.append(((com.tencent.hlyyb.downloader.b.b)localObject3).b);
    localStringBuilder.append(",");
    localStringBuilder.append(((com.tencent.hlyyb.downloader.b.b)localObject3).d);
    localStringBuilder.append(",");
    localStringBuilder.append(((com.tencent.hlyyb.downloader.b.b)localObject3).c);
    localStringBuilder.append(",");
    localStringBuilder.append(((com.tencent.hlyyb.downloader.b.b)localObject3).e);
    localStringBuilder.append(",");
    localStringBuilder.append(((com.tencent.hlyyb.downloader.b.b)localObject3).f);
    localStringBuilder.append(",");
    localObject3 = ((List)localObject2).iterator();
    do
    {
      boolean bool = ((Iterator)localObject3).hasNext();
      i3 = 1;
      if (!bool) {
        break;
      }
    } while (!((com.tencent.hlyyb.downloader.b.c)((Iterator)localObject3).next()).c);
    int i1 = 1;
    break label207;
    i1 = 0;
    label207:
    if (((List)localObject2).size() > 0)
    {
      localObject2 = ((List)localObject2).iterator();
      do
      {
        i2 = i3;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((com.tencent.hlyyb.downloader.b.c)((Iterator)localObject2).next()).c);
    }
    int i2 = 0;
    int i3 = ((h)localObject1).b();
    localStringBuilder.append(0);
    localStringBuilder.append(",");
    localObject3 = "1";
    localObject2 = "0";
    if (i1 != 0) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    if (i2 != 0) {
      localObject1 = localObject3;
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append(i3);
    localStringBuilder.append(",");
    localObject1 = localObject2;
    if (l1 > 0L) {
      localObject1 = Long.valueOf(l1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append(i4);
    return localStringBuilder.toString();
  }
  
  public final String r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ak.size() > 0)
    {
      Iterator localIterator = this.ak.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((com.tencent.hlyyb.downloader.b.c)localIterator.next()).g.toString());
        localStringBuilder.append(";");
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
      if ((localDownloaderTaskStatus != DownloaderTaskStatus.STARTED) && (localDownloaderTaskStatus != DownloaderTaskStatus.DOWNLOADING) && (localDownloaderTaskStatus != DownloaderTaskStatus.COMPLETE) && (localDownloaderTaskStatus != DownloaderTaskStatus.PENDING))
      {
        if ((localDownloaderTaskStatus != DownloaderTaskStatus.DELETED) && (!this.T.e()))
        {
          this.K = false;
          this.S = false;
          this.k = true;
          this.q = 0;
          this.D = false;
          c();
          return true;
        }
        return false;
      }
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
      }
      else if (this.M.e())
      {
        this.I = this.M.a;
        C();
      }
      else
      {
        ??? = this.ad.b();
        if (((f)???).a != 0) {
          a(false, ((f)???).a, ((f)???).b, DownloaderTaskStatus.FAILED);
        }
      }
      this.T.d();
      ??? = this.N;
      if (??? != null) {
        ((com.tencent.hlyyb.downloader.e.a.a)???).c();
      }
      E();
      if (this.U)
      {
        x();
        v();
        if (this.G) {
          w();
        }
      }
      else if ((isCompleted()) || (this.r == -75))
      {
        x();
      }
      G();
      this.p.set(0L);
      this.ae = null;
      ??? = this.ad;
      ((k)???).a = null;
      ((k)???).b = null;
      return;
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
        if (!TextUtils.isEmpty(str))
        {
          localStringBuilder.append(str);
          localStringBuilder.append(";");
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
    if (!this.ai) {
      return;
    }
    File localFile = new File(this.h, this.J);
    if (!localFile.exists()) {
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.i
 * JD-Core Version:    0.7.0.1
 */