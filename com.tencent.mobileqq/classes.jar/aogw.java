import MQQ.DataReturnFlag;
import MQQ.GuanjiaReportRsp;
import MQQ.ItemCfgInfo;
import MQQ.ItemCfgList;
import MQQ.PayRuleCfg;
import MQQ.PrivExtV2Rsp;
import MQQ.QidInfoItem;
import MQQ.ShowRangeTime;
import MQQ.ShowRule;
import MQQ.TrafficResultInfo;
import MQQ.VAResourcesRsp;
import MQQ.VipMedalList;
import MQQ.VipUserInfo;
import QC.LoginInfo;
import QC.MessageShow;
import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniSetReq;
import QQService.EVIPSPEC;
import VIP.GetCustomOnlineStatusRsp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler.1;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.qzone.util.JceUtils;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class aogw
  extends BusinessHandler
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a;
  private static HashMap<String, PayRuleCfg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  private static String q = "VipInfoHandler";
  private String r;
  
  static
  {
    jdField_a_of_type_JavaLangString = "k_uin";
    b = "k_type";
    c = "k_skey";
    d = "k_from";
    e = "k_phone_num";
    f = "k_is_king_card";
    g = "k_card_type";
    h = "k_card_status";
    i = "k_hasImsi";
    j = "key_has_double_imsi";
    k = "key_imsi_one";
    l = "key_imsi_two";
    m = "k_sequence";
    n = "uin";
    o = "login_info";
    p = "state";
  }
  
  aogw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a(PayRuleCfg paramPayRuleCfg)
  {
    return (paramPayRuleCfg.clubType - 1) * 3 + paramPayRuleCfg.userType;
  }
  
  private int a(VipUserInfo paramVipUserInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipUserInfo == null) || (paramInt1 > 2) || (paramInt1 < 1)) {
      return paramInt2;
    }
    if (1 == paramInt1) {}
    for (paramInt1 = paramVipUserInfo.iOpenVip;; paramInt1 = paramVipUserInfo.iOpenSVip) {
      return (paramInt1 << 8 | (byte)paramVipUserInfo.iVipType) << 16 | (short)paramVipUserInfo.iVipLevel;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int i3 = 0;
    paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i1;
    label36:
    int i2;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = null;
      if (paramQQAppInterface == null) {
        break label120;
      }
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label103;
      }
      i1 = 1;
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label108;
      }
      i2 = 1;
      label49:
      int i4 = paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
      if (paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_QQVIP) + i4 > 0) {
        break label114;
      }
      label71:
      if (i2 != 1) {
        break label130;
      }
      i1 = 3;
    }
    for (;;)
    {
      i2 = i1;
      if (paramBoolean) {
        i2 = i1 + 4;
      }
      return i2;
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      break;
      label103:
      i1 = 0;
      break label36;
      label108:
      i2 = 0;
      break label49;
      label114:
      i3 = 1;
      break label71;
      label120:
      if (paramBoolean) {
        return 99;
      }
      return 98;
      label130:
      if (i1 == 1) {
        i1 = 4;
      } else if (i3 == 1) {
        i1 = 2;
      } else {
        i1 = 1;
      }
    }
  }
  
  public static PayRuleCfg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(q, 1, "getPayRule: empty uin");
      ??? = null;
      return ???;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilHashMap)
      {
        Object localObject2 = (PayRuleCfg)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        ??? = localObject2;
        if (localObject2 != null) {
          break;
        }
        ??? = a(paramString, "payRule.cfg");
        if (??? == null)
        {
          ??? = new PayRuleCfg();
          ((PayRuleCfg)???).enable = 0;
          synchronized (jdField_a_of_type_JavaUtilHashMap)
          {
            PayRuleCfg localPayRuleCfg = (PayRuleCfg)jdField_a_of_type_JavaUtilHashMap.get(paramString);
            localObject2 = localPayRuleCfg;
            if (localPayRuleCfg == null)
            {
              jdField_a_of_type_JavaUtilHashMap.put(paramString, ???);
              localObject2 = ???;
            }
            return localObject2;
          }
        }
      }
    }
  }
  
  private static PayRuleCfg a(String arg0, String paramString2)
  {
    paramString2 = new File(BaseApplicationImpl.getContext().getFilesDir(), ??? + File.separator + paramString2);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString2 = FileUtils.fileToBytes(paramString2);
      if (paramString2 != null) {
        return (PayRuleCfg)JceUtils.decodeWup(PayRuleCfg.class, paramString2);
      }
    }
    return null;
  }
  
  private LoginInfo a()
  {
    try
    {
      String str1 = this.app.getCurrentAccountUin();
      String str2 = ((TicketManager)this.app.getManager(2)).getSkey(str1);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str1);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = str2;
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = DeviceInfoUtil.getQQVersion();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e(q, 1, localException, new Object[0]);
    }
    return null;
  }
  
  public static String a(PayRuleCfg paramPayRuleCfg)
  {
    if (paramPayRuleCfg == null) {
      return "null";
    }
    return Base64.encodeToString(JceUtils.encodeWup(paramPayRuleCfg), 2) + "\n" + paramPayRuleCfg;
  }
  
  public static void a(int paramInt, String paramString)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.mTraceId = (str + "_" + l1);
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mAppId = "tianshu.47";
    localTianShuReportData.mPageId = "tianshu.47";
    localTianShuReportData.mItemId = paramString;
    localTianShuReportData.mSubItemId = "";
    localTianShuReportData.mOperTime = l1;
    localTianShuReportData.mActionId = paramInt;
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mActionAttr = 1;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(@NonNull PrivExtV2Rsp paramPrivExtV2Rsp, String paramString)
  {
    VipUserInfo localVipUserInfo = paramPrivExtV2Rsp.vipInfo;
    paramPrivExtV2Rsp = paramPrivExtV2Rsp.medalInfoList;
    if (localVipUserInfo == null) {
      return;
    }
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = localanvk.d(paramString);
    localFriends.qqVipInfo = a(localVipUserInfo, 1, localFriends.qqVipInfo);
    localFriends.superVipInfo = a(localVipUserInfo, 2, localFriends.superVipInfo);
    SharedPreferences localSharedPreferences = this.app.getApplication().getApplicationContext().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (localVipUserInfo.iUpdateTime > 0L) {
      localSharedPreferences.edit().putLong("sp_vip_info_request_time", localVipUserInfo.iUpdateTime);
    }
    if (localVipUserInfo.iUpdateFreq > 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_update_freq", localVipUserInfo.iUpdateFreq);
    }
    if (localVipUserInfo.iCanUseRed >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", localVipUserInfo.iCanUseRed);
    }
    if (localVipUserInfo.iRedDisable >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", localVipUserInfo.iRedDisable);
    }
    localSharedPreferences.edit().putString("sp_vip_info_current_version", QUA.getQUA3());
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", localVipUserInfo.iRedPackId);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", localVipUserInfo.sRedPackRemard);
    localSharedPreferences.edit().putString("sp_vip_medal_lvl_jump_url", paramPrivExtV2Rsp.lvlJumpUrl);
    localSharedPreferences.edit().commit();
    if (QLog.isColorLevel()) {
      QLog.d(q, 2, "redpacketinfo : icanusedred = " + localVipUserInfo.iCanUseRed + ";iRedDisable = " + localVipUserInfo.iRedDisable + "iRedPacketId = " + localVipUserInfo.iRedPackId + ";sRedPackRemard = " + localVipUserInfo.sRedPackRemard);
    }
    localanvk.a(localFriends);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.app.getAccount())) && ((localVipUserInfo.iCanUseRed >= 0) || (localVipUserInfo.iRedDisable >= 0)))
    {
      paramPrivExtV2Rsp = (anxc)this.app.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
      paramPrivExtV2Rsp.a(localVipUserInfo.iCanUseRed, localVipUserInfo.iRedDisable, true);
      paramPrivExtV2Rsp.a(localVipUserInfo.iRedPackId, localVipUserInfo.sRedPackRemard);
    }
    paramPrivExtV2Rsp = localVipUserInfo.sUri;
    if (!TextUtils.isEmpty(paramPrivExtV2Rsp))
    {
      if (QLog.isColorLevel()) {
        QLog.d(q, 2, "vip url = " + paramPrivExtV2Rsp);
      }
      paramPrivExtV2Rsp = this.app.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramPrivExtV2Rsp);
      if (Build.VERSION.SDK_INT >= 9) {
        break label556;
      }
      paramPrivExtV2Rsp.commit();
    }
    for (;;)
    {
      bhyh.a().a(this.app, localVipUserInfo);
      return;
      label556:
      paramPrivExtV2Rsp.apply();
    }
  }
  
  private void a(VipMedalList paramVipMedalList, String paramString)
  {
    this.r = null;
    if (paramVipMedalList == null)
    {
      QLog.e("QVipSettingMe." + q, 1, "medal info is null!");
      return;
    }
    if (paramVipMedalList.bUpdate == 0)
    {
      QLog.e("QVipSettingMe." + q, 1, "bUpdate=" + paramVipMedalList.bUpdate + " it do not need to update medal info");
      return;
    }
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramString = localanvk.d(paramString);
    paramVipMedalList = MedalList.parse(paramVipMedalList);
    if (paramVipMedalList != null) {}
    try
    {
      paramString.medalsInfo = paramVipMedalList.convert();
      this.r = paramString.medalsInfo;
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe." + q, 1, "medalList receiver form service :" + paramString.medalsInfo);
      }
      localanvk.a(paramString);
      return;
    }
    catch (JSONException paramVipMedalList)
    {
      for (;;)
      {
        QLog.e("QVipSettingMe." + q, 1, "medalList convert faile :" + paramVipMedalList);
      }
    }
  }
  
  public static void a(String paramString, PayRuleCfg paramPayRuleCfg)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(q, 1, "writePayRule: empty uin");
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramPayRuleCfg);
      ThreadManager.getSubThreadHandler().post(new VipInfoHandler.1(paramString, paramPayRuleCfg));
      return;
    }
  }
  
  private void a(ArrayList<ItemCfgInfo> paramArrayList, String paramString)
  {
    if (paramArrayList == null)
    {
      QLog.e("QVipSettingMe." + q, 1, "NamePlateCfgInfo is null!");
      return;
    }
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramString = localanvk.d(paramString);
    try
    {
      paramString.nameplateCfgInfo = NamePlateCfgInfo.convert2Json(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe." + q, 2, "handleNamePlateCfgInfoRsp cfginfo :\n " + paramString.nameplateCfgInfo);
      }
      localanvk.a(paramString);
      return;
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        paramArrayList.printStackTrace();
      }
    }
  }
  
  private static boolean a(PayRuleCfg paramPayRuleCfg1, PayRuleCfg paramPayRuleCfg2)
  {
    if (paramPayRuleCfg1 == paramPayRuleCfg2) {
      return true;
    }
    if ((paramPayRuleCfg1 == null) || (paramPayRuleCfg2 == null)) {
      return false;
    }
    return Arrays.equals(JceUtils.encodeWup(paramPayRuleCfg1), JceUtils.encodeWup(paramPayRuleCfg2));
  }
  
  private boolean a(PrivExtV2Rsp paramPrivExtV2Rsp)
  {
    if (paramPrivExtV2Rsp.data_flag != null) {
      IliveDbManager.saveIliveDrawerData("drawer_trace_info", paramPrivExtV2Rsp.data_flag.trace_info);
    }
    IliveDbManager.saveIliveData(paramPrivExtV2Rsp.isQQLivePgc, paramPrivExtV2Rsp.qqLiveMsg);
    bhzf.a(this.app, "setting_me_vip_sync_freq", paramPrivExtV2Rsp.iSyncFreq);
    if ((paramPrivExtV2Rsp.data_flag != null) && (paramPrivExtV2Rsp.data_flag.has_priv_base == 0))
    {
      QLog.e(q, 1, "getVipInfo PrivExtV2Rsp has_priv_base = 0");
      return true;
    }
    QLog.e(q, 1, "getVipInfo PrivExtV2Rsp has_priv_base = 1 , return vip data");
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, PayRuleCfg paramPayRuleCfg, boolean paramBoolean)
  {
    if ((paramPayRuleCfg != null) && (paramPayRuleCfg.enable == 1) && (paramPayRuleCfg.rule != null)) {}
    Object localObject;
    switch (paramPayRuleCfg.rule.showType)
    {
    default: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("needShowPayButton: cfg=").append(paramPayRuleCfg).append(" enable=");
        if (paramPayRuleCfg != null) {
          break label379;
        }
      }
      break;
    }
    label379:
    for (paramQQAppInterface = Boolean.valueOf(false);; paramQQAppInterface = Integer.valueOf(paramPayRuleCfg.enable))
    {
      QLog.d("VipInfoHandler", 2, paramQQAppInterface);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_LIMIT_DAY count remain: " + paramPayRuleCfg.rule.showCount);
      }
      if (paramPayRuleCfg.rule.showCount > 0)
      {
        if (!paramBoolean)
        {
          localObject = paramPayRuleCfg.rule;
          ((ShowRule)localObject).showCount -= 1;
          a(paramQQAppInterface.getCurrentUin(), paramPayRuleCfg);
        }
        return true;
      }
      return false;
      long l1 = bhzf.a(paramQQAppInterface, "last_pull_pay_rule", 0L);
      long l2 = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_DATE " + paramPayRuleCfg.rule.showCount + " offset " + (l2 - l1));
      }
      return l2 - l1 < paramPayRuleCfg.rule.showCount * 24 * 3600L;
      l1 = NetConnInfoCenter.getServerTime();
      if (paramPayRuleCfg.rule.rangTimes != null)
      {
        paramQQAppInterface = paramPayRuleCfg.rule.rangTimes.iterator();
        while (paramQQAppInterface.hasNext())
        {
          paramPayRuleCfg = (ShowRangeTime)paramQQAppInterface.next();
          if ((paramPayRuleCfg.beginTime <= l1) && (l1 <= paramPayRuleCfg.endTime))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_TIME needShowPayButton");
            }
            return true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_TIME dontShow");
      }
      return false;
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PrivExtV2Rsp paramPrivExtV2Rsp, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString(jdField_a_of_type_JavaLangString);
      if (a(paramPrivExtV2Rsp))
      {
        bool = true;
        return bool;
      }
      Object localObject = paramPrivExtV2Rsp.vipInfo;
      a(paramPrivExtV2Rsp.medalInfoList, paramFromServiceMsg);
      label114:
      long l1;
      if (localObject != null) {
        if (((VipUserInfo)localObject).bUpdate == 0)
        {
          QLog.e("QVipSettingMe." + q, 1, "bUpdate=" + ((VipUserInfo)localObject).bUpdate + " it do not need to update vip info");
          bhyk.a(paramPrivExtV2Rsp.trafficResult, paramToServiceMsg.extraData);
          if ((localObject != null) && (((VipUserInfo)localObject).bUpdate == 1) && (paramPrivExtV2Rsp.trafficResult != null) && (paramPrivExtV2Rsp.trafficResult.bUpdate == 1) && (paramPrivExtV2Rsp.medalInfoList != null) && (paramPrivExtV2Rsp.medalInfoList.bUpdate == 1)) {
            bhzf.a(this.app, "setting_me_get_vip_info_sequence", NetConnInfoCenter.getServerTime());
          }
          bhzf.a(this.app, "setting_me_last_request_success_time", NetConnInfoCenter.getServerTime());
          if ((paramPrivExtV2Rsp.medalInfoList != null) && (paramPrivExtV2Rsp.medalInfoList.bUpdate == 1))
          {
            if (QZoneVipInfoManager.getInstance().getVipType() <= 0) {
              break label766;
            }
            l1 = 1L;
            label233:
            bhzf.a(this.app, "key_long_setting_me_vip_medal_list_record", l1);
          }
          paramToServiceMsg = paramPrivExtV2Rsp.itemCfgList;
          if (paramToServiceMsg != null)
          {
            l1 = bhzf.a(this.app, "name_plate_config_version", 0L);
            localObject = NamePlateCfgInfo.getVipNamePlateCfgInfo(this.app, paramFromServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.i("QVipSettingMe." + q, 2, "vipinfo NamePlate response localVersion = " + l1 + " netVersion = " + paramToServiceMsg.iItemCfgVer + " \nlocalCfgInfo = " + (String)localObject);
            }
            if ((l1 != paramToServiceMsg.iItemCfgVer) || (TextUtils.isEmpty((CharSequence)localObject)))
            {
              bhzf.a(this.app, "name_plate_config_version", paramToServiceMsg.iItemCfgVer);
              a(paramPrivExtV2Rsp.itemCfgList.itemCfgInfo, paramFromServiceMsg);
            }
          }
          if (paramPrivExtV2Rsp.payRule == null) {
            break label772;
          }
          QLog.e(q, 1, new Object[] { "privExtRsp.payRule ", paramPrivExtV2Rsp.payRule.iconText, " url=", paramPrivExtV2Rsp.payRule.iconUrl, " update=", Integer.valueOf(paramPrivExtV2Rsp.payRule.update), " new:\n", a(paramPrivExtV2Rsp.payRule) });
          if (paramPrivExtV2Rsp.payRule.update == 1)
          {
            bhzf.a(this.app, "last_pull_pay_rule", NetConnInfoCenter.getServerTime());
            paramToServiceMsg = a(paramFromServiceMsg, "payRuleOrigin.cfg");
            bool = a(paramToServiceMsg, paramPrivExtV2Rsp.payRule);
            QLog.e(q, 1, new Object[] { "privExtRsp.payRule equals=" + bool, " old:\n", a(paramToServiceMsg) });
            if (!bool)
            {
              b(paramFromServiceMsg, "payRuleOrigin.cfg", paramPrivExtV2Rsp.payRule);
              a(paramFromServiceMsg, paramPrivExtV2Rsp.payRule);
              notifyUI(4, true, null);
            }
          }
          label610:
          if (paramPrivExtV2Rsp.qid_info != null)
          {
            paramToServiceMsg = this.app;
            if (paramPrivExtV2Rsp.qid_info.has_qid != 1) {
              break label785;
            }
          }
        }
      }
      label772:
      label785:
      for (boolean bool = true;; bool = false)
      {
        bhqa.a(paramToServiceMsg, bool);
        bhzf.a(this.app, "qid_info_login", paramPrivExtV2Rsp.qid_info.qid);
        if (paramPrivExtV2Rsp.map_menum != null) {
          bhze.a().a(this.app, paramPrivExtV2Rsp.map_menum);
        }
        bool = paramBoolean;
        if (paramPrivExtV2Rsp.qq_value == null) {
          break;
        }
        bibb.a(paramFromServiceMsg, paramPrivExtV2Rsp.qq_value);
        return paramBoolean;
        if ((((VipUserInfo)localObject).iOpenVip >= 0) && (((VipUserInfo)localObject).iOpenSVip >= 0))
        {
          a(paramPrivExtV2Rsp, paramFromServiceMsg);
          break label114;
        }
        paramBoolean = false;
        break label114;
        QLog.e("QVipSettingMe." + q, 1, "request vip user info rsp null!");
        break label114;
        label766:
        l1 = 0L;
        break label233;
        QLog.e(q, 1, "privExtRsp.payRule is null");
        break label610;
      }
    }
    QLog.e(q, 1, "ClubInfoSvc.queryPrivExt failed:" + paramFromServiceMsg.getBusinessFailCode());
    bjgx.a().a("ClubInfoSvc.queryPrivExt", 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, "[CMD:ClubInfoSvc.queryPrivExtfailed]", true);
    return paramBoolean;
  }
  
  private static void b(String paramString1, String arg1, PayRuleCfg paramPayRuleCfg)
  {
    paramString1 = new File(BaseApplicationImpl.getContext().getFilesDir(), paramString1 + File.separator + ???);
    paramPayRuleCfg = JceUtils.encodeWup(paramPayRuleCfg);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      FileUtils.writeFile(paramPayRuleCfg, paramString1.getAbsolutePath());
      return;
    }
  }
  
  public String a()
  {
    return this.r;
  }
  
  public void a(long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "VipCustom.GetCustomOnlineStatus");
    localToServiceMsg.extraData.putLong(n, paramLong);
    send(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "send to server");
    }
  }
  
  public void a(UniGetReq paramUniGetReq, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = createToServiceMsg("QCUniBusinessLogic.uniGet", paramBusinessObserver, paramBoolean);
    paramUniGetReq.stLogin = a();
    paramBusinessObserver.extraData.putSerializable("req", paramUniGetReq);
    send(paramBusinessObserver);
  }
  
  public void a(UniSetReq paramUniSetReq, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = createToServiceMsg("QCUniBusinessLogic.uniSet", paramBusinessObserver, paramBoolean);
    paramUniSetReq.stLogin = a();
    paramBusinessObserver.extraData.putSerializable("req", paramUniSetReq);
    send(paramBusinessObserver);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 1562146740L, "vip_other");
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
    localToServiceMsg.extraData.putString(jdField_a_of_type_JavaLangString, paramString2);
    localToServiceMsg.extraData.putInt(b, 1);
    localToServiceMsg.extraData.putString(c, paramString1);
    localToServiceMsg.extraData.putString(d, paramString3);
    if (paramLong > 0L) {
      localToServiceMsg.extraData.putLong(m, paramLong);
    }
    send(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("QVipSettingMe." + q, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.queryPrivExt seq=" + paramLong);
    }
    paramString3 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
    paramString3.extraData.putString(jdField_a_of_type_JavaLangString, paramString2);
    paramString3.extraData.putInt(b, 6);
    paramString3.extraData.putString(c, paramString1);
    send(paramString3);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3)
  {
    int i1 = 0;
    if ("ORDER".equals(paramString3)) {
      i1 = 1;
    }
    for (;;)
    {
      paramString3 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ClubInfoSvc.guanjiaReport");
      paramString3.extraData.putString(jdField_a_of_type_JavaLangString, paramString1);
      paramString3.extraData.putString(e, paramString2);
      paramString3.extraData.putBoolean(f, paramBoolean);
      paramString3.extraData.putInt(g, paramInt);
      paramString3.extraData.putInt(h, i1);
      send(paramString3);
      if (QLog.isColorLevel()) {
        QLog.d(q, 2, "guanjiaReport: isKingCard=" + paramBoolean);
      }
      return;
      if ("ACTIVESUCC".equals(paramString3)) {
        i1 = 2;
      } else if ("GOODCHG".equals(paramString3)) {
        i1 = 3;
      } else if ("CANCEL".equals(paramString3)) {
        i1 = 4;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    UniSetReq localUniSetReq = new UniSetReq();
    localUniSetReq.stUniBusinessItem = new UniBusinessItem();
    localUniSetReq.stUniBusinessItem.appid = 36;
    localUniSetReq.stUniBusinessItem.itemid = 0;
    localUniSetReq.stMessageShow = new MessageShow();
    localUniSetReq.stMessageShow.bOpen = paramBoolean;
    a(localUniSetReq, null, false);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return aogx.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    String str = paramToServiceMsg.getServiceCmd();
    int i1 = Integer.valueOf(paramToServiceMsg.extraData.getInt(b)).intValue();
    Long.valueOf(paramToServiceMsg.extraData.getLong(m)).longValue();
    boolean bool = paramFromServiceMsg.isSuccess();
    if ("ClubInfoSvc.queryPrivExt".equals(str))
    {
      if ((i1 == 6) && ((paramObject instanceof VAResourcesRsp)))
      {
        bhnz.a = System.currentTimeMillis() / 1000L;
        bhnz.a((VAResourcesRsp)paramObject);
        notifyUI(6, bool, paramObject);
        return;
      }
      if (i1 != 1) {
        break label423;
      }
      bool = a(paramToServiceMsg, paramFromServiceMsg, (PrivExtV2Rsp)paramObject, bool);
    }
    label423:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(q, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + bool);
      }
      notifyUI(1, bool, paramObject);
      return;
      if ("ClubInfoSvc.guanjiaReport".equals(str))
      {
        if (bool)
        {
          paramToServiceMsg = (GuanjiaReportRsp)paramObject;
          if (QLog.isColorLevel()) {
            QLog.d(q, 1, "onReceive: " + paramToServiceMsg.ret);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(q, 2, "onReceive: guanjiaReport,isSuccess=" + bool);
        return;
      }
      if ("VipCustom.GetCustomOnlineStatus".equals(str))
      {
        if (!bool) {
          break;
        }
        paramToServiceMsg = (GetCustomOnlineStatusRsp)paramObject;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "onReceive: CUSTOM_ONLINE_STATUS " + paramToServiceMsg.sMsg + " " + paramToServiceMsg.sMsg);
        }
        if (TextUtils.isEmpty(paramToServiceMsg.sBuffer)) {
          break;
        }
        try
        {
          paramFromServiceMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.sBuffer.getBytes());
          bhmx.a().a(paramFromServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          QLog.d(q, 1, paramToServiceMsg, new Object[0]);
          return;
        }
      }
      if ("QCUniBusinessLogic.uniSet".equals(str))
      {
        notifyUI(paramToServiceMsg, 2, bool, paramObject);
        return;
      }
      if (!"QCUniBusinessLogic.uniGet".equals(str)) {
        break;
      }
      notifyUI(paramToServiceMsg, 3, bool, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogw
 * JD-Core Version:    0.7.0.1
 */