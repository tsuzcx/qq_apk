package com.tencent.mobileqq.app;

import MQQ.PrivExtV2Rsp;
import MQQ.VipUserInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class VipInfoHandler
  extends BusinessHandler
{
  public static int a;
  static String a;
  static String b;
  static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  private static String h = "VipInfoHandler";
  
  static
  {
    jdField_a_of_type_JavaLangString = "k_uin";
    jdField_b_of_type_JavaLangString = "k_type";
    c = "k_skey";
    d = "k_hasImsi";
    e = "key_has_double_imsi";
    f = "key_imsi_one";
    g = "key_imsi_two";
    jdField_a_of_type_Int = 1;
  }
  
  VipInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
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
  
  private void a(VipUserInfo paramVipUserInfo, String paramString)
  {
    if (paramVipUserInfo == null) {
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Friends localFriends = localFriendsManager.b(paramString);
    localFriends.qqVipInfo = a(paramVipUserInfo, 1, localFriends.qqVipInfo);
    localFriends.superVipInfo = a(paramVipUserInfo, 2, localFriends.superVipInfo);
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    localSharedPreferences.edit().putLong("sp_vip_info_request_time", paramVipUserInfo.iUpdateTime);
    localSharedPreferences.edit().putInt("sp_vip_info_update_freq", paramVipUserInfo.iUpdateFreq);
    if (paramVipUserInfo.iCanUseRed >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", paramVipUserInfo.iCanUseRed);
    }
    if (paramVipUserInfo.iRedDisable >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramVipUserInfo.iRedDisable);
    }
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramVipUserInfo.iRedPackId);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramVipUserInfo.sRedPackRemard);
    localSharedPreferences.edit().commit();
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "redpacketinfo : icanusedred = " + paramVipUserInfo.iCanUseRed + ";iRedDisable = " + paramVipUserInfo.iRedDisable + "iRedPacketId = " + paramVipUserInfo.iRedPackId + ";sRedPackRemard = " + paramVipUserInfo.sRedPackRemard);
    }
    localFriendsManager.a(localFriends);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) && ((paramVipUserInfo.iCanUseRed >= 0) || (paramVipUserInfo.iRedDisable >= 0)))
    {
      paramString = (IndividualRedPacketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
      paramString.a(paramVipUserInfo.iCanUseRed, paramVipUserInfo.iRedDisable, true);
      paramString.a(paramVipUserInfo.iRedPackId, paramVipUserInfo.sRedPackRemard);
    }
    paramString = paramVipUserInfo.sUri;
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "vip url = " + paramString);
      }
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramString);
      if (Build.VERSION.SDK_INT >= 9) {
        break label475;
      }
      paramString.commit();
    }
    for (;;)
    {
      AioVipDonateHelper.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramVipUserInfo);
      return;
      label475:
      paramString.apply();
    }
  }
  
  protected Class a()
  {
    return VipInfoObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject;
    int i;
    boolean bool1;
    do
    {
      return;
      localObject = paramToServiceMsg.getServiceCmd();
      i = Integer.valueOf(paramToServiceMsg.extraData.getInt(jdField_b_of_type_JavaLangString)).intValue();
      bool1 = paramFromServiceMsg.isSuccess();
    } while (!"ClubInfoSvc.queryPrivExt".equals(localObject));
    boolean bool2 = bool1;
    if (i == jdField_a_of_type_Int)
    {
      if (!bool1) {
        break label182;
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getString(jdField_a_of_type_JavaLangString);
      localObject = (PrivExtV2Rsp)paramObject;
      VipUserInfo localVipUserInfo = ((PrivExtV2Rsp)localObject).vipInfo;
      if ((localVipUserInfo == null) || (localVipUserInfo.iOpenVip < 0) || (localVipUserInfo.iOpenSVip < 0)) {
        break label176;
      }
      a(localVipUserInfo, paramFromServiceMsg);
      CUKingCardHelper.a(((PrivExtV2Rsp)localObject).trafficResult, paramToServiceMsg.extraData);
    }
    for (bool2 = bool1;; bool2 = bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + bool2);
      }
      a(jdField_a_of_type_Int, bool2, paramObject);
      return;
      label176:
      bool1 = false;
      break;
      label182:
      ReportCenter.a().a("ClubInfoSvc.queryPrivExt", 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, "[CMD:ClubInfoSvc.queryPrivExtfailed]", true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
    localToServiceMsg.extraData.putString(jdField_a_of_type_JavaLangString, paramString2);
    localToServiceMsg.extraData.putInt(jdField_b_of_type_JavaLangString, jdField_a_of_type_Int);
    localToServiceMsg.extraData.putString(c, paramString1);
    a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.queryPrivExt");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoHandler
 * JD-Core Version:    0.7.0.1
 */