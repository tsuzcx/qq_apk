package com.tencent.featuretoggle.hltxkg.common.c.b.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

final class a$a
  extends SQLiteOpenHelper
{
  public a$a(a parama, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: new 19	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 21	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: ldc 23
    //   11: iconst_1
    //   12: bipush 100
    //   14: bipush 8
    //   16: invokestatic 28	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   19: istore_1
    //   20: aload_0
    //   21: invokevirtual 32	com/tencent/featuretoggle/hltxkg/common/c/b/a/a$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 5
    //   26: aconst_null
    //   27: astore_3
    //   28: aload 5
    //   30: ldc 34
    //   32: iconst_1
    //   33: anewarray 36	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 38
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: ldc 40
    //   47: invokevirtual 46	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +122 -> 176
    //   57: aload 4
    //   59: astore_3
    //   60: aload 4
    //   62: invokeinterface 52 1 0
    //   67: iload_1
    //   68: isub
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +105 -> 176
    //   74: aload 4
    //   76: astore_3
    //   77: aload 4
    //   79: invokeinterface 56 1 0
    //   84: ifeq +92 -> 176
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: aload 4
    //   94: ldc 38
    //   96: invokeinterface 60 2 0
    //   101: invokeinterface 64 2 0
    //   106: astore 7
    //   108: aload 4
    //   110: astore_3
    //   111: aload 7
    //   113: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifne +31 -> 147
    //   119: aload 4
    //   121: astore_3
    //   122: aload 6
    //   124: aload 7
    //   126: invokeinterface 76 2 0
    //   131: ifne +16 -> 147
    //   134: aload 4
    //   136: astore_3
    //   137: aload 6
    //   139: aload 7
    //   141: invokeinterface 79 2 0
    //   146: pop
    //   147: aload 4
    //   149: astore_3
    //   150: aload 4
    //   152: invokeinterface 82 1 0
    //   157: istore_2
    //   158: iload_2
    //   159: ifeq +17 -> 176
    //   162: iload_1
    //   163: ifgt +6 -> 169
    //   166: goto +10 -> 176
    //   169: iload_1
    //   170: iconst_1
    //   171: isub
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: aload 4
    //   178: ifnull +10 -> 188
    //   181: aload 4
    //   183: invokeinterface 85 1 0
    //   188: aload 6
    //   190: invokeinterface 88 1 0
    //   195: ifle +66 -> 261
    //   198: aload 6
    //   200: invokeinterface 92 1 0
    //   205: astore_3
    //   206: aload_3
    //   207: invokeinterface 97 1 0
    //   212: ifeq +49 -> 261
    //   215: aload 5
    //   217: ldc 34
    //   219: ldc 99
    //   221: iconst_1
    //   222: anewarray 36	java/lang/String
    //   225: dup
    //   226: iconst_0
    //   227: aload_3
    //   228: invokeinterface 103 1 0
    //   233: checkcast 36	java/lang/String
    //   236: aastore
    //   237: invokevirtual 107	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   240: pop
    //   241: goto -35 -> 206
    //   244: astore 4
    //   246: aload_3
    //   247: ifnull +9 -> 256
    //   250: aload_3
    //   251: invokeinterface 85 1 0
    //   256: aload 4
    //   258: athrow
    //   259: astore_3
    //   260: return
    //   261: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	a
    //   19	154	1	i	int
    //   157	2	2	bool	boolean
    //   27	224	3	localObject1	java.lang.Object
    //   259	1	3	localException	Exception
    //   50	132	4	localCursor	android.database.Cursor
    //   244	13	4	localObject2	java.lang.Object
    //   24	192	5	localSQLiteDatabase	SQLiteDatabase
    //   7	192	6	localArrayList	java.util.ArrayList
    //   106	34	7	str	String
    // Exception table:
    //   from	to	target	type
    //   28	52	244	finally
    //   60	70	244	finally
    //   77	87	244	finally
    //   90	108	244	finally
    //   111	119	244	finally
    //   122	134	244	finally
    //   137	147	244	finally
    //   150	158	244	finally
    //   0	26	259	java/lang/Exception
    //   181	188	259	java/lang/Exception
    //   188	206	259	java/lang/Exception
    //   206	241	259	java/lang/Exception
    //   250	256	259	java/lang/Exception
    //   256	259	259	java/lang/Exception
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  /* Error */
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 32	com/tencent/featuretoggle/hltxkg/common/c/b/a/a$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 4
    //   8: aload 4
    //   10: ldc 34
    //   12: ldc 99
    //   14: iconst_1
    //   15: anewarray 36	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: aastore
    //   22: invokevirtual 107	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   25: istore_3
    //   26: new 124	android/content/ContentValues
    //   29: dup
    //   30: invokespecial 125	android/content/ContentValues:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: ldc 38
    //   39: aload_1
    //   40: invokevirtual 129	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 5
    //   45: ldc 131
    //   47: aload_2
    //   48: invokevirtual 133	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   51: aload 5
    //   53: ldc 135
    //   55: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   58: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: invokevirtual 150	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   64: ldc2_w 151
    //   67: aload 4
    //   69: ldc 34
    //   71: aconst_null
    //   72: aload 5
    //   74: invokevirtual 156	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   77: lcmp
    //   78: ifeq +11 -> 89
    //   81: iload_3
    //   82: ifgt +7 -> 89
    //   85: aload_0
    //   86: invokespecial 158	com/tencent/featuretoggle/hltxkg/common/c/b/a/a$a:a	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: astore_1
    //   101: goto -4 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   0	104	1	paramString	String
    //   0	104	2	paramArrayOfByte	byte[]
    //   25	57	3	i	int
    //   6	62	4	localSQLiteDatabase	SQLiteDatabase
    //   33	40	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   2	81	92	finally
    //   85	89	92	finally
    //   2	81	100	java/lang/Throwable
    //   85	89	100	java/lang/Throwable
  }
  
  /* Error */
  public final byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 162	com/tencent/featuretoggle/hltxkg/common/c/b/a/a$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_3
    //   7: aload_3
    //   8: ldc 34
    //   10: aconst_null
    //   11: ldc 99
    //   13: iconst_1
    //   14: anewarray 36	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 46	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +54 -> 83
    //   32: aload_3
    //   33: invokeinterface 56 1 0
    //   38: ifeq +45 -> 83
    //   41: aload_3
    //   42: aload_3
    //   43: ldc 131
    //   45: invokeinterface 60 2 0
    //   50: invokeinterface 166 2 0
    //   55: astore_1
    //   56: aload_1
    //   57: invokestatic 171	com/tencent/featuretoggle/hltxkg/common/e/c:a	([B)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifne +21 -> 83
    //   65: aload_3
    //   66: ifnull +9 -> 75
    //   69: aload_3
    //   70: invokeinterface 85 1 0
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: astore_1
    //   80: goto +16 -> 96
    //   83: aload_3
    //   84: ifnull +29 -> 113
    //   87: aload_3
    //   88: invokeinterface 85 1 0
    //   93: goto +20 -> 113
    //   96: aload_3
    //   97: ifnull +9 -> 106
    //   100: aload_3
    //   101: invokeinterface 85 1 0
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: aload_0
    //   114: monitorexit
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: goto -5 -> 113
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_3
    //   124: goto -28 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	a
    //   0	127	1	paramString	String
    //   60	2	2	bool	boolean
    //   6	118	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	61	79	finally
    //   2	7	108	finally
    //   69	75	108	finally
    //   87	93	108	finally
    //   100	106	108	finally
    //   106	108	108	finally
    //   2	7	117	java/lang/Throwable
    //   69	75	117	java/lang/Throwable
    //   87	93	117	java/lang/Throwable
    //   100	106	117	java/lang/Throwable
    //   106	108	117	java/lang/Throwable
    //   7	28	121	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
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
        a locala = this.a;
        if (i <= 0)
        {
          locala = this.a;
          a(paramSQLiteDatabase);
          b(paramSQLiteDatabase);
          return;
        }
        locala = this.a;
        if (i > 1)
        {
          locala = this.a;
          a(paramSQLiteDatabase);
          b(paramSQLiteDatabase);
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
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */