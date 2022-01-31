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
    if (ct.f) {}
    for (long l = 51200L; cq.b(this.e) > l; l = 512000L) {
      return l;
    }
    return cq.b(this.e);
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
    if (cq.d(this.e) == null)
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
      arrayOfFile = cq.d(this.e).listFiles();
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
          if ((l3 - localFile.lastModified() > 172800000L) && (!((String)localObject2).endsWith(".enc")) && (((String)localObject2).startsWith(ct.a())))
          {
            a(ct.a((String)localObject2), localFile);
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
      Object localObject = dv.a("LocationSDK");
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      String str = ((SharedPreferences)localObject).getString("log_up_fc_date", "");
      long l = ((SharedPreferences)localObject).getLong("log_up_fc_size", 0L);
      localObject = dp.a("yyyyMMdd").format(new Date());
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
      m = cq.i(this.e);
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
            if ((!paramString.endsWith("d_c")) || ((localFile.length() != 0L) && (l - localFile.lastModified() <= cq.e(this.e)))) {
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
          if (((!((String)localObject).startsWith(ct.a())) || (!((String)localObject).endsWith(".enc"))) && (i == 0)) {
            break label501;
          }
          j = 1;
          i = j;
          if (j == 0)
          {
            co.a(paramString + ",has no " + ct.a() + "***.enc files!!!");
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
          i = ct.a((String)localObject);
          j = m;
          if (i <= 0) {
            break;
          }
          String str = ct.a(i);
          j = m;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          localObject = str;
          if (!ct.e) {
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
    } while (m == cq.i(this.e));
    label268:
    label295:
    return true;
  }
  
  private void b()
  {
    if ((this.c == null) || (this.c.length() == 0) || (this.b == null)) {
      return;
    }
    byte[] arrayOfByte = cv.a(this.c.toString());
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
      cx.a(this.b);
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
      cx.a(this.b);
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
        dv.a("LocationSDK", "log_fc_create", Long.valueOf(System.currentTimeMillis()));
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
    //   29: tableswitch	default:+47 -> 76, 101:+48->77, 102:+48->77, 103:+377->406, 104:+427->456, 105:+432->461, 106:+554->583, 107:+822->851, 108:+863->892
    //   77: aload_1
    //   78: getfield 367	android/os/Message:what	I
    //   81: istore_2
    //   82: aload_0
    //   83: invokespecial 369	c/t/m/g/cq$a:d	()V
    //   86: ldc 23
    //   88: astore 7
    //   90: iload_2
    //   91: bipush 102
    //   93: if_icmpne +254 -> 347
    //   96: aload_0
    //   97: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   100: invokestatic 373	c/t/m/g/cq:j	(Lc/t/m/g/cq;)Lc/t/m/g/cx;
    //   103: aload_0
    //   104: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   107: invokestatic 377	c/t/m/g/cq:k	(Lc/t/m/g/cq;)Landroid/location/Location;
    //   110: aconst_null
    //   111: aload_0
    //   112: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   115: invokestatic 381	c/t/m/g/cq:l	(Lc/t/m/g/cq;)Ljava/util/List;
    //   118: invokestatic 386	c/t/m/g/cu:a	(Lc/t/m/g/cx;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   126: ifnull -50 -> 76
    //   129: aload_1
    //   130: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne -57 -> 76
    //   136: aload_1
    //   137: invokevirtual 387	java/lang/String:length	()I
    //   140: bipush 25
    //   142: if_icmplt -66 -> 76
    //   145: aload_1
    //   146: bipush 22
    //   148: invokevirtual 390	java/lang/String:substring	(I)Ljava/lang/String;
    //   151: invokevirtual 394	java/lang/String:getBytes	()[B
    //   154: ldc_w 396
    //   157: invokestatic 399	c/t/m/g/co:a	([BLjava/lang/String;)Ljava/lang/String;
    //   160: astore 7
    //   162: aload_0
    //   163: getfield 25	c/t/m/g/cq$a:d	Ljava/lang/String;
    //   166: aload 7
    //   168: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne -95 -> 76
    //   174: aload_0
    //   175: aload 7
    //   177: putfield 25	c/t/m/g/cq$a:d	Ljava/lang/String;
    //   180: aload_0
    //   181: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   184: ifnonnull +21 -> 205
    //   187: aload_0
    //   188: new 291	java/lang/StringBuffer
    //   191: dup
    //   192: aload_0
    //   193: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   196: invokestatic 402	c/t/m/g/cq:n	(Lc/t/m/g/cq;)I
    //   199: invokespecial 404	java/lang/StringBuffer:<init>	(I)V
    //   202: putfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   205: aload_0
    //   206: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   209: aload_1
    //   210: invokevirtual 407	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   213: ldc_w 409
    //   216: invokevirtual 407	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   219: pop
    //   220: aload_0
    //   221: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   224: invokevirtual 294	java/lang/StringBuffer:length	()I
    //   227: aload_0
    //   228: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   231: invokestatic 402	c/t/m/g/cq:n	(Lc/t/m/g/cq;)I
    //   234: if_icmpgt +22 -> 256
    //   237: aload_0
    //   238: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   241: ifnull +48 -> 289
    //   244: aload_0
    //   245: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   248: invokevirtual 152	java/io/File:length	()J
    //   251: lconst_0
    //   252: lcmp
    //   253: ifne +36 -> 289
    //   256: aload_0
    //   257: invokespecial 411	c/t/m/g/cq$a:b	()V
    //   260: aload_0
    //   261: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   264: invokevirtual 152	java/io/File:length	()J
    //   267: aload_0
    //   268: invokespecial 413	c/t/m/g/cq$a:a	()J
    //   271: lcmp
    //   272: ifle +17 -> 289
    //   275: aload_0
    //   276: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   279: invokestatic 416	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   282: bipush 106
    //   284: lconst_0
    //   285: invokestatic 419	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   288: pop
    //   289: new 58	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 421
    //   296: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload_1
    //   300: iconst_0
    //   301: bipush 60
    //   303: invokevirtual 424	java/lang/String:substring	(II)Ljava/lang/String;
    //   306: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 426
    //   312: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_1
    //   316: invokevirtual 387	java/lang/String:length	()I
    //   319: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   328: return
    //   329: astore_1
    //   330: ldc_w 428
    //   333: aload_1
    //   334: invokestatic 123	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   337: return
    //   338: astore_1
    //   339: ldc_w 430
    //   342: aload_1
    //   343: invokestatic 123	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   346: return
    //   347: aload 7
    //   349: astore_1
    //   350: iload_2
    //   351: bipush 101
    //   353: if_icmpne -231 -> 122
    //   356: aload_0
    //   357: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   360: invokestatic 433	c/t/m/g/cq:m	(Lc/t/m/g/cq;)Ljava/util/List;
    //   363: astore 8
    //   365: aload 7
    //   367: astore_1
    //   368: aload 8
    //   370: invokestatic 436	c/t/m/g/co:a	(Ljava/util/Collection;)Z
    //   373: ifne -251 -> 122
    //   376: aload_0
    //   377: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   380: invokestatic 373	c/t/m/g/cq:j	(Lc/t/m/g/cq;)Lc/t/m/g/cx;
    //   383: aload_0
    //   384: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   387: invokestatic 377	c/t/m/g/cq:k	(Lc/t/m/g/cq;)Landroid/location/Location;
    //   390: aload 8
    //   392: aload_0
    //   393: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   396: invokestatic 381	c/t/m/g/cq:l	(Lc/t/m/g/cq;)Ljava/util/List;
    //   399: invokestatic 386	c/t/m/g/cu:a	(Lc/t/m/g/cx;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   402: astore_1
    //   403: goto -281 -> 122
    //   406: ldc_w 438
    //   409: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   412: aload_0
    //   413: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   416: invokestatic 441	c/t/m/g/cq:c	(Lc/t/m/g/cq;)Z
    //   419: ifeq -343 -> 76
    //   422: aload_0
    //   423: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   426: invokestatic 131	c/t/m/g/cq:d	(Lc/t/m/g/cq;)Ljava/io/File;
    //   429: invokevirtual 65	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: astore_1
    //   433: aload_0
    //   434: aload_1
    //   435: invokespecial 443	c/t/m/g/cq$a:a	(Ljava/lang/String;)Z
    //   438: ifne -362 -> 76
    //   441: aload_0
    //   442: aload_1
    //   443: ldc_w 445
    //   446: ldc 247
    //   448: invokevirtual 448	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   451: invokespecial 443	c/t/m/g/cq$a:a	(Ljava/lang/String;)Z
    //   454: pop
    //   455: return
    //   456: aload_0
    //   457: invokespecial 450	c/t/m/g/cq$a:c	()V
    //   460: return
    //   461: aload_0
    //   462: invokespecial 411	c/t/m/g/cq$a:b	()V
    //   465: aload_0
    //   466: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   469: ifnull +11 -> 480
    //   472: aload_0
    //   473: getfield 289	c/t/m/g/cq$a:c	Ljava/lang/StringBuffer;
    //   476: iconst_0
    //   477: invokevirtual 313	java/lang/StringBuffer:setLength	(I)V
    //   480: aload_0
    //   481: aconst_null
    //   482: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   485: aload_0
    //   486: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   489: invokestatic 332	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   492: aload_0
    //   493: aload_0
    //   494: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   497: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   500: aload_0
    //   501: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   504: invokestatic 452	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   507: invokespecial 454	c/t/m/g/cq$a:a	(JJ)V
    //   510: aload_0
    //   511: aconst_null
    //   512: invokevirtual 458	c/t/m/g/cq$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   515: return
    //   516: astore_1
    //   517: aload_0
    //   518: aconst_null
    //   519: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   522: aload_0
    //   523: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   526: invokestatic 332	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   529: aload_0
    //   530: aload_0
    //   531: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   534: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   537: aload_0
    //   538: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   541: invokestatic 452	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   544: invokespecial 454	c/t/m/g/cq$a:a	(JJ)V
    //   547: goto -37 -> 510
    //   550: astore_1
    //   551: aload_0
    //   552: aconst_null
    //   553: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   556: aload_0
    //   557: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   560: invokestatic 332	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   563: aload_0
    //   564: aload_0
    //   565: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   568: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   571: aload_0
    //   572: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   575: invokestatic 452	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   578: invokespecial 454	c/t/m/g/cq$a:a	(JJ)V
    //   581: aload_1
    //   582: athrow
    //   583: aload_0
    //   584: invokespecial 369	c/t/m/g/cq$a:d	()V
    //   587: aload_0
    //   588: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   591: invokestatic 131	c/t/m/g/cq:d	(Lc/t/m/g/cq;)Ljava/io/File;
    //   594: ifnull -518 -> 76
    //   597: aload_0
    //   598: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   601: ifnull -525 -> 76
    //   604: aload_0
    //   605: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   608: invokevirtual 138	java/io/File:exists	()Z
    //   611: ifeq -535 -> 76
    //   614: aload_0
    //   615: invokespecial 411	c/t/m/g/cq$a:b	()V
    //   618: ldc 181
    //   620: ldc_w 340
    //   623: lconst_0
    //   624: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   627: invokestatic 461	c/t/m/g/dv:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   630: checkcast 342	java/lang/Long
    //   633: invokevirtual 464	java/lang/Long:longValue	()J
    //   636: lstore_3
    //   637: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   640: lstore 5
    //   642: new 58	java/lang/StringBuilder
    //   645: dup
    //   646: ldc_w 466
    //   649: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   652: aload_0
    //   653: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   656: invokevirtual 152	java/io/File:length	()J
    //   659: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   662: ldc_w 468
    //   665: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_0
    //   669: invokespecial 413	c/t/m/g/cq$a:a	()J
    //   672: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: ldc_w 470
    //   678: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: lload 5
    //   683: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   686: ldc_w 472
    //   689: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: lload_3
    //   693: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   696: ldc_w 474
    //   699: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_0
    //   703: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   706: invokestatic 477	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   709: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   712: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   718: aload_0
    //   719: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   722: invokevirtual 152	java/io/File:length	()J
    //   725: aload_0
    //   726: invokespecial 413	c/t/m/g/cq$a:a	()J
    //   729: lcmp
    //   730: ifgt +18 -> 748
    //   733: lload 5
    //   735: lload_3
    //   736: lsub
    //   737: aload_0
    //   738: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   741: invokestatic 477	c/t/m/g/cq:g	(Lc/t/m/g/cq;)J
    //   744: lcmp
    //   745: ifle -669 -> 76
    //   748: ldc_w 479
    //   751: invokestatic 118	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   754: aload_0
    //   755: invokespecial 450	c/t/m/g/cq$a:c	()V
    //   758: aload_0
    //   759: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   762: ifnull +17 -> 779
    //   765: aload_0
    //   766: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   769: invokevirtual 152	java/io/File:length	()J
    //   772: ldc2_w 480
    //   775: lcmp
    //   776: ifge +35 -> 811
    //   779: aload_0
    //   780: aload_0
    //   781: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   784: invokestatic 257	c/t/m/g/cq:e	(Lc/t/m/g/cq;)J
    //   787: aload_0
    //   788: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   791: invokestatic 452	c/t/m/g/cq:f	(Lc/t/m/g/cq;)J
    //   794: invokespecial 454	c/t/m/g/cq$a:a	(JJ)V
    //   797: getstatic 33	c/t/m/g/ct:f	Z
    //   800: ifeq -724 -> 76
    //   803: aload_0
    //   804: bipush 107
    //   806: invokevirtual 485	c/t/m/g/cq$a:sendEmptyMessage	(I)Z
    //   809: pop
    //   810: return
    //   811: aload_0
    //   812: getfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   815: invokestatic 332	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   818: aload_0
    //   819: aconst_null
    //   820: putfield 296	c/t/m/g/cq$a:b	Ljava/io/BufferedOutputStream;
    //   823: iconst_4
    //   824: aload_0
    //   825: getfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   828: invokestatic 172	c/t/m/g/cq$a:a	(ILjava/io/File;)V
    //   831: aload_0
    //   832: aconst_null
    //   833: putfield 327	c/t/m/g/cq$a:a	Ljava/io/File;
    //   836: ldc 181
    //   838: ldc_w 340
    //   841: lconst_0
    //   842: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   845: invokestatic 349	c/t/m/g/dv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   848: goto -69 -> 779
    //   851: aload_0
    //   852: bipush 107
    //   854: invokevirtual 488	c/t/m/g/cq$a:removeMessages	(I)V
    //   857: aload_0
    //   858: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   861: aload_0
    //   862: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   865: invokestatic 416	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   868: invokestatic 491	c/t/m/g/cq:a	(Lc/t/m/g/cq;Landroid/os/Handler;)V
    //   871: aload_0
    //   872: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   875: invokestatic 416	c/t/m/g/cq:a	(Lc/t/m/g/cq;)Landroid/os/Handler;
    //   878: bipush 107
    //   880: aload_0
    //   881: getfield 18	c/t/m/g/cq$a:e	Lc/t/m/g/cq;
    //   884: invokestatic 494	c/t/m/g/cq:h	(Lc/t/m/g/cq;)J
    //   887: invokestatic 419	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   890: pop
    //   891: return
    //   892: aload_0
    //   893: bipush 108
    //   895: invokevirtual 488	c/t/m/g/cq$a:removeMessages	(I)V
    //   898: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	899	0	this	a
    //   0	899	1	paramMessage	android.os.Message
    //   27	327	2	i	int
    //   636	100	3	l1	long
    //   640	94	5	l2	long
    //   88	278	7	str	String
    //   363	28	8	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   77	86	329	java/lang/Throwable
    //   96	122	329	java/lang/Throwable
    //   122	205	329	java/lang/Throwable
    //   205	256	329	java/lang/Throwable
    //   256	289	329	java/lang/Throwable
    //   289	328	329	java/lang/Throwable
    //   356	365	329	java/lang/Throwable
    //   368	403	329	java/lang/Throwable
    //   0	28	338	java/lang/Throwable
    //   330	337	338	java/lang/Throwable
    //   406	455	338	java/lang/Throwable
    //   456	460	338	java/lang/Throwable
    //   480	510	338	java/lang/Throwable
    //   510	515	338	java/lang/Throwable
    //   517	547	338	java/lang/Throwable
    //   551	583	338	java/lang/Throwable
    //   583	748	338	java/lang/Throwable
    //   748	779	338	java/lang/Throwable
    //   779	810	338	java/lang/Throwable
    //   811	848	338	java/lang/Throwable
    //   851	891	338	java/lang/Throwable
    //   892	898	338	java/lang/Throwable
    //   461	480	516	java/lang/Throwable
    //   461	480	550	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cq.a
 * JD-Core Version:    0.7.0.1
 */