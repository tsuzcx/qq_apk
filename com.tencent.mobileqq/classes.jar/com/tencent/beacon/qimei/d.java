package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.d.i;

public final class d
{
  private static String a = "tencent/beacon/meta_";
  
  private static String a()
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
  
  public static String a(Context paramContext)
  {
    c localc = c.a(paramContext);
    String str = localc.a("QIMEI_DENGTA", "");
    com.tencent.beacon.core.d.b.b("[qimei] get QIMEI:%s from sp", new Object[] { str });
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (!str.trim().equals("")) {}
    }
    else
    {
      com.tencent.beacon.core.b.d.a(paramContext);
      localObject = str;
      if (com.tencent.beacon.core.b.d.g())
      {
        localObject = str;
        if (f(paramContext))
        {
          localObject = a(a);
          com.tencent.beacon.core.d.b.b("[qimei] get QIMEI:%s from sdcard(AppKey)", new Object[] { localObject });
        }
        if (localObject != null)
        {
          paramContext = (Context)localObject;
          if (!((String)localObject).trim().equals("")) {}
        }
        else
        {
          paramContext = a("tencent/beacon/meta.dat");
          com.tencent.beacon.core.d.b.b("[qimei] get QIMEI:%s from sdcard", new Object[] { paramContext });
        }
        localObject = paramContext;
        if (paramContext != null)
        {
          localObject = paramContext;
          if (!paramContext.trim().equals(""))
          {
            com.tencent.beacon.core.d.b.b("[qimei] Save QIMEI:%s to sp", new Object[] { paramContext });
            localc.a().a("QIMEI_DENGTA", paramContext).b();
            localObject = paramContext;
          }
        }
      }
    }
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "";
    }
    com.tencent.beacon.core.d.b.a("[qimei] load QIMEI:%s from sp/sdcard", new Object[] { paramContext });
    return paramContext;
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 108	java/io/File
    //   3: dup
    //   4: invokestatic 114	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: aload_0
    //   8: invokespecial 117	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 119	java/io/FileInputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: aload_2
    //   24: invokevirtual 126	java/io/File:length	()J
    //   27: l2i
    //   28: newarray byte
    //   30: astore_2
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 130	java/io/FileInputStream:read	([B)I
    //   38: pop
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 133	java/io/FileInputStream:close	()V
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: iconst_3
    //   49: invokestatic 135	com/tencent/beacon/qimei/d:a	()Ljava/lang/String;
    //   52: invokestatic 140	com/tencent/beacon/core/d/i:b	([BILjava/lang/String;)[B
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +20 -> 77
    //   60: aload_1
    //   61: astore_0
    //   62: new 36	java/lang/String
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 40	java/lang/String:<init>	([B)V
    //   70: astore_2
    //   71: aload_1
    //   72: invokestatic 145	com/tencent/beacon/core/d/c:a	(Ljava/io/Closeable;)V
    //   75: aload_2
    //   76: areturn
    //   77: aload_1
    //   78: invokestatic 145	com/tencent/beacon/core/d/c:a	(Ljava/io/Closeable;)V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: ldc 147
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_2
    //   97: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 153	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_1
    //   105: invokestatic 145	com/tencent/beacon/core/d/c:a	(Ljava/io/Closeable;)V
    //   108: goto -27 -> 81
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: invokestatic 145	com/tencent/beacon/core/d/c:a	(Ljava/io/Closeable;)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -7 -> 114
    //   124: astore_2
    //   125: goto -39 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   20	85	1	localFileInputStream	java.io.FileInputStream
    //   111	8	1	localObject1	Object
    //   120	1	1	localObject2	Object
    //   11	65	2	localObject3	Object
    //   83	14	2	localException1	java.lang.Exception
    //   124	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	21	83	java/lang/Exception
    //   12	21	111	finally
    //   23	31	120	finally
    //   33	39	120	finally
    //   41	45	120	finally
    //   47	56	120	finally
    //   62	71	120	finally
    //   88	104	120	finally
    //   23	31	124	java/lang/Exception
    //   33	39	124	java/lang/Exception
    //   41	45	124	java/lang/Exception
    //   47	56	124	java/lang/Exception
    //   62	71	124	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {
      return;
    }
    com.tencent.beacon.core.b.d.a(paramContext);
    if (com.tencent.beacon.core.b.d.g())
    {
      if (f(paramContext))
      {
        com.tencent.beacon.core.d.b.b("[qimei] Save QIMEI: %s to SDCard(AppKey)", new Object[] { paramString });
        a(paramString, a);
      }
      com.tencent.beacon.core.d.b.b("[qimei] Save QIMEI:%s to SDCard", new Object[] { paramString });
      a(paramString, "tencent/beacon/meta.dat");
    }
    c.a(paramContext).a().a("QIMEI_DENGTA", paramString).b();
    com.tencent.beacon.core.d.b.b("[qimei] update QIMEI:%s, and save to sp.", new Object[] { paramString });
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 108	java/io/File
    //   3: dup
    //   4: invokestatic 114	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: aload_1
    //   8: invokespecial 117	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   11: astore_2
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_2
    //   15: invokevirtual 166	java/io/File:getParentFile	()Ljava/io/File;
    //   18: invokevirtual 169	java/io/File:mkdirs	()Z
    //   21: pop
    //   22: aload_2
    //   23: invokevirtual 172	java/io/File:createNewFile	()Z
    //   26: pop
    //   27: new 174	java/io/FileOutputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: aload_0
    //   40: invokevirtual 179	java/lang/String:getBytes	()[B
    //   43: iconst_3
    //   44: invokestatic 135	com/tencent/beacon/qimei/d:a	()Ljava/lang/String;
    //   47: invokestatic 181	com/tencent/beacon/core/d/i:a	([BILjava/lang/String;)[B
    //   50: invokevirtual 184	java/io/FileOutputStream:write	([B)V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 187	java/io/FileOutputStream:flush	()V
    //   59: aload_2
    //   60: invokestatic 145	com/tencent/beacon/core/d/c:a	(Ljava/io/Closeable;)V
    //   63: return
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: ldc 189
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 153	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_0
    //   79: invokestatic 145	com/tencent/beacon/core/d/c:a	(Ljava/io/Closeable;)V
    //   82: return
    //   83: astore_0
    //   84: aload_1
    //   85: invokestatic 145	com/tencent/beacon/core/d/c:a	(Ljava/io/Closeable;)V
    //   88: aload_0
    //   89: athrow
    //   90: astore_0
    //   91: goto -7 -> 84
    //   94: astore_0
    //   95: aload_2
    //   96: astore_0
    //   97: goto -30 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramString1	String
    //   0	100	1	paramString2	String
    //   11	85	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	36	64	java/lang/Exception
    //   14	36	83	finally
    //   38	53	90	finally
    //   55	59	90	finally
    //   69	78	90	finally
    //   38	53	94	java/lang/Exception
    //   55	59	94	java/lang/Exception
  }
  
  public static boolean b(Context paramContext)
  {
    return (i.a().equals(e(paramContext))) && (d(paramContext) >= b.a(paramContext).b());
  }
  
  public static void c(Context paramContext)
  {
    int i = d(paramContext);
    if (!i.a().equals(e(paramContext)))
    {
      c.a(paramContext).a().a("GEN_QIMEI", i.a()).b();
      i = 0;
    }
    c.a(paramContext).a().a("GEN_QIMEI_TIMES", Integer.valueOf(i + 1)).b();
  }
  
  private static int d(Context paramContext)
  {
    return c.a(paramContext).a("GEN_QIMEI_TIMES");
  }
  
  private static String e(Context paramContext)
  {
    return c.a(paramContext).a("GEN_QIMEI", "");
  }
  
  private static boolean f(Context paramContext)
  {
    paramContext = com.tencent.beacon.core.b.b.a(paramContext);
    String str = paramContext.b();
    if (paramContext.a().equals(str)) {
      return false;
    }
    if (!a.contains(str)) {
      a = a.concat(str).concat(".dat");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.qimei.d
 * JD-Core Version:    0.7.0.1
 */