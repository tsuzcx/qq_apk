package com.tencent.biz.pubaccount.readinjoy;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.tencent.mobileqq.kandian.biz.common.constant.ReadInJoyDataProviderConstants;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReadInJoyDataProvider
  extends AppContentProvider
{
  public static final Uri a;
  public static final Uri b;
  public static final Uri c;
  public static final Uri d;
  private UriMatcher e;
  private ReadInJoyDataProvider.ReadInJoyDBHelper f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyDataProviderConstants.a);
    localStringBuilder.append("subscribe_msg_records");
    a = Uri.parse(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyDataProviderConstants.a);
    localStringBuilder.append("notify_msg_records");
    b = Uri.parse(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyDataProviderConstants.a);
    localStringBuilder.append("feeds_msg_records");
    c = Uri.parse(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyDataProviderConstants.a);
    localStringBuilder.append("recent_data");
    d = Uri.parse(localStringBuilder.toString());
  }
  
  private SQLiteDatabase a(Uri paramUri, boolean paramBoolean)
  {
    Object localObject2 = paramUri.getQueryParameter("uin");
    if (localObject2 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDBHelper, uin = null, uri=");
        ((StringBuilder)localObject1).append(paramUri.getPath());
        QLog.d("ReadInJoyDataProvider", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    Object localObject1 = getRuntime((String)localObject2);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDBHelper, ar is null, uri=");
        ((StringBuilder)localObject1).append(paramUri.getPath());
        QLog.d("ReadInJoyDataProvider", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    String str = ((AppRuntime)localObject1).getAccount();
    if (!str.equals(localObject2))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getDBHelper, uin not equal, uri=");
        ((StringBuilder)localObject2).append(paramUri.getPath());
        ((StringBuilder)localObject2).append(", current account=");
        ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
        QLog.d("ReadInJoyDataProvider", 2, ((StringBuilder)localObject2).toString());
      }
      return null;
    }
    paramUri = this.f;
    if ((paramUri == null) || (!paramUri.a.equals(str)))
    {
      this.f = new ReadInJoyDataProvider.ReadInJoyDBHelper(this, ((AppRuntime)localObject1).getApplication().getApplicationContext(), (String)localObject2);
      this.f.a = str;
    }
    if (paramBoolean) {
      return this.f.getReadableDatabase();
    }
    return this.f.getWritableDatabase();
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    QLog.isColorLevel();
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    switch (this.e.match(paramUri))
    {
    case 2002: 
    default: 
      return 0;
    case 2004: 
      return localSQLiteDatabase.delete("common_records", paramString, paramArrayOfString);
    case 2003: 
      return localSQLiteDatabase.delete("feeds_msg_records", paramString, paramArrayOfString);
    case 2001: 
      localSQLiteDatabase.execSQL("DELETE from notify_msg_records;");
      return 0;
    }
    return localSQLiteDatabase.delete("subscribe_msg_records", paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    QLog.isColorLevel();
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return null;
    }
    long l;
    switch (this.e.match(paramUri))
    {
    case 2002: 
    default: 
      l = -1L;
      break;
    case 2004: 
      l = localSQLiteDatabase.insert("common_records", null, paramContentValues);
      break;
    case 2003: 
      l = localSQLiteDatabase.insert("feeds_msg_records", null, paramContentValues);
      break;
    case 2001: 
      l = localSQLiteDatabase.insert("notify_msg_records", null, paramContentValues);
      break;
    case 2000: 
      l = localSQLiteDatabase.insert("subscribe_msg_records", null, paramContentValues);
    }
    if (l == -1L) {
      return null;
    }
    return paramUri;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.e = new UriMatcher(-1);
    this.e.addURI("qq.readinjoy", "subscribe_msg_records", 2000);
    this.e.addURI("qq.readinjoy", "notify_msg_records", 2001);
    this.e.addURI("qq.readinjoy", "recent_data", 2002);
    this.e.addURI("qq.readinjoy", "feeds_msg_records", 2003);
    this.e.addURI("qq.readinjoy", "common_records", 2004);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    QLog.isColorLevel();
    SQLiteDatabase localSQLiteDatabase = a(paramUri, true);
    if (localSQLiteDatabase == null) {
      return null;
    }
    switch (this.e.match(paramUri))
    {
    case 2002: 
    default: 
      return null;
    case 2004: 
      return localSQLiteDatabase.query("common_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
    case 2003: 
      return localSQLiteDatabase.query("feeds_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
    case 2001: 
      return localSQLiteDatabase.query("notify_msg_records", null, null, null, null, null, "msgID DESC", null);
    }
    return localSQLiteDatabase.query("subscribe_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, paramUri.getQueryParameter("limit"));
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    QLog.isColorLevel();
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    int i = this.e.match(paramUri);
    if (i != 2003)
    {
      if (i != 2004) {
        return 0;
      }
      return localSQLiteDatabase.update("common_records", paramContentValues, paramString, paramArrayOfString);
    }
    return localSQLiteDatabase.update("feeds_msg_records", paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDataProvider
 * JD-Core Version:    0.7.0.1
 */