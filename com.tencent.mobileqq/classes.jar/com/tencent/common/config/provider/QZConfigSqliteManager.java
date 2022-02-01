package com.tencent.common.config.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class QZConfigSqliteManager
  implements QZoneConfigConst
{
  public String a;
  private QZoneConfigSQLiteHelper j;
  private SQLiteDatabase k;
  private SQLiteDatabase l;
  
  public QZConfigSqliteManager(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a = paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_db");
    localStringBuilder.append(paramString);
    this.j = new QZoneConfigSQLiteHelper(paramContext, localStringBuilder.toString(), null, 17);
  }
  
  /* Error */
  public int a(Uri paramUri, String paramString, ContentValues[] paramArrayOfContentValues)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 53	com/tencent/common/config/provider/QZConfigSqliteManager:a	()Z
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 6
    //   9: iload 8
    //   11: ifeq +334 -> 345
    //   14: aload_3
    //   15: arraylength
    //   16: istore 4
    //   18: iload 4
    //   20: istore 5
    //   22: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   25: lstore 9
    //   27: iload 4
    //   29: istore 5
    //   31: aload_0
    //   32: getfield 61	com/tencent/common/config/provider/QZConfigSqliteManager:k	Landroid/database/sqlite/SQLiteDatabase;
    //   35: invokevirtual 66	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   38: iload 4
    //   40: istore 5
    //   42: aload_3
    //   43: arraylength
    //   44: istore 7
    //   46: iload 6
    //   48: iload 7
    //   50: if_icmpge +94 -> 144
    //   53: aload_3
    //   54: iload 6
    //   56: aaload
    //   57: astore 13
    //   59: iload 4
    //   61: istore 5
    //   63: aload_0
    //   64: getfield 61	com/tencent/common/config/provider/QZConfigSqliteManager:k	Landroid/database/sqlite/SQLiteDatabase;
    //   67: aload_2
    //   68: ldc 68
    //   70: aload 13
    //   72: invokevirtual 72	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   75: lconst_0
    //   76: lcmp
    //   77: ifle +18 -> 95
    //   80: iload 4
    //   82: iconst_1
    //   83: iadd
    //   84: istore 4
    //   86: iload 6
    //   88: iconst_1
    //   89: iadd
    //   90: istore 6
    //   92: goto -46 -> 46
    //   95: iload 4
    //   97: istore 5
    //   99: new 28	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   106: astore_2
    //   107: iload 4
    //   109: istore 5
    //   111: aload_2
    //   112: ldc 74
    //   114: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: iload 4
    //   120: istore 5
    //   122: aload_2
    //   123: aload_1
    //   124: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: iload 4
    //   130: istore 5
    //   132: new 50	android/database/SQLException
    //   135: dup
    //   136: aload_2
    //   137: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 80	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   143: athrow
    //   144: iload 4
    //   146: istore 5
    //   148: aload_0
    //   149: getfield 61	com/tencent/common/config/provider/QZConfigSqliteManager:k	Landroid/database/sqlite/SQLiteDatabase;
    //   152: invokevirtual 83	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   155: iload 4
    //   157: istore 5
    //   159: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   162: lstore 11
    //   164: iload 4
    //   166: istore 5
    //   168: iload 4
    //   170: istore 6
    //   172: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +147 -> 322
    //   178: iload 4
    //   180: istore 5
    //   182: new 28	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   189: astore_2
    //   190: iload 4
    //   192: istore 5
    //   194: aload_2
    //   195: ldc 90
    //   197: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: iload 4
    //   203: istore 5
    //   205: aload_2
    //   206: aload_1
    //   207: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: iload 4
    //   213: istore 5
    //   215: aload_2
    //   216: ldc 92
    //   218: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: iload 4
    //   224: istore 5
    //   226: aload_2
    //   227: lload 11
    //   229: lload 9
    //   231: lsub
    //   232: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: iload 4
    //   238: istore 5
    //   240: aload_2
    //   241: ldc 97
    //   243: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: iload 4
    //   249: istore 5
    //   251: aload_2
    //   252: iload 4
    //   254: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: iload 4
    //   260: istore 5
    //   262: ldc 102
    //   264: iconst_2
    //   265: aload_2
    //   266: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: iload 4
    //   274: istore 6
    //   276: goto +46 -> 322
    //   279: astore_1
    //   280: goto +56 -> 336
    //   283: astore_1
    //   284: new 28	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   291: astore_2
    //   292: aload_2
    //   293: ldc 108
    //   295: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_2
    //   300: aload_1
    //   301: invokevirtual 111	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   304: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc 102
    //   310: iconst_1
    //   311: aload_2
    //   312: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iload 5
    //   320: istore 6
    //   322: aload_0
    //   323: getfield 61	com/tencent/common/config/provider/QZConfigSqliteManager:k	Landroid/database/sqlite/SQLiteDatabase;
    //   326: invokevirtual 117	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   329: aload_0
    //   330: invokevirtual 120	com/tencent/common/config/provider/QZConfigSqliteManager:c	()V
    //   333: iload 6
    //   335: ireturn
    //   336: aload_0
    //   337: getfield 61	com/tencent/common/config/provider/QZConfigSqliteManager:k	Landroid/database/sqlite/SQLiteDatabase;
    //   340: invokevirtual 117	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   343: aload_1
    //   344: athrow
    //   345: iconst_0
    //   346: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	QZConfigSqliteManager
    //   0	347	1	paramUri	Uri
    //   0	347	2	paramString	String
    //   0	347	3	paramArrayOfContentValues	ContentValues[]
    //   16	257	4	i	int
    //   20	299	5	m	int
    //   7	327	6	n	int
    //   44	7	7	i1	int
    //   4	6	8	bool	boolean
    //   25	205	9	l1	long
    //   162	66	11	l2	long
    //   57	14	13	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   22	27	279	finally
    //   31	38	279	finally
    //   42	46	279	finally
    //   63	80	279	finally
    //   99	107	279	finally
    //   111	118	279	finally
    //   122	128	279	finally
    //   132	144	279	finally
    //   148	155	279	finally
    //   159	164	279	finally
    //   172	178	279	finally
    //   182	190	279	finally
    //   194	201	279	finally
    //   205	211	279	finally
    //   215	222	279	finally
    //   226	236	279	finally
    //   240	247	279	finally
    //   251	258	279	finally
    //   262	272	279	finally
    //   284	318	279	finally
    //   22	27	283	android/database/SQLException
    //   31	38	283	android/database/SQLException
    //   42	46	283	android/database/SQLException
    //   63	80	283	android/database/SQLException
    //   99	107	283	android/database/SQLException
    //   111	118	283	android/database/SQLException
    //   122	128	283	android/database/SQLException
    //   132	144	283	android/database/SQLException
    //   148	155	283	android/database/SQLException
    //   159	164	283	android/database/SQLException
    //   172	178	283	android/database/SQLException
    //   182	190	283	android/database/SQLException
    //   194	201	283	android/database/SQLException
    //   205	211	283	android/database/SQLException
    //   215	222	283	android/database/SQLException
    //   226	236	283	android/database/SQLException
    //   240	247	283	android/database/SQLException
    //   251	258	283	android/database/SQLException
    //   262	272	283	android/database/SQLException
  }
  
  public int a(String paramString, String[] paramArrayOfString)
  {
    if (a())
    {
      int i = this.k.delete("qz_configs", paramString, paramArrayOfString);
      c();
      return i;
    }
    return 0;
  }
  
  public Cursor a(String[] paramArrayOfString)
  {
    if (b())
    {
      paramArrayOfString = this.l.query("qz_cookie", paramArrayOfString, null, null, null, null, null);
      c();
      return paramArrayOfString;
    }
    return null;
  }
  
  public Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (b())
    {
      paramArrayOfString1 = this.l.query("qz_navigator_bar", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      c();
      return paramArrayOfString1;
    }
    return null;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l1 = this.k.replace("qz_configs", "", paramContentValues);
      if (l1 > 0L)
      {
        paramUri = ContentUris.withAppendedId(b, l1);
        c();
        return paramUri;
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("failed to insert row into ");
      paramContentValues.append(paramUri);
      throw new SQLException(paramContentValues.toString());
    }
    return null;
  }
  
  public boolean a()
  {
    SQLiteDatabase localSQLiteDatabase1 = this.k;
    if ((localSQLiteDatabase1 != null) && (localSQLiteDatabase1.isOpen())) {
      return true;
    }
    try
    {
      this.k = this.j.getWritableDatabase();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
      }
    }
    SQLiteDatabase localSQLiteDatabase2 = this.k;
    return (localSQLiteDatabase2 != null) && (localSQLiteDatabase2.isOpen());
  }
  
  public int b(String paramString, String[] paramArrayOfString)
  {
    if (a())
    {
      int i = this.k.delete("qz_isp_config", paramString, paramArrayOfString);
      c();
      return i;
    }
    return 0;
  }
  
  public Cursor b(String[] paramArrayOfString)
  {
    if (b())
    {
      paramArrayOfString = this.l.query("qz_check_time", paramArrayOfString, null, null, null, null, null);
      c();
      return paramArrayOfString;
    }
    return null;
  }
  
  public Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (b())
    {
      paramArrayOfString1 = this.l.query("qz_configs", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      c();
      return paramArrayOfString1;
    }
    return null;
  }
  
  public Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l1 = this.k.replace("qz_navigator_bar", "", paramContentValues);
      if (l1 > 0L)
      {
        paramUri = ContentUris.withAppendedId(h, l1);
        c();
        return paramUri;
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("failed to insert row into ");
      paramContentValues.append(paramUri);
      throw new SQLException(paramContentValues.toString());
    }
    return null;
  }
  
  public boolean b()
  {
    SQLiteDatabase localSQLiteDatabase1 = this.l;
    if ((localSQLiteDatabase1 != null) && (localSQLiteDatabase1.isOpen())) {
      return true;
    }
    try
    {
      this.l = this.j.getReadableDatabase();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
      }
    }
    SQLiteDatabase localSQLiteDatabase2 = this.l;
    return (localSQLiteDatabase2 != null) && (localSQLiteDatabase2.isOpen());
  }
  
  public int c(String paramString, String[] paramArrayOfString)
  {
    if (a())
    {
      int i = this.k.delete("qz_navigator_bar", paramString, paramArrayOfString);
      c();
      return i;
    }
    return 0;
  }
  
  public Cursor c(String[] paramArrayOfString)
  {
    if (b())
    {
      paramArrayOfString = this.l.query("qz_update", paramArrayOfString, null, null, null, null, null);
      c();
      return paramArrayOfString;
    }
    return null;
  }
  
  public Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (b())
    {
      paramArrayOfString1 = this.l.query("qz_isp_config", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      c();
      return paramArrayOfString1;
    }
    return null;
  }
  
  public Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l1 = this.k.replace("qz_isp_config", "", paramContentValues);
      if (l1 > 0L)
      {
        paramUri = ContentUris.withAppendedId(f, l1);
        c();
        return paramUri;
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("failed to insert row into ");
      paramContentValues.append(paramUri);
      throw new SQLException(paramContentValues.toString());
    }
    return null;
  }
  
  public void c() {}
  
  public int d()
  {
    if (a())
    {
      int i = this.k.delete("qz_cookie", null, null);
      c();
      return i;
    }
    return 0;
  }
  
  int d(String paramString, String[] paramArrayOfString)
  {
    if (a()) {
      return this.k.delete("table_qz_unread", paramString, paramArrayOfString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite,failed deleteQzoneUnread"));
    }
    return 0;
  }
  
  Cursor d(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (b())
    {
      paramArrayOfString1 = this.l.query("table_qz_unread", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      c();
      return paramArrayOfString1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite"));
    }
    return null;
  }
  
  public Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l1 = this.k.replace("qz_cookie", "", paramContentValues);
      if (l1 > 0L)
      {
        paramUri = ContentUris.withAppendedId(c, l1);
        c();
        return paramUri;
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("failed to insert row into ");
      paramContentValues.append(paramUri);
      throw new SQLException(paramContentValues.toString());
    }
    return null;
  }
  
  public int e()
  {
    if (a())
    {
      int i = this.k.delete("qz_check_time", null, null);
      c();
      return i;
    }
    return 0;
  }
  
  public Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l1 = this.k.replace("qz_check_time", "", paramContentValues);
      if (l1 > 0L)
      {
        paramUri = ContentUris.withAppendedId(g, l1);
        c();
        return paramUri;
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("failed to insert row into ");
      paramContentValues.append(paramUri);
      throw new SQLException(paramContentValues.toString());
    }
    return null;
  }
  
  public int f()
  {
    if (a()) {
      return this.k.delete("qz_update", null, null);
    }
    return 0;
  }
  
  public Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l1 = this.k.replace("qz_update", "", paramContentValues);
      if (l1 > 0L)
      {
        paramUri = ContentUris.withAppendedId(d, l1);
        c();
        return paramUri;
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("failed to insert row into ");
      paramContentValues.append(paramUri);
      throw new SQLException(paramContentValues.toString());
    }
    return null;
  }
  
  public int g()
  {
    return d() + 0 + a(null, null) + f() + e() + b(null, null) + c(null, null);
  }
  
  Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l1 = this.k.replace("table_qz_unread", "", paramContentValues);
      c();
      if (l1 > 0L) {
        return ContentUris.withAppendedId(paramUri, l1);
      }
      if (QLog.isColorLevel())
      {
        paramContentValues = new StringBuilder();
        paramContentValues.append("failed to insert row into ");
        paramContentValues.append(paramUri);
        QLog.e("QZConfigSqliteManager", 2, "", new SQLException(paramContentValues.toString()));
      }
    }
    else if (QLog.isColorLevel())
    {
      paramContentValues = new StringBuilder();
      paramContentValues.append("cannot openWriteSqlite,failed to insert row into ");
      paramContentValues.append(paramUri);
      QLog.e("QZConfigSqliteManager", 2, "", new SQLException(paramContentValues.toString()));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigSqliteManager
 * JD-Core Version:    0.7.0.1
 */