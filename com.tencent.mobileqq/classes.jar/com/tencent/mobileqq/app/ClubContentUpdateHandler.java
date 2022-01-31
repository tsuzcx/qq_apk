package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yxz;
import yya;
import yyb;

public class ClubContentUpdateHandler
  extends BusinessHandler
{
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new yyb(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  
  ClubContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramString, paramInt1, "", paramInt2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "small emotion has update info.");
    }
    ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString, paramInt1);
  }
  
  private void a(int paramInt, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    if (Math.abs(paramInt - ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.d)) > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "New version json found!");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null) {
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46));
      }
      File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("version", paramInt);
      localBundle.putString("json_name", paramTaskInfo.d);
      paramTaskInfo = new DownloadTask(paramTaskInfo.b, localFile);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramTaskInfo, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("7.6.0.3525");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
      ArrayList localArrayList1 = new ArrayList();
      int i = paramQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0).getInt("sigTplCfgVer", 0);
      ArrayList localArrayList2 = new ArrayList();
      Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("signature_json");
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
      localArrayList2.add(localObject2);
      localObject2 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).uint_appid.set(8);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).rpt_msg_reqiteminfo.set(localArrayList2);
      localArrayList1.add(localObject2);
      localReqBody.rpt_msg_reqappinfo.set(localArrayList1);
      localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
      ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i("ClubContentUpdateHandler", 2, "checkUpdateSigTpl called.");
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, Map paramMap, boolean paramBoolean)
  {
    if (paramString1.equals(ClubContentJsonTask.d.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonWordingTask!");
      }
      a(paramInt1, ClubContentJsonTask.d, paramBoolean);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString1.equals(ClubContentJsonTask.a.e)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEPPromotionTask!");
          }
          paramInt2 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.a.d);
        } while (paramInt1 <= paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        ClubContentJsonTask.a(MobileQQ.getContext(), ClubContentJsonTask.a.d, paramInt2);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommendEmotion_sp_name", 0);
        ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b();
        paramString1.edit().putLong("last_get_recommendemotion_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), System.currentTimeMillis()).commit();
        return;
        if (!paramString1.contains("_json")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, name.contains(EmosmConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
        }
      } while (!EmoticonUtils.a(paramInt2));
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b(paramString1.replace("_json", "").trim(), paramInt1, paramString2, paramInt2, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, update emoji package!");
      }
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramString1, paramInt1, paramString2, paramInt2, 0);
      paramMap.put(paramString1, Integer.valueOf(paramInt2));
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentUpdateHandler", 2, "emotion has update info.");
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("group_domain")) && (paramJSONObject.has("group_strategy"))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        String str = paramJSONObject.getString("group_domain");
        paramJSONObject = paramJSONObject.getString("group_strategy");
        if (QLog.isColorLevel()) {
          QLog.i("ClubContentUpdateHandler", 2, "cdnCacheConfig, domain: " + str + ", strategys: " + paramJSONObject);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        do
        {
          paramJSONObject.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.w("ClubContentUpdateHandler", 2, "", paramJSONObject);
        return;
      }
    }
    QLog.w("ClubContentUpdateHandler", 2, "no cdnCacheConfig!");
  }
  
  private boolean a(int paramInt, ClubContentJsonTask.TaskInfo paramTaskInfo, boolean paramBoolean)
  {
    int i = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.d);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "updateResJson name = " + paramTaskInfo.e + " localVersion = " + i + " version = " + paramInt);
    }
    if (paramInt > i)
    {
      ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTaskInfo, paramInt, paramBoolean);
      return true;
    }
    return false;
  }
  
  private void c() {}
  
  private void g(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleGetIndividuationUrlsResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals(ClubContentJsonTask.b.e)) {}
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "SmallEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag);
        }
        if ((localEmoticonPackage.jobType == 4) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.b(localEmoticonPackage.updateFlag)))
        {
          ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
        }
      }
    }
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(10);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a(ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramTaskInfo.e);
    localReqItemInfo.uint_version.set(ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.d));
    localArrayList.add(localReqItemInfo);
    paramTaskInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    paramTaskInfo.uint_appid.set(paramInt);
    paramTaskInfo.rpt_msg_reqiteminfo.set(localArrayList);
    paramTaskInfo.setHasFlag(true);
    return paramTaskInfo;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(Context paramContext)
  {
    int i = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getString("qvip_res_push_cfg_txt.", "");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).getJSONArray("data");
        if (i >= ((JSONArray)localObject).length()) {
          continue;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        String str = localJSONObject.getString("filename");
        if (!ClubContentJsonTask.e.a.equals(str)) {
          break label168;
        }
        localObject = localJSONObject.getString("version");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        i = Integer.parseInt((String)localObject);
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("ClubContentUpdateHandler", 2, "Parse QVIP_RES_PUSH_CFG_TXT failed:" + paramContext.toString());
        return;
        i = -1;
        if (i != -1) {
          continue;
        }
      }
      if (ClubContentJsonTask.a(paramContext, ClubContentJsonTask.e.d) != i)
      {
        a(i, ClubContentJsonTask.e);
        return;
      }
      label167:
      return;
      label168:
      i += 1;
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 44
    //   8: iconst_2
    //   9: ldc_w 569
    //   12: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   19: iload_3
    //   20: ldc 33
    //   22: invokestatic 574	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;ILjava/lang/String;)V
    //   25: invokestatic 522	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: ldc_w 524
    //   31: iconst_0
    //   32: invokevirtual 216	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: invokeinterface 327 1 0
    //   40: ldc_w 526
    //   43: aload_2
    //   44: invokeinterface 577 3 0
    //   49: invokeinterface 347 1 0
    //   54: pop
    //   55: new 391	org/json/JSONObject
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 531	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   63: ldc_w 533
    //   66: invokevirtual 537	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   69: astore_2
    //   70: iconst_0
    //   71: istore 4
    //   73: aload_2
    //   74: invokevirtual 542	org/json/JSONArray:length	()I
    //   77: istore 5
    //   79: iload 4
    //   81: iload 5
    //   83: if_icmpge +1313 -> 1396
    //   86: aload_2
    //   87: iload 4
    //   89: invokevirtual 546	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   92: astore 10
    //   94: aload 10
    //   96: ldc 122
    //   98: invokevirtual 579	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   101: istore 5
    //   103: aload 10
    //   105: ldc_w 581
    //   108: invokevirtual 579	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   111: istore 6
    //   113: aload 10
    //   115: ldc_w 548
    //   118: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 10
    //   123: aload 10
    //   125: ifnonnull +1272 -> 1397
    //   128: return
    //   129: getstatic 550	com/tencent/mobileqq/vas/ClubContentJsonTask:e	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   132: getfield 297	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   135: aload 10
    //   137: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifeq +1399 -> 1539
    //   143: aload_0
    //   144: iload 5
    //   146: getstatic 550	com/tencent/mobileqq/vas/ClubContentJsonTask:e	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   149: invokespecial 561	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;)V
    //   152: goto +1387 -> 1539
    //   155: aload_1
    //   156: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   159: invokevirtual 60	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   162: new 62	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   169: ldc 67
    //   171: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 10
    //   176: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 89	com/tencent/mobileqq/vas/ClubContentJsonTask:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   185: istore 6
    //   187: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +52 -> 242
    //   193: ldc 44
    //   195: iconst_4
    //   196: new 62	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 583
    //   206: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 10
    //   211: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 585
    //   217: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: iload 5
    //   222: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: ldc_w 587
    //   228: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload 6
    //   233: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: iload 6
    //   244: iload 5
    //   246: if_icmpge -117 -> 129
    //   249: aload_0
    //   250: iload 5
    //   252: iconst_1
    //   253: aload 10
    //   255: invokespecial 589	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(IILjava/lang/String;)V
    //   258: goto -129 -> 129
    //   261: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +12 -> 276
    //   267: ldc 44
    //   269: iconst_2
    //   270: ldc_w 591
    //   273: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: aload 10
    //   279: iload 5
    //   281: ldc 33
    //   283: iconst_1
    //   284: new 593	java/util/HashMap
    //   287: dup
    //   288: invokespecial 594	java/util/HashMap:<init>	()V
    //   291: iconst_1
    //   292: invokespecial 596	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(Ljava/lang/String;ILjava/lang/String;ILjava/util/Map;Z)V
    //   295: goto -166 -> 129
    //   298: getstatic 598	com/tencent/mobileqq/vas/ClubContentJsonTask:c	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   301: getfield 297	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   304: aload 10
    //   306: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifeq -180 -> 129
    //   312: aload_0
    //   313: iload 5
    //   315: getstatic 598	com/tencent/mobileqq/vas/ClubContentJsonTask:c	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   318: iconst_1
    //   319: invokespecial 307	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   322: pop
    //   323: goto -194 -> 129
    //   326: ldc 44
    //   328: iconst_1
    //   329: new 62	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 600
    //   339: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 10
    //   344: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 602
    //   350: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload 5
    //   355: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_1
    //   365: sipush 152
    //   368: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   371: checkcast 604	com/tencent/mobileqq/apollo/ApolloManager
    //   374: astore 11
    //   376: aload_1
    //   377: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   380: invokestatic 607	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   383: ifeq +43 -> 426
    //   386: aload 11
    //   388: ifnull +38 -> 426
    //   391: iconst_1
    //   392: aload 11
    //   394: aload_1
    //   395: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   398: invokevirtual 609	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   401: if_icmpne +25 -> 426
    //   404: ldc_w 611
    //   407: aload 10
    //   409: invokestatic 614	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   412: ifeq -283 -> 129
    //   415: aload_0
    //   416: aload 10
    //   418: iload 5
    //   420: invokevirtual 616	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(Ljava/lang/String;I)V
    //   423: goto -294 -> 129
    //   426: ldc 44
    //   428: iconst_1
    //   429: ldc_w 618
    //   432: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: goto -306 -> 129
    //   438: ldc 44
    //   440: iconst_1
    //   441: new 62	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 620
    //   451: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload 10
    //   456: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc_w 602
    //   462: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: iload 5
    //   467: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload_1
    //   477: sipush 152
    //   480: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   483: checkcast 604	com/tencent/mobileqq/apollo/ApolloManager
    //   486: astore 11
    //   488: aload_1
    //   489: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   492: invokestatic 607	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   495: ifeq +32 -> 527
    //   498: aload 11
    //   500: ifnull +27 -> 527
    //   503: iconst_1
    //   504: aload 11
    //   506: aload_1
    //   507: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   510: invokevirtual 609	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   513: if_icmpne +14 -> 527
    //   516: aload_0
    //   517: aload 10
    //   519: iload 5
    //   521: invokevirtual 622	com/tencent/mobileqq/app/ClubContentUpdateHandler:b	(Ljava/lang/String;I)V
    //   524: goto -395 -> 129
    //   527: ldc 44
    //   529: iconst_1
    //   530: ldc_w 624
    //   533: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto -407 -> 129
    //   539: ldc 44
    //   541: iconst_1
    //   542: new 62	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 626
    //   552: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 10
    //   557: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 602
    //   563: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: iload 5
    //   568: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aconst_null
    //   578: aload_1
    //   579: iload 5
    //   581: iconst_0
    //   582: invokestatic 631	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig:a	(Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig;Lcom/tencent/common/app/AppInterface;IZ)V
    //   585: goto -456 -> 129
    //   588: ldc 44
    //   590: iconst_1
    //   591: new 62	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   598: ldc_w 633
    //   601: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload 10
    //   606: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: ldc_w 635
    //   612: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: iload 5
    //   617: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   620: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   626: aload_1
    //   627: sipush 152
    //   630: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   633: checkcast 604	com/tencent/mobileqq/apollo/ApolloManager
    //   636: astore 11
    //   638: aload_1
    //   639: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   642: invokestatic 607	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   645: ifeq +141 -> 786
    //   648: aload 11
    //   650: ifnull +136 -> 786
    //   653: iconst_1
    //   654: aload 11
    //   656: aload_1
    //   657: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   660: invokevirtual 609	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   663: if_icmpne +123 -> 786
    //   666: aload 10
    //   668: invokestatic 559	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   671: istore 6
    //   673: aload 11
    //   675: iconst_1
    //   676: iload 6
    //   678: invokevirtual 638	com/tencent/mobileqq/apollo/ApolloManager:a	(II)J
    //   681: ldc2_w 639
    //   684: ldiv
    //   685: lstore 7
    //   687: lload 7
    //   689: iload 5
    //   691: i2l
    //   692: lcmp
    //   693: ifeq -564 -> 129
    //   696: aload_1
    //   697: aload_1
    //   698: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   701: aconst_null
    //   702: iload 6
    //   704: aconst_null
    //   705: iconst_m1
    //   706: iconst_m1
    //   707: iconst_1
    //   708: invokestatic 645	com/tencent/mobileqq/apollo/store/ApolloResDownloader:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;I[IIIZ)V
    //   711: ldc 44
    //   713: iconst_1
    //   714: new 62	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 647
    //   724: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 10
    //   729: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: ldc_w 649
    //   735: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: lload 7
    //   740: invokevirtual 652	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   743: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: goto -620 -> 129
    //   752: astore 11
    //   754: ldc 44
    //   756: iconst_2
    //   757: new 62	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   764: ldc_w 654
    //   767: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload 10
    //   772: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: aload 11
    //   780: invokestatic 656	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   783: goto -654 -> 129
    //   786: ldc 44
    //   788: iconst_1
    //   789: ldc_w 658
    //   792: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: goto -666 -> 129
    //   798: ldc 44
    //   800: iconst_1
    //   801: new 62	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   808: ldc_w 660
    //   811: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload 10
    //   816: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: ldc_w 635
    //   822: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: iload 5
    //   827: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: aload_1
    //   837: sipush 152
    //   840: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   843: checkcast 604	com/tencent/mobileqq/apollo/ApolloManager
    //   846: astore 11
    //   848: aload_1
    //   849: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   852: invokestatic 607	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   855: ifeq -726 -> 129
    //   858: aload 11
    //   860: ifnull -731 -> 129
    //   863: iconst_1
    //   864: aload 11
    //   866: aload_1
    //   867: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   870: invokevirtual 609	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   873: if_icmpne -744 -> 129
    //   876: aload 10
    //   878: invokestatic 559	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   881: istore 6
    //   883: aload 11
    //   885: iconst_2
    //   886: iload 6
    //   888: invokevirtual 638	com/tencent/mobileqq/apollo/ApolloManager:a	(II)J
    //   891: ldc2_w 639
    //   894: ldiv
    //   895: lstore 7
    //   897: lload 7
    //   899: iload 5
    //   901: i2l
    //   902: lcmp
    //   903: ifeq -774 -> 129
    //   906: aload_1
    //   907: aload_1
    //   908: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   911: aconst_null
    //   912: iconst_m1
    //   913: iconst_1
    //   914: newarray int
    //   916: dup
    //   917: iconst_0
    //   918: iload 6
    //   920: iastore
    //   921: iconst_m1
    //   922: iconst_m1
    //   923: iconst_1
    //   924: invokestatic 662	com/tencent/mobileqq/apollo/store/ApolloResDownloader:b	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;I[IIIZ)V
    //   927: ldc 44
    //   929: iconst_1
    //   930: new 62	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   937: ldc_w 664
    //   940: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: iload 6
    //   945: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   948: ldc_w 649
    //   951: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: lload 7
    //   956: invokevirtual 652	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   959: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   965: goto -836 -> 129
    //   968: astore 11
    //   970: ldc 44
    //   972: iconst_2
    //   973: new 62	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   980: ldc_w 666
    //   983: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload 10
    //   988: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: aload 11
    //   996: invokestatic 656	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   999: goto -870 -> 129
    //   1002: ldc_w 668
    //   1005: aload 10
    //   1007: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1010: ifeq -881 -> 129
    //   1013: aload_1
    //   1014: sipush 152
    //   1017: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1020: checkcast 604	com/tencent/mobileqq/apollo/ApolloManager
    //   1023: astore 11
    //   1025: aload_1
    //   1026: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1029: invokestatic 607	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   1032: ifeq +149 -> 1181
    //   1035: aload 11
    //   1037: ifnull +144 -> 1181
    //   1040: iconst_1
    //   1041: aload 11
    //   1043: aload_1
    //   1044: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   1047: invokevirtual 609	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   1050: if_icmpne +131 -> 1181
    //   1053: aload_1
    //   1054: bipush 115
    //   1056: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1059: checkcast 670	com/tencent/mobileqq/app/utils/ApolloContentUpdateHandler
    //   1062: ifnull -933 -> 129
    //   1065: invokestatic 672	com/tencent/mobileqq/app/utils/ApolloContentUpdateHandler:a	()J
    //   1068: lstore 7
    //   1070: lload 7
    //   1072: iload 5
    //   1074: i2l
    //   1075: lcmp
    //   1076: ifeq +64 -> 1140
    //   1079: new 62	java/lang/StringBuilder
    //   1082: dup
    //   1083: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1086: getstatic 677	com/tencent/mobileqq/apollo/utils/ApolloConstant:o	Ljava/lang/String;
    //   1089: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: ldc_w 679
    //   1095: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: astore 11
    //   1103: new 119	android/os/Bundle
    //   1106: dup
    //   1107: invokespecial 120	android/os/Bundle:<init>	()V
    //   1110: astore 12
    //   1112: aload 12
    //   1114: ldc 122
    //   1116: iload 5
    //   1118: i2l
    //   1119: invokevirtual 682	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1122: aload_1
    //   1123: aload 11
    //   1125: ldc_w 684
    //   1128: aload 12
    //   1130: new 686	com/tencent/mobileqq/app/utils/ApolloContentUpdateHandler$ApolloDownloadListener
    //   1133: dup
    //   1134: invokespecial 687	com/tencent/mobileqq/app/utils/ApolloContentUpdateHandler$ApolloDownloadListener:<init>	()V
    //   1137: invokestatic 690	com/tencent/mobileqq/apollo/store/ApolloResDownloader:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/tencent/mobileqq/vip/DownloadListener;)V
    //   1140: ldc 44
    //   1142: iconst_1
    //   1143: new 62	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1150: ldc_w 692
    //   1153: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: iload 5
    //   1158: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: ldc_w 694
    //   1164: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: lload 7
    //   1169: invokevirtual 652	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1178: goto -1049 -> 129
    //   1181: ldc 44
    //   1183: iconst_1
    //   1184: ldc_w 696
    //   1187: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1190: goto -1061 -> 129
    //   1193: getstatic 477	com/tencent/mobileqq/vas/ClubContentJsonTask:b	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1196: getfield 297	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   1199: aload 10
    //   1201: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1204: ifeq -1075 -> 129
    //   1207: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1210: ifeq -1081 -> 129
    //   1213: ldc 44
    //   1215: iconst_2
    //   1216: ldc_w 698
    //   1219: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1222: goto -1093 -> 129
    //   1225: getstatic 701	com/tencent/mobileqq/vas/ClubContentJsonTask:h	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1228: getfield 297	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   1231: aload 10
    //   1233: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1236: ifeq -1107 -> 129
    //   1239: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1242: ifeq +12 -> 1254
    //   1245: ldc 44
    //   1247: iconst_2
    //   1248: ldc_w 703
    //   1251: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1254: aload_0
    //   1255: iload 5
    //   1257: getstatic 701	com/tencent/mobileqq/vas/ClubContentJsonTask:h	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1260: iconst_1
    //   1261: invokespecial 307	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   1264: pop
    //   1265: goto -1136 -> 129
    //   1268: getstatic 705	com/tencent/mobileqq/vas/ClubContentJsonTask:i	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1271: getfield 297	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   1274: aload 10
    //   1276: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1279: ifeq -1150 -> 129
    //   1282: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1285: ifeq +12 -> 1297
    //   1288: ldc 44
    //   1290: iconst_2
    //   1291: ldc_w 707
    //   1294: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1297: aload_0
    //   1298: iload 5
    //   1300: getstatic 705	com/tencent/mobileqq/vas/ClubContentJsonTask:i	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1303: iconst_1
    //   1304: invokespecial 307	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   1307: pop
    //   1308: goto -1179 -> 129
    //   1311: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1314: ifeq +30 -> 1344
    //   1317: ldc 44
    //   1319: iconst_2
    //   1320: new 62	java/lang/StringBuilder
    //   1323: dup
    //   1324: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1327: ldc_w 709
    //   1330: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: aload 10
    //   1335: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1341: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1344: aload 10
    //   1346: ldc_w 711
    //   1349: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1352: istore 9
    //   1354: iload 9
    //   1356: ifeq -1227 -> 129
    //   1359: goto -1230 -> 129
    //   1362: astore_1
    //   1363: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1366: ifeq +30 -> 1396
    //   1369: ldc 44
    //   1371: iconst_2
    //   1372: new 62	java/lang/StringBuilder
    //   1375: dup
    //   1376: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1379: ldc_w 713
    //   1382: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: iload_3
    //   1386: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1389: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1392: aload_1
    //   1393: invokestatic 715	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1396: return
    //   1397: iload 6
    //   1399: lookupswitch	default:+137->1536, 1:+-1138->261, 2:+-1270->129, 3:+-1270->129, 5:+-131->1268, 7:+-1101->298, 10:+-1244->155, 18:+-1270->129, 113:+-174->1225, 201:+-1073->326, 202:+-811->588, 203:+-601->798, 204:+-961->438, 205:+-860->539, 206:+-397->1002, 302:+-88->1311, 401:+-206->1193
    //   1537: <illegal opcode>
    //   1538: lor
    //   1539: iload 4
    //   1541: iconst_1
    //   1542: iadd
    //   1543: istore 4
    //   1545: goto -1472 -> 73
    //   1548: astore 10
    //   1550: goto -11 -> 1539
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1553	0	this	ClubContentUpdateHandler
    //   0	1553	1	paramQQAppInterface	QQAppInterface
    //   0	1553	2	paramString	String
    //   0	1553	3	paramInt	int
    //   71	1473	4	i	int
    //   77	1222	5	j	int
    //   111	1287	6	k	int
    //   685	483	7	l	long
    //   1352	3	9	bool	boolean
    //   92	1253	10	localObject1	Object
    //   1548	1	10	localException1	Exception
    //   374	300	11	localApolloManager1	com.tencent.mobileqq.apollo.ApolloManager
    //   752	27	11	localException2	Exception
    //   846	38	11	localApolloManager2	com.tencent.mobileqq.apollo.ApolloManager
    //   968	27	11	localException3	Exception
    //   1023	101	11	localObject2	Object
    //   1110	19	12	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   588	648	752	java/lang/Exception
    //   653	687	752	java/lang/Exception
    //   696	749	752	java/lang/Exception
    //   786	795	752	java/lang/Exception
    //   798	858	968	java/lang/Exception
    //   863	897	968	java/lang/Exception
    //   906	965	968	java/lang/Exception
    //   55	70	1362	java/lang/Exception
    //   73	79	1362	java/lang/Exception
    //   86	123	1548	java/lang/Exception
    //   129	152	1548	java/lang/Exception
    //   155	242	1548	java/lang/Exception
    //   249	258	1548	java/lang/Exception
    //   261	276	1548	java/lang/Exception
    //   276	295	1548	java/lang/Exception
    //   298	323	1548	java/lang/Exception
    //   326	386	1548	java/lang/Exception
    //   391	423	1548	java/lang/Exception
    //   426	435	1548	java/lang/Exception
    //   438	498	1548	java/lang/Exception
    //   503	524	1548	java/lang/Exception
    //   527	536	1548	java/lang/Exception
    //   539	585	1548	java/lang/Exception
    //   754	783	1548	java/lang/Exception
    //   970	999	1548	java/lang/Exception
    //   1002	1035	1548	java/lang/Exception
    //   1040	1070	1548	java/lang/Exception
    //   1079	1140	1548	java/lang/Exception
    //   1140	1178	1548	java/lang/Exception
    //   1181	1190	1548	java/lang/Exception
    //   1193	1222	1548	java/lang/Exception
    //   1225	1254	1548	java/lang/Exception
    //   1254	1265	1548	java/lang/Exception
    //   1268	1297	1548	java/lang/Exception
    //   1297	1308	1548	java/lang/Exception
    //   1311	1344	1548	java/lang/Exception
    //   1344	1354	1548	java/lang/Exception
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleUrlInterceptJSONResponse name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.h.e)) {
        a(i, ClubContentJsonTask.h, false);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ClubContentUpdate.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new yxz(this, paramInt, paramString));
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "BigEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        }
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.b(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label378;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label378:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(ClubContentJsonTask.d.e);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.d.d));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b(ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramTaskInfo.e);
    localReqItemInfo.uint_version.set(ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.d));
    localArrayList.add(localReqItemInfo);
    paramTaskInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    paramTaskInfo.uint_appid.set(paramInt);
    paramTaskInfo.rpt_msg_reqiteminfo.set(localArrayList);
    paramTaskInfo.setHasFlag(true);
    return paramTaskInfo;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("7.6.0.3525");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b());
    localArrayList.add(a());
    localArrayList.add(c());
    localArrayList.add(b(ClubContentJsonTask.c, 7));
    localArrayList.add(a(ClubContentJsonTask.e, 105));
    localArrayList.add(b(ClubContentJsonTask.f, 11));
    localArrayList.add(b(ClubContentJsonTask.h, 113));
    localArrayList.add(b(ClubContentJsonTask.i, 5));
    localReqBody.rpt_msg_reqappinfo.set(localArrayList);
    localReqBody.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l) + "ms");
    }
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    paramRspAppInfo = new StringBuilder(((ArrayList)localObject).size() * 64);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)((Iterator)localObject).next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        paramRspAppInfo.append("name=").append(str1).append(", version=").append(i).append(", updateFlag=").append(j).append(", extStr=").append(str2);
      }
      if ((str1.equals(ClubContentJsonTask.e.e)) && (i > ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.e.d))) {
        a(i, ClubContentJsonTask.e);
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramRspAppInfo.toString()))) {
      QLog.d("ClubContentUpdateHandler", 2, paramRspAppInfo.toString());
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.int_result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          c();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label326;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 2: 
        case 3: 
        case 9: 
        case 18: 
        case 1: 
          e(paramFromServiceMsg);
          break;
        case 10: 
          d(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      c(paramFromServiceMsg);
      continue;
      b(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      g(paramFromServiceMsg);
      continue;
      a(paramFromServiceMsg);
      continue;
      f(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      label326:
      return;
      i = 0;
      break;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new yya(this, paramInt, paramString));
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        QLog.d("ClubContentUpdateHandler", 2, "MagicEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        if ((localEmoticonPackage.jobType == 3) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.b(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label320;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label320:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
        }
        if (str1.equals(ClubContentJsonTask.c.e))
        {
          if (i > ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.c.d)) {
            ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.c, i, false);
          }
        }
        else if (str1.equals(ClubContentJsonTask.f.e))
        {
          if (i > ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.f.d)) {
            ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.f, i, false);
          }
        }
        else if (str1.equals(ClubContentJsonTask.i.e))
        {
          j = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.i.d);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "FontInfoList_json remoteVersion = " + i + " localVersion = " + j);
          }
          if (i > j) {
            ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.i, i, false);
          }
        }
      }
    }
  }
  
  protected void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse begins");
    }
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      int j = localRspItemInfo.uint_update_flag.get();
      int k = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + str);
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + str + ",updateFlag:" + j + ",version" + i + ",localVersion:" + k);
      }
      if (k < i) {
        a(i, j, str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse ends");
    }
  }
  
  protected void e(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    QLog.d("ClubContentUpdateHandler", 2, "handleEmosmResponse begins");
    paramRspAppInfo = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRspAppInfo.iterator();
    while (localIterator.hasNext())
    {
      paramRspAppInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      String str1 = paramRspAppInfo.str_name.get();
      int i = paramRspAppInfo.uint_version.get();
      String str2 = paramRspAppInfo.str_extend.get();
      int j = paramRspAppInfo.uint_update_flag.get();
      String[] arrayOfString = str2.split("\\|\\|");
      paramRspAppInfo = "";
      if (arrayOfString.length > 0) {
        paramRspAppInfo = arrayOfString[0];
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      a(str1, i, paramRspAppInfo, j, localHashMap, false);
    }
  }
  
  protected void f(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleIndividuationMainpageConfigResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals("individuation_mainpage_config2")) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler
 * JD-Core Version:    0.7.0.1
 */