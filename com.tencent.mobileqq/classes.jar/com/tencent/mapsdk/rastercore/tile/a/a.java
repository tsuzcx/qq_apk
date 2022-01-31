package com.tencent.mapsdk.rastercore.tile.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.io.File;
import java.io.PrintStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static final ReadWriteLock a = new ReentrantReadWriteLock();
  private static final String d = "Qmap" + File.separator + "RealTimeMap" + File.separator + "v1";
  private boolean b = false;
  private volatile Context c;
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 128 * 128 + paramInt2 % 128;
  }
  
  public static a a()
  {
    return a.a;
  }
  
  private String[] a(com.tencent.mapsdk.rastercore.tile.a parama, boolean paramBoolean)
  {
    int i = parama.b() / 128;
    int j = parama.c() / 128;
    int k = i / 10;
    int m = j / 10;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = c();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/");
    localStringBuilder.append(parama.a());
    localStringBuilder.append("/");
    localStringBuilder.append(parama.d());
    localStringBuilder.append("/");
    localStringBuilder.append(k);
    localStringBuilder.append("/");
    localStringBuilder.append(m);
    localStringBuilder.append("/");
    if (!paramBoolean)
    {
      localObject = new File(localStringBuilder.toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
    localStringBuilder.append(parama.d());
    localStringBuilder.append("_");
    localStringBuilder.append(i);
    localStringBuilder.append("_");
    localStringBuilder.append(j);
    return new String[] { localStringBuilder.toString() + ".idx", localStringBuilder.toString() + ".dat" };
  }
  
  /* Error */
  public final android.graphics.Bitmap a(com.tencent.mapsdk.rastercore.tile.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   6: invokeinterface 113 1 0
    //   11: invokeinterface 118 1 0
    //   16: aload_0
    //   17: aload_1
    //   18: iconst_1
    //   19: invokespecial 120	com/tencent/mapsdk/rastercore/tile/a/a:a	(Lcom/tencent/mapsdk/rastercore/tile/a;Z)[Ljava/lang/String;
    //   22: astore 9
    //   24: aload 9
    //   26: ifnull +38 -> 64
    //   29: aload 9
    //   31: arraylength
    //   32: iconst_2
    //   33: if_icmpne +31 -> 64
    //   36: aload 9
    //   38: iconst_0
    //   39: aaload
    //   40: ldc 122
    //   42: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifne +19 -> 64
    //   48: aload 9
    //   50: aload 9
    //   52: arraylength
    //   53: anewarray 98	java/lang/String
    //   56: invokestatic 131	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq +18 -> 79
    //   64: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   67: invokeinterface 113 1 0
    //   72: invokeinterface 134 1 0
    //   77: aconst_null
    //   78: areturn
    //   79: new 34	java/io/File
    //   82: dup
    //   83: aload 9
    //   85: iconst_0
    //   86: aaload
    //   87: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore 6
    //   92: aload 6
    //   94: invokevirtual 91	java/io/File:exists	()Z
    //   97: ifeq +17 -> 114
    //   100: aload 6
    //   102: invokevirtual 138	java/io/File:length	()J
    //   105: lstore 4
    //   107: lload 4
    //   109: lconst_0
    //   110: lcmp
    //   111: ifne +18 -> 129
    //   114: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   117: invokeinterface 113 1 0
    //   122: invokeinterface 134 1 0
    //   127: aconst_null
    //   128: areturn
    //   129: aload_1
    //   130: invokevirtual 66	com/tencent/mapsdk/rastercore/tile/a:b	()I
    //   133: aload_1
    //   134: invokevirtual 68	com/tencent/mapsdk/rastercore/tile/a:c	()I
    //   137: invokestatic 140	com/tencent/mapsdk/rastercore/tile/a/a:a	(II)I
    //   140: istore_2
    //   141: iload_2
    //   142: ifge +18 -> 160
    //   145: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   148: invokeinterface 113 1 0
    //   153: invokeinterface 134 1 0
    //   158: aconst_null
    //   159: areturn
    //   160: iconst_4
    //   161: newarray byte
    //   163: astore 8
    //   165: new 142	java/io/RandomAccessFile
    //   168: dup
    //   169: aload 6
    //   171: ldc 144
    //   173: invokespecial 147	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   176: astore 6
    //   178: iload_2
    //   179: iconst_4
    //   180: imul
    //   181: i2l
    //   182: lstore 4
    //   184: aload 6
    //   186: lload 4
    //   188: invokevirtual 151	java/io/RandomAccessFile:seek	(J)V
    //   191: aload 6
    //   193: aload 8
    //   195: iconst_0
    //   196: iconst_4
    //   197: invokevirtual 155	java/io/RandomAccessFile:read	([BII)I
    //   200: pop
    //   201: aload 6
    //   203: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   206: aload 8
    //   208: invokestatic 163	com/tencent/mapsdk/rastercore/d$a:b	([B)[B
    //   211: pop
    //   212: aload 8
    //   214: invokestatic 166	com/tencent/mapsdk/rastercore/d$a:a	([B)I
    //   217: istore_2
    //   218: iload_2
    //   219: ifge +69 -> 288
    //   222: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   225: invokeinterface 113 1 0
    //   230: invokeinterface 134 1 0
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aconst_null
    //   239: astore 6
    //   241: aload 6
    //   243: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   246: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   249: invokeinterface 113 1 0
    //   254: invokeinterface 134 1 0
    //   259: aconst_null
    //   260: areturn
    //   261: astore_1
    //   262: aconst_null
    //   263: astore 6
    //   265: aload 6
    //   267: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   276: invokeinterface 113 1 0
    //   281: invokeinterface 134 1 0
    //   286: aload_1
    //   287: athrow
    //   288: new 34	java/io/File
    //   291: dup
    //   292: aload 9
    //   294: iconst_1
    //   295: aaload
    //   296: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   299: astore 6
    //   301: aload 6
    //   303: invokevirtual 91	java/io/File:exists	()Z
    //   306: istore_3
    //   307: iload_3
    //   308: ifne +18 -> 326
    //   311: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   314: invokeinterface 113 1 0
    //   319: invokeinterface 134 1 0
    //   324: aconst_null
    //   325: areturn
    //   326: new 142	java/io/RandomAccessFile
    //   329: dup
    //   330: aload 6
    //   332: ldc 144
    //   334: invokespecial 147	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   337: astore 6
    //   339: iload_2
    //   340: i2l
    //   341: lstore 4
    //   343: aload 6
    //   345: lload 4
    //   347: invokevirtual 151	java/io/RandomAccessFile:seek	(J)V
    //   350: aload 6
    //   352: aload 8
    //   354: iconst_0
    //   355: iconst_4
    //   356: invokevirtual 155	java/io/RandomAccessFile:read	([BII)I
    //   359: pop
    //   360: aload 8
    //   362: invokestatic 163	com/tencent/mapsdk/rastercore/d$a:b	([B)[B
    //   365: pop
    //   366: aload 8
    //   368: invokestatic 166	com/tencent/mapsdk/rastercore/d$a:a	([B)I
    //   371: istore_2
    //   372: iload_2
    //   373: ifle +9 -> 382
    //   376: iload_2
    //   377: ldc 167
    //   379: if_icmple +111 -> 490
    //   382: aload 6
    //   384: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   387: invokestatic 173	com/tencent/tencentmap/mapsdk/map/TencentMap:getErrorListener	()Lcom/tencent/tencentmap/mapsdk/map/TencentMap$OnErrorListener;
    //   390: ifnull +63 -> 453
    //   393: invokestatic 173	com/tencent/tencentmap/mapsdk/map/TencentMap:getErrorListener	()Lcom/tencent/tencentmap/mapsdk/map/TencentMap$OnErrorListener;
    //   396: new 27	java/lang/StringBuilder
    //   399: dup
    //   400: ldc 175
    //   402: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   405: iload_2
    //   406: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   409: ldc 177
    //   411: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_1
    //   415: invokevirtual 66	com/tencent/mapsdk/rastercore/tile/a:b	()I
    //   418: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: ldc 179
    //   423: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_1
    //   427: invokevirtual 68	com/tencent/mapsdk/rastercore/tile/a:c	()I
    //   430: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc 181
    //   435: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 83	com/tencent/mapsdk/rastercore/tile/a:d	()I
    //   442: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokeinterface 186 2 0
    //   453: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   456: invokeinterface 113 1 0
    //   461: invokeinterface 134 1 0
    //   466: aconst_null
    //   467: areturn
    //   468: astore_1
    //   469: aconst_null
    //   470: astore_1
    //   471: aload_1
    //   472: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   475: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   478: invokeinterface 113 1 0
    //   483: invokeinterface 134 1 0
    //   488: aconst_null
    //   489: areturn
    //   490: iload_2
    //   491: newarray byte
    //   493: astore_1
    //   494: aload 6
    //   496: aload_1
    //   497: iconst_0
    //   498: iload_2
    //   499: invokevirtual 155	java/io/RandomAccessFile:read	([BII)I
    //   502: pop
    //   503: aload 6
    //   505: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   508: aload_1
    //   509: iconst_0
    //   510: aload_1
    //   511: arraylength
    //   512: invokestatic 192	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   515: astore_1
    //   516: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   519: invokeinterface 113 1 0
    //   524: invokeinterface 134 1 0
    //   529: aload_1
    //   530: areturn
    //   531: astore_1
    //   532: aload 6
    //   534: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   537: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   540: invokeinterface 113 1 0
    //   545: invokeinterface 134 1 0
    //   550: aconst_null
    //   551: areturn
    //   552: astore_1
    //   553: aload 6
    //   555: invokestatic 160	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   558: aload_1
    //   559: athrow
    //   560: astore_1
    //   561: aload 7
    //   563: astore_1
    //   564: goto -48 -> 516
    //   567: astore_1
    //   568: aload 6
    //   570: astore_1
    //   571: goto -100 -> 471
    //   574: astore_1
    //   575: goto -310 -> 265
    //   578: astore_1
    //   579: goto -338 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	a
    //   0	582	1	parama	com.tencent.mapsdk.rastercore.tile.a
    //   140	359	2	i	int
    //   59	249	3	bool	boolean
    //   105	241	4	l	long
    //   90	479	6	localObject1	Object
    //   1	561	7	localObject2	Object
    //   163	204	8	arrayOfByte	byte[]
    //   22	271	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   165	178	237	java/lang/Exception
    //   165	178	261	finally
    //   16	24	272	finally
    //   29	60	272	finally
    //   79	107	272	finally
    //   129	141	272	finally
    //   160	165	272	finally
    //   201	218	272	finally
    //   241	246	272	finally
    //   265	272	272	finally
    //   288	307	272	finally
    //   326	339	272	finally
    //   343	360	272	finally
    //   360	372	272	finally
    //   382	453	272	finally
    //   471	475	272	finally
    //   490	494	272	finally
    //   503	508	272	finally
    //   508	516	272	finally
    //   532	537	272	finally
    //   553	560	272	finally
    //   326	339	468	java/lang/Exception
    //   494	503	531	java/io/IOException
    //   494	503	552	finally
    //   508	516	560	java/lang/Exception
    //   343	360	567	java/lang/Exception
    //   184	201	574	finally
    //   184	201	578	java/lang/Exception
  }
  
  public final void a(int paramInt)
  {
    int i = 0;
    a.writeLock().lock();
    for (;;)
    {
      try
      {
        Object localObject3 = new StringBuilder(256);
        Object localObject1 = c();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool) {
          return;
        }
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append(b.a(MapTile.MapSource.SATELLITE, 0, paramInt));
        localObject1 = Pattern.compile("/Sate/V\\d+$");
        Pattern localPattern = Pattern.compile("\\d+$");
        localObject3 = new File(((StringBuilder)localObject3).substring(0, ((StringBuilder)localObject3).lastIndexOf("/")));
        if ((((File)localObject3).exists()) && (((File)localObject3).isDirectory()))
        {
          localObject3 = ((File)localObject3).listFiles();
          int j = localObject3.length;
          if (i < j)
          {
            String str = localObject3[i];
            if (str.isDirectory())
            {
              str = str.getAbsolutePath();
              if ((((Pattern)localObject1).matcher(str).find()) && (Long.parseLong(localPattern.matcher(str).group()) != paramInt)) {
                com.tencent.mapsdk.rastercore.f.b.b(str);
              }
            }
            else
            {
              str.delete();
            }
          }
        }
      }
      finally
      {
        a.writeLock().unlock();
      }
      a.writeLock().unlock();
      return;
      i += 1;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, MapTile.MapSource paramMapSource)
  {
    int i = 0;
    a.writeLock().lock();
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        localObject2 = new StringBuilder(256);
        localObject1 = c();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool) {
          return;
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(b.a(paramMapSource, paramInt1, paramInt2));
        localObject1 = new StringBuilder();
        switch (1.a[paramMapSource.ordinal()])
        {
        case 1: 
          ((StringBuilder)localObject1).append("/\\d+$");
          localObject1 = Pattern.compile(((StringBuilder)localObject1).toString());
          if (paramMapSource != MapTile.MapSource.BING) {
            break label386;
          }
          paramMapSource = ((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).lastIndexOf("/"));
          paramMapSource = paramMapSource.substring(0, paramMapSource.lastIndexOf("/"));
          paramMapSource = new File(paramMapSource);
          if ((!paramMapSource.exists()) || (!paramMapSource.isDirectory())) {
            break label412;
          }
          paramMapSource = paramMapSource.listFiles();
          int j = paramMapSource.length;
          paramInt1 = i;
          if (paramInt1 >= j) {
            break label412;
          }
          localObject2 = paramMapSource[paramInt1];
          if (!((File)localObject2).isDirectory()) {
            break label403;
          }
          localObject2 = ((File)localObject2).getAbsolutePath();
          if ((!((Pattern)localObject1).matcher((CharSequence)localObject2).find()) || (Integer.parseInt(((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1)) == paramInt2)) {
            break label429;
          }
          com.tencent.mapsdk.rastercore.f.b.b((String)localObject2);
        }
      }
      finally
      {
        a.writeLock().unlock();
      }
      ((StringBuilder)localObject1).append("/BingGrid/").append(e.u()).append("/").append(e.t());
      continue;
      ((StringBuilder)localObject1).append("/Grid/").append(e.y()).append("/").append(paramInt1);
      continue;
      ((StringBuilder)localObject1).append("/QQAR/").append(e.y()).append("/").append(paramInt1);
      continue;
      label386:
      paramMapSource = ((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).lastIndexOf("/"));
      continue;
      label403:
      ((File)localObject2).delete();
      break label429;
      label412:
      a.writeLock().unlock();
      return;
      continue;
      label429:
      paramInt1 += 1;
    }
  }
  
  public final void a(Context paramContext)
  {
    this.c = paramContext;
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, com.tencent.mapsdk.rastercore.tile.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   6: invokeinterface 196 1 0
    //   11: invokeinterface 118 1 0
    //   16: aload_0
    //   17: getfield 304	com/tencent/mapsdk/rastercore/tile/a/a:c	Landroid/content/Context;
    //   20: astore 10
    //   22: aload 10
    //   24: ifnonnull +18 -> 42
    //   27: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   30: invokeinterface 196 1 0
    //   35: invokeinterface 134 1 0
    //   40: iconst_0
    //   41: ireturn
    //   42: invokestatic 308	com/tencent/mapsdk/rastercore/d$a:a	()Lcom/tencent/mapsdk/rastercore/d$a;
    //   45: pop
    //   46: aload_0
    //   47: getfield 304	com/tencent/mapsdk/rastercore/tile/a/a:c	Landroid/content/Context;
    //   50: invokevirtual 313	android/content/Context:getPackageName	()Ljava/lang/String;
    //   53: iconst_0
    //   54: invokestatic 316	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/lang/String;Z)I
    //   57: istore_3
    //   58: invokestatic 308	com/tencent/mapsdk/rastercore/d$a:a	()Lcom/tencent/mapsdk/rastercore/d$a;
    //   61: pop
    //   62: aload_0
    //   63: getfield 304	com/tencent/mapsdk/rastercore/tile/a/a:c	Landroid/content/Context;
    //   66: invokevirtual 313	android/content/Context:getPackageName	()Ljava/lang/String;
    //   69: iconst_0
    //   70: invokestatic 318	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;Z)I
    //   73: istore 4
    //   75: invokestatic 308	com/tencent/mapsdk/rastercore/d$a:a	()Lcom/tencent/mapsdk/rastercore/d$a;
    //   78: pop
    //   79: iload_3
    //   80: iload 4
    //   82: iconst_0
    //   83: invokestatic 321	com/tencent/mapsdk/rastercore/d$a:a	(IIZ)I
    //   86: istore_3
    //   87: aload_2
    //   88: invokevirtual 324	com/tencent/mapsdk/rastercore/tile/a:l	()I
    //   91: istore 4
    //   93: iload 4
    //   95: iload_3
    //   96: if_icmpeq +18 -> 114
    //   99: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   102: invokeinterface 196 1 0
    //   107: invokeinterface 134 1 0
    //   112: iconst_0
    //   113: ireturn
    //   114: aload_1
    //   115: ifnonnull +18 -> 133
    //   118: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   121: invokeinterface 196 1 0
    //   126: invokeinterface 134 1 0
    //   131: iconst_0
    //   132: ireturn
    //   133: aload_1
    //   134: arraylength
    //   135: istore_3
    //   136: iload_3
    //   137: ifgt +18 -> 155
    //   140: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   143: invokeinterface 196 1 0
    //   148: invokeinterface 134 1 0
    //   153: iconst_0
    //   154: ireturn
    //   155: aload_0
    //   156: aload_2
    //   157: iconst_0
    //   158: invokespecial 120	com/tencent/mapsdk/rastercore/tile/a/a:a	(Lcom/tencent/mapsdk/rastercore/tile/a;Z)[Ljava/lang/String;
    //   161: astore 12
    //   163: aload 12
    //   165: ifnull +40 -> 205
    //   168: aload 12
    //   170: arraylength
    //   171: iconst_2
    //   172: if_icmpne +33 -> 205
    //   175: aload 12
    //   177: iconst_0
    //   178: aaload
    //   179: ldc 122
    //   181: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: ifne +21 -> 205
    //   187: aload 12
    //   189: aload 12
    //   191: arraylength
    //   192: anewarray 98	java/lang/String
    //   195: invokestatic 131	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   198: istore 5
    //   200: iload 5
    //   202: ifeq +18 -> 220
    //   205: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   208: invokeinterface 196 1 0
    //   213: invokeinterface 134 1 0
    //   218: iconst_0
    //   219: ireturn
    //   220: new 34	java/io/File
    //   223: dup
    //   224: aload 12
    //   226: iconst_1
    //   227: aaload
    //   228: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   231: astore 10
    //   233: aload 10
    //   235: invokevirtual 91	java/io/File:exists	()Z
    //   238: istore 5
    //   240: iload 5
    //   242: ifne +38 -> 280
    //   245: aload 10
    //   247: invokevirtual 327	java/io/File:createNewFile	()Z
    //   250: istore 5
    //   252: iload 5
    //   254: ifne +26 -> 280
    //   257: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   260: invokeinterface 196 1 0
    //   265: invokeinterface 134 1 0
    //   270: iconst_0
    //   271: ireturn
    //   272: astore 13
    //   274: iconst_0
    //   275: istore 5
    //   277: goto -25 -> 252
    //   280: new 142	java/io/RandomAccessFile
    //   283: dup
    //   284: aload 10
    //   286: ldc_w 329
    //   289: invokespecial 147	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   292: astore 10
    //   294: aload 10
    //   296: ifnonnull +26 -> 322
    //   299: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   302: invokeinterface 196 1 0
    //   307: invokeinterface 134 1 0
    //   312: iconst_0
    //   313: ireturn
    //   314: astore 10
    //   316: aconst_null
    //   317: astore 10
    //   319: goto -25 -> 294
    //   322: iload_3
    //   323: invokestatic 332	com/tencent/mapsdk/rastercore/d$a:b	(I)[B
    //   326: astore 13
    //   328: aload 13
    //   330: invokestatic 163	com/tencent/mapsdk/rastercore/d$a:b	([B)[B
    //   333: pop
    //   334: aload 10
    //   336: invokevirtual 333	java/io/RandomAccessFile:length	()J
    //   339: lstore 6
    //   341: aload 10
    //   343: lload 6
    //   345: invokevirtual 151	java/io/RandomAccessFile:seek	(J)V
    //   348: aload 10
    //   350: aload 13
    //   352: invokevirtual 337	java/io/RandomAccessFile:write	([B)V
    //   355: aload 10
    //   357: aload_1
    //   358: invokevirtual 337	java/io/RandomAccessFile:write	([B)V
    //   361: aload 10
    //   363: invokevirtual 340	java/io/RandomAccessFile:close	()V
    //   366: new 34	java/io/File
    //   369: dup
    //   370: aload 12
    //   372: iconst_0
    //   373: aaload
    //   374: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   377: astore_1
    //   378: aload_1
    //   379: invokevirtual 91	java/io/File:exists	()Z
    //   382: istore 5
    //   384: iload 5
    //   386: ifne +44 -> 430
    //   389: aload_1
    //   390: invokevirtual 327	java/io/File:createNewFile	()Z
    //   393: istore 5
    //   395: iload 5
    //   397: ifne +33 -> 430
    //   400: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   403: invokeinterface 196 1 0
    //   408: invokeinterface 134 1 0
    //   413: iconst_0
    //   414: ireturn
    //   415: astore_1
    //   416: lconst_0
    //   417: lstore 6
    //   419: goto -53 -> 366
    //   422: astore 10
    //   424: iconst_0
    //   425: istore 5
    //   427: goto -32 -> 395
    //   430: new 142	java/io/RandomAccessFile
    //   433: dup
    //   434: aload_1
    //   435: ldc_w 329
    //   438: invokespecial 147	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   441: astore_1
    //   442: aload_1
    //   443: ifnonnull +18 -> 461
    //   446: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   449: invokeinterface 196 1 0
    //   454: invokeinterface 134 1 0
    //   459: iconst_0
    //   460: ireturn
    //   461: aload_1
    //   462: invokevirtual 333	java/io/RandomAccessFile:length	()J
    //   465: lstore 8
    //   467: lload 8
    //   469: lconst_0
    //   470: lcmp
    //   471: ifne +22 -> 493
    //   474: ldc_w 341
    //   477: newarray byte
    //   479: astore 10
    //   481: aload 10
    //   483: iconst_m1
    //   484: invokestatic 345	java/util/Arrays:fill	([BB)V
    //   487: aload_1
    //   488: aload 10
    //   490: invokevirtual 337	java/io/RandomAccessFile:write	([B)V
    //   493: aload_2
    //   494: invokevirtual 66	com/tencent/mapsdk/rastercore/tile/a:b	()I
    //   497: aload_2
    //   498: invokevirtual 68	com/tencent/mapsdk/rastercore/tile/a:c	()I
    //   501: invokestatic 140	com/tencent/mapsdk/rastercore/tile/a/a:a	(II)I
    //   504: istore_3
    //   505: iload_3
    //   506: ifge +30 -> 536
    //   509: aload_1
    //   510: invokevirtual 340	java/io/RandomAccessFile:close	()V
    //   513: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   516: invokeinterface 196 1 0
    //   521: invokeinterface 134 1 0
    //   526: iconst_0
    //   527: ireturn
    //   528: astore 10
    //   530: lconst_0
    //   531: lstore 8
    //   533: goto -66 -> 467
    //   536: iload_3
    //   537: iconst_4
    //   538: imul
    //   539: i2l
    //   540: lstore 8
    //   542: aload_1
    //   543: lload 8
    //   545: invokevirtual 151	java/io/RandomAccessFile:seek	(J)V
    //   548: lload 6
    //   550: l2i
    //   551: istore_3
    //   552: iload_3
    //   553: invokestatic 332	com/tencent/mapsdk/rastercore/d$a:b	(I)[B
    //   556: astore_2
    //   557: aload_2
    //   558: invokestatic 163	com/tencent/mapsdk/rastercore/d$a:b	([B)[B
    //   561: pop
    //   562: aload_1
    //   563: aload_2
    //   564: invokevirtual 337	java/io/RandomAccessFile:write	([B)V
    //   567: aload_1
    //   568: invokevirtual 340	java/io/RandomAccessFile:close	()V
    //   571: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   574: invokeinterface 196 1 0
    //   579: invokeinterface 134 1 0
    //   584: iconst_1
    //   585: ireturn
    //   586: astore_1
    //   587: getstatic 25	com/tencent/mapsdk/rastercore/tile/a/a:a	Ljava/util/concurrent/locks/ReadWriteLock;
    //   590: invokeinterface 196 1 0
    //   595: invokeinterface 134 1 0
    //   600: aload_1
    //   601: athrow
    //   602: astore 10
    //   604: goto -111 -> 493
    //   607: astore_1
    //   608: goto -95 -> 513
    //   611: astore_2
    //   612: goto -64 -> 548
    //   615: astore_1
    //   616: goto -45 -> 571
    //   619: astore_1
    //   620: aload 11
    //   622: astore_1
    //   623: goto -181 -> 442
    //   626: astore_1
    //   627: goto -208 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	this	a
    //   0	630	1	paramArrayOfByte	byte[]
    //   0	630	2	parama	com.tencent.mapsdk.rastercore.tile.a
    //   57	496	3	i	int
    //   73	24	4	j	int
    //   198	228	5	bool	boolean
    //   339	210	6	l1	long
    //   465	79	8	l2	long
    //   20	275	10	localObject1	Object
    //   314	1	10	localException1	Exception
    //   317	45	10	localObject2	Object
    //   422	1	10	localException2	Exception
    //   479	10	10	arrayOfByte1	byte[]
    //   528	1	10	localException3	Exception
    //   602	1	10	localException4	Exception
    //   1	620	11	localObject3	Object
    //   161	210	12	arrayOfString	String[]
    //   272	1	13	localException5	Exception
    //   326	25	13	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   245	252	272	java/lang/Exception
    //   280	294	314	java/lang/Exception
    //   334	341	415	java/lang/Exception
    //   389	395	422	java/lang/Exception
    //   461	467	528	java/lang/Exception
    //   16	22	586	finally
    //   42	93	586	finally
    //   133	136	586	finally
    //   155	163	586	finally
    //   168	200	586	finally
    //   220	240	586	finally
    //   245	252	586	finally
    //   280	294	586	finally
    //   322	334	586	finally
    //   334	341	586	finally
    //   341	366	586	finally
    //   366	384	586	finally
    //   389	395	586	finally
    //   430	442	586	finally
    //   461	467	586	finally
    //   474	487	586	finally
    //   487	493	586	finally
    //   493	505	586	finally
    //   509	513	586	finally
    //   542	548	586	finally
    //   552	562	586	finally
    //   562	571	586	finally
    //   487	493	602	java/lang/Exception
    //   509	513	607	java/lang/Exception
    //   542	548	611	java/lang/Exception
    //   562	571	615	java/lang/Exception
    //   430	442	619	java/lang/Exception
    //   341	366	626	java/lang/Exception
  }
  
  public final boolean b()
  {
    a.writeLock().lock();
    try
    {
      com.tencent.mapsdk.rastercore.f.b.b(c());
      return true;
    }
    finally
    {
      a.writeLock().unlock();
    }
  }
  
  @SuppressLint({"NewApi"})
  public final String c()
  {
    int j = 1;
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    if (this.c == null) {
      return null;
    }
    int i = j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = this.c.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
      int k = this.c.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
      if ((i != 0) || (k != 0)) {
        break label174;
      }
    }
    label174:
    for (i = j;; i = 0)
    {
      if ((bool) && (i != 0)) {}
      for (;;)
      {
        try
        {
          String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + d;
          d.a.b(str1);
          return str1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          System.out.println(localException.toString());
          return null;
        }
        String str2 = this.c.getFileStreamPath("") + File.separator + d;
      }
    }
  }
  
  public final void d()
  {
    Object localObject1 = new StringBuilder(256);
    Object localObject2 = c();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    do
    {
      return;
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/glGrid");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new File((String)localObject1);
    } while ((!((File)localObject2).isDirectory()) || (!((File)localObject2).exists()));
    com.tencent.mapsdk.rastercore.f.b.b((String)localObject1);
  }
  
  static final class a
  {
    public static final a a = new a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.a.a
 * JD-Core Version:    0.7.0.1
 */