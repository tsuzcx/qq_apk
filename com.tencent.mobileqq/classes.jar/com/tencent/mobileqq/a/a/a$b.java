package com.tencent.mobileqq.a.a;

import com.tencent.mobileqq.msf.core.c.j.a;
import com.tencent.qphone.base.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a$b
  extends j.a
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
    Object localObject2 = this.a;
    Object localObject1 = Integer.valueOf(1);
    if (((AtomicBoolean)localObject2).compareAndSet(false, true))
    {
      parama = parama.toString();
      if (this.f == null) {
        this.f = new HashMap();
      }
      if (l - this.d > 300000L)
      {
        if (this.e > 10)
        {
          b();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("closeConnCount:");
          ((StringBuilder)localObject2).append(this.e);
          ((StringBuilder)localObject2).append(" ,reasonMap:");
          ((StringBuilder)localObject2).append(this.f.keySet());
          QLog.d("freqCloseConn", 1, ((StringBuilder)localObject2).toString());
        }
        this.e = 1;
        this.d = l;
        this.f.clear();
        this.f.put(parama, localObject1);
      }
      else
      {
        this.e += 1;
        if ((this.f.containsKey(parama)) && (this.f.get(parama) != null))
        {
          localObject1 = this.f;
          ((HashMap)localObject1).put(parama, Integer.valueOf(((Integer)((HashMap)localObject1).get(parama)).intValue() + 1));
        }
        else
        {
          this.f.put(parama, localObject1);
        }
      }
      this.a.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */