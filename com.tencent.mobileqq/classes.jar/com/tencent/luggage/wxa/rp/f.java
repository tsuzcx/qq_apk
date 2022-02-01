package com.tencent.luggage.wxa.rp;

import com.tencent.luggage.wxa.rl.b;

public class f
{
  private volatile d a;
  private volatile f.a b;
  
  public f(d paramd, f.a parama)
  {
    a(paramd);
    a(parama);
  }
  
  private void a(f.a parama)
  {
    this.b = parama;
  }
  
  private void b(b paramb, Object paramObject, long paramLong, boolean paramBoolean)
  {
    try
    {
      Object localObject2 = this.a;
      Object localObject1 = localObject2;
      if ((paramb instanceof e))
      {
        e locale = (e)paramb;
        localObject1 = localObject2;
        if (!"Vending.ANY".equals(locale.a())) {
          localObject1 = g.b(locale.a());
        }
      }
      if (localObject1 == null)
      {
        if (this.b != null) {
          this.b.b();
        }
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("object is not right: ");
      ((StringBuilder)localObject2).append(paramObject);
      paramb = new f.1(this, paramb, paramObject, new RuntimeException(((StringBuilder)localObject2).toString()));
      if (paramLong < 0L)
      {
        if ((paramBoolean) && (g.a() == localObject1)) {
          paramb.run();
        } else {
          ((d)localObject1).a(paramb);
        }
      }
      else {
        ((d)localObject1).a(paramb, paramLong);
      }
      return;
    }
    finally {}
  }
  
  private void b(d paramd)
  {
    this.a = paramd;
  }
  
  public void a(b paramb, Object paramObject, long paramLong, boolean paramBoolean)
  {
    b(paramb, paramObject, paramLong, paramBoolean);
  }
  
  public void a(b paramb, Object paramObject, boolean paramBoolean)
  {
    a(paramb, paramObject, -1L, paramBoolean);
  }
  
  public void a(d paramd)
  {
    try
    {
      b(paramd);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rp.f
 * JD-Core Version:    0.7.0.1
 */