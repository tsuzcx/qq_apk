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
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
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
  private static final int RESULT_DEFAULT = 1;
  private static final int RESULT_EXP = 2;
  private static final int RESULT_FAIL = 0;
  private static final String RES_VALID = "res_valid";
  public static final String TAG = "Wadl_QQGameCheckServiceImpl";
  static HashSet<String> cmdMap = new HashSet();
  
  static
  {
    cmdMap.add("13625");
  }
  
  private int canAppointStart()
  {
    Object localObject = MobileQQ.sMobileQQ;
    if ((NetworkUtil.isWifiConnected(MobileQQ.getContext())) && ((GameCenterBroadcastReceiver.b >= 20) || (GameCenterBroadcastReceiver.c)))
    {
      localObject = ABTestController.a().a("exp_qq_qqgame_predownload_screen");
      ((ExpEntityInfo)localObject).h();
      if (((ExpEntityInfo)localObject).f()) {
        return 2;
      }
      localObject = MobileQQ.sMobileQQ;
      localObject = (PowerManager)MobileQQ.getContext().getSystemService("power");
      if ((localObject != null) && (!((PowerManager)localObject).isScreenOn())) {
        return 1;
      }
    }
    return 0;
  }
  
  private void checkIfNeedToDownloadAppointApp(int paramInt, String[] paramArrayOfString)
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
          label323:
          break label323;
        }
        i += 1;
      }
      if (j != 0) {
        GameCenterSpUtils.b("APPOINTMENT_LIST", (String)localObject2);
      }
      paramArrayOfString = ((String)localObject1).split("\\|");
      if (paramArrayOfString.length == 0) {
        return;
      }
      i = 0;
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
        boolean bool;
        if (paramInt == 2) {
          bool = true;
        } else {
          bool = false;
        }
        try
        {
          startDownload((String)localObject3, 1, bool);
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
  
  private void checkIfNeedToDownloadDelayApp(int paramInt, String[] paramArrayOfString)
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
      GameCenterSpUtils.b("DELAY_LIST", "");
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
        boolean bool;
        if (paramInt == 2) {
          bool = true;
        } else {
          bool = false;
        }
        try
        {
          startDownload((String)localObject, 2, bool);
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
      int i = 0;
      GameCenterSpUtils.a(new String[] { "APPOINTMENT_TGPA_LIST" });
      while (i < paramJSONArray.length())
      {
        try
        {
          localObject1 = paramJSONArray.optJSONObject(i);
          localObject2 = ((JSONObject)localObject1).optString("appid");
          int j = ((JSONObject)localObject1).optInt("version_code");
          String str1 = ((JSONObject)localObject1).optString("app_name");
          int k = ((JSONObject)localObject1).optInt("package_type");
          String str2 = ((JSONObject)localObject1).optString("package_name");
          String str3 = ((JSONObject)localObject1).optString("package_src_url");
          int m = ((JSONObject)localObject1).optInt("package_index");
          String str4 = ((JSONObject)localObject1).optString("package_id");
          String str5 = ((JSONObject)localObject1).optString("package_md5");
          if ((checkParams((String)localObject2, str1, str2, str3)) && (checkLocalStatus((String)localObject2, str1, k, str2, j)))
          {
            startResDownload((String)localObject2, str1, k, str3, str2, m, str4, j, str5);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkIfNeedToDownloadTGPA fail，jsonTmp=");
            ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
            QLog.w("Wadl_QQGameCheckServiceImpl", 1, ((StringBuilder)localObject2).toString());
          }
        }
        catch (Exception localException)
        {
          QLog.e("Wadl_QQGameCheckServiceImpl", 1, "checkIfNeedToDownloadTGPA exception", localException);
        }
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
    //   3: new 135	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   10: astore 6
    //   12: aload 6
    //   14: ldc_w 370
    //   17: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 6
    //   23: aload 5
    //   25: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 31
    //   31: iconst_1
    //   32: aload 6
    //   34: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 155	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 5
    //   42: ifnull +488 -> 530
    //   45: aload_1
    //   46: invokevirtual 283	org/json/JSONArray:length	()I
    //   49: iconst_1
    //   50: if_icmpge +4 -> 54
    //   53: return
    //   54: iconst_1
    //   55: anewarray 223	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 372
    //   63: aastore
    //   64: invokestatic 315	com/tencent/gamecenter/wadl/util/GameCenterSpUtils:a	([Ljava/lang/String;)Z
    //   67: pop
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: aload_1
    //   72: invokevirtual 283	org/json/JSONArray:length	()I
    //   75: if_icmpge +455 -> 530
    //   78: aload_1
    //   79: iload_2
    //   80: invokevirtual 319	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   83: astore 5
    //   85: aload 5
    //   87: ldc_w 321
    //   90: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 6
    //   95: aload 5
    //   97: ldc_w 326
    //   100: invokevirtual 330	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   103: istore_3
    //   104: aload 5
    //   106: ldc_w 374
    //   109: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 10
    //   114: aload 5
    //   116: ldc_w 332
    //   119: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 7
    //   124: aload 5
    //   126: ldc_w 376
    //   129: ldc_w 378
    //   132: invokevirtual 381	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 8
    //   137: aload 5
    //   139: ldc_w 383
    //   142: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 9
    //   147: aload 5
    //   149: ldc_w 385
    //   152: invokevirtual 330	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   155: istore 4
    //   157: aload 6
    //   159: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +295 -> 457
    //   165: aload 10
    //   167: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +287 -> 457
    //   173: aload 9
    //   175: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifne +279 -> 457
    //   181: new 157	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder
    //   184: dup
    //   185: invokespecial 158	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:<init>	()V
    //   188: ldc 160
    //   190: invokevirtual 163	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   193: ldc 165
    //   195: invokevirtual 167	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:h	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   198: ldc_w 387
    //   201: invokevirtual 171	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:c	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   204: aload 6
    //   206: invokevirtual 173	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:b	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   209: iconst_1
    //   210: ldc_w 389
    //   213: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   216: bipush 11
    //   218: ldc 180
    //   220: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   223: bipush 12
    //   225: ldc 182
    //   227: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   230: iconst_3
    //   231: ldc_w 391
    //   234: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   237: iconst_4
    //   238: ldc_w 393
    //   241: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   244: invokevirtual 184	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	()V
    //   247: aload 10
    //   249: iload_3
    //   250: iload 4
    //   252: invokestatic 396	com/tencent/gamecenter/wadl/util/GameCenterUtil:a	(Ljava/lang/String;II)Z
    //   255: ifne +118 -> 373
    //   258: new 157	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder
    //   261: dup
    //   262: invokespecial 158	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:<init>	()V
    //   265: ldc 160
    //   267: invokevirtual 163	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   270: ldc 165
    //   272: invokevirtual 167	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:h	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   275: ldc_w 387
    //   278: invokevirtual 171	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:c	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   281: aload 6
    //   283: invokevirtual 173	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:b	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   286: iconst_1
    //   287: ldc_w 398
    //   290: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   293: bipush 11
    //   295: ldc 180
    //   297: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   300: bipush 12
    //   302: ldc 182
    //   304: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   307: iconst_3
    //   308: ldc_w 391
    //   311: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   314: iconst_4
    //   315: ldc_w 393
    //   318: invokevirtual 178	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   321: invokevirtual 184	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	()V
    //   324: new 135	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   331: astore 5
    //   333: aload 5
    //   335: ldc_w 400
    //   338: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 5
    //   344: aload 6
    //   346: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 5
    //   352: ldc_w 402
    //   355: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: ldc 31
    //   361: iconst_1
    //   362: aload 5
    //   364: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto +127 -> 497
    //   373: new 404	com/tencent/gamecenter/wadl/biz/entity/WadlParams
    //   376: dup
    //   377: aload 6
    //   379: aload 10
    //   381: invokespecial 407	com/tencent/gamecenter/wadl/biz/entity/WadlParams:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: astore 5
    //   386: aload 5
    //   388: iconst_2
    //   389: putfield 409	com/tencent/gamecenter/wadl/biz/entity/WadlParams:c	I
    //   392: aload 5
    //   394: iconst_0
    //   395: putfield 411	com/tencent/gamecenter/wadl/biz/entity/WadlParams:b	Z
    //   398: aload 5
    //   400: aload 8
    //   402: putfield 413	com/tencent/gamecenter/wadl/biz/entity/WadlParams:i	Ljava/lang/String;
    //   405: aload 5
    //   407: aload 7
    //   409: putfield 416	com/tencent/gamecenter/wadl/biz/entity/WadlParams:u	Ljava/lang/String;
    //   412: aload 5
    //   414: aload 9
    //   416: putfield 419	com/tencent/gamecenter/wadl/biz/entity/WadlParams:k	Ljava/lang/String;
    //   419: aload 5
    //   421: iload_3
    //   422: putfield 422	com/tencent/gamecenter/wadl/biz/entity/WadlParams:l	I
    //   425: aload 5
    //   427: ldc_w 424
    //   430: putfield 426	com/tencent/gamecenter/wadl/biz/entity/WadlParams:w	Ljava/lang/String;
    //   433: aload 5
    //   435: iconst_3
    //   436: putfield 428	com/tencent/gamecenter/wadl/biz/entity/WadlParams:h	I
    //   439: aload 5
    //   441: bipush 56
    //   443: invokevirtual 431	com/tencent/gamecenter/wadl/biz/entity/WadlParams:c	(I)V
    //   446: invokestatic 436	com/tencent/gamecenter/wadl/util/WadlProxyServiceUtil:a	()Lcom/tencent/gamecenter/wadl/util/WadlProxyServiceWrap;
    //   449: aload 5
    //   451: invokevirtual 441	com/tencent/gamecenter/wadl/util/WadlProxyServiceWrap:b	(Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;)V
    //   454: goto +43 -> 497
    //   457: new 135	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   464: astore 6
    //   466: aload 6
    //   468: ldc_w 443
    //   471: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 6
    //   477: aload 5
    //   479: invokevirtual 359	org/json/JSONObject:toString	()Ljava/lang/String;
    //   482: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: ldc 31
    //   488: iconst_1
    //   489: aload 6
    //   491: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 362	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: goto +26 -> 523
    //   500: astore 5
    //   502: goto +10 -> 512
    //   505: astore 5
    //   507: goto +5 -> 512
    //   510: astore 5
    //   512: ldc 31
    //   514: iconst_1
    //   515: ldc_w 445
    //   518: aload 5
    //   520: invokestatic 368	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  private boolean checkLocalStatus(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    if (GameCenterUtil.d(paramInt1)) {
      return false;
    }
    if (paramInt1 == 1) {
      return GameCenterUtil.a(paramString2, paramInt2);
    }
    if (paramInt1 == 4)
    {
      paramInt1 = GameCenterUtil.b(paramString2);
      if (paramInt1 != -1)
      {
        paramString1 = new StringBuilder();
        paramString1.append("checkIfNeedToDownloadTGPA cancel, localVersion=");
        paramString1.append(paramInt1);
        QLog.d("Wadl_QQGameCheckServiceImpl", 1, paramString1.toString());
        return false;
      }
    }
    else if ((paramInt1 != 0) || (!GameCenterUtil.a(0, paramString1, paramString3))) {}
    return false;
  }
  
  private boolean checkParams(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4));
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
      GameCenterSpUtils.b(paramString, localJSONArray.toString());
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
              GameCenterSpUtils.b(((StringBuilder)localObject).toString(), str2);
              if (!bool) {
                break label237;
              }
              GameCenterUtil.a(str1, "APPOINTMENT_RES_LIST");
              continue;
              if (j >= arrayOfString.length) {
                break label249;
              }
              if ((TextUtils.isEmpty(arrayOfString[j])) || (TextUtils.isEmpty(str1)) || (!arrayOfString[j].equals(str1))) {
                break label242;
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
      label237:
      int j = 0;
      continue;
      label242:
      j += 1;
      continue;
      label249:
      j = 0;
    }
  }
  
  private void startDownload(String paramString, int paramInt, boolean paramBoolean)
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
      paramString.c = 2;
      paramString.h = paramInt;
      if (paramBoolean) {
        paramString.c(2048);
      }
      WadlProxyServiceUtil.a().b(paramString);
      if (2 == paramInt)
      {
        new WadlReportBuilder().a("dc00087").h("427").c("202139").b(paramString.e).a(1, "42701").a(11, "1").a(12, "117").a();
        return;
      }
      if (1 == paramInt)
      {
        new WadlReportBuilder().a("dc00087").h("426").c("202140").b(paramString.e).a(1, "42601").a(11, "1").a(12, "116").a();
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_QQGameCheckServiceImpl", 1, "startDownload exception", paramString);
    }
  }
  
  private void startResDownload(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, int paramInt3, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownload packageName=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",resType=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",appId=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",resName=");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(",srcUrl=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(",versionCode=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",versionName=");
    localStringBuilder.append(paramString5);
    localStringBuilder.append(",resMD5=");
    localStringBuilder.append(paramString6);
    QLog.d("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
    paramString1 = new WadlParams(paramString1, paramString2);
    paramString1.b(2);
    paramString1.b(4);
    paramString1.c = 2;
    paramString1.b = true;
    paramString1.t = paramInt1;
    paramString1.h = 3;
    paramString1.k = paramString3;
    paramString1.r = paramString4;
    paramString1.p = paramInt2;
    paramString1.q = paramString5;
    paramString1.l = paramInt3;
    paramString1.s = paramString6;
    paramString1.w = "auto_tgpa";
    WadlProxyServiceUtil.a().b(paramString1);
  }
  
  public void checkGameCenter()
  {
    int i = canAppointStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkGameCenter canAppointStartResult=");
    localStringBuilder.append(i);
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, localStringBuilder.toString());
    if (i == 0) {
      return;
    }
    ThreadManager.excute(new QQGameCheckServiceImpl.1(this, i), 192, null, false);
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
    GameCenterReceiver.b();
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
  }
  
  public void onDestroy()
  {
    QLog.i("Wadl_QQGameCheckServiceImpl", 1, "onDestroy");
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this);
    GameCenterReceiver.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameCheckServiceImpl
 * JD-Core Version:    0.7.0.1
 */