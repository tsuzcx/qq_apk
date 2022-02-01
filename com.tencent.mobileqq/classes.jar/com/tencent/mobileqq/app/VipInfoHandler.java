package com.tencent.mobileqq.app;

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
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.qzone.QUA;
import cooperation.qzone.util.JceUtils;
import cooperation.vip.manager.QZoneVipInfoManager;
import cooperation.vip.tianshu.TianShuManager;
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

public class VipInfoHandler
  extends BusinessHandler
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a = "k_uin";
  private static HashMap<String, PayRuleCfg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static String b = "k_type";
  public static String c = "k_skey";
  public static String d = "k_from";
  public static String e = "k_phone_num";
  public static String f = "k_is_king_card";
  public static String g = "k_card_type";
  public static String h = "k_card_status";
  public static String i = "k_hasImsi";
  public static String j = "key_has_double_imsi";
  public static String k = "key_imsi_one";
  public static String l = "key_imsi_two";
  public static String m = "k_sequence";
  public static String n = "uin";
  public static String o = "login_info";
  public static String p = "state";
  private static String q = "VipInfoHandler";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String r = null;
  
  VipInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(PayRuleCfg paramPayRuleCfg)
  {
    return (paramPayRuleCfg.clubType - 1) * 3 + paramPayRuleCfg.userType;
  }
  
  private int a(VipUserInfo paramVipUserInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipUserInfo != null) && (paramInt1 <= 2))
    {
      if (paramInt1 < 1) {
        return paramInt2;
      }
      if (1 == paramInt1) {
        paramInt1 = paramVipUserInfo.iOpenVip;
      } else {
        paramInt1 = paramVipUserInfo.iOpenSVip;
      }
      paramInt2 = (byte)paramVipUserInfo.iVipType;
      return (short)paramVipUserInfo.iVipLevel | (paramInt1 << 8 | paramInt2) << 16;
    }
    return paramInt2;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramQQAppInterface == null) {
      paramQQAppInterface = null;
    } else {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
    }
    if (paramQQAppInterface != null)
    {
      boolean bool1 = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      boolean bool2 = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      int i2 = paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
      int i3 = paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_QQVIP);
      int i1 = 1;
      if (i2 + i3 <= 0) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      if (bool2 == true) {
        i1 = 3;
      } else if (bool1 == true) {
        i1 = 4;
      } else if (i2 == 1) {
        i1 = 2;
      }
      i2 = i1;
      if (paramBoolean) {
        i2 = i1 + 4;
      }
      return i2;
    }
    if (paramBoolean) {
      return 99;
    }
    return 98;
  }
  
  public static PayRuleCfg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(q, 1, "getPayRule: empty uin");
      return null;
    }
    for (;;)
    {
      PayRuleCfg localPayRuleCfg;
      synchronized (jdField_a_of_type_JavaUtilHashMap)
      {
        localPayRuleCfg = (PayRuleCfg)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localPayRuleCfg != null) {
          return localPayRuleCfg;
        }
        localPayRuleCfg = a(paramString, "payRule.cfg");
        ??? = localPayRuleCfg;
        if (localPayRuleCfg == null)
        {
          ??? = new PayRuleCfg();
          ((PayRuleCfg)???).enable = 0;
        }
        synchronized (jdField_a_of_type_JavaUtilHashMap)
        {
          localPayRuleCfg = (PayRuleCfg)jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localPayRuleCfg == null)
          {
            jdField_a_of_type_JavaUtilHashMap.put(paramString, ???);
            return ???;
          }
        }
      }
      ??? = localPayRuleCfg;
    }
  }
  
  private static PayRuleCfg a(String arg0, String paramString2)
  {
    File localFile = BaseApplicationImpl.getContext().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(???);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    paramString2 = new File(localFile, localStringBuilder.toString());
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString2 = FileUtils.fileToBytes(paramString2);
      if (paramString2 != null) {
        return (PayRuleCfg)JceUtils.decodeWup(PayRuleCfg.class, paramString2);
      }
      return null;
    }
  }
  
  private LoginInfo a()
  {
    try
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(str1);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str1);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = str2;
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = DeviceInfoUtil.c();
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
    StringBuilder localStringBuilder = new StringBuilder(Base64.encodeToString(JceUtils.encodeWup(paramPayRuleCfg), 2));
    localStringBuilder.append("\n");
    localStringBuilder.append(paramPayRuleCfg);
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.47";
    localTianShuReportData.jdField_f_of_type_JavaLangString = "tianshu.47";
    localTianShuReportData.g = paramString;
    localTianShuReportData.h = "";
    localTianShuReportData.jdField_a_of_type_Long = l1;
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_f_of_type_Int = 1;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(@NonNull PrivExtV2Rsp paramPrivExtV2Rsp, String paramString)
  {
    VipUserInfo localVipUserInfo = paramPrivExtV2Rsp.vipInfo;
    Object localObject2 = paramPrivExtV2Rsp.medalInfoList;
    if (localVipUserInfo == null) {
      return;
    }
    paramPrivExtV2Rsp = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = paramPrivExtV2Rsp.d(paramString);
    ((Friends)localObject1).qqVipInfo = a(localVipUserInfo, 1, ((Friends)localObject1).qqVipInfo);
    ((Friends)localObject1).superVipInfo = a(localVipUserInfo, 2, ((Friends)localObject1).superVipInfo);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localVipUserInfo.iUpdateTime > 0L) {
      ((SharedPreferences)localObject3).edit().putLong("sp_vip_info_request_time", localVipUserInfo.iUpdateTime);
    }
    if (localVipUserInfo.iUpdateFreq > 0) {
      ((SharedPreferences)localObject3).edit().putInt("sp_vip_info_update_freq", localVipUserInfo.iUpdateFreq);
    }
    if (localVipUserInfo.iCanUseRed >= 0) {
      ((SharedPreferences)localObject3).edit().putInt("sp_vip_info_can_use_packet", localVipUserInfo.iCanUseRed);
    }
    if (localVipUserInfo.iRedDisable >= 0) {
      ((SharedPreferences)localObject3).edit().putInt("sp_vip_info_red_packet_disable", localVipUserInfo.iRedDisable);
    }
    ((SharedPreferences)localObject3).edit().putString("sp_vip_info_current_version", QUA.getQUA3());
    ((SharedPreferences)localObject3).edit().putInt("sp_vip_info_red_packet_id", localVipUserInfo.iRedPackId);
    ((SharedPreferences)localObject3).edit().putString("sp_vip_info_red_packet_text", localVipUserInfo.sRedPackRemard);
    ((SharedPreferences)localObject3).edit().putString("sp_vip_medal_lvl_jump_url", ((VipMedalList)localObject2).lvlJumpUrl);
    ((SharedPreferences)localObject3).edit().commit();
    if (QLog.isColorLevel())
    {
      localObject2 = q;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("redpacketinfo : icanusedred = ");
      ((StringBuilder)localObject3).append(localVipUserInfo.iCanUseRed);
      ((StringBuilder)localObject3).append(";iRedDisable = ");
      ((StringBuilder)localObject3).append(localVipUserInfo.iRedDisable);
      ((StringBuilder)localObject3).append("iRedPacketId = ");
      ((StringBuilder)localObject3).append(localVipUserInfo.iRedPackId);
      ((StringBuilder)localObject3).append(";sRedPackRemard = ");
      ((StringBuilder)localObject3).append(localVipUserInfo.sRedPackRemard);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    paramPrivExtV2Rsp.a((Friends)localObject1);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) && ((localVipUserInfo.iCanUseRed >= 0) || (localVipUserInfo.iRedDisable >= 0)))
    {
      paramPrivExtV2Rsp = (IndividualRedPacketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
      paramPrivExtV2Rsp.a(localVipUserInfo.iCanUseRed, localVipUserInfo.iRedDisable, true);
      paramPrivExtV2Rsp.a(localVipUserInfo.iRedPackId, localVipUserInfo.sRedPackRemard);
    }
    paramPrivExtV2Rsp = localVipUserInfo.sUri;
    if (!TextUtils.isEmpty(paramPrivExtV2Rsp))
    {
      if (QLog.isColorLevel())
      {
        paramString = q;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("vip url = ");
        ((StringBuilder)localObject1).append(paramPrivExtV2Rsp);
        QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
      }
      paramPrivExtV2Rsp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramPrivExtV2Rsp);
      if (Build.VERSION.SDK_INT < 9) {
        paramPrivExtV2Rsp.commit();
      } else {
        paramPrivExtV2Rsp.apply();
      }
    }
    AioVipDonateHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVipUserInfo);
  }
  
  private void a(VipMedalList paramVipMedalList, String paramString)
  {
    this.r = null;
    if (paramVipMedalList == null)
    {
      paramVipMedalList = new StringBuilder();
      paramVipMedalList.append("QVipSettingMe.");
      paramVipMedalList.append(q);
      QLog.e(paramVipMedalList.toString(), 1, "medal info is null!");
      return;
    }
    if (paramVipMedalList.bUpdate == 0)
    {
      paramString = new StringBuilder();
      paramString.append("QVipSettingMe.");
      paramString.append(q);
      paramString = paramString.toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bUpdate=");
      ((StringBuilder)localObject1).append(paramVipMedalList.bUpdate);
      ((StringBuilder)localObject1).append(" it do not need to update medal info");
      QLog.e(paramString, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramString = ((FriendsManager)localObject1).d(paramString);
    paramVipMedalList = MedalList.parse(paramVipMedalList);
    if (paramVipMedalList != null) {
      try
      {
        paramString.medalsInfo = paramVipMedalList.convert();
        this.r = paramString.medalsInfo;
        if (QLog.isColorLevel())
        {
          paramVipMedalList = new StringBuilder();
          paramVipMedalList.append("QVipSettingMe.");
          paramVipMedalList.append(q);
          paramVipMedalList = paramVipMedalList.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("medalList receiver form service :");
          ((StringBuilder)localObject2).append(paramString.medalsInfo);
          QLog.d(paramVipMedalList, 1, ((StringBuilder)localObject2).toString());
        }
      }
      catch (JSONException paramVipMedalList)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QVipSettingMe.");
        ((StringBuilder)localObject2).append(q);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("medalList convert faile :");
        localStringBuilder.append(paramVipMedalList);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
      }
    }
    ((FriendsManager)localObject1).a(paramString);
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
      paramArrayList = new StringBuilder();
      paramArrayList.append("QVipSettingMe.");
      paramArrayList.append(q);
      QLog.e(paramArrayList.toString(), 1, "NamePlateCfgInfo is null!");
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramString = localFriendsManager.d(paramString);
    try
    {
      paramString.nameplateCfgInfo = NamePlateCfgInfo.convert2Json(paramArrayList);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("QVipSettingMe.");
        paramArrayList.append(q);
        paramArrayList = paramArrayList.toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleNamePlateCfgInfoRsp cfginfo :\n ");
        localStringBuilder.append(paramString.nameplateCfgInfo);
        QLog.d(paramArrayList, 2, localStringBuilder.toString());
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    localFriendsManager.a(paramString);
  }
  
  private static boolean a(PayRuleCfg paramPayRuleCfg1, PayRuleCfg paramPayRuleCfg2)
  {
    if (paramPayRuleCfg1 == paramPayRuleCfg2) {
      return true;
    }
    if ((paramPayRuleCfg1 != null) && (paramPayRuleCfg2 != null)) {
      return Arrays.equals(JceUtils.encodeWup(paramPayRuleCfg1), JceUtils.encodeWup(paramPayRuleCfg2));
    }
    return false;
  }
  
  private boolean a(PrivExtV2Rsp paramPrivExtV2Rsp)
  {
    if (paramPrivExtV2Rsp.data_flag != null) {
      IliveDbManager.saveIliveDrawerData("drawer_trace_info", paramPrivExtV2Rsp.data_flag.trace_info);
    }
    IliveDbManager.saveIliveData(paramPrivExtV2Rsp.isQQLivePgc, paramPrivExtV2Rsp.qqLiveMsg);
    QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_vip_sync_freq", paramPrivExtV2Rsp.iSyncFreq);
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
    Object localObject;
    if ((paramPayRuleCfg != null) && (paramPayRuleCfg.enable == 1) && (paramPayRuleCfg.rule != null))
    {
      int i1 = paramPayRuleCfg.rule.showType;
      if (i1 != 1)
      {
        long l1;
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            l1 = QVipConfigManager.a(paramQQAppInterface, "last_pull_pay_rule", 0L);
            long l2 = NetConnInfoCenter.getServerTime();
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("needShowPayButton: _ESHOW_RANGE_DATE ");
              paramQQAppInterface.append(paramPayRuleCfg.rule.showCount);
              paramQQAppInterface.append(" offset ");
              paramQQAppInterface.append(l2 - l1);
              QLog.d("VipInfoHandler", 2, paramQQAppInterface.toString());
            }
            return l2 - l1 < paramPayRuleCfg.rule.showCount * 24 * 3600L;
          }
        }
        else
        {
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
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("needShowPayButton: _ESHOW_LIMIT_DAY count remain: ");
          ((StringBuilder)localObject).append(paramPayRuleCfg.rule.showCount);
          QLog.d("VipInfoHandler", 2, ((StringBuilder)localObject).toString());
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
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needShowPayButton: cfg=");
      ((StringBuilder)localObject).append(paramPayRuleCfg);
      ((StringBuilder)localObject).append(" enable=");
      if (paramPayRuleCfg == null) {
        paramQQAppInterface = Boolean.valueOf(false);
      } else {
        paramQQAppInterface = Integer.valueOf(paramPayRuleCfg.enable);
      }
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.d("VipInfoHandler", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PrivExtV2Rsp paramPrivExtV2Rsp, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (paramBoolean)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString(jdField_a_of_type_JavaLangString);
      if (a(paramPrivExtV2Rsp)) {
        return true;
      }
      Object localObject1 = paramPrivExtV2Rsp.vipInfo;
      a(paramPrivExtV2Rsp.medalInfoList, paramFromServiceMsg);
      Object localObject2;
      StringBuilder localStringBuilder;
      if (localObject1 != null)
      {
        if (((VipUserInfo)localObject1).bUpdate == 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("QVipSettingMe.");
          ((StringBuilder)localObject2).append(q);
          localObject2 = ((StringBuilder)localObject2).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("bUpdate=");
          localStringBuilder.append(((VipUserInfo)localObject1).bUpdate);
          localStringBuilder.append(" it do not need to update vip info");
          QLog.e((String)localObject2, 1, localStringBuilder.toString());
        }
        else if ((((VipUserInfo)localObject1).iOpenVip >= 0) && (((VipUserInfo)localObject1).iOpenSVip >= 0))
        {
          a(paramPrivExtV2Rsp, paramFromServiceMsg);
        }
        else
        {
          paramBoolean = false;
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QVipSettingMe.");
        ((StringBuilder)localObject2).append(q);
        QLog.e(((StringBuilder)localObject2).toString(), 1, "request vip user info rsp null!");
      }
      CUKingCardHelper.a(paramPrivExtV2Rsp.trafficResult, paramToServiceMsg.extraData);
      if ((localObject1 != null) && (((VipUserInfo)localObject1).bUpdate == 1) && (paramPrivExtV2Rsp.trafficResult != null) && (paramPrivExtV2Rsp.trafficResult.bUpdate == 1) && (paramPrivExtV2Rsp.medalInfoList != null) && (paramPrivExtV2Rsp.medalInfoList.bUpdate == 1)) {
        QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_get_vip_info_sequence", NetConnInfoCenter.getServerTime());
      }
      QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_last_request_success_time", NetConnInfoCenter.getServerTime());
      long l1;
      if ((paramPrivExtV2Rsp.medalInfoList != null) && (paramPrivExtV2Rsp.medalInfoList.bUpdate == 1))
      {
        if (QZoneVipInfoManager.a().a() > 0) {
          l1 = 1L;
        } else {
          l1 = 0L;
        }
        QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "key_long_setting_me_vip_medal_list_record", l1);
      }
      paramToServiceMsg = paramPrivExtV2Rsp.itemCfgList;
      if (paramToServiceMsg != null)
      {
        l1 = QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "name_plate_config_version", 0L);
        localObject1 = NamePlateCfgInfo.getVipNamePlateCfgInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("QVipSettingMe.");
          ((StringBuilder)localObject2).append(q);
          localObject2 = ((StringBuilder)localObject2).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("vipinfo NamePlate response localVersion = ");
          localStringBuilder.append(l1);
          localStringBuilder.append(" netVersion = ");
          localStringBuilder.append(paramToServiceMsg.iItemCfgVer);
          localStringBuilder.append(" \nlocalCfgInfo = ");
          localStringBuilder.append((String)localObject1);
          QLog.i((String)localObject2, 2, localStringBuilder.toString());
        }
        if ((l1 != paramToServiceMsg.iItemCfgVer) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "name_plate_config_version", paramToServiceMsg.iItemCfgVer);
          a(paramPrivExtV2Rsp.itemCfgList.itemCfgInfo, paramFromServiceMsg);
        }
      }
      if (paramPrivExtV2Rsp.payRule != null)
      {
        QLog.e(q, 1, new Object[] { "privExtRsp.payRule ", paramPrivExtV2Rsp.payRule.iconText, " url=", paramPrivExtV2Rsp.payRule.iconUrl, " update=", Integer.valueOf(paramPrivExtV2Rsp.payRule.update), " new:\n", a(paramPrivExtV2Rsp.payRule) });
        if (paramPrivExtV2Rsp.payRule.update == 1)
        {
          QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "last_pull_pay_rule", NetConnInfoCenter.getServerTime());
          paramToServiceMsg = a(paramFromServiceMsg, "payRuleOrigin.cfg");
          boolean bool2 = a(paramToServiceMsg, paramPrivExtV2Rsp.payRule);
          localObject1 = q;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("privExtRsp.payRule equals=");
          ((StringBuilder)localObject2).append(bool2);
          QLog.e((String)localObject1, 1, new Object[] { ((StringBuilder)localObject2).toString(), " old:\n", a(paramToServiceMsg) });
          if (!bool2)
          {
            b(paramFromServiceMsg, "payRuleOrigin.cfg", paramPrivExtV2Rsp.payRule);
            a(paramFromServiceMsg, paramPrivExtV2Rsp.payRule);
            notifyUI(4, true, null);
          }
        }
      }
      else
      {
        QLog.e(q, 1, "privExtRsp.payRule is null");
      }
      if (paramPrivExtV2Rsp.qid_info != null)
      {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramPrivExtV2Rsp.qid_info.has_qid != 1) {
          bool1 = false;
        }
        VipQidHelper.a(paramToServiceMsg, bool1);
        QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "qid_info_login", paramPrivExtV2Rsp.qid_info.qid);
      }
      if (paramPrivExtV2Rsp.map_menum != null) {
        QQSettingConfigManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPrivExtV2Rsp.map_menum);
      }
      bool1 = paramBoolean;
      if (paramPrivExtV2Rsp.qq_value != null)
      {
        QQValueInfoManage.a().b(paramFromServiceMsg, paramPrivExtV2Rsp.qq_value);
        return paramBoolean;
      }
    }
    else
    {
      paramToServiceMsg = q;
      paramPrivExtV2Rsp = new StringBuilder();
      paramPrivExtV2Rsp.append("ClubInfoSvc.queryPrivExt failed:");
      paramPrivExtV2Rsp.append(paramFromServiceMsg.getBusinessFailCode());
      QLog.e(paramToServiceMsg, 1, paramPrivExtV2Rsp.toString());
      ReportCenter.a().a("ClubInfoSvc.queryPrivExt", 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, "[CMD:ClubInfoSvc.queryPrivExtfailed]", true);
      bool1 = paramBoolean;
    }
    return bool1;
  }
  
  private static void b(String paramString1, String arg1, PayRuleCfg paramPayRuleCfg)
  {
    File localFile = BaseApplicationImpl.getContext().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(???);
    paramString1 = new File(localFile, localStringBuilder.toString());
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
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "VipCustom.GetCustomOnlineStatus");
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
    Object localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
    ((ToServiceMsg)localObject).extraData.putString(jdField_a_of_type_JavaLangString, paramString2);
    ((ToServiceMsg)localObject).extraData.putInt(b, 1);
    ((ToServiceMsg)localObject).extraData.putString(c, paramString1);
    ((ToServiceMsg)localObject).extraData.putString(d, paramString3);
    if (paramLong > 0L) {
      ((ToServiceMsg)localObject).extraData.putLong(m, paramLong);
    }
    send((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("QVipSettingMe.");
      paramString3.append(q);
      paramString3 = paramString3.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.queryPrivExt seq=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d(paramString3, 2, ((StringBuilder)localObject).toString());
    }
    paramString3 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
    paramString3.extraData.putString(jdField_a_of_type_JavaLangString, paramString2);
    paramString3.extraData.putInt(b, 6);
    paramString3.extraData.putString(c, paramString1);
    send(paramString3);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3)
  {
    int i1;
    if ("ORDER".equals(paramString3)) {
      i1 = 1;
    } else if ("ACTIVESUCC".equals(paramString3)) {
      i1 = 2;
    } else if ("GOODCHG".equals(paramString3)) {
      i1 = 3;
    } else if ("CANCEL".equals(paramString3)) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    paramString3 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ClubInfoSvc.guanjiaReport");
    paramString3.extraData.putString(jdField_a_of_type_JavaLangString, paramString1);
    paramString3.extraData.putString(jdField_e_of_type_JavaLangString, paramString2);
    paramString3.extraData.putBoolean(jdField_f_of_type_JavaLangString, paramBoolean);
    paramString3.extraData.putInt(g, paramInt);
    paramString3.extraData.putInt(h, i1);
    send(paramString3);
    if (QLog.isColorLevel())
    {
      paramString1 = q;
      paramString2 = new StringBuilder();
      paramString2.append("guanjiaReport: isKingCard=");
      paramString2.append(paramBoolean);
      QLog.d(paramString1, 2, paramString2.toString());
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VipInfoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    String str = paramToServiceMsg.getServiceCmd();
    int i1 = Integer.valueOf(paramToServiceMsg.extraData.getInt(b)).intValue();
    Long.valueOf(paramToServiceMsg.extraData.getLong(m)).longValue();
    boolean bool2 = paramFromServiceMsg.isSuccess();
    if ("ClubInfoSvc.queryPrivExt".equals(str))
    {
      if ((i1 == 6) && ((paramObject instanceof VAResourcesRsp)))
      {
        PrettyAccountUtil.jdField_a_of_type_Long = System.currentTimeMillis() / 1000L;
        PrettyAccountUtil.a((VAResourcesRsp)paramObject);
        notifyUI(6, bool2, paramObject);
        return;
      }
      boolean bool1 = bool2;
      if (i1 == 1) {
        bool1 = a(paramToServiceMsg, paramFromServiceMsg, (PrivExtV2Rsp)paramObject, bool2);
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = q;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive: GetBaseVipInfoReq,isSuccess=");
        paramFromServiceMsg.append(bool1);
        QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
      }
      notifyUI(1, bool1, paramObject);
      return;
    }
    if ("ClubInfoSvc.guanjiaReport".equals(str))
    {
      if (bool2)
      {
        paramToServiceMsg = (GuanjiaReportRsp)paramObject;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = q;
          paramObject = new StringBuilder();
          paramObject.append("onReceive: ");
          paramObject.append(paramToServiceMsg.ret);
          QLog.d(paramFromServiceMsg, 1, paramObject.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = q;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive: guanjiaReport,isSuccess=");
        paramFromServiceMsg.append(bool2);
        QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
      }
    }
    else
    {
      if ("VipCustom.GetCustomOnlineStatus".equals(str))
      {
        if (!bool2) {
          return;
        }
        paramToServiceMsg = (GetCustomOnlineStatusRsp)paramObject;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onReceive: CUSTOM_ONLINE_STATUS ");
          paramFromServiceMsg.append(paramToServiceMsg.sMsg);
          paramFromServiceMsg.append(" ");
          paramFromServiceMsg.append(paramToServiceMsg.sMsg);
          QLog.d("CustomOnlineStatusManager", 2, paramFromServiceMsg.toString());
        }
        if (TextUtils.isEmpty(paramToServiceMsg.sBuffer)) {
          return;
        }
        try
        {
          paramFromServiceMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.sBuffer.getBytes());
          CustomOnlineStatusManager.a().a(paramFromServiceMsg);
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
        notifyUI(paramToServiceMsg, 2, bool2, paramObject);
        return;
      }
      if ("QCUniBusinessLogic.uniGet".equals(str)) {
        notifyUI(paramToServiceMsg, 3, bool2, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoHandler
 * JD-Core Version:    0.7.0.1
 */