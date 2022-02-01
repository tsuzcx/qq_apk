package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.HashMap;

public final class n
{
  private static n a;
  private Context b;
  private String c;
  private SharedPreferences d;
  
  static
  {
    System.currentTimeMillis();
  }
  
  private n(Context paramContext)
  {
    this.b = paramContext;
    new HashMap();
    this.c = a.b().d;
    this.d = paramContext.getSharedPreferences("crashrecord", 0);
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new n(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private <T extends java.util.List<?>> void a(int paramInt, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 27	com/tencent/bugly/proguard/n:b	Landroid/content/Context;
    //   13: ldc 41
    //   15: iconst_0
    //   16: invokevirtual 64	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   19: astore_3
    //   20: new 66	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: iload_1
    //   32: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 73	java/io/File
    //   39: dup
    //   40: aload_3
    //   41: aload 4
    //   43: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 80	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 4
    //   51: aconst_null
    //   52: astore 5
    //   54: aconst_null
    //   55: astore_3
    //   56: new 82	java/io/ObjectOutputStream
    //   59: dup
    //   60: new 84	java/io/FileOutputStream
    //   63: dup
    //   64: aload 4
    //   66: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: invokespecial 90	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   72: astore 4
    //   74: aload 4
    //   76: aload_2
    //   77: invokevirtual 94	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   80: aload 4
    //   82: invokevirtual 97	java/io/ObjectOutputStream:close	()V
    //   85: goto +86 -> 171
    //   88: astore_2
    //   89: aload 4
    //   91: astore_3
    //   92: goto +55 -> 147
    //   95: astore_3
    //   96: aload 4
    //   98: astore_2
    //   99: aload_3
    //   100: astore 4
    //   102: goto +12 -> 114
    //   105: astore_2
    //   106: goto +41 -> 147
    //   109: astore 4
    //   111: aload 5
    //   113: astore_2
    //   114: aload_2
    //   115: astore_3
    //   116: aload 4
    //   118: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   121: aload_2
    //   122: astore_3
    //   123: ldc 102
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 107	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: aload_2
    //   134: ifnull +10 -> 144
    //   137: aload_2
    //   138: invokevirtual 97	java/io/ObjectOutputStream:close	()V
    //   141: goto +30 -> 171
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 97	java/io/ObjectOutputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: goto +16 -> 174
    //   161: ldc 109
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 112	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   170: pop
    //   171: aload_0
    //   172: monitorexit
    //   173: return
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_2
    //   177: athrow
    //   178: astore_2
    //   179: goto -18 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	n
    //   0	182	1	paramInt	int
    //   0	182	2	paramT	T
    //   19	73	3	localObject1	Object
    //   95	5	3	localIOException1	java.io.IOException
    //   115	37	3	?	T
    //   27	74	4	localObject2	Object
    //   109	8	4	localIOException2	java.io.IOException
    //   52	60	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   74	80	88	finally
    //   74	80	95	java/io/IOException
    //   56	74	105	finally
    //   116	121	105	finally
    //   123	133	105	finally
    //   56	74	109	java/io/IOException
    //   9	51	157	finally
    //   80	85	157	finally
    //   137	141	157	finally
    //   151	155	157	finally
    //   155	157	157	finally
    //   161	171	157	finally
    //   9	51	178	java/lang/Exception
    //   80	85	178	java/lang/Exception
    //   137	141	178	java/lang/Exception
    //   151	155	178	java/lang/Exception
    //   155	157	178	java/lang/Exception
  }
  
  /* Error */
  private boolean b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 122	com/tencent/bugly/proguard/n:c	(I)Ljava/util/List;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: invokestatic 20	java/lang/System:currentTimeMillis	()J
    //   21: lstore_2
    //   22: new 124	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 125	java/util/ArrayList:<init>	()V
    //   29: astore 5
    //   31: new 124	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 125	java/util/ArrayList:<init>	()V
    //   38: astore 6
    //   40: aload 4
    //   42: invokeinterface 131 1 0
    //   47: astore 7
    //   49: aload 7
    //   51: invokeinterface 137 1 0
    //   56: ifeq +36 -> 92
    //   59: aload 7
    //   61: invokeinterface 141 1 0
    //   66: checkcast 143	com/tencent/bugly/proguard/m
    //   69: astore 8
    //   71: ldc2_w 144
    //   74: lload_2
    //   75: lcmp
    //   76: ifge -27 -> 49
    //   79: aload 6
    //   81: aload 8
    //   83: invokeinterface 149 2 0
    //   88: pop
    //   89: goto -40 -> 49
    //   92: aload 5
    //   94: invokestatic 155	java/util/Collections:sort	(Ljava/util/List;)V
    //   97: aload 5
    //   99: invokeinterface 159 1 0
    //   104: iconst_2
    //   105: if_icmplt +60 -> 165
    //   108: aload 5
    //   110: invokeinterface 159 1 0
    //   115: ifle +46 -> 161
    //   118: aload 5
    //   120: aload 5
    //   122: invokeinterface 159 1 0
    //   127: iconst_1
    //   128: isub
    //   129: invokeinterface 163 2 0
    //   134: pop
    //   135: ldc2_w 144
    //   138: lload_2
    //   139: lcmp
    //   140: ifge +21 -> 161
    //   143: aload 4
    //   145: invokeinterface 166 1 0
    //   150: aload_0
    //   151: iload_1
    //   152: aload 4
    //   154: invokespecial 168	com/tencent/bugly/proguard/n:a	(ILjava/util/List;)V
    //   157: aload_0
    //   158: monitorexit
    //   159: iconst_0
    //   160: ireturn
    //   161: aload_0
    //   162: monitorexit
    //   163: iconst_1
    //   164: ireturn
    //   165: aload 4
    //   167: aload 6
    //   169: invokeinterface 172 2 0
    //   174: pop
    //   175: aload_0
    //   176: iload_1
    //   177: aload 4
    //   179: invokespecial 168	com/tencent/bugly/proguard/n:a	(ILjava/util/List;)V
    //   182: aload_0
    //   183: monitorexit
    //   184: iconst_0
    //   185: ireturn
    //   186: astore 4
    //   188: goto +17 -> 205
    //   191: ldc 174
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 112	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   200: pop
    //   201: aload_0
    //   202: monitorexit
    //   203: iconst_0
    //   204: ireturn
    //   205: aload_0
    //   206: monitorexit
    //   207: goto +6 -> 213
    //   210: aload 4
    //   212: athrow
    //   213: goto -3 -> 210
    //   216: astore 4
    //   218: goto -27 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	n
    //   0	221	1	paramInt	int
    //   21	118	2	l	long
    //   7	171	4	localList	java.util.List
    //   186	25	4	localObject	Object
    //   216	1	4	localException	java.lang.Exception
    //   29	92	5	localArrayList1	java.util.ArrayList
    //   38	130	6	localArrayList2	java.util.ArrayList
    //   47	13	7	localIterator	java.util.Iterator
    //   69	13	8	localm	m
    // Exception table:
    //   from	to	target	type
    //   2	9	186	finally
    //   18	49	186	finally
    //   49	71	186	finally
    //   79	89	186	finally
    //   92	135	186	finally
    //   143	157	186	finally
    //   165	182	186	finally
    //   191	201	186	finally
    //   2	9	216	java/lang/Exception
    //   18	49	216	java/lang/Exception
    //   49	71	216	java/lang/Exception
    //   79	89	216	java/lang/Exception
    //   92	135	216	java/lang/Exception
    //   143	157	216	java/lang/Exception
    //   165	182	216	java/lang/Exception
  }
  
  /* Error */
  private <T extends java.util.List<?>> T c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/bugly/proguard/n:b	Landroid/content/Context;
    //   6: ldc 41
    //   8: iconst_0
    //   9: invokevirtual 64	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   12: astore_3
    //   13: new 66	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: iload_1
    //   25: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new 73	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: aload 4
    //   36: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 80	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 179	java/io/File:exists	()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +7 -> 56
    //   52: aload_0
    //   53: monitorexit
    //   54: aconst_null
    //   55: areturn
    //   56: new 181	java/io/ObjectInputStream
    //   59: dup
    //   60: new 183	java/io/FileInputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 187	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: invokevirtual 190	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   81: checkcast 127	java/util/List
    //   84: astore 5
    //   86: aload 4
    //   88: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 5
    //   95: areturn
    //   96: astore_3
    //   97: aconst_null
    //   98: astore 4
    //   100: goto +64 -> 164
    //   103: aconst_null
    //   104: astore 4
    //   106: aload 4
    //   108: astore_3
    //   109: ldc 193
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 107	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   118: pop
    //   119: aload 4
    //   121: ifnull +69 -> 190
    //   124: aload 4
    //   126: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   129: goto +61 -> 190
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: astore_3
    //   138: ldc 102
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 107	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload 4
    //   150: ifnull +40 -> 190
    //   153: goto -29 -> 124
    //   156: astore 5
    //   158: aload_3
    //   159: astore 4
    //   161: aload 5
    //   163: astore_3
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto +17 -> 194
    //   180: ldc 195
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 112	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aload_0
    //   191: monitorexit
    //   192: aconst_null
    //   193: areturn
    //   194: aload_0
    //   195: monitorexit
    //   196: goto +5 -> 201
    //   199: aload_3
    //   200: athrow
    //   201: goto -2 -> 199
    //   204: astore_3
    //   205: goto -25 -> 180
    //   208: astore_3
    //   209: goto -77 -> 132
    //   212: astore_3
    //   213: goto -110 -> 103
    //   216: astore_3
    //   217: goto -82 -> 135
    //   220: astore_3
    //   221: goto -115 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	n
    //   0	224	1	paramInt	int
    //   47	2	2	bool	boolean
    //   12	64	3	localObject1	Object
    //   96	1	3	localObject2	Object
    //   108	67	3	localObject3	Object
    //   176	24	3	localObject4	Object
    //   204	1	3	localException	java.lang.Exception
    //   208	1	3	localIOException1	java.io.IOException
    //   212	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   216	1	3	localIOException2	java.io.IOException
    //   220	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   20	150	4	localObject5	Object
    //   84	10	5	localList	java.util.List
    //   156	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   56	73	96	finally
    //   76	86	156	finally
    //   109	119	156	finally
    //   138	148	156	finally
    //   2	48	176	finally
    //   86	91	176	finally
    //   124	129	176	finally
    //   169	174	176	finally
    //   174	176	176	finally
    //   180	190	176	finally
    //   2	48	204	java/lang/Exception
    //   86	91	204	java/lang/Exception
    //   124	129	204	java/lang/Exception
    //   169	174	204	java/lang/Exception
    //   174	176	204	java/lang/Exception
    //   56	73	208	java/io/IOException
    //   56	73	212	java/lang/ClassNotFoundException
    //   76	86	216	java/io/IOException
    //   76	86	220	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_3
    //   4: iload_3
    //   5: istore_2
    //   6: aload_0
    //   7: getfield 49	com/tencent/bugly/proguard/n:d	Landroid/content/SharedPreferences;
    //   10: astore 4
    //   12: iload_3
    //   13: istore_2
    //   14: new 66	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   21: astore 5
    //   23: iload_3
    //   24: istore_2
    //   25: aload 5
    //   27: iload_1
    //   28: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: iload_3
    //   33: istore_2
    //   34: aload 5
    //   36: ldc 198
    //   38: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: iload_3
    //   43: istore_2
    //   44: aload 5
    //   46: aload_0
    //   47: getfield 39	com/tencent/bugly/proguard/n:c	Ljava/lang/String;
    //   50: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: iload_3
    //   55: istore_2
    //   56: aload 4
    //   58: aload 5
    //   60: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: iconst_1
    //   64: invokeinterface 207 3 0
    //   69: istore_3
    //   70: iload_3
    //   71: istore_2
    //   72: invokestatic 212	com/tencent/bugly/proguard/w:a	()Lcom/tencent/bugly/proguard/w;
    //   75: new 214	com/tencent/bugly/proguard/n$1
    //   78: dup
    //   79: aload_0
    //   80: iload_1
    //   81: invokespecial 217	com/tencent/bugly/proguard/n$1:<init>	(Lcom/tencent/bugly/proguard/n;I)V
    //   84: invokevirtual 220	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: iload_3
    //   91: ireturn
    //   92: astore 4
    //   94: goto +17 -> 111
    //   97: ldc 222
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 112	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: iload_2
    //   110: ireturn
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 4
    //   115: athrow
    //   116: astore 4
    //   118: goto -21 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	n
    //   0	121	1	paramInt	int
    //   5	105	2	bool1	boolean
    //   3	88	3	bool2	boolean
    //   10	47	4	localSharedPreferences	SharedPreferences
    //   92	22	4	localObject	Object
    //   116	1	4	localException	java.lang.Exception
    //   21	38	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	12	92	finally
    //   14	23	92	finally
    //   25	32	92	finally
    //   34	42	92	finally
    //   44	54	92	finally
    //   56	70	92	finally
    //   72	88	92	finally
    //   97	107	92	finally
    //   6	12	116	java/lang/Exception
    //   14	23	116	java/lang/Exception
    //   25	32	116	java/lang/Exception
    //   34	42	116	java/lang/Exception
    //   44	54	116	java/lang/Exception
    //   56	70	116	java/lang/Exception
    //   72	88	116	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.n
 * JD-Core Version:    0.7.0.1
 */