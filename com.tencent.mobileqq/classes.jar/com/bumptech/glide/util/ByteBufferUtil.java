package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil
{
  private static final AtomicReference<byte[]> a = new AtomicReference();
  
  /* Error */
  @NonNull
  public static ByteBuffer a(@NonNull java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 28	java/io/File:length	()J
    //   7: lstore_1
    //   8: lload_1
    //   9: ldc2_w 29
    //   12: lcmp
    //   13: ifgt +79 -> 92
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: ifeq +63 -> 82
    //   22: new 32	java/io/RandomAccessFile
    //   25: dup
    //   26: aload_0
    //   27: ldc 34
    //   29: invokespecial 37	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 41	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   37: astore_0
    //   38: aload_0
    //   39: getstatic 47	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   42: lconst_0
    //   43: lload_1
    //   44: invokevirtual 53	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   47: invokevirtual 59	java/nio/MappedByteBuffer:load	()Ljava/nio/MappedByteBuffer;
    //   50: astore 4
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 62	java/nio/channels/FileChannel:close	()V
    //   60: aload_3
    //   61: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   64: aload 4
    //   66: areturn
    //   67: astore 5
    //   69: aload_0
    //   70: astore 4
    //   72: aload 5
    //   74: astore_0
    //   75: goto +30 -> 105
    //   78: astore_0
    //   79: goto +26 -> 105
    //   82: new 22	java/io/IOException
    //   85: dup
    //   86: ldc 65
    //   88: invokespecial 68	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    //   92: new 22	java/io/IOException
    //   95: dup
    //   96: ldc 70
    //   98: invokespecial 68	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_3
    //   105: aload 4
    //   107: ifnull +11 -> 118
    //   110: aload 4
    //   112: invokevirtual 62	java/nio/channels/FileChannel:close	()V
    //   115: goto +3 -> 118
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: goto -69 -> 60
    //   132: astore_0
    //   133: aload 4
    //   135: areturn
    //   136: astore 4
    //   138: goto -20 -> 118
    //   141: astore_3
    //   142: goto -16 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramFile	java.io.File
    //   7	37	1	l	long
    //   32	91	3	localRandomAccessFile	java.io.RandomAccessFile
    //   141	1	3	localIOException1	java.io.IOException
    //   1	133	4	localObject1	Object
    //   136	1	4	localIOException2	java.io.IOException
    //   67	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	52	67	finally
    //   33	38	78	finally
    //   3	8	102	finally
    //   22	33	102	finally
    //   82	92	102	finally
    //   92	102	102	finally
    //   56	60	128	java/io/IOException
    //   60	64	132	java/io/IOException
    //   110	115	136	java/io/IOException
    //   122	126	141	java/io/IOException
  }
  
  /* Error */
  public static void a(@NonNull ByteBuffer paramByteBuffer, @NonNull java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokevirtual 79	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   5: pop
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore 4
    //   11: new 32	java/io/RandomAccessFile
    //   14: dup
    //   15: aload_1
    //   16: ldc 81
    //   18: invokespecial 37	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload 4
    //   24: astore_1
    //   25: aload_3
    //   26: invokevirtual 41	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: aload_0
    //   34: invokevirtual 85	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   37: pop
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: iconst_0
    //   42: invokevirtual 89	java/nio/channels/FileChannel:force	(Z)V
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: invokevirtual 62	java/nio/channels/FileChannel:close	()V
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   57: aload_2
    //   58: ifnull +7 -> 65
    //   61: aload_2
    //   62: invokevirtual 62	java/nio/channels/FileChannel:close	()V
    //   65: aload_3
    //   66: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   69: return
    //   70: astore_0
    //   71: aload_1
    //   72: astore_2
    //   73: aload_3
    //   74: astore_1
    //   75: goto +6 -> 81
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_2
    //   82: ifnull +10 -> 92
    //   85: aload_2
    //   86: invokevirtual 62	java/nio/channels/FileChannel:close	()V
    //   89: goto +3 -> 92
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: goto -38 -> 65
    //   106: astore_0
    //   107: return
    //   108: astore_2
    //   109: goto -17 -> 92
    //   112: astore_1
    //   113: goto -13 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramByteBuffer	ByteBuffer
    //   0	116	1	paramFile	java.io.File
    //   7	79	2	localObject1	Object
    //   108	1	2	localIOException	java.io.IOException
    //   21	53	3	localRandomAccessFile	java.io.RandomAccessFile
    //   9	14	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	30	70	finally
    //   32	38	70	finally
    //   40	45	70	finally
    //   47	51	70	finally
    //   53	57	70	finally
    //   11	22	78	finally
    //   61	65	102	java/io/IOException
    //   65	69	106	java/io/IOException
    //   85	89	108	java/io/IOException
    //   96	100	112	java/io/IOException
  }
  
  @NonNull
  public static byte[] a(@NonNull ByteBuffer paramByteBuffer)
  {
    Object localObject = c(paramByteBuffer);
    if ((localObject != null) && (((ByteBufferUtil.SafeArray)localObject).a == 0) && (((ByteBufferUtil.SafeArray)localObject).b == ((ByteBufferUtil.SafeArray)localObject).c.length)) {
      return paramByteBuffer.array();
    }
    paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
    localObject = new byte[paramByteBuffer.limit()];
    paramByteBuffer.position(0);
    paramByteBuffer.get((byte[])localObject);
    return localObject;
  }
  
  @NonNull
  public static InputStream b(@NonNull ByteBuffer paramByteBuffer)
  {
    return new ByteBufferUtil.ByteBufferStream(paramByteBuffer);
  }
  
  @Nullable
  private static ByteBufferUtil.SafeArray c(@NonNull ByteBuffer paramByteBuffer)
  {
    if ((!paramByteBuffer.isReadOnly()) && (paramByteBuffer.hasArray())) {
      return new ByteBufferUtil.SafeArray(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.limit());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.ByteBufferUtil
 * JD-Core Version:    0.7.0.1
 */