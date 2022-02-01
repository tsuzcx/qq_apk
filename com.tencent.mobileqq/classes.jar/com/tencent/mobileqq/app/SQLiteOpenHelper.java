package com.tencent.mobileqq.app;

import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.qphone.base.util.QLog;

public class SQLiteOpenHelper
{
  private static final String REPORT_WAL_EXCEPTION = "actWALException";
  private static final String REPORT_WAL_READ_EXCEPTION_KEY = "ReadWALException";
  private static final String REPORT_WAL_WRITE_EXCEPTION_KEY = "WriteWALException";
  public static final String TAG = "SQLiteOpenHelper";
  public static boolean WAL_ENABLE = true;
  private static boolean sTryWalException = false;
  private SQLiteDatabase dbR;
  private SQLiteDatabase dbW;
  private ISQLiteOpenHelper helper;
  private TableNameCache tbnCache = new TableNameCache();
  
  public SQLiteOpenHelper(ISQLiteOpenHelper paramISQLiteOpenHelper)
  {
    QLog.d("SQLiteOpenHelper", 1, new Object[] { " new SQLiteOpenHelper  helper = ", paramISQLiteOpenHelper, " this = ", this });
    if (QLog.isColorLevel()) {
      QLog.d("SQLiteOpenHelper", 1, new Object[] { " new SQLiteOpenHelper, db name = ", paramISQLiteOpenHelper.getDatabaseName() });
    }
    this.helper = paramISQLiteOpenHelper;
  }
  
  public static final void throwDebugException(Exception paramException) {}
  
  public void close()
  {
    for (;;)
    {
      try
      {
        if (this.dbR != null)
        {
          Integer localInteger = Integer.valueOf(this.dbR.hashCode());
          if (this.dbW == null) {
            break label119;
          }
          localObject2 = Integer.valueOf(this.dbW.hashCode());
          QLog.d("SQLiteOpenHelper", 1, new Object[] { " close, dbR = : ", localInteger, " dbW = ", localObject2, " helper = ", this.helper, " this = ", this });
          this.helper.close();
          return;
        }
      }
      finally {}
      String str = "null";
      continue;
      label119:
      Object localObject2 = "null";
    }
  }
  
  /* Error */
  public SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   6: invokeinterface 101 1 0
    //   11: astore 4
    //   13: getstatic 103	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   16: ifeq +138 -> 154
    //   19: invokestatic 108	com/tencent/util/VersionUtils:e	()Z
    //   22: ifeq +132 -> 154
    //   25: aload 4
    //   27: ifnull +127 -> 154
    //   30: getstatic 110	com/tencent/mobileqq/app/SQLiteOpenHelper:sTryWalException	Z
    //   33: istore_1
    //   34: iload_1
    //   35: ifne +119 -> 154
    //   38: aload 4
    //   40: invokevirtual 115	android/database/sqlite/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   43: pop
    //   44: goto +110 -> 154
    //   47: astore_2
    //   48: ldc 17
    //   50: iconst_1
    //   51: bipush 6
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: ldc 117
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: ldc 88
    //   69: aastore
    //   70: dup
    //   71: iconst_3
    //   72: aload_0
    //   73: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   76: aastore
    //   77: dup
    //   78: iconst_4
    //   79: ldc 45
    //   81: aastore
    //   82: dup
    //   83: iconst_5
    //   84: aload_0
    //   85: aastore
    //   86: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   89: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +30 -> 122
    //   95: ldc 17
    //   97: iconst_1
    //   98: iconst_2
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: ldc 121
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_0
    //   110: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   113: invokeinterface 63 1 0
    //   118: aastore
    //   119: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   122: iconst_1
    //   123: putstatic 110	com/tencent/mobileqq/app/SQLiteOpenHelper:sTryWalException	Z
    //   126: new 123	java/util/HashMap
    //   129: dup
    //   130: invokespecial 124	java/util/HashMap:<init>	()V
    //   133: astore_2
    //   134: aload_2
    //   135: ldc 11
    //   137: ldc 126
    //   139: invokevirtual 130	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aconst_null
    //   144: ldc 8
    //   146: iconst_1
    //   147: lconst_0
    //   148: lconst_0
    //   149: aload_2
    //   150: aconst_null
    //   151: invokestatic 136	com/tencent/mobileqq/imcore/proxy/basic/StatisticCollectorProxy:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   154: aload 4
    //   156: ifnonnull +109 -> 265
    //   159: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +53 -> 215
    //   165: ldc 17
    //   167: iconst_1
    //   168: iconst_5
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: ldc 138
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload_0
    //   180: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   183: invokevirtual 74	java/lang/Object:hashCode	()I
    //   186: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: new 96	java/lang/Exception
    //   195: dup
    //   196: invokespecial 139	java/lang/Exception:<init>	()V
    //   199: aastore
    //   200: dup
    //   201: iconst_3
    //   202: ldc 141
    //   204: aastore
    //   205: dup
    //   206: iconst_4
    //   207: aload_0
    //   208: aastore
    //   209: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   212: goto +53 -> 265
    //   215: ldc 17
    //   217: iconst_1
    //   218: bipush 6
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: ldc 138
    //   227: aastore
    //   228: dup
    //   229: iconst_1
    //   230: aload_0
    //   231: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   234: invokevirtual 74	java/lang/Object:hashCode	()I
    //   237: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: ldc 88
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: aload_0
    //   249: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   252: aastore
    //   253: dup
    //   254: iconst_4
    //   255: ldc 45
    //   257: aastore
    //   258: dup
    //   259: iconst_5
    //   260: aload_0
    //   261: aastore
    //   262: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   265: aload_0
    //   266: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   269: ifnull +15 -> 284
    //   272: aload_0
    //   273: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   276: getfield 147	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   279: aload 4
    //   281: if_acmpeq +279 -> 560
    //   284: aload_0
    //   285: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   288: ifnull +285 -> 573
    //   291: aload_0
    //   292: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   295: invokevirtual 74	java/lang/Object:hashCode	()I
    //   298: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: astore_2
    //   302: goto +3 -> 305
    //   305: aload 4
    //   307: ifnull +272 -> 579
    //   310: aload 4
    //   312: invokevirtual 74	java/lang/Object:hashCode	()I
    //   315: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: astore_3
    //   319: goto +3 -> 322
    //   322: ldc 17
    //   324: iconst_1
    //   325: iconst_4
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: ldc 149
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_2
    //   337: aastore
    //   338: dup
    //   339: iconst_2
    //   340: ldc 151
    //   342: aastore
    //   343: dup
    //   344: iconst_3
    //   345: aload_3
    //   346: aastore
    //   347: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   350: aload_0
    //   351: new 143	com/tencent/mobileqq/app/SQLiteDatabase
    //   354: dup
    //   355: aload 4
    //   357: aload_0
    //   358: getfield 41	com/tencent/mobileqq/app/SQLiteOpenHelper:tbnCache	Lcom/tencent/mobileqq/persistence/TableNameCache;
    //   361: aload_0
    //   362: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   365: invokeinterface 63 1 0
    //   370: invokespecial 154	com/tencent/mobileqq/app/SQLiteDatabase:<init>	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/persistence/TableNameCache;Ljava/lang/String;)V
    //   373: putfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   376: aload_0
    //   377: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   380: ifnull +205 -> 585
    //   383: aload_0
    //   384: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   387: invokevirtual 74	java/lang/Object:hashCode	()I
    //   390: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: astore_2
    //   394: goto +3 -> 397
    //   397: ldc 17
    //   399: iconst_1
    //   400: bipush 6
    //   402: anewarray 4	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: ldc 156
    //   409: aastore
    //   410: dup
    //   411: iconst_1
    //   412: aload_2
    //   413: aastore
    //   414: dup
    //   415: iconst_2
    //   416: ldc 88
    //   418: aastore
    //   419: dup
    //   420: iconst_3
    //   421: aload_0
    //   422: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   425: aastore
    //   426: dup
    //   427: iconst_4
    //   428: ldc 45
    //   430: aastore
    //   431: dup
    //   432: iconst_5
    //   433: aload_0
    //   434: aastore
    //   435: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   438: goto +122 -> 560
    //   441: astore_2
    //   442: goto +127 -> 569
    //   445: astore_3
    //   446: aload_0
    //   447: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   450: ifnull +141 -> 591
    //   453: aload_0
    //   454: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   457: invokevirtual 74	java/lang/Object:hashCode	()I
    //   460: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   463: astore_2
    //   464: goto +3 -> 467
    //   467: ldc 17
    //   469: iconst_1
    //   470: bipush 7
    //   472: anewarray 4	java/lang/Object
    //   475: dup
    //   476: iconst_0
    //   477: ldc 158
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: ldc 160
    //   484: aastore
    //   485: dup
    //   486: iconst_2
    //   487: aload_2
    //   488: aastore
    //   489: dup
    //   490: iconst_3
    //   491: ldc 88
    //   493: aastore
    //   494: dup
    //   495: iconst_4
    //   496: aload_0
    //   497: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   500: aastore
    //   501: dup
    //   502: iconst_5
    //   503: ldc 45
    //   505: aastore
    //   506: dup
    //   507: bipush 6
    //   509: aload_0
    //   510: aastore
    //   511: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   514: ldc 17
    //   516: iconst_1
    //   517: ldc 161
    //   519: aload_3
    //   520: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   523: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +30 -> 556
    //   529: ldc 17
    //   531: iconst_1
    //   532: iconst_2
    //   533: anewarray 4	java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: ldc 166
    //   540: aastore
    //   541: dup
    //   542: iconst_1
    //   543: aload_0
    //   544: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   547: invokeinterface 63 1 0
    //   552: aastore
    //   553: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   556: aload_3
    //   557: invokestatic 168	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   560: aload_0
    //   561: getfield 70	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   564: astore_2
    //   565: aload_0
    //   566: monitorexit
    //   567: aload_2
    //   568: areturn
    //   569: aload_0
    //   570: monitorexit
    //   571: aload_2
    //   572: athrow
    //   573: ldc 92
    //   575: astore_2
    //   576: goto -271 -> 305
    //   579: ldc 92
    //   581: astore_3
    //   582: goto -260 -> 322
    //   585: ldc 92
    //   587: astore_2
    //   588: goto -191 -> 397
    //   591: ldc 92
    //   593: astore_2
    //   594: goto -127 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	SQLiteOpenHelper
    //   33	2	1	bool	boolean
    //   47	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   133	280	2	localObject1	Object
    //   441	1	2	localObject2	Object
    //   463	131	2	localObject3	Object
    //   318	28	3	localInteger	Integer
    //   445	112	3	localException	Exception
    //   581	1	3	str	String
    //   11	345	4	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   38	44	47	java/lang/IllegalStateException
    //   2	25	441	finally
    //   30	34	441	finally
    //   38	44	441	finally
    //   48	122	441	finally
    //   122	154	441	finally
    //   159	212	441	finally
    //   215	265	441	finally
    //   265	284	441	finally
    //   284	302	441	finally
    //   310	319	441	finally
    //   322	394	441	finally
    //   397	438	441	finally
    //   446	464	441	finally
    //   467	556	441	finally
    //   556	560	441	finally
    //   560	565	441	finally
    //   2	25	445	java/lang/Exception
    //   30	34	445	java/lang/Exception
    //   38	44	445	java/lang/Exception
    //   48	122	445	java/lang/Exception
    //   122	154	445	java/lang/Exception
    //   159	212	445	java/lang/Exception
    //   215	265	445	java/lang/Exception
    //   265	284	445	java/lang/Exception
    //   284	302	445	java/lang/Exception
    //   310	319	445	java/lang/Exception
    //   322	394	445	java/lang/Exception
    //   397	438	445	java/lang/Exception
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   6: invokeinterface 171 1 0
    //   11: astore 4
    //   13: getstatic 103	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   16: ifeq +138 -> 154
    //   19: invokestatic 108	com/tencent/util/VersionUtils:e	()Z
    //   22: ifeq +132 -> 154
    //   25: aload 4
    //   27: ifnull +127 -> 154
    //   30: getstatic 110	com/tencent/mobileqq/app/SQLiteOpenHelper:sTryWalException	Z
    //   33: istore_1
    //   34: iload_1
    //   35: ifne +119 -> 154
    //   38: aload 4
    //   40: invokevirtual 115	android/database/sqlite/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   43: pop
    //   44: goto +110 -> 154
    //   47: astore_2
    //   48: ldc 17
    //   50: iconst_1
    //   51: bipush 6
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: ldc 117
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: ldc 88
    //   69: aastore
    //   70: dup
    //   71: iconst_3
    //   72: aload_0
    //   73: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   76: aastore
    //   77: dup
    //   78: iconst_4
    //   79: ldc 45
    //   81: aastore
    //   82: dup
    //   83: iconst_5
    //   84: aload_0
    //   85: aastore
    //   86: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   89: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +30 -> 122
    //   95: ldc 17
    //   97: iconst_1
    //   98: iconst_2
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: ldc 121
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_0
    //   110: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   113: invokeinterface 63 1 0
    //   118: aastore
    //   119: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   122: iconst_1
    //   123: putstatic 110	com/tencent/mobileqq/app/SQLiteOpenHelper:sTryWalException	Z
    //   126: new 123	java/util/HashMap
    //   129: dup
    //   130: invokespecial 124	java/util/HashMap:<init>	()V
    //   133: astore_2
    //   134: aload_2
    //   135: ldc 14
    //   137: ldc 126
    //   139: invokevirtual 130	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aconst_null
    //   144: ldc 8
    //   146: iconst_1
    //   147: lconst_0
    //   148: lconst_0
    //   149: aload_2
    //   150: aconst_null
    //   151: invokestatic 136	com/tencent/mobileqq/imcore/proxy/basic/StatisticCollectorProxy:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   154: aload 4
    //   156: ifnonnull +123 -> 279
    //   159: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +67 -> 229
    //   165: ldc 17
    //   167: iconst_1
    //   168: bipush 7
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: ldc 173
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload_0
    //   181: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   184: invokevirtual 74	java/lang/Object:hashCode	()I
    //   187: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: dup
    //   192: iconst_2
    //   193: new 96	java/lang/Exception
    //   196: dup
    //   197: invokespecial 139	java/lang/Exception:<init>	()V
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: ldc 88
    //   205: aastore
    //   206: dup
    //   207: iconst_4
    //   208: aload_0
    //   209: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   212: aastore
    //   213: dup
    //   214: iconst_5
    //   215: ldc 45
    //   217: aastore
    //   218: dup
    //   219: bipush 6
    //   221: aload_0
    //   222: aastore
    //   223: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   226: goto +53 -> 279
    //   229: ldc 17
    //   231: iconst_1
    //   232: bipush 6
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: ldc 173
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: aload_0
    //   245: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   248: invokevirtual 74	java/lang/Object:hashCode	()I
    //   251: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: aastore
    //   255: dup
    //   256: iconst_2
    //   257: ldc 88
    //   259: aastore
    //   260: dup
    //   261: iconst_3
    //   262: aload_0
    //   263: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   266: aastore
    //   267: dup
    //   268: iconst_4
    //   269: ldc 45
    //   271: aastore
    //   272: dup
    //   273: iconst_5
    //   274: aload_0
    //   275: aastore
    //   276: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   279: aload_0
    //   280: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   283: ifnull +15 -> 298
    //   286: aload_0
    //   287: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   290: getfield 147	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   293: aload 4
    //   295: if_acmpeq +279 -> 574
    //   298: aload_0
    //   299: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   302: ifnull +285 -> 587
    //   305: aload_0
    //   306: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   309: invokevirtual 74	java/lang/Object:hashCode	()I
    //   312: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: astore_2
    //   316: goto +3 -> 319
    //   319: aload 4
    //   321: ifnull +272 -> 593
    //   324: aload 4
    //   326: invokevirtual 74	java/lang/Object:hashCode	()I
    //   329: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: astore_3
    //   333: goto +3 -> 336
    //   336: ldc 17
    //   338: iconst_1
    //   339: iconst_4
    //   340: anewarray 4	java/lang/Object
    //   343: dup
    //   344: iconst_0
    //   345: ldc 175
    //   347: aastore
    //   348: dup
    //   349: iconst_1
    //   350: aload_2
    //   351: aastore
    //   352: dup
    //   353: iconst_2
    //   354: ldc 151
    //   356: aastore
    //   357: dup
    //   358: iconst_3
    //   359: aload_3
    //   360: aastore
    //   361: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   364: aload_0
    //   365: new 143	com/tencent/mobileqq/app/SQLiteDatabase
    //   368: dup
    //   369: aload 4
    //   371: aload_0
    //   372: getfield 41	com/tencent/mobileqq/app/SQLiteOpenHelper:tbnCache	Lcom/tencent/mobileqq/persistence/TableNameCache;
    //   375: aload_0
    //   376: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   379: invokeinterface 63 1 0
    //   384: invokespecial 154	com/tencent/mobileqq/app/SQLiteDatabase:<init>	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/persistence/TableNameCache;Ljava/lang/String;)V
    //   387: putfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   390: aload_0
    //   391: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   394: ifnull +205 -> 599
    //   397: aload_0
    //   398: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   401: invokevirtual 74	java/lang/Object:hashCode	()I
    //   404: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: astore_2
    //   408: goto +3 -> 411
    //   411: ldc 17
    //   413: iconst_1
    //   414: bipush 6
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: ldc 177
    //   423: aastore
    //   424: dup
    //   425: iconst_1
    //   426: aload_2
    //   427: aastore
    //   428: dup
    //   429: iconst_2
    //   430: ldc 88
    //   432: aastore
    //   433: dup
    //   434: iconst_3
    //   435: aload_0
    //   436: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   439: aastore
    //   440: dup
    //   441: iconst_4
    //   442: ldc 45
    //   444: aastore
    //   445: dup
    //   446: iconst_5
    //   447: aload_0
    //   448: aastore
    //   449: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   452: goto +122 -> 574
    //   455: astore_2
    //   456: goto +127 -> 583
    //   459: astore_3
    //   460: aload_0
    //   461: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   464: ifnull +141 -> 605
    //   467: aload_0
    //   468: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   471: invokevirtual 74	java/lang/Object:hashCode	()I
    //   474: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   477: astore_2
    //   478: goto +3 -> 481
    //   481: ldc 17
    //   483: iconst_1
    //   484: bipush 7
    //   486: anewarray 4	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: ldc 179
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: ldc 181
    //   498: aastore
    //   499: dup
    //   500: iconst_2
    //   501: aload_2
    //   502: aastore
    //   503: dup
    //   504: iconst_3
    //   505: ldc 88
    //   507: aastore
    //   508: dup
    //   509: iconst_4
    //   510: aload_0
    //   511: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   514: aastore
    //   515: dup
    //   516: iconst_5
    //   517: ldc 45
    //   519: aastore
    //   520: dup
    //   521: bipush 6
    //   523: aload_0
    //   524: aastore
    //   525: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   528: ldc 17
    //   530: iconst_1
    //   531: ldc 182
    //   533: aload_3
    //   534: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   537: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +30 -> 570
    //   543: ldc 17
    //   545: iconst_1
    //   546: iconst_2
    //   547: anewarray 4	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: ldc 184
    //   554: aastore
    //   555: dup
    //   556: iconst_1
    //   557: aload_0
    //   558: getfield 65	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   561: invokeinterface 63 1 0
    //   566: aastore
    //   567: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   570: aload_3
    //   571: invokestatic 168	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   574: aload_0
    //   575: getfield 82	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   578: astore_2
    //   579: aload_0
    //   580: monitorexit
    //   581: aload_2
    //   582: areturn
    //   583: aload_0
    //   584: monitorexit
    //   585: aload_2
    //   586: athrow
    //   587: ldc 92
    //   589: astore_2
    //   590: goto -271 -> 319
    //   593: ldc 92
    //   595: astore_3
    //   596: goto -260 -> 336
    //   599: ldc 92
    //   601: astore_2
    //   602: goto -191 -> 411
    //   605: ldc 92
    //   607: astore_2
    //   608: goto -127 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	611	0	this	SQLiteOpenHelper
    //   33	2	1	bool	boolean
    //   47	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   133	294	2	localObject1	Object
    //   455	1	2	localObject2	Object
    //   477	131	2	localObject3	Object
    //   332	28	3	localInteger	Integer
    //   459	112	3	localException	Exception
    //   595	1	3	str	String
    //   11	359	4	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   38	44	47	java/lang/IllegalStateException
    //   2	25	455	finally
    //   30	34	455	finally
    //   38	44	455	finally
    //   48	122	455	finally
    //   122	154	455	finally
    //   159	226	455	finally
    //   229	279	455	finally
    //   279	298	455	finally
    //   298	316	455	finally
    //   324	333	455	finally
    //   336	408	455	finally
    //   411	452	455	finally
    //   460	478	455	finally
    //   481	570	455	finally
    //   570	574	455	finally
    //   574	579	455	finally
    //   2	25	459	java/lang/Exception
    //   30	34	459	java/lang/Exception
    //   38	44	459	java/lang/Exception
    //   48	122	459	java/lang/Exception
    //   122	154	459	java/lang/Exception
    //   159	226	459	java/lang/Exception
    //   229	279	459	java/lang/Exception
    //   279	298	459	java/lang/Exception
    //   298	316	459	java/lang/Exception
    //   324	333	459	java/lang/Exception
    //   336	408	459	java/lang/Exception
    //   411	452	459	java/lang/Exception
  }
  
  public void stop()
  {
    for (;;)
    {
      try
      {
        if (this.dbR != null)
        {
          Integer localInteger = Integer.valueOf(this.dbR.hashCode());
          if (this.dbW == null) {
            break label115;
          }
          localObject2 = Integer.valueOf(this.dbW.hashCode());
          QLog.d("SQLiteOpenHelper", 1, new Object[] { " stop, dbR = : ", localInteger, " dbW = ", localObject2, " helper = ", this.helper, " this = ", this });
          this.helper = null;
          return;
        }
      }
      finally {}
      String str = "null";
      continue;
      label115:
      Object localObject2 = "null";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */