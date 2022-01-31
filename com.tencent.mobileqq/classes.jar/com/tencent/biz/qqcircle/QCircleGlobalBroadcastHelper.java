package com.tencent.biz.qqcircle;

import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;

public class QCircleGlobalBroadcastHelper
{
  private static volatile QCircleGlobalBroadcastHelper jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper;
  private static final String jdField_a_of_type_JavaLangString = QCircleGlobalBroadcastHelper.class.getSimpleName();
  private volatile QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver = new QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver(this);
  
  private QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver == null) {
        this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver = new QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver(this);
      }
      return this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver;
    }
    finally {}
  }
  
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
      BaseApplicationImpl.getApplication().registerReceiver(a(), localIntentFilter);
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
      if (a() != null) {
        BaseApplicationImpl.getApplication().unregisterReceiver(a());
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper
 * JD-Core Version:    0.7.0.1
 */