package com.tencent.mobileqq.apollo.store.webview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;
import zbc;
import zbd;
import zbe;
import zbf;
import zbg;

public class ApolloSSOConfig
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private final ConcurrentHashMap b;
  private final ConcurrentHashMap c;
  
  ApolloSSOConfig(ApolloWebDataHandler paramApolloWebDataHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloWebDataHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap();
    if (!a())
    {
      paramApolloWebDataHandler = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (paramApolloWebDataHandler != null)
      {
        int i = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "new ApolloSSOConfig updateConfigsFromDb=false, checkUpdateApolloWebViewConfig");
        }
        a(this, paramApolloWebDataHandler, i, true);
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public static void a(ApolloSSOConfig paramApolloSSOConfig, AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramAppInterface == null) {}
    do
    {
      do
      {
        return;
        SharedPreferences localSharedPreferences = paramAppInterface.getApplication().getSharedPreferences("sp_apollo_webView", 4);
        int i = localSharedPreferences.getInt("sp_key_apollo_webView_config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "apollo_client checkUpdateApolloWebViewConfig, oldVersion" + i + ",version:" + paramInt);
        }
        Object localObject = new File(ApolloClientUtil.a());
        boolean bool1 = paramBoolean;
        if (paramInt > 0)
        {
          bool1 = paramBoolean;
          if (!((File)localObject).exists()) {
            bool1 = true;
          }
        }
        localSharedPreferences.edit().putLong("sp_key_sso_check_time", System.currentTimeMillis()).commit();
        if ((!bool1) && (paramInt <= i)) {
          break;
        }
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        ((File)localObject).getParentFile().mkdirs();
        localObject = new DownloadTask("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_thunder_config/xydata.json", (File)localObject);
        ((DownloadTask)localObject).n = false;
        ((DownloadTask)localObject).l = true;
        ((DownloadTask)localObject).f = "apollo_res";
        ((DownloadTask)localObject).b = 1;
        ((DownloadTask)localObject).o = true;
        ((DownloadTask)localObject).p = true;
        ((DownloadTask)localObject).a(new zbd(localSharedPreferences, paramInt, paramApolloSSOConfig));
        paramApolloSSOConfig = (DownloaderFactory)paramAppInterface.getManager(46);
        paramBoolean = bool2;
        if (paramApolloSSOConfig != null)
        {
          paramApolloSSOConfig = paramApolloSSOConfig.a(1);
          paramBoolean = bool2;
          if (paramApolloSSOConfig != null)
          {
            paramApolloSSOConfig.a((DownloadTask)localObject, ((DownloadTask)localObject).a(), null);
            paramBoolean = false;
          }
        }
        if (paramBoolean) {
          ThreadManager.executeOnNetWorkThread(new zbe((DownloadTask)localObject));
        }
      } while (!QLog.isColorLevel());
      QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig async:" + paramBoolean);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig local config is new， not need to download");
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(ApolloClientUtil.a());
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      int i;
      String str1;
      String str2;
      int j;
      Object localObject3;
      int k;
      try
      {
        localObject1 = ApolloClientUtil.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label754;
          }
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, ApolloClientUtil.readFileSafety null");
          break label754;
        }
        JSONArray localJSONArray = new JSONObject((String)localObject1).optJSONObject("data").optJSONArray("thunderConfig");
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.b.clear();
        this.c.clear();
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, content:" + (String)localObject1);
        }
        if (localJSONArray == null) {
          break label614;
        }
        int m = localJSONArray.length();
        i = 0;
        if (i >= m) {
          break label614;
        }
        Object localObject2 = localJSONArray.getJSONObject(i);
        if (localObject2 == null) {
          break label756;
        }
        str1 = String.valueOf(((JSONObject)localObject2).optInt("pageId"));
        localObject1 = (Set)this.b.get(str1);
        if (localObject1 != null) {
          break label751;
        }
        localObject1 = new HashSet();
        this.b.put(str1, localObject1);
        str2 = ((JSONObject)localObject2).optString("md5");
        if (TextUtils.isEmpty(str2)) {
          break label756;
        }
        this.c.put(str1, str2);
        localObject2 = ((JSONObject)localObject2).optJSONArray("cmds");
        if (localObject2 == null) {
          break label756;
        }
        int n = ((JSONArray)localObject2).length();
        j = 0;
        if (j >= n) {
          break label756;
        }
        localObject3 = ((JSONArray)localObject2).optJSONObject(j);
        if (localObject3 == null) {
          break label763;
        }
        str2 = ((JSONObject)localObject3).optString("name");
        if (TextUtils.isEmpty(str2)) {
          break label763;
        }
        localObject4 = ((JSONObject)localObject3).optJSONArray("parameters");
        if (localObject4 == null) {
          break label763;
        }
        int i1 = ((JSONArray)localObject4).length();
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, cmdName:" + str2 + ",parameterLength:" + i1);
        }
        localObject3 = new ArrayList();
        k = 0;
        if (k < i1)
        {
          Object localObject5 = ((JSONArray)localObject4).optJSONObject(k);
          if (localObject5 == null) {
            break label770;
          }
          String str3 = ((JSONObject)localObject5).optString("key");
          if (TextUtils.isEmpty(str3)) {
            break label770;
          }
          String str4 = ((JSONObject)localObject5).optString("value");
          int i2 = ((JSONObject)localObject5).optInt("valueType");
          if ((i2 != 4) && (i2 != 5) && (TextUtils.isEmpty(str4))) {
            break label770;
          }
          localObject5 = new zbg(null);
          ((zbg)localObject5).jdField_a_of_type_JavaLangString = str3;
          ((zbg)localObject5).jdField_a_of_type_Int = i2;
          ((zbg)localObject5).b = str4;
          ((List)localObject3).add(localObject5);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        QLog.e("apollo_client_ApolloSSOConfig", 1, localException.getMessage());
        return false;
      }
      Object localObject4 = new zbf();
      ((zbf)localObject4).jdField_a_of_type_JavaLangString = str2;
      ((zbf)localObject4).b = str1;
      ((zbf)localObject4).jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(((zbf)localObject4).b, ((zbf)localObject4).jdField_a_of_type_JavaLangString), localObject4);
      localException.add(str2);
      break label763;
      label614:
      if (QLog.isColorLevel())
      {
        i = BaseApplicationImpl.getContext().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mCurrentConfigVersion:").append(i).append(",mClientUpdateHtmlMap:").append(this.c).append("mCmdConfigs:").append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).append("mClientToCmds:").append(this.b);
        QLog.d("apollo_client_ApolloSSOConfig", 2, localStringBuilder.toString());
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "updateConfigsFromDb use:" + (System.currentTimeMillis() - l));
      }
      return false;
      label751:
      continue;
      label754:
      return false;
      label756:
      i += 1;
      continue;
      label763:
      j += 1;
      continue;
      label770:
      k += 1;
    }
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (String)this.c.get(paramString);
    }
    return "";
  }
  
  public Set a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (Set)this.b.get(paramString);
    }
    return null;
  }
  
  public JSONObject a(String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramAppInterface == null)) {
      return null;
    }
    paramString2 = (zbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString2, paramString3));
    if (paramString2 != null) {
      return paramString2.a(paramString1, paramAppInterface);
    }
    return null;
  }
  
  void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    long l;
    do
    {
      return;
      localObject1 = paramAppInterface.getApplication().getSharedPreferences("sp_apollo_webView", 4);
      l = ((SharedPreferences)localObject1).getLong("sp_key_sso_check_time", 0L);
    } while (System.currentTimeMillis() - l <= 1800000L);
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject2 = paramAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.e("apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO account is null!");
      return;
    }
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("7.6.8.3615");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject2));
    int i = ((SharedPreferences)localObject1).getInt("sp_key_apollo_webView_config_version", 0);
    localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("apollo_thunder_json_v670");
    Object localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(205);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.add((MessageMicro)localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    localReqBody.rpt_msg_reqappinfo.set((List)localObject2);
    localObject1 = new NewIntent(paramAppInterface.getApp(), WebSSOAgentServlet.class);
    ((NewIntent)localObject1).putExtra("extra_cmd", "ClubContentUpdate.Req");
    ((NewIntent)localObject1).putExtra("extra_data", localReqBody.toByteArray());
    ((NewIntent)localObject1).putExtra("extra_callbackid", paramAppInterface.getCurrentAccountUin());
    ((NewIntent)localObject1).setObserver(new zbc(this, paramAppInterface));
    paramAppInterface.startServlet((NewIntent)localObject1);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO local ver: " + i);
  }
  
  public void a(AppInterface paramAppInterface, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramAppInterface == null) || (paramBundle == null)) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        Object localObject;
        try
        {
          localObject = new ClubContentUpdateInfoPb.RspBody();
          ((ClubContentUpdateInfoPb.RspBody)localObject).mergeFrom(paramBundle.getByteArray("extra_data"));
          if (((ClubContentUpdateInfoPb.RspBody)localObject).int_result.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("apollo_client_ApolloSSOConfig", 2, "handleReceiveSSO, result=" + ((ClubContentUpdateInfoPb.RspBody)localObject).int_result.get());
            return;
          }
        }
        catch (Exception paramAppInterface)
        {
          paramAppInterface.printStackTrace();
          return;
        }
        paramBundle = ((ArrayList)((ClubContentUpdateInfoPb.RspBody)localObject).rpt_msg_rspappinfo.get()).iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ClubContentUpdateInfoPb.RspAppInfo)paramBundle.next();
          if (localObject != null) {
            switch (((ClubContentUpdateInfoPb.RspAppInfo)localObject).uint_appid.get())
            {
            case 205: 
              if ((((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.has()) && (((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.size() > 0))
              {
                localObject = (ClubContentUpdateInfoPb.RspItemInfo)((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.get().get(0);
                String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
                int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
                String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
                int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
                if (1 == (j & 0x1)) {}
                for (paramBoolean = true;; paramBoolean = false)
                {
                  a(this, paramAppInterface, i, paramBoolean);
                  QLog.i("apollo_client_ApolloSSOConfig", 1, "handleApolloWebViewResponse apollo_client ApolloWebView Config json: " + str1 + ", ver: " + i + ", updateFlag: " + j + ", extStr: " + str2);
                  break;
                }
              }
              break;
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.b.containsKey(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString1, paramString2)) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig
 * JD-Core Version:    0.7.0.1
 */