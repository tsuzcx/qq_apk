package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import com.tencent.bugly.crashreport.common.info.b;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class q
  extends SQLiteOpenHelper
{
  private static String a = "bugly_db";
  private static int b = 15;
  private Context c;
  private List<a> d;
  
  public q(Context paramContext, List<a> paramList)
  {
    super(paramContext, localStringBuilder.toString(), null, b);
    this.c = paramContext;
    this.d = paramList;
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_3
    //   3: anewarray 64	java/lang/String
    //   6: astore 4
    //   8: aload 4
    //   10: iconst_0
    //   11: ldc 66
    //   13: aastore
    //   14: aload 4
    //   16: iconst_1
    //   17: ldc 68
    //   19: aastore
    //   20: aload 4
    //   22: iconst_2
    //   23: ldc 70
    //   25: aastore
    //   26: aload 4
    //   28: arraylength
    //   29: istore_3
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: iload_3
    //   34: if_icmpge +48 -> 82
    //   37: aload 4
    //   39: iload_2
    //   40: aaload
    //   41: astore 5
    //   43: new 23	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 72
    //   49: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: astore 6
    //   54: aload 6
    //   56: aload 5
    //   58: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: aload 6
    //   65: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 64	java/lang/String
    //   72: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: iload_2
    //   76: iconst_1
    //   77: iadd
    //   78: istore_2
    //   79: goto -47 -> 32
    //   82: aload_0
    //   83: monitorexit
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_1
    //   87: goto +19 -> 106
    //   90: astore_1
    //   91: aload_1
    //   92: invokestatic 86	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   95: ifne +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_0
    //   105: ireturn
    //   106: aload_0
    //   107: monitorexit
    //   108: goto +5 -> 113
    //   111: aload_1
    //   112: athrow
    //   113: goto -2 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	q
    //   0	116	1	paramSQLiteDatabase	SQLiteDatabase
    //   31	48	2	i	int
    //   29	6	3	j	int
    //   6	32	4	arrayOfString	String[]
    //   41	16	5	str	String
    //   52	12	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	8	86	finally
    //   26	30	86	finally
    //   43	75	86	finally
    //   91	102	86	finally
    //   2	8	90	java/lang/Throwable
    //   26	30	90	java/lang/Throwable
    //   43	75	90	java/lang/Throwable
  }
  
  /* Error */
  public final SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: aload_2
    //   7: ifnonnull +79 -> 86
    //   10: iload_1
    //   11: iconst_5
    //   12: if_icmpge +74 -> 86
    //   15: iload_1
    //   16: iconst_1
    //   17: iadd
    //   18: istore_1
    //   19: aload_0
    //   20: invokespecial 95	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: goto -20 -> 6
    //   29: astore_2
    //   30: goto +52 -> 82
    //   33: ldc 97
    //   35: iconst_1
    //   36: anewarray 40	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: iload_1
    //   42: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 106	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: iload_1
    //   51: iconst_5
    //   52: if_icmpne +13 -> 65
    //   55: ldc 108
    //   57: iconst_0
    //   58: anewarray 40	java/lang/Object
    //   61: invokestatic 111	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   64: pop
    //   65: ldc2_w 112
    //   68: invokestatic 119	java/lang/Thread:sleep	(J)V
    //   71: goto -65 -> 6
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual 120	java/lang/InterruptedException:printStackTrace	()V
    //   79: goto -73 -> 6
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_2
    //   89: areturn
    //   90: astore_3
    //   91: goto -58 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	q
    //   5	48	1	i	int
    //   3	23	2	localObject	Object
    //   29	60	2	localSQLiteDatabase1	SQLiteDatabase
    //   23	2	3	localSQLiteDatabase2	SQLiteDatabase
    //   74	2	3	localInterruptedException	java.lang.InterruptedException
    //   90	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	24	29	finally
    //   33	50	29	finally
    //   55	65	29	finally
    //   65	71	29	finally
    //   75	79	29	finally
    //   65	71	74	java/lang/InterruptedException
    //   19	24	90	java/lang/Throwable
  }
  
  /* Error */
  public final SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: aload_2
    //   7: ifnonnull +71 -> 78
    //   10: iload_1
    //   11: iconst_5
    //   12: if_icmpge +66 -> 78
    //   15: iload_1
    //   16: iconst_1
    //   17: iadd
    //   18: istore_1
    //   19: aload_0
    //   20: invokespecial 123	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: goto -20 -> 6
    //   29: ldc 97
    //   31: iconst_1
    //   32: anewarray 40	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_1
    //   38: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: invokestatic 106	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: iload_1
    //   47: iconst_5
    //   48: if_icmpne +13 -> 61
    //   51: ldc 108
    //   53: iconst_0
    //   54: anewarray 40	java/lang/Object
    //   57: invokestatic 111	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc2_w 112
    //   64: invokestatic 119	java/lang/Thread:sleep	(J)V
    //   67: goto -61 -> 6
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual 120	java/lang/InterruptedException:printStackTrace	()V
    //   75: goto -69 -> 6
    //   78: aload_2
    //   79: ifnonnull +21 -> 100
    //   82: ldc 125
    //   84: iconst_0
    //   85: anewarray 40	java/lang/Object
    //   88: invokestatic 106	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   91: pop
    //   92: goto +8 -> 100
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: areturn
    //   104: astore_3
    //   105: goto -76 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	q
    //   5	44	1	i	int
    //   3	76	2	localObject	Object
    //   95	8	2	localSQLiteDatabase1	SQLiteDatabase
    //   23	2	3	localSQLiteDatabase2	SQLiteDatabase
    //   70	2	3	localInterruptedException	java.lang.InterruptedException
    //   104	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   61	67	70	java/lang/InterruptedException
    //   19	24	95	finally
    //   29	46	95	finally
    //   51	61	95	finally
    //   61	67	95	finally
    //   71	75	95	finally
    //   82	92	95	finally
    //   19	24	104	java/lang/Throwable
  }
  
  /* Error */
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 23	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: iconst_0
    //   12: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   15: aload_2
    //   16: ldc 133
    //   18: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: ldc 135
    //   25: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc 137
    //   32: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc 139
    //   39: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc 141
    //   46: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc 143
    //   53: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc 141
    //   60: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: ldc 145
    //   67: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: ldc 141
    //   74: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc 147
    //   81: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: ldc 149
    //   88: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: ldc 151
    //   95: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: ldc 153
    //   102: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: ldc 155
    //   109: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 40	java/lang/Object
    //   121: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_1
    //   126: aload_2
    //   127: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_0
    //   131: anewarray 64	java/lang/String
    //   134: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_2
    //   138: iconst_0
    //   139: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   142: aload_2
    //   143: ldc 159
    //   145: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc 135
    //   152: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: ldc 137
    //   159: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_2
    //   164: ldc 145
    //   166: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: ldc 141
    //   173: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: ldc 139
    //   180: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: ldc 141
    //   187: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: ldc 151
    //   194: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: ldc 153
    //   201: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc 161
    //   208: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: ldc 153
    //   215: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_2
    //   220: ldc 147
    //   222: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: ldc 149
    //   229: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: ldc 155
    //   236: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: iconst_0
    //   245: anewarray 40	java/lang/Object
    //   248: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: aload_1
    //   253: aload_2
    //   254: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: iconst_0
    //   258: anewarray 64	java/lang/String
    //   261: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_2
    //   265: iconst_0
    //   266: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   269: aload_2
    //   270: ldc 163
    //   272: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: ldc 135
    //   279: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_2
    //   284: ldc 165
    //   286: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_2
    //   291: ldc 145
    //   293: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: ldc 153
    //   300: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: ldc 139
    //   307: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: ldc 141
    //   314: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_2
    //   319: ldc 147
    //   321: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_2
    //   326: ldc 149
    //   328: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_2
    //   333: ldc 167
    //   335: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload_2
    //   340: ldc 169
    //   342: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_2
    //   347: ldc 171
    //   349: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: iconst_0
    //   358: anewarray 40	java/lang/Object
    //   361: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: aload_1
    //   366: aload_2
    //   367: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: iconst_0
    //   371: anewarray 64	java/lang/String
    //   374: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_2
    //   378: iconst_0
    //   379: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   382: aload_2
    //   383: ldc 173
    //   385: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: ldc 135
    //   392: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: ldc 137
    //   399: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_2
    //   404: ldc 139
    //   406: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_2
    //   411: ldc 141
    //   413: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc 175
    //   420: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_2
    //   425: ldc 153
    //   427: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: ldc 177
    //   434: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_2
    //   439: ldc 141
    //   441: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_2
    //   446: ldc 179
    //   448: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_2
    //   453: ldc 141
    //   455: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_2
    //   460: ldc 181
    //   462: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_2
    //   467: ldc 141
    //   469: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_2
    //   474: ldc 147
    //   476: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_2
    //   481: ldc 149
    //   483: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_2
    //   488: ldc 155
    //   490: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_2
    //   495: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: iconst_0
    //   499: anewarray 40	java/lang/Object
    //   502: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   505: pop
    //   506: aload_1
    //   507: aload_2
    //   508: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: iconst_0
    //   512: anewarray 64	java/lang/String
    //   515: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: aload_2
    //   519: iconst_0
    //   520: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   523: aload_2
    //   524: ldc 183
    //   526: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_2
    //   531: ldc 185
    //   533: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_2
    //   538: ldc 187
    //   540: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_2
    //   545: ldc 189
    //   547: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_2
    //   552: ldc 191
    //   554: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload_2
    //   559: ldc 193
    //   561: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_2
    //   566: ldc 195
    //   568: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload_2
    //   573: ldc 197
    //   575: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_2
    //   580: ldc 199
    //   582: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload_2
    //   587: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: iconst_0
    //   591: anewarray 40	java/lang/Object
    //   594: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   597: pop
    //   598: aload_1
    //   599: aload_2
    //   600: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: iconst_0
    //   604: anewarray 64	java/lang/String
    //   607: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload_2
    //   611: iconst_0
    //   612: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   615: aload_2
    //   616: ldc 201
    //   618: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: ldc 185
    //   625: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_2
    //   630: ldc 203
    //   632: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload_2
    //   637: ldc 205
    //   639: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload_2
    //   644: ldc 207
    //   646: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_2
    //   651: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: iconst_0
    //   655: anewarray 40	java/lang/Object
    //   658: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload_1
    //   663: aload_2
    //   664: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: iconst_0
    //   668: anewarray 64	java/lang/String
    //   671: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   674: aload_2
    //   675: iconst_0
    //   676: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   679: aload_2
    //   680: ldc 209
    //   682: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_2
    //   687: ldc 135
    //   689: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload_2
    //   694: ldc 165
    //   696: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload_2
    //   701: ldc 145
    //   703: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_2
    //   708: ldc 153
    //   710: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_2
    //   715: ldc 139
    //   717: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload_2
    //   722: ldc 141
    //   724: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload_2
    //   729: ldc 147
    //   731: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_2
    //   736: ldc 149
    //   738: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload_2
    //   743: ldc 167
    //   745: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload_2
    //   750: ldc 169
    //   752: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload_2
    //   757: ldc 171
    //   759: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload_2
    //   764: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: iconst_0
    //   768: anewarray 40	java/lang/Object
    //   771: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   774: pop
    //   775: aload_1
    //   776: aload_2
    //   777: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: iconst_0
    //   781: anewarray 64	java/lang/String
    //   784: invokevirtual 81	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   787: goto +19 -> 806
    //   790: astore_1
    //   791: goto +82 -> 873
    //   794: astore_2
    //   795: aload_2
    //   796: invokestatic 86	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   799: ifne +7 -> 806
    //   802: aload_2
    //   803: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   806: aload_0
    //   807: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   810: astore_2
    //   811: aload_2
    //   812: ifnonnull +6 -> 818
    //   815: aload_0
    //   816: monitorexit
    //   817: return
    //   818: aload_0
    //   819: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   822: invokeinterface 215 1 0
    //   827: astore_2
    //   828: aload_2
    //   829: invokeinterface 221 1 0
    //   834: ifeq +36 -> 870
    //   837: aload_2
    //   838: invokeinterface 225 1 0
    //   843: checkcast 227	com/tencent/bugly/a
    //   846: astore_3
    //   847: aload_3
    //   848: aload_1
    //   849: invokevirtual 230	com/tencent/bugly/a:onDbCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   852: goto -24 -> 828
    //   855: astore_3
    //   856: aload_3
    //   857: invokestatic 86	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   860: ifne -32 -> 828
    //   863: aload_3
    //   864: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   867: goto -39 -> 828
    //   870: aload_0
    //   871: monitorexit
    //   872: return
    //   873: aload_0
    //   874: monitorexit
    //   875: goto +5 -> 880
    //   878: aload_1
    //   879: athrow
    //   880: goto -2 -> 878
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	883	0	this	q
    //   0	883	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	768	2	localStringBuilder	StringBuilder
    //   794	9	2	localThrowable1	Throwable
    //   810	28	2	localObject	Object
    //   846	2	3	locala	a
    //   855	9	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	787	790	finally
    //   795	806	790	finally
    //   806	811	790	finally
    //   818	828	790	finally
    //   828	847	790	finally
    //   847	852	790	finally
    //   856	867	790	finally
    //   2	787	794	java/lang/Throwable
    //   847	852	855	java/lang/Throwable
  }
  
  @TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      if (b.c() >= 11)
      {
        x.d("[Database] Downgrade %d to %d drop tables.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.d != null)
        {
          Iterator localIterator = this.d.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            try
            {
              locala.onDbDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
            }
            catch (Throwable localThrowable) {}
            if (!x.b(localThrowable)) {
              localThrowable.printStackTrace();
            }
          }
        }
        if (a(paramSQLiteDatabase))
        {
          onCreate(paramSQLiteDatabase);
          return;
        }
        x.d("[Database] Failed to drop, delete db.", new Object[0]);
        paramSQLiteDatabase = this.c.getDatabasePath(a);
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
          paramSQLiteDatabase.delete();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      x.d("[Database] Upgrade %d to %d , drop tables!", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.d != null)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          try
          {
            locala.onDbUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
          }
          catch (Throwable localThrowable) {}
          if (!x.b(localThrowable)) {
            localThrowable.printStackTrace();
          }
        }
      }
      if (a(paramSQLiteDatabase))
      {
        onCreate(paramSQLiteDatabase);
        return;
      }
      x.d("[Database] Failed to drop, delete db.", new Object[0]);
      paramSQLiteDatabase = this.c.getDatabasePath(a);
      if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
        paramSQLiteDatabase.delete();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramSQLiteDatabase;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.q
 * JD-Core Version:    0.7.0.1
 */