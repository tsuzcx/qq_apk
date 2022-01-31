package com.tencent.mobileqq.app.automator.step;

import avnh;
import bhjf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.startup.step.InstallPlugins;

public class GetQZoneFeeds
  extends AsyncStep
{
  public static boolean a;
  
  public int a()
  {
    jdField_a_of_type_Boolean = true;
    ((avnh)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(91)).a();
    ((bhjf)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(175)).b();
    InstallPlugins.a(1);
    InstallPlugins.a();
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeeds
 * JD-Core Version:    0.7.0.1
 */