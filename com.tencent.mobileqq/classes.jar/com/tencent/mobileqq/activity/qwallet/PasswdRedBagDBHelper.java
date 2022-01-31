package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;

public class PasswdRedBagDBHelper
  extends SQLiteOpenHelper
{
  public PasswdRedBagDBHelper(Context paramContext, String paramString)
  {
    super(paramContext, "passwd_red_bag_" + paramString + ".db", null, 3);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagDBHelper", 2, " onCreate execSQL sqlRedBags=" + "CREATE TABLE IF NOT EXISTS red_bags (redbag_id VARCHAR PRIMARY KEY, redbag_index VARCHAR, uint64_creator_uin VARCHAR, expire_time INTEGER, password VARCHAR, is_open INTEGER, is_finish INTEGER, is_overdue INTEGER, redbag_type INTEGER);" + " sqlRedBagRelation=" + "CREATE TABLE IF NOT EXISTS red_bag_relations (code VARCHAR, source VARCHAR, redbag_id VARCHAR, authkey VARCHAR );" + " sqlUpdateTimes=" + "CREATE TABLE IF NOT EXISTS update_times (code INTEGER, source INTEGER, last_update_time INTEGER, PRIMARY KEY(code,source));");
      }
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bags (redbag_id VARCHAR PRIMARY KEY, redbag_index VARCHAR, uint64_creator_uin VARCHAR, expire_time INTEGER, password VARCHAR, is_open INTEGER, is_finish INTEGER, is_overdue INTEGER, redbag_type INTEGER);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bag_relations (code VARCHAR, source VARCHAR, redbag_id VARCHAR, authkey VARCHAR );");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_times (code INTEGER, source INTEGER, last_update_time INTEGER, PRIMARY KEY(code,source));");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PasswdRedBagDBHelper", 2, " onCreate execSQL exception", paramSQLiteDatabase);
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN redbag_index VARCHAR ");
        }
        catch (Exception localException1) {}
        if (QLog.isColorLevel())
        {
          QLog.e("PasswdRedBagDBHelper", 2, " exception occurred when " + "ALTER TABLE red_bags ADD COLUMN redbag_index VARCHAR ", localException1);
          continue;
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN redbag_type INTEGER DEFAULT 0");
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel()) {
            QLog.e("PasswdRedBagDBHelper", 2, " exception occurred when " + "ALTER TABLE red_bags ADD COLUMN redbag_type INTEGER DEFAULT 0", localException2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagDBHelper
 * JD-Core Version:    0.7.0.1
 */