package c.t.m.g;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public final class ar
  extends ax
{
  public final boolean a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, Object paramObject, ax.a parama)
  {
    long l = SystemClock.elapsedRealtime();
    this.b = parama;
    this.a = paramObject;
    parama = new HashMap();
    parama.put("B-Length", String.valueOf(paramInt));
    if (paramBoolean) {}
    for (paramObject = "realtime_speed";; paramObject = "hllog")
    {
      parama.put("HLReportCmd", paramObject);
      paramArrayOfByte = al.a("https://up-hl.3g.qq.com/upreport", parama, paramArrayOfByte, 20000, cn.d());
      paramArrayOfByte.o = false;
      paramArrayOfByte.q = "event";
      paramArrayOfByte = new as(this, paramArrayOfByte, l);
      try
      {
        aa.a.a().a.execute(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.ar
 * JD-Core Version:    0.7.0.1
 */