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
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.DeviceInfo;
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
import acme;
import acmp;
import acmw;
import acnh;
import acnk;
import acnt;
import acny;
import acnz;
import acos;
import acot;
import admh;
import agfe;
import aizi;
import akqe;
import allw;
import almg;
import almj;
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
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Pair;
import ansr;
import antl;
import antp;
import anvi;
import anvk;
import anvx;
import anwf;
import anyj;
import anyk;
import anyl;
import anym;
import anyn;
import anyo;
import anyp;
import anyq;
import anyr;
import anys;
import anyt;
import anyu;
import anyv;
import anyz;
import anza;
import aobd;
import aocn;
import aodl;
import aonn;
import aonp;
import aonw;
import aonx;
import aoob;
import aooi;
import aoon;
import aooo;
import aoop;
import aoou;
import aooy;
import aopk;
import aopm;
import aopp;
import aoxz;
import aqvh;
import aqwc;
import aqwd;
import asih;
import auui;
import avhz;
import avia;
import awth;
import awyr;
import axii;
import axio;
import axql;
import bahy;
import bbdk;
import bbxu;
import bcpt;
import bcpv;
import bcqj;
import bcrg;
import bcrj;
import bcrl;
import bcrn;
import bcrq;
import bcrr;
import bcrx;
import bcsa;
import bcsc;
import bcxj;
import bdla;
import bdnl;
import bdxj;
import bdxs;
import bfjz;
import bfkb;
import bgiy;
import bgkf;
import bgyo;
import bgzw;
import bhch;
import bhcl;
import bhdf;
import bibt;
import bibu;
import bjyi;
import bkxs;
import blys;
import blzs;
import bpup;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.pb.onlinepush.OnlinePushTrans.ExtGroupKeyInfo;
import com.tencent.pb.onlinepush.OnlinePushTrans.PbMsgInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
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
import lch;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
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
import msf.msgsvc.msg_svc.TransSvrInfo;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;
import msf.registerproxy.register_proxy.SvcPbResponsePullDisMsgProxy;
import msf.registerproxy.register_proxy.SvcRegisterProxyMsgResp;
import msf.registerproxy.register_proxy.SvcResponseMsgInfo;
import msf.registerproxy.register_proxy.SvcResponsePbPullGroupMsgProxy;
import mud;
import ntb;
import ntf;
import olh;
import omx;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_receipt.MsgInfo;
import tencent.im.msg.im_receipt.ReceiptInfo;
import tencent.im.msg.im_receipt.ReceiptReq;
import tencent.im.msg.im_receipt.ReceiptResp;
import tencent.im.oidb.cmd0x9db.cmd0x9db.ReqBody;
import tencent.im.oidb.cmd0x9db.cmd0x9db.RspBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.ReqBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.ReqBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.SimilarItem;
import tencent.im.oidb.cmd0xbad.oidb_0xbad.ReqBody;
import tencent.im.oidb.cmd0xefe.oidb_cmd0xefe.RspBody;
import tencent.im.oidb.oidb_0xd55.CheckAppSignReq;
import tencent.im.oidb.oidb_0xd55.CheckMiniAppReq;
import tencent.im.oidb.oidb_0xd55.CheckUserReq;
import tencent.im.oidb.oidb_0xd55.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqconnect.ConnectClientInfo;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;
import tencent.im.oidb.searcher.oidb_c2c_searcher.MsgKey;
import tencent.im.oidb.searcher.oidb_c2c_searcher.ReqBody;
import usu;
import uwe;
import zng;

public class MessageHandler
  extends BusinessHandler
  implements aooo
{
  static int jdField_a_of_type_Int = 1;
  public static boolean a;
  public static boolean b;
  public static int e;
  public static int f;
  public static boolean f;
  public long a;
  private final acny<String, Object> jdField_a_of_type_Acny = new acnz();
  private volatile Pair<RegisterPushNotice, Long> jdField_a_of_type_AndroidUtilPair;
  private anvi jdField_a_of_type_Anvi = new anyk(this);
  anyu jdField_a_of_type_Anyu;
  public bcrg a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public final HashMap<String, List<msg_comm.Msg>> a;
  private final HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  protected List<register_proxy.GroupList> a;
  private Map<String, acme> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private MessageHandler.MessageHandleThread[] jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private Thread jdField_b_of_type_JavaLangThread;
  private ArrayList<Setting> jdField_b_of_type_JavaUtilArrayList;
  private HashMap<String, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private final int[] jdField_b_of_type_ArrayOfInt = new int[0];
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  protected int c;
  private long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private ArrayList<anys> jdField_c_of_type_JavaUtilArrayList;
  private HashMap<String, Boolean> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public boolean c;
  protected int d;
  private long jdField_d_of_type_Long;
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private ArrayList<anys> jdField_d_of_type_JavaUtilArrayList;
  private final HashMap<Long, SendMessageHandler> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  protected boolean d;
  private HashMap<String, anyo> e;
  protected boolean e;
  public int g;
  private boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private final int jdField_l_of_type_Int = 450000;
  private boolean jdField_l_of_type_Boolean;
  private final int m = 9;
  private final int n = 3;
  private int o;
  private final int p = 2;
  private int q;
  private final int r = 3;
  private final int s = 6;
  
  static
  {
    jdField_b_of_type_Boolean = true;
    jdField_f_of_type_Boolean = true;
    jdField_e_of_type_Int = 200;
    jdField_f_of_type_Int = 500;
  }
  
  public MessageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_e_of_type_JavaUtilHashMap = new HashMap(10);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anvi, true);
    this.jdField_a_of_type_Bcrg = paramQQAppInterface.getMsgCache();
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("mobileQQ", 0);
    AppSetting.jdField_h_of_type_Boolean = paramQQAppInterface.getBoolean(AppSetting.jdField_b_of_type_JavaLangString, true);
    AppSetting.jdField_i_of_type_Boolean = paramQQAppInterface.getBoolean("c2c_del_msg_oper_enable", true);
  }
  
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyTroopMsgResp_PB return by null data");
    }
    label210:
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
          break label210;
        }
        try
        {
          localObject1 = ((register_proxy.SvcResponsePbPullGroupMsgProxy)localObject1).msg_content.get().toByteArray();
          int i1 = localObject1.length - 4;
          byte[] arrayOfByte = new byte[i1];
          PkgTools.copyData(arrayOfByte, 0, (byte[])localObject1, 4, i1);
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
  
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramObject = (SvcResponsePullDisMsgSeq)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDisMsgSeq.");
      }
      u(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  @Deprecated
  private void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1;
    SvcResponsePullDisGroupSeq localSvcResponsePullDisGroupSeq;
    StringBuilder localStringBuilder;
    if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      l1 = System.currentTimeMillis();
      localSvcResponsePullDisGroupSeq = (SvcResponsePullDisGroupSeq)paramObject;
      localStringBuilder = new StringBuilder(256);
      if (QLog.isColorLevel()) {
        localStringBuilder.append("registerproxy->handleMsgProxyDisGroupMsgSeq.");
      }
      if ((!paramFromServiceMsg.isSuccess()) || ((localSvcResponsePullDisGroupSeq != null) && (localSvcResponsePullDisGroupSeq.cReplyCode != 0))) {
        notifyUI(1000, false, null);
      }
    }
    else
    {
      return;
    }
    paramObject = null;
    if (localSvcResponsePullDisGroupSeq != null)
    {
      antl localantl = (antl)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      paramObject = new SvcResponsePullDisMsgSeq();
      paramObject.cReplyCode = localSvcResponsePullDisGroupSeq.cReplyCode;
      paramObject.strResult = localSvcResponsePullDisGroupSeq.strResult;
      if (localSvcResponsePullDisGroupSeq.vDisInfo != null)
      {
        akqe localakqe = (akqe)this.app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        HashMap localHashMap = new HashMap();
        paramObject.vConfNumInfo = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (QLog.isColorLevel()) {
          localStringBuilder.append(", size=").append(localSvcResponsePullDisGroupSeq.vDisInfo.size());
        }
        int i1 = 0;
        if (i1 < localSvcResponsePullDisGroupSeq.vDisInfo.size())
        {
          stDisGroupInfo localstDisGroupInfo = (stDisGroupInfo)localSvcResponsePullDisGroupSeq.vDisInfo.get(i1);
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
            paramObject.vConfNumInfo.add(localObject);
            localObject = new DiscussInfo();
            ((DiscussInfo)localObject).DiscussUin = localstDisGroupInfo.lDisCode;
            ((DiscussInfo)localObject).InfoSeq = localstDisGroupInfo.uInfoSeq;
            localArrayList.add(localObject);
            if (localstDisGroupInfo.lRedPackTime > 0L)
            {
              localHashMap.put(String.valueOf(localstDisGroupInfo.lDisCode), String.valueOf(localstDisGroupInfo.lRedPackTime));
              continue;
              localantl.a(String.valueOf(localstDisGroupInfo.lDisCode));
            }
          }
        }
        localakqe.b(localHashMap);
        localantl.a(localArrayList);
      }
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    u(paramToServiceMsg, paramFromServiceMsg, paramObject);
    MsgAutoMonitorUtil.getInstance().addProxySeqTime_Dis(System.currentTimeMillis() - l1);
  }
  
  private void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB.");
      }
      if (jdField_f_of_type_Boolean) {
        a(3, paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else
    {
      return;
    }
    E(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          PkgTools.copyData(arrayOfByte, 0, (byte[])localObject1, 4, i1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB. dataHash=" + paramObject.hashCode() + ", newDataHash=" + arrayOfByte.hashCode());
          }
          v(paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
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
  
  private void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      r(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i2 = paramToServiceMsg.extraData.getInt("doSome", 0);
    paramToServiceMsg = new StringBuilder();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg.append("<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: ").append(paramObject.result.get()).append(" ,doSome: ").append(i2);
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
    }
    this.q = 0;
    int i1 = 0;
    label245:
    long l2;
    long l1;
    label336:
    boolean bool;
    label368:
    long l3;
    if (i1 < paramObject.group_info_resp.get().size())
    {
      localObject1 = (msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)paramObject.group_info_resp.get().get(i1);
      paramFromServiceMsg = String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get());
      Object localObject2 = this.jdField_a_of_type_Bcrg.b(paramFromServiceMsg);
      l2 = this.jdField_a_of_type_Bcrg.j(paramFromServiceMsg);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label854;
      }
      l1 = ((Long)localObject2[0]).longValue();
      localObject2 = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localObject2 == null) || (!((HotChatManager)localObject2).b(paramFromServiceMsg))) {
        break label860;
      }
      bool = true;
      if (!bool)
      {
        this.jdField_a_of_type_Bcrg.c(paramFromServiceMsg, new Object[] { Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()), Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get()) });
        if (l1 < ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()) {
          this.app.getMessageFacade().setReadFrom(String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get()), 1, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get());
        }
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg.setLength(0);
        paramToServiceMsg.append("handleGetPullTroopMsgNumResp_PB getGroupMsgMemberSeq groupUin=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get()).append(" ,memberseq=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()).append(" ,groupSeq=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get()).append(" ,localMemberMsgSeq=").append(l1).append(" ,localLastSeq=").append(l2).append(", isHotChat=").append(bool);
        QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
      }
      l2 = this.jdField_a_of_type_Bcrg.a(paramFromServiceMsg, 1);
      localObject1 = a(paramFromServiceMsg, 1, this.jdField_a_of_type_Bcrg.b(paramFromServiceMsg), this.jdField_a_of_type_Bcrg.c(paramFromServiceMsg), l2, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get());
      int i3 = (int)(((Long)((Pair)localObject1).second).longValue() - ((Long)((Pair)localObject1).first).longValue());
      l2 = ((Long)((Pair)localObject1).first).longValue();
      l3 = ((Long)((Pair)localObject1).second).longValue();
      l2 = l3 - (l2 + 1L);
      if (l2 <= 10) {
        break label866;
      }
      l2 = l3 - 10 + 1L;
      label689:
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
        break label876;
      }
      ((bfkb)a("troop_processor")).a(paramFromServiceMsg, null, i2);
    }
    for (;;)
    {
      i1 += 1;
      break label245;
      break;
      label854:
      l1 = 0L;
      break label336;
      label860:
      bool = false;
      break label368;
      label866:
      l2 = l3 - l2;
      break label689;
      label876:
      a(paramFromServiceMsg, l2, l3, false, null, i2);
    }
  }
  
  private void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 1;
    if ("MessageSvc.RequestPushStatus".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        break label293;
      }
      paramToServiceMsg = (RequestPushStatus)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus status:" + paramToServiceMsg.cStatus + "supportdataline:" + paramToServiceMsg.cDataLine);
      }
      paramFromServiceMsg = (aocn)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
      if (paramToServiceMsg.cStatus != 1) {
        break label253;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "PConline now");
      }
      r();
      i1 = 1;
      if (!((zng)this.app.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).a(paramToServiceMsg.vecInstanceList)) {
        break label287;
      }
      i2 = (byte)i2;
      paramFromServiceMsg.b(i1);
      paramFromServiceMsg.e(paramToServiceMsg.cDataLine);
      paramFromServiceMsg.f(paramToServiceMsg.cPrintable);
      paramFromServiceMsg.g(paramToServiceMsg.cViewFile);
      paramFromServiceMsg.a(paramToServiceMsg.nPCVer);
      paramFromServiceMsg.b(paramToServiceMsg.nClientType);
      paramFromServiceMsg.c(paramToServiceMsg.nInstanceId);
      paramFromServiceMsg.a(i2);
      paramFromServiceMsg.c();
      paramFromServiceMsg.h(i1);
      ((ansr)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a().a(i1, paramToServiceMsg.cDataLine, paramToServiceMsg.cPrintable, paramToServiceMsg.cViewFile, paramToServiceMsg.nPCVer);
    }
    label253:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        if (paramToServiceMsg.cStatus == 2)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageHandler", 4, "PCoffline now");
          }
          b(0);
        }
        int i1 = 0;
        continue;
        i2 = 0;
      }
    }
    label287:
    label293:
    QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
  }
  
  private void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.infoSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        paramObject = new Bundle();
        paramObject.putParcelable("ToServiceMsg", paramToServiceMsg);
        paramObject.putParcelable("FromServiceMsg", paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request success!");
        }
        notifyUI(4004, true, paramObject);
      }
    }
    else {
      return;
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request timeout!");
      }
      notifyUI(4004, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request error!");
    }
    notifyUI(4004, false, null);
  }
  
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1;
    if ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg begin!");
      l1 = System.currentTimeMillis();
      paramObject = a((byte[])paramObject);
      if (paramObject != null) {
        break label44;
      }
    }
    label44:
    do
    {
      do
      {
        return;
      } while (!a(paramObject));
      if ((!paramObject.flag.has()) || (paramObject.flag.get() == 0)) {
        break;
      }
      int i1 = paramObject.flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleNewRegisterProxyMsg flag = " + i1);
      }
      bcrg localbcrg = this.jdField_a_of_type_Bcrg;
      if (bcrg.jdField_a_of_type_Bcrl == null)
      {
        localbcrg = this.jdField_a_of_type_Bcrg;
        bcrg.jdField_a_of_type_Bcrl = new bcrl();
      }
      b(paramObject);
      a("c2c_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.c2c_msg);
      a("pub_account_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.pub_account_msg);
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramObject);
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      c(i1);
      a(paramFromServiceMsg, i1);
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg end! cost :" + (System.currentTimeMillis() - l1));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---handleNewRegisterProxyMsg-->flag error!");
    }
    notifyUI(4004, false, null);
  }
  
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1;
    if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      l1 = paramToServiceMsg.extraData.getLong("msgSeq");
      if (a(l1) != null) {
        break label35;
      }
    }
    label35:
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
  
  private void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    long l4;
    long l5;
    long l1;
    Object localObject1;
    if ("OidbSvc.0xa89".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageRespPB enter");
      }
      str = paramToServiceMsg.extraData.getString("groupuin");
      l4 = paramToServiceMsg.extraData.getLong("msgSeq");
      l5 = paramToServiceMsg.extraData.getLong("uniseq");
      l1 = 0L;
      localObject1 = null;
    }
    try
    {
      Object localObject2 = new oidb_0xa89.RspBody();
      i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
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
        label421:
        label472:
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
            break label598;
          }
          paramObject = ((msg_svc.PbSendMsgResp)localObject1).errmsg.get();
          arrayOfObject[6] = paramObject;
          if ((i1 != 108) && (i1 != 102)) {
            break label672;
          }
          paramObject = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(str);
          if (paramObject == null) {
            break label605;
          }
          anwf.a(this.app, paramObject);
          bool = false;
        }
        for (;;)
        {
          label475:
          if (bool)
          {
            this.app.getMsgCache().a(str, 1026, l5);
            long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
            notifyUI(6003, true, new String[] { str, String.valueOf(l5) });
            long l2 = l3;
            if (l3 == 0L) {
              l2 = bcrg.a();
            }
            a(str, 1026, l5, l1, l2);
          }
          for (;;)
          {
            a(paramToServiceMsg, paramFromServiceMsg, i1, l5, bool);
            a(l4);
            c(paramToServiceMsg, paramFromServiceMsg);
            return;
            i2 = 0;
            break;
            label598:
            paramObject = "";
            break label421;
            label605:
            paramObject = this.app.getProxyManager().a();
            localObject1 = (RecentUser)paramObject.findRecentUserByUin(str, 1);
            if (localObject1 != null) {
              paramObject.delRecentUser((BaseRecentUser)localObject1);
            }
            a(1002, true, arrayOfObject);
            a(2001, true, arrayOfObject);
            a(2002, true, arrayOfObject);
            break label472;
            label672:
            if (i1 != 0) {
              break label708;
            }
            bool = true;
            break label475;
            a(arrayOfObject, paramFromServiceMsg.getUin(), i1);
            a(3013, false, arrayOfObject);
          }
          label708:
          bool = false;
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
  
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = a(l1);
      if (paramFromServiceMsg != null) {
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
      paramFromServiceMsg.getClass();
    } while (a(paramFromServiceMsg, "server"));
    if ((i1 == 0) || (i1 == 241)) {
      if (i3 == 1) {
        a(6015, true, new Long[] { Long.valueOf(i3), Long.valueOf(l1) });
      }
    }
    for (;;)
    {
      a(l1);
      return;
      label440:
      i2 = 0;
      break;
      a(6015, true, new Long[] { Long.valueOf(i3), Long.valueOf(l1), Long.valueOf(paramObject.receipt_resp.receipt_info.uint64_read_time.get()) });
      continue;
      a(paramToServiceMsg, paramObject);
      a(3021, true, new Long[] { Long.valueOf(i3), Long.valueOf(l1), Long.valueOf(i1) });
    }
  }
  
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow.");
    }
    long l1 = paramToServiceMsg.extraData.getLong("toUin");
    paramToServiceMsg = new oidb_0xb31.RspBody();
    int i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i1 == 0)
    {
      if (!paramToServiceMsg.items.has()) {
        break label481;
      }
      paramToServiceMsg = paramToServiceMsg.items.get();
      if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
        break label463;
      }
      paramToServiceMsg = (oidb_0xb31.SimilarItem)paramToServiceMsg.get(0);
      if (paramToServiceMsg == null) {
        break label445;
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
        ((aizi)this.mApp.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(paramFromServiceMsg.toString(), String.valueOf(l1));
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
      label445:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow index == 0 item is null.");
        continue;
        label463:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items is empty.");
          continue;
          label481:
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items not has.");
          }
        }
      }
    }
  }
  
  public static int a(int paramInt)
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
    case 1026: 
      return 3013;
    case 10008: 
      return 8043;
    }
    return 8045;
  }
  
  private int a(SendMessageHandler paramSendMessageHandler)
  {
    int i1;
    do
    {
      i1 = bcpv.jdField_a_of_type_Int;
      bcpv.jdField_a_of_type_Int = i1 + 1;
    } while (!a(i1, paramSendMessageHandler));
    return i1;
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt1 != 10002)
    {
      i1 = paramInt2;
      if (paramInt1 != 1001) {}
    }
    else
    {
      i1 = paramInt2;
      if (axql.a(paramInt2)) {
        if (paramInt2 == 48)
        {
          if (paramInt1 != 10002) {
            break label150;
          }
          i1 = 1;
          this.app.getMsgCache().i(paramString, null);
        }
      }
    }
    for (;;)
    {
      axql.a(this.app, paramString, i1);
      bdla.b(this.app, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_sig_expire", 0, 0, paramString, String.valueOf(paramInt1), String.valueOf(paramInt2), "");
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandlerQ.nearby.nearby_sig", 2, "handleSendC2CMessageResp_PB, 部落、附近的人临时会话因为签名失败, uinType:" + paramInt1 + "|replyCode:" + paramInt2);
      }
      i1 = 0;
      return i1;
      label150:
      this.app.getMsgCache().h(paramString, null);
      i1 = 0;
    }
  }
  
  private int a(msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    int i1 = 0;
    if ((paramPbSendMsgResp == null) || (!paramPbSendMsgResp.result.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
    }
    while (paramPbSendMsgResp.result.get() == 0) {
      return i1;
    }
    return paramPbSendMsgResp.result.get();
  }
  
  private Pair<Long, Long> a(String paramString, int paramInt)
  {
    long l1;
    long l2;
    long l3;
    Object localObject;
    if (paramInt == 3000)
    {
      l1 = this.jdField_a_of_type_Bcrg.h(paramString);
      l2 = this.jdField_a_of_type_Bcrg.d(paramString);
      l3 = this.jdField_a_of_type_Bcrg.a(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(128);
        ((StringBuilder)localObject).append("guessPullMsgStartSeq uin = ").append(paramString).append(" ,type = ").append(paramInt).append(" ,lastSeq = ").append(l1).append(" ,expiredSeq = ").append(l2).append(" ,delSeq = ").append(l3);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      List localList = this.app.getMessageFacade().getMsgList(paramString, paramInt);
      localObject = acnh.a(localList, false);
      l2 = Math.max(l3, l2);
      boolean bool1 = acnh.a(paramString, paramInt, (List)localObject);
      boolean bool2 = acnh.c((List)localObject);
      if ((!bool1) && (!bool2)) {
        break label767;
      }
      paramString = acnh.a(localList, false, 25);
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
          l1 = this.jdField_a_of_type_Bcrg.b(paramString);
          l2 = this.jdField_a_of_type_Bcrg.c(paramString);
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
      label767:
      paramString = (String)localObject;
    }
  }
  
  private Pair<Long, Long> a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getPullMsgLowSeq uin = " + paramString + " ,type = " + paramInt + " ,lastSeq = " + paramLong1 + " ,expiredSeq = " + paramLong2 + " ,delSeq = " + paramLong3 + " ,svrSeq = " + paramLong4);
    }
    paramString = acnh.a(this.app.getMessageFacade().getMsgList(paramString, paramInt), false);
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
  
  private anyu a()
  {
    if (this.jdField_a_of_type_Anyu == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Anyu == null) {
        this.jdField_a_of_type_Anyu = new anyu(this, ThreadManager.getSubThreadLooper());
      }
      return this.jdField_a_of_type_Anyu;
    }
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
    if (paramString != null) {
      localToServiceMsg.addAttribute("sso_push_timestamp", paramString + "|" + System.currentTimeMillis());
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
    if (paramMessageRecord.msg == null)
    {
      l1 = 0L;
      paramBusinessObserver = createToServiceMsg("MessageSvc.PbSendMsg", paramBusinessObserver);
      a(paramMessageRecord, paramBusinessObserver);
      int i1 = bcrx.b(paramMessageRecord.istroop, this.app);
      long l3 = paramMessageRecord.msgUid;
      int i2 = (short)(int)paramMessageRecord.msgseq;
      int i3 = bcsc.a(l3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, String.format("<PbSendMsg><S> --->createSendRichTextMsgReq, uint32Seq:%d, random:%d, routingType:%d, %s", new Object[] { Integer.valueOf(0xFFFF & i2), Integer.valueOf(i3), Integer.valueOf(i1), paramMessageRecord.getBaseInfoString() }));
      }
      paramBusinessObserver.extraData.putString("uin", paramMessageRecord.frienduin);
      paramBusinessObserver.extraData.putLong("msgsize", l1);
      paramBusinessObserver.extraData.putLong("uniseq", paramMessageRecord.uniseq);
      paramBusinessObserver.extraData.putLong("timeOut", paramLong);
      paramBusinessObserver.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
      paramBusinessObserver.extraData.putLong("startTime", l2);
      paramBusinessObserver.extraData.putInt("retryIndex", paramInt);
      paramBusinessObserver.extraData.putInt("uintype", paramMessageRecord.istroop);
      paramBusinessObserver.extraData.putInt("msgtype", paramMessageRecord.msgtype);
      paramBusinessObserver.extraData.putInt("ROUNTING_TYPE", i1);
      paramBusinessObserver.extraData.putInt("send_msg_req_size", paramBusinessObserver.getWupBuffer().length);
      paramBusinessObserver.putWupBuffer(paramPbSendMsgReq.toByteArray());
      paramBusinessObserver.setTimeout(paramLong);
      paramBusinessObserver.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
      paramBusinessObserver.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
      paramBusinessObserver.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
      paramBusinessObserver.addAttribute("retryIndex", Integer.valueOf(paramInt));
      if (paramMessageRecord.frienduin != null) {
        break label427;
      }
      paramPbSendMsgReq = "";
      label366:
      paramBusinessObserver.addAttribute("uin", paramPbSendMsgReq);
      if (paramMessageRecord.senderuin != null) {
        break label435;
      }
    }
    label427:
    label435:
    for (paramMessageRecord = "";; paramMessageRecord = paramMessageRecord.senderuin)
    {
      paramBusinessObserver.addAttribute("fromUin", paramMessageRecord);
      paramBusinessObserver.addAttribute("normal_msg", Boolean.valueOf(true));
      return paramBusinessObserver;
      l1 = paramMessageRecord.msg.getBytes().length;
      break;
      paramPbSendMsgReq = paramMessageRecord.frienduin;
      break label366;
    }
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
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB : Exception occurs whitl parsing the bytes.");
      }
    }
    return null;
  }
  
  @NotNull
  private msg_svc.PbGetMsgReq a(int paramInt1, int paramInt2, Object paramObject, byte[] paramArrayOfByte, byte paramByte)
  {
    msg_svc.PbGetMsgReq localPbGetMsgReq = new msg_svc.PbGetMsgReq();
    switch (paramInt2)
    {
    }
    for (;;)
    {
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
      localPbGetMsgReq.msg_req_type.set(0);
      if (paramArrayOfByte != null)
      {
        localPbGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        continue;
        localPbGetMsgReq.msg_req_type.set(1);
        if (paramArrayOfByte != null)
        {
          localPbGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
          continue;
          localPbGetMsgReq.msg_req_type.set(2);
          paramArrayOfByte = this.jdField_a_of_type_Bcrg.b();
          if (paramArrayOfByte != null) {
            localPbGetMsgReq.pubaccount_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
          }
        }
      }
    }
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
  
  @NonNull
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
      if (!QLog.isColorLevel()) {
        break label78;
      }
    }
    QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : invalid.", localException);
    StringBuilder localStringBuilder = new StringBuilder().append("<---handleSendC2CMessageResp_PB : data:");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
    {
      QLog.e("Q.msg.MessageHandler", 2, paramObject);
      label78:
      return new msg_svc.PbSendMsgResp();
    }
  }
  
  private register_proxy.SvcRegisterProxyMsgResp a(byte[] paramArrayOfByte)
  {
    Object localObject = new register_proxy.SvcRegisterProxyMsgResp();
    try
    {
      paramArrayOfByte = (register_proxy.SvcRegisterProxyMsgResp)((register_proxy.SvcRegisterProxyMsgResp)localObject).mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg package error!");
        }
        notifyUI(4004, false, null);
        localObject = null;
        return localObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg : decode SvcRegisterProxyMsgResp pb:", paramArrayOfByte);
              }
              paramArrayOfByte = null;
            }
            localObject = paramArrayOfByte;
          } while (!paramArrayOfByte.seq.has());
          localObject = paramArrayOfByte;
        } while (paramArrayOfByte.seq.get() == this.jdField_b_of_type_Int);
        localObject = paramArrayOfByte;
      } while (paramArrayOfByte.seq.get() == this.jdField_h_of_type_Int);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append("handleNewRegisterProxyMsg endSeq wrong! seq=").append(paramArrayOfByte.seq.get()).append(" registerProxyEndSeq=").append(this.jdField_b_of_type_Int).append(" registerProxyEndSeq_numTroop=").append(this.jdField_h_of_type_Int);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    a(4, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "needPullTroopNum:" + paramInt1 + " ,needPullDiscNum:" + paramInt2 + " ,regPrxyError:" + this.app.getMsgCache().a(false));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_needpulltroop", String.valueOf(paramInt1));
    localHashMap.put("param_needpulldisc", String.valueOf(paramInt2));
    localHashMap.put("param_trooptotalnum", String.valueOf(paramInt3));
    localHashMap.put("param_disctotalnum", String.valueOf(paramInt4));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    if (!this.app.getMsgCache().a(false)) {}
    for (;;)
    {
      localStatisticCollector.collectPerformance(null, "prxyRegNeedPullGroup", bool, 0L, 0L, localHashMap, null);
      return;
      bool = false;
    }
  }
  
  private void a(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 2))
      {
        String str = (String)paramObject[0];
        int i1 = ((Integer)paramObject[1]).intValue();
        if ((((Integer)paramObject[2]).intValue() == 55) && (paramInt != 8035)) {
          ((aodl)this.app.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER)).a(str, i1);
        }
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    almg localalmg = (almg)this.mApp.getManager(QQManagerFactory.TEMP_MSG_BOX);
    if (localalmg.b(paramString, paramInt)) {
      paramString = (Integer)almj.b().get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.intValue() >= 0)) {
        bdla.b(this.app, "dc00898", "", "", "0X800B1C3", "0X800B1C3", paramString.intValue(), 0, "", "", "", "");
      }
      return;
      if (localalmg.a(paramString, paramInt)) {
        paramString = Integer.valueOf(10000);
      } else {
        paramString = Integer.valueOf(-1);
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    String str = this.app.getCurrentAccountUin();
    long l1 = System.currentTimeMillis() / 1000L;
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord = bcsa.a(-2013);
    localMessageRecord.init(str, paramString2, str, paramString1, l1, 0, paramInt, 0L);
    localMessageRecord.msgtype = -2013;
    localMessageRecord.isread = true;
    localArrayList.add(localMessageRecord);
    this.app.getMessageFacade().addMessage(localArrayList, String.valueOf(str), false);
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, MessageRecord paramMessageRecord)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramBoolean2) && (paramInt1 == 1000) && (paramBoolean1 == true)) {
      if (paramInt2 > 0) {
        if (paramMessageRecord != null) {}
      }
    }
    for (;;)
    {
      try
      {
        paramMessageRecord = this.app;
        if (paramBoolean3) {
          break label123;
        }
        paramBoolean1 = bool1;
        paramMessageRecord.handleReceivedMessage(paramInt2, true, paramBoolean1);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        QQAppInterface localQQAppInterface;
        if (!QLog.isColorLevel()) {
          break label122;
        }
      }
      localQQAppInterface = this.app;
      if (!paramBoolean3)
      {
        paramBoolean1 = bool2;
        mud.a(localQQAppInterface, paramInt2, true, paramBoolean1, paramMessageRecord);
        return;
        QLog.w("notification", 2, "notification exception", paramMessageRecord);
        return;
      }
      paramBoolean1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "notification size = 0");
      }
      label122:
      return;
      label123:
      paramBoolean1 = false;
    }
  }
  
  private void a(SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify, List<Object> paramList)
  {
    if ((paramSvcRequestPushReadedNotify.vDisReadedNotify == null) || (paramSvcRequestPushReadedNotify.vDisReadedNotify.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList.addAll(paramSvcRequestPushReadedNotify.vDisReadedNotify);
      paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vDisReadedNotify.iterator();
      while (paramSvcRequestPushReadedNotify.hasNext())
      {
        paramList = (DisMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
        String str = String.valueOf(paramList.lDisUin);
        if (this.app.getMsgCache().b(str) == 1)
        {
          this.app.getMsgCache().a(str, paramList);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "DisMsgReadedNotify unfinished discussionUin=" + str);
          }
        }
        else
        {
          ((aonw)a("disc_processor")).a(paramList);
        }
      }
    }
  }
  
  private void a(SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify, List<Object> paramList, boolean paramBoolean)
  {
    if ((paramSvcRequestPushReadedNotify.vC2CReadedNotify == null) || (paramSvcRequestPushReadedNotify.vC2CReadedNotify.size() <= 0)) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        paramList = (bdxs)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
        paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
        int i1 = 0;
        while (paramSvcRequestPushReadedNotify.hasNext())
        {
          C2CMsgReadedNotify localC2CMsgReadedNotify = (C2CMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
          String str1 = Long.toString(localC2CMsgReadedNotify.lPeerUin);
          String str2 = Long.toString(localC2CMsgReadedNotify.lBindedUin);
          int i2 = paramList.a(str2, str1);
          i1 += i2;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify C2CMsgReadedNotify curFriendUin is " + localC2CMsgReadedNotify.lPeerUin + ", lLastReadTime  is " + localC2CMsgReadedNotify.lLastReadTime + " isSubAccount=" + paramBoolean + " changed=" + i2);
          }
          if (i1 != 0)
          {
            this.app.getConversationFacade().d(str2, 7000, i1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify subUin=" + str2 + "increaseUnread=" + i1);
            }
          }
          this.app.getMessageFacade().setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, str2 });
        }
      }
      else
      {
        paramList.addAll(paramSvcRequestPushReadedNotify.vC2CReadedNotify);
        paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
        while (paramSvcRequestPushReadedNotify.hasNext())
        {
          paramList = (C2CMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "C2CMsgReadedNotify curFriendUin is " + paramList.lPeerUin + ", lLastReadTime  is " + paramList.lLastReadTime + " isSubAccount=" + paramBoolean);
          }
          ((acmp)a("c2c_processor")).a(paramList);
        }
      }
    }
  }
  
  public static void a(anyt paramanyt, QQAppInterface paramQQAppInterface)
  {
    int i1 = 2;
    Object localObject = new StringBuilder(256);
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).append("msg send cost per phase--->>").append("send_request:").append(paramanyt.jdField_a_of_type_Long).append(" ,request_reponse:").append(paramanyt.jdField_b_of_type_Long).append(" ,netSend_netRecv:").append(paramanyt.jdField_c_of_type_Long).append(" ,notifyUi_reflash:").append(paramanyt.e).append(" ,mUinType:").append(paramanyt.jdField_a_of_type_Int).append(" ,isCrossOper:").append(paramanyt.jdField_a_of_type_Boolean);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    long l1 = paramanyt.jdField_a_of_type_Long;
    ((HashMap)localObject).put("param_net", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
    ((HashMap)localObject).put("param_send_req", String.valueOf(paramanyt.jdField_a_of_type_Long));
    ((HashMap)localObject).put("param_req_resp", String.valueOf(paramanyt.jdField_b_of_type_Long));
    ((HashMap)localObject).put("param_netSend_netRecv", String.valueOf(paramanyt.jdField_c_of_type_Long));
    ((HashMap)localObject).put("param_notifyUi_reflash", String.valueOf(paramanyt.e));
    ((HashMap)localObject).put("param_uin_type", String.valueOf(paramanyt.jdField_a_of_type_Int));
    ((HashMap)localObject).put("param_msg_tag", paramanyt.jdField_a_of_type_JavaLangString);
    if (paramanyt.jdField_a_of_type_Boolean) {
      ((HashMap)localObject).put("param_cross_oper", String.valueOf(paramanyt.jdField_a_of_type_Boolean));
    }
    if (paramanyt.jdField_b_of_type_Boolean) {
      ((HashMap)localObject).put("param_sent_by_xg", String.valueOf(paramanyt.jdField_b_of_type_Boolean));
    }
    if (paramanyt.jdField_c_of_type_Boolean) {
      ((HashMap)localObject).put("param_weaknet", String.valueOf(paramanyt.jdField_c_of_type_Boolean));
    }
    if (paramanyt.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      if (paramanyt.jdField_b_of_type_Boolean) {
        i1 = 4;
      }
      if (paramanyt.jdField_c_of_type_Boolean) {
        i1 = 8;
      }
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i1));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "msgSendCostPerPhase", true, l1, 0L, (HashMap)localObject, "");
      return;
      i1 = 0;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, anyz paramanyz)
  {
    uwe.a().a(this.app, paramMessageRecord, paramanyz, false);
  }
  
  private void a(MessageRecord paramMessageRecord, ToServiceMsg paramToServiceMsg)
  {
    if (((paramMessageRecord instanceof MessageForLongTextMsg)) && (((MessageForLongTextMsg)paramMessageRecord).structingMsg != null)) {
      paramToServiceMsg.extraData.putString("fileName", ((MessageForLongTextMsg)paramMessageRecord).structingMsg.mFileName);
    }
    if ((paramMessageRecord instanceof MessageForMarketFace))
    {
      MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage;
      if ((localMarkFaceMessage != null) && (((localMarkFaceMessage.mobileparam != null) && (localMarkFaceMessage.mobileparam.length > 0)) || (localMarkFaceMessage.mediaType == 3))) {
        paramToServiceMsg.extraData.putInt("mediaType", 2);
      }
    }
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramToServiceMsg.extraData.putInt("msg_signal_sum", ((MessageForText)paramMessageRecord).mMsgSignalSum);
      paramToServiceMsg.extraData.putInt("msg_signal_count", ((MessageForText)paramMessageRecord).mMsgSignalCount);
      paramToServiceMsg.extraData.putBoolean("msg_signal_open", ((MessageForText)paramMessageRecord).mIsMsgSignalOpen);
      paramToServiceMsg.extraData.putInt("msg_signal_net_type", ((MessageForText)paramMessageRecord).mMsgSignalNetType);
      paramToServiceMsg.extraData.putLong("msg_send_time", ((MessageForText)paramMessageRecord).mMsgSendTime);
    }
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 1026)) {
      paramToServiceMsg.extraData.putString("groupuin", paramMessageRecord.frienduin);
    }
    for (;;)
    {
      if (acnh.q(paramMessageRecord.msgtype)) {
        paramToServiceMsg.extraData.putBoolean("RichNotify", true);
      }
      return;
      if (paramMessageRecord.istroop == 3000) {
        paramToServiceMsg.extraData.putString("uToUin", paramMessageRecord.frienduin);
      } else if (acnh.a(paramMessageRecord.istroop) == 1032) {
        paramToServiceMsg.extraData.putInt("key_confess_topicid", paramMessageRecord.getConfessTopicId());
      }
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
    if (AppSetting.d()) {
      this.app.getParcelHooker().a(paramMessageRecord);
    }
    a(paramMessageRecord);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (("MultiVideo.c2sack".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (lch.jdField_a_of_type_Boolean))
    {
      paramFromServiceMsg = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg c2sack, type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramFromServiceMsg.type), Short.valueOf(paramFromServiceMsg.csCmd) }));
      }
      if (paramFromServiceMsg.type < 32) {}
    }
    else
    {
      return;
    }
    this.app.getGAudioHandler().b(paramFromServiceMsg.video_buff);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if ((paramInt & 0x8) == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleRestEnding!");
      }
      this.jdField_e_of_type_Boolean = true;
      if ((!this.jdField_e_of_type_Boolean) || (!g()) || (!h())) {}
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      }
      long l1 = ((Long)paramFromServiceMsg.getAttribute("infoSync_timestamp")).longValue();
      paramFromServiceMsg = createToServiceMsg("RegPrxySvc.PbSyncMsg", null);
      paramFromServiceMsg.addAttribute("infoSync_timestamp", Long.valueOf(l1));
      paramFromServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
      send(paramFromServiceMsg);
      return;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, StringBuilder paramStringBuilder, ArrayList<String> paramArrayList, GroupInfo paramGroupInfo, String paramString, long paramLong)
  {
    this.jdField_a_of_type_Bcrg.c(paramString, new Object[] { Long.valueOf(paramGroupInfo.lMemberSeq), Long.valueOf(paramGroupInfo.lGroupSeq) });
    if (paramLong < paramGroupInfo.lMemberSeq) {
      this.app.getMessageFacade().setReadFrom(String.valueOf(paramGroupInfo.lGroupCode), 1, paramGroupInfo.lMemberSeq);
    }
    paramLong = this.jdField_a_of_type_Bcrg.a(paramString, 1);
    paramGroupInfo = a(paramString, 1, this.jdField_a_of_type_Bcrg.b(paramString), this.jdField_a_of_type_Bcrg.c(paramString), paramLong, paramGroupInfo.lGroupSeq);
    int i1 = (int)(((Long)paramGroupInfo.second).longValue() - ((Long)paramGroupInfo.first).longValue());
    paramLong = ((Long)paramGroupInfo.first).longValue();
    long l1 = ((Long)paramGroupInfo.second).longValue();
    paramLong = l1 - (paramLong + 1L);
    if (paramLong > 10)
    {
      paramLong = 1L + (l1 - 10);
      if (QLog.isColorLevel())
      {
        paramStringBuilder.setLength(0);
        paramStringBuilder.append("---------handleGetPullTroopMsgNumResp troopUin: ").append(paramString).append(" msg count: ").append(i1);
        QLog.d("Q.msg.MessageHandler", 2, paramStringBuilder.toString());
      }
      if (i1 > 0) {
        break label274;
      }
      ((bfkb)a("troop_processor")).a(paramString, null, paramInt);
    }
    for (;;)
    {
      return;
      paramLong = l1 - paramLong;
      break;
      label274:
      paramArrayList.add(paramString);
      if (paramArrayList.size() <= 0) {
        break label332;
      }
      paramToServiceMsg = paramArrayList.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramStringBuilder = (String)paramToServiceMsg.next();
        a(paramString, paramLong, l1, false, null, paramInt);
      }
    }
    label332:
    notifyUI(4003, true, paramToServiceMsg.extraData.getStringArray("array_groupuin"));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, long paramLong1, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong2, boolean paramBoolean3)
  {
    if (a(paramToServiceMsg, paramPbGetGroupMsgResp)) {
      return;
    }
    ArrayList localArrayList = this.jdField_a_of_type_Bcrg.b(paramLong2);
    if (paramBoolean3) {
      a(paramToServiceMsg, paramPbGetGroupMsgResp, paramString, localArrayList);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcrg.b(paramLong2);
      ((bfkb)a("troop_processor")).a("" + paramLong2, paramPbGetGroupMsgResp, paramInt);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "handleGetPullGroupMsgRespPB, cost time = [" + (System.currentTimeMillis() - paramLong1) + "]");
      return;
      a(paramToServiceMsg, paramPbGetGroupMsgResp, paramBoolean1, paramBoolean2, paramString, paramLong2, localArrayList);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong, boolean paramBoolean)
  {
    int i1;
    anza localanza;
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localanza = new anza();
      if (!paramBoolean) {
        break label93;
      }
      localanza.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      localanza.jdField_c_of_type_Int = (i1 + 1);
    }
    for (;;)
    {
      localanza.jdField_d_of_type_Int = 1;
      a(paramToServiceMsg, 5006, paramBoolean, new Object[] { Long.valueOf(paramLong), localanza });
      return;
      label93:
      localanza.jdField_b_of_type_Int = 2900;
      localanza.jdField_a_of_type_Long = paramInt;
      localanza.jdField_c_of_type_Int = (i1 + 1);
      localanza.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq)
  {
    if (paramSvcResponsePullGroupMsgSeq == null) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    boolean bool;
    String[] arrayOfString;
    HashMap localHashMap1;
    do
    {
      return;
      int i2 = paramToServiceMsg.extraData.getInt("doSome", 0);
      bool = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      StringBuilder localStringBuilder = new StringBuilder();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("<<---handleGetPullTroopMsgNumResp msgStruct.cReplyCode: ").append(paramSvcResponsePullGroupMsgSeq.cReplyCode).append(",isUsedRegisterProxy: ").append(bool).append(",doSome: ").append(i2);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      if (paramSvcResponsePullGroupMsgSeq.cReplyCode != 0)
      {
        r(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
      this.q = 0;
      ArrayList localArrayList = new ArrayList();
      localHashMap1 = null;
      if (bool) {
        localHashMap1 = new HashMap(this.jdField_a_of_type_Bcrg.a());
      }
      akqe localakqe = (akqe)this.app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      HashMap localHashMap2 = new HashMap();
      int i1 = 0;
      while (i1 < paramSvcResponsePullGroupMsgSeq.vGroupInfo.size())
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramSvcResponsePullGroupMsgSeq, i2, bool, localStringBuilder, localArrayList, localHashMap1, localHashMap2, i1);
        i1 += 1;
      }
      localakqe.a(localHashMap2);
    } while (!bool);
    a(arrayOfString, localHashMap1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq, int paramInt1, boolean paramBoolean, StringBuilder paramStringBuilder, ArrayList<String> paramArrayList, HashMap paramHashMap, HashMap<String, String> paramHashMap1, int paramInt2)
  {
    paramSvcResponsePullGroupMsgSeq = (GroupInfo)paramSvcResponsePullGroupMsgSeq.vGroupInfo.get(paramInt2);
    String str = String.valueOf(paramSvcResponsePullGroupMsgSeq.lGroupCode);
    if (paramSvcResponsePullGroupMsgSeq.lRedPackTime > 0L) {
      paramHashMap1.put(str, String.valueOf(paramSvcResponsePullGroupMsgSeq.lRedPackTime));
    }
    paramHashMap1 = this.jdField_a_of_type_Bcrg.b(str);
    long l2 = this.jdField_a_of_type_Bcrg.j(str);
    if ((paramHashMap1 != null) && (paramHashMap1.length > 0)) {}
    for (long l1 = ((Long)paramHashMap1[0]).longValue();; l1 = 0L)
    {
      if (QLog.isColorLevel())
      {
        paramStringBuilder.setLength(0);
        paramStringBuilder.append("handleGetPullTroopMsgNumResp getGroupMsgMemberSeq groupUin=").append(paramSvcResponsePullGroupMsgSeq.lGroupCode).append(" memberseq=").append(paramSvcResponsePullGroupMsgSeq.lMemberSeq).append(" groupSeq=").append(paramSvcResponsePullGroupMsgSeq.lGroupSeq).append(" lMask=").append(paramSvcResponsePullGroupMsgSeq.lMask).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l2);
        QLog.d("Q.msg.MessageHandler", 2, paramStringBuilder.toString());
      }
      if (!paramBoolean) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramHashMap, paramSvcResponsePullGroupMsgSeq, str, l2, l1);
      return;
    }
    a(paramToServiceMsg, paramInt1, paramStringBuilder, paramArrayList, paramSvcResponsePullGroupMsgSeq, str, l1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    a(paramString, paramToServiceMsg, paramFromServiceMsg, paramObject);
    x(paramToServiceMsg, paramFromServiceMsg, paramObject);
    B(paramToServiceMsg, paramFromServiceMsg, paramObject);
    C(paramToServiceMsg, paramFromServiceMsg, paramObject);
    z(paramToServiceMsg, paramFromServiceMsg, paramObject);
    d(paramToServiceMsg, paramFromServiceMsg, paramObject, paramString);
    f(paramToServiceMsg, paramFromServiceMsg, paramObject);
    y(paramToServiceMsg, paramFromServiceMsg, paramObject);
    D(paramToServiceMsg, paramFromServiceMsg, paramObject);
    g(paramFromServiceMsg, paramObject);
    H(paramToServiceMsg, paramFromServiceMsg, paramObject);
    I(paramToServiceMsg, paramFromServiceMsg, paramObject);
    k(paramToServiceMsg, paramFromServiceMsg, paramObject);
    g(paramToServiceMsg, paramFromServiceMsg, paramObject);
    f(paramFromServiceMsg, paramObject);
    s(paramToServiceMsg, paramFromServiceMsg, paramObject);
    t(paramToServiceMsg, paramFromServiceMsg, paramObject);
    J(paramToServiceMsg, paramFromServiceMsg, paramObject);
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    p(paramToServiceMsg, paramFromServiceMsg, paramObject);
    d(paramFromServiceMsg, paramObject);
    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
    K(paramToServiceMsg, paramFromServiceMsg, paramObject);
    e(paramFromServiceMsg, paramObject);
    n(paramToServiceMsg, paramFromServiceMsg, paramObject);
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    m(paramToServiceMsg, paramFromServiceMsg, paramObject);
    l(paramToServiceMsg, paramFromServiceMsg);
    q(paramToServiceMsg, paramFromServiceMsg, paramObject);
    k(paramToServiceMsg, paramFromServiceMsg);
    r(paramToServiceMsg, paramFromServiceMsg, paramObject);
    j(paramToServiceMsg, paramFromServiceMsg, paramObject);
    i(paramToServiceMsg, paramFromServiceMsg, paramObject);
    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
    G(paramToServiceMsg, paramFromServiceMsg, paramObject);
    c(paramFromServiceMsg);
    c(paramFromServiceMsg, paramObject);
    b(paramFromServiceMsg);
    a(paramFromServiceMsg);
    a(paramObject, paramString);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject, paramString);
    c(paramToServiceMsg, paramFromServiceMsg, paramObject, paramString);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object arg3, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp = a((byte[])???);
    if (localPbGetGroupMsgResp == null) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
    }
    if ((localPbGetGroupMsgResp == null) || (??? == null))
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i1 = paramToServiceMsg.extraData.getInt("doSome", 0);
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
    String str;
    if (paramToServiceMsg.getUin() == null)
    {
      paramFromServiceMsg = this.app.getCurrentAccountUin();
      str = paramToServiceMsg.extraData.getString("groupuin");
      if (str == null) {
        break label229;
      }
    }
    label229:
    for (long l1 = Long.valueOf(str).longValue();; l1 = localPbGetGroupMsgResp.group_code.get())
    {
      boolean bool3 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
      a(???, paramBoolean, localPbGetGroupMsgResp, i1, l1, bool3);
      synchronized (a(String.valueOf(l1), 1))
      {
        a(paramToServiceMsg, l2, localPbGetGroupMsgResp, i1, bool1, bool2, paramFromServiceMsg, l1, bool3);
        return;
      }
      paramFromServiceMsg = paramToServiceMsg.getUin();
      break;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, msg_svc.PbSendMsgResp paramPbSendMsgResp, SendMessageHandler paramSendMessageHandler)
  {
    boolean bool = this.app.getMsgCache().a(paramString1, paramInt2, paramLong1);
    paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool);
    long l1;
    if (paramPbSendMsgResp.send_time.has())
    {
      l1 = paramPbSendMsgResp.send_time.get() & 0xFFFFFFFF;
      a(paramString1, paramInt2, paramLong1, l1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB updateSendMsgTime: sendBuddyPb: respData.uSendTime:" + l1 + ",peerUin:" + paramString1);
      }
    }
    if ((paramPbSendMsgResp.trans_svr_info.has()) && (paramInt2 == 10008)) {
      notifyUI(8046, true, paramPbSendMsgResp.trans_svr_info.get());
    }
    MessageRecord localMessageRecord = this.app.getMessageFacade().queryMsgItemByUniseq(paramString1, paramInt2, paramLong1);
    if (paramPbSendMsgResp.uint32_msg_info_flag.has())
    {
      int i1 = paramPbSendMsgResp.uint32_msg_info_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "C2CMessageSendFlag: " + i1);
      }
      localMessageRecord.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i1));
      this.app.msgFacade.updateMsgFieldByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "extStr", localMessageRecord.extStr);
    }
    if ((localMessageRecord instanceof RecommendCommonMessage))
    {
      if ((paramPbSendMsgResp.text_analysis_result.has()) && (paramPbSendMsgResp.text_analysis_result.get() == 1))
      {
        paramString2 = "1";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB text_analysis_result=" + paramString2);
        }
        localMessageRecord.saveExtInfoToExtStr("ark_text_analysis_flag", paramString2);
      }
    }
    else
    {
      long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
      if ((l3 <= 0L) || (paramInt2 != 0)) {
        break label769;
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
      paramString2 = new anyt();
      paramString2.jdField_c_of_type_Long = l2;
      paramString2.jdField_d_of_type_Long = System.currentTimeMillis();
      paramString2.jdField_b_of_type_Long = (paramString2.jdField_d_of_type_Long - l3);
      paramString2.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
      paramString2.jdField_a_of_type_Int = 0;
      paramString2.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
      paramString2.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      paramString2.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
      notifyUI(6003, true, new Object[] { paramString1, paramLong1 + "", paramString2 });
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramString2 = new anza();
        paramString2.jdField_c_of_type_Int = (paramInt1 + 1);
        a(paramToServiceMsg, 5006, true, new Object[] { Long.valueOf(paramLong1), paramString2 });
        a(paramString1, paramInt2, paramLong1, true);
      }
      b(paramToServiceMsg, paramFromServiceMsg, true);
      a(paramLong2);
      if ((paramInt2 == 1025) || (paramInt2 == 1024))
      {
        paramLong1 = paramSendMessageHandler.a(System.currentTimeMillis());
        ((bjyi)this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(paramString1, paramLong1);
      }
      b(localMessageRecord);
      a(paramInt2, paramString1);
      return;
      paramString2 = "0";
      break;
      label769:
      if (acnh.a(paramInt2) == 1032) {
        notifyUI(8035, true, new Object[] { paramString1, Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Integer.valueOf(paramInt3) });
      } else {
        notifyUI(6003, true, new String[] { paramString1, paramLong1 + "" });
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, msg_svc.PbSendMsgResp paramPbSendMsgResp, long paramLong, int paramInt)
  {
    MessageRecord localMessageRecord = this.app.getMessageFacade().queryMsgItemByUniseq(paramString, paramInt, paramLong);
    if ((localMessageRecord instanceof RecommendCommonMessage))
    {
      if ((paramPbSendMsgResp.text_analysis_result.has()) && (paramPbSendMsgResp.text_analysis_result.get() == 1))
      {
        paramString = "1";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB text_analysis_result=" + paramString);
        }
        localMessageRecord.saveExtInfoToExtStr("ark_text_analysis_flag", paramString);
      }
    }
    else
    {
      boolean bool = this.app.getMsgCache().a(paramToServiceMsg.extraData.getString("groupuin"), 1, paramLong);
      paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool);
      long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
      if (l3 <= 0L) {
        break label409;
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
      paramString = new anyt();
      paramString.jdField_c_of_type_Long = l2;
      paramString.jdField_d_of_type_Long = System.currentTimeMillis();
      paramString.jdField_b_of_type_Long = (paramString.jdField_d_of_type_Long - l3);
      paramString.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
      paramString.jdField_a_of_type_Int = 1;
      paramString.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
      paramString.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      paramString.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
      notifyUI(6003, true, new Object[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(paramLong), paramString });
    }
    for (;;)
    {
      b(localMessageRecord);
      return;
      paramString = "0";
      break;
      label409:
      notifyUI(6003, true, new String[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(paramLong) });
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, HashMap paramHashMap, GroupInfo paramGroupInfo, String paramString, long paramLong1, long paramLong2)
  {
    if (((paramGroupInfo.lMask == 2L) || (paramGroupInfo.lMask == 3L)) && (!this.app.mAutomator.d())) {
      h(paramString);
    }
    for (;;)
    {
      if (paramHashMap != null) {
        paramHashMap.remove(paramString);
      }
      if (paramGroupInfo.lMask != 0L)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        paramToServiceMsg = new Setting();
        paramToServiceMsg.Path = ("message.group.policy." + paramString);
        paramToServiceMsg.Value = String.valueOf(paramGroupInfo.lMask);
        this.jdField_b_of_type_JavaUtilArrayList.add(paramToServiceMsg);
      }
      return;
      this.jdField_a_of_type_Bcrg.c(paramString, new Object[] { Long.valueOf(paramGroupInfo.lMemberSeq), Long.valueOf(paramGroupInfo.lGroupSeq) });
      if (paramGroupInfo.lGroupSeq <= paramLong1)
      {
        h(paramString);
        if (paramLong2 < paramGroupInfo.lMemberSeq) {
          if (jdField_f_of_type_Boolean) {
            a(4, paramToServiceMsg, paramFromServiceMsg, paramGroupInfo);
          } else {
            this.app.getMessageFacade().setReadFrom(paramString, 1, paramGroupInfo.lMemberSeq);
          }
        }
      }
      else if (paramLong2 < paramGroupInfo.lMemberSeq)
      {
        this.jdField_a_of_type_Bcrg.a(paramString, 1);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp, long paramLong, String paramString, int paramInt)
  {
    paramString = this.app.getMessageFacade().queryMsgItemByUniseq(paramString, paramInt, paramLong);
    if ((paramString instanceof RecommendCommonMessage))
    {
      if ((paramPbSendMsgResp.text_analysis_result.has()) && (paramPbSendMsgResp.text_analysis_result.get() == 1))
      {
        paramPbSendMsgResp = "1";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB text_analysis_result=" + paramPbSendMsgResp);
        }
        paramString.saveExtInfoToExtStr("ark_text_analysis_flag", paramPbSendMsgResp);
      }
    }
    else
    {
      boolean bool = this.app.getMsgCache().a(paramToServiceMsg.extraData.getString("uToUin"), 3000, paramLong);
      paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool);
      long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
      if (l3 <= 0L) {
        break label412;
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
      paramPbSendMsgResp = new anyt();
      paramPbSendMsgResp.jdField_c_of_type_Long = l2;
      paramPbSendMsgResp.jdField_d_of_type_Long = System.currentTimeMillis();
      paramPbSendMsgResp.jdField_b_of_type_Long = (paramPbSendMsgResp.jdField_d_of_type_Long - l3);
      paramPbSendMsgResp.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
      paramPbSendMsgResp.jdField_a_of_type_Int = 3000;
      paramPbSendMsgResp.jdField_a_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
      paramPbSendMsgResp.jdField_b_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      paramPbSendMsgResp.jdField_c_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
      notifyUI(6003, true, new Object[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(paramLong), paramPbSendMsgResp });
    }
    for (;;)
    {
      b(paramString);
      return;
      paramPbSendMsgResp = "0";
      break;
      label412:
      notifyUI(6003, true, new String[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(paramLong) });
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.discuss_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_msg.get();
      int i2 = paramSvcRegisterProxyMsgResp.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussMsgResp_PB, discuss_msg size:" + i2);
      }
      int i1 = 0;
      if (i1 < i2)
      {
        register_proxy.SvcPbResponsePullDisMsgProxy localSvcPbResponsePullDisMsgProxy = (register_proxy.SvcPbResponsePullDisMsgProxy)paramSvcRegisterProxyMsgResp.get(i1);
        if (this.jdField_d_of_type_Boolean) {
          a(3, paramToServiceMsg, paramFromServiceMsg, localSvcPbResponsePullDisMsgProxy, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          a(3, paramToServiceMsg, paramFromServiceMsg, localSvcPbResponsePullDisMsgProxy, true);
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
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    if ((paramToServiceMsg.extraData != null) && (paramToServiceMsg.extraData.getInt("msgtype") == -2007))
    {
      if (paramToServiceMsg.extraData.getInt("mediaType") == 2) {
        awyr.b(paramString, 7);
      }
    }
    else {
      return;
    }
    awyr.b(paramString, 6);
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
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB refreshTroopHead exception ! ", paramToServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong, ArrayList<msg_comm.Msg> paramArrayList)
  {
    for (;;)
    {
      try
      {
        a("troop_processor").a(1002, new Object[] { paramToServiceMsg, paramArrayList, paramPbGetGroupMsgResp, paramString });
        if (!paramBoolean2) {
          continue;
        }
        this.jdField_j_of_type_Int += 1;
        this.jdField_a_of_type_Bcrg.a(String.valueOf(paramLong), 2);
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB initGetPullTroopMsg exception ! ", paramToServiceMsg);
        if (!paramBoolean2) {
          continue;
        }
        this.jdField_j_of_type_Int += 1;
        this.jdField_a_of_type_Bcrg.a(String.valueOf(paramLong), 2);
        continue;
        d(String.valueOf(paramLong), "handleGetPullGroupMsgRespPB");
        continue;
      }
      finally
      {
        if (!paramBoolean2) {
          continue;
        }
        this.jdField_j_of_type_Int += 1;
        this.jdField_a_of_type_Bcrg.a(String.valueOf(paramLong), 2);
        throw paramToServiceMsg;
        d(String.valueOf(paramLong), "handleGetPullGroupMsgRespPB");
        continue;
        if (!paramBoolean2) {
          continue;
        }
        if ((this.jdField_c_of_type_Int == 0) || (this.jdField_j_of_type_Int < this.jdField_c_of_type_Int)) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN , troopNum:" + this.jdField_c_of_type_Int + " , recvTroopNum:" + this.jdField_j_of_type_Int);
        MsgAutoMonitorUtil.getInstance().markGrpFinishTime();
        notifyUI(4003, true, null);
        return;
        notifyUI(4003, true, new String[] { "" + paramLong });
      }
      if (!paramBoolean1) {
        continue;
      }
      if (this.jdField_a_of_type_Bcrg.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
        }
        paramToServiceMsg = "" + paramLong;
        MsgAutoMonitorUtil.getInstance().markGrpFinishTime();
        notifyUI(4003, true, new String[] { paramToServiceMsg });
      }
      return;
      d(String.valueOf(paramLong), "handleGetPullGroupMsgRespPB");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    if ((paramPbSendMsgResp != null) && (paramPbSendMsgResp.errtype.has())) {
      switch (paramPbSendMsgResp.errtype.get())
      {
      }
    }
    do
    {
      return;
    } while (!paramPbSendMsgResp.trans_svr_info.has());
    paramPbSendMsgResp = (msg_svc.TransSvrInfo)paramPbSendMsgResp.trans_svr_info.get();
    a(paramToServiceMsg, 8036, true, new Object[] { Integer.valueOf(paramPbSendMsgResp.int32_ret_code.get()), paramPbSendMsgResp.bytes_trans_info.get().toByteArray() });
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
          bcsc.a(this.app, paramObject);
          localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (!((anvk)localObject).e(paramObject))
          {
            Friends localFriends = ((anvk)localObject).e(String.valueOf(paramObject));
            if (localFriends != null)
            {
              localFriends.setShieldFlag(true);
              ((anvk)localObject).a(localFriends);
              this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(56, true, new Object[] { Long.valueOf(Long.parseLong(paramObject)), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), "" });
            }
          }
        }
      }
    }
  }
  
  private void a(Object paramObject, String paramString)
  {
    if ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(paramString)) {
      this.app.getQlinkServiceMgr().a((byte[])paramObject);
    }
  }
  
  private void a(Object paramObject, boolean paramBoolean1, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt, long paramLong, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder(128);
      StringBuilder localStringBuilder2 = localStringBuilder1.append("handleGetPullTroopMsgResp msgStruct.cReplyCode = ");
      if (paramPbGetGroupMsgResp != null) {
        break label214;
      }
      localObject = "null";
      localStringBuilder2.append(localObject).append(" troopUin: ").append(paramLong).append(",isRefreshHead:").append(paramBoolean2).append(", dataHash=@").append(Integer.toHexString(paramObject.hashCode())).append(" rtnBeginSeq:").append(paramPbGetGroupMsgResp.return_begin_seq.get()).append(" rtnEndSeq:").append(paramPbGetGroupMsgResp.return_end_seq.get()).append(",doSome:").append(paramInt);
      if (!paramBoolean1) {
        localStringBuilder1.append(",costTime = [").append(System.currentTimeMillis() - bfjz.jdField_b_of_type_Long).append("]");
      }
      if (paramPbGetGroupMsgResp.msg.get() == null) {
        break label229;
      }
      localStringBuilder1.append(" msgSize:").append(paramPbGetGroupMsgResp.msg.get().size());
      label189:
      if (QLog.isColorLevel()) {
        if (!paramBoolean1) {
          break label241;
        }
      }
    }
    label214:
    label229:
    label241:
    for (paramObject = "Q.msg.MessageHandler.troop.register_proxy_pull_msg";; paramObject = "Q.msg.MessageHandler.trooptroop_pull_msg")
    {
      QLog.d(paramObject, 2, localStringBuilder1.toString());
      return;
      localObject = Integer.valueOf(paramPbGetGroupMsgResp.result.get());
      break;
      localStringBuilder1.append(" msg:null.");
      break label189;
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bcrg.e()) && (this.jdField_a_of_type_Bcrg.b(paramString, paramInt, paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "handleRevokingRichMsgCacheAndNotify, in revoking cache, isSuc:" + paramBoolean);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Bcrg.f(null);
      }
      this.app.getMessageFacade().getBaseMessageManager(paramInt).b();
    }
  }
  
  private void a(String paramString, int paramInt1, boolean paramBoolean1, Object paramObject, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, MessageRecord paramMessageRecord)
  {
    b(paramString, paramInt1, paramBoolean1);
    a(paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3, paramMessageRecord);
    notifyUI(paramInt1, paramBoolean1, paramObject);
    if (a(paramInt1)) {
      a(paramObject);
    }
    do
    {
      return;
      if (b(paramInt1))
      {
        a(paramInt1, paramObject);
        return;
      }
    } while (!c(paramInt1));
    b(paramObject);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(aoon.a(paramString)).a(aoon.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PBBytesField paramPBBytesField)
  {
    if (paramPBBytesField.has()) {}
    try
    {
      paramPBBytesField = paramPBBytesField.get().toByteArray();
      int i1 = paramPBBytesField.length - 4;
      byte[] arrayOfByte = new byte[i1];
      PkgTools.copyData(arrayOfByte, 0, paramPBBytesField, 4, i1);
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode " + paramString + ", hashCode:" + arrayOfByte.hashCode());
      }
      a(1, paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode " + paramString + "error:", paramToServiceMsg);
    }
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (aoon.a().containsKey(paramString)) {
      a(aoon.a(paramString)).a(aoon.a(paramString), new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
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
        l2 = paramFromServiceMsg.extraData.getLong(bcrn.jdField_b_of_type_JavaLangString, 0L);
        int i6 = paramFromServiceMsg.extraData.getInt(bcrn.jdField_a_of_type_JavaLangString, 0);
        if (l2 == 0L) {}
        for (l2 = 0L;; l2 = System.currentTimeMillis() - l2)
        {
          localHashMap.put("pm_queueTime", String.valueOf(l2));
          localHashMap.put("pm_respLen", String.valueOf(i6));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), paramString, paramBoolean, l3, paramLong, localHashMap, "");
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
  
  private void a(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSvcRegisterProxyMsgResp.discuss_list_flag.has())
    {
      bool1 = bool2;
      if (paramSvcRegisterProxyMsgResp.discuss_list_flag.get() == 1) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg needDealDiscussList=" + bool1);
    }
    if (bool1)
    {
      Object localObject1;
      int i1;
      Object localObject2;
      if (paramSvcRegisterProxyMsgResp.discuss_list.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList!");
        }
        paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_list.get();
        localObject1 = this.jdField_a_of_type_Bcrg;
        bcrg.jdField_a_of_type_Bcrl.b = paramSvcRegisterProxyMsgResp;
        i1 = 0;
        if (i1 < paramSvcRegisterProxyMsgResp.size())
        {
          localObject1 = (register_proxy.DiscussList)paramSvcRegisterProxyMsgResp.get(i1);
          if (localObject1 == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            localObject2 = String.valueOf(((register_proxy.DiscussList)localObject1).discuss_code.get());
            Object localObject3 = this.jdField_a_of_type_Bcrg.a((String)localObject2);
            long l3 = this.jdField_a_of_type_Bcrg.i((String)localObject2);
            long l2 = 0L;
            long l1 = l2;
            if (localObject3 != null)
            {
              l1 = l2;
              if (localObject3.length > 0) {
                l1 = ((Long)localObject3[0]).longValue();
              }
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).setLength(0);
              ((StringBuilder)localObject3).append("handleNewRegisterProxyMsg getDiscussList discussCode=").append(((register_proxy.DiscussList)localObject1).discuss_code.get()).append(" discussSeq=").append(((register_proxy.DiscussList)localObject1).discuss_seq.get()).append(" memberSeq=").append(((register_proxy.DiscussList)localObject1).member_seq.get()).append(" info_seq=").append(((register_proxy.DiscussList)localObject1).info_seq.get()).append(" isHotDiscuss=").append(((register_proxy.DiscussList)localObject1).bHotGroup.get()).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l3).append(" redpack_time=").append(((register_proxy.DiscussList)localObject1).redpack_time.get()).append(" hasMsg=").append(((register_proxy.DiscussList)localObject1).has_msg.get());
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject3).toString());
            }
            this.jdField_a_of_type_Bcrg.b((String)localObject2, new Object[] { Long.valueOf(((register_proxy.DiscussList)localObject1).member_seq.get()), Long.valueOf(((register_proxy.DiscussList)localObject1).discuss_seq.get()) });
            if (((register_proxy.DiscussList)localObject1).member_seq.get() > l1) {
              if (((register_proxy.DiscussList)localObject1).discuss_seq.get() <= l3) {
                a(5, null, null, localObject1);
              } else {
                this.jdField_a_of_type_Bcrg.b((String)localObject2, 1);
              }
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList! noDiscussList return...");
        }
        localObject1 = (antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        paramSvcRegisterProxyMsgResp = (antl)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        localObject1 = ((antp)localObject1).a();
        new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        i1 = 1;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> should be deleted discussion" + i1 + ":" + ((DiscussionInfo)localObject2).uin);
          }
          paramSvcRegisterProxyMsgResp.a(((DiscussionInfo)localObject2).uin);
          if (this.jdField_a_of_type_Bcrg.b(((DiscussionInfo)localObject2).uin) != null) {
            this.jdField_a_of_type_Bcrg.d(((DiscussionInfo)localObject2).uin);
          }
          i1 += 1;
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
      long l1 = PkgTools.getLongData(paramArrayOfByte, 1);
      l2 = PkgTools.getLongData(paramArrayOfByte, 5);
      l3 = PkgTools.getLongData(paramArrayOfByte, 9);
      l4 = PkgTools.getLongData(paramArrayOfByte, 13);
      l5 = PkgTools.getLongData(paramArrayOfByte, 17);
      if (QLog.isColorLevel()) {
        QLog.d("Emoticon", 2, "uin:" + l1 + " epId=" + l2 + " expireTime=" + l3 + " flag=" + l4);
      }
      localObject = (awyr)this.app.getManager(QQManagerFactory.EMOTICON_MANAGER);
    } while (((awyr)localObject).c(Long.toString(l2), 0) != null);
    paramArrayOfByte = new EmoticonPackage();
    paramArrayOfByte.epId = Long.toString(l2);
    paramArrayOfByte.wordingId = l5;
    if (l4 == 1L) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfByte.valid = bool;
      paramArrayOfByte.expiretime = l3;
      paramArrayOfByte.aio = true;
      ((awyr)localObject).a(paramArrayOfByte);
      ((awyr)localObject).f(paramArrayOfByte.epId, 0);
      localObject = (asih)this.app.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
      ((asih)localObject).a(paramArrayOfByte.epId, asih.jdField_c_of_type_Int);
      ((asih)localObject).a(paramArrayOfByte);
      return;
    }
  }
  
  private void a(Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    paramString = (String)paramArrayOfObject[0];
    int i1 = ((Integer)paramArrayOfObject[1]).intValue();
    long l1 = ((Long)paramArrayOfObject[5]).longValue();
    paramArrayOfObject = this.app.getMessageFacade().getLastMessage(paramString, i1);
    this.app.getMsgCache().a(paramString, i1, l1);
    if ((paramArrayOfObject != null) && (paramArrayOfObject.uniseq == l1)) {
      paramArrayOfObject.extraflag = 32768;
    }
    this.app.getMessageFacade().updateMsgExtraFlagByUniseq(paramString, i1, l1, 32768, paramInt);
  }
  
  private void a(String[] paramArrayOfString, HashMap paramHashMap)
  {
    if (!paramHashMap.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp  RegisterProxyTroopSeq FailedTroopSize=" + paramHashMap.size());
      }
      paramHashMap = paramHashMap.keySet().iterator();
      while (paramHashMap.hasNext()) {
        h((String)paramHashMap.next());
      }
    }
    if (this.jdField_a_of_type_Bcrg.b()) {
      notifyUI(4003, true, paramArrayOfString);
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 3001;
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
  
  private boolean a(SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify)
  {
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
    return bool1;
  }
  
  private boolean a(MessageRecord paramMessageRecord, anyz paramanyz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "the values of disable big data channel is" + usu.o);
    }
    if (usu.o) {}
    do
    {
      do
      {
        return false;
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break;
        }
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramMessageRecord).structingMsg;
        if ((localAbsStructMsg != null) && (uwe.a(localAbsStructMsg)))
        {
          String str1 = paramMessageRecord.getExtInfoFromExtStr("send_by_struct_long_message");
          String str2 = uwe.a(localAbsStructMsg);
          String str3 = uwe.a(str2);
          if (!"1".equals(str1))
          {
            paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "1");
            a(paramMessageRecord, paramanyz);
            olh.a(null, localAbsStructMsg.source_puin, "0X8007A26", "0X8007A26", 0, 0, str3, str2, "", "", false);
            return true;
          }
          paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "0");
          olh.a(null, localAbsStructMsg.source_puin, "0X8007A27", "0X8007A27", 0, 0, str3, str2, "", "", false);
          return false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, "struct msg is null");
      return false;
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        admh.a(this.app, (MessageForArkApp)paramMessageRecord, false);
        return true;
      }
      if ((paramMessageRecord instanceof MessageForArkBabyqReply))
      {
        QLog.e("Q.msg.MessageHandler", 1, "MessageForArkBabyqReply no longer supported from 8.2.6");
        return true;
      }
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        ((axii)this.app.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(this.app, paramMessageRecord, true);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "it is not message for structing");
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if (msgCmdFilter(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "cmdfilter error=" + paramString);
      }
    }
    do
    {
      return true;
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        j(paramToServiceMsg, paramFromServiceMsg);
        return true;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return true;
      }
    } while (this.jdField_l_of_type_Boolean);
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
      this.jdField_a_of_type_Bcrg.a(l3, paramPbGetDiscussMsgResp.msg.get());
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
        this.jdField_a_of_type_Bcrg.b(paramPbGetGroupMsgResp.group_code.get(), paramPbGetGroupMsgResp.msg.get());
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
  
  private boolean a(String paramString, int paramInt, TroopManager paramTroopManager, Object[] paramArrayOfObject)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
    if (localHotChatInfo != null)
    {
      if ((paramInt == 108) || (paramInt == 102))
      {
        if (localHotChatInfo != null)
        {
          anwf.a(this.app, localHotChatInfo);
          return false;
        }
        paramTroopManager = this.app.getProxyManager().a();
        paramString = (RecentUser)paramTroopManager.findRecentUserByUin(paramString, 1);
        if (paramString != null) {
          paramTroopManager.delRecentUser(paramString);
        }
        a(1002, true, paramArrayOfObject);
        a(2001, true, paramArrayOfObject);
        a(2002, true, paramArrayOfObject);
        return false;
      }
      if (paramInt == 0) {
        return true;
      }
    }
    else
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 0: 
      case 241: 
        return true;
      }
      paramTroopManager.a(paramString);
      paramTroopManager = this.app.getProxyManager().a();
      paramString = (RecentUser)paramTroopManager.findRecentUserByUin(paramString, 1);
      if (paramString != null) {
        paramTroopManager.delRecentUser(paramString);
      }
      a(1002, true, paramArrayOfObject);
      a(2001, true, paramArrayOfObject);
      a(2002, true, paramArrayOfObject);
      return false;
    }
    return false;
  }
  
  private boolean a(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    boolean bool = true;
    int i1 = paramSvcRegisterProxyMsgResp.result.get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyResultCode resultCode = " + i1);
    }
    if (i1 != 0)
    {
      paramSvcRegisterProxyMsgResp = new HashMap();
      paramSvcRegisterProxyMsgResp.put("param_FailCode", String.valueOf(i1));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "prxyRegFailCode", true, 0L, 0L, paramSvcRegisterProxyMsgResp, null);
    }
    switch (i1)
    {
    default: 
      bool = false;
    case 0: 
      return bool;
    case 1: 
      notifyUI(4001, false, null);
      notifyUI(4016, false, null);
      notifyUI(4003, false, null);
      notifyUI(4002, false, null);
      return false;
    case 99: 
    case 101: 
      RegisterProxy.jdField_d_of_type_Int |= 0x1;
      i1 = new Random().nextInt(3000);
      ThreadManager.getSubThreadHandler().postDelayed(new MessageHandler.13(this), i1);
      return false;
    case 100: 
      jdField_b_of_type_Boolean = false;
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", false).commit();
      notifyUI(4004, false, null);
      return false;
    case 102: 
      b(false);
      a(true, 1);
      return true;
    case 103: 
      c(false);
      a(true, 2);
      return true;
    }
    b(false);
    a(true, 0);
    return true;
  }
  
  private boolean a(boolean paramBoolean, long paramLong, MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof ChatMessage)) {}
    int i1;
    do
    {
      do
      {
        do
        {
          return paramBoolean;
          ((ChatMessage)paramMessageRecord).parse();
        } while (!(paramMessageRecord instanceof MessageForStructing));
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
      } while (paramMessageRecord.structingMsg == null);
      i1 = paramMessageRecord.structingMsg.mMsgServiceID;
    } while ((i1 != 35) && (i1 != 107));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "current mr is multimsg, uniseq:" + paramLong + ",");
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean, ArrayList<MessageRecord> paramArrayList, Iterator<Map.Entry<String, ConcurrentHashMap<Long, bcrj>>> paramIterator)
  {
    paramIterator = ((ConcurrentHashMap)((Map.Entry)paramIterator.next()).getValue()).entrySet().iterator();
    while (paramIterator.hasNext()) {
      paramBoolean = b(paramBoolean, paramArrayList, paramIterator);
    }
    return paramBoolean;
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
      this.jdField_a_of_type_Bcrg.a(paramArrayOfString[i1], 0);
      this.jdField_a_of_type_Bcrg.e(paramArrayOfString[i1]);
      arrayOfLong[i1] = this.jdField_a_of_type_Bcrg.j(paramArrayOfString[i1]);
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
    Object localObject = ((antp)this.mApp.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
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
      arrayOfLong[i1] = this.jdField_a_of_type_Bcrg.i(str);
      this.jdField_a_of_type_Bcrg.b(str, 0);
      this.jdField_a_of_type_Bcrg.g(str);
      this.jdField_a_of_type_Bcrg.c(str);
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
      notifyUI(4002, true, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>initBeforGetPullDiscussionMsgNum, get discussionUin is null or length is 0, notifyUI NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
      }
      return null;
    }
    return new Object[] { arrayOfString, arrayOfLong, Integer.valueOf(i1) };
  }
  
  private int b(int paramInt)
  {
    return ((acos)this.app.getMessageFacade().getRegistry().a().a(Integer.valueOf(paramInt))).b();
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
      if (!QLog.isColorLevel()) {
        break label69;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("<---handleSendTroopMessageRespPB:");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
    {
      QLog.e("Q.msg.MessageHandler", 2, paramObject, localException);
      label69:
      return null;
    }
  }
  
  private void b(int paramInt)
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (paramInt == 0)
    {
      localQQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", 264);
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
      localQQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", 263);
      this.jdField_k_of_type_Boolean = false;
    } while (this.jdField_a_of_type_JavaLangRunnable == null);
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  private void b(SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify, List<Object> paramList)
  {
    if ((paramSvcRequestPushReadedNotify.vGroupReadedNotify == null) || (paramSvcRequestPushReadedNotify.vGroupReadedNotify.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList.addAll(paramSvcRequestPushReadedNotify.vGroupReadedNotify);
      paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vGroupReadedNotify.iterator();
      while (paramSvcRequestPushReadedNotify.hasNext())
      {
        paramList = (GroupMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
        String str = String.valueOf(paramList.lGroupCode);
        if (this.app.getMsgCache().a(str) == 1)
        {
          this.app.getMsgCache().a(str, paramList);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "GroupMsgReadedNotify unfinished groupUin=" + str);
          }
        }
        else
        {
          ((bfkb)a("troop_processor")).a(paramList);
        }
      }
    }
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing))) {
      MiniAppController.tryReportShare((MessageForStructing)paramMessageRecord);
    }
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
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramMessageRecord.frienduin);
      oidb_0xa89.ReqBody localReqBody = new oidb_0xa89.ReqBody();
      localReqBody.bytes_msg_body.set(ByteStringMicro.copyFrom(paramPbSendMsgReq.toByteArray()));
      localReqBody.bytes_poid.set(ByteStringMicro.copyFrom(localHotChatInfo.uuid.getBytes()));
      paramBusinessObserver = makeOIDBPkg("OidbSvc.0xa89", 2697, 1, localReqBody.toByteArray(), paramLong, paramBusinessObserver, false);
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
      if (acnh.q(paramMessageRecord.msgtype)) {
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
        break label461;
      }
      paramPbSendMsgReq = "";
      label396:
      paramBusinessObserver.addAttribute("uin", paramPbSendMsgReq);
      if (paramMessageRecord.senderuin != null) {
        break label469;
      }
    }
    label461:
    label469:
    for (paramMessageRecord = "";; paramMessageRecord = paramMessageRecord.senderuin)
    {
      paramBusinessObserver.addAttribute("fromUin", paramMessageRecord);
      paramBusinessObserver.addAttribute("normal_msg", Boolean.valueOf(true));
      a(paramBusinessObserver);
      return;
      l1 = paramMessageRecord.msg.getBytes().length;
      break;
      paramPbSendMsgReq = paramMessageRecord.frienduin;
      break label396;
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg)
  {
    if (("MultiVideo.s2c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (lch.jdField_a_of_type_Boolean))
    {
      paramFromServiceMsg = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg s2c, type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramFromServiceMsg.type), Short.valueOf(paramFromServiceMsg.csCmd) }));
      }
      if (paramFromServiceMsg.type < 32) {
        break label93;
      }
    }
    label93:
    do
    {
      return;
      this.app.getGAudioHandler().a(paramFromServiceMsg.video_buff);
    } while (paramFromServiceMsg.type == 10);
    ToServiceMsg localToServiceMsg = createToServiceMsg("MultiVideo.s2cack");
    localToServiceMsg.extraData.putByte("ver", paramFromServiceMsg.ver);
    localToServiceMsg.extraData.putByte("type", paramFromServiceMsg.type);
    localToServiceMsg.extraData.putShort("cscmd", paramFromServiceMsg.csCmd);
    localToServiceMsg.extraData.putShort("subcmd", paramFromServiceMsg.subCmd);
    localToServiceMsg.extraData.putLong("from_uin", paramFromServiceMsg.from_uin);
    localToServiceMsg.extraData.putLong("to_uin", ((Long)paramFromServiceMsg.to_uin.get(0)).longValue());
    localToServiceMsg.extraData.putLong("msg_seq", paramFromServiceMsg.msg_seq);
    localToServiceMsg.extraData.putLong("msg_uid", paramFromServiceMsg.msg_uid);
    localToServiceMsg.extraData.putLong("msg_type", paramFromServiceMsg.msg_type);
    localToServiceMsg.extraData.putLong("msg_time", paramFromServiceMsg.msg_time);
    localToServiceMsg.extraData.putByteArray("video_buff", paramFromServiceMsg.video_buff);
    localToServiceMsg.extraData.putLong("msg_dataflag", paramFromServiceMsg.msg_dataflag);
    send(localToServiceMsg);
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new msg_onlinepush.PbPushMsg();
    try
    {
      paramObject = (msg_onlinepush.PbPushMsg)((msg_onlinepush.PbPushMsg)localObject).mergeFrom((byte[])paramObject);
      if (paramObject == null) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      if ((paramObject == null) || (!paramObject.msg.has())) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("<---handleMessagePush_PB: pushMsg is null or doesn't has msg:");
          if (paramObject == null)
          {
            paramFromServiceMsg = " null ";
            QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg);
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: exception occurs while parsing the pb bytes.", paramObject);
        }
        paramObject = null;
        continue;
        paramFromServiceMsg = "noMsg";
      }
      localObject = (msg_comm.Msg)paramObject.msg.get();
      int i1 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).msg_type.get();
      if ((paramObject.uint32_general_flag.get() & 0x20) == 32) {
        bgzw.a(true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, new Object[] { "<---handleMessagePush_PB: msgType:", Integer.valueOf(i1), " ,muteGeneralFlag:", Integer.valueOf(paramObject.uint32_general_flag.get()) });
        }
        if (!"OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        a("c2c_processor").a(2003, new Object[] { localObject, paramFromServiceMsg, paramObject });
        return;
        bgzw.a(false);
      }
      if ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        a().a(4004, new Object[] { localObject, paramFromServiceMsg, paramObject });
        return;
      }
      switch (i1)
      {
      default: 
        return;
      }
    }
    a("disc_processor").a(1001, new Object[] { localObject, paramFromServiceMsg, paramObject, Boolean.valueOf(true) });
    return;
    acme localacme = a("troop_processor");
    if (paramObject.ping_flag.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localacme.a(1001, new Object[] { localObject, paramFromServiceMsg, paramObject, Boolean.valueOf(bool) });
      return;
    }
    a("c2c_processor").a(1001, new Object[] { localObject, paramFromServiceMsg, paramObject });
  }
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    b();
    if (this.jdField_g_of_type_Int < 6)
    {
      a(paramToServiceMsg.extraData.getBoolean("isPullRoamMsg"), paramToServiceMsg.extraData.getInt("pullMsgType"));
      this.jdField_g_of_type_Int += 1;
      return;
    }
    c(paramToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong, boolean paramBoolean)
  {
    int i1;
    anza localanza;
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localanza = new anza();
      if (!paramBoolean) {
        break label93;
      }
      localanza.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      localanza.jdField_c_of_type_Int = (i1 + 1);
    }
    for (;;)
    {
      localanza.jdField_d_of_type_Int = 1;
      a(paramToServiceMsg, 5006, paramBoolean, new Object[] { Long.valueOf(paramLong), localanza });
      return;
      label93:
      localanza.jdField_b_of_type_Int = 2900;
      localanza.jdField_c_of_type_Int = (i1 + 1);
      localanza.jdField_a_of_type_Long = paramInt;
      localanza.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"MessageSvc.PushReaded".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      paramToServiceMsg = (SvcRequestPushReadedNotify)paramObject;
      paramFromServiceMsg = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify() vC2CReadedNotify=" + paramToServiceMsg.vC2CReadedNotify + ", vGroupReadedNotify=" + paramToServiceMsg.vGroupReadedNotify + ", vDisMsgReadedNotify=" + paramToServiceMsg.vDisReadedNotify);
      }
      a(paramToServiceMsg, paramFromServiceMsg, a(paramToServiceMsg));
      b(paramToServiceMsg, paramFromServiceMsg);
      a(paramToServiceMsg, paramFromServiceMsg);
    } while (paramFromServiceMsg.size() <= 0);
    notifyUI(6004, true, paramFromServiceMsg.toArray());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(paramString)) {
      L(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.gourp_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.gourp_msg.get();
      int i2 = paramSvcRegisterProxyMsgResp.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleTroopMsgResp_PB, gourp_msg size:" + i2);
      }
      int i1 = 0;
      if (i1 < i2)
      {
        register_proxy.SvcResponsePbPullGroupMsgProxy localSvcResponsePbPullGroupMsgProxy = (register_proxy.SvcResponsePbPullGroupMsgProxy)paramSvcRegisterProxyMsgResp.get(i1);
        if (this.jdField_d_of_type_Boolean) {
          a(2, paramToServiceMsg, paramFromServiceMsg, localSvcResponsePbPullGroupMsgProxy, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          a(2, paramToServiceMsg, paramFromServiceMsg, localSvcResponsePbPullGroupMsgProxy, true);
        }
      }
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
    if ((paramInt == 1000) && (paramString != null) && (QLog.isColorLevel())) {
      QLog.d("notification", 2, "funName:" + paramString + ",isSuccess:" + paramBoolean);
    }
  }
  
  private void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(aoon.a(paramString)).b(aoon.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void b(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.msg_info.has())
    {
      this.jdField_c_of_type_Int = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).group_num.get();
      this.jdField_d_of_type_Int = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).discuss_num.get();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg ,groupNum=" + this.jdField_c_of_type_Int + ",discussionNum=" + this.jdField_d_of_type_Int);
      }
      if ((this.jdField_c_of_type_Int == 0) || (this.jdField_j_of_type_Int >= this.jdField_c_of_type_Int)) {
        notifyUI(4003, true, null);
      }
      if ((this.jdField_d_of_type_Int == 0) || (this.jdField_k_of_type_Int >= this.jdField_d_of_type_Int)) {
        notifyUI(4002, true, null);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 6000) || (paramInt == 8002) || (paramInt == 7000) || (paramInt == 8005) || (paramInt == 8006) || (paramInt == 6010) || (paramInt == 6012) || (paramInt == 6013) || (paramInt == 8008) || (paramInt == 8010) || (paramInt == 8012) || (paramInt == 8014) || (paramInt == 3022) || (paramInt == 8035) || (paramInt == 8028) || (paramInt == 8037) || (paramInt == 8032) || (paramInt == 8040) || (paramInt == 8041) || (paramInt == 8043) || (paramInt == 8044) || (paramInt == 8045);
  }
  
  private boolean b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgGetting: " + this.jdField_g_of_type_Boolean);
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        b(true);
        f(paramBoolean);
        return false;
      }
      return true;
    }
  }
  
  private boolean b(boolean paramBoolean, ArrayList<MessageRecord> paramArrayList, Iterator<Map.Entry<Long, bcrj>> paramIterator)
  {
    Object localObject = (bcrj)((Map.Entry)paramIterator.next()).getValue();
    paramIterator = ((bcrj)localObject).jdField_a_of_type_JavaLangString;
    int i1 = ((bcrj)localObject).jdField_a_of_type_Int;
    long l1 = ((bcrj)localObject).jdField_a_of_type_Long;
    localObject = this.app.getMessageFacade().queryMsgItemByUniseq(paramIterator, i1, l1);
    if (localObject == null)
    {
      this.app.getMsgCache().a(paramIterator, i1, l1);
      return paramBoolean;
    }
    paramBoolean = a(paramBoolean, l1, (MessageRecord)localObject);
    long l2 = ((MessageRecord)localObject).time;
    long l3 = bcrg.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "msgSending:setMsgSendingInfo, uin:" + paramIterator + " istroop:" + i1 + " uniseq:" + l1 + " time:" + l2 + " currentServerTime:" + l3);
    }
    if ((paramBoolean) || ((l3 - l2) * 1000L + 30000L >= 480000L) || (l3 - l2 < 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:msg sending flag set to failed");
      }
      paramArrayList = this.app.getMessageFacade().getLastMessage(paramIterator, i1);
      this.app.getMsgCache().a(paramIterator, i1, l1);
      if ((paramArrayList != null) && (paramArrayList.uniseq == l1)) {
        paramArrayList.extraflag = 32768;
      }
      this.app.getMessageFacade().updateMsgExtraFlagByUniseq(paramIterator, i1, l1, 32768, 1002);
      notifyUI(6003, false, new String[] { paramIterator, String.valueOf(l1) });
      return paramBoolean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "msgSending:resend msg, key =" + ((MessageRecord)localObject).uniseq + "+" + ((MessageRecord)localObject).frienduin + "+" + ((MessageRecord)localObject).istroop);
    }
    acnh.b(paramArrayList, (MessageRecord)localObject, true);
    return paramBoolean;
  }
  
  @Nullable
  private msg_svc.PbSendMsgResp c(Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      return localPbSendMsgResp;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label69;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("<---handleSendDiscussionMsgRespPB:");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
    {
      QLog.e("Q.msg.MessageHandler", 2, paramObject, localException);
      label69:
      return null;
    }
  }
  
  private void c(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleFirstEnding! isPullCircleStop: " + this.jdField_c_of_type_Boolean);
      }
      this.jdField_d_of_type_Boolean = true;
      if (f()) {
        notifyUI(4017, true, null);
      }
    }
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
      this.app.getPicPreDownloader().b(paramMessageRecord, 3);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForStructing)) {
        e(paramMessageRecord);
      }
      return;
      if ((paramMessageRecord instanceof MessageForShortVideo)) {
        this.app.getShortVideoPredownloer().a((MessageForShortVideo)paramMessageRecord);
      } else if ((paramMessageRecord instanceof MessageForPtt)) {
        f(paramMessageRecord);
      } else if (((paramMessageRecord instanceof MessageForLongTextMsg)) && (paramMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
        d(paramMessageRecord);
      } else if ((paramMessageRecord instanceof MessageForScribble)) {
        this.app.getScribbleDownloader().a((MessageForScribble)paramMessageRecord);
      }
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg)
  {
    aocn localaocn;
    if ("StatSvc.SvcReqMSFLoginNotify".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramFromServiceMsg = (SvcReqMSFLoginNotify)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcReqMSFLoginNotify", new SvcReqMSFLoginNotify());
      if (paramFromServiceMsg == null) {
        break label417;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "SvcReqMSFLoginNotify status:" + paramFromServiceMsg.cStatus + "iPlatform:" + paramFromServiceMsg.iPlatform);
      }
      localaocn = (aocn)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
      if ((paramFromServiceMsg.iPlatform != 110L) || (paramFromServiceMsg.cTablet != 1)) {
        break label244;
      }
      if (paramFromServiceMsg.cStatus != 1) {
        break label211;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "ipad online now");
      }
      s();
    }
    for (int i1 = 1;; i1 = 0)
    {
      localaocn.c(i1);
      if (jdField_a_of_type_Int == 1) {
        jdField_a_of_type_Int = 1;
      }
      if (!((zng)this.app.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).a(paramFromServiceMsg.vecInstanceList)) {
        break;
      }
      i1 = 1;
      label190:
      notifyUI(6016, true, new Object[] { Byte.valueOf((byte)i1) });
      label210:
      return;
      label211:
      if (paramFromServiceMsg.cStatus == 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.MessageHandler", 4, "ipad offline now");
        }
        b(1);
      }
    }
    label244:
    if (paramFromServiceMsg.iPlatform == 1029L) {
      if (paramFromServiceMsg.cStatus == 1) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "mac online push status:" + i1 + ",cDataline:" + 1);
      }
      localaocn.b(i1);
      localaocn.h(i1);
      break;
      if (paramFromServiceMsg.cStatus == 2)
      {
        i1 = 0;
        continue;
        if (paramFromServiceMsg.iClientType != 78082L) {
          break;
        }
        if (paramFromServiceMsg.cStatus == 1) {
          i1 = 1;
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label436;
          }
          QLog.d("Q.msg.MessageHandler", 2, "watch online push status:" + i1 + ",cDataline:" + 1);
          break;
          if (paramFromServiceMsg.cStatus == 2)
          {
            i1 = 0;
            continue;
            i1 = 0;
            break label190;
            label417:
            if (!QLog.isColorLevel()) {
              break label210;
            }
            QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
            return;
          }
          i1 = 0;
        }
        label436:
        break;
      }
      i1 = 0;
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(str)) || ("OnlinePush.PbPushC2CMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(str))) {}
    try
    {
      b(paramFromServiceMsg, paramObject);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.MessageHandler", 2, "handleMessagePush_PB exception ! ", paramFromServiceMsg);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    b();
    this.jdField_g_of_type_Int = 0;
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
      notifyUI(4001, false, null);
      notifyUI(4016, false, null);
      return;
    case 1: 
      notifyUI(4001, false, null);
      return;
    }
    notifyUI(4016, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB.");
    }
    String str2 = paramToServiceMsg.getServiceCmd();
    String str1 = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    String str3 = paramToServiceMsg.extraData.getString("fileName");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i5 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    int i6 = paramToServiceMsg.extraData.getInt("msgtype");
    int i7 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i1 = bcrx.a(i7, this.app);
    int i2 = i1;
    if (i1 == 1024) {
      i2 = paramToServiceMsg.extraData.getInt("uintype", i1);
    }
    int i3 = 0;
    if (acnh.a(i2) == 1032) {
      i3 = paramToServiceMsg.extraData.getInt("key_confess_topicid", 0);
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("RichNotify", false);
    i1 = 0;
    paramObject = a(paramObject);
    if ((paramObject == null) || (!paramObject.result.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : server did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
    }
    SendMessageHandler localSendMessageHandler;
    label455:
    int i4;
    label489:
    do
    {
      break label455;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + str2 + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + " peerUin:" + str1 + " uniseq:" + l1 + " msgSeq:" + l2 + " msgType:" + i6 + " uinType:" + i2 + " routingType:" + i7);
        }
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
        b(paramToServiceMsg, paramFromServiceMsg);
        localSendMessageHandler = a(l2);
        if (localSendMessageHandler != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + str2 + ",no SendMessageHandler found.");
        }
        agfe.a().a(this.app, l1);
        return;
        if (paramObject.result.get() != 0) {
          i1 = paramObject.result.get();
        }
      }
      if (i1 != 255) {
        break label637;
      }
      i4 = 1;
      if (i4 == 0) {
        break;
      }
      localSendMessageHandler.getClass();
    } while (a(localSendMessageHandler, "server"));
    i1 = a(str1, i2, i1);
    if ((i1 == 0) || (i1 == 241)) {
      a(paramToServiceMsg, paramFromServiceMsg, str1, l1, str3, l2, i5, i2, i3, bool, paramObject, localSendMessageHandler);
    }
    for (bool = false;; bool = paramFromServiceMsg.b())
    {
      ((axii)this.app.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(str1, i2, l1, i1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
      omx.a(this.app, i6, str1, i2, l1);
      if (bool) {
        break;
      }
      agfe.a().a(this.app, l1);
      return;
      label637:
      i4 = 0;
      break label489;
      paramFromServiceMsg = new anyp(this, paramToServiceMsg, paramFromServiceMsg, str1, l1, l2, l3, i5, i6, i7, i2, false, i3, bool, i1, paramObject, localSendMessageHandler).a();
      if (paramFromServiceMsg.a()) {
        break;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ("OidbSvc.0xb31".equalsIgnoreCase(paramString)) {
      M(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.group_list.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleTroopList!");
      }
      bgiy localbgiy = (bgiy)this.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.group_list.get();
      this.jdField_a_of_type_JavaUtilList = paramSvcRegisterProxyMsgResp;
      Object localObject1 = this.jdField_a_of_type_Bcrg;
      bcrg.jdField_a_of_type_Bcrl.jdField_a_of_type_JavaUtilList = paramSvcRegisterProxyMsgResp;
      int i1 = 0;
      if (i1 < paramSvcRegisterProxyMsgResp.size())
      {
        localObject1 = (register_proxy.GroupList)paramSvcRegisterProxyMsgResp.get(i1);
        if (localObject1 == null) {}
        label564:
        label575:
        for (;;)
        {
          i1 += 1;
          break;
          String str = String.valueOf(((register_proxy.GroupList)localObject1).group_code.get());
          Object localObject2 = this.jdField_a_of_type_Bcrg.b(str);
          long l3 = this.jdField_a_of_type_Bcrg.j(str);
          long l2 = 0L;
          long l1 = l2;
          if (localObject2 != null)
          {
            l1 = l2;
            if (localObject2.length > 0) {
              l1 = ((Long)localObject2[0]).longValue();
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).setLength(0);
            ((StringBuilder)localObject2).append("handleNewRegisterProxyMsg getGroupList groupCode=").append(((register_proxy.GroupList)localObject1).group_code.get()).append(" groupSeq=").append(((register_proxy.GroupList)localObject1).group_seq.get()).append(" memberSeq=").append(((register_proxy.GroupList)localObject1).member_seq.get()).append(" mask=").append(((register_proxy.GroupList)localObject1).mask.get()).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l3).append(" redpack_time=").append(((register_proxy.GroupList)localObject1).redpack_time.get()).append(" hasMsg=").append(((register_proxy.GroupList)localObject1).has_msg.get());
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
          }
          if ((((register_proxy.GroupList)localObject1).mask.get() == 1L) || (((register_proxy.GroupList)localObject1).mask.get() == 4L) || ((((register_proxy.GroupList)localObject1).mask.get() == 3L) && (str.equals(localbgiy.a()))))
          {
            this.jdField_a_of_type_Bcrg.c(str, new Object[] { Long.valueOf(((register_proxy.GroupList)localObject1).member_seq.get()), Long.valueOf(((register_proxy.GroupList)localObject1).group_seq.get()) });
            if (l1 < ((register_proxy.GroupList)localObject1).member_seq.get())
            {
              if (((register_proxy.GroupList)localObject1).group_seq.get() > l3) {
                break label564;
              }
              a(4, paramToServiceMsg, paramFromServiceMsg, localObject1);
            }
          }
          for (;;)
          {
            if (((register_proxy.GroupList)localObject1).mask.get() == 0L) {
              break label575;
            }
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            }
            localObject2 = new Setting();
            ((Setting)localObject2).Path = ("message.group.policy." + str);
            ((Setting)localObject2).Value = String.valueOf(((register_proxy.GroupList)localObject1).mask.get());
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            break;
            this.jdField_a_of_type_Bcrg.a(str, 1);
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    while (paramToServiceMsg.extraData.getByte("binaryPic", (byte)0).byteValue() == 1) {
      return;
    }
    a("actSendC2CProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(bhch.a(((Long)paramArrayList.next()).longValue()));
    }
    a(localArrayList);
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt == 3002) || (paramInt == 3013) || (paramInt == 3008);
  }
  
  private void d(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    if (this.jdField_c_of_type_Long < 0L) {
      this.jdField_c_of_type_Long = 0L;
    }
    if (this.jdField_c_of_type_Long > 300L) {
      this.jdField_c_of_type_Long = 300L;
    }
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    ((MessageForLongTextMsg)paramMessageRecord).loading = true;
    String str = paramMessageRecord.getExtInfoFromExtStr("long_text_msg_resid");
    if (TextUtils.isEmpty(str)) {
      QLog.e("Q.msg.MessageHandler", 1, "LongTextMsg resid is null!");
    }
    axii.a(this.app, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, str);
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        notifyUI(3011, false, null);
      }
    }
    else {
      return;
    }
    notifyUI(3011, true, new Object[] { (bcrr)paramObject });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.o < 2)
    {
      send(paramToServiceMsg);
      this.o += 1;
      return;
    }
    a(5002, false, null);
    this.o = 0;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendTroopMessageRespPB enter");
    }
    String str = paramToServiceMsg.extraData.getString("groupuin");
    int i3 = paramToServiceMsg.extraData.getInt("msgtype");
    Object localObject = paramToServiceMsg.getServiceCmd();
    msg_svc.PbSendMsgResp localPbSendMsgResp = b(paramObject);
    int i1 = 0;
    if ((localPbSendMsgResp == null) || (!localPbSendMsgResp.result.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB:server did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
    }
    long l1;
    long l2;
    boolean bool1;
    label261:
    int i2;
    label297:
    do
    {
      break label261;
      for (;;)
      {
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
        b(paramToServiceMsg, paramFromServiceMsg);
        l1 = paramToServiceMsg.extraData.getLong("msgSeq");
        l2 = paramToServiceMsg.extraData.getLong("uniseq");
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendTroopMessageRespPB: ---cmd:" + (String)localObject + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",SendTroopMessageResp : peerUin:" + str + ",uniseq:" + l2 + ",msgSeq:" + l1);
        }
        bool1 = false;
        paramObject = a(l1);
        if (paramObject != null) {
          break;
        }
        agfe.a().a(this.app, l2);
        return;
        if (localPbSendMsgResp.result.get() != 0) {
          i1 = localPbSendMsgResp.result.get();
        }
      }
      if (i1 != 255) {
        break label588;
      }
      i2 = 1;
      if (i2 == 0) {
        break;
      }
      paramObject.getClass();
    } while (a(paramObject, "server"));
    localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    ((TroopManager)localObject).e(str);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(1);
    arrayOfObject[2] = Integer.valueOf(i1);
    arrayOfObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    arrayOfObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    arrayOfObject[5] = Long.valueOf(l2);
    label421:
    boolean bool2;
    if (localPbSendMsgResp != null)
    {
      paramObject = localPbSendMsgResp.errmsg.get();
      arrayOfObject[6] = paramObject;
      bool2 = a(str, i1, (TroopManager)localObject, arrayOfObject);
      i2 = bcrx.a(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.app);
      if (!bool2) {
        break label601;
      }
      a(paramToServiceMsg, paramFromServiceMsg, str, localPbSendMsgResp, l2, i2);
    }
    for (;;)
    {
      a(paramToServiceMsg, paramFromServiceMsg, i1, l2, bool2);
      d(paramToServiceMsg, paramFromServiceMsg, true);
      a(l1);
      c(paramToServiceMsg, paramFromServiceMsg);
      ((axii)this.app.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(paramToServiceMsg.extraData.getString("groupuin"), 1, l2, i1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
      omx.a(this.app, i3, str, 1, l2);
      if (bool1) {
        break;
      }
      agfe.a().a(this.app, l2);
      return;
      label588:
      i2 = 0;
      break label297;
      paramObject = "";
      break label421;
      label601:
      paramObject = new anyr(this, paramToServiceMsg, paramFromServiceMsg, str, localPbSendMsgResp, i1, l1, l2, false, arrayOfObject, i2).a();
      if (paramObject.a()) {
        break;
      }
      bool1 = paramObject.b();
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ("RegPrxySvc.GetBoxFilter".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null) {
        break label27;
      }
      QLog.e("Q.msg.MessageHandler", 1, "handleGetBoxFilterResp return by null data");
    }
    label27:
    do
    {
      return;
      paramToServiceMsg = new oidb_cmd0xefe.RspBody();
      if ((paramObject instanceof oidb_cmd0xefe.RspBody)) {
        paramToServiceMsg = (oidb_cmd0xefe.RspBody)paramObject;
      }
      for (;;)
      {
        paramFromServiceMsg = (almg)this.mApp.getManager(QQManagerFactory.TEMP_MSG_BOX);
        if (!paramToServiceMsg.mute_friend.has()) {
          break;
        }
        paramObject = paramToServiceMsg.mute_friend.get().iterator();
        while (paramObject.hasNext())
        {
          paramString = (Long)paramObject.next();
          if (!paramFromServiceMsg.a(String.valueOf(paramString), this.app))
          {
            paramFromServiceMsg.a(String.valueOf(paramString), this.app);
            paramFromServiceMsg.b(String.valueOf(paramString));
          }
        }
        try
        {
          paramFromServiceMsg = (oidb_cmd0xefe.RspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (Exception paramFromServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleGetBoxFilterResp : decode oidb_cmd0xefe.RspBody:", paramFromServiceMsg);
          }
        }
      }
      if (paramToServiceMsg.whitelist.has())
      {
        paramObject = paramToServiceMsg.whitelist.get().iterator();
        while (paramObject.hasNext())
        {
          paramString = (Long)paramObject.next();
          paramFromServiceMsg.a(String.valueOf(paramString));
          paramFromServiceMsg.c(String.valueOf(paramString));
        }
      }
    } while (!paramToServiceMsg.update_time.has());
    allw.a(paramToServiceMsg.update_time.get());
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
    this.jdField_a_of_type_Bcrg.a(paramString1, 2);
    Object localObject = this.jdField_a_of_type_Bcrg.a(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------handleTroopMsgResponseFinishedAndNotify troopUin: " + paramString1 + ", funcName:" + paramString2);
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_Bcrg.b(paramString1);
      paramString2 = ((ArrayList)localObject).iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 2)) {
          a("troop_processor").a(1001, new Object[] { localObject, null, Boolean.valueOf(false) });
        }
      }
    }
    paramString1 = this.jdField_a_of_type_Bcrg.a(paramString1);
    if (paramString1 != null) {
      ((bfkb)a("troop_processor")).a(paramString1);
    }
  }
  
  private void d(ArrayList<MessageRecord> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      g((MessageRecord)paramArrayList.next());
    }
  }
  
  private boolean d(int paramInt)
  {
    switch (paramInt)
    {
    case 35: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    default: 
      return false;
    }
    return true;
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    Object localObject = (MessageForStructing)paramMessageRecord;
    if (((MessageForStructing)localObject).structingMsg == null) {
      return;
    }
    if ((!paramMessageRecord.isread) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 38) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mResid)))
    {
      bibu localbibu = (bibu)this.app.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      boolean bool = localbibu.a((MessageForStructing)localObject);
      localObject = localbibu.a();
      if ((bool) && (this.app.mAutomator != null) && (this.app.mAutomator.c()) && (localObject != null) && (((bibt)localObject).jdField_d_of_type_Long == 0L) && (((bibt)localObject).jdField_a_of_type_Long != 0L)) {
        localbibu.a(((bibt)localObject).jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      this.app.getPicPreDownloader().b(paramMessageRecord, 1);
      return;
      if (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 35) {
        axio.a().a((MessageForStructing)localObject, this.app);
      } else if (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 107) {
        axio.a().a((MessageForStructing)localObject, this.app);
      }
    }
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    long l1;
    long l2;
    long l3;
    long l4;
    if (("StreamSvr.PushStreamMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (paramObject != null))
    {
      localObject = (Object[])paramObject;
      l1 = ((Long)localObject[0]).longValue();
      paramFromServiceMsg = (StreamInfo)localObject[1];
      paramObject = (StreamData)localObject[2];
      l2 = ((Long)localObject[3]).longValue();
      l3 = ((Long)localObject[4]).longValue();
      l4 = ((Long)localObject[5]).longValue();
      localObject = new ptt_reserve.ReserveStruct();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.vPbData == null)) {}
    }
    try
    {
      ((ptt_reserve.ReserveStruct)localObject).mergeFrom(paramFromServiceMsg.vPbData);
      if (paramFromServiceMsg != null) {
        this.app.getTransFileController().onReceiveStreamAction(paramFromServiceMsg, paramObject, l1, l2, l3, l4, (ptt_reserve.ReserveStruct)localObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        QLog.e("Q.msg.MessageHandler", 1, "parse streaminfo.vPbData failed.", localInvalidProtocolBufferMicroException);
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(paramToServiceMsg, 3012, false, null);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1;
    if ("ADMsgSvc.PushMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramFromServiceMsg = (AdMsgInfo)paramObject;
      if ((paramFromServiceMsg != null) && (String.valueOf(paramFromServiceMsg.uDstUin).equalsIgnoreCase(paramToServiceMsg.getUin())))
      {
        l1 = paramFromServiceMsg.utime;
        paramToServiceMsg = paramFromServiceMsg.strMsgContent;
        if (paramFromServiceMsg.uMsgType != 9) {
          break label192;
        }
        paramObject = bcsa.a(-2003);
        paramObject.selfuin = this.app.getCurrentAccountUin();
        paramObject.frienduin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
        paramObject.senderuin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
        paramObject.msg = paramToServiceMsg;
        paramObject.time = l1;
        paramObject.msgtype = -2003;
        paramObject.istroop = 0;
        if (!anyv.a(this.app, paramObject, false))
        {
          this.app.getMessageFacade().addMessage(paramObject, this.app.getCurrentAccountUin());
          a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramFromServiceMsg.uSrcUin), 1, true, false, null);
        }
      }
    }
    label192:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramFromServiceMsg.uMsgType != 513);
        int i1 = aqwd.a(paramToServiceMsg);
        paramObject = aqwd.a(paramToServiceMsg);
        switch (i1)
        {
        case 1: 
        case 3: 
        default: 
          return;
        }
      } while ((paramObject == null) || ((!paramObject.equals("WAP")) && (!paramObject.equals("WAPI")) && (!paramObject.equals("TMTWAP")) && (!paramObject.equals("TMTWAPI")) && (!paramObject.equals("LOCAL"))));
      paramObject = bcsa.a(-2004);
      paramObject.selfuin = this.app.getCurrentAccountUin();
      paramObject.frienduin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
      paramObject.senderuin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
      paramObject.msg = paramToServiceMsg;
      paramObject.time = l1;
      paramObject.msgtype = -2004;
      paramObject.istroop = 0;
    } while (anyv.a(this.app, paramObject, false));
    this.app.getMessageFacade().addMessage(paramObject, this.app.getCurrentAccountUin());
    a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramFromServiceMsg.uSrcUin), 1, true, false, null);
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "dim.actSendGrpTmpMsg", paramBoolean, l1, l2, localHashMap, "");
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
    ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
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
    this.jdField_a_of_type_Bcrg.b(paramString1, 2);
    paramString2 = this.jdField_a_of_type_Bcrg.b(paramString1);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = new ArrayList(paramString2);
      this.jdField_a_of_type_Bcrg.d(paramString1);
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 3)) {
          a("disc_processor").a(1001, new Object[] { localObject[0], localObject[1], localObject[2], Boolean.valueOf(false) });
        }
      }
    }
    paramString1 = this.jdField_a_of_type_Bcrg.a(paramString1);
    if (paramString1 != null) {
      ((aonw)a("disc_processor")).a(paramString1);
    }
  }
  
  private boolean e()
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
  
  private void f(MessageRecord paramMessageRecord)
  {
    bahy.a(this.app).a((MessageForPtt)paramMessageRecord);
    int i1 = 4;
    if (paramMessageRecord.istroop == 0) {
      i1 = 1;
    }
    for (;;)
    {
      PttInfoCollector.reportPTTPV(this.app, i1, false, 3);
      return;
      if (paramMessageRecord.istroop == 1) {
        i1 = 3;
      } else if (paramMessageRecord.istroop == 3000) {
        i1 = 2;
      }
    }
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    boolean bool1;
    boolean bool2;
    if ("MessageSvc.PushNotify".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      localObject = null;
      String str = null;
      if (!(paramObject instanceof RequestPushNotify)) {
        break label339;
      }
      RequestPushNotify localRequestPushNotify = (RequestPushNotify)paramObject;
      this.app.userActiveStatus = localRequestPushNotify.wUserActive;
      if ((localRequestPushNotify.wGeneralFlag & 0x8) != 8) {
        break label334;
      }
      str = Long.toString(localRequestPushNotify.lBindedUin);
      if ((localRequestPushNotify.wGeneralFlag & 0x10) == 16) {
        this.app.getMsgHandler().a().a(localRequestPushNotify);
      }
      bool1 = true;
      if (localRequestPushNotify.ping_flag == 1L) {
        a(localRequestPushNotify.lUin, localRequestPushNotify.svrip, paramFromServiceMsg.getRequestSsoSeq());
      }
      if ((localRequestPushNotify.wGeneralFlag & 0x20) != 32) {
        break label300;
      }
      bgzw.a(true);
      localObject = str;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        if (!bool1) {
          break label307;
        }
        localObject = "SUB_ACCOUNT";
        label164:
        QLog.d((String)localObject, 2, String.format("MessageSvc.PushNotify, notify.wUserActive: %d isSubAccount: %s, cmd: %s, wGeneralFlag:%d, bytesServerBuf: %s, ping_flag%d", new Object[] { Integer.valueOf(localRequestPushNotify.wUserActive), Boolean.valueOf(bool1), localRequestPushNotify.strCmd, Integer.valueOf(localRequestPushNotify.wGeneralFlag), localRequestPushNotify.bytes_server_buf, Long.valueOf(localRequestPushNotify.ping_flag) }));
        bool2 = bool1;
        localObject = str;
      }
    }
    for (;;)
    {
      if (bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount push and start get subaccount msg, subUin=" + (String)localObject);
        }
        if (localObject != null) {
          bdxj.a(this.app, (String)localObject, true);
        }
      }
      label300:
      label307:
      while (!this.app.mAutomator.a())
      {
        return;
        bgzw.a(false);
        break;
        localObject = "Q.msg.MessageHandler";
        break label164;
      }
      a(paramFromServiceMsg, paramObject);
      return;
      label334:
      bool1 = false;
      break;
      label339:
      bool2 = false;
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
    int i2 = bcrx.a(i4, this.app);
    agfe.a().a(this.app, l1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendC2CMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l1 + " msgSeq:" + l2 + " msgType:" + i3 + " uinType:" + i2 + " routingType:" + i4 + " retryIndex:" + i1);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l2);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label295;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label295;
      }
    }
    label295:
    while ((480000L != l3) && (!((SendMessageHandler)localObject).a())) {
      return;
    }
    i3 = b(i4);
    localObject = new Object[6];
    localObject[0] = str;
    localObject[1] = Integer.valueOf(i2);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(l3);
    localObject[5] = Long.valueOf(l1);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    a(i3, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((anza)localObject).jdField_c_of_type_Int = i1;
      ((anza)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l1), localObject });
      a(str, i2, l1, false);
    }
    b(paramToServiceMsg, paramFromServiceMsg, false);
    a(l2);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      w(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "dim.actSendWpaMsg", paramBoolean, l1, l2, localHashMap, "");
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
    ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  private boolean f()
  {
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
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
        if (!((anys)localIterator.next()).jdField_a_of_type_Boolean) {
          continue;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "hasFirstGroupMsg flag =" + bool);
        }
        if (!bool)
        {
          this.jdField_d_of_type_Boolean = false;
          return true;
        }
      }
      return false;
      label116:
      boolean bool = false;
    }
  }
  
  private void g(MessageRecord paramMessageRecord)
  {
    this.app.getMsgCache().d(paramMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "msgSending:addSendingCache suc");
    }
    this.app.getMessageFacade().setChangeAndNotify(paramMessageRecord);
    if ((paramMessageRecord.msgtype == -1051) && ((paramMessageRecord instanceof MessageForLongTextMsg)) && (((MessageForLongTextMsg)paramMessageRecord).structingMsg == null))
    {
      ((axii)this.app.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(this.app, paramMessageRecord, true);
      return;
    }
    a(paramMessageRecord, null, true);
  }
  
  private void g(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = paramFromServiceMsg.getServiceCmd();
    if (("RegPrxySvc.infoLogin".equalsIgnoreCase(paramObject)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(paramObject)))
    {
      if (paramFromServiceMsg.getResultCode() == 1000) {
        notifyUI(4004, true, null);
      }
    }
    else {
      return;
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request timeout!");
      }
      notifyUI(4004, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() == -20009)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request overload protection!");
      }
      notifyUI(4004, false, null);
      notifyUI(4001, false, null);
      notifyUI(4016, false, null);
      notifyUI(4003, false, null);
      notifyUI(4002, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request error!");
    }
    notifyUI(4004, false, null);
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
    int i4 = bcrx.a(i2, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendGrpMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i1 + " uinType:" + i4 + " routingType:" + i2 + " retryIndex:" + i3);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    agfe.a().a(this.app, l3);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label295;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label295;
      }
    }
    label295:
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
    a(3002, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((anza)localObject).jdField_c_of_type_Int = i1;
      ((anza)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
    }
    d(paramToServiceMsg, paramFromServiceMsg, false);
    a(l1);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        e(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    else {
      return;
    }
    a(paramToServiceMsg, 3012, true, new Object[] { paramObject });
  }
  
  private void g(String paramString)
  {
    e(paramString, "closeDisOnlineMsgCache");
  }
  
  private boolean g()
  {
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length > 1)) {
          break label77;
        }
        return true;
        if (i1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length) {
          break label73;
        }
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1].b())) {
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
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg = l3 + "";
    this.app.getMessageFacade().updateMsgExtraFlagByUniseq(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    a(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(0), null, Long.valueOf(l4), Long.valueOf(l2) });
    if ((480000L == l4) && (a(l1) != null)) {
      a(l1);
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {}
    try
    {
      v(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp_PB exception ! ", paramObject);
      }
      v(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void h(String paramString)
  {
    this.app.getCurrentAccountUin();
    d(paramString, "closeTroopOnlineMsgCache");
  }
  
  private boolean h()
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
    int i4 = bcrx.a(i2, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendDisMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i1 + " uinType:" + i4 + " routingType:" + i2 + " retryIndex:" + i3);
    }
    agfe.a().a(this.app, l3);
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label295;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label295;
      }
    }
    label295:
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
    a(3008, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((anza)localObject).jdField_c_of_type_Int = i1;
      ((anza)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
    }
    a(paramToServiceMsg, paramFromServiceMsg, false);
    a(l1);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramToServiceMsg.extraData.getBoolean("key_from_parallel_pull", false)) {
        ThreadManager.post(new MessageHandler.8(this, paramToServiceMsg, paramFromServiceMsg, paramObject), 8, null, false);
      }
    }
    else {
      return;
    }
    try
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, false);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", paramObject);
      }
      t(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleTimeOut serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (aoon.a().containsKey(str)) {
      b(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      do
      {
        return;
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
        {
          b(paramToServiceMsg);
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
        if ("MessageSvc.PbSendMsg".equalsIgnoreCase(str))
        {
          m(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0xa89".equalsIgnoreCase(str))
        {
          x(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
        {
          h(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (!"PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str)) {
          break;
        }
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
      if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<---handle timeout - get thirdqq unread number");
        }
        a().a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      s(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("RegPrxySvc.infoLogin".equalsIgnoreCase(str)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str)))
      {
        g(paramFromServiceMsg, null);
        return;
      }
      if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
      {
        w(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        H(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"MessageSvc.PbReceiptRead".equalsIgnoreCase(str));
    y(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) || ("PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str))) && (paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
    {
      if (!"getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action"))) {
        break label115;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handle response - get thirdqq unread number");
      }
    }
    try
    {
      a().a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handle response - get thirdqq unread number exception ! ", paramObject);
      }
      a().b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    try
    {
      label115:
      if (isPbReq(paramToServiceMsg))
      {
        F(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp exception ! ", paramObject);
      }
      r(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullGroupMsgSeq)paramObject);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str;
    int i1;
    if ("AccostSvc.ReqDeleteBlackList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      str = paramToServiceMsg.extraData.getString("deleteUin");
      i1 = paramToServiceMsg.extraData.getInt("fromType");
      if (paramFromServiceMsg.getResultCode() == 1000) {
        f(str);
      }
      if (paramFromServiceMsg.getResultCode() != 1000) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      notifyUI(6002, bool, new Object[] { str, Integer.valueOf(i1) });
      return;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      try
      {
        if ((this.app.mAutomator != null) && (!this.app.mAutomator.d()))
        {
          w(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetC2CMessageResp_PB exception ! ", paramFromServiceMsg);
        }
        c(paramToServiceMsg);
      }
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("AccostSvc.ReqInsertBlackList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("insertUin");
      if (paramFromServiceMsg.getResultCode() == 1000) {
        e(paramToServiceMsg);
      }
      if (paramFromServiceMsg.getResultCode() != 1000) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      notifyUI(6001, bool, paramToServiceMsg);
      return;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1;
    if ("MessageSvc.PbSendMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
      if (!anyv.a(i1, this.app)) {
        break label53;
      }
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      a(paramToServiceMsg, "0");
      return;
      label53:
      if (i1 == 9) {
        a().a(7002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      } else if (i1 == 13) {
        a().a(7003, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      } else if (i1 == 4) {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (i1 == 2) {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (anyv.a(i1, this.app)) {
      f(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      a(paramToServiceMsg, String.valueOf(paramFromServiceMsg.getResultCode()));
      return;
      if (i1 == 9) {
        a().b(paramToServiceMsg, paramFromServiceMsg);
      } else if (i1 == 13) {
        a().c(paramToServiceMsg, paramFromServiceMsg);
      } else if (i1 == 4) {
        i(paramToServiceMsg, paramFromServiceMsg);
      } else if (i1 == 2) {
        g(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte;
    if ("OnlinePush.PbPushTransMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramObject = paramFromServiceMsg.getWupBuffer();
      arrayOfByte = new byte[paramObject.length - 4];
      PkgTools.copyData(arrayOfByte, 0, paramObject, 4, paramObject.length - 4);
      paramObject = new OnlinePushTrans.PbMsgInfo();
    }
    try
    {
      paramObject.mergeFrom(arrayOfByte);
      if (paramObject != null)
      {
        if ((paramObject.uint32_general_flag.get() & 0x20) == 32)
        {
          bgzw.a(true);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, new Object[] { "PbPushTransMsg muteGeneralFlag:", Integer.valueOf(paramObject.uint32_general_flag.get()) });
          }
          if (paramObject.msg_type.get() != 207) {
            break label233;
          }
          a(paramObject.msg_data.get().toByteArray());
        }
      }
      else
      {
        paramToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
        if (paramObject != null)
        {
          i1 = paramFromServiceMsg.getRequestSsoSeq();
          paramToServiceMsg.extraData.putInt("svrip", paramObject.svr_ip.get());
          paramToServiceMsg.extraData.putInt("seq", i1);
        }
        paramToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.app.getCurrentAccountUin()));
        paramToServiceMsg.setNeedCallback(false);
        send(paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        int i1;
        paramObject.printStackTrace();
        paramObject = null;
        continue;
        bgzw.a(false);
        continue;
        label233:
        if ((paramObject.msg_type.get() == 44) || (paramObject.msg_type.get() == 34))
        {
          a().a(3, 1, false);
          long l1;
          long l2;
          if (paramObject.msg_type.get() == 34)
          {
            paramToServiceMsg = (bgkf)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            paramToServiceMsg = paramObject.msg_data.get().toByteArray();
            l1 = PkgTools.getLongData(paramToServiceMsg, 0);
            i1 = paramToServiceMsg[4];
            l2 = PkgTools.getLongData(paramToServiceMsg, 5);
            paramObject.from_uin.get();
            ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(String.valueOf(l1), String.valueOf(l2), i1);
            paramToServiceMsg = (OnlinePushTrans.ExtGroupKeyInfo)paramObject.ext_group_key_info.get();
            if (paramToServiceMsg != null)
            {
              l1 = paramToServiceMsg.cur_max_seq.get();
              l2 = paramToServiceMsg.cur_time.get();
              if (QLog.isColorLevel()) {
                QLog.d("GrayTipsForTroop", 2, "OnlinePushTrans 0x22 maxseq = " + l1 + ", maxTime = " + l2);
              }
            }
          }
          else if (paramObject.msg_type.get() == 44)
          {
            paramToServiceMsg = paramObject.msg_data.get().toByteArray();
            long l3 = PkgTools.getLongData(paramToServiceMsg, 0);
            i1 = paramToServiceMsg[4];
            i1 = paramToServiceMsg[5];
            if ((i1 == 0) || (i1 == 1)) {
              l2 = PkgTools.getLongData(paramToServiceMsg, 6);
            }
            for (l1 = 0L;; l1 = PkgTools.getLongData(paramToServiceMsg, 10))
            {
              if (QLog.isColorLevel()) {
                QLog.d(".troop.push_msg", 2, new Object[] { "GroupCode: ", Long.valueOf(l3) });
              }
              AIOUtils.postDelayedChatPieMessage(".troop.push_msg", this.app, 86, 0, 0, Arrays.asList(new Long[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1) }), 500);
              break;
              l2 = PkgTools.getLongData(paramToServiceMsg, 6);
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
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1005, false, null);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("AccostSvc.ClientMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramObject = (RespClientMsg)paramObject;
      if (paramObject == null) {
        h(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    else
    {
      return;
    }
    paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    a(l1);
    if (paramObject.stHeader.eReplyCode == 0)
    {
      this.app.getMsgCache().a(String.valueOf(paramToServiceMsg.extraData.getLong("to")), 1001, l2);
      notifyUI(6003, true, new String[] { String.valueOf(paramToServiceMsg.extraData.getLong("to")), l2 + "" });
      return;
    }
    int i1 = paramObject.stHeader.eReplyCode;
    paramToServiceMsg = l3 + "";
    this.app.getMessageFacade().updateMsgExtraFlagByUniseq(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    a(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(i1), null, Long.valueOf(l4), Long.valueOf(l2) });
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1005, false, null);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendDiscussionMsgRespPB enter");
    }
    if (paramObject == null) {}
    Object localObject1;
    int i2;
    long l1;
    long l2;
    int i3;
    Object localObject2;
    label246:
    do
    {
      return;
      localObject1 = c(paramObject);
      i2 = a((msg_svc.PbSendMsgResp)localObject1);
      paramFromServiceMsg.extraData.putLong("ServerReplyCode", i2);
      b(paramToServiceMsg, paramFromServiceMsg);
      l1 = paramToServiceMsg.extraData.getLong("uniseq");
      l2 = paramToServiceMsg.extraData.getLong("msgSeq");
      i3 = paramToServiceMsg.extraData.getInt("msgtype");
      paramObject = paramToServiceMsg.extraData.getString("uToUin");
      localObject2 = paramToServiceMsg.getServiceCmd();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendDiscussionMsgRespPB: ---cmd:" + (String)localObject2 + "----replyCode:" + i2 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + "SendDiscussionMsgResp : peerUin:" + paramObject + ",uniseq:" + l1 + ",msgSeq:" + l2);
      }
      localObject2 = a(l2);
      if (localObject2 == null)
      {
        agfe.a().a(this.app, l1);
        return;
      }
      if (i2 != 255) {
        break label429;
      }
      i1 = 1;
      if (i1 == 0) {
        break;
      }
      localObject2.getClass();
    } while (a((SendMessageHandler)localObject2, "server"));
    boolean bool2 = d(i2);
    int i1 = bcrx.a(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.app);
    if (bool2) {
      a(paramToServiceMsg, paramFromServiceMsg, (msg_svc.PbSendMsgResp)localObject1, l1, paramObject, i1);
    }
    for (boolean bool1 = false;; bool1 = ((anyq)localObject1).b())
    {
      b(paramToServiceMsg, paramFromServiceMsg, i2, l1, bool2);
      a(paramToServiceMsg, paramFromServiceMsg, true);
      a(l2);
      c(paramToServiceMsg, paramFromServiceMsg);
      ((axii)this.app.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(paramToServiceMsg.extraData.getString("uToUin"), 3000, l1, i2, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
      omx.a(this.app, i3, paramObject, 3000, l1);
      if (bool1) {
        break;
      }
      agfe.a().a(this.app, l1);
      return;
      label429:
      i1 = 0;
      break label246;
      localObject1 = new anyq(this, paramToServiceMsg, paramFromServiceMsg, (msg_svc.PbSendMsgResp)localObject1, i2, false, l1, l2, paramObject, i1).a();
      if (((anyq)localObject1).a()) {
        break;
      }
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1003, false, null);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TransService.ReqGetSign".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramObject = (bcrq)paramObject;
      if (paramObject == null) {
        a(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    else
    {
      return;
    }
    this.app.setSig(paramObject.a, paramObject.b);
    a(5002, true, null);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1003, false, null);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2;
    int i4;
    cmd0x9db.RspBody localRspBody;
    int i1;
    long l2;
    int i3;
    long l1;
    if ("OidbSvc.0x9db".equals(paramFromServiceMsg.getServiceCmd()))
    {
      i2 = 0;
      i4 = 0;
      localRspBody = new cmd0x9db.RspBody();
      i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      l2 = 0L;
      i3 = -1;
      if (localRspBody.int32_result.has()) {
        i3 = localRspBody.int32_result.get();
      }
      if ((i1 != 0) || (i3 != 0)) {
        break label290;
      }
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
        break label399;
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
        notifyUI(8017, true, new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Long.toString(l1), Integer.valueOf(i1) });
        return;
        label290:
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
        notifyUI(8017, false, new Object[] { Integer.valueOf(i4), Integer.valueOf(i3), paramFromServiceMsg });
        return;
      }
      label399:
      i1 = 0;
      paramFromServiceMsg = null;
      l1 = l2;
    }
  }
  
  private void r()
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    bdla.b(this.app, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.jdField_j_of_type_Boolean = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject3 = ((Context)localObject1).getString(2131694359);
    String str = ((Context)localObject1).getString(2131694359);
    Object localObject2 = bgyo.a(((Context)localObject1).getResources(), 2130844185);
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    localObject3 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject3).setWhen(System.currentTimeMillis());
    if (localObject2 != null) {
      ((NotificationCompat.Builder)localObject3).setLargeIcon((Bitmap)localObject2);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject3).setSmallIcon(2130844186);
      }
      localObject2 = new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION");
      ((Intent)localObject2).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject2).putExtra("param_notifyid", 264);
      ((NotificationCompat.Builder)localObject3).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0));
      localObject1 = ((NotificationCompat.Builder)localObject3).build();
      if (localQQNotificationManager == null) {
        break;
      }
      localQQNotificationManager.cancel("Q.msg.MessageHandler_PcOnlineNotifition", 264);
      bkxs.a(this.app.getApp(), 0, (Notification)localObject1);
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_OTHER");
      localQQNotificationManager.notify("Q.msg.MessageHandler_PcOnlineNotifition", 264, (Notification)localObject1);
      this.jdField_b_of_type_JavaLangRunnable = new MessageHandler.9(this, localQQNotificationManager);
      ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
      return;
      ((NotificationCompat.Builder)localObject3).setLargeIcon(bgyo.a(((Context)localObject1).getResources(), 2130844185));
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 0;
    if (paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      paramToServiceMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
    for (;;)
    {
      this.q = 0;
      notifyUI(4003, false, paramToServiceMsg);
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
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ("OidbSvc.0x4ff_42024".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
    }
    else
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int i1;
          boolean bool2;
          paramFromServiceMsg.printStackTrace();
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 ret=" + i1);
        }
        if ((i1 == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          i1 = paramToServiceMsg.length;
          bool2 = true;
          bool1 = bool2;
          if (4 > i1) {
            break label216;
          }
          paramToServiceMsg = String.valueOf(PkgTools.getLongData(paramToServiceMsg, 0));
          if (paramToServiceMsg != null)
          {
            bool1 = bool2;
            if (paramToServiceMsg.equals(this.app.getAccount())) {
              break label216;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 uin error");
          }
        }
      }
    }
    label216:
    while (!QLog.isColorLevel())
    {
      return;
      bool1 = false;
    }
    QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 suc=" + bool1);
  }
  
  private void s()
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    bdla.b(this.app, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.jdField_k_of_type_Boolean = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject3 = ((Context)localObject1).getString(2131694355);
    String str = ((Context)localObject1).getString(2131694355);
    Object localObject2 = bgyo.a(((Context)localObject1).getResources(), 2130844183);
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    localObject3 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject3).setWhen(System.currentTimeMillis());
    if (localObject2 != null) {
      ((NotificationCompat.Builder)localObject3).setLargeIcon((Bitmap)localObject2);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject3).setSmallIcon(2130844184);
      }
      localObject2 = new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION");
      ((Intent)localObject2).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject2).putExtra("param_notifyid", 263);
      ((NotificationCompat.Builder)localObject3).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0));
      localObject1 = ((NotificationCompat.Builder)localObject3).build();
      if (localQQNotificationManager == null) {
        break;
      }
      localQQNotificationManager.cancel("Q.msg.MessageHandler_IpadOnlineNotifition", 263);
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_OTHER");
      localQQNotificationManager.notify("Q.msg.MessageHandler_IpadOnlineNotifition", 263, (Notification)localObject1);
      this.jdField_a_of_type_JavaLangRunnable = new MessageHandler.10(this, localQQNotificationManager);
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
      return;
      ((NotificationCompat.Builder)localObject3).setLargeIcon(bgyo.a(((Context)localObject1).getResources(), 2130844183));
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.q < 3)
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
        this.q += 1;
        return;
      }
      paramFromServiceMsg = ((msg_svc.PbPullGroupMsgSeqReq)paramFromServiceMsg.group_unread_info.get()).group_info_req.get().iterator();
      while (paramFromServiceMsg.hasNext()) {
        c(String.valueOf(((msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq)paramFromServiceMsg.next()).group_code.get()), paramToServiceMsg.extraData.getInt("doSome"));
      }
    }
    r(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = (SvcResponseSetRoamMsg)paramObject;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.cReplyCode == 0)) {
        break label43;
      }
    }
    label43:
    for (boolean bool = false;; bool = true)
    {
      a(1005, bool, null);
      return;
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish");
    }
    if (this.jdField_a_of_type_Bcrg.a())
    {
      localObject2 = this.jdField_a_of_type_Bcrg.b();
      this.jdField_a_of_type_Bcrg.a();
      localStringBuilder = null;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo size = " + ((List)localObject2).size());
        }
        localStringBuilder = new StringBuilder();
        localObject1 = new HashMap(this.jdField_a_of_type_Bcrg.c());
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
            arrayOfObject = this.jdField_a_of_type_Bcrg.a(str);
            l2 = this.jdField_a_of_type_Bcrg.i(str);
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
              this.jdField_a_of_type_Bcrg.b(String.valueOf(localstConfNumInfo.lConfUin), new Object[] { Long.valueOf(localstConfNumInfo.uMemberMsgSeq), Long.valueOf(localstConfNumInfo.uConfMsgSeq) });
              if (localstConfNumInfo.uConfMsgSeq > l2) {
                break label415;
              }
              g(str);
              if (l1 < localstConfNumInfo.uMemberMsgSeq)
              {
                if (!jdField_f_of_type_Boolean) {
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
              this.app.getMessageFacade().setReadFrom(str, 3000, localstConfNumInfo.uMemberMsgSeq);
              continue;
              if (l1 < localstConfNumInfo.uMemberMsgSeq) {
                this.jdField_a_of_type_Bcrg.b(str, 1);
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
      if (this.jdField_a_of_type_Bcrg.c()) {
        notifyUI(4002, true, null);
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
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
        this.app.getMessageFacade().handleRefreshMessagelistHeadResult(paramFromServiceMsg, 1, null, null, paramToServiceMsg);
      }
      return;
    }
    try
    {
      d(paramFromServiceMsg, "handleGetPullTroopMsgError");
      if (bool2) {
        if (this.jdField_a_of_type_Bcrg.b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          notifyUI(4003, false, new String[] { paramFromServiceMsg });
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
      this.jdField_a_of_type_Bcrg.g();
      return;
    }
    notifyUI(4003, false, new String[] { paramFromServiceMsg });
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = (SvcResponseDelRoamMsg)paramObject;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.cReplyCode == 0)) {
        break label96;
      }
      bool = false;
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("handleDelRoamResp isSuccess = ").append(bool).append(" , cReplyCode = ");
        if (paramToServiceMsg != null) {
          break label102;
        }
      }
    }
    label96:
    label102:
    for (paramToServiceMsg = "null";; paramToServiceMsg = Byte.valueOf(paramToServiceMsg.cReplyCode))
    {
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg);
      a(1003, bool, null);
      return;
      bool = true;
      break;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
    this.app.getCurrentAccountUin();
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
    this.jdField_a_of_type_Bcrg.a(paramToServiceMsg);
    t();
    label165:
    notifyUI(4002, false, null);
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber ERROR isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramObject = (SvcResponsePullDisMsgSeq)paramObject;
    this.app.getCurrentAccountUin();
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber is null");
      }
      u(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i1 = paramObject.cReplyCode;
    Object localObject = paramObject.strResult;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetDiscussionMsgNum resp.cReplyCode: " + i1);
    }
    if (i1 != 0)
    {
      u(paramToServiceMsg, paramFromServiceMsg);
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
      this.jdField_a_of_type_Bcrg.a(paramObject);
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
          this.jdField_a_of_type_Bcrg.b(paramObject, 2);
          if (this.jdField_a_of_type_Bcrg.b(paramObject) != null) {
            this.jdField_a_of_type_Bcrg.d(paramObject);
          }
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_Bcrg.a(paramToServiceMsg);
    t();
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("lDisUin"));
    if (bool)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.putBoolean("success", false);
      }
      this.app.getMessageFacade().handleRefreshMessagelistHeadResult(String.valueOf(paramFromServiceMsg), 3000, null, null, paramToServiceMsg);
      return;
    }
    paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    try
    {
      e(String.valueOf(paramFromServiceMsg), "handleGetPullDiscussionMsgError");
      if (this.jdField_a_of_type_Bcrg.c())
      {
        notifyUI(4002, false, null);
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
      this.jdField_a_of_type_Bcrg.h();
    }
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
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
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
        v(paramToServiceMsg, ???);
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
        ???.append("handleGetPullDiscussionMsgResp_PB res.cReplyCode = ").append(localPbGetDiscussMsgResp2.result.get()).append(" discussUin: ").append(l1).append(" isRefreshHead: ").append(bool3).append(", dataHash=@").append(Integer.toHexString(paramObject.hashCode())).append(" rtnBeginSeq:").append(localPbGetDiscussMsgResp2.return_begin_seq.get()).append(" rtnEndSeq:").append(localPbGetDiscussMsgResp2.return_end_seq.get());
        if (localPbGetDiscussMsgResp2.msg.get() == null) {
          break label361;
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
        label361:
        ???.append(" msg:null.");
      }
      paramObject = this.jdField_a_of_type_Bcrg.a(localPbGetDiscussMsgResp2.discuss_uin.get());
      this.jdField_a_of_type_Bcrg.a(String.valueOf(l1), localPbGetDiscussMsgResp2.discuss_info_seq.get(), localPbGetDiscussMsgResp2.last_get_time.get());
      if (!bool3) {}
    }
    for (;;)
    {
      try
      {
        a("disc_processor").a(1003, new Object[] { paramToServiceMsg, paramObject, localPbGetDiscussMsgResp2, str });
        this.jdField_a_of_type_Bcrg.a(localPbGetDiscussMsgResp2.discuss_uin.get());
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
          this.jdField_k_of_type_Int += 1;
          this.jdField_a_of_type_Bcrg.b(String.valueOf(l1), 2);
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
          this.jdField_k_of_type_Int += 1;
          this.jdField_a_of_type_Bcrg.b(String.valueOf(l1), 2);
          continue;
          e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
          continue;
        }
        finally
        {
          if (!bool2) {
            continue;
          }
          this.jdField_k_of_type_Int += 1;
          this.jdField_a_of_type_Bcrg.b(String.valueOf(l1), 2);
          throw paramToServiceMsg;
          e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
          continue;
        }
        if ((!bool1) || (!this.jdField_a_of_type_Bcrg.c())) {
          break label724;
        }
        MsgAutoMonitorUtil.getInstance().markDisFinishTime();
        notifyUI(4002, true, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
        break;
        e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
      }
      label724:
      if ((bool2) && (this.jdField_d_of_type_Int != 0) && (this.jdField_k_of_type_Int >= this.jdField_d_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN , discussionNum:" + this.jdField_d_of_type_Int + " , recvDiscNum:" + this.jdField_k_of_type_Int);
        }
        MsgAutoMonitorUtil.getInstance().markDisFinishTime();
        notifyUI(4002, true, null);
      }
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyC2CMsgResp.");
    }
    if (jdField_f_of_type_Boolean)
    {
      a(1, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
    a(3013, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
      ((anza)localObject).jdField_c_of_type_Int = i1;
      ((anza)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
    }
    a(l1);
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      long l1 = System.currentTimeMillis();
      paramObject = (SvcResponsePullGroupMsgSeq)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgSeq.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      MsgAutoMonitorUtil.getInstance().addProxySeqTime_Grp(System.currentTimeMillis() - l1);
    }
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
    a(3021, false, new Long[] { Long.valueOf(i1), Long.valueOf(l1), Long.valueOf(paramFromServiceMsg.getResultCode()) });
    a(l1);
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
      }
      if (jdField_f_of_type_Boolean) {
        a(2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else
    {
      return;
    }
    A(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void z(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if ((paramObject != null) && ((paramObject instanceof RegisterPushNotice))) {
        break label40;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd ERROR");
      }
    }
    return;
    label40:
    paramFromServiceMsg = (RegisterPushNotice)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, new Object[] { "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd endseq=" + paramFromServiceMsg.uEndSeq + ",timeoutflag=" + paramFromServiceMsg.ulTimeOutFlag, ", uInterval_forbid_pulldown=", Long.valueOf(paramFromServiceMsg.uInterval_forbid_pulldown) });
    }
    long l1;
    if (paramFromServiceMsg.uEndSeq == this.jdField_b_of_type_Int)
    {
      l1 = 0L;
      this.jdField_a_of_type_AndroidUtilPair = new Pair(paramFromServiceMsg, Long.valueOf(0L));
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      d(paramFromServiceMsg.uInterval_forbid_pulldown);
    }
    for (;;)
    {
      if ((this.jdField_i_of_type_Int != 0) && (paramFromServiceMsg.uEndSeq == this.jdField_i_of_type_Int))
      {
        this.app.getMsgCache().c(false);
        this.jdField_i_of_type_Int = 0;
      }
      if (((!g()) || (!h())) && (jdField_f_of_type_Boolean)) {
        break;
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (this.jdField_a_of_type_AndroidUtilPair != null)
        {
          this.jdField_a_of_type_AndroidUtilPair = null;
          if ((l1 == 1L) || (!this.jdField_a_of_type_Bcrg.c()) || (!this.jdField_a_of_type_Bcrg.b()))
          {
            j();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyEndResp RegPrxySvc.NoticeEnd notify");
            }
            notifyUI(4013, true, new Long[] { Long.valueOf(paramFromServiceMsg.ulTimeOutFlag), Long.valueOf(l1) });
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        }
        return;
      }
      if (paramFromServiceMsg.uEndSeq != this.jdField_h_of_type_Int) {
        break;
      }
      this.jdField_a_of_type_AndroidUtilPair = new Pair(paramFromServiceMsg, Long.valueOf(1L));
      l1 = 1L;
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
      localSendMessageHandler.a(new MessageHandler.1(this, localPbSendMsgReq, i1, paramLong2));
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
    localSvcRequestGetMsgV2.lUin = Long.parseLong(this.app.getCurrentAccountUin());
    localSvcRequestGetMsgV2.uDateTime = this.jdField_a_of_type_Bcrg.b();
    localSvcRequestGetMsgV2.cRecivePic = 1;
    localSvcRequestGetMsgV2.shAbility = 15;
    byte[] arrayOfByte = this.jdField_a_of_type_Bcrg.a();
    localSvcRequestGetMsgV2.cChannel = 4;
    localSvcRequestGetMsgV2.cInst = 1;
    localSvcRequestGetMsgV2.cChannelEx = 1;
    localSvcRequestGetMsgV2.cSyncFlag = 0;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      localSvcRequestGetMsgV2.vSyncCookie = arrayOfByte;
    }
    localSvcRequestGetMsgV2.cRambleFlag = 0;
    localSvcRequestGetMsgV2.lGeneralAbi = 1L;
    arrayOfByte = this.jdField_a_of_type_Bcrg.b();
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
        notifyUI(4002, true, null);
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
        ((MessageSvcPack.PullDisSeqParam)localObject3).lLastSeqId = this.jdField_a_of_type_Bcrg.i((String)localObject2);
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
      localObject1 = ((antp)this.mApp.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
      if (((ArrayList)localObject1).size() == 0)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = null;
        notifyUI(4002, true, null);
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
        localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_Bcrg.i(((DiscussionInfo)localObject3).uin);
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
      arrayOfString = this.app.getNewTroopListUin(2);
      this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
    }
    while ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      notifyUI(4003, true, arrayOfString);
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
        localPullGroupSeqParam.lLastSeqId = this.jdField_a_of_type_Bcrg.j(arrayOfString[paramInt]);
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
      notifyUI(4002, true, null);
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
          localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_Bcrg.i(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
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
        notifyUI(4002, true, null);
        return null;
      }
      localSvcRequestPullDisGroupSeq.setVDisInfo((ArrayList)localObject);
      localObject = localSvcRequestPullDisGroupSeq;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisGroupSeq disUinArray: " + localStringBuilder.toString());
    return localSvcRequestPullDisGroupSeq;
  }
  
  public acme a(String paramString)
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
          localObject = new acmp(this.app, this);
          if (localObject != null) {
            break label416;
          }
          return null;
        }
      }
      if ("troop_processor".equals(paramString))
      {
        localObject = new bfkb(this.app, this);
      }
      else if ("disc_processor".equals(paramString))
      {
        localObject = new aonw(this.app, this);
      }
      else if ("businessbase_processor".equals(paramString))
      {
        localObject = new acnk(this.app, this);
      }
      else if ("sub_account_processor".equals(paramString))
      {
        localObject = new aoou(this.app, this);
      }
      else if ("accost_processor".equals(paramString))
      {
        localObject = new aonn(this.app, this);
      }
      else if ("offlinefile_processor".equals(paramString))
      {
        localObject = new aooi(this.app, this);
      }
      else if ("system_processor".equals(paramString))
      {
        localObject = new aooy(this.app, this);
      }
      else if ("uncommon_msg_processor".equals(paramString))
      {
        localObject = new aopk(this.app, this);
      }
      else if ("video_processor".equals(paramString))
      {
        localObject = new aopm(this.app, this);
      }
      else if ("discuss_update_processor".equals(paramString))
      {
        localObject = new aonw(this.app, this);
      }
      else if ("info_update_processor".equals(paramString))
      {
        localObject = new aoop(this.app, this);
      }
      else if ("slave_master_processor".equals(paramString))
      {
        localObject = new aonx(this.app, this);
      }
      else if ("hctopic_processor".equals(paramString))
      {
        localObject = new aoob(this.app, this);
        continue;
        label416:
        ((acme)localObject).a(this);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        label433:
        return (acme)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public aooi a()
  {
    return (aooi)a("offlinefile_processor");
  }
  
  public aoou a()
  {
    return (aoou)a("sub_account_processor");
  }
  
  public aooy a()
  {
    return (aooy)a("system_processor");
  }
  
  public aopk a()
  {
    return (aopk)a("uncommon_msg_processor");
  }
  
  public bcrg a()
  {
    return this.jdField_a_of_type_Bcrg;
  }
  
  public AppShareID a(String paramString)
  {
    return this.jdField_a_of_type_Bcrg.a(paramString);
  }
  
  public OpenID a(String paramString)
  {
    return this.jdField_a_of_type_Bcrg.a(paramString);
  }
  
  public EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public SendMessageHandler a(long paramLong)
  {
    return (SendMessageHandler)this.jdField_d_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public ToServiceMsg a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "sendNewRegisterProxy , isGetPassword = " + paramBoolean + " ,randomSeq" + paramInt);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("RegPrxySvc.infoSync");
    localToServiceMsg.extraData.putLong("requestOptional", 0x80 | 0L | 0x40 | 0x100 | 0x2 | 0x2000 | 0x4000 | 0x10000);
    localToServiceMsg.extraData.putInt("endSeq", paramInt);
    localToServiceMsg.extraData.putInt("type", 1);
    localToServiceMsg.extraData.putBoolean("isGetPassword", paramBoolean);
    if (paramLong != 0L)
    {
      localToServiceMsg.getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] currentRegisterProxyRandom = " + paramLong);
      }
    }
    return localToServiceMsg;
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
  
  public HashSet<String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    notifyUI(6006, true, null, true);
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
    if (((paramInt2 != 2) && (!b(paramBoolean3))) || ((paramInt2 == 2) && (!e())))
    {
      this.jdField_a_of_type_Bcrg.a(false);
      localObject = this.jdField_a_of_type_Bcrg.a();
      if (!paramBoolean1) {
        break label252;
      }
    }
    label252:
    for (byte b1 = 0;; b1 = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getC2CMessage cChannel: " + paramByte + "vCookies: " + paramArrayOfByte + ",cSyncFlag:" + paramInt1 + ",pullRoamMsg:" + paramBoolean1 + ",onlineSyncFlag:" + b1);
      }
      a(a(paramByte, paramArrayOfByte, paramInt1, paramBoolean1, paramBoolean2, paramString, paramInt2, paramObject, (byte[])localObject, b1));
      return;
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
      localObject = (String[])this.app.getTroopListUin(-2).get(Integer.valueOf(-2));
      a((String[])localObject);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
      localObject = a();
      if (localObject != null)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject[0]);
        if (paramInt == 1) {
          p();
        }
      }
    }
    else
    {
      localHashMap = this.app.getTroopListUin(-1);
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
        if ((localObject != null) && (localObject.length > 0) && (this.jdField_a_of_type_Bcrg != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "enableTroopMsgPushCache type=2, 1st uin=" + localObject[0]);
          }
          i1 = 0;
          while (i1 < localObject.length)
          {
            this.jdField_a_of_type_Bcrg.a(localObject[i1], 0);
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
  
  protected void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject)
  {
    l();
    paramToServiceMsg = new anys(paramInt, paramToServiceMsg, ???, paramObject);
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
  
  protected void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject, boolean paramBoolean)
  {
    l();
    paramToServiceMsg = new anys(paramInt, paramToServiceMsg, ???, paramObject, paramBoolean);
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
  
  public void a(int paramInt1, List<String> paramList, String paramString, long paramLong1, List<oidb_c2c_searcher.Iterator> paramList1, int paramInt2, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("PbMessageSvc.PbSearchRoamMsgInCloud");
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
    if (paramList1 == null)
    {
      if (paramList != null)
      {
        paramInt1 = 0;
        if (paramInt1 < paramList.size())
        {
          paramList1 = new oidb_c2c_searcher.Iterator();
          oidb_c2c_searcher.MsgKey localMsgKey = new oidb_c2c_searcher.MsgKey();
          if (paramLong2 != 0L) {
            localMsgKey.time.set(paramLong2);
          }
          for (;;)
          {
            paramList1.key.set(localMsgKey);
            paramList1.uin.set(Long.parseLong((String)paramList.get(paramInt1)));
            localArrayList.add(paramList1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud friendUin: " + (String)paramList.get(paramInt1) + " beginTime: " + paramList1.key.time.get() + ", searchkey: " + paramString + ",lastDatelineTime:" + paramLong2);
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
        QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud  beginTime: " + ((oidb_c2c_searcher.Iterator)paramList1.get(0)).key.time.get() + ", searchkey: " + paramString + ",retryIndex" + paramInt2);
      }
      localArrayList.addAll(paramList1);
    }
    if (localArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud listSize 0: it should not happen, check why");
      }
      return;
    }
    VipUtils.a(this.app, "chat_history", "ChatSearch", "Send_require", 0, 0, new String[0]);
    localReqBody.friends.set(localArrayList);
    localReqBody.set(localReqBody);
    localPbSearchRoamMsgInCloudReq.serialize_reqbody.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(localPbSearchRoamMsgInCloudReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 0L, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    n();
    int i1 = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "sendRegisterProxy , type = " + paramInt + " , needEndPkg = " + paramBoolean1 + " , registerProxyRandom = " + paramLong + " , isGetPassword = " + paramBoolean2);
    }
    long l2 = 0L | 0x80;
    long l1;
    if ((paramInt == 1) || (paramInt == 2))
    {
      l2 = l2 | 0x40 | 0x100 | 0x2 | 0x10000;
      l1 = l2;
      if (!paramBoolean1) {
        break label353;
      }
      this.jdField_b_of_type_Int = i1;
      l1 = l2;
      if (paramInt != 1) {
        break label356;
      }
    }
    label353:
    label356:
    for (Object localObject = "RegPrxySvc.infoLogin";; localObject = "RegPrxySvc.getOffMsg")
    {
      localObject = createToServiceMsg((String)localObject);
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
      send((ToServiceMsg)localObject);
      return;
      if ((paramInt == 3) && (paramBoolean1))
      {
        this.jdField_h_of_type_Int = i1;
        l1 = l2;
        break;
      }
      l1 = l2;
      if (paramInt == 4)
      {
        l2 |= 0x100;
        this.jdField_b_of_type_Int = i1;
        l1 = l2;
        if (this.app.getMsgCache().a(false))
        {
          this.jdField_i_of_type_Int = i1;
          l1 = l2;
        }
      }
      break;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(null, paramInt, paramBoolean, paramObject, 0, false, false, null);
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
    a(paramLong, paramInt1, paramInt2, null, 1, DeviceInfoUtil.getDeviceInfo());
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    a(paramLong, paramInt1, paramInt2, paramPbPushMsg, 1, DeviceInfoUtil.getDeviceInfo());
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg, int paramInt3, DeviceInfo paramDeviceInfo)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
    localToServiceMsg.extraData.putInt("svrip", paramInt1);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    localToServiceMsg.extraData.putLong("lUin", paramLong);
    if (paramInt3 != -1) {
      localToServiceMsg.extraData.putInt("service_type", paramInt3);
    }
    if (paramDeviceInfo != null) {
      localToServiceMsg.extraData.putSerializable("deviceInfo", paramDeviceInfo);
    }
    if ((paramPbPushMsg != null) && (paramPbPushMsg.bytes_push_token.has())) {
      localToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[])paramPbPushMsg.bytes_push_token.get().toByteArray().clone());
    }
    localToServiceMsg.setNeedCallback(false);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, ntf paramntf)
  {
    oidb_0xbad.ReqBody localReqBody = new oidb_0xbad.ReqBody();
    localReqBody.bytes_openid.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqBody.uint64_appid.set(paramLong2);
    localReqBody.uint64_uin.set(paramLong1);
    ntb.a(this.app, paramntf, localReqBody.toByteArray(), "OidbSvc.0xbad", 2989, 0);
  }
  
  public void a(long paramLong, ArrayList<DelMsgInfo> paramArrayList, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
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
      send(localToServiceMsg);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    n();
    int i1 = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    this.jdField_b_of_type_Int = i1;
    if (paramLong != 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    send(a(paramBoolean, i1, paramLong));
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt) {}
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong2));
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Friends)localObject1).name;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).trim().length() != 0) {
          break label62;
        }
      }
    }
    for (localObject1 = String.valueOf(paramLong2);; localObject1 = String.valueOf(paramLong2))
    {
      label62:
      long l1 = this.app.getOnlineStauts();
      localObject2 = new Intent("tencent.video.q2v.RecvSharpVideoCall");
      ((Intent)localObject2).setClassName(this.app.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
      ((Intent)localObject2).putExtra("uin", String.valueOf(paramLong1));
      ((Intent)localObject2).putExtra("fromUin", String.valueOf(paramLong2));
      ((Intent)localObject2).putExtra("buffer", paramArrayOfByte);
      ((Intent)localObject2).putExtra("time", paramInt);
      ((Intent)localObject2).putExtra("name", (String)localObject1);
      ((Intent)localObject2).putExtra("isPttRecordingOrPlaying", this.app.isPttRecordingOrPlaying());
      ((Intent)localObject2).putExtra("isRequest", paramBoolean);
      ((Intent)localObject2).putExtra("onLineStatus", l1);
      ((Intent)localObject2).putExtra("msf_timestamp", System.currentTimeMillis());
      QLog.d("shanezhaiSHARP", 1, "avideo handleSharpVideoMessageResp sendBroadcast!!");
      this.app.getApp().sendBroadcast((Intent)localObject2);
      return;
    }
  }
  
  public void a(SvrMsg paramSvrMsg)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.SvrMsg");
    localToServiceMsg.extraData.putSerializable("SvrMsg", paramSvrMsg);
    send(localToServiceMsg);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION".equals(paramContext)) || ("com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION".equals(paramContext)))
    {
      paramContext = QQNotificationManager.getInstance();
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 264);
      this.jdField_j_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaLangThread != null) {
        this.jdField_a_of_type_JavaLangThread.interrupt();
      }
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 263);
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
          bdla.b(this.app, "CliOper", "", "", "My_eq", "PC_Online_notice", 0, 0, "", "", "", "");
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
    this.app.getMessageFacade().addMessage(paramMessageRecord, this.app.getCurrentAccountUin());
    new ArrayList().add(paramMessageRecord);
    if (!paramMessageRecord.isread) {}
    for (boolean bool = true;; bool = false)
    {
      a("addMessageAndNotify", 1000, true, null, 1, a(bool), false, null);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "sendRevokeMsgReq, timeout: " + paramLong);
    }
    if (!this.app.getMsgCache().e())
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
      a(paramMessageRecord);
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
    boolean bool2 = a(paramMessageRecord.msgseq, localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = anyv.a(this.app, paramMessageRecord);
    MessageForStructing localMessageForStructing;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (localMessageForStructing.structingMsg == null) {}
    }
    for (boolean bool1 = uwe.b(localMessageForStructing.structingMsg);; bool1 = false)
    {
      if ((MessageForRichText.class.isInstance(paramMessageRecord)) && (!bool1)) {
        ((MessageForRichText)paramMessageRecord).richText = null;
      }
      if (localPbSendMsgReq == null) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->sendRichTextMessageWith_MR : the richText is null!", paramMessageRecord.getBaseInfoString() });
        }
      }
      int i1;
      do
      {
        do
        {
          return;
          a(paramMessageRecord, localPbSendMsgReq, 480000L, 0, paramBusinessObserver, paramBoolean);
          localSendMessageHandler.postDelayed(new MessageHandler.3(this, paramMessageRecord), jdField_e_of_type_Int);
          if (bool2)
          {
            i1 = 0;
            while (i1 < 8)
            {
              localSendMessageHandler.a(new MessageHandler.4(this, paramMessageRecord, localPbSendMsgReq, paramBusinessObserver, paramBoolean));
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
        this.jdField_a_of_type_Bcrg.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
        i1 = this.jdField_a_of_type_Bcrg.jdField_a_of_type_JavaUtilList.size();
        paramMessageRecord = this.jdField_a_of_type_Bcrg;
      } while (i1 <= bcrg.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bcrg.jdField_a_of_type_JavaUtilList.remove(0);
      return;
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
        paramMessageRecord2.extStr = paramMessageRecord1.extStr;
        paramMessageRecord2.mExJsonObject = paramMessageRecord1.mExJsonObject;
        paramMessageRecord2.extLong = paramMessageRecord1.extLong;
        if ((paramMessageRecord1 instanceof MessageForFunnyFace))
        {
          Object localObject = (MessageForFunnyFace)paramMessageRecord1;
          if ((((MessageForFunnyFace)localObject).mFunnyFaceMessage != null) && (((MessageForFunnyFace)localObject).mFunnyFaceMessage.faceId == 1)) {
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
                this.app.getMessageFacade().updateMsgContentByUniseq(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord1.uniseq, paramMessageRecord2.mFunnyFaceMessage.getBytes());
                return;
              }
            }
            catch (Exception paramMessageRecord1) {}
          }
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
    this.app.getMessageFacade().addMessage(paramMessageRecord, this.app.getCurrentAccountUin());
    new ArrayList().add(paramMessageRecord);
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
        a("addMessageAndNotify", 1000, true, null, 1, a(paramBoolean), false, paramMessageRecord);
        return;
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a("addMessageAndNotify", 1000, true, null, 1, a(paramBoolean), false, null);
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
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleError serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (aoon.a().containsKey(str)) {
      a(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      do
      {
        return;
        if (("MessageSvc.PbGetMsg".equalsIgnoreCase(str)) || ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str)))
        {
          if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str)) {
            jdField_a_of_type_Boolean = true;
          }
          c(paramToServiceMsg);
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
        if ("MessageSvc.PbSendMsg".equalsIgnoreCase(str))
        {
          m(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0xa89".equalsIgnoreCase(str))
        {
          x(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
        {
          h(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
        {
          w(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ((!"MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) && (!"PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str))) {
          break;
        }
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
      if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<---handleError - get thirdqq unread number");
        }
        a().b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      r(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("RegPrxySvc.infoLogin".equalsIgnoreCase(str)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str)))
      {
        g(paramFromServiceMsg, null);
        return;
      }
      if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        H(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(str))
      {
        y(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"StreamSvr.UploadStreamMsg".equals(str));
    short s1 = paramToServiceMsg.extraData.getShort("PackSeq");
    notifyUI(3011, false, new Object[] { new bcrr(paramToServiceMsg.extraData.getString("filepath"), s1, paramToServiceMsg.extraData.getShort("flowLayer"), null, 0) });
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (("AccostSvc.ReqGetBlackList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramToServiceMsg = (RespGetBlackList)paramObject;
      if (paramToServiceMsg.stHeader.eReplyCode == 0)
      {
        int i2 = paramToServiceMsg.vBlackListUin.size();
        if (i2 > 0)
        {
          paramFromServiceMsg = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
          break label149;
        }
      }
    }
    return;
    label149:
    b(paramToServiceMsg.lNextMid);
  }
  
  public void a(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    c(localArrayList);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqInsertBlackList");
    localToServiceMsg.extraData.putString("insertUin", paramString);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------addFriendTipsMr friendUin: " + paramString + ", sourceId=" + paramInt);
    }
    if ((paramInt == 2007) || (paramInt == 3007) || (paramInt == 4007) || (paramInt == 2017) || (paramInt == 3017)) {
      this.app.getAVNotifyCenter().a(Long.valueOf(paramString).longValue(), true, paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        paramString = (anyo)this.jdField_e_of_type_JavaUtilHashMap.get(paramString);
        if (paramString != null) {
          a(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_c_of_type_JavaLangString, paramString.jdField_a_of_type_Long, paramString.jdField_a_of_type_JavaLangString, paramString.jdField_b_of_type_Long, paramString.jdField_a_of_type_Int, paramString.jdField_b_of_type_Int, paramString.jdField_c_of_type_Long);
        }
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    a(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.app.getMessageFacade().updateGroupMsgSeqAndTimeByUniseq(paramString, paramInt, paramLong1, paramLong2, paramLong3);
    if (this.app.getMsgCache().a(paramInt, paramString, paramLong1))
    {
      paramString = this.app.getMsgCache().a(paramInt, paramString, paramLong1);
      paramString.shmsgseq = paramLong2;
      paramString.time = paramLong3;
      paramString.extraflag = 0;
      a().a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (this.app.getMsgCache().a(paramInt, paramString1, paramLong1))
    {
      paramString1 = this.app.getMsgCache().a(paramInt, paramString1, paramLong1);
      paramString1.time = paramLong2;
      paramString1.extraflag = 0;
      a().a(paramString1);
      return;
    }
    this.app.getMessageFacade().updateC2CMsgTimeByUniseq(paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    if (acnh.a(paramInt) == 1032) {}
    do
    {
      do
      {
        return;
      } while (!acnh.b(paramString, paramInt));
      paramString = this.app.getMessageFacade().setBoxMsgReaded(paramString, paramInt, paramBoolean);
    } while ((paramString == null) || (paramString.toByteArray() == null));
    paramInt = bcpt.jdField_a_of_type_Int;
    bcpt.jdField_a_of_type_Int = paramInt + 1;
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
      localSendMessageHandler.a(new MessageHandler.18(this, paramString, l2, l1));
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
    a(paramString, paramLong1, paramLong2, paramLong3, paramShort, paramLong4, paramInt1, paramArrayOfByte, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
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
        QLog.d("Q.msg.MessageHandler", 2, i1 + ", fetchMore: " + paramBoolean1 + ", fetchNum: " + paramInt3 + ", isPreloadType: " + paramBoolean2 + ", notify: " + paramBoolean3);
        QLog.e("Q.msg.MessageHandler", 2, new Exception("getRoamMsgByTime"), new Object[0]);
      }
    }
    else
    {
      if ((paramLong4 == 0L) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      localObject = createToServiceMsg("MessageSvc.PbGetRoamMsg");
      ((ToServiceMsg)localObject).extraData.putLong("lBeginTime", paramLong1);
      ((ToServiceMsg)localObject).extraData.putLong("lEndTime", paramLong3);
      ((ToServiceMsg)localObject).extraData.putBoolean("fetchMore", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putInt("fetchNum", paramInt3);
      ((ToServiceMsg)localObject).extraData.putString("peerUin", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("preloadType", paramBoolean2);
      ((ToServiceMsg)localObject).extraData.putBoolean("notify", paramBoolean3);
      localPbGetRoamMsgReq = new msg_svc.PbGetRoamMsgReq();
      if ((paramLong4 != 0L) || (paramLong2 != 0L)) {
        break label494;
      }
      localPbGetRoamMsgReq.last_msgtime.set(paramLong3);
      label369:
      localPbGetRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetRoamMsgReq.random.set(paramLong4);
      paramString = localPbGetRoamMsgReq.read_cnt;
      if (paramShort == 0) {
        break label507;
      }
      label402:
      paramString.set(paramShort);
      localPbGetRoamMsgReq.subcmd.set(paramInt1);
      localPbGetRoamMsgReq.begin_msgtime.set(paramLong1);
      localPbGetRoamMsgReq.check_pwd.set(1);
      localPbGetRoamMsgReq.req_type.set(paramInt2);
      if (paramArrayOfByte != null)
      {
        if (paramInt2 != 0) {
          break label515;
        }
        localPbGetRoamMsgReq.pwd.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).putWupBuffer(localPbGetRoamMsgReq.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
      i1 = paramArrayOfByte.length;
      break;
      label494:
      localPbGetRoamMsgReq.last_msgtime.set(paramLong2);
      break label369;
      label507:
      paramShort = 1000;
      break label402;
      label515:
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
      localObject = this.jdField_a_of_type_Bcrg.b(paramString);
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
        paramLong2 = bcrg.a();
      }
      localObject = createToServiceMsg("MessageSvc.PbGetOneDayRoamMsg");
      msg_svc.PbGetOneDayRoamMsgReq localPbGetOneDayRoamMsgReq = new msg_svc.PbGetOneDayRoamMsgReq();
      localPbGetOneDayRoamMsgReq.last_msgtime.set(paramLong2);
      localPbGetOneDayRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetOneDayRoamMsgReq.random.set(l1);
      localPbGetOneDayRoamMsgReq.read_cnt.set(paramShort);
      ((ToServiceMsg)localObject).putWupBuffer(localPbGetOneDayRoamMsgReq.toByteArray());
      if (paramBundle != null) {
        ((ToServiceMsg)localObject).extraData.putBundle("context", paramBundle);
      }
      sendPbReq((ToServiceMsg)localObject);
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
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localanvk.a(localanvk.a(paramString1, paramString2));
    }
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong1, long paramLong2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    for (long l1 = 0L; l1 < 3L; l1 += 1L) {
      localSendMessageHandler.postDelayed(new MessageHandler.12(this, l1, paramString1, paramString2, paramByte, paramString3, paramLong1, paramLong2), 30000L * l1);
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
      if (paramLong2 == this.jdField_d_of_type_Long) {
        return;
      }
    }
    Object localObject1;
    int i1;
    Object localObject4;
    Object localObject3;
    if (((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1))
    {
      localObject1 = this.app.getMessageFacade().getMsgList(paramString1, 0);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramString3 = new avhz(paramString1, this.app.getCurrentUin(), this.app.getApp().getString(2131690032), 0, -5040, 655362, paramLong2);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString3);
        avia.a(this.app, (MessageForUniteGrayTip)localObject1);
        break label1066;
        if (i1 == 0) {
          break label1088;
        }
        localObject1 = anvx.a(2131706104);
        localObject4 = anvx.a(2131706099);
        localObject3 = anvx.a(2131706102);
        paramString3 = new avhz(paramString1, this.app.getCurrentUin(), (String)localObject1, 0, -5040, 135179, paramLong2);
        paramString3.jdField_c_of_type_JavaLangString = ((String)localObject1);
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 14);
        localBundle.putString("key_action_DATA", "from_batch_add_frd_for_troop");
        i1 = ((String)localObject1).indexOf((String)localObject4);
        int i2 = ((String)localObject1).indexOf((String)localObject4);
        paramString3.a(i1, ((String)localObject4).length() + i2, localBundle);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("key_action", 13);
        ((Bundle)localObject4).putString("key_action_DATA", "from_batch_add_frd_for_troop");
        paramString3.a(((String)localObject1).indexOf((String)localObject3), ((String)localObject1).indexOf((String)localObject3) + ((String)localObject3).length(), (Bundle)localObject4);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString3);
        avia.a(this.app, (MessageForUniteGrayTip)localObject1);
        break label1088;
      }
    }
    for (;;)
    {
      label455:
      boolean bool = bpup.a(paramInt1);
      if (i1 != 0)
      {
        paramString3 = (MessageForGrayTips)bcsa.a(-1013);
        paramString3.init(this.app.getCurrentAccountUin(), paramString1, paramString1, this.app.getApp().getString(2131690031), paramLong2, -1013, 3, paramLong2);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 14);
        paramString3.addHightlightItem(18, 22, (Bundle)localObject1);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 13);
        paramString3.addHightlightItem(23, 27, (Bundle)localObject1);
        paramString3.isread = true;
        a(paramString3);
        bdla.b(this.app, "dc00898", "", "", "0X8007978", "0X8007978", 0, 0, "", "", "", "");
      }
      if ((bool) && (!TextUtils.isEmpty(paramString2)))
      {
        bool = ((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).a(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "addGreetingMsg | deleted = " + bool);
        }
        if (bool) {
          notifyUI(8030, true, paramString2);
        }
      }
      bbdk.a(this.app, paramString1, paramLong2, paramInt1, paramInt2);
      if (this.jdField_e_of_type_JavaUtilHashMap.get(paramString1) != null) {
        this.jdField_e_of_type_JavaUtilHashMap.remove(paramString1);
      }
      this.jdField_d_of_type_Long = paramLong2;
      label739:
      return;
      ((aizi)this.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(paramString1);
      localObject3 = (MessageForText)bcsa.a(-1000);
      ((MessageForText)localObject3).frienduin = paramString1;
      localObject1 = this.app.getApp().getString(2131690033);
      if (paramLong3 == this.app.getLongAccountUin())
      {
        paramString3 = anvx.a(2131706094);
        label813:
        localObject4 = this.app.getCurrentAccountUin();
        if (!TextUtils.isEmpty(paramString3)) {
          break label1110;
        }
      }
      for (;;)
      {
        ((MessageForText)localObject3).init((String)localObject4, paramString1, paramString1, (String)localObject1, paramLong2, -1000, 0, paramLong2);
        ((MessageForText)localObject3).isread = true;
        if (paramLong1 != -1L) {
          ((MessageForText)localObject3).vipBubbleID = paramLong1;
        }
        a((MessageRecord)localObject3);
        if ((!TextUtils.isEmpty(paramString3)) && (paramLong3 != this.app.getLongAccountUin()))
        {
          localObject1 = ContactUtils.getFriendDisplayName(this.app, paramString1);
          paramString3 = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString3 = paramString1;
          }
          localObject1 = (MessageForGrayTips)bcsa.a(-1013);
          ((MessageForGrayTips)localObject1).init(this.app.getCurrentAccountUin(), paramString1, paramString1, String.format(anvx.a(2131706103), new Object[] { paramString3 }), paramLong2, -1013, 0, paramLong2);
          ((MessageForGrayTips)localObject1).isread = true;
          a((MessageRecord)localObject1);
          break label1066;
          localObject1 = new anyo();
          ((anyo)localObject1).jdField_b_of_type_JavaLangString = paramString1;
          ((anyo)localObject1).jdField_a_of_type_JavaLangString = paramString3;
          ((anyo)localObject1).jdField_a_of_type_Long = paramLong1;
          ((anyo)localObject1).jdField_b_of_type_Long = paramLong2;
          ((anyo)localObject1).jdField_a_of_type_Int = paramInt1;
          ((anyo)localObject1).jdField_b_of_type_Int = paramInt2;
          ((anyo)localObject1).jdField_c_of_type_JavaLangString = paramString2;
          ((anyo)localObject1).jdField_c_of_type_Long = paramLong3;
          this.jdField_e_of_type_JavaUtilHashMap.put(paramString1, localObject1);
          break label739;
          break label813;
        }
        label1066:
        if ((paramInt1 != 2093) && (paramInt1 != 3093)) {
          break label1117;
        }
        i1 = 1;
        break;
        label1088:
        if ((paramInt1 != 3078) && (paramInt1 != 3079)) {
          break label1123;
        }
        i1 = 1;
        break label455;
        label1110:
        localObject1 = paramString3;
      }
      label1117:
      i1 = 0;
      break;
      label1123:
      i1 = 0;
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
    localToServiceMsg.extraData.putShort("flowLayer", bdnl.a(paramString3));
    localToServiceMsg.extraData.putInt("msgseq", paramInt);
    localToServiceMsg.extraData.putLong("random", paramLong1);
    localToServiceMsg.extraData.putLong("VoiceType", paramLong2);
    localToServiceMsg.extraData.putLong("VoiceLength", paramLong3);
    localToServiceMsg.extraData.putLong("SubBubbleId", paramLong4);
    localToServiceMsg.extraData.putInt("DiyTextId", paramBundle.getInt("DiyTextId", 0));
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.setNeedRemindSlowNetwork(true);
    send(localToServiceMsg);
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
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString1 + "." + paramString2, 1000, paramBoolean1, null, paramInt, paramBoolean2, paramBoolean3, null);
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
        bcqj.a(this.app, this.app.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void a(ArrayList<anyn> paramArrayList, ArrayList<aonp> paramArrayList1)
  {
    int i2 = 0;
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.DelMsgV2");
    long[] arrayOfLong;
    Object localObject;
    short[] arrayOfShort;
    int i1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      arrayOfLong = new long[paramArrayList.size()];
      localObject = new int[paramArrayList.size()];
      arrayOfShort = new short[paramArrayList.size()];
      i1 = 0;
      while (i1 < paramArrayList.size())
      {
        arrayOfLong[i1] = ((anyn)paramArrayList.get(i1)).jdField_a_of_type_Long;
        localObject[i1] = ((anyn)paramArrayList.get(i1)).jdField_a_of_type_Int;
        arrayOfShort[i1] = ((anyn)paramArrayList.get(i1)).jdField_a_of_type_Short;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i1 + " fromUin:" + arrayOfLong[i1] + " msgTime: " + localObject[i1] + " msgSeq:" + arrayOfShort[i1]);
        }
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("fromUin", arrayOfLong);
      localToServiceMsg.extraData.putIntArray("msgTime", (int[])localObject);
      localToServiceMsg.extraData.putShortArray("msgSeq", arrayOfShort);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList = new long[paramArrayList1.size()];
      arrayOfLong = new long[paramArrayList1.size()];
      localObject = new long[paramArrayList1.size()];
      arrayOfShort = new short[paramArrayList1.size()];
      i1 = i2;
      while (i1 < paramArrayList1.size())
      {
        paramArrayList[i1] = ((aonp)paramArrayList1.get(i1)).jdField_a_of_type_Long;
        arrayOfLong[i1] = ((aonp)paramArrayList1.get(i1)).jdField_b_of_type_Long;
        localObject[i1] = ((aonp)paramArrayList1.get(i1)).jdField_c_of_type_Long;
        arrayOfShort[i1] = ((aonp)paramArrayList1.get(i1)).jdField_a_of_type_Short;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i1 + " fromUin:" + paramArrayList[i1] + " msgId: " + localObject[i1] + " msgType:" + arrayOfShort[i1]);
        }
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("accostFromUin", paramArrayList);
      localToServiceMsg.extraData.putLongArray("accostToUin", arrayOfLong);
      localToServiceMsg.extraData.putLongArray("accostMsgId", (long[])localObject);
      localToServiceMsg.extraData.putShortArray("accostMsgType", arrayOfShort);
    }
    send(localToServiceMsg);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        c((MessageRecord)paramArrayList.next());
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (paramList != null)
    {
      anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      int i1 = 0;
      while (i1 < paramList.size())
      {
        String str = String.valueOf(paramList.get(i1));
        if (!TextUtils.isEmpty(str))
        {
          boolean bool = localanvk.a(str);
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
  
  public void a(short paramShort, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.SetRoamMsgAllUser");
    localToServiceMsg.extraData.putShort("shType", paramShort);
    localToServiceMsg.extraData.putByte("cValue", paramByte);
    send(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "Msg Pull Finish picPreDownloadOn");
    }
    this.app.getPicPreDownloader().b();
    this.app.getShortVideoPredownloer().b();
    this.app.getScribbleDownloader().c();
    awth.a().a(3);
    notifyUI(6005, paramBoolean, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getC2CMessage:isPullRoamMsg:" + paramBoolean + " ,pullMsgType:" + paramInt);
    }
    a((byte)3, null, 0, paramBoolean, true, false, null, paramInt, null);
  }
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean3, long paramLong3, ntf paramntf)
  {
    oidb_0xd55.ReqBody localReqBody = new oidb_0xd55.ReqBody();
    localReqBody.check_app_sign_req.setHasFlag(true);
    localReqBody.check_app_sign_req.client_info.setHasFlag(true);
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.check_app_sign_req.client_info.android_package_name.set(paramString2);
    }
    localReqBody.check_app_sign_req.client_info.platform.set(1);
    paramString2 = auui.a(BaseApplicationImpl.getContext(), paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.check_app_sign_req.client_info.android_signature.set(paramString2);
    }
    localReqBody.check_app_sign_req.client_info.sdk_version.set("0.0.0");
    localReqBody.check_user_req.setHasFlag(true);
    localReqBody.check_user_req.openid.set(paramString1);
    paramString1 = localReqBody.check_user_req.need_check_same_user;
    int i1;
    if (paramBoolean1)
    {
      i1 = 1;
      paramString1.set(i1);
      if (paramBoolean2)
      {
        localReqBody.check_mini_app_req.setHasFlag(true);
        localReqBody.check_mini_app_req.mini_app_appid.set(paramLong1);
        localReqBody.check_mini_app_req.need_check_bind.set(1);
      }
      localReqBody.appid.set(paramLong2);
      localReqBody.app_type.set(paramInt1);
      localReqBody.src_id.set(paramInt2);
      paramString1 = localReqBody.is_need_appinfo;
      if (!paramBoolean3) {
        break label282;
      }
    }
    label282:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.set(paramInt1);
      ntb.a(this.app, paramntf, localReqBody.toByteArray(), "OidbSvc.0xd55", 3413, 0, null, paramLong3);
      return;
      i1 = 0;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.app.getProxyManager().a().getRecentList(true);
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
      if (localRecentUser.getType() == 1)
      {
        i2 = this.app.getTroopMask(localRecentUser.uin);
        if (((i2 == 1) || (i2 == 4)) && (this.app.getMessageFacade().hasCurFrinedMsg(localRecentUser.uin, 1))) {}
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
          if ((localException1.getType() == 3000) && (this.app.getMessageFacade().hasCurFrinedMsg(localException1.uin, 3000)))
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
    long l1 = this.jdField_a_of_type_Bcrg.a(String.valueOf(paramLong1), 3000);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getPullDiscussionMsg uin: " + paramLong1 + " beginSeq: " + paramLong2 + " endSeq: " + paramLong3 + " delSeq: " + l1);
    }
    if ((paramLong2 < 0L) || (paramLong3 < 0L)) {
      return false;
    }
    Pair localPair = this.jdField_a_of_type_Bcrg.a(String.valueOf(paramLong1));
    if (localPair == null) {
      return false;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbGetDiscussMsg");
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
    a(localToServiceMsg);
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
  
  public boolean a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    long l1 = this.jdField_a_of_type_Bcrg.a(paramString, 1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "--->>getPullTroopMsg troopUin2: " + paramString + " beginSeq: " + paramLong1 + " endSeq: " + paramLong2 + " delSeq: " + l1 + " pull num : " + (paramLong2 - paramLong1 + 1L) + " doSome:" + paramInt + " ThreadId:" + Thread.currentThread().getId());
    }
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      return false;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbGetGroupMsg");
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
      localObject = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramBundle.public_group.set(((HotChatManager)localObject).a(paramString));
      localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
      a(localToServiceMsg);
      return true;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if ((!paramBoolean2) && (a(paramBoolean1))) {}
    for (paramBoolean1 = true; (paramBoolean1) && (paramList != null) && (paramList.size() > 0) && ((acnh.a(this.app, (MessageRecord)paramList.get(0))) || (acnh.b(this.app, (MessageRecord)paramList.get(0))) || (aqwc.a(this.app, (MessageRecord)paramList.get(0)))); paramBoolean1 = false)
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
    byte[] arrayOfByte = this.jdField_a_of_type_Bcrg.a();
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
    Object localObject = new msg_svc.PbGetMsgReq();
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      arrayOfByte = this.jdField_a_of_type_Bcrg.b();
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
      PkgTools.copyData(arrayOfByte, 4, (byte[])localObject, 0, localObject.length);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>createGetMsgReq ,isPubAccount:" + paramBoolean);
      }
      return arrayOfByte;
      arrayOfByte = this.jdField_a_of_type_Bcrg.a();
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
      localSendMessageHandler.a(new MessageHandler.2(this, localPbSendMsgReq, i1, paramLong2));
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------resetGetMsgFlag ");
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
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
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, null, -1, null);
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
        paramFromServiceMsg = anyv.a(paramToServiceMsg, paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---TimeConsume---> cmd[" + paramToServiceMsg.getServiceCmd() + "] seq[" + l1 + "] retryIndex[" + i1 + "] " + paramFromServiceMsg[0] + "");
        }
        localSendMessageHandler.a(i1, l2, l3, paramFromServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "can not found handler");
  }
  
  public void b(String paramString)
  {
    b(paramString, 0);
  }
  
  public void b(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqDeleteBlackList");
    localToServiceMsg.extraData.putString("deleteUin", paramString);
    localToServiceMsg.extraData.putInt("fromType", paramInt);
    send(localToServiceMsg);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1, paramString2);
    }
  }
  
  public void b(ArrayList<MessageRecord> paramArrayList)
  {
    a(paramArrayList, true);
  }
  
  public void b(List<String> paramList)
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
          localGroupInfoReq.last_seq.set(this.jdField_a_of_type_Bcrg.j((String)paramList.get(i1)));
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
    paramList = createToServiceMsg("PbMessageSvc.PbUnReadMsgSeq");
    paramList.putWupBuffer(localPbUnReadMsgSeqReq.toByteArray());
    paramList.extraData.putBoolean("RequestFromPublicAccountChatPie", true);
    sendPbReq(paramList);
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
        bhdf.a().a(this.jdField_b_of_type_JavaUtilArrayList, this.app);
        this.jdField_b_of_type_JavaUtilArrayList = null;
        bool = true;
      }
      return bool;
    }
  }
  
  public void c()
  {
    if (a().hasMessages(2)) {
      a().removeMessages(2);
    }
    a().a();
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
    localObject = makeOIDBPkg("OidbSvc.0xb31", 2865, 0, ((oidb_0xb31.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("toUin", paramLong);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getCommonHobbyForAIOShow.");
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
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
        break label347;
      }
      paramFromServiceMsg = "0";
    }
    label337:
    label347:
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
            break label337;
          }
        }
      }
      for (l1 = 0L;; l1 = l2 - l1)
      {
        int i3 = paramToServiceMsg.extraData.getInt("msgtype");
        int i4 = bcrx.a(i1, this.app);
        localHashMap.put("pm_msg_type", String.valueOf(i3));
        localHashMap.put("pm_uin_type", String.valueOf(i4));
        paramToServiceMsg = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramToServiceMsg.getCurrentAccountUin(), "sendMsgTooLargeErrorTag", false, l1, i2, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, duration:%dms, peerUin:%s, replyCode:%d, routingType:%s, msgReqSize:%d", new Object[] { "sendMsgTooLargeErrorTag", Long.valueOf(l1), paramFromServiceMsg, Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(i2) }));
        }
        return;
      }
    }
  }
  
  public void c(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.DelRoamMsg");
    localToServiceMsg.extraData.putString("uin", paramString);
    send(localToServiceMsg);
  }
  
  public void c(String paramString, int paramInt)
  {
    int i1 = 0;
    Object localObject = new String[1];
    localObject[0] = paramString;
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.jdField_a_of_type_Bcrg.j(paramString);
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
    localObject = createToServiceMsg("PbMessageSvc.PbUnReadMsgSeq");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("doSome", paramInt);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
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
    return ((g()) && (h())) || (!jdField_f_of_type_Boolean);
  }
  
  public void d()
  {
    this.jdField_g_of_type_Int = 0;
    this.q = 0;
  }
  
  public void d(String paramString)
  {
    if (a(paramString) != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "get openid key = " + paramString);
    }
    AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    localHashMap.put("OpenAppid", paramString);
    localAccountManager.changeToken(localHashMap, new anyj(this, paramString));
  }
  
  public void d(boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new MessageHandler.16(this, paramBoolean), 10, null, false);
      return;
    }
    aqvh.b(this.app, false);
    aqvh.a(this.app, false);
    e(paramBoolean);
  }
  
  public boolean d()
  {
    long l1 = SystemClock.uptimeMillis() - this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "canRefreshMessage() elapsed=[" + (float)l1 * 1.0F / 1000.0F + "]s,mIntervalForbidPulldown=[" + this.jdField_c_of_type_Long + "]s");
    }
    return l1 >= this.jdField_c_of_type_Long * 1000L;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Bcrg.a(false);
    b(false);
    b(false);
    c(false);
    e();
  }
  
  public void e(boolean paramBoolean)
  {
    int i3 = 0;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = this.app.getMessageFacade().setAllReaded(paramBoolean);
    if ((localPbMsgReadedReportReq == null) || (localPbMsgReadedReportReq.toByteArray() == null)) {
      return;
    }
    int i1 = bcpt.jdField_a_of_type_Int;
    bcpt.jdField_a_of_type_Int = i1 + 1;
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
      localSendMessageHandler.a(new MessageHandler.17(this, localPbMsgReadedReportReq, l2, l1));
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
  
  public void f()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handlePullLackGroupMsg-> New RegisterProxy End!");
      }
      g();
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
        this.jdField_e_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        h();
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
  
  public void g()
  {
    Object localObject1 = this.jdField_a_of_type_Bcrg;
    if (bcrg.jdField_a_of_type_Bcrl != null)
    {
      long l1 = System.currentTimeMillis();
      localObject1 = (akqe)this.app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      Object localObject2 = this.jdField_a_of_type_Bcrg;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (bcrg.jdField_a_of_type_Bcrl.jdField_a_of_type_JavaUtilList != null)
      {
        localObject2 = this.jdField_a_of_type_Bcrg;
        if (bcrg.jdField_a_of_type_Bcrl.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localObject2 = new HashMap();
          localObject3 = this.jdField_a_of_type_Bcrg;
          localObject3 = bcrg.jdField_a_of_type_Bcrl.jdField_a_of_type_JavaUtilList.iterator();
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
          ((akqe)localObject1).a((HashMap)localObject2);
        }
      }
      localObject2 = this.jdField_a_of_type_Bcrg;
      if (bcrg.jdField_a_of_type_Bcrl.b != null)
      {
        localObject2 = this.jdField_a_of_type_Bcrg;
        if (bcrg.jdField_a_of_type_Bcrl.b.size() > 0)
        {
          localObject3 = ((antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
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
          localObject3 = (antl)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          HashMap localHashMap = new HashMap();
          Object localObject6 = this.jdField_a_of_type_Bcrg;
          localObject6 = bcrg.jdField_a_of_type_Bcrl.b.iterator();
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
            ((antl)localObject3).f(this.app.getLongAccountUin());
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
              ((antl)localObject3).a((String)localObject6);
              if (this.jdField_a_of_type_Bcrg.b((String)localObject6) != null) {
                this.jdField_a_of_type_Bcrg.d((String)localObject6);
              }
            }
          }
          notifyUI(1000, ((antl)localObject3).a((ArrayList)localObject4, (ArrayList)localObject5), null);
          ((akqe)localObject1).b(localHashMap);
        }
      }
      localObject1 = this.jdField_a_of_type_Bcrg;
      bcrg.jdField_a_of_type_Bcrl.jdField_a_of_type_JavaUtilList = null;
      localObject1 = this.jdField_a_of_type_Bcrg;
      bcrg.jdField_a_of_type_Bcrl.b = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleRegPrxyCache end! cost:" + (System.currentTimeMillis() - l1));
      }
    }
  }
  
  public void h()
  {
    Object localObject = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).setLength(0);
      ((StringBuilder)localObject).append("checkGroupMsgComplete-> troopNum:").append(this.jdField_c_of_type_Int).append(" ,discussionNum:").append(this.jdField_d_of_type_Int).append(" ,recvTroopNum:").append(this.jdField_j_of_type_Int).append(" ,recvDiscNum").append(this.jdField_k_of_type_Int);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.app.getMsgCache().a(false)) && (this.jdField_c_of_type_Int == 0) && (this.jdField_d_of_type_Int == 0)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    int i2;
    int i1;
    if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.size() > 0))
    {
      anym localanym = new anym(this, (StringBuilder)localObject, 0).a();
      i2 = localanym.a();
      i1 = localanym.b();
    }
    for (;;)
    {
      int i4;
      int i3;
      if ((this.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_c_of_type_JavaUtilHashMap.size() > 0))
      {
        localObject = new anyl(this, (StringBuilder)localObject, 0).a();
        i4 = ((anyl)localObject).a();
        i3 = ((anyl)localObject).b();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) || (this.jdField_b_of_type_ArrayOfJavaLangString != null)) {
          a(i2, i4, i1, i3);
        }
        this.jdField_c_of_type_Int = 0;
        this.jdField_d_of_type_Int = 0;
        this.jdField_j_of_type_Int = 0;
        this.jdField_k_of_type_Int = 0;
        return;
        i3 = 0;
        i4 = 0;
      }
      i1 = 0;
      i2 = 0;
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGroupMsgAfterSyncMsg");
    }
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Bcrg.b();
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
            this.jdField_a_of_type_Bcrg.b((String)localObject1);
            if ((arrayOfObject != null) && (arrayOfObject.length >= 2)) {
              a("troop_processor").a(1001, new Object[] { arrayOfObject, null, Boolean.valueOf(false) });
            }
          }
        }
        localObject1 = this.jdField_a_of_type_Bcrg.a((String)localObject1);
        if (localObject1 != null) {
          ((bfkb)a("troop_processor")).a((GroupMsgReadedNotify)localObject1);
        }
      }
    }
    localConcurrentHashMap = this.jdField_a_of_type_Bcrg.d();
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
          this.jdField_a_of_type_Bcrg.d((String)localObject1);
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfObject = (Object[])((Iterator)localObject2).next();
            if ((arrayOfObject != null) && (arrayOfObject.length >= 3)) {
              a("disc_processor").a(1001, new Object[] { arrayOfObject[0], arrayOfObject[1], arrayOfObject[2], Boolean.valueOf(false) });
            }
          }
        }
        localObject1 = this.jdField_a_of_type_Bcrg.a((String)localObject1);
        if (localObject1 != null) {
          ((aonw)a("disc_processor")).a((DisMsgReadedNotify)localObject1);
        }
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg begin.");
    }
    ConcurrentHashMap localConcurrentHashMap1 = this.jdField_a_of_type_Bcrg.a();
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
        localConcurrentHashMap2 = this.jdField_a_of_type_Bcrg.c();
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
      this.jdField_a_of_type_Bcrg.b();
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
  
  public void k()
  {
    send(createToServiceMsg("RegPrxySvc.getExtinfo"));
  }
  
  public void l()
  {
    if (!jdField_f_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread != null) {
          break label193;
        }
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(20);
        this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(10);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread = new MessageHandler.MessageHandleThread[6];
        break label193;
        if (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length)
        {
          if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1] != null) && (!this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1].a())) {
            break label198;
          }
          if (i1 == 0)
          {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1] = new MessageHandler.MessageHandleThread(this, this.jdField_d_of_type_JavaUtilArrayList);
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1].setName("MessageHandleThread" + (i1 + 1));
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1].setPriority(5);
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1].start();
            break label198;
          }
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1] = new MessageHandler.MessageHandleThread(this, this.jdField_c_of_type_JavaUtilArrayList);
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
  
  public void m()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread != null)
      {
        int i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i1].a();
          i1 += 1;
        }
      }
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.notifyAll();
        this.jdField_d_of_type_JavaUtilArrayList = null;
        this.jdField_c_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread = null;
        return;
      }
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
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
      this.allowCmdSet.add("VideoSvc.Send");
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
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] cleanRegisterProxyRandom");
    }
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void o()
  {
    if (this.app.getMsgCache().d()) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = this.app.getMsgCache().e();
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      bool = a(bool, localArrayList, localIterator);
    }
    if (!localArrayList.isEmpty()) {
      d(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "msgSending:last, msgSendingTemp:" + localConcurrentHashMap);
    }
    localConcurrentHashMap.clear();
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return anyz.class;
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_l_of_type_Boolean = true;
    d();
    b();
    this.jdField_a_of_type_Bcrg.d();
    bhcl.a();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    m();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
    ((aonw)a("disc_processor")).a();
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
      localStringBuilder.append("onReceive success ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" serviceCmd: ").append(str).append(", resultCode:").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (a(paramToServiceMsg, paramFromServiceMsg, str)) {}
    long l2;
    do
    {
      return;
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, str);
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "handle [cmd]=" + str + " , costTime = [" + (l2 - l1) + "]");
  }
  
  public void p()
  {
    int i1 = 0;
    SharedPreferences localSharedPreferences;
    Object localObject1;
    if (this.app.getCurrentAccountUin() != null)
    {
      localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      localObject1 = localSharedPreferences.getString("msgSending", null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:init,read msgSending file," + (String)localObject1 + " msgCache:" + this.app.getMsgCache().hashCode());
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
          this.app.getMsgCache().d(str, i2, l1);
          localObject2 = this.app.getMessageFacade().queryMsgItemByUniseq(str, i2, l1);
          if (localObject2 == null) {
            break label349;
          }
          this.app.getMsgCache().d((MessageRecord)localObject2);
          this.app.getMessageFacade().setChangeAndNotify(localObject2);
          if ((((MessageRecord)localObject2).msgtype != -1035) || (!(localObject2 instanceof MessageForMixedMsg))) {
            break label349;
          }
          this.app.getMessageFacade().updateMsgExtraFlagByUniseq(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, 32768, ((MessageRecord)localObject2).sendFailCode);
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
  
  public void q()
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
        bgiy localbgiy;
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
    localbgiy = (bgiy)this.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    i2 = localList.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        register_proxy.GroupList localGroupList = (register_proxy.GroupList)localList.get(i1);
        String str = String.valueOf(localGroupList.group_code.get());
        long l2 = localGroupList.group_seq.get();
        if (!str.equals(localbgiy.a())) {
          acnh.a(this.app, str, l2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler
 * JD-Core Version:    0.7.0.1
 */