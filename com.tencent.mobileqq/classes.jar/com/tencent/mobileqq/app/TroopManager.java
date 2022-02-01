package com.tencent.mobileqq.app;

import GROUP.MessageRemindRsp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.util.ArraySet;
import android.support.v4.util.LruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.troopconfig.TroopConfigForAllUser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.config.CfgProcess.OnGetConfigListener;
import com.tencent.mobileqq.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.mobileqq.data.HWTroopMemberCard;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.ITroopInfoCallback;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multicard.MultiCardManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.TroopMemberCardConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchConfigManager.TroopMemberSetting;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService.GetTroopCodeCallback;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig;
import com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.ReqBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;
import tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor.UserHonor;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopManager
  implements CfgProcess.OnGetConfigListener, Manager
{
  public static String a;
  public static String b;
  public static ArrayList<String> b;
  public static String c;
  public static ArrayList<String> c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  private int jdField_a_of_type_Int = 0;
  protected LruCache<String, TroopMemberCard> a;
  public TroopConfigForAllUser a;
  protected QQAppInterface a;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopManager.11(this);
  private TroopManager.ConfigableWordingSetter jdField_a_of_type_ComTencentMobileqqAppTroopManager$ConfigableWordingSetter = null;
  protected EntityManager a;
  private BatchAddFriendForTroopConfig jdField_a_of_type_ComTencentMobileqqRelationxBatchAddBatchAddFriendForTroopConfig = null;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopManager.10(this);
  public final HomeworkConfig a;
  public final ReciteConfig a;
  protected ArrayList<String> a;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Queue<Integer> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  protected Set<String> a;
  protected LruCache<String, HWTroopMemberCard> b;
  protected Set<String> b;
  LruCache<TroopManager.TroopMemberLevelValue, Drawable> c;
  private ArrayList<TroopInfo> d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "next_get_expire_time";
    jdField_b_of_type_JavaLangString = "big_troop_expired_info";
    jdField_c_of_type_JavaLangString = "troop_expired_notify_tips_count";
    jdField_d_of_type_JavaLangString = "troop_expired_notify_tips_last_time";
    e = "troop_expired_notify_tips_one_day_count";
    f = "troop_expired_notify_tips_close_count";
    g = "troop_expired_notify_count";
    h = "troop_expired_notify_dialog_last_time";
    i = "troop_expired_notify_dialog_is_show";
    j = "troop_expired_notify_dialog_one_day_count";
    k = "troop_expired_notify_dialog_last_day";
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  @Deprecated
  public TroopManager()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    this.jdField_d_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_b_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigHomeworkConfig = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteConfigReciteConfig = null;
  }
  
  public TroopManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    this.jdField_d_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_b_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver, true);
    TroopLinkManager.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigHomeworkConfig = new HomeworkConfig(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteConfigReciteConfig = new ReciteConfig(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentBizTroopconfigTroopConfigForAllUser = new TroopConfigForAllUser(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getConfigProcess().a("batch_add_friend_for_troop_config", this);
  }
  
  protected static int a(TroopManager.ExpiredType paramExpiredType, MessageRemindRsp paramMessageRemindRsp)
  {
    switch (TroopManager.12.a[paramExpiredType.ordinal()])
    {
    default: 
      return (int)paramMessageRemindRsp.iSVIPExpiredTime;
    case 2: 
      return (int)paramMessageRemindRsp.iGroupExpiredTime;
    }
    return paramMessageRemindRsp.iLhGroupExpiredTime;
  }
  
  public static MessageRemindRsp a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(jdField_b_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(paramSharedPreferences))
    {
      paramString = new MessageRemindRsp();
      paramString.readFrom(new JceInputStream(Utils.hexStr2Bytes(paramSharedPreferences)));
      return paramString;
    }
    return null;
  }
  
  protected static TroopManager.ExpiredType a(MessageRemindRsp paramMessageRemindRsp)
  {
    Object localObject2 = TroopManager.ExpiredType.SVIP;
    Object localObject1 = localObject2;
    if (paramMessageRemindRsp.iGroupExpiredTime != 0L)
    {
      localObject1 = localObject2;
      if (paramMessageRemindRsp.iGroupExpiredTime < paramMessageRemindRsp.iSVIPExpiredTime) {
        localObject1 = TroopManager.ExpiredType.GROUP;
      }
    }
    localObject2 = localObject1;
    if (paramMessageRemindRsp.iLhGroupExpiredTime != 0) {
      if (paramMessageRemindRsp.iGroupExpiredTime != 0L)
      {
        localObject2 = localObject1;
        if (paramMessageRemindRsp.iLhGroupExpiredTime >= paramMessageRemindRsp.iGroupExpiredTime) {}
      }
      else if (paramMessageRemindRsp.iSVIPExpiredTime != 0L)
      {
        localObject2 = localObject1;
        if (paramMessageRemindRsp.iLhGroupExpiredTime >= paramMessageRemindRsp.iSVIPExpiredTime) {}
      }
      else
      {
        localObject2 = TroopManager.ExpiredType.LIANG;
      }
    }
    return localObject2;
  }
  
  private SearchConfigManager.TroopMemberSetting a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    SearchConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SearchConfigManager.TroopMemberSetting localTroopMemberSetting = null;
    Object localObject1 = null;
    Object localObject2 = localTroopMemberSetting;
    if (SearchConfigManager.troopMemberUpdateConfigs != null)
    {
      localObject2 = localTroopMemberSetting;
      if (!SearchConfigManager.troopMemberUpdateConfigs.isEmpty())
      {
        Iterator localIterator = SearchConfigManager.troopMemberUpdateConfigs.iterator();
        localObject2 = localObject1;
        if (localIterator.hasNext())
        {
          localTroopMemberSetting = (SearchConfigManager.TroopMemberSetting)localIterator.next();
          if (paramBoolean)
          {
            localObject2 = localTroopMemberSetting;
            if (localObject1 != null) {
              if (localObject1.b <= localTroopMemberSetting.b) {
                break label133;
              }
            }
          }
        }
      }
    }
    label133:
    for (localObject2 = localTroopMemberSetting;; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if ((paramTroopInfo.wMemberNum > localTroopMemberSetting.jdField_a_of_type_Int) && (paramTroopInfo.wMemberNum < localTroopMemberSetting.b))
      {
        localObject2 = localTroopMemberSetting;
        return localObject2;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      return;
      ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).notifyQuitTroop(paramString);
      try
      {
        if (this.jdField_d_of_type_JavaUtilArrayList != null)
        {
          localObject = this.jdField_d_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((TroopInfo)((Iterator)localObject).next()).troopuin.equals(paramString)) {
              ((Iterator)localObject).remove();
            }
          }
        }
        return;
      }
      finally {}
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate((ArrayList)localObject);
      return;
      localObject = b(paramString);
    } while ((localObject == null) || (!a((TroopInfo)localObject, true)));
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    for (;;)
    {
      try
      {
        if (this.jdField_d_of_type_JavaUtilArrayList == null)
        {
          this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
          this.jdField_d_of_type_JavaUtilArrayList.add(localObject);
          localTroopHandler.a(true, paramString, ((TroopInfo)localObject).troopcode, 9);
          return;
        }
      }
      finally {}
      this.jdField_d_of_type_JavaUtilArrayList.add(localObject);
    }
  }
  
  public static void a(MessageRemindRsp paramMessageRemindRsp, QQAppInterface paramQQAppInterface, String paramString, Context paramContext, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager)
  {
    if (paramMessageRemindRsp == null) {}
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig;
    int m;
    TroopManager.ExpiredType localExpiredType;
    do
    {
      do
      {
        return;
        localQVipBigTroopExpiredConfig = QVipBigTroopExpiredProcessor.c();
      } while (!localQVipBigTroopExpiredConfig.mIsEnable);
      m = (int)(System.currentTimeMillis() / 1000L);
      localExpiredType = a(paramMessageRemindRsp);
      if (paramMessageRemindRsp.isFreezed)
      {
        a(paramQQAppInterface, paramString, m, localQVipBigTroopExpiredConfig, paramMessageRemindRsp, paramContext, localExpiredType, paramTroopChatPie, paramTipsManager);
        return;
      }
    } while ((paramMessageRemindRsp.eRemindLevel < 3) || (TroopManager.LiangGroupHelper.a(paramMessageRemindRsp.iGroupType)));
    int n = a(localExpiredType, paramMessageRemindRsp);
    if (VipUtils.a(m, n) > localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay)
    {
      ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).j(paramString);
      return;
    }
    a(paramQQAppInterface, paramString, m, localQVipBigTroopExpiredConfig, n, paramMessageRemindRsp, paramContext, localExpiredType, paramTroopChatPie, paramTipsManager);
  }
  
  private static void a(Context paramContext, TroopManager paramTroopManager, String paramString, MessageRemindRsp paramMessageRemindRsp, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, int paramInt3, TroopManager.ExpiredType paramExpiredType)
  {
    switch (TroopManager.12.a[paramExpiredType.ordinal()])
    {
    }
    int m;
    do
    {
      do
      {
        return;
        m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iSVIPExpiredTime);
      } while (((m > paramQVipBigTroopExpiredConfig.mNotifyDialogMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyDialogMinDay)) && (m != 0));
      VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 5).toString(), HardCodeUtil.a(2131715368), new TroopManager.4(), "0X8009E36", 1);
      paramTroopManager.h(paramString, paramInt2 + 1);
      paramTroopManager.i(paramString, paramInt1);
      paramTroopManager.j(paramString, paramInt3 + 1);
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
      return;
      m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iGroupExpiredTime);
    } while (((m > paramQVipBigTroopExpiredConfig.mNotifyDialogMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyDialogMinDay)) && (m != 0));
    VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 4).toString(), HardCodeUtil.a(2131715374), new TroopManager.5(), "0X8009E36", 1);
    paramTroopManager.h(paramString, paramInt2 + 1);
    paramTroopManager.i(paramString, paramInt1);
    paramTroopManager.j(paramString, paramInt3 + 1);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_b_of_type_JavaUtilArrayList.clear();
    jdField_c_of_type_JavaUtilArrayList.clear();
    a(paramQQAppInterface, jdField_b_of_type_JavaUtilArrayList, jdField_c_of_type_JavaUtilArrayList);
    if (jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      jdField_b_of_type_JavaUtilArrayList.addAll(Arrays.asList(new String[] { HardCodeUtil.a(2131715394), HardCodeUtil.a(2131715381), HardCodeUtil.a(2131715377), HardCodeUtil.a(2131715388), HardCodeUtil.a(2131715360), HardCodeUtil.a(2131715366), HardCodeUtil.a(2131715385) }));
    }
    if (jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
      jdField_c_of_type_JavaUtilArrayList.addAll(Arrays.asList(new String[] { HardCodeUtil.a(2131715396), HardCodeUtil.a(2131715370), HardCodeUtil.a(2131715395), HardCodeUtil.a(2131715382), HardCodeUtil.a(2131715397), HardCodeUtil.a(2131715387), HardCodeUtil.a(2131715351), HardCodeUtil.a(2131715347), HardCodeUtil.a(2131715364) }));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager, Context paramContext, TroopManager paramTroopManager, String paramString, MessageRemindRsp paramMessageRemindRsp, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, int paramInt3, TroopManager.ExpiredType paramExpiredType)
  {
    switch (TroopManager.12.a[paramExpiredType.ordinal()])
    {
    }
    int m;
    do
    {
      do
      {
        do
        {
          return;
          m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iSVIPExpiredTime);
        } while ((m > paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay));
        if (paramTroopChatPie.a == null)
        {
          paramTroopChatPie.a = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
          paramTipsManager.a(paramTroopChatPie.a);
        }
        paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 1), 0, 2);
        paramTipsManager.a(paramTroopChatPie.a, new Object[0]);
        paramTroopManager.d(paramString, paramInt2 + 1);
        paramTroopManager.e(paramString, paramInt1);
        paramTroopManager.f(paramString, paramInt3 + 1);
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 2, 0, "", "", "", "");
        return;
        m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iGroupExpiredTime);
      } while ((m > paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay));
      if (paramTroopChatPie.a == null)
      {
        paramTroopChatPie.a = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
        paramTipsManager.a(paramTroopChatPie.a);
      }
      paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 0), 0, 1);
      paramTipsManager.a(paramTroopChatPie.a, new Object[0]);
      paramTroopManager.d(paramString, paramInt2 + 1);
      paramTroopManager.e(paramString, paramInt1);
      paramTroopManager.f(paramString, paramInt3 + 1);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 1, 0, "", "", "", "");
      return;
      m = VipUtils.a(paramInt1, paramMessageRemindRsp.iLhGroupExpiredTime);
    } while ((m > paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay));
    if (paramTroopChatPie.a == null)
    {
      paramTroopChatPie.a = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
      paramTipsManager.a(paramTroopChatPie.a);
    }
    paramTroopChatPie.a.a(paramString, VipUtils.a(paramMessageRemindRsp.iLhGroupExpiredTime, 10), 0, 3);
    paramTipsManager.a(paramTroopChatPie.a, new Object[0]);
    paramTroopManager.d(paramString, paramInt2 + 1);
    paramTroopManager.e(paramString, paramInt1);
    paramTroopManager.f(paramString, paramInt3 + 1);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A579", 0, 0, "", "", "", "");
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, MessageRemindRsp paramMessageRemindRsp, Context paramContext, TroopManager.ExpiredType paramExpiredType, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    int m = localTroopManager.c(paramString);
    int n;
    if (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMaxCount)
    {
      if (!VipUtils.a(localTroopManager.d(paramString), paramInt1)) {
        a(paramQQAppInterface, paramTroopChatPie, paramTipsManager, paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, 0, paramExpiredType);
      }
    }
    else
    {
      m = localTroopManager.g(paramString);
      n = localTroopManager.h(paramString);
      if ((!VipUtils.a(paramInt1, paramInt2)) || (VipUtils.a(n, paramInt1))) {
        break label159;
      }
      a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, 0, paramExpiredType);
    }
    label159:
    do
    {
      do
      {
        return;
        n = localTroopManager.e(paramString);
        if (n >= paramQVipBigTroopExpiredConfig.mNotifyTipsPerDay) {
          break;
        }
        a(paramQQAppInterface, paramTroopChatPie, paramTipsManager, paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, n, paramExpiredType);
        break;
      } while (m >= paramQVipBigTroopExpiredConfig.mNotifyDialogMaxCount);
      if (!VipUtils.a(n, paramInt1))
      {
        a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, 0, paramExpiredType);
        return;
      }
      paramInt2 = localTroopManager.i(paramString);
    } while (paramInt2 >= paramQVipBigTroopExpiredConfig.mNotifyDialogPerDay);
    a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, paramInt2, paramExpiredType);
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, MessageRemindRsp paramMessageRemindRsp, Context paramContext, TroopManager.ExpiredType paramExpiredType, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (VipUtils.a(localTroopManager.d(paramString), paramInt)) {}
    for (;;)
    {
      if ((localTroopManager.j(paramString)) && (VipUtils.a(localTroopManager.j(paramString), paramInt) >= paramQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay))
      {
        a(paramExpiredType, paramQQAppInterface, paramContext, paramString, paramMessageRemindRsp);
        localTroopManager.k(paramString, paramInt);
      }
      return;
      if (localTroopManager.f(paramString) < paramQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount)
      {
        if (paramTroopChatPie.a == null)
        {
          paramTroopChatPie.a = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
          paramTipsManager.a(paramTroopChatPie.a);
        }
        a(paramExpiredType, paramQQAppInterface, paramString, paramTroopChatPie, paramMessageRemindRsp, paramTipsManager);
        localTroopManager.e(paramString, paramInt);
      }
    }
  }
  
  @Deprecated
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    ((IUniqueTitleService)paramQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).getTroopMemberUniqueTitle(paramString, paramLong1, paramLong2, paramTroopProtocolObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if ((paramJSONArray1 == null) || (paramJSONArray2 == null)) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
    localEditor.putString("troop_pobing_config_left_wording_" + paramString, paramJSONArray1.toString());
    localEditor.putString("troop_pobing_config_right_wording_" + paramString, paramJSONArray2.toString());
    localEditor.commit();
    a(paramQQAppInterface);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, List<String> paramList1, List<String> paramList2)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    String str = ((SharedPreferences)localObject).getString("troop_pobing_config_left_wording_" + paramQQAppInterface, "");
    paramQQAppInterface = ((SharedPreferences)localObject).getString("troop_pobing_config_right_wording_" + paramQQAppInterface, "");
    int m;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        localObject = new JSONArray(str);
        m = 0;
        while (m < ((JSONArray)localObject).length())
        {
          str = ((JSONArray)localObject).optString(m);
          if (!TextUtils.isEmpty(str)) {
            paramList1.add(str);
          }
          m += 1;
        }
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          return;
        }
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
      }
    } else {
      try
      {
        paramQQAppInterface = new JSONArray(paramQQAppInterface);
        m = 0;
        while (m < paramQQAppInterface.length())
        {
          paramList1 = paramQQAppInterface.optString(m);
          if (!TextUtils.isEmpty(paramList1)) {
            paramList2.add(paramList1);
          }
          m += 1;
        }
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  protected static void a(TroopManager.ExpiredType paramExpiredType, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, MessageRemindRsp paramMessageRemindRsp)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    switch (TroopManager.12.a[paramExpiredType.ordinal()])
    {
    default: 
      return;
    case 1: 
      VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 7).toString(), HardCodeUtil.a(2131715357), new TroopManager.1(localTroopManager, paramString), "0X8009E36", 2);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E35", 2, 0, "", "", "", "");
      return;
    case 2: 
      VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 6).toString(), HardCodeUtil.a(2131715393), new TroopManager.2(localTroopManager, paramString), "0X8009E36", 1);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
      return;
    }
    if (TroopManager.LiangGroupHelper.b(paramMessageRemindRsp.iGroupType)) {}
    for (int m = 13;; m = 14)
    {
      VipUtils.a(paramContext, paramString, VipUtils.a(0, m).toString(), HardCodeUtil.a(2131715340), new TroopManager.3(localTroopManager, paramString, paramQQAppInterface), "0X800A57E", 1, true);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A57D", 0, 0, "", "", "", "");
      return;
    }
  }
  
  protected static void a(TroopManager.ExpiredType paramExpiredType, QQAppInterface paramQQAppInterface, String paramString, TroopChatPie paramTroopChatPie, MessageRemindRsp paramMessageRemindRsp, TipsManager paramTipsManager)
  {
    switch (TroopManager.12.a[paramExpiredType.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 3), 1, 2);
      paramTipsManager.a(paramTroopChatPie.a, new Object[0]);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 2, 0, "", "", "", "");
      return;
    case 2: 
      paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 2), 1, 1);
      paramTipsManager.a(paramTroopChatPie.a, new Object[0]);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 1, 0, "", "", "", "");
      return;
    }
    paramExpiredType = paramTroopChatPie.a;
    int n = paramMessageRemindRsp.iLhGroupExpiredTime;
    if (TroopManager.LiangGroupHelper.b(paramMessageRemindRsp.iGroupType)) {}
    for (int m = 11;; m = 12)
    {
      paramExpiredType.a(paramString, VipUtils.a(n, m), 1, 4);
      paramTipsManager.a(paramTroopChatPie.a, new Object[0]);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A57B", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!TroopLuckyCharacterUtil.a(paramInt1, paramInt2)) {
      return;
    }
    ((TroopListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).notifyUI(TroopNotificationConstants.aC, true, null);
  }
  
  private void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("onUpdateTroopGetMemberList(memberLimit), troopUin:").append(paramString).append(", mGetTroopMemberListTroops == null:");
      if (this.jdField_d_of_type_JavaUtilArrayList == null)
      {
        bool = true;
        QLog.i("Q.contacttab.troop", 2, bool);
      }
    }
    else
    {
      paramList = new ArrayList();
      paramList.add(paramString);
      if (this.jdField_d_of_type_JavaUtilArrayList != null) {
        break label105;
      }
      ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate(paramList);
    }
    label105:
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
        } while (this.jdField_d_of_type_JavaUtilArrayList.size() <= 0);
        localTroopInfo = (TroopInfo)this.jdField_d_of_type_JavaUtilArrayList.get(0);
      } while (!localTroopInfo.troopuin.equals(paramString));
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (paramBoolean) {
        break label306;
      }
      paramInt1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (paramInt1 + 1);
      if (paramInt1 >= 3) {
        break label247;
      }
      localTroopHandler.a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 4);
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), failed, retry mRetryGetTroopMemberListCount:" + this.jdField_a_of_type_Int + ", troopUin" + localTroopInfo.troopuin);
    return;
    label247:
    ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).notifyGetTroopMembersFailed(paramString);
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.contacttab.troop", 2, "notifyTroopMembersUpdate, troopUin:" + paramString);
      }
      f();
      return;
      label306:
      ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate(paramList);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isOpenTroopMessage) {
      return true;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.f(paramMessageRecord.frienduin))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x6ef.ReqBody localReqBody = new oidb_cmd0x6ef.ReqBody();
    localReqBody.gc.set(Long.parseLong(paramString1));
    localReqBody.event_id.set(paramString2);
    localReqBody.seq.set(paramLong);
    ProtoUtils.b(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x6ef_0", 1775, 0);
    return false;
  }
  
  private boolean a(TroopInfo paramTroopInfo)
  {
    boolean bool1 = true;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0);
    boolean bool2;
    SearchConfigManager.TroopMemberSetting localTroopMemberSetting;
    if (i1 == 0)
    {
      bool2 = true;
      localTroopMemberSetting = a(paramTroopInfo, bool2);
      if (localTroopMemberSetting == null) {
        bool1 = false;
      }
      if ((!bool2) || (localTroopMemberSetting == null)) {
        break label385;
      }
      if ((paramTroopInfo.wMemberNum <= localTroopMemberSetting.jdField_a_of_type_Int) || (paramTroopInfo.wMemberNum >= localTroopMemberSetting.b)) {
        break label307;
      }
      bool1 = true;
    }
    label385:
    for (;;)
    {
      label94:
      int n = 0;
      long l1 = FTSTroopOperator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopInfo.troopuin);
      bool2 = bool1;
      int m = n;
      if (bool1)
      {
        l1 = Math.abs(System.currentTimeMillis() - l1);
        if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
          break label313;
        }
        if (l1 >= localTroopMemberSetting.c * 3600000L) {
          break label382;
        }
        bool1 = false;
      }
      label163:
      label307:
      label313:
      label382:
      for (;;)
      {
        if ((bool1) && (l1 > localTroopMemberSetting.c * 3600000L * 2L) && (l1 > 3600000L * localTroopMemberSetting.d))
        {
          m = 1;
          bool2 = bool1;
        }
        for (;;)
        {
          bool1 = bool2;
          if (i1 == 2)
          {
            bool1 = bool2;
            if (bool2)
            {
              bool1 = bool2;
              if (m != 0) {}
            }
          }
          try
          {
            l1 = Long.valueOf(paramTroopInfo.troopuin).longValue();
            m = Calendar.getInstance().get(5);
            n = localTroopMemberSetting.c / 24;
            bool1 = bool2;
            if (n != 0)
            {
              long l2 = n;
              bool1 = bool2;
              if (l1 % l2 != m % n) {
                bool1 = false;
              }
            }
          }
          catch (Exception paramTroopInfo)
          {
            do
            {
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, except: %s", new Object[] { paramTroopInfo.getMessage() }));
            return bool2;
          }
          return bool1;
          bool2 = false;
          break;
          bool1 = false;
          break label94;
          if (l1 >= localTroopMemberSetting.d * 3600000L) {
            break label382;
          }
          bool1 = false;
          break label163;
          bool2 = bool1;
          m = n;
        }
      }
    }
  }
  
  private boolean a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = a(paramTroopInfo);; paramBoolean = true)
    {
      if ((paramBoolean) && ((!QLog.isColorLevel()) || ((paramTroopInfo.mMemberNumSeq != paramTroopInfo.mOldMemberNumSeq) || (paramTroopInfo.mMemberNumSeq == -1L) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq) || (paramTroopInfo.mMemberCardSeq == -1L))))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, get troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq) }));
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, ignore troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d, overtime: %s", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq), Boolean.valueOf(paramBoolean) }));
      }
      return false;
    }
  }
  
  @Deprecated
  private void e()
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).buildTroopUI();
  }
  
  private void f()
  {
    try
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(0);
      if (this.jdField_d_of_type_JavaUtilArrayList.size() > 0)
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_d_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_Int = 0;
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 4);
        return;
      }
    }
    finally {}
    try
    {
      this.jdField_d_of_type_JavaUtilArrayList = null;
      return;
    }
    finally {}
  }
  
  public double a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopMemberDistance", 2, "getTroopMemberDiatanceToSelf, uin is null");
      }
    }
    do
    {
      return -100.0D;
      paramString1 = b(paramString1, paramString2);
    } while (paramString1 == null);
    return paramString1.distanceToSelf;
  }
  
  @Deprecated
  public int a()
  {
    return ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).getUniqueTitleNewFlag();
  }
  
  public int a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("modify_troop_class_info_" + str + "_" + paramString, 0);
  }
  
  @Deprecated
  public long a(String paramString)
  {
    return ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).getOldestUniqueTitleExpireTime(paramString);
  }
  
  public MessageRemindRsp a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 4).getString(jdField_b_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(paramString))
    {
      MessageRemindRsp localMessageRemindRsp = new MessageRemindRsp();
      localMessageRemindRsp.readFrom(new JceInputStream(Utils.hexStr2Bytes(paramString)));
      return localMessageRemindRsp;
    }
    return null;
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    TroopManager.TroopMemberLevelValue localTroopMemberLevelValue = new TroopManager.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.jdField_a_of_type_Int = paramInt;
    localTroopMemberLevelValue.jdField_a_of_type_JavaLangString = paramString;
    return (Drawable)this.jdField_c_of_type_AndroidSupportV4UtilLruCache.get(localTroopMemberLevelValue);
  }
  
  public TroopManager.ConfigableWordingSetter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$ConfigableWordingSetter == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$ConfigableWordingSetter = new TroopManager.ConfigableWordingSetter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$ConfigableWordingSetter;
  }
  
  public TroopManager.MemberGagInfo a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1, paramString2);
    long l = 0L;
    if (paramString1 != null) {
      l = paramString1.gagTimeStamp;
    }
    return new TroopManager.MemberGagInfo(this, paramString2, l);
  }
  
  public HWTroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (HWTroopMemberCard)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
  }
  
  public MessageRecord a(String paramString1, String paramString2)
  {
    if (TroopMemberCardConstants.a != null)
    {
      int n = TroopMemberCardConstants.a.length;
      if (n > 0)
      {
        localObject = new StringBuilder();
        int m = 0;
        while (m < n)
        {
          ((StringBuilder)localObject).append(TroopMemberCardConstants.a[m]);
          if (m < n - 1) {
            ((StringBuilder)localObject).append(" , ");
          }
          m += 1;
        }
      }
    }
    for (Object localObject = ((StringBuilder)localObject).toString();; localObject = null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramString1 = localEntityManager.query(MessageRecord.class, MessageRecord.getTableName(paramString1, 1), false, String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", new Object[] { Long.valueOf(9223372036854775807L), localObject }), new String[] { paramString2 }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((paramString1 == null) || (paramString1.isEmpty())) {
        return null;
      }
      return (MessageRecord)paramString1.get(0);
    }
  }
  
  @Deprecated
  public CommonlyUsedTroop a(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroop(paramString);
  }
  
  @Deprecated
  public TroopInfo a(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfoInUI(paramString);
  }
  
  @Deprecated
  protected TroopInfo a(String paramString1, String paramString2)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).saveTroopName(paramString1, paramString2);
  }
  
  @Deprecated
  public TroopInfo a(String paramString, boolean paramBoolean)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString, paramBoolean);
  }
  
  @Deprecated
  public TroopInfo a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString, paramBoolean1, paramBoolean2);
  }
  
  public TroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (TroopMemberCard)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
  }
  
  @Deprecated
  public TroopMemberInfo a(String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInLruCache(paramString1, paramString2);
  }
  
  public EntityTransaction a()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getEntityTransaction();
  }
  
  public BatchAddFriendForTroopConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxBatchAddBatchAddFriendForTroopConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqRelationxBatchAddBatchAddFriendForTroopConfig = new BatchAddFriendForTroopConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRelationxBatchAddBatchAddFriendForTroopConfig;
  }
  
  @Deprecated
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    return ((ITroopMemberNameService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramTroopMemberInfo);
  }
  
  @Deprecated
  public String a(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopNameByID(paramString);
  }
  
  @Deprecated
  public String a(String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2);
  }
  
  @Deprecated
  public ArrayList<Entity> a()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getUiTroopListWithoutBlockedTroop();
  }
  
  public ArrayList<String> a(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopMemberForTroopHead(paramString);
  }
  
  @Deprecated
  public List<CommonlyUsedTroop> a()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopList();
  }
  
  public List<TroopNotificationCache> a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopNotificationCache.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, null, null, "time ASC", null);
    } while (paramString == null);
    HashMap localHashMap = new HashMap();
    int m = 0;
    if (m < paramString.size())
    {
      TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)paramString.get(m);
      if (localHashMap.containsKey(localTroopNotificationCache.feedsId)) {}
      for (;;)
      {
        m += 1;
        break;
        localArrayList.add(localTroopNotificationCache);
        localHashMap.put(localTroopNotificationCache.feedsId, Integer.valueOf(1));
      }
    }
    return localArrayList;
  }
  
  @Deprecated
  public oidb_cmd0xb36.ToastInfo a(String paramString)
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).getTroopSurveyList(paramString);
  }
  
  @Deprecated
  public void a()
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).initAndBuildTroopUI();
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).setUniqueTitleNewFlag(paramInt);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((Integer)((Iterator)localObject).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.contacttab.", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    String str = String.valueOf(paramLong1);
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(String.valueOf(paramLong1));
    localObject = localTroopInfo;
    if (localTroopInfo == null)
    {
      localObject = new TroopInfo();
      ((TroopInfo)localObject).troopuin = str;
    }
    if ((((TroopInfo)localObject).troopPrivilegeFlag & paramLong3) != (paramLong4 & paramLong3)) {
      if ((paramLong4 & paramLong3) != paramLong3) {
        break label221;
      }
    }
    label221:
    for (((TroopInfo)localObject).troopPrivilegeFlag &= paramLong3;; ((TroopInfo)localObject).troopPrivilegeFlag &= (0xFFFFFFFF ^ paramLong3))
    {
      localTroopManager.b((TroopInfo)localObject);
      a(str, paramLong2, paramInt, paramLong3, paramLong4, paramString);
      return;
    }
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable)
  {
    TroopManager.TroopMemberLevelValue localTroopMemberLevelValue = new TroopManager.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.jdField_a_of_type_Int = paramInt;
    localTroopMemberLevelValue.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache.put(localTroopMemberLevelValue, paramDrawable);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "markGroupSystemMsgProcessed troopCode:" + paramLong1 + " msgTime:" + paramLong2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      return;
    }
    l(String.format("%s_%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("batch_add_friend_for_troop_config".equals(paramString))) {
      a().a(paramCfgParseResult.jdField_a_of_type_JavaLangString);
    }
  }
  
  @Deprecated
  public void a(TroopInfo paramTroopInfo)
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).addTroop(paramTroopInfo);
  }
  
  public void a(TroopInfo paramTroopInfo, long paramLong)
  {
    if (paramTroopInfo == null) {}
    ProxyManager localProxyManager;
    RecentUser localRecentUser;
    do
    {
      return;
      localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
      localRecentUser = localProxyManager.a().a(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.getTroopDisplayName();
    } while (localRecentUser.getStatus() != 1000);
    localRecentUser.lastmsgtime = paramLong;
    HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
    localProxyManager.a().b(localRecentUser);
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(6003, true, new String[] { paramTroopInfo.troopuin, "0" });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      for (;;)
      {
        return;
        TroopNotificationHelper.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        TroopAssistantManager.a().b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 1);
        b(paramString, true);
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.al, true, paramString);
        ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).notifyQuitTroop(paramString);
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(Long.parseLong(paramString)))
          {
            BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, "tm->deleteTroop-->NumberFormatException, troopUin:" + paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramString = "modify_troop_class_info_" + str + "_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  @Deprecated
  public void a(String paramString, long paramLong)
  {
    ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).setOldestUniqueTitleExpireTime(paramString, paramLong);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "----------addTroopPrivilegeTipsMr troopUin: " + paramString1);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if ((1L & paramLong2) == 1L) {
        if ((1L & paramLong3) == 1L) {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697671);
        }
      }
    }
    for (;;)
    {
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-1013);
      localMessageForGrayTips.frienduin = paramString1;
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong1, -1013, 1, paramInt);
      localMessageForGrayTips.isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697672);
      continue;
      if ((0x2 & paramLong2) == 2L) {
        if ((0x2 & paramLong3) == 2L) {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697669);
        } else {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697670);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    String str = "";
    if (paramInt == 131081) {
      str = HardCodeUtil.a(2131715356);
    }
    long l;
    do
    {
      while (TextUtils.isEmpty(str))
      {
        return;
        if (paramInt == 131080) {
          str = HardCodeUtil.a(2131715373);
        }
      }
      Object localObject = new UniteGrayTipParam(paramString, paramString, str, 1, -5040, paramInt, paramLong1);
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject);
      localMessageForUniteGrayTip.isread = true;
      l = paramLong2;
      if (paramLong2 == 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 1);
        if (localObject != null) {
          paramLong2 = ((Message)localObject).shmsgseq;
        }
        l = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, String.format("addAIOGrayTips, shmsgseq: %s, msgseq: %s", new Object[] { Long.valueOf(((Message)localObject).shmsgseq), Long.valueOf(((Message)localObject).msgseq) }));
          l = paramLong2;
        }
      }
      localMessageForUniteGrayTip.shmsgseq = l;
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, String.format("addAIOGrayTips, troopUin: %s, msgTime: %s, wording: %s, msgSeq: %s", new Object[] { paramString, Long.valueOf(paramLong1), str, Long.valueOf(l) }));
  }
  
  public void a(String paramString, MessageRemindRsp paramMessageRemindRsp)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0);
    c(paramString, (int)paramMessageRemindRsp.iNextReqTime);
    localSharedPreferences.edit().putString(jdField_b_of_type_JavaLangString, Utils.bytes2HexStr(paramMessageRemindRsp.toByteArray())).commit();
  }
  
  @Deprecated
  public void a(String paramString, ITroopInfoCallback paramITroopInfoCallback)
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).asyncGetTroopInfo(paramString, paramITroopInfoCallback);
  }
  
  public void a(String paramString, ITroopInfoService.GetTroopCodeCallback paramGetTroopCodeCallback)
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUinAsync(paramString, paramGetTroopCodeCallback);
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putBoolean(i, paramBoolean.booleanValue()).commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1 + paramString2, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { "addGroupInviteStatus groupUin : " + paramString1, ", inviterUin:" + paramString2 });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("Q.contacttab.", 1, "handleMemberExitTroop, troopUin or memberUin is empty");
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, String.format("handleMemberExitTroop, troopUin: %s, memberUin: %s, type: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
      }
      if (((paramInt == 1) || (paramInt == 3)) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(paramString1, paramString2, false);
      }
      while (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramString1);
        return;
        a(paramString1, paramString2, true);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    ProxyManager localProxyManager;
    RecentUser localRecentUser;
    do
    {
      return;
      localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
      localRecentUser = localProxyManager.a().a(paramString1, 1);
      localRecentUser.displayName = paramString2;
    } while (localRecentUser.getStatus() != 1000);
    localRecentUser.lastmsgtime = paramLong;
    HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
    localProxyManager.a().b(localRecentUser);
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(6003, true, new String[] { paramString1, "0" });
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, TroopManager.ITroopMemberInfoCallBack paramITroopMemberInfoCallBack)
  {
    ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfo(paramString1, paramString2, paramITroopMemberInfoCallBack);
  }
  
  public void a(String paramString1, String paramString2, HWTroopMemberCard paramHWTroopMemberCard)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramHWTroopMemberCard != null))
    {
      paramString1 = paramString1 + "_" + paramString2;
      this.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramHWTroopMemberCard);
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberInfoInLruCache(paramString1, paramString2, paramTroopMemberInfo);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.post(new TroopManager.9(this, paramString1, paramString2, paramString3), 8, null, true);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).saveTroopMemberUniqueTitle(paramString1, paramString2, paramString3, paramInt);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).saveTroopMemberUniqueTitle(paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    int n = 1;
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "saveHomeworkTroopMemberIdentity , info is null ... ");
      }
    }
    for (;;)
    {
      return;
      TroopMemberCardInfo localTroopMemberCardInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      int m = 0;
      int i1 = 0;
      if (paramInt != -100)
      {
        m = i1;
        if (paramInt != localTroopMemberInfo.hwIdentity)
        {
          localTroopMemberInfo.hwIdentity = paramInt;
          m = 1;
        }
        if (paramInt != localTroopMemberInfo.level)
        {
          localTroopMemberInfo.level = paramInt;
          if ((localTroopMemberCardInfo != null) && (!TextUtils.equals(String.valueOf(paramInt), localTroopMemberCardInfo.level))) {
            localTroopMemberCardInfo.level = String.valueOf(paramInt);
          }
          m = 1;
        }
      }
      paramInt = m;
      if (!TextUtils.isEmpty(paramString4))
      {
        paramInt = m;
        if (!paramString4.equals(localTroopMemberInfo.hwCourse))
        {
          localTroopMemberInfo.hwCourse = paramString4;
          paramInt = 1;
        }
      }
      m = paramInt;
      if (!TextUtils.isEmpty(paramString5))
      {
        m = paramInt;
        if (!paramString5.equals(localTroopMemberInfo.hwName))
        {
          localTroopMemberInfo.hwName = paramString5;
          m = 1;
        }
      }
      if ((paramString3 != null) && (!paramString3.equals(localTroopMemberInfo.troopnick)))
      {
        localTroopMemberInfo.troopnick = paramString3;
        paramInt = n;
        if (localTroopMemberCardInfo != null)
        {
          paramInt = n;
          if (!TextUtils.equals(paramString3, localTroopMemberCardInfo.name)) {
            localTroopMemberCardInfo.name = paramString3;
          }
        }
      }
      for (paramInt = n; paramInt != 0; paramInt = m)
      {
        if (localTroopMemberInfo.getStatus() == 1000) {
          a(paramString1, paramString2, localTroopMemberInfo);
        }
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          paramString1.persistOrReplace(localTroopMemberInfo);
          if (localTroopMemberCardInfo != null) {
            paramString1.persistOrReplace(localTroopMemberCardInfo);
          }
        }
        for (;;)
        {
          paramString1.close();
          return;
          paramString1.update(localTroopMemberInfo);
          if (localTroopMemberCardInfo != null) {
            paramString1.update(localTroopMemberCardInfo);
          }
        }
      }
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).setUniqueTitleExpireNotified(paramString1, paramString2, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      if (!((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).deleteTroop(paramString, paramBoolean)) {
        continue;
      }
      try
      {
        ((MultiCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER)).a(Long.parseLong(paramString), null);
        if (!QLog.isDebugVersion()) {
          continue;
        }
        QLog.d("Q.contacttab.", 2, "deleteTroop", new Throwable("debug"));
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isDebugVersion()) {
            QLog.d("Q.contacttab.", 2, new Object[] { "deleteTroopRecommendUinList ", paramString.toString() });
          }
        }
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putString("troop_app_list_data", Base64Util.encodeToString(paramArrayOfByte, 2)).commit();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject1 = new troop_honor.HonorChangeGrayTipsReserved();
        ((troop_honor.HonorChangeGrayTipsReserved)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((troop_honor.HonorChangeGrayTipsReserved)localObject1).user_honor.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          Object localObject2 = (troop_honor.UserHonor)paramArrayOfByte.next();
          if ((((troop_honor.UserHonor)localObject2).uin.has()) && (((troop_honor.UserHonor)localObject2).level.has()))
          {
            localObject1 = String.valueOf(((troop_honor.UserHonor)localObject2).uin.get());
            int m = ((troop_honor.UserHonor)localObject2).level.get();
            localObject2 = new TroopManager.TmiCallBackForTroopMemberNewLevel(this, null);
            ((TroopManager.TmiCallBackForTroopMemberNewLevel)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((TroopManager.TmiCallBackForTroopMemberNewLevel)localObject2).jdField_b_of_type_JavaLangString = paramString;
            ((TroopManager.TmiCallBackForTroopMemberNewLevel)localObject2).jdField_a_of_type_Int = m;
            a(paramString, (String)localObject1, (TroopManager.ITroopMemberInfoCallBack)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("Q.contacttab.", 2, String.format("handleTroopMemberNewLevelChange, pushType: %s, troopUin: %s, memberUin: %s, newRealLevel: %s", new Object[] { Integer.valueOf(paramInt), paramString, localObject1, Integer.valueOf(m) }));
            }
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        QLog.d("Q.contacttab.", 1, "handleTroopMemberNewLevelChange", paramString);
      }
    }
  }
  
  @Deprecated
  public void a(ArrayList<String> paramArrayList)
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).preloadData(paramArrayList);
  }
  
  public void a(Map<String, Long> paramMap)
  {
    ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).prePareShowExternalTroop(paramMap);
  }
  
  @Deprecated
  public void a(oidb_cmd0xb36.RspBody paramRspBody)
  {
    ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).updateTroopSurveyList(paramRspBody);
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    if (paramStructMsg == null) {
      QLog.e("Q.contacttab.", 1, "handlePassiveExitTroop groupMsg == null");
    }
    String str;
    int n;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
        str = String.valueOf(paramStructMsg.msg.group_code.get());
        n = paramStructMsg.msg.group_msg_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, String.format("handlePassiveExitTroop, troopUin: %s, msgType: %s", new Object[] { str, Integer.valueOf(n) }));
        }
      } while (TextUtils.isEmpty(str));
      localTroopInfo = a(str, true);
      if (localTroopInfo == null)
      {
        QLog.e("Q.contacttab.", 1, "handlePassiveExitTroop, troopInfo == null");
        return;
      }
      if (!localTroopInfo.isExited()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, "handlePassiveExitTroop, exitReason is no default ");
    return;
    long l1 = localTroopInfo.dwCmdUinJoinTime;
    long l2 = paramStructMsg.msg_time.get();
    int m;
    if (l1 < l2)
    {
      m = -1;
      a(str);
      DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      TroopNotificationHelper.a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      e();
      ((MultiCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER)).a(paramStructMsg.msg.group_code.get(), null);
      if (n != 8) {
        break label418;
      }
      localTroopInfo.exitTroopReason = 2;
      b(localTroopInfo);
      a(str, paramStructMsg.msg_time.get(), 0L, 131081);
      m = 2;
    }
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(Long.parseLong(str));
        if (bool) {
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "handlePassiveExitTroop, hasTroopVideo: " + bool);
        }
      }
      catch (Exception paramStructMsg)
      {
        label418:
        QLog.e("Q.contacttab.", 2, "handlePassiveExitTroop, excption:" + paramStructMsg.getMessage());
        continue;
      }
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.bw, true, new Object[] { str, Integer.valueOf(m) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.contacttab.", 2, String.format("handlePassiveExit push joinTime: %s, msgTime: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
      return;
      if (n == 7)
      {
        localTroopInfo.exitTroopReason = 1;
        b(localTroopInfo);
        a(str, paramStructMsg.msg_time.get(), 0L, 131080);
        m = 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).setTroopConfessPanelOpen(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public boolean a()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).hasNoTroop();
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "hasGroupSystemMsgProcessed troopCode:" + paramLong1 + " msgTime:" + paramLong2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      return false;
    }
    return l(String.format("%s_%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  @Deprecated
  public boolean a(Entity paramEntity)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).updateEntity(paramEntity);
  }
  
  @Deprecated
  public boolean a(String paramString)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).deleteTroopMembers(paramString);
  }
  
  @Deprecated
  public boolean a(String paramString, long paramLong)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).addCommonlyUsedTroop(paramString, paramLong);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).isMemberInCache(paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, byte paramByte)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null) {}
    label123:
    for (;;)
    {
      return false;
      if (paramByte != -100)
      {
        localTroopMemberInfo.isTroopFollowed = false;
        localTroopMemberInfo.mIsShielded = false;
        if (paramByte == 1) {
          localTroopMemberInfo.isTroopFollowed = true;
        }
      }
      for (paramByte = 1;; paramByte = 0)
      {
        if (paramByte == 0) {
          break label123;
        }
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          a(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.persistOrReplace(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.close();
          return true;
          if (paramByte != 2) {
            break;
          }
          localTroopMemberInfo.mIsShielded = true;
          break;
          localEntityManager.update(localTroopMemberInfo);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.troopuin = paramString1;
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.isTroopFollowed = false;
    }
    for (int n = 1;; n = 0)
    {
      int m = n;
      if (paramInt1 >= 0)
      {
        m = n;
        if (paramInt1 != localTroopMemberInfo.hotChatGlamourLevel)
        {
          localTroopMemberInfo.hotChatGlamourLevel = paramInt1;
          m = 1;
        }
      }
      paramInt1 = m;
      if (paramInt2 >= 0)
      {
        paramInt1 = m;
        if (paramInt2 != localTroopMemberInfo.globalTroopLevel)
        {
          localTroopMemberInfo.globalTroopLevel = paramInt2;
          paramInt1 = 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberHotChatGlamourLevel ," + localTroopMemberInfo.toString());
      }
      if (paramInt1 != 0)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          a(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.persistOrReplace(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.close();
          ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).notifyChangeMember(paramString1, paramString2);
          return true;
          localEntityManager.update(localTroopMemberInfo);
        }
      }
      return false;
    }
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, paramString6, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMember(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramInt5);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).deleteTroopMember(paramString1, paramString2, paramBoolean);
  }
  
  @Deprecated
  public boolean a(List<TroopMemberInfo> paramList)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMembers(paramList);
  }
  
  public byte[] a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getString("troop_app_list_data", null);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public int b()
  {
    try
    {
      int m = this.jdField_a_of_type_JavaUtilHashMap.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, "hasGroupInviting  : " + m);
      }
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("upgrade_troop_notify_" + str + "_" + paramString, 0);
  }
  
  public long b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getLong("line_" + str + "_" + paramString, -1L);
  }
  
  @Deprecated
  public TroopInfo b(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
  }
  
  @Deprecated
  public TroopMemberInfo b(String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
  }
  
  @Deprecated
  public String b(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(paramString);
  }
  
  @Deprecated
  public String b(String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2, false, true);
  }
  
  @Deprecated
  public ArrayList<Entity> b()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
  }
  
  /* Error */
  public ArrayList<TroopManager.MemberGagInfo> b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 91	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 94	java/util/ArrayList:<init>	()V
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 170	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: invokevirtual 1751	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   19: astore 5
    //   21: aload 5
    //   23: astore 4
    //   25: aload 4
    //   27: ifnull +139 -> 166
    //   30: aload 4
    //   32: invokevirtual 1756	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   35: invokestatic 1761	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   38: lstore_2
    //   39: aload_0
    //   40: getfield 170	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: ldc_w 932
    //   46: iconst_0
    //   47: ldc_w 1763
    //   50: iconst_1
    //   51: anewarray 327	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 1079	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +99 -> 166
    //   70: aload_1
    //   71: invokeinterface 1538 1 0
    //   76: astore_1
    //   77: aload_1
    //   78: invokeinterface 297 1 0
    //   83: ifeq +83 -> 166
    //   86: aload_1
    //   87: invokeinterface 301 1 0
    //   92: checkcast 932	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   95: astore 5
    //   97: aload 5
    //   99: invokestatic 1768	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;)Z
    //   102: ifeq -25 -> 77
    //   105: aload 5
    //   107: getfield 971	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   110: lconst_0
    //   111: lcmp
    //   112: ifeq -35 -> 77
    //   115: aload 5
    //   117: getfield 971	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   120: lload_2
    //   121: lcmp
    //   122: ifle -45 -> 77
    //   125: aload 6
    //   127: new 973	com/tencent/mobileqq/app/TroopManager$MemberGagInfo
    //   130: dup
    //   131: aload_0
    //   132: aload 5
    //   134: getfield 1683	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   137: aload 5
    //   139: getfield 971	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   142: invokespecial 976	com/tencent/mobileqq/app/TroopManager$MemberGagInfo:<init>	(Lcom/tencent/mobileqq/app/TroopManager;Ljava/lang/String;J)V
    //   145: invokevirtual 337	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: goto -72 -> 77
    //   152: astore_1
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 1771	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   163: aload 6
    //   165: areturn
    //   166: aload 4
    //   168: ifnull -5 -> 163
    //   171: aload 4
    //   173: invokevirtual 1771	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   176: aload 6
    //   178: areturn
    //   179: astore_1
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 1771	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: goto -13 -> 183
    //   199: astore_1
    //   200: goto -47 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	TroopManager
    //   0	203	1	paramString	String
    //   38	83	2	l	long
    //   1	188	4	localObject1	Object
    //   19	119	5	localObject2	Object
    //   10	167	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   30	66	152	java/lang/Throwable
    //   70	77	152	java/lang/Throwable
    //   77	149	152	java/lang/Throwable
    //   12	21	179	finally
    //   30	66	195	finally
    //   70	77	195	finally
    //   77	149	195	finally
    //   12	21	199	java/lang/Throwable
  }
  
  @Deprecated
  public List<ShowExternalTroop> b()
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).getShowExternalTroopList();
  }
  
  @Deprecated
  public List<TroopMemberInfo> b(String paramString)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getAllTroopMembers(paramString);
  }
  
  public void b()
  {
    ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).refreshShowExternalTroop();
  }
  
  @Deprecated
  public void b(TroopInfo paramTroopInfo)
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(paramTroopInfo);
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramString = "upgrade_troop_notify_" + str + "_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramString = "line_" + str + "_" + paramString;
    if (paramLong < 0L)
    {
      localSharedPreferences.edit().remove(paramString);
      return;
    }
    localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1 + paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, "removeGroupInviteStatus groupUin : " + paramString1);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void b(String paramString1, String paramString2, long paramLong)
  {
    Object localObject2 = b(paramString1, paramString2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TroopMemberInfo();
      ((TroopMemberInfo)localObject1).memberuin = paramString2;
      ((TroopMemberInfo)localObject1).troopuin = paramString1;
    }
    ((TroopMemberInfo)localObject1).cmduinFlagEx3Grocery = paramLong;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (((TroopMemberInfo)localObject1).getStatus() == 1000)
    {
      a(paramString1, paramString2, (TroopMemberInfo)localObject1);
      ((EntityManager)localObject2).persistOrReplace((Entity)localObject1);
    }
    for (;;)
    {
      ((EntityManager)localObject2).close();
      return;
      ((EntityManager)localObject2).update((Entity)localObject1);
    }
  }
  
  @Deprecated
  public void b(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberInfoToDB(paramString1, paramString2, paramTroopMemberInfo);
  }
  
  @Deprecated
  public void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).saveTroopMemeberUniqueTitleAndExpire(paramString1, paramString2, paramString3, paramInt);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    ThreadManager.post(new TroopManager.6(this, paramString1, paramString2, paramString3, paramInt, paramString4, paramString5), 8, null, false);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    if (paramBoolean)
    {
      ThreadManager.post(new TroopManager.8(this, paramString), 8, null, true);
      return;
    }
    b(paramString, -1L);
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).setTroopAIOOpen(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public boolean b()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).isTroopCacheInited();
  }
  
  @Deprecated
  public boolean b(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).isCommonlyUsedTroop(paramString);
  }
  
  public boolean b(String paramString, long paramLong)
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).addShowExternalTroop(paramString, paramLong);
  }
  
  @Deprecated
  public boolean b(String paramString1, String paramString2)
  {
    return ((IUniqueTitleService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).hasUniqueTitleExpireNotified(paramString1, paramString2);
  }
  
  public int c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(jdField_c_of_type_JavaLangString, 0);
  }
  
  @Deprecated
  public TroopInfo c(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
  
  @Deprecated
  public TroopMemberInfo c(String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoFromDb(paramString1, paramString2);
  }
  
  public String c(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopUinByTroopCode(paramString);
  }
  
  public String c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.troop", 2, "getTroopMemberNick uin is null");
      }
      localObject = "";
      return localObject;
    }
    String str = "";
    Object localObject = b(paramString1, paramString2);
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((TroopMemberInfo)localObject).troopnick)) {
        break label115;
      }
      str = ((TroopMemberInfo)localObject).troopnick;
    }
    for (;;)
    {
      localObject = str;
      if (str == null) {
        break;
      }
      localObject = str;
      if (!str.equals(paramString2)) {
        break;
      }
      paramString1 = b(paramString1);
      localObject = str;
      if (paramString1 == null) {
        break;
      }
      localObject = str;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      label115:
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject).friendnick)) {
        str = ((TroopMemberInfo)localObject).friendnick;
      } else {
        str = paramString2;
      }
    }
  }
  
  @Deprecated
  public List<Long> c()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getUinList();
  }
  
  public void c()
  {
    if (this.jdField_d_of_type_JavaUtilArrayList != null) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), last getTroopsMemberList(int memberLimit) is not finished.");
      }
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = b();
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), troopList is null");
    return;
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    int i1;
    int m;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      i1 = 0;
      m = 0;
    }
    int i3;
    for (int n = 0;; n = i3)
    {
      int i2;
      if (i1 < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(i1);
        i2 = m;
        i3 = n;
        if (a(localTroopInfo, false)) {
          try
          {
            this.jdField_d_of_type_JavaUtilArrayList.add(localTroopInfo);
            i3 = n + 1;
            i2 = m + localTroopInfo.wMemberNum;
          }
          finally {}
        }
      }
      else
      {
        if (this.jdField_d_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject2 = (TroopInfo)this.jdField_d_of_type_JavaUtilArrayList.get(0);
          localObject1.a(true, ((TroopInfo)localObject2).troopuin, ((TroopInfo)localObject2).troopcode, 4);
        }
        while (n > 0)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("reqUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          localHashMap.put("tpNum", String.valueOf(n));
          localHashMap.put("tpMemNum", String.valueOf(m));
          localHashMap.put("isFirst", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0)));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "tMSearchUpdateReq", false, 0L, 0L, localHashMap, "");
          return;
          this.jdField_d_of_type_JavaUtilArrayList = null;
          continue;
          this.jdField_d_of_type_JavaUtilArrayList = null;
          m = 0;
          n = 0;
        }
        break;
      }
      i1 += 1;
      m = i2;
    }
  }
  
  @Deprecated
  public void c(TroopInfo paramTroopInfo)
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfoOnlyCacheAndDB(paramTroopInfo);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("update TroopNotificationCache set read=1 where troopUin=" + paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(jdField_a_of_type_JavaLangString, paramInt).commit();
  }
  
  public void c(String paramString1, String paramString2, long paramLong)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "saveAndUpdateTroopMemberGagStatus , info is null ... ");
      }
      return;
    }
    if ((paramLong != -100L) && (paramLong != localTroopMemberInfo.gagTimeStamp)) {
      localTroopMemberInfo.gagTimeStamp = paramLong;
    }
    if (localTroopMemberInfo.getStatus() == 1000) {
      a(paramString1, paramString2, localTroopMemberInfo);
    }
    ThreadManager.post(new TroopManager.7(this, localTroopMemberInfo, paramString1), 8, null, false);
  }
  
  public void c(boolean paramBoolean)
  {
    ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).setShowTroopBigClub(paramBoolean);
  }
  
  public boolean c()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getBoolean("show_new_create_big_troop2_" + str, false);
  }
  
  @Deprecated
  public boolean c(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).removeCommonlyUsedTroop(paramString);
  }
  
  @Deprecated
  public boolean c(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, true);
  }
  
  public int d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(jdField_d_of_type_JavaLangString, 0);
  }
  
  @Deprecated
  public TroopInfo d(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfoFromCache(paramString);
  }
  
  public String d(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(paramString);
  }
  
  public void d()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    str = "show_new_create_big_troop2_" + str;
    localSharedPreferences.edit().putBoolean(str, true).commit();
  }
  
  void d(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    i(paramTroopInfo.troopuin);
    b(paramTroopInfo);
    e();
  }
  
  public void d(String paramString)
  {
    try
    {
      ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).setCurrentOpenTroop(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(jdField_c_of_type_JavaLangString, paramInt).commit();
  }
  
  public boolean d()
  {
    try
    {
      boolean bool = ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).isTroopConfessPanelOpen();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public boolean d(String paramString)
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).isShowExternalTroop(paramString);
  }
  
  public boolean d(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1 + paramString2);
      if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { "isTheSameInviterInviting re:" + bool + ", troopUin : " + paramString1, ", inviterUin:" + paramString2 });
      }
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int e(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(e, 0);
  }
  
  public void e(TroopInfo paramTroopInfo)
  {
    a(paramTroopInfo, NetConnInfoCenter.getServerTime());
  }
  
  public void e(String paramString)
  {
    ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).onTroopReceiveOrSendMsg(paramString);
  }
  
  public void e(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(jdField_d_of_type_JavaLangString, paramInt).commit();
  }
  
  public boolean e()
  {
    try
    {
      boolean bool = ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).isTroopAIOOpen();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e(String paramString)
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).removeShowExternalTroop(paramString);
  }
  
  public int f(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(f, 0);
  }
  
  /* Error */
  public void f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +19 -> 25
    //   9: aload_0
    //   10: getfield 135	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 1948	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 135	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   29: aload_1
    //   30: invokevirtual 337	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: goto -12 -> 22
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TroopManager
    //   0	42	1	paramString	String
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	37	finally
    //   25	34	37	finally
  }
  
  public void f(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(e, paramInt).commit();
  }
  
  public boolean f()
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).isShowTroopBigClub();
  }
  
  public boolean f(String paramString)
  {
    try
    {
      boolean bool = ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).isCurrentOpenTroop(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int g(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(g, 0);
  }
  
  /* Error */
  public void g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 135	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 1956	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: goto -12 -> 11
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	TroopManager
    //   0	31	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public void g(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(f, paramInt).commit();
  }
  
  /* Error */
  public boolean g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 135	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 1948	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +9 -> 28
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	TroopManager
    //   0	38	1	paramString	String
    //   17	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	33	finally
  }
  
  public int h(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(h, 0);
  }
  
  public void h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("Q.contacttab.", 1, "addPassiveExitGrayTips, troopUin is empty");
    }
    paramString = a(paramString, true);
    if (paramString == null)
    {
      QLog.e("Q.contacttab.", 1, "addPassiveExitGrayTips, troopInfo == null");
      return;
    }
    switch (paramString.exitTroopReason)
    {
    default: 
      return;
    case 1: 
      a(paramString.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131080);
      return;
    }
    a(paramString.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131081);
  }
  
  public void h(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(g, paramInt).commit();
  }
  
  public boolean h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("Q.contacttab.", 1, "isPassiveExit, troopUin is empty");
    }
    do
    {
      return false;
      paramString = a(paramString, true);
    } while ((paramString == null) || ((!paramString.isKicked()) && (!paramString.isDisband())));
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, String.format("isPassiveExit reason: %s", new Object[] { Integer.valueOf(paramString.exitTroopReason) }));
    }
    return true;
  }
  
  public int i(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(j, 0);
  }
  
  public void i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d("Q.contacttab.", 1, "clearPassiveExitTroopInfo, troopUin is empty!");
    }
    do
    {
      do
      {
        return;
      } while (!((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).clearPassiveExitTroopInfo(paramString));
      TroopAssistantManager.a().b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 1);
      b(paramString, true);
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, new Throwable("clearPassiveExitTroopInfo.debug"), new Object[0]);
  }
  
  public void i(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(h, paramInt).commit();
  }
  
  public boolean i(String paramString)
  {
    if (!QVIPPrettyTroopProcessor.c().a)
    {
      TroopInfo localTroopInfo = b(paramString);
      if ((localTroopInfo != null) && (localTroopInfo.checkFlagExt4(3))) {
        if (QLog.isColorLevel()) {
          QLog.d("vip_pretty.Q.contacttab.", 1, "troop " + paramString + " is pretty so req group care");
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(jdField_a_of_type_JavaLangString, 0) < System.currentTimeMillis() / 1000L) {
      return true;
    }
    return false;
  }
  
  public int j(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(k, 0);
  }
  
  public void j(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0);
    if ((paramString.contains(jdField_c_of_type_JavaLangString)) || (paramString.contains(g))) {
      paramString.edit().remove(jdField_c_of_type_JavaLangString).remove(e).remove(f).remove(g).remove(i).remove(j).remove(k).commit();
    }
  }
  
  public void j(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(j, paramInt).commit();
  }
  
  public boolean j(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getBoolean(i, true);
  }
  
  public int k(String paramString)
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).getAssociatedTroopCount(paramString);
  }
  
  public void k(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "markHasHandleGroupInviteAccept key:" + paramString);
    }
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new ArraySet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putStringSet("group_invite_accept_handle_set", this.jdField_a_of_type_JavaUtilSet).apply();
  }
  
  public void k(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(k, paramInt).commit();
  }
  
  public boolean k(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new ArraySet();
      Set localSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getStringSet("group_invite_accept_handle_set", null);
      if (localSet != null) {
        this.jdField_a_of_type_JavaUtilSet.addAll(localSet);
      }
    }
    boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "hasHandleGroupInviteAccept key:" + paramString + " res:" + bool);
    }
    return bool;
  }
  
  public void l(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "markGroupSystemMsgProcessed key:" + paramString);
    }
    if (this.jdField_b_of_type_JavaUtilSet == null) {
      this.jdField_b_of_type_JavaUtilSet = new ArraySet();
    }
    this.jdField_b_of_type_JavaUtilSet.add(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_group_sysmsg", 0).edit().putStringSet("processed_cache", this.jdField_b_of_type_JavaUtilSet).apply();
  }
  
  public void l(String paramString, int paramInt)
  {
    ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).setAssociatedTroopCount(paramString, paramInt);
  }
  
  public boolean l(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new ArraySet();
      Set localSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_group_sysmsg", 0).getStringSet("processed_cache", null);
      if (localSet != null) {
        this.jdField_b_of_type_JavaUtilSet.addAll(localSet);
      }
    }
    boolean bool = this.jdField_b_of_type_JavaUtilSet.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "hasGroupSystemMsgProcessed key:" + paramString + " res:" + bool);
    }
    return bool;
  }
  
  public void m(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "handleTroopFlagExt4Changed troopUin = " + paramString + ", newTroopFlagExt4 = " + paramInt);
    }
    Object localObject = b(paramString);
    if (localObject == null) {
      return;
    }
    int m = ((TroopInfo)localObject).groupFlagExt4;
    ((TroopInfo)localObject).groupFlagExt4 = paramInt;
    b((TroopInfo)localObject);
    localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localObject != null) {
      ((TroopHandler)localObject).notifyUI(TroopNotificationConstants.bY, true, new Object[] { paramString, Integer.valueOf(m) });
    }
    a(paramString, paramInt, m);
  }
  
  public final boolean m(String paramString)
  {
    return b(paramString) != null;
  }
  
  public boolean n(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(paramString);
  }
  
  public boolean o(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).isHomeworkTroop(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
  
  public boolean p(String paramString)
  {
    return ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).isFansTroop(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager
 * JD-Core Version:    0.7.0.1
 */