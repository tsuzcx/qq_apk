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

public final class ba
  extends SQLiteOpenHelper
{
  private static Map<String, ba> a = new ConcurrentHashMap();
  private static final Object b = new Object();
  
  private ba(Context paramContext, String paramString)
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
    //   4: invokevirtual 35	c/t/m/g/ba:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: iload_1
    //   10: ifeq +61 -> 71
    //   13: iload_2
    //   14: ifeq +57 -> 71
    //   17: aload 4
    //   19: ldc 37
    //   21: iconst_1
    //   22: anewarray 39	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 41
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +160 -> 202
    //   45: aload 4
    //   47: astore 5
    //   49: aload 4
    //   51: invokeinterface 53 1 0
    //   56: istore_3
    //   57: aload 4
    //   59: ifnull +10 -> 69
    //   62: aload 4
    //   64: invokeinterface 56 1 0
    //   69: iload_3
    //   70: ireturn
    //   71: iload_1
    //   72: ifeq +38 -> 110
    //   75: aload 4
    //   77: ldc 37
    //   79: iconst_1
    //   80: anewarray 39	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: ldc 41
    //   87: aastore
    //   88: ldc 58
    //   90: iconst_1
    //   91: anewarray 39	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: ldc 60
    //   98: aastore
    //   99: aconst_null
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore 4
    //   107: goto -67 -> 40
    //   110: aload 4
    //   112: ldc 37
    //   114: iconst_1
    //   115: anewarray 39	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: ldc 41
    //   122: aastore
    //   123: ldc 58
    //   125: iconst_1
    //   126: anewarray 39	java/lang/String
    //   129: dup
    //   130: iconst_0
    //   131: ldc 62
    //   133: aastore
    //   134: aconst_null
    //   135: aconst_null
    //   136: aconst_null
    //   137: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   140: astore 4
    //   142: goto -102 -> 40
    //   145: astore 6
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 4
    //   152: astore 5
    //   154: aload 6
    //   156: invokevirtual 65	java/lang/Throwable:printStackTrace	()V
    //   159: aload 4
    //   161: ifnull +39 -> 200
    //   164: aload 4
    //   166: invokeinterface 56 1 0
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 4
    //   175: aload 5
    //   177: ifnull +10 -> 187
    //   180: aload 5
    //   182: invokeinterface 56 1 0
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
    //   0	207	0	this	ba
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
  
  public static ba a(String paramString)
  {
    synchronized (b)
    {
      ba localba = (ba)a.get(paramString);
      Object localObject1 = localba;
      if (localba == null)
      {
        m.b();
        localObject1 = "HalleyAction_" + m.c() + "_" + m.i() + "_" + paramString + ".db";
        localObject1 = new ba(m.a(), (String)localObject1);
        a.put(paramString, localObject1);
      }
      return localObject1;
    }
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
        while (localIterator.hasNext()) {
          localSQLiteDatabase.update("halley_action_tbl", localContentValues, "key=?", new String[] { String.valueOf(((Long)localIterator.next()).longValue()) });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localSQLiteDatabase.delete("halley_action_tbl", "key=?", new String[] { String.valueOf(((Long)paramList.next()).longValue()) });
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
            label164:
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
          break label164;
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
    //   3: invokespecial 167	c/t/m/g/ba:a	(ZZ)I
    //   6: iload_1
    //   7: if_icmple +45 -> 52
    //   10: aload_0
    //   11: invokevirtual 35	c/t/m/g/ba:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc 37
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 165	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   21: pop
    //   22: iconst_1
    //   23: ireturn
    //   24: astore_2
    //   25: aload_0
    //   26: iconst_1
    //   27: iconst_1
    //   28: invokespecial 167	c/t/m/g/ba:a	(ZZ)I
    //   31: iload_1
    //   32: if_icmple +20 -> 52
    //   35: aload_0
    //   36: invokevirtual 35	c/t/m/g/ba:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore_2
    //   40: aload_2
    //   41: ldc 169
    //   43: invokevirtual 172	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   46: aload_2
    //   47: ldc 174
    //   49: invokevirtual 172	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
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
    //   0	65	0	this	ba
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
    //   1: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: ldc2_w 185
    //   10: lreturn
    //   11: aload_0
    //   12: invokevirtual 35	c/t/m/g/ba:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: new 126	android/content/ContentValues
    //   20: dup
    //   21: invokespecial 127	android/content/ContentValues:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 188
    //   30: aload_1
    //   31: invokevirtual 132	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc 129
    //   38: ldc 60
    //   40: invokevirtual 132	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 4
    //   45: ldc 37
    //   47: aconst_null
    //   48: aload 5
    //   50: invokevirtual 192	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   53: lstore_2
    //   54: lload_2
    //   55: lreturn
    //   56: astore_1
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc2_w 185
    //   63: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ba
    //   0	64	1	paramString	String
    //   53	2	2	l	long
    //   15	29	4	localSQLiteDatabase	SQLiteDatabase
    //   24	25	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	54	56	finally
    //   11	54	59	java/lang/Exception
  }
  
  /* Error */
  public final List<ba.a> b(int paramInt)
  {
    // Byte code:
    //   0: new 195	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 196	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aload_0
    //   10: invokevirtual 35	c/t/m/g/ba:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 37
    //   15: aconst_null
    //   16: ldc 58
    //   18: iconst_1
    //   19: anewarray 39	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 60
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 7
    //   35: aload 7
    //   37: ifnull +149 -> 186
    //   40: aload 7
    //   42: astore 6
    //   44: aload 7
    //   46: invokeinterface 53 1 0
    //   51: iload_1
    //   52: invokestatic 202	java/lang/Math:min	(II)I
    //   55: istore_2
    //   56: aload 7
    //   58: astore 6
    //   60: aload 7
    //   62: invokeinterface 205 1 0
    //   67: ifeq +119 -> 186
    //   70: iconst_0
    //   71: istore_1
    //   72: aload 7
    //   74: astore 6
    //   76: aload 7
    //   78: aload 7
    //   80: ldc 41
    //   82: invokeinterface 209 2 0
    //   87: invokeinterface 213 2 0
    //   92: lstore_3
    //   93: aload 7
    //   95: astore 6
    //   97: aload 7
    //   99: aload 7
    //   101: ldc 188
    //   103: invokeinterface 209 2 0
    //   108: invokeinterface 217 2 0
    //   113: astore 8
    //   115: aload 7
    //   117: astore 6
    //   119: aload 7
    //   121: aload 7
    //   123: ldc 129
    //   125: invokeinterface 209 2 0
    //   130: invokeinterface 217 2 0
    //   135: pop
    //   136: aload 7
    //   138: astore 6
    //   140: aload 9
    //   142: new 219	c/t/m/g/ba$a
    //   145: dup
    //   146: lload_3
    //   147: aload 8
    //   149: iconst_0
    //   150: invokespecial 222	c/t/m/g/ba$a:<init>	(JLjava/lang/String;B)V
    //   153: invokeinterface 225 2 0
    //   158: pop
    //   159: iload_1
    //   160: iconst_1
    //   161: iadd
    //   162: istore_1
    //   163: iload_1
    //   164: iload_2
    //   165: if_icmpge +21 -> 186
    //   168: aload 7
    //   170: astore 6
    //   172: aload 7
    //   174: invokeinterface 228 1 0
    //   179: istore 5
    //   181: iload 5
    //   183: ifne -111 -> 72
    //   186: aload 7
    //   188: ifnull +10 -> 198
    //   191: aload 7
    //   193: invokeinterface 56 1 0
    //   198: aload 9
    //   200: areturn
    //   201: astore 8
    //   203: aconst_null
    //   204: astore 7
    //   206: aload 7
    //   208: astore 6
    //   210: aload 8
    //   212: invokevirtual 65	java/lang/Throwable:printStackTrace	()V
    //   215: aload 7
    //   217: ifnull -19 -> 198
    //   220: aload 7
    //   222: invokeinterface 56 1 0
    //   227: aload 9
    //   229: areturn
    //   230: astore 7
    //   232: aconst_null
    //   233: astore 6
    //   235: aload 6
    //   237: ifnull +10 -> 247
    //   240: aload 6
    //   242: invokeinterface 56 1 0
    //   247: aload 7
    //   249: athrow
    //   250: astore 7
    //   252: goto -17 -> 235
    //   255: astore 8
    //   257: goto -51 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	ba
    //   0	260	1	paramInt	int
    //   55	111	2	i	int
    //   92	55	3	l	long
    //   179	3	5	bool	boolean
    //   42	199	6	localCursor1	android.database.Cursor
    //   33	188	7	localCursor2	android.database.Cursor
    //   230	18	7	localObject1	Object
    //   250	1	7	localObject2	Object
    //   113	35	8	str	String
    //   201	10	8	localThrowable1	java.lang.Throwable
    //   255	1	8	localThrowable2	java.lang.Throwable
    //   7	221	9	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	35	201	java/lang/Throwable
    //   9	35	230	finally
    //   44	56	250	finally
    //   60	70	250	finally
    //   76	93	250	finally
    //   97	115	250	finally
    //   119	136	250	finally
    //   140	159	250	finally
    //   172	181	250	finally
    //   210	215	250	finally
    //   44	56	255	java/lang/Throwable
    //   60	70	255	java/lang/Throwable
    //   76	93	255	java/lang/Throwable
    //   97	115	255	java/lang/Throwable
    //   119	136	255	java/lang/Throwable
    //   140	159	255	java/lang/Throwable
    //   172	181	255	java/lang/Throwable
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ba
 * JD-Core Version:    0.7.0.1
 */