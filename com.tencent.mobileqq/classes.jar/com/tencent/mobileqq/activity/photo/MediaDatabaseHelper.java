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
  private static MediaDatabaseHelper sInstance = null;
  private String TAG = "MediaDatabaseHelper";
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
      QLog.d(this.TAG, 2, "createDatabase error=" + paramSQLiteDatabase.getMessage());
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
    QLog.d(this.TAG, 2, "getReadableDatabase ERROR Exception:" + paramHashSet.getMessage());
    return;
    try
    {
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramHashSet)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "deleteMediaScannerInfoByFolderPathSet() ERROR Exception:" + paramHashSet.getMessage());
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
    //   6: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 97	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   14: aload_1
    //   15: invokevirtual 143	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 108 1 0
    //   25: ifeq +121 -> 146
    //   28: aload_2
    //   29: ldc 116
    //   31: ldc 145
    //   33: iconst_1
    //   34: anewarray 114	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: invokeinterface 112 1 0
    //   45: checkcast 147	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   48: getfield 151	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   51: invokestatic 155	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: aastore
    //   55: invokevirtual 122	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: pop
    //   59: goto -40 -> 19
    //   62: astore_1
    //   63: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +33 -> 99
    //   69: aload_0
    //   70: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   73: iconst_2
    //   74: new 54	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   81: ldc 157
    //   83: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_2
    //   100: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   103: aload_0
    //   104: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   107: return
    //   108: astore_1
    //   109: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq -108 -> 4
    //   115: aload_0
    //   116: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   119: iconst_2
    //   120: new 54	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   127: ldc 126
    //   129: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: return
    //   146: aload_2
    //   147: invokevirtual 129	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   150: aload_2
    //   151: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   154: aload_0
    //   155: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   158: return
    //   159: astore_1
    //   160: aload_2
    //   161: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   164: aload_0
    //   165: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	MediaDatabaseHelper
    //   0	170	1	paramArrayList	java.util.ArrayList<MediaScannerInfo>
    //   9	152	2	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	19	62	java/lang/Exception
    //   19	59	62	java/lang/Exception
    //   146	150	62	java/lang/Exception
    //   5	14	108	java/lang/Exception
    //   99	107	108	java/lang/Exception
    //   150	158	108	java/lang/Exception
    //   160	170	108	java/lang/Exception
    //   14	19	159	finally
    //   19	59	159	finally
    //   63	99	159	finally
    //   146	150	159	finally
  }
  
  /* Error */
  public void deleteMediaScannerInfoByPathSet(HashSet<String> paramHashSet)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 97	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   14: aload_1
    //   15: invokevirtual 103	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 108 1 0
    //   25: ifeq +115 -> 140
    //   28: aload_2
    //   29: ldc 116
    //   31: ldc 161
    //   33: iconst_1
    //   34: anewarray 114	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: invokeinterface 112 1 0
    //   45: checkcast 114	java/lang/String
    //   48: aastore
    //   49: invokevirtual 122	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   52: pop
    //   53: goto -34 -> 19
    //   56: astore_1
    //   57: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +33 -> 93
    //   63: aload_0
    //   64: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   67: iconst_2
    //   68: new 54	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   75: ldc 163
    //   77: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_2
    //   94: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   97: aload_0
    //   98: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   101: return
    //   102: astore_1
    //   103: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -102 -> 4
    //   109: aload_0
    //   110: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   113: iconst_2
    //   114: new 54	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   121: ldc 126
    //   123: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: return
    //   140: aload_2
    //   141: invokevirtual 129	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   144: aload_2
    //   145: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   148: aload_0
    //   149: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   152: return
    //   153: astore_1
    //   154: aload_2
    //   155: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: aload_0
    //   159: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	MediaDatabaseHelper
    //   0	164	1	paramHashSet	HashSet<String>
    //   9	146	2	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	19	56	java/lang/Exception
    //   19	53	56	java/lang/Exception
    //   140	144	56	java/lang/Exception
    //   5	14	102	java/lang/Exception
    //   93	101	102	java/lang/Exception
    //   144	152	102	java/lang/Exception
    //   154	164	102	java/lang/Exception
    //   14	19	153	finally
    //   19	53	153	finally
    //   57	93	153	finally
    //   140	144	153	finally
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
        QLog.d(this.TAG, 2, "insertMediaScannerInfoByList() ERROR Exception:" + paramMediaScannerInfo.getMessage());
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
    //   6: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 97	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   14: aload_1
    //   15: invokevirtual 143	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 108 1 0
    //   25: ifeq +216 -> 241
    //   28: aload_1
    //   29: invokeinterface 112 1 0
    //   34: checkcast 147	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   37: astore_3
    //   38: new 171	android/content/ContentValues
    //   41: dup
    //   42: invokespecial 172	android/content/ContentValues:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: ldc 174
    //   51: aload_3
    //   52: getfield 176	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   55: invokevirtual 180	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 4
    //   60: ldc 182
    //   62: aload_3
    //   63: getfield 184	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   66: invokevirtual 180	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 4
    //   71: ldc 186
    //   73: aload_3
    //   74: getfield 190	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   77: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: invokevirtual 198	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   83: aload 4
    //   85: ldc 200
    //   87: aload_3
    //   88: getfield 203	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   91: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 198	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   97: aload 4
    //   99: ldc 205
    //   101: aload_3
    //   102: getfield 207	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   105: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   108: invokevirtual 198	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   111: aload 4
    //   113: ldc 209
    //   115: aload_3
    //   116: getfield 212	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   119: invokevirtual 180	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 4
    //   124: ldc 214
    //   126: aload_3
    //   127: getfield 217	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   130: invokevirtual 180	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: ldc 219
    //   137: aload_3
    //   138: getfield 221	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   141: invokevirtual 180	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_2
    //   145: ldc 116
    //   147: aconst_null
    //   148: aload 4
    //   150: invokevirtual 225	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   153: pop2
    //   154: goto -135 -> 19
    //   157: astore_1
    //   158: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +33 -> 194
    //   164: aload_0
    //   165: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   168: iconst_2
    //   169: new 54	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   176: ldc 163
    //   178: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   185: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_2
    //   195: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   198: aload_0
    //   199: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   202: return
    //   203: astore_1
    //   204: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -203 -> 4
    //   210: aload_0
    //   211: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   214: iconst_2
    //   215: new 54	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   222: ldc 126
    //   224: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: return
    //   241: aload_2
    //   242: invokevirtual 129	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   245: aload_2
    //   246: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   249: aload_0
    //   250: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   253: return
    //   254: astore_1
    //   255: aload_2
    //   256: invokevirtual 132	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   259: aload_0
    //   260: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	MediaDatabaseHelper
    //   0	265	1	paramArrayList	java.util.ArrayList<MediaScannerInfo>
    //   9	247	2	localSQLiteDatabase	SQLiteDatabase
    //   37	101	3	localMediaScannerInfo	MediaScannerInfo
    //   45	104	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   14	19	157	java/lang/Exception
    //   19	154	157	java/lang/Exception
    //   241	245	157	java/lang/Exception
    //   5	14	203	java/lang/Exception
    //   194	202	203	java/lang/Exception
    //   245	253	203	java/lang/Exception
    //   255	265	203	java/lang/Exception
    //   14	19	254	finally
    //   19	154	254	finally
    //   158	194	254	finally
    //   241	245	254	finally
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
        QLog.d(this.TAG, 2, "insertMediaScnnerFolderInfo() ERROR Exception:" + paramMediaScannerFolderInfo.getMessage());
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
      QLog.d(this.TAG, 2, "onCreate");
    }
    createDatabase(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onDowngrade oldVersion=" + paramInt1 + ", newVersion=" + paramInt2);
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
    QLog.d(this.TAG, 2, "onDowngrade error=" + paramSQLiteDatabase.getMessage());
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onUpgrade oldVersion=" + paramInt1 + ", newVersion=" + paramInt2);
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
    QLog.d(this.TAG, 2, "onUpgrade error=" + paramSQLiteDatabase.getMessage());
  }
  
  /* Error */
  public java.util.ArrayList<MediaScannerInfo> queryAllLongVideoMediaScannerInfo(String paramString)
  {
    // Byte code:
    //   0: new 142	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 262	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 116
    //   15: getstatic 268	com/tencent/mobileqq/activity/photo/MediaDBValues:CONTENT_TABLE_COLUMNS	[Ljava/lang/String;
    //   18: ldc_w 270
    //   21: iconst_1
    //   22: anewarray 114	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 272
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: ldc_w 274
    //   36: aload_1
    //   37: invokevirtual 278	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokeinterface 283 1 0
    //   49: ifeq +265 -> 314
    //   52: aload_2
    //   53: astore_1
    //   54: new 147	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   57: dup
    //   58: invokespecial 284	com/tencent/mobileqq/activity/photo/MediaScannerInfo:<init>	()V
    //   61: astore_3
    //   62: aload_2
    //   63: astore_1
    //   64: aload_3
    //   65: aload_2
    //   66: aload_2
    //   67: ldc_w 285
    //   70: invokeinterface 289 2 0
    //   75: invokeinterface 293 2 0
    //   80: putfield 151	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: aload_2
    //   87: aload_2
    //   88: ldc 174
    //   90: invokeinterface 289 2 0
    //   95: invokeinterface 296 2 0
    //   100: putfield 176	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: aload_2
    //   107: aload_2
    //   108: ldc 182
    //   110: invokeinterface 289 2 0
    //   115: invokeinterface 296 2 0
    //   120: putfield 184	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: aload_2
    //   127: aload_2
    //   128: ldc 186
    //   130: invokeinterface 289 2 0
    //   135: invokeinterface 300 2 0
    //   140: putfield 190	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: aload_2
    //   147: aload_2
    //   148: ldc 200
    //   150: invokeinterface 289 2 0
    //   155: invokeinterface 300 2 0
    //   160: putfield 203	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   163: aload_2
    //   164: astore_1
    //   165: aload_3
    //   166: aload_2
    //   167: aload_2
    //   168: ldc 205
    //   170: invokeinterface 289 2 0
    //   175: invokeinterface 300 2 0
    //   180: putfield 207	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   183: aload_2
    //   184: astore_1
    //   185: aload_3
    //   186: aload_2
    //   187: aload_2
    //   188: ldc 209
    //   190: invokeinterface 289 2 0
    //   195: invokeinterface 296 2 0
    //   200: putfield 212	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: aload_2
    //   207: aload_2
    //   208: ldc 214
    //   210: invokeinterface 289 2 0
    //   215: invokeinterface 296 2 0
    //   220: putfield 217	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   223: aload_2
    //   224: astore_1
    //   225: aload_3
    //   226: aload_2
    //   227: aload_2
    //   228: ldc 219
    //   230: invokeinterface 289 2 0
    //   235: invokeinterface 296 2 0
    //   240: putfield 221	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   243: aload_2
    //   244: astore_1
    //   245: aload 4
    //   247: aload_3
    //   248: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   251: pop
    //   252: goto -211 -> 41
    //   255: astore_3
    //   256: aload_2
    //   257: astore_1
    //   258: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +36 -> 297
    //   264: aload_2
    //   265: astore_1
    //   266: aload_0
    //   267: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   270: iconst_2
    //   271: new 54	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 306
    //   281: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_3
    //   285: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_2
    //   298: ifnull +9 -> 307
    //   301: aload_2
    //   302: invokeinterface 307 1 0
    //   307: aload_0
    //   308: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   311: aload 4
    //   313: areturn
    //   314: aload_2
    //   315: ifnull +9 -> 324
    //   318: aload_2
    //   319: invokeinterface 307 1 0
    //   324: aload_0
    //   325: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   328: aload 4
    //   330: areturn
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_1
    //   334: aload_1
    //   335: ifnull +9 -> 344
    //   338: aload_1
    //   339: invokeinterface 307 1 0
    //   344: aload_0
    //   345: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   348: aload_2
    //   349: athrow
    //   350: astore_2
    //   351: goto -17 -> 334
    //   354: astore_3
    //   355: aconst_null
    //   356: astore_2
    //   357: goto -101 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	MediaDatabaseHelper
    //   0	360	1	paramString	String
    //   40	279	2	localCursor	android.database.Cursor
    //   331	18	2	localObject1	Object
    //   350	1	2	localObject2	Object
    //   356	1	2	localObject3	Object
    //   61	187	3	localMediaScannerInfo	MediaScannerInfo
    //   255	30	3	localException1	Exception
    //   354	1	3	localException2	Exception
    //   7	322	4	localArrayList	java.util.ArrayList
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
    //   9	41	331	finally
    //   43	52	350	finally
    //   54	62	350	finally
    //   64	83	350	finally
    //   85	103	350	finally
    //   105	123	350	finally
    //   125	143	350	finally
    //   145	163	350	finally
    //   165	183	350	finally
    //   185	203	350	finally
    //   205	223	350	finally
    //   225	243	350	finally
    //   245	252	350	finally
    //   258	264	350	finally
    //   266	297	350	finally
    //   9	41	354	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerFolderPathSet()
  {
    // Byte code:
    //   0: new 99	java/util/HashSet
    //   3: dup
    //   4: invokespecial 311	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 124
    //   15: iconst_1
    //   16: anewarray 114	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 214
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 314	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 283 1 0
    //   41: ifeq +87 -> 128
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: aload_2
    //   49: aload_2
    //   50: ldc 214
    //   52: invokeinterface 289 2 0
    //   57: invokeinterface 296 2 0
    //   62: invokevirtual 315	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: goto -33 -> 33
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +36 -> 111
    //   78: aload_2
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   84: iconst_2
    //   85: new 54	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 317
    //   95: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_2
    //   112: ifnull +9 -> 121
    //   115: aload_2
    //   116: invokeinterface 307 1 0
    //   121: aload_0
    //   122: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   125: aload 4
    //   127: areturn
    //   128: aload_2
    //   129: ifnull +9 -> 138
    //   132: aload_2
    //   133: invokeinterface 307 1 0
    //   138: aload_0
    //   139: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   142: aload 4
    //   144: areturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 307 1 0
    //   158: aload_0
    //   159: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   162: aload_2
    //   163: athrow
    //   164: astore_2
    //   165: goto -17 -> 148
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -101 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	MediaDatabaseHelper
    //   34	119	1	localCursor1	android.database.Cursor
    //   32	101	2	localCursor2	android.database.Cursor
    //   145	18	2	localObject1	Object
    //   164	1	2	localObject2	Object
    //   170	1	2	localObject3	Object
    //   69	30	3	localException1	Exception
    //   168	1	3	localException2	Exception
    //   7	136	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   35	44	69	java/lang/Exception
    //   46	66	69	java/lang/Exception
    //   9	33	145	finally
    //   35	44	164	finally
    //   46	66	164	finally
    //   72	78	164	finally
    //   80	111	164	finally
    //   9	33	168	java/lang/Exception
  }
  
  /* Error */
  public java.util.ArrayList<MediaScannerInfo> queryAllMediaScannerInfo(String paramString)
  {
    // Byte code:
    //   0: new 142	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 262	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 116
    //   15: getstatic 268	com/tencent/mobileqq/activity/photo/MediaDBValues:CONTENT_TABLE_COLUMNS	[Ljava/lang/String;
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: ldc_w 274
    //   25: aload_1
    //   26: invokevirtual 278	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: invokeinterface 283 1 0
    //   38: ifeq +265 -> 303
    //   41: aload_2
    //   42: astore_1
    //   43: new 147	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   46: dup
    //   47: invokespecial 284	com/tencent/mobileqq/activity/photo/MediaScannerInfo:<init>	()V
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: aload_2
    //   55: aload_2
    //   56: ldc_w 285
    //   59: invokeinterface 289 2 0
    //   64: invokeinterface 293 2 0
    //   69: putfield 151	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: aload_2
    //   76: aload_2
    //   77: ldc 174
    //   79: invokeinterface 289 2 0
    //   84: invokeinterface 296 2 0
    //   89: putfield 176	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload_2
    //   96: aload_2
    //   97: ldc 182
    //   99: invokeinterface 289 2 0
    //   104: invokeinterface 296 2 0
    //   109: putfield 184	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: aload_2
    //   116: aload_2
    //   117: ldc 186
    //   119: invokeinterface 289 2 0
    //   124: invokeinterface 300 2 0
    //   129: putfield 190	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   132: aload_2
    //   133: astore_1
    //   134: aload_3
    //   135: aload_2
    //   136: aload_2
    //   137: ldc 200
    //   139: invokeinterface 289 2 0
    //   144: invokeinterface 300 2 0
    //   149: putfield 203	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   152: aload_2
    //   153: astore_1
    //   154: aload_3
    //   155: aload_2
    //   156: aload_2
    //   157: ldc 205
    //   159: invokeinterface 289 2 0
    //   164: invokeinterface 300 2 0
    //   169: putfield 207	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   172: aload_2
    //   173: astore_1
    //   174: aload_3
    //   175: aload_2
    //   176: aload_2
    //   177: ldc 209
    //   179: invokeinterface 289 2 0
    //   184: invokeinterface 296 2 0
    //   189: putfield 212	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   192: aload_2
    //   193: astore_1
    //   194: aload_3
    //   195: aload_2
    //   196: aload_2
    //   197: ldc 214
    //   199: invokeinterface 289 2 0
    //   204: invokeinterface 296 2 0
    //   209: putfield 217	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   212: aload_2
    //   213: astore_1
    //   214: aload_3
    //   215: aload_2
    //   216: aload_2
    //   217: ldc 219
    //   219: invokeinterface 289 2 0
    //   224: invokeinterface 296 2 0
    //   229: putfield 221	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   232: aload_2
    //   233: astore_1
    //   234: aload 4
    //   236: aload_3
    //   237: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   240: pop
    //   241: goto -211 -> 30
    //   244: astore_3
    //   245: aload_2
    //   246: astore_1
    //   247: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +36 -> 286
    //   253: aload_2
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   259: iconst_2
    //   260: new 54	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 321
    //   270: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_3
    //   274: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   277: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload_2
    //   287: ifnull +9 -> 296
    //   290: aload_2
    //   291: invokeinterface 307 1 0
    //   296: aload_0
    //   297: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   300: aload 4
    //   302: areturn
    //   303: aload_2
    //   304: ifnull +9 -> 313
    //   307: aload_2
    //   308: invokeinterface 307 1 0
    //   313: aload_0
    //   314: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   317: aload 4
    //   319: areturn
    //   320: astore_2
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_1
    //   324: ifnull +9 -> 333
    //   327: aload_1
    //   328: invokeinterface 307 1 0
    //   333: aload_0
    //   334: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   337: aload_2
    //   338: athrow
    //   339: astore_2
    //   340: goto -17 -> 323
    //   343: astore_3
    //   344: aconst_null
    //   345: astore_2
    //   346: goto -101 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	MediaDatabaseHelper
    //   0	349	1	paramString	String
    //   29	279	2	localCursor	android.database.Cursor
    //   320	18	2	localObject1	Object
    //   339	1	2	localObject2	Object
    //   345	1	2	localObject3	Object
    //   50	187	3	localMediaScannerInfo	MediaScannerInfo
    //   244	30	3	localException1	Exception
    //   343	1	3	localException2	Exception
    //   7	311	4	localArrayList	java.util.ArrayList
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
    //   9	30	320	finally
    //   32	41	339	finally
    //   43	51	339	finally
    //   53	72	339	finally
    //   74	92	339	finally
    //   94	112	339	finally
    //   114	132	339	finally
    //   134	152	339	finally
    //   154	172	339	finally
    //   174	192	339	finally
    //   194	212	339	finally
    //   214	232	339	finally
    //   234	241	339	finally
    //   247	253	339	finally
    //   255	286	339	finally
    //   9	30	343	java/lang/Exception
  }
  
  /* Error */
  public int queryAllMediaScannerInfoCnt()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: ldc 116
    //   6: iconst_1
    //   7: anewarray 114	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc_w 285
    //   15: aastore
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 314	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: invokeinterface 325 1 0
    //   33: istore_1
    //   34: aload_3
    //   35: ifnull +9 -> 44
    //   38: aload_3
    //   39: invokeinterface 307 1 0
    //   44: aload_0
    //   45: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   48: iload_1
    //   49: ireturn
    //   50: astore 4
    //   52: aconst_null
    //   53: astore_3
    //   54: aload_3
    //   55: astore_2
    //   56: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +37 -> 96
    //   62: aload_3
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   68: iconst_2
    //   69: new 54	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 327
    //   79: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 4
    //   84: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_3
    //   97: ifnull +9 -> 106
    //   100: aload_3
    //   101: invokeinterface 307 1 0
    //   106: aload_0
    //   107: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +9 -> 125
    //   119: aload_2
    //   120: invokeinterface 307 1 0
    //   125: aload_0
    //   126: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   129: aload_3
    //   130: athrow
    //   131: astore_3
    //   132: goto -17 -> 115
    //   135: astore 4
    //   137: goto -83 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	MediaDatabaseHelper
    //   33	16	1	i	int
    //   26	94	2	localCursor1	android.database.Cursor
    //   24	77	3	localCursor2	android.database.Cursor
    //   112	18	3	localObject1	Object
    //   131	1	3	localObject2	Object
    //   50	33	4	localException1	Exception
    //   135	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	25	50	java/lang/Exception
    //   0	25	112	finally
    //   27	34	131	finally
    //   56	62	131	finally
    //   64	96	131	finally
    //   27	34	135	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerInfoMd5Set()
  {
    // Byte code:
    //   0: new 99	java/util/HashSet
    //   3: dup
    //   4: invokespecial 311	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 116
    //   15: iconst_1
    //   16: anewarray 114	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 219
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 314	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 283 1 0
    //   41: ifeq +87 -> 128
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: aload_2
    //   49: aload_2
    //   50: ldc 219
    //   52: invokeinterface 289 2 0
    //   57: invokeinterface 296 2 0
    //   62: invokevirtual 315	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: goto -33 -> 33
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +36 -> 111
    //   78: aload_2
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   84: iconst_2
    //   85: new 54	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 317
    //   95: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_2
    //   112: ifnull +9 -> 121
    //   115: aload_2
    //   116: invokeinterface 307 1 0
    //   121: aload_0
    //   122: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   125: aload 4
    //   127: areturn
    //   128: aload_2
    //   129: ifnull +9 -> 138
    //   132: aload_2
    //   133: invokeinterface 307 1 0
    //   138: aload_0
    //   139: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   142: aload 4
    //   144: areturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 307 1 0
    //   158: aload_0
    //   159: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   162: aload_2
    //   163: athrow
    //   164: astore_2
    //   165: goto -17 -> 148
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -101 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	MediaDatabaseHelper
    //   34	119	1	localCursor1	android.database.Cursor
    //   32	101	2	localCursor2	android.database.Cursor
    //   145	18	2	localObject1	Object
    //   164	1	2	localObject2	Object
    //   170	1	2	localObject3	Object
    //   69	30	3	localException1	Exception
    //   168	1	3	localException2	Exception
    //   7	136	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   35	44	69	java/lang/Exception
    //   46	66	69	java/lang/Exception
    //   9	33	145	finally
    //   35	44	164	finally
    //   46	66	164	finally
    //   72	78	164	finally
    //   80	111	164	finally
    //   9	33	168	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerInfoPathSet()
  {
    // Byte code:
    //   0: new 99	java/util/HashSet
    //   3: dup
    //   4: invokespecial 311	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 116
    //   15: iconst_1
    //   16: anewarray 114	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 182
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 314	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 283 1 0
    //   41: ifeq +87 -> 128
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: aload_2
    //   49: aload_2
    //   50: ldc 182
    //   52: invokeinterface 289 2 0
    //   57: invokeinterface 296 2 0
    //   62: invokevirtual 315	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: goto -33 -> 33
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +36 -> 111
    //   78: aload_2
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   84: iconst_2
    //   85: new 54	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 331
    //   95: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_2
    //   112: ifnull +9 -> 121
    //   115: aload_2
    //   116: invokeinterface 307 1 0
    //   121: aload_0
    //   122: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   125: aload 4
    //   127: areturn
    //   128: aload_2
    //   129: ifnull +9 -> 138
    //   132: aload_2
    //   133: invokeinterface 307 1 0
    //   138: aload_0
    //   139: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   142: aload 4
    //   144: areturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 307 1 0
    //   158: aload_0
    //   159: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   162: aload_2
    //   163: athrow
    //   164: astore_2
    //   165: goto -17 -> 148
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -101 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	MediaDatabaseHelper
    //   34	119	1	localCursor1	android.database.Cursor
    //   32	101	2	localCursor2	android.database.Cursor
    //   145	18	2	localObject1	Object
    //   164	1	2	localObject2	Object
    //   170	1	2	localObject3	Object
    //   69	30	3	localException1	Exception
    //   168	1	3	localException2	Exception
    //   7	136	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   35	44	69	java/lang/Exception
    //   46	66	69	java/lang/Exception
    //   9	33	145	finally
    //   35	44	164	finally
    //   46	66	164	finally
    //   72	78	164	finally
    //   80	111	164	finally
    //   9	33	168	java/lang/Exception
  }
  
  /* Error */
  public HashSet<String> queryAllMediaScannerInfoPathSetByFolder(String paramString)
  {
    // Byte code:
    //   0: new 99	java/util/HashSet
    //   3: dup
    //   4: invokespecial 311	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 116
    //   15: iconst_1
    //   16: anewarray 114	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 182
    //   23: aastore
    //   24: ldc 118
    //   26: iconst_1
    //   27: anewarray 114	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 314	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokeinterface 283 1 0
    //   49: ifeq +87 -> 136
    //   52: aload_2
    //   53: astore_1
    //   54: aload 4
    //   56: aload_2
    //   57: aload_2
    //   58: ldc 182
    //   60: invokeinterface 289 2 0
    //   65: invokeinterface 296 2 0
    //   70: invokevirtual 315	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -33 -> 41
    //   77: astore_3
    //   78: aload_2
    //   79: astore_1
    //   80: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +36 -> 119
    //   86: aload_2
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   92: iconst_2
    //   93: new 54	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 335
    //   103: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_3
    //   107: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_2
    //   120: ifnull +9 -> 129
    //   123: aload_2
    //   124: invokeinterface 307 1 0
    //   129: aload_0
    //   130: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   133: aload 4
    //   135: areturn
    //   136: aload_2
    //   137: ifnull +9 -> 146
    //   140: aload_2
    //   141: invokeinterface 307 1 0
    //   146: aload_0
    //   147: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   150: aload 4
    //   152: areturn
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_1
    //   156: aload_1
    //   157: ifnull +9 -> 166
    //   160: aload_1
    //   161: invokeinterface 307 1 0
    //   166: aload_0
    //   167: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   170: aload_2
    //   171: athrow
    //   172: astore_2
    //   173: goto -17 -> 156
    //   176: astore_3
    //   177: aconst_null
    //   178: astore_2
    //   179: goto -101 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	MediaDatabaseHelper
    //   0	182	1	paramString	String
    //   40	101	2	localCursor	android.database.Cursor
    //   153	18	2	localObject1	Object
    //   172	1	2	localObject2	Object
    //   178	1	2	localObject3	Object
    //   77	30	3	localException1	Exception
    //   176	1	3	localException2	Exception
    //   7	144	4	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   43	52	77	java/lang/Exception
    //   54	74	77	java/lang/Exception
    //   9	41	153	finally
    //   43	52	172	finally
    //   54	74	172	finally
    //   80	86	172	finally
    //   88	119	172	finally
    //   9	41	176	java/lang/Exception
  }
  
  /* Error */
  public MediaScannerFolderInfo queryMediaScannerFolderInfoByFolderpath(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 94	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: ldc 124
    //   6: getstatic 341	com/tencent/mobileqq/activity/photo/MediaDBValues:FOLDER_TABLE_COLUMNS	[Ljava/lang/String;
    //   9: ldc 118
    //   11: iconst_1
    //   12: anewarray 114	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 314	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 325 1 0
    //   32: ifle +184 -> 216
    //   35: aload_1
    //   36: invokeinterface 283 1 0
    //   41: pop
    //   42: new 230	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo
    //   45: dup
    //   46: invokespecial 342	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: aload_1
    //   52: aload_1
    //   53: ldc_w 285
    //   56: invokeinterface 289 2 0
    //   61: invokeinterface 293 2 0
    //   66: putfield 343	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:id	I
    //   69: aload_2
    //   70: aload_1
    //   71: aload_1
    //   72: ldc 214
    //   74: invokeinterface 289 2 0
    //   79: invokeinterface 296 2 0
    //   84: putfield 232	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:folderpath	Ljava/lang/String;
    //   87: aload_2
    //   88: aload_1
    //   89: aload_1
    //   90: ldc 200
    //   92: invokeinterface 289 2 0
    //   97: invokeinterface 300 2 0
    //   102: putfield 233	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:modifiedDate	J
    //   105: aload_1
    //   106: ifnull +9 -> 115
    //   109: aload_1
    //   110: invokeinterface 307 1 0
    //   115: aload_0
    //   116: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   119: aload_2
    //   120: areturn
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_2
    //   126: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +34 -> 163
    //   132: aload_0
    //   133: getfield 25	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:TAG	Ljava/lang/String;
    //   136: iconst_2
    //   137: new 54	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 345
    //   147: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_3
    //   151: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_1
    //   164: ifnull +9 -> 173
    //   167: aload_1
    //   168: invokeinterface 307 1 0
    //   173: aload_0
    //   174: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   177: aload_2
    //   178: areturn
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: ifnull +9 -> 192
    //   186: aload_1
    //   187: invokeinterface 307 1 0
    //   192: aload_0
    //   193: invokevirtual 134	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   196: aload_2
    //   197: athrow
    //   198: astore_2
    //   199: goto -17 -> 182
    //   202: astore_2
    //   203: goto -21 -> 182
    //   206: astore_3
    //   207: aconst_null
    //   208: astore_2
    //   209: goto -83 -> 126
    //   212: astore_3
    //   213: goto -87 -> 126
    //   216: aconst_null
    //   217: astore_2
    //   218: goto -113 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	MediaDatabaseHelper
    //   0	221	1	paramString	String
    //   49	129	2	localMediaScannerFolderInfo	MediaScannerFolderInfo
    //   179	18	2	localObject1	Object
    //   198	1	2	localObject2	Object
    //   202	1	2	localObject3	Object
    //   208	10	2	localObject4	Object
    //   121	30	3	localException1	Exception
    //   206	1	3	localException2	Exception
    //   212	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	26	121	java/lang/Exception
    //   0	26	179	finally
    //   26	50	198	finally
    //   50	105	198	finally
    //   126	163	202	finally
    //   26	50	206	java/lang/Exception
    //   50	105	212	java/lang/Exception
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
        QLog.d(this.TAG, 2, "updateMediaScnnerFolderInfo() ERROR Exception:" + paramMediaScannerFolderInfo.getMessage());
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
        QLog.d(this.TAG, 2, "updateMediaScnnerFolderInfo() ERROR Exception:" + paramString.getMessage());
      }
      return;
    }
    finally
    {
      closeDatabase();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */