package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.now.ChannelRequest;
import com.tencent.mobileqq.now.ChannelResponse;
import com.tencent.mobileqq.now.NowAppHelper;
import com.tencent.mobileqq.now.NowManager;
import com.tencent.mobileqq.now.ReportReq;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NowHandler
  extends BusinessHandler
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = NowAppHelper.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_Int = 1;
  }
  
  protected NowHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(long paramLong, String paramString)
  {
    String str1 = DeviceInfoUtil.e();
    String str2 = String.valueOf(ApkUtils.a(BaseApplicationImpl.sApplication));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "query, clientTime=" + paramLong + ",nowChannel=" + paramString + ",qq_channel=" + "10001264" + ",qqVersionCode=" + str2 + ",deviceInfo=" + str1);
    }
    ChannelRequest localChannelRequest = new ChannelRequest();
    localChannelRequest.channel = paramString;
    localChannelRequest.qq_channel = "10001264";
    localChannelRequest.qq_version = str2;
    localChannelRequest.deviceInfo = str1;
    localChannelRequest.clientTime = paramLong;
    localChannelRequest.action_version = jdField_a_of_type_Int;
    paramString = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "NowChannelSvc.query");
    paramString.extraData.putSerializable("req", localChannelRequest);
    super.a(paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    boolean bool = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceive, cmd=" + paramToServiceMsg + ",isSucc=" + bool);
    }
    if (("NowChannelSvc.query".equals(paramToServiceMsg)) && (bool))
    {
      paramToServiceMsg = (ChannelResponse)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceive, resp.error_code=" + paramToServiceMsg.error_code);
      }
      paramFromServiceMsg = this.b.getApp().getSharedPreferences("key_now_conf", 0);
      if (paramToServiceMsg.error_code != -101) {
        break label177;
      }
      paramFromServiceMsg.edit().putBoolean("key_is_mf_channel", false).putLong("key_lastTime", System.currentTimeMillis() / 1000L).putLong("key_updateInternal", paramToServiceMsg.updateInternal).commit();
    }
    label177:
    while (paramToServiceMsg.error_code != 0) {
      return;
    }
    paramFromServiceMsg.edit().remove("key_is_mf_channel").commit();
    ((NowManager)this.b.getManager(197)).a(paramToServiceMsg);
    NowAppHelper.a(this.b, paramToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    String str1 = String.valueOf(NowAppHelper.b);
    String str2 = DeviceInfoUtil.a();
    int i = NetworkUtil.a(this.b.getApp());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "report, actionName=" + paramString1 + ",channel=" + str1 + ",netType=" + i + ",imei=" + str2 + ",ext1=" + paramString2 + ",ext2=" + paramString3 + ",ext3=" + paramString4 + ",ext4=" + paramString5 + ",result=" + paramInt);
    }
    ReportReq localReportReq = new ReportReq();
    localReportReq.uin = this.b.getCurrentAccountUin();
    localReportReq.action_name = paramString1;
    localReportReq.channel = str1;
    localReportReq.imei = str2;
    localReportReq.net_type = i;
    localReportReq.report_time = (System.currentTimeMillis() / 1000L);
    localReportReq.result = paramInt;
    localReportReq.ext1 = paramString2;
    localReportReq.ext2 = paramString3;
    localReportReq.ext3 = paramString4;
    localReportReq.ext4 = paramString5;
    paramString1 = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "NowChannelSvc.reportAction");
    paramString1.extraData.putSerializable("req", localReportReq);
    super.a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NowHandler
 * JD-Core Version:    0.7.0.1
 */