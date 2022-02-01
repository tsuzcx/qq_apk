package com.tencent.gdtad.util;

import com.tencent.gdtad.log.GdtLog;

class GdtTAIDAdapter$1
  implements Runnable
{
  GdtTAIDAdapter$1(GdtTAIDAdapter paramGdtTAIDAdapter, long paramLong) {}
  
  public void run()
  {
    GdtLog.b(GdtTAIDAdapter.a(), String.format("update delayMillis:%d count:%d", new Object[] { Long.valueOf(this.a), Integer.valueOf(GdtTAIDAdapter.a(this.this$0)) }));
    if (GdtTAIDAdapter.a(this.this$0) >= 5) {
      return;
    }
    try
    {
      if (GdtTAIDAdapter.a(this.this$0) >= 5) {
        return;
      }
      GdtTAIDAdapter.a(this.this$0, GdtTAIDAdapter.a(this.this$0) + 1);
      GdtAidHelper.TicketEntity localTicketEntity = GdtAidHelper.a().b();
      int i = GdtTAIDAdapter.a(localTicketEntity);
      if (localTicketEntity != null) {
        GdtLog.b(GdtTAIDAdapter.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread errorCode:%d errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localTicketEntity.c), Long.valueOf(localTicketEntity.d) }));
      } else {
        GdtLog.b(GdtTAIDAdapter.a(), String.format("updateForAidTicketAndTaidTicketOnSubThread initTuringSDK return null, errorCode:%d", new Object[] { Integer.valueOf(i) }));
      }
      if (i == 0)
      {
        if ((localTicketEntity != null) && (localTicketEntity.d > 0L))
        {
          long l = localTicketEntity.d * 1000L - System.currentTimeMillis() + 1000L;
          if (l > 0L) {
            GdtTAIDAdapter.a(this.this$0, l);
          }
        }
      }
      else if (i == 3) {
        GdtTAIDAdapter.a(this.this$0, 1800000L);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtTAIDAdapter.1
 * JD-Core Version:    0.7.0.1
 */