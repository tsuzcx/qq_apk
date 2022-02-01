package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.device.AdTAID.Entity;
import com.tencent.ad.tangram.device.AdTAIDAdapter;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;

public final class GdtTAIDAdapter
  implements AdTAIDAdapter
{
  private static String a = "GdtTAIDAdapter";
  private volatile int b = 0;
  
  private void a(long paramLong)
  {
    AdThreadManager.INSTANCE.postDelayed(new GdtTAIDAdapter.1(this, paramLong), 4, paramLong);
  }
  
  private static int b(GdtAidHelper.TicketEntity paramTicketEntity)
  {
    int i = d(paramTicketEntity);
    if ((i == 0) && (TextUtils.isEmpty(paramTicketEntity.a))) {
      return 10;
    }
    return i;
  }
  
  private static int c(GdtAidHelper.TicketEntity paramTicketEntity)
  {
    int i = d(paramTicketEntity);
    if ((i == 0) && (TextUtils.isEmpty(paramTicketEntity.b))) {
      return 1;
    }
    return i;
  }
  
  private static int d(GdtAidHelper.TicketEntity paramTicketEntity)
  {
    if (paramTicketEntity == null) {
      return 1;
    }
    if (paramTicketEntity.c == 0) {
      return 0;
    }
    if (paramTicketEntity.c == -10001) {
      return 6;
    }
    if (paramTicketEntity.c == -10008) {
      return 8;
    }
    if (paramTicketEntity.c == -10009) {
      return 7;
    }
    if (paramTicketEntity.c == 10010) {
      return 5;
    }
    if (paramTicketEntity.c == -10011) {
      return 2;
    }
    if ((paramTicketEntity.c != -10004) && (paramTicketEntity.c != -10012) && (paramTicketEntity.c != -21052) && (paramTicketEntity.c != -22056))
    {
      if (paramTicketEntity.c == -30014) {
        return 10;
      }
      if (paramTicketEntity.c == -2147483648) {
        return 4;
      }
      if (paramTicketEntity.c == -2147483647) {
        return 9;
      }
      if (paramTicketEntity.c == -2147483646) {
        return 205;
      }
      if (paramTicketEntity.c == -2147483645) {
        return 206;
      }
      return 1;
    }
    return 3;
  }
  
  public AdTAID.Entity getEntity(Context paramContext, String paramString)
  {
    paramContext = GdtAidHelper.a().a(paramString);
    if (paramContext != null) {
      GdtLog.b(a, String.format("getEntity businessId:%s errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d aidTicket:%s taidTicket:%s", new Object[] { paramString, Integer.valueOf(paramContext.c), Long.valueOf(paramContext.d), paramContext.a, paramContext.b }));
    } else {
      GdtLog.d(a, String.format("getEntity return null, businessId:%s", new Object[] { paramString }));
    }
    paramString = new AdTAID.Entity();
    if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.a))) {
      paramString.aidTicket = paramContext.a;
    }
    paramString.errorCodeForAidTicket = b(paramContext);
    if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.b))) {
      paramString.taidTicket = paramContext.b;
    }
    paramString.errorCodeForTaidTicket = c(paramContext);
    long l;
    if (paramContext != null) {
      l = paramContext.d;
    } else {
      l = -2147483648L;
    }
    paramString.expiredTimeMillis = l;
    int i;
    if (paramContext != null) {
      i = paramContext.c;
    } else {
      i = -2147483648;
    }
    paramString.originErrorCode = i;
    if (paramContext != null) {
      paramContext = paramContext.e;
    } else {
      paramContext = null;
    }
    paramString.throwable = paramContext;
    return paramString;
  }
  
  public void init(Context paramContext)
  {
    a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtTAIDAdapter
 * JD-Core Version:    0.7.0.1
 */