package com.tencent.beacon.event.c;

import com.tencent.beacon.base.net.b.c;
import com.tencent.beacon.event.EventBean;

final class b$b
  implements c<com.tencent.beacon.event.a.b, EventBean>
{
  public EventBean a(com.tencent.beacon.event.a.b paramb)
  {
    Object localObject = com.tencent.beacon.base.util.b.a(paramb.e);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof EventBean))
    {
      localObject = (EventBean)localObject;
      ((EventBean)localObject).setCid(paramb.a);
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.c.b.b
 * JD-Core Version:    0.7.0.1
 */