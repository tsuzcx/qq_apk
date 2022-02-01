package com.tencent.map.sdk.a;

import java.io.File;
import java.util.List;

public final class ic
  extends Thread
  implements id
{
  private long a;
  private lw b;
  private qe c;
  private boolean d;
  private boolean e;
  private boolean f;
  private List<Integer> g;
  
  public ic(lw paramlw, qe paramqe)
  {
    this.b = paramlw;
    this.c = paramqe;
    this.a = 0L;
    this.f = false;
    this.d = false;
    this.e = false;
  }
  
  private static long a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  private File a(String paramString)
  {
    Object localObject = f();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject == null) || (localObject.length == 0)) {
        return null;
      }
    }
    catch (Exception paramString)
    {
      return null;
    }
    int i = 0;
    while (i < localObject.length)
    {
      String[] arrayOfString = localObject[i].getName().split("_|\\.");
      if ((arrayOfString.length > 1) && (paramString.equals(arrayOfString[0]))) {
        return localObject[i];
      }
      i += 1;
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2 + ".kml";
  }
  
  /* Error */
  private boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +10 -> 11
    //   4: aload_3
    //   5: arraylength
    //   6: bipush 10
    //   8: if_icmpge +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial 47	com/tencent/map/sdk/a/ic:f	()Ljava/io/File;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnull -10 -> 11
    //   24: new 49	java/io/File
    //   27: dup
    //   28: new 72	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   35: aload 4
    //   37: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   40: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   46: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokestatic 101	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   53: iload_2
    //   54: invokestatic 101	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   57: invokestatic 103	com/tencent/map/sdk/a/ic:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 7
    //   71: aload 7
    //   73: invokevirtual 110	java/io/File:exists	()Z
    //   76: ifeq +16 -> 92
    //   79: aload 7
    //   81: invokevirtual 113	java/io/File:delete	()Z
    //   84: ifne +8 -> 92
    //   87: aload 7
    //   89: invokevirtual 116	java/io/File:deleteOnExit	()V
    //   92: aload 7
    //   94: invokevirtual 119	java/io/File:createNewFile	()Z
    //   97: pop
    //   98: aconst_null
    //   99: astore 5
    //   101: aconst_null
    //   102: astore 6
    //   104: aconst_null
    //   105: astore 4
    //   107: aload_3
    //   108: aload_3
    //   109: arraylength
    //   110: bipush 10
    //   112: isub
    //   113: invokestatic 124	com/tencent/map/sdk/a/oo:a	([BI)[B
    //   116: astore 8
    //   118: aload 8
    //   120: ifnull -109 -> 11
    //   123: new 126	java/io/FileOutputStream
    //   126: dup
    //   127: aload 7
    //   129: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore_3
    //   133: aload_3
    //   134: aload 8
    //   136: invokevirtual 133	java/io/FileOutputStream:write	([B)V
    //   139: aload_3
    //   140: invokevirtual 136	java/io/FileOutputStream:flush	()V
    //   143: aload_3
    //   144: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull -142 -> 11
    //   156: aload_3
    //   157: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_3
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_3
    //   166: aload 4
    //   168: astore_3
    //   169: aload_3
    //   170: ifnull -159 -> 11
    //   173: aload_3
    //   174: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_3
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_3
    //   183: aload 5
    //   185: astore_3
    //   186: aload_3
    //   187: ifnull -176 -> 11
    //   190: aload_3
    //   191: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_3
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_3
    //   200: aload 6
    //   202: astore 4
    //   204: aload 4
    //   206: ifnull +8 -> 214
    //   209: aload 4
    //   211: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   214: aload_3
    //   215: athrow
    //   216: astore_3
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_3
    //   220: goto -73 -> 147
    //   223: astore 4
    //   225: goto -11 -> 214
    //   228: astore 5
    //   230: aload_3
    //   231: astore 4
    //   233: aload 5
    //   235: astore_3
    //   236: goto -32 -> 204
    //   239: astore 4
    //   241: goto -55 -> 186
    //   244: astore 4
    //   246: goto -77 -> 169
    //   249: astore 4
    //   251: goto -99 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	ic
    //   0	254	1	paramInt1	int
    //   0	254	2	paramInt2	int
    //   0	254	3	paramArrayOfByte	byte[]
    //   17	193	4	localObject1	Object
    //   223	1	4	localIOException1	java.io.IOException
    //   231	1	4	arrayOfByte1	byte[]
    //   239	1	4	localException	Exception
    //   244	1	4	localIOException2	java.io.IOException
    //   249	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   99	85	5	localObject2	Object
    //   228	6	5	localObject3	Object
    //   102	99	6	localObject4	Object
    //   69	59	7	localFile	File
    //   116	19	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   107	118	149	java/io/FileNotFoundException
    //   123	133	149	java/io/FileNotFoundException
    //   156	160	162	java/io/IOException
    //   107	118	165	java/io/IOException
    //   123	133	165	java/io/IOException
    //   173	177	179	java/io/IOException
    //   107	118	182	java/lang/Exception
    //   123	133	182	java/lang/Exception
    //   190	194	196	java/io/IOException
    //   107	118	199	finally
    //   123	133	199	finally
    //   92	98	216	java/io/IOException
    //   143	147	219	java/io/IOException
    //   209	214	223	java/io/IOException
    //   133	143	228	finally
    //   133	143	239	java/lang/Exception
    //   133	143	244	java/io/IOException
    //   133	143	249	java/io/FileNotFoundException
  }
  
  private boolean a(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return false;
      if (this.g == null) {
        return true;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (!this.g.contains(paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private File f()
  {
    if ((this.b == null) || (this.b.o == null)) {}
    do
    {
      return null;
      localObject = this.b.o.e();
    } while (localObject == null);
    Object localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).mkdirs();
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   12: getfield 174	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 179	com/tencent/map/sdk/a/pf:y	()V
    //   22: aload 4
    //   24: getfield 181	com/tencent/map/sdk/a/pf:b	J
    //   27: lstore_2
    //   28: lconst_0
    //   29: lload_2
    //   30: lcmp
    //   31: ifne +29 -> 60
    //   34: aload 4
    //   36: invokevirtual 184	com/tencent/map/sdk/a/pf:z	()V
    //   39: aload_0
    //   40: iload_1
    //   41: putfield 34	com/tencent/map/sdk/a/ic:d	Z
    //   44: iload_1
    //   45: ifeq +7 -> 52
    //   48: aload_0
    //   49: invokevirtual 187	com/tencent/map/sdk/a/ic:start	()V
    //   52: aload_0
    //   53: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   56: invokevirtual 190	com/tencent/map/sdk/a/lw:k	()V
    //   59: return
    //   60: aload 4
    //   62: invokevirtual 184	com/tencent/map/sdk/a/pf:z	()V
    //   65: goto -26 -> 39
    //   68: astore 5
    //   70: aload 4
    //   72: invokevirtual 184	com/tencent/map/sdk/a/pf:z	()V
    //   75: aload 5
    //   77: athrow
    //   78: astore 4
    //   80: goto -28 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	ic
    //   0	83	1	paramBoolean	boolean
    //   27	3	2	l	long
    //   15	56	4	localpf	pf
    //   78	1	4	localException	Exception
    //   68	8	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	28	68	finally
    //   48	52	78	java/lang/Exception
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final void b()
  {
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void c()
  {
    this.e = false;
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void d()
  {
    this.e = true;
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void e()
  {
    this.f = true;
    this.e = true;
    this.d = false;
    try
    {
      notifyAll();
      interrupt();
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 203	java/lang/Thread:run	()V
    //   4: aload_0
    //   5: getfield 32	com/tencent/map/sdk/a/ic:f	Z
    //   8: ifne +753 -> 761
    //   11: aload_0
    //   12: getfield 36	com/tencent/map/sdk/a/ic:e	Z
    //   15: ifne +59 -> 74
    //   18: aload_0
    //   19: getfield 34	com/tencent/map/sdk/a/ic:d	Z
    //   22: ifeq +52 -> 74
    //   25: aload_0
    //   26: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   29: ifnull +45 -> 74
    //   32: aload_0
    //   33: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   36: getfield 206	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   39: ifnull +35 -> 74
    //   42: aload_0
    //   43: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   46: getfield 206	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   49: invokevirtual 212	com/tencent/map/sdk/a/kl:p	()Landroid/graphics/Rect;
    //   52: pop
    //   53: aload_0
    //   54: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   57: getfield 206	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   60: getfield 216	com/tencent/map/sdk/a/kl:i	Lcom/tencent/map/sdk/a/kc;
    //   63: getfield 221	com/tencent/map/sdk/a/kc:b	Lcom/tencent/map/sdk/a/kc$a;
    //   66: getfield 226	com/tencent/map/sdk/a/kc$a:f	I
    //   69: bipush 11
    //   71: if_icmpge +24 -> 95
    //   74: aload_0
    //   75: monitorenter
    //   76: aload_0
    //   77: ldc2_w 227
    //   80: invokevirtual 232	java/lang/Object:wait	(J)V
    //   83: aload_0
    //   84: monitorexit
    //   85: goto -81 -> 4
    //   88: astore 7
    //   90: aload_0
    //   91: monitorexit
    //   92: aload 7
    //   94: athrow
    //   95: aload_0
    //   96: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   99: getfield 206	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   102: astore 7
    //   104: aload_0
    //   105: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   108: astore 8
    //   110: aload 7
    //   112: invokevirtual 212	com/tencent/map/sdk/a/kl:p	()Landroid/graphics/Rect;
    //   115: astore 9
    //   117: aload 7
    //   119: getfield 216	com/tencent/map/sdk/a/kl:i	Lcom/tencent/map/sdk/a/kc;
    //   122: getfield 221	com/tencent/map/sdk/a/kc:b	Lcom/tencent/map/sdk/a/kc$a;
    //   125: getfield 226	com/tencent/map/sdk/a/kc$a:f	I
    //   128: istore_1
    //   129: aload 8
    //   131: getfield 174	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   134: aload 9
    //   136: iload_1
    //   137: invokevirtual 235	com/tencent/map/sdk/a/pf:a	(Landroid/graphics/Rect;I)Ljava/util/List;
    //   140: astore 9
    //   142: aload 9
    //   144: ifnull -70 -> 74
    //   147: aload 9
    //   149: invokeinterface 146 1 0
    //   154: ifeq -80 -> 74
    //   157: aload_0
    //   158: getfield 28	com/tencent/map/sdk/a/ic:c	Lcom/tencent/map/sdk/a/qe;
    //   161: ifnull -87 -> 74
    //   164: new 237	java/util/ArrayList
    //   167: dup
    //   168: invokespecial 238	java/util/ArrayList:<init>	()V
    //   171: astore 10
    //   173: aload_0
    //   174: aload 9
    //   176: invokespecial 240	com/tencent/map/sdk/a/ic:a	(Ljava/util/List;)Z
    //   179: istore 6
    //   181: iload 6
    //   183: ifne +18 -> 201
    //   186: invokestatic 246	java/lang/System:currentTimeMillis	()J
    //   189: aload_0
    //   190: getfield 30	com/tencent/map/sdk/a/ic:a	J
    //   193: lsub
    //   194: ldc2_w 227
    //   197: lcmp
    //   198: iflt -124 -> 74
    //   201: iconst_0
    //   202: istore_1
    //   203: aload_0
    //   204: aload 9
    //   206: putfield 148	com/tencent/map/sdk/a/ic:g	Ljava/util/List;
    //   209: aload 9
    //   211: invokeinterface 146 1 0
    //   216: iconst_1
    //   217: isub
    //   218: istore_2
    //   219: iload_2
    //   220: iflt +493 -> 713
    //   223: aload 9
    //   225: iload_2
    //   226: invokeinterface 152 2 0
    //   231: checkcast 98	java/lang/Integer
    //   234: invokevirtual 249	java/lang/Integer:intValue	()I
    //   237: istore 5
    //   239: iload 5
    //   241: invokestatic 101	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   244: astore 11
    //   246: aload_0
    //   247: aload 11
    //   249: invokespecial 251	com/tencent/map/sdk/a/ic:a	(Ljava/lang/String;)Ljava/io/File;
    //   252: astore 12
    //   254: aload 12
    //   256: ifnull +98 -> 354
    //   259: aload 12
    //   261: invokevirtual 57	java/io/File:getName	()Ljava/lang/String;
    //   264: ldc 59
    //   266: invokevirtual 65	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   269: astore 7
    //   271: aload 7
    //   273: arraylength
    //   274: iconst_1
    //   275: if_icmple +79 -> 354
    //   278: aload 11
    //   280: aload 7
    //   282: iconst_0
    //   283: aaload
    //   284: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifeq +67 -> 354
    //   290: aload 7
    //   292: iconst_1
    //   293: aaload
    //   294: astore 7
    //   296: aload 12
    //   298: ifnull +64 -> 362
    //   301: invokestatic 246	java/lang/System:currentTimeMillis	()J
    //   304: aload 12
    //   306: invokevirtual 254	java/io/File:lastModified	()J
    //   309: lsub
    //   310: ldc2_w 227
    //   313: lcmp
    //   314: ifge +48 -> 362
    //   317: iconst_0
    //   318: istore_3
    //   319: aload 7
    //   321: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   324: istore 4
    //   326: iload 4
    //   328: istore_3
    //   329: aload 10
    //   331: new 260	com/tencent/map/sdk/a/ia
    //   334: dup
    //   335: iload 5
    //   337: iload_3
    //   338: invokespecial 263	com/tencent/map/sdk/a/ia:<init>	(II)V
    //   341: invokeinterface 266 2 0
    //   346: pop
    //   347: iload_2
    //   348: iconst_1
    //   349: isub
    //   350: istore_2
    //   351: goto -132 -> 219
    //   354: ldc_w 268
    //   357: astore 7
    //   359: goto -63 -> 296
    //   362: aload_0
    //   363: getfield 28	com/tencent/map/sdk/a/ic:c	Lcom/tencent/map/sdk/a/qe;
    //   366: astore 13
    //   368: aload_0
    //   369: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   372: ifnull +13 -> 385
    //   375: aload_0
    //   376: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   379: getfield 271	com/tencent/map/sdk/a/lw:w	Ljava/lang/String;
    //   382: ifnonnull +82 -> 464
    //   385: aconst_null
    //   386: astore 8
    //   388: aload 13
    //   390: aload 8
    //   392: invokevirtual 276	com/tencent/map/sdk/a/qe:a	(Ljava/lang/String;)[B
    //   395: astore 8
    //   397: aload 8
    //   399: ifnull +311 -> 710
    //   402: aload 8
    //   404: arraylength
    //   405: bipush 10
    //   407: if_icmplt +303 -> 710
    //   410: aload 8
    //   412: iconst_4
    //   413: baload
    //   414: ifne +116 -> 530
    //   417: iconst_0
    //   418: istore_3
    //   419: aload 7
    //   421: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   424: istore 4
    //   426: iload 4
    //   428: istore_3
    //   429: aload 10
    //   431: new 260	com/tencent/map/sdk/a/ia
    //   434: dup
    //   435: iload 5
    //   437: iload_3
    //   438: invokespecial 263	com/tencent/map/sdk/a/ia:<init>	(II)V
    //   441: invokeinterface 266 2 0
    //   446: pop
    //   447: aload 12
    //   449: ifnull +261 -> 710
    //   452: aload 12
    //   454: invokestatic 246	java/lang/System:currentTimeMillis	()J
    //   457: invokevirtual 280	java/io/File:setLastModified	(J)Z
    //   460: pop
    //   461: goto -114 -> 347
    //   464: new 72	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   471: astore 8
    //   473: aload 8
    //   475: aload_0
    //   476: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   479: getfield 271	com/tencent/map/sdk/a/lw:w	Ljava/lang/String;
    //   482: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 8
    //   488: ldc_w 282
    //   491: aload 11
    //   493: invokestatic 286	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   496: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   499: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 8
    //   505: ldc_w 292
    //   508: aload 7
    //   510: invokestatic 286	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   513: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   516: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 8
    //   522: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: astore 8
    //   527: goto -139 -> 388
    //   530: iconst_4
    //   531: newarray byte
    //   533: astore 12
    //   535: aload 8
    //   537: iconst_0
    //   538: aload 12
    //   540: iconst_0
    //   541: iconst_4
    //   542: invokestatic 296	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   545: aload 12
    //   547: invokestatic 298	com/tencent/map/sdk/a/ic:a	([B)J
    //   550: l2i
    //   551: istore_3
    //   552: aload 8
    //   554: iconst_5
    //   555: aload 12
    //   557: iconst_0
    //   558: iconst_4
    //   559: invokestatic 296	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   562: aload 12
    //   564: invokestatic 298	com/tencent/map/sdk/a/ic:a	([B)J
    //   567: l2i
    //   568: istore 4
    //   570: aload_0
    //   571: iload_3
    //   572: iload 4
    //   574: aload 8
    //   576: invokespecial 300	com/tencent/map/sdk/a/ic:a	(II[B)Z
    //   579: ifeq +101 -> 680
    //   582: aload_0
    //   583: invokespecial 47	com/tencent/map/sdk/a/ic:f	()Ljava/io/File;
    //   586: astore 8
    //   588: aload 8
    //   590: ifnull +67 -> 657
    //   593: new 49	java/io/File
    //   596: dup
    //   597: new 72	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   604: aload 8
    //   606: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   609: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   615: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 11
    //   620: aload 7
    //   622: invokestatic 103	com/tencent/map/sdk/a/ic:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   625: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   634: astore 7
    //   636: aload 7
    //   638: invokevirtual 110	java/io/File:exists	()Z
    //   641: ifeq +16 -> 657
    //   644: aload 7
    //   646: invokevirtual 113	java/io/File:delete	()Z
    //   649: ifne +8 -> 657
    //   652: aload 7
    //   654: invokevirtual 116	java/io/File:deleteOnExit	()V
    //   657: aload 10
    //   659: new 260	com/tencent/map/sdk/a/ia
    //   662: dup
    //   663: iload_3
    //   664: iload 4
    //   666: invokespecial 263	com/tencent/map/sdk/a/ia:<init>	(II)V
    //   669: invokeinterface 266 2 0
    //   674: pop
    //   675: iconst_1
    //   676: istore_1
    //   677: goto -330 -> 347
    //   680: iconst_0
    //   681: istore_3
    //   682: aload 7
    //   684: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   687: istore 4
    //   689: iload 4
    //   691: istore_3
    //   692: aload 10
    //   694: new 260	com/tencent/map/sdk/a/ia
    //   697: dup
    //   698: iload 5
    //   700: iload_3
    //   701: invokespecial 263	com/tencent/map/sdk/a/ia:<init>	(II)V
    //   704: invokeinterface 266 2 0
    //   709: pop
    //   710: goto -363 -> 347
    //   713: iload 6
    //   715: ifne +7 -> 722
    //   718: iload_1
    //   719: ifeq +22 -> 741
    //   722: aload_0
    //   723: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   726: getfield 174	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   729: aload 10
    //   731: invokevirtual 303	com/tencent/map/sdk/a/pf:a	(Ljava/util/List;)V
    //   734: aload_0
    //   735: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   738: invokevirtual 190	com/tencent/map/sdk/a/lw:k	()V
    //   741: aload_0
    //   742: invokestatic 246	java/lang/System:currentTimeMillis	()J
    //   745: putfield 30	com/tencent/map/sdk/a/ic:a	J
    //   748: goto -674 -> 74
    //   751: astore 7
    //   753: invokestatic 307	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   756: invokevirtual 308	java/lang/Thread:interrupt	()V
    //   759: aload_0
    //   760: monitorexit
    //   761: return
    //   762: astore 7
    //   764: goto -435 -> 329
    //   767: astore 7
    //   769: goto -340 -> 429
    //   772: astore 7
    //   774: goto -82 -> 692
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	777	0	this	ic
    //   128	591	1	i	int
    //   218	133	2	j	int
    //   318	383	3	k	int
    //   324	366	4	m	int
    //   237	462	5	n	int
    //   179	535	6	bool	boolean
    //   88	5	7	localObject1	Object
    //   102	581	7	localObject2	Object
    //   751	1	7	localInterruptedException	java.lang.InterruptedException
    //   762	1	7	localException1	Exception
    //   767	1	7	localException2	Exception
    //   772	1	7	localException3	Exception
    //   108	497	8	localObject3	Object
    //   115	109	9	localObject4	Object
    //   171	559	10	localArrayList	java.util.ArrayList
    //   244	375	11	str	String
    //   252	311	12	localObject5	Object
    //   366	23	13	localqe	qe
    // Exception table:
    //   from	to	target	type
    //   76	83	88	finally
    //   83	85	88	finally
    //   90	92	88	finally
    //   753	761	88	finally
    //   76	83	751	java/lang/InterruptedException
    //   319	326	762	java/lang/Exception
    //   419	426	767	java/lang/Exception
    //   682	689	772	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ic
 * JD-Core Version:    0.7.0.1
 */