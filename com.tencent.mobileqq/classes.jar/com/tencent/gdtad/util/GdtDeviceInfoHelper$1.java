package com.tencent.gdtad.util;

import yny;
import you;
import yow;
import yoy;

public final class GdtDeviceInfoHelper$1
  implements Runnable
{
  public GdtDeviceInfoHelper$1(long paramLong) {}
  
  public void run()
  {
    yny.b(yoy.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread delayMillis:%d count:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(yoy.a()) }));
    if (yoy.a() >= 5) {}
    int i;
    label212:
    do
    {
      return;
      try
      {
        if (yoy.a() >= 5) {
          return;
        }
      }
      finally {}
      yoy.a(yoy.a() + 1);
      yow localyow = you.a().a();
      i = yoy.a(localyow);
      if (localyow != null) {
        yny.b(yoy.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localyow.jdField_a_of_type_Int), Long.valueOf(localyow.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        if ((localyow == null) || (localyow.jdField_a_of_type_Long == 0L)) {
          break;
        }
        long l = localyow.jdField_a_of_type_Long * 1000L - System.currentTimeMillis() + 1000L;
        if (l <= 0L) {
          break;
        }
        yoy.a(l);
        return;
        yny.b(yoy.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
    } while (i != 3);
    yoy.a(1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */