package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.store.webview.IApolloSSOConfigHelper;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloDownloadListener;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
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

public class ClubContentUpdateHandler
  extends BusinessHandler
{
  protected QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ClubContentUpdateHandler.2(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  
  ClubContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramString, paramInt1, "", paramInt2, 0);
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
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
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
      localReqBody.str_clientver.set("8.5.5.5105");
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
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, Map<String, Integer> paramMap, boolean paramBoolean)
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
        ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a();
        paramString1.edit().putLong("last_get_recommendemotion_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), System.currentTimeMillis()).commit();
        return;
        if (!paramString1.contains("_json")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, name.contains(EmosmConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
        }
      } while (!EmoticonUtils.isEmoticonPkgUpdateBitSet(paramInt2));
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).b(paramString1.replace("_json", "").trim(), paramInt1, paramString2, paramInt2, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, update emoji package!");
      }
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramString1, paramInt1, paramString2, paramInt2, 0);
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
  
  private void b() {}
  
  private void b(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    case 204: 
    default: 
    case 201: 
      do
      {
        return;
        QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update panel id: " + paramString + ", version: " + paramInt2);
        IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if ((!localIApolloManagerService.isApolloFuncOpen(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) || (localIApolloManagerService == null) || (1 != localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
          break;
        }
      } while (!TextUtils.equals("tab_list_android_json_v665", paramString));
      a(paramString, paramInt2);
      return;
      QLog.i("ClubContentUpdateHandler", 1, "panel update cancel, apollo not available.");
      return;
    case 205: 
      QLog.i("ClubContentUpdateHandler", 1, "saveQVIPResConfigContent apollo_client realtime update apolloWebView config name: " + paramString + ", version: " + paramInt2);
      ((IApolloSSOConfigHelper)QRoute.api(IApolloSSOConfigHelper.class)).checkUpdateApolloWebViewConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2, false);
      return;
    case 202: 
      c(paramString, paramInt2);
      return;
    case 203: 
      b(paramString, paramInt2);
      return;
    }
    d(paramString, paramInt2);
  }
  
  private void b(String paramString, int paramInt)
  {
    try
    {
      QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update dress id: " + paramString + ", ver: " + paramInt);
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if ((localIApolloManagerService.isApolloFuncOpen(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (localIApolloManagerService != null) && (1 == localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
      {
        int i = Integer.parseInt(paramString);
        long l = localIApolloManagerService.getApolloResLocalTimestamp(2, i) / 1000L;
        if (l != paramInt)
        {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, -1, new int[] { i }, -1, -1, true);
          QLog.i("ClubContentUpdateHandler", 1, "download apollo dress id: " + i + ", loc ver: " + l);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 2, "apollo dress real time update id:" + paramString, localException);
    }
  }
  
  private void c(String paramString, int paramInt)
  {
    try
    {
      QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update role id: " + paramString + ", ver: " + paramInt);
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if ((localIApolloManagerService.isApolloFuncOpen(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (localIApolloManagerService != null) && (1 == localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
      {
        int i = Integer.parseInt(paramString);
        long l = localIApolloManagerService.getApolloResLocalTimestamp(1, i) / 1000L;
        if (l != paramInt)
        {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, i, null, -1, -1, true);
          QLog.i("ClubContentUpdateHandler", 1, "download apollo role id: " + paramString + ", loc ver: " + l);
        }
      }
      else
      {
        QLog.i("ClubContentUpdateHandler", 1, "apollo role res ");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 2, "apollo: update role res realTime failed name:" + paramString, localException);
    }
  }
  
  private void d(String paramString, int paramInt)
  {
    if (ApolloContentUpdateHandler.a().equals(paramString))
    {
      paramString = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if ((!paramString.isApolloFuncOpen(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) || (paramString == null) || (1 != paramString.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
        break label200;
      }
      if ((ApolloContentUpdateHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER) != null)
      {
        long l = ApolloContentUpdateHandler.b();
        if (l != paramInt)
        {
          paramString = ApolloConstant.I + "base.zip";
          Bundle localBundle = new Bundle();
          localBundle.putLong("version", paramInt);
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadCmshowRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, ApolloConstant.G, localBundle, new ApolloContentUpdateHandler.ApolloDownloadListener());
        }
        QLog.i("ClubContentUpdateHandler", 1, "apollo_base_script login push version: " + paramInt + ", old version: " + l);
      }
    }
    return;
    label200:
    QLog.i("ClubContentUpdateHandler", 1, "apollo_base_script login push");
  }
  
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
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(0);
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
        if ((localEmoticonPackage.jobType == 4) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.isEmoticonPkgNeverUpdateBitSet(localEmoticonPackage.updateFlag)))
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
  
  public void a()
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.5.5.5105");
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
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l) + "ms");
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramInt1 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString);
                if (QLog.isColorLevel()) {
                  QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + paramString + ",version" + paramInt2 + ",localVersion:" + paramInt1);
                }
              } while (paramInt1 >= paramInt2);
              a(paramInt2, 1, paramString);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "func handleSmallEmosmResponse, bigEmoji and magicEmoji");
              }
              a(paramString, paramInt2, "", 1, new HashMap(), true);
              return;
            } while (!ClubContentJsonTask.c.e.equals(paramString));
            a(paramInt2, ClubContentJsonTask.c, true);
            return;
          } while ((!ClubContentJsonTask.b.e.equals(paramString)) || (!QLog.isColorLevel()));
          QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, update json for individuation url config");
          return;
        } while (!ClubContentJsonTask.h.e.equals(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent UrlInterceptJson");
        }
        a(paramInt2, ClubContentJsonTask.h, true);
        return;
      } while (!ClubContentJsonTask.i.e.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent FontInfoList");
      }
      a(paramInt2, ClubContentJsonTask.i, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, individuation mainpage, name=" + paramString);
      }
    } while (!paramString.equals("individuation_mainpage_config2"));
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
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "func saveQVIPResConfigContent invoked!");
    }
    BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putString("qvip_res_push_cfg_txt.", paramString).commit();
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramString).getJSONArray("data");
        j = paramQQAppInterface.length();
        if (i >= j) {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ClubContentUpdateHandler", 2, "name= saveQVIPResConfigContent ", paramQQAppInterface);
        return;
      }
      try
      {
        paramString = paramQQAppInterface.getJSONObject(i);
        j = paramString.getInt("version");
        k = paramString.getInt("id");
        paramString = paramString.getString("filename");
        if (paramString == null) {
          return;
        }
        a(k, paramString, j);
        b(k, paramString, j);
        if (ClubContentJsonTask.e.e.equals(paramString)) {
          a(j, ClubContentJsonTask.e);
        }
      }
      catch (Exception paramString)
      {
        continue;
      }
      i += 1;
    }
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
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          b();
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
  
  public void a(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ClubContentUpdateHandler.1(this, paramInt, paramString));
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(0);
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
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.isEmoticonPkgNeverUpdateBitSet(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label379;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label379:
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
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(0);
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
        if ((localEmoticonPackage.jobType == 3) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.isEmoticonPkgNeverUpdateBitSet(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label321;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label321:
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ClubContentUpdate.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler
 * JD-Core Version:    0.7.0.1
 */