package com.tencent.biz.pubaccount.persistence.manager;

import android.database.Cursor;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicAccountEntityManagerFactory
  extends EntityManagerFactory
{
  public PublicAccountEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.tag = "PublicAccountEntityManagerFactory";
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.decode(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {}
        try
        {
          Object localObject;
          if (str.equals(PAAdPreloadTask.TABLE_NAME))
          {
            localObject = PAAdPreloadTask.class;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(".");
            ((StringBuilder)localObject).append(str);
            localObject = Class.forName(((StringBuilder)localObject).toString());
          }
          OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, (Class)localObject);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          label132:
          break label132;
        }
        localCursor2.close();
      }
      localCursor1.close();
    }
    else
    {
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          paramSQLiteDatabase.execSQL((String)paramString.next());
        }
        paramSQLiteDatabase.setTransactionSuccessful();
        paramSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        for (;;)
        {
          throw paramString;
        }
      }
    }
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("public_account_database_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.a(this, localStringBuilder.toString(), 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PAAdPreloadTask()));
  }
  
  protected String getPackageName()
  {
    return "com.tencent.biz.pubaccount.persistence.manager";
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String str = this.tag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DB]|upgrade. oldVer=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", newVer=");
    localStringBuilder.append(paramInt2);
    QLog.i(str, 1, localStringBuilder.toString());
    a(getPackageName(), paramSQLiteDatabase);
  }
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      EntityManager localEntityManager = createEntityManager();
      PublicAccountEntityManagerFactory.VerifyEntity localVerifyEntity = (PublicAccountEntityManagerFactory.VerifyEntity)localEntityManager.find(PublicAccountEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "public_account_database_verify_entity" });
      if (localVerifyEntity == null)
      {
        localVerifyEntity = new PublicAccountEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localEntityManager.persistOrReplace(localVerifyEntity);
      }
      else if ((!localVerifyEntity.flags.equals("public_account_database_verify_entity")) || (!localVerifyEntity.name.equals(this.name)))
      {
        this.mInnerDbHelper.a();
        localVerifyEntity = new PublicAccountEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localEntityManager.persistOrReplace(localVerifyEntity);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */