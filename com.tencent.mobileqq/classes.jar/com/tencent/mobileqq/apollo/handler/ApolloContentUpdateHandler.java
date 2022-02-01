package com.tencent.mobileqq.apollo.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.store.webview.IApolloSSOConfigHelper;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ApolloContentUpdateHandler
  extends BusinessHandler
{
  protected QQAppInterface a;
  public AtomicBoolean a;
  
  public ApolloContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static long a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getLong("apollo_client_script_" + ApolloConstant.K, 0L);
  }
  
  public static String a()
  {
    return "client_script_config_" + ApolloConstant.H;
  }
  
  public static void a(long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).edit().putLong("apollo_client_script_" + ApolloConstant.K, paramLong).commit();
    QLog.i("ApolloContentUpdateHandler", 1, "updateNewestApolloBaseResVersion version: " + paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      ArrayList localArrayList = new ArrayList();
      b(0L);
      ApolloContentUpdateHandler localApolloContentUpdateHandler = (ApolloContentUpdateHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
      if (localApolloContentUpdateHandler == null) {
        break label50;
      }
      localApolloContentUpdateHandler.b(localArrayList);
      localApolloContentUpdateHandler.a(localArrayList);
    }
    for (;;)
    {
      QLog.i("ApolloContentUpdateHandler", 1, "apollo_base_script forceCheckBaseScript");
      return;
      label50:
      b(paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(paramInt);
    if (i == 0) {
      ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(true, "checkApolloPanelJsonVer : local ver==0", paramInt);
    }
    for (;;)
    {
      QLog.i("ApolloContentUpdateHandler", 1, "checkApolloPanelJsonVer local ver: " + i + ",taskType:" + paramInt);
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("8.5.5.5105");
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
      paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
      QLog.i("ApolloContentUpdateHandler", 1, "checkApolloPanelJsonVer from version " + i + ",taskType:" + paramInt);
    }
  }
  
  public static long b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getLong("apollo_client_script_" + ApolloConstant.H, 0L);
  }
  
  public static String b()
  {
    return "client_script_config_" + ApolloConstant.K;
  }
  
  public static void b(long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).edit().putLong("apollo_client_script_" + ApolloConstant.H, paramLong).commit();
    QLog.i("ApolloContentUpdateHandler", 1, "updateApolloBaseResVersion version: " + paramLong);
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    String str = ApolloConstant.I + "base.zip";
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadCmshowRes(paramQQAppInterface, str, ApolloConstant.G, null, new ApolloContentUpdateHandler.ApolloDownloadListener());
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1);
    QLog.i("ApolloContentUpdateHandler", 1, "getApolloPanelReqInfo ver: " + i);
    if (i == 0)
    {
      ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(true, "login : local ver==0", 1);
      return null;
    }
    ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(false, "login : check action", 1);
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set("tab_list_android_json_v665");
    localReqItemInfo.uint_version.set(i);
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(201);
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo);
    return localReqAppInfo;
  }
  
  protected void a() {}
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    int i;
    String str;
    int j;
    if ((paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.rpt_msg_rspiteminfo.get().get(0);
      paramRspAppInfo = localRspItemInfo.str_name.get();
      i = localRspItemInfo.uint_version.get();
      str = localRspItemInfo.str_extend.get();
      j = localRspItemInfo.uint_update_flag.get();
      if (1 != (j & 0x1)) {
        break label164;
      }
      ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(true, "12h update...", 1);
    }
    for (;;)
    {
      QLog.i("ApolloContentUpdateHandler", 1, "apollo panel json: " + paramRspAppInfo + ", ver: " + i + ", updateFlag: " + j + ", extStr: " + str);
      return;
      try
      {
        label164:
        int k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt("apollo_json_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0) == k) {
          continue;
        }
        ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).parseActionPanelJSon();
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.e("ApolloContentUpdateHandler", 2, "apollo json error" + localThrowable.toString());
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
            QLog.d("ApolloContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          a();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label246;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloContentUpdateHandler", 2, "handleResponse, switch result=" + paramFromServiceMsg.uint_appid.get());
        }
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 201: 
          a(paramFromServiceMsg);
          break;
        case 205: 
          b(paramFromServiceMsg);
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
      d(paramFromServiceMsg);
      continue;
      label246:
      return;
      i = 0;
      break;
    }
  }
  
  public void a(ArrayList<ClubContentUpdateInfoPb.ReqAppInfo> paramArrayList)
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.5.5.5105");
    localReqBody.uint_uin.set(Long.parseLong(str));
    int i;
    if (paramArrayList == null)
    {
      paramArrayList = new ArrayList();
      Object localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (((IApolloManagerService)localObject).isApolloSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
      {
        i = ((IApolloManagerService)localObject).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (2 != i)
        {
          paramArrayList.add(b());
          localObject = a();
          if (localObject != null) {
            paramArrayList.add(localObject);
          }
          localObject = c();
          if (localObject != null) {
            paramArrayList.add(localObject);
          }
          b(paramArrayList);
          localReqBody.rpt_msg_reqappinfo.set(paramArrayList);
        }
      }
    }
    for (;;)
    {
      localReqBody.setHasFlag(true);
      paramArrayList = new ToServiceMsg("mobileqq.service", str, "apollo_content_update.Req");
      paramArrayList.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.i("ApolloContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l) + "ms");
      }
      return;
      QLog.d("ApolloContentUpdateHandler", 1, "apollo status: " + i);
      break;
      if (FileUtil.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
        ApolloUtilImpl.checkJsonParse(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      QLog.d("ApolloContentUpdateHandler", 1, "ApolloFunc close...");
      break;
      localReqBody.rpt_msg_reqappinfo.set(paramArrayList);
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
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
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    boolean bool = false;
    if ((paramRspAppInfo != null) && (paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.rpt_msg_rspiteminfo.get().get(0);
      paramRspAppInfo = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      localObject = (IApolloSSOConfigHelper)QRoute.api(IApolloSSOConfigHelper.class);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (1 == (j & 0x1)) {
        bool = true;
      }
      ((IApolloSSOConfigHelper)localObject).checkUpdateApolloWebViewConfig(localQQAppInterface, i, bool);
      QLog.i("ApolloContentUpdateHandler", 1, "handleApolloWebViewResponse apollo_client ApolloWebView Config json: " + paramRspAppInfo + ", ver: " + i + ", updateFlag: " + j + ", extStr: " + str);
    }
  }
  
  public void b(ArrayList<ClubContentUpdateInfoPb.ReqAppInfo> paramArrayList)
  {
    if (!((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getConfigInitDone())
    {
      QLog.w("ApolloContentUpdateHandler", 1, "sendRequest but apollo config is not done");
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(206);
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo1 = new ClubContentUpdateInfoPb.ReqItemInfo();
    String str1 = a();
    localReqItemInfo1.str_name.set(str1);
    localReqItemInfo1.uint_version.set((int)b());
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo1);
    if (!TextUtils.isEmpty(ApolloConstant.K))
    {
      ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      String str2 = b();
      long l = a();
      localReqItemInfo2.str_name.set(str2);
      localReqItemInfo2.uint_version.set((int)l);
      localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo2);
      QLog.i("ApolloContentUpdateHandler", 1, "getApolloBaseScriptUpdateInfo newest str_name:" + str2 + " ,ver: " + l);
    }
    paramArrayList.add(localReqAppInfo);
    QLog.i("ApolloContentUpdateHandler", 1, "getApolloBaseScriptUpdateInfo str_name:" + str1 + " ,ver: " + localReqItemInfo1.uint_version.get());
  }
  
  public ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject1 = new SparseArray(8);
    Object localObject2 = new File(ApolloConstant.a, "/def/role/0/config.json");
    if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {}
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    for (;;)
    {
      try
      {
        long l = new JSONObject(FileUtils.a((File)localObject2)).optLong("version");
        ((SparseArray)localObject1).put(0, Long.valueOf(l));
        QLog.i("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo roleId: 0, ver: " + l / 1000L);
        localObject2 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
        if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory())) {
          ((File)localObject2).listFiles(new ApolloContentUpdateHandler.1(this, (SparseArray)localObject1));
        }
        localObject2 = new ArrayList();
        i = 0;
        if (i >= ((SparseArray)localObject1).size()) {
          break;
        }
        localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
        int j = ((SparseArray)localObject1).keyAt(i);
        localReqItemInfo.str_name.set(j + "");
        localReqItemInfo.uint_version.set((int)(((Long)((SparseArray)localObject1).get(j)).longValue() / 1000L));
        ((ArrayList)localObject2).add(localReqItemInfo);
        i += 1;
        continue;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo roleId:0", localException);
        ((SparseArray)localObject1).put(0, Long.valueOf(0L));
        continue;
      }
      QLog.e("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo not find role 0 config");
      ((SparseArray)localObject1).put(0, Long.valueOf(0L));
    }
    int i = 0;
    while (i < 3)
    {
      if (((SparseArray)localObject1).get(i) == null)
      {
        localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
        localReqItemInfo.str_name.set(i + "");
        localReqItemInfo.uint_version.set(0);
        localException.add(localReqItemInfo);
      }
      i += 1;
    }
    if (localException.size() > 0)
    {
      localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(202);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.addAll(localException);
      return localObject1;
    }
    return null;
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if ((paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
      while (paramRspAppInfo.hasNext())
      {
        ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
        try
        {
          int i = Integer.parseInt(localRspItemInfo.str_name.get());
          int j = localRspItemInfo.uint_version.get();
          String str = localRspItemInfo.str_extend.get();
          int k = localRspItemInfo.uint_update_flag.get();
          if ((k & 0x1) == 1) {
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, i, null, -1, -1, true);
          }
          QLog.i("ApolloContentUpdateHandler", 1, "apollo role: " + i + ", ver: " + j + ", updateFlag: " + k + ", extStr: " + str);
        }
        catch (Exception localException)
        {
          QLog.e("ApolloContentUpdateHandler", 1, "handleApolloRoleResponse role id: " + localRspItemInfo.str_name.get(), localException);
        }
      }
    }
  }
  
  public void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject;
    String str;
    int i;
    int j;
    boolean bool;
    if ((paramRspAppInfo != null) && (paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
      for (;;)
      {
        if (paramRspAppInfo.hasNext())
        {
          localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
          str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
          if (!TextUtils.isEmpty(str)) {
            if (str.equals(a()))
            {
              i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
              ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
              j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
              if (j != 0) {
                break label545;
              }
              localObject = new File(ApolloConstant.I);
              if (!((File)localObject).exists()) {
                bool = true;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = ApolloConstant.I + "base.zip";
      Bundle localBundle;
      if ((1 == (j & 0x1)) || (bool))
      {
        localBundle = new Bundle();
        localBundle.putLong("version", i);
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadCmshowRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, ApolloConstant.G, localBundle, new ApolloContentUpdateHandler.ApolloDownloadListener());
      }
      QLog.i("ApolloContentUpdateHandler", 1, "apollo_base_script str_name:" + str + ",ver: " + i + ", updateFlag: " + j + ", needUpdate: " + bool);
      break;
      if ((((File)localObject).list() == null) || (((File)localObject).list().length == 0))
      {
        bool = true;
        continue;
        if (!str.equals(b())) {
          break;
        }
        i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
        j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
        if (j == 0)
        {
          localObject = new File(ApolloConstant.L);
          if (!((File)localObject).exists()) {
            bool = true;
          }
        }
        for (;;)
        {
          localObject = ApolloConstant.L + "base.zip";
          if ((1 == (j & 0x1)) || (bool))
          {
            localBundle = new Bundle();
            localBundle.putLong("version", i);
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadCmshowRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, ApolloConstant.J, localBundle, new ApolloContentUpdateHandler.ApolloPreDownloadListener());
          }
          QLog.i("ApolloContentUpdateHandler", 1, "apollo_base_script newest str_name:" + str + ",ver: " + i + ", updateFlag: " + j + ", needUpdate: " + bool);
          break;
          if ((((File)localObject).list() == null) || (((File)localObject).list().length == 0)) {
            bool = true;
          } else {
            bool = false;
          }
        }
      }
      label545:
      bool = false;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("apollo_content_update.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloContentUpdateHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler
 * JD-Core Version:    0.7.0.1
 */