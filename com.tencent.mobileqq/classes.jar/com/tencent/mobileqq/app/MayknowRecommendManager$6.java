package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class MayknowRecommendManager$6
  implements BusinessObserver
{
  MayknowRecommendManager$6(MayknowRecommendManager paramMayknowRecommendManager, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "setRecommendTroopDeleted uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.6
 * JD-Core Version:    0.7.0.1
 */