package com.tencent.mobileqq.applets;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountStateReporter
{
  private static int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 0;
    }
    return 2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    paramInt = a(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPublicAccountReceiveState state : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", name: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", pUin: ");
      localStringBuilder.append(paramString1);
      QLog.i("PublicAccountStateReporter", 2, localStringBuilder.toString());
    }
    paramQQAppInterface = (AppletsHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramString1, paramString2, paramInt);
    }
  }
  
  private static void a(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountStateReporter", 2, new Object[] { "doPublicAccountFollowState { isFollow=", Boolean.valueOf(paramBoolean), " appType=", Integer.valueOf(paramInt1), " appid=", Long.valueOf(paramLong1), " puin=", Long.valueOf(paramLong2), " source=", Integer.valueOf(paramInt2), " }" });
    }
    paramQQAppInterface = (AppletsHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramBoolean, paramInt1, paramLong1, paramLong2, paramInt2);
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    try
    {
      a(paramQQAppInterface, paramBoolean, -1, -1L, Long.parseLong(paramString), paramInt);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      label15:
      break label15;
    }
    QLog.d("PublicAccountStateReporter", 1, new Object[] { "NumberFormatException, puin=", paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountStateReporter
 * JD-Core Version:    0.7.0.1
 */