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
  private BufferedInputStream a;
  private BufferedInputStream b;
  private ByteArrayOutputStream c;
  private boolean d = true;
  private boolean e = true;
  private final WeakReference<BridgeStream.IBridgeStreamCallback> f;
  
  public BridgeStream(BridgeStream.IBridgeStreamCallback paramIBridgeStreamCallback, ByteArrayOutputStream paramByteArrayOutputStream, BufferedInputStream paramBufferedInputStream)
  {
    if (paramBufferedInputStream != null)
    {
      this.a = paramBufferedInputStream;
      this.d = false;
    }
    if (paramByteArrayOutputStream != null)
    {
      this.c = paramByteArrayOutputStream;
      this.b = new BufferedInputStream(new ByteArrayInputStream(paramByteArrayOutputStream.toByteArray()));
      this.e = false;
    }
    else
    {
      this.c = new ByteArrayOutputStream();
    }
    this.f = new WeakReference(paramIBridgeStreamCallback);
  }
  
  @TargetApi(9)
  public void close()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("close: memory stream and socket stream, netStreamReadComplete=");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", memStreamReadComplete=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("[cmshow]Apollo_client_BridgeStream", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          this.b.close();
          this.b = null;
        }
        if (this.a != null)
        {
          this.a.close();
          this.a = null;
        }
        localObject = (BridgeStream.IBridgeStreamCallback)this.f.get();
        if (localObject != null)
        {
          if ((this.d) && (this.e))
          {
            bool = true;
            ((BridgeStream.IBridgeStreamCallback)localObject).a(bool, this.c);
          }
        }
        else
        {
          this.c = null;
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
    //   3: getfield 46	com/tencent/mobileqq/apollo/store/webview/BridgeStream:b	Ljava/io/BufferedInputStream;
    //   6: ifnull +152 -> 158
    //   9: aload_0
    //   10: getfield 24	com/tencent/mobileqq/apollo/store/webview/BridgeStream:e	Z
    //   13: ifne +145 -> 158
    //   16: aload_0
    //   17: getfield 46	com/tencent/mobileqq/apollo/store/webview/BridgeStream:b	Ljava/io/BufferedInputStream;
    //   20: invokevirtual 118	java/io/BufferedInputStream:read	()I
    //   23: istore_1
    //   24: goto +3 -> 27
    //   27: iload_1
    //   28: istore_2
    //   29: iconst_m1
    //   30: iload_1
    //   31: if_icmpne +55 -> 86
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 24	com/tencent/mobileqq/apollo/store/webview/BridgeStream:e	Z
    //   39: iload_1
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 26	com/tencent/mobileqq/apollo/store/webview/BridgeStream:a	Ljava/io/BufferedInputStream;
    //   45: ifnull +41 -> 86
    //   48: iload_1
    //   49: istore_2
    //   50: aload_0
    //   51: getfield 22	com/tencent/mobileqq/apollo/store/webview/BridgeStream:d	Z
    //   54: ifne +32 -> 86
    //   57: aload_0
    //   58: getfield 26	com/tencent/mobileqq/apollo/store/webview/BridgeStream:a	Ljava/io/BufferedInputStream;
    //   61: invokevirtual 118	java/io/BufferedInputStream:read	()I
    //   64: istore_2
    //   65: iconst_m1
    //   66: iload_2
    //   67: if_icmpeq +14 -> 81
    //   70: aload_0
    //   71: getfield 28	com/tencent/mobileqq/apollo/store/webview/BridgeStream:c	Ljava/io/ByteArrayOutputStream;
    //   74: iload_2
    //   75: invokevirtual 122	java/io/ByteArrayOutputStream:write	(I)V
    //   78: goto +8 -> 86
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 22	com/tencent/mobileqq/apollo/store/webview/BridgeStream:d	Z
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_2
    //   89: ireturn
    //   90: astore_3
    //   91: goto +63 -> 154
    //   94: astore_3
    //   95: new 69	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   102: astore 4
    //   104: aload 4
    //   106: ldc 124
    //   108: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 4
    //   114: aload_3
    //   115: invokevirtual 106	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 83
    //   124: iconst_2
    //   125: aload 4
    //   127: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_3
    //   134: instanceof 110
    //   137: ifeq +8 -> 145
    //   140: aload_3
    //   141: checkcast 110	java/io/IOException
    //   144: athrow
    //   145: new 110	java/io/IOException
    //   148: dup
    //   149: aload_3
    //   150: invokespecial 113	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.BridgeStream
 * JD-Core Version:    0.7.0.1
 */