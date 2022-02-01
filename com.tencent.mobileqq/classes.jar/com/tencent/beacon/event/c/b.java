package com.tencent.beacon.event.c;

import com.tencent.beacon.base.net.b.c;
import com.tencent.beacon.base.net.b.c.a;
import com.tencent.beacon.event.EventBean;

public final class b
  extends c.a<EventBean, com.tencent.beacon.event.a.b>
{
  private final b.b a = new b.b();
  private final b.a b = new b.a();
  
  public static b a()
  {
    return new b();
  }
  
  public c<EventBean, com.tencent.beacon.event.a.b> b()
  {
    return this.b;
  }
  
  public c<com.tencent.beacon.event.a.b, EventBean> c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.c.b
 * JD-Core Version:    0.7.0.1
 */