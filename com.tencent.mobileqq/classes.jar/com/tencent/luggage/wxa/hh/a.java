package com.tencent.luggage.wxa.hh;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class a
{
  private final MediaExtractor a = new MediaExtractor();
  
  public int a(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    return this.a.readSampleData(paramByteBuffer, paramInt);
  }
  
  @NonNull
  public MediaFormat a(int paramInt)
  {
    return this.a.getTrackFormat(paramInt);
  }
  
  public final void a()
  {
    this.a.release();
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.a.seekTo(paramLong, paramInt);
  }
  
  public final void a(@NonNull String paramString)
  {
    a(paramString, null);
  }
  
  /* Error */
  public final void a(@NonNull String paramString, @androidx.annotation.Nullable java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 52	com/tencent/luggage/wxa/rt/k:c	(Ljava/lang/String;Z)Ljava/lang/String;
    //   5: ifnull +66 -> 71
    //   8: aload_0
    //   9: getfield 18	com/tencent/luggage/wxa/hh/a:a	Landroid/media/MediaExtractor;
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 55	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   17: return
    //   18: astore_3
    //   19: new 57	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: ldc 60
    //   32: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: aload_1
    //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: ldc 66
    //   47: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 4
    //   53: aload_3
    //   54: invokevirtual 70	java/io/IOException:getMessage	()Ljava/lang/String;
    //   57: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 72
    //   63: aload 4
    //   65: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 81	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_1
    //   72: ldc 83
    //   74: invokestatic 86	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   77: astore 5
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_0
    //   82: getfield 18	com/tencent/luggage/wxa/hh/a:a	Landroid/media/MediaExtractor;
    //   85: aload 5
    //   87: invokevirtual 92	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   90: invokevirtual 95	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   93: aload 5
    //   95: ifnull +8 -> 103
    //   98: aload 5
    //   100: invokevirtual 98	android/os/ParcelFileDescriptor:close	()V
    //   103: return
    //   104: astore 4
    //   106: goto +11 -> 117
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: aload 4
    //   116: athrow
    //   117: aload 5
    //   119: ifnull +20 -> 139
    //   122: aload_3
    //   123: ifnull +11 -> 134
    //   126: aload 5
    //   128: invokevirtual 98	android/os/ParcelFileDescriptor:close	()V
    //   131: goto +8 -> 139
    //   134: aload 5
    //   136: invokevirtual 98	android/os/ParcelFileDescriptor:close	()V
    //   139: aload 4
    //   141: athrow
    //   142: astore_3
    //   143: new 57	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   150: astore 4
    //   152: aload 4
    //   154: ldc 100
    //   156: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: aload_1
    //   163: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 4
    //   169: ldc 66
    //   171: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 4
    //   177: aload_3
    //   178: invokevirtual 70	java/io/IOException:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 72
    //   187: aload 4
    //   189: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 81	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_0
    //   196: getfield 18	com/tencent/luggage/wxa/hh/a:a	Landroid/media/MediaExtractor;
    //   199: aload_1
    //   200: aload_2
    //   201: invokevirtual 55	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   204: return
    //   205: astore_3
    //   206: goto -67 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	a
    //   0	209	1	paramString	String
    //   0	209	2	paramMap	java.util.Map<String, String>
    //   18	36	3	localIOException1	java.io.IOException
    //   80	43	3	localObject1	Object
    //   142	36	3	localIOException2	java.io.IOException
    //   205	1	3	localThrowable1	java.lang.Throwable
    //   26	38	4	localStringBuilder1	java.lang.StringBuilder
    //   104	1	4	localObject2	Object
    //   109	31	4	localThrowable2	java.lang.Throwable
    //   150	38	4	localStringBuilder2	java.lang.StringBuilder
    //   77	58	5	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    // Exception table:
    //   from	to	target	type
    //   8	17	18	java/io/IOException
    //   81	93	104	finally
    //   114	117	104	finally
    //   81	93	109	java/lang/Throwable
    //   71	79	142	java/io/IOException
    //   98	103	142	java/io/IOException
    //   126	131	142	java/io/IOException
    //   134	139	142	java/io/IOException
    //   139	142	142	java/io/IOException
    //   126	131	205	java/lang/Throwable
  }
  
  public final int b()
  {
    return this.a.getTrackCount();
  }
  
  public void b(int paramInt)
  {
    this.a.selectTrack(paramInt);
  }
  
  public boolean c()
  {
    return this.a.advance();
  }
  
  public long d()
  {
    return this.a.getSampleTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hh.a
 * JD-Core Version:    0.7.0.1
 */