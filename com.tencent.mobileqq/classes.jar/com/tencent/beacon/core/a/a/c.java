package com.tencent.beacon.core.a.a;

public final class c
{
  /* Error */
  public static boolean a(android.content.Context paramContext, java.lang.String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 13	com/tencent/beacon/core/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/b;
    //   4: invokevirtual 17	com/tencent/beacon/core/b/b:b	()Ljava/lang/String;
    //   7: astore 5
    //   9: aload 5
    //   11: invokestatic 22	com/tencent/beacon/core/a/a/e:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: astore 4
    //   16: aload 4
    //   18: monitorenter
    //   19: aload_0
    //   20: ifnonnull +8 -> 28
    //   23: aload 4
    //   25: monitorexit
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: aload 5
    //   31: invokestatic 25	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   34: invokevirtual 29	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: astore_0
    //   38: aload_0
    //   39: ldc 31
    //   41: new 33	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 35
    //   47: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 45
    //   56: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: aconst_null
    //   63: invokevirtual 54	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   66: pop
    //   67: new 56	android/content/ContentValues
    //   70: dup
    //   71: invokespecial 59	android/content/ContentValues:<init>	()V
    //   74: astore 5
    //   76: aload 5
    //   78: ldc 61
    //   80: aload_1
    //   81: invokevirtual 65	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 5
    //   86: ldc 67
    //   88: aload_2
    //   89: iconst_0
    //   90: aaload
    //   91: checkcast 69	java/lang/String
    //   94: invokevirtual 65	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload 5
    //   99: ldc 71
    //   101: aload_2
    //   102: iconst_1
    //   103: aaload
    //   104: checkcast 73	java/lang/Long
    //   107: invokevirtual 76	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   110: aload 5
    //   112: ldc 78
    //   114: new 80	java/util/Date
    //   117: dup
    //   118: invokespecial 81	java/util/Date:<init>	()V
    //   121: invokevirtual 85	java/util/Date:getTime	()J
    //   124: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: invokevirtual 76	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   130: aload_0
    //   131: ldc 31
    //   133: aconst_null
    //   134: aload 5
    //   136: invokevirtual 93	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   139: lconst_0
    //   140: lcmp
    //   141: ifge +25 -> 166
    //   144: ldc 95
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 101	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: iconst_0
    //   154: istore_3
    //   155: aload 4
    //   157: monitorexit
    //   158: iload_3
    //   159: ireturn
    //   160: astore_0
    //   161: aload 4
    //   163: monitorexit
    //   164: aload_0
    //   165: athrow
    //   166: iconst_1
    //   167: istore_3
    //   168: goto -13 -> 155
    //   171: astore_0
    //   172: iconst_0
    //   173: istore_3
    //   174: goto -19 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	android.content.Context
    //   0	177	1	paramString	java.lang.String
    //   0	177	2	paramArrayOfObject	Object[]
    //   154	20	3	bool	boolean
    //   14	148	4	localObject1	Object
    //   7	128	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	26	160	finally
    //   28	153	160	finally
    //   155	158	160	finally
    //   161	164	160	finally
    //   28	153	171	java/lang/Exception
  }
  
  /* Error */
  public static Object[] a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 13	com/tencent/beacon/core/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/b;
    //   7: invokevirtual 17	com/tencent/beacon/core/b/b:b	()Ljava/lang/String;
    //   10: astore 6
    //   12: aload 6
    //   14: invokestatic 22	com/tencent/beacon/core/a/a/e:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: astore 5
    //   19: aload 5
    //   21: monitorenter
    //   22: aload_0
    //   23: ifnonnull +17 -> 40
    //   26: ldc 105
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 101	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload 5
    //   37: monitorexit
    //   38: aconst_null
    //   39: areturn
    //   40: aload_0
    //   41: aload 6
    //   43: invokestatic 25	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   46: invokevirtual 29	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnonnull +17 -> 68
    //   54: ldc 107
    //   56: iconst_0
    //   57: anewarray 4	java/lang/Object
    //   60: invokestatic 101	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload 5
    //   65: monitorexit
    //   66: aconst_null
    //   67: areturn
    //   68: aload_0
    //   69: ldc 31
    //   71: aconst_null
    //   72: new 33	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 35
    //   78: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 45
    //   87: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +92 -> 194
    //   105: aload_0
    //   106: invokeinterface 117 1 0
    //   111: ifeq +83 -> 194
    //   114: aload_0
    //   115: aload_0
    //   116: ldc 67
    //   118: invokeinterface 121 2 0
    //   123: invokeinterface 125 2 0
    //   128: astore 4
    //   130: aload_0
    //   131: aload_0
    //   132: ldc 71
    //   134: invokeinterface 121 2 0
    //   139: invokeinterface 129 2 0
    //   144: lstore_2
    //   145: aload_0
    //   146: ifnull +18 -> 164
    //   149: aload_0
    //   150: invokeinterface 132 1 0
    //   155: ifne +9 -> 164
    //   158: aload_0
    //   159: invokeinterface 135 1 0
    //   164: aload 5
    //   166: monitorexit
    //   167: iconst_3
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_1
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload 4
    //   179: aastore
    //   180: dup
    //   181: iconst_2
    //   182: lload_2
    //   183: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: areturn
    //   188: astore_0
    //   189: aload 5
    //   191: monitorexit
    //   192: aload_0
    //   193: athrow
    //   194: aload_0
    //   195: ifnull +18 -> 213
    //   198: aload_0
    //   199: invokeinterface 132 1 0
    //   204: ifne +9 -> 213
    //   207: aload_0
    //   208: invokeinterface 135 1 0
    //   213: aload 5
    //   215: monitorexit
    //   216: aconst_null
    //   217: areturn
    //   218: aload_0
    //   219: ifnull -6 -> 213
    //   222: aload_0
    //   223: invokeinterface 132 1 0
    //   228: ifne -15 -> 213
    //   231: aload_0
    //   232: invokeinterface 135 1 0
    //   237: goto -24 -> 213
    //   240: aload_1
    //   241: ifnull +18 -> 259
    //   244: aload_1
    //   245: invokeinterface 132 1 0
    //   250: ifne +9 -> 259
    //   253: aload_1
    //   254: invokeinterface 135 1 0
    //   259: aload_0
    //   260: athrow
    //   261: astore 4
    //   263: aload_0
    //   264: astore_1
    //   265: aload 4
    //   267: astore_0
    //   268: goto -28 -> 240
    //   271: astore_1
    //   272: goto -54 -> 218
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_0
    //   278: goto -60 -> 218
    //   281: astore_0
    //   282: aload 4
    //   284: astore_1
    //   285: goto -45 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramContext	android.content.Context
    //   0	288	1	paramString	java.lang.String
    //   144	39	2	l	long
    //   1	177	4	str1	java.lang.String
    //   261	22	4	localObject1	Object
    //   17	197	5	localObject2	Object
    //   10	32	6	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   26	38	188	finally
    //   63	66	188	finally
    //   149	164	188	finally
    //   164	188	188	finally
    //   189	192	188	finally
    //   198	213	188	finally
    //   213	216	188	finally
    //   222	237	188	finally
    //   244	259	188	finally
    //   259	261	188	finally
    //   105	145	261	finally
    //   105	145	271	java/lang/Exception
    //   40	50	275	java/lang/Exception
    //   54	63	275	java/lang/Exception
    //   68	101	275	java/lang/Exception
    //   40	50	281	finally
    //   54	63	281	finally
    //   68	101	281	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */