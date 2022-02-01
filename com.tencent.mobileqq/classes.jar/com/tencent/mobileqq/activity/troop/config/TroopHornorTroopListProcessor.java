package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler;
import com.tencent.qphone.base.util.QLog;

public class TroopHornorTroopListProcessor
  extends AbsTroopListHandlerProcessor
{
  private static String a = "TroopHornorTroopListProcessor";
  
  public void a(@NonNull AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onGetTroopListFinish");
    }
    paramAppInterface = (ITroopHonorHandler)paramAppInterface.getRuntimeService(ITroopHonorHandler.class, "");
    if (paramAppInterface != null) {
      paramAppInterface.getHostTroopHonorList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopHornorTroopListProcessor
 * JD-Core Version:    0.7.0.1
 */