package com.tencent.acstat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.acstat.common.StatLogger;

class an
  extends SQLiteOpenHelper
{
  private String a = "";
  private Context b = null;
  
  public an(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 3);
    this.a = paramString;
    this.b = paramContext.getApplicationContext();
    if (StatConfig.isDebugEnable())
    {
      paramContext = af.e();
      paramString = new StringBuilder("SQLiteOpenHelper ");
      paramString.append(this.a);
      paramContext.i(paramString.toString());
    }
  }
  
  /* Error */
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_1
    //   9: ldc 65
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_3
    //   21: new 73	android/content/ContentValues
    //   24: dup
    //   25: invokespecial 76	android/content/ContentValues:<init>	()V
    //   28: astore 4
    //   30: aload 5
    //   32: astore_2
    //   33: aload_3
    //   34: invokeinterface 81 1 0
    //   39: ifeq +46 -> 85
    //   42: aload_3
    //   43: iconst_0
    //   44: invokeinterface 85 2 0
    //   49: astore_2
    //   50: aload_3
    //   51: iconst_1
    //   52: invokeinterface 89 2 0
    //   57: pop
    //   58: aload_3
    //   59: iconst_2
    //   60: invokeinterface 85 2 0
    //   65: pop
    //   66: aload_3
    //   67: iconst_3
    //   68: invokeinterface 93 2 0
    //   73: pop2
    //   74: aload 4
    //   76: ldc 95
    //   78: aload_2
    //   79: invokestatic 101	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 105	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_2
    //   86: ifnull +22 -> 108
    //   89: aload_1
    //   90: ldc 65
    //   92: aload 4
    //   94: ldc 107
    //   96: iconst_1
    //   97: anewarray 109	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: aload_2
    //   103: aastore
    //   104: invokevirtual 113	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   107: pop
    //   108: aload_3
    //   109: ifnull +60 -> 169
    //   112: aload_3
    //   113: invokeinterface 116 1 0
    //   118: return
    //   119: astore_1
    //   120: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   123: aload_1
    //   124: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   127: return
    //   128: astore_1
    //   129: goto +41 -> 170
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: aload_2
    //   136: astore_3
    //   137: goto +13 -> 150
    //   140: astore_1
    //   141: aload_2
    //   142: astore_3
    //   143: goto +27 -> 170
    //   146: astore_3
    //   147: aload 4
    //   149: astore_1
    //   150: aload_1
    //   151: astore_2
    //   152: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   155: aload_3
    //   156: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   159: aload_1
    //   160: ifnull +9 -> 169
    //   163: aload_1
    //   164: invokeinterface 116 1 0
    //   169: return
    //   170: aload_3
    //   171: ifnull +20 -> 191
    //   174: aload_3
    //   175: invokeinterface 116 1 0
    //   180: goto +11 -> 191
    //   183: astore_2
    //   184: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   187: aload_2
    //   188: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   191: aload_1
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	an
    //   0	193	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	102	2	localObject1	Object
    //   132	10	2	localThrowable1	java.lang.Throwable
    //   151	1	2	localSQLiteDatabase	SQLiteDatabase
    //   183	5	2	localThrowable2	java.lang.Throwable
    //   20	123	3	localObject2	Object
    //   146	29	3	localThrowable3	java.lang.Throwable
    //   3	145	4	localContentValues	android.content.ContentValues
    //   6	25	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   112	118	119	java/lang/Throwable
    //   163	169	119	java/lang/Throwable
    //   21	30	128	finally
    //   33	85	128	finally
    //   89	108	128	finally
    //   21	30	132	java/lang/Throwable
    //   33	85	132	java/lang/Throwable
    //   89	108	132	java/lang/Throwable
    //   8	21	140	finally
    //   152	159	140	finally
    //   8	21	146	java/lang/Throwable
    //   174	180	183	java/lang/Throwable
  }
  
  /* Error */
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: ldc 121
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_2
    //   21: aload 4
    //   23: astore_3
    //   24: new 123	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 124	java/util/ArrayList:<init>	()V
    //   31: astore 6
    //   33: aload 4
    //   35: astore_2
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: invokeinterface 81 1 0
    //   46: ifeq +59 -> 105
    //   49: aload 4
    //   51: astore_2
    //   52: aload 4
    //   54: astore_3
    //   55: aload 6
    //   57: new 126	com/tencent/acstat/ao
    //   60: dup
    //   61: aload 4
    //   63: iconst_0
    //   64: invokeinterface 93 2 0
    //   69: aload 4
    //   71: iconst_1
    //   72: invokeinterface 85 2 0
    //   77: aload 4
    //   79: iconst_2
    //   80: invokeinterface 89 2 0
    //   85: aload 4
    //   87: iconst_3
    //   88: invokeinterface 89 2 0
    //   93: invokespecial 129	com/tencent/acstat/ao:<init>	(JLjava/lang/String;II)V
    //   96: invokeinterface 135 2 0
    //   101: pop
    //   102: goto -69 -> 33
    //   105: aload 4
    //   107: astore_2
    //   108: aload 4
    //   110: astore_3
    //   111: new 73	android/content/ContentValues
    //   114: dup
    //   115: invokespecial 76	android/content/ContentValues:<init>	()V
    //   118: astore 5
    //   120: aload 4
    //   122: astore_2
    //   123: aload 4
    //   125: astore_3
    //   126: aload 6
    //   128: invokeinterface 139 1 0
    //   133: astore 6
    //   135: aload 4
    //   137: astore_2
    //   138: aload 4
    //   140: astore_3
    //   141: aload 6
    //   143: invokeinterface 144 1 0
    //   148: ifeq +77 -> 225
    //   151: aload 4
    //   153: astore_2
    //   154: aload 4
    //   156: astore_3
    //   157: aload 6
    //   159: invokeinterface 148 1 0
    //   164: checkcast 126	com/tencent/acstat/ao
    //   167: astore 7
    //   169: aload 4
    //   171: astore_2
    //   172: aload 4
    //   174: astore_3
    //   175: aload 5
    //   177: ldc 150
    //   179: aload 7
    //   181: getfield 152	com/tencent/acstat/ao:b	Ljava/lang/String;
    //   184: invokestatic 101	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 105	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload 4
    //   192: astore_2
    //   193: aload 4
    //   195: astore_3
    //   196: aload_1
    //   197: ldc 121
    //   199: aload 5
    //   201: ldc 154
    //   203: iconst_1
    //   204: anewarray 109	java/lang/String
    //   207: dup
    //   208: iconst_0
    //   209: aload 7
    //   211: getfield 157	com/tencent/acstat/ao:a	J
    //   214: invokestatic 162	java/lang/Long:toString	(J)Ljava/lang/String;
    //   217: aastore
    //   218: invokevirtual 113	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   221: pop
    //   222: goto -87 -> 135
    //   225: aload 4
    //   227: ifnull +44 -> 271
    //   230: aload 4
    //   232: invokeinterface 116 1 0
    //   237: return
    //   238: astore_1
    //   239: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   242: aload_1
    //   243: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   246: return
    //   247: astore_1
    //   248: goto +24 -> 272
    //   251: astore_1
    //   252: aload_3
    //   253: astore_2
    //   254: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   257: aload_1
    //   258: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   261: aload_3
    //   262: ifnull +9 -> 271
    //   265: aload_3
    //   266: invokeinterface 116 1 0
    //   271: return
    //   272: aload_2
    //   273: ifnull +20 -> 293
    //   276: aload_2
    //   277: invokeinterface 116 1 0
    //   282: goto +11 -> 293
    //   285: astore_2
    //   286: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   289: aload_2
    //   290: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   293: goto +5 -> 298
    //   296: aload_1
    //   297: athrow
    //   298: goto -2 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	an
    //   0	301	1	paramSQLiteDatabase	SQLiteDatabase
    //   3	274	2	localObject1	Object
    //   285	5	2	localThrowable	java.lang.Throwable
    //   1	265	3	localObject2	Object
    //   16	215	4	localCursor	android.database.Cursor
    //   118	82	5	localContentValues	android.content.ContentValues
    //   31	127	6	localObject3	Object
    //   167	43	7	localao	ao
    // Exception table:
    //   from	to	target	type
    //   230	237	238	java/lang/Throwable
    //   265	271	238	java/lang/Throwable
    //   4	18	247	finally
    //   24	33	247	finally
    //   39	49	247	finally
    //   55	102	247	finally
    //   111	120	247	finally
    //   126	135	247	finally
    //   141	151	247	finally
    //   157	169	247	finally
    //   175	190	247	finally
    //   196	222	247	finally
    //   254	261	247	finally
    //   4	18	251	java/lang/Throwable
    //   24	33	251	java/lang/Throwable
    //   39	49	251	java/lang/Throwable
    //   55	102	251	java/lang/Throwable
    //   111	120	251	java/lang/Throwable
    //   126	135	251	java/lang/Throwable
    //   141	151	251	java/lang/Throwable
    //   157	169	251	java/lang/Throwable
    //   175	190	251	java/lang/Throwable
    //   196	222	251	java/lang/Throwable
    //   276	282	285	java/lang/Throwable
  }
  
  public boolean a()
  {
    if (StatConfig.isDebugEnable())
    {
      StatLogger localStatLogger = af.e();
      StringBuilder localStringBuilder = new StringBuilder("delete ");
      localStringBuilder.append(this.a);
      localStatLogger.w(localStringBuilder.toString());
    }
    return this.b.deleteDatabase(this.a);
  }
  
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
    paramSQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StatLogger localStatLogger = af.e();
    StringBuilder localStringBuilder = new StringBuilder("upgrade DB from oldVersion ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" to newVersion ");
    localStringBuilder.append(paramInt2);
    localStatLogger.debug(localStringBuilder.toString());
    if (paramInt1 == 1)
    {
      paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
    if (paramInt1 == 2)
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.an
 * JD-Core Version:    0.7.0.1
 */