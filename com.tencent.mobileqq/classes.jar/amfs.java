import MQQ.GuanjiaReportRsp;
import MQQ.ItemCfgInfo;
import MQQ.ItemCfgList;
import MQQ.PayRuleCfg;
import MQQ.PrivExtV2Rsp;
import MQQ.ShowRangeTime;
import MQQ.ShowRule;
import MQQ.TrafficResultInfo;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler.1;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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

public class amfs
  extends alpd
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
  private static String p = "VipInfoHandler";
  private String q;
  
  static
  {
    jdField_a_of_type_JavaLangString = "k_uin";
    b = "k_type";
    c = "k_skey";
    d = "k_phone_num";
    jdField_e_of_type_JavaLangString = "k_is_king_card";
    jdField_f_of_type_JavaLangString = "k_card_type";
    g = "k_card_status";
    h = "k_hasImsi";
    i = "key_has_double_imsi";
    j = "key_imsi_one";
    k = "key_imsi_two";
    l = "k_sequence";
    m = "uin";
    n = "login_info";
    o = "state";
  }
  
  public amfs(QQAppInterface paramQQAppInterface)
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
    paramQQAppInterface = (alto)paramQQAppInterface.getManager(51);
    int i1;
    label35:
    int i2;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = null;
      if (paramQQAppInterface == null) {
        break label119;
      }
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label102;
      }
      i1 = 1;
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label107;
      }
      i2 = 1;
      label48:
      int i4 = paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
      if (paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_QQVIP) + i4 > 0) {
        break label113;
      }
      label70:
      if (i2 != 1) {
        break label129;
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
      label102:
      i1 = 0;
      break label35;
      label107:
      i2 = 0;
      break label48;
      label113:
      i3 = 1;
      break label70;
      label119:
      if (paramBoolean) {
        return 99;
      }
      return 98;
      label129:
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
      QLog.e(p, 1, "getPayRule: empty uin");
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
      paramString2 = bdhb.a(paramString2);
      if (paramString2 != null) {
        return (PayRuleCfg)bjuf.a(PayRuleCfg.class, paramString2);
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
      localLoginInfo.sClientVer = bdgk.c();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e(p, 1, localException, new Object[0]);
    }
    return null;
  }
  
  public static String a(PayRuleCfg paramPayRuleCfg)
  {
    if (paramPayRuleCfg == null) {
      return "null";
    }
    return Base64.encodeToString(bjuf.a(paramPayRuleCfg), 2) + "\n" + paramPayRuleCfg;
  }
  
  public static void a(int paramInt, String paramString)
  {
    bkgq localbkgq = new bkgq();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbkgq.b = (str + "_" + l1);
    localbkgq.jdField_a_of_type_Int = 1;
    localbkgq.jdField_e_of_type_JavaLangString = "tianshu.47";
    localbkgq.jdField_f_of_type_JavaLangString = "tianshu.47";
    localbkgq.g = paramString;
    localbkgq.h = "";
    localbkgq.jdField_a_of_type_Long = l1;
    localbkgq.d = paramInt;
    localbkgq.jdField_e_of_type_Int = 1;
    localbkgq.jdField_f_of_type_Int = 1;
    bkgp.a().a(localbkgq);
  }
  
  private void a(@NonNull PrivExtV2Rsp paramPrivExtV2Rsp, String paramString)
  {
    paramPrivExtV2Rsp = paramPrivExtV2Rsp.vipInfo;
    if (paramPrivExtV2Rsp == null) {
      return;
    }
    alto localalto = (alto)this.app.getManager(51);
    Friends localFriends = localalto.d(paramString);
    localFriends.qqVipInfo = a(paramPrivExtV2Rsp, 1, localFriends.qqVipInfo);
    localFriends.superVipInfo = a(paramPrivExtV2Rsp, 2, localFriends.superVipInfo);
    SharedPreferences localSharedPreferences = this.app.getApplication().getApplicationContext().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (paramPrivExtV2Rsp.iUpdateTime > 0L) {
      localSharedPreferences.edit().putLong("sp_vip_info_request_time", paramPrivExtV2Rsp.iUpdateTime);
    }
    if (paramPrivExtV2Rsp.iUpdateFreq > 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_update_freq", paramPrivExtV2Rsp.iUpdateFreq);
    }
    if (paramPrivExtV2Rsp.iCanUseRed >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", paramPrivExtV2Rsp.iCanUseRed);
    }
    if (paramPrivExtV2Rsp.iRedDisable >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramPrivExtV2Rsp.iRedDisable);
    }
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramPrivExtV2Rsp.iRedPackId);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramPrivExtV2Rsp.sRedPackRemard);
    localSharedPreferences.edit().commit();
    if (QLog.isColorLevel()) {
      QLog.d(p, 2, "redpacketinfo : icanusedred = " + paramPrivExtV2Rsp.iCanUseRed + ";iRedDisable = " + paramPrivExtV2Rsp.iRedDisable + "iRedPacketId = " + paramPrivExtV2Rsp.iRedPackId + ";sRedPackRemard = " + paramPrivExtV2Rsp.sRedPackRemard);
    }
    localalto.a(localFriends);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.app.getAccount())) && ((paramPrivExtV2Rsp.iCanUseRed >= 0) || (paramPrivExtV2Rsp.iRedDisable >= 0)))
    {
      paramString = (alvg)this.app.getManager(131);
      paramString.a(paramPrivExtV2Rsp.iCanUseRed, paramPrivExtV2Rsp.iRedDisable, true);
      paramString.a(paramPrivExtV2Rsp.iRedPackId, paramPrivExtV2Rsp.sRedPackRemard);
    }
    paramString = paramPrivExtV2Rsp.sUri;
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(p, 2, "vip url = " + paramString);
      }
      paramString = this.app.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramString);
      if (Build.VERSION.SDK_INT >= 9) {
        break label508;
      }
      paramString.commit();
    }
    for (;;)
    {
      bdzx.a().a(this.app, paramPrivExtV2Rsp);
      return;
      label508:
      paramString.apply();
    }
  }
  
  private void a(VipMedalList paramVipMedalList, String paramString)
  {
    this.q = null;
    if (paramVipMedalList == null)
    {
      QLog.e("QVipSettingMe." + p, 1, "medal info is null!");
      return;
    }
    if (paramVipMedalList.bUpdate == 0)
    {
      QLog.e("QVipSettingMe." + p, 1, "bUpdate=" + paramVipMedalList.bUpdate + " it do not need to update medal info");
      return;
    }
    alto localalto = (alto)this.app.getManager(51);
    paramString = localalto.d(paramString);
    paramVipMedalList = MedalList.parse(paramVipMedalList);
    if (paramVipMedalList != null) {}
    try
    {
      paramString.medalsInfo = paramVipMedalList.convert();
      this.q = paramString.medalsInfo;
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe." + p, 1, "medalList receiver form service :" + paramString.medalsInfo);
      }
      localalto.a(paramString);
      return;
    }
    catch (JSONException paramVipMedalList)
    {
      for (;;)
      {
        QLog.e("QVipSettingMe." + p, 1, "medalList convert faile :" + paramVipMedalList);
      }
    }
  }
  
  public static void a(String paramString, PayRuleCfg paramPayRuleCfg)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(p, 1, "writePayRule: empty uin");
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
      QLog.e("QVipSettingMe." + p, 1, "NamePlateCfgInfo is null!");
      return;
    }
    alto localalto = (alto)this.app.getManager(51);
    paramString = localalto.d(paramString);
    try
    {
      paramString.nameplateCfgInfo = NamePlateCfgInfo.convert2Json(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe." + p, 2, "handleNamePlateCfgInfoRsp cfginfo :\n " + paramString.nameplateCfgInfo);
      }
      localalto.a(paramString);
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
    return Arrays.equals(bjuf.a(paramPayRuleCfg1), bjuf.a(paramPayRuleCfg2));
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
          a(paramQQAppInterface.c(), paramPayRuleCfg);
        }
        return true;
      }
      return false;
      long l1 = beat.a(paramQQAppInterface, "last_pull_pay_rule", 0L);
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
  
  private static void b(String paramString1, String arg1, PayRuleCfg paramPayRuleCfg)
  {
    paramString1 = new File(BaseApplicationImpl.getContext().getFilesDir(), paramString1 + File.separator + ???);
    paramPayRuleCfg = bjuf.a(paramPayRuleCfg);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      bdhb.a(paramPayRuleCfg, paramString1.getAbsolutePath());
      return;
    }
  }
  
  public String a()
  {
    return this.q;
  }
  
  public void a(long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "VipCustom.GetCustomOnlineStatus");
    localToServiceMsg.extraData.putLong(m, paramLong);
    send(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "send to server");
    }
  }
  
  public void a(UniGetReq paramUniGetReq, alpg paramalpg, boolean paramBoolean)
  {
    paramalpg = createToServiceMsg("QCUniBusinessLogic.uniGet", paramalpg, paramBoolean);
    paramUniGetReq.stLogin = a();
    paramalpg.extraData.putSerializable("req", paramUniGetReq);
    send(paramalpg);
  }
  
  public void a(UniSetReq paramUniSetReq, alpg paramalpg, boolean paramBoolean)
  {
    paramalpg = createToServiceMsg("QCUniBusinessLogic.uniSet", paramalpg, paramBoolean);
    paramUniSetReq.stLogin = a();
    paramalpg.extraData.putSerializable("req", paramUniSetReq);
    send(paramalpg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 1562146740L);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
    localToServiceMsg.extraData.putString(jdField_a_of_type_JavaLangString, paramString2);
    localToServiceMsg.extraData.putInt(b, 1);
    localToServiceMsg.extraData.putString(c, paramString1);
    if (paramLong > 0L) {
      localToServiceMsg.extraData.putLong(l, paramLong);
    }
    send(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("QVipSettingMe." + p, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.queryPrivExt seq=" + paramLong);
    }
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
      paramString3.extraData.putString(d, paramString2);
      paramString3.extraData.putBoolean(jdField_e_of_type_JavaLangString, paramBoolean);
      paramString3.extraData.putInt(jdField_f_of_type_JavaLangString, paramInt);
      paramString3.extraData.putInt(g, i1);
      send(paramString3);
      if (QLog.isColorLevel()) {
        QLog.d(p, 2, "guanjiaReport: isKingCard=" + paramBoolean);
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
  
  protected Class<? extends alpg> observerClass()
  {
    return amft.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject1;
    boolean bool1;
    label323:
    label711:
    label758:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = paramToServiceMsg.getServiceCmd();
            int i1 = Integer.valueOf(paramToServiceMsg.extraData.getInt(b)).intValue();
            Long.valueOf(paramToServiceMsg.extraData.getLong(l)).longValue();
            bool1 = paramFromServiceMsg.isSuccess();
            if ("ClubInfoSvc.queryPrivExt".equals(localObject1))
            {
              boolean bool2 = bool1;
              Object localObject2;
              long l1;
              if (i1 == 1)
              {
                if (!bool1) {
                  break label841;
                }
                paramFromServiceMsg = paramToServiceMsg.extraData.getString(jdField_a_of_type_JavaLangString);
                localObject1 = (PrivExtV2Rsp)paramObject;
                localObject2 = ((PrivExtV2Rsp)localObject1).vipInfo;
                a(((PrivExtV2Rsp)localObject1).medalInfoList, paramFromServiceMsg);
                if (localObject2 == null) {
                  break label790;
                }
                if (((VipUserInfo)localObject2).bUpdate != 0) {
                  break label758;
                }
                QLog.e("QVipSettingMe." + p, 1, "bUpdate=" + ((VipUserInfo)localObject2).bUpdate + " it do not need to update vip info");
                beaa.a(((PrivExtV2Rsp)localObject1).trafficResult, paramToServiceMsg.extraData);
                if ((localObject2 != null) && (((VipUserInfo)localObject2).bUpdate == 1) && (((PrivExtV2Rsp)localObject1).trafficResult != null) && (((PrivExtV2Rsp)localObject1).trafficResult.bUpdate == 1) && (((PrivExtV2Rsp)localObject1).medalInfoList != null) && (((PrivExtV2Rsp)localObject1).medalInfoList.bUpdate == 1)) {
                  beat.a(this.app, "setting_me_get_vip_info_sequence", NetConnInfoCenter.getServerTime());
                }
                beat.a(this.app, "setting_me_last_request_success_time", NetConnInfoCenter.getServerTime());
                beat.a(this.app, "setting_me_vip_sync_freq", ((PrivExtV2Rsp)localObject1).iSyncFreq);
                if ((((PrivExtV2Rsp)localObject1).medalInfoList != null) && (((PrivExtV2Rsp)localObject1).medalInfoList.bUpdate == 1))
                {
                  if (bjfh.a().a() <= 0) {
                    break label822;
                  }
                  l1 = 1L;
                  beat.a(this.app, "key_long_setting_me_vip_medal_list_record", l1);
                }
                paramToServiceMsg = ((PrivExtV2Rsp)localObject1).itemCfgList;
                if (paramToServiceMsg != null)
                {
                  l1 = beat.a(this.app, "name_plate_config_version", 0L);
                  localObject2 = NamePlateCfgInfo.getVipNamePlateCfgInfo(this.app, paramFromServiceMsg);
                  if (QLog.isColorLevel()) {
                    QLog.i("QVipSettingMe." + p, 2, "vipinfo NamePlate response localVersion = " + l1 + " netVersion = " + paramToServiceMsg.iItemCfgVer + " \nlocalCfgInfo = " + (String)localObject2);
                  }
                  if ((l1 != paramToServiceMsg.iItemCfgVer) || (TextUtils.isEmpty((CharSequence)localObject2)))
                  {
                    beat.a(this.app, "name_plate_config_version", paramToServiceMsg.iItemCfgVer);
                    a(((PrivExtV2Rsp)localObject1).itemCfgList.itemCfgInfo, paramFromServiceMsg);
                  }
                }
                if (((PrivExtV2Rsp)localObject1).payRule == null) {
                  break label828;
                }
                QLog.e(p, 1, new Object[] { "privExtRsp.payRule ", ((PrivExtV2Rsp)localObject1).payRule.iconText, " url=", ((PrivExtV2Rsp)localObject1).payRule.iconUrl, " update=", Integer.valueOf(((PrivExtV2Rsp)localObject1).payRule.update), " new:\n", a(((PrivExtV2Rsp)localObject1).payRule) });
                if (((PrivExtV2Rsp)localObject1).payRule.update == 1)
                {
                  beat.a(this.app, "last_pull_pay_rule", NetConnInfoCenter.getServerTime());
                  paramToServiceMsg = a(paramFromServiceMsg, "payRuleOrigin.cfg");
                  bool2 = a(paramToServiceMsg, ((PrivExtV2Rsp)localObject1).payRule);
                  QLog.e(p, 1, new Object[] { "privExtRsp.payRule equals=" + bool2, " old:\n", a(paramToServiceMsg) });
                  if (!bool2)
                  {
                    b(paramFromServiceMsg, "payRuleOrigin.cfg", ((PrivExtV2Rsp)localObject1).payRule);
                    a(paramFromServiceMsg, ((PrivExtV2Rsp)localObject1).payRule);
                    notifyUI(4, true, null);
                  }
                }
              }
              for (bool2 = bool1;; bool2 = bool1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(p, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + bool2);
                }
                notifyUI(1, bool2, paramObject);
                return;
                if ((((VipUserInfo)localObject2).iOpenVip >= 0) && (((VipUserInfo)localObject2).iOpenSVip >= 0))
                {
                  a((PrivExtV2Rsp)localObject1, paramFromServiceMsg);
                  break;
                }
                bool1 = false;
                break;
                QLog.e("QVipSettingMe." + p, 1, "request vip user info rsp null!");
                break;
                l1 = 0L;
                break label323;
                QLog.e(p, 1, "privExtRsp.payRule is null");
                break label711;
                QLog.e(p, 1, "ClubInfoSvc.queryPrivExt failed:" + paramFromServiceMsg.getBusinessFailCode());
                bfhz.a().a("ClubInfoSvc.queryPrivExt", 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, "[CMD:ClubInfoSvc.queryPrivExtfailed]", true);
              }
            }
            if (!"ClubInfoSvc.guanjiaReport".equals(localObject1)) {
              break;
            }
            if (bool1)
            {
              paramToServiceMsg = (GuanjiaReportRsp)paramObject;
              if (QLog.isColorLevel()) {
                QLog.d(p, 1, "onReceive: " + paramToServiceMsg.ret);
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d(p, 2, "onReceive: guanjiaReport,isSuccess=" + bool1);
          return;
          if (!"VipCustom.GetCustomOnlineStatus".equals(localObject1)) {
            break;
          }
        } while (!bool1);
        paramToServiceMsg = (GetCustomOnlineStatusRsp)paramObject;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "onReceive: CUSTOM_ONLINE_STATUS " + paramToServiceMsg.sMsg + " " + paramToServiceMsg.sMsg);
        }
      } while (TextUtils.isEmpty(paramToServiceMsg.sBuffer));
      try
      {
        paramFromServiceMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.sBuffer.getBytes());
        bdsp.a().a(paramFromServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.d(p, 1, paramToServiceMsg, new Object[0]);
        return;
      }
      if ("QCUniBusinessLogic.uniSet".equals(localObject1))
      {
        notifyUI(paramToServiceMsg, 2, bool1, paramObject);
        return;
      }
    } while (!"QCUniBusinessLogic.uniGet".equals(localObject1));
    label790:
    label822:
    label828:
    label841:
    notifyUI(paramToServiceMsg, 3, bool1, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfs
 * JD-Core Version:    0.7.0.1
 */