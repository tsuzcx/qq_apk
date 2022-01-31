package com.tencent.acstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.acstat.common.DeviceInfo;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.common.StatPreferences;
import com.tencent.acstat.common.Util;
import com.tencent.acstat.event.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class af
{
  private static StatLogger h = ;
  private static Context i = null;
  private static int j = 307200;
  private static af k = null;
  volatile int a = 0;
  DeviceInfo b = null;
  private an c = null;
  private an d = null;
  private Handler e = null;
  private String f = "";
  private String g = "";
  private int l = 0;
  private ConcurrentHashMap<d, String> m = null;
  private boolean n = false;
  private HashMap<String, String> o = new HashMap();
  
  private af(Context paramContext)
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("StatStore");
      localHandlerThread.start();
      this.e = new Handler(localHandlerThread.getLooper());
      i = paramContext.getApplicationContext();
      this.m = new ConcurrentHashMap();
      this.f = StatCommonHelper.getDatabaseName(paramContext);
      this.g = ("pri_" + StatCommonHelper.getDatabaseName(paramContext));
      this.c = new an(i, this.f);
      this.d = new an(i, this.g);
      f();
      b(true);
      b(false);
      g();
      b(i);
      d();
      k();
      return;
    }
    catch (Throwable paramContext)
    {
      h.e(paramContext);
    }
  }
  
  public static af a(Context paramContext)
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new af(paramContext);
      }
      return k;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    return "tencent_mta_sp_" + paramString;
  }
  
  private String a(List<ao> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 3);
    localStringBuilder.append("event_id in (");
    int i2 = paramList.size();
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      localStringBuilder.append(((ao)paramList.next()).a);
      if (i1 != i2 - 1) {
        localStringBuilder.append(",");
      }
      i1 += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((this.a > 0) && (paramInt > 0))
        {
          boolean bool = StatServiceImpl.a();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        ArrayList localArrayList;
        h.e(localThrowable);
        continue;
      }
      finally {}
      return;
      if (StatConfig.isDebugEnable()) {
        h.i("Load " + this.a + " unsent events");
      }
      localArrayList = new ArrayList(paramInt);
      b(localArrayList, paramInt, paramBoolean);
      if (localArrayList.size() > 0)
      {
        if (StatConfig.isDebugEnable()) {
          h.i("Peek " + localArrayList.size() + " unsent events.");
        }
        a(localArrayList, 2, paramBoolean);
        g.b(i).b(localArrayList, new al(this, localArrayList, paramBoolean));
      }
    }
  }
  
  private void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put(a("uid"), paramString);
    localHashMap.put(a("user_type"), Integer.valueOf(paramInt));
    localHashMap.put(a("app_ver"), StatCommonHelper.getAppVersion(paramContext));
    localHashMap.put(a("ts"), Long.valueOf(paramLong));
    StatPreferences.putObjectList(paramContext, localHashMap);
  }
  
  private void a(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      long l2;
      try
      {
        localSQLiteDatabase = d(paramBoolean);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        if (!paramBoolean)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (this.a > StatConfig.getMaxStoreEventCount())
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            h.warn("Too many events stored in db.");
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            this.a -= this.c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
          }
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        String str = paramd.g();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (StatConfig.isDebugEnable())
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          h.i("insert 1 event, content:" + str);
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        str = Util.encode(str);
        if (str == null) {
          break label529;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (str.length() >= j) {
          break label529;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("content", str);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("send_count", "0");
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("status", Integer.toString(1));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("timestamp", Long.valueOf(paramd.c()));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        l1 = localSQLiteDatabase.insert("events", null, localContentValues);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
        l2 = l1;
        if (localSQLiteDatabase == null) {
          break label522;
        }
      }
      catch (Throwable localThrowable3)
      {
        SQLiteDatabase localSQLiteDatabase;
        l2 = -1L;
        localObject2 = localThrowable1;
        h.e(localThrowable3);
        if (localThrowable1 == null) {
          break label522;
        }
        try
        {
          localThrowable1.endTransaction();
          l1 = -1L;
        }
        catch (Throwable localThrowable2)
        {
          h.e(localThrowable2);
          l1 = -1L;
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        try
        {
          localObject2.endTransaction();
          throw paramd;
        }
        catch (Throwable paramStatDispatchCallback)
        {
          h.e(paramStatDispatchCallback);
          continue;
        }
        h.error("Failed to store event:" + paramd.g());
        return;
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        if (l1 > 0L)
        {
          this.a += 1;
          if (StatConfig.isDebugEnable()) {
            h.d("directStoreEvent insert event to db, event:" + paramd.g());
          }
          if (paramStatDispatchCallback != null) {
            paramStatDispatchCallback.onDispatchSuccess();
          }
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        h.e(localThrowable1);
        continue;
      }
      label522:
      long l1 = l2;
      continue;
      label529:
      l1 = 0L;
    }
  }
  
  /* Error */
  private void a(List<ao> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 165 1 0
    //   14: istore 4
    //   16: iload 4
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iload_3
    //   26: invokespecial 398	com/tencent/acstat/af:c	(Z)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_3
    //   33: invokespecial 303	com/tencent/acstat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 6
    //   38: iload_2
    //   39: iconst_2
    //   40: if_icmpne +192 -> 232
    //   43: aload 6
    //   45: astore 5
    //   47: new 117	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 400
    //   54: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: iload_2
    //   58: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 402
    //   64: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 404	com/tencent/acstat/af:a	(Ljava/util/List;)Ljava/lang/String;
    //   72: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 8
    //   80: aload 7
    //   82: astore_1
    //   83: aload 8
    //   85: astore 7
    //   87: aload 6
    //   89: astore 5
    //   91: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   94: ifeq +31 -> 125
    //   97: aload 6
    //   99: astore 5
    //   101: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   104: new 117	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 406
    //   111: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload 7
    //   116: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   125: aload 6
    //   127: astore 5
    //   129: aload 6
    //   131: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   134: aload 6
    //   136: astore 5
    //   138: aload 6
    //   140: aload 7
    //   142: invokevirtual 409	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   145: aload_1
    //   146: ifnull +48 -> 194
    //   149: aload 6
    //   151: astore 5
    //   153: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   156: new 117	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 411
    //   163: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   176: aload 6
    //   178: astore 5
    //   180: aload 6
    //   182: aload_1
    //   183: invokevirtual 409	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   186: aload 6
    //   188: astore 5
    //   190: aload_0
    //   191: invokespecial 140	com/tencent/acstat/af:g	()V
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   203: aload 6
    //   205: ifnull -184 -> 21
    //   208: aload 6
    //   210: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   213: goto -192 -> 21
    //   216: astore_1
    //   217: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   220: aload_1
    //   221: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   224: goto -203 -> 21
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    //   232: aload 6
    //   234: astore 5
    //   236: new 117	java/lang/StringBuilder
    //   239: dup
    //   240: ldc_w 400
    //   243: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: iload_2
    //   247: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc_w 413
    //   253: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: aload_1
    //   258: invokespecial 404	com/tencent/acstat/af:a	(Ljava/util/List;)Ljava/lang/String;
    //   261: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: astore 7
    //   269: aload 8
    //   271: astore_1
    //   272: aload 6
    //   274: astore 5
    //   276: aload_0
    //   277: getfield 74	com/tencent/acstat/af:l	I
    //   280: iconst_3
    //   281: irem
    //   282: ifne +26 -> 308
    //   285: aload 6
    //   287: astore 5
    //   289: new 117	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 415
    //   296: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: iload 4
    //   301: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_1
    //   308: aload 6
    //   310: astore 5
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 74	com/tencent/acstat/af:l	I
    //   317: iconst_1
    //   318: iadd
    //   319: putfield 74	com/tencent/acstat/af:l	I
    //   322: goto -235 -> 87
    //   325: astore_1
    //   326: aload 6
    //   328: astore 5
    //   330: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   333: aload_1
    //   334: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   337: aload 6
    //   339: ifnull -318 -> 21
    //   342: aload 6
    //   344: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   347: goto -326 -> 21
    //   350: astore_1
    //   351: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   354: aload_1
    //   355: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   358: goto -337 -> 21
    //   361: astore_1
    //   362: aconst_null
    //   363: astore 5
    //   365: aload 5
    //   367: ifnull +8 -> 375
    //   370: aload 5
    //   372: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   375: aload_1
    //   376: athrow
    //   377: astore 5
    //   379: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   382: aload 5
    //   384: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   387: goto -12 -> 375
    //   390: astore_1
    //   391: goto -26 -> 365
    //   394: astore_1
    //   395: aconst_null
    //   396: astore 6
    //   398: goto -72 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	af
    //   0	401	1	paramList	List<ao>
    //   0	401	2	paramInt	int
    //   0	401	3	paramBoolean	boolean
    //   14	286	4	i1	int
    //   45	326	5	localSQLiteDatabase1	SQLiteDatabase
    //   377	6	5	localThrowable	Throwable
    //   36	361	6	localSQLiteDatabase2	SQLiteDatabase
    //   4	264	7	str1	String
    //   1	269	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   208	213	216	java/lang/Throwable
    //   8	16	227	finally
    //   24	31	227	finally
    //   208	213	227	finally
    //   217	224	227	finally
    //   342	347	227	finally
    //   351	358	227	finally
    //   370	375	227	finally
    //   375	377	227	finally
    //   379	387	227	finally
    //   47	80	325	java/lang/Throwable
    //   91	97	325	java/lang/Throwable
    //   101	125	325	java/lang/Throwable
    //   129	134	325	java/lang/Throwable
    //   138	145	325	java/lang/Throwable
    //   153	176	325	java/lang/Throwable
    //   180	186	325	java/lang/Throwable
    //   190	194	325	java/lang/Throwable
    //   198	203	325	java/lang/Throwable
    //   236	269	325	java/lang/Throwable
    //   276	285	325	java/lang/Throwable
    //   289	308	325	java/lang/Throwable
    //   312	322	325	java/lang/Throwable
    //   342	347	350	java/lang/Throwable
    //   31	38	361	finally
    //   370	375	377	java/lang/Throwable
    //   47	80	390	finally
    //   91	97	390	finally
    //   101	125	390	finally
    //   129	134	390	finally
    //   138	145	390	finally
    //   153	176	390	finally
    //   180	186	390	finally
    //   190	194	390	finally
    //   198	203	390	finally
    //   236	269	390	finally
    //   276	285	390	finally
    //   289	308	390	finally
    //   312	322	390	finally
    //   330	337	390	finally
    //   31	38	394	java/lang/Throwable
  }
  
  /* Error */
  private void a(List<ao> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 165 1 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   25: ifeq +41 -> 66
    //   28: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   31: new 117	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 418
    //   38: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokeinterface 165 1 0
    //   47: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 420
    //   53: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_2
    //   57: invokevirtual 423	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   66: new 117	java/lang/StringBuilder
    //   69: dup
    //   70: aload_1
    //   71: invokeinterface 165 1 0
    //   76: iconst_3
    //   77: imul
    //   78: invokespecial 168	java/lang/StringBuilder:<init>	(I)V
    //   81: astore 7
    //   83: aload 7
    //   85: ldc 170
    //   87: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: invokeinterface 165 1 0
    //   97: istore 4
    //   99: aload_1
    //   100: invokeinterface 174 1 0
    //   105: astore_1
    //   106: iconst_0
    //   107: istore_3
    //   108: aload_1
    //   109: invokeinterface 180 1 0
    //   114: ifeq +40 -> 154
    //   117: aload 7
    //   119: aload_1
    //   120: invokeinterface 184 1 0
    //   125: checkcast 186	com/tencent/acstat/ao
    //   128: getfield 189	com/tencent/acstat/ao:a	J
    //   131: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: iload_3
    //   136: iload 4
    //   138: iconst_1
    //   139: isub
    //   140: if_icmpeq +264 -> 404
    //   143: aload 7
    //   145: ldc 194
    //   147: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: goto +253 -> 404
    //   154: aload 7
    //   156: ldc 196
    //   158: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: astore_1
    //   165: aload_0
    //   166: iload_2
    //   167: invokespecial 303	com/tencent/acstat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   170: astore 6
    //   172: aload 6
    //   174: astore_1
    //   175: aload 6
    //   177: astore 5
    //   179: aload 6
    //   181: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   184: aload 6
    //   186: astore_1
    //   187: aload 6
    //   189: astore 5
    //   191: aload 6
    //   193: ldc_w 322
    //   196: aload 7
    //   198: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aconst_null
    //   202: invokevirtual 328	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   205: istore_3
    //   206: aload 6
    //   208: astore_1
    //   209: aload 6
    //   211: astore 5
    //   213: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   216: ifeq +58 -> 274
    //   219: aload 6
    //   221: astore_1
    //   222: aload 6
    //   224: astore 5
    //   226: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   229: new 117	java/lang/StringBuilder
    //   232: dup
    //   233: ldc_w 425
    //   236: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: iload 4
    //   241: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 427
    //   247: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 7
    //   252: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 429
    //   261: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload_3
    //   265: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   274: aload 6
    //   276: astore_1
    //   277: aload 6
    //   279: astore 5
    //   281: aload_0
    //   282: aload_0
    //   283: getfield 70	com/tencent/acstat/af:a	I
    //   286: iload_3
    //   287: isub
    //   288: putfield 70	com/tencent/acstat/af:a	I
    //   291: aload 6
    //   293: astore_1
    //   294: aload 6
    //   296: astore 5
    //   298: aload 6
    //   300: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   303: aload 6
    //   305: astore_1
    //   306: aload 6
    //   308: astore 5
    //   310: aload_0
    //   311: invokespecial 140	com/tencent/acstat/af:g	()V
    //   314: aload 6
    //   316: ifnull -297 -> 19
    //   319: aload 6
    //   321: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   324: goto -305 -> 19
    //   327: astore_1
    //   328: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   331: aload_1
    //   332: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   335: goto -316 -> 19
    //   338: astore_1
    //   339: aload_0
    //   340: monitorexit
    //   341: aload_1
    //   342: athrow
    //   343: astore 6
    //   345: aload_1
    //   346: astore 5
    //   348: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   351: aload 6
    //   353: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   356: aload_1
    //   357: ifnull -338 -> 19
    //   360: aload_1
    //   361: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   364: goto -345 -> 19
    //   367: astore_1
    //   368: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   371: aload_1
    //   372: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   375: goto -356 -> 19
    //   378: astore_1
    //   379: aload 5
    //   381: ifnull +8 -> 389
    //   384: aload 5
    //   386: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   389: aload_1
    //   390: athrow
    //   391: astore 5
    //   393: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   396: aload 5
    //   398: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   401: goto -12 -> 389
    //   404: iload_3
    //   405: iconst_1
    //   406: iadd
    //   407: istore_3
    //   408: goto -300 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	af
    //   0	411	1	paramList	List<ao>
    //   0	411	2	paramBoolean	boolean
    //   14	394	3	i1	int
    //   97	143	4	i2	int
    //   1	384	5	localObject	Object
    //   391	6	5	localThrowable1	Throwable
    //   4	316	6	localSQLiteDatabase	SQLiteDatabase
    //   343	9	6	localThrowable2	Throwable
    //   81	170	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   319	324	327	java/lang/Throwable
    //   8	15	338	finally
    //   22	66	338	finally
    //   66	106	338	finally
    //   108	135	338	finally
    //   143	151	338	finally
    //   154	162	338	finally
    //   319	324	338	finally
    //   328	335	338	finally
    //   360	364	338	finally
    //   368	375	338	finally
    //   384	389	338	finally
    //   389	391	338	finally
    //   393	401	338	finally
    //   165	172	343	java/lang/Throwable
    //   179	184	343	java/lang/Throwable
    //   191	206	343	java/lang/Throwable
    //   213	219	343	java/lang/Throwable
    //   226	274	343	java/lang/Throwable
    //   281	291	343	java/lang/Throwable
    //   298	303	343	java/lang/Throwable
    //   310	314	343	java/lang/Throwable
    //   360	364	367	java/lang/Throwable
    //   165	172	378	finally
    //   179	184	378	finally
    //   191	206	378	finally
    //   213	219	378	finally
    //   226	274	378	finally
    //   281	291	378	finally
    //   298	303	378	finally
    //   310	314	378	finally
    //   348	356	378	finally
    //   384	389	391	java/lang/Throwable
  }
  
  private boolean a(boolean paramBoolean)
  {
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        SQLiteDatabase localSQLiteDatabase = d(paramBoolean);
        localSQLiteDatabase.beginTransaction();
        Object localObject = new ContentValues();
        ((ContentValues)localObject).put("content", "test");
        ((ContentValues)localObject).put("send_count", "100");
        ((ContentValues)localObject).put("status", Integer.toString(1));
        ((ContentValues)localObject).put("timestamp", Long.valueOf(System.currentTimeMillis()));
        localSQLiteDatabase.insert("events", null, (ContentValues)localObject);
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        i1 = localSQLiteDatabase.delete("events", "content = ?", new String[] { "test" });
        localObject = localSQLiteDatabase.query("events", null, "content=?", new String[] { "test" }, null, null, null, "1");
        i2 = ((Cursor)localObject).getCount();
        ((Cursor)localObject).close();
        if (!StatConfig.isDebugEnable()) {
          break label297;
        }
        h.i("delNum=" + i1 + ",queryNum=" + i2);
      }
      catch (SQLiteFullException localSQLiteFullException)
      {
        h.warn("db is full, change to INSTANT");
        StatConfig.setReportEventsByOrder(false);
        StatConfig.setStatSendStrategy(StatReportStrategy.INSTANT);
        return true;
        if (!StatConfig.isDebugEnable()) {
          continue;
        }
        String[] arrayOfString = localSQLiteFullException.getPath().split("/");
        h.i("test db passed, db name:" + arrayOfString[(arrayOfString.length - 1)]);
        return true;
      }
      catch (Throwable localThrowable)
      {
        h.e(localThrowable);
        return false;
      }
      throw new SQLException("test delete error.");
      label297:
      if (i1 != 0) {
        if (i2 <= 0) {}
      }
    }
  }
  
  public static af b()
  {
    return k;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      if (!paramBoolean) {
        paramInt = h();
      }
    }
    for (;;)
    {
      if (paramInt > 0)
      {
        int i2 = StatConfig.getSendPeriodMinutes() * 60 * StatConfig.getNumEventsCommitPerSec();
        int i1 = paramInt;
        if (paramInt > i2)
        {
          i1 = paramInt;
          if (i2 > 0) {
            i1 = i2;
          }
        }
        int i3 = StatConfig.a();
        int i4 = i1 / i3;
        int i5 = i1 % i3;
        if (StatConfig.isDebugEnable()) {
          h.i("sentStoreEventsByDb sendNumbers=" + i1 + ",important=" + paramBoolean + ",maxSendNumPerFor1Period=" + i2 + ",maxCount=" + i4 + ",restNumbers=" + i5);
        }
        paramInt = 0;
        for (;;)
        {
          if (paramInt < i4)
          {
            a(i3, paramBoolean);
            paramInt += 1;
            continue;
            paramInt = i();
            break;
          }
        }
        if (i5 > 0) {
          a(i5, paramBoolean);
        }
      }
      return;
    }
  }
  
  /* Error */
  private void b(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 524	com/tencent/acstat/e:a	()Ljava/lang/String;
    //   6: astore 7
    //   8: aload 7
    //   10: invokestatic 527	com/tencent/acstat/common/StatCommonHelper:md5sum	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 5
    //   15: new 330	android/content/ContentValues
    //   18: dup
    //   19: invokespecial 331	android/content/ContentValues:<init>	()V
    //   22: astore 8
    //   24: aload 8
    //   26: ldc_w 349
    //   29: aload_1
    //   30: getfield 530	com/tencent/acstat/e:b	Lorg/json/JSONObject;
    //   33: invokevirtual 533	org/json/JSONObject:toString	()Ljava/lang/String;
    //   36: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload 8
    //   41: ldc_w 534
    //   44: aload 5
    //   46: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: aload 5
    //   52: putfield 536	com/tencent/acstat/e:c	Ljava/lang/String;
    //   55: aload 8
    //   57: ldc_w 538
    //   60: aload_1
    //   61: getfield 540	com/tencent/acstat/e:d	I
    //   64: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   70: aload_0
    //   71: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   74: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   77: ldc_w 548
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 5
    //   95: aload 6
    //   97: invokeinterface 554 1 0
    //   102: ifeq +381 -> 483
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: iconst_0
    //   112: invokeinterface 558 2 0
    //   117: aload_1
    //   118: getfield 559	com/tencent/acstat/e:a	I
    //   121: if_icmpne -30 -> 91
    //   124: iconst_1
    //   125: istore_2
    //   126: aload 6
    //   128: astore 5
    //   130: aload_0
    //   131: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   134: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   137: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   140: iconst_1
    //   141: iload_2
    //   142: if_icmpne +116 -> 258
    //   145: aload 6
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   153: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   156: ldc_w 548
    //   159: aload 8
    //   161: ldc_w 561
    //   164: iconst_1
    //   165: anewarray 344	java/lang/String
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: getfield 559	com/tencent/acstat/e:a	I
    //   174: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   177: aastore
    //   178: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   181: i2l
    //   182: lstore_3
    //   183: lload_3
    //   184: ldc2_w 389
    //   187: lcmp
    //   188: ifne +113 -> 301
    //   191: aload 6
    //   193: astore 5
    //   195: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   198: new 117	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 567
    //   205: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload 7
    //   210: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 569	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   219: aload 6
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   227: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   230: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   233: aload 6
    //   235: ifnull +10 -> 245
    //   238: aload 6
    //   240: invokeinterface 460 1 0
    //   245: aload_0
    //   246: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   249: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   252: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   255: aload_0
    //   256: monitorexit
    //   257: return
    //   258: aload 6
    //   260: astore 5
    //   262: aload 8
    //   264: ldc_w 571
    //   267: aload_1
    //   268: getfield 559	com/tencent/acstat/e:a	I
    //   271: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   277: aload 6
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   285: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   288: ldc_w 548
    //   291: aconst_null
    //   292: aload 8
    //   294: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   297: lstore_3
    //   298: goto -115 -> 183
    //   301: aload 6
    //   303: astore 5
    //   305: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   308: new 117	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 573
    //   315: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload 7
    //   320: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokevirtual 383	com/tencent/acstat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   329: goto -110 -> 219
    //   332: astore_1
    //   333: aload 6
    //   335: astore 5
    //   337: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   340: aload_1
    //   341: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   344: aload 6
    //   346: ifnull +10 -> 356
    //   349: aload 6
    //   351: invokeinterface 460 1 0
    //   356: aload_0
    //   357: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   360: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   363: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   366: goto -111 -> 255
    //   369: astore_1
    //   370: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   373: aload_1
    //   374: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   377: goto -122 -> 255
    //   380: astore_1
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_1
    //   384: athrow
    //   385: astore_1
    //   386: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   389: aload_1
    //   390: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   393: goto -148 -> 245
    //   396: astore_1
    //   397: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   400: aload_1
    //   401: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   404: goto -149 -> 255
    //   407: astore_1
    //   408: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   411: aload_1
    //   412: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   415: goto -59 -> 356
    //   418: astore_1
    //   419: aconst_null
    //   420: astore 5
    //   422: aload 5
    //   424: ifnull +10 -> 434
    //   427: aload 5
    //   429: invokeinterface 460 1 0
    //   434: aload_0
    //   435: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   438: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   441: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   444: aload_1
    //   445: athrow
    //   446: astore 5
    //   448: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   451: aload 5
    //   453: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   456: goto -22 -> 434
    //   459: astore 5
    //   461: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   464: aload 5
    //   466: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   469: goto -25 -> 444
    //   472: astore_1
    //   473: goto -51 -> 422
    //   476: astore_1
    //   477: aconst_null
    //   478: astore 6
    //   480: goto -147 -> 333
    //   483: iconst_0
    //   484: istore_2
    //   485: goto -359 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	af
    //   0	488	1	parame	e
    //   125	360	2	i1	int
    //   182	116	3	l1	long
    //   13	415	5	localObject	Object
    //   446	6	5	localThrowable1	Throwable
    //   459	6	5	localThrowable2	Throwable
    //   89	390	6	localCursor	Cursor
    //   6	313	7	str	String
    //   22	271	8	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   95	105	332	java/lang/Throwable
    //   109	124	332	java/lang/Throwable
    //   130	140	332	java/lang/Throwable
    //   149	183	332	java/lang/Throwable
    //   195	219	332	java/lang/Throwable
    //   223	233	332	java/lang/Throwable
    //   262	277	332	java/lang/Throwable
    //   281	298	332	java/lang/Throwable
    //   305	329	332	java/lang/Throwable
    //   356	366	369	java/lang/Throwable
    //   238	245	380	finally
    //   245	255	380	finally
    //   349	356	380	finally
    //   356	366	380	finally
    //   370	377	380	finally
    //   386	393	380	finally
    //   397	404	380	finally
    //   408	415	380	finally
    //   427	434	380	finally
    //   434	444	380	finally
    //   444	446	380	finally
    //   448	456	380	finally
    //   461	469	380	finally
    //   238	245	385	java/lang/Throwable
    //   245	255	396	java/lang/Throwable
    //   349	356	407	java/lang/Throwable
    //   2	91	418	finally
    //   427	434	446	java/lang/Throwable
    //   434	444	459	java/lang/Throwable
    //   95	105	472	finally
    //   109	124	472	finally
    //   130	140	472	finally
    //   149	183	472	finally
    //   195	219	472	finally
    //   223	233	472	finally
    //   262	277	472	finally
    //   281	298	472	finally
    //   305	329	472	finally
    //   337	344	472	finally
    //   2	91	476	java/lang/Throwable
  }
  
  /* Error */
  private void b(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 311	com/tencent/acstat/StatConfig:getMaxStoreEventCount	()I
    //   5: ifle +25 -> 30
    //   8: getstatic 575	com/tencent/acstat/StatConfig:m	I
    //   11: ifle +12 -> 23
    //   14: iload_3
    //   15: ifne +8 -> 23
    //   18: iload 4
    //   20: ifeq +13 -> 33
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: iload_3
    //   27: invokespecial 577	com/tencent/acstat/af:a	(Lcom/tencent/acstat/event/d;Lcom/tencent/acstat/StatDispatchCallback;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: getstatic 575	com/tencent/acstat/StatConfig:m	I
    //   36: ifle -6 -> 30
    //   39: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   42: ifeq +83 -> 125
    //   45: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   48: new 117	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 579
    //   55: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: invokevirtual 580	java/util/concurrent/ConcurrentHashMap:size	()I
    //   65: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc_w 582
    //   71: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: getstatic 575	com/tencent/acstat/StatConfig:m	I
    //   77: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 584
    //   83: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: getfield 70	com/tencent/acstat/af:a	I
    //   90: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   99: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   102: new 117	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 586
    //   109: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 335	com/tencent/acstat/event/d:g	()Ljava/lang/String;
    //   116: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   125: aload_0
    //   126: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   129: aload_1
    //   130: ldc 64
    //   132: invokevirtual 587	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload_0
    //   137: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   140: invokevirtual 580	java/util/concurrent/ConcurrentHashMap:size	()I
    //   143: getstatic 575	com/tencent/acstat/StatConfig:m	I
    //   146: if_icmplt +7 -> 153
    //   149: aload_0
    //   150: invokespecial 284	com/tencent/acstat/af:j	()V
    //   153: aload_2
    //   154: ifnull -124 -> 30
    //   157: aload_0
    //   158: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   161: invokevirtual 580	java/util/concurrent/ConcurrentHashMap:size	()I
    //   164: ifle +7 -> 171
    //   167: aload_0
    //   168: invokespecial 284	com/tencent/acstat/af:j	()V
    //   171: aload_2
    //   172: invokeinterface 388 1 0
    //   177: goto -147 -> 30
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	af
    //   0	185	1	paramd	d
    //   0	185	2	paramStatDispatchCallback	StatDispatchCallback
    //   0	185	3	paramBoolean1	boolean
    //   0	185	4	paramBoolean2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	180	finally
    //   23	30	180	finally
    //   33	125	180	finally
    //   125	153	180	finally
    //   157	171	180	finally
    //   171	177	180	finally
  }
  
  /* Error */
  private void b(List<ao> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: invokespecial 589	com/tencent/acstat/af:e	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   5: astore 7
    //   7: iconst_1
    //   8: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   11: astore 8
    //   13: iload_2
    //   14: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   17: astore 9
    //   19: aload 7
    //   21: ldc_w 322
    //   24: aconst_null
    //   25: ldc_w 591
    //   28: iconst_1
    //   29: anewarray 344	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload 8
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aload 9
    //   42: invokevirtual 452	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 7
    //   47: aload 7
    //   49: invokeinterface 554 1 0
    //   54: ifeq +173 -> 227
    //   57: aload 7
    //   59: iconst_0
    //   60: invokeinterface 595 2 0
    //   65: lstore 5
    //   67: aload 7
    //   69: iconst_1
    //   70: invokeinterface 598 2 0
    //   75: astore 9
    //   77: aload 9
    //   79: astore 8
    //   81: getstatic 600	com/tencent/acstat/StatConfig:g	Z
    //   84: ifne +10 -> 94
    //   87: aload 9
    //   89: invokestatic 603	com/tencent/acstat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 8
    //   94: aload 7
    //   96: iconst_2
    //   97: invokeinterface 558 2 0
    //   102: istore_2
    //   103: aload 7
    //   105: iconst_3
    //   106: invokeinterface 558 2 0
    //   111: istore 4
    //   113: new 186	com/tencent/acstat/ao
    //   116: dup
    //   117: lload 5
    //   119: aload 8
    //   121: iload_2
    //   122: iload 4
    //   124: invokespecial 606	com/tencent/acstat/ao:<init>	(JLjava/lang/String;II)V
    //   127: astore 8
    //   129: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   132: ifeq +55 -> 187
    //   135: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   138: new 117	java/lang/StringBuilder
    //   141: dup
    //   142: ldc_w 608
    //   145: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: lload 5
    //   150: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: ldc_w 610
    //   156: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 4
    //   161: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: ldc_w 612
    //   167: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 7
    //   172: iconst_4
    //   173: invokeinterface 595 2 0
    //   178: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   181: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   187: aload_1
    //   188: aload 8
    //   190: invokeinterface 616 2 0
    //   195: pop
    //   196: goto -149 -> 47
    //   199: astore 8
    //   201: aload 7
    //   203: astore_1
    //   204: aload 8
    //   206: astore 7
    //   208: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   211: aload 7
    //   213: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   216: aload_1
    //   217: ifnull +9 -> 226
    //   220: aload_1
    //   221: invokeinterface 460 1 0
    //   226: return
    //   227: aload 7
    //   229: ifnull -3 -> 226
    //   232: aload 7
    //   234: invokeinterface 460 1 0
    //   239: return
    //   240: astore_1
    //   241: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   244: aload_1
    //   245: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   248: return
    //   249: astore_1
    //   250: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   253: aload_1
    //   254: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   257: return
    //   258: astore_1
    //   259: aconst_null
    //   260: astore 7
    //   262: aload 7
    //   264: ifnull +10 -> 274
    //   267: aload 7
    //   269: invokeinterface 460 1 0
    //   274: aload_1
    //   275: athrow
    //   276: astore 7
    //   278: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   281: aload 7
    //   283: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   286: goto -12 -> 274
    //   289: astore_1
    //   290: goto -28 -> 262
    //   293: astore 8
    //   295: aload_1
    //   296: astore 7
    //   298: aload 8
    //   300: astore_1
    //   301: goto -39 -> 262
    //   304: astore 7
    //   306: aconst_null
    //   307: astore_1
    //   308: goto -100 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	af
    //   0	311	1	paramList	List<ao>
    //   0	311	2	paramInt	int
    //   0	311	3	paramBoolean	boolean
    //   111	49	4	i1	int
    //   65	84	5	l1	long
    //   5	263	7	localObject1	Object
    //   276	6	7	localThrowable1	Throwable
    //   296	1	7	localList	List<ao>
    //   304	1	7	localThrowable2	Throwable
    //   11	178	8	localObject2	Object
    //   199	6	8	localThrowable3	Throwable
    //   293	6	8	localObject3	Object
    //   17	71	9	str	String
    // Exception table:
    //   from	to	target	type
    //   47	77	199	java/lang/Throwable
    //   81	94	199	java/lang/Throwable
    //   94	187	199	java/lang/Throwable
    //   187	196	199	java/lang/Throwable
    //   232	239	240	java/lang/Throwable
    //   220	226	249	java/lang/Throwable
    //   0	47	258	finally
    //   267	274	276	java/lang/Throwable
    //   47	77	289	finally
    //   81	94	289	finally
    //   94	187	289	finally
    //   187	196	289	finally
    //   208	216	293	finally
    //   0	47	304	java/lang/Throwable
  }
  
  /* Error */
  private void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 303	com/tencent/acstat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 7
    //   13: aload 7
    //   15: astore 5
    //   17: aload 7
    //   19: astore 6
    //   21: aload 7
    //   23: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   26: aload 7
    //   28: astore 5
    //   30: aload 7
    //   32: astore 6
    //   34: new 330	android/content/ContentValues
    //   37: dup
    //   38: invokespecial 331	android/content/ContentValues:<init>	()V
    //   41: astore 8
    //   43: aload 7
    //   45: astore 5
    //   47: aload 7
    //   49: astore 6
    //   51: aload 8
    //   53: ldc_w 358
    //   56: iconst_1
    //   57: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   63: aload 7
    //   65: astore 5
    //   67: aload 7
    //   69: astore 6
    //   71: aload 7
    //   73: ldc_w 322
    //   76: aload 8
    //   78: ldc_w 591
    //   81: iconst_1
    //   82: anewarray 344	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: ldc2_w 619
    //   90: invokestatic 623	java/lang/Long:toString	(J)Ljava/lang/String;
    //   93: aastore
    //   94: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   97: istore_2
    //   98: aload 7
    //   100: astore 5
    //   102: aload 7
    //   104: astore 6
    //   106: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   109: ifeq +39 -> 148
    //   112: aload 7
    //   114: astore 5
    //   116: aload 7
    //   118: astore 6
    //   120: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   123: new 117	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 625
    //   130: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: iload_2
    //   134: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc 228
    //   139: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   148: aload 7
    //   150: astore 5
    //   152: aload 7
    //   154: astore 6
    //   156: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   159: ldc2_w 626
    //   162: ldiv
    //   163: lstore_3
    //   164: aload 7
    //   166: astore 5
    //   168: aload 7
    //   170: astore 6
    //   172: aload 7
    //   174: new 117	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 629
    //   181: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: lload_3
    //   185: ldc2_w 630
    //   188: lsub
    //   189: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: ldc_w 633
    //   195: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: getstatic 47	com/tencent/acstat/af:j	I
    //   201: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokevirtual 409	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   210: aload 7
    //   212: ifnull +13 -> 225
    //   215: aload 7
    //   217: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   220: aload 7
    //   222: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   225: return
    //   226: astore 5
    //   228: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   231: aload 5
    //   233: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   236: return
    //   237: astore 7
    //   239: aload 5
    //   241: astore 6
    //   243: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   246: aload 7
    //   248: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   251: aload 5
    //   253: ifnull -28 -> 225
    //   256: aload 5
    //   258: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   261: aload 5
    //   263: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   266: return
    //   267: astore 5
    //   269: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   272: aload 5
    //   274: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   277: return
    //   278: astore 5
    //   280: aload 6
    //   282: ifnull +13 -> 295
    //   285: aload 6
    //   287: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   290: aload 6
    //   292: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   295: aload 5
    //   297: athrow
    //   298: astore 6
    //   300: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   303: aload 6
    //   305: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   308: goto -13 -> 295
    //   311: astore 5
    //   313: goto -93 -> 220
    //   316: astore 6
    //   318: goto -57 -> 261
    //   321: astore 7
    //   323: goto -33 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	af
    //   0	326	1	paramBoolean	boolean
    //   97	37	2	i1	int
    //   163	22	3	l1	long
    //   4	163	5	localObject1	Object
    //   226	36	5	localThrowable1	Throwable
    //   267	6	5	localThrowable2	Throwable
    //   278	18	5	localObject2	Object
    //   311	1	5	localException1	java.lang.Exception
    //   1	290	6	localObject3	Object
    //   298	6	6	localThrowable3	Throwable
    //   316	1	6	localException2	java.lang.Exception
    //   11	210	7	localSQLiteDatabase	SQLiteDatabase
    //   237	10	7	localThrowable4	Throwable
    //   321	1	7	localException3	java.lang.Exception
    //   41	36	8	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   215	220	226	java/lang/Throwable
    //   220	225	226	java/lang/Throwable
    //   6	13	237	java/lang/Throwable
    //   21	26	237	java/lang/Throwable
    //   34	43	237	java/lang/Throwable
    //   51	63	237	java/lang/Throwable
    //   71	98	237	java/lang/Throwable
    //   106	112	237	java/lang/Throwable
    //   120	148	237	java/lang/Throwable
    //   156	164	237	java/lang/Throwable
    //   172	210	237	java/lang/Throwable
    //   256	261	267	java/lang/Throwable
    //   261	266	267	java/lang/Throwable
    //   6	13	278	finally
    //   21	26	278	finally
    //   34	43	278	finally
    //   51	63	278	finally
    //   71	98	278	finally
    //   106	112	278	finally
    //   120	148	278	finally
    //   156	164	278	finally
    //   172	210	278	finally
    //   243	251	278	finally
    //   285	290	298	java/lang/Throwable
    //   290	295	298	java/lang/Throwable
    //   215	220	311	java/lang/Exception
    //   256	261	316	java/lang/Exception
    //   285	290	321	java/lang/Exception
  }
  
  private int c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return StatConfig.getMaxSendRetryCount();
    }
    return StatConfig.getMaxImportantDataSendRetryCount();
  }
  
  private boolean c(Context paramContext)
  {
    return (StatPreferences.contains(paramContext, a("uid"))) || (StatPreferences.contains(paramContext, a("user_type"))) || (StatPreferences.contains(paramContext, a("app_ver"))) || (StatPreferences.contains(paramContext, a("ts")));
  }
  
  private SQLiteDatabase d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getWritableDatabase();
    }
    return this.d.getWritableDatabase();
  }
  
  private SQLiteDatabase e(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getReadableDatabase();
    }
    return this.d.getReadableDatabase();
  }
  
  private void f()
  {
    try
    {
      if (!a(false))
      {
        h.warn("delete " + an.a(this.c) + ", and create new one");
        this.c.a();
        this.c = new an(i, this.f);
      }
      if (!a(true))
      {
        h.warn("delete " + an.a(this.d) + ", and create new one");
        this.d.a();
        this.d = new an(i, this.g);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
  }
  
  private void g()
  {
    this.a = (h() + i());
  }
  
  private int h()
  {
    try
    {
      long l1 = DatabaseUtils.queryNumEntries(this.c.getReadableDatabase(), "events");
      return (int)l1;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
    return 0;
  }
  
  private int i()
  {
    try
    {
      long l1 = DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
      return (int)l1;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
    return 0;
  }
  
  private void j()
  {
    localObject5 = null;
    Object localObject1 = null;
    if (this.n) {
      return;
    }
    synchronized (this.m)
    {
      if (this.m.size() == 0) {
        return;
      }
    }
    this.n = true;
    if (StatConfig.isDebugEnable()) {
      h.i("insert " + this.m.size() + " events ,numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.a);
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
      Object localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      Iterator localIterator = this.m.entrySet().iterator();
      for (;;)
      {
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        d locald = (d)((Map.Entry)localIterator.next()).getKey();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        String str = locald.g();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (StatConfig.isDebugEnable())
        {
          localObject3 = localSQLiteDatabase;
          localObject5 = localSQLiteDatabase;
          h.i("insert content:" + str);
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        str = Util.encode(str);
        if (str != null)
        {
          localObject3 = localSQLiteDatabase;
          localObject5 = localSQLiteDatabase;
          if (str.length() < j)
          {
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("content", str);
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("send_count", "0");
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("status", Integer.toString(1));
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("timestamp", Long.valueOf(locald.c()));
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localSQLiteDatabase.insert("events", null, localContentValues);
          }
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localIterator.remove();
      }
      try
      {
        localObject5.endTransaction();
        g();
        throw localObject4;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          h.e(localThrowable3);
        }
      }
    }
    catch (Throwable localThrowable4)
    {
      localObject5 = localObject3;
      h.e(localThrowable4);
      if (localObject3 != null) {}
      try
      {
        localObject3.endTransaction();
        g();
        for (;;)
        {
          this.n = false;
          if (StatConfig.isDebugEnable()) {
            h.i("after insert, cacheEventsInMemory.size():" + this.m.size() + ",numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.a);
          }
          return;
          localObject3 = localThrowable4;
          localObject5 = localThrowable4;
          localThrowable4.setTransactionSuccessful();
          if (localThrowable4 != null) {
            try
            {
              localThrowable4.endTransaction();
              g();
            }
            catch (Throwable localThrowable1)
            {
              h.e(localThrowable1);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          h.e(localThrowable2);
        }
      }
    }
    finally
    {
      if (localObject5 == null) {}
    }
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   4: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 683
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokeinterface 554 1 0
    //   28: ifeq +51 -> 79
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 83	com/tencent/acstat/af:o	Ljava/util/HashMap;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 598 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 598 2 0
    //   51: invokevirtual 684	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: goto -35 -> 20
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   64: aload_3
    //   65: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 460 1 0
    //   78: return
    //   79: aload_2
    //   80: ifnull -2 -> 78
    //   83: aload_2
    //   84: invokeinterface 460 1 0
    //   89: return
    //   90: astore_1
    //   91: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   94: aload_1
    //   95: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   98: return
    //   99: astore_1
    //   100: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   103: aload_1
    //   104: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   107: return
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 460 1 0
    //   121: aload_2
    //   122: athrow
    //   123: astore_1
    //   124: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   127: aload_1
    //   128: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   131: goto -10 -> 121
    //   134: astore_2
    //   135: goto -24 -> 111
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_2
    //   141: goto -82 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	af
    //   21	40	1	localCursor1	Cursor
    //   90	5	1	localThrowable1	Throwable
    //   99	5	1	localThrowable2	Throwable
    //   110	6	1	localObject1	Object
    //   123	5	1	localThrowable3	Throwable
    //   19	65	2	localCursor2	Cursor
    //   108	14	2	localObject2	Object
    //   134	1	2	localObject3	Object
    //   140	1	2	localObject4	Object
    //   58	7	3	localThrowable4	Throwable
    //   138	1	3	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	31	58	java/lang/Throwable
    //   33	55	58	java/lang/Throwable
    //   83	89	90	java/lang/Throwable
    //   72	78	99	java/lang/Throwable
    //   0	20	108	finally
    //   115	121	123	java/lang/Throwable
    //   22	31	134	finally
    //   33	55	134	finally
    //   61	68	134	finally
    //   0	20	138	java/lang/Throwable
  }
  
  public int a()
  {
    return this.a;
  }
  
  void a(int paramInt)
  {
    this.e.post(new am(this, paramInt));
  }
  
  void a(e parame)
  {
    if (parame == null) {
      return;
    }
    this.e.post(new ak(this, parame));
  }
  
  void a(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.post(new aj(this, paramd, paramStatDispatchCallback, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<ao> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.post(new ag(this, paramList, paramInt, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<ao> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.post(new ah(this, paramList, paramBoolean1, paramBoolean2));
    }
  }
  
  /* Error */
  public DeviceInfo b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 717	com/tencent/acstat/af:c	(Landroid/content/Context;)Z
    //   23: ifeq +425 -> 448
    //   26: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   29: ifeq +12 -> 41
    //   32: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   35: ldc_w 719
    //   38: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   41: aload_1
    //   42: aload_0
    //   43: ldc 247
    //   45: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   48: ldc 64
    //   50: invokestatic 722	com/tencent/acstat/common/StatPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 15
    //   55: aload 15
    //   57: invokestatic 603	com/tencent/acstat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 11
    //   62: aload_1
    //   63: aload_0
    //   64: ldc_w 257
    //   67: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   70: iconst_1
    //   71: invokestatic 725	com/tencent/acstat/common/StatPreferences:getInt	(Landroid/content/Context;Ljava/lang/String;I)I
    //   74: istore 5
    //   76: aload_1
    //   77: aload_0
    //   78: ldc_w 265
    //   81: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   84: ldc 64
    //   86: invokestatic 722	com/tencent/acstat/common/StatPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 10
    //   91: aload_1
    //   92: aload_0
    //   93: ldc_w 270
    //   96: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   99: lconst_0
    //   100: invokestatic 728	com/tencent/acstat/common/StatPreferences:getLong	(Landroid/content/Context;Ljava/lang/String;J)J
    //   103: lstore 6
    //   105: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   108: ldc2_w 626
    //   111: ldiv
    //   112: lstore 8
    //   114: iload 5
    //   116: iconst_1
    //   117: if_icmpeq +1250 -> 1367
    //   120: lload 6
    //   122: ldc2_w 626
    //   125: lmul
    //   126: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   129: ldc2_w 626
    //   132: lload 8
    //   134: lmul
    //   135: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   138: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifne +1226 -> 1367
    //   144: iconst_1
    //   145: istore_2
    //   146: iload_2
    //   147: istore_3
    //   148: aload 10
    //   150: aload_1
    //   151: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   154: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifne +7 -> 164
    //   160: iload_2
    //   161: iconst_2
    //   162: ior
    //   163: istore_3
    //   164: aload 11
    //   166: ldc 194
    //   168: invokevirtual 493	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   171: astore 13
    //   173: aload 13
    //   175: ifnull +180 -> 355
    //   178: aload 13
    //   180: arraylength
    //   181: ifle +174 -> 355
    //   184: aload 13
    //   186: iconst_0
    //   187: aaload
    //   188: astore 10
    //   190: aload 10
    //   192: ifnull +13 -> 205
    //   195: aload 10
    //   197: invokevirtual 347	java/lang/String:length	()I
    //   200: bipush 11
    //   202: if_icmpge +1148 -> 1350
    //   205: aload_1
    //   206: invokestatic 737	com/tencent/acstat/common/Util:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   209: astore 12
    //   211: aload 12
    //   213: ifnull +1132 -> 1345
    //   216: aload 12
    //   218: invokevirtual 347	java/lang/String:length	()I
    //   221: bipush 10
    //   223: if_icmple +1122 -> 1345
    //   226: iconst_1
    //   227: istore_2
    //   228: aload 12
    //   230: astore 10
    //   232: goto +1141 -> 1373
    //   235: aload 13
    //   237: ifnull +133 -> 370
    //   240: aload 13
    //   242: arraylength
    //   243: iconst_2
    //   244: if_icmplt +126 -> 370
    //   247: aload 13
    //   249: iconst_1
    //   250: aaload
    //   251: astore 13
    //   253: new 117	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   260: aload 11
    //   262: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 194
    //   267: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 13
    //   272: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore 12
    //   280: iload_2
    //   281: istore 4
    //   283: aload_0
    //   284: new 740	com/tencent/acstat/common/DeviceInfo
    //   287: dup
    //   288: aload 11
    //   290: aload 13
    //   292: iload_3
    //   293: invokespecial 743	com/tencent/acstat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   296: putfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   299: aload 12
    //   301: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore 10
    //   306: iload 4
    //   308: ifeq +23 -> 331
    //   311: aload 10
    //   313: aload 15
    //   315: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq +13 -> 331
    //   321: aload_0
    //   322: aload_1
    //   323: aload 10
    //   325: iload_3
    //   326: lload 8
    //   328: invokespecial 745	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   331: iload_3
    //   332: iload 5
    //   334: if_icmpeq +13 -> 347
    //   337: aload_0
    //   338: aload_1
    //   339: aload 10
    //   341: iload_3
    //   342: lload 8
    //   344: invokespecial 745	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   347: aload_0
    //   348: getfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   351: astore_1
    //   352: goto -338 -> 14
    //   355: aload_1
    //   356: invokestatic 748	com/tencent/acstat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   359: astore 10
    //   361: aload 10
    //   363: astore 11
    //   365: iconst_1
    //   366: istore_2
    //   367: goto -132 -> 235
    //   370: aload_1
    //   371: invokestatic 751	com/tencent/acstat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   374: astore 14
    //   376: aload 14
    //   378: astore 13
    //   380: iload_2
    //   381: istore 4
    //   383: aload 10
    //   385: astore 12
    //   387: aload 14
    //   389: ifnull -106 -> 283
    //   392: aload 14
    //   394: astore 13
    //   396: iload_2
    //   397: istore 4
    //   399: aload 10
    //   401: astore 12
    //   403: aload 14
    //   405: invokevirtual 347	java/lang/String:length	()I
    //   408: ifle -125 -> 283
    //   411: new 117	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   418: aload 11
    //   420: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc 194
    //   425: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload 14
    //   430: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: astore 12
    //   438: iconst_1
    //   439: istore 4
    //   441: aload 14
    //   443: astore 13
    //   445: goto -162 -> 283
    //   448: aload_0
    //   449: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   452: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   455: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   458: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   461: ifeq +12 -> 473
    //   464: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   467: ldc_w 753
    //   470: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   473: aload_0
    //   474: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   477: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   480: ldc_w 755
    //   483: aconst_null
    //   484: aconst_null
    //   485: aconst_null
    //   486: aconst_null
    //   487: aconst_null
    //   488: aconst_null
    //   489: aconst_null
    //   490: invokevirtual 452	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   493: astore 11
    //   495: iconst_0
    //   496: istore_2
    //   497: aload 11
    //   499: invokeinterface 554 1 0
    //   504: ifeq +379 -> 883
    //   507: aload 11
    //   509: iconst_0
    //   510: invokeinterface 598 2 0
    //   515: astore 16
    //   517: aload 16
    //   519: invokestatic 603	com/tencent/acstat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   522: astore 12
    //   524: aload 11
    //   526: iconst_1
    //   527: invokeinterface 558 2 0
    //   532: istore 5
    //   534: aload 11
    //   536: iconst_2
    //   537: invokeinterface 598 2 0
    //   542: astore 10
    //   544: aload 11
    //   546: iconst_3
    //   547: invokeinterface 595 2 0
    //   552: lstore 6
    //   554: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   557: ldc2_w 626
    //   560: ldiv
    //   561: lstore 8
    //   563: iload 5
    //   565: iconst_1
    //   566: if_icmpeq +773 -> 1339
    //   569: lload 6
    //   571: ldc2_w 626
    //   574: lmul
    //   575: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   578: ldc2_w 626
    //   581: lload 8
    //   583: lmul
    //   584: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   587: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   590: ifne +749 -> 1339
    //   593: iconst_1
    //   594: istore_2
    //   595: iload_2
    //   596: istore_3
    //   597: aload 10
    //   599: aload_1
    //   600: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   603: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   606: ifne +7 -> 613
    //   609: iload_2
    //   610: iconst_2
    //   611: ior
    //   612: istore_3
    //   613: aload 12
    //   615: ldc 194
    //   617: invokevirtual 493	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   620: astore 14
    //   622: iconst_0
    //   623: istore 4
    //   625: iconst_0
    //   626: istore_2
    //   627: aload 14
    //   629: ifnull +479 -> 1108
    //   632: aload 14
    //   634: arraylength
    //   635: ifle +473 -> 1108
    //   638: aload 14
    //   640: iconst_0
    //   641: aaload
    //   642: astore 10
    //   644: aload 10
    //   646: ifnull +13 -> 659
    //   649: aload 10
    //   651: invokevirtual 347	java/lang/String:length	()I
    //   654: bipush 11
    //   656: if_icmpge +668 -> 1324
    //   659: aload_1
    //   660: invokestatic 737	com/tencent/acstat/common/Util:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   663: astore 13
    //   665: aload 13
    //   667: ifnull +651 -> 1318
    //   670: aload 13
    //   672: invokevirtual 347	java/lang/String:length	()I
    //   675: bipush 10
    //   677: if_icmple +641 -> 1318
    //   680: iconst_1
    //   681: istore_2
    //   682: aload 13
    //   684: astore 10
    //   686: goto +702 -> 1388
    //   689: aload 14
    //   691: ifnull +432 -> 1123
    //   694: aload 14
    //   696: arraylength
    //   697: iconst_2
    //   698: if_icmplt +425 -> 1123
    //   701: aload 14
    //   703: iconst_1
    //   704: aaload
    //   705: astore 14
    //   707: new 117	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   714: aload 12
    //   716: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: ldc 194
    //   721: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 14
    //   726: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: astore 13
    //   734: iload_2
    //   735: istore 4
    //   737: aload_0
    //   738: new 740	com/tencent/acstat/common/DeviceInfo
    //   741: dup
    //   742: aload 12
    //   744: aload 14
    //   746: iload_3
    //   747: invokespecial 743	com/tencent/acstat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   750: putfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   753: new 330	android/content/ContentValues
    //   756: dup
    //   757: invokespecial 331	android/content/ContentValues:<init>	()V
    //   760: astore 10
    //   762: aload 13
    //   764: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   767: astore 12
    //   769: aload 10
    //   771: ldc 247
    //   773: aload 12
    //   775: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   778: aload 10
    //   780: ldc_w 257
    //   783: iload_3
    //   784: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   787: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   790: aload 10
    //   792: ldc_w 265
    //   795: aload_1
    //   796: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   799: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: aload 10
    //   804: ldc_w 270
    //   807: lload 8
    //   809: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   812: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   815: iload 4
    //   817: ifeq +31 -> 848
    //   820: aload_0
    //   821: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   824: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   827: ldc_w 755
    //   830: aload 10
    //   832: ldc_w 757
    //   835: iconst_1
    //   836: anewarray 344	java/lang/String
    //   839: dup
    //   840: iconst_0
    //   841: aload 16
    //   843: aastore
    //   844: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   847: pop
    //   848: iload_3
    //   849: iload 5
    //   851: if_icmpeq +20 -> 871
    //   854: aload_0
    //   855: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   858: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   861: ldc_w 755
    //   864: aconst_null
    //   865: aload 10
    //   867: invokevirtual 760	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   870: pop2
    //   871: aload_0
    //   872: aload_1
    //   873: aload 12
    //   875: iload_3
    //   876: lload 8
    //   878: invokespecial 745	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   881: iconst_1
    //   882: istore_2
    //   883: iload_2
    //   884: ifne +173 -> 1057
    //   887: aload_1
    //   888: invokestatic 748	com/tencent/acstat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   891: astore 12
    //   893: aload_1
    //   894: invokestatic 751	com/tencent/acstat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   897: astore 13
    //   899: aload 13
    //   901: ifnull +410 -> 1311
    //   904: aload 13
    //   906: invokevirtual 347	java/lang/String:length	()I
    //   909: ifle +402 -> 1311
    //   912: new 117	java/lang/StringBuilder
    //   915: dup
    //   916: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   919: aload 12
    //   921: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: ldc 194
    //   926: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: aload 13
    //   931: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: astore 10
    //   939: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   942: ldc2_w 626
    //   945: ldiv
    //   946: lstore 6
    //   948: aload_1
    //   949: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   952: astore 14
    //   954: new 330	android/content/ContentValues
    //   957: dup
    //   958: invokespecial 331	android/content/ContentValues:<init>	()V
    //   961: astore 15
    //   963: aload 10
    //   965: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   968: astore 10
    //   970: aload 15
    //   972: ldc 247
    //   974: aload 10
    //   976: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: aload 15
    //   981: ldc_w 257
    //   984: iconst_0
    //   985: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   988: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   991: aload 15
    //   993: ldc_w 265
    //   996: aload 14
    //   998: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1001: aload 15
    //   1003: ldc_w 270
    //   1006: lload 6
    //   1008: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1011: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1014: aload_0
    //   1015: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1018: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1021: ldc_w 755
    //   1024: aconst_null
    //   1025: aload 15
    //   1027: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1030: pop2
    //   1031: aload_0
    //   1032: aload_1
    //   1033: aload 10
    //   1035: iconst_0
    //   1036: lload 6
    //   1038: invokespecial 745	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   1041: aload_0
    //   1042: new 740	com/tencent/acstat/common/DeviceInfo
    //   1045: dup
    //   1046: aload 12
    //   1048: aload 13
    //   1050: iconst_0
    //   1051: invokespecial 743	com/tencent/acstat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1054: putfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   1057: aload_0
    //   1058: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1061: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1064: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   1067: aload 11
    //   1069: ifnull +10 -> 1079
    //   1072: aload 11
    //   1074: invokeinterface 460 1 0
    //   1079: aload_0
    //   1080: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1083: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1086: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1089: goto -742 -> 347
    //   1092: astore_1
    //   1093: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1096: aload_1
    //   1097: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1100: goto -753 -> 347
    //   1103: astore_1
    //   1104: aload_0
    //   1105: monitorexit
    //   1106: aload_1
    //   1107: athrow
    //   1108: aload_1
    //   1109: invokestatic 748	com/tencent/acstat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   1112: astore 10
    //   1114: iconst_1
    //   1115: istore_2
    //   1116: aload 10
    //   1118: astore 12
    //   1120: goto -431 -> 689
    //   1123: aload_1
    //   1124: invokestatic 751	com/tencent/acstat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   1127: astore 15
    //   1129: iload_2
    //   1130: istore 4
    //   1132: aload 15
    //   1134: astore 14
    //   1136: aload 10
    //   1138: astore 13
    //   1140: aload 15
    //   1142: ifnull -405 -> 737
    //   1145: iload_2
    //   1146: istore 4
    //   1148: aload 15
    //   1150: astore 14
    //   1152: aload 10
    //   1154: astore 13
    //   1156: aload 15
    //   1158: invokevirtual 347	java/lang/String:length	()I
    //   1161: ifle -424 -> 737
    //   1164: new 117	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   1171: aload 12
    //   1173: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: ldc 194
    //   1178: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: aload 15
    //   1183: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: astore 13
    //   1191: iconst_1
    //   1192: istore 4
    //   1194: aload 15
    //   1196: astore 14
    //   1198: goto -461 -> 737
    //   1201: astore 10
    //   1203: aconst_null
    //   1204: astore_1
    //   1205: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1208: aload 10
    //   1210: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1213: aload_1
    //   1214: ifnull +9 -> 1223
    //   1217: aload_1
    //   1218: invokeinterface 460 1 0
    //   1223: aload_0
    //   1224: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1227: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1230: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1233: goto -886 -> 347
    //   1236: astore_1
    //   1237: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1240: aload_1
    //   1241: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1244: goto -897 -> 347
    //   1247: astore_1
    //   1248: aconst_null
    //   1249: astore 11
    //   1251: aload 11
    //   1253: ifnull +10 -> 1263
    //   1256: aload 11
    //   1258: invokeinterface 460 1 0
    //   1263: aload_0
    //   1264: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1267: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1270: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1273: aload_1
    //   1274: athrow
    //   1275: astore 10
    //   1277: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1280: aload 10
    //   1282: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1285: goto -12 -> 1273
    //   1288: astore_1
    //   1289: goto -38 -> 1251
    //   1292: astore 10
    //   1294: aload_1
    //   1295: astore 11
    //   1297: aload 10
    //   1299: astore_1
    //   1300: goto -49 -> 1251
    //   1303: astore 10
    //   1305: aload 11
    //   1307: astore_1
    //   1308: goto -103 -> 1205
    //   1311: aload 12
    //   1313: astore 10
    //   1315: goto -376 -> 939
    //   1318: iload 4
    //   1320: istore_2
    //   1321: goto +67 -> 1388
    //   1324: aload 10
    //   1326: astore 13
    //   1328: aload 12
    //   1330: astore 10
    //   1332: aload 13
    //   1334: astore 12
    //   1336: goto -647 -> 689
    //   1339: iload 5
    //   1341: istore_2
    //   1342: goto -747 -> 595
    //   1345: iconst_0
    //   1346: istore_2
    //   1347: goto +26 -> 1373
    //   1350: iconst_0
    //   1351: istore_2
    //   1352: aload 10
    //   1354: astore 12
    //   1356: aload 11
    //   1358: astore 10
    //   1360: aload 12
    //   1362: astore 11
    //   1364: goto -1129 -> 235
    //   1367: iload 5
    //   1369: istore_2
    //   1370: goto -1224 -> 146
    //   1373: aload 10
    //   1375: astore 12
    //   1377: aload 11
    //   1379: astore 10
    //   1381: aload 12
    //   1383: astore 11
    //   1385: goto -1150 -> 235
    //   1388: aload 10
    //   1390: astore 13
    //   1392: aload 12
    //   1394: astore 10
    //   1396: aload 13
    //   1398: astore 12
    //   1400: goto -711 -> 689
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1403	0	this	af
    //   0	1403	1	paramContext	Context
    //   145	1225	2	i1	int
    //   147	729	3	i2	int
    //   281	1038	4	i3	int
    //   74	1294	5	i4	int
    //   103	934	6	l1	long
    //   112	765	8	l2	long
    //   89	1064	10	localObject1	Object
    //   1201	8	10	localThrowable1	Throwable
    //   1275	6	10	localThrowable2	Throwable
    //   1292	6	10	localObject2	Object
    //   1303	1	10	localThrowable3	Throwable
    //   1313	82	10	localObject3	Object
    //   60	1324	11	localObject4	Object
    //   209	1190	12	localObject5	Object
    //   171	1226	13	localObject6	Object
    //   374	823	14	localObject7	Object
    //   53	1142	15	localObject8	Object
    //   515	327	16	str	String
    // Exception table:
    //   from	to	target	type
    //   1072	1079	1092	java/lang/Throwable
    //   1079	1089	1092	java/lang/Throwable
    //   2	14	1103	finally
    //   18	41	1103	finally
    //   41	114	1103	finally
    //   120	144	1103	finally
    //   148	160	1103	finally
    //   164	173	1103	finally
    //   178	184	1103	finally
    //   195	205	1103	finally
    //   205	211	1103	finally
    //   216	226	1103	finally
    //   240	247	1103	finally
    //   253	280	1103	finally
    //   283	306	1103	finally
    //   311	331	1103	finally
    //   337	347	1103	finally
    //   347	352	1103	finally
    //   355	361	1103	finally
    //   370	376	1103	finally
    //   403	438	1103	finally
    //   1072	1079	1103	finally
    //   1079	1089	1103	finally
    //   1093	1100	1103	finally
    //   1217	1223	1103	finally
    //   1223	1233	1103	finally
    //   1237	1244	1103	finally
    //   1256	1263	1103	finally
    //   1263	1273	1103	finally
    //   1273	1275	1103	finally
    //   1277	1285	1103	finally
    //   448	473	1201	java/lang/Throwable
    //   473	495	1201	java/lang/Throwable
    //   1217	1223	1236	java/lang/Throwable
    //   1223	1233	1236	java/lang/Throwable
    //   448	473	1247	finally
    //   473	495	1247	finally
    //   1256	1263	1275	java/lang/Throwable
    //   1263	1273	1275	java/lang/Throwable
    //   497	563	1288	finally
    //   569	593	1288	finally
    //   597	609	1288	finally
    //   613	622	1288	finally
    //   632	638	1288	finally
    //   649	659	1288	finally
    //   659	665	1288	finally
    //   670	680	1288	finally
    //   694	701	1288	finally
    //   707	734	1288	finally
    //   737	815	1288	finally
    //   820	848	1288	finally
    //   854	871	1288	finally
    //   871	881	1288	finally
    //   887	899	1288	finally
    //   904	939	1288	finally
    //   939	1057	1288	finally
    //   1057	1067	1288	finally
    //   1108	1114	1288	finally
    //   1123	1129	1288	finally
    //   1156	1191	1288	finally
    //   1205	1213	1292	finally
    //   497	563	1303	java/lang/Throwable
    //   569	593	1303	java/lang/Throwable
    //   597	609	1303	java/lang/Throwable
    //   613	622	1303	java/lang/Throwable
    //   632	638	1303	java/lang/Throwable
    //   649	659	1303	java/lang/Throwable
    //   659	665	1303	java/lang/Throwable
    //   670	680	1303	java/lang/Throwable
    //   694	701	1303	java/lang/Throwable
    //   707	734	1303	java/lang/Throwable
    //   737	815	1303	java/lang/Throwable
    //   820	848	1303	java/lang/Throwable
    //   854	871	1303	java/lang/Throwable
    //   871	881	1303	java/lang/Throwable
    //   887	899	1303	java/lang/Throwable
    //   904	939	1303	java/lang/Throwable
    //   939	1057	1303	java/lang/Throwable
    //   1057	1067	1303	java/lang/Throwable
    //   1108	1114	1303	java/lang/Throwable
    //   1123	1129	1303	java/lang/Throwable
    //   1156	1191	1303	java/lang/Throwable
  }
  
  void c()
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    try
    {
      this.e.post(new ai(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   4: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 548
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: invokeinterface 554 1 0
    //   31: ifeq +151 -> 182
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 558 2 0
    //   45: istore_1
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: iconst_1
    //   52: invokeinterface 598 2 0
    //   57: astore 5
    //   59: aload 4
    //   61: astore_3
    //   62: aload 4
    //   64: iconst_2
    //   65: invokeinterface 598 2 0
    //   70: astore 6
    //   72: aload 4
    //   74: astore_3
    //   75: aload 4
    //   77: iconst_3
    //   78: invokeinterface 558 2 0
    //   83: istore_2
    //   84: aload 4
    //   86: astore_3
    //   87: new 522	com/tencent/acstat/e
    //   90: dup
    //   91: iload_1
    //   92: invokespecial 768	com/tencent/acstat/e:<init>	(I)V
    //   95: astore 7
    //   97: aload 4
    //   99: astore_3
    //   100: aload 7
    //   102: iload_1
    //   103: putfield 559	com/tencent/acstat/e:a	I
    //   106: aload 4
    //   108: astore_3
    //   109: aload 7
    //   111: new 532	org/json/JSONObject
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 769	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: putfield 530	com/tencent/acstat/e:b	Lorg/json/JSONObject;
    //   123: aload 4
    //   125: astore_3
    //   126: aload 7
    //   128: aload 6
    //   130: putfield 536	com/tencent/acstat/e:c	Ljava/lang/String;
    //   133: aload 4
    //   135: astore_3
    //   136: aload 7
    //   138: iload_2
    //   139: putfield 540	com/tencent/acstat/e:d	I
    //   142: aload 4
    //   144: astore_3
    //   145: getstatic 44	com/tencent/acstat/af:i	Landroid/content/Context;
    //   148: aload 7
    //   150: invokestatic 772	com/tencent/acstat/StatConfig:a	(Landroid/content/Context;Lcom/tencent/acstat/e;)V
    //   153: goto -132 -> 21
    //   156: astore 5
    //   158: aload 4
    //   160: astore_3
    //   161: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   164: aload 5
    //   166: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 460 1 0
    //   181: return
    //   182: aload 4
    //   184: ifnull -3 -> 181
    //   187: aload 4
    //   189: invokeinterface 460 1 0
    //   194: return
    //   195: astore_3
    //   196: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   199: aload_3
    //   200: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   203: return
    //   204: astore_3
    //   205: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   208: aload_3
    //   209: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   212: return
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_3
    //   217: aload_3
    //   218: ifnull +9 -> 227
    //   221: aload_3
    //   222: invokeinterface 460 1 0
    //   227: aload 4
    //   229: athrow
    //   230: astore_3
    //   231: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   234: aload_3
    //   235: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   238: goto -11 -> 227
    //   241: astore 4
    //   243: goto -26 -> 217
    //   246: astore 5
    //   248: aconst_null
    //   249: astore 4
    //   251: goto -93 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	af
    //   45	58	1	i1	int
    //   83	56	2	i2	int
    //   23	138	3	localCursor1	Cursor
    //   195	5	3	localThrowable1	Throwable
    //   204	5	3	localThrowable2	Throwable
    //   216	6	3	localObject1	Object
    //   230	5	3	localThrowable3	Throwable
    //   19	169	4	localCursor2	Cursor
    //   213	15	4	localObject2	Object
    //   241	1	4	localObject3	Object
    //   249	1	4	localObject4	Object
    //   57	59	5	str1	String
    //   156	9	5	localThrowable4	Throwable
    //   246	1	5	localThrowable5	Throwable
    //   70	59	6	str2	String
    //   95	54	7	locale	e
    // Exception table:
    //   from	to	target	type
    //   24	34	156	java/lang/Throwable
    //   37	46	156	java/lang/Throwable
    //   49	59	156	java/lang/Throwable
    //   62	72	156	java/lang/Throwable
    //   75	84	156	java/lang/Throwable
    //   87	97	156	java/lang/Throwable
    //   100	106	156	java/lang/Throwable
    //   109	123	156	java/lang/Throwable
    //   126	133	156	java/lang/Throwable
    //   136	142	156	java/lang/Throwable
    //   145	153	156	java/lang/Throwable
    //   187	194	195	java/lang/Throwable
    //   174	181	204	java/lang/Throwable
    //   0	21	213	finally
    //   221	227	230	java/lang/Throwable
    //   24	34	241	finally
    //   37	46	241	finally
    //   49	59	241	finally
    //   62	72	241	finally
    //   75	84	241	finally
    //   87	97	241	finally
    //   100	106	241	finally
    //   109	123	241	finally
    //   126	133	241	finally
    //   136	142	241	finally
    //   145	153	241	finally
    //   161	169	241	finally
    //   0	21	246	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.af
 * JD-Core Version:    0.7.0.1
 */