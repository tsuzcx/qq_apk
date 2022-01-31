package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import com.tencent.bugly.crashreport.common.info.b;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class q
  extends SQLiteOpenHelper
{
  private static String a = "bugly_db";
  private static int b = 15;
  private Context c;
  private List<a> d;
  
  public q(Context paramContext, List<a> paramList)
  {
    super(paramContext, localStringBuilder.toString(), null, b);
    this.c = paramContext;
    this.d = paramList;
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: iconst_3
    //   6: anewarray 63	java/lang/String
    //   9: astore 6
    //   11: aload 6
    //   13: iconst_0
    //   14: ldc 65
    //   16: aastore
    //   17: aload 6
    //   19: iconst_1
    //   20: ldc 67
    //   22: aastore
    //   23: aload 6
    //   25: iconst_2
    //   26: ldc 69
    //   28: aastore
    //   29: aload 6
    //   31: arraylength
    //   32: istore_3
    //   33: iconst_0
    //   34: istore_2
    //   35: iload 5
    //   37: istore 4
    //   39: iload_2
    //   40: iload_3
    //   41: if_icmpge +56 -> 97
    //   44: aload 6
    //   46: iload_2
    //   47: aaload
    //   48: astore 7
    //   50: aload_1
    //   51: new 26	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 71
    //   57: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload 7
    //   62: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 63	java/lang/String
    //   72: invokevirtual 80	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: iload_2
    //   76: iconst_1
    //   77: iadd
    //   78: istore_2
    //   79: goto -44 -> 35
    //   82: astore_1
    //   83: aload_1
    //   84: invokestatic 85	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   87: ifne +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 88	java/lang/Throwable:printStackTrace	()V
    //   94: iconst_0
    //   95: istore 4
    //   97: aload_0
    //   98: monitorexit
    //   99: iload 4
    //   101: ireturn
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	q
    //   0	107	1	paramSQLiteDatabase	SQLiteDatabase
    //   34	45	2	i	int
    //   32	10	3	j	int
    //   37	63	4	bool1	boolean
    //   1	35	5	bool2	boolean
    //   9	36	6	arrayOfString	String[]
    //   48	13	7	str	String
    // Exception table:
    //   from	to	target	type
    //   5	11	82	java/lang/Throwable
    //   29	33	82	java/lang/Throwable
    //   50	75	82	java/lang/Throwable
    //   5	11	102	finally
    //   29	33	102	finally
    //   50	75	102	finally
    //   83	94	102	finally
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    int i = 0;
    Object localObject = null;
    while ((localObject == null) && (i < 5))
    {
      i += 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getReadableDatabase();
        localObject = localSQLiteDatabase2;
      }
      catch (Throwable localThrowable)
      {
        x.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
        if (i == 5) {
          x.e("[Database] Failed to get db.", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    return localSQLiteDatabase1;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    int i = 0;
    Object localObject = null;
    while ((localObject == null) && (i < 5))
    {
      i += 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        localObject = localSQLiteDatabase2;
      }
      catch (Throwable localThrowable)
      {
        x.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
        if (i == 5) {
          x.e("[Database] Failed to get db.", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    if (localSQLiteDatabase1 == null) {
      x.d("[Database] db error delay error record 1min.", new Object[0]);
    }
    return localSQLiteDatabase1;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_ui").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _ut").append(" int").append(" , _tp").append(" int").append(" , _dt").append(" blob").append(" , _pc").append(" text").append(" ) ");
        x.c(((StringBuilder)localObject).toString(), new Object[0]);
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString(), new String[0]);
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_lr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tp").append(" int").append(" , _tm").append(" int").append(" , _pc").append(" text").append(" , _th").append(" text").append(" , _dt").append(" blob").append(" ) ");
        x.c(((StringBuilder)localObject).toString(), new Object[0]);
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString(), new String[0]);
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_pf").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
        x.c(((StringBuilder)localObject).toString(), new Object[0]);
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString(), new String[0]);
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_cr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _s1").append(" text").append(" , _up").append(" int").append(" , _me").append(" int").append(" , _uc").append(" int").append(" , _dt").append(" blob").append(" ) ");
        x.c(((StringBuilder)localObject).toString(), new Object[0]);
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString(), new String[0]);
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS dl_1002").append(" (_id").append(" integer primary key autoincrement, _dUrl").append(" varchar(100), _sFile").append(" varchar(100), _sLen").append(" INTEGER, _tLen").append(" INTEGER, _MD5").append(" varchar(100), _DLTIME").append(" INTEGER)");
        x.c(((StringBuilder)localObject).toString(), new Object[0]);
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString(), new String[0]);
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS ge_1002").append(" (_id").append(" integer primary key autoincrement, _time").append(" INTEGER, _datas").append(" blob)");
        x.c(((StringBuilder)localObject).toString(), new Object[0]);
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString(), new String[0]);
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS st_1002").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
        x.c(((StringBuilder)localObject).toString(), new Object[0]);
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString(), new String[0]);
        localObject = this.d;
        if (localObject == null) {
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        if (x.b(localThrowable1)) {
          continue;
        }
        localThrowable1.printStackTrace();
        continue;
      }
      finally {}
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        try
        {
          locala.onDbCreate(paramSQLiteDatabase);
        }
        catch (Throwable localThrowable2) {}
        if (!x.b(localThrowable2)) {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  @TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      if (b.c() < 11) {
        break label121;
      }
      x.d("[Database] Downgrade %d to %d drop tables.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.d != null)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          try
          {
            locala.onDbDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
          }
          catch (Throwable localThrowable) {}
          if (!x.b(localThrowable)) {
            localThrowable.printStackTrace();
          }
        }
      }
      if (!a(paramSQLiteDatabase)) {
        break label124;
      }
    }
    finally {}
    onCreate(paramSQLiteDatabase);
    for (;;)
    {
      label121:
      return;
      label124:
      x.d("[Database] Failed to drop, delete db.", new Object[0]);
      paramSQLiteDatabase = this.c.getDatabasePath(a);
      if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
        paramSQLiteDatabase.delete();
      }
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      x.d("[Database] Upgrade %d to %d , drop tables!", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.d != null)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          try
          {
            locala.onDbUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
          }
          catch (Throwable localThrowable) {}
          if (!x.b(localThrowable)) {
            localThrowable.printStackTrace();
          }
        }
      }
      if (!a(paramSQLiteDatabase)) {
        break label117;
      }
    }
    finally {}
    onCreate(paramSQLiteDatabase);
    for (;;)
    {
      return;
      label117:
      x.d("[Database] Failed to drop, delete db.", new Object[0]);
      paramSQLiteDatabase = this.c.getDatabasePath(a);
      if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
        paramSQLiteDatabase.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.q
 * JD-Core Version:    0.7.0.1
 */