package com.tencent.beacon.a.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.beacon.a.b.a;
import com.tencent.beacon.a.b.d;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private final Object a = new Object();
  private FileChannel b;
  private JSONObject c = new JSONObject();
  private MappedByteBuffer d;
  private long e;
  private Runnable f;
  private boolean g;
  private boolean h;
  
  private g(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    this.b = paramFile.getChannel();
    this.e = paramFile.length();
    paramFile = new StringBuilder();
    paramFile.append("file size: ");
    paramFile.append(this.e);
    com.tencent.beacon.base.util.c.a("[properties]", paramFile.toString(), new Object[0]);
    f();
  }
  
  public static g a(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir(), "beacon");
    boolean bool;
    if (!paramContext.exists()) {
      bool = paramContext.mkdirs();
    } else {
      bool = true;
    }
    if (!bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mkdir ");
      localStringBuilder.append(paramContext.getName());
      localStringBuilder.append(" exception!");
      com.tencent.beacon.base.util.e.a(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("V1");
    return new g(new File(paramContext, localStringBuilder.toString()));
  }
  
  private void a(long paramLong)
  {
    if (paramLong <= 2097152L)
    {
      this.d.rewind();
      this.d = this.b.map(FileChannel.MapMode.READ_WRITE, 0L, paramLong);
      return;
    }
    throw new IllegalArgumentException("file size to reach maximum!");
  }
  
  private void a(Runnable paramRunnable)
  {
    a.a().a(new f(this, paramRunnable));
  }
  
  private byte[] a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.getInt(0);
    if ((i > 1) && (i <= 2097152) && (paramByteBuffer.capacity() > 10))
    {
      paramByteBuffer.position(10);
      byte[] arrayOfByte = new byte[i];
      paramByteBuffer.get(arrayOfByte, 0, i);
      return arrayOfByte;
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return com.tencent.beacon.base.net.c.c.b(3, "BEACONDEFAULTAES", paramArrayOfByte);
  }
  
  private static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = com.tencent.beacon.base.net.c.c.a(3, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.base.util.c.a(paramArrayOfByte);
      d locald = d.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unEncrypt error: key=");
      localStringBuilder.append(paramString);
      locald.a("513", localStringBuilder.toString(), paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = a(paramArrayOfByte, "BEACONDEFAULTAES");
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    arrayOfByte = a(paramArrayOfByte, com.tencent.beacon.a.c.f.p().e());
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    return a(paramArrayOfByte, "");
  }
  
  private Object c(@NonNull String paramString)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = localObject4;
    try
    {
      Object localObject5 = this.a;
      localObject1 = localObject4;
      localObject1 = localObject2;
      try
      {
        localObject2 = this.c.get(paramString);
        localObject1 = localObject2;
        return localObject2;
      }
      finally {}
    }
    catch (Exception localException)
    {
      label44:
      StringBuilder localStringBuilder;
      break label44;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("current jsonObject not exist key: ");
    localStringBuilder.append(paramString);
    com.tencent.beacon.base.util.c.a("[properties]", localStringBuilder.toString(), new Object[0]);
    return localObject1;
  }
  
  private boolean d()
  {
    if (this.g)
    {
      com.tencent.beacon.base.util.c.a("[properties]", "File is close!", new Object[0]);
      return true;
    }
    return false;
  }
  
  private Runnable e()
  {
    if (this.f == null) {
      this.f = new e(this);
    }
    return this.f;
  }
  
  private void f()
  {
    if (this.e <= 10L)
    {
      this.h = true;
      this.e = 4L;
    }
    this.d = this.b.map(FileChannel.MapMode.READ_WRITE, 0L, this.e);
    this.d.rewind();
    if (this.h)
    {
      this.d.putInt(0, 1);
      a(e());
      return;
    }
    byte[] arrayOfByte = a(this.d);
    if (arrayOfByte == null) {
      return;
    }
    try
    {
      arrayOfByte = b(arrayOfByte);
      this.c = new JSONObject(new String(arrayOfByte, "ISO8859-1"));
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init error");
      ((StringBuilder)localObject).append(localException.getMessage());
      com.tencent.beacon.base.util.c.a("[properties]", ((StringBuilder)localObject).toString(), new Object[0]);
      localObject = d.b();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[properties] init error! msg: ");
      localStringBuilder2.append(localException.getMessage());
      localStringBuilder2.append(". file size: ");
      localStringBuilder2.append(this.e);
      ((d)localObject).a("504", localStringBuilder2.toString(), localException);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("init json: ");
    localStringBuilder1.append(this.c.toString());
    com.tencent.beacon.base.util.c.a("[properties]", localStringBuilder1.toString(), new Object[0]);
  }
  
  public <T> T a(@NonNull String paramString, @NonNull T paramT)
  {
    try
    {
      boolean bool = d();
      if (bool) {
        return paramT;
      }
      Object localObject = c(paramString);
      paramString = localObject;
      if (localObject == null) {
        paramString = paramT;
      }
      return paramString;
    }
    finally {}
  }
  
  public <T> Set<T> a(@NonNull String paramString, @Nullable Set<T> paramSet)
  {
    try
    {
      boolean bool = d();
      if (bool) {
        return paramSet;
      }
      try
      {
        Object localObject1 = new HashSet();
        synchronized (this.a)
        {
          paramString = this.c.getJSONObject(paramString);
          if (paramString != null)
          {
            ??? = paramString.keys();
            while (((Iterator)???).hasNext()) {
              ((Set)localObject1).add(paramString.get((String)((Iterator)???).next()));
            }
          }
          bool = ((Set)localObject1).isEmpty();
          if (bool) {
            paramString = paramSet;
          } else {
            paramString = (String)localObject1;
          }
        }
        paramString = finally;
      }
      catch (JSONException paramString)
      {
        d.b().a("504", "[properties] JSON getSet error!", paramString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[properties] JSON get error!");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        com.tencent.beacon.base.util.c.b(((StringBuilder)localObject1).toString(), new Object[0]);
        paramString = paramSet;
        return paramString;
      }
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public void a()
  {
    try
    {
      this.c = new JSONObject();
      a(e());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.c.keys();
      if (localIterator != null) {
        while (localIterator.hasNext()) {
          if (paramString.equals(localIterator.next())) {
            return true;
          }
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public Map<String, ?> b()
  {
    synchronized (this.a)
    {
      if (this.c != null)
      {
        Iterator localIterator = this.c.keys();
        HashMap localHashMap = new HashMap();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            localHashMap.put(str, this.c.get(str));
          }
          catch (JSONException localJSONException)
          {
            com.tencent.beacon.base.util.c.a(localJSONException);
          }
        }
        return localHashMap;
      }
      return null;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/beacon/a/d/g:a	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 31	com/tencent/beacon/a/d/g:c	Lorg/json/JSONObject;
    //   13: aload_1
    //   14: invokevirtual 349	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: pop
    //   18: aload_2
    //   19: monitorexit
    //   20: aload_0
    //   21: aload_0
    //   22: invokespecial 255	com/tencent/beacon/a/d/g:e	()Ljava/lang/Runnable;
    //   25: invokespecial 256	com/tencent/beacon/a/d/g:a	(Ljava/lang/Runnable;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore_1
    //   32: aload_2
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	g
    //   0	41	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	20	31	finally
    //   32	34	31	finally
    //   2	9	36	finally
    //   20	28	36	finally
    //   34	36	36	finally
  }
  
  /* Error */
  public void b(@NonNull String paramString, @NonNull Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 285	com/tencent/beacon/a/d/g:d	()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 287	com/tencent/beacon/a/d/g:c	(Ljava/lang/String;)Ljava/lang/Object;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +17 -> 40
    //   26: aload 4
    //   28: aload_2
    //   29: invokevirtual 351	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   32: istore_3
    //   33: iload_3
    //   34: ifeq +6 -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_2
    //   41: instanceof 262
    //   44: ifeq +43 -> 87
    //   47: aload_2
    //   48: checkcast 262	java/lang/String
    //   51: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq +6 -> 62
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_2
    //   63: checkcast 262	java/lang/String
    //   66: invokestatic 360	com/tencent/beacon/base/util/f:b	(Ljava/lang/String;)Z
    //   69: istore_3
    //   70: iload_3
    //   71: ifne +16 -> 87
    //   74: ldc_w 362
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 330	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: aload_0
    //   88: getfield 26	com/tencent/beacon/a/d/g:a	Ljava/lang/Object;
    //   91: astore 4
    //   93: aload 4
    //   95: monitorenter
    //   96: aload_0
    //   97: getfield 31	com/tencent/beacon/a/d/g:c	Lorg/json/JSONObject;
    //   100: aload_1
    //   101: aload_2
    //   102: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 4
    //   108: monitorexit
    //   109: aload_0
    //   110: aload_0
    //   111: invokespecial 255	com/tencent/beacon/a/d/g:e	()Ljava/lang/Runnable;
    //   114: invokespecial 256	com/tencent/beacon/a/d/g:a	(Ljava/lang/Runnable;)V
    //   117: goto +59 -> 176
    //   120: astore_1
    //   121: aload 4
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: invokestatic 196	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   130: ldc_w 279
    //   133: ldc_w 367
    //   136: aload_1
    //   137: invokevirtual 203	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: new 52	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   147: astore_2
    //   148: aload_2
    //   149: ldc_w 367
    //   152: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: aload_1
    //   158: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 330	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	g
    //   0	184	1	paramString	String
    //   0	184	2	paramObject	Object
    //   6	65	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   96	109	120	finally
    //   121	124	120	finally
    //   14	21	126	java/lang/Exception
    //   26	33	126	java/lang/Exception
    //   40	55	126	java/lang/Exception
    //   62	70	126	java/lang/Exception
    //   74	84	126	java/lang/Exception
    //   87	96	126	java/lang/Exception
    //   109	117	126	java/lang/Exception
    //   124	126	126	java/lang/Exception
    //   2	7	179	finally
    //   14	21	179	finally
    //   26	33	179	finally
    //   40	55	179	finally
    //   62	70	179	finally
    //   74	84	179	finally
    //   87	96	179	finally
    //   109	117	179	finally
    //   124	126	179	finally
    //   127	176	179	finally
  }
  
  public <T> void b(@NonNull String paramString, @NonNull Set<T> paramSet)
  {
    for (;;)
    {
      try
      {
        boolean bool = d();
        if (bool) {
          return;
        }
      }
      finally
      {
        JSONObject localJSONObject;
        Iterator localIterator;
        int i;
        continue;
        throw paramString;
        continue;
        i += 1;
        continue;
      }
      try
      {
        localJSONObject = new JSONObject();
        localIterator = paramSet.iterator();
        i = 0;
        if (i < paramSet.size())
        {
          if (!localIterator.hasNext()) {
            continue;
          }
          localJSONObject.put(String.valueOf(i), localIterator.next());
          continue;
        }
        b(paramString, localJSONObject);
      }
      catch (JSONException paramString)
      {
        com.tencent.beacon.base.util.c.a(paramString);
        d.b().a("504", "[properties] JSON put set error!", paramString);
      }
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/beacon/a/d/g:a	Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 44	com/tencent/beacon/a/d/g:b	Ljava/nio/channels/FileChannel;
    //   17: invokevirtual 389	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   20: astore 4
    //   22: aload 4
    //   24: astore_2
    //   25: aload 4
    //   27: astore_3
    //   28: aload_0
    //   29: getfield 118	com/tencent/beacon/a/d/g:d	Ljava/nio/MappedByteBuffer;
    //   32: invokevirtual 392	java/nio/MappedByteBuffer:clear	()Ljava/nio/Buffer;
    //   35: pop
    //   36: aload 4
    //   38: astore_2
    //   39: aload 4
    //   41: astore_3
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 44	com/tencent/beacon/a/d/g:b	Ljava/nio/channels/FileChannel;
    //   47: getstatic 130	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   50: lconst_0
    //   51: aload_0
    //   52: getfield 44	com/tencent/beacon/a/d/g:b	Ljava/nio/channels/FileChannel;
    //   55: invokevirtual 394	java/nio/channels/FileChannel:size	()J
    //   58: invokevirtual 136	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   61: putfield 118	com/tencent/beacon/a/d/g:d	Ljava/nio/MappedByteBuffer;
    //   64: aload 4
    //   66: astore_2
    //   67: aload 4
    //   69: astore_3
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 118	com/tencent/beacon/a/d/g:d	Ljava/nio/MappedByteBuffer;
    //   75: invokespecial 258	com/tencent/beacon/a/d/g:a	(Ljava/nio/ByteBuffer;)[B
    //   78: invokestatic 260	com/tencent/beacon/a/d/g:b	([B)[B
    //   81: astore 6
    //   83: aload 4
    //   85: astore_2
    //   86: aload 4
    //   88: astore_3
    //   89: aload_0
    //   90: new 28	org/json/JSONObject
    //   93: dup
    //   94: new 262	java/lang/String
    //   97: dup
    //   98: aload 6
    //   100: ldc_w 264
    //   103: invokespecial 267	java/lang/String:<init>	([BLjava/lang/String;)V
    //   106: invokespecial 268	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: putfield 31	com/tencent/beacon/a/d/g:c	Lorg/json/JSONObject;
    //   112: aload 4
    //   114: ifnull +98 -> 212
    //   117: aload 4
    //   119: invokevirtual 399	java/nio/channels/FileLock:release	()V
    //   122: goto +90 -> 212
    //   125: astore_2
    //   126: goto +82 -> 208
    //   129: astore_3
    //   130: goto +86 -> 216
    //   133: astore 4
    //   135: aload_3
    //   136: astore_2
    //   137: aload_0
    //   138: getfield 247	com/tencent/beacon/a/d/g:h	Z
    //   141: istore_1
    //   142: iload_1
    //   143: ifne +54 -> 197
    //   146: aload_3
    //   147: astore_2
    //   148: new 52	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   155: astore 6
    //   157: aload_3
    //   158: astore_2
    //   159: aload 6
    //   161: ldc_w 401
    //   164: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_3
    //   169: astore_2
    //   170: aload 6
    //   172: aload 4
    //   174: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_3
    //   182: astore_2
    //   183: ldc 64
    //   185: aload 6
    //   187: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 73	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_3
    //   198: ifnull +14 -> 212
    //   201: aload_3
    //   202: invokevirtual 399	java/nio/channels/FileLock:release	()V
    //   205: goto +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   212: aload 5
    //   214: monitorexit
    //   215: return
    //   216: aload_2
    //   217: ifnull +15 -> 232
    //   220: aload_2
    //   221: invokevirtual 399	java/nio/channels/FileLock:release	()V
    //   224: goto +8 -> 232
    //   227: astore_2
    //   228: aload_2
    //   229: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   232: aload_3
    //   233: athrow
    //   234: astore_2
    //   235: aload 5
    //   237: monitorexit
    //   238: aload_2
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	g
    //   141	2	1	bool	boolean
    //   12	74	2	localObject1	Object
    //   125	1	2	localIOException1	java.io.IOException
    //   136	85	2	localObject2	Object
    //   227	2	2	localIOException2	java.io.IOException
    //   234	5	2	localObject3	Object
    //   10	79	3	localObject4	Object
    //   129	104	3	localObject5	Object
    //   20	98	4	localFileLock	java.nio.channels.FileLock
    //   133	40	4	localException	Exception
    //   4	232	5	localObject6	Object
    //   81	105	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	122	125	java/io/IOException
    //   201	205	125	java/io/IOException
    //   13	22	129	finally
    //   28	36	129	finally
    //   42	64	129	finally
    //   70	83	129	finally
    //   89	112	129	finally
    //   137	142	129	finally
    //   148	157	129	finally
    //   159	168	129	finally
    //   170	181	129	finally
    //   183	197	129	finally
    //   13	22	133	java/lang/Exception
    //   28	36	133	java/lang/Exception
    //   42	64	133	java/lang/Exception
    //   70	83	133	java/lang/Exception
    //   89	112	133	java/lang/Exception
    //   220	224	227	java/io/IOException
    //   117	122	234	finally
    //   201	205	234	finally
    //   208	212	234	finally
    //   212	215	234	finally
    //   220	224	234	finally
    //   228	232	234	finally
    //   232	234	234	finally
    //   235	238	234	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.d.g
 * JD-Core Version:    0.7.0.1
 */