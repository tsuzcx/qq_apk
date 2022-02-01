package com.tencent.biz.pubaccount.readinjoy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.TableBuilder;

public class ReadInJoyDataProvider$ReadInJoyDBHelper
  extends SQLiteOpenHelper
{
  public String a;
  
  public ReadInJoyDataProvider$ReadInJoyDBHelper(ReadInJoyDataProvider paramReadInJoyDataProvider, Context paramContext, String paramString)
  {
    super(paramContext, paramReadInJoyDataProvider.toString(), null, 84);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    StringBuilder localStringBuilder;
    if ((!paramString.equals("subscribe_msg_records")) && (!paramString.equals("notify_msg_records")))
    {
      if (paramString.equals("feeds_msg_records"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CREATE TABLE IF NOT EXISTS ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("(");
        localStringBuilder.append("_id");
        localStringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        localStringBuilder.append("pushTime");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("notifyType");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("feedsOwner");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("feedsID");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("feedsSubject");
        localStringBuilder.append(" TEXT DEFAULT '', ");
        localStringBuilder.append("deleteUin");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("publishFail");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("likeUin");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("commentUin");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("commentID");
        localStringBuilder.append(" VARCHAR(32) DEFAULT '', ");
        localStringBuilder.append("replyUin");
        localStringBuilder.append(" INTEGER NOT NULL, ");
        localStringBuilder.append("replyID");
        localStringBuilder.append(" VARCHAR(32) DEFAULT '', ");
        localStringBuilder.append("commentInfo");
        localStringBuilder.append(" TEXT DEFAULT '', ");
        localStringBuilder.append("isDelete");
        localStringBuilder.append(" INTEGER DEFAULT 0, ");
        localStringBuilder.append("processSeq");
        localStringBuilder.append(" INTEGER DEFAULT 0, ");
        localStringBuilder.append("receiveTime");
        localStringBuilder.append(" INTEGER NOT NULL);");
        paramSQLiteDatabase.execSQL(localStringBuilder.toString());
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CREATE TABLE IF NOT EXISTS ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append("_id");
      localStringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
      localStringBuilder.append("msgID");
      localStringBuilder.append(" INTEGER UNIQUE NOT NULL, ");
      localStringBuilder.append("subscribeID");
      localStringBuilder.append(" TEXT NOT NULL, ");
      localStringBuilder.append("msgURL");
      localStringBuilder.append(" TEXT NOT NULL, ");
      localStringBuilder.append("msgContent");
      localStringBuilder.append(" TEXT NOT NULL, ");
      localStringBuilder.append("msgTime");
      localStringBuilder.append(" INTEGER NOT NULL, ");
      localStringBuilder.append("bindUin");
      localStringBuilder.append(" INTEGER NOT NULL);");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if ("common_records".equalsIgnoreCase(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CREATE TABLE IF NOT EXISTS ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append("_id");
      localStringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
      localStringBuilder.append("common_version");
      localStringBuilder.append(" INTEGER NOT NULL, ");
      localStringBuilder.append("common_key");
      localStringBuilder.append(" TEXT DEFAULT '', ");
      localStringBuilder.append("common_content");
      localStringBuilder.append(" TEXT DEFAULT '');");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase, "subscribe_msg_records");
    a(paramSQLiteDatabase, "notify_msg_records");
    a(paramSQLiteDatabase, "feeds_msg_records");
    b(paramSQLiteDatabase, "common_records");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 80)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("subscribe_msg_records"));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("notify_msg_records"));
      a(paramSQLiteDatabase, "subscribe_msg_records");
      a(paramSQLiteDatabase, "notify_msg_records");
    }
    if (paramInt1 < 81)
    {
      a(paramSQLiteDatabase, "feeds_msg_records");
    }
    else
    {
      if (paramInt1 < 82) {
        paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "isDelete", "INTEGER DEFAULT 0" }));
      }
      if (paramInt1 < 83) {
        paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "processSeq", "INTEGER DEFAULT 0" }));
      }
    }
    if (paramInt1 < 84) {
      b(paramSQLiteDatabase, "common_records");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDataProvider.ReadInJoyDBHelper
 * JD-Core Version:    0.7.0.1
 */