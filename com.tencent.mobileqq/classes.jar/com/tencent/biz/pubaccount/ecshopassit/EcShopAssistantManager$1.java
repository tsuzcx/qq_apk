package com.tencent.biz.pubaccount.ecshopassit;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import ofx;
import ogr;

public class EcShopAssistantManager$1
  implements Runnable
{
  public EcShopAssistantManager$1(ofx paramofx) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_get_PA_head");
    ((IntentFilter)localObject).addAction("action_shop_set_read");
    ((IntentFilter)localObject).addAction("action_folder_set_read");
    ((IntentFilter)localObject).addAction("action_folder_destroy");
    ((IntentFilter)localObject).addAction("action_folder_msg_change");
    ((IntentFilter)localObject).addAction("action_set_folder_tab_red");
    ((IntentFilter)localObject).addAction("action_follow_status");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.this$0.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      ((ogr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(88)).a();
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("ecshop_sp" + ofx.a(this.this$0), 0);
      this.this$0.b = ((SharedPreferences)localObject).getBoolean("folder_tab_show", false);
      this.this$0.c = ((SharedPreferences)localObject).getBoolean("preload_web", false);
      ofx.g = String.valueOf(((SharedPreferences)localObject).getLong("ad_puin", 0L));
      this.this$0.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("stayTime", 5000L);
      this.this$0.d = ((SharedPreferences)localObject).getInt("dayLimit", 3);
      this.this$0.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EcShopAssistantManager", 1, "Register receiver error:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.1
 * JD-Core Version:    0.7.0.1
 */