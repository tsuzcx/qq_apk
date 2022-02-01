package com.tencent.beacon.core.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.e.d;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public static int a(Context paramContext, String paramString, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    int j = -1;
    int i = 0;
    if (paramContext == null) {}
    String str;
    for (;;)
    {
      try
      {
        d.b("[db] delete context is null arg", new Object[0]);
        i = j;
        return i;
      }
      finally {}
      if (paramLong1 > paramLong2)
      {
        i = 0;
      }
      else
      {
        str = "_time >= " + paramLong1 + " and " + "_time" + " <= " + paramLong2;
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          j = paramArrayOfInt.length;
          while (i < j)
          {
            int k = paramArrayOfInt[i];
            localStringBuilder.append(" or _type = ").append(k);
            i += 1;
          }
          paramArrayOfInt = new StringBuilder(localStringBuilder.substring(4));
        }
      }
    }
    for (paramArrayOfInt = str + " and ( " + paramArrayOfInt.toString() + " )";; paramArrayOfInt = str) {
      for (;;)
      {
        d.a("[db] delete where: " + paramArrayOfInt, new Object[0]);
        try
        {
          paramString = e.a(paramContext, paramString).getWritableDatabase();
          i = paramString.delete("t_event", paramArrayOfInt, null);
          paramString = new StringBuilder();
          d.a("[db] deleted num: " + i, new Object[0]);
          d.a("[db] delete end", new Object[0]);
          break;
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            paramContext = i.a(paramContext);
            paramContext.a("503", "[db] TB: t_event delete fail!", paramString);
            d.a(paramString.getMessage(), new Object[0]);
            d.a("[db] delete end", new Object[0]);
            i = -1;
          }
        }
        finally
        {
          d.a("[db] delete end", new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, Long[] paramArrayOfLong)
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
    //   16: ldc 101
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   62: astore_1
    //   63: iload 5
    //   65: istore_3
    //   66: new 103	java/lang/StringBuffer
    //   69: dup
    //   70: invokespecial 104	java/lang/StringBuffer:<init>	()V
    //   73: astore 10
    //   75: iconst_0
    //   76: istore 5
    //   78: iload 4
    //   80: istore_3
    //   81: iload 5
    //   83: aload_2
    //   84: arraylength
    //   85: if_icmpge +187 -> 272
    //   88: iload 4
    //   90: istore_3
    //   91: aload_2
    //   92: iload 5
    //   94: aaload
    //   95: invokevirtual 110	java/lang/Long:longValue	()J
    //   98: lstore 8
    //   100: iload 4
    //   102: istore_3
    //   103: new 18	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   110: astore 11
    //   112: iload 4
    //   114: istore_3
    //   115: aload 10
    //   117: aload 11
    //   119: ldc 112
    //   121: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: lload 8
    //   126: invokevirtual 31	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 115	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: iload 4
    //   138: istore_3
    //   139: iload 5
    //   141: ifle +314 -> 455
    //   144: iload 4
    //   146: istore_3
    //   147: iload 5
    //   149: bipush 25
    //   151: irem
    //   152: ifne +303 -> 455
    //   155: iload 4
    //   157: istore_3
    //   158: new 18	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   165: astore 11
    //   167: iload 4
    //   169: istore_3
    //   170: aload 11
    //   172: ldc 117
    //   174: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload 5
    //   179: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: iload 4
    //   194: istore_3
    //   195: aload 10
    //   197: iconst_4
    //   198: invokevirtual 118	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   201: astore 11
    //   203: iload 4
    //   205: istore_3
    //   206: iload 4
    //   208: aload_1
    //   209: ldc 72
    //   211: aload 11
    //   213: aconst_null
    //   214: invokevirtual 78	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   217: iadd
    //   218: istore 4
    //   220: iload 4
    //   222: istore_3
    //   223: aload 10
    //   225: iconst_0
    //   226: invokevirtual 122	java/lang/StringBuffer:setLength	(I)V
    //   229: iload 4
    //   231: istore_3
    //   232: new 18	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   239: astore 11
    //   241: iload 4
    //   243: istore_3
    //   244: aload 11
    //   246: ldc 124
    //   248: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload 4
    //   253: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: iload 4
    //   268: istore_3
    //   269: goto +186 -> 455
    //   272: iload 4
    //   274: istore 5
    //   276: iload 4
    //   278: istore_3
    //   279: aload 10
    //   281: invokevirtual 128	java/lang/StringBuffer:length	()I
    //   284: ifle +41 -> 325
    //   287: iload 4
    //   289: istore_3
    //   290: aload 10
    //   292: iconst_4
    //   293: invokevirtual 118	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   296: astore_2
    //   297: iload 4
    //   299: istore_3
    //   300: aload_1
    //   301: ldc 72
    //   303: aload_2
    //   304: aconst_null
    //   305: invokevirtual 78	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   308: istore 5
    //   310: iload 5
    //   312: iload 4
    //   314: iadd
    //   315: istore_3
    //   316: aload 10
    //   318: iconst_0
    //   319: invokevirtual 122	java/lang/StringBuffer:setLength	(I)V
    //   322: iload_3
    //   323: istore 5
    //   325: iload 5
    //   327: istore_3
    //   328: new 18	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   335: astore_1
    //   336: iload 5
    //   338: istore_3
    //   339: aload_1
    //   340: ldc 130
    //   342: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload 5
    //   347: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: iconst_0
    //   354: anewarray 4	java/lang/Object
    //   357: invokestatic 133	com/tencent/beacon/core/e/d:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: ldc 135
    //   362: iconst_0
    //   363: anewarray 4	java/lang/Object
    //   366: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: iload 5
    //   371: istore_3
    //   372: goto -345 -> 27
    //   375: astore_0
    //   376: ldc 2
    //   378: monitorexit
    //   379: aload_0
    //   380: athrow
    //   381: astore_1
    //   382: aload_0
    //   383: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   386: astore_0
    //   387: aload_0
    //   388: ldc 89
    //   390: ldc 137
    //   392: aload_1
    //   393: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   396: new 18	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   403: astore_0
    //   404: aload_0
    //   405: ldc 139
    //   407: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_1
    //   411: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   414: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: iconst_0
    //   421: anewarray 4	java/lang/Object
    //   424: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   427: ldc 135
    //   429: iconst_0
    //   430: anewarray 4	java/lang/Object
    //   433: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: goto -409 -> 27
    //   439: astore_0
    //   440: ldc 135
    //   442: iconst_0
    //   443: anewarray 4	java/lang/Object
    //   446: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: aload_0
    //   450: athrow
    //   451: astore_1
    //   452: goto -70 -> 382
    //   455: iload 5
    //   457: iconst_1
    //   458: iadd
    //   459: istore 5
    //   461: iload_3
    //   462: istore 4
    //   464: goto -386 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramContext	Context
    //   0	467	1	paramString	String
    //   0	467	2	paramArrayOfLong	Long[]
    //   26	436	3	i	int
    //   1	462	4	j	int
    //   4	456	5	k	int
    //   7	37	6	m	int
    //   41	6	7	n	int
    //   98	27	8	l	long
    //   73	244	10	localStringBuffer	java.lang.StringBuffer
    //   110	135	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	25	375	finally
    //   39	43	375	finally
    //   360	369	375	finally
    //   427	436	375	finally
    //   440	451	375	finally
    //   54	63	381	java/lang/Throwable
    //   66	75	381	java/lang/Throwable
    //   81	88	381	java/lang/Throwable
    //   91	100	381	java/lang/Throwable
    //   103	112	381	java/lang/Throwable
    //   115	136	381	java/lang/Throwable
    //   158	167	381	java/lang/Throwable
    //   170	192	381	java/lang/Throwable
    //   195	203	381	java/lang/Throwable
    //   206	220	381	java/lang/Throwable
    //   223	229	381	java/lang/Throwable
    //   232	241	381	java/lang/Throwable
    //   244	266	381	java/lang/Throwable
    //   279	287	381	java/lang/Throwable
    //   290	297	381	java/lang/Throwable
    //   300	310	381	java/lang/Throwable
    //   328	336	381	java/lang/Throwable
    //   339	360	381	java/lang/Throwable
    //   54	63	439	finally
    //   66	75	439	finally
    //   81	88	439	finally
    //   91	100	439	finally
    //   103	112	439	finally
    //   115	136	439	finally
    //   158	167	439	finally
    //   170	192	439	finally
    //   195	203	439	finally
    //   206	220	439	finally
    //   223	229	439	finally
    //   232	241	439	finally
    //   244	266	439	finally
    //   279	287	439	finally
    //   290	297	439	finally
    //   300	310	439	finally
    //   316	322	439	finally
    //   328	336	439	finally
    //   339	360	439	finally
    //   382	387	439	finally
    //   387	404	439	finally
    //   404	427	439	finally
    //   316	322	451	java/lang/Throwable
  }
  
  public static ContentValues a(a parama)
  {
    ContentValues localContentValues = new ContentValues();
    long l = parama.a;
    if (l > 0L) {
      localContentValues.put("_id", Long.valueOf(l));
    }
    localContentValues.put("_prority", Integer.valueOf(parama.c));
    localContentValues.put("_time", Long.valueOf(parama.d));
    localContentValues.put("_type", Integer.valueOf(parama.b));
    localContentValues.put("_datas", parama.e);
    localContentValues.put("_length", Long.valueOf(parama.f));
    return localContentValues;
  }
  
  /* Error */
  public static List a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnonnull +19 -> 28
    //   12: ldc 197
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aconst_null
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload 4
    //   30: astore_3
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   36: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore_1
    //   40: aload 4
    //   42: astore_3
    //   43: aload_1
    //   44: ldc 199
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: ldc 201
    //   53: ldc 203
    //   55: invokevirtual 207	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 213 1 0
    //   65: ifeq +288 -> 353
    //   68: new 215	java/util/ArrayList
    //   71: dup
    //   72: invokespecial 216	java/util/ArrayList:<init>	()V
    //   75: astore_2
    //   76: aload_2
    //   77: aload_1
    //   78: aload_1
    //   79: ldc 150
    //   81: invokeinterface 220 2 0
    //   86: invokeinterface 224 2 0
    //   91: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: invokeinterface 230 2 0
    //   99: pop
    //   100: aload_2
    //   101: aload_1
    //   102: aload_1
    //   103: ldc 232
    //   105: invokeinterface 220 2 0
    //   110: invokeinterface 235 2 0
    //   115: invokeinterface 230 2 0
    //   120: pop
    //   121: aload_2
    //   122: aload_1
    //   123: aload_1
    //   124: ldc 35
    //   126: invokeinterface 220 2 0
    //   131: invokeinterface 239 2 0
    //   136: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: invokeinterface 230 2 0
    //   144: pop
    //   145: aload_2
    //   146: aload_1
    //   147: aload_1
    //   148: ldc 180
    //   150: invokeinterface 220 2 0
    //   155: invokeinterface 243 2 0
    //   160: invokeinterface 230 2 0
    //   165: pop
    //   166: aload_2
    //   167: aload_1
    //   168: aload_1
    //   169: ldc 245
    //   171: invokeinterface 220 2 0
    //   176: invokeinterface 224 2 0
    //   181: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokeinterface 230 2 0
    //   189: pop
    //   190: ldc 247
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokestatic 133	com/tencent/beacon/core/e/d:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aload_2
    //   200: astore_0
    //   201: aload_1
    //   202: ifnull +18 -> 220
    //   205: aload_1
    //   206: invokeinterface 250 1 0
    //   211: ifne +9 -> 220
    //   214: aload_1
    //   215: invokeinterface 253 1 0
    //   220: ldc 255
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: goto -206 -> 23
    //   232: astore_0
    //   233: ldc 2
    //   235: monitorexit
    //   236: aload_0
    //   237: athrow
    //   238: astore 4
    //   240: aload_2
    //   241: astore_3
    //   242: aload_1
    //   243: astore_2
    //   244: aload_3
    //   245: astore_1
    //   246: aload_2
    //   247: astore_3
    //   248: aload_0
    //   249: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   252: astore_0
    //   253: aload_2
    //   254: astore_3
    //   255: aload_0
    //   256: ldc 89
    //   258: ldc_w 257
    //   261: aload 4
    //   263: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload_2
    //   267: ifnull +18 -> 285
    //   270: aload_2
    //   271: invokeinterface 250 1 0
    //   276: ifne +9 -> 285
    //   279: aload_2
    //   280: invokeinterface 253 1 0
    //   285: ldc 255
    //   287: iconst_0
    //   288: anewarray 4	java/lang/Object
    //   291: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: aload_1
    //   295: astore_0
    //   296: goto -273 -> 23
    //   299: aload_1
    //   300: ifnull +18 -> 318
    //   303: aload_1
    //   304: invokeinterface 250 1 0
    //   309: ifne +9 -> 318
    //   312: aload_1
    //   313: invokeinterface 253 1 0
    //   318: ldc 255
    //   320: iconst_0
    //   321: anewarray 4	java/lang/Object
    //   324: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: aload_0
    //   328: athrow
    //   329: astore 4
    //   331: aconst_null
    //   332: astore_3
    //   333: aload_1
    //   334: astore_2
    //   335: aload_3
    //   336: astore_1
    //   337: goto -91 -> 246
    //   340: astore 4
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -98 -> 246
    //   347: astore_0
    //   348: aload_3
    //   349: astore_1
    //   350: goto -51 -> 299
    //   353: aconst_null
    //   354: astore_0
    //   355: goto -154 -> 201
    //   358: astore_0
    //   359: goto -60 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	paramContext	Context
    //   0	362	1	paramString	String
    //   4	331	2	localObject1	Object
    //   30	319	3	localObject2	Object
    //   1	40	4	localObject3	Object
    //   238	24	4	localException1	java.lang.Exception
    //   329	1	4	localException2	java.lang.Exception
    //   340	1	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	21	232	finally
    //   205	220	232	finally
    //   220	229	232	finally
    //   270	285	232	finally
    //   285	294	232	finally
    //   303	318	232	finally
    //   318	329	232	finally
    //   76	100	238	java/lang/Exception
    //   100	121	238	java/lang/Exception
    //   121	145	238	java/lang/Exception
    //   145	166	238	java/lang/Exception
    //   166	190	238	java/lang/Exception
    //   190	199	238	java/lang/Exception
    //   59	76	329	java/lang/Exception
    //   31	40	340	java/lang/Exception
    //   43	59	340	java/lang/Exception
    //   31	40	347	finally
    //   43	59	347	finally
    //   248	253	347	finally
    //   255	266	347	finally
    //   59	76	358	finally
    //   76	100	358	finally
    //   100	121	358	finally
    //   121	145	358	finally
    //   145	166	358	finally
    //   166	190	358	finally
    //   190	199	358	finally
  }
  
  public static List<a> a(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramContext = a(paramContext, paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3, -1, -1, -1, -1, -1L, -1L);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static List<a> a(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2)
  {
    try
    {
      paramContext = a(paramContext, paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong1, paramLong2, -1);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static List<a> a(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, int paramInt8)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +46 -> 50
    //   7: lload 12
    //   9: lconst_0
    //   10: lcmp
    //   11: istore 14
    //   13: iload 14
    //   15: ifle +11 -> 26
    //   18: lload 10
    //   20: lload 12
    //   22: lcmp
    //   23: ifgt +27 -> 50
    //   26: iload 7
    //   28: ifle +10 -> 38
    //   31: iload 6
    //   33: iload 7
    //   35: if_icmpgt +15 -> 50
    //   38: iload 9
    //   40: ifle +27 -> 67
    //   43: iload 8
    //   45: iload 9
    //   47: if_icmple +20 -> 67
    //   50: ldc_w 271
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aconst_null
    //   61: astore_2
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_2
    //   66: areturn
    //   67: ldc_w 273
    //   70: astore 16
    //   72: aload 16
    //   74: astore 15
    //   76: aload_2
    //   77: ifnull +90 -> 167
    //   80: aload 16
    //   82: astore 15
    //   84: aload_2
    //   85: arraylength
    //   86: ifle +81 -> 167
    //   89: new 18	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   96: astore 15
    //   98: aload_2
    //   99: arraylength
    //   100: istore 7
    //   102: iconst_0
    //   103: istore 6
    //   105: iload 6
    //   107: iload 7
    //   109: if_icmpge +31 -> 140
    //   112: aload_2
    //   113: iload 6
    //   115: iaload
    //   116: istore 8
    //   118: aload 15
    //   120: ldc 43
    //   122: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload 8
    //   127: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: iload 6
    //   133: iconst_1
    //   134: iadd
    //   135: istore 6
    //   137: goto -32 -> 105
    //   140: new 18	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 273
    //   150: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 15
    //   155: iconst_4
    //   156: invokevirtual 50	java/lang/StringBuilder:substring	(I)Ljava/lang/String;
    //   159: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 15
    //   167: aload 15
    //   169: invokevirtual 276	java/lang/String:length	()I
    //   172: ifle +387 -> 559
    //   175: new 18	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 278
    //   185: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 15
    //   190: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 280
    //   196: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: astore 15
    //   204: aload 15
    //   206: astore_2
    //   207: lload 10
    //   209: lconst_0
    //   210: lcmp
    //   211: iflt +60 -> 271
    //   214: new 18	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   221: aload 15
    //   223: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: astore 16
    //   228: aload 15
    //   230: invokevirtual 276	java/lang/String:length	()I
    //   233: ifle +591 -> 824
    //   236: ldc 33
    //   238: astore_2
    //   239: aload 16
    //   241: aload_2
    //   242: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc 35
    //   247: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 282
    //   253: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: lload 10
    //   258: invokevirtual 31	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: ldc_w 284
    //   264: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore_2
    //   271: aload_2
    //   272: astore 15
    //   274: iload 14
    //   276: iflt +519 -> 795
    //   279: new 18	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   286: aload_2
    //   287: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: astore 15
    //   292: aload_2
    //   293: invokevirtual 276	java/lang/String:length	()I
    //   296: ifle +535 -> 831
    //   299: ldc 33
    //   301: astore_2
    //   302: aload 15
    //   304: aload_2
    //   305: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 35
    //   310: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 37
    //   315: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: lload 12
    //   320: invokevirtual 31	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   323: ldc_w 284
    //   326: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: astore 15
    //   334: goto +461 -> 795
    //   337: aload_2
    //   338: astore 16
    //   340: aload_2
    //   341: ldc_w 286
    //   344: invokevirtual 290	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   347: ifeq +16 -> 363
    //   350: aload_2
    //   351: iconst_0
    //   352: aload_2
    //   353: invokevirtual 276	java/lang/String:length	()I
    //   356: iconst_3
    //   357: isub
    //   358: invokevirtual 293	java/lang/String:substring	(II)Ljava/lang/String;
    //   361: astore 16
    //   363: ldc_w 295
    //   366: iconst_1
    //   367: anewarray 4	java/lang/Object
    //   370: dup
    //   371: iconst_0
    //   372: aload 15
    //   374: aastore
    //   375: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: aload_0
    //   379: aload_1
    //   380: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   383: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   386: astore_2
    //   387: iload 5
    //   389: iflt +277 -> 666
    //   392: new 18	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   399: astore_1
    //   400: aload_1
    //   401: ldc_w 273
    //   404: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: iload 5
    //   409: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: astore_1
    //   416: aload_2
    //   417: ldc 72
    //   419: aconst_null
    //   420: aload 15
    //   422: aconst_null
    //   423: aconst_null
    //   424: aconst_null
    //   425: aload 16
    //   427: aload_1
    //   428: invokevirtual 207	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   431: astore_1
    //   432: new 18	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   439: astore_2
    //   440: aload_2
    //   441: ldc_w 297
    //   444: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_1
    //   448: invokeinterface 300 1 0
    //   453: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload_1
    //   467: invokeinterface 300 1 0
    //   472: iconst_1
    //   473: if_icmplt +198 -> 671
    //   476: aload_1
    //   477: invokestatic 303	com/tencent/beacon/core/a/a/b:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   480: astore_2
    //   481: aload_2
    //   482: ifnull +39 -> 521
    //   485: new 18	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   492: astore 15
    //   494: aload 15
    //   496: ldc_w 305
    //   499: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_2
    //   503: invokeinterface 308 1 0
    //   508: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: iconst_0
    //   515: anewarray 4	java/lang/Object
    //   518: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: aload_1
    //   522: ifnull +18 -> 540
    //   525: aload_1
    //   526: invokeinterface 250 1 0
    //   531: ifne +9 -> 540
    //   534: aload_1
    //   535: invokeinterface 253 1 0
    //   540: ldc_w 310
    //   543: iconst_0
    //   544: anewarray 4	java/lang/Object
    //   547: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: goto -488 -> 62
    //   553: astore_0
    //   554: ldc 2
    //   556: monitorexit
    //   557: aload_0
    //   558: athrow
    //   559: ldc_w 273
    //   562: astore 15
    //   564: goto -360 -> 204
    //   567: new 18	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   574: ldc_w 273
    //   577: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc_w 312
    //   583: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: astore_2
    //   590: goto +219 -> 809
    //   593: new 18	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 273
    //   603: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: ldc_w 314
    //   609: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: astore_2
    //   616: goto +193 -> 809
    //   619: new 18	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   626: aload_2
    //   627: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: ldc 201
    //   632: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: astore_2
    //   639: goto -302 -> 337
    //   642: new 18	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   649: aload_2
    //   650: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: ldc_w 316
    //   656: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: astore_2
    //   663: goto -326 -> 337
    //   666: aconst_null
    //   667: astore_1
    //   668: goto -252 -> 416
    //   671: aconst_null
    //   672: astore_2
    //   673: goto -192 -> 481
    //   676: astore 15
    //   678: aload_0
    //   679: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   682: astore_0
    //   683: aload_0
    //   684: ldc 89
    //   686: ldc_w 318
    //   689: aload 15
    //   691: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   694: aload 15
    //   696: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   699: iconst_0
    //   700: anewarray 4	java/lang/Object
    //   703: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   706: aload_1
    //   707: ifnull +18 -> 725
    //   710: aload_1
    //   711: invokeinterface 250 1 0
    //   716: ifne +9 -> 725
    //   719: aload_1
    //   720: invokeinterface 253 1 0
    //   725: ldc_w 310
    //   728: iconst_0
    //   729: anewarray 4	java/lang/Object
    //   732: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   735: goto -673 -> 62
    //   738: aload_1
    //   739: ifnull +18 -> 757
    //   742: aload_1
    //   743: invokeinterface 250 1 0
    //   748: ifne +9 -> 757
    //   751: aload_1
    //   752: invokeinterface 253 1 0
    //   757: ldc_w 310
    //   760: iconst_0
    //   761: anewarray 4	java/lang/Object
    //   764: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   767: aload_0
    //   768: athrow
    //   769: astore 15
    //   771: aconst_null
    //   772: astore_2
    //   773: goto -95 -> 678
    //   776: astore 15
    //   778: aconst_null
    //   779: astore_1
    //   780: aconst_null
    //   781: astore_2
    //   782: goto -104 -> 678
    //   785: astore_0
    //   786: aconst_null
    //   787: astore_1
    //   788: goto -50 -> 738
    //   791: astore_0
    //   792: goto -54 -> 738
    //   795: ldc_w 273
    //   798: astore_2
    //   799: iload_3
    //   800: iconst_1
    //   801: if_icmpeq -208 -> 593
    //   804: iload_3
    //   805: iconst_2
    //   806: if_icmpeq -239 -> 567
    //   809: iload 4
    //   811: iconst_1
    //   812: if_icmpeq -170 -> 642
    //   815: iload 4
    //   817: iconst_2
    //   818: if_icmpeq -199 -> 619
    //   821: goto -484 -> 337
    //   824: ldc_w 273
    //   827: astore_2
    //   828: goto -589 -> 239
    //   831: ldc_w 273
    //   834: astore_2
    //   835: goto -533 -> 302
    //   838: astore_0
    //   839: goto -101 -> 738
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	paramContext	Context
    //   0	842	1	paramString	String
    //   0	842	2	paramArrayOfInt	int[]
    //   0	842	3	paramInt1	int
    //   0	842	4	paramInt2	int
    //   0	842	5	paramInt3	int
    //   0	842	6	paramInt4	int
    //   0	842	7	paramInt5	int
    //   0	842	8	paramInt6	int
    //   0	842	9	paramInt7	int
    //   0	842	10	paramLong1	long
    //   0	842	12	paramLong2	long
    //   0	842	14	paramInt8	int
    //   74	489	15	localObject1	Object
    //   676	19	15	localThrowable1	Throwable
    //   769	1	15	localThrowable2	Throwable
    //   776	1	15	localThrowable3	Throwable
    //   70	356	16	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	60	553	finally
    //   84	102	553	finally
    //   118	131	553	finally
    //   140	167	553	finally
    //   167	204	553	finally
    //   214	236	553	finally
    //   239	271	553	finally
    //   279	299	553	finally
    //   302	334	553	finally
    //   340	363	553	finally
    //   363	378	553	finally
    //   525	540	553	finally
    //   540	550	553	finally
    //   567	590	553	finally
    //   593	616	553	finally
    //   619	639	553	finally
    //   642	663	553	finally
    //   710	725	553	finally
    //   725	735	553	finally
    //   742	757	553	finally
    //   757	769	553	finally
    //   485	494	676	java/lang/Throwable
    //   494	521	676	java/lang/Throwable
    //   432	440	769	java/lang/Throwable
    //   440	481	769	java/lang/Throwable
    //   378	387	776	java/lang/Throwable
    //   392	400	776	java/lang/Throwable
    //   400	416	776	java/lang/Throwable
    //   416	432	776	java/lang/Throwable
    //   378	387	785	finally
    //   392	400	785	finally
    //   400	416	785	finally
    //   416	432	785	finally
    //   678	683	791	finally
    //   683	706	791	finally
    //   432	440	838	finally
    //   440	481	838	finally
    //   485	494	838	finally
    //   494	521	838	finally
  }
  
  protected static List<a> a(Cursor paramCursor)
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
    d.a("[db] in parseCursor end", new Object[0]);
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
    //   10: ifnonnull +23 -> 33
    //   13: ldc_w 326
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: iload 5
    //   25: istore 4
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload 4
    //   32: ireturn
    //   33: iload 5
    //   35: istore 4
    //   37: aload_2
    //   38: ifnull -11 -> 27
    //   41: iload 5
    //   43: istore 4
    //   45: aload_2
    //   46: invokevirtual 329	java/lang/String:trim	()Ljava/lang/String;
    //   49: ldc_w 273
    //   52: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne -28 -> 27
    //   58: new 18	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 334
    //   68: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 336
    //   78: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_2
    //   85: new 18	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 338
    //   95: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_2
    //   99: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_0
    //   113: aload_1
    //   114: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   117: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   120: astore_1
    //   121: aload_1
    //   122: ldc 199
    //   124: aload_2
    //   125: aconst_null
    //   126: invokevirtual 78	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   129: istore_3
    //   130: new 18	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   137: astore_1
    //   138: aload_1
    //   139: ldc_w 340
    //   142: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload_3
    //   146: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: iload 6
    //   161: istore 4
    //   163: iload_3
    //   164: iconst_1
    //   165: if_icmpne +6 -> 171
    //   168: iconst_1
    //   169: istore 4
    //   171: ldc_w 342
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: goto -154 -> 27
    //   184: astore_0
    //   185: ldc 2
    //   187: monitorexit
    //   188: aload_0
    //   189: athrow
    //   190: astore_1
    //   191: aload_0
    //   192: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   195: astore_0
    //   196: aload_0
    //   197: ldc 89
    //   199: ldc_w 344
    //   202: aload_1
    //   203: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_1
    //   207: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: ldc_w 342
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: iload 5
    //   229: istore 4
    //   231: goto -204 -> 27
    //   234: astore_0
    //   235: ldc_w 342
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aload_0
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramContext	Context
    //   0	247	1	paramString1	String
    //   0	247	2	paramString2	String
    //   129	37	3	i	int
    //   25	205	4	bool1	boolean
    //   4	224	5	bool2	boolean
    //   1	159	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   13	23	184	finally
    //   45	112	184	finally
    //   171	181	184	finally
    //   217	227	184	finally
    //   235	247	184	finally
    //   112	121	190	java/lang/Throwable
    //   121	138	190	java/lang/Throwable
    //   138	159	190	java/lang/Throwable
    //   112	121	234	finally
    //   121	138	234	finally
    //   138	159	234	finally
    //   191	196	234	finally
    //   196	217	234	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, List<a> paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_2
    //   11: ifnonnull +22 -> 33
    //   14: ldc_w 347
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iconst_0
    //   25: istore 4
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload 4
    //   32: ireturn
    //   33: aload_2
    //   34: invokeinterface 308 1 0
    //   39: ifgt +22 -> 61
    //   42: ldc_w 349
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: goto -25 -> 27
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: aload_0
    //   62: aload_1
    //   63: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   66: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 352	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: aload_2
    //   78: invokeinterface 308 1 0
    //   83: if_icmpge +103 -> 186
    //   86: aload_2
    //   87: iload_3
    //   88: invokeinterface 356 2 0
    //   93: checkcast 145	com/tencent/beacon/core/a/a/a
    //   96: astore 7
    //   98: aload 7
    //   100: invokestatic 358	com/tencent/beacon/core/a/a/b:a	(Lcom/tencent/beacon/core/a/a/a;)Landroid/content/ContentValues;
    //   103: astore 8
    //   105: aload_1
    //   106: ldc 72
    //   108: ldc 150
    //   110: aload 8
    //   112: invokevirtual 362	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   115: lstore 5
    //   117: lload 5
    //   119: lconst_0
    //   120: lcmp
    //   121: ifge +51 -> 172
    //   124: aload_0
    //   125: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   128: astore 8
    //   130: new 18	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   137: astore 9
    //   139: aload 8
    //   141: ldc 89
    //   143: aload 9
    //   145: ldc_w 364
    //   148: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 5
    //   153: invokevirtual 31	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 367	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: ldc_w 369
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload 7
    //   174: lload 5
    //   176: putfield 148	com/tencent/beacon/core/a/a/a:a	J
    //   179: iload_3
    //   180: iconst_1
    //   181: iadd
    //   182: istore_3
    //   183: goto -107 -> 76
    //   186: aload_1
    //   187: invokevirtual 372	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   190: aload_1
    //   191: invokevirtual 375	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   194: ldc_w 377
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: ldc 72
    //   205: aastore
    //   206: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: iconst_1
    //   210: istore 4
    //   212: goto +159 -> 371
    //   215: astore_1
    //   216: aload_0
    //   217: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   220: ldc 89
    //   222: ldc_w 379
    //   225: aload_1
    //   226: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   229: ldc_w 381
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: goto -45 -> 194
    //   242: astore_2
    //   243: aload_1
    //   244: invokevirtual 375	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   247: ldc_w 377
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: ldc 72
    //   258: aastore
    //   259: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload_2
    //   263: athrow
    //   264: astore_2
    //   265: aload_0
    //   266: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   269: astore 7
    //   271: aload 7
    //   273: ldc 89
    //   275: ldc_w 383
    //   278: aload_2
    //   279: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   282: ldc_w 385
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: aload_1
    //   293: invokevirtual 375	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   296: ldc_w 377
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: ldc 72
    //   307: aastore
    //   308: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: iconst_0
    //   312: istore 4
    //   314: goto +57 -> 371
    //   317: astore_1
    //   318: aload_0
    //   319: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   322: ldc 89
    //   324: ldc_w 379
    //   327: aload_1
    //   328: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   331: ldc_w 381
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: goto -45 -> 296
    //   344: astore_1
    //   345: aload_0
    //   346: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   349: ldc 89
    //   351: ldc_w 379
    //   354: aload_1
    //   355: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   358: ldc_w 381
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: goto -121 -> 247
    //   371: goto -344 -> 27
    //   374: astore_2
    //   375: aconst_null
    //   376: astore_1
    //   377: goto -134 -> 243
    //   380: astore_2
    //   381: aconst_null
    //   382: astore_1
    //   383: goto -118 -> 265
    //   386: astore_2
    //   387: goto -144 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramContext	Context
    //   0	390	1	paramString	String
    //   0	390	2	paramList	List<a>
    //   75	108	3	i	int
    //   1	312	4	bool	boolean
    //   115	60	5	l	long
    //   96	176	7	localObject1	Object
    //   103	37	8	localObject2	Object
    //   137	7	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	24	55	finally
    //   33	52	55	finally
    //   190	194	55	finally
    //   194	209	55	finally
    //   216	239	55	finally
    //   243	247	55	finally
    //   247	264	55	finally
    //   292	296	55	finally
    //   296	311	55	finally
    //   318	341	55	finally
    //   345	368	55	finally
    //   190	194	215	java/lang/Exception
    //   70	74	242	finally
    //   76	105	242	finally
    //   105	117	242	finally
    //   124	130	242	finally
    //   130	139	242	finally
    //   139	162	242	finally
    //   162	172	242	finally
    //   172	179	242	finally
    //   186	190	242	finally
    //   70	74	264	java/lang/Throwable
    //   76	105	264	java/lang/Throwable
    //   105	117	264	java/lang/Throwable
    //   124	130	264	java/lang/Throwable
    //   130	139	264	java/lang/Throwable
    //   139	162	264	java/lang/Throwable
    //   162	172	264	java/lang/Throwable
    //   172	179	264	java/lang/Throwable
    //   186	190	264	java/lang/Throwable
    //   292	296	317	java/lang/Exception
    //   243	247	344	java/lang/Exception
    //   61	70	374	finally
    //   61	70	380	java/lang/Throwable
    //   265	271	386	finally
    //   271	282	386	finally
    //   282	292	386	finally
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
    //   21: ldc_w 389
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: iload 5
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   42: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore_1
    //   46: new 142	android/content/ContentValues
    //   49: dup
    //   50: invokespecial 143	android/content/ContentValues:<init>	()V
    //   53: astore 9
    //   55: aload 9
    //   57: ldc 232
    //   59: aload_3
    //   60: invokevirtual 391	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 9
    //   65: ldc 35
    //   67: new 393	java/util/Date
    //   70: dup
    //   71: invokespecial 394	java/util/Date:<init>	()V
    //   74: invokevirtual 397	java/util/Date:getTime	()J
    //   77: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   83: aload 9
    //   85: ldc 245
    //   87: iload 4
    //   89: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: invokevirtual 172	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   95: aload 9
    //   97: ldc 180
    //   99: aload_2
    //   100: invokevirtual 187	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   103: aload_1
    //   104: ldc 199
    //   106: aconst_null
    //   107: aload 9
    //   109: invokevirtual 362	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   112: lstore 7
    //   114: lload 7
    //   116: lconst_0
    //   117: lcmp
    //   118: ifge +70 -> 188
    //   121: aload_0
    //   122: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   125: astore_1
    //   126: new 18	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   133: astore_2
    //   134: aload_1
    //   135: ldc 89
    //   137: aload_2
    //   138: ldc_w 399
    //   141: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: lload 7
    //   146: invokevirtual 31	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokevirtual 367	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: ldc_w 401
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 16	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: iload 6
    //   167: istore 5
    //   169: ldc_w 403
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: goto -148 -> 31
    //   182: astore_0
    //   183: ldc 2
    //   185: monitorexit
    //   186: aload_0
    //   187: athrow
    //   188: iconst_1
    //   189: istore 5
    //   191: goto -22 -> 169
    //   194: astore_1
    //   195: aload_0
    //   196: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   199: astore_0
    //   200: aload_0
    //   201: ldc 89
    //   203: ldc_w 405
    //   206: aload_1
    //   207: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: ldc_w 407
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: ldc_w 403
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: goto -199 -> 31
    //   233: astore_0
    //   234: ldc_w 403
    //   237: iconst_0
    //   238: anewarray 4	java/lang/Object
    //   241: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_0
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   0	246	1	paramString1	String
    //   0	246	2	paramArrayOfByte	byte[]
    //   0	246	3	paramString2	String
    //   0	246	4	paramInt	int
    //   4	186	5	bool1	boolean
    //   1	165	6	bool2	boolean
    //   112	33	7	l	long
    //   53	55	9	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   21	31	182	finally
    //   169	179	182	finally
    //   220	230	182	finally
    //   234	246	182	finally
    //   37	55	194	java/lang/Throwable
    //   55	63	194	java/lang/Throwable
    //   63	83	194	java/lang/Throwable
    //   83	95	194	java/lang/Throwable
    //   95	103	194	java/lang/Throwable
    //   103	114	194	java/lang/Throwable
    //   121	126	194	java/lang/Throwable
    //   126	134	194	java/lang/Throwable
    //   134	155	194	java/lang/Throwable
    //   155	165	194	java/lang/Throwable
    //   37	55	233	finally
    //   55	63	233	finally
    //   63	83	233	finally
    //   83	95	233	finally
    //   95	103	233	finally
    //   103	114	233	finally
    //   121	126	233	finally
    //   126	134	233	finally
    //   134	155	233	finally
    //   155	165	233	finally
    //   195	200	233	finally
    //   200	210	233	finally
    //   210	220	233	finally
  }
  
  /* Error */
  public static int b(Context paramContext, String paramString, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +22 -> 26
    //   7: ldc_w 409
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 133	com/tencent/beacon/core/e/d:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: iconst_m1
    //   18: istore 7
    //   20: ldc 2
    //   22: monitorexit
    //   23: iload 7
    //   25: ireturn
    //   26: lload_3
    //   27: lload 5
    //   29: lcmp
    //   30: ifle +9 -> 39
    //   33: iconst_0
    //   34: istore 7
    //   36: goto -16 -> 20
    //   39: new 18	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   46: ldc 24
    //   48: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: lload_3
    //   52: invokevirtual 31	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   55: ldc 33
    //   57: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 35
    //   62: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 37
    //   67: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: lload 5
    //   72: invokevirtual 31	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 11
    //   80: aload 11
    //   82: astore 10
    //   84: aload_2
    //   85: ifnull +111 -> 196
    //   88: aload 11
    //   90: astore 10
    //   92: aload_2
    //   93: arraylength
    //   94: ifle +102 -> 196
    //   97: new 18	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   104: astore 10
    //   106: aload_2
    //   107: arraylength
    //   108: istore 8
    //   110: iconst_0
    //   111: istore 7
    //   113: iload 7
    //   115: iload 8
    //   117: if_icmpge +31 -> 148
    //   120: aload_2
    //   121: iload 7
    //   123: iaload
    //   124: istore 9
    //   126: aload 10
    //   128: ldc 43
    //   130: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload 9
    //   135: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: iload 7
    //   141: iconst_1
    //   142: iadd
    //   143: istore 7
    //   145: goto -32 -> 113
    //   148: new 18	java/lang/StringBuilder
    //   151: dup
    //   152: aload 10
    //   154: iconst_4
    //   155: invokevirtual 50	java/lang/StringBuilder:substring	(I)Ljava/lang/String;
    //   158: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: astore_2
    //   162: new 18	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   169: aload 11
    //   171: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 55
    //   176: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_2
    //   180: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc 57
    //   188: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore 10
    //   196: new 18	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 411
    //   206: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 10
    //   211: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload_0
    //   225: aload_1
    //   226: invokestatic 66	com/tencent/beacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/core/a/a/e;
    //   229: invokevirtual 70	com/tencent/beacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   232: astore_1
    //   233: aload_1
    //   234: ldc 72
    //   236: iconst_1
    //   237: anewarray 275	java/lang/String
    //   240: dup
    //   241: iconst_0
    //   242: ldc_w 413
    //   245: aastore
    //   246: aload 10
    //   248: aconst_null
    //   249: aconst_null
    //   250: aconst_null
    //   251: aconst_null
    //   252: invokevirtual 416	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   255: astore_1
    //   256: aload_1
    //   257: invokeinterface 213 1 0
    //   262: pop
    //   263: aload_1
    //   264: aload_1
    //   265: ldc_w 418
    //   268: invokeinterface 220 2 0
    //   273: invokeinterface 224 2 0
    //   278: istore 7
    //   280: new 18	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   287: astore_2
    //   288: aload_2
    //   289: ldc_w 420
    //   292: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 7
    //   297: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: iconst_0
    //   304: anewarray 4	java/lang/Object
    //   307: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: aload_1
    //   311: ifnull +18 -> 329
    //   314: aload_1
    //   315: invokeinterface 250 1 0
    //   320: ifne +9 -> 329
    //   323: aload_1
    //   324: invokeinterface 253 1 0
    //   329: ldc_w 422
    //   332: iconst_0
    //   333: anewarray 4	java/lang/Object
    //   336: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: goto -319 -> 20
    //   342: astore_0
    //   343: ldc 2
    //   345: monitorexit
    //   346: aload_0
    //   347: athrow
    //   348: astore_2
    //   349: aconst_null
    //   350: astore_1
    //   351: aload_0
    //   352: invokestatic 87	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   355: astore_0
    //   356: aload_0
    //   357: ldc 89
    //   359: ldc_w 424
    //   362: aload_2
    //   363: invokevirtual 94	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   366: aload_2
    //   367: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: iconst_m1
    //   378: istore 7
    //   380: aload_1
    //   381: ifnull +18 -> 399
    //   384: aload_1
    //   385: invokeinterface 250 1 0
    //   390: ifne +9 -> 399
    //   393: aload_1
    //   394: invokeinterface 253 1 0
    //   399: ldc_w 422
    //   402: iconst_0
    //   403: anewarray 4	java/lang/Object
    //   406: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   409: goto -389 -> 20
    //   412: aload_1
    //   413: ifnull +18 -> 431
    //   416: aload_1
    //   417: invokeinterface 250 1 0
    //   422: ifne +9 -> 431
    //   425: aload_1
    //   426: invokeinterface 253 1 0
    //   431: ldc_w 422
    //   434: iconst_0
    //   435: anewarray 4	java/lang/Object
    //   438: invokestatic 61	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: aload_0
    //   442: athrow
    //   443: astore_0
    //   444: goto -32 -> 412
    //   447: astore_2
    //   448: goto -97 -> 351
    //   451: astore_0
    //   452: goto -40 -> 412
    //   455: astore_0
    //   456: aconst_null
    //   457: astore_1
    //   458: goto -46 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramContext	Context
    //   0	461	1	paramString	String
    //   0	461	2	paramArrayOfInt	int[]
    //   0	461	3	paramLong1	long
    //   0	461	5	paramLong2	long
    //   18	361	7	i	int
    //   108	10	8	j	int
    //   124	10	9	k	int
    //   82	165	10	localObject	Object
    //   78	92	11	str	String
    // Exception table:
    //   from	to	target	type
    //   7	17	342	finally
    //   39	80	342	finally
    //   92	110	342	finally
    //   126	139	342	finally
    //   148	196	342	finally
    //   196	224	342	finally
    //   314	329	342	finally
    //   329	339	342	finally
    //   384	399	342	finally
    //   399	409	342	finally
    //   416	431	342	finally
    //   431	443	342	finally
    //   224	233	348	java/lang/Throwable
    //   233	256	348	java/lang/Throwable
    //   351	356	443	finally
    //   356	377	443	finally
    //   256	263	447	java/lang/Throwable
    //   263	288	447	java/lang/Throwable
    //   288	310	447	java/lang/Throwable
    //   256	263	451	finally
    //   263	288	451	finally
    //   288	310	451	finally
    //   224	233	455	finally
    //   233	256	455	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.a.b
 * JD-Core Version:    0.7.0.1
 */