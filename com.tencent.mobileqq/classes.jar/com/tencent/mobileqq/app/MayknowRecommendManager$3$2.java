package com.tencent.mobileqq.app;

import alro;
import alrr;
import com.tencent.qphone.base.util.QLog;

public class MayknowRecommendManager$3$2
  implements Runnable
{
  public MayknowRecommendManager$3$2(alrr paramalrr, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "isSuccess :" + this.jdField_a_of_type_Boolean + " onAddReqStatesChanged: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Alrr.a.a(this.jdField_a_of_type_JavaLangString, true);
    ((FriendListHandler)alro.a(this.jdField_a_of_type_Alrr.a).a(1)).notifyUI(108, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.3.2
 * JD-Core Version:    0.7.0.1
 */