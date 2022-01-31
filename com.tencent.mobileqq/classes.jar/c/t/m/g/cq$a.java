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
    if (cu.f) {}
    for (long l = 51200L; cq.c(this.e) > l; l = 512000L) {
      return l;
    }
    return cq.c(this.e);
  }
  
  private static void a(int paramInt, File paramFile)
  {
    for (;;)
    {
      try
      {
        if (!paramFile.isFile()) {
          return;
        }
        long l = System.currentTimeMillis();
        File localFile = new File(paramFile.getAbsolutePath() + "." + l + ".enc");
        if (paramInt == 4)
        {
          byte[] arrayOfByte = co.a(paramFile);
          if (!co.b(arrayOfByte))
          {
            arrayOfByte = co.a(arrayOfByte);
            if (!co.b(arrayOfByte))
            {
              FileOutputStream localFileOutputStream = new FileOutputStream(localFile, true);
              localFileOutputStream.write(arrayOfByte);
              localFileOutputStream.close();
              paramFile.delete();
            }
          }
          co.a("rename:" + paramFile.getName() + " to " + localFile.getName());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        co.a("rename:" + paramFile.getName() + " error.", localThrowable);
        return;
      }
      paramFile.renameTo(localThrowable);
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    File[] arrayOfFile;
    if (cq.e(this.e) == null)
    {
      arrayOfFile = null;
      if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
        break label40;
      }
    }
    label40:
    long l2;
    Object localObject1;
    label217:
    do
    {
      return;
      arrayOfFile = cq.e(this.e).listFiles();
      break;
      long l3 = System.currentTimeMillis();
      l2 = 0L;
      int j = arrayOfFile.length;
      int i = 0;
      localObject1 = null;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        Object localObject2 = localObject1;
        long l1 = l2;
        if (localFile.exists())
        {
          localObject2 = localObject1;
          l1 = l2;
          if (localFile.isFile())
          {
            localObject2 = localObject1;
            l1 = l2;
            if (!cq.c().equals(localFile.getName()))
            {
              if ((l3 - localFile.lastModified() <= paramLong1) && (localFile.length() != 0L)) {
                break label217;
              }
              co.a("delete expired file:" + localFile.getName() + ",len:" + localFile.length());
              localFile.delete();
              l1 = l2;
              localObject2 = localObject1;
            }
          }
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject2;
          l2 = l1;
          break;
          localObject2 = localFile.getName();
          if ((l3 - localFile.lastModified() > 172800000L) && (!((String)localObject2).endsWith(".enc")) && (((String)localObject2).startsWith(cu.a())))
          {
            a(cu.a((String)localObject2), localFile);
            localObject2 = localObject1;
            l1 = l2;
          }
          else
          {
            l2 += localFile.length();
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              l1 = l2;
              if (localObject1.lastModified() <= localFile.lastModified()) {}
            }
            else
            {
              localObject2 = localFile;
              l1 = l2;
            }
          }
        }
      }
    } while ((l2 < paramLong2) || (localObject1 == null));
    co.a("too big folder size:" + l2 + ", delete " + localObject1.getName() + ",size:" + localObject1.length());
    localObject1.delete();
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
        if (l > cq.o(this.e)) {
          return false;
        }
        localEditor.putLong("log_up_fc_size", paramLong + l);
      }
      for (;;)
      {
        localEditor.apply();
        break;
        localEditor.putString("log_up_fc_date", (String)localObject);
        localEditor.putLong("log_up_fc_size", paramLong);
      }
      return true;
    }
    catch (Throwable localThrowable) {}
  }
  
  private boolean a(String paramString)
  {
    Object localObject;
    File[] arrayOfFile;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory())) {
        break label80;
      }
      arrayOfFile = null;
      label34:
      if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
        break label90;
      }
      if ((arrayOfFile != null) && (paramString.endsWith("d_c"))) {
        ((File)localObject).delete();
      }
    }
    label80:
    label90:
    int m;
    label244:
    label501:
    label506:
    do
    {
      return false;
      localObject = new File(paramString);
      break;
      arrayOfFile = ((File)localObject).listFiles();
      break label34;
      long l = System.currentTimeMillis();
      m = cq.j(this.e);
      int k = 0;
      if ((k < arrayOfFile.length) && (m > 0))
      {
        File localFile = arrayOfFile[k];
        if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile())) {}
        int j;
        for (localObject = "";; localObject = localFile.getName())
        {
          if (!((String)localObject).startsWith("dc"))
          {
            j = m;
            if (!((String)localObject).startsWith("fc")) {}
          }
          else
          {
            if ((!paramString.endsWith("d_c")) || ((localFile.length() != 0L) && (l - localFile.lastModified() <= cq.f(this.e)))) {
              break label244;
            }
            localFile.delete();
            j = m;
          }
          k += 1;
          m = j;
          break;
        }
        if ((((String)localObject).startsWith("fc2")) || (((String)localObject).startsWith("fc3")))
        {
          i = 1;
          if (((!((String)localObject).startsWith(cu.a())) || (!((String)localObject).endsWith(".enc"))) && (i == 0)) {
            break label501;
          }
          j = 1;
          i = j;
          if (j == 0)
          {
            co.a(paramString + ",has no " + cu.a() + "***.enc files!!!");
            if ((!((String)localObject).startsWith("dc")) || (System.currentTimeMillis() - localFile.lastModified() <= 172800000L)) {
              break label506;
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          j = m;
          if (i == 0) {
            break;
          }
          j = m;
          if (!a(localFile.length())) {
            break;
          }
          co.a("upload:" + localFile.getName() + ",len=" + localFile.length());
          i = cu.a((String)localObject);
          j = m;
          if (i <= 0) {
            break;
          }
          String str = cu.a(i);
          j = m;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          localObject = str;
          if (!cu.e) {
            localObject = str.replace("https:", "http:");
          }
          cq.a(this.e, localFile, (String)localObject);
          j = m - 1;
          break;
          i = 0;
          break label268;
          j = 0;
          break label295;
        }
      }
    } while (m == cq.j(this.e));
    label268:
    label295:
    return true;
  }
  
  private void b()
  {
    if ((this.c == null) || (this.c.length() == 0) || (this.b == null)) {
      return;
    }
    byte[] arrayOfByte = cw.a(this.c.toString());
    StringBuilder localStringBuilder = new StringBuilder("write buf to file:buf:").append(this.c.length()).append(",enc:");
    if (arrayOfByte == null) {}
    for (int i = 0;; i = arrayOfByte.length)
    {
      co.a(i);
      this.c.setLength(0);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        break;
      }
      co.a("enc result is null or len = 0");
      return;
    }
    try
    {
      this.b.write(arrayOfByte);
      this.b.write(36);
      this.b.flush();
      return;
    }
    catch (Throwable localThrowable)
    {
      co.a("write file failed.", localThrowable);
      this.a = null;
      dt.a(this.b);
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
      this.a = null;
      dt.a(this.b);
    }
  }
  
  private void d()
  {
    if ((this.a == null) || (!this.a.exists()) || (this.b == null) || (!cq.c().equals(this.a.getName()))) {
      this.a = e();
    }
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
  
  private File e()
  {
    File localFile = cq.e(this.e);
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
    //   7: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: getfield 367	android/os/Message:what	I
    //   14: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: getfield 367	android/os/Message:what	I
    //   27: istore_2
    //   28: iload_2
    //   29: tableswitch	default:+43 -> 72, 101:+44->73, 102:+44->73, 103:+365->394, 104:+415->444, 105:+420->449, 106:+542->571, 107:+810->839
    //   73: aload_1
    //   74: getfield 367	android/os/Message:what	I
    //   77: istore_2
    //   78: aload_0
    //   79: invokespecial 369	c/t/m/g/cq$a:d	()V
    //   82: ldc 23
    //   84: astore 7
    //   86: iload_2
    //   87: bipush 102
    //   89: if_icmpne +250 -> 339
    //   92: getstatic 373	c/t/m/g/cu:i	Lc/t/m/g/dt;
    //   95: aload_0
    //   96: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   99: invokestatic 377	c/t/m/g/cq:k	(Lc/t/m/g/cq;)Landroid/location/Location;
    //   102: aconst_null
    //   103: aload_0
    //   104: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   107: invokestatic 381	c/t/m/g/cq:l	(Lc/t/m/g/cq;)Ljava/util/List;
    //   110: invokestatic 386	c/t/m/g/cv:a	(Lc/t/m/g/dt;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   113: astore_1
    //   114: aload_0
    //   115: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   118: ifnull -46 -> 72
    //   121: aload_1
    //   122: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne -53 -> 72
    //   128: aload_1
    //   129: invokevirtual 387	java/lang/String:length	()I
    //   132: bipush 25
    //   134: if_icmplt -62 -> 72
    //   137: aload_1
    //   138: bipush 22
    //   140: invokevirtual 390	java/lang/String:substring	(I)Ljava/lang/String;
    //   143: invokevirtual 394	java/lang/String:getBytes	()[B
    //   146: ldc_w 396
    //   149: invokestatic 399	c/t/m/g/co:a	([BLjava/lang/String;)Ljava/lang/String;
    //   152: astore 7
    //   154: aload_0
    //   155: getfield 25	c/t/m/g/cq$a:d	Ljava/lang/String;
    //   158: aload 7
    //   160: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifne -91 -> 72
    //   166: aload_0
    //   167: aload 7
    //   169: putfield 25	c/t/m/g/cq$a:d	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   176: ifnonnull +21 -> 197
    //   179: aload_0
    //   180: new 291	java/lang/StringBuffer
    //   183: dup
    //   184: aload_0
    //   185: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   188: invokestatic 402	c/t/m/g/cq:n	(Lc/t/m/g/cq;)I
    //   191: invokespecial 404	java/lang/StringBuffer:<init>	(I)V
    //   194: putfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   197: aload_0
    //   198: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   201: aload_1
    //   202: invokevirtual 407	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   205: ldc_w 409
    //   208: invokevirtual 407	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   211: pop
    //   212: aload_0
    //   213: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   216: invokevirtual 294	java/lang/StringBuffer:length	()I
    //   219: aload_0
    //   220: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   223: invokestatic 402	c/t/m/g/cq:n	(Lc/t/m/g/cq;)I
    //   226: if_icmpgt +22 -> 248
    //   229: aload_0
    //   230: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   233: ifnull +48 -> 281
    //   236: aload_0
    //   237: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   240: invokevirtual 152	java/io/File:length	()J
    //   243: lconst_0
    //   244: lcmp
    //   245: ifne +36 -> 281
    //   248: aload_0
    //   249: invokespecial 411	c/t/m/g/cq$a:b	()V
    //   252: aload_0
    //   253: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   256: invokevirtual 152	java/io/File:length	()J
    //   259: aload_0
    //   260: invokespecial 413	c/t/m/g/cq$a:a	()J
    //   263: lcmp
    //   264: ifle +17 -> 281
    //   267: aload_0
    //   268: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   271: invokestatic 416	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   274: bipush 106
    //   276: lconst_0
    //   277: invokestatic 419	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   280: pop
    //   281: new 58	java/lang/StringBuilder
    //   284: dup
    //   285: ldc_w 421
    //   288: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: aload_1
    //   292: iconst_0
    //   293: bipush 60
    //   295: invokevirtual 424	java/lang/String:substring	(II)Ljava/lang/String;
    //   298: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 426
    //   304: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 387	java/lang/String:length	()I
    //   311: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   320: return
    //   321: astore_1
    //   322: ldc_w 428
    //   325: aload_1
    //   326: invokestatic 123	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: return
    //   330: astore_1
    //   331: ldc_w 430
    //   334: aload_1
    //   335: invokestatic 123	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   338: return
    //   339: aload 7
    //   341: astore_1
    //   342: iload_2
    //   343: bipush 101
    //   345: if_icmpne -231 -> 114
    //   348: aload_0
    //   349: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   352: invokestatic 433	c/t/m/g/cq:m	(Lc/t/m/g/cq;)Ljava/util/List;
    //   355: astore 8
    //   357: aload 7
    //   359: astore_1
    //   360: aload 8
    //   362: invokestatic 436	c/t/m/g/co:a	(Ljava/util/Collection;)Z
    //   365: ifne -251 -> 114
    //   368: getstatic 373	c/t/m/g/cu:i	Lc/t/m/g/dt;
    //   371: aload_0
    //   372: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   375: invokestatic 377	c/t/m/g/cq:k	(Lc/t/m/g/cq;)Landroid/location/Location;
    //   378: aload 8
    //   380: aload_0
    //   381: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   384: invokestatic 381	c/t/m/g/cq:l	(Lc/t/m/g/cq;)Ljava/util/List;
    //   387: invokestatic 386	c/t/m/g/cv:a	(Lc/t/m/g/dt;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   390: astore_1
    //   391: goto -277 -> 114
    //   394: ldc_w 438
    //   397: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   404: invokestatic 441	c/t/m/g/cq:d	(Lc/t/m/g/cq;)Z
    //   407: ifeq -335 -> 72
    //   410: aload_0
    //   411: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   414: invokestatic 131	c/t/m/g/cq:e	(Lc/t/m/g/cq;)Ljava/io/File;
    //   417: invokevirtual 65	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   420: astore_1
    //   421: aload_0
    //   422: aload_1
    //   423: invokespecial 443	c/t/m/g/cq$a:a	(Ljava/lang/String;)Z
    //   426: ifne -354 -> 72
    //   429: aload_0
    //   430: aload_1
    //   431: ldc_w 445
    //   434: ldc 247
    //   436: invokevirtual 448	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   439: invokespecial 443	c/t/m/g/cq$a:a	(Ljava/lang/String;)Z
    //   442: pop
    //   443: return
    //   444: aload_0
    //   445: invokespecial 450	c/t/m/g/cq$a:c	()V
    //   448: return
    //   449: aload_0
    //   450: invokespecial 411	c/t/m/g/cq$a:b	()V
    //   453: aload_0
    //   454: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   457: ifnull +11 -> 468
    //   460: aload_0
    //   461: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   464: iconst_0
    //   465: invokevirtual 313	java/lang/StringBuffer:setLength	(I)V
    //   468: aload_0
    //   469: aconst_null
    //   470: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   473: aload_0
    //   474: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   477: invokestatic 332	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   480: aload_0
    //   481: aload_0
    //   482: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   485: invokestatic 257	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   488: aload_0
    //   489: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   492: invokestatic 453	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   495: invokespecial 455	c/t/m/g/cq$a:a	(JJ)V
    //   498: aload_0
    //   499: aconst_null
    //   500: invokevirtual 459	c/t/m/g/cq$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   503: return
    //   504: astore_1
    //   505: aload_0
    //   506: aconst_null
    //   507: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   510: aload_0
    //   511: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   514: invokestatic 332	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   517: aload_0
    //   518: aload_0
    //   519: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   522: invokestatic 257	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   525: aload_0
    //   526: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   529: invokestatic 453	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   532: invokespecial 455	c/t/m/g/cq$a:a	(JJ)V
    //   535: goto -37 -> 498
    //   538: astore_1
    //   539: aload_0
    //   540: aconst_null
    //   541: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   544: aload_0
    //   545: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   548: invokestatic 332	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   551: aload_0
    //   552: aload_0
    //   553: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   556: invokestatic 257	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   559: aload_0
    //   560: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   563: invokestatic 453	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   566: invokespecial 455	c/t/m/g/cq$a:a	(JJ)V
    //   569: aload_1
    //   570: athrow
    //   571: aload_0
    //   572: invokespecial 369	c/t/m/g/cq$a:d	()V
    //   575: aload_0
    //   576: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   579: invokestatic 131	c/t/m/g/cq:e	(Lc/t/m/g/cq;)Ljava/io/File;
    //   582: ifnull -510 -> 72
    //   585: aload_0
    //   586: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   589: ifnull -517 -> 72
    //   592: aload_0
    //   593: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   596: invokevirtual 138	java/io/File:exists	()Z
    //   599: ifeq -527 -> 72
    //   602: aload_0
    //   603: invokespecial 411	c/t/m/g/cq$a:b	()V
    //   606: ldc 181
    //   608: ldc_w 340
    //   611: lconst_0
    //   612: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   615: invokestatic 462	c/t/m/g/dy:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   618: checkcast 342	java/lang/Long
    //   621: invokevirtual 465	java/lang/Long:longValue	()J
    //   624: lstore_3
    //   625: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   628: lstore 5
    //   630: new 58	java/lang/StringBuilder
    //   633: dup
    //   634: ldc_w 467
    //   637: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   640: aload_0
    //   641: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   644: invokevirtual 152	java/io/File:length	()J
    //   647: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   650: ldc_w 469
    //   653: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_0
    //   657: invokespecial 413	c/t/m/g/cq$a:a	()J
    //   660: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   663: ldc_w 471
    //   666: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: lload 5
    //   671: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   674: ldc_w 473
    //   677: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: lload_3
    //   681: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   684: ldc_w 475
    //   687: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: aload_0
    //   691: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   694: invokestatic 478	c/t/m/g/cq:h	(Lc/t/m/g/cq;)J
    //   697: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   700: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   706: aload_0
    //   707: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   710: invokevirtual 152	java/io/File:length	()J
    //   713: aload_0
    //   714: invokespecial 413	c/t/m/g/cq$a:a	()J
    //   717: lcmp
    //   718: ifgt +18 -> 736
    //   721: lload 5
    //   723: lload_3
    //   724: lsub
    //   725: aload_0
    //   726: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   729: invokestatic 478	c/t/m/g/cq:h	(Lc/t/m/g/cq;)J
    //   732: lcmp
    //   733: ifle -661 -> 72
    //   736: ldc_w 480
    //   739: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   742: aload_0
    //   743: invokespecial 450	c/t/m/g/cq$a:c	()V
    //   746: aload_0
    //   747: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   750: ifnull +17 -> 767
    //   753: aload_0
    //   754: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   757: invokevirtual 152	java/io/File:length	()J
    //   760: ldc2_w 481
    //   763: lcmp
    //   764: ifge +35 -> 799
    //   767: aload_0
    //   768: aload_0
    //   769: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   772: invokestatic 257	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   775: aload_0
    //   776: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   779: invokestatic 453	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   782: invokespecial 455	c/t/m/g/cq$a:a	(JJ)V
    //   785: getstatic 33	c/t/m/g/cu:f	Z
    //   788: ifeq -716 -> 72
    //   791: aload_0
    //   792: bipush 107
    //   794: invokevirtual 486	c/t/m/g/cq$a:sendEmptyMessage	(I)Z
    //   797: pop
    //   798: return
    //   799: aload_0
    //   800: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   803: invokestatic 332	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   806: aload_0
    //   807: aconst_null
    //   808: putfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   811: iconst_4
    //   812: aload_0
    //   813: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   816: invokestatic 172	c/t/m/g/cq$a:a	(ILjava/io/File;)V
    //   819: aload_0
    //   820: aconst_null
    //   821: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   824: ldc 181
    //   826: ldc_w 340
    //   829: lconst_0
    //   830: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   833: invokestatic 349	c/t/m/g/dy:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   836: goto -69 -> 767
    //   839: aload_0
    //   840: bipush 107
    //   842: invokevirtual 489	c/t/m/g/cq$a:removeMessages	(I)V
    //   845: aload_0
    //   846: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   849: aload_0
    //   850: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   853: invokestatic 416	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   856: invokestatic 492	c/t/m/g/cq:a	(Lc/t/m/g/cq;Landroid/os/Handler;)V
    //   859: aload_0
    //   860: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   863: invokestatic 416	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   866: bipush 107
    //   868: aload_0
    //   869: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   872: invokestatic 494	c/t/m/g/cq:i	(Lc/t/m/g/cq;)J
    //   875: invokestatic 419	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   878: pop
    //   879: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	880	0	this	a
    //   0	880	1	paramMessage	android.os.Message
    //   27	319	2	i	int
    //   624	100	3	l1	long
    //   628	94	5	l2	long
    //   84	274	7	str	String
    //   355	24	8	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   73	82	321	java/lang/Throwable
    //   92	114	321	java/lang/Throwable
    //   114	197	321	java/lang/Throwable
    //   197	248	321	java/lang/Throwable
    //   248	281	321	java/lang/Throwable
    //   281	320	321	java/lang/Throwable
    //   348	357	321	java/lang/Throwable
    //   360	391	321	java/lang/Throwable
    //   0	28	330	java/lang/Throwable
    //   322	329	330	java/lang/Throwable
    //   394	443	330	java/lang/Throwable
    //   444	448	330	java/lang/Throwable
    //   468	498	330	java/lang/Throwable
    //   498	503	330	java/lang/Throwable
    //   505	535	330	java/lang/Throwable
    //   539	571	330	java/lang/Throwable
    //   571	736	330	java/lang/Throwable
    //   736	767	330	java/lang/Throwable
    //   767	798	330	java/lang/Throwable
    //   799	836	330	java/lang/Throwable
    //   839	879	330	java/lang/Throwable
    //   449	468	504	java/lang/Throwable
    //   449	468	538	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.cq.a
 * JD-Core Version:    0.7.0.1
 */