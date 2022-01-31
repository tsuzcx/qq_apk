package com.tencent.mobileqq.app.automator.step;

import awwx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetQZonePhotoGuideCheck
  extends AsyncStep
{
  public static boolean a;
  
  public int a()
  {
    jdField_a_of_type_Boolean = true;
    awwx localawwx = (awwx)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(104);
    if (localawwx != null) {
      localawwx.c();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck
 * JD-Core Version:    0.7.0.1
 */