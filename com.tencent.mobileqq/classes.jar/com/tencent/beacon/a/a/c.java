package com.tencent.beacon.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.beacon.d.a;

public final class c
{
  private static int a = -22876499;
  
  /* Error */
  public static java.util.List<b> a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 20	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   5: astore 4
    //   7: aload 4
    //   9: monitorenter
    //   10: ldc 22
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: ifnonnull +17 -> 37
    //   23: ldc 30
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 33	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload 4
    //   34: monitorexit
    //   35: aconst_null
    //   36: areturn
    //   37: aload_0
    //   38: invokestatic 36	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   41: invokevirtual 40	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: ldc 42
    //   46: aconst_null
    //   47: ldc 44
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 50	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_0
    //   57: new 52	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 55	java/util/ArrayList:<init>	()V
    //   64: astore_2
    //   65: aload_0
    //   66: invokeinterface 61 1 0
    //   71: ifeq +164 -> 235
    //   74: new 63	com/tencent/beacon/a/a/b
    //   77: dup
    //   78: invokespecial 64	com/tencent/beacon/a/a/b:<init>	()V
    //   81: astore_3
    //   82: aload_3
    //   83: aload_0
    //   84: aload_0
    //   85: ldc 66
    //   87: invokeinterface 70 2 0
    //   92: invokeinterface 74 2 0
    //   97: i2l
    //   98: putfield 77	com/tencent/beacon/a/a/b:a	J
    //   101: aload_3
    //   102: new 79	java/lang/String
    //   105: dup
    //   106: aload_0
    //   107: aload_0
    //   108: ldc 81
    //   110: invokeinterface 70 2 0
    //   115: invokeinterface 85 2 0
    //   120: iconst_1
    //   121: ldc 87
    //   123: invokestatic 92	com/tencent/beacon/a/f:b	([BILjava/lang/String;)[B
    //   126: invokespecial 95	java/lang/String:<init>	([B)V
    //   129: putfield 98	com/tencent/beacon/a/a/b:b	Ljava/lang/String;
    //   132: aload_3
    //   133: aload_0
    //   134: aload_0
    //   135: ldc 100
    //   137: invokeinterface 70 2 0
    //   142: invokeinterface 74 2 0
    //   147: getstatic 11	com/tencent/beacon/a/a/c:a	I
    //   150: ixor
    //   151: putfield 103	com/tencent/beacon/a/a/b:c	I
    //   154: aload_0
    //   155: aload_0
    //   156: ldc 105
    //   158: invokeinterface 70 2 0
    //   163: invokeinterface 74 2 0
    //   168: iconst_1
    //   169: if_icmpne +61 -> 230
    //   172: iconst_1
    //   173: istore_1
    //   174: aload_3
    //   175: iload_1
    //   176: putfield 108	com/tencent/beacon/a/a/b:d	Z
    //   179: aload_2
    //   180: aload_3
    //   181: invokeinterface 114 2 0
    //   186: pop
    //   187: goto -122 -> 65
    //   190: astore_3
    //   191: aload_0
    //   192: ifnull +18 -> 210
    //   195: aload_0
    //   196: invokeinterface 117 1 0
    //   201: ifne +9 -> 210
    //   204: aload_0
    //   205: invokeinterface 120 1 0
    //   210: ldc 122
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload 4
    //   221: monitorexit
    //   222: aload_2
    //   223: areturn
    //   224: astore_0
    //   225: aload 4
    //   227: monitorexit
    //   228: aload_0
    //   229: athrow
    //   230: iconst_0
    //   231: istore_1
    //   232: goto -58 -> 174
    //   235: new 124	java/lang/StringBuilder
    //   238: dup
    //   239: ldc 126
    //   241: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload_2
    //   245: invokeinterface 133 1 0
    //   250: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 143	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: ifnull +18 -> 282
    //   267: aload_0
    //   268: invokeinterface 117 1 0
    //   273: ifne +9 -> 282
    //   276: aload_0
    //   277: invokeinterface 120 1 0
    //   282: ldc 122
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: goto -72 -> 219
    //   294: aload_0
    //   295: ifnull +18 -> 313
    //   298: aload_0
    //   299: invokeinterface 117 1 0
    //   304: ifne +9 -> 313
    //   307: aload_0
    //   308: invokeinterface 120 1 0
    //   313: ldc 122
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload_2
    //   323: athrow
    //   324: astore_2
    //   325: goto -31 -> 294
    //   328: astore_0
    //   329: aconst_null
    //   330: astore_0
    //   331: aload_3
    //   332: astore_2
    //   333: goto -142 -> 191
    //   336: astore_2
    //   337: aload_3
    //   338: astore_2
    //   339: goto -148 -> 191
    //   342: astore_2
    //   343: aconst_null
    //   344: astore_0
    //   345: goto -51 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramContext	Context
    //   173	59	1	bool	boolean
    //   64	259	2	localArrayList	java.util.ArrayList
    //   324	1	2	localObject1	Object
    //   332	1	2	localException1	java.lang.Exception
    //   336	1	2	localException2	java.lang.Exception
    //   338	1	2	localException3	java.lang.Exception
    //   342	1	2	localObject2	Object
    //   1	180	3	localb	b
    //   190	148	3	localException4	java.lang.Exception
    //   5	221	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   65	172	190	java/lang/Exception
    //   174	187	190	java/lang/Exception
    //   235	263	190	java/lang/Exception
    //   10	19	224	finally
    //   23	35	224	finally
    //   195	210	224	finally
    //   210	219	224	finally
    //   219	222	224	finally
    //   267	282	224	finally
    //   282	291	224	finally
    //   298	313	224	finally
    //   313	324	224	finally
    //   57	65	324	finally
    //   65	172	324	finally
    //   174	187	324	finally
    //   235	263	324	finally
    //   37	57	328	java/lang/Exception
    //   57	65	336	java/lang/Exception
    //   37	57	342	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, java.util.List<b> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 20	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   6: astore 5
    //   8: aload 5
    //   10: monitorenter
    //   11: ldc 150
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: ifnull +16 -> 37
    //   24: aload_1
    //   25: ifnull +12 -> 37
    //   28: aload_1
    //   29: invokeinterface 133 1 0
    //   34: ifne +8 -> 42
    //   37: aload 5
    //   39: monitorexit
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_0
    //   43: invokestatic 36	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   46: invokevirtual 40	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 153	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   54: aload_1
    //   55: invokeinterface 157 1 0
    //   60: astore_1
    //   61: aload_1
    //   62: invokeinterface 162 1 0
    //   67: ifeq +161 -> 228
    //   70: aload_1
    //   71: invokeinterface 166 1 0
    //   76: checkcast 63	com/tencent/beacon/a/a/b
    //   79: astore 4
    //   81: new 168	android/content/ContentValues
    //   84: dup
    //   85: invokespecial 169	android/content/ContentValues:<init>	()V
    //   88: astore 6
    //   90: aload 6
    //   92: ldc 81
    //   94: aload 4
    //   96: getfield 98	com/tencent/beacon/a/a/b:b	Ljava/lang/String;
    //   99: invokevirtual 173	java/lang/String:getBytes	()[B
    //   102: iconst_1
    //   103: ldc 87
    //   105: invokestatic 175	com/tencent/beacon/a/f:a	([BILjava/lang/String;)[B
    //   108: invokevirtual 179	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   111: aload 6
    //   113: ldc 100
    //   115: aload 4
    //   117: getfield 103	com/tencent/beacon/a/a/b:c	I
    //   120: getstatic 11	com/tencent/beacon/a/a/c:a	I
    //   123: ixor
    //   124: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: invokevirtual 188	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   130: aload 4
    //   132: getfield 108	com/tencent/beacon/a/a/b:d	Z
    //   135: ifeq +83 -> 218
    //   138: iconst_1
    //   139: istore_3
    //   140: aload 6
    //   142: ldc 105
    //   144: iload_3
    //   145: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: invokevirtual 188	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   151: iload_2
    //   152: ifeq +71 -> 223
    //   155: iconst_1
    //   156: istore_3
    //   157: aload 6
    //   159: ldc 190
    //   161: iload_3
    //   162: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokevirtual 188	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   168: aload_0
    //   169: ldc 42
    //   171: aconst_null
    //   172: aload 6
    //   174: iconst_4
    //   175: invokevirtual 194	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   178: pop2
    //   179: goto -118 -> 61
    //   182: astore_1
    //   183: ldc 196
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   196: ldc 201
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: iconst_0
    //   206: istore_2
    //   207: aload 5
    //   209: monitorexit
    //   210: iload_2
    //   211: ireturn
    //   212: astore_0
    //   213: aload 5
    //   215: monitorexit
    //   216: aload_0
    //   217: athrow
    //   218: iconst_0
    //   219: istore_3
    //   220: goto -80 -> 140
    //   223: iconst_0
    //   224: istore_3
    //   225: goto -68 -> 157
    //   228: aload_0
    //   229: invokevirtual 204	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   232: aload_0
    //   233: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   236: ldc 201
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: iconst_1
    //   246: istore_2
    //   247: goto -40 -> 207
    //   250: aload_0
    //   251: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   254: ldc 201
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_1
    //   264: athrow
    //   265: astore_1
    //   266: goto -16 -> 250
    //   269: astore_1
    //   270: goto -20 -> 250
    //   273: astore_0
    //   274: aload 4
    //   276: astore_0
    //   277: goto -94 -> 183
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_0
    //   283: goto -33 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramContext	Context
    //   0	286	1	paramList	java.util.List<b>
    //   0	286	2	paramBoolean	boolean
    //   139	86	3	i	int
    //   1	274	4	localb	b
    //   6	208	5	localObject	Object
    //   88	85	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   50	61	182	java/lang/Throwable
    //   61	138	182	java/lang/Throwable
    //   140	151	182	java/lang/Throwable
    //   157	179	182	java/lang/Throwable
    //   228	232	182	java/lang/Throwable
    //   11	20	212	finally
    //   28	37	212	finally
    //   37	40	212	finally
    //   192	205	212	finally
    //   207	210	212	finally
    //   232	245	212	finally
    //   250	265	212	finally
    //   50	61	265	finally
    //   61	138	265	finally
    //   140	151	265	finally
    //   157	179	265	finally
    //   228	232	265	finally
    //   183	192	269	finally
    //   42	50	273	java/lang/Throwable
    //   42	50	280	finally
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    synchronized (e.a)
    {
      a.b(" updateAppUseData start", new Object[0]);
      if (paramContext == null) {
        return false;
      }
      try
      {
        e.a(paramContext).getWritableDatabase().execSQL("update t_apple set _d = 1 where _d = 0");
        bool = true;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          a.b("updateAppUseData failure!", new Object[0]);
          a.b("updateAppUseData end", new Object[0]);
        }
      }
      finally
      {
        a.b("updateAppUseData end", new Object[0]);
      }
      return bool;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    bool2 = false;
    bool1 = false;
    synchronized (e.a)
    {
      a.b(" deleteAppUseData start", new Object[0]);
      if (paramContext == null)
      {
        a.a(" delete() context is null arg", new Object[0]);
        return false;
      }
      try
      {
        int i = e.a(paramContext).getWritableDatabase().delete("t_apple", null, null);
        a.b(" deleted num: " + i, new Object[0]);
        if (i > 0) {
          bool1 = true;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          a.b(paramContext.getMessage(), new Object[0]);
          a.b(" deleteAppUseData end", new Object[0]);
          bool1 = bool2;
        }
      }
      finally
      {
        a.b(" deleteAppUseData end", new Object[0]);
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.c
 * JD-Core Version:    0.7.0.1
 */