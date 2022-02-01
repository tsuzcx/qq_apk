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
    if (paramSessionInfo.B == 3) {
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
              break label149;
            }
            if (i != 3000)
            {
              if (i == 10002) {
                break label135;
              }
              if ((i == 10008) || (i == 10010) || (i == 10013)) {
                break label149;
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
            label135:
            paramContext = new MiniPieForNearby(paramContext, paramSessionInfo, paramQQAppInterface);
            break;
          }
        }
        label149:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieFactory
 * JD-Core Version:    0.7.0.1
 */