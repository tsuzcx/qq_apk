package com.tencent.mobileqq.activity.photo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class MediaDatabaseHelper
  extends SQLiteOpenHelper
{
  private static final String TAG = "MediaDatabaseHelper";
  private static MediaDatabaseHelper sInstance = null;
  private SQLiteDatabase mDatabase;
  private AtomicInteger mOpenCounter = new AtomicInteger(0);
  
  private MediaDatabaseHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  private void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS content_table (id            integer PRIMARY KEY autoincrement,name         varchar (128),path           varchar (512),filesize       integer,modifieddate   integer,folderpath           varchar (512),md5           varchar(128),duration      integer,mimetype  varchar (50));");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS folder_table (id            integer PRIMARY KEY autoincrement,folderpath         varchar (512),modifieddate   integer);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MediaDatabaseHelper", 2, "createDatabase error=" + paramSQLiteDatabase.getMessage());
    }
  }
  
  public static MediaDatabaseHelper getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new MediaDatabaseHelper(paramContext, "media_scanner_database", null, 2);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void closeDatabase()
  {
    try
    {
      if ((this.mOpenCounter.decrementAndGet() == 0) && (this.mDatabase != null)) {
        this.mDatabase.close();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void deleteMediaScannerInfoByFolderPathSet(HashSet<String> paramHashSet)
  {
    if (paramHashSet == null) {}
    SQLiteDatabase localSQLiteDatabase;
    for (;;)
    {
      return;
      try
      {
        localSQLiteDatabase = getReadableDatabase();
        localSQLiteDatabase.beginTransaction();
        paramHashSet = paramHashSet.iterator();
        while (paramHashSet.hasNext())
        {
          String str = (String)paramHashSet.next();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = str;
          localSQLiteDatabase.delete("content_table", "folderpath=?", arrayOfString);
          localSQLiteDatabase.delete("folder_table", "folderpath=?", arrayOfString);
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramHashSet) {}
    }
    QLog.d("MediaDatabaseHelper", 2, "getReadableDatabase ERROR Exception:" + paramHashSet.getMessage());
    return;
    try
    {
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramHashSet)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaDatabaseHelper", 2, "deleteMediaScannerInfoByFolderPathSet() ERROR Exception:" + paramHashSet.getMessage());
      }
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
      closeDatabase();
    }
  }
  
  /* Error */
  public void deleteMediaScannerInfoByList(java.util.ArrayList<MediaScannerInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 95	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   14: aload_1
    //   15: invokevirtual 141	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 106 1 0
    //   25: ifeq +117 -> 142
    //   28: aload_2
    //   29: ldc 114
    //   31: ldc 143
    //   33: iconst_1
    //   34: anewarray 112	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: invokeinterface 110 1 0
    //   45: checkcast 145	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   48: getfield 149	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   51: invokestatic 153	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: aastore
    //   55: invokevirtual 120	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: pop
    //   59: goto -40 -> 19
    //   62: astore_1
    //   63: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +31 -> 97
    //   69: ldc 8
    //   71: iconst_2
    //   72: new 52	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   79: ldc 155
    //   81: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: aload_2
    //   98: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   101: aload_0
    //   102: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   105: return
    //   106: astore_1
    //   107: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq -106 -> 4
    //   113: ldc 8
    //   115: iconst_2
    //   116: new 52	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   123: ldc 124
    //   125: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: return
    //   142: aload_2
    //   143: invokevirtual 127	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   146: aload_2
    //   147: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   150: aload_0
    //   151: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   154: return
    //   155: astore_1
    //   156: aload_2
    //   157: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   160: aload_0
    //   161: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	MediaDatabaseHelper
    //   0	166	1	paramArrayList	java.util.ArrayList<MediaScannerInfo>
    //   9	148	2	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	19	62	java/lang/Exception
    //   19	59	62	java/lang/Exception
    //   142	146	62	java/lang/Exception
    //   5	14	106	java/lang/Exception
    //   97	105	106	java/lang/Exception
    //   146	154	106	java/lang/Exception
    //   156	166	106	java/lang/Exception
    //   14	19	155	finally
    //   19	59	155	finally
    //   63	97	155	finally
    //   142	146	155	finally
  }
  
  /* Error */
  public void deleteMediaScannerInfoByPathSet(HashSet<String> paramHashSet)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 95	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   14: aload_1
    //   15: invokevirtual 101	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 106 1 0
    //   25: ifeq +111 -> 136
    //   28: aload_2
    //   29: ldc 114
    //   31: ldc 159
    //   33: iconst_1
    //   34: anewarray 112	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: invokeinterface 110 1 0
    //   45: checkcast 112	java/lang/String
    //   48: aastore
    //   49: invokevirtual 120	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   52: pop
    //   53: goto -34 -> 19
    //   56: astore_1
    //   57: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +31 -> 91
    //   63: ldc 8
    //   65: iconst_2
    //   66: new 52	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   73: ldc 161
    //   75: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   82: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_2
    //   92: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   95: aload_0
    //   96: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   99: return
    //   100: astore_1
    //   101: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq -100 -> 4
    //   107: ldc 8
    //   109: iconst_2
    //   110: new 52	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   117: ldc 124
    //   119: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: return
    //   136: aload_2
    //   137: invokevirtual 127	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   140: aload_2
    //   141: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   144: aload_0
    //   145: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   148: return
    //   149: astore_1
    //   150: aload_2
    //   151: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   154: aload_0
    //   155: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	MediaDatabaseHelper
    //   0	160	1	paramHashSet	HashSet<String>
    //   9	142	2	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	19	56	java/lang/Exception
    //   19	53	56	java/lang/Exception
    //   136	140	56	java/lang/Exception
    //   5	14	100	java/lang/Exception
    //   91	99	100	java/lang/Exception
    //   140	148	100	java/lang/Exception
    //   150	160	100	java/lang/Exception
    //   14	19	149	finally
    //   19	53	149	finally
    //   57	91	149	finally
    //   136	140	149	finally
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      if ((this.mOpenCounter.incrementAndGet() == 1) || (this.mDatabase == null)) {
        this.mDatabase = super.getReadableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void insertMediaScannerInfo(MediaScannerInfo paramMediaScannerInfo)
  {
    if (paramMediaScannerInfo == null) {
      return;
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("name", paramMediaScannerInfo.name);
      localContentValues.put("path", paramMediaScannerInfo.path);
      localContentValues.put("filesize", Long.valueOf(paramMediaScannerInfo.fileSize));
      localContentValues.put("modifieddate", Long.valueOf(paramMediaScannerInfo.modifiedDate));
      localContentValues.put("duration", Long.valueOf(paramMediaScannerInfo.duration));
      localContentValues.put("mimetype", paramMediaScannerInfo.mimeType);
      localContentValues.put("folderpath", paramMediaScannerInfo.folderPath);
      localContentValues.put("md5", paramMediaScannerInfo.md5);
      localSQLiteDatabase.insert("content_table", null, localContentValues);
      return;
    }
    catch (Exception paramMediaScannerInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaDatabaseHelper", 2, "insertMediaScannerInfoByList() ERROR Exception:" + paramMediaScannerInfo.getMessage());
      }
      return;
    }
    finally
    {
      closeDatabase();
    }
  }
  
  /* Error */
  public void insertMediaScannerInfoByList(java.util.ArrayList<MediaScannerInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 95	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   14: aload_1
    //   15: invokevirtual 141	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 106 1 0
    //   25: ifeq +212 -> 237
    //   28: aload_1
    //   29: invokeinterface 110 1 0
    //   34: checkcast 145	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   37: astore_3
    //   38: new 169	android/content/ContentValues
    //   41: dup
    //   42: invokespecial 170	android/content/ContentValues:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: ldc 172
    //   51: aload_3
    //   52: getfield 174	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   55: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 4
    //   60: ldc 180
    //   62: aload_3
    //   63: getfield 182	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   66: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 4
    //   71: ldc 184
    //   73: aload_3
    //   74: getfield 188	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   77: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   83: aload 4
    //   85: ldc 198
    //   87: aload_3
    //   88: getfield 201	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   91: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   97: aload 4
    //   99: ldc 203
    //   101: aload_3
    //   102: getfield 205	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   105: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   108: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   111: aload 4
    //   113: ldc 207
    //   115: aload_3
    //   116: getfield 210	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   119: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 4
    //   124: ldc 212
    //   126: aload_3
    //   127: getfield 215	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   130: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: ldc 217
    //   137: aload_3
    //   138: getfield 219	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   141: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_2
    //   145: ldc 114
    //   147: aconst_null
    //   148: aload 4
    //   150: invokevirtual 223	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   153: pop2
    //   154: goto -135 -> 19
    //   157: astore_1
    //   158: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +31 -> 192
    //   164: ldc 8
    //   166: iconst_2
    //   167: new 52	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   174: ldc 161
    //   176: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_2
    //   193: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   196: aload_0
    //   197: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   200: return
    //   201: astore_1
    //   202: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq -201 -> 4
    //   208: ldc 8
    //   210: iconst_2
    //   211: new 52	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   218: ldc 124
    //   220: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_1
    //   224: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: return
    //   237: aload_2
    //   238: invokevirtual 127	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   241: aload_2
    //   242: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   245: aload_0
    //   246: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   249: return
    //   250: astore_1
    //   251: aload_2
    //   252: invokevirtual 130	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   255: aload_0
    //   256: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   259: aload_1
    //   260: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	MediaDatabaseHelper
    //   0	261	1	paramArrayList	java.util.ArrayList<MediaScannerInfo>
    //   9	243	2	localSQLiteDatabase	SQLiteDatabase
    //   37	101	3	localMediaScannerInfo	MediaScannerInfo
    //   45	104	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   14	19	157	java/lang/Exception
    //   19	154	157	java/lang/Exception
    //   237	241	157	java/lang/Exception
    //   5	14	201	java/lang/Exception
    //   192	200	201	java/lang/Exception
    //   241	249	201	java/lang/Exception
    //   251	261	201	java/lang/Exception
    //   14	19	250	finally
    //   19	154	250	finally
    //   158	192	250	finally
    //   237	241	250	finally
  }
  
  public void insertMediaScnnerFolderInfo(MediaScannerFolderInfo paramMediaScannerFolderInfo)
  {
    if (paramMediaScannerFolderInfo == null) {
      return;
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("folderpath", paramMediaScannerFolderInfo.folderpath);
      localContentValues.put("modifieddate", Long.valueOf(paramMediaScannerFolderInfo.modifiedDate));
      localSQLiteDatabase.insert("folder_table", null, localContentValues);
      return;
    }
    catch (Exception paramMediaScannerFolderInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaDatabaseHelper", 2, "insertMediaScnnerFolderInfo() ERROR Exception:" + paramMediaScannerFolderInfo.getMessage());
      }
      return;
    }
    finally
    {
      closeDatabase();
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaDatabaseHelper", 2, "onCreate");
    }
    createDatabase(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaDatabaseHelper", 2, "onDowngrade oldVersion=" + paramInt1 + ", newVersion=" + paramInt2);
    }
    if (paramInt1 == paramInt2) {}
    do
    {
      return;
      try
      {
        paramSQLiteDatabase.execSQL("drop table if exists folder_table");
        paramSQLiteDatabase.execSQL("drop table if exists content_table");
        createDatabase(paramSQLiteDatabase);
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    } while (!QLog.isColorLevel());
    QLog.d("MediaDatabaseHelper", 2, "onDowngrade error=" + paramSQLiteDatabase.getMessage());
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaDatabaseHelper", 2, "onUpgrade oldVersion=" + paramInt1 + ", newVersion=" + paramInt2);
    }
    if (paramInt1 == paramInt2) {}
    do
    {
      return;
      try
      {
        paramSQLiteDatabase.execSQL("drop table if exists folder_table");
        paramSQLiteDatabase.execSQL("drop table if exists content_table");
        createDatabase(paramSQLiteDatabase);
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    } while (!QLog.isColorLevel());
    QLog.d("MediaDatabaseHelper", 2, "onUpgrade error=" + paramSQLiteDatabase.getMessage());
  }
  
  /* Error */
  public java.util.ArrayList<MediaScannerInfo> queryAllLongVideoMediaScannerInfo(String paramString)
  {
    // Byte code:
    //   0: new 140	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 260	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 114
    //   15: getstatic 266	com/tencent/mobileqq/activity/photo/MediaDBValues:CONTENT_TABLE_COLUMNS	[Ljava/lang/String;
    //   18: ldc_w 268
    //   21: iconst_1
    //   22: anewarray 112	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 270
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: ldc_w 272
    //   36: aload_1
    //   37: invokevirtual 276	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokeinterface 281 1 0
    //   49: ifeq +263 -> 312
    //   52: aload_2
    //   53: astore_1
    //   54: new 145	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   57: dup
    //   58: invokespecial 282	com/tencent/mobileqq/activity/photo/MediaScannerInfo:<init>	()V
    //   61: astore_3
    //   62: aload_2
    //   63: astore_1
    //   64: aload_3
    //   65: aload_2
    //   66: aload_2
    //   67: ldc_w 283
    //   70: invokeinterface 287 2 0
    //   75: invokeinterface 291 2 0
    //   80: putfield 149	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: aload_2
    //   87: aload_2
    //   88: ldc 172
    //   90: invokeinterface 287 2 0
    //   95: invokeinterface 294 2 0
    //   100: putfield 174	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: aload_2
    //   107: aload_2
    //   108: ldc 180
    //   110: invokeinterface 287 2 0
    //   115: invokeinterface 294 2 0
    //   120: putfield 182	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: aload_2
    //   127: aload_2
    //   128: ldc 184
    //   130: invokeinterface 287 2 0
    //   135: invokeinterface 298 2 0
    //   140: putfield 188	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: aload_2
    //   147: aload_2
    //   148: ldc 198
    //   150: invokeinterface 287 2 0
    //   155: invokeinterface 298 2 0
    //   160: putfield 201	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   163: aload_2
    //   164: astore_1
    //   165: aload_3
    //   166: aload_2
    //   167: aload_2
    //   168: ldc 203
    //   170: invokeinterface 287 2 0
    //   175: invokeinterface 298 2 0
    //   180: putfield 205	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   183: aload_2
    //   184: astore_1
    //   185: aload_3
    //   186: aload_2
    //   187: aload_2
    //   188: ldc 207
    //   190: invokeinterface 287 2 0
    //   195: invokeinterface 294 2 0
    //   200: putfield 210	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: aload_2
    //   207: aload_2
    //   208: ldc 212
    //   210: invokeinterface 287 2 0
    //   215: invokeinterface 294 2 0
    //   220: putfield 215	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   223: aload_2
    //   224: astore_1
    //   225: aload_3
    //   226: aload_2
    //   227: aload_2
    //   228: ldc 217
    //   230: invokeinterface 287 2 0
    //   235: invokeinterface 294 2 0
    //   240: putfield 219	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   243: aload_2
    //   244: astore_1
    //   245: aload 4
    //   247: aload_3
    //   248: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   251: pop
    //   252: goto -211 -> 41
    //   255: astore_3
    //   256: aload_2
    //   257: astore_1
    //   258: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +34 -> 295
    //   264: aload_2
    //   265: astore_1
    //   266: ldc 8
    //   268: iconst_2
    //   269: new 52	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 304
    //   279: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_3
    //   283: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_2
    //   296: ifnull +9 -> 305
    //   299: aload_2
    //   300: invokeinterface 305 1 0
    //   305: aload_0
    //   306: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   309: aload 4
    //   311: areturn
    //   312: aload_2
    //   313: ifnull +9 -> 322
    //   316: aload_2
    //   317: invokeinterface 305 1 0
    //   322: aload_0
    //   323: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   326: aload 4
    //   328: areturn
    //   329: astore_2
    //   330: aconst_null
    //   331: astore_1
    //   332: aload_1
    //   333: ifnull +9 -> 342
    //   336: aload_1
    //   337: invokeinterface 305 1 0
    //   342: aload_0
    //   343: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   346: aload_2
    //   347: athrow
    //   348: astore_2
    //   349: goto -17 -> 332
    //   352: astore_3
    //   353: aconst_null
    //   354: astore_2
    //   355: goto -99 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	MediaDatabaseHelper
    //   0	358	1	paramString	String
    //   40	277	2	localCursor	android.database.Cursor
    //   329	18	2	localObject1	Object
    //   348	1	2	localObject2	Object
    //   354	1	2	localObject3	Object
    //   61	187	3	localMediaScannerInfo	MediaScannerInfo
    //   255	28	3	localException1	Exception
    //   352	1	3	localException2	Exception
    //   7	320	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   43	52	255	java/lang/Exception
    //   54	62	255	java/lang/Exception
    //   64	83	255	java/lang/Exception
    //   85	103	255	java/lang/Exception
    //   105	123	255	java/lang/Exception
    //   125	143	255	java/lang/Exception
    //   145	163	255	java/lang/Exception
    //   165	183	255	java/lang/Exception
    //   185	203	255	java/lang/Exception
    //   205	223	255	java/lang/Exception
    //   225	243	255	java/lang/Exception
    //   245	252	255	java/lang/Exception
    //   9	41	329	finally
    //   43	52	348	finally
    //   54	62	348	finally
    //   64	83	348	finally
    //   85	103	348	finally
    //   105	123	348	finally
    //   125	143	348	finally
    //   145	163	348	finally
    //   165	183	348	finally
    //   185	203	348	finally
    //   205	223	348	finally
    //   225	243	348	finally
    //   245	252	348	finally
    //   258	264	348	finally
    //   266	295	348	finally
    //   9	41	352	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerFolderPathSet()
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 122
    //   15: iconst_1
    //   16: anewarray 112	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 212
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 281 1 0
    //   41: ifeq +85 -> 126
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: aload_2
    //   49: aload_2
    //   50: ldc 212
    //   52: invokeinterface 287 2 0
    //   57: invokeinterface 294 2 0
    //   62: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: goto -33 -> 33
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +34 -> 109
    //   78: aload_2
    //   79: astore_1
    //   80: ldc 8
    //   82: iconst_2
    //   83: new 52	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 315
    //   93: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_3
    //   97: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_2
    //   110: ifnull +9 -> 119
    //   113: aload_2
    //   114: invokeinterface 305 1 0
    //   119: aload_0
    //   120: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   123: aload 4
    //   125: areturn
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 305 1 0
    //   136: aload_0
    //   137: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   140: aload 4
    //   142: areturn
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +9 -> 156
    //   150: aload_1
    //   151: invokeinterface 305 1 0
    //   156: aload_0
    //   157: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: goto -17 -> 146
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -99 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	MediaDatabaseHelper
    //   34	117	1	localCursor1	android.database.Cursor
    //   32	99	2	localCursor2	android.database.Cursor
    //   143	18	2	localObject1	Object
    //   162	1	2	localObject2	Object
    //   168	1	2	localObject3	Object
    //   69	28	3	localException1	Exception
    //   166	1	3	localException2	Exception
    //   7	134	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   35	44	69	java/lang/Exception
    //   46	66	69	java/lang/Exception
    //   9	33	143	finally
    //   35	44	162	finally
    //   46	66	162	finally
    //   72	78	162	finally
    //   80	109	162	finally
    //   9	33	166	java/lang/Exception
  }
  
  /* Error */
  public java.util.ArrayList<MediaScannerInfo> queryAllMediaScannerInfo(String paramString)
  {
    // Byte code:
    //   0: new 140	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 260	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 114
    //   15: getstatic 266	com/tencent/mobileqq/activity/photo/MediaDBValues:CONTENT_TABLE_COLUMNS	[Ljava/lang/String;
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: ldc_w 272
    //   25: aload_1
    //   26: invokevirtual 276	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: invokeinterface 281 1 0
    //   38: ifeq +263 -> 301
    //   41: aload_2
    //   42: astore_1
    //   43: new 145	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   46: dup
    //   47: invokespecial 282	com/tencent/mobileqq/activity/photo/MediaScannerInfo:<init>	()V
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: aload_2
    //   55: aload_2
    //   56: ldc_w 283
    //   59: invokeinterface 287 2 0
    //   64: invokeinterface 291 2 0
    //   69: putfield 149	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: aload_2
    //   76: aload_2
    //   77: ldc 172
    //   79: invokeinterface 287 2 0
    //   84: invokeinterface 294 2 0
    //   89: putfield 174	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload_2
    //   96: aload_2
    //   97: ldc 180
    //   99: invokeinterface 287 2 0
    //   104: invokeinterface 294 2 0
    //   109: putfield 182	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: aload_2
    //   116: aload_2
    //   117: ldc 184
    //   119: invokeinterface 287 2 0
    //   124: invokeinterface 298 2 0
    //   129: putfield 188	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   132: aload_2
    //   133: astore_1
    //   134: aload_3
    //   135: aload_2
    //   136: aload_2
    //   137: ldc 198
    //   139: invokeinterface 287 2 0
    //   144: invokeinterface 298 2 0
    //   149: putfield 201	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   152: aload_2
    //   153: astore_1
    //   154: aload_3
    //   155: aload_2
    //   156: aload_2
    //   157: ldc 203
    //   159: invokeinterface 287 2 0
    //   164: invokeinterface 298 2 0
    //   169: putfield 205	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   172: aload_2
    //   173: astore_1
    //   174: aload_3
    //   175: aload_2
    //   176: aload_2
    //   177: ldc 207
    //   179: invokeinterface 287 2 0
    //   184: invokeinterface 294 2 0
    //   189: putfield 210	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   192: aload_2
    //   193: astore_1
    //   194: aload_3
    //   195: aload_2
    //   196: aload_2
    //   197: ldc 212
    //   199: invokeinterface 287 2 0
    //   204: invokeinterface 294 2 0
    //   209: putfield 215	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   212: aload_2
    //   213: astore_1
    //   214: aload_3
    //   215: aload_2
    //   216: aload_2
    //   217: ldc 217
    //   219: invokeinterface 287 2 0
    //   224: invokeinterface 294 2 0
    //   229: putfield 219	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   232: aload_2
    //   233: astore_1
    //   234: aload 4
    //   236: aload_3
    //   237: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   240: pop
    //   241: goto -211 -> 30
    //   244: astore_3
    //   245: aload_2
    //   246: astore_1
    //   247: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +34 -> 284
    //   253: aload_2
    //   254: astore_1
    //   255: ldc 8
    //   257: iconst_2
    //   258: new 52	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 319
    //   268: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_3
    //   272: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_2
    //   285: ifnull +9 -> 294
    //   288: aload_2
    //   289: invokeinterface 305 1 0
    //   294: aload_0
    //   295: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   298: aload 4
    //   300: areturn
    //   301: aload_2
    //   302: ifnull +9 -> 311
    //   305: aload_2
    //   306: invokeinterface 305 1 0
    //   311: aload_0
    //   312: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   315: aload 4
    //   317: areturn
    //   318: astore_2
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_1
    //   322: ifnull +9 -> 331
    //   325: aload_1
    //   326: invokeinterface 305 1 0
    //   331: aload_0
    //   332: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   335: aload_2
    //   336: athrow
    //   337: astore_2
    //   338: goto -17 -> 321
    //   341: astore_3
    //   342: aconst_null
    //   343: astore_2
    //   344: goto -99 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	MediaDatabaseHelper
    //   0	347	1	paramString	String
    //   29	277	2	localCursor	android.database.Cursor
    //   318	18	2	localObject1	Object
    //   337	1	2	localObject2	Object
    //   343	1	2	localObject3	Object
    //   50	187	3	localMediaScannerInfo	MediaScannerInfo
    //   244	28	3	localException1	Exception
    //   341	1	3	localException2	Exception
    //   7	309	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   32	41	244	java/lang/Exception
    //   43	51	244	java/lang/Exception
    //   53	72	244	java/lang/Exception
    //   74	92	244	java/lang/Exception
    //   94	112	244	java/lang/Exception
    //   114	132	244	java/lang/Exception
    //   134	152	244	java/lang/Exception
    //   154	172	244	java/lang/Exception
    //   174	192	244	java/lang/Exception
    //   194	212	244	java/lang/Exception
    //   214	232	244	java/lang/Exception
    //   234	241	244	java/lang/Exception
    //   9	30	318	finally
    //   32	41	337	finally
    //   43	51	337	finally
    //   53	72	337	finally
    //   74	92	337	finally
    //   94	112	337	finally
    //   114	132	337	finally
    //   134	152	337	finally
    //   154	172	337	finally
    //   174	192	337	finally
    //   194	212	337	finally
    //   214	232	337	finally
    //   234	241	337	finally
    //   247	253	337	finally
    //   255	284	337	finally
    //   9	30	341	java/lang/Exception
  }
  
  /* Error */
  public int queryAllMediaScannerInfoCnt()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: ldc 114
    //   6: iconst_1
    //   7: anewarray 112	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc_w 283
    //   15: aastore
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: invokeinterface 323 1 0
    //   33: istore_1
    //   34: aload_3
    //   35: ifnull +9 -> 44
    //   38: aload_3
    //   39: invokeinterface 305 1 0
    //   44: aload_0
    //   45: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   48: iload_1
    //   49: ireturn
    //   50: astore 4
    //   52: aconst_null
    //   53: astore_3
    //   54: aload_3
    //   55: astore_2
    //   56: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +35 -> 94
    //   62: aload_3
    //   63: astore_2
    //   64: ldc 8
    //   66: iconst_2
    //   67: new 52	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 325
    //   77: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload 4
    //   82: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   85: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_3
    //   95: ifnull +9 -> 104
    //   98: aload_3
    //   99: invokeinterface 305 1 0
    //   104: aload_0
    //   105: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 305 1 0
    //   123: aload_0
    //   124: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   127: aload_3
    //   128: athrow
    //   129: astore_3
    //   130: goto -17 -> 113
    //   133: astore 4
    //   135: goto -81 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	MediaDatabaseHelper
    //   33	16	1	i	int
    //   26	92	2	localCursor1	android.database.Cursor
    //   24	75	3	localCursor2	android.database.Cursor
    //   110	18	3	localObject1	Object
    //   129	1	3	localObject2	Object
    //   50	31	4	localException1	Exception
    //   133	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	25	50	java/lang/Exception
    //   0	25	110	finally
    //   27	34	129	finally
    //   56	62	129	finally
    //   64	94	129	finally
    //   27	34	133	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerInfoMd5Set()
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 114
    //   15: iconst_1
    //   16: anewarray 112	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 217
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 281 1 0
    //   41: ifeq +85 -> 126
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: aload_2
    //   49: aload_2
    //   50: ldc 217
    //   52: invokeinterface 287 2 0
    //   57: invokeinterface 294 2 0
    //   62: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: goto -33 -> 33
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +34 -> 109
    //   78: aload_2
    //   79: astore_1
    //   80: ldc 8
    //   82: iconst_2
    //   83: new 52	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 315
    //   93: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_3
    //   97: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_2
    //   110: ifnull +9 -> 119
    //   113: aload_2
    //   114: invokeinterface 305 1 0
    //   119: aload_0
    //   120: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   123: aload 4
    //   125: areturn
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 305 1 0
    //   136: aload_0
    //   137: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   140: aload 4
    //   142: areturn
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +9 -> 156
    //   150: aload_1
    //   151: invokeinterface 305 1 0
    //   156: aload_0
    //   157: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: goto -17 -> 146
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -99 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	MediaDatabaseHelper
    //   34	117	1	localCursor1	android.database.Cursor
    //   32	99	2	localCursor2	android.database.Cursor
    //   143	18	2	localObject1	Object
    //   162	1	2	localObject2	Object
    //   168	1	2	localObject3	Object
    //   69	28	3	localException1	Exception
    //   166	1	3	localException2	Exception
    //   7	134	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   35	44	69	java/lang/Exception
    //   46	66	69	java/lang/Exception
    //   9	33	143	finally
    //   35	44	162	finally
    //   46	66	162	finally
    //   72	78	162	finally
    //   80	109	162	finally
    //   9	33	166	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerInfoPathSet()
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 114
    //   15: iconst_1
    //   16: anewarray 112	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 180
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 281 1 0
    //   41: ifeq +85 -> 126
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: aload_2
    //   49: aload_2
    //   50: ldc 180
    //   52: invokeinterface 287 2 0
    //   57: invokeinterface 294 2 0
    //   62: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: goto -33 -> 33
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +34 -> 109
    //   78: aload_2
    //   79: astore_1
    //   80: ldc 8
    //   82: iconst_2
    //   83: new 52	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 329
    //   93: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_3
    //   97: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_2
    //   110: ifnull +9 -> 119
    //   113: aload_2
    //   114: invokeinterface 305 1 0
    //   119: aload_0
    //   120: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   123: aload 4
    //   125: areturn
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 305 1 0
    //   136: aload_0
    //   137: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   140: aload 4
    //   142: areturn
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +9 -> 156
    //   150: aload_1
    //   151: invokeinterface 305 1 0
    //   156: aload_0
    //   157: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: goto -17 -> 146
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -99 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	MediaDatabaseHelper
    //   34	117	1	localCursor1	android.database.Cursor
    //   32	99	2	localCursor2	android.database.Cursor
    //   143	18	2	localObject1	Object
    //   162	1	2	localObject2	Object
    //   168	1	2	localObject3	Object
    //   69	28	3	localException1	Exception
    //   166	1	3	localException2	Exception
    //   7	134	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   35	44	69	java/lang/Exception
    //   46	66	69	java/lang/Exception
    //   9	33	143	finally
    //   35	44	162	finally
    //   46	66	162	finally
    //   72	78	162	finally
    //   80	109	162	finally
    //   9	33	166	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerInfoPathSetByFolder(String paramString)
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 114
    //   15: iconst_1
    //   16: anewarray 112	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 180
    //   23: aastore
    //   24: ldc 116
    //   26: iconst_1
    //   27: anewarray 112	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokeinterface 281 1 0
    //   49: ifeq +85 -> 134
    //   52: aload_2
    //   53: astore_1
    //   54: aload 4
    //   56: aload_2
    //   57: aload_2
    //   58: ldc 180
    //   60: invokeinterface 287 2 0
    //   65: invokeinterface 294 2 0
    //   70: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -33 -> 41
    //   77: astore_3
    //   78: aload_2
    //   79: astore_1
    //   80: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +34 -> 117
    //   86: aload_2
    //   87: astore_1
    //   88: ldc 8
    //   90: iconst_2
    //   91: new 52	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 333
    //   101: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_2
    //   118: ifnull +9 -> 127
    //   121: aload_2
    //   122: invokeinterface 305 1 0
    //   127: aload_0
    //   128: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   131: aload 4
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 305 1 0
    //   144: aload_0
    //   145: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   148: aload 4
    //   150: areturn
    //   151: astore_2
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +9 -> 164
    //   158: aload_1
    //   159: invokeinterface 305 1 0
    //   164: aload_0
    //   165: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   168: aload_2
    //   169: athrow
    //   170: astore_2
    //   171: goto -17 -> 154
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -99 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	MediaDatabaseHelper
    //   0	180	1	paramString	String
    //   40	99	2	localCursor	android.database.Cursor
    //   151	18	2	localObject1	Object
    //   170	1	2	localObject2	Object
    //   176	1	2	localObject3	Object
    //   77	28	3	localException1	Exception
    //   174	1	3	localException2	Exception
    //   7	142	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   43	52	77	java/lang/Exception
    //   54	74	77	java/lang/Exception
    //   9	41	151	finally
    //   43	52	170	finally
    //   54	74	170	finally
    //   80	86	170	finally
    //   88	117	170	finally
    //   9	41	174	java/lang/Exception
  }
  
  /* Error */
  public MediaScannerFolderInfo queryMediaScannerFolderInfoByFolderpath(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: ldc 122
    //   6: getstatic 339	com/tencent/mobileqq/activity/photo/MediaDBValues:FOLDER_TABLE_COLUMNS	[Ljava/lang/String;
    //   9: ldc 116
    //   11: iconst_1
    //   12: anewarray 112	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 323 1 0
    //   32: ifle +182 -> 214
    //   35: aload_1
    //   36: invokeinterface 281 1 0
    //   41: pop
    //   42: new 228	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo
    //   45: dup
    //   46: invokespecial 340	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: aload_1
    //   52: aload_1
    //   53: ldc_w 283
    //   56: invokeinterface 287 2 0
    //   61: invokeinterface 291 2 0
    //   66: putfield 341	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:id	I
    //   69: aload_2
    //   70: aload_1
    //   71: aload_1
    //   72: ldc 212
    //   74: invokeinterface 287 2 0
    //   79: invokeinterface 294 2 0
    //   84: putfield 230	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:folderpath	Ljava/lang/String;
    //   87: aload_2
    //   88: aload_1
    //   89: aload_1
    //   90: ldc 198
    //   92: invokeinterface 287 2 0
    //   97: invokeinterface 298 2 0
    //   102: putfield 231	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:modifiedDate	J
    //   105: aload_1
    //   106: ifnull +9 -> 115
    //   109: aload_1
    //   110: invokeinterface 305 1 0
    //   115: aload_0
    //   116: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   119: aload_2
    //   120: areturn
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_2
    //   126: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +32 -> 161
    //   132: ldc 8
    //   134: iconst_2
    //   135: new 52	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 343
    //   145: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_3
    //   149: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_1
    //   162: ifnull +9 -> 171
    //   165: aload_1
    //   166: invokeinterface 305 1 0
    //   171: aload_0
    //   172: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   175: aload_2
    //   176: areturn
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +9 -> 190
    //   184: aload_1
    //   185: invokeinterface 305 1 0
    //   190: aload_0
    //   191: invokevirtual 132	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   194: aload_2
    //   195: athrow
    //   196: astore_2
    //   197: goto -17 -> 180
    //   200: astore_2
    //   201: goto -21 -> 180
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_2
    //   207: goto -81 -> 126
    //   210: astore_3
    //   211: goto -85 -> 126
    //   214: aconst_null
    //   215: astore_2
    //   216: goto -111 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	MediaDatabaseHelper
    //   0	219	1	paramString	String
    //   49	127	2	localMediaScannerFolderInfo	MediaScannerFolderInfo
    //   177	18	2	localObject1	Object
    //   196	1	2	localObject2	Object
    //   200	1	2	localObject3	Object
    //   206	10	2	localObject4	Object
    //   121	28	3	localException1	Exception
    //   204	1	3	localException2	Exception
    //   210	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	26	121	java/lang/Exception
    //   0	26	177	finally
    //   26	50	196	finally
    //   50	105	196	finally
    //   126	161	200	finally
    //   26	50	204	java/lang/Exception
    //   50	105	210	java/lang/Exception
  }
  
  public void updateMediaScnnerFolderInfo(MediaScannerFolderInfo paramMediaScannerFolderInfo)
  {
    if (paramMediaScannerFolderInfo == null) {
      return;
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("modifieddate", Long.valueOf(paramMediaScannerFolderInfo.modifiedDate));
      localSQLiteDatabase.update("folder_table", localContentValues, "folderpath=?", new String[] { paramMediaScannerFolderInfo.folderpath });
      return;
    }
    catch (Exception paramMediaScannerFolderInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaDatabaseHelper", 2, "updateMediaScnnerFolderInfo() ERROR Exception:" + paramMediaScannerFolderInfo.getMessage());
      }
      return;
    }
    finally
    {
      closeDatabase();
    }
  }
  
  public void updateMediaScnnerInfoDuration(String paramString, long paramLong)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("duration", Long.valueOf(paramLong));
      localSQLiteDatabase.update("content_table", localContentValues, "path=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaDatabaseHelper", 2, "updateMediaScnnerFolderInfo() ERROR Exception:" + paramString.getMessage());
      }
      return;
    }
    finally
    {
      closeDatabase();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */