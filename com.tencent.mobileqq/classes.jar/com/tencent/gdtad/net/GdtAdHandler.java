package com.tencent.gdtad.net;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.ipc.AppInstallerReceiver;
import com.tencent.gdtad.statistics.GdtClickReporter;
import com.tencent.gdtad.util.GdtAppOpenUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet.Phone;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.AdInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.PosAdInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdReport;
import tencent.im.oidb.qqshop.qq_ad.QQAdReportRsp;

public class GdtAdHandler
  extends BusinessHandler
{
  public static int a;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  public long b;
  
  static
  {
    jdField_a_of_type_Int = 300000;
  }
  
  public GdtAdHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  /* Error */
  public static GdtAdHandler.ReportInfo a(GdtAdHandler.ReportInfo paramReportInfo, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aload_0
    //   5: areturn
    //   6: aload_1
    //   7: ldc 32
    //   9: invokevirtual 38	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 5
    //   14: aload_1
    //   15: ldc 40
    //   17: invokevirtual 38	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: ldc 42
    //   24: astore_3
    //   25: aload_1
    //   26: ldc 44
    //   28: invokevirtual 38	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 6
    //   33: aload_3
    //   34: astore_2
    //   35: new 46	org/json/JSONObject
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 49	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: ldc 51
    //   52: invokevirtual 54	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 56
    //   62: invokevirtual 54	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: astore_2
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 59	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   75: invokevirtual 65	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokestatic 71	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: putfield 75	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:jdField_a_of_type_Long	J
    //   84: aload_0
    //   85: aload_3
    //   86: putfield 78	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:k	Ljava/lang/String;
    //   89: aload_0
    //   90: aload 6
    //   92: putfield 80	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: aload 5
    //   98: putfield 83	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:l	Ljava/lang/String;
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 85	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 88	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:jdField_g_of_type_Int	I
    //   111: aload_0
    //   112: areturn
    //   113: astore_3
    //   114: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 96
    //   122: iconst_2
    //   123: ldc 98
    //   125: aload_3
    //   126: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: astore_3
    //   131: ldc 104
    //   133: astore_2
    //   134: goto -64 -> 70
    //   137: astore_1
    //   138: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -57 -> 84
    //   144: ldc 96
    //   146: iconst_2
    //   147: ldc 106
    //   149: aload_1
    //   150: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -69 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramReportInfo	GdtAdHandler.ReportInfo
    //   0	156	1	paramMessageRecord	MessageRecord
    //   34	100	2	localObject1	Object
    //   24	62	3	str1	String
    //   113	13	3	localException	Exception
    //   130	1	3	localObject2	Object
    //   20	48	4	localObject3	Object
    //   12	85	5	str2	String
    //   31	60	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   35	46	113	java/lang/Exception
    //   48	56	113	java/lang/Exception
    //   58	67	113	java/lang/Exception
    //   70	84	137	java/lang/Exception
  }
  
  private boolean a()
  {
    return NetworkUtil.h(BaseApplicationImpl.getContext());
  }
  
  private void b(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramGdtBaseAdItem.deepLinkUrl)))
    {
      AppInstallerReceiver.a().a(paramContext);
      AppInstallerReceiver.a().a(paramGdtBaseAdItem);
    }
  }
  
  protected Class a()
  {
    return GdtAdObserver.class;
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    GdtAdHandler.ReportInfo localReportInfo = new GdtAdHandler.ReportInfo();
    localReportInfo.jdField_a_of_type_Int = paramInt;
    a(localReportInfo, paramMessageRecord);
    a(localReportInfo, null);
  }
  
  public void a(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((paramContext == null) || (paramGdtBaseAdItem == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramGdtBaseAdItem.urlForClick)) {
      paramGdtBaseAdItem.setUrlForClick(paramGdtBaseAdItem.downloadScheme);
    }
    if (ApkUtils.a(paramGdtBaseAdItem.packageName, paramContext))
    {
      GdtClickReporter.a(paramGdtBaseAdItem.urlForClick);
      if (QLog.isColorLevel()) {
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled " + paramGdtBaseAdItem.packageName);
      }
      if (paramGdtBaseAdItem.openmain)
      {
        GdtAppOpenUtil.b(paramContext, paramGdtBaseAdItem);
        return;
      }
      GdtAppOpenUtil.a(paramContext, paramGdtBaseAdItem);
      return;
    }
    if (!TextUtils.isEmpty(paramGdtBaseAdItem.downloadScheme))
    {
      b(paramContext, paramGdtBaseAdItem);
      boolean bool = a();
      label137:
      String str;
      if ((bool) && (paramGdtBaseAdItem.autoDownLoad))
      {
        localObject = "1";
        if (!GdtAppOpenUtil.a(paramGdtBaseAdItem.downloadScheme)) {
          break label538;
        }
        if ((bool) && (TextUtils.isEmpty((String)GdtAppOpenUtil.a(paramGdtBaseAdItem.downloadScheme).get("acttype")))) {
          paramGdtBaseAdItem.downloadScheme += "&acttype=42";
        }
        if (TextUtils.isEmpty((String)GdtAppOpenUtil.a(paramGdtBaseAdItem.downloadScheme).get("wv"))) {
          paramGdtBaseAdItem.downloadScheme += "&wv=1";
        }
        str = (String)GdtAppOpenUtil.a(paramGdtBaseAdItem.downloadScheme).get("_autodownload");
        if (TextUtils.isEmpty(str)) {
          break label473;
        }
        if (!"1".equals(localObject)) {
          break label436;
        }
        paramGdtBaseAdItem.downloadScheme = paramGdtBaseAdItem.downloadScheme.replace("_autodownload=" + str, "_autodownload=" + (String)localObject);
        label331:
        if (paramGdtBaseAdItem.clz != null) {
          break label529;
        }
      }
      label529:
      for (Object localObject = QQBrowserActivity.class;; localObject = paramGdtBaseAdItem.clz)
      {
        localObject = new Intent(paramContext, (Class)localObject);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("url", paramGdtBaseAdItem.downloadScheme);
        ((Intent)localObject).addFlags(268435456);
        paramContext.startActivity((Intent)localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled not : custom H5 " + paramGdtBaseAdItem.packageName);
        return;
        localObject = "0";
        break label137;
        label436:
        paramGdtBaseAdItem.downloadScheme = paramGdtBaseAdItem.downloadScheme.replace("&_autodownload=" + str, "");
        break label331;
        label473:
        if (!"1".equals(localObject)) {
          break label331;
        }
        paramGdtBaseAdItem.downloadScheme = (paramGdtBaseAdItem.downloadScheme + "&" + "_autodownload" + "=" + (String)localObject);
        break label331;
      }
      label538:
      GdtClickReporter.a(paramGdtBaseAdItem.urlForClick);
      paramContext = (String)Common.a(paramGdtBaseAdItem.downloadScheme).get("auto_download");
      if (!TextUtils.isEmpty(paramContext)) {
        if ("1".equals(localObject)) {
          paramGdtBaseAdItem.downloadScheme = paramGdtBaseAdItem.downloadScheme.replace("auto_download=" + paramContext, "auto_download=" + (String)localObject);
        }
      }
      for (;;)
      {
        paramContext = new Bundle();
        paramContext.putInt("process_id", 1);
        paramContext.putString("schemaUrl", paramGdtBaseAdItem.downloadScheme);
        paramContext.putBoolean("is_can_open_yyb_native", false);
        GdtAppOpenUtil.a(paramContext);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled not : yingyongbao H5 " + paramGdtBaseAdItem.packageName);
        return;
        paramGdtBaseAdItem.downloadScheme = paramGdtBaseAdItem.downloadScheme.replace("&auto_download=" + paramContext, "");
        continue;
        if ("1".equals(localObject)) {
          paramGdtBaseAdItem.downloadScheme = (paramGdtBaseAdItem.downloadScheme + "&" + "auto_download" + "=" + (String)localObject);
        }
      }
    }
    QLog.e("GdtAdHandler", 1, "doAppJump download_url null " + paramGdtBaseAdItem.packageName);
  }
  
  public void a(GdtAdHandler.ReportInfo paramReportInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtAdHandler", 2, "do ad report info:" + paramReportInfo.toString());
    }
    qq_ad.QQAdReport localQQAdReport;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "SQQShopAdSdkReportSvr.AdReport";
      localQQAdReport = new qq_ad.QQAdReport();
      localQQAdReport.type.set(paramReportInfo.jdField_a_of_type_Int);
      localObject2 = localQQAdReport.view_id;
      if (paramReportInfo.jdField_a_of_type_JavaLangString != null) {
        break label626;
      }
      localObject1 = "";
      label84:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.trace_id;
      if (paramReportInfo.jdField_b_of_type_JavaLangString != null) {
        break label634;
      }
      localObject1 = "";
      label107:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.act_time.set((int)(System.currentTimeMillis() / 1000L));
      localObject2 = localQQAdReport.sns_uid;
      if (paramReportInfo.jdField_c_of_type_JavaLangString != null) {
        break label642;
      }
      localObject1 = "";
      label146:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.resolution;
      if (paramReportInfo.jdField_d_of_type_JavaLangString != null) {
        break label650;
      }
      localObject1 = "";
      label169:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.referer;
      if (paramReportInfo.jdField_e_of_type_JavaLangString != null) {
        break label658;
      }
      localObject1 = "";
      label192:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.user_agent;
      if (paramReportInfo.jdField_f_of_type_JavaLangString != null) {
        break label666;
      }
      localObject1 = "";
      label215:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.q_user_agent;
      if (paramReportInfo.jdField_g_of_type_JavaLangString != null) {
        break label674;
      }
      localObject1 = "";
      label238:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.feeds_index.set(paramReportInfo.jdField_b_of_type_Int);
      localQQAdReport.is_impression.set(paramReportInfo.jdField_a_of_type_Boolean);
      localQQAdReport.is_installed.set(paramReportInfo.jdField_b_of_type_Boolean);
      localObject2 = localQQAdReport.feeds_video_attachment;
      if (paramReportInfo.h != null) {
        break label682;
      }
      localObject1 = "";
      label297:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.platform_id.set(109);
      localObject2 = localQQAdReport.imei;
      if (MobileInfoUtil.c() != null) {
        break label690;
      }
      localObject1 = "";
      label329:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.click_source;
      if (paramReportInfo.i != null) {
        break label697;
      }
      localObject1 = "";
      label352:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.antispam_info;
      if (paramReportInfo.j != null) {
        break label705;
      }
      localObject1 = "";
      label375:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = DeviceInfoUtil.c(BaseApplicationImpl.getApplication().getApplicationContext());
      PBStringField localPBStringField = localQQAdReport.hardware_addr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localQQAdReport.stay_time.set(paramReportInfo.jdField_c_of_type_Int);
      localQQAdReport.net_type.set(HttpUtil.a());
      localQQAdReport.client_id.set(paramReportInfo.jdField_d_of_type_Int);
      localQQAdReport.action_id.set(paramReportInfo.jdField_e_of_type_Int);
      localQQAdReport.msg_floor.set(paramReportInfo.jdField_f_of_type_Int);
      localQQAdReport.puin.set(paramReportInfo.jdField_a_of_type_Long);
      localQQAdReport.ad_puin.set(paramReportInfo.jdField_b_of_type_Long);
      localQQAdReport.version.set("7.6.3");
      localObject2 = localQQAdReport.ad_id;
      if (paramReportInfo.k != null) {
        break label713;
      }
      localObject1 = "";
      label527:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.msgid;
      if (paramReportInfo.l != null) {
        break label721;
      }
    }
    label642:
    label650:
    label658:
    label666:
    label674:
    label682:
    label690:
    label697:
    label705:
    label713:
    label721:
    for (Object localObject1 = "";; localObject1 = paramReportInfo.l)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.get_back.set(false);
      localQQAdReport.source.set(paramReportInfo.jdField_g_of_type_Int);
      paramReportInfo = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
      paramReportInfo.putWupBuffer(localQQAdReport.toByteArray());
      super.b(paramReportInfo);
      return;
      Cmd2HandlerMap.a(paramString, new int[] { 110 });
      break;
      label626:
      localObject1 = paramReportInfo.jdField_a_of_type_JavaLangString;
      break label84;
      label634:
      localObject1 = paramReportInfo.jdField_b_of_type_JavaLangString;
      break label107;
      localObject1 = paramReportInfo.jdField_c_of_type_JavaLangString;
      break label146;
      localObject1 = paramReportInfo.jdField_d_of_type_JavaLangString;
      break label169;
      localObject1 = paramReportInfo.jdField_e_of_type_JavaLangString;
      break label192;
      localObject1 = paramReportInfo.jdField_f_of_type_JavaLangString;
      break label215;
      localObject1 = paramReportInfo.jdField_g_of_type_JavaLangString;
      break label238;
      localObject1 = paramReportInfo.h;
      break label297;
      localObject1 = MobileInfoUtil.c();
      break label329;
      localObject1 = paramReportInfo.i;
      break label352;
      localObject1 = paramReportInfo.j;
      break label375;
      localObject1 = paramReportInfo.k;
      break label527;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      if (("SQQShopAdSdkSvr.getAd".equals(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramToServiceMsg.getServiceCmd()))))
      {
        paramToServiceMsg = new qq_ad.QQAdGetRsp();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.pos_ads_info.has())
          {
            paramFromServiceMsg = paramToServiceMsg.pos_ads_info.get().iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (qq_ad.QQAdGetRsp.PosAdInfo)paramFromServiceMsg.next();
              if (paramObject.ads_info.has())
              {
                paramObject = paramObject.ads_info.get().iterator();
                while (paramObject.hasNext())
                {
                  qq_ad.QQAdGetRsp.AdInfo localAdInfo = (qq_ad.QQAdGetRsp.AdInfo)paramObject.next();
                  this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(localAdInfo.aid.get()));
                }
              }
            }
          }
          a(1, true, paramToServiceMsg);
        }
        catch (Exception paramFromServiceMsg)
        {
          a(2, false, paramToServiceMsg);
          QLog.e("GdtAdHandler", 2, "Get ad error:", paramFromServiceMsg);
          return;
        }
        return;
      }
      paramToServiceMsg = new qq_ad.QQAdReportRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel())
        {
          QLog.i("GdtAdHandler", 2, "rsp:" + JSONUtils.a(paramToServiceMsg));
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("GdtAdHandler", 2, "Report error:", paramToServiceMsg);
      }
    }
  }
  
  public void a(List paramList1, List paramList2, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtAdHandler", 2, "pull ad pos:" + paramList1 + ",count:" + paramList2 + ",syn:" + paramBoolean);
    }
    qq_ad.QQAdGet localQQAdGet;
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "SQQShopAdSdkSvr.getAd";
      localQQAdGet = new qq_ad.QQAdGet();
      qq_ad.QQAdGet.Phone localPhone = new qq_ad.QQAdGet.Phone();
      localPhone.carrier.set(DeviceInfoUtil.e());
      PBStringField localPBStringField = localPhone.muid;
      if (MobileInfoUtil.c() != null) {
        break label351;
      }
      str = "";
      label111:
      localPBStringField.set(str);
      localPhone.conn.set(HttpUtil.a());
      localPBStringField = localPhone.os_ver;
      if (Build.VERSION.RELEASE != null) {
        break label359;
      }
      str = "";
      label146:
      localPBStringField.set(str);
      localPhone.qq_ver.set("7.6.3");
      localPhone.os_type.set(2);
      localQQAdGet.net_info.set(localPhone);
      if (paramList1 != null) {
        localQQAdGet.pos_id.set(paramList1);
      }
      if (paramList2 != null) {
        localQQAdGet.ad_count.set(paramList2);
      }
      localQQAdGet.get_back.set(paramBoolean);
      localQQAdGet.last_req_time.set(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaUtilSet.size() <= 5) {
        break label367;
      }
      int i = this.jdField_a_of_type_JavaUtilSet.size();
      paramList1 = new Long[5];
      System.arraycopy(this.jdField_a_of_type_JavaUtilSet.toArray(), i - 5, paramList1, 0, 5);
    }
    label351:
    label359:
    label367:
    for (paramList1 = Arrays.asList(paramList1);; paramList1 = new ArrayList(this.jdField_a_of_type_JavaUtilSet))
    {
      if (paramList1 != null) {
        localQQAdGet.last_adid.set(paramList1);
      }
      paramList1 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
      paramList1.putWupBuffer(localQQAdGet.toByteArray());
      super.b(paramList1);
      this.jdField_a_of_type_Long = (System.currentTimeMillis() / 1000L);
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      break;
      str = MobileInfoUtil.c();
      break label111;
      str = Build.VERSION.RELEASE;
      break label146;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtAdHandler", 2, "On Running Foreground,login?" + this.jdField_a_of_type_Boolean + ",current interval:" + jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_b_of_type_Long <= jdField_a_of_type_Int);
    this.jdField_b_of_type_Long = l;
    a(null, null, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.net.GdtAdHandler
 * JD-Core Version:    0.7.0.1
 */