package com.tencent.beacon.e;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StrategyModule;

public final class j
{
  private static String a;
  
  /* Error */
  public static i a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 5
    //   18: aload_0
    //   19: ifnonnull +17 -> 36
    //   22: ldc 11
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 17	com/tencent/beacon/base/util/c:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aconst_null
    //   35: areturn
    //   36: invokestatic 23	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   39: invokevirtual 27	com/tencent/beacon/a/c/c:f	()Ljava/lang/String;
    //   42: astore_2
    //   43: new 29	com/tencent/beacon/e/j$a
    //   46: dup
    //   47: aload_0
    //   48: aload_2
    //   49: invokespecial 33	com/tencent/beacon/e/j$a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   52: invokevirtual 39	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnonnull +44 -> 101
    //   60: aload 5
    //   62: astore 4
    //   64: aload_2
    //   65: astore_3
    //   66: ldc 41
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 17	com/tencent/beacon/base/util/c:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_2
    //   76: ifnull +14 -> 90
    //   79: aload_2
    //   80: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   83: ifeq +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   90: ldc 2
    //   92: monitorexit
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aload_3
    //   97: astore_2
    //   98: goto +296 -> 394
    //   101: aload 5
    //   103: astore 4
    //   105: aload_2
    //   106: astore_3
    //   107: getstatic 57	java/util/Locale:US	Ljava/util/Locale;
    //   110: astore_0
    //   111: aload 5
    //   113: astore 4
    //   115: aload_2
    //   116: astore_3
    //   117: aload_0
    //   118: ldc 59
    //   120: iconst_2
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: ldc 61
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: iload_1
    //   132: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: invokestatic 73	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   139: astore_0
    //   140: aload 5
    //   142: astore 4
    //   144: aload_2
    //   145: astore_3
    //   146: aload_2
    //   147: ldc 75
    //   149: aconst_null
    //   150: aload_0
    //   151: aconst_null
    //   152: aconst_null
    //   153: aconst_null
    //   154: aconst_null
    //   155: invokevirtual 79	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   158: astore 5
    //   160: aload 8
    //   162: astore_3
    //   163: aload 5
    //   165: ifnull +85 -> 250
    //   168: aload 7
    //   170: astore_0
    //   171: aload 8
    //   173: astore_3
    //   174: aload 5
    //   176: invokeinterface 84 1 0
    //   181: ifeq +69 -> 250
    //   184: aload 7
    //   186: astore_0
    //   187: aload 5
    //   189: invokestatic 87	com/tencent/beacon/e/j:a	(Landroid/database/Cursor;)Lcom/tencent/beacon/e/i;
    //   192: astore 4
    //   194: aload 4
    //   196: astore_3
    //   197: aload 4
    //   199: ifnull +51 -> 250
    //   202: aload 4
    //   204: astore_0
    //   205: ldc 89
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload 4
    //   215: getfield 95	com/tencent/beacon/e/i:b	I
    //   218: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: invokestatic 97	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload 4
    //   227: astore_3
    //   228: goto +22 -> 250
    //   231: astore_0
    //   232: aload 5
    //   234: astore 4
    //   236: goto +158 -> 394
    //   239: astore_3
    //   240: aload 5
    //   242: astore 6
    //   244: aload_3
    //   245: astore 5
    //   247: goto +62 -> 309
    //   250: aload 5
    //   252: ifnull +20 -> 272
    //   255: aload 5
    //   257: invokeinterface 100 1 0
    //   262: ifne +10 -> 272
    //   265: aload 5
    //   267: invokeinterface 101 1 0
    //   272: aload_2
    //   273: ifnull +14 -> 287
    //   276: aload_2
    //   277: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   280: ifeq +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   287: goto +102 -> 389
    //   290: astore 5
    //   292: aconst_null
    //   293: astore_0
    //   294: goto +15 -> 309
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_2
    //   300: goto +94 -> 394
    //   303: astore 5
    //   305: aconst_null
    //   306: astore_0
    //   307: aload_0
    //   308: astore_2
    //   309: aload 6
    //   311: astore 4
    //   313: aload_2
    //   314: astore_3
    //   315: invokestatic 106	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   318: astore 7
    //   320: aload 6
    //   322: astore 4
    //   324: aload_2
    //   325: astore_3
    //   326: aload 7
    //   328: ldc 108
    //   330: ldc 110
    //   332: invokevirtual 113	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 6
    //   337: astore 4
    //   339: aload_2
    //   340: astore_3
    //   341: aload 5
    //   343: invokestatic 116	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   346: aload 6
    //   348: ifnull +20 -> 368
    //   351: aload 6
    //   353: invokeinterface 100 1 0
    //   358: ifne +10 -> 368
    //   361: aload 6
    //   363: invokeinterface 101 1 0
    //   368: aload_0
    //   369: astore_3
    //   370: aload_2
    //   371: ifnull +18 -> 389
    //   374: aload_0
    //   375: astore_3
    //   376: aload_2
    //   377: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   380: ifeq +9 -> 389
    //   383: aload_2
    //   384: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   387: aload_0
    //   388: astore_3
    //   389: ldc 2
    //   391: monitorexit
    //   392: aload_3
    //   393: areturn
    //   394: aload 4
    //   396: ifnull +20 -> 416
    //   399: aload 4
    //   401: invokeinterface 100 1 0
    //   406: ifne +10 -> 416
    //   409: aload 4
    //   411: invokeinterface 101 1 0
    //   416: aload_2
    //   417: ifnull +14 -> 431
    //   420: aload_2
    //   421: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   424: ifeq +7 -> 431
    //   427: aload_2
    //   428: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   431: aload_0
    //   432: athrow
    //   433: astore_0
    //   434: ldc 2
    //   436: monitorexit
    //   437: aload_0
    //   438: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	paramContext	android.content.Context
    //   0	439	1	paramInt	int
    //   42	386	2	localObject1	Object
    //   65	163	3	localObject2	Object
    //   239	6	3	localException1	java.lang.Exception
    //   314	79	3	localObject3	Object
    //   13	397	4	localObject4	Object
    //   16	250	5	localObject5	Object
    //   290	1	5	localException2	java.lang.Exception
    //   303	39	5	localException3	java.lang.Exception
    //   10	352	6	localObject6	Object
    //   4	323	7	locald	com.tencent.beacon.a.b.d
    //   7	165	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   66	75	95	finally
    //   107	111	95	finally
    //   117	140	95	finally
    //   146	160	95	finally
    //   315	320	95	finally
    //   326	335	95	finally
    //   341	346	95	finally
    //   174	184	231	finally
    //   187	194	231	finally
    //   205	225	231	finally
    //   174	184	239	java/lang/Exception
    //   187	194	239	java/lang/Exception
    //   205	225	239	java/lang/Exception
    //   66	75	290	java/lang/Exception
    //   107	111	290	java/lang/Exception
    //   117	140	290	java/lang/Exception
    //   146	160	290	java/lang/Exception
    //   43	56	297	finally
    //   43	56	303	java/lang/Exception
    //   22	31	433	finally
    //   36	43	433	finally
    //   79	90	433	finally
    //   255	272	433	finally
    //   276	287	433	finally
    //   351	368	433	finally
    //   376	387	433	finally
    //   399	416	433	finally
    //   420	431	433	finally
    //   431	433	433	finally
  }
  
  private static i a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isBeforeFirst()) && (!paramCursor.isAfterLast()))
    {
      com.tencent.beacon.base.util.c.a("[db] parse bean.", new Object[0]);
      i locali = new i();
      locali.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      locali.b = paramCursor.getInt(paramCursor.getColumnIndex("_key"));
      locali.c = paramCursor.getBlob(paramCursor.getColumnIndex("_datas"));
      return locali;
    }
    return null;
  }
  
  public static String a()
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
    a = locala.getString("initsdkdate", "");
    if (!com.tencent.beacon.base.util.b.c().equals(a)) {
      locala.edit().putString("initsdkdate", com.tencent.beacon.base.util.b.c());
    }
    return a;
  }
  
  public static boolean b()
  {
    com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
    int i;
    if (com.tencent.beacon.base.util.b.c().equals(a())) {
      i = locala.getInt("QUERY_TIMES_KEY", 0);
    } else {
      i = 0;
    }
    if (i <= a.a().c())
    {
      locala.edit().putInt("QUERY_TIMES_KEY", i + 1);
      return false;
    }
    com.tencent.beacon.base.util.c.d("[strategy] sdk init max times", new Object[0]);
    return true;
  }
  
  public static boolean c()
  {
    b localb = ((StrategyModule)com.tencent.beacon.a.c.c.d().a(ModuleName.STRATEGY)).b();
    boolean bool2 = localb.l();
    boolean bool1 = false;
    if (bool2)
    {
      com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
      long l1 = System.currentTimeMillis();
      long l2 = (l1 / 60000L + 480L) % 1440L;
      if ((l2 >= 0L) && (l2 <= 30L) && (l1 - locala.getLong("last_success_strategy_query_time", 0L) <= 90000000L)) {
        return true;
      }
      if (com.tencent.beacon.base.util.b.c().equals(a()))
      {
        if (locala.getInt("today_success_strategy_query_times", 0) >= localb.c()) {
          bool1 = true;
        }
        return bool1;
      }
      locala.edit().putInt("today_success_strategy_query_times", 0);
    }
    return false;
  }
  
  public static void d()
  {
    Object localObject = ((StrategyModule)com.tencent.beacon.a.c.c.d().a(ModuleName.STRATEGY)).b();
    if ((localObject != null) && (((b)localObject).l()))
    {
      localObject = com.tencent.beacon.a.d.a.a();
      int i = ((com.tencent.beacon.a.d.a)localObject).getInt("today_success_strategy_query_times", 0);
      ((com.tencent.beacon.a.d.a)localObject).edit().putInt("today_success_strategy_query_times", i + 1).putLong("last_success_strategy_query_time", System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.e.j
 * JD-Core Version:    0.7.0.1
 */