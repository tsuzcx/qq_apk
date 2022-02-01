package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class MayknowRecommendManager$7
  implements BusinessObserver
{
  MayknowRecommendManager$7(MayknowRecommendManager paramMayknowRecommendManager, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("setRecommendTroopDeleted uin: ");
      paramBundle.append(this.a);
      paramBundle.append(" isSuccess: ");
      paramBundle.append(paramBoolean);
      QLog.i("MayknowRecommendManager", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.7
 * JD-Core Version:    0.7.0.1
 */