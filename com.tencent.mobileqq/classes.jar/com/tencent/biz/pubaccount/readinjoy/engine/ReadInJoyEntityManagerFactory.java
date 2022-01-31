package com.tencent.biz.pubaccount.readinjoy.engine;

import android.database.Cursor;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyEntityManagerFactory
  extends QQEntityManagerFactory
{
  public ReadInJoyEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.TAG = "ReadInJoy.MessageNode.EntityManagerFactory";
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
              if (!str.equals(ArticleInfo.TABLE_NAME)) {
                continue;
              }
              localObject = ArticleInfo.class;
              OGEntityManager.a(localArrayList, str, localCursor2, (Class)localObject);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Object localObject;
              continue;
            }
            localCursor2.close();
            break;
            if (str.equals(ArticleReadInfo.TABLE_NAME)) {
              localObject = ArticleReadInfo.class;
            } else if (str.equals(ChannelInfo.TABLE_NAME)) {
              localObject = ChannelInfo.class;
            } else if (str.equals(ChannelTopCookie.TABLE_NAME)) {
              localObject = ChannelTopCookie.class;
            } else if (str.equals(InterestLabelInfo.TABLE_NAME)) {
              localObject = InterestLabelInfo.class;
            } else if (str.equals(AdvertisementInfo.TABLE_NAME)) {
              localObject = AdvertisementInfo.class;
            } else if (str.equals(ChannelCoverInfo.TABLE_NAME)) {
              localObject = ChannelCoverInfo.class;
            } else {
              localObject = Class.forName(paramString + "." + str);
            }
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
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "readinjoy_message_node_" + paramString + ".db", null, 52);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ArticleInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ArticleReadInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new AdvertisementInfo()));
    paramSQLiteDatabase.execSQL("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on " + ArticleInfo.TABLE_NAME + " for each row begin  delete from " + ArticleReadInfo.TABLE_NAME + " where mArticleID = old.mArticleID; end ");
  }
  
  protected String getPackageName()
  {
    return "com.tencent.biz.pubaccount.readinjoy.struct";
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = 1;
    QLog.i(this.TAG, 1, "[DB]|upgrade. oldver=" + paramInt1 + ",newver=" + paramInt2);
    a(getPackageName(), paramSQLiteDatabase);
    try
    {
      paramSQLiteDatabase.execSQL("select * from " + ArticleReadInfo.TABLE_NAME + " limit 1 ");
      paramInt1 = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramInt1 = 0;
      }
    }
    if (paramInt1 == 0) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ArticleReadInfo()));
    }
    paramSQLiteDatabase.execSQL("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on " + ArticleInfo.TABLE_NAME + " for each row begin  delete from " + ArticleReadInfo.TABLE_NAME + " where mArticleID = old.mArticleID; end ");
  }
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      EntityManager localEntityManager = createEntityManager();
      ReadInJoyEntityManagerFactory.VerifyEntity localVerifyEntity = (ReadInJoyEntityManagerFactory.VerifyEntity)localEntityManager.a(ReadInJoyEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "readinjoy_message_node_verify_entity" });
      if (localVerifyEntity == null)
      {
        localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localEntityManager.b(localVerifyEntity);
        return true;
      }
      if ((!localVerifyEntity.flags.equals("readinjoy_message_node_verify_entity")) || (!localVerifyEntity.name.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
        localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localEntityManager.b(localVerifyEntity);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */