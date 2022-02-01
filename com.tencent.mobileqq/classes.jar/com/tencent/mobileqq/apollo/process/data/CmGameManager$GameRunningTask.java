package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import java.lang.ref.WeakReference;

public class CmGameManager$GameRunningTask
{
  public int a;
  public long a;
  public CmGameStartChecker.StartCheckParam a;
  public String a;
  public WeakReference<Activity> a;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("GameRunningTask{");
    localStringBuffer.append("mStartCheckParam=").append(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    localStringBuffer.append(", mActivityRef=").append(this.jdField_a_of_type_JavaLangRefWeakReference);
    localStringBuffer.append(", mActivityState=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameManager.GameRunningTask
 * JD-Core Version:    0.7.0.1
 */