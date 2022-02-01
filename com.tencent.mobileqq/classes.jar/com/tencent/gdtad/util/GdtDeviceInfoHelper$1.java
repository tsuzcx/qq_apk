package com.tencent.gdtad.util;

import acqy;
import acrs;
import acrv;
import acrx;

public final class GdtDeviceInfoHelper$1
  implements Runnable
{
  public GdtDeviceInfoHelper$1(long paramLong) {}
  
  public void run()
  {
    acqy.b(acrx.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread delayMillis:%d count:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(acrx.a()) }));
    if (acrx.a() >= 5) {}
    int i;
    label212:
    do
    {
      return;
      try
      {
        if (acrx.a() >= 5) {
          return;
        }
      }
      finally {}
      acrx.a(acrx.a() + 1);
      acrv localacrv = acrs.a().a();
      i = acrx.a(localacrv);
      if (localacrv != null) {
        acqy.b(acrx.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localacrv.jdField_a_of_type_Int), Long.valueOf(localacrv.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        if ((localacrv == null) || (localacrv.jdField_a_of_type_Long == 0L)) {
          break;
        }
        long l = localacrv.jdField_a_of_type_Long * 1000L - System.currentTimeMillis() + 1000L;
        if (l <= 0L) {
          break;
        }
        acrx.a(l);
        return;
        acqy.b(acrx.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
    } while (i != 3);
    acrx.a(1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */