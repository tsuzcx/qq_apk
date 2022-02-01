package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

public class HCTopicMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public HCTopicMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0) {
      return 0;
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (this.a.getCurrentAccountUin().equals(paramString1)) {
      paramString2 = HardCodeUtil.a(2131705535);
    } else {
      paramString2 = ContactUtils.b((QQAppInterface)this.a, paramString2, paramString1);
    }
    String str;
    if ((paramString2 != null) && (paramString2.length() != 0))
    {
      str = paramString2;
      if (!paramString2.equals(paramString1)) {}
    }
    else
    {
      str = ((QQAppInterface)this.a).getHotChatMng(true).a(true).a(paramString1);
    }
    if (str == null) {
      return paramString1;
    }
    return str;
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap2 = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Map localMap1 = paramAddMessageContext.d;
    Object localObject1 = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    boolean bool3 = true;
    Object localObject2 = ((RecentUserProxy)localObject1).a(str, 1);
    localObject1 = localObject2;
    if (localMap2.containsKey(UinTypeUtil.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType()))) {
      localObject1 = (RecentUser)localMap2.get(UinTypeUtil.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType()));
    }
    boolean bool2 = MsgProxyUtils.b(paramMessageRecord.msgtype) ^ true;
    boolean bool1 = bool2;
    if (paramMessageRecord.isLongMsg())
    {
      bool1 = bool2;
      if (((MessageCache)this.a.getMsgCache()).a(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
        }
        bool1 = false;
      }
    }
    if (bool1)
    {
      localObject2 = UinTypeUtil.a(str, 1);
      ((RecentUser)localObject1).uin = str;
      ((RecentUser)localObject1).setType(1);
      if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
        bool3 = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
      }
      if ((l > ((RecentUser)localObject1).lastmsgtime) && (bool3)) {
        ((RecentUser)localObject1).lastmsgtime = l;
      }
      localMap2.put(localObject2, localObject1);
      localObject1 = (MessageRecord)localMap1.get(localObject2);
      if ((localObject1 != null) && (!paramMessageRecord.isSendFromLocal()))
      {
        if (a(paramMessageRecord) >= a((MessageRecord)localObject1)) {
          localMap1.put(localObject2, paramMessageRecord);
        }
      }
      else {
        localMap1.put(localObject2, paramMessageRecord);
      }
    }
    if (paramMessageRecord.isSendFromLocal())
    {
      paramMessageRecord.extraflag = 32772;
      paramMessageRecord.sendFailCode = 0;
    }
    super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
  }
  
  protected String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2);
  }
  
  public void b(Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
    if ((paramMessage.nickName == null) || (paramMessage.nickName.equals(paramMessage.senderuin)))
    {
      Object localObject = paramMessage.nickName;
      try
      {
        String str = paramMessage.getExtInfoFromExtStr("hotchat_nick");
        localObject = str;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        paramMessage.nickName = ((String)localObject);
      }
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "processNickName", new Object[] { paramMessage.senderuin, paramMessage.nickName });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.HCTopicMessageManager
 * JD-Core Version:    0.7.0.1
 */