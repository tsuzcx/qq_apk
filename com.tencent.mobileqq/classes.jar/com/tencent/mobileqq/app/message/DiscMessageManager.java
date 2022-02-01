package com.tencent.mobileqq.app.message;

import android.content.res.Resources;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class DiscMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public DiscMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, MsgPool paramMsgPool)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramMsgPool);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.a.getCurrentAccountUin().equals(paramString1)) {
      return this.a.getApp().getResources().getString(2131693939);
    }
    return ContactUtils.c(this.a, paramString2, paramString1);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:" + paramMessageRecord);
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
    localObject = null;
    TroopInfoManager localTroopInfoManager = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager;
    String str2;
    MessageInfo localMessageInfo;
    if (localTroopInfoManager != null)
    {
      str2 = str1 + "&" + 3000;
      localMessageInfo = localTroopInfoManager.a(str2);
      if (localMessageInfo == null) {
        break label642;
      }
      if (localMessageInfo.b() == paramMessageRecord.shmsgseq) {
        break label585;
      }
      localMessageInfo = null;
      localObject = localMessageInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
        localObject = localMessageInfo;
      }
    }
    int i;
    if ((localObject != null) && (((MessageInfo)localObject).a()))
    {
      i = ((MessageInfo)localObject).b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + i + "|ru.msgType:" + localRecentUser.msgType);
      }
      if (MessageInfo.a(i, localRecentUser.msgType))
      {
        localRecentUser.msgType = i;
        localRecentUser.msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a(this.a, str1, (MessageInfo)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(UinTypeUtil.a(str1, k), localRecentUser);
      }
    }
    if (localMap.containsKey(UinTypeUtil.a(localRecentUser.uin, localRecentUser.getType()))) {}
    for (localObject = (RecentUser)localMap.get(UinTypeUtil.a(localRecentUser.uin, localRecentUser.getType()));; localObject = localRecentUser)
    {
      if (!MsgProxyUtils.b(paramMessageRecord.msgtype)) {}
      for (i = 1;; i = 0)
      {
        int j = i;
        if (paramMessageRecord.isLongMsg())
        {
          j = i;
          if (this.a.getMsgCache().a(paramMessageRecord))
          {
            i = 0;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
              j = i;
            }
          }
        }
        if (j != 0)
        {
          ((RecentUser)localObject).uin = str1;
          ((RecentUser)localObject).setType(k);
          boolean bool = true;
          if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
            bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
          }
          if ((l > ((RecentUser)localObject).lastmsgtime) && (bool))
          {
            ((RecentUser)localObject).lastmsgtime = l;
            localMap.put(UinTypeUtil.a(str1, k), localObject);
          }
        }
        super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
        paramEntityManager = TeamWorkUtils.ProcessTDFileScheduler.a(this.a);
        paramEntityManager.a(paramMessageRecord);
        paramEntityManager.a();
        return;
        label585:
        localObject = localMessageInfo;
        if (!paramMessageRecord.isread) {
          break;
        }
        localTroopInfoManager.b(str2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
        }
        localObject = null;
        break;
        label642:
        localObject = localMessageInfo;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
        localObject = localMessageInfo;
        break;
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    super.a(paramString, paramInt, paramLong);
    c(paramString, paramInt, paramLong);
  }
  
  public String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt);
    }
    super.b(paramString, paramInt);
    ProxyManager localProxyManager = this.a.getProxyManager();
    paramString = localProxyManager.a().a(paramString, paramInt);
    if (RecentUserAppearLogic.a(this.a, paramString.msgType))
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      localProxyManager.a().b(paramString);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    if (this.a.getConversationFacade().a(paramString, paramInt) > 0) {
      c(paramString, paramInt, paramLong);
    }
    super.b(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageManager
 * JD-Core Version:    0.7.0.1
 */