package com.tencent.map.sdk.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bs
  extends SQLiteOpenHelper
{
  private static Map<String, bs> a = new ConcurrentHashMap();
  private static final Object b = new Object();
  
  private bs(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
  }
  
  /* Error */
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 7
    //   14: aload 7
    //   16: astore 8
    //   18: aload 9
    //   20: astore 6
    //   22: aload_0
    //   23: invokevirtual 35	com/tencent/map/sdk/a/bs:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 10
    //   28: iload_1
    //   29: ifeq +41 -> 70
    //   32: iload_2
    //   33: ifeq +37 -> 70
    //   36: aload 7
    //   38: astore 8
    //   40: aload 9
    //   42: astore 6
    //   44: aload 10
    //   46: ldc 37
    //   48: iconst_1
    //   49: anewarray 39	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc 41
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 7
    //   67: goto +186 -> 253
    //   70: iload_1
    //   71: ifeq +46 -> 117
    //   74: aload 7
    //   76: astore 8
    //   78: aload 9
    //   80: astore 6
    //   82: aload 10
    //   84: ldc 37
    //   86: iconst_1
    //   87: anewarray 39	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: ldc 41
    //   94: aastore
    //   95: ldc 49
    //   97: iconst_1
    //   98: anewarray 39	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: ldc 51
    //   105: aastore
    //   106: aconst_null
    //   107: aconst_null
    //   108: aconst_null
    //   109: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore 7
    //   114: goto +139 -> 253
    //   117: aload 7
    //   119: astore 8
    //   121: aload 9
    //   123: astore 6
    //   125: aload 10
    //   127: ldc 37
    //   129: iconst_1
    //   130: anewarray 39	java/lang/String
    //   133: dup
    //   134: iconst_0
    //   135: ldc 41
    //   137: aastore
    //   138: ldc 49
    //   140: iconst_1
    //   141: anewarray 39	java/lang/String
    //   144: dup
    //   145: iconst_0
    //   146: ldc 53
    //   148: aastore
    //   149: aconst_null
    //   150: aconst_null
    //   151: aconst_null
    //   152: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   155: astore 7
    //   157: goto +96 -> 253
    //   160: aload 7
    //   162: ifnull +19 -> 181
    //   165: aload 7
    //   167: astore 8
    //   169: aload 7
    //   171: astore 6
    //   173: aload 7
    //   175: invokeinterface 59 1 0
    //   180: istore_3
    //   181: iload_3
    //   182: istore 4
    //   184: aload 7
    //   186: ifnull +43 -> 229
    //   189: aload 7
    //   191: astore 6
    //   193: aload 6
    //   195: invokeinterface 62 1 0
    //   200: iload_3
    //   201: ireturn
    //   202: astore 6
    //   204: goto +28 -> 232
    //   207: astore 7
    //   209: aload 6
    //   211: astore 8
    //   213: aload 7
    //   215: invokevirtual 65	java/lang/Throwable:printStackTrace	()V
    //   218: aload 6
    //   220: ifnull +9 -> 229
    //   223: iload 5
    //   225: istore_3
    //   226: goto -33 -> 193
    //   229: iload 4
    //   231: ireturn
    //   232: aload 8
    //   234: ifnull +10 -> 244
    //   237: aload 8
    //   239: invokeinterface 62 1 0
    //   244: goto +6 -> 250
    //   247: aload 6
    //   249: athrow
    //   250: goto -3 -> 247
    //   253: goto -93 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	bs
    //   0	256	1	paramBoolean1	boolean
    //   0	256	2	paramBoolean2	boolean
    //   7	219	3	i	int
    //   4	226	4	j	int
    //   1	223	5	k	int
    //   20	174	6	localObject1	Object
    //   202	46	6	localObject2	Object
    //   12	178	7	localCursor	android.database.Cursor
    //   207	7	7	localThrowable	Throwable
    //   16	222	8	localObject3	Object
    //   9	113	9	localObject4	Object
    //   26	100	10	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   22	28	202	finally
    //   44	67	202	finally
    //   82	114	202	finally
    //   125	157	202	finally
    //   173	181	202	finally
    //   213	218	202	finally
    //   22	28	207	java/lang/Throwable
    //   44	67	207	java/lang/Throwable
    //   82	114	207	java/lang/Throwable
    //   125	157	207	java/lang/Throwable
    //   173	181	207	java/lang/Throwable
  }
  
  public static bs a(String paramString)
  {
    for (;;)
    {
      synchronized (b)
      {
        Object localObject2 = (bs)a.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (ac.b())
          {
            localObject1 = "_test_";
            localObject2 = new StringBuilder("HalleyAction_");
            ((StringBuilder)localObject2).append(ac.c());
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(ac.g());
            ((StringBuilder)localObject2).append("_");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(".db");
            localObject1 = ((StringBuilder)localObject2).toString();
            localObject1 = new bs(ac.a(), (String)localObject1);
            a.put(paramString, localObject1);
          }
        }
        else {
          return localObject1;
        }
      }
      Object localObject1 = "_";
    }
  }
  
  /* Error */
  public final void a(java.util.List<java.lang.Long> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 126 1 0
    //   6: ifgt +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: invokevirtual 35	com/tencent/map/sdk/a/bs:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: new 128	android/content/ContentValues
    //   19: dup
    //   20: invokespecial 129	android/content/ContentValues:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: ldc 131
    //   29: ldc 53
    //   31: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokeinterface 138 1 0
    //   40: astore 6
    //   42: aload 6
    //   44: invokeinterface 143 1 0
    //   49: istore_3
    //   50: iload_3
    //   51: ifeq +41 -> 92
    //   54: aload 4
    //   56: ldc 37
    //   58: aload 5
    //   60: ldc 145
    //   62: iconst_1
    //   63: anewarray 39	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: aload 6
    //   70: invokeinterface 149 1 0
    //   75: checkcast 151	java/lang/Long
    //   78: invokevirtual 155	java/lang/Long:longValue	()J
    //   81: invokestatic 159	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   84: aastore
    //   85: invokevirtual 163	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   88: pop
    //   89: goto -47 -> 42
    //   92: aload_1
    //   93: invokeinterface 138 1 0
    //   98: astore_1
    //   99: aload_1
    //   100: invokeinterface 143 1 0
    //   105: ifeq +38 -> 143
    //   108: aload 4
    //   110: ldc 37
    //   112: ldc 145
    //   114: iconst_1
    //   115: anewarray 39	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: invokeinterface 149 1 0
    //   126: checkcast 151	java/lang/Long
    //   129: invokevirtual 155	java/lang/Long:longValue	()J
    //   132: invokestatic 159	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   135: aastore
    //   136: invokevirtual 167	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   139: pop
    //   140: goto -41 -> 99
    //   143: aload_0
    //   144: iconst_0
    //   145: iconst_1
    //   146: invokespecial 169	com/tencent/map/sdk/a/bs:a	(ZZ)I
    //   149: ifle +32 -> 181
    //   152: aload_0
    //   153: iconst_1
    //   154: iconst_0
    //   155: invokespecial 169	com/tencent/map/sdk/a/bs:a	(ZZ)I
    //   158: istore_2
    //   159: iload_2
    //   160: ifgt +21 -> 181
    //   163: aload 4
    //   165: ldc 171
    //   167: invokevirtual 174	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   170: aload 4
    //   172: ldc 176
    //   174: invokevirtual 174	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   177: return
    //   178: astore_1
    //   179: aload_1
    //   180: athrow
    //   181: return
    //   182: astore_1
    //   183: return
    //   184: astore_1
    //   185: goto -15 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	bs
    //   0	188	1	paramList	java.util.List<java.lang.Long>
    //   158	2	2	i	int
    //   49	2	3	bool	boolean
    //   14	157	4	localSQLiteDatabase	SQLiteDatabase
    //   23	36	5	localContentValues	android.content.ContentValues
    //   40	29	6	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   170	177	178	android/database/SQLException
    //   10	42	182	java/lang/Exception
    //   42	50	182	java/lang/Exception
    //   54	89	182	java/lang/Exception
    //   92	99	182	java/lang/Exception
    //   99	140	182	java/lang/Exception
    //   143	159	182	java/lang/Exception
    //   163	170	182	java/lang/Exception
    //   170	177	182	java/lang/Exception
    //   179	181	182	java/lang/Exception
    //   163	170	184	android/database/SQLException
  }
  
  public final boolean a(int paramInt)
  {
    if (a(true, true) > paramInt) {}
    try
    {
      getWritableDatabase().delete("halley_action_tbl", null, null);
      return true;
    }
    catch (Exception localThrowable)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
      }
      catch (Throwable localThrowable)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase;
          localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
          try
          {
            localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
          }
          catch (SQLException localSQLException1)
          {
            throw localSQLException1;
          }
          for (;;)
          {
            return false;
            localException = localException;
            break;
            localThrowable = localThrowable;
          }
        }
        catch (SQLException localSQLException2)
        {
          break label45;
        }
      }
    }
    if (a(true, true) <= paramInt) {}
  }
  
  /* Error */
  public final long b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: ldc2_w 187
    //   10: lreturn
    //   11: aload_0
    //   12: invokevirtual 35	com/tencent/map/sdk/a/bs:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: new 128	android/content/ContentValues
    //   20: dup
    //   21: invokespecial 129	android/content/ContentValues:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 190
    //   30: aload_1
    //   31: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc 131
    //   38: ldc 51
    //   40: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 4
    //   45: ldc 37
    //   47: aconst_null
    //   48: aload 5
    //   50: invokevirtual 194	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   53: lstore_2
    //   54: lload_2
    //   55: lreturn
    //   56: astore_1
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc2_w 187
    //   63: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	bs
    //   0	64	1	paramString	String
    //   53	2	2	l	long
    //   15	29	4	localSQLiteDatabase	SQLiteDatabase
    //   24	25	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	54	56	finally
    //   11	54	59	java/lang/Exception
  }
  
  /* Error */
  public final java.util.List<bs.a> b(int paramInt)
  {
    // Byte code:
    //   0: new 197	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 198	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 7
    //   15: aload_0
    //   16: invokevirtual 35	com/tencent/map/sdk/a/bs:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: ldc 37
    //   21: aconst_null
    //   22: ldc 49
    //   24: iconst_1
    //   25: anewarray 39	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc 51
    //   32: aastore
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: invokevirtual 47	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 8
    //   41: aload 8
    //   43: ifnull +177 -> 220
    //   46: aload 8
    //   48: astore 7
    //   50: aload 8
    //   52: astore 6
    //   54: aload 8
    //   56: invokeinterface 59 1 0
    //   61: iload_1
    //   62: invokestatic 204	java/lang/Math:min	(II)I
    //   65: istore_2
    //   66: aload 8
    //   68: astore 7
    //   70: aload 8
    //   72: astore 6
    //   74: aload 8
    //   76: invokeinterface 207 1 0
    //   81: ifeq +139 -> 220
    //   84: iconst_0
    //   85: istore_1
    //   86: aload 8
    //   88: astore 7
    //   90: aload 8
    //   92: astore 6
    //   94: aload 8
    //   96: aload 8
    //   98: ldc 41
    //   100: invokeinterface 211 2 0
    //   105: invokeinterface 215 2 0
    //   110: lstore_3
    //   111: aload 8
    //   113: astore 7
    //   115: aload 8
    //   117: astore 6
    //   119: aload 8
    //   121: aload 8
    //   123: ldc 190
    //   125: invokeinterface 211 2 0
    //   130: invokeinterface 219 2 0
    //   135: astore 10
    //   137: aload 8
    //   139: astore 7
    //   141: aload 8
    //   143: astore 6
    //   145: aload 8
    //   147: aload 8
    //   149: ldc 131
    //   151: invokeinterface 211 2 0
    //   156: invokeinterface 219 2 0
    //   161: pop
    //   162: aload 8
    //   164: astore 7
    //   166: aload 8
    //   168: astore 6
    //   170: aload 9
    //   172: new 221	com/tencent/map/sdk/a/bs$a
    //   175: dup
    //   176: lload_3
    //   177: aload 10
    //   179: iconst_0
    //   180: invokespecial 224	com/tencent/map/sdk/a/bs$a:<init>	(JLjava/lang/String;B)V
    //   183: invokeinterface 227 2 0
    //   188: pop
    //   189: iload_1
    //   190: iconst_1
    //   191: iadd
    //   192: istore_1
    //   193: iload_1
    //   194: iload_2
    //   195: if_icmpge +25 -> 220
    //   198: aload 8
    //   200: astore 7
    //   202: aload 8
    //   204: astore 6
    //   206: aload 8
    //   208: invokeinterface 230 1 0
    //   213: istore 5
    //   215: iload 5
    //   217: ifne -131 -> 86
    //   220: aload 8
    //   222: ifnull +38 -> 260
    //   225: aload 8
    //   227: astore 6
    //   229: goto +24 -> 253
    //   232: astore 6
    //   234: goto +29 -> 263
    //   237: astore 8
    //   239: aload 6
    //   241: astore 7
    //   243: aload 8
    //   245: invokevirtual 65	java/lang/Throwable:printStackTrace	()V
    //   248: aload 6
    //   250: ifnull +10 -> 260
    //   253: aload 6
    //   255: invokeinterface 62 1 0
    //   260: aload 9
    //   262: areturn
    //   263: aload 7
    //   265: ifnull +10 -> 275
    //   268: aload 7
    //   270: invokeinterface 62 1 0
    //   275: goto +6 -> 281
    //   278: aload 6
    //   280: athrow
    //   281: goto -3 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	bs
    //   0	284	1	paramInt	int
    //   65	131	2	i	int
    //   110	67	3	l	long
    //   213	3	5	bool	boolean
    //   10	218	6	localObject1	Object
    //   232	47	6	localObject2	Object
    //   13	256	7	localObject3	Object
    //   39	187	8	localCursor	android.database.Cursor
    //   237	7	8	localThrowable	Throwable
    //   7	254	9	localArrayList	java.util.ArrayList
    //   135	43	10	str	String
    // Exception table:
    //   from	to	target	type
    //   15	41	232	finally
    //   54	66	232	finally
    //   74	84	232	finally
    //   94	111	232	finally
    //   119	137	232	finally
    //   145	162	232	finally
    //   170	189	232	finally
    //   206	215	232	finally
    //   243	248	232	finally
    //   15	41	237	java/lang/Throwable
    //   54	66	237	java/lang/Throwable
    //   74	84	237	java/lang/Throwable
    //   94	111	237	java/lang/Throwable
    //   119	137	237	java/lang/Throwable
    //   145	162	237	java/lang/Throwable
    //   170	189	237	java/lang/Throwable
    //   206	215	237	java/lang/Throwable
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
    catch (SQLException localSQLException)
    {
      break label6;
    }
    catch (Exception paramSQLiteDatabase) {}
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
        if (i > 2) {
          onDowngrade(paramSQLiteDatabase, i, 2);
        }
      }
      return;
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
    catch (SQLException localSQLException)
    {
      break label6;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bs
 * JD-Core Version:    0.7.0.1
 */