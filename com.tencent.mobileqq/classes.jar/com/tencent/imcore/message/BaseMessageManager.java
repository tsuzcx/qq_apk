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
  public static BaseMessageManager.Callback e;
  public AppRuntime a;
  public IMessageFacade b;
  protected IConversationFacade c;
  protected MsgPool d;
  private Object f = new Object();
  private Object g = new Object();
  
  static {}
  
  public BaseMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    this.a = paramAppRuntime;
    this.b = ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, ""));
    this.c = ((IConversationFacade)paramAppRuntime.getRuntimeService(IConversationFacade.class, ""));
    this.d = paramMsgPool;
  }
  
  @Nullable
  private Message a(String paramString, Message paramMessage, StringBuilder paramStringBuilder)
  {
    try
    {
      Message localMessage = (Message)this.b.getCachedMsg().get(paramString);
      if (localMessage == null)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramMessage);
        this.b.getCachedMsg().put(paramString, paramMessage);
        return paramMessage;
      }
      if (a(localMessage) < a(paramMessage))
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramMessage);
        this.b.getCachedMsg().put(paramString, paramMessage);
        return paramMessage;
      }
      if ((!localMessage.isCacheValid) && (paramMessage.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramMessage);
        this.b.getCachedMsg().put(paramString, paramMessage);
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
    String str2 = this.a.getApp().getString(2131895483);
    int i = paramString1.length() + str2.length();
    int j = str1.length() + i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    localStringBuilder.append(this.a.getApp().getString(2131895484));
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
    return e.a(this.a, paramInt, paramString1, paramString2, paramMessageForUniteGrayTip, paramString3);
  }
  
  public static void a(BaseMessageManager.Callback paramCallback)
  {
    e = paramCallback;
  }
  
  private void a(String paramString, Message paramMessage)
  {
    if (((paramString.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN)))) && (paramMessage.msgData != null)) {
      e.a(null, paramMessage);
    }
  }
  
  private void b(MessageRecord paramMessageRecord, Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
      this.b.setIncomingMsg(paramMessage);
    }
    if ((!String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(paramMessage.frienduin)) && ((!UinTypeUtil.c(paramMessage)) || (MsgProxyUtils.a(this.a, paramMessageRecord))))
    {
      e.a(paramMessageRecord, paramMessage);
      this.b.setIncomingMsg(paramMessage);
    }
    if (((paramMessage.msgtype == -2009) || (paramMessage.msgtype == -2016)) && (paramBoolean))
    {
      Message localMessage = new Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      localMessage.emoRecentMsg = null;
      localMessage.fileType = -1;
      paramMessage.lastMsg = null;
      this.b.setIncomingMsg(localMessage);
    }
    if (AppConstants.TROOP_SYSTEM_MSG_UIN.equals(paramMessage.frienduin))
    {
      int i = GroupSystemMsgController.a().b(this.a);
      if (i > 0)
      {
        this.b.getIncomingMsg().unReadNum = i;
        return;
      }
      this.b.setIncomingMsg(null);
    }
  }
  
  private void d(Message paramMessage)
  {
    if (((!AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin)) && ((UinTypeUtil.e(paramMessage.istroop) == 1001) || (UinTypeUtil.e(paramMessage.istroop) == 10002))) || (UinTypeUtil.e(paramMessage.istroop) == 10010) || ((!AppConstants.DATE_UIN.equals(paramMessage.frienduin)) && (UinTypeUtil.e(paramMessage.istroop) == 1010)))
    {
      Object localObject = a(paramMessage.istroop).c(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) && (!MessageUtils.b(localMessageRecord.msgtype)))
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
  
  private long e(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject1 = null;
    int i = UinTypeUtil.e(paramInt);
    Object localObject2 = "";
    if (i == 1009)
    {
      localObject1 = a(paramInt).b(AppConstants.SAME_STATE_BOX_UIN, 1009);
    }
    else if (UinTypeUtil.e(paramInt) == 1001)
    {
      localObject1 = a(paramInt).b(AppConstants.LBS_HELLO_UIN, 1001);
      localObject2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
    }
    else if (UinTypeUtil.e(paramInt) == 1010)
    {
      localObject1 = a(paramInt).b(AppConstants.DATE_UIN, 1010);
      localObject2 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
    }
    else if (UinTypeUtil.e(paramInt) == 10002)
    {
      localObject1 = a(paramInt).b(AppConstants.LBS_HELLO_UIN, 10002);
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
      localObject1 = a(paramInt).b((String)localObject2, UinTypeUtil.e(paramInt));
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
  
  private boolean e(Message paramMessage)
  {
    Iterator localIterator = this.b.getRegistry().f().iterator();
    while (localIterator.hasNext()) {
      if (((ExtractMessageSummaryCallback)localIterator.next()).a(paramMessage)) {
        return true;
      }
    }
    return false;
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0) {
      if (paramInt == 2)
      {
        if ((!e.b(this.a, paramConversationInfo.uin, paramConversationInfo.type)) && (this.c.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 6)
      {
        if (((paramConversationInfo.type == 1001) || (paramConversationInfo.type == 10002)) && (AppConstants.LBS_HELLO_UIN.equals(paramConversationInfo.uin)) && (this.c.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.SAME_STATE_BOX_UIN)) && (this.c.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(AppConstants.DATE_UIN)) && (this.c.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 9)
      {
        if ((paramConversationInfo.type == 1008) && (this.c.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 10)
      {
        if (((paramConversationInfo.type == 0) || (paramConversationInfo.type == 1) || (paramConversationInfo.type == 3000)) && (!e.b(this.a, paramConversationInfo.uin, paramConversationInfo.type)) && (this.c.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type))) {
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
    this.c.removeUnreadItem(paramString, paramInt);
    Object localObject = this.b.getLastMessage(paramString, paramInt);
    int i = a(paramInt).b(paramString, paramInt, paramBoolean1);
    if (paramInt == 0) {
      e.b(this.a, paramString);
    }
    if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
      this.b.clearTransFileInfo(paramString);
    }
    if (i > 0) {
      ((Message)localObject).cleanMessageRecordBaseField();
    }
    if ((paramInt != 3000) && (paramInt != 1) && (this.c.isInMsgBox(paramString, UinTypeUtil.e(paramInt)))) {
      if (UinTypeUtil.e(paramInt) == 1009) {
        a(paramString, AppConstants.SAME_STATE_BOX_UIN, 1009);
      } else if (UinTypeUtil.e(paramInt) == 1001) {
        a(paramString, AppConstants.LBS_HELLO_UIN, 1001);
      } else if (UinTypeUtil.e(paramInt) == 1010) {
        a(paramString, AppConstants.DATE_UIN, 1010);
      } else if (UinTypeUtil.e(paramInt) == 10002) {
        a(paramString, AppConstants.LBS_HELLO_UIN, 10002);
      } else if (UinTypeUtil.e(paramInt) == 1044) {
        a(paramString, AppConstants.MATCH_CHAT_UIN, 1044);
      } else if (UinTypeUtil.e(paramInt) == 10008) {
        a(paramString, AppConstants.QCIRCLE_CHAT_UIN, 10008);
      }
    }
    if (paramBoolean2)
    {
      RecentUser localRecentUser = ((IRecentUserProxyService)this.a.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().b(paramString, ((Message)localObject).istroop);
      if (localRecentUser != null) {
        this.b.removeRecentUser(localRecentUser);
      }
    }
    this.b.getCachedMsg().remove(UinTypeUtil.a(paramString, paramInt));
    this.b.setChangeAndNotify(localObject);
    return i;
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public BaseMsgProxy a(int paramInt)
  {
    return e.a(paramInt, this.a);
  }
  
  public Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    if (paramString == null) {
      return new Message();
    }
    e.a(this.a, paramString, paramInt);
    String str = UinTypeUtil.a(paramString, paramInt);
    Object localObject1 = null;
    Object localObject2 = (Message)this.b.getCachedMsg().get(str);
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
      localObject2 = e.a((String)localObject1, paramString);
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
          a(((Message)localObject1).istroop).c(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
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
      if ((localObject2 != null) && (((Message)localObject2).isSendFromLocal()) && (((Message)localObject2).extraflag == 32772) && (!((MessageCache)this.a.getMsgCache()).f((MessageRecord)localObject2)))
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
    if ((paramString != null) && (UinTypeUtil.c(paramString.frienduin, paramString.istroop))) {
      paramString.istroop = UinTypeUtil.e(paramString.istroop);
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
    return e.a(this.a, paramInt, paramString1, paramString2, paramMessageForUniteGrayTip);
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
    e.a(this, this.a, paramInt1, paramString, (List)localObject2, null, false, true);
    e.a(paramInt1, (List)localObject2, this.a);
    MsgProxyUtils.a(paramString, paramInt1, (List)localObject2, (MessageCache)this.a.getMsgCache());
    e.a(this.b, paramString, paramInt1, (List)localObject2, this);
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
      Iterator localIterator2 = this.b.getRegistry().r().iterator();
      while (localIterator2.hasNext())
      {
        Object[] arrayOfObject = ((IAioMsgHandler)localIterator2.next()).a(this.a, paramString, paramInt1, paramBoolean, localArrayList1, localArrayList2, (List)localObject1, (MessageRecord)localObject2);
        localObject2 = (MessageRecord)arrayOfObject[0];
        if (((Boolean)arrayOfObject[1]).booleanValue()) {
          break;
        }
      }
    }
    if (!paramBoolean) {
      e.a(this.a, localArrayList2, (List)localObject1);
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
        if ((i != 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.b))
        {
          if (((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!MsgProxyUtils.a(localMessageRecord))) {
            paramString.add(localMessageRecord);
          }
        }
        else if ((i == 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.b) && (localMessageRecord.msgUid == localRevokeMsgInfo.f) && (TextUtils.equals(localMessageRecord.senderuin, localRevokeMsgInfo.d))) {
          paramString.add(localMessageRecord);
        }
      }
    }
    return paramString;
  }
  
  protected List<MessageRecord> a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    return (List)this.d.c().get(UinTypeUtil.a(paramString, paramInt));
  }
  
  public void a()
  {
    try
    {
      synchronized (this.g)
      {
        this.g.wait(15000L);
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
    paramString = this.d.a(paramString, paramInt);
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
    if (e(paramMessage)) {
      return;
    }
    Iterator localIterator = this.b.getRegistry().n().iterator();
    while (localIterator.hasNext()) {
      ((IMessageDecoder)localIterator.next()).a(paramMessage, this, this.a);
    }
  }
  
  protected void a(RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.f)
    {
      if (paramRefreshMessageContext.s)
      {
        paramRefreshMessageContext.s = false;
        this.f.notify();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
        }
      }
      return;
    }
  }
  
  protected void a(RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    if ((paramRefreshMessageContext.b != null) && (paramRefreshMessageContext.b.size() > 0)) {
      synchronized (paramRefreshMessageContext.b)
      {
        e.a(paramInt, paramRefreshMessageContext.b, this.a);
        if (paramRefreshMessageContext.b.size() > 0) {
          MsgProxyUtils.a(paramRefreshMessageContext.p, paramRefreshMessageContext.q, paramRefreshMessageContext.b, (MessageCache)this.a.getMsgCache());
        }
        i = 1;
      }
    }
    int i = 0;
    ??? = paramRefreshMessageContext.p;
    int j = paramRefreshMessageContext.r;
    if ((paramRefreshMessageContext.f) && (i != 0) && (paramRefreshMessageContext.b.isEmpty()) && (paramRefreshMessageContext.l < 9))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:");
        localStringBuilder.append(paramRefreshMessageContext.l);
        localStringBuilder.append(" ]");
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramRefreshMessageContext.l += 1;
      b((String)???, paramInt, j, paramRefreshMessageContext);
      return;
    }
    paramRefreshMessageContext.l = 0;
    paramRefreshMessageContext.m = 0;
    if (paramRefreshMessageContext.h) {
      this.b.setChangeAndNotify(paramRefreshMessageContext);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramInt == 1) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (!String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(paramMessageRecord.frienduin))) {
      this.b.setIncomingMsg(null);
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
      paramMessageRecord.time = MessageCache.c();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    paramAddMessageContext = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0) || (paramMessageRecord.istroop == 10014)) && (paramMessageRecord.extraflag == 0))
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
    Object localObject = this.b.getRegistry().p().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IAddMessageHandler)((Iterator)localObject).next()).a(this.a, this, paramMessageRecord, paramBoolean1, paramBoolean2, paramBoolean4, paramEntityManager, paramAddMessageContext, i);
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, boolean paramBoolean, Message paramMessage)
  {
    MessageRecord.copyMessageRecordBaseField(paramMessage, paramMessageRecord);
    paramMessage.emoRecentMsg = null;
    paramMessage.fileType = -1;
    paramMessage.lastMsg = null;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (e.a(this.a, paramMessage)) {
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
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = e.a(paramMessageRecord, localArrayList);
    int i = 0;
    if (bool)
    {
      bool = UinTypeUtil.a(paramMessageRecord, this.b.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop));
    }
    else
    {
      localArrayList.add(paramMessageRecord);
      if (this.b.isTheLastTabMsg(paramMessageRecord)) {
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
    if (this.b.getCachedMsg().containsKey(localObject))
    {
      localObject = (Message)this.b.getCachedMsg().get(localObject);
      if ((!paramMessageRecord.isread) && (localObject != null)) {
        this.c.decreaseUnread(((Message)localObject).frienduin, ((Message)localObject).istroop, (MessageRecord)localObject);
      }
    }
    this.b.stopHttpProcessorIfNeed(paramMessageRecord);
    int j = localArrayList.size();
    while (i < j)
    {
      localObject = (MessageRecord)localArrayList.get(i);
      a(((MessageRecord)localObject).istroop).a((MessageRecord)localObject, paramBoolean2);
      ((MessageCache)this.a.getMsgCache()).d((MessageRecord)localObject);
      i += 1;
    }
    if (paramBoolean1) {
      e.a(this.a, null, paramMessageRecord);
    }
    if (bool) {
      c(paramMessageRecord);
    }
    if (paramBoolean2) {
      a(paramMessageRecord.istroop).h();
    }
  }
  
  public void a(MessageForUniteGrayTip paramMessageForUniteGrayTip, Bundle paramBundle)
  {
    e.a(paramMessageForUniteGrayTip, paramBundle);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.f = true;
    paramRefreshMessageContext.p = paramString;
    paramRefreshMessageContext.q = paramInt1;
    paramRefreshMessageContext.r = paramInt2;
    String str;
    if (UinTypeUtil.e(paramInt1) != 1032) {
      str = UinTypeUtil.a(paramString, paramInt1);
    } else {
      str = UinTypeUtil.a(paramString, paramInt1, paramRefreshMessageContext.w);
    }
    if (this.b.getRefreshActionMap().containsKey(str))
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
      if ((paramRefreshMessageContext.s) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("numTroopRefresh = ");
        localStringBuilder.append(paramRefreshMessageContext.s);
        localStringBuilder.append(", refreshActionMap[");
        localStringBuilder.append(UinTypeUtil.a(paramString, paramInt1));
        localStringBuilder.append("] = ");
        localStringBuilder.append(this.b.getRefreshActionMap().get(str));
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      this.b.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
    this.b.getRefreshActionMap().put(str, Boolean.valueOf(true));
    ThreadManager.executeOnNetWorkThread(new BaseMessageManager.RefreshRunnable(paramString, paramInt1, paramInt2, paramRefreshMessageContext, str, this));
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = a(paramInt1).c(paramString, paramInt1);
    Message localMessage = this.b.getLastMessage(paramString, paramInt1);
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
    e.a(this.a, this, this.b, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    e.a(this.a, this.b, this.c, paramString1, paramInt, paramString2, paramString3, paramLong);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramInt, paramString2, paramString3, paramInt, 0, paramBoolean);
  }
  
  public abstract void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle);
  
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
    boolean bool1 = c(paramString, paramInt1);
    boolean bool2 = true;
    IConversationFacade localIConversationFacade;
    long l;
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      if (this.c.getUnreadCount(paramString, paramInt1) > 0)
      {
        localObject = a(paramInt1).e(paramString, paramInt1);
        localIConversationFacade = this.c;
        if (localObject != null) {
          l = a((MessageRecord)localObject);
        } else {
          l = 0L;
        }
        localIConversationFacade.cleanUnread(paramString, paramInt1, l, paramBoolean1, paramBoolean2);
        d(paramString, paramInt1);
        paramBoolean1 = bool2;
        break label319;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
      }
    }
    else
    {
      if (this.c.getUnreadCountConfess(paramString, paramInt1, paramInt2) > 0)
      {
        localObject = a(paramInt1).b(paramString, paramInt1, paramInt2);
        localIConversationFacade = this.c;
        if (localObject != null) {
          l = a((MessageRecord)localObject);
        } else {
          l = 0L;
        }
        localIConversationFacade.cleanUnread(paramString, paramInt1, l, paramBoolean1, paramBoolean2, paramInt2);
        d(paramString, paramInt1);
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
      localObject = this.b;
      ((IMessageFacade)localObject).setChangeAndNotify(((IMessageFacade)localObject).getLastMessage(paramString, paramInt1, paramInt2));
      b(paramString, paramInt1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString2, paramInt, paramString1, this.a.getAccount());
    paramString2 = this.b.getLastMessage(paramString2, paramInt);
    if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1))) {
      paramString2.cleanMessageRecordBaseField();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.b.getAIOList(paramString1, paramInt);
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
        if ((TextUtils.equals(localMessageRecord.frienduin, paramString1)) && (TextUtils.equals(localMessageRecord.getExtInfoFromExtStr("uint64_tips_seq_id"), paramString3)) && (TextUtils.equals(localMessageRecord.getExtInfoFromExtStr("uint64_busi_id"), paramString2)) && (e.a(localMessageRecord))) {
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
      this.b.removeMsgByUniseq(paramString2.frienduin, paramString2.istroop, paramString2.uniseq, true);
      paramString3 = this.a.getApp();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.a.getAccount());
      ((StringBuilder)localObject1).append("_pai_yi_pai_revoke");
      paramString3 = paramString3.getSharedPreferences(((StringBuilder)localObject1).toString(), 0);
      if ((paramString3.getBoolean("first_time_revoke_pai_yi_pai", true)) && (bool) && (paramBoolean))
      {
        paramString3.edit().putBoolean("first_time_revoke_pai_yi_pai", false).apply();
        paramString3 = a(paramInt).i(paramString1, paramInt);
        if (paramString3 != null)
        {
          if (paramString3.isEmpty()) {
            return;
          }
          paramString2 = UniteGrayTipMsgUtil.a(this.a, paramString2);
          a(paramInt, paramString1, paramString2, paramString3);
          UniteGrayTipMsgUtil.a(this.a, paramString2);
        }
        else
        {
          return;
        }
      }
      e.d(this.a);
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    Object localObject5 = (RevokeMsgInfo)paramArrayList.get(0);
    int i = ((RevokeMsgInfo)localObject5).a;
    String str1 = ((RevokeMsgInfo)localObject5).c;
    Object localObject4 = ((RevokeMsgInfo)localObject5).d;
    int j = ((RevokeMsgInfo)localObject5).m;
    int k = ((RevokeMsgInfo)localObject5).p;
    String str2 = ((RevokeMsgInfo)localObject5).q;
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
      ((StringBuilder)localObject2).append(((RevokeMsgInfo)localObject5).h);
      QLog.w("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = a(i).g(str1, i);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      List localList = a((List)localObject2, str1, i, paramArrayList);
      if ((localList != null) && (!localList.isEmpty()))
      {
        if ((localList != null) && (localList.size() == 1) && (UniteGrayTipMsgUtil.b((MessageRecord)localList.get(0))))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify same gray msg");
          }
          paramArrayList = (MessageRecord)localList.get(0);
          if ((paramArrayList instanceof MessageForUniteGrayTip)) {
            UniteGrayTipMsgUtil.a(this.a, (MessageForUniteGrayTip)paramArrayList, i);
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
          if ((((MessageRecord)localObject3).shmsgseq == ((RevokeMsgInfo)localObject5).b) && (((MessageRecord)localObject3).msgUid == ((RevokeMsgInfo)localObject5).f))
          {
            localObject1 = localObject3;
            break label405;
          }
        }
        localObject1 = localObject2;
        label405:
        ArrayList<RevokeMsgInfo> localArrayList = paramArrayList;
        localObject2 = new MessageForUniteGrayTip();
        this.a.getApp().getString(2131895486);
        String str3 = this.a.getApp().getString(2131895485);
        this.a.getApp().getString(2131895482);
        k = ((RevokeMsgInfo)localObject5).n;
        long l;
        if ((j != 1) && (j != 2))
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append(HardCodeUtil.a(2131899249));
          paramArrayList.append(BaseApplication.getContext().getString(2131891963));
          localObject3 = paramArrayList.toString();
          localObject5 = ((MessageRecord)localObject1).senderuin;
          if (k == 1)
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append(HardCodeUtil.a(2131899249));
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
                paramArrayList = this.a.getAccount();
              }
              localObject4 = e.c(this.a, paramArrayList);
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
                localObject3 = paramArrayList.concat(BaseApplication.getContext().getString(2131891963));
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
          localObject3 = HardCodeUtil.a(2131899254);
          paramArrayList = this.a.getAccount();
          if (((MessageRecord)localList.get(0)).msgtype != -2006) {
            l = ((MessageRecord)localList.get(0)).time;
          } else {
            l = ((RevokeMsgInfo)localObject5).g;
          }
          if ((((RevokeMsgInfo)localObject5).h != null) && (!a(((RevokeMsgInfo)localObject5).h)))
          {
            localObject3 = a(i, (String)localObject3, ((RevokeMsgInfo)localObject5).h, str1, paramArrayList, (MessageForUniteGrayTip)localObject2, l);
            localObject4 = ((UniteGrayTipParam)localObject3).g;
          }
          else
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append(HardCodeUtil.a(2131899251));
            paramArrayList.append(BaseApplication.getContext().getString(2131895486));
            localObject4 = paramArrayList.toString();
            if (k == 1) {
              localObject4 = ((String)localObject3).concat(str3);
            }
            paramArrayList = this.a.getAccount();
            l = ((MessageRecord)localObject1).time;
            localObject3 = new UniteGrayTipParam(str1, paramArrayList, (String)localObject4, i, -5040, 1, l);
          }
          localObject5 = localObject4;
          localObject4 = paramArrayList;
          paramArrayList = (ArrayList<RevokeMsgInfo>)localObject5;
        }
        localObject5 = str1;
        ((UniteGrayTipParam)localObject3).m = true;
        ((UniteGrayTipParam)localObject3).q = false;
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.a, (UniteGrayTipParam)localObject3);
        ((MessageForUniteGrayTip)localObject2).msgUid = ((MessageRecord)localObject1).msgUid;
        ((MessageForUniteGrayTip)localObject2).shmsgseq = ((MessageRecord)localObject1).shmsgseq;
        ((MessageForUniteGrayTip)localObject2).saveExtInfoToExtStr("revoke_op_type", String.valueOf(j));
        if (k == 1) {
          e.a((MessageForUniteGrayTip)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(localArrayList, 2, new Object[] { "revoke msg doReplaceRevokedMsgAndNotify senderUin=", localObject4, ",frienduin=", localObject5 });
        }
        UniteGrayTipMsgUtil.a(this.a, (MessageForUniteGrayTip)localObject2, localList, i, paramArrayList, (UniteGrayTipParam)localObject3);
        e.a(this.a, this.b, true, 0, true, localList, (MessageRecord)localObject1);
        a(i, (String)localObject5, (MessageRecord)localObject2, a(i).i((String)localObject5, i));
        UniteGrayTipMsgUtil.a(this.a, (MessageForUniteGrayTip)localObject2);
        e.a(this.a, null, true);
        e.b(this.a, localList, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
      }
      e.a(this.a, str1, i, BaseMessageProcessor.a, BaseMessageProcessor.h);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: AIO is empty");
    }
    e.a(this.a, str1, i, BaseMessageProcessor.a, BaseMessageProcessor.g);
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.get(0);
    boolean bool1;
    if (localRevokeMsgInfo.j > 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int n = localRevokeMsgInfo.a;
    String str1 = localRevokeMsgInfo.d;
    Object localObject3 = localRevokeMsgInfo.c;
    Object localObject1 = localRevokeMsgInfo.h;
    Object localObject5 = localRevokeMsgInfo.l;
    int j = localRevokeMsgInfo.m;
    int i = localRevokeMsgInfo.n;
    boolean bool2 = localRevokeMsgInfo.o;
    int k = localRevokeMsgInfo.p;
    Object localObject4 = localRevokeMsgInfo.q;
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
    String str2 = this.a.getAccount();
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
      localObject6 = this.b.queryMsgItemByShmsgseq((String)localObject2, n, ((RevokeMsgInfo)localObject6).b, ((RevokeMsgInfo)localObject6).f);
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
        Collections.sort((List)localObject3, MsgProxyUtils.n);
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
      if (UniteGrayTipMsgUtil.b((MessageRecord)((List)localObject3).get(0))) {
        return;
      }
      if (((MessageRecord)((List)localObject3).get(0)).msgtype == -2006)
      {
        if (e.a((MessageRecord)((List)localObject3).get(0), null))
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
        ((MessageCache)this.a.getMsgCache()).a(paramArrayList);
        return;
      }
      k = 0;
    }
    else
    {
      k = 1;
    }
    if ((localRevokeMsgInfo.n == 1) && (!paramBoolean))
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
      l = localRevokeMsgInfo.g;
    }
    if (paramBoolean)
    {
      if ((m == 0) && (localRevokeMsgInfo.n == 0) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
        paramArrayList = e.c(this.a, str1);
      } else {
        paramArrayList = HardCodeUtil.a(2131899253);
      }
    }
    else {
      paramArrayList = a(n, (String)localObject2, (String)localObject1, localMessageForUniteGrayTip);
    }
    Object localObject6 = localObject1;
    localObject1 = localObject2;
    this.a.getApp().getString(2131895486);
    Object localObject7 = this.a.getApp().getString(2131895485);
    localObject2 = this.a.getApp().getString(2131895482);
    if ((m != 1) && (m != 2))
    {
      if (localRevokeMsgInfo.n == 1)
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
        localObject2 = ((String)localObject2).concat(BaseApplication.getContext().getString(2131891963));
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
      if (TextUtils.equals(str1, this.a.getAccount()))
      {
        if ((localObject5 != null) && (!a((String)localObject5)))
        {
          paramArrayList = a(n, paramArrayList, (String)localObject5, (String)localObject4, (String)localObject6, localMessageForUniteGrayTip, l);
          localObject2 = paramArrayList.g;
        }
        else
        {
          localObject2 = paramArrayList.concat(this.a.getApp().getString(2131895486));
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
          localObject2 = this.a.getApp();
          j = 2131895514;
        }
        else
        {
          localObject2 = this.a.getApp();
          j = 2131895513;
        }
        localObject2 = ((BaseApplication)localObject2).getString(j);
        j = ((String)localObject2).length();
        i1 = ((String)localObject2).length();
        int i2 = paramArrayList.length();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(paramArrayList);
        ((StringBuilder)localObject5).append(this.a.getApp().getString(2131895486));
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
    paramArrayList.m = true;
    paramArrayList.q = false;
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.a, paramArrayList);
    if (k != 0) {
      l = ((MessageRecord)((List)localObject3).get(0)).msgUid;
    } else {
      l = localRevokeMsgInfo.f;
    }
    ((MessageForUniteGrayTip)localObject1).msgUid = l;
    ((MessageForUniteGrayTip)localObject1).shmsgseq = localRevokeMsgInfo.b;
    ((MessageForUniteGrayTip)localObject1).saveExtInfoToExtStr("revoke_op_type", String.valueOf(m));
    if (i == 1) {
      e.a((MessageForUniteGrayTip)localObject1);
    }
    if (paramBoolean) {
      UniteGrayTipMsgUtil.a((List)localObject3);
    }
    if (k != 0) {
      e.a(this.a, this.b, bool1, n, bool2, (List)localObject3, null);
    }
    paramArrayList = a(n).i((String)localObject2, n);
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
      UniteGrayTipMsgUtil.a(this.a, (MessageForUniteGrayTip)localObject1);
    } else if (((List)localObject3).size() > 0) {
      this.b.setChangeAndNotify(((List)localObject3).get(0));
    }
    if (k != 0)
    {
      paramArrayList = ((List)localObject3).iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (MessageRecord)paramArrayList.next();
        this.b.cancelNotificationWhenRevokeMessage((MessageRecord)localObject1);
      }
    }
    this.b.cancelNotificationWhenRevokeMessage((MessageRecord)localObject1);
    if ((k != 0) && (!((MessageRecord)((List)localObject3).get(0)).isread)) {
      e.c(this.a);
    }
    e.a(this.a, (List)localObject3, paramBoolean);
  }
  
  public void a(List<MessageRecord> paramList)
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
        e.a(localMessageRecord, null);
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (UniteGrayTipMsgUtil.b(localMessageRecord)) {
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
      if (!e.a((MessageRecord)localObject3, localArrayList)) {
        localArrayList.add(localObject3);
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("-->removeMsgByMessageRecord :");
        ((StringBuilder)localObject4).append(localObject3);
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject4).toString());
      }
      this.b.stopHttpProcessorIfNeed((MessageRecord)localObject3);
    }
    localObject2 = UinTypeUtil.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
    if (this.b.getCachedMsg().containsKey(localObject2))
    {
      localObject2 = (Message)this.b.getCachedMsg().get(localObject2);
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
          this.c.decreaseUnreads(((Message)localObject2).frienduin, ((Message)localObject2).istroop, (List)localObject3);
        }
      }
    }
    a(((MessageRecord)localObject1).istroop).a(localArrayList, paramBoolean2);
    paramList = localArrayList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (MessageRecord)paramList.next();
      ((MessageCache)this.a.getMsgCache()).d((MessageRecord)localObject2);
    }
    if (paramBoolean1) {
      e.a(this.a, localArrayList, null);
    }
    if (e.a((MessageRecord)localObject1, null))
    {
      paramBoolean1 = UinTypeUtil.a((MessageRecord)localObject1, this.b.getLastMessage(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop));
    }
    else
    {
      paramBoolean1 = bool;
      if (this.b.isTheLastTabMsg((MessageRecord)localObject1)) {
        paramBoolean1 = true;
      }
    }
    if (paramBoolean1) {
      c((MessageRecord)localObject1);
    }
    if (paramBoolean2) {
      a(((MessageRecord)localObject1).istroop).h();
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
    if (UinTypeUtil.c(paramMessage.frienduin, paramMessage.istroop)) {
      paramMessage.istroop = UinTypeUtil.e(paramMessage.istroop);
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord, Message paramMessage)
  {
    int i = paramMessageRecord.istroop;
    boolean bool1 = true;
    if ((i != 3000) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 10014))
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
  
  protected boolean a(MessageRecord paramMessageRecord, Message paramMessage, boolean paramBoolean)
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
      if (((MessageCache)this.a.getMsgCache()).b(paramMessageRecord))
      {
        a(paramMessageRecord, paramInt);
        return false;
      }
      localObject = this.b.findLongMsgHead(paramMessageRecord);
    }
    if (((MessageRecord)localObject).istroop == 1036) {
      return false;
    }
    if (e.a(this.a, (MessageRecord)localObject)) {
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
          paramMessageRecord = this.b.getLastMessage(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateMsgTab getLastMessage ");
            localStringBuilder.append(paramMessageRecord.getBaseInfoString());
            QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
          }
          if (d((MessageRecord)localObject)) {
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
              b((MessageRecord)localObject, paramMessageRecord);
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
    if ((!paramMessageRecord.isSend()) && (!MessageUtils.b(paramMessageRecord.msgtype)))
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
      b(paramMessageRecord, paramMessage, paramBoolean3);
    }
    return paramBoolean2;
  }
  
  public boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "10000")) || (TextUtils.equals(paramString, "1000000")) || (TextUtils.equals(paramString, "50000000")) || (TextUtils.equals(paramString, "80000000")) || (b(paramString));
  }
  
  public Message b(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    if (paramString == null) {
      return new Message();
    }
    String str1 = UinTypeUtil.a(paramString, paramInt1);
    Object localObject = null;
    Message localMessage = (Message)this.b.getCachedMsg().get(str1);
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
          a(localMessage.istroop).c(localMessage.frienduin, localMessage.istroop);
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
    if ((paramString != null) && (UinTypeUtil.c(paramString.frienduin, paramString.istroop))) {
      paramString.istroop = UinTypeUtil.e(paramString.istroop);
    }
    return paramString;
  }
  
  public void b()
  {
    synchronized (this.g)
    {
      this.g.notify();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest notify");
      }
      return;
    }
  }
  
  public void b(Message paramMessage) {}
  
  public void b(RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.f)
    {
      boolean bool = paramRefreshMessageContext.s;
      if (bool)
      {
        try
        {
          this.f.wait(40000L);
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
  
  public void b(MessageRecord paramMessageRecord) {}
  
  protected void b(MessageRecord paramMessageRecord, Message paramMessage)
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
  
  protected void b(String paramString, int paramInt)
  {
    e.d(this.a, paramString, paramInt);
  }
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext);
  
  protected void b(String paramString, int paramInt, long paramLong) {}
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
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
    if ((this.c.getUnreadCount(paramString, paramInt) <= 0) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.c.cleanUnread(paramString, paramInt, paramLong, true);
      return;
    }
    this.c.cleanUnreadFrom(paramString, paramInt, paramLong);
    b(paramString, paramInt, paramLong);
    Object localObject = this.b;
    ((IMessageFacade)localObject).setChangeAndNotify(((IMessageFacade)localObject).getLastMessage(paramString, paramInt));
    b(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      long l = e(paramString, paramInt1);
      if (l != 0L)
      {
        Message localMessage;
        if (UinTypeUtil.e(paramInt1) == 1009)
        {
          localMessage = this.b.getLastMessage(AppConstants.SAME_STATE_BOX_UIN, 1009);
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
          int i = UinTypeUtil.e(paramInt1);
          boolean bool2 = false;
          boolean bool1 = false;
          MessageRecord localMessageRecord;
          if ((i != 1001) && (UinTypeUtil.e(paramInt1) != 10002))
          {
            if (UinTypeUtil.e(paramInt1) == 1010)
            {
              bool2 = UinTypeUtil.c(paramMessageRecord);
              if (bool2) {
                bool1 = this.c.isInMsgBox(paramString, 1010, AppConstants.DATE_UIN);
              }
              if ((bool2) && (!bool1))
              {
                localMessage = this.b.getLastMessage(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
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
                  localMessage = this.b.getLastMessage(AppConstants.DATE_UIN, 1010);
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
                localMessage = this.b.getLastMessage(AppConstants.DATE_UIN, 1010);
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
            i = UinTypeUtil.e(paramInt1);
            boolean bool3 = UinTypeUtil.c(paramMessageRecord);
            bool1 = bool2;
            if (bool3) {
              bool1 = this.c.isInMsgBox(paramString, i, AppConstants.LBS_HELLO_UIN);
            }
            if ((bool3) && (!bool1))
            {
              localMessage = this.b.getLastMessage(AppConstants.LBS_SAY_HELLO_LIST_UIN, i);
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
                localMessage = this.b.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
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
              localMessage = this.b.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
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
    a(paramString, paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  protected boolean b(String paramString)
  {
    return e.a(this.a, paramString);
  }
  
  public void c(Message paramMessage) {}
  
  public void c(MessageRecord paramMessageRecord)
  {
    e.a(this.a, this.b, this, paramMessageRecord);
  }
  
  public void c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
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
    if (!UinTypeUtil.c(paramString, paramInt))
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
      if (this.c.getUnreadCount((String)localObject, paramInt) > 0)
      {
        paramString = a(paramInt).e((String)localObject, paramInt);
        localIConversationFacade = this.c;
        if (paramString != null) {
          l = a(paramString);
        }
        localIConversationFacade.cleanUnread((String)localObject, paramInt, l, paramBoolean1, paramBoolean2);
        d((String)localObject, paramInt);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
      }
    }
    int i;
    if (this.c.getUnreadCount(paramString, paramInt) > 0)
    {
      localObject = a(paramInt).e(paramString, paramInt);
      localIConversationFacade = this.c;
      if (localObject != null) {
        l = a((MessageRecord)localObject);
      }
      localIConversationFacade.cleanUnread(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      d(paramString, paramInt);
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
      e.a(this.a, true, true);
      e.a(this.a, true, false);
    }
    if (i != 0)
    {
      localObject = this.b;
      ((IMessageFacade)localObject).setChangeAndNotify(((IMessageFacade)localObject).getLastMessage(paramString, paramInt));
    }
  }
  
  protected boolean c(String paramString, int paramInt)
  {
    return e.c(this.a, paramString, paramInt);
  }
  
  protected void d(String paramString, int paramInt) {}
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (MessageRecordInfo.b(paramMessageRecord.issend)))
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
  
  public void e(MessageRecord paramMessageRecord)
  {
    Object localObject1 = this.b.getLastMsgForMsgTabWithAutoInit(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject1 != null)
    {
      a((MessageRecord)localObject1, true, 4);
      b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, (MessageRecord)localObject1, 4);
      return;
    }
    Object localObject2 = null;
    Object localObject3 = this.a.getAccount();
    int i = UinTypeUtil.e(paramMessageRecord.istroop);
    if ((i != 1001) && (i != 10002))
    {
      if (UinTypeUtil.e(paramMessageRecord.istroop) == 1009)
      {
        a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramMessageRecord.frienduin, (String)localObject3);
        localObject1 = this.b.getLastMessage(AppConstants.SAME_STATE_BOX_UIN, 1009);
      }
      else
      {
        localObject1 = localObject2;
        if (UinTypeUtil.e(paramMessageRecord.istroop) == 1010) {
          if (UinTypeUtil.c(paramMessageRecord))
          {
            a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, paramMessageRecord.frienduin, (String)localObject3);
            localObject3 = this.b.getLastMessage(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
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
            localObject1 = this.b.getLastMessage(AppConstants.DATE_UIN, 1010);
          }
        }
      }
    }
    else if (UinTypeUtil.c(paramMessageRecord))
    {
      a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, paramMessageRecord.frienduin, (String)localObject3);
      localObject3 = this.b.getLastMessage(AppConstants.LBS_SAY_HELLO_LIST_UIN, i);
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
      localObject1 = this.b.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
    }
    if ((localObject1 != null) && (((Message)localObject1).senderuin != null) && (((Message)localObject1).senderuin.equals(paramMessageRecord.frienduin))) {
      ((Message)localObject1).cleanMessageRecordBaseField();
    }
  }
  
  public void f(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int j = paramMessageRecord.istroop;
    paramMessageRecord = UinTypeUtil.a((String)localObject, j);
    if (this.b.getCachedMsg().containsKey(paramMessageRecord))
    {
      int i;
      if (j == 1026) {
        i = 1;
      } else {
        i = j;
      }
      RecentUser localRecentUser = ((IRecentUserProxyService)this.a.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().c((String)localObject, i);
      localObject = this.b.getLastMsgForMsgTabWithAutoInit((String)localObject, j);
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
          e.a(this.a, localRecentUser);
          ((IRecentUserProxyService)this.a.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().b(localRecentUser);
        }
      }
      else if (localRecentUser != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
        }
        this.b.removeRecentUser(localRecentUser);
        this.b.getCachedMsg().remove(paramMessageRecord);
      }
      if (localRecentUser != null) {
        this.b.setChangeAndNotify(localRecentUser);
      }
    }
  }
  
  public void g(MessageRecord paramMessageRecord) {}
  
  public boolean h(MessageRecord paramMessageRecord)
  {
    return e.a(this, paramMessageRecord);
  }
  
  public void i(MessageRecord paramMessageRecord)
  {
    ThreadManager.executeOnNetWorkThread(new BaseMessageManager.1(this, paramMessageRecord, System.currentTimeMillis()));
  }
  
  public void j(MessageRecord paramMessageRecord)
  {
    Object localObject = HardCodeUtil.a(2131899244);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5040, 1, paramMessageRecord.time);
    ((UniteGrayTipParam)localObject).q = false;
    localMessageForUniteGrayTip.initGrayTipMsg(this.a, (UniteGrayTipParam)localObject);
    localMessageForUniteGrayTip.msgUid = paramMessageRecord.msgUid;
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    this.b.removeMsgByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, false);
    localObject = a(paramMessageRecord.istroop).g(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      UniteGrayTipMsgUtil.a(this.a, localMessageForUniteGrayTip);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "doRevokeFakeMsgToGrayTips error: AIO is empty");
    }
    e.a(this.a, paramMessageRecord.frienduin, paramMessageRecord.istroop, BaseMessageProcessor.a, BaseMessageProcessor.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager
 * JD-Core Version:    0.7.0.1
 */