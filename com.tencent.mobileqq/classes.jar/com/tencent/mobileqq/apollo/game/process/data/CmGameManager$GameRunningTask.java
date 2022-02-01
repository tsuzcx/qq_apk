package com.tencent.mobileqq.apollo.game.process.data;

import android.app.Activity;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import java.lang.ref.WeakReference;

public class CmGameManager$GameRunningTask
{
  public int a;
  public long a;
  public StartCheckParam a;
  public WeakReference<Activity> a;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("GameRunningTask{");
    localStringBuffer.append("mStartCheckParam=");
    localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
    localStringBuffer.append(", mActivityRef=");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangRefWeakReference);
    localStringBuffer.append(", mActivityState=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameManager.GameRunningTask
 * JD-Core Version:    0.7.0.1
 */