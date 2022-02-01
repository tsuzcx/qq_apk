package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Message;
import android.util.Base64;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cs
  extends dj
  implements du.a, Runnable
{
  private volatile boolean c = false;
  private List<String> d = new ArrayList();
  private dc e = new dc((byte)0);
  private volatile dd f;
  private File g;
  private String h = "wf4_bf";
  private String i = "wf4";
  private StringBuilder j = new StringBuilder(100);
  
  public cs(File paramFile)
  {
    this.g = paramFile;
    paramFile = new StringBuilder("data dir:");
    paramFile.append(this.g.getAbsolutePath());
    co.a(paramFile.toString());
  }
  
  private String a(ScanResult paramScanResult)
  {
    this.j.setLength(0);
    try
    {
      StringBuilder localStringBuilder = this.j;
      localStringBuilder.append(paramScanResult.BSSID);
      localStringBuilder.append(',');
      localStringBuilder = this.j;
      localStringBuilder.append(Base64.encodeToString(paramScanResult.SSID.getBytes("UTF-8"), 2));
      localStringBuilder.append(',');
      localStringBuilder = this.j;
      localStringBuilder.append(paramScanResult.frequency);
      localStringBuilder.append(',');
      this.j.append(Base64.encodeToString(paramScanResult.capabilities.getBytes("UTF-8"), 2));
    }
    catch (Throwable paramScanResult)
    {
      label104:
      break label104;
    }
    this.j.setLength(0);
    return this.j.toString();
  }
  
  private void a(List<String> paramList)
  {
    if ((!this.c) && (!co.a(paramList)))
    {
      int k;
      if (this.f == null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        return;
      }
      long l = this.f.b().length();
      co.a("wf file len:".concat(String.valueOf(l)));
      if (l <= 51200L)
      {
        ??? = new StringBuilder(500);
        ((StringBuilder)???).append("1|");
        ((StringBuilder)???).append(paramList.size());
        Object localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(str);
        }
        localObject2 = this.f;
        String str = ((StringBuilder)???).toString();
        synchronized (((dd)localObject2).a)
        {
          ((dd)localObject2).b.append(str);
          if (((dd)localObject2).b.length() >= ((dd)localObject2).c)
          {
            ((dd)localObject2).a(((dd)localObject2).b.toString().getBytes("UTF-8"));
            ((dd)localObject2).b.setLength(0);
          }
        }
      }
      paramList.clear();
    }
  }
  
  public final int a()
  {
    a(100, 0L);
    return 0;
  }
  
  public final void a(Message paramMessage)
  {
    if (this.g == null) {
      return;
    }
    int k = paramMessage.what;
    boolean bool2 = false;
    Object localObject1;
    long l1;
    long l2;
    switch (k)
    {
    default: 
      return;
    case 102: 
      paramMessage = ((List)paramMessage.obj).iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (ScanResult)paramMessage.next();
        if (!this.e.b(((ScanResult)localObject1).BSSID))
        {
          this.e.a(((ScanResult)localObject1).BSSID);
          localObject1 = a((ScanResult)localObject1);
          this.d.add(localObject1);
        }
      }
      paramMessage = new StringBuilder("wf list size:");
      paramMessage.append(this.d.size());
      co.a(paramMessage.toString());
      if (this.d.size() < 30) {
        return;
      }
      a(this.d);
      return;
    case 101: 
      a(this.d);
      co.a(new File(this.g, this.h), this.e.a());
      if (this.f != null)
      {
        this.f.a();
        this.f = null;
      }
    case 103: 
      if (f()) {
        a(103, 1800000L);
      }
      l1 = System.currentTimeMillis();
      l2 = ((Long)dy.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(0L))).longValue();
      paramMessage = dv.a(dp.a());
      if (paramMessage != dv.a.c)
      {
        bool1 = bool2;
        if (paramMessage != dv.a.b) {
          break label325;
        }
        if (!cu.f)
        {
          bool1 = bool2;
          if (!cu.g) {
            break label325;
          }
        }
      }
      boolean bool1 = true;
      localObject1 = new StringBuilder("lastUpT:");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(",deltaT:");
      long l3 = l1 - l2;
      ((StringBuilder)localObject1).append(l3);
      ((StringBuilder)localObject1).append(",network status:");
      ((StringBuilder)localObject1).append(paramMessage);
      ((StringBuilder)localObject1).append(",isUpload:");
      ((StringBuilder)localObject1).append(bool1);
      co.a(((StringBuilder)localObject1).toString());
      if (!bool1) {
        return;
      }
      if ((l2 != 0L) && (l3 >= 86400000L))
      {
        ds.a("th_loc_task_t_consume", this);
        dy.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
        return;
      }
      if (l2 == 0L) {
        dy.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
      }
      return;
    case 100: 
      label325:
      this.f = new dd(new File(this.g, this.i));
      this.f.a(this);
      localObject1 = co.a(new File(this.g, this.h));
      l1 = ((Long)dy.b("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(0L))).longValue();
      l2 = System.currentTimeMillis();
      if ((l2 - l1 < 2592000000L) && (!co.b((byte[])localObject1)))
      {
        dc localdc = this.e;
        paramMessage = localdc.a;
        if (localObject1 != null) {}
        try
        {
          k = Math.min(localObject1.length, localdc.b.length);
          System.arraycopy(localObject1, 0, localdc.b, 0, k);
          co.a("bf init.");
        }
        finally {}
      }
      else
      {
        dy.a("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(l2));
        co.a("bf reset.");
      }
      a(103, 300000L);
    }
    co.a(new File(this.g, this.h), this.e.a());
    a(104, 300000L);
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = dr.a(co.a(paramArrayOfByte), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
    if (!co.b(paramArrayOfByte))
    {
      paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
      if (!co.b(paramArrayOfByte))
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayOfByte);
        localStringBuilder.append('$');
        paramArrayOfByte = localStringBuilder.toString();
      }
    }
    try
    {
      paramArrayOfByte = paramArrayOfByte.getBytes("UTF-8");
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      label75:
      break label75;
    }
    return new byte[0];
  }
  
  public final void b()
  {
    a(101, 0L);
  }
  
  public final String c()
  {
    return "WifiInfoPro";
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 31	c/t/m/g/cs:c	Z
    //   5: aload_0
    //   6: getfield 131	c/t/m/g/cs:f	Lc/t/m/g/dd;
    //   9: ifnull +15 -> 24
    //   12: aload_0
    //   13: getfield 131	c/t/m/g/cs:f	Lc/t/m/g/dd;
    //   16: invokevirtual 230	c/t/m/g/dd:a	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 131	c/t/m/g/cs:f	Lc/t/m/g/dd;
    //   24: new 67	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: getfield 60	c/t/m/g/cs:g	Ljava/io/File;
    //   32: aload_0
    //   33: getfield 39	c/t/m/g/cs:i	Ljava/lang/String;
    //   36: invokespecial 222	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_3
    //   40: new 41	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 364
    //   47: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 367	java/io/File:getName	()Ljava/lang/String;
    //   56: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_2
    //   61: ldc_w 369
    //   64: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: aload_3
    //   70: invokevirtual 141	java/io/File:length	()J
    //   73: invokevirtual 284	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_2
    //   78: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 83	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   84: aload_3
    //   85: invokestatic 316	c/t/m/g/co:a	(Ljava/io/File;)[B
    //   88: invokestatic 345	c/t/m/g/co:a	([B)[B
    //   91: astore 4
    //   93: getstatic 371	c/t/m/g/cu:h	Z
    //   96: istore_1
    //   97: ldc_w 373
    //   100: astore_2
    //   101: getstatic 375	c/t/m/g/cu:e	Z
    //   104: ifne +16 -> 120
    //   107: ldc_w 373
    //   110: ldc_w 377
    //   113: ldc_w 379
    //   116: invokevirtual 383	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   119: astore_2
    //   120: getstatic 386	c/t/m/g/cu:j	Lc/t/m/g/df;
    //   123: aload_2
    //   124: aload 4
    //   126: new 388	c/t/m/g/cs$1
    //   129: dup
    //   130: aload_0
    //   131: aload_3
    //   132: invokespecial 391	c/t/m/g/cs$1:<init>	(Lc/t/m/g/cs;Ljava/io/File;)V
    //   135: invokeinterface 396 4 0
    //   140: pop
    //   141: aload_0
    //   142: invokevirtual 232	c/t/m/g/cs:f	()Z
    //   145: ifeq +37 -> 182
    //   148: aload_0
    //   149: new 133	c/t/m/g/dd
    //   152: dup
    //   153: new 67	java/io/File
    //   156: dup
    //   157: aload_0
    //   158: getfield 60	c/t/m/g/cs:g	Ljava/io/File;
    //   161: aload_0
    //   162: getfield 39	c/t/m/g/cs:i	Ljava/lang/String;
    //   165: invokespecial 222	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   168: invokespecial 310	c/t/m/g/dd:<init>	(Ljava/io/File;)V
    //   171: putfield 131	c/t/m/g/cs:f	Lc/t/m/g/dd;
    //   174: aload_0
    //   175: getfield 131	c/t/m/g/cs:f	Lc/t/m/g/dd;
    //   178: aload_0
    //   179: invokevirtual 313	c/t/m/g/dd:a	(Lc/t/m/g/du$a;)V
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 31	c/t/m/g/cs:c	Z
    //   187: return
    //   188: astore_2
    //   189: goto +17 -> 206
    //   192: astore_2
    //   193: ldc_w 398
    //   196: aload_2
    //   197: invokestatic 401	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload_0
    //   201: iconst_0
    //   202: putfield 31	c/t/m/g/cs:c	Z
    //   205: return
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 31	c/t/m/g/cs:c	Z
    //   211: aload_2
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	cs
    //   96	1	1	bool	boolean
    //   50	74	2	localObject1	Object
    //   188	1	2	localObject2	Object
    //   192	20	2	localThrowable	Throwable
    //   39	93	3	localFile	File
    //   91	34	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	24	188	finally
    //   24	97	188	finally
    //   101	120	188	finally
    //   120	182	188	finally
    //   193	200	188	finally
    //   0	24	192	java/lang/Throwable
    //   24	97	192	java/lang/Throwable
    //   101	120	192	java/lang/Throwable
    //   120	182	192	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cs
 * JD-Core Version:    0.7.0.1
 */