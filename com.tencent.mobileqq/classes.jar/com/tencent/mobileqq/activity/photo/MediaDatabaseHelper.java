package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class MediaDatabaseHelper
  extends SQLiteOpenHelper
{
  private static final String TAG = "QQAlbum";
  private static MediaDatabaseHelper sInstance;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createDatabase error=");
        localStringBuilder.append(paramSQLiteDatabase.getMessage());
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
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
  
  /* Error */
  public void deleteMediaScannerInfoByFolderPathSet(java.util.HashSet<String> paramHashSet)
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
    //   25: ifeq +49 -> 74
    //   28: aload_1
    //   29: invokeinterface 110 1 0
    //   34: checkcast 112	java/lang/String
    //   37: astore_3
    //   38: iconst_1
    //   39: anewarray 112	java/lang/String
    //   42: astore 4
    //   44: aload 4
    //   46: iconst_0
    //   47: aload_3
    //   48: aastore
    //   49: aload_2
    //   50: ldc 114
    //   52: ldc 116
    //   54: aload 4
    //   56: invokevirtual 120	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   59: pop
    //   60: aload_2
    //   61: ldc 122
    //   63: ldc 116
    //   65: aload 4
    //   67: invokevirtual 120	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   70: pop
    //   71: goto -52 -> 19
    //   74: aload_2
    //   75: invokevirtual 125	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   78: aload_2
    //   79: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   82: aload_0
    //   83: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   86: return
    //   87: astore_1
    //   88: goto +51 -> 139
    //   91: astore_1
    //   92: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +37 -> 132
    //   98: new 50	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   105: astore_3
    //   106: aload_3
    //   107: ldc 132
    //   109: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: aload_1
    //   115: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 8
    //   124: iconst_2
    //   125: aload_3
    //   126: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_2
    //   133: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   136: goto -54 -> 82
    //   139: aload_2
    //   140: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   143: aload_0
    //   144: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +37 -> 190
    //   156: new 50	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   163: astore_2
    //   164: aload_2
    //   165: ldc 134
    //   167: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_2
    //   172: aload_1
    //   173: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 8
    //   182: iconst_2
    //   183: aload_2
    //   184: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	MediaDatabaseHelper
    //   0	191	1	paramHashSet	java.util.HashSet<String>
    //   9	175	2	localObject1	Object
    //   37	89	3	localObject2	Object
    //   42	24	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   74	78	87	finally
    //   92	132	87	finally
    //   74	78	91	java/lang/Exception
    //   5	19	149	java/lang/Exception
    //   19	44	149	java/lang/Exception
    //   49	71	149	java/lang/Exception
    //   78	82	149	java/lang/Exception
    //   82	86	149	java/lang/Exception
    //   132	136	149	java/lang/Exception
    //   139	149	149	java/lang/Exception
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
    //   25: ifeq +37 -> 62
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
    //   62: aload_2
    //   63: invokevirtual 125	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   66: aload_2
    //   67: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   70: aload_0
    //   71: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   74: return
    //   75: astore_1
    //   76: goto +51 -> 127
    //   79: astore_1
    //   80: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +37 -> 120
    //   86: new 50	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   93: astore_3
    //   94: aload_3
    //   95: ldc 155
    //   97: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_3
    //   102: aload_1
    //   103: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc 8
    //   112: iconst_2
    //   113: aload_3
    //   114: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   124: goto -54 -> 70
    //   127: aload_2
    //   128: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   131: aload_0
    //   132: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +37 -> 178
    //   144: new 50	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   151: astore_2
    //   152: aload_2
    //   153: ldc 134
    //   155: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_2
    //   160: aload_1
    //   161: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 8
    //   170: iconst_2
    //   171: aload_2
    //   172: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	MediaDatabaseHelper
    //   0	179	1	paramArrayList	java.util.ArrayList<MediaScannerInfo>
    //   9	163	2	localObject	Object
    //   93	21	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	19	75	finally
    //   19	59	75	finally
    //   62	66	75	finally
    //   80	120	75	finally
    //   14	19	79	java/lang/Exception
    //   19	59	79	java/lang/Exception
    //   62	66	79	java/lang/Exception
    //   5	14	137	java/lang/Exception
    //   66	70	137	java/lang/Exception
    //   70	74	137	java/lang/Exception
    //   120	124	137	java/lang/Exception
    //   127	137	137	java/lang/Exception
  }
  
  /* Error */
  public void deleteMediaScannerInfoByPathSet(java.util.HashSet<String> paramHashSet)
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
    //   25: ifeq +31 -> 56
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
    //   56: aload_2
    //   57: invokevirtual 125	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   60: aload_2
    //   61: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   64: aload_0
    //   65: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   68: return
    //   69: astore_1
    //   70: goto +51 -> 121
    //   73: astore_1
    //   74: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +37 -> 114
    //   80: new 50	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   87: astore_3
    //   88: aload_3
    //   89: ldc 161
    //   91: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: aload_1
    //   97: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: ldc 8
    //   106: iconst_2
    //   107: aload_3
    //   108: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_2
    //   115: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   118: goto -54 -> 64
    //   121: aload_2
    //   122: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   125: aload_0
    //   126: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +37 -> 172
    //   138: new 50	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   145: astore_2
    //   146: aload_2
    //   147: ldc 134
    //   149: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_2
    //   154: aload_1
    //   155: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: ldc 8
    //   164: iconst_2
    //   165: aload_2
    //   166: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	MediaDatabaseHelper
    //   0	173	1	paramHashSet	java.util.HashSet<String>
    //   9	157	2	localObject	Object
    //   87	21	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	19	69	finally
    //   19	53	69	finally
    //   56	60	69	finally
    //   74	114	69	finally
    //   14	19	73	java/lang/Exception
    //   19	53	73	java/lang/Exception
    //   56	60	73	java/lang/Exception
    //   5	14	131	java/lang/Exception
    //   60	64	131	java/lang/Exception
    //   64	68	131	java/lang/Exception
    //   114	118	131	java/lang/Exception
    //   121	131	131	java/lang/Exception
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
  
  /* Error */
  public void insertMediaScannerInfo(MediaScannerInfo paramMediaScannerInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: new 169	android/content/ContentValues
    //   13: dup
    //   14: invokespecial 170	android/content/ContentValues:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc 172
    //   21: aload_1
    //   22: getfield 174	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   25: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_3
    //   29: ldc 180
    //   31: aload_1
    //   32: getfield 182	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   35: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: ldc 184
    //   41: aload_1
    //   42: getfield 188	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   45: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   51: aload_3
    //   52: ldc 198
    //   54: aload_1
    //   55: getfield 201	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   58: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   64: aload_3
    //   65: ldc 203
    //   67: aload_1
    //   68: getfield 205	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   71: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   74: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   77: aload_3
    //   78: ldc 207
    //   80: aload_1
    //   81: getfield 210	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   84: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_3
    //   88: ldc 212
    //   90: aload_1
    //   91: getfield 215	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   94: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_3
    //   98: ldc 217
    //   100: aload_1
    //   101: getfield 219	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   104: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_2
    //   108: ldc 114
    //   110: aconst_null
    //   111: aload_3
    //   112: invokevirtual 223	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   115: pop2
    //   116: goto +48 -> 164
    //   119: astore_1
    //   120: goto +49 -> 169
    //   123: astore_1
    //   124: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +37 -> 164
    //   130: new 50	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   137: astore_2
    //   138: aload_2
    //   139: ldc 161
    //   141: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: aload_1
    //   147: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: ldc 8
    //   156: iconst_2
    //   157: aload_2
    //   158: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   168: return
    //   169: aload_0
    //   170: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	MediaDatabaseHelper
    //   0	175	1	paramMediaScannerInfo	MediaScannerInfo
    //   9	149	2	localObject	Object
    //   17	95	3	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   5	116	119	finally
    //   124	164	119	finally
    //   5	116	123	java/lang/Exception
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
    //   25: ifeq +132 -> 157
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
    //   157: aload_2
    //   158: invokevirtual 125	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   161: aload_2
    //   162: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   165: aload_0
    //   166: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   169: return
    //   170: astore_1
    //   171: goto +51 -> 222
    //   174: astore_1
    //   175: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +37 -> 215
    //   181: new 50	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: ldc 161
    //   192: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_3
    //   197: aload_1
    //   198: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 8
    //   207: iconst_2
    //   208: aload_3
    //   209: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_2
    //   216: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   219: goto -54 -> 165
    //   222: aload_2
    //   223: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   226: aload_0
    //   227: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +37 -> 273
    //   239: new 50	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   246: astore_2
    //   247: aload_2
    //   248: ldc 134
    //   250: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_2
    //   255: aload_1
    //   256: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   259: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 8
    //   265: iconst_2
    //   266: aload_2
    //   267: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	MediaDatabaseHelper
    //   0	274	1	paramArrayList	java.util.ArrayList<MediaScannerInfo>
    //   9	258	2	localObject1	Object
    //   37	172	3	localObject2	Object
    //   45	104	4	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   14	19	170	finally
    //   19	154	170	finally
    //   157	161	170	finally
    //   175	215	170	finally
    //   14	19	174	java/lang/Exception
    //   19	154	174	java/lang/Exception
    //   157	161	174	java/lang/Exception
    //   5	14	232	java/lang/Exception
    //   161	165	232	java/lang/Exception
    //   165	169	232	java/lang/Exception
    //   215	219	232	java/lang/Exception
    //   222	232	232	java/lang/Exception
  }
  
  /* Error */
  public void insertMediaScnnerFolderInfo(MediaScannerFolderInfo paramMediaScannerFolderInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: new 169	android/content/ContentValues
    //   13: dup
    //   14: invokespecial 170	android/content/ContentValues:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc 212
    //   21: aload_1
    //   22: getfield 230	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:folderpath	Ljava/lang/String;
    //   25: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_3
    //   29: ldc 198
    //   31: aload_1
    //   32: getfield 231	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:modifiedDate	J
    //   35: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   41: aload_2
    //   42: ldc 122
    //   44: aconst_null
    //   45: aload_3
    //   46: invokevirtual 223	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   49: pop2
    //   50: goto +48 -> 98
    //   53: astore_1
    //   54: goto +49 -> 103
    //   57: astore_1
    //   58: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +37 -> 98
    //   64: new 50	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: ldc 233
    //   75: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 8
    //   90: iconst_2
    //   91: aload_2
    //   92: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_0
    //   99: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   102: return
    //   103: aload_0
    //   104: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	MediaDatabaseHelper
    //   0	109	1	paramMediaScannerFolderInfo	MediaScannerFolderInfo
    //   9	83	2	localObject	Object
    //   17	29	3	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   5	50	53	finally
    //   58	98	53	finally
    //   5	50	57	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "onCreate");
    }
    createDatabase(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDowngrade oldVersion=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", newVersion=");
      localStringBuilder.append(paramInt2);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    if (paramInt1 == paramInt2) {
      return;
    }
    try
    {
      paramSQLiteDatabase.execSQL("drop table if exists folder_table");
      paramSQLiteDatabase.execSQL("drop table if exists content_table");
      createDatabase(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDowngrade error=");
        localStringBuilder.append(paramSQLiteDatabase.getMessage());
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpgrade oldVersion=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", newVersion=");
      localStringBuilder.append(paramInt2);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    if (paramInt1 == paramInt2) {
      return;
    }
    try
    {
      paramSQLiteDatabase.execSQL("drop table if exists folder_table");
      paramSQLiteDatabase.execSQL("drop table if exists content_table");
      createDatabase(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpgrade error=");
        localStringBuilder.append(paramSQLiteDatabase.getMessage());
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
    }
  }
  
  /* Error */
  public java.util.ArrayList<MediaScannerInfo> queryAllLongVideoMediaScannerInfo(String paramString)
  {
    // Byte code:
    //   0: new 140	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 260	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 114
    //   19: getstatic 266	com/tencent/mobileqq/activity/photo/MediaDBValues:CONTENT_TABLE_COLUMNS	[Ljava/lang/String;
    //   22: ldc_w 268
    //   25: iconst_1
    //   26: anewarray 112	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 270
    //   34: aastore
    //   35: aconst_null
    //   36: aconst_null
    //   37: ldc_w 272
    //   40: aload_1
    //   41: invokevirtual 276	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: invokeinterface 281 1 0
    //   55: ifeq +239 -> 294
    //   58: aload_1
    //   59: astore_3
    //   60: aload_1
    //   61: astore_2
    //   62: new 145	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   65: dup
    //   66: invokespecial 282	com/tencent/mobileqq/activity/photo/MediaScannerInfo:<init>	()V
    //   69: astore 5
    //   71: aload_1
    //   72: astore_3
    //   73: aload_1
    //   74: astore_2
    //   75: aload 5
    //   77: aload_1
    //   78: aload_1
    //   79: ldc_w 283
    //   82: invokeinterface 287 2 0
    //   87: invokeinterface 291 2 0
    //   92: putfield 149	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   95: aload_1
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: aload 5
    //   101: aload_1
    //   102: aload_1
    //   103: ldc 172
    //   105: invokeinterface 287 2 0
    //   110: invokeinterface 294 2 0
    //   115: putfield 174	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   118: aload_1
    //   119: astore_3
    //   120: aload_1
    //   121: astore_2
    //   122: aload 5
    //   124: aload_1
    //   125: aload_1
    //   126: ldc 180
    //   128: invokeinterface 287 2 0
    //   133: invokeinterface 294 2 0
    //   138: putfield 182	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   141: aload_1
    //   142: astore_3
    //   143: aload_1
    //   144: astore_2
    //   145: aload 5
    //   147: aload_1
    //   148: aload_1
    //   149: ldc 184
    //   151: invokeinterface 287 2 0
    //   156: invokeinterface 298 2 0
    //   161: putfield 188	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   164: aload_1
    //   165: astore_3
    //   166: aload_1
    //   167: astore_2
    //   168: aload 5
    //   170: aload_1
    //   171: aload_1
    //   172: ldc 198
    //   174: invokeinterface 287 2 0
    //   179: invokeinterface 298 2 0
    //   184: putfield 201	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   187: aload_1
    //   188: astore_3
    //   189: aload_1
    //   190: astore_2
    //   191: aload 5
    //   193: aload_1
    //   194: aload_1
    //   195: ldc 203
    //   197: invokeinterface 287 2 0
    //   202: invokeinterface 298 2 0
    //   207: putfield 205	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   210: aload_1
    //   211: astore_3
    //   212: aload_1
    //   213: astore_2
    //   214: aload 5
    //   216: aload_1
    //   217: aload_1
    //   218: ldc 207
    //   220: invokeinterface 287 2 0
    //   225: invokeinterface 294 2 0
    //   230: putfield 210	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   233: aload_1
    //   234: astore_3
    //   235: aload_1
    //   236: astore_2
    //   237: aload 5
    //   239: aload_1
    //   240: aload_1
    //   241: ldc 212
    //   243: invokeinterface 287 2 0
    //   248: invokeinterface 294 2 0
    //   253: putfield 215	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   256: aload_1
    //   257: astore_3
    //   258: aload_1
    //   259: astore_2
    //   260: aload 5
    //   262: aload_1
    //   263: aload_1
    //   264: ldc 217
    //   266: invokeinterface 287 2 0
    //   271: invokeinterface 294 2 0
    //   276: putfield 219	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   279: aload_1
    //   280: astore_3
    //   281: aload_1
    //   282: astore_2
    //   283: aload 4
    //   285: aload 5
    //   287: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   290: pop
    //   291: goto -246 -> 45
    //   294: aload_1
    //   295: ifnull +78 -> 373
    //   298: goto +69 -> 367
    //   301: astore_1
    //   302: goto +78 -> 380
    //   305: astore_1
    //   306: aload_2
    //   307: astore_3
    //   308: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +50 -> 361
    //   314: aload_2
    //   315: astore_3
    //   316: new 50	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   323: astore 5
    //   325: aload_2
    //   326: astore_3
    //   327: aload 5
    //   329: ldc_w 304
    //   332: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_2
    //   337: astore_3
    //   338: aload 5
    //   340: aload_1
    //   341: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_2
    //   349: astore_3
    //   350: ldc 8
    //   352: iconst_2
    //   353: aload 5
    //   355: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_2
    //   362: ifnull +11 -> 373
    //   365: aload_2
    //   366: astore_1
    //   367: aload_1
    //   368: invokeinterface 305 1 0
    //   373: aload_0
    //   374: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   377: aload 4
    //   379: areturn
    //   380: aload_3
    //   381: ifnull +9 -> 390
    //   384: aload_3
    //   385: invokeinterface 305 1 0
    //   390: aload_0
    //   391: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   394: goto +5 -> 399
    //   397: aload_1
    //   398: athrow
    //   399: goto -2 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	MediaDatabaseHelper
    //   0	402	1	paramString	String
    //   10	356	2	str1	String
    //   12	373	3	str2	String
    //   7	371	4	localArrayList	java.util.ArrayList
    //   69	285	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	45	301	finally
    //   49	58	301	finally
    //   62	71	301	finally
    //   75	95	301	finally
    //   99	118	301	finally
    //   122	141	301	finally
    //   145	164	301	finally
    //   168	187	301	finally
    //   191	210	301	finally
    //   214	233	301	finally
    //   237	256	301	finally
    //   260	279	301	finally
    //   283	291	301	finally
    //   308	314	301	finally
    //   316	325	301	finally
    //   327	336	301	finally
    //   338	348	301	finally
    //   350	361	301	finally
    //   13	45	305	java/lang/Exception
    //   49	58	305	java/lang/Exception
    //   62	71	305	java/lang/Exception
    //   75	95	305	java/lang/Exception
    //   99	118	305	java/lang/Exception
    //   122	141	305	java/lang/Exception
    //   145	164	305	java/lang/Exception
    //   168	187	305	java/lang/Exception
    //   191	210	305	java/lang/Exception
    //   214	233	305	java/lang/Exception
    //   237	256	305	java/lang/Exception
    //   260	279	305	java/lang/Exception
    //   283	291	305	java/lang/Exception
  }
  
  /* Error */
  public java.util.HashSet<String> queryAllMediaScannerFolderPathSet()
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 122
    //   19: iconst_1
    //   20: anewarray 112	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 212
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: invokeinterface 281 1 0
    //   47: ifeq +30 -> 77
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: astore_1
    //   54: aload 4
    //   56: aload_3
    //   57: aload_3
    //   58: ldc 212
    //   60: invokeinterface 287 2 0
    //   65: invokeinterface 294 2 0
    //   70: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -37 -> 37
    //   77: aload_3
    //   78: ifnull +78 -> 156
    //   81: aload_3
    //   82: astore_1
    //   83: goto +67 -> 150
    //   86: astore_1
    //   87: goto +76 -> 163
    //   90: astore_3
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +50 -> 146
    //   99: aload_1
    //   100: astore_2
    //   101: new 50	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   108: astore 5
    //   110: aload_1
    //   111: astore_2
    //   112: aload 5
    //   114: ldc_w 315
    //   117: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: astore_2
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: astore_2
    //   135: ldc 8
    //   137: iconst_2
    //   138: aload 5
    //   140: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_1
    //   147: ifnull +9 -> 156
    //   150: aload_1
    //   151: invokeinterface 305 1 0
    //   156: aload_0
    //   157: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   160: aload 4
    //   162: areturn
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 305 1 0
    //   173: aload_0
    //   174: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   177: goto +5 -> 182
    //   180: aload_1
    //   181: athrow
    //   182: goto -2 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	MediaDatabaseHelper
    //   10	73	1	localObject1	Object
    //   86	95	1	localObject2	Object
    //   12	156	2	localObject3	Object
    //   36	46	3	localCursor	android.database.Cursor
    //   90	36	3	localException	Exception
    //   7	154	4	localHashSet	java.util.HashSet
    //   108	31	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	37	86	finally
    //   41	50	86	finally
    //   54	74	86	finally
    //   93	99	86	finally
    //   101	110	86	finally
    //   112	121	86	finally
    //   123	133	86	finally
    //   135	146	86	finally
    //   13	37	90	java/lang/Exception
    //   41	50	90	java/lang/Exception
    //   54	74	90	java/lang/Exception
  }
  
  /* Error */
  public java.util.ArrayList<MediaScannerInfo> queryAllMediaScannerInfo(String paramString)
  {
    // Byte code:
    //   0: new 140	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 260	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 114
    //   19: getstatic 266	com/tencent/mobileqq/activity/photo/MediaDBValues:CONTENT_TABLE_COLUMNS	[Ljava/lang/String;
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: ldc_w 272
    //   29: aload_1
    //   30: invokevirtual 276	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_1
    //   34: aload_1
    //   35: astore_3
    //   36: aload_1
    //   37: astore_2
    //   38: aload_1
    //   39: invokeinterface 281 1 0
    //   44: ifeq +239 -> 283
    //   47: aload_1
    //   48: astore_3
    //   49: aload_1
    //   50: astore_2
    //   51: new 145	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   54: dup
    //   55: invokespecial 282	com/tencent/mobileqq/activity/photo/MediaScannerInfo:<init>	()V
    //   58: astore 5
    //   60: aload_1
    //   61: astore_3
    //   62: aload_1
    //   63: astore_2
    //   64: aload 5
    //   66: aload_1
    //   67: aload_1
    //   68: ldc_w 283
    //   71: invokeinterface 287 2 0
    //   76: invokeinterface 291 2 0
    //   81: putfield 149	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   84: aload_1
    //   85: astore_3
    //   86: aload_1
    //   87: astore_2
    //   88: aload 5
    //   90: aload_1
    //   91: aload_1
    //   92: ldc 172
    //   94: invokeinterface 287 2 0
    //   99: invokeinterface 294 2 0
    //   104: putfield 174	com/tencent/mobileqq/activity/photo/MediaScannerInfo:name	Ljava/lang/String;
    //   107: aload_1
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: aload 5
    //   113: aload_1
    //   114: aload_1
    //   115: ldc 180
    //   117: invokeinterface 287 2 0
    //   122: invokeinterface 294 2 0
    //   127: putfield 182	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   130: aload_1
    //   131: astore_3
    //   132: aload_1
    //   133: astore_2
    //   134: aload 5
    //   136: aload_1
    //   137: aload_1
    //   138: ldc 184
    //   140: invokeinterface 287 2 0
    //   145: invokeinterface 298 2 0
    //   150: putfield 188	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   153: aload_1
    //   154: astore_3
    //   155: aload_1
    //   156: astore_2
    //   157: aload 5
    //   159: aload_1
    //   160: aload_1
    //   161: ldc 198
    //   163: invokeinterface 287 2 0
    //   168: invokeinterface 298 2 0
    //   173: putfield 201	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   176: aload_1
    //   177: astore_3
    //   178: aload_1
    //   179: astore_2
    //   180: aload 5
    //   182: aload_1
    //   183: aload_1
    //   184: ldc 203
    //   186: invokeinterface 287 2 0
    //   191: invokeinterface 298 2 0
    //   196: putfield 205	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   199: aload_1
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: aload 5
    //   205: aload_1
    //   206: aload_1
    //   207: ldc 207
    //   209: invokeinterface 287 2 0
    //   214: invokeinterface 294 2 0
    //   219: putfield 210	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   222: aload_1
    //   223: astore_3
    //   224: aload_1
    //   225: astore_2
    //   226: aload 5
    //   228: aload_1
    //   229: aload_1
    //   230: ldc 212
    //   232: invokeinterface 287 2 0
    //   237: invokeinterface 294 2 0
    //   242: putfield 215	com/tencent/mobileqq/activity/photo/MediaScannerInfo:folderPath	Ljava/lang/String;
    //   245: aload_1
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload 5
    //   251: aload_1
    //   252: aload_1
    //   253: ldc 217
    //   255: invokeinterface 287 2 0
    //   260: invokeinterface 294 2 0
    //   265: putfield 219	com/tencent/mobileqq/activity/photo/MediaScannerInfo:md5	Ljava/lang/String;
    //   268: aload_1
    //   269: astore_3
    //   270: aload_1
    //   271: astore_2
    //   272: aload 4
    //   274: aload 5
    //   276: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   279: pop
    //   280: goto -246 -> 34
    //   283: aload_1
    //   284: ifnull +78 -> 362
    //   287: goto +69 -> 356
    //   290: astore_1
    //   291: goto +78 -> 369
    //   294: astore_1
    //   295: aload_2
    //   296: astore_3
    //   297: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +50 -> 350
    //   303: aload_2
    //   304: astore_3
    //   305: new 50	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   312: astore 5
    //   314: aload_2
    //   315: astore_3
    //   316: aload 5
    //   318: ldc_w 319
    //   321: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_2
    //   326: astore_3
    //   327: aload 5
    //   329: aload_1
    //   330: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_2
    //   338: astore_3
    //   339: ldc 8
    //   341: iconst_2
    //   342: aload 5
    //   344: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload_2
    //   351: ifnull +11 -> 362
    //   354: aload_2
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 305 1 0
    //   362: aload_0
    //   363: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   366: aload 4
    //   368: areturn
    //   369: aload_3
    //   370: ifnull +9 -> 379
    //   373: aload_3
    //   374: invokeinterface 305 1 0
    //   379: aload_0
    //   380: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   383: goto +5 -> 388
    //   386: aload_1
    //   387: athrow
    //   388: goto -2 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	MediaDatabaseHelper
    //   0	391	1	paramString	String
    //   10	345	2	str1	String
    //   12	362	3	str2	String
    //   7	360	4	localArrayList	java.util.ArrayList
    //   58	285	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	34	290	finally
    //   38	47	290	finally
    //   51	60	290	finally
    //   64	84	290	finally
    //   88	107	290	finally
    //   111	130	290	finally
    //   134	153	290	finally
    //   157	176	290	finally
    //   180	199	290	finally
    //   203	222	290	finally
    //   226	245	290	finally
    //   249	268	290	finally
    //   272	280	290	finally
    //   297	303	290	finally
    //   305	314	290	finally
    //   316	325	290	finally
    //   327	337	290	finally
    //   339	350	290	finally
    //   13	34	294	java/lang/Exception
    //   38	47	294	java/lang/Exception
    //   51	60	294	java/lang/Exception
    //   64	84	294	java/lang/Exception
    //   88	107	294	java/lang/Exception
    //   111	130	294	java/lang/Exception
    //   134	153	294	java/lang/Exception
    //   157	176	294	java/lang/Exception
    //   180	199	294	java/lang/Exception
    //   203	222	294	java/lang/Exception
    //   226	245	294	java/lang/Exception
    //   249	268	294	java/lang/Exception
    //   272	280	294	java/lang/Exception
  }
  
  /* Error */
  public int queryAllMediaScannerInfoCnt()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc 114
    //   16: iconst_1
    //   17: anewarray 112	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w 283
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 6
    //   36: aload 6
    //   38: astore 5
    //   40: aload 6
    //   42: astore 4
    //   44: aload 6
    //   46: invokeinterface 323 1 0
    //   51: istore_2
    //   52: iload_2
    //   53: istore_1
    //   54: aload 6
    //   56: ifnull +99 -> 155
    //   59: iload_2
    //   60: istore_1
    //   61: aload 6
    //   63: astore 4
    //   65: goto +83 -> 148
    //   68: astore 4
    //   70: goto +91 -> 161
    //   73: astore 6
    //   75: aload 4
    //   77: astore 5
    //   79: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +59 -> 141
    //   85: aload 4
    //   87: astore 5
    //   89: new 50	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   96: astore 7
    //   98: aload 4
    //   100: astore 5
    //   102: aload 7
    //   104: ldc_w 325
    //   107: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: astore 5
    //   115: aload 7
    //   117: aload 6
    //   119: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 4
    //   128: astore 5
    //   130: ldc 8
    //   132: iconst_2
    //   133: aload 7
    //   135: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 4
    //   143: ifnull +12 -> 155
    //   146: iload_3
    //   147: istore_1
    //   148: aload 4
    //   150: invokeinterface 305 1 0
    //   155: aload_0
    //   156: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   159: iload_1
    //   160: ireturn
    //   161: aload 5
    //   163: ifnull +10 -> 173
    //   166: aload 5
    //   168: invokeinterface 305 1 0
    //   173: aload_0
    //   174: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   177: aload 4
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	MediaDatabaseHelper
    //   1	159	1	i	int
    //   51	9	2	j	int
    //   3	144	3	k	int
    //   5	59	4	localObject1	Object
    //   68	110	4	localObject2	Object
    //   8	159	5	localObject3	Object
    //   34	28	6	localCursor	android.database.Cursor
    //   73	45	6	localException	Exception
    //   96	38	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	36	68	finally
    //   44	52	68	finally
    //   79	85	68	finally
    //   89	98	68	finally
    //   102	111	68	finally
    //   115	126	68	finally
    //   130	141	68	finally
    //   10	36	73	java/lang/Exception
    //   44	52	73	java/lang/Exception
  }
  
  /* Error */
  public java.util.HashSet<String> queryAllMediaScannerInfoMd5Set()
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 114
    //   19: iconst_1
    //   20: anewarray 112	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 217
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: invokeinterface 281 1 0
    //   47: ifeq +30 -> 77
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: astore_1
    //   54: aload 4
    //   56: aload_3
    //   57: aload_3
    //   58: ldc 217
    //   60: invokeinterface 287 2 0
    //   65: invokeinterface 294 2 0
    //   70: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -37 -> 37
    //   77: aload_3
    //   78: ifnull +78 -> 156
    //   81: aload_3
    //   82: astore_1
    //   83: goto +67 -> 150
    //   86: astore_1
    //   87: goto +76 -> 163
    //   90: astore_3
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +50 -> 146
    //   99: aload_1
    //   100: astore_2
    //   101: new 50	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   108: astore 5
    //   110: aload_1
    //   111: astore_2
    //   112: aload 5
    //   114: ldc_w 315
    //   117: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: astore_2
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: astore_2
    //   135: ldc 8
    //   137: iconst_2
    //   138: aload 5
    //   140: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_1
    //   147: ifnull +9 -> 156
    //   150: aload_1
    //   151: invokeinterface 305 1 0
    //   156: aload_0
    //   157: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   160: aload 4
    //   162: areturn
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 305 1 0
    //   173: aload_0
    //   174: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   177: goto +5 -> 182
    //   180: aload_1
    //   181: athrow
    //   182: goto -2 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	MediaDatabaseHelper
    //   10	73	1	localObject1	Object
    //   86	95	1	localObject2	Object
    //   12	156	2	localObject3	Object
    //   36	46	3	localCursor	android.database.Cursor
    //   90	36	3	localException	Exception
    //   7	154	4	localHashSet	java.util.HashSet
    //   108	31	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	37	86	finally
    //   41	50	86	finally
    //   54	74	86	finally
    //   93	99	86	finally
    //   101	110	86	finally
    //   112	121	86	finally
    //   123	133	86	finally
    //   135	146	86	finally
    //   13	37	90	java/lang/Exception
    //   41	50	90	java/lang/Exception
    //   54	74	90	java/lang/Exception
  }
  
  /* Error */
  public java.util.HashSet<String> queryAllMediaScannerInfoPathSet()
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 114
    //   19: iconst_1
    //   20: anewarray 112	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 180
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: invokeinterface 281 1 0
    //   47: ifeq +30 -> 77
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: astore_1
    //   54: aload 4
    //   56: aload_3
    //   57: aload_3
    //   58: ldc 180
    //   60: invokeinterface 287 2 0
    //   65: invokeinterface 294 2 0
    //   70: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -37 -> 37
    //   77: aload_3
    //   78: ifnull +78 -> 156
    //   81: aload_3
    //   82: astore_1
    //   83: goto +67 -> 150
    //   86: astore_1
    //   87: goto +76 -> 163
    //   90: astore_3
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +50 -> 146
    //   99: aload_1
    //   100: astore_2
    //   101: new 50	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   108: astore 5
    //   110: aload_1
    //   111: astore_2
    //   112: aload 5
    //   114: ldc_w 329
    //   117: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: astore_2
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: astore_2
    //   135: ldc 8
    //   137: iconst_2
    //   138: aload 5
    //   140: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_1
    //   147: ifnull +9 -> 156
    //   150: aload_1
    //   151: invokeinterface 305 1 0
    //   156: aload_0
    //   157: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   160: aload 4
    //   162: areturn
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 305 1 0
    //   173: aload_0
    //   174: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   177: goto +5 -> 182
    //   180: aload_1
    //   181: athrow
    //   182: goto -2 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	MediaDatabaseHelper
    //   10	73	1	localObject1	Object
    //   86	95	1	localObject2	Object
    //   12	156	2	localObject3	Object
    //   36	46	3	localCursor	android.database.Cursor
    //   90	36	3	localException	Exception
    //   7	154	4	localHashSet	java.util.HashSet
    //   108	31	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	37	86	finally
    //   41	50	86	finally
    //   54	74	86	finally
    //   93	99	86	finally
    //   101	110	86	finally
    //   112	121	86	finally
    //   123	133	86	finally
    //   135	146	86	finally
    //   13	37	90	java/lang/Exception
    //   41	50	90	java/lang/Exception
    //   54	74	90	java/lang/Exception
  }
  
  /* Error */
  public java.util.HashSet<String> queryAllMediaScannerInfoPathSetByFolder(String paramString)
  {
    // Byte code:
    //   0: new 97	java/util/HashSet
    //   3: dup
    //   4: invokespecial 309	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 114
    //   19: iconst_1
    //   20: anewarray 112	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 180
    //   27: aastore
    //   28: ldc 116
    //   30: iconst_1
    //   31: anewarray 112	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: aastore
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: invokeinterface 281 1 0
    //   55: ifeq +30 -> 85
    //   58: aload_1
    //   59: astore_3
    //   60: aload_1
    //   61: astore_2
    //   62: aload 4
    //   64: aload_1
    //   65: aload_1
    //   66: ldc 180
    //   68: invokeinterface 287 2 0
    //   73: invokeinterface 294 2 0
    //   78: invokevirtual 313	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: goto -37 -> 45
    //   85: aload_1
    //   86: ifnull +78 -> 164
    //   89: goto +69 -> 158
    //   92: astore_1
    //   93: goto +78 -> 171
    //   96: astore_1
    //   97: aload_2
    //   98: astore_3
    //   99: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +50 -> 152
    //   105: aload_2
    //   106: astore_3
    //   107: new 50	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   114: astore 5
    //   116: aload_2
    //   117: astore_3
    //   118: aload 5
    //   120: ldc_w 333
    //   123: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_2
    //   128: astore_3
    //   129: aload 5
    //   131: aload_1
    //   132: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: astore_3
    //   141: ldc 8
    //   143: iconst_2
    //   144: aload 5
    //   146: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_2
    //   153: ifnull +11 -> 164
    //   156: aload_2
    //   157: astore_1
    //   158: aload_1
    //   159: invokeinterface 305 1 0
    //   164: aload_0
    //   165: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   168: aload 4
    //   170: areturn
    //   171: aload_3
    //   172: ifnull +9 -> 181
    //   175: aload_3
    //   176: invokeinterface 305 1 0
    //   181: aload_0
    //   182: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   185: goto +5 -> 190
    //   188: aload_1
    //   189: athrow
    //   190: goto -2 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	MediaDatabaseHelper
    //   0	193	1	paramString	String
    //   10	147	2	str1	String
    //   12	164	3	str2	String
    //   7	162	4	localHashSet	java.util.HashSet
    //   114	31	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	45	92	finally
    //   49	58	92	finally
    //   62	82	92	finally
    //   99	105	92	finally
    //   107	116	92	finally
    //   118	127	92	finally
    //   129	139	92	finally
    //   141	152	92	finally
    //   13	45	96	java/lang/Exception
    //   49	58	96	java/lang/Exception
    //   62	82	96	java/lang/Exception
  }
  
  /* Error */
  public MediaScannerFolderInfo queryMediaScannerFolderInfoByFolderpath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: ldc 122
    //   8: getstatic 339	com/tencent/mobileqq/activity/photo/MediaDBValues:FOLDER_TABLE_COLUMNS	[Ljava/lang/String;
    //   11: ldc 116
    //   13: iconst_1
    //   14: anewarray 112	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 312	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 4
    //   29: aload 4
    //   31: astore_1
    //   32: aload 4
    //   34: invokeinterface 323 1 0
    //   39: ifle +104 -> 143
    //   42: aload 4
    //   44: astore_1
    //   45: aload 4
    //   47: invokeinterface 281 1 0
    //   52: pop
    //   53: aload 4
    //   55: astore_1
    //   56: new 228	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo
    //   59: dup
    //   60: invokespecial 340	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:<init>	()V
    //   63: astore_3
    //   64: aload 4
    //   66: astore_1
    //   67: aload_3
    //   68: aload 4
    //   70: aload 4
    //   72: ldc_w 283
    //   75: invokeinterface 287 2 0
    //   80: invokeinterface 291 2 0
    //   85: putfield 341	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:id	I
    //   88: aload 4
    //   90: astore_1
    //   91: aload_3
    //   92: aload 4
    //   94: aload 4
    //   96: ldc 212
    //   98: invokeinterface 287 2 0
    //   103: invokeinterface 294 2 0
    //   108: putfield 230	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:folderpath	Ljava/lang/String;
    //   111: aload 4
    //   113: astore_1
    //   114: aload_3
    //   115: aload 4
    //   117: aload 4
    //   119: ldc 198
    //   121: invokeinterface 287 2 0
    //   126: invokeinterface 298 2 0
    //   131: putfield 231	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:modifiedDate	J
    //   134: aload_3
    //   135: astore_2
    //   136: goto +7 -> 143
    //   139: astore_2
    //   140: goto +39 -> 179
    //   143: aload 4
    //   145: ifnull +10 -> 155
    //   148: aload 4
    //   150: invokeinterface 305 1 0
    //   155: aload_0
    //   156: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   159: aload_2
    //   160: areturn
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_3
    //   164: goto +15 -> 179
    //   167: astore_1
    //   168: aconst_null
    //   169: astore_2
    //   170: goto +92 -> 262
    //   173: astore_2
    //   174: aconst_null
    //   175: astore_3
    //   176: aload_3
    //   177: astore 4
    //   179: aload 4
    //   181: astore_1
    //   182: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +54 -> 239
    //   188: aload 4
    //   190: astore_1
    //   191: new 50	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   198: astore 5
    //   200: aload 4
    //   202: astore_1
    //   203: aload 5
    //   205: ldc_w 343
    //   208: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 4
    //   214: astore_1
    //   215: aload 5
    //   217: aload_2
    //   218: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: astore_1
    //   228: ldc 8
    //   230: iconst_2
    //   231: aload 5
    //   233: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload 4
    //   241: ifnull +10 -> 251
    //   244: aload 4
    //   246: invokeinterface 305 1 0
    //   251: aload_0
    //   252: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   255: aload_3
    //   256: areturn
    //   257: astore_3
    //   258: aload_1
    //   259: astore_2
    //   260: aload_3
    //   261: astore_1
    //   262: aload_2
    //   263: ifnull +9 -> 272
    //   266: aload_2
    //   267: invokeinterface 305 1 0
    //   272: aload_0
    //   273: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   276: aload_1
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	MediaDatabaseHelper
    //   0	278	1	paramString	String
    //   1	135	2	localObject1	Object
    //   139	21	2	localException1	Exception
    //   161	1	2	localException2	Exception
    //   169	1	2	localObject2	Object
    //   173	45	2	localException3	Exception
    //   259	8	2	str	String
    //   63	193	3	localMediaScannerFolderInfo	MediaScannerFolderInfo
    //   257	4	3	localObject3	Object
    //   27	218	4	localObject4	Object
    //   198	34	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	88	139	java/lang/Exception
    //   91	111	139	java/lang/Exception
    //   114	134	139	java/lang/Exception
    //   32	42	161	java/lang/Exception
    //   45	53	161	java/lang/Exception
    //   56	64	161	java/lang/Exception
    //   2	29	167	finally
    //   2	29	173	java/lang/Exception
    //   32	42	257	finally
    //   45	53	257	finally
    //   56	64	257	finally
    //   67	88	257	finally
    //   91	111	257	finally
    //   114	134	257	finally
    //   182	188	257	finally
    //   191	200	257	finally
    //   203	212	257	finally
    //   215	225	257	finally
    //   228	239	257	finally
  }
  
  /* Error */
  public void updateMediaScnnerFolderInfo(MediaScannerFolderInfo paramMediaScannerFolderInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: new 169	android/content/ContentValues
    //   13: dup
    //   14: invokespecial 170	android/content/ContentValues:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc 198
    //   21: aload_1
    //   22: getfield 231	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:modifiedDate	J
    //   25: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   31: aload_2
    //   32: ldc 122
    //   34: aload_3
    //   35: ldc 116
    //   37: iconst_1
    //   38: anewarray 112	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: getfield 230	com/tencent/mobileqq/activity/photo/MediaScannerFolderInfo:folderpath	Ljava/lang/String;
    //   47: aastore
    //   48: invokevirtual 348	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   51: pop
    //   52: goto +49 -> 101
    //   55: astore_1
    //   56: goto +50 -> 106
    //   59: astore_1
    //   60: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +38 -> 101
    //   66: new 50	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   73: astore_2
    //   74: aload_2
    //   75: ldc_w 350
    //   78: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: aload_1
    //   84: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: ldc 8
    //   93: iconst_2
    //   94: aload_2
    //   95: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   105: return
    //   106: aload_0
    //   107: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	MediaDatabaseHelper
    //   0	112	1	paramMediaScannerFolderInfo	MediaScannerFolderInfo
    //   9	86	2	localObject	Object
    //   17	18	3	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   5	52	55	finally
    //   60	101	55	finally
    //   5	52	59	java/lang/Exception
  }
  
  /* Error */
  public void updateMediaScnnerInfoDuration(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 92	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 4
    //   6: new 169	android/content/ContentValues
    //   9: dup
    //   10: invokespecial 170	android/content/ContentValues:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc 203
    //   19: lload_2
    //   20: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: invokevirtual 196	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   26: aload 4
    //   28: ldc 114
    //   30: aload 5
    //   32: ldc 159
    //   34: iconst_1
    //   35: anewarray 112	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: invokevirtual 348	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   45: pop
    //   46: goto +53 -> 99
    //   49: astore_1
    //   50: goto +54 -> 104
    //   53: astore_1
    //   54: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +42 -> 99
    //   60: new 50	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   67: astore 4
    //   69: aload 4
    //   71: ldc_w 350
    //   74: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 8
    //   90: iconst_2
    //   91: aload 4
    //   93: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   103: return
    //   104: aload_0
    //   105: invokevirtual 130	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:closeDatabase	()V
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	MediaDatabaseHelper
    //   0	110	1	paramString	String
    //   0	110	2	paramLong	long
    //   4	88	4	localObject	Object
    //   13	18	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   0	46	49	finally
    //   54	99	49	finally
    //   0	46	53	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */