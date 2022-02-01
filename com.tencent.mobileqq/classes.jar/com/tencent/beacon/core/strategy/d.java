package com.tencent.beacon.core.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.beacon.core.a.a.e;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.info.b;

public class d
{
  public static int a(Context paramContext, int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    if ((paramContext == null) || (paramInt < -1)) {}
    Object localObject2;
    for (;;)
    {
      try
      {
        com.tencent.beacon.core.e.d.i("[db] params error.", new Object[0]);
        i = j;
        return i;
      }
      finally {}
      localObject2 = b.b(paramContext).a();
      try
      {
        localObject2 = e.a(paramContext, (String)localObject2).getWritableDatabase();
        if (localObject2 == null)
        {
          com.tencent.beacon.core.e.d.b("get db fail!,return ", new Object[0]);
          i = j;
        }
      }
      catch (Throwable localThrowable1) {}
    }
    for (;;)
    {
      for (;;)
      {
        i.a(paramContext).a("503", "[db] TB: t_strategy deleteStrategy fail!");
        com.tencent.beacon.core.e.d.a(localThrowable1);
        break;
        String str;
        if (paramInt > 0) {
          str = String.format("%s = %d", new Object[] { "_key", Integer.valueOf(paramInt) });
        }
        j = ((SQLiteDatabase)localObject2).delete("t_strategy", str, null);
        i = j;
        try
        {
          com.tencent.beacon.core.e.d.g("[db] key:%d , num: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        }
        catch (Throwable localThrowable2) {}
      }
    }
  }
  
  public static ContentValues a(k paramk)
  {
    if (paramk == null) {
      return null;
    }
    ContentValues localContentValues = new ContentValues();
    long l = paramk.a;
    if (l >= 0L) {
      localContentValues.put("_id", Long.valueOf(l));
    }
    localContentValues.put("_key", Integer.valueOf(paramk.b));
    localContentValues.put("_datas", paramk.c);
    return localContentValues;
  }
  
  public static k a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isBeforeFirst()) || (paramCursor.isAfterLast())) {
      return null;
    }
    com.tencent.beacon.core.e.d.a("[db] parse bean.", new Object[0]);
    k localk = new k();
    localk.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    localk.b = paramCursor.getInt(paramCursor.getColumnIndex("_key"));
    localk.c = paramCursor.getBlob(paramCursor.getColumnIndex("_datas"));
    return localk;
  }
  
  public static void a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    k localk = new k();
    localk.b = paramInt;
    localk.c = paramArrayOfByte;
    a(paramContext, localk);
  }
  
  public static boolean a(Context paramContext, k paramk)
  {
    boolean bool2 = false;
    if ((paramContext == null) || (paramk == null)) {}
    for (;;)
    {
      try
      {
        com.tencent.beacon.core.e.d.i("[db] context or bean is null}", new Object[0]);
        bool1 = bool2;
        return bool1;
      }
      finally {}
      Object localObject = b.b(paramContext).a();
      try
      {
        localObject = e.a(paramContext, (String)localObject).getWritableDatabase();
        if (localObject != null) {
          break label108;
        }
        com.tencent.beacon.core.e.d.b("[db] get db fail!,return false ", new Object[0]);
        bool1 = bool2;
      }
      catch (Throwable paramk)
      {
        i.a(paramContext).a("503", "[db] TB: t_strategy updateStrategyBean fail! ", paramk);
        com.tencent.beacon.core.e.d.b("[db] error: %s", new Object[] { paramk.toString() });
        bool1 = bool2;
      }
      continue;
      label108:
      ContentValues localContentValues = a(paramk);
      boolean bool1 = bool2;
      if (localContentValues != null)
      {
        long l = ((SQLiteDatabase)localObject).replace("t_strategy", "_id", localContentValues);
        if (l < 0L)
        {
          paramk = i.a(paramContext);
          localObject = new StringBuilder();
          paramk.a("503", "[db] TB: t_strategy updateStrategyBean fail! cid: " + l);
          com.tencent.beacon.core.e.d.i("[db] insert failure! return false ", new Object[0]);
          bool1 = bool2;
        }
        else
        {
          paramk.a = l;
          com.tencent.beacon.core.e.d.e("[db] update strategy %d true ", new Object[] { Integer.valueOf(paramk.b) });
          bool1 = true;
        }
      }
    }
  }
  
  /* Error */
  public static k b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnonnull +19 -> 28
    //   12: ldc 199
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 16	com/tencent/beacon/core/e/d:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aconst_null
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: invokestatic 22	com/tencent/beacon/core/info/b:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/b;
    //   32: invokevirtual 25	com/tencent/beacon/core/info/b:a	()Ljava/lang/String;
    //   35: astore_3
    //   36: aload_2
    //   37: astore 4
    //   39: aload_0
    //   40: aload_3
    //   41: invokestatic 30	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   44: invokevirtual 34	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnonnull +20 -> 69
    //   52: aload_2
    //   53: astore 4
    //   55: ldc 201
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 16	com/tencent/beacon/core/e/d:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aconst_null
    //   65: astore_0
    //   66: goto -43 -> 23
    //   69: aload_2
    //   70: astore 4
    //   72: getstatic 207	java/util/Locale:US	Ljava/util/Locale;
    //   75: astore 5
    //   77: aload_2
    //   78: astore 4
    //   80: aload 5
    //   82: ldc 209
    //   84: iconst_2
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc 57
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: iload_1
    //   96: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokestatic 212	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   103: astore 5
    //   105: aload_2
    //   106: astore 4
    //   108: aload_3
    //   109: ldc 71
    //   111: aconst_null
    //   112: aload 5
    //   114: aconst_null
    //   115: aconst_null
    //   116: aconst_null
    //   117: aconst_null
    //   118: invokevirtual 216	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull +159 -> 282
    //   126: aload_3
    //   127: invokeinterface 219 1 0
    //   132: ifeq +150 -> 282
    //   135: aload_3
    //   136: invokestatic 221	com/tencent/beacon/core/strategy/d:a	(Landroid/database/Cursor;)Lcom/tencent/beacon/core/strategy/k;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +163 -> 304
    //   144: ldc 223
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_2
    //   153: getfield 109	com/tencent/beacon/core/strategy/k:b	I
    //   156: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: invokestatic 82	com/tencent/beacon/core/e/d:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_2
    //   164: astore_0
    //   165: aload_3
    //   166: ifnull -143 -> 23
    //   169: aload_2
    //   170: astore_0
    //   171: aload_3
    //   172: invokeinterface 226 1 0
    //   177: ifne -154 -> 23
    //   180: aload_3
    //   181: invokeinterface 229 1 0
    //   186: aload_2
    //   187: astore_0
    //   188: goto -165 -> 23
    //   191: astore_0
    //   192: ldc 2
    //   194: monitorexit
    //   195: aload_0
    //   196: athrow
    //   197: astore 5
    //   199: aload_3
    //   200: astore 4
    //   202: aload_0
    //   203: invokestatic 43	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   206: astore_0
    //   207: aload_3
    //   208: astore 4
    //   210: aload_0
    //   211: ldc 45
    //   213: ldc 231
    //   215: invokevirtual 50	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_3
    //   219: astore 4
    //   221: aload 5
    //   223: invokestatic 53	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: astore_0
    //   228: aload_3
    //   229: ifnull -206 -> 23
    //   232: aload_2
    //   233: astore_0
    //   234: aload_3
    //   235: invokeinterface 226 1 0
    //   240: ifne -217 -> 23
    //   243: aload_3
    //   244: invokeinterface 229 1 0
    //   249: aload_2
    //   250: astore_0
    //   251: goto -228 -> 23
    //   254: aload_3
    //   255: ifnull +18 -> 273
    //   258: aload_3
    //   259: invokeinterface 226 1 0
    //   264: ifne +9 -> 273
    //   267: aload_3
    //   268: invokeinterface 229 1 0
    //   273: aload_0
    //   274: athrow
    //   275: astore 5
    //   277: aconst_null
    //   278: astore_2
    //   279: goto -80 -> 199
    //   282: aconst_null
    //   283: astore_2
    //   284: goto -121 -> 163
    //   287: astore 5
    //   289: aconst_null
    //   290: astore_2
    //   291: aload 6
    //   293: astore_3
    //   294: goto -95 -> 199
    //   297: astore_0
    //   298: aload 4
    //   300: astore_3
    //   301: goto -47 -> 254
    //   304: goto -141 -> 163
    //   307: astore_0
    //   308: goto -54 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramContext	Context
    //   0	311	1	paramInt	int
    //   1	290	2	localk	k
    //   35	266	3	localObject1	Object
    //   37	262	4	localObject2	Object
    //   75	38	5	localObject3	Object
    //   197	25	5	localThrowable1	Throwable
    //   275	1	5	localThrowable2	Throwable
    //   287	1	5	localThrowable3	Throwable
    //   3	289	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	21	191	finally
    //   28	36	191	finally
    //   171	186	191	finally
    //   234	249	191	finally
    //   258	273	191	finally
    //   273	275	191	finally
    //   144	163	197	java/lang/Throwable
    //   126	140	275	java/lang/Throwable
    //   39	48	287	java/lang/Throwable
    //   55	64	287	java/lang/Throwable
    //   72	77	287	java/lang/Throwable
    //   80	105	287	java/lang/Throwable
    //   108	122	287	java/lang/Throwable
    //   39	48	297	finally
    //   55	64	297	finally
    //   72	77	297	finally
    //   80	105	297	finally
    //   108	122	297	finally
    //   202	207	297	finally
    //   210	218	297	finally
    //   221	226	297	finally
    //   126	140	307	finally
    //   144	163	307	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.d
 * JD-Core Version:    0.7.0.1
 */