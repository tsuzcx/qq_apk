package com.tencent.biz.pubaccount.readinjoy.engine;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.tencent.biz.pubaccount.readinjoy.reward.RedPacketTaskData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleExposureInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyEntityManagerFactory
  extends EntityManagerFactory
{
  public ReadInJoyEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.TAG = "ReadInJoy.MessageNode.EntityManagerFactory";
  }
  
  private void a(com.tencent.mobileqq.app.SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = a(paramSQLiteDatabase);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ("android_metadata".equals(str)) {}
        for (;;)
        {
          i += 1;
          break;
          if (!"sqlite_sequence".equals(str)) {
            try
            {
              paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str));
            }
            catch (SQLiteException localSQLiteException)
            {
              QLog.e(this.TAG, 1, "[DB] dropAllTable " + str, localSQLiteException);
              SQLiteOpenHelper.throwDebugException(localSQLiteException);
            }
          }
        }
      }
    }
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
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.equals(ArticleInfo.TABLE_NAME)) {
                continue;
              }
              localObject = ArticleInfo.class;
              OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, (Class)localObject);
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
            } else if (str.equals(WeiShiVideoArticleInfo.TABLE_NAME)) {
              localObject = WeiShiVideoArticleInfo.class;
            } else if (str.equals(ArticleExposureInfo.TABLE_NAME)) {
              localObject = ArticleExposureInfo.class;
            } else if (str.equals(RedPacketTaskData.TABLE_NAME)) {
              localObject = RedPacketTaskData.class;
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
  
  /* Error */
  private String[] a(com.tencent.mobileqq.app.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ldc 76
    //   5: aconst_null
    //   6: invokevirtual 188	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +177 -> 190
    //   16: aload 4
    //   18: astore 5
    //   20: aload 4
    //   22: invokeinterface 191 1 0
    //   27: ifeq +163 -> 190
    //   30: aload 4
    //   32: astore 5
    //   34: aload 4
    //   36: invokeinterface 195 1 0
    //   41: anewarray 26	java/lang/String
    //   44: astore_1
    //   45: aload 4
    //   47: astore 5
    //   49: aload_1
    //   50: iload_2
    //   51: aload 4
    //   53: iconst_0
    //   54: invokeinterface 95 2 0
    //   59: invokestatic 100	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   62: aastore
    //   63: aload 4
    //   65: astore 5
    //   67: aload 4
    //   69: invokeinterface 91 1 0
    //   74: istore_3
    //   75: iload_3
    //   76: ifne +107 -> 183
    //   79: aload_1
    //   80: astore 5
    //   82: aload 4
    //   84: ifnull +13 -> 97
    //   87: aload 4
    //   89: invokeinterface 118 1 0
    //   94: aload_1
    //   95: astore 5
    //   97: aload 5
    //   99: areturn
    //   100: astore 6
    //   102: aconst_null
    //   103: astore 4
    //   105: aconst_null
    //   106: astore_1
    //   107: aload 4
    //   109: astore 5
    //   111: aload_0
    //   112: getfield 14	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyEntityManagerFactory:TAG	Ljava/lang/String;
    //   115: iconst_1
    //   116: ldc 197
    //   118: aload 6
    //   120: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload 4
    //   125: astore 5
    //   127: aload 6
    //   129: invokestatic 71	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   132: aload_1
    //   133: astore 5
    //   135: aload 4
    //   137: ifnull -40 -> 97
    //   140: aload 4
    //   142: invokeinterface 118 1 0
    //   147: aload_1
    //   148: areturn
    //   149: astore_1
    //   150: aconst_null
    //   151: astore 5
    //   153: aload 5
    //   155: ifnull +10 -> 165
    //   158: aload 5
    //   160: invokeinterface 118 1 0
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: goto -15 -> 153
    //   171: astore 6
    //   173: aconst_null
    //   174: astore_1
    //   175: goto -68 -> 107
    //   178: astore 6
    //   180: goto -73 -> 107
    //   183: iload_2
    //   184: iconst_1
    //   185: iadd
    //   186: istore_2
    //   187: goto -142 -> 45
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -113 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	ReadInJoyEntityManagerFactory
    //   0	195	1	paramSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   1	186	2	i	int
    //   74	2	3	bool	boolean
    //   9	132	4	localCursor	Cursor
    //   18	141	5	localObject	Object
    //   100	28	6	localException1	Exception
    //   171	1	6	localException2	Exception
    //   178	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	100	java/lang/Exception
    //   2	11	149	finally
    //   20	30	167	finally
    //   34	45	167	finally
    //   49	63	167	finally
    //   67	75	167	finally
    //   111	123	167	finally
    //   127	132	167	finally
    //   20	30	171	java/lang/Exception
    //   34	45	171	java/lang/Exception
    //   49	63	178	java/lang/Exception
    //   67	75	178	java/lang/Exception
  }
  
  public void a()
  {
    if ((this.dbHelper == null) || (this.mInnerDbHelper == null))
    {
      QLog.d(this.TAG, 2, "removeDatabases: failed. please call build first.");
      return;
    }
    a(this.dbHelper.getWritableDatabase());
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, "readinjoy_message_node_" + paramString + ".db", null, 105);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArticleInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArticleReadInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AdvertisementInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new WeiShiVideoArticleInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArticleExposureInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RedPacketTaskData()));
    paramSQLiteDatabase.execSQL("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on " + ArticleInfo.TABLE_NAME + " for each row begin  delete from " + ArticleReadInfo.TABLE_NAME + " where mArticleID = old.mArticleID; end ");
  }
  
  public String getPackageName()
  {
    return "com.tencent.biz.pubaccount.readinjoy.struct";
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
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
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArticleReadInfo()));
    }
    paramSQLiteDatabase.execSQL("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on " + ArticleInfo.TABLE_NAME + " for each row begin  delete from " + ArticleReadInfo.TABLE_NAME + " where mArticleID = old.mArticleID; end ");
  }
  
  public boolean verifyAuthentication()
  {
    try
    {
      if (this.name.matches("^[0-9]*$"))
      {
        EntityManager localEntityManager = createEntityManager();
        ReadInJoyEntityManagerFactory.VerifyEntity localVerifyEntity = (ReadInJoyEntityManagerFactory.VerifyEntity)localEntityManager.find(ReadInJoyEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "readinjoy_message_node_verify_entity" });
        if (localVerifyEntity == null)
        {
          localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
          localVerifyEntity.name = this.name;
          localEntityManager.persistOrReplace(localVerifyEntity);
          return true;
        }
        if ((!localVerifyEntity.flags.equals("readinjoy_message_node_verify_entity")) || (!localVerifyEntity.name.equals(this.name)))
        {
          this.mInnerDbHelper.dropAllTable();
          localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
          localVerifyEntity.name = this.name;
          localEntityManager.persistOrReplace(localVerifyEntity);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.TAG, 1, localException, new Object[0]);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */