package com.tencent.common.config.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

public class QZConfigSqliteManager
  implements QZoneConfigConst
{
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private QZoneConfigSQLiteHelper jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper;
  private SQLiteDatabase b;
  
  public QZConfigSqliteManager(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper = new QZoneConfigSQLiteHelper(paramContext, "config_db", null, 12);
  }
  
  public int a()
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_cookie", null, null);
      a();
    }
    return i;
  }
  
  /* Error */
  public int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokevirtual 29	com/tencent/common/config/provider/QZConfigSqliteManager:a	()Z
    //   6: ifeq +123 -> 129
    //   9: aload_2
    //   10: arraylength
    //   11: istore_3
    //   12: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   15: lstore 6
    //   17: aload_0
    //   18: getfield 31	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   21: invokevirtual 53	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   24: aload_2
    //   25: arraylength
    //   26: istore 5
    //   28: iconst_0
    //   29: istore 4
    //   31: iload 4
    //   33: iload 5
    //   35: if_icmpge +109 -> 144
    //   38: aload_2
    //   39: iload 4
    //   41: aaload
    //   42: astore 10
    //   44: aload_0
    //   45: getfield 31	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   48: ldc 55
    //   50: ldc 57
    //   52: aload 10
    //   54: invokevirtual 61	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   57: lconst_0
    //   58: lcmp
    //   59: ifgt +72 -> 131
    //   62: new 44	android/database/SQLException
    //   65: dup
    //   66: new 63	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   73: ldc 66
    //   75: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 80	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_1
    //   90: ldc 82
    //   92: iconst_1
    //   93: new 63	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   100: ldc 84
    //   102: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 87	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   109: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: getfield 31	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   122: invokevirtual 96	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   125: aload_0
    //   126: invokevirtual 41	com/tencent/common/config/provider/QZConfigSqliteManager:a	()V
    //   129: iload_3
    //   130: ireturn
    //   131: iload 4
    //   133: iconst_1
    //   134: iadd
    //   135: istore 4
    //   137: iload_3
    //   138: iconst_1
    //   139: iadd
    //   140: istore_3
    //   141: goto -110 -> 31
    //   144: aload_0
    //   145: getfield 31	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   148: invokevirtual 99	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   151: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   154: lstore 8
    //   156: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +50 -> 209
    //   162: ldc 82
    //   164: iconst_2
    //   165: new 63	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   172: ldc 104
    //   174: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: ldc 106
    //   183: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: lload 8
    //   188: lload 6
    //   190: lsub
    //   191: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   194: ldc 111
    //   196: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload_3
    //   200: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_0
    //   210: getfield 31	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   213: invokevirtual 96	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   216: goto -91 -> 125
    //   219: astore_1
    //   220: aload_0
    //   221: getfield 31	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   224: invokevirtual 96	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: goto -140 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	QZConfigSqliteManager
    //   0	233	1	paramUri	Uri
    //   0	233	2	paramArrayOfContentValues	ContentValues[]
    //   1	199	3	i	int
    //   29	107	4	j	int
    //   26	10	5	k	int
    //   15	174	6	l1	long
    //   154	33	8	l2	long
    //   42	11	10	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   44	89	89	android/database/SQLException
    //   144	209	89	android/database/SQLException
    //   12	28	219	finally
    //   44	89	219	finally
    //   90	118	219	finally
    //   144	209	219	finally
    //   12	28	229	android/database/SQLException
  }
  
  public int a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_configs", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor a(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_cookie", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_navigator_bar", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_configs", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_a_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public void a() {}
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper.getWritableDatabase();
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  public int b()
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_check_time", null, null);
      a();
    }
    return i;
  }
  
  int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    k = 0;
    i = 0;
    j = 0;
    if (a()) {
      i = k;
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
      i = k;
      m = paramArrayOfContentValues.length;
      k = 0;
    }
    catch (SQLException paramUri)
    {
      for (;;)
      {
        int m;
        ContentValues localContentValues;
        QLog.e("QZConfigSqliteManager", 1, "There was a problem with the bulk insert: ", paramUri);
        return i;
        k += 1;
        j += 1;
      }
      i = j;
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
      return j;
    }
    finally
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
      a();
    }
    if (k < m)
    {
      localContentValues = paramArrayOfContentValues[k];
      i = j;
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("table_qz_unread", "", localContentValues) <= 0L)
      {
        i = j;
        throw new SQLException("failed to insert row into " + paramUri);
      }
    }
  }
  
  public int b(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_isp_config", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor b(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_check_time", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_configs", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_navigator_bar", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(g, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper.getReadableDatabase();
      if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  public int c()
  {
    int i = 0;
    if (a()) {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_update", null, null);
    }
    return i;
  }
  
  public int c(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_navigator_bar", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor c(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_update", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_isp_config", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_isp_config", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(e, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public int d()
  {
    return 0 + a() + a(null, null) + c() + b() + b(null, null) + c(null, null);
  }
  
  int d(String paramString, String[] paramArrayOfString)
  {
    if (a()) {
      return this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("table_qz_unread", paramString, paramArrayOfString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite,failed deleteQzoneUnread"));
    }
    return 0;
  }
  
  Cursor d(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Object localObject = null;
    if (b())
    {
      paramArrayOfString1 = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("table_qz_unread", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    do
    {
      return paramArrayOfString1;
      paramArrayOfString1 = localObject;
    } while (!QLog.isColorLevel());
    QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite"));
    return null;
  }
  
  public Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_cookie", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_b_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_check_time", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(f, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_update", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(c, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("table_qz_unread", "", paramContentValues);
      a();
      if (l > 0L) {
        return ContentUris.withAppendedId(paramUri, l);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigSqliteManager", 2, "", new SQLException("failed to insert row into " + paramUri));
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite,failed to insert row into " + paramUri));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigSqliteManager
 * JD-Core Version:    0.7.0.1
 */