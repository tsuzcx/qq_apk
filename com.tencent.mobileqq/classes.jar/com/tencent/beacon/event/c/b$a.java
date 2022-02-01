package com.tencent.beacon.event.c;

import com.tencent.beacon.base.net.b.c;
import com.tencent.beacon.event.EventBean;

final class b$a
  implements c<EventBean, com.tencent.beacon.event.a.b>
{
  public com.tencent.beacon.event.a.b a(EventBean paramEventBean)
  {
    com.tencent.beacon.event.a.b localb = new com.tencent.beacon.event.a.b();
    localb.b = paramEventBean.getEventTime();
    localb.d = paramEventBean.getAppKey();
    paramEventBean = com.tencent.beacon.base.util.b.a(paramEventBean);
    localb.e = paramEventBean;
    if (paramEventBean != null) {
      localb.c = paramEventBean.length;
    }
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.c.b.a
 * JD-Core Version:    0.7.0.1
 */