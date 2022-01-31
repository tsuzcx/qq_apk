package com.tencent.biz.pubaccount.persistence.manager;

import alxk;
import android.database.Cursor;
import awbw;
import awcj;
import awcw;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicAccountEntityManagerFactory
  extends QQEntityManagerFactory
{
  public PublicAccountEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.TAG = "PublicAccountEntityManagerFactory";
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.b(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.equals(PAAdPreloadTask.TABLE_NAME)) {
                continue;
              }
              localObject = PAAdPreloadTask.class;
              awcj.a(localArrayList, str, localCursor2, (Class)localObject);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Object localObject;
              continue;
            }
            localCursor2.close();
            break;
            localObject = Class.forName(paramString + "." + str);
          }
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
  }
  
  public alxk build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "public_account_database_" + paramString + ".db", null, 1);
      this.dbHelper = new alxk(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(awcw.a(new PAAdPreloadTask()));
  }
  
  public String getPackageName()
  {
    return "com.tencent.biz.pubaccount.persistence.manager";
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QLog.i(this.TAG, 1, "[DB]|upgrade. oldVer=" + paramInt1 + ", newVer=" + paramInt2);
    a(getPackageName(), paramSQLiteDatabase);
  }
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      awbw localawbw = createEntityManager();
      PublicAccountEntityManagerFactory.VerifyEntity localVerifyEntity = (PublicAccountEntityManagerFactory.VerifyEntity)localawbw.a(PublicAccountEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "public_account_database_verify_entity" });
      if (localVerifyEntity == null)
      {
        localVerifyEntity = new PublicAccountEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localawbw.b(localVerifyEntity);
        return true;
      }
      if ((!localVerifyEntity.flags.equals("public_account_database_verify_entity")) || (!localVerifyEntity.name.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
        localVerifyEntity = new PublicAccountEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localawbw.b(localVerifyEntity);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */