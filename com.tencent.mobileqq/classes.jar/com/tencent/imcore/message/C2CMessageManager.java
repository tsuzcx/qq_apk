package com.tencent.imcore.message;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.adder.IC2CAddMessageHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class C2CMessageManager
  extends BaseMessageManager
{
  protected static C2CMessageManager.Callback a;
  
  static {}
  
  public C2CMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
  }
  
  private int a(MessageRecord paramMessageRecord, BaseMessageManager.AddMessageContext paramAddMessageContext, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1;
    RecentUser localRecentUser = a(paramMap, paramRecentUserProxy, paramString1, paramInt1, paramInt2, paramBoolean);
    paramInt2 = i;
    if (!MsgProxyUtils.b(paramMessageRecord.msgtype))
    {
      if ((i == 1008) && (!jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString1))) {
        return i;
      }
      if (jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord)) {
        return i;
      }
      if (paramString1.equals(AppConstants.NEARBY_LBS_HELLO_UIN))
      {
        paramAddMessageContext = new StringBuilder();
        paramAddMessageContext.append("mr.senderUin = ");
        paramAddMessageContext.append(paramMessageRecord.senderuin);
        QLog.i("Q.msg.BaseMessageManager.NEARBY_MSG", 2, paramAddMessageContext.toString());
        return i;
      }
      if ((i == 1009) && (paramString1.equals(AppConstants.SAME_STATE_BOX_UIN)))
      {
        a(paramRecentUserProxy, paramLong, localRecentUser);
        return i;
      }
      if ((i == 1032) && (paramString1.equals(AppConstants.CONFESS_UIN)))
      {
        a(paramMessageRecord, paramRecentUserProxy, paramLong, localRecentUser);
        return i;
      }
      if (jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord, paramString1, i))
      {
        a(paramMessageRecord, paramAddMessageContext, paramString1, i);
        return i;
      }
      if (jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord, paramString1, paramInt1, paramAddMessageContext)) {
        return i;
      }
      if (paramMessageRecord.msgtype == -1034)
      {
        a(paramMap, paramRecentUserProxy, paramString1, paramInt1, paramLong, localRecentUser);
        return i;
      }
      if ((paramMessageRecord.msgtype == -5010) && (paramMessageRecord.isSend()))
      {
        b(paramMessageRecord, paramMap, paramString1, paramInt1, paramLong, localRecentUser);
        return i;
      }
      if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (paramMessageRecord.isSend()))
      {
        a(paramMessageRecord, paramMap, paramString1, paramInt1, paramLong, localRecentUser);
        return i;
      }
      if ((paramMessageRecord.frienduin.equals(AppConstants.MAYKNOW_RECOMMEND_UIN)) && (paramMessageRecord.istroop == 0))
      {
        a(paramMap, paramString1, paramInt1, paramLong, localRecentUser, "add recentUserCache MAYKNOW_RECOMMEND_UIN");
        return i;
      }
      if ((paramMessageRecord.frienduin.equals(AppConstants.FRIEND_ANNIVER_UIN)) && (paramMessageRecord.istroop == 0))
      {
        a(paramMap, paramString1, paramInt1, paramLong, localRecentUser, "add recentUserCache FRIEND_ANNIVER_UIN");
        return i;
      }
      if ((paramMessageRecord.frienduin.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) && (paramMessageRecord.istroop == 0))
      {
        a(paramMap, paramString1, paramInt1, paramLong, localRecentUser, "add recentUserCache FRIEND_SYSTEM_MSG_UIN");
        return i;
      }
      if (a(i, paramMessageRecord, paramString1)) {
        return i;
      }
      paramInt2 = a(paramMessageRecord, paramMap, paramString1, paramString2, paramInt1, paramLong, localRecentUser);
    }
    return paramInt2;
  }
  
  private int a(MessageRecord paramMessageRecord, Map<String, RecentUser> paramMap, String paramString1, String paramString2, int paramInt, long paramLong, RecentUser paramRecentUser)
  {
    paramRecentUser.uin = paramString1;
    int i;
    if ((paramInt != 1000) && (paramInt != 1020))
    {
      i = paramInt;
      if (paramInt != 1004) {}
    }
    else if (jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.b(this.jdField_a_of_type_MqqAppAppRuntime, paramString1))
    {
      paramRecentUser.setType(0);
      paramRecentUser.troopUin = "";
      i = 0;
    }
    else
    {
      i = paramInt;
      if (!TextUtils.equals(paramString2, this.jdField_a_of_type_MqqAppAppRuntime.getAccount()))
      {
        i = paramInt;
        if (!TextUtils.equals(paramString2, paramString1))
        {
          paramRecentUser.troopUin = paramString2;
          i = paramInt;
        }
      }
    }
    paramRecentUser.setType(UinTypeUtil.a(paramRecentUser.getType()));
    boolean bool = true;
    if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
      bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_d_of_type_Boolean;
    }
    if ((paramLong > paramRecentUser.lastmsgtime) && (bool)) {
      paramRecentUser.lastmsgtime = paramLong;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache ELSE");
    }
    paramMap.put(UinTypeUtil.a(paramString1, i), paramRecentUser);
    return i;
  }
  
  private long a(String paramString)
  {
    paramString = ((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).b(paramString);
    if (paramString == null) {
      return 0L;
    }
    return ((Long)paramString.first).longValue();
  }
  
  private long a(String paramString, int paramInt1, int paramInt2, long paramLong, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt3, ArrayList<MessageRecord> paramArrayList)
  {
    long l = paramMessageRecord.time;
    if (paramInt3 >= paramInt2)
    {
      paramInt1 = paramInt3 - paramInt2;
      while (paramInt1 < paramInt3)
      {
        paramString = (MessageRecord)paramList.get(paramInt1);
        if (paramString.time >= paramLong) {
          paramArrayList.add(paramString);
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("all in cache", paramArrayList);
    }
    else
    {
      paramMessageRecord = (MessageRecord)paramList.get(0);
      paramList = paramList.subList(0, paramInt3).iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.time >= paramLong) {
          paramArrayList.add(localMessageRecord);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("cache part", paramArrayList);
      paramInt2 -= paramArrayList.size();
      paramArrayList.addAll(0, a(paramInt1).a(paramString, paramInt1, paramMessageRecord.time, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramMessageRecord.time), Long.valueOf(paramMessageRecord.getId()) })));
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("cache + db", paramArrayList);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("NavigateRefreshMessageListHead memdb:size:");
        paramString.append(paramArrayList.size());
        paramString.append(",miss:");
        paramString.append(paramInt2);
        QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("NavigateRefreshMessageListHead fromTime:");
      paramString.append(l);
      QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
    }
    return l;
  }
  
  private long a(boolean paramBoolean, long paramLong)
  {
    long l = paramLong;
    if (paramBoolean) {
      l = Math.max(paramLong, NetConnInfoCenter.getServerTime() - 86400L);
    }
    return l;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time, paramMessageRecord.senderuin, paramMessageRecord.msg);
  }
  
  private RecentUser a(Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != 1032) {
      paramRecentUserProxy = paramRecentUserProxy.a(paramString, paramInt2);
    } else {
      paramRecentUserProxy = paramRecentUserProxy.a(paramString, paramInt1);
    }
    if (paramBoolean) {
      paramRecentUserProxy.lFlag = 16L;
    }
    paramString = paramRecentUserProxy;
    if (paramMap.containsKey(UinTypeUtil.a(paramRecentUserProxy.uin, paramRecentUserProxy.getType()))) {
      paramString = (RecentUser)paramMap.get(UinTypeUtil.a(paramRecentUserProxy.uin, paramRecentUserProxy.getType()));
    }
    return paramString;
  }
  
  private ArrayList<MessageRecord> a(String paramString, List<MessageRecord> paramList1, List<MessageRecord> paramList2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("C2CMsgFilter basetime=");
    ((StringBuilder)localObject2).append(paramLong1);
    ((StringBuilder)localObject2).append(",lowtime=");
    ((StringBuilder)localObject2).append(paramLong2);
    ((IMessageFacade)localObject1).qLogColor(((StringBuilder)localObject2).toString(), "");
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      long l1 = -1L;
      long l2 = 9223372036854775807L;
      localObject1 = paramList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        long l3 = l2;
        if (l2 >= ((MessageRecord)localObject2).time) {
          l3 = ((MessageRecord)localObject2).time;
        }
        l2 = l3;
        if (l1 <= ((MessageRecord)localObject2).time)
        {
          l1 = ((MessageRecord)localObject2).time;
          l2 = l3;
        }
      }
      localObject2 = b(paramString, 0, l2 - 30L, 30L + l1);
      if (paramList2 == null) {
        localObject1 = null;
      } else {
        localObject1 = new ArrayList();
      }
      Object localObject3 = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-1000);
      MessageRecord localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-1000);
      a(paramList1, paramLong1, localArrayList, (List)localObject2, (List)localObject1, (MessageRecord)localObject3, localMessageRecord);
      if ((paramLong1 > 0L) && (localObject1 != null))
      {
        ((MessageRecord)localObject3).time = paramLong2;
        localMessageRecord.time = paramLong1;
        paramString = b(paramString, 0, paramLong2, paramLong1).iterator();
        while (paramString.hasNext())
        {
          paramList1 = (MessageRecord)paramString.next();
          if ((!UinTypeUtil.c(paramList1.msgtype)) && (paramList1.time <= paramLong1))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("addmsg ptt = ");
            ((StringBuilder)localObject3).append(paramList1.getId());
            ((IMessageFacade)localObject2).qLogColor(((StringBuilder)localObject3).toString(), "");
            MsgProxyUtils.b((List)localObject1, paramList1, true);
          }
        }
      }
      if (paramList2 != null) {
        paramList2.addAll((Collection)localObject1);
      }
      return localArrayList;
    }
    return localArrayList;
  }
  
  @NotNull
  private ArrayList<MessageRecord> a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.time != paramMessageRecord.time) {
        break;
      }
      localArrayList.add(localMessageRecord);
      i += 1;
    }
    return localArrayList;
  }
  
  private List<MessageRecord> a(String paramString, List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString, paramList, localArrayList, paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("needSave", paramString);
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("msgInDB", localArrayList);
    if ((paramString != null) && (!paramString.isEmpty())) {
      a(((MessageRecord)paramString.get(0)).istroop).a(paramString, null);
    }
    paramList = paramString.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (MessageRecord)paramList.next();
      Object localObject2;
      Object localObject3;
      StringBuilder localStringBuilder;
      if (((MessageRecord)localObject1).getId() < 0L)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("refresh C2C insert db error ! , mr.seq = ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject1).shmsgseq);
        ((StringBuilder)localObject3).append(" , mr.uniseq = ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject1).uniseq);
        ((StringBuilder)localObject3).append(", mr.uid=");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject1).msgUid);
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mr.msg = ");
        localStringBuilder.append(((MessageRecord)localObject1).getLogColorContent());
        ((IMessageFacade)localObject2).qLogColor((String)localObject3, localStringBuilder.toString());
        localObject2 = a((MessageRecord)localObject1);
        if (localObject2 == null)
        {
          localArrayList.remove(localObject1);
        }
        else
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh C2C insert db error ! , m.seq = ");
          localStringBuilder.append(((MessageRecord)localObject2).shmsgseq);
          localStringBuilder.append(" , mr.uniseq = ");
          localStringBuilder.append(((MessageRecord)localObject2).uniseq);
          localStringBuilder.append(", m.uid=");
          localStringBuilder.append(((MessageRecord)localObject2).msgUid);
          ((IMessageFacade)localObject3).qLogColor(localStringBuilder.toString(), "");
          localArrayList.set(localArrayList.indexOf(localObject1), localObject2);
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("refresh C2C roam step 3 , mr.seq = ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject1).shmsgseq);
        ((StringBuilder)localObject3).append(" , mr.uniseq = ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject1).uniseq);
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mr.msg = ");
        localStringBuilder.append(((MessageRecord)localObject1).getLogColorContent());
        ((IMessageFacade)localObject2).qLogColor((String)localObject3, localStringBuilder.toString());
      }
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setC2CRoamMessageResult needsave=");
    ((StringBuilder)localObject1).append(paramString.size());
    paramList.qLogColor(((StringBuilder)localObject1).toString(), "");
    return localArrayList;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord.time > paramLong1) && (localMessageRecord.time < paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(C2CMessageManager.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback = paramCallback;
  }
  
  private void a(C2CMessageManager.FindBaseMsgResult paramFindBaseMsgResult, String paramString, int paramInt1, int paramInt2, long paramLong, List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult, C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult).time);
    if (C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult) >= paramInt2)
    {
      paramInt1 = C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult) - paramInt2;
      while (paramInt1 < C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult))
      {
        paramString = (MessageRecord)paramList.get(paramInt1);
        if (paramString.time >= paramLong) {
          paramArrayList.add(paramString);
        }
        paramInt1 += 1;
      }
      a(paramArrayList, "all in cache");
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("all in cache", paramArrayList);
    }
    else
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.get(0);
      paramList = paramList.subList(0, C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult)).iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord2 = (MessageRecord)paramList.next();
        if (localMessageRecord2.time >= paramLong) {
          paramArrayList.add(localMessageRecord2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("cache part", paramArrayList);
      a(paramArrayList, "cache part");
      paramInt2 -= paramArrayList.size();
      paramArrayList.addAll(0, a(paramInt1).a(paramString, paramInt1, localMessageRecord1.time, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong), Long.valueOf(localMessageRecord1.time), Long.valueOf(localMessageRecord1.getId()) })));
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("cache + db", paramArrayList);
      a(paramArrayList, "cache + db");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("refreshC2CMessageListHead memdb:size:");
        paramString.append(paramArrayList.size());
        paramString.append(",miss:");
        paramString.append(paramInt2);
        QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("refreshC2CMessageListHead fromTime:");
      paramString.append(C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult));
      QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
    }
  }
  
  private void a(RecentUserProxy paramRecentUserProxy, long paramLong, RecentUser paramRecentUser)
  {
    if (paramLong > paramRecentUser.lastmsgtime) {
      paramRecentUser.lastmsgtime = paramLong;
    }
    paramRecentUser.setType(UinTypeUtil.a(paramRecentUser.getType()));
    paramRecentUserProxy.b(paramRecentUser);
  }
  
  private void a(MessageRecord paramMessageRecord, BaseMessageManager.AddMessageContext paramAddMessageContext, String paramString, int paramInt)
  {
    paramString = UinTypeUtil.a(paramString, paramInt);
    if (paramAddMessageContext.f.containsKey(paramString))
    {
      ((List)paramAddMessageContext.f.get(paramString)).add(paramMessageRecord);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageRecord);
    paramAddMessageContext.f.put(paramString, localArrayList);
  }
  
  private void a(MessageRecord paramMessageRecord, RecentUserProxy paramRecentUserProxy, long paramLong, RecentUser paramRecentUser)
  {
    if ((paramLong > paramRecentUser.lastmsgtime) && (jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.b(paramMessageRecord))) {
      paramRecentUser.lastmsgtime = paramLong;
    }
    paramRecentUser.setType(UinTypeUtil.a(paramRecentUser.getType()));
    paramRecentUserProxy.b(paramRecentUser);
  }
  
  private void a(MessageRecord paramMessageRecord, IConversationFacade paramIConversationFacade, int paramInt)
  {
    if ((paramInt != 3000) && (paramInt != 1) && (paramInt != 7000))
    {
      String str2 = paramMessageRecord.frienduin;
      String str1 = str2;
      if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(str2)) {
        str1 = paramMessageRecord.senderuin;
      }
      if ((paramInt == 1001) && (!paramMessageRecord.isSend()) && (jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(paramMessageRecord))) {
        if (UinTypeUtil.a(paramMessageRecord)) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8005C8E", "0X8005C8E", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8005C8F", "0X8005C8F", 0, 0, "", "", "", "");
        }
      }
      if ((UinTypeUtil.a(paramInt) != 1009) && (paramIConversationFacade.isInMsgBox(str1, 1009)))
      {
        paramIConversationFacade.moveBoxToMessageTab(AppConstants.SAME_STATE_BOX_UIN, 1009, str1, paramMessageRecord.istroop);
        a(AppConstants.SAME_STATE_BOX_UIN, 1009, str1, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      }
      if ((UinTypeUtil.a(paramInt) != 1001) && (paramIConversationFacade.isInMsgBox(str1, 1001)))
      {
        paramIConversationFacade.moveBoxToMessageTab(AppConstants.LBS_HELLO_UIN, 1001, str1, paramMessageRecord.istroop);
        if (paramIConversationFacade.isInMsgBox(str1, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN)) {
          a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, str1, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        } else {
          a(AppConstants.LBS_HELLO_UIN, 1001, str1, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        }
      }
      if ((UinTypeUtil.a(paramInt) != 1010) && (paramIConversationFacade.isInMsgBox(str1, 1010)))
      {
        paramIConversationFacade.moveBoxToMessageTab(AppConstants.DATE_UIN, 1010, str1, paramMessageRecord.istroop);
        if (paramIConversationFacade.isInMsgBox(str1, 1010, AppConstants.DATE_SAY_HELLO_LIST_UIN)) {
          a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, str1, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        } else {
          a(AppConstants.DATE_UIN, 1010, str1, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        }
      }
      if ((UinTypeUtil.a(paramInt) != 1044) && (paramIConversationFacade.isInMsgBox(str1, 1044)) && (paramIConversationFacade.isInMsgBox(str1, 1044, AppConstants.MATCH_CHAT_UIN))) {
        a(AppConstants.MATCH_CHAT_UIN, 1044, str1, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      }
      if ((UinTypeUtil.a(paramInt) != 10008) && (paramIConversationFacade.isInMsgBox(str1, 10008)) && (paramIConversationFacade.isInMsgBox(str1, 10008, AppConstants.QCIRCLE_CHAT_UIN))) {
        a(AppConstants.QCIRCLE_CHAT_UIN, 10008, str1, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, Map<String, RecentUser> paramMap, String paramString, int paramInt, long paramLong, RecentUser paramRecentUser)
  {
    if (((paramMessageRecord.isBlessMsg) && (paramMessageRecord.needUpdateMsgTag)) || ((paramMessageRecord.isCheckNeedShowInListTypeMsg) && (paramMessageRecord.needNeedShowInList)))
    {
      paramRecentUser.uin = paramString;
      paramRecentUser.setType(0);
      if (paramLong > paramRecentUser.lastmsgtime) {
        paramRecentUser.lastmsgtime = paramLong;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache isBlessMsg");
      }
      paramMap.put(UinTypeUtil.a(paramString, paramInt), paramRecentUser);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i = paramArrayList.size();
    IRoamMsgFetcher localIRoamMsgFetcher = paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher;
    if ((localIRoamMsgFetcher != null) && (!localIRoamMsgFetcher.a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, paramMessageRecord, paramLong)))
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.qLogColor("get roam msg failed", "");
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
      if (paramArrayList.isEmpty())
      {
        if (paramMessageRecord == null) {
          paramLong = 0L;
        } else {
          paramLong = paramMessageRecord.uniseq;
        }
      }
      else {
        paramLong = ((MessageRecord)paramArrayList.get(0)).uniseq;
      }
      a(paramString, paramInt1, paramLong, paramInt2 - i, paramRefreshMessageContext, paramArrayList, false);
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, long paramLong1, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2, Bundle paramBundle, long paramLong2, int paramInt3)
  {
    if (!paramBundle.getBoolean("timeout"))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshC2CMessageListHead ");
        localStringBuilder.append(paramArrayList.size());
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      a(paramInt1).a(paramString, paramInt1, paramLong2, paramArrayList);
      boolean bool1 = paramBundle.getBoolean("success");
      boolean bool2 = paramBundle.getBoolean("complete");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("success ?");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", complete?");
        localStringBuilder.append(bool2);
        QLog.w("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      if ((!paramBoolean1) && ((!bool1) || (bool2)))
      {
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        if (!paramArrayList.isEmpty()) {
          paramLong2 = ((MessageRecord)paramArrayList.get(0)).uniseq;
        }
        if (paramArrayList.isEmpty()) {
          paramInt3 = paramInt2;
        } else {
          paramInt3 = paramInt2 - paramArrayList.size();
        }
        a(paramString, paramInt1, paramLong2, paramInt3, paramRefreshMessageContext, paramArrayList);
      }
      if (!paramBoolean2)
      {
        paramRefreshMessageContext.jdField_a_of_type_Long = paramBundle.getLong("tempEct");
        paramRefreshMessageContext.b = paramBundle.getLong("tempRandom");
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update tempEct:");
        localStringBuilder.append(paramRefreshMessageContext.jdField_a_of_type_Long);
        localStringBuilder.append(", rand=");
        localStringBuilder.append(paramRefreshMessageContext.b);
        paramBundle.qLogColor(localStringBuilder.toString(), "");
      }
      if ((paramBoolean1) && (paramArrayList.size() < paramInt2) && (bool2)) {
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, paramMessageRecord, paramLong1);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.qLogColor("pull timeout", "");
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
      if (!paramArrayList.isEmpty()) {
        paramLong2 = ((MessageRecord)paramArrayList.get(0)).uniseq;
      }
      a(paramString, paramInt1, paramLong2, paramInt3, paramRefreshMessageContext, paramArrayList);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, C2CMessageManager.C2CReplyContext paramC2CReplyContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((!MsgProxyUtils.b(localMessageRecord)) && (localMessageRecord.msgUid == paramC2CReplyContext.jdField_a_of_type_Long) && (localMessageRecord.time == paramC2CReplyContext.b))
        {
          i = paramArrayList.indexOf(localMessageRecord);
          break label87;
        }
      }
      int i = -1;
      label87:
      int j = i;
      if (i == -1) {
        return;
      }
      while (j < paramArrayList.size())
      {
        localArrayList.add(paramArrayList.get(j));
        j += 1;
      }
      paramArrayList.clear();
      paramArrayList.addAll(localArrayList);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayList1.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramArrayList1.get(i);
      Iterator localIterator = paramArrayList2.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
        StringBuilder localStringBuilder;
        if (MsgProxyUtils.a(localMessageRecord2, localMessageRecord1, true))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("refreshC2CMessageListHead filterMr ");
            localStringBuilder.append(localMessageRecord2.getLogColorContent());
            localStringBuilder.append(",uniseq=");
            localStringBuilder.append(localMessageRecord2.uniseq);
            QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
          }
          localArrayList.add(localMessageRecord1);
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshC2CMessageListHead not find filterMr ");
          localStringBuilder.append(localMessageRecord2.getLogColorContent());
          localStringBuilder.append(",mr=");
          localStringBuilder.append(localMessageRecord1.getLogColorContent());
          QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
        }
      }
      i -= 1;
    }
    paramArrayList1.removeAll(localArrayList);
  }
  
  private void a(List<MessageRecord> paramList1, long paramLong, ArrayList<MessageRecord> paramArrayList, List<MessageRecord> paramList2, List<MessageRecord> paramList3, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList1.next();
      localMessageRecord.time -= 30L;
      localMessageRecord.time += 30L;
      Object localObject1 = a(paramList2, paramMessageRecord1.time, paramMessageRecord2.time);
      if ((paramList2 != null) && (paramList2.size() != 0))
      {
        Object localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (MessageRecord)((Iterator)localObject2).next();
          if (MsgProxyUtils.a((MessageRecord)localObject1, localMessageRecord, true))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("C2CMsgFilter shmsgseq equals?");
              boolean bool;
              if (localMessageRecord.shmsgseq == ((MessageRecord)localObject1).shmsgseq) {
                bool = true;
              } else {
                bool = false;
              }
              ((StringBuilder)localObject2).append(bool);
              ((StringBuilder)localObject2).append(",msg=");
              ((StringBuilder)localObject2).append(localMessageRecord.getLogColorContent());
              ((StringBuilder)localObject2).append("time:");
              ((StringBuilder)localObject2).append(localMessageRecord.time);
              ((StringBuilder)localObject2).append("<->");
              ((StringBuilder)localObject2).append(((MessageRecord)localObject1).time);
              ((StringBuilder)localObject2).append(", type=");
              ((StringBuilder)localObject2).append(((MessageRecord)localObject1).msgtype);
              ((StringBuilder)localObject2).append("-");
              ((StringBuilder)localObject2).append(localMessageRecord.msgtype);
              QLog.i("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject2).toString());
            }
            if ((paramList3 != null) && (paramLong != -1L) && (((MessageRecord)localObject1).time <= paramLong)) {
              paramList3.add(localObject1);
            }
            i = 1;
            break label341;
          }
        }
        int i = 0;
        label341:
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("C2CMsgFilter not eq: msg=");
            ((StringBuilder)localObject1).append(localMessageRecord.getLogColorContent());
            ((StringBuilder)localObject1).append("time:");
            ((StringBuilder)localObject1).append(localMessageRecord.time);
            ((StringBuilder)localObject1).append(",type:");
            ((StringBuilder)localObject1).append(localMessageRecord.msgtype);
            ((StringBuilder)localObject1).append(",msg.con : ");
            ((StringBuilder)localObject1).append(localMessageRecord.getLogColorContent());
            QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject1).toString());
          }
          if (paramList3 != null) {
            paramList3.add(localMessageRecord);
          }
          paramArrayList.add(localMessageRecord);
        }
      }
      else
      {
        paramArrayList.add(localMessageRecord);
        if (paramList3 != null) {
          paramList3.add(localMessageRecord);
        }
      }
    }
  }
  
  private void a(Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt, long paramLong, RecentUser paramRecentUser)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache start");
    }
    if (paramRecentUserProxy.a(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramRecentUserProxy = new StringBuilder();
        paramRecentUserProxy.append("insertSignMsgIfNeeded add recentUserCache uin ");
        paramRecentUserProxy.append(paramString);
        QLog.d("Q.msg.BaseMessageManager", 2, paramRecentUserProxy.toString());
      }
      paramRecentUser.uin = paramString;
      paramRecentUser.setType(UinTypeUtil.a(paramRecentUser.getType()));
      if (paramLong > paramRecentUser.lastmsgtime) {
        paramRecentUser.lastmsgtime = paramLong;
      }
      paramMap.put(UinTypeUtil.a(paramString, paramInt), paramRecentUser);
    }
  }
  
  private void a(Map<String, RecentUser> paramMap, String paramString1, int paramInt, long paramLong, RecentUser paramRecentUser, String paramString2)
  {
    paramRecentUser.uin = AppConstants.RECOMMEND_CONTACT_UIN;
    paramRecentUser.setType(4000);
    paramRecentUser.displayName = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext().getString(2131694443);
    if (paramLong > paramRecentUser.lastmsgtime) {
      paramRecentUser.lastmsgtime = paramLong;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, paramString2);
    }
    paramMap.put(UinTypeUtil.a(paramString1, paramInt), paramRecentUser);
  }
  
  private boolean a(int paramInt, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, List<MessageRecord> paramList)
  {
    if (((paramList == null) || (paramList.isEmpty())) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt);
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord.isLongMsg()) && (((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a(paramMessageRecord)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
      }
      return true;
    }
    if ((paramInt == 1044) && (paramString.equals(AppConstants.MATCH_CHAT_UIN))) {
      return true;
    }
    if (TextUtils.equals(paramMessageRecord.senderuin, AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN)) {
      return true;
    }
    return (paramInt == 10008) && (paramString.equals(AppConstants.QCIRCLE_CHAT_UIN));
  }
  
  private boolean a(C2CMessageManager.FindBaseMsgResult paramFindBaseMsgResult, String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList)
  {
    C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult, a(paramInt1).a(paramString, paramInt1, paramLong1));
    if (C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult) == null)
    {
      if (paramBoolean)
      {
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, null, 0L);
        a(paramArrayList);
        a(paramInt1).a(paramString, paramInt1, paramArrayList);
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = paramArrayList;
        if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
          c(paramString, paramInt1);
        }
        a(paramArrayList, "get Roam Msg when aioBase is null");
        paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refresh C2C finish , context = ");
        ((StringBuilder)localObject).append(paramRefreshMessageContext);
        ((StringBuilder)localObject).append(" , size = ");
        ((StringBuilder)localObject).append(paramArrayList.size());
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(", timestamp = ");
        localStringBuilder.append(System.currentTimeMillis());
        paramString.qLogColor((String)localObject, localStringBuilder.toString());
        if ((UinTypeUtil.a(paramArrayList)) && (paramRefreshMessageContext.jdField_c_of_type_Int < 3))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("refresh C2C finish, now rePull sticker msg! ");
            paramString.append(paramRefreshMessageContext.jdField_c_of_type_Int);
            QLog.i("Q.msg.BaseMessageManager", 2, paramString.toString());
          }
          a(paramRefreshMessageContext, paramInt1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.qLogColor("refresh from empty C2C msg", "");
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      }
      C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult, true);
      return true;
    }
    C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult, C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult).time);
    paramRefreshMessageContext = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshC2CMessageListHead uniseq=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", aioBase.getId():");
    ((StringBuilder)localObject).append(C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult).getId());
    paramRefreshMessageContext.qLogColor(((StringBuilder)localObject).toString(), "");
    paramArrayList.addAll(a(paramInt1).a(paramString, paramInt1, C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult), paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong2), Long.valueOf(C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult)), Long.valueOf(C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult).getId()) })));
    a(paramArrayList, "only load in db");
    paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    paramRefreshMessageContext = new StringBuilder();
    paramRefreshMessageContext.append("refreshC2CMessageListHead Db fromTime:");
    paramRefreshMessageContext.append(C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult));
    paramString.qLogColor(paramRefreshMessageContext.toString(), "");
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("only load in db", paramArrayList);
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord, int paramInt)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord, paramInt);
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    if (a(paramInt1))
    {
      if (paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIMessageRefresher != null)
      {
        paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIMessageRefresher.a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("refreshMessageListHead TYPE ERROR! TYPE = ");
        paramString.append(paramInt1);
        QLog.w("Q.msg.BaseMessageManager", 2, paramString.toString());
      }
      paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    if ((!paramRefreshMessageContext.jdField_c_of_type_Boolean) && (paramLong2 != 0L) && (paramBoolean)) {
      return false;
    }
    a(paramString, paramInt1, paramLong1, paramInt2, paramRefreshMessageContext, paramArrayList);
    a(paramArrayList, paramC2CReplyContext);
    a(paramArrayList);
    a(paramInt1).a(paramString, paramInt1, paramArrayList);
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = paramArrayList;
    if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
      c(paramString, paramInt1);
    }
    if ((UinTypeUtil.a(paramArrayList)) && (paramRefreshMessageContext.jdField_c_of_type_Int < 3)) {
      a(paramRefreshMessageContext, paramInt1);
    }
    return true;
  }
  
  /* Error */
  private boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload 9
    //   2: invokevirtual 298	java/util/ArrayList:size	()I
    //   5: iload_3
    //   6: if_icmpge +918 -> 924
    //   9: new 613	android/os/Bundle
    //   12: dup
    //   13: invokespecial 843	android/os/Bundle:<init>	()V
    //   16: astore 18
    //   18: aload_0
    //   19: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   22: invokeinterface 847 1 0
    //   27: iconst_1
    //   28: invokevirtual 852	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   31: istore 11
    //   33: aload 18
    //   35: ldc_w 854
    //   38: iload 11
    //   40: invokevirtual 857	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   43: aload 18
    //   45: ldc_w 611
    //   48: iconst_1
    //   49: invokevirtual 861	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   52: aload 18
    //   54: ldc_w 863
    //   57: aload_1
    //   58: invokestatic 866	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   61: invokevirtual 251	java/lang/Long:longValue	()J
    //   64: invokevirtual 870	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   67: aload 18
    //   69: ldc_w 872
    //   72: iload 10
    //   74: invokevirtual 861	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   77: aload_0
    //   78: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   81: invokeinterface 876 1 0
    //   86: iload 11
    //   88: invokestatic 881	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aload 9
    //   93: invokevirtual 884	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: aload_0
    //   98: aload 5
    //   100: aload 8
    //   102: invokespecial 886	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/util/List;Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/util/ArrayList;
    //   105: astore 5
    //   107: aload 8
    //   109: getfield 452	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   112: lstore 12
    //   114: aload 9
    //   116: invokevirtual 298	java/util/ArrayList:size	()I
    //   119: istore 11
    //   121: aload 9
    //   123: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   126: ifeq +9 -> 135
    //   129: iload_3
    //   130: istore 11
    //   132: goto +9 -> 141
    //   135: iload_3
    //   136: iload 11
    //   138: isub
    //   139: istore 11
    //   141: aload 18
    //   143: ldc_w 888
    //   146: lload 6
    //   148: invokevirtual 870	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   151: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +77 -> 231
    //   157: new 65	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   164: astore 8
    //   166: aload 8
    //   168: ldc_w 890
    //   171: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 8
    //   177: iload 11
    //   179: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 8
    //   185: ldc_w 892
    //   188: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 8
    //   194: lload 6
    //   196: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 8
    //   202: ldc_w 894
    //   205: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 8
    //   211: aload 5
    //   213: invokevirtual 298	java/util/ArrayList:size	()I
    //   216: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: ldc 215
    //   222: iconst_2
    //   223: aload 8
    //   225: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: iload 10
    //   233: ifne +13 -> 246
    //   236: aload 4
    //   238: getfield 650	com/tencent/imcore/message/RefreshMessageContext:b	J
    //   241: lstore 14
    //   243: goto +6 -> 249
    //   246: lconst_0
    //   247: lstore 14
    //   249: ldc_w 896
    //   252: invokestatic 408	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   255: checkcast 896	com/tencent/mobileqq/service/message/api/IMessageHandlerService
    //   258: aload_0
    //   259: getfield 38	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   262: aload_1
    //   263: lload 6
    //   265: iload 11
    //   267: i2s
    //   268: aload 18
    //   270: lload 14
    //   272: invokeinterface 900 9 0
    //   277: aload 18
    //   279: ldc_w 902
    //   282: iload 11
    //   284: invokevirtual 857	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   287: aload_0
    //   288: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   291: invokeinterface 905 1 0
    //   296: aload_1
    //   297: iload_2
    //   298: invokestatic 222	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   301: iconst_0
    //   302: invokestatic 910	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   305: invokevirtual 884	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   308: pop
    //   309: aload 9
    //   311: monitorenter
    //   312: aload 9
    //   314: ldc2_w 911
    //   317: invokevirtual 916	java/lang/Object:wait	(J)V
    //   320: goto +14 -> 334
    //   323: astore_1
    //   324: goto +595 -> 919
    //   327: astore 8
    //   329: aload 8
    //   331: invokevirtual 919	java/lang/InterruptedException:printStackTrace	()V
    //   334: aload 9
    //   336: monitorexit
    //   337: aload_0
    //   338: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   341: invokeinterface 905 1 0
    //   346: aload_1
    //   347: iload_2
    //   348: invokestatic 222	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   351: invokevirtual 920	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   354: ifeq +83 -> 437
    //   357: aload_0
    //   358: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   361: invokeinterface 905 1 0
    //   366: aload_1
    //   367: iload_2
    //   368: invokestatic 222	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   371: invokevirtual 921	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   374: checkcast 907	java/lang/Boolean
    //   377: invokevirtual 924	java/lang/Boolean:booleanValue	()Z
    //   380: ifeq +57 -> 437
    //   383: aload 4
    //   385: aconst_null
    //   386: putfield 746	com/tencent/imcore/message/RefreshMessageContext:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   389: aload_0
    //   390: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   393: astore_1
    //   394: new 65	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   401: astore 4
    //   403: aload 4
    //   405: ldc_w 788
    //   408: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 4
    //   414: invokestatic 793	java/lang/System:currentTimeMillis	()J
    //   417: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload_1
    //   422: ldc_w 926
    //   425: aload 4
    //   427: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokeinterface 388 3 0
    //   435: iconst_1
    //   436: ireturn
    //   437: aload 18
    //   439: ldc_w 611
    //   442: invokevirtual 617	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   445: ifeq +18 -> 463
    //   448: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +12 -> 463
    //   454: ldc 215
    //   456: iconst_2
    //   457: ldc_w 928
    //   460: invokestatic 636	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aload_0
    //   464: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   467: astore 8
    //   469: new 65	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   476: astore 19
    //   478: aload 19
    //   480: ldc_w 930
    //   483: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 19
    //   489: aload 9
    //   491: invokevirtual 298	java/util/ArrayList:size	()I
    //   494: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 8
    //   500: aload 19
    //   502: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: ldc 173
    //   507: invokeinterface 388 3 0
    //   512: aload_0
    //   513: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   516: ldc_w 930
    //   519: aload 9
    //   521: invokeinterface 277 3 0
    //   526: aload_0
    //   527: aload 9
    //   529: aload 5
    //   531: invokespecial 932	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   534: aload 18
    //   536: ldc_w 611
    //   539: invokevirtual 617	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   542: ifne +316 -> 858
    //   545: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq +43 -> 591
    //   551: new 65	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   558: astore 5
    //   560: aload 5
    //   562: ldc_w 619
    //   565: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 5
    //   571: aload 9
    //   573: invokevirtual 298	java/util/ArrayList:size	()I
    //   576: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: ldc 215
    //   582: iconst_2
    //   583: aload 5
    //   585: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: aload_0
    //   592: iload_2
    //   593: invokevirtual 301	com/tencent/imcore/message/C2CMessageManager:a	(I)Lcom/tencent/imcore/message/BaseMsgProxy;
    //   596: aload_1
    //   597: iload_2
    //   598: lload 12
    //   600: aload 9
    //   602: invokevirtual 622	com/tencent/imcore/message/BaseMsgProxy:a	(Ljava/lang/String;IJLjava/util/List;)V
    //   605: aload 18
    //   607: ldc_w 624
    //   610: invokevirtual 617	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   613: istore 16
    //   615: aload 18
    //   617: ldc_w 626
    //   620: invokevirtual 617	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   623: istore 17
    //   625: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +57 -> 685
    //   631: new 65	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   638: astore 5
    //   640: aload 5
    //   642: ldc_w 628
    //   645: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 5
    //   651: iload 16
    //   653: invokevirtual 631	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 5
    //   659: ldc_w 633
    //   662: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 5
    //   668: iload 17
    //   670: invokevirtual 631	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: ldc 215
    //   676: iconst_2
    //   677: aload 5
    //   679: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 636	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: iload 16
    //   687: ifeq +8 -> 695
    //   690: iload 17
    //   692: ifeq +66 -> 758
    //   695: aload 4
    //   697: iconst_1
    //   698: putfield 602	com/tencent/imcore/message/RefreshMessageContext:jdField_c_of_type_Boolean	Z
    //   701: aload 9
    //   703: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   706: ifeq +6 -> 712
    //   709: goto +17 -> 726
    //   712: aload 9
    //   714: iconst_0
    //   715: invokevirtual 604	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   718: checkcast 23	com/tencent/mobileqq/data/MessageRecord
    //   721: getfield 452	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   724: lstore 12
    //   726: aload 9
    //   728: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   731: ifeq +6 -> 737
    //   734: goto +11 -> 745
    //   737: iload_3
    //   738: aload 9
    //   740: invokevirtual 298	java/util/ArrayList:size	()I
    //   743: isub
    //   744: istore_3
    //   745: aload_0
    //   746: aload_1
    //   747: iload_2
    //   748: lload 12
    //   750: iload_3
    //   751: aload 4
    //   753: aload 9
    //   755: invokevirtual 639	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/lang/String;IJILcom/tencent/imcore/message/RefreshMessageContext;Ljava/util/ArrayList;)V
    //   758: iload 10
    //   760: ifne +164 -> 924
    //   763: aload 4
    //   765: aload 18
    //   767: ldc_w 641
    //   770: invokevirtual 644	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   773: putfield 646	com/tencent/imcore/message/RefreshMessageContext:jdField_a_of_type_Long	J
    //   776: aload 4
    //   778: aload 18
    //   780: ldc_w 648
    //   783: invokevirtual 644	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   786: putfield 650	com/tencent/imcore/message/RefreshMessageContext:b	J
    //   789: aload_0
    //   790: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   793: astore_1
    //   794: new 65	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   801: astore 5
    //   803: aload 5
    //   805: ldc_w 652
    //   808: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload 5
    //   814: aload 4
    //   816: getfield 646	com/tencent/imcore/message/RefreshMessageContext:jdField_a_of_type_Long	J
    //   819: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload 5
    //   825: ldc_w 654
    //   828: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 5
    //   834: aload 4
    //   836: getfield 650	com/tencent/imcore/message/RefreshMessageContext:b	J
    //   839: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload_1
    //   844: aload 5
    //   846: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: ldc 173
    //   851: invokeinterface 388 3 0
    //   856: iconst_0
    //   857: ireturn
    //   858: aload_0
    //   859: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   862: ldc_w 658
    //   865: ldc 173
    //   867: invokeinterface 388 3 0
    //   872: aload 4
    //   874: iconst_1
    //   875: putfield 602	com/tencent/imcore/message/RefreshMessageContext:jdField_c_of_type_Boolean	Z
    //   878: aload 9
    //   880: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   883: ifeq +6 -> 889
    //   886: goto +17 -> 903
    //   889: aload 9
    //   891: iconst_0
    //   892: invokevirtual 604	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   895: checkcast 23	com/tencent/mobileqq/data/MessageRecord
    //   898: getfield 452	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   901: lstore 12
    //   903: aload_0
    //   904: aload_1
    //   905: iload_2
    //   906: lload 12
    //   908: iload 11
    //   910: aload 4
    //   912: aload 9
    //   914: invokevirtual 639	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/lang/String;IJILcom/tencent/imcore/message/RefreshMessageContext;Ljava/util/ArrayList;)V
    //   917: iconst_0
    //   918: ireturn
    //   919: aload 9
    //   921: monitorexit
    //   922: aload_1
    //   923: athrow
    //   924: iconst_0
    //   925: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	926	0	this	C2CMessageManager
    //   0	926	1	paramString	String
    //   0	926	2	paramInt1	int
    //   0	926	3	paramInt2	int
    //   0	926	4	paramRefreshMessageContext	RefreshMessageContext
    //   0	926	5	paramList	List<MessageRecord>
    //   0	926	6	paramLong	long
    //   0	926	8	paramMessageRecord	MessageRecord
    //   0	926	9	paramArrayList	ArrayList<MessageRecord>
    //   0	926	10	paramBoolean	boolean
    //   31	878	11	i	int
    //   112	795	12	l1	long
    //   241	30	14	l2	long
    //   613	73	16	bool1	boolean
    //   623	68	17	bool2	boolean
    //   16	763	18	localBundle	Bundle
    //   476	25	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   312	320	323	finally
    //   329	334	323	finally
    //   334	337	323	finally
    //   919	922	323	finally
    //   312	320	327	java/lang/InterruptedException
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2)
  {
    if ((!paramRefreshMessageContext.jdField_c_of_type_Boolean) && (paramLong2 != 0L) && ((paramBoolean2) || (paramBoolean1))) {
      return false;
    }
    a(paramString, paramInt1, paramLong1, paramInt2, paramRefreshMessageContext, paramArrayList);
    a(paramArrayList);
    a(paramInt1).a(paramString, paramInt1, paramArrayList);
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = paramArrayList;
    if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
      c(paramString, paramInt1);
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refresh load local C2C msg only FIN , context = ");
    ((StringBuilder)localObject).append(paramRefreshMessageContext);
    ((StringBuilder)localObject).append(", size = ");
    if (paramArrayList == null) {
      paramInt2 = -1;
    } else {
      paramInt2 = paramArrayList.size();
    }
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", timestamp = ");
    localStringBuilder.append(System.currentTimeMillis());
    paramString.qLogColor((String)localObject, localStringBuilder.toString());
    if ((UinTypeUtil.a(paramArrayList)) && (paramRefreshMessageContext.jdField_c_of_type_Int < 3)) {
      a(paramRefreshMessageContext, paramInt1);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
    }
    return true;
  }
  
  /* Error */
  private boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 613	android/os/Bundle
    //   3: dup
    //   4: invokespecial 843	android/os/Bundle:<init>	()V
    //   7: astore 17
    //   9: aload_0
    //   10: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   13: invokeinterface 847 1 0
    //   18: iconst_1
    //   19: invokevirtual 852	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   22: istore 12
    //   24: aload 17
    //   26: ldc_w 854
    //   29: iload 12
    //   31: invokevirtual 857	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   34: aload 17
    //   36: ldc_w 611
    //   39: iconst_1
    //   40: invokevirtual 861	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   43: aload 17
    //   45: ldc_w 863
    //   48: aload_1
    //   49: invokestatic 866	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   52: invokevirtual 251	java/lang/Long:longValue	()J
    //   55: invokevirtual 870	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   58: aload 17
    //   60: ldc_w 872
    //   63: iload 11
    //   65: invokevirtual 861	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   68: aload_0
    //   69: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   72: invokeinterface 876 1 0
    //   77: iload 12
    //   79: invokestatic 881	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aload 10
    //   84: invokevirtual 884	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: aload 6
    //   91: aload 9
    //   93: invokespecial 886	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/util/List;Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/util/ArrayList;
    //   96: astore 6
    //   98: aload 9
    //   100: getfield 452	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   103: lstore 15
    //   105: aload 10
    //   107: invokevirtual 298	java/util/ArrayList:size	()I
    //   110: istore 12
    //   112: aload 10
    //   114: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   117: ifeq +9 -> 126
    //   120: iload_3
    //   121: istore 12
    //   123: goto +9 -> 132
    //   126: iload_3
    //   127: iload 12
    //   129: isub
    //   130: istore 12
    //   132: aload 17
    //   134: ldc_w 888
    //   137: lload 7
    //   139: invokevirtual 870	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   142: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +77 -> 222
    //   148: new 65	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   155: astore 18
    //   157: aload 18
    //   159: ldc_w 890
    //   162: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 18
    //   168: iload 12
    //   170: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 18
    //   176: ldc_w 892
    //   179: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 18
    //   185: lload 7
    //   187: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 18
    //   193: ldc_w 894
    //   196: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 18
    //   202: aload 6
    //   204: invokevirtual 298	java/util/ArrayList:size	()I
    //   207: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: ldc 215
    //   213: iconst_2
    //   214: aload 18
    //   216: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: lconst_0
    //   223: lstore 13
    //   225: iload 11
    //   227: ifne +10 -> 237
    //   230: aload 4
    //   232: getfield 650	com/tencent/imcore/message/RefreshMessageContext:b	J
    //   235: lstore 13
    //   237: ldc_w 896
    //   240: invokestatic 408	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   243: checkcast 896	com/tencent/mobileqq/service/message/api/IMessageHandlerService
    //   246: aload_0
    //   247: getfield 38	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   250: aload_1
    //   251: lload 7
    //   253: iload 12
    //   255: i2s
    //   256: aload 17
    //   258: lload 13
    //   260: invokeinterface 900 9 0
    //   265: aload 17
    //   267: ldc_w 902
    //   270: iload 12
    //   272: invokevirtual 857	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   275: aload_0
    //   276: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   279: invokeinterface 905 1 0
    //   284: aload_1
    //   285: iload_2
    //   286: invokestatic 222	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   289: iconst_0
    //   290: invokestatic 910	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   293: invokevirtual 884	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   296: pop
    //   297: aload 10
    //   299: monitorenter
    //   300: aload 10
    //   302: ldc2_w 911
    //   305: invokevirtual 916	java/lang/Object:wait	(J)V
    //   308: goto +14 -> 322
    //   311: astore_1
    //   312: goto +257 -> 569
    //   315: astore 18
    //   317: aload 18
    //   319: invokevirtual 919	java/lang/InterruptedException:printStackTrace	()V
    //   322: aload 10
    //   324: monitorexit
    //   325: aload_0
    //   326: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   329: invokeinterface 905 1 0
    //   334: aload_1
    //   335: iload_2
    //   336: invokestatic 222	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   339: invokevirtual 920	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   342: ifeq +94 -> 436
    //   345: aload_0
    //   346: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   349: invokeinterface 905 1 0
    //   354: aload_1
    //   355: iload_2
    //   356: invokestatic 222	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   359: invokevirtual 921	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: checkcast 907	java/lang/Boolean
    //   365: invokevirtual 924	java/lang/Boolean:booleanValue	()Z
    //   368: ifeq +68 -> 436
    //   371: aload 4
    //   373: aconst_null
    //   374: putfield 746	com/tencent/imcore/message/RefreshMessageContext:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   377: aload_0
    //   378: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   381: astore_1
    //   382: new 65	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   389: astore 6
    //   391: aload 6
    //   393: ldc_w 788
    //   396: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 6
    //   402: invokestatic 793	java/lang/System:currentTimeMillis	()J
    //   405: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_1
    //   410: ldc_w 926
    //   413: aload 6
    //   415: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokeinterface 388 3 0
    //   423: aload_0
    //   424: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   427: aload 4
    //   429: invokeinterface 804 2 0
    //   434: iconst_1
    //   435: ireturn
    //   436: aload 17
    //   438: ldc_w 611
    //   441: invokevirtual 617	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   444: ifeq +18 -> 462
    //   447: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +12 -> 462
    //   453: ldc 215
    //   455: iconst_2
    //   456: ldc_w 928
    //   459: invokestatic 636	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_0
    //   463: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   466: astore 18
    //   468: new 65	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   475: astore 19
    //   477: aload 19
    //   479: ldc_w 930
    //   482: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 19
    //   488: aload 10
    //   490: invokevirtual 298	java/util/ArrayList:size	()I
    //   493: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 18
    //   499: aload 19
    //   501: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: ldc 173
    //   506: invokeinterface 388 3 0
    //   511: aload_0
    //   512: getfield 269	com/tencent/imcore/message/C2CMessageManager:jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade	Lcom/tencent/mobileqq/msg/api/IMessageFacade;
    //   515: ldc_w 930
    //   518: aload 10
    //   520: invokeinterface 277 3 0
    //   525: aload_0
    //   526: aload 10
    //   528: ldc_w 942
    //   531: invokevirtual 503	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/util/List;Ljava/lang/String;)V
    //   534: aload_0
    //   535: aload 10
    //   537: aload 6
    //   539: invokespecial 932	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   542: aload_0
    //   543: aload_1
    //   544: iload_2
    //   545: iload_3
    //   546: aload 4
    //   548: iload 5
    //   550: lload 7
    //   552: aload 9
    //   554: aload 10
    //   556: iload 11
    //   558: aload 17
    //   560: lload 15
    //   562: iload 12
    //   564: invokespecial 944	com/tencent/imcore/message/C2CMessageManager:a	(Ljava/lang/String;IILcom/tencent/imcore/message/RefreshMessageContext;ZJLcom/tencent/mobileqq/data/MessageRecord;Ljava/util/ArrayList;ZLandroid/os/Bundle;JI)V
    //   567: iconst_0
    //   568: ireturn
    //   569: aload 10
    //   571: monitorexit
    //   572: aload_1
    //   573: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	this	C2CMessageManager
    //   0	574	1	paramString	String
    //   0	574	2	paramInt1	int
    //   0	574	3	paramInt2	int
    //   0	574	4	paramRefreshMessageContext	RefreshMessageContext
    //   0	574	5	paramBoolean1	boolean
    //   0	574	6	paramList	List<MessageRecord>
    //   0	574	7	paramLong	long
    //   0	574	9	paramMessageRecord	MessageRecord
    //   0	574	10	paramArrayList	ArrayList<MessageRecord>
    //   0	574	11	paramBoolean2	boolean
    //   22	541	12	i	int
    //   223	36	13	l1	long
    //   103	458	15	l2	long
    //   7	552	17	localBundle	Bundle
    //   155	60	18	localStringBuilder1	StringBuilder
    //   315	3	18	localInterruptedException	java.lang.InterruptedException
    //   466	32	18	localIMessageFacade	IMessageFacade
    //   475	25	19	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   300	308	311	finally
    //   317	322	311	finally
    //   322	325	311	finally
    //   569	572	311	finally
    //   300	308	315	java/lang/InterruptedException
  }
  
  private List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, Math.min(paramLong1, paramLong2), Math.max(paramLong1, paramLong2));
  }
  
  private void b(MessageRecord paramMessageRecord, Map<String, RecentUser> paramMap, String paramString, int paramInt, long paramLong, RecentUser paramRecentUser)
  {
    if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1) && (!paramMessageRecord.frienduin.equals(paramMessageRecord.selfuin)))
    {
      paramRecentUser.setType(UinTypeUtil.a(paramRecentUser.getType()));
      if (paramLong > paramRecentUser.lastmsgtime) {
        paramRecentUser.lastmsgtime = paramLong;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MSG_TYPE_DINGDONG_SCHEDULE_MSG");
      }
      paramMap.put(UinTypeUtil.a(paramString, paramInt), paramRecentUser);
    }
  }
  
  private void c(String paramString, int paramInt)
  {
    if ((1000 == paramInt) || (1004 == paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAIOList(paramString, paramInt);
      if (paramString != null)
      {
        if (paramString.isEmpty()) {
          return;
        }
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((!localMessageRecord.isSend()) && (!MsgProxyUtils.b(localMessageRecord.msgtype))) {
            ((ChatMessage)paramString.get(0)).mNeedGrayTips = true;
          }
        }
      }
    }
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.time;
  }
  
  C2CMessageManager.FindBaseMsgResult a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    C2CMessageManager.FindBaseMsgResult localFindBaseMsgResult = new C2CMessageManager.FindBaseMsgResult(null);
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int j = 0;
    Object localObject;
    while (j < i)
    {
      localObject = (MessageRecord)paramList.get(j);
      if (((MessageRecord)localObject).uniseq == paramLong1)
      {
        C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult, (MessageRecord)localObject);
        C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult, j);
        break;
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshC2CMessageListHead cacheIndex:");
      ((StringBuilder)localObject).append(C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult));
      ((StringBuilder)localObject).append(", itemList:");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    if (C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult) == null)
    {
      if (a(localFindBaseMsgResult, paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramBoolean, paramLong1, paramLong2, paramArrayList)) {
        return localFindBaseMsgResult;
      }
    }
    else {
      a(localFindBaseMsgResult, paramString, paramInt1, paramInt2, paramLong3, paramList, paramArrayList);
    }
    C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult, false);
    return localFindBaseMsgResult;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext)
  {
    Object localObject1 = a(paramInt1).d(paramString, paramInt1);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if ((jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a()) && (localObject1 != null)) {
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("current Aio", ((List)localObject1).subList(0, Math.min(paramInt2, ((List)localObject1).size())));
      }
      long l1 = ((MessageRecord)((List)localObject1).get(0)).uniseq;
      long l2 = a(paramString);
      Object localObject4 = a(paramInt1).b(paramString, paramInt1);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("NavigateRefreshMessageListHead isLocalOnly=");
      ((StringBuilder)localObject3).append(paramRefreshMessageContext.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject3).append(",uniseq=");
      ((StringBuilder)localObject3).append(l1);
      ((StringBuilder)localObject3).append(",ect=");
      ((StringBuilder)localObject3).append(l2);
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(" ,getC2CRoamingSetting");
      ((StringBuilder)localObject5).append(jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime));
      ((IMessageFacade)localObject2).qLogColor((String)localObject3, ((StringBuilder)localObject5).toString());
      if (jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime) == 0) {
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
      }
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if (((MessageRecord)localObject2).uniseq == l1)
        {
          while (i < ((List)localObject1).size())
          {
            localObject2 = localObject1;
            if (UinTypeUtil.c(((MessageRecord)((List)localObject2).get(i)).msgtype))
            {
              l1 = ((MessageRecord)((List)localObject2).get(i)).uniseq;
              bool = true;
              break label387;
            }
            i += 1;
            localObject1 = localObject2;
          }
          bool = false;
          label387:
          localObject3 = localObject1;
          break label410;
        }
        i += 1;
      }
      boolean bool = false;
      localObject3 = localObject1;
      label410:
      localObject1 = localObject4;
      if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramC2CReplyContext, l1, l2, localArrayList, bool)) {
        return localArrayList;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = localObject1;
        localObject4 = (MessageRecord)((List)localObject2).get(i);
        if (((MessageRecord)localObject4).uniseq == l1)
        {
          localObject2 = localObject4;
          break label509;
        }
        i += 1;
        localObject1 = localObject2;
      }
      i = 0;
      localObject2 = null;
      label509:
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("NavigateRefreshMessageListHead cacheIndex:");
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append(", itemList:");
        ((StringBuilder)localObject4).append(((List)localObject1).size());
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject4).toString());
      }
      if (localObject2 == null)
      {
        localObject1 = this;
        localObject2 = ((C2CMessageManager)localObject1).a(paramInt1).a(paramString, paramInt1, l1);
        if (localObject2 == null)
        {
          ((C2CMessageManager)localObject1).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.qLogColor("refresh from empty C2C msg", "");
          paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
          paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
          paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = new ArrayList();
          return paramRefreshMessageContext.jdField_a_of_type_JavaUtilList;
        }
        long l3 = ((MessageRecord)localObject2).time;
        localObject4 = ((C2CMessageManager)localObject1).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("NavigateRefreshMessageListHead uniseq=");
        ((StringBuilder)localObject5).append(l1);
        ((StringBuilder)localObject5).append(", aioBase.getId():");
        ((StringBuilder)localObject5).append(((MessageRecord)localObject2).getId());
        ((IMessageFacade)localObject4).qLogColor(((StringBuilder)localObject5).toString(), "");
        localArrayList.addAll(((C2CMessageManager)localObject1).a(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject2).getId()) })));
        localObject4 = ((C2CMessageManager)localObject1).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("NavigateRefreshMessageListHead Db fromTime:");
        ((StringBuilder)localObject5).append(l3);
        ((IMessageFacade)localObject4).qLogColor(((StringBuilder)localObject5).toString(), "");
        ((C2CMessageManager)localObject1).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("only load in db", localArrayList);
        l1 = l3;
        localObject1 = localObject2;
      }
      else
      {
        l1 = a(paramString, paramInt1, paramInt2, l2, (List)localObject1, (MessageRecord)localObject2, i, localArrayList);
        localObject1 = localObject2;
      }
      bool = true;
      localObject2 = this;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("NavigateRefreshMessageListHead locallist size ");
        ((StringBuilder)localObject4).append(localArrayList.size());
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject4).toString());
      }
      if (l2 > l1)
      {
        l1 = Math.min(l1, paramRefreshMessageContext.jdField_a_of_type_Long);
        localObject4 = ((C2CMessageManager)localObject2).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("ect > fromTime!! newEct:");
        ((StringBuilder)localObject5).append(l1);
        ((IMessageFacade)localObject4).qLogColor(((StringBuilder)localObject5).toString(), "");
        bool = false;
      }
      else
      {
        l1 = l2;
      }
      localObject4 = paramRefreshMessageContext;
      ((C2CMessageManager)localObject2).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("before pull locallist", localArrayList);
      localObject5 = ((C2CMessageManager)localObject2).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("before pull locallist");
      localStringBuilder.append(localArrayList.size());
      ((IMessageFacade)localObject5).qLogColor(localStringBuilder.toString(), "");
      if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, (List)localObject3, l1, (MessageRecord)localObject1, localArrayList, bool)) {
        return ((RefreshMessageContext)localObject4).jdField_a_of_type_JavaUtilList;
      }
      ((C2CMessageManager)localObject2).a(localArrayList);
      ((C2CMessageManager)localObject2).a(localArrayList, paramC2CReplyContext);
      ((C2CMessageManager)localObject2).a(paramInt1).a(paramString, paramInt1, localArrayList);
      ((RefreshMessageContext)localObject4).jdField_a_of_type_JavaUtilList = localArrayList;
      if (((RefreshMessageContext)localObject4).jdField_a_of_type_Boolean) {
        c(paramString, paramInt1);
      }
      paramString = ((C2CMessageManager)localObject2).jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      paramRefreshMessageContext = new StringBuilder();
      paramRefreshMessageContext.append("refresh C2C finish , context = ");
      paramRefreshMessageContext.append(localObject4);
      paramRefreshMessageContext.append(" , size = ");
      paramRefreshMessageContext.append(localArrayList.size());
      paramRefreshMessageContext = paramRefreshMessageContext.toString();
      paramC2CReplyContext = new StringBuilder();
      paramC2CReplyContext.append(", timestamp = ");
      paramC2CReplyContext.append(System.currentTimeMillis());
      paramString.qLogColor(paramRefreshMessageContext, paramC2CReplyContext.toString());
      if ((UinTypeUtil.a(localArrayList)) && (((RefreshMessageContext)localObject4).jdField_c_of_type_Int < 3))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh C2C finish, now rePull sticker msg! ");
          paramString.append(((RefreshMessageContext)localObject4).jdField_c_of_type_Int);
          QLog.i("Q.msg.BaseMessageManager", 2, paramString.toString());
        }
        ((C2CMessageManager)localObject2).a((RefreshMessageContext)localObject4, paramInt1);
      }
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead ERROR: AIO is closed !!");
    }
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
    a(paramRefreshMessageContext, paramInt1);
    return paramRefreshMessageContext.jdField_a_of_type_JavaUtilList;
  }
  
  List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt).b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time >= paramLong1) && (localMessageRecord.time <= paramLong2)) {
          break;
        }
        localArrayList.add(localMessageRecord);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTempListFromDB fromCache=");
        ((StringBuilder)localObject).append(localArrayList.size());
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    paramString = a(paramInt).a(paramString, paramInt, paramLong2, -1, String.format("time>=%d or time=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTempListFromDB from=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",to=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",size=");
      ((StringBuilder)localObject).append(paramString.size());
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    paramString = UinTypeUtil.a(localArrayList, paramString).iterator();
    while (paramString.hasNext()) {
      MsgProxyUtils.b(localArrayList, (MessageRecord)paramString.next(), false);
    }
    return localArrayList;
  }
  
  protected Map<String, List<MessageRecord>> a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.a();
  }
  
  protected void a(RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    List localList = a(paramInt).d(str, paramInt);
    if ((paramRefreshMessageContext.jdField_c_of_type_Int < 3) && (UinTypeUtil.a(localList)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
      }
      paramRefreshMessageContext.jdField_c_of_type_Int += 1;
      b(str, paramInt, 15, paramRefreshMessageContext);
      return;
    }
    super.a(paramRefreshMessageContext, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ThreadManager.post(new C2CMessageManager.2(this, paramMessageRecord), 8, null, true);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    RecentUserProxy localRecentUserProxy = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    Object localObject1 = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    Object localObject2 = paramMessageRecord.frienduin;
    String str = paramMessageRecord.senderuin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    a(paramMessageRecord, (IConversationFacade)localObject1, i);
    if (a(paramMessageRecord, i)) {
      return;
    }
    localObject2 = new C2CMessageManager.MsgBoxAppender(this, paramMessageRecord, paramEntityManager, localMap, localRecentUserProxy, (IConversationFacade)localObject1, (String)localObject2, i, l).a();
    localObject1 = ((C2CMessageManager.MsgBoxAppender)localObject2).a();
    int j = ((C2CMessageManager.MsgBoxAppender)localObject2).a();
    l = ((C2CMessageManager.MsgBoxAppender)localObject2).a();
    i = paramMessageRecord.istroop;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRegistry().i().iterator();
    boolean bool = false;
    int k;
    while (((Iterator)localObject2).hasNext())
    {
      boolean[] arrayOfBoolean = ((IC2CAddMessageHandler)((Iterator)localObject2).next()).a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, paramMessageRecord, paramEntityManager, localRecentUserProxy, (String)localObject1, i, bool, j);
      k = arrayOfBoolean[0];
      if (arrayOfBoolean[1] != 0) {
        break;
      }
    }
    i = a(paramMessageRecord, paramAddMessageContext, localMap, localRecentUserProxy, (String)localObject1, str, j, l, i, k);
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this, paramMessageRecord);
    if (i == 1036) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(null);
    }
    super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
    if ((TempMsgBoxManagerProxy.a((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord.frienduin, paramMessageRecord.istroop)) && (!paramMessageRecord.isSend())) {
      TempMsgBoxManagerProxy.a((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, false);
    }
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    MessageRecord localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.frienduin = paramString1;
    if (TextUtils.equals(AppConstants.LBS_HELLO_UIN, paramString1)) {
      paramMessageRecord.saveExtInfoToExtStr("msg_in_box", "msg_in_box");
    }
    if (UinTypeUtil.a(paramMessageRecord.istroop) == 1032) {
      localMessageRecord.istroop = 1032;
    } else {
      localMessageRecord.istroop = paramMessageRecord.istroop;
    }
    if (!MsgProxyUtils.b(paramMessageRecord.msgtype))
    {
      a(paramMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin, localMessageRecord.getExtraKey());
      a(localMessageRecord, null, false, true, 1);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in SubThread!");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in MainThread!");
    }
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.b(this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord);
    super.a(paramMessageRecord, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList)
  {
    a(paramString, paramInt1, paramLong, paramInt2, paramRefreshMessageContext, paramArrayList, true);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    MessageRecord localMessageRecord1 = a(paramInt1).a(paramString, paramInt1, paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadFromLocal uniseq=");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(",count=");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", fromtime=");
    if (localMessageRecord1 == null) {
      paramLong = -1L;
    } else {
      paramLong = localMessageRecord1.time;
    }
    ((StringBuilder)localObject2).append(paramLong);
    ((IMessageFacade)localObject1).qLogColor(((StringBuilder)localObject2).toString(), "");
    if (localMessageRecord1 != null)
    {
      long l2 = localMessageRecord1.time;
      paramLong = localMessageRecord1.getId();
      localObject1 = a(paramInt1).b(paramString, paramInt1);
      localObject2 = new ArrayList();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)((Iterator)localObject1).next();
          if ((localMessageRecord2.time > l2) || (MsgProxyUtils.a(localMessageRecord1, localMessageRecord2, true))) {
            break;
          }
          ((List)localObject2).add(localMessageRecord2);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("loadFromLocal load from Cache", (Collection)localObject2);
      }
      if ((paramArrayList.size() < paramInt2) && (((List)localObject2).size() > 0))
      {
        paramArrayList.addAll(0, ((List)localObject2).subList(Math.max(((List)localObject2).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject2).size()));
        if (paramArrayList.size() > 0)
        {
          l1 = Math.min(l2, ((MessageRecord)paramArrayList.get(0)).time);
          l2 = Math.max(Math.min(paramLong, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          paramLong = l1;
          l1 = l2;
          l2 = paramLong;
          break label362;
        }
      }
      long l1 = paramLong;
      label362:
      if (paramArrayList.size() < paramInt2)
      {
        paramString = a(paramInt1).a(paramString, paramInt1, l1, localMessageRecord1.versionCode, l2, paramInt2, String.format(" or (time=%d and _id<%d) ", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryTimedMessageDBUnion list size");
        ((StringBuilder)localObject2).append(paramString.size());
        ((StringBuilder)localObject2).append(", getID=");
        ((StringBuilder)localObject2).append(localMessageRecord1.getId());
        ((IMessageFacade)localObject1).qLogColor(((StringBuilder)localObject2).toString(), "");
        if (paramString.isEmpty())
        {
          paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
        }
        else
        {
          if (paramString.size() < paramInt2) {
            paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("loadFromLocal load from DB", paramString);
          paramArrayList.addAll(0, paramString);
        }
      }
      paramRefreshMessageContext.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
    paramRefreshMessageContext.jdField_c_of_type_Boolean = paramBoolean;
    paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.qLogColor("loadFromLocal complete", "");
  }
  
  public void a(String paramString, int paramInt, RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext, Context paramContext)
  {
    paramRefreshMessageContext.f = false;
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt;
    if ((!paramRefreshMessageContext.i) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().containsKey(UinTypeUtil.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().put(UinTypeUtil.a(paramString, paramInt), Boolean.valueOf(true));
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, paramString, paramInt, paramRefreshMessageContext, paramC2CReplyContext, paramContext);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    boolean bool2 = paramBundle.getBoolean("complete");
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getPullCache().get(Integer.valueOf(paramBundle.getInt("counter")));
    paramBundle.putBoolean("timeout", false);
    long l1 = paramBundle.getLong("baseTime");
    long l2 = paramBundle.getLong("lowTime");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setC2CRoamMessageResult success=");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(",complete=");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(",res_size=");
    int j = -1;
    if (paramList1 == null) {
      paramInt = -1;
    } else {
      paramInt = paramList1.size();
    }
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",baseT=");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(",lowTime=");
    ((StringBuilder)localObject).append(l2);
    paramBundle.qLogColor(((StringBuilder)localObject).toString(), "");
    if (paramList1 == null) {
      paramBundle = new ArrayList();
    } else {
      paramBundle = paramList1;
    }
    if (paramList2 == null) {
      paramList1 = new ArrayList();
    } else {
      paramList1 = paramList2;
    }
    if (bool1)
    {
      paramList2 = a(paramString, paramBundle, l1, l2);
      if ((localList != null) && (!localList.isEmpty()))
      {
        l1 = ((MessageRecord)localList.get(0)).time;
        paramString = new ArrayList();
        paramBundle = localList.iterator();
        while (paramBundle.hasNext())
        {
          localObject = (MessageRecord)paramBundle.next();
          if (((MessageRecord)localObject).time == l1) {
            paramString.add(localObject);
          }
        }
        paramList2 = paramList2.iterator();
        paramInt = 0;
      }
      while (paramList2.hasNext())
      {
        paramBundle = (MessageRecord)paramList2.next();
        localObject = paramString.iterator();
        do
        {
          bool1 = ((Iterator)localObject).hasNext();
          i = 1;
          if (!bool1) {
            break;
          }
        } while (!MsgProxyUtils.a((MessageRecord)((Iterator)localObject).next(), paramBundle, true));
        break label441;
        int i = 0;
        label441:
        if ((localList != null) && (i == 0))
        {
          localList.add(paramInt, paramBundle);
          paramInt += 1;
          paramList1.add(paramBundle);
          continue;
          if (localList != null) {
            localList.addAll(paramList2);
          }
        }
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      paramList1 = new StringBuilder();
      paramList1.append("setC2CRoamMessageResult locallist:");
      if (localList == null) {
        paramInt = j;
      } else {
        paramInt = localList.size();
      }
      paramList1.append(paramInt);
      paramString.qLogColor(paramList1.toString(), "");
    }
    if (localList != null) {
      try
      {
        localList.notify();
        return;
      }
      finally {}
    }
  }
  
  protected boolean a(int paramInt)
  {
    UinType localUinType = UinType.valueOf(paramInt);
    if (localUinType != null) {
      return localUinType.isInvalidUinTypeWhenRefresh();
    }
    return (paramInt != 0) && (paramInt != 1000) && (paramInt != 1004) && (paramInt != 9501) && (paramInt != 1044) && (paramInt != 1045) && (paramInt != 10007) && (paramInt != 10008) && (paramInt != 10009) && (paramInt != 10010);
  }
  
  protected void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext)) {
      return;
    }
    boolean bool1;
    if (paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject1 = a(paramInt1).d(paramString, paramInt1);
    if (a(paramInt1, paramRefreshMessageContext, bool1, (List)localObject1)) {
      return;
    }
    if ((jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a()) && (localObject1 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("current Aio", ((List)localObject1).subList(0, Math.min(paramInt2, ((List)localObject1).size())));
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      l1 = ((MessageRecord)((List)localObject1).get(0)).uniseq;
    } else {
      l1 = 0L;
    }
    long l2 = a(paramString);
    long l3 = a(bool1, l2);
    Object localObject2 = a(paramInt1).b(paramString, paramInt1);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("refreshC2CMessageListHead isLocalOnly=");
    ((StringBuilder)localObject4).append(paramRefreshMessageContext.jdField_c_of_type_Boolean);
    ((StringBuilder)localObject4).append(",uniseq=");
    ((StringBuilder)localObject4).append(l1);
    ((StringBuilder)localObject4).append(",ect=");
    ((StringBuilder)localObject4).append(l2);
    ((StringBuilder)localObject4).append(", possibleBreakTime=");
    ((StringBuilder)localObject4).append(l3);
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ,getC2CRoamingSetting");
    localStringBuilder.append(jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime));
    ((IMessageFacade)localObject3).qLogColor((String)localObject4, localStringBuilder.toString());
    if (jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime) == 0) {
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
    }
    localObject3 = new TopMsgSeqFinder((List)localObject1, l1).a();
    long l1 = ((TopMsgSeqFinder)localObject3).a();
    if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, l1, l3, localArrayList, ((TopMsgSeqFinder)localObject3).a())) {
      return;
    }
    localObject3 = a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, l1, l2, l3, (List)localObject2, localArrayList);
    if (((C2CMessageManager.FindBaseMsgResult)localObject3).a()) {
      return;
    }
    localObject2 = ((C2CMessageManager.FindBaseMsgResult)localObject3).a();
    l1 = ((C2CMessageManager.FindBaseMsgResult)localObject3).a();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("refreshC2CMessageListHead locallist size ");
      ((StringBuilder)localObject3).append(localArrayList.size());
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject3).toString());
    }
    boolean bool2;
    if (l2 > l1)
    {
      l1 = Math.min(l1, paramRefreshMessageContext.jdField_a_of_type_Long);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("ect > fromTime!! newEct:");
      ((StringBuilder)localObject4).append(l1);
      ((IMessageFacade)localObject3).qLogColor(((StringBuilder)localObject4).toString(), "");
      bool2 = false;
    }
    else
    {
      l1 = l2;
      bool2 = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.dumpmsgs("before pull locallist", localArrayList);
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("before pull locallist");
    ((StringBuilder)localObject4).append(localArrayList.size());
    ((IMessageFacade)localObject3).qLogColor(((StringBuilder)localObject4).toString(), "");
    a(localArrayList, "before pull localList");
    if ((l1 > 0L) && (localArrayList.size() < paramInt2))
    {
      if (!a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, (List)localObject1, l1, (MessageRecord)localObject2, localArrayList, bool2)) {}
    }
    else
    {
      localObject1 = localArrayList;
      if ((bool1) && (((ArrayList)localObject1).size() < paramInt2)) {
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, (ArrayList)localObject1, (MessageRecord)localObject2, l1);
      }
    }
    a(localArrayList);
    a(paramInt1).a(paramString, paramInt1, localArrayList);
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localArrayList;
    if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
      c(paramString, paramInt1);
    }
    a(localArrayList, "after pull localList");
    paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refresh C2C finish , context = ");
    ((StringBuilder)localObject1).append(paramRefreshMessageContext);
    ((StringBuilder)localObject1).append(" , size = ");
    ((StringBuilder)localObject1).append(localArrayList.size());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(", timestamp = ");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    paramString.qLogColor((String)localObject1, ((StringBuilder)localObject2).toString());
    if ((UinTypeUtil.a(localArrayList)) && (paramRefreshMessageContext.jdField_c_of_type_Int < 3))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("refresh C2C finish, now rePull sticker msg! ");
        paramString.append(paramRefreshMessageContext.jdField_c_of_type_Int);
        QLog.i("Q.msg.BaseMessageManager", 2, paramString.toString());
      }
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getCachedMsg().remove(AppConstants.LBS_HELLO_UIN);
    String str1 = AppConstants.LBS_HELLO_UIN;
    Iterator localIterator = a(1001).a(str1, 1001).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (!jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$Callback.c(localMessageRecord))
      {
        BaseMsgProxy localBaseMsgProxy = a(localMessageRecord.istroop);
        String str2 = AppConstants.LBS_HELLO_UIN;
        int i = localMessageRecord.istroop;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localMessageRecord.senderuin);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMessageRecord.selfuin);
        localStringBuilder.append("");
        localBaseMsgProxy.a(str2, i, (String)localObject, localStringBuilder.toString(), localMessageRecord.getExtraKey());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.calculateNearbyBoxUnreadCount(str1, 1001);
  }
  
  public void e(MessageRecord paramMessageRecord)
  {
    ThreadManager.post(new C2CMessageManager.1(this, paramMessageRecord), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager
 * JD-Core Version:    0.7.0.1
 */