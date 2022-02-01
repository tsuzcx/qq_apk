package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qidian.QidianManager;

public class PublicAccountPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (CrmUtils.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.a)) {
      a(paramBaseChatPie.ah.a, 201);
    }
    a(paramBaseChatPie.ah.a, 217);
    a(paramBaseChatPie.ah.a, 218);
    if (paramSessionInfo.a == 1008)
    {
      paramSessionInfo = (PublicAccountInfo)((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(paramSessionInfo.b);
      if ((paramSessionInfo != null) && ((paramSessionInfo.accountFlag & 0x20000000) != 0) && (ShortVideoUtils.sSupportShortVideo) && (VideoEnvironment.supportShortVideoRecordAndPlay())) {
        a(paramBaseChatPie.ah.a, 1104788673);
      }
      if ((paramSessionInfo != null) && ((paramSessionInfo.accountFlag & 0x10000000) != 0)) {
        a(0, C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(1000000005));
      }
    }
    a(paramBaseChatPie.ah.a, 205);
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QidianManager paramQidianManager)
  {
    if (paramQidianManager.g(paramSessionInfo.b))
    {
      a(paramBaseChatPie.ah.a, 201);
      a(paramBaseChatPie.ah.a, 202);
    }
    a(paramBaseChatPie.ah.a, 206);
    a(paramBaseChatPie.ah.a, 205);
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    SessionInfo localSessionInfo = paramBaseChatPie.ah;
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    QidianManager localQidianManager = (QidianManager)localQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    if (localQidianManager.m(localSessionInfo.b))
    {
      a(paramBaseChatPie, localSessionInfo, localQidianManager);
      return;
    }
    a(paramBaseChatPie, localSessionInfo, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.PublicAccountPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */