package com.tencent.mobileqq.app.automator.step;

import bazf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import cooperation.qzone.plugin.QZonePluginManager;

public class GetQZoneFeeds
  extends AsyncStep
{
  public static boolean a;
  
  public int a()
  {
    jdField_a_of_type_Boolean = true;
    ((bazf)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a();
    ((QZonePluginManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.QZONE_PLUGIN_MANAGER)).setReadyToNetworking();
    InstallPlugins.a(1);
    InstallPlugins.a();
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeeds
 * JD-Core Version:    0.7.0.1
 */