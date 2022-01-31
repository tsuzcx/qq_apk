package com.tencent.gdtad.util;

import yxs;
import yyn;
import yyp;
import yys;

public final class GdtDeviceInfoHelper$1
  implements Runnable
{
  public GdtDeviceInfoHelper$1(long paramLong) {}
  
  public void run()
  {
    yxs.b(yys.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread delayMillis:%d count:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(yys.a()) }));
    if (yys.a() >= 5) {}
    int i;
    label212:
    do
    {
      return;
      try
      {
        if (yys.a() >= 5) {
          return;
        }
      }
      finally {}
      yys.a(yys.a() + 1);
      yyp localyyp = yyn.a().a();
      i = yys.a(localyyp);
      if (localyyp != null) {
        yxs.b(yys.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localyyp.jdField_a_of_type_Int), Long.valueOf(localyyp.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        if ((localyyp == null) || (localyyp.jdField_a_of_type_Long == 0L)) {
          break;
        }
        long l = localyyp.jdField_a_of_type_Long * 1000L - System.currentTimeMillis() + 1000L;
        if (l <= 0L) {
          break;
        }
        yys.a(l);
        return;
        yxs.b(yys.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
    } while (i != 3);
    yys.a(1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */