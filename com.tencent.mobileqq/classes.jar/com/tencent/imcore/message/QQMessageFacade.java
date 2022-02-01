package com.tencent.imcore.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQMessageFacadeConfig;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.DatalineMessageIpadManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.DatalineMessagePcManager;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.app.message.HCTopicMessageManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.message.SubMessageManager;
import com.tencent.mobileqq.app.message.TinyIdMsgMessageManager;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.FTSMessageDelete;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.dating.MsgBoxProtocol;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.TinyMsgCodec;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableEntityManagerFactory;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class QQMessageFacade
  extends Observable
  implements QQMessageFacadeStub, Manager
{
  public static final Object a;
  private int jdField_a_of_type_Int = -1;
  public Handler a;
  private SparseArray<BaseMessageManager> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private Registry jdField_a_of_type_ComTencentImcoreMessageRegistry;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQMessageFacadeConfig jdField_a_of_type_ComTencentMobileqqAppQQMessageFacadeConfig;
  public MsgNotifyManager a;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private String jdField_a_of_type_JavaLangString = null;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(-2011), Integer.valueOf(-2007), Integer.valueOf(-2002), Integer.valueOf(-2000), Integer.valueOf(-2010), Integer.valueOf(-2020), Integer.valueOf(-2022), Integer.valueOf(-2039), Integer.valueOf(-5008), Integer.valueOf(-5012), Integer.valueOf(-5018), Integer.valueOf(-1051), Integer.valueOf(-2051), Integer.valueOf(-1035), Integer.valueOf(-2056), Integer.valueOf(-2057), Integer.valueOf(-2058), Integer.valueOf(-7001), Integer.valueOf(-5013), Integer.valueOf(-5014), Integer.valueOf(-5016), Integer.valueOf(-5017), Integer.valueOf(-7002), Integer.valueOf(-7005) }));
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  public final Map<String, Message> a;
  private Vector<QQMessageFacade.ObserverWrapper> jdField_a_of_type_JavaUtilVector = new Vector();
  public final ConcurrentHashMap<Integer, List<MessageRecord>> a;
  public final AtomicInteger a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile int jdField_b_of_type_Int = -1;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString;
  public Map<String, Boolean> b;
  public final ConcurrentHashMap<String, Boolean> b;
  private Map<String, IMessageManager> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Map<String, Map<String, Object>> d = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new QQConcurrentHashMap(1017, 0, 1200);
    this.jdField_b_of_type_JavaUtilMap = new QQConcurrentHashMap(1018, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager = new MsgNotifyManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentImcoreMessageRegistry = new Registry();
    a();
  }
  
  QQMessageFacade(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new QQConcurrentHashMap(1017, 0, 1200);
    this.jdField_a_of_type_ComTencentImcoreMessageRegistry = new Registry();
  }
  
  private int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum() called with: type = [" + paramInt + "], start");
    }
    long l = SystemClock.elapsedRealtime();
    int k = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a();
    int j = i;
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        j = i;
      }
    }
    else {
      return j;
    }
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("getUnreadMsgsNum type=" + paramInt + "{");; localStringBuilder = null)
    {
      localObject = ((Set)localObject).iterator();
      i = k;
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        if (!a(localConversationInfo))
        {
          j = a(localConversationInfo.type).a(paramInt, localConversationInfo);
          if ((QLog.isColorLevel()) && (localStringBuilder != null) && (j > 0)) {
            localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + j + "]");
          }
          i = a(localConversationInfo, j) + i;
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null) && (i > 0))
      {
        localStringBuilder.append("}");
        QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
      }
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum() called with: type = [" + paramInt + "], end, costTime = [" + (SystemClock.elapsedRealtime() - l) + "]ms");
      return i;
    }
  }
  
  private int a(ConversationInfo paramConversationInfo, int paramInt)
  {
    int i = paramInt;
    if (paramConversationInfo.type == 1008)
    {
      i = paramInt;
      if (paramInt > 0)
      {
        int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().g(paramConversationInfo.uin, 1008);
        i = paramInt;
        if (j > 0) {
          i = paramInt - 1;
        }
        paramInt = i;
        if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramConversationInfo.uin))
        {
          paramInt = i;
          if (j > 0) {
            paramInt = 0;
          }
        }
        i = paramInt;
        if (AppConstants.KANDIAN_DAILY_UIN.equals(paramConversationInfo.uin)) {
          if (j <= 0)
          {
            i = paramInt;
            if (ReadInJoyHelper.o()) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    return i;
  }
  
  private int a(String paramString, StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentImcoreMessageRegistry.d().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((GetUnreadMsgNumCallback)localIterator.next()).a(paramString, paramStringBuilder) + i) {}
    return i;
  }
  
  private BaseMsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt);
  }
  
  private Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramString, paramInt, paramEntityManager, 0);
  }
  
  private Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramEntityManager = a(paramInt1).a(paramString, paramInt1, paramEntityManager, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "refreshSingleLastMsg() called with: uin = [" + paramString + "], uinType = [" + paramInt1 + "], topicId = [" + paramInt2 + "], cost = [" + (SystemClock.uptimeMillis() - l) + "]ms");
    }
    return paramEntityManager;
  }
  
  private QQMessageFacade.ObserverWrapper a(Observer paramObserver)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext())
    {
      QQMessageFacade.ObserverWrapper localObserverWrapper = (QQMessageFacade.ObserverWrapper)localIterator.next();
      if ((localObserverWrapper != null) && (paramObserver.equals(QQMessageFacade.ObserverWrapper.a(localObserverWrapper)))) {
        return localObserverWrapper;
      }
    }
    return null;
  }
  
  public static MessageRecord a(List<MessageRecord> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label82;
      }
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (!TextUtils.equals(localMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))
      {
        localObject = localMessageRecord;
        if (localMessageRecord.msgtype != -2006) {
          break;
        }
        localObject = localMessageRecord;
        if ((localMessageRecord instanceof MessageForFoldMsg)) {
          break;
        }
      }
      i -= 1;
    }
    label82:
    return null;
  }
  
  private String a(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  @NotNull
  private msg_svc.PbC2CReadedReportReq a(StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo, int paramInt)
  {
    msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    String str = paramConversationInfo.uin;
    if (1006 == paramConversationInfo.type) {
      str = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin);
    }
    if (TextUtils.isEmpty(str)) {
      return paramPbC2CReadedReportReq;
    }
    localUinPairReadInfo.peer_uin.set(Long.valueOf(str).longValue());
    paramStringBuilder.append("{C2C:").append(Long.valueOf(str)).append(paramConversationInfo.type).append("}");
    localUinPairReadInfo.last_read_time.set(paramInt);
    paramStringBuilder = paramPbC2CReadedReportReq;
    if (paramPbC2CReadedReportReq == null) {
      paramStringBuilder = new msg_svc.PbC2CReadedReportReq();
    }
    paramStringBuilder.pair_info.add(localUinPairReadInfo);
    return paramStringBuilder;
  }
  
  private msg_svc.PbC2CReadedReportReq a(boolean paramBoolean, StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo)
  {
    if (1044 == paramConversationInfo.type) {}
    do
    {
      return paramPbC2CReadedReportReq;
      paramConversationInfo = b(paramConversationInfo.uin, paramConversationInfo.type);
    } while (paramConversationInfo == null);
    int i = paramConversationInfo.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramConversationInfo.get(i);
      if (localMessageRecord == null) {}
      for (;;)
      {
        i -= 1;
        break;
        paramPbC2CReadedReportReq = a(paramBoolean, paramStringBuilder, paramPbC2CReadedReportReq, localMessageRecord);
      }
    }
    return paramPbC2CReadedReportReq;
  }
  
  private msg_svc.PbC2CReadedReportReq a(boolean paramBoolean, StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (UinTypeUtil.c(paramMessageRecord.senderuin))
    {
      paramStringBuilder = b(paramMessageRecord.senderuin, paramMessageRecord.istroop);
      localObject = paramPbC2CReadedReportReq;
      if (paramStringBuilder != null)
      {
        localObject = paramPbC2CReadedReportReq;
        if (!paramStringBuilder.isEmpty())
        {
          paramMessageRecord = paramStringBuilder.iterator();
          for (;;)
          {
            localObject = paramPbC2CReadedReportReq;
            if (!paramMessageRecord.hasNext()) {
              break;
            }
            paramStringBuilder = (MessageRecord)paramMessageRecord.next();
            a(paramStringBuilder.senderuin, paramStringBuilder.istroop, true, paramBoolean);
            localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(Long.valueOf(paramStringBuilder.senderuin).longValue());
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramStringBuilder.time);
            paramStringBuilder = paramPbC2CReadedReportReq;
            if (paramPbC2CReadedReportReq == null) {
              paramStringBuilder = new msg_svc.PbC2CReadedReportReq();
            }
            paramStringBuilder.pair_info.add((MessageMicro)localObject);
            paramPbC2CReadedReportReq = paramStringBuilder;
          }
        }
      }
    }
    else
    {
      a(paramMessageRecord.senderuin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), true, paramBoolean);
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      localUinPairReadInfo.last_read_time.set((int)paramMessageRecord.time);
      localObject = paramPbC2CReadedReportReq;
      if (paramPbC2CReadedReportReq == null) {
        localObject = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject).pair_info.add(localUinPairReadInfo);
      paramStringBuilder.append("{MSGBOX:").append(paramMessageRecord.frienduin).append("}");
    }
    return localObject;
  }
  
  private msg_svc.PbC2CReadedReportReq a(boolean paramBoolean, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo)
  {
    Object localObject = paramPbC2CReadedReportReq;
    if (paramBoolean)
    {
      a(paramConversationInfo.uin, paramConversationInfo.type, true, paramBoolean);
      long l = a(paramConversationInfo.uin, paramConversationInfo.type);
      msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = paramPbC2CReadedReportReq;
      if (paramPbC2CReadedReportReq == null) {
        localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
      }
      TinyMsgCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPbC2CReadedReportReq, l, paramConversationInfo);
      localObject = localPbC2CReadedReportReq;
      if (GameMsgManager.a())
      {
        ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(0);
        localObject = localPbC2CReadedReportReq;
      }
    }
    return localObject;
  }
  
  /* Error */
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 116	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getProxyManager	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   7: invokevirtual 497	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   10: iconst_1
    //   11: invokeinterface 502 2 0
    //   16: invokeinterface 305 1 0
    //   21: astore 8
    //   23: iconst_0
    //   24: istore_3
    //   25: iconst_0
    //   26: istore 4
    //   28: aload 8
    //   30: invokeinterface 228 1 0
    //   35: ifeq +422 -> 457
    //   38: aload 8
    //   40: invokeinterface 232 1 0
    //   45: checkcast 504	com/tencent/mobileqq/data/RecentUser
    //   48: astore 9
    //   50: iload 4
    //   52: iconst_1
    //   53: iadd
    //   54: istore 7
    //   56: iload_3
    //   57: istore 6
    //   59: iload 7
    //   61: istore 5
    //   63: aload 9
    //   65: getfield 507	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   68: lload_1
    //   69: lcmp
    //   70: ifle +377 -> 447
    //   73: aload 9
    //   75: getfield 508	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   78: getstatic 511	com/tencent/mobileqq/app/AppConstants:TROOP_ASSISTANT_UIN	Ljava/lang/String;
    //   81: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +103 -> 187
    //   87: invokestatic 516	com/tencent/mobileqq/managers/TroopAssistantManager:a	()Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   90: aload_0
    //   91: getfield 116	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 519	com/tencent/mobileqq/managers/TroopAssistantManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   97: invokeinterface 305 1 0
    //   102: astore 9
    //   104: iload 7
    //   106: iconst_1
    //   107: isub
    //   108: istore 4
    //   110: aload 9
    //   112: invokeinterface 228 1 0
    //   117: ifeq +67 -> 184
    //   120: aload 9
    //   122: invokeinterface 232 1 0
    //   127: checkcast 521	com/tencent/mobileqq/data/TroopAssistantData
    //   130: astore 10
    //   132: iload 4
    //   134: iconst_1
    //   135: iadd
    //   136: istore 5
    //   138: iload 5
    //   140: istore 4
    //   142: aload 10
    //   144: getfield 522	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   147: lload_1
    //   148: lcmp
    //   149: ifle -39 -> 110
    //   152: iload_3
    //   153: iconst_1
    //   154: iadd
    //   155: istore_3
    //   156: aload_0
    //   157: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   160: aload 10
    //   162: getfield 525	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   165: iconst_1
    //   166: invokestatic 528	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   169: iconst_1
    //   170: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: invokevirtual 532	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: iload 5
    //   179: istore 4
    //   181: goto -71 -> 110
    //   184: goto -156 -> 28
    //   187: aload 9
    //   189: getfield 508	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   192: aload 9
    //   194: invokevirtual 535	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   197: invokestatic 538	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   200: ifeq +115 -> 315
    //   203: iload 7
    //   205: iconst_1
    //   206: isub
    //   207: istore 4
    //   209: aload_0
    //   210: aload 9
    //   212: getfield 508	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   215: aload 9
    //   217: invokevirtual 535	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   220: invokevirtual 439	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Ljava/util/List;
    //   223: invokeinterface 305 1 0
    //   228: astore 9
    //   230: aload 9
    //   232: invokeinterface 228 1 0
    //   237: ifeq +75 -> 312
    //   240: aload 9
    //   242: invokeinterface 232 1 0
    //   247: checkcast 350	com/tencent/mobileqq/data/MessageRecord
    //   250: astore 10
    //   252: iload 4
    //   254: iconst_1
    //   255: iadd
    //   256: istore 5
    //   258: iload 5
    //   260: istore 4
    //   262: aload 10
    //   264: getfield 458	com/tencent/mobileqq/data/MessageRecord:time	J
    //   267: lload_1
    //   268: lcmp
    //   269: ifle -39 -> 230
    //   272: iload_3
    //   273: iconst_1
    //   274: iadd
    //   275: istore_3
    //   276: aload_0
    //   277: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   280: aload 10
    //   282: getfield 445	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   285: aload 10
    //   287: getfield 451	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   290: invokestatic 528	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   293: aload 10
    //   295: getfield 451	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   298: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: invokevirtual 532	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   304: pop
    //   305: iload 5
    //   307: istore 4
    //   309: goto -79 -> 230
    //   312: goto -128 -> 184
    //   315: iload_3
    //   316: istore 4
    //   318: aload 9
    //   320: getfield 508	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   323: invokestatic 399	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   326: invokevirtual 402	java/lang/Long:longValue	()J
    //   329: ldc2_w 539
    //   332: lcmp
    //   333: ifle +46 -> 379
    //   336: iload_3
    //   337: iconst_1
    //   338: iadd
    //   339: istore_3
    //   340: iload_3
    //   341: istore 4
    //   343: aload_0
    //   344: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   347: aload 9
    //   349: getfield 508	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   352: aload 9
    //   354: invokevirtual 535	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   357: invokestatic 528	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   360: aload 9
    //   362: invokevirtual 535	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   365: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: invokevirtual 532	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: iload 7
    //   374: istore 4
    //   376: goto -192 -> 184
    //   379: iload 7
    //   381: iconst_1
    //   382: isub
    //   383: istore 4
    //   385: goto -9 -> 376
    //   388: astore 9
    //   390: iload 7
    //   392: iconst_1
    //   393: isub
    //   394: istore_3
    //   395: aload 9
    //   397: invokevirtual 543	java/lang/NumberFormatException:printStackTrace	()V
    //   400: iload 4
    //   402: istore 6
    //   404: iload_3
    //   405: istore 5
    //   407: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +37 -> 447
    //   413: ldc 164
    //   415: iconst_2
    //   416: new 166	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 545
    //   426: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload 9
    //   431: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iload_3
    //   441: istore 5
    //   443: iload 4
    //   445: istore 6
    //   447: iload 6
    //   449: istore_3
    //   450: iload 5
    //   452: istore 4
    //   454: goto -270 -> 184
    //   457: iload_3
    //   458: iload 4
    //   460: if_icmpne +173 -> 633
    //   463: aload_0
    //   464: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   467: invokevirtual 548	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   470: astore 10
    //   472: aload_0
    //   473: getfield 116	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   476: invokevirtual 552	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   479: astore 8
    //   481: aload 8
    //   483: ldc_w 554
    //   486: aconst_null
    //   487: invokevirtual 560	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   490: astore 9
    //   492: aload 9
    //   494: ifnull +140 -> 634
    //   497: aload 9
    //   499: astore 8
    //   501: aload 9
    //   503: invokeinterface 565 1 0
    //   508: ifeq +126 -> 634
    //   511: aload 9
    //   513: astore 8
    //   515: aload 9
    //   517: iconst_0
    //   518: invokeinterface 569 2 0
    //   523: invokestatic 575	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   526: astore 11
    //   528: aload 9
    //   530: astore 8
    //   532: aload 10
    //   534: aload 11
    //   536: invokeinterface 578 2 0
    //   541: ifne -44 -> 497
    //   544: aload 9
    //   546: astore 8
    //   548: aload_0
    //   549: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   552: aload 11
    //   554: aload 11
    //   556: invokestatic 582	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   559: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   562: invokevirtual 532	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   565: pop
    //   566: goto -69 -> 497
    //   569: astore 10
    //   571: aload 9
    //   573: astore 8
    //   575: aload 10
    //   577: invokevirtual 583	java/lang/Exception:printStackTrace	()V
    //   580: aload 9
    //   582: astore 8
    //   584: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +34 -> 621
    //   590: aload 9
    //   592: astore 8
    //   594: ldc 164
    //   596: iconst_2
    //   597: new 166	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   604: ldc_w 545
    //   607: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 10
    //   612: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   621: aload 9
    //   623: ifnull +10 -> 633
    //   626: aload 9
    //   628: invokeinterface 586 1 0
    //   633: return
    //   634: aload 9
    //   636: ifnull -3 -> 633
    //   639: aload 9
    //   641: invokeinterface 586 1 0
    //   646: return
    //   647: astore 9
    //   649: aconst_null
    //   650: astore 8
    //   652: aload 8
    //   654: ifnull +10 -> 664
    //   657: aload 8
    //   659: invokeinterface 586 1 0
    //   664: aload 9
    //   666: athrow
    //   667: astore 9
    //   669: goto -17 -> 652
    //   672: astore 10
    //   674: aconst_null
    //   675: astore 9
    //   677: goto -106 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	680	0	this	QQMessageFacade
    //   0	680	1	paramLong	long
    //   24	437	3	i	int
    //   26	435	4	j	int
    //   61	390	5	k	int
    //   57	391	6	m	int
    //   54	340	7	n	int
    //   21	637	8	localObject1	Object
    //   48	313	9	localObject2	Object
    //   388	42	9	localNumberFormatException	java.lang.NumberFormatException
    //   490	150	9	localCursor	Cursor
    //   647	18	9	localObject3	Object
    //   667	1	9	localObject4	Object
    //   675	1	9	localObject5	Object
    //   130	403	10	localObject6	Object
    //   569	42	10	localException1	Exception
    //   672	1	10	localException2	Exception
    //   526	29	11	str	String
    // Exception table:
    //   from	to	target	type
    //   318	336	388	java/lang/NumberFormatException
    //   343	372	388	java/lang/NumberFormatException
    //   501	511	569	java/lang/Exception
    //   515	528	569	java/lang/Exception
    //   532	544	569	java/lang/Exception
    //   548	566	569	java/lang/Exception
    //   481	492	647	finally
    //   501	511	667	finally
    //   515	528	667	finally
    //   532	544	667	finally
    //   548	566	667	finally
    //   575	580	667	finally
    //   584	590	667	finally
    //   594	621	667	finally
    //   481	492	672	java/lang/Exception
  }
  
  private void a(BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    Iterator localIterator = paramAddMessageContext.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = (MessageRecord)paramAddMessageContext.d.get(localObject1);
      localObject1 = a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
      a((Message)localObject1);
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = MsgUtils.a((MessageForPic)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Message)localObject1).msg = ((String)localObject2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + ((Message)localObject1).frienduin + " , type = " + ((Message)localObject1).istroop + " ,msgType:" + ((Message)localObject1).msgtype + ", con = " + ((Message)localObject1).getLogColorContent());
      }
    }
  }
  
  private void a(BaseMessageManager.AddMessageContext paramAddMessageContext, Message paramMessage)
  {
    int j;
    int i;
    if (paramMessage != null)
    {
      j = 0;
      if (paramMessage.istroop != 1) {
        break label60;
      }
      paramAddMessageContext = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramMessage.frienduin);
      i = j;
      if (paramAddMessageContext != null)
      {
        i = j;
        if (paramAddMessageContext.a() == paramMessage.shmsgseq) {
          i = paramAddMessageContext.a();
        }
      }
    }
    for (;;)
    {
      paramMessage.bizType = i;
      return;
      label60:
      i = j;
      if (paramMessage.istroop == 3000)
      {
        paramAddMessageContext = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramMessage.frienduin + "&" + 3000);
        i = j;
        if (paramAddMessageContext != null)
        {
          i = j;
          if (paramAddMessageContext.a() == paramMessage.shmsgseq) {
            i = paramAddMessageContext.b();
          }
        }
      }
    }
  }
  
  private void a(BaseMessageManager.AddMessageContext paramAddMessageContext, Message paramMessage, RecentUser paramRecentUser)
  {
    HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser);
    RecentUtil.a(paramRecentUser, this);
    paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.b(paramRecentUser);
    if (paramRecentUser.getType() == 1038) {
      ((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(paramRecentUser);
    }
    if (paramMessage != null)
    {
      if (paramMessage.istroop == 3000) {
        paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(paramRecentUser.uin + "&" + 3000);
      }
    }
    else {
      return;
    }
    paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(paramRecentUser.uin);
  }
  
  private void a(MessageRecordEntityManager paramMessageRecordEntityManager, List<MessageRecord> paramList)
  {
    HashSet localHashSet = new HashSet(5);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord.isSupportFTS()) && (localMessageRecord.isValid) && (localMessageRecord.msgtype != -2006))
      {
        Object localObject = FTSMessageCodec.a(localMessageRecord);
        ((FTSMessage)localObject).deleteOpt();
        localObject = FTSMessageCodec.a((FTSMessage)localObject);
        if (!a(localHashSet, (FTSMessageDelete)localObject, localMessageRecord.getExtInfoFromExtStr("ExtraFTSMsgCounter"))) {
          paramMessageRecordEntityManager.persistOrReplace((Entity)localObject);
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentImcoreMessageRegistry.e().iterator();
    while (localIterator.hasNext()) {
      ((GetAioListCallback)localIterator.next()).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean, paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    if (!AnonymousChatHelper.a(paramMessageRecord)) {
      paramString.a(paramMessageRecord);
    }
  }
  
  private void a(StringBuilder paramStringBuilder, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo)
  {
    if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramConversationInfo.uin)) {}
    do
    {
      do
      {
        return;
        localObject = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      } while (localObject == null);
      ((SubAccountManager)localObject).b(paramConversationInfo.uin);
      paramConversationInfo = ((SubAccountManager)localObject).a(paramConversationInfo.uin);
    } while (paramConversationInfo == null);
    Object localObject = new msg_svc.PbBindUinMsgReadedConfirmReq();
    ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject).sync_cookie.set(ByteStringMicro.copyFrom(paramConversationInfo));
    paramPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject);
    paramStringBuilder.append("{SUBUIN}");
  }
  
  private void a(HashMap<String, MsgBackupMsgUserData> paramHashMap, boolean paramBoolean, int paramInt, Message paramMessage, String paramString1, String paramString2)
  {
    int j = 1;
    String str;
    if (paramBoolean)
    {
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramString1;
      }
      i = j;
      if (paramMessage.istroop != 0)
      {
        i = j;
        if (paramMessage.istroop != 1) {
          if (paramMessage.istroop != 3000) {
            break label114;
          }
        }
      }
    }
    label114:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramMessage = new MsgBackupMsgUserData();
        paramMessage.uin = paramString1;
        paramMessage.uinType = paramInt;
        paramMessage.name = str;
        paramMessage.mTitleName = str;
        paramHashMap.put(paramString1, paramMessage);
      }
      return;
    }
  }
  
  private void a(List<RecentUser> paramList, Message paramMessage)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        RecentUser localRecentUser = (RecentUser)paramList.get(i);
        if ((localRecentUser == null) || (localRecentUser.uin == null) || (!localRecentUser.uin.equals(paramMessage.frienduin))) {
          break label89;
        }
        if ((UinTypeUtil.h(paramMessage.istroop)) && (a().a(paramMessage.frienduin, UinTypeUtil.a(paramMessage.istroop)))) {
          c(paramMessage);
        }
      }
      return;
      label89:
      i += 1;
    }
  }
  
  private void a(List<MessageRecord> paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      a(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }), null);
    }
    paramList = ForwardOptionUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
    if (paramList.isEmpty())
    {
      QLog.d("Q.msg.QQMessageFacade", 1, "addMultiMessagesInner all fake messages");
      return;
    }
    Object localObject1 = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l2 = paramList.size();
    d(paramList);
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      e((MessageRecord)localObject3);
      if ((!QFileAssistantUtils.a((MessageRecord)localObject3)) && (QFileAssistantUtils.a(((MessageRecord)localObject3).frienduin)))
      {
        QFileAssistantUtils.a((MessageRecord)localObject3, 0);
        QFileAssistantUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (((MessageRecord)localObject3).msgtype == -2029) {
        QLog.d("VideoRedBag", 1, new Object[] { "onReceiveGrapTips, uniseq:", Long.valueOf(((MessageRecord)localObject3).uniseq), " uin:", ((MessageRecord)localObject3).frienduin, " type:", Integer.valueOf(((MessageRecord)localObject3).istroop) });
      }
      a(((MessageRecord)localObject3).istroop).a((MessageRecord)localObject3, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (BaseMessageManager.AddMessageContext)localObject1);
      if (PAWeatherItemBuilder.a(((MessageRecord)localObject3).frienduin)) {
        WeatherDCReportHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3);
      }
    }
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).g.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject3 = (String)paramEntityManager.next();
      localObject2 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      localObject3 = ((List)((BaseMessageManager.AddMessageContext)localObject1).g.get(localObject3)).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((EcShopAssistantManager)localObject2).a((MessageRecord)((Iterator)localObject3).next(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    ((BaseMessageManager.AddMessageContext)localObject1).g.clear();
    paramEntityManager = a();
    a((BaseMessageManager.AddMessageContext)localObject1, paramEntityManager);
    if (paramBoolean3) {
      ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentImcoreMessageConversationFacade.a(paramList);
    }
    localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject3 = (RecentUser)((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject3);
      try
      {
        a((BaseMessageManager.AddMessageContext)localObject1, paramEntityManager, (RecentUser)localObject3);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner --> Catch Exception .Info = " + localException);
      }
    }
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      TroopAssistantManager.a().a((MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.get(localObject2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    paramEntityManager = (HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
    localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      paramEntityManager.a((MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.get(localObject4));
    }
    a((BaseMessageManager.AddMessageContext)localObject1);
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).f.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      localObject2 = ((List)((BaseMessageManager.AddMessageContext)localObject1).f.get(localObject2)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        TroopBarAssistantManager.a().a((MessageRecord)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    ((BaseMessageManager.AddMessageContext)localObject1).f.clear();
    MsgAutoMonitorUtil.getInstance().addAddMsgTime(System.currentTimeMillis() - l1, l2);
    paramEntityManager = ServiceAccountFolderManager.a();
    localObject1 = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject2).next();
      paramEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject4);
      VideoReporter.a((MessageRecord)localObject4);
      if ((localObject1 != null) && (((ClassicHeadActivityManager)localObject1).a())) {
        ((ClassicHeadActivityManager)localObject1).b(((MessageRecord)localObject4).senderuin);
      }
      if (((localObject4 instanceof MessageForShortVideo)) && (((MessageForShortVideo)localObject4).redBagType == LocalMediaInfo.REDBAG_TYPE_GET))
      {
        localObject4 = (MessageForShortVideo)localObject4;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject4).shortVideoId, ((MessageForShortVideo)localObject4).uniseq, ((MessageForShortVideo)localObject4).redBagStat);
      }
    }
    ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
  }
  
  private void a(List<RecentBaseData> paramList, List<RecentUser> paramList1, HashMap<String, MsgBackupMsgUserData> paramHashMap)
  {
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      label123:
      while (paramList1.hasNext())
      {
        String str = ((RecentUser)paramList1.next()).uin;
        MsgBackupMsgUserData localMsgBackupMsgUserData = (MsgBackupMsgUserData)paramHashMap.get(str);
        if ((localMsgBackupMsgUserData != null) && (Long.parseLong(str) > 10000L))
        {
          if ((localMsgBackupMsgUserData.uinType == 0) || (localMsgBackupMsgUserData.uinType == 1) || (localMsgBackupMsgUserData.uinType == 3000)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label123;
            }
            paramList.add(localMsgBackupMsgUserData);
            break;
          }
        }
      }
    }
  }
  
  private void a(msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (paramPbC2CReadedReportReq != null)
    {
      byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a();
      if (arrayOfByte != null) {
        paramPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      paramPbMsgReadedReportReq.c2c_read_report.set(paramPbC2CReadedReportReq);
    }
  }
  
  private void a(msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo, long paramLong)
  {
    if (!paramConversationInfo.uin.matches("^\\d+$")) {
      return;
    }
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.valueOf(paramConversationInfo.uin).longValue());
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    paramPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
  }
  
  private boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentImcoreMessageRegistry.d().iterator();
    while (localIterator.hasNext()) {
      if (((GetUnreadMsgNumCallback)localIterator.next()).a(paramConversationInfo, paramArrayOfBoolean)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(HashSet<String> paramHashSet, FTSMessageDelete paramFTSMessageDelete, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramFTSMessageDelete.deleteOne();
    }
    for (;;)
    {
      return false;
      if (paramHashSet.contains(paramString)) {
        return true;
      }
      try
      {
        paramFTSMessageDelete.delCounter = Long.valueOf(Long.parseLong(paramString)).longValue();
        paramFTSMessageDelete.deletePatch();
        paramHashSet.add(paramString);
      }
      catch (Exception paramHashSet) {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, paramHashSet.toString());
      }
    }
  }
  
  private BaseMessageManager b(int paramInt)
  {
    MsgPool localMsgPool = a(paramInt).a();
    switch (paramInt)
    {
    default: 
      return new C2CMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localMsgPool);
    case 1: 
      return new TroopMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localMsgPool);
    case 3000: 
      return new DiscMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localMsgPool);
    case 7000: 
      return new SubMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localMsgPool);
    case 1026: 
      return new HCTopicMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localMsgPool);
    }
    return new TinyIdMsgMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localMsgPool);
  }
  
  private void b(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramEntityManager);
      }
    }
  }
  
  private void c(Message paramMessage)
  {
    if (paramMessage.istroop != 1009) {
      a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if (paramMessage.istroop != 1001)
    {
      a(AppConstants.LBS_HELLO_UIN, 1001, paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    a(AppConstants.LBS_HELLO_UIN, 10002, paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void d(Message paramMessage)
  {
    if (((!AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin)) && ((UinTypeUtil.a(paramMessage.istroop) == 10002) || (UinTypeUtil.a(paramMessage.istroop) == 1001))) || (UinTypeUtil.a(paramMessage.istroop) == 10010) || ((!AppConstants.DATE_UIN.equals(paramMessage.frienduin)) && (UinTypeUtil.a(paramMessage.istroop) == 1010)))
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
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + paramMessage + ",hasReply=" + paramMessage.hasReply);
            }
          }
        }
      }
    }
  }
  
  private void e(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.SAME_STATE_BOX_UIN)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = a(paramMessage.istroop).a(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          int i = paramMessage.unReadNum;
          paramMessage.unReadNum = (a(paramMessage.istroop).a(localMessageRecord.senderuin, localMessageRecord.istroop, 0L) + i);
        }
        localEntityManager.close();
      }
    }
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    int i = FlashChatManager.a(paramMessageRecord);
    if (i != -1) {}
    try
    {
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(i, paramMessageRecord);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner type " + i, paramMessageRecord);
    }
  }
  
  private boolean e(ConversationInfo paramConversationInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentImcoreMessageRegistry.d().iterator();
    while (localIterator.hasNext()) {
      if (((GetUnreadMsgNumCallback)localIterator.next()).a(paramConversationInfo)) {
        return true;
      }
    }
    return false;
  }
  
  private void f(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getParcelHooker().a(paramMessageRecord);
  }
  
  private void g(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (UinTypeUtil.c(localMessageRecord.senderuin))
        {
          g(localMessageRecord.senderuin, localMessageRecord.istroop);
        }
        else if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localMessageRecord.senderuin))
        {
          a().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          Message localMessage = a(localMessageRecord.senderuin, paramInt);
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
          RecentUser localRecentUser = localRecentUserProxy.a(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          RecentUtil.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade());
          localRecentUserProxy.b(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshMsgBox uin=" + paramString + ",type=" + paramInt + ",move " + localMessageRecord.senderuin + " from box to recentlist");
          }
          setChanged();
          notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt, String paramString)
  {
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
    if (localConversationFacade != null) {
      return localConversationFacade.a(paramString, paramInt);
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public int a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase();
    if (localSQLiteDatabase != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = localSQLiteDatabase.getCount(paramString, paramLong1, paramLong2, i, -1000);
    }
    return i;
  }
  
  public long a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).b(paramString, 0);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equals(paramString)))
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a(paramString, 0, 9223372036854775807L, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramString = (String)localObject1;
          if (!((List)localObject2).isEmpty()) {
            paramString = (MessageRecord)((List)localObject2).get(0);
          }
        }
        localObject2 = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d("vip", 2, "getLastC2CBubleID find in db");
          localObject2 = paramString;
        }
      }
      if (localObject2 == null)
      {
        return 0L;
        i -= 1;
        break;
      }
      return ((MessageRecord)localObject2).vipBubbleID;
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    long l2 = -1L;
    Object localObject;
    long l1;
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt);
      l2 = ((Message)localObject).shmsgseq;
      l1 = l2;
      if (((Message)localObject).isLongMsg())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (paramString.size() > 0) {
            return Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
          }
        }
      }
    }
    else
    {
      l1 = l2;
      if (UinTypeUtil.b(paramInt))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (!paramString.isEmpty())
          {
            paramInt = paramString.size() - 1;
            for (;;)
            {
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              localObject = (MessageRecord)paramString.get(paramInt);
              if (!MessageRecordInfo.b(((MessageRecord)localObject).issend)) {
                return ((MessageRecord)localObject).time;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
    return l1;
  }
  
  public long a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).b(paramString1, 0);
    int i;
    MessageRecord localMessageRecord;
    if (paramString1 != null)
    {
      i = paramString1.size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)paramString1.get(i);
        if (localMessageRecord.senderuin.equals(paramString2))
        {
          paramString1 = localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (paramString1 = localMessageRecord;; paramString1 = null)
    {
      if (paramString1 == null)
      {
        return 0L;
        i -= 1;
        break;
      }
      return paramString1.vipBubbleID;
    }
  }
  
  public BaseMessageManager a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      BaseMessageManager localBaseMessageManager2 = (BaseMessageManager)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      BaseMessageManager localBaseMessageManager1 = localBaseMessageManager2;
      if (localBaseMessageManager2 == null)
      {
        localBaseMessageManager1 = b(paramInt);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localBaseMessageManager1);
      }
      return localBaseMessageManager1;
    }
  }
  
  public C2CMessageManager a()
  {
    return (C2CMessageManager)a(0);
  }
  
  public ConversationFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
  }
  
  public Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a();
  }
  
  @Nullable
  protected Message a(long paramLong, List<MessageRecord> paramList)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.uniseq > paramLong))
      {
        paramList = new Message();
        paramList.frienduin = localMessageRecord.frienduin;
        paramList.istroop = localMessageRecord.istroop;
        paramList.time = localMessageRecord.time;
        paramList.isread = localMessageRecord.isread;
        a(paramList);
        return paramList;
      }
      i += 1;
    }
    return null;
  }
  
  public Message a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false);
  }
  
  public Message a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return b(paramString, paramInt1, paramInt2);
    }
    return a(paramString, paramInt1);
  }
  
  public Message a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = new Message();
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = a(paramString, paramInt);
    Message localMessage = (Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject1;
    if (localMessage != null)
    {
      localObject1 = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else
    {
      if (this.jdField_b_of_type_Int != 0) {
        break label161;
      }
      localObject1 = new Message();
      ((Message)localObject1).frienduin = paramString;
      ((Message)localObject1).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
      localStringBuilder.append("All-In");
    }
    for (;;)
    {
      paramString = (String)localObject1;
      if (localObject1 == null) {
        break;
      }
      paramString = (String)localObject1;
      if (!UinTypeUtil.a(((Message)localObject1).frienduin, ((Message)localObject1).istroop)) {
        break;
      }
      ((Message)localObject1).istroop = UinTypeUtil.a(((Message)localObject1).istroop);
      return localObject1;
      label161:
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = localMessage;
        if (localMessage == null)
        {
          if ((!RecentParcelUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || ((!paramBoolean) && (Looper.getMainLooper() == Looper.myLooper()))) {
            break label324;
          }
          localObject2 = MessageRecord.getTableName(paramString, paramInt);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (((EntityManager)localObject1).tabbleIsExist((String)localObject2))
          {
            localMessage = a(paramString, paramInt, (EntityManager)localObject1);
            localStringBuilder.append("Not-Finish-Yet，force Check DB");
          }
          ((EntityManager)localObject1).close();
          localObject1 = localMessage;
          if (localMessage == null)
          {
            localObject1 = new Message();
            ((Message)localObject1).frienduin = paramString;
            ((Message)localObject1).istroop = paramInt;
            ((Message)localObject1).isCacheValid = false;
            this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
            localStringBuilder.append("Not-Finish-Yet，force Check DB But Null");
          }
        }
        for (;;)
        {
          localStringBuilder.append("Not-Finish-Yet");
          break;
          label324:
          localObject1 = new Message();
          ((Message)localObject1).frienduin = paramString;
          ((Message)localObject1).istroop = paramInt;
          ((Message)localObject1).isCacheValid = false;
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
        }
      }
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((!((EntityManager)localObject2).tabbleIsExist((String)localObject1)) && (!((EntityManager)localObject2).tabbleIsExist(str2))) {
        break label485;
      }
      localMessage = a(paramString, paramInt, (EntityManager)localObject2);
      localStringBuilder.append("Check-DB");
      localObject1 = localMessage;
      if (localMessage == null)
      {
        localObject1 = new Message();
        ((Message)localObject1).frienduin = paramString;
        ((Message)localObject1).istroop = paramInt;
        this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
      }
      ((EntityManager)localObject2).close();
    }
    label485:
    if (localMessage == null)
    {
      localObject1 = new Message();
      ((Message)localObject1).frienduin = paramString;
      ((Message)localObject1).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject1 = localMessage;
    }
  }
  
  public Registry a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageRegistry;
  }
  
  public MsgSummary a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    for (;;)
    {
      try
      {
        if (!(a(localMessage.istroop) instanceof TroopMessageManager)) {
          continue;
        }
        if (!TextUtils.isEmpty(ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage.frienduin, localMessage.senderuin))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "getMsgSummaryStrForTroop nickname is null");
        }
        localMessage.isFromLS = true;
        a(localMessage);
        localMessage.isFromLS = false;
        ThreadManager.getSubThreadHandler().post(new QQLSActivity.SyncTroopSummaryTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((QQLSActivity)paramContext).a, localMessage.senderuin, localMessage.frienduin));
      }
      catch (Throwable paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        continue;
        a(localMessage);
        continue;
      }
      paramMessageRecord = new MsgSummary();
      MsgUtils.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
      return paramMessageRecord;
      a(localMessage);
    }
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public DatalineMessageManager a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (String str = "dataline_manager_pc";; str = "dataline_manager_ipad") {
      return (DatalineMessageManager)a(str);
    }
  }
  
  public DiscMessageManager a()
  {
    return (DiscMessageManager)a(3000);
  }
  
  public IMessageManager a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.jdField_c_of_type_JavaUtilMap)
      {
        if (this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {
          break label116;
        }
        if ("dataline_manager_pc".equals(paramString))
        {
          localObject = new DatalineMessagePcManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          if (localObject != null) {
            break label104;
          }
          return null;
        }
      }
      if ("dataline_manager_ipad".equals(paramString))
      {
        localObject = new DatalineMessageIpadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        continue;
        label104:
        this.jdField_c_of_type_JavaUtilMap.put(paramString, localObject);
        label116:
        return (IMessageManager)this.jdField_c_of_type_JavaUtilMap.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = a(paramInt).b(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public ChatHistorySearchData a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return a(paramInt).a(paramString1, paramString2, paramInt, paramString3);
  }
  
  public MessageRecord a(Message paramMessage)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessage.msgtype, paramMessage.msgData, paramMessage.extLong, paramMessage.extStr, paramMessage.istroop);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessage);
    if ((localMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)localMessageRecord).parse();
    }
    return localMessageRecord;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {}
    List localList;
    do
    {
      return paramMessageRecord;
      localList = a(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    } while ((localList == null) || (localList.isEmpty()));
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if (UinTypeUtil.a(localMessageRecord, paramMessageRecord))
      {
        if (localMessageRecord.longMsgIndex == 0) {
          return localMessageRecord;
        }
        if (localMessageRecord.longMsgIndex < paramMessageRecord.longMsgIndex) {
          paramMessageRecord = localMessageRecord;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
      }
    }
    return paramMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      int i = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!MsgProxyUtils.b(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramInt).a(paramString, paramInt, null);
        }
        return localObject2;
        i -= 1;
        break;
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt1, paramLong1);
    if (localMessageRecord == null)
    {
      paramString1 = null;
      return paramString1;
    }
    paramString3 = TransfileUtile.getForwardMsgContent(localMessageRecord.msg, paramString2, paramString3, paramLong2, paramInt2);
    localMessageRecord.msg = paramString3;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentToForward: set msg =" + localMessageRecord.getBaseInfoString());
    }
    paramString2 = new ContentValues();
    if (localMessageRecord.versionCode > 0) {}
    for (;;)
    {
      try
      {
        paramString2.put("msgData", paramString3.getBytes("UTF-8"));
        a(paramString1, paramInt1, localMessageRecord, paramString2, null);
        paramString1 = localMessageRecord;
        if (!(localMessageRecord instanceof ChatMessage)) {
          break;
        }
        ((ChatMessage)localMessageRecord).reParse();
        return localMessageRecord;
      }
      catch (UnsupportedEncodingException paramString3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentToForward fail!" + paramString3);
        continue;
      }
      paramString2.put("msg", paramString3);
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord, paramList);
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt).a(paramString1, paramInt, paramString2);
  }
  
  public TroopMessageManager a()
  {
    return (TroopMessageManager)a(1);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return a(paramContext, paramMessageRecord, paramBoolean).a(paramContext).toString();
  }
  
  public String a(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    String str4 = "select * from " + paramString;
    String str1 = null;
    String str2 = null;
    if (paramLong1 >= 0L) {}
    for (paramString = String.format(" time >= %d and time <= %d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });; paramString = null)
    {
      if (paramLong3 >= 0L) {}
      for (String str3 = String.format(" _id >= %d ", new Object[] { Long.valueOf(paramLong3) });; str3 = null)
      {
        int i;
        if (paramBoolean)
        {
          i = -1000;
          if (i == -1000) {
            str2 = " msgtype = " + i;
          }
          if (paramString != null) {
            str1 = " where " + paramString;
          }
          paramString = str1;
          if (str3 != null)
          {
            if (str1 == null) {
              break label323;
            }
            paramString = str1 + " and " + str3;
          }
          label194:
          str1 = paramString;
          if (str2 != null) {
            if (paramString == null) {
              break label348;
            }
          }
        }
        label323:
        label348:
        for (str1 = paramString + " and " + str2;; str1 = " where " + str2)
        {
          paramString = str4;
          if (str1 != null) {
            paramString = str4 + str1;
          }
          str1 = paramString;
          if (paramInt > 0)
          {
            str1 = " order by _id limit " + paramInt;
            str1 = paramString + str1;
          }
          return str1;
          i = 0;
          break;
          paramString = " where " + str3;
          break label194;
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2, long paramLong)
  {
    int j = 0;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a(paramString1, 0, 0, false);
    paramString1 = null;
    int i;
    Object localObject;
    if (localList != null)
    {
      i = localList.size() - 1;
      if (i < 0) {
        break label128;
      }
      localObject = (MessageRecord)localList.get(i);
      if (((MessageRecord)localObject).uniseq == paramLong) {
        j = 1;
      }
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        paramString1 = (String)localObject;
        if (j == 0) {}
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "chatthumb";
        }
        return ((MessageForPic)localObject).getFilePath(paramString1);
        i -= 1;
        break;
      }
      return "";
      label128:
      localObject = paramString1;
    }
  }
  
  public List<ChatMessage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<ChatMessage> a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(paramString, paramInt1, -1L, paramInt2, false);
      paramInt1 = paramInt3;
      if (paramInt3 == -1) {
        paramInt1 = paramString.size();
      }
      Iterator localIterator = paramString.iterator();
      paramInt3 = 0;
      int i;
      do
      {
        ChatMessage localChatMessage;
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localChatMessage = (ChatMessage)localIterator.next();
          } while (localChatMessage.getConfessTopicId() != paramInt2);
          i = paramInt3 + 1;
          paramInt3 = i;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt3 = i;
      } while (i < paramInt1);
      return paramString;
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString1, paramInt1, paramLong, paramInt2, paramString2);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    List localList = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean);
    a(paramString, paramInt1, paramLong, paramInt2, paramBoolean, localList);
    return localList;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    return a(paramInt).a(paramString, paramInt, paramList);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, -1L, paramBoolean);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return a(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, String paramString2)
  {
    localObject1 = null;
    str = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localArrayList = new ArrayList();
    QSlowTableEntityManagerFactory localQSlowTableEntityManagerFactory = new QSlowTableEntityManagerFactory((String)localObject2);
    EntityManager localEntityManager = localQSlowTableEntityManagerFactory.a();
    localObject2 = localQSlowTableEntityManagerFactory.build((String)localObject2).getWritableDatabase();
    try
    {
      paramString1 = ((SQLiteDatabase)localObject2).rawQuery(paramString1, paramString2, null, null);
      str = paramString1;
      localObject1 = paramString1;
      paramString2 = localEntityManager.cursor2List(MessageRecord.class, paramString2, paramString1);
      if (paramString2 != null)
      {
        str = paramString1;
        localObject1 = paramString1;
        if (paramString2.size() > 0)
        {
          str = paramString1;
          localObject1 = paramString1;
          localArrayList.addAll(paramString2);
        }
      }
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    catch (Exception paramString1)
    {
      do
      {
        localObject1 = str;
        paramString1.printStackTrace();
      } while (str == null);
      str.close();
      return localArrayList;
    }
    finally
    {
      if (localObject1 == null) {
        break label156;
      }
      ((Cursor)localObject1).close();
    }
    return localArrayList;
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq;
    Object localObject2;
    Object localObject1;
    label156:
    Object localObject3;
    if (UinTypeUtil.a(paramString, paramInt))
    {
      d(paramString, paramInt);
      List localList = b(paramString, paramInt);
      if (localList == null) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      paramString = null;
      localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      paramInt = localList.size() - 1;
      if (paramInt >= 0)
      {
        localObject2 = (MessageRecord)localList.get(paramInt);
        if (localObject2 == null) {
          localObject1 = paramString;
        }
        do
        {
          do
          {
            paramInt -= 1;
            paramString = (String)localObject1;
            break;
            if (!UinTypeUtil.c(((MessageRecord)localObject2).senderuin)) {
              break label291;
            }
            localObject2 = b(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
            localObject1 = paramString;
          } while (localObject2 == null);
          localObject1 = paramString;
        } while (((List)localObject2).isEmpty());
        localObject2 = ((List)localObject2).iterator();
        do
        {
          localObject1 = paramString;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
        } while (localObject3 == null);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop) <= 0) {
          break label630;
        }
        a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop, false, paramBoolean);
        localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(Long.valueOf(((MessageRecord)localObject3).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)((MessageRecord)localObject3).time);
        if (paramString != null) {
          break label627;
        }
        paramString = new msg_svc.PbC2CReadedReportReq();
        label279:
        paramString.pair_info.add((MessageMicro)localObject1);
      }
    }
    label291:
    label627:
    label630:
    for (;;)
    {
      break label156;
      if (UinTypeUtil.d(((MessageRecord)localObject2).senderuin))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) > 0) {
          c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        }
        MsgBoxProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
        MsgBoxProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null);
        localObject1 = paramString;
        break;
      }
      localObject1 = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
        break;
      }
      a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, false, paramBoolean);
      localObject3 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).peer_uin.set(Long.valueOf(((MessageRecord)localObject2).senderuin).longValue());
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).last_read_time.set((int)((MessageRecord)localObject2).time);
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject3);
      localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject2).senderuin).append("}");
      break;
      if (paramString != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a();
        if (localObject1 != null) {
          paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localPbMsgReadedReportReq.c2c_read_report.set(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_LBS>setLbsFriendReaded: " + localStringBuilder.toString());
          long l2 = System.currentTimeMillis();
          QLog.d("Q.msg_box", 2, "setBoxMsgReaded[cost:" + (l2 - l1) + "]");
        }
        return localPbMsgReadedReportReq;
      }
      return null;
      break label279;
    }
  }
  
  public msg_svc.PbMsgReadedReportReq a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a();
    if ((localObject == null) || (((Set)localObject).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject).iterator();
    localObject = null;
    for (;;)
    {
      ConversationInfo localConversationInfo;
      long l;
      if (localIterator.hasNext())
      {
        localConversationInfo = (ConversationInfo)localIterator.next();
        if ((ConversationFacade.a(localConversationInfo) <= 0) || (!a().b(localConversationInfo.uin, localConversationInfo.type)) || (e(localConversationInfo))) {
          continue;
        }
        if (UinTypeUtil.a(localConversationInfo.uin, localConversationInfo.type))
        {
          localObject = a(paramBoolean, localStringBuilder, (msg_svc.PbC2CReadedReportReq)localObject, localConversationInfo);
          continue;
        }
        if (7000 == localConversationInfo.type)
        {
          a(localStringBuilder, localPbMsgReadedReportReq, localConversationInfo);
          continue;
        }
        if ((!paramBoolean) && (localConversationInfo.type == 1008) && (b(localConversationInfo))) {
          continue;
        }
        if ((1006 != localConversationInfo.type) && ((!UinTypeUtil.b(localConversationInfo.type)) || (Long.valueOf(localConversationInfo.uin).longValue() <= 10000L))) {
          break label380;
        }
        if (10007 == localConversationInfo.type)
        {
          localObject = a(paramBoolean, (msg_svc.PbC2CReadedReportReq)localObject, localConversationInfo);
          continue;
        }
        if (localConversationInfo.type == 1036) {
          continue;
        }
        a(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
        l = a(localConversationInfo.uin, localConversationInfo.type);
        if (l != -1L) {
          break label363;
        }
      }
      label363:
      label380:
      do
      {
        do
        {
          a((msg_svc.PbC2CReadedReportReq)localObject, localPbMsgReadedReportReq);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
          }
          return localPbMsgReadedReportReq;
          localObject = a(localStringBuilder, (msg_svc.PbC2CReadedReportReq)localObject, localConversationInfo, (int)l);
          break;
          if (3000 != localConversationInfo.type) {
            break label480;
          }
          a(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
          l = a(localConversationInfo.uin, localConversationInfo.type);
        } while (l == -1L);
        msg_svc.PbDiscussReadedReportReq localPbDiscussReadedReportReq = new msg_svc.PbDiscussReadedReportReq();
        localPbDiscussReadedReportReq.conf_uin.set(Long.valueOf(localConversationInfo.uin).longValue());
        localPbDiscussReadedReportReq.last_read_seq.set(l);
        localPbMsgReadedReportReq.dis_read_report.add(localPbDiscussReadedReportReq);
        break;
        if ((1 != localConversationInfo.type) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isTroopMark(localConversationInfo.uin, localConversationInfo.type))) {
          break;
        }
        a(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
        HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localConversationInfo.uin);
        l = a(localConversationInfo.uin, localConversationInfo.type);
      } while (l == -1L);
      label480:
      a(localPbMsgReadedReportReq, localConversationInfo, l);
    }
  }
  
  public void a()
  {
    ThreadManager.post(new QQMessageFacade.1(this), 10, null, false);
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(AppConstants.RECOMMEND_TROOP_UIN);
    if (a().a(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      Message localMessage = a(str, 4001);
      paramInt = a(4001).a(paramInt, localMessage);
      a().d(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4001));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (((OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "orderMediaMsgSending in chat:" + paramString);
      }
      return;
    }
    a(paramInt).a(paramInt, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "refreshRecentCache_Lazy() called with: refreshTopN = [" + paramInt + "], isLoadGrpAssist = [" + paramBoolean + "]");
    }
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    int i;
    int k;
    int j;
    if (this.jdField_b_of_type_Int == -1)
    {
      if (localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName()))
      {
        i = 1;
        this.jdField_b_of_type_Int = i;
      }
    }
    else
    {
      localObject = ((RecentUserProxy)localObject).a(true);
      i = 0;
      k = i;
      if (localObject == null) {
        break label427;
      }
      k = i;
      if (((List)localObject).size() <= 0) {
        break label427;
      }
      i = ((List)localObject).size();
      if (paramInt <= 0) {
        break label484;
      }
      if (i <= paramInt) {
        break label368;
      }
      j = paramInt;
    }
    for (;;)
    {
      label163:
      int m = 0;
      label166:
      k = i;
      if (m < j)
      {
        long l = SystemClock.uptimeMillis();
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(m);
        a(localRecentUser.uin, localRecentUser.getType(), localEntityManager);
        if (m == 10)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        if (UinTypeUtil.a(localRecentUser.uin, localRecentUser.getType()))
        {
          if (!AppConstants.LBS_HELLO_UIN.equals(localRecentUser.uin)) {
            break label374;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.LBS_SAY_HELLO_LIST_UIN, localRecentUser.getType())) {
            a(AppConstants.LBS_SAY_HELLO_LIST_UIN, localRecentUser.getType(), localEntityManager);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshRecentCache_Lazy() i = [" + m + "], cost = [" + (SystemClock.uptimeMillis() - l) + "]ms");
          }
          m += 1;
          break label166;
          i = 0;
          break;
          label368:
          j = i;
          break label163;
          label374:
          if ((AppConstants.DATE_UIN.equals(localRecentUser.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.DATE_SAY_HELLO_LIST_UIN, localRecentUser.getType()))) {
            a(AppConstants.DATE_SAY_HELLO_LIST_UIN, localRecentUser.getType(), localEntityManager);
          }
        }
      }
      label427:
      if (paramBoolean) {
        b(localEntityManager);
      }
      if ((paramBoolean) || (((List)localObject).size() > 10))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      if ((paramInt != 0) && (paramInt < k)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      label484:
      j = i;
    }
  }
  
  public void a(Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).a(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    ThreadManager.post(new QQMessageFacade.4(this, paramQQAppInterface, paramMessageRecord, paramArrayList, paramHongbaoParams), 8, null, false);
  }
  
  public void a(QQMessageFacadeConfig paramQQMessageFacadeConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQMessageFacadeConfig = paramQQMessageFacadeConfig;
  }
  
  public void a(MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    if (localFileManagerEntity != null) {
      if ((paramMessageForFile.isSend()) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || (localFileManagerEntity.status == 3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramMessageForFile, localFileManagerEntity, new QQMessageFacade.3(this, paramMessageForFile, localFileManagerEntity));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg uniseq[" + paramMessageForFile.uniseq + "], sendUin[" + FileManagerUtil.e(paramMessageForFile.senderuin) + "], type[" + paramMessageForFile.istroop + "], Entity is Null, return");
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord, MessageCache.jdField_a_of_type_Int);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(paramMessageRecord.frienduin, paramMessageRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, localEntityManager, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, String.format("addSendMessage key = %d %s %d", new Object[] { Long.valueOf(paramMessageRecord.uniseq), paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramMessageRecord, paramInt);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      localEntityManager.close();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    a(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.frienduin == null) || (paramMessageRecord.frienduin.length() < 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      a(paramMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
      }
      b(paramMessageRecord, paramMessageObserver, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      e(localArrayList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      e(localArrayList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramRecentUser, false);
    a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
    if (paramRecentUser.getType() == 1) {
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin);
    }
  }
  
  public void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
    localObject = paramEntityManager.query(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopBarData)((Iterator)localObject).next()).mUin, 1008, paramEntityManager);
      }
    }
  }
  
  public void a(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (ArrayList)localEntityManager.query(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localEntityManager.remove((TransFileInfo)paramString.next());
      }
    }
    localEntityManager.close();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    a(paramInt1).a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1).a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramInt).a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QLog.i("Q.msg.QQMessageFacade", 1, "updateMsgExtraFlagByUniseq: peerUin = " + MsfSdkUtils.getShortUin(paramString) + " type = " + paramInt1 + " uniseq = " + paramLong);
    MessageRecord localMessageRecord = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    a(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    Object localObject = a(paramInt);
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject = ((BaseMsgProxy)localObject).a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(paramLong1, paramLong2);
    }
    for (;;)
    {
      BaseMessageManager localBaseMessageManager = a(paramInt);
      localBaseMessageManager.a(paramString, paramInt, (MessageRecord)localObject, 3);
      a(paramString, paramInt, paramLong2);
      setChanged();
      notifyObservers(localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(8047, true, localObject);
      if (localObject == null) {}
      do
      {
        return;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
      } while ((!(localBaseMessageManager instanceof BaseMessageManagerForTroopAndDisc)) || (!paramString.e()) || ((!((BaseMessageManagerForTroopAndDisc)localBaseMessageManager).b((MessageRecord)localObject)) && (!paramString.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq))));
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
      }
      paramString.d(null);
      localBaseMessageManager.b();
      return;
      localObject = null;
    }
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong + " fieldName = " + paramString2 + " fieldValue = " + paramObject);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2, paramObject);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramInt).a(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramArrayOfByte = a(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    a(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public void a(String paramString, int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    List localList = a(paramString, paramInt);
    if (localList == null) {}
    for (int i = 0;; i = localList.size())
    {
      i = 10 - i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "refreshMessageListHeadByAIOBreak numTroopRefresh = " + paramRefreshMessageContext.i + ", count = " + i);
      }
      if (i <= 0) {
        break;
      }
      paramRefreshMessageContext.i = true;
      a(paramInt).a(paramString, paramInt, i, paramRefreshMessageContext);
      return;
    }
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt;
    paramRefreshMessageContext.e = i;
    a(paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).b(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ContentValues paramContentValues, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq mr=" + paramMessageRecord);
    }
    a(paramInt).a(paramString, paramInt, paramMessageRecord.uniseq, paramContentValues);
    if (paramArrayOfInt == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq null == reasons");
      }
    }
    for (;;)
    {
      return;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq reason=" + k);
        }
        a(paramInt).a(paramString, paramInt, paramMessageRecord, k);
        i += 1;
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (QLog.isColorLevel()) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramLong = 0L;
      }
      for (;;)
      {
        a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - l) + " drafttime = " + paramLong);
        }
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramString, paramInt, paramList);
      setChanged();
      notifyObservers(paramList.get(0));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager();
    }
    try
    {
      a(paramList, paramString, true, true, false, false);
      paramString.close();
      e(paramList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    a(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public void a(String paramString, Collection<MessageRecord> paramCollection)
  {
    if (paramCollection != null)
    {
      a("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    a("------------" + paramString + "-------------- is null", "");
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    a(((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int).a(paramArrayList);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.close();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        paramString = a(paramArrayList);
        if (paramString != null)
        {
          setChanged();
          notifyObservers(paramString);
          QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        }
        return;
      }
      finally
      {
        paramString.close();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.close();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramString = a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.close();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.close();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramString = a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.close();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    String str;
    int i;
    do
    {
      return;
      str = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
      i = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int;
      a(i).a(paramArrayList, paramBoolean);
      ((MiniMsgHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(str, i, -1);
    } while ((!paramBoolean) || ((i != 1) && (i != 3000)));
    a(str, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(str, i));
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "setChatMsgList");
    }
  }
  
  public void a(List<MessageRecord> paramList, String paramString)
  {
    a(paramList, paramString, true);
  }
  
  public void a(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, paramBoolean);
      paramString.close();
      paramString = a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        e(paramList);
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList.size() != 0) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, true, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Int >= 0);
  }
  
  protected boolean a(ConversationInfo paramConversationInfo)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "filterUnreadMsgsNum() called with: info = [" + paramConversationInfo + "], start");
    }
    long l = SystemClock.elapsedRealtime();
    boolean bool1 = bool2;
    if (paramConversationInfo != null)
    {
      if (paramConversationInfo.uin != null) {
        break label114;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "filterUnreadMsgsNum() called with: info = [" + paramConversationInfo + "], costTime = [" + (SystemClock.elapsedRealtime() - l) + "]ms");
      }
      return bool1;
      label114:
      bool1 = bool2;
      if (!AppConstants.TROOP_NOTIFICATION_UIN.equals(paramConversationInfo.uin))
      {
        bool1 = bool2;
        if (!d(paramConversationInfo))
        {
          bool1 = bool2;
          if (!c(paramConversationInfo))
          {
            bool1 = bool2;
            if (!TextUtils.equals(AppConstants.NEW_KANDIAN_UIN, paramConversationInfo.uin))
            {
              bool1 = bool2;
              if (!TextUtils.equals(AppConstants.LBS_HELLO_UIN, paramConversationInfo.uin))
              {
                bool1 = bool2;
                if (!TextUtils.equals(AppConstants.KANDIAN_MERGE_UIN, paramConversationInfo.uin)) {
                  if (paramConversationInfo.type == 1008)
                  {
                    bool1 = bool2;
                    if (b(paramConversationInfo)) {}
                  }
                  else
                  {
                    bool1 = bool2;
                    if (paramConversationInfo.type != 1033)
                    {
                      bool1 = bool2;
                      if (paramConversationInfo.type != 1034)
                      {
                        bool1 = bool2;
                        if (paramConversationInfo.type != 1037)
                        {
                          bool1 = bool2;
                          if (paramConversationInfo.type != 1044)
                          {
                            bool1 = bool2;
                            if (paramConversationInfo.type != 1045)
                            {
                              bool1 = bool2;
                              if (paramConversationInfo.type != 1036) {
                                if (paramConversationInfo.type == 1038)
                                {
                                  bool1 = bool2;
                                  if (!b()) {}
                                }
                                else
                                {
                                  if (paramConversationInfo.type != 7000) {
                                    break;
                                  }
                                  QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum subaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
                                  bool1 = bool2;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    Object localObject;
    if (paramConversationInfo.type == 1038)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().b(paramConversationInfo.uin, paramConversationInfo.type);
      Message localMessage = a(paramConversationInfo.uin, paramConversationInfo.type);
      if (((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(localMessage, (RecentUser)localObject) != 1) {
        break label528;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum appletsaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
      }
    }
    int i;
    label528:
    for (bool1 = true;; i = 0)
    {
      break;
      bool1 = bool2;
      if (paramConversationInfo.type == 10007) {
        break;
      }
      localObject = new boolean[1];
      if (a(paramConversationInfo, (boolean[])localObject))
      {
        i = localObject[0];
        break;
      }
      i = 0;
      break;
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    Message localMessage = a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (UinTypeUtil.b(paramMessageRecord.istroop)) {
      if ((paramMessageRecord.msgUid != localMessage.msgUid) || (paramMessageRecord.shmsgseq != localMessage.shmsgseq)) {}
    }
    while (paramMessageRecord.shmsgseq == localMessage.shmsgseq)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return c(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = MessageRecord.getTableName(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("select count() as counter, 'x' as msgData from ").append(paramString).append(" where issend=0 and isValid=1 and msgtype ").append(UinTypeUtil.b());
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().rawQuery(Message.class, localStringBuilder.toString(), null);
    if ((paramString != null) && (paramString.size() > 0)) {
      return ((Message)paramString.get(0)).counter > 0;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (UinTypeUtil.d(paramInt2))
    {
      bool1 = bool2;
      if (MsgProxyUtils.b(paramInt2))
      {
        bool1 = bool2;
        if (a(paramInt1).e(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(paramString, paramInt), Boolean.valueOf(true));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).d(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a();
    }
    a("refresh C2C autopull, size = " + paramString.size(), ", timestamp = " + System.currentTimeMillis());
    return true;
  }
  
  public void addObserver(Observer paramObserver)
  {
    if (paramObserver == null) {}
    for (;;)
    {
      return;
      try
      {
        if (a(paramObserver) != null)
        {
          QLog.d("Q.msg.QQMessageFacade", 1, "addObserver() called with: o = [" + paramObserver + "], contains");
          continue;
        }
      }
      finally {}
      paramObserver = new QQMessageFacade.ObserverWrapper(paramObserver);
      super.addObserver(paramObserver);
      this.jdField_a_of_type_JavaUtilVector.addElement(paramObserver);
    }
  }
  
  public int b()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder(168);
    ((StringBuilder)localObject1).append("startTime=[").append(l).append("],");
    int j = a(2);
    if (j != 0) {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j) }));
    }
    int i = j;
    int k;
    if (a().b(AppConstants.TROOP_NOTIFICATION_UIN, 9000))
    {
      k = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((k != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + k);
      }
      i = j + k;
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.TROOP_NOTIFICATION_UIN, Integer.valueOf(9000), Integer.valueOf(k) }));
    }
    j = i;
    Object localObject2;
    if (a().b(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230))
    {
      j = ServiceAccountFolderManager.a().b();
      i += j;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (!(localObject2 instanceof RedTouchManager)) {
        break label861;
      }
      k = ((RedTouchManager)localObject2).a("104000.104001", 100);
      if (k <= 0) {
        break label861;
      }
      i = k + i;
    }
    label856:
    label861:
    for (;;)
    {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, Integer.valueOf(7230), Integer.valueOf(j) }));
      j = i;
      i = j;
      if (TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        i = j;
        if (a().b(AppConstants.TENCENT_DOCS_ASSISTANT_UIN, 6004))
        {
          localObject2 = ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(46, false);
          if ((localObject2 == null) || (!((oidb_0x791.RedDotInfo)localObject2).uint32_number.has()) || (!((oidb_0x791.RedDotInfo)localObject2).bool_display_reddot.get())) {
            break label856;
          }
        }
      }
      for (i = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();; i = 0)
      {
        j += i;
        ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.TENCENT_DOCS_ASSISTANT_UIN, Integer.valueOf(6004), Integer.valueOf(i) }));
        i = j;
        j = i;
        if (a().b(AppConstants.SEND_BLESS_UIN, 9003))
        {
          localObject2 = (BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
          j = i;
          if (localObject2 != null)
          {
            k = ((BlessManager)localObject2).b();
            j = i + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SEND_BLESS_UIN, Integer.valueOf(9003), Integer.valueOf(k) }));
          }
        }
        i = j;
        if (a().b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000))
        {
          k = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          i = j + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, Integer.valueOf(7000), Integer.valueOf(k) }));
        }
        j = i;
        if (GameMsgManager.a())
        {
          localObject2 = (GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
          j = i;
          if (!((GameMsgManager)localObject2).c())
          {
            k = ((GameMsgManager)localObject2).c();
            j = i + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { "2747277822", Integer.valueOf(10007), Integer.valueOf(k) }));
          }
        }
        i = j;
        if (MiniAppConfProcessor.a("MiniAppEcShopNumMsgEnable", 1) == 1)
        {
          i = j;
          if (a().b(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120))
          {
            k = ((EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            i = j + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, Integer.valueOf(7120), Integer.valueOf(k) }));
          }
        }
        j = a("(%s,%d,%d) ", (StringBuilder)localObject1);
        ((StringBuilder)localObject1).append(",costTime=[").append(System.currentTimeMillis() - l).append("]");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!((String)localObject1).equals(this.jdField_b_of_type_JavaLangString))
        {
          QLog.d("Q.msg.QQMessageFacade_UnreadMonitor", 1, "Recent Msg Unread: " + (String)localObject1);
          this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        }
        return j + i;
      }
    }
  }
  
  public int b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localObject = new QSlowTableEntityManagerFactory((String)localObject).build((String)localObject).getReadableDatabase();
    if (localObject != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = ((SQLiteDatabase)localObject).getCount(paramString, paramLong1, paramLong2, i, -1000);
      ((SQLiteDatabase)localObject).close();
    }
    return i;
  }
  
  public Message b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "getFirstUnreadMessage() called with: uin = [" + paramString + "], type = [" + paramInt + "]");
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramString, paramInt);
    Object localObject = a(l, b(paramString, paramInt));
    if (localObject != null) {}
    Message localMessage;
    do
    {
      return localObject;
      localMessage = a(l, a(paramString, paramInt, l, 3, String.format("time>=%d", new Object[] { Long.valueOf(l) })));
      localObject = localMessage;
    } while (localMessage != null);
    localObject = new Message();
    ((Message)localObject).frienduin = paramString;
    ((Message)localObject).istroop = paramInt;
    return localObject;
  }
  
  public Message b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      paramString = new Message();
    }
    StringBuilder localStringBuilder;
    String str;
    Message localMessage;
    Object localObject;
    do
    {
      do
      {
        return paramString;
        localStringBuilder = new StringBuilder("Case:");
        str = a(paramString, paramInt1);
        localMessage = (Message)this.jdField_a_of_type_JavaUtilMap.get(str);
        if ((localMessage != null) && (localMessage.isCacheValid))
        {
          localObject = localMessage;
          if (localMessage.getConfessTopicId() == paramInt2) {}
        }
        else
        {
          localObject = MessageRecord.getTableName(paramString, paramInt1);
          EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (!localEntityManager.tabbleIsExist((String)localObject)) {
            break;
          }
          localMessage = a(paramString, paramInt1, localEntityManager, paramInt2);
          localStringBuilder.append("Check-DB");
          localObject = localMessage;
          if (localMessage == null)
          {
            localObject = new Message();
            ((Message)localObject).frienduin = paramString;
            ((Message)localObject).istroop = paramInt1;
            ((Message)localObject).setConfessTopicId(paramInt2);
            this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
          }
          localEntityManager.close();
        }
        paramString = (String)localObject;
      } while (localObject == null);
      paramString = (String)localObject;
    } while (!UinTypeUtil.a(((Message)localObject).frienduin, ((Message)localObject).istroop));
    ((Message)localObject).istroop = UinTypeUtil.a(((Message)localObject).istroop);
    return localObject;
    if (localMessage == null)
    {
      localObject = new Message();
      ((Message)localObject).frienduin = paramString;
      ((Message)localObject).istroop = paramInt1;
      ((Message)localObject).setConfessTopicId(paramInt2);
      this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject = localMessage;
    }
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).c(paramString, paramInt);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!MsgProxyUtils.b(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
    }
    for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        return localObject1;
        i -= 1;
        break;
      }
      Message localMessage = a(paramString, paramInt);
      localObject2 = localObject1;
      if (localMessage != null)
      {
        localObject2 = localObject1;
        if (localMessage.isCacheValid) {
          if (localMessage.lastMsg == null) {
            break label170;
          }
        }
      }
      label170:
      for (localObject2 = localMessage.lastMsg;; localObject2 = a(localMessage))
      {
        localMessage.lastMsg = ((MessageRecord)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return a(paramInt).a(paramString, paramInt, null);
      }
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public String b(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramContext).toString();
  }
  
  public List<RecentBaseData> b()
  {
    ArrayList localArrayList = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject3 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    Object localObject1 = localArrayList;
    Object localObject2;
    HashMap localHashMap;
    Object localObject4;
    int i;
    String str;
    boolean bool;
    if (localObject3 != null)
    {
      localObject1 = localArrayList;
      if (((List)localObject3).size() > 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(true);
        localHashMap = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Sqlite)((Iterator)localObject3).next();
            localObject1 = SecurityUtile.decode(((Sqlite)localObject4).tbl_name);
            ((Sqlite)localObject4).tbl_name = ((String)localObject1);
            if (((String)localObject1).endsWith("_New"))
            {
              i = MsgProxyUtils.a((String)localObject1);
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(i).a((String)localObject1, localEntityManager);
              if ((localObject4 != null) && (((Message)localObject4).frienduin != null))
              {
                str = ((Message)localObject4).frienduin;
                if (((String)localObject1).startsWith("mr_friend_"))
                {
                  localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, false);
                  bool = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      a(localHashMap, bool, i, (Message)localObject4, str, (String)localObject1);
      break;
      if (((String)localObject1).startsWith("mr_troop_"))
      {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, false);
        i = 1;
        bool = true;
      }
      else if (((String)localObject1).startsWith("mr_discusssion_"))
      {
        localObject1 = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        i = 3000;
        bool = true;
        continue;
        localObject1 = localArrayList;
        if (localHashMap.size() > 0)
        {
          localArrayList = new ArrayList();
          a(localArrayList, (List)localObject2, localHashMap);
          localObject2 = localHashMap.keySet().iterator();
          label445:
          for (;;)
          {
            localObject1 = localArrayList;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (MsgBackupMsgUserData)localHashMap.get((String)((Iterator)localObject2).next());
            if ((((MsgBackupMsgUserData)localObject1).uinType == 0) || (((MsgBackupMsgUserData)localObject1).uinType == 1) || (((MsgBackupMsgUserData)localObject1).uinType == 3000) || (((MsgBackupMsgUserData)localObject1).uinType == 1000) || (((MsgBackupMsgUserData)localObject1).uinType == 1004) || (((MsgBackupMsgUserData)localObject1).uinType == 10010)) {}
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (localArrayList.contains(localObject1)) || (Long.parseLong(((MsgBackupMsgUserData)localObject1).uin) <= 10000L)) {
                break label445;
              }
              localArrayList.add(localObject1);
              break;
            }
          }
        }
        return localObject1;
      }
      else
      {
        localObject1 = null;
        bool = false;
      }
    }
  }
  
  public List<MessageRecord> b(String paramString, int paramInt)
  {
    return a(paramInt).b(paramString, paramInt);
  }
  
  public List<ChatMessage> b(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(paramString, paramInt1);
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = paramString.size();
      }
      Iterator localIterator = paramString.iterator();
      paramInt2 = 0;
      int i;
      do
      {
        ChatMessage localChatMessage;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localChatMessage = (ChatMessage)localIterator.next();
          i = paramInt2 + 1;
          paramInt2 = i;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt2 = i;
      } while (i < paramInt1);
      return paramString;
    }
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).d(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).b(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<MessageRecord> b(String paramString1, String paramString2)
  {
    localObject = null;
    str = null;
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase();
    localArrayList = new ArrayList();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().a();
    try
    {
      paramString1 = localSQLiteDatabase.rawQuery(paramString1, paramString2, null, null);
      str = paramString1;
      localObject = paramString1;
      paramString2 = localEntityManager.cursor2List(MessageRecord.class, paramString2, paramString1);
      if (paramString2 != null)
      {
        str = paramString1;
        localObject = paramString1;
        if (paramString2.size() > 0)
        {
          str = paramString1;
          localObject = paramString1;
          localArrayList.addAll(paramString2);
        }
      }
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    catch (Exception paramString1)
    {
      do
      {
        localObject = str;
        paramString1.printStackTrace();
      } while (str == null);
      str.close();
      return localArrayList;
    }
    finally
    {
      if (localObject == null) {
        break label138;
      }
      ((Cursor)localObject).close();
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(4001).b(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt);
    } while (a(4001).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN);
    notifyObservers(localObject);
  }
  
  public void b(Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a(paramMessage);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        AioVideoTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.deleteCacheFileByMsg((MessageForShortVideo)localObject1);
      }
    }
    else
    {
      if (paramMessageRecord.isSendFromLocal()) {
        break label88;
      }
    }
    for (;;)
    {
      return;
      AioVideoTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label88:
      localObject1 = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      localObject2 = new ArrayList();
      Object localObject3;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        j = paramMessageRecord.msgElemList.size();
        i = 0;
        while (i < j)
        {
          localObject3 = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          i += 1;
        }
      }
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
        int k = paramMessageRecord.longMsgFragmentList.size();
        i = 0;
        if (i < k)
        {
          localObject3 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = (MessageForMixedMsg)localObject3;
              int m = ((MessageForMixedMsg)localObject3).msgElemList.size();
              j = 0;
              while (j < m)
              {
                MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(j);
                if ((localMessageRecord instanceof MessageForPic)) {
                  ((List)localObject2).add((MessageForPic)localMessageRecord);
                }
                j += 1;
              }
            }
          }
        }
      }
      else
      {
        if (!(paramMessageRecord instanceof MessageForPic)) {
          continue;
        }
        ((List)localObject2).add((MessageForPic)paramMessageRecord);
      }
      int j = ((List)localObject2).size();
      int i = 0;
      while (i < j)
      {
        paramMessageRecord = (MessageForPic)((List)localObject2).get(i);
        paramMessageRecord = paramMessageRecord.frienduin + paramMessageRecord.uniseq + "_" + paramMessageRecord.subMsgId;
        localObject3 = ((ITransFileController)localObject1).findProcessor(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject3).stop();
          ((ITransFileController)localObject1).removeProcessor(paramMessageRecord);
        }
        i += 1;
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    b(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      ThreadManager.post(new QQMessageFacade.2(this, paramMessageRecord, paramMessageObserver, paramBoolean), 10, null, false);
    }
    for (;;)
    {
      if (paramMessageRecord.msgtype == -2011) {
        FightReporter.a(paramMessageRecord);
      }
      return;
      c(paramMessageRecord, paramMessageObserver, paramBoolean);
    }
  }
  
  public void b(String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1052);
    localMessageRecord.msg = paramString;
    localMessageRecord.frienduin = AppConstants.BABY_Q_UIN;
    localMessageRecord.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.time = MessageCache.a();
    localMessageRecord.msgseq = ((int)localMessageRecord.time);
    localMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(localMessageRecord, null, true);
  }
  
  public void b(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
    if (localSQLiteDatabase == null) {}
    do
    {
      return;
      i = localSQLiteDatabase.getCount(paramString);
    } while (i <= 6000);
    int j = Math.max(i - 5000, 1200);
    MessageRecordEntityManager localMessageRecordEntityManager = (MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().a();
    EntityTransaction localEntityTransaction = localMessageRecordEntityManager.getTransaction();
    int k = j / 2500 + 1;
    int m = j / k;
    int i = 0;
    if (i < k)
    {
      Object localObject2;
      if (paramInt == 0)
      {
        localObject2 = String.format("delete from %s where time in (select time from %s order by time limit %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
        localObject1 = String.format("SELECT * FROM %s WHERE time IN (SELECT time FROM %s ORDER BY time LIMIT %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
      }
      for (;;)
      {
        long l = System.currentTimeMillis();
        if (localEntityTransaction != null) {}
        try
        {
          localEntityTransaction.begin();
          localObject1 = localMessageRecordEntityManager.a((String)localObject1, null);
          if (localObject1 == null) {}
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            label219:
            localObject1 = null;
            localException1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 2, "checkRecordCount " + localException1);
            }
            Object localObject3 = localObject1;
            if (localEntityTransaction != null)
            {
              localEntityTransaction.end();
              localObject3 = localObject1;
            }
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.end();
          }
        }
        try
        {
          a(localMessageRecordEntityManager, (List)localObject1);
          localSQLiteDatabase.execSQL((String)localObject2);
          if (localEntityTransaction != null) {
            localEntityTransaction.commit();
          }
          if (localEntityTransaction == null) {
            break label573;
          }
          localEntityTransaction.end();
          localObject2 = localObject1;
        }
        catch (Exception localException2)
        {
          break label490;
          Object localObject4 = localObject1;
          break label219;
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = (QSlowTableManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
          if (localObject1 != null) {
            ((QSlowTableManager)localObject1).a(paramString, (List)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "transfer " + paramString + " " + m + "|" + i + "|" + j + " rows cost " + (System.currentTimeMillis() - l));
          }
        }
        i += 1;
        break;
        if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
        {
          localObject2 = String.format("delete from %s where shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
          localObject1 = String.format("SELECT * FROM %s WHERE shmsgseq IN (SELECT shmsgseq FROM %s ORDER BY shmsgseq LIMIT %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
        }
        else
        {
          localObject2 = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
          localObject1 = String.format("SELECT * FROM %s WHERE _id IN (SELECT _id FROM %s ORDER BY _id LIMIT %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
        }
      }
    }
    label490:
    localMessageRecordEntityManager.close();
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong, true);
  }
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(localMessageRecord);
    if (a(paramInt).b(paramString, paramInt, paramLong) == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt, localMessageRecord);
    }
    if (!paramBoolean) {}
    label168:
    label183:
    do
    {
      for (;;)
      {
        return;
        if (localMessageRecord == null) {
          break label183;
        }
        if (a().b(localMessageRecord.frienduin, localMessageRecord.istroop))
        {
          paramInt = 0;
          if ((localMessageRecord instanceof MessageForLongMsg)) {
            if (UinTypeUtil.a(localMessageRecord, a(localMessageRecord.frienduin, localMessageRecord.istroop))) {
              paramInt = 1;
            }
          }
          while (paramInt != 0)
          {
            if (!UinTypeUtil.h(localMessageRecord.istroop)) {
              break label168;
            }
            a(localMessageRecord.istroop).a(localMessageRecord);
            return;
            if (a(localMessageRecord)) {
              paramInt = 1;
            }
          }
        }
      }
      a(localMessageRecord.istroop).b(localMessageRecord);
      return;
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + paramString + ",type=" + paramInt + ",uniseq=" + paramLong);
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localEntityManager.persistOrReplace((MessageRecord)localIterator.next());
      }
    }
    finally
    {
      localEntityManager.close();
    }
    a((MessageRecord)paramList.get(paramList.size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
  }
  
  public void b(List<MessageRecord> paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.close();
      paramString = a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      e(paramList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void b(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, false, false, true, false);
      paramString.close();
      paramString = a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        e(paramList);
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  protected boolean b()
  {
    return AppletsFolderManager.a(false);
  }
  
  protected boolean b(ConversationInfo paramConversationInfo)
  {
    return ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      paramString = (Message)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public int c()
  {
    int i = a(10);
    if (QLog.isColorLevel()) {
      QLog.d("MiniUnreadMsgsNum", 2, "unread count = " + i);
    }
    return i;
  }
  
  public Message c(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str1 = a(paramString, paramInt);
    Message localMessage = (Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject = localMessage;
    EntityManager localEntityManager;
    if (localMessage == null)
    {
      localObject = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((!localEntityManager.tabbleIsExist((String)localObject)) && (!localEntityManager.tabbleIsExist(str2))) {
        break label135;
      }
      paramString = a(paramString, paramInt, localEntityManager);
    }
    for (;;)
    {
      localEntityManager.close();
      localObject = paramString;
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!UinTypeUtil.a(((Message)localObject).frienduin, ((Message)localObject).istroop)) {
        break;
      }
      ((Message)localObject).istroop = UinTypeUtil.a(((Message)localObject).istroop);
      return localObject;
      label135:
      if (localMessage == null)
      {
        localObject = new Message();
        ((Message)localObject).frienduin = paramString;
        ((Message)localObject).istroop = paramInt;
        this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        paramString = (String)localObject;
      }
      else
      {
        localMessage.isCacheValid = true;
        paramString = localMessage;
      }
    }
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).c(paramString, paramInt, paramLong);
  }
  
  public String c(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info");
    ConfessInfo localConfessInfo = new ConfessInfo();
    localConfessInfo.parseFromJsonStr((String)localObject);
    paramMessageRecord = ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localConfessInfo, paramMessageRecord.senderuin);
    localObject = new MsgSummary();
    MsgUtils.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, (MsgSummary)localObject, paramMessageRecord, false, paramBoolean);
    return ((MsgSummary)localObject).a(paramContext).toString();
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).b(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public void c()
  {
    a(0).a();
    a(3000).a();
    a(1).a();
    a(1026).a();
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.frienduin == null) || (paramMessageRecord.frienduin.length() < 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      a(paramMessageRecord);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
  }
  
  public void c(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (AppSetting.f()) {
      f(paramMessageRecord);
    }
    ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
      }
      if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1049))
      {
        if (paramMessageRecord.istroop == 1001) {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLBSFriendNewClient(paramMessageRecord.frienduin)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramMessageRecord, null, paramBoolean);
          return;
          if (paramMessageRecord.istroop == 1003) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          }
        }
      }
      return;
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + paramMessageRecord.getMessage(), paramMessageRecord);
        return;
        if (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramMessageRecord.msgtype)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramMessageRecord, paramMessageObserver, paramBoolean);
          return;
        }
        if (paramMessageRecord.msgtype == -2071)
        {
          if (paramMessageRecord.istroop == 1) {
            AnonymousChatHelper.a().a(paramMessageRecord);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramMessageRecord, paramMessageObserver, paramBoolean);
        }
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    a(paramString, paramInt, true, false);
  }
  
  public void c(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        a(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord, null, false, true, true);
      }
    }
    e(paramList);
  }
  
  protected boolean c(ConversationInfo paramConversationInfo)
  {
    return HiddenChatHelper.a(paramConversationInfo.uin, paramConversationInfo.type, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean c(String paramString, int paramInt)
  {
    return d(paramString, paramInt);
  }
  
  public int d()
  {
    return a(7);
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).d(paramString, paramInt, paramLong);
  }
  
  public String d(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramContext = new Message();
    MessageRecord.copyMessageRecordBaseField(paramContext, paramMessageRecord);
    paramContext.emoRecentMsg = null;
    paramContext.fileType = -1;
    a(paramContext);
    return MsgUtils.a(paramContext.nickName, 0.4F);
  }
  
  public void d()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    boolean bool;
    int i;
    if (this.jdField_b_of_type_Int == -1)
    {
      bool = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i = 1;
        this.jdField_b_of_type_Int = i;
      }
    }
    for (;;)
    {
      localEntityManager.close();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache start : Lazy : " + bool);
      }
      long l = System.currentTimeMillis();
      if (bool) {
        a(90, true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache finish : TimeSpend:" + (System.currentTimeMillis() - l));
        }
        return;
        i = 0;
        break;
        e();
      }
      bool = true;
    }
  }
  
  public void d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (a(paramMessageRecord.istroop).a(paramMessageRecord)) {
      return;
    }
    if (paramMessageRecord.msgtype == -2005)
    {
      a((MessageForFile)paramMessageRecord);
      return;
    }
    if ((paramMessageRecord.msgtype == -2057) && (paramMessageRecord.istroop == 1)) {
      ((TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a(paramMessageRecord);
    }
    a(paramMessageRecord.istroop).c(paramMessageRecord);
  }
  
  public void d(String paramString, int paramInt)
  {
    a(paramInt).b(paramString, paramInt, false, false);
  }
  
  public void d(List<MessageRecord> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForStructing))
      {
        paramList = (MessageForStructing)localMessageRecord;
        if ((paramList.structingMsg != null) && (paramList.structingMsg.mMsgServiceID == 98))
        {
          MsgProxyUtils.a(paramList, false);
          Object localObject = (NearbyGrayTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner will insert a face score message, msg = " + paramList);
          }
          boolean bool2 = FaceScoreUtils.a(paramList, "isFaceScoreSecondMember");
          localObject = ((NearbyGrayTipsManager)localObject).b(1, 2, localMessageRecord.time);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getValidConfigForFaceScore, flag = " + bool2 + ", configForFaceScore = " + localObject);
          }
          if (localObject != null)
          {
            int i = StructMsgItemLayout26.a(paramList.structingMsg.mExtraData);
            paramList = new Random();
            paramList.setSeed(localMessageRecord.time);
            boolean bool1;
            if ((i & 0x4) != 0)
            {
              bool1 = true;
              label225:
              if (!bool1) {
                break label465;
              }
              if (!bool2) {
                break label455;
              }
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getFavoriteGrayTipWording1(paramList);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getGrayTipWording, wording = " + paramList);
              }
              if ((paramList == null) || (TextUtils.isEmpty(paramList.text))) {
                break;
              }
              paramList = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject).id, paramList.text, paramList.highlightText, 16, ((NearbyGrayTipsManager.GrayTipsConfig)localObject).url, 1);
              localObject = MessageRecordFactory.a(-2027);
              ((MessageRecord)localObject).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.selfuin, paramList, localMessageRecord.time - 1L, -2027, 1001, localMessageRecord.time - 1L);
              ((MessageRecord)localObject).isread = true;
              FaceScoreUtils.a((MessageRecord)localObject, "isFaceScoreGrayTips", true);
              FaceScoreUtils.a((MessageRecord)localObject, "isFaceScoreSecondMember", bool2);
              FaceScoreUtils.a((MessageRecord)localObject, "isFaceScoreSpecialLike", bool1);
              MsgProxyUtils.a((MessageRecord)localObject, false);
              a((MessageRecord)localObject, localMessageRecord.selfuin);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner insert faceScore gray tips., msg = " + localObject);
              break;
              bool1 = false;
              break label225;
              label455:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getFavoriteGrayTipWording2(paramList);
              continue;
              label465:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getGrayTipWording(paramList);
            }
          }
        }
      }
    }
  }
  
  protected boolean d(ConversationInfo paramConversationInfo)
  {
    return FriendsStatusUtil.a(paramConversationInfo.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean d(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  /* Error */
  public void deleteObserver(Observer paramObserver)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 2172	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/util/Observer;)Lcom/tencent/imcore/message/QQMessageFacade$ObserverWrapper;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +20 -> 29
    //   12: aload_0
    //   13: aload_2
    //   14: invokespecial 2758	java/util/Observable:deleteObserver	(Ljava/util/Observer;)V
    //   17: aload_0
    //   18: getfield 103	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   21: aload_2
    //   22: invokevirtual 2761	java/util/Vector:removeElement	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 164
    //   31: iconst_1
    //   32: new 166	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 2763
    //   42: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc_w 2765
    //   52: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: goto -35 -> 26
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	QQMessageFacade
    //   0	69	1	paramObserver	Observer
    //   7	15	2	localObserverWrapper	QQMessageFacade.ObserverWrapper
    // Exception table:
    //   from	to	target	type
    //   2	8	64	finally
    //   12	26	64	finally
    //   29	61	64	finally
  }
  
  public void deleteObservers()
  {
    try
    {
      super.deleteObservers();
      this.jdField_a_of_type_JavaUtilVector.removeAllElements();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int e()
  {
    return a(9);
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).g(paramString, paramInt, paramLong);
  }
  
  public void e()
  {
    a("refreshCache", "");
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int j;
    if (localObject1 != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(true);
      boolean bool1 = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      ConversationFacade localConversationFacade = a();
      StringBuilder localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      int i = 0;
      boolean bool2;
      Object localObject2;
      do
      {
        Sqlite localSqlite;
        do
        {
          do
          {
            do
            {
              j = i;
              if (!localIterator.hasNext()) {
                break;
              }
              localSqlite = (Sqlite)localIterator.next();
              localSqlite.tbl_name = SecurityUtile.decode(localSqlite.tbl_name);
            } while ((localSqlite.tbl_name.equals("mr_fileManager")) || (localSqlite.tbl_name.startsWith("mr_confess_a")) || (localSqlite.tbl_name.startsWith("mr_confess_b")));
            bool2 = localSqlite.tbl_name.endsWith("_New");
            localObject2 = a(MsgProxyUtils.a(localSqlite.tbl_name)).a(localSqlite.tbl_name, localEntityManager);
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
            }
          } while ((localObject2 == null) || (((Message)localObject2).frienduin == null));
          localObject1 = localObject2;
          if (((Message)localObject2).uniseq == 0L)
          {
            a(((Message)localObject2).istroop).b(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
            localObject2 = a(((Message)localObject2).istroop).a(localSqlite.tbl_name, localEntityManager);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
              localObject1 = localObject2;
            }
          }
          if (localObject1 == null) {
            break label653;
          }
        } while (((AppConstants.DATALINE_PC_UIN.equals(((Message)localObject1).frienduin)) && (!localSqlite.tbl_name.equals(DataLineMsgRecord.tableName()))) || ((AppConstants.DATALINE_IPAD_UIN.equals(((Message)localObject1).frienduin)) && (!localSqlite.tbl_name.equals(DataLineMsgRecord.tableName(1)))));
        d((Message)localObject1);
        a((Message)localObject1);
        if (!bool1)
        {
          e((Message)localObject1);
          if (localList != null) {
            a(localList, (Message)localObject1);
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append("refreshCache message uin = ").append(((Message)localObject1).frienduin).append(", type = ").append(((Message)localObject1).istroop).append(", unread = ").append(((Message)localObject1).unReadNum).append(", time = ").append(((Message)localObject1).time);
          a(localStringBuilder.toString(), "");
        }
        localObject2 = a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
      } while ((!bool2) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2)));
      this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject1);
      j = i + 1;
      i = j;
      if (!bool1)
      {
        localConversationFacade.c(((Message)localObject1).frienduin, ((Message)localObject1).istroop, ((Message)localObject1).unReadNum);
        i = j;
      }
    }
    label653:
    for (;;)
    {
      break;
      j = 0;
      localEntityManager.close();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_TableNum", j + "");
      return;
    }
  }
  
  public void e(String paramString, int paramInt)
  {
    paramString = new QQMessageFacade.MessageNotifyParam(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public void e(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(8020, true, paramList);
    }
    QQGameHelper.a(paramList);
  }
  
  public boolean e(String paramString, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    List localList = b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      bool1 = false;
      return bool1;
    }
    if (localList.size() == 1)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(0);
      if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
        return false;
      }
      if (localMessageRecord.shmsgseq > Math.max(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString, paramInt)) + 1L) {}
      for (;;)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool2 + "; cacheList size = " + localList.size() + "; msgseq = " + localMessageRecord.shmsgseq + ", expiredSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramString) + ", delLastSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString, paramInt));
        return bool2;
        bool2 = false;
      }
    }
    if (localList.size() > 1)
    {
      paramString = (MessageRecord)localList.get(localList.size() - 1);
      if ((paramString.msgtype == -2006) || (!paramString.isValid)) {
        return false;
      }
      paramString = MsgProxyUtils.a(localList, false);
      if (paramString.size() < 10) {}
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool2 + "; cacheList size = " + localList.size() + "; continuedList size = " + paramString.size());
        return bool2;
      }
    }
    return false;
  }
  
  public MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).f(paramString, paramInt, paramLong);
  }
  
  public void f()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.query((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      int i = 0;
      while (i < ((Cursor)localObject1).getCount())
      {
        a(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
        ((Cursor)localObject1).moveToNext();
        i += 1;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      g();
      a(0).c();
      a(0).b();
      a(3000).c();
      a(3000).b();
      a(1).c();
      a(1).b();
      if ((FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().g();
        return;
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    QLog.e("Q.msg.QQMessageFacade", 1, "not support fts");
  }
  
  public void f(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
  }
  
  public boolean f(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(paramString, paramInt);
    }
    return false;
  }
  
  public void g()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1032).a(AppConstants.CONFESS_UIN, 1032);
    HashSet localHashSet = new HashSet(localList.size());
    int i = 0;
    if (i < localList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      int j;
      label71:
      String str;
      if (localMessageRecord.isSelfConfessor())
      {
        j = 1033;
        str = j + "&" + localMessageRecord.senderuin;
        if (!localHashSet.contains(str)) {
          break label127;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 1034;
        break label71;
        label127:
        localHashSet.add(str);
        a(localMessageRecord.senderuin, j, true, true);
      }
    }
    ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
  }
  
  public DraftSummaryInfo getDraftSummaryInfo(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public void h()
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.delete((String)localObject, null, null);
    localSQLiteDatabase.delete(str1, null, null);
    localSQLiteDatabase.delete(str2, null, null);
    localSQLiteDatabase.delete(str4, null, null);
    localSQLiteDatabase.delete(str3, null, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsg();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    localObject = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
    if (localObject != null)
    {
      ((RecommendTroopManagerImp)localObject).c();
      ((RecommendTroopManagerImp)localObject).a(1);
    }
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    j();
    localRecentUserProxy.a();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(false, true);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(true, true);
  }
  
  public void k()
  {
    g(AppConstants.SAME_STATE_BOX_UIN, 1009);
    g(AppConstants.LBS_HELLO_UIN, 1001);
    g(AppConstants.LBS_HELLO_UIN, 10002);
    g(AppConstants.DATE_UIN, 1010);
    g(AppConstants.MATCH_CHAT_UIN, 1044);
    g(AppConstants.QCIRCLE_CHAT_UIN, 10008);
  }
  
  /* Error */
  public void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 116	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 2966	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: aload_0
    //   8: getfield 116	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 1114	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 2972	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore 4
    //   20: aload 4
    //   22: ldc_w 2974
    //   25: lconst_0
    //   26: invokeinterface 2980 4 0
    //   31: lstore_2
    //   32: invokestatic 826	java/lang/System:currentTimeMillis	()J
    //   35: ldc2_w 2981
    //   38: ldiv
    //   39: lload_2
    //   40: lsub
    //   41: ldc2_w 2983
    //   44: lcmp
    //   45: ifge +4 -> 49
    //   48: return
    //   49: aload_0
    //   50: lload_2
    //   51: invokespecial 2986	com/tencent/imcore/message/QQMessageFacade:a	(J)V
    //   54: new 166	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 2988
    //   61: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: aload_0
    //   67: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: astore 7
    //   72: aload 7
    //   74: monitorenter
    //   75: new 58	java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: aload_0
    //   80: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   83: invokespecial 2991	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 61	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   92: invokevirtual 2992	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 6
    //   100: invokevirtual 548	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   103: invokeinterface 223 1 0
    //   108: astore 7
    //   110: aload 7
    //   112: invokeinterface 228 1 0
    //   117: ifeq +114 -> 231
    //   120: aload 7
    //   122: invokeinterface 232 1 0
    //   127: checkcast 286	java/lang/String
    //   130: astore 8
    //   132: aload 6
    //   134: aload 8
    //   136: invokevirtual 2993	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 83	java/lang/Integer
    //   142: invokevirtual 2996	java/lang/Integer:intValue	()I
    //   145: istore_1
    //   146: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +23 -> 172
    //   152: aload 5
    //   154: ldc_w 2998
    //   157: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 8
    //   162: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 3000
    //   168: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_0
    //   173: aload 8
    //   175: iload_1
    //   176: invokevirtual 3002	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)V
    //   179: goto -69 -> 110
    //   182: astore 4
    //   184: aload 4
    //   186: invokevirtual 583	java/lang/Exception:printStackTrace	()V
    //   189: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -144 -> 48
    //   195: ldc 164
    //   197: iconst_2
    //   198: new 166	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 3004
    //   208: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 4
    //   213: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: return
    //   223: astore 4
    //   225: aload 7
    //   227: monitorexit
    //   228: aload 4
    //   230: athrow
    //   231: aload 4
    //   233: invokeinterface 3008 1 0
    //   238: ldc_w 2974
    //   241: invokestatic 826	java/lang/System:currentTimeMillis	()J
    //   244: ldc2_w 2981
    //   247: ldiv
    //   248: invokeinterface 3014 4 0
    //   253: invokeinterface 3016 1 0
    //   258: pop
    //   259: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -214 -> 48
    //   265: ldc 164
    //   267: iconst_2
    //   268: aload 5
    //   270: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	QQMessageFacade
    //   145	31	1	i	int
    //   31	20	2	l	long
    //   18	3	4	localSharedPreferences	android.content.SharedPreferences
    //   182	30	4	localException	Exception
    //   223	9	4	localObject1	Object
    //   64	205	5	localStringBuilder	StringBuilder
    //   86	47	6	localConcurrentHashMap	ConcurrentHashMap
    //   130	44	8	str	String
    // Exception table:
    //   from	to	target	type
    //   49	54	182	java/lang/Exception
    //   75	98	223	finally
    //   225	228	223	finally
  }
  
  public void m()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f();
    if (localConcurrentHashMap.isEmpty()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "handleRevokeNotifyAfterSyncMsg");
    }
    Iterator localIterator = localConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList = (ArrayList)localConcurrentHashMap.get(localIterator.next());
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        int i = ((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_Int;
        if (i == 3000)
        {
          if (((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_JavaLangString) == null) {}
        }
        else
        {
          String str1;
          do
          {
            do
            {
              a(localArrayList, true);
              break;
            } while (i != 0);
            RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)localArrayList.get(0);
            String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            String str2 = localRevokeMsgInfo.jdField_b_of_type_JavaLangString;
            str1 = str2;
            if (TextUtils.equals(str3, str2)) {
              str1 = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
            }
          } while (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str1));
        }
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "notifyObservers() called with: data = [" + paramObject + "], costTime = [" + l + "]");
    }
    paramObject = MsgAutoMonitorUtil.getInstance();
    if (paramObject != null)
    {
      paramObject.addMsgObserverTime(l);
      paramObject.addMsgObserverNotifyNum();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a();
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a();
    this.jdField_a_of_type_Boolean = false;
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */