package com.tencent.mobileqq.app.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
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
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
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
import org.json.JSONObject;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import zpk;
import zpl;

public class C2CMessageManager
  extends BaseMessageManager
{
  public C2CMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time, paramMessageRecord.senderuin, paramMessageRecord.msg);
  }
  
  private ArrayList a(String paramString, List paramList1, List paramList2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("C2CMsgFilter basetime=" + paramLong1 + ",lowtime=" + paramLong2, "");
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
        break label768;
      }
      l2 = ((MessageRecord)localObject2).time;
    }
    label768:
    for (;;)
    {
      if (l1 <= ((MessageRecord)localObject2).time) {
        l1 = ((MessageRecord)localObject2).time;
      }
      for (;;)
      {
        break;
        localObject2 = b(paramString, 0, l2 - 30L, l1 + 30L);
        MessageRecord localMessageRecord1;
        MessageRecord localMessageRecord2;
        if (paramList2 == null)
        {
          localObject1 = null;
          localMessageRecord1 = MessageRecordFactory.a(-1000);
          localMessageRecord2 = MessageRecordFactory.a(-1000);
          paramList1 = paramList1.iterator();
        }
        label391:
        label763:
        for (;;)
        {
          MessageRecord localMessageRecord3;
          boolean bool;
          if (paramList1.hasNext())
          {
            localMessageRecord3 = (MessageRecord)paramList1.next();
            localMessageRecord3.time -= 30L;
            localMessageRecord3.time += 30L;
            Object localObject3 = a((List)localObject2, localMessageRecord1.time, localMessageRecord2.time);
            if ((localObject2 == null) || (((List)localObject2).size() == 0))
            {
              localArrayList.add(localMessageRecord3);
              if (localObject1 == null) {
                continue;
              }
              ((List)localObject1).add(localMessageRecord3);
              continue;
              localObject1 = new ArrayList();
              break;
            }
            Object localObject4 = ((List)localObject3).iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (MessageRecord)((Iterator)localObject4).next();
                if (MsgProxyUtils.a((MessageRecord)localObject3, localMessageRecord3, true)) {
                  if (QLog.isColorLevel())
                  {
                    localObject4 = new StringBuilder().append("C2CMsgFilter shmsgseq equals?");
                    if (localMessageRecord3.shmsgseq == ((MessageRecord)localObject3).shmsgseq)
                    {
                      bool = true;
                      QLog.i("Q.msg.BaseMessageManager", 2, bool + ",msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + "<->" + ((MessageRecord)localObject3).time + ", type=" + ((MessageRecord)localObject3).msgtype + "-" + localMessageRecord3.msgtype);
                    }
                  }
                  else if ((localObject1 != null) && (paramLong1 != -1L) && (((MessageRecord)localObject3).time <= paramLong1))
                  {
                    ((List)localObject1).add(localObject3);
                  }
                }
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label763;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "C2CMsgFilter not eq: msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + ",type:" + localMessageRecord3.msgtype + ",msg.con : " + localMessageRecord3.getLogColorContent());
            }
            if (localObject1 != null) {
              ((List)localObject1).add(localMessageRecord3);
            }
            localArrayList.add(localMessageRecord3);
            break;
            bool = false;
            break label391;
            if ((paramLong1 > 0L) && (localObject1 != null))
            {
              localMessageRecord1.time = paramLong2;
              localMessageRecord2.time = paramLong1;
              paramString = b(paramString, 0, paramLong2, paramLong1).iterator();
              while (paramString.hasNext())
              {
                paramList1 = (MessageRecord)paramString.next();
                if ((!MsgProxyUtils.f(paramList1.msgtype)) && (paramList1.time <= paramLong1))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("addmsg ptt = " + paramList1.getId(), "");
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
    }
  }
  
  private List a(String paramString, List paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString, paramList, localArrayList, paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("needSave", paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("msgInDB", localArrayList);
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)paramString.get(0)).istroop).a(paramString, null);
    }
    paramList = paramString.iterator();
    label418:
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MessageRecord localMessageRecord;
      if (((MessageRecord)localObject).getId() < 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C insert db error ! , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq + ", mr.uid=" + ((MessageRecord)localObject).msgUid, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
        localMessageRecord = a((MessageRecord)localObject);
        if (localMessageRecord == null) {
          localArrayList.remove(localObject);
        }
      }
      for (;;)
      {
        if ((!(localObject instanceof MessageForShortVideo)) || (((MessageForShortVideo)localObject).redBagType != LocalMediaInfo.REDBAG_TYPE_GET)) {
          break label418;
        }
        localObject = (MessageForShortVideo)localObject;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject).shortVideoId, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).redBagStat);
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C insert db error ! , m.seq = " + localMessageRecord.shmsgseq + " , mr.uniseq = " + localMessageRecord.uniseq + ", m.uid=" + localMessageRecord.msgUid, "");
        localArrayList.set(localArrayList.indexOf(localObject), localMessageRecord);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C roam step 3 , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("setC2CRoamMessageResult needsave=" + paramString.size(), "");
    return localArrayList;
  }
  
  private List a(List paramList, long paramLong1, long paramLong2)
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
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.frienduin = paramString1;
    if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1032) {}
    for (localMessageRecord.istroop = 1032;; localMessageRecord.istroop = paramMessageRecord.istroop)
    {
      if (!MsgProxyUtils.g(paramMessageRecord.msgtype))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin, localMessageRecord.getExtraKey());
        a(localMessageRecord, null, false, true, 1);
      }
      return;
    }
  }
  
  private List b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, Math.min(paramLong1, paramLong2), Math.max(paramLong1, paramLong2));
  }
  
  private void b(String paramString, int paramInt)
  {
    if ((1000 == paramInt) || (1004 == paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
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
    } while ((localChatMessage.isSend()) || (MsgProxyUtils.g(localChatMessage.msgtype)));
    ((ChatMessage)paramString.get(0)).mNeedGrayTips = true;
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.time;
  }
  
  List a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
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
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramLong2, -1, String.format("time>=%d or time=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB from=" + paramLong1 + ",to=" + paramLong2 + ",size=" + paramString.size());
        }
        paramString = MsgProxyUtils.a(localArrayList, paramString).iterator();
        while (paramString.hasNext()) {
          MsgProxyUtils.b(localArrayList, (MessageRecord)paramString.next(), false);
        }
      }
      localArrayList.add(localMessageRecord);
    }
    return localArrayList;
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(str, paramInt);
    if ((paramRefreshMessageContext.jdField_c_of_type_Int < 3) && (MsgProxyUtils.c(localList)))
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
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    RecentUserProxy localRecentUserProxy = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    Object localObject4 = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    Object localObject1;
    if ((i != 3000) && (i != 1) && (i != 7000))
    {
      localObject1 = paramMessageRecord.frienduin;
      if (!String.valueOf(AppConstants.G).equals(localObject1)) {
        break label4286;
      }
      localObject1 = paramMessageRecord.senderuin;
    }
    label404:
    label1073:
    label2610:
    label4274:
    label4280:
    label4283:
    label4286:
    for (;;)
    {
      if ((i == 1001) && (!paramMessageRecord.isSend()) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)))
      {
        if (MsgProxyUtils.c(paramMessageRecord)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8E", "0X8005C8E", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if ((MsgProxyUtils.a(i) != 1009) && (((ConversationFacade)localObject4).a((String)localObject1, 1009)))
        {
          ((ConversationFacade)localObject4).a(AppConstants.v, 1009, (String)localObject1, paramMessageRecord.istroop);
          a(AppConstants.v, 1009, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((MsgProxyUtils.a(i) != 1001) && (((ConversationFacade)localObject4).a((String)localObject1, 1001)))
        {
          ((ConversationFacade)localObject4).a(AppConstants.G, 1001, (String)localObject1, paramMessageRecord.istroop);
          if (!((ConversationFacade)localObject4).a((String)localObject1, 1001, AppConstants.ae)) {
            break label1073;
          }
          a(AppConstants.ae, 1001, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        label328:
        if ((MsgProxyUtils.a(i) != 1010) && (((ConversationFacade)localObject4).a((String)localObject1, 1010)))
        {
          ((ConversationFacade)localObject4).a(AppConstants.X, 1010, (String)localObject1, paramMessageRecord.istroop);
          if (!((ConversationFacade)localObject4).a((String)localObject1, 1010, AppConstants.af)) {
            break label1095;
          }
          a(AppConstants.af, 1010, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((i == 1008) && (PAWeatherItemBuilder.a(paramMessageRecord.frienduin)))
        {
          localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
          if ((paramMessageRecord instanceof MessageForPubAccount)) {
            break;
          }
          if (!(paramMessageRecord instanceof MessageForText)) {
            break label1117;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_push", 0, 0, "", "", "", "");
          ((SharedPreferences.Editor)localObject1).putLong("pa_list_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject1).commit();
        }
        if (MsgProxyUtils.a(paramMessageRecord.istroop) != 1009) {
          break label1483;
        }
        if ((((ConversationFacade)localObject4).a(str1)) || (localMap.containsKey(MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
          localRecentUserProxy.a(paramMessageRecord.frienduin);
        }
        a(paramMessageRecord, AppConstants.v, paramMessageRecord.frienduin);
        str1 = AppConstants.v;
        i = paramMessageRecord.istroop;
        l = paramMessageRecord.time;
      }
      int k;
      for (;;)
      {
        for (;;)
        {
          if (((paramMessageRecord instanceof MessageForVideo)) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
            k = -1;
          }
          try
          {
            localObject1 = paramMessageRecord.msg.split("\\|");
            j = k;
            if (localObject1 != null)
            {
              j = k;
              if (localObject1.length >= 2) {
                j = Integer.valueOf(localObject1[1]).intValue();
              }
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Object localObject5;
              int j = -1;
              continue;
              localException1.a((MessageForVideo)paramMessageRecord, false);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementRecentUserManager", 2, "isAdMessage:recent_list_advertisement_message change 0");
              }
              paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
              if (i != 1032)
              {
                localObject3 = localRecentUserProxy.a(str1, k);
                if (j != 0) {
                  ((RecentUser)localObject3).lFlag = 16L;
                }
                if (!localMap.containsKey(MsgProxyUtils.a(((RecentUser)localObject3).uin, ((RecentUser)localObject3).type))) {
                  break label4271;
                }
                localObject3 = (RecentUser)localMap.get(MsgProxyUtils.a(((RecentUser)localObject3).uin, ((RecentUser)localObject3).type));
              }
              for (;;)
              {
                if ((MsgProxyUtils.g(paramMessageRecord.msgtype)) || ((i == 1008) && (!a(str1)))) {}
                for (;;)
                {
                  if ((!paramMessageRecord.isSend()) && (paramMessageRecord.istroop == 0) && (Utils.b(paramMessageRecord.frienduin)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
                  {
                    bool = QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
                    if (QLog.isColorLevel()) {
                      QLog.i("BabyQReportCookie", 2, "now in the aio, isScreenLocked = " + bool);
                    }
                    if ((MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) && (!bool))
                    {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
                      if (QLog.isColorLevel()) {
                        QLog.i("BabyQReportCookie", 2, "now in the aio!!!");
                      }
                    }
                  }
                  super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
                  return;
                  if (i != 10005) {
                    break;
                  }
                  ImaxAdVideoPreloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramEntityManager, localRecentUserProxy);
                  break;
                  localObject3 = localRecentUserProxy.a(str1, i);
                  break label2629;
                  if (!QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)) {
                    if ((i == 1009) && (str1.equals(AppConstants.v)))
                    {
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      ((RecentUser)localObject3).type = MsgProxyUtils.a(((RecentUser)localObject3).type);
                      localRecentUserProxy.a((RecentUser)localObject3);
                    }
                    else if ((i == 1032) && (str1.equals(AppConstants.aE)))
                    {
                      if ((l > ((RecentUser)localObject3).lastmsgtime) && (ConfessMsgUtil.b(paramMessageRecord))) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      ((RecentUser)localObject3).type = MsgProxyUtils.a(((RecentUser)localObject3).type);
                      localRecentUserProxy.a((RecentUser)localObject3);
                    }
                    else if ((i == 1008) && (!PublicAccountAdUtil.a(paramMessageRecord)) && ((TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, i)) || ("1".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num")))))
                    {
                      str1 = MsgProxyUtils.a(str1, i);
                      if (paramAddMessageContext.f.containsKey(str1))
                      {
                        ((List)paramAddMessageContext.f.get(str1)).add(paramMessageRecord);
                      }
                      else
                      {
                        localObject3 = new ArrayList();
                        ((List)localObject3).add(paramMessageRecord);
                        paramAddMessageContext.f.put(str1, localObject3);
                      }
                    }
                    else if ((i == 1008) && (!PublicAccountAdUtil.a(paramMessageRecord)) && (("2".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))) || (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1))))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("EcShopAssistantManager", 2, "ecshop new msg puin: " + paramMessageRecord.senderuin + ", inter_num: " + paramMessageRecord.getExtInfoFromExtStr("inter_num"));
                      }
                      str1 = MsgProxyUtils.a(str1, i);
                      if (paramAddMessageContext.g.containsKey(str1))
                      {
                        ((List)paramAddMessageContext.g.get(str1)).add(paramMessageRecord);
                      }
                      else
                      {
                        localObject3 = new ArrayList();
                        ((List)localObject3).add(paramMessageRecord);
                        paramAddMessageContext.g.put(str1, localObject3);
                      }
                    }
                    else if (paramMessageRecord.msgtype == -1034)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache start");
                      }
                      if (localRecentUserProxy.a(str1))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache uin " + str1);
                        }
                        ((RecentUser)localObject3).uin = str1;
                        ((RecentUser)localObject3).type = MsgProxyUtils.a(((RecentUser)localObject3).type);
                        if (l > ((RecentUser)localObject3).lastmsgtime) {
                          ((RecentUser)localObject3).lastmsgtime = l;
                        }
                        localMap.put(MsgProxyUtils.a(str1, i), localObject3);
                      }
                    }
                    else if ((paramMessageRecord.msgtype == -5010) && (paramMessageRecord.isSend()))
                    {
                      if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1) && (!paramMessageRecord.frienduin.equals(paramMessageRecord.selfuin)))
                      {
                        ((RecentUser)localObject3).type = MsgProxyUtils.a(((RecentUser)localObject3).type);
                        if (l > ((RecentUser)localObject3).lastmsgtime) {
                          ((RecentUser)localObject3).lastmsgtime = l;
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MSG_TYPE_DINGDONG_SCHEDULE_MSG");
                        }
                        localMap.put(MsgProxyUtils.a(str1, i), localObject3);
                      }
                    }
                    else if ((paramMessageRecord.isBlessMsg) && (paramMessageRecord.isSend()))
                    {
                      if (paramMessageRecord.needUpdateMsgTag)
                      {
                        ((RecentUser)localObject3).uin = str1;
                        ((RecentUser)localObject3).type = 0;
                        if (l > ((RecentUser)localObject3).lastmsgtime) {
                          ((RecentUser)localObject3).lastmsgtime = l;
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache isBlessMsg");
                        }
                        localMap.put(MsgProxyUtils.a(str1, i), localObject3);
                      }
                    }
                    else if ((paramMessageRecord.frienduin.equals(AppConstants.ap)) && (paramMessageRecord.istroop == 0))
                    {
                      ((RecentUser)localObject3).uin = AppConstants.C;
                      ((RecentUser)localObject3).type = 4000;
                      ((RecentUser)localObject3).displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131433298);
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MAYKNOW_RECOMMEND_UIN");
                      }
                      localMap.put(MsgProxyUtils.a(str1, i), localObject3);
                    }
                    else if ((paramMessageRecord.frienduin.equals(AppConstants.aw)) && (paramMessageRecord.istroop == 0))
                    {
                      ((RecentUser)localObject3).uin = AppConstants.C;
                      ((RecentUser)localObject3).type = 4000;
                      ((RecentUser)localObject3).displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131433298);
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_ANNIVER_UIN");
                      }
                      localMap.put(MsgProxyUtils.a(str1, i), localObject3);
                    }
                    else if ((paramMessageRecord.frienduin.equals(AppConstants.K)) && (paramMessageRecord.istroop == 0))
                    {
                      ((RecentUser)localObject3).uin = AppConstants.C;
                      ((RecentUser)localObject3).type = 4000;
                      ((RecentUser)localObject3).displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131433298);
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_SYSTEM_MSG_UIN");
                      }
                      localMap.put(MsgProxyUtils.a(str1, i), localObject3);
                    }
                    else
                    {
                      if ((!paramMessageRecord.isLongMsg()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord))) {
                        break label4068;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
                      }
                    }
                  }
                }
                ((RecentUser)localObject3).uin = str1;
                if ((i != 1000) && (i != 1020))
                {
                  j = i;
                  if (i != 1004) {}
                }
                else
                {
                  if (!RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1)) {
                    break label4224;
                  }
                  j = 0;
                  ((RecentUser)localObject3).type = 0;
                  ((RecentUser)localObject3).troopUin = "";
                }
                for (;;)
                {
                  ((RecentUser)localObject3).type = MsgProxyUtils.a(((RecentUser)localObject3).type);
                  bool = true;
                  if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
                    bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
                  }
                  if ((l > ((RecentUser)localObject3).lastmsgtime) && (bool)) {
                    ((RecentUser)localObject3).lastmsgtime = l;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache ELSE");
                  }
                  localMap.put(MsgProxyUtils.a(str1, j), localObject3);
                  break;
                  j = i;
                  if (!TextUtils.equals(str2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
                  {
                    j = i;
                    if (!TextUtils.equals(str2, str1))
                    {
                      ((RecentUser)localObject3).troopUin = str2;
                      j = i;
                    }
                  }
                }
              }
              j = 0;
            }
          }
          localObject1 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
          if (j != 6) {
            break label2571;
          }
          ((QCallFacade)localObject1).a((MessageForVideo)paramMessageRecord, true);
          ((QCallFacade)localObject1).a((MessageForVideo)paramMessageRecord);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zpk(this));
          }
          k = paramMessageRecord.istroop;
          if ((i != 1008) || (!PublicAccountAdUtil.a(paramMessageRecord))) {
            break label4274;
          }
          j = 1;
          if (j == 0) {
            break label2884;
          }
          localObject1 = PublicAccountAdUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, false);
          if ((localObject1 == null) || (TextUtils.isEmpty(((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString))) {
            break label2584;
          }
          AdvertisementRecentUserManager.a().a(((AdvertisementItem)localObject1).jdField_a_of_type_JavaLangString);
          AdvertisementRecentUserManager.a().a((AdvertisementItem)localObject1);
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString);
          if (((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b != null) {
            paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b);
          }
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
          localObject1 = paramEntityManager.a(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
          if (localObject1 == null) {
            break label2610;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject1).next();
            paramEntityManager.b((Entity)localObject4);
            RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
            localObject5 = localRecentUserProxy.a(str1, k);
            if (localObject5 != null)
            {
              RecentDataListManager.a().a(str1 + "-" + k);
              localRecentUserProxy.b((RecentUser)localObject5);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).senderuin, 1008, true, true);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8F", "0X8005C8F", 0, 0, "", "", "", "");
          break;
          a(AppConstants.G, 1001, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          break label328;
          label1095:
          a(AppConstants.X, 1010, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          break label404;
          label1117:
          if (!(paramMessageRecord instanceof MessageForArkApp)) {
            break label521;
          }
          localObject5 = (MessageForArkApp)paramMessageRecord;
          ((SharedPreferences.Editor)localObject1).putBoolean("show_flag", true);
          try
          {
            localObject5 = new JSONObject(((MessageForArkApp)localObject5).ark_app_message.metaList).optJSONObject("weather");
            if ((localObject5 == null) || (!((JSONObject)localObject5).has("info"))) {
              break label521;
            }
            JSONObject localJSONObject = ((JSONObject)localObject5).optJSONObject("info");
            Object localObject6 = localJSONObject.optJSONObject("it1");
            if (localObject6 == null) {
              break label521;
            }
            String str3 = ((JSONObject)localObject6).optString("city");
            String str4 = ((JSONObject)localObject6).optString("temp");
            localObject6 = ((JSONObject)localObject6).optString("type");
            if (!TextUtils.isEmpty(str3)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_city", str3.split("-")[0]);
            }
            if (!TextUtils.isEmpty(str4)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_temp", str4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_code", (String)localObject6);
            }
            ((SharedPreferences.Editor)localObject1).putLong("pa_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), System.currentTimeMillis());
            if (0L != ((JSONObject)localObject5).optLong("ts")) {
              ((SharedPreferences.Editor)localObject1).putLong("pa_time_stamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localJSONObject.optLong("ts"));
            }
            if (!QLog.isColorLevel()) {
              break label521;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "parse ark msg city: " + str3 + ", temp: " + str4 + ", code: " + (String)localObject6 + ", ts: " + localJSONObject.optLong("ts"));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        break label521;
        label1483:
        if (String.valueOf(AppConstants.G).equals(paramMessageRecord.frienduin))
        {
          if ((((ConversationFacade)localObject4).a(paramMessageRecord.senderuin)) || (localMap.containsKey(MsgProxyUtils.a(paramMessageRecord.senderuin, paramMessageRecord.istroop)))) {
            localRecentUserProxy.a(paramMessageRecord.senderuin);
          }
          localObject1 = MessageRecordFactory.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
          ((MessageRecord)localObject1).frienduin = ((MessageRecord)localObject1).senderuin;
          ((MessageRecord)localObject1).istroop = 1001;
          if (!MsgProxyUtils.g(paramMessageRecord.msgtype))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject1).istroop).a(AppConstants.G, 1001, paramMessageRecord.senderuin, paramMessageRecord.selfuin, 0);
            a((MessageRecord)localObject1, null, false, true, 1);
          }
          if (MsgProxyUtils.c(paramMessageRecord))
          {
            a(paramMessageRecord, AppConstants.ae, paramMessageRecord.senderuin);
            paramMessageRecord.senderuin = AppConstants.ae;
            if (!paramMessageRecord.isread) {
              ((ConversationFacade)localObject4).a(1001, paramMessageRecord.senderuin);
            }
          }
          for (;;)
          {
            break;
            if (((ConversationFacade)localObject4).a(paramMessageRecord.frienduin, 1001, AppConstants.ae)) {
              a(AppConstants.ae, 1001, paramMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
          }
        }
        if (((MsgProxyUtils.a(paramMessageRecord.istroop) == 1001) && (MsgProxyUtils.a(paramMessageRecord.istroop, paramMessageRecord.msgtype))) || (MsgProxyUtils.a(paramMessageRecord.istroop) == 1010))
        {
          if ((((ConversationFacade)localObject4).a(str1)) || (localMap.containsKey(MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
            localRecentUserProxy.a(paramMessageRecord.frienduin);
          }
          if (MsgProxyUtils.c(paramMessageRecord))
          {
            a(paramMessageRecord, AppConstants.ae, paramMessageRecord.frienduin);
            a(paramMessageRecord, AppConstants.G, AppConstants.ae);
            if (!paramMessageRecord.isread) {
              ((ConversationFacade)localObject4).a(1001, paramMessageRecord.frienduin);
            }
          }
          for (;;)
          {
            if ((!paramMessageRecord.isSend()) && (paramMessageRecord.msgtype == -2025) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
              ((ConversationFacade)localObject4).a(paramMessageRecord.senderuin, paramMessageRecord.msg, 1001, 0);
            }
            str1 = AppConstants.G;
            i = paramMessageRecord.istroop;
            l = paramMessageRecord.time;
            break;
            if (((ConversationFacade)localObject4).a(paramMessageRecord.frienduin, 1001, AppConstants.ae)) {
              a(AppConstants.ae, 1001, paramMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            a(paramMessageRecord, AppConstants.G, paramMessageRecord.frienduin);
          }
        }
        if (!String.valueOf(AppConstants.F).equals(paramMessageRecord.frienduin)) {
          break label2016;
        }
        if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
          break label4280;
        }
        localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject1 != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
        }
        l = paramMessageRecord.time;
      }
      label2016:
      if (String.valueOf(AppConstants.L).equals(paramMessageRecord.frienduin))
      {
        if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
          break label4283;
        }
        localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject1 != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
        }
        l = paramMessageRecord.time;
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        int m = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (m > 0)
        {
          k = 0;
          j = k;
          if (!paramMessageRecord.isSendFromLocal())
          {
            j = k;
            if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject1).time) {
              j = 1;
            }
          }
          if (j == 0)
          {
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
            ((QQMessageFacade.Message)localObject1).msgData = paramMessageRecord.msgData;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b((QQMessageFacade.Message)localObject1);
          }
        }
        for (;;)
        {
          try
          {
            a((QQMessageFacade.Message)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = m;
          }
          catch (Throwable localThrowable1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable1);
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
        }
        Object localObject2;
        if (AppConstants.D.equals(paramMessageRecord.frienduin))
        {
          try
          {
            localObject2 = paramEntityManager.a(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                paramEntityManager.b((MessageRecord)((Iterator)localObject2).next());
              }
            }
          }
          finally {}
          break;
        }
        if ((String.valueOf(AppConstants.ap).equals(paramMessageRecord.frienduin)) || (AppConstants.aw.equals(paramMessageRecord.frienduin)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject4 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
          ((QQMessageFacade.Message)localObject2).istroop = paramMessageRecord.istroop;
          ((NewFriendManager)localObject4).a(false);
          m = ((NewFriendManager)localObject4).d();
          if (m > 0)
          {
            k = 0;
            j = k;
            if (!paramMessageRecord.isSendFromLocal())
            {
              j = k;
              if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject2).time) {
                j = 1;
              }
            }
            if (j == 0)
            {
              MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, paramMessageRecord);
              ((QQMessageFacade.Message)localObject2).msgData = paramMessageRecord.msgData;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b((QQMessageFacade.Message)localObject2);
            }
          }
          for (;;)
          {
            try
            {
              a((QQMessageFacade.Message)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = m;
            }
            catch (Throwable localThrowable2)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable2);
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
          }
        }
        if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1032)
        {
          if (ConfessMsgUtil.b(paramMessageRecord)) {
            a(paramMessageRecord, AppConstants.aE, paramMessageRecord.frienduin);
          }
          str1 = AppConstants.aE;
          l = paramMessageRecord.time;
          i = 1032;
          break;
        }
        Object localObject3;
        label2629:
        boolean bool;
        label2884:
        label4068:
        break;
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
      ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91)).b(paramMessageRecord);
      super.a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in MainThread!");
      }
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.f) }));
    }
    String str = ConfessMsgUtil.a(paramString, paramInt1, paramRefreshMessageContext.f);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l1;
    if (paramLong > 0L)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
      localObject3 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
      if (localObject1 == null)
      {
        paramLong = -1L;
        ((QQMessageFacade)localObject2).a(paramLong, "");
        if (localObject1 == null) {
          break label726;
        }
        l1 = ((MessageRecord)localObject1).time;
        paramLong = ((MessageRecord)localObject1).getId();
      }
    }
    for (;;)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localObject2 = new ArrayList();
      label201:
      MessageRecord localMessageRecord;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
          if (TextUtils.equals(str, ConfessMsgUtil.a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId()))) {
            if ((localMessageRecord.time <= l1) && ((localObject1 == null) || (!MsgProxyUtils.a((MessageRecord)localObject1, localMessageRecord, true)))) {
              break label664;
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from Cache", (Collection)localObject2);
      }
      long l2;
      if ((paramArrayList.size() < paramInt2) && (((List)localObject2).size() > 0))
      {
        paramArrayList.addAll(0, ((List)localObject2).subList(Math.max(((List)localObject2).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject2).size()));
        if (paramArrayList.size() > 0)
        {
          l1 = Math.min(l1, ((MessageRecord)paramArrayList.get(0)).time);
          l2 = Math.max(Math.min(paramLong, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          paramLong = l1;
          l1 = l2;
          l2 = paramLong;
          paramLong = l1;
        }
      }
      for (;;)
      {
        if (paramArrayList.size() < paramInt2)
        {
          int i = ConfessMsgUtil.a(paramInt1, paramRefreshMessageContext.f) << 3;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(String.format(" and (extLong & 4194296)=%d", new Object[] { Integer.valueOf(i) }));
          ((StringBuilder)localObject1).append(String.format(" or (time=%d and _id<%d and (extLong & 4194296)=%d) ", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Integer.valueOf(i) }));
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong, 3, l2, paramInt2, ((StringBuilder)localObject1).toString());
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("queryTimedMessageDBUnion list size" + ((List)localObject1).size() + ", getID=" + paramLong, "");
          if (!((List)localObject1).isEmpty()) {
            break label677;
          }
          paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
        }
        for (;;)
        {
          paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d findCount:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.f), Integer.valueOf(paramArrayList.size()) }));
          }
          return;
          paramLong = ((MessageRecord)localObject1).time;
          break;
          label664:
          ((List)localObject2).add(localMessageRecord);
          break label201;
          label677:
          if (((List)localObject1).size() < paramInt2) {
            paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from DB", (Collection)localObject1);
          paramArrayList.addAll(0, (Collection)localObject1);
        }
        l2 = l1;
      }
      label726:
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
      continue;
      localObject1 = null;
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
    }
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    boolean bool2 = paramBundle.getBoolean("complete");
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
    paramBundle.putBoolean("timeout", false);
    long l1 = paramBundle.getLong("baseTime");
    long l2 = paramBundle.getLong("lowTime");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
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
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
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
  
  protected boolean a(String paramString)
  {
    paramString = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(paramString);
    if (paramString != null) {
      return paramString.isVisible();
    }
    return true;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if ((paramInt1 != 0) && (paramInt1 != 1000) && (paramInt1 != 1004) && (paramInt1 != 9501))
    {
      if (paramInt1 == 1008)
      {
        c(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
        return;
      }
      if ((MsgProxyUtils.a(paramInt1) == 1032) && (paramRefreshMessageContext.f > 0))
      {
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        d(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead TYPE ERROR! TYPE = " + paramInt1);
      }
      paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    if (localObject3 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject3).subList(0, Math.min(paramInt2, ((List)localObject3).size())));
    }
    long l2 = ((MessageRecord)((List)localObject3).get(0)).uniseq;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
    long l1;
    Object localObject4;
    ArrayList localArrayList;
    int i;
    if (localObject1 == null)
    {
      l1 = 0L;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead isLocalOnly=" + paramRefreshMessageContext.jdField_c_of_type_Boolean + ",uniseq=" + l2 + ",ect=" + l1, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 0) {
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
      }
      i = 0;
      label380:
      if (i >= ((List)localObject3).size()) {
        break label2774;
      }
      if (((MessageRecord)((List)localObject3).get(i)).uniseq != l2) {
        break label664;
      }
      label413:
      if (i >= ((List)localObject3).size()) {
        break label2768;
      }
      if (!MsgProxyUtils.f(((MessageRecord)((List)localObject3).get(i)).msgtype)) {
        break label655;
      }
      l2 = ((MessageRecord)((List)localObject3).get(i)).uniseq;
      i = 1;
    }
    for (;;)
    {
      if ((paramRefreshMessageContext.jdField_c_of_type_Boolean) || (l1 == 0L) || (i == 0))
      {
        b(paramString, paramInt1, l2, paramInt2, paramRefreshMessageContext, localArrayList);
        a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList);
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localArrayList;
        if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
          b(paramString, paramInt1);
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
        localObject1 = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramRefreshMessageContext).append(", size = ");
        if (localArrayList == null) {}
        for (paramInt2 = -1;; paramInt2 = localArrayList.size())
        {
          paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
          if ((!MsgProxyUtils.c(localArrayList)) || (paramRefreshMessageContext.jdField_c_of_type_Int >= 3)) {
            break label682;
          }
          a(paramRefreshMessageContext, paramInt1);
          return;
          l1 = ((Long)((Pair)localObject1).first).longValue();
          break;
          label655:
          i += 1;
          break label413;
          label664:
          i += 1;
          break label380;
        }
        label682:
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
        return;
      }
      i = 0;
      if (i < ((List)localObject4).size())
      {
        localObject1 = (MessageRecord)((List)localObject4).get(i);
        if (((MessageRecord)localObject1).uniseq != l2) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead cacheIndex:" + i + ", itemList:" + ((List)localObject4).size());
        }
        long l3;
        if (localObject1 == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2);
          if (localObject1 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh from empty C2C msg", "");
            paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
            paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
            paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = new ArrayList();
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
            return;
            i += 1;
            break;
          }
          l3 = ((MessageRecord)localObject1).time;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead uniseq=" + l2 + ", aioBase.getId():" + ((MessageRecord)localObject1).getId(), "");
          localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject1).getId()) })));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead Db fromTime:" + l3, "");
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("only load in db", localArrayList);
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead locallist size " + localArrayList.size());
          }
          if (l1 <= l2) {
            break label2753;
          }
          l1 = Math.min(l2, paramRefreshMessageContext.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("ect > fromTime!! newEct:" + l1, "");
        }
        label2743:
        label2753:
        for (boolean bool1 = false;; bool1 = true)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist", localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist" + localArrayList.size(), "");
          if (localArrayList.size() < paramInt2)
          {
            localObject4 = new Bundle();
            i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
            ((Bundle)localObject4).putInt("counter", i);
            ((Bundle)localObject4).putBoolean("timeout", true);
            ((Bundle)localObject4).putLong("UIN", Long.valueOf(paramString).longValue());
            ((Bundle)localObject4).putBoolean("canUpdateEct", bool1);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localArrayList);
            Object localObject5 = new ArrayList();
            i = 0;
            Object localObject6;
            while (i < ((List)localObject3).size())
            {
              localObject6 = (MessageRecord)((List)localObject3).get(i);
              if (((MessageRecord)localObject6).time == ((MessageRecord)localObject1).time)
              {
                ((ArrayList)localObject5).add(localObject6);
                i += 1;
                continue;
                l2 = ((MessageRecord)localObject1).time;
                if (i >= paramInt2)
                {
                  j = i - paramInt2;
                  while (j < i)
                  {
                    localObject5 = (MessageRecord)((List)localObject4).get(j);
                    if (((MessageRecord)localObject5).time >= l1) {
                      localArrayList.add(localObject5);
                    }
                    j += 1;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("all in cache", localArrayList);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead fromTime:" + l2);
                  }
                  break;
                  localObject5 = (MessageRecord)((List)localObject4).get(0);
                  localObject4 = ((List)localObject4).subList(0, i).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject6 = (MessageRecord)((Iterator)localObject4).next();
                    if (((MessageRecord)localObject6).time >= l1) {
                      localArrayList.add(localObject6);
                    }
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache part", localArrayList);
                  i = paramInt2 - localArrayList.size();
                  localArrayList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)localObject5).time, i, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(((MessageRecord)localObject5).time), Long.valueOf(((MessageRecord)localObject5).getId()) })));
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache + db", localArrayList);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead memdb:size:" + localArrayList.size() + ",miss:" + i);
                  }
                }
              }
            }
            l2 = ((MessageRecord)localObject1).uniseq;
            i = localArrayList.size();
            if (localArrayList.isEmpty()) {
              i = paramInt2;
            }
            for (;;)
            {
              ((Bundle)localObject4).putLong("baseTime", l1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + l1 + ",timeFilterList:" + ((ArrayList)localObject5).size());
              }
              l3 = 0L;
              if (!bool1) {
                l3 = paramRefreshMessageContext.b;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l1, (short)i, (Bundle)localObject4, l3);
              ((Bundle)localObject4).putInt("size_req", i);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString, paramInt1), Boolean.valueOf(false));
              try
              {
                localArrayList.wait(35000L);
                if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.get(MsgProxyUtils.a(paramString, paramInt1))).booleanValue()))
                {
                  paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
                  return;
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
            if ((((Bundle)localObject4).getBoolean("timeout")) && (QLog.isColorLevel())) {
              QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist" + localArrayList.size(), "");
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist", localArrayList);
            localObject2 = new ArrayList();
            int j = localArrayList.size() - 1;
            while (j >= 0)
            {
              localObject3 = (MessageRecord)localArrayList.get(j);
              localObject6 = ((ArrayList)localObject5).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject6).next();
                if (MsgProxyUtils.a(localMessageRecord, (MessageRecord)localObject3, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord.getLogColorContent() + ",uniseq=" + localMessageRecord.uniseq);
                  }
                  ((ArrayList)localObject2).add(localObject3);
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord.getLogColorContent() + ",mr=" + ((MessageRecord)localObject3).getLogColorContent());
                }
              }
              j -= 1;
            }
            localArrayList.removeAll((Collection)localObject2);
            if (((Bundle)localObject4).getBoolean("timeout")) {
              break label2674;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + localArrayList.size());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, localArrayList);
            boolean bool2 = ((Bundle)localObject4).getBoolean("success");
            boolean bool3 = ((Bundle)localObject4).getBoolean("complete");
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool2 + ", complete?" + bool3);
            }
            if ((!bool2) || (bool3))
            {
              paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
              if (!localArrayList.isEmpty()) {
                break label2646;
              }
              if (!localArrayList.isEmpty()) {
                break label2663;
              }
              label2379:
              b(paramString, paramInt1, l2, paramInt2, paramRefreshMessageContext, localArrayList);
            }
            if (!bool1)
            {
              paramRefreshMessageContext.jdField_a_of_type_Long = ((Bundle)localObject4).getLong("tempEct");
              paramRefreshMessageContext.b = ((Bundle)localObject4).getLong("tempRandom");
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("update tempEct:" + paramRefreshMessageContext.jdField_a_of_type_Long + ", rand=" + paramRefreshMessageContext.b, "");
            }
          }
          a(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList);
          paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localArrayList;
          if (paramRefreshMessageContext.jdField_a_of_type_Boolean) {
            b(paramString, paramInt1);
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
          localObject2 = new StringBuilder().append("refresh C2C finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
          if (localArrayList == null) {}
          for (paramInt2 = -1;; paramInt2 = localArrayList.size())
          {
            paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
            if ((!MsgProxyUtils.c(localArrayList)) || (paramRefreshMessageContext.jdField_c_of_type_Int >= 3)) {
              break label2743;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramRefreshMessageContext.jdField_c_of_type_Int);
            }
            a(paramRefreshMessageContext, paramInt1);
            return;
            label2646:
            l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            break;
            label2663:
            paramInt2 -= localArrayList.size();
            break label2379;
            label2674:
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("pull timeout", "");
            paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
            if (localArrayList.isEmpty()) {}
            for (;;)
            {
              b(paramString, paramInt1, l2, i, paramRefreshMessageContext, localArrayList);
              break;
              l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
          return;
        }
        i = 0;
        Object localObject2 = null;
      }
      label2768:
      i = 0;
      continue;
      label2774:
      i = 0;
    }
  }
  
  public void b(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList paramArrayList)
  {
    MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
    Object localObject2 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
    label140:
    MessageRecord localMessageRecord2;
    if (localMessageRecord1 == null)
    {
      paramLong = -1L;
      ((QQMessageFacade)localObject1).a(paramLong, "");
      if (localMessageRecord1 == null) {
        break label517;
      }
      long l3 = localMessageRecord1.time;
      long l2 = localMessageRecord1.getId();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord2.time <= l3) && (!MsgProxyUtils.a(localMessageRecord1, localMessageRecord2, true))) {
            break label465;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from Cache", (Collection)localObject1);
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
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1, localMessageRecord1.versionCode, paramLong, paramInt2, String.format(" or (time=%d and _id<%d) ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("queryTimedMessageDBUnion list size" + paramString.size() + ", getID=" + localMessageRecord1.getId(), "");
        if (!paramString.isEmpty()) {
          break label478;
        }
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
      return;
      paramLong = localMessageRecord1.time;
      break;
      label465:
      ((List)localObject1).add(localMessageRecord2);
      break label140;
      label478:
      if (paramString.size() < paramInt2) {
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from DB", paramString);
      paramArrayList.addAll(0, paramString);
    }
    label517:
    paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal complete", "");
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    ThreadManager.post(new zpl(this, paramMessageRecord), 8, null, true);
  }
  
  public void c(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
    }
    long l;
    do
    {
      return;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject).subList(0, Math.min(15, ((List)localObject).size())));
      }
      l = ((MessageRecord)((List)localObject).get(0)).uniseq;
      localObject = new ArrayList();
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
    } while (!paramRefreshMessageContext.jdField_c_of_type_Boolean);
    b(paramString, paramInt1, l, paramInt2, paramRefreshMessageContext, (ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, (List)localObject);
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject);
    if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
    {
      if ((paramRefreshMessageContext.jdField_a_of_type_JavaUtilList == null) || (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        l = PublicAccountManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(paramString, l, 1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X8005C99", "0X8005C99", 0, 1, 0, "new", "2", "", "");
        return;
      }
      paramRefreshMessageContext.jdField_a_of_type_Boolean = false;
      paramRefreshMessageContext.g = false;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
    StringBuilder localStringBuilder = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramRefreshMessageContext).append(", size = ");
    if (localObject == null) {}
    for (paramInt1 = -1;; paramInt1 = ((ArrayList)localObject).size())
    {
      paramString.a(paramInt1, ", timestamp = " + System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("doRefreshMessageListHead_Confess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.f) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        if (((MessageRecord)((List)localObject).get(i)).getConfessTopicId() != paramRefreshMessageContext.f) {
          ((List)localObject).remove(i);
        }
        i -= 1;
      }
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject).subList(0, Math.min(paramInt2, ((List)localObject).size())));
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {}
    for (long l = ((MessageRecord)((List)localObject).get(0)).uniseq;; l = 0L)
    {
      localObject = new ArrayList();
      a(paramString, paramInt1, l, paramInt2, paramRefreshMessageContext, (ArrayList)localObject);
      a((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, (List)localObject);
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageManager
 * JD-Core Version:    0.7.0.1
 */