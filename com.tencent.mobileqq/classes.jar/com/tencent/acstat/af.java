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
import com.tencent.acstat.event.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
      Object localObject = new HandlerThread("StatStore");
      ((HandlerThread)localObject).start();
      this.e = new Handler(((HandlerThread)localObject).getLooper());
      i = paramContext.getApplicationContext();
      this.m = new ConcurrentHashMap();
      this.f = StatCommonHelper.getDatabaseName(paramContext);
      localObject = new StringBuilder("pri_");
      ((StringBuilder)localObject).append(StatCommonHelper.getDatabaseName(paramContext));
      this.g = ((StringBuilder)localObject).toString();
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
    if (k == null) {
      try
      {
        if (k == null) {
          k = new af(paramContext);
        }
      }
      finally {}
    }
    return k;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("tencent_mta_sp_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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
  
  /* Error */
  private void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/acstat/af:a	I
    //   6: ifle +171 -> 177
    //   9: iload_1
    //   10: ifle +167 -> 177
    //   13: invokestatic 203	com/tencent/acstat/StatServiceImpl:a	()Z
    //   16: ifeq +6 -> 22
    //   19: goto +158 -> 177
    //   22: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   25: ifeq +45 -> 70
    //   28: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   31: astore_3
    //   32: new 117	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 210
    //   38: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: aload_0
    //   46: getfield 70	com/tencent/acstat/af:a	I
    //   49: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 4
    //   55: ldc 215
    //   57: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: aload 4
    //   64: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   70: new 220	java/util/ArrayList
    //   73: dup
    //   74: iload_1
    //   75: invokespecial 221	java/util/ArrayList:<init>	(I)V
    //   78: astore_3
    //   79: aload_0
    //   80: aload_3
    //   81: iload_1
    //   82: iload_2
    //   83: invokespecial 224	com/tencent/acstat/af:b	(Ljava/util/List;IZ)V
    //   86: aload_3
    //   87: invokeinterface 165 1 0
    //   92: ifle +82 -> 174
    //   95: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   98: ifeq +49 -> 147
    //   101: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   104: astore 4
    //   106: new 117	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 226
    //   112: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: astore 5
    //   117: aload 5
    //   119: aload_3
    //   120: invokeinterface 165 1 0
    //   125: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 5
    //   131: ldc 228
    //   133: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: aload 5
    //   141: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   147: aload_0
    //   148: aload_3
    //   149: iconst_2
    //   150: iload_2
    //   151: invokespecial 230	com/tencent/acstat/af:a	(Ljava/util/List;IZ)V
    //   154: getstatic 44	com/tencent/acstat/af:i	Landroid/content/Context;
    //   157: invokestatic 235	com/tencent/acstat/g:b	(Landroid/content/Context;)Lcom/tencent/acstat/g;
    //   160: aload_3
    //   161: new 237	com/tencent/acstat/al
    //   164: dup
    //   165: aload_0
    //   166: aload_3
    //   167: iload_2
    //   168: invokespecial 240	com/tencent/acstat/al:<init>	(Lcom/tencent/acstat/af;Ljava/util/List;Z)V
    //   171: invokevirtual 243	com/tencent/acstat/g:b	(Ljava/util/List;Lcom/tencent/acstat/StatDispatchCallback;)V
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: astore_3
    //   181: goto +14 -> 195
    //   184: astore_3
    //   185: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   188: aload_3
    //   189: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   192: aload_0
    //   193: monitorexit
    //   194: return
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_3
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	af
    //   0	199	1	paramInt	int
    //   0	199	2	paramBoolean	boolean
    //   31	136	3	localObject1	Object
    //   180	1	3	localObject2	Object
    //   184	14	3	localThrowable	Throwable
    //   41	97	4	localObject3	Object
    //   115	25	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	9	180	finally
    //   13	19	180	finally
    //   22	70	180	finally
    //   70	147	180	finally
    //   147	174	180	finally
    //   185	192	180	finally
    //   2	9	184	java/lang/Throwable
    //   13	19	184	java/lang/Throwable
    //   22	70	184	java/lang/Throwable
    //   70	147	184	java/lang/Throwable
    //   147	174	184	java/lang/Throwable
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
  
  /* Error */
  private void a(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: iload_3
    //   8: invokespecial 303	com/tencent/acstat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 9
    //   13: aload 9
    //   15: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   18: iload_3
    //   19: ifne +48 -> 67
    //   22: aload_0
    //   23: getfield 70	com/tencent/acstat/af:a	I
    //   26: invokestatic 311	com/tencent/acstat/StatConfig:getMaxStoreEventCount	()I
    //   29: if_icmple +38 -> 67
    //   32: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   35: ldc_w 313
    //   38: invokevirtual 316	com/tencent/acstat/common/StatLogger:warn	(Ljava/lang/Object;)V
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 70	com/tencent/acstat/af:a	I
    //   46: aload_0
    //   47: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   50: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: ldc_w 322
    //   56: ldc_w 324
    //   59: aconst_null
    //   60: invokevirtual 328	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   63: isub
    //   64: putfield 70	com/tencent/acstat/af:a	I
    //   67: new 330	android/content/ContentValues
    //   70: dup
    //   71: invokespecial 331	android/content/ContentValues:<init>	()V
    //   74: astore 8
    //   76: aload_1
    //   77: invokevirtual 335	com/tencent/acstat/event/d:g	()Ljava/lang/String;
    //   80: astore 10
    //   82: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   85: ifeq +38 -> 123
    //   88: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   91: astore 11
    //   93: new 117	java/lang/StringBuilder
    //   96: dup
    //   97: ldc_w 337
    //   100: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: astore 12
    //   105: aload 12
    //   107: aload 10
    //   109: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 11
    //   115: aload 12
    //   117: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   123: aload 10
    //   125: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 10
    //   130: aload 10
    //   132: ifnull +313 -> 445
    //   135: aload 10
    //   137: invokevirtual 347	java/lang/String:length	()I
    //   140: getstatic 47	com/tencent/acstat/af:j	I
    //   143: if_icmpge +302 -> 445
    //   146: aload 8
    //   148: ldc_w 349
    //   151: aload 10
    //   153: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 8
    //   158: ldc_w 354
    //   161: ldc_w 356
    //   164: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 8
    //   169: ldc_w 358
    //   172: iconst_1
    //   173: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   176: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 8
    //   181: ldc_w 363
    //   184: aload_1
    //   185: invokevirtual 366	com/tencent/acstat/event/d:c	()J
    //   188: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   194: aload 9
    //   196: ldc_w 322
    //   199: aconst_null
    //   200: aload 8
    //   202: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   205: lstore 4
    //   207: goto +3 -> 210
    //   210: aload 9
    //   212: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   215: lload 4
    //   217: lstore 6
    //   219: aload 9
    //   221: ifnull +94 -> 315
    //   224: lload 4
    //   226: lstore 6
    //   228: aload 9
    //   230: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   233: lload 4
    //   235: lstore 6
    //   237: goto +78 -> 315
    //   240: astore 8
    //   242: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   245: aload 8
    //   247: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   250: goto +65 -> 315
    //   253: astore_1
    //   254: goto +168 -> 422
    //   257: astore 10
    //   259: goto +17 -> 276
    //   262: astore_1
    //   263: aload 8
    //   265: astore 9
    //   267: goto +155 -> 422
    //   270: astore 10
    //   272: aload 11
    //   274: astore 9
    //   276: ldc2_w 380
    //   279: lstore 4
    //   281: aload 9
    //   283: astore 8
    //   285: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   288: aload 10
    //   290: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   293: lload 4
    //   295: lstore 6
    //   297: aload 9
    //   299: ifnull +16 -> 315
    //   302: lload 4
    //   304: lstore 6
    //   306: aload 9
    //   308: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   311: lload 4
    //   313: lstore 6
    //   315: lload 6
    //   317: lconst_0
    //   318: lcmp
    //   319: ifle +67 -> 386
    //   322: aload_0
    //   323: aload_0
    //   324: getfield 70	com/tencent/acstat/af:a	I
    //   327: iconst_1
    //   328: iadd
    //   329: putfield 70	com/tencent/acstat/af:a	I
    //   332: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   335: ifeq +40 -> 375
    //   338: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   341: astore 8
    //   343: new 117	java/lang/StringBuilder
    //   346: dup
    //   347: ldc_w 383
    //   350: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   353: astore 9
    //   355: aload 9
    //   357: aload_1
    //   358: invokevirtual 335	com/tencent/acstat/event/d:g	()Ljava/lang/String;
    //   361: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 8
    //   367: aload 9
    //   369: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokevirtual 385	com/tencent/acstat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   375: aload_2
    //   376: ifnull +45 -> 421
    //   379: aload_2
    //   380: invokeinterface 390 1 0
    //   385: return
    //   386: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   389: astore_2
    //   390: new 117	java/lang/StringBuilder
    //   393: dup
    //   394: ldc_w 392
    //   397: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: astore 8
    //   402: aload 8
    //   404: aload_1
    //   405: invokevirtual 335	com/tencent/acstat/event/d:g	()Ljava/lang/String;
    //   408: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_2
    //   413: aload 8
    //   415: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokevirtual 395	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   421: return
    //   422: aload 9
    //   424: ifnull +19 -> 443
    //   427: aload 9
    //   429: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   432: goto +11 -> 443
    //   435: astore_2
    //   436: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   439: aload_2
    //   440: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   443: aload_1
    //   444: athrow
    //   445: lconst_0
    //   446: lstore 4
    //   448: goto -238 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	af
    //   0	451	1	paramd	d
    //   0	451	2	paramStatDispatchCallback	StatDispatchCallback
    //   0	451	3	paramBoolean	boolean
    //   205	242	4	l1	long
    //   217	99	6	l2	long
    //   4	197	8	localContentValues	ContentValues
    //   240	24	8	localThrowable1	Throwable
    //   283	131	8	localObject1	Object
    //   11	417	9	localObject2	Object
    //   80	72	10	str	String
    //   257	1	10	localThrowable2	Throwable
    //   270	19	10	localThrowable3	Throwable
    //   1	272	11	localStatLogger	StatLogger
    //   103	13	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   228	233	240	java/lang/Throwable
    //   306	311	240	java/lang/Throwable
    //   13	18	253	finally
    //   22	67	253	finally
    //   67	123	253	finally
    //   123	130	253	finally
    //   135	207	253	finally
    //   210	215	253	finally
    //   13	18	257	java/lang/Throwable
    //   22	67	257	java/lang/Throwable
    //   67	123	257	java/lang/Throwable
    //   123	130	257	java/lang/Throwable
    //   135	207	257	java/lang/Throwable
    //   210	215	257	java/lang/Throwable
    //   6	13	262	finally
    //   285	293	262	finally
    //   6	13	270	java/lang/Throwable
    //   427	432	435	java/lang/Throwable
  }
  
  /* Error */
  private void a(List<ao> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 165 1 0
    //   8: istore 4
    //   10: iload 4
    //   12: ifne +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: iload_3
    //   20: invokespecial 398	com/tencent/acstat/af:c	(Z)I
    //   23: istore 4
    //   25: aconst_null
    //   26: astore 8
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore 9
    //   34: aconst_null
    //   35: astore 7
    //   37: aload_0
    //   38: iload_3
    //   39: invokespecial 303	com/tencent/acstat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   42: astore 6
    //   44: iload_2
    //   45: iconst_2
    //   46: if_icmpne +55 -> 101
    //   49: new 117	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 400
    //   56: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: astore 5
    //   61: aload 5
    //   63: iload_2
    //   64: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 5
    //   70: ldc_w 402
    //   73: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 5
    //   79: aload_0
    //   80: aload_1
    //   81: invokespecial 404	com/tencent/acstat/af:a	(Ljava/util/List;)Ljava/lang/String;
    //   84: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 5
    //   95: aload 8
    //   97: astore_1
    //   98: goto +94 -> 192
    //   101: new 117	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 400
    //   108: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: astore 5
    //   113: aload 5
    //   115: iload_2
    //   116: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: ldc_w 406
    //   125: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 5
    //   131: aload_0
    //   132: aload_1
    //   133: invokespecial 404	com/tencent/acstat/af:a	(Ljava/util/List;)Ljava/lang/String;
    //   136: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 5
    //   142: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: aload 7
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 74	com/tencent/acstat/af:l	I
    //   154: iconst_3
    //   155: irem
    //   156: ifne +26 -> 182
    //   159: new 117	java/lang/StringBuilder
    //   162: dup
    //   163: ldc_w 408
    //   166: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: astore_1
    //   170: aload_1
    //   171: iload 4
    //   173: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore_1
    //   182: aload_0
    //   183: aload_0
    //   184: getfield 74	com/tencent/acstat/af:l	I
    //   187: iconst_1
    //   188: iadd
    //   189: putfield 74	com/tencent/acstat/af:l	I
    //   192: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   195: ifeq +38 -> 233
    //   198: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   201: astore 7
    //   203: new 117	java/lang/StringBuilder
    //   206: dup
    //   207: ldc_w 410
    //   210: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: astore 8
    //   215: aload 8
    //   217: aload 5
    //   219: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 7
    //   225: aload 8
    //   227: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   233: aload 6
    //   235: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   238: aload 6
    //   240: aload 5
    //   242: invokevirtual 413	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   245: aload_1
    //   246: ifnull +47 -> 293
    //   249: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   252: astore 5
    //   254: new 117	java/lang/StringBuilder
    //   257: dup
    //   258: ldc_w 415
    //   261: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: astore 7
    //   266: aload 7
    //   268: aload_1
    //   269: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 5
    //   275: aload 7
    //   277: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   283: aload 6
    //   285: aload_1
    //   286: invokevirtual 413	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   289: aload_0
    //   290: invokespecial 140	com/tencent/acstat/af:g	()V
    //   293: aload 6
    //   295: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   298: aload 6
    //   300: ifnull +84 -> 384
    //   303: aload 6
    //   305: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   308: aload_0
    //   309: monitorexit
    //   310: return
    //   311: astore_1
    //   312: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   315: aload_1
    //   316: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   319: aload_0
    //   320: monitorexit
    //   321: return
    //   322: astore_1
    //   323: aload 6
    //   325: astore 5
    //   327: goto +60 -> 387
    //   330: astore 5
    //   332: aload 6
    //   334: astore_1
    //   335: aload 5
    //   337: astore 6
    //   339: goto +12 -> 351
    //   342: astore_1
    //   343: goto +44 -> 387
    //   346: astore 6
    //   348: aload 9
    //   350: astore_1
    //   351: aload_1
    //   352: astore 5
    //   354: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   357: aload 6
    //   359: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   362: aload_1
    //   363: ifnull +21 -> 384
    //   366: aload_1
    //   367: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   370: aload_0
    //   371: monitorexit
    //   372: return
    //   373: astore_1
    //   374: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   377: aload_1
    //   378: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   381: aload_0
    //   382: monitorexit
    //   383: return
    //   384: aload_0
    //   385: monitorexit
    //   386: return
    //   387: aload 5
    //   389: ifnull +21 -> 410
    //   392: aload 5
    //   394: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   397: goto +13 -> 410
    //   400: astore 5
    //   402: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   405: aload 5
    //   407: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   410: aload_1
    //   411: athrow
    //   412: astore_1
    //   413: aload_0
    //   414: monitorexit
    //   415: aload_1
    //   416: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	af
    //   0	417	1	paramList	List<ao>
    //   0	417	2	paramInt	int
    //   0	417	3	paramBoolean	boolean
    //   8	164	4	i1	int
    //   29	297	5	localObject1	Object
    //   330	6	5	localThrowable1	Throwable
    //   352	41	5	localList	List<ao>
    //   400	6	5	localThrowable2	Throwable
    //   42	296	6	localObject2	Object
    //   346	12	6	localThrowable3	Throwable
    //   35	241	7	localObject3	Object
    //   26	200	8	localStringBuilder	StringBuilder
    //   32	317	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   303	308	311	java/lang/Throwable
    //   49	95	322	finally
    //   101	147	322	finally
    //   150	182	322	finally
    //   182	192	322	finally
    //   192	233	322	finally
    //   233	245	322	finally
    //   249	293	322	finally
    //   293	298	322	finally
    //   49	95	330	java/lang/Throwable
    //   101	147	330	java/lang/Throwable
    //   150	182	330	java/lang/Throwable
    //   182	192	330	java/lang/Throwable
    //   192	233	330	java/lang/Throwable
    //   233	245	330	java/lang/Throwable
    //   249	293	330	java/lang/Throwable
    //   293	298	330	java/lang/Throwable
    //   37	44	342	finally
    //   354	362	342	finally
    //   37	44	346	java/lang/Throwable
    //   366	370	373	java/lang/Throwable
    //   392	397	400	java/lang/Throwable
    //   2	10	412	finally
    //   18	25	412	finally
    //   303	308	412	finally
    //   312	319	412	finally
    //   366	370	412	finally
    //   374	381	412	finally
    //   392	397	412	finally
    //   402	410	412	finally
    //   410	412	412	finally
  }
  
  /* Error */
  private void a(List<ao> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 165 1 0
    //   8: istore_3
    //   9: iload_3
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   19: ifeq +58 -> 77
    //   22: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   25: astore 5
    //   27: new 117	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 418
    //   34: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: astore 6
    //   39: aload 6
    //   41: aload_1
    //   42: invokeinterface 165 1 0
    //   47: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 6
    //   53: ldc_w 420
    //   56: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 6
    //   62: iload_2
    //   63: invokevirtual 423	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 5
    //   69: aload 6
    //   71: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   77: new 117	java/lang/StringBuilder
    //   80: dup
    //   81: aload_1
    //   82: invokeinterface 165 1 0
    //   87: iconst_3
    //   88: imul
    //   89: invokespecial 168	java/lang/StringBuilder:<init>	(I)V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc 170
    //   98: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: iconst_0
    //   103: istore_3
    //   104: aload_1
    //   105: invokeinterface 165 1 0
    //   110: istore 4
    //   112: aload_1
    //   113: invokeinterface 174 1 0
    //   118: astore_1
    //   119: aload_1
    //   120: invokeinterface 180 1 0
    //   125: ifeq +40 -> 165
    //   128: aload 6
    //   130: aload_1
    //   131: invokeinterface 184 1 0
    //   136: checkcast 186	com/tencent/acstat/ao
    //   139: getfield 189	com/tencent/acstat/ao:a	J
    //   142: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: iload_3
    //   147: iload 4
    //   149: iconst_1
    //   150: isub
    //   151: if_icmpeq +304 -> 455
    //   154: aload 6
    //   156: ldc 194
    //   158: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: goto +293 -> 455
    //   165: aload 6
    //   167: ldc 196
    //   169: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_0
    //   174: iload_2
    //   175: invokespecial 303	com/tencent/acstat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   178: astore 5
    //   180: aload 5
    //   182: astore_1
    //   183: aload 5
    //   185: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   188: aload 5
    //   190: astore_1
    //   191: aload 5
    //   193: ldc_w 322
    //   196: aload 6
    //   198: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aconst_null
    //   202: invokevirtual 328	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   205: istore_3
    //   206: aload 5
    //   208: astore_1
    //   209: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   212: ifeq +98 -> 310
    //   215: aload 5
    //   217: astore_1
    //   218: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   221: astore 7
    //   223: aload 5
    //   225: astore_1
    //   226: new 117	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 425
    //   233: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: astore 8
    //   238: aload 5
    //   240: astore_1
    //   241: aload 8
    //   243: iload 4
    //   245: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 5
    //   251: astore_1
    //   252: aload 8
    //   254: ldc_w 427
    //   257: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 5
    //   263: astore_1
    //   264: aload 8
    //   266: aload 6
    //   268: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 5
    //   277: astore_1
    //   278: aload 8
    //   280: ldc_w 429
    //   283: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 5
    //   289: astore_1
    //   290: aload 8
    //   292: iload_3
    //   293: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 5
    //   299: astore_1
    //   300: aload 7
    //   302: aload 8
    //   304: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   310: aload 5
    //   312: astore_1
    //   313: aload_0
    //   314: aload_0
    //   315: getfield 70	com/tencent/acstat/af:a	I
    //   318: iload_3
    //   319: isub
    //   320: putfield 70	com/tencent/acstat/af:a	I
    //   323: aload 5
    //   325: astore_1
    //   326: aload 5
    //   328: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   331: aload 5
    //   333: astore_1
    //   334: aload_0
    //   335: invokespecial 140	com/tencent/acstat/af:g	()V
    //   338: aload 5
    //   340: ifnull +79 -> 419
    //   343: aload 5
    //   345: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   348: aload_0
    //   349: monitorexit
    //   350: return
    //   351: astore_1
    //   352: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   355: aload_1
    //   356: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   359: aload_0
    //   360: monitorexit
    //   361: return
    //   362: astore 5
    //   364: goto +58 -> 422
    //   367: astore 6
    //   369: goto +15 -> 384
    //   372: astore 5
    //   374: aconst_null
    //   375: astore_1
    //   376: goto +46 -> 422
    //   379: astore 6
    //   381: aconst_null
    //   382: astore 5
    //   384: aload 5
    //   386: astore_1
    //   387: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   390: aload 6
    //   392: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   395: aload 5
    //   397: ifnull +22 -> 419
    //   400: aload 5
    //   402: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   405: aload_0
    //   406: monitorexit
    //   407: return
    //   408: astore_1
    //   409: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   412: aload_1
    //   413: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   416: aload_0
    //   417: monitorexit
    //   418: return
    //   419: aload_0
    //   420: monitorexit
    //   421: return
    //   422: aload_1
    //   423: ifnull +18 -> 441
    //   426: aload_1
    //   427: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   430: goto +11 -> 441
    //   433: astore_1
    //   434: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   437: aload_1
    //   438: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   441: aload 5
    //   443: athrow
    //   444: astore_1
    //   445: aload_0
    //   446: monitorexit
    //   447: goto +5 -> 452
    //   450: aload_1
    //   451: athrow
    //   452: goto -2 -> 450
    //   455: iload_3
    //   456: iconst_1
    //   457: iadd
    //   458: istore_3
    //   459: goto -340 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	af
    //   0	462	1	paramList	List<ao>
    //   0	462	2	paramBoolean	boolean
    //   8	451	3	i1	int
    //   110	134	4	i2	int
    //   25	319	5	localObject1	Object
    //   362	1	5	localObject2	Object
    //   372	1	5	localObject3	Object
    //   382	60	5	localObject4	Object
    //   37	230	6	localStringBuilder1	StringBuilder
    //   367	1	6	localThrowable1	Throwable
    //   379	12	6	localThrowable2	Throwable
    //   221	80	7	localStatLogger	StatLogger
    //   236	67	8	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   343	348	351	java/lang/Throwable
    //   183	188	362	finally
    //   191	206	362	finally
    //   209	215	362	finally
    //   218	223	362	finally
    //   226	238	362	finally
    //   241	249	362	finally
    //   252	261	362	finally
    //   264	275	362	finally
    //   278	287	362	finally
    //   290	297	362	finally
    //   300	310	362	finally
    //   313	323	362	finally
    //   326	331	362	finally
    //   334	338	362	finally
    //   387	395	362	finally
    //   183	188	367	java/lang/Throwable
    //   191	206	367	java/lang/Throwable
    //   209	215	367	java/lang/Throwable
    //   218	223	367	java/lang/Throwable
    //   226	238	367	java/lang/Throwable
    //   241	249	367	java/lang/Throwable
    //   252	261	367	java/lang/Throwable
    //   264	275	367	java/lang/Throwable
    //   278	287	367	java/lang/Throwable
    //   290	297	367	java/lang/Throwable
    //   300	310	367	java/lang/Throwable
    //   313	323	367	java/lang/Throwable
    //   326	331	367	java/lang/Throwable
    //   334	338	367	java/lang/Throwable
    //   173	180	372	finally
    //   173	180	379	java/lang/Throwable
    //   400	405	408	java/lang/Throwable
    //   426	430	433	java/lang/Throwable
    //   2	9	444	finally
    //   16	77	444	finally
    //   77	102	444	finally
    //   104	119	444	finally
    //   119	146	444	finally
    //   154	162	444	finally
    //   165	173	444	finally
    //   343	348	444	finally
    //   352	359	444	finally
    //   400	405	444	finally
    //   409	416	444	finally
    //   426	430	444	finally
    //   434	441	444	finally
    //   441	444	444	finally
  }
  
  private boolean a(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = d(paramBoolean);
      ((SQLiteDatabase)localObject1).beginTransaction();
      Object localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("content", "test");
      ((ContentValues)localObject2).put("send_count", "100");
      ((ContentValues)localObject2).put("status", Integer.toString(1));
      ((ContentValues)localObject2).put("timestamp", Long.valueOf(System.currentTimeMillis()));
      ((SQLiteDatabase)localObject1).insert("events", null, (ContentValues)localObject2);
      ((SQLiteDatabase)localObject1).setTransactionSuccessful();
      ((SQLiteDatabase)localObject1).endTransaction();
      int i1 = ((SQLiteDatabase)localObject1).delete("events", "content = ?", new String[] { "test" });
      localObject2 = ((SQLiteDatabase)localObject1).query("events", null, "content=?", new String[] { "test" }, null, null, null, "1");
      int i2 = ((Cursor)localObject2).getCount();
      ((Cursor)localObject2).close();
      StringBuilder localStringBuilder;
      if (StatConfig.isDebugEnable())
      {
        localObject2 = h;
        localStringBuilder = new StringBuilder("delNum=");
        localStringBuilder.append(i1);
        localStringBuilder.append(",queryNum=");
        localStringBuilder.append(i2);
        ((StatLogger)localObject2).i(localStringBuilder.toString());
      }
      if ((i1 != 0) && (i2 <= 0))
      {
        if (StatConfig.isDebugEnable())
        {
          localObject1 = ((SQLiteDatabase)localObject1).getPath().split("/");
          localObject2 = h;
          localStringBuilder = new StringBuilder("test db passed, db name:");
          localStringBuilder.append(localObject1[(localObject1.length - 1)]);
          ((StatLogger)localObject2).i(localStringBuilder.toString());
          return true;
        }
      }
      else {
        throw new SQLException("test delete error.");
      }
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
      return false;
      h.warn("db is full, change to INSTANT");
      StatConfig.setReportEventsByOrder(false);
      StatConfig.setStatSendStrategy(StatReportStrategy.INSTANT);
      return true;
    }
    catch (SQLiteFullException localSQLiteFullException)
    {
      label307:
      break label307;
    }
    return true;
  }
  
  public static af b()
  {
    return k;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (paramInt == -1) {
      if (!paramBoolean) {
        i1 = h();
      } else {
        i1 = i();
      }
    }
    if (i1 > 0)
    {
      int i2 = StatConfig.getSendPeriodMinutes() * 60 * StatConfig.getNumEventsCommitPerSec();
      paramInt = i1;
      if (i1 > i2)
      {
        paramInt = i1;
        if (i2 > 0) {
          paramInt = i2;
        }
      }
      i1 = StatConfig.a();
      int i3 = paramInt / i1;
      int i4 = paramInt % i1;
      if (StatConfig.isDebugEnable())
      {
        StatLogger localStatLogger = h;
        StringBuilder localStringBuilder = new StringBuilder("sentStoreEventsByDb sendNumbers=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",important=");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(",maxSendNumPerFor1Period=");
        localStringBuilder.append(i2);
        localStringBuilder.append(",maxCount=");
        localStringBuilder.append(i3);
        localStringBuilder.append(",restNumbers=");
        localStringBuilder.append(i4);
        localStatLogger.i(localStringBuilder.toString());
      }
      paramInt = 0;
      while (paramInt < i3)
      {
        a(i1, paramBoolean);
        paramInt += 1;
      }
      if (i4 > 0) {
        a(i4, paramBoolean);
      }
    }
  }
  
  /* Error */
  private void b(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: aload 6
    //   10: astore 5
    //   12: aload_1
    //   13: invokevirtual 524	com/tencent/acstat/e:a	()Ljava/lang/String;
    //   16: astore 8
    //   18: aload 6
    //   20: astore 5
    //   22: aload 8
    //   24: invokestatic 527	com/tencent/acstat/common/StatCommonHelper:md5sum	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 10
    //   29: aload 6
    //   31: astore 5
    //   33: new 330	android/content/ContentValues
    //   36: dup
    //   37: invokespecial 331	android/content/ContentValues:<init>	()V
    //   40: astore 9
    //   42: aload 6
    //   44: astore 5
    //   46: aload 9
    //   48: ldc_w 349
    //   51: aload_1
    //   52: getfield 530	com/tencent/acstat/e:b	Lorg/json/JSONObject;
    //   55: invokevirtual 533	org/json/JSONObject:toString	()Ljava/lang/String;
    //   58: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload 6
    //   63: astore 5
    //   65: aload 9
    //   67: ldc_w 534
    //   70: aload 10
    //   72: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 6
    //   77: astore 5
    //   79: aload_1
    //   80: aload 10
    //   82: putfield 536	com/tencent/acstat/e:c	Ljava/lang/String;
    //   85: aload 6
    //   87: astore 5
    //   89: aload 9
    //   91: ldc_w 538
    //   94: aload_1
    //   95: getfield 540	com/tencent/acstat/e:d	I
    //   98: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   104: aload 6
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   112: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   115: ldc_w 548
    //   118: aconst_null
    //   119: aconst_null
    //   120: aconst_null
    //   121: aconst_null
    //   122: aconst_null
    //   123: aconst_null
    //   124: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore 6
    //   129: aload 6
    //   131: invokeinterface 554 1 0
    //   136: ifeq +390 -> 526
    //   139: aload 6
    //   141: iconst_0
    //   142: invokeinterface 558 2 0
    //   147: aload_1
    //   148: getfield 559	com/tencent/acstat/e:a	I
    //   151: if_icmpne -22 -> 129
    //   154: iconst_1
    //   155: istore_2
    //   156: goto +3 -> 159
    //   159: aload_0
    //   160: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   163: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   166: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   169: iconst_1
    //   170: iload_2
    //   171: if_icmpne +40 -> 211
    //   174: aload_0
    //   175: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   178: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   181: ldc_w 548
    //   184: aload 9
    //   186: ldc_w 561
    //   189: iconst_1
    //   190: anewarray 344	java/lang/String
    //   193: dup
    //   194: iconst_0
    //   195: aload_1
    //   196: getfield 559	com/tencent/acstat/e:a	I
    //   199: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   202: aastore
    //   203: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   206: i2l
    //   207: lstore_3
    //   208: goto +35 -> 243
    //   211: aload 9
    //   213: ldc_w 567
    //   216: aload_1
    //   217: getfield 559	com/tencent/acstat/e:a	I
    //   220: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   226: aload_0
    //   227: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   230: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   233: ldc_w 548
    //   236: aconst_null
    //   237: aload 9
    //   239: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   242: lstore_3
    //   243: lload_3
    //   244: ldc2_w 380
    //   247: lcmp
    //   248: ifne +39 -> 287
    //   251: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   254: astore_1
    //   255: new 117	java/lang/StringBuilder
    //   258: dup
    //   259: ldc_w 569
    //   262: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: astore 5
    //   267: aload 5
    //   269: aload 8
    //   271: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_1
    //   276: aload 5
    //   278: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 571	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   284: goto +36 -> 320
    //   287: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   290: astore_1
    //   291: new 117	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 573
    //   298: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: astore 5
    //   303: aload 5
    //   305: aload 8
    //   307: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_1
    //   312: aload 5
    //   314: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokevirtual 385	com/tencent/acstat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   320: aload_0
    //   321: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   324: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   327: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   330: aload 6
    //   332: ifnull +21 -> 353
    //   335: aload 6
    //   337: invokeinterface 460 1 0
    //   342: goto +11 -> 353
    //   345: astore_1
    //   346: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   349: aload_1
    //   350: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   353: aload_0
    //   354: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   357: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   360: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   363: aload_0
    //   364: monitorexit
    //   365: return
    //   366: astore_1
    //   367: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   370: aload_1
    //   371: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   374: aload_0
    //   375: monitorexit
    //   376: return
    //   377: astore_1
    //   378: goto +84 -> 462
    //   381: astore 5
    //   383: aload 6
    //   385: astore_1
    //   386: aload 5
    //   388: astore 6
    //   390: goto +16 -> 406
    //   393: astore_1
    //   394: aload 5
    //   396: astore 6
    //   398: goto +64 -> 462
    //   401: astore 6
    //   403: aload 7
    //   405: astore_1
    //   406: aload_1
    //   407: astore 5
    //   409: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   412: aload 6
    //   414: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   417: aload_1
    //   418: ifnull +20 -> 438
    //   421: aload_1
    //   422: invokeinterface 460 1 0
    //   427: goto +11 -> 438
    //   430: astore_1
    //   431: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   434: aload_1
    //   435: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   438: aload_0
    //   439: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   442: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   445: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   448: aload_0
    //   449: monitorexit
    //   450: return
    //   451: astore_1
    //   452: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   455: aload_1
    //   456: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   459: aload_0
    //   460: monitorexit
    //   461: return
    //   462: aload 6
    //   464: ifnull +23 -> 487
    //   467: aload 6
    //   469: invokeinterface 460 1 0
    //   474: goto +13 -> 487
    //   477: astore 5
    //   479: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   482: aload 5
    //   484: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   487: aload_0
    //   488: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   491: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   494: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   497: goto +17 -> 514
    //   500: astore_1
    //   501: goto +15 -> 516
    //   504: astore 5
    //   506: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   509: aload 5
    //   511: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   514: aload_1
    //   515: athrow
    //   516: aload_0
    //   517: monitorexit
    //   518: goto +5 -> 523
    //   521: aload_1
    //   522: athrow
    //   523: goto -2 -> 521
    //   526: iconst_0
    //   527: istore_2
    //   528: goto -369 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	af
    //   0	531	1	parame	e
    //   155	373	2	i1	int
    //   207	37	3	l1	long
    //   10	303	5	localObject1	Object
    //   381	14	5	localThrowable1	Throwable
    //   407	1	5	locale	e
    //   477	6	5	localThrowable2	Throwable
    //   504	6	5	localThrowable3	Throwable
    //   6	391	6	localObject2	Object
    //   401	67	6	localThrowable4	Throwable
    //   3	401	7	localObject3	Object
    //   16	290	8	str1	String
    //   40	198	9	localContentValues	ContentValues
    //   27	54	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   335	342	345	java/lang/Throwable
    //   353	363	366	java/lang/Throwable
    //   129	154	377	finally
    //   159	169	377	finally
    //   174	208	377	finally
    //   211	243	377	finally
    //   251	284	377	finally
    //   287	320	377	finally
    //   320	330	377	finally
    //   129	154	381	java/lang/Throwable
    //   159	169	381	java/lang/Throwable
    //   174	208	381	java/lang/Throwable
    //   211	243	381	java/lang/Throwable
    //   251	284	381	java/lang/Throwable
    //   287	320	381	java/lang/Throwable
    //   320	330	381	java/lang/Throwable
    //   12	18	393	finally
    //   22	29	393	finally
    //   33	42	393	finally
    //   46	61	393	finally
    //   65	75	393	finally
    //   79	85	393	finally
    //   89	104	393	finally
    //   108	129	393	finally
    //   409	417	393	finally
    //   12	18	401	java/lang/Throwable
    //   22	29	401	java/lang/Throwable
    //   33	42	401	java/lang/Throwable
    //   46	61	401	java/lang/Throwable
    //   65	75	401	java/lang/Throwable
    //   79	85	401	java/lang/Throwable
    //   89	104	401	java/lang/Throwable
    //   108	129	401	java/lang/Throwable
    //   421	427	430	java/lang/Throwable
    //   438	448	451	java/lang/Throwable
    //   467	474	477	java/lang/Throwable
    //   335	342	500	finally
    //   346	353	500	finally
    //   353	363	500	finally
    //   367	374	500	finally
    //   421	427	500	finally
    //   431	438	500	finally
    //   438	448	500	finally
    //   452	459	500	finally
    //   467	474	500	finally
    //   479	487	500	finally
    //   487	497	500	finally
    //   506	514	500	finally
    //   514	516	500	finally
    //   487	497	504	java/lang/Throwable
  }
  
  private void b(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (StatConfig.getMaxStoreEventCount() > 0) {
        if ((StatConfig.m > 0) && (!paramBoolean1) && (!paramBoolean2))
        {
          if (StatConfig.m > 0)
          {
            if (StatConfig.isDebugEnable())
            {
              StatLogger localStatLogger = h;
              StringBuilder localStringBuilder = new StringBuilder("cacheEventsInMemory.size():");
              localStringBuilder.append(this.m.size());
              localStringBuilder.append(",numEventsCachedInMemory:");
              localStringBuilder.append(StatConfig.m);
              localStringBuilder.append(",numStoredEvents:");
              localStringBuilder.append(this.a);
              localStatLogger.i(localStringBuilder.toString());
              localStatLogger = h;
              localStringBuilder = new StringBuilder("cache event:");
              localStringBuilder.append(paramd.g());
              localStatLogger.i(localStringBuilder.toString());
            }
            this.m.put(paramd, "");
            if (this.m.size() >= StatConfig.m) {
              j();
            }
            if (paramStatDispatchCallback != null)
            {
              if (this.m.size() > 0) {
                j();
              }
              paramStatDispatchCallback.onDispatchSuccess();
            }
          }
        }
        else
        {
          a(paramd, paramStatDispatchCallback, paramBoolean1);
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private void b(List<ao> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload 9
    //   8: astore 7
    //   10: aload 10
    //   12: astore 8
    //   14: aload_0
    //   15: iload_3
    //   16: invokespecial 589	com/tencent/acstat/af:e	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 11
    //   21: aload 9
    //   23: astore 7
    //   25: aload 10
    //   27: astore 8
    //   29: iconst_1
    //   30: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   33: astore 12
    //   35: aload 9
    //   37: astore 7
    //   39: aload 10
    //   41: astore 8
    //   43: iload_2
    //   44: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   47: astore 13
    //   49: aload 9
    //   51: astore 7
    //   53: aload 10
    //   55: astore 8
    //   57: aload 11
    //   59: ldc_w 322
    //   62: aconst_null
    //   63: ldc_w 591
    //   66: iconst_1
    //   67: anewarray 344	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload 12
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aload 13
    //   80: invokevirtual 452	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 9
    //   85: aload 9
    //   87: astore 7
    //   89: aload 9
    //   91: astore 8
    //   93: aload 9
    //   95: invokeinterface 554 1 0
    //   100: ifeq +304 -> 404
    //   103: aload 9
    //   105: astore 7
    //   107: aload 9
    //   109: astore 8
    //   111: aload 9
    //   113: iconst_0
    //   114: invokeinterface 595 2 0
    //   119: lstore 5
    //   121: aload 9
    //   123: astore 7
    //   125: aload 9
    //   127: astore 8
    //   129: aload 9
    //   131: iconst_1
    //   132: invokeinterface 598 2 0
    //   137: astore 11
    //   139: aload 11
    //   141: astore 10
    //   143: aload 9
    //   145: astore 7
    //   147: aload 9
    //   149: astore 8
    //   151: getstatic 600	com/tencent/acstat/StatConfig:g	Z
    //   154: ifne +18 -> 172
    //   157: aload 9
    //   159: astore 7
    //   161: aload 9
    //   163: astore 8
    //   165: aload 11
    //   167: invokestatic 603	com/tencent/acstat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 10
    //   172: aload 9
    //   174: astore 7
    //   176: aload 9
    //   178: astore 8
    //   180: aload 9
    //   182: iconst_2
    //   183: invokeinterface 558 2 0
    //   188: istore_2
    //   189: aload 9
    //   191: astore 7
    //   193: aload 9
    //   195: astore 8
    //   197: aload 9
    //   199: iconst_3
    //   200: invokeinterface 558 2 0
    //   205: istore 4
    //   207: aload 9
    //   209: astore 7
    //   211: aload 9
    //   213: astore 8
    //   215: new 186	com/tencent/acstat/ao
    //   218: dup
    //   219: lload 5
    //   221: aload 10
    //   223: iload_2
    //   224: iload 4
    //   226: invokespecial 606	com/tencent/acstat/ao:<init>	(JLjava/lang/String;II)V
    //   229: astore 10
    //   231: aload 9
    //   233: astore 7
    //   235: aload 9
    //   237: astore 8
    //   239: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   242: ifeq +142 -> 384
    //   245: aload 9
    //   247: astore 7
    //   249: aload 9
    //   251: astore 8
    //   253: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   256: astore 11
    //   258: aload 9
    //   260: astore 7
    //   262: aload 9
    //   264: astore 8
    //   266: new 117	java/lang/StringBuilder
    //   269: dup
    //   270: ldc_w 608
    //   273: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: astore 12
    //   278: aload 9
    //   280: astore 7
    //   282: aload 9
    //   284: astore 8
    //   286: aload 12
    //   288: lload 5
    //   290: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 9
    //   296: astore 7
    //   298: aload 9
    //   300: astore 8
    //   302: aload 12
    //   304: ldc_w 610
    //   307: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 9
    //   313: astore 7
    //   315: aload 9
    //   317: astore 8
    //   319: aload 12
    //   321: iload 4
    //   323: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 9
    //   329: astore 7
    //   331: aload 9
    //   333: astore 8
    //   335: aload 12
    //   337: ldc_w 612
    //   340: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 9
    //   346: astore 7
    //   348: aload 9
    //   350: astore 8
    //   352: aload 12
    //   354: aload 9
    //   356: iconst_4
    //   357: invokeinterface 595 2 0
    //   362: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 9
    //   368: astore 7
    //   370: aload 9
    //   372: astore 8
    //   374: aload 11
    //   376: aload 12
    //   378: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   384: aload 9
    //   386: astore 7
    //   388: aload 9
    //   390: astore 8
    //   392: aload_1
    //   393: aload 10
    //   395: invokeinterface 616 2 0
    //   400: pop
    //   401: goto -316 -> 85
    //   404: aload 9
    //   406: ifnull +48 -> 454
    //   409: aload 9
    //   411: invokeinterface 460 1 0
    //   416: return
    //   417: astore_1
    //   418: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   421: aload_1
    //   422: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   425: return
    //   426: astore_1
    //   427: goto +28 -> 455
    //   430: astore_1
    //   431: aload 8
    //   433: astore 7
    //   435: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   438: aload_1
    //   439: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   442: aload 8
    //   444: ifnull +10 -> 454
    //   447: aload 8
    //   449: invokeinterface 460 1 0
    //   454: return
    //   455: aload 7
    //   457: ifnull +23 -> 480
    //   460: aload 7
    //   462: invokeinterface 460 1 0
    //   467: goto +13 -> 480
    //   470: astore 7
    //   472: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   475: aload 7
    //   477: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   480: goto +5 -> 485
    //   483: aload_1
    //   484: athrow
    //   485: goto -2 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	af
    //   0	488	1	paramList	List<ao>
    //   0	488	2	paramInt	int
    //   0	488	3	paramBoolean	boolean
    //   205	117	4	i1	int
    //   119	170	5	l1	long
    //   8	453	7	localObject1	Object
    //   470	6	7	localThrowable	Throwable
    //   12	436	8	localObject2	Object
    //   4	406	9	localCursor	Cursor
    //   1	393	10	localObject3	Object
    //   19	356	11	localObject4	Object
    //   33	344	12	localObject5	Object
    //   47	32	13	str	String
    // Exception table:
    //   from	to	target	type
    //   409	416	417	java/lang/Throwable
    //   447	454	417	java/lang/Throwable
    //   14	21	426	finally
    //   29	35	426	finally
    //   43	49	426	finally
    //   57	85	426	finally
    //   93	103	426	finally
    //   111	121	426	finally
    //   129	139	426	finally
    //   151	157	426	finally
    //   165	172	426	finally
    //   180	189	426	finally
    //   197	207	426	finally
    //   215	231	426	finally
    //   239	245	426	finally
    //   253	258	426	finally
    //   266	278	426	finally
    //   286	294	426	finally
    //   302	311	426	finally
    //   319	327	426	finally
    //   335	344	426	finally
    //   352	366	426	finally
    //   374	384	426	finally
    //   392	401	426	finally
    //   435	442	426	finally
    //   14	21	430	java/lang/Throwable
    //   29	35	430	java/lang/Throwable
    //   43	49	430	java/lang/Throwable
    //   57	85	430	java/lang/Throwable
    //   93	103	430	java/lang/Throwable
    //   111	121	430	java/lang/Throwable
    //   129	139	430	java/lang/Throwable
    //   151	157	430	java/lang/Throwable
    //   165	172	430	java/lang/Throwable
    //   180	189	430	java/lang/Throwable
    //   197	207	430	java/lang/Throwable
    //   215	231	430	java/lang/Throwable
    //   239	245	430	java/lang/Throwable
    //   253	258	430	java/lang/Throwable
    //   266	278	430	java/lang/Throwable
    //   286	294	430	java/lang/Throwable
    //   302	311	430	java/lang/Throwable
    //   319	327	430	java/lang/Throwable
    //   335	344	430	java/lang/Throwable
    //   352	366	430	java/lang/Throwable
    //   374	384	430	java/lang/Throwable
    //   392	401	430	java/lang/Throwable
    //   460	467	470	java/lang/Throwable
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
    //   109: ifeq +85 -> 194
    //   112: aload 7
    //   114: astore 5
    //   116: aload 7
    //   118: astore 6
    //   120: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   123: astore 8
    //   125: aload 7
    //   127: astore 5
    //   129: aload 7
    //   131: astore 6
    //   133: new 117	java/lang/StringBuilder
    //   136: dup
    //   137: ldc_w 625
    //   140: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: astore 9
    //   145: aload 7
    //   147: astore 5
    //   149: aload 7
    //   151: astore 6
    //   153: aload 9
    //   155: iload_2
    //   156: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 7
    //   162: astore 5
    //   164: aload 7
    //   166: astore 6
    //   168: aload 9
    //   170: ldc 228
    //   172: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 7
    //   178: astore 5
    //   180: aload 7
    //   182: astore 6
    //   184: aload 8
    //   186: aload 9
    //   188: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   194: aload 7
    //   196: astore 5
    //   198: aload 7
    //   200: astore 6
    //   202: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   205: ldc2_w 626
    //   208: ldiv
    //   209: lstore_3
    //   210: aload 7
    //   212: astore 5
    //   214: aload 7
    //   216: astore 6
    //   218: new 117	java/lang/StringBuilder
    //   221: dup
    //   222: ldc_w 629
    //   225: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: astore 8
    //   230: aload 7
    //   232: astore 5
    //   234: aload 7
    //   236: astore 6
    //   238: aload 8
    //   240: lload_3
    //   241: ldc2_w 630
    //   244: lsub
    //   245: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 7
    //   251: astore 5
    //   253: aload 7
    //   255: astore 6
    //   257: aload 8
    //   259: ldc_w 633
    //   262: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 7
    //   268: astore 5
    //   270: aload 7
    //   272: astore 6
    //   274: aload 8
    //   276: getstatic 47	com/tencent/acstat/af:j	I
    //   279: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 7
    //   285: astore 5
    //   287: aload 7
    //   289: astore 6
    //   291: aload 7
    //   293: aload 8
    //   295: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 413	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   301: aload 7
    //   303: ifnull +30 -> 333
    //   306: aload 7
    //   308: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   311: goto +8 -> 319
    //   314: astore 5
    //   316: goto +9 -> 325
    //   319: aload 7
    //   321: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   324: return
    //   325: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   328: aload 5
    //   330: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   333: return
    //   334: astore 6
    //   336: goto +33 -> 369
    //   339: astore 7
    //   341: aload 6
    //   343: astore 5
    //   345: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   348: aload 7
    //   350: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   353: aload 6
    //   355: ifnull +13 -> 368
    //   358: aload 6
    //   360: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   363: aload 6
    //   365: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   368: return
    //   369: aload 5
    //   371: ifnull +32 -> 403
    //   374: aload 5
    //   376: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   379: goto +8 -> 387
    //   382: astore 5
    //   384: goto +11 -> 395
    //   387: aload 5
    //   389: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   392: goto +11 -> 403
    //   395: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   398: aload 5
    //   400: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   403: aload 6
    //   405: athrow
    //   406: astore 5
    //   408: goto -89 -> 319
    //   411: astore 5
    //   413: goto -50 -> 363
    //   416: astore 7
    //   418: goto -31 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	af
    //   0	421	1	paramBoolean	boolean
    //   97	59	2	i1	int
    //   209	32	3	l1	long
    //   4	282	5	localObject1	Object
    //   314	15	5	localThrowable1	Throwable
    //   343	32	5	localObject2	Object
    //   382	17	5	localThrowable2	Throwable
    //   406	1	5	localException1	java.lang.Exception
    //   411	1	5	localException2	java.lang.Exception
    //   1	289	6	localObject3	Object
    //   334	70	6	localObject4	Object
    //   11	309	7	localSQLiteDatabase	SQLiteDatabase
    //   339	10	7	localThrowable3	Throwable
    //   416	1	7	localException3	java.lang.Exception
    //   41	253	8	localObject5	Object
    //   143	44	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   306	311	314	java/lang/Throwable
    //   319	324	314	java/lang/Throwable
    //   358	363	314	java/lang/Throwable
    //   363	368	314	java/lang/Throwable
    //   6	13	334	finally
    //   21	26	334	finally
    //   34	43	334	finally
    //   51	63	334	finally
    //   71	98	334	finally
    //   106	112	334	finally
    //   120	125	334	finally
    //   133	145	334	finally
    //   153	160	334	finally
    //   168	176	334	finally
    //   184	194	334	finally
    //   202	210	334	finally
    //   218	230	334	finally
    //   238	249	334	finally
    //   257	266	334	finally
    //   274	283	334	finally
    //   291	301	334	finally
    //   345	353	334	finally
    //   6	13	339	java/lang/Throwable
    //   21	26	339	java/lang/Throwable
    //   34	43	339	java/lang/Throwable
    //   51	63	339	java/lang/Throwable
    //   71	98	339	java/lang/Throwable
    //   106	112	339	java/lang/Throwable
    //   120	125	339	java/lang/Throwable
    //   133	145	339	java/lang/Throwable
    //   153	160	339	java/lang/Throwable
    //   168	176	339	java/lang/Throwable
    //   184	194	339	java/lang/Throwable
    //   202	210	339	java/lang/Throwable
    //   218	230	339	java/lang/Throwable
    //   238	249	339	java/lang/Throwable
    //   257	266	339	java/lang/Throwable
    //   274	283	339	java/lang/Throwable
    //   291	301	339	java/lang/Throwable
    //   374	379	382	java/lang/Throwable
    //   387	392	382	java/lang/Throwable
    //   306	311	406	java/lang/Exception
    //   358	363	411	java/lang/Exception
    //   374	379	416	java/lang/Exception
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
    if (!paramBoolean) {}
    for (an localan = this.c;; localan = this.d) {
      return localan.getWritableDatabase();
    }
  }
  
  private SQLiteDatabase e(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (an localan = this.c;; localan = this.d) {
      return localan.getReadableDatabase();
    }
  }
  
  private void f()
  {
    try
    {
      boolean bool = a(false);
      StatLogger localStatLogger;
      StringBuilder localStringBuilder;
      if (!bool)
      {
        localStatLogger = h;
        localStringBuilder = new StringBuilder("delete ");
        localStringBuilder.append(an.a(this.c));
        localStringBuilder.append(", and create new one");
        localStatLogger.warn(localStringBuilder.toString());
        this.c.a();
        this.c = new an(i, this.f);
      }
      if (!a(true))
      {
        localStatLogger = h;
        localStringBuilder = new StringBuilder("delete ");
        localStringBuilder.append(an.a(this.d));
        localStringBuilder.append(", and create new one");
        localStatLogger.warn(localStringBuilder.toString());
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
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/tencent/acstat/af:n	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: astore 4
    //   14: aload 4
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   21: invokevirtual 578	java/util/concurrent/ConcurrentHashMap:size	()I
    //   24: ifne +7 -> 31
    //   27: aload 4
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 78	com/tencent/acstat/af:n	Z
    //   36: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   39: ifeq +71 -> 110
    //   42: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   45: astore_1
    //   46: new 117	java/lang/StringBuilder
    //   49: dup
    //   50: ldc_w 660
    //   53: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: astore_2
    //   57: aload_2
    //   58: aload_0
    //   59: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: invokevirtual 578	java/util/concurrent/ConcurrentHashMap:size	()I
    //   65: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: ldc_w 662
    //   73: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_2
    //   78: getstatic 575	com/tencent/acstat/StatConfig:m	I
    //   81: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: ldc_w 582
    //   89: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: aload_0
    //   95: getfield 70	com/tencent/acstat/af:a	I
    //   98: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   110: aconst_null
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_0
    //   115: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   118: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   121: astore_2
    //   122: aload_2
    //   123: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   126: aload_0
    //   127: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   130: invokevirtual 666	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   133: invokeinterface 669 1 0
    //   138: astore_1
    //   139: aload_1
    //   140: invokeinterface 180 1 0
    //   145: ifeq +168 -> 313
    //   148: aload_1
    //   149: invokeinterface 184 1 0
    //   154: checkcast 671	java/util/Map$Entry
    //   157: invokeinterface 674 1 0
    //   162: checkcast 333	com/tencent/acstat/event/d
    //   165: astore_3
    //   166: new 330	android/content/ContentValues
    //   169: dup
    //   170: invokespecial 331	android/content/ContentValues:<init>	()V
    //   173: astore 5
    //   175: aload_3
    //   176: invokevirtual 335	com/tencent/acstat/event/d:g	()Ljava/lang/String;
    //   179: astore 6
    //   181: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   184: ifeq +38 -> 222
    //   187: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   190: astore 7
    //   192: new 117	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 676
    //   199: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: astore 8
    //   204: aload 8
    //   206: aload 6
    //   208: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 7
    //   214: aload 8
    //   216: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   222: aload 6
    //   224: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 6
    //   229: aload 6
    //   231: ifnull +73 -> 304
    //   234: aload 6
    //   236: invokevirtual 347	java/lang/String:length	()I
    //   239: getstatic 47	com/tencent/acstat/af:j	I
    //   242: if_icmpge +62 -> 304
    //   245: aload 5
    //   247: ldc_w 349
    //   250: aload 6
    //   252: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 5
    //   257: ldc_w 354
    //   260: ldc_w 356
    //   263: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 5
    //   268: ldc_w 358
    //   271: iconst_1
    //   272: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   275: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload 5
    //   280: ldc_w 363
    //   283: aload_3
    //   284: invokevirtual 366	com/tencent/acstat/event/d:c	()J
    //   287: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   290: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   293: aload_2
    //   294: ldc_w 322
    //   297: aconst_null
    //   298: aload 5
    //   300: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   303: pop2
    //   304: aload_1
    //   305: invokeinterface 679 1 0
    //   310: goto -171 -> 139
    //   313: aload_2
    //   314: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   317: aload_2
    //   318: ifnull +80 -> 398
    //   321: aload_2
    //   322: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   325: aload_0
    //   326: invokespecial 140	com/tencent/acstat/af:g	()V
    //   329: goto +69 -> 398
    //   332: astore_1
    //   333: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   336: astore_2
    //   337: aload_2
    //   338: aload_1
    //   339: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   342: goto +56 -> 398
    //   345: astore_1
    //   346: goto +135 -> 481
    //   349: astore_3
    //   350: goto +16 -> 366
    //   353: astore_3
    //   354: aload_1
    //   355: astore_2
    //   356: aload_3
    //   357: astore_1
    //   358: goto +123 -> 481
    //   361: astore_1
    //   362: aload_3
    //   363: astore_2
    //   364: aload_1
    //   365: astore_3
    //   366: aload_2
    //   367: astore_1
    //   368: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   371: aload_3
    //   372: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   375: aload_2
    //   376: ifnull +22 -> 398
    //   379: aload_2
    //   380: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   383: aload_0
    //   384: invokespecial 140	com/tencent/acstat/af:g	()V
    //   387: goto +11 -> 398
    //   390: astore_1
    //   391: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   394: astore_2
    //   395: goto -58 -> 337
    //   398: aload_0
    //   399: iconst_0
    //   400: putfield 78	com/tencent/acstat/af:n	Z
    //   403: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   406: ifeq +71 -> 477
    //   409: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   412: astore_1
    //   413: new 117	java/lang/StringBuilder
    //   416: dup
    //   417: ldc_w 681
    //   420: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: astore_2
    //   424: aload_2
    //   425: aload_0
    //   426: getfield 76	com/tencent/acstat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   429: invokevirtual 578	java/util/concurrent/ConcurrentHashMap:size	()I
    //   432: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_2
    //   437: ldc_w 580
    //   440: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_2
    //   445: getstatic 575	com/tencent/acstat/StatConfig:m	I
    //   448: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_2
    //   453: ldc_w 582
    //   456: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload_2
    //   461: aload_0
    //   462: getfield 70	com/tencent/acstat/af:a	I
    //   465: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_1
    //   470: aload_2
    //   471: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   477: aload 4
    //   479: monitorexit
    //   480: return
    //   481: aload_2
    //   482: ifnull +22 -> 504
    //   485: aload_2
    //   486: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   489: aload_0
    //   490: invokespecial 140	com/tencent/acstat/af:g	()V
    //   493: goto +11 -> 504
    //   496: astore_2
    //   497: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   500: aload_2
    //   501: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   504: aload_1
    //   505: athrow
    //   506: astore_1
    //   507: aload 4
    //   509: monitorexit
    //   510: goto +5 -> 515
    //   513: aload_1
    //   514: athrow
    //   515: goto -2 -> 513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	af
    //   45	260	1	localObject1	Object
    //   332	7	1	localThrowable1	Throwable
    //   345	10	1	localObject2	Object
    //   357	1	1	localObject3	Object
    //   361	4	1	localThrowable2	Throwable
    //   367	1	1	localObject4	Object
    //   390	1	1	localThrowable3	Throwable
    //   412	93	1	localStatLogger1	StatLogger
    //   506	8	1	localObject5	Object
    //   56	430	2	localObject6	Object
    //   496	5	2	localThrowable4	Throwable
    //   111	173	3	locald	d
    //   349	1	3	localThrowable5	Throwable
    //   353	10	3	localObject7	Object
    //   365	7	3	localThrowable6	Throwable
    //   12	496	4	localConcurrentHashMap	ConcurrentHashMap
    //   173	126	5	localContentValues	ContentValues
    //   179	72	6	str	String
    //   190	23	7	localStatLogger2	StatLogger
    //   202	13	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   321	329	332	java/lang/Throwable
    //   122	139	345	finally
    //   139	222	345	finally
    //   222	229	345	finally
    //   234	304	345	finally
    //   304	310	345	finally
    //   313	317	345	finally
    //   122	139	349	java/lang/Throwable
    //   139	222	349	java/lang/Throwable
    //   222	229	349	java/lang/Throwable
    //   234	304	349	java/lang/Throwable
    //   304	310	349	java/lang/Throwable
    //   313	317	349	java/lang/Throwable
    //   114	122	353	finally
    //   368	375	353	finally
    //   114	122	361	java/lang/Throwable
    //   379	387	390	java/lang/Throwable
    //   485	493	496	java/lang/Throwable
    //   17	30	506	finally
    //   31	110	506	finally
    //   321	329	506	finally
    //   333	337	506	finally
    //   337	342	506	finally
    //   379	387	506	finally
    //   391	395	506	finally
    //   398	477	506	finally
    //   477	480	506	finally
    //   485	493	506	finally
    //   497	504	506	finally
    //   504	506	506	finally
    //   507	510	506	finally
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   8: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: ldc_w 683
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_1
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: invokeinterface 554 1 0
    //   34: ifeq +32 -> 66
    //   37: aload_3
    //   38: astore_1
    //   39: aload_3
    //   40: astore_2
    //   41: aload_0
    //   42: getfield 83	com/tencent/acstat/af:o	Ljava/util/HashMap;
    //   45: aload_3
    //   46: iconst_0
    //   47: invokeinterface 598 2 0
    //   52: aload_3
    //   53: iconst_1
    //   54: invokeinterface 598 2 0
    //   59: invokevirtual 684	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: goto -39 -> 24
    //   66: aload_3
    //   67: ifnull +43 -> 110
    //   70: aload_3
    //   71: invokeinterface 460 1 0
    //   76: return
    //   77: astore_1
    //   78: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   81: aload_1
    //   82: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   85: return
    //   86: astore_2
    //   87: goto +24 -> 111
    //   90: astore_3
    //   91: aload_2
    //   92: astore_1
    //   93: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   96: aload_3
    //   97: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   100: aload_2
    //   101: ifnull +9 -> 110
    //   104: aload_2
    //   105: invokeinterface 460 1 0
    //   110: return
    //   111: aload_1
    //   112: ifnull +20 -> 132
    //   115: aload_1
    //   116: invokeinterface 460 1 0
    //   121: goto +11 -> 132
    //   124: astore_1
    //   125: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   128: aload_1
    //   129: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   132: goto +5 -> 137
    //   135: aload_2
    //   136: athrow
    //   137: goto -2 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	af
    //   3	36	1	localObject1	Object
    //   77	5	1	localThrowable1	Throwable
    //   92	24	1	localObject2	Object
    //   124	5	1	localThrowable2	Throwable
    //   1	40	2	localObject3	Object
    //   86	50	2	localObject4	Object
    //   23	48	3	localCursor	Cursor
    //   90	7	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   70	76	77	java/lang/Throwable
    //   104	110	77	java/lang/Throwable
    //   4	24	86	finally
    //   28	37	86	finally
    //   41	63	86	finally
    //   93	100	86	finally
    //   4	24	90	java/lang/Throwable
    //   28	37	90	java/lang/Throwable
    //   41	63	90	java/lang/Throwable
    //   115	121	124	java/lang/Throwable
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
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.post(new aj(this, paramd, paramStatDispatchCallback, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<ao> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.post(new ag(this, paramList, paramInt, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<ao> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.post(new ah(this, paramList, paramBoolean1, paramBoolean2));
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
    //   23: istore 7
    //   25: iconst_0
    //   26: istore 4
    //   28: iconst_1
    //   29: istore 5
    //   31: iload 7
    //   33: ifeq +486 -> 519
    //   36: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   39: ifeq +12 -> 51
    //   42: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   45: ldc_w 719
    //   48: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   51: aload_1
    //   52: aload_0
    //   53: ldc 247
    //   55: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   58: ldc 64
    //   60: invokestatic 722	com/tencent/acstat/common/StatPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   63: astore 17
    //   65: aload 17
    //   67: invokestatic 603	com/tencent/acstat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 13
    //   72: aload_1
    //   73: aload_0
    //   74: ldc_w 257
    //   77: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   80: iconst_1
    //   81: invokestatic 725	com/tencent/acstat/common/StatPreferences:getInt	(Landroid/content/Context;Ljava/lang/String;I)I
    //   84: istore 5
    //   86: aload_1
    //   87: aload_0
    //   88: ldc_w 265
    //   91: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   94: ldc 64
    //   96: invokestatic 722	com/tencent/acstat/common/StatPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 12
    //   101: aload_1
    //   102: aload_0
    //   103: ldc_w 270
    //   106: invokespecial 249	com/tencent/acstat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   109: lconst_0
    //   110: invokestatic 728	com/tencent/acstat/common/StatPreferences:getLong	(Landroid/content/Context;Ljava/lang/String;J)J
    //   113: lstore 8
    //   115: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   118: ldc2_w 626
    //   121: ldiv
    //   122: lstore 10
    //   124: iload 5
    //   126: iconst_1
    //   127: if_icmpeq +1332 -> 1459
    //   130: lload 8
    //   132: ldc2_w 626
    //   135: lmul
    //   136: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   139: ldc2_w 626
    //   142: lload 10
    //   144: lmul
    //   145: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   148: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifne +1308 -> 1459
    //   154: iconst_1
    //   155: istore_2
    //   156: goto +3 -> 159
    //   159: iload_2
    //   160: istore_3
    //   161: aload 12
    //   163: aload_1
    //   164: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   167: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifne +7 -> 177
    //   173: iload_2
    //   174: iconst_2
    //   175: ior
    //   176: istore_3
    //   177: aload 13
    //   179: ldc 194
    //   181: invokevirtual 473	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   184: astore 18
    //   186: aload 18
    //   188: ifnull +99 -> 287
    //   191: aload 18
    //   193: arraylength
    //   194: ifle +93 -> 287
    //   197: aload 18
    //   199: iconst_0
    //   200: aaload
    //   201: astore 15
    //   203: aload 15
    //   205: ifnull +24 -> 229
    //   208: aload 13
    //   210: astore 12
    //   212: aload 15
    //   214: astore 14
    //   216: iload 4
    //   218: istore_2
    //   219: aload 15
    //   221: invokevirtual 347	java/lang/String:length	()I
    //   224: bipush 11
    //   226: if_icmpge +74 -> 300
    //   229: aload_1
    //   230: invokestatic 737	com/tencent/acstat/common/Util:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   233: astore 16
    //   235: aload 13
    //   237: astore 12
    //   239: aload 15
    //   241: astore 14
    //   243: iload 4
    //   245: istore_2
    //   246: aload 16
    //   248: ifnull +52 -> 300
    //   251: aload 13
    //   253: astore 12
    //   255: aload 15
    //   257: astore 14
    //   259: iload 4
    //   261: istore_2
    //   262: aload 16
    //   264: invokevirtual 347	java/lang/String:length	()I
    //   267: bipush 10
    //   269: if_icmple +31 -> 300
    //   272: aload 16
    //   274: astore 14
    //   276: aload 13
    //   278: astore 12
    //   280: aload 14
    //   282: astore 13
    //   284: goto +1181 -> 1465
    //   287: aload_1
    //   288: invokestatic 740	com/tencent/acstat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   291: astore 12
    //   293: aload 12
    //   295: astore 13
    //   297: goto +1168 -> 1465
    //   300: aload 18
    //   302: ifnull +62 -> 364
    //   305: aload 18
    //   307: arraylength
    //   308: iconst_2
    //   309: if_icmplt +55 -> 364
    //   312: aload 18
    //   314: iconst_1
    //   315: aaload
    //   316: astore 15
    //   318: new 117	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 741	java/lang/StringBuilder:<init>	()V
    //   325: astore 12
    //   327: aload 12
    //   329: aload 14
    //   331: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 12
    //   337: ldc 194
    //   339: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 12
    //   345: aload 15
    //   347: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 12
    //   353: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: astore 13
    //   358: iload_2
    //   359: istore 4
    //   361: goto +91 -> 452
    //   364: aload_1
    //   365: invokestatic 744	com/tencent/acstat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   368: astore 16
    //   370: aload 16
    //   372: astore 15
    //   374: aload 12
    //   376: astore 13
    //   378: iload_2
    //   379: istore 4
    //   381: aload 16
    //   383: ifnull +69 -> 452
    //   386: aload 16
    //   388: astore 15
    //   390: aload 12
    //   392: astore 13
    //   394: iload_2
    //   395: istore 4
    //   397: aload 16
    //   399: invokevirtual 347	java/lang/String:length	()I
    //   402: ifle +50 -> 452
    //   405: new 117	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 741	java/lang/StringBuilder:<init>	()V
    //   412: astore 12
    //   414: aload 12
    //   416: aload 14
    //   418: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 12
    //   424: ldc 194
    //   426: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 12
    //   432: aload 16
    //   434: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 12
    //   440: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: astore 13
    //   445: iconst_1
    //   446: istore 4
    //   448: aload 16
    //   450: astore 15
    //   452: aload_0
    //   453: new 746	com/tencent/acstat/common/DeviceInfo
    //   456: dup
    //   457: aload 14
    //   459: aload 15
    //   461: iload_3
    //   462: invokespecial 749	com/tencent/acstat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   465: putfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   468: aload 13
    //   470: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   473: astore 12
    //   475: iload 4
    //   477: ifeq +23 -> 500
    //   480: aload 12
    //   482: aload 17
    //   484: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   487: ifeq +13 -> 500
    //   490: aload_0
    //   491: aload_1
    //   492: aload 12
    //   494: iload_3
    //   495: lload 10
    //   497: invokespecial 751	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   500: iload_3
    //   501: iload 5
    //   503: if_icmpeq +899 -> 1402
    //   506: aload_0
    //   507: aload_1
    //   508: aload 12
    //   510: iload_3
    //   511: lload 10
    //   513: invokespecial 751	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   516: goto +886 -> 1402
    //   519: aconst_null
    //   520: astore 13
    //   522: aconst_null
    //   523: astore 14
    //   525: aload 14
    //   527: astore 12
    //   529: aload_0
    //   530: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   533: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   536: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   539: aload 14
    //   541: astore 12
    //   543: invokestatic 208	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   546: ifeq +16 -> 562
    //   549: aload 14
    //   551: astore 12
    //   553: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   556: ldc_w 753
    //   559: invokevirtual 218	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   562: aload 14
    //   564: astore 12
    //   566: aload_0
    //   567: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   570: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   573: ldc_w 755
    //   576: aconst_null
    //   577: aconst_null
    //   578: aconst_null
    //   579: aconst_null
    //   580: aconst_null
    //   581: aconst_null
    //   582: aconst_null
    //   583: invokevirtual 452	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   586: astore 14
    //   588: aload 14
    //   590: invokeinterface 554 1 0
    //   595: ifeq +899 -> 1494
    //   598: aload 14
    //   600: iconst_0
    //   601: invokeinterface 598 2 0
    //   606: astore 18
    //   608: aload 18
    //   610: invokestatic 603	com/tencent/acstat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   613: astore 12
    //   615: aload 14
    //   617: iconst_1
    //   618: invokeinterface 558 2 0
    //   623: istore 6
    //   625: aload 14
    //   627: iconst_2
    //   628: invokeinterface 598 2 0
    //   633: astore 13
    //   635: aload 14
    //   637: iconst_3
    //   638: invokeinterface 595 2 0
    //   643: lstore 8
    //   645: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   648: ldc2_w 626
    //   651: ldiv
    //   652: lstore 10
    //   654: iload 6
    //   656: iconst_1
    //   657: if_icmpeq +817 -> 1474
    //   660: lload 8
    //   662: ldc2_w 626
    //   665: lmul
    //   666: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   669: lload 10
    //   671: ldc2_w 626
    //   674: lmul
    //   675: invokestatic 731	com/tencent/acstat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   678: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   681: ifne +793 -> 1474
    //   684: iconst_1
    //   685: istore_2
    //   686: goto +3 -> 689
    //   689: iload_2
    //   690: istore_3
    //   691: aload 13
    //   693: aload_1
    //   694: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   697: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   700: ifne +7 -> 707
    //   703: iload_2
    //   704: iconst_2
    //   705: ior
    //   706: istore_3
    //   707: aload 12
    //   709: ldc 194
    //   711: invokevirtual 473	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   714: astore 16
    //   716: aload 16
    //   718: ifnull +57 -> 775
    //   721: aload 16
    //   723: arraylength
    //   724: ifle +51 -> 775
    //   727: aload 16
    //   729: iconst_0
    //   730: aaload
    //   731: astore 15
    //   733: aload 15
    //   735: ifnull +16 -> 751
    //   738: aload 15
    //   740: invokevirtual 347	java/lang/String:length	()I
    //   743: bipush 11
    //   745: if_icmpge +735 -> 1480
    //   748: goto +3 -> 751
    //   751: aload_1
    //   752: invokestatic 737	com/tencent/acstat/common/Util:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   755: astore 13
    //   757: aload 13
    //   759: ifnull +721 -> 1480
    //   762: aload 13
    //   764: invokevirtual 347	java/lang/String:length	()I
    //   767: bipush 10
    //   769: if_icmple +711 -> 1480
    //   772: goto +713 -> 1485
    //   775: aload_1
    //   776: invokestatic 740	com/tencent/acstat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   779: astore 12
    //   781: aload 12
    //   783: astore 13
    //   785: goto +700 -> 1485
    //   788: aload 16
    //   790: ifnull +62 -> 852
    //   793: aload 16
    //   795: arraylength
    //   796: iconst_2
    //   797: if_icmplt +55 -> 852
    //   800: aload 16
    //   802: iconst_1
    //   803: aaload
    //   804: astore 16
    //   806: new 117	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 741	java/lang/StringBuilder:<init>	()V
    //   813: astore 12
    //   815: aload 12
    //   817: aload 15
    //   819: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload 12
    //   825: ldc 194
    //   827: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload 12
    //   833: aload 16
    //   835: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 12
    //   841: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: astore 13
    //   846: iload_2
    //   847: istore 4
    //   849: goto +91 -> 940
    //   852: aload_1
    //   853: invokestatic 744	com/tencent/acstat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   856: astore 17
    //   858: iload_2
    //   859: istore 4
    //   861: aload 17
    //   863: astore 16
    //   865: aload 12
    //   867: astore 13
    //   869: aload 17
    //   871: ifnull +69 -> 940
    //   874: iload_2
    //   875: istore 4
    //   877: aload 17
    //   879: astore 16
    //   881: aload 12
    //   883: astore 13
    //   885: aload 17
    //   887: invokevirtual 347	java/lang/String:length	()I
    //   890: ifle +50 -> 940
    //   893: new 117	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 741	java/lang/StringBuilder:<init>	()V
    //   900: astore 12
    //   902: aload 12
    //   904: aload 15
    //   906: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload 12
    //   912: ldc 194
    //   914: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload 12
    //   920: aload 17
    //   922: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 12
    //   928: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: astore 13
    //   933: iconst_1
    //   934: istore 4
    //   936: aload 17
    //   938: astore 16
    //   940: aload_0
    //   941: new 746	com/tencent/acstat/common/DeviceInfo
    //   944: dup
    //   945: aload 15
    //   947: aload 16
    //   949: iload_3
    //   950: invokespecial 749	com/tencent/acstat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   953: putfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   956: new 330	android/content/ContentValues
    //   959: dup
    //   960: invokespecial 331	android/content/ContentValues:<init>	()V
    //   963: astore 12
    //   965: aload 13
    //   967: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   970: astore 13
    //   972: aload 12
    //   974: ldc 247
    //   976: aload 13
    //   978: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   981: aload 12
    //   983: ldc_w 257
    //   986: iload_3
    //   987: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   990: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   993: aload 12
    //   995: ldc_w 265
    //   998: aload_1
    //   999: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   1002: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1005: aload 12
    //   1007: ldc_w 270
    //   1010: lload 10
    //   1012: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1015: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1018: iload 4
    //   1020: ifeq +31 -> 1051
    //   1023: aload_0
    //   1024: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1027: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1030: ldc_w 755
    //   1033: aload 12
    //   1035: ldc_w 757
    //   1038: iconst_1
    //   1039: anewarray 344	java/lang/String
    //   1042: dup
    //   1043: iconst_0
    //   1044: aload 18
    //   1046: aastore
    //   1047: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1050: pop
    //   1051: iload_3
    //   1052: iload 6
    //   1054: if_icmpeq +20 -> 1074
    //   1057: aload_0
    //   1058: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1061: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1064: ldc_w 755
    //   1067: aconst_null
    //   1068: aload 12
    //   1070: invokevirtual 760	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1073: pop2
    //   1074: aload_0
    //   1075: aload_1
    //   1076: aload 13
    //   1078: iload_3
    //   1079: lload 10
    //   1081: invokespecial 751	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   1084: iload 5
    //   1086: istore_2
    //   1087: goto +3 -> 1090
    //   1090: iload_2
    //   1091: ifne +189 -> 1280
    //   1094: aload_1
    //   1095: invokestatic 740	com/tencent/acstat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   1098: astore 13
    //   1100: aload_1
    //   1101: invokestatic 744	com/tencent/acstat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   1104: astore 15
    //   1106: aload 15
    //   1108: ifnull +391 -> 1499
    //   1111: aload 15
    //   1113: invokevirtual 347	java/lang/String:length	()I
    //   1116: ifle +383 -> 1499
    //   1119: new 117	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 741	java/lang/StringBuilder:<init>	()V
    //   1126: astore 12
    //   1128: aload 12
    //   1130: aload 13
    //   1132: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload 12
    //   1138: ldc 194
    //   1140: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: aload 12
    //   1146: aload 15
    //   1148: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload 12
    //   1154: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: astore 12
    //   1159: goto +3 -> 1162
    //   1162: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   1165: ldc2_w 626
    //   1168: ldiv
    //   1169: lstore 8
    //   1171: aload_1
    //   1172: invokestatic 268	com/tencent/acstat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   1175: astore 16
    //   1177: new 330	android/content/ContentValues
    //   1180: dup
    //   1181: invokespecial 331	android/content/ContentValues:<init>	()V
    //   1184: astore 17
    //   1186: aload 12
    //   1188: invokestatic 342	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   1191: astore 12
    //   1193: aload 17
    //   1195: ldc 247
    //   1197: aload 12
    //   1199: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1202: aload 17
    //   1204: ldc_w 257
    //   1207: iconst_0
    //   1208: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1211: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1214: aload 17
    //   1216: ldc_w 265
    //   1219: aload 16
    //   1221: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1224: aload 17
    //   1226: ldc_w 270
    //   1229: lload 8
    //   1231: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1234: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1237: aload_0
    //   1238: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1241: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1244: ldc_w 755
    //   1247: aconst_null
    //   1248: aload 17
    //   1250: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1253: pop2
    //   1254: aload_0
    //   1255: aload_1
    //   1256: aload 12
    //   1258: iconst_0
    //   1259: lload 8
    //   1261: invokespecial 751	com/tencent/acstat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   1264: aload_0
    //   1265: new 746	com/tencent/acstat/common/DeviceInfo
    //   1268: dup
    //   1269: aload 13
    //   1271: aload 15
    //   1273: iconst_0
    //   1274: invokespecial 749	com/tencent/acstat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1277: putfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   1280: aload_0
    //   1281: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1284: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1287: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   1290: aload 14
    //   1292: ifnull +10 -> 1302
    //   1295: aload 14
    //   1297: invokeinterface 460 1 0
    //   1302: aload_0
    //   1303: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1306: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1309: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1312: goto +90 -> 1402
    //   1315: astore_1
    //   1316: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1319: astore 12
    //   1321: aload 12
    //   1323: aload_1
    //   1324: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1327: goto +75 -> 1402
    //   1330: astore_1
    //   1331: aload 14
    //   1333: astore 12
    //   1335: goto +76 -> 1411
    //   1338: astore 13
    //   1340: aload 14
    //   1342: astore_1
    //   1343: goto +16 -> 1359
    //   1346: astore_1
    //   1347: goto +64 -> 1411
    //   1350: astore 12
    //   1352: aload 13
    //   1354: astore_1
    //   1355: aload 12
    //   1357: astore 13
    //   1359: aload_1
    //   1360: astore 12
    //   1362: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1365: aload 13
    //   1367: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1370: aload_1
    //   1371: ifnull +9 -> 1380
    //   1374: aload_1
    //   1375: invokeinterface 460 1 0
    //   1380: aload_0
    //   1381: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1384: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1387: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1390: goto +12 -> 1402
    //   1393: astore_1
    //   1394: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1397: astore 12
    //   1399: goto -78 -> 1321
    //   1402: aload_0
    //   1403: getfield 72	com/tencent/acstat/af:b	Lcom/tencent/acstat/common/DeviceInfo;
    //   1406: astore_1
    //   1407: aload_0
    //   1408: monitorexit
    //   1409: aload_1
    //   1410: areturn
    //   1411: aload 12
    //   1413: ifnull +10 -> 1423
    //   1416: aload 12
    //   1418: invokeinterface 460 1 0
    //   1423: aload_0
    //   1424: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   1427: invokevirtual 320	com/tencent/acstat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1430: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1433: goto +13 -> 1446
    //   1436: astore 12
    //   1438: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   1441: aload 12
    //   1443: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1446: aload_1
    //   1447: athrow
    //   1448: astore_1
    //   1449: aload_0
    //   1450: monitorexit
    //   1451: goto +5 -> 1456
    //   1454: aload_1
    //   1455: athrow
    //   1456: goto -2 -> 1454
    //   1459: iload 5
    //   1461: istore_2
    //   1462: goto -1303 -> 159
    //   1465: iconst_1
    //   1466: istore_2
    //   1467: aload 13
    //   1469: astore 14
    //   1471: goto -1171 -> 300
    //   1474: iload 6
    //   1476: istore_2
    //   1477: goto -788 -> 689
    //   1480: iconst_0
    //   1481: istore_2
    //   1482: goto -694 -> 788
    //   1485: iconst_1
    //   1486: istore_2
    //   1487: aload 13
    //   1489: astore 15
    //   1491: goto -703 -> 788
    //   1494: iconst_0
    //   1495: istore_2
    //   1496: goto -406 -> 1090
    //   1499: aload 13
    //   1501: astore 12
    //   1503: goto -341 -> 1162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1506	0	this	af
    //   0	1506	1	paramContext	Context
    //   155	1341	2	i1	int
    //   160	919	3	i2	int
    //   26	993	4	i3	int
    //   29	1431	5	i4	int
    //   623	852	6	i5	int
    //   23	9	7	bool	boolean
    //   113	1147	8	l1	long
    //   122	958	10	l2	long
    //   99	1235	12	localObject1	Object
    //   1350	6	12	localThrowable1	Throwable
    //   1360	57	12	localObject2	Object
    //   1436	6	12	localThrowable2	Throwable
    //   1501	1	12	localObject3	Object
    //   70	1200	13	localObject4	Object
    //   1338	15	13	localThrowable3	Throwable
    //   1357	143	13	localObject5	Object
    //   214	1256	14	localObject6	Object
    //   201	1289	15	localObject7	Object
    //   233	987	16	localObject8	Object
    //   63	1186	17	localObject9	Object
    //   184	861	18	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   1295	1302	1315	java/lang/Throwable
    //   1302	1312	1315	java/lang/Throwable
    //   588	654	1330	finally
    //   660	684	1330	finally
    //   691	703	1330	finally
    //   707	716	1330	finally
    //   721	727	1330	finally
    //   738	748	1330	finally
    //   751	757	1330	finally
    //   762	772	1330	finally
    //   775	781	1330	finally
    //   793	800	1330	finally
    //   806	846	1330	finally
    //   852	858	1330	finally
    //   885	933	1330	finally
    //   940	1018	1330	finally
    //   1023	1051	1330	finally
    //   1057	1074	1330	finally
    //   1074	1084	1330	finally
    //   1094	1106	1330	finally
    //   1111	1159	1330	finally
    //   1162	1280	1330	finally
    //   1280	1290	1330	finally
    //   588	654	1338	java/lang/Throwable
    //   660	684	1338	java/lang/Throwable
    //   691	703	1338	java/lang/Throwable
    //   707	716	1338	java/lang/Throwable
    //   721	727	1338	java/lang/Throwable
    //   738	748	1338	java/lang/Throwable
    //   751	757	1338	java/lang/Throwable
    //   762	772	1338	java/lang/Throwable
    //   775	781	1338	java/lang/Throwable
    //   793	800	1338	java/lang/Throwable
    //   806	846	1338	java/lang/Throwable
    //   852	858	1338	java/lang/Throwable
    //   885	933	1338	java/lang/Throwable
    //   940	1018	1338	java/lang/Throwable
    //   1023	1051	1338	java/lang/Throwable
    //   1057	1074	1338	java/lang/Throwable
    //   1074	1084	1338	java/lang/Throwable
    //   1094	1106	1338	java/lang/Throwable
    //   1111	1159	1338	java/lang/Throwable
    //   1162	1280	1338	java/lang/Throwable
    //   1280	1290	1338	java/lang/Throwable
    //   529	539	1346	finally
    //   543	549	1346	finally
    //   553	562	1346	finally
    //   566	588	1346	finally
    //   1362	1370	1346	finally
    //   529	539	1350	java/lang/Throwable
    //   543	549	1350	java/lang/Throwable
    //   553	562	1350	java/lang/Throwable
    //   566	588	1350	java/lang/Throwable
    //   1374	1380	1393	java/lang/Throwable
    //   1380	1390	1393	java/lang/Throwable
    //   1416	1423	1436	java/lang/Throwable
    //   1423	1433	1436	java/lang/Throwable
    //   2	14	1448	finally
    //   18	25	1448	finally
    //   36	51	1448	finally
    //   51	124	1448	finally
    //   130	154	1448	finally
    //   161	173	1448	finally
    //   177	186	1448	finally
    //   191	197	1448	finally
    //   219	229	1448	finally
    //   229	235	1448	finally
    //   262	272	1448	finally
    //   287	293	1448	finally
    //   305	312	1448	finally
    //   318	358	1448	finally
    //   364	370	1448	finally
    //   397	445	1448	finally
    //   452	475	1448	finally
    //   480	500	1448	finally
    //   506	516	1448	finally
    //   1295	1302	1448	finally
    //   1302	1312	1448	finally
    //   1316	1321	1448	finally
    //   1321	1327	1448	finally
    //   1374	1380	1448	finally
    //   1380	1390	1448	finally
    //   1394	1399	1448	finally
    //   1402	1407	1448	finally
    //   1416	1423	1448	finally
    //   1423	1433	1448	finally
    //   1438	1446	1448	finally
    //   1446	1448	1448	finally
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
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 58	com/tencent/acstat/af:c	Lcom/tencent/acstat/an;
    //   9: invokevirtual 546	com/tencent/acstat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: ldc_w 548
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore 5
    //   26: aload 5
    //   28: astore_3
    //   29: aload 5
    //   31: astore 4
    //   33: aload 5
    //   35: invokeinterface 554 1 0
    //   40: ifeq +165 -> 205
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore 4
    //   50: aload 5
    //   52: iconst_0
    //   53: invokeinterface 558 2 0
    //   58: istore_1
    //   59: aload 5
    //   61: astore_3
    //   62: aload 5
    //   64: astore 4
    //   66: aload 5
    //   68: iconst_1
    //   69: invokeinterface 598 2 0
    //   74: astore 6
    //   76: aload 5
    //   78: astore_3
    //   79: aload 5
    //   81: astore 4
    //   83: aload 5
    //   85: iconst_2
    //   86: invokeinterface 598 2 0
    //   91: astore 7
    //   93: aload 5
    //   95: astore_3
    //   96: aload 5
    //   98: astore 4
    //   100: aload 5
    //   102: iconst_3
    //   103: invokeinterface 558 2 0
    //   108: istore_2
    //   109: aload 5
    //   111: astore_3
    //   112: aload 5
    //   114: astore 4
    //   116: new 522	com/tencent/acstat/e
    //   119: dup
    //   120: iload_1
    //   121: invokespecial 768	com/tencent/acstat/e:<init>	(I)V
    //   124: astore 8
    //   126: aload 5
    //   128: astore_3
    //   129: aload 5
    //   131: astore 4
    //   133: aload 8
    //   135: iload_1
    //   136: putfield 559	com/tencent/acstat/e:a	I
    //   139: aload 5
    //   141: astore_3
    //   142: aload 5
    //   144: astore 4
    //   146: aload 8
    //   148: new 532	org/json/JSONObject
    //   151: dup
    //   152: aload 6
    //   154: invokespecial 769	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   157: putfield 530	com/tencent/acstat/e:b	Lorg/json/JSONObject;
    //   160: aload 5
    //   162: astore_3
    //   163: aload 5
    //   165: astore 4
    //   167: aload 8
    //   169: aload 7
    //   171: putfield 536	com/tencent/acstat/e:c	Ljava/lang/String;
    //   174: aload 5
    //   176: astore_3
    //   177: aload 5
    //   179: astore 4
    //   181: aload 8
    //   183: iload_2
    //   184: putfield 540	com/tencent/acstat/e:d	I
    //   187: aload 5
    //   189: astore_3
    //   190: aload 5
    //   192: astore 4
    //   194: getstatic 44	com/tencent/acstat/af:i	Landroid/content/Context;
    //   197: aload 8
    //   199: invokestatic 772	com/tencent/acstat/StatConfig:a	(Landroid/content/Context;Lcom/tencent/acstat/e;)V
    //   202: goto -176 -> 26
    //   205: aload 5
    //   207: ifnull +50 -> 257
    //   210: aload 5
    //   212: invokeinterface 460 1 0
    //   217: return
    //   218: astore_3
    //   219: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   222: aload_3
    //   223: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   226: return
    //   227: astore 4
    //   229: goto +29 -> 258
    //   232: astore 5
    //   234: aload 4
    //   236: astore_3
    //   237: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   240: aload 5
    //   242: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   245: aload 4
    //   247: ifnull +10 -> 257
    //   250: aload 4
    //   252: invokeinterface 460 1 0
    //   257: return
    //   258: aload_3
    //   259: ifnull +20 -> 279
    //   262: aload_3
    //   263: invokeinterface 460 1 0
    //   268: goto +11 -> 279
    //   271: astore_3
    //   272: getstatic 42	com/tencent/acstat/af:h	Lcom/tencent/acstat/common/StatLogger;
    //   275: aload_3
    //   276: invokevirtual 152	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   279: goto +6 -> 285
    //   282: aload 4
    //   284: athrow
    //   285: goto -3 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	af
    //   58	78	1	i1	int
    //   108	76	2	i2	int
    //   4	186	3	localObject1	Object
    //   218	5	3	localThrowable1	Throwable
    //   236	27	3	localObject2	Object
    //   271	5	3	localThrowable2	Throwable
    //   1	192	4	localObject3	Object
    //   227	56	4	localObject4	Object
    //   24	187	5	localCursor	Cursor
    //   232	9	5	localThrowable3	Throwable
    //   74	79	6	str1	String
    //   91	79	7	str2	String
    //   124	74	8	locale	e
    // Exception table:
    //   from	to	target	type
    //   210	217	218	java/lang/Throwable
    //   250	257	218	java/lang/Throwable
    //   5	26	227	finally
    //   33	43	227	finally
    //   50	59	227	finally
    //   66	76	227	finally
    //   83	93	227	finally
    //   100	109	227	finally
    //   116	126	227	finally
    //   133	139	227	finally
    //   146	160	227	finally
    //   167	174	227	finally
    //   181	187	227	finally
    //   194	202	227	finally
    //   237	245	227	finally
    //   5	26	232	java/lang/Throwable
    //   33	43	232	java/lang/Throwable
    //   50	59	232	java/lang/Throwable
    //   66	76	232	java/lang/Throwable
    //   83	93	232	java/lang/Throwable
    //   100	109	232	java/lang/Throwable
    //   116	126	232	java/lang/Throwable
    //   133	139	232	java/lang/Throwable
    //   146	160	232	java/lang/Throwable
    //   167	174	232	java/lang/Throwable
    //   181	187	232	java/lang/Throwable
    //   194	202	232	java/lang/Throwable
    //   262	268	271	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.af
 * JD-Core Version:    0.7.0.1
 */