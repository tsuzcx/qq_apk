package com.tencent.beacon.core.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public static int a(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    int i = -1;
    int j = 0;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.beacon.core.d.b.d("[db] delete context is null arg", new Object[0]);
        return i;
      }
      finally {}
      if (-1L > 9223372036854775807L)
      {
        i = 0;
      }
      else if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        String str = "";
        i = j;
        while (i < paramArrayOfInt.length)
        {
          str = str + " or _type = " + paramArrayOfInt[i];
          i += 1;
        }
        paramArrayOfInt = str.substring(4);
      }
    }
    for (paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807" + " and ( " + paramArrayOfInt + " )";; paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807") {
      for (;;)
      {
        com.tencent.beacon.core.d.b.b("[db] delete where: " + paramArrayOfInt, new Object[0]);
        try
        {
          i = e.a(paramContext, paramString).getWritableDatabase().delete("t_event", paramArrayOfInt, null);
          com.tencent.beacon.core.d.b.b("[db] deleted num: " + i, new Object[0]);
          com.tencent.beacon.core.d.b.b("[db] delete end", new Object[0]);
          break;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            com.tencent.beacon.core.d.b.b(paramContext.getMessage(), new Object[0]);
            com.tencent.beacon.core.d.b.b("[db] delete end", new Object[0]);
            i = -1;
          }
        }
        finally
        {
          com.tencent.beacon.core.d.b.b("[db] delete end", new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, java.lang.Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: ldc 2
    //   11: monitorenter
    //   12: aload_0
    //   13: ifnonnull +19 -> 32
    //   16: ldc 89
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: iconst_m1
    //   26: istore_3
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: iload 6
    //   34: istore_3
    //   35: aload_2
    //   36: ifnull -9 -> 27
    //   39: aload_2
    //   40: arraylength
    //   41: istore 7
    //   43: iload 6
    //   45: istore_3
    //   46: iload 7
    //   48: ifle -21 -> 27
    //   51: iload 5
    //   53: istore_3
    //   54: aload_0
    //   55: aload_1
    //   56: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   59: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: astore_0
    //   63: iload 5
    //   65: istore_3
    //   66: new 91	java/lang/StringBuffer
    //   69: dup
    //   70: invokespecial 92	java/lang/StringBuffer:<init>	()V
    //   73: astore_1
    //   74: iconst_0
    //   75: istore 5
    //   77: iload 4
    //   79: istore_3
    //   80: iload 5
    //   82: aload_2
    //   83: arraylength
    //   84: if_icmpge +147 -> 231
    //   87: iload 4
    //   89: istore_3
    //   90: aload_2
    //   91: iload 5
    //   93: aaload
    //   94: invokevirtual 98	java/lang/Long:longValue	()J
    //   97: lstore 8
    //   99: iload 4
    //   101: istore_3
    //   102: aload_1
    //   103: new 24	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 100
    //   109: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: lload 8
    //   114: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   117: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 106	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: iload 4
    //   126: istore_3
    //   127: iload 5
    //   129: ifle +250 -> 379
    //   132: iload 4
    //   134: istore_3
    //   135: iload 5
    //   137: bipush 25
    //   139: irem
    //   140: ifne +239 -> 379
    //   143: iload 4
    //   145: istore_3
    //   146: new 24	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 108
    //   152: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: iload 5
    //   157: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: iload 4
    //   172: istore_3
    //   173: iload 4
    //   175: aload_0
    //   176: ldc 72
    //   178: aload_1
    //   179: iconst_4
    //   180: invokevirtual 109	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   183: aconst_null
    //   184: invokevirtual 78	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   187: iadd
    //   188: istore 4
    //   190: iload 4
    //   192: istore_3
    //   193: aload_1
    //   194: iconst_0
    //   195: invokevirtual 113	java/lang/StringBuffer:setLength	(I)V
    //   198: iload 4
    //   200: istore_3
    //   201: new 24	java/lang/StringBuilder
    //   204: dup
    //   205: ldc 115
    //   207: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: iload 4
    //   212: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: iload 4
    //   227: istore_3
    //   228: goto +151 -> 379
    //   231: iload 4
    //   233: istore 5
    //   235: iload 4
    //   237: istore_3
    //   238: aload_1
    //   239: invokevirtual 119	java/lang/StringBuffer:length	()I
    //   242: ifle +34 -> 276
    //   245: iload 4
    //   247: istore_3
    //   248: aload_0
    //   249: ldc 72
    //   251: aload_1
    //   252: iconst_4
    //   253: invokevirtual 109	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   256: aconst_null
    //   257: invokevirtual 78	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   260: istore 5
    //   262: iload 5
    //   264: iload 4
    //   266: iadd
    //   267: istore_3
    //   268: aload_1
    //   269: iconst_0
    //   270: invokevirtual 113	java/lang/StringBuffer:setLength	(I)V
    //   273: iload_3
    //   274: istore 5
    //   276: iload 5
    //   278: istore_3
    //   279: new 24	java/lang/StringBuilder
    //   282: dup
    //   283: ldc 121
    //   285: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: iload 5
    //   290: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: iconst_0
    //   297: anewarray 4	java/lang/Object
    //   300: invokestatic 123	com/tencent/beacon/core/d/b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: ldc 125
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: iload 5
    //   314: istore_3
    //   315: goto -288 -> 27
    //   318: astore_0
    //   319: ldc 2
    //   321: monitorexit
    //   322: aload_0
    //   323: athrow
    //   324: astore_0
    //   325: new 24	java/lang/StringBuilder
    //   328: dup
    //   329: ldc 127
    //   331: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload_0
    //   335: invokevirtual 85	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   338: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: ldc 125
    //   353: iconst_0
    //   354: anewarray 4	java/lang/Object
    //   357: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: goto -333 -> 27
    //   363: astore_0
    //   364: ldc 125
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: aload_0
    //   374: athrow
    //   375: astore_0
    //   376: goto -51 -> 325
    //   379: iload 5
    //   381: iconst_1
    //   382: iadd
    //   383: istore 5
    //   385: iload_3
    //   386: istore 4
    //   388: goto -311 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramContext	Context
    //   0	391	1	paramString	String
    //   0	391	2	paramArrayOfLong	java.lang.Long[]
    //   26	360	3	i	int
    //   1	386	4	j	int
    //   4	380	5	k	int
    //   7	37	6	m	int
    //   41	6	7	n	int
    //   97	16	8	l	long
    // Exception table:
    //   from	to	target	type
    //   16	25	318	finally
    //   39	43	318	finally
    //   303	312	318	finally
    //   351	360	318	finally
    //   364	375	318	finally
    //   54	63	324	java/lang/Throwable
    //   66	74	324	java/lang/Throwable
    //   80	87	324	java/lang/Throwable
    //   90	99	324	java/lang/Throwable
    //   102	124	324	java/lang/Throwable
    //   146	170	324	java/lang/Throwable
    //   173	190	324	java/lang/Throwable
    //   193	198	324	java/lang/Throwable
    //   201	225	324	java/lang/Throwable
    //   238	245	324	java/lang/Throwable
    //   248	262	324	java/lang/Throwable
    //   279	303	324	java/lang/Throwable
    //   54	63	363	finally
    //   66	74	363	finally
    //   80	87	363	finally
    //   90	99	363	finally
    //   102	124	363	finally
    //   146	170	363	finally
    //   173	190	363	finally
    //   193	198	363	finally
    //   201	225	363	finally
    //   238	245	363	finally
    //   248	262	363	finally
    //   268	273	363	finally
    //   279	303	363	finally
    //   325	351	363	finally
    //   268	273	375	java/lang/Throwable
  }
  
  /* Error */
  public static List a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull +19 -> 25
    //   9: ldc 132
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aconst_null
    //   19: astore_0
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: aload_1
    //   27: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   30: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: ldc 134
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: ldc 136
    //   42: ldc 138
    //   44: invokevirtual 142	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 148 1 0
    //   54: ifeq +263 -> 317
    //   57: new 150	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 151	java/util/ArrayList:<init>	()V
    //   64: astore_1
    //   65: aload_1
    //   66: aload_0
    //   67: aload_0
    //   68: ldc 153
    //   70: invokeinterface 157 2 0
    //   75: invokeinterface 161 2 0
    //   80: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokeinterface 173 2 0
    //   88: pop
    //   89: aload_1
    //   90: aload_0
    //   91: aload_0
    //   92: ldc 175
    //   94: invokeinterface 157 2 0
    //   99: invokeinterface 178 2 0
    //   104: invokeinterface 173 2 0
    //   109: pop
    //   110: aload_1
    //   111: aload_0
    //   112: aload_0
    //   113: ldc 180
    //   115: invokeinterface 157 2 0
    //   120: invokeinterface 184 2 0
    //   125: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: invokeinterface 173 2 0
    //   133: pop
    //   134: aload_1
    //   135: aload_0
    //   136: aload_0
    //   137: ldc 189
    //   139: invokeinterface 157 2 0
    //   144: invokeinterface 193 2 0
    //   149: invokeinterface 173 2 0
    //   154: pop
    //   155: aload_1
    //   156: aload_0
    //   157: aload_0
    //   158: ldc 195
    //   160: invokeinterface 157 2 0
    //   165: invokeinterface 161 2 0
    //   170: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: invokeinterface 173 2 0
    //   178: pop
    //   179: ldc 197
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 123	com/tencent/beacon/core/d/b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_0
    //   189: ifnull +18 -> 207
    //   192: aload_0
    //   193: invokeinterface 200 1 0
    //   198: ifne +9 -> 207
    //   201: aload_0
    //   202: invokeinterface 203 1 0
    //   207: ldc 205
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_1
    //   217: astore_0
    //   218: goto -198 -> 20
    //   221: astore_0
    //   222: ldc 2
    //   224: monitorexit
    //   225: aload_0
    //   226: athrow
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_0
    //   230: aload_2
    //   231: astore_1
    //   232: aload_1
    //   233: ifnull +18 -> 251
    //   236: aload_1
    //   237: invokeinterface 200 1 0
    //   242: ifne +9 -> 251
    //   245: aload_1
    //   246: invokeinterface 203 1 0
    //   251: ldc 205
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: goto -240 -> 20
    //   263: aload_0
    //   264: ifnull +18 -> 282
    //   267: aload_0
    //   268: invokeinterface 200 1 0
    //   273: ifne +9 -> 282
    //   276: aload_0
    //   277: invokeinterface 203 1 0
    //   282: ldc 205
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: aload_1
    //   292: athrow
    //   293: astore_1
    //   294: goto -31 -> 263
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_2
    //   300: aload_0
    //   301: astore_1
    //   302: aload_2
    //   303: astore_0
    //   304: goto -72 -> 232
    //   307: astore_2
    //   308: aload_0
    //   309: astore_2
    //   310: aload_1
    //   311: astore_0
    //   312: aload_2
    //   313: astore_1
    //   314: goto -82 -> 232
    //   317: aconst_null
    //   318: astore_1
    //   319: goto -131 -> 188
    //   322: astore_1
    //   323: aconst_null
    //   324: astore_0
    //   325: goto -62 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	Context
    //   0	328	1	paramString	String
    //   1	302	2	localObject	Object
    //   307	1	2	localException	java.lang.Exception
    //   309	4	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   9	18	221	finally
    //   192	207	221	finally
    //   207	216	221	finally
    //   236	251	221	finally
    //   251	260	221	finally
    //   267	282	221	finally
    //   282	293	221	finally
    //   25	48	227	java/lang/Exception
    //   48	65	293	finally
    //   65	188	293	finally
    //   48	65	297	java/lang/Exception
    //   65	188	307	java/lang/Exception
    //   25	48	322	finally
  }
  
  public static List<a> a(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramContext = b(paramContext, paramString, paramArrayOfInt, paramInt);
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
    if (paramCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("_id");
    int j = paramCursor.getColumnIndex("_prority");
    int k = paramCursor.getColumnIndex("_time");
    int m = paramCursor.getColumnIndex("_type");
    int n = paramCursor.getColumnIndex("_datas");
    int i1 = paramCursor.getColumnIndex("_length");
    while (paramCursor.moveToNext())
    {
      a locala = new a();
      locala.a = paramCursor.getLong(i);
      locala.e = paramCursor.getBlob(n);
      locala.c = paramCursor.getInt(j);
      locala.d = paramCursor.getLong(k);
      locala.b = paramCursor.getInt(m);
      locala.f = paramCursor.getLong(i1);
      localArrayList.add(locala);
    }
    com.tencent.beacon.core.d.b.b("[db] in parseCursor end", new Object[0]);
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: ifnonnull +22 -> 32
    //   13: ldc 244
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: iload 5
    //   24: istore 4
    //   26: ldc 2
    //   28: monitorexit
    //   29: iload 4
    //   31: ireturn
    //   32: iload 5
    //   34: istore 4
    //   36: aload_2
    //   37: ifnull -11 -> 26
    //   40: iload 5
    //   42: istore 4
    //   44: aload_2
    //   45: invokevirtual 247	java/lang/String:trim	()Ljava/lang/String;
    //   48: ldc 22
    //   50: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifne -27 -> 26
    //   56: new 24	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 252
    //   62: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 254
    //   71: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_2
    //   78: new 24	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 256
    //   85: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: aload_1
    //   104: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   107: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   110: ldc 134
    //   112: aload_2
    //   113: aconst_null
    //   114: invokevirtual 78	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: istore_3
    //   118: new 24	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 258
    //   125: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: iload_3
    //   129: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: iload 6
    //   144: istore 4
    //   146: iload_3
    //   147: iconst_1
    //   148: if_icmpne +6 -> 154
    //   151: iconst_1
    //   152: istore 4
    //   154: ldc_w 260
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -138 -> 26
    //   167: astore_0
    //   168: ldc 2
    //   170: monitorexit
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 85	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 260
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iload 5
    //   197: istore 4
    //   199: goto -173 -> 26
    //   202: astore_0
    //   203: ldc_w 260
    //   206: iconst_0
    //   207: anewarray 4	java/lang/Object
    //   210: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload_0
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramContext	Context
    //   0	215	1	paramString1	String
    //   0	215	2	paramString2	String
    //   117	32	3	i	int
    //   24	174	4	bool1	boolean
    //   4	192	5	bool2	boolean
    //   1	142	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   13	22	167	finally
    //   44	102	167	finally
    //   154	164	167	finally
    //   185	195	167	finally
    //   203	215	167	finally
    //   102	142	173	java/lang/Throwable
    //   102	142	202	finally
    //   174	185	202	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, List<a> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: ldc_w 263
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: ldc 2
    //   22: monitorexit
    //   23: iload 4
    //   25: ireturn
    //   26: aload_2
    //   27: invokeinterface 266 1 0
    //   32: ifgt +19 -> 51
    //   35: ldc_w 268
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: iconst_1
    //   46: istore 4
    //   48: goto -28 -> 20
    //   51: aconst_null
    //   52: astore 7
    //   54: aload_0
    //   55: aload_1
    //   56: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   59: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 271	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: aload_2
    //   71: invokeinterface 266 1 0
    //   76: if_icmpge +155 -> 231
    //   79: aload_2
    //   80: iload_3
    //   81: invokeinterface 275 2 0
    //   86: checkcast 219	com/tencent/beacon/core/a/a/a
    //   89: astore_1
    //   90: new 277	android/content/ContentValues
    //   93: dup
    //   94: invokespecial 278	android/content/ContentValues:<init>	()V
    //   97: astore 7
    //   99: aload_1
    //   100: getfield 223	com/tencent/beacon/core/a/a/a:a	J
    //   103: lconst_0
    //   104: lcmp
    //   105: ifle +17 -> 122
    //   108: aload 7
    //   110: ldc 153
    //   112: aload_1
    //   113: getfield 223	com/tencent/beacon/core/a/a/a:a	J
    //   116: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   119: invokevirtual 282	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   122: aload 7
    //   124: ldc 213
    //   126: aload_1
    //   127: getfield 231	com/tencent/beacon/core/a/a/a:c	I
    //   130: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: invokevirtual 285	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   136: aload 7
    //   138: ldc 180
    //   140: aload_1
    //   141: getfield 233	com/tencent/beacon/core/a/a/a:d	J
    //   144: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: invokevirtual 282	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   150: aload 7
    //   152: ldc 215
    //   154: aload_1
    //   155: getfield 235	com/tencent/beacon/core/a/a/a:b	I
    //   158: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: invokevirtual 285	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   164: aload 7
    //   166: ldc 189
    //   168: aload_1
    //   169: getfield 227	com/tencent/beacon/core/a/a/a:e	[B
    //   172: invokevirtual 288	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   175: aload 7
    //   177: ldc 217
    //   179: aload_1
    //   180: getfield 238	com/tencent/beacon/core/a/a/a:f	J
    //   183: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: invokevirtual 282	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   189: aload_0
    //   190: ldc 72
    //   192: ldc 153
    //   194: aload 7
    //   196: invokevirtual 292	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   199: lstore 5
    //   201: lload 5
    //   203: lconst_0
    //   204: lcmp
    //   205: ifge +13 -> 218
    //   208: ldc_w 294
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_1
    //   219: lload 5
    //   221: putfield 223	com/tencent/beacon/core/a/a/a:a	J
    //   224: iload_3
    //   225: iconst_1
    //   226: iadd
    //   227: istore_3
    //   228: goto -159 -> 69
    //   231: aload_0
    //   232: invokevirtual 297	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   235: aload_0
    //   236: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   239: ldc_w 302
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: ldc 72
    //   250: aastore
    //   251: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: iconst_1
    //   255: istore 4
    //   257: goto +126 -> 383
    //   260: astore_0
    //   261: ldc_w 304
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -32 -> 239
    //   274: astore_0
    //   275: ldc 2
    //   277: monitorexit
    //   278: aload_0
    //   279: athrow
    //   280: astore_0
    //   281: aload 7
    //   283: astore_0
    //   284: ldc_w 306
    //   287: iconst_0
    //   288: anewarray 4	java/lang/Object
    //   291: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: aload_0
    //   295: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   298: ldc_w 302
    //   301: iconst_1
    //   302: anewarray 4	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: ldc 72
    //   309: aastore
    //   310: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: iconst_0
    //   314: istore 4
    //   316: goto +67 -> 383
    //   319: astore_0
    //   320: ldc_w 304
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: goto -32 -> 298
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_0
    //   336: aload_0
    //   337: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   340: ldc_w 302
    //   343: iconst_1
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: ldc 72
    //   351: aastore
    //   352: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: aload_1
    //   356: athrow
    //   357: astore_0
    //   358: ldc_w 304
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: goto -28 -> 340
    //   371: astore_1
    //   372: goto -36 -> 336
    //   375: astore_1
    //   376: goto -40 -> 336
    //   379: astore_1
    //   380: goto -96 -> 284
    //   383: goto -363 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramContext	Context
    //   0	386	1	paramString	String
    //   0	386	2	paramList	List<a>
    //   68	160	3	i	int
    //   1	314	4	bool	boolean
    //   199	21	5	l	long
    //   52	230	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   235	239	260	java/lang/Exception
    //   10	20	274	finally
    //   26	45	274	finally
    //   235	239	274	finally
    //   239	254	274	finally
    //   261	271	274	finally
    //   294	298	274	finally
    //   298	313	274	finally
    //   320	330	274	finally
    //   336	340	274	finally
    //   340	357	274	finally
    //   358	368	274	finally
    //   54	63	280	java/lang/Throwable
    //   294	298	319	java/lang/Exception
    //   54	63	333	finally
    //   336	340	357	java/lang/Exception
    //   63	67	371	finally
    //   69	122	371	finally
    //   122	201	371	finally
    //   208	218	371	finally
    //   218	224	371	finally
    //   231	235	371	finally
    //   284	294	375	finally
    //   63	67	379	java/lang/Throwable
    //   69	122	379	java/lang/Throwable
    //   122	201	379	java/lang/Throwable
    //   208	218	379	java/lang/Throwable
    //   218	224	379	java/lang/Throwable
    //   231	235	379	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: aload_2
    //   14: ifnull +7 -> 21
    //   17: aload_3
    //   18: ifnonnull +19 -> 37
    //   21: ldc_w 310
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: iload 5
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   42: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore_0
    //   46: new 277	android/content/ContentValues
    //   49: dup
    //   50: invokespecial 278	android/content/ContentValues:<init>	()V
    //   53: astore_1
    //   54: aload_1
    //   55: ldc 175
    //   57: aload_3
    //   58: invokevirtual 313	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_1
    //   62: ldc 180
    //   64: new 315	java/util/Date
    //   67: dup
    //   68: invokespecial 316	java/util/Date:<init>	()V
    //   71: invokevirtual 319	java/util/Date:getTime	()J
    //   74: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 282	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   80: aload_1
    //   81: ldc 195
    //   83: iload 4
    //   85: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: invokevirtual 285	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   91: aload_1
    //   92: ldc 189
    //   94: aload_2
    //   95: invokevirtual 288	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   98: aload_0
    //   99: ldc 134
    //   101: aconst_null
    //   102: aload_1
    //   103: invokevirtual 292	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   106: lconst_0
    //   107: lcmp
    //   108: ifge +36 -> 144
    //   111: ldc_w 321
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: iload 6
    //   123: istore 5
    //   125: ldc_w 323
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: goto -104 -> 31
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    //   144: iconst_1
    //   145: istore 5
    //   147: goto -22 -> 125
    //   150: astore_0
    //   151: ldc_w 325
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: ldc_w 323
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -140 -> 31
    //   174: astore_0
    //   175: ldc_w 323
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: aload_0
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramContext	Context
    //   0	187	1	paramString1	String
    //   0	187	2	paramArrayOfByte	byte[]
    //   0	187	3	paramString2	String
    //   0	187	4	paramInt	int
    //   4	142	5	bool1	boolean
    //   1	121	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   21	31	138	finally
    //   125	135	138	finally
    //   161	171	138	finally
    //   175	187	138	finally
    //   37	121	150	java/lang/Throwable
    //   37	121	174	finally
    //   151	161	174	finally
  }
  
  /* Error */
  public static int b(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnonnull +18 -> 27
    //   12: ldc_w 327
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 123	com/tencent/beacon/core/d/b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: iload_3
    //   26: ireturn
    //   27: ldc2_w 17
    //   30: ldc2_w 19
    //   33: lcmp
    //   34: ifle +8 -> 42
    //   37: iconst_0
    //   38: istore_3
    //   39: goto -17 -> 22
    //   42: ldc 22
    //   44: astore 5
    //   46: iload 4
    //   48: istore_3
    //   49: iload_3
    //   50: iconst_4
    //   51: if_icmpge +38 -> 89
    //   54: new 24	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   61: aload 5
    //   63: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 34
    //   68: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: iload_3
    //   73: iaload
    //   74: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 5
    //   82: iload_3
    //   83: iconst_1
    //   84: iadd
    //   85: istore_3
    //   86: goto -37 -> 49
    //   89: aload 5
    //   91: iconst_4
    //   92: invokevirtual 47	java/lang/String:substring	(I)Ljava/lang/String;
    //   95: astore_2
    //   96: new 24	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   103: ldc 49
    //   105: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 51
    //   110: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_2
    //   114: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 53
    //   119: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_2
    //   126: new 24	java/lang/StringBuilder
    //   129: dup
    //   130: ldc_w 329
    //   133: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload_2
    //   137: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_0
    //   151: aload_1
    //   152: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   155: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   158: ldc 72
    //   160: iconst_1
    //   161: anewarray 43	java/lang/String
    //   164: dup
    //   165: iconst_0
    //   166: ldc_w 331
    //   169: aastore
    //   170: aload_2
    //   171: aconst_null
    //   172: aconst_null
    //   173: aconst_null
    //   174: aconst_null
    //   175: invokevirtual 334	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   178: astore_1
    //   179: aload_1
    //   180: astore_0
    //   181: aload_1
    //   182: invokeinterface 148 1 0
    //   187: pop
    //   188: aload_1
    //   189: astore_0
    //   190: aload_1
    //   191: aload_1
    //   192: ldc_w 336
    //   195: invokeinterface 157 2 0
    //   200: invokeinterface 161 2 0
    //   205: istore_3
    //   206: aload_1
    //   207: astore_0
    //   208: new 24	java/lang/StringBuilder
    //   211: dup
    //   212: ldc_w 338
    //   215: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: iload_3
    //   219: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_1
    //   233: ifnull +18 -> 251
    //   236: aload_1
    //   237: invokeinterface 200 1 0
    //   242: ifne +9 -> 251
    //   245: aload_1
    //   246: invokeinterface 203 1 0
    //   251: ldc_w 340
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: goto -239 -> 22
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_1
    //   268: astore_0
    //   269: aload_2
    //   270: invokevirtual 85	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: aload_1
    //   281: ifnull +18 -> 299
    //   284: aload_1
    //   285: invokeinterface 200 1 0
    //   290: ifne +9 -> 299
    //   293: aload_1
    //   294: invokeinterface 203 1 0
    //   299: ldc_w 340
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: iconst_m1
    //   310: istore_3
    //   311: goto -50 -> 261
    //   314: aload_0
    //   315: ifnull +18 -> 333
    //   318: aload_0
    //   319: invokeinterface 200 1 0
    //   324: ifne +9 -> 333
    //   327: aload_0
    //   328: invokeinterface 203 1 0
    //   333: ldc_w 340
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: aload_1
    //   344: athrow
    //   345: astore_0
    //   346: ldc 2
    //   348: monitorexit
    //   349: aload_0
    //   350: athrow
    //   351: astore_1
    //   352: goto -38 -> 314
    //   355: astore_2
    //   356: goto -89 -> 267
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_0
    //   362: goto -48 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramContext	Context
    //   0	365	1	paramString	String
    //   0	365	2	paramArrayOfInt	int[]
    //   1	310	3	i	int
    //   3	44	4	j	int
    //   44	46	5	str	String
    // Exception table:
    //   from	to	target	type
    //   150	179	264	java/lang/Throwable
    //   12	22	345	finally
    //   54	82	345	finally
    //   89	150	345	finally
    //   236	251	345	finally
    //   251	261	345	finally
    //   284	299	345	finally
    //   299	309	345	finally
    //   318	333	345	finally
    //   333	345	345	finally
    //   181	188	351	finally
    //   190	206	351	finally
    //   208	232	351	finally
    //   269	280	351	finally
    //   181	188	355	java/lang/Throwable
    //   190	206	355	java/lang/Throwable
    //   208	232	355	java/lang/Throwable
    //   150	179	359	finally
  }
  
  private static List<a> b(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramContext = c(paramContext, paramString, paramArrayOfInt, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private static List<a> c(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: ifnull +91 -> 101
    //   13: ldc2_w 17
    //   16: lconst_0
    //   17: lcmp
    //   18: ifle +13 -> 31
    //   21: ldc2_w 17
    //   24: ldc2_w 17
    //   27: lcmp
    //   28: ifgt +73 -> 101
    //   31: ldc 22
    //   33: astore 7
    //   35: aload 7
    //   37: astore 5
    //   39: aload_2
    //   40: ifnull +104 -> 144
    //   43: aload 7
    //   45: astore 5
    //   47: aload_2
    //   48: arraylength
    //   49: ifle +95 -> 144
    //   52: ldc 22
    //   54: astore 5
    //   56: iload 4
    //   58: aload_2
    //   59: arraylength
    //   60: if_icmpge +58 -> 118
    //   63: new 24	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   70: aload 5
    //   72: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 34
    //   77: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: iload 4
    //   83: iaload
    //   84: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 5
    //   92: iload 4
    //   94: iconst_1
    //   95: iadd
    //   96: istore 4
    //   98: goto -42 -> 56
    //   101: ldc_w 344
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aconst_null
    //   112: astore_0
    //   113: ldc 2
    //   115: monitorexit
    //   116: aload_0
    //   117: areturn
    //   118: new 24	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   125: ldc 22
    //   127: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 5
    //   132: iconst_4
    //   133: invokevirtual 47	java/lang/String:substring	(I)Ljava/lang/String;
    //   136: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore 5
    //   144: aload 5
    //   146: invokevirtual 345	java/lang/String:length	()I
    //   149: ifle +369 -> 518
    //   152: new 24	java/lang/StringBuilder
    //   155: dup
    //   156: ldc_w 347
    //   159: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: aload 5
    //   164: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 349
    //   170: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore 5
    //   178: aload 5
    //   180: astore_2
    //   181: ldc2_w 17
    //   184: lconst_0
    //   185: lcmp
    //   186: iflt +45 -> 231
    //   189: new 24	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   196: aload 5
    //   198: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: astore 7
    //   203: aload 5
    //   205: invokevirtual 345	java/lang/String:length	()I
    //   208: ifle +449 -> 657
    //   211: ldc_w 351
    //   214: astore_2
    //   215: aload 7
    //   217: aload_2
    //   218: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 353
    //   224: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: astore_2
    //   231: aload_2
    //   232: astore 5
    //   234: ldc2_w 17
    //   237: lconst_0
    //   238: lcmp
    //   239: iflt +44 -> 283
    //   242: new 24	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   249: aload_2
    //   250: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: astore 5
    //   255: aload_2
    //   256: invokevirtual 345	java/lang/String:length	()I
    //   259: ifle +266 -> 525
    //   262: ldc_w 351
    //   265: astore_2
    //   266: aload 5
    //   268: aload_2
    //   269: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 355
    //   275: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore 5
    //   283: new 24	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   290: ldc 22
    //   292: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 357
    //   298: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: astore_2
    //   305: new 24	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   312: aload_2
    //   313: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 136
    //   318: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore 7
    //   326: aload 7
    //   328: astore_2
    //   329: aload 7
    //   331: ldc_w 359
    //   334: invokevirtual 363	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   337: ifeq +17 -> 354
    //   340: aload 7
    //   342: iconst_0
    //   343: aload 7
    //   345: invokevirtual 345	java/lang/String:length	()I
    //   348: iconst_3
    //   349: isub
    //   350: invokevirtual 366	java/lang/String:substring	(II)Ljava/lang/String;
    //   353: astore_2
    //   354: ldc_w 368
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload 5
    //   365: aastore
    //   366: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_0
    //   370: aload_1
    //   371: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   374: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   377: astore_1
    //   378: iload_3
    //   379: iflt +152 -> 531
    //   382: iload_3
    //   383: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   386: astore_0
    //   387: aload_1
    //   388: ldc 72
    //   390: aconst_null
    //   391: aload 5
    //   393: aconst_null
    //   394: aconst_null
    //   395: aconst_null
    //   396: aload_2
    //   397: aload_0
    //   398: invokevirtual 142	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   401: astore_0
    //   402: new 24	java/lang/StringBuilder
    //   405: dup
    //   406: ldc_w 372
    //   409: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   412: aload_0
    //   413: invokeinterface 375 1 0
    //   418: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: iconst_0
    //   425: anewarray 4	java/lang/Object
    //   428: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload_0
    //   432: invokeinterface 375 1 0
    //   437: ifle +215 -> 652
    //   440: aload_0
    //   441: invokestatic 377	com/tencent/beacon/core/a/a/b:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   444: astore_1
    //   445: aload_1
    //   446: ifnull +32 -> 478
    //   449: new 24	java/lang/StringBuilder
    //   452: dup
    //   453: ldc_w 379
    //   456: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   459: aload_1
    //   460: invokeinterface 266 1 0
    //   465: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: iconst_0
    //   472: anewarray 4	java/lang/Object
    //   475: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: aload_0
    //   479: ifnull +18 -> 497
    //   482: aload_0
    //   483: invokeinterface 200 1 0
    //   488: ifne +9 -> 497
    //   491: aload_0
    //   492: invokeinterface 203 1 0
    //   497: ldc_w 381
    //   500: iconst_0
    //   501: anewarray 4	java/lang/Object
    //   504: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   507: aload_1
    //   508: astore_0
    //   509: goto -396 -> 113
    //   512: astore_0
    //   513: ldc 2
    //   515: monitorexit
    //   516: aload_0
    //   517: athrow
    //   518: ldc 22
    //   520: astore 5
    //   522: goto -344 -> 178
    //   525: ldc 22
    //   527: astore_2
    //   528: goto -262 -> 266
    //   531: aconst_null
    //   532: astore_0
    //   533: goto -146 -> 387
    //   536: astore_2
    //   537: aconst_null
    //   538: astore_0
    //   539: aload 6
    //   541: astore_1
    //   542: aload_2
    //   543: invokevirtual 85	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   546: iconst_0
    //   547: anewarray 4	java/lang/Object
    //   550: invokestatic 16	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   553: aload_1
    //   554: ifnull +18 -> 572
    //   557: aload_1
    //   558: invokeinterface 200 1 0
    //   563: ifne +9 -> 572
    //   566: aload_1
    //   567: invokeinterface 203 1 0
    //   572: ldc_w 381
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: goto -469 -> 113
    //   585: aload_0
    //   586: ifnull +18 -> 604
    //   589: aload_0
    //   590: invokeinterface 200 1 0
    //   595: ifne +9 -> 604
    //   598: aload_0
    //   599: invokeinterface 203 1 0
    //   604: ldc_w 381
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokestatic 61	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: aload_1
    //   615: athrow
    //   616: astore_1
    //   617: goto -32 -> 585
    //   620: astore_2
    //   621: aload_1
    //   622: astore_0
    //   623: aload_2
    //   624: astore_1
    //   625: goto -40 -> 585
    //   628: astore_2
    //   629: aconst_null
    //   630: astore 5
    //   632: aload_0
    //   633: astore_1
    //   634: aload 5
    //   636: astore_0
    //   637: goto -95 -> 542
    //   640: astore_2
    //   641: aload_0
    //   642: astore 5
    //   644: aload_1
    //   645: astore_0
    //   646: aload 5
    //   648: astore_1
    //   649: goto -107 -> 542
    //   652: aconst_null
    //   653: astore_1
    //   654: goto -209 -> 445
    //   657: ldc 22
    //   659: astore_2
    //   660: goto -445 -> 215
    //   663: astore_1
    //   664: aconst_null
    //   665: astore_0
    //   666: goto -81 -> 585
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	paramContext	Context
    //   0	669	1	paramString	String
    //   0	669	2	paramArrayOfInt	int[]
    //   0	669	3	paramInt	int
    //   4	93	4	i	int
    //   37	610	5	localObject1	Object
    //   1	539	6	localObject2	Object
    //   33	311	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	52	512	finally
    //   56	92	512	finally
    //   101	111	512	finally
    //   118	144	512	finally
    //   144	178	512	finally
    //   189	211	512	finally
    //   215	231	512	finally
    //   242	262	512	finally
    //   266	283	512	finally
    //   283	326	512	finally
    //   329	354	512	finally
    //   354	369	512	finally
    //   482	497	512	finally
    //   497	507	512	finally
    //   557	572	512	finally
    //   572	582	512	finally
    //   589	604	512	finally
    //   604	616	512	finally
    //   369	378	536	java/lang/Throwable
    //   382	387	536	java/lang/Throwable
    //   387	402	536	java/lang/Throwable
    //   402	445	616	finally
    //   449	478	616	finally
    //   542	553	620	finally
    //   402	445	628	java/lang/Throwable
    //   449	478	640	java/lang/Throwable
    //   369	378	663	finally
    //   382	387	663	finally
    //   387	402	663	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.a.b
 * JD-Core Version:    0.7.0.1
 */