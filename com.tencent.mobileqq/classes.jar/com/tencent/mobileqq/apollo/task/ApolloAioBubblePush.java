package com.tencent.mobileqq.apollo.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ApolloAioBubblePush
{
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      Object localObject = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (this.jdField_a_of_type_Boolean)
      {
        DrawerPushItem localDrawerPushItem = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
        localDrawerPushItem.show_sum += 1;
        paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum == this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("remove item from db, id:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
          QLog.i("[cmshow]ApolloAioBubblePush", 1, ((StringBuilder)localObject).toString());
          paramQQAppInterface.removePushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          return;
        }
        ((ApolloManagerServiceImpl)localObject).updateDrawerItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("update item from db");
        paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
        QLog.i("[cmshow]ApolloAioBubblePush", 1, paramQQAppInterface.toString());
      }
    }
  }
  
  public DrawerPushItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = null;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    ThreadManager.post(new ApolloAioBubblePush.1(this, paramAppRuntime), 8, null, true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloAioBubblePush", 2, "DO NOT show bubble cause it has been showed.");
          }
          return false;
        }
        if ((((DrawerPushItem)localObject).msg_type == 4) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id)))
        {
          localObject = paramQQAppInterface.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
          localStringBuilder.append("apollo_game_reddot_sp");
          ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id, true).commit();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[onShowBubble] parseGameReddot mPushItem.msg_id has show:");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
            QLog.d("[cmshow]ApolloAioBubblePush", 2, ((StringBuilder)localObject).toString());
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Show bubble, id:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
        QLog.i("[cmshow]ApolloAioBubblePush", 1, ((StringBuilder)localObject).toString());
        localObject = SpriteUtil.a(paramQQAppInterface);
        if (localObject == null) {
          return false;
        }
        ((SpriteActionScript)localObject).b("", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content);
        this.jdField_a_of_type_Boolean = true;
        a(paramQQAppInterface);
        if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_type == 10) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_type == 7)) {
          ApolloTianshuReportUtil.a(101, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuTraceInfo);
        }
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramInt), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("DO NOT show bubble, maybe item is null, item:");
      paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      QLog.d("[cmshow]ApolloAioBubblePush", 2, paramQQAppInterface.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAioBubblePush
 * JD-Core Version:    0.7.0.1
 */