package com.tencent.luggage.wxa.gq;

import android.media.MediaExtractor;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  extends c
{
  private static int F;
  private static int G;
  private byte[] A = new byte[this.z];
  private byte[] B = new byte[3536];
  private int C = 3536;
  private byte[] D = new byte[3536];
  private int E = 0;
  private MediaExtractor s;
  private com.tencent.luggage.wxa.hd.e t;
  private i u;
  private String v = null;
  private int w = 2;
  private long x = 0L;
  private long y = 0L;
  private int z = 14144;
  
  public e(com.tencent.luggage.wxa.gt.d paramd, com.tencent.luggage.wxa.gv.c paramc)
  {
    super(paramd, paramc);
  }
  
  private void B()
  {
    try
    {
      if (this.s != null)
      {
        this.s.release();
        this.s = null;
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaExtractor", new Object[0]);
    }
    D();
  }
  
  private void C()
  {
    try
    {
      if (this.t != null)
      {
        this.t.c();
        this.t.a();
        this.t = null;
        return;
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaCodec", new Object[0]);
    }
  }
  
  private void D()
  {
    try
    {
      if (this.u != null)
      {
        this.u.close();
        this.u = null;
        return;
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseDataSource", new Object[0]);
    }
  }
  
  private void a(com.tencent.luggage.wxa.gm.d paramd, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "pushBuffer chunk is null");
      return;
    }
    int i = paramArrayOfByte.length;
    if (i == 3536)
    {
      if (this.E > 0) {
        c(paramd);
      }
      a(paramd, paramArrayOfByte);
      return;
    }
    if (i != 3536)
    {
      if (i > this.z)
      {
        for (;;)
        {
          j = this.z;
          if (j >= i) {
            break;
          }
          this.z = (j + 3536);
        }
        byte[] arrayOfByte = new byte[j];
        j = this.E;
        if (j > 0) {
          System.arraycopy(this.A, 0, arrayOfByte, 0, j);
        }
        this.A = arrayOfByte;
      }
      int j = this.E;
      int k = j + i;
      System.arraycopy(paramArrayOfByte, 0, this.A, j, i);
      j = k / 3536;
      k %= 3536;
      i = 0;
      while (i < j)
      {
        paramArrayOfByte = new byte[3536];
        System.arraycopy(this.A, i * 3536, paramArrayOfByte, 0, 3536);
        a(paramd, paramArrayOfByte);
        i += 1;
      }
      System.arraycopy(this.A, j * 3536, this.D, 0, k);
      Arrays.fill(this.A, 0, this.z, (byte)0);
      System.arraycopy(this.D, 0, this.A, 0, k);
      this.E = k;
    }
  }
  
  public void A()
  {
    B();
    C();
    if (this.e != null)
    {
      this.e.b();
      this.e.d();
      this.e = null;
    }
    this.g = null;
    this.v = null;
    this.o = 0;
    this.p = 0;
    this.x = 0L;
    this.y = 0L;
  }
  
  protected void a(com.tencent.luggage.wxa.gm.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    if (this.e != null)
    {
      a(paramByteBuffer, paramInt);
      return;
    }
    b(paramd, paramByteBuffer, paramInt);
  }
  
  protected void a(com.tencent.luggage.wxa.gm.d paramd, byte[] paramArrayOfByte)
  {
    com.tencent.luggage.wxa.gm.e locale = com.tencent.luggage.wxa.gn.e.a().b();
    locale.f = paramArrayOfByte;
    locale.b = this.o;
    locale.c = this.p;
    locale.d = this.w;
    paramd.a(locale);
    a(locale);
  }
  
  protected void a(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt != this.C)
    {
      this.C = paramInt;
      this.B = new byte[paramInt];
    }
    paramByteBuffer.get(this.B);
    if (this.b.a().A) {
      com.tencent.luggage.wxa.gp.a.a(this.B, w().l);
    }
    this.e.a(this.B);
  }
  
  protected void b(com.tencent.luggage.wxa.gm.d paramd)
  {
    if (this.e != null)
    {
      this.e.b();
      com.tencent.luggage.wxa.gn.a.a().b(paramd.a);
      if (j())
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
        this.e.c();
        return;
      }
      if (i())
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
        this.e.c();
        s();
        return;
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
      a(paramd);
      return;
    }
    c(paramd);
    paramd.f();
  }
  
  protected void b(com.tencent.luggage.wxa.gm.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    if (3536 == paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      paramByteBuffer.get(arrayOfByte);
      paramByteBuffer = arrayOfByte;
    }
    else
    {
      if (paramInt != this.C)
      {
        this.C = paramInt;
        this.B = new byte[paramInt];
      }
      Arrays.fill(this.B, 0, this.C, (byte)0);
      paramByteBuffer.get(this.B, 0, this.C);
      paramByteBuffer = this.B;
    }
    if (this.b.a().A) {
      com.tencent.luggage.wxa.gp.a.a(paramByteBuffer, w().l);
    }
    a(paramd, paramByteBuffer, this.x);
  }
  
  protected void c(com.tencent.luggage.wxa.gm.d paramd)
  {
    int i = this.E;
    if (i <= 0) {
      return;
    }
    byte[] arrayOfByte;
    if (i > 3536)
    {
      int j = i / 3536;
      int k = i % 3536;
      i = 0;
      while (i < j)
      {
        arrayOfByte = new byte[3536];
        System.arraycopy(this.A, i * 3536, arrayOfByte, 0, 3536);
        a(paramd, arrayOfByte);
        i += 1;
      }
      System.arraycopy(this.A, j * 3536, this.D, 0, k);
      Arrays.fill(this.A, 0, this.z, (byte)0);
      System.arraycopy(this.D, 0, this.A, 0, k);
      this.E = k;
    }
    i = this.E;
    if (i <= 3536)
    {
      arrayOfByte = new byte[3536];
      System.arraycopy(this.A, 0, arrayOfByte, 0, i);
      a(paramd, arrayOfByte);
      this.E = 0;
    }
  }
  
  /* Error */
  protected void r()
  {
    // Byte code:
    //   0: ldc 250
    //   2: astore 11
    //   4: ldc 252
    //   6: astore 12
    //   8: ldc 64
    //   10: ldc 254
    //   12: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: new 59	android/media/MediaExtractor
    //   19: dup
    //   20: invokespecial 256	android/media/MediaExtractor:<init>	()V
    //   23: putfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   26: getstatic 261	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 23
    //   31: if_icmplt +104 -> 135
    //   34: aload_0
    //   35: getfield 264	com/tencent/luggage/wxa/gq/e:c	Lcom/tencent/luggage/wxa/if/b;
    //   38: getfield 266	com/tencent/luggage/wxa/if/b:b	Ljava/lang/String;
    //   41: ifnull +94 -> 135
    //   44: aload_0
    //   45: getfield 264	com/tencent/luggage/wxa/gq/e:c	Lcom/tencent/luggage/wxa/if/b;
    //   48: getfield 266	com/tencent/luggage/wxa/if/b:b	Ljava/lang/String;
    //   51: ldc_w 268
    //   54: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +78 -> 135
    //   60: aload_0
    //   61: getfield 264	com/tencent/luggage/wxa/gq/e:c	Lcom/tencent/luggage/wxa/if/b;
    //   64: getfield 276	com/tencent/luggage/wxa/if/b:C	Ljava/nio/ByteBuffer;
    //   67: ifnull +68 -> 135
    //   70: ldc 64
    //   72: ldc_w 278
    //   75: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: new 280	com/tencent/luggage/wxa/qo/a
    //   81: dup
    //   82: aload_0
    //   83: getfield 264	com/tencent/luggage/wxa/gq/e:c	Lcom/tencent/luggage/wxa/if/b;
    //   86: getfield 276	com/tencent/luggage/wxa/if/b:C	Ljava/nio/ByteBuffer;
    //   89: invokespecial 283	com/tencent/luggage/wxa/qo/a:<init>	(Ljava/nio/ByteBuffer;)V
    //   92: astore 10
    //   94: aload_0
    //   95: getfield 89	com/tencent/luggage/wxa/gq/e:u	Lcom/tencent/luggage/wxa/gq/i;
    //   98: ifnull +10 -> 108
    //   101: aload_0
    //   102: getfield 89	com/tencent/luggage/wxa/gq/e:u	Lcom/tencent/luggage/wxa/gq/i;
    //   105: invokevirtual 94	com/tencent/luggage/wxa/gq/i:close	()V
    //   108: aload_0
    //   109: new 91	com/tencent/luggage/wxa/gq/i
    //   112: dup
    //   113: aload 10
    //   115: invokespecial 286	com/tencent/luggage/wxa/gq/i:<init>	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)V
    //   118: putfield 89	com/tencent/luggage/wxa/gq/e:u	Lcom/tencent/luggage/wxa/gq/i;
    //   121: aload_0
    //   122: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   125: aload_0
    //   126: getfield 89	com/tencent/luggage/wxa/gq/e:u	Lcom/tencent/luggage/wxa/gq/i;
    //   129: invokevirtual 290	android/media/MediaExtractor:setDataSource	(Landroid/media/MediaDataSource;)V
    //   132: goto +14 -> 146
    //   135: aload_0
    //   136: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   139: aload_0
    //   140: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   143: invokevirtual 293	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   150: invokevirtual 297	android/media/MediaExtractor:getTrackCount	()I
    //   153: istore_2
    //   154: ldc 64
    //   156: ldc_w 299
    //   159: iconst_1
    //   160: anewarray 68	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: iload_2
    //   166: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: iconst_0
    //   174: istore_1
    //   175: iload_1
    //   176: iload_2
    //   177: if_icmpge +1930 -> 2107
    //   180: aload_0
    //   181: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   184: iload_1
    //   185: invokevirtual 312	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   188: astore 10
    //   190: aload_0
    //   191: aload 10
    //   193: ldc_w 314
    //   196: invokevirtual 320	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   199: putfield 35	com/tencent/luggage/wxa/gq/e:v	Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 35	com/tencent/luggage/wxa/gq/e:v	Ljava/lang/String;
    //   206: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +1891 -> 2100
    //   212: aload_0
    //   213: getfield 35	com/tencent/luggage/wxa/gq/e:v	Ljava/lang/String;
    //   216: ldc_w 328
    //   219: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   222: ifeq +1878 -> 2100
    //   225: goto +3 -> 228
    //   228: aload 10
    //   230: ifnonnull +31 -> 261
    //   233: ldc 64
    //   235: ldc_w 330
    //   238: invokestatic 102	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: sipush 703
    //   245: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   253: invokevirtual 335	com/tencent/luggage/wxa/gq/e:e	(I)V
    //   256: aload_0
    //   257: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   260: return
    //   261: ldc 64
    //   263: ldc_w 337
    //   266: iconst_1
    //   267: anewarray 68	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 10
    //   274: aastore
    //   275: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload_0
    //   279: aload 10
    //   281: ldc_w 339
    //   284: invokevirtual 343	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   287: putfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   290: aload_0
    //   291: aload 10
    //   293: ldc 252
    //   295: invokevirtual 343	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   298: putfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   301: aload_0
    //   302: aload 10
    //   304: ldc_w 345
    //   307: invokevirtual 349	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   310: putfield 41	com/tencent/luggage/wxa/gq/e:y	J
    //   313: invokestatic 213	com/tencent/luggage/wxa/gn/a:a	()Lcom/tencent/luggage/wxa/gn/a;
    //   316: aload_0
    //   317: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   320: invokevirtual 351	com/tencent/luggage/wxa/gn/a:d	(Ljava/lang/String;)Z
    //   323: ifeq +362 -> 685
    //   326: new 353	java/io/File
    //   329: dup
    //   330: aload_0
    //   331: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   334: invokestatic 357	com/tencent/luggage/wxa/gw/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   337: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   340: astore 14
    //   342: new 353	java/io/File
    //   345: dup
    //   346: aload_0
    //   347: getfield 264	com/tencent/luggage/wxa/gq/e:c	Lcom/tencent/luggage/wxa/if/b;
    //   350: getfield 362	com/tencent/luggage/wxa/if/b:n	Ljava/lang/String;
    //   353: aload_0
    //   354: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   357: invokestatic 365	com/tencent/luggage/wxa/gw/a:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   360: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: astore 15
    //   365: aload 14
    //   367: invokevirtual 368	java/io/File:exists	()Z
    //   370: ifne +36 -> 406
    //   373: aload 15
    //   375: invokevirtual 368	java/io/File:exists	()Z
    //   378: ifeq +6 -> 384
    //   381: goto +25 -> 406
    //   384: ldc 64
    //   386: ldc_w 370
    //   389: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: invokestatic 213	com/tencent/luggage/wxa/gn/a:a	()Lcom/tencent/luggage/wxa/gn/a;
    //   395: aload_0
    //   396: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   399: invokevirtual 372	com/tencent/luggage/wxa/gn/a:c	(Ljava/lang/String;)Z
    //   402: pop
    //   403: goto +282 -> 685
    //   406: aload_0
    //   407: invokevirtual 375	com/tencent/luggage/wxa/gq/e:n	()Lcom/tencent/luggage/wxa/gm/d;
    //   410: astore 13
    //   412: aload 13
    //   414: invokevirtual 376	com/tencent/luggage/wxa/gm/d:a	()V
    //   417: aload 13
    //   419: aload_0
    //   420: getfield 41	com/tencent/luggage/wxa/gq/e:y	J
    //   423: ldc2_w 377
    //   426: ldiv
    //   427: invokevirtual 381	com/tencent/luggage/wxa/gm/d:a	(J)V
    //   430: aload_0
    //   431: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   434: astore 16
    //   436: aload 14
    //   438: invokevirtual 368	java/io/File:exists	()Z
    //   441: ifne +17 -> 458
    //   444: aload 15
    //   446: invokevirtual 368	java/io/File:exists	()Z
    //   449: ifeq +9 -> 458
    //   452: iconst_1
    //   453: istore 7
    //   455: goto +6 -> 461
    //   458: iconst_0
    //   459: istore 7
    //   461: new 383	com/tencent/luggage/wxa/gp/b
    //   464: dup
    //   465: aload 16
    //   467: iload 7
    //   469: aload_0
    //   470: getfield 264	com/tencent/luggage/wxa/gq/e:c	Lcom/tencent/luggage/wxa/if/b;
    //   473: getfield 362	com/tencent/luggage/wxa/if/b:n	Ljava/lang/String;
    //   476: invokespecial 386	com/tencent/luggage/wxa/gp/b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   479: astore 14
    //   481: ldc 64
    //   483: ldc_w 388
    //   486: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_0
    //   490: invokevirtual 222	com/tencent/luggage/wxa/gq/e:j	()Z
    //   493: ifeq +6 -> 499
    //   496: goto +113 -> 609
    //   499: aload_0
    //   500: invokevirtual 390	com/tencent/luggage/wxa/gq/e:o	()V
    //   503: aload 14
    //   505: sipush 3536
    //   508: invokevirtual 393	com/tencent/luggage/wxa/gp/b:a	(I)[B
    //   511: astore 15
    //   513: aload 15
    //   515: ifnull +28 -> 543
    //   518: aload_0
    //   519: ldc_w 394
    //   522: putfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   525: aload_0
    //   526: iconst_2
    //   527: putfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   530: aload_0
    //   531: iconst_2
    //   532: putfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   535: aload_0
    //   536: aload 13
    //   538: aload 15
    //   540: invokevirtual 108	com/tencent/luggage/wxa/gq/e:a	(Lcom/tencent/luggage/wxa/gm/d;[B)V
    //   543: aload 13
    //   545: invokevirtual 396	com/tencent/luggage/wxa/gm/d:c	()I
    //   548: ifle +27 -> 575
    //   551: aload 15
    //   553: ifnonnull +22 -> 575
    //   556: aload 13
    //   558: invokevirtual 240	com/tencent/luggage/wxa/gm/d:f	()V
    //   561: getstatic 398	com/tencent/luggage/wxa/gq/e:F	I
    //   564: iconst_1
    //   565: iadd
    //   566: putstatic 398	com/tencent/luggage/wxa/gq/e:F	I
    //   569: iconst_1
    //   570: istore 7
    //   572: goto +40 -> 612
    //   575: aload 13
    //   577: invokevirtual 396	com/tencent/luggage/wxa/gm/d:c	()I
    //   580: ifne +16 -> 596
    //   583: aload 15
    //   585: ifnonnull +11 -> 596
    //   588: aload 13
    //   590: invokevirtual 376	com/tencent/luggage/wxa/gm/d:a	()V
    //   593: goto +16 -> 609
    //   596: aload 15
    //   598: ifnonnull +6 -> 604
    //   601: goto +8 -> 609
    //   604: aload 15
    //   606: ifnonnull -117 -> 489
    //   609: iconst_0
    //   610: istore 7
    //   612: ldc 64
    //   614: ldc_w 400
    //   617: iconst_1
    //   618: anewarray 68	java/lang/Object
    //   621: dup
    //   622: iconst_0
    //   623: iload 7
    //   625: invokestatic 405	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   628: aastore
    //   629: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   632: aload 14
    //   634: invokevirtual 406	com/tencent/luggage/wxa/gp/b:a	()V
    //   637: iload 7
    //   639: ifeq +46 -> 685
    //   642: aload 13
    //   644: aload_0
    //   645: getfield 185	com/tencent/luggage/wxa/gq/e:b	Lcom/tencent/luggage/wxa/gv/c;
    //   648: invokeinterface 190 1 0
    //   653: getfield 408	com/tencent/luggage/wxa/if/b:z	Z
    //   656: invokevirtual 411	com/tencent/luggage/wxa/gm/d:a	(Z)V
    //   659: aload_0
    //   660: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   663: ldc 64
    //   665: ldc_w 413
    //   668: iconst_1
    //   669: anewarray 68	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: getstatic 398	com/tencent/luggage/wxa/gq/e:F	I
    //   677: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   684: return
    //   685: aload_0
    //   686: aload_0
    //   687: getfield 35	com/tencent/luggage/wxa/gq/e:v	Ljava/lang/String;
    //   690: invokestatic 416	com/tencent/luggage/wxa/hd/e:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/hd/e;
    //   693: putfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   696: aload_0
    //   697: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   700: aload 10
    //   702: aconst_null
    //   703: aconst_null
    //   704: iconst_0
    //   705: invokevirtual 419	com/tencent/luggage/wxa/hd/e:a	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   708: aload_0
    //   709: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   712: invokevirtual 420	com/tencent/luggage/wxa/hd/e:b	()V
    //   715: aload_0
    //   716: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   719: invokevirtual 423	com/tencent/luggage/wxa/hd/e:e	()[Ljava/nio/ByteBuffer;
    //   722: astore 13
    //   724: aload_0
    //   725: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   728: invokevirtual 425	com/tencent/luggage/wxa/hd/e:f	()[Ljava/nio/ByteBuffer;
    //   731: astore 14
    //   733: ldc 64
    //   735: ldc_w 427
    //   738: iconst_2
    //   739: anewarray 68	java/lang/Object
    //   742: dup
    //   743: iconst_0
    //   744: aload 10
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: aload_0
    //   750: getfield 35	com/tencent/luggage/wxa/gq/e:v	Ljava/lang/String;
    //   753: aastore
    //   754: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   757: ldc 64
    //   759: ldc_w 429
    //   762: iconst_5
    //   763: anewarray 68	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: aload_0
    //   769: getfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   772: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   775: aastore
    //   776: dup
    //   777: iconst_1
    //   778: aload_0
    //   779: getfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   782: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   785: aastore
    //   786: dup
    //   787: iconst_2
    //   788: aload_0
    //   789: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   792: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   795: aastore
    //   796: dup
    //   797: iconst_3
    //   798: aload_0
    //   799: getfield 41	com/tencent/luggage/wxa/gq/e:y	J
    //   802: invokestatic 434	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   805: aastore
    //   806: dup
    //   807: iconst_4
    //   808: aload_0
    //   809: getfield 185	com/tencent/luggage/wxa/gq/e:b	Lcom/tencent/luggage/wxa/gv/c;
    //   812: invokeinterface 190 1 0
    //   817: getfield 435	com/tencent/luggage/wxa/if/b:a	Ljava/lang/String;
    //   820: aastore
    //   821: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   824: aload_0
    //   825: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   828: iconst_0
    //   829: invokevirtual 438	android/media/MediaExtractor:selectTrack	(I)V
    //   832: new 440	android/media/MediaCodec$BufferInfo
    //   835: dup
    //   836: invokespecial 441	android/media/MediaCodec$BufferInfo:<init>	()V
    //   839: astore 16
    //   841: aload_0
    //   842: invokevirtual 375	com/tencent/luggage/wxa/gq/e:n	()Lcom/tencent/luggage/wxa/gm/d;
    //   845: astore 15
    //   847: aload 15
    //   849: invokevirtual 376	com/tencent/luggage/wxa/gm/d:a	()V
    //   852: aload_0
    //   853: getfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   856: aload_0
    //   857: getfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   860: aload_0
    //   861: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   864: invokestatic 446	com/tencent/luggage/wxa/gt/a:a	(III)Z
    //   867: ifne +43 -> 910
    //   870: ldc 64
    //   872: ldc_w 448
    //   875: invokestatic 102	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: aload_0
    //   879: new 450	com/tencent/luggage/wxa/gp/f
    //   882: dup
    //   883: aload 15
    //   885: aload_0
    //   886: getfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   889: aload_0
    //   890: getfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   893: aload_0
    //   894: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   897: aload_0
    //   898: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   901: invokespecial 453	com/tencent/luggage/wxa/gp/f:<init>	(Lcom/tencent/luggage/wxa/gm/d;IIILjava/lang/String;)V
    //   904: putfield 128	com/tencent/luggage/wxa/gq/e:e	Lcom/tencent/luggage/wxa/gp/i;
    //   907: goto +32 -> 939
    //   910: getstatic 455	com/tencent/luggage/wxa/gq/e:G	I
    //   913: iconst_1
    //   914: iadd
    //   915: putstatic 455	com/tencent/luggage/wxa/gq/e:G	I
    //   918: ldc 64
    //   920: ldc_w 457
    //   923: iconst_1
    //   924: anewarray 68	java/lang/Object
    //   927: dup
    //   928: iconst_0
    //   929: getstatic 455	com/tencent/luggage/wxa/gq/e:G	I
    //   932: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   935: aastore
    //   936: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   939: aload 15
    //   941: aload_0
    //   942: getfield 41	com/tencent/luggage/wxa/gq/e:y	J
    //   945: ldc2_w 377
    //   948: ldiv
    //   949: invokevirtual 381	com/tencent/luggage/wxa/gm/d:a	(J)V
    //   952: aload 14
    //   954: astore 10
    //   956: iconst_0
    //   957: istore_1
    //   958: iconst_0
    //   959: istore_2
    //   960: iconst_0
    //   961: istore_3
    //   962: iload_1
    //   963: ifne +786 -> 1749
    //   966: iload_2
    //   967: bipush 50
    //   969: if_icmpge +780 -> 1749
    //   972: aload_0
    //   973: invokevirtual 222	com/tencent/luggage/wxa/gq/e:j	()Z
    //   976: ifeq +6 -> 982
    //   979: goto +770 -> 1749
    //   982: aload_0
    //   983: invokevirtual 390	com/tencent/luggage/wxa/gq/e:o	()V
    //   986: iload_2
    //   987: iconst_1
    //   988: iadd
    //   989: istore_2
    //   990: iload_3
    //   991: ifne +1131 -> 2122
    //   994: aload_0
    //   995: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   998: ldc2_w 377
    //   1001: invokevirtual 460	com/tencent/luggage/wxa/hd/e:a	(J)I
    //   1004: istore 6
    //   1006: iload 6
    //   1008: iflt +141 -> 1149
    //   1011: aload 13
    //   1013: iload 6
    //   1015: aaload
    //   1016: astore 14
    //   1018: aload_0
    //   1019: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   1022: aload 14
    //   1024: iconst_0
    //   1025: invokevirtual 464	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   1028: istore 4
    //   1030: iload 4
    //   1032: ifge +19 -> 1051
    //   1035: ldc 64
    //   1037: ldc_w 466
    //   1040: invokestatic 102	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1043: iconst_1
    //   1044: istore_3
    //   1045: iconst_0
    //   1046: istore 4
    //   1048: goto +44 -> 1092
    //   1051: aload_0
    //   1052: aload_0
    //   1053: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   1056: invokevirtual 470	android/media/MediaExtractor:getSampleTime	()J
    //   1059: putfield 39	com/tencent/luggage/wxa/gq/e:x	J
    //   1062: aload_0
    //   1063: getfield 41	com/tencent/luggage/wxa/gq/e:y	J
    //   1066: lconst_0
    //   1067: lcmp
    //   1068: ifne +6 -> 1074
    //   1071: goto +1042 -> 2113
    //   1074: aload_0
    //   1075: getfield 39	com/tencent/luggage/wxa/gq/e:x	J
    //   1078: ldc2_w 471
    //   1081: lmul
    //   1082: aload_0
    //   1083: getfield 41	com/tencent/luggage/wxa/gq/e:y	J
    //   1086: ldiv
    //   1087: lstore 8
    //   1089: goto +1024 -> 2113
    //   1092: aload_0
    //   1093: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   1096: astore 14
    //   1098: aload_0
    //   1099: getfield 39	com/tencent/luggage/wxa/gq/e:x	J
    //   1102: lstore 8
    //   1104: iload_3
    //   1105: ifeq +1011 -> 2116
    //   1108: iconst_4
    //   1109: istore 5
    //   1111: goto +3 -> 1114
    //   1114: aload 14
    //   1116: iload 6
    //   1118: iconst_0
    //   1119: iload 4
    //   1121: lload 8
    //   1123: iload 5
    //   1125: invokevirtual 475	com/tencent/luggage/wxa/hd/e:a	(IIIJI)V
    //   1128: iload_3
    //   1129: istore 5
    //   1131: iload_3
    //   1132: ifne +59 -> 1191
    //   1135: aload_0
    //   1136: getfield 57	com/tencent/luggage/wxa/gq/e:s	Landroid/media/MediaExtractor;
    //   1139: invokevirtual 478	android/media/MediaExtractor:advance	()Z
    //   1142: pop
    //   1143: iload_3
    //   1144: istore 5
    //   1146: goto +45 -> 1191
    //   1149: new 480	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   1156: astore 14
    //   1158: aload 14
    //   1160: ldc_w 483
    //   1163: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload 14
    //   1169: iload 6
    //   1171: invokevirtual 490	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1174: pop
    //   1175: ldc 64
    //   1177: aload 14
    //   1179: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1182: invokestatic 102	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1185: iload_3
    //   1186: istore 5
    //   1188: goto +3 -> 1191
    //   1191: aload_0
    //   1192: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   1195: aload 16
    //   1197: ldc2_w 377
    //   1200: invokevirtual 497	com/tencent/luggage/wxa/hd/e:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1203: istore_3
    //   1204: iload_3
    //   1205: iflt +79 -> 1284
    //   1208: aload 16
    //   1210: getfield 500	android/media/MediaCodec$BufferInfo:size	I
    //   1213: ifle +5 -> 1218
    //   1216: iconst_0
    //   1217: istore_2
    //   1218: aload 10
    //   1220: iload_3
    //   1221: aaload
    //   1222: astore 14
    //   1224: aload 16
    //   1226: getfield 500	android/media/MediaCodec$BufferInfo:size	I
    //   1229: istore 4
    //   1231: iload 4
    //   1233: ifle +13 -> 1246
    //   1236: aload_0
    //   1237: aload 15
    //   1239: aload 14
    //   1241: iload 4
    //   1243: invokevirtual 502	com/tencent/luggage/wxa/gq/e:a	(Lcom/tencent/luggage/wxa/gm/d;Ljava/nio/ByteBuffer;I)V
    //   1246: aload 14
    //   1248: invokevirtual 506	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1251: pop
    //   1252: aload_0
    //   1253: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   1256: iload_3
    //   1257: iconst_0
    //   1258: invokevirtual 509	com/tencent/luggage/wxa/hd/e:a	(IZ)V
    //   1261: aload 16
    //   1263: getfield 512	android/media/MediaCodec$BufferInfo:flags	I
    //   1266: iconst_4
    //   1267: iand
    //   1268: ifeq +860 -> 2128
    //   1271: ldc 64
    //   1273: ldc_w 514
    //   1276: invokestatic 102	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1279: iconst_1
    //   1280: istore_1
    //   1281: goto +847 -> 2128
    //   1284: iload_3
    //   1285: bipush 253
    //   1287: if_icmpne +23 -> 1310
    //   1290: aload_0
    //   1291: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   1294: invokevirtual 425	com/tencent/luggage/wxa/hd/e:f	()[Ljava/nio/ByteBuffer;
    //   1297: astore 10
    //   1299: ldc 64
    //   1301: ldc_w 516
    //   1304: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1307: goto +821 -> 2128
    //   1310: iload_3
    //   1311: bipush 254
    //   1313: if_icmpne +389 -> 1702
    //   1316: aload_0
    //   1317: getfield 78	com/tencent/luggage/wxa/gq/e:t	Lcom/tencent/luggage/wxa/hd/e;
    //   1320: invokevirtual 519	com/tencent/luggage/wxa/hd/e:d	()Landroid/media/MediaFormat;
    //   1323: astore 17
    //   1325: new 480	java/lang/StringBuilder
    //   1328: dup
    //   1329: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   1332: astore 14
    //   1334: aload 14
    //   1336: ldc_w 521
    //   1339: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: aload 14
    //   1345: aload 17
    //   1347: invokevirtual 524	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: ldc 64
    //   1353: aload 14
    //   1355: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1361: aload_0
    //   1362: aload 17
    //   1364: ldc_w 339
    //   1367: invokevirtual 343	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1370: putfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   1373: aload_0
    //   1374: aload 17
    //   1376: aload 12
    //   1378: invokevirtual 343	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1381: putfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   1384: aload 11
    //   1386: astore 14
    //   1388: aload 17
    //   1390: aload 14
    //   1392: invokevirtual 527	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1395: ifeq +17 -> 1412
    //   1398: aload_0
    //   1399: aload 17
    //   1401: aload 14
    //   1403: invokevirtual 343	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1406: putfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1409: goto +48 -> 1457
    //   1412: aload 17
    //   1414: ldc_w 529
    //   1417: invokevirtual 527	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1420: ifeq +37 -> 1457
    //   1423: aload 17
    //   1425: ldc_w 529
    //   1428: invokevirtual 343	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1431: istore_3
    //   1432: iload_3
    //   1433: bipush 16
    //   1435: if_icmpne +11 -> 1446
    //   1438: aload_0
    //   1439: iconst_2
    //   1440: putfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1443: goto +14 -> 1457
    //   1446: iload_3
    //   1447: bipush 8
    //   1449: if_icmpne +8 -> 1457
    //   1452: aload_0
    //   1453: iconst_3
    //   1454: putfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1457: ldc 64
    //   1459: ldc_w 531
    //   1462: iconst_5
    //   1463: anewarray 68	java/lang/Object
    //   1466: dup
    //   1467: iconst_0
    //   1468: aload_0
    //   1469: getfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   1472: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1475: aastore
    //   1476: dup
    //   1477: iconst_1
    //   1478: aload_0
    //   1479: getfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   1482: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1485: aastore
    //   1486: dup
    //   1487: iconst_2
    //   1488: aload_0
    //   1489: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1492: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1495: aastore
    //   1496: dup
    //   1497: iconst_3
    //   1498: aload_0
    //   1499: getfield 185	com/tencent/luggage/wxa/gq/e:b	Lcom/tencent/luggage/wxa/gv/c;
    //   1502: invokeinterface 190 1 0
    //   1507: getfield 435	com/tencent/luggage/wxa/if/b:a	Ljava/lang/String;
    //   1510: aastore
    //   1511: dup
    //   1512: iconst_4
    //   1513: aload_0
    //   1514: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   1517: aastore
    //   1518: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1521: aload_0
    //   1522: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1525: invokestatic 534	com/tencent/luggage/wxa/gt/a:d	(I)Z
    //   1528: ifne +49 -> 1577
    //   1531: ldc 64
    //   1533: ldc_w 536
    //   1536: iconst_1
    //   1537: anewarray 68	java/lang/Object
    //   1540: dup
    //   1541: iconst_0
    //   1542: aload_0
    //   1543: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1546: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1549: aastore
    //   1550: invokestatic 538	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1553: aload_0
    //   1554: sipush 709
    //   1557: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1560: aload_0
    //   1561: aload_0
    //   1562: getfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1565: invokevirtual 335	com/tencent/luggage/wxa/gq/e:e	(I)V
    //   1568: aload_0
    //   1569: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   1572: aload_0
    //   1573: invokespecial 124	com/tencent/luggage/wxa/gq/e:C	()V
    //   1576: return
    //   1577: aload_0
    //   1578: getfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   1581: aload_0
    //   1582: getfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   1585: aload_0
    //   1586: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1589: invokestatic 446	com/tencent/luggage/wxa/gt/a:a	(III)Z
    //   1592: ifeq +53 -> 1645
    //   1595: aload_0
    //   1596: getfield 128	com/tencent/luggage/wxa/gq/e:e	Lcom/tencent/luggage/wxa/gp/i;
    //   1599: ifnull +46 -> 1645
    //   1602: ldc 64
    //   1604: ldc_w 540
    //   1607: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1610: aload_0
    //   1611: getfield 128	com/tencent/luggage/wxa/gq/e:e	Lcom/tencent/luggage/wxa/gp/i;
    //   1614: invokeinterface 133 1 0
    //   1619: aload_0
    //   1620: getfield 128	com/tencent/luggage/wxa/gq/e:e	Lcom/tencent/luggage/wxa/gp/i;
    //   1623: invokeinterface 136 1 0
    //   1628: aload_0
    //   1629: aconst_null
    //   1630: putfield 128	com/tencent/luggage/wxa/gq/e:e	Lcom/tencent/luggage/wxa/gp/i;
    //   1633: iload_2
    //   1634: istore_3
    //   1635: aload 10
    //   1637: astore 14
    //   1639: iload_1
    //   1640: istore 4
    //   1642: goto +495 -> 2137
    //   1645: iload_2
    //   1646: istore_3
    //   1647: aload 10
    //   1649: astore 14
    //   1651: iload_1
    //   1652: istore 4
    //   1654: aload_0
    //   1655: getfield 128	com/tencent/luggage/wxa/gq/e:e	Lcom/tencent/luggage/wxa/gp/i;
    //   1658: ifnull +479 -> 2137
    //   1661: ldc 64
    //   1663: ldc_w 542
    //   1666: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1669: aload_0
    //   1670: getfield 128	com/tencent/luggage/wxa/gq/e:e	Lcom/tencent/luggage/wxa/gp/i;
    //   1673: aload_0
    //   1674: getfield 142	com/tencent/luggage/wxa/gq/e:o	I
    //   1677: aload_0
    //   1678: getfield 145	com/tencent/luggage/wxa/gq/e:p	I
    //   1681: aload_0
    //   1682: getfield 37	com/tencent/luggage/wxa/gq/e:w	I
    //   1685: invokeinterface 545 4 0
    //   1690: iload_2
    //   1691: istore_3
    //   1692: aload 10
    //   1694: astore 14
    //   1696: iload_1
    //   1697: istore 4
    //   1699: goto +438 -> 2137
    //   1702: new 480	java/lang/StringBuilder
    //   1705: dup
    //   1706: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   1709: astore 14
    //   1711: aload 14
    //   1713: ldc_w 547
    //   1716: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: pop
    //   1720: aload 14
    //   1722: iload_3
    //   1723: invokevirtual 490	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: pop
    //   1727: ldc 64
    //   1729: aload 14
    //   1731: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1734: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1737: iload_2
    //   1738: istore_3
    //   1739: aload 10
    //   1741: astore 14
    //   1743: iload_1
    //   1744: istore 4
    //   1746: goto +391 -> 2137
    //   1749: aload_0
    //   1750: getfield 41	com/tencent/luggage/wxa/gq/e:y	J
    //   1753: ldc2_w 377
    //   1756: ldiv
    //   1757: aload_0
    //   1758: getfield 39	com/tencent/luggage/wxa/gq/e:x	J
    //   1761: ldc2_w 377
    //   1764: ldiv
    //   1765: lsub
    //   1766: ldc2_w 548
    //   1769: lcmp
    //   1770: ifge +382 -> 2152
    //   1773: iconst_1
    //   1774: istore 7
    //   1776: goto +3 -> 1779
    //   1779: iload_2
    //   1780: bipush 50
    //   1782: if_icmplt +40 -> 1822
    //   1785: ldc 64
    //   1787: ldc_w 551
    //   1790: iconst_1
    //   1791: anewarray 68	java/lang/Object
    //   1794: dup
    //   1795: iconst_0
    //   1796: iload_2
    //   1797: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1800: aastore
    //   1801: invokestatic 538	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1804: aload_0
    //   1805: sipush 706
    //   1808: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1811: aload_0
    //   1812: aload_0
    //   1813: getfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1816: invokevirtual 335	com/tencent/luggage/wxa/gq/e:e	(I)V
    //   1819: goto +80 -> 1899
    //   1822: ldc 64
    //   1824: ldc_w 553
    //   1827: iconst_1
    //   1828: anewarray 68	java/lang/Object
    //   1831: dup
    //   1832: iconst_0
    //   1833: iload 7
    //   1835: invokestatic 405	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1838: aastore
    //   1839: invokestatic 308	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1842: iload 7
    //   1844: ifeq +12 -> 1856
    //   1847: aload_0
    //   1848: aload 15
    //   1850: invokevirtual 555	com/tencent/luggage/wxa/gq/e:b	(Lcom/tencent/luggage/wxa/gm/d;)V
    //   1853: goto +46 -> 1899
    //   1856: aload 15
    //   1858: invokevirtual 376	com/tencent/luggage/wxa/gm/d:a	()V
    //   1861: goto +38 -> 1899
    //   1864: astore 10
    //   1866: goto +67 -> 1933
    //   1869: astore 10
    //   1871: ldc 64
    //   1873: aload 10
    //   1875: ldc 254
    //   1877: iconst_0
    //   1878: anewarray 68	java/lang/Object
    //   1881: invokestatic 74	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1884: aload_0
    //   1885: sipush 706
    //   1888: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1891: aload_0
    //   1892: aload_0
    //   1893: getfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1896: invokevirtual 335	com/tencent/luggage/wxa/gq/e:e	(I)V
    //   1899: aload_0
    //   1900: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   1903: aload_0
    //   1904: invokespecial 124	com/tencent/luggage/wxa/gq/e:C	()V
    //   1907: aload 15
    //   1909: aload_0
    //   1910: getfield 185	com/tencent/luggage/wxa/gq/e:b	Lcom/tencent/luggage/wxa/gv/c;
    //   1913: invokeinterface 190 1 0
    //   1918: getfield 408	com/tencent/luggage/wxa/if/b:z	Z
    //   1921: invokevirtual 411	com/tencent/luggage/wxa/gm/d:a	(Z)V
    //   1924: ldc 64
    //   1926: ldc_w 557
    //   1929: invokestatic 226	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1932: return
    //   1933: aload_0
    //   1934: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   1937: aload_0
    //   1938: invokespecial 124	com/tencent/luggage/wxa/gq/e:C	()V
    //   1941: aload 10
    //   1943: athrow
    //   1944: astore 10
    //   1946: ldc 64
    //   1948: aload 10
    //   1950: ldc_w 559
    //   1953: iconst_0
    //   1954: anewarray 68	java/lang/Object
    //   1957: invokestatic 74	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1960: aload_0
    //   1961: sipush 716
    //   1964: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1967: aload_0
    //   1968: aload_0
    //   1969: getfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   1972: invokevirtual 335	com/tencent/luggage/wxa/gq/e:e	(I)V
    //   1975: aload_0
    //   1976: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   1979: aload_0
    //   1980: invokespecial 124	com/tencent/luggage/wxa/gq/e:C	()V
    //   1983: return
    //   1984: astore 10
    //   1986: ldc 64
    //   1988: aload 10
    //   1990: ldc_w 561
    //   1993: iconst_0
    //   1994: anewarray 68	java/lang/Object
    //   1997: invokestatic 74	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2000: aload_0
    //   2001: sipush 704
    //   2004: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   2007: aload_0
    //   2008: aload_0
    //   2009: getfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   2012: invokevirtual 335	com/tencent/luggage/wxa/gq/e:e	(I)V
    //   2015: aload_0
    //   2016: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   2019: aload_0
    //   2020: invokespecial 124	com/tencent/luggage/wxa/gq/e:C	()V
    //   2023: return
    //   2024: astore 10
    //   2026: ldc 64
    //   2028: aload 10
    //   2030: ldc_w 563
    //   2033: iconst_0
    //   2034: anewarray 68	java/lang/Object
    //   2037: invokestatic 74	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2040: aload_0
    //   2041: sipush 705
    //   2044: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   2047: aload_0
    //   2048: aload_0
    //   2049: getfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   2052: invokevirtual 335	com/tencent/luggage/wxa/gq/e:e	(I)V
    //   2055: aload_0
    //   2056: invokespecial 122	com/tencent/luggage/wxa/gq/e:B	()V
    //   2059: return
    //   2060: astore 10
    //   2062: ldc 64
    //   2064: aload 10
    //   2066: ldc_w 565
    //   2069: iconst_1
    //   2070: anewarray 68	java/lang/Object
    //   2073: dup
    //   2074: iconst_0
    //   2075: aload_0
    //   2076: getfield 139	com/tencent/luggage/wxa/gq/e:g	Ljava/lang/String;
    //   2079: aastore
    //   2080: invokestatic 74	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2083: aload_0
    //   2084: sipush 702
    //   2087: putfield 332	com/tencent/luggage/wxa/gq/e:f	I
    //   2090: aload_0
    //   2091: iconst_1
    //   2092: invokevirtual 566	com/tencent/luggage/wxa/gq/e:a	(Z)V
    //   2095: aload_0
    //   2096: invokespecial 76	com/tencent/luggage/wxa/gq/e:D	()V
    //   2099: return
    //   2100: iload_1
    //   2101: iconst_1
    //   2102: iadd
    //   2103: istore_1
    //   2104: goto -1929 -> 175
    //   2107: aconst_null
    //   2108: astore 10
    //   2110: goto -1882 -> 228
    //   2113: goto -1021 -> 1092
    //   2116: iconst_0
    //   2117: istore 5
    //   2119: goto -1005 -> 1114
    //   2122: iload_3
    //   2123: istore 5
    //   2125: goto -934 -> 1191
    //   2128: iload_1
    //   2129: istore 4
    //   2131: aload 10
    //   2133: astore 14
    //   2135: iload_2
    //   2136: istore_3
    //   2137: iload 4
    //   2139: istore_1
    //   2140: iload_3
    //   2141: istore_2
    //   2142: iload 5
    //   2144: istore_3
    //   2145: aload 14
    //   2147: astore 10
    //   2149: goto -1187 -> 962
    //   2152: iconst_0
    //   2153: istore 7
    //   2155: goto -376 -> 1779
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2158	0	this	e
    //   174	1966	1	i	int
    //   153	1989	2	j	int
    //   961	1184	3	k	int
    //   1028	1110	4	m	int
    //   1109	1034	5	n	int
    //   1004	166	6	i1	int
    //   453	1701	7	bool	boolean
    //   1087	35	8	l	long
    //   92	1648	10	localObject1	Object
    //   1864	1	10	localObject2	Object
    //   1869	73	10	localException1	Exception
    //   1944	5	10	localIllegalStateException	java.lang.IllegalStateException
    //   1984	5	10	localException2	Exception
    //   2024	5	10	localException3	Exception
    //   2060	5	10	localException4	Exception
    //   2108	40	10	localObject3	Object
    //   2	1383	11	str1	String
    //   6	1371	12	str2	String
    //   410	602	13	localObject4	Object
    //   340	1806	14	localObject5	Object
    //   363	1545	15	localObject6	Object
    //   434	828	16	localObject7	Object
    //   1323	101	17	localMediaFormat	android.media.MediaFormat
    // Exception table:
    //   from	to	target	type
    //   972	979	1864	finally
    //   982	986	1864	finally
    //   994	1006	1864	finally
    //   1018	1030	1864	finally
    //   1035	1043	1864	finally
    //   1051	1071	1864	finally
    //   1074	1089	1864	finally
    //   1092	1104	1864	finally
    //   1114	1128	1864	finally
    //   1135	1143	1864	finally
    //   1149	1185	1864	finally
    //   1191	1204	1864	finally
    //   1208	1216	1864	finally
    //   1224	1231	1864	finally
    //   1236	1246	1864	finally
    //   1246	1279	1864	finally
    //   1290	1307	1864	finally
    //   1316	1384	1864	finally
    //   1388	1409	1864	finally
    //   1412	1432	1864	finally
    //   1438	1443	1864	finally
    //   1452	1457	1864	finally
    //   1457	1568	1864	finally
    //   1577	1633	1864	finally
    //   1654	1690	1864	finally
    //   1702	1737	1864	finally
    //   1749	1773	1864	finally
    //   1785	1819	1864	finally
    //   1822	1842	1864	finally
    //   1847	1853	1864	finally
    //   1856	1861	1864	finally
    //   1871	1899	1864	finally
    //   972	979	1869	java/lang/Exception
    //   982	986	1869	java/lang/Exception
    //   994	1006	1869	java/lang/Exception
    //   1018	1030	1869	java/lang/Exception
    //   1035	1043	1869	java/lang/Exception
    //   1051	1071	1869	java/lang/Exception
    //   1074	1089	1869	java/lang/Exception
    //   1092	1104	1869	java/lang/Exception
    //   1114	1128	1869	java/lang/Exception
    //   1135	1143	1869	java/lang/Exception
    //   1149	1185	1869	java/lang/Exception
    //   1191	1204	1869	java/lang/Exception
    //   1208	1216	1869	java/lang/Exception
    //   1224	1231	1869	java/lang/Exception
    //   1236	1246	1869	java/lang/Exception
    //   1246	1279	1869	java/lang/Exception
    //   1290	1307	1869	java/lang/Exception
    //   1316	1384	1869	java/lang/Exception
    //   1388	1409	1869	java/lang/Exception
    //   1412	1432	1869	java/lang/Exception
    //   1438	1443	1869	java/lang/Exception
    //   1452	1457	1869	java/lang/Exception
    //   1457	1568	1869	java/lang/Exception
    //   1577	1633	1869	java/lang/Exception
    //   1654	1690	1869	java/lang/Exception
    //   1702	1737	1869	java/lang/Exception
    //   1749	1773	1869	java/lang/Exception
    //   1785	1819	1869	java/lang/Exception
    //   1822	1842	1869	java/lang/Exception
    //   1847	1853	1869	java/lang/Exception
    //   1856	1861	1869	java/lang/Exception
    //   715	733	1944	java/lang/IllegalStateException
    //   685	715	1984	java/lang/Exception
    //   146	173	2024	java/lang/Exception
    //   180	225	2024	java/lang/Exception
    //   233	260	2024	java/lang/Exception
    //   261	313	2024	java/lang/Exception
    //   26	108	2060	java/lang/Exception
    //   108	132	2060	java/lang/Exception
    //   135	146	2060	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.e
 * JD-Core Version:    0.7.0.1
 */