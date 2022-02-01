package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;

public class TroopGameCardTroopListProcessor
  extends AbsTroopListHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopGameCardRedPoint(paramAppInterface.getCurrentUin(), paramTroopInfo.troopuin, paramTroopInfo.isTroopGameCardEnabled());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopGameCardTroopListProcessor
 * JD-Core Version:    0.7.0.1
 */