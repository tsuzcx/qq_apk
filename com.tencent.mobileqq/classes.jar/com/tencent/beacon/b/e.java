package com.tencent.beacon.b;

import android.content.Context;
import android.os.Environment;
import com.tencent.beacon.a.a.c;

public final class e
{
  private final Context a;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  private static String d()
  {
    // Byte code:
    //   0: new 22	java/io/File
    //   3: dup
    //   4: invokestatic 28	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: ldc 30
    //   9: invokespecial 33	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 35	java/io/FileInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 38	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: aload_1
    //   23: invokevirtual 42	java/io/File:length	()J
    //   26: l2i
    //   27: newarray byte
    //   29: astore_1
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 46	java/io/FileInputStream:read	([B)I
    //   35: pop
    //   36: aload_0
    //   37: invokevirtual 49	java/io/FileInputStream:close	()V
    //   40: aload_1
    //   41: iconst_3
    //   42: invokestatic 52	com/tencent/beacon/b/e:e	()Ljava/lang/String;
    //   45: invokestatic 58	com/tencent/beacon/a/a:b	([BILjava/lang/String;)[B
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +18 -> 68
    //   53: new 60	java/lang/String
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 63	java/lang/String:<init>	([B)V
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 49	java/io/FileInputStream:close	()V
    //   66: aload_1
    //   67: areturn
    //   68: aload_0
    //   69: invokevirtual 49	java/io/FileInputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull -6 -> 72
    //   81: aload_0
    //   82: invokevirtual 49	java/io/FileInputStream:close	()V
    //   85: goto -13 -> 72
    //   88: astore_0
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: ifnull -24 -> 72
    //   99: aload_0
    //   100: invokevirtual 49	java/io/FileInputStream:close	()V
    //   103: goto -31 -> 72
    //   106: astore_0
    //   107: goto -35 -> 72
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 49	java/io/FileInputStream:close	()V
    //   121: aload_1
    //   122: athrow
    //   123: astore_0
    //   124: aload_1
    //   125: areturn
    //   126: astore_0
    //   127: goto -55 -> 72
    //   130: astore_0
    //   131: goto -10 -> 121
    //   134: astore_1
    //   135: goto -22 -> 113
    //   138: astore_1
    //   139: goto -44 -> 95
    //   142: astore_1
    //   143: goto -66 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	48	0	localFileInputStream	java.io.FileInputStream
    //   74	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   76	6	0	localObject1	Object
    //   88	1	0	localIOException1	java.io.IOException
    //   92	1	0	localIOException2	java.io.IOException
    //   94	6	0	localObject2	Object
    //   106	1	0	localIOException3	java.io.IOException
    //   112	6	0	localObject3	Object
    //   123	1	0	localIOException4	java.io.IOException
    //   126	1	0	localIOException5	java.io.IOException
    //   130	1	0	localIOException6	java.io.IOException
    //   12	55	1	localObject4	Object
    //   110	15	1	str	String
    //   134	1	1	localObject5	Object
    //   138	1	1	localIOException7	java.io.IOException
    //   142	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   13	22	74	java/io/FileNotFoundException
    //   81	85	88	java/io/IOException
    //   13	22	92	java/io/IOException
    //   99	103	106	java/io/IOException
    //   13	22	110	finally
    //   62	66	123	java/io/IOException
    //   68	72	126	java/io/IOException
    //   117	121	130	java/io/IOException
    //   22	49	134	finally
    //   53	62	134	finally
    //   22	49	138	java/io/IOException
    //   53	62	138	java/io/IOException
    //   22	49	142	java/io/FileNotFoundException
    //   53	62	142	java/io/FileNotFoundException
  }
  
  private static String e()
  {
    int k = 0;
    byte[] arrayOfByte1 = new byte[15];
    byte[] tmp8_7 = arrayOfByte1;
    tmp8_7[0] = 64;
    byte[] tmp13_8 = tmp8_7;
    tmp13_8[1] = 38;
    byte[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 40;
    byte[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 42;
    byte[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 35;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 72;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 78;
    byte[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 75;
    byte[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 74;
    byte[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 103;
    byte[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 49;
    byte[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 50;
    byte[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 33;
    byte[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 64;
    byte[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 41;
    tmp86_80;
    byte[] arrayOfByte2 = new byte[6];
    byte[] tmp101_99 = arrayOfByte2;
    tmp101_99[0] = 27;
    byte[] tmp106_101 = tmp101_99;
    tmp106_101[1] = 81;
    byte[] tmp111_106 = tmp106_101;
    tmp111_106[2] = 19;
    byte[] tmp116_111 = tmp111_106;
    tmp116_111[3] = 34;
    byte[] tmp121_116 = tmp116_111;
    tmp121_116[4] = 88;
    byte[] tmp126_121 = tmp121_116;
    tmp126_121[5] = 32;
    tmp126_121;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 15) {
        break;
      }
      arrayOfByte1[i] = ((byte)(arrayOfByte1[i] ^ arrayOfByte2[(i % 6)]));
      i += 1;
    }
    while (j < 15)
    {
      arrayOfByte1[j] = ((byte)(arrayOfByte1[j] ^ arrayOfByte2[(j % 6)]));
      j += 1;
    }
    return new String(arrayOfByte1);
  }
  
  public final String a()
  {
    c localc = c.a(this.a);
    Object localObject2 = localc.a("QIMEI_DENGTA", "");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).trim().equals("")) {}
    }
    else
    {
      com.tencent.beacon.a.c.e.a(this.a);
      localObject1 = localObject2;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localObject2 = d();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).trim().equals(""))
          {
            localc.a().a("QIMEI_DENGTA", localObject2).b();
            localObject1 = localObject2;
          }
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    com.tencent.beacon.a.g.a.a("[qimei] load QIMEI:%s from sp/sdcard", new Object[] { localObject2 });
    return localObject2;
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +15 -> 16
    //   4: aload_1
    //   5: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   8: ldc 92
    //   10: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 13	com/tencent/beacon/b/e:a	Landroid/content/Context;
    //   21: invokestatic 107	com/tencent/beacon/a/c/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/c/e;
    //   24: pop
    //   25: invokestatic 110	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   28: ldc 112
    //   30: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +63 -> 96
    //   36: new 22	java/io/File
    //   39: dup
    //   40: invokestatic 28	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   43: ldc 30
    //   45: invokespecial 33	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore_2
    //   49: aconst_null
    //   50: astore_3
    //   51: aload_2
    //   52: invokevirtual 133	java/io/File:getParentFile	()Ljava/io/File;
    //   55: invokevirtual 137	java/io/File:mkdirs	()Z
    //   58: pop
    //   59: aload_2
    //   60: invokevirtual 140	java/io/File:createNewFile	()Z
    //   63: pop
    //   64: new 142	java/io/FileOutputStream
    //   67: dup
    //   68: aload_2
    //   69: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   72: astore_2
    //   73: aload_2
    //   74: aload_1
    //   75: invokevirtual 147	java/lang/String:getBytes	()[B
    //   78: iconst_3
    //   79: invokestatic 52	com/tencent/beacon/b/e:e	()Ljava/lang/String;
    //   82: invokestatic 149	com/tencent/beacon/a/a:a	([BILjava/lang/String;)[B
    //   85: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   88: aload_2
    //   89: invokevirtual 155	java/io/FileOutputStream:flush	()V
    //   92: aload_2
    //   93: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   96: aload_0
    //   97: getfield 13	com/tencent/beacon/b/e:a	Landroid/content/Context;
    //   100: invokestatic 88	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   103: ldc 90
    //   105: aload_1
    //   106: invokevirtual 120	com/tencent/beacon/a/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/a/a/c;
    //   109: invokevirtual 122	com/tencent/beacon/a/a/c:b	()V
    //   112: return
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull -21 -> 96
    //   120: aload_2
    //   121: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   124: goto -28 -> 96
    //   127: astore_2
    //   128: goto -32 -> 96
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull -39 -> 96
    //   138: aload_2
    //   139: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   142: goto -46 -> 96
    //   145: astore_2
    //   146: goto -50 -> 96
    //   149: astore_1
    //   150: aload_3
    //   151: astore_2
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   160: aload_1
    //   161: athrow
    //   162: astore_2
    //   163: goto -67 -> 96
    //   166: astore_2
    //   167: goto -7 -> 160
    //   170: astore_1
    //   171: goto -19 -> 152
    //   174: astore_3
    //   175: goto -41 -> 134
    //   178: astore_3
    //   179: goto -63 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	e
    //   0	182	1	paramString	String
    //   48	45	2	localObject1	Object
    //   113	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   115	6	2	localObject2	Object
    //   127	1	2	localIOException1	java.io.IOException
    //   131	1	2	localIOException2	java.io.IOException
    //   133	6	2	localObject3	Object
    //   145	1	2	localIOException3	java.io.IOException
    //   151	6	2	localObject4	Object
    //   162	1	2	localIOException4	java.io.IOException
    //   166	1	2	localIOException5	java.io.IOException
    //   50	101	3	localObject5	Object
    //   174	1	3	localIOException6	java.io.IOException
    //   178	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   51	73	113	java/io/FileNotFoundException
    //   120	124	127	java/io/IOException
    //   51	73	131	java/io/IOException
    //   138	142	145	java/io/IOException
    //   51	73	149	finally
    //   92	96	162	java/io/IOException
    //   156	160	166	java/io/IOException
    //   73	92	170	finally
    //   73	92	174	java/io/IOException
    //   73	92	178	java/io/FileNotFoundException
  }
  
  public final boolean b()
  {
    return (com.tencent.beacon.a.a.f().equals(c.a(this.a).a("GEN_QIMEI", ""))) && (c.a(this.a).a("GEN_QIMEI_TIMES") >= a.j(this.a).g());
  }
  
  public final void c()
  {
    int i = c.a(this.a).a("GEN_QIMEI_TIMES");
    if (!com.tencent.beacon.a.a.f().equals(c.a(this.a).a("GEN_QIMEI", "")))
    {
      c.a(this.a).a().a("GEN_QIMEI", com.tencent.beacon.a.a.f()).b();
      i = 0;
    }
    c.a(this.a).a().a("GEN_QIMEI_TIMES", Integer.valueOf(i + 1)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.e
 * JD-Core Version:    0.7.0.1
 */