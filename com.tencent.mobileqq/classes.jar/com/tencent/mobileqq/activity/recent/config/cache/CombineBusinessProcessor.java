package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class CombineBusinessProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver
{
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Object localObject = paramRecentUser;
    if (paramRecentUser.getType() != 1)
    {
      localObject = paramRecentUser;
      if (paramRecentUser.getType() != 3000)
      {
        localObject = paramRecentUser;
        if (paramRecentUser.getType() != 7000)
        {
          localObject = paramRecentUser;
          if ((paramBaseQQAppInterface instanceof QQAppInterface))
          {
            localObject = (QQAppInterface)paramBaseQQAppInterface;
            RecentUserProxy localRecentUserProxy = ((QQAppInterface)localObject).getRecentUserProxy();
            if (QidianManager.a((BaseQQAppInterface)localObject, paramRecentUser.uin)) {
              paramRecentUser.setType(1024);
            }
            ArrayList localArrayList = new ArrayList();
            paramBaseQQAppInterface = UinTypeUtil.c;
            int j = paramBaseQQAppInterface.length;
            int i = 0;
            while (i < j)
            {
              int k = paramBaseQQAppInterface[i];
              if (k != paramRecentUser.getType())
              {
                String str = BaseRecentUserCache.a(paramRecentUser.uin, k);
                if (localRecentUserProxy.b(str)) {
                  localArrayList.add(str);
                }
              }
              i += 1;
            }
            j = localArrayList.size();
            paramBaseQQAppInterface = paramRecentUser;
            if (j > 0)
            {
              paramBaseQQAppInterface = paramRecentUser;
              i = 0;
              while (i < j)
              {
                if (i == 0)
                {
                  paramRecentUser = (RecentUser)localRecentUserProxy.a(localArrayList.get(i));
                  if (paramRecentUser != null)
                  {
                    paramRecentUser.setType(paramBaseQQAppInterface.getType());
                    paramRecentUser.displayName = paramBaseQQAppInterface.displayName;
                    paramRecentUser.lastmsgtime = paramBaseQQAppInterface.lastmsgtime;
                    paramRecentUser.showUpTime = Math.max(paramRecentUser.showUpTime, paramBaseQQAppInterface.showUpTime);
                    paramRecentUser.troopUin = paramBaseQQAppInterface.troopUin;
                    paramRecentUser.lastmsgdrafttime = paramBaseQQAppInterface.lastmsgdrafttime;
                    paramRecentUser.msgData = paramBaseQQAppInterface.msgData;
                    paramRecentUser.msgType = paramBaseQQAppInterface.msgType;
                    paramRecentUser.lFlag = paramBaseQQAppInterface.lFlag;
                    QLog.d(this.a, 1, new Object[] { "isHiddenChat=", Integer.valueOf(paramBaseQQAppInterface.isHiddenChat), " uin=", MobileQQ.getShortUinStr(paramBaseQQAppInterface.uin) });
                    paramRecentUser.isHiddenChat = paramBaseQQAppInterface.isHiddenChat;
                    paramRecentUser.opTime = Math.max(paramRecentUser.opTime, paramBaseQQAppInterface.opTime);
                    localRecentUserProxy.a(localArrayList.get(i));
                    paramBaseQQAppInterface = paramRecentUser;
                  }
                }
                else
                {
                  localRecentUserProxy.a(localArrayList.get(i));
                  QLog.d(this.a, 2, new Object[] { "removeKey=", localArrayList.get(i), " ignore storage" });
                }
                i += 1;
              }
            }
            QCallFacade.a((QQAppInterface)localObject, paramBaseQQAppInterface.uin, paramBaseQQAppInterface.getType());
            localObject = paramBaseQQAppInterface;
          }
        }
      }
    }
    return localObject;
  }
  
  @NonNull
  String a()
  {
    return "CombineBusinessProcessor";
  }
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    if (TextUtils.equals(paramRecentUser.uin, AppConstants.TENCENT_DOCS_ASSISTANT_UIN))
    {
      if (!((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(paramBaseQQAppInterface)) {
        return false;
      }
    }
    else
    {
      if (TextUtils.equals(AppConstants.LBS_HELLO_UIN, paramRecentUser.uin)) {
        return false;
      }
      if (TextUtils.equals(AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN, paramRecentUser.uin))
      {
        if (!LoginWelcomeManager.a(paramBaseQQAppInterface, paramRecentUser)) {
          return false;
        }
      }
      else
      {
        if (paramRecentUser.getType() == 1038) {
          return AppletsFolderManager.a(false);
        }
        if (TextUtils.equals(AppConstants.MATCH_CHAT_UIN, paramRecentUser.uin)) {
          return false;
        }
        if (paramRecentUser.getType() == 10008) {
          return false;
        }
        if (QFileAssistantUtils.a(paramBaseQQAppInterface, paramRecentUser)) {
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.CombineBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */