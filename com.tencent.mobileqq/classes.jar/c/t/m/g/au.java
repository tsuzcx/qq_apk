package c.t.m.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class au
  extends SQLiteOpenHelper
{
  private static Map<String, au> a = new ConcurrentHashMap();
  private static final Object b = new Object();
  
  private au(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
  }
  
  /* Error */
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 37	c/t/m/g/au:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: iload_1
    //   10: ifeq +61 -> 71
    //   13: iload_2
    //   14: ifeq +57 -> 71
    //   17: aload 4
    //   19: ldc 39
    //   21: iconst_1
    //   22: anewarray 41	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 43
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +160 -> 202
    //   45: aload 4
    //   47: astore 5
    //   49: aload 4
    //   51: invokeinterface 55 1 0
    //   56: istore_3
    //   57: aload 4
    //   59: ifnull +10 -> 69
    //   62: aload 4
    //   64: invokeinterface 58 1 0
    //   69: iload_3
    //   70: ireturn
    //   71: iload_1
    //   72: ifeq +38 -> 110
    //   75: aload 4
    //   77: ldc 39
    //   79: iconst_1
    //   80: anewarray 41	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: ldc 43
    //   87: aastore
    //   88: ldc 60
    //   90: iconst_1
    //   91: anewarray 41	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: ldc 62
    //   98: aastore
    //   99: aconst_null
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore 4
    //   107: goto -67 -> 40
    //   110: aload 4
    //   112: ldc 39
    //   114: iconst_1
    //   115: anewarray 41	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: ldc 43
    //   122: aastore
    //   123: ldc 60
    //   125: iconst_1
    //   126: anewarray 41	java/lang/String
    //   129: dup
    //   130: iconst_0
    //   131: ldc 64
    //   133: aastore
    //   134: aconst_null
    //   135: aconst_null
    //   136: aconst_null
    //   137: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   140: astore 4
    //   142: goto -102 -> 40
    //   145: astore 6
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 4
    //   152: astore 5
    //   154: aload 6
    //   156: invokevirtual 67	java/lang/Throwable:printStackTrace	()V
    //   159: aload 4
    //   161: ifnull +39 -> 200
    //   164: aload 4
    //   166: invokeinterface 58 1 0
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 4
    //   175: aload 5
    //   177: ifnull +10 -> 187
    //   180: aload 5
    //   182: invokeinterface 58 1 0
    //   187: aload 4
    //   189: athrow
    //   190: astore 4
    //   192: goto -17 -> 175
    //   195: astore 6
    //   197: goto -47 -> 150
    //   200: iconst_0
    //   201: ireturn
    //   202: iconst_0
    //   203: istore_3
    //   204: goto -147 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	au
    //   0	207	1	paramBoolean1	boolean
    //   0	207	2	paramBoolean2	boolean
    //   56	148	3	i	int
    //   7	158	4	localObject1	Object
    //   173	15	4	localObject2	Object
    //   190	1	4	localObject3	Object
    //   1	180	5	localObject4	Object
    //   145	10	6	localThrowable1	java.lang.Throwable
    //   195	1	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   3	9	145	java/lang/Throwable
    //   17	40	145	java/lang/Throwable
    //   75	107	145	java/lang/Throwable
    //   110	142	145	java/lang/Throwable
    //   3	9	173	finally
    //   17	40	173	finally
    //   75	107	173	finally
    //   110	142	173	finally
    //   49	57	190	finally
    //   154	159	190	finally
    //   49	57	195	java/lang/Throwable
  }
  
  public static au a(String paramString)
  {
    synchronized (b)
    {
      au localau = (au)a.get(paramString);
      Object localObject1 = localau;
      if (localau == null)
      {
        l.b();
        localObject1 = "HalleyAction_" + l.c() + "_" + l.i() + "_" + paramString + ".db";
        localObject1 = new au(l.a(), (String)localObject1);
        a.put(paramString, localObject1);
      }
      return localObject1;
    }
  }
  
  /* Error */
  public final List<a> a()
  {
    // Byte code:
    //   0: new 119	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 120	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aload_0
    //   10: invokevirtual 37	c/t/m/g/au:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 39
    //   15: aconst_null
    //   16: ldc 60
    //   18: iconst_1
    //   19: anewarray 41	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 62
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 7
    //   35: aload 7
    //   37: ifnull +150 -> 187
    //   40: aload 7
    //   42: astore 6
    //   44: aload 7
    //   46: invokeinterface 55 1 0
    //   51: bipush 11
    //   53: invokestatic 126	java/lang/Math:min	(II)I
    //   56: istore_2
    //   57: aload 7
    //   59: astore 6
    //   61: aload 7
    //   63: invokeinterface 129 1 0
    //   68: ifeq +119 -> 187
    //   71: iconst_0
    //   72: istore_1
    //   73: aload 7
    //   75: astore 6
    //   77: aload 7
    //   79: aload 7
    //   81: ldc 43
    //   83: invokeinterface 133 2 0
    //   88: invokeinterface 137 2 0
    //   93: lstore_3
    //   94: aload 7
    //   96: astore 6
    //   98: aload 7
    //   100: aload 7
    //   102: ldc 139
    //   104: invokeinterface 133 2 0
    //   109: invokeinterface 143 2 0
    //   114: astore 8
    //   116: aload 7
    //   118: astore 6
    //   120: aload 7
    //   122: aload 7
    //   124: ldc 145
    //   126: invokeinterface 133 2 0
    //   131: invokeinterface 143 2 0
    //   136: pop
    //   137: aload 7
    //   139: astore 6
    //   141: aload 9
    //   143: new 6	c/t/m/g/au$a
    //   146: dup
    //   147: lload_3
    //   148: aload 8
    //   150: iconst_0
    //   151: invokespecial 148	c/t/m/g/au$a:<init>	(JLjava/lang/String;B)V
    //   154: invokeinterface 153 2 0
    //   159: pop
    //   160: iload_1
    //   161: iconst_1
    //   162: iadd
    //   163: istore_1
    //   164: iload_1
    //   165: iload_2
    //   166: if_icmpge +21 -> 187
    //   169: aload 7
    //   171: astore 6
    //   173: aload 7
    //   175: invokeinterface 156 1 0
    //   180: istore 5
    //   182: iload 5
    //   184: ifne -111 -> 73
    //   187: aload 7
    //   189: ifnull +10 -> 199
    //   192: aload 7
    //   194: invokeinterface 58 1 0
    //   199: aload 9
    //   201: areturn
    //   202: astore 8
    //   204: aconst_null
    //   205: astore 7
    //   207: aload 7
    //   209: astore 6
    //   211: aload 8
    //   213: invokevirtual 67	java/lang/Throwable:printStackTrace	()V
    //   216: aload 7
    //   218: ifnull -19 -> 199
    //   221: aload 7
    //   223: invokeinterface 58 1 0
    //   228: aload 9
    //   230: areturn
    //   231: astore 7
    //   233: aconst_null
    //   234: astore 6
    //   236: aload 6
    //   238: ifnull +10 -> 248
    //   241: aload 6
    //   243: invokeinterface 58 1 0
    //   248: aload 7
    //   250: athrow
    //   251: astore 7
    //   253: goto -17 -> 236
    //   256: astore 8
    //   258: goto -51 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	au
    //   72	95	1	i	int
    //   56	111	2	j	int
    //   93	55	3	l	long
    //   180	3	5	bool	boolean
    //   42	200	6	localCursor1	android.database.Cursor
    //   33	189	7	localCursor2	android.database.Cursor
    //   231	18	7	localObject1	Object
    //   251	1	7	localObject2	Object
    //   114	35	8	str	String
    //   202	10	8	localThrowable1	java.lang.Throwable
    //   256	1	8	localThrowable2	java.lang.Throwable
    //   7	222	9	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	35	202	java/lang/Throwable
    //   9	35	231	finally
    //   44	57	251	finally
    //   61	71	251	finally
    //   77	94	251	finally
    //   98	116	251	finally
    //   120	137	251	finally
    //   141	160	251	finally
    //   173	182	251	finally
    //   211	216	251	finally
    //   44	57	256	java/lang/Throwable
    //   61	71	256	java/lang/Throwable
    //   77	94	256	java/lang/Throwable
    //   98	116	256	java/lang/Throwable
    //   120	137	256	java/lang/Throwable
    //   141	160	256	java/lang/Throwable
    //   173	182	256	java/lang/Throwable
  }
  
  public final void a(List<Long> paramList)
  {
    if (paramList.size() <= 0) {}
    for (;;)
    {
      return;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("state", "remove");
        Iterator localIterator = paramList.iterator();
        long l;
        while (localIterator.hasNext())
        {
          l = ((Long)localIterator.next()).longValue();
          localSQLiteDatabase.update("halley_action_tbl", localContentValues, "key=?", new String[] { l });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          l = ((Long)paramList.next()).longValue();
          localSQLiteDatabase.delete("halley_action_tbl", "key=?", new String[] { l });
        }
        if (a(false, true) <= 0) {
          continue;
        }
        int i = a(true, false);
        if (i > 0) {
          continue;
        }
        try
        {
          localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
          try
          {
            label192:
            localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            return;
          }
          catch (SQLException paramList)
          {
            throw paramList;
          }
        }
        catch (SQLException paramList)
        {
          break label192;
        }
        return;
      }
      catch (Exception paramList) {}
    }
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: iconst_1
    //   3: invokespecial 207	c/t/m/g/au:a	(ZZ)I
    //   6: iload_1
    //   7: if_icmple +45 -> 52
    //   10: aload_0
    //   11: invokevirtual 37	c/t/m/g/au:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc 39
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 205	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   21: pop
    //   22: iconst_1
    //   23: ireturn
    //   24: astore_2
    //   25: aload_0
    //   26: iconst_1
    //   27: iconst_1
    //   28: invokespecial 207	c/t/m/g/au:a	(ZZ)I
    //   31: iload_1
    //   32: if_icmple +20 -> 52
    //   35: aload_0
    //   36: invokevirtual 37	c/t/m/g/au:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore_2
    //   40: aload_2
    //   41: ldc 209
    //   43: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   46: aload_2
    //   47: ldc 214
    //   49: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   52: iconst_0
    //   53: ireturn
    //   54: astore_2
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: goto -6 -> 52
    //   61: astore_3
    //   62: goto -16 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	au
    //   0	65	1	paramInt	int
    //   24	1	2	localException	Exception
    //   39	8	2	localSQLiteDatabase	SQLiteDatabase
    //   54	2	2	localSQLException1	SQLException
    //   57	1	2	localThrowable	java.lang.Throwable
    //   61	1	3	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   10	22	24	java/lang/Exception
    //   46	52	54	android/database/SQLException
    //   35	40	57	java/lang/Throwable
    //   40	46	57	java/lang/Throwable
    //   46	52	57	java/lang/Throwable
    //   55	57	57	java/lang/Throwable
    //   40	46	61	android/database/SQLException
  }
  
  /* Error */
  public final long b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: ldc2_w 224
    //   10: lreturn
    //   11: aload_0
    //   12: invokevirtual 37	c/t/m/g/au:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: new 168	android/content/ContentValues
    //   20: dup
    //   21: invokespecial 169	android/content/ContentValues:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 139
    //   30: aload_1
    //   31: invokevirtual 172	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc 145
    //   38: ldc 62
    //   40: invokevirtual 172	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 4
    //   45: ldc 39
    //   47: aconst_null
    //   48: aload 5
    //   50: invokevirtual 229	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   53: lstore_2
    //   54: lload_2
    //   55: lreturn
    //   56: astore_1
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc2_w 224
    //   63: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	au
    //   0	64	1	paramString	String
    //   53	2	2	l	long
    //   15	29	4	localSQLiteDatabase	SQLiteDatabase
    //   24	25	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	54	56	finally
    //   11	54	59	java/lang/Exception
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    try
    {
      int i = paramSQLiteDatabase.getVersion();
      if (i != 0)
      {
        if (i < 2)
        {
          onUpgrade(paramSQLiteDatabase, i, 2);
          return;
        }
        if (i > 2)
        {
          onDowngrade(paramSQLiteDatabase, i, 2);
          return;
        }
      }
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
  
  public static final class a
  {
    public long a;
    public String b;
    
    public a(long paramLong, String paramString)
    {
      this.a = paramLong;
      this.b = paramString;
    }
    
    public a(long paramLong, String paramString, byte paramByte)
    {
      this(paramLong, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.au
 * JD-Core Version:    0.7.0.1
 */