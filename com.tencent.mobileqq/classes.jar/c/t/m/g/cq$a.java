package c.t.m.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

final class cq$a
  extends Handler
{
  private File a;
  private BufferedOutputStream b;
  private StringBuffer c;
  private String d = "";
  
  public cq$a(cq paramcq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private long a()
  {
    long l;
    if (cu.f) {
      l = 51200L;
    } else {
      l = 512000L;
    }
    if (cq.b(this.e) > l) {
      return l;
    }
    return cq.b(this.e);
  }
  
  private static void a(int paramInt, File paramFile)
  {
    try
    {
      if (!paramFile.isFile()) {
        return;
      }
      long l = System.currentTimeMillis();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
      ((StringBuilder)localObject1).append(".");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(".enc");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (paramInt == 4)
      {
        localObject2 = co.a(paramFile);
        if (!co.b((byte[])localObject2))
        {
          localObject2 = co.a((byte[])localObject2);
          if (!co.b((byte[])localObject2))
          {
            FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject1, true);
            localFileOutputStream.write((byte[])localObject2);
            localFileOutputStream.close();
            paramFile.delete();
          }
        }
      }
      else
      {
        paramFile.renameTo((File)localObject1);
      }
      localObject2 = new StringBuilder("rename:");
      ((StringBuilder)localObject2).append(paramFile.getName());
      ((StringBuilder)localObject2).append(" to ");
      ((StringBuilder)localObject2).append(((File)localObject1).getName());
      co.a(((StringBuilder)localObject2).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder("rename:");
      ((StringBuilder)localObject2).append(paramFile.getName());
      ((StringBuilder)localObject2).append(" error.");
      co.a(((StringBuilder)localObject2).toString(), localThrowable);
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = cq.d(this.e);
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = cq.d(this.e).listFiles();
    }
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return;
      }
      long l3 = System.currentTimeMillis();
      int j = localObject1.length;
      int i = 0;
      long l1;
      for (long l2 = 0L; i < j; l2 = l1)
      {
        File localFile = localObject1[i];
        Object localObject3 = localObject2;
        l1 = l2;
        if (localFile.exists())
        {
          localObject3 = localObject2;
          l1 = l2;
          if (localFile.isFile())
          {
            localObject3 = localObject2;
            l1 = l2;
            if (!cq.c().equals(localFile.getName())) {
              if ((l3 - localFile.lastModified() <= paramLong1) && (localFile.length() != 0L))
              {
                localObject3 = localFile.getName();
                if ((l3 - localFile.lastModified() > 172800000L) && (!((String)localObject3).endsWith(".enc")) && (((String)localObject3).startsWith(cu.a())))
                {
                  a(cu.a((String)localObject3), localFile);
                  localObject3 = localObject2;
                  l1 = l2;
                }
                else
                {
                  l2 += localFile.length();
                  if (localObject2 != null)
                  {
                    localObject3 = localObject2;
                    l1 = l2;
                    if (localObject2.lastModified() <= localFile.lastModified()) {}
                  }
                  else
                  {
                    localObject3 = localFile;
                    l1 = l2;
                  }
                }
              }
              else
              {
                localObject3 = new StringBuilder("delete expired file:");
                ((StringBuilder)localObject3).append(localFile.getName());
                ((StringBuilder)localObject3).append(",len:");
                ((StringBuilder)localObject3).append(localFile.length());
                co.a(((StringBuilder)localObject3).toString());
                localFile.delete();
                l1 = l2;
                localObject3 = localObject2;
              }
            }
          }
        }
        i += 1;
        localObject2 = localObject3;
      }
      if ((l2 >= paramLong2) && (localObject2 != null))
      {
        localObject1 = new StringBuilder("too big folder size:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(", delete ");
        ((StringBuilder)localObject1).append(localObject2.getName());
        ((StringBuilder)localObject1).append(",size:");
        ((StringBuilder)localObject1).append(localObject2.length());
        co.a(((StringBuilder)localObject1).toString());
        localObject2.delete();
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    try
    {
      Object localObject = dy.a("LocationSDK");
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      String str = ((SharedPreferences)localObject).getString("log_up_fc_date", "");
      long l = ((SharedPreferences)localObject).getLong("log_up_fc_size", 0L);
      localObject = dq.a("yyyyMMdd").format(new Date());
      if (((String)localObject).equals(str))
      {
        if (l > cq.n(this.e)) {
          return false;
        }
        localEditor.putLong("log_up_fc_size", paramLong + l);
      }
      else
      {
        localEditor.putString("log_up_fc_date", (String)localObject);
        localEditor.putLong("log_up_fc_size", paramLong);
      }
      localEditor.apply();
    }
    catch (Throwable localThrowable)
    {
      label127:
      break label127;
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = null;
    Object localObject2;
    if (bool) {
      localObject2 = null;
    } else {
      localObject2 = new File(paramString);
    }
    Object localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject3;
      if (((File)localObject2).exists()) {
        if (!((File)localObject2).isDirectory()) {
          localObject1 = localObject3;
        } else {
          localObject1 = ((File)localObject2).listFiles();
        }
      }
    }
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      long l = System.currentTimeMillis();
      int m = cq.i(this.e);
      int k = 0;
      while ((k < localObject1.length) && (m > 0))
      {
        File localFile = localObject1[k];
        if ((localFile != null) && (localFile.exists()) && (localFile.isFile())) {
          localObject2 = localFile.getName();
        } else {
          localObject2 = "";
        }
        int j;
        if (!((String)localObject2).startsWith("dc"))
        {
          j = m;
          if (!((String)localObject2).startsWith("fc")) {}
        }
        else if ((paramString.endsWith("d_c")) && ((localFile.length() == 0L) || (l - localFile.lastModified() > cq.e(this.e))))
        {
          localFile.delete();
          j = m;
        }
        else
        {
          if ((!((String)localObject2).startsWith("fc2")) && (!((String)localObject2).startsWith("fc3"))) {
            i = 0;
          } else {
            i = 1;
          }
          if (((((String)localObject2).startsWith(cu.a())) && (((String)localObject2).endsWith(".enc"))) || (i != 0)) {
            j = 1;
          } else {
            j = 0;
          }
          int i = j;
          if (j == 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(",has no ");
            ((StringBuilder)localObject3).append(cu.a());
            ((StringBuilder)localObject3).append("***.enc files!!!");
            co.a(((StringBuilder)localObject3).toString());
            if ((((String)localObject2).startsWith("dc")) && (System.currentTimeMillis() - localFile.lastModified() > 172800000L)) {
              i = 1;
            } else {
              i = 0;
            }
          }
          j = m;
          if (i != 0)
          {
            j = m;
            if (a(localFile.length()))
            {
              localObject3 = new StringBuilder("upload:");
              ((StringBuilder)localObject3).append(localFile.getName());
              ((StringBuilder)localObject3).append(",len=");
              ((StringBuilder)localObject3).append(localFile.length());
              co.a(((StringBuilder)localObject3).toString());
              i = cu.a((String)localObject2);
              j = m;
              if (i > 0)
              {
                localObject3 = cu.a(i);
                j = m;
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject2 = localObject3;
                  if (!cu.e) {
                    localObject2 = ((String)localObject3).replace("https:", "http:");
                  }
                  cq.a(this.e, localFile, (String)localObject2);
                  j = m - 1;
                }
              }
            }
          }
        }
        k += 1;
        m = j;
      }
      return m != cq.i(this.e);
    }
    if ((localObject1 != null) && (paramString.endsWith("d_c"))) {
      ((File)localObject2).delete();
    }
    return false;
  }
  
  private void b()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((StringBuffer)localObject).length() != 0))
    {
      if (this.b == null) {
        return;
      }
      localObject = cw.a(this.c.toString());
      StringBuilder localStringBuilder = new StringBuilder("write buf to file:buf:");
      localStringBuilder.append(this.c.length());
      localStringBuilder.append(",enc:");
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = localObject.length;
      }
      localStringBuilder.append(i);
      co.a(localStringBuilder.toString());
      this.c.setLength(0);
      if ((localObject != null) && (localObject.length != 0)) {
        try
        {
          this.b.write((byte[])localObject);
          this.b.write(36);
          this.b.flush();
          return;
        }
        catch (Throwable localThrowable)
        {
          co.a("write file failed.", localThrowable);
          this.a = null;
          dt.a(this.b);
          return;
        }
      }
      co.a("enc result is null or len = 0");
    }
  }
  
  private void c()
  {
    try
    {
      if (this.b != null) {
        this.b.flush();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    this.a = null;
    dt.a(this.b);
  }
  
  private void d()
  {
    File localFile = this.a;
    if ((localFile == null) || (!localFile.exists()) || (this.b == null) || (!cq.c().equals(this.a.getName())))
    {
      this.a = e();
      try
      {
        boolean bool = this.a.exists();
        this.b = new BufferedOutputStream(new FileOutputStream(this.a, true), 1024);
        if (!bool) {
          dy.a("LocationSDK", "log_fc_create", Long.valueOf(System.currentTimeMillis()));
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        co.a("open file error", localThrowable);
      }
    }
  }
  
  private File e()
  {
    File localFile = cq.d(this.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, cq.c());
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: new 58	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 361
    //   7: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore 7
    //   12: aload 7
    //   14: aload_1
    //   15: getfield 367	android/os/Message:what	I
    //   18: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 7
    //   24: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 122	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   30: aload_1
    //   31: getfield 367	android/os/Message:what	I
    //   34: tableswitch	default:+902 -> 936, 101:+556->590, 102:+556->590, 103:+506->540, 104:+501->535, 105:+372->406, 106:+83->117, 107:+42->76
    //   77: bipush 107
    //   79: invokevirtual 370	c/t/m/g/cq$a:removeMessages	(I)V
    //   82: aload_0
    //   83: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   86: aload_0
    //   87: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   90: invokestatic 373	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   93: invokestatic 376	c/t/m/g/cq:a	(Lc/t/m/g/cq;Landroid/os/Handler;)V
    //   96: aload_0
    //   97: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   100: invokestatic 373	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   103: bipush 107
    //   105: aload_0
    //   106: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   109: invokestatic 379	c/t/m/g/cq:h	(Lc/t/m/g/cq;)J
    //   112: invokestatic 382	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   115: pop
    //   116: return
    //   117: aload_0
    //   118: invokespecial 384	c/t/m/g/cq$a:d	()V
    //   121: aload_0
    //   122: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   125: invokestatic 131	c/t/m/g/cq:d	(Lc/t/m/g/cq;)Ljava/io/File;
    //   128: ifnull +277 -> 405
    //   131: aload_0
    //   132: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   135: ifnull +270 -> 405
    //   138: aload_0
    //   139: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   142: invokevirtual 138	java/io/File:exists	()Z
    //   145: ifne +4 -> 149
    //   148: return
    //   149: aload_0
    //   150: invokespecial 386	c/t/m/g/cq$a:b	()V
    //   153: ldc 181
    //   155: ldc_w 340
    //   158: lconst_0
    //   159: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   162: invokestatic 389	c/t/m/g/dy:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast 342	java/lang/Long
    //   168: invokevirtual 392	java/lang/Long:longValue	()J
    //   171: lstore_3
    //   172: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   175: lstore 5
    //   177: new 58	java/lang/StringBuilder
    //   180: dup
    //   181: ldc_w 394
    //   184: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: astore_1
    //   188: aload_1
    //   189: aload_0
    //   190: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   193: invokevirtual 152	java/io/File:length	()J
    //   196: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_1
    //   201: ldc_w 396
    //   204: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_1
    //   209: aload_0
    //   210: invokespecial 398	c/t/m/g/cq$a:a	()J
    //   213: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_1
    //   218: ldc_w 400
    //   221: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_1
    //   226: lload 5
    //   228: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_1
    //   233: ldc_w 402
    //   236: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_1
    //   241: lload_3
    //   242: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_1
    //   247: ldc_w 404
    //   250: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: aload_0
    //   256: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   259: invokestatic 407	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   262: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_1
    //   267: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 122	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   273: aload_0
    //   274: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   277: invokevirtual 152	java/io/File:length	()J
    //   280: aload_0
    //   281: invokespecial 398	c/t/m/g/cq$a:a	()J
    //   284: lcmp
    //   285: ifgt +18 -> 303
    //   288: lload 5
    //   290: lload_3
    //   291: lsub
    //   292: aload_0
    //   293: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   296: invokestatic 407	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   299: lcmp
    //   300: ifle +622 -> 922
    //   303: ldc_w 409
    //   306: invokestatic 122	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   309: aload_0
    //   310: invokespecial 411	c/t/m/g/cq$a:c	()V
    //   313: aload_0
    //   314: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   317: ifnull +57 -> 374
    //   320: aload_0
    //   321: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   324: invokevirtual 152	java/io/File:length	()J
    //   327: ldc2_w 412
    //   330: lcmp
    //   331: ifge +6 -> 337
    //   334: goto +40 -> 374
    //   337: aload_0
    //   338: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   341: invokestatic 330	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   344: aload_0
    //   345: aconst_null
    //   346: putfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   349: iconst_4
    //   350: aload_0
    //   351: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   354: invokestatic 168	c/t/m/g/cq$a:a	(ILjava/io/File;)V
    //   357: aload_0
    //   358: aconst_null
    //   359: putfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   362: ldc 181
    //   364: ldc_w 340
    //   367: lconst_0
    //   368: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   371: invokestatic 349	c/t/m/g/dy:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   374: aload_0
    //   375: aload_0
    //   376: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   379: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   382: aload_0
    //   383: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   386: invokestatic 415	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   389: invokespecial 417	c/t/m/g/cq$a:a	(JJ)V
    //   392: getstatic 33	c/t/m/g/cu:f	Z
    //   395: ifeq +527 -> 922
    //   398: aload_0
    //   399: bipush 107
    //   401: invokevirtual 421	c/t/m/g/cq$a:sendEmptyMessage	(I)Z
    //   404: pop
    //   405: return
    //   406: aload_0
    //   407: invokespecial 386	c/t/m/g/cq$a:b	()V
    //   410: aload_0
    //   411: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   414: ifnull +11 -> 425
    //   417: aload_0
    //   418: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   421: iconst_0
    //   422: invokevirtual 313	java/lang/StringBuffer:setLength	(I)V
    //   425: aload_0
    //   426: aconst_null
    //   427: putfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   430: aload_0
    //   431: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   434: invokestatic 330	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   437: aload_0
    //   438: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   441: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   444: lstore_3
    //   445: aload_0
    //   446: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   449: invokestatic 415	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   452: lstore 5
    //   454: aload_0
    //   455: lload_3
    //   456: lload 5
    //   458: invokespecial 417	c/t/m/g/cq$a:a	(JJ)V
    //   461: goto +68 -> 529
    //   464: astore_1
    //   465: aload_0
    //   466: aconst_null
    //   467: putfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   470: aload_0
    //   471: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   474: invokestatic 330	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   477: aload_0
    //   478: aload_0
    //   479: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   482: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   485: aload_0
    //   486: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   489: invokestatic 415	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   492: invokespecial 417	c/t/m/g/cq$a:a	(JJ)V
    //   495: aload_1
    //   496: athrow
    //   497: aload_0
    //   498: aconst_null
    //   499: putfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   502: aload_0
    //   503: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   506: invokestatic 330	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   509: aload_0
    //   510: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   513: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   516: lstore_3
    //   517: aload_0
    //   518: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   521: invokestatic 415	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   524: lstore 5
    //   526: goto -72 -> 454
    //   529: aload_0
    //   530: aconst_null
    //   531: invokevirtual 425	c/t/m/g/cq$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   534: return
    //   535: aload_0
    //   536: invokespecial 411	c/t/m/g/cq$a:c	()V
    //   539: return
    //   540: ldc_w 427
    //   543: invokestatic 122	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   546: aload_0
    //   547: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   550: invokestatic 430	c/t/m/g/cq:c	(Lc/t/m/g/cq;)Z
    //   553: ifeq +369 -> 922
    //   556: aload_0
    //   557: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   560: invokestatic 131	c/t/m/g/cq:d	(Lc/t/m/g/cq;)Ljava/io/File;
    //   563: invokevirtual 65	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   566: astore_1
    //   567: aload_0
    //   568: aload_1
    //   569: invokespecial 432	c/t/m/g/cq$a:a	(Ljava/lang/String;)Z
    //   572: ifne +350 -> 922
    //   575: aload_0
    //   576: aload_1
    //   577: ldc_w 434
    //   580: ldc 255
    //   582: invokevirtual 437	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   585: invokespecial 432	c/t/m/g/cq$a:a	(Ljava/lang/String;)Z
    //   588: pop
    //   589: return
    //   590: aload_1
    //   591: getfield 367	android/os/Message:what	I
    //   594: istore_2
    //   595: aload_0
    //   596: invokespecial 384	c/t/m/g/cq$a:d	()V
    //   599: ldc 23
    //   601: astore 7
    //   603: iload_2
    //   604: bipush 102
    //   606: if_icmpne +28 -> 634
    //   609: getstatic 440	c/t/m/g/cu:i	Lc/t/m/g/dt;
    //   612: aload_0
    //   613: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   616: invokestatic 444	c/t/m/g/cq:j	(Lc/t/m/g/cq;)Landroid/location/Location;
    //   619: aconst_null
    //   620: aload_0
    //   621: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   624: invokestatic 448	c/t/m/g/cq:k	(Lc/t/m/g/cq;)Ljava/util/List;
    //   627: invokestatic 453	c/t/m/g/cv:a	(Lc/t/m/g/dt;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   630: astore_1
    //   631: goto +55 -> 686
    //   634: aload 7
    //   636: astore_1
    //   637: iload_2
    //   638: bipush 101
    //   640: if_icmpne +46 -> 686
    //   643: aload_0
    //   644: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   647: invokestatic 456	c/t/m/g/cq:l	(Lc/t/m/g/cq;)Ljava/util/List;
    //   650: astore 8
    //   652: aload 7
    //   654: astore_1
    //   655: aload 8
    //   657: invokestatic 459	c/t/m/g/co:a	(Ljava/util/Collection;)Z
    //   660: ifne +26 -> 686
    //   663: getstatic 440	c/t/m/g/cu:i	Lc/t/m/g/dt;
    //   666: aload_0
    //   667: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   670: invokestatic 444	c/t/m/g/cq:j	(Lc/t/m/g/cq;)Landroid/location/Location;
    //   673: aload 8
    //   675: aload_0
    //   676: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   679: invokestatic 448	c/t/m/g/cq:k	(Lc/t/m/g/cq;)Ljava/util/List;
    //   682: invokestatic 453	c/t/m/g/cv:a	(Lc/t/m/g/dt;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   685: astore_1
    //   686: aload_0
    //   687: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   690: ifnull +223 -> 913
    //   693: aload_1
    //   694: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   697: ifne +216 -> 913
    //   700: aload_1
    //   701: invokevirtual 460	java/lang/String:length	()I
    //   704: bipush 25
    //   706: if_icmpge +4 -> 710
    //   709: return
    //   710: aload_1
    //   711: bipush 22
    //   713: invokevirtual 463	java/lang/String:substring	(I)Ljava/lang/String;
    //   716: invokevirtual 467	java/lang/String:getBytes	()[B
    //   719: ldc_w 469
    //   722: invokestatic 472	c/t/m/g/co:a	([BLjava/lang/String;)Ljava/lang/String;
    //   725: astore 7
    //   727: aload_0
    //   728: getfield 25	c/t/m/g/cq$a:d	Ljava/lang/String;
    //   731: aload 7
    //   733: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   736: ifne +177 -> 913
    //   739: aload_0
    //   740: aload 7
    //   742: putfield 25	c/t/m/g/cq$a:d	Ljava/lang/String;
    //   745: aload_0
    //   746: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   749: ifnonnull +21 -> 770
    //   752: aload_0
    //   753: new 291	java/lang/StringBuffer
    //   756: dup
    //   757: aload_0
    //   758: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   761: invokestatic 475	c/t/m/g/cq:m	(Lc/t/m/g/cq;)I
    //   764: invokespecial 477	java/lang/StringBuffer:<init>	(I)V
    //   767: putfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   770: aload_0
    //   771: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   774: astore 7
    //   776: aload 7
    //   778: aload_1
    //   779: invokevirtual 480	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   782: pop
    //   783: aload 7
    //   785: ldc_w 482
    //   788: invokevirtual 480	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   791: pop
    //   792: aload_0
    //   793: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   796: invokevirtual 294	java/lang/StringBuffer:length	()I
    //   799: aload_0
    //   800: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   803: invokestatic 475	c/t/m/g/cq:m	(Lc/t/m/g/cq;)I
    //   806: if_icmpgt +22 -> 828
    //   809: aload_0
    //   810: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   813: ifnull +48 -> 861
    //   816: aload_0
    //   817: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   820: invokevirtual 152	java/io/File:length	()J
    //   823: lconst_0
    //   824: lcmp
    //   825: ifne +36 -> 861
    //   828: aload_0
    //   829: invokespecial 386	c/t/m/g/cq$a:b	()V
    //   832: aload_0
    //   833: getfield 325	c/t/m/g/cq$a:a	Ljava/io/File;
    //   836: invokevirtual 152	java/io/File:length	()J
    //   839: aload_0
    //   840: invokespecial 398	c/t/m/g/cq$a:a	()J
    //   843: lcmp
    //   844: ifle +17 -> 861
    //   847: aload_0
    //   848: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   851: invokestatic 373	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   854: bipush 106
    //   856: lconst_0
    //   857: invokestatic 382	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   860: pop
    //   861: new 58	java/lang/StringBuilder
    //   864: dup
    //   865: ldc_w 484
    //   868: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   871: astore 7
    //   873: aload 7
    //   875: aload_1
    //   876: iconst_0
    //   877: bipush 60
    //   879: invokevirtual 487	java/lang/String:substring	(II)Ljava/lang/String;
    //   882: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: aload 7
    //   888: ldc_w 489
    //   891: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload 7
    //   897: aload_1
    //   898: invokevirtual 460	java/lang/String:length	()I
    //   901: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload 7
    //   907: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 122	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   913: return
    //   914: astore_1
    //   915: ldc_w 491
    //   918: aload_1
    //   919: invokestatic 127	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   922: return
    //   923: astore_1
    //   924: ldc_w 493
    //   927: aload_1
    //   928: invokestatic 127	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   931: return
    //   932: astore_1
    //   933: goto -436 -> 497
    //   936: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	937	0	this	a
    //   0	937	1	paramMessage	android.os.Message
    //   594	47	2	i	int
    //   171	346	3	l1	long
    //   175	350	5	l2	long
    //   10	896	7	localObject	Object
    //   650	24	8	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   406	425	464	finally
    //   590	599	914	java/lang/Throwable
    //   609	631	914	java/lang/Throwable
    //   643	652	914	java/lang/Throwable
    //   655	686	914	java/lang/Throwable
    //   686	709	914	java/lang/Throwable
    //   710	770	914	java/lang/Throwable
    //   770	828	914	java/lang/Throwable
    //   828	861	914	java/lang/Throwable
    //   861	913	914	java/lang/Throwable
    //   0	76	923	java/lang/Throwable
    //   76	116	923	java/lang/Throwable
    //   117	148	923	java/lang/Throwable
    //   149	303	923	java/lang/Throwable
    //   303	334	923	java/lang/Throwable
    //   337	374	923	java/lang/Throwable
    //   374	405	923	java/lang/Throwable
    //   425	454	923	java/lang/Throwable
    //   454	461	923	java/lang/Throwable
    //   465	497	923	java/lang/Throwable
    //   497	526	923	java/lang/Throwable
    //   529	534	923	java/lang/Throwable
    //   535	539	923	java/lang/Throwable
    //   540	589	923	java/lang/Throwable
    //   915	922	923	java/lang/Throwable
    //   406	425	932	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cq.a
 * JD-Core Version:    0.7.0.1
 */