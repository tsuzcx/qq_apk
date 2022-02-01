package com.tencent.beacon.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import com.tencent.beacon.base.util.c;
import java.util.Locale;

public class j$a
  extends SQLiteOpenHelper
{
  public j$a(@Nullable Context paramContext, @Nullable String paramString)
  {
    super(paramContext, paramString, null, 30);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", new Object[] { "t_strategy", "_id", "_key", "_ut", "_datas" }));
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    c.a("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", new Object[] { "beacon_db", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.e.j.a
 * JD-Core Version:    0.7.0.1
 */