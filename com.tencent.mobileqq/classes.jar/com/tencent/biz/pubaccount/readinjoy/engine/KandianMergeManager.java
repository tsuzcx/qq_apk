package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.atlas.ReadInJoyAtlasConfig;
import com.tencent.biz.pubaccount.readinjoy.channelCover.RIJMainChannelUtil;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerUtil;
import com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusPreloadManager;
import com.tencent.biz.pubaccount.readinjoy.common.RIJUserInfoUtil;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyResetUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyStringUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinListener;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinListenerUtils;
import com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMiniProgrameReporter;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJLockScreenPushReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJMergeKanDianMessage;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.Utils;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJUGCAccountPopupStep;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSHelper;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushComponentExtData;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushComponentExtDataProcessor;
import com.tencent.biz.pubaccount.readinjoy.struct.AwesomeCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.ScreenshotEventReportListener;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.tkd.TKDCommentFragmentHelper;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyTabObserver;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.content.ReadInJoyDataProviderObserver;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BiuBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;

public class KandianMergeManager
  implements Manager
{
  public static String b;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new KandianMergeManager.8(this);
  AladdinListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener = new KandianMergeManager.9(this);
  KandianMergeManager.KandianReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianReporter = new KandianMergeManager.KandianReporter();
  private KandianMergeManager.KandianSetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo;
  private volatile Kandian210Msg0xeeInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  private KandianOx210MsgInfo.Biu0x210Msg jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg;
  private KandianOx210MsgInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private KandianRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
  private ReadInJoyGlobalReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter = new ReadInJoyGlobalReporter();
  private ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new KandianMergeManager.36(this);
  private MiniAppNotify.IMiniAppNotifyListener jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener = new KandianMergeManager.7(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new KandianMergeManager.15(this);
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = null;
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<KandianMergeManager.InsertArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new KandianMergeManager.10(this);
  private KandianOx210MsgInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private KandianRedDotInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private List<IRIJNormalRedDotInterceptor> jdField_b_of_type_JavaUtilList;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private KandianOx210MsgInfo jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private KandianRedDotInfo jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
  private String jdField_c_of_type_JavaLangString;
  private List<KandianMergeManager.OnTabRedNumsChangeListenner> jdField_c_of_type_JavaUtilList;
  private AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String jdField_d_of_type_JavaLangString;
  private List<KandianMergeManager.OnMainVideoTabRedChangeListener> jdField_d_of_type_JavaUtilList;
  private AtomicInteger jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String jdField_e_of_type_JavaLangString;
  private List<KandianMergeManager.MessageObserver> jdField_e_of_type_JavaUtilList;
  private AtomicInteger jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String f;
  private String g = "";
  private String h = "";
  
  static
  {
    jdField_b_of_type_JavaLangString = "PUSH_0X210_ORANGE_KEY";
  }
  
  public KandianMergeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    QLog.i("KandianMergeManager", 1, "[KandianMergeManager] constructed.");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    u();
    w();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    ReadInJoyResetUtils.a();
    QQAladdinUtils.a();
    z();
    Utils.a();
    ReadinjoySPEventReport.g();
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 0)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break label412;
      }
      s();
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "do method[someInitInSubThread] in manager init ");
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      ThreadManager.executeOnSubThread(new KandianMergeManager.2(this));
      ReadInJoyDataProviderObserver.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianReporter);
      AladdinListenerUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
      KBPDUtils.a();
      SneakyCallback.a();
      AwesomeCommentInfo.a();
      ReadInJoyAtlasConfig.a();
      paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      t();
      RIJUGCAccountPopupStep.i();
      G();
      a(new RIJXTabNormalRedDotInterceptor(paramQQAppInterface, this));
      return;
      label412:
      ThreadManager.executeOnSubThread(new KandianMergeManager.1(this));
    }
  }
  
  private void A()
  {
    ThreadManager.post(new KandianMergeManager.13(this), 8, null, false);
  }
  
  private void B()
  {
    boolean bool2 = false;
    Object localObject1 = null;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString;
      long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g == 0)
      {
        bool1 = true;
        localObject1 = a((String)localObject1, (String)localObject2, l, bool1, true, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Long));
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Long);
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
        a((MessageRecord)localObject1, true);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int != 1) {
        break label322;
      }
    }
    label322:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(bool1).append(", showLockScreen : ");
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.f == 1) {
        bool1 = true;
      }
      QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g + ", msgSeq : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("BID_TYPE", 2);
      a((MessageRecord)localObject1, KandianOx210MsgInfo.l, (Bundle)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void C()
  {
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.OnTabRedNumsChangeListenner)localIterator.next()).ai_();
      }
    }
  }
  
  private void D()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = new ScreenshotContentObserver(BaseApplicationImpl.getContext(), 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a(new ScreenshotContentObserver.ScreenshotEventReportListener());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.e("KandianMergeManager", 1, localSecurityException, new Object[0]);
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a();
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
    }
  }
  
  private void F()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
    for (long l = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue();; l = 0L)
    {
      a(l);
      return;
    }
  }
  
  private void G()
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localReadInJoyLogicManager != null) {
      localReadInJoyLogicManager.a().m();
    }
  }
  
  public static int a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
      } while (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN)));
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) {
        return 0;
      }
    } while ((paramMessageRecord.istroop != 1008) || (!ServiceAccountFolderManager.d(paramQQAppInterface, paramMessageRecord.frienduin)));
    return 1;
  }
  
  private long a(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    long l = 0L;
    paramKandian210Msg0xeeInfo = paramKandian210Msg0xeeInfo.notifyInfos.iterator();
    while (paramKandian210Msg0xeeInfo.hasNext()) {
      l = ((Kandian210Msg0xeeInfo.NotifyInfo)paramKandian210Msg0xeeInfo.next()).contextId;
    }
    return l;
  }
  
  private long a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      if (paramMessageRecord.structingMsg != null) {
        break label34;
      }
      QLog.d("KandianMergeManager", 1, "getArticleIDFromMessageRecord : struct msg body is null");
    }
    for (;;)
    {
      return 0L;
      label34:
      if ((paramMessageRecord.time >= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)))
      {
        paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
        if (paramMessageRecord.length > 0) {
          try
          {
            if (!TextUtils.isEmpty(paramMessageRecord[0]))
            {
              long l = new BigInteger(paramMessageRecord[0]).longValue();
              return l;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            QLog.e("KandianMergeManager", 1, "getArticleIDFromMessageRecord has num format error : " + paramMessageRecord);
          }
        }
      }
    }
    return 0L;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = paramMessageRecord;
    if (paramAppInfo.buffer.has())
    {
      localObject1 = paramAppInfo.buffer.get();
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | buffer jsonStr " + (String)localObject1);
      paramAppInfo = paramMessageRecord;
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          paramAppInfo = paramMessageRecord;
          Object localObject2 = ((JSONObject)localObject1).optString("_show_mission");
          paramAppInfo = paramMessageRecord;
          localObject1 = new JSONObject(new JSONObject(((JSONObject)localObject1).optString("param")).optString((String)localObject2)).optString("_red_ext_kd_push_msg_xml");
          paramAppInfo = paramMessageRecord;
          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | kandian redpoint xmlContent " + (String)localObject1);
          paramAppInfo = paramMessageRecord;
          localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8"))).getElementsByTagName("msg").item(0);
          localObject1 = paramMessageRecord;
          if (localObject2 == null) {
            break;
          }
          paramAppInfo = paramMessageRecord;
          localObject2 = ((Node)localObject2).getAttributes();
          localObject1 = paramMessageRecord;
          if (localObject2 == null) {
            break;
          }
          paramAppInfo = paramMessageRecord;
          if (((NamedNodeMap)localObject2).getNamedItem("articleIds") != null)
          {
            paramAppInfo = paramMessageRecord;
            if (!TextUtils.isEmpty(this.h))
            {
              paramAppInfo = paramMessageRecord;
              if (this.h.equalsIgnoreCase(((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue()))
              {
                paramAppInfo = paramMessageRecord;
                QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | duplicate redPntInfo | mLastRedTouchInfoArticleId " + this.h + " ; duplicateArticleId: " + ((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue());
                return paramMessageRecord;
              }
            }
          }
          paramAppInfo = paramMessageRecord;
          paramMessageRecord = a((NamedNodeMap)localObject2);
          paramAppInfo = paramMessageRecord;
          localObject2 = new StringBuilder().append("handlerRedPntCenterNotify | parseRedPntInfoAndSave ");
          if (paramMessageRecord != null)
          {
            localObject1 = "succeed";
            paramAppInfo = paramMessageRecord;
            QLog.d("KandianMergeManager", 1, (String)localObject1);
            localObject1 = paramMessageRecord;
            if (paramMessageRecord == null) {
              break;
            }
            paramAppInfo = paramMessageRecord;
            localObject1 = paramMessageRecord;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break;
            }
            paramAppInfo = paramMessageRecord;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
            return paramMessageRecord;
          }
        }
        catch (Exception paramMessageRecord)
        {
          QLog.e("KandianMergeManager", 1, "handlerRedPntCenterNotify JSONException " + paramMessageRecord);
          return paramAppInfo;
        }
        localObject1 = "failed";
      }
    }
    return localObject1;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {}
    while ((!paramBoolean) && ((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.msg, paramString1))) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, long paramLong, String paramString2)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.senderuin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.istroop = 7225;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msg_id", paramString2);
      localMessageRecord.extStr = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.i("KandianMergeManager", 2, "createLockScreenInteractMessage, msg=" + paramString1 + ", msg_id=" + paramString2);
      }
      return localMessageRecord;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("KandianMergeManager", 1, "put msgId error, e=" + localJSONException.toString());
      }
    }
  }
  
  private MessageRecord a(String paramString1, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 6;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      localMessageRecord.isread = false;
      localMessageRecord.issend = 0;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = paramLong1;
      try
      {
        if (TextUtils.isEmpty(localMessageRecord.extStr))
        {
          paramString1 = new JSONObject();
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("strategy_id", paramLong2);
          paramString1.put("algorithm_id", paramLong3);
          paramString1.put("article_id", paramLong4);
          paramString1.put("folder_status", paramLong5);
        }
        for (localMessageRecord.extStr = paramString1.toString();; localMessageRecord.extStr = paramString1.toString())
        {
          localMessageRecord.vipBubbleID = -999L;
          RIJKanDianFolderStatus.a(localMessageRecord);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          return localMessageRecord;
          localMessageRecord.extLong |= 0x2;
          break;
          paramString1 = new JSONObject(localMessageRecord.extStr);
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("strategy_id", paramLong2);
          paramString1.put("algorithm_id", paramLong3);
          paramString1.put("article_id", paramLong4);
          paramString1.put("folder_status", paramLong5);
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          localMessageRecord.extStr = null;
        }
      }
    }
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    boolean bool = ReadInJoyHelper.r();
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 5;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localMessageRecord.extInt = 2;
        bool = ReadInJoyHelper.c(paramString3);
      }
      localMessageRecord.issend = 0;
      localMessageRecord.isread = false;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = paramLong;
      try
      {
        this.jdField_c_of_type_JavaLangString = paramString3;
        if (TextUtils.isEmpty(localMessageRecord.extStr))
        {
          paramString1 = new JSONObject();
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("kdUin", this.jdField_c_of_type_JavaLangString);
          paramString1.put("kdShouldShowMergedAvatar", bool);
        }
        for (localMessageRecord.extStr = paramString1.toString();; localMessageRecord.extStr = paramString1.toString())
        {
          if (!f()) {
            break label362;
          }
          localMessageRecord.vipBubbleID = -1000L;
          if ((localMessageRecord.vipBubbleID == -1000L) && (!paramBoolean1)) {
            localMessageRecord.extStr = null;
          }
          if (KandianAppInPush.a().a(2000002)) {
            break label387;
          }
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
          RIJKanDianFolderStatus.a(localMessageRecord);
          paramString1.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          return localMessageRecord;
          localMessageRecord.extLong |= 0x2;
          break;
          paramString1 = new JSONObject(localMessageRecord.extStr);
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("kdUin", this.jdField_c_of_type_JavaLangString);
          paramString1.put("kdShouldShowMergedAvatar", bool);
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          localMessageRecord.extStr = null;
        }
        label362:
        if (paramBoolean1) {}
        for (paramLong = -999L;; paramLong = -1000L)
        {
          localMessageRecord.vipBubbleID = paramLong;
          break;
        }
        label387:
        QLog.w("KandianMergeManager", 2, "app in push is showing, abandon 210 push update msg table!");
      }
    }
    return localMessageRecord;
  }
  
  private void a(long paramLong)
  {
    try
    {
      String str = new RIJTransMergeKanDianReport.ReportR5Builder().c(paramLong).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A8A", "0X8009A8A", 0, 0, "", "", "", str, false);
      QLog.d("KandianMergeManager", 2, new Object[] { "reportAbandonPushRedPoint action = 0X8009A8A, r5 = ", str });
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("KandianMergeManager", 1, "reportAbandonPushRedPoint exception.");
    }
  }
  
  private void a(KandianOx210MsgInfo paramKandianOx210MsgInfo, long paramLong)
  {
    boolean bool = false;
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
    if (localKandianOx210MsgInfo != null)
    {
      if (localKandianOx210MsgInfo != null) {
        QLog.d("KandianMergeManager", 1, "0x210Msg reached, oldSeq = " + localKandianOx210MsgInfo.jdField_b_of_type_Long + ", newSeq = " + paramKandianOx210MsgInfo.jdField_b_of_type_Long);
      }
      if (localKandianOx210MsgInfo.jdField_b_of_type_Long >= paramKandianOx210MsgInfo.jdField_b_of_type_Long)
      {
        if (localKandianOx210MsgInfo.jdField_b_of_type_Long != paramKandianOx210MsgInfo.jdField_b_of_type_Long) {
          bool = true;
        }
        if (bool) {
          localKandianOx210MsgInfo.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0x210msg delay reach , has a latest msg , no cover! needAddCount : " + bool);
        }
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
        paramKandianOx210MsgInfo.jdField_a_of_type_Int += this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramKandianOx210MsgInfo;
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long = paramLong;
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i = 0;
      while (i < paramKandianOx210MsgInfo.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a((MySelfNormalItemRedPointInfo)paramKandianOx210MsgInfo.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_e_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.MessageObserver)localIterator.next()).a(paramMessageRecord, paramInt, paramBundle);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramMessageRecord.senderuin = AppConstants.KANDIAN_MERGE_UIN;
    paramMessageRecord.istroop = 7220;
    paramMessageRecord.msg = paramString1;
    for (;;)
    {
      try
      {
        paramMessageRecord.time = Long.parseLong(paramString2);
        paramMessageRecord.createMessageUniseq();
        if (paramInt == 0)
        {
          paramMessageRecord.extInt = 3;
          paramMessageRecord.extLong = 0;
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      if (paramInt == 1) {
        paramMessageRecord.extInt = 4;
      } else if (paramInt == 5) {
        paramMessageRecord.extInt = paramInt;
      } else {
        paramMessageRecord.extInt = 0;
      }
    }
  }
  
  private void a(RedTouchManager paramRedTouchManager, int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo, AladdinConfig paramAladdinConfig)
  {
    int i = 0;
    if (paramAladdinConfig.getIntegerFromString("use_new_route", 0) == 0) {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | use old route, skip parse num push info");
    }
    label24:
    do
    {
      do
      {
        do
        {
          break label24;
          do
          {
            return;
          } while ((paramAppInfo.red_display_info.get() == null) || (((BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get()).red_type_info.get() == null));
          paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
        } while (paramAppInfo == null);
        paramAppInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.tab_display_info.get();
      } while (paramAppInfo == null);
      paramAppInfo = paramAppInfo.red_content.get();
      paramAladdinConfig = paramRedTouchManager.a(paramInt);
    } while ((paramAladdinConfig == null) || (paramAladdinConfig.isEmpty()));
    paramAladdinConfig = new ArrayList(paramAladdinConfig);
    int j = paramAladdinConfig.size();
    long[] arrayOfLong = new long[j];
    if (i < j)
    {
      BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)paramAladdinConfig.get(i);
      if (localNumRedPath == null) {}
      for (;;)
      {
        i += 1;
        break;
        arrayOfLong[i] = localNumRedPath.uint64_msgid.get();
      }
    }
    paramRedTouchManager.a(arrayOfLong, "kandian_num_red_pnt_buffer", new KandianMergeManager.16(this));
    QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | numRedPoint num: " + paramAppInfo + ", extraNum : " + paramRedTouchManager.a(paramInt) + ", lastMsgID : " + arrayOfLong[(arrayOfLong.length - 1)]);
  }
  
  private boolean a(String paramString)
  {
    boolean bool;
    if (RIJXTabConfigHandler.b().a()) {
      bool = RIJXTabFrameUtils.a.a();
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, new Object[] { "isNeedToBlockPushRedPoint, ret = ", Boolean.valueOf(bool), ", tag = ", paramString });
      return bool;
      if ((RIJXTabFrameUtils.a.a()) && (!ReadInJoyChannelViewPagerController.b())) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong, OnLinePushMessageProcessor paramOnLinePushMessageProcessor)
  {
    paramArrayOfByte = KandianOx210MsgInfo.a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 follow msg fail!");
      }
    }
    label321:
    label450:
    do
    {
      do
      {
        return;
        paramOnLinePushMessageProcessor = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
        if ((paramOnLinePushMessageProcessor == null) || (paramOnLinePushMessageProcessor.jdField_b_of_type_Long <= paramArrayOfByte.jdField_b_of_type_Long)) {
          break label558;
        }
        if (paramArrayOfByte.jdField_e_of_type_Int != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach showFolder, has a latest msg , no cover! + oldMsg.msgSeq" + paramOnLinePushMessageProcessor.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long + "brief : " + paramArrayOfByte.jdField_b_of_type_JavaLangString);
        }
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo == null) || (paramArrayOfByte.jdField_b_of_type_Long > this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long))
        {
          if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) && (QLog.isColorLevel())) {
            QLog.d("KandianMergeManager", 2, "upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
          }
          paramOnLinePushMessageProcessor = paramArrayOfByte.jdField_b_of_type_JavaLangString;
          String str = paramArrayOfByte.jdField_a_of_type_JavaLangString;
          paramLong = paramArrayOfByte.jdField_d_of_type_Long;
          if (paramArrayOfByte.g == 0)
          {
            bool = true;
            paramOnLinePushMessageProcessor = a(paramOnLinePushMessageProcessor, str, paramLong, bool, true, String.valueOf(paramArrayOfByte.jdField_e_of_type_Long));
            a(paramOnLinePushMessageProcessor, true);
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramArrayOfByte;
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int != 1) {
                break label444;
              }
              bool = true;
              paramArrayOfByte = paramArrayOfByte.append(bool).append(", showLockScreen : ");
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.f != 1) {
                break label450;
              }
            }
          }
          for (boolean bool = true;; bool = false)
          {
            QLog.d("KandianMergeManager", 1, bool + ", redType : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g + ", msgSeq : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int);
            a(paramOnLinePushMessageProcessor, KandianOx210MsgInfo.l, null);
            return;
            bool = false;
            break;
            bool = false;
            break label321;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("KandianMergeManager", 2, "no upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
      return;
    } while (!QLog.isColorLevel());
    label444:
    QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach discarded,  + oldMsg.msgSeq" + paramOnLinePushMessageProcessor.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
    return;
    label558:
    if (QLog.isColorLevel()) {
      QLog.d("KandianMergeManager", 2, "0x210msgc5 nomel , msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    B();
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, OnLinePushMessageProcessor paramOnLinePushMessageProcessor)
  {
    int i = KandianOx210MsgInfo.a(paramArrayOfByte);
    if (i == KandianOx210MsgInfo.j) {}
    KandianOx210MsgInfo localKandianOx210MsgInfo;
    do
    {
      do
      {
        return;
        if (i == KandianOx210MsgInfo.l)
        {
          a(paramArrayOfByte);
          return;
        }
        localKandianOx210MsgInfo = KandianOx210MsgInfo.a(paramArrayOfByte);
        if (localKandianOx210MsgInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("KandianMergeManager", 2, "process 0x210 msg fail!");
      return;
      i = KandianOx210MsgInfo.b(paramArrayOfByte);
    } while (i == KandianOx210MsgInfo.m);
    boolean bool2;
    boolean bool3;
    boolean bool1;
    if ((i == KandianOx210MsgInfo.n) || (i == KandianOx210MsgInfo.o))
    {
      ReadInJoyLogicEngine.a().b(0, "");
      bool2 = RIJAppSetting.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bool3 = RIJPushNotification.a();
      if (((!bool2) && (!bool3)) || (localKandianOx210MsgInfo.f != 1) || (!((Boolean)ReadInJoyHelper.a("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue())) {
        break label372;
      }
      bool1 = true;
      label150:
      if (bool1)
      {
        paramArrayOfByte = a(localKandianOx210MsgInfo.jdField_b_of_type_JavaLangString, localKandianOx210MsgInfo.jdField_d_of_type_Long, localKandianOx210MsgInfo.h);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false, false, true, false);
        paramOnLinePushMessageProcessor.a("handleGetKandian210Message", true, 1, true, false);
        if ((RIJAladdinUtils.c() != 1) && (RIJMsgBoxUtils.b() == 2)) {
          break label378;
        }
      }
    }
    label372:
    label378:
    for (i = 3;; i = 1)
    {
      paramArrayOfByte = new RIJTransMergeKanDianReport.ReportR5Builder().a("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a("load_mode", Integer.valueOf(i)).a("push_type", Integer.valueOf(9));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X80081DC", paramArrayOfByte.a());
      QLog.i("KandianMergeManager", 1, "isAppBackground=" + bool2 + ",needNotificationForeground" + bool3 + ",showLockScreen=" + localKandianOx210MsgInfo.f + ",needShow=" + bool1);
      return;
      if (i != KandianOx210MsgInfo.p) {
        break;
      }
      a(localKandianOx210MsgInfo, paramLong);
      break;
      bool1 = false;
      break label150;
    }
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if (ReadInJoyUtils.a(paramMessageRecord)) {
      ThreadManager.post(new KandianMergeManager.19(this), 8, null, false);
    }
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    MessageRecord localMessageRecord = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localMessageRecord = localQQMessageFacade.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    }
    String str1;
    Object localObject;
    if ((localMessageRecord != null) && (a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (localMessageRecord.extInt == 2) && (!localMessageRecord.isread)) {
      if (QLog.isColorLevel())
      {
        str1 = "lastMr_info 【" + "msg: " + ReadInJoyUtils.a(localMessageRecord.msg) + ", msguid : " + localMessageRecord.msgUid;
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label356;
        }
        localObject = (MessageForStructing)localMessageRecord;
        ((MessageForStructing)localObject).parse();
        if (((MessageForStructing)localObject).structingMsg == null) {
          break label356;
        }
        str1 = str1 + ", title : " + ReadInJoyUtils.a(((MessageForStructing)localObject).structingMsg.mMsgBrief) + " 】";
      }
    }
    label356:
    for (;;)
    {
      String str2 = "newMr_info 【" + "msg: " + ReadInJoyUtils.a(paramMessageRecord.msg) + ", senderUin : " + paramMessageRecord.senderuin + " , msguid : " + paramMessageRecord.msgUid;
      localObject = str2;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        paramMessageRecord.parse();
        localObject = str2;
        if (paramMessageRecord.structingMsg != null) {
          localObject = str2 + ", title : " + ReadInJoyUtils.a(paramMessageRecord.structingMsg.mMsgBrief) + " 】";
        }
      }
      QLog.i("KandianMergeManager", 2, "subscribe push msg cover ! \n" + str1 + "\n" + (String)localObject);
      localQQMessageFacade.a(localMessageRecord, false);
      return;
    }
  }
  
  private void f(MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      try
      {
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break label239;
        }
        Object localObject = (MessageForStructing)paramMessageRecord;
        ((MessageForStructing)localObject).parse();
        if (((MessageForStructing)localObject).structingMsg == null) {
          break label239;
        }
        localObject = new JSONObject(((MessageForStructing)localObject).structingMsg.mMsgActionData);
        if (!((JSONObject)localObject).has("showMergedAvatar")) {
          break label234;
        }
        if (((JSONObject)localObject).getInt("showMergedAvatar") != 1) {
          break label240;
        }
        bool = true;
        if (((JSONObject)localObject).has("uin")) {
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
        }
        if (!((JSONObject)localObject).has("biuUin")) {
          break label231;
        }
        this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("biuUin");
        bool = ReadInJoyHelper.q();
        if (((JSONObject)localObject).has("defaultAvatarUrl"))
        {
          localObject = ((JSONObject)localObject).getString("defaultAvatarUrl");
          if (TextUtils.isEmpty(paramMessageRecord.extStr))
          {
            localJSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
              localJSONObject.put("kdUin", this.jdField_c_of_type_JavaLangString);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localJSONObject.put("kdDefaultSourceAvatarUrl", localObject);
            }
            localJSONObject.put("kdShouldShowMergedAvatar", bool);
            paramMessageRecord.extStr = localJSONObject.toString();
            return;
          }
          JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
          continue;
        }
        localObject = null;
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      continue;
      label231:
      continue;
      label234:
      boolean bool = false;
      continue;
      label239:
      return;
      label240:
      bool = false;
    }
  }
  
  private void s()
  {
    Object localObject = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ((ReadInJoyLogicManager)localObject).a().b(0, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).a().b(56, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).a().b(70, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).a().b(DailyModeConfigHandler.b(), 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).a().c(0);
    ((ReadInJoyLogicManager)localObject).a().r();
    ((ReadInJoyLogicManager)localObject).a().b();
    D();
    localObject = ProteusPreloadManager.a.a();
    ProteusPreloadManager.a.a((List)localObject);
    QLog.d("KandianMergeManager", 1, "preload pts card, rules : " + localObject);
  }
  
  private void t()
  {
    ThreadManager.getFileThreadHandler().post(new KandianMergeManager.4(this));
  }
  
  private void u()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.5(this));
  }
  
  private void v()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.6(this));
  }
  
  private void w()
  {
    RIJMiniProgrameReporter.a.b();
  }
  
  private void x()
  {
    RIJMiniProgrameReporter.a.c();
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void z()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.h = localSharedPreferences.getString("kandian_red_touch_pnt_article_id", "");
    QLog.d("KandianMergeManager", 1, "initCache mLastRedTouchInfoArticleId : " + this.h);
    Object localObject = localSharedPreferences.getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = StructMsgFactory.a(PkgTools.hexToBytes((String)localObject));
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mArticleIds))
      {
        String[] arrayOfString = ((AbsStructMsg)localObject).mArticleIds.split("\\|");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < arrayOfString.length)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(arrayOfString[i]));
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mMsgActionData)) {
        this.jdField_a_of_type_JavaLangString = ((AbsStructMsg)localObject).mMsgActionData;
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mAlgorithmIds)) {
        this.jdField_a_of_type_Long = Long.parseLong(localObject.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mStrategyIds)) {
        this.jdField_b_of_type_Long = Long.parseLong(localObject.mStrategyIds.split("\\|")[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      l = localSharedPreferences.getLong("kandian_push_msg_time", 0L);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l;
        localException.printStackTrace();
      }
    }
    this.jdField_e_of_type_JavaLangString = "";
    this.f = "";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
    l = localSharedPreferences.getLong("subscribe_push_msg_time", 0L);
    if (l > 0L)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      this.jdField_d_of_type_JavaLangString = localSharedPreferences.getString("subscribe_push_msg_uin", "");
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localSharedPreferences.getInt("subscribe_push_msg_status", -1));
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localSharedPreferences.getInt("subscribe_push_msg_msgtype", -1));
      if ((this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg = KandianOx210MsgInfo.Biu0x210Msg.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = KandianOx210MsgInfo.b();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = KandianOx210MsgInfo.c();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = KandianOx210MsgInfo.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = KandianMsgBoxRedPntInfo.getRedPntInfoFromSp();
    QLog.d("KandianMergeManager", 1, "init msgbox info from sp. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.getKandian210Msg0xeeInfoFromSp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.d("KandianAppInPush", 2, "init app push info from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = ((KandianMergeManager.KandianSetTopInfo)RIJSPUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_msgtab_settop", true));
    QLog.d("KandianMergeManager.SETTOP", 2, "get from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    A();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_video_tab_reddot_info", true);
    QLog.d("KandianMergeManager", 1, "init mianVideoTabRed : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_red_pnt_lock_screen", true);
    QLog.d("KandianMergeManager", 2, "lock screen push info : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    ThreadManager.executeOnSubThread(new KandianMergeManager.11(this));
    RIJXTabNormalRedDotStore.a.b();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  @VisibleForTesting
  int a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.c;
    }
    return 0L;
  }
  
  public Pair<Object, String> a()
  {
    if ((!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2))) {
      return null;
    }
    c(2);
    QLog.d("KandianMergeManager", 1, "mSubscribePushMsgTitle : " + RIJAppSetting.a(this.jdField_e_of_type_JavaLangString) + " mSubscribePushMsgArticleID : " + this.jdField_a_of_type_JavaLangLong + " mInnerUniqId : " + this.f + " seedUIN :  " + this.jdField_d_of_type_JavaLangString + ", isInterestedAccount : " + ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    if ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || ((TextUtils.isEmpty(this.f)) && (this.jdField_a_of_type_JavaLangLong.longValue() == -1L))) {
      return null;
    }
    if ((ReadInJoyHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(this.f))) {
      return new Pair(this.f, this.jdField_e_of_type_JavaLangString);
    }
    return new Pair(this.jdField_a_of_type_JavaLangLong, this.jdField_e_of_type_JavaLangString);
  }
  
  public SparseIntArray a()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.append(0, b(0));
    localSparseIntArray.append(1, b(1));
    localSparseIntArray.append(2, b(2));
    localSparseIntArray.append(3, b(3));
    return localSparseIntArray;
  }
  
  public IRIJNormalRedDotInterceptor a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      QLog.d("KandianMergeManager", 2, "getRedDotInterceptor --> interceptors is null!");
      return new RIJNormalRedDotInterceptorWrapper(null);
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      IRIJNormalRedDotInterceptor localIRIJNormalRedDotInterceptor = (IRIJNormalRedDotInterceptor)localIterator.next();
      if (localIRIJNormalRedDotInterceptor.a(paramMessageRecord))
      {
        QLog.d("KandianMergeManager", 2, "getRedDotInterceptor --> found an interceptor!");
        return new RIJNormalRedDotInterceptorWrapper(localIRIJNormalRedDotInterceptor);
      }
    }
    QLog.d("KandianMergeManager", 2, "getRedDotInterceptor --> no interceptor handle!");
    return new RIJNormalRedDotInterceptorWrapper(null);
  }
  
  @Nullable
  public KandianMsgBoxRedPntInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  }
  
  public KandianRedDotInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  @VisibleForTesting
  MessageRecord a()
  {
    MessageRecord localMessageRecord = null;
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (localRedTouchManager == null)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | RedTouchManager is null ");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("1130");
    if (localAppInfo != null) {
      localArrayList.add(localAppInfo);
    }
    localAppInfo = localRedTouchManager.b(7, "1130");
    if (localAppInfo != null) {
      localArrayList.add(localAppInfo);
    }
    QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | receive a red point push notify, size : " + localArrayList.size());
    int i = 0;
    if (i < localArrayList.size())
    {
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i);
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | parse redPntInfo type :  " + localAppInfo.type.get());
      AladdinConfig localAladdinConfig = Aladdin.getConfig(186);
      if (localAppInfo.type.get() == 5) {
        a(localRedTouchManager, 1130, localAppInfo, localAladdinConfig);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (localAppInfo.type.get() == 0)
      {
        localMessageRecord = a(localMessageRecord, localAppInfo);
        continue;
        QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify end !");
        return localMessageRecord;
      }
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    IRIJNormalRedDotInterceptor localIRIJNormalRedDotInterceptor = a(paramMessageRecord);
    if (localIRIJNormalRedDotInterceptor.b(paramMessageRecord)) {}
    do
    {
      do
      {
        return null;
      } while (a(paramMessageRecord));
      i = localIRIJNormalRedDotInterceptor.a(paramMessageRecord);
      if (i != 0) {
        break;
      }
    } while (!b(paramMessageRecord));
    e(paramMessageRecord);
    int i = a(paramMessageRecord);
    MessageRecord localMessageRecord = a(paramMessageRecord, i);
    if (!localIRIJNormalRedDotInterceptor.c(localMessageRecord))
    {
      if (i != 0) {
        break label106;
      }
      b(localMessageRecord);
    }
    for (;;)
    {
      RIJKanDianFolderStatus.a(localMessageRecord);
      d(paramMessageRecord);
      return localMessageRecord;
      if (i != -1) {
        break;
      }
      return null;
      label106:
      if (i == 1)
      {
        c(localMessageRecord);
        l();
      }
    }
  }
  
  @VisibleForTesting
  MessageRecord a(MessageRecord paramMessageRecord, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.istroop = 7220;
    if (paramInt == 0)
    {
      localMessageRecord.extInt = 1;
      a(localMessageRecord, 0);
      if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label116;
      }
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
      label74:
      if (!f()) {
        break label129;
      }
    }
    label129:
    for (localMessageRecord.vipBubbleID = -1000L;; localMessageRecord.vipBubbleID = -999L)
    {
      f(localMessageRecord);
      return localMessageRecord;
      if (paramInt == 1)
      {
        localMessageRecord.extInt = 2;
        break;
      }
      localMessageRecord.extInt = 0;
      break;
      label116:
      localMessageRecord.extLong |= 0x2;
      break label74;
    }
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageForStructing.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageForStructing.time = RIJMergeKanDianMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong |= 0x20000000;
    localMessageForStructing.extLong |= 0x1;
    localMessageForStructing.structingMsg = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    localMessageForStructing.msg = localMessageForStructing.structingMsg.mMsgBrief;
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    a(localMessageForStructing, 1);
    if (!b(localMessageForStructing)) {
      return null;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    RIJKanDianFolderStatus.a(localMessageForStructing);
    paramString.a(localMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return localMessageForStructing;
  }
  
  @VisibleForTesting
  MessageRecord a(NamedNodeMap paramNamedNodeMap)
  {
    if (paramNamedNodeMap == null)
    {
      QLog.d("KandianMergeManager", 2, "parseRedPntInfoAndSave redInfoMap null ");
      return null;
    }
    String str1;
    String str2;
    label69:
    String str3;
    label97:
    String str4;
    label125:
    String str5;
    label153:
    String str6;
    if (paramNamedNodeMap.getNamedItem("orangeWord") != null)
    {
      str1 = paramNamedNodeMap.getNamedItem("orangeWord").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("brief") == null) {
        break label425;
      }
      str2 = paramNamedNodeMap.getNamedItem("brief").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("articleIds") == null) {
        break label431;
      }
      str3 = paramNamedNodeMap.getNamedItem("articleIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("algorithmIds") == null) {
        break label438;
      }
      str4 = paramNamedNodeMap.getNamedItem("algorithmIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("strategyIds") == null) {
        break label445;
      }
      str5 = paramNamedNodeMap.getNamedItem("strategyIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("actionData") == null) {
        break label452;
      }
      str6 = paramNamedNodeMap.getNamedItem("actionData").getNodeValue();
      label181:
      if (paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue") == null) {
        break label459;
      }
    }
    label425:
    label431:
    label438:
    label445:
    label452:
    label459:
    for (paramNamedNodeMap = paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue").getNodeValue();; paramNamedNodeMap = "")
    {
      this.h = str3;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.18(this));
      MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
      localMessageForStructing.msgtype = -2011;
      localMessageForStructing.structingMsg = StructMsgFactory.a();
      localMessageForStructing.structingMsg.mMsgServiceID = 142;
      localMessageForStructing.structingMsg.mMsgBrief = str2;
      localMessageForStructing.structingMsg.mOrangeWord = str1;
      localMessageForStructing.structingMsg.mArticleIds = str3;
      localMessageForStructing.structingMsg.mStrategyIds = str5;
      localMessageForStructing.structingMsg.mAlgorithmIds = str4;
      localMessageForStructing.structingMsg.reportEventFolderStatusValue = paramNamedNodeMap;
      localMessageForStructing.structingMsg.mMsgActionData = str6;
      localMessageForStructing.extInt = 1;
      localMessageForStructing.frienduin = AppConstants.KANDIAN_MERGE_UIN;
      localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
      localMessageForStructing.istroop = 7220;
      localMessageForStructing.issend = 0;
      localMessageForStructing.isread = false;
      localMessageForStructing.extLong = 0;
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      localMessageForStructing.createMessageUniseq();
      localMessageForStructing.doPrewrite();
      return a(localMessageForStructing);
      str1 = "";
      break;
      str2 = "";
      break label69;
      str3 = "";
      break label97;
      str4 = "";
      break label125;
      str5 = "";
      break label153;
      str6 = "";
      break label181;
    }
  }
  
  public MessageRecord a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Object localObject = new RIJPushComponentExtDataProcessor();
    paramArrayOfByte = ((RIJPushComponentExtDataProcessor)localObject).a(new String(paramArrayOfByte));
    JSONObject localJSONObject = ((RIJPushComponentExtDataProcessor)localObject).a(new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte));
    localObject = ((RIJPushComponentExtDataProcessor)localObject).a(new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte), paramString);
    paramString = (MessageForStructing)MessageRecordFactory.a(-2011);
    paramString.msgtype = -2011;
    paramString.structingMsg = StructMsgFactory.a();
    paramString.structingMsg.mMsgServiceID = 142;
    paramString.structingMsg.mArticleIds = paramArrayOfByte.jdField_a_of_type_JavaLangString;
    paramString.structingMsg.mStrategyIds = paramArrayOfByte.jdField_d_of_type_JavaLangString;
    paramString.structingMsg.mAlgorithmIds = paramArrayOfByte.jdField_c_of_type_JavaLangString;
    paramString.structingMsg.reportEventFolderStatusValue = paramArrayOfByte.jdField_b_of_type_JavaLangString;
    paramString.structingMsg.mMsgActionData = localJSONObject.toString();
    paramString.structingMsg.mExtraData = new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte);
    paramString.structingMsg.mMsgBrief = ((JSONObject)localObject).optString("brief", "");
    paramString.structingMsg.mOrangeWord = ((JSONObject)localObject).optString("orangeWord", "");
    paramString.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    paramString.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramString.senderuin = AppConstants.NEW_KANDIAN_UIN;
    paramString.istroop = 7220;
    paramString.extInt = 1;
    paramString.time = NetConnInfoCenter.getServerTime();
    paramString.isread = false;
    paramString.issend = 0;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      paramString.extLong |= 0x20000000;
    }
    for (paramString.extLong |= 0x1;; paramString.extLong |= 0x2)
    {
      QLog.d("KandianMergeManager", 1, "createFakeMsgFrom0x135XmlBuffer fakeMr.structingMsg: " + paramString.structingMsg);
      paramString.msg = paramString.structingMsg.mMsgBrief;
      paramString.msgData = paramString.structingMsg.getBytes();
      a(paramString, 0);
      if (!RIJLockScreenPushReport.a(paramString)) {
        break;
      }
      QLog.d("KandianMergeManager", 1, "createFakeMsgFrom0x135XmlBuffer receive daily push ! mr : " + paramString);
      ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramString);
      return paramString;
    }
    d(paramString);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    RIJKanDianFolderStatus.a(paramString);
    paramArrayOfByte.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return paramString;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    int i = 1;
    int k = 0;
    int j = 0;
    Object localObject2 = "";
    label55:
    Object localObject1;
    if (!ReadInJoyHelper.n())
    {
      boolean bool = RIJXTabNormalRedDotStore.a.a();
      if (b())
      {
        k = 1;
        int m = e();
        if ((k <= 0) && (m <= 0) && (!bool)) {
          break label169;
        }
        i = 1;
        if (m > 0) {
          j = 5;
        }
        localObject1 = String.valueOf(m);
        if (m > 99) {
          localObject1 = "99+";
        }
        QLog.d("KandianMergeManager", 1, "getReadinjoyTabRedInfo, recommendRedNum : " + k + ", msgBoxRedNum : " + m);
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label198;
      }
      localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#FF0000'}");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(j);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set((String)localObject1);
      return localObject2;
      k = 0;
      break;
      label169:
      i = 0;
      break label55;
      j = k;
      localObject1 = localObject2;
      if (!g())
      {
        i = 0;
        j = k;
        localObject1 = localObject2;
      }
    }
    label198:
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(Long paramLong)
  {
    if (paramLong.longValue() > 0L) {
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramLong);
    }
    return null;
  }
  
  public List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = RIJXTabNormalRedDotStore.a.a(0);
    if ((RIJXTabConfigHandler.b().a()) && (localRIJXTabRedDotInfo != null)) {}
    while ((!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)) {
      try
      {
        long l1 = Long.parseLong(localRIJXTabRedDotInfo.getArticleIds());
        long l2 = Long.parseLong(localRIJXTabRedDotInfo.getAlgorithmIds());
        long l3 = Long.parseLong(localRIJXTabRedDotInfo.getStrategyIds());
        localArrayList.add(Long.valueOf(l1));
        localArrayList.add(Long.valueOf(l2));
        localArrayList.add(Long.valueOf(l3));
        return localArrayList;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("KandianMergeManager", 2, "getKandianArticleIdsWhenRefreshKandian failed --> " + localRIJXTabRedDotInfo);
      }
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_Long));
      localArrayList.add(Long.valueOf(this.jdField_b_of_type_Long));
    }
    QLog.i("KandianMergeManager", 1, "getKandianArticleIdsWhenRefreshKandian: " + localArrayList.toString());
    return localArrayList;
  }
  
  public void a()
  {
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 1) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.3(this));
    }
    l();
    RIJWebArticleUtil.a.a();
    PTSHelper.a();
    RIJMainChannelUtil.a.b();
    RIJChannelBannerUtil.a.a();
    RIJFeedsInsertUtil.a.a();
    RIJUserInfoUtil.a.a();
    VideoAudioControlUtil.a.a();
    TKDCommentFragmentHelper.clearHippyCommentConfig();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KandianMergeManager", 2, "followListLength" + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    ThreadManager.post(new KandianMergeManager.12(this, paramInt), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianMergeManager.KandianSetTopInfo localKandianSetTopInfo = KandianMergeManager.KandianSetTopInfo.get(paramInt1, paramInt2);
    RIJSPUtils.a("kandian_msgtab_settop", localKandianSetTopInfo, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = localKandianSetTopInfo;
    QLog.d("KandianMergeManager.SETTOP", 2, "update kandian push msg setTop info : " + localKandianSetTopInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.g = paramString;
    if (!this.g.isEmpty()) {
      ReadInJoyLogicEngine.a().b(paramInt, this.g);
    }
  }
  
  public void a(IRIJNormalRedDotInterceptor paramIRIJNormalRedDotInterceptor)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramIRIJNormalRedDotInterceptor);
  }
  
  public void a(KandianMergeManager.InsertArticleInfo paramInsertArticleInfo)
  {
    if (paramInsertArticleInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaUtilList.add(paramInsertArticleInfo);
      }
      finally {}
    }
  }
  
  public void a(KandianMergeManager.MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_e_of_type_JavaUtilList == null) {
          this.jdField_e_of_type_JavaUtilList = new ArrayList();
        }
        QLog.d("KandianMergeManager", 2, "add MsgObserver " + paramMessageObserver.getClass().getSimpleName() + ", " + paramMessageObserver);
        if (this.jdField_e_of_type_JavaUtilList.contains(paramMessageObserver)) {
          continue;
        }
        this.jdField_e_of_type_JavaUtilList.add(paramMessageObserver);
      }
      finally {}
    }
  }
  
  public void a(KandianMergeManager.OnMainVideoTabRedChangeListener paramOnMainVideoTabRedChangeListener)
  {
    if (paramOnMainVideoTabRedChangeListener == null) {}
    do
    {
      return;
      if (this.jdField_d_of_type_JavaUtilList == null) {
        this.jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + paramOnMainVideoTabRedChangeListener.getClass().getSimpleName() + ", " + paramOnMainVideoTabRedChangeListener);
    } while (this.jdField_d_of_type_JavaUtilList.contains(paramOnMainVideoTabRedChangeListener));
    this.jdField_d_of_type_JavaUtilList.add(paramOnMainVideoTabRedChangeListener);
  }
  
  public void a(KandianMergeManager.OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_JavaUtilList == null) {
        this.jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + paramOnTabRedNumsChangeListenner.getClass().getSimpleName() + ", " + paramOnTabRedNumsChangeListenner);
    } while (this.jdField_c_of_type_JavaUtilList.contains(paramOnTabRedNumsChangeListenner));
    this.jdField_c_of_type_JavaUtilList.add(paramOnTabRedNumsChangeListenner);
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (paramKandianMsgBoxRedPntInfo.mSeq <= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mSeq) && ((this.g == null) || (this.g.isEmpty()))) {}
    for (int i = 1; (paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.mMsgCnt <= 0) || (i != 0); i = 0)
    {
      QLog.d("KandianMergeManager", 1, new Object[] { "new msgbox red info has error, local : ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo, "new : ", paramKandianMsgBoxRedPntInfo });
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.asyncWriteToSP();
    this.g = "";
    String str;
    long l;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mNeedShowInFolder)
    {
      paramKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mSummary;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mOrangeWord;
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgTime;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mRedType == 0) {
        bool = true;
      }
    }
    for (paramKandianMsgBoxRedPntInfo = a(paramKandianMsgBoxRedPntInfo, str, l, bool, false, null);; paramKandianMsgBoxRedPntInfo = null)
    {
      a(paramKandianMsgBoxRedPntInfo, KandianOx210MsgInfo.k, null);
      l();
      QLog.d("KandianMergeManager", 1, "update msgbox redpnt info. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
      return;
      bool = false;
      break;
    }
  }
  
  public void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null) {
      if (!paramKandianRedDotInfo.hasArticleID()) {}
    }
    for (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo;; this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo)
    {
      QLog.d("KandianMergeManager", 1, "update mainVideoTab RedDot : " + paramKandianRedDotInfo);
      m();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.saveToDiskAsync(true);
      return;
      QLog.d("KandianMergeManager", 1, "main video tab fake red drop because of has reddot now!");
      return;
    }
  }
  
  public void a(MySelfNormalItemRedPointInfo paramMySelfNormalItemRedPointInfo)
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.37(this, paramMySelfNormalItemRedPointInfo));
  }
  
  public void a(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(paramReadInJoyTabObserver);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      paramMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.21(this, paramMessageRecord), 10, null, false);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramMessageRecord.extStr))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("kandian_push_from", paramInt);
        paramMessageRecord.extStr = localJSONObject.toString();
        return;
      }
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
    localJSONObject.put("kandian_push_from", paramInt);
    paramMessageRecord.extStr = localJSONObject.toString();
  }
  
  public void a(String paramString)
  {
    try
    {
      if (TextUtils.equals(paramString, this.jdField_d_of_type_JavaLangString))
      {
        e();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = b();
          if (paramString != null)
          {
            RIJKanDianFolderStatus.a(paramString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || ((paramInt != 0) && (paramInt != 1))) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      do
      {
        return;
      } while (paramInt == 1);
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new KandianMergeManager.14(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      RIJAppSetting.a(localQQAppInterface, paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Class paramClass)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.getSimpleName(), Boolean.valueOf(paramBoolean));
    String str = paramClass.getSimpleName();
    if (BaseActivity.sTopActivity != null) {}
    for (paramClass = BaseActivity.sTopActivity.getClass().getSimpleName();; paramClass = "")
    {
      if (TextUtils.equals(str, paramClass))
      {
        if (!paramBoolean) {
          break;
        }
        o();
      }
      return;
    }
    KandianAppInPush.a().a(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      i = 1;
      this.jdField_a_of_type_Int = i;
      if ((!paramBoolean2) || (!this.jdField_a_of_type_Boolean)) {
        break label28;
      }
    }
    label28:
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      i = 0;
      break;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } while ((localRecentUser == null) && (!paramBoolean1) && (paramBoolean2 == true));
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new RecentUser(AppConstants.KANDIAN_MERGE_UIN, 7220);
      ((RecentUser)localObject).lastmsgtime = NetConnInfoCenter.getServerTime();
    }
    if (paramBoolean1) {}
    for (((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject).showUpTime = 0L)
    {
      localRecentUserProxy.b((RecentUser)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      if (paramBoolean2) {
        break;
      }
      c(paramBoolean1);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = localMsgBody.uint64_seq.get();
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long;
      QLog.d("KandianMergeManager", 1, "biu 0x210Msg reached, oldSeq = " + l2 + ", newSeq = " + l1);
      if (l2 >= l1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "biu 0x210Msg delay reached, no updated!");
        }
      }
      else if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.has()) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get() != null) && (((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.has()))
      {
        l2 = ((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.get();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_b_of_type_Long = l2;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        QLog.d("KandianMergeManager", 1, "has biu 0x210 msg push, seq = " + l1 + ", uin = " + l2);
        a(null, KandianOx210MsgInfo.l, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.decodeFromPbBytes(paramArrayOfByte);
    if ((localKandian210Msg0xeeInfo == null) || (KandianAppInPush.a().a())) {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 sub 0xee msg fail!");
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo != null) && (localKandian210Msg0xeeInfo.msgSeq < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.msgSeq));
      if ((localKandian210Msg0xeeInfo.notifyInfos != null) && (!localKandian210Msg0xeeInfo.notifyInfos.isEmpty()) && (!TextUtils.isEmpty(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).contextTitle))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("KandianMergeManager", 2, "0x210 sub 0xee msg title empty, just abandon " + localKandian210Msg0xeeInfo);
    return;
    if (a("processMsg0x210Sub0xee"))
    {
      a(a(localKandian210Msg0xeeInfo));
      return;
    }
    boolean bool = false;
    Object localObject;
    Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo;
    if (localKandian210Msg0xeeInfo.isArticleAppInPush())
    {
      this.jdField_a_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).algorithmID;
      this.jdField_b_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).strategyID;
      this.jdField_a_of_type_JavaLangString = ReadInJoyStringUtils.a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).extCookie, 0);
      localObject = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).orangeWord;
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null) {
        paramArrayOfByte = HardCodeUtil.a(2131705939);
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilArrayList.add(0, Long.valueOf(localNotifyInfo.contextId));
      }
      paramArrayOfByte = a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).contextTitle, paramArrayOfByte, paramLong, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue(), ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).folderStatus);
      if (paramArrayOfByte != null) {
        c(paramArrayOfByte);
      }
      b(paramArrayOfByte);
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = localKandian210Msg0xeeInfo;
        Kandian210Msg0xeeInfo.writeToSpAsync(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
        o();
      }
      QLog.d("KandianMergeManager", 2, "process Msg 210 0xee canHandle : " + bool + "\n InAppPush : " + localKandian210Msg0xeeInfo);
      return;
      if (localKandian210Msg0xeeInfo.isVideoAppInPush())
      {
        if (!ReadInJoyHelper.n())
        {
          QLog.d("KandianMergeManager", 2, "received video app in push , but user is not in video tab, drop it as wife");
          return;
        }
        paramArrayOfByte = new KandianRedDotInfo("kandian_video_tab_reddot_info");
        localObject = (Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0);
        paramArrayOfByte.algorithmID = ((Kandian210Msg0xeeInfo.NotifyInfo)localObject).algorithmID;
        paramArrayOfByte.cookie = Html.fromHtml(((Kandian210Msg0xeeInfo.NotifyInfo)localObject).extCookie).toString();
        localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
          paramArrayOfByte.articleIDList.add(0, Long.valueOf(localNotifyInfo.contextId));
        }
        a(paramArrayOfByte);
        m();
        bool = true;
      }
      else
      {
        QLog.d("KandianMergeManager", 2, "received unknow app in push, bid " + localKandian210Msg0xeeInfo.bid);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, OnLinePushMessageProcessor paramOnLinePushMessageProcessor)
  {
    int i = KandianOx210MsgInfo.c(paramArrayOfByte);
    QLog.i("KandianMergeManager", 1, "processMsg0x210Sub0xc5, receiveMsg bidType= " + i);
    if (i == 2)
    {
      b(paramArrayOfByte, paramLong, paramOnLinePushMessageProcessor);
      return;
    }
    c(paramArrayOfByte, paramLong, paramOnLinePushMessageProcessor);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KandianMergeManager", 2, "erasureTabRedWhenSwitchTab from: " + paramInt1 + ", to: " + paramInt2);
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {}
    do
    {
      return false;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return true;
      }
      if ((paramInt1 != 1) && (paramInt2 == 1))
      {
        if (b(1) > 0) {
          ThreadManager.getSubThreadHandler().post(new KandianMergeManager.31(this));
        }
        d(1);
        return true;
      }
      if ((paramInt1 == 1) && (paramInt2 == 1))
      {
        if (b(1) > 0) {
          ThreadManager.getSubThreadHandler().post(new KandianMergeManager.32(this));
        }
        d(1);
        return true;
      }
      if (paramInt2 == 2)
      {
        d(2);
        return true;
      }
    } while ((paramInt2 != 3) || (b(3) <= 0));
    return false;
  }
  
  @VisibleForTesting
  boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return true;
    }
    if ((a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) && (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return true;
    }
    if (KandianAppInPush.a().a(2000002))
    {
      QLog.d("KandianMergeManager", 2, "app in push is showing, abandon the new msg !");
      return true;
    }
    if ((ReadInJoyUtils.a(paramMessageRecord)) && (ReadInJoyUtils.b(paramMessageRecord)))
    {
      QLog.d("KandianMergeManager", 1, "receive daily lock screen red point push ! mr : " + paramMessageRecord);
      ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramMessageRecord);
      return true;
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        long l = paramMessageRecord.time;
        String str = paramMessageRecord.senderuin;
        int j = paramMessageRecord.msgtype;
        Object localObject2 = "";
        if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("kandian_replace_subscribe_msg")))
        {
          paramMessageRecord = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
          if (paramMessageRecord != null) {
            paramMessageRecord.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
          }
          paramBoolean = false;
          return paramBoolean;
        }
        if (l > this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
        {
          if (!paramBoolean)
          {
            this.jdField_e_of_type_JavaLangString = "";
            this.f = "";
            this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
            if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramMessageRecord.msgtype))
            {
              bool = true;
              localObject1 = "";
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_d_of_type_JavaLangString = str;
              this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j);
              if ((paramBoolean) || (!ReadInJoyHelper.o())) {
                g();
              }
              ThreadManager.getSubThreadHandler().post(new KandianMergeManager.22(this, l, str, 1, (String)localObject1, j));
              QLog.d("KandianMergeManager", 1, "subscribe push, title : " + this.jdField_e_of_type_JavaLangString + ", id : " + this.jdField_a_of_type_JavaLangLong + ", msguid : " + paramMessageRecord.msgUid + ", isInterestedAccount : " + bool);
              paramBoolean = true;
              continue;
            }
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              Object localObject3 = (MessageForStructing)paramMessageRecord;
              ((MessageForStructing)localObject3).parse();
              if (((MessageForStructing)localObject3).structingMsg == null) {
                break label529;
              }
              localObject1 = PkgTools.toHexStr(((MessageForStructing)localObject3).structingMsg.getBytes());
              this.jdField_e_of_type_JavaLangString = ((MessageForStructing)localObject3).structingMsg.mMsgBrief;
              if (!TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mInnerUniqIds))
              {
                localObject2 = ((MessageForStructing)localObject3).structingMsg.mInnerUniqIds.split("\\|");
                k = localObject2.length;
                i = 0;
                if (i >= k) {
                  break label536;
                }
                localObject3 = localObject2[i];
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label542;
                }
                this.f = ((String)localObject3);
                break label536;
              }
              localObject2 = localObject1;
              if (TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mArticleIds)) {
                break label529;
              }
              localObject3 = ((MessageForStructing)localObject3).structingMsg.mArticleIds.split("\\|");
              int k = localObject3.length;
              i = 0;
              localObject2 = localObject1;
              if (i >= k) {
                break label529;
              }
              localObject2 = localObject3[i];
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label549;
              }
              this.jdField_a_of_type_JavaLangLong = Long.valueOf((String)localObject2);
              break label536;
            }
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "parse subscribe push struct msg fail !");
            }
          }
          bool = false;
          localObject1 = "";
          continue;
        }
        else
        {
          paramBoolean = false;
          continue;
        }
        Object localObject1 = localObject2;
      }
      finally {}
      label529:
      label536:
      boolean bool = false;
      continue;
      label542:
      i += 1;
      continue;
      label549:
      i += 1;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Int;
    }
    return 0;
  }
  
  public int b(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "getTabRedNums tab: " + paramInt + ", nums: " + i);
      }
      return i;
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i < 0) {
        break;
      }
      continue;
      i = this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i <= 0) {
        break;
      }
      continue;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo == null) {
        break;
      }
      i = 1;
      continue;
      i = d();
    }
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return -1;
      if (!TextUtils.isEmpty(paramMessageRecord.extStr)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.extStr);
          if (paramMessageRecord.has("kandian_push_from"))
          {
            int i = Integer.parseInt(paramMessageRecord.getString("kandian_push_from"));
            return i;
          }
        }
        catch (Exception paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      return KandianMergeManager.KandianSetTopInfo.access$1200(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    }
    return 0L;
  }
  
  public KandianRedDotInfo b()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public MessageRecord b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4)) {}
        while ((!localMessageRecord.isValid) || (MsgProxyUtils.b(localMessageRecord.msgtype)))
        {
          i -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1 OR extInt=3");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public List<KandianMergeManager.InsertArticleInfo> b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.clear();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("1130");
    if (localAppInfo != null) {
      localRedTouchManager.b(localAppInfo, "");
    }
    localAppInfo = localRedTouchManager.b(7, "1130");
    if (localAppInfo != null) {
      localRedTouchManager.b(localAppInfo, "");
    }
    QLog.d("KandianMergeManager", 1, "reportRedPntExposure");
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0);
    e();
  }
  
  public void b(KandianMergeManager.MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.jdField_e_of_type_JavaUtilList == null) || (this.jdField_e_of_type_JavaUtilList.isEmpty())) {
          continue;
        }
        QLog.d("KandianMergeManager", 2, "remove MsgObserver " + paramMessageObserver.getClass().getSimpleName() + ", " + paramMessageObserver);
        this.jdField_e_of_type_JavaUtilList.remove(paramMessageObserver);
      }
      finally {}
    }
  }
  
  public void b(KandianMergeManager.OnMainVideoTabRedChangeListener paramOnMainVideoTabRedChangeListener)
  {
    if ((paramOnMainVideoTabRedChangeListener == null) || (this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + paramOnMainVideoTabRedChangeListener.getClass().getSimpleName() + ", " + paramOnMainVideoTabRedChangeListener);
    this.jdField_d_of_type_JavaUtilList.remove(paramOnMainVideoTabRedChangeListener);
  }
  
  public void b(KandianMergeManager.OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {}
    while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + paramOnTabRedNumsChangeListenner.getClass().getSimpleName() + ", " + paramOnTabRedNumsChangeListenner);
    this.jdField_c_of_type_JavaUtilList.remove(paramOnTabRedNumsChangeListenner);
  }
  
  public void b(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(paramReadInJoyTabObserver);
  }
  
  @VisibleForTesting
  void b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_e_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.MessageObserver)localIterator.next()).a(paramMessageRecord);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public boolean b()
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return false;
    }
    QLog.d("KandianMergeManager", 1, "SubUnread : " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", SubStatus : " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", mSubTitle : " + RIJAppSetting.a(this.jdField_e_of_type_JavaLangString) + ", KDUnread : " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) && ((ReadInJoyHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccount(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))))
    {
      if ((ReadInJoyHelper.o()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_a_of_type_JavaLangLong.longValue() <= 0L) && (TextUtils.isEmpty(this.f)))
      {
        QLog.d("KandianMergeManager", 2, "subscribe push has not article id , give up auto refresh! only for kandian tab");
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    int i = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 0) {
      bool = d(paramMessageRecord);
    }
    while (i != 1) {
      return bool;
    }
    return a(paramMessageRecord, false);
  }
  
  public int c()
  {
    return ReadInJoyLogicEngine.a().a();
  }
  
  public long c()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null)
    {
      l1 = l2;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead) {
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mUin;
      }
    }
    return l1;
  }
  
  public KandianRedDotInfo c()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public MessageRecord c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4) || (localMessageRecord.extInt == 3)) {}
        while (((localMessageRecord.extInt == 5) && (!e())) || (!localMessageRecord.isValid) || (MsgProxyUtils.b(localMessageRecord.msgtype)))
        {
          i -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public void c()
  {
    if (ReadInJoyHelper.o()) {
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : isShowKandianTab give up clean !");
    }
    int i;
    label64:
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
          break label292;
        }
        if (!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())) {
          break;
        }
        e();
        i = 1;
        localObject1 = TroopBarAssistantManager.a();
        if (localObject1 != null) {
          ((TroopBarAssistantManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      } while (i == 0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localObject1 == null) {
        break label297;
      }
    } while ((((MessageRecord)localObject1).extInt == 1) || (((MessageRecord)localObject1).extInt == 3));
    long l = ((MessageRecord)localObject1).time;
    label134:
    Object localObject1 = b();
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131695233);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131695233);
      }
      localObject1 = a((String)localObject2, String.valueOf(l), 0);
      RIJKanDianFolderStatus.a((MessageRecord)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : last msg is interested account,replace by kandian. " + ((MessageRecord)localObject1).msg);
      return;
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        e();
        i = 0;
        break label64;
      }
      c(3);
      label292:
      i = 0;
      break label64;
      label297:
      l = NetConnInfoCenter.getServerTime();
      break label134;
      if ((((MessageRecord)localObject1).extInt == 1) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)localObject1;
        ((MessageForStructing)localObject2).parse();
        if (((MessageForStructing)localObject2).structingMsg == null) {
          localObject1 = ((MessageRecord)localObject1).msg;
        } else {
          localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        }
      }
      else
      {
        localObject1 = ((MessageRecord)localObject1).msg;
      }
    }
  }
  
  /* Error */
  public void c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_3
    //   4: if_icmpne +29 -> 33
    //   7: aload_0
    //   8: getfield 171	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 1332	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: iconst_2
    //   15: if_icmpne +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 1864	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:e	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 165	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: iconst_0
    //   30: invokevirtual 1308	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   33: aload_0
    //   34: getfield 171	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   37: iload_1
    //   38: invokevirtual 1308	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   41: invokestatic 1228	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   44: new 2246	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$23
    //   47: dup
    //   48: aload_0
    //   49: iload_1
    //   50: invokespecial 2247	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$23:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;I)V
    //   53: invokevirtual 1225	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   56: pop
    //   57: goto -35 -> 22
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	KandianMergeManager
    //   0	65	1	paramInt	int
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	22	60	finally
    //   25	33	60	finally
    //   33	57	60	finally
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    if (this.jdField_e_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.MessageObserver)localIterator.next()).b(paramMessageRecord);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int j = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
      if (localUserOperationModule != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        i = j;
        if (paramBoolean) {
          i = 2;
        }
        localUserOperationModule.a(str, i);
      }
      return;
    }
  }
  
  public boolean c()
  {
    return !ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    AbsStructMsg localAbsStructMsg;
    try
    {
      localAbsStructMsg = StructMsgFactory.a();
      localAbsStructMsg.uin = paramMessageRecord.frienduin;
      localAbsStructMsg.currentAccountUin = paramMessageRecord.selfuin;
      localAbsStructMsg.mMsgBrief = paramMessageRecord.msg;
      localAbsStructMsg.mMsgActionData = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((Long)localIterator.next()).append("|");
      }
      localAbsStructMsg.mArticleIds = localStringBuilder.toString();
    }
    finally {}
    localAbsStructMsg.mAlgorithmIds = String.valueOf(this.jdField_a_of_type_Long);
    localAbsStructMsg.mStrategyIds = String.valueOf(this.jdField_b_of_type_Long);
    long l = paramMessageRecord.time;
    paramMessageRecord = PkgTools.toHexStr(localAbsStructMsg.getBytes());
    if (l > this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.25(this, paramMessageRecord, l));
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2))
      {
        c(2);
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0xee push, ids: " + this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
        break;
      }
      e();
      break;
    }
  }
  
  public int d()
  {
    int i = 0;
    if (i()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return i;
  }
  
  public void d()
  {
    RIJKanDianFolderStatus.b();
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localMessageRecord != null) && (!localMessageRecord.isread))
    {
      localMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.20(this, localMessageRecord), 10, null, false);
    }
  }
  
  public void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("erasureTabRed index: " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 3: 
    default: 
    case 1: 
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
        }
        l();
        return;
        this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
    }
    if (b(paramInt) > 0) {}
    for (;;)
    {
      localStringBuilder.append(", subscribe msg successful");
      break;
      ReadInJoyLogicEngine.a().o();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramBoolean)
    {
      localAppInfo = localRedTouchManager.b(7, "1130");
      if (localAppInfo != null) {
        localRedTouchManager.a(localAppInfo, "");
      }
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "reportRedPntClick, isNumRedPnt : " + paramBoolean);
      return;
      localAppInfo = localRedTouchManager.a("1130");
      if (localAppInfo != null) {
        localRedTouchManager.a(localAppInfo, "");
      }
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      long l;
      Object localObject2;
      try
      {
        if (a("updateKandianPush2SP"))
        {
          a(a(paramMessageRecord));
          bool = false;
          return bool;
        }
        if (ReadInJoyLockScreenJumpDelegate.a(paramMessageRecord))
        {
          if (ReadInJoyUtils.a(paramMessageRecord)) {
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
          }
          QLog.i("KandianMergeManager", 1, "updateKandianPush2SP: block lock screen red dot.");
          bool = true;
          continue;
        }
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break label676;
        }
        localObject1 = (MessageForStructing)paramMessageRecord;
        ((MessageForStructing)localObject1).parse();
        if (((MessageForStructing)localObject1).structingMsg == null)
        {
          if (!QLog.isColorLevel()) {
            break label682;
          }
          QLog.d("KandianMergeManager", 2, "kandian push msg : struct msg body is null");
          break label682;
        }
        localObject1 = PkgTools.toHexStr(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
        l = paramMessageRecord.time;
        if (paramMessageRecord.time < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) {
          break label676;
        }
        if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds))
        {
          localObject2 = ((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds.split("\\|");
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int j = localObject2.length;
          if (i < j) {
            try
            {
              if (TextUtils.isEmpty(localObject2[i])) {
                break label688;
              }
              BigInteger localBigInteger = new BigInteger(localObject2[i]);
              this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(localBigInteger.longValue()));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              QLog.e("KandianMergeManager", 1, "parse kandian push articleID has num format error : " + localNumberFormatException);
            }
          }
        }
        this.jdField_a_of_type_JavaLangString = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgActionData;
      }
      finally {}
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds)) {
        this.jdField_a_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds)) {
        this.jdField_b_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds.split("\\|")[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramMessageRecord.time);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      if ((ReadInJoyUtils.a(paramMessageRecord)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.saveToDiskAsync(true);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.hasArticleID())
          {
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.articleIDList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Long localLong = (Long)((Iterator)localObject2).next();
              this.jdField_a_of_type_JavaUtilMap.put(localLong, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.extInfo);
            }
          }
        }
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.26(this, (String)localObject1, l));
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2)) {
        c(2);
      }
      for (;;)
      {
        f();
        RIJXTabNormalRedDotStore.a.a();
        QLog.d("KandianMergeManager", 1, "kandian push, ids: " + this.jdField_a_of_type_JavaUtilArrayList + ", msgUid : " + paramMessageRecord.msgUid + ", isLockScreenMsg : " + ReadInJoyUtils.a(paramMessageRecord) + ", pushContent : " + this.jdField_a_of_type_JavaLangString);
        bool = true;
        break;
        if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)) {
          e();
        }
      }
      label676:
      boolean bool = false;
      continue;
      label682:
      bool = false;
      continue;
      label688:
      i += 1;
    }
  }
  
  public int e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return 0;
  }
  
  public void e()
  {
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.jdField_d_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.24(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = null;
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean f()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localMessageRecord == null) || (localMessageRecord.isread)) {}
    while (localMessageRecord.vipBubbleID != -1000L) {
      return false;
    }
    return true;
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.removeFromDiskAsync(true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.27(this));
      return;
    }
    finally {}
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null;
  }
  
  public void h()
  {
    RIJKanDianFolderStatus.b();
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
    String str;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      str = AppConstants.KANDIAN_MERGE_UIN;
    }
    for (int i = 7220;; i = 1008)
    {
      if ((localConversationFacade != null) && (localConversationFacade.a(str, i) > 0)) {
        ThreadManager.post(new KandianMergeManager.28(this, str, i), 8, null, false);
      }
      return;
      str = AppConstants.NEW_KANDIAN_UIN;
    }
  }
  
  public boolean h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SplashActivity");
    if ((BaseActivity.sTopActivity != null) && ((ReadInJoyUtils.a() instanceof QQAppInterface)) && (!FrameHelperActivity.o))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      String str = localBaseActivity.getClass().getSimpleName();
      if (localArrayList.contains(str))
      {
        if ("SplashActivity".equals(str))
        {
          if (SplashActivity.currentFragment != 1) {
            return false;
          }
          if (((SplashActivity)localBaseActivity).getCurrentTab() == FrameControllerUtil.g) {
            return false;
          }
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(str)).booleanValue();
        }
        return true;
      }
    }
    return false;
  }
  
  public void i()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "get_message_configuration");
    mobileqq_mp.GetMessageConfigurationRequest localGetMessageConfigurationRequest = new mobileqq_mp.GetMessageConfigurationRequest();
    localGetMessageConfigurationRequest.uin.set(2171946401L);
    localGetMessageConfigurationRequest.versionInfo.set(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getVersionInfo());
    localNewIntent.putExtra("data", localGetMessageConfigurationRequest.toByteArray());
    localNewIntent.setObserver(new KandianMergeManager.29(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean i()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.30(this));
    }
  }
  
  /* Error */
  public boolean j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 936 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	KandianMergeManager
    //   11	13	1	bool	boolean
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    localRecentUser.lastmsgtime = l;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(l));
    localRecentUserProxy.b(localRecentUser);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    QLog.d("KandianMergeManager", 1, "stickKandianConversation successful! newTime : " + l);
  }
  
  public void l()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      C();
      return;
    }
    ThreadManager.getUIHandler().post(new KandianMergeManager.33(this));
  }
  
  public void m()
  {
    ThreadManager.getUIHandler().post(new KandianMergeManager.34(this));
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.removeFromDiskAsync(true);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
    m();
  }
  
  public void o()
  {
    ThreadManager.executeOnSubThread(new KandianMergeManager.35(this));
  }
  
  public void onDestroy()
  {
    ReadInJoyHelper.b();
    E();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    ReadInJoyDataProviderObserver.a().a(null);
    TaskManager.getInstance().stopAllTasks();
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    if (this.jdField_e_of_type_JavaUtilList != null) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
    SneakyCallback.b();
    AladdinListenerUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
    v();
    x();
    ProteusPreloadManager.a.a();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation = true;
    }
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.asyncWriteToSP();
      l();
      QLog.d("KandianMergeManager", 1, "clear msg box redPnt info, " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    }
  }
  
  public void r()
  {
    try
    {
      boolean bool = b();
      QLog.d("KandianMergeManager", 1, new Object[] { "switch to sub channel, clear kandian red point, hasRedPoint = ", Boolean.valueOf(bool) });
      if (bool)
      {
        F();
        g();
        f();
        l();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager
 * JD-Core Version:    0.7.0.1
 */