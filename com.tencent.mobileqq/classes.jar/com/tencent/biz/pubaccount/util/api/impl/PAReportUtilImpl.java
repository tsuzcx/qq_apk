package com.tencent.biz.pubaccount.util.api.impl;

import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mp.mobileqq_mp.ReportPublicAccountRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PAReportUtilImpl
  implements IPAReportUtil
{
  public static final String COMMAND_READ_AD_MSG = "read_ad_msg";
  public static final String COMMAND_SEND_AD_RECEIPT = "send_ad_receipt";
  public static final String SSO_COMMAND_REPORT = "ad_report";
  public static final String TAG = "PAReport";
  
  private static void reportClickEventRuntime(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (paramAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "r2 or mainAction or tag or app is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int j = paramList.size();
      if (j > 0)
      {
        ((StringBuilder)localObject).append((String)paramList.get(0));
        int i = 1;
        while (i < j)
        {
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append((String)paramList.get(i));
          i += 1;
        }
      }
      QLog.d("PAReport", 2, "Reporting: " + paramString1 + "|" + paramString2 + "|" + paramString3 + "|" + paramString4 + "|" + paramString5 + "|" + paramInt1 + "|" + paramInt2 + "|" + paramInt3 + "|" + paramString6 + "|" + paramString7 + "|" + paramString8 + "|" + ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(paramAppInterface.getApplication(), PublicAccountServletImpl.class);
    ((NewIntent)localObject).putExtra("cmd", "PubAccountAdSvc.");
    mobileqq_mp.ReportPublicAccountRequest localReportPublicAccountRequest = new mobileqq_mp.ReportPublicAccountRequest();
    localReportPublicAccountRequest.tag.set(paramString1);
    localReportPublicAccountRequest.mainAction.set(paramString2);
    localReportPublicAccountRequest.toUin.set(paramString3);
    localReportPublicAccountRequest.subAction.set(paramString4);
    localReportPublicAccountRequest.actionName.set(paramString5);
    localReportPublicAccountRequest.fromType.set(paramInt1);
    localReportPublicAccountRequest.count.set(paramInt2);
    localReportPublicAccountRequest.result.set(paramInt3);
    localReportPublicAccountRequest.r2.set(paramString6);
    localReportPublicAccountRequest.r3.set(paramString7);
    localReportPublicAccountRequest.r4.set(paramString8);
    localReportPublicAccountRequest.r5.set(paramList);
    ((NewIntent)localObject).putExtra("data", localReportPublicAccountRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new PAReportUtilImpl.1(paramAppInterface, paramList, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8));
    paramAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void reportAdMsgArriveReceipt(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "sendAdArriveReceipt report");
    }
    long l = NetConnInfoCenter.getServerTime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str = AppSetting.e();
      localJSONObject.put("puin", paramString3);
      localJSONObject.put("q_user_agent", str);
      localJSONObject.put("gdt_imp_data", paramString4);
      localJSONObject.put("view_id", paramString5);
      reportClickEventRuntime(paramAppInterface, "P_CliOper", "Pb_account_lifeservice", paramAppInterface.getAccount(), paramString1, paramString2, 0, 1, 0, "send_ad_receipt", String.valueOf(l * 1000L), localJSONObject.toString(), paramList);
      return;
    }
    catch (JSONException paramString3)
    {
      for (;;)
      {
        paramString3.printStackTrace();
      }
    }
  }
  
  public void reportAdMsgRead(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "reportAdMsgRead report msgId size = " + paramList2.size());
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str1 = AppSetting.e();
      String str2 = MobileInfoUtil.a();
      String str3 = MobileInfoUtil.d();
      String str4 = Settings.Secure.getString(paramAppInterface.getApp().getContentResolver(), "android_id");
      String str5 = MobileInfoUtil.c();
      JSONArray localJSONArray = new JSONArray();
      int j = paramList1.size();
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(i, paramList1.get(i));
        i += 1;
      }
      localJSONObject.put("puin", paramString3);
      localJSONObject.put("q_user_agent", str1);
      localJSONObject.put("hardware_addr", str2);
      localJSONObject.put("mobile_imsi", str3);
      localJSONObject.put("mobile_android_id", str4);
      localJSONObject.put("mobile_imei", str5);
      localJSONObject.put("gdt_cli_data", localJSONArray);
      paramString3 = new JSONArray();
      j = paramList3.size();
      i = 0;
      while (i < j)
      {
        paramString3.put(i, paramList3.get(i));
        i += 1;
      }
      localJSONObject.put("view_id", paramString3);
    }
    catch (JSONException paramString3)
    {
      for (;;)
      {
        long l;
        paramString3.printStackTrace();
      }
    }
    l = NetConnInfoCenter.getServerTime();
    reportClickEventRuntime(paramAppInterface, "P_CliOper", "Pb_account_lifeservice", paramAppInterface.getAccount(), paramString1, paramString2, 0, 1, 0, "read_ad_msg", String.valueOf(l * 1000L), localJSONObject.toString(), paramList2);
  }
  
  public void reportClickEventForAdver(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "reportClickEventForAdver send: " + paramString1 + "r4:" + paramString2 + "r5:" + paramString3);
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.getApplication(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "PubAccountAdSvc.");
    mobileqq_mp.ReportPublicAccountRequest localReportPublicAccountRequest = new mobileqq_mp.ReportPublicAccountRequest();
    localReportPublicAccountRequest.tag.set("P_CliOper");
    localReportPublicAccountRequest.mainAction.set("Pb_account_lifeservice");
    localReportPublicAccountRequest.toUin.set(paramString1);
    localReportPublicAccountRequest.subAction.set("");
    localReportPublicAccountRequest.actionName.set("");
    localReportPublicAccountRequest.fromType.set(0);
    localReportPublicAccountRequest.count.set(1);
    localReportPublicAccountRequest.result.set(0);
    localReportPublicAccountRequest.r2.set("click_ad_msg");
    long l = NetConnInfoCenter.getServerTime();
    localReportPublicAccountRequest.r3.set(String.valueOf(l * 1000L));
    localReportPublicAccountRequest.r4.set(paramString2);
    paramString1 = new ArrayList();
    paramString1.add(paramString3);
    localReportPublicAccountRequest.r5.set(paramString1);
    localNewIntent.putExtra("data", localReportPublicAccountRequest.toByteArray());
    localNewIntent.setObserver(new PAReportUtilImpl.2(this));
    paramAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PAReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */