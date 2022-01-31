package com.tencent.gdtad.util;

import aase;
import aasy;
import aatb;
import aatd;

public final class GdtDeviceInfoHelper$1
  implements Runnable
{
  public GdtDeviceInfoHelper$1(long paramLong) {}
  
  public void run()
  {
    aase.b(aatd.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread delayMillis:%d count:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(aatd.a()) }));
    if (aatd.a() >= 5) {}
    int i;
    label212:
    do
    {
      return;
      try
      {
        if (aatd.a() >= 5) {
          return;
        }
      }
      finally {}
      aatd.a(aatd.a() + 1);
      aatb localaatb = aasy.a().a();
      i = aatd.a(localaatb);
      if (localaatb != null) {
        aase.b(aatd.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localaatb.jdField_a_of_type_Int), Long.valueOf(localaatb.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        if ((localaatb == null) || (localaatb.jdField_a_of_type_Long == 0L)) {
          break;
        }
        long l = localaatb.jdField_a_of_type_Long * 1000L - System.currentTimeMillis() + 1000L;
        if (l <= 0L) {
          break;
        }
        aatd.a(l);
        return;
        aase.b(aatd.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
    } while (i != 3);
    aatd.a(1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */