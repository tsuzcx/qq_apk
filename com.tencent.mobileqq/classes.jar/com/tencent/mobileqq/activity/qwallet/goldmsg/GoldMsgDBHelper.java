package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public final class GoldMsgDBHelper
  extends SQLiteOpenHelper
{
  public GoldMsgDBHelper(Context paramContext)
  {
    super(paramContext, "GoldMsgNotify.db", null, 2);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ").append("record");
    localStringBuilder.append(" (");
    localStringBuilder.append("no").append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
    localStringBuilder.append("uid").append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("listid").append(" VARCHAR(32) NOT NULL, ");
    localStringBuilder.append("state").append(" INTEGER(16) DEFAULT 0, ");
    localStringBuilder.append("uins").append(" VARCHAR(64), ");
    localStringBuilder.append("create_time").append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("grap_state").append(" INTEGER(16) DEFAULT 0, ");
    localStringBuilder.append("grap_money").append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("grap_user_count").append(" INTEGER(16) DEFAULT 0");
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  /* Error */
  public void a(String paramString, java.util.HashMap paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 7
    //   14: aload_1
    //   15: ifnull +7 -> 22
    //   18: aload_2
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload_2
    //   24: invokevirtual 79	java/util/HashMap:clear	()V
    //   27: aload_0
    //   28: invokevirtual 83	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 4
    //   33: aload 8
    //   35: astore_3
    //   36: aload 4
    //   38: ifnull +267 -> 305
    //   41: aload 7
    //   43: astore 6
    //   45: aload 5
    //   47: astore_3
    //   48: aload 4
    //   50: astore 5
    //   52: aload 4
    //   54: new 16	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   61: ldc 85
    //   63: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: aconst_null
    //   74: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   77: astore_1
    //   78: aload_1
    //   79: ifnull +203 -> 282
    //   82: aload_1
    //   83: astore 6
    //   85: aload_1
    //   86: astore_3
    //   87: aload 4
    //   89: astore 5
    //   91: aload_1
    //   92: invokeinterface 95 1 0
    //   97: ifle +185 -> 282
    //   100: aload_1
    //   101: astore 6
    //   103: aload_1
    //   104: astore_3
    //   105: aload 4
    //   107: astore 5
    //   109: aload_1
    //   110: invokeinterface 99 1 0
    //   115: pop
    //   116: aload_1
    //   117: astore 6
    //   119: aload_1
    //   120: astore_3
    //   121: aload 4
    //   123: astore 5
    //   125: aload_1
    //   126: invokeinterface 102 1 0
    //   131: ifne +151 -> 282
    //   134: aload_1
    //   135: astore 6
    //   137: aload_1
    //   138: astore_3
    //   139: aload 4
    //   141: astore 5
    //   143: aload_1
    //   144: invokestatic 107	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgDBHelper$GoldMsgNotifyRecord:a	(Landroid/database/Cursor;)Lcom/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgDBHelper$GoldMsgNotifyRecord;
    //   147: astore 7
    //   149: aload 7
    //   151: ifnull +24 -> 175
    //   154: aload_1
    //   155: astore 6
    //   157: aload_1
    //   158: astore_3
    //   159: aload 4
    //   161: astore 5
    //   163: aload_2
    //   164: aload 7
    //   166: getfield 110	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgDBHelper$GoldMsgNotifyRecord:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   169: aload 7
    //   171: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_1
    //   176: astore 6
    //   178: aload_1
    //   179: astore_3
    //   180: aload 4
    //   182: astore 5
    //   184: aload_1
    //   185: invokeinterface 117 1 0
    //   190: pop
    //   191: goto -75 -> 116
    //   194: astore_1
    //   195: aload 6
    //   197: astore_3
    //   198: aload 4
    //   200: astore 5
    //   202: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +38 -> 243
    //   208: aload 6
    //   210: astore_3
    //   211: aload 4
    //   213: astore 5
    //   215: ldc 124
    //   217: iconst_2
    //   218: new 16	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   225: ldc 126
    //   227: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 133	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 6
    //   245: ifnull +20 -> 265
    //   248: aload 6
    //   250: invokeinterface 136 1 0
    //   255: ifne +10 -> 265
    //   258: aload 6
    //   260: invokeinterface 139 1 0
    //   265: aload 4
    //   267: ifnull -245 -> 22
    //   270: aload 4
    //   272: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   275: return
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   281: return
    //   282: aload_1
    //   283: astore_3
    //   284: aload_1
    //   285: ifnull +20 -> 305
    //   288: aload_1
    //   289: astore 6
    //   291: aload_1
    //   292: astore_3
    //   293: aload 4
    //   295: astore 5
    //   297: aload_1
    //   298: invokeinterface 139 1 0
    //   303: aload_1
    //   304: astore_3
    //   305: aload_3
    //   306: ifnull +18 -> 324
    //   309: aload_3
    //   310: invokeinterface 136 1 0
    //   315: ifne +9 -> 324
    //   318: aload_3
    //   319: invokeinterface 139 1 0
    //   324: aload 4
    //   326: ifnull -304 -> 22
    //   329: aload 4
    //   331: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   334: return
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   340: return
    //   341: astore_1
    //   342: aload_1
    //   343: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   346: goto -22 -> 324
    //   349: astore_1
    //   350: aload_1
    //   351: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   354: goto -89 -> 265
    //   357: astore_1
    //   358: aconst_null
    //   359: astore 5
    //   361: aload_3
    //   362: ifnull +18 -> 380
    //   365: aload_3
    //   366: invokeinterface 136 1 0
    //   371: ifne +9 -> 380
    //   374: aload_3
    //   375: invokeinterface 139 1 0
    //   380: aload 5
    //   382: ifnull +8 -> 390
    //   385: aload 5
    //   387: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   390: aload_1
    //   391: athrow
    //   392: astore_2
    //   393: aload_2
    //   394: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   397: goto -17 -> 380
    //   400: astore_2
    //   401: aload_2
    //   402: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   405: goto -15 -> 390
    //   408: astore_1
    //   409: goto -48 -> 361
    //   412: astore_1
    //   413: aconst_null
    //   414: astore 4
    //   416: goto -221 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	GoldMsgDBHelper
    //   0	419	1	paramString	String
    //   0	419	2	paramHashMap	java.util.HashMap
    //   7	368	3	localObject1	Object
    //   31	384	4	localSQLiteDatabase	SQLiteDatabase
    //   9	377	5	localObject2	Object
    //   1	289	6	localObject3	Object
    //   12	158	7	localGoldMsgNotifyRecord	GoldMsgDBHelper.GoldMsgNotifyRecord
    //   4	30	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	78	194	java/lang/Exception
    //   91	100	194	java/lang/Exception
    //   109	116	194	java/lang/Exception
    //   125	134	194	java/lang/Exception
    //   143	149	194	java/lang/Exception
    //   163	175	194	java/lang/Exception
    //   184	191	194	java/lang/Exception
    //   297	303	194	java/lang/Exception
    //   270	275	276	java/lang/Exception
    //   329	334	335	java/lang/Exception
    //   309	324	341	java/lang/Exception
    //   248	265	349	java/lang/Exception
    //   27	33	357	finally
    //   365	380	392	java/lang/Exception
    //   385	390	400	java/lang/Exception
    //   52	78	408	finally
    //   91	100	408	finally
    //   109	116	408	finally
    //   125	134	408	finally
    //   143	149	408	finally
    //   163	175	408	finally
    //   184	191	408	finally
    //   202	208	408	finally
    //   215	243	408	finally
    //   297	303	408	finally
    //   27	33	412	java/lang/Exception
  }
  
  public void a(String paramString, List paramList)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramString == null) || (paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        paramList = paramList.iterator();
        for (;;)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (!paramList.hasNext()) {
            break;
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord = (GoldMsgDBHelper.GoldMsgNotifyRecord)paramList.next();
          if (localGoldMsgNotifyRecord != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            if (!TextUtils.isEmpty(localGoldMsgNotifyRecord.jdField_a_of_type_JavaLangString))
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              ContentValues localContentValues = new ContentValues();
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("uid", Long.valueOf(Long.valueOf(paramString).longValue()));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("listid", localGoldMsgNotifyRecord.jdField_a_of_type_JavaLangString);
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("state", Integer.valueOf(localGoldMsgNotifyRecord.jdField_a_of_type_Int));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("create_time", Long.valueOf(NetConnInfoCenter.getServerTime()));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("uins", localGoldMsgNotifyRecord.a());
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("grap_state", Integer.valueOf(localGoldMsgNotifyRecord.b));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("grap_money", Integer.valueOf(localGoldMsgNotifyRecord.c));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("grap_user_count", Integer.valueOf(localGoldMsgNotifyRecord.d));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localSQLiteDatabase.insertOrThrow("record", null, localContentValues);
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              if (QLog.isColorLevel())
              {
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                QLog.i("GoldMsgDBHelper", 2, "GoldMsgDBHelper.insert record=" + localGoldMsgNotifyRecord);
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.i("GoldMsgDBHelper", 2, "GoldMsgDBHelper.insert err:" + paramString.getMessage());
        }
        if (localObject1 != null)
        {
          try
          {
            localObject1.close();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if (localSQLiteDatabase != null) {
            try
            {
              localSQLiteDatabase.close();
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              return;
            }
          }
        }
      }
      finally
      {
        if (localObject2 == null) {}
      }
    }
    try
    {
      localObject2.close();
      throw paramString;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public void b(String paramString, List paramList)
  {
    if ((paramString == null) || (paramList == null) || (paramList.size() <= 0)) {}
    Object localObject2;
    for (;;)
    {
      return;
      localObject2 = null;
      Object localObject1 = null;
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        paramList = paramList.iterator();
        for (;;)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (!paramList.hasNext()) {
            break;
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord = (GoldMsgDBHelper.GoldMsgNotifyRecord)paramList.next();
          if (localGoldMsgNotifyRecord != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            if (!TextUtils.isEmpty(localGoldMsgNotifyRecord.jdField_a_of_type_JavaLangString))
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              ContentValues localContentValues = new ContentValues();
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("state", Integer.valueOf(localGoldMsgNotifyRecord.jdField_a_of_type_Int));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("uins", localGoldMsgNotifyRecord.a());
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("grap_state", Integer.valueOf(localGoldMsgNotifyRecord.b));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("grap_money", Integer.valueOf(localGoldMsgNotifyRecord.c));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localContentValues.put("grap_user_count", Integer.valueOf(localGoldMsgNotifyRecord.d));
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localSQLiteDatabase.update("record", localContentValues, " uid= ?  AND listid= ? ", new String[] { paramString, localGoldMsgNotifyRecord.jdField_a_of_type_JavaLangString });
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              if (QLog.isColorLevel())
              {
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                QLog.i("GoldMsgDBHelper", 2, "GoldMsgDBHelper.update record=" + localGoldMsgNotifyRecord);
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.i("GoldMsgDBHelper", 2, "GoldMsgDBHelper.update err:" + paramString.getMessage());
        }
        if (localObject1 != null)
        {
          try
          {
            localObject1.close();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if (localSQLiteDatabase != null) {
            try
            {
              localSQLiteDatabase.close();
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              return;
            }
          }
        }
      }
      finally
      {
        if (localObject2 == null) {}
      }
    }
    try
    {
      localObject2.close();
      throw paramString;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        String str = "ALTER TABLE record ADD COLUMN grap_state INTEGER(16) DEFAULT 0";
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE record ADD COLUMN grap_state INTEGER(16) DEFAULT 0");
          str = "ALTER TABLE record ADD COLUMN grap_money INTEGER(64) DEFAULT 0";
          paramSQLiteDatabase.execSQL("ALTER TABLE record ADD COLUMN grap_money INTEGER(64) DEFAULT 0");
          str = "ALTER TABLE record ADD COLUMN grap_user_count INTEGER(16) DEFAULT 0";
          paramSQLiteDatabase.execSQL("ALTER TABLE record ADD COLUMN grap_user_count INTEGER(16) DEFAULT 0");
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.e("GoldMsgDBHelper", 2, " exception occurred when " + str, localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDBHelper
 * JD-Core Version:    0.7.0.1
 */