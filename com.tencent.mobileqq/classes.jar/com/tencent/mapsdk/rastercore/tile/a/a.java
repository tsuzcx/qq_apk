package com.tencent.mapsdk.rastercore.tile.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mapsdk.rastercore.c;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.d.h;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.io.File;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class a
{
  private static final String g = "Qmap" + File.separator;
  private AtomicBoolean a = new AtomicBoolean(false);
  private volatile Context b;
  private AtomicInteger c = new AtomicInteger(0);
  private b d;
  private c e;
  private ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  
  public static a a()
  {
    return a.a;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "md5";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < arrayOfByte.length)
      {
        localObject = Integer.toHexString(arrayOfByte[i] & 0xFF);
        paramArrayOfByte = (byte[])localObject;
        if (((String)localObject).length() == 1) {
          paramArrayOfByte = "0" + (String)localObject;
        }
        localStringBuilder.append(paramArrayOfByte);
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      new StringBuilder("CacheManager getMd5 failed:").append(paramArrayOfByte.toString());
    }
    return "md5";
  }
  
  private static byte[] c(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int j = paramString.length + paramArrayOfByte.length;
      byte[] arrayOfByte = new byte[j];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = paramString[i];
        i += 1;
      }
      i = paramString.length;
      while (i < j)
      {
        arrayOfByte[i] = paramArrayOfByte[(i - paramString.length)];
        i += 1;
      }
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      new StringBuilder("CacheManager encode:").append(paramString.toString());
    }
    return paramArrayOfByte;
  }
  
  private static byte[] d(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int j = paramString.getBytes("UTF-8").length;
      paramString = new byte[paramArrayOfByte.length - j];
      int i = j;
      while (i < paramArrayOfByte.length)
      {
        paramString[(i - j)] = paramArrayOfByte[i];
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return paramArrayOfByte;
  }
  
  /* Error */
  public final b a(com.tencent.mapsdk.rastercore.tile.a parama)
  {
    // Byte code:
    //   0: new 134	com/tencent/mapsdk/rastercore/tile/a/b
    //   3: dup
    //   4: aconst_null
    //   5: invokestatic 138	com/tencent/mapsdk/rastercore/d/h:b	()I
    //   8: ldc 140
    //   10: invokespecial 143	com/tencent/mapsdk/rastercore/tile/a/b:<init>	([BILjava/lang/String;)V
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 145	com/tencent/mapsdk/rastercore/tile/a/a:e	Lcom/tencent/mapsdk/rastercore/tile/a/a$c;
    //   18: ifnull +42 -> 60
    //   21: aload_1
    //   22: invokevirtual 151	com/tencent/mapsdk/rastercore/tile/a:m	()Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   25: getstatic 157	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:CUSTOMER	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   28: if_acmpeq +32 -> 60
    //   31: aload_1
    //   32: invokevirtual 151	com/tencent/mapsdk/rastercore/tile/a:m	()Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   35: getstatic 160	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:TRAFFIC	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   38: if_acmpeq +22 -> 60
    //   41: aload_1
    //   42: invokevirtual 151	com/tencent/mapsdk/rastercore/tile/a:m	()Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   45: getstatic 163	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:TENCENT	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   48: if_acmpne +14 -> 62
    //   51: aload_1
    //   52: invokevirtual 166	com/tencent/mapsdk/rastercore/tile/a:n	()I
    //   55: bipush 7
    //   57: if_icmpne +5 -> 62
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: getfield 73	com/tencent/mapsdk/rastercore/tile/a/a:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   66: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   69: invokevirtual 175	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   72: aload_0
    //   73: getfield 145	com/tencent/mapsdk/rastercore/tile/a/a:e	Lcom/tencent/mapsdk/rastercore/tile/a/a$c;
    //   76: aload_1
    //   77: invokevirtual 177	com/tencent/mapsdk/rastercore/tile/a/a$c:a	(Lcom/tencent/mapsdk/rastercore/tile/a;)Lcom/tencent/mapsdk/rastercore/tile/a/b;
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 73	com/tencent/mapsdk/rastercore/tile/a/a:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   91: aload_1
    //   92: areturn
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 73	com/tencent/mapsdk/rastercore/tile/a/a:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   98: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   101: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   104: aload_2
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 73	com/tencent/mapsdk/rastercore/tile/a/a:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   111: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   114: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	a
    //   0	119	1	parama	com.tencent.mapsdk.rastercore.tile.a
    //   13	92	2	localb	b
    // Exception table:
    //   from	to	target	type
    //   72	81	93	java/lang/Throwable
    //   72	81	106	finally
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      this.c.incrementAndGet();
      if (this.a.compareAndSet(false, true))
      {
        this.b = paramContext;
        this.d = new b(this.b);
        this.e = new c(this.d);
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public final boolean a(MapTile.MapSource paramMapSource)
  {
    if (this.e == null) {
      return false;
    }
    this.f.writeLock().lock();
    try
    {
      boolean bool = this.e.a(paramMapSource);
      return bool;
    }
    catch (Throwable paramMapSource)
    {
      new StringBuilder("clearCache error:").append(paramMapSource.toString());
      return false;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  public final boolean a(b paramb, com.tencent.mapsdk.rastercore.tile.a parama)
  {
    if ((this.e == null) || (parama.m() == MapTile.MapSource.CUSTOMER) || (parama.m() == MapTile.MapSource.TRAFFIC) || ((parama.m() == MapTile.MapSource.TENCENT) && (parama.n() == 7))) {
      return false;
    }
    Object localObject = parama.m();
    int i;
    switch (1.a[localObject.ordinal()])
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      this.f.writeLock().lock();
      try
      {
        if ((parama.g()) && (parama.l() == i))
        {
          localObject = this.e;
          if (localObject != null) {}
        }
        else
        {
          return false;
          i = h.g();
          continue;
          i = h.b();
          continue;
          i = h.d();
          continue;
        }
        if (!c.a(this.e, parama))
        {
          bool = this.e.a(parama, paramb.c());
          return bool;
        }
        boolean bool = this.e.a(parama, paramb.c(), false);
        return bool;
      }
      catch (Throwable paramb)
      {
        new StringBuilder("put error:").append(paramb.toString());
        return false;
      }
      finally
      {
        this.f.writeLock().unlock();
      }
    }
  }
  
  public final boolean a(com.tencent.mapsdk.rastercore.tile.a parama, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((this.e == null) || (parama.m() == MapTile.MapSource.CUSTOMER) || (parama.m() == MapTile.MapSource.TRAFFIC) || ((parama.m() == MapTile.MapSource.TENCENT) && (parama.n() == 7))) {
      return false;
    }
    this.f.writeLock().lock();
    try
    {
      paramBoolean = this.e.a(parama, null, true);
      return paramBoolean;
    }
    catch (Throwable parama)
    {
      new StringBuilder("updateTile error:").append(parama.toString());
      return false;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  public final String b()
  {
    int j = 1;
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    if (this.b == null) {
      return null;
    }
    int i = j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = this.b.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
      int k = this.b.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
      if ((i != 0) || (k != 0)) {
        break label173;
      }
    }
    label173:
    for (i = j;; i = 0)
    {
      if ((bool) && (i != 0)) {}
      for (;;)
      {
        try
        {
          String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + g;
          c.b(str1);
          return str1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          System.out.println(localException.toString());
          return null;
        }
        String str2 = this.b.getFileStreamPath("") + File.separator + g;
      }
    }
  }
  
  public final void c()
  {
    if (this.c.decrementAndGet() == 0)
    {
      if (this.e != null) {
        this.e.close();
      }
      this.a.compareAndSet(true, false);
    }
  }
  
  static final class a
  {
    public static final a a = new a();
  }
  
  final class b
    extends ContextWrapper
  {
    public b(Context paramContext)
    {
      super();
    }
    
    public final SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      String str = a.this.b();
      if ((str == null) || (str.length() == 0)) {
        return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
      }
      return SQLiteDatabase.openOrCreateDatabase(str + paramString, null);
    }
    
    public final SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
    {
      String str = a.this.b();
      if ((str == null) || (str.length() == 0)) {
        return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
      }
      return SQLiteDatabase.openOrCreateDatabase(str + paramString, null);
    }
  }
  
  final class c
    extends SQLiteOpenHelper
  {
    private SQLiteDatabase a = null;
    
    public c(Context paramContext)
    {
      super("Cache.db", null, 1);
      if (Build.VERSION.SDK_INT > 10)
      {
        this.a.enableWriteAheadLogging();
        return;
      }
      this.a.setLockingEnabled(true);
    }
    
    private static void a(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + " (tile" + " TEXT PRIMARY KEY UNIQUE,version" + " TEXT,style" + " TEXT,md5" + " TEXT,data" + " BLOB )");
    }
    
    private static String b(MapTile.MapSource paramMapSource)
    {
      switch (a.1.a[paramMapSource.ordinal()])
      {
      default: 
        return "";
      case 2: 
        return "tct";
      case 1: 
        return "wmt";
      }
      return "stt";
    }
    
    private static String b(com.tencent.mapsdk.rastercore.tile.a parama)
    {
      switch (a.1.a[parama.m().ordinal()])
      {
      default: 
        return null;
      case 2: 
        return parama.d() + "-" + parama.b() + "-" + parama.c() + "-zh-" + parama.n();
      case 1: 
        return parama.d() + "-" + parama.b() + "-" + parama.c() + "-" + f.q() + "-" + parama.n();
      }
      return parama.d() + "-" + parama.b() + "-" + parama.c();
    }
    
    private boolean c(com.tencent.mapsdk.rastercore.tile.a parama)
    {
      localObject = null;
      Cursor localCursor = null;
      boolean bool2 = true;
      boolean bool1 = true;
      String str = b(parama);
      str = "select count(*) as ct from " + b(parama.m()) + " where " + "tile" + " = '" + str + "'";
      parama = localCursor;
      do
      {
        for (;;)
        {
          try
          {
            localCursor = this.a.rawQuery(str, null);
            if (localCursor == null) {
              continue;
            }
            parama = localCursor;
            localObject = localCursor;
            if (localCursor.getCount() <= 0) {
              continue;
            }
            parama = localCursor;
            localObject = localCursor;
            localCursor.moveToFirst();
            parama = localCursor;
            localObject = localCursor;
            int i = localCursor.getInt(localCursor.getColumnIndex("ct"));
            if (i <= 0) {
              continue;
            }
            bool2 = bool1;
            if (localCursor != null)
            {
              localCursor.close();
              bool2 = bool1;
            }
          }
          catch (Throwable localThrowable)
          {
            localObject = parama;
            new StringBuilder("tileExist error:").append(localThrowable.toString());
            if (parama == null) {
              continue;
            }
            parama.close();
            return true;
          }
          finally
          {
            if (localObject == null) {
              continue;
            }
            ((Cursor)localObject).close();
          }
          return bool2;
          bool1 = false;
        }
      } while (localCursor == null);
      localCursor.close();
      return true;
    }
    
    /* Error */
    public final b a(com.tencent.mapsdk.rastercore.tile.a parama)
    {
      // Byte code:
      //   0: new 174	com/tencent/mapsdk/rastercore/tile/a/b
      //   3: dup
      //   4: aconst_null
      //   5: invokestatic 177	com/tencent/mapsdk/rastercore/d/h:b	()I
      //   8: ldc 89
      //   10: invokespecial 180	com/tencent/mapsdk/rastercore/tile/a/b:<init>	([BILjava/lang/String;)V
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 18	com/tencent/mapsdk/rastercore/tile/a/a$c:a	Landroid/database/sqlite/SQLiteDatabase;
      //   18: ifnonnull +7 -> 25
      //   21: aload_2
      //   22: astore_1
      //   23: aload_1
      //   24: areturn
      //   25: new 42	java/lang/StringBuilder
      //   28: dup
      //   29: ldc 182
      //   31: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   34: aload_1
      //   35: invokevirtual 102	com/tencent/mapsdk/rastercore/tile/a:m	()Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
      //   38: invokestatic 135	com/tencent/mapsdk/rastercore/tile/a/a$c:b	(Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;)Ljava/lang/String;
      //   41: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: ldc 184
      //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: ldc 186
      //   51: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   57: astore_2
      //   58: aload_0
      //   59: getfield 18	com/tencent/mapsdk/rastercore/tile/a/a$c:a	Landroid/database/sqlite/SQLiteDatabase;
      //   62: aload_2
      //   63: iconst_1
      //   64: anewarray 188	java/lang/String
      //   67: dup
      //   68: iconst_0
      //   69: aload_1
      //   70: invokestatic 131	com/tencent/mapsdk/rastercore/tile/a/a$c:b	(Lcom/tencent/mapsdk/rastercore/tile/a;)Ljava/lang/String;
      //   73: aastore
      //   74: invokevirtual 147	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   77: astore_2
      //   78: aload_2
      //   79: ifnull +104 -> 183
      //   82: aload_2
      //   83: astore_1
      //   84: aload_2
      //   85: invokeinterface 152 1 0
      //   90: ifle +93 -> 183
      //   93: aload_2
      //   94: astore_1
      //   95: aload_2
      //   96: invokeinterface 155 1 0
      //   101: pop
      //   102: aload_2
      //   103: astore_1
      //   104: aload_2
      //   105: aload_2
      //   106: ldc 190
      //   108: invokeinterface 161 2 0
      //   113: invokeinterface 194 2 0
      //   118: astore_3
      //   119: aload_2
      //   120: astore_1
      //   121: aload_2
      //   122: aload_2
      //   123: ldc 196
      //   125: invokeinterface 161 2 0
      //   130: invokeinterface 200 2 0
      //   135: astore 4
      //   137: aload_2
      //   138: astore_1
      //   139: new 174	com/tencent/mapsdk/rastercore/tile/a/b
      //   142: dup
      //   143: aload_3
      //   144: aload 4
      //   146: invokestatic 203	com/tencent/mapsdk/rastercore/tile/a/a:a	([BLjava/lang/String;)[B
      //   149: aload_2
      //   150: aload_2
      //   151: ldc 205
      //   153: invokeinterface 161 2 0
      //   158: invokeinterface 165 2 0
      //   163: aload 4
      //   165: invokespecial 180	com/tencent/mapsdk/rastercore/tile/a/b:<init>	([BILjava/lang/String;)V
      //   168: astore_3
      //   169: aload_3
      //   170: astore_1
      //   171: aload_2
      //   172: ifnull -149 -> 23
      //   175: aload_2
      //   176: invokeinterface 168 1 0
      //   181: aload_3
      //   182: areturn
      //   183: aload_2
      //   184: ifnull +9 -> 193
      //   187: aload_2
      //   188: invokeinterface 168 1 0
      //   193: new 174	com/tencent/mapsdk/rastercore/tile/a/b
      //   196: dup
      //   197: aconst_null
      //   198: invokestatic 177	com/tencent/mapsdk/rastercore/d/h:b	()I
      //   201: ldc 89
      //   203: invokespecial 180	com/tencent/mapsdk/rastercore/tile/a/b:<init>	([BILjava/lang/String;)V
      //   206: areturn
      //   207: astore_3
      //   208: aconst_null
      //   209: astore_2
      //   210: aload_2
      //   211: astore_1
      //   212: new 42	java/lang/StringBuilder
      //   215: dup
      //   216: ldc 207
      //   218: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   221: aload_3
      //   222: invokevirtual 171	java/lang/Throwable:toString	()Ljava/lang/String;
      //   225: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: pop
      //   229: aload_2
      //   230: ifnull -37 -> 193
      //   233: aload_2
      //   234: invokeinterface 168 1 0
      //   239: goto -46 -> 193
      //   242: astore_2
      //   243: aconst_null
      //   244: astore_1
      //   245: aload_1
      //   246: ifnull +9 -> 255
      //   249: aload_1
      //   250: invokeinterface 168 1 0
      //   255: aload_2
      //   256: athrow
      //   257: astore_2
      //   258: goto -13 -> 245
      //   261: astore_3
      //   262: goto -52 -> 210
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	265	0	this	c
      //   0	265	1	parama	com.tencent.mapsdk.rastercore.tile.a
      //   13	221	2	localObject1	Object
      //   242	14	2	localObject2	Object
      //   257	1	2	localObject3	Object
      //   118	64	3	localObject4	Object
      //   207	15	3	localThrowable1	Throwable
      //   261	1	3	localThrowable2	Throwable
      //   135	29	4	str	String
      // Exception table:
      //   from	to	target	type
      //   58	78	207	java/lang/Throwable
      //   58	78	242	finally
      //   84	93	257	finally
      //   95	102	257	finally
      //   104	119	257	finally
      //   121	137	257	finally
      //   139	169	257	finally
      //   212	229	257	finally
      //   84	93	261	java/lang/Throwable
      //   95	102	261	java/lang/Throwable
      //   104	119	261	java/lang/Throwable
      //   121	137	261	java/lang/Throwable
      //   139	169	261	java/lang/Throwable
    }
    
    public final boolean a(MapTile.MapSource paramMapSource)
    {
      if (this.a == null) {
        return false;
      }
      paramMapSource = "delete  from " + b(paramMapSource);
      try
      {
        this.a.execSQL(paramMapSource);
        return true;
      }
      catch (Throwable paramMapSource)
      {
        new StringBuilder("cleanCache Error:").append(paramMapSource.toString());
      }
      return false;
    }
    
    public final boolean a(com.tencent.mapsdk.rastercore.tile.a parama, byte[] paramArrayOfByte)
    {
      if ((this.a == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
      for (;;)
      {
        return false;
        try
        {
          Object localObject = a.a(paramArrayOfByte);
          byte[] arrayOfByte = a.b(paramArrayOfByte, (String)localObject);
          paramArrayOfByte = new ContentValues();
          paramArrayOfByte.put("tile", b(parama));
          paramArrayOfByte.put("data", arrayOfByte);
          paramArrayOfByte.put("md5", (String)localObject);
          localObject = parama.m();
          if (localObject == MapTile.MapSource.WORLD) {
            paramArrayOfByte.put("style", Integer.valueOf(h.e()));
          }
          if (localObject == MapTile.MapSource.TENCENT) {
            paramArrayOfByte.put("style", Integer.valueOf(h.a()));
          }
          paramArrayOfByte.put("version", Integer.valueOf(parama.l()));
          long l = this.a.insert(b(parama.m()), null, paramArrayOfByte);
          if (l != -1L) {
            return true;
          }
        }
        catch (Throwable parama)
        {
          new StringBuilder("putBitmap Error:").append(parama.toString());
        }
      }
      return false;
    }
    
    public final boolean a(com.tencent.mapsdk.rastercore.tile.a parama, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      if (this.a == null) {}
      for (;;)
      {
        return false;
        try
        {
          ContentValues localContentValues = new ContentValues();
          String str1 = b(parama);
          localContentValues.put("version", Integer.valueOf(parama.l()));
          if ((!paramBoolean) && (paramArrayOfByte != null))
          {
            String str2 = a.a(paramArrayOfByte);
            paramArrayOfByte = a.b(paramArrayOfByte, str2);
            localContentValues.put("md5", str2);
            localContentValues.put("data", paramArrayOfByte);
          }
          int i = this.a.update(b(parama.m()), localContentValues, "tile = ? ", new String[] { str1 });
          if (i > 0) {
            return true;
          }
        }
        catch (Throwable parama)
        {
          new StringBuilder("updateBitmap Error:").append(parama.toString());
        }
      }
      return false;
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      a("tct", paramSQLiteDatabase);
      a("wmt", paramSQLiteDatabase);
      a("stt", paramSQLiteDatabase);
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS  tct");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS  wmt");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS  stt");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.a.a
 * JD-Core Version:    0.7.0.1
 */