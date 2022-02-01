package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MiniPieFactory
{
  public static MiniPie a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = paramSessionInfo.a;
    Object localObject = null;
    if (paramSessionInfo.f == 3) {
      paramSessionInfo = new MiniPieForForward(paramContext, paramSessionInfo, paramQQAppInterface);
    }
    do
    {
      return paramSessionInfo;
      switch (i)
      {
      default: 
        paramContext = localObject;
        paramSessionInfo = paramContext;
      }
    } while (!QLog.isColorLevel());
    paramQQAppInterface = new StringBuilder().append("getChatPie uinType = ").append(i).append(" miniPie ");
    if (paramContext == null) {}
    for (paramSessionInfo = "null";; paramSessionInfo = Integer.valueOf(paramContext.hashCode()))
    {
      QLog.i("MiniPieFactory", 2, paramSessionInfo);
      return paramContext;
      paramContext = new MiniPieForC2C(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new MiniPieForDisc(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new MiniPieForTroop(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new MiniPieForStranger(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new MiniPieForNearby(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieFactory
 * JD-Core Version:    0.7.0.1
 */