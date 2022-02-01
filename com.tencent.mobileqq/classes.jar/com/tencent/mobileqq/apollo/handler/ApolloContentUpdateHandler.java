package com.tencent.mobileqq.apollo.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.store.webview.api.IApolloSSOConfigHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ApolloContentUpdateHandler
  extends BusinessHandler
  implements IApolloContentUpdateHandler
{
  public static final String a = "com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler";
  protected QQAppInterface b;
  public AtomicBoolean c = new AtomicBoolean(false);
  
  public ApolloContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public static void a(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_client_script_");
    localStringBuilder.append(ApolloConstant.X);
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateNewestApolloBaseResVersion version: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    b(0L);
    ApolloContentUpdateHandler localApolloContentUpdateHandler = (ApolloContentUpdateHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    if (localApolloContentUpdateHandler != null)
    {
      localApolloContentUpdateHandler.b(localArrayList);
      localApolloContentUpdateHandler.a(localArrayList);
    }
    else
    {
      b(paramAppInterface);
    }
    QLog.i("[cmshow]ApolloContentUpdateHandler", 1, "apollo_base_script forceCheckBaseScript");
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramAppInterface == null) {
      return;
    }
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(paramInt);
    if (i == 0)
    {
      ApolloResManagerFacade.a.a(Scene.AIO).a(true, "checkApolloPanelJsonVer : local ver==0", paramInt);
      QLog.e("[cmshow]ApolloContentUpdateHandler", 1, "checkApolloPanelJsonVer local ver = 0");
      return;
    }
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject1 = paramAppInterface.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.8.17.5770");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
    Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
    if (1 == paramInt) {
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("tab_list_android_json_v665");
    }
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    if (1 == paramInt) {
      localReqAppInfo.uint_appid.set(201);
    }
    localReqAppInfo.rpt_msg_reqiteminfo.add((MessageMicro)localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localReqAppInfo);
    localReqBody.rpt_msg_reqappinfo.set((List)localObject2);
    localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "apollo_content_update.Req");
    ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
    paramAppInterface.sendToService((ToServiceMsg)localObject1);
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("checkApolloPanelJsonVer from version ");
    paramAppInterface.append(i);
    paramAppInterface.append(",taskType:");
    paramAppInterface.append(paramInt);
    QLog.i("[cmshow]ApolloContentUpdateHandler", 1, paramAppInterface.toString());
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("client_script_config_");
    localStringBuilder.append(ApolloConstant.X);
    return localStringBuilder.toString();
  }
  
  public static void b(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_client_script_");
    localStringBuilder.append(ApolloConstant.U);
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateApolloBaseResVersion version: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
  }
  
  private static void b(AppInterface paramAppInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApolloConstant.V);
    ((StringBuilder)localObject).append("base.zip");
    localObject = ((StringBuilder)localObject).toString();
    ApolloResDownloaderFacade.a.a(paramAppInterface, (String)localObject, ApolloConstant.T, null, new ApolloContentUpdateHandler.ApolloDownloadListener());
  }
  
  public static long g()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_client_script_");
    localStringBuilder.append(ApolloConstant.X);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("client_script_config_");
    localStringBuilder.append(ApolloConstant.U);
    return localStringBuilder.toString();
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if (paramRspAppInfo.rpt_msg_rspiteminfo.has())
    {
      if (paramRspAppInfo.rpt_msg_rspiteminfo.size() == 0) {
        return;
      }
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.rpt_msg_rspiteminfo.get().get(0);
      paramRspAppInfo = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      if (1 == (j & 0x1)) {
        ApolloResManagerFacade.a.a(Scene.AIO).a(true, "12h update...", 1);
      } else {
        try
        {
          int k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1);
          localObject = this.b.getApplication().getSharedPreferences("apollo_sp", 0);
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("apollo_json_version");
          localStringBuilder2.append(this.b.getCurrentAccountUin());
          if (((SharedPreferences)localObject).getInt(localStringBuilder2.toString(), 0) != k) {
            ApolloResManagerFacade.a.a(Scene.AIO).c();
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder2;
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("apollo json error");
            localStringBuilder2.append(localThrowable.toString());
            QLog.e("[cmshow]ApolloContentUpdateHandler", 2, localStringBuilder2.toString());
          }
        }
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("apollo panel json: ");
      localStringBuilder1.append(paramRspAppInfo);
      localStringBuilder1.append(", ver: ");
      localStringBuilder1.append(i);
      localStringBuilder1.append(", updateFlag: ");
      localStringBuilder1.append(j);
      localStringBuilder1.append(", extStr: ");
      localStringBuilder1.append(str);
      QLog.i("[cmshow]ApolloContentUpdateHandler", 1, localStringBuilder1.toString());
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
    if (i == 0) {
      return;
    }
    paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
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
          QLog.d("[cmshow]ApolloContentUpdateHandler", 2, paramFromServiceMsg.toString());
        }
        f();
        return;
      }
      paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleResponse, switch result=");
          paramObject.append(paramFromServiceMsg.uint_appid.get());
          QLog.d("[cmshow]ApolloContentUpdateHandler", 2, paramObject.toString());
        }
        i = paramFromServiceMsg.uint_appid.get();
        if (i != 201)
        {
          if (i != 202)
          {
            if (i != 205)
            {
              if (i != 206)
              {
                paramObject = new StringBuilder();
                paramObject.append("handleResponse type error: ");
                paramObject.append(paramFromServiceMsg.uint_appid.get());
                QLog.e("[cmshow]ApolloContentUpdateHandler", 1, paramObject.toString());
              }
              else
              {
                d(paramFromServiceMsg);
              }
            }
            else {
              b(paramFromServiceMsg);
            }
          }
          else {
            c(paramFromServiceMsg);
          }
        }
        else {
          a(paramFromServiceMsg);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleResponse error: ");
      paramFromServiceMsg.append(paramToServiceMsg.getMessage());
      QLog.e("[cmshow]ApolloContentUpdateHandler", 1, paramFromServiceMsg.toString());
    }
  }
  
  public void a(ArrayList<ClubContentUpdateInfoPb.ReqAppInfo> paramArrayList)
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.8.17.5770");
    String str = this.b.getCurrentAccountUin();
    localReqBody.uint_uin.set(Long.parseLong(str));
    if (paramArrayList == null)
    {
      paramArrayList = new ArrayList();
      Object localObject = (IApolloManagerService)this.b.getRuntimeService(IApolloManagerService.class, "all");
      if (((IApolloManagerService)localObject).isApolloSupport(this.b.getApp()))
      {
        int i = ((IApolloManagerService)localObject).getApolloStatus(this.b.getCurrentUin());
        if (2 != i)
        {
          paramArrayList.add(d());
          localObject = c();
          if (localObject != null) {
            paramArrayList.add(localObject);
          }
          localObject = e();
          if (localObject != null) {
            paramArrayList.add(localObject);
          }
          b(paramArrayList);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("apollo status: ");
          ((StringBuilder)localObject).append(i);
          QLog.d("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        if (FileUtil.d("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
          ApolloUtilImpl.checkJsonParse(this.b);
        }
        QLog.d("[cmshow]ApolloContentUpdateHandler", 1, "ApolloFunc close...");
      }
      localReqBody.rpt_msg_reqappinfo.set(paramArrayList);
    }
    else
    {
      localReqBody.rpt_msg_reqappinfo.set(paramArrayList);
    }
    localReqBody.setHasFlag(true);
    paramArrayList = new ToServiceMsg("mobileqq.service", str, "apollo_content_update.Req");
    paramArrayList.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("sendPbReq called cost: ");
      paramArrayList.append(System.currentTimeMillis() - l);
      paramArrayList.append("ms");
      QLog.i("[cmshow]ApolloContentUpdateHandler", 2, paramArrayList.toString());
    }
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if ((paramRspAppInfo != null) && (paramRspAppInfo.rpt_msg_rspiteminfo.has()))
    {
      if (paramRspAppInfo.rpt_msg_rspiteminfo.size() == 0) {
        return;
      }
      paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get();
      boolean bool = false;
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.get(0);
      paramRspAppInfo = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      localObject = (IApolloSSOConfigHelper)QRoute.api(IApolloSSOConfigHelper.class);
      QQAppInterface localQQAppInterface = this.b;
      if (1 == (j & 0x1)) {
        bool = true;
      }
      ((IApolloSSOConfigHelper)localObject).checkUpdateApolloWebViewConfig(localQQAppInterface, i, bool);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleApolloWebViewResponse apollo_client ApolloWebView Config json: ");
      ((StringBuilder)localObject).append(paramRspAppInfo);
      ((StringBuilder)localObject).append(", ver: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", updateFlag: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", extStr: ");
      ((StringBuilder)localObject).append(str);
      QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(ArrayList<ClubContentUpdateInfoPb.ReqAppInfo> paramArrayList)
  {
    if (!((IApolloManagerService)this.b.getRuntimeService(IApolloManagerService.class, "all")).getConfigInitDone())
    {
      QLog.w("[cmshow]ApolloContentUpdateHandler", 1, "sendRequest but apollo config is not done");
      this.c.set(true);
      return;
    }
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(206);
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    String str1 = a();
    localReqItemInfo.str_name.set(str1);
    localReqItemInfo.uint_version.set((int)h());
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo);
    if (!TextUtils.isEmpty(ApolloConstant.X))
    {
      Object localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      String str2 = b();
      long l = g();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(str2);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set((int)l);
      localReqAppInfo.rpt_msg_reqiteminfo.add((MessageMicro)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getApolloBaseScriptUpdateInfo newest str_name:");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(" ,ver: ");
      ((StringBuilder)localObject).append(l);
      QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
    }
    paramArrayList.add(localReqAppInfo);
    paramArrayList = new StringBuilder();
    paramArrayList.append("getApolloBaseScriptUpdateInfo str_name:");
    paramArrayList.append(str1);
    paramArrayList.append(" ,ver: ");
    paramArrayList.append(localReqItemInfo.uint_version.get());
    QLog.i("[cmshow]ApolloContentUpdateHandler", 1, paramArrayList.toString());
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getApolloPanelReqInfo ver: ");
    ((StringBuilder)localObject).append(i);
    QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
    localObject = ApolloResManagerFacade.a.a(Scene.AIO);
    if (i == 0)
    {
      ((IApolloResManager)localObject).a(true, "login : local ver==0", 1);
      return null;
    }
    ((IApolloResManager)localObject).a(false, "login : check action", 1);
    localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set("tab_list_android_json_v665");
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(i);
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(201);
    localReqAppInfo.rpt_msg_reqiteminfo.add((MessageMicro)localObject);
    return localReqAppInfo;
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo;
    if (paramRspAppInfo.rpt_msg_rspiteminfo.has())
    {
      if (paramRspAppInfo.rpt_msg_rspiteminfo.size() == 0) {
        return;
      }
      Iterator localIterator = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
      paramRspAppInfo = this;
      if (localIterator.hasNext()) {
        localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      }
    }
    label262:
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(localRspItemInfo.str_name.get());
        int j = localRspItemInfo.uint_version.get();
        localObject = localRspItemInfo.str_extend.get();
        int k = localRspItemInfo.uint_update_flag.get();
        if ((k & 0x1) != 1) {
          break label262;
        }
        ApolloResDownloaderFacade.a.a(paramRspAppInfo.b, paramRspAppInfo.b.getCurrentAccountUin(), null, i, null, -1, -1, true);
        paramRspAppInfo = new StringBuilder();
        paramRspAppInfo.append("apollo role: ");
        paramRspAppInfo.append(i);
        paramRspAppInfo.append(", ver: ");
        paramRspAppInfo.append(j);
        paramRspAppInfo.append(", updateFlag: ");
        paramRspAppInfo.append(k);
        paramRspAppInfo.append(", extStr: ");
        paramRspAppInfo.append((String)localObject);
        QLog.i("[cmshow]ApolloContentUpdateHandler", 1, paramRspAppInfo.toString());
      }
      catch (Exception paramRspAppInfo)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleApolloRoleResponse role id: ");
        ((StringBuilder)localObject).append(localRspItemInfo.str_name.get());
        QLog.e("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString(), paramRspAppInfo);
      }
      break;
      return;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo d()
  {
    int i = BaseApplicationImpl.getContext().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set("apollo_thunder_json_v670");
    localReqItemInfo.uint_version.set(i);
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(205);
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo);
    return localReqAppInfo;
  }
  
  public void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if ((paramRspAppInfo != null) && (paramRspAppInfo.rpt_msg_rspiteminfo.has()))
    {
      if (paramRspAppInfo.rpt_msg_rspiteminfo.size() == 0) {
        return;
      }
      paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
      while (paramRspAppInfo.hasNext())
      {
        Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
        String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
        if (!TextUtils.isEmpty(str))
        {
          boolean bool1 = str.equals(a());
          boolean bool3 = false;
          boolean bool2 = false;
          int i;
          int j;
          Bundle localBundle;
          if (bool1)
          {
            i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
            j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
            bool1 = bool2;
            if (j == 0)
            {
              localObject = new File(ApolloConstant.V);
              if (!((File)localObject).exists()) {}
              do
              {
                do
                {
                  bool1 = true;
                  break;
                } while (((File)localObject).list() == null);
                bool1 = bool2;
              } while (((File)localObject).list().length == 0);
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(ApolloConstant.V);
            ((StringBuilder)localObject).append("base.zip");
            localObject = ((StringBuilder)localObject).toString();
            if ((1 == (j & 0x1)) || (bool1))
            {
              localBundle = new Bundle();
              localBundle.putLong("version", i);
              ApolloResDownloaderFacade.a.a(this.b, (String)localObject, ApolloConstant.T, localBundle, new ApolloContentUpdateHandler.ApolloDownloadListener());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("apollo_base_script str_name:");
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(",ver: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(", updateFlag: ");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(", needUpdate: ");
            ((StringBuilder)localObject).append(bool1);
            QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
          }
          else if (str.equals(b()))
          {
            i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
            j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
            bool1 = bool3;
            if (j == 0)
            {
              localObject = new File(ApolloConstant.Y);
              if (!((File)localObject).exists()) {}
              do
              {
                do
                {
                  bool1 = true;
                  break;
                } while (((File)localObject).list() == null);
                bool1 = bool3;
              } while (((File)localObject).list().length == 0);
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(ApolloConstant.Y);
            ((StringBuilder)localObject).append("base.zip");
            localObject = ((StringBuilder)localObject).toString();
            if ((1 == (j & 0x1)) || (bool1))
            {
              localBundle = new Bundle();
              localBundle.putLong("version", i);
              ApolloResDownloaderFacade.a.a(this.b, (String)localObject, ApolloConstant.W, localBundle, new ApolloContentUpdateHandler.ApolloPreDownloadListener());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("apollo_base_script newest str_name:");
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(",ver: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(", updateFlag: ");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(", needUpdate: ");
            ((StringBuilder)localObject).append(bool1);
            QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public ClubContentUpdateInfoPb.ReqAppInfo e()
  {
    Object localObject1 = new SparseArray(8);
    Object localObject3 = new File(ApolloConstant.a, "/def/role/0/config.json");
    boolean bool = ((File)localObject3).exists();
    Object localObject2 = Long.valueOf(0L);
    if ((bool) && (((File)localObject3).isFile()))
    {
      try
      {
        long l = new JSONObject(FileUtils.readFileContent((File)localObject3)).optLong("version");
        ((SparseArray)localObject1).put(0, Long.valueOf(l));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getApolloRoleReqInfo roleId: 0, ver: ");
        ((StringBuilder)localObject3).append(l / 1000L);
        QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject3).toString());
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo roleId:0", localException);
        ((SparseArray)localObject1).put(0, localObject2);
      }
    }
    else
    {
      QLog.e("[cmshow]ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo not find role 0 config");
      ((SparseArray)localObject1).put(0, localObject2);
    }
    localObject2 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory())) {
      ((File)localObject2).listFiles(new ApolloContentUpdateHandler.1(this, (SparseArray)localObject1));
    }
    localObject2 = new ArrayList();
    int i = 0;
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    PBStringField localPBStringField;
    StringBuilder localStringBuilder;
    while (i < ((SparseArray)localObject1).size())
    {
      localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
      int j = ((SparseArray)localObject1).keyAt(i);
      localPBStringField = localReqItemInfo.str_name;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("");
      localPBStringField.set(localStringBuilder.toString());
      localReqItemInfo.uint_version.set((int)(((Long)((SparseArray)localObject1).get(j)).longValue() / 1000L));
      ((ArrayList)localObject2).add(localReqItemInfo);
      i += 1;
    }
    i = 0;
    while (i < 3)
    {
      if (((SparseArray)localObject1).get(i) == null)
      {
        localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
        localPBStringField = localReqItemInfo.str_name;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        localPBStringField.set(localStringBuilder.toString());
        localReqItemInfo.uint_version.set(0);
        ((ArrayList)localObject2).add(localReqItemInfo);
      }
      i += 1;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(202);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.addAll((Collection)localObject2);
      return localObject1;
    }
    return null;
  }
  
  protected void f() {}
  
  public long h()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_client_script_");
    localStringBuilder.append(ApolloConstant.U);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("apollo_content_update.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("[cmshow]ApolloContentUpdateHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler
 * JD-Core Version:    0.7.0.1
 */