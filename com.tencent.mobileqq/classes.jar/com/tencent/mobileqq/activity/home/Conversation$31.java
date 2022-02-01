package com.tencent.mobileqq.activity.home;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

class Conversation$31
  extends RoamSettingObserver
{
  Conversation$31(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      int i;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onSetGenralSettingsTroopFilter: isSuc = ");
        paramString.append(paramBoolean);
        paramString.append(", size = ");
        if (paramMap == null) {
          i = 0;
        } else {
          i = paramMap.size();
        }
        paramString.append(i);
        QLog.d("Q.recent", 2, paramString.toString());
      }
      if (paramMap != null)
      {
        if (paramMap.size() == 0) {
          return;
        }
        paramString = (ProxyManager)this.a.aF.getManager(QQManagerFactory.PROXY_MANAGER);
        if (paramString == null) {
          paramString = null;
        } else {
          paramString = paramString.g();
        }
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          String str = (String)((Map.Entry)paramMap.next()).getKey();
          i = this.a.s().getTroopMask(str);
          if (i == 2) {
            TroopAssistantManager.a().a(str, this.a.s());
          } else {
            TroopAssistantManager.a().c(str, this.a.s());
          }
          if ((i == 3) && (paramString != null)) {}
          try
          {
            RecentUser localRecentUser = paramString.c(str, 1);
            if (localRecentUser != null)
            {
              paramString.a(localRecentUser);
              RecentDataListManager localRecentDataListManager = RecentDataListManager.a();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(localRecentUser.uin);
              localStringBuilder.append("-");
              localStringBuilder.append(localRecentUser.getType());
              localRecentDataListManager.b(localStringBuilder.toString());
              paramString.a(localRecentUser);
              RecentUtil.b(this.a.s(), localRecentUser.uin, 1);
              this.a.s().getMessageFacade().a(localRecentUser.uin, localRecentUser.getType());
            }
          }
          catch (Exception localException)
          {
            label359:
            break label359;
          }
          this.a.a(9, str, 1);
        }
        this.a.a(9, AppConstants.TROOP_ASSISTANT_UIN, 5000);
        this.a.a(9, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = (ProxyManager)this.a.aF.getManager(QQManagerFactory.PROXY_MANAGER);
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((ProxyManager)localObject1).g();
    }
    TroopAssistantManager.a().q(this.a.s());
    if (localObject1 != null) {
      localObject2 = ((RecentUserProxy)localObject1).a(false);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.getType() == 1) && (this.a.s().getTroopMask(localRecentUser.uin) == 3))
        {
          if (localObject1 != null) {
            ((RecentUserProxy)localObject1).a(localRecentUser);
          }
          RecentUtil.b(this.a.s(), localRecentUser.uin, 1);
          this.a.s().getMessageFacade().a(localRecentUser.uin, localRecentUser.getType());
        }
      }
    }
    this.a.a(9, AppConstants.TROOP_ASSISTANT_UIN, 5000);
    this.a.a(9, AppConstants.HOTCHAT_CENTER_UIN, 5001);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onGetGenralSettings");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.31
 * JD-Core Version:    0.7.0.1
 */