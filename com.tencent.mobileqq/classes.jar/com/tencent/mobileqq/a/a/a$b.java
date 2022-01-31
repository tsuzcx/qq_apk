package com.tencent.mobileqq.a.a;

import com.tencent.mobileqq.msf.core.c.k.a;
import com.tencent.qphone.base.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a$b
  extends k.a
{
  private static final String b = "freqCloseConn";
  private static final String c = "msf.event.freqCloseConn";
  volatile AtomicBoolean a = new AtomicBoolean(false);
  private long d = 0L;
  private int e = 0;
  private HashMap f = null;
  
  public static b a()
  {
    return a.b.a.a();
  }
  
  private void b()
  {
    a("closeConnCount", String.valueOf(this.e));
    a("closeConnReason", String.valueOf(this.f.keySet()));
    a("msf.event.freqCloseConn", true, 0L, this.e);
  }
  
  public void a(a parama)
  {
    long l = System.currentTimeMillis();
    if (this.a.compareAndSet(false, true))
    {
      parama = parama.toString();
      if (this.f == null) {
        this.f = new HashMap();
      }
      if (l - this.d <= 300000L) {
        break label147;
      }
      if (this.e > 10)
      {
        b();
        QLog.d("freqCloseConn", 1, "closeConnCount:" + this.e + " ,reasonMap:" + this.f.keySet());
      }
      this.e = 1;
      this.d = l;
      this.f.clear();
      this.f.put(parama, Integer.valueOf(1));
    }
    for (;;)
    {
      this.a.set(false);
      return;
      label147:
      this.e += 1;
      if ((this.f.containsKey(parama)) && (this.f.get(parama) != null)) {
        this.f.put(parama, Integer.valueOf(((Integer)this.f.get(parama)).intValue() + 1));
      } else {
        this.f.put(parama, Integer.valueOf(1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */