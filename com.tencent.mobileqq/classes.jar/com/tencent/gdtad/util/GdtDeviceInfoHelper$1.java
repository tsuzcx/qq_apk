package com.tencent.gdtad.util;

import aanp;
import aaoj;
import aaom;
import aaoo;

public final class GdtDeviceInfoHelper$1
  implements Runnable
{
  public GdtDeviceInfoHelper$1(long paramLong) {}
  
  public void run()
  {
    aanp.b(aaoo.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread delayMillis:%d count:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(aaoo.a()) }));
    if (aaoo.a() >= 5) {}
    int i;
    label212:
    do
    {
      return;
      try
      {
        if (aaoo.a() >= 5) {
          return;
        }
      }
      finally {}
      aaoo.a(aaoo.a() + 1);
      aaom localaaom = aaoj.a().a();
      i = aaoo.a(localaaom);
      if (localaaom != null) {
        aanp.b(aaoo.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localaaom.jdField_a_of_type_Int), Long.valueOf(localaaom.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        if ((localaaom == null) || (localaaom.jdField_a_of_type_Long == 0L)) {
          break;
        }
        long l = localaaom.jdField_a_of_type_Long * 1000L - System.currentTimeMillis() + 1000L;
        if (l <= 0L) {
          break;
        }
        aaoo.a(l);
        return;
        aanp.b(aaoo.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
    } while (i != 3);
    aaoo.a(1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */