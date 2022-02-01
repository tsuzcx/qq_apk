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
    if (paramSessionInfo.f == 3) {
      return new MiniPieForForward(paramContext, paramSessionInfo, paramQQAppInterface);
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 1000)
        {
          if (i != 1001)
          {
            if (i == 1022) {
              break label141;
            }
            if (i != 3000)
            {
              if (i == 10002) {
                break label127;
              }
              if ((i == 10008) || (i == 10010)) {
                break label141;
              }
            }
          }
          switch (i)
          {
          default: 
            paramContext = null;
            break;
            paramContext = new MiniPieForDisc(paramContext, paramSessionInfo, paramQQAppInterface);
            break;
            label127:
            paramContext = new MiniPieForNearby(paramContext, paramSessionInfo, paramQQAppInterface);
            break;
          }
        }
        label141:
        paramContext = new MiniPieForStranger(paramContext, paramSessionInfo, paramQQAppInterface);
      }
      else
      {
        paramContext = new MiniPieForTroop(paramContext, paramSessionInfo, paramQQAppInterface);
      }
    }
    else {
      paramContext = new MiniPieForC2C(paramContext, paramSessionInfo, paramQQAppInterface);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getChatPie uinType = ");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(" miniPie ");
      if (paramContext == null) {
        paramSessionInfo = "null";
      } else {
        paramSessionInfo = Integer.valueOf(paramContext.hashCode());
      }
      paramQQAppInterface.append(paramSessionInfo);
      QLog.i("MiniPieFactory", 2, paramQQAppInterface.toString());
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieFactory
 * JD-Core Version:    0.7.0.1
 */