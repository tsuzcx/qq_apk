package com.tencent.mobileqq.apollo.store.webview;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class BridgeStream
  extends InputStream
{
  private BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private final WeakReference<BridgeStream.IBridgeStreamCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private BufferedInputStream jdField_b_of_type_JavaIoBufferedInputStream;
  private boolean jdField_b_of_type_Boolean = true;
  
  public BridgeStream(BridgeStream.IBridgeStreamCallback paramIBridgeStreamCallback, ByteArrayOutputStream paramByteArrayOutputStream, BufferedInputStream paramBufferedInputStream)
  {
    if (paramBufferedInputStream != null)
    {
      this.jdField_a_of_type_JavaIoBufferedInputStream = paramBufferedInputStream;
      this.jdField_a_of_type_Boolean = false;
    }
    if (paramByteArrayOutputStream != null)
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = paramByteArrayOutputStream;
      this.jdField_b_of_type_JavaIoBufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(paramByteArrayOutputStream.toByteArray()));
      this.jdField_b_of_type_Boolean = false;
    }
    else
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIBridgeStreamCallback);
  }
  
  @TargetApi(9)
  public void close()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("close: memory stream and socket stream, netStreamReadComplete=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", memStreamReadComplete=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("[cmshow]Apollo_client_BridgeStream", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaIoBufferedInputStream != null)
        {
          this.jdField_b_of_type_JavaIoBufferedInputStream.close();
          this.jdField_b_of_type_JavaIoBufferedInputStream = null;
        }
        if (this.jdField_a_of_type_JavaIoBufferedInputStream != null)
        {
          this.jdField_a_of_type_JavaIoBufferedInputStream.close();
          this.jdField_a_of_type_JavaIoBufferedInputStream = null;
        }
        localObject = (BridgeStream.IBridgeStreamCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
          {
            bool = true;
            ((BridgeStream.IBridgeStreamCallback)localObject).a(bool, this.jdField_a_of_type_JavaIoByteArrayOutputStream);
          }
        }
        else
        {
          this.jdField_a_of_type_JavaIoByteArrayOutputStream = null;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("close error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("[cmshow]Apollo_client_BridgeStream", 2, localStringBuilder.toString());
        if ((localThrowable instanceof IOException)) {
          throw ((IOException)localThrowable);
        }
        throw new IOException(localThrowable);
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  @TargetApi(9)
  public int read()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   6: ifnull +152 -> 158
    //   9: aload_0
    //   10: getfield 20	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_Boolean	Z
    //   13: ifne +145 -> 158
    //   16: aload_0
    //   17: getfield 42	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   20: invokevirtual 116	java/io/BufferedInputStream:read	()I
    //   23: istore_1
    //   24: goto +3 -> 27
    //   27: iload_1
    //   28: istore_2
    //   29: iconst_m1
    //   30: iload_1
    //   31: if_icmpne +55 -> 86
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 20	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_Boolean	Z
    //   39: iload_1
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 22	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   45: ifnull +41 -> 86
    //   48: iload_1
    //   49: istore_2
    //   50: aload_0
    //   51: getfield 18	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_Boolean	Z
    //   54: ifne +32 -> 86
    //   57: aload_0
    //   58: getfield 22	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   61: invokevirtual 116	java/io/BufferedInputStream:read	()I
    //   64: istore_2
    //   65: iconst_m1
    //   66: iload_2
    //   67: if_icmpeq +14 -> 81
    //   70: aload_0
    //   71: getfield 24	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoByteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
    //   74: iload_2
    //   75: invokevirtual 120	java/io/ByteArrayOutputStream:write	(I)V
    //   78: goto +8 -> 86
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 18	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_Boolean	Z
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_2
    //   89: ireturn
    //   90: astore_3
    //   91: goto +63 -> 154
    //   94: astore_3
    //   95: new 65	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   102: astore 4
    //   104: aload 4
    //   106: ldc 122
    //   108: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 4
    //   114: aload_3
    //   115: invokevirtual 103	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 79
    //   124: iconst_2
    //   125: aload 4
    //   127: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_3
    //   134: instanceof 108
    //   137: ifeq +8 -> 145
    //   140: aload_3
    //   141: checkcast 108	java/io/IOException
    //   144: athrow
    //   145: new 108	java/io/IOException
    //   148: dup
    //   149: aload_3
    //   150: invokespecial 111	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   153: athrow
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_3
    //   157: athrow
    //   158: iconst_m1
    //   159: istore_1
    //   160: goto -133 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	BridgeStream
    //   23	137	1	i	int
    //   28	61	2	j	int
    //   90	1	3	localObject	Object
    //   94	63	3	localThrowable	Throwable
    //   102	24	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	24	90	finally
    //   34	39	90	finally
    //   41	48	90	finally
    //   50	65	90	finally
    //   70	78	90	finally
    //   81	86	90	finally
    //   95	145	90	finally
    //   145	154	90	finally
    //   2	24	94	java/lang/Throwable
    //   34	39	94	java/lang/Throwable
    //   41	48	94	java/lang/Throwable
    //   50	65	94	java/lang/Throwable
    //   70	78	94	java/lang/Throwable
    //   81	86	94	java/lang/Throwable
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
  {
    try
    {
      int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
      return i;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      int i = paramArrayOfByte.length;
      if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= i) && (i - paramInt1 >= paramInt2))
      {
        i = 0;
        while (i < paramInt2) {
          try
          {
            int j = read();
            if (j == -1)
            {
              paramInt1 = i;
              if (i == 0) {
                paramInt1 = -1;
              }
              return paramInt1;
            }
            paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
            i += 1;
          }
          catch (IOException paramArrayOfByte)
          {
            if (i != 0) {
              return i;
            }
            throw paramArrayOfByte;
          }
        }
        return paramInt2;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    finally {}
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.BridgeStream
 * JD-Core Version:    0.7.0.1
 */