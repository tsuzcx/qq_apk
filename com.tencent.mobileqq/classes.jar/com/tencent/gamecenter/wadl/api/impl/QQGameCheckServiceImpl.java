package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameCheckServiceImpl
  implements IQQGameCheckService, WadlCmdListener
{
  private static final String LOAD_GAP = "load_gap";
  private static final String PRE_DOWNLOAD_LIST = "pre_download_list";
  private static final String PRE_UPDATE_LIST = "pre_update_list";
  private static final String RES_VALID = "res_valid";
  public static final String TAG = "Wadl_QQGameCheckServiceImpl";
  static HashSet<String> cmdMap = new HashSet();
  
  static
  {
    cmdMap.add("13625");
  }
  
  private boolean canAppointStart()
  {
    Object localObject = MobileQQ.sMobileQQ;
    if (NetworkUtil.isWifiConnected(MobileQQ.getContext()))
    {
      localObject = MobileQQ.sMobileQQ;
      localObject = (PowerManager)MobileQQ.getContext().getSystemService("power");
      if ((localObject != null) && (!((PowerManager)localObject).isScreenOn()) && ((GameCenterBroadcastReceiver.a >= 20) || (GameCenterBroadcastReceiver.b))) {
        return true;
      }
    }
    return false;
  }
  
  private void checkIfNeedToDownloadAppointApp(String[] paramArrayOfString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkIfNeedToDownloadAppointApp:");
    ((StringBuilder)localObject1).append(paramArrayOfString);
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject1).toString());
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length < 1) {
        return;
      }
      int j = paramArrayOfString.length;
      int k = 0;
      int i = 0;
      while (i < j)
      {
        localObject1 = paramArrayOfString[i];
        new WadlReportBuilder().a("dc00087").h("558").c("203701").b((String)localObject1).a(1, "55801").a(11, "4").a(12, "430").a();
        i += 1;
      }
      Object localObject2 = "";
      localObject1 = localObject2;
      i = 0;
      j = 0;
      Object localObject3;
      while (i < paramArrayOfString.length)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("APPOINT_APPID_DETAIL_");
        ((StringBuilder)localObject3).append(paramArrayOfString[i]);
        localObject3 = GameCenterSpUtils.a(((StringBuilder)localObject3).toString());
        try
        {
          localObject3 = new JSONObject((String)localObject3);
          long l1 = ((JSONObject)localObject3).optLong("downloadStartTime", 0L);
          long l2 = ((JSONObject)localObject3).optLong("downloadEndTime", 0L);
          long l3 = NetConnInfoCenter.getServerTime();
          if ((l1 <= l3) && (l3 <= l2))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(paramArrayOfString[i]);
            ((StringBuilder)localObject3).append("|");
            localObject3 = ((StringBuilder)localObject3).toString();
            j = 1;
            localObject1 = localObject3;
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(paramArrayOfString[i]);
            ((StringBuilder)localObject3).append("|");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject2 = localObject3;
          }
        }
        catch (Exception localException2)
        {
          label322:
          break label322;
        }
        i += 1;
      }
      if (j != 0) {
        GameCenterSpUtils.a("APPOINTMENT_LIST", (String)localObject2);
      }
      paramArrayOfString = ((String)localObject1).split("\\|");
      i = k;
      if (paramArrayOfString.length == 0) {
        return;
      }
      while (i < paramArrayOfString.length)
      {
        TextUtils.isEmpty(paramArrayOfString[i]);
        i += 1;
      }
      localObject1 = getParams(paramArrayOfString, "APPOINT_APPID_DETAIL_");
      if (((List)localObject1).size() < 1)
      {
        QLog.d("Wadl_QQGameCheckServiceImpl", 1, "checkIfNeedToDownloadAppointApp params.size=0");
        return;
      }
      paramArrayOfString = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("APPOINT_APPID_DETAIL_");
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject3 = GameCenterSpUtils.a(((StringBuilder)localObject3).toString());
        try
        {
          startDownload((String)localObject3, 1);
          GameCenterUtil.a((String)localObject2, "APPOINTMENT_DOWNLOAD_LIST");
          paramArrayOfString.put(localObject2);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      if (paramArrayOfString.length() > 0) {
        ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).reportDownloadStart(paramArrayOfString, null);
      }
    }
  }
  
  private void checkIfNeedToDownloadDelayApp(String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkIfNeedToDownloadDelayApp:");
    ((StringBuilder)localObject).append(paramArrayOfString);
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length < 1) {
        return;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfString[i];
        new WadlReportBuilder().a("dc00087").h("558").c("203713").b((String)localObject).a(1, "55801").a(11, "4").a(12, "430").a();
        i += 1;
      }
      GameCenterSpUtils.a("DELAY_LIST", "");
      paramArrayOfString = getParams(paramArrayOfString, "DELAY_APPID_DETAIL_");
      if (paramArrayOfString.size() == 0)
      {
        QLog.d("Wadl_QQGameCheckServiceImpl", 1, "checkIfNeedToDownloadDelayApp params.size=0");
        return;
      }
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        localObject = (String)paramArrayOfString.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DELAY_APPID_DETAIL_");
        localStringBuilder.append((String)localObject);
        localObject = GameCenterSpUtils.a(localStringBuilder.toString());
        try
        {
          startDownload((String)localObject, 2);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void checkIfNeedToDownloadTGPA(JSONArray paramJSONArray)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkIfNeedToDownloadTGPA jsonArray=");
    Object localObject1;
    if (paramJSONArray != null) {
      localObject1 = paramJSONArray.toString();
    } else {
      localObject1 = "empty";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject2).toString());
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() < 1) {
        return;
      }
      GameCenterSpUtils.a(new String[] { "APPOINTMENT_TGPA_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          Object localObject3 = paramJSONArray.optJSONObject(i);
          String str3 = ((JSONObject)localObject3).optString("appid");
          int j = ((JSONObject)localObject3).optInt("version_code");
          String str4 = ((JSONObject)localObject3).optString("app_name");
          int k = ((JSONObject)localObject3).optInt("package_type");
          localObject1 = ((JSONObject)localObject3).optString("package_name");
          localObject2 = ((JSONObject)localObject3).optString("package_src_url");
          int m = ((JSONObject)localObject3).optInt("package_index");
          String str1 = ((JSONObject)localObject3).optString("package_id");
          String str2 = ((JSONObject)localObject3).optString("package_md5");
          if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("checkIfNeedToDownloadTGPA packageName=");
            ((StringBuilder)localObject3).append(str4);
            ((StringBuilder)localObject3).append(",resType=");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(",appId=");
            ((StringBuilder)localObject3).append(str3);
            ((StringBuilder)localObject3).append(",resName=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(",srcUrl=");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(",versionCode=");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(",versionName=");
            ((StringBuilder)localObject3).append(str1);
            ((StringBuilder)localObject3).append(",resMD5=");
            ((StringBuilder)localObject3).append(str2);
            QLog.d("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject3).toString());
            if (((k != 0) || (GameCenterUtil.e)) && ((k != 1) || (GameCenterUtil.d)) && ((k != 4) || (GameCenterUtil.d)))
            {
              if (k == 1)
              {
                if (!GameCenterUtil.a(str4, j))
                {
                  QLog.d("Wadl_QQGameCheckServiceImpl", 1, "checkIfNeedToDownloadTGPA cancel, checkVersion=false");
                  break label684;
                }
              }
              else if (k == 4)
              {
                int n = GameCenterUtil.a(str4);
                if (n != -1)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("checkIfNeedToDownloadTGPA cancel, localVersion=");
                  ((StringBuilder)localObject1).append(n);
                  QLog.d("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject1).toString());
                  break label684;
                }
              }
              else
              {
                if ((k == 0) && (GameCenterUtil.a(0, str3, (String)localObject1))) {
                  break label684;
                }
              }
              localObject3 = new WadlParams(str3, str4);
              ((WadlParams)localObject3).a(2);
              ((WadlParams)localObject3).a(4);
              ((WadlParams)localObject3).b = 2;
              ((WadlParams)localObject3).jdField_a_of_type_Boolean = true;
              ((WadlParams)localObject3).jdField_g_of_type_Int = k;
              ((WadlParams)localObject3).d = 3;
              ((WadlParams)localObject3).jdField_e_of_type_JavaLangString = ((String)localObject2);
              ((WadlParams)localObject3).h = ((String)localObject1);
              ((WadlParams)localObject3).f = m;
              ((WadlParams)localObject3).jdField_g_of_type_JavaLangString = str1;
              ((WadlParams)localObject3).jdField_e_of_type_Int = j;
              ((WadlParams)localObject3).i = str2;
              ((WadlParams)localObject3).l = "auto_tgpa";
              WadlProxyServiceUtil.a().b((WadlParams)localObject3);
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkIfNeedToDownloadTGPA params check fail，jsonTmp=");
            ((StringBuilder)localObject1).append(((JSONObject)localObject3).toString());
            QLog.w("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject1).toString());
          }
        }
        catch (Exception localException)
        {
          QLog.e("Wadl_QQGameCheckServiceImpl", 1, "checkIfNeedToDownloadTGPA exception", localException);
        }
        label684:
        i += 1;
      }
    }
  }
  
  /* Error */
  private void checkIfNeedToDownloadUpdateApp(JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 5
    //   3: new 109	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   10: astore 6
    //   12: aload 6
    //   14: ldc_w 414
    //   17: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 6
    //   23: aload 5
    //   25: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 24
    //   31: iconst_1
    //   32: aload 6
    //   34: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 129	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 5
    //   42: ifnull +488 -> 530
    //   45: aload_1
    //   46: invokevirtual 259	org/json/JSONArray:length	()I
    //   49: iconst_1
    //   50: if_icmpge +4 -> 54
    //   53: return
    //   54: iconst_1
    //   55: anewarray 199	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 416
    //   63: aastore
    //   64: invokestatic 291	com/tencent/gamecenter/wadl/util/GameCenterSpUtils:a	([Ljava/lang/String;)Z
    //   67: pop
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: aload_1
    //   72: invokevirtual 259	org/json/JSONArray:length	()I
    //   75: if_icmpge +455 -> 530
    //   78: aload_1
    //   79: iload_2
    //   80: invokevirtual 295	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   83: astore 5
    //   85: aload 5
    //   87: ldc_w 297
    //   90: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 6
    //   95: aload 5
    //   97: ldc_w 302
    //   100: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   103: istore_3
    //   104: aload 5
    //   106: ldc_w 418
    //   109: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 10
    //   114: aload 5
    //   116: ldc_w 308
    //   119: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 7
    //   124: aload 5
    //   126: ldc_w 420
    //   129: ldc_w 422
    //   132: invokevirtual 425	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 8
    //   137: aload 5
    //   139: ldc_w 427
    //   142: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 9
    //   147: aload 5
    //   149: ldc_w 429
    //   152: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   155: istore 4
    //   157: aload 6
    //   159: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +295 -> 457
    //   165: aload 10
    //   167: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +287 -> 457
    //   173: aload 9
    //   175: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifne +279 -> 457
    //   181: new 131	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder
    //   184: dup
    //   185: invokespecial 132	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:<init>	()V
    //   188: ldc 134
    //   190: invokevirtual 137	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   193: ldc 139
    //   195: invokevirtual 142	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:h	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   198: ldc_w 431
    //   201: invokevirtual 147	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:c	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   204: aload 6
    //   206: invokevirtual 149	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:b	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   209: iconst_1
    //   210: ldc_w 433
    //   213: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   216: bipush 11
    //   218: ldc 156
    //   220: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   223: bipush 12
    //   225: ldc 158
    //   227: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   230: iconst_3
    //   231: ldc_w 435
    //   234: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   237: iconst_4
    //   238: ldc_w 437
    //   241: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   244: invokevirtual 160	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	()V
    //   247: aload 10
    //   249: iload_3
    //   250: iload 4
    //   252: invokestatic 440	com/tencent/gamecenter/wadl/util/GameCenterUtil:a	(Ljava/lang/String;II)Z
    //   255: ifne +118 -> 373
    //   258: new 131	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder
    //   261: dup
    //   262: invokespecial 132	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:<init>	()V
    //   265: ldc 134
    //   267: invokevirtual 137	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   270: ldc 139
    //   272: invokevirtual 142	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:h	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   275: ldc_w 431
    //   278: invokevirtual 147	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:c	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   281: aload 6
    //   283: invokevirtual 149	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:b	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   286: iconst_1
    //   287: ldc_w 442
    //   290: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   293: bipush 11
    //   295: ldc 156
    //   297: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   300: bipush 12
    //   302: ldc 158
    //   304: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   307: iconst_3
    //   308: ldc_w 435
    //   311: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   314: iconst_4
    //   315: ldc_w 437
    //   318: invokevirtual 154	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   321: invokevirtual 160	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	()V
    //   324: new 109	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   331: astore 5
    //   333: aload 5
    //   335: ldc_w 444
    //   338: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 5
    //   344: aload 6
    //   346: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 5
    //   352: ldc_w 446
    //   355: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: ldc 24
    //   361: iconst_1
    //   362: aload 5
    //   364: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto +127 -> 497
    //   373: new 358	com/tencent/gamecenter/wadl/biz/entity/WadlParams
    //   376: dup
    //   377: aload 6
    //   379: aload 10
    //   381: invokespecial 361	com/tencent/gamecenter/wadl/biz/entity/WadlParams:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: astore 5
    //   386: aload 5
    //   388: iconst_2
    //   389: putfield 366	com/tencent/gamecenter/wadl/biz/entity/WadlParams:b	I
    //   392: aload 5
    //   394: iconst_0
    //   395: putfield 368	com/tencent/gamecenter/wadl/biz/entity/WadlParams:jdField_a_of_type_Boolean	Z
    //   398: aload 5
    //   400: aload 8
    //   402: putfield 448	com/tencent/gamecenter/wadl/biz/entity/WadlParams:c	Ljava/lang/String;
    //   405: aload 5
    //   407: aload 7
    //   409: putfield 451	com/tencent/gamecenter/wadl/biz/entity/WadlParams:j	Ljava/lang/String;
    //   412: aload 5
    //   414: aload 9
    //   416: putfield 375	com/tencent/gamecenter/wadl/biz/entity/WadlParams:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   419: aload 5
    //   421: iload_3
    //   422: putfield 384	com/tencent/gamecenter/wadl/biz/entity/WadlParams:jdField_e_of_type_Int	I
    //   425: aload 5
    //   427: ldc_w 453
    //   430: putfield 391	com/tencent/gamecenter/wadl/biz/entity/WadlParams:l	Ljava/lang/String;
    //   433: aload 5
    //   435: iconst_3
    //   436: putfield 373	com/tencent/gamecenter/wadl/biz/entity/WadlParams:d	I
    //   439: aload 5
    //   441: bipush 56
    //   443: invokevirtual 455	com/tencent/gamecenter/wadl/biz/entity/WadlParams:b	(I)V
    //   446: invokestatic 396	com/tencent/gamecenter/wadl/util/WadlProxyServiceUtil:a	()Lcom/tencent/gamecenter/wadl/util/WadlProxyServiceWrap;
    //   449: aload 5
    //   451: invokevirtual 401	com/tencent/gamecenter/wadl/util/WadlProxyServiceWrap:b	(Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;)V
    //   454: goto +43 -> 497
    //   457: new 109	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   464: astore 6
    //   466: aload 6
    //   468: ldc_w 457
    //   471: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 6
    //   477: aload 5
    //   479: invokevirtual 404	org/json/JSONObject:toString	()Ljava/lang/String;
    //   482: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: ldc 24
    //   488: iconst_1
    //   489: aload 6
    //   491: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 407	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: goto +26 -> 523
    //   500: astore 5
    //   502: goto +10 -> 512
    //   505: astore 5
    //   507: goto +5 -> 512
    //   510: astore 5
    //   512: ldc 24
    //   514: iconst_1
    //   515: ldc_w 459
    //   518: aload 5
    //   520: invokestatic 412	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   523: iload_2
    //   524: iconst_1
    //   525: iadd
    //   526: istore_2
    //   527: goto -457 -> 70
    //   530: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	QQGameCheckServiceImpl
    //   0	531	1	paramJSONArray	JSONArray
    //   69	458	2	i	int
    //   103	319	3	j	int
    //   155	96	4	k	int
    //   1	477	5	localObject1	Object
    //   500	1	5	localException1	Exception
    //   505	1	5	localException2	Exception
    //   510	9	5	localException3	Exception
    //   10	480	6	localObject2	Object
    //   122	286	7	str1	String
    //   135	266	8	str2	String
    //   145	270	9	str3	String
    //   112	268	10	str4	String
    // Exception table:
    //   from	to	target	type
    //   392	454	500	java/lang/Exception
    //   457	497	500	java/lang/Exception
    //   147	370	505	java/lang/Exception
    //   373	392	505	java/lang/Exception
    //   78	147	510	java/lang/Exception
  }
  
  private List<String> getParams(String[] paramArrayOfString, String paramString)
  {
    int j = paramArrayOfString.length;
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = MobileQQ.sMobileQQ.getPackageManager();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[i]))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(paramArrayOfString[i]);
        localObject2 = GameCenterSpUtils.a(((StringBuilder)localObject2).toString());
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          String str = ((JSONObject)localObject2).optString("appid");
          localObject2 = ((JSONObject)localObject2).optString("packageName", "");
          try
          {
            localObject2 = localPackageManager.getPackageInfo(((String)localObject2).trim(), 0);
            localObject1 = localObject2;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            QLog.e("Wadl_QQGameCheckServiceImpl", 1, "exception and no installed", localNameNotFoundException);
          }
          StringBuilder localStringBuilder;
          if (localObject1 == null)
          {
            localArrayList.add(str);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(" no installed");
            QLog.i("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(" installed");
            QLog.i("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
            new WadlReportBuilder().a("dc00087").h("426").c("202142").b(str).a(1, "42601").a(11, "1").a(12, "116").a();
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void handlePreData(String paramString, JSONArray paramJSONArray)
  {
    int j = 0;
    int i;
    if (paramJSONArray != null) {
      i = paramJSONArray.length();
    } else {
      i = 0;
    }
    if (i < 1) {
      return;
    }
    JSONArray localJSONArray = paramJSONArray;
    if ("APPOINTMENT_TGPA_LIST".equals(paramString))
    {
      localJSONArray = new JSONArray();
      while (j < i)
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(j);
        if (localJSONObject != null)
        {
          int k = localJSONObject.optInt("package_type");
          if ((k == 0) || (k == 1) || (k == 4)) {
            localJSONArray.put(localJSONObject);
          }
        }
        j += 1;
      }
    }
    if (localJSONArray.length() > 0) {
      GameCenterSpUtils.a(paramString, localJSONArray.toString());
    }
  }
  
  private void parsePreData(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      if (paramJSONArray.length() < 1) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        String[] arrayOfString = GameCenterSpUtils.a("APPOINTMENT_DOWNLOAD_LIST").split("\\|");
        int i = 0;
        if (i < paramJSONArray.length())
        {
          Object localObject = paramJSONArray.optJSONObject(i);
          if (localObject != null)
          {
            String str1 = ((JSONObject)localObject).optString("appid");
            String str2 = ((JSONObject)localObject).optString("packageName");
            boolean bool = ((JSONObject)localObject).optBoolean("isRes");
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("APPID_PKGNAME_");
              ((StringBuilder)localObject).append(str1);
              GameCenterSpUtils.a(((StringBuilder)localObject).toString(), str2);
              if (!bool) {
                break label236;
              }
              GameCenterUtil.a(str1, "APPOINTMENT_RES_LIST");
              continue;
              if (j >= arrayOfString.length) {
                break label248;
              }
              if ((TextUtils.isEmpty(arrayOfString[j])) || (TextUtils.isEmpty(str1)) || (!arrayOfString[j].equals(str1))) {
                break label241;
              }
              j = 1;
              if (j == 0)
              {
                GameCenterUtil.a(str1, "APPOINTMENT_LIST");
                GameCenterUtil.a(str1, paramJSONArray.get(i).toString(), "APPOINT_APPID_DETAIL_");
              }
            }
          }
          i += 1;
        }
        else
        {
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
      label236:
      int j = 0;
      continue;
      label241:
      j += 1;
      continue;
      label248:
      j = 0;
    }
  }
  
  private void startDownload(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownload paramsJson=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",from=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",isWifi=");
    localStringBuilder.append(AppNetConnInfo.isWifiConn());
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
    try
    {
      paramString = new WadlParams(paramString);
      paramString.b = 2;
      paramString.d = paramInt;
      WadlProxyServiceUtil.a().b(paramString);
      if (2 == paramInt)
      {
        new WadlReportBuilder().a("dc00087").h("427").c("202139").b(paramString.jdField_a_of_type_JavaLangString).a(1, "42701").a(11, "1").a(12, "117").a();
        return;
      }
      if (1 == paramInt)
      {
        new WadlReportBuilder().a("dc00087").h("426").c("202140").b(paramString.jdField_a_of_type_JavaLangString).a(1, "42601").a(11, "1").a(12, "116").a();
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_QQGameCheckServiceImpl", 1, "startDownload exception", paramString);
    }
  }
  
  public void checkGameCenter()
  {
    boolean bool = canAppointStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkGameCenter canAppointStart=");
    localStringBuilder.append(bool);
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
    if (!bool) {
      return;
    }
    ThreadManager.excute(new QQGameCheckServiceImpl.1(this), 192, null, false);
  }
  
  public HashSet<String> getFilterCmds()
  {
    return cmdMap;
  }
  
  public void handlePushTgpa(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optJSONArray("tgpa_apk_list");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivePushMsg dataJson=");
      localStringBuilder.append(paramString);
      QLog.d("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        handlePreData("APPOINTMENT_TGPA_LIST", (JSONArray)localObject);
        GameCenterBroadcastReceiver.a();
        checkGameCenter();
        return;
      }
    }
    catch (JSONException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivePushMsg tgpa push e=");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.e("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean hasAppointTask()
  {
    boolean bool;
    if ((TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_LIST"))) && (TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_UPDATE_LIST"))) && (TextUtils.isEmpty(GameCenterSpUtils.a("DELAY_LIST"))) && (TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_RES_LIST"))) && (TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_TGPA_LIST")))) {
      bool = false;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasAppointTask hasTask=");
    localStringBuilder.append(bool);
    QLog.d("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    paramIntent = new StringBuilder();
    paramIntent.append("onCmdRsp cmd=");
    paramIntent.append(paramString);
    paramIntent.append(",ret=");
    paramIntent.append(paramLong);
    paramIntent.append(",dataJson=");
    paramIntent.append(paramJSONObject);
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, paramIntent.toString());
    if (("13625".equals(paramString)) && (paramLong == 0L) && (paramJSONObject != null)) {
      try
      {
        GameCenterSpUtils.a("APPOINTMENT_LASTGET_TIME", NetConnInfoCenter.getServerTime());
        GameCenterSpUtils.a("APPOINTMENT_LOAD_GAP", paramJSONObject.optLong("load_gap"));
        GameCenterUtil.a(paramJSONObject.optLong("res_valid") * 1000L);
        parsePreData(paramJSONObject.optJSONArray("pre_download_list"));
        handlePreData("APPOINTMENT_UPDATE_LIST", paramJSONObject.optJSONArray("pre_update_list"));
        if (hasAppointTask())
        {
          GameCenterBroadcastReceiver.a();
          checkGameCenter();
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        paramString = new StringBuilder();
        paramString.append("onGetAutoDownloadApk error=");
        paramString.append(paramIntent.toString());
        QLog.e("Wadl_QQGameCheckServiceImpl", 1, paramString.toString());
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, "onCreate");
    GameCenterReceiver.a();
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
  }
  
  public void onDestroy()
  {
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, "onDestroy");
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this);
    GameCenterReceiver.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameCheckServiceImpl
 * JD-Core Version:    0.7.0.1
 */