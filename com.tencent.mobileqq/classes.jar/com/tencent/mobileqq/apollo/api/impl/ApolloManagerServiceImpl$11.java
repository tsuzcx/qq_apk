package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class ApolloManagerServiceImpl$11
  implements Runnable
{
  ApolloManagerServiceImpl$11(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void run()
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0);
      long l = localSharedPreferences.getLong("sp_key_apollo_panel_action_used_last_request_time" + ApolloManagerServiceImpl.access$300(this.this$0).getCurrentAccountUin(), 0L);
      if (QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOPanelTag", 0) != 0) {}
      for (int i = 1;; i = 0)
      {
        ApolloActionUsedManagerServiceImpl localApolloActionUsedManagerServiceImpl = (ApolloActionUsedManagerServiceImpl)ApolloManagerServiceImpl.access$300(this.this$0).getRuntimeService(IApolloActionUsedManagerService.class, "all");
        if (((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L) || (localApolloActionUsedManagerServiceImpl.isDataExpired())) && (i != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "getApolloActionUsedListReqFromNetwork send req");
          }
          localApolloActionUsedManagerServiceImpl.getActionIdDataFromServer(-1);
          localSharedPreferences.edit().putLong("sp_key_apollo_panel_action_used_last_request_time" + ApolloManagerServiceImpl.access$300(this.this$0).getCurrentAccountUin(), System.currentTimeMillis()).commit();
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ApolloManager", 1, "[doAfterOpenAIO]  getBattleGameList error! exception = ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.11
 * JD-Core Version:    0.7.0.1
 */