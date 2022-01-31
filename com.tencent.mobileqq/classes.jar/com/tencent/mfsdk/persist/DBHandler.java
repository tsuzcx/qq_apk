package com.tencent.mfsdk.persist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.tencent.mfsdk.Config.SamplingConfig;
import com.tencent.mfsdk.collector.DropResultObject;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class DBHandler
{
  private static final long jdField_a_of_type_Long = ;
  private static DBHandler jdField_a_of_type_ComTencentMfsdkPersistDBHandler;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private DBHelper jdField_a_of_type_ComTencentMfsdkPersistDBHelper;
  
  private DBHandler(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMfsdkPersistDBHelper = DBHelper.a(paramContext);
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMfsdkPersistDBHelper.getWritableDatabase();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Magnifier_DBHandler", 2, paramContext, new Object[0]);
    }
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2;
    }
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      return i;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Magnifier_DBHandler", 2, paramString1, new Object[0]);
      }
    }
    return -1;
  }
  
  private ResultObject a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    ResultObject localResultObject = new ResultObject();
    localResultObject.dbId = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    localResultObject.params = new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localResultObject.isRealTime = bool;
      localResultObject.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      return localResultObject;
    }
  }
  
  public static DBHandler a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMfsdkPersistDBHandler == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkPersistDBHandler == null) {
        jdField_a_of_type_ComTencentMfsdkPersistDBHandler = new DBHandler(paramContext);
      }
      return jdField_a_of_type_ComTencentMfsdkPersistDBHandler;
    }
    finally {}
  }
  
  private JSONObject a(DropResultObject paramDropResultObject)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONObject2.put("dropDuration", (float)paramDropResultObject.b / 1000.0F);
    int i = 0;
    while (i < 6)
    {
      localJSONArray.put(i, paramDropResultObject.jdField_a_of_type_ArrayOfLong[i]);
      i += 1;
    }
    localJSONObject2.put("dropTimes", localJSONArray);
    localJSONObject1.put(String.valueOf(paramDropResultObject.jdField_a_of_type_Int), localJSONObject2);
    return localJSONObject1;
  }
  
  private JSONObject a(HashMap paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, a((DropResultObject)paramHashMap.get(str)));
    }
    return localJSONObject;
  }
  
  /* Error */
  private java.util.List b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   11: invokevirtual 57	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   14: ifne +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: bipush 101
    //   21: invokestatic 182	com/tencent/mfsdk/ReportedStatus:a	(I)V
    //   24: new 184	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 185	java/util/ArrayList:<init>	()V
    //   31: astore 15
    //   33: new 151	java/util/HashMap
    //   36: dup
    //   37: invokespecial 186	java/util/HashMap:<init>	()V
    //   40: astore 14
    //   42: iconst_1
    //   43: iload_1
    //   44: if_icmpne +40 -> 84
    //   47: aload_0
    //   48: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   51: ldc 188
    //   53: aconst_null
    //   54: ldc 190
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 194	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 13
    //   65: aload 13
    //   67: ifnonnull +37 -> 104
    //   70: aload 13
    //   72: ifnull -55 -> 17
    //   75: aload 13
    //   77: invokeinterface 197 1 0
    //   82: aconst_null
    //   83: areturn
    //   84: aload_0
    //   85: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   88: ldc 188
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokevirtual 194	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore 13
    //   101: goto -36 -> 65
    //   104: aload 13
    //   106: invokeinterface 200 1 0
    //   111: pop
    //   112: aload 13
    //   114: invokeinterface 203 1 0
    //   119: ifne +402 -> 521
    //   122: aload 13
    //   124: aload 13
    //   126: ldc 205
    //   128: invokeinterface 72 2 0
    //   133: invokeinterface 88 2 0
    //   138: astore 16
    //   140: aload 13
    //   142: aload 13
    //   144: ldc 207
    //   146: invokeinterface 72 2 0
    //   151: invokeinterface 211 2 0
    //   156: istore_3
    //   157: iload_3
    //   158: istore_2
    //   159: iload_3
    //   160: ifgt +5 -> 165
    //   163: iconst_1
    //   164: istore_2
    //   165: aload 13
    //   167: aload 13
    //   169: ldc 213
    //   171: invokeinterface 72 2 0
    //   176: invokeinterface 106 2 0
    //   181: lstore 9
    //   183: aload 13
    //   185: aload 13
    //   187: ldc 215
    //   189: invokeinterface 72 2 0
    //   194: invokeinterface 106 2 0
    //   199: lstore 11
    //   201: aload 13
    //   203: aload 13
    //   205: ldc 217
    //   207: invokeinterface 72 2 0
    //   212: invokeinterface 76 2 0
    //   217: istore_3
    //   218: aload 13
    //   220: aload 13
    //   222: ldc 219
    //   224: invokeinterface 72 2 0
    //   229: invokeinterface 76 2 0
    //   234: istore 4
    //   236: aload 13
    //   238: aload 13
    //   240: ldc 221
    //   242: invokeinterface 72 2 0
    //   247: invokeinterface 76 2 0
    //   252: istore 5
    //   254: aload 13
    //   256: aload 13
    //   258: ldc 223
    //   260: invokeinterface 72 2 0
    //   265: invokeinterface 76 2 0
    //   270: istore 6
    //   272: aload 13
    //   274: aload 13
    //   276: ldc 225
    //   278: invokeinterface 72 2 0
    //   283: invokeinterface 76 2 0
    //   288: istore 7
    //   290: aload 13
    //   292: aload 13
    //   294: ldc 227
    //   296: invokeinterface 72 2 0
    //   301: invokeinterface 76 2 0
    //   306: istore 8
    //   308: aload 14
    //   310: aload 16
    //   312: new 122	com/tencent/mfsdk/collector/DropResultObject
    //   315: dup
    //   316: lload 11
    //   318: lload 9
    //   320: bipush 6
    //   322: newarray long
    //   324: dup
    //   325: iconst_0
    //   326: iload_3
    //   327: i2l
    //   328: lastore
    //   329: dup
    //   330: iconst_1
    //   331: iload 4
    //   333: i2l
    //   334: lastore
    //   335: dup
    //   336: iconst_2
    //   337: iload 5
    //   339: i2l
    //   340: lastore
    //   341: dup
    //   342: iconst_3
    //   343: iload 6
    //   345: i2l
    //   346: lastore
    //   347: dup
    //   348: iconst_4
    //   349: iload 7
    //   351: i2l
    //   352: lastore
    //   353: dup
    //   354: iconst_5
    //   355: iload 8
    //   357: i2l
    //   358: lastore
    //   359: invokespecial 230	com/tencent/mfsdk/collector/DropResultObject:<init>	(JJ[J)V
    //   362: invokevirtual 233	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: new 82	org/json/JSONObject
    //   369: dup
    //   370: invokespecial 115	org/json/JSONObject:<init>	()V
    //   373: astore 16
    //   375: new 82	org/json/JSONObject
    //   378: dup
    //   379: invokespecial 115	org/json/JSONObject:<init>	()V
    //   382: astore 17
    //   384: aload 17
    //   386: ldc 235
    //   388: iconst_1
    //   389: invokestatic 148	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   392: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload 17
    //   398: ldc 237
    //   400: iload_2
    //   401: invokestatic 148	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   404: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   407: pop
    //   408: aload 16
    //   410: ldc 239
    //   412: aload_0
    //   413: aload 14
    //   415: invokespecial 241	com/tencent/mfsdk/persist/DBHandler:a	(Ljava/util/HashMap;)Lorg/json/JSONObject;
    //   418: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 16
    //   424: ldc 243
    //   426: aload 17
    //   428: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   431: pop
    //   432: aload 16
    //   434: ldc 245
    //   436: bipush 101
    //   438: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   441: pop
    //   442: aload 15
    //   444: new 63	com/tencent/mfsdk/collector/ResultObject
    //   447: dup
    //   448: iconst_0
    //   449: ldc 250
    //   451: iconst_1
    //   452: lconst_1
    //   453: lconst_1
    //   454: aload 16
    //   456: iconst_0
    //   457: iconst_1
    //   458: getstatic 253	com/tencent/mfsdk/MagnifierSDK:jdField_a_of_type_Long	J
    //   461: invokespecial 256	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   464: invokeinterface 262 2 0
    //   469: pop
    //   470: aload 14
    //   472: invokevirtual 265	java/util/HashMap:clear	()V
    //   475: aload 13
    //   477: invokeinterface 268 1 0
    //   482: pop
    //   483: goto -371 -> 112
    //   486: astore 14
    //   488: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +15 -> 506
    //   494: ldc 47
    //   496: iconst_2
    //   497: aload 14
    //   499: iconst_0
    //   500: anewarray 4	java/lang/Object
    //   503: invokestatic 51	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   506: aload 13
    //   508: ifnull +10 -> 518
    //   511: aload 13
    //   513: invokeinterface 197 1 0
    //   518: aload 15
    //   520: areturn
    //   521: aload_0
    //   522: ldc 188
    //   524: aconst_null
    //   525: aconst_null
    //   526: invokespecial 270	com/tencent/mfsdk/persist/DBHandler:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   529: pop
    //   530: aload 13
    //   532: ifnull -14 -> 518
    //   535: aload 13
    //   537: invokeinterface 197 1 0
    //   542: goto -24 -> 518
    //   545: astore 14
    //   547: aconst_null
    //   548: astore 13
    //   550: aload 13
    //   552: ifnull +10 -> 562
    //   555: aload 13
    //   557: invokeinterface 197 1 0
    //   562: aload 14
    //   564: athrow
    //   565: astore 14
    //   567: goto -17 -> 550
    //   570: astore 14
    //   572: goto -22 -> 550
    //   575: astore 14
    //   577: aconst_null
    //   578: astore 13
    //   580: goto -92 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	DBHandler
    //   0	583	1	paramBoolean	boolean
    //   158	243	2	i	int
    //   156	171	3	j	int
    //   234	98	4	k	int
    //   252	86	5	m	int
    //   270	74	6	n	int
    //   288	62	7	i1	int
    //   306	50	8	i2	int
    //   181	138	9	l1	long
    //   199	118	11	l2	long
    //   63	516	13	localCursor	Cursor
    //   40	431	14	localHashMap	HashMap
    //   486	12	14	localException1	Exception
    //   545	18	14	localObject1	Object
    //   565	1	14	localObject2	Object
    //   570	1	14	localObject3	Object
    //   575	1	14	localException2	Exception
    //   31	488	15	localArrayList	java.util.ArrayList
    //   138	317	16	localObject4	Object
    //   382	45	17	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   104	112	486	java/lang/Exception
    //   112	157	486	java/lang/Exception
    //   165	483	486	java/lang/Exception
    //   521	530	486	java/lang/Exception
    //   47	65	545	finally
    //   84	101	545	finally
    //   104	112	565	finally
    //   112	157	565	finally
    //   165	483	565	finally
    //   521	530	565	finally
    //   488	506	570	finally
    //   47	65	575	java/lang/Exception
    //   84	101	575	java/lang/Exception
  }
  
  public int a()
  {
    return a("result_objects", null, null);
  }
  
  public int a(String paramString, long paramLong, int paramInt)
  {
    int j = -1;
    int i;
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      i = -2;
    }
    do
    {
      do
      {
        return i;
        if (paramInt == 1) {
          break;
        }
        i = j;
      } while (paramInt != 2);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(paramInt));
      try
      {
        paramInt = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update(paramString, localContentValues, "_id=" + paramLong, null);
        return paramInt;
      }
      catch (Exception paramString)
      {
        i = j;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Magnifier_DBHandler", 2, paramString, new Object[0]);
    return -1;
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a(paramString, "status=? OR occur_time<?", new String[] { String.valueOf(2), String.valueOf(System.currentTimeMillis() - 86400000L) });
    }
    return a(paramString, "status=?", new String[] { String.valueOf(2) });
  }
  
  public long a(long paramLong, String paramString, DropResultObject paramDropResultObject)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2L;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uin", Long.valueOf(paramLong));
    localContentValues.put("scene", paramString);
    localContentValues.put("state", Integer.valueOf(paramDropResultObject.jdField_a_of_type_Int));
    localContentValues.put("drop_duration", Long.valueOf(paramDropResultObject.b));
    localContentValues.put("drop_count", Long.valueOf(paramDropResultObject.jdField_a_of_type_Long));
    localContentValues.put("range_0", Long.valueOf(paramDropResultObject.jdField_a_of_type_ArrayOfLong[0]));
    localContentValues.put("range_1", Long.valueOf(paramDropResultObject.jdField_a_of_type_ArrayOfLong[1]));
    localContentValues.put("range_2_4", Long.valueOf(paramDropResultObject.jdField_a_of_type_ArrayOfLong[2]));
    localContentValues.put("range_4_8", Long.valueOf(paramDropResultObject.jdField_a_of_type_ArrayOfLong[3]));
    localContentValues.put("range_8_15", Long.valueOf(paramDropResultObject.jdField_a_of_type_ArrayOfLong[4]));
    localContentValues.put("range_over_15", Long.valueOf(paramDropResultObject.jdField_a_of_type_ArrayOfLong[5]));
    localContentValues.put("status", Integer.valueOf(1));
    try
    {
      paramLong = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("drop_frame", "name", localContentValues);
      return paramLong;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Magnifier_DBHandler", 2, paramString, new Object[0]);
      }
    }
    return -1L;
  }
  
  public long a(SparseArray paramSparseArray)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2L;
    }
    a("configs", null, null);
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
    int j = paramSparseArray.size();
    ContentValues localContentValues = new ContentValues();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        int k = paramSparseArray.keyAt(i);
        Config.SamplingConfig localSamplingConfig = (Config.SamplingConfig)paramSparseArray.get(k);
        localContentValues.put("plugin", Integer.valueOf(k));
        localContentValues.put("user_sample_ratio", Float.valueOf(localSamplingConfig.jdField_a_of_type_Float));
        localContentValues.put("threshold", Integer.valueOf(localSamplingConfig.jdField_a_of_type_Int));
        localContentValues.put("max_report_num", Integer.valueOf(localSamplingConfig.jdField_b_of_type_Int));
        localContentValues.put("event_sample_ratio", Float.valueOf(localSamplingConfig.jdField_b_of_type_Float));
        localContentValues.put("stack_depth", Integer.valueOf(localSamplingConfig.c));
        try
        {
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("configs", "name", localContentValues);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Magnifier_DBHandler", 2, localException, new Object[0]);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
    return 0L;
  }
  
  public long a(ResultObject paramResultObject)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2L;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("params", paramResultObject.params.toString());
    localContentValues.put("is_real_time", Boolean.valueOf(paramResultObject.isRealTime));
    localContentValues.put("uin", Long.valueOf(paramResultObject.uin));
    localContentValues.put("status", Integer.valueOf(1));
    try
    {
      l1 = paramResultObject.params.getJSONObject("clientinfo").optLong("event_time");
      long l2 = l1;
      if (l1 == 0L) {
        l2 = jdField_a_of_type_Long;
      }
      localContentValues.put("occur_time", Long.valueOf(l2));
    }
    catch (Exception paramResultObject)
    {
      for (;;)
      {
        try
        {
          l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("result_objects", "name", localContentValues);
          return l1;
        }
        catch (Exception paramResultObject)
        {
          long l1;
          if (!QLog.isColorLevel()) {
            break label169;
          }
          QLog.e("Magnifier_DBHandler", 2, paramResultObject, new Object[0]);
        }
        paramResultObject = paramResultObject;
        l1 = 0L;
      }
    }
    label169:
    return -1L;
  }
  
  /* Error */
  public SparseArray a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 57	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   16: ifne +9 -> 25
    //   19: aconst_null
    //   20: astore 4
    //   22: aload 4
    //   24: areturn
    //   25: aload_0
    //   26: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   29: ldc_w 343
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 194	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnonnull +15 -> 58
    //   46: aload_2
    //   47: ifnull +9 -> 56
    //   50: aload_2
    //   51: invokeinterface 197 1 0
    //   56: aconst_null
    //   57: areturn
    //   58: aload_2
    //   59: invokeinterface 420 1 0
    //   64: istore_1
    //   65: iload_1
    //   66: iconst_1
    //   67: if_icmpge +15 -> 82
    //   70: aload_2
    //   71: ifnull +9 -> 80
    //   74: aload_2
    //   75: invokeinterface 197 1 0
    //   80: aconst_null
    //   81: areturn
    //   82: new 348	android/util/SparseArray
    //   85: dup
    //   86: iload_1
    //   87: invokespecial 422	android/util/SparseArray:<init>	(I)V
    //   90: astore 5
    //   92: aload_2
    //   93: invokeinterface 200 1 0
    //   98: pop
    //   99: aload_2
    //   100: invokeinterface 203 1 0
    //   105: ifne +154 -> 259
    //   108: aload 5
    //   110: aload_2
    //   111: aload_2
    //   112: ldc 235
    //   114: invokeinterface 72 2 0
    //   119: invokeinterface 76 2 0
    //   124: new 359	com/tencent/mfsdk/Config$SamplingConfig
    //   127: dup
    //   128: aload_2
    //   129: aload_2
    //   130: ldc_w 361
    //   133: invokeinterface 72 2 0
    //   138: invokeinterface 426 2 0
    //   143: aload_2
    //   144: aload_2
    //   145: ldc_w 374
    //   148: invokeinterface 72 2 0
    //   153: invokeinterface 76 2 0
    //   158: aload_2
    //   159: aload_2
    //   160: ldc_w 377
    //   163: invokeinterface 72 2 0
    //   168: invokeinterface 76 2 0
    //   173: aload_2
    //   174: aload_2
    //   175: ldc_w 381
    //   178: invokeinterface 72 2 0
    //   183: invokeinterface 426 2 0
    //   188: aload_2
    //   189: aload_2
    //   190: ldc_w 385
    //   193: invokeinterface 72 2 0
    //   198: invokeinterface 76 2 0
    //   203: invokespecial 429	com/tencent/mfsdk/Config$SamplingConfig:<init>	(FIIFI)V
    //   206: invokevirtual 432	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   209: aload_2
    //   210: invokeinterface 268 1 0
    //   215: pop
    //   216: goto -117 -> 99
    //   219: astore 4
    //   221: aload_2
    //   222: astore_3
    //   223: aload 5
    //   225: astore_2
    //   226: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +15 -> 244
    //   232: ldc 47
    //   234: iconst_2
    //   235: aload 4
    //   237: iconst_0
    //   238: anewarray 4	java/lang/Object
    //   241: invokestatic 51	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   244: aload_2
    //   245: astore 4
    //   247: aload_3
    //   248: ifnull -226 -> 22
    //   251: aload_3
    //   252: invokeinterface 197 1 0
    //   257: aload_2
    //   258: areturn
    //   259: aload_2
    //   260: ifnull +61 -> 321
    //   263: aload_2
    //   264: invokeinterface 197 1 0
    //   269: aload 5
    //   271: areturn
    //   272: astore_3
    //   273: aconst_null
    //   274: astore_2
    //   275: aload_2
    //   276: ifnull +9 -> 285
    //   279: aload_2
    //   280: invokeinterface 197 1 0
    //   285: aload_3
    //   286: athrow
    //   287: astore_3
    //   288: goto -13 -> 275
    //   291: astore 4
    //   293: aload_3
    //   294: astore_2
    //   295: aload 4
    //   297: astore_3
    //   298: goto -23 -> 275
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_2
    //   305: goto -79 -> 226
    //   308: astore 4
    //   310: aconst_null
    //   311: astore 5
    //   313: aload_2
    //   314: astore_3
    //   315: aload 5
    //   317: astore_2
    //   318: goto -92 -> 226
    //   321: aload 5
    //   323: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	DBHandler
    //   64	23	1	i	int
    //   41	277	2	localObject1	Object
    //   1	251	3	localObject2	Object
    //   272	14	3	localObject3	Object
    //   287	7	3	localObject4	Object
    //   297	18	3	localObject5	Object
    //   20	3	4	localSparseArray1	SparseArray
    //   219	17	4	localException1	Exception
    //   245	1	4	localObject6	Object
    //   291	5	4	localObject7	Object
    //   301	1	4	localException2	Exception
    //   308	1	4	localException3	Exception
    //   90	232	5	localSparseArray2	SparseArray
    // Exception table:
    //   from	to	target	type
    //   92	99	219	java/lang/Exception
    //   99	216	219	java/lang/Exception
    //   25	42	272	finally
    //   58	65	287	finally
    //   82	92	287	finally
    //   92	99	287	finally
    //   99	216	287	finally
    //   226	244	291	finally
    //   25	42	301	java/lang/Exception
    //   58	65	308	java/lang/Exception
    //   82	92	308	java/lang/Exception
  }
  
  /* Error */
  public java.util.List a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 17	java/lang/System:currentTimeMillis	()J
    //   6: lstore_2
    //   7: new 184	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 185	java/util/ArrayList:<init>	()V
    //   14: astore 7
    //   16: aload_0
    //   17: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   27: invokevirtual 57	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   30: ifne +6 -> 36
    //   33: aload 7
    //   35: areturn
    //   36: iconst_1
    //   37: iload_1
    //   38: if_icmpne +64 -> 102
    //   41: aload_0
    //   42: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc_w 273
    //   48: aconst_null
    //   49: ldc_w 434
    //   52: iconst_2
    //   53: anewarray 145	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: iconst_1
    //   59: invokestatic 148	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload_2
    //   66: ldc2_w 311
    //   69: lsub
    //   70: invokestatic 315	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   73: aastore
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: invokevirtual 194	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 4
    //   82: aload 4
    //   84: ifnonnull +39 -> 123
    //   87: aload 4
    //   89: ifnull +10 -> 99
    //   92: aload 4
    //   94: invokeinterface 197 1 0
    //   99: aload 7
    //   101: areturn
    //   102: aload_0
    //   103: getfield 39	com/tencent/mfsdk/persist/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   106: ldc_w 273
    //   109: aconst_null
    //   110: aconst_null
    //   111: aconst_null
    //   112: aconst_null
    //   113: aconst_null
    //   114: aconst_null
    //   115: invokevirtual 194	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 4
    //   120: goto -38 -> 82
    //   123: aload 4
    //   125: astore 5
    //   127: aload 4
    //   129: invokeinterface 200 1 0
    //   134: pop
    //   135: aload 4
    //   137: astore 5
    //   139: aload 4
    //   141: invokeinterface 203 1 0
    //   146: ifne +124 -> 270
    //   149: aload 4
    //   151: astore 5
    //   153: aload_0
    //   154: aload 4
    //   156: invokespecial 436	com/tencent/mfsdk/persist/DBHandler:a	(Landroid/database/Cursor;)Lcom/tencent/mfsdk/collector/ResultObject;
    //   159: astore 6
    //   161: aload 6
    //   163: ifnull +17 -> 180
    //   166: aload 4
    //   168: astore 5
    //   170: aload 7
    //   172: aload 6
    //   174: invokeinterface 262 2 0
    //   179: pop
    //   180: aload 4
    //   182: astore 5
    //   184: aload 4
    //   186: invokeinterface 268 1 0
    //   191: pop
    //   192: goto -57 -> 135
    //   195: astore 6
    //   197: aload 4
    //   199: astore 5
    //   201: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +19 -> 223
    //   207: aload 4
    //   209: astore 5
    //   211: ldc 47
    //   213: iconst_2
    //   214: aload 6
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 51	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   223: aload 4
    //   225: ifnull +10 -> 235
    //   228: aload 4
    //   230: invokeinterface 197 1 0
    //   235: aload_0
    //   236: iload_1
    //   237: invokespecial 438	com/tencent/mfsdk/persist/DBHandler:b	(Z)Ljava/util/List;
    //   240: astore 4
    //   242: aload 4
    //   244: ifnull +23 -> 267
    //   247: aload 4
    //   249: invokeinterface 441 1 0
    //   254: ifne +13 -> 267
    //   257: aload 7
    //   259: aload 4
    //   261: invokeinterface 445 2 0
    //   266: pop
    //   267: aload 7
    //   269: areturn
    //   270: aload 4
    //   272: ifnull -37 -> 235
    //   275: aload 4
    //   277: invokeinterface 197 1 0
    //   282: goto -47 -> 235
    //   285: astore 4
    //   287: aload 5
    //   289: ifnull +10 -> 299
    //   292: aload 5
    //   294: invokeinterface 197 1 0
    //   299: aload 4
    //   301: athrow
    //   302: astore 4
    //   304: goto -17 -> 287
    //   307: astore 6
    //   309: aconst_null
    //   310: astore 4
    //   312: goto -115 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	DBHandler
    //   0	315	1	paramBoolean	boolean
    //   6	60	2	l	long
    //   80	196	4	localObject1	Object
    //   285	15	4	localObject2	Object
    //   302	1	4	localObject3	Object
    //   310	1	4	localObject4	Object
    //   1	292	5	localObject5	Object
    //   159	14	6	localResultObject	ResultObject
    //   195	20	6	localException1	Exception
    //   307	1	6	localException2	Exception
    //   14	254	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   127	135	195	java/lang/Exception
    //   139	149	195	java/lang/Exception
    //   153	161	195	java/lang/Exception
    //   170	180	195	java/lang/Exception
    //   184	192	195	java/lang/Exception
    //   41	82	285	finally
    //   102	120	285	finally
    //   127	135	302	finally
    //   139	149	302	finally
    //   153	161	302	finally
    //   170	180	302	finally
    //   184	192	302	finally
    //   201	207	302	finally
    //   211	223	302	finally
    //   41	82	307	java/lang/Exception
    //   102	120	307	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.persist.DBHandler
 * JD-Core Version:    0.7.0.1
 */