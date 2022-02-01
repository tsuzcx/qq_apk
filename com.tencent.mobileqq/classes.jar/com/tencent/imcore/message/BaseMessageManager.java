package com.tencent.imcore.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.adder.IAddMessageHandler;
import com.tencent.imcore.message.aiolist.IAioMsgHandler;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallback;
import com.tencent.imcore.message.decoder.IMessageDecoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.revokemsg.RevokeMsgInfo;>;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public abstract class BaseMessageManager
  extends Observable
  implements IMessageManager
{
  protected static BaseMessageManager.Callback a;
  protected MsgPool a;
  protected IConversationFacade a;
  public IMessageFacade a;
  private Object a;
  public AppRuntime a;
  private Object b = new Object();
  
  static {}
  
  public BaseMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade = ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade = ((IConversationFacade)paramAppRuntime.getRuntimeService(IConversationFacade.class, ""));
    this.jdField_a_of_type_ComTencentImcoreMessageMsgPool = paramMsgPool;
  }
  
  private long a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject1 = null;
    int i = UinTypeUtil.a(paramInt);
    Object localObject2 = "";
    if (i == 1009)
    {
      localObject1 = a(paramInt).a(AppConstants.SAME_STATE_BOX_UIN, 1009);
    }
    else if (UinTypeUtil.a(paramInt) == 1001)
    {
      localObject1 = a(paramInt).a(AppConstants.LBS_HELLO_UIN, 1001);
      localObject2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
    }
    else if (UinTypeUtil.a(paramInt) == 1010)
    {
      localObject1 = a(paramInt).a(AppConstants.DATE_UIN, 1010);
      localObject2 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
    }
    else if (UinTypeUtil.a(paramInt) == 10002)
    {
      localObject1 = a(paramInt).a(AppConstants.LBS_HELLO_UIN, 10002);
      localObject2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
    }
    int k = 0;
    i = 0;
    int j = k;
    if (localObject1 != null)
    {
      j = k;
      if (!((List)localObject1).isEmpty())
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
          if (paramString.equals(localMessageRecord.senderuin)) {
            return localMessageRecord.uniseq;
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(localMessageRecord.senderuin)) || (AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(localMessageRecord.senderuin)))) {
            i = 1;
          }
        }
      }
    }
    if (j != 0)
    {
      localObject1 = a(paramInt).a((String)localObject2, UinTypeUtil.a(paramInt));
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (paramString.equals(((MessageRecord)localObject2).senderuin)) {
            return ((MessageRecord)localObject2).uniseq;
          }
        }
      }
    }
    return 0L;
  }
  
  @Nullable
  private Message a(String paramString, Message paramMessage, StringBuilder paramStringBuilder)
  {
    try
    {
      Message localMessage = (Message)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().get(paramString);
      if (localMessage == null)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().put(paramString, paramMessage);
        return paramMessage;
      }
      if (a(localMessage) < a(paramMessage))
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().put(paramString, paramMessage);
        return paramMessage;
      }
      if ((!localMessage.isCacheValid) && (paramMessage.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().put(paramString, paramMessage);
        return paramMessage;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append(" : case 4 :invalid inplace");
      }
      localMessage.isCacheValid = true;
      return localMessage;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", paramString);
      }
    }
    return paramMessage;
  }
  
  private UniteGrayTipParam a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MessageForUniteGrayTip paramMessageForUniteGrayTip, long paramLong)
  {
    String str1 = a(paramInt, paramString2, paramString3, paramMessageForUniteGrayTip, "");
    String str2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697710);
    int i = paramString1.length() + str2.length();
    int j = str1.length() + i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697711));
    paramString1 = localStringBuilder.toString();
    paramString3 = new UniteGrayTipParam(paramString3, paramString4, paramString1, paramInt, -5040, 1, paramLong);
    paramString4 = new Bundle();
    a(paramMessageForUniteGrayTip, paramString4);
    paramString4.putInt("key_action", 28);
    paramString4.putString("troop_mem_uin", String.valueOf(paramString2));
    paramString4.putBoolean("need_update_nick", true);
    paramString3.a(i, j, paramString4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke message wording", paramString1, Integer.valueOf(i), " end:", Integer.valueOf(j) });
    }
    return paramString3;
  }
  
  private String a(int paramInt, String paramString1, String paramString2, MessageForUniteGrayTip paramMessageForUniteGrayTip, String paramString3)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt, paramString1, paramString2, paramMessageForUniteGrayTip, paramString3);
  }
  
  public static void a(BaseMessageManager.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback = paramCallback;
  }
  
  private void a(MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (paramMessage.uniseq == paramMessageRecord.uniseq)
    {
      MessageRecord.copyMessageRecordStatusField(paramMessage, paramMessageRecord);
      return;
    }
    MessageRecord.copyMessageRecordBaseField(paramMessage, paramMessageRecord);
    paramMessage.emoRecentMsg = null;
    paramMessage.fileType = -1;
    paramMessage.lastMsg = null;
    try
    {
      a(paramMessage);
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(paramMessage);
    }
    if ((!String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(paramMessage.frienduin)) && ((!UinTypeUtil.a(paramMessage)) || (MsgProxyUtils.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord))))
    {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(paramMessageRecord, paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(paramMessage);
    }
    if (((paramMessage.msgtype == -2009) || (paramMessage.msgtype == -2016)) && (paramBoolean))
    {
      Message localMessage = new Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      localMessage.emoRecentMsg = null;
      localMessage.fileType = -1;
      paramMessage.lastMsg = null;
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(localMessage);
    }
    if (AppConstants.TROOP_SYSTEM_MSG_UIN.equals(paramMessage.frienduin))
    {
      int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getIncomingMsg().unReadNum = i;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(null);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean, Message paramMessage)
  {
    MessageRecord.copyMessageRecordBaseField(paramMessage, paramMessageRecord);
    paramMessage.emoRecentMsg = null;
    paramMessage.fileType = -1;
    paramMessage.lastMsg = null;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessage)) {
        bool = true;
      }
    }
    if (bool) {
      try
      {
        a(paramMessage);
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
        }
      }
    }
  }
  
  private void a(String paramString, Message paramMessage)
  {
    if (((paramString.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN)))) && (paramMessage.msgData != null)) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(null, paramMessage);
    }
  }
  
  private boolean a(Message paramMessage)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRegistry().b().iterator();
    while (localIterator.hasNext()) {
      if (((ExtractMessageSummaryCallback)localIterator.next()).a(paramMessage)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord, Message paramMessage)
  {
    int i = paramMessageRecord.istroop;
    boolean bool1 = true;
    if ((i != 3000) && (paramMessageRecord.istroop != 1))
    {
      if ((!UinTypeUtil.b(paramMessageRecord.istroop)) || (paramMessageRecord.isSendFromLocal()) || (paramMessageRecord.time >= paramMessage.time)) {
        bool1 = false;
      }
    }
    else {
      bool1 = a(paramMessageRecord, paramMessage, false);
    }
    boolean bool2 = bool1;
    if (UinTypeUtil.d(paramMessageRecord.senderuin))
    {
      bool2 = bool1;
      if (TextUtils.equals(paramMessageRecord.senderuin, paramMessage.senderuin)) {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private boolean a(MessageRecord paramMessageRecord, Message paramMessage, boolean paramBoolean)
  {
    int j = (int)(paramMessage.shmsgseq - paramMessageRecord.shmsgseq);
    int k;
    boolean bool;
    if (paramMessageRecord.msgtype != -1012)
    {
      k = j;
      bool = paramBoolean;
      if (paramMessageRecord.msgtype != -5021) {}
    }
    else
    {
      if ((paramMessage.msgtype != -1012) && (paramMessage.msgtype != -5021)) {
        k = 0;
      } else {
        k = 1;
      }
      int i = j;
      if (j == 0) {
        if (k != 0) {
          i = (int)(paramMessage.time - paramMessageRecord.time);
        } else {
          i = -1;
        }
      }
      if (i > 0) {
        paramBoolean = true;
      }
      k = i;
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("updateMsgTab mrIsOld ");
        paramMessage.append(paramBoolean);
        QLog.d("GrayTipsForTroop", 2, paramMessage.toString());
        bool = paramBoolean;
        k = i;
      }
    }
    paramBoolean = bool;
    if (!paramMessageRecord.isSendFromLocal())
    {
      paramBoolean = bool;
      if (k > 0) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  private void d(Message paramMessage)
  {
    if (((!AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin)) && ((UinTypeUtil.a(paramMessage.istroop) == 1001) || (UinTypeUtil.a(paramMessage.istroop) == 10002))) || (UinTypeUtil.a(paramMessage.istroop) == 10010) || ((!AppConstants.DATE_UIN.equals(paramMessage.frienduin)) && (UinTypeUtil.a(paramMessage.istroop) == 1010)))
    {
      Object localObject = a(paramMessage.istroop).b(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) && (!MessageUtils.a(localMessageRecord.msgtype)))
          {
            paramMessage.hasReply = true;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("refreshSingleLastMsg = ");
              ((StringBuilder)localObject).append(paramMessage);
              ((StringBuilder)localObject).append(",hasReply=");
              ((StringBuilder)localObject).append(paramMessage.hasReply);
              QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0) {
      if (paramInt == 2)
      {
        if ((!jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 6)
      {
        if (((paramConversationInfo.type == 1001) || (paramConversationInfo.type == 10002)) && (AppConstants.LBS_HELLO_UIN.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.SAME_STATE_BOX_UIN)) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(AppConstants.DATE_UIN)) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 9)
      {
        if ((paramConversationInfo.type == 1008) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 10)
      {
        if (((paramConversationInfo.type == 0) || (paramConversationInfo.type == 1) || (paramConversationInfo.type == 3000)) && (!jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else {
        return ConversationFacade.a(paramConversationInfo);
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearHistory uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", needDeleteDB = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.removeUnreadItem(paramString, paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(paramString, paramInt);
    int i = a(paramInt).a(paramString, paramInt, paramBoolean1);
    if (paramInt == 0) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString);
    }
    if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.clearTransFileInfo(paramString);
    }
    if (i > 0) {
      ((Message)localObject).cleanMessageRecordBaseField();
    }
    if ((paramInt != 3000) && (paramInt != 1) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isInMsgBox(paramString, UinTypeUtil.a(paramInt)))) {
      if (UinTypeUtil.a(paramInt) == 1009) {
        a(paramString, AppConstants.SAME_STATE_BOX_UIN, 1009);
      } else if (UinTypeUtil.a(paramInt) == 1001) {
        a(paramString, AppConstants.LBS_HELLO_UIN, 1001);
      } else if (UinTypeUtil.a(paramInt) == 1010) {
        a(paramString, AppConstants.DATE_UIN, 1010);
      } else if (UinTypeUtil.a(paramInt) == 10002) {
        a(paramString, AppConstants.LBS_HELLO_UIN, 10002);
      } else if (UinTypeUtil.a(paramInt) == 1044) {
        a(paramString, AppConstants.MATCH_CHAT_UIN, 1044);
      } else if (UinTypeUtil.a(paramInt) == 10008) {
        a(paramString, AppConstants.QCIRCLE_CHAT_UIN, 10008);
      }
    }
    if (paramBoolean2)
    {
      RecentUser localRecentUser = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(paramString, ((Message)localObject).istroop);
      if (localRecentUser != null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.removeRecentUser(localRecentUser);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().remove(UinTypeUtil.a(paramString, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(localObject);
    return i;
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public BaseMsgProxy a(int paramInt)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(paramInt, this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    if (paramString == null) {
      return new Message();
    }
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt);
    String str = UinTypeUtil.a(paramString, paramInt);
    Object localObject1 = null;
    Object localObject2 = (Message)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().get(str);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("CACHE : refreshSingleLastMsg:uin:");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(" uinType:");
    ((StringBuilder)localObject3).append(paramInt);
    StringBuilder localStringBuilder = new StringBuilder(((StringBuilder)localObject3).toString());
    if ((localObject2 != null) && (((Message)localObject2).isCacheValid))
    {
      paramString = (String)localObject1;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" : case 5 : not null or isValid : ");
        paramString.append(localObject2);
        localStringBuilder.append(paramString.toString());
        paramString = (String)localObject1;
      }
    }
    else
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      localObject2 = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a((String)localObject1, paramString);
      Message localMessage = a(paramInt).a((String)localObject2, paramEntityManager);
      localObject3 = localObject2;
      localObject1 = localMessage;
      if (localMessage == null) {
        if ((!UinTypeUtil.b(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject2;
          localObject1 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject1 = a(paramInt).a((String)localObject3, paramEntityManager);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" message:");
        ((StringBuilder)localObject2).append(localObject1);
        localStringBuilder.append(((StringBuilder)localObject2).toString());
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((Message)localObject1).uniseq == 0L)
        {
          a(((Message)localObject1).istroop).b(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
          paramEntityManager = a(((Message)localObject1).istroop).a((String)localObject3, paramEntityManager);
          localObject2 = paramEntityManager;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("CACHE : requeryLastMessage = ");
            ((StringBuilder)localObject1).append(paramEntityManager);
            QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject1).toString());
            localObject2 = paramEntityManager;
          }
        }
      }
      if ((localObject2 != null) && (((Message)localObject2).isSendFromLocal()) && (((Message)localObject2).extraflag == 32772) && (!((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).b((MessageRecord)localObject2)))
      {
        QLog.e("Q.msg.BaseMessageManager", 1, new Object[] { "set sending message FAILED: ", localObject2 });
        ((Message)localObject2).setExtraFlag(32768);
      }
      if (localObject2 != null)
      {
        a(paramString, (Message)localObject2);
        d((Message)localObject2);
      }
      else
      {
        localObject2 = new Message();
        ((Message)localObject2).frienduin = paramString;
        ((Message)localObject2).istroop = paramInt;
      }
      paramString = a(str, (Message)localObject2, localStringBuilder);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (UinTypeUtil.a(paramString.frienduin, paramString.istroop))) {
      paramString.istroop = UinTypeUtil.a(paramString.istroop);
    }
    return paramString;
  }
  
  public Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    int i;
    if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return b(paramString, paramInt1, paramEntityManager, paramInt2);
    }
    return a(paramString, paramInt1, paramEntityManager);
  }
  
  public String a(int paramInt, String paramString1, String paramString2, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt, paramString1, paramString2, paramMessageForUniteGrayTip);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return new ArrayList();
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (paramLong >= 0L) {
      localObject1 = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
    } else {
      localObject1 = a(paramInt1).a(paramString, paramInt1, paramInt2, true);
    }
    if (localObject1 == null) {
      return new ArrayList();
    }
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this, this.jdField_a_of_type_MqqAppAppRuntime, paramInt1, paramString, (List)localObject2, null, false, true);
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a((List)localObject2, this.jdField_a_of_type_MqqAppAppRuntime);
    MsgProxyUtils.a(paramString, paramInt1, (List)localObject2, (MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache());
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, paramString, paramInt1, (List)localObject2, this);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("newAIOCursor clone ");
      ((StringBuilder)localObject1).append(Integer.valueOf(((List)localObject2).size()));
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator1 = ((List)localObject2).iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (MessageRecord)localIterator1.next();
      Iterator localIterator2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRegistry().h().iterator();
      while (localIterator2.hasNext())
      {
        Object[] arrayOfObject = ((IAioMsgHandler)localIterator2.next()).a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt1, paramBoolean, localArrayList1, localArrayList2, (List)localObject1, (MessageRecord)localObject2);
        localObject2 = (MessageRecord)arrayOfObject[0];
        if (((Boolean)arrayOfObject[1]).booleanValue()) {
          break;
        }
      }
    }
    if (!paramBoolean) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, localArrayList2, (List)localObject1);
    }
    return localArrayList1;
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<MessageRecord> a(List<MessageRecord> paramList, String paramString, int paramInt, ArrayList<RevokeMsgInfo> paramArrayList)
  {
    int j = 1;
    int i = j;
    if (paramInt != 3000) {
      if (paramInt == 1) {
        i = j;
      } else {
        i = 0;
      }
    }
    paramString = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.next();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((i != 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long))
        {
          if (((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!MsgProxyUtils.a(localMessageRecord))) {
            paramString.add(localMessageRecord);
          }
        }
        else if ((i == 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long) && (localMessageRecord.msgUid == localRevokeMsgInfo.jdField_b_of_type_Long) && (TextUtils.equals(localMessageRecord.senderuin, localRevokeMsgInfo.jdField_b_of_type_JavaLangString))) {
          paramString.add(localMessageRecord);
        }
      }
    }
    return paramString;
  }
  
  protected List<MessageRecord> a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    return (List)this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.a().get(UinTypeUtil.a(paramString, paramInt));
  }
  
  public void a()
  {
    try
    {
      synchronized (this.b)
      {
        this.b.wait(15000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait over");
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait interrupted");
      }
      return;
    }
  }
  
  public <T extends MessageRecord> void a(int paramInt, String paramString, T paramT, List<T> paramList)
  {
    paramString = this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.a(paramString, paramInt);
    paramString.lock();
    try
    {
      MsgProxyUtils.a(paramList, paramT, true);
      return;
    }
    finally
    {
      paramString.unlock();
    }
  }
  
  public void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (a(paramMessage)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRegistry().f().iterator();
    while (localIterator.hasNext()) {
      ((IMessageDecoder)localIterator.next()).a(paramMessage, this, this.jdField_a_of_type_MqqAppAppRuntime);
    }
  }
  
  protected void a(RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramRefreshMessageContext.i)
      {
        paramRefreshMessageContext.i = false;
        this.jdField_a_of_type_JavaLangObject.notify();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
        }
      }
      return;
    }
  }
  
  protected void a(RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    if ((paramRefreshMessageContext.jdField_a_of_type_JavaUtilList != null) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0)) {
      synchronized (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList)
      {
        jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(paramRefreshMessageContext.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_MqqAppAppRuntime);
        if (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0) {
          MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaLangString, paramRefreshMessageContext.jdField_d_of_type_Int, paramRefreshMessageContext.jdField_a_of_type_JavaUtilList, (MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache());
        }
        i = 1;
      }
    }
    int i = 0;
    ??? = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    int j = paramRefreshMessageContext.jdField_e_of_type_Int;
    if ((paramRefreshMessageContext.jdField_d_of_type_Boolean) && (i != 0) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramRefreshMessageContext.jdField_a_of_type_Int < 9))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:");
        localStringBuilder.append(paramRefreshMessageContext.jdField_a_of_type_Int);
        localStringBuilder.append(" ]");
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramRefreshMessageContext.jdField_a_of_type_Int += 1;
      b((String)???, paramInt, j, paramRefreshMessageContext);
      return;
    }
    paramRefreshMessageContext.jdField_a_of_type_Int = 0;
    paramRefreshMessageContext.b = 0;
    if (paramRefreshMessageContext.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
    }
  }
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramInt == 1) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (!String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(paramMessageRecord.frienduin))) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(null);
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, true);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramEntityManager = paramAddMessageContext.d;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    paramAddMessageContext = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addMessage set sendmsg extra ");
        ((StringBuilder)localObject).append(paramMessageRecord.getBaseInfoString());
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
      }
      paramMessageRecord.setExtraFlag(32772);
      paramMessageRecord.setSendFailCode(0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRegistry().g().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IAddMessageHandler)((Iterator)localObject).next()).a(this.jdField_a_of_type_MqqAppAppRuntime, this, paramMessageRecord, paramBoolean1, paramBoolean2, paramBoolean4, paramEntityManager, paramAddMessageContext, i);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(paramMessageRecord, localArrayList);
    int i = 0;
    if (bool)
    {
      bool = UinTypeUtil.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop));
    }
    else
    {
      localArrayList.add(paramMessageRecord);
      if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.isTheLastTabMsg(paramMessageRecord)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->removeMsgByMessageRecord :");
      ((StringBuilder)localObject).append(paramMessageRecord);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().containsKey(localObject))
    {
      localObject = (Message)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().get(localObject);
      if ((!paramMessageRecord.isread) && (localObject != null)) {
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.decreaseUnread(((Message)localObject).frienduin, ((Message)localObject).istroop, (MessageRecord)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.stopHttpProcessorIfNeed(paramMessageRecord);
    int j = localArrayList.size();
    while (i < j)
    {
      localObject = (MessageRecord)localArrayList.get(i);
      a(((MessageRecord)localObject).istroop).a((MessageRecord)localObject, paramBoolean2);
      ((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).c((MessageRecord)localObject);
      i += 1;
    }
    if (paramBoolean1) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, null, paramMessageRecord);
    }
    if (bool) {
      b(paramMessageRecord);
    }
    if (paramBoolean2) {
      a(paramMessageRecord.istroop).d();
    }
  }
  
  public void a(MessageForUniteGrayTip paramMessageForUniteGrayTip, Bundle paramBundle)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(paramMessageForUniteGrayTip, paramBundle);
  }
  
  protected void a(String paramString, int paramInt)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.b(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt1;
    paramRefreshMessageContext.jdField_e_of_type_Int = paramInt2;
    String str;
    if (UinTypeUtil.a(paramInt1) != 1032) {
      str = UinTypeUtil.a(paramString, paramInt1);
    } else {
      str = UinTypeUtil.a(paramString, paramInt1, paramRefreshMessageContext.jdField_f_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().containsKey(str))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshMessageListHead UNFINISHED ERROR uin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", type = ");
        localStringBuilder.append(paramInt1);
        QLog.w("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      if ((paramRefreshMessageContext.i) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("numTroopRefresh = ");
        localStringBuilder.append(paramRefreshMessageContext.i);
        localStringBuilder.append(", refreshActionMap[");
        localStringBuilder.append(UinTypeUtil.a(paramString, paramInt1));
        localStringBuilder.append("] = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().get(str));
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().put(str, Boolean.valueOf(true));
    ThreadManager.executeOnNetWorkThread(new BaseMessageManager.RefreshRunnable(paramString, paramInt1, paramInt2, paramRefreshMessageContext, str, this));
  }
  
  protected void a(String paramString, int paramInt, long paramLong) {}
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setReadFrom uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",from=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",force=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong < 0L) {
      return;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getUnreadCount(paramString, paramInt) <= 0) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.cleanUnread(paramString, paramInt, paramLong, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.cleanUnreadFrom(paramString, paramInt, paramLong);
    a(paramString, paramInt, paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    ((IMessageFacade)localObject).setChangeAndNotify(((IMessageFacade)localObject).getLastMessage(paramString, paramInt));
    a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = a(paramInt1).b(paramString, paramInt1);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg()))
    {
      if ((UinTypeUtil.a(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
      {
        a(paramMessageRecord, true, paramInt2);
        b(paramString, paramInt1, paramMessageRecord, paramInt2);
      }
    }
    else if ((paramMessageRecord != null) && (localList != null) && (!localList.isEmpty()) && (paramMessageRecord.uniseq == ((MessageRecord)localList.get(localList.size() - 1)).uniseq))
    {
      a(paramMessageRecord, true, paramInt2);
      b(paramString, paramInt1, paramMessageRecord, paramInt2);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, paramString2, paramString3, true);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, this, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade, paramString1, paramInt, paramString2, paramString3, paramLong);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramInt, paramString2, paramString3, paramInt, 0, paramBoolean);
  }
  
  public abstract void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle);
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setReaded uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",type=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",needDelMark=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
      }
      return;
    }
    boolean bool1 = a(paramString, paramInt1);
    boolean bool2 = true;
    IConversationFacade localIConversationFacade;
    long l;
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getUnreadCount(paramString, paramInt1) > 0)
      {
        localObject = a(paramInt1).a(paramString, paramInt1);
        localIConversationFacade = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade;
        if (localObject != null) {
          l = a((MessageRecord)localObject);
        } else {
          l = 0L;
        }
        localIConversationFacade.cleanUnread(paramString, paramInt1, l, paramBoolean1, paramBoolean2);
        b(paramString, paramInt1);
        paramBoolean1 = bool2;
        break label319;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getUnreadCountConfess(paramString, paramInt1, paramInt2) > 0)
      {
        localObject = a(paramInt1).a(paramString, paramInt1, paramInt2);
        localIConversationFacade = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade;
        if (localObject != null) {
          l = a((MessageRecord)localObject);
        } else {
          l = 0L;
        }
        localIConversationFacade.cleanUnread(paramString, paramInt1, l, paramBoolean1, paramBoolean2, paramInt2);
        b(paramString, paramInt1);
        paramBoolean1 = bool2;
        break label319;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
      }
    }
    paramBoolean1 = bool1;
    label319:
    if (paramBoolean1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      ((IMessageFacade)localObject).setChangeAndNotify(((IMessageFacade)localObject).getLastMessage(paramString, paramInt1, paramInt2));
      a(paramString, paramInt1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString2, paramInt, paramString1, this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(paramString2, paramInt);
    if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1))) {
      paramString2.cleanMessageRecordBaseField();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAIOList(paramString1, paramInt);
    if (localObject2 != null)
    {
      if (((List)localObject2).isEmpty()) {
        return;
      }
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((TextUtils.equals(localMessageRecord.frienduin, paramString1)) && (TextUtils.equals(localMessageRecord.getExtInfoFromExtStr("uint64_tips_seq_id"), paramString3)) && (TextUtils.equals(localMessageRecord.getExtInfoFromExtStr("uint64_busi_id"), paramString2)) && (jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(localMessageRecord))) {
          ((List)localObject1).add(localMessageRecord);
        }
      }
      if (((List)localObject1).isEmpty())
      {
        QLog.e("Q.msg.BaseMessageManager", 1, "doRevokePaiYiPaiNotify Can't find PaiYiPai Msg");
        return;
      }
      paramString2 = (MessageForUniteGrayTip)((List)localObject1).get(0);
      boolean bool = TextUtils.equals(paramString2.getExtInfoFromExtStr("pai_yi_pai_trigger_from_local"), "1");
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.removeMsgByUniseq(paramString2.frienduin, paramString2.istroop, paramString2.uniseq, true);
      paramString3 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      ((StringBuilder)localObject1).append("_pai_yi_pai_revoke");
      paramString3 = paramString3.getSharedPreferences(((StringBuilder)localObject1).toString(), 0);
      if ((paramString3.getBoolean("first_time_revoke_pai_yi_pai", true)) && (bool) && (paramBoolean))
      {
        paramString3.edit().putBoolean("first_time_revoke_pai_yi_pai", false).apply();
        paramString3 = a(paramInt).e(paramString1, paramInt);
        if (paramString3 != null)
        {
          if (paramString3.isEmpty()) {
            return;
          }
          paramString2 = UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString2);
          a(paramInt, paramString1, paramString2, paramString3);
          UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString2);
        }
        else
        {
          return;
        }
      }
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.b(this.jdField_a_of_type_MqqAppAppRuntime);
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    Object localObject5 = (RevokeMsgInfo)paramArrayList.get(0);
    int i = ((RevokeMsgInfo)localObject5).jdField_a_of_type_Int;
    String str1 = ((RevokeMsgInfo)localObject5).jdField_a_of_type_JavaLangString;
    Object localObject4 = ((RevokeMsgInfo)localObject5).jdField_b_of_type_JavaLangString;
    int j = ((RevokeMsgInfo)localObject5).jdField_e_of_type_Int;
    int k = ((RevokeMsgInfo)localObject5).g;
    String str2 = ((RevokeMsgInfo)localObject5).jdField_f_of_type_JavaLangString;
    boolean bool = QLog.isColorLevel();
    Object localObject1 = "Q.msg.BaseMessageManager";
    if (bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("revoke msg doReplaceRevokedMsgAndNotify frienduin = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(", fromUin = ");
      ((StringBuilder)localObject2).append((String)localObject4);
      ((StringBuilder)localObject2).append(", istroop = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", grayTipsWordingId = ");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(", senderUin = ");
      ((StringBuilder)localObject2).append(((RevokeMsgInfo)localObject5).d);
      QLog.w("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = a(i).d(str1, i);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      List localList = a((List)localObject2, str1, i, paramArrayList);
      if ((localList != null) && (!localList.isEmpty()))
      {
        if ((localList != null) && (localList.size() == 1) && (UniteGrayTipMsgUtil.a((MessageRecord)localList.get(0))))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify same gray msg");
          }
          paramArrayList = (MessageRecord)localList.get(0);
          if ((paramArrayList instanceof MessageForUniteGrayTip)) {
            UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageForUniteGrayTip)paramArrayList, i);
          }
          return;
        }
        localObject2 = (MessageRecord)localList.get(0);
        Object localObject3 = localList.iterator();
        paramArrayList = (ArrayList<RevokeMsgInfo>)localObject1;
        localObject1 = localObject3;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          if ((((MessageRecord)localObject3).shmsgseq == ((RevokeMsgInfo)localObject5).jdField_a_of_type_Long) && (((MessageRecord)localObject3).msgUid == ((RevokeMsgInfo)localObject5).jdField_b_of_type_Long))
          {
            localObject1 = localObject3;
            break label405;
          }
        }
        localObject1 = localObject2;
        label405:
        ArrayList<RevokeMsgInfo> localArrayList = paramArrayList;
        localObject2 = new MessageForUniteGrayTip();
        this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697713);
        String str3 = this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697712);
        this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697709);
        k = ((RevokeMsgInfo)localObject5).jdField_f_of_type_Int;
        long l;
        if ((j != 1) && (j != 2))
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append(HardCodeUtil.a(2131701239));
          paramArrayList.append(BaseApplication.getContext().getString(2131694325));
          localObject3 = paramArrayList.toString();
          localObject5 = ((MessageRecord)localObject1).senderuin;
          if (k == 1)
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append(HardCodeUtil.a(2131701239));
            paramArrayList.append(str3);
            paramArrayList = paramArrayList.toString();
          }
          else
          {
            paramArrayList = (ArrayList<RevokeMsgInfo>)localObject3;
            if (!TextUtils.isEmpty(str2))
            {
              paramArrayList = (ArrayList<RevokeMsgInfo>)localObject4;
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                paramArrayList = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
              }
              localObject4 = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramArrayList);
              if (!TextUtils.isEmpty((CharSequence)localObject4))
              {
                paramArrayList = (ArrayList<RevokeMsgInfo>)localObject4;
                if (((String)localObject4).length() > 9)
                {
                  paramArrayList = new StringBuilder();
                  paramArrayList.append(((String)localObject4).substring(0, 8));
                  paramArrayList.append("...");
                  paramArrayList = paramArrayList.toString();
                }
                localObject3 = paramArrayList.concat(BaseApplication.getContext().getString(2131694325));
              }
              paramArrayList = new StringBuilder();
              paramArrayList.append("，");
              paramArrayList.append(str2);
              paramArrayList = ((String)localObject3).concat(paramArrayList.toString());
            }
          }
          l = ((MessageRecord)localObject1).time;
          localObject4 = localObject5;
          localObject3 = new UniteGrayTipParam(str1, (String)localObject5, paramArrayList, i, -5040, 1, l);
        }
        else
        {
          localObject3 = HardCodeUtil.a(2131701244);
          paramArrayList = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
          if (((MessageRecord)localList.get(0)).msgtype != -2006) {
            l = ((MessageRecord)localList.get(0)).time;
          } else {
            l = ((RevokeMsgInfo)localObject5).jdField_c_of_type_Long;
          }
          if ((((RevokeMsgInfo)localObject5).d != null) && (!a(((RevokeMsgInfo)localObject5).d)))
          {
            localObject3 = a(i, (String)localObject3, ((RevokeMsgInfo)localObject5).d, str1, paramArrayList, (MessageForUniteGrayTip)localObject2, l);
            localObject4 = ((UniteGrayTipParam)localObject3).c;
          }
          else
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append(HardCodeUtil.a(2131701241));
            paramArrayList.append(BaseApplication.getContext().getString(2131697713));
            localObject4 = paramArrayList.toString();
            if (k == 1) {
              localObject4 = ((String)localObject3).concat(str3);
            }
            paramArrayList = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
            l = ((MessageRecord)localObject1).time;
            localObject3 = new UniteGrayTipParam(str1, paramArrayList, (String)localObject4, i, -5040, 1, l);
          }
          localObject5 = localObject4;
          localObject4 = paramArrayList;
          paramArrayList = (ArrayList<RevokeMsgInfo>)localObject5;
        }
        localObject5 = str1;
        ((UniteGrayTipParam)localObject3).e = true;
        ((UniteGrayTipParam)localObject3).jdField_f_of_type_Boolean = false;
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_MqqAppAppRuntime, (UniteGrayTipParam)localObject3);
        ((MessageForUniteGrayTip)localObject2).msgUid = ((MessageRecord)localObject1).msgUid;
        ((MessageForUniteGrayTip)localObject2).shmsgseq = ((MessageRecord)localObject1).shmsgseq;
        ((MessageForUniteGrayTip)localObject2).saveExtInfoToExtStr("revoke_op_type", String.valueOf(j));
        if (k == 1) {
          jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a((MessageForUniteGrayTip)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(localArrayList, 2, new Object[] { "revoke msg doReplaceRevokedMsgAndNotify senderUin=", localObject4, ",frienduin=", localObject5 });
        }
        UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageForUniteGrayTip)localObject2, localList, i, paramArrayList, (UniteGrayTipParam)localObject3);
        jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, true, 0, true, localList, (MessageRecord)localObject1);
        a(i, (String)localObject5, (MessageRecord)localObject2, a(i).e((String)localObject5, i));
        UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageForUniteGrayTip)localObject2);
        jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, null, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
      }
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, str1, i, BaseMessageProcessor.jdField_a_of_type_Int, BaseMessageProcessor.h);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: AIO is empty");
    }
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, str1, i, BaseMessageProcessor.jdField_a_of_type_Int, BaseMessageProcessor.g);
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.get(0);
    boolean bool1;
    if (localRevokeMsgInfo.jdField_c_of_type_Int > 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int n = localRevokeMsgInfo.jdField_a_of_type_Int;
    String str1 = localRevokeMsgInfo.jdField_b_of_type_JavaLangString;
    Object localObject3 = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
    Object localObject1 = localRevokeMsgInfo.d;
    Object localObject5 = localRevokeMsgInfo.jdField_e_of_type_JavaLangString;
    int j = localRevokeMsgInfo.jdField_e_of_type_Int;
    int i = localRevokeMsgInfo.jdField_f_of_type_Int;
    boolean bool2 = localRevokeMsgInfo.jdField_a_of_type_Boolean;
    int k = localRevokeMsgInfo.g;
    Object localObject4 = localRevokeMsgInfo.jdField_f_of_type_JavaLangString;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("revoke msg doHandleRevokedNotifyAndNotify fromUin = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(", istroop = ");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(",toUin=");
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append(",groupUin=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",authorUin=");
      ((StringBuilder)localObject2).append((String)localObject5);
      ((StringBuilder)localObject2).append(",opType= ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",anonyType ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", needShow = ");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(", grayTipsWordingId = ");
      ((StringBuilder)localObject2).append(k);
      QLog.i("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject2).toString());
    }
    String str2 = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    if ((n != 1004) && (n != 1000)) {
      localObject1 = str1;
    }
    paramBoolean = TextUtils.equals(str2, str1);
    Object localObject2 = localObject3;
    if (n != 3000) {
      if (n == 1) {
        localObject2 = localObject3;
      } else if (paramBoolean) {
        localObject2 = localObject3;
      } else {
        localObject2 = str1;
      }
    }
    localObject3 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      localObject6 = (RevokeMsgInfo)localIterator.next();
      localObject6 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.queryMsgItemByShmsgseq((String)localObject2, n, ((RevokeMsgInfo)localObject6).jdField_a_of_type_Long, ((RevokeMsgInfo)localObject6).jdField_b_of_type_Long);
      if ((localObject6 != null) && (!((List)localObject6).isEmpty()))
      {
        if (n == 0)
        {
          localObject6 = ((List)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (MessageRecord)((Iterator)localObject6).next();
            if (TextUtils.equals(((MessageRecord)localObject7).senderuin, str1)) {
              ((List)localObject3).add(localObject7);
            }
          }
        }
        ((List)localObject3).addAll((Collection)localObject6);
      }
    }
    int i1 = i;
    if (bool1) {
      try
      {
        Collections.sort((List)localObject3, MsgProxyUtils.a);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "sort long msg error", localException);
        }
      }
    }
    a((List)localObject3, "doHandleRevokedNotifyAndNotify");
    if (((List)localObject3).size() == 1)
    {
      if (UniteGrayTipMsgUtil.a((MessageRecord)((List)localObject3).get(0))) {
        return;
      }
      if (((MessageRecord)((List)localObject3).get(0)).msgtype == -2006)
      {
        if (jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a((MessageRecord)((List)localObject3).get(0), null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: msg is fold redbag msg");
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: same revoke msg");
        }
        return;
      }
    }
    if (((List)localObject3).isEmpty())
    {
      if (!((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isSyncNormalMsgFinish())
      {
        ((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a(paramArrayList);
        return;
      }
      k = 0;
    }
    else
    {
      k = 1;
    }
    if ((localRevokeMsgInfo.jdField_f_of_type_Int == 1) && (!paramBoolean))
    {
      if (j == 0) {
        m = 1;
      } else {
        m = 0;
      }
      if ((m != 0) && (((List)localObject3).size() > 0)) {
        paramBoolean = ((MessageRecord)((List)localObject3).get(0)).isSend();
      } else {
        paramBoolean = false;
      }
    }
    int m = j;
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    long l;
    if ((k != 0) && (((MessageRecord)((List)localObject3).get(0)).msgtype != -2006)) {
      l = ((MessageRecord)((List)localObject3).get(0)).time;
    } else {
      l = localRevokeMsgInfo.jdField_c_of_type_Long;
    }
    if (paramBoolean)
    {
      if ((m == 0) && (localRevokeMsgInfo.jdField_f_of_type_Int == 0) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
        paramArrayList = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, str1);
      } else {
        paramArrayList = HardCodeUtil.a(2131701243);
      }
    }
    else {
      paramArrayList = a(n, (String)localObject2, (String)localObject1, localMessageForUniteGrayTip);
    }
    Object localObject6 = localObject1;
    localObject1 = localObject2;
    this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697713);
    Object localObject7 = this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697712);
    localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697709);
    if ((m != 1) && (m != 2))
    {
      if (localRevokeMsgInfo.jdField_f_of_type_Int == 1)
      {
        if (paramBoolean) {
          paramArrayList = paramArrayList.concat((String)localObject7);
        } else {
          paramArrayList = (ArrayList<RevokeMsgInfo>)localObject2;
        }
      }
      else
      {
        localObject2 = paramArrayList;
        if (paramArrayList.length() > 9)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayList.substring(0, 8));
          ((StringBuilder)localObject2).append("...");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = ((String)localObject2).concat(BaseApplication.getContext().getString(2131694325));
        paramArrayList = (ArrayList<RevokeMsgInfo>)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("，");
          paramArrayList.append((String)localObject4);
          paramArrayList = ((String)localObject2).concat(paramArrayList.toString());
        }
      }
      paramArrayList = new UniteGrayTipParam((String)localObject1, (String)localObject6, paramArrayList, n, -5040, 1, l);
    }
    else
    {
      localObject4 = localObject1;
      if (TextUtils.equals(str1, this.jdField_a_of_type_MqqAppAppRuntime.getAccount()))
      {
        if ((localObject5 != null) && (!a((String)localObject5)))
        {
          paramArrayList = a(n, paramArrayList, (String)localObject5, (String)localObject4, (String)localObject6, localMessageForUniteGrayTip, l);
          localObject2 = paramArrayList.c;
        }
        else
        {
          localObject2 = paramArrayList.concat(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697713));
          if (i1 == 1) {
            paramArrayList = paramArrayList.concat((String)localObject7);
          } else {
            paramArrayList = (ArrayList<RevokeMsgInfo>)localObject2;
          }
          paramArrayList = new UniteGrayTipParam((String)localObject4, (String)localObject6, paramArrayList, n, -5040, 1, l);
        }
      }
      else
      {
        if (m == 2)
        {
          localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
          j = 2131697741;
        }
        else
        {
          localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
          j = 2131697740;
        }
        localObject2 = ((BaseApplication)localObject2).getString(j);
        j = ((String)localObject2).length();
        i1 = ((String)localObject2).length();
        int i2 = paramArrayList.length();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(paramArrayList);
        ((StringBuilder)localObject5).append(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131697713));
        paramArrayList = new UniteGrayTipParam((String)localObject4, (String)localObject6, ((StringBuilder)localObject5).toString(), n, -5040, 1, l);
        localObject2 = new Bundle();
        a(localMessageForUniteGrayTip, (Bundle)localObject2);
        ((Bundle)localObject2).putInt("key_action", 5);
        ((Bundle)localObject2).putString("troop_mem_uin", String.valueOf(str1));
        ((Bundle)localObject2).putBoolean("need_update_nick", true);
        paramArrayList.a(j, i1 + i2, (Bundle)localObject2);
      }
    }
    localObject2 = localObject1;
    localObject1 = localMessageForUniteGrayTip;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doHandleRevokedNotifyAndNotify isRevokeSender = ", Boolean.valueOf(paramBoolean), ",selfuin=", str2, ",fromUin=", str1 });
    }
    paramArrayList.e = true;
    paramArrayList.jdField_f_of_type_Boolean = false;
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_MqqAppAppRuntime, paramArrayList);
    if (k != 0) {
      l = ((MessageRecord)((List)localObject3).get(0)).msgUid;
    } else {
      l = localRevokeMsgInfo.jdField_b_of_type_Long;
    }
    ((MessageForUniteGrayTip)localObject1).msgUid = l;
    ((MessageForUniteGrayTip)localObject1).shmsgseq = localRevokeMsgInfo.jdField_a_of_type_Long;
    ((MessageForUniteGrayTip)localObject1).saveExtInfoToExtStr("revoke_op_type", String.valueOf(m));
    if (i == 1) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a((MessageForUniteGrayTip)localObject1);
    }
    if (paramBoolean) {
      UniteGrayTipMsgUtil.a((List)localObject3);
    }
    if (k != 0) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, bool1, n, bool2, (List)localObject3, null);
    }
    paramArrayList = a(n).e((String)localObject2, n);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      if (bool2) {
        a(n, (String)localObject2, (MessageRecord)localObject1, paramArrayList);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify: AIO is empty");
    }
    if (bool2) {
      UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageForUniteGrayTip)localObject1);
    } else if (((List)localObject3).size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(((List)localObject3).get(0));
    }
    if (k != 0)
    {
      paramArrayList = ((List)localObject3).iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (MessageRecord)paramArrayList.next();
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.cancelNotificationWhenRevokeMessage((MessageRecord)localObject1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.cancelNotificationWhenRevokeMessage((MessageRecord)localObject1);
    if ((k != 0) && (!((MessageRecord)((List)localObject3).get(0)).isread)) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime);
    }
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, (List)localObject3, paramBoolean);
  }
  
  protected void a(List<MessageRecord> paramList)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      if (paramList == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(localMessageRecord, null);
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (UniteGrayTipMsgUtil.a(localMessageRecord)) {
        QLog.d("Q.msg.BaseMessageManager", 1, new Object[] { "pull Revoke Gray Tip: ", paramString, localMessageRecord });
      }
    }
  }
  
  public void a(List<? extends MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    Object localObject1 = (MessageRecord)paramList.get(0);
    int i = 1;
    Object localObject3;
    while (i < paramList.size())
    {
      localObject3 = (MessageRecord)paramList.get(i);
      if ((((MessageRecord)localObject3).istroop != 1) && (((MessageRecord)localObject3).istroop != 3000))
      {
        if (((MessageRecord)localObject3).time <= ((MessageRecord)localObject1).time)
        {
          localObject2 = localObject1;
          if (((MessageRecord)localObject3).time != ((MessageRecord)localObject1).time) {
            break label197;
          }
          localObject2 = localObject1;
          if (((MessageRecord)localObject3).getId() <= ((MessageRecord)localObject1).getId()) {
            break label197;
          }
        }
      }
      else if (((MessageRecord)localObject3).shmsgseq <= ((MessageRecord)localObject1).shmsgseq)
      {
        localObject2 = localObject1;
        if (((MessageRecord)localObject3).shmsgseq != ((MessageRecord)localObject1).shmsgseq) {
          break label197;
        }
        localObject2 = localObject1;
        if (((MessageRecord)localObject3).getId() <= ((MessageRecord)localObject1).getId()) {
          break label197;
        }
      }
      localObject2 = localObject3;
      label197:
      i += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = paramList.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if (!jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a((MessageRecord)localObject3, localArrayList)) {
        localArrayList.add(localObject3);
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("-->removeMsgByMessageRecord :");
        ((StringBuilder)localObject4).append(localObject3);
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject4).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.stopHttpProcessorIfNeed((MessageRecord)localObject3);
    }
    localObject2 = UinTypeUtil.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
    if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().containsKey(localObject2))
    {
      localObject2 = (Message)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().get(localObject2);
      if (localObject2 != null)
      {
        localObject3 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject4 = (MessageRecord)paramList.next();
          if (!((MessageRecord)localObject4).isread) {
            ((List)localObject3).add(localObject4);
          }
        }
        if (((List)localObject3).size() != 0) {
          this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.decreaseUnreads(((Message)localObject2).frienduin, ((Message)localObject2).istroop, (List)localObject3);
        }
      }
    }
    a(((MessageRecord)localObject1).istroop).a(localArrayList, paramBoolean2);
    paramList = localArrayList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (MessageRecord)paramList.next();
      ((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).c((MessageRecord)localObject2);
    }
    if (paramBoolean1) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, null);
    }
    if (jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a((MessageRecord)localObject1, null))
    {
      paramBoolean1 = UinTypeUtil.a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop));
    }
    else
    {
      paramBoolean1 = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.isTheLastTabMsg((MessageRecord)localObject1)) {
        paramBoolean1 = true;
      }
    }
    if (paramBoolean1) {
      b((MessageRecord)localObject1);
    }
    if (paramBoolean2) {
      a(((MessageRecord)localObject1).istroop).d();
    }
  }
  
  public void a(boolean paramBoolean, Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMsgTab fin ");
      localStringBuilder.append(paramMessage.getBaseInfoString());
      localStringBuilder.append(" , result = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    if (UinTypeUtil.a(paramMessage.frienduin, paramMessage.istroop)) {
      paramMessage.istroop = UinTypeUtil.a(paramMessage.istroop);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (MessageRecordInfo.a(paramMessageRecord.issend)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMsgTab isBlessMsg:");
        localStringBuilder.append(paramMessageRecord.isBlessMsg);
        localStringBuilder.append(" needUpdateMsgTag:");
        localStringBuilder.append(paramMessageRecord.needUpdateMsgTag);
        localStringBuilder.append(" isCheckNeedShowInListTypeMsg:");
        localStringBuilder.append(paramMessageRecord.isCheckNeedShowInListTypeMsg);
        localStringBuilder.append(" needNeedShowInList:");
        localStringBuilder.append(paramMessageRecord.needNeedShowInList);
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      int i;
      if ((paramMessageRecord.isBlessMsg) && (paramMessageRecord.needUpdateMsgTag)) {
        i = 0;
      } else {
        i = 1;
      }
      int j = i;
      if (paramMessageRecord.isCheckNeedShowInListTypeMsg)
      {
        j = i;
        if (paramMessageRecord.needNeedShowInList) {
          j = 0;
        }
      }
      if (j != 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMsgTab ");
      ((StringBuilder)localObject).append(paramMessageRecord.getBaseInfoString());
      ((StringBuilder)localObject).append(",reason ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramMessageRecord;
    if (paramMessageRecord.isLongMsg())
    {
      if (((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a(paramMessageRecord))
      {
        a(paramMessageRecord, paramInt);
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.findLongMsgHead(paramMessageRecord);
    }
    if (((MessageRecord)localObject).istroop == 1036) {
      return false;
    }
    if (jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageRecord)localObject)) {
      return false;
    }
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (((MessageRecord)localObject).isValid)
    {
      bool1 = bool3;
      if (!MsgProxyUtils.b(((MessageRecord)localObject).msgtype)) {
        if (((MessageRecord)localObject).frienduin.equals(AppConstants.MAYKNOW_RECOMMEND_UIN))
        {
          bool1 = bool3;
          if (((MessageRecord)localObject).istroop == 0) {}
        }
        else if (((MessageRecord)localObject).frienduin.equals(AppConstants.FRIEND_ANNIVER_UIN))
        {
          bool1 = bool3;
          if (((MessageRecord)localObject).istroop == 0) {}
        }
        else
        {
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateMsgTab getLastMessage ");
            localStringBuilder.append(paramMessageRecord.getBaseInfoString());
            QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
          }
          if (a((MessageRecord)localObject)) {
            return false;
          }
          if (paramInt == 1)
          {
            bool1 = a((MessageRecord)localObject, paramMessageRecord);
            if (UinTypeUtil.a((MessageRecord)localObject, paramMessageRecord))
            {
              if (((MessageRecord)localObject).longMsgIndex >= paramMessageRecord.longMsgIndex) {
                return false;
              }
              bool1 = false;
            }
            paramBoolean = a((MessageRecord)localObject, paramBoolean, false, paramMessageRecord, bool1);
          }
          else
          {
            if ((paramInt != 4) && (paramInt != 2))
            {
              paramBoolean = bool2;
              if (paramInt != 3) {
                break label406;
              }
              a((MessageRecord)localObject, paramMessageRecord);
            }
            else
            {
              a((MessageRecord)localObject, paramBoolean, paramMessageRecord);
            }
            paramBoolean = true;
          }
          label406:
          a(paramBoolean, paramMessageRecord);
          bool1 = paramBoolean;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage, boolean paramBoolean3)
  {
    int j = 1;
    if (!paramBoolean3)
    {
      a(paramMessageRecord, paramBoolean1, paramMessage);
      paramBoolean2 = true;
    }
    if ((!paramMessageRecord.isSend()) && (!MessageUtils.a(paramMessageRecord.msgtype)))
    {
      paramMessage.hasReply = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMsgTab = ");
        localStringBuilder.append(paramMessage);
        localStringBuilder.append(",hasReply=");
        localStringBuilder.append(paramMessage.hasReply);
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
    }
    int i = j;
    if (paramMessageRecord.istroop != 1033) {
      if (paramMessageRecord.istroop == 1034) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (((!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (i == 0)) || (paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
      a(paramMessageRecord, paramMessage, paramBoolean3);
    }
    return paramBoolean2;
  }
  
  public boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "10000")) || (TextUtils.equals(paramString, "1000000")) || (TextUtils.equals(paramString, "50000000")) || (TextUtils.equals(paramString, "80000000")) || (b(paramString));
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.b(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt);
  }
  
  public Message b(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    if (paramString == null) {
      return new Message();
    }
    String str1 = UinTypeUtil.a(paramString, paramInt1);
    Object localObject = null;
    Message localMessage = (Message)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().get(str1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CACHE : refreshSingleLastMsg:uin:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" uinType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    if ((localMessage != null) && (localMessage.isCacheValid) && (localMessage.getConfessTopicId() == paramInt2))
    {
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" : case 5 : not null or isValid : ");
        paramString.append(localMessage);
        localStringBuilder.append(paramString.toString());
        paramString = (String)localObject;
      }
    }
    else
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      localMessage = a(paramInt1).a(str2, paramEntityManager, paramInt2);
      localObject = localMessage;
      if (localMessage != null)
      {
        localObject = localMessage;
        if (localMessage.uniseq == 0L)
        {
          a(localMessage.istroop).b(localMessage.frienduin, localMessage.istroop);
          paramEntityManager = a(localMessage.istroop).a(str2, paramEntityManager, paramInt2);
          localObject = paramEntityManager;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("CACHE : requeryLastMessage = ");
            ((StringBuilder)localObject).append(paramEntityManager);
            QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
            localObject = paramEntityManager;
          }
        }
      }
      paramEntityManager = (EntityManager)localObject;
      if (localObject == null)
      {
        paramEntityManager = new Message();
        paramEntityManager.frienduin = paramString;
        paramEntityManager.istroop = paramInt1;
        paramEntityManager.setConfessTopicId(paramInt2);
      }
      paramString = a(str1, paramEntityManager, localStringBuilder);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (UinTypeUtil.a(paramString.frienduin, paramString.istroop))) {
      paramString.istroop = UinTypeUtil.a(paramString.istroop);
    }
    return paramString;
  }
  
  public void b()
  {
    synchronized (this.b)
    {
      this.b.notify();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest notify");
      }
      return;
    }
  }
  
  public void b(Message paramMessage) {}
  
  protected void b(RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = paramRefreshMessageContext.i;
      if (bool)
      {
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(40000L);
        }
        catch (InterruptedException paramRefreshMessageContext)
        {
          paramRefreshMessageContext.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage wait over");
        }
      }
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, this, paramMessageRecord);
  }
  
  protected void b(String paramString, int paramInt) {}
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext);
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      long l = a(paramString, paramInt1);
      if (l != 0L)
      {
        Message localMessage;
        if (UinTypeUtil.a(paramInt1) == 1009)
        {
          localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.SAME_STATE_BOX_UIN, 1009);
          if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
          {
            paramString = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
            MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
            paramString.selfuin = paramMessageRecord.selfuin;
            paramString.senderuin = paramMessageRecord.frienduin;
            paramString.frienduin = AppConstants.SAME_STATE_BOX_UIN;
            if (paramInt2 == 3)
            {
              a(paramString, true, paramInt2);
              a(paramInt1).a(AppConstants.SAME_STATE_BOX_UIN, 1009, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
              a(paramInt1).b(AppConstants.SAME_STATE_BOX_UIN, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              return;
            }
            if (paramInt2 == 2)
            {
              a(paramString, true, paramInt2);
              a(paramInt1).a(AppConstants.SAME_STATE_BOX_UIN, 1009, l, paramMessageRecord.msg);
              return;
            }
            if (paramInt2 == 4)
            {
              a(paramInt1).a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramString.senderuin, paramString.selfuin, 0);
              a(paramString, null, false, true, paramInt2);
              a(paramString, true, paramInt2);
            }
          }
        }
        else
        {
          int i = UinTypeUtil.a(paramInt1);
          boolean bool2 = false;
          boolean bool1 = false;
          MessageRecord localMessageRecord;
          if ((i != 1001) && (UinTypeUtil.a(paramInt1) != 10002))
          {
            if (UinTypeUtil.a(paramInt1) == 1010)
            {
              bool2 = UinTypeUtil.a(paramMessageRecord);
              if (bool2) {
                bool1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isInMsgBox(paramString, 1010, AppConstants.DATE_UIN);
              }
              if ((bool2) && (!bool1))
              {
                localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
                if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
                {
                  paramString = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
                  MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                  paramString.frienduin = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                  paramString.senderuin = paramMessageRecord.frienduin;
                  paramString.istroop = localMessage.istroop;
                  localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
                  MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                  localMessageRecord.frienduin = AppConstants.DATE_UIN;
                  localMessageRecord.senderuin = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                  localMessageRecord.istroop = localMessage.istroop;
                  localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.DATE_UIN, 1010);
                  if (paramInt2 == 3)
                  {
                    a(paramString, true, paramInt2);
                    a(paramInt1).a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                    a(paramInt1).b(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                    if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN)))
                    {
                      a(localMessageRecord, true, paramInt2);
                      a(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
                      a(paramInt1).b(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                    }
                  }
                  else if (paramInt2 == 2)
                  {
                    a(paramString, true, paramInt2);
                    a(paramInt1).a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, l, paramMessageRecord.msg);
                    if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN)))
                    {
                      a(localMessageRecord, true, paramInt2);
                      a(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.msg);
                    }
                  }
                  else if (paramInt2 == 4)
                  {
                    a(paramInt1).a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, paramString.senderuin, paramString.selfuin, 0);
                    a(paramString, null, false, true, 1);
                    a(paramInt1).a(AppConstants.DATE_UIN, 1010, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
                    a(localMessageRecord, null, false, true, 1);
                    a(paramString, true, paramInt2);
                    if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN))) {
                      a(localMessageRecord, true, paramInt2);
                    }
                  }
                }
              }
              else
              {
                localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.DATE_UIN, 1010);
                if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
                {
                  paramString = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
                  MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                  paramString.selfuin = paramMessageRecord.selfuin;
                  paramString.senderuin = paramMessageRecord.frienduin;
                  paramString.frienduin = AppConstants.DATE_UIN;
                  if (paramInt2 == 3)
                  {
                    a(paramString, true, paramInt2);
                    a(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
                    a(paramInt1).b(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                    return;
                  }
                  if (paramInt2 == 2)
                  {
                    a(paramString, true, paramInt2);
                    a(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.msg);
                    return;
                  }
                  if (paramInt2 == 4)
                  {
                    a(paramInt1).a(AppConstants.DATE_UIN, 1010, paramString.senderuin, paramString.selfuin, 0);
                    a(paramString, null, false, true, paramInt2);
                    a(paramString, true, paramInt2);
                  }
                }
              }
            }
          }
          else
          {
            i = UinTypeUtil.a(paramInt1);
            boolean bool3 = UinTypeUtil.a(paramMessageRecord);
            bool1 = bool2;
            if (bool3) {
              bool1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isInMsgBox(paramString, i, AppConstants.LBS_HELLO_UIN);
            }
            if ((bool3) && (!bool1))
            {
              localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.LBS_SAY_HELLO_LIST_UIN, i);
              if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
              {
                paramString = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                paramString.frienduin = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                paramString.senderuin = paramMessageRecord.frienduin;
                paramString.istroop = localMessage.istroop;
                localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                localMessageRecord.frienduin = AppConstants.LBS_HELLO_UIN;
                localMessageRecord.senderuin = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                localMessageRecord.istroop = localMessage.istroop;
                localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
                if (paramInt2 == 3)
                {
                  a(paramString, true, paramInt2);
                  a(paramInt1).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                  a(paramInt1).b(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                  if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN)))
                  {
                    a(localMessageRecord, true, paramInt2);
                    a(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
                    a(paramInt1).b(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                    return;
                  }
                  return;
                }
                if (paramInt2 == 2)
                {
                  a(paramString, true, paramInt2);
                  a(paramInt1).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, l, paramMessageRecord.msg);
                  if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN)))
                  {
                    a(localMessageRecord, true, paramInt2);
                    a(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.msg);
                  }
                }
                else if (paramInt2 == 4)
                {
                  a(paramInt1).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, paramString.senderuin, paramString.selfuin, 0);
                  a(paramString, null, false, true, 1);
                  a(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
                  a(localMessageRecord, null, false, true, 1);
                  a(paramString, true, paramInt2);
                  if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN))) {
                    a(localMessageRecord, true, paramInt2);
                  }
                }
              }
            }
            else
            {
              localMessage = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
              if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
              {
                paramString = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                paramString.selfuin = paramMessageRecord.selfuin;
                paramString.senderuin = paramMessageRecord.frienduin;
                paramString.frienduin = AppConstants.LBS_HELLO_UIN;
                if (paramInt2 == 3)
                {
                  a(paramString, true, paramInt2);
                  a(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
                  a(paramInt1).b(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                  return;
                }
                if (paramInt2 == 2)
                {
                  a(paramString, true, paramInt2);
                  a(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.msg);
                  return;
                }
                if (paramInt2 == 4)
                {
                  a(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, paramString.senderuin, paramString.selfuin, 0);
                  a(paramString, null, false, true, paramInt2);
                  a(paramString, true, paramInt2);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBoxReaded boxUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",boxType=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",needDelMark=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : boxUin=null");
      }
      return;
    }
    if (!UinTypeUtil.a(paramString, paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : is not msgbox");
      }
      return;
    }
    Object localObject = null;
    if (paramString.equals(AppConstants.LBS_HELLO_UIN)) {
      localObject = AppConstants.LBS_SAY_HELLO_LIST_UIN;
    } else if (paramString.equals(AppConstants.DATE_UIN)) {
      localObject = AppConstants.DATE_SAY_HELLO_LIST_UIN;
    }
    long l = 0L;
    IConversationFacade localIConversationFacade;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getUnreadCount((String)localObject, paramInt) > 0)
      {
        paramString = a(paramInt).a((String)localObject, paramInt);
        localIConversationFacade = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade;
        if (paramString != null) {
          l = a(paramString);
        }
        localIConversationFacade.cleanUnread((String)localObject, paramInt, l, paramBoolean1, paramBoolean2);
        b((String)localObject, paramInt);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
      }
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getUnreadCount(paramString, paramInt) > 0)
    {
      localObject = a(paramInt).a(paramString, paramInt);
      localIConversationFacade = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade;
      if (localObject != null) {
        l = a((MessageRecord)localObject);
      }
      localIConversationFacade.cleanUnread(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      b(paramString, paramInt);
      i = 1;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : box unread = 0");
      }
      i = 0;
    }
    if (paramString.equals(AppConstants.CONFESS_UIN))
    {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, true, true);
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, true, false);
    }
    if (i != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      ((IMessageFacade)localObject).setChangeAndNotify(((IMessageFacade)localObject).getLastMessage(paramString, paramInt));
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this, paramMessageRecord);
  }
  
  protected boolean b(String paramString)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString);
  }
  
  public void c(Message paramMessage) {}
  
  public void c(MessageRecord paramMessageRecord)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMsgForMsgTabWithAutoInit(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject1 != null)
    {
      a((MessageRecord)localObject1, true, 4);
      b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, (MessageRecord)localObject1, 4);
      return;
    }
    Object localObject2 = null;
    Object localObject3 = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    int i = UinTypeUtil.a(paramMessageRecord.istroop);
    if ((i != 1001) && (i != 10002))
    {
      if (UinTypeUtil.a(paramMessageRecord.istroop) == 1009)
      {
        a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramMessageRecord.frienduin, (String)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.SAME_STATE_BOX_UIN, 1009);
      }
      else
      {
        localObject1 = localObject2;
        if (UinTypeUtil.a(paramMessageRecord.istroop) == 1010) {
          if (UinTypeUtil.a(paramMessageRecord))
          {
            a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, paramMessageRecord.frienduin, (String)localObject3);
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (((Message)localObject3).senderuin != null)
              {
                localObject1 = localObject2;
                if (((Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
                {
                  ((Message)localObject3).cleanMessageRecordBaseField();
                  localObject1 = localObject2;
                }
              }
            }
          }
          else
          {
            a(AppConstants.DATE_UIN, 1010, paramMessageRecord.frienduin, (String)localObject3);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.DATE_UIN, 1010);
          }
        }
      }
    }
    else if (UinTypeUtil.a(paramMessageRecord))
    {
      a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, paramMessageRecord.frienduin, (String)localObject3);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.LBS_SAY_HELLO_LIST_UIN, i);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Message)localObject3).senderuin != null)
        {
          localObject1 = localObject2;
          if (((Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
          {
            ((Message)localObject3).cleanMessageRecordBaseField();
            localObject1 = localObject2;
          }
        }
      }
    }
    else
    {
      a(AppConstants.LBS_HELLO_UIN, i, paramMessageRecord.frienduin, (String)localObject3);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
    }
    if ((localObject1 != null) && (((Message)localObject1).senderuin != null) && (((Message)localObject1).senderuin.equals(paramMessageRecord.frienduin))) {
      ((Message)localObject1).cleanMessageRecordBaseField();
    }
  }
  
  public void d(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int j = paramMessageRecord.istroop;
    paramMessageRecord = UinTypeUtil.a((String)localObject, j);
    if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().containsKey(paramMessageRecord))
    {
      int i;
      if (j == 1026) {
        i = 1;
      } else {
        i = j;
      }
      RecentUser localRecentUser = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().b((String)localObject, i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMsgForMsgTabWithAutoInit((String)localObject, j);
      if (localObject != null)
      {
        a((MessageRecord)localObject, true, 4);
        if (localRecentUser != null)
        {
          if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
            localRecentUser.troopUin = ((MessageRecord)localObject).senderuin;
          }
          localRecentUser.setType(i);
          localRecentUser.lastmsgtime = ((MessageRecord)localObject).time;
          jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, localRecentUser);
          ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().b(localRecentUser);
        }
      }
      else if (localRecentUser != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.removeRecentUser(localRecentUser);
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().remove(paramMessageRecord);
      }
      if (localRecentUser != null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(localRecentUser);
      }
    }
  }
  
  public void e(MessageRecord paramMessageRecord) {}
  
  public void f(MessageRecord paramMessageRecord)
  {
    ThreadManager.executeOnNetWorkThread(new BaseMessageManager.1(this, paramMessageRecord, System.currentTimeMillis()));
  }
  
  public void g(MessageRecord paramMessageRecord)
  {
    Object localObject = HardCodeUtil.a(2131701234);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5040, 1, paramMessageRecord.time);
    ((UniteGrayTipParam)localObject).jdField_f_of_type_Boolean = false;
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_MqqAppAppRuntime, (UniteGrayTipParam)localObject);
    localMessageForUniteGrayTip.msgUid = paramMessageRecord.msgUid;
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.removeMsgByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, false);
    localObject = a(paramMessageRecord.istroop).d(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, localMessageForUniteGrayTip);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "doRevokeFakeMsgToGrayTips error: AIO is empty");
    }
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord.frienduin, paramMessageRecord.istroop, BaseMessageProcessor.jdField_a_of_type_Int, BaseMessageProcessor.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager
 * JD-Core Version:    0.7.0.1
 */