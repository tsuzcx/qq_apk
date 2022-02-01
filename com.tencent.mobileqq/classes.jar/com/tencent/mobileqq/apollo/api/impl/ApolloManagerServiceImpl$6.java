package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class ApolloManagerServiceImpl$6
  implements Runnable
{
  ApolloManagerServiceImpl$6(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication();
      int i = 0;
      localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("aio_used_action_sp", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp_key_apollo_panel_action_used_last_request_time");
      ((StringBuilder)localObject2).append(ApolloManagerServiceImpl.access$200(this.this$0).getCurrentAccountUin());
      long l = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
      if (QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOPanelTag", 0) != 0) {
        i = 1;
      }
      localObject2 = (ApolloActionUsedManagerImpl)ApolloManagerServiceImpl.access$200(this.this$0).getRuntimeService(IApolloActionUsedManager.class, "all");
      if (((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L) || (((ApolloActionUsedManagerImpl)localObject2).isDataExpired())) && (i != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloManager", 2, "getApolloActionUsedListReqFromNetwork send req");
        }
        ((ApolloActionUsedManagerImpl)localObject2).getActionIdDataFromServer(-1);
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sp_key_apollo_panel_action_used_last_request_time");
        ((StringBuilder)localObject2).append(ApolloManagerServiceImpl.access$200(this.this$0).getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), System.currentTimeMillis()).commit();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("[cmshow]ApolloManager", 1, "[doAfterOpenAIO]  getBattleGameList error! exception = ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */