package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.api.config.AbsTroopPushHandlerProcessor;

public class GrayTipTroopPushProcessor
  extends AbsTroopPushHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong, int paramInt)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (TroopManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramInt == 8)
      {
        paramAppInterface.a(paramString, paramLong, 0L, 131081);
        return;
      }
      if (paramInt == 7) {
        paramAppInterface.a(paramString, paramLong, 0L, 131080);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.GrayTipTroopPushProcessor
 * JD-Core Version:    0.7.0.1
 */