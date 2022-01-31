package com.tencent.mobileqq.app;

import AccostSvc.RespClientMsg;
import AccostSvc.RespGetBlackList;
import AccostSvc.RespHeader;
import AccostSvc.SvrMsg;
import GeneralSettings.Setting;
import MessageSvcPack.GroupInfo;
import MessageSvcPack.MsgFilter;
import MessageSvcPack.PullGroupSeqParam;
import MessageSvcPack.RequestPushStatus;
import MessageSvcPack.SvcRequestGetMsgV2;
import MessageSvcPack.SvcRequestPullDisMsgSeq;
import MessageSvcPack.SvcRequestPullGroupMsgSeq;
import MessageSvcPack.SvcResponseDelRoamMsg;
import MessageSvcPack.SvcResponsePullDisMsgSeq;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import MessageSvcPack.SvcResponseSetRoamMsg;
import MessageSvcPack.stConfNumInfo;
import PushAdMsg.AdMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import PushNotifyPack.RequestPushNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import QQService.DiscussInfo;
import QQService.StreamData;
import QQService.StreamInfo;
import QQService.SvcReqMSFLoginNotify;
import RegisterProxySvcPack.RegisterPushNotice;
import RegisterProxySvcPack.SvcRequestPullDisGroupSeq;
import RegisterProxySvcPack.SvcResponsePullDisGroupSeq;
import RegisterProxySvcPack.stDisGroupInfo;
import SharpSvrPack.MultiVideoMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.VideoConstants;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.ShareStructLongMessageManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.message.AccostMessageProcessor;
import com.tencent.mobileqq.app.message.AccostMessageProcessor.DelAccostMsg;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.FileSlaveMasterMessageProcessor;
import com.tencent.mobileqq.app.message.HCTopicMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.app.message.ProcessorObserver;
import com.tencent.mobileqq.app.message.ProfileCardMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.message.VideoMessageProcessor;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.ADParser;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
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
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.scribble.ScribbleDownloader;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo;
import com.tencent.mobileqq.service.message.MessageCache.RegPrxyCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.SigStruct;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.pb.onlinepush.OnlinePushTrans.PbMsgInfo;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import cooperation.qlink.QlinkServiceManager;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import friendlist.EAddFriendSourceID;
import java.nio.ByteBuffer;
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
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import msf.msgsvc.msg_svc.PbC2CReadedReportResp;
import msf.msgsvc.msg_svc.PbDiscussReadedReportResp;
import msf.msgsvc.msg_svc.PbGetDiscussMsgReq;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.msgsvc.msg_svc.PbGetGroupMsgReq;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import msf.msgsvc.msg_svc.PbGetMsgReq;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgReq;
import msf.msgsvc.msg_svc.PbGetRoamMsgReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportResp;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqReq;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp;
import msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudReq;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;
import msf.registerproxy.register_proxy.SvcPbResponsePullDisMsgProxy;
import msf.registerproxy.register_proxy.SvcRegisterProxyMsgResp;
import msf.registerproxy.register_proxy.SvcResponseMsgInfo;
import msf.registerproxy.register_proxy.SvcResponsePbPullGroupMsgProxy;
import org.json.JSONArray;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_receipt.MsgInfo;
import tencent.im.msg.im_receipt.ReceiptInfo;
import tencent.im.msg.im_receipt.ReceiptReq;
import tencent.im.msg.im_receipt.ReceiptResp;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x9db.cmd0x9db.ReqBody;
import tencent.im.oidb.cmd0x9db.cmd0x9db.RspBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.ReqBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.ReqBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.SimilarItem;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;
import tencent.im.oidb.searcher.oidb_c2c_searcher.MsgKey;
import tencent.im.oidb.searcher.oidb_c2c_searcher.ReqBody;
import zgl;
import zgm;
import zgn;
import zgo;
import zgp;
import zgq;
import zgr;
import zgs;
import zgt;
import zgu;
import zgv;
import zgw;
import zgx;
import zgy;
import zgz;
import zha;
import zhb;
import zhc;
import zhd;

public class MessageHandler
  extends BusinessHandler
  implements ProcessorDispatcherInterface, ProcessorObserver
{
  static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = MessageHandler.class.getSimpleName();
  public static boolean a;
  public static boolean b;
  public static int d;
  public static boolean d;
  public static int e;
  public static int g;
  public static int h;
  public long a;
  private volatile Pair jdField_a_of_type_AndroidUtilPair;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new zgr(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public MessageCache a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public final HashMap a;
  private final HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  protected List a;
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  zhd jdField_a_of_type_Zhd;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private zhb[] jdField_a_of_type_ArrayOfZhb;
  public int b;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private final String jdField_b_of_type_JavaLangString = "Q.msg.MessageHandler";
  private Thread jdField_b_of_type_JavaLangThread;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private final int[] jdField_b_of_type_ArrayOfInt = new int[0];
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  public int c;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private final String jdField_c_of_type_JavaLangString = "Q.msg.MessageHandler";
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public boolean c;
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private final String jdField_d_of_type_JavaLangString = "Q.msg.MessageHandler";
  private ArrayList jdField_d_of_type_JavaUtilArrayList;
  private final HashMap jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private final String jdField_e_of_type_JavaLangString = "Q.msg.MessageHandler";
  private HashMap jdField_e_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_e_of_type_Boolean;
  public int f;
  private final String jdField_f_of_type_JavaLangString = "Q.msg.MessageHandler";
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = "Q.msg.MessageHandler";
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int m;
  private int n = -1;
  private final int o = 450000;
  private final int p = 9;
  private final int q = 3;
  private int r;
  private final int s = 2;
  private int t;
  private final int u = 3;
  private final int v = 6;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Boolean = true;
    jdField_d_of_type_Boolean = true;
    jdField_d_of_type_Int = 200;
    jdField_e_of_type_Int = 500;
    jdField_g_of_type_Int = 10103;
    jdField_h_of_type_Int = 10104;
  }
  
  MessageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("mobileQQ", 0);
    AppSetting.jdField_g_of_type_Boolean = paramQQAppInterface.getBoolean(AppSetting.jdField_a_of_type_JavaLangString, true);
    AppSetting.jdField_h_of_type_Boolean = paramQQAppInterface.getBoolean("c2c_del_msg_oper_enable", true);
  }
  
  private int a(SendMessageHandler paramSendMessageHandler)
  {
    int i1;
    do
    {
      i1 = MobileQQServiceBase.jdField_a_of_type_Int;
      MobileQQServiceBase.jdField_a_of_type_Int = i1 + 1;
    } while (!a(i1, paramSendMessageHandler));
    return i1;
  }
  
  private Pair a(String paramString, int paramInt)
  {
    long l1;
    long l2;
    long l3;
    Object localObject;
    if (paramInt == 3000)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g(paramString);
      l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramString);
      l3 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(128);
        ((StringBuilder)localObject).append("guessPullMsgStartSeq uin = ").append(paramString).append(" ,type = ").append(paramInt).append(" ,lastSeq = ").append(l1).append(" ,expiredSeq = ").append(l2).append(" ,delSeq = ").append(l3);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      List localList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt);
      localObject = MsgProxyUtils.a(localList, false);
      l2 = Math.max(l3, l2);
      boolean bool1 = MsgProxyUtils.a(paramString, paramInt, (List)localObject);
      boolean bool2 = MsgProxyUtils.c((List)localObject);
      if ((!bool1) && (!bool2)) {
        break label764;
      }
      paramString = MsgProxyUtils.a(localList, false, 25);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getRePullMsgSeqRange : pull more long msg");
      }
    }
    for (paramInt = 25;; paramInt = 10)
    {
      if ((paramString == null) || (paramString.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return local is null!");
        }
        return new Pair(Long.valueOf(l1), Long.valueOf(l1));
        if (paramInt == 1)
        {
          l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
          l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString);
          break;
        }
        return null;
      }
      l3 = ((MessageRecord)paramString.get(0)).shmsgseq;
      long l4 = Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
      l1 = Math.max(l2, l1);
      if (1L + l2 >= l3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return seq = " + Math.max(l1 - paramInt, l4) + "," + l1 + ",lowSeq >= lastBreakSeq ");
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l4)), Long.valueOf(l1));
      }
      if (l1 - l3 >= paramInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return seq = " + Math.max(l1 - paramInt, l4) + "," + l1 + ",continuedList >= " + paramInt);
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l4)), Long.valueOf(l1));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return seq = " + Math.max(l1 - paramInt, l2));
      }
      if (l1 > l4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return ok lastSeq > lastLocalSeq , (" + Math.max(l1 - paramInt, l2) + "," + l1 + ")");
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l2)), Long.valueOf(l1));
      }
      if (l1 == l4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return ok lastSeq == lastLocalSeq , (" + Math.max(l1 - paramInt, l2) + "," + Math.max(l3 - 1L, l2) + ")");
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l2)), Long.valueOf(l3 - 1L));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lastSeq < lastLocalSeq");
      }
      return new Pair(Long.valueOf(l1), Long.valueOf(l1));
      label764:
      paramString = (String)localObject;
    }
  }
  
  private Pair a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getPullMsgLowSeq uin = " + paramString + " ,type = " + paramInt + " ,lastSeq = " + paramLong1 + " ,expiredSeq = " + paramLong2 + " ,delSeq = " + paramLong3 + " ,svrSeq = " + paramLong4);
    }
    paramString = MsgProxyUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt), false);
    long l2 = paramLong1;
    long l3 = paramLong4;
    if (paramString != null)
    {
      l2 = paramLong1;
      l3 = paramLong4;
      if (!paramString.isEmpty())
      {
        long l1 = paramLong1;
        if (((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq < paramLong1) {
          l1 = ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq;
        }
        l2 = l1;
        l3 = paramLong4;
        if (((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq > paramLong4)
        {
          l3 = ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq;
          l2 = l1;
        }
      }
    }
    paramLong1 = Math.max(paramLong3, paramLong2);
    paramLong2 = Math.max(paramLong1, l2);
    paramLong3 = Math.max(paramLong1, l3);
    if (paramLong1 >= paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lowSeq >= lastSeq");
      }
      return new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong3));
    }
    if (l3 - l2 >= 10L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return pullCount >= 10");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return local is null! ");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    paramLong4 = ((MessageRecord)paramString.get(0)).shmsgseq;
    if (1L + paramLong1 >= paramLong4)
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return ok svrSeq > lastSeq , (" + Math.max(paramLong3 - 10L, paramLong1) + "," + paramLong3 + ")");
      }
      return new Pair(Long.valueOf(Math.max(paramLong3 - 10L, paramLong1)), Long.valueOf(paramLong3));
    }
    if (paramLong3 == paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return ok svrSeq == lastSeq , (" + Math.max(paramLong3 - 10L, paramLong1) + "," + Math.max(paramLong4 - 1L, paramLong1) + ")");
      }
      return new Pair(Long.valueOf(Math.max(paramLong3 - 10L, paramLong1)), Long.valueOf(Math.max(paramLong4 - 1L, paramLong1)));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "return svrSeq < lastSeq");
    }
    return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
  }
  
  public static String a(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)))
    {
      if (paramFromServiceMsg.getAttribute("_tag_socket") != null) {
        return "timeout_reason_SERVER_NO_RESPONSE";
      }
      return (String)paramFromServiceMsg.getAttribute("_tag_socket_connerror", String.valueOf(paramFromServiceMsg.getResultCode()));
    }
    return null;
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
  
  private zhd a()
  {
    if (this.jdField_a_of_type_Zhd == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Zhd == null) {
        this.jdField_a_of_type_Zhd = new zhd(this, ThreadManager.getSubThreadLooper());
      }
      return this.jdField_a_of_type_Zhd;
    }
  }
  
  private void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject)
  {
    m();
    paramToServiceMsg = new zhc(paramInt, paramToServiceMsg, ???, paramObject);
    if (paramInt == 1) {
      synchronized (this.jdField_d_of_type_JavaUtilArrayList)
      {
        this.jdField_d_of_type_JavaUtilArrayList.add(paramToServiceMsg);
        this.jdField_d_of_type_JavaUtilArrayList.notify();
        return;
      }
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramToServiceMsg);
      this.jdField_c_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  private void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject, boolean paramBoolean)
  {
    m();
    paramToServiceMsg = new zhc(paramInt, paramToServiceMsg, ???, paramObject, paramBoolean);
    if (paramInt == 1) {
      synchronized (this.jdField_d_of_type_JavaUtilArrayList)
      {
        this.jdField_d_of_type_JavaUtilArrayList.add(paramToServiceMsg);
        this.jdField_d_of_type_JavaUtilArrayList.notify();
        return;
      }
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramToServiceMsg);
      this.jdField_c_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    long l1 = System.currentTimeMillis() / 1000L;
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2013);
    localMessageRecord.init(str, paramString2, str, paramString1, l1, 0, paramInt, 0L);
    localMessageRecord.msgtype = -2013;
    localMessageRecord.isread = true;
    localArrayList.add(localMessageRecord);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, String.valueOf(str), false);
  }
  
  public static void a(MessageHandler.MsgSendCostParams paramMsgSendCostParams, QQAppInterface paramQQAppInterface)
  {
    int i1 = 2;
    Object localObject = new StringBuilder(256);
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).append("msg send cost per phase--->>").append("send_request:").append(paramMsgSendCostParams.jdField_a_of_type_Long).append(" ,request_reponse:").append(paramMsgSendCostParams.jdField_b_of_type_Long).append(" ,netSend_netRecv:").append(paramMsgSendCostParams.jdField_c_of_type_Long).append(" ,notifyUi_reflash:").append(paramMsgSendCostParams.e).append(" ,mUinType:").append(paramMsgSendCostParams.jdField_a_of_type_Int).append(" ,isCrossOper:").append(paramMsgSendCostParams.jdField_a_of_type_Boolean);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    long l1 = paramMsgSendCostParams.jdField_a_of_type_Long;
    ((HashMap)localObject).put("param_net", String.valueOf(NetworkUtil.a(BaseApplication.getContext())));
    ((HashMap)localObject).put("param_send_req", String.valueOf(paramMsgSendCostParams.jdField_a_of_type_Long));
    ((HashMap)localObject).put("param_req_resp", String.valueOf(paramMsgSendCostParams.jdField_b_of_type_Long));
    ((HashMap)localObject).put("param_netSend_netRecv", String.valueOf(paramMsgSendCostParams.jdField_c_of_type_Long));
    ((HashMap)localObject).put("param_notifyUi_reflash", String.valueOf(paramMsgSendCostParams.e));
    ((HashMap)localObject).put("param_uin_type", String.valueOf(paramMsgSendCostParams.jdField_a_of_type_Int));
    ((HashMap)localObject).put("param_msg_tag", paramMsgSendCostParams.jdField_a_of_type_JavaLangString);
    if (paramMsgSendCostParams.jdField_a_of_type_Boolean) {
      ((HashMap)localObject).put("param_cross_oper", String.valueOf(paramMsgSendCostParams.jdField_a_of_type_Boolean));
    }
    if (paramMsgSendCostParams.jdField_b_of_type_Boolean) {
      ((HashMap)localObject).put("param_sent_by_xg", String.valueOf(paramMsgSendCostParams.jdField_b_of_type_Boolean));
    }
    if (paramMsgSendCostParams.jdField_c_of_type_Boolean) {
      ((HashMap)localObject).put("param_weaknet", String.valueOf(paramMsgSendCostParams.jdField_c_of_type_Boolean));
    }
    if (paramMsgSendCostParams.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      if (paramMsgSendCostParams.jdField_b_of_type_Boolean) {
        i1 = 4;
      }
      if (paramMsgSendCostParams.jdField_c_of_type_Boolean) {
        i1 = 8;
      }
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i1));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "msgSendCostPerPhase", true, l1, 0L, (HashMap)localObject, "");
      return;
      i1 = 0;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    ShareStructLongMessageManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramMessageObserver, false);
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
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null)
    {
      l1 = 0L;
      paramBusinessObserver = a("MessageSvc.PbSendMsg", paramBusinessObserver);
      paramBusinessObserver.extraData.putString("uin", paramMessageRecord.frienduin);
      paramBusinessObserver.extraData.putLong("msgsize", l1);
      paramBusinessObserver.extraData.putLong("uniseq", paramMessageRecord.uniseq);
      paramBusinessObserver.extraData.putLong("timeOut", paramLong);
      paramBusinessObserver.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
      paramBusinessObserver.extraData.putLong("startTime", l2);
      paramBusinessObserver.extraData.putInt("retryIndex", paramInt);
      paramBusinessObserver.extraData.putInt("uintype", paramMessageRecord.istroop);
      paramBusinessObserver.extraData.putInt("msgtype", paramMessageRecord.msgtype);
      if ((paramMessageRecord instanceof MessageForText))
      {
        paramBusinessObserver.extraData.putInt("msg_signal_sum", ((MessageForText)paramMessageRecord).mMsgSignalSum);
        paramBusinessObserver.extraData.putInt("msg_signal_count", ((MessageForText)paramMessageRecord).mMsgSignalCount);
        paramBusinessObserver.extraData.putBoolean("msg_signal_open", ((MessageForText)paramMessageRecord).mIsMsgSignalOpen);
        paramBusinessObserver.extraData.putInt("msg_signal_net_type", ((MessageForText)paramMessageRecord).mMsgSignalNetType);
        paramBusinessObserver.extraData.putLong("msg_send_time", ((MessageForText)paramMessageRecord).mMsgSendTime);
      }
      if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 1026)) {
        break label627;
      }
      paramBusinessObserver.extraData.putString("groupuin", paramMessageRecord.frienduin);
      label321:
      if (MsgProxyUtils.o(paramMessageRecord.msgtype)) {
        paramBusinessObserver.extraData.putBoolean("RichNotify", true);
      }
      int i1 = MessageProtoCodec.b(paramMessageRecord.istroop);
      l1 = paramMessageRecord.msgUid;
      int i2 = (short)(int)paramMessageRecord.msgseq;
      int i3 = MessageUtils.a(l1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, String.format("<PbSendMsg><S> --->createSendRichTextMsgReq, uint32Seq:%d, random:%d, routingType:%d, %s", new Object[] { Integer.valueOf(0xFFFF & i2), Integer.valueOf(i3), Integer.valueOf(i1), paramMessageRecord.getBaseInfoString() }));
      }
      paramBusinessObserver.putWupBuffer(paramPbSendMsgReq.toByteArray());
      paramBusinessObserver.extraData.putInt("ROUNTING_TYPE", i1);
      paramBusinessObserver.extraData.putInt("send_msg_req_size", paramBusinessObserver.getWupBuffer().length);
      paramBusinessObserver.setTimeout(paramLong);
      paramBusinessObserver.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
      paramBusinessObserver.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
      paramBusinessObserver.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
      paramBusinessObserver.addAttribute("retryIndex", Integer.valueOf(paramInt));
      if (paramMessageRecord.frienduin != null) {
        break label686;
      }
      paramPbSendMsgReq = "";
      label546:
      paramBusinessObserver.addAttribute("uin", paramPbSendMsgReq);
      if (paramMessageRecord.senderuin != null) {
        break label694;
      }
    }
    label686:
    label694:
    for (paramPbSendMsgReq = "";; paramPbSendMsgReq = paramMessageRecord.senderuin)
    {
      paramBusinessObserver.addAttribute("fromUin", paramPbSendMsgReq);
      paramBusinessObserver.addAttribute("normal_msg", Boolean.valueOf(true));
      paramBusinessObserver.addAttribute("is_gold_msg", Boolean.valueOf(GoldMsgChatHelper.c(paramMessageRecord)));
      c(paramBusinessObserver);
      return;
      l1 = paramMessageRecord.msg.getBytes().length;
      break;
      label627:
      if (paramMessageRecord.istroop == 3000)
      {
        paramBusinessObserver.extraData.putString("uToUin", paramMessageRecord.frienduin);
        break label321;
      }
      if (MsgProxyUtils.a(paramMessageRecord.istroop) != 1032) {
        break label321;
      }
      paramBusinessObserver.extraData.putInt("key_confess_topicid", paramMessageRecord.getConfessTopicId());
      break label321;
      paramPbSendMsgReq = paramMessageRecord.frienduin;
      break label546;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      a(4004, true, null);
      return;
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request timeout!");
      }
      a(4004, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() == -20009)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request overload protection!");
      }
      a(4004, false, null);
      a(4001, false, null);
      a(4016, false, null);
      a(4003, false, null);
      a(4002, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request error!");
    }
    a(4004, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseDelRoamMsg paramSvcResponseDelRoamMsg)
  {
    boolean bool;
    if ((paramSvcResponseDelRoamMsg == null) || (paramSvcResponseDelRoamMsg.cReplyCode != 0))
    {
      bool = false;
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("handleDelRoamResp isSuccess = ").append(bool).append(" , cReplyCode = ");
        if (paramSvcResponseDelRoamMsg != null) {
          break label84;
        }
      }
    }
    label84:
    for (paramToServiceMsg = "null";; paramToServiceMsg = Byte.valueOf(paramSvcResponseDelRoamMsg.cReplyCode))
    {
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg);
      b(1003, bool, null);
      return;
      bool = true;
      break;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullDisMsgSeq paramSvcResponsePullDisMsgSeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDisMsgSeq.");
    }
    m(paramToServiceMsg, paramFromServiceMsg, paramSvcResponsePullDisMsgSeq);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgSeq.");
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramSvcResponsePullGroupMsgSeq);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseSetRoamMsg paramSvcResponseSetRoamMsg)
  {
    if ((paramSvcResponseSetRoamMsg == null) || (paramSvcResponseSetRoamMsg.cReplyCode != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      b(1005, bool, null);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, AdMsgInfo paramAdMsgInfo)
  {
    long l1;
    if ((paramAdMsgInfo != null) && (String.valueOf(paramAdMsgInfo.uDstUin).equalsIgnoreCase(paramToServiceMsg.getUin())))
    {
      l1 = paramAdMsgInfo.utime;
      paramToServiceMsg = paramAdMsgInfo.strMsgContent;
      if (paramAdMsgInfo.uMsgType != 9) {
        break label174;
      }
      paramFromServiceMsg = MessageRecordFactory.a(-2003);
      paramFromServiceMsg.selfuin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramFromServiceMsg.frienduin = String.valueOf(AppConstants.H);
      paramFromServiceMsg.senderuin = String.valueOf(AppConstants.H);
      paramFromServiceMsg.msg = paramToServiceMsg;
      paramFromServiceMsg.time = l1;
      paramFromServiceMsg.msgtype = -2003;
      paramFromServiceMsg.istroop = 0;
      if (!MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, false))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramAdMsgInfo.uSrcUin), 1, true, false, null);
      }
    }
    label174:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramAdMsgInfo.uMsgType != 513);
        int i1 = ADParser.a(paramToServiceMsg);
        paramFromServiceMsg = ADParser.a(paramToServiceMsg);
        switch (i1)
        {
        case 1: 
        case 3: 
        default: 
          return;
        }
      } while ((paramFromServiceMsg == null) || ((!paramFromServiceMsg.equals("WAP")) && (!paramFromServiceMsg.equals("WAPI")) && (!paramFromServiceMsg.equals("TMTWAP")) && (!paramFromServiceMsg.equals("TMTWAPI")) && (!paramFromServiceMsg.equals("LOCAL"))));
      paramFromServiceMsg = MessageRecordFactory.a(-2004);
      paramFromServiceMsg.selfuin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramFromServiceMsg.frienduin = String.valueOf(AppConstants.H);
      paramFromServiceMsg.senderuin = String.valueOf(AppConstants.H);
      paramFromServiceMsg.msg = paramToServiceMsg;
      paramFromServiceMsg.time = l1;
      paramFromServiceMsg.msgtype = -2004;
      paramFromServiceMsg.istroop = 0;
    } while (MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, false));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramAdMsgInfo.uSrcUin), 1, true, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify)
  {
    paramToServiceMsg = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify() vC2CReadedNotify=" + paramSvcRequestPushReadedNotify.vC2CReadedNotify + ", vGroupReadedNotify=" + paramSvcRequestPushReadedNotify.vGroupReadedNotify + ", vDisMsgReadedNotify=" + paramSvcRequestPushReadedNotify.vDisReadedNotify);
    }
    boolean bool1 = false;
    if ((paramSvcRequestPushReadedNotify.cNotifyType & 0x8) == 8)
    {
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify() isSubAccount=true");
        bool1 = bool2;
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramSvcRequestPushReadedNotify.vC2CReadedNotify != null) && (paramSvcRequestPushReadedNotify.vC2CReadedNotify.size() > 0))
    {
      if (bool1)
      {
        paramFromServiceMsg = (SubAccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        localObject1 = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
        int i1 = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (C2CMsgReadedNotify)((Iterator)localObject1).next();
          String str1 = Long.toString(((C2CMsgReadedNotify)localObject2).lPeerUin);
          String str2 = Long.toString(((C2CMsgReadedNotify)localObject2).lBindedUin);
          int i2 = paramFromServiceMsg.a(str2, str1);
          i1 += i2;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify C2CMsgReadedNotify curFriendUin is " + ((C2CMsgReadedNotify)localObject2).lPeerUin + ", lLastReadTime  is " + ((C2CMsgReadedNotify)localObject2).lLastReadTime + " isSubAccount=" + bool1 + " changed=" + i2);
          }
          if (i1 != 0)
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str2, 7000, i1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify subUin=" + str2 + "increaseUnread=" + i1);
            }
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.w, str2 });
        }
      }
      paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vC2CReadedNotify);
      paramFromServiceMsg = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        localObject1 = (C2CMsgReadedNotify)paramFromServiceMsg.next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "C2CMsgReadedNotify curFriendUin is " + ((C2CMsgReadedNotify)localObject1).lPeerUin + ", lLastReadTime  is " + ((C2CMsgReadedNotify)localObject1).lLastReadTime + " isSubAccount=" + bool1);
        }
        localObject2 = String.valueOf(((C2CMsgReadedNotify)localObject1).lPeerUin);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, 0, ((C2CMsgReadedNotify)localObject1).lLastReadTime);
        if (((C2CMsgReadedNotify)localObject1).lLastReadTime >= 0L) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.a((String)localObject2, 0);
        }
      }
    }
    if ((paramSvcRequestPushReadedNotify.vGroupReadedNotify != null) && (paramSvcRequestPushReadedNotify.vGroupReadedNotify.size() > 0))
    {
      paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vGroupReadedNotify);
      paramFromServiceMsg = paramSvcRequestPushReadedNotify.vGroupReadedNotify.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        localObject1 = (GroupMsgReadedNotify)paramFromServiceMsg.next();
        localObject2 = String.valueOf(((GroupMsgReadedNotify)localObject1).lGroupCode);
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2) == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, (GroupMsgReadedNotify)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "GroupMsgReadedNotify unfinished groupUin=" + (String)localObject2);
          }
        }
        else
        {
          ((TroopMessageProcessor)a("troop_processor")).a((GroupMsgReadedNotify)localObject1);
        }
      }
    }
    if ((paramSvcRequestPushReadedNotify.vDisReadedNotify != null) && (paramSvcRequestPushReadedNotify.vDisReadedNotify.size() > 0))
    {
      paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vDisReadedNotify);
      paramFromServiceMsg = paramSvcRequestPushReadedNotify.vDisReadedNotify.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramSvcRequestPushReadedNotify = (DisMsgReadedNotify)paramFromServiceMsg.next();
        localObject1 = String.valueOf(paramSvcRequestPushReadedNotify.lDisUin);
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1) == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, paramSvcRequestPushReadedNotify);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "DisMsgReadedNotify unfinished discussionUin=" + (String)localObject1);
          }
        }
        else
        {
          ((DiscMessageProcessor)a("disc_processor")).a(paramSvcRequestPushReadedNotify);
        }
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
      a(6004, true, paramToServiceMsg.toArray());
    }
  }
  
  @Deprecated
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullDisGroupSeq paramSvcResponsePullDisGroupSeq)
  {
    SvcResponsePullDisMsgSeq localSvcResponsePullDisMsgSeq = null;
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("registerproxy->handleMsgProxyDisGroupMsgSeq.");
    }
    if ((!paramFromServiceMsg.isSuccess()) || ((paramSvcResponsePullDisGroupSeq != null) && (paramSvcResponsePullDisGroupSeq.cReplyCode != 0)))
    {
      a(1000, false, null);
      return;
    }
    if (paramSvcResponsePullDisGroupSeq != null)
    {
      DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      localSvcResponsePullDisMsgSeq = new SvcResponsePullDisMsgSeq();
      localSvcResponsePullDisMsgSeq.cReplyCode = paramSvcResponsePullDisGroupSeq.cReplyCode;
      localSvcResponsePullDisMsgSeq.strResult = paramSvcResponsePullDisGroupSeq.strResult;
      if (paramSvcResponsePullDisGroupSeq.vDisInfo != null)
      {
        PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
        HashMap localHashMap = new HashMap();
        localSvcResponsePullDisMsgSeq.vConfNumInfo = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (QLog.isColorLevel()) {
          localStringBuilder.append(", size=").append(paramSvcResponsePullDisGroupSeq.vDisInfo.size());
        }
        int i1 = 0;
        if (i1 < paramSvcResponsePullDisGroupSeq.vDisInfo.size())
        {
          stDisGroupInfo localstDisGroupInfo = (stDisGroupInfo)paramSvcResponsePullDisGroupSeq.vDisInfo.get(i1);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\nlDisCode=").append(localstDisGroupInfo.lDisCode).append(", eInfoFlag=").append(localstDisGroupInfo.eInfoFlag).append(", infoSeq=").append(localstDisGroupInfo.uInfoSeq);
          }
          switch (localstDisGroupInfo.eInfoFlag)
          {
          }
          for (;;)
          {
            i1 += 1;
            break;
            Object localObject = new stConfNumInfo();
            ((stConfNumInfo)localObject).lConfUin = localstDisGroupInfo.lDisCode;
            ((stConfNumInfo)localObject).uConfMsgSeq = localstDisGroupInfo.uDisMsgSeq;
            ((stConfNumInfo)localObject).uMemberMsgSeq = localstDisGroupInfo.uMemberMsgSeq;
            localSvcResponsePullDisMsgSeq.vConfNumInfo.add(localObject);
            localObject = new DiscussInfo();
            ((DiscussInfo)localObject).DiscussUin = localstDisGroupInfo.lDisCode;
            ((DiscussInfo)localObject).InfoSeq = localstDisGroupInfo.uInfoSeq;
            localArrayList.add(localObject);
            if (localstDisGroupInfo.lRedPackTime > 0L)
            {
              localHashMap.put(String.valueOf(localstDisGroupInfo.lDisCode), String.valueOf(localstDisGroupInfo.lRedPackTime));
              continue;
              localDiscussionHandler.a(String.valueOf(localstDisGroupInfo.lDisCode));
            }
          }
        }
        localPasswdRedBagManager.b(localHashMap);
        localDiscussionHandler.a(localArrayList);
      }
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    m(paramToServiceMsg, paramFromServiceMsg, localSvcResponsePullDisMsgSeq);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.SigStruct paramSigStruct)
  {
    if (paramSigStruct == null)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramSigStruct.a, paramSigStruct.b);
    b(5002, true, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object arg3, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp1 = new msg_svc.PbGetGroupMsgResp();
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp2;
    int i1;
    boolean bool1;
    boolean bool2;
    Object localObject;
    long l1;
    try
    {
      localPbGetGroupMsgResp1 = (msg_svc.PbGetGroupMsgResp)localPbGetGroupMsgResp1.mergeFrom((byte[])???);
      if (localPbGetGroupMsgResp1 == null) {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      if ((localPbGetGroupMsgResp1 == null) || (??? == null))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB : Exception occurs whitl parsing the bytes.");
        }
        localPbGetGroupMsgResp2 = null;
      }
      i1 = paramToServiceMsg.extraData.getInt("doSome", 0);
      bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      label188:
      boolean bool3;
      StringBuilder localStringBuilder1;
      if (paramToServiceMsg.getUin() == null)
      {
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject = paramToServiceMsg.extraData.getString("groupuin");
        if (localObject == null) {
          break label482;
        }
        l1 = Long.valueOf((String)localObject).longValue();
        bool3 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder(128);
          StringBuilder localStringBuilder2 = localStringBuilder1.append("handleGetPullTroopMsgResp msgStruct.cReplyCode = ");
          if (localPbGetGroupMsgResp2 != null) {
            break label495;
          }
          localObject = "null";
          label239:
          localStringBuilder2.append(localObject).append(" troopUin: ").append(l1).append(",isRefreshHead:").append(bool3).append(", dataHash=").append(???.hashCode()).append(" rtnBeginSeq:").append(localPbGetGroupMsgResp2.return_begin_seq.get()).append(" rtnEndSeq:").append(localPbGetGroupMsgResp2.return_end_seq.get()).append(",doSome:").append(i1);
          if (!paramBoolean) {
            localStringBuilder1.append(",costTime:").append(System.currentTimeMillis() - TroopMessageManager.jdField_b_of_type_Long);
          }
          localStringBuilder1.append(" ThreadId:" + Thread.currentThread().getId());
          if (localPbGetGroupMsgResp2.msg.get() == null) {
            break label511;
          }
          localStringBuilder1.append(" msgSize:").append(localPbGetGroupMsgResp2.msg.get().size());
          label418:
          if (QLog.isColorLevel()) {
            if (!paramBoolean) {
              break label523;
            }
          }
        }
      }
      label523:
      for (??? = "Q.msg.MessageHandler.troop.register_proxy_pull_msg";; ??? = "Q.msg.MessageHandler.trooptroop_pull_msg")
      {
        QLog.d(???, 2, localStringBuilder1.toString());
        synchronized (a(String.valueOf(l1), 1))
        {
          if (!a(paramToServiceMsg, localPbGetGroupMsgResp2)) {
            break label530;
          }
          return;
        }
        paramFromServiceMsg = paramToServiceMsg.getUin();
        break;
        label482:
        l1 = localPbGetGroupMsgResp2.group_code.get();
        break label188;
        label495:
        localObject = Integer.valueOf(localPbGetGroupMsgResp2.result.get());
        break label239;
        label511:
        localStringBuilder1.append(" msg:null.");
        break label418;
      }
      label530:
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(l1);
      if (!bool3) {}
    }
    for (;;)
    {
      try
      {
        a("troop_processor").a(1003, new Object[] { paramToServiceMsg, localPbGetGroupMsgResp2, localObject, paramFromServiceMsg });
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(l1);
        ((TroopMessageProcessor)a("troop_processor")).a("" + l1, localPbGetGroupMsgResp2, i1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "handleGetPullGroupMsgResp_PB, cost:" + (System.currentTimeMillis() - l2));
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB refreshTroopHead exception ! ", paramToServiceMsg);
        continue;
      }
      try
      {
        a("troop_processor").a(1002, new Object[] { paramToServiceMsg, localObject, localPbGetGroupMsgResp2, paramFromServiceMsg });
        if (bool2)
        {
          this.jdField_l_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(l1), 2);
        }
        for (;;)
        {
          if (!bool1) {
            break label953;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          paramToServiceMsg = "" + l1;
          MsgAutoMonitorUtil.a().g();
          a(4003, true, new String[] { paramToServiceMsg });
          break;
          d(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB initGetPullTroopMsg exception ! ", paramToServiceMsg);
          }
          if (bool2)
          {
            this.jdField_l_of_type_Int += 1;
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(l1), 2);
          }
          else
          {
            d(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
          }
        }
      }
      finally
      {
        if (bool2)
        {
          this.jdField_l_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(l1), 2);
        }
        for (;;)
        {
          throw paramToServiceMsg;
          d(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
        }
        label953:
        if (bool2)
        {
          if ((this.jdField_b_of_type_Int != 0) && (this.jdField_l_of_type_Int >= this.jdField_b_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN , troopNum:" + this.jdField_b_of_type_Int + " , recvTroopNum:" + this.jdField_l_of_type_Int);
            }
            MsgAutoMonitorUtil.a().g();
            a(4003, true, null);
          }
        }
        else {
          a(4003, true, new String[] { "" + l1 });
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      paramToServiceMsg.extraData.getByte("cBodyType", (byte)-1).byteValue();
    } while (paramToServiceMsg.extraData.getInt("msgtype", -1) != -1000);
    a("actSendDiscussProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e()) && (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString, paramInt, paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "handleRevokingRichMsgCacheAndNotify, in revoking cache, isSuc:" + paramBoolean);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.f(null);
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt).b();
    }
  }
  
  private void a(String paramString, int paramInt1, boolean paramBoolean1, Object paramObject, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, MessageRecord paramMessageRecord)
  {
    if ((paramInt1 == 1000) && (paramString != null) && (QLog.isColorLevel())) {
      QLog.d("notification", 2, "funName:" + paramString + ",isSuccess:" + paramBoolean1);
    }
    if ((paramBoolean2) && (paramInt1 == 1000) && (paramBoolean1 == true))
    {
      if (paramInt2 <= 0) {
        break label359;
      }
      if (paramMessageRecord != null) {
        break label305;
      }
    }
    try
    {
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramBoolean3) {
        break label299;
      }
      paramBoolean2 = true;
      paramString.a(paramInt2, true, paramBoolean2);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label103:
        if (QLog.isColorLevel())
        {
          QLog.w("notification", 2, "notification exception", paramString);
          continue;
          paramBoolean2 = false;
        }
      }
    }
    a(paramInt1, paramBoolean1, paramObject);
    if (paramInt1 == 3001) {
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length > 2))
        {
          paramString = (String)paramObject[0];
          ((Integer)paramObject[1]).intValue();
          if (((Integer)paramObject[2]).intValue() == 58)
          {
            MessageUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
            paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            if (!paramObject.d(paramString))
            {
              paramMessageRecord = paramObject.c(String.valueOf(paramString));
              if (paramMessageRecord != null)
              {
                paramMessageRecord.setShieldFlag(true);
                paramObject.a(paramMessageRecord);
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(56, true, new Object[] { Long.valueOf(Long.parseLong(paramString)), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), "" });
              }
            }
          }
        }
      }
    }
    label299:
    label305:
    label359:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramBoolean2 = false;
              break;
              paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              if (!paramBoolean3)
              {
                paramBoolean2 = true;
                paramString.a(paramInt2, true, paramBoolean2, paramMessageRecord);
                break label103;
              }
              if (!QLog.isColorLevel()) {
                break label103;
              }
              QLog.d("notification", 2, "notification size = 0");
              break label103;
              if ((paramInt1 != 6000) && (paramInt1 != 8002) && (paramInt1 != 7000) && (paramInt1 != 8005) && (paramInt1 != 8006) && (paramInt1 != 6010) && (paramInt1 != 6012) && (paramInt1 != 6013) && (paramInt1 != 8008) && (paramInt1 != 8010) && (paramInt1 != 8012) && (paramInt1 != 8014) && (paramInt1 != 3020) && (paramInt1 != 8035) && (paramInt1 != 8028) && (paramInt1 != 8032)) {
                break label577;
              }
            } while (!(paramObject instanceof Object[]));
            paramString = (Object[])paramObject;
          } while ((paramString == null) || (paramString.length <= 2));
          paramObject = (String)paramString[0];
          paramInt2 = ((Integer)paramString[1]).intValue();
        } while ((((Integer)paramString[2]).intValue() != 55) || (paramInt1 == 8035));
        ((ShieldListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(18)).a(paramObject, paramInt2);
        return;
      } while (((paramInt1 != 3002) && (paramInt1 != 3013) && (paramInt1 != 3008)) || (!(paramObject instanceof Object[])));
      paramString = (Object[])paramObject;
    } while ((paramString == null) || (paramString.length <= 2));
    label577:
    ((Integer)paramString[2]).intValue();
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(ProcessorDispatcher.a(paramString)).a(ProcessorDispatcher.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(ProcessorDispatcher.a(paramString)).a(ProcessorDispatcher.a(paramString), new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  private void a(String paramString1, String paramString2, byte paramByte, boolean paramBoolean, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ClientMsg");
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
    a(localToServiceMsg);
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    HashMap localHashMap = new HashMap();
    long l2 = paramFromServiceMsg.getResultCode();
    long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    long l1 = l2;
    if (l3 != 0L)
    {
      l1 = l2;
      if (l3 != 241L)
      {
        l1 = 2900L;
        localHashMap.put("param_ServerReplyCode", paramFromServiceMsg.extraData.getLong("ServerReplyCode") + "");
      }
    }
    localHashMap.put("param_FailCode", l1 + "");
    long l4 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    localHashMap.put("param_retryIndex", Long.toString(l4));
    l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    l2 = System.currentTimeMillis();
    Object localObject;
    String str;
    if (l1 < 1L)
    {
      l1 = 0L;
      if (!paramToServiceMsg.extraData.containsKey("msgSeq")) {
        break label934;
      }
      localObject = a(paramToServiceMsg.extraData.getLong("msgSeq"));
      if (localObject == null) {
        break label934;
      }
      str = ((SendMessageHandler)localObject).toString();
      localHashMap.put("param_retryInfo", str);
    }
    for (l3 = ((SendMessageHandler)localObject).a(l2);; l3 = l1)
    {
      localObject = a(paramFromServiceMsg);
      if (localObject != null) {
        localHashMap.put("param_reason", localObject);
      }
      l1 = 0L;
      l2 = l1;
      if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
      {
        l2 = l1;
        if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
        {
          l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          l2 = l1;
          if (l1 <= 2147483647L) {}
        }
      }
      for (l1 = 0L;; l1 = l2)
      {
        int i1 = paramToServiceMsg.extraData.getInt("msg_signal_sum");
        int i2 = paramToServiceMsg.extraData.getInt("msg_signal_count");
        boolean bool1 = paramToServiceMsg.extraData.getBoolean("msg_signal_open");
        int i3 = paramToServiceMsg.extraData.getInt("msgtype", -1);
        int i4 = paramToServiceMsg.extraData.getInt("msg_signal_net_type", -1);
        localHashMap.put("pm_signal_sum", String.valueOf(i1));
        localHashMap.put("pm_signal_count", String.valueOf(i2));
        localHashMap.put("pm_signal_open", String.valueOf(bool1));
        localHashMap.put("pm_msgtype", String.valueOf(i3));
        localHashMap.put("pm_nettype", String.valueOf(i4));
        localHashMap.put("pm_msftime", String.valueOf(l1));
        int i5 = paramToServiceMsg.extraData.getInt("send_msg_req_size", 0);
        boolean bool2 = paramToServiceMsg.extraData.getBoolean("isJuhuaExist");
        localHashMap.put("pm_req_size", String.valueOf(i5));
        localHashMap.put("isJuhuaExist", String.valueOf(bool2));
        bool2 = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
        boolean bool3 = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
        boolean bool4 = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
        localHashMap.put("isCrossOper", String.valueOf(bool2));
        localHashMap.put("isSentByXG", String.valueOf(bool3));
        localHashMap.put("isWeaknet", String.valueOf(bool4));
        l2 = paramFromServiceMsg.extraData.getLong(MessageConstants.jdField_b_of_type_JavaLangString, 0L);
        int i6 = paramFromServiceMsg.extraData.getInt(MessageConstants.jdField_a_of_type_JavaLangString, 0);
        if (l2 == 0L) {}
        for (l2 = 0L;; l2 = System.currentTimeMillis() - l2)
        {
          localHashMap.put("pm_queueTime", String.valueOf(l2));
          localHashMap.put("pm_respLen", String.valueOf(i6));
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramBoolean, l3, paramLong, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, success:%s, duration:%dms, retryNum:%d, detail:%s, msgSignal [Sum:%d Count:%d, Open:%s msgType:%d netType:%d msfTime:%d reqSize:%d queueHandleTime:%d respWaitLen:%d]", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(l3), Long.valueOf(l4), str, Integer.valueOf(i1), Integer.valueOf(i2), Boolean.valueOf(bool1), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l1), Integer.valueOf(i5), Long.valueOf(l2), Integer.valueOf(i6) }));
          }
          return;
          l1 = l2 - l1;
          break;
        }
      }
      label934:
      str = "";
    }
  }
  
  private void a(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1006) {
      if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 1600) || (paramInt2 == 1601) || (paramInt2 == 1602) || (paramInt2 == 1603))) {
        a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
      }
    }
    for (;;)
    {
      if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
        a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
      }
      return;
      if (paramInt1 == 1022)
      {
        if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
          a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
        }
      }
      else if (paramInt1 == 1010)
      {
        if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 54) || (paramInt2 == 61) || (paramInt2 == 62) || (paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65)))
        {
          AddMessageHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
          switch (paramInt2)
          {
          default: 
            break;
          case 63: 
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
            break;
          case 64: 
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
            break;
          case 65: 
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
            break;
          }
        }
      }
      else
      {
        label468:
        Object localObject2;
        Object localObject1;
        if ((paramInt1 == 1001) || (paramInt1 == 10002))
        {
          if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65) || ((paramInt2 >= 10000) && (paramInt2 < 20000))))
          {
            AddMessageHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
            switch (paramInt2)
            {
            default: 
              if ((paramInt2 >= 10000) && (paramInt2 < 20000))
              {
                localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
                if (paramInt1 != 1001) {
                  break label673;
                }
              }
              break;
            }
            label673:
            for (localObject1 = "0";; localObject1 = "1")
            {
              ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, (String)localObject1, "" + paramInt2, "", "");
              break;
              ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
              break label468;
              ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
              break label468;
              ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
              break label468;
              break;
            }
          }
        }
        else if ((paramInt1 == 0) && (paramInt2 == 16))
        {
          localObject2 = paramPbSendMsgResp.errmsg.get();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "发送失败，请先添加对方为好友。";
          }
          localObject1 = new UniteGrayTipParam(paramString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject1, paramInt1, -5020, 1376257, MessageCache.a());
          localObject2 = new MessageForUniteGrayTip();
          ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
          UniteGrayTipUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 21)) {}
    long l2;
    long l3;
    long l4;
    long l5;
    Object localObject;
    do
    {
      do
      {
        return;
      } while (paramArrayOfByte[0] != 3);
      long l1 = PkgTools.a(paramArrayOfByte, 1);
      l2 = PkgTools.a(paramArrayOfByte, 5);
      l3 = PkgTools.a(paramArrayOfByte, 9);
      l4 = PkgTools.a(paramArrayOfByte, 13);
      l5 = PkgTools.a(paramArrayOfByte, 17);
      if (QLog.isColorLevel()) {
        QLog.d("Emoticon", 2, "uin:" + l1 + " epId=" + l2 + " expireTime=" + l3 + " flag=" + l4);
      }
      localObject = (EmoticonManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    } while (((EmoticonManager)localObject).b(Long.toString(l2), 0) != null);
    paramArrayOfByte = new EmoticonPackage();
    paramArrayOfByte.epId = Long.toString(l2);
    paramArrayOfByte.wordingId = l5;
    if (l4 == 1L) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfByte.valid = bool;
      paramArrayOfByte.expiretime = l3;
      paramArrayOfByte.aio = true;
      ((EmoticonManager)localObject).a(paramArrayOfByte);
      ((EmoticonManager)localObject).a(paramArrayOfByte.epId, 0);
      localObject = (EmojiManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      ((EmojiManager)localObject).a(paramArrayOfByte.epId, EmojiManager.jdField_b_of_type_Int);
      ((EmojiManager)localObject).a(paramArrayOfByte);
      return;
    }
  }
  
  private void a(Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    paramString = (String)paramArrayOfObject[0];
    int i1 = ((Integer)paramArrayOfObject[1]).intValue();
    long l1 = ((Long)paramArrayOfObject[5]).longValue();
    paramArrayOfObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, i1);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, i1, l1);
    if ((paramArrayOfObject != null) && (paramArrayOfObject.uniseq == l1)) {
      paramArrayOfObject.extraflag = 32768;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, i1, l1, 32768, paramInt);
  }
  
  private boolean a(long paramLong)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
      {
        this.jdField_d_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "the values of disable big data channel is" + PublicAccountConfigUtil.o);
    }
    if (PublicAccountConfigUtil.o) {}
    do
    {
      do
      {
        return false;
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break;
        }
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramMessageRecord).structingMsg;
        if ((localAbsStructMsg != null) && (ShareStructLongMessageManager.a(localAbsStructMsg)))
        {
          String str1 = paramMessageRecord.getExtInfoFromExtStr("send_by_struct_long_message");
          String str2 = ShareStructLongMessageManager.a(localAbsStructMsg);
          String str3 = ShareStructLongMessageManager.a(str2);
          if (!"1".equals(str1))
          {
            paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "1");
            a(paramMessageRecord, paramMessageObserver);
            PublicAccountReportUtils.a(null, localAbsStructMsg.source_puin, "0X8007A26", "0X8007A26", 0, 0, str3, str2, "", "", false);
            return true;
          }
          paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "0");
          PublicAccountReportUtils.a(null, localAbsStructMsg.source_puin, "0X8007A27", "0X8007A27", 0, 0, str3, str2, "", "", false);
          return false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, "struct msg is null");
      return false;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "it is not message for structing");
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    if ((paramPbGetDiscussMsgResp.msg.get() != null) && (paramPbGetDiscussMsgResp.msg.get().size() > 0))
    {
      boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq");
      long l2 = paramPbGetDiscussMsgResp.return_begin_seq.get();
      long l3 = paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pullNextDisMsg disUin: ").append(l3).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" srcBegSeq: ").append(l1).append(" srcEndSeq: ").append(paramToServiceMsg.extraData.getLong("lEndSeq")).append(" res.lReturnBeginSeq: ").append(l2).append(" res.lReturnEndSeq: ").append(paramPbGetDiscussMsgResp.return_end_seq.get()).append(" res.vMsgs.size(): ").append(paramPbGetDiscussMsgResp.msg.get().size());
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(l3, paramPbGetDiscussMsgResp.msg.get());
      if ((!bool1) && (!bool2) && (l1 <= l2 - 1L) && (paramPbGetDiscussMsgResp.return_begin_seq.get() <= paramPbGetDiscussMsgResp.return_end_seq.get())) {
        return a(l3, l1, l2 - 1L, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"));
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
      int i1;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (paramPbGetGroupMsgResp.msg.get() != null)
      {
        i1 = 1;
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder(128);
          localStringBuilder2 = localStringBuilder1.append("pullNextTroopMsg troopUin: ").append((String)localObject1).append(" msgStruct.cReplyCode: ").append(paramPbGetGroupMsgResp.result.get()).append(" lBeginSeq: ").append(l1).append(" lEndSeq: ").append(paramToServiceMsg.extraData.getLong("lEndSeq")).append(" res.lReturnBeginSeq: ").append(l2).append(" res.lReturnEndSeq: ").append(paramPbGetGroupMsgResp.return_end_seq.get()).append(" msg.size(): ");
          if (i1 == 0) {
            break label379;
          }
        }
      }
      label379:
      for (localObject2 = Integer.valueOf(paramPbGetGroupMsgResp.msg.get().size());; localObject2 = "null")
      {
        localStringBuilder2.append(localObject2);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder1.toString());
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramPbGetGroupMsgResp.group_code.get(), paramPbGetGroupMsgResp.msg.get());
        l2 -= 1L;
        if ((bool1) || (bool2) || (l1 > l2) || (paramPbGetGroupMsgResp.return_begin_seq.get() > paramPbGetGroupMsgResp.return_end_seq.get())) {
          break label387;
        }
        return a((String)localObject1, l1, l2, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"), paramToServiceMsg.extraData.getInt("doSome"));
        i1 = 0;
        break;
      }
    }
    label387:
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgGetting: " + this.jdField_g_of_type_Boolean);
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        b(true);
        h(paramBoolean);
        return false;
      }
      return true;
    }
  }
  
  private long[] a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("--->>initBeforGetPullTroopMsgNumber, troopUinArray.length=").append(paramArrayOfString.length).append(", list=");
    }
    long[] arrayOfLong = new long[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramArrayOfString[i1], 0);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e(paramArrayOfString[i1]);
      arrayOfLong[i1] = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(paramArrayOfString[i1]);
      if (QLog.isColorLevel()) {
        localStringBuilder.append(paramArrayOfString[i1]).append(":").append(arrayOfLong[i1]).append(", ");
      }
      i1 += 1;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    return arrayOfLong;
  }
  
  private Object[] a()
  {
    Object localObject = ((DiscussionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(52)).a();
    String[] arrayOfString = new String[((ArrayList)localObject).size()];
    long[] arrayOfLong = new long[((ArrayList)localObject).size()];
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("--->>initBeforGetPullDiscussionMsgNum: discussLength:").append(((ArrayList)localObject).size()).append(", discussionUinArray: ");
    }
    localObject = ((ArrayList)localObject).iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = ((DiscussionInfo)((Iterator)localObject).next()).uin;
      arrayOfString[i1] = str;
      arrayOfLong[i1] = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(str);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str, 0);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g(str);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(str);
      if (QLog.isColorLevel()) {
        localStringBuilder.append(str).append(":").append(arrayOfLong[i1]).append(", ");
      }
      i1 += 1;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if ((arrayOfString == null) || (i1 == 0))
    {
      a(4002, true, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>initBeforGetPullDiscussionMsgNum, get discussionUin is null or length is 0, notifyUI NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
      }
      return null;
    }
    return new Object[] { arrayOfString, arrayOfLong, Integer.valueOf(i1) };
  }
  
  public static String b(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() == 1013) {
        paramFromServiceMsg = String.valueOf(1013);
      }
      String str;
      do
      {
        return paramFromServiceMsg;
        if (paramFromServiceMsg.getResultCode() != 1002) {
          break;
        }
        str = (String)paramFromServiceMsg.getAttribute("_tag_socket_connerror", "timeout_reason_UNKNOWN");
        paramFromServiceMsg = str;
      } while (!str.equals("conSucc"));
      return "timeout_reason_SERVER_NO_RESPONSE";
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    QNotificationManager localQNotificationManager = new QNotificationManager(BaseApplication.getContext());
    if (paramInt == 0)
    {
      localQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", jdField_g_of_type_Int);
      this.jdField_j_of_type_Boolean = false;
      if (this.jdField_b_of_type_JavaLangRunnable != null)
      {
        ThreadManager.remove(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      localQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", jdField_h_of_type_Int);
      this.jdField_k_of_type_Boolean = false;
    } while (this.jdField_a_of_type_JavaLangRunnable == null);
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  private void b(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "sendHCTopicMessageInner");
    }
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null)
    {
      l1 = 0L;
      HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramMessageRecord.frienduin);
      oidb_0xa89.ReqBody localReqBody = new oidb_0xa89.ReqBody();
      localReqBody.bytes_msg_body.set(ByteStringMicro.copyFrom(paramPbSendMsgReq.toByteArray()));
      localReqBody.bytes_poid.set(ByteStringMicro.copyFrom(localHotChatInfo.uuid.getBytes()));
      paramBusinessObserver = a("OidbSvc.0xa89", 2697, 1, localReqBody.toByteArray(), paramLong, paramBusinessObserver, false);
      paramBusinessObserver.extraData.putString("uin", paramMessageRecord.frienduin);
      paramBusinessObserver.extraData.putLong("msgsize", l1);
      paramBusinessObserver.extraData.putLong("uniseq", paramMessageRecord.uniseq);
      paramBusinessObserver.extraData.putLong("timeOut", paramLong);
      paramBusinessObserver.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
      paramBusinessObserver.extraData.putLong("startTime", l2);
      paramBusinessObserver.extraData.putInt("retryIndex", paramInt);
      paramBusinessObserver.extraData.putInt("uintype", paramMessageRecord.istroop);
      paramBusinessObserver.extraData.putInt("msgtype", paramMessageRecord.msgtype);
      paramBusinessObserver.extraData.putString("groupuin", paramMessageRecord.frienduin);
      if (MsgProxyUtils.o(paramMessageRecord.msgtype)) {
        paramBusinessObserver.extraData.putBoolean("RichNotify", true);
      }
      paramBusinessObserver.extraData.putInt("ROUNTING_TYPE", 21);
      paramBusinessObserver.extraData.putInt("send_msg_req_size", paramBusinessObserver.getWupBuffer().length);
      paramBusinessObserver.extraData.putLong("msg_request_time", paramMessageRecord.time);
      paramBusinessObserver.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
      paramBusinessObserver.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
      paramBusinessObserver.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
      paramBusinessObserver.addAttribute("retryIndex", Integer.valueOf(paramInt));
      if (paramMessageRecord.frienduin != null) {
        break label460;
      }
      paramPbSendMsgReq = "";
      label395:
      paramBusinessObserver.addAttribute("uin", paramPbSendMsgReq);
      if (paramMessageRecord.senderuin != null) {
        break label468;
      }
    }
    label460:
    label468:
    for (paramMessageRecord = "";; paramMessageRecord = paramMessageRecord.senderuin)
    {
      paramBusinessObserver.addAttribute("fromUin", paramMessageRecord);
      paramBusinessObserver.addAttribute("normal_msg", Boolean.valueOf(true));
      c(paramBusinessObserver);
      return;
      l1 = paramMessageRecord.msg.getBytes().length;
      break;
      paramPbSendMsgReq = paramMessageRecord.frienduin;
      break label395;
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request success!");
      }
      a(4004, true, null);
      return;
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request timeout!");
      }
      a(4004, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request error!");
    }
    a(4004, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq)
  {
    if (paramSvcResponsePullGroupMsgSeq == null)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i2 = paramToServiceMsg.extraData.getInt("doSome", 0);
    boolean bool = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---handleGetPullTroopMsgNumResp msgStruct.cReplyCode: ").append(paramSvcResponsePullGroupMsgSeq.cReplyCode).append(",isUsedRegisterProxy: ").append(bool).append(",doSome: ").append(i2);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (paramSvcResponsePullGroupMsgSeq.cReplyCode != 0)
    {
      o(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.t = 0;
    ArrayList localArrayList = new ArrayList();
    if (bool) {}
    for (HashMap localHashMap1 = new HashMap(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a());; localHashMap1 = null)
    {
      PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
      HashMap localHashMap2 = new HashMap();
      int i1 = 0;
      if (i1 < paramSvcResponsePullGroupMsgSeq.vGroupInfo.size())
      {
        Object localObject1 = (GroupInfo)paramSvcResponsePullGroupMsgSeq.vGroupInfo.get(i1);
        String str = String.valueOf(((GroupInfo)localObject1).lGroupCode);
        if (((GroupInfo)localObject1).lRedPackTime > 0L) {
          localHashMap2.put(str, String.valueOf(((GroupInfo)localObject1).lRedPackTime));
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str);
        long l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(str);
        long l1;
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          l1 = ((Long)localObject2[0]).longValue();
          label294:
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("handleGetPullTroopMsgNumResp getGroupMsgMemberSeq groupUin=").append(((GroupInfo)localObject1).lGroupCode).append(" memberseq=").append(((GroupInfo)localObject1).lMemberSeq).append(" groupSeq=").append(((GroupInfo)localObject1).lGroupSeq).append(" lMask=").append(((GroupInfo)localObject1).lMask).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l2);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          }
          if (!bool) {
            break label686;
          }
          if (((((GroupInfo)localObject1).lMask != 2L) && (((GroupInfo)localObject1).lMask != 3L)) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d())) {
            break label560;
          }
          h(str);
          label446:
          if (localHashMap1 != null) {
            localHashMap1.remove(str);
          }
          if (((GroupInfo)localObject1).lMask != 0L)
          {
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            }
            localObject2 = new Setting();
            ((Setting)localObject2).Path = ("message.group.policy." + str);
            ((Setting)localObject2).Value = String.valueOf(((GroupInfo)localObject1).lMask);
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          l1 = 0L;
          break label294;
          label560:
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(str, new Object[] { Long.valueOf(((GroupInfo)localObject1).lMemberSeq), Long.valueOf(((GroupInfo)localObject1).lGroupSeq) });
          if (((GroupInfo)localObject1).lGroupSeq <= l2)
          {
            h(str);
            if (l1 >= ((GroupInfo)localObject1).lMemberSeq) {
              break label446;
            }
            if (jdField_d_of_type_Boolean)
            {
              a(4, paramToServiceMsg, paramFromServiceMsg, localObject1);
              break label446;
            }
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1, ((GroupInfo)localObject1).lMemberSeq);
            break label446;
          }
          if (l1 >= ((GroupInfo)localObject1).lMemberSeq) {
            break label446;
          }
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str, 1);
          break label446;
          label686:
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(str, new Object[] { Long.valueOf(((GroupInfo)localObject1).lMemberSeq), Long.valueOf(((GroupInfo)localObject1).lGroupSeq) });
          if (l1 < ((GroupInfo)localObject1).lMemberSeq) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(((GroupInfo)localObject1).lGroupCode), 1, ((GroupInfo)localObject1).lMemberSeq);
          }
          l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str, 1);
          localObject1 = a(str, 1, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str), this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str), l1, ((GroupInfo)localObject1).lGroupSeq);
          int i3 = (int)(((Long)((Pair)localObject1).second).longValue() - ((Long)((Pair)localObject1).first).longValue());
          l1 = ((Long)((Pair)localObject1).first).longValue();
          l2 = ((Long)((Pair)localObject1).second).longValue();
          l1 = l2 - (1L + l1);
          if (l1 > 10) {}
          for (l1 = l2 - 10 + 1L;; l1 = l2 - l1)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder.setLength(0);
              localStringBuilder.append("---------handleGetPullTroopMsgNumResp troopUin: ").append(str).append(" msg count: ").append(i3);
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            if (i3 > 0) {
              break label966;
            }
            ((TroopMessageProcessor)a("troop_processor")).a(str, null, i2);
            break;
          }
          label966:
          localArrayList.add(str);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              a(str, l1, l2, false, null, i2);
            }
          }
          else
          {
            a(4003, true, paramToServiceMsg.extraData.getStringArray("array_groupuin"));
          }
        }
      }
      localPasswdRedBagManager.a(localHashMap2);
      if (!bool) {
        break;
      }
      if ((localHashMap1 != null) && (!localHashMap1.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp  RegisterProxyTroopSeq FailedTroopSize=" + localHashMap1.size());
        }
        paramToServiceMsg = localHashMap1.keySet().iterator();
        while (paramToServiceMsg.hasNext()) {
          h((String)paramToServiceMsg.next());
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b()) {
        break;
      }
      a(4003, true, arrayOfString);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    int i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (i1 == 1) {
      c(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
    }
    do
    {
      return;
      if ((i1 == 3) || (i1 == 14) || (i1 == 22))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
        return;
      }
    } while (i1 != 6);
    f(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
  }
  
  private void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(ProcessorDispatcher.a(paramString)).b(ProcessorDispatcher.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 3001;
    case 1: 
      return 3002;
    case 3000: 
      return 3008;
    case 1000: 
      return 6000;
    case 1004: 
      return 8002;
    case 1005: 
      return 7000;
    case 1006: 
      return 8005;
    case 1009: 
      return 8006;
    case 1023: 
      return 8008;
    case 1024: 
      return 8010;
    case 1010: 
      return 8012;
    }
    return 3013;
  }
  
  public static void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    HashMap localHashMap = new HashMap();
    long l2 = 0L;
    long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    int i1;
    if ((l3 == 10L) || (l3 == 34L))
    {
      i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (paramFromServiceMsg != null) {
        break label339;
      }
      paramFromServiceMsg = "0";
    }
    label329:
    label339:
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("send_msg_req_size", 0);
      localHashMap.put("pm_peer_uin", paramFromServiceMsg);
      localHashMap.put("pm_route_type", String.valueOf(i1));
      localHashMap.put("pm_req_size", String.valueOf(i2));
      localHashMap.put("pm_srv_reply", String.valueOf(l3));
      long l1 = l2;
      if (i1 != 13)
      {
        l1 = l2;
        if (i1 != 9)
        {
          l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
          l2 = System.currentTimeMillis();
          if (l1 >= 1L) {
            break label329;
          }
        }
      }
      for (l1 = 0L;; l1 = l2 - l1)
      {
        int i3 = paramToServiceMsg.extraData.getInt("msgtype");
        int i4 = MessageProtoCodec.a(i1);
        localHashMap.put("pm_msg_type", String.valueOf(i3));
        localHashMap.put("pm_uin_type", String.valueOf(i4));
        paramToServiceMsg = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        StatisticCollector.a(BaseApplication.getContext()).a(paramToServiceMsg.getCurrentAccountUin(), "sendMsgTooLargeErrorTag", false, l1, i2, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, duration:%dms, peerUin:%s, replyCode:%d, routingType:%s, msgReqSize:%d", new Object[] { "sendMsgTooLargeErrorTag", Long.valueOf(l1), paramFromServiceMsg, Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(i2) }));
        }
        return;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    while (paramToServiceMsg.extraData.getByte("binaryPic", (byte)0).byteValue() == 1) {
      return;
    }
    String str = "actSendC2CProcess";
    long l1 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    if (((Boolean)paramToServiceMsg.getAttribute("is_gold_msg", Boolean.valueOf(false))).booleanValue()) {
      str = "actSendC2CGoldmsgProcess";
    }
    a(str, paramBoolean, l1, paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(AppShareIDUtil.a(((Long)paramArrayList.next()).longValue()));
    }
    a(localArrayList);
  }
  
  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 7: 
    case 9: 
    case 13: 
    default: 
      return 3001;
    case 3: 
      return 6000;
    case 5: 
      return 8002;
    case 6: 
      return 7000;
    case 8: 
      return 7001;
    case 10: 
      return 8005;
    case 11: 
      return 8006;
    case 2: 
      return 3002;
    case 4: 
      return 3008;
    case 14: 
      return 6009;
    case 12: 
      return 6010;
    case 23: 
      return 8028;
    case 26: 
    case 27: 
      return 8035;
    case 25: 
      return 8032;
    case 16: 
      return 6012;
    case 17: 
      return 6013;
    case 18: 
      return 8008;
    case 15: 
      return 8010;
    case 19: 
      return 8012;
    case 20: 
      return 8014;
    case 21: 
      return 3013;
    case 22: 
      return 3014;
    }
    return 3020;
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    c();
    if (this.jdField_f_of_type_Int < 6)
    {
      a(paramToServiceMsg.extraData.getBoolean("isPullRoamMsg"), paramToServiceMsg.extraData.getInt("pullMsgType"));
      this.jdField_f_of_type_Int += 1;
      return;
    }
    e(paramToServiceMsg);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.r < 2)
    {
      a(paramToServiceMsg);
      this.r += 1;
      return;
    }
    b(5002, false, null);
    this.r = 0;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int i1;
    long l1;
    do
    {
      return;
      i1 = paramToServiceMsg.extraData.getInt("msgtype", -1);
      l1 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    } while (i1 != -1000);
    a("actSendGroupProcess", paramBoolean, l1, paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void d(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1, 2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------handleTroopMsgResponseFinishedAndNotify troopUin: " + paramString1 + ", funcName:" + paramString2);
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString1);
      paramString2 = ((ArrayList)localObject).iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 2)) {
          a("troop_processor").a(1001, (Object[])localObject);
        }
      }
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (paramString1 != null) {
      ((TroopMessageProcessor)a("troop_processor")).a(paramString1);
    }
  }
  
  private boolean d()
  {
    synchronized (this.jdField_b_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handlePAMsgGetting: " + this.jdField_i_of_type_Boolean);
      }
      if (!this.jdField_i_of_type_Boolean)
      {
        c(true);
        return false;
      }
      return true;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg)
  {
    c();
    this.jdField_f_of_type_Int = 0;
    b(false);
    int i1 = paramToServiceMsg.extraData.getInt("pullMsgType");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetBuddyMessageError ,pullMsgType:" + i1);
    }
    switch (i1)
    {
    default: 
      return;
    case 0: 
      a(4001, false, null);
      a(4016, false, null);
      return;
    case 1: 
      a(4001, false, null);
      return;
    }
    a(4016, false, null);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    b(paramToServiceMsg, 3012, false, null);
  }
  
  private void e(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      h(true);
      a((byte)1, null, 0, false, false, false, (String)paramFromServiceMsg.getAttribute("sso_push_timestamp"), 0, paramObject);
      return;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramFromServiceMsg.getResultCode() + "");
    long l2 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    long l4 = paramToServiceMsg.extraData.getLong("startTime");
    long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (l4 < 1L) {}
    for (;;)
    {
      localHashMap.put("param_retryIndex", Long.toString(l3));
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dim.actSendGrpTmpMsg", paramBoolean, l1, l2, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "TAG[" + "dim.actSendGrpTmpMsg" + "]  success[" + paramBoolean + "] duration[" + l1 + "ms] retryNum[" + l3 + "]");
      return;
      l1 = System.currentTimeMillis() - l4;
    }
  }
  
  private void e(String paramString)
  {
    ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramString);
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
    if ((this.jdField_e_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        return true;
      }
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label116;
        }
        if (!((zhc)localIterator.next()).jdField_a_of_type_Boolean) {
          continue;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "hasFirstGroupMsg flag =" + bool);
        }
        if (!bool)
        {
          this.jdField_e_of_type_Boolean = false;
          return true;
        }
      }
      return false;
      label116:
      boolean bool = false;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i3 = paramToServiceMsg.extraData.getInt("msgtype");
    int i4 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex");
    int i2 = MessageProtoCodec.a(i4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendC2CMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l1 + " msgSeq:" + l2 + " msgType:" + i3 + " uinType:" + i2 + " routingType:" + i4 + " retryIndex:" + i1);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l2);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label279;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label279;
      }
    }
    label279:
    while ((480000L != l3) && (!((SendMessageHandler)localObject).a())) {
      return;
    }
    i3 = d(i4);
    localObject = new Object[6];
    localObject[0] = str;
    localObject[1] = Integer.valueOf(i2);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(l3);
    localObject[5] = Long.valueOf(l1);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    b(i3, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = i1;
      ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { localObject });
      a(str, i2, l1, false);
    }
    b(paramToServiceMsg, paramFromServiceMsg, false);
    a(l2);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB.");
    }
    Object localObject2 = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    long l4 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l1 = paramToServiceMsg.extraData.getLong("timeOut");
    int i5 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    int i6 = paramToServiceMsg.extraData.getInt("msgtype");
    int i7 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i2 = MessageProtoCodec.a(i7);
    if (i2 == 1024) {
      i2 = paramToServiceMsg.extraData.getInt("uintype", i2);
    }
    label634:
    for (;;)
    {
      if (MsgProxyUtils.a(i2) == 1032) {}
      boolean bool1;
      label509:
      for (int i3 = paramToServiceMsg.extraData.getInt("key_confess_topicid", 0);; i3 = 0)
      {
        bool1 = paramToServiceMsg.extraData.getBoolean("RichNotify", false);
        Object localObject1 = new msg_svc.PbSendMsgResp();
        try
        {
          localObject1 = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
          paramObject = localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i1;
            StringBuilder localStringBuilder;
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : invalid.", localException);
              localStringBuilder = new StringBuilder().append("<---handleSendC2CMessageResp_PB : data:");
              if (paramObject != null) {
                break label509;
              }
            }
            for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
            {
              QLog.e("Q.msg.MessageHandler", 2, paramObject);
              paramObject = new msg_svc.PbSendMsgResp();
              break;
            }
            if (paramObject.result.get() != 0)
            {
              i1 = paramObject.result.get();
              continue;
              int i4;
              if (i1 == 255)
              {
                i4 = 1;
                if (i4 != 0)
                {
                  localStringBuilder.getClass();
                  if (a(localStringBuilder, "server")) {
                    continue;
                  }
                }
                if (((i2 != 10002) && (i2 != 1001)) || (!NearbyUtils.a(i1))) {
                  break label1945;
                }
                if (i1 == 48)
                {
                  if (i2 != 10002) {
                    break label1420;
                  }
                  i4 = 1;
                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().i(str, null);
                  NearbyUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, i4);
                }
                ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_sig_expire", 0, 0, str, String.valueOf(i2), String.valueOf(i1), "");
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandlerQ.nearby.nearby_sig", 2, "handleSendC2CMessageResp_PB, 部落、附近的人临时会话因为签名失败, uinType:" + i2 + "|replyCode:" + i1);
                }
                i1 = 0;
              }
              for (;;)
              {
                if ((i1 == 0) || (i1 == 241))
                {
                  boolean bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i2, l3);
                  paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool2);
                  if (paramObject.send_time.has())
                  {
                    l1 = paramObject.send_time.get() & 0xFFFFFFFF;
                    a(str, i2, l3, l1);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB updateSendMsgTime: sendBuddyPb: respData.uSendTime:" + l1 + ",peerUin:" + str);
                    }
                  }
                  localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l3);
                  if ((localObject2 instanceof RecommendCommonMessage))
                  {
                    if ((paramObject.text_analysis_result.has()) && (paramObject.text_analysis_result.get() == 1))
                    {
                      paramObject = "1";
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB text_analysis_result=" + paramObject);
                      }
                      ((MessageRecord)localObject2).saveExtInfoToExtStr("ark_text_analysis_flag", paramObject);
                    }
                  }
                  else
                  {
                    long l5 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
                    if ((l5 <= 0L) || (i2 != 0)) {
                      break label1446;
                    }
                    l1 = 0L;
                    long l2 = l1;
                    if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
                    {
                      l2 = l1;
                      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
                      {
                        l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                        l1 = l2;
                        if (l2 < 0L) {
                          l1 = 0L;
                        }
                        l2 = l1;
                        if (l1 > 2147483647L) {
                          l2 = 0L;
                        }
                      }
                    }
                    paramObject = new MessageHandler.MsgSendCostParams();
                    paramObject.jdField_c_of_type_Long = l2;
                    paramObject.d = System.currentTimeMillis();
                    paramObject.jdField_b_of_type_Long = (paramObject.d - l5);
                    paramObject.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
                    paramObject.jdField_a_of_type_Int = 0;
                    paramObject.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
                    paramObject.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
                    paramObject.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
                    if (((Boolean)paramToServiceMsg.getAttribute("is_gold_msg", Boolean.valueOf(false))).booleanValue()) {
                      paramObject.jdField_a_of_type_JavaLangString = "actSendC2CGoldmsgProcess";
                    }
                    a(6003, true, new Object[] { str, l3 + "", paramObject });
                  }
                  for (;;)
                  {
                    if (bool1)
                    {
                      paramObject = new MessageObserver.StatictisInfo();
                      paramObject.jdField_c_of_type_Int = (i5 + 1);
                      b(paramToServiceMsg, 5006, true, new Object[] { paramObject });
                      a(str, i2, l3, true);
                    }
                    b(paramToServiceMsg, paramFromServiceMsg, true);
                    a(l4);
                    if ((i2 == 1025) || (i2 == 1024))
                    {
                      l1 = localStringBuilder.a(System.currentTimeMillis());
                      ((QidianHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str, l1);
                    }
                    ((LongTextMsgManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).a(str, i2, l3, i1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
                    VideoReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i6, str, i2, l3);
                    return;
                    i4 = 0;
                    break;
                    i4 = 0;
                    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().h(str, null);
                    break label634;
                    paramObject = "0";
                    break label906;
                    if (MsgProxyUtils.a(i2) == 1032) {
                      a(8035, true, new Object[] { str, Integer.valueOf(i2), Long.valueOf(l3), Integer.valueOf(i3) });
                    } else {
                      a(6003, true, new String[] { str, l3 + "" });
                    }
                  }
                }
                a(paramObject, str, i2, i1);
                if ((i1 == 10) || (i1 == 34))
                {
                  paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l3);
                  if (a(paramFromServiceMsg, a(paramToServiceMsg)))
                  {
                    a(l4);
                    return;
                  }
                  if ((paramFromServiceMsg instanceof MessageForArkApp))
                  {
                    a(l4);
                    ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkApp)paramFromServiceMsg, false);
                    return;
                  }
                  if (!(paramFromServiceMsg instanceof MessageForArkBabyqReply)) {
                    break;
                  }
                  a(l4);
                  ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkBabyqReply)paramFromServiceMsg, false);
                  return;
                }
                i4 = d(i7);
                localObject2 = new Object[8];
                localObject2[0] = str;
                localObject2[1] = Integer.valueOf(i2);
                localObject2[2] = Integer.valueOf(i1);
                localObject2[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
                localObject2[4] = Long.valueOf(l1);
                localObject2[5] = Long.valueOf(l3);
                if (paramObject.errmsg.has()) {}
                for (paramObject = paramObject.errmsg.get();; paramObject = "")
                {
                  localObject2[6] = paramObject;
                  a((Object[])localObject2, paramFromServiceMsg.getUin(), i1);
                  if (MsgProxyUtils.a(i2) == 1032) {
                    localObject2[7] = Integer.valueOf(i3);
                  }
                  b(i4, true, localObject2);
                  if (bool1)
                  {
                    paramObject = new MessageObserver.StatictisInfo();
                    paramObject.jdField_b_of_type_Int = 2900;
                    paramObject.jdField_a_of_type_Long = i1;
                    paramObject.jdField_c_of_type_Int = (i5 + 1);
                    paramObject.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
                    paramObject.jdField_d_of_type_Int = 1;
                    b(paramToServiceMsg, 5006, false, new Object[] { paramObject });
                    a(str, i2, l3, false);
                  }
                  b(paramToServiceMsg, paramFromServiceMsg, true);
                  a(l4);
                  c(paramToServiceMsg, paramFromServiceMsg);
                  if ((i2 != 1025) && (i2 != 1024)) {
                    break;
                  }
                  l1 = localStringBuilder.a(System.currentTimeMillis());
                  ((QidianHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str, i1, l1);
                  break;
                }
              }
            }
            else
            {
              i1 = 0;
            }
          }
        }
        if ((paramObject == null) || (!paramObject.result.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : server did not return a valid result code, use 4 instead.");
          }
          i1 = 4;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + (String)localObject2 + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + " peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l4 + " msgType:" + i6 + " uinType:" + i2 + " routingType:" + i7);
          }
          paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
          b(paramToServiceMsg, paramFromServiceMsg);
          localObject1 = a(l4);
          if (localObject1 != null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + (String)localObject2 + ",no SendMessageHandler found.");
          }
        }
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramFromServiceMsg.getResultCode() + "");
    long l2 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    long l4 = paramToServiceMsg.extraData.getLong("startTime");
    long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (l4 < 1L) {}
    for (;;)
    {
      localHashMap.put("param_retryIndex", Long.toString(l3));
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dim.actSendWpaMsg", paramBoolean, l1, l2, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "TAG[" + "dim.actSendWpaMsg" + "]  success[" + paramBoolean + "] duration[" + l1 + "ms] retryNum[" + l3 + "]");
      return;
      l1 = System.currentTimeMillis() - l4;
    }
  }
  
  private void f(String paramString)
  {
    ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(paramString);
  }
  
  private boolean f()
  {
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_ArrayOfZhb != null) && (this.jdField_a_of_type_ArrayOfZhb.length > 1)) {
          break label77;
        }
        return true;
        if (i1 >= this.jdField_a_of_type_ArrayOfZhb.length) {
          break label73;
        }
        if ((this.jdField_a_of_type_ArrayOfZhb[i1] != null) && (this.jdField_a_of_type_ArrayOfZhb[i1].b())) {
          return false;
        }
      }
      i1 += 1;
      continue;
      label73:
      return true;
      label77:
      int i1 = 1;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int i1 = paramToServiceMsg.extraData.getInt("msgtype");
    int i2 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i3 = paramToServiceMsg.extraData.getInt("retryIndex");
    int i4 = MessageProtoCodec.a(i2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendGrpMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i1 + " uinType:" + i4 + " routingType:" + i2 + " retryIndex:" + i3);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label279;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label279;
      }
    }
    label279:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).a())) {
      return;
    }
    localObject = new Object[6];
    localObject[0] = paramToServiceMsg.extraData.getString("groupuin");
    localObject[1] = Integer.valueOf(1);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject[5] = Long.valueOf(l3);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    b(3002, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = i1;
      ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { localObject });
    }
    d(paramToServiceMsg, paramFromServiceMsg, false);
    a(l1);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendTroopMessageRespPB enter");
    }
    String str = paramToServiceMsg.extraData.getString("groupuin");
    int i3 = paramToServiceMsg.extraData.getInt("msgtype");
    Object localObject3 = paramToServiceMsg.getServiceCmd();
    Object localObject1 = new msg_svc.PbSendMsgResp();
    Object localObject4;
    try
    {
      localObject1 = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("<---handleSendTroopMessageRespPB:");
          if (paramObject != null) {
            break label322;
          }
        }
        for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
        {
          QLog.e("Q.msg.MessageHandler", 2, paramObject, localException);
          paramObject = null;
          break;
        }
        if (paramObject.result.get() != 0) {
          i1 = paramObject.result.get();
        }
      }
    }
    int i1 = 0;
    long l3;
    long l4;
    if ((paramObject == null) || (!paramObject.result.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB:server did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
      paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
      b(paramToServiceMsg, paramFromServiceMsg);
      l3 = paramToServiceMsg.extraData.getLong("msgSeq");
      l4 = paramToServiceMsg.extraData.getLong("uniseq");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendTroopMessageRespPB: ---cmd:" + (String)localObject3 + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",SendTroopMessageResp : peerUin:" + str + ",uniseq:" + l4 + ",msgSeq:" + l3);
      }
      localObject1 = a(l3);
      if (localObject1 != null) {
        break label358;
      }
    }
    label268:
    label322:
    label358:
    int i2;
    label369:
    do
    {
      return;
      if (i1 != 255) {
        break label1109;
      }
      i2 = 1;
      if (i2 == 0) {
        break;
      }
      localException.getClass();
    } while (a(localException, "server"));
    localObject3 = new Object[7];
    localObject3[0] = str;
    localObject3[1] = Integer.valueOf(1);
    localObject3[2] = Integer.valueOf(i1);
    localObject3[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject3[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject3[5] = Long.valueOf(l4);
    Object localObject2;
    label472:
    boolean bool1;
    if (paramObject != null)
    {
      localObject2 = paramObject.errmsg.get();
      localObject3[6] = localObject2;
      bool1 = false;
      localObject2 = ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(str);
      if (localObject2 == null) {
        break label1204;
      }
      if ((i1 != 108) && (i1 != 102)) {
        break label1193;
      }
      if (localObject2 == null) {
        break label1123;
      }
      HotChatHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (HotChatInfo)localObject2);
      bool1 = false;
      label537:
      i2 = MessageProtoCodec.a(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"));
      if (!bool1) {
        break label1398;
      }
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l4);
      if ((localObject2 instanceof RecommendCommonMessage))
      {
        if ((!paramObject.text_analysis_result.has()) || (paramObject.text_analysis_result.get() != 1)) {
          break label1355;
        }
        paramObject = "1";
        label608:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB text_analysis_result=" + paramObject);
        }
        ((MessageRecord)localObject2).saveExtInfoToExtStr("ark_text_analysis_flag", paramObject);
      }
      boolean bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg.extraData.getString("groupuin"), 1, l4);
      paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool2);
      long l5 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
      if (l5 <= 0L) {
        break label1362;
      }
      long l1 = 0L;
      long l2 = l1;
      if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
      {
        l2 = l1;
        if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
        {
          l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          l2 = l1;
          if (l1 > 2147483647L) {
            l2 = 0L;
          }
        }
      }
      paramObject = new MessageHandler.MsgSendCostParams();
      paramObject.jdField_c_of_type_Long = l2;
      paramObject.d = System.currentTimeMillis();
      paramObject.jdField_b_of_type_Long = (paramObject.d - l5);
      paramObject.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
      paramObject.jdField_a_of_type_Int = 1;
      paramObject.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
      paramObject.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      paramObject.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
      a(6003, true, new Object[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(l4), paramObject });
      label951:
      if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
      {
        i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
        paramObject = new MessageObserver.StatictisInfo();
        if (!bool1) {
          break label1528;
        }
        paramObject.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
        paramObject.jdField_c_of_type_Int = (i2 + 1);
      }
    }
    for (;;)
    {
      paramObject.jdField_d_of_type_Int = 1;
      b(paramToServiceMsg, 5006, bool1, new Object[] { paramObject });
      d(paramToServiceMsg, paramFromServiceMsg, true);
      a(l3);
      c(paramToServiceMsg, paramFromServiceMsg);
      ((LongTextMsgManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).a(paramToServiceMsg.extraData.getString("groupuin"), 1, l4, i1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
      VideoReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i3, str, 1, l4);
      return;
      label1109:
      i2 = 0;
      break label369;
      localObject2 = "";
      break label472;
      label1123:
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject4 = ((RecentUserProxy)localObject2).a(str, 1);
      if (localObject4 != null) {
        ((RecentUserProxy)localObject2).b((RecentUser)localObject4);
      }
      b(1002, true, localObject3);
      b(2001, true, localObject3);
      b(2002, true, localObject3);
      bool1 = false;
      break label537;
      label1193:
      if (i1 != 0) {
        break label537;
      }
      bool1 = true;
      break label537;
      switch (i1)
      {
      default: 
        bool1 = false;
        break;
      case 0: 
      case 241: 
        bool1 = true;
        break;
      case 101: 
      case 102: 
      case 103: 
        label1204:
        ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str);
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        localObject4 = ((RecentUserProxy)localObject2).a(str, 1);
        if (localObject4 != null) {
          ((RecentUserProxy)localObject2).b((RecentUser)localObject4);
        }
        b(1002, true, localObject3);
        b(2001, true, localObject3);
        b(2002, true, localObject3);
        bool1 = false;
        break;
        label1355:
        paramObject = "0";
        break label608;
        label1362:
        a(6003, true, new String[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(l4) });
        break label951;
        label1398:
        if ((i1 == 10) || (i1 == 34))
        {
          paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l4);
          if (a(paramFromServiceMsg, a(paramToServiceMsg)))
          {
            a(l3);
            return;
          }
          if ((paramFromServiceMsg instanceof MessageForArkApp))
          {
            a(l3);
            ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkApp)paramFromServiceMsg, false);
            return;
          }
          if (!(paramFromServiceMsg instanceof MessageForArkBabyqReply)) {
            break label268;
          }
          a(l3);
          ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkBabyqReply)paramFromServiceMsg, false);
          return;
        }
        a((Object[])localObject3, paramFromServiceMsg.getUin(), i1);
        b(3002, false, localObject3);
        break label951;
        label1528:
        paramObject.jdField_b_of_type_Int = 2900;
        paramObject.jdField_a_of_type_Long = i1;
        paramObject.jdField_c_of_type_Int = (i2 + 1);
        paramObject.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      }
    }
  }
  
  private void g(String paramString)
  {
    e(paramString, "closeDisOnlineMsgCache");
  }
  
  private boolean g()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList == null) {
      return true;
    }
    for (;;)
    {
      try
      {
        synchronized (this.jdField_c_of_type_JavaUtilArrayList)
        {
          if (this.jdField_c_of_type_JavaUtilArrayList.size() == 0)
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        return true;
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg = l3 + "";
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    b(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(0), null, Long.valueOf(l4), Long.valueOf(l2) });
    if ((480000L == l4) && (a(l1) != null)) {
      a(l1);
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new msg_onlinepush.PbPushMsg();
    try
    {
      paramToServiceMsg = (msg_onlinepush.PbPushMsg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null) {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.msg.has())) {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("<---handleMessagePush_PB: pushMsg is null or doesn't has msg:");
          if (paramToServiceMsg == null)
          {
            paramToServiceMsg = " null ";
            QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg);
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: exception occurs while parsing the pb bytes.", paramToServiceMsg);
        }
        paramToServiceMsg = null;
        continue;
        paramToServiceMsg = "noMsg";
      }
      paramObject = (msg_comm.Msg)paramToServiceMsg.msg.get();
      int i1 = ((msg_comm.MsgHead)paramObject.msg_head.get()).msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: msgType:" + i1);
      }
      if ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        a("c2c_processor").a(2003, new Object[] { paramObject, paramFromServiceMsg, paramToServiceMsg });
        return;
      }
      switch (i1)
      {
      default: 
        return;
      }
    }
    a("disc_processor").a(1001, new Object[] { paramObject, paramFromServiceMsg, paramToServiceMsg, Boolean.valueOf(true) });
    return;
    a("troop_processor").a(1001, new Object[] { paramObject, paramFromServiceMsg });
    return;
    a("c2c_processor").a(1001, new Object[] { paramObject, paramFromServiceMsg, paramToServiceMsg });
  }
  
  private void h(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    d(paramString, "closeTroopOnlineMsgCache");
  }
  
  private void h(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int i1 = paramToServiceMsg.extraData.getInt("msgtype");
    int i2 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i3 = paramToServiceMsg.extraData.getInt("retryIndex");
    int i4 = MessageProtoCodec.a(i2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendDisMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i1 + " uinType:" + i4 + " routingType:" + i2 + " retryIndex:" + i3);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label279;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label279;
      }
    }
    label279:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).a())) {
      return;
    }
    localObject = new Object[6];
    localObject[0] = paramToServiceMsg.extraData.getString("uToUin");
    localObject[1] = Integer.valueOf(3000);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject[5] = Long.valueOf(l3);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    b(3008, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = i1;
      ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { localObject });
    }
    a(paramToServiceMsg, paramFromServiceMsg, false);
    a(l1);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (RespClientMsg)paramObject;
    if (paramObject == null) {
      h(paramToServiceMsg, paramFromServiceMsg);
    }
    paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    a(l1);
    if (paramObject.stHeader.eReplyCode == 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramToServiceMsg.extraData.getLong("to")), 1001, l2);
      a(6003, true, new String[] { String.valueOf(paramToServiceMsg.extraData.getLong("to")), l2 + "" });
      return;
    }
    int i1 = paramObject.stHeader.eReplyCode;
    paramToServiceMsg = l3 + "";
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    b(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(i1), null, Long.valueOf(l4), Long.valueOf(l2) });
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleTimeOut serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (ProcessorDispatcher.a().containsKey(str)) {
      b(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      int i1;
      do
      {
        return;
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
        {
          d(paramToServiceMsg);
          return;
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          e(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(str))
        {
          d(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (!"MessageSvc.PbSendMsg".equalsIgnoreCase(str)) {
          break;
        }
        i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
        if ((i1 == 1) || (i1 == 3) || (i1 == 25) || (i1 == 14) || (i1 == 5) || (i1 == 6) || (i1 == 10) || (i1 == 11) || (i1 == 12) || (i1 == 23) || (i1 == 26) || (i1 == 27) || (i1 == 8) || (i1 == 16) || (i1 == 17) || (i1 == 18) || (i1 == 15) || (i1 == 19) || (i1 == 20) || (i1 == 22) || (i1 == 24))
        {
          f(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 9)
        {
          a().b(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 13)
        {
          a().c(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 4)
        {
          i(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while (i1 != 2);
      g(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("OidbSvc.0xa89".equalsIgnoreCase(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str))
      {
        if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action"))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<<---handle timeout - get thirdqq unread number");
          }
          a().a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        p(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("RegPrxySvc.infoLogin".equalsIgnoreCase(str)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str)))
      {
        a(paramFromServiceMsg, null);
        return;
      }
      if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        b(paramFromServiceMsg, null);
        return;
      }
    } while (!"MessageSvc.PbReceiptRead".equalsIgnoreCase(str));
    v(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendDiscussionMsgRespPB enter");
    }
    if (paramObject == null) {}
    for (;;)
    {
      return;
      Object localObject1 = new msg_svc.PbSendMsgResp();
      try
      {
        localObject1 = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
        paramObject = localObject1;
        i1 = 0;
        if ((paramObject == null) || (!paramObject.result.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB did not return a valid result code, use 4 instead.");
          }
          i1 = 4;
          paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
          b(paramToServiceMsg, paramFromServiceMsg);
          l3 = paramToServiceMsg.extraData.getLong("uniseq");
          l4 = paramToServiceMsg.extraData.getLong("msgSeq");
          int i3 = paramToServiceMsg.extraData.getInt("msgtype");
          localObject1 = paramToServiceMsg.extraData.getString("uToUin");
          localObject2 = paramToServiceMsg.getServiceCmd();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendDiscussionMsgRespPB: ---cmd:" + (String)localObject2 + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + "SendDiscussionMsgResp : peerUin:" + (String)localObject1 + ",uniseq:" + l3 + ",msgSeq:" + l4);
          }
          localObject2 = a(l4);
          if (localObject2 == null) {
            continue;
          }
          if (i1 != 255) {
            break label1048;
          }
          i2 = 1;
          if (i2 != 0)
          {
            localObject2.getClass();
            if (a((SendMessageHandler)localObject2, "server")) {
              continue;
            }
          }
          switch (i1)
          {
          default: 
            bool1 = false;
            i2 = MessageProtoCodec.a(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"));
            if (bool1)
            {
              localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1, i2, l3);
              if ((localObject2 instanceof RecommendCommonMessage))
              {
                if ((paramObject.text_analysis_result.has()) && (paramObject.text_analysis_result.get() == 1))
                {
                  paramObject = "1";
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB text_analysis_result=" + paramObject);
                  }
                  ((MessageRecord)localObject2).saveExtInfoToExtStr("ark_text_analysis_flag", paramObject);
                }
              }
              else
              {
                boolean bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg.extraData.getString("uToUin"), 3000, l3);
                paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool2);
                long l5 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
                if (l5 <= 0L) {
                  break label1073;
                }
                long l1 = 0L;
                long l2 = l1;
                if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
                {
                  l2 = l1;
                  if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
                  {
                    l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                    l1 = l2;
                    if (l2 < 0L) {
                      l1 = 0L;
                    }
                    l2 = l1;
                    if (l1 > 2147483647L) {
                      l2 = 0L;
                    }
                  }
                }
                paramObject = new MessageHandler.MsgSendCostParams();
                paramObject.jdField_c_of_type_Long = l2;
                paramObject.d = System.currentTimeMillis();
                paramObject.jdField_b_of_type_Long = (paramObject.d - l5);
                paramObject.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
                paramObject.jdField_a_of_type_Int = 3000;
                paramObject.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
                paramObject.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
                paramObject.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
                a(6003, true, new Object[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(l3), paramObject });
                if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
                {
                  i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
                  paramObject = new MessageObserver.StatictisInfo();
                  if (!bool1) {
                    break label1378;
                  }
                  paramObject.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
                  paramObject.jdField_c_of_type_Int = (i2 + 1);
                  paramObject.jdField_d_of_type_Int = 1;
                  b(paramToServiceMsg, 5006, bool1, new Object[] { paramObject });
                }
                a(paramToServiceMsg, paramFromServiceMsg, true);
                a(l4);
                c(paramToServiceMsg, paramFromServiceMsg);
                ((LongTextMsgManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).a(paramToServiceMsg.extraData.getString("uToUin"), 3000, l3, i1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
                VideoReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i3, (String)localObject1, 3000, l3);
                return;
              }
            }
            break;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1;
          long l3;
          long l4;
          Object localObject2;
          int i2;
          boolean bool1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("<---handleSendDiscussionMsgRespPB:");
            if (paramObject != null) {
              break label1012;
            }
          }
          label1012:
          for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
          {
            QLog.e("Q.msg.MessageHandler", 2, paramObject, localException);
            paramObject = null;
            break;
          }
          if (paramObject.result.get() != 0)
          {
            i1 = paramObject.result.get();
            continue;
            label1048:
            i2 = 0;
            continue;
            bool1 = true;
            continue;
            bool1 = false;
            continue;
            paramObject = "0";
            continue;
            label1073:
            a(6003, true, new String[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(l3) });
            continue;
            if ((i1 == 10) || (i1 == 34))
            {
              paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localException, i2, l3);
              if (a(paramFromServiceMsg, a(paramToServiceMsg)))
              {
                a(l4);
                return;
              }
              if ((paramFromServiceMsg instanceof MessageForArkApp))
              {
                a(l4);
                ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkApp)paramFromServiceMsg, false);
                return;
              }
              if (!(paramFromServiceMsg instanceof MessageForArkBabyqReply)) {
                break;
              }
              a(l4);
              ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkBabyqReply)paramFromServiceMsg, false);
              return;
            }
            localObject2 = paramToServiceMsg.extraData;
            Object[] arrayOfObject = new Object[6];
            arrayOfObject[0] = ((Bundle)localObject2).getString("uToUin");
            arrayOfObject[1] = Integer.valueOf(3000);
            arrayOfObject[2] = Integer.valueOf(i1);
            arrayOfObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
            arrayOfObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
            arrayOfObject[5] = Long.valueOf(l3);
            a(arrayOfObject, paramFromServiceMsg.getUin(), i1);
            b(3008, false, arrayOfObject);
            if ((paramObject.errmsg.has()) && (paramObject.errmsg.get() != null) && (QLog.isColorLevel()))
            {
              QLog.d("Q.msg.MessageHandler", 2, "send dicussion msg failed: " + paramObject.errmsg.get());
              continue;
              label1378:
              paramObject.jdField_b_of_type_Int = 2900;
              paramObject.jdField_c_of_type_Int = (i2 + 1);
              paramObject.jdField_a_of_type_Long = i1;
              paramObject.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
            }
          }
        }
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    b(1005, false, null);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 0;
    int i4 = 0;
    cmd0x9db.RspBody localRspBody = new cmd0x9db.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    long l2 = 0L;
    int i3 = -1;
    if (localRspBody.int32_result.has()) {
      i3 = localRspBody.int32_result.get();
    }
    long l1;
    if ((i1 == 0) && (i3 == 0))
    {
      i2 = 1;
      i1 = 1;
      l1 = l2;
      if (localRspBody.rpt_uint64_uin.has())
      {
        paramFromServiceMsg = localRspBody.rpt_uint64_uin.get();
        l1 = l2;
        if (paramFromServiceMsg.size() > 0) {
          l1 = ((Long)paramFromServiceMsg.get(0)).longValue();
        }
      }
      l2 = l1;
      if (!localRspBody.uint32_sequence.has()) {
        break label386;
      }
      i4 = localRspBody.uint32_sequence.get();
      paramFromServiceMsg = null;
      i2 = i1;
      i1 = i4;
    }
    for (;;)
    {
      i4 = paramToServiceMsg.extraData.getInt("fromType");
      if ((i2 != 0) && (l1 > 0L))
      {
        e(Long.toString(l1));
        l2 = paramToServiceMsg.extraData.getLong("insertTinnyid");
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleInsertBlackList success, tinnyid:" + l2);
        }
        a(8017, true, new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Long.toString(l1), Integer.valueOf(i1) });
        return;
        if (localRspBody.str_errormessage.has())
        {
          paramFromServiceMsg = localRspBody.str_errormessage.get();
          i1 = 0;
          l1 = 0L;
          i2 = i4;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleInsertBlackList failed :" + paramFromServiceMsg + " code:" + i3);
        }
        a(8017, false, new Object[] { Integer.valueOf(i4), Integer.valueOf(i3), paramFromServiceMsg });
        return;
      }
      label386:
      i1 = 0;
      paramFromServiceMsg = null;
      l1 = l2;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    b(1005, false, null);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i1 = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 ret=" + i1);
          }
          if ((i1 == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.a(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool = true;
      }
    }
    for (;;)
    {
      paramToServiceMsg.extraData.getBoolean("key_subscribe_nearby_assistant_switch", true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 suc=" + bool);
      return;
      bool = false;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    b(1003, false, null);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber ERROR isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramObject = (SvcResponsePullDisMsgSeq)paramObject;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber is null");
      }
      r(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i1 = paramObject.cReplyCode;
    Object localObject = paramObject.strResult;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetDiscussionMsgNum resp.cReplyCode: " + i1);
    }
    if (i1 != 0)
    {
      r(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = paramObject.vConfNumInfo;
    paramToServiceMsg = this.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetDiscussionMsgNum add cache " + paramObject.size());
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
      int i2 = paramToServiceMsg.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramObject = paramToServiceMsg[i1];
        if (!paramFromServiceMsg.contains(paramObject))
        {
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject, 2);
          if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject) != null) {
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(paramObject);
          }
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramToServiceMsg);
    v();
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    b(1003, false, null);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    String str = (String)???.getAttribute("_tag_LOGSTR");
    msg_svc.PbGetDiscussMsgResp localPbGetDiscussMsgResp1 = new msg_svc.PbGetDiscussMsgResp();
    msg_svc.PbGetDiscussMsgResp localPbGetDiscussMsgResp2;
    boolean bool1;
    boolean bool2;
    long l1;
    try
    {
      localPbGetDiscussMsgResp1 = (msg_svc.PbGetDiscussMsgResp)localPbGetDiscussMsgResp1.mergeFrom((byte[])paramObject);
      if (localPbGetDiscussMsgResp1 == null)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
        s(paramToServiceMsg, ???);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "Exception occurs while parsing the byte array.");
        }
        localPbGetDiscussMsgResp2 = null;
      }
      bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      new ArrayList();
      boolean bool3 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
      l1 = paramToServiceMsg.extraData.getLong("lDisUin", localPbGetDiscussMsgResp2.discuss_uin.get());
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("handleGetPullDiscussionMsgResp_PB res.cReplyCode = ").append(localPbGetDiscussMsgResp2.result.get()).append(" discussUin: ").append(l1).append(" isRefreshHead: ").append(bool3).append(", dataHash=").append(paramObject.hashCode()).append(" rtnBeginSeq:").append(localPbGetDiscussMsgResp2.return_begin_seq.get()).append(" rtnEndSeq:").append(localPbGetDiscussMsgResp2.return_end_seq.get());
        if (localPbGetDiscussMsgResp2.msg.get() == null) {
          break label358;
        }
        ???.append(" msgSize:").append(localPbGetDiscussMsgResp2.msg.get().size());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, ???.toString());
        }
        synchronized (a(String.valueOf(l1), 3000))
        {
          if (!a(paramToServiceMsg, localPbGetDiscussMsgResp2)) {
            break;
          }
          return;
        }
        label358:
        ???.append(" msg:null.");
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(localPbGetDiscussMsgResp2.discuss_uin.get());
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(l1), localPbGetDiscussMsgResp2.discuss_info_seq.get(), localPbGetDiscussMsgResp2.last_get_time.get());
      if (!bool3) {}
    }
    for (;;)
    {
      try
      {
        a("disc_processor").a(1003, new Object[] { paramToServiceMsg, paramObject, localPbGetDiscussMsgResp2, str });
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(localPbGetDiscussMsgResp2.discuss_uin.get());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp refreshDiscussionHead exception ! ", paramToServiceMsg);
        continue;
      }
      for (;;)
      {
        try
        {
          a("disc_processor").a(1002, new Object[] { paramToServiceMsg, paramObject, localPbGetDiscussMsgResp2 });
          if (!bool2) {
            continue;
          }
          this.m += 1;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(String.valueOf(l1), 2);
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp initGetPullDiscussionMsg exception ! ", paramToServiceMsg);
          if (!bool2) {
            continue;
          }
          this.m += 1;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(String.valueOf(l1), 2);
          continue;
          e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
          continue;
        }
        finally
        {
          if (!bool2) {
            continue;
          }
          this.m += 1;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(String.valueOf(l1), 2);
          throw paramToServiceMsg;
          e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
          continue;
        }
        if ((!bool1) || (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c())) {
          break label721;
        }
        MsgAutoMonitorUtil.a().i();
        a(4002, true, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
        break;
        e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
      }
      label721:
      if ((bool2) && (this.jdField_c_of_type_Int != 0) && (this.m >= this.jdField_c_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN , discussionNum:" + this.jdField_c_of_type_Int + " , recvDiscNum:" + this.m);
        }
        MsgAutoMonitorUtil.a().i();
        a(4002, true, null);
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 0;
    if (paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      paramToServiceMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
    for (;;)
    {
      this.t = 0;
      a(4003, false, paramToServiceMsg);
      label44:
      if ((paramToServiceMsg != null) && (i1 < paramToServiceMsg.length)) {
        try
        {
          d(paramToServiceMsg[i1], "handleGetPullTroopMsgNumError");
          i1 += 1;
          break label44;
          paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("array_groupuin");
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumError exception ! ", paramFromServiceMsg);
            }
          }
        }
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyC2CMsgResp.");
    }
    if (jdField_d_of_type_Boolean)
    {
      a(1, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.t < 3)
    {
      paramFromServiceMsg = new msg_svc.PbUnReadMsgSeqReq();
      try
      {
        msg_svc.PbUnReadMsgSeqReq localPbUnReadMsgSeqReq = (msg_svc.PbUnReadMsgSeqReq)paramFromServiceMsg.mergeFrom((byte[])paramToServiceMsg.getWupBuffer());
        paramFromServiceMsg = localPbUnReadMsgSeqReq;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleGetPullTroopMsgNumTimeOut : decode pb:", localException);
          }
        }
        this.t += 1;
        return;
      }
      paramFromServiceMsg = ((msg_svc.PbPullGroupMsgSeqReq)paramFromServiceMsg.group_unread_info.get()).group_info_req.get().iterator();
      while (paramFromServiceMsg.hasNext()) {
        c(String.valueOf(((msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq)paramFromServiceMsg.next()).group_code.get()), paramToServiceMsg.extraData.getInt("doSome"));
      }
    }
    o(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
    }
    if (jdField_d_of_type_Boolean)
    {
      a(2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    r(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("groupuin");
    if (bool1)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.putBoolean("success", false);
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg, 1, null, null, paramToServiceMsg);
      return;
    }
    try
    {
      d(paramFromServiceMsg, "handleGetPullTroopMsgError");
      if (bool2) {
        if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          a(4003, false, new String[] { paramFromServiceMsg });
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError exception ! ", paramToServiceMsg);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g();
      return;
    }
    a(4003, false, new String[] { paramFromServiceMsg });
  }
  
  private void q(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RegisterPushNotice)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd ERROR");
      }
      return;
    }
    paramFromServiceMsg = (RegisterPushNotice)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, new Object[] { "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd endseq=" + paramFromServiceMsg.uEndSeq + ",timeoutflag=" + paramFromServiceMsg.ulTimeOutFlag, ", uInterval_forbid_pulldown=", Long.valueOf(paramFromServiceMsg.uInterval_forbid_pulldown) });
    }
    ((NowEnterManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a(paramFromServiceMsg.uInterval_forbid_pulldown);
    long l1;
    if (paramFromServiceMsg.uEndSeq == this.jdField_i_of_type_Int)
    {
      l1 = 0L;
      this.jdField_a_of_type_AndroidUtilPair = new Pair(paramFromServiceMsg, Long.valueOf(0L));
    }
    for (;;)
    {
      if ((this.jdField_k_of_type_Int != 0) && (paramFromServiceMsg.uEndSeq == this.jdField_k_of_type_Int))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(false);
        this.jdField_k_of_type_Int = 0;
      }
      if (((!f()) || (!g())) && (jdField_d_of_type_Boolean)) {
        break;
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (this.jdField_a_of_type_AndroidUtilPair != null)
        {
          this.jdField_a_of_type_AndroidUtilPair = null;
          if ((l1 == 1L) || (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c()) || (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b()))
          {
            k();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyEndResp RegPrxySvc.NoticeEnd notify");
            }
            a(4013, true, new Long[] { Long.valueOf(paramFromServiceMsg.ulTimeOutFlag), Long.valueOf(l1) });
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        }
        return;
      }
      if (paramFromServiceMsg.uEndSeq != this.jdField_j_of_type_Int) {
        break;
      }
      this.jdField_a_of_type_AndroidUtilPair = new Pair(paramFromServiceMsg, Long.valueOf(1L));
      l1 = 1L;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumError isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramToServiceMsg = this.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i1;
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder().append("handleGetPullDiscussionMsgNumError size = ");
      if (paramToServiceMsg != null) {
        break label123;
      }
      i1 = 0;
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, i1);
      if (paramToServiceMsg == null) {
        break label165;
      }
      int i2 = paramToServiceMsg.length;
      i1 = 0;
      label98:
      if (i1 < i2)
      {
        paramFromServiceMsg = paramToServiceMsg[i1];
        try
        {
          e(paramFromServiceMsg, "handleGetPullDiscussionMsgNumError");
          i1 += 1;
          break label98;
          label123:
          i1 = paramToServiceMsg.length;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumError exception ! ", paramFromServiceMsg);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramToServiceMsg);
    v();
    label165:
    a(4002, false, null);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyTroopMsgResp_PB return by null data");
    }
    label213:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
      }
      Object localObject1;
      if ((paramObject instanceof register_proxy.SvcResponsePbPullGroupMsgProxy)) {
        localObject1 = (register_proxy.SvcResponsePbPullGroupMsgProxy)paramObject;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label213;
        }
        try
        {
          localObject1 = ((register_proxy.SvcResponsePbPullGroupMsgProxy)localObject1).msg_content.get().toByteArray();
          int i1 = localObject1.length - 4;
          byte[] arrayOfByte = new byte[i1];
          PkgTools.a(arrayOfByte, 0, (byte[])localObject1, 4, i1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB. dataHash=" + paramObject.hashCode() + ", newDataHash=" + arrayOfByte.hashCode());
          }
          a(paramToServiceMsg, paramFromServiceMsg, arrayOfByte, true);
          return;
        }
        catch (Exception paramToServiceMsg) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode pb:", paramToServiceMsg);
        return;
        localObject1 = new register_proxy.SvcResponsePbPullGroupMsgProxy();
        try
        {
          localObject1 = (register_proxy.SvcResponsePbPullGroupMsgProxy)((register_proxy.SvcResponsePbPullGroupMsgProxy)localObject1).mergeFrom((byte[])paramObject);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode SvcResponsePbPullGroupMsgProxy:", localException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("lDisUin"));
    if (bool)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.putBoolean("success", false);
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFromServiceMsg), 3000, null, null, paramToServiceMsg);
      return;
    }
    paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    try
    {
      e(String.valueOf(paramFromServiceMsg), "handleGetPullDiscussionMsgError");
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c())
      {
        a(4002, false, null);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgError exception ! ", paramToServiceMsg);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h();
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB.");
    }
    if (jdField_d_of_type_Boolean)
    {
      a(3, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    t(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void t()
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.jdField_j_of_type_Boolean = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject2 = ((Context)localObject1).getString(2131436674);
    String str = ((Context)localObject1).getString(2131436674);
    Bitmap localBitmap = BitmapManager.a(((Context)localObject1).getResources(), 2130841588);
    QNotificationManager localQNotificationManager = new QNotificationManager((Context)localObject1);
    localObject2 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
    if (localBitmap != null) {
      ((NotificationCompat.Builder)localObject2).setLargeIcon(localBitmap);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(2130841588);
      }
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION"), 0));
      localObject1 = ((NotificationCompat.Builder)localObject2).build();
      if (localQNotificationManager == null) {
        break;
      }
      localQNotificationManager.cancel("Q.msg.MessageHandler_PcOnlineNotifition", jdField_g_of_type_Int);
      BadgeUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, (Notification)localObject1);
      localQNotificationManager.notify("Q.msg.MessageHandler_PcOnlineNotifition", jdField_g_of_type_Int, (Notification)localObject1);
      this.jdField_b_of_type_JavaLangRunnable = new zgz(this, localQNotificationManager);
      ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
      return;
      ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapManager.a(((Context)localObject1).getResources(), 2130841588));
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label98;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>handleMsgReadedReportError_PB: reqSeq " + l1);
      }
      paramToServiceMsg.getClass();
      if (!a(paramToServiceMsg, "msf")) {
        break label98;
      }
    }
    label98:
    while ((480000L != l2) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>handleMsgReadedReportError_PB, all retry: reqSeq " + l1);
    }
    a(l1);
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyDiscussMsgResp_PB return by null data");
    }
    label197:
    for (;;)
    {
      return;
      Object localObject1;
      if ((paramObject instanceof register_proxy.SvcPbResponsePullDisMsgProxy)) {
        localObject1 = (register_proxy.SvcPbResponsePullDisMsgProxy)paramObject;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label197;
        }
        try
        {
          localObject1 = ((register_proxy.SvcPbResponsePullDisMsgProxy)localObject1).msg_content.get().toByteArray();
          int i1 = localObject1.length - 4;
          byte[] arrayOfByte = new byte[i1];
          PkgTools.a(arrayOfByte, 0, (byte[])localObject1, 4, i1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB. dataHash=" + paramObject.hashCode() + ", newDataHash=" + arrayOfByte.hashCode());
          }
          n(paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
          return;
        }
        catch (Exception paramToServiceMsg) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode pb:", paramToServiceMsg);
        return;
        localObject1 = new register_proxy.SvcPbResponsePullDisMsgProxy();
        try
        {
          localObject1 = (register_proxy.SvcPbResponsePullDisMsgProxy)((register_proxy.SvcPbResponsePullDisMsgProxy)localObject1).mergeFrom((byte[])paramObject);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode SvcPbResponsePullDisMsgProxy:", localException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.jdField_k_of_type_Boolean = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject2 = ((Context)localObject1).getString(2131436675);
    String str = ((Context)localObject1).getString(2131436675);
    Bitmap localBitmap = BitmapManager.a(((Context)localObject1).getResources(), 2130841586);
    QNotificationManager localQNotificationManager = new QNotificationManager((Context)localObject1);
    localObject2 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
    if (localBitmap != null) {
      ((NotificationCompat.Builder)localObject2).setLargeIcon(localBitmap);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(2130841586);
      }
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION"), 0));
      localObject1 = ((NotificationCompat.Builder)localObject2).build();
      if (localQNotificationManager == null) {
        break;
      }
      localQNotificationManager.cancel("Q.msg.MessageHandler_IpadOnlineNotifition", jdField_h_of_type_Int);
      localQNotificationManager.notify("Q.msg.MessageHandler_IpadOnlineNotifition", jdField_h_of_type_Int, (Notification)localObject1);
      this.jdField_a_of_type_JavaLangRunnable = new zgm(this, localQNotificationManager);
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
      return;
      ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapManager.a(((Context)localObject1).getResources(), 2130841586));
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageError");
    }
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    b(paramToServiceMsg, paramFromServiceMsg);
    Object localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label99;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label99;
      }
    }
    label99:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).a())) {
      return;
    }
    localObject = new Object[6];
    localObject[0] = paramToServiceMsg.extraData.getString("groupuin");
    localObject[1] = Integer.valueOf(1026);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject[5] = Long.valueOf(l3);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    b(3013, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = i1;
      ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { localObject });
    }
    a(l1);
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    Object localObject1;
    do
    {
      for (;;)
      {
        return;
        localObject1 = new msg_svc.PbUnReadMsgSeqResp();
        try
        {
          paramObject = (msg_svc.PbUnReadMsgSeqResp)((msg_svc.PbUnReadMsgSeqResp)localObject1).mergeFrom((byte[])paramObject);
          if ((paramObject.group_unread_info.has()) && (paramObject.group_unread_info.get() != null)) {
            break label89;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return group_unread_info");
            return;
          }
        }
        catch (Exception paramToServiceMsg) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return a valid response");
    return;
    label89:
    paramObject = (msg_svc.PbPullGroupMsgSeqResp)paramObject.group_unread_info.get();
    if (paramObject.result.get() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: " + paramObject.result.get() + " ,groupMsgSeqResp.errmsg: " + paramObject.errmsg.get());
      }
      o(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i2 = paramToServiceMsg.extraData.getInt("doSome", 0);
    paramToServiceMsg = new StringBuilder();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg.append("<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: ").append(paramObject.result.get()).append(" ,doSome: ").append(i2);
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
    }
    this.t = 0;
    int i1 = 0;
    label245:
    long l2;
    long l1;
    label336:
    boolean bool;
    label367:
    long l3;
    if (i1 < paramObject.group_info_resp.get().size())
    {
      localObject1 = (msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)paramObject.group_info_resp.get().get(i1);
      paramFromServiceMsg = String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get());
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramFromServiceMsg);
      l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(paramFromServiceMsg);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label853;
      }
      l1 = ((Long)localObject2[0]).longValue();
      localObject2 = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if ((localObject2 == null) || (!((HotChatManager)localObject2).b(paramFromServiceMsg))) {
        break label859;
      }
      bool = true;
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramFromServiceMsg, new Object[] { Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()), Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get()) });
        if (l1 < ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get()), 1, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get());
        }
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg.setLength(0);
        paramToServiceMsg.append("handleGetPullTroopMsgNumResp_PB getGroupMsgMemberSeq groupUin=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get()).append(" ,memberseq=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()).append(" ,groupSeq=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get()).append(" ,localMemberMsgSeq=").append(l1).append(" ,localLastSeq=").append(l2).append(", isHotChat=").append(bool);
        QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
      }
      l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramFromServiceMsg, 1);
      localObject1 = a(paramFromServiceMsg, 1, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramFromServiceMsg), this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramFromServiceMsg), l2, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get());
      int i3 = (int)(((Long)((Pair)localObject1).second).longValue() - ((Long)((Pair)localObject1).first).longValue());
      l2 = ((Long)((Pair)localObject1).first).longValue();
      l3 = ((Long)((Pair)localObject1).second).longValue();
      l2 = l3 - (l2 + 1L);
      if (l2 <= 10) {
        break label865;
      }
      l2 = l3 - 10 + 1L;
      label688:
      if (QLog.isColorLevel())
      {
        paramToServiceMsg.setLength(0);
        paramToServiceMsg.append("---------handleGetPullTroopMsgNumResp_PB troopUin: ").append(paramFromServiceMsg).append(" ,msg count: ").append(i3);
        QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
      }
      if ((i3 <= 0) && (i2 == 8))
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.joinSplitMsg", 2, "handleGetPullTroopMsgNumResp_PB doSome=" + i2 + "  beginSeq:" + (l1 - 10L) + " endSeq:" + l1);
        }
        a(paramFromServiceMsg, l1 - 10L, l1, false, null, i2);
      }
      if (i3 > 0) {
        break label875;
      }
      ((TroopMessageProcessor)a("troop_processor")).a(paramFromServiceMsg, null, i2);
    }
    for (;;)
    {
      i1 += 1;
      break label245;
      break;
      label853:
      l1 = 0L;
      break label336;
      label859:
      bool = false;
      break label367;
      label865:
      l2 = l3 - l2;
      break label688;
      label875:
      a(paramFromServiceMsg, l2, l3, false, null, i2);
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a())
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      localStringBuilder = null;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo size = " + ((List)localObject2).size());
        }
        localStringBuilder = new StringBuilder();
        localObject1 = new HashMap(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c());
        localObject2 = ((List)localObject2).iterator();
        label392:
        label415:
        label436:
        while (((Iterator)localObject2).hasNext())
        {
          localstConfNumInfo = (stConfNumInfo)((Iterator)localObject2).next();
          if (localstConfNumInfo != null)
          {
            str = String.valueOf(localstConfNumInfo.lConfUin);
            arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str);
            l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(str);
            if ((arrayOfObject != null) && (arrayOfObject.length > 0))
            {
              l1 = ((Long)arrayOfObject[0]).longValue();
              label211:
              if (QLog.isColorLevel())
              {
                localStringBuilder.setLength(0);
                localStringBuilder.append("addDisMsgMemberSeq uin = ").append(localstConfNumInfo.lConfUin).append(" memberseq = ").append(localstConfNumInfo.uMemberMsgSeq).append(" confMsgSeq =").append(localstConfNumInfo.uConfMsgSeq).append(" localLastSeq =").append(l2);
                QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
              }
              this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(String.valueOf(localstConfNumInfo.lConfUin), new Object[] { Long.valueOf(localstConfNumInfo.uMemberMsgSeq), Long.valueOf(localstConfNumInfo.uConfMsgSeq) });
              if (localstConfNumInfo.uConfMsgSeq > l2) {
                break label415;
              }
              g(str);
              if (l1 < localstConfNumInfo.uMemberMsgSeq)
              {
                if (!jdField_d_of_type_Boolean) {
                  break label392;
                }
                a(5, null, null, localstConfNumInfo);
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label436;
              }
              ((HashMap)localObject1).remove(str);
              break;
              l1 = 0L;
              break label211;
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 3000, localstConfNumInfo.uMemberMsgSeq);
              continue;
              if (l1 < localstConfNumInfo.uMemberMsgSeq) {
                this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str, 1);
              }
            }
          }
        }
      }
      while ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish  RegisterProxyDiscSeq FailedDiscSize=" + ((HashMap)localObject1).size());
        }
        localObject1 = ((HashMap)localObject1).keySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          g((String)((Iterator)localObject1).next());
        }
        localObject1 = localStringBuilder;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo is null ! ");
          localObject1 = localStringBuilder;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c()) {
        a(4002, true, null);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      Object localObject1;
      stConfNumInfo localstConfNumInfo;
      String str;
      Object[] arrayOfObject;
      long l2;
      long l1;
      return;
    }
    QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumber waitting ... ");
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    int i1 = paramToServiceMsg.extraData.getInt("msgtype");
    int i2 = paramToServiceMsg.extraData.getInt("retryIndex");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><E><---handleC2CReceiptMessageError: ---cmd:MessageSvc.PbReceiptRead ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " msgseq::" + l1 + " msgType:" + i1 + " retryIndex:" + i2 + " resultCode:" + paramFromServiceMsg.getResultCode() + " timeout:" + l2);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label218;
      }
      paramToServiceMsg.getClass();
      if (!a(paramToServiceMsg, "msf")) {
        break label218;
      }
    }
    label218:
    while (!paramToServiceMsg.a()) {
      return;
    }
    b(3021, false, new Long[] { Long.valueOf(i1), Long.valueOf(l1), Long.valueOf(paramFromServiceMsg.getResultCode()) });
    a(l1);
  }
  
  private void v(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg begin!");
    }
    long l3 = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    Object localObject2 = new register_proxy.SvcRegisterProxyMsgResp();
    try
    {
      paramObject = (register_proxy.SvcRegisterProxyMsgResp)((register_proxy.SvcRegisterProxyMsgResp)localObject2).mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg package error!");
        }
        a(4004, false, null);
        return;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleNewRegisterProxyMsg : decode SvcRegisterProxyMsgResp pb:", paramObject);
        }
        paramObject = null;
        continue;
        if ((paramObject.seq.has()) && (paramObject.seq.get() != this.jdField_i_of_type_Int) && (paramObject.seq.get() != this.jdField_j_of_type_Int))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          ((StringBuilder)localObject1).setLength(0);
          ((StringBuilder)localObject1).append("handleNewRegisterProxyMsg endSeq wrong! seq=").append(paramObject.seq.get()).append(" registerProxyEndSeq=").append(this.jdField_i_of_type_Int).append(" registerProxyEndSeq_numTroop=").append(this.jdField_j_of_type_Int);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
          return;
        }
        int i1 = paramObject.result.get();
        if (QLog.isColorLevel())
        {
          ((StringBuilder)localObject1).setLength(0);
          ((StringBuilder)localObject1).append("handleNewRegisterProxyMsg resultCode=").append(i1);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
        }
        if (i1 != 0)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_FailCode", String.valueOf(i1));
          StatisticCollector.a(BaseApplication.getContext()).a(null, "prxyRegFailCode", true, 0L, 0L, (HashMap)localObject2, null);
        }
        int i2;
        switch (i1)
        {
        default: 
          return;
        case 0: 
          this.n += 1;
          if ((paramObject.flag.has()) && (paramObject.flag.get() != 0))
          {
            i2 = paramObject.flag.get();
            if (QLog.isColorLevel())
            {
              ((StringBuilder)localObject1).setLength(0);
              ((StringBuilder)localObject1).append("handleNewRegisterProxyMsg flag=").append(i2);
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
            if (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache == null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
              MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache = new MessageCache.RegPrxyCache();
            }
            if (paramObject.msg_info.has())
            {
              this.jdField_b_of_type_Int = ((register_proxy.SvcResponseMsgInfo)paramObject.msg_info.get()).group_num.get();
              this.jdField_c_of_type_Int = ((register_proxy.SvcResponseMsgInfo)paramObject.msg_info.get()).discuss_num.get();
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg ,groupNum=" + this.jdField_b_of_type_Int + ",discussionNum=" + this.jdField_c_of_type_Int);
              }
              if ((this.jdField_b_of_type_Int == 0) || (this.jdField_l_of_type_Int >= this.jdField_b_of_type_Int)) {
                a(4003, true, null);
              }
              if ((this.jdField_c_of_type_Int == 0) || (this.m >= this.jdField_c_of_type_Int)) {
                a(4002, true, null);
              }
            }
            if (!paramObject.c2c_msg.has()) {
              break;
            }
          }
          break;
        }
        try
        {
          localObject2 = paramObject.c2c_msg.get().toByteArray();
          i1 = localObject2.length - 4;
          localObject4 = new byte[i1];
          PkgTools.a((byte[])localObject4, 0, (byte[])localObject2, 4, i1);
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode c2c_msg , hashCode:" + localObject4.hashCode());
          }
          a(1, ???, paramFromServiceMsg, localObject4);
          if (!paramObject.pub_account_msg.has()) {}
        }
        catch (Exception localException1)
        {
          try
          {
            do
            {
              localObject2 = paramObject.pub_account_msg.get().toByteArray();
              i1 = localObject2.length - 4;
              localObject4 = new byte[i1];
              PkgTools.a((byte[])localObject4, 0, (byte[])localObject2, 4, i1);
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode pub_account_msg , hashCode:" + localObject4.hashCode());
              }
              a(1, ???, paramFromServiceMsg, localObject4);
              if (!paramObject.group_list.has()) {
                break label1637;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleTroopList!");
              }
              localObject2 = (TroopBindPublicAccountMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
              localObject4 = paramObject.group_list.get();
              this.jdField_a_of_type_JavaUtilList = ((List)localObject4);
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
              MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList = ((List)localObject4);
              i1 = 0;
              for (;;)
              {
                if (i1 >= ((List)localObject4).size()) {
                  break label1637;
                }
                localObject5 = (register_proxy.GroupList)((List)localObject4).get(i1);
                if (localObject5 != null) {
                  break;
                }
                i1 += 1;
              }
              a(4001, false, null);
              a(4016, false, null);
              a(4003, false, null);
              a(4002, false, null);
              return;
              RegisterProxy.jdField_d_of_type_Int |= 0x1;
              i1 = new Random().nextInt(3000);
              ThreadManager.getSubThreadHandler().postDelayed(new zgp(this), i1);
              return;
              jdField_b_of_type_Boolean = false;
              BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", false).commit();
              a(4004, false, null);
              return;
              b(false);
              a(true, 1);
              break;
              c(false);
              a(true, 2);
              break;
              b(false);
              a(true, 0);
              break;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg-->flag error!");
              }
              a(4004, false, null);
              return;
              localException1 = localException1;
            } while (!QLog.isColorLevel());
            QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode c2c_msg error:", localException1);
          }
          catch (Exception localException2)
          {
            Object localObject4;
            Object localObject5;
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode pub_account_msg error:", localException2);
              }
            }
            Object localObject6 = String.valueOf(((register_proxy.GroupList)localObject5).group_code.get());
            Object localObject7 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b((String)localObject6);
            long l4 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i((String)localObject6);
            long l2 = 0L;
            long l1 = l2;
            if (localObject7 != null)
            {
              l1 = l2;
              if (localObject7.length > 0) {
                l1 = ((Long)localObject7[0]).longValue();
              }
            }
            if (QLog.isColorLevel())
            {
              ((StringBuilder)localObject1).setLength(0);
              ((StringBuilder)localObject1).append("handleNewRegisterProxyMsg getGroupList groupCode=").append(((register_proxy.GroupList)localObject5).group_code.get()).append(" groupSeq=").append(((register_proxy.GroupList)localObject5).group_seq.get()).append(" memberSeq=").append(((register_proxy.GroupList)localObject5).member_seq.get()).append(" mask=").append(((register_proxy.GroupList)localObject5).mask.get()).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l4).append(" redpack_time=").append(((register_proxy.GroupList)localObject5).redpack_time.get()).append(" hasMsg=").append(((register_proxy.GroupList)localObject5).has_msg.get());
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
            }
            if ((((register_proxy.GroupList)localObject5).mask.get() == 1L) || (((register_proxy.GroupList)localObject5).mask.get() == 4L) || ((((register_proxy.GroupList)localObject5).mask.get() == 3L) && (((String)localObject6).equals(localException2.a()))))
            {
              this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c((String)localObject6, new Object[] { Long.valueOf(((register_proxy.GroupList)localObject5).member_seq.get()), Long.valueOf(((register_proxy.GroupList)localObject5).group_seq.get()) });
              if (l1 < ((register_proxy.GroupList)localObject5).member_seq.get())
              {
                if (((register_proxy.GroupList)localObject5).group_seq.get() > l4) {
                  break label1624;
                }
                a(4, ???, paramFromServiceMsg, localObject5);
              }
            }
            while (((register_proxy.GroupList)localObject5).mask.get() != 0L)
            {
              if (this.jdField_b_of_type_JavaUtilArrayList == null) {
                this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
              }
              localObject7 = new Setting();
              ((Setting)localObject7).Path = ("message.group.policy." + (String)localObject6);
              ((Setting)localObject7).Value = String.valueOf(((register_proxy.GroupList)localObject5).mask.get());
              this.jdField_b_of_type_JavaUtilArrayList.add(localObject7);
              break;
              label1624:
              this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a((String)localObject6, 1);
            }
            label1637:
            Object localObject3;
            if (paramObject.discuss_list.has())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList!");
              }
              localObject3 = paramObject.discuss_list.get();
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
              MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b = ((List)localObject3);
              i1 = 0;
              if (i1 < ((List)localObject3).size())
              {
                localObject4 = (register_proxy.DiscussList)((List)localObject3).get(i1);
                if (localObject4 == null) {}
                for (;;)
                {
                  i1 += 1;
                  break;
                  localObject5 = String.valueOf(((register_proxy.DiscussList)localObject4).discuss_code.get());
                  localObject6 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a((String)localObject5);
                  l4 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h((String)localObject5);
                  l2 = 0L;
                  l1 = l2;
                  if (localObject6 != null)
                  {
                    l1 = l2;
                    if (localObject6.length > 0) {
                      l1 = ((Long)localObject6[0]).longValue();
                    }
                  }
                  if (QLog.isColorLevel())
                  {
                    ((StringBuilder)localObject1).setLength(0);
                    ((StringBuilder)localObject1).append("handleNewRegisterProxyMsg getDiscussList discussCode=").append(((register_proxy.DiscussList)localObject4).discuss_code.get()).append(" discussSeq=").append(((register_proxy.DiscussList)localObject4).discuss_seq.get()).append(" memberSeq=").append(((register_proxy.DiscussList)localObject4).member_seq.get()).append(" info_seq=").append(((register_proxy.DiscussList)localObject4).info_seq.get()).append(" isHotDiscuss=").append(((register_proxy.DiscussList)localObject4).bHotGroup.get()).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l4).append(" redpack_time=").append(((register_proxy.DiscussList)localObject4).redpack_time.get()).append(" hasMsg=").append(((register_proxy.DiscussList)localObject4).has_msg.get());
                    QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
                  }
                  this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b((String)localObject5, new Object[] { Long.valueOf(((register_proxy.DiscussList)localObject4).member_seq.get()), Long.valueOf(((register_proxy.DiscussList)localObject4).discuss_seq.get()) });
                  if (((register_proxy.DiscussList)localObject4).member_seq.get() > l1) {
                    if (((register_proxy.DiscussList)localObject4).discuss_seq.get() <= l4) {
                      a(5, null, null, localObject4);
                    } else {
                      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b((String)localObject5, 1);
                    }
                  }
                }
              }
            }
            else if ((!this.jdField_e_of_type_Boolean) && (this.n == 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList! noDiscussList return...");
              }
              localObject3 = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              localObject1 = (DiscussionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
              localObject3 = ((DiscussionManager)localObject3).a();
              new ArrayList();
              localObject3 = ((ArrayList)localObject3).iterator();
              i1 = 1;
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> should be deleted discussion" + i1 + ":" + ((DiscussionInfo)localObject4).uin);
                }
                ((DiscussionHandler)localObject1).a(((DiscussionInfo)localObject4).uin);
                if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(((DiscussionInfo)localObject4).uin) != null) {
                  this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(((DiscussionInfo)localObject4).uin);
                }
                i1 += 1;
              }
            }
            int i3;
            if (paramObject.gourp_msg.has())
            {
              localObject1 = paramObject.gourp_msg.get();
              i3 = ((List)localObject1).size();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleTroopMsgResp_PB, gourp_msg size:" + i3);
              }
              i1 = 0;
              if (i1 < i3)
              {
                localObject3 = (register_proxy.SvcResponsePbPullGroupMsgProxy)((List)localObject1).get(i1);
                if (this.jdField_e_of_type_Boolean) {
                  a(2, ???, paramFromServiceMsg, localObject3, false);
                }
                for (;;)
                {
                  i1 += 1;
                  break;
                  a(2, ???, paramFromServiceMsg, localObject3, true);
                }
              }
            }
            if (paramObject.discuss_msg.has())
            {
              paramObject = paramObject.discuss_msg.get();
              i3 = paramObject.size();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussMsgResp_PB, discuss_msg size:" + i3);
              }
              i1 = 0;
              if (i1 < i3)
              {
                localObject1 = (register_proxy.SvcPbResponsePullDisMsgProxy)paramObject.get(i1);
                if (this.jdField_e_of_type_Boolean) {
                  a(3, ???, paramFromServiceMsg, localObject1, false);
                }
                for (;;)
                {
                  i1 += 1;
                  break;
                  a(3, ???, paramFromServiceMsg, localObject1, true);
                }
              }
            }
            if ((i2 & 0x2) == 2)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleFirstEnding! isPullCircleStop: " + this.jdField_c_of_type_Boolean);
              }
              this.jdField_e_of_type_Boolean = true;
              if (e()) {
                a(4017, true, null);
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg curr pbSyncMsgState:" + this.n);
            }
            if ((i2 & 0x8) == 8)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleRestEnding!");
              }
              this.jdField_f_of_type_Boolean = true;
              this.n = -1;
              if ((!this.jdField_f_of_type_Boolean) || (!f()) || (!g())) {}
            }
            synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
            {
              if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
              }
              l1 = ((Long)paramFromServiceMsg.getAttribute("infoSync_timestamp")).longValue();
              ??? = a("RegPrxySvc.PbSyncMsg", null);
              ???.addAttribute("infoSync_timestamp", Long.valueOf(l1));
              ???.setMsfCommand(MsfCommand.msf_pbSyncMsg);
              a(???);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg end! cost :" + (System.currentTimeMillis() - l3));
              return;
            }
          }
        }
      }
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    if (a(l1) == null) {}
    do
    {
      return;
      paramToServiceMsg = new msg_svc.PbMsgReadedReportResp();
      try
      {
        paramToServiceMsg = (msg_svc.PbMsgReadedReportResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel())
        {
          if (paramToServiceMsg.c2c_read_report.result.has()) {
            QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>C2C replyCode:" + paramToServiceMsg.c2c_read_report.result.get() + "reqSeq:" + l1);
          }
          if ((paramToServiceMsg.dis_read_report.has()) && (((msg_svc.PbDiscussReadedReportResp)paramToServiceMsg.dis_read_report.get(0)).result.has())) {
            QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>Dis replyCode:" + ((msg_svc.PbDiscussReadedReportResp)paramToServiceMsg.dis_read_report.get(0)).result.get() + "reqSeq:" + l1);
          }
          if ((paramToServiceMsg.grp_read_report.has()) && (((msg_svc.PbGroupReadedReportResp)paramToServiceMsg.grp_read_report.get(0)).result.has())) {
            QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>GRP replyCode:" + ((msg_svc.PbGroupReadedReportResp)paramToServiceMsg.grp_read_report.get(0)).result.get() + " reqSeq:" + l1);
          }
        }
        a(l1);
        return;
      }
      catch (Exception paramToServiceMsg) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, "<ReadReport>handleMsgReadedReportResp_PB : server did not return a valid response,reqSeq " + l1);
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageRespPB enter");
    }
    String str = paramToServiceMsg.extraData.getString("groupuin");
    long l4 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l5 = paramToServiceMsg.extraData.getLong("uniseq");
    long l1 = 0L;
    Object localObject1 = null;
    try
    {
      Object localObject2 = new oidb_0xa89.RspBody();
      i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
      if (localObject2 != null)
      {
        l1 = ((oidb_0xa89.RspBody)localObject2).uint64_msg_seq.get();
        localObject1 = ((oidb_0xa89.RspBody)localObject2).bytes_poid.get().toStringUtf8();
        ((oidb_0xa89.RspBody)localObject2).bytes_msg_error_info.get().toStringUtf8();
        if (((oidb_0xa89.RspBody)localObject2).bytes_rsp_msg_body.has())
        {
          localObject2 = new msg_svc.PbSendMsgResp();
          try
          {
            paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject2).mergeFrom((byte[])paramObject);
            localObject2 = localObject1;
            localObject1 = paramObject;
            paramObject = localObject2;
          }
          catch (Exception paramObject)
          {
            for (;;)
            {
              arrayOfObject = null;
              paramObject = localObject1;
              localObject1 = arrayOfObject;
            }
          }
          paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
          b(paramToServiceMsg, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, String.format("%s, troopUin = %s, replycode=%d, msgSeq=%d, uniseq=%d, shmsgseq=%d, uuid=%s", new Object[] { "handleSendHotchatTopicMessageRespPB", str, Integer.valueOf(i1), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l1), paramObject }));
          }
          paramObject = a(l4);
          if (paramObject == null) {
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i1 = 4;
        Object[] arrayOfObject = null;
        continue;
        int i2;
        label408:
        boolean bool;
        if (i1 == 255)
        {
          i2 = 1;
          if (i2 != 0)
          {
            paramObject.getClass();
            if (a(paramObject, "server")) {
              continue;
            }
          }
          arrayOfObject = new Object[7];
          arrayOfObject[0] = str;
          arrayOfObject[1] = Integer.valueOf(1026);
          arrayOfObject[2] = Integer.valueOf(i1);
          arrayOfObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
          arrayOfObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
          arrayOfObject[5] = Long.valueOf(l5);
          if (localObject1 == null) {
            break label653;
          }
          paramObject = ((msg_svc.PbSendMsgResp)localObject1).errmsg.get();
          arrayOfObject[6] = paramObject;
          bool = false;
          if ((i1 != 108) && (i1 != 102)) {
            break label727;
          }
          paramObject = ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(str);
          if (paramObject == null) {
            break label660;
          }
          HotChatHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          bool = false;
          label464:
          if (!bool) {
            break label738;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1026, l5);
          long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
          a(6003, true, new String[] { str, String.valueOf(l5) });
          long l2 = l3;
          if (l3 == 0L) {
            l2 = MessageCache.a();
          }
          a(str, 1026, l5, l1, l2);
          label556:
          if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
          {
            i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
            paramObject = new MessageObserver.StatictisInfo();
            if (!bool) {
              break label763;
            }
            paramObject.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
            paramObject.jdField_c_of_type_Int = (i2 + 1);
          }
        }
        for (;;)
        {
          paramObject.jdField_d_of_type_Int = 1;
          b(paramToServiceMsg, 5006, bool, new Object[] { paramObject });
          a(l4);
          c(paramToServiceMsg, paramFromServiceMsg);
          return;
          i2 = 0;
          break;
          label653:
          paramObject = "";
          break label408;
          label660:
          paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          localObject1 = paramObject.a(str, 1);
          if (localObject1 != null) {
            paramObject.b((RecentUser)localObject1);
          }
          b(1002, true, arrayOfObject);
          b(2001, true, arrayOfObject);
          b(2002, true, arrayOfObject);
          bool = false;
          break label464;
          label727:
          if (i1 != 0) {
            break label464;
          }
          bool = true;
          break label464;
          label738:
          a(arrayOfObject, paramFromServiceMsg.getUin(), i1);
          b(3013, false, arrayOfObject);
          break label556;
          label763:
          paramObject.jdField_b_of_type_Int = 2900;
          paramObject.jdField_a_of_type_Long = i1;
          paramObject.jdField_c_of_type_Int = (i2 + 1);
          paramObject.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
        }
        paramObject = localObject1;
        localObject1 = null;
        continue;
        arrayOfObject = null;
        paramObject = localObject1;
        localObject1 = arrayOfObject;
      }
    }
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp.");
    }
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    int i3 = paramToServiceMsg.extraData.getInt("msgtype");
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      paramObject = localPbSendMsgResp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : invalid.", localException);
          localStringBuilder = new StringBuilder().append("<---handleC2CReceiptMessageResp : data:");
          if (paramObject != null) {
            break label317;
          }
        }
        label317:
        for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
        {
          QLog.e("Q.msg.MessageHandler", 2, paramObject);
          paramObject = new msg_svc.PbSendMsgResp();
          break;
        }
        if (paramObject.result.get() != 0) {
          i1 = paramObject.result.get();
        }
      }
    }
    int i1 = 0;
    if (!paramObject.result.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : server did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + " peerUin:" + str + " msgseq:" + l1 + " msgType:" + i3);
      }
      paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
      b(paramToServiceMsg, paramFromServiceMsg);
      paramToServiceMsg = a(l1);
      if (paramToServiceMsg != null) {
        break label353;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead,no SendMessageHandler found.");
      }
    }
    label353:
    int i2;
    do
    {
      return;
      StringBuilder localStringBuilder;
      if (i1 != 255) {
        break label440;
      }
      i2 = 1;
      if (i2 == 0) {
        break;
      }
      paramToServiceMsg.getClass();
    } while (a(paramToServiceMsg, "server"));
    if ((i1 == 0) || (i1 == 241)) {
      if (i3 == 1) {
        b(6015, true, new Long[] { Long.valueOf(i3), Long.valueOf(l1) });
      }
    }
    for (;;)
    {
      a(l1);
      return;
      label440:
      i2 = 0;
      break;
      b(6015, true, new Long[] { Long.valueOf(i3), Long.valueOf(l1), Long.valueOf(paramObject.receipt_resp.receipt_info.uint64_read_time.get()) });
      continue;
      b(3021, true, new Long[] { Long.valueOf(i3), Long.valueOf(l1), Long.valueOf(i1) });
    }
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow.");
    }
    long l1 = paramToServiceMsg.extraData.getLong("toUin");
    paramToServiceMsg = new oidb_0xb31.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i1 == 0)
    {
      if (!paramToServiceMsg.items.has()) {
        break label480;
      }
      paramToServiceMsg = paramToServiceMsg.items.get();
      if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
        break label462;
      }
      paramToServiceMsg = (oidb_0xb31.SimilarItem)paramToServiceMsg.get(0);
      if (paramToServiceMsg == null) {
        break label444;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new JSONObject();
        if (paramToServiceMsg.icon_url.has()) {
          paramFromServiceMsg.put("icon_url", paramToServiceMsg.icon_url.get());
        }
        if (paramToServiceMsg.jump_url.has()) {
          paramFromServiceMsg.put("jump_url", paramToServiceMsg.jump_url.get());
        }
        if (paramToServiceMsg.name.has()) {
          paramFromServiceMsg.put("name", paramToServiceMsg.name.get());
        }
        if (paramToServiceMsg.sub_title.has()) {
          paramFromServiceMsg.put("sub_title", paramToServiceMsg.sub_title.get());
        }
        if (paramToServiceMsg.title.has()) {
          paramFromServiceMsg.put("title", paramToServiceMsg.title.get());
        }
        if (paramToServiceMsg.type.has()) {
          paramFromServiceMsg.put("type", paramToServiceMsg.type.get());
        }
        if (paramToServiceMsg.url.has()) {
          paramFromServiceMsg.put("url", paramToServiceMsg.url.get());
        }
        if (paramToServiceMsg.show_both_head.has()) {
          paramFromServiceMsg.put("show_both_head", paramToServiceMsg.show_both_head.get());
        }
        paramFromServiceMsg.put("friend_uin", l1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow content is: " + paramFromServiceMsg.toString());
        }
        ((NewFriendManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(33)).a(paramFromServiceMsg.toString(), String.valueOf(l1));
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow exception: " + QLog.getStackTraceString(paramToServiceMsg));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow. result is: " + i1);
      }
      return;
      label444:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow index == 0 item is null.");
        continue;
        label462:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items is empty.");
          continue;
          label480:
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items not has.");
          }
        }
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int i1 = a(localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = a(1, paramLong1, paramLong2, paramInt1, paramInt2);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      localSendMessageHandler.a(new zgl(this, localPbSendMsgReq, i1, paramLong2));
      paramInt1 += 1;
    }
    paramInt1 = 0;
    while (paramInt1 <= 3)
    {
      paramLong1 = paramInt1 * 30000L / 3L;
      localSendMessageHandler.getClass();
      localSendMessageHandler.a(paramLong1, 10000L, "period");
      paramInt1 += 1;
    }
    return i1;
  }
  
  public SvcRequestGetMsgV2 a()
  {
    SvcRequestGetMsgV2 localSvcRequestGetMsgV2 = new SvcRequestGetMsgV2();
    localSvcRequestGetMsgV2.lUin = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    int i1 = 0;
    SvcRequestPullDisMsgSeq localSvcRequestPullDisMsgSeq = new SvcRequestPullDisMsgSeq(new ArrayList(), (byte)0);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramInt == 4)
    {
      if ((this.jdField_b_of_type_ArrayOfJavaLangString == null) || (this.jdField_b_of_type_ArrayOfJavaLangString.length == 0))
      {
        a(4002, true, null);
        return null;
      }
      int i2 = this.jdField_b_of_type_ArrayOfJavaLangString.length;
      localObject1 = new StringBuilder();
      paramInt = i1;
      while (paramInt < i2)
      {
        localObject2 = this.jdField_b_of_type_ArrayOfJavaLangString[paramInt];
        localObject3 = new MessageSvcPack.PullDisSeqParam();
        ((MessageSvcPack.PullDisSeqParam)localObject3).lDisCode = Long.parseLong((String)localObject2);
        ((MessageSvcPack.PullDisSeqParam)localObject3).lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h((String)localObject2);
        localSvcRequestPullDisMsgSeq.vDisInfo.add(localObject3);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject1).append((String)localObject2).append(",");
        }
        paramInt += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisMsgSeq disUinArray: " + ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      return localSvcRequestPullDisMsgSeq;
      localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(52)).a();
      if (((ArrayList)localObject1).size() == 0)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = null;
        a(4002, true, null);
        return null;
      }
      i1 = ((ArrayList)localObject1).size();
      this.jdField_b_of_type_ArrayOfJavaLangString = new String[i1];
      localObject2 = new StringBuilder();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject3 = (DiscussionInfo)((ArrayList)localObject1).get(paramInt);
        MessageSvcPack.PullDisSeqParam localPullDisSeqParam = new MessageSvcPack.PullDisSeqParam();
        localPullDisSeqParam.lDisCode = Long.parseLong(((DiscussionInfo)localObject3).uin);
        localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(((DiscussionInfo)localObject3).uin);
        this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = ((DiscussionInfo)localObject3).uin;
        localSvcRequestPullDisMsgSeq.vDisInfo.add(localPullDisSeqParam);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject2).append(((DiscussionInfo)localObject3).uin).append(",");
        }
        paramInt += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisMsgSeq disUinArray: " + ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public SvcRequestPullGroupMsgSeq a(int paramInt)
  {
    int i1 = 0;
    Object localObject = new ArrayList();
    int i2 = MsgFilter.LIMIT_10_AND_IN_3_DAYS.value();
    String[] arrayOfString;
    if (paramInt == 3)
    {
      arrayOfString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
    }
    while ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      a(4003, true, arrayOfString);
      return null;
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    }
    localObject = new SvcRequestPullGroupMsgSeq((ArrayList)localObject, (byte)0, i2);
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = i1;
    while (paramInt < arrayOfString.length)
    {
      PullGroupSeqParam localPullGroupSeqParam = new PullGroupSeqParam();
      try
      {
        localPullGroupSeqParam.lGroupCode = Long.parseLong(arrayOfString[paramInt]);
        localPullGroupSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(arrayOfString[paramInt]);
        ((SvcRequestPullGroupMsgSeq)localObject).vGroupInfo.add(localPullGroupSeqParam);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("; troopUin=").append(arrayOfString[paramInt]).append(",").append(" lastSeqId=").append(localPullGroupSeqParam.lLastSeqId);
        }
      }
      catch (Exception localException)
      {
        label192:
        break label192;
      }
      paramInt += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullGroupMsgSeq troopUinArray: " + localStringBuilder.toString());
    }
    return localObject;
  }
  
  public SvcRequestPullDisGroupSeq a()
  {
    Object localObject;
    if ((this.jdField_b_of_type_ArrayOfJavaLangString == null) || (this.jdField_b_of_type_ArrayOfJavaLangString.length == 0))
    {
      a(4002, true, null);
      localObject = null;
    }
    SvcRequestPullDisGroupSeq localSvcRequestPullDisGroupSeq;
    StringBuilder localStringBuilder;
    label198:
    do
    {
      return localObject;
      new ArrayList();
      localSvcRequestPullDisGroupSeq = new SvcRequestPullDisGroupSeq();
      localObject = new ArrayList();
      int i2 = this.jdField_b_of_type_ArrayOfJavaLangString.length;
      localStringBuilder = new StringBuilder();
      int i1 = 0;
      for (;;)
      {
        if (i1 >= i2) {
          break label198;
        }
        try
        {
          RegisterProxySvcPack.PullDisSeqParam localPullDisSeqParam = new RegisterProxySvcPack.PullDisSeqParam();
          localPullDisSeqParam.lDisCode = Long.parseLong(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
          localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
          ((ArrayList)localObject).add(localPullDisSeqParam);
          if (QLog.isColorLevel()) {
            localStringBuilder.append(this.jdField_b_of_type_ArrayOfJavaLangString[i1]).append(",");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisGroupSeq Exception: disUin=" + this.jdField_b_of_type_ArrayOfJavaLangString[i1], localException);
            }
          }
        }
        i1 += 1;
      }
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        a(4002, true, null);
        return null;
      }
      localSvcRequestPullDisGroupSeq.setVDisInfo((ArrayList)localObject);
      localObject = localSvcRequestPullDisGroupSeq;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisGroupSeq disUinArray: " + localStringBuilder.toString());
    return localSvcRequestPullDisGroupSeq;
  }
  
  public BaseMessageProcessor a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
          break label433;
        }
        if ("c2c_processor".equals(paramString))
        {
          localObject = new C2CMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
          if (localObject != null) {
            break label416;
          }
          return null;
        }
      }
      if ("troop_processor".equals(paramString))
      {
        localObject = new TroopMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("disc_processor".equals(paramString))
      {
        localObject = new DiscMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("businessbase_processor".equals(paramString))
      {
        localObject = new OnLinePushMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("sub_account_processor".equals(paramString))
      {
        localObject = new SubAccountMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("accost_processor".equals(paramString))
      {
        localObject = new AccostMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("offlinefile_processor".equals(paramString))
      {
        localObject = new OfflineFileMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("system_processor".equals(paramString))
      {
        localObject = new SystemMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("uncommon_msg_processor".equals(paramString))
      {
        localObject = new UncommonMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("video_processor".equals(paramString))
      {
        localObject = new VideoMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("discuss_update_processor".equals(paramString))
      {
        localObject = new DiscMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("info_update_processor".equals(paramString))
      {
        localObject = new ProfileCardMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("slave_master_processor".equals(paramString))
      {
        localObject = new FileSlaveMasterMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("hctopic_processor".equals(paramString))
      {
        localObject = new HCTopicMessageProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
        continue;
        label416:
        ((BaseMessageProcessor)localObject).a(this);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        label433:
        return (BaseMessageProcessor)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public OfflineFileMessageProcessor a()
  {
    return (OfflineFileMessageProcessor)a("offlinefile_processor");
  }
  
  public OnLinePushMessageProcessor a()
  {
    return (OnLinePushMessageProcessor)a("businessbase_processor");
  }
  
  public SubAccountMessageProcessor a()
  {
    return (SubAccountMessageProcessor)a("sub_account_processor");
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
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public MessageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  }
  
  public SendMessageHandler a(long paramLong)
  {
    return (SendMessageHandler)this.jdField_d_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  protected Class a()
  {
    return MessageObserver.class;
  }
  
  public Object a(String arg1, int paramInt)
  {
    String str = ??? + "_" + paramInt;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  public HashSet a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_l_of_type_Boolean = true;
    e();
    c();
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d();
    AudioUtil.a();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    n();
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() != null) {
          ((SendMessageHandler)localEntry.getValue()).a();
        }
      }
    }
    this.jdField_d_of_type_JavaUtilHashMap.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    ((DiscMessageProcessor)a("disc_processor")).a();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ThreadManager.post(new zgn(this), 8, null, false);
  }
  
  public void a(byte paramByte, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, int paramInt2, Object paramObject)
  {
    Object localObject = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).setLength(0);
      ((StringBuilder)localObject).append("<PbGetMsg><S>--->>getC2CMessage:cChannel:").append(paramByte).append(",syncFlag:").append(paramInt1).append(",isPullRoamMsg:").append(paramBoolean1).append(",newMsgInSync:").append(paramBoolean3).append(",ssoTimeStamp:").append(paramString).append(",pullMsgType:").append(paramInt2);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    byte[] arrayOfByte;
    byte b1;
    if (((paramInt2 != 2) && (!a(paramBoolean3))) || ((paramInt2 == 2) && (!d())))
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(false);
      arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      if (!paramBoolean1) {
        break label567;
      }
      b1 = 0;
      localObject = a("MessageSvc.PbGetMsg");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getC2CMessage cChannel: " + paramByte + "vCookies: " + paramArrayOfByte + ",cSyncFlag:" + paramInt1 + ",pullRoamMsg:" + paramBoolean1 + ",onlineSyncFlag:" + b1);
      }
      ((ToServiceMsg)localObject).extraData.putByte("cChannel", paramByte);
      ((ToServiceMsg)localObject).extraData.putByteArray("vCookies", paramArrayOfByte);
      ((ToServiceMsg)localObject).extraData.putInt("cSyncFlag", paramInt1);
      ((ToServiceMsg)localObject).extraData.putByteArray("vSyncCookie", arrayOfByte);
      ((ToServiceMsg)localObject).extraData.putByte("onlineSyncFlag", b1);
      ((ToServiceMsg)localObject).extraData.putBoolean("needNofityConversation", paramBoolean2);
      ((ToServiceMsg)localObject).extraData.putBoolean("isPullRoamMsg", paramBoolean1);
      if (paramString != null) {
        ((ToServiceMsg)localObject).addAttribute("sso_push_timestamp", paramString + "|" + System.currentTimeMillis());
      }
      paramArrayOfByte = new msg_svc.PbGetMsgReq();
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).extraData.putInt("pullMsgType", paramInt2);
      paramArrayOfByte.sync_flag.set(paramInt1);
      paramArrayOfByte.ramble_flag.set(0);
      paramArrayOfByte.context_flag.set(1);
      paramArrayOfByte.online_sync_flag.set(b1);
      paramArrayOfByte.latest_ramble_number.set(20);
      paramArrayOfByte.other_ramble_number.set(3);
      if ((paramObject != null) && ((paramObject instanceof RequestPushNotify)))
      {
        paramString = (RequestPushNotify)paramObject;
        if (paramString.bytes_server_buf != null)
        {
          paramArrayOfByte.bytes_server_buf.set(ByteStringMicro.copyFrom(paramString.bytes_server_buf));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->>getC2CMessage (PushNotify getMsg) pb:", "MessageSvc.PbGetMsg", ", fill bytes_server_buf=", paramString.bytes_server_buf.toString() });
          }
        }
      }
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
      c((ToServiceMsg)localObject);
      return;
      label567:
      b1 = 1;
      break;
      paramArrayOfByte.msg_req_type.set(0);
      if (arrayOfByte != null)
      {
        paramArrayOfByte.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
        continue;
        paramArrayOfByte.msg_req_type.set(1);
        if (arrayOfByte != null)
        {
          paramArrayOfByte.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
          continue;
          paramArrayOfByte.msg_req_type.set(2);
          paramString = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
          if (paramString != null) {
            paramArrayOfByte.pubaccount_cookie.set(ByteStringMicro.copyFrom(paramString));
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    label65:
    HashMap localHashMap;
    String[] arrayOfString1;
    String[] arrayOfString2;
    if (paramInt == 1)
    {
      localObject = (String[])this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(-2).get(Integer.valueOf(-2));
      a((String[])localObject);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
      localObject = a();
      if (localObject != null)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject[0]);
        if (paramInt == 1) {
          q();
        }
      }
    }
    else
    {
      localHashMap = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(-1);
      arrayOfString1 = (String[])localHashMap.get(Integer.valueOf(1));
      arrayOfString2 = (String[])localHashMap.get(Integer.valueOf(4));
      if (arrayOfString1 == null) {
        break label330;
      }
    }
    label168:
    label330:
    for (int i1 = arrayOfString1.length + 0;; i1 = 0)
    {
      int i2 = i1;
      if (arrayOfString2 != null) {
        i2 = i1 + arrayOfString2.length;
      }
      if (i2 > 0)
      {
        localObject = new String[i2];
        if (arrayOfString1 != null)
        {
          System.arraycopy(arrayOfString1, 0, localObject, 0, arrayOfString1.length);
          i1 = arrayOfString1.length;
          if (arrayOfString2 != null) {
            System.arraycopy(arrayOfString2, 0, localObject, i1, arrayOfString2.length);
          }
          a((String[])localObject);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
        localObject = (String[])localHashMap.get(Integer.valueOf(2));
        if ((localObject != null) && (localObject.length > 0) && (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "enableTroopMsgPushCache type=2, 1st uin=" + localObject[0]);
          }
          i1 = 0;
          while (i1 < localObject.length)
          {
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(localObject[i1], 0);
            i1 += 1;
          }
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.MessageHandler", 2, "enableTroopMsgPushCache num troop list is empty!");
        break;
        this.jdField_b_of_type_ArrayOfJavaLangString = null;
        break label65;
        i1 = 0;
        break label168;
        localObject = null;
      }
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    o();
    int i1 = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "sendNewRegisterProxy , type = " + paramInt + " , isGetPassword = " + paramBoolean + " ,randomSeq" + i1);
    }
    long l2 = 0x80 | 0L;
    long l1;
    if ((paramInt == 1) || (paramInt == 2))
    {
      l1 = l2 | 0x40 | 0x100 | 0x2 | 0x2000 | 0x4000;
      this.jdField_i_of_type_Int = i1;
    }
    for (;;)
    {
      ToServiceMsg localToServiceMsg = a("RegPrxySvc.infoSync");
      localToServiceMsg.extraData.putLong("requestOptional", l1);
      localToServiceMsg.extraData.putInt("endSeq", i1);
      localToServiceMsg.extraData.putInt("type", paramInt);
      localToServiceMsg.extraData.putBoolean("isGetPassword", paramBoolean);
      if (paramLong != 0L)
      {
        this.jdField_a_of_type_Long = paramLong;
        localToServiceMsg.getAttributes().put("_attr_regprxy_random_code", Long.valueOf(this.jdField_a_of_type_Long));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] currentRegisterProxyRandom = " + this.jdField_a_of_type_Long);
        }
      }
      a(localToServiceMsg);
      return;
      l1 = l2;
      if (paramInt == 3)
      {
        this.jdField_j_of_type_Int = i1;
        l1 = l2;
      }
    }
  }
  
  public void a(int paramInt1, List paramList1, String paramString, long paramLong1, List paramList2, int paramInt2, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("PbMessageSvc.PbSearchRoamMsgInCloud");
    localToServiceMsg.setTimeout(5000L);
    localToServiceMsg.extraData.putString("keyword", paramString);
    localToServiceMsg.extraData.putLong("sequence", paramLong1);
    localToServiceMsg.extraData.putInt("retryIndex", paramInt2);
    localToServiceMsg.extraData.putInt("loadType", paramInt1);
    msg_svc.PbSearchRoamMsgInCloudReq localPbSearchRoamMsgInCloudReq = new msg_svc.PbSearchRoamMsgInCloudReq();
    oidb_c2c_searcher.ReqBody localReqBody = new oidb_c2c_searcher.ReqBody();
    localReqBody.query.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.max_cnt.set(20);
    localReqBody.type.set(1);
    ArrayList localArrayList = new ArrayList();
    if (paramList2 == null)
    {
      if (paramList1 != null)
      {
        paramInt1 = 0;
        if (paramInt1 < paramList1.size())
        {
          paramList2 = new oidb_c2c_searcher.Iterator();
          oidb_c2c_searcher.MsgKey localMsgKey = new oidb_c2c_searcher.MsgKey();
          if (paramLong2 != 0L) {
            localMsgKey.time.set(paramLong2);
          }
          for (;;)
          {
            paramList2.key.set(localMsgKey);
            paramList2.uin.set(Long.parseLong((String)paramList1.get(paramInt1)));
            localArrayList.add(paramList2);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud friendUin: " + (String)paramList1.get(paramInt1) + " beginTime: " + paramList2.key.time.get() + ", searchkey: " + paramString + ",lastDatelineTime:" + paramLong2);
            }
            paramInt1 += 1;
            break;
            localMsgKey.time.set(NetConnInfoCenter.getServerTime());
          }
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud  beginTime: " + ((oidb_c2c_searcher.Iterator)paramList2.get(0)).key.time.get() + ", searchkey: " + paramString + ",retryIndex" + paramInt2);
      }
      localArrayList.addAll(paramList2);
    }
    if (localArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud listSize 0: it should not happen, check why");
      }
      return;
    }
    VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatSearch", "Send_require", 0, 0, new String[0]);
    localReqBody.friends.set(localArrayList);
    localReqBody.set(localReqBody);
    localPbSearchRoamMsgInCloudReq.serialize_reqbody.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(localPbSearchRoamMsgInCloudReq.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 0L, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    o();
    int i1 = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "sendRegisterProxy , type = " + paramInt + " , needEndPkg = " + paramBoolean1 + " , registerProxyRandom = " + paramLong + " , isGetPassword = " + paramBoolean2);
    }
    long l2 = 0L | 0x80;
    long l1;
    if ((paramInt == 1) || (paramInt == 2))
    {
      l2 = l2 | 0x40 | 0x100 | 0x2;
      l1 = l2;
      if (!paramBoolean1) {
        break label349;
      }
      this.jdField_i_of_type_Int = i1;
      l1 = l2;
      if (paramInt != 1) {
        break label352;
      }
    }
    label349:
    label352:
    for (Object localObject = "RegPrxySvc.infoLogin";; localObject = "RegPrxySvc.getOffMsg")
    {
      localObject = a((String)localObject);
      ((ToServiceMsg)localObject).extraData.putLong("requestOptional", l1);
      if (paramBoolean1) {
        ((ToServiceMsg)localObject).extraData.putInt("endSeq", i1);
      }
      if (paramLong != 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] RegisterProxyRandom = " + paramLong);
        }
        this.jdField_a_of_type_Long = paramLong;
        ((ToServiceMsg)localObject).getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
      }
      ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
      ((ToServiceMsg)localObject).extraData.putBoolean("isGetPassword", paramBoolean2);
      a((ToServiceMsg)localObject);
      return;
      if ((paramInt == 3) && (paramBoolean1))
      {
        this.jdField_j_of_type_Int = i1;
        l1 = l2;
        break;
      }
      l1 = l2;
      if (paramInt == 4)
      {
        l2 |= 0x100;
        this.jdField_i_of_type_Int = i1;
        l1 = l2;
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false))
        {
          this.jdField_k_of_type_Int = i1;
          l1 = l2;
        }
      }
      break;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "removeSendMessageHandler msgseq=" + paramLong);
    }
    SendMessageHandler localSendMessageHandler = a(paramLong);
    if (localSendMessageHandler != null)
    {
      localSendMessageHandler.a();
      a(paramLong);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("OnlinePush.RespPush");
    localToServiceMsg.extraData.putInt("svrip", paramInt1);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    localToServiceMsg.extraData.putLong("lUin", paramLong);
    localToServiceMsg.setNeedCallback(false);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    ToServiceMsg localToServiceMsg = a("OnlinePush.RespPush");
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localToServiceMsg.extraData.putSerializable("delMsgInfos", paramArrayList);
      localToServiceMsg.extraData.putInt("svrip", paramInt1);
      localToServiceMsg.extraData.putInt("seq", paramInt2);
      localToServiceMsg.extraData.putLong("lUin", paramLong);
      if ((paramPbPushMsg != null) && (paramPbPushMsg.bytes_push_token.has())) {
        localToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[])paramPbPushMsg.bytes_push_token.get().toByteArray().clone());
      }
      localToServiceMsg.setNeedCallback(false);
      a(localToServiceMsg);
    }
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt) {}
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(String.valueOf(paramLong2));
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Friends)localObject1).name;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).trim().length() != 0) {
          break label61;
        }
      }
    }
    for (localObject1 = String.valueOf(paramLong2);; localObject1 = String.valueOf(paramLong2))
    {
      label61:
      long l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = new Intent("tencent.video.q2v.RecvSharpVideoCall");
      ((Intent)localObject2).setClassName(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
      ((Intent)localObject2).putExtra("uin", String.valueOf(paramLong1));
      ((Intent)localObject2).putExtra("fromUin", String.valueOf(paramLong2));
      ((Intent)localObject2).putExtra("buffer", paramArrayOfByte);
      ((Intent)localObject2).putExtra("time", paramInt);
      ((Intent)localObject2).putExtra("name", (String)localObject1);
      ((Intent)localObject2).putExtra("isPttRecordingOrPlaying", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.r());
      ((Intent)localObject2).putExtra("isRequest", paramBoolean);
      ((Intent)localObject2).putExtra("onLineStatus", l1);
      QLog.d("shanezhaiSHARP", 1, "avideo handleSharpVideoMessageResp sendBroadcast!!");
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject2);
      return;
    }
  }
  
  public void a(SvrMsg paramSvrMsg)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.SvrMsg");
    localToServiceMsg.extraData.putSerializable("SvrMsg", paramSvrMsg);
    a(localToServiceMsg);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION".equals(paramContext)) || ("com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION".equals(paramContext)))
    {
      paramContext = new QNotificationManager(BaseApplication.getContext());
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", jdField_g_of_type_Int);
      this.jdField_j_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaLangThread != null) {
        this.jdField_a_of_type_JavaLangThread.interrupt();
      }
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", jdField_h_of_type_Int);
      this.jdField_k_of_type_Boolean = false;
      if (this.jdField_b_of_type_JavaLangThread != null) {
        this.jdField_b_of_type_JavaLangThread.interrupt();
      }
      paramContext = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.MessageHandler", 4, "PConline BroadcastReceiver clicked " + paramContext.getClassName());
        }
        if (!paramContext.getClassName().equals(LoginInfoActivity.class.getName()))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageHandler", 4, "PConline BroadcastReceiver clicked startActivity" + LoginInfoActivity.class.getName());
          }
          paramContext = new Intent(BaseApplication.getContext(), LoginInfoActivity.class);
          paramContext.addFlags(268435456);
          BaseApplication.getContext().startActivity(paramContext);
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_notice", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(Message paramMessage, boolean paramBoolean)
  {
    if (!a().a(paramMessage))
    {
      a().a(paramMessage);
      if (paramBoolean)
      {
        a().sendMessage(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sendWorkMessage doNow=" + paramBoolean);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        a().b(paramMessage);
        if (!a().hasMessages(2)) {
          a().sendEmptyMessageDelayed(2, 5000L);
        }
      }
    }
    QLog.d("Q.msg.MessageHandler", 2, "return! caused by hasSameUnreadWorker");
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageRecord);
    if (!paramMessageRecord.isread) {}
    for (boolean bool = true;; bool = false)
    {
      a("addMessageAndNotify", 1000, true, null, 1, a(bool, MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList)), false, null);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "sendRevokeMsgReq, timeout: " + paramLong);
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "sendRevokeMsgReq error, isMsgRevoking: false");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord.isLongMsg()) && ((paramMessageRecord instanceof MessageForLongMsg))) {
      localArrayList.addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
    }
    for (;;)
    {
      paramMessageRecord = a().a(localArrayList, 1);
      if (paramMessageRecord == null) {
        break;
      }
      paramMessageRecord.setTimeout(paramLong);
      c(paramMessageRecord);
      return;
      localArrayList.add(paramMessageRecord);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->sendRichTextMessageWith_MR : msgseq=", Long.valueOf(paramMessageRecord.msgseq) });
    }
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    if (!a(paramMessageRecord.msgseq, localSendMessageHandler)) {}
    for (int i1 = 0;; i1 = 1)
    {
      msg_svc.PbSendMsgReq localPbSendMsgReq = MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
      MessageForStructing localMessageForStructing;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        localMessageForStructing = (MessageForStructing)paramMessageRecord;
        if (localMessageForStructing.structingMsg == null) {}
      }
      for (boolean bool = ShareStructLongMessageManager.b(localMessageForStructing.structingMsg);; bool = false)
      {
        if ((MessageForRichText.class.isInstance(paramMessageRecord)) && (!bool)) {
          ((MessageForRichText)paramMessageRecord).richText = null;
        }
        if (localPbSendMsgReq == null) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->sendRichTextMessageWith_MR : the richText is null!", paramMessageRecord.getBaseInfoString() });
          }
        }
        do
        {
          do
          {
            return;
            a(paramMessageRecord, localPbSendMsgReq, 480000L, 0, paramBusinessObserver, paramBoolean);
            localSendMessageHandler.postDelayed(new zgw(this, paramMessageRecord), jdField_d_of_type_Int);
            if (i1 != 0)
            {
              i1 = 0;
              while (i1 < 8)
              {
                localSendMessageHandler.a(new zgx(this, paramMessageRecord, localPbSendMsgReq, paramBusinessObserver, paramBoolean));
                i1 += 1;
              }
              i1 = 1;
              while (i1 < 3)
              {
                long l1 = (3 - i1) * 480000 / 3 - i1 * 2000;
                long l2 = 480000 * i1 / 3;
                localSendMessageHandler.getClass();
                localSendMessageHandler.a(l2, l1, "period");
                i1 += 1;
              }
            }
          } while (paramMessageRecord.istroop != 1);
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
          i1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.jdField_a_of_type_JavaUtilList.size();
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
        } while (i1 <= MessageCache.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.jdField_a_of_type_JavaUtilList.remove(0);
        return;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (paramMessageRecord2 == null)) {}
    do
    {
      for (;;)
      {
        return;
        if ((paramMessageRecord1 instanceof MessageForFunnyFace))
        {
          Object localObject = (MessageForFunnyFace)paramMessageRecord1;
          if ((((MessageForFunnyFace)localObject).mFunnyFaceMessage == null) || (((MessageForFunnyFace)localObject).mFunnyFaceMessage.faceId != 1)) {
            break;
          }
          try
          {
            paramMessageRecord2 = (MessageForFunnyFace)paramMessageRecord2;
            localObject = ((MessageForFunnyFace)localObject).mFunnyFaceMessage.turntable.hitNickName;
            if ((localObject != null) && (((String)localObject).length() > 0) && (!((String)localObject).equals(paramMessageRecord2.mFunnyFaceMessage.turntable.hitNickName)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "updateGroupMsgContent, funnyface, change " + paramMessageRecord2.mFunnyFaceMessage.turntable.hitNickName + " to " + (String)localObject);
              }
              paramMessageRecord2.mFunnyFaceMessage.turntable.hitNickName = ((String)localObject);
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord1.uniseq, paramMessageRecord2.mFunnyFaceMessage.getBytes());
              return;
            }
          }
          catch (Exception paramMessageRecord1) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, paramMessageRecord1.toString());
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "addMessageAndNotifyForQAV:" + paramMessageRecord.toString());
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageRecord);
    if ((paramMessageRecord.msgtype == -4008) || (paramMessageRecord.msgtype == -2016))
    {
      if ((paramMessageRecord.istroop == 3000) && (paramMessageRecord.msgtype == -4008)) {
        a("addMessageAndNotify", 1000, true, null, 1, true, false, paramMessageRecord);
      }
    }
    else if ((paramMessageRecord.msgtype == -2009) && ((paramMessageRecord.istroop == 0) || (paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 10004) || (paramMessageRecord.istroop == 1004) || (paramMessageRecord.istroop == 1006) || (paramMessageRecord.istroop == 1021) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)))
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a("addMessageAndNotify", 1000, true, null, 1, a(paramBoolean, MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList)), false, paramMessageRecord);
        return;
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a("addMessageAndNotify", 1000, true, null, 1, a(paramBoolean, MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList)), false, null);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleError serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (ProcessorDispatcher.a().containsKey(str)) {
      a(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      int i1;
      do
      {
        return;
        if (("MessageSvc.PbGetMsg".equalsIgnoreCase(str)) || ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str)))
        {
          if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str)) {
            jdField_a_of_type_Boolean = true;
          }
          e(paramToServiceMsg);
          return;
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          e(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(str))
        {
          d(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (!"MessageSvc.PbSendMsg".equalsIgnoreCase(str)) {
          break;
        }
        i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
        if ((i1 == 1) || (i1 == 3) || (i1 == 25) || (i1 == 14) || (i1 == 5) || (i1 == 6) || (i1 == 10) || (i1 == 11) || (i1 == 12) || (i1 == 23) || (i1 == 26) || (i1 == 27) || (i1 == 8) || (i1 == 16) || (i1 == 17) || (i1 == 18) || (i1 == 15) || (i1 == 19) || (i1 == 20) || (i1 == 22) || (i1 == 24))
        {
          f(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 9)
        {
          a().b(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 13)
        {
          a().c(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 4)
        {
          i(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while (i1 != 2);
      g(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("OidbSvc.0xa89".equalsIgnoreCase(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) || ("PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str)))
      {
        if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action"))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<<---handleError - get thirdqq unread number");
          }
          a().b(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("RegPrxySvc.infoLogin".equalsIgnoreCase(str)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str)))
      {
        a(paramFromServiceMsg, null);
        return;
      }
      if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        b(paramFromServiceMsg, null);
        return;
      }
    } while (!"MessageSvc.PbReceiptRead".equalsIgnoreCase(str));
    v(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l3 = System.currentTimeMillis();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(128);
      ((StringBuilder)localObject1).append("onReceive success ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" serviceCmd: ").append(str).append(", resultCode:").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if ("StreamSvr.UploadStreamMsg".equals(str))
    {
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        short s1 = paramToServiceMsg.extraData.getShort("PackSeq");
        a(3011, false, new Object[] { new MessageFactoryReceiver.UploadStreamStruct(paramToServiceMsg.extraData.getString("filepath"), s1, paramToServiceMsg.extraData.getShort("flowLayer"), null, 0) });
      }
      if (!a(str)) {
        break label244;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "cmdfilter error=" + str);
      }
    }
    label244:
    do
    {
      return;
      if ("OidbSvc.0x4ff_42073".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        break;
      }
      if (!"OidbSvc.0x5eb_42073".equals(str)) {
        break;
      }
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      break;
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        j(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (this.jdField_l_of_type_Boolean);
    if (ProcessorDispatcher.a().containsKey(str)) {
      a(str, paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    label704:
    byte b1;
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "handle [cmd]=" + str + " , cost =" + (l1 - l3));
      return;
      if ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(str))
      {
        l1 = System.currentTimeMillis();
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullGroupMsgSeq)paramObject);
        MsgAutoMonitorUtil.a().e(System.currentTimeMillis() - l1);
      }
      else if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullDisMsgSeq)paramObject);
      }
      else if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(str))
      {
        l1 = System.currentTimeMillis();
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullDisGroupSeq)paramObject);
        MsgAutoMonitorUtil.a().d(System.currentTimeMillis() - l1);
      }
      else if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.infoLogin".equalsIgnoreCase(str))
      {
        a(paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str))
      {
        a(paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        b(paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(str))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
      {
        try
        {
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d()) {
            break label704;
          }
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handleGetC2CMessageResp_PB exception ! ", paramFromServiceMsg);
          }
          e(paramToServiceMsg);
        }
        continue;
        a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      }
      else if (!"MessageSvc.DelMsgV2".equalsIgnoreCase(str))
      {
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          if (paramObject == null) {
            e(paramToServiceMsg, paramFromServiceMsg);
          } else {
            b(paramToServiceMsg, 3012, true, new Object[] { paramObject });
          }
        }
        else
        {
          boolean bool1;
          if ("MessageSvc.PushNotify".equalsIgnoreCase(str))
          {
            boolean bool2 = false;
            bool1 = false;
            Object localObject3 = null;
            localObject1 = null;
            RequestPushNotify localRequestPushNotify;
            if ((paramObject instanceof RequestPushNotify))
            {
              localRequestPushNotify = (RequestPushNotify)paramObject;
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = localRequestPushNotify.wUserActive;
              if ((localRequestPushNotify.wGeneralFlag & 0x8) == 8)
              {
                bool2 = true;
                localObject3 = Long.toString(localRequestPushNotify.lBindedUin);
                localObject1 = localObject3;
                bool1 = bool2;
                if ((localRequestPushNotify.wGeneralFlag & 0x10) == 16)
                {
                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localRequestPushNotify);
                  bool1 = bool2;
                  localObject1 = localObject3;
                }
              }
              localObject3 = localObject1;
              bool2 = bool1;
              if (QLog.isColorLevel()) {
                if (!bool1) {
                  break label1061;
                }
              }
            }
            label1061:
            for (localObject3 = "SUB_ACCOUNT";; localObject3 = "Q.msg.MessageHandler")
            {
              QLog.d((String)localObject3, 2, String.format("MessageSvc.PushNotify, notify.wUserActive: %d isSubAccount: %s, cmd: %s, wGeneralFlag:%d, bytesServerBuf: %s", new Object[] { Integer.valueOf(localRequestPushNotify.wUserActive), Boolean.valueOf(bool1), localRequestPushNotify.strCmd, Integer.valueOf(localRequestPushNotify.wGeneralFlag), localRequestPushNotify.bytes_server_buf }));
              bool2 = bool1;
              localObject3 = localObject1;
              if (!bool2) {
                break label1068;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "subaccount push and start get subaccount msg, subUin=" + (String)localObject3);
              }
              if (localObject3 == null) {
                break;
              }
              SubAccountControll.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, true);
              break;
            }
            label1068:
            if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a()) {
              e(paramToServiceMsg, paramFromServiceMsg, paramObject);
            }
          }
          else if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcResponseSetRoamMsg)paramObject);
          }
          else if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcResponseDelRoamMsg)paramObject);
          }
          else if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
          {
            w(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("ADMsgSvc.PushMsg".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (AdMsgInfo)paramObject);
          }
          else if ("MessageSvc.PushReaded".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcRequestPushReadedNotify)paramObject);
          }
          else if ("TransService.ReqGetSign".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.SigStruct)paramObject);
          }
          else if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(str))
          {
            if (paramObject == null) {
              a(3011, false, null);
            } else {
              a(3011, true, new Object[] { (MessageFactoryReceiver.UploadStreamStruct)paramObject });
            }
          }
          else
          {
            int i1;
            if ("MessageSvc.PbSendMsg".equalsIgnoreCase(str))
            {
              i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
              if ((i1 == 1) || (i1 == 3) || (i1 == 25) || (i1 == 14) || (i1 == 5) || (i1 == 6) || (i1 == 10) || (i1 == 11) || (i1 == 12) || (i1 == 23) || (i1 == 26) || (i1 == 27) || (i1 == 8) || (i1 == 16) || (i1 == 17) || (i1 == 18) || (i1 == 15) || (i1 == 19) || (i1 == 20) || (i1 == 22) || (i1 == 24)) {
                f(paramToServiceMsg, paramFromServiceMsg, paramObject);
              } else if (i1 == 9) {
                a("offlinefile_processor").a(7002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
              } else if (i1 == 13) {
                a("offlinefile_processor").a(7003, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
              } else if (i1 == 4) {
                j(paramToServiceMsg, paramFromServiceMsg, paramObject);
              } else if (i1 == 2) {
                g(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
            }
            else if ("OidbSvc.0xa89".equalsIgnoreCase(str))
            {
              x(paramToServiceMsg, paramFromServiceMsg, paramObject);
            }
            else
            {
              long l2;
              long l4;
              if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(str))
              {
                if (paramObject != null)
                {
                  paramObject = (Object[])paramObject;
                  l1 = ((Long)paramObject[0]).longValue();
                  paramToServiceMsg = (StreamInfo)paramObject[1];
                  paramFromServiceMsg = (StreamData)paramObject[2];
                  l2 = ((Long)paramObject[3]).longValue();
                  l4 = ((Long)paramObject[4]).longValue();
                  long l5 = ((Long)paramObject[5]).longValue();
                  paramObject = new ptt_reserve.ReserveStruct();
                  if ((paramToServiceMsg != null) && (paramToServiceMsg.vPbData != null)) {}
                  try
                  {
                    paramObject.mergeFrom(paramToServiceMsg.vPbData);
                    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, paramFromServiceMsg, l1, l2, l4, l5, paramObject);
                  }
                  catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
                  {
                    for (;;)
                    {
                      QLog.e("Q.msg.MessageHandler", 1, "parse streaminfo.vPbData failed.", localInvalidProtocolBufferMicroException);
                    }
                  }
                }
              }
              else if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
              {
                i(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              else if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(str))
              {
                b(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              else if ("OnlinePush.PbPushTransMsg".equalsIgnoreCase(str))
              {
                paramObject = paramFromServiceMsg.getWupBuffer();
                Object localObject2 = new byte[paramObject.length - 4];
                PkgTools.a((byte[])localObject2, 0, paramObject, 4, paramObject.length - 4);
                paramObject = new OnlinePushTrans.PbMsgInfo();
                try
                {
                  paramObject.mergeFrom((byte[])localObject2);
                  if (paramObject != null)
                  {
                    if (paramObject.msg_type.get() == 207) {
                      a(paramObject.msg_data.get().toByteArray());
                    }
                  }
                  else
                  {
                    paramToServiceMsg = a("OnlinePush.RespPush");
                    if (paramObject != null)
                    {
                      i1 = paramFromServiceMsg.getRequestSsoSeq();
                      paramToServiceMsg.extraData.putInt("svrip", paramObject.svr_ip.get());
                      paramToServiceMsg.extraData.putInt("seq", i1);
                    }
                    paramToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
                    paramToServiceMsg.setNeedCallback(false);
                    a(paramToServiceMsg);
                  }
                }
                catch (InvalidProtocolBufferMicroException paramObject)
                {
                  for (;;)
                  {
                    paramObject.printStackTrace();
                    paramObject = null;
                    continue;
                    if ((paramObject.msg_type.get() == 44) || (paramObject.msg_type.get() == 34))
                    {
                      a().a(3, 1, false);
                      if (paramObject.msg_type.get() == 34)
                      {
                        paramToServiceMsg = (TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
                        localObject2 = paramObject.msg_data.get().toByteArray();
                        l1 = PkgTools.a((byte[])localObject2, 0);
                        i1 = localObject2[4];
                        l2 = PkgTools.a((byte[])localObject2, 5);
                        paramObject.from_uin.get();
                        localObject2 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                        ((TroopManager)localObject2).c("" + l1, "" + l2);
                        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals("" + l2))
                        {
                          localObject2 = ((TroopManager)localObject2).a(paramObject.from_uin.get() + "");
                          if ((paramToServiceMsg != null) && (localObject2 == null)) {
                            paramToServiceMsg.a("" + paramObject.from_uin.get());
                          }
                        }
                      }
                      else if (paramObject.msg_type.get() == 44)
                      {
                        paramToServiceMsg = paramObject.msg_data.get().toByteArray();
                        l4 = PkgTools.a(paramToServiceMsg, 0);
                        i1 = paramToServiceMsg[4];
                        i1 = paramToServiceMsg[5];
                        if ((i1 == 0) || (i1 == 1)) {
                          l2 = PkgTools.a(paramToServiceMsg, 6);
                        }
                        for (l1 = 0L;; l1 = PkgTools.a(paramToServiceMsg, 10))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(".troop.push_msg", 2, new Object[] { "GroupCode: ", Long.valueOf(l4) });
                          }
                          AIOUtils.a(".troop.push_msg", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 87, 0, 0, Arrays.asList(new Long[] { Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1) }), 500);
                          break;
                          l2 = PkgTools.a(paramToServiceMsg, 6);
                        }
                      }
                    }
                    else if ((paramObject.msg_type.get() == 529) && (paramObject.msg_subtype.get() == 11))
                    {
                      a("video_processor").a(3001, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject.msg_data.get().toByteArray() });
                    }
                  }
                }
              }
              else
              {
                if ("AccostSvc.ReqInsertBlackList".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  paramToServiceMsg = paramToServiceMsg.extraData.getString("insertUin");
                  if (paramFromServiceMsg.getResultCode() == 1000) {
                    e(paramToServiceMsg);
                  }
                  if (paramFromServiceMsg.getResultCode() == 1000) {}
                  for (bool1 = true;; bool1 = false)
                  {
                    a(6001, bool1, paramToServiceMsg);
                    break;
                  }
                }
                if ("OidbSvc.0x9db".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  k(paramToServiceMsg, paramFromServiceMsg, paramObject);
                }
                else
                {
                  if ("AccostSvc.ReqDeleteBlackList".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    paramObject = paramToServiceMsg.extraData.getString("deleteUin");
                    i1 = paramToServiceMsg.extraData.getInt("fromType");
                    if (paramFromServiceMsg.getResultCode() == 1000) {
                      f(paramObject);
                    }
                    if (paramFromServiceMsg.getResultCode() == 1000) {}
                    for (bool1 = true;; bool1 = false)
                    {
                      a(6002, bool1, new Object[] { paramObject, Integer.valueOf(i1) });
                      break;
                    }
                  }
                  if ("OidbSvc.0x4ff_42024".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  }
                  else if (("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) || ("PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str)))
                  {
                    if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action"))))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<<---handle response - get thirdqq unread number");
                      }
                      try
                      {
                        a().a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      }
                      catch (Exception paramObject)
                      {
                        paramObject.printStackTrace();
                        if (QLog.isColorLevel()) {
                          QLog.w("Q.msg.MessageHandler", 2, "handle response - get thirdqq unread number exception ! ", paramObject);
                        }
                        a().b(paramToServiceMsg, paramFromServiceMsg);
                      }
                    }
                    else
                    {
                      try
                      {
                        if (!a(paramToServiceMsg)) {
                          break label2829;
                        }
                        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      }
                      catch (Exception paramObject)
                      {
                        paramObject.printStackTrace();
                        if (QLog.isColorLevel()) {
                          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp exception ! ", paramObject);
                        }
                        o(paramToServiceMsg, paramFromServiceMsg);
                      }
                      continue;
                      label2829:
                      b(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullGroupMsgSeq)paramObject);
                    }
                  }
                  else if ("MessageSvc.PbGetGroupMsg".equalsIgnoreCase(str))
                  {
                    if (paramToServiceMsg.extraData.getBoolean("key_from_parallel_pull", false)) {
                      ThreadManager.post(new zgy(this, paramToServiceMsg, paramFromServiceMsg, paramObject), 8, null, false);
                    } else {
                      try
                      {
                        a(paramToServiceMsg, paramFromServiceMsg, paramObject, false);
                      }
                      catch (Exception paramObject)
                      {
                        paramObject.printStackTrace();
                        if (QLog.isColorLevel()) {
                          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", paramObject);
                        }
                        q(paramToServiceMsg, paramFromServiceMsg);
                      }
                    }
                  }
                  else if ("MessageSvc.PbGetDiscussMsg".equalsIgnoreCase(str))
                  {
                    try
                    {
                      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    }
                    catch (Exception paramObject)
                    {
                      paramObject.printStackTrace();
                      if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp_PB exception ! ", paramObject);
                      }
                      s(paramToServiceMsg, paramFromServiceMsg);
                    }
                  }
                  else
                  {
                    if (!"MessageSvc.RequestPushStatus".equalsIgnoreCase(str)) {
                      break label3273;
                    }
                    if (paramObject != null)
                    {
                      paramToServiceMsg = (RequestPushStatus)paramObject;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus status:" + paramToServiceMsg.cStatus + "supportdataline:" + paramToServiceMsg.cDataLine);
                      }
                      paramFromServiceMsg = (RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
                      b1 = 0;
                      if (paramToServiceMsg.cStatus == 1)
                      {
                        b1 = 1;
                        if (QLog.isDevelopLevel()) {
                          QLog.d("Q.msg.MessageHandler", 4, "PConline now");
                        }
                        t();
                      }
                      for (;;)
                      {
                        paramFromServiceMsg.a(b1);
                        paramFromServiceMsg.d(paramToServiceMsg.cDataLine);
                        paramFromServiceMsg.e(paramToServiceMsg.cPrintable);
                        paramFromServiceMsg.f(paramToServiceMsg.cViewPcFile);
                        paramFromServiceMsg.a(paramToServiceMsg.iPCVersion);
                        paramFromServiceMsg.b(paramToServiceMsg.nClientType);
                        paramFromServiceMsg.c(paramToServiceMsg.nInstanceId);
                        paramFromServiceMsg.d();
                        ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a(b1, paramToServiceMsg.cDataLine, paramToServiceMsg.cPrintable, paramToServiceMsg.cViewPcFile, paramToServiceMsg.iPCVersion);
                        a(6007, true, new Object[] { Byte.valueOf(b1), Byte.valueOf(paramToServiceMsg.cDataLine) });
                        break;
                        if (paramToServiceMsg.cStatus == 2)
                        {
                          b1 = 0;
                          if (QLog.isDevelopLevel()) {
                            QLog.d("Q.msg.MessageHandler", 4, "PCoffline now");
                          }
                          b(0);
                        }
                      }
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label3273:
    if ("StatSvc.SvcReqMSFLoginNotify".equalsIgnoreCase(str))
    {
      paramToServiceMsg = (SvcReqMSFLoginNotify)a(paramFromServiceMsg.getWupBuffer(), "SvcReqMSFLoginNotify", new SvcReqMSFLoginNotify());
      if (paramToServiceMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "SvcReqMSFLoginNotify status:" + paramToServiceMsg.cStatus + "iPlatform:" + paramToServiceMsg.iPlatform);
        }
        paramFromServiceMsg = (RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
        b1 = 0;
        if ((paramToServiceMsg.iPlatform == 110L) && (paramToServiceMsg.cTablet == 1)) {
          if (paramToServiceMsg.cStatus == 1)
          {
            b1 = 1;
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.MessageHandler", 4, "ipad online now");
            }
            u();
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramFromServiceMsg.b(b1);
        if (jdField_a_of_type_Int != 1) {
          break;
        }
        a(6014, true, new Object[] { Byte.valueOf(b1), Byte.valueOf(1) });
        jdField_a_of_type_Int = 1;
        break;
        if (paramToServiceMsg.cStatus != 2) {
          break label4127;
        }
        b1 = 0;
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.MessageHandler", 4, "ipad offline now");
        }
        b(1);
        continue;
        if (paramToServiceMsg.iPlatform != 1029L) {
          break;
        }
        if (paramToServiceMsg.cStatus == 1) {
          b1 = 1;
        }
        for (;;)
        {
          a(8033, true, new Object[] { Byte.valueOf(b1), Byte.valueOf(1) });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.MessageHandler", 2, "mac online push status:" + b1 + ",cDataline:" + 1);
          break;
          if (paramToServiceMsg.cStatus == 2) {
            b1 = 0;
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
        break;
        if ((!"OnlinePush.PbPushGroupMsg".equalsIgnoreCase(str)) && (!"OnlinePush.PbPushDisMsg".equalsIgnoreCase(str)) && (!"OnlinePush.PbC2CMsgSync".equalsIgnoreCase(str)) && (!"OnlinePush.PbPushC2CMsg".equalsIgnoreCase(str))) {
          break label3709;
        }
        try
        {
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MessageHandler", 2, "handleMessagePush_PB exception ! ", paramToServiceMsg);
      break;
      label3709:
      if ("MultiVideo.s2c".equalsIgnoreCase(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "Receive multi video message s2c ,cmd=MultiVideo.s2c");
        }
        if (!VideoConstants.jdField_a_of_type_Boolean) {
          break;
        }
        paramToServiceMsg = (MultiVideoMsg)a(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
        paramFromServiceMsg = paramToServiceMsg.video_buff;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg);
        if (paramToServiceMsg.type == 10) {
          break;
        }
        paramFromServiceMsg = a("MultiVideo.s2cack");
        paramFromServiceMsg.extraData.putByte("ver", paramToServiceMsg.ver);
        paramFromServiceMsg.extraData.putByte("type", paramToServiceMsg.type);
        paramFromServiceMsg.extraData.putShort("cscmd", paramToServiceMsg.csCmd);
        paramFromServiceMsg.extraData.putShort("subcmd", paramToServiceMsg.subCmd);
        paramFromServiceMsg.extraData.putLong("from_uin", paramToServiceMsg.from_uin);
        paramFromServiceMsg.extraData.putLong("to_uin", ((Long)paramToServiceMsg.to_uin.get(0)).longValue());
        paramFromServiceMsg.extraData.putLong("msg_seq", paramToServiceMsg.msg_seq);
        paramFromServiceMsg.extraData.putLong("msg_uid", paramToServiceMsg.msg_uid);
        paramFromServiceMsg.extraData.putLong("msg_type", paramToServiceMsg.msg_type);
        paramFromServiceMsg.extraData.putLong("msg_time", paramToServiceMsg.msg_time);
        paramFromServiceMsg.extraData.putByteArray("video_buff", paramToServiceMsg.video_buff);
        paramFromServiceMsg.extraData.putLong("msg_dataflag", paramToServiceMsg.msg_dataflag);
        a(paramFromServiceMsg);
        break;
      }
      if ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(str))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((byte[])paramObject);
        break;
      }
      if ("MultiVideo.c2sack".equalsIgnoreCase(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "Receive multi video message C2SACK ,cmd=MultiVideo.c2sack");
        }
        if (!VideoConstants.jdField_a_of_type_Boolean) {
          break;
        }
        paramToServiceMsg = ((MultiVideoMsg)a(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg())).video_buff;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramToServiceMsg);
        break;
      }
      if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(str))
      {
        y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        break;
      }
      if (!"OidbSvc.0xb31".equalsIgnoreCase(str)) {
        break;
      }
      z(paramToServiceMsg, paramFromServiceMsg, paramObject);
      break;
      label4127:
      b1 = 0;
    }
  }
  
  public void a(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    c(localArrayList);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ReqInsertBlackList");
    localToServiceMsg.extraData.putString("insertUin", paramString);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------addFriendTipsMr friendUin: " + paramString + ", sourceId=" + paramInt);
    }
    if ((paramInt == 2007) || (paramInt == 3007) || (paramInt == 4007) || (paramInt == 2017) || (paramInt == 3017)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(paramString).longValue(), true, paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        paramString = (MessageHandler.GreetingMsg)this.jdField_e_of_type_JavaUtilHashMap.get(paramString);
        if (paramString != null) {
          a(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_c_of_type_JavaLangString, paramString.jdField_a_of_type_Long, paramString.jdField_a_of_type_JavaLangString, paramString.jdField_b_of_type_Long, paramString.jdField_a_of_type_Int, paramString.jdField_b_of_type_Int, paramString.jdField_c_of_type_Long);
        }
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1))
    {
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1);
      paramString.time = paramLong2;
      paramString.extraflag = 0;
      a().a(paramString);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1))
    {
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1);
      paramString.shmsgseq = paramLong2;
      paramString.time = paramLong3;
      paramString.extraflag = 0;
      a().a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    if (MsgProxyUtils.a(paramInt) == 1032) {}
    do
    {
      do
      {
        return;
      } while (!MsgProxyUtils.a(paramString, paramInt));
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramBoolean);
    } while ((paramString == null) || (paramString.toByteArray() == null));
    paramInt = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = paramInt + 1;
    long l1 = paramInt;
    long l2 = System.currentTimeMillis();
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    a(l1, localSendMessageHandler);
    paramInt = 0;
    int i1;
    for (;;)
    {
      i1 = i2;
      if (paramInt >= 9) {
        break;
      }
      localSendMessageHandler.a(new zgu(this, paramString, l2, l1));
      paramInt += 1;
    }
    label121:
    if (i1 < 3) {
      if (i1 != 0) {
        break label176;
      }
    }
    label176:
    for (l1 = 480000L;; l1 = (3 - i1) * 480000 / 3 - i1 * 2000)
    {
      l2 = i1 * 480000 / 3;
      localSendMessageHandler.getClass();
      localSendMessageHandler.a(l2, l1, "period");
      i1 += 1;
      break label121;
      break;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    Object localObject;
    int i1;
    msg_svc.PbGetRoamMsgReq localPbGetRoamMsgReq;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getRoamMsgByTime friendUin: " + paramString + " beginTime: " + paramLong1 + " endTime: " + paramLong3 + " middleTime: " + paramLong2 + " maxCnt: " + paramShort + " random: " + paramLong4 + " subcmd：" + paramInt1);
      localObject = new StringBuilder().append("--->>getRoamMsgByTime req_type: ").append(paramInt2).append(", ticket length: ");
      if (paramArrayOfByte == null)
      {
        i1 = 0;
        QLog.d("Q.msg.MessageHandler", 2, i1 + ", fetchMore: " + paramBoolean1 + ", fetchNum: " + paramInt3 + ", isPreloadType: " + paramBoolean2);
      }
    }
    else
    {
      if ((paramLong4 == 0L) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      localObject = a("MessageSvc.PbGetRoamMsg");
      ((ToServiceMsg)localObject).extraData.putLong("lBeginTime", paramLong1);
      ((ToServiceMsg)localObject).extraData.putLong("lEndTime", paramLong3);
      ((ToServiceMsg)localObject).extraData.putBoolean("fetchMore", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putInt("fetchNum", paramInt3);
      ((ToServiceMsg)localObject).extraData.putString("peerUin", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("preloadType", paramBoolean2);
      localPbGetRoamMsgReq = new msg_svc.PbGetRoamMsgReq();
      if ((paramLong4 != 0L) || (paramLong2 != 0L)) {
        break label450;
      }
      localPbGetRoamMsgReq.last_msgtime.set(paramLong3);
      label325:
      localPbGetRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetRoamMsgReq.random.set(paramLong4);
      paramString = localPbGetRoamMsgReq.read_cnt;
      if (paramShort == 0) {
        break label463;
      }
      label358:
      paramString.set(paramShort);
      localPbGetRoamMsgReq.subcmd.set(paramInt1);
      localPbGetRoamMsgReq.begin_msgtime.set(paramLong1);
      localPbGetRoamMsgReq.check_pwd.set(1);
      localPbGetRoamMsgReq.req_type.set(paramInt2);
      if (paramArrayOfByte != null)
      {
        if (paramInt2 != 0) {
          break label471;
        }
        localPbGetRoamMsgReq.pwd.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).putWupBuffer(localPbGetRoamMsgReq.toByteArray());
      b((ToServiceMsg)localObject);
      return;
      i1 = paramArrayOfByte.length;
      break;
      label450:
      localPbGetRoamMsgReq.last_msgtime.set(paramLong2);
      break label325;
      label463:
      paramShort = 1000;
      break label358;
      label471:
      localPbGetRoamMsgReq.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
  }
  
  public void a(String paramString, long paramLong1, short paramShort, Bundle paramBundle, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getRoamMsgInOneDay friendUin: " + paramString + " reqLastMsgTime: " + paramLong1 + " readCnt: " + paramShort + " random: " + paramLong2);
    }
    long l1 = paramLong2;
    Object localObject;
    if (paramLong2 == 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString);
      if (localObject != null) {
        break label234;
      }
      l1 = 0L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay:" + paramLong1);
      }
      paramLong2 = paramLong1;
      if (paramLong1 == 0L) {
        paramLong2 = MessageCache.a();
      }
      localObject = a("MessageSvc.PbGetOneDayRoamMsg");
      msg_svc.PbGetOneDayRoamMsgReq localPbGetOneDayRoamMsgReq = new msg_svc.PbGetOneDayRoamMsgReq();
      localPbGetOneDayRoamMsgReq.last_msgtime.set(paramLong2);
      localPbGetOneDayRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetOneDayRoamMsgReq.random.set(l1);
      localPbGetOneDayRoamMsgReq.read_cnt.set(paramShort);
      ((ToServiceMsg)localObject).putWupBuffer(localPbGetOneDayRoamMsgReq.toByteArray());
      if (paramBundle != null) {
        ((ToServiceMsg)localObject).extraData.putBundle("context", paramBundle);
      }
      b((ToServiceMsg)localObject);
      return;
      label234:
      paramLong2 = ((Long)((Pair)localObject).second).longValue();
      l1 = paramLong2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay rand=" + paramLong2);
        l1 = paramLong2;
      }
    }
  }
  
  public void a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    a(paramString1, paramLong, paramBoolean, paramString2, -1, null);
  }
  
  public void a(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------addTroopTipsMr troopUin: " + paramString1);
    }
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = NetConnInfoCenter.getServerTime();
    }
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.joinSplitMsg", 2, "addFriendTipsMr troopUin=" + paramString1);
    }
    localTroopHandler.a(paramString1, paramString2, paramInt, paramString3);
    int i1;
    if (paramBoolean)
    {
      paramString2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, 1);
      if (paramString2 != null)
      {
        paramString2 = paramString2.iterator();
        paramInt = 0;
        i1 = paramInt;
        if (!paramString2.hasNext()) {
          break label205;
        }
        paramString3 = (MessageRecord)paramString2.next();
        if ((Math.abs(paramString3.time - l1) >= 30L) || (paramString3.msgtype != -5021)) {
          break label309;
        }
        paramInt = 1;
      }
    }
    label309:
    for (;;)
    {
      break;
      i1 = 0;
      label205:
      if (i1 == 0) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString1, 8);
      }
      try
      {
        for (;;)
        {
          paramLong = Long.parseLong(paramString1);
          l1 = Long.parseLong(paramString1);
          long l2 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 0, l1, paramLong, l2, "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, false, true);
          return;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString1, 8);
        }
      }
      catch (NumberFormatException paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.MessageHandler", 2, "troopCode not long type!");
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localFriendsManager.a(localFriendsManager.a(paramString1, paramString2));
    }
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, BusinessObserver paramBusinessObserver)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return;
    }
    paramBusinessObserver = a("TransService.ReqTmpChatPicDownload", paramBusinessObserver);
    paramBusinessObserver.extraData.putString("selfuin", paramString1);
    paramBusinessObserver.extraData.putString("filekey", paramString2);
    paramBusinessObserver.extraData.putByte("picscale", paramByte);
    a(paramBusinessObserver);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong1, long paramLong2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    for (long l1 = 0L; l1 < 3L; l1 += 1L) {
      localSendMessageHandler.postDelayed(new zgo(this, l1, paramString1, paramString2, paramByte, paramString3, paramLong1, paramLong2), 30000L * l1);
    }
    a(paramLong1, localSendMessageHandler);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "addGreetingMsg | uin is empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, String.format(Locale.getDefault(), "addGreetingMsg uin=%s, mobile=%s, addationMsg=%s, sourceid=%s, subSourceid=%s, requin=%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong3) }));
    }
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      if (paramLong2 == this.jdField_b_of_type_Long) {
        return;
      }
    }
    Object localObject1;
    if (((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramString1))
    {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, 0);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramString3 = new UniteGrayTipParam(paramString1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433039), 0, -5040, 655362, paramLong2);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString3);
        UniteGrayTipUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
        break label1029;
        if (paramInt2 == 0) {
          break label1051;
        }
        paramString3 = new UniteGrayTipParam(paramString1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), "该好友通过群成员快速添加，建议为对方 设置分组 和 设置备注 。", 0, -5040, 135179, paramLong2);
        paramString3.jdField_c_of_type_JavaLangString = "该好友通过群成员快速添加，建议为对方 设置分组 和 设置备注 。";
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 14);
        ((Bundle)localObject1).putString("key_action_DATA", "from_batch_add_frd_for_troop");
        paramInt2 = "该好友通过群成员快速添加，建议为对方 设置分组 和 设置备注 。".indexOf("设置分组");
        int i1 = "该好友通过群成员快速添加，建议为对方 设置分组 和 设置备注 。".indexOf("设置分组");
        paramString3.a(paramInt2, "设置分组".length() + i1, (Bundle)localObject1);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 13);
        ((Bundle)localObject1).putString("key_action_DATA", "from_batch_add_frd_for_troop");
        paramString3.a("该好友通过群成员快速添加，建议为对方 设置分组 和 设置备注 。".indexOf("设置备注"), "该好友通过群成员快速添加，建议为对方 设置分组 和 设置备注 。".indexOf("设置备注") + "设置备注".length(), (Bundle)localObject1);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString3);
        UniteGrayTipUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
        break label1051;
      }
    }
    for (;;)
    {
      label440:
      boolean bool = EAddFriendSourceID.a(paramInt1);
      if (paramInt2 != 0)
      {
        paramString3 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
        paramString3.init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433037), paramLong2, -1013, 3, paramLong2);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 14);
        paramString3.addHightlightItem(18, 22, (Bundle)localObject1);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 13);
        paramString3.addHightlightItem(23, 27, (Bundle)localObject1);
        paramString3.isread = true;
        a(paramString3);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007978", "0X8007978", 0, 0, "", "", "", "");
      }
      if ((bool) && (!TextUtils.isEmpty(paramString2)))
      {
        bool = ((PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "addGreetingMsg | deleted = " + bool);
        }
        if (bool) {
          a(8030, true, paramString2);
        }
      }
      if (this.jdField_e_of_type_JavaUtilHashMap.get(paramString1) != null) {
        this.jdField_e_of_type_JavaUtilHashMap.remove(paramString1);
      }
      this.jdField_b_of_type_Long = paramLong2;
      label709:
      return;
      MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
      localMessageForText.frienduin = paramString1;
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433038);
      label763:
      String str;
      if (paramLong3 == this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
      {
        paramString3 = "我通过了你的好友请求，现在我们可以开始聊天了。";
        str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (!TextUtils.isEmpty(paramString3)) {
          break label1073;
        }
      }
      for (;;)
      {
        localMessageForText.init(str, paramString1, paramString1, (String)localObject1, paramLong2, -1000, 0, paramLong2);
        localMessageForText.isread = true;
        if (paramLong1 != -1L) {
          localMessageForText.vipBubbleID = paramLong1;
        }
        a(localMessageForText);
        if ((!TextUtils.isEmpty(paramString3)) && (paramLong3 != this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))
        {
          localObject1 = ContactUtils.l(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
          paramString3 = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString3 = paramString1;
          }
          localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
          ((MessageForGrayTips)localObject1).init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, String.format("你已经和%s成为好友，现在可以开始聊天了。", new Object[] { paramString3 }), paramLong2, -1013, 0, paramLong2);
          ((MessageForGrayTips)localObject1).isread = true;
          a((MessageRecord)localObject1);
        }
        ((NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(paramString1);
        break label1029;
        localObject1 = new MessageHandler.GreetingMsg();
        ((MessageHandler.GreetingMsg)localObject1).jdField_b_of_type_JavaLangString = paramString1;
        ((MessageHandler.GreetingMsg)localObject1).jdField_a_of_type_JavaLangString = paramString3;
        ((MessageHandler.GreetingMsg)localObject1).jdField_a_of_type_Long = paramLong1;
        ((MessageHandler.GreetingMsg)localObject1).jdField_b_of_type_Long = paramLong2;
        ((MessageHandler.GreetingMsg)localObject1).jdField_a_of_type_Int = paramInt1;
        ((MessageHandler.GreetingMsg)localObject1).jdField_b_of_type_Int = paramInt2;
        ((MessageHandler.GreetingMsg)localObject1).jdField_c_of_type_JavaLangString = paramString2;
        ((MessageHandler.GreetingMsg)localObject1).jdField_c_of_type_Long = paramLong3;
        this.jdField_e_of_type_JavaUtilHashMap.put(paramString1, localObject1);
        break label709;
        break label763;
        label1029:
        if ((paramInt1 != 2093) && (paramInt1 != 3093)) {
          break label1080;
        }
        paramInt2 = 1;
        break;
        label1051:
        if ((paramInt1 != 3078) && (paramInt1 != 3079)) {
          break label1086;
        }
        paramInt2 = 1;
        break label440;
        label1073:
        localObject1 = paramString3;
      }
      label1080:
      paramInt2 = 0;
      break;
      label1086:
      paramInt2 = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, short paramShort, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
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
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, short paramShort, long paramLong)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString1, "StreamSvr.RespPushStreamMsg");
    localToServiceMsg.extraData.putString("selfuin", paramString1);
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putString("filepath", paramString3);
    localToServiceMsg.extraData.putShort("PackSeq", paramShort);
    localToServiceMsg.extraData.putLong("lkey", paramLong);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString1 + "." + paramString2, 1000, paramBoolean1, null, paramInt, paramBoolean2, paramBoolean3, null);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_JavaUtilHashSet.add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        ConfigUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int i2 = 0;
    ToServiceMsg localToServiceMsg = a("MessageSvc.DelMsgV2");
    long[] arrayOfLong;
    Object localObject;
    short[] arrayOfShort;
    int i1;
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      arrayOfLong = new long[paramArrayList1.size()];
      localObject = new int[paramArrayList1.size()];
      arrayOfShort = new short[paramArrayList1.size()];
      i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        arrayOfLong[i1] = ((zha)paramArrayList1.get(i1)).jdField_a_of_type_Long;
        localObject[i1] = ((zha)paramArrayList1.get(i1)).jdField_a_of_type_Int;
        arrayOfShort[i1] = ((zha)paramArrayList1.get(i1)).jdField_a_of_type_Short;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i1 + " fromUin:" + arrayOfLong[i1] + " msgTime: " + localObject[i1] + " msgSeq:" + arrayOfShort[i1]);
        }
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("fromUin", arrayOfLong);
      localToServiceMsg.extraData.putIntArray("msgTime", (int[])localObject);
      localToServiceMsg.extraData.putShortArray("msgSeq", arrayOfShort);
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramArrayList1 = new long[paramArrayList2.size()];
      arrayOfLong = new long[paramArrayList2.size()];
      localObject = new long[paramArrayList2.size()];
      arrayOfShort = new short[paramArrayList2.size()];
      i1 = i2;
      while (i1 < paramArrayList2.size())
      {
        paramArrayList1[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).jdField_a_of_type_Long;
        arrayOfLong[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).jdField_b_of_type_Long;
        localObject[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).jdField_c_of_type_Long;
        arrayOfShort[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).jdField_a_of_type_Short;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i1 + " fromUin:" + paramArrayList1[i1] + " msgId: " + localObject[i1] + " msgType:" + arrayOfShort[i1]);
        }
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("accostFromUin", paramArrayList1);
      localToServiceMsg.extraData.putLongArray("accostToUin", arrayOfLong);
      localToServiceMsg.extraData.putLongArray("accostMsgId", (long[])localObject);
      localToServiceMsg.extraData.putShortArray("accostMsgType", arrayOfShort);
    }
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    label17:
    MessageRecord localMessageRecord;
    label66:
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localMessageRecord = (MessageRecord)paramArrayList.next();
        if ((!(localMessageRecord instanceof MessageForPic)) && (!(localMessageRecord instanceof MessageForMixedMsg))) {
          break label231;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord, 3);
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label448;
        }
        localObject2 = (MessageForStructing)localMessageRecord;
        if (((MessageForStructing)localObject2).structingMsg != null)
        {
          if ((localMessageRecord.isread) || (((MessageForStructing)localObject2).structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mResid))) {
            break label450;
          }
          localObject1 = (VipGiftManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
          paramBoolean = ((VipGiftManager)localObject1).a((MessageForStructing)localObject2);
          localObject2 = ((VipGiftManager)localObject1).a();
          if ((paramBoolean) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (localObject2 != null) && (((VipGiftDownloadInfo)localObject2).d == 0L) && (((VipGiftDownloadInfo)localObject2).jdField_a_of_type_Long != 0L)) {
            ((VipGiftManager)localObject1).a(((VipGiftDownloadInfo)localObject2).jdField_a_of_type_Long);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord, 1);
      break label17;
      break;
      label231:
      if ((localMessageRecord instanceof MessageForShortVideo))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForShortVideo)localMessageRecord);
        break label66;
      }
      if ((localMessageRecord instanceof MessageForPtt))
      {
        PTTPreDownloader.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a((MessageForPtt)localMessageRecord);
        int i1 = 4;
        if (localMessageRecord.istroop == 0) {
          i1 = 1;
        }
        for (;;)
        {
          PttInfoCollector.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i1, false, 3);
          break;
          if (localMessageRecord.istroop == 1) {
            i1 = 3;
          } else if (localMessageRecord.istroop == 3000) {
            i1 = 2;
          }
        }
      }
      if (((localMessageRecord instanceof MessageForLongTextMsg)) && (localMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("3")))
      {
        ((MessageForLongTextMsg)localMessageRecord).loading = true;
        localObject1 = localMessageRecord.getExtInfoFromExtStr("long_text_msg_resid");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          QLog.e("Q.msg.MessageHandler", 1, "LongTextMsg resid is null!");
        }
        LongTextMsgManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, (String)localObject1);
        break label66;
      }
      if (!(localMessageRecord instanceof MessageForScribble)) {
        break label66;
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForScribble)localMessageRecord);
      break label66;
      label448:
      break label17;
      label450:
      if (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 35) {
        MultiMsgManager.a().a((MessageForStructing)localObject2, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      } else if (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 107) {
        MultiMsgManager.a().a((MessageForStructing)localObject2, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      int i1 = 0;
      while (i1 < paramList.size())
      {
        String str = String.valueOf(paramList.get(i1));
        if (!TextUtils.isEmpty(str))
        {
          boolean bool = localFriendsManager.a(str);
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.MessageHandler", 2, "removeFriendFromBlackList:" + str + " isBlack:" + bool);
          }
          if (bool) {
            f(str);
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg)
  {
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv msg0x210.Submsgtype0x51");
    }
    if (paramMsgType0x210.sub_msg_type.get() != 81) {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush submsgtype != 0x51");
      }
    }
    do
    {
      do
      {
        return;
        if (paramMsgType0x210.msg_content != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush msg_content is null");
      return;
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      if (paramMsgType0x210 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush decode ox210Stream is null");
    return;
    new SubMsgType0x51.MsgBody();
    for (;;)
    {
      try
      {
        SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210);
        if (!localMsgBody.bytes_qrsig_url.has()) {
          break label348;
        }
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint1.has()) {
          break label343;
        }
        paramMsg = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint2.has()) {
          break label338;
        }
        str = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_login_conf.has()) {
          arrayOfByte = localMsgBody.bytes_login_conf.get().toByteArray();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + paramMsg + " smalltip" + str);
        }
        EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, paramMsg, str, arrayOfByte);
        return;
      }
      catch (Exception paramMsgType0x210) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      return;
      label338:
      String str = null;
      continue;
      label343:
      paramMsg = null;
      continue;
      label348:
      paramMsgType0x210 = null;
    }
  }
  
  public void a(short paramShort, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = a("MessageSvc.SetRoamMsgAllUser");
    localToServiceMsg.extraData.putShort("shType", paramShort);
    localToServiceMsg.extraData.putByte("cValue", paramByte);
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Msg Pull Finish picPreDownloadOn");
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    LoadingStateManager.a().a(3);
    a(6005, paramBoolean, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getC2CMessage:isPullRoamMsg:" + paramBoolean + " ,pullMsgType:" + paramInt);
    }
    a((byte)3, null, 0, paramBoolean, true, false, null, paramInt, null);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
    int i1;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i1 = 0;
      if ((i1 < localList.size()) && (i1 < 40)) {}
    }
    else
    {
      b(false);
      c(false);
      if (!a()) {
        break label472;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint getNewPushMsg");
      }
      a(false, 0);
    }
    label472:
    do
    {
      return;
      RecentUser localRecentUser = (RecentUser)localList.get(i1);
      int i2;
      if (localRecentUser.type == 1)
      {
        i2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(localRecentUser.uin);
        if (((i2 == 1) || (i2 == 4)) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localRecentUser.uin, 1))) {}
      }
      for (;;)
      {
        i1 += 1;
        break;
        Pair localPair = a(localRecentUser.uin, 1);
        i2 = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint troopUin: " + localRecentUser.uin + " msg count: " + i2);
        }
        if (i2 > 0)
        {
          try
          {
            a(localRecentUser.uin, ((Long)localPair.first).longValue() + 1L, ((Long)localPair.second).longValue(), false, null, 0);
          }
          catch (Exception localException1) {}
          continue;
          if ((localException1.type == 3000) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localException1.uin, 3000)))
          {
            localPair = a(localException1.uin, 3000);
            i2 = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint discUin: " + localException1.uin + " msg count: " + i2);
            }
            if (i2 > 0) {
              try
              {
                a(Long.valueOf(localException1.uin).longValue(), 1L + ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue(), false, null);
              }
              catch (Exception localException2) {}
            }
          }
        }
      }
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint syncC2CMsg");
        }
        a(true, 1);
      }
    } while (!paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint syncPAMsg");
    }
    a(true, 2);
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgNew: " + this.jdField_h_of_type_Boolean);
      }
      return this.jdField_h_of_type_Boolean;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(paramLong1), 3000);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getPullDiscussionMsg uin: " + paramLong1 + " beginSeq: " + paramLong2 + " endSeq: " + paramLong3 + " delSeq: " + l1);
    }
    if ((paramLong2 < 0L) || (paramLong3 < 0L)) {
      return false;
    }
    Pair localPair = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(paramLong1));
    if (localPair == null) {
      return false;
    }
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbGetDiscussMsg");
    localToServiceMsg.extraData.putLong("lDisUin", paramLong1);
    localToServiceMsg.extraData.putLong("lBeginSeq", paramLong2);
    localToServiceMsg.extraData.putLong("lEndSeq", paramLong3);
    localToServiceMsg.extraData.putBoolean("isRefreshHead", paramBoolean);
    localToServiceMsg.extraData.putBundle("context", paramBundle);
    localToServiceMsg.extraData.putLong("dwLastInfoSeq", ((Long)localPair.first).longValue());
    localToServiceMsg.extraData.putLong("dwLastGetTime", ((Long)localPair.second).longValue());
    paramBundle = new msg_svc.PbGetDiscussMsgReq();
    paramBundle.begin_seq.set(paramLong2);
    paramBundle.end_seq.set(paramLong3);
    paramBundle.discuss_uin.set(paramLong1);
    paramBundle.discuss_info_seq.set(((Long)localPair.first).longValue());
    paramBundle.last_get_time.set(((Long)localPair.second).longValue());
    localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
    c(localToServiceMsg);
    return true;
  }
  
  public boolean a(long paramLong, SendMessageHandler paramSendMessageHandler)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
      {
        this.jdField_d_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramSendMessageHandler);
        paramSendMessageHandler.jdField_a_of_type_Long = paramLong;
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "sendQueue alread has msgSeq[" + paramLong + "]");
      }
      return false;
    }
  }
  
  public boolean a(SendMessageHandler paramSendMessageHandler, String paramString)
  {
    boolean bool2 = false;
    long l1 = paramSendMessageHandler.a(System.currentTimeMillis());
    boolean bool3;
    if (l1 < 450000L)
    {
      l1 = 480000L - l1 - 5000L;
      bool3 = paramSendMessageHandler.a(0L, l1, paramString);
      bool1 = bool3;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage scheduleSuccess[" + bool3 + "] msgSeq[" + paramSendMessageHandler.jdField_a_of_type_Long + "] timeout[" + l1 + "] reason[" + paramString + "]");
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      if ((bool1) || (!paramSendMessageHandler.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage Wait SendMessage Retry");
        }
        bool1 = true;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage No unfinished retry attampt.");
      return false;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.GetMsgV4");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbGetMsg");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbBindUinGetMsg");
      this.jdField_b_of_type_JavaUtilSet.add("PbMessageSvc.PbBindUinMsgReadedConfirm");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d0_1");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.DelMsgV2");
      this.jdField_b_of_type_JavaUtilSet.add("TransService.ReqOffFilePack");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PushNotify");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.SetRoamMsgAllUser");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.DelRoamMsg");
      this.jdField_b_of_type_JavaUtilSet.add("PbMessageSvc.PbMsgReadedReport");
      this.jdField_b_of_type_JavaUtilSet.add("ADMsgSvc.PushMsg");
      this.jdField_b_of_type_JavaUtilSet.add("VideoSvc.Send");
      this.jdField_b_of_type_JavaUtilSet.add("VideoCCSvc.Adaptation");
      this.jdField_b_of_type_JavaUtilSet.add("SharpSvr.c2sack");
      this.jdField_b_of_type_JavaUtilSet.add("SharpSvr.s2c");
      this.jdField_b_of_type_JavaUtilSet.add("MultiVideo.c2sack");
      this.jdField_b_of_type_JavaUtilSet.add("MultiVideo.s2c");
      this.jdField_b_of_type_JavaUtilSet.add("OnlinePush.RespPush");
      this.jdField_b_of_type_JavaUtilSet.add("OnlinePush.ReqPush");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PushReaded");
      this.jdField_b_of_type_JavaUtilSet.add("TransService.ReqTmpChatPicDownload");
      this.jdField_b_of_type_JavaUtilSet.add("TransService.ReqGetSign");
      this.jdField_b_of_type_JavaUtilSet.add("OnlinePush.PbPushTransMsg");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbSendMsg");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xa89");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbMultiMsgSend");
      this.jdField_b_of_type_JavaUtilSet.add("SecSvcBlessingHelper.blessing_helper");
      this.jdField_b_of_type_JavaUtilSet.add("StreamSvr.RespUploadStreamMsg");
      this.jdField_b_of_type_JavaUtilSet.add("StreamSvr.PushStreamMsg");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.ClientMsg");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.SvrMsg");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.ReqInsertBlackList");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x9db");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.ReqGetBlackList");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_42024");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.ReqDeleteBlackList");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbGetDiscussMsg");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbGetGroupMsg");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PullGroupMsgSeq");
      this.jdField_b_of_type_JavaUtilSet.add("PbMessageSvc.PbUnReadMsgSeq");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.RequestPushStatus");
      this.jdField_b_of_type_JavaUtilSet.add("OnlinePush.PbPushGroupMsg");
      this.jdField_b_of_type_JavaUtilSet.add("OnlinePush.PbPushDisMsg");
      this.jdField_b_of_type_JavaUtilSet.add("OnlinePush.PbPushC2CMsg");
      this.jdField_b_of_type_JavaUtilSet.add("OnlinePush.PbC2CMsgSync");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.PbGetMsg");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.GetMsgV2");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.PullGroupMsgSeq");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.PullDisMsgSeq");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.PullDisGroupSeq");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.NoticeEnd");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.PbGetGroupMsg");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.PbGetDiscussMsg");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.getOffMsg");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.infoLogin");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.infoSync");
      this.jdField_b_of_type_JavaUtilSet.add("RegPrxySvc.PbSyncMsg");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.SvcReqMSFLoginNotify");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbGetRoamMsg");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbGetOneDayRoamMsg");
      this.jdField_b_of_type_JavaUtilSet.add("PbMessageSvc.PbSearchRoamMsgInCloud");
      this.jdField_b_of_type_JavaUtilSet.add("PbMessageSvc.PbDelOneRoamMsg");
      this.jdField_b_of_type_JavaUtilSet.add("PbMessageSvc.PbMsgWithDraw");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgRead");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgAction");
      this.jdField_b_of_type_JavaUtilSet.add("NearFieldTranFileSvr.NotifyList");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgNew");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgNew.Friend");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgNew.Group");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5cf_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_42073");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_42073");
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbReceiptRead");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xb31");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, 1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "--->>getPullTroopMsg troopUin2: " + paramString + " beginSeq: " + paramLong1 + " endSeq: " + paramLong2 + " delSeq: " + l1 + " pull num : " + (paramLong2 - paramLong1 + 1L) + " doSome:" + paramInt + " ThreadId:" + Thread.currentThread().getId());
    }
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      return false;
    }
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbGetGroupMsg");
    localToServiceMsg.extraData.putString("groupuin", paramString);
    localToServiceMsg.extraData.putLong("lBeginSeq", paramLong1);
    localToServiceMsg.extraData.putLong("lEndSeq", paramLong2);
    localToServiceMsg.extraData.putBoolean("isRefreshHead", paramBoolean);
    localToServiceMsg.extraData.putBundle("context", paramBundle);
    localToServiceMsg.extraData.putInt("doSome", paramInt);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    Object localObject = localToServiceMsg.extraData;
    if ((paramBundle != null) && (paramBundle.getBoolean("key_from_parallel_pull", false))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((Bundle)localObject).putBoolean("key_from_parallel_pull", paramBoolean);
      paramBundle = new msg_svc.PbGetGroupMsgReq();
      paramBundle.group_code.set(Long.valueOf(paramString).longValue());
      paramBundle.begin_seq.set(paramLong1);
      paramBundle.end_seq.set(paramLong2);
      localObject = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      paramBundle.public_group.set(((HotChatManager)localObject).a(paramString));
      localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
      c(localToServiceMsg);
      return true;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramBoolean1) && ((!paramBoolean2) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause));
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List paramList)
  {
    if ((!paramBoolean3) && (a(paramBoolean1, paramBoolean2))) {}
    for (paramBoolean1 = true; (paramBoolean1) && (paramList != null) && (paramList.size() > 0) && ((MsgProxyUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramList.get(0))) || (MsgProxyUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramList.get(0)))); paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenTroopDebug", 2, "opentroop and hotchattroop msg not notify.");
      }
      return false;
    }
    return paramBoolean1;
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
    PkgTools.a(arrayOfByte, 4, (byte[])localObject, 0, localObject.length);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>createGetMsgReq");
    }
    return arrayOfByte;
  }
  
  public byte[] a(boolean paramBoolean)
  {
    Object localObject = new msg_svc.PbGetMsgReq();
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      if (arrayOfByte != null) {
        ((msg_svc.PbGetMsgReq)localObject).pubaccount_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      ((msg_svc.PbGetMsgReq)localObject).msg_req_type.set(2);
    }
    for (;;)
    {
      ((msg_svc.PbGetMsgReq)localObject).sync_flag.set(0);
      ((msg_svc.PbGetMsgReq)localObject).ramble_flag.set(0);
      ((msg_svc.PbGetMsgReq)localObject).context_flag.set(1);
      ((msg_svc.PbGetMsgReq)localObject).online_sync_flag.set(0);
      ((msg_svc.PbGetMsgReq)localObject).latest_ramble_number.set(20);
      ((msg_svc.PbGetMsgReq)localObject).other_ramble_number.set(3);
      localObject = ((msg_svc.PbGetMsgReq)localObject).toByteArray();
      arrayOfByte = new byte[localObject.length + 4];
      PkgTools.a(arrayOfByte, 4, (byte[])localObject, 0, localObject.length);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>createGetMsgReq ,isPubAccount:" + paramBoolean);
      }
      return arrayOfByte;
      arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      if (arrayOfByte != null) {
        ((msg_svc.PbGetMsgReq)localObject).sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      ((msg_svc.PbGetMsgReq)localObject).msg_req_type.set(1);
    }
  }
  
  public int b(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int i1 = a(localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = a(2, paramLong1, paramLong2, paramInt1, paramInt2);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      localSendMessageHandler.a(new zgv(this, localPbSendMsgReq, i1, paramLong2));
      paramInt1 += 1;
    }
    paramInt1 = 0;
    while (paramInt1 <= 3)
    {
      paramLong1 = paramInt1 * 30000L / 3L;
      localSendMessageHandler.getClass();
      localSendMessageHandler.a(paramLong1, 10000L, "period");
      paramInt1 += 1;
    }
    return i1;
  }
  
  public void b()
  {
    a(6006, true, null, true);
  }
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(null, paramInt, paramBoolean, paramObject, 0, false, false, null);
  }
  
  public void b(long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ReqGetBlackList");
    localToServiceMsg.extraData.putLong("lNextMid", paramLong);
    a(localToServiceMsg);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x9db.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    ((cmd0x9db.ReqBody)localObject).rpt_uint64_id.set(localArrayList);
    ((cmd0x9db.ReqBody)localObject).uint32_sequence.set(paramInt1);
    localObject = a("OidbSvc.0x9db", 2523, 0, ((cmd0x9db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("insertTinnyid", paramLong);
    ((ToServiceMsg)localObject).extraData.putInt("fromType", paramInt2);
    b((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramToServiceMsg, paramInt, paramBoolean, paramObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "req or resp is null");
      }
    }
    do
    {
      do
      {
        return;
        if (paramToServiceMsg.extraData.containsKey("msgSeq")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, "no msgSeq");
      return;
      long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
      int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      long l2 = paramFromServiceMsg.getResultCode();
      long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 9223372036854775807L);
      SendMessageHandler localSendMessageHandler = a(l1);
      if (localSendMessageHandler != null)
      {
        paramFromServiceMsg = MessageHandlerUtils.a(paramToServiceMsg, paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---TimeConsume---> cmd[" + paramToServiceMsg.getServiceCmd() + "] seq[" + l1 + "] retryIndex[" + i1 + "] " + paramFromServiceMsg[0] + "");
        }
        localSendMessageHandler.a(i1, l2, l3, paramFromServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "can not found handler");
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramToServiceMsg = (RespGetBlackList)paramObject;
      if (paramToServiceMsg.stHeader.eReplyCode == 0)
      {
        int i2 = paramToServiceMsg.vBlackListUin.size();
        if (i2 > 0)
        {
          paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          int i1 = 0;
          while (i1 < i2)
          {
            paramObject = ((Long)paramToServiceMsg.vBlackListUin.get(i1)).longValue() + "";
            if (!paramFromServiceMsg.b(paramObject)) {
              paramFromServiceMsg.b(paramObject);
            }
            i1 += 1;
          }
        }
        if (paramToServiceMsg.lNextMid != -1L) {
          break label135;
        }
      }
    }
    return;
    label135:
    b(paramToServiceMsg.lNextMid);
  }
  
  public void b(String paramString)
  {
    b(paramString, 0);
  }
  
  public void b(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ReqDeleteBlackList");
    localToServiceMsg.extraData.putString("deleteUin", paramString);
    localToServiceMsg.extraData.putInt("fromType", paramInt);
    a(localToServiceMsg);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramString1, paramString2);
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    a(paramArrayList, true);
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    msg_svc.PbUnReadMsgSeqReq localPbUnReadMsgSeqReq = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbPullGroupMsgSeqReq localPbPullGroupMsgSeqReq = new msg_svc.PbPullGroupMsgSeqReq();
    int i2 = paramList.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq localGroupInfoReq = new msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq();
        try
        {
          long l1 = Long.parseLong((String)paramList.get(i1));
          localGroupInfoReq.group_code.set(l1);
          localGroupInfoReq.last_seq.set(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i((String)paramList.get(i1)));
          localPbPullGroupMsgSeqReq.group_info_req.add(localGroupInfoReq);
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
    localPbUnReadMsgSeqReq.group_unread_info.set(localPbPullGroupMsgSeqReq);
    paramList = a("PbMessageSvc.PbUnReadMsgSeq");
    paramList.putWupBuffer(localPbUnReadMsgSeqReq.toByteArray());
    paramList.extraData.putBoolean("RequestFromPublicAccountChatPie", true);
    b(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("saveTroopMsgFilter. troopSettingList size=");
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        break label75;
      }
    }
    label75:
    for (int i1 = 0;; i1 = this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      QLog.d("Q.msg.MessageHandler", 2, i1);
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        DBUtils.a().a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_b_of_type_JavaUtilArrayList = null;
        bool = true;
      }
      return bool;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------resetGetMsgFlag ");
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
  }
  
  public void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
  
  public void c(long paramLong)
  {
    Object localObject = new oidb_0xb31.ReqBody();
    ((oidb_0xb31.ReqBody)localObject).uint64_to.set(paramLong);
    ((oidb_0xb31.ReqBody)localObject).uint64_from.set(0L);
    localObject = a("OidbSvc.0xb31", 2865, 0, ((oidb_0xb31.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("toUin", paramLong);
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getCommonHobbyForAIOShow.");
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.setNeedRemindSlowNetwork(true);
    b(paramToServiceMsg);
  }
  
  /* Error */
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: checkcast 1204	[B
    //   4: checkcast 1204	[B
    //   7: astore 7
    //   9: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +55 -> 67
    //   15: new 241	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 5524
    //   25: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 1103	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   32: invokevirtual 560	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: ldc_w 1824
    //   38: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: astore_1
    //   42: aload 7
    //   44: ifnull +344 -> 388
    //   47: aload 7
    //   49: arraylength
    //   50: istore 4
    //   52: ldc 145
    //   54: iconst_2
    //   55: aload_1
    //   56: iload 4
    //   58: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: invokestatic 5529	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual 5532	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   75: astore_1
    //   76: aload_2
    //   77: ifnull +334 -> 411
    //   80: aload_2
    //   81: invokevirtual 1103	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   84: ifeq +327 -> 411
    //   87: aload 7
    //   89: ifnull +322 -> 411
    //   92: new 2609	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 2610	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: aload 7
    //   103: invokevirtual 2612	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: pop
    //   107: aload_2
    //   108: getfield 2615	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 2247	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   114: ifeq +297 -> 411
    //   117: aload_2
    //   118: getfield 2615	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: invokevirtual 1303	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   124: ifne +287 -> 411
    //   127: new 5534	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   130: dup
    //   131: invokespecial 5535	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   134: astore 7
    //   136: aload 7
    //   138: aload_2
    //   139: getfield 2620	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   142: invokevirtual 2624	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   145: invokevirtual 2625	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   148: invokevirtual 5536	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   151: pop
    //   152: aload 7
    //   154: getfield 5539	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   157: invokevirtual 5540	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   160: ifle +251 -> 411
    //   163: aload 7
    //   165: getfield 5539	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   168: iconst_0
    //   169: invokevirtual 3292	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   172: checkcast 5542	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   175: getfield 5545	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_preload_disable_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   178: invokevirtual 1303	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   181: istore 4
    //   183: aload_1
    //   184: monitorenter
    //   185: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +31 -> 219
    //   191: ldc_w 5547
    //   194: iconst_2
    //   195: new 241	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 5549
    //   205: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload 4
    //   210: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_1
    //   220: iconst_1
    //   221: putfield 5552	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   224: iload 4
    //   226: iconst_1
    //   227: if_icmpne +190 -> 417
    //   230: iconst_1
    //   231: istore 5
    //   233: aload_1
    //   234: getfield 5555	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   237: ifnull +209 -> 446
    //   240: iload 4
    //   242: ifne +241 -> 483
    //   245: aload_1
    //   246: getfield 5556	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   249: iconst_1
    //   250: if_icmpne +182 -> 432
    //   253: iconst_1
    //   254: istore 5
    //   256: iload 5
    //   258: istore 6
    //   260: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +35 -> 298
    //   266: ldc_w 5547
    //   269: iconst_2
    //   270: new 241	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 5558
    //   280: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload 5
    //   285: invokevirtual 560	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   288: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: iload 5
    //   296: istore 6
    //   298: aload_0
    //   299: getfield 271	com/tencent/mobileqq/app/MessageHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: iload 6
    //   304: invokestatic 5563	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   307: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +13 -> 323
    //   313: ldc_w 5565
    //   316: iconst_2
    //   317: ldc_w 5567
    //   320: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_1
    //   324: getfield 5555	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   327: ifnull +132 -> 459
    //   330: aload_1
    //   331: getfield 5570	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   334: ifnull +125 -> 459
    //   337: aload_1
    //   338: getfield 5555	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   341: getfield 5575	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   344: ifeq +115 -> 459
    //   347: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +13 -> 363
    //   353: ldc_w 5565
    //   356: iconst_2
    //   357: ldc_w 5577
    //   360: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: getfield 271	com/tencent/mobileqq/app/MessageHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   367: iconst_4
    //   368: invokevirtual 1109	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   371: checkcast 5560	com/tencent/mobileqq/app/ConfigHandler
    //   374: astore_2
    //   375: aload_3
    //   376: aload_1
    //   377: getfield 5555	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   380: aload_2
    //   381: invokevirtual 5580	com/tencent/mobileqq/app/upgrade/UpgradeController:a	(Lprotocol/KQQConfig/UpgradeInfo;Lcom/tencent/mobileqq/app/upgrade/UpgradeController$OnHandleUpgradeFinishListener;)Z
    //   384: pop
    //   385: aload_1
    //   386: monitorexit
    //   387: return
    //   388: iconst_m1
    //   389: istore 4
    //   391: goto -339 -> 52
    //   394: astore_2
    //   395: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +13 -> 411
    //   401: ldc 145
    //   403: iconst_2
    //   404: ldc_w 494
    //   407: aload_2
    //   408: invokestatic 5582	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   411: iconst_0
    //   412: istore 4
    //   414: goto -231 -> 183
    //   417: iload 4
    //   419: iconst_2
    //   420: if_icmpne +66 -> 486
    //   423: invokestatic 5529	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   426: invokevirtual 5583	com/tencent/mobileqq/app/upgrade/UpgradeController:b	()V
    //   429: goto +57 -> 486
    //   432: aload_1
    //   433: getfield 5556	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   436: iconst_2
    //   437: if_icmpne +46 -> 483
    //   440: iconst_0
    //   441: istore 5
    //   443: goto -187 -> 256
    //   446: aload_1
    //   447: iload 4
    //   449: putfield 5584	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   452: iload 5
    //   454: istore 6
    //   456: goto -158 -> 298
    //   459: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -77 -> 385
    //   465: ldc_w 5565
    //   468: iconst_2
    //   469: ldc_w 5586
    //   472: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: goto -90 -> 385
    //   478: astore_2
    //   479: aload_1
    //   480: monitorexit
    //   481: aload_2
    //   482: athrow
    //   483: goto -227 -> 256
    //   486: iconst_0
    //   487: istore 5
    //   489: goto -256 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	this	MessageHandler
    //   0	492	1	paramToServiceMsg	ToServiceMsg
    //   0	492	2	paramFromServiceMsg	FromServiceMsg
    //   0	492	3	paramObject	Object
    //   50	398	4	i1	int
    //   231	257	5	bool1	boolean
    //   258	197	6	bool2	boolean
    //   7	157	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   92	183	394	java/lang/Throwable
    //   185	219	478	finally
    //   219	224	478	finally
    //   233	240	478	finally
    //   245	253	478	finally
    //   260	294	478	finally
    //   298	323	478	finally
    //   323	363	478	finally
    //   363	385	478	finally
    //   385	387	478	finally
    //   423	429	478	finally
    //   432	440	478	finally
    //   446	452	478	finally
    //   459	475	478	finally
    //   479	481	478	finally
  }
  
  public void c(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("MessageSvc.DelRoamMsg");
    localToServiceMsg.extraData.putString("uin", paramString);
    a(localToServiceMsg);
  }
  
  public void c(String paramString, int paramInt)
  {
    int i1 = 0;
    Object localObject = new String[1];
    localObject[0] = paramString;
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getPullTroopMsgNumber_PB troopUinArray.length: " + localObject.length + " troopUinArray:" + Arrays.toString((Object[])localObject) + ", lastSeqAry:" + Arrays.toString(arrayOfLong) + ", doSome:" + paramInt);
    }
    paramString = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbPullGroupMsgSeqReq localPbPullGroupMsgSeqReq = new msg_svc.PbPullGroupMsgSeqReq();
    for (;;)
    {
      if (i1 < localObject.length)
      {
        msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq localGroupInfoReq = new msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq();
        try
        {
          long l1 = Long.parseLong(localObject[i1]);
          localGroupInfoReq.group_code.set(l1);
          localGroupInfoReq.last_seq.set(arrayOfLong[i1]);
          localPbPullGroupMsgSeqReq.group_info_req.add(localGroupInfoReq);
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
    paramString.group_unread_info.set(localPbPullGroupMsgSeqReq);
    localObject = a("PbMessageSvc.PbUnReadMsgSeq");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("doSome", paramInt);
    b((ToServiceMsg)localObject);
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localTroopManager.a(localTroopManager.a(paramString1, paramString2));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    synchronized (this.jdField_b_of_type_ArrayOfInt)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean c()
  {
    return ((f()) && (g())) || (!jdField_d_of_type_Boolean);
  }
  
  public void d()
  {
    if (a().hasMessages(2)) {
      a().removeMessages(2);
    }
    a().a();
  }
  
  public void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    b(paramInt, paramBoolean, paramObject);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.extraData.getBoolean("switch", true);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
        int i1 = 1;
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      if (4 > paramToServiceMsg.length) {
        break label168;
      }
      paramToServiceMsg = String.valueOf(PkgTools.a(paramToServiceMsg, 0));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {
        break label168;
      }
      i1 = 0;
      if ((i1 != 0) && (QLog.isDevelopLevel())) {
        QLog.d("Q.msg.MessageHandler", 4, "toggle update value success");
      }
    }
  }
  
  public void d(String paramString)
  {
    if (a(paramString) != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "get openid key = " + paramString);
    }
    AccountManager localAccountManager = (AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    localHashMap.put("OpenAppid", paramString);
    localAccountManager.changeToken(localHashMap, new zgq(this, paramString));
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramBoolean) {}
    for (short s1 = 0;; s1 = 1)
    {
      ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)-23512).putShort((short)2).putShort(s1);
      localObject = a("OidbSvc.0x4ff_42024", 1279, 9, ((ByteBuffer)localObject).array());
      ((ToServiceMsg)localObject).extraData.putBoolean("key_subscribe_nearby_assistant_switch", paramBoolean);
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void e()
  {
    this.jdField_f_of_type_Int = 0;
    this.t = 0;
  }
  
  public void e(boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new zgs(this, paramBoolean), 10, null, false);
      return;
    }
    ConfessMsgUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false);
    ConfessMsgUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false);
    f(paramBoolean);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(false);
    b(false);
    a(false);
    c(false);
    d();
  }
  
  public void f(boolean paramBoolean)
  {
    int i3 = 0;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean);
    if ((localPbMsgReadedReportReq == null) || (localPbMsgReadedReportReq.toByteArray() == null)) {
      return;
    }
    int i1 = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i1 + 1;
    long l1 = i1;
    long l2 = System.currentTimeMillis();
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    a(l1, localSendMessageHandler);
    i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 9) {
        break;
      }
      localSendMessageHandler.a(new zgt(this, localPbMsgReadedReportReq, l2, l1));
      i1 += 1;
    }
    label104:
    if (i2 < 3) {
      if (i2 != 0) {
        break label154;
      }
    }
    label154:
    for (l1 = 480000L;; l1 = (3 - i2) * 480000 / 3 - i2 * 2000)
    {
      l2 = i2 * 480000 / 3;
      localSendMessageHandler.getClass();
      localSendMessageHandler.a(l2, l1, "period");
      i2 += 1;
      break label104;
      break;
    }
  }
  
  public void g()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handlePullLackGroupMsg-> New RegisterProxy End!");
      }
      h();
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          long l1 = System.currentTimeMillis();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(10000L);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "AllMsgThreadEndLock wait = " + (System.currentTimeMillis() - l1));
          }
        }
        this.jdField_f_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = false;
        i();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.msg.MessageHandler", 1, "handlePullLackGroupMsg exception!");
    }
  }
  
  public void g(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramBoolean) {}
    for (short s1 = 1;; s1 = 2)
    {
      ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)-23463).putShort((short)2).putShort(s1);
      localObject = a("OidbSvc.0x4ff_42073", 1279, 9, ((ByteBuffer)localObject).array());
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
    if (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache != null)
    {
      long l1 = System.currentTimeMillis();
      localObject1 = (PasswdRedBagManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
        if (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localObject2 = new HashMap();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
          localObject3 = MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (register_proxy.GroupList)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = String.valueOf(((register_proxy.GroupList)localObject4).group_code.get());
              this.jdField_b_of_type_JavaUtilHashMap.put(localObject5, Boolean.valueOf(((register_proxy.GroupList)localObject4).has_msg.get()));
              if (((register_proxy.GroupList)localObject4).redpack_time.get() > 0L) {
                ((HashMap)localObject2).put(localObject5, String.valueOf(((register_proxy.GroupList)localObject4).redpack_time.get()));
              }
            }
          }
          ((PasswdRedBagManager)localObject1).a((HashMap)localObject2);
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
      if (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
        if (MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b.size() > 0)
        {
          localObject3 = ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          int i1 = 1;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
            ((ArrayList)localObject2).add(((DiscussionInfo)localObject4).uin);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handleRegPrxyCache--> discussion" + i1 + ":" + ((DiscussionInfo)localObject4).uin);
            }
            i1 += 1;
          }
          localObject3 = (DiscussionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          HashMap localHashMap = new HashMap();
          Object localObject6 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
          localObject6 = MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            register_proxy.DiscussList localDiscussList = (register_proxy.DiscussList)((Iterator)localObject6).next();
            if (localDiscussList != null)
            {
              String str = String.valueOf(localDiscussList.discuss_code.get());
              this.jdField_c_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(localDiscussList.has_msg.get()));
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
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionVerify", 2, "REG_PROXY dis_cnt=" + ((ArrayList)localObject4).size() + " fav_cnt=" + ((ArrayList)localObject5).size());
          }
          i1 = 1;
          if (((ArrayList)localObject4).size() >= 100)
          {
            ((DiscussionHandler)localObject3).f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
            i1 = 0;
          }
          if ((!((ArrayList)localObject2).isEmpty()) && (i1 != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handleRegPrxyCache deleteDiscussList=" + ((ArrayList)localObject2).toArray());
            }
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject6 = (String)((Iterator)localObject2).next();
              ((DiscussionHandler)localObject3).a((String)localObject6);
              if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b((String)localObject6) != null) {
                this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d((String)localObject6);
              }
            }
          }
          a(1000, ((DiscussionHandler)localObject3).a((ArrayList)localObject4, (ArrayList)localObject5), null);
          ((PasswdRedBagManager)localObject1).b(localHashMap);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
      MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.jdField_a_of_type_JavaUtilList = null;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
      MessageCache.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$RegPrxyCache.b = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleRegPrxyCache end! cost:" + (System.currentTimeMillis() - l1));
      }
    }
  }
  
  public void i()
  {
    Object localObject1 = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject1).setLength(0);
      ((StringBuilder)localObject1).append("checkGroupMsgComplete-> troopNum:").append(this.jdField_b_of_type_Int).append(" ,discussionNum:").append(this.jdField_c_of_type_Int).append(" ,recvTroopNum:").append(this.jdField_l_of_type_Int).append(" ,recvDiscNum").append(this.m);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false)) && (this.jdField_b_of_type_Int == 0) && (this.jdField_c_of_type_Int == 0)) {
      return;
    }
    int i3 = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    Object localObject2;
    int i2;
    Iterator localIterator;
    String str;
    long l2;
    Object[] arrayOfObject;
    long l1;
    label357:
    int i1;
    if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.size() > 0))
    {
      localObject2 = new ArrayList();
      i2 = this.jdField_b_of_type_JavaUtilHashMap.size();
      localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(str);
        arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str);
        if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {}
        for (l1 = ((Long)arrayOfObject[1]).longValue();; l1 = 0L)
        {
          if (((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false)) && (!((Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(str)).booleanValue())) || (l2 >= l1)) {
            break label357;
          }
          if (QLog.isColorLevel())
          {
            ((StringBuilder)localObject1).setLength(0);
            ((StringBuilder)localObject1).append("---------checkGroupMsgComplete needToPullTroop troopUin: ").append(str).append(",lastSeq:").append(l2).append(",svrSeq:").append(l1);
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
          }
          ((ArrayList)localObject2).add(str);
          break;
        }
      }
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i3 = ((ArrayList)localObject2).size();
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[i3];
        i1 = 0;
        while (i1 < i3)
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i1] = ((String)((ArrayList)localObject2).get(i1));
          i1 += 1;
        }
        i1 = i3;
        this.jdField_b_of_type_JavaUtilHashMap.clear();
        i3 = i1;
      }
    }
    for (;;)
    {
      int i4;
      if ((this.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_c_of_type_JavaUtilHashMap.size() > 0))
      {
        localObject2 = new ArrayList();
        i4 = this.jdField_c_of_type_JavaUtilHashMap.size();
        localIterator = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
        label656:
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(str);
          arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str);
          if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {}
          for (l1 = ((Long)arrayOfObject[1]).longValue();; l1 = 0L)
          {
            if (((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false)) && (!((Boolean)this.jdField_c_of_type_JavaUtilHashMap.get(str)).booleanValue())) || (l2 >= l1)) {
              break label656;
            }
            if (QLog.isColorLevel())
            {
              ((StringBuilder)localObject1).setLength(0);
              ((StringBuilder)localObject1).append("---------checkGroupMsgComplete needToPullDiscuss discussUin: ").append(str).append(",lastSeq:").append(l2).append(",svrSeq:").append(l1);
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
            }
            ((ArrayList)localObject2).add(str);
            break;
          }
        }
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          int i5 = ((ArrayList)localObject2).size();
          this.jdField_b_of_type_ArrayOfJavaLangString = new String[i5];
          i1 = 0;
          while (i1 < i5)
          {
            this.jdField_b_of_type_ArrayOfJavaLangString[i1] = ((String)((ArrayList)localObject2).get(i1));
            i1 += 1;
          }
          i1 = i5;
          this.jdField_c_of_type_JavaUtilHashMap.clear();
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) || (this.jdField_b_of_type_ArrayOfJavaLangString != null))
        {
          a(4, true);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "needPullTroopNum:" + i3 + " ,needPullDiscNum:" + i1 + " ,regPrxyError:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false));
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_needpulltroop", String.valueOf(i3));
          ((HashMap)localObject1).put("param_needpulldisc", String.valueOf(i1));
          ((HashMap)localObject1).put("param_trooptotalnum", String.valueOf(i2));
          ((HashMap)localObject1).put("param_disctotalnum", String.valueOf(i4));
          localObject2 = StatisticCollector.a(BaseApplication.getContext());
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false)) {
            break label933;
          }
        }
        label933:
        for (boolean bool = true;; bool = false)
        {
          ((StatisticCollector)localObject2).a(null, "prxyRegNeedPullGroup", bool, 0L, 0L, (HashMap)localObject1, null);
          this.jdField_b_of_type_Int = 0;
          this.jdField_c_of_type_Int = 0;
          this.jdField_l_of_type_Int = 0;
          this.m = 0;
          return;
        }
        i1 = 0;
        break;
        i4 = 0;
        i1 = 0;
      }
      i1 = 0;
      break;
      i2 = 0;
    }
  }
  
  public void j()
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
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGroupMsgAfterSyncMsg --> troopUin:" + (String)localObject1);
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
              a("troop_processor").a(1001, arrayOfObject);
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
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGroupMsgAfterSyncMsg --> discUin:" + (String)localObject1);
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
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg begin.");
    }
    ConcurrentHashMap localConcurrentHashMap1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
    ArrayList localArrayList;
    Enumeration localEnumeration;
    String str;
    boolean bool;
    if ((localConcurrentHashMap1 != null) && (localConcurrentHashMap1.size() > 0))
    {
      try
      {
        localArrayList = new ArrayList();
        localEnumeration = localConcurrentHashMap1.keys();
        for (;;)
        {
          if (!localEnumeration.hasMoreElements()) {
            break label239;
          }
          str = (String)localEnumeration.nextElement();
          if (((Integer)localConcurrentHashMap1.get(str)).intValue() != 2) {
            break;
          }
          bool = true;
          if (!Boolean.valueOf(bool).booleanValue()) {
            localArrayList.add(str);
          }
        }
        localConcurrentHashMap2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    else
    {
      label113:
      ConcurrentHashMap localConcurrentHashMap2;
      if ((localConcurrentHashMap2 != null) && (localConcurrentHashMap2.size() > 0)) {
        try
        {
          localArrayList = new ArrayList();
          localEnumeration = localConcurrentHashMap2.keys();
          for (;;)
          {
            if (localEnumeration.hasMoreElements())
            {
              str = (String)localEnumeration.nextElement();
              if (((Integer)localConcurrentHashMap2.get(str)).intValue() == 2)
              {
                bool = true;
                label186:
                if (Boolean.valueOf(bool).booleanValue()) {
                  continue;
                }
                localArrayList.add(str);
                continue;
                if (!QLog.isColorLevel()) {
                  break;
                }
              }
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg end.");
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      return;
      bool = false;
      break;
      label239:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, troopSize=" + localArrayList.size());
      }
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        d((String)localIterator.next(), "flushDiscussionAndTroopMsg");
      }
      break label113;
      bool = false;
      break label186;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, disSize=" + localArrayList.size());
      }
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        e((String)localIterator.next(), "flushDiscussionAndTroopMsg");
      }
    }
  }
  
  public void l()
  {
    a(a("RegPrxySvc.getExtinfo"));
  }
  
  public void m()
  {
    if (!jdField_d_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ArrayOfZhb != null) {
          break label193;
        }
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(20);
        this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(10);
        this.jdField_a_of_type_ArrayOfZhb = new zhb[6];
        break label193;
        if (i1 < this.jdField_a_of_type_ArrayOfZhb.length)
        {
          if ((this.jdField_a_of_type_ArrayOfZhb[i1] != null) && (!this.jdField_a_of_type_ArrayOfZhb[i1].a())) {
            break label198;
          }
          if (i1 == 0)
          {
            this.jdField_a_of_type_ArrayOfZhb[i1] = new zhb(this, this.jdField_d_of_type_JavaUtilArrayList);
            this.jdField_a_of_type_ArrayOfZhb[i1].setName("MessageHandleThread" + (i1 + 1));
            this.jdField_a_of_type_ArrayOfZhb[i1].setPriority(5);
            this.jdField_a_of_type_ArrayOfZhb[i1].start();
            break label198;
          }
          this.jdField_a_of_type_ArrayOfZhb[i1] = new zhb(this, this.jdField_c_of_type_JavaUtilArrayList);
        }
      }
      return;
      label193:
      int i1 = 0;
      continue;
      label198:
      i1 += 1;
    }
  }
  
  public void n()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ArrayOfZhb != null)
      {
        int i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfZhb.length)
        {
          this.jdField_a_of_type_ArrayOfZhb[i1].a();
          i1 += 1;
        }
      }
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.notifyAll();
        this.jdField_d_of_type_JavaUtilArrayList = null;
        this.jdField_c_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_ArrayOfZhb = null;
        return;
      }
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] cleanRegisterProxyRandom");
    }
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void p()
  {
    ConcurrentHashMap localConcurrentHashMap;
    Object localObject1;
    Object localObject2;
    int i1;
    Object localObject3;
    String str;
    int i2;
    long l1;
    if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().d())
    {
      localConcurrentHashMap = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
      localObject1 = new ArrayList();
      localObject2 = localConcurrentHashMap.entrySet().iterator();
      i1 = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Iterator localIterator = ((ConcurrentHashMap)((Map.Entry)((Iterator)localObject2).next()).getValue()).entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (MessageCache.MsgSendingInfo)((Map.Entry)localIterator.next()).getValue();
          str = ((MessageCache.MsgSendingInfo)localObject3).jdField_a_of_type_JavaLangString;
          i2 = ((MessageCache.MsgSendingInfo)localObject3).jdField_a_of_type_Int;
          l1 = ((MessageCache.MsgSendingInfo)localObject3).jdField_a_of_type_Long;
          localObject3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l1);
          if (localObject3 == null)
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i2, l1);
          }
          else
          {
            if (!(localObject3 instanceof ChatMessage)) {
              break label778;
            }
            ((ChatMessage)localObject3).parse();
            if (!(localObject3 instanceof MessageForStructing)) {
              break label778;
            }
            MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
            if (localMessageForStructing.structingMsg == null) {
              break label778;
            }
            int i3 = localMessageForStructing.structingMsg.mMsgServiceID;
            if ((i3 != 35) && (i3 != 107)) {
              break label778;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "current mr is multimsg, uniseq: " + l1);
            }
            i1 = 1;
          }
        }
      }
    }
    label778:
    for (;;)
    {
      long l2 = ((MessageRecord)localObject3).time;
      long l3 = MessageCache.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:setMsgSendingInfo, uin:" + str + " istroop:" + i2 + " uniseq:" + l1 + " time:" + l2 + " currentServerTime:" + l3);
      }
      if ((i1 != 0) || ((l3 - l2) * 1000L + 30000L >= 480000L) || (l3 - l2 < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:msg sending flag set to failed");
        }
        localObject3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i2);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i2, l1);
        if ((localObject3 != null) && (((QQMessageFacade.Message)localObject3).uniseq == l1)) {
          ((QQMessageFacade.Message)localObject3).extraflag = 32768;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i2, l1, 32768, 1002);
        a(6003, false, new String[] { str, String.valueOf(l1) });
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:resend msg, key =" + ((MessageRecord)localObject3).uniseq + "+" + ((MessageRecord)localObject3).frienduin + "+" + ((MessageRecord)localObject3).istroop);
        }
        MsgProxyUtils.b((List)localObject1, (MessageRecord)localObject3, true);
      }
      break;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().d((MessageRecord)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "msgSending:addSendingCache suc");
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject2);
          if ((((MessageRecord)localObject2).msgtype == -1051) && ((localObject2 instanceof MessageForLongTextMsg)) && (((MessageForLongTextMsg)localObject2).structingMsg == null)) {
            ((LongTextMsgManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, true);
          } else {
            a((MessageRecord)localObject2, null, true);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:last, msgSendingTemp:" + localConcurrentHashMap);
      }
      localConcurrentHashMap.clear();
      return;
    }
  }
  
  public void q()
  {
    int i1 = 0;
    SharedPreferences localSharedPreferences;
    Object localObject1;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      localObject1 = localSharedPreferences.getString("msgSending", null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:init,read msgSending file," + (String)localObject1 + " msgCache:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().hashCode());
      }
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if (i1 < ((JSONArray)localObject1).length())
        {
          if (((JSONArray)localObject1).isNull(i1)) {
            break label349;
          }
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
          String str = ((JSONObject)localObject2).getString("uin");
          int i2 = ((JSONObject)localObject2).getInt("type");
          long l1 = ((JSONObject)localObject2).getLong("uniseq");
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str, i2, l1);
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l1);
          if (localObject2 == null) {
            break label349;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().d((MessageRecord)localObject2);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject2);
          if ((((MessageRecord)localObject2).msgtype != -1035) || (!(localObject2 instanceof MessageForMixedMsg))) {
            break label349;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, 32768, ((MessageRecord)localObject2).sendFailCode);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:init,read msgSending file," + localException.getMessage());
        }
        localException.printStackTrace();
        localSharedPreferences.edit().remove("msgSending").commit();
      }
      return;
      label349:
      i1 += 1;
    }
  }
  
  public void r()
  {
    try
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      if (localList == null) {
        break label206;
      }
      if (localList.size() == 0) {
        return;
      }
      if (!QLog.isColorLevel()) {
        break label201;
      }
      l1 = System.currentTimeMillis();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        List localList;
        long l1;
        TroopBindPublicAccountMgr localTroopBindPublicAccountMgr;
        int i2;
        if (QLog.isColorLevel())
        {
          QLog.e(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg exception ", localException);
          continue;
          label201:
          l1 = 0L;
        }
      }
    }
    localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    i2 = localList.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        register_proxy.GroupList localGroupList = (register_proxy.GroupList)localList.get(i1);
        String str = String.valueOf(localGroupList.group_code.get());
        long l2 = localGroupList.group_seq.get();
        if (!str.equals(localTroopBindPublicAccountMgr.a())) {
          MsgProxyUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, l2);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg: " + i2 + "," + (System.currentTimeMillis() - l1));
        }
        this.jdField_a_of_type_JavaUtilList = null;
        return;
        label206:
        return;
      }
      i1 += 1;
    }
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.MessageHandler", 2, "send_oidb_0x5eb_42073");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_preload_disable_flag.set(1);
      b(a("OidbSvc.0x5eb_42073", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.MessageHandler", 2, "send_oidb_0x5eb_42073 error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler
 * JD-Core Version:    0.7.0.1
 */