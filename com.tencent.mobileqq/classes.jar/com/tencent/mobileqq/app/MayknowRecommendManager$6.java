package com.tencent.mobileqq.app;

import alwd;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class MayknowRecommendManager$6
  implements Runnable
{
  public MayknowRecommendManager$6(alwd paramalwd, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    QLog.i("MayknowRecommendManager", 1, String.format("getMayKnowRecommendRemote, real start, entryType = " + this.jdField_a_of_type_Int, new Object[0]));
    ((FriendListHandler)alwd.a(this.this$0).a(1)).a(null, null, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.6
 * JD-Core Version:    0.7.0.1
 */