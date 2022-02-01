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
    if ((!TextUtils.isEmpty(paramString6)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (paramAppInterface != null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        int i = paramList.size();
        if (i > 0)
        {
          ((StringBuilder)localObject1).append((String)paramList.get(0));
          int j = 1;
          while (j < i)
          {
            ((StringBuilder)localObject1).append("|");
            ((StringBuilder)localObject1).append((String)paramList.get(j));
            j += 1;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Reporting: ");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramString3);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramString4);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramString5);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramString6);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramString7);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramString8);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
        QLog.d("PAReport", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = new NewIntent(paramAppInterface.getApplication(), PublicAccountServletImpl.class);
      ((NewIntent)localObject1).putExtra("cmd", "PubAccountAdSvc.");
      Object localObject2 = new mobileqq_mp.ReportPublicAccountRequest();
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).tag.set(paramString1);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).mainAction.set(paramString2);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).toUin.set(paramString3);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).subAction.set(paramString4);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).actionName.set(paramString5);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).fromType.set(paramInt1);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).count.set(paramInt2);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).result.set(paramInt3);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).r2.set(paramString6);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).r3.set(paramString7);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).r4.set(paramString8);
      ((mobileqq_mp.ReportPublicAccountRequest)localObject2).r5.set(paramList);
      ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.ReportPublicAccountRequest)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(new PAReportUtilImpl.1(paramAppInterface, paramList, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8));
      paramAppInterface.startServlet((NewIntent)localObject1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "r2 or mainAction or tag or app is null");
    }
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
    }
    catch (JSONException paramString3)
    {
      paramString3.printStackTrace();
    }
    reportClickEventRuntime(paramAppInterface, "P_CliOper", "Pb_account_lifeservice", paramAppInterface.getAccount(), paramString1, paramString2, 0, 1, 0, "send_ad_receipt", String.valueOf(l * 1000L), localJSONObject.toString(), paramList);
  }
  
  public void reportAdMsgRead(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportAdMsgRead report msgId size = ");
      ((StringBuilder)localObject).append(paramList2.size());
      QLog.d("PAReport", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    try
    {
      String str1 = AppSetting.e();
      String str2 = MobileInfoUtil.getLocalMacAddress();
      String str3 = MobileInfoUtil.getImsi();
      String str4 = Settings.Secure.getString(paramAppInterface.getApp().getContentResolver(), "android_id");
      String str5 = MobileInfoUtil.getImei();
      JSONArray localJSONArray = new JSONArray();
      int k = paramList1.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        localJSONArray.put(i, paramList1.get(i));
        i += 1;
      }
      ((JSONObject)localObject).put("puin", paramString3);
      ((JSONObject)localObject).put("q_user_agent", str1);
      ((JSONObject)localObject).put("hardware_addr", str2);
      ((JSONObject)localObject).put("mobile_imsi", str3);
      ((JSONObject)localObject).put("mobile_android_id", str4);
      ((JSONObject)localObject).put("mobile_imei", str5);
      ((JSONObject)localObject).put("gdt_cli_data", localJSONArray);
      paramString3 = new JSONArray();
      k = paramList3.size();
      i = j;
      while (i < k)
      {
        paramString3.put(i, paramList3.get(i));
        i += 1;
      }
      ((JSONObject)localObject).put("view_id", paramString3);
    }
    catch (JSONException paramString3)
    {
      paramString3.printStackTrace();
    }
    long l = NetConnInfoCenter.getServerTime();
    reportClickEventRuntime(paramAppInterface, "P_CliOper", "Pb_account_lifeservice", paramAppInterface.getAccount(), paramString1, paramString2, 0, 1, 0, "read_ad_msg", String.valueOf(l * 1000L), ((JSONObject)localObject).toString(), paramList2);
  }
  
  public void reportClickEventForAdver(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEventForAdver send: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("r4:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("r5:");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("PAReport", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(paramAppInterface.getApplication(), PublicAccountServletImpl.class);
    ((NewIntent)localObject).putExtra("cmd", "PubAccountAdSvc.");
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
    ((NewIntent)localObject).putExtra("data", localReportPublicAccountRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new PAReportUtilImpl.2(this));
    paramAppInterface.startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PAReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */