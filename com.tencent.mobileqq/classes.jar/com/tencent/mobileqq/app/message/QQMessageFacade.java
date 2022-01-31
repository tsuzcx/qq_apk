package com.tencent.mobileqq.app.message;

import aaaf;
import aaag;
import aaah;
import aaai;
import aaaj;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
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
import com.tencent.mobileqq.dating.MsgBoxProtocol;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class QQMessageFacade
  extends Observable
  implements Manager
{
  public static final Object a;
  private int jdField_a_of_type_Int = -1;
  public Handler a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseMessageManager jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  public MsgNotifyManager a;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private String jdField_a_of_type_JavaLangString;
  public final Map a;
  public final ConcurrentHashMap a;
  public final AtomicInteger a;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int = -1;
  private BaseMessageManager jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString;
  public Map b;
  public final ConcurrentHashMap b;
  private BaseMessageManager jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private final String jdField_c_of_type_JavaLangString = "Q.msg.QQMessageFacade";
  private Map jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private BaseMessageManager d;
  private BaseMessageManager e;
  
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
    a();
  }
  
  private int a(int paramInt)
  {
    int k = 0;
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    int j = i;
    if (localObject1 != null)
    {
      if (((Set)localObject1).isEmpty()) {
        j = i;
      }
    }
    else {
      return j;
    }
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("getUnreadMsgsNum type=" + paramInt + "{");; localStringBuilder = null)
    {
      localObject1 = ((Set)localObject1).iterator();
      i = k;
      label92:
      while (((Iterator)localObject1).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject1).next();
        if ((localConversationInfo != null) && (localConversationInfo.uin != null) && (!AppConstants.S.equals(localConversationInfo.uin)) && (!TextUtils.equals(AppConstants.as, localConversationInfo.uin)) && (!TextUtils.equals(AppConstants.at, localConversationInfo.uin)) && ((localConversationInfo.type != 1008) || (!ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localConversationInfo.uin))) && (localConversationInfo.type != 1033) && (localConversationInfo.type != 1034)) {
          if (localConversationInfo.type == 7000)
          {
            QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum subaccount info.uin=" + localConversationInfo.uin + "  info.type=" + localConversationInfo.type);
          }
          else
          {
            if (localConversationInfo.type == 1)
            {
              Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(localConversationInfo.uin, localConversationInfo.type);
              if ((localObject2 != null) && ((((RecentUser)localObject2).lFlag & 1L) != 0L))
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
                if ((localObject2 != null) && (!((HotChatManager)localObject2).b(localConversationInfo.uin)))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum invalide hotchat!");
                  continue;
                }
              }
            }
            j = a(localConversationInfo.type).a(paramInt, localConversationInfo);
            if ((QLog.isColorLevel()) && (localStringBuilder != null) && (j > 0)) {
              localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + j + "]");
            }
            if ((localConversationInfo.type != 1008) || (j <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(localConversationInfo.uin, 1008) <= 0)) {
              break label545;
            }
            j -= 1;
          }
        }
      }
      label545:
      for (;;)
      {
        i = j + i;
        break label92;
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        j = i;
        if (localStringBuilder == null) {
          break;
        }
        j = i;
        if (i <= 0) {
          break;
        }
        localStringBuilder.append("}");
        QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
        return i;
      }
    }
  }
  
  private MsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramString, paramInt, paramEntityManager, 0);
  }
  
  private QQMessageFacade.Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramEntityManager, paramInt2);
  }
  
  private String a(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  /* Error */
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 104	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   7: invokevirtual 204	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   10: iconst_1
    //   11: invokevirtual 275	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Z)Ljava/util/List;
    //   14: invokeinterface 278 1 0
    //   19: astore 8
    //   21: iconst_0
    //   22: istore_3
    //   23: iconst_0
    //   24: istore 4
    //   26: aload 8
    //   28: invokeinterface 155 1 0
    //   33: ifeq +422 -> 455
    //   36: aload 8
    //   38: invokeinterface 159 1 0
    //   43: checkcast 211	com/tencent/mobileqq/data/RecentUser
    //   46: astore 9
    //   48: iload 4
    //   50: iconst_1
    //   51: iadd
    //   52: istore 7
    //   54: iload_3
    //   55: istore 6
    //   57: iload 7
    //   59: istore 5
    //   61: aload 9
    //   63: getfield 281	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   66: lload_1
    //   67: lcmp
    //   68: ifle +377 -> 445
    //   71: aload 9
    //   73: getfield 282	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   76: getstatic 285	com/tencent/mobileqq/app/AppConstants:B	Ljava/lang/String;
    //   79: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +103 -> 185
    //   85: invokestatic 290	com/tencent/mobileqq/managers/TroopAssistantManager:a	()Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   88: aload_0
    //   89: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 293	com/tencent/mobileqq/managers/TroopAssistantManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   95: invokeinterface 278 1 0
    //   100: astore 9
    //   102: iload 7
    //   104: iconst_1
    //   105: isub
    //   106: istore 4
    //   108: aload 9
    //   110: invokeinterface 155 1 0
    //   115: ifeq +67 -> 182
    //   118: aload 9
    //   120: invokeinterface 159 1 0
    //   125: checkcast 295	com/tencent/mobileqq/data/TroopAssistantData
    //   128: astore 10
    //   130: iload 4
    //   132: iconst_1
    //   133: iadd
    //   134: istore 5
    //   136: iload 5
    //   138: istore 4
    //   140: aload 10
    //   142: getfield 296	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   145: lload_1
    //   146: lcmp
    //   147: ifle -39 -> 108
    //   150: iload_3
    //   151: iconst_1
    //   152: iadd
    //   153: istore_3
    //   154: aload_0
    //   155: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   158: aload 10
    //   160: getfield 299	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   163: iconst_1
    //   164: invokestatic 304	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   167: iconst_1
    //   168: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokevirtual 314	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: iload 5
    //   177: istore 4
    //   179: goto -71 -> 108
    //   182: goto -156 -> 26
    //   185: aload 9
    //   187: getfield 282	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   190: aload 9
    //   192: getfield 315	com/tencent/mobileqq/data/RecentUser:type	I
    //   195: invokestatic 318	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   198: ifeq +115 -> 313
    //   201: iload 7
    //   203: iconst_1
    //   204: isub
    //   205: istore 4
    //   207: aload_0
    //   208: aload 9
    //   210: getfield 282	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   213: aload 9
    //   215: getfield 315	com/tencent/mobileqq/data/RecentUser:type	I
    //   218: invokevirtual 321	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)Ljava/util/List;
    //   221: invokeinterface 278 1 0
    //   226: astore 9
    //   228: aload 9
    //   230: invokeinterface 155 1 0
    //   235: ifeq +75 -> 310
    //   238: aload 9
    //   240: invokeinterface 159 1 0
    //   245: checkcast 301	com/tencent/mobileqq/data/MessageRecord
    //   248: astore 10
    //   250: iload 4
    //   252: iconst_1
    //   253: iadd
    //   254: istore 5
    //   256: iload 5
    //   258: istore 4
    //   260: aload 10
    //   262: getfield 324	com/tencent/mobileqq/data/MessageRecord:time	J
    //   265: lload_1
    //   266: lcmp
    //   267: ifle -39 -> 228
    //   270: iload_3
    //   271: iconst_1
    //   272: iadd
    //   273: istore_3
    //   274: aload_0
    //   275: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   278: aload 10
    //   280: getfield 327	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   283: aload 10
    //   285: getfield 330	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   288: invokestatic 304	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   291: aload 10
    //   293: getfield 330	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   296: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: invokevirtual 314	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   302: pop
    //   303: iload 5
    //   305: istore 4
    //   307: goto -79 -> 228
    //   310: goto -128 -> 182
    //   313: iload_3
    //   314: istore 4
    //   316: aload 9
    //   318: getfield 282	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   321: invokestatic 335	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   324: invokevirtual 339	java/lang/Long:longValue	()J
    //   327: ldc2_w 340
    //   330: lcmp
    //   331: ifle +46 -> 377
    //   334: iload_3
    //   335: iconst_1
    //   336: iadd
    //   337: istore_3
    //   338: iload_3
    //   339: istore 4
    //   341: aload_0
    //   342: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   345: aload 9
    //   347: getfield 282	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   350: aload 9
    //   352: getfield 315	com/tencent/mobileqq/data/RecentUser:type	I
    //   355: invokestatic 304	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   358: aload 9
    //   360: getfield 315	com/tencent/mobileqq/data/RecentUser:type	I
    //   363: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: invokevirtual 314	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: iload 7
    //   372: istore 4
    //   374: goto -192 -> 182
    //   377: iload 7
    //   379: iconst_1
    //   380: isub
    //   381: istore 4
    //   383: goto -9 -> 374
    //   386: astore 9
    //   388: iload 7
    //   390: iconst_1
    //   391: isub
    //   392: istore_3
    //   393: aload 9
    //   395: invokevirtual 344	java/lang/NumberFormatException:printStackTrace	()V
    //   398: iload 4
    //   400: istore 6
    //   402: iload_3
    //   403: istore 5
    //   405: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +37 -> 445
    //   411: ldc 50
    //   413: iconst_2
    //   414: new 127	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 346
    //   424: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 9
    //   429: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iload_3
    //   439: istore 5
    //   441: iload 4
    //   443: istore 6
    //   445: iload 6
    //   447: istore_3
    //   448: iload 5
    //   450: istore 4
    //   452: goto -270 -> 182
    //   455: iload_3
    //   456: iload 4
    //   458: if_icmpne +173 -> 631
    //   461: aload_0
    //   462: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   465: invokevirtual 352	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   468: astore 10
    //   470: aload_0
    //   471: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   474: invokevirtual 355	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   477: astore 8
    //   479: aload 8
    //   481: ldc_w 357
    //   484: aconst_null
    //   485: invokevirtual 362	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   488: astore 9
    //   490: aload 9
    //   492: ifnull +140 -> 632
    //   495: aload 9
    //   497: astore 8
    //   499: aload 9
    //   501: invokeinterface 367 1 0
    //   506: ifeq +126 -> 632
    //   509: aload 9
    //   511: astore 8
    //   513: aload 9
    //   515: iconst_0
    //   516: invokeinterface 371 2 0
    //   521: invokestatic 376	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   524: astore 11
    //   526: aload 9
    //   528: astore 8
    //   530: aload 10
    //   532: aload 11
    //   534: invokeinterface 379 2 0
    //   539: ifne -44 -> 495
    //   542: aload 9
    //   544: astore 8
    //   546: aload_0
    //   547: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   550: aload 11
    //   552: aload 11
    //   554: invokestatic 383	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   557: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   560: invokevirtual 314	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: goto -69 -> 495
    //   567: astore 10
    //   569: aload 9
    //   571: astore 8
    //   573: aload 10
    //   575: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   578: aload 9
    //   580: astore 8
    //   582: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +34 -> 619
    //   588: aload 9
    //   590: astore 8
    //   592: ldc 50
    //   594: iconst_2
    //   595: new 127	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 346
    //   605: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 10
    //   610: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload 9
    //   621: ifnull +10 -> 631
    //   624: aload 9
    //   626: invokeinterface 387 1 0
    //   631: return
    //   632: aload 9
    //   634: ifnull -3 -> 631
    //   637: aload 9
    //   639: invokeinterface 387 1 0
    //   644: return
    //   645: astore 9
    //   647: aconst_null
    //   648: astore 8
    //   650: aload 8
    //   652: ifnull +10 -> 662
    //   655: aload 8
    //   657: invokeinterface 387 1 0
    //   662: aload 9
    //   664: athrow
    //   665: astore 9
    //   667: goto -17 -> 650
    //   670: astore 10
    //   672: aconst_null
    //   673: astore 9
    //   675: goto -106 -> 569
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	QQMessageFacade
    //   0	678	1	paramLong	long
    //   22	437	3	i	int
    //   24	435	4	j	int
    //   59	390	5	k	int
    //   55	391	6	m	int
    //   52	340	7	n	int
    //   19	637	8	localObject1	Object
    //   46	313	9	localObject2	Object
    //   386	42	9	localNumberFormatException	java.lang.NumberFormatException
    //   488	150	9	localCursor	Cursor
    //   645	18	9	localObject3	Object
    //   665	1	9	localObject4	Object
    //   673	1	9	localObject5	Object
    //   128	403	10	localObject6	Object
    //   567	42	10	localException1	Exception
    //   670	1	10	localException2	Exception
    //   524	29	11	str	String
    // Exception table:
    //   from	to	target	type
    //   316	334	386	java/lang/NumberFormatException
    //   341	370	386	java/lang/NumberFormatException
    //   499	509	567	java/lang/Exception
    //   513	526	567	java/lang/Exception
    //   530	542	567	java/lang/Exception
    //   546	564	567	java/lang/Exception
    //   479	490	645	finally
    //   499	509	665	finally
    //   513	526	665	finally
    //   530	542	665	finally
    //   546	564	665	finally
    //   573	578	665	finally
    //   582	588	665	finally
    //   592	619	665	finally
    //   479	490	670	java/lang/Exception
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    if (!AnonymousChatHelper.a(paramMessageRecord)) {
      paramString.a(paramMessageRecord);
    }
  }
  
  private void a(List paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    int i;
    if (QLog.isColorLevel())
    {
      if (paramList != null) {
        break label274;
      }
      i = 0;
    }
    long l2;
    label120:
    Object localObject3;
    for (;;)
    {
      a(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }), null);
      if ((paramList != null) && (paramList.isEmpty())) {}
      localObject1 = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      l2 = paramList.size();
      b(paramList);
      localObject2 = paramList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        i = FlashChatManager.a((MessageRecord)localObject3);
        if (i != -1) {}
        try
        {
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(i, (MessageRecord)localObject3);
          if (((MessageRecord)localObject3).msgtype == -2029) {
            QLog.d("VideoRedBag", 1, new Object[] { "onReceiveGrapTips, uniseq:", Long.valueOf(((MessageRecord)localObject3).uniseq), " uin:", ((MessageRecord)localObject3).frienduin, " type:", Integer.valueOf(((MessageRecord)localObject3).istroop) });
          }
          a(((MessageRecord)localObject3).istroop).a((MessageRecord)localObject3, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (BaseMessageManager.AddMessageContext)localObject1);
          break label120;
          label274:
          i = paramList.size();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner type " + i, localException2);
            }
          }
        }
      }
    }
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).g.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject3 = (String)paramEntityManager.next();
      localObject2 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      localObject3 = ((List)((BaseMessageManager.AddMessageContext)localObject1).g.get(localObject3)).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((EcShopAssistantManager)localObject2).a((MessageRecord)((Iterator)localObject3).next(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    ((BaseMessageManager.AddMessageContext)localObject1).g.clear();
    paramEntityManager = a();
    int j;
    if (paramEntityManager != null)
    {
      j = 0;
      if (paramEntityManager.istroop == 1)
      {
        localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramEntityManager.frienduin);
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((MessageInfo)localObject2).b() == paramEntityManager.shmsgseq) {
            i = ((MessageInfo)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramEntityManager.frienduin);
          }
        }
        paramEntityManager.bizType = i;
      }
    }
    else
    {
      localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label803;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject3 = (RecentUser)((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject3);
      try
      {
        HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject3);
        RecentUtil.a((RecentUser)localObject3, this);
        ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.a((RecentUser)localObject3);
        if (paramEntityManager == null) {
          continue;
        }
        if (paramEntityManager.istroop != 3000) {
          break label786;
        }
        ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(((RecentUser)localObject3).uin + "&" + 3000);
      }
      catch (Exception localException1) {}
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner --> Catch Exception .Info = " + localException1);
        continue;
        i = j;
        if (paramEntityManager.istroop != 3000) {
          break;
        }
        localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramEntityManager.frienduin + "&" + 3000);
        i = j;
        if (localObject2 == null) {
          break;
        }
        i = j;
        if (((MessageInfo)localObject2).b() != paramEntityManager.shmsgseq) {
          break;
        }
        i = ((MessageInfo)localObject2).a();
        break;
        label786:
        ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(localException1.uin);
      }
    }
    label803:
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      TroopAssistantManager.a().a((MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.get(localObject2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    paramEntityManager = (HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254);
    Object localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      paramEntityManager.a((MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.get(localObject4));
    }
    if (paramBoolean3) {
      ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade.a(paramList);
    }
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).d.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      localObject2 = (MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).d.get(localObject2);
      localObject2 = a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
      a((QQMessageFacade.Message)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + ((QQMessageFacade.Message)localObject2).frienduin + " , type = " + ((QQMessageFacade.Message)localObject2).istroop + " ,msgType:" + ((QQMessageFacade.Message)localObject2).msgtype + ", con = " + ((QQMessageFacade.Message)localObject2).getLogColorContent());
      }
    }
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
    MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l1, l2);
    paramEntityManager = ServiceAccountFolderManager.a();
    Object localObject1 = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (MessageRecord)paramList.next();
      paramEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject2);
      VideoReporter.a((MessageRecord)localObject2);
      if ((localObject1 != null) && (((ClassicHeadActivityManager)localObject1).a())) {
        ((ClassicHeadActivityManager)localObject1).b(((MessageRecord)localObject2).senderuin);
      }
      if (((localObject2 instanceof MessageForShortVideo)) && (((MessageForShortVideo)localObject2).redBagType == LocalMediaInfo.REDBAG_TYPE_GET))
      {
        localObject2 = (MessageForShortVideo)localObject2;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject2).shortVideoId, ((MessageForShortVideo)localObject2).uniseq, ((MessageForShortVideo)localObject2).redBagStat);
      }
    }
  }
  
  private void b(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
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
  
  private void c(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.v)) && (paramMessage.istroop == 1009))
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
        localEntityManager.a();
      }
    }
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
        if (MsgProxyUtils.c(localMessageRecord.senderuin))
        {
          g(localMessageRecord.senderuin, localMessageRecord.istroop);
        }
        else if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(localMessageRecord.senderuin))
        {
          a().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          QQMessageFacade.Message localMessage = a(localMessageRecord.senderuin, paramInt);
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = localRecentUserProxy.a(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          RecentUtil.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localRecentUserProxy.a(localRecentUser);
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
  
  public long a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString, 0);
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
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString, 0, 9223372036854775807L, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      l2 = ((QQMessageFacade.Message)localObject).shmsgseq;
      l1 = l2;
      if (((QQMessageFacade.Message)localObject).isLongMsg())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt);
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
      if (MsgProxyUtils.c(paramInt))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
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
              if (!MsgUtils.b(((MessageRecord)localObject).issend)) {
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
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString1, 0);
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
    if (paramInt == 1)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new TroopMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 3000)
    {
      if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new DiscMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 7000)
    {
      if (this.d == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.d == null) {
          this.d = new SubMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.d;
      }
    }
    if (paramInt == 1026)
    {
      if (this.e == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.e == null) {
          this.e = new HCTopicMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.e;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new C2CMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
    }
  }
  
  public C2CMessageManager a()
  {
    return (C2CMessageManager)a(0);
  }
  
  public ConversationFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
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
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a();
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = a(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject;
    if (localMessage != null)
    {
      localObject = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else
    {
      if (this.jdField_b_of_type_Int != 0) {
        break label148;
      }
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
      localStringBuilder.append("All-In");
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!MsgProxyUtils.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop)) {
        break;
      }
      ((QQMessageFacade.Message)localObject).istroop = MsgProxyUtils.a(((QQMessageFacade.Message)localObject).istroop);
      return localObject;
      label148:
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = localMessage;
        if (localMessage == null)
        {
          localObject = new QQMessageFacade.Message();
          ((QQMessageFacade.Message)localObject).frienduin = paramString;
          ((QQMessageFacade.Message)localObject).istroop = paramInt;
          ((QQMessageFacade.Message)localObject).isCacheValid = false;
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        }
        localStringBuilder.append("Not-Finish-Yet");
      }
      else
      {
        localObject = MessageRecord.getTableName(paramString, paramInt);
        String str2 = MessageRecord.getOldTableName(paramString, paramInt);
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if ((!localEntityManager.d((String)localObject)) && (!localEntityManager.d(str2))) {
          break label321;
        }
        localMessage = a(paramString, paramInt, localEntityManager);
        localStringBuilder.append("Check-DB");
        localObject = localMessage;
        if (localMessage == null)
        {
          localObject = new QQMessageFacade.Message();
          ((QQMessageFacade.Message)localObject).frienduin = paramString;
          ((QQMessageFacade.Message)localObject).istroop = paramInt;
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        }
        localEntityManager.a();
      }
    }
    label321:
    if (localMessage == null)
    {
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject = localMessage;
    }
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return b(paramString, paramInt1, paramInt2);
    }
    return a(paramString, paramInt1);
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    return a(paramSessionInfo.jdField_a_of_type_Int).a(paramSessionInfo, paramString);
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = a(paramInt).c(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public DraftSummaryInfo a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public MessageRecord a(QQMessageFacade.Message paramMessage)
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
      if (MsgProxyUtils.a(localMessageRecord, paramMessageRecord))
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
        if ((((MessageRecord)localObject2).isValid) && (!MsgProxyUtils.g(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramInt).b(paramString, paramInt, null);
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
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    return a(paramInt1).a(paramString1, paramInt1, paramLong1, paramString2, paramString3, paramLong2, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord);
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List paramList)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord, paramList);
    }
    return null;
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
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramContext).toString();
  }
  
  public String a(String paramString1, String paramString2, long paramLong)
  {
    int j = 0;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString1, 0, false, false);
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
  
  public List a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  public List a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List a(String paramString, int paramInt1, int paramInt2, int paramInt3)
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
  
  public List a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).b(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    paramString = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean);
    ChatMessage localChatMessage;
    if ((paramInt1 == 1001) || (paramInt1 == 10002) || (MsgProxyUtils.a(paramInt1) == 1032))
    {
      if (paramString == null) {}
      for (paramInt2 = 0;; paramInt2 = paramString.size())
      {
        paramInt2 -= 1;
        while (paramInt2 >= 0)
        {
          localChatMessage = (ChatMessage)paramString.get(paramInt2);
          if ((localChatMessage != null) && (localChatMessage.msgtype == -4011)) {
            paramString.remove(localChatMessage);
          }
          paramInt2 -= 1;
        }
      }
    }
    if (paramInt1 == 1008)
    {
      if (paramString == null) {}
      for (paramInt1 = i;; paramInt1 = paramString.size())
      {
        paramInt1 -= 1;
        for (;;)
        {
          if (paramInt1 < 0) {
            break label330;
          }
          localChatMessage = (ChatMessage)paramString.get(paramInt1);
          if (localChatMessage != null) {
            break;
          }
          paramInt1 -= 1;
        }
      }
      if (PAWeatherItemBuilder.a(localChatMessage.senderuin))
      {
        if (!(localChatMessage instanceof MessageForText)) {
          break label302;
        }
        if (!((MessageForText)localChatMessage).msg.startsWith(" ")) {
          paramString.remove(localChatMessage);
        }
      }
      for (;;)
      {
        if ((localChatMessage.msgtype == -5008) && (ArkAppCenter.c())) {
          paramString.remove(localChatMessage);
        }
        if ((localChatMessage.msgtype != -2011) || (!(localChatMessage instanceof MessageForStructing))) {
          break;
        }
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)localChatMessage).structingMsg;
        if ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgServiceID != 85)) {
          break;
        }
        paramString.remove(localChatMessage);
        break;
        label302:
        if ((!(localChatMessage instanceof MessageForArkApp)) && (!(localChatMessage instanceof MessageForStructing))) {
          paramString.remove(localChatMessage);
        }
      }
    }
    try
    {
      label330:
      Collections.sort(paramString, new aaah(this));
      return paramString;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.QQMessageFacade", 2, "Collections sort exception ! ", localException);
    }
    return paramString;
  }
  
  public List a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List a(String paramString, int paramInt, List paramList)
  {
    return a(paramInt).a(paramString, paramInt, paramList);
  }
  
  public List a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, -1L, paramBoolean);
  }
  
  public List a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return a(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public List a(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, paramArrayOfInt);
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
    if (MsgProxyUtils.a(paramString, paramInt))
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
            if (!MsgProxyUtils.c(((MessageRecord)localObject2).senderuin)) {
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
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop) <= 0) {
          break label628;
        }
        a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop, false, paramBoolean);
        localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(Long.valueOf(((MessageRecord)localObject3).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)((MessageRecord)localObject3).time);
        if (paramString != null) {
          break label625;
        }
        paramString = new msg_svc.PbC2CReadedReportReq();
        label279:
        paramString.pair_info.add((MessageMicro)localObject1);
      }
    }
    label291:
    label625:
    label628:
    for (;;)
    {
      break label156;
      if (MsgProxyUtils.d(((MessageRecord)localObject2).senderuin))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) > 0) {
          c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        }
        MsgBoxProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
        MsgBoxProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null);
        localObject1 = paramString;
        break;
      }
      localObject1 = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = null;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject2).iterator();
    Object localObject3;
    int i;
    label159:
    Object localObject4;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (ConversationInfo)localIterator.next();
        if ((ConversationFacade.a((ConversationInfo)localObject3) > 0) && (a().b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
          if (MsgProxyUtils.a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))
          {
            localObject3 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (localObject3 == null) {
              continue;
            }
            i = ((List)localObject3).size() - 1;
            if (i >= 0)
            {
              localObject4 = (MessageRecord)((List)localObject3).get(i);
              if (localObject4 == null) {
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label185:
      i -= 1;
      localObject1 = localObject2;
      break label159;
      label255:
      Object localObject5;
      if (MsgProxyUtils.c(((MessageRecord)localObject4).senderuin))
      {
        localObject4 = b(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
        localObject2 = localObject1;
        if (localObject4 == null) {
          continue;
        }
        localObject2 = localObject1;
        if (((List)localObject4).isEmpty()) {
          continue;
        }
        localObject2 = ((List)localObject4).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1220;
        }
        localObject5 = (MessageRecord)((Iterator)localObject2).next();
        a(((MessageRecord)localObject5).senderuin, ((MessageRecord)localObject5).istroop, true, paramBoolean);
        localObject4 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).peer_uin.set(Long.valueOf(((MessageRecord)localObject5).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).last_read_time.set((int)((MessageRecord)localObject5).time);
        if (localObject1 != null) {
          break label1217;
        }
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      label1214:
      label1217:
      for (;;)
      {
        ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject4);
        break label255;
        a(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).getConfessTopicId(), true, paramBoolean);
        localObject5 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).peer_uin.set(Long.valueOf(((MessageRecord)localObject4).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).last_read_time.set((int)((MessageRecord)localObject4).time);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new msg_svc.PbC2CReadedReportReq();
        }
        ((msg_svc.PbC2CReadedReportReq)localObject2).pair_info.add((MessageMicro)localObject5);
        localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject4).frienduin).append("}");
        break label185;
        break;
        if (7000 == ((ConversationInfo)localObject3).type)
        {
          if (AppConstants.w.equals(((ConversationInfo)localObject3).uin)) {
            break;
          }
          localObject2 = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          if (localObject2 == null) {
            break;
          }
          ((SubAccountManager)localObject2).b(((ConversationInfo)localObject3).uin);
          localObject2 = ((SubAccountManager)localObject2).a(((ConversationInfo)localObject3).uin);
          if (localObject2 == null) {
            break;
          }
          localObject3 = new msg_svc.PbBindUinMsgReadedConfirmReq();
          ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject3).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
          localPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject3);
          localStringBuilder.append("{SUBUIN}");
          break;
        }
        if ((!paramBoolean) && (((ConversationInfo)localObject3).type == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin))) {
          break;
        }
        long l;
        if ((1006 == ((ConversationInfo)localObject3).type) || ((MsgProxyUtils.c(((ConversationInfo)localObject3).type)) && (Long.valueOf(((ConversationInfo)localObject3).uin).longValue() > 10000L)))
        {
          a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
          l = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          if (l == -1L)
          {
            label705:
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
              if (localObject2 != null) {
                ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
              }
              localPbMsgReadedReportReq.c2c_read_report.set((MessageMicro)localObject1);
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
            }
            return localPbMsgReadedReportReq;
          }
          localObject4 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          localObject2 = ((ConversationInfo)localObject3).uin;
          if (1006 == ((ConversationInfo)localObject3).type) {
            localObject2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin);
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).peer_uin.set(Long.valueOf((String)localObject2).longValue());
          localStringBuilder.append("{C2C:").append(Long.valueOf((String)localObject2)).append(((ConversationInfo)localObject3).type).append("}");
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).last_read_time.set((int)l);
          if (localObject1 != null) {
            break label1214;
          }
          localObject1 = new msg_svc.PbC2CReadedReportReq();
        }
        for (;;)
        {
          ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject4);
          break;
          if (3000 == ((ConversationInfo)localObject3).type)
          {
            a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
            l = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (l == -1L) {
              break label705;
            }
            localObject2 = new msg_svc.PbDiscussReadedReportReq();
            ((msg_svc.PbDiscussReadedReportReq)localObject2).conf_uin.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
            ((msg_svc.PbDiscussReadedReportReq)localObject2).last_read_seq.set(l);
            localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject2);
            break;
          }
          if ((1 == ((ConversationInfo)localObject3).type) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type)))
          {
            a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
            HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin);
            l = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (l == -1L) {
              break label705;
            }
            if (!((ConversationInfo)localObject3).uin.matches("^\\d+$")) {
              break;
            }
            localObject2 = new msg_svc.PbGroupReadedReportReq();
            ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
            ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l);
            localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
            break;
          }
          if ((!AppConstants.am.equals(((ConversationInfo)localObject3).uin)) || (9999 != ((ConversationInfo)localObject3).type)) {
            break;
          }
          ((DingdongPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114)).a(true, true, false);
          break;
        }
      }
      label1220:
      localObject2 = localObject1;
    }
  }
  
  public void a()
  {
    ThreadManager.post(new aaaf(this), 10, null, false);
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(AppConstants.U);
    if (a().a(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      QQMessageFacade.Message localMessage = a(str, 4001);
      paramInt = a(4001).a(paramInt, localMessage);
      a().c(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4001));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i;
    if (this.jdField_b_of_type_Int == -1)
    {
      if (localEntityManager.d(ConversationInfo.getConversationInfoTableName()))
      {
        i = 1;
        this.jdField_b_of_type_Int = i;
      }
    }
    else
    {
      localObject = ((RecentUserProxy)localObject).a(true);
      i = j;
      if (localObject == null) {
        break label316;
      }
      i = j;
      if (((List)localObject).size() <= 0) {
        break label316;
      }
      i = ((List)localObject).size();
      if (paramInt <= 0) {
        break label372;
      }
      if (i <= paramInt) {
        break label257;
      }
      j = paramInt;
    }
    for (;;)
    {
      label117:
      if (k < j)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(k);
        a(localRecentUser.uin, localRecentUser.type, localEntityManager);
        if (k == 8)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        if (MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type))
        {
          if (!AppConstants.G.equals(localRecentUser.uin)) {
            break label263;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ae, localRecentUser.type)) {
            a(AppConstants.ae, localRecentUser.type, localEntityManager);
          }
        }
        for (;;)
        {
          k += 1;
          break label117;
          i = 0;
          break;
          j = i;
          break label117;
          if ((AppConstants.X.equals(localRecentUser.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.af, localRecentUser.type))) {
            a(AppConstants.af, localRecentUser.type, localEntityManager);
          }
        }
      }
      label257:
      label263:
      label316:
      if (paramBoolean) {
        b(localEntityManager);
      }
      if ((paramBoolean) || (((List)localObject).size() > 8))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      if ((paramInt != 0) && (paramInt < i)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      label372:
      j = i;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    ThreadManager.post(new aaaj(this, paramQQAppInterface, paramMessageRecord, paramArrayList, paramHongbaoParams), 8, null, false);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
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
  
  public void a(MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    if (localFileManagerEntity != null) {
      if ((paramMessageForFile.isSend()) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || (localFileManagerEntity.status == 3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile, localFileManagerEntity, new aaai(this, paramMessageForFile, localFileManagerEntity));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg uniseq[" + paramMessageForFile.uniseq + "], sendUin[" + FileManagerUtil.e(paramMessageForFile.senderuin) + "], type[" + paramMessageForFile.istroop + "], Entity is Null, return");
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        ((TransFileController)localObject2).a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.a((MessageForShortVideo)localObject1);
      }
    }
    else
    {
      if (paramMessageRecord.isSendFromLocal()) {
        break label78;
      }
    }
    for (;;)
    {
      return;
      ((TransFileController)localObject2).b(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label78:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
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
        localObject3 = ((TransFileController)localObject1).a(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject3).h();
          ((TransFileController)localObject1).a(paramMessageRecord);
        }
        i += 1;
      }
    }
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramInt);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      localEntityManager.a();
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
      b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      c(localArrayList);
      return;
    }
    finally
    {
      paramString.a();
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
      c(localArrayList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramRecentUser, false);
    a(paramRecentUser.uin, paramRecentUser.type, true, true);
    if (paramRecentUser.type == 1) {
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin);
    }
  }
  
  public void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
    localObject = paramEntityManager.a(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
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
    paramString = (ArrayList)localEntityManager.a(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localEntityManager.b((TransFileInfo)paramString.next());
      }
    }
    localEntityManager.a();
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgExtraFlagByuniseq: peerUin = " + paramString + " type = " + paramInt1 + " uniseq = " + paramLong);
    }
    MessageRecord localMessageRecord = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    MessageRecord localMessageRecord = a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
    a(paramInt).a(paramString, paramInt, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    MsgProxy localMsgProxy = a(paramInt);
    MessageRecord localMessageRecord = null;
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy))
    {
      localMessageRecord = ((TroopAndDiscMsgProxy)localMsgProxy).b(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(paramLong1, paramLong2);
    }
    a(paramInt).a(paramString, paramInt, localMessageRecord, 3);
    a(paramString, paramInt, paramLong2);
    setChanged();
    notifyObservers(localMessageRecord);
    if (localMessageRecord == null) {}
    do
    {
      return;
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while ((!paramString.e()) || ((!paramString.e(localMessageRecord)) && (!paramString.b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq))));
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
    }
    paramString.f(null);
    a(paramInt).b();
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
        QLog.d("Q.msg.QQMessageFacade", 2, "refreshMessageListHeadByAIOBreak numTroopRefresh = " + paramRefreshMessageContext.h + ", count = " + i);
      }
      if (i <= 0) {
        break;
      }
      paramRefreshMessageContext.h = true;
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
  
  public void a(String paramString, int paramInt, List paramList)
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
      paramString.a();
      c(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
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
  
  public void a(String paramString, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      a("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    a("------------" + paramString + "-------------- is null", "");
  }
  
  public void a(ArrayList paramArrayList)
  {
    a(((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int).a(paramArrayList);
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.a();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        paramString = MsgProxyUtils.a(paramArrayList);
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
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramString = MsgProxyUtils.a(paramArrayList);
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
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramString = MsgProxyUtils.a(paramArrayList);
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
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    int i;
    do
    {
      return;
      i = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int;
      a(i).b(paramArrayList);
    } while ((!paramBoolean) || ((i != 1) && (i != 3000)));
    paramArrayList = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
    a(paramArrayList, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList, i));
  }
  
  public void a(List paramList)
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
    c(paramList);
  }
  
  public void a(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, true);
      paramString.a();
      paramString = MsgProxyUtils.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      c(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList.size() != 0) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, true, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Int >= 0);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    QQMessageFacade.Message localMessage = a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (MsgProxyUtils.c(paramMessageRecord.istroop)) {
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
    localStringBuilder.append("select count() as counter, 'x' as msgData from ").append(paramString).append(" where issend=0 and isValid=1 and msgtype ").append(MsgProxyUtils.a());
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(QQMessageFacade.Message.class, localStringBuilder.toString(), null);
    if ((paramString != null) && (paramString.size() > 0)) {
      return ((QQMessageFacade.Message)paramString.get(0)).counter > 0;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (MsgProxyUtils.m(paramInt2))
    {
      bool1 = bool2;
      if (MsgProxyUtils.g(paramInt2))
      {
        bool1 = bool2;
        if (a(paramInt1).e(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List paramList, boolean paramBoolean)
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
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
    }
    a("refresh C2C autopull, size = " + paramString.size(), ", timestamp = " + System.currentTimeMillis());
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramBoolean = true;
    boolean bool = true;
    List localList = b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    if (localList.size() == 1)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(0);
      if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
        return false;
      }
      if (localMessageRecord.shmsgseq > Math.max(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt)) + 1L) {}
      for (;;)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; msgseq = " + localMessageRecord.shmsgseq + ", expiredSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString) + ", delLastSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt));
        return bool;
        bool = false;
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
      for (bool = paramBoolean;; bool = false)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; continuedList size = " + paramString.size());
        return bool;
      }
    }
    return false;
  }
  
  public int b()
  {
    Object localObject1 = new StringBuilder(168);
    int j = a(2);
    if (j != 0) {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j) }));
    }
    int i = j;
    int k;
    if (a().b(AppConstants.S, 9000))
    {
      k = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((k != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + k);
      }
      i = j + k;
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.S, Integer.valueOf(9000), Integer.valueOf(k) }));
    }
    j = i;
    if (a().b(AppConstants.au, 7230))
    {
      k = ServiceAccountFolderManager.a().b();
      j = i + k;
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.au, Integer.valueOf(7230), Integer.valueOf(k) }));
    }
    i = j;
    j = i;
    Object localObject2;
    if (TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject2 = ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).a(46, false);
      if ((localObject2 != null) && (((oidb_0x791.RedDotInfo)localObject2).uint32_number.has()))
      {
        j = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();
        j = i + j;
      }
    }
    else
    {
      i = j;
      if (!ReadInJoyHelper.h())
      {
        i = j;
        if (a().b(AppConstants.at, 7220))
        {
          localObject2 = b(AppConstants.at, 7220);
          if ((localObject2 == null) || (((MessageRecord)localObject2).isread) || (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) != 1)) {
            break label619;
          }
          i = j + 1;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.at, Integer.valueOf(7220), Integer.valueOf(1) }));
        }
      }
    }
    for (;;)
    {
      j = i;
      if (a().b(AppConstants.an, 9003))
      {
        localObject2 = (BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137);
        j = i;
        if (localObject2 != null)
        {
          k = ((BlessManager)localObject2).b();
          j = i + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.an, Integer.valueOf(9003), Integer.valueOf(k) }));
        }
      }
      i = j;
      if (a().b(AppConstants.w, 7000))
      {
        k = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
        i = j + k;
        ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.w, Integer.valueOf(7000), Integer.valueOf(k) }));
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!((String)localObject1).equals(this.jdField_b_of_type_JavaLangString))
      {
        QLog.d("Q.msg.QQMessageFacade_UnreadMonitor", 1, "Recent Msg Unread: " + (String)localObject1);
        this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      }
      return i;
      j = 0;
      break;
      label619:
      Object localObject3 = RecentDataListManager.a(AppConstants.at, 7220);
      localObject3 = RecentDataListManager.a().a((String)localObject3);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((RecentBaseData)localObject3).jdField_b_of_type_Int == 1)
        {
          i = j;
          if (localObject2 != null)
          {
            i = j;
            if (!((MessageRecord)localObject2).isread)
            {
              i = j + 1;
              ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.at, Integer.valueOf(7220), Integer.valueOf(1) }));
            }
          }
        }
      }
    }
  }
  
  public QQMessageFacade.Message b(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str1 = a(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject = localMessage;
    EntityManager localEntityManager;
    if (localMessage == null)
    {
      localObject = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((!localEntityManager.d((String)localObject)) && (!localEntityManager.d(str2))) {
        break label135;
      }
      paramString = a(paramString, paramInt, localEntityManager);
    }
    for (;;)
    {
      localEntityManager.a();
      localObject = paramString;
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!MsgProxyUtils.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop)) {
        break;
      }
      ((QQMessageFacade.Message)localObject).istroop = MsgProxyUtils.a(((QQMessageFacade.Message)localObject).istroop);
      return localObject;
      label135:
      if (localMessage == null)
      {
        localObject = new QQMessageFacade.Message();
        ((QQMessageFacade.Message)localObject).frienduin = paramString;
        ((QQMessageFacade.Message)localObject).istroop = paramInt;
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
  
  public QQMessageFacade.Message b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      paramString = new QQMessageFacade.Message();
    }
    StringBuilder localStringBuilder;
    String str;
    QQMessageFacade.Message localMessage;
    Object localObject;
    do
    {
      do
      {
        return paramString;
        localStringBuilder = new StringBuilder("Case:");
        str = a(paramString, paramInt1);
        localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str);
        if ((localMessage != null) && (localMessage.isCacheValid))
        {
          localObject = localMessage;
          if (localMessage.getConfessTopicId() == paramInt2) {}
        }
        else
        {
          localObject = MessageRecord.getTableName(paramString, paramInt1);
          EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (!localEntityManager.d((String)localObject)) {
            break;
          }
          localMessage = a(paramString, paramInt1, localEntityManager, paramInt2);
          localStringBuilder.append("Check-DB");
          localObject = localMessage;
          if (localMessage == null)
          {
            localObject = new QQMessageFacade.Message();
            ((QQMessageFacade.Message)localObject).frienduin = paramString;
            ((QQMessageFacade.Message)localObject).istroop = paramInt1;
            ((QQMessageFacade.Message)localObject).setConfessTopicId(paramInt2);
            this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
          }
          localEntityManager.a();
        }
        paramString = (String)localObject;
      } while (localObject == null);
      paramString = (String)localObject;
    } while (!MsgProxyUtils.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop));
    ((QQMessageFacade.Message)localObject).istroop = MsgProxyUtils.a(((QQMessageFacade.Message)localObject).istroop);
    return localObject;
    if (localMessage == null)
    {
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt1;
      ((QQMessageFacade.Message)localObject).setConfessTopicId(paramInt2);
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
        if ((((MessageRecord)localObject2).isValid) && (!MsgProxyUtils.g(((MessageRecord)localObject2).msgtype)))
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
      QQMessageFacade.Message localMessage = a(paramString, paramInt);
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
        return a(paramInt).b(paramString, paramInt, null);
      }
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public MessageRecord b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt).b(paramString1, paramInt, paramString2);
  }
  
  public String b(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
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
  
  public List b(String paramString, int paramInt)
  {
    return a(paramInt).b(paramString, paramInt);
  }
  
  public List b(String paramString, int paramInt1, int paramInt2)
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
  
  public List b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4001).b(String.valueOf(AppConstants.U), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt);
    } while (a(4001).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(AppConstants.S);
    notifyObservers(localObject);
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a(paramMessage);
  }
  
  public void b(MessageRecord paramMessageRecord)
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
      ((TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(207)).a(paramMessageRecord);
    }
    for (;;)
    {
      a(paramMessageRecord.istroop).c(paramMessageRecord);
      return;
      if (paramMessageRecord.msgtype == -1049)
      {
        MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
        if (localMessageForReplyText.mSourceMsgInfo.mType == 2) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(localMessageForReplyText);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    b(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (GoldMsgChatHelper.a(paramMessageRecord, paramMessageObserver, paramBoolean)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new aaag(this, paramMessageRecord, paramMessageObserver, paramBoolean), 10, null, false);
      return;
    }
    c(paramMessageRecord, paramMessageObserver, paramBoolean);
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString)
  {
    a(paramMessageRecord, MessageHandler.jdField_d_of_type_Int);
  }
  
  public void b(String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1052);
    localMessageRecord.msg = paramString;
    localMessageRecord.frienduin = AppConstants.av;
    localMessageRecord.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.time = MessageCache.a();
    localMessageRecord.msgseq = ((int)localMessageRecord.time);
    localMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, null, true);
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 355	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   7: astore 13
    //   9: aload 13
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload 13
    //   17: aload_1
    //   18: invokevirtual 1879	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)I
    //   21: istore_3
    //   22: iload_3
    //   23: sipush 6000
    //   26: if_icmple -12 -> 14
    //   29: iload_3
    //   30: sipush 5000
    //   33: isub
    //   34: sipush 1200
    //   37: invokestatic 1882	java/lang/Math:max	(II)I
    //   40: istore 4
    //   42: aload_0
    //   43: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: invokevirtual 662	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   49: invokevirtual 1885	com/tencent/mobileqq/persistence/EntityManagerFactory:createMessageRecordEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   52: checkcast 1887	com/tencent/mobileqq/persistence/MessageRecordEntityManager
    //   55: astore 14
    //   57: aload 14
    //   59: invokevirtual 1890	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   62: astore 12
    //   64: iload 4
    //   66: sipush 2500
    //   69: idiv
    //   70: iconst_1
    //   71: iadd
    //   72: istore 5
    //   74: iload 4
    //   76: iload 5
    //   78: idiv
    //   79: istore 6
    //   81: iconst_0
    //   82: istore_3
    //   83: iload_3
    //   84: iload 5
    //   86: if_icmpge +556 -> 642
    //   89: iload_2
    //   90: ifne +371 -> 461
    //   93: ldc_w 1892
    //   96: iconst_3
    //   97: anewarray 27	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_1
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: iload 6
    //   112: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: invokestatic 422	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   119: astore 9
    //   121: ldc_w 1894
    //   124: iconst_3
    //   125: anewarray 27	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_1
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload_1
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: iload 6
    //   140: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: invokestatic 422	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   147: astore 10
    //   149: invokestatic 411	java/lang/System:currentTimeMillis	()J
    //   152: lstore 7
    //   154: aload 12
    //   156: ifnull +8 -> 164
    //   159: aload 12
    //   161: invokevirtual 1897	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   164: aload 14
    //   166: aload 10
    //   168: aconst_null
    //   169: aload_0
    //   170: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   173: invokevirtual 1900	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   176: astore 10
    //   178: aload 10
    //   180: ifnull +418 -> 598
    //   183: aload 10
    //   185: invokeinterface 278 1 0
    //   190: astore 11
    //   192: aload 11
    //   194: invokeinterface 155 1 0
    //   199: ifeq +399 -> 598
    //   202: aload 11
    //   204: invokeinterface 159 1 0
    //   209: checkcast 301	com/tencent/mobileqq/data/MessageRecord
    //   212: astore 15
    //   214: aload 15
    //   216: invokevirtual 1903	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   219: ifeq -27 -> 192
    //   222: aload 15
    //   224: getfield 904	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   227: ifeq -35 -> 192
    //   230: aload 15
    //   232: getfield 451	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   235: sipush -2006
    //   238: if_icmpeq -46 -> 192
    //   241: aload 15
    //   243: invokestatic 1908	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/fts/FTSMessage;
    //   246: astore 15
    //   248: aload 15
    //   250: invokevirtual 1913	com/tencent/mobileqq/data/fts/FTSMessage:deleteOpt	()V
    //   253: aload 14
    //   255: aload 15
    //   257: invokestatic 1916	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/fts/FTSMessage;)Lcom/tencent/mobileqq/data/FTSMessageSync;
    //   260: invokevirtual 1919	com/tencent/mobileqq/persistence/MessageRecordEntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   263: goto -71 -> 192
    //   266: astore 11
    //   268: aload 10
    //   270: astore 9
    //   272: aload 11
    //   274: astore 10
    //   276: aload 10
    //   278: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   281: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +30 -> 314
    //   287: ldc 50
    //   289: iconst_2
    //   290: new 127	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 1921
    //   300: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 10
    //   305: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload 9
    //   316: astore 10
    //   318: aload 12
    //   320: ifnull +12 -> 332
    //   323: aload 12
    //   325: invokevirtual 1922	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   328: aload 9
    //   330: astore 10
    //   332: aload 10
    //   334: ifnull +120 -> 454
    //   337: aload 10
    //   339: invokeinterface 433 1 0
    //   344: ifle +110 -> 454
    //   347: aload_0
    //   348: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   351: sipush 200
    //   354: invokevirtual 445	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   357: checkcast 1924	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager
    //   360: astore 9
    //   362: aload 9
    //   364: ifnull +11 -> 375
    //   367: aload 9
    //   369: aload_1
    //   370: aload 10
    //   372: invokevirtual 1927	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:a	(Ljava/lang/String;Ljava/util/List;)V
    //   375: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +76 -> 454
    //   381: ldc 50
    //   383: iconst_2
    //   384: new 127	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 1929
    //   394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_1
    //   398: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc_w 1008
    //   404: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: iload 6
    //   409: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc_w 1931
    //   415: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: iload_3
    //   419: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc_w 1931
    //   425: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: iload 4
    //   430: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc_w 1933
    //   436: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokestatic 411	java/lang/System:currentTimeMillis	()J
    //   442: lload 7
    //   444: lsub
    //   445: invokevirtual 1148	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: iload_3
    //   455: iconst_1
    //   456: iadd
    //   457: istore_3
    //   458: goto -375 -> 83
    //   461: iload_2
    //   462: iconst_1
    //   463: if_icmpeq +17 -> 480
    //   466: iload_2
    //   467: sipush 3000
    //   470: if_icmpeq +10 -> 480
    //   473: iload_2
    //   474: sipush 1026
    //   477: if_icmpne +62 -> 539
    //   480: ldc_w 1935
    //   483: iconst_3
    //   484: anewarray 27	java/lang/Object
    //   487: dup
    //   488: iconst_0
    //   489: aload_1
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: aload_1
    //   494: aastore
    //   495: dup
    //   496: iconst_2
    //   497: iload 6
    //   499: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   502: aastore
    //   503: invokestatic 422	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   506: astore 9
    //   508: ldc_w 1937
    //   511: iconst_3
    //   512: anewarray 27	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: aload_1
    //   518: aastore
    //   519: dup
    //   520: iconst_1
    //   521: aload_1
    //   522: aastore
    //   523: dup
    //   524: iconst_2
    //   525: iload 6
    //   527: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: invokestatic 422	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   534: astore 10
    //   536: goto -387 -> 149
    //   539: ldc_w 1939
    //   542: iconst_3
    //   543: anewarray 27	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: aload_1
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: aload_1
    //   553: aastore
    //   554: dup
    //   555: iconst_2
    //   556: iload 6
    //   558: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   561: aastore
    //   562: invokestatic 422	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   565: astore 9
    //   567: ldc_w 1941
    //   570: iconst_3
    //   571: anewarray 27	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: aload_1
    //   577: aastore
    //   578: dup
    //   579: iconst_1
    //   580: aload_1
    //   581: aastore
    //   582: dup
    //   583: iconst_2
    //   584: iload 6
    //   586: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   589: aastore
    //   590: invokestatic 422	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   593: astore 10
    //   595: goto -446 -> 149
    //   598: aload 13
    //   600: aload 9
    //   602: invokevirtual 1942	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   605: pop
    //   606: aload 12
    //   608: ifnull +8 -> 616
    //   611: aload 12
    //   613: invokevirtual 1943	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   616: aload 12
    //   618: ifnull +38 -> 656
    //   621: aload 12
    //   623: invokevirtual 1922	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   626: goto -294 -> 332
    //   629: astore_1
    //   630: aload 12
    //   632: ifnull +8 -> 640
    //   635: aload 12
    //   637: invokevirtual 1922	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   640: aload_1
    //   641: athrow
    //   642: aload 14
    //   644: invokevirtual 1944	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   647: return
    //   648: astore 10
    //   650: aconst_null
    //   651: astore 9
    //   653: goto -377 -> 276
    //   656: goto -324 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	QQMessageFacade
    //   0	659	1	paramString	String
    //   0	659	2	paramInt	int
    //   21	437	3	i	int
    //   40	389	4	j	int
    //   72	15	5	k	int
    //   79	506	6	m	int
    //   152	291	7	l	long
    //   119	533	9	localObject1	Object
    //   147	447	10	localObject2	Object
    //   648	1	10	localException1	Exception
    //   190	13	11	localIterator	Iterator
    //   266	7	11	localException2	Exception
    //   62	574	12	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   7	592	13	localSQLiteDatabase	SQLiteDatabase
    //   55	588	14	localMessageRecordEntityManager	com.tencent.mobileqq.persistence.MessageRecordEntityManager
    //   212	44	15	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   183	192	266	java/lang/Exception
    //   192	263	266	java/lang/Exception
    //   598	606	266	java/lang/Exception
    //   611	616	266	java/lang/Exception
    //   159	164	629	finally
    //   164	178	629	finally
    //   183	192	629	finally
    //   192	263	629	finally
    //   276	314	629	finally
    //   598	606	629	finally
    //   611	616	629	finally
    //   159	164	648	java/lang/Exception
    //   164	178	648	java/lang/Exception
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong, true);
  }
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.b(localMessageRecord);
    if (a(paramInt).c(paramString, paramInt, paramLong) == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, localMessageRecord);
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
            if (MsgProxyUtils.a(localMessageRecord, a(localMessageRecord.frienduin, localMessageRecord.istroop))) {
              paramInt = 1;
            }
          }
          while (paramInt != 0)
          {
            if (!MsgProxyUtils.r(localMessageRecord.istroop)) {
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
  
  public void b(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
        if ((localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 98))
        {
          paramList = (NearbyGrayTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner will insert a face score message, msg = " + localMessageForStructing);
          }
          boolean bool2 = FaceScoreUtils.a(localMessageForStructing, "isFaceScoreSecondMember");
          Object localObject = paramList.b(1, 2, localMessageRecord.time);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getValidConfigForFaceScore, flag = " + bool2 + ", configForFaceScore = " + localObject);
          }
          if (localObject != null)
          {
            int i = StructMsgItemLayout26.a(localMessageForStructing.structingMsg.mExtraData);
            paramList = new Random();
            paramList.setSeed(localMessageRecord.time);
            boolean bool1;
            if ((i & 0x4) != 0)
            {
              bool1 = true;
              label223:
              if (!bool1) {
                break label467;
              }
              if (!bool2) {
                break label457;
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
              MsgProxyUtils.a((MessageRecord)localObject, MsgProxyUtils.c(localMessageForStructing));
              a((MessageRecord)localObject, localMessageRecord.selfuin);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner insert faceScore gray tips., msg = " + localObject);
              break;
              bool1 = false;
              break label223;
              label457:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getFavoriteGrayTipWording2(paramList);
              continue;
              label467:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getGrayTipWording(paramList);
            }
          }
        }
      }
    }
  }
  
  public void b(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, false, false, true, false);
      paramString.a();
      paramString = MsgProxyUtils.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      c(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      paramString = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public int c()
  {
    return a(7);
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).c(paramString, paramInt, paramLong);
  }
  
  public String c(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramContext = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(paramContext, paramMessageRecord);
    paramContext.emoRecentMsg = null;
    paramContext.fileType = -1;
    a(paramContext);
    return MsgUtils.a(paramContext.nickName, 0.4F);
  }
  
  public void c()
  {
    a(0).c();
    a(3000).c();
    a(1).c();
    a(1026).c();
  }
  
  public void c(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
      }
      if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1049)) {
        if (paramMessageRecord.istroop == 1001)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.frienduin))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + paramMessageRecord.getMessage(), paramMessageRecord);
        return;
        if (paramMessageRecord.istroop == 1003)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
        return;
        if ((paramMessageRecord.msgtype == -2011) || (paramMessageRecord.msgtype == -2007) || (paramMessageRecord.msgtype == -2002) || (paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2010) || (paramMessageRecord.msgtype == -2020) || (paramMessageRecord.msgtype == -2022) || (paramMessageRecord.msgtype == -2039) || (paramMessageRecord.msgtype == -5008) || (paramMessageRecord.msgtype == -5012) || (paramMessageRecord.msgtype == -5018) || (paramMessageRecord.msgtype == -1051) || (paramMessageRecord.msgtype == -2051) || (paramMessageRecord.msgtype == -1035) || (paramMessageRecord.msgtype == -2056) || (paramMessageRecord.msgtype == -2057) || (paramMessageRecord.msgtype == -2058) || (paramMessageRecord.msgtype == -7001) || (paramMessageRecord.msgtype == -5013) || (paramMessageRecord.msgtype == -5014) || (paramMessageRecord.msgtype == -5016) || (paramMessageRecord.msgtype == -5017) || (paramMessageRecord.msgtype == -7002)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramMessageObserver, paramBoolean);
        }
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    a(paramString, paramInt, true, false);
  }
  
  public void c(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(8020, true, paramList);
    }
  }
  
  public void c(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.a();
      paramString = MsgProxyUtils.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      c(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean c(String paramString, int paramInt)
  {
    return d(paramString, paramInt);
  }
  
  public int d()
  {
    return a(9);
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).d(paramString, paramInt, paramLong);
  }
  
  public void d()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    boolean bool;
    int i;
    if (this.jdField_b_of_type_Int == -1)
    {
      bool = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i = 1;
        this.jdField_b_of_type_Int = i;
      }
    }
    for (;;)
    {
      localEntityManager.a();
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
  
  public void d(String paramString, int paramInt)
  {
    a(paramInt).b(paramString, paramInt, false, false);
  }
  
  public boolean d(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).i(paramString, paramInt, paramLong);
  }
  
  public void e()
  {
    a("refreshCache", "");
    System.currentTimeMillis();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localEntityManager.a(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    boolean bool1;
    ConversationFacade localConversationFacade;
    StringBuilder localStringBuilder;
    int i;
    int j;
    boolean bool2;
    Object localObject2;
    if (localObject1 != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
      bool1 = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      localConversationFacade = a();
      localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      i = 0;
      Object localObject3;
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
            localObject3 = (Sqlite)localIterator.next();
            ((Sqlite)localObject3).tbl_name = SecurityUtile.b(((Sqlite)localObject3).tbl_name);
          } while ((((Sqlite)localObject3).tbl_name.equals("mr_fileManager")) || (((Sqlite)localObject3).tbl_name.startsWith("mr_confess_a")) || (((Sqlite)localObject3).tbl_name.startsWith("mr_confess_b")));
          bool2 = ((Sqlite)localObject3).tbl_name.endsWith("_New");
          localObject2 = a(MsgProxyUtils.a(((Sqlite)localObject3).tbl_name)).a(((Sqlite)localObject3).tbl_name, localEntityManager);
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
          }
        } while ((localObject2 == null) || ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).frienduin == null)));
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
          {
            a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
            localObject2 = a(((QQMessageFacade.Message)localObject2).istroop).a(((Sqlite)localObject3).tbl_name, localEntityManager);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 == null) {
          break label1081;
        }
      } while (((AppConstants.y.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName()))) || ((AppConstants.z.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName(1)))));
      if (((!AppConstants.G.equals(((QQMessageFacade.Message)localObject1).frienduin)) && ((MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) == 10002) || (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) == 1001))) || ((!AppConstants.X.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) == 1010)))
      {
        localObject2 = a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if ((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin)) && (!MessageUtils.a(((MessageRecord)localObject3).msgtype)))
            {
              ((QQMessageFacade.Message)localObject1).hasReply = true;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
              }
            }
          }
        }
      }
      a((QQMessageFacade.Message)localObject1);
      if (!bool1)
      {
        c((QQMessageFacade.Message)localObject1);
        if (localList != null)
        {
          j = 0;
          label687:
          if (j < localList.size())
          {
            localObject2 = (RecentUser)localList.get(j);
            if ((localObject2 == null) || (((RecentUser)localObject2).uin == null) || (!((RecentUser)localObject2).uin.equals(((QQMessageFacade.Message)localObject1).frienduin))) {
              break label1037;
            }
            if ((MsgProxyUtils.r(((QQMessageFacade.Message)localObject1).istroop)) && (a().a(((QQMessageFacade.Message)localObject1).frienduin, MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop))))
            {
              if (((QQMessageFacade.Message)localObject1).istroop != 1009) {
                a(AppConstants.v, 1009, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              }
              if (((QQMessageFacade.Message)localObject1).istroop == 1001) {
                break label1001;
              }
              a(AppConstants.G, 1001, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
          }
        }
      }
    }
    label1037:
    label1081:
    label1082:
    for (;;)
    {
      label840:
      localStringBuilder.setLength(0);
      localStringBuilder.append("refreshCache message uin = ").append(((QQMessageFacade.Message)localObject1).frienduin).append(", type = ").append(((QQMessageFacade.Message)localObject1).istroop).append(", unread = ").append(((QQMessageFacade.Message)localObject1).unReadNum).append(", time = ").append(((QQMessageFacade.Message)localObject1).time);
      a(localStringBuilder.toString(), "");
      localObject2 = a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      if ((!bool2) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject1);
      j = i + 1;
      i = j;
      if (!bool1)
      {
        localConversationFacade.b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, ((QQMessageFacade.Message)localObject1).unReadNum);
        i = j;
      }
      for (;;)
      {
        break;
        label1001:
        if (((QQMessageFacade.Message)localObject1).istroop == 10002) {
          break label1082;
        }
        a(AppConstants.G, 10002, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        break label840;
        j += 1;
        break label687;
        j = 0;
        localEntityManager.a();
        MsgAutoMonitorUtil.a().a("MSG_TableNum", j + "");
        return;
      }
    }
  }
  
  public void e(String paramString, int paramInt)
  {
    paramString = new QQMessageFacade.MessageNotifyParam(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public boolean e(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(paramString, paramInt);
    }
    return false;
  }
  
  public void f()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.a((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
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
      a(0).e();
      a(0).d();
      a(3000).e();
      a(3000).d();
      a(1).e();
      a(1).d();
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public void f(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
  }
  
  public void g()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1032).a(AppConstants.aF, 1032);
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
  
  public void h()
  {
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.a((String)localObject, null, null);
    localSQLiteDatabase.a(str1, null, null);
    localSQLiteDatabase.a(str2, null, null);
    localSQLiteDatabase.a(str4, null, null);
    localSQLiteDatabase.a(str3, null, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    localObject = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localObject != null)
    {
      ((RecommendTroopManagerImp)localObject).b();
      ((RecommendTroopManagerImp)localObject).a(1);
    }
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, true);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, true);
  }
  
  public void k()
  {
    g(AppConstants.v, 1009);
    g(AppConstants.G, 1001);
    g(AppConstants.G, 10002);
    g(AppConstants.X, 1010);
  }
  
  /* Error */
  public void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 2271	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: aload_0
    //   8: getfield 65	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 1415	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 2277	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore 4
    //   20: aload 4
    //   22: ldc_w 2279
    //   25: lconst_0
    //   26: invokeinterface 2285 4 0
    //   31: lstore_2
    //   32: invokestatic 411	java/lang/System:currentTimeMillis	()J
    //   35: ldc2_w 2286
    //   38: ldiv
    //   39: lload_2
    //   40: lsub
    //   41: ldc2_w 2288
    //   44: lcmp
    //   45: ifge +4 -> 49
    //   48: return
    //   49: aload_0
    //   50: lload_2
    //   51: invokespecial 2291	com/tencent/mobileqq/app/message/QQMessageFacade:a	(J)V
    //   54: new 127	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 2293
    //   61: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: aload_0
    //   67: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: astore 7
    //   72: aload 7
    //   74: monitorenter
    //   75: new 39	java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: aload_0
    //   80: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   83: invokespecial 2296	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 42	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   92: invokevirtual 2297	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 6
    //   100: invokevirtual 352	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   103: invokeinterface 150 1 0
    //   108: astore 7
    //   110: aload 7
    //   112: invokeinterface 155 1 0
    //   117: ifeq +114 -> 231
    //   120: aload 7
    //   122: invokeinterface 159 1 0
    //   127: checkcast 171	java/lang/String
    //   130: astore 8
    //   132: aload 6
    //   134: aload 8
    //   136: invokevirtual 2298	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 306	java/lang/Integer
    //   142: invokevirtual 2301	java/lang/Integer:intValue	()I
    //   145: istore_1
    //   146: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +23 -> 172
    //   152: aload 5
    //   154: ldc_w 2303
    //   157: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 8
    //   162: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 2305
    //   168: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_0
    //   173: aload 8
    //   175: iload_1
    //   176: invokevirtual 2307	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)V
    //   179: goto -69 -> 110
    //   182: astore 4
    //   184: aload 4
    //   186: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   189: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -144 -> 48
    //   195: ldc 50
    //   197: iconst_2
    //   198: new 127	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 2309
    //   208: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 4
    //   213: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: return
    //   223: astore 4
    //   225: aload 7
    //   227: monitorexit
    //   228: aload 4
    //   230: athrow
    //   231: aload 4
    //   233: invokeinterface 2313 1 0
    //   238: ldc_w 2279
    //   241: invokestatic 411	java/lang/System:currentTimeMillis	()J
    //   244: ldc2_w 2286
    //   247: ldiv
    //   248: invokeinterface 2319 4 0
    //   253: invokeinterface 2322 1 0
    //   258: pop
    //   259: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -214 -> 48
    //   265: ldc 50
    //   267: iconst_2
    //   268: aload 5
    //   270: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
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
          if (((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_JavaLangString) == null) {}
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
          } while (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).d(str1));
        }
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    MsgAutoMonitorUtil.a().c(System.currentTimeMillis() - l);
    MsgAutoMonitorUtil.a().c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */