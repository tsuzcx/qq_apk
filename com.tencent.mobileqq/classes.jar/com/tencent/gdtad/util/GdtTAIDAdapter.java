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
  private static String jdField_a_of_type_JavaLangString = "GdtTAIDAdapter";
  private volatile int jdField_a_of_type_Int = 0;
  
  private void a(long paramLong)
  {
    AdThreadManager.INSTANCE.postDelayed(new GdtTAIDAdapter.1(this, paramLong), 4, paramLong);
  }
  
  private static int b(GdtAidHelper.TicketEntity paramTicketEntity)
  {
    int j = d(paramTicketEntity);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramTicketEntity.jdField_a_of_type_JavaLangString)) {
        i = 10;
      }
    }
    return i;
  }
  
  private static int c(GdtAidHelper.TicketEntity paramTicketEntity)
  {
    int j = d(paramTicketEntity);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramTicketEntity.b)) {
        i = 1;
      }
    }
    return i;
  }
  
  private static int d(GdtAidHelper.TicketEntity paramTicketEntity)
  {
    if (paramTicketEntity == null) {}
    do
    {
      return 1;
      if (paramTicketEntity.jdField_a_of_type_Int == 0) {
        return 0;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -10001) {
        return 6;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -10008) {
        return 8;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -10009) {
        return 7;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == 10010) {
        return 5;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -10011) {
        return 2;
      }
      if ((paramTicketEntity.jdField_a_of_type_Int == -10004) || (paramTicketEntity.jdField_a_of_type_Int == -10012) || (paramTicketEntity.jdField_a_of_type_Int == -21052) || (paramTicketEntity.jdField_a_of_type_Int == -22056)) {
        return 3;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -30014) {
        return 10;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -2147483648) {
        return 4;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -2147483647) {
        return 9;
      }
      if (paramTicketEntity.jdField_a_of_type_Int == -2147483646) {
        return 205;
      }
    } while (paramTicketEntity.jdField_a_of_type_Int != -2147483645);
    return 206;
  }
  
  public AdTAID.Entity getEntity(Context paramContext, String paramString)
  {
    paramContext = GdtAidHelper.a().a(paramString);
    long l;
    label143:
    int i;
    if (paramContext != null)
    {
      GdtLog.b(jdField_a_of_type_JavaLangString, String.format("getEntity businessId:%s errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d aidTicket:%s taidTicket:%s", new Object[] { paramString, Integer.valueOf(paramContext.jdField_a_of_type_Int), Long.valueOf(paramContext.jdField_a_of_type_Long), paramContext.jdField_a_of_type_JavaLangString, paramContext.b }));
      paramString = new AdTAID.Entity();
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
        paramString.aidTicket = paramContext.jdField_a_of_type_JavaLangString;
      }
      paramString.errorCodeForAidTicket = b(paramContext);
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.b))) {
        paramString.taidTicket = paramContext.b;
      }
      paramString.errorCodeForTaidTicket = c(paramContext);
      if (paramContext == null) {
        break label201;
      }
      l = paramContext.jdField_a_of_type_Long;
      paramString.expiredTimeMillis = l;
      if (paramContext == null) {
        break label209;
      }
      i = paramContext.jdField_a_of_type_Int;
      label158:
      paramString.originErrorCode = i;
      if (paramContext == null) {
        break label215;
      }
    }
    label201:
    label209:
    label215:
    for (paramContext = paramContext.jdField_a_of_type_JavaLangThrowable;; paramContext = null)
    {
      paramString.throwable = paramContext;
      return paramString;
      GdtLog.d(jdField_a_of_type_JavaLangString, String.format("getEntity return null, businessId:%s", new Object[] { paramString }));
      break;
      l = -2147483648L;
      break label143;
      i = -2147483648;
      break label158;
    }
  }
  
  public void init(Context paramContext)
  {
    a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtTAIDAdapter
 * JD-Core Version:    0.7.0.1
 */