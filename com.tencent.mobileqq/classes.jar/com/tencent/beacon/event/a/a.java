package com.tencent.beacon.event.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import com.tencent.beacon.event.EventBean;
import java.util.ArrayList;
import java.util.List;

public class a
  implements com.tencent.beacon.a.d.d<EventBean>
{
  private final SQLiteStatement a;
  private final SQLiteStatement b;
  private final Object c = new Object();
  private final Object d = new Object();
  private com.tencent.beacon.event.c.b e = com.tencent.beacon.event.c.b.a();
  private SQLiteDatabase f;
  private SQLiteDatabase g;
  private long h;
  private long i;
  
  public a()
  {
    Object localObject = new com.tencent.beacon.a.d.c(com.tencent.beacon.a.c.b.c(com.tencent.beacon.a.c.c.d().c()));
    this.f = ((SQLiteOpenHelper)localObject).getWritableDatabase();
    this.g = ((SQLiteOpenHelper)localObject).getReadableDatabase();
    this.a = this.g.compileStatement("INSERT INTO t_r_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
    this.b = this.g.compileStatement("INSERT INTO t_n_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
    this.h = a("t_r_e");
    this.i = a("t_n_e");
    if ((this.h != 0L) || (this.i != 0L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" realtime: ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(", normal: ");
      ((StringBuilder)localObject).append(this.i);
      localObject = ((StringBuilder)localObject).toString();
      com.tencent.beacon.base.util.c.a("[EventDAO]", (String)localObject, new Object[0]);
      com.tencent.beacon.a.b.d locald = com.tencent.beacon.a.b.d.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[EventDAO]");
      localStringBuilder.append((String)localObject);
      locald.a("607", localStringBuilder.toString());
    }
  }
  
  private List<EventBean> a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed()))
    {
      ArrayList localArrayList = new ArrayList();
      while (paramCursor.moveToNext())
      {
        b localb = new b();
        localb.a = paramCursor.getLong(0);
        localb.d = paramCursor.getString(1);
        localb.b = paramCursor.getInt(2);
        localb.c = paramCursor.getLong(3);
        localb.e = paramCursor.getBlob(4);
        localArrayList.add((EventBean)this.e.c().a(localb));
      }
      if (!paramCursor.isClosed()) {
        paramCursor.close();
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramBoolean1)
    {
      localObject1 = this.c;
      if (paramBoolean2) {}
      try
      {
        this.h += paramLong;
        break label40;
        this.h -= paramLong;
        label40:
        com.tencent.beacon.base.util.c.a("[EventDAO]", "current db realtime:%s", new Object[] { Long.valueOf(this.h) });
        return;
      }
      finally {}
    }
    Object localObject1 = this.d;
    if (paramBoolean2) {}
    try
    {
      this.i += paramLong;
      break label109;
      this.i -= paramLong;
      label109:
      com.tencent.beacon.base.util.c.a("[EventDAO]", "current db normal:%s", new Object[] { Long.valueOf(this.i) });
      return;
    }
    finally {}
  }
  
  /* Error */
  public long a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload 8
    //   8: astore 6
    //   10: aload 9
    //   12: astore 7
    //   14: new 94	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   21: astore 10
    //   23: aload 8
    //   25: astore 6
    //   27: aload 9
    //   29: astore 7
    //   31: aload 10
    //   33: ldc 208
    //   35: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 8
    //   41: astore 6
    //   43: aload 9
    //   45: astore 7
    //   47: aload 10
    //   49: aload_1
    //   50: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 8
    //   56: astore 6
    //   58: aload 9
    //   60: astore 7
    //   62: aload 10
    //   64: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 10
    //   69: aload 8
    //   71: astore 6
    //   73: aload 9
    //   75: astore 7
    //   77: aload_0
    //   78: getfield 67	com/tencent/beacon/event/a/a:g	Landroid/database/sqlite/SQLiteDatabase;
    //   81: aload 10
    //   83: iconst_1
    //   84: anewarray 210	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: ldc 212
    //   91: aastore
    //   92: invokevirtual 216	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore 8
    //   97: aload 8
    //   99: astore 6
    //   101: aload 8
    //   103: astore 7
    //   105: aload 8
    //   107: invokeinterface 219 1 0
    //   112: pop
    //   113: aload 8
    //   115: astore 6
    //   117: aload 8
    //   119: astore 7
    //   121: aload 8
    //   123: iconst_0
    //   124: invokeinterface 148 2 0
    //   129: lstore 4
    //   131: lload 4
    //   133: lstore_2
    //   134: aload 8
    //   136: ifnull +157 -> 293
    //   139: lload 4
    //   141: lstore_2
    //   142: aload 8
    //   144: invokeinterface 135 1 0
    //   149: ifne +144 -> 293
    //   152: aload 8
    //   154: invokeinterface 191 1 0
    //   159: lload 4
    //   161: lreturn
    //   162: astore_1
    //   163: goto +132 -> 295
    //   166: astore 8
    //   168: aload 7
    //   170: astore 6
    //   172: invokestatic 122	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   175: astore 9
    //   177: aload 7
    //   179: astore 6
    //   181: new 94	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   188: astore 10
    //   190: aload 7
    //   192: astore 6
    //   194: aload 10
    //   196: ldc 221
    //   198: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 7
    //   204: astore 6
    //   206: aload 10
    //   208: aload_1
    //   209: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 7
    //   215: astore 6
    //   217: aload 10
    //   219: ldc 223
    //   221: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 7
    //   227: astore 6
    //   229: aload 10
    //   231: aload 8
    //   233: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 7
    //   242: astore 6
    //   244: aload 9
    //   246: ldc 228
    //   248: aload 10
    //   250: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: aload 8
    //   255: invokevirtual 231	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload 7
    //   260: astore 6
    //   262: aload 8
    //   264: invokestatic 234	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   267: aload 7
    //   269: ifnull +20 -> 289
    //   272: aload 7
    //   274: invokeinterface 135 1 0
    //   279: ifne +10 -> 289
    //   282: aload 7
    //   284: invokeinterface 191 1 0
    //   289: ldc2_w 235
    //   292: lstore_2
    //   293: lload_2
    //   294: lreturn
    //   295: aload 6
    //   297: ifnull +20 -> 317
    //   300: aload 6
    //   302: invokeinterface 135 1 0
    //   307: ifne +10 -> 317
    //   310: aload 6
    //   312: invokeinterface 191 1 0
    //   317: aload_1
    //   318: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	a
    //   0	319	1	paramString	String
    //   133	161	2	l1	long
    //   129	31	4	l2	long
    //   8	303	6	localObject1	Object
    //   12	271	7	localObject2	Object
    //   4	149	8	localCursor	Cursor
    //   166	97	8	localException	Exception
    //   1	244	9	locald	com.tencent.beacon.a.b.d
    //   21	228	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	23	162	finally
    //   31	39	162	finally
    //   47	54	162	finally
    //   62	69	162	finally
    //   77	97	162	finally
    //   105	113	162	finally
    //   121	131	162	finally
    //   172	177	162	finally
    //   181	190	162	finally
    //   194	202	162	finally
    //   206	213	162	finally
    //   217	225	162	finally
    //   229	240	162	finally
    //   244	258	162	finally
    //   262	267	162	finally
    //   14	23	166	java/lang/Exception
    //   31	39	166	java/lang/Exception
    //   47	54	166	java/lang/Exception
    //   62	69	166	java/lang/Exception
    //   77	97	166	java/lang/Exception
    //   105	113	166	java/lang/Exception
    //   121	131	166	java/lang/Exception
  }
  
  public List<EventBean> a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" SELECT * FROM ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" WHERE ");
      ((StringBuilder)localObject2).append("_id");
      ((StringBuilder)localObject2).append(" NOT IN (");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(") ORDER BY ");
      ((StringBuilder)localObject2).append("_time");
      ((StringBuilder)localObject2).append(" DESC LIMIT ");
      ((StringBuilder)localObject2).append(paramInt);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject2 = a(this.g.rawQuery((String)localObject2, null));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.base.util.c.a(localException);
      com.tencent.beacon.a.b.d locald = com.tencent.beacon.a.b.d.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("type: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" query err: ");
      localStringBuilder.append(localException.getMessage());
      locald.a("605", localStringBuilder.toString(), localException);
    }
    com.tencent.beacon.base.util.c.a("[EventDAO]", "query tableName: %s, args: %s", new Object[] { paramString1, paramString2 });
    com.tencent.beacon.base.util.c.a("[EventDAO]", "query cost time: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localObject1;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 1) {
      synchronized (this.c)
      {
        if (this.h >= com.tencent.beacon.e.b.a().b()) {
          bool1 = true;
        }
        return bool1;
      }
    }
    ??? = this.d;
    bool1 = bool2;
    try
    {
      if (this.i >= com.tencent.beacon.e.b.a().b()) {
        bool1 = true;
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(EventBean paramEventBean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 36	com/tencent/beacon/event/a/a:e	Lcom/tencent/beacon/event/c/b;
    //   10: invokevirtual 279	com/tencent/beacon/event/c/b:b	()Lcom/tencent/beacon/base/net/b/c;
    //   13: aload_1
    //   14: invokeinterface 180 2 0
    //   19: checkcast 143	com/tencent/beacon/event/a/b
    //   22: astore 6
    //   24: aload_1
    //   25: invokevirtual 282	com/tencent/beacon/event/EventBean:getEventType	()I
    //   28: invokestatic 286	com/tencent/beacon/event/c/c:a	(I)Z
    //   31: istore_3
    //   32: aload_0
    //   33: getfield 62	com/tencent/beacon/event/a/a:f	Landroid/database/sqlite/SQLiteDatabase;
    //   36: invokevirtual 289	android/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   39: aload_0
    //   40: getfield 77	com/tencent/beacon/event/a/a:a	Landroid/database/sqlite/SQLiteStatement;
    //   43: invokevirtual 294	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   46: iload_3
    //   47: ifeq +58 -> 105
    //   50: aload_0
    //   51: getfield 77	com/tencent/beacon/event/a/a:a	Landroid/database/sqlite/SQLiteStatement;
    //   54: iconst_1
    //   55: aload 6
    //   57: getfield 157	com/tencent/beacon/event/a/b:d	Ljava/lang/String;
    //   60: invokevirtual 298	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   63: aload_0
    //   64: getfield 77	com/tencent/beacon/event/a/a:a	Landroid/database/sqlite/SQLiteStatement;
    //   67: iconst_2
    //   68: aload 6
    //   70: getfield 163	com/tencent/beacon/event/a/b:b	J
    //   73: invokevirtual 302	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   76: aload_0
    //   77: getfield 77	com/tencent/beacon/event/a/a:a	Landroid/database/sqlite/SQLiteStatement;
    //   80: iconst_3
    //   81: aload 6
    //   83: getfield 165	com/tencent/beacon/event/a/b:c	J
    //   86: invokevirtual 302	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   89: aload_0
    //   90: getfield 77	com/tencent/beacon/event/a/a:a	Landroid/database/sqlite/SQLiteStatement;
    //   93: iconst_4
    //   94: aload 6
    //   96: getfield 172	com/tencent/beacon/event/a/b:e	[B
    //   99: invokevirtual 306	android/database/sqlite/SQLiteStatement:bindBlob	(I[B)V
    //   102: goto +55 -> 157
    //   105: aload_0
    //   106: getfield 81	com/tencent/beacon/event/a/a:b	Landroid/database/sqlite/SQLiteStatement;
    //   109: iconst_1
    //   110: aload 6
    //   112: getfield 157	com/tencent/beacon/event/a/b:d	Ljava/lang/String;
    //   115: invokevirtual 298	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   118: aload_0
    //   119: getfield 81	com/tencent/beacon/event/a/a:b	Landroid/database/sqlite/SQLiteStatement;
    //   122: iconst_2
    //   123: aload 6
    //   125: getfield 163	com/tencent/beacon/event/a/b:b	J
    //   128: invokevirtual 302	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   131: aload_0
    //   132: getfield 81	com/tencent/beacon/event/a/a:b	Landroid/database/sqlite/SQLiteStatement;
    //   135: iconst_3
    //   136: aload 6
    //   138: getfield 165	com/tencent/beacon/event/a/b:c	J
    //   141: invokevirtual 302	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   144: aload_0
    //   145: getfield 81	com/tencent/beacon/event/a/a:b	Landroid/database/sqlite/SQLiteStatement;
    //   148: iconst_4
    //   149: aload 6
    //   151: getfield 172	com/tencent/beacon/event/a/b:e	[B
    //   154: invokevirtual 306	android/database/sqlite/SQLiteStatement:bindBlob	(I[B)V
    //   157: iload_3
    //   158: ifeq +18 -> 176
    //   161: aload_0
    //   162: getfield 77	com/tencent/beacon/event/a/a:a	Landroid/database/sqlite/SQLiteStatement;
    //   165: invokevirtual 309	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   168: lconst_0
    //   169: lcmp
    //   170: iflt +27 -> 197
    //   173: goto +19 -> 192
    //   176: aload_0
    //   177: getfield 81	com/tencent/beacon/event/a/a:b	Landroid/database/sqlite/SQLiteStatement;
    //   180: invokevirtual 309	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   183: lstore 4
    //   185: lload 4
    //   187: lconst_0
    //   188: lcmp
    //   189: iflt +8 -> 197
    //   192: iconst_1
    //   193: istore_2
    //   194: goto +5 -> 199
    //   197: iconst_0
    //   198: istore_2
    //   199: aload_0
    //   200: getfield 62	com/tencent/beacon/event/a/a:f	Landroid/database/sqlite/SQLiteDatabase;
    //   203: invokevirtual 312	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   206: aload_0
    //   207: getfield 62	com/tencent/beacon/event/a/a:f	Landroid/database/sqlite/SQLiteDatabase;
    //   210: invokevirtual 315	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   213: goto +230 -> 443
    //   216: astore_1
    //   217: invokestatic 122	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   220: astore 6
    //   222: new 94	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   229: astore 7
    //   231: aload 7
    //   233: ldc 221
    //   235: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 7
    //   241: iload_3
    //   242: invokevirtual 318	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 7
    //   248: ldc_w 320
    //   251: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 7
    //   257: aload_1
    //   258: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   261: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 6
    //   267: ldc_w 322
    //   270: aload 7
    //   272: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: aload_1
    //   276: invokevirtual 231	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload_1
    //   280: invokestatic 234	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   283: goto +160 -> 443
    //   286: astore_1
    //   287: goto +227 -> 514
    //   290: astore_1
    //   291: invokestatic 122	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   294: astore 6
    //   296: new 94	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   303: astore 7
    //   305: aload 7
    //   307: ldc 221
    //   309: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 7
    //   315: iload_3
    //   316: invokevirtual 318	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 7
    //   322: ldc_w 320
    //   325: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 7
    //   331: aload_1
    //   332: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 6
    //   341: ldc_w 322
    //   344: aload 7
    //   346: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: aload_1
    //   350: invokevirtual 231	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_1
    //   354: invokestatic 234	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   357: aload_0
    //   358: getfield 62	com/tencent/beacon/event/a/a:f	Landroid/database/sqlite/SQLiteDatabase;
    //   361: invokevirtual 312	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   364: aload_0
    //   365: getfield 62	com/tencent/beacon/event/a/a:f	Landroid/database/sqlite/SQLiteDatabase;
    //   368: invokevirtual 315	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   371: goto +70 -> 441
    //   374: astore_1
    //   375: invokestatic 122	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   378: astore 6
    //   380: new 94	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   387: astore 7
    //   389: aload 7
    //   391: ldc 221
    //   393: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 7
    //   399: iload_3
    //   400: invokevirtual 318	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 7
    //   406: ldc_w 320
    //   409: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 7
    //   415: aload_1
    //   416: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   419: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 6
    //   425: ldc_w 322
    //   428: aload 7
    //   430: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: aload_1
    //   434: invokevirtual 231	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   437: aload_1
    //   438: invokestatic 234	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   441: iconst_0
    //   442: istore_2
    //   443: iload_2
    //   444: ifeq +12 -> 456
    //   447: aload_0
    //   448: iload_3
    //   449: iconst_1
    //   450: lconst_1
    //   451: invokespecial 324	com/tencent/beacon/event/a/a:a	(ZZJ)V
    //   454: iload_2
    //   455: ireturn
    //   456: invokestatic 122	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   459: astore_1
    //   460: new 94	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   467: astore 6
    //   469: aload 6
    //   471: ldc 221
    //   473: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 6
    //   479: iload_3
    //   480: invokevirtual 318	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 6
    //   486: ldc_w 326
    //   489: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 6
    //   495: iconst_0
    //   496: invokevirtual 318	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_1
    //   501: ldc_w 322
    //   504: aload 6
    //   506: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokevirtual 127	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: iload_2
    //   513: ireturn
    //   514: aload_0
    //   515: getfield 62	com/tencent/beacon/event/a/a:f	Landroid/database/sqlite/SQLiteDatabase;
    //   518: invokevirtual 312	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   521: aload_0
    //   522: getfield 62	com/tencent/beacon/event/a/a:f	Landroid/database/sqlite/SQLiteDatabase;
    //   525: invokevirtual 315	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   528: goto +74 -> 602
    //   531: astore 6
    //   533: invokestatic 122	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   536: astore 7
    //   538: new 94	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   545: astore 8
    //   547: aload 8
    //   549: ldc 221
    //   551: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 8
    //   557: iload_3
    //   558: invokevirtual 318	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 8
    //   564: ldc_w 320
    //   567: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 8
    //   573: aload 6
    //   575: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   578: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 7
    //   584: ldc_w 322
    //   587: aload 8
    //   589: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: aload 6
    //   594: invokevirtual 231	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   597: aload 6
    //   599: invokestatic 234	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   602: aload_1
    //   603: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	a
    //   0	604	1	paramEventBean	EventBean
    //   193	320	2	bool1	boolean
    //   31	527	3	bool2	boolean
    //   183	3	4	l	long
    //   22	483	6	localObject1	Object
    //   531	67	6	localException	Exception
    //   229	354	7	localObject2	Object
    //   545	43	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   199	213	216	java/lang/Exception
    //   32	46	286	finally
    //   50	102	286	finally
    //   105	157	286	finally
    //   161	173	286	finally
    //   176	185	286	finally
    //   291	357	286	finally
    //   32	46	290	java/lang/Exception
    //   50	102	290	java/lang/Exception
    //   105	157	290	java/lang/Exception
    //   161	173	290	java/lang/Exception
    //   176	185	290	java/lang/Exception
    //   357	371	374	java/lang/Exception
    //   514	528	531	java/lang/Exception
  }
  
  public boolean a(@NonNull String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_id IN (");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      int j = this.f.delete(paramString1, (String)localObject, null);
      a(paramString1.equals("t_r_e"), false, j);
      if (j >= 0) {
        return true;
      }
    }
    catch (Exception localException)
    {
      com.tencent.beacon.a.b.d locald = com.tencent.beacon.a.b.d.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("type: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" delete err: ");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(" target: ");
      localStringBuilder.append(paramString2);
      locald.a("606", localStringBuilder.toString(), localException);
      com.tencent.beacon.base.util.c.a(localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.a.a
 * JD-Core Version:    0.7.0.1
 */