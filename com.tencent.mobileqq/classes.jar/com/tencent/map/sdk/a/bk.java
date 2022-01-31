package com.tencent.map.sdk.a;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public final class bk
  extends bp
{
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, Object paramObject, bp.a parama, int paramInt2)
  {
    long l = SystemClock.elapsedRealtime();
    this.b = parama;
    this.a = paramObject;
    parama = new HashMap();
    parama.put("B-Length", String.valueOf(paramInt1));
    if (paramInt2 == 1) {
      paramObject = "devlog";
    }
    for (;;)
    {
      parama.put("HLReportCmd", paramObject);
      paramArrayOfByte = be.a("https://up-hl.3g.qq.com/upreport", parama, paramArrayOfByte, 20000, dg.d());
      paramArrayOfByte.o = false;
      paramArrayOfByte.p = "event";
      paramArrayOfByte = new bl(this, paramArrayOfByte, l);
      try
      {
        as.a.a().a.execute(paramArrayOfByte);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        this.b.a(false, this.a);
      }
      if (paramBoolean) {
        paramObject = "realtime_speed";
      } else {
        paramObject = "hllog";
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bk
 * JD-Core Version:    0.7.0.1
 */