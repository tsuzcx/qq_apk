package com.tencent.beacon.core.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.b;
import java.util.Date;

public class c
{
  public static boolean a(Context paramContext, String paramString, Object[] paramArrayOfObject)
  {
    Object localObject2 = b.b(paramContext).a();
    Object localObject1 = e.a((String)localObject2);
    if ((paramContext != null) && (paramString != null) && (paramArrayOfObject != null)) {}
    for (;;)
    {
      Object localObject3;
      long l;
      try
      {
        if (paramArrayOfObject.length == 0) {
          return false;
        }
      }
      finally {}
      try
      {
        localObject2 = e.a(paramContext, (String)localObject2).getWritableDatabase();
        localObject3 = new StringBuilder();
        localObject3 = ((StringBuilder)localObject3).append("_key = '").append(paramString);
        ((SQLiteDatabase)localObject2).delete("t_conf", "'", null);
        localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("_key", paramString);
        ((ContentValues)localObject3).put("_value", (String)paramArrayOfObject[0]);
        ((ContentValues)localObject3).put("_vdate", (Long)paramArrayOfObject[1]);
        ((ContentValues)localObject3).put("_time", Long.valueOf(new Date().getTime()));
        l = ((SQLiteDatabase)localObject2).insert("t_conf", null, (ContentValues)localObject3);
        if (l >= 0L) {
          break label229;
        }
        paramContext = i.a(paramContext);
        paramString = new StringBuilder();
        paramContext.a("503", "TB: t_conf insert fail! cid: " + l);
        d.b("[db] insertOrUpdateByKey failure! return false!", new Object[0]);
        bool = false;
      }
      catch (Exception paramContext)
      {
        bool = false;
        continue;
      }
      return bool;
      label229:
      bool = true;
    }
  }
  
  /* Error */
  public static Object[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokestatic 14	com/tencent/beacon/core/info/b:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/b;
    //   7: invokevirtual 17	com/tencent/beacon/core/info/b:a	()Ljava/lang/String;
    //   10: astore 4
    //   12: aload 4
    //   14: invokestatic 22	com/tencent/beacon/core/a/a/e:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: astore 6
    //   19: aload 6
    //   21: monitorenter
    //   22: aload_0
    //   23: ifnonnull +17 -> 40
    //   26: ldc 116
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 112	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload 6
    //   37: monitorexit
    //   38: aconst_null
    //   39: areturn
    //   40: aload_1
    //   41: ifnonnull +17 -> 58
    //   44: ldc 118
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokestatic 112	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload 6
    //   55: monitorexit
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: aload 4
    //   61: invokestatic 25	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   64: invokevirtual 29	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnonnull +17 -> 88
    //   74: ldc 120
    //   76: iconst_0
    //   77: anewarray 4	java/lang/Object
    //   80: invokestatic 112	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 6
    //   85: monitorexit
    //   86: aconst_null
    //   87: areturn
    //   88: new 31	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   95: astore 7
    //   97: aload 7
    //   99: ldc 37
    //   101: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: astore 7
    //   110: aload 4
    //   112: ldc 43
    //   114: aconst_null
    //   115: aload 7
    //   117: ldc 45
    //   119: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aconst_null
    //   126: aconst_null
    //   127: aconst_null
    //   128: aconst_null
    //   129: invokevirtual 124	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   132: astore 4
    //   134: aload 4
    //   136: ifnull +112 -> 248
    //   139: aload 4
    //   141: astore 5
    //   143: aload 4
    //   145: invokeinterface 130 1 0
    //   150: ifeq +98 -> 248
    //   153: aload 4
    //   155: astore 5
    //   157: aload 4
    //   159: aload 4
    //   161: ldc 65
    //   163: invokeinterface 134 2 0
    //   168: invokeinterface 138 2 0
    //   173: astore 7
    //   175: aload 4
    //   177: astore 5
    //   179: aload 4
    //   181: aload 4
    //   183: ldc 69
    //   185: invokeinterface 134 2 0
    //   190: invokeinterface 142 2 0
    //   195: lstore_2
    //   196: aload 4
    //   198: ifnull +20 -> 218
    //   201: aload 4
    //   203: invokeinterface 145 1 0
    //   208: ifne +10 -> 218
    //   211: aload 4
    //   213: invokeinterface 148 1 0
    //   218: aload 6
    //   220: monitorexit
    //   221: iconst_3
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_1
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: aload 7
    //   233: aastore
    //   234: dup
    //   235: iconst_2
    //   236: lload_2
    //   237: invokestatic 87	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   240: aastore
    //   241: areturn
    //   242: astore_0
    //   243: aload 6
    //   245: monitorexit
    //   246: aload_0
    //   247: athrow
    //   248: aload 4
    //   250: ifnull +20 -> 270
    //   253: aload 4
    //   255: invokeinterface 145 1 0
    //   260: ifne +10 -> 270
    //   263: aload 4
    //   265: invokeinterface 148 1 0
    //   270: aload 6
    //   272: monitorexit
    //   273: aconst_null
    //   274: areturn
    //   275: astore_1
    //   276: aconst_null
    //   277: astore 4
    //   279: aload 4
    //   281: astore 5
    //   283: aload_0
    //   284: invokestatic 96	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   287: astore_0
    //   288: aload 4
    //   290: astore 5
    //   292: aload_0
    //   293: ldc 98
    //   295: ldc 150
    //   297: aload_1
    //   298: invokevirtual 153	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload 4
    //   303: ifnull -33 -> 270
    //   306: aload 4
    //   308: invokeinterface 145 1 0
    //   313: ifne -43 -> 270
    //   316: goto -53 -> 263
    //   319: aload 5
    //   321: ifnull +20 -> 341
    //   324: aload 5
    //   326: invokeinterface 145 1 0
    //   331: ifne +10 -> 341
    //   334: aload 5
    //   336: invokeinterface 148 1 0
    //   341: aload_0
    //   342: athrow
    //   343: astore_0
    //   344: goto -25 -> 319
    //   347: astore_1
    //   348: goto -69 -> 279
    //   351: astore_0
    //   352: goto -33 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	paramContext	Context
    //   0	355	1	paramString	String
    //   195	42	2	l	long
    //   10	297	4	localObject1	Object
    //   1	334	5	localObject2	Object
    //   17	254	6	localObject3	Object
    //   95	137	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   26	38	242	finally
    //   44	56	242	finally
    //   83	86	242	finally
    //   201	218	242	finally
    //   218	242	242	finally
    //   243	246	242	finally
    //   253	263	242	finally
    //   263	270	242	finally
    //   270	273	242	finally
    //   306	316	242	finally
    //   324	341	242	finally
    //   341	343	242	finally
    //   58	69	275	java/lang/Exception
    //   74	83	275	java/lang/Exception
    //   88	97	275	java/lang/Exception
    //   97	110	275	java/lang/Exception
    //   110	134	275	java/lang/Exception
    //   58	69	343	finally
    //   74	83	343	finally
    //   88	97	343	finally
    //   97	110	343	finally
    //   110	134	343	finally
    //   143	153	347	java/lang/Exception
    //   157	175	347	java/lang/Exception
    //   179	196	347	java/lang/Exception
    //   143	153	351	finally
    //   157	175	351	finally
    //   179	196	351	finally
    //   283	288	351	finally
    //   292	301	351	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */