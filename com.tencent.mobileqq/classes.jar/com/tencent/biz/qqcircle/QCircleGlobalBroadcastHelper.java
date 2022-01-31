package com.tencent.biz.qqcircle;

import android.content.IntentFilter;
import axlx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QCircleGlobalBroadcastHelper
{
  private static volatile QCircleGlobalBroadcastHelper jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper;
  private static final String jdField_a_of_type_JavaLangString = QCircleGlobalBroadcastHelper.class.getSimpleName();
  private final QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver = new QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver(this);
  
  public static QCircleGlobalBroadcastHelper a()
  {
    if (jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper == null) {
        jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper = new QCircleGlobalBroadcastHelper();
      }
      return jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper;
    }
    finally {}
  }
  
  private static AppInterface b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof AppInterface)) {
        return (AppInterface)localObject;
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_clear_message_red_poiont");
      localIntentFilter.addAction("action_update_native_user_follow_state");
      localIntentFilter.addAction("action_update_native_tag_follow_state");
      localIntentFilter.addAction("action_receive_message_push");
      BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver);
      jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    axlx localaxlx = (axlx)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    localaxlx.a(localaxlx.a("140000"), 9, "");
    ThreadManager.getSubThreadHandler().postDelayed(new QCircleGlobalBroadcastHelper.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper
 * JD-Core Version:    0.7.0.1
 */