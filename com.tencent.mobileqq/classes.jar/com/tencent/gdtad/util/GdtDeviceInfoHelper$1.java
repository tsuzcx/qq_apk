package com.tencent.gdtad.util;

import yxp;
import yyk;
import yym;
import yyp;

public final class GdtDeviceInfoHelper$1
  implements Runnable
{
  public GdtDeviceInfoHelper$1(long paramLong) {}
  
  public void run()
  {
    yxp.b(yyp.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread delayMillis:%d count:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(yyp.a()) }));
    if (yyp.a() >= 5) {}
    int i;
    label212:
    do
    {
      return;
      try
      {
        if (yyp.a() >= 5) {
          return;
        }
      }
      finally {}
      yyp.a(yyp.a() + 1);
      yym localyym = yyk.a().a();
      i = yyp.a(localyym);
      if (localyym != null) {
        yxp.b(yyp.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localyym.jdField_a_of_type_Int), Long.valueOf(localyym.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        if ((localyym == null) || (localyym.jdField_a_of_type_Long == 0L)) {
          break;
        }
        long l = localyym.jdField_a_of_type_Long * 1000L - System.currentTimeMillis() + 1000L;
        if (l <= 0L) {
          break;
        }
        yyp.a(l);
        return;
        yxp.b(yyp.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
    } while (i != 3);
    yyp.a(1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */