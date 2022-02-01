package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import java.util.List;

public class TroopBindPAReloadFilter
  implements IReloadFilter
{
  public List<ChatMessage> a(AIOContext paramAIOContext, List<ChatMessage> paramList)
  {
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
    paramAIOContext = (TroopBindPublicAccountMgr)paramAIOContext.a().getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    if (paramAIOContext.b(localBaseSessionInfo.a)) {
      paramAIOContext.a(localBaseSessionInfo.a, paramList);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.TroopBindPAReloadFilter
 * JD-Core Version:    0.7.0.1
 */