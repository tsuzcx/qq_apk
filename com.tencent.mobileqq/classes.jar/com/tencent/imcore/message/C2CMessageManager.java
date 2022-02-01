package com.tencent.imcore.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class C2CMessageManager
  extends BaseMessageManager
{
  public C2CMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, MsgPool paramMsgPool)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramMsgPool);
  }
  
  private int a(MessageRecord paramMessageRecord, BaseMessageManager.AddMessageContext paramAddMessageContext, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    RecentUser localRecentUser = a(paramMap, paramRecentUserProxy, paramString1, paramInt1, paramInt2, paramBoolean);
    if ((MsgProxyUtils.b(paramMessageRecord.msgtype)) || ((paramInt1 == 1008) && (!c(paramString1)))) {}
    do
    {
      do
      {
        return paramInt1;
      } while (QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord));
      if (paramString1.equals(AppConstants.NEARBY_LBS_HELLO_UIN))
      {
        QLog.i("Q.msg.BaseMessageManager.NEARBY_MSG", 2, "mr.senderUin = " + paramMessageRecord.senderuin);
        return paramInt1;
      }
      if ((paramInt1 == 1009) && (paramString1.equals(AppConstants.SAME_STATE_BOX_UIN)))
      {
        a(paramRecentUserProxy, paramLong, localRecentUser);
        return paramInt1;
      }
      if ((paramInt1 == 1032) && (paramString1.equals(AppConstants.CONFESS_UIN)))
      {
        a(paramMessageRecord, paramRecentUserProxy, paramLong, localRecentUser);
        return paramInt1;
      }
      if (b(paramMessageRecord, paramString1, paramInt1))
      {
        a(paramMessageRecord, paramAddMessageContext, paramString1, paramInt1);
        return paramInt1;
      }
      if (a(paramMessageRecord, paramString1, paramInt1))
      {
        b(paramMessageRecord, paramAddMessageContext, paramString1, paramInt1);
        return paramInt1;
      }
      if (paramMessageRecord.msgtype == -1034)
      {
        a(paramMap, paramRecentUserProxy, paramString1, paramInt1, paramLong, localRecentUser);
        return paramInt1;
      }
      if ((paramMessageRecord.msgtype == -5010) && (paramMessageRecord.isSend()))
      {
        b(paramMessageRecord, paramMap, paramString1, paramInt1, paramLong, localRecentUser);
        return paramInt1;
      }
      if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (paramMessageRecord.isSend()))
      {
        a(paramMessageRecord, paramMap, paramString1, paramInt1, paramLong, localRecentUser);
        return paramInt1;
      }
      if ((paramMessageRecord.frienduin.equals(AppConstants.MAYKNOW_RECOMMEND_UIN)) && (paramMessageRecord.istroop == 0))
      {
        a(paramMap, paramString1, paramInt1, paramLong, localRecentUser, "add recentUserCache MAYKNOW_RECOMMEND_UIN");
        return paramInt1;
      }
      if ((paramMessageRecord.frienduin.equals(AppConstants.FRIEND_ANNIVER_UIN)) && (paramMessageRecord.istroop == 0))
      {
        a(paramMap, paramString1, paramInt1, paramLong, localRecentUser, "add recentUserCache FRIEND_ANNIVER_UIN");
        return paramInt1;
      }
      if ((paramMessageRecord.frienduin.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) && (paramMessageRecord.istroop == 0))
      {
        a(paramMap, paramString1, paramInt1, paramLong, localRecentUser, "add recentUserCache FRIEND_SYSTEM_MSG_UIN");
        return paramInt1;
      }
    } while (a(paramInt1, paramMessageRecord, paramString1));
    return a(paramMessageRecord, paramMap, paramString1, paramString2, paramInt1, paramLong, localRecentUser);
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
    else
    {
      if (!RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {
        break label151;
      }
      paramRecentUser.setType(0);
      paramRecentUser.troopUin = "";
      i = 0;
    }
    for (;;)
    {
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
      label151:
      i = paramInt;
      if (!TextUtils.equals(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
      {
        i = paramInt;
        if (!TextUtils.equals(paramString2, paramString1))
        {
          paramRecentUser.troopUin = paramString2;
          i = paramInt;
        }
      }
    }
  }
  
  private long a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramString);
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
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("all in cache", paramArrayList);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead fromTime:" + l);
      }
      return l;
      paramMessageRecord = (MessageRecord)paramList.get(0);
      paramList = paramList.subList(0, paramInt3).iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.time >= paramLong) {
          paramArrayList.add(localMessageRecord);
        }
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("cache part", paramArrayList);
      paramInt2 -= paramArrayList.size();
      paramArrayList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramMessageRecord.time, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramMessageRecord.time), Long.valueOf(paramMessageRecord.getId()) })));
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("cache + db", paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead memdb:size:" + paramArrayList.size() + ",miss:" + paramInt2);
      }
    }
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
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time, paramMessageRecord.senderuin, paramMessageRecord.msg);
  }
  
  private RecentUser a(Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != 1032) {}
    for (paramRecentUserProxy = paramRecentUserProxy.a(paramString, paramInt2);; paramRecentUserProxy = paramRecentUserProxy.a(paramString, paramInt1))
    {
      if (paramBoolean) {
        paramRecentUserProxy.lFlag = 16L;
      }
      paramString = paramRecentUserProxy;
      if (paramMap.containsKey(UinTypeUtil.a(paramRecentUserProxy.uin, paramRecentUserProxy.getType()))) {
        paramString = (RecentUser)paramMap.get(UinTypeUtil.a(paramRecentUserProxy.uin, paramRecentUserProxy.getType()));
      }
      return paramString;
    }
  }
  
  private ArrayList<MessageRecord> a(String paramString, List<MessageRecord> paramList1, List<MessageRecord> paramList2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("C2CMsgFilter basetime=" + paramLong1 + ",lowtime=" + paramLong2, "");
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return localArrayList;
    }
    Object localObject1 = paramList1.iterator();
    long l2 = 9223372036854775807L;
    long l1 = -1L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (l2 < ((MessageRecord)localObject2).time) {
        break label359;
      }
      l2 = ((MessageRecord)localObject2).time;
    }
    label359:
    for (;;)
    {
      if (l1 <= ((MessageRecord)localObject2).time) {
        l1 = ((MessageRecord)localObject2).time;
      }
      for (;;)
      {
        break;
        localObject2 = b(paramString, 0, l2 - 30L, l1 + 30L);
        if (paramList2 == null) {}
        for (localObject1 = null;; localObject1 = new ArrayList())
        {
          MessageRecord localMessageRecord1 = MessageRecordFactory.a(-1000);
          MessageRecord localMessageRecord2 = MessageRecordFactory.a(-1000);
          a(paramList1, paramLong1, localArrayList, (List)localObject2, (List)localObject1, localMessageRecord1, localMessageRecord2);
          if ((paramLong1 <= 0L) || (localObject1 == null)) {
            break;
          }
          localMessageRecord1.time = paramLong2;
          localMessageRecord2.time = paramLong1;
          paramString = b(paramString, 0, paramLong2, paramLong1).iterator();
          while (paramString.hasNext())
          {
            paramList1 = (MessageRecord)paramString.next();
            if ((!UinTypeUtil.c(paramList1.msgtype)) && (paramList1.time <= paramLong1))
            {
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("addmsg ptt = " + paramList1.getId(), "");
              MsgProxyUtils.b((List)localObject1, paramList1, true);
            }
          }
        }
        if (paramList2 != null) {
          paramList2.addAll((Collection)localObject1);
        }
        return localArrayList;
      }
    }
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
  
  private List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext)
  {
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).d(paramString, paramInt1);
    Object localObject1;
    if ((localList1 == null) || (localList1.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      localObject1 = paramRefreshMessageContext.jdField_a_of_type_JavaUtilList;
      return localObject1;
    }
    if (localList1 != null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("current Aio", localList1.subList(0, Math.min(paramInt2, localList1.size())));
    }
    long l1 = ((MessageRecord)localList1.get(0)).uniseq;
    long l2 = a(paramString);
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
    Object localObject2 = null;
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("NavigateRefreshMessageListHead isLocalOnly=" + paramRefreshMessageContext.jdField_c_of_type_Boolean + ",uniseq=" + l1 + ",ect=" + l2, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 0) {
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
    }
    int i = 0;
    label286:
    boolean bool;
    if (i < localList1.size()) {
      if (((MessageRecord)localList1.get(i)).uniseq == l1)
      {
        if (i >= localList1.size()) {
          break label1115;
        }
        if (UinTypeUtil.c(((MessageRecord)localList1.get(i)).msgtype))
        {
          l1 = ((MessageRecord)localList1.get(i)).uniseq;
          bool = true;
        }
      }
    }
    for (;;)
    {
      localObject1 = localArrayList;
      if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramC2CReplyContext, l1, l2, localArrayList, bool)) {
        break;
      }
      i = 0;
      int j;
      for (;;)
      {
        localObject1 = localObject2;
        j = k;
        if (i < localList2.size())
        {
          localObject1 = (MessageRecord)localList2.get(i);
          if (((MessageRecord)localObject1).uniseq == l1) {
            j = i;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead cacheIndex:" + j + ", itemList:" + localList2.size());
          }
          if (localObject1 != null) {
            break label880;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1);
          if (localObject1 != null) {
            break label562;
          }
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refresh from empty C2C msg", "");
          paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
          paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
          paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = new ArrayList();
          return paramRefreshMessageContext.jdField_a_of_type_JavaUtilList;
          i += 1;
          break label286;
          i += 1;
          break;
        }
        i += 1;
      }
      label562:
      long l3 = ((MessageRecord)localObject1).time;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("NavigateRefreshMessageListHead uniseq=" + l1 + ", aioBase.getId():" + ((MessageRecord)localObject1).getId(), "");
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject1).getId()) })));
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("NavigateRefreshMessageListHead Db fromTime:" + l3, "");
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("only load in db", localArrayList);
      l1 = l3;
      label718:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead locallist size " + localArrayList.size());
      }
      if (l2 > l1)
      {
        l1 = Math.min(l1, paramRefreshMessageContext.jdField_a_of_type_Long);
        bool = false;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("ect > fromTime!! newEct:" + l1, "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("before pull locallist", localArrayList);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("before pull locallist" + localArrayList.size(), "");
        if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, localList1, l1, (MessageRecord)localObject1, localArrayList, bool))
        {
          return paramRefreshMessageContext.jdField_a_of_type_JavaUtilList;
          label880:
          l1 = a(paramString, paramInt1, paramInt2, l2, localList2, (MessageRecord)localObject1, j, localArrayList);
          break label718;
        }
        a(localArrayList);
        a(localArrayList, paramC2CReplyContext);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, localArrayList);
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localArrayList;
        if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
          c(paramString, paramInt1);
        }
        paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
        paramC2CReplyContext = new StringBuilder().append("refresh C2C finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
        if (localArrayList == null) {}
        for (paramInt2 = -1;; paramInt2 = localArrayList.size())
        {
          paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
          localObject1 = localArrayList;
          if (!UinTypeUtil.a(localArrayList)) {
            break;
          }
          localObject1 = localArrayList;
          if (paramRefreshMessageContext.jdField_c_of_type_Int >= 3) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramRefreshMessageContext.jdField_c_of_type_Int);
          }
          a(paramRefreshMessageContext, paramInt1);
          return localArrayList;
        }
        bool = true;
        l1 = l2;
      }
      label1115:
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private List<MessageRecord> a(String paramString, List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString, paramList, localArrayList, paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("needSave", paramString);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("msgInDB", localArrayList);
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((MessageRecord)paramString.get(0)).istroop).a(paramString, null);
    }
    paramList = paramString.iterator();
    label428:
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MessageRecord localMessageRecord;
      if (((MessageRecord)localObject).getId() < 0L)
      {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refresh C2C insert db error ! , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq + ", mr.uid=" + ((MessageRecord)localObject).msgUid, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
        localMessageRecord = a((MessageRecord)localObject);
        if (localMessageRecord == null) {
          localArrayList.remove(localObject);
        }
      }
      for (;;)
      {
        if ((!(localObject instanceof MessageForShortVideo)) || (((MessageForShortVideo)localObject).redBagType != LocalMediaInfo.REDBAG_TYPE_GET)) {
          break label428;
        }
        localObject = (MessageForShortVideo)localObject;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject).shortVideoId, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).redBagStat);
        break;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refresh C2C insert db error ! , m.seq = " + localMessageRecord.shmsgseq + " , mr.uniseq = " + localMessageRecord.uniseq + ", m.uid=" + localMessageRecord.msgUid, "");
        localArrayList.set(localArrayList.indexOf(localObject), localMessageRecord);
        continue;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refresh C2C roam step 3 , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
      }
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("setC2CRoamMessageResult needsave=" + paramString.size(), "");
    return localArrayList;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
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
    return localArrayList;
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
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("all in cache", paramArrayList);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead fromTime:" + C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult));
      }
      return;
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.get(0);
      paramList = paramList.subList(0, C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult)).iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord2 = (MessageRecord)paramList.next();
        if (localMessageRecord2.time >= paramLong) {
          paramArrayList.add(localMessageRecord2);
        }
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("cache part", paramArrayList);
      paramInt2 -= paramArrayList.size();
      paramArrayList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, localMessageRecord1.time, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong), Long.valueOf(localMessageRecord1.time), Long.valueOf(localMessageRecord1.getId()) })));
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("cache + db", paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead memdb:size:" + paramArrayList.size() + ",miss:" + paramInt2);
      }
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
  
  private void a(MessageRecord paramMessageRecord, ConversationFacade paramConversationFacade, int paramInt)
  {
    String str;
    if ((paramInt != 3000) && (paramInt != 1) && (paramInt != 7000))
    {
      str = paramMessageRecord.frienduin;
      if (!String.valueOf(AppConstants.LBS_HELLO_UIN).equals(str)) {
        break label494;
      }
      str = paramMessageRecord.senderuin;
    }
    label232:
    label494:
    for (;;)
    {
      if ((paramInt == 1001) && (!paramMessageRecord.isSend()) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)))
      {
        if (UinTypeUtil.a(paramMessageRecord)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8E", "0X8005C8E", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if ((UinTypeUtil.a(paramInt) != 1009) && (paramConversationFacade.a(str, 1009)))
        {
          paramConversationFacade.a(AppConstants.SAME_STATE_BOX_UIN, 1009, str, paramMessageRecord.istroop);
          a(AppConstants.SAME_STATE_BOX_UIN, 1009, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((UinTypeUtil.a(paramInt) != 1001) && (paramConversationFacade.a(str, 1001)))
        {
          paramConversationFacade.a(AppConstants.LBS_HELLO_UIN, 1001, str, paramMessageRecord.istroop);
          if (!paramConversationFacade.a(str, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN)) {
            break label450;
          }
          a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((UinTypeUtil.a(paramInt) != 1010) && (paramConversationFacade.a(str, 1010)))
        {
          paramConversationFacade.a(AppConstants.DATE_UIN, 1010, str, paramMessageRecord.istroop);
          if (!paramConversationFacade.a(str, 1010, AppConstants.DATE_SAY_HELLO_LIST_UIN)) {
            break label472;
          }
          a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
      for (;;)
      {
        if ((UinTypeUtil.a(paramInt) != 1044) && (paramConversationFacade.a(str, 1044)) && (paramConversationFacade.a(str, 1044, AppConstants.MATCH_CHAT_UIN))) {
          a(AppConstants.MATCH_CHAT_UIN, 1044, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((UinTypeUtil.a(paramInt) != 10008) && (paramConversationFacade.a(str, 10008)) && (paramConversationFacade.a(str, 10008, AppConstants.QCIRCLE_CHAT_UIN))) {
          a(AppConstants.QCIRCLE_CHAT_UIN, 10008, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8F", "0X8005C8F", 0, 0, "", "", "", "");
        break;
        a(AppConstants.LBS_HELLO_UIN, 1001, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        break label232;
        a(AppConstants.DATE_UIN, 1010, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, RecentUserProxy paramRecentUserProxy, long paramLong, RecentUser paramRecentUser)
  {
    if ((paramLong > paramRecentUser.lastmsgtime) && (ConfessMsgUtil.b(paramMessageRecord))) {
      paramRecentUser.lastmsgtime = paramLong;
    }
    paramRecentUser.setType(UinTypeUtil.a(paramRecentUser.getType()));
    paramRecentUserProxy.b(paramRecentUser);
  }
  
  private void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt)
  {
    Object localObject = PublicAccountAdUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, false);
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString)))
    {
      AdvertisementRecentUserManager.a().a(((AdvertisementItem)localObject).jdField_a_of_type_JavaLangString);
      AdvertisementRecentUserManager.a().a((AdvertisementItem)localObject);
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString);
      if (((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b != null) {
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b);
      }
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
      paramMessageRecord = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
      if (paramMessageRecord != null) {
        paramMessageRecord = paramMessageRecord.iterator();
      }
    }
    else
    {
      while (paramMessageRecord.hasNext())
      {
        localObject = (MessageRecord)paramMessageRecord.next();
        paramEntityManager.remove((Entity)localObject);
        RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject).senderuin, ((MessageRecord)localObject).istroop);
        RecentUser localRecentUser = paramRecentUserProxy.a(paramString, paramInt);
        if (localRecentUser != null)
        {
          RecentDataListManager.a().a(paramString + "-" + paramInt);
          paramRecentUserProxy.a(localRecentUser);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageRecord)localObject).senderuin, 1008, true, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "isAdMessage:recent_list_advertisement_message change 0");
        }
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
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
  
  private void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i = paramArrayList.size();
    IRoamMsgFetcher localIRoamMsgFetcher = paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher;
    if ((localIRoamMsgFetcher != null) && (!localIRoamMsgFetcher.a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, paramMessageRecord, paramLong)))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("get roam msg failed", "");
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
      if (!paramArrayList.isEmpty()) {
        break label102;
      }
      if (paramMessageRecord != null) {
        break label92;
      }
      paramLong = 0L;
    }
    for (;;)
    {
      a(paramString, paramInt1, paramLong, paramInt2 - i, paramRefreshMessageContext, paramArrayList, false);
      return;
      label92:
      paramLong = paramMessageRecord.uniseq;
      continue;
      label102:
      paramLong = ((MessageRecord)paramArrayList.get(0)).uniseq;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, long paramLong1, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2, Bundle paramBundle, long paramLong2, int paramInt3)
  {
    if (!paramBundle.getBoolean("timeout"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + paramArrayList.size());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong2, paramArrayList);
      boolean bool1 = paramBundle.getBoolean("success");
      boolean bool2 = paramBundle.getBoolean("complete");
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool1 + ", complete?" + bool2);
      }
      if ((!paramBoolean1) && ((!bool1) || (bool2)))
      {
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        if (!paramArrayList.isEmpty()) {
          break label295;
        }
        if (!paramArrayList.isEmpty()) {
          break label312;
        }
      }
      label295:
      label312:
      for (paramInt3 = paramInt2;; paramInt3 = paramInt2 - paramArrayList.size())
      {
        a(paramString, paramInt1, paramLong2, paramInt3, paramRefreshMessageContext, paramArrayList);
        if (!paramBoolean2)
        {
          paramRefreshMessageContext.jdField_a_of_type_Long = paramBundle.getLong("tempEct");
          paramRefreshMessageContext.b = paramBundle.getLong("tempRandom");
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("update tempEct:" + paramRefreshMessageContext.jdField_a_of_type_Long + ", rand=" + paramRefreshMessageContext.b, "");
        }
        if ((paramBoolean1) && (paramArrayList.size() < paramInt2) && (bool2)) {
          a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, paramMessageRecord, paramLong1);
        }
        return;
        paramLong2 = ((MessageRecord)paramArrayList.get(0)).uniseq;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("pull timeout", "");
    paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
    if (paramArrayList.isEmpty()) {}
    for (;;)
    {
      a(paramString, paramInt1, paramLong2, paramInt3, paramRefreshMessageContext, paramArrayList);
      return;
      paramLong2 = ((MessageRecord)paramArrayList.get(0)).uniseq;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, C2CMessageManager.C2CReplyContext paramC2CReplyContext)
  {
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord;
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
      } while ((MsgProxyUtils.b(localMessageRecord)) || (localMessageRecord.msgUid != paramC2CReplyContext.jdField_a_of_type_Long) || (localMessageRecord.time != paramC2CReplyContext.b));
    }
    for (int i = paramArrayList.indexOf(localMessageRecord);; i = -1)
    {
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
      return;
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
        if (MsgProxyUtils.a(localMessageRecord2, localMessageRecord1, true))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord2.getLogColorContent() + ",uniseq=" + localMessageRecord2.uniseq);
          }
          localArrayList.add(localMessageRecord1);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord2.getLogColorContent() + ",mr=" + localMessageRecord1.getLogColorContent());
        }
      }
      i -= 1;
    }
    paramArrayList1.removeAll(localArrayList);
  }
  
  private void a(List<MessageRecord> paramList1, long paramLong, ArrayList<MessageRecord> paramArrayList, List<MessageRecord> paramList2, List<MessageRecord> paramList3, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramList1 = paramList1.iterator();
    label436:
    for (;;)
    {
      MessageRecord localMessageRecord;
      boolean bool;
      if (paramList1.hasNext())
      {
        localMessageRecord = (MessageRecord)paramList1.next();
        localMessageRecord.time -= 30L;
        localMessageRecord.time += 30L;
        Object localObject1 = a(paramList2, paramMessageRecord1.time, paramMessageRecord2.time);
        if ((paramList2 == null) || (paramList2.size() == 0))
        {
          paramArrayList.add(localMessageRecord);
          if (paramList3 != null) {
            paramList3.add(localMessageRecord);
          }
        }
        else
        {
          Object localObject2 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (MessageRecord)((Iterator)localObject2).next();
              if (MsgProxyUtils.a((MessageRecord)localObject1, localMessageRecord, true)) {
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder().append("C2CMsgFilter shmsgseq equals?");
                  if (localMessageRecord.shmsgseq == ((MessageRecord)localObject1).shmsgseq)
                  {
                    bool = true;
                    label194:
                    QLog.i("Q.msg.BaseMessageManager", 2, bool + ",msg=" + localMessageRecord.getLogColorContent() + "time:" + localMessageRecord.time + "<->" + ((MessageRecord)localObject1).time + ", type=" + ((MessageRecord)localObject1).msgtype + "-" + localMessageRecord.msgtype);
                  }
                }
                else if ((paramList3 != null) && (paramLong != -1L) && (((MessageRecord)localObject1).time <= paramLong))
                {
                  paramList3.add(localObject1);
                }
              }
            }
          }
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label436;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "C2CMsgFilter not eq: msg=" + localMessageRecord.getLogColorContent() + "time:" + localMessageRecord.time + ",type:" + localMessageRecord.msgtype + ",msg.con : " + localMessageRecord.getLogColorContent());
          }
          if (paramList3 != null) {
            paramList3.add(localMessageRecord);
          }
          paramArrayList.add(localMessageRecord);
          break;
          bool = false;
          break label194;
          return;
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache uin " + paramString);
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
    paramRecentUser.displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131694478);
    if (paramLong > paramRecentUser.lastmsgtime) {
      paramRecentUser.lastmsgtime = paramLong;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, paramString2);
    }
    paramMap.put(UinTypeUtil.a(paramString1, paramInt), paramRecentUser);
  }
  
  private boolean a(int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, List<MessageRecord> paramList)
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
    if ((paramMessageRecord.isLongMsg()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramMessageRecord))) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
      }
    }
    while ((LimitChatUtil.b(paramMessageRecord)) || ((paramInt == 1044) && (paramString.equals(AppConstants.MATCH_CHAT_UIN))) || (TextUtils.equals(paramMessageRecord.senderuin, AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN)) || ((paramInt == 10008) && (paramString.equals(AppConstants.QCIRCLE_CHAT_UIN)))) {
      return true;
    }
    return false;
  }
  
  private boolean a(C2CMessageManager.FindBaseMsgResult paramFindBaseMsgResult, String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList)
  {
    C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong1));
    if (C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult) == null)
    {
      if (paramBoolean)
      {
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, null, 0L);
        a(paramArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramArrayList);
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = paramArrayList;
        if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
          c(paramString, paramInt1);
        }
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refresh C2C finish , context = " + paramRefreshMessageContext + " , size = " + paramArrayList.size(), ", timestamp = " + System.currentTimeMillis());
        if ((UinTypeUtil.a(paramArrayList)) && (paramRefreshMessageContext.jdField_c_of_type_Int < 3))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramRefreshMessageContext.jdField_c_of_type_Int);
          }
          a(paramRefreshMessageContext, paramInt1);
        }
      }
      for (;;)
      {
        C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult, true);
        return true;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
        continue;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refresh from empty C2C msg", "");
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
      }
    }
    C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult, C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult).time);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refreshC2CMessageListHead uniseq=" + paramLong1 + ", aioBase.getId():" + C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult).getId(), "");
    paramArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult), paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong2), Long.valueOf(C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult)), Long.valueOf(C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult).getId()) })));
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refreshC2CMessageListHead Db fromTime:" + C2CMessageManager.FindBaseMsgResult.a(paramFindBaseMsgResult), "");
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("only load in db", paramArrayList);
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    SharedPreferences.Editor localEditor;
    if (paramInt == 1008)
    {
      bool1 = bool2;
      if (PAWeatherItemBuilder.a(paramMessageRecord.frienduin))
      {
        localEditor = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
        if (!(paramMessageRecord instanceof MessageForPubAccount)) {
          break label54;
        }
        bool1 = true;
      }
    }
    return bool1;
    label54:
    if ((paramMessageRecord instanceof MessageForText))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_push", 0, 0, "", "", "", "");
      localEditor.putLong("pa_list_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
    }
    for (;;)
    {
      localEditor.commit();
      return false;
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        paramMessageRecord = (MessageForArkApp)paramMessageRecord;
        localEditor.putBoolean("show_flag", true);
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.ark_app_message.metaList).optJSONObject("weather");
          if ((paramMessageRecord != null) && (paramMessageRecord.has("info")))
          {
            JSONObject localJSONObject = paramMessageRecord.optJSONObject("info");
            Object localObject = localJSONObject.optJSONObject("it1");
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("city");
              String str2 = ((JSONObject)localObject).optString("temp");
              localObject = ((JSONObject)localObject).optString("type");
              if (!TextUtils.isEmpty(str1)) {
                localEditor.putString("cur_city", str1.split("-")[0]);
              }
              if (!TextUtils.isEmpty(str2)) {
                localEditor.putString("cur_temp", str2);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                localEditor.putString("cur_code", (String)localObject);
              }
              localEditor.putLong("pa_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), System.currentTimeMillis());
              if (0L != paramMessageRecord.optLong("ts")) {
                localEditor.putLong("pa_time_stamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localJSONObject.optLong("ts"));
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "parse ark msg city: " + str1 + ", temp: " + str2 + ", code: " + (String)localObject + ", ts: " + localJSONObject.optLong("ts"));
              }
            }
          }
        }
        catch (Exception paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (!PublicAccountAdUtil.a(paramMessageRecord)) && (("2".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))) || (ServiceAccountFolderManager.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)));
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (a(paramInt1))
    {
      if (paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIMessageRefresher != null)
      {
        paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIMessageRefresher.a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead TYPE ERROR! TYPE = " + paramInt1);
      }
      paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    if ((paramRefreshMessageContext.jdField_c_of_type_Boolean) || (paramLong2 == 0L) || (!paramBoolean))
    {
      a(paramString, paramInt1, paramLong1, paramInt2, paramRefreshMessageContext, paramArrayList);
      a(paramArrayList, paramC2CReplyContext);
      a(paramArrayList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramArrayList);
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = paramArrayList;
      if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
        c(paramString, paramInt1);
      }
      if ((UinTypeUtil.a(paramArrayList)) && (paramRefreshMessageContext.jdField_c_of_type_Int < 3))
      {
        a(paramRefreshMessageContext, paramInt1);
        return true;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    Bundle localBundle;
    int i;
    long l1;
    if (paramArrayList.size() < paramInt2)
    {
      localBundle = new Bundle();
      i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      localBundle.putInt("counter", i);
      localBundle.putBoolean("timeout", true);
      localBundle.putLong("UIN", Long.valueOf(paramString).longValue());
      localBundle.putBoolean("canUpdateEct", paramBoolean);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), paramArrayList);
      paramList = a(paramList, paramMessageRecord);
      l1 = paramMessageRecord.uniseq;
      i = paramArrayList.size();
      if (paramArrayList.isEmpty()) {
        i = paramInt2;
      }
      for (;;)
      {
        localBundle.putLong("baseTime", paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + paramLong + ",timeFilterList:" + paramList.size());
        }
        long l2 = 0L;
        if (!paramBoolean) {
          l2 = paramRefreshMessageContext.b;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString, paramLong, (short)i, localBundle, l2);
        localBundle.putInt("size_req", i);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(UinTypeUtil.a(paramString, paramInt1), Boolean.valueOf(false));
        try
        {
          paramArrayList.wait(35000L);
          if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(UinTypeUtil.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(UinTypeUtil.a(paramString, paramInt1))).booleanValue()))
          {
            paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
            return true;
            i = paramInt2 - i;
          }
        }
        catch (InterruptedException paramMessageRecord)
        {
          for (;;)
          {
            paramMessageRecord.printStackTrace();
          }
        }
        finally {}
      }
      if ((localBundle.getBoolean("timeout")) && (QLog.isColorLevel())) {
        QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("after pull locallist" + paramArrayList.size(), "");
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("after pull locallist", paramArrayList);
      a(paramArrayList, paramList);
      if (localBundle.getBoolean("timeout")) {
        break label742;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + paramArrayList.size());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1, paramArrayList);
      boolean bool1 = localBundle.getBoolean("success");
      boolean bool2 = localBundle.getBoolean("complete");
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool1 + ", complete?" + bool2);
      }
      if ((!bool1) || (bool2))
      {
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        if (!paramArrayList.isEmpty()) {
          break label714;
        }
        if (!paramArrayList.isEmpty()) {
          break label731;
        }
      }
    }
    for (;;)
    {
      a(paramString, paramInt1, l1, paramInt2, paramRefreshMessageContext, paramArrayList);
      if (!paramBoolean)
      {
        paramRefreshMessageContext.jdField_a_of_type_Long = localBundle.getLong("tempEct");
        paramRefreshMessageContext.b = localBundle.getLong("tempRandom");
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("update tempEct:" + paramRefreshMessageContext.jdField_a_of_type_Long + ", rand=" + paramRefreshMessageContext.b, "");
      }
      return false;
      label714:
      l1 = ((MessageRecord)paramArrayList.get(0)).uniseq;
      break;
      label731:
      paramInt2 -= paramArrayList.size();
    }
    label742:
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("pull timeout", "");
    paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
    if (paramArrayList.isEmpty()) {}
    for (;;)
    {
      a(paramString, paramInt1, l1, i, paramRefreshMessageContext, paramArrayList);
      break;
      l1 = ((MessageRecord)paramArrayList.get(0)).uniseq;
    }
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2)
  {
    if ((paramRefreshMessageContext.jdField_c_of_type_Boolean) || (paramLong2 == 0L) || ((!paramBoolean2) && (!paramBoolean1)))
    {
      a(paramString, paramInt1, paramLong1, paramInt2, paramRefreshMessageContext, paramArrayList);
      a(paramArrayList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramArrayList);
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = paramArrayList;
      if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
        c(paramString, paramInt1);
      }
      paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
      StringBuilder localStringBuilder = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramRefreshMessageContext).append(", size = ");
      if (paramArrayList == null)
      {
        paramInt2 = -1;
        paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
        if ((!UinTypeUtil.a(paramArrayList)) || (paramRefreshMessageContext.jdField_c_of_type_Int >= 3)) {
          break label188;
        }
        a(paramRefreshMessageContext, paramInt1);
      }
      for (;;)
      {
        return true;
        paramInt2 = paramArrayList.size();
        break;
        label188:
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
      }
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    int i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    localBundle.putInt("counter", i);
    localBundle.putBoolean("timeout", true);
    localBundle.putLong("UIN", Long.valueOf(paramString).longValue());
    localBundle.putBoolean("canUpdateEct", paramBoolean2);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), paramArrayList);
    paramList = a(paramList, paramMessageRecord);
    long l2 = paramMessageRecord.uniseq;
    i = paramArrayList.size();
    if (paramArrayList.isEmpty()) {
      i = paramInt2;
    }
    for (;;)
    {
      localBundle.putLong("baseTime", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + paramLong + ",timeFilterList:" + paramList.size());
      }
      long l1 = 0L;
      if (!paramBoolean2) {
        l1 = paramRefreshMessageContext.b;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString, paramLong, (short)i, localBundle, l1);
      localBundle.putInt("size_req", i);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(UinTypeUtil.a(paramString, paramInt1), Boolean.valueOf(false));
      try
      {
        paramArrayList.wait(35000L);
        if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(UinTypeUtil.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(UinTypeUtil.a(paramString, paramInt1))).booleanValue()))
        {
          paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
          return true;
          i = paramInt2 - i;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    if ((localBundle.getBoolean("timeout")) && (QLog.isColorLevel())) {
      QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("after pull locallist" + paramArrayList.size(), "");
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("after pull locallist", paramArrayList);
    a(paramArrayList, paramList);
    a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramBoolean1, paramLong, paramMessageRecord, paramArrayList, paramBoolean2, localBundle, l2, i);
    return false;
  }
  
  private List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, Math.min(paramLong1, paramLong2), Math.max(paramLong1, paramLong2));
  }
  
  private void b(MessageRecord paramMessageRecord, BaseMessageManager.AddMessageContext paramAddMessageContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "ecshop new msg puin: " + paramMessageRecord.senderuin + ", inter_num: " + paramMessageRecord.getExtInfoFromExtStr("inter_num"));
    }
    paramString = UinTypeUtil.a(paramString, paramInt);
    if (paramAddMessageContext.g.containsKey(paramString))
    {
      ((List)paramAddMessageContext.g.get(paramString)).add(paramMessageRecord);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageRecord);
    paramAddMessageContext.g.put(paramString, localArrayList);
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
  
  private boolean b(MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (!PublicAccountAdUtil.a(paramMessageRecord)) && ((TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt)) || ("1".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))));
  }
  
  private void c(String paramString, int paramInt)
  {
    if ((1000 == paramInt) || (1004 == paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt);
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label41;
      }
    }
    label41:
    ChatMessage localChatMessage;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramString.iterator();
      }
      localChatMessage = (ChatMessage)localIterator.next();
    } while ((localChatMessage.isSend()) || (MsgProxyUtils.b(localChatMessage.msgtype)));
    ((ChatMessage)paramString.get(0)).mNeedGrayTips = true;
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    int j;
    if (((paramMessageRecord instanceof MessageForVideo)) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
      j = -1;
    }
    try
    {
      localObject = paramMessageRecord.msg.split("\\|");
      i = j;
      if (localObject != null)
      {
        i = j;
        if (localObject.length >= 2) {
          i = Integer.valueOf(localObject[1]).intValue();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i = -1;
        continue;
        localException.a((MessageForVideo)paramMessageRecord, false);
      }
    }
    localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (i == 6)
    {
      ((QCallFacade)localObject).a((MessageForVideo)paramMessageRecord, true);
      ((QCallFacade)localObject).a((MessageForVideo)paramMessageRecord);
      return;
    }
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.time;
  }
  
  C2CMessageManager.FindBaseMsgResult a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    C2CMessageManager.FindBaseMsgResult localFindBaseMsgResult = new C2CMessageManager.FindBaseMsgResult(null);
    int i;
    int j;
    if (paramList == null)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j < i)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(j);
        if (localMessageRecord.uniseq == paramLong1)
        {
          C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult, localMessageRecord);
          C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult, j);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead cacheIndex:" + C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult) + ", itemList:" + paramList);
        }
        if (C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult) != null) {
          break label170;
        }
        if (!a(localFindBaseMsgResult, paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramBoolean, paramLong1, paramLong2, paramArrayList)) {
          break label185;
        }
        return localFindBaseMsgResult;
        i = paramList.size();
        break;
      }
      j += 1;
    }
    label170:
    a(localFindBaseMsgResult, paramString, paramInt1, paramInt2, paramLong3, paramList, paramArrayList);
    label185:
    C2CMessageManager.FindBaseMsgResult.a(localFindBaseMsgResult, false);
    return localFindBaseMsgResult;
  }
  
  List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time < paramLong1) || (localMessageRecord.time > paramLong2)) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB fromCache=" + localArrayList.size());
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt, paramLong2, -1, String.format("time>=%d or time=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB from=" + paramLong1 + ",to=" + paramLong2 + ",size=" + paramString.size());
        }
        paramString = UinTypeUtil.a(localArrayList, paramString).iterator();
        while (paramString.hasNext()) {
          MsgProxyUtils.b(localArrayList, (MessageRecord)paramString.next(), false);
        }
      }
      localArrayList.add(localMessageRecord);
    }
    return localArrayList;
  }
  
  protected Map<String, List<MessageRecord>> a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.a();
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).d(str, paramInt);
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
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {}
    Map localMap;
    RecentUserProxy localRecentUserProxy;
    String str1;
    do
    {
      return;
      localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
      localRecentUserProxy = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
      localObject = paramAddMessageContext.jdField_a_of_type_ComTencentImcoreMessageConversationFacade;
      if (paramMessageRecord.time == 0L) {
        paramMessageRecord.time = MessageCache.a();
      }
      if (paramMessageRecord.msgseq == 0L) {
        paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
      }
      str2 = paramMessageRecord.frienduin;
      str1 = paramMessageRecord.senderuin;
      i = paramMessageRecord.istroop;
      l = paramMessageRecord.time;
      a(paramMessageRecord, (ConversationFacade)localObject, i);
      TempMsgBoxManager localTempMsgBoxManager = (TempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
      if (localTempMsgBoxManager.b(paramMessageRecord.frienduin, paramMessageRecord.istroop)) {
        localTempMsgBoxManager.a(false);
      }
    } while (a(paramMessageRecord, i));
    Object localObject = new C2CMessageManager.MsgBoxAppender(this, paramMessageRecord, paramEntityManager, localMap, localRecentUserProxy, (ConversationFacade)localObject, str2, i, l).a();
    String str2 = ((C2CMessageManager.MsgBoxAppender)localObject).a();
    int i = ((C2CMessageManager.MsgBoxAppender)localObject).a();
    long l = ((C2CMessageManager.MsgBoxAppender)localObject).a();
    e(paramMessageRecord);
    int j = paramMessageRecord.istroop;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1008)
    {
      bool1 = bool2;
      if (PublicAccountAdUtil.a(paramMessageRecord)) {
        bool1 = true;
      }
    }
    if (bool1) {
      a(paramMessageRecord, paramEntityManager, localRecentUserProxy, str2, j);
    }
    for (;;)
    {
      i = a(paramMessageRecord, paramAddMessageContext, localMap, localRecentUserProxy, str2, str1, i, l, j, bool1);
      if ((!paramMessageRecord.isSend()) && (paramMessageRecord.istroop == 0) && (Utils.b(paramMessageRecord.frienduin)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
      {
        bool1 = QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        if (QLog.isColorLevel()) {
          QLog.i("BabyQReportCookie", 2, "now in the aio, isScreenLocked = " + bool1);
        }
        if ((a().containsKey(UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) && (!bool1))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
          if (QLog.isColorLevel()) {
            QLog.i("BabyQReportCookie", 2, "now in the aio!!!");
          }
        }
      }
      if (i == 1036) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(null);
      }
      super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
      paramEntityManager = TeamWorkUtils.ProcessTDFileScheduler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramEntityManager.a(paramMessageRecord);
      paramEntityManager.a();
      return;
      if (i == 10005) {
        ImaxAdVideoPreloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramEntityManager, localRecentUserProxy);
      } else if (IceBreakingUtil.b(i)) {
        IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, i, paramMessageRecord);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in SubThread!");
      }
    }
    for (;;)
    {
      ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).b(paramMessageRecord);
      super.a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in MainThread!");
      }
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList)
  {
    a(paramString, paramInt1, paramLong, paramInt2, paramRefreshMessageContext, paramArrayList, true);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    Object localObject2 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
    label140:
    MessageRecord localMessageRecord2;
    if (localMessageRecord1 == null)
    {
      paramLong = -1L;
      ((QQMessageFacade)localObject1).a(paramLong, "");
      if (localMessageRecord1 == null) {
        break label518;
      }
      long l3 = localMessageRecord1.time;
      long l2 = localMessageRecord1.getId();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord2.time <= l3) && (!MsgProxyUtils.a(localMessageRecord1, localMessageRecord2, true))) {
            break label466;
          }
        }
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("loadFromLocal load from Cache", (Collection)localObject1);
      }
      long l1 = l2;
      paramLong = l3;
      if (paramArrayList.size() < paramInt2)
      {
        l1 = l2;
        paramLong = l3;
        if (((List)localObject1).size() > 0)
        {
          paramArrayList.addAll(0, ((List)localObject1).subList(Math.max(((List)localObject1).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject1).size()));
          l1 = l2;
          paramLong = l3;
          if (paramArrayList.size() > 0)
          {
            paramLong = Math.min(l3, ((MessageRecord)paramArrayList.get(0)).time);
            l1 = Math.max(Math.min(l2, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          }
        }
      }
      if (paramArrayList.size() < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1, localMessageRecord1.versionCode, paramLong, paramInt2, String.format(" or (time=%d and _id<%d) ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("queryTimedMessageDBUnion list size" + paramString.size() + ", getID=" + localMessageRecord1.getId(), "");
        if (!paramString.isEmpty()) {
          break label479;
        }
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      paramRefreshMessageContext.jdField_c_of_type_Boolean = paramBoolean;
      return;
      paramLong = localMessageRecord1.time;
      break;
      label466:
      ((List)localObject1).add(localMessageRecord2);
      break label140;
      label479:
      if (paramString.size() < paramInt2) {
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("loadFromLocal load from DB", paramString);
      paramArrayList.addAll(0, paramString);
    }
    label518:
    paramRefreshMessageContext.jdField_c_of_type_Boolean = paramBoolean;
    paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("loadFromLocal complete", "");
  }
  
  public void a(String paramString, int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext, FragmentActivity paramFragmentActivity)
  {
    paramRefreshMessageContext.f = false;
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt;
    if ((!paramRefreshMessageContext.i) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.containsKey(UinTypeUtil.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.put(UinTypeUtil.a(paramString, paramInt), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new C2CMessageManager.2(this, paramRefreshMessageContext, paramInt, paramString, paramC2CReplyContext, paramFragmentActivity));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    boolean bool2 = paramBundle.getBoolean("complete");
    List localList = (List)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
    paramBundle.putBoolean("timeout", false);
    long l1 = paramBundle.getLong("baseTime");
    long l2 = paramBundle.getLong("lowTime");
    paramBundle = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    Object localObject = new StringBuilder().append("setC2CRoamMessageResult success=").append(bool1).append(",complete=").append(bool2).append(",res_size=");
    if (paramList1 == null)
    {
      paramInt = -1;
      paramBundle.a(paramInt + ",baseT=" + l1 + ",lowTime=" + l2, "");
      if (paramList1 != null) {
        break label526;
      }
    }
    label526:
    for (paramBundle = new ArrayList();; paramBundle = paramList1)
    {
      paramList1 = paramList2;
      if (paramList2 == null) {
        paramList1 = new ArrayList();
      }
      if (bool1)
      {
        paramList2 = a(paramString, paramBundle, l1, l2);
        if ((localList != null) && (!localList.isEmpty()))
        {
          l1 = ((MessageRecord)localList.get(0)).time;
          paramString = new ArrayList();
          paramBundle = localList.iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject = (MessageRecord)paramBundle.next();
              if (((MessageRecord)localObject).time == l1)
              {
                paramString.add(localObject);
                continue;
                paramInt = paramList1.size();
                break;
              }
            }
          }
          paramList2 = paramList2.iterator();
          paramInt = 0;
          if (!paramList2.hasNext()) {
            break label446;
          }
          paramBundle = (MessageRecord)paramList2.next();
          localObject = paramString.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!MsgProxyUtils.a((MessageRecord)((Iterator)localObject).next(), paramBundle, true));
        }
      }
      for (int j = 1;; j = 0)
      {
        int i = paramInt;
        if (localList != null)
        {
          i = paramInt;
          if (j == 0)
          {
            localList.add(paramInt, paramBundle);
            i = paramInt + 1;
            paramList1.add(paramBundle);
          }
        }
        paramInt = i;
        break;
        if (localList != null) {
          localList.addAll(paramList2);
        }
        label446:
        paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
        paramList1 = new StringBuilder().append("setC2CRoamMessageResult locallist:");
        if (localList == null) {}
        for (paramInt = -1;; paramInt = localList.size())
        {
          paramString.a(paramInt, "");
          if (localList != null) {}
          try
          {
            localList.notify();
            return;
          }
          finally {}
        }
      }
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
    if (paramInt == 1038)
    {
      paramString = (AppletsHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
      if (paramString != null) {
        paramString.b();
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext)) {}
    boolean bool1;
    Object localObject1;
    label105:
    long l2;
    Object localObject2;
    ArrayList localArrayList;
    do
    {
      long l3;
      do
      {
        do
        {
          return;
          if (paramRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher == null) {
            break;
          }
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).d(paramString, paramInt1);
        } while (a(paramInt1, paramRefreshMessageContext, bool1, (List)localObject1));
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("current Aio", ((List)localObject1).subList(0, Math.min(paramInt2, ((List)localObject1).size())));
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label701;
        }
        l1 = 0L;
        l2 = a(paramString);
        l3 = a(bool1, l2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
        localArrayList = new ArrayList();
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refreshC2CMessageListHead isLocalOnly=" + paramRefreshMessageContext.jdField_c_of_type_Boolean + ",uniseq=" + l1 + ",ect=" + l2 + ", possibleBreakTime=" + l3, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting());
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 0) {
          paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        }
        localObject3 = new TopMsgSeqFinder((List)localObject1, l1).a();
        l1 = ((TopMsgSeqFinder)localObject3).a();
      } while (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, l1, l3, localArrayList, ((TopMsgSeqFinder)localObject3).a()));
      localObject2 = a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, l1, l2, l3, (List)localObject2, localArrayList);
    } while (((C2CMessageManager.FindBaseMsgResult)localObject2).a());
    Object localObject3 = ((C2CMessageManager.FindBaseMsgResult)localObject2).a();
    long l1 = ((C2CMessageManager.FindBaseMsgResult)localObject2).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead locallist size " + localArrayList.size());
    }
    boolean bool2;
    if (l2 > l1)
    {
      l1 = Math.min(l1, paramRefreshMessageContext.jdField_a_of_type_Long);
      bool2 = false;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("ect > fromTime!! newEct:" + l1, "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("before pull locallist", localArrayList);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("before pull locallist" + localArrayList.size(), "");
      if ((l1 > 0L) && (localArrayList.size() < paramInt2))
      {
        if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, (List)localObject1, l1, (MessageRecord)localObject3, localArrayList, bool2)) {
          break;
        }
        label519:
        a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, localArrayList);
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localArrayList;
        if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
          c(paramString, paramInt1);
        }
        paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
        localObject1 = new StringBuilder().append("refresh C2C finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
        if (localArrayList != null) {
          break label752;
        }
      }
      label701:
      label752:
      for (paramInt2 = -1;; paramInt2 = localArrayList.size())
      {
        paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
        if ((!UinTypeUtil.a(localArrayList)) || (paramRefreshMessageContext.jdField_c_of_type_Int >= 3)) {
          break label761;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramRefreshMessageContext.jdField_c_of_type_Int);
        }
        a(paramRefreshMessageContext, paramInt1);
        return;
        bool1 = false;
        break;
        l1 = ((MessageRecord)((List)localObject1).get(0)).uniseq;
        break label105;
        if ((!bool1) || (localArrayList.size() >= paramInt2)) {
          break label519;
        }
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, localArrayList, (MessageRecord)localObject3, l1);
        break label519;
      }
      label761:
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
      bool2 = true;
      l1 = l2;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().jdField_a_of_type_JavaUtilMap.remove(AppConstants.LBS_HELLO_UIN);
    String str = AppConstants.LBS_HELLO_UIN;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1001).a(str, 1001).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (!MsgBoxUtil.b(localMessageRecord)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(localMessageRecord.istroop).a(AppConstants.LBS_HELLO_UIN, localMessageRecord.istroop, localMessageRecord.senderuin + "", localMessageRecord.selfuin + "", localMessageRecord.getExtraKey());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().e(str, 1001);
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    ThreadManager.post(new C2CMessageManager.1(this, paramMessageRecord), 8, null, true);
  }
  
  protected boolean c(String paramString)
  {
    paramString = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(paramString);
    if (paramString != null) {
      return paramString.isVisible();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager
 * JD-Core Version:    0.7.0.1
 */