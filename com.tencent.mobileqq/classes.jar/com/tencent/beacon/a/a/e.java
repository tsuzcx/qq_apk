package com.tencent.beacon.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.beacon.d.a;

public final class e
  extends SQLiteOpenHelper
{
  public static Object a = new Object();
  private static SQLiteDatabase c = null;
  private Context b;
  
  private e(Context paramContext)
  {
    super(paramContext, "beacon_db", null, 21);
    this.b = paramContext;
  }
  
  public static e a(Context paramContext)
  {
    try
    {
      paramContext = new e(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 38	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 39	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_1
    //   12: ldc 41
    //   14: iconst_1
    //   15: anewarray 43	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 45
    //   22: aastore
    //   23: ldc 47
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 53	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +74 -> 110
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokeinterface 59 1 0
    //   49: ifeq +61 -> 110
    //   52: aload 4
    //   54: astore_3
    //   55: aload 5
    //   57: aload 4
    //   59: iconst_0
    //   60: invokeinterface 63 2 0
    //   65: invokeinterface 69 2 0
    //   70: pop
    //   71: goto -32 -> 39
    //   74: astore_1
    //   75: aload 4
    //   77: astore_3
    //   78: aload_1
    //   79: invokestatic 74	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   82: aload 4
    //   84: ifnull +20 -> 104
    //   87: aload 4
    //   89: invokeinterface 77 1 0
    //   94: ifne +10 -> 104
    //   97: aload 4
    //   99: invokeinterface 80 1 0
    //   104: iconst_0
    //   105: istore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: iload_2
    //   109: ireturn
    //   110: aload 4
    //   112: astore_3
    //   113: aload 5
    //   115: invokeinterface 84 1 0
    //   120: ifle +140 -> 260
    //   123: aload 4
    //   125: astore_3
    //   126: aload 5
    //   128: invokeinterface 88 1 0
    //   133: astore 5
    //   135: aload 4
    //   137: astore_3
    //   138: aload 5
    //   140: invokeinterface 93 1 0
    //   145: ifeq +115 -> 260
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: invokeinterface 97 1 0
    //   158: checkcast 43	java/lang/String
    //   161: astore 6
    //   163: aload 4
    //   165: astore_3
    //   166: aload 6
    //   168: ldc 99
    //   170: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifne -38 -> 135
    //   176: aload 4
    //   178: astore_3
    //   179: aload 6
    //   181: ldc 104
    //   183: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifne -51 -> 135
    //   189: aload 4
    //   191: astore_3
    //   192: aload_1
    //   193: getstatic 110	java/util/Locale:US	Ljava/util/Locale;
    //   196: ldc 112
    //   198: iconst_1
    //   199: anewarray 14	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 6
    //   206: aastore
    //   207: invokestatic 116	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokevirtual 120	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   213: aload 4
    //   215: astore_3
    //   216: ldc 122
    //   218: iconst_1
    //   219: anewarray 14	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload 6
    //   226: aastore
    //   227: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: goto -95 -> 135
    //   233: astore_1
    //   234: aload_3
    //   235: ifnull +18 -> 253
    //   238: aload_3
    //   239: invokeinterface 77 1 0
    //   244: ifne +9 -> 253
    //   247: aload_3
    //   248: invokeinterface 80 1 0
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: aload_0
    //   257: monitorexit
    //   258: aload_1
    //   259: athrow
    //   260: aload 4
    //   262: ifnull +20 -> 282
    //   265: aload 4
    //   267: invokeinterface 77 1 0
    //   272: ifne +10 -> 282
    //   275: aload 4
    //   277: invokeinterface 80 1 0
    //   282: iconst_1
    //   283: istore_2
    //   284: goto -178 -> 106
    //   287: astore_1
    //   288: aconst_null
    //   289: astore_3
    //   290: goto -56 -> 234
    //   293: astore_1
    //   294: aconst_null
    //   295: astore 4
    //   297: goto -222 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	e
    //   0	300	1	paramSQLiteDatabase	SQLiteDatabase
    //   105	179	2	bool	boolean
    //   41	249	3	localCursor1	android.database.Cursor
    //   32	264	4	localCursor2	android.database.Cursor
    //   9	143	5	localObject	Object
    //   161	64	6	str	String
    // Exception table:
    //   from	to	target	type
    //   42	52	74	java/lang/Throwable
    //   55	71	74	java/lang/Throwable
    //   113	123	74	java/lang/Throwable
    //   126	135	74	java/lang/Throwable
    //   138	148	74	java/lang/Throwable
    //   151	163	74	java/lang/Throwable
    //   166	176	74	java/lang/Throwable
    //   179	189	74	java/lang/Throwable
    //   192	213	74	java/lang/Throwable
    //   216	230	74	java/lang/Throwable
    //   42	52	233	finally
    //   55	71	233	finally
    //   78	82	233	finally
    //   113	123	233	finally
    //   126	135	233	finally
    //   138	148	233	finally
    //   151	163	233	finally
    //   166	176	233	finally
    //   179	189	233	finally
    //   192	213	233	finally
    //   216	230	233	finally
    //   87	104	255	finally
    //   238	253	255	finally
    //   253	255	255	finally
    //   265	282	255	finally
    //   2	34	287	finally
    //   2	34	293	java/lang/Throwable
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    int i = 0;
    try
    {
      for (;;)
      {
        SQLiteDatabase localSQLiteDatabase1 = c;
        if ((localSQLiteDatabase1 != null) || (i >= 5)) {
          break;
        }
        i += 1;
        try
        {
          c = super.getWritableDatabase();
        }
        catch (Exception localException)
        {
          a.c("getWritableDatabase error count %d", new Object[] { Integer.valueOf(i) });
          if (i == 5) {
            a.d("error get DB failed", new Object[0]);
          }
          try
          {
            Thread.sleep(200L);
          }
          catch (InterruptedException localInterruptedException)
          {
            a.a(localInterruptedException);
          }
        }
      }
      localSQLiteDatabase2 = c;
    }
    finally {}
    SQLiteDatabase localSQLiteDatabase2;
    return localSQLiteDatabase2;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (d.a != null)
      {
        String[][] arrayOfString = d.a;
        int j = arrayOfString.length;
        while (i < j)
        {
          String[] arrayOfString1 = arrayOfString[i];
          a.g("table:%s", new Object[] { arrayOfString1[0] });
          paramSQLiteDatabase.execSQL(arrayOfString1[1]);
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/beacon/a/a/e:b	Landroid/content/Context;
    //   6: invokestatic 176	com/tencent/beacon/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/f;
    //   9: pop
    //   10: invokestatic 179	com/tencent/beacon/a/f:d	()Ljava/lang/String;
    //   13: invokestatic 183	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   16: bipush 11
    //   18: if_icmplt +53 -> 71
    //   21: ldc 185
    //   23: iconst_3
    //   24: anewarray 14	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: ldc 25
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: iload_2
    //   35: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: iload_3
    //   42: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 187	com/tencent/beacon/a/a/e:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   54: ifeq +20 -> 74
    //   57: ldc 189
    //   59: iconst_0
    //   60: anewarray 14	java/lang/Object
    //   63: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 191	com/tencent/beacon/a/a/e:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: ldc 193
    //   76: iconst_0
    //   77: anewarray 14	java/lang/Object
    //   80: invokestatic 149	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_0
    //   84: getfield 30	com/tencent/beacon/a/a/e:b	Landroid/content/Context;
    //   87: ldc 25
    //   89: invokevirtual 199	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -23 -> 71
    //   97: aload_1
    //   98: invokevirtual 204	java/io/File:canWrite	()Z
    //   101: ifeq -30 -> 71
    //   104: aload_1
    //   105: invokevirtual 207	java/io/File:delete	()Z
    //   108: pop
    //   109: goto -38 -> 71
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	e
    //   0	117	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	117	2	paramInt1	int
    //   0	117	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	71	112	finally
    //   74	93	112	finally
    //   97	109	112	finally
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 211
    //   4: iconst_3
    //   5: anewarray 14	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 25
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iload_2
    //   16: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: iload_3
    //   23: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 187	com/tencent/beacon/a/a/e:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   35: ifeq +20 -> 55
    //   38: ldc 189
    //   40: iconst_0
    //   41: anewarray 14	java/lang/Object
    //   44: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 191	com/tencent/beacon/a/a/e:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: ldc 193
    //   57: iconst_0
    //   58: anewarray 14	java/lang/Object
    //   61: invokestatic 149	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: getfield 30	com/tencent/beacon/a/a/e:b	Landroid/content/Context;
    //   68: ldc 25
    //   70: invokevirtual 199	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull -23 -> 52
    //   78: aload_1
    //   79: invokevirtual 204	java/io/File:canWrite	()Z
    //   82: ifeq -30 -> 52
    //   85: aload_1
    //   86: invokevirtual 207	java/io/File:delete	()Z
    //   89: pop
    //   90: goto -38 -> 52
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	e
    //   0	98	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	98	2	paramInt1	int
    //   0	98	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	52	93	finally
    //   55	74	93	finally
    //   78	90	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.e
 * JD-Core Version:    0.7.0.1
 */