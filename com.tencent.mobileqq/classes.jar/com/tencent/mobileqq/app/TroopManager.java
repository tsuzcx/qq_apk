package com.tencent.mobileqq.app;

import GROUP.MessageRemindRsp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.util.ArraySet;
import android.text.SpannableString;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.av.gaudio.AVNotifyCenter;
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
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.config.CfgProcess.OnGetConfigListener;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.ITroopInfoCallback;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multicard.MultiCardManager;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.config.SearchConfig.TroopMemberSetting;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService.GetTroopCodeCallback;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;
import tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor.UserHonor;

public class TroopManager
  implements CfgProcess.OnGetConfigListener, Manager
{
  public static String g = "next_get_expire_time";
  public static String h = "big_troop_expired_info";
  public static String i = "troop_expired_notify_tips_count";
  public static String j = "troop_expired_notify_tips_last_time";
  public static String k = "troop_expired_notify_tips_one_day_count";
  public static String l = "troop_expired_notify_tips_close_count";
  public static String m = "troop_expired_notify_count";
  public static String n = "troop_expired_notify_dialog_last_time";
  public static String o = "troop_expired_notify_dialog_is_show";
  public static String p = "troop_expired_notify_dialog_one_day_count";
  public static String q = "troop_expired_notify_dialog_last_day";
  public static ArrayList<String> t = new ArrayList();
  public static ArrayList<String> u = new ArrayList();
  protected QQAppInterface a;
  protected EntityManager b;
  public TroopConfigForAllUser c;
  Queue<Integer> d = new LinkedList();
  protected ArrayList<String> e = new ArrayList();
  HashMap<String, String> f = new HashMap();
  protected Set<String> r = null;
  protected Set<String> s = null;
  private TroopObserver v = new TroopManager.7(this);
  private TroopManagerBizObserver w = new TroopManager.8(this);
  private BatchAddFriendForTroopConfig x = null;
  private TroopManager.ConfigableWordingSetter y = null;
  
  @Deprecated
  public TroopManager() {}
  
  public TroopManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.addObserver(this.w, true);
    paramQQAppInterface.addObserver(this.v, true);
    QRoute.api(ITroopLinkApi.class);
    this.c = new TroopConfigForAllUser(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getConfigProcess().a("batch_add_friend_for_troop_config", this);
  }
  
  protected static int a(TroopManager.ExpiredType paramExpiredType, MessageRemindRsp paramMessageRemindRsp)
  {
    int i1 = TroopManager.9.a[paramExpiredType.ordinal()];
    if (i1 != 2) {
      if (i1 == 3) {}
    }
    for (long l1 = paramMessageRemindRsp.iSVIPExpiredTime;; l1 = paramMessageRemindRsp.iGroupExpiredTime)
    {
      return (int)l1;
      return paramMessageRemindRsp.iLhGroupExpiredTime;
    }
  }
  
  public static long a(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_check_stamp");
    localStringBuilder.append(paramAppRuntime.getAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static MessageRemindRsp a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(h, "");
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
  
  public static void a(MessageRemindRsp paramMessageRemindRsp, QQAppInterface paramQQAppInterface, String paramString, Context paramContext, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager)
  {
    if (paramMessageRemindRsp == null) {
      return;
    }
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig = QVipBigTroopExpiredProcessor.e();
    if (!localQVipBigTroopExpiredConfig.mIsEnable) {
      return;
    }
    int i1 = (int)(System.currentTimeMillis() / 1000L);
    TroopManager.ExpiredType localExpiredType = a(paramMessageRemindRsp);
    if (paramMessageRemindRsp.isFreezed)
    {
      a(paramQQAppInterface, paramString, i1, localQVipBigTroopExpiredConfig, paramMessageRemindRsp, paramContext, localExpiredType, paramTroopChatPie, paramTipsManager);
      return;
    }
    if (paramMessageRemindRsp.eRemindLevel >= 3)
    {
      if (TroopManager.LiangGroupHelper.a(paramMessageRemindRsp.iGroupType)) {
        return;
      }
      int i2 = a(localExpiredType, paramMessageRemindRsp);
      if (VipUtils.b(i1, i2) > localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay)
      {
        ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).I(paramString);
        return;
      }
      a(paramQQAppInterface, paramString, i1, localQVipBigTroopExpiredConfig, i2, paramMessageRemindRsp, paramContext, localExpiredType, paramTroopChatPie, paramTipsManager);
    }
  }
  
  private static void a(Context paramContext, TroopManager paramTroopManager, String paramString, MessageRemindRsp paramMessageRemindRsp, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, int paramInt3, TroopManager.ExpiredType paramExpiredType)
  {
    int i1 = TroopManager.9.a[paramExpiredType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      i1 = VipUtils.b(paramInt1, (int)paramMessageRemindRsp.iGroupExpiredTime);
      if (((i1 <= paramQVipBigTroopExpiredConfig.mNotifyDialogMaxDay) && (i1 >= paramQVipBigTroopExpiredConfig.mNotifyDialogMinDay)) || (i1 == 0))
      {
        VipUtils.a(paramContext, paramString, VipUtils.c((int)paramMessageRemindRsp.iGroupExpiredTime, 4).toString(), HardCodeUtil.a(2131898212), new TroopManager.5(), "0X8009E36", 1);
        paramTroopManager.h(paramString, paramInt2 + 1);
        paramTroopManager.i(paramString, paramInt1);
        paramTroopManager.j(paramString, paramInt3 + 1);
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
      }
    }
    else
    {
      i1 = VipUtils.b(paramInt1, (int)paramMessageRemindRsp.iSVIPExpiredTime);
      if (((i1 <= paramQVipBigTroopExpiredConfig.mNotifyDialogMaxDay) && (i1 >= paramQVipBigTroopExpiredConfig.mNotifyDialogMinDay)) || (i1 == 0))
      {
        VipUtils.a(paramContext, paramString, VipUtils.c((int)paramMessageRemindRsp.iSVIPExpiredTime, 5).toString(), HardCodeUtil.a(2131898212), new TroopManager.4(), "0X8009E36", 1);
        paramTroopManager.h(paramString, paramInt2 + 1);
        paramTroopManager.i(paramString, paramInt1);
        paramTroopManager.j(paramString, paramInt3 + 1);
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    t.clear();
    u.clear();
    a(paramQQAppInterface, t, u);
    if (t.isEmpty()) {
      t.addAll(Arrays.asList(new String[] { HardCodeUtil.a(2131912796), HardCodeUtil.a(2131912783), HardCodeUtil.a(2131912779), HardCodeUtil.a(2131912790), HardCodeUtil.a(2131912764), HardCodeUtil.a(2131912770), HardCodeUtil.a(2131912787) }));
    }
    if (u.isEmpty()) {
      u.addAll(Arrays.asList(new String[] { HardCodeUtil.a(2131912798), HardCodeUtil.a(2131912773), HardCodeUtil.a(2131912797), HardCodeUtil.a(2131912784), HardCodeUtil.a(2131912799), HardCodeUtil.a(2131912789), HardCodeUtil.a(2131912755), HardCodeUtil.a(2131912751), HardCodeUtil.a(2131912768) }));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager, Context paramContext, TroopManager paramTroopManager, String paramString, MessageRemindRsp paramMessageRemindRsp, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, int paramInt3, TroopManager.ExpiredType paramExpiredType)
  {
    int i1 = TroopManager.9.a[paramExpiredType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return;
        }
        i1 = VipUtils.b(paramInt1, paramMessageRemindRsp.iLhGroupExpiredTime);
        if ((i1 <= paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) && (i1 >= paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay))
        {
          if (paramTroopChatPie.bB == null)
          {
            paramTroopChatPie.bB = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
            paramTipsManager.b(paramTroopChatPie.bB);
          }
          paramTroopChatPie.bB.a(paramString, VipUtils.c(paramMessageRemindRsp.iLhGroupExpiredTime, 10), 0, 3);
          paramTipsManager.a(paramTroopChatPie.bB, new Object[0]);
          paramTroopManager.d(paramString, paramInt2 + 1);
          paramTroopManager.e(paramString, paramInt1);
          paramTroopManager.f(paramString, paramInt3 + 1);
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A579", 0, 0, "", "", "", "");
        }
      }
      else
      {
        i1 = VipUtils.b(paramInt1, (int)paramMessageRemindRsp.iGroupExpiredTime);
        if ((i1 <= paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) && (i1 >= paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay))
        {
          if (paramTroopChatPie.bB == null)
          {
            paramTroopChatPie.bB = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
            paramTipsManager.b(paramTroopChatPie.bB);
          }
          paramTroopChatPie.bB.a(paramString, VipUtils.c((int)paramMessageRemindRsp.iGroupExpiredTime, 0), 0, 1);
          paramTipsManager.a(paramTroopChatPie.bB, new Object[0]);
          paramTroopManager.d(paramString, paramInt2 + 1);
          paramTroopManager.e(paramString, paramInt1);
          paramTroopManager.f(paramString, paramInt3 + 1);
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 1, 0, "", "", "", "");
        }
      }
    }
    else
    {
      i1 = VipUtils.b(paramInt1, (int)paramMessageRemindRsp.iSVIPExpiredTime);
      if ((i1 <= paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) && (i1 >= paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay))
      {
        if (paramTroopChatPie.bB == null)
        {
          paramTroopChatPie.bB = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
          paramTipsManager.b(paramTroopChatPie.bB);
        }
        paramTroopChatPie.bB.a(paramString, VipUtils.c((int)paramMessageRemindRsp.iSVIPExpiredTime, 1), 0, 2);
        paramTipsManager.a(paramTroopChatPie.bB, new Object[0]);
        paramTroopManager.d(paramString, paramInt2 + 1);
        paramTroopManager.e(paramString, paramInt1);
        paramTroopManager.f(paramString, paramInt3 + 1);
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 2, 0, "", "", "", "");
      }
    }
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, MessageRemindRsp paramMessageRemindRsp, Context paramContext, TroopManager.ExpiredType paramExpiredType, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    int i1 = localTroopManager.K(paramString);
    if (i1 < paramQVipBigTroopExpiredConfig.mNotifyTipsMaxCount) {
      if (!VipUtils.a(localTroopManager.L(paramString), paramInt1))
      {
        a(paramQQAppInterface, paramTroopChatPie, paramTipsManager, paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, i1, 0, paramExpiredType);
      }
      else
      {
        i2 = localTroopManager.M(paramString);
        if (i2 < paramQVipBigTroopExpiredConfig.mNotifyTipsPerDay) {
          a(paramQQAppInterface, paramTroopChatPie, paramTipsManager, paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, i1, i2, paramExpiredType);
        }
      }
    }
    i1 = localTroopManager.O(paramString);
    int i2 = localTroopManager.P(paramString);
    if ((VipUtils.a(paramInt1, paramInt2)) && (!VipUtils.a(i2, paramInt1)))
    {
      a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, i1, 0, paramExpiredType);
      return;
    }
    if (i1 < paramQVipBigTroopExpiredConfig.mNotifyDialogMaxCount)
    {
      if (!VipUtils.a(i2, paramInt1))
      {
        a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, i1, 0, paramExpiredType);
        return;
      }
      paramInt2 = localTroopManager.R(paramString);
      if (paramInt2 < paramQVipBigTroopExpiredConfig.mNotifyDialogPerDay) {
        a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, i1, paramInt2, paramExpiredType);
      }
    }
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, MessageRemindRsp paramMessageRemindRsp, Context paramContext, TroopManager.ExpiredType paramExpiredType, TroopChatPie paramTroopChatPie, TipsManager paramTipsManager)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((!VipUtils.a(localTroopManager.L(paramString), paramInt)) && (localTroopManager.N(paramString) < paramQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount))
    {
      if (paramTroopChatPie.bB == null)
      {
        paramTroopChatPie.bB = new BigTroopExpiredTipsBar(paramQQAppInterface, paramContext, paramTipsManager);
        paramTipsManager.b(paramTroopChatPie.bB);
      }
      a(paramExpiredType, paramQQAppInterface, paramString, paramTroopChatPie, paramMessageRemindRsp, paramTipsManager);
      localTroopManager.e(paramString, paramInt);
    }
    if ((localTroopManager.Q(paramString)) && (VipUtils.b(localTroopManager.S(paramString), paramInt) >= paramQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay))
    {
      a(paramExpiredType, paramQQAppInterface, paramContext, paramString, paramMessageRemindRsp);
      localTroopManager.k(paramString, paramInt);
    }
  }
  
  @Deprecated
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    ((IUniqueTitleService)paramQQAppInterface.getRuntimeService(IUniqueTitleService.class, "")).getTroopMemberUniqueTitle(paramString, paramLong1, paramLong2, paramTroopProtocolObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray1 != null)
    {
      if (paramJSONArray2 == null) {
        return;
      }
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop_pobing_config_left_wording_");
      localStringBuilder.append(paramString);
      localEditor.putString(localStringBuilder.toString(), paramJSONArray1.toString());
      paramJSONArray1 = new StringBuilder();
      paramJSONArray1.append("troop_pobing_config_right_wording_");
      paramJSONArray1.append(paramString);
      localEditor.putString(paramJSONArray1.toString(), paramJSONArray2.toString());
      localEditor.commit();
      a(paramQQAppInterface);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, List<String> paramList1, List<String> paramList2)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("troop_pobing_config_left_wording_");
    ((StringBuilder)localObject2).append(paramQQAppInterface);
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_pobing_config_right_wording_");
    localStringBuilder.append(paramQQAppInterface);
    paramQQAppInterface = ((SharedPreferences)localObject1).getString(localStringBuilder.toString(), "");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    int i2 = 0;
    int i1;
    if (!bool) {
      try
      {
        localObject1 = new JSONArray((String)localObject2);
        i1 = 0;
        while (i1 < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(i1);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramList1.add(localObject2);
          }
          i1 += 1;
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
        i1 = i2;
        while (i1 < paramQQAppInterface.length())
        {
          paramList1 = paramQQAppInterface.optString(i1);
          if (!TextUtils.isEmpty(paramList1)) {
            paramList2.add(paramList1);
          }
          i1 += 1;
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
    int i1 = TroopManager.9.a[paramExpiredType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return;
        }
        if (TroopManager.LiangGroupHelper.b(paramMessageRemindRsp.iGroupType)) {
          i1 = 13;
        } else {
          i1 = 14;
        }
        VipUtils.a(paramContext, paramString, VipUtils.c(0, i1).toString(), HardCodeUtil.a(2131912744), new TroopManager.3(localTroopManager, paramString, paramQQAppInterface), "0X800A57E", 1, true);
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A57D", 0, 0, "", "", "", "");
        return;
      }
      VipUtils.a(paramContext, paramString, VipUtils.c((int)paramMessageRemindRsp.iGroupExpiredTime, 6).toString(), HardCodeUtil.a(2131912795), new TroopManager.2(localTroopManager, paramString), "0X8009E36", 1);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
      return;
    }
    VipUtils.a(paramContext, paramString, VipUtils.c((int)paramMessageRemindRsp.iSVIPExpiredTime, 7).toString(), HardCodeUtil.a(2131912761), new TroopManager.1(localTroopManager, paramString), "0X8009E36", 2);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E35", 2, 0, "", "", "", "");
  }
  
  protected static void a(TroopManager.ExpiredType paramExpiredType, QQAppInterface paramQQAppInterface, String paramString, TroopChatPie paramTroopChatPie, MessageRemindRsp paramMessageRemindRsp, TipsManager paramTipsManager)
  {
    int i1 = TroopManager.9.a[paramExpiredType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return;
        }
        paramExpiredType = paramTroopChatPie.bB;
        int i2 = paramMessageRemindRsp.iLhGroupExpiredTime;
        if (TroopManager.LiangGroupHelper.b(paramMessageRemindRsp.iGroupType)) {
          i1 = 11;
        } else {
          i1 = 12;
        }
        paramExpiredType.a(paramString, VipUtils.c(i2, i1), 1, 4);
        paramTipsManager.a(paramTroopChatPie.bB, new Object[0]);
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A57B", 0, 0, "", "", "", "");
        return;
      }
      paramTroopChatPie.bB.a(paramString, VipUtils.c((int)paramMessageRemindRsp.iGroupExpiredTime, 2), 1, 1);
      paramTipsManager.a(paramTroopChatPie.bB, new Object[0]);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 1, 0, "", "", "", "");
      return;
    }
    paramTroopChatPie.bB.a(paramString, VipUtils.c((int)paramMessageRemindRsp.iSVIPExpiredTime, 3), 1, 2);
    paramTipsManager.a(paramTroopChatPie.bB, new Object[0]);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 2, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isOpenTroopMessage) {
      return true;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      return (paramQQAppInterface != null) && (paramQQAppInterface.s(paramMessageRecord.frienduin));
    }
    return false;
  }
  
  private SearchConfig.TroopMemberSetting b(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    SearchConfigManager.a(this.a);
    ArrayList localArrayList = SearchConfigManager.troopMemberUpdateConfigs;
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localIterator;
    if (localArrayList != null)
    {
      localObject1 = localIterator;
      if (!SearchConfigManager.troopMemberUpdateConfigs.isEmpty())
      {
        localIterator = SearchConfigManager.troopMemberUpdateConfigs.iterator();
        do
        {
          for (;;)
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              return localObject1;
            }
            localObject1 = (SearchConfig.TroopMemberSetting)localIterator.next();
            if (!paramBoolean) {
              break;
            }
            if ((localObject2 == null) || (localObject2.b > ((SearchConfig.TroopMemberSetting)localObject1).b)) {
              localObject2 = localObject1;
            }
          }
        } while ((paramTroopInfo.wMemberNum <= ((SearchConfig.TroopMemberSetting)localObject1).a) || (paramTroopInfo.wMemberNum >= ((SearchConfig.TroopMemberSetting)localObject1).b));
      }
    }
    return localObject1;
  }
  
  private boolean f(TroopInfo paramTroopInfo)
  {
    int i2 = this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0);
    if (i2 == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    SearchConfig.TroopMemberSetting localTroopMemberSetting = b(paramTroopInfo, bool2);
    if (localTroopMemberSetting == null) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if ((bool2) && (localTroopMemberSetting != null)) {
      if ((paramTroopInfo.wMemberNum > localTroopMemberSetting.a) && (paramTroopInfo.wMemberNum < localTroopMemberSetting.b)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    long l1 = a(this.a, paramTroopInfo.troopuin);
    boolean bool2 = bool1;
    if (bool1)
    {
      l1 = Math.abs(System.currentTimeMillis() - l1);
      if (NetworkUtil.isWifiConnected(this.a.getApp()) ? l1 < localTroopMemberSetting.c * 3600000L : l1 < localTroopMemberSetting.d * 3600000L) {
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (l1 > localTroopMemberSetting.c * 3600000L * 2L)
        {
          bool2 = bool1;
          if (l1 > localTroopMemberSetting.d * 3600000L)
          {
            i1 = 1;
            break label258;
          }
        }
      }
    }
    int i1 = 0;
    boolean bool1 = bool2;
    label258:
    if ((i2 == 2) && (bool1) && (i1 == 0)) {
      try
      {
        l1 = Long.valueOf(paramTroopInfo.troopuin).longValue();
        i1 = Calendar.getInstance().get(5);
        i2 = localTroopMemberSetting.c / 24;
        if (i2 != 0)
        {
          long l2 = i2;
          if (l1 % l2 != i1 % i2) {
            return false;
          }
        }
      }
      catch (Exception paramTroopInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, except: %s", new Object[] { paramTroopInfo.getMessage() }));
        }
      }
    }
    return bool1;
  }
  
  @Deprecated
  private void q()
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).buildTroopUI();
  }
  
  public void A(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.e.remove(paramString);
      return;
    }
    finally {}
  }
  
  public boolean B(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        bool = this.e.contains(paramString);
        if (bool)
        {
          bool = true;
          break label29;
        }
      }
      boolean bool = false;
      label29:
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int C(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a.getPreferences();
    String str = this.a.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("modify_troop_class_info_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public int D(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a.getPreferences();
    String str = this.a.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_troop_notify_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public void E(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("Q.contacttab.", 1, "addPassiveExitGrayTips, troopUin is empty");
    }
    paramString = b(paramString, true);
    if (paramString == null)
    {
      QLog.e("Q.contacttab.", 1, "addPassiveExitGrayTips, troopInfo == null");
      return;
    }
    int i1 = paramString.exitTroopReason;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      a(paramString.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131081);
      return;
    }
    a(paramString.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131080);
  }
  
  public boolean F(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Q.contacttab.", 1, "isPassiveExit, troopUin is empty");
      return false;
    }
    paramString = b(paramString, true);
    if (paramString == null) {
      return false;
    }
    if ((!paramString.isKicked()) && (!paramString.isDisband())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, String.format("isPassiveExit reason: %s", new Object[] { Integer.valueOf(paramString.exitTroopReason) }));
    }
    return true;
  }
  
  public void G(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("Q.contacttab.", 1, "clearPassiveExitTroopInfo, troopUin is empty!");
      return;
    }
    if (!((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).clearPassiveExitTroopInfo(paramString)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a);
    this.a.getMessageFacade().c(paramString, 1);
    c(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, new Throwable("clearPassiveExitTroopInfo.debug"), new Object[0]);
    }
  }
  
  public boolean H(String paramString)
  {
    if (!QVIPPrettyTroopProcessor.e().a)
    {
      localObject = f(paramString);
      if ((localObject != null) && (((TroopInfo)localObject).checkFlagExt4(3)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("troop ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" is pretty so req group care");
          QLog.d("vip_pretty.Q.contacttab.", 1, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    Object localObject = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getInt(g, 0) < System.currentTimeMillis() / 1000L;
  }
  
  public void I(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    if ((paramString.contains(i)) || (paramString.contains(m))) {
      paramString.edit().remove(i).remove(k).remove(l).remove(m).remove(o).remove(p).remove(q).commit();
    }
  }
  
  public MessageRemindRsp J(String paramString)
  {
    Object localObject = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 4).getString(h, "");
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new MessageRemindRsp();
      ((MessageRemindRsp)localObject).readFrom(new JceInputStream(Utils.hexStr2Bytes(paramString)));
      return localObject;
    }
    return null;
  }
  
  public int K(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(i, 0);
  }
  
  public int L(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(j, 0);
  }
  
  public int M(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(k, 0);
  }
  
  public int N(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(l, 0);
  }
  
  public int O(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(m, 0);
  }
  
  public int P(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(n, 0);
  }
  
  public boolean Q(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(o, true);
  }
  
  public int R(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(p, 0);
  }
  
  public int S(String paramString)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(q, 0);
  }
  
  public boolean T(String paramString)
  {
    Object localObject;
    if (this.r == null)
    {
      this.r = new ArraySet();
      localObject = this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).getStringSet("group_invite_accept_handle_set", null);
      if (localObject != null) {
        this.r.addAll((Collection)localObject);
      }
    }
    boolean bool = this.r.contains(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasHandleGroupInviteAccept key:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" res:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void U(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markHasHandleGroupInviteAccept key:");
      localStringBuilder.append(paramString);
      QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
    }
    if (this.r == null) {
      this.r = new ArraySet();
    }
    this.r.add(paramString);
    this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putStringSet("group_invite_accept_handle_set", this.r).apply();
  }
  
  public boolean V(String paramString)
  {
    Object localObject;
    if (this.s == null)
    {
      this.s = new ArraySet();
      localObject = this.a.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.getCurrentAccountUin());
      localStringBuilder.append("_group_sysmsg");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getStringSet("processed_cache", null);
      if (localObject != null) {
        this.s.addAll((Collection)localObject);
      }
    }
    boolean bool = this.s.contains(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasGroupSystemMsgProcessed key:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" res:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void W(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("markGroupSystemMsgProcessed key:");
      localStringBuilder.append(paramString);
      QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
    }
    if (this.s == null) {
      this.s = new ArraySet();
    }
    this.s.add(paramString);
    paramString = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_group_sysmsg");
    paramString.getSharedPreferences(localStringBuilder.toString(), 0).edit().putStringSet("processed_cache", this.s).apply();
  }
  
  public int X(String paramString)
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).getAssociatedTroopCount(paramString);
  }
  
  public final boolean Y(String paramString)
  {
    return f(paramString) != null;
  }
  
  public boolean Z(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(paramString);
  }
  
  @Deprecated
  public TroopInfo a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString, paramBoolean1, paramBoolean2);
  }
  
  @Deprecated
  public TroopMemberInfo a(String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInLruCache(paramString1, paramString2);
  }
  
  @Deprecated
  public oidb_cmd0xb36.ToastInfo a(String paramString)
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).getTroopSurveyList(paramString);
  }
  
  @Deprecated
  public void a()
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).initAndBuildTroopUI();
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).setUniqueTitleNewFlag(paramInt);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((Integer)((Iterator)localObject).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.contacttab.", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.d.size() > 30) {
      this.d.poll();
    }
    this.d.offer(Integer.valueOf(paramInt));
    String str = String.valueOf(paramLong1);
    TroopManager localTroopManager = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.f(String.valueOf(paramLong1));
    localObject = localTroopInfo;
    if (localTroopInfo == null)
    {
      localObject = new TroopInfo();
      ((TroopInfo)localObject).troopuin = str;
    }
    paramLong1 = ((TroopInfo)localObject).troopPrivilegeFlag;
    long l1 = paramLong4 & paramLong3;
    if ((paramLong1 & paramLong3) != l1)
    {
      if (l1 == paramLong3) {
        ((TroopInfo)localObject).troopPrivilegeFlag &= paramLong3;
      } else {
        ((TroopInfo)localObject).troopPrivilegeFlag &= (paramLong3 ^ 0xFFFFFFFF);
      }
      localTroopManager.b((TroopInfo)localObject);
    }
    a(str, paramLong2, paramInt, paramLong3, paramLong4, paramString);
  }
  
  @Deprecated
  public void a(TroopInfo paramTroopInfo)
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).addTroop(paramTroopInfo);
  }
  
  public void a(TroopInfo paramTroopInfo, long paramLong)
  {
    if (paramTroopInfo == null) {
      return;
    }
    ProxyManager localProxyManager = this.a.getProxyManager();
    RecentUser localRecentUser = localProxyManager.g().b(paramTroopInfo.troopuin, 1);
    localRecentUser.displayName = paramTroopInfo.getTroopDisplayName();
    if (localRecentUser.getStatus() == 1000)
    {
      localRecentUser.lastmsgtime = paramLong;
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(this.a, localRecentUser);
      localProxyManager.g().b(localRecentUser);
      ((MessageHandler)this.a.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(6003, true, new String[] { paramTroopInfo.troopuin, "0" });
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.a.getPreferences();
    String str = this.a.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("modify_troop_class_info_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  @Deprecated
  public void a(String paramString, long paramLong)
  {
    ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).setOldestUniqueTitleExpireTime(paramString, paramLong);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("----------addTroopPrivilegeTipsMr troopUin: ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if ((paramLong2 & 1L) == 1L) {
        if ((paramLong3 & 1L) == 1L) {
          paramString2 = this.a.getApplication().getString(2131895450);
        } else {
          paramString2 = this.a.getApplication().getString(2131895451);
        }
      }
      for (;;)
      {
        break;
        if ((paramLong2 & 0x2) != 2L) {
          break;
        }
        if ((paramLong3 & 0x2) == 2L) {
          paramString2 = this.a.getApplication().getString(2131895448);
        } else {
          paramString2 = this.a.getApplication().getString(2131895449);
        }
      }
    }
    Object localObject = (MessageForGrayTips)MessageRecordFactory.a(-1013);
    ((MessageForGrayTips)localObject).frienduin = paramString1;
    ((MessageForGrayTips)localObject).init(this.a.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong1, -1013, 1, paramInt);
    ((MessageForGrayTips)localObject).isread = true;
    this.a.getMessageFacade().a((MessageRecord)localObject, this.a.getCurrentAccountUin());
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    String str;
    if (paramInt == 131081) {
      str = HardCodeUtil.a(2131912760);
    } else if (paramInt == 131080) {
      str = HardCodeUtil.a(2131912776);
    } else {
      str = "";
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Object localObject = new UniteGrayTipParam(paramString, paramString, str, 1, -5040, paramInt, paramLong1);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.initGrayTipMsg(this.a, (UniteGrayTipParam)localObject);
    localMessageForUniteGrayTip.isread = true;
    if (paramLong2 == 0L)
    {
      localObject = this.a.getMessageFacade().getLastMessage(paramString, 1);
      if (localObject != null)
      {
        long l1 = ((Message)localObject).shmsgseq;
        paramLong2 = l1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, String.format("addAIOGrayTips, shmsgseq: %s, msgseq: %s", new Object[] { Long.valueOf(((Message)localObject).shmsgseq), Long.valueOf(((Message)localObject).msgseq) }));
          paramLong2 = l1;
        }
      }
    }
    localMessageForUniteGrayTip.shmsgseq = paramLong2;
    UniteGrayTipMsgUtil.a(this.a, localMessageForUniteGrayTip);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, String.format("addAIOGrayTips, troopUin: %s, msgTime: %s, wording: %s, msgSeq: %s", new Object[] { paramString, Long.valueOf(paramLong1), str, Long.valueOf(paramLong2) }));
    }
  }
  
  public void a(String paramString, MessageRemindRsp paramMessageRemindRsp)
  {
    Object localObject = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    c(paramString, (int)paramMessageRemindRsp.iNextReqTime);
    ((SharedPreferences)localObject).edit().putString(h, Utils.bytes2HexStr(paramMessageRemindRsp.toByteArray())).commit();
  }
  
  @Deprecated
  public void a(String paramString, ITroopInfoCallback paramITroopInfoCallback)
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).asyncGetTroopInfo(paramString, paramITroopInfoCallback);
  }
  
  public void a(String paramString, ITroopInfoService.GetTroopCodeCallback paramGetTroopCodeCallback)
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUinAsync(paramString, paramGetTroopCodeCallback);
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(o, paramBoolean.booleanValue()).commit();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, String.format("handleMemberExitTroop, troopUin: %s, memberUin: %s, type: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
      }
      if (((paramInt == 1) || (paramInt == 3)) && (paramString2.equals(this.a.getCurrentAccountUin()))) {
        b(paramString1, paramString2, false);
      } else {
        b(paramString1, paramString2, true);
      }
      if (paramString2.equals(this.a.getCurrentAccountUin())) {
        ((TroopGagMgr)this.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).e(paramString1);
      }
      return;
    }
    QLog.e("Q.contacttab.", 1, "handleMemberExitTroop, troopUin or memberUin is empty");
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      ProxyManager localProxyManager = this.a.getProxyManager();
      RecentUser localRecentUser = localProxyManager.g().b(paramString1, 1);
      localRecentUser.displayName = paramString2;
      if (localRecentUser.getStatus() == 1000)
      {
        localRecentUser.lastmsgtime = paramLong;
        ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(this.a, localRecentUser);
        localProxyManager.g().b(localRecentUser);
        ((MessageHandler)this.a.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(6003, true, new String[] { paramString1, "0" });
      }
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, TroopManager.ITroopMemberInfoCallBack paramITroopMemberInfoCallBack)
  {
    ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfo(paramString1, paramString2, paramITroopMemberInfoCallBack);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberInfoInLruCache(paramString1, paramString2, paramTroopMemberInfo);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).saveTroopMemberUniqueTitle(paramString1, paramString2, paramString3, paramInt);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).saveTroopMemberUniqueTitle(paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).setUniqueTitleExpireNotified(paramString1, paramString2, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface == null) {
      return;
    }
    if (!((ITroopInfoService)localQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).deleteTroop(paramString, paramBoolean)) {
      return;
    }
    try
    {
      ((MultiCardManager)this.a.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER)).a(Long.parseLong(paramString), null);
    }
    catch (Exception paramString)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Q.contacttab.", 2, new Object[] { "deleteTroopRecommendUinList ", paramString.toString() });
      }
    }
    if (QLog.isDebugVersion()) {
      QLog.d("Q.contacttab.", 2, "deleteTroop", new Throwable("debug"));
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      try
      {
        Object localObject1 = new troop_honor.HonorChangeGrayTipsReserved();
        ((troop_honor.HonorChangeGrayTipsReserved)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((troop_honor.HonorChangeGrayTipsReserved)localObject1).user_honor.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            Object localObject2 = (troop_honor.UserHonor)paramArrayOfByte.next();
            if ((((troop_honor.UserHonor)localObject2).uin.has()) && (((troop_honor.UserHonor)localObject2).level.has()))
            {
              localObject1 = String.valueOf(((troop_honor.UserHonor)localObject2).uin.get());
              int i1 = ((troop_honor.UserHonor)localObject2).level.get();
              localObject2 = new TroopManager.TmiCallBackForTroopMemberNewLevel(this, null);
              ((TroopManager.TmiCallBackForTroopMemberNewLevel)localObject2).a = ((String)localObject1);
              ((TroopManager.TmiCallBackForTroopMemberNewLevel)localObject2).b = paramString;
              ((TroopManager.TmiCallBackForTroopMemberNewLevel)localObject2).c = i1;
              a(paramString, (String)localObject1, (TroopManager.ITroopMemberInfoCallBack)localObject2);
              if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.", 2, String.format("handleTroopMemberNewLevelChange, pushType: %s, troopUin: %s, memberUin: %s, newRealLevel: %s", new Object[] { Integer.valueOf(paramInt), paramString, localObject1, Integer.valueOf(i1) }));
              }
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
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).preloadData(paramArrayList);
  }
  
  public void a(Map<String, Long> paramMap)
  {
    ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).prePareShowExternalTroop(paramMap);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).setTroopConfessPanelOpen(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasGroupSystemMsgProcessed troopCode:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" msgTime:");
      localStringBuilder.append(paramLong2);
      QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
    }
    if (paramLong1 != 0L)
    {
      if (paramLong2 == 0L) {
        return false;
      }
      return V(String.format("%s_%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    return false;
  }
  
  public boolean a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramBoolean = f(paramTroopInfo);
    } else {
      paramBoolean = true;
    }
    if (paramBoolean)
    {
      QLog.isColorLevel();
      if ((paramTroopInfo.mMemberNumSeq != paramTroopInfo.mOldMemberNumSeq) || (paramTroopInfo.mMemberNumSeq == -1L) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq) || (paramTroopInfo.mMemberCardSeq == -1L))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, get troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq) }));
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, ignore troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d, overtime: %s", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq), Boolean.valueOf(paramBoolean) }));
    }
    return false;
  }
  
  @Deprecated
  public boolean a(Entity paramEntity)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).updateEntity(paramEntity);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, paramString6, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMember(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramInt5);
  }
  
  @Deprecated
  public boolean a(List<TroopMemberInfo> paramList)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMembers(paramList);
  }
  
  public boolean aa(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).isHomeworkTroop(paramString);
  }
  
  public boolean ab(String paramString)
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).isFansTroop(paramString);
  }
  
  @Deprecated
  public int b()
  {
    return ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).getUniqueTitleNewFlag();
  }
  
  @Deprecated
  public long b(String paramString)
  {
    return ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).getOldestUniqueTitleExpireTime(paramString);
  }
  
  @Deprecated
  public TroopInfo b(String paramString, boolean paramBoolean)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString, paramBoolean);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markGroupSystemMsgProcessed troopCode:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" msgTime:");
      localStringBuilder.append(paramLong2);
      QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
    }
    if (paramLong1 != 0L)
    {
      if (paramLong2 == 0L) {
        return;
      }
      W(String.format("%s_%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
  }
  
  @Deprecated
  public void b(TroopInfo paramTroopInfo)
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(paramTroopInfo);
  }
  
  public void b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.a.getPreferences();
    String str = this.a.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_troop_notify_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public void b(String paramString, long paramLong)
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).setInsertJoinTroopMsgTime(paramString, paramLong);
  }
  
  @Deprecated
  public void b(String paramString1, String paramString2, long paramLong)
  {
    ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberCmduinFlagEx3(paramString1, paramString2, paramLong);
  }
  
  @Deprecated
  public void b(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberInfoToDB(paramString1, paramString2, paramTroopMemberInfo);
  }
  
  @Deprecated
  public void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).saveTroopMemeberUniqueTitleAndExpire(paramString1, paramString2, paramString3, paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).setTroopAIOOpen(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public boolean b(String paramString1, String paramString2)
  {
    return ((IUniqueTitleService)this.a.getRuntimeService(IUniqueTitleService.class, "")).hasUniqueTitleExpireNotified(paramString1, paramString2);
  }
  
  @Deprecated
  public boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).deleteTroopMember(paramString1, paramString2, paramBoolean);
  }
  
  @Deprecated
  protected TroopInfo c(String paramString1, String paramString2)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).saveTroopName(paramString1, paramString2);
  }
  
  @Deprecated
  public void c(TroopInfo paramTroopInfo)
  {
    ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfoOnlyCacheAndDB(paramTroopInfo);
  }
  
  public void c(String paramString)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    TroopNotificationHelper.a(paramString, (QQAppInterface)localObject);
    TroopAssistantManager.a().b(paramString, this.a);
    this.a.getMessageFacade().c(paramString, 1);
    c(paramString, true);
    this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER).notifyUI(TroopMngObserver.m, true, paramString);
    ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).notifyQuitTroop(paramString);
    label157:
    try
    {
      if (!this.a.getAVNotifyCenter().d(Long.parseLong(paramString))) {
        break label157;
      }
      BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label118:
      break label118;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tm->deleteTroop-->NumberFormatException, troopUin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(g, paramInt).commit();
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramBoolean)
      {
        ThreadManager.post(new TroopManager.6(this, paramString), 8, null, true);
        return;
      }
      b(paramString, -1L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).setShowTroopBigClub(paramBoolean);
  }
  
  @Deprecated
  public boolean c()
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).hasNoTroop();
  }
  
  @Deprecated
  public boolean c(String paramString, long paramLong)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).addCommonlyUsedTroop(paramString, paramLong);
  }
  
  @Deprecated
  public List<CommonlyUsedTroop> d()
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopList();
  }
  
  public void d(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    G(paramTroopInfo.troopuin);
    b(paramTroopInfo);
    q();
  }
  
  public void d(String paramString)
  {
    a(paramString, false);
  }
  
  public void d(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(i, paramInt).commit();
  }
  
  public boolean d(String paramString, long paramLong)
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).addShowExternalTroop(paramString, paramLong);
  }
  
  @Deprecated
  public boolean d(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, true);
  }
  
  @Deprecated
  public TroopInfo e(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfoInUI(paramString);
  }
  
  @Deprecated
  public String e(String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)this.a.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2);
  }
  
  @Deprecated
  public List<ShowExternalTroop> e()
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).getShowExternalTroopList();
  }
  
  public void e(TroopInfo paramTroopInfo)
  {
    a(paramTroopInfo, NetConnInfoCenter.getServerTime());
  }
  
  public void e(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(j, paramInt).commit();
  }
  
  @Deprecated
  public TroopInfo f(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
  }
  
  @Deprecated
  public String f(String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)this.a.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2, false, true);
  }
  
  public void f()
  {
    ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).refreshShowExternalTroop();
  }
  
  public void f(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(k, paramInt).commit();
  }
  
  @Deprecated
  public TroopInfo g(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
  
  @Deprecated
  public TroopMemberInfo g(String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
  }
  
  @Deprecated
  public ArrayList<Entity> g()
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getUiTroopListWithoutBlockedTroop();
  }
  
  public void g(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(l, paramInt).commit();
  }
  
  @Deprecated
  public TroopInfo h(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopInfoFromCache(paramString);
  }
  
  @Deprecated
  public TroopMemberInfo h(String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoFromDb(paramString1, paramString2);
  }
  
  @Deprecated
  public ArrayList<Entity> h()
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
  }
  
  public void h(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(m, paramInt).commit();
  }
  
  @Deprecated
  public String i(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopNameByID(paramString);
  }
  
  @Deprecated
  public List<Long> i()
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getUinList();
  }
  
  public void i(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(n, paramInt).commit();
  }
  
  public void i(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      ((HashMap)localObject).put(localStringBuilder.toString(), paramString2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addGroupInviteStatus groupUin : ");
        ((StringBuilder)localObject).append(paramString1);
        paramString1 = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", inviterUin:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { paramString1, ((StringBuilder)localObject).toString() });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int j()
  {
    try
    {
      int i1 = this.f.size();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hasGroupInviting  : ");
        localStringBuilder.append(i1);
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, localStringBuilder.toString());
      }
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long j(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getInsertJoinTroopMsgTime(paramString);
  }
  
  public void j(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(p, paramInt).commit();
  }
  
  public boolean j(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      boolean bool = ((HashMap)localObject).containsKey(localStringBuilder.toString());
      if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isTheSameInviterInviting re:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", troopUin : ");
        ((StringBuilder)localObject).append(paramString1);
        paramString1 = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", inviterUin:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { paramString1, ((StringBuilder)localObject).toString() });
      }
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public BatchAddFriendForTroopConfig k()
  {
    if (this.x == null) {
      this.x = new BatchAddFriendForTroopConfig(this.a);
    }
    return this.x;
  }
  
  @Deprecated
  public String k(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(paramString);
  }
  
  public void k(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(q, paramInt).commit();
  }
  
  public void k(String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      localHashMap.remove(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("removeGroupInviteStatus groupUin : ");
        paramString2.append(paramString1);
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, paramString2.toString());
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public List<TroopNotificationCache> l(String paramString)
  {
    if (paramString != null)
    {
      if (this.a == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.b;
      int i1 = 0;
      paramString = ((EntityManager)localObject).query(TroopNotificationCache.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.a.getCurrentAccountUin() }, null, null, "time ASC", null);
      if (paramString == null) {
        return null;
      }
      localObject = new HashMap();
      while (i1 < paramString.size())
      {
        TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)paramString.get(i1);
        if (!((Map)localObject).containsKey(localTroopNotificationCache.feedsId))
        {
          localArrayList.add(localTroopNotificationCache);
          ((Map)localObject).put(localTroopNotificationCache.feedsId, Integer.valueOf(1));
        }
        i1 += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  @Deprecated
  public boolean l()
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).isTroopCacheInited();
  }
  
  public void m(String paramString)
  {
    EntityManager localEntityManager = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update TroopNotificationCache set read=1 where troopUin=");
    localStringBuilder.append(paramString);
    localEntityManager.execSQL(localStringBuilder.toString());
  }
  
  public boolean m()
  {
    try
    {
      boolean bool = ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).isTroopConfessPanelOpen();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public CommonlyUsedTroop n(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroop(paramString);
  }
  
  public boolean n()
  {
    try
    {
      boolean bool = ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).isTroopAIOOpen();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean o()
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).isShowTroopBigClub();
  }
  
  @Deprecated
  public boolean o(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).isCommonlyUsedTroop(paramString);
  }
  
  public void onDestroy()
  {
    this.a.getConfigProcess().a(this);
    this.a.removeObserver(this.w);
    this.a.removeObserver(this.v);
    this.b.close();
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("batch_add_friend_for_troop_config".equals(paramString))) {
      k().a(paramCfgParseResult.d);
    }
  }
  
  public TroopManager.ConfigableWordingSetter p()
  {
    if (this.y == null) {
      this.y = new TroopManager.ConfigableWordingSetter(this.a);
    }
    return this.y;
  }
  
  @Deprecated
  public boolean p(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).removeCommonlyUsedTroop(paramString);
  }
  
  @Deprecated
  public boolean q(String paramString)
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).isShowExternalTroop(paramString);
  }
  
  public boolean r(String paramString)
  {
    return ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).removeShowExternalTroop(paramString);
  }
  
  public boolean s(String paramString)
  {
    try
    {
      boolean bool = ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).isCurrentOpenTroop(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void t(String paramString)
  {
    try
    {
      ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).setCurrentOpenTroop(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String u(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopUinByTroopCode(paramString);
  }
  
  public String v(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(paramString);
  }
  
  @Deprecated
  public List<TroopMemberInfo> w(String paramString)
  {
    return ((ITroopMemberInfoService)this.a.getRuntimeService(ITroopMemberInfoService.class, "")).getAllTroopMembers(paramString);
  }
  
  public ArrayList<String> x(String paramString)
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getTroopMemberForTroopHead(paramString);
  }
  
  @Deprecated
  public void y(String paramString)
  {
    ((IBizTroopInfoService)this.a.getRuntimeService(IBizTroopInfoService.class, "")).onTroopReceiveOrSendMsg(paramString);
  }
  
  public void z(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        boolean bool = this.e.contains(paramString);
        if (bool) {
          return;
        }
      }
      this.e.add(paramString);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager
 * JD-Core Version:    0.7.0.1
 */