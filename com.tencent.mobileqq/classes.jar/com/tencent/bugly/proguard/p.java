package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.a;
import java.util.List;
import java.util.Map;

public final class p
{
  public static boolean a = false;
  private static p b;
  private static q c;
  
  private p(Context paramContext, List<a> paramList)
  {
    c = new q(paramContext, paramList);
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 10
    //   5: aconst_null
    //   6: astore 11
    //   8: iconst_0
    //   9: istore 7
    //   11: iconst_0
    //   12: istore 8
    //   14: iconst_0
    //   15: istore 5
    //   17: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   20: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore 12
    //   25: aload 12
    //   27: ifnull +21 -> 48
    //   30: aload 12
    //   32: astore 11
    //   34: aload 12
    //   36: astore 10
    //   38: aload 12
    //   40: aload_1
    //   41: aload_2
    //   42: aload_3
    //   43: invokevirtual 42	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   46: istore 5
    //   48: aload 4
    //   50: ifnull +3 -> 53
    //   53: iload 5
    //   55: istore 6
    //   57: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   60: ifeq +87 -> 147
    //   63: iload 5
    //   65: istore 6
    //   67: aload 12
    //   69: ifnull +78 -> 147
    //   72: aload 12
    //   74: astore 10
    //   76: aload 10
    //   78: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   81: iload 5
    //   83: istore 6
    //   85: goto +62 -> 147
    //   88: astore_1
    //   89: goto +63 -> 152
    //   92: astore_1
    //   93: aload 10
    //   95: astore 11
    //   97: aload_1
    //   98: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   101: ifne +11 -> 112
    //   104: aload 10
    //   106: astore 11
    //   108: aload_1
    //   109: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   112: aload 4
    //   114: ifnull +3 -> 117
    //   117: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   120: istore 9
    //   122: iload 8
    //   124: istore 6
    //   126: iload 9
    //   128: ifeq +19 -> 147
    //   131: iload 8
    //   133: istore 6
    //   135: aload 10
    //   137: ifnull +10 -> 147
    //   140: iload 7
    //   142: istore 5
    //   144: goto -68 -> 76
    //   147: aload_0
    //   148: monitorexit
    //   149: iload 6
    //   151: ireturn
    //   152: aload 4
    //   154: ifnull +3 -> 157
    //   157: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   160: ifeq +13 -> 173
    //   163: aload 11
    //   165: ifnull +8 -> 173
    //   168: aload 11
    //   170: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: goto +5 -> 183
    //   181: aload_1
    //   182: athrow
    //   183: goto -2 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	p
    //   0	186	1	paramString1	String
    //   0	186	2	paramString2	String
    //   0	186	3	paramArrayOfString	String[]
    //   0	186	4	paramo	o
    //   15	128	5	i	int
    //   55	95	6	j	int
    //   9	132	7	k	int
    //   12	120	8	m	int
    //   120	7	9	bool	boolean
    //   3	133	10	localObject1	Object
    //   6	163	11	localObject2	Object
    //   23	50	12	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   17	25	88	finally
    //   38	48	88	finally
    //   97	104	88	finally
    //   108	112	88	finally
    //   17	25	92	java/lang/Throwable
    //   38	48	92	java/lang/Throwable
    //   57	63	175	finally
    //   76	81	175	finally
    //   117	122	175	finally
    //   157	163	175	finally
    //   168	173	175	finally
    //   173	175	175	finally
  }
  
  /* Error */
  private long a(String paramString, ContentValues paramContentValues, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 11
    //   5: aconst_null
    //   6: astore 12
    //   8: lconst_0
    //   9: lstore 6
    //   11: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   14: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 13
    //   19: lload 6
    //   21: lstore 4
    //   23: aload 13
    //   25: ifnull +84 -> 109
    //   28: lload 6
    //   30: lstore 4
    //   32: aload_2
    //   33: ifnull +76 -> 109
    //   36: aload 13
    //   38: astore 12
    //   40: aload 13
    //   42: astore 11
    //   44: aload 13
    //   46: aload_1
    //   47: ldc 61
    //   49: aload_2
    //   50: invokevirtual 65	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   53: lstore 4
    //   55: lload 4
    //   57: lconst_0
    //   58: lcmp
    //   59: iflt +28 -> 87
    //   62: aload 13
    //   64: astore 12
    //   66: aload 13
    //   68: astore 11
    //   70: ldc 67
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokestatic 70	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   83: pop
    //   84: goto +25 -> 109
    //   87: aload 13
    //   89: astore 12
    //   91: aload 13
    //   93: astore 11
    //   95: ldc 72
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: aastore
    //   105: invokestatic 75	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload_3
    //   110: ifnull +3 -> 113
    //   113: lload 4
    //   115: lstore 8
    //   117: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   120: ifeq +86 -> 206
    //   123: lload 4
    //   125: lstore 8
    //   127: aload 13
    //   129: ifnull +77 -> 206
    //   132: aload 13
    //   134: astore 11
    //   136: aload 11
    //   138: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   141: lload 4
    //   143: lstore 8
    //   145: goto +61 -> 206
    //   148: astore_1
    //   149: goto +62 -> 211
    //   152: astore_1
    //   153: aload 11
    //   155: astore 12
    //   157: aload_1
    //   158: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   161: ifne +11 -> 172
    //   164: aload 11
    //   166: astore 12
    //   168: aload_1
    //   169: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   172: aload_3
    //   173: ifnull +3 -> 176
    //   176: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   179: istore 10
    //   181: lload 6
    //   183: lstore 8
    //   185: iload 10
    //   187: ifeq +19 -> 206
    //   190: lload 6
    //   192: lstore 8
    //   194: aload 11
    //   196: ifnull +10 -> 206
    //   199: lload 6
    //   201: lstore 4
    //   203: goto -67 -> 136
    //   206: aload_0
    //   207: monitorexit
    //   208: lload 8
    //   210: lreturn
    //   211: aload_3
    //   212: ifnull +3 -> 215
    //   215: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   218: ifeq +13 -> 231
    //   221: aload 12
    //   223: ifnull +8 -> 231
    //   226: aload 12
    //   228: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   231: aload_1
    //   232: athrow
    //   233: astore_1
    //   234: aload_0
    //   235: monitorexit
    //   236: goto +5 -> 241
    //   239: aload_1
    //   240: athrow
    //   241: goto -2 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	p
    //   0	244	1	paramString	String
    //   0	244	2	paramContentValues	ContentValues
    //   0	244	3	paramo	o
    //   21	181	4	l1	long
    //   9	191	6	l2	long
    //   115	94	8	l3	long
    //   179	7	10	bool	boolean
    //   3	192	11	localObject1	Object
    //   6	221	12	localObject2	Object
    //   17	116	13	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   11	19	148	finally
    //   44	55	148	finally
    //   70	84	148	finally
    //   95	109	148	finally
    //   157	164	148	finally
    //   168	172	148	finally
    //   11	19	152	java/lang/Throwable
    //   44	55	152	java/lang/Throwable
    //   70	84	152	java/lang/Throwable
    //   95	109	152	java/lang/Throwable
    //   117	123	233	finally
    //   136	141	233	finally
    //   176	181	233	finally
    //   215	221	233	finally
    //   226	231	233	finally
    //   231	233	233	finally
  }
  
  /* Error */
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 11
    //   5: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   8: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 12
    //   13: aload 11
    //   15: astore 10
    //   17: aload 12
    //   19: ifnull +52 -> 71
    //   22: aload 12
    //   24: iload_1
    //   25: aload_2
    //   26: aload_3
    //   27: aload 4
    //   29: aload 5
    //   31: aload 6
    //   33: aload 7
    //   35: aload 8
    //   37: aload 9
    //   39: invokevirtual 83	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 10
    //   44: goto +27 -> 71
    //   47: astore_2
    //   48: goto +28 -> 76
    //   51: astore_2
    //   52: aload 11
    //   54: astore 10
    //   56: aload_2
    //   57: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   60: ifne +11 -> 71
    //   63: aload_2
    //   64: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   67: aload 11
    //   69: astore 10
    //   71: aload_0
    //   72: monitorexit
    //   73: aload 10
    //   75: areturn
    //   76: aload_2
    //   77: athrow
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	p
    //   0	83	1	paramBoolean	boolean
    //   0	83	2	paramString1	String
    //   0	83	3	paramArrayOfString1	String[]
    //   0	83	4	paramString2	String
    //   0	83	5	paramArrayOfString2	String[]
    //   0	83	6	paramString3	String
    //   0	83	7	paramString4	String
    //   0	83	8	paramString5	String
    //   0	83	9	paramString6	String
    //   0	83	10	paramo	o
    //   3	65	11	localObject	Object
    //   11	12	12	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   5	13	47	finally
    //   22	44	47	finally
    //   56	67	47	finally
    //   5	13	51	java/lang/Throwable
    //   22	44	51	java/lang/Throwable
    //   76	78	78	finally
  }
  
  public static p a()
  {
    try
    {
      p localp = b;
      return localp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static p a(Context paramContext, List<a> paramList)
  {
    try
    {
      if (b == null) {
        b = new p(paramContext, paramList);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private static r a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      r localr = new r();
      localr.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      localr.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
      localr.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
      localr.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
      localr.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      localr.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return localr;
    }
    catch (Throwable paramCursor)
    {
      if (!x.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  private Map<String, byte[]> a(int paramInt, o paramo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: iload_1
    //   6: invokespecial 147	com/tencent/bugly/proguard/p:c	(I)Ljava/util/List;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +100 -> 113
    //   16: new 149	java/util/HashMap
    //   19: dup
    //   20: invokespecial 150	java/util/HashMap:<init>	()V
    //   23: astore_3
    //   24: aload 4
    //   26: invokeinterface 156 1 0
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 162 1 0
    //   38: ifeq +43 -> 81
    //   41: aload_2
    //   42: invokeinterface 166 1 0
    //   47: checkcast 92	com/tencent/bugly/proguard/r
    //   50: astore 4
    //   52: aload 4
    //   54: getfield 143	com/tencent/bugly/proguard/r:g	[B
    //   57: astore 5
    //   59: aload 5
    //   61: ifnull -29 -> 32
    //   64: aload_3
    //   65: aload 4
    //   67: getfield 169	com/tencent/bugly/proguard/r:f	Ljava/lang/String;
    //   70: aload 5
    //   72: invokeinterface 175 3 0
    //   77: pop
    //   78: goto -46 -> 32
    //   81: aload_3
    //   82: areturn
    //   83: astore 4
    //   85: aload_3
    //   86: astore_2
    //   87: goto +9 -> 96
    //   90: astore_2
    //   91: goto +24 -> 115
    //   94: astore 4
    //   96: aload_2
    //   97: astore_3
    //   98: aload 4
    //   100: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   103: ifne +10 -> 113
    //   106: aload 4
    //   108: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   111: aload_2
    //   112: astore_3
    //   113: aload_3
    //   114: areturn
    //   115: goto +5 -> 120
    //   118: aload_2
    //   119: athrow
    //   120: goto -2 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	p
    //   0	123	1	paramInt	int
    //   0	123	2	paramo	o
    //   1	113	3	localObject1	Object
    //   9	57	4	localObject2	Object
    //   83	1	4	localThrowable1	Throwable
    //   94	13	4	localThrowable2	Throwable
    //   57	14	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	32	83	java/lang/Throwable
    //   32	59	83	java/lang/Throwable
    //   64	78	83	java/lang/Throwable
    //   4	11	90	finally
    //   16	24	90	finally
    //   24	32	90	finally
    //   32	59	90	finally
    //   64	78	90	finally
    //   98	111	90	finally
    //   4	11	94	java/lang/Throwable
    //   16	24	94	java/lang/Throwable
  }
  
  /* Error */
  private boolean a(int paramInt, String paramString, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 7
    //   8: iconst_0
    //   9: istore 6
    //   11: iconst_0
    //   12: istore 5
    //   14: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   17: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore 8
    //   22: iload 5
    //   24: istore 4
    //   26: aload 8
    //   28: ifnull +151 -> 179
    //   31: aload_2
    //   32: invokestatic 185	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   35: ifeq +27 -> 62
    //   38: new 187	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 189
    //   44: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: iload_1
    //   50: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_2
    //   59: goto +58 -> 117
    //   62: new 187	java/lang/StringBuilder
    //   65: dup
    //   66: ldc 189
    //   68: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: astore 7
    //   73: aload 7
    //   75: iload_1
    //   76: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 7
    //   82: ldc 202
    //   84: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 7
    //   90: ldc 207
    //   92: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 7
    //   98: aload_2
    //   99: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: ldc 209
    //   107: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 7
    //   113: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_2
    //   117: aload 8
    //   119: ldc 211
    //   121: aload_2
    //   122: aconst_null
    //   123: invokevirtual 42	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   126: istore_1
    //   127: ldc 213
    //   129: iconst_2
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: ldc 211
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: iload_1
    //   141: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: invokestatic 70	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   148: pop
    //   149: iload 5
    //   151: istore 4
    //   153: iload_1
    //   154: ifle +25 -> 179
    //   157: iconst_1
    //   158: istore 4
    //   160: goto +19 -> 179
    //   163: astore_2
    //   164: goto +117 -> 281
    //   167: astore 7
    //   169: aload 8
    //   171: astore_2
    //   172: aload 7
    //   174: astore 8
    //   176: goto +51 -> 227
    //   179: aload_3
    //   180: ifnull +3 -> 183
    //   183: iload 4
    //   185: istore 5
    //   187: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   190: ifeq +86 -> 276
    //   193: iload 4
    //   195: istore 5
    //   197: aload 8
    //   199: ifnull +77 -> 276
    //   202: aload 8
    //   204: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   207: iload 4
    //   209: istore 5
    //   211: goto +65 -> 276
    //   214: astore_2
    //   215: aload 7
    //   217: astore 8
    //   219: goto +62 -> 281
    //   222: astore 8
    //   224: aload 9
    //   226: astore_2
    //   227: aload_2
    //   228: astore 7
    //   230: aload 8
    //   232: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   235: ifne +11 -> 246
    //   238: aload_2
    //   239: astore 7
    //   241: aload 8
    //   243: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   246: aload_3
    //   247: ifnull +3 -> 250
    //   250: iload 6
    //   252: istore 5
    //   254: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   257: ifeq +19 -> 276
    //   260: iload 6
    //   262: istore 5
    //   264: aload_2
    //   265: ifnull +11 -> 276
    //   268: aload_2
    //   269: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   272: iload 6
    //   274: istore 5
    //   276: aload_0
    //   277: monitorexit
    //   278: iload 5
    //   280: ireturn
    //   281: aload_3
    //   282: ifnull +3 -> 285
    //   285: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   288: ifeq +13 -> 301
    //   291: aload 8
    //   293: ifnull +8 -> 301
    //   296: aload 8
    //   298: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   301: aload_2
    //   302: athrow
    //   303: astore_2
    //   304: aload_0
    //   305: monitorexit
    //   306: aload_2
    //   307: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	p
    //   0	308	1	paramInt	int
    //   0	308	2	paramString	String
    //   0	308	3	paramo	o
    //   24	184	4	bool1	boolean
    //   12	267	5	bool2	boolean
    //   9	264	6	bool3	boolean
    //   6	106	7	localStringBuilder	java.lang.StringBuilder
    //   167	49	7	localThrowable1	Throwable
    //   228	12	7	str	String
    //   20	198	8	localObject1	Object
    //   222	75	8	localThrowable2	Throwable
    //   3	222	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	59	163	finally
    //   62	117	163	finally
    //   117	149	163	finally
    //   31	59	167	java/lang/Throwable
    //   62	117	167	java/lang/Throwable
    //   117	149	167	java/lang/Throwable
    //   14	22	214	finally
    //   230	238	214	finally
    //   241	246	214	finally
    //   14	22	222	java/lang/Throwable
    //   187	193	303	finally
    //   202	207	303	finally
    //   254	260	303	finally
    //   268	272	303	finally
    //   285	291	303	finally
    //   296	301	303	finally
    //   301	303	303	finally
  }
  
  /* Error */
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 7
    //   6: new 92	com/tencent/bugly/proguard/r
    //   9: dup
    //   10: invokespecial 93	com/tencent/bugly/proguard/r:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: iload_1
    //   18: i2l
    //   19: putfield 106	com/tencent/bugly/proguard/r:a	J
    //   22: aload 8
    //   24: aload_2
    //   25: putfield 169	com/tencent/bugly/proguard/r:f	Ljava/lang/String;
    //   28: aload 8
    //   30: invokestatic 226	java/lang/System:currentTimeMillis	()J
    //   33: putfield 133	com/tencent/bugly/proguard/r:e	J
    //   36: aload 8
    //   38: aload_3
    //   39: putfield 143	com/tencent/bugly/proguard/r:g	[B
    //   42: aload_0
    //   43: aload 8
    //   45: invokespecial 229	com/tencent/bugly/proguard/p:b	(Lcom/tencent/bugly/proguard/r;)Z
    //   48: istore 5
    //   50: iload 5
    //   52: istore 6
    //   54: aload 4
    //   56: ifnull +34 -> 90
    //   59: iload 5
    //   61: ireturn
    //   62: astore_2
    //   63: goto +30 -> 93
    //   66: astore_2
    //   67: aload_2
    //   68: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   71: ifne +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   78: aload 4
    //   80: ifnull +10 -> 90
    //   83: iload 7
    //   85: istore 5
    //   87: goto -28 -> 59
    //   90: iload 6
    //   92: ireturn
    //   93: aload 4
    //   95: ifnull +3 -> 98
    //   98: goto +5 -> 103
    //   101: aload_2
    //   102: athrow
    //   103: goto -2 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	p
    //   0	106	1	paramInt	int
    //   0	106	2	paramString	String
    //   0	106	3	paramArrayOfByte	byte[]
    //   0	106	4	paramo	o
    //   48	38	5	bool1	boolean
    //   1	90	6	bool2	boolean
    //   4	80	7	bool3	boolean
    //   13	31	8	localr	r
    // Exception table:
    //   from	to	target	type
    //   6	50	62	finally
    //   67	78	62	finally
    //   6	50	66	java/lang/Throwable
  }
  
  private static r b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      r localr = new r();
      localr.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      localr.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      localr.f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
      localr.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return localr;
    }
    catch (Throwable paramCursor)
    {
      if (!x.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  private boolean b(r paramr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 4
    //   16: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   19: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 6
    //   24: aload 6
    //   26: ifnull +124 -> 150
    //   29: aload 6
    //   31: astore 4
    //   33: aload 6
    //   35: astore 5
    //   37: aload_1
    //   38: invokestatic 238	com/tencent/bugly/proguard/p:d	(Lcom/tencent/bugly/proguard/r;)Landroid/content/ContentValues;
    //   41: astore 7
    //   43: aload 7
    //   45: ifnull +105 -> 150
    //   48: aload 6
    //   50: astore 4
    //   52: aload 6
    //   54: astore 5
    //   56: aload 6
    //   58: ldc 211
    //   60: ldc 61
    //   62: aload 7
    //   64: invokevirtual 65	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   67: lstore_2
    //   68: lload_2
    //   69: lconst_0
    //   70: lcmp
    //   71: iflt +59 -> 130
    //   74: aload 6
    //   76: astore 4
    //   78: aload 6
    //   80: astore 5
    //   82: ldc 67
    //   84: iconst_1
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc 211
    //   92: aastore
    //   93: invokestatic 70	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload 6
    //   99: astore 4
    //   101: aload 6
    //   103: astore 5
    //   105: aload_1
    //   106: lload_2
    //   107: putfield 106	com/tencent/bugly/proguard/r:a	J
    //   110: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   113: ifeq +13 -> 126
    //   116: aload 6
    //   118: ifnull +8 -> 126
    //   121: aload 6
    //   123: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: iconst_1
    //   129: ireturn
    //   130: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   133: ifeq +13 -> 146
    //   136: aload 6
    //   138: ifnull +8 -> 146
    //   141: aload 6
    //   143: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   146: aload_0
    //   147: monitorexit
    //   148: iconst_0
    //   149: ireturn
    //   150: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   153: ifeq +13 -> 166
    //   156: aload 6
    //   158: ifnull +8 -> 166
    //   161: aload 6
    //   163: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   166: aload_0
    //   167: monitorexit
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: goto +43 -> 214
    //   174: astore_1
    //   175: aload 5
    //   177: astore 4
    //   179: aload_1
    //   180: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   183: ifne +11 -> 194
    //   186: aload 5
    //   188: astore 4
    //   190: aload_1
    //   191: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   194: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   197: ifeq +13 -> 210
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   210: aload_0
    //   211: monitorexit
    //   212: iconst_0
    //   213: ireturn
    //   214: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   217: ifeq +13 -> 230
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	p
    //   0	237	1	paramr	r
    //   67	40	2	l	long
    //   14	212	4	localObject1	Object
    //   11	195	5	localObject2	Object
    //   22	140	6	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   41	22	7	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   16	24	170	finally
    //   37	43	170	finally
    //   56	68	170	finally
    //   82	97	170	finally
    //   105	110	170	finally
    //   179	186	170	finally
    //   190	194	170	finally
    //   16	24	174	java/lang/Throwable
    //   37	43	174	java/lang/Throwable
    //   56	68	174	java/lang/Throwable
    //   82	97	174	java/lang/Throwable
    //   105	110	174	java/lang/Throwable
    //   110	116	232	finally
    //   121	126	232	finally
    //   130	136	232	finally
    //   141	146	232	finally
    //   150	156	232	finally
    //   161	166	232	finally
    //   194	200	232	finally
    //   205	210	232	finally
    //   214	220	232	finally
    //   225	230	232	finally
    //   230	232	232	finally
  }
  
  private static ContentValues c(r paramr)
  {
    if (paramr == null) {
      return null;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      if (paramr.a > 0L) {
        localContentValues.put("_id", Long.valueOf(paramr.a));
      }
      localContentValues.put("_tp", Integer.valueOf(paramr.b));
      localContentValues.put("_pc", paramr.c);
      localContentValues.put("_th", paramr.d);
      localContentValues.put("_tm", Long.valueOf(paramr.e));
      if (paramr.g != null) {
        localContentValues.put("_dt", paramr.g);
      }
      return localContentValues;
    }
    catch (Throwable paramr)
    {
      if (!x.a(paramr)) {
        paramr.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  private List<r> c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +417 -> 427
    //   13: new 187	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 189
    //   19: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: aload 4
    //   26: iload_1
    //   27: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 7
    //   38: aload_3
    //   39: ldc 211
    //   41: aconst_null
    //   42: aload 7
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 261	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnonnull +33 -> 88
    //   58: aload 4
    //   60: ifnull +10 -> 70
    //   63: aload 4
    //   65: invokeinterface 262 1 0
    //   70: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   73: ifeq +11 -> 84
    //   76: aload_3
    //   77: ifnull +7 -> 84
    //   80: aload_3
    //   81: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   84: aload_0
    //   85: monitorexit
    //   86: aconst_null
    //   87: areturn
    //   88: aload_3
    //   89: astore 5
    //   91: aload 4
    //   93: astore 6
    //   95: new 187	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   102: astore 8
    //   104: aload_3
    //   105: astore 5
    //   107: aload 4
    //   109: astore 6
    //   111: new 265	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 266	java/util/ArrayList:<init>	()V
    //   118: astore 9
    //   120: aload_3
    //   121: astore 5
    //   123: aload 4
    //   125: astore 6
    //   127: aload 4
    //   129: invokeinterface 269 1 0
    //   134: ifeq +138 -> 272
    //   137: aload_3
    //   138: astore 5
    //   140: aload 4
    //   142: astore 6
    //   144: aload 4
    //   146: invokestatic 271	com/tencent/bugly/proguard/p:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   149: astore 10
    //   151: aload 10
    //   153: ifnull +23 -> 176
    //   156: aload_3
    //   157: astore 5
    //   159: aload 4
    //   161: astore 6
    //   163: aload 9
    //   165: aload 10
    //   167: invokeinterface 275 2 0
    //   172: pop
    //   173: goto -53 -> 120
    //   176: aload_3
    //   177: astore 5
    //   179: aload 4
    //   181: astore 6
    //   183: aload 4
    //   185: aload 4
    //   187: ldc 108
    //   189: invokeinterface 99 2 0
    //   194: invokeinterface 121 2 0
    //   199: astore 10
    //   201: aload_3
    //   202: astore 5
    //   204: aload 4
    //   206: astore 6
    //   208: aload 8
    //   210: ldc_w 277
    //   213: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_3
    //   218: astore 5
    //   220: aload 4
    //   222: astore 6
    //   224: aload 8
    //   226: ldc_w 279
    //   229: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: astore 5
    //   236: aload 4
    //   238: astore 6
    //   240: aload 8
    //   242: aload 10
    //   244: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: goto -128 -> 120
    //   251: aload_3
    //   252: astore 5
    //   254: aload 4
    //   256: astore 6
    //   258: ldc_w 281
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 75	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   268: pop
    //   269: goto -149 -> 120
    //   272: aload_3
    //   273: astore 5
    //   275: aload 4
    //   277: astore 6
    //   279: aload 8
    //   281: invokevirtual 285	java/lang/StringBuilder:length	()I
    //   284: ifle +91 -> 375
    //   287: aload_3
    //   288: astore 5
    //   290: aload 4
    //   292: astore 6
    //   294: aload 8
    //   296: ldc_w 287
    //   299: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_3
    //   304: astore 5
    //   306: aload 4
    //   308: astore 6
    //   310: aload 8
    //   312: ldc_w 279
    //   315: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: astore 5
    //   322: aload 4
    //   324: astore 6
    //   326: aload 8
    //   328: iload_1
    //   329: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_3
    //   334: astore 5
    //   336: aload 4
    //   338: astore 6
    //   340: ldc_w 289
    //   343: iconst_2
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: ldc 211
    //   351: aastore
    //   352: dup
    //   353: iconst_1
    //   354: aload_3
    //   355: ldc 211
    //   357: aload 7
    //   359: iconst_4
    //   360: invokevirtual 294	java/lang/String:substring	(I)Ljava/lang/String;
    //   363: aconst_null
    //   364: invokevirtual 42	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   367: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   370: aastore
    //   371: invokestatic 75	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   374: pop
    //   375: aload 4
    //   377: ifnull +10 -> 387
    //   380: aload 4
    //   382: invokeinterface 262 1 0
    //   387: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   390: ifeq +11 -> 401
    //   393: aload_3
    //   394: ifnull +7 -> 401
    //   397: aload_3
    //   398: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   401: aload_0
    //   402: monitorexit
    //   403: aload 9
    //   405: areturn
    //   406: astore 7
    //   408: goto +53 -> 461
    //   411: astore 4
    //   413: aconst_null
    //   414: astore 6
    //   416: goto +108 -> 524
    //   419: astore 7
    //   421: aconst_null
    //   422: astore 4
    //   424: goto +37 -> 461
    //   427: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   430: ifeq +85 -> 515
    //   433: aload_3
    //   434: ifnull +81 -> 515
    //   437: aload_3
    //   438: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   441: goto +74 -> 515
    //   444: astore 4
    //   446: aconst_null
    //   447: astore_3
    //   448: aload_3
    //   449: astore 6
    //   451: goto +73 -> 524
    //   454: astore 7
    //   456: aconst_null
    //   457: astore_3
    //   458: aload_3
    //   459: astore 4
    //   461: aload_3
    //   462: astore 5
    //   464: aload 4
    //   466: astore 6
    //   468: aload 7
    //   470: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   473: ifne +15 -> 488
    //   476: aload_3
    //   477: astore 5
    //   479: aload 4
    //   481: astore 6
    //   483: aload 7
    //   485: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   488: aload 4
    //   490: ifnull +10 -> 500
    //   493: aload 4
    //   495: invokeinterface 262 1 0
    //   500: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   503: istore_2
    //   504: iload_2
    //   505: ifeq +10 -> 515
    //   508: aload_3
    //   509: ifnull +6 -> 515
    //   512: goto -75 -> 437
    //   515: aload_0
    //   516: monitorexit
    //   517: aconst_null
    //   518: areturn
    //   519: astore 4
    //   521: aload 5
    //   523: astore_3
    //   524: aload 6
    //   526: ifnull +10 -> 536
    //   529: aload 6
    //   531: invokeinterface 262 1 0
    //   536: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   539: ifeq +11 -> 550
    //   542: aload_3
    //   543: ifnull +7 -> 550
    //   546: aload_3
    //   547: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   550: aload 4
    //   552: athrow
    //   553: astore_3
    //   554: aload_0
    //   555: monitorexit
    //   556: goto +5 -> 561
    //   559: aload_3
    //   560: athrow
    //   561: goto -2 -> 559
    //   564: astore 5
    //   566: goto -315 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	p
    //   0	569	1	paramInt	int
    //   503	2	2	bool	boolean
    //   8	539	3	localObject1	Object
    //   553	7	3	localObject2	Object
    //   22	359	4	localObject3	Object
    //   411	1	4	localObject4	Object
    //   422	1	4	localObject5	Object
    //   444	1	4	localObject6	Object
    //   459	35	4	localObject7	Object
    //   519	32	4	localObject8	Object
    //   89	433	5	localObject9	Object
    //   564	1	5	localThrowable1	Throwable
    //   93	437	6	localObject10	Object
    //   36	322	7	str	String
    //   406	1	7	localThrowable2	Throwable
    //   419	1	7	localThrowable3	Throwable
    //   454	30	7	localThrowable4	Throwable
    //   102	225	8	localStringBuilder	java.lang.StringBuilder
    //   118	286	9	localArrayList	java.util.ArrayList
    //   149	94	10	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   95	104	406	java/lang/Throwable
    //   111	120	406	java/lang/Throwable
    //   127	137	406	java/lang/Throwable
    //   144	151	406	java/lang/Throwable
    //   163	173	406	java/lang/Throwable
    //   258	269	406	java/lang/Throwable
    //   279	287	406	java/lang/Throwable
    //   294	303	406	java/lang/Throwable
    //   310	319	406	java/lang/Throwable
    //   326	333	406	java/lang/Throwable
    //   340	375	406	java/lang/Throwable
    //   13	53	411	finally
    //   13	53	419	java/lang/Throwable
    //   2	9	444	finally
    //   2	9	454	java/lang/Throwable
    //   95	104	519	finally
    //   111	120	519	finally
    //   127	137	519	finally
    //   144	151	519	finally
    //   163	173	519	finally
    //   183	201	519	finally
    //   208	217	519	finally
    //   224	233	519	finally
    //   240	248	519	finally
    //   258	269	519	finally
    //   279	287	519	finally
    //   294	303	519	finally
    //   310	319	519	finally
    //   326	333	519	finally
    //   340	375	519	finally
    //   468	476	519	finally
    //   483	488	519	finally
    //   63	70	553	finally
    //   70	76	553	finally
    //   80	84	553	finally
    //   380	387	553	finally
    //   387	393	553	finally
    //   397	401	553	finally
    //   427	433	553	finally
    //   437	441	553	finally
    //   493	500	553	finally
    //   500	504	553	finally
    //   529	536	553	finally
    //   536	542	553	finally
    //   546	550	553	finally
    //   550	553	553	finally
    //   183	201	564	java/lang/Throwable
    //   208	217	564	java/lang/Throwable
    //   224	233	564	java/lang/Throwable
    //   240	248	564	java/lang/Throwable
  }
  
  private static ContentValues d(r paramr)
  {
    if (paramr != null)
    {
      if (z.a(paramr.f)) {
        return null;
      }
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramr.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramr.a));
        }
        localContentValues.put("_tp", paramr.f);
        localContentValues.put("_tm", Long.valueOf(paramr.e));
        if (paramr.g != null) {
          localContentValues.put("_dt", paramr.g);
        }
        return localContentValues;
      }
      catch (Throwable paramr)
      {
        if (!x.a(paramr)) {
          paramr.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, o paramo, boolean paramBoolean)
  {
    return a(paramString, paramContentValues, null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, o paramo, boolean paramBoolean)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  /* Error */
  public final List<r> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnull +425 -> 437
    //   15: iload_1
    //   16: iflt +459 -> 475
    //   19: new 187	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 300
    //   26: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: iload_1
    //   34: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 4
    //   45: goto +3 -> 48
    //   48: aload 7
    //   50: ldc_w 302
    //   53: aconst_null
    //   54: aload 4
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 261	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnonnull +35 -> 102
    //   70: aload 5
    //   72: ifnull +10 -> 82
    //   75: aload 5
    //   77: invokeinterface 262 1 0
    //   82: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   85: ifeq +13 -> 98
    //   88: aload 7
    //   90: ifnull +8 -> 98
    //   93: aload 7
    //   95: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   98: aload_0
    //   99: monitorexit
    //   100: aconst_null
    //   101: areturn
    //   102: aload 5
    //   104: astore 4
    //   106: new 187	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   113: astore 8
    //   115: aload 5
    //   117: astore 4
    //   119: new 265	java/util/ArrayList
    //   122: dup
    //   123: invokespecial 266	java/util/ArrayList:<init>	()V
    //   126: astore 6
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: invokeinterface 269 1 0
    //   139: ifeq +115 -> 254
    //   142: aload 5
    //   144: astore 4
    //   146: aload 5
    //   148: invokestatic 304	com/tencent/bugly/proguard/p:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   151: astore 9
    //   153: aload 9
    //   155: ifnull +20 -> 175
    //   158: aload 5
    //   160: astore 4
    //   162: aload 6
    //   164: aload 9
    //   166: invokeinterface 275 2 0
    //   171: pop
    //   172: goto -44 -> 128
    //   175: aload 5
    //   177: astore 4
    //   179: aload 5
    //   181: aload 5
    //   183: ldc 61
    //   185: invokeinterface 99 2 0
    //   190: invokeinterface 103 2 0
    //   195: lstore_2
    //   196: aload 5
    //   198: astore 4
    //   200: aload 8
    //   202: ldc_w 306
    //   205: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 5
    //   211: astore 4
    //   213: aload 8
    //   215: ldc_w 279
    //   218: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 5
    //   224: astore 4
    //   226: aload 8
    //   228: lload_2
    //   229: invokevirtual 309	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: goto -105 -> 128
    //   236: aload 5
    //   238: astore 4
    //   240: ldc_w 281
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 75	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   250: pop
    //   251: goto -123 -> 128
    //   254: aload 5
    //   256: astore 4
    //   258: aload 8
    //   260: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 8
    //   265: aload 5
    //   267: astore 4
    //   269: aload 8
    //   271: invokevirtual 310	java/lang/String:length	()I
    //   274: ifle +45 -> 319
    //   277: aload 5
    //   279: astore 4
    //   281: ldc_w 312
    //   284: iconst_2
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: ldc_w 302
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload 7
    //   298: ldc_w 302
    //   301: aload 8
    //   303: iconst_4
    //   304: invokevirtual 294	java/lang/String:substring	(I)Ljava/lang/String;
    //   307: aconst_null
    //   308: invokevirtual 42	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   311: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   314: aastore
    //   315: invokestatic 75	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   318: pop
    //   319: aload 5
    //   321: ifnull +10 -> 331
    //   324: aload 5
    //   326: invokeinterface 262 1 0
    //   331: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   334: ifeq +13 -> 347
    //   337: aload 7
    //   339: ifnull +8 -> 347
    //   342: aload 7
    //   344: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   347: aload_0
    //   348: monitorexit
    //   349: aload 6
    //   351: areturn
    //   352: astore 6
    //   354: aload 5
    //   356: astore 4
    //   358: aload 6
    //   360: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   363: ifne +12 -> 375
    //   366: aload 5
    //   368: astore 4
    //   370: aload 6
    //   372: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   375: aload 5
    //   377: ifnull +10 -> 387
    //   380: aload 5
    //   382: invokeinterface 262 1 0
    //   387: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   390: ifeq +47 -> 437
    //   393: aload 7
    //   395: ifnull +42 -> 437
    //   398: aload 7
    //   400: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   403: goto +34 -> 437
    //   406: aload 4
    //   408: ifnull +10 -> 418
    //   411: aload 4
    //   413: invokeinterface 262 1 0
    //   418: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   421: ifeq +13 -> 434
    //   424: aload 7
    //   426: ifnull +8 -> 434
    //   429: aload 7
    //   431: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   434: aload 5
    //   436: athrow
    //   437: aload_0
    //   438: monitorexit
    //   439: aconst_null
    //   440: areturn
    //   441: astore 4
    //   443: aload_0
    //   444: monitorexit
    //   445: goto +6 -> 451
    //   448: aload 4
    //   450: athrow
    //   451: goto -3 -> 448
    //   454: astore 4
    //   456: goto -220 -> 236
    //   459: astore 5
    //   461: aconst_null
    //   462: astore 4
    //   464: goto -58 -> 406
    //   467: astore 6
    //   469: aconst_null
    //   470: astore 5
    //   472: goto -118 -> 354
    //   475: aconst_null
    //   476: astore 4
    //   478: goto -430 -> 48
    //   481: astore 5
    //   483: goto -77 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	p
    //   0	486	1	paramInt	int
    //   195	34	2	l	long
    //   29	383	4	localObject1	Object
    //   441	8	4	localObject2	Object
    //   454	1	4	localThrowable1	Throwable
    //   462	15	4	localObject3	Object
    //   63	372	5	localCursor	Cursor
    //   459	1	5	localObject4	Object
    //   470	1	5	localObject5	Object
    //   481	1	5	localObject6	Object
    //   126	224	6	localArrayList	java.util.ArrayList
    //   352	19	6	localThrowable2	Throwable
    //   467	1	6	localThrowable3	Throwable
    //   8	422	7	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   113	189	8	localObject7	Object
    //   151	14	9	localr	r
    // Exception table:
    //   from	to	target	type
    //   106	115	352	java/lang/Throwable
    //   119	128	352	java/lang/Throwable
    //   132	142	352	java/lang/Throwable
    //   146	153	352	java/lang/Throwable
    //   162	172	352	java/lang/Throwable
    //   240	251	352	java/lang/Throwable
    //   258	265	352	java/lang/Throwable
    //   269	277	352	java/lang/Throwable
    //   281	319	352	java/lang/Throwable
    //   2	10	441	finally
    //   75	82	441	finally
    //   82	88	441	finally
    //   93	98	441	finally
    //   324	331	441	finally
    //   331	337	441	finally
    //   342	347	441	finally
    //   380	387	441	finally
    //   387	393	441	finally
    //   398	403	441	finally
    //   411	418	441	finally
    //   418	424	441	finally
    //   429	434	441	finally
    //   434	437	441	finally
    //   179	196	454	java/lang/Throwable
    //   200	209	454	java/lang/Throwable
    //   213	222	454	java/lang/Throwable
    //   226	233	454	java/lang/Throwable
    //   19	45	459	finally
    //   48	65	459	finally
    //   19	45	467	java/lang/Throwable
    //   48	65	467	java/lang/Throwable
    //   106	115	481	finally
    //   119	128	481	finally
    //   132	142	481	finally
    //   146	153	481	finally
    //   162	172	481	finally
    //   179	196	481	finally
    //   200	209	481	finally
    //   213	222	481	finally
    //   226	233	481	finally
    //   240	251	481	finally
    //   258	265	481	finally
    //   269	277	481	finally
    //   281	319	481	finally
    //   358	366	481	finally
    //   370	375	481	finally
  }
  
  public final Map<String, byte[]> a(int paramInt, o paramo, boolean paramBoolean)
  {
    return a(paramInt, null);
  }
  
  /* Error */
  public final void a(List<r> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +212 -> 215
    //   6: aload_1
    //   7: invokeinterface 318 1 0
    //   12: ifne +6 -> 18
    //   15: goto +200 -> 215
    //   18: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   21: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +181 -> 207
    //   29: new 187	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   36: astore 4
    //   38: aload_1
    //   39: invokeinterface 156 1 0
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 162 1 0
    //   51: ifeq +44 -> 95
    //   54: aload_1
    //   55: invokeinterface 166 1 0
    //   60: checkcast 92	com/tencent/bugly/proguard/r
    //   63: astore_2
    //   64: aload 4
    //   66: ldc_w 306
    //   69: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: ldc_w 279
    //   78: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 4
    //   84: aload_2
    //   85: getfield 106	com/tencent/bugly/proguard/r:a	J
    //   88: invokevirtual 309	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: goto -47 -> 45
    //   95: aload 4
    //   97: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokevirtual 310	java/lang/String:length	()I
    //   107: ifle +9 -> 116
    //   110: aload_2
    //   111: iconst_4
    //   112: invokevirtual 294	java/lang/String:substring	(I)Ljava/lang/String;
    //   115: astore_1
    //   116: aload 4
    //   118: iconst_0
    //   119: invokevirtual 322	java/lang/StringBuilder:setLength	(I)V
    //   122: ldc 213
    //   124: iconst_2
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc_w 302
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_3
    //   137: ldc_w 302
    //   140: aload_1
    //   141: aconst_null
    //   142: invokevirtual 42	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   145: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 70	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   156: ifeq +51 -> 207
    //   159: aload_3
    //   160: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: astore_1
    //   167: goto +28 -> 195
    //   170: astore_1
    //   171: aload_1
    //   172: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   175: ifne +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   182: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   185: ifeq +22 -> 207
    //   188: aload_3
    //   189: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   192: aload_0
    //   193: monitorexit
    //   194: return
    //   195: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   198: ifeq +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   205: aload_1
    //   206: athrow
    //   207: aload_0
    //   208: monitorexit
    //   209: return
    //   210: astore_1
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_1
    //   214: athrow
    //   215: aload_0
    //   216: monitorexit
    //   217: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	p
    //   0	218	1	paramList	List<r>
    //   63	48	2	localObject	Object
    //   24	178	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   36	81	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   122	153	166	finally
    //   171	182	166	finally
    //   122	153	170	java/lang/Throwable
    //   6	15	210	finally
    //   18	25	210	finally
    //   29	45	210	finally
    //   45	92	210	finally
    //   95	101	210	finally
    //   103	116	210	finally
    //   116	122	210	finally
    //   153	163	210	finally
    //   182	192	210	finally
    //   195	205	210	finally
    //   205	207	210	finally
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramo = new p.a(this, 4, null);
      paramo.a(paramInt, paramString, paramArrayOfByte);
      w.a().a(paramo);
      return true;
    }
    return a(paramInt, paramString, paramArrayOfByte, null);
  }
  
  /* Error */
  public final boolean a(r paramr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 4
    //   16: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   19: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 6
    //   24: aload 6
    //   26: ifnull +126 -> 152
    //   29: aload 6
    //   31: astore 4
    //   33: aload 6
    //   35: astore 5
    //   37: aload_1
    //   38: invokestatic 342	com/tencent/bugly/proguard/p:c	(Lcom/tencent/bugly/proguard/r;)Landroid/content/ContentValues;
    //   41: astore 7
    //   43: aload 7
    //   45: ifnull +107 -> 152
    //   48: aload 6
    //   50: astore 4
    //   52: aload 6
    //   54: astore 5
    //   56: aload 6
    //   58: ldc_w 302
    //   61: ldc 61
    //   63: aload 7
    //   65: invokevirtual 65	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   68: lstore_2
    //   69: lload_2
    //   70: lconst_0
    //   71: lcmp
    //   72: iflt +60 -> 132
    //   75: aload 6
    //   77: astore 4
    //   79: aload 6
    //   81: astore 5
    //   83: ldc 67
    //   85: iconst_1
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: ldc_w 302
    //   94: aastore
    //   95: invokestatic 70	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   98: pop
    //   99: aload 6
    //   101: astore 4
    //   103: aload 6
    //   105: astore 5
    //   107: aload_1
    //   108: lload_2
    //   109: putfield 106	com/tencent/bugly/proguard/r:a	J
    //   112: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   115: ifeq +13 -> 128
    //   118: aload 6
    //   120: ifnull +8 -> 128
    //   123: aload 6
    //   125: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   128: aload_0
    //   129: monitorexit
    //   130: iconst_1
    //   131: ireturn
    //   132: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   135: ifeq +13 -> 148
    //   138: aload 6
    //   140: ifnull +8 -> 148
    //   143: aload 6
    //   145: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   148: aload_0
    //   149: monitorexit
    //   150: iconst_0
    //   151: ireturn
    //   152: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   155: ifeq +13 -> 168
    //   158: aload 6
    //   160: ifnull +8 -> 168
    //   163: aload 6
    //   165: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   168: aload_0
    //   169: monitorexit
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_1
    //   173: goto +43 -> 216
    //   176: astore_1
    //   177: aload 5
    //   179: astore 4
    //   181: aload_1
    //   182: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   185: ifne +11 -> 196
    //   188: aload 5
    //   190: astore 4
    //   192: aload_1
    //   193: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   196: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   199: ifeq +13 -> 212
    //   202: aload 5
    //   204: ifnull +8 -> 212
    //   207: aload 5
    //   209: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   212: aload_0
    //   213: monitorexit
    //   214: iconst_0
    //   215: ireturn
    //   216: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   219: ifeq +13 -> 232
    //   222: aload 4
    //   224: ifnull +8 -> 232
    //   227: aload 4
    //   229: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_1
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	p
    //   0	239	1	paramr	r
    //   68	41	2	l	long
    //   14	214	4	localObject1	Object
    //   11	197	5	localObject2	Object
    //   22	142	6	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   41	23	7	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   16	24	172	finally
    //   37	43	172	finally
    //   56	69	172	finally
    //   83	99	172	finally
    //   107	112	172	finally
    //   181	188	172	finally
    //   192	196	172	finally
    //   16	24	176	java/lang/Throwable
    //   37	43	176	java/lang/Throwable
    //   56	69	176	java/lang/Throwable
    //   83	99	176	java/lang/Throwable
    //   107	112	176	java/lang/Throwable
    //   112	118	234	finally
    //   123	128	234	finally
    //   132	138	234	finally
    //   143	148	234	finally
    //   152	158	234	finally
    //   163	168	234	finally
    //   196	202	234	finally
    //   207	212	234	finally
    //   216	222	234	finally
    //   227	232	234	finally
    //   232	234	234	finally
  }
  
  /* Error */
  public final void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual 36	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +124 -> 134
    //   13: iload_1
    //   14: iflt +136 -> 150
    //   17: new 187	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 300
    //   24: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: iload_1
    //   30: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_2
    //   39: goto +3 -> 42
    //   42: ldc 213
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: ldc_w 302
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload_3
    //   57: ldc_w 302
    //   60: aload_2
    //   61: aconst_null
    //   62: invokevirtual 42	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   65: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic 70	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   72: pop
    //   73: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   76: ifeq +58 -> 134
    //   79: aload_3
    //   80: ifnull +54 -> 134
    //   83: aload_3
    //   84: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: aload_2
    //   91: invokestatic 52	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   94: ifne +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   101: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   104: ifeq +30 -> 134
    //   107: aload_3
    //   108: ifnull +26 -> 134
    //   111: aload_3
    //   112: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   115: aload_0
    //   116: monitorexit
    //   117: return
    //   118: getstatic 44	com/tencent/bugly/proguard/p:a	Z
    //   121: ifeq +11 -> 132
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 47	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    //   142: astore_2
    //   143: goto -25 -> 118
    //   146: astore_2
    //   147: goto -57 -> 90
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -110 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	p
    //   0	155	1	paramInt	int
    //   27	106	2	localObject1	Object
    //   137	4	2	localObject2	Object
    //   142	1	2	localObject3	Object
    //   146	1	2	localThrowable	Throwable
    //   151	1	2	localObject4	Object
    //   8	121	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	9	137	finally
    //   73	79	137	finally
    //   83	87	137	finally
    //   101	107	137	finally
    //   111	115	137	finally
    //   118	124	137	finally
    //   128	132	137	finally
    //   132	134	137	finally
    //   17	39	142	finally
    //   42	73	142	finally
    //   90	101	142	finally
    //   17	39	146	java/lang/Throwable
    //   42	73	146	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.p
 * JD-Core Version:    0.7.0.1
 */