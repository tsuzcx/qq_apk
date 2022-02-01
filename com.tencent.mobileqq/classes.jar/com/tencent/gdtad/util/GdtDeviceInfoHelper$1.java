package com.tencent.gdtad.util;

import acvc;
import acvw;
import acvz;
import acwb;

public final class GdtDeviceInfoHelper$1
  implements Runnable
{
  public GdtDeviceInfoHelper$1(long paramLong) {}
  
  public void run()
  {
    acvc.b(acwb.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread delayMillis:%d count:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(acwb.a()) }));
    if (acwb.a() >= 5) {}
    int i;
    label212:
    do
    {
      return;
      try
      {
        if (acwb.a() >= 5) {
          return;
        }
      }
      finally {}
      acwb.a(acwb.a() + 1);
      acvz localacvz = acvw.a().a();
      i = acwb.a(localacvz);
      if (localacvz != null) {
        acvc.b(acwb.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localacvz.jdField_a_of_type_Int), Long.valueOf(localacvz.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        if ((localacvz == null) || (localacvz.jdField_a_of_type_Long == 0L)) {
          break;
        }
        long l = localacvz.jdField_a_of_type_Long * 1000L - System.currentTimeMillis() + 1000L;
        if (l <= 0L) {
          break;
        }
        acwb.a(l);
        return;
        acvc.b(acwb.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
    } while (i != 3);
    acwb.a(1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */