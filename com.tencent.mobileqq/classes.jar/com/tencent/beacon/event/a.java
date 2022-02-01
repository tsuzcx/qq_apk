package com.tencent.beacon.event;

import com.tencent.beacon.a.b.d;

class a
  implements Runnable
{
  a(b paramb, EventBean paramEventBean) {}
  
  public void run()
  {
    if (b.a(this.b).a(this.a.getEventType()))
    {
      d locald = d.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("type: ");
      localStringBuilder.append(com.tencent.beacon.event.c.c.a(this.a.getEventType()));
      localStringBuilder.append(" max db count!");
      locald.a("602", localStringBuilder.toString());
      com.tencent.beacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB false. reason: DB count max!", new Object[] { this.a.getEventCode() });
      return;
    }
    boolean bool = b.a(this.b).a(this.a);
    com.tencent.beacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB %s", new Object[] { this.a.getEventCode(), Boolean.valueOf(bool) });
    if (bool) {
      this.b.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.a
 * JD-Core Version:    0.7.0.1
 */