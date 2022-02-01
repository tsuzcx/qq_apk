package com.tencent.mobileqq.apollo.bubble;

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
  private DrawerPushItem a;
  private boolean b = false;
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (this.a != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      Object localObject = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (this.b)
      {
        DrawerPushItem localDrawerPushItem = this.a;
        localDrawerPushItem.show_sum += 1;
        paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        if (this.a.show_sum == this.a.show_counts)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("remove item from db, id:");
          ((StringBuilder)localObject).append(this.a.msg_id);
          QLog.i("[cmshow]ApolloAioBubblePush", 1, ((StringBuilder)localObject).toString());
          paramQQAppInterface.removePushItem(this.a);
          return;
        }
        ((ApolloManagerServiceImpl)localObject).updateDrawerItem(this.a);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("update item from db");
        paramQQAppInterface.append(this.a.msg_id);
        QLog.i("[cmshow]ApolloAioBubblePush", 1, paramQQAppInterface.toString());
      }
    }
  }
  
  public DrawerPushItem a()
  {
    return this.a;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    ThreadManager.post(new ApolloAioBubblePush.1(this, paramAppRuntime), 8, null, true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (this.b)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloAioBubblePush", 2, "DO NOT show bubble cause it has been showed.");
          }
          return false;
        }
        if ((((DrawerPushItem)localObject).msg_type == 4) && (!TextUtils.isEmpty(this.a.msg_id)))
        {
          localObject = paramQQAppInterface.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
          localStringBuilder.append("apollo_game_reddot_sp");
          ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(this.a.msg_id, true).commit();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[onShowBubble] parseGameReddot mPushItem.msg_id has show:");
            ((StringBuilder)localObject).append(this.a.msg_id);
            QLog.d("[cmshow]ApolloAioBubblePush", 2, ((StringBuilder)localObject).toString());
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Show bubble, id:");
        ((StringBuilder)localObject).append(this.a.msg_id);
        QLog.i("[cmshow]ApolloAioBubblePush", 1, ((StringBuilder)localObject).toString());
        localObject = SpriteUtil.i(paramQQAppInterface);
        if (localObject == null) {
          return false;
        }
        ((SpriteActionScript)localObject).b("", this.a.content);
        this.b = true;
        a(paramQQAppInterface);
        if ((this.a.msg_type == 10) || (this.a.msg_type == 7)) {
          ApolloTianshuReportUtil.a(101, String.valueOf(this.a.tianshuAdId), this.a.tianshuTraceInfo);
        }
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramInt), 0, new String[] { this.a.msg_id });
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("DO NOT show bubble, maybe item is null, item:");
      paramQQAppInterface.append(this.a);
      QLog.d("[cmshow]ApolloAioBubblePush", 2, paramQQAppInterface.toString());
    }
    return false;
  }
  
  public void b()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.bubble.ApolloAioBubblePush
 * JD-Core Version:    0.7.0.1
 */