package com.tencent.mobileqq.activity.troop.config;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.config.AbsTroopManagerBizHandlerProcessor;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GrayTipsTroopManagerBizProcessor
  extends AbsTroopManagerBizHandlerProcessor
{
  public void a(AppInterface paramAppInterface, TroopInfo paramTroopInfo, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label831;
      }
      localQQAppInterface = (QQAppInterface)paramAppInterface;
      localTroopManager = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      l = localTroopManager.j(paramString1);
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("insertAddHWTroopGrayTips troopUin = ");
        paramAppInterface.append(paramString1);
        paramAppInterface.append(" local joinTroopMsgTime = ");
        paramAppInterface.append(l);
        paramAppInterface.append(" joinSeq = ");
        paramAppInterface.append(paramInt1);
        paramAppInterface.append(", joinTime = ");
        paramAppInterface.append(paramLong);
        paramAppInterface.append(" from:");
        paramAppInterface.append(paramInt2);
        paramAppInterface.append(", inviteUin = ");
        paramAppInterface.append(paramString2);
        paramAppInterface.append(", fromUin");
        paramAppInterface.append(paramString3);
        paramAppInterface.append(", isFrom0x88d");
        paramAppInterface.append(paramBoolean);
        QLog.d("GrayTipsForTroop", 2, paramAppInterface.toString());
      }
      if (l > 0L) {
        return;
      }
      localQQAppInterface.getMessageFacade().m(paramString1, 8);
      paramBoolean = paramTroopInfo.isHomeworkTroop();
      int i = 0;
      if (!paramBoolean) {
        break label237;
      }
      paramAppInterface = paramTroopInfo.troopuin;
      if (paramInt1 > 0) {
        break label845;
      }
      paramInt1 = i;
    }
    finally
    {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        TroopManager localTroopManager;
        label237:
        UniteGrayTipParam localUniteGrayTipParam;
        Object localObject2;
        String str;
        DiscussionManager localDiscussionManager;
        for (;;)
        {
          label783:
          label831:
          throw paramAppInterface;
        }
        label845:
        continue;
        label848:
        Object localObject1 = paramAppInterface;
        paramAppInterface = str;
        continue;
        continue;
        label860:
        long l = paramInt1;
      }
    }
    HWTroopUtils.a(localQQAppInterface, paramAppInterface, paramInt1, paramLong);
    break label783;
    paramAppInterface = localQQAppInterface.getApp().getString(2131886639);
    localUniteGrayTipParam = new UniteGrayTipParam(paramString1, paramString1, paramAppInterface, 1, -5021, 131073, paramLong);
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject2 = MessageHandlerUtils.a(localQQAppInterface, paramString2, paramString1);
      str = null;
      if (paramInt2 == 1)
      {
        localObject1 = localTroopManager;
        str = ((TroopManager)localObject1).i(paramString3);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramAppInterface = (AppInterface)localObject2;
          if (!((String)localObject2).equals(paramString2)) {
            break label848;
          }
        }
        paramString3 = ((TroopManager)localObject1).g(paramString3, paramString2);
        paramAppInterface = (AppInterface)localObject2;
        if (paramString3 != null)
        {
          paramAppInterface = (AppInterface)localObject2;
          if (!TextUtils.isEmpty(paramString3.friendnick)) {
            paramAppInterface = paramString3.friendnick;
          }
        }
      }
      else
      {
        localObject1 = localObject2;
        paramAppInterface = str;
        if (paramInt2 == 2)
        {
          localDiscussionManager = (DiscussionManager)localQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          localObject1 = localObject2;
          paramAppInterface = str;
          if (localDiscussionManager != null)
          {
            paramString3 = localDiscussionManager.d(paramString3);
            localObject1 = localObject2;
            paramAppInterface = str;
            if (paramString3 != null)
            {
              paramAppInterface = paramString3.discussionName;
              localObject1 = localObject2;
            }
          }
        }
        if (!TextUtils.isEmpty(paramAppInterface)) {
          paramAppInterface = String.format("%s通过群聊\"%s\"邀请你加入了本群", new Object[] { localObject1, paramAppInterface });
        } else {
          paramAppInterface = localQQAppInterface.getApp().getString(2131886640, new Object[] { localObject1 });
        }
        paramString3 = localUniteGrayTipParam;
        paramString3.g = paramAppInterface;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("key_action", 5);
        ((Bundle)localObject2).putString("troop_mem_uin", paramString2);
        ((Bundle)localObject2).putBoolean("need_update_nick", false);
        paramString3.a(0, ((String)localObject1).length(), (Bundle)localObject2);
        paramString2 = HardCodeUtil.a(2131912696);
        paramString3 = new StringBuilder();
        paramString3.append(paramAppInterface);
        paramString3.append("，");
        paramString3.append(paramString2);
        paramString3.append("。");
        paramAppInterface = paramString3.toString();
        localUniteGrayTipParam.g = paramAppInterface;
        paramString3 = new Bundle();
        paramString3.putInt("key_action", 19);
        paramString3.putString("troop_mem_uin", localQQAppInterface.getCurrentAccountUin());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append("");
        paramString3.putString("troopUin", ((StringBuilder)localObject1).toString());
        localUniteGrayTipParam.a(paramAppInterface.indexOf(paramString2), paramAppInterface.indexOf(paramString2) + paramString2.length(), paramString3);
        paramAppInterface = new MessageForUniteGrayTip();
        paramAppInterface.initGrayTipMsg(localQQAppInterface, localUniteGrayTipParam);
        paramAppInterface.isread = true;
        if (paramInt1 > 0) {
          break label860;
        }
        l = 0L;
        paramAppInterface.shmsgseq = l;
        l = paramLong;
        paramAppInterface.time = l;
        paramAppInterface.mNeedTimeStamp = true;
        paramAppInterface.updateUniteGrayTipMsgData(localQQAppInterface);
        localQQAppInterface.getMessageFacade().a(paramAppInterface, localQQAppInterface.getCurrentAccountUin());
        localTroopManager.a(paramTroopInfo, l);
        ((ITroopAnnouncementHandler)localQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName())).a(paramTroopInfo.troopuin, paramTroopInfo.troopcode, (short)34);
        localTroopManager.b(paramTroopInfo.troopuin, paramLong);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.GrayTipsTroopManagerBizProcessor
 * JD-Core Version:    0.7.0.1
 */