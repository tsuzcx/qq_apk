package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

final class eq
{
  final LinkedBlockingQueue<eq.a> a;
  final ea b;
  long c;
  long d;
  long e;
  long f;
  volatile boolean g;
  long h;
  
  eq(ea paramea)
  {
    this.b = paramea;
    this.a = new LinkedBlockingQueue(3);
  }
  
  static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TencentLogImpl.isDebugEnabled()) && (paramArrayOfByte != null)) {}
    try
    {
      if (e.o(paramArrayOfByte, 1) < 0) {
        return eh.a(paramInt, 0);
      }
      paramArrayOfByte = eh.a(paramInt, 1);
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  private static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 59	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: aload_0
    //   5: arraylength
    //   6: invokespecial 60	java/io/ByteArrayOutputStream:<init>	(I)V
    //   9: astore_1
    //   10: new 62	java/util/zip/GZIPOutputStream
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 65	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: aload_0
    //   21: invokevirtual 69	java/util/zip/GZIPOutputStream:write	([B)V
    //   24: aload_2
    //   25: invokevirtual 72	java/util/zip/GZIPOutputStream:close	()V
    //   28: aload_1
    //   29: invokevirtual 76	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   32: astore_0
    //   33: aload_1
    //   34: invokevirtual 77	java/io/ByteArrayOutputStream:close	()V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_1
    //   52: invokevirtual 81	java/lang/Error:printStackTrace	()V
    //   55: aload_0
    //   56: areturn
    //   57: astore_1
    //   58: goto -7 -> 51
    //   61: astore_1
    //   62: goto -20 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramArrayOfByte	byte[]
    //   9	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   39	4	1	localException1	Exception
    //   48	4	1	localError1	Error
    //   57	1	1	localError2	Error
    //   61	1	1	localException2	Exception
    //   18	7	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	33	39	java/lang/Exception
    //   0	33	48	java/lang/Error
    //   33	37	57	java/lang/Error
    //   33	37	61	java/lang/Exception
  }
  
  private void b()
  {
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
  }
  
  public final void a()
  {
    if (!this.g) {
      return;
    }
    this.g = false;
    this.a.clear();
    this.a.offer(eq.a.d);
    this.h = 0L;
    if (this.f != 0L)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.f;
      String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[] { Long.valueOf((l1 - l2) / 1000L), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.c) });
    }
    b();
  }
  
  final void a(eq.a parama)
  {
    eq.a.d(parama);
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (eq.a.c((eq.a)localIterator.next()) != eq.a.c(parama));
    for (int i = 1;; i = 0)
    {
      if ((eq.a.e(parama) > 0) && (i == 0) && (eq.a.c(parama) != 2))
      {
        new StringBuilder("retryIfNeed: times=").append(eq.a.e(parama));
        this.a.offer(parama);
      }
      return;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = a(paramString.getBytes("UTF-8"));
      e.o((byte[])localObject, 2);
      localObject = new eq.a(2, (byte[])localObject, "https://ue.indoorloc.map.qq.com/", null);
      ((eq.a)localObject).b = paramString;
      if (eq.a.a((eq.a)localObject) != null)
      {
        this.a.offer(localObject);
        return;
      }
    }
    catch (Exception paramString) {}catch (Error paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.eq
 * JD-Core Version:    0.7.0.1
 */