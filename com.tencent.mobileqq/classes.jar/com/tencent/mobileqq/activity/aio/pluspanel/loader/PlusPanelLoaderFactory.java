package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import android.util.SparseArray;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.BMQQPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.CommonC2CPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.OneWayFriendPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.RobotPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.SelfPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.AnonymousPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.CommonTroopPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.HotChatPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.QiDianPrivatePlusPanelAppLoader;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.filemanager.fileassistant.aio.NewDataLinePlusPanelAppLoader;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qphone.base.util.QLog;

public class PlusPanelLoaderFactory
  implements PlusPanelAppLoader.Factory
{
  private final SparseArray<Class<? extends PlusPanelAppLoader>> a = new PlusPanelLoaderFactory.1(this);
  
  PlusPanelAppLoader a(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    paramBaseChatPie = paramBaseChatPie.ah;
    HotChatManager localHotChatManager = (HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramBaseChatPie.b))) {
      return new HotChatPlusPanelAppLoader();
    }
    if (AnonymousChatHelper.a().a(paramBaseChatPie.b)) {
      return new AnonymousPlusPanelAppLoader();
    }
    if (((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).Z(paramBaseChatPie.b)) {
      return new QiDianPrivatePlusPanelAppLoader();
    }
    return new CommonTroopPlusPanelAppLoader();
  }
  
  public PlusPanelAppLoader a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    int i = paramBaseChatPie.ah.a;
    QLog.d("PlusPanelLoaderFactory", 1, new Object[] { "createPlusPanelAppLoader type = ", Integer.valueOf(i), ", oneWayFriend = ", Boolean.valueOf(paramBoolean) });
    if (i == 1) {
      return a(paramBaseChatPie);
    }
    if ((i != 0) && (!ChatActivityUtils.a(localQQAppInterface, paramBaseChatPie.ah.b))) {
      try
      {
        paramBaseChatPie = (Class)this.a.get(i);
        if (paramBaseChatPie != null)
        {
          paramBaseChatPie = (PlusPanelAppLoader)paramBaseChatPie.newInstance();
          return paramBaseChatPie;
        }
      }
      catch (Throwable paramBaseChatPie)
      {
        QLog.d("PlusPanelLoaderFactory", 1, paramBaseChatPie, new Object[0]);
        QLog.d("PlusPanelLoaderFactory", 1, "createPlusPanelAppLoader get loader fail, return default loader");
        return new DefaultPlusPanelAppLoader();
      }
    }
    return b(paramBaseChatPie, paramBoolean);
  }
  
  PlusPanelAppLoader b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    paramBaseChatPie = paramBaseChatPie.ah;
    if (RobotUtils.a(localQQAppInterface, paramBaseChatPie.b)) {
      return new RobotPlusPanelAppLoader();
    }
    if (BmqqSegmentUtil.c(paramBaseChatPie.b)) {
      return new BMQQPlusPanelAppLoader();
    }
    if (paramBoolean) {
      return new OneWayFriendPlusPanelAppLoader();
    }
    if (localQQAppInterface.getCurrentUin().equals(paramBaseChatPie.b)) {
      return new SelfPlusPanelAppLoader();
    }
    if (QFileAssistantUtils.a(paramBaseChatPie.b)) {
      return new NewDataLinePlusPanelAppLoader();
    }
    return new CommonC2CPlusPanelAppLoader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelLoaderFactory
 * JD-Core Version:    0.7.0.1
 */