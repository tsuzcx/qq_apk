package com.tencent.beacon.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public long a = -1L;
  public byte[] b = null;
  private int c = -1;
  private int d = -1;
  private long e = -1L;
  private long f = 0L;
  
  public a() {}
  
  public a(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramLong;
    this.b = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      this.f = paramArrayOfByte.length;
    }
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: aload_0
    //   8: ifnonnull +19 -> 27
    //   11: ldc 38
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: iload_3
    //   21: istore_2
    //   22: ldc 2
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: ldc2_w 18
    //   30: ldc2_w 44
    //   33: lcmp
    //   34: ifle +8 -> 42
    //   37: iconst_0
    //   38: istore_2
    //   39: goto -17 -> 22
    //   42: aload_1
    //   43: ifnull +123 -> 166
    //   46: aload_1
    //   47: arraylength
    //   48: ifle +118 -> 166
    //   51: ldc 47
    //   53: astore 4
    //   55: iload_2
    //   56: aload_1
    //   57: arraylength
    //   58: if_icmpge +38 -> 96
    //   61: new 49	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   68: aload 4
    //   70: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 56
    //   75: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: iload_2
    //   80: iaload
    //   81: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 4
    //   89: iload_2
    //   90: iconst_1
    //   91: iadd
    //   92: istore_2
    //   93: goto -38 -> 55
    //   96: aload 4
    //   98: iconst_4
    //   99: invokevirtual 69	java/lang/String:substring	(I)Ljava/lang/String;
    //   102: astore_1
    //   103: new 49	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   110: ldc 71
    //   112: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 73
    //   117: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 75
    //   126: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_1
    //   133: aload_0
    //   134: invokestatic 80	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   137: invokevirtual 84	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   140: ldc 86
    //   142: aload_1
    //   143: aconst_null
    //   144: invokevirtual 92	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   147: istore_2
    //   148: goto -126 -> 22
    //   151: astore_0
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: ldc 2
    //   157: monitorexit
    //   158: aload_0
    //   159: athrow
    //   160: astore_0
    //   161: iload_3
    //   162: istore_2
    //   163: goto -141 -> 22
    //   166: ldc 71
    //   168: astore_1
    //   169: goto -36 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   0	172	1	paramArrayOfInt	int[]
    //   3	160	2	i	int
    //   1	161	3	j	int
    //   53	44	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   133	148	151	finally
    //   11	20	154	finally
    //   46	51	154	finally
    //   55	89	154	finally
    //   96	133	154	finally
    //   152	154	154	finally
    //   133	148	160	java/lang/Throwable
  }
  
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    if (paramContext == null) {}
    int i;
    for (;;)
    {
      try
      {
        com.tencent.beacon.a.g.a.d("[db] deleteList have null args!", new Object[0]);
        i = -1;
        return i;
      }
      finally {}
      i = m;
      if (paramArrayOfLong != null)
      {
        int n = paramArrayOfLong.length;
        i = m;
        if (n > 0) {
          i = k;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramContext = c.a(paramContext).getWritableDatabase();
        i = k;
        localStringBuffer = new StringBuffer();
        k = 0;
        i = j;
        if (k < paramArrayOfLong.length)
        {
          i = j;
          long l = paramArrayOfLong[k].longValue();
          i = j;
          localStringBuffer.append(" or  _id = " + l);
          i = j;
          if (k > 0)
          {
            i = j;
            if (k % 25 == 0)
            {
              i = j;
              j += paramContext.delete("t_event", localStringBuffer.substring(4), null);
              i = j;
              localStringBuffer.setLength(0);
              i = j;
            }
          }
        }
        else
        {
          k = j;
          i = j;
          if (localStringBuffer.length() > 0)
          {
            i = j;
            k = paramContext.delete("t_event", localStringBuffer.substring(4), null);
            i = k + j;
          }
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          StringBuffer localStringBuffer;
          localStringBuffer.setLength(0);
          k = i;
          i = k;
          com.tencent.beacon.a.g.a.a("[db] total deleteNum: " + k, new Object[0]);
          i = k;
        }
        catch (Throwable paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        com.tencent.beacon.a.g.a.d("[db] " + paramContext.getMessage(), new Object[0]);
        break;
      }
      finally {}
      k += 1;
      j = i;
    }
  }
  
  private static ContentValues a(a parama)
  {
    ContentValues localContentValues = new ContentValues();
    if (parama.a > 0L) {
      localContentValues.put("_id", Long.valueOf(parama.a));
    }
    localContentValues.put("_prority", Integer.valueOf(parama.d));
    localContentValues.put("_time", Long.valueOf(parama.e));
    localContentValues.put("_type", Integer.valueOf(parama.c));
    localContentValues.put("_datas", parama.b);
    localContentValues.put("_length", Long.valueOf(parama.f));
    return localContentValues;
  }
  
  /* Error */
  public static List a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull +19 -> 25
    //   9: ldc 173
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aconst_null
    //   19: astore_1
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: invokestatic 80	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   29: invokevirtual 84	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: ldc 175
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: ldc 177
    //   41: ldc 179
    //   43: invokevirtual 183	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_0
    //   47: aload_0
    //   48: invokeinterface 189 1 0
    //   53: ifeq +244 -> 297
    //   56: new 191	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 192	java/util/ArrayList:<init>	()V
    //   63: astore_2
    //   64: aload_2
    //   65: aload_0
    //   66: aload_0
    //   67: ldc 139
    //   69: invokeinterface 196 2 0
    //   74: invokeinterface 200 2 0
    //   79: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: invokeinterface 206 2 0
    //   87: pop
    //   88: aload_2
    //   89: aload_0
    //   90: aload_0
    //   91: ldc 208
    //   93: invokeinterface 196 2 0
    //   98: invokeinterface 211 2 0
    //   103: invokeinterface 206 2 0
    //   108: pop
    //   109: aload_2
    //   110: aload_0
    //   111: aload_0
    //   112: ldc 159
    //   114: invokeinterface 196 2 0
    //   119: invokeinterface 215 2 0
    //   124: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: invokeinterface 206 2 0
    //   132: pop
    //   133: aload_2
    //   134: aload_0
    //   135: aload_0
    //   136: ldc 163
    //   138: invokeinterface 196 2 0
    //   143: invokeinterface 219 2 0
    //   148: invokeinterface 206 2 0
    //   153: pop
    //   154: aload_2
    //   155: aload_0
    //   156: aload_0
    //   157: ldc 221
    //   159: invokeinterface 196 2 0
    //   164: invokeinterface 200 2 0
    //   169: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: invokeinterface 206 2 0
    //   177: pop
    //   178: ldc 223
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 128	com/tencent/beacon/a/g/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aload_2
    //   188: astore_1
    //   189: aload_0
    //   190: ifnull -170 -> 20
    //   193: aload_2
    //   194: astore_1
    //   195: aload_0
    //   196: invokeinterface 226 1 0
    //   201: ifne -181 -> 20
    //   204: aload_0
    //   205: invokeinterface 229 1 0
    //   210: aload_2
    //   211: astore_1
    //   212: goto -192 -> 20
    //   215: astore_0
    //   216: ldc 2
    //   218: monitorexit
    //   219: aload_0
    //   220: athrow
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_0
    //   225: astore_1
    //   226: aload_2
    //   227: ifnull -207 -> 20
    //   230: aload_0
    //   231: astore_1
    //   232: aload_2
    //   233: invokeinterface 226 1 0
    //   238: ifne -218 -> 20
    //   241: aload_2
    //   242: invokeinterface 229 1 0
    //   247: aload_0
    //   248: astore_1
    //   249: goto -229 -> 20
    //   252: aload_0
    //   253: ifnull +18 -> 271
    //   256: aload_0
    //   257: invokeinterface 226 1 0
    //   262: ifne +9 -> 271
    //   265: aload_0
    //   266: invokeinterface 229 1 0
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: goto -22 -> 252
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_0
    //   281: astore_2
    //   282: aload_1
    //   283: astore_0
    //   284: goto -60 -> 224
    //   287: astore_1
    //   288: aload_0
    //   289: astore_1
    //   290: aload_2
    //   291: astore_0
    //   292: aload_1
    //   293: astore_2
    //   294: goto -70 -> 224
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -112 -> 187
    //   302: astore_1
    //   303: aconst_null
    //   304: astore_0
    //   305: goto -53 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramContext	Context
    //   19	253	1	localObject1	Object
    //   273	1	1	localObject2	Object
    //   277	1	1	localException1	java.lang.Exception
    //   279	4	1	localObject3	Object
    //   287	1	1	localException2	java.lang.Exception
    //   289	4	1	localContext	Context
    //   302	1	1	localObject4	Object
    //   1	298	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	215	finally
    //   195	210	215	finally
    //   232	247	215	finally
    //   256	271	215	finally
    //   271	273	215	finally
    //   25	47	221	java/lang/Exception
    //   47	64	273	finally
    //   64	187	273	finally
    //   47	64	277	java/lang/Exception
    //   64	187	287	java/lang/Exception
    //   25	47	302	finally
  }
  
  public static List<a> a(Context paramContext, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramContext = a(paramContext, paramArrayOfInt, 1, 2, paramInt, -1L);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static List<a> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    try
    {
      paramContext = b(paramContext, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramLong);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static List<a> a(Cursor paramCursor)
  {
    Object localObject;
    if (paramCursor == null)
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("_id");
    int j = paramCursor.getColumnIndex("_prority");
    int k = paramCursor.getColumnIndex("_time");
    int m = paramCursor.getColumnIndex("_type");
    int n = paramCursor.getColumnIndex("_datas");
    int i1 = paramCursor.getColumnIndex("_length");
    for (;;)
    {
      localObject = localArrayList;
      if (!paramCursor.moveToNext()) {
        break;
      }
      localObject = new a();
      ((a)localObject).a = paramCursor.getLong(i);
      ((a)localObject).b = paramCursor.getBlob(n);
      ((a)localObject).d = paramCursor.getInt(j);
      ((a)localObject).e = paramCursor.getLong(k);
      ((a)localObject).c = paramCursor.getInt(m);
      ((a)localObject).f = paramCursor.getLong(i1);
      localArrayList.add(localObject);
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: ifnonnull +20 -> 30
    //   13: ldc 244
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: iload 5
    //   24: istore_3
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: iload 5
    //   32: istore_3
    //   33: aload_1
    //   34: ifnull -9 -> 25
    //   37: iload 5
    //   39: istore_3
    //   40: aload_1
    //   41: invokevirtual 247	java/lang/String:trim	()Ljava/lang/String;
    //   44: ldc 47
    //   46: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifne -24 -> 25
    //   52: new 49	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 252
    //   58: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 254
    //   67: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore_1
    //   74: aload_0
    //   75: invokestatic 80	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   78: invokevirtual 84	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   81: ldc 175
    //   83: aload_1
    //   84: aconst_null
    //   85: invokevirtual 92	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   88: istore_2
    //   89: iload_2
    //   90: iconst_1
    //   91: if_icmpne +24 -> 115
    //   94: iload 4
    //   96: istore_3
    //   97: goto -72 -> 25
    //   100: astore_0
    //   101: iconst_0
    //   102: istore_3
    //   103: goto -6 -> 97
    //   106: astore_0
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    //   115: iconst_0
    //   116: istore_3
    //   117: goto -20 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramString	java.lang.String
    //   88	4	2	i	int
    //   24	93	3	bool1	boolean
    //   1	94	4	bool2	boolean
    //   4	34	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   74	89	100	java/lang/Throwable
    //   74	89	106	finally
    //   13	22	109	finally
    //   40	74	109	finally
    //   107	109	109	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, List<a> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull +18 -> 24
    //   9: ldc_w 257
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_3
    //   23: ireturn
    //   24: aload_1
    //   25: invokeinterface 260 1 0
    //   30: istore_2
    //   31: iload_2
    //   32: ifgt +8 -> 40
    //   35: iconst_1
    //   36: istore_3
    //   37: goto -18 -> 19
    //   40: aconst_null
    //   41: astore 6
    //   43: aload_0
    //   44: invokestatic 80	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   47: invokevirtual 84	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 263	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: aload_1
    //   59: invokeinterface 260 1 0
    //   64: if_icmpge +61 -> 125
    //   67: aload_1
    //   68: iload_2
    //   69: invokeinterface 267 2 0
    //   74: checkcast 2	com/tencent/beacon/a/a/a/a
    //   77: astore 6
    //   79: aload_0
    //   80: ldc 86
    //   82: ldc 139
    //   84: aload 6
    //   86: invokestatic 269	com/tencent/beacon/a/a/a/a:a	(Lcom/tencent/beacon/a/a/a/a;)Landroid/content/ContentValues;
    //   89: invokevirtual 273	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   92: lstore 4
    //   94: lload 4
    //   96: lconst_0
    //   97: lcmp
    //   98: ifge +13 -> 111
    //   101: ldc_w 275
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload 6
    //   113: lload 4
    //   115: putfield 21	com/tencent/beacon/a/a/a/a:a	J
    //   118: iload_2
    //   119: iconst_1
    //   120: iadd
    //   121: istore_2
    //   122: goto -65 -> 57
    //   125: aload_0
    //   126: invokevirtual 278	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   129: aload_0
    //   130: invokevirtual 281	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   133: iconst_1
    //   134: istore_3
    //   135: goto -116 -> 19
    //   138: astore_0
    //   139: iconst_1
    //   140: istore_3
    //   141: goto -6 -> 135
    //   144: astore_0
    //   145: aload 6
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 281	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   152: iconst_0
    //   153: istore_3
    //   154: goto -19 -> 135
    //   157: astore_0
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -25 -> 135
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 281	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_0
    //   173: ldc 2
    //   175: monitorexit
    //   176: aload_0
    //   177: athrow
    //   178: astore_0
    //   179: goto -9 -> 170
    //   182: astore_1
    //   183: goto -17 -> 166
    //   186: astore_1
    //   187: goto -39 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramContext	Context
    //   0	190	1	paramList	List<a>
    //   30	92	2	i	int
    //   1	159	3	bool	boolean
    //   92	22	4	l	long
    //   41	105	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   129	133	138	java/lang/Exception
    //   43	51	144	java/lang/Throwable
    //   148	152	157	java/lang/Exception
    //   43	51	163	finally
    //   9	19	172	finally
    //   24	31	172	finally
    //   129	133	172	finally
    //   148	152	172	finally
    //   166	170	172	finally
    //   170	172	172	finally
    //   166	170	178	java/lang/Exception
    //   51	55	182	finally
    //   57	94	182	finally
    //   101	111	182	finally
    //   111	118	182	finally
    //   125	129	182	finally
    //   51	55	186	java/lang/Throwable
    //   57	94	186	java/lang/Throwable
    //   101	111	186	java/lang/Throwable
    //   111	118	186	java/lang/Throwable
    //   125	129	186	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, byte[] paramArrayOfByte, java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnull +11 -> 18
    //   10: aload_1
    //   11: ifnull +7 -> 18
    //   14: aload_2
    //   15: ifnonnull +19 -> 34
    //   18: ldc_w 285
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload 4
    //   33: ireturn
    //   34: aload_0
    //   35: invokestatic 80	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   38: invokevirtual 84	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   41: astore_0
    //   42: new 136	android/content/ContentValues
    //   45: dup
    //   46: invokespecial 137	android/content/ContentValues:<init>	()V
    //   49: astore 5
    //   51: aload 5
    //   53: ldc 208
    //   55: aload_2
    //   56: invokevirtual 288	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 5
    //   61: ldc 159
    //   63: new 290	java/util/Date
    //   66: dup
    //   67: invokespecial 291	java/util/Date:<init>	()V
    //   70: invokevirtual 294	java/util/Date:getTime	()J
    //   73: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   79: aload 5
    //   81: ldc 221
    //   83: iload_3
    //   84: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   90: aload 5
    //   92: ldc 163
    //   94: aload_1
    //   95: invokevirtual 166	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   98: aload_0
    //   99: ldc 175
    //   101: aconst_null
    //   102: aload 5
    //   104: invokevirtual 273	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   107: lconst_0
    //   108: lcmp
    //   109: ifge +20 -> 129
    //   112: ldc_w 296
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: goto -94 -> 28
    //   125: astore_0
    //   126: goto -98 -> 28
    //   129: iconst_1
    //   130: istore 4
    //   132: goto -104 -> 28
    //   135: astore_0
    //   136: aload_0
    //   137: athrow
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramArrayOfByte	byte[]
    //   0	144	2	paramString	java.lang.String
    //   0	144	3	paramInt	int
    //   1	130	4	bool	boolean
    //   49	54	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   34	122	125	java/lang/Throwable
    //   34	122	135	finally
    //   18	28	138	finally
    //   136	138	138	finally
  }
  
  /* Error */
  public static int b(Context paramContext, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aconst_null
    //   5: astore 5
    //   7: ldc 2
    //   9: monitorenter
    //   10: aload_0
    //   11: ifnonnull +18 -> 29
    //   14: ldc_w 298
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 128	com/tencent/beacon/a/g/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: ldc2_w 18
    //   32: ldc2_w 44
    //   35: lcmp
    //   36: ifle +8 -> 44
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -17 -> 24
    //   44: ldc 47
    //   46: astore 4
    //   48: iload_3
    //   49: istore_2
    //   50: iload_2
    //   51: iconst_4
    //   52: if_icmpge +38 -> 90
    //   55: new 49	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   62: aload 4
    //   64: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 56
    //   69: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: iload_2
    //   74: iaload
    //   75: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 4
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -37 -> 50
    //   90: aload 4
    //   92: iconst_4
    //   93: invokevirtual 69	java/lang/String:substring	(I)Ljava/lang/String;
    //   96: astore_1
    //   97: new 49	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   104: ldc 71
    //   106: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 73
    //   111: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 75
    //   120: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_1
    //   127: aload_0
    //   128: invokestatic 80	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   131: invokevirtual 84	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   134: ldc 86
    //   136: iconst_1
    //   137: anewarray 65	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 300
    //   145: aastore
    //   146: aload_1
    //   147: aconst_null
    //   148: aconst_null
    //   149: aconst_null
    //   150: aconst_null
    //   151: invokevirtual 303	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore_0
    //   155: aload_0
    //   156: invokeinterface 189 1 0
    //   161: pop
    //   162: aload_0
    //   163: aload_0
    //   164: ldc_w 305
    //   167: invokeinterface 196 2 0
    //   172: invokeinterface 200 2 0
    //   177: istore_3
    //   178: iload_3
    //   179: istore_2
    //   180: aload_0
    //   181: ifnull +92 -> 273
    //   184: iload_3
    //   185: istore_2
    //   186: aload_0
    //   187: invokeinterface 226 1 0
    //   192: ifne +81 -> 273
    //   195: aload_0
    //   196: invokeinterface 229 1 0
    //   201: iload_3
    //   202: istore_2
    //   203: goto +70 -> 273
    //   206: aload_0
    //   207: ifnull +64 -> 271
    //   210: aload_0
    //   211: invokeinterface 226 1 0
    //   216: ifne +55 -> 271
    //   219: aload_0
    //   220: invokeinterface 229 1 0
    //   225: iconst_m1
    //   226: istore_2
    //   227: goto +46 -> 273
    //   230: aload_1
    //   231: ifnull +18 -> 249
    //   234: aload_1
    //   235: invokeinterface 226 1 0
    //   240: ifne +9 -> 249
    //   243: aload_1
    //   244: invokeinterface 229 1 0
    //   249: aload_0
    //   250: athrow
    //   251: astore_0
    //   252: ldc 2
    //   254: monitorexit
    //   255: aload_0
    //   256: athrow
    //   257: astore 4
    //   259: aload_0
    //   260: astore_1
    //   261: aload 4
    //   263: astore_0
    //   264: goto -34 -> 230
    //   267: astore_1
    //   268: goto -62 -> 206
    //   271: iconst_m1
    //   272: istore_2
    //   273: goto -249 -> 24
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_0
    //   279: goto -73 -> 206
    //   282: astore_0
    //   283: aload 5
    //   285: astore_1
    //   286: goto -56 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramContext	Context
    //   0	289	1	paramArrayOfInt	int[]
    //   1	272	2	i	int
    //   3	199	3	j	int
    //   46	45	4	str	java.lang.String
    //   257	5	4	localObject1	Object
    //   5	279	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	24	251	finally
    //   55	83	251	finally
    //   90	127	251	finally
    //   186	201	251	finally
    //   210	225	251	finally
    //   234	249	251	finally
    //   249	251	251	finally
    //   155	178	257	finally
    //   155	178	267	java/lang/Throwable
    //   127	155	276	java/lang/Throwable
    //   127	155	282	finally
  }
  
  /* Error */
  private static List<a> b(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +92 -> 96
    //   7: lload 5
    //   9: lconst_0
    //   10: lcmp
    //   11: ifle +12 -> 23
    //   14: ldc2_w 18
    //   17: lload 5
    //   19: lcmp
    //   20: ifgt +76 -> 96
    //   23: ldc 47
    //   25: astore 9
    //   27: aload 9
    //   29: astore 8
    //   31: aload_1
    //   32: ifnull +107 -> 139
    //   35: aload 9
    //   37: astore 8
    //   39: aload_1
    //   40: arraylength
    //   41: ifle +98 -> 139
    //   44: ldc 47
    //   46: astore 8
    //   48: iconst_0
    //   49: istore 7
    //   51: iload 7
    //   53: aload_1
    //   54: arraylength
    //   55: if_icmpge +58 -> 113
    //   58: new 49	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   65: aload 8
    //   67: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 56
    //   72: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: iload 7
    //   78: iaload
    //   79: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 8
    //   87: iload 7
    //   89: iconst_1
    //   90: iadd
    //   91: istore 7
    //   93: goto -42 -> 51
    //   96: ldc_w 307
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aconst_null
    //   107: astore_0
    //   108: ldc 2
    //   110: monitorexit
    //   111: aload_0
    //   112: areturn
    //   113: new 49	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   120: ldc 47
    //   122: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 8
    //   127: iconst_4
    //   128: invokevirtual 69	java/lang/String:substring	(I)Ljava/lang/String;
    //   131: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 8
    //   139: aload 8
    //   141: invokevirtual 308	java/lang/String:length	()I
    //   144: ifle +270 -> 414
    //   147: new 49	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 310
    //   154: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload 8
    //   159: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 312
    //   165: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 8
    //   173: aload 8
    //   175: astore_1
    //   176: ldc2_w 18
    //   179: lconst_0
    //   180: lcmp
    //   181: iflt +45 -> 226
    //   184: new 49	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   191: aload 8
    //   193: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: astore 9
    //   198: aload 8
    //   200: invokevirtual 308	java/lang/String:length	()I
    //   203: ifle +464 -> 667
    //   206: ldc_w 314
    //   209: astore_1
    //   210: aload 9
    //   212: aload_1
    //   213: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 316
    //   219: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: astore 8
    //   229: lload 5
    //   231: lconst_0
    //   232: lcmp
    //   233: iflt +379 -> 612
    //   236: new 49	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   243: aload_1
    //   244: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: astore 8
    //   249: aload_1
    //   250: invokevirtual 308	java/lang/String:length	()I
    //   253: ifle +420 -> 673
    //   256: ldc_w 314
    //   259: astore_1
    //   260: aload 8
    //   262: aload_1
    //   263: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 318
    //   269: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: lload 5
    //   274: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   277: ldc_w 320
    //   280: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore 8
    //   288: goto +324 -> 612
    //   291: aload_1
    //   292: astore 9
    //   294: aload_1
    //   295: ldc_w 322
    //   298: invokevirtual 326	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   301: ifeq +16 -> 317
    //   304: aload_1
    //   305: iconst_0
    //   306: aload_1
    //   307: invokevirtual 308	java/lang/String:length	()I
    //   310: iconst_3
    //   311: isub
    //   312: invokevirtual 329	java/lang/String:substring	(II)Ljava/lang/String;
    //   315: astore 9
    //   317: aconst_null
    //   318: astore_1
    //   319: aload_0
    //   320: invokestatic 80	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   323: invokevirtual 84	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   326: astore 10
    //   328: iload 4
    //   330: iflt +188 -> 518
    //   333: iload 4
    //   335: invokestatic 331	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   338: astore_0
    //   339: aload 10
    //   341: ldc 86
    //   343: aconst_null
    //   344: aload 8
    //   346: aconst_null
    //   347: aconst_null
    //   348: aconst_null
    //   349: aload 9
    //   351: aload_0
    //   352: invokevirtual 183	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   355: astore_0
    //   356: aload_0
    //   357: astore_1
    //   358: aload_1
    //   359: astore_0
    //   360: aload_1
    //   361: invokeinterface 334 1 0
    //   366: ifle +240 -> 606
    //   369: aload_1
    //   370: astore_0
    //   371: aload_1
    //   372: invokestatic 336	com/tencent/beacon/a/a/a/a:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   375: astore 8
    //   377: aload 8
    //   379: astore_0
    //   380: aload_1
    //   381: ifnull -273 -> 108
    //   384: aload 8
    //   386: astore_0
    //   387: aload_1
    //   388: invokeinterface 226 1 0
    //   393: ifne -285 -> 108
    //   396: aload_1
    //   397: invokeinterface 229 1 0
    //   402: aload 8
    //   404: astore_0
    //   405: goto -297 -> 108
    //   408: astore_0
    //   409: ldc 2
    //   411: monitorexit
    //   412: aload_0
    //   413: athrow
    //   414: ldc 47
    //   416: astore 8
    //   418: goto -245 -> 173
    //   421: new 49	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   428: ldc 47
    //   430: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 338
    //   436: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: astore_1
    //   443: goto +197 -> 640
    //   446: new 49	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   453: ldc 47
    //   455: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc_w 340
    //   461: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: astore_1
    //   468: goto +172 -> 640
    //   471: new 49	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   478: aload_1
    //   479: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc_w 342
    //   485: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: astore_1
    //   492: goto -201 -> 291
    //   495: new 49	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   502: aload_1
    //   503: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc 177
    //   508: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: astore_1
    //   515: goto -224 -> 291
    //   518: aconst_null
    //   519: astore_0
    //   520: goto -181 -> 339
    //   523: astore 8
    //   525: aconst_null
    //   526: astore_1
    //   527: aload_1
    //   528: astore_0
    //   529: aload 8
    //   531: invokevirtual 133	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   534: iconst_0
    //   535: anewarray 4	java/lang/Object
    //   538: invokestatic 43	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: aload_1
    //   542: ifnull +59 -> 601
    //   545: aload_1
    //   546: invokeinterface 226 1 0
    //   551: ifne +50 -> 601
    //   554: aload_1
    //   555: invokeinterface 229 1 0
    //   560: aconst_null
    //   561: astore_0
    //   562: goto -454 -> 108
    //   565: aload_1
    //   566: ifnull +18 -> 584
    //   569: aload_1
    //   570: invokeinterface 226 1 0
    //   575: ifne +9 -> 584
    //   578: aload_1
    //   579: invokeinterface 229 1 0
    //   584: aload_0
    //   585: athrow
    //   586: astore 8
    //   588: aload_0
    //   589: astore_1
    //   590: aload 8
    //   592: astore_0
    //   593: goto -28 -> 565
    //   596: astore 8
    //   598: goto -71 -> 527
    //   601: aconst_null
    //   602: astore_0
    //   603: goto -495 -> 108
    //   606: aconst_null
    //   607: astore 8
    //   609: goto -232 -> 377
    //   612: ldc 47
    //   614: astore_1
    //   615: iload_2
    //   616: tableswitch	default:+24 -> 640, 1:+-195->421, 2:+-170->446
    //   641: tableswitch	default:+23 -> 664, 1:+-170->471, 2:+-146->495
    //   665: impdep1
    //   666: f2i
    //   667: ldc 47
    //   669: astore_1
    //   670: goto -460 -> 210
    //   673: ldc 47
    //   675: astore_1
    //   676: goto -416 -> 260
    //   679: astore_0
    //   680: goto -115 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	paramContext	Context
    //   0	683	1	paramArrayOfInt	int[]
    //   0	683	2	paramInt1	int
    //   0	683	3	paramInt2	int
    //   0	683	4	paramInt3	int
    //   0	683	5	paramLong	long
    //   49	43	7	i	int
    //   29	388	8	localObject1	Object
    //   523	7	8	localThrowable1	Throwable
    //   586	5	8	localObject2	Object
    //   596	1	8	localThrowable2	Throwable
    //   607	1	8	localObject3	Object
    //   25	325	9	localObject4	Object
    //   326	14	10	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   39	44	408	finally
    //   51	87	408	finally
    //   96	106	408	finally
    //   113	139	408	finally
    //   139	173	408	finally
    //   184	206	408	finally
    //   210	226	408	finally
    //   236	256	408	finally
    //   260	288	408	finally
    //   294	317	408	finally
    //   387	402	408	finally
    //   421	443	408	finally
    //   446	468	408	finally
    //   471	492	408	finally
    //   495	515	408	finally
    //   545	560	408	finally
    //   569	584	408	finally
    //   584	586	408	finally
    //   319	328	523	java/lang/Throwable
    //   333	339	523	java/lang/Throwable
    //   339	356	523	java/lang/Throwable
    //   360	369	586	finally
    //   371	377	586	finally
    //   529	541	586	finally
    //   360	369	596	java/lang/Throwable
    //   371	377	596	java/lang/Throwable
    //   319	328	679	finally
    //   333	339	679	finally
    //   339	356	679	finally
  }
  
  public static boolean b(Context paramContext, List<a> paramList)
  {
    if (paramContext != null) {}
    label143:
    for (;;)
    {
      try
      {
        if (paramList.size() <= 0)
        {
          com.tencent.beacon.a.g.a.d("[db] context == null || list == null|| list.size() <= 0 ? pls check!", new Object[0]);
          bool1 = false;
          return bool1;
        }
        boolean bool3 = true;
        boolean bool1 = true;
        boolean bool2 = bool3;
        try
        {
          paramContext = c.a(paramContext).getWritableDatabase();
          bool2 = bool3;
          paramList = paramList.iterator();
          bool2 = bool1;
          if (!paramList.hasNext()) {
            break label143;
          }
          bool2 = bool1;
          a locala = (a)paramList.next();
          bool2 = bool1;
          long l = paramContext.replace("t_event", "_id", a(locala));
          if (l > 0L)
          {
            bool2 = bool1;
            locala.a = l;
            continue;
          }
        }
        catch (Throwable paramContext)
        {
          paramContext = paramContext;
          bool1 = bool2;
          com.tencent.beacon.a.g.a.a(paramContext);
          continue;
        }
        finally {}
        bool1 = false;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */