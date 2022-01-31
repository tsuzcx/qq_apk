package com.tencent.beacon.d;

import android.content.Context;
import android.os.Environment;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.f;

public final class b
{
  private final Context a;
  
  public b(Context paramContext)
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
    //   42: ldc 51
    //   44: invokestatic 57	com/tencent/beacon/a/f:b	([BILjava/lang/String;)[B
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +18 -> 67
    //   52: new 59	java/lang/String
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 62	java/lang/String:<init>	([B)V
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 49	java/io/FileInputStream:close	()V
    //   65: aload_1
    //   66: areturn
    //   67: aload_0
    //   68: invokevirtual 49	java/io/FileInputStream:close	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull -6 -> 71
    //   80: aload_0
    //   81: invokevirtual 49	java/io/FileInputStream:close	()V
    //   84: goto -13 -> 71
    //   87: astore_0
    //   88: goto -17 -> 71
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: ifnull -24 -> 71
    //   98: aload_0
    //   99: invokevirtual 49	java/io/FileInputStream:close	()V
    //   102: goto -31 -> 71
    //   105: astore_0
    //   106: goto -35 -> 71
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 49	java/io/FileInputStream:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_0
    //   123: aload_1
    //   124: areturn
    //   125: astore_0
    //   126: goto -55 -> 71
    //   129: astore_0
    //   130: goto -10 -> 120
    //   133: astore_1
    //   134: goto -22 -> 112
    //   137: astore_1
    //   138: goto -44 -> 94
    //   141: astore_1
    //   142: goto -66 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	47	0	localFileInputStream	java.io.FileInputStream
    //   73	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   75	6	0	localObject1	Object
    //   87	1	0	localIOException1	java.io.IOException
    //   91	1	0	localIOException2	java.io.IOException
    //   93	6	0	localObject2	Object
    //   105	1	0	localIOException3	java.io.IOException
    //   111	6	0	localObject3	Object
    //   122	1	0	localIOException4	java.io.IOException
    //   125	1	0	localIOException5	java.io.IOException
    //   129	1	0	localIOException6	java.io.IOException
    //   12	54	1	localObject4	Object
    //   109	15	1	str	String
    //   133	1	1	localObject5	Object
    //   137	1	1	localIOException7	java.io.IOException
    //   141	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   13	22	73	java/io/FileNotFoundException
    //   80	84	87	java/io/IOException
    //   13	22	91	java/io/IOException
    //   98	102	105	java/io/IOException
    //   13	22	109	finally
    //   61	65	122	java/io/IOException
    //   67	71	125	java/io/IOException
    //   116	120	129	java/io/IOException
    //   22	48	133	finally
    //   52	61	133	finally
    //   22	48	137	java/io/IOException
    //   52	61	137	java/io/IOException
    //   22	48	141	java/io/FileNotFoundException
    //   52	61	141	java/io/FileNotFoundException
  }
  
  public final String a()
  {
    Object localObject2 = com.tencent.beacon.a.b.b(this.a, "QIMEI_DENGTA", "");
    a.b("Load QIMEI from share preference, QIMEI is %s.", new Object[] { localObject2 });
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).trim().equals("")) {}
    }
    else
    {
      f.a(this.a);
      if (!Environment.getExternalStorageState().equals("mounted")) {
        break label157;
      }
    }
    label157:
    for (int i = 1;; i = 0)
    {
      localObject1 = localObject2;
      if (i != 0)
      {
        localObject2 = d();
        a.b("Load QIMEI from SDCard, QIMEI is %s.", new Object[] { localObject2 });
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).trim().equals(""))
          {
            a.b("Save QIMEI to shared prefs: %s.", new Object[] { localObject2 });
            com.tencent.beacon.a.b.a(this.a, "QIMEI_DENGTA", (String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      a.b("Return QIMEI %s.", new Object[] { localObject2 });
      return localObject2;
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +15 -> 16
    //   4: aload_1
    //   5: invokevirtual 81	java/lang/String:trim	()Ljava/lang/String;
    //   8: ldc 66
    //   10: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 13	com/tencent/beacon/d/b:a	Landroid/content/Context;
    //   21: invokestatic 88	com/tencent/beacon/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/f;
    //   24: pop
    //   25: invokestatic 91	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   28: ldc 93
    //   30: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +107 -> 140
    //   36: iconst_1
    //   37: istore_2
    //   38: iload_2
    //   39: ifeq +76 -> 115
    //   42: new 22	java/io/File
    //   45: dup
    //   46: invokestatic 28	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   49: ldc 30
    //   51: invokespecial 33	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore_3
    //   55: aconst_null
    //   56: astore 4
    //   58: aload_3
    //   59: invokevirtual 108	java/io/File:getParentFile	()Ljava/io/File;
    //   62: invokevirtual 112	java/io/File:mkdirs	()Z
    //   65: pop
    //   66: aload_3
    //   67: invokevirtual 115	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: new 117	java/io/FileOutputStream
    //   74: dup
    //   75: aload_3
    //   76: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore_3
    //   80: aload_3
    //   81: aload_1
    //   82: invokevirtual 122	java/lang/String:getBytes	()[B
    //   85: iconst_3
    //   86: ldc 51
    //   88: invokestatic 124	com/tencent/beacon/a/f:a	([BILjava/lang/String;)[B
    //   91: invokevirtual 127	java/io/FileOutputStream:write	([B)V
    //   94: aload_3
    //   95: invokevirtual 130	java/io/FileOutputStream:flush	()V
    //   98: aload_3
    //   99: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   102: ldc 133
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload_1
    //   111: aastore
    //   112: invokestatic 78	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload_0
    //   116: getfield 13	com/tencent/beacon/d/b:a	Landroid/content/Context;
    //   119: ldc 64
    //   121: aload_1
    //   122: invokestatic 102	com/tencent/beacon/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   125: pop
    //   126: ldc 135
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: aastore
    //   136: invokestatic 78	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: return
    //   140: iconst_0
    //   141: istore_2
    //   142: goto -104 -> 38
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_3
    //   148: aload_3
    //   149: ifnull -47 -> 102
    //   152: aload_3
    //   153: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   156: goto -54 -> 102
    //   159: astore_3
    //   160: goto -58 -> 102
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_3
    //   166: aload_3
    //   167: ifnull -65 -> 102
    //   170: aload_3
    //   171: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   174: goto -72 -> 102
    //   177: astore_3
    //   178: goto -76 -> 102
    //   181: astore_1
    //   182: aload 4
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +7 -> 193
    //   189: aload_3
    //   190: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_3
    //   196: goto -94 -> 102
    //   199: astore_3
    //   200: goto -7 -> 193
    //   203: astore_1
    //   204: goto -19 -> 185
    //   207: astore 4
    //   209: goto -43 -> 166
    //   212: astore 4
    //   214: goto -66 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	b
    //   0	217	1	paramString	String
    //   37	105	2	i	int
    //   54	45	3	localObject1	Object
    //   145	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   147	6	3	localObject2	Object
    //   159	1	3	localIOException1	java.io.IOException
    //   163	1	3	localIOException2	java.io.IOException
    //   165	6	3	localObject3	Object
    //   177	1	3	localIOException3	java.io.IOException
    //   184	6	3	localObject4	Object
    //   195	1	3	localIOException4	java.io.IOException
    //   199	1	3	localIOException5	java.io.IOException
    //   56	127	4	localObject5	Object
    //   207	1	4	localIOException6	java.io.IOException
    //   212	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   58	80	145	java/io/FileNotFoundException
    //   152	156	159	java/io/IOException
    //   58	80	163	java/io/IOException
    //   170	174	177	java/io/IOException
    //   58	80	181	finally
    //   98	102	195	java/io/IOException
    //   189	193	199	java/io/IOException
    //   80	98	203	finally
    //   80	98	207	java/io/IOException
    //   80	98	212	java/io/FileNotFoundException
  }
  
  public final boolean b()
  {
    return (f.n().equals(com.tencent.beacon.a.b.b(this.a, "GEN_QIMEI", ""))) && (com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI_TIMES") >= d.a().g());
  }
  
  public final void c()
  {
    int i = com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI_TIMES");
    if (!f.n().equals(com.tencent.beacon.a.b.b(this.a, "GEN_QIMEI", "")))
    {
      com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI", f.n());
      i = 0;
    }
    com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI_TIMES", i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.d.b
 * JD-Core Version:    0.7.0.1
 */