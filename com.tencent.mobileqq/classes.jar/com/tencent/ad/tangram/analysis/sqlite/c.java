package com.tencent.ad.tangram.analysis.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;

class c
  extends SQLiteOpenHelper
{
  public static final String DATABASE_NAME = "gdt_analysis";
  private static final int DATABASE_VERSION = 1;
  private static final String TAG = "AdAnalysisSQLiteHelper";
  private static volatile c instance;
  
  private c(Context paramContext)
  {
    super(paramContext, getFilename(paramContext), null, 1);
    initialize();
  }
  
  private static String getCreateTableSQL()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (%s %s, %s %s, %s %s, %s %s, %s %s)", new Object[] { "gdt_analysis_table_v4", "_id", "INTEGER PRIMARY KEY AUTOINCREMENT", "uuid", "TEXT NOT NULL UNIQUE", "time_millis", "INTEGER NOT NULL", "strategy", "INTEGER NOT NULL", "event", "TEXT NOT NULL" });
  }
  
  private static String getDropTableSQL(String paramString)
  {
    return String.format("DROP TABLE IF EXISTS %s", new Object[] { paramString });
  }
  
  private static String getFilename(Context paramContext)
  {
    paramContext = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      paramContext = "";
    } else {
      paramContext = paramContext.replaceAll("(\\.|:)", "_");
    }
    if (!TextUtils.isEmpty(paramContext)) {
      return String.format("%s_%s.db", new Object[] { "gdt_analysis", paramContext });
    }
    return String.format("%s.db", new Object[] { "gdt_analysis" });
  }
  
  public static c getInstance(Context paramContext)
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new c(paramContext);
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void initialize()
  {
    AdLog.i("AdAnalysisSQLiteHelper", "initialize");
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    if ((localSQLiteDatabase != null) && (a.OLD_TABLE_NAMES != null) && (a.OLD_TABLE_NAMES.length >= 0)) {
      try
      {
        String[] arrayOfString = a.OLD_TABLE_NAMES;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localSQLiteDatabase.execSQL(getDropTableSQL(arrayOfString[i]));
          i += 1;
        }
        localSQLiteDatabase.execSQL(getCreateTableSQL());
        return;
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdAnalysisSQLiteHelper", "throwable", localThrowable);
        return;
      }
    }
    AdLog.e("AdAnalysisSQLiteHelper", "initialize error");
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AdLog.i("AdAnalysisSQLiteHelper", "onCreate");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AdLog.i("AdAnalysisSQLiteHelper", "onUpgrade");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.sqlite.c
 * JD-Core Version:    0.7.0.1
 */