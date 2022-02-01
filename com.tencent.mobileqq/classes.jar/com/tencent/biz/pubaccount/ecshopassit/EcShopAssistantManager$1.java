package com.tencent.biz.pubaccount.ecshopassit;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class EcShopAssistantManager$1
  implements Runnable
{
  EcShopAssistantManager$1(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    ((EcShopAssistantManager)localObject1).a(((EcShopAssistantManager)localObject1).c);
    localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("action_get_PA_head");
    ((IntentFilter)localObject1).addAction("action_shop_set_read");
    ((IntentFilter)localObject1).addAction("action_folder_set_read");
    ((IntentFilter)localObject1).addAction("action_folder_destroy");
    ((IntentFilter)localObject1).addAction("action_folder_msg_change");
    ((IntentFilter)localObject1).addAction("action_set_folder_tab_red");
    ((IntentFilter)localObject1).addAction("action_follow_status");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.this$0.D, (IntentFilter)localObject1);
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Register receiver error:");
      localStringBuilder.append(localException);
      QLog.e("EcShopAssistantManager", 1, localStringBuilder.toString());
    }
    Object localObject2 = (EcshopReportHandler)this.this$0.c.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    if (localObject2 != null) {
      ((EcshopReportHandler)localObject2).a();
    }
    localObject2 = this.this$0.c.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ecshop_sp");
    localStringBuilder.append(EcShopAssistantManager.a(this.this$0));
    localObject2 = ((MobileQQ)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    this.this$0.v = ((SharedPreferences)localObject2).getBoolean("folder_tab_show", false);
    this.this$0.z = ((SharedPreferences)localObject2).getBoolean("preload_web", false);
    EcShopAssistantManager.s = String.valueOf(((SharedPreferences)localObject2).getLong("ad_puin", 0L));
    this.this$0.x = ((SharedPreferences)localObject2).getLong("stayTime", 5000L);
    this.this$0.y = ((SharedPreferences)localObject2).getInt("dayLimit", 3);
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.1
 * JD-Core Version:    0.7.0.1
 */