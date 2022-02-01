package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopBatchInfoHandlerProcessor;

public class TroopBatchInfoHandlerProcessor
  extends AbsTroopBatchInfoHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo)
  {
    ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).e(paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopBatchInfoHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */