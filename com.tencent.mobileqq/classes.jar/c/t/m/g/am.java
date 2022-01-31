package c.t.m.g;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public final class am
  extends ar
{
  public final boolean a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, Object paramObject, ar.a parama)
  {
    long l = SystemClock.elapsedRealtime();
    this.b = parama;
    this.a = paramObject;
    parama = new HashMap();
    parama.put("B-Length", paramInt);
    if (paramBoolean) {}
    for (paramObject = "realtime_speed";; paramObject = "hllog")
    {
      parama.put("HLReportCmd", paramObject);
      paramArrayOfByte = ag.a("https://up-hl.3g.qq.com/upreport", parama, paramArrayOfByte, 20000, ch.d(), null);
      paramArrayOfByte.o = false;
      paramArrayOfByte.a("event");
      paramArrayOfByte = new an(this, paramArrayOfByte, l);
      try
      {
        x.a.a().a.execute(paramArrayOfByte);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        this.b.a(false, this.a);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.am
 * JD-Core Version:    0.7.0.1
 */