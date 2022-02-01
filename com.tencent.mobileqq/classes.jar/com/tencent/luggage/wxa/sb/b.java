package com.tencent.luggage.wxa.sb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b
  extends SQLiteOpenHelper
  implements d
{
  private SQLiteDatabase a;
  
  public b(@Nullable Context paramContext)
  {
    super(paramContext, "Scheduler.db", null, 1);
    try
    {
      this.a = getWritableDatabase();
      return;
    }
    catch (Exception paramContext)
    {
      c.c.c("ExperienceStorage", "%s", new Object[] { paramContext.toString() });
    }
  }
  
  private static ContentValues a(a.b paramb)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("taskName", paramb.a);
    localContentValues.put("threadTime", Long.valueOf(paramb.b));
    localContentValues.put("time", Long.valueOf(paramb.c));
    localContentValues.put("timestamp", Long.valueOf(paramb.e));
    localContentValues.put("rate", Float.valueOf(paramb.f));
    localContentValues.put("scheduler", paramb.d);
    return localContentValues;
  }
  
  public Map<String, a.a> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = this.a;
    if (localObject2 == null) {
      return localHashMap;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ((SQLiteDatabase)localObject2).query("DisposedTask", new String[] { "taskName", String.format("avg(%s)", new Object[] { "rate" }), String.format("avg(%s)", new Object[] { "threadTime" }) }, null, null, "taskName", null, null);
      localObject1 = localObject2;
      ((Cursor)localObject2).moveToFirst();
      for (;;)
      {
        localObject1 = localObject2;
        if (((Cursor)localObject2).isAfterLast()) {
          break;
        }
        localObject1 = localObject2;
        a.a locala = new b.a(this, (Cursor)localObject2).a();
        localObject1 = localObject2;
        localHashMap.put(locala.a(), locala);
        localObject1 = localObject2;
        ((Cursor)localObject2).moveToNext();
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      return localHashMap;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.close();
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.a == null) {
      return;
    }
    if (paramLong <= 0L) {
      paramLong = System.currentTimeMillis();
    } else {
      paramLong += System.currentTimeMillis();
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      localSQLiteDatabase.delete("DisposedTask", "timestamp<?", new String[] { localStringBuilder.toString() });
      return;
    }
    catch (Exception localException)
    {
      c.c.c("ExperienceStorage", "%s", new Object[] { localException.toString() });
    }
  }
  
  public void a(Collection<a.a> paramCollection)
  {
    if (this.a != null)
    {
      if (paramCollection.size() <= 0) {
        return;
      }
      try
      {
        this.a.beginTransaction();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          Object localObject = (a.a)paramCollection.next();
          localObject = new a.b(((a.a)localObject).a(), ((a.a)localObject).b, ((a.a)localObject).c, "");
          ((a.b)localObject).e = System.currentTimeMillis();
          this.a.insert("DisposedTask", null, a((a.b)localObject));
        }
        return;
      }
      finally
      {
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DisposedTask(_ID INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL, taskName TEXT NOT NULL, threadTime LONG NOT NULL, time LONG NOT NULL, rate REAL NOT NULL, timestamp LONG NOT NULL, scheduler TEXT NOT NULL )");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS timestampIndex ON DisposedTask(timestamp)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS taskNameIndex ON DisposedTask(taskName)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sb.b
 * JD-Core Version:    0.7.0.1
 */