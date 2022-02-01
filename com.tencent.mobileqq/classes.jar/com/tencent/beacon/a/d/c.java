package com.tencent.beacon.a.d;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.beacon.a.b.d;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class c
  extends SQLiteOpenHelper
{
  private String a = "";
  
  public c(String paramString)
  {
    super((Context)localObject, localStringBuilder.toString(), null, 1);
    com.tencent.beacon.base.util.c.a("[DB]", 0, "DBOpenHelper construc.", new Object[0]);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("beacon_db_");
    ((StringBuilder)localObject).append(paramString);
    this.a = ((StringBuilder)localObject).toString();
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload 6
    //   11: astore 4
    //   13: new 57	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 58	java/util/ArrayList:<init>	()V
    //   20: astore 7
    //   22: aload 5
    //   24: astore_3
    //   25: aload 6
    //   27: astore 4
    //   29: aload_1
    //   30: ldc 60
    //   32: iconst_1
    //   33: anewarray 62	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 64
    //   40: aastore
    //   41: ldc 66
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 72	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +54 -> 108
    //   57: aload 5
    //   59: astore_3
    //   60: aload 5
    //   62: astore 4
    //   64: aload 5
    //   66: invokeinterface 78 1 0
    //   71: ifeq +37 -> 108
    //   74: aload 5
    //   76: astore_3
    //   77: aload 5
    //   79: astore 4
    //   81: aload 7
    //   83: aload 5
    //   85: iconst_0
    //   86: invokeinterface 82 2 0
    //   91: invokeinterface 88 2 0
    //   96: pop
    //   97: goto -40 -> 57
    //   100: astore_1
    //   101: goto +277 -> 378
    //   104: astore_1
    //   105: goto +221 -> 326
    //   108: aload 5
    //   110: astore_3
    //   111: aload 5
    //   113: astore 4
    //   115: aload 7
    //   117: invokeinterface 92 1 0
    //   122: ifle +180 -> 302
    //   125: aload 5
    //   127: astore_3
    //   128: aload 5
    //   130: astore 4
    //   132: aload 7
    //   134: invokeinterface 96 1 0
    //   139: astore 6
    //   141: aload 5
    //   143: astore_3
    //   144: aload 5
    //   146: astore 4
    //   148: aload 6
    //   150: invokeinterface 101 1 0
    //   155: ifeq +147 -> 302
    //   158: aload 5
    //   160: astore_3
    //   161: aload 5
    //   163: astore 4
    //   165: aload 6
    //   167: invokeinterface 105 1 0
    //   172: checkcast 62	java/lang/String
    //   175: astore 7
    //   177: aload 5
    //   179: astore_3
    //   180: aload 5
    //   182: astore 4
    //   184: aload 7
    //   186: ldc 107
    //   188: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: istore_2
    //   192: iload_2
    //   193: ifne -52 -> 141
    //   196: aload 5
    //   198: astore_3
    //   199: aload 5
    //   201: astore 4
    //   203: aload 7
    //   205: ldc 112
    //   207: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifne -69 -> 141
    //   213: aload 5
    //   215: astore_3
    //   216: aload 5
    //   218: astore 4
    //   220: new 20	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   227: astore 8
    //   229: aload 5
    //   231: astore_3
    //   232: aload 5
    //   234: astore 4
    //   236: aload 8
    //   238: ldc 114
    //   240: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 5
    //   246: astore_3
    //   247: aload 5
    //   249: astore 4
    //   251: aload 8
    //   253: aload 7
    //   255: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 5
    //   261: astore_3
    //   262: aload 5
    //   264: astore 4
    //   266: aload_1
    //   267: aload 8
    //   269: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokevirtual 117	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   275: aload 5
    //   277: astore_3
    //   278: aload 5
    //   280: astore 4
    //   282: ldc 42
    //   284: iconst_1
    //   285: ldc 119
    //   287: iconst_1
    //   288: anewarray 46	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload 7
    //   295: aastore
    //   296: invokestatic 51	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V
    //   299: goto -158 -> 141
    //   302: aload 5
    //   304: ifnull +20 -> 324
    //   307: aload 5
    //   309: invokeinterface 122 1 0
    //   314: ifne +10 -> 324
    //   317: aload 5
    //   319: invokeinterface 125 1 0
    //   324: iconst_1
    //   325: ireturn
    //   326: aload 4
    //   328: astore_3
    //   329: invokestatic 131	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   332: astore 5
    //   334: aload 4
    //   336: astore_3
    //   337: aload 5
    //   339: ldc 133
    //   341: ldc 135
    //   343: aload_1
    //   344: invokevirtual 138	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   347: aload 4
    //   349: astore_3
    //   350: aload_1
    //   351: invokestatic 141	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   354: aload 4
    //   356: ifnull +20 -> 376
    //   359: aload 4
    //   361: invokeinterface 122 1 0
    //   366: ifne +10 -> 376
    //   369: aload 4
    //   371: invokeinterface 125 1 0
    //   376: iconst_0
    //   377: ireturn
    //   378: aload_3
    //   379: ifnull +18 -> 397
    //   382: aload_3
    //   383: invokeinterface 122 1 0
    //   388: ifne +9 -> 397
    //   391: aload_3
    //   392: invokeinterface 125 1 0
    //   397: goto +5 -> 402
    //   400: aload_1
    //   401: athrow
    //   402: goto -2 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	c
    //   0	405	1	paramSQLiteDatabase	SQLiteDatabase
    //   191	2	2	bool	boolean
    //   8	384	3	localObject1	Object
    //   11	359	4	localObject2	Object
    //   4	334	5	localObject3	Object
    //   1	165	6	localIterator	Iterator
    //   20	274	7	localObject4	Object
    //   227	41	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	22	100	finally
    //   29	52	100	finally
    //   64	74	100	finally
    //   81	97	100	finally
    //   115	125	100	finally
    //   132	141	100	finally
    //   148	158	100	finally
    //   165	177	100	finally
    //   184	192	100	finally
    //   203	213	100	finally
    //   220	229	100	finally
    //   236	244	100	finally
    //   251	259	100	finally
    //   266	275	100	finally
    //   282	299	100	finally
    //   329	334	100	finally
    //   337	347	100	finally
    //   350	354	100	finally
    //   13	22	104	java/lang/Throwable
    //   29	52	104	java/lang/Throwable
    //   64	74	104	java/lang/Throwable
    //   81	97	104	java/lang/Throwable
    //   115	125	104	java/lang/Throwable
    //   132	141	104	java/lang/Throwable
    //   148	158	104	java/lang/Throwable
    //   165	177	104	java/lang/Throwable
    //   184	192	104	java/lang/Throwable
    //   203	213	104	java/lang/Throwable
    //   220	229	104	java/lang/Throwable
    //   236	244	104	java/lang/Throwable
    //   251	259	104	java/lang/Throwable
    //   266	275	104	java/lang/Throwable
    //   282	299	104	java/lang/Throwable
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (a(paramSQLiteDatabase))
    {
      com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] drop all success recreate!", new Object[0]);
      onCreate(paramSQLiteDatabase);
      return;
    }
    com.tencent.beacon.base.util.c.e("[db] drop all fail try deleted file,may next time will success!", new Object[0]);
    paramSQLiteDatabase = com.tencent.beacon.a.c.c.d().c().getDatabasePath(this.a);
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
      paramSQLiteDatabase.delete();
    }
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    paramSQLiteDatabase.setPageSize(4096L);
    paramSQLiteDatabase.enableWriteAheadLogging();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    com.tencent.beacon.base.util.c.a("[DB]", 0, "DBOpenHelper onCreate.", new Object[0]);
    try
    {
      Object localObject = b.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramSQLiteDatabase.execSQL((String)((Iterator)localObject).next());
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      localObject = d.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("error msg: ");
      localStringBuilder.append(paramSQLiteDatabase.getMessage());
      ((d)localObject).a("601", localStringBuilder.toString(), paramSQLiteDatabase);
      com.tencent.beacon.base.util.c.b("[DB] crate db table error!", new Object[0]);
      com.tencent.beacon.base.util.c.a(paramSQLiteDatabase);
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Downgrade a db  [%s] from v %d to  v%d , deleted all tables!", new Object[] { this.a, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", new Object[] { this.a, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.d.c
 * JD-Core Version:    0.7.0.1
 */