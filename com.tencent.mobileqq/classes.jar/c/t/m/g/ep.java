package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.GZIPOutputStream;

final class ep
{
  final LinkedBlockingQueue<ep.a> a;
  final ea b;
  long c;
  long d;
  long e;
  long f;
  volatile boolean g;
  long h;
  
  ep(ea paramea)
  {
    this.b = paramea;
    this.a = new LinkedBlockingQueue(3);
  }
  
  static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TencentLogImpl.isDebugEnabled()) && (paramArrayOfByte != null)) {}
    try
    {
      if (e.o(paramArrayOfByte, 1) >= 0) {
        return eg.a(paramInt, 1);
      }
      paramArrayOfByte = eg.a(paramInt, 0);
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      label35:
      break label35;
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject1 = localObject3;
      localObject2 = localObject4;
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localGZIPOutputStream.close();
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localObject2 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Error paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return localObject1;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localObject2;
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
    this.a.offer(ep.a.e);
    this.h = 0L;
    if (this.f != 0L)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.f;
      String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[] { Long.valueOf((l1 - l2) / 1000L), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.c) });
    }
    b();
  }
  
  final void a(ep.a parama)
  {
    ep.a.e(parama);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (ep.a.b((ep.a)localIterator.next()) == ep.a.b(parama))
      {
        i = 1;
        break label48;
      }
    }
    int i = 0;
    label48:
    if ((ep.a.f(parama) > 0) && (i == 0) && (ep.a.b(parama) != 2))
    {
      new StringBuilder("retryIfNeed: times=").append(ep.a.f(parama));
      this.a.offer(parama);
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
      localObject = new ep.a(2, (byte[])localObject, "https://ue.indoorloc.map.qq.com/", null);
      ((ep.a)localObject).b = paramString;
      if (ep.a.a((ep.a)localObject) != null) {
        this.a.offer(localObject);
      }
      return;
    }
    catch (Exception|Error paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ep
 * JD-Core Version:    0.7.0.1
 */