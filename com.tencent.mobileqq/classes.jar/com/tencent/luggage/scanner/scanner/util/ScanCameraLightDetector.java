package com.tencent.luggage.scanner.scanner.util;

import android.os.HandlerThread;
import android.os.Message;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.sc.d;

public class ScanCameraLightDetector
{
  public static final ScanCameraLightDetector a = new ScanCameraLightDetector();
  private final int b = 2;
  private String c;
  private int d;
  private long e = -1L;
  private float f = -1.0F;
  private HandlerThread g;
  private s h;
  
  static
  {
    f.a("wmpfcommonjni", ScanCameraLightDetector.class.getClassLoader());
  }
  
  private void b()
  {
    o.d("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
    a();
    this.g = d.c("ScanCameraLightDetector_detectThread", 5);
    this.g.start();
    this.h = new ScanCameraLightDetector.1(this, this.g.getLooper());
  }
  
  private boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!af.a(paramArrayOfByte)) && (paramArrayOfByte.length > paramInt1 * paramInt2))
    {
      paramInt1 = calcLumNative(paramArrayOfByte, paramInt1, paramInt2);
      o.d("MicroMsg.ScanCameraLightDetector", "lum light: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 < 50) {
        return true;
      }
    }
    return false;
  }
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void a()
  {
    try
    {
      this.e = -1L;
      if (this.g != null)
      {
        this.g.quit();
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.ScanCameraLightDetector", localException, "stop error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.c = paramString;
      b();
      return;
    }
    catch (Exception paramString)
    {
      o.a("MicroMsg.ScanCameraLightDetector", paramString, "start error: %s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = this.e;
    if (((l < 0L) || (af.c(l) >= 1000L)) && (this.h != null))
    {
      Object localObject = this.g;
      if ((localObject != null) && (((HandlerThread)localObject).isAlive()))
      {
        localObject = new ScanCameraLightDetector.a(this, null);
        ((ScanCameraLightDetector.a)localObject).a = paramArrayOfByte;
        ((ScanCameraLightDetector.a)localObject).b = paramInt1;
        ((ScanCameraLightDetector.a)localObject).c = paramInt2;
        paramArrayOfByte = Message.obtain();
        paramArrayOfByte.what = 233;
        paramArrayOfByte.obj = localObject;
        this.h.b(paramArrayOfByte);
        this.e = af.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */