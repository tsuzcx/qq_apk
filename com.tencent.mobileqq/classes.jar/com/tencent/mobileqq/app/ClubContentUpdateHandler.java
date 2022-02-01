package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClubContentUpdateHandler
  extends BusinessHandler
{
  protected QQAppInterface a;
  DownloadListener b = new ClubContentUpdateHandler.1(this);
  private DownloaderFactory c = null;
  
  ClubContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ((IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPkgUpdateStatus(paramString, paramInt1, "", paramInt2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "small emotion has update info.");
    }
    Context localContext = this.a.getApplication().getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("small_emosm_update_flag");
    localStringBuilder.append(paramString);
    ClubContentJsonTask.a(localContext, localStringBuilder.toString(), paramInt1);
  }
  
  private void a(int paramInt, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    if (Math.abs(paramInt - ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), paramTaskInfo.d)) > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "New version json found!");
      }
      if (this.c == null) {
        this.c = ((DownloaderFactory)this.a.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
      }
      File localFile = new File(this.a.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("version", paramInt);
      localBundle.putString("json_name", paramTaskInfo.d);
      paramTaskInfo = new DownloadTask(paramTaskInfo.b, localFile);
      this.c.a(1).startDownload(paramTaskInfo, this.b, localBundle);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.8.17.5770");
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
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "checkUpdateSigTpl called.");
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, Map<String, Integer> paramMap, boolean paramBoolean)
  {
    if (paramString1.equals(ClubContentJsonTask.d.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonWordingTask!");
      }
      a(paramInt1, ClubContentJsonTask.d, paramBoolean);
      return;
    }
    if (paramString1.equals(ClubContentJsonTask.a.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEPPromotionTask!");
      }
      paramInt2 = ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), ClubContentJsonTask.a.d);
      if (paramInt1 > paramInt2)
      {
        this.a.getApplication();
        ClubContentJsonTask.a(MobileQQ.getContext(), ClubContentJsonTask.a.d, paramInt2);
        paramString1 = this.a.getApp().getSharedPreferences("recommendEmotion_sp_name", 0);
        ((IEmoticonHandler)this.a.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a();
        paramString1 = paramString1.edit();
        paramString2 = new StringBuilder();
        paramString2.append("last_get_recommendemotion_time_");
        paramString2.append(this.a.getCurrentUin());
        paramString1.putLong(paramString2.toString(), System.currentTimeMillis()).commit();
      }
    }
    else if (paramString1.contains("_json"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, name.contains(EmosmEmoticonConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
      }
      if (EmoticonPanelUtils.a(paramInt2)) {
        ((IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPackageKeywordJson(paramString1.replace("_json", "").trim(), paramInt1, paramString2, paramInt2, 0);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, update emoji package!");
      }
      ((IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPkgUpdateStatus(paramString1, paramInt1, paramString2, paramInt2, 0);
      paramMap.put(paramString1, Integer.valueOf(paramInt2));
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "emotion has update info.");
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("group_domain")) && (paramJSONObject.has("group_strategy")))
    {
      try
      {
        String str = paramJSONObject.getString("group_domain");
        paramJSONObject = paramJSONObject.getString("group_strategy");
        if (!QLog.isColorLevel()) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cdnCacheConfig, domain: ");
        localStringBuilder.append(str);
        localStringBuilder.append(", strategys: ");
        localStringBuilder.append(paramJSONObject);
        QLog.i("ClubContentUpdateHandler", 2, localStringBuilder.toString());
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.w("ClubContentUpdateHandler", 2, "", paramJSONObject);
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("ClubContentUpdateHandler", 2, "no cdnCacheConfig!");
    }
  }
  
  private boolean a(int paramInt, ClubContentJsonTask.TaskInfo paramTaskInfo, boolean paramBoolean)
  {
    int i = ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), paramTaskInfo.d);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateResJson name = ");
      localStringBuilder.append(paramTaskInfo.e);
      localStringBuilder.append(" localVersion = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" version = ");
      localStringBuilder.append(paramInt);
      QLog.d("ClubContentUpdateHandler", 2, localStringBuilder.toString());
    }
    if (paramInt > i)
    {
      ClubContentJsonTask.a(this.a, paramTaskInfo, paramInt, paramBoolean);
      return true;
    }
    return false;
  }
  
  private void e() {}
  
  private void g(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetIndividuationUrlsResponse, name=");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(", version=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", updateFlag=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",extStr=");
        ((StringBuilder)localObject).append(str2);
        QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject).toString());
      }
      str1.equals(ClubContentJsonTask.b.e);
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a(ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramTaskInfo.e);
    localReqItemInfo.uint_version.set(ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), paramTaskInfo.d));
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
    Object localObject1 = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject2 = this.a.getCurrentAccountUin();
    ((ClubContentUpdateInfoPb.ReqBody)localObject1).int_protocolver.set(1);
    ((ClubContentUpdateInfoPb.ReqBody)localObject1).uint_clientplatid.set(109);
    ((ClubContentUpdateInfoPb.ReqBody)localObject1).str_clientver.set("8.8.17.5770");
    ((ClubContentUpdateInfoPb.ReqBody)localObject1).uint_uin.set(Long.parseLong((String)localObject2));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(c());
    localArrayList.add(b());
    localArrayList.add(d());
    localArrayList.add(b(ClubContentJsonTask.c, 7));
    localArrayList.add(a(ClubContentJsonTask.e, 105));
    localArrayList.add(b(ClubContentJsonTask.f, 11));
    localArrayList.add(b(ClubContentJsonTask.h, 113));
    localArrayList.add(b(ClubContentJsonTask.j, 5));
    ((ClubContentUpdateInfoPb.ReqBody)localObject1).rpt_msg_reqappinfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqBody)localObject1).setHasFlag(true);
    localObject2 = new ToServiceMsg("mobileqq.service", (String)localObject2, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject2).putWupBuffer(((ClubContentUpdateInfoPb.ReqBody)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendPbReq called cost: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject1).append("ms");
      QLog.i("ClubContentUpdateHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 5)
      {
        if (paramInt1 != 7)
        {
          Object localObject;
          if (paramInt1 != 10)
          {
            if (paramInt1 != 113)
            {
              if (paramInt1 != 302)
              {
                if (paramInt1 != 401) {
                  return;
                }
                if ((ClubContentJsonTask.b.e.equals(paramString)) && (QLog.isColorLevel())) {
                  QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, update json for individuation url config");
                }
              }
              else
              {
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("saveQVIPResConfigContent, individuation mainpage, name=");
                  ((StringBuilder)localObject).append(paramString);
                  QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject).toString());
                }
                paramString.equals("individuation_mainpage_config2");
              }
            }
            else if (ClubContentJsonTask.h.e.equals(paramString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent UrlInterceptJson");
              }
              a(paramInt2, ClubContentJsonTask.h, true);
            }
          }
          else
          {
            localObject = this.a.getApplication().getApplicationContext();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("small_emosm_update_flag");
            localStringBuilder.append(paramString);
            paramInt1 = ClubContentJsonTask.a((Context)localObject, localStringBuilder.toString());
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("func handleSmallEmosmResponse, name:");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(",version");
              ((StringBuilder)localObject).append(paramInt2);
              ((StringBuilder)localObject).append(",localVersion:");
              ((StringBuilder)localObject).append(paramInt1);
              QLog.d("ClubContentUpdateHandler", 4, ((StringBuilder)localObject).toString());
            }
            if (paramInt1 < paramInt2) {
              a(paramInt2, 1, paramString);
            }
          }
        }
        else if (ClubContentJsonTask.c.e.equals(paramString))
        {
          a(paramInt2, ClubContentJsonTask.c, true);
        }
      }
      else if (ClubContentJsonTask.j.e.equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent FontInfoList");
        }
        a(paramInt2, ClubContentJsonTask.j, true);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func handleSmallEmosmResponse, bigEmoji and magicEmoji");
      }
      a(paramString, paramInt2, "", 1, new HashMap(), true);
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = BaseApplication.getContext();
    int i = 0;
    localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", 0).getString("qvip_res_push_cfg_txt.", "");
    label167:
    label168:
    do
    {
      for (;;)
      {
        try
        {
          localObject = new JSONObject((String)localObject).getJSONArray("data");
          if (i >= ((JSONArray)localObject).length()) {
            break;
          }
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          String str = localJSONObject.getString("filename");
          if (!ClubContentJsonTask.e.a.equals(str)) {
            break label168;
          }
          localObject = localJSONObject.getString("version");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          i = Integer.parseInt((String)localObject);
        }
        catch (Exception paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label167;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Parse QVIP_RES_PUSH_CFG_TXT failed:");
          ((StringBuilder)localObject).append(paramContext.toString());
          QLog.e("ClubContentUpdateHandler", 2, ((StringBuilder)localObject).toString());
        }
        if (ClubContentJsonTask.a(paramContext, ClubContentJsonTask.e.d) != i)
        {
          a(i, ClubContentJsonTask.e);
          return;
        }
        return;
        i += 1;
      }
      i = -1;
    } while (i != -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "func saveQVIPResConfigContent invoked!");
    }
    paramQQAppInterface = BaseApplication.getContext();
    int i = 0;
    paramQQAppInterface.getSharedPreferences("mobileQQ", 0).edit().putString("qvip_res_push_cfg_txt.", paramString).commit();
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramString).getJSONArray("data");
        j = paramQQAppInterface.length();
        if (i >= j) {}
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "name= saveQVIPResConfigContent ", paramQQAppInterface);
        }
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
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleUrlInterceptJSONResponse name=");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(", version=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", updateFlag=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",extStr=");
        ((StringBuilder)localObject).append(str2);
        QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject).toString());
      }
      if (str1.equals(ClubContentJsonTask.h.e)) {
        a(i, ClubContentJsonTask.h, false);
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.int_result.get() != 0)
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleResponse, result=");
            paramFromServiceMsg.append(paramToServiceMsg.int_result.get());
            QLog.d("ClubContentUpdateHandler", 2, paramFromServiceMsg.toString());
          }
          e();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (paramToServiceMsg.hasNext())
        {
          paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
          i = paramFromServiceMsg.uint_appid.get();
          if (i != 1)
          {
            if ((i == 2) || (i == 3)) {
              continue;
            }
            if (i != 5) {
              if (i != 7)
              {
                if (i == 18) {
                  continue;
                }
                if (i != 105) {
                  if (i != 113) {
                    if (i != 302) {
                      if (i == 401) {}
                    }
                  }
                }
              }
            }
          }
        }
        switch (i)
        {
        case 9: 
        case 11: 
          c(paramFromServiceMsg);
          break;
        case 10: 
          d(paramFromServiceMsg);
          continue;
          g(paramFromServiceMsg);
          continue;
          f(paramFromServiceMsg);
          continue;
          a(paramFromServiceMsg);
          continue;
          b(paramFromServiceMsg);
          continue;
          c(paramFromServiceMsg);
          continue;
          c(paramFromServiceMsg);
          continue;
          e(paramFromServiceMsg);
          continue;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    Object localObject1 = ((IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject1).next();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("SmallEmojiId= ");
          ((StringBuilder)localObject2).append(localEmoticonPackage.epId);
          ((StringBuilder)localObject2).append("status=");
          ((StringBuilder)localObject2).append(localEmoticonPackage.status);
          ((StringBuilder)localObject2).append("jobType=");
          ((StringBuilder)localObject2).append(localEmoticonPackage.jobType);
          ((StringBuilder)localObject2).append("updateFlag=");
          ((StringBuilder)localObject2).append(localEmoticonPackage.updateFlag);
          QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject2).toString());
        }
        if ((localEmoticonPackage.jobType == 4) && (localEmoticonPackage.status == 2) && (!EmoticonPanelUtils.b(localEmoticonPackage.updateFlag)))
        {
          localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set(localEmoticonPackage.epId);
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localObject2);
        }
      }
    }
    localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(10);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).setHasFlag(true);
    return localObject1;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b(ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramTaskInfo.e);
    localReqItemInfo.uint_version.set(ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), paramTaskInfo.d));
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
      if (QLog.isColorLevel())
      {
        paramRspAppInfo.append("name=");
        paramRspAppInfo.append(str1);
        paramRspAppInfo.append(", version=");
        paramRspAppInfo.append(i);
        paramRspAppInfo.append(", updateFlag=");
        paramRspAppInfo.append(j);
        paramRspAppInfo.append(", extStr=");
        paramRspAppInfo.append(str2);
      }
      if ((str1.equals(ClubContentJsonTask.e.e)) && (i > ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), ClubContentJsonTask.e.d))) {
        a(i, ClubContentJsonTask.e);
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramRspAppInfo.toString()))) {
      QLog.d("ClubContentUpdateHandler", 2, paramRspAppInfo.toString());
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject1 = ((IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject1).next();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("BigEmojiId= ");
          ((StringBuilder)localObject2).append(localEmoticonPackage.epId);
          ((StringBuilder)localObject2).append("status=");
          ((StringBuilder)localObject2).append(localEmoticonPackage.status);
          ((StringBuilder)localObject2).append("jobType=");
          ((StringBuilder)localObject2).append(localEmoticonPackage.jobType);
          ((StringBuilder)localObject2).append("updateFlag=");
          ((StringBuilder)localObject2).append(localEmoticonPackage.updateFlag);
          ((StringBuilder)localObject2).append("localVersion=");
          ((StringBuilder)localObject2).append(localEmoticonPackage.localVersion);
          QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject2).toString());
        }
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!EmoticonPanelUtils.b(localEmoticonPackage.updateFlag)))
        {
          localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set(localEmoticonPackage.epId);
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localObject2);
          localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
          PBStringField localPBStringField = ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localEmoticonPackage.epId);
          localStringBuilder.append("_json");
          localPBStringField.set(localStringBuilder.toString());
          int j = localEmoticonPackage.jsonVersion;
          int i = j;
          if (j == 0) {
            i = localEmoticonPackage.localVersion;
          }
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
          localArrayList.add(localObject2);
        }
      }
    }
    localObject1 = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject1).str_name.set(ClubContentJsonTask.d.e);
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject1).uint_version.set(ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), ClubContentJsonTask.d.d));
    localArrayList.add(localObject1);
    localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(1);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).setHasFlag(true);
    return localObject1;
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      Object localObject2 = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      Object localObject1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).uint_version.get();
      String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).str_extend.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).uint_update_flag.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("name=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", version=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", updateFlag=");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(",extStr=");
          ((StringBuilder)localObject2).append(str);
          QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject2).toString());
        }
        if (((String)localObject1).equals(ClubContentJsonTask.c.e))
        {
          if (i > ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), ClubContentJsonTask.c.d)) {
            ClubContentJsonTask.a(this.a, ClubContentJsonTask.c, i, false);
          }
        }
        else if (((String)localObject1).equals(ClubContentJsonTask.f.e))
        {
          if (i > ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), ClubContentJsonTask.f.d)) {
            ClubContentJsonTask.a(this.a, ClubContentJsonTask.f, i, false);
          }
        }
        else if (((String)localObject1).equals(ClubContentJsonTask.j.e))
        {
          j = ClubContentJsonTask.a(this.a.getApplication().getApplicationContext(), ClubContentJsonTask.j.d);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("FontInfoList_json remoteVersion = ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(" localVersion = ");
            ((StringBuilder)localObject1).append(j);
            QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject1).toString());
          }
          if (i > j) {
            ClubContentJsonTask.a(this.a, ClubContentJsonTask.j, i, false);
          }
        }
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo d()
  {
    Object localObject1 = ((IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject1).next();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MagicEmojiId= ");
        ((StringBuilder)localObject2).append(localEmoticonPackage.epId);
        ((StringBuilder)localObject2).append("status=");
        ((StringBuilder)localObject2).append(localEmoticonPackage.status);
        ((StringBuilder)localObject2).append("jobType=");
        ((StringBuilder)localObject2).append(localEmoticonPackage.jobType);
        ((StringBuilder)localObject2).append("updateFlag=");
        ((StringBuilder)localObject2).append(localEmoticonPackage.updateFlag);
        ((StringBuilder)localObject2).append("localVersion=");
        ((StringBuilder)localObject2).append(localEmoticonPackage.localVersion);
        QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject2).toString());
        if ((localEmoticonPackage.jobType == 3) && (localEmoticonPackage.status == 2) && (!EmoticonPanelUtils.b(localEmoticonPackage.updateFlag)))
        {
          localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set(localEmoticonPackage.epId);
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localObject2);
          localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
          PBStringField localPBStringField = ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localEmoticonPackage.epId);
          localStringBuilder.append("_json");
          localPBStringField.set(localStringBuilder.toString());
          int j = localEmoticonPackage.jsonVersion;
          int i = j;
          if (j == 0) {
            i = localEmoticonPackage.localVersion;
          }
          ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
          localArrayList.add(localObject2);
        }
      }
    }
    localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(1);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).setHasFlag(true);
    return localObject1;
  }
  
  protected void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse begins");
    }
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      localObject = this.a.getApplication().getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("small_emosm_update_flag");
      localStringBuilder.append(str);
      int k = ClubContentJsonTask.a((Context)localObject, localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("func handleSmallEmosmResponse, name:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",updateFlag:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",version");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",localVersion:");
        ((StringBuilder)localObject).append(k);
        QLog.d("ClubContentUpdateHandler", 4, ((StringBuilder)localObject).toString());
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
      paramRspAppInfo = str2.split("\\|\\|");
      if (paramRspAppInfo.length > 0) {
        paramRspAppInfo = paramRspAppInfo[0];
      } else {
        paramRspAppInfo = "";
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("name=");
        localStringBuilder.append(str1);
        localStringBuilder.append(", version=");
        localStringBuilder.append(i);
        localStringBuilder.append(", tip=");
        localStringBuilder.append(paramRspAppInfo);
        localStringBuilder.append(", updateFlag=");
        localStringBuilder.append(j);
        localStringBuilder.append(",extStr=");
        localStringBuilder.append(str2);
        QLog.d("ClubContentUpdateHandler", 2, localStringBuilder.toString());
      }
      a(str1, i, paramRspAppInfo, j, localHashMap, false);
    }
  }
  
  protected void f(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleIndividuationMainpageConfigResponse, name=");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(", version=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", updateFlag=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",extStr=");
        ((StringBuilder)localObject).append(str2);
        QLog.d("ClubContentUpdateHandler", 2, ((StringBuilder)localObject).toString());
      }
      str1.equals("individuation_mainpage_config2");
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