package com.tencent.mobileqq.app;

import GeneralSettings.Setting;
import MessageSvcPack.GroupInfo;
import MessageSvcPack.MsgFilter;
import MessageSvcPack.PullGroupSeqParam;
import MessageSvcPack.SvcRequestGetMsgV2;
import MessageSvcPack.SvcRequestPullDisMsgSeq;
import MessageSvcPack.SvcRequestPullGroupMsgSeq;
import MessageSvcPack.SvcResponsePullDisMsgSeq;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import MessageSvcPack.stConfNumInfo;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import PushNotifyPack.RequestPushNotify;
import QQService.SvcReqMSFLoginNotify;
import RegisterProxySvcPack.SvcRequestPullDisGroupSeq;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.utils.QavMsgNotificationUtil;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.util.ShareStructLongMessageManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.imcore.message.core.codec.RoutingTypeGenerator;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.handler.IMsgHandler;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler.Callback;
import com.tencent.mobileqq.app.handler.Report;
import com.tencent.mobileqq.app.handler.receiveerror.Error;
import com.tencent.mobileqq.app.handler.receivesuccess.AccostSvcReqDeleteBlackList;
import com.tencent.mobileqq.app.handler.receivesuccess.AccostSvcReqInsertBlackList;
import com.tencent.mobileqq.app.handler.receivesuccess.DelRoamResp;
import com.tencent.mobileqq.app.handler.receivesuccess.GetBlackList;
import com.tencent.mobileqq.app.handler.receivesuccess.GetBoxFilterResp;
import com.tencent.mobileqq.app.handler.receivesuccess.InfoSyncResp;
import com.tencent.mobileqq.app.handler.receivesuccess.InsertBlackList;
import com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbGetDiscussMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbGetGroupMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbGetMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbReceiptRead;
import com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPullGroupMsgSeq;
import com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPushNotify;
import com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcRequestPushStatus;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyCmdResp;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyDisGroupMsgSeq;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyDisMsgSeq;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyDiscussMsgRespPB;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyEndResp;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyTroopMsgRespPB;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyTroopMsgSeq;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgReadReportRespPB;
import com.tencent.mobileqq.app.handler.receivesuccess.MultiVideoc2sack;
import com.tencent.mobileqq.app.handler.receivesuccess.MultiVideos2c;
import com.tencent.mobileqq.app.handler.receivesuccess.NearFieldTranFileSvrNotifyList;
import com.tencent.mobileqq.app.handler.receivesuccess.OidbSvc0xb31;
import com.tencent.mobileqq.app.handler.receivesuccess.OnlinePushPbPushGroupMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.OnlinePushPbPushTransMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.PushADMessageResp;
import com.tencent.mobileqq.app.handler.receivesuccess.PushReadNotify;
import com.tencent.mobileqq.app.handler.receivesuccess.RegPrxySvcPbGetMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.SendClientMsgResp;
import com.tencent.mobileqq.app.handler.receivesuccess.SendGetSig;
import com.tencent.mobileqq.app.handler.receivesuccess.SendHotchatTopicMessageRespPB;
import com.tencent.mobileqq.app.handler.receivesuccess.SendMsgResp;
import com.tencent.mobileqq.app.handler.receivesuccess.SetRoamMsgResp;
import com.tencent.mobileqq.app.handler.receivesuccess.StatSvcSvcReqMSFLoginNotify;
import com.tencent.mobileqq.app.handler.receivesuccess.StreamSvrPushStreamMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.StreamSvrRespUploadStreamMsg;
import com.tencent.mobileqq.app.handler.receivesuccess.SubscribeNearbyAssistant;
import com.tencent.mobileqq.app.handler.receivesuccess.TransServiceReqTmpChatPicDownload;
import com.tencent.mobileqq.app.handler.receivetimeout.TimeOut;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.AccostMessageProcessor;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.FileSlaveMasterMessageProcessor;
import com.tencent.mobileqq.app.message.HCTopicMessageProcessor;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.app.message.ProcessorObserver;
import com.tencent.mobileqq.app.message.ProfileCardMessageProcessor;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.message.VideoMessageProcessor;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.app.messagehandler.WorkerHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.message.FriendShieldUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo;
import com.tencent.mobileqq.service.message.MessageCache.RegPrxyCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetDiscussMsgReq;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.msgsvc.msg_svc.PbGetGroupMsgReq;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import msf.msgsvc.msg_svc.PbGetMsgReq;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgReq;
import msf.msgsvc.msg_svc.PbGetRoamMsgReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqReq;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import msf.msgsvc.msg_svc.TransSvrInfo;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;
import msf.registerproxy.register_proxy.SvcPbResponsePullDisMsgProxy;
import msf.registerproxy.register_proxy.SvcResponsePbPullGroupMsgProxy;
import org.jetbrains.annotations.NotNull;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.msg.im_receipt.MsgInfo;
import tencent.im.msg.im_receipt.ReceiptReq;
import tencent.im.oidb.cmd0x9db.cmd0x9db.ReqBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.ReqBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.ReqBody;
import tencent.im.oidb.cmd0xbad.oidb_0xbad.ReqBody;

@KeepClassConstructor
public class MessageHandler
  extends BaseMessageHandler
  implements ProcessorDispatcherInterface, ProcessorObserver
{
  public static int c = 500;
  public long a;
  private final MapClassGenerator<String, IMsgHandler> jdField_a_of_type_ComTencentImcoreMessageBasicMapClassGenerator = new MapClassGeneratorImpl();
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MessageHandler.14(this);
  public QQAppInterface a;
  private final RegisterProxyHandler.Callback jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler$Callback = new MessageHandler.1(this);
  WorkerHandler jdField_a_of_type_ComTencentMobileqqAppMessagehandlerWorkerHandler;
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new MessageHandler.13(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  public MessageCache a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private Thread jdField_a_of_type_JavaLangThread = null;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Runnable jdField_b_of_type_JavaLangRunnable = null;
  private Thread jdField_b_of_type_JavaLangThread = null;
  private boolean jdField_b_of_type_Boolean;
  private final int[] jdField_b_of_type_ArrayOfInt = new int[0];
  private boolean c;
  public int d;
  private boolean d;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private final int jdField_f_of_type_Int = 2;
  private boolean jdField_f_of_type_Boolean = false;
  private int g = 0;
  private final int h = 3;
  private final int i = 6;
  
  public MessageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler$Callback);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = paramQQAppInterface.getMsgCache();
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("mobileQQ", 0);
    AppSetting.i = paramQQAppInterface.getBoolean(AppSetting.b, true);
    AppSetting.j = paramQQAppInterface.getBoolean("c2c_del_msg_oper_enable", true);
  }
  
  public static int a(int paramInt)
  {
    int j = 3001;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1000)
        {
          if (paramInt != 1026)
          {
            if (paramInt != 3000)
            {
              if (paramInt != 10008)
              {
                if (paramInt != 10010)
                {
                  if (paramInt != 1009)
                  {
                    if (paramInt != 1010)
                    {
                      if (paramInt != 1023)
                      {
                        if (paramInt != 1024)
                        {
                          switch (paramInt)
                          {
                          default: 
                            return 3001;
                          case 1006: 
                            return 8005;
                          case 1005: 
                            return 7000;
                          }
                          return 8002;
                        }
                        return 8010;
                      }
                      return 8008;
                    }
                    return 8012;
                  }
                  return 8006;
                }
                return 8045;
              }
              return 8043;
            }
            return 3008;
          }
          return 3013;
        }
        return 6000;
      }
      j = 3002;
    }
    return j;
  }
  
  private int a(msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    if ((paramPbSendMsgResp != null) && (paramPbSendMsgResp.result.has()))
    {
      if (paramPbSendMsgResp.result.get() != 0) {
        return paramPbSendMsgResp.result.get();
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB did not return a valid result code, use 4 instead.");
    }
    return 4;
  }
  
  private Pair<Long, Long> a(String paramString, int paramInt)
  {
    long l1;
    long l2;
    if (paramInt == 3000)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(paramString);
      l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(paramString);
    }
    else
    {
      if (paramInt != 1) {
        break label906;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString);
      l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramString);
    }
    long l3 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("guessPullMsgStartSeq uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ,type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ,lastSeq = ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" ,expiredSeq = ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(" ,delSeq = ");
      ((StringBuilder)localObject).append(l3);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt);
    Object localObject = MsgProxyUtils.a(localList, false);
    l3 = Math.max(l3, l2);
    boolean bool1 = UinTypeUtil.a(paramString, paramInt, (List)localObject);
    boolean bool2 = UinTypeUtil.a((List)localObject);
    if ((!bool1) && (!bool2))
    {
      paramInt = 10;
      paramString = (String)localObject;
    }
    else
    {
      int j = 25;
      localObject = MsgProxyUtils.a(localList, false, 25);
      paramInt = j;
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "getRePullMsgSeqRange : pull more long msg");
        paramString = (String)localObject;
        paramInt = j;
      }
    }
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      l2 = ((MessageRecord)paramString.get(0)).shmsgseq;
      long l4 = Math.max(l3, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
      l1 = Math.max(l3, l1);
      if (l3 + 1L >= l2)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("return seq = ");
          paramString.append(Math.max(l1 - paramInt, l4));
          paramString.append(",");
          paramString.append(l1);
          paramString.append(",lowSeq >= lastBreakSeq ");
          QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l4)), Long.valueOf(l1));
      }
      long l5 = paramInt;
      if (l1 - l2 >= l5)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("return seq = ");
          paramString.append(Math.max(l1 - l5, l4));
          paramString.append(",");
          paramString.append(l1);
          paramString.append(",continuedList >= ");
          paramString.append(paramInt);
          QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
        }
        return new Pair(Long.valueOf(Math.max(l1 - l5, l4)), Long.valueOf(l1));
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("return seq = ");
        paramString.append(Math.max(l1 - l5, l3));
        QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
      }
      if (l1 > l4)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("return ok lastSeq > lastLocalSeq , (");
          paramString.append(Math.max(l1 - l5, l3));
          paramString.append(",");
          paramString.append(l1);
          paramString.append(")");
          QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
        }
        return new Pair(Long.valueOf(Math.max(l1 - l5, l3)), Long.valueOf(l1));
      }
      if (l1 == l4)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("return ok lastSeq == lastLocalSeq , (");
          paramString.append(Math.max(l1 - l5, l3));
          paramString.append(",");
          paramString.append(Math.max(l2 - 1L, l3));
          paramString.append(")");
          QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
        }
        return new Pair(Long.valueOf(Math.max(l1 - l5, l3)), Long.valueOf(l2 - 1L));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lastSeq < lastLocalSeq");
      }
      return new Pair(Long.valueOf(l1), Long.valueOf(l1));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "return local is null!");
    }
    return new Pair(Long.valueOf(l1), Long.valueOf(l1));
    label906:
    return null;
  }
  
  private Pair<Long, Long> a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l3 = paramLong4;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPullMsgLowSeq uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ,type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ,lastSeq = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" ,expiredSeq = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" ,delSeq = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(" ,svrSeq = ");
      localStringBuilder.append(l3);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    paramString = MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt), false);
    long l1 = paramLong1;
    long l2 = l3;
    if (paramString != null)
    {
      l1 = paramLong1;
      l2 = l3;
      if (!paramString.isEmpty())
      {
        paramLong4 = paramLong1;
        if (((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq < paramLong1) {
          paramLong4 = ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq;
        }
        l1 = paramLong4;
        l2 = l3;
        if (((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq > l3)
        {
          l2 = ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq;
          l1 = paramLong4;
        }
      }
    }
    paramLong1 = Math.max(paramLong3, paramLong2);
    paramLong2 = Math.max(paramLong1, l1);
    paramLong3 = Math.max(paramLong1, l2);
    if (paramLong1 >= paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lowSeq >= lastSeq");
      }
      return new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong3));
    }
    if (l2 - l1 >= 10L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return pullCount >= 10");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramLong4 = ((MessageRecord)paramString.get(0)).shmsgseq;
      if (paramLong1 + 1L >= paramLong4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return lowSeq >= lastBreakSeq");
        }
        return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
      }
      if (paramLong3 - paramLong4 >= 10L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return svrSeq - lastBreakSeq >= 10");
        }
        return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
      }
      if (paramLong3 > paramLong2)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("return ok svrSeq > lastSeq , (");
          paramString.append(Math.max(paramLong3 - 10L, paramLong1));
          paramString.append(",");
          paramString.append(paramLong3);
          paramString.append(")");
          QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
        }
        return new Pair(Long.valueOf(Math.max(paramLong3 - 10L, paramLong1)), Long.valueOf(paramLong3));
      }
      if (paramLong3 == paramLong2)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("return ok svrSeq == lastSeq , (");
          paramString.append(Math.max(paramLong3 - 10L, paramLong1));
          paramString.append(",");
          paramString.append(Math.max(paramLong4 - 1L, paramLong1));
          paramString.append(")");
          QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
        }
        return new Pair(Long.valueOf(Math.max(paramLong3 - 10L, paramLong1)), Long.valueOf(Math.max(paramLong4 - 1L, paramLong1)));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return svrSeq < lastSeq");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "return local is null! ");
    }
    return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
  }
  
  private WorkerHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessagehandlerWorkerHandler == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessagehandlerWorkerHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessagehandlerWorkerHandler = new WorkerHandler(this, ThreadManager.getSubThreadLooper());
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessagehandlerWorkerHandler;
  }
  
  @NotNull
  private ToServiceMsg a(byte paramByte1, byte[] paramArrayOfByte1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2, Object paramObject, byte[] paramArrayOfByte2, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "createGetOfflineMsgRequest");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte1);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte1);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt1);
    localToServiceMsg.extraData.putByteArray("vSyncCookie", paramArrayOfByte2);
    localToServiceMsg.extraData.putByte("onlineSyncFlag", paramByte2);
    localToServiceMsg.extraData.putBoolean("needNofityConversation", paramBoolean2);
    localToServiceMsg.extraData.putBoolean("isPullRoamMsg", paramBoolean1);
    if (paramString != null)
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append("|");
      paramArrayOfByte1.append(System.currentTimeMillis());
      localToServiceMsg.addAttribute("sso_push_timestamp", paramArrayOfByte1.toString());
    }
    localToServiceMsg.extraData.putInt("pullMsgType", paramInt2);
    localToServiceMsg.putWupBuffer(a(paramInt1, paramInt2, paramObject, paramArrayOfByte2, paramByte2).toByteArray());
    return localToServiceMsg;
  }
  
  @NotNull
  private ToServiceMsg a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null) {
      l1 = 0L;
    } else {
      l1 = paramMessageRecord.msg.getBytes().length;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg", paramBusinessObserver);
    a(paramMessageRecord, localToServiceMsg);
    int j = MessageProtoCodec.b(paramMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l3 = paramMessageRecord.msgUid;
    int k = (short)(int)paramMessageRecord.msgseq;
    int m = MessageUtils.a(l3);
    QLog.i("Q.msg.MessageHandler", 1, String.format(Locale.getDefault(), "<PbSendMsg><S> --->createSendRichTextMsgReq, uint32Seq:%d, random:%d, routingType:%d, %s", new Object[] { Integer.valueOf(0xFFFF & k), Integer.valueOf(m), Integer.valueOf(j), paramMessageRecord.getBaseInfoString() }));
    localToServiceMsg.extraData.putString("uin", paramMessageRecord.frienduin);
    localToServiceMsg.extraData.putLong("msgsize", l1);
    localToServiceMsg.extraData.putLong("uniseq", paramMessageRecord.uniseq);
    localToServiceMsg.extraData.putLong("timeOut", paramLong);
    localToServiceMsg.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
    localToServiceMsg.extraData.putLong("startTime", l2);
    localToServiceMsg.extraData.putInt("retryIndex", paramInt);
    localToServiceMsg.extraData.putInt("uintype", paramMessageRecord.istroop);
    localToServiceMsg.extraData.putInt("msgtype", paramMessageRecord.msgtype);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", j);
    localToServiceMsg.extraData.putInt("send_msg_req_size", localToServiceMsg.getWupBuffer().length);
    localToServiceMsg.putWupBuffer(paramPbSendMsgReq.toByteArray());
    localToServiceMsg.setTimeout(paramLong);
    localToServiceMsg.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
    localToServiceMsg.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
    localToServiceMsg.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
    localToServiceMsg.addAttribute("retryIndex", Integer.valueOf(paramInt));
    paramPbSendMsgReq = paramMessageRecord.frienduin;
    paramBusinessObserver = "";
    if (paramPbSendMsgReq == null) {
      paramPbSendMsgReq = "";
    } else {
      paramPbSendMsgReq = paramMessageRecord.frienduin;
    }
    localToServiceMsg.addAttribute("uin", paramPbSendMsgReq);
    if (paramMessageRecord.senderuin == null) {
      paramMessageRecord = paramBusinessObserver;
    } else {
      paramMessageRecord = paramMessageRecord.senderuin;
    }
    localToServiceMsg.addAttribute("fromUin", paramMessageRecord);
    localToServiceMsg.addAttribute("normal_msg", Boolean.valueOf(true));
    return localToServiceMsg;
  }
  
  @Nullable
  private msg_svc.PbGetGroupMsgResp a(byte[] paramArrayOfByte)
  {
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp = new msg_svc.PbGetGroupMsgResp();
    try
    {
      paramArrayOfByte = (msg_svc.PbGetGroupMsgResp)localPbGetGroupMsgResp.mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label19:
      break label19;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB : Exception occurs whitl parsing the bytes.");
    }
    return null;
  }
  
  @NotNull
  private msg_svc.PbGetMsgReq a(int paramInt1, int paramInt2, Object paramObject, byte[] paramArrayOfByte, byte paramByte)
  {
    msg_svc.PbGetMsgReq localPbGetMsgReq = new msg_svc.PbGetMsgReq();
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          localPbGetMsgReq.msg_req_type.set(2);
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
          if (paramArrayOfByte != null) {
            localPbGetMsgReq.pubaccount_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
          }
        }
      }
      else
      {
        localPbGetMsgReq.msg_req_type.set(1);
        if (paramArrayOfByte != null) {
          localPbGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        }
      }
    }
    else
    {
      localPbGetMsgReq.msg_req_type.set(0);
      if (paramArrayOfByte != null) {
        localPbGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
    }
    localPbGetMsgReq.sync_flag.set(paramInt1);
    localPbGetMsgReq.ramble_flag.set(0);
    localPbGetMsgReq.context_flag.set(1);
    localPbGetMsgReq.online_sync_flag.set(paramByte);
    localPbGetMsgReq.latest_ramble_number.set(20);
    localPbGetMsgReq.other_ramble_number.set(3);
    if ((paramObject != null) && ((paramObject instanceof RequestPushNotify)))
    {
      paramObject = (RequestPushNotify)paramObject;
      if (paramObject.bytes_server_buf != null)
      {
        localPbGetMsgReq.bytes_server_buf.set(ByteStringMicro.copyFrom(paramObject.bytes_server_buf));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->>getC2CMessage (PushNotify getMsg) pb:", "MessageSvc.PbGetMsg", ", fill bytes_server_buf=", paramObject.bytes_server_buf.toString() });
        }
      }
    }
    return localPbGetMsgReq;
  }
  
  @NonNull
  private msg_svc.PbSendMsgReq a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    msg_svc.PbSendMsgReq localPbSendMsgReq = new msg_svc.PbSendMsgReq();
    im_receipt.ReceiptReq localReceiptReq = new im_receipt.ReceiptReq();
    localReceiptReq.command.set(paramInt1);
    im_receipt.MsgInfo localMsgInfo = new im_receipt.MsgInfo();
    localMsgInfo.uint64_from_uin.set(paramLong1);
    localMsgInfo.uint64_to_uin.set(paramLong2);
    localMsgInfo.uint32_msg_seq.set(paramInt2);
    localMsgInfo.uint32_msg_random.set(paramInt3);
    localReceiptReq.msg_info.set(localMsgInfo);
    localPbSendMsgReq.receipt_req.set(localReceiptReq);
    return localPbSendMsgReq;
  }
  
  @Nullable
  private msg_svc.PbSendMsgResp a(Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      return localPbSendMsgResp;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleSendTroopMessageRespPB:");
        if (paramObject == null) {
          paramObject = "null";
        } else {
          paramObject = Arrays.toString((byte[])paramObject);
        }
        localStringBuilder.append(paramObject);
        QLog.e("Q.msg.MessageHandler", 2, localStringBuilder.toString(), localException);
      }
    }
    return null;
  }
  
  private void a(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 2))
      {
        String str = (String)paramObject[0];
        int j = ((Integer)paramObject[1]).intValue();
        if ((((Integer)paramObject[2]).intValue() == 55) && (paramInt != 8035)) {
          ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER)).a(str, j);
        }
      }
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, MessageRecord paramMessageRecord)
  {
    if ((paramBoolean2) && (paramInt1 == 1000) && (paramBoolean1 == true)) {
      if (paramInt2 > 0)
      {
        paramBoolean2 = false;
        paramBoolean1 = false;
        if (paramMessageRecord == null) {}
        try
        {
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!paramBoolean3) {
            paramBoolean1 = true;
          }
          paramMessageRecord.handleReceivedMessage(paramInt2, true, paramBoolean1);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          QQAppInterface localQQAppInterface;
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramBoolean1 = paramBoolean2;
        if (!paramBoolean3) {
          paramBoolean1 = true;
        }
        QavMsgNotificationUtil.a(localQQAppInterface, paramInt2, true, paramBoolean1, paramMessageRecord);
        return;
        QLog.w("notification", 2, "notification exception", paramMessageRecord);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("notification", 2, "notification size = 0");
      }
    }
  }
  
  private void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, paramInt, paramLong);
    if (localMessageRecord == null) {
      return;
    }
    localMessageRecord.saveExtInfoToExtStr(paramString3, paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, paramInt, paramLong, "extStr", localMessageRecord.extStr);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          l = System.currentTimeMillis();
        }
        localObject1 = paramQQAppInterface.getMessageProxy(1).c(paramString, 1);
        if (localObject1 != null) {
          break label522;
        }
        localObject1 = paramQQAppInterface.getMessageProxy(1).c(paramString, 1, 1L + paramLong, 2147483647L);
        n = 0;
        m = 0;
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label573;
        }
        n = ((List)localObject1).size() - 1;
        j = 0;
        k = 0;
        if (n < 0) {
          break label558;
        }
        localObject2 = (MessageRecord)((List)localObject1).get(n);
        if (((MessageRecord)localObject2).shmsgseq <= paramLong) {
          break label558;
        }
        if (!MsgProxyUtils.a((MessageRecord)localObject2)) {
          if (((MessageRecord)localObject2).msgtype != -2006) {
            break label525;
          }
        }
        paramQQAppInterface.getMessageFacade().b(paramString, 1, ((MessageRecord)localObject2).uniseq);
        boolean bool = QLog.isColorLevel();
        StringBuilder localStringBuilder;
        if (bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("delAbnormalLocalTroopMsg: ");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(", ");
          localStringBuilder.append(((MessageRecord)localObject2).getBaseInfoString());
          QLog.d(".troop.del_abnormal_troop_local_msg", 2, localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("delAbnormalLocalTroopMsg: ");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(", ");
          localStringBuilder.append(((MessageRecord)localObject2).getUserLogString());
          QLog.d(".troop.del_abnormal_troop_local_msg", 1, localStringBuilder.toString());
        }
        j = ((MessageRecord)localObject2).msgtype;
        k = m + 1;
        m = 1;
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject1;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          break label521;
        }
        paramString = new StringBuilder();
        paramString.append("delAbnormalLocalTroopMsg:");
        paramString.append(paramQQAppInterface.toString());
        QLog.e(".troop.del_abnormal_troop_local_msg", 2, paramString.toString());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("---delAbnormalLocalTroopMsg---:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, ((StringBuilder)localObject1).toString());
      }
      if (m != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("");
        ReportController.b(paramQQAppInterface, "dc00899", "BizTechReport", "", "Grp_msg", "del_abnormal_local_msg", 0, 0, paramString, (String)localObject1, ((StringBuilder)localObject2).toString(), "");
        return;
      }
      label521:
      return;
      label522:
      continue;
      label525:
      int i1 = k;
      int k = m;
      int m = i1;
      n -= 1;
      i1 = m;
      m = k;
      k = i1;
      continue;
      label558:
      int n = k;
      k = m;
      m = n;
      continue;
      label573:
      k = 0;
      int j = 0;
      m = n;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    ShareStructLongMessageManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramMessageObserver, false);
  }
  
  private void a(MessageRecord paramMessageRecord, ToServiceMsg paramToServiceMsg)
  {
    Object localObject;
    if ((paramMessageRecord instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramMessageRecord;
      if (((MessageForLongTextMsg)localObject).structingMsg != null) {
        paramToServiceMsg.extraData.putString("fileName", ((MessageForLongTextMsg)localObject).structingMsg.mFileName);
      }
    }
    if ((paramMessageRecord instanceof MessageForMarketFace))
    {
      localObject = ((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage;
      if ((localObject != null) && (((((MarkFaceMessage)localObject).mobileparam != null) && (((MarkFaceMessage)localObject).mobileparam.length > 0)) || (((MarkFaceMessage)localObject).mediaType == 3))) {
        paramToServiceMsg.extraData.putInt("mediaType", 2);
      }
    }
    if ((paramMessageRecord instanceof MessageForText))
    {
      localObject = paramToServiceMsg.extraData;
      MessageForText localMessageForText = (MessageForText)paramMessageRecord;
      ((Bundle)localObject).putInt("msg_signal_sum", localMessageForText.mMsgSignalSum);
      paramToServiceMsg.extraData.putInt("msg_signal_count", localMessageForText.mMsgSignalCount);
      paramToServiceMsg.extraData.putBoolean("msg_signal_open", localMessageForText.mIsMsgSignalOpen);
      paramToServiceMsg.extraData.putInt("msg_signal_net_type", localMessageForText.mMsgSignalNetType);
      paramToServiceMsg.extraData.putLong("msg_send_time", localMessageForText.mMsgSendTime);
    }
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 1026))
    {
      if (paramMessageRecord.istroop == 3000) {
        paramToServiceMsg.extraData.putString("uToUin", paramMessageRecord.frienduin);
      } else if (UinTypeUtil.a(paramMessageRecord.istroop) == 1032) {
        paramToServiceMsg.extraData.putInt("key_confess_topicid", paramMessageRecord.getConfessTopicId());
      }
    }
    else {
      paramToServiceMsg.extraData.putString("groupuin", paramMessageRecord.frienduin);
    }
    if (MsgProxyUtils.i(paramMessageRecord.msgtype)) {
      paramToServiceMsg.extraData.putBoolean("RichNotify", true);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramMessageRecord.istroop == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "sendRichTextMessageInner");
      }
      b(paramMessageRecord, paramPbSendMsgReq, paramLong, paramInt, paramBusinessObserver, paramBoolean);
      return;
    }
    paramMessageRecord = a(paramMessageRecord, paramPbSendMsgReq, paramLong, paramInt, paramBusinessObserver, paramBoolean);
    if (AppSetting.f()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getParcelHooker().a(paramMessageRecord);
    }
    a(paramMessageRecord);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, StringBuilder paramStringBuilder, ArrayList<String> paramArrayList, GroupInfo paramGroupInfo, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramString, new Object[] { Long.valueOf(paramGroupInfo.lMemberSeq), Long.valueOf(paramGroupInfo.lGroupSeq) });
    FightMsgReporter.a(paramString, paramGroupInfo.lGroupSeq, paramGroupInfo.lMemberSeq);
    if (paramLong < paramGroupInfo.lMemberSeq) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(String.valueOf(paramGroupInfo.lGroupCode), 1, paramGroupInfo.lMemberSeq);
    }
    paramLong = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, 1);
    paramGroupInfo = a(paramString, 1, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString), this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramString), paramLong, paramGroupInfo.lGroupSeq);
    int j = (int)(((Long)paramGroupInfo.second).longValue() - ((Long)paramGroupInfo.first).longValue());
    paramLong = ((Long)paramGroupInfo.first).longValue();
    long l1 = ((Long)paramGroupInfo.second).longValue();
    paramLong = l1 - (paramLong + 1L);
    long l2 = 10;
    if (paramLong > l2) {
      paramLong = l1 - l2 + 1L;
    } else {
      paramLong = l1 - paramLong;
    }
    if (QLog.isColorLevel())
    {
      paramStringBuilder.setLength(0);
      paramStringBuilder.append("---------handleGetPullTroopMsgNumResp troopUin: ");
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(" msg count: ");
      paramStringBuilder.append(j);
      QLog.d("Q.msg.MessageHandler", 2, paramStringBuilder.toString());
    }
    if (j <= 0)
    {
      ((TroopMessageProcessor)a("troop_processor")).a(paramString, null, paramInt);
      return;
    }
    paramArrayList.add(paramString);
    if (paramArrayList.size() > 0)
    {
      paramToServiceMsg = paramArrayList.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramStringBuilder = (String)paramToServiceMsg.next();
        a(paramString, paramLong, l1, false, null, paramInt);
      }
    }
    notifyUI(4003, true, paramToServiceMsg.extraData.getStringArray("array_groupuin"));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, long paramLong1, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong2, boolean paramBoolean3)
  {
    if (a(paramToServiceMsg, paramPbGetGroupMsgResp)) {
      return;
    }
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramLong2);
    if (paramBoolean3) {
      a(paramToServiceMsg, paramPbGetGroupMsgResp, paramString, localArrayList);
    } else {
      a(paramToServiceMsg, paramPbGetGroupMsgResp, paramBoolean1, paramBoolean2, paramString, paramLong2, localArrayList);
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramLong2);
    paramToServiceMsg = (TroopMessageProcessor)a("troop_processor");
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(paramLong2);
    paramToServiceMsg.a(paramString.toString(), paramPbGetGroupMsgResp, paramInt);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetPullGroupMsgRespPB, cost time = [");
      paramToServiceMsg.append(System.currentTimeMillis() - paramLong1);
      paramToServiceMsg.append("]");
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, paramToServiceMsg.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq, int paramInt1, boolean paramBoolean, StringBuilder paramStringBuilder, ArrayList<String> paramArrayList, HashMap paramHashMap, HashMap<String, String> paramHashMap1, int paramInt2)
  {
    paramSvcResponsePullGroupMsgSeq = (GroupInfo)paramSvcResponsePullGroupMsgSeq.vGroupInfo.get(paramInt2);
    String str = String.valueOf(paramSvcResponsePullGroupMsgSeq.lGroupCode);
    long l1 = paramSvcResponsePullGroupMsgSeq.lRedPackTime;
    long l2 = 0L;
    if (l1 > 0L) {
      paramHashMap1.put(str, String.valueOf(paramSvcResponsePullGroupMsgSeq.lRedPackTime));
    }
    paramHashMap1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str);
    long l3 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.j(str);
    l1 = l2;
    if (paramHashMap1 != null)
    {
      l1 = l2;
      if (paramHashMap1.length > 0) {
        l1 = ((Long)paramHashMap1[0]).longValue();
      }
    }
    if (QLog.isColorLevel())
    {
      paramStringBuilder.setLength(0);
      paramStringBuilder.append("handleGetPullTroopMsgNumResp getGroupMsgMemberSeq groupUin=");
      paramStringBuilder.append(paramSvcResponsePullGroupMsgSeq.lGroupCode);
      paramStringBuilder.append(" memberseq=");
      paramStringBuilder.append(paramSvcResponsePullGroupMsgSeq.lMemberSeq);
      paramStringBuilder.append(" groupSeq=");
      paramStringBuilder.append(paramSvcResponsePullGroupMsgSeq.lGroupSeq);
      paramStringBuilder.append(" lMask=");
      paramStringBuilder.append(paramSvcResponsePullGroupMsgSeq.lMask);
      paramStringBuilder.append(" localMemberMsgSeq=");
      paramStringBuilder.append(l1);
      paramStringBuilder.append(" localLastSeq=");
      paramStringBuilder.append(l3);
      QLog.d("Q.msg.MessageHandler", 2, paramStringBuilder.toString());
    }
    if (paramBoolean)
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramHashMap, paramSvcResponsePullGroupMsgSeq, str, l3, l1);
      return;
    }
    a(paramToServiceMsg, paramInt1, paramStringBuilder, paramArrayList, paramSvcResponsePullGroupMsgSeq, str, l1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    a(paramString, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgProxyTroopMsgSeq.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgProxyDisMsgSeq.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgProxyDisGroupMsgSeq.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgProxyEndResp.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    GetBoxFilterResp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, paramFromServiceMsg, paramObject);
    RegPrxySvcPbGetMsg.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgProxyTroopMsgRespPB.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgProxyDiscussMsgRespPB.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgProxyCmdResp.a(this, paramFromServiceMsg, paramObject);
    InfoSyncResp.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    MessageSvcPbGetMsg.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    TransServiceReqTmpChatPicDownload.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MessageSvcPushNotify.a(this, paramFromServiceMsg, paramObject);
    SetRoamMsgResp.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    DelRoamResp.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgReadReportRespPB.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    PushADMessageResp.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    PushReadNotify.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    SendGetSig.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    StreamSvrRespUploadStreamMsg.a(this, paramFromServiceMsg, paramObject);
    SendMsgResp.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    SendHotchatTopicMessageRespPB.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    StreamSvrPushStreamMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, paramObject);
    SendClientMsgResp.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    GetBlackList.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    OnlinePushPbPushTransMsg.a(this, paramToServiceMsg, paramFromServiceMsg);
    AccostSvcReqInsertBlackList.a(this, paramToServiceMsg, paramFromServiceMsg);
    InsertBlackList.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    AccostSvcReqDeleteBlackList.a(this, paramToServiceMsg, paramFromServiceMsg);
    SubscribeNearbyAssistant.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MessageSvcPullGroupMsgSeq.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MessageSvcPbGetGroupMsg.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MessageSvcPbGetDiscussMsg.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    MessageSvcRequestPushStatus.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
    StatSvcSvcReqMSFLoginNotify.a(this, paramFromServiceMsg);
    OnlinePushPbPushGroupMsg.a(this, paramFromServiceMsg, paramObject);
    MultiVideos2c.a(this, paramFromServiceMsg);
    MultiVideoc2sack.a(this, paramFromServiceMsg);
    NearFieldTranFileSvrNotifyList.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, paramString);
    MessageSvcPbReceiptRead.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject, paramString);
    OidbSvc0xb31.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject, paramString);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, msg_svc.PbSendMsgResp paramPbSendMsgResp, long paramLong, int paramInt)
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong);
    if ((localMessageRecord instanceof RecommendCommonMessage))
    {
      if ((paramPbSendMsgResp.text_analysis_result.has()) && (paramPbSendMsgResp.text_analysis_result.get() == 1)) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      if (QLog.isColorLevel())
      {
        paramPbSendMsgResp = new StringBuilder();
        paramPbSendMsgResp.append("<---handleSendTroopMessageRespPB text_analysis_result=");
        paramPbSendMsgResp.append(paramString);
        QLog.d("Q.msg.MessageHandler", 2, paramPbSendMsgResp.toString());
      }
      localMessageRecord.saveExtInfoToExtStr("ark_text_analysis_flag", paramString);
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramToServiceMsg.extraData.getString("groupuin"), 1, paramLong);
    paramToServiceMsg.extraData.putBoolean("isJuhuaExist", MessageCache.a(paramString));
    long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
    if (l3 > 0L)
    {
      if ((paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null) && (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null))
      {
        long l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        if (l1 <= 2147483647L) {
          break label252;
        }
      }
      long l1 = 0L;
      label252:
      paramString = new MessageHandlerConstants.MsgSendCostParams();
      paramString.jdField_c_of_type_Long = l1;
      paramString.d = System.currentTimeMillis();
      paramString.jdField_b_of_type_Long = (paramString.d - l3);
      paramString.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
      paramString.jdField_a_of_type_Int = 1;
      paramString.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
      paramString.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      paramString.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
      notifyUI(6003, true, new Object[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(paramLong), paramString });
    }
    else
    {
      notifyUI(6003, true, new String[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(paramLong) });
    }
    a(localMessageRecord);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, HashMap paramHashMap, GroupInfo paramGroupInfo, String paramString, long paramLong1, long paramLong2)
  {
    if (((paramGroupInfo.lMask == 2L) || (paramGroupInfo.lMask == 3L)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.d()))
    {
      g(paramString);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramString, new Object[] { Long.valueOf(paramGroupInfo.lMemberSeq), Long.valueOf(paramGroupInfo.lGroupSeq) });
      FightMsgReporter.a(paramString, paramGroupInfo.lGroupSeq, paramGroupInfo.lMemberSeq);
      if (paramGroupInfo.lGroupSeq <= paramLong1)
      {
        g(paramString);
        if (paramLong2 < paramGroupInfo.lMemberSeq) {
          if (RegisterProxyHandler.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(4, paramToServiceMsg, paramFromServiceMsg, paramGroupInfo);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 1, paramGroupInfo.lMemberSeq);
          }
        }
      }
      else if (paramLong2 < paramGroupInfo.lMemberSeq)
      {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, 1);
      }
    }
    if (paramHashMap != null) {
      paramHashMap.remove(paramString);
    }
    if (paramGroupInfo.lMask != 0L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c = new ArrayList();
      }
      paramToServiceMsg = new Setting();
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("message.group.policy.");
      paramFromServiceMsg.append(paramString);
      paramToServiceMsg.Path = paramFromServiceMsg.toString();
      paramToServiceMsg.Value = String.valueOf(paramGroupInfo.lMask);
      this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c.add(paramToServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp, long paramLong, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong);
    if ((paramString instanceof RecommendCommonMessage))
    {
      if ((paramPbSendMsgResp.text_analysis_result.has()) && (paramPbSendMsgResp.text_analysis_result.get() == 1)) {
        paramPbSendMsgResp = "1";
      } else {
        paramPbSendMsgResp = "0";
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleSendDiscussionMsgRespPB text_analysis_result=");
        localStringBuilder.append(paramPbSendMsgResp);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      paramString.saveExtInfoToExtStr("ark_text_analysis_flag", paramPbSendMsgResp);
    }
    paramPbSendMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramToServiceMsg.extraData.getString("uToUin"), 3000, paramLong);
    paramToServiceMsg.extraData.putBoolean("isJuhuaExist", MessageCache.a(paramPbSendMsgResp));
    long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
    if (l3 > 0L)
    {
      if ((paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null) && (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null))
      {
        long l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        if (l1 <= 2147483647L) {
          break label253;
        }
      }
      long l1 = 0L;
      label253:
      paramPbSendMsgResp = new MessageHandlerConstants.MsgSendCostParams();
      paramPbSendMsgResp.jdField_c_of_type_Long = l1;
      paramPbSendMsgResp.d = System.currentTimeMillis();
      paramPbSendMsgResp.jdField_b_of_type_Long = (paramPbSendMsgResp.d - l3);
      paramPbSendMsgResp.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
      paramPbSendMsgResp.jdField_a_of_type_Int = 3000;
      paramPbSendMsgResp.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
      paramPbSendMsgResp.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      paramPbSendMsgResp.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
      notifyUI(6003, true, new Object[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(paramLong), paramPbSendMsgResp });
    }
    else
    {
      notifyUI(6003, true, new String[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(paramLong) });
    }
    a(paramString);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, String paramString, ArrayList<msg_comm.Msg> paramArrayList)
  {
    try
    {
      a("troop_processor").a(1003, new Object[] { paramToServiceMsg, paramPbGetGroupMsgResp, paramArrayList, paramString });
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB refreshTroopHead exception ! ", paramToServiceMsg);
      }
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong, ArrayList<msg_comm.Msg> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 953
    //   4: invokevirtual 956	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;)Lcom/tencent/imcore/message/BaseMessageProcessor;
    //   7: sipush 1002
    //   10: iconst_4
    //   11: anewarray 51	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload 8
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: aload_2
    //   26: aastore
    //   27: dup
    //   28: iconst_3
    //   29: aload 5
    //   31: aastore
    //   32: invokevirtual 1324	com/tencent/imcore/message/BaseMessageProcessor:a	(I[Ljava/lang/Object;)V
    //   35: iload 4
    //   37: ifeq +63 -> 100
    //   40: goto +29 -> 69
    //   43: astore_1
    //   44: goto +303 -> 347
    //   47: astore_1
    //   48: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +13 -> 64
    //   54: ldc 198
    //   56: iconst_2
    //   57: ldc_w 1329
    //   60: aload_1
    //   61: invokestatic 739	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   64: iload 4
    //   66: ifeq +34 -> 100
    //   69: aload_0
    //   70: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   73: astore_1
    //   74: aload_1
    //   75: aload_1
    //   76: getfield 1330	com/tencent/mobileqq/app/handler/RegisterProxyHandler:h	I
    //   79: iconst_1
    //   80: iadd
    //   81: putfield 1330	com/tencent/mobileqq/app/handler/RegisterProxyHandler:h	I
    //   84: aload_0
    //   85: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   88: lload 6
    //   90: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   93: iconst_2
    //   94: invokevirtual 1299	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;I)V
    //   97: goto +15 -> 112
    //   100: aload_0
    //   101: lload 6
    //   103: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   106: ldc_w 1332
    //   109: invokespecial 1334	com/tencent/mobileqq/app/MessageHandler:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: iload_3
    //   113: ifeq +79 -> 192
    //   116: aload_0
    //   117: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   120: invokevirtual 1336	com/tencent/mobileqq/service/message/MessageCache:b	()Z
    //   123: ifeq +223 -> 346
    //   126: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +12 -> 141
    //   132: ldc 198
    //   134: iconst_2
    //   135: ldc_w 1338
    //   138: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: new 220	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   148: astore_1
    //   149: aload_1
    //   150: ldc_w 561
    //   153: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: lload 6
    //   160: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore_1
    //   169: invokestatic 1344	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   172: invokevirtual 1347	com/tencent/util/MsgAutoMonitorUtil:markGrpFinishTime	()V
    //   175: aload_0
    //   176: sipush 4003
    //   179: iconst_1
    //   180: iconst_1
    //   181: anewarray 452	java/lang/String
    //   184: dup
    //   185: iconst_0
    //   186: aload_1
    //   187: aastore
    //   188: invokevirtual 992	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   191: return
    //   192: iload 4
    //   194: ifeq +110 -> 304
    //   197: aload_0
    //   198: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   201: getfield 1348	com/tencent/mobileqq/app/handler/RegisterProxyHandler:jdField_f_of_type_Int	I
    //   204: ifeq +142 -> 346
    //   207: aload_0
    //   208: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   211: getfield 1330	com/tencent/mobileqq/app/handler/RegisterProxyHandler:h	I
    //   214: aload_0
    //   215: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   218: getfield 1348	com/tencent/mobileqq/app/handler/RegisterProxyHandler:jdField_f_of_type_Int	I
    //   221: if_icmplt +125 -> 346
    //   224: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +61 -> 288
    //   230: new 220	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   237: astore_1
    //   238: aload_1
    //   239: ldc_w 1350
    //   242: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_1
    //   247: aload_0
    //   248: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   251: getfield 1348	com/tencent/mobileqq/app/handler/RegisterProxyHandler:jdField_f_of_type_Int	I
    //   254: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_1
    //   259: ldc_w 1352
    //   262: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_1
    //   267: aload_0
    //   268: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   271: getfield 1330	com/tencent/mobileqq/app/handler/RegisterProxyHandler:h	I
    //   274: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: ldc 198
    //   280: iconst_2
    //   281: aload_1
    //   282: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: invokestatic 1344	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   291: invokevirtual 1347	com/tencent/util/MsgAutoMonitorUtil:markGrpFinishTime	()V
    //   294: aload_0
    //   295: sipush 4003
    //   298: iconst_1
    //   299: aconst_null
    //   300: invokevirtual 992	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   303: return
    //   304: new 220	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   311: astore_1
    //   312: aload_1
    //   313: ldc_w 561
    //   316: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_1
    //   321: lload 6
    //   323: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_0
    //   328: sipush 4003
    //   331: iconst_1
    //   332: iconst_1
    //   333: anewarray 452	java/lang/String
    //   336: dup
    //   337: iconst_0
    //   338: aload_1
    //   339: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: aastore
    //   343: invokevirtual 992	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   346: return
    //   347: iload 4
    //   349: ifeq +34 -> 383
    //   352: aload_0
    //   353: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   356: astore_2
    //   357: aload_2
    //   358: aload_2
    //   359: getfield 1330	com/tencent/mobileqq/app/handler/RegisterProxyHandler:h	I
    //   362: iconst_1
    //   363: iadd
    //   364: putfield 1330	com/tencent/mobileqq/app/handler/RegisterProxyHandler:h	I
    //   367: aload_0
    //   368: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   371: lload 6
    //   373: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   376: iconst_2
    //   377: invokevirtual 1299	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;I)V
    //   380: goto +15 -> 395
    //   383: aload_0
    //   384: lload 6
    //   386: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   389: ldc_w 1332
    //   392: invokespecial 1334	com/tencent/mobileqq/app/MessageHandler:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_1
    //   396: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	MessageHandler
    //   0	397	1	paramToServiceMsg	ToServiceMsg
    //   0	397	2	paramPbGetGroupMsgResp	msg_svc.PbGetGroupMsgResp
    //   0	397	3	paramBoolean1	boolean
    //   0	397	4	paramBoolean2	boolean
    //   0	397	5	paramString	String
    //   0	397	6	paramLong	long
    //   0	397	8	paramArrayList	ArrayList<msg_comm.Msg>
    // Exception table:
    //   from	to	target	type
    //   0	35	43	finally
    //   48	64	43	finally
    //   0	35	47	java/lang/Exception
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object localObject = (Object[])paramObject;
      if ((localObject != null) && (localObject.length > 2))
      {
        paramObject = (String)localObject[0];
        ((Integer)localObject[1]).intValue();
        if (((Integer)localObject[2]).intValue() == 58)
        {
          FriendShieldUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (!((FriendsManager)localObject).e(paramObject))
          {
            Friends localFriends = ((FriendsManager)localObject).e(String.valueOf(paramObject));
            if (localFriends != null)
            {
              localFriends.setShieldFlag(true);
              ((FriendsManager)localObject).a(localFriends);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(55, true, new Object[] { Long.valueOf(Long.parseLong(paramObject)), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), "" });
            }
          }
        }
      }
    }
  }
  
  private void a(Object paramObject, boolean paramBoolean1, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("handleGetPullTroopMsgResp msgStruct.cReplyCode = ");
      localStringBuilder.append(paramPbGetGroupMsgResp.result.get());
      localStringBuilder.append(" troopUin: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",isRefreshHead:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", dataHash=@");
      localStringBuilder.append(Integer.toHexString(paramObject.hashCode()));
      localStringBuilder.append(" rtnBeginSeq:");
      localStringBuilder.append(paramPbGetGroupMsgResp.return_begin_seq.get());
      localStringBuilder.append(" rtnEndSeq:");
      localStringBuilder.append(paramPbGetGroupMsgResp.return_end_seq.get());
      localStringBuilder.append(",doSome:");
      localStringBuilder.append(paramInt);
      if (!paramBoolean1)
      {
        localStringBuilder.append(",costTime = [");
        localStringBuilder.append(System.currentTimeMillis() - BaseMessageManagerForTroopAndDisc.jdField_a_of_type_Long);
        localStringBuilder.append("]");
      }
      if (paramPbGetGroupMsgResp.msg.get() != null)
      {
        localStringBuilder.append(" msgSize:");
        localStringBuilder.append(paramPbGetGroupMsgResp.msg.get().size());
      }
      else
      {
        localStringBuilder.append(" msg:null.");
      }
      if (QLog.isColorLevel())
      {
        if (paramBoolean1) {
          paramObject = "Q.msg.MessageHandler.troop.register_proxy_pull_msg";
        } else {
          paramObject = "Q.msg.MessageHandler.trooptroop_pull_msg";
        }
        QLog.d(paramObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  private void a(String paramString1, String paramString2, byte paramByte, boolean paramBoolean, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ClientMsg");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putLong("to", Long.valueOf(paramString1).longValue());
    localToServiceMsg.extraData.putString("msg", paramString2);
    localToServiceMsg.extraData.putByte("cType", paramByte);
    localToServiceMsg.extraData.putBoolean("hello", paramBoolean);
    localToServiceMsg.extraData.putString("pyNickname", paramString3);
    localToServiceMsg.extraData.putLong("uniseq", paramLong2);
    localToServiceMsg.extraData.putLong("msgSeq", paramLong1);
    localToServiceMsg.extraData.putLong("timeOut", paramLong3);
    localToServiceMsg.setTimeout(paramLong3);
    send(localToServiceMsg);
  }
  
  private void a(String[] paramArrayOfString, HashMap paramHashMap)
  {
    if (!paramHashMap.isEmpty())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGetPullTroopMsgNumResp  RegisterProxyTroopSeq FailedTroopSize=");
        localStringBuilder.append(paramHashMap.size());
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      paramHashMap = paramHashMap.keySet().iterator();
      while (paramHashMap.hasNext()) {
        g((String)paramHashMap.next());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b()) {
      notifyUI(4003, true, paramArrayOfString);
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if (msgCmdFilter(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramString);
        QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
      }
      return true;
    }
    if ((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013))
    {
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return true;
      }
      return this.jdField_f_of_type_Boolean;
    }
    TimeOut.a(this, paramToServiceMsg, paramFromServiceMsg);
    return true;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    if ((paramPbGetDiscussMsgResp.msg.get() != null) && (paramPbGetDiscussMsgResp.msg.get().size() > 0))
    {
      boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq");
      long l3 = paramPbGetDiscussMsgResp.return_begin_seq.get();
      long l2 = paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pullNextDisMsg disUin: ");
        localStringBuilder.append(l2);
        localStringBuilder.append(" res.cReplyCode: ");
        localStringBuilder.append(paramPbGetDiscussMsgResp.result.get());
        localStringBuilder.append(" srcBegSeq: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(" srcEndSeq: ");
        localStringBuilder.append(paramToServiceMsg.extraData.getLong("lEndSeq"));
        localStringBuilder.append(" res.lReturnBeginSeq: ");
        localStringBuilder.append(l3);
        localStringBuilder.append(" res.lReturnEndSeq: ");
        localStringBuilder.append(paramPbGetDiscussMsgResp.return_end_seq.get());
        localStringBuilder.append(" res.vMsgs.size(): ");
        localStringBuilder.append(paramPbGetDiscussMsgResp.msg.get().size());
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(l2, paramPbGetDiscussMsgResp.msg.get());
      if ((!bool1) && (!bool2))
      {
        l3 -= 1L;
        if ((l1 <= l3) && (paramPbGetDiscussMsgResp.return_begin_seq.get() <= paramPbGetDiscussMsgResp.return_end_seq.get())) {
          return a(l2, l1, l3, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"));
        }
      }
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp)
  {
    if ((paramPbGetGroupMsgResp.msg.get() != null) && (paramPbGetGroupMsgResp.msg.get().size() > 0))
    {
      boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
      }
      long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq", 0L);
      long l2 = paramPbGetGroupMsgResp.return_begin_seq.get();
      int j;
      if (paramPbGetGroupMsgResp.msg.get() != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("pullNextTroopMsg troopUin: ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" msgStruct.cReplyCode: ");
        localStringBuilder.append(paramPbGetGroupMsgResp.result.get());
        localStringBuilder.append(" lBeginSeq: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(" lEndSeq: ");
        localStringBuilder.append(paramToServiceMsg.extraData.getLong("lEndSeq"));
        localStringBuilder.append(" res.lReturnBeginSeq: ");
        localStringBuilder.append(l2);
        localStringBuilder.append(" res.lReturnEndSeq: ");
        localStringBuilder.append(paramPbGetGroupMsgResp.return_end_seq.get());
        localStringBuilder.append(" msg.size(): ");
        if (j != 0) {
          localObject2 = Integer.valueOf(paramPbGetGroupMsgResp.msg.get().size());
        } else {
          localObject2 = "null";
        }
        localStringBuilder.append(localObject2);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramPbGetGroupMsgResp.group_code.get(), paramPbGetGroupMsgResp.msg.get());
      l2 -= 1L;
      if ((!bool1) && (!bool2) && (l1 <= l2) && (paramPbGetGroupMsgResp.return_begin_seq.get() <= paramPbGetGroupMsgResp.return_end_seq.get())) {
        return a((String)localObject1, l1, l2, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"), paramToServiceMsg.extraData.getInt("doSome"));
      }
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt, TroopManager paramTroopManager, Object[] paramArrayOfObject)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
    boolean bool = false;
    if (localHotChatInfo != null)
    {
      if ((paramInt != 108) && (paramInt != 102))
      {
        if (paramInt != 0) {
          break label241;
        }
      }
      else
      {
        if (localHotChatInfo != null)
        {
          HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo);
          return false;
        }
        paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        paramString = paramTroopManager.a(paramString, 1);
        if (paramString != null) {
          paramTroopManager.a(paramString);
        }
        a(1002, true, paramArrayOfObject);
        a(2001, true, paramArrayOfObject);
        a(2002, true, paramArrayOfObject);
        return false;
      }
    }
    else if ((paramInt != 0) && (paramInt != 241))
    {
      switch (paramInt)
      {
      default: 
        return false;
      }
      paramTroopManager.b(paramString);
      paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      paramString = paramTroopManager.a(paramString, 1);
      if (paramString != null) {
        paramTroopManager.a(paramString);
      }
      a(1002, true, paramArrayOfObject);
      a(2001, true, paramArrayOfObject);
      a(2002, true, paramArrayOfObject);
      return false;
    }
    bool = true;
    label241:
    return bool;
  }
  
  private boolean a(boolean paramBoolean, long paramLong, MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof ChatMessage)) {
      return paramBoolean;
    }
    ((ChatMessage)paramMessageRecord).parse();
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      return paramBoolean;
    }
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if (paramMessageRecord.structingMsg == null) {
      return paramBoolean;
    }
    int j = paramMessageRecord.structingMsg.mMsgServiceID;
    if ((j != 35) && (j != 107)) {
      return paramBoolean;
    }
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("current mr is multimsg, uniseq:");
      paramMessageRecord.append(paramLong);
      paramMessageRecord.append(",");
      QLog.d("Q.msg.MessageHandler", 2, paramMessageRecord.toString());
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean, ArrayList<MessageRecord> paramArrayList, Iterator<Map.Entry<String, ConcurrentHashMap<Long, MessageCache.MsgSendingInfo>>> paramIterator)
  {
    paramIterator = ((ConcurrentHashMap)((Map.Entry)paramIterator.next()).getValue()).entrySet().iterator();
    while (paramIterator.hasNext()) {
      paramBoolean = b(paramBoolean, paramArrayList, paramIterator);
    }
    return paramBoolean;
  }
  
  @Nullable
  private msg_svc.PbSendMsgResp b(Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      return localPbSendMsgResp;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleSendDiscussionMsgRespPB:");
        if (paramObject == null) {
          paramObject = "null";
        } else {
          paramObject = Arrays.toString((byte[])paramObject);
        }
        localStringBuilder.append(paramObject);
        QLog.e("Q.msg.MessageHandler", 2, localStringBuilder.toString(), localException);
      }
    }
    return null;
  }
  
  private void b(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "sendHCTopicMessageInner");
    }
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null) {
      l1 = 0L;
    } else {
      l1 = paramMessageRecord.msg.getBytes().length;
    }
    Object localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramMessageRecord.frienduin);
    oidb_0xa89.ReqBody localReqBody = new oidb_0xa89.ReqBody();
    localReqBody.bytes_msg_body.set(ByteStringMicro.copyFrom(paramPbSendMsgReq.toByteArray()));
    localReqBody.bytes_poid.set(ByteStringMicro.copyFrom(((HotChatInfo)localObject).uuid.getBytes()));
    localObject = makeOIDBPkg("OidbSvc.0xa89", 2697, 1, localReqBody.toByteArray(), paramLong, paramBusinessObserver, false);
    ((ToServiceMsg)localObject).extraData.putString("uin", paramMessageRecord.frienduin);
    ((ToServiceMsg)localObject).extraData.putLong("msgsize", l1);
    ((ToServiceMsg)localObject).extraData.putLong("uniseq", paramMessageRecord.uniseq);
    ((ToServiceMsg)localObject).extraData.putLong("timeOut", paramLong);
    ((ToServiceMsg)localObject).extraData.putLong("msgSeq", paramMessageRecord.msgseq);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", l2);
    ((ToServiceMsg)localObject).extraData.putInt("retryIndex", paramInt);
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramMessageRecord.istroop);
    ((ToServiceMsg)localObject).extraData.putInt("msgtype", paramMessageRecord.msgtype);
    ((ToServiceMsg)localObject).extraData.putString("groupuin", paramMessageRecord.frienduin);
    if (MsgProxyUtils.i(paramMessageRecord.msgtype)) {
      ((ToServiceMsg)localObject).extraData.putBoolean("RichNotify", true);
    }
    ((ToServiceMsg)localObject).extraData.putInt("ROUNTING_TYPE", 21);
    ((ToServiceMsg)localObject).extraData.putInt("send_msg_req_size", ((ToServiceMsg)localObject).getWupBuffer().length);
    ((ToServiceMsg)localObject).extraData.putLong("msg_request_time", paramMessageRecord.time);
    ((ToServiceMsg)localObject).addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
    ((ToServiceMsg)localObject).addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
    ((ToServiceMsg)localObject).addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
    ((ToServiceMsg)localObject).addAttribute("retryIndex", Integer.valueOf(paramInt));
    paramPbSendMsgReq = paramMessageRecord.frienduin;
    paramBusinessObserver = "";
    if (paramPbSendMsgReq == null) {
      paramPbSendMsgReq = "";
    } else {
      paramPbSendMsgReq = paramMessageRecord.frienduin;
    }
    ((ToServiceMsg)localObject).addAttribute("uin", paramPbSendMsgReq);
    if (paramMessageRecord.senderuin == null) {
      paramMessageRecord = paramBusinessObserver;
    } else {
      paramMessageRecord = paramMessageRecord.senderuin;
    }
    ((ToServiceMsg)localObject).addAttribute("fromUin", paramMessageRecord);
    ((ToServiceMsg)localObject).addAttribute("normal_msg", Boolean.valueOf(true));
    a((ToServiceMsg)localObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      int j = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      StatictisInfo localStatictisInfo = new StatictisInfo();
      if (paramBoolean)
      {
        localStatictisInfo.b = paramFromServiceMsg.getResultCode();
        localStatictisInfo.c = (j + 1);
      }
      else
      {
        localStatictisInfo.b = 2900;
        localStatictisInfo.c = (j + 1);
        localStatictisInfo.jdField_a_of_type_Long = paramInt;
        localStatictisInfo.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      }
      localStatictisInfo.jdField_d_of_type_Int = 1;
      a(paramToServiceMsg, 5006, paramBoolean, new Object[] { Long.valueOf(paramLong), localStatictisInfo });
    }
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 2)) {
        ((Integer)paramObject[2]).intValue();
      }
    }
  }
  
  private void b(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1000) && (paramString != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("funName:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("notification", 2, localStringBuilder.toString());
    }
  }
  
  private void b(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(AppShareIDUtil.a(((Long)paramArrayList.next()).longValue()));
    }
    a(localArrayList);
  }
  
  private boolean b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("----------handleMsgGetting: ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        a(true);
        f(paramBoolean);
        return false;
      }
      return true;
    }
  }
  
  private boolean b(boolean paramBoolean, ArrayList<MessageRecord> paramArrayList, Iterator<Map.Entry<Long, MessageCache.MsgSendingInfo>> paramIterator)
  {
    Object localObject = (MessageCache.MsgSendingInfo)((Map.Entry)paramIterator.next()).getValue();
    paramIterator = ((MessageCache.MsgSendingInfo)localObject).jdField_a_of_type_JavaLangString;
    int j = ((MessageCache.MsgSendingInfo)localObject).jdField_a_of_type_Int;
    long l1 = ((MessageCache.MsgSendingInfo)localObject).jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramIterator, j, l1);
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramIterator, j, l1);
      return paramBoolean;
    }
    paramBoolean = a(paramBoolean, l1, (MessageRecord)localObject);
    long l2 = ((MessageRecord)localObject).time;
    long l3 = MessageCache.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgSending:setMsgSendingInfo, uin:");
      localStringBuilder.append(paramIterator);
      localStringBuilder.append(" istroop:");
      localStringBuilder.append(j);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" time:");
      localStringBuilder.append(l2);
      localStringBuilder.append(" currentServerTime:");
      localStringBuilder.append(l3);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (!paramBoolean)
    {
      l2 = l3 - l2;
      if ((1000L * l2 + 30000L < 480000L) && (l2 >= 0L))
      {
        if (QLog.isColorLevel())
        {
          paramIterator = new StringBuilder();
          paramIterator.append("msgSending:resend msg, key =");
          paramIterator.append(((MessageRecord)localObject).uniseq);
          paramIterator.append("+");
          paramIterator.append(((MessageRecord)localObject).frienduin);
          paramIterator.append("+");
          paramIterator.append(((MessageRecord)localObject).istroop);
          QLog.d("Q.msg.MessageHandler", 2, paramIterator.toString());
        }
        MsgProxyUtils.b(paramArrayList, (MessageRecord)localObject, true);
        return paramBoolean;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "msgSending:msg sending flag set to failed");
    }
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramIterator, j);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramIterator, j, l1);
    if ((paramArrayList != null) && (paramArrayList.uniseq == l1)) {
      paramArrayList.setExtraFlag(32768);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIterator, j, l1, 32768, 1002);
    notifyUI(6003, false, new String[] { paramIterator, String.valueOf(l1) });
    return paramBoolean;
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "msgSending:addSendingCache suc");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord);
    if ((paramMessageRecord.msgtype == -1051) && ((paramMessageRecord instanceof MessageForLongTextMsg)) && (((MessageForLongTextMsg)paramMessageRecord).structingMsg == null))
    {
      ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, true);
      return;
    }
    a(paramMessageRecord, null, true);
  }
  
  private void c(ArrayList<MessageRecord> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      c((MessageRecord)paramArrayList.next());
    }
  }
  
  private void d(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1, 2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----------handleTroopMsgResponseFinishedAndNotify troopUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", funcName:");
      localStringBuilder.append(paramString2);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString1);
      paramString2 = ((ArrayList)localObject).iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 2)) {
          a("troop_processor").a(1001, new Object[] { localObject, null, Boolean.valueOf(false) });
        }
      }
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (paramString1 != null) {
      ((TroopMessageProcessor)a("troop_processor")).a(paramString1);
    }
  }
  
  private boolean d(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt == 35) {
        return bool1;
      }
      if (paramInt != 241) {
        bool1 = bool2;
      }
    }
    switch (paramInt)
    {
    default: 
      return false;
      bool1 = true;
    }
    return bool1;
  }
  
  private void e(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("handleDiscMsgResponseFinishAndNotify uin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", funcName=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString1, 2);
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString1);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = new ArrayList(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(paramString1);
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 3)) {
          a("disc_processor").a(1001, new Object[] { localObject[0], localObject[1], localObject[2], Boolean.valueOf(false) });
        }
      }
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (paramString1 != null) {
      ((DiscMessageProcessor)a("disc_processor")).a(paramString1);
    }
  }
  
  private boolean e()
  {
    synchronized (this.jdField_b_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("----------handlePAMsgGetting: ");
        localStringBuilder.append(this.jdField_c_of_type_Boolean);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        b(true);
        return false;
      }
      return true;
    }
  }
  
  private void f(String paramString)
  {
    e(paramString, "closeDisOnlineMsgCache");
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    d(paramString, "closeTroopOnlineMsgCache");
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int m = paramToServiceMsg.extraData.getInt("msgtype");
    int n = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int j = paramToServiceMsg.extraData.getInt("retryIndex");
    int k = MessageProtoCodec.a(n, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<PbSendMsg><E><---handleSendC2CMessageError: ---cmd:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ssoseq:");
    localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
    localStringBuilder.append(" appseq:");
    localStringBuilder.append(paramFromServiceMsg.getAppSeq());
    localStringBuilder.append(",sendC2CMessage error : peerUin:");
    localStringBuilder.append(MsfSdkUtils.getShortUin(str));
    localStringBuilder.append(" uniseq:");
    localStringBuilder.append(l1);
    localStringBuilder.append(" msgSeq:");
    localStringBuilder.append(l2);
    localStringBuilder.append(" msgType:");
    localStringBuilder.append(m);
    localStringBuilder.append(" uinType:");
    localStringBuilder.append(k);
    localStringBuilder.append(" routingType:");
    localStringBuilder.append(n);
    localStringBuilder.append(" retryIndex:");
    localStringBuilder.append(j);
    localObject = localStringBuilder.toString();
    QLog.e("Q.msg.MessageHandler", 1, (String)localObject);
    a(l1, (String)localObject, str, k, "SendMessageError");
    a(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l2);
    if (localObject != null)
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (a((SendMessageHandler)localObject, "msf"))) {
        return;
      }
      if ((480000L == l3) || (((SendMessageHandler)localObject).a()))
      {
        m = b(n);
        localObject = new Object[6];
        localObject[0] = str;
        localObject[1] = Integer.valueOf(k);
        localObject[2] = Integer.valueOf(0);
        localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
        localObject[4] = Long.valueOf(l3);
        localObject[5] = Long.valueOf(l1);
        a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
        a(m, false, localObject);
        if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
        {
          localObject = new StatictisInfo();
          ((StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
          ((StatictisInfo)localObject).c = j;
          ((StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
          a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l1), localObject });
          a(str, k, l1, false);
        }
        Report.c(this, paramToServiceMsg, paramFromServiceMsg, false);
        a(l2);
      }
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int j = paramToServiceMsg.extraData.getInt("msgtype");
    int k = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int m = paramToServiceMsg.extraData.getInt("retryIndex");
    int n = MessageProtoCodec.a(k, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbSendMsg><E><---handleSendGrpMessageError: ---cmd:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ssoseq:");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" appseq:");
      localStringBuilder.append(paramFromServiceMsg.getAppSeq());
      localStringBuilder.append(",sendC2CMessage error : peerUin:");
      localStringBuilder.append(str);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(l3);
      localStringBuilder.append(" msgSeq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" msgType:");
      localStringBuilder.append(j);
      localStringBuilder.append(" uinType:");
      localStringBuilder.append(n);
      localStringBuilder.append(" routingType:");
      localStringBuilder.append(k);
      localStringBuilder.append(" retryIndex:");
      localStringBuilder.append(m);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    a(paramToServiceMsg, paramFromServiceMsg);
    ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l3);
    localObject = a(l1);
    if (localObject != null)
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (a((SendMessageHandler)localObject, "msf"))) {
        return;
      }
      if ((480000L == l2) || (((SendMessageHandler)localObject).a()))
      {
        localObject = new Object[6];
        localObject[0] = paramToServiceMsg.extraData.getString("groupuin");
        localObject[1] = Integer.valueOf(1);
        localObject[2] = Integer.valueOf(0);
        localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
        localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
        localObject[5] = Long.valueOf(l3);
        a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
        a(3002, false, localObject);
        if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
        {
          j = paramToServiceMsg.extraData.getInt("retryIndex", 0);
          localObject = new StatictisInfo();
          ((StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
          ((StatictisInfo)localObject).c = j;
          ((StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
          a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
        }
        Report.a(this, paramToServiceMsg, paramFromServiceMsg, false);
        a(l1);
      }
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a())
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      Object localObject1;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleGetPullDiscussionMsgNumberFinish vConfNumInfo size = ");
          ((StringBuilder)localObject1).append(((List)localObject2).size());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new StringBuilder();
        HashMap localHashMap = new HashMap(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c());
        Iterator localIterator = ((List)localObject2).iterator();
        for (;;)
        {
          localObject2 = localHashMap;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (stConfNumInfo)localIterator.next();
          if (localObject2 != null)
          {
            String str = String.valueOf(((stConfNumInfo)localObject2).lConfUin);
            Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str);
            long l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(str);
            long l1;
            if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {
              l1 = ((Long)arrayOfObject[0]).longValue();
            } else {
              l1 = 0L;
            }
            if (QLog.isColorLevel())
            {
              ((StringBuilder)localObject1).setLength(0);
              ((StringBuilder)localObject1).append("addDisMsgMemberSeq uin = ");
              ((StringBuilder)localObject1).append(((stConfNumInfo)localObject2).lConfUin);
              ((StringBuilder)localObject1).append(" memberseq = ");
              ((StringBuilder)localObject1).append(((stConfNumInfo)localObject2).uMemberMsgSeq);
              ((StringBuilder)localObject1).append(" confMsgSeq =");
              ((StringBuilder)localObject1).append(((stConfNumInfo)localObject2).uConfMsgSeq);
              ((StringBuilder)localObject1).append(" localLastSeq =");
              ((StringBuilder)localObject1).append(l2);
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(String.valueOf(((stConfNumInfo)localObject2).lConfUin), new Object[] { Long.valueOf(((stConfNumInfo)localObject2).uMemberMsgSeq), Long.valueOf(((stConfNumInfo)localObject2).uConfMsgSeq) });
            if (((stConfNumInfo)localObject2).uConfMsgSeq <= l2)
            {
              f(str);
              if (l1 < ((stConfNumInfo)localObject2).uMemberMsgSeq) {
                if (RegisterProxyHandler.jdField_b_of_type_Boolean) {
                  this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(5, null, null, localObject2);
                } else {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, 3000, ((stConfNumInfo)localObject2).uMemberMsgSeq);
                }
              }
            }
            else if (l1 < ((stConfNumInfo)localObject2).uMemberMsgSeq)
            {
              this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str, 1);
            }
            localHashMap.remove(str);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo is null ! ");
      }
      localObject2 = null;
      if ((localObject2 != null) && (!((HashMap)localObject2).isEmpty()))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleGetPullDiscussionMsgNumberFinish  RegisterProxyDiscSeq FailedDiscSize=");
          ((StringBuilder)localObject1).append(((HashMap)localObject2).size());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = ((HashMap)localObject2).keySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          f((String)((Iterator)localObject1).next());
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c()) {
        notifyUI(4002, true, null);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumber waitting ... ");
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int j = paramToServiceMsg.extraData.getInt("msgtype");
    int k = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int m = paramToServiceMsg.extraData.getInt("retryIndex");
    int n = MessageProtoCodec.a(k, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbSendMsg><E><---handleSendDisMessageError: ---cmd:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ssoseq:");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" appseq:");
      localStringBuilder.append(paramFromServiceMsg.getAppSeq());
      localStringBuilder.append(",sendC2CMessage error : peerUin:");
      localStringBuilder.append(str);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(l3);
      localStringBuilder.append(" msgSeq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" msgType:");
      localStringBuilder.append(j);
      localStringBuilder.append(" uinType:");
      localStringBuilder.append(n);
      localStringBuilder.append(" routingType:");
      localStringBuilder.append(k);
      localStringBuilder.append(" retryIndex:");
      localStringBuilder.append(m);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l3);
    a(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l1);
    if (localObject != null)
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (a((SendMessageHandler)localObject, "msf"))) {
        return;
      }
      if ((480000L == l2) || (((SendMessageHandler)localObject).a()))
      {
        localObject = new Object[6];
        localObject[0] = paramToServiceMsg.extraData.getString("uToUin");
        localObject[1] = Integer.valueOf(3000);
        localObject[2] = Integer.valueOf(0);
        localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
        localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
        localObject[5] = Long.valueOf(l3);
        a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
        a(3008, false, localObject);
        if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
        {
          j = paramToServiceMsg.extraData.getInt("retryIndex", 0);
          localObject = new StatictisInfo();
          ((StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
          ((StatictisInfo)localObject).c = j;
          ((StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
          a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
        }
        Report.d(this, paramToServiceMsg, paramFromServiceMsg, false);
        a(l1);
      }
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumError isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int j;
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetPullDiscussionMsgNumError size = ");
      if (paramToServiceMsg == null) {
        j = 0;
      } else {
        j = paramToServiceMsg.length;
      }
      paramFromServiceMsg.append(j);
      QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
    }
    if (paramToServiceMsg != null)
    {
      int k = paramToServiceMsg.length;
      j = 0;
      while (j < k)
      {
        paramFromServiceMsg = paramToServiceMsg[j];
        try
        {
          e(paramFromServiceMsg, "handleGetPullDiscussionMsgNumError");
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumError exception ! ", paramFromServiceMsg);
          }
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramToServiceMsg);
      s();
    }
    notifyUI(4002, false, null);
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int k = a(localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = a(1, paramLong1, paramLong2, paramInt1, paramInt2);
    int j = 0;
    paramInt1 = 0;
    for (;;)
    {
      paramInt2 = j;
      if (paramInt1 >= 3) {
        break;
      }
      localSendMessageHandler.a(new MessageHandler.2(this, localPbSendMsgReq, k, paramLong2));
      paramInt1 += 1;
    }
    while (paramInt2 <= 3)
    {
      localSendMessageHandler.a(paramInt2 * 30000L / 3L, 10000L, "period");
      paramInt2 += 1;
    }
    return k;
  }
  
  public SvcRequestGetMsgV2 a()
  {
    SvcRequestGetMsgV2 localSvcRequestGetMsgV2 = new SvcRequestGetMsgV2();
    localSvcRequestGetMsgV2.lUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localSvcRequestGetMsgV2.uDateTime = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
    localSvcRequestGetMsgV2.cRecivePic = 1;
    localSvcRequestGetMsgV2.shAbility = 15;
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
    localSvcRequestGetMsgV2.cChannel = 4;
    localSvcRequestGetMsgV2.cInst = 1;
    localSvcRequestGetMsgV2.cChannelEx = 1;
    localSvcRequestGetMsgV2.cSyncFlag = 0;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      localSvcRequestGetMsgV2.vSyncCookie = arrayOfByte;
    }
    localSvcRequestGetMsgV2.cRambleFlag = 0;
    localSvcRequestGetMsgV2.lGeneralAbi = 1L;
    arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      localSvcRequestGetMsgV2.vPubAccountCookie = arrayOfByte;
    }
    return localSvcRequestGetMsgV2;
  }
  
  public SvcRequestPullDisMsgSeq a(int paramInt)
  {
    Object localObject1 = new ArrayList();
    int k = 0;
    int j = 0;
    localObject1 = new SvcRequestPullDisMsgSeq((ArrayList)localObject1, (byte)0);
    StringBuilder localStringBuilder;
    Object localObject2;
    Object localObject3;
    if (paramInt == 4)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString.length != 0))
      {
        k = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString.length;
        localStringBuilder = new StringBuilder();
        paramInt = j;
        while (paramInt < k)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString[paramInt];
          localObject3 = new MessageSvcPack.PullDisSeqParam();
          ((MessageSvcPack.PullDisSeqParam)localObject3).lDisCode = Long.parseLong((String)localObject2);
          ((MessageSvcPack.PullDisSeqParam)localObject3).lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i((String)localObject2);
          ((SvcRequestPullDisMsgSeq)localObject1).vDisInfo.add(localObject3);
          if (QLog.isColorLevel())
          {
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",");
          }
          paramInt += 1;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("--->>getSvcRequestPullDisMsgSeq disUinArray: ");
          ((StringBuilder)localObject2).append(localStringBuilder.toString());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
          return localObject1;
        }
      }
      else
      {
        notifyUI(4002, true, null);
        return null;
      }
    }
    else
    {
      localObject2 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
      if (((ArrayList)localObject2).size() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString = null;
        notifyUI(4002, true, null);
        return null;
      }
      j = ((ArrayList)localObject2).size();
      this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString = new String[j];
      localStringBuilder = new StringBuilder();
      paramInt = k;
      while (paramInt < j)
      {
        localObject3 = (DiscussionInfo)((ArrayList)localObject2).get(paramInt);
        MessageSvcPack.PullDisSeqParam localPullDisSeqParam = new MessageSvcPack.PullDisSeqParam();
        localPullDisSeqParam.lDisCode = Long.parseLong(((DiscussionInfo)localObject3).uin);
        localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(((DiscussionInfo)localObject3).uin);
        this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = ((DiscussionInfo)localObject3).uin;
        ((SvcRequestPullDisMsgSeq)localObject1).vDisInfo.add(localPullDisSeqParam);
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(((DiscussionInfo)localObject3).uin);
          localStringBuilder.append(",");
        }
        paramInt += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--->>getSvcRequestPullDisMsgSeq disUinArray: ");
        ((StringBuilder)localObject2).append(localStringBuilder.toString());
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    return localObject1;
  }
  
  public SvcRequestPullGroupMsgSeq a(int paramInt)
  {
    Object localObject2 = new ArrayList();
    int j = MsgFilter.LIMIT_10_AND_IN_3_DAYS.value();
    Object localObject1;
    if (paramInt == 3)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNewTroopListUin(2);
      this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_ArrayOfJavaLangString;
    }
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      paramInt = 0;
      localObject2 = new SvcRequestPullGroupMsgSeq((ArrayList)localObject2, (byte)0, j);
      StringBuilder localStringBuilder = new StringBuilder();
      while (paramInt < localObject1.length)
      {
        PullGroupSeqParam localPullGroupSeqParam = new PullGroupSeqParam();
        try
        {
          localPullGroupSeqParam.lGroupCode = Long.parseLong(localObject1[paramInt]);
          localPullGroupSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.j(localObject1[paramInt]);
          ((SvcRequestPullGroupMsgSeq)localObject2).vGroupInfo.add(localPullGroupSeqParam);
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("; troopUin=");
            localStringBuilder.append(localObject1[paramInt]);
            localStringBuilder.append(",");
            localStringBuilder.append(" lastSeqId=");
            localStringBuilder.append(localPullGroupSeqParam.lLastSeqId);
          }
        }
        catch (Exception localException)
        {
          label190:
          break label190;
        }
        paramInt += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("--->>getSvcRequestPullGroupMsgSeq troopUinArray: ");
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
      }
      return localObject2;
    }
    else
    {
      notifyUI(4003, true, localObject1);
      return null;
    }
  }
  
  public SvcRequestPullDisGroupSeq a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString.length != 0))
    {
      new ArrayList();
      SvcRequestPullDisGroupSeq localSvcRequestPullDisGroupSeq = new SvcRequestPullDisGroupSeq();
      Object localObject = new ArrayList();
      int k = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString.length;
      StringBuilder localStringBuilder1 = new StringBuilder();
      int j = 0;
      while (j < k)
      {
        try
        {
          RegisterProxySvcPack.PullDisSeqParam localPullDisSeqParam = new RegisterProxySvcPack.PullDisSeqParam();
          localPullDisSeqParam.lDisCode = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString[j]);
          localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString[j]);
          ((ArrayList)localObject).add(localPullDisSeqParam);
          if (QLog.isColorLevel())
          {
            localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString[j]);
            localStringBuilder1.append(",");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("--->>getSvcRequestPullDisGroupSeq Exception: disUin=");
            localStringBuilder2.append(this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString[j]);
            QLog.e("Q.msg.MessageHandler", 2, localStringBuilder2.toString(), localException);
          }
        }
        j += 1;
      }
      if (((ArrayList)localObject).size() == 0)
      {
        notifyUI(4002, true, null);
        return null;
      }
      localSvcRequestPullDisGroupSeq.setVDisInfo((ArrayList)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("--->>getSvcRequestPullDisGroupSeq disUinArray: ");
        ((StringBuilder)localObject).append(localStringBuilder1.toString());
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      return localSvcRequestPullDisGroupSeq;
    }
    notifyUI(4002, true, null);
    return null;
  }
  
  public BaseMessageProcessor a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          if ("c2c_processor".equals(paramString))
          {
            localObject = new C2CMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("troop_processor".equals(paramString))
          {
            localObject = new TroopMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("disc_processor".equals(paramString))
          {
            localObject = new DiscMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("businessbase_processor".equals(paramString))
          {
            localObject = new OnLinePushMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("sub_account_processor".equals(paramString))
          {
            localObject = ((ISubAccountService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISubAccountService.class, "")).createSubAccountMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("accost_processor".equals(paramString))
          {
            localObject = new AccostMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("offlinefile_processor".equals(paramString))
          {
            localObject = new OfflineFileMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("system_processor".equals(paramString))
          {
            localObject = new SystemMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("uncommon_msg_processor".equals(paramString))
          {
            localObject = new UncommonMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("video_processor".equals(paramString))
          {
            localObject = new VideoMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("discuss_update_processor".equals(paramString))
          {
            localObject = new DiscMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("info_update_processor".equals(paramString))
          {
            localObject = new ProfileCardMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else if ("slave_master_processor".equals(paramString))
          {
            localObject = new FileSlaveMasterMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else
          {
            if (!"hctopic_processor".equals(paramString)) {
              break label469;
            }
            localObject = new HCTopicMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          if (localObject == null) {
            return null;
          }
          ((BaseMessageProcessor)localObject).a(this);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        }
      }
      return (BaseMessageProcessor)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      label469:
      Object localObject = null;
    }
  }
  
  public MessageObserver a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      if (!paramToServiceMsg.extraData.containsKey(SEQ_KEY)) {
        return null;
      }
      synchronized (this.uiObserverMap)
      {
        long l = paramToServiceMsg.extraData.getLong(SEQ_KEY);
        if (MessageObserver.class.isInstance((BusinessObserver)this.uiObserverMap.get(Long.valueOf(l))))
        {
          paramToServiceMsg = (MessageObserver)this.uiObserverMap.remove(Long.valueOf(l));
          return paramToServiceMsg;
        }
        return null;
      }
    }
    return null;
  }
  
  public AbsSubAccountMessageProcessor a()
  {
    return (AbsSubAccountMessageProcessor)a("sub_account_processor");
  }
  
  public OfflineFileMessageProcessor a()
  {
    return (OfflineFileMessageProcessor)a("offlinefile_processor");
  }
  
  public SystemMessageProcessor a()
  {
    return (SystemMessageProcessor)a("system_processor");
  }
  
  public UncommonMessageProcessor a()
  {
    return (UncommonMessageProcessor)a("uncommon_msg_processor");
  }
  
  public AppShareID a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
  }
  
  public OpenID a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
  }
  
  public EntityManager a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public IPasswdRedBagService a()
  {
    return (IPasswdRedBagService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
  }
  
  public MessageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  }
  
  public Object a(String arg1, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(???);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject1)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject1)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, new Object());
        }
      }
    }
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
  }
  
  public String a()
  {
    return ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a();
  }
  
  public void a(byte paramByte, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, int paramInt2, Object paramObject)
  {
    Object localObject = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).setLength(0);
      ((StringBuilder)localObject).append("<PbGetMsg><S>--->>getC2CMessage:cChannel:");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(",syncFlag:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",isPullRoamMsg:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",newMsgInSync:");
      ((StringBuilder)localObject).append(paramBoolean3);
      ((StringBuilder)localObject).append(",ssoTimeStamp:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",pullMsgType:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (((paramInt2 != 2) && (!b(paramBoolean3))) || ((paramInt2 == 2) && (!e())))
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      int j = paramBoolean1 ^ true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>getC2CMessage cChannel: ");
        localStringBuilder.append(paramByte);
        localStringBuilder.append("vCookies: ");
        localStringBuilder.append(paramArrayOfByte);
        localStringBuilder.append(",cSyncFlag:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",pullRoamMsg:");
        localStringBuilder.append(paramBoolean1);
        localStringBuilder.append(",onlineSyncFlag:");
        localStringBuilder.append(j);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      a(a(paramByte, paramArrayOfByte, paramInt1, paramBoolean1, paramBoolean2, paramString, paramInt2, paramObject, (byte[])localObject, j));
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString1.equals("")) {
        return;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      long l = System.currentTimeMillis() / 1000L;
      ArrayList localArrayList = new ArrayList();
      MessageRecord localMessageRecord = MessageRecordFactory.a(-2013);
      localMessageRecord.init(str, paramString2, str, paramString1, l, 0, paramInt, 0L);
      localMessageRecord.msgtype = -2013;
      localMessageRecord.isread = true;
      localArrayList.add(localMessageRecord);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localArrayList, String.valueOf(str), false);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 0L, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(paramInt, paramBoolean1, paramLong, paramBoolean2);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(null, paramInt, paramBoolean, paramObject, 0, false, false, null);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_0xbad.ReqBody localReqBody = new oidb_0xbad.ReqBody();
    localReqBody.bytes_openid.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqBody.uint64_appid.set(paramLong2);
    localReqBody.uint64_uin.set(paramLong1);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0xbad", 2989, 0);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(paramLong, paramBoolean1, paramBoolean2);
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong2));
    if (localObject1 != null)
    {
      localObject2 = ((Friends)localObject1).name;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).trim().length() != 0) {}
      }
      else
      {
        localObject1 = String.valueOf(paramLong2);
      }
    }
    else
    {
      localObject1 = String.valueOf(paramLong2);
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStauts();
    Object localObject2 = new Intent("tencent.video.q2v.RecvSharpVideoCall");
    ((Intent)localObject2).setClassName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
    ((Intent)localObject2).putExtra("uin", String.valueOf(paramLong1));
    ((Intent)localObject2).putExtra("fromUin", String.valueOf(paramLong2));
    ((Intent)localObject2).putExtra("buffer", paramArrayOfByte);
    ((Intent)localObject2).putExtra("time", paramInt);
    ((Intent)localObject2).putExtra("name", (String)localObject1);
    ((Intent)localObject2).putExtra("isPttRecordingOrPlaying", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPttRecordingOrPlaying());
    ((Intent)localObject2).putExtra("isRequest", paramBoolean);
    ((Intent)localObject2).putExtra("onLineStatus", l);
    ((Intent)localObject2).putExtra("msf_timestamp", System.currentTimeMillis());
    QLog.d("shanezhaiSHARP", 1, "avideo handleSharpVideoMessageResp sendBroadcast!!");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject2);
  }
  
  public void a(SvcReqMSFLoginNotify paramSvcReqMSFLoginNotify, byte paramByte, int paramInt)
  {
    if ((paramByte == 1) && (QFileAssistantUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, true);
      QFileAssistantUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).b(paramSvcReqMSFLoginNotify.vecInstanceList);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION".equals(paramContext)) || ("com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION".equals(paramContext)))
    {
      paramContext = QQNotificationManager.getInstance();
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 264);
      this.jdField_d_of_type_Boolean = false;
      paramIntent = this.jdField_a_of_type_JavaLangThread;
      if (paramIntent != null) {
        paramIntent.interrupt();
      }
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 263);
      this.jdField_e_of_type_Boolean = false;
      paramContext = this.jdField_b_of_type_JavaLangThread;
      if (paramContext != null) {
        paramContext.interrupt();
      }
      paramContext = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
        if (QLog.isDevelopLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("PConline BroadcastReceiver clicked ");
          paramIntent.append(paramContext.getClassName());
          QLog.d("Q.msg.MessageHandler", 4, paramIntent.toString());
        }
        if (!paramContext.getClassName().equals(LoginInfoActivity.class.getName()))
        {
          if (QLog.isDevelopLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("PConline BroadcastReceiver clicked startActivity");
            paramContext.append(LoginInfoActivity.class.getName());
            QLog.d("Q.msg.MessageHandler", 4, paramContext.toString());
          }
          paramContext = new Intent(BaseApplication.getContext(), LoginInfoActivity.class);
          paramContext.addFlags(268435456);
          BaseApplication.getContext().startActivity(paramContext);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_notice", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(android.os.Message paramMessage, boolean paramBoolean)
  {
    if (!a().a(paramMessage))
    {
      a().a(paramMessage);
      if (paramBoolean)
      {
        a().sendMessage(paramMessage);
      }
      else
      {
        a().b(paramMessage);
        if (!a().hasMessages(2)) {
          a().sendEmptyMessageDelayed(2, 5000L);
        }
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("sendWorkMessage doNow=");
        paramMessage.append(paramBoolean);
        QLog.d("Q.msg.MessageHandler", 2, paramMessage.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.MessageHandler", 2, "return! caused by hasSameUnreadWorker");
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing))) {
      MiniAppController.tryReportShare((MessageForStructing)paramMessageRecord);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendRevokeMsgReq, timeout: ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("revokeMsg", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "sendRevokeMsgReq error, isMsgRevoking: false");
      }
      return;
    }
    Object localObject = new ArrayList();
    if ((paramMessageRecord.isLongMsg()) && ((paramMessageRecord instanceof MessageForLongMsg))) {
      ((ArrayList)localObject).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
    } else {
      ((ArrayList)localObject).add(paramMessageRecord);
    }
    paramMessageRecord = a().a((List)localObject, 1);
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.setTimeout(paramLong);
    a(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->sendRichTextMessageWith_MR : msgseq=", Long.valueOf(paramMessageRecord.msgseq) });
    }
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    boolean bool2 = a(paramMessageRecord.msgseq, localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (localMessageForStructing.structingMsg != null)
      {
        bool1 = ShareStructLongMessageManager.b(localMessageForStructing.structingMsg);
        break label100;
      }
    }
    boolean bool1 = false;
    label100:
    if ((MessageForRichText.class.isInstance(paramMessageRecord)) && (!bool1)) {
      ((MessageForRichText)paramMessageRecord).richText = null;
    }
    if (localPbSendMsgReq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->sendRichTextMessageWith_MR : the richText is null!", paramMessageRecord.getBaseInfoString() });
      }
      return;
    }
    a(paramMessageRecord, localPbSendMsgReq, 480000L, 0, paramBusinessObserver, paramBoolean);
    localSendMessageHandler.postDelayed(new MessageHandler.4(this, paramMessageRecord), MessageCache.jdField_a_of_type_Int);
    int j;
    if (bool2)
    {
      j = 0;
      while (j < 8)
      {
        localSendMessageHandler.a(new MessageHandler.5(this, paramMessageRecord, localPbSendMsgReq, paramBusinessObserver, paramBoolean));
        j += 1;
      }
      j = 1;
      paramBusinessObserver = localSendMessageHandler;
      while (j < 3)
      {
        long l = (3 - j) * 480000 / 3 - j * 2000;
        paramBusinessObserver.a(480000 * j / 3, l, "period");
        j += 1;
      }
    }
    if (paramMessageRecord.istroop == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
      j = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.jdField_a_of_type_JavaUtilList.size();
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
      if (j > MessageCache.b) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.jdField_a_of_type_JavaUtilList.remove(0);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1 != null)
    {
      if (paramMessageRecord2 == null) {
        return;
      }
      paramMessageRecord2.extStr = paramMessageRecord1.extStr;
      paramMessageRecord2.mExJsonObject = paramMessageRecord1.mExJsonObject;
      paramMessageRecord2.extLong = paramMessageRecord1.extLong;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addMessageAndNotifyForQAV:");
      localStringBuilder.append(paramMessageRecord.toString());
      QLog.d("notification", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    new ArrayList().add(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -4008) && (paramMessageRecord.msgtype != -2016))
    {
      if ((paramMessageRecord.msgtype == -2009) && ((paramMessageRecord.istroop == 0) || (paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 10004) || (paramMessageRecord.istroop == 1004) || (paramMessageRecord.istroop == 1006) || (paramMessageRecord.istroop == 1021) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002))) {
        a("addMessageAndNotify", 1000, true, null, 1, a(paramBoolean ^ true), false, paramMessageRecord);
      }
    }
    else if ((paramMessageRecord.istroop == 3000) && (paramMessageRecord.msgtype == -4008))
    {
      a("addMessageAndNotify", 1000, true, null, 1, true, false, paramMessageRecord);
      return;
    }
    a("addMessageAndNotify", 1000, true, null, 1, a(paramBoolean ^ true), false, null);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleC2CMessagePush");
    }
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      f(true);
      a((byte)1, null, 0, false, false, false, (String)paramFromServiceMsg.getAttribute("sso_push_timestamp"), 0, paramObject);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.setNeedRemindSlowNetwork(true);
    sendPbReq(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramToServiceMsg, paramInt, paramBoolean, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      int j = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      StatictisInfo localStatictisInfo = new StatictisInfo();
      if (paramBoolean)
      {
        localStatictisInfo.b = paramFromServiceMsg.getResultCode();
        localStatictisInfo.c = (j + 1);
      }
      else
      {
        localStatictisInfo.b = 2900;
        localStatictisInfo.jdField_a_of_type_Long = paramInt;
        localStatictisInfo.c = (j + 1);
        localStatictisInfo.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      }
      localStatictisInfo.jdField_d_of_type_Int = 1;
      a(paramToServiceMsg, 5006, paramBoolean, new Object[] { Long.valueOf(paramLong), localStatictisInfo });
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq)
  {
    Object localObject = paramSvcResponsePullGroupMsgSeq;
    if (localObject == null)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int k = paramToServiceMsg.extraData.getInt("doSome", 0);
    boolean bool = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---handleGetPullTroopMsgNumResp msgStruct.cReplyCode: ");
      localStringBuilder.append(((SvcResponsePullGroupMsgSeq)localObject).cReplyCode);
      localStringBuilder.append(",isUsedRegisterProxy: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",doSome: ");
      localStringBuilder.append(k);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (((SvcResponsePullGroupMsgSeq)localObject).cReplyCode != 0)
    {
      j(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.g = 0;
    ArrayList localArrayList = new ArrayList();
    if (bool) {
      localObject = new HashMap(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a());
    } else {
      localObject = null;
    }
    IPasswdRedBagService localIPasswdRedBagService = a();
    HashMap localHashMap = new HashMap();
    int j = 0;
    while (j < paramSvcResponsePullGroupMsgSeq.vGroupInfo.size())
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramSvcResponsePullGroupMsgSeq, k, bool, localStringBuilder, localArrayList, (HashMap)localObject, localHashMap, j);
      j += 1;
    }
    localIPasswdRedBagService.saveGroupInfos(localHashMap);
    if (bool) {
      a(arrayOfString, (HashMap)localObject);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object arg3, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp = a((byte[])???);
    if (localPbGetGroupMsgResp == null) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
    }
    if ((localPbGetGroupMsgResp != null) && (??? != null))
    {
      int j = paramToServiceMsg.extraData.getInt("doSome", 0);
      boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      if (paramToServiceMsg.getUin() == null) {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      } else {
        paramFromServiceMsg = paramToServiceMsg.getUin();
      }
      String str = paramToServiceMsg.extraData.getString("groupuin");
      long l1;
      if (str != null) {
        l1 = Long.parseLong(str);
      } else {
        l1 = localPbGetGroupMsgResp.group_code.get();
      }
      boolean bool3 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
      a(???, paramBoolean, localPbGetGroupMsgResp, j, l1, bool3);
      synchronized (a(String.valueOf(l1), 1))
      {
        a(paramToServiceMsg, l2, localPbGetGroupMsgResp, j, bool1, bool2, paramFromServiceMsg, l1, bool3);
        return;
      }
    }
    b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    if ((paramPbSendMsgResp != null) && (paramPbSendMsgResp.errtype.has()))
    {
      if (paramPbSendMsgResp.errtype.get() != 72) {
        return;
      }
      if (paramPbSendMsgResp.trans_svr_info.has())
      {
        paramPbSendMsgResp = (msg_svc.TransSvrInfo)paramPbSendMsgResp.trans_svr_info.get();
        a(paramToServiceMsg, 8036, true, new Object[] { Integer.valueOf(paramPbSendMsgResp.int32_ret_code.get()), paramPbSendMsgResp.bytes_trans_info.get().toByteArray() });
      }
    }
  }
  
  public void a(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    b(localArrayList);
  }
  
  public void a(String paramString)
  {
    ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqDeleteBlackList");
    localToServiceMsg.extraData.putString("deleteUin", paramString);
    localToServiceMsg.extraData.putInt("fromType", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    a(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramInt, paramString, paramLong1))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramInt, paramString, paramLong1);
      paramString.shmsgseq = paramLong2;
      paramString.time = paramLong3;
      paramString.setExtraFlag(0);
      a().a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramInt, paramString1, paramLong1))
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramInt, paramString1, paramLong1);
      paramString1.time = paramLong2;
      paramString1.setExtraFlag(0);
      a().a(paramString1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e()) && (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, paramInt, paramLong)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("handleRevokingRichMsgCacheAndNotify, in revoking cache, isSuc:");
        paramString.append(paramBoolean);
        QLog.d("revokeMsg", 2, paramString.toString());
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt).b();
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (UinTypeUtil.a(paramInt) == 1032) {
      return;
    }
    if (UinTypeUtil.a(paramString, paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, paramBoolean);
      if (paramString != null)
      {
        if (paramString.toByteArray() == null) {
          return;
        }
        paramInt = MobileQQService.seq;
        MobileQQService.seq = paramInt + 1;
        long l1 = paramInt;
        long l2 = System.currentTimeMillis();
        SendMessageHandler localSendMessageHandler = new SendMessageHandler();
        a(l1, localSendMessageHandler);
        paramInt = 0;
        while (paramInt < 9)
        {
          localSendMessageHandler.a(new MessageHandler.17(this, paramString, l2, l1));
          paramInt += 1;
        }
        paramInt = 0;
        while (paramInt < 3)
        {
          if (paramInt == 0) {
            l1 = 480000L;
          } else {
            l1 = (3 - paramInt) * 480000 / 3 - paramInt * 2000;
          }
          localSendMessageHandler.a(480000 * paramInt / 3, l1, "period");
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, Object paramObject, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, MessageRecord paramMessageRecord)
  {
    b(paramString, paramInt1, paramBoolean1);
    a(paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3, paramMessageRecord);
    notifyUI(paramInt1, paramBoolean1, paramObject);
    if (a(paramInt1))
    {
      a(paramObject);
      return;
    }
    if (b(paramInt1))
    {
      a(paramInt1, paramObject);
      return;
    }
    if (c(paramInt1)) {
      b(paramObject);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    a(paramString, paramLong1, paramLong2, paramLong3, paramShort, paramLong4, paramInt1, paramArrayOfByte, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--->>getRoamMsgByTime friendUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" beginTime: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" endTime: ");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(" middleTime: ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" maxCnt: ");
      ((StringBuilder)localObject).append(paramShort);
      ((StringBuilder)localObject).append(" random: ");
      ((StringBuilder)localObject).append(paramLong4);
      ((StringBuilder)localObject).append(" subcmd：");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--->>getRoamMsgByTime req_type: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", ticket length: ");
      int j;
      if (paramArrayOfByte == null) {
        j = 0;
      } else {
        j = paramArrayOfByte.length;
      }
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", fetchMore: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", fetchNum: ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", isPreloadType: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", notify: ");
      ((StringBuilder)localObject).append(paramBoolean3);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      QLog.e("Q.msg.MessageHandler", 2, new Exception("getRoamMsgByTime"), new Object[0]);
    }
    if (paramLong4 == 0L)
    {
      localObject = this;
      if (((MessageHandler)localObject).jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        ((MessageHandler)localObject).jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
    }
    Object localObject = createToServiceMsg("MessageSvc.PbGetRoamMsg");
    ((ToServiceMsg)localObject).extraData.putLong("lBeginTime", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("lEndTime", paramLong3);
    ((ToServiceMsg)localObject).extraData.putBoolean("fetchMore", paramBoolean1);
    ((ToServiceMsg)localObject).extraData.putInt("fetchNum", paramInt3);
    ((ToServiceMsg)localObject).extraData.putString("peerUin", paramString);
    ((ToServiceMsg)localObject).extraData.putBoolean("preloadType", paramBoolean2);
    ((ToServiceMsg)localObject).extraData.putBoolean("notify", paramBoolean3);
    msg_svc.PbGetRoamMsgReq localPbGetRoamMsgReq = new msg_svc.PbGetRoamMsgReq();
    if ((paramLong4 == 0L) && (paramLong2 == 0L)) {
      localPbGetRoamMsgReq.last_msgtime.set(paramLong3);
    } else {
      localPbGetRoamMsgReq.last_msgtime.set(paramLong2);
    }
    localPbGetRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
    localPbGetRoamMsgReq.random.set(paramLong4);
    paramString = localPbGetRoamMsgReq.read_cnt;
    if (paramShort == 0) {
      paramShort = 1000;
    }
    paramString.set(paramShort);
    localPbGetRoamMsgReq.subcmd.set(paramInt1);
    localPbGetRoamMsgReq.begin_msgtime.set(paramLong1);
    localPbGetRoamMsgReq.check_pwd.set(1);
    localPbGetRoamMsgReq.req_type.set(paramInt2);
    if (paramArrayOfByte != null) {
      if (paramInt2 == 0) {
        localPbGetRoamMsgReq.pwd.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      } else {
        localPbGetRoamMsgReq.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
    }
    ((ToServiceMsg)localObject).putWupBuffer(localPbGetRoamMsgReq.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, long paramLong1, short paramShort, Bundle paramBundle, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--->>getRoamMsgInOneDay friendUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" reqLastMsgTime: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" readCnt: ");
      ((StringBuilder)localObject).append(paramShort);
      ((StringBuilder)localObject).append(" random: ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l = paramLong2;
    if (paramLong2 == 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString);
      if (localObject == null)
      {
        l = 0L;
      }
      else
      {
        paramLong2 = ((Long)((Pair)localObject).second).longValue();
        l = paramLong2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getRoamMsgInOneDay rand=");
          ((StringBuilder)localObject).append(paramLong2);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
          l = paramLong2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRoamMsgInOneDay:");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramLong2 = paramLong1;
    if (paramLong1 == 0L) {
      paramLong2 = MessageCache.a();
    }
    Object localObject = createToServiceMsg("MessageSvc.PbGetOneDayRoamMsg");
    msg_svc.PbGetOneDayRoamMsgReq localPbGetOneDayRoamMsgReq = new msg_svc.PbGetOneDayRoamMsgReq();
    localPbGetOneDayRoamMsgReq.last_msgtime.set(paramLong2);
    localPbGetOneDayRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
    localPbGetOneDayRoamMsgReq.random.set(l);
    localPbGetOneDayRoamMsgReq.read_cnt.set(paramShort);
    ((ToServiceMsg)localObject).putWupBuffer(localPbGetOneDayRoamMsgReq.toByteArray());
    if (paramBundle != null) {
      ((ToServiceMsg)localObject).extraData.putBundle("context", paramBundle);
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localFriendsManager.a(localFriendsManager.a(paramString1, paramString2));
    }
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong1, long paramLong2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    for (long l = 0L; l < 3L; l += 1L) {
      localSendMessageHandler.postDelayed(new MessageHandler.12(this, l, paramString1, paramString2, paramByte, paramString3, paramLong1, paramLong2), 30000L * l);
    }
    a(paramLong1, localSendMessageHandler);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, short paramShort, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString1, "StreamSvr.UploadStreamMsg");
      localToServiceMsg.extraData.putString("selfuin", paramString1);
      localToServiceMsg.extraData.putString("uin", paramString2);
      localToServiceMsg.extraData.putString("filepath", paramString3);
      localToServiceMsg.extraData.putShort("PackSeq", paramShort);
      localToServiceMsg.extraData.putShort("flowLayer", StreamDataManager.a(paramString3));
      localToServiceMsg.extraData.putInt("msgseq", paramInt);
      localToServiceMsg.extraData.putLong("random", paramLong1);
      localToServiceMsg.extraData.putLong("VoiceType", paramLong2);
      localToServiceMsg.extraData.putLong("VoiceLength", paramLong3);
      localToServiceMsg.extraData.putLong("SubBubbleId", paramLong4);
      localToServiceMsg.extraData.putInt("DiyTextId", paramBundle.getInt("DiyTextId", 0));
      localToServiceMsg.setTimeout(60000L);
      localToServiceMsg.setNeedRemindSlowNetwork(true);
      send(localToServiceMsg);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, short paramShort, long paramLong)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null))
    {
      if (paramString2.length() <= 0) {
        return;
      }
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString1, "StreamSvr.RespPushStreamMsg");
      localToServiceMsg.extraData.putString("selfuin", paramString1);
      localToServiceMsg.extraData.putString("uin", paramString2);
      localToServiceMsg.extraData.putString("filepath", paramString3);
      localToServiceMsg.extraData.putShort("PackSeq", paramShort);
      localToServiceMsg.extraData.putLong("lkey", paramLong);
      send(localToServiceMsg);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    a(localStringBuilder.toString(), 1000, paramBoolean1, null, paramInt, paramBoolean2, paramBoolean3, null);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Request list add appid = ");
            ((StringBuilder)localObject).append(str);
            QLog.d("share_appid", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if (localArrayList.size() > 0)
      {
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ConfigUtil.a(paramArrayList, paramArrayList.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (paramList != null)
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      int j = 0;
      while (j < paramList.size())
      {
        String str = String.valueOf(paramList.get(j));
        if (!TextUtils.isEmpty(str))
        {
          boolean bool = localFriendsManager.a(str);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeFriendFromBlackList:");
            localStringBuilder.append(str);
            localStringBuilder.append(" isBlack:");
            localStringBuilder.append(bool);
            QLog.i("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          }
          if (bool) {
            b(str);
          }
        }
        j += 1;
      }
    }
  }
  
  public void a(short paramShort, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.SetRoamMsgAllUser");
    localToServiceMsg.extraData.putShort("shType", paramShort);
    localToServiceMsg.extraData.putByte("cValue", paramByte);
    send(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getC2CMessage:isPullRoamMsg:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ,pullMsgType:");
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    a((byte)3, null, 0, paramBoolean, true, false, null, paramInt, null);
  }
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean3, long paramLong3, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(true);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int j = 0;
      while ((j < localList.size()) && (j < 40))
      {
        RecentUser localRecentUser = (RecentUser)localList.get(j);
        int k;
        Pair localPair;
        StringBuilder localStringBuilder;
        if (localRecentUser.getType() == 1)
        {
          k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(localRecentUser.uin);
          if (((k != 1) && (k != 4)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localRecentUser.uin, 1))) {
            break label456;
          }
          localPair = a(localRecentUser.uin, 1);
          k = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkBreakPoint troopUin: ");
            localStringBuilder.append(localRecentUser.uin);
            localStringBuilder.append(" msg count: ");
            localStringBuilder.append(k);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          }
          if (k <= 0) {
            break label456;
          }
        }
        try
        {
          a(localRecentUser.uin, 1L + ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue(), false, null, 0);
        }
        catch (Exception localException)
        {
          label456:
          break label456;
        }
        if ((localRecentUser.getType() == 3000) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localRecentUser.uin, 3000)))
        {
          localPair = a(localRecentUser.uin, 3000);
          k = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkBreakPoint discUin: ");
            localStringBuilder.append(localRecentUser.uin);
            localStringBuilder.append(" msg count: ");
            localStringBuilder.append(k);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          }
          if (k > 0) {
            a(Long.valueOf(localRecentUser.uin).longValue(), ((Long)localPair.first).longValue() + 1L, ((Long)localPair.second).longValue(), false, null);
          }
        }
        j += 1;
      }
    }
    else
    {
      a(false);
      b(false);
      if (a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint getNewPushMsg");
        }
        a(false, 0);
        return;
      }
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint syncC2CMsg");
        }
        a(true, 1);
      }
      if (paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint syncPAMsg");
        }
        a(true, 2);
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 21) {
        return;
      }
      if (paramArrayOfByte[0] != 3) {
        return;
      }
      long l1 = PkgTools.getLongData(paramArrayOfByte, 1);
      long l2 = PkgTools.getLongData(paramArrayOfByte, 5);
      long l3 = PkgTools.getLongData(paramArrayOfByte, 9);
      long l4 = PkgTools.getLongData(paramArrayOfByte, 13);
      long l5 = PkgTools.getLongData(paramArrayOfByte, 17);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("uin:");
        paramArrayOfByte.append(l1);
        paramArrayOfByte.append(" epId=");
        paramArrayOfByte.append(l2);
        paramArrayOfByte.append(" expireTime=");
        paramArrayOfByte.append(l3);
        paramArrayOfByte.append(" flag=");
        paramArrayOfByte.append(l4);
        QLog.d("Emoticon", 2, paramArrayOfByte.toString());
      }
      Object localObject = (IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
      if (((IEmoticonManagerService)localObject).syncFindTabEmoticonPackageById(Long.toString(l2), 0) == null)
      {
        paramArrayOfByte = new EmoticonPackage();
        paramArrayOfByte.epId = Long.toString(l2);
        paramArrayOfByte.wordingId = l5;
        boolean bool;
        if (l4 == 1L) {
          bool = true;
        } else {
          bool = false;
        }
        paramArrayOfByte.valid = bool;
        paramArrayOfByte.expiretime = l3;
        paramArrayOfByte.aio = true;
        ((IEmoticonManagerService)localObject).saveEmoticonPackage(paramArrayOfByte);
        ((IEmoticonManagerService)localObject).syncPcTabEmoticonPackage(paramArrayOfByte.epId, 0);
        localObject = (IEmojiManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmojiManagerService.class);
        ((IEmojiManagerService)localObject).startDownloadEmosmJson(paramArrayOfByte.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
        ((IEmojiManagerService)localObject).startCoverDownload(paramArrayOfByte);
      }
    }
  }
  
  public void a(Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    paramString = (String)paramArrayOfObject[0];
    int j = ((Integer)paramArrayOfObject[1]).intValue();
    long l = ((Long)paramArrayOfObject[5]).longValue();
    paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramString, j);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString, j, l);
    if ((paramArrayOfObject != null) && (paramArrayOfObject.uniseq == l)) {
      paramArrayOfObject.setExtraFlag(32768);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, j, l, 32768, paramInt);
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("----------handleMsgNew: ");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      return this.jdField_b_of_type_Boolean;
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 3001;
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Bundle paramBundle)
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(paramLong1), 3000);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--->>getPullDiscussionMsg uin: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" beginSeq: ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" endSeq: ");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(" delSeq: ");
      ((StringBuilder)localObject).append(l);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong2 >= 0L)
    {
      if (paramLong3 < 0L) {
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(paramLong1));
      if (localObject == null) {
        return false;
      }
      ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbGetDiscussMsg");
      localToServiceMsg.extraData.putLong("lDisUin", paramLong1);
      localToServiceMsg.extraData.putLong("lBeginSeq", paramLong2);
      localToServiceMsg.extraData.putLong("lEndSeq", paramLong3);
      localToServiceMsg.extraData.putBoolean("isRefreshHead", paramBoolean);
      localToServiceMsg.extraData.putBundle("context", paramBundle);
      localToServiceMsg.extraData.putLong("dwLastInfoSeq", ((Long)((Pair)localObject).first).longValue());
      localToServiceMsg.extraData.putLong("dwLastGetTime", ((Long)((Pair)localObject).second).longValue());
      paramBundle = new msg_svc.PbGetDiscussMsgReq();
      paramBundle.begin_seq.set(paramLong2);
      paramBundle.end_seq.set(paramLong3);
      paramBundle.discuss_uin.set(paramLong1);
      paramBundle.discuss_info_seq.set(((Long)((Pair)localObject).first).longValue());
      paramBundle.last_get_time.set(((Long)((Pair)localObject).second).longValue());
      localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
      a(localToServiceMsg);
      return true;
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("the values of disable big data channel is");
      ((StringBuilder)localObject).append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDisableBigDataChannel());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDisableBigDataChannel();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((localObject != null) && (ShareStructLongMessageManager.a((AbsStructMsg)localObject)))
      {
        String str1 = paramMessageRecord.getExtInfoFromExtStr("send_by_struct_long_message");
        String str2 = ShareStructLongMessageManager.a((AbsStructMsg)localObject);
        String str3 = ShareStructLongMessageManager.a(str2);
        if (!"1".equals(str1))
        {
          paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "1");
          a(paramMessageRecord, paramMessageObserver);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ((AbsStructMsg)localObject).source_puin, "0X8007A26", "0X8007A26", 0, 0, str3, str2, "", "", false);
          bool1 = true;
        }
        else
        {
          paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "0");
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ((AbsStructMsg)localObject).source_puin, "0X8007A27", "0X8007A27", 0, 0, str3, str2, "", "", false);
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "struct msg is null");
          bool1 = bool2;
        }
      }
      return bool1;
    }
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkApp)paramMessageRecord, false);
      return true;
    }
    if ((paramMessageRecord instanceof MessageForArkBabyqReply))
    {
      QLog.e("Q.msg.MessageHandler", 1, "MessageForArkBabyqReply no longer supported from 8.2.6");
      return true;
    }
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, true);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "it is not message for structing");
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, 1);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("--->>getPullTroopMsg troopUin2: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" beginSeq: ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" endSeq: ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" delSeq: ");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(" pull num : ");
      ((StringBuilder)localObject1).append(paramLong2 - paramLong1 + 1L);
      ((StringBuilder)localObject1).append(" doSome:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" ThreadId:");
      ((StringBuilder)localObject1).append(Thread.currentThread().getId());
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = false;
    if (paramLong1 >= 0L)
    {
      if (paramLong2 < 0L) {
        return false;
      }
      localObject1 = createToServiceMsg("MessageSvc.PbGetGroupMsg");
      ((ToServiceMsg)localObject1).extraData.putString("groupuin", paramString);
      ((ToServiceMsg)localObject1).extraData.putLong("lBeginSeq", paramLong1);
      ((ToServiceMsg)localObject1).extraData.putLong("lEndSeq", paramLong2);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isRefreshHead", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putBundle("context", paramBundle);
      ((ToServiceMsg)localObject1).extraData.putInt("doSome", paramInt);
      ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
      Object localObject2 = ((ToServiceMsg)localObject1).extraData;
      paramBoolean = bool;
      if (paramBundle != null)
      {
        paramBoolean = bool;
        if (paramBundle.getBoolean("key_from_parallel_pull", false)) {
          paramBoolean = true;
        }
      }
      ((Bundle)localObject2).putBoolean("key_from_parallel_pull", paramBoolean);
      paramBundle = new msg_svc.PbGetGroupMsgReq();
      paramBundle.group_code.set(Long.valueOf(paramString).longValue());
      paramBundle.begin_seq.set(paramLong1);
      paramBundle.end_seq.set(paramLong2);
      localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramBundle.public_group.set(((HotChatManager)localObject2).a(paramString));
      ((ToServiceMsg)localObject1).putWupBuffer(paramBundle.toByteArray());
      a((ToServiceMsg)localObject1);
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if ((!paramBoolean2) && (a(paramBoolean1))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean1)
    {
      paramBoolean2 = paramBoolean1;
      if (paramList != null)
      {
        paramBoolean2 = paramBoolean1;
        if (paramList.size() > 0) {
          if ((!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramList.get(0))) && (!TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramList.get(0))))
          {
            paramBoolean2 = paramBoolean1;
            if (!TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramList.get(0))) {}
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("OpenTroopDebug", 2, "opentroop and hotchattroop msg not notify.");
            }
            paramBoolean2 = false;
          }
        }
      }
    }
    return paramBoolean2;
  }
  
  public byte[] a()
  {
    Object localObject = new msg_svc.PbGetMsgReq();
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
    if (arrayOfByte != null) {
      ((msg_svc.PbGetMsgReq)localObject).sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    ((msg_svc.PbGetMsgReq)localObject).sync_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject).ramble_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject).context_flag.set(1);
    ((msg_svc.PbGetMsgReq)localObject).online_sync_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject).latest_ramble_number.set(20);
    ((msg_svc.PbGetMsgReq)localObject).other_ramble_number.set(3);
    localObject = ((msg_svc.PbGetMsgReq)localObject).toByteArray();
    arrayOfByte = new byte[localObject.length + 4];
    PkgTools.copyData(arrayOfByte, 4, (byte[])localObject, 0, localObject.length);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>createGetMsgReq");
    }
    return arrayOfByte;
  }
  
  public byte[] a(boolean paramBoolean)
  {
    Object localObject1 = new msg_svc.PbGetMsgReq();
    if (paramBoolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      if (localObject2 != null) {
        ((msg_svc.PbGetMsgReq)localObject1).pubaccount_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      ((msg_svc.PbGetMsgReq)localObject1).msg_req_type.set(2);
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      if (localObject2 != null) {
        ((msg_svc.PbGetMsgReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      ((msg_svc.PbGetMsgReq)localObject1).msg_req_type.set(1);
    }
    ((msg_svc.PbGetMsgReq)localObject1).sync_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject1).ramble_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject1).context_flag.set(1);
    ((msg_svc.PbGetMsgReq)localObject1).online_sync_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject1).latest_ramble_number.set(20);
    ((msg_svc.PbGetMsgReq)localObject1).other_ramble_number.set(3);
    Object localObject2 = ((msg_svc.PbGetMsgReq)localObject1).toByteArray();
    localObject1 = new byte[localObject2.length + 4];
    PkgTools.copyData((byte[])localObject1, 4, (byte[])localObject2, 0, localObject2.length);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("--->>createGetMsgReq ,isPubAccount:");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public int b(int paramInt)
  {
    return ((RoutingType)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().a().a(Integer.valueOf(paramInt))).b();
  }
  
  public int b(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int k = a(localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = a(2, paramLong1, paramLong2, paramInt1, paramInt2);
    int j = 0;
    paramInt1 = 0;
    for (;;)
    {
      paramInt2 = j;
      if (paramInt1 >= 3) {
        break;
      }
      localSendMessageHandler.a(new MessageHandler.3(this, localPbSendMsgReq, k, paramLong2));
      paramInt1 += 1;
    }
    while (paramInt2 <= 3)
    {
      localSendMessageHandler.a(paramInt2 * 30000L / 3L, 10000L, "period");
      paramInt2 += 1;
    }
    return k;
  }
  
  public void b()
  {
    if (a().hasMessages(2)) {
      a().removeMessages(2);
    }
    a().a();
  }
  
  public void b(int paramInt)
  {
    Object localObject = QQNotificationManager.getInstance();
    if (paramInt == 0)
    {
      ((QQNotificationManager)localObject).cancel("Q.msg.MessageHandler_OfflineNotifition", 264);
      this.jdField_d_of_type_Boolean = false;
      localObject = this.jdField_b_of_type_JavaLangRunnable;
      if (localObject != null)
      {
        ThreadManager.remove((Runnable)localObject);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
    }
    else if (paramInt == 1)
    {
      ((QQNotificationManager)localObject).cancel("Q.msg.MessageHandler_OfflineNotifition", 263);
      this.jdField_e_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_JavaLangRunnable;
      if (localObject != null)
      {
        ThreadManager.remove((Runnable)localObject);
        this.jdField_a_of_type_JavaLangRunnable = null;
      }
    }
  }
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void b(long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqGetBlackList");
    localToServiceMsg.extraData.putLong("lNextMid", paramLong);
    send(localToServiceMsg);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    new ArrayList().add(paramMessageRecord);
    a("addMessageAndNotify", 1000, true, null, 1, a(paramMessageRecord.isread ^ true), false, null);
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new msg_onlinepush.PbPushMsg();
    try
    {
      paramObject = (msg_onlinepush.PbPushMsg)((msg_onlinepush.PbPushMsg)localObject).mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: exception occurs while parsing the pb bytes.", paramObject);
      }
      paramObject = null;
    }
    if (paramObject == null) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
    }
    if ((paramObject != null) && (paramObject.msg.has()))
    {
      localObject = (msg_comm.Msg)paramObject.msg.get();
      int j = ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).msg_type.get();
      int k = paramObject.uint32_general_flag.get();
      boolean bool = false;
      if ((k & 0x20) == 32) {
        NoDisturbUtil.a(true);
      } else {
        NoDisturbUtil.a(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, new Object[] { "<---handleMessagePush_PB: msgType:", Integer.valueOf(j), " ,muteGeneralFlag:", Integer.valueOf(paramObject.uint32_general_flag.get()) });
      }
      if ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        a("c2c_processor").a(2003, new Object[] { localObject, paramFromServiceMsg, paramObject });
        return;
      }
      if ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        a().a(4004, new Object[] { localObject, paramFromServiceMsg, paramObject });
        return;
      }
      if (j != 42) {
        if ((j != 43) && (j != 82))
        {
          if (j != 83)
          {
            if (j != 141) {
              return;
            }
            a("c2c_processor").a(1001, new Object[] { localObject, paramFromServiceMsg, paramObject });
          }
        }
        else
        {
          BaseMessageProcessor localBaseMessageProcessor = a("troop_processor");
          if (paramObject.ping_flag.get() == 1) {
            bool = true;
          }
          localBaseMessageProcessor.a(1001, new Object[] { localObject, paramFromServiceMsg, paramObject, Boolean.valueOf(bool) });
          return;
        }
      }
      a("disc_processor").a(1001, new Object[] { localObject, paramFromServiceMsg, paramObject, Boolean.valueOf(true) });
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<---handleMessagePush_PB: pushMsg is null or doesn't has msg:");
      if (paramObject == null) {
        paramFromServiceMsg = " null ";
      } else {
        paramFromServiceMsg = "noMsg";
      }
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    i();
    if (this.jdField_d_of_type_Int < 6)
    {
      a(paramToServiceMsg.extraData.getBoolean("isPullRoamMsg"), paramToServiceMsg.extraData.getInt("pullMsgType"));
      this.jdField_d_of_type_Int += 1;
      return;
    }
    c(paramToServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Error.a(this, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyTroopMsgResp_PB return by null data");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
    }
    register_proxy.SvcResponsePbPullGroupMsgProxy localSvcResponsePbPullGroupMsgProxy;
    byte[] arrayOfByte;
    if ((paramObject instanceof register_proxy.SvcResponsePbPullGroupMsgProxy))
    {
      localSvcResponsePbPullGroupMsgProxy = (register_proxy.SvcResponsePbPullGroupMsgProxy)paramObject;
    }
    else
    {
      localSvcResponsePbPullGroupMsgProxy = new register_proxy.SvcResponsePbPullGroupMsgProxy();
      try
      {
        localSvcResponsePbPullGroupMsgProxy = (register_proxy.SvcResponsePbPullGroupMsgProxy)localSvcResponsePbPullGroupMsgProxy.mergeFrom((byte[])paramObject);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode SvcResponsePbPullGroupMsgProxy:", localException);
        }
        arrayOfByte = null;
      }
    }
    if (arrayOfByte != null) {
      try
      {
        Object localObject = arrayOfByte.msg_content.get().toByteArray();
        int j = localObject.length - 4;
        arrayOfByte = new byte[j];
        PkgTools.copyData(arrayOfByte, 0, (byte[])localObject, 4, j);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("registerproxy->handleMsgProxyTroopMsgResp_PB. dataHash=");
          ((StringBuilder)localObject).append(paramObject.hashCode());
          ((StringBuilder)localObject).append(", newDataHash=");
          ((StringBuilder)localObject).append(arrayOfByte.hashCode());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
        }
        a(paramToServiceMsg, paramFromServiceMsg, arrayOfByte, true);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode pb:", paramToServiceMsg);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject = new String[1];
    int j = 0;
    localObject[0] = paramString;
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.j(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getPullTroopMsgNumber_PB troopUinArray.length: ");
      paramString.append(localObject.length);
      paramString.append(" troopUinArray:");
      paramString.append(Arrays.toString((Object[])localObject));
      paramString.append(", lastSeqAry:");
      paramString.append(Arrays.toString(arrayOfLong));
      paramString.append(", doSome:");
      paramString.append(paramInt);
      QLog.d("Q.msg.MessageHandler", 2, paramString.toString());
    }
    paramString = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbPullGroupMsgSeqReq localPbPullGroupMsgSeqReq = new msg_svc.PbPullGroupMsgSeqReq();
    while (j < localObject.length)
    {
      msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq localGroupInfoReq = new msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq();
      try
      {
        long l = Long.parseLong(localObject[j]);
        localGroupInfoReq.group_code.set(l);
        localGroupInfoReq.last_seq.set(arrayOfLong[j]);
        localPbPullGroupMsgSeqReq.group_info_req.add(localGroupInfoReq);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
      j += 1;
    }
    paramString.group_unread_info.set(localPbPullGroupMsgSeqReq);
    localObject = createToServiceMsg("PbMessageSvc.PbUnReadMsgSeq");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("doSome", paramInt);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1, paramString2);
    }
  }
  
  public void b(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      msg_svc.PbUnReadMsgSeqReq localPbUnReadMsgSeqReq = new msg_svc.PbUnReadMsgSeqReq();
      msg_svc.PbPullGroupMsgSeqReq localPbPullGroupMsgSeqReq = new msg_svc.PbPullGroupMsgSeqReq();
      int k = paramList.size();
      int j = 0;
      while (j < k)
      {
        msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq localGroupInfoReq = new msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq();
        try
        {
          long l = Long.parseLong((String)paramList.get(j));
          localGroupInfoReq.group_code.set(l);
          localGroupInfoReq.last_seq.set(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.j((String)paramList.get(j)));
          localPbPullGroupMsgSeqReq.group_info_req.add(localGroupInfoReq);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
        j += 1;
      }
      localPbUnReadMsgSeqReq.group_unread_info.set(localPbPullGroupMsgSeqReq);
      paramList = createToServiceMsg("PbMessageSvc.PbUnReadMsgSeq");
      paramList.putWupBuffer(localPbUnReadMsgSeqReq.toByteArray());
      paramList.extraData.putBoolean("RequestFromPublicAccountChatPie", true);
      sendPbReq(paramList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_b_of_type_ArrayOfInt)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveTroopMsgFilter. troopSettingList size=");
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c == null) {
        j = 0;
      } else {
        j = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c.size();
      }
      localStringBuilder.append(j);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c != null)
    {
      ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettings(this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c = null;
      return true;
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt == 6000) || (paramInt == 8002) || (paramInt == 7000) || (paramInt == 8005) || (paramInt == 8006) || (paramInt == 6010) || (paramInt == 6012) || (paramInt == 6013) || (paramInt == 8008) || (paramInt == 8010) || (paramInt == 8012) || (paramInt == 8014) || (paramInt == 3022) || (paramInt == 8035) || (paramInt == 8028) || (paramInt == 8037) || (paramInt == 8032) || (paramInt == 8040) || (paramInt == 8041) || (paramInt == 8043) || (paramInt == 8044) || (paramInt == 8045);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg begin.");
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
    Enumeration localEnumeration;
    String str;
    boolean bool;
    if ((localObject3 != null) && (((ConcurrentHashMap)localObject3).size() > 0)) {
      try
      {
        Object localObject1 = new ArrayList();
        localEnumeration = ((ConcurrentHashMap)localObject3).keys();
        while (localEnumeration.hasMoreElements())
        {
          str = (String)localEnumeration.nextElement();
          if (((Integer)((ConcurrentHashMap)localObject3).get(str)).intValue() != 2) {
            break label388;
          }
          bool = true;
          if (!Boolean.valueOf(bool).booleanValue()) {
            ((ArrayList)localObject1).add(str);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("flushDiscussionAndTroopMsg, troopSize=");
          ((StringBuilder)localObject3).append(((ArrayList)localObject1).size());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject3).toString());
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          d((String)((Iterator)localObject1).next(), "flushDiscussionAndTroopMsg");
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    } else if ((localObject3 == null) || (((ConcurrentHashMap)localObject3).size() <= 0)) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new ArrayList();
        localEnumeration = ((ConcurrentHashMap)localObject3).keys();
        if (localEnumeration.hasMoreElements())
        {
          str = (String)localEnumeration.nextElement();
          if (((Integer)((ConcurrentHashMap)localObject3).get(str)).intValue() != 2) {
            break label393;
          }
          bool = true;
          if (Boolean.valueOf(bool).booleanValue()) {
            continue;
          }
          ((ArrayList)localObject2).add(str);
          continue;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("flushDiscussionAndTroopMsg, disSize=");
          ((StringBuilder)localObject3).append(((ArrayList)localObject2).size());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject3).toString());
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          e((String)((Iterator)localObject2).next(), "flushDiscussionAndTroopMsg");
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label380;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg end.");
      label380:
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      return;
      label388:
      bool = false;
      break;
      label393:
      bool = false;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(paramInt);
  }
  
  public void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
  
  public void c(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    if (this.jdField_b_of_type_Long < 0L) {
      this.jdField_b_of_type_Long = 0L;
    }
    if (this.jdField_b_of_type_Long > 300L) {
      this.jdField_b_of_type_Long = 300L;
    }
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x9db.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    ((cmd0x9db.ReqBody)localObject).rpt_uint64_id.set(localArrayList);
    ((cmd0x9db.ReqBody)localObject).uint32_sequence.set(paramInt1);
    localObject = makeOIDBPkg("OidbSvc.0x9db", 2523, 0, ((cmd0x9db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("insertTinnyid", paramLong);
    ((ToServiceMsg)localObject).extraData.putInt("fromType", paramInt2);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    i();
    this.jdField_d_of_type_Int = 0;
    a(false);
    int j = paramToServiceMsg.extraData.getInt("pullMsgType");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetBuddyMessageError ,pullMsgType:");
      paramToServiceMsg.append(j);
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
    }
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return;
        }
        notifyUI(4016, false, null);
        return;
      }
      notifyUI(4001, false, null);
      return;
    }
    notifyUI(4001, false, null);
    notifyUI(4016, false, null);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.jdField_e_of_type_Int < 2)
    {
      send(paramToServiceMsg);
      this.jdField_e_of_type_Int += 1;
      return;
    }
    a(5002, false, null);
    this.jdField_e_of_type_Int = 0;
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyDiscussMsgResp_PB return by null data");
      return;
    }
    register_proxy.SvcPbResponsePullDisMsgProxy localSvcPbResponsePullDisMsgProxy;
    byte[] arrayOfByte;
    if ((paramObject instanceof register_proxy.SvcPbResponsePullDisMsgProxy))
    {
      localSvcPbResponsePullDisMsgProxy = (register_proxy.SvcPbResponsePullDisMsgProxy)paramObject;
    }
    else
    {
      localSvcPbResponsePullDisMsgProxy = new register_proxy.SvcPbResponsePullDisMsgProxy();
      try
      {
        localSvcPbResponsePullDisMsgProxy = (register_proxy.SvcPbResponsePullDisMsgProxy)localSvcPbResponsePullDisMsgProxy.mergeFrom((byte[])paramObject);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode SvcPbResponsePullDisMsgProxy:", localException);
        }
        arrayOfByte = null;
      }
    }
    if (arrayOfByte != null) {
      try
      {
        Object localObject = arrayOfByte.msg_content.get().toByteArray();
        int j = localObject.length - 4;
        arrayOfByte = new byte[j];
        PkgTools.copyData(arrayOfByte, 0, (byte[])localObject, 4, j);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("registerproxy->handleMsgProxyDiscussMsgResp_PB. dataHash=");
          ((StringBuilder)localObject).append(paramObject.hashCode());
          ((StringBuilder)localObject).append(", newDataHash=");
          ((StringBuilder)localObject).append(arrayOfByte.hashCode());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
        }
        g(paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode pb:", paramToServiceMsg);
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqInsertBlackList");
    localToServiceMsg.extraData.putString("insertUin", paramString);
    send(localToServiceMsg);
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localTroopManager.a(localTroopManager.a(paramString1, paramString2));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "Msg Pull Finish picPreDownloadOn");
    }
    ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).switchOn();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().b();
    ((IScribbleDownloader)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IScribbleDownloader.class)).on();
    LoadingStateManager.a().a(3);
    notifyUI(6005, paramBoolean, null, true);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.d();
  }
  
  public boolean c(int paramInt)
  {
    return (paramInt == 3002) || (paramInt == 3013) || (paramInt == 3008);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.d();
  }
  
  public void d(long paramLong)
  {
    Object localObject = new oidb_0xb31.ReqBody();
    ((oidb_0xb31.ReqBody)localObject).uint64_to.set(paramLong);
    ((oidb_0xb31.ReqBody)localObject).uint64_from.set(0L);
    localObject = makeOIDBPkg("OidbSvc.0xb31", 2865, 0, ((oidb_0xb31.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("toUin", paramLong);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getCommonHobbyForAIOShow.");
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(paramToServiceMsg, 3012, false, null);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendTroopMessageRespPB enter");
    }
    String str = paramToServiceMsg.extraData.getString("groupuin");
    int m = paramToServiceMsg.extraData.getInt("msgtype");
    Object localObject = paramToServiceMsg.getServiceCmd();
    msg_svc.PbSendMsgResp localPbSendMsgResp = a(paramObject);
    int j;
    if ((localPbSendMsgResp != null) && (localPbSendMsgResp.result.has()))
    {
      if (localPbSendMsgResp.result.get() != 0) {
        j = localPbSendMsgResp.result.get();
      } else {
        j = 0;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB:server did not return a valid result code, use 4 instead.");
      }
      j = 4;
    }
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", j);
    a(paramToServiceMsg, paramFromServiceMsg);
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("<PbSendMsg><R><---handleSendTroopMessageRespPB: ---cmd:");
      paramObject.append((String)localObject);
      paramObject.append("----replyCode:");
      paramObject.append(j);
      paramObject.append(" ssoseq:");
      paramObject.append(paramFromServiceMsg.getRequestSsoSeq());
      paramObject.append(" appseq:");
      paramObject.append(paramFromServiceMsg.getAppSeq());
      paramObject.append(",SendTroopMessageResp : peerUin:");
      paramObject.append(str);
      paramObject.append(",uniseq:");
      paramObject.append(l1);
      paramObject.append(",msgSeq:");
      paramObject.append(l2);
      QLog.d("Q.msg.MessageHandler", 2, paramObject.toString());
    }
    paramObject = a(l2);
    if (paramObject == null)
    {
      ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1);
      return;
    }
    if (j == 255) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k != 0) && (a(paramObject, "server"))) {
      return;
    }
    localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    ((TroopManager)localObject).e(str);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(1);
    arrayOfObject[2] = Integer.valueOf(j);
    arrayOfObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    arrayOfObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    arrayOfObject[5] = Long.valueOf(l1);
    if (localPbSendMsgResp != null) {
      paramObject = localPbSendMsgResp.errmsg.get();
    } else {
      paramObject = "";
    }
    arrayOfObject[6] = paramObject;
    boolean bool2 = a(str, j, (TroopManager)localObject, arrayOfObject);
    int k = MessageProtoCodec.a(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1;
    if (bool2)
    {
      a(paramToServiceMsg, paramFromServiceMsg, str, localPbSendMsgResp, l1, k);
      bool1 = false;
    }
    else
    {
      paramObject = new MessageHandler.HandleSendTroopMessageRespPBFail(this, paramToServiceMsg, paramFromServiceMsg, str, localPbSendMsgResp, j, l2, l1, false, arrayOfObject, k).a();
      if (paramObject.a()) {
        return;
      }
      bool1 = paramObject.b();
    }
    paramObject = paramFromServiceMsg;
    a(paramToServiceMsg, paramFromServiceMsg, j, l1, bool2);
    Report.a(this, paramToServiceMsg, paramObject, true);
    a(l2);
    Report.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, paramObject);
    ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(paramToServiceMsg.extraData.getString("groupuin"), 1, l1, j, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
    ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportVideoStructMsgSendSuc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, str, 1, l1);
    if (!bool1) {
      ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1);
    }
  }
  
  public void d(String paramString)
  {
    a(paramString, 0);
  }
  
  public void d(boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new MessageHandler.15(this, paramBoolean), 10, null, false);
      return;
    }
    ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    e(paramBoolean);
  }
  
  public boolean d()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canRefreshMessage() elapsed=[");
      localStringBuilder.append((float)l * 1.0F / 1000.0F);
      localStringBuilder.append("]s,mIntervalForbidPulldown=[");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("]s");
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    return l >= this.jdField_b_of_type_Long * 1000L;
  }
  
  public void e()
  {
    super.e();
    RegisterProxy.jdField_a_of_type_Int |= 0x1;
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (MessageHandlerUtils.a(j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      q(paramToServiceMsg, paramFromServiceMsg);
    } else if (j == 9) {
      a().b(paramToServiceMsg, paramFromServiceMsg);
    } else if (j == 13) {
      a().c(paramToServiceMsg, paramFromServiceMsg);
    } else if (j == 4) {
      s(paramToServiceMsg, paramFromServiceMsg);
    } else if (j == 2) {
      r(paramToServiceMsg, paramFromServiceMsg);
    }
    Report.a(paramToServiceMsg, String.valueOf(paramFromServiceMsg.getResultCode()));
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendDiscussionMsgRespPB enter");
    }
    if (paramObject == null) {
      return;
    }
    Object localObject1 = b(paramObject);
    int k = a((msg_svc.PbSendMsgResp)localObject1);
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", k);
    a(paramToServiceMsg, paramFromServiceMsg);
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    int m = paramToServiceMsg.extraData.getInt("msgtype");
    paramObject = paramToServiceMsg.extraData.getString("uToUin");
    Object localObject2 = paramToServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbSendMsg><R><---handleSendDiscussionMsgRespPB: ---cmd:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("----replyCode:");
      localStringBuilder.append(k);
      localStringBuilder.append(" ssoseq:");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" appseq:");
      localStringBuilder.append(paramFromServiceMsg.getAppSeq());
      localStringBuilder.append("SendDiscussionMsgResp : peerUin:");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(",uniseq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(",msgSeq:");
      localStringBuilder.append(l2);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    localObject2 = a(l2);
    if (localObject2 == null)
    {
      ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1);
      return;
    }
    if (k == 255) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (a((SendMessageHandler)localObject2, "server"))) {
      return;
    }
    boolean bool2 = d(k);
    int j = MessageProtoCodec.a(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1;
    if (bool2)
    {
      a(paramToServiceMsg, paramFromServiceMsg, (msg_svc.PbSendMsgResp)localObject1, l1, paramObject, j);
      bool1 = false;
    }
    else
    {
      localObject1 = new MessageHandler.HandleSendDiscussionMsgRespPBNotSuccess(this, paramToServiceMsg, paramFromServiceMsg, (msg_svc.PbSendMsgResp)localObject1, k, false, l1, l2, paramObject, j).a();
      if (((MessageHandler.HandleSendDiscussionMsgRespPBNotSuccess)localObject1).a()) {
        return;
      }
      bool1 = ((MessageHandler.HandleSendDiscussionMsgRespPBNotSuccess)localObject1).b();
    }
    b(paramToServiceMsg, paramFromServiceMsg, k, l1, bool2);
    Report.d(this, paramToServiceMsg, paramFromServiceMsg, true);
    a(l2);
    Report.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, paramFromServiceMsg);
    ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(paramToServiceMsg.extraData.getString("uToUin"), 3000, l1, k, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
    ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportVideoStructMsgSendSuc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, paramObject, 3000, l1);
    if (!bool1) {
      ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1);
    }
  }
  
  public void e(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.DelRoamMsg");
    localToServiceMsg.extraData.putString("uin", paramString);
    send(localToServiceMsg);
  }
  
  public void e(boolean paramBoolean)
  {
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramBoolean);
    if (localPbMsgReadedReportReq != null)
    {
      if (localPbMsgReadedReportReq.toByteArray() == null) {
        return;
      }
      int j = MobileQQService.seq;
      MobileQQService.seq = j + 1;
      long l1 = j;
      long l2 = System.currentTimeMillis();
      SendMessageHandler localSendMessageHandler = new SendMessageHandler();
      a(l1, localSendMessageHandler);
      j = 0;
      while (j < 9)
      {
        localSendMessageHandler.a(new MessageHandler.16(this, localPbMsgReadedReportReq, l2, l1));
        j += 1;
      }
      j = 0;
      while (j < 3)
      {
        if (j == 0) {
          l1 = 480000L;
        } else {
          l1 = (3 - j) * 480000 / 3 - j * 2000;
        }
        localSendMessageHandler.a(480000 * j / 3, l1, "period");
        j += 1;
      }
    }
  }
  
  public void f()
  {
    super.f();
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    localObject = ((DiscussionManager)localObject).a();
    new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    int j = 1;
    while (((Iterator)localObject).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleNewRegisterProxyMsg--> should be deleted discussion");
        localStringBuilder.append(j);
        localStringBuilder.append(":");
        localStringBuilder.append(localDiscussionInfo.uin);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      localDiscussionHandler.a(localDiscussionInfo.uin);
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(localDiscussionInfo.uin) != null) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(localDiscussionInfo.uin);
      }
      j += 1;
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1005, false, null);
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData;
    int j = 0;
    if (!((Bundle)localObject).getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber ERROR isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramObject = (SvcResponsePullDisMsgSeq)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber is null");
      }
      t(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int k = paramObject.cReplyCode;
    localObject = paramObject.strResult;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<---handleGetDiscussionMsgNum resp.cReplyCode: ");
      ((StringBuilder)localObject).append(k);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (k != 0)
    {
      t(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = paramObject.vConfNumInfo;
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString = null;
    if (paramObject != null)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("<<---handleGetDiscussionMsgNum add cache ");
        paramFromServiceMsg.append(paramObject.size());
        QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramObject);
    }
    if ((paramToServiceMsg != null) && (paramObject != null))
    {
      paramFromServiceMsg = new HashSet();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        localObject = (stConfNumInfo)paramObject.next();
        if (localObject != null) {
          paramFromServiceMsg.add(String.valueOf(((stConfNumInfo)localObject).lConfUin));
        }
      }
      k = paramToServiceMsg.length;
      while (j < k)
      {
        paramObject = paramToServiceMsg[j];
        if (!paramFromServiceMsg.contains(paramObject))
        {
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject, 2);
          if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject) != null) {
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(paramObject);
          }
        }
        j += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramToServiceMsg);
    s();
  }
  
  public void g()
  {
    Object localObject1 = (MessageCache)a().getMsgCache();
    if (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache == null) {
      return;
    }
    long l = System.currentTimeMillis();
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if ((MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList != null) && (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject2 = new HashMap();
      localObject3 = MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (register_proxy.GroupList)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject5 = String.valueOf(((register_proxy.GroupList)localObject4).group_code.get());
          this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_JavaUtilHashMap.put(localObject5, Boolean.valueOf(((register_proxy.GroupList)localObject4).has_msg.get()));
          if (((register_proxy.GroupList)localObject4).redpack_time.get() > 0L) {
            ((HashMap)localObject2).put(localObject5, String.valueOf(((register_proxy.GroupList)localObject4).redpack_time.get()));
          }
        }
      }
      localIPasswdRedBagService.saveGroupInfos((HashMap)localObject2);
    }
    if ((MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b != null) && (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b.size() > 0))
    {
      localObject3 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
      localObject2 = new ArrayList();
      localObject3 = ((ArrayList)localObject3).iterator();
      int j = 1;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
        ((ArrayList)localObject2).add(((DiscussionInfo)localObject4).uin);
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("handleRegPrxyCache--> discussion");
          ((StringBuilder)localObject5).append(j);
          ((StringBuilder)localObject5).append(":");
          ((StringBuilder)localObject5).append(((DiscussionInfo)localObject4).uin);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject5).toString());
        }
        j += 1;
      }
      localObject3 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      localObject4 = new ArrayList();
      localObject5 = new ArrayList();
      HashMap localHashMap = new HashMap();
      Object localObject6 = MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        register_proxy.DiscussList localDiscussList = (register_proxy.DiscussList)((Iterator)localObject6).next();
        if (localDiscussList != null)
        {
          String str = String.valueOf(localDiscussList.discuss_code.get());
          this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(localDiscussList.has_msg.get()));
          if (localDiscussList.redpack_time.get() > 0L) {
            localHashMap.put(str, String.valueOf(localDiscussList.redpack_time.get()));
          }
          DiscussionInfo localDiscussionInfo = new DiscussionInfo();
          localDiscussionInfo.uin = String.valueOf(localDiscussList.discuss_code.get());
          localDiscussionInfo.infoSeq = localDiscussList.info_seq.get();
          ((ArrayList)localObject4).add(localDiscussionInfo);
          if (localDiscussList.bHotGroup.get()) {
            ((ArrayList)localObject5).add(localDiscussionInfo.uin);
          }
          ((ArrayList)localObject2).remove(str);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("REG_PROXY dis_cnt=");
        ((StringBuilder)localObject6).append(((ArrayList)localObject4).size());
        ((StringBuilder)localObject6).append(" fav_cnt=");
        ((StringBuilder)localObject6).append(((ArrayList)localObject5).size());
        QLog.d("DiscussionVerify", 2, ((StringBuilder)localObject6).toString());
      }
      if (((ArrayList)localObject4).size() >= 100)
      {
        ((DiscussionHandler)localObject3).f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        j = 0;
      }
      else
      {
        j = 1;
      }
      if ((!((ArrayList)localObject2).isEmpty()) && (j != 0))
      {
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("handleRegPrxyCache deleteDiscussList=");
          ((StringBuilder)localObject6).append(((ArrayList)localObject2).toArray());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject6).toString());
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject6 = (String)((Iterator)localObject2).next();
          ((DiscussionHandler)localObject3).a((String)localObject6);
          if (((MessageCache)localObject1).b((String)localObject6) != null) {
            ((MessageCache)localObject1).d((String)localObject6);
          }
        }
      }
      notifyUI(1000, ((DiscussionHandler)localObject3).a((ArrayList)localObject4, (ArrayList)localObject5), null);
      localIPasswdRedBagService.saveDisGroupInfos(localHashMap);
    }
    MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList = null;
    MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b = null;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleRegPrxyCache end! cost:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1005, false, null);
  }
  
  /* Error */
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 3902
    //   4: invokevirtual 1244	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 452	java/lang/String
    //   10: astore 10
    //   12: new 1498	msf/msgsvc/msg_svc$PbGetDiscussMsgResp
    //   15: dup
    //   16: invokespecial 3903	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:<init>	()V
    //   19: astore 9
    //   21: aload 9
    //   23: aload_3
    //   24: checkcast 690	[B
    //   27: checkcast 690	[B
    //   30: invokevirtual 3904	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: checkcast 1498	msf/msgsvc/msg_svc$PbGetDiscussMsgResp
    //   36: astore 9
    //   38: goto +21 -> 59
    //   41: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +12 -> 56
    //   47: ldc 198
    //   49: iconst_2
    //   50: ldc_w 3906
    //   53: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aconst_null
    //   57: astore 9
    //   59: aload 9
    //   61: ifnonnull +42 -> 103
    //   64: invokestatic 2497	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   67: invokestatic 2715	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   70: aload_0
    //   71: getfield 123	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   74: invokevirtual 1829	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   77: ldc_w 2717
    //   80: iconst_0
    //   81: lconst_0
    //   82: lconst_0
    //   83: new 1026	java/util/HashMap
    //   86: dup
    //   87: invokespecial 2699	java/util/HashMap:<init>	()V
    //   90: ldc_w 561
    //   93: invokevirtual 2721	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   96: aload_0
    //   97: aload_1
    //   98: aload_2
    //   99: invokevirtual 3909	com/tencent/mobileqq/app/MessageHandler:m	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   102: return
    //   103: aload_1
    //   104: getfield 384	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   107: ldc_w 1501
    //   110: iconst_0
    //   111: invokevirtual 1502	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   114: istore 4
    //   116: aload_1
    //   117: getfield 384	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   120: ldc_w 1504
    //   123: iconst_0
    //   124: invokevirtual 1502	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   127: istore 5
    //   129: new 79	java/util/ArrayList
    //   132: dup
    //   133: invokespecial 80	java/util/ArrayList:<init>	()V
    //   136: pop
    //   137: aload_1
    //   138: getfield 384	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   141: ldc_w 1537
    //   144: iconst_0
    //   145: invokevirtual 1502	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   148: istore 6
    //   150: aload_1
    //   151: getfield 384	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   154: ldc_w 1511
    //   157: aload 9
    //   159: getfield 1514	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:discuss_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   162: invokevirtual 1424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   165: invokevirtual 1236	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   168: lstore 7
    //   170: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +188 -> 361
    //   176: new 220	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   183: astore_2
    //   184: aload_2
    //   185: ldc_w 3911
    //   188: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_2
    //   193: aload 9
    //   195: getfield 1519	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   198: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   201: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc_w 3913
    //   209: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: lload 7
    //   216: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_2
    //   221: ldc_w 3915
    //   224: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_2
    //   229: iload 6
    //   231: invokevirtual 1408	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: ldc_w 1410
    //   239: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_2
    //   244: aload_3
    //   245: invokevirtual 1413	java/lang/Object:hashCode	()I
    //   248: invokestatic 1417	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   251: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_2
    //   256: ldc_w 1419
    //   259: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_2
    //   264: aload 9
    //   266: getfield 1509	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:return_begin_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   269: invokevirtual 1424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   272: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: ldc_w 1426
    //   280: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: aload 9
    //   287: getfield 1530	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:return_end_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   290: invokevirtual 1424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   293: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 9
    //   299: getfield 1499	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   302: invokevirtual 1444	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   305: ifnull +32 -> 337
    //   308: aload_2
    //   309: ldc_w 1446
    //   312: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_2
    //   317: aload 9
    //   319: getfield 1499	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   322: invokevirtual 1444	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   325: invokeinterface 298 1 0
    //   330: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: goto +11 -> 345
    //   337: aload_2
    //   338: ldc_w 1448
    //   341: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +13 -> 361
    //   351: ldc 198
    //   353: iconst_2
    //   354: aload_2
    //   355: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: lload 7
    //   364: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   367: sipush 3000
    //   370: invokevirtual 2726	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   373: astore_3
    //   374: aload_3
    //   375: monitorenter
    //   376: aload_0
    //   377: aload_1
    //   378: aload 9
    //   380: invokespecial 3917	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lmsf/msgsvc/msg_svc$PbGetDiscussMsgResp;)Z
    //   383: ifeq +6 -> 389
    //   386: aload_3
    //   387: monitorexit
    //   388: return
    //   389: aload_0
    //   390: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   393: aload 9
    //   395: getfield 1514	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:discuss_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   398: invokevirtual 1424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   401: invokevirtual 3919	com/tencent/mobileqq/service/message/MessageCache:a	(J)Ljava/util/ArrayList;
    //   404: astore_2
    //   405: aload_0
    //   406: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   409: lload 7
    //   411: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   414: aload 9
    //   416: getfield 3920	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:discuss_info_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   419: invokevirtual 1424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   422: aload 9
    //   424: getfield 3921	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:last_get_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   427: invokevirtual 1424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   430: invokevirtual 3922	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;JJ)V
    //   433: iload 6
    //   435: ifeq +61 -> 496
    //   438: aload_0
    //   439: ldc_w 1809
    //   442: invokevirtual 956	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;)Lcom/tencent/imcore/message/BaseMessageProcessor;
    //   445: sipush 1003
    //   448: iconst_4
    //   449: anewarray 51	java/lang/Object
    //   452: dup
    //   453: iconst_0
    //   454: aload_1
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: aload_2
    //   459: aastore
    //   460: dup
    //   461: iconst_2
    //   462: aload 9
    //   464: aastore
    //   465: dup
    //   466: iconst_3
    //   467: aload 10
    //   469: aastore
    //   470: invokevirtual 1324	com/tencent/imcore/message/BaseMessageProcessor:a	(I[Ljava/lang/Object;)V
    //   473: goto +333 -> 806
    //   476: astore_1
    //   477: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +326 -> 806
    //   483: ldc 198
    //   485: iconst_2
    //   486: ldc_w 3924
    //   489: aload_1
    //   490: invokestatic 739	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   493: goto +313 -> 806
    //   496: aload_0
    //   497: ldc_w 1809
    //   500: invokevirtual 956	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;)Lcom/tencent/imcore/message/BaseMessageProcessor;
    //   503: sipush 1002
    //   506: iconst_3
    //   507: anewarray 51	java/lang/Object
    //   510: dup
    //   511: iconst_0
    //   512: aload_1
    //   513: aastore
    //   514: dup
    //   515: iconst_1
    //   516: aload_2
    //   517: aastore
    //   518: dup
    //   519: iconst_2
    //   520: aload 9
    //   522: aastore
    //   523: invokevirtual 1324	com/tencent/imcore/message/BaseMessageProcessor:a	(I[Ljava/lang/Object;)V
    //   526: iload 5
    //   528: ifeq +38 -> 566
    //   531: aload_0
    //   532: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   535: astore_1
    //   536: aload_1
    //   537: aload_1
    //   538: getfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   541: iconst_1
    //   542: iadd
    //   543: putfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   546: aload_0
    //   547: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   550: astore_1
    //   551: lload 7
    //   553: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   556: astore_2
    //   557: aload_1
    //   558: aload_2
    //   559: iconst_2
    //   560: invokevirtual 1799	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;I)V
    //   563: goto +84 -> 647
    //   566: lload 7
    //   568: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   571: astore_1
    //   572: aload_0
    //   573: aload_1
    //   574: ldc_w 3927
    //   577: invokespecial 1825	com/tencent/mobileqq/app/MessageHandler:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: goto +67 -> 647
    //   583: astore_1
    //   584: goto +240 -> 824
    //   587: astore_1
    //   588: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +13 -> 604
    //   594: ldc 198
    //   596: iconst_2
    //   597: ldc_w 3929
    //   600: aload_1
    //   601: invokestatic 739	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   604: iload 5
    //   606: ifeq +32 -> 638
    //   609: aload_0
    //   610: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   613: astore_1
    //   614: aload_1
    //   615: aload_1
    //   616: getfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   619: iconst_1
    //   620: iadd
    //   621: putfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   624: aload_0
    //   625: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   628: astore_1
    //   629: lload 7
    //   631: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   634: astore_2
    //   635: goto -78 -> 557
    //   638: lload 7
    //   640: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   643: astore_1
    //   644: goto -72 -> 572
    //   647: iload 4
    //   649: ifeq +46 -> 695
    //   652: aload_0
    //   653: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   656: invokevirtual 1969	com/tencent/mobileqq/service/message/MessageCache:c	()Z
    //   659: ifeq +36 -> 695
    //   662: invokestatic 1344	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   665: invokevirtual 3932	com/tencent/util/MsgAutoMonitorUtil:markDisFinishTime	()V
    //   668: aload_0
    //   669: sipush 4002
    //   672: iconst_1
    //   673: aconst_null
    //   674: invokevirtual 992	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   677: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +126 -> 806
    //   683: ldc 198
    //   685: iconst_2
    //   686: ldc_w 3934
    //   689: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: goto +114 -> 806
    //   695: iload 5
    //   697: ifeq +109 -> 806
    //   700: aload_0
    //   701: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   704: getfield 3935	com/tencent/mobileqq/app/handler/RegisterProxyHandler:g	I
    //   707: ifeq +99 -> 806
    //   710: aload_0
    //   711: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   714: getfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   717: aload_0
    //   718: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   721: getfield 3935	com/tencent/mobileqq/app/handler/RegisterProxyHandler:g	I
    //   724: if_icmplt +82 -> 806
    //   727: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +61 -> 791
    //   733: new 220	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   740: astore_1
    //   741: aload_1
    //   742: ldc_w 3937
    //   745: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload_1
    //   750: aload_0
    //   751: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   754: getfield 3935	com/tencent/mobileqq/app/handler/RegisterProxyHandler:g	I
    //   757: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_1
    //   762: ldc_w 3939
    //   765: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload_1
    //   770: aload_0
    //   771: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   774: getfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   777: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: ldc 198
    //   783: iconst_2
    //   784: aload_1
    //   785: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: invokestatic 1344	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   794: invokevirtual 3932	com/tencent/util/MsgAutoMonitorUtil:markDisFinishTime	()V
    //   797: aload_0
    //   798: sipush 4002
    //   801: iconst_1
    //   802: aconst_null
    //   803: invokevirtual 992	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   806: aload_0
    //   807: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   810: aload 9
    //   812: getfield 1514	msf/msgsvc/msg_svc$PbGetDiscussMsgResp:discuss_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   815: invokevirtual 1424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   818: invokevirtual 3940	com/tencent/mobileqq/service/message/MessageCache:a	(J)V
    //   821: aload_3
    //   822: monitorexit
    //   823: return
    //   824: iload 5
    //   826: ifeq +34 -> 860
    //   829: aload_0
    //   830: getfield 126	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   833: astore_2
    //   834: aload_2
    //   835: aload_2
    //   836: getfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   839: iconst_1
    //   840: iadd
    //   841: putfield 3925	com/tencent/mobileqq/app/handler/RegisterProxyHandler:i	I
    //   844: aload_0
    //   845: getfield 143	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   848: lload 7
    //   850: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   853: iconst_2
    //   854: invokevirtual 1799	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;I)V
    //   857: goto +15 -> 872
    //   860: aload_0
    //   861: lload 7
    //   863: invokestatic 931	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   866: ldc_w 3927
    //   869: invokespecial 1825	com/tencent/mobileqq/app/MessageHandler:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   872: aload_1
    //   873: athrow
    //   874: astore_1
    //   875: aload_3
    //   876: monitorexit
    //   877: goto +5 -> 882
    //   880: aload_1
    //   881: athrow
    //   882: goto -2 -> 880
    //   885: astore 9
    //   887: goto -846 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	this	MessageHandler
    //   0	890	1	paramToServiceMsg	ToServiceMsg
    //   0	890	2	paramFromServiceMsg	FromServiceMsg
    //   0	890	3	paramObject	Object
    //   114	534	4	bool1	boolean
    //   127	698	5	bool2	boolean
    //   148	286	6	bool3	boolean
    //   168	694	7	l	long
    //   19	792	9	localPbGetDiscussMsgResp	msg_svc.PbGetDiscussMsgResp
    //   885	1	9	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   10	458	10	str	String
    // Exception table:
    //   from	to	target	type
    //   438	473	476	java/lang/Exception
    //   496	526	583	finally
    //   588	604	583	finally
    //   496	526	587	java/lang/Exception
    //   376	388	874	finally
    //   389	433	874	finally
    //   438	473	874	finally
    //   477	493	874	finally
    //   531	557	874	finally
    //   557	563	874	finally
    //   566	572	874	finally
    //   572	580	874	finally
    //   609	635	874	finally
    //   638	644	874	finally
    //   652	692	874	finally
    //   700	791	874	finally
    //   791	806	874	finally
    //   806	823	874	finally
    //   829	857	874	finally
    //   860	872	874	finally
    //   872	874	874	finally
    //   875	877	874	finally
    //   21	38	885	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MessageSvc.GetMsgV4");
      this.allowCmdSet.add("MessageSvc.PbGetMsg");
      this.allowCmdSet.add("MessageSvc.PbBindUinGetMsg");
      this.allowCmdSet.add("PbMessageSvc.PbBindUinMsgReadedConfirm");
      this.allowCmdSet.add("OidbSvc.0x5d0_1");
      this.allowCmdSet.add("MessageSvc.DelMsgV2");
      this.allowCmdSet.add("TransService.ReqOffFilePack");
      this.allowCmdSet.add("MessageSvc.PushNotify");
      this.allowCmdSet.add("MessageSvc.SetRoamMsgAllUser");
      this.allowCmdSet.add("MessageSvc.DelRoamMsg");
      this.allowCmdSet.add("PbMessageSvc.PbMsgReadedReport");
      this.allowCmdSet.add("ADMsgSvc.PushMsg");
      this.allowCmdSet.add("VideoCCSvc.Adaptation");
      this.allowCmdSet.add("SharpSvr.c2sack");
      this.allowCmdSet.add("SharpSvr.s2c");
      this.allowCmdSet.add("MultiVideo.c2sack");
      this.allowCmdSet.add("MultiVideo.s2c");
      this.allowCmdSet.add("OnlinePush.RespPush");
      this.allowCmdSet.add("OnlinePush.ReqPush");
      this.allowCmdSet.add("MessageSvc.PushReaded");
      this.allowCmdSet.add("TransService.ReqTmpChatPicDownload");
      this.allowCmdSet.add("TransService.ReqGetSign");
      this.allowCmdSet.add("OnlinePush.PbPushTransMsg");
      this.allowCmdSet.add("MessageSvc.PbSendMsg");
      this.allowCmdSet.add("OidbSvc.0xa89");
      this.allowCmdSet.add("MessageSvc.PbMultiMsgSend");
      this.allowCmdSet.add("SecSvcBlessingHelper.blessing_helper");
      this.allowCmdSet.add("StreamSvr.RespUploadStreamMsg");
      this.allowCmdSet.add("StreamSvr.PushStreamMsg");
      this.allowCmdSet.add("AccostSvc.ClientMsg");
      this.allowCmdSet.add("AccostSvc.SvrMsg");
      this.allowCmdSet.add("AccostSvc.ReqInsertBlackList");
      this.allowCmdSet.add("OidbSvc.0x9db");
      this.allowCmdSet.add("AccostSvc.ReqGetBlackList");
      this.allowCmdSet.add("OidbSvc.0x4ff_42024");
      this.allowCmdSet.add("AccostSvc.ReqDeleteBlackList");
      this.allowCmdSet.add("MessageSvc.PbGetDiscussMsg");
      this.allowCmdSet.add("MessageSvc.PbGetGroupMsg");
      this.allowCmdSet.add("MessageSvc.PullGroupMsgSeq");
      this.allowCmdSet.add("PbMessageSvc.PbUnReadMsgSeq");
      this.allowCmdSet.add("MessageSvc.RequestPushStatus");
      this.allowCmdSet.add("OnlinePush.PbPushGroupMsg");
      this.allowCmdSet.add("OnlinePush.PbPushBindUinGroupMsg");
      this.allowCmdSet.add("OnlinePush.PbPushDisMsg");
      this.allowCmdSet.add("OnlinePush.PbPushC2CMsg");
      this.allowCmdSet.add("OnlinePush.PbC2CMsgSync");
      this.allowCmdSet.add("RegPrxySvc.PbGetMsg");
      this.allowCmdSet.add("RegPrxySvc.GetMsgV2");
      this.allowCmdSet.add("RegPrxySvc.PullGroupMsgSeq");
      this.allowCmdSet.add("RegPrxySvc.PullDisMsgSeq");
      this.allowCmdSet.add("RegPrxySvc.PullDisGroupSeq");
      this.allowCmdSet.add("RegPrxySvc.NoticeEnd");
      this.allowCmdSet.add("RegPrxySvc.PbGetGroupMsg");
      this.allowCmdSet.add("RegPrxySvc.PbGetDiscussMsg");
      this.allowCmdSet.add("RegPrxySvc.getOffMsg");
      this.allowCmdSet.add("RegPrxySvc.infoLogin");
      this.allowCmdSet.add("RegPrxySvc.infoSync");
      this.allowCmdSet.add("RegPrxySvc.PbSyncMsg");
      this.allowCmdSet.add("RegPrxySvc.GetBoxFilter");
      this.allowCmdSet.add("StatSvc.SvcReqMSFLoginNotify");
      this.allowCmdSet.add("MessageSvc.PbGetRoamMsg");
      this.allowCmdSet.add("MessageSvc.PbGetOneDayRoamMsg");
      this.allowCmdSet.add("PbMessageSvc.PbSearchRoamMsgInCloud");
      this.allowCmdSet.add("PbMessageSvc.PbDelOneRoamMsg");
      this.allowCmdSet.add("PbMessageSvc.PbMsgWithDraw");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgRead");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgAction");
      this.allowCmdSet.add("NearFieldTranFileSvr.NotifyList");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew.Friend");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew.Group");
      this.allowCmdSet.add("OidbSvc.0x5cf_0");
      this.allowCmdSet.add("OidbSvc.0x5cf_1");
      this.allowCmdSet.add("MessageSvc.PbReceiptRead");
      this.allowCmdSet.add("OidbSvc.0xb31");
    }
    return this.allowCmdSet;
  }
  
  public Set<String> getPushPBCommandList()
  {
    return new MessageHandler.18(this);
  }
  
  public void h()
  {
    notifyUI(6006, true, null, true);
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1003, false, null);
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyC2CMsgResp.");
    }
    if (RegisterProxyHandler.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a(1, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------resetGetMsgFlag ");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1003, false, null);
  }
  
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    Object localObject1 = new msg_svc.PbUnReadMsgSeqResp();
    try
    {
      paramObject = (msg_svc.PbUnReadMsgSeqResp)((msg_svc.PbUnReadMsgSeqResp)localObject1).mergeFrom((byte[])paramObject);
      if ((paramObject.group_unread_info.has()) && (paramObject.group_unread_info.get() != null))
      {
        paramObject = (msg_svc.PbPullGroupMsgSeqResp)paramObject.group_unread_info.get();
        if (paramObject.result.get() != 0)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: ");
            ((StringBuilder)localObject1).append(paramObject.result.get());
            ((StringBuilder)localObject1).append(" ,groupMsgSeqResp.errmsg: ");
            ((StringBuilder)localObject1).append(paramObject.errmsg.get());
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
          }
          j(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        int j = paramToServiceMsg.extraData.getInt("doSome", 0);
        paramFromServiceMsg = new StringBuilder();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg.append("<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: ");
          paramFromServiceMsg.append(paramObject.result.get());
          paramFromServiceMsg.append(" ,doSome: ");
          paramFromServiceMsg.append(j);
          QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
        }
        this.g = 0;
        int k = 0;
        paramToServiceMsg = paramObject;
        while (k < paramToServiceMsg.group_info_resp.get().size())
        {
          localObject1 = (msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)paramToServiceMsg.group_info_resp.get().get(k);
          paramObject = String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get());
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject);
          long l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.j(paramObject);
          long l1;
          if ((localObject2 != null) && (localObject2.length > 0)) {
            l1 = ((Long)localObject2[0]).longValue();
          } else {
            l1 = 0L;
          }
          localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
          boolean bool;
          if ((localObject2 != null) && (((HotChatManager)localObject2).b(paramObject))) {
            bool = true;
          } else {
            bool = false;
          }
          if (!bool)
          {
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramObject, new Object[] { Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()), Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get()) });
            FightMsgReporter.a(paramObject, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get(), ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get());
            if (l1 < ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get()), 1, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get());
            }
          }
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg.setLength(0);
            paramFromServiceMsg.append("handleGetPullTroopMsgNumResp_PB getGroupMsgMemberSeq groupUin=");
            paramFromServiceMsg.append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get());
            paramFromServiceMsg.append(" ,memberseq=");
            paramFromServiceMsg.append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get());
            paramFromServiceMsg.append(" ,groupSeq=");
            paramFromServiceMsg.append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get());
            paramFromServiceMsg.append(" ,localMemberMsgSeq=");
            paramFromServiceMsg.append(l1);
            paramFromServiceMsg.append(" ,localLastSeq=");
            paramFromServiceMsg.append(l2);
            paramFromServiceMsg.append(", isHotChat=");
            paramFromServiceMsg.append(bool);
            QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
          }
          l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramObject, 1);
          localObject1 = a(paramObject, 1, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject), this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramObject), l2, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get());
          int m = (int)(((Long)((Pair)localObject1).second).longValue() - ((Long)((Pair)localObject1).first).longValue());
          l2 = ((Long)((Pair)localObject1).first).longValue();
          long l4 = ((Long)((Pair)localObject1).second).longValue();
          l2 = l4 - (l2 + 1L);
          long l3 = 10;
          if (l2 > l3) {
            l2 = l4 - l3 + 1L;
          } else {
            l2 = l4 - l2;
          }
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg.setLength(0);
            paramFromServiceMsg.append("---------handleGetPullTroopMsgNumResp_PB troopUin: ");
            paramFromServiceMsg.append(paramObject);
            paramFromServiceMsg.append(" ,msg count: ");
            paramFromServiceMsg.append(m);
            QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
          }
          if ((m <= 0) && (j == 8))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("handleGetPullTroopMsgNumResp_PB doSome=");
              ((StringBuilder)localObject1).append(j);
              ((StringBuilder)localObject1).append("  beginSeq:");
              l3 = l1;
              ((StringBuilder)localObject1).append(l3 - 10L);
              ((StringBuilder)localObject1).append(" endSeq:");
              ((StringBuilder)localObject1).append(l3);
              QLog.d(".troop.joinSplitMsg", 2, ((StringBuilder)localObject1).toString());
            }
            a(paramObject, l1 - 10L, l1, false, null, j);
          }
          if (m <= 0) {
            ((TroopMessageProcessor)a("troop_processor")).a(paramObject, null, j);
          } else {
            a(paramObject, l2, l4, false, null, j);
          }
          k += 1;
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return group_unread_info");
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      label993:
      break label993;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return a valid response");
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.jdField_d_of_type_Boolean = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject3 = ((Context)localObject1).getString(2131694534);
    String str = ((Context)localObject1).getString(2131694534);
    Object localObject2 = BitmapManager.a(((Context)localObject1).getResources(), 2130844281);
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    localObject3 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject3).setWhen(System.currentTimeMillis());
    if (localObject2 != null) {
      ((NotificationCompat.Builder)localObject3).setLargeIcon((Bitmap)localObject2);
    } else {
      ((NotificationCompat.Builder)localObject3).setLargeIcon(BitmapManager.a(((Context)localObject1).getResources(), 2130844281));
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((NotificationCompat.Builder)localObject3).setSmallIcon(2130844282);
    }
    localObject2 = new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION");
    ((Intent)localObject2).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject2).putExtra("param_notifyid", 264);
    ((NotificationCompat.Builder)localObject3).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0));
    localObject1 = ((NotificationCompat.Builder)localObject3).build();
    if (localQQNotificationManager != null)
    {
      localQQNotificationManager.cancel("Q.msg.MessageHandler_PcOnlineNotifition", 264);
      BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, (Notification)localObject1);
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_OTHER");
      localQQNotificationManager.notify("Q.msg.MessageHandler_PcOnlineNotifition", 264, (Notification)localObject1);
      this.jdField_b_of_type_JavaLangRunnable = new MessageHandler.9(this, localQQNotificationManager);
      ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
    }
  }
  
  public void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData;
    int j = 0;
    if (paramFromServiceMsg.getBoolean("used_register_proxy", false))
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_ArrayOfJavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
    else
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("array_groupuin");
    }
    this.g = 0;
    notifyUI(4003, false, paramToServiceMsg);
    if (paramToServiceMsg != null) {
      while (j < paramToServiceMsg.length)
      {
        try
        {
          d(paramToServiceMsg[j], "handleGetPullTroopMsgNumError");
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumError exception ! ", paramFromServiceMsg);
          }
        }
        j += 1;
      }
    }
  }
  
  public void k()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.jdField_e_of_type_Boolean = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject3 = ((Context)localObject1).getString(2131694530);
    String str = ((Context)localObject1).getString(2131694530);
    Object localObject2 = BitmapManager.a(((Context)localObject1).getResources(), 2130844276);
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    localObject3 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject3).setWhen(System.currentTimeMillis());
    if (localObject2 != null) {
      ((NotificationCompat.Builder)localObject3).setLargeIcon((Bitmap)localObject2);
    } else {
      ((NotificationCompat.Builder)localObject3).setLargeIcon(BitmapManager.a(((Context)localObject1).getResources(), 2130844276));
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((NotificationCompat.Builder)localObject3).setSmallIcon(2130844277);
    }
    localObject2 = new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION");
    ((Intent)localObject2).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject2).putExtra("param_notifyid", 263);
    ((NotificationCompat.Builder)localObject3).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0));
    localObject1 = ((NotificationCompat.Builder)localObject3).build();
    if (localQQNotificationManager != null)
    {
      localQQNotificationManager.cancel("Q.msg.MessageHandler_IpadOnlineNotifition", 263);
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_OTHER");
      localQQNotificationManager.notify("Q.msg.MessageHandler_IpadOnlineNotifition", 263, (Notification)localObject1);
      this.jdField_a_of_type_JavaLangRunnable = new MessageHandler.10(this, localQQNotificationManager);
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
    }
  }
  
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.g < 3)
    {
      msg_svc.PbUnReadMsgSeqReq localPbUnReadMsgSeqReq = new msg_svc.PbUnReadMsgSeqReq();
      try
      {
        paramFromServiceMsg = (msg_svc.PbUnReadMsgSeqReq)localPbUnReadMsgSeqReq.mergeFrom((byte[])paramToServiceMsg.getWupBuffer());
      }
      catch (Exception localException)
      {
        paramFromServiceMsg = localPbUnReadMsgSeqReq;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleGetPullTroopMsgNumTimeOut : decode pb:", localException);
          paramFromServiceMsg = localPbUnReadMsgSeqReq;
        }
      }
      paramFromServiceMsg = ((msg_svc.PbPullGroupMsgSeqReq)paramFromServiceMsg.group_unread_info.get()).group_info_req.get().iterator();
      while (paramFromServiceMsg.hasNext()) {
        b(String.valueOf(((msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq)paramFromServiceMsg.next()).group_code.get()), paramToServiceMsg.extraData.getInt("doSome"));
      }
      this.g += 1;
      return;
    }
    j(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void l()
  {
    this.jdField_d_of_type_Int = 0;
    this.g = 0;
  }
  
  public void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("groupuin");
    if (bool1)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.putBoolean("success", false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramFromServiceMsg, 1, null, null, paramToServiceMsg);
      }
    }
    else
    {
      try
      {
        d(paramFromServiceMsg, "handleGetPullTroopMsgError");
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError exception ! ", paramToServiceMsg);
        }
      }
      if (bool2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          notifyUI(4003, false, new String[] { paramFromServiceMsg });
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g();
        return;
      }
      notifyUI(4003, false, new String[] { paramFromServiceMsg });
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(false);
    a(false);
    b(false);
    b(false);
    e();
  }
  
  public void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("lDisUin"));
    if (bool)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.putBoolean("success", false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(String.valueOf(paramFromServiceMsg), 3000, null, null, paramToServiceMsg);
      }
    }
    else
    {
      paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      try
      {
        e(String.valueOf(paramFromServiceMsg), "handleGetPullDiscussionMsgError");
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgError exception ! ", paramToServiceMsg);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c())
      {
        notifyUI(4002, false, null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h();
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.d();
  }
  
  public void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    a(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() == 2901)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("<ReadReport_All>handleMsgReadedReportError_PB: reqSeq ");
          paramFromServiceMsg.append(l1);
          QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
        }
        if (a(paramToServiceMsg, "msf")) {
          return;
        }
      }
      if ((480000L == l2) || (paramToServiceMsg.a()))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("<ReadReport_All>handleMsgReadedReportError_PB, all retry: reqSeq ");
          paramToServiceMsg.append(l1);
          QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
        }
        a(l1);
      }
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGroupMsgAfterSyncMsg");
    }
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    Object[] arrayOfObject;
    if (!localConcurrentHashMap.isEmpty())
    {
      localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleGroupMsgAfterSyncMsg --> troopUin:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = (ArrayList)localConcurrentHashMap.get(localObject1);
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfObject = (Object[])((Iterator)localObject2).next();
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b((String)localObject1);
            if ((arrayOfObject != null) && (arrayOfObject.length >= 2)) {
              a("troop_processor").a(1001, new Object[] { arrayOfObject, null, Boolean.valueOf(false) });
            }
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a((String)localObject1);
        if (localObject1 != null) {
          ((TroopMessageProcessor)a("troop_processor")).a((GroupMsgReadedNotify)localObject1);
        }
      }
    }
    localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d();
    if (!localConcurrentHashMap.isEmpty())
    {
      localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleGroupMsgAfterSyncMsg --> discUin:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = (ArrayList)localConcurrentHashMap.get(localObject1);
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
        {
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d((String)localObject1);
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfObject = (Object[])((Iterator)localObject2).next();
            if ((arrayOfObject != null) && (arrayOfObject.length >= 3)) {
              a("disc_processor").a(1001, new Object[] { arrayOfObject[0], arrayOfObject[1], arrayOfObject[2], Boolean.valueOf(false) });
            }
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a((String)localObject1);
        if (localObject1 != null) {
          ((DiscMessageProcessor)a("disc_processor")).a((DisMsgReadedNotify)localObject1);
        }
      }
    }
  }
  
  public void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageError");
    }
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    a(paramToServiceMsg, paramFromServiceMsg);
    Object localObject = a(l1);
    if (localObject != null)
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (a((SendMessageHandler)localObject, "msf"))) {
        return;
      }
      if ((480000L == l2) || (((SendMessageHandler)localObject).a()))
      {
        localObject = new Object[6];
        localObject[0] = paramToServiceMsg.extraData.getString("groupuin");
        localObject[1] = Integer.valueOf(1026);
        localObject[2] = Integer.valueOf(0);
        localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
        localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
        localObject[5] = Long.valueOf(l3);
        a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
        a(3013, false, localObject);
        if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
        {
          int j = paramToServiceMsg.extraData.getInt("retryIndex", 0);
          localObject = new StatictisInfo();
          ((StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
          ((StatictisInfo)localObject).c = j;
          ((StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
          a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
        }
        a(l1);
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_f_of_type_Boolean = true;
    l();
    i();
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d();
    AudioUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.b();
    a();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
    ((DiscMessageProcessor)a("disc_processor")).a();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ThreadManager.post(new MessageHandler.11(this), 8, null, false);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq:");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" serviceCmd: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", resultCode:");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (a(paramToServiceMsg, paramFromServiceMsg, str)) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, str);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle [cmd]=");
      paramToServiceMsg.append(str);
      paramToServiceMsg.append(" , costTime = [");
      paramToServiceMsg.append(l2 - l1);
      paramToServiceMsg.append("]");
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  public void p()
  {
    send(createToServiceMsg("RegPrxySvc.getExtinfo"));
  }
  
  public void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    int j = paramToServiceMsg.extraData.getInt("msgtype");
    int k = paramToServiceMsg.extraData.getInt("retryIndex");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbReceiptRead><E><---handleC2CReceiptMessageError: ---cmd:MessageSvc.PbReceiptRead ssoseq:");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" appseq:");
      localStringBuilder.append(paramFromServiceMsg.getAppSeq());
      localStringBuilder.append(",sendC2CMessage error : peerUin:");
      localStringBuilder.append(str);
      localStringBuilder.append(" msgseq::");
      localStringBuilder.append(l1);
      localStringBuilder.append(" msgType:");
      localStringBuilder.append(j);
      localStringBuilder.append(" retryIndex:");
      localStringBuilder.append(k);
      localStringBuilder.append(" resultCode:");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append(" timeout:");
      localStringBuilder.append(l2);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    a(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l1);
    if (paramToServiceMsg != null)
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (a(paramToServiceMsg, "msf"))) {
        return;
      }
      if (paramToServiceMsg.a())
      {
        a(3021, false, new Long[] { Long.valueOf(j), Long.valueOf(l1), Long.valueOf(paramFromServiceMsg.getResultCode()) });
        a(l1);
      }
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d()) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e();
    boolean bool = false;
    Object localObject = new ArrayList();
    Iterator localIterator = localConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      bool = a(bool, (ArrayList)localObject, localIterator);
    }
    if (!((ArrayList)localObject).isEmpty()) {
      c((ArrayList)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msgSending:last, msgSendingTemp:");
      ((StringBuilder)localObject).append(localConcurrentHashMap);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    localConcurrentHashMap.clear();
  }
  
  public void r()
  {
    for (;;)
    {
      int j;
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_JavaUtilList;
        if (localObject != null)
        {
          if (((List)localObject).size() == 0) {
            return;
          }
          long l1 = 0L;
          if (QLog.isColorLevel()) {
            l1 = System.currentTimeMillis();
          }
          TroopBindPublicAccountMgr localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
          int k = ((List)localObject).size();
          j = 0;
          if (j < k)
          {
            register_proxy.GroupList localGroupList = (register_proxy.GroupList)((List)localObject).get(j);
            String str = String.valueOf(localGroupList.group_code.get());
            long l2 = localGroupList.group_seq.get();
            if (str.equals(localTroopBindPublicAccountMgr.a())) {
              break label226;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, l2);
            break label226;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("checkDelAbnormalLocalTroopMsg: ");
            ((StringBuilder)localObject).append(k);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
            QLog.d(".troop.del_abnormal_troop_local_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg exception ", localException);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_JavaUtilList = null;
        return;
      }
      label226:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler
 * JD-Core Version:    0.7.0.1
 */