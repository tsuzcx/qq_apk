package com.tencent.mobileqq.app.message;

import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

public class DiscMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public DiscMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin().equals(paramString1)) {
      return this.jdField_a_of_type_MqqAppAppRuntime.getApp().getResources().getString(2131693894);
    }
    return ContactUtils.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramString2, paramString1);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addMessageRecord:");
      ((StringBuilder)localObject).append(paramMessageRecord);
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, ((StringBuilder)localObject).toString());
    }
    Map localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Object localObject = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    int k = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(str1, paramMessageRecord.istroop);
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)paramAddMessageContext.jdField_a_of_type_MqqManagerManager;
    StringBuilder localStringBuilder = null;
    if (localTroopInfoManager != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(3000);
      String str2 = ((StringBuilder)localObject).toString();
      localObject = localTroopInfoManager.a(str2);
      if (localObject != null)
      {
        if (((MessageInfo)localObject).b() != paramMessageRecord.shmsgseq)
        {
          localObject = localStringBuilder;
          if (!QLog.isColorLevel()) {
            break label384;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addMessageRecord:not the same msg:");
          ((StringBuilder)localObject).append(str2);
          QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, ((StringBuilder)localObject).toString());
          localObject = localStringBuilder;
          break label384;
        }
        if (paramMessageRecord.isread)
        {
          localTroopInfoManager.b(str2);
          localObject = localStringBuilder;
          if (!QLog.isColorLevel()) {
            break label384;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addMessageRecord:readed msg been removed:");
          ((StringBuilder)localObject).append(str2);
          QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, ((StringBuilder)localObject).toString());
          localObject = localStringBuilder;
          break label384;
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMessageRecord:msgInfo == null ");
        localStringBuilder.append(str2);
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, localStringBuilder.toString());
      }
    }
    else
    {
      localObject = localStringBuilder;
    }
    label384:
    if ((localObject != null) && (((MessageInfo)localObject).a()))
    {
      i = ((MessageInfo)localObject).b();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMessageRecord, bizType");
        localStringBuilder.append(i);
        localStringBuilder.append("|ru.msgType:");
        localStringBuilder.append(localRecentUser.msgType);
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, localStringBuilder.toString());
      }
      if (MessageInfo.a(i, localRecentUser.msgType))
      {
        localRecentUser.msgType = i;
        localRecentUser.msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, str1, (MessageInfo)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(UinTypeUtil.a(str1, k), localRecentUser);
      }
    }
    localObject = localRecentUser;
    if (localMap.containsKey(UinTypeUtil.a(localRecentUser.uin, localRecentUser.getType()))) {
      localObject = (RecentUser)localMap.get(UinTypeUtil.a(localRecentUser.uin, localRecentUser.getType()));
    }
    boolean bool2 = MsgProxyUtils.b(paramMessageRecord.msgtype);
    boolean bool1 = true;
    int j = bool2 ^ true;
    int i = j;
    if (paramMessageRecord.isLongMsg())
    {
      i = j;
      if (((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a(paramMessageRecord))
      {
        j = 0;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
          i = j;
        }
      }
    }
    if (i != 0)
    {
      ((RecentUser)localObject).uin = str1;
      ((RecentUser)localObject).setType(k);
      if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
        bool1 = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
      }
      if ((l > ((RecentUser)localObject).lastmsgtime) && (bool1))
      {
        ((RecentUser)localObject).lastmsgtime = l;
        localMap.put(UinTypeUtil.a(str1, k), localObject);
      }
    }
    super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afterCleanUnRead:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("-");
      localStringBuilder.append(paramLong);
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, localStringBuilder.toString());
    }
    super.a(paramString, paramInt, paramLong);
    c(paramString, paramInt, paramLong);
  }
  
  protected String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("afterCleanUnRead:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, ((StringBuilder)localObject).toString());
    }
    super.b(paramString, paramInt);
    Object localObject = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    paramString = ((RecentUserProxy)localObject).a(paramString, paramInt);
    if (RecentUserAppearLogic.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramString.msgType))
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      ((RecentUserProxy)localObject).b(paramString);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afterCleanUnRead:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("-");
      localStringBuilder.append(paramLong);
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getUnreadCount(paramString, paramInt) > 0) {
      c(paramString, paramInt, paramLong);
    }
    super.b(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageManager
 * JD-Core Version:    0.7.0.1
 */