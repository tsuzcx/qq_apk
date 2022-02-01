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
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

public class ApolloSSOConfig
{
  private final ConcurrentHashMap<String, ApolloSSOConfig.ThunderConfig> a = new ConcurrentHashMap();
  
  public ApolloSSOConfig()
  {
    if (a()) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if (localAppInterface == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, "new ApolloSSOConfig updateConfigsFromDb=false, checkUpdateApolloWebViewConfig");
    }
    a(this, localAppInterface, i, true);
  }
  
  private void a(AppInterface paramAppInterface, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramAppInterface != null)
    {
      if (paramBundle == null) {
        return;
      }
      if (!paramBoolean) {
        return;
      }
      try
      {
        Object localObject1 = new ClubContentUpdateInfoPb.RspBody();
        ((ClubContentUpdateInfoPb.RspBody)localObject1).mergeFrom(paramBundle.getByteArray("extra_data"));
        if (((ClubContentUpdateInfoPb.RspBody)localObject1).int_result.get() != 0)
        {
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("handleReceiveSSO, result=");
            paramAppInterface.append(((ClubContentUpdateInfoPb.RspBody)localObject1).int_result.get());
            QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, paramAppInterface.toString());
          }
        }
        else
        {
          paramBundle = ((ArrayList)((ClubContentUpdateInfoPb.RspBody)localObject1).rpt_msg_rspappinfo.get()).iterator();
          while (paramBundle.hasNext())
          {
            localObject1 = (ClubContentUpdateInfoPb.RspAppInfo)paramBundle.next();
            if ((localObject1 != null) && (((ClubContentUpdateInfoPb.RspAppInfo)localObject1).uint_appid.get() == 205) && (((ClubContentUpdateInfoPb.RspAppInfo)localObject1).rpt_msg_rspiteminfo.has()) && (((ClubContentUpdateInfoPb.RspAppInfo)localObject1).rpt_msg_rspiteminfo.size() > 0))
            {
              localObject1 = ((ClubContentUpdateInfoPb.RspAppInfo)localObject1).rpt_msg_rspiteminfo.get();
              paramBoolean = false;
              Object localObject2 = (ClubContentUpdateInfoPb.RspItemInfo)((List)localObject1).get(0);
              localObject1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).str_name.get();
              int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).uint_version.get();
              String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).str_extend.get();
              int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).uint_update_flag.get();
              if (1 == (j & 0x1)) {
                paramBoolean = true;
              }
              a(this, paramAppInterface, i, paramBoolean);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleApolloWebViewResponse apollo_client ApolloWebView Config json: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(", ver: ");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(", updateFlag: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(", extStr: ");
              ((StringBuilder)localObject2).append(str);
              QLog.i("[cmshow]apollo_client_ApolloSSOConfig", 1, ((StringBuilder)localObject2).toString());
            }
          }
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("handleReceiveSSO error :");
        paramBundle.append(paramAppInterface.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloSSOConfig", 1, paramBundle.toString());
      }
    }
  }
  
  public static void a(ApolloSSOConfig paramApolloSSOConfig, AppRuntime paramAppRuntime, int paramInt, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("sp_apollo_webView", 4);
    int i = localSharedPreferences.getInt("sp_key_apollo_webView_config_version", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apollo_client checkUpdateApolloWebViewConfig, oldVersion");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",version:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(ApolloClientUtil.a());
    boolean bool = paramBoolean;
    if (paramInt > 0)
    {
      bool = paramBoolean;
      if (!((File)localObject).exists()) {
        bool = true;
      }
    }
    localSharedPreferences.edit().putLong("sp_key_sso_check_time", System.currentTimeMillis()).commit();
    if ((!bool) && (paramInt <= i))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig local config is new， not need to download");
      }
      return;
    }
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    ((File)localObject).getParentFile().mkdirs();
    localObject = new DownloadTask("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_thunder_config/xydata.json", (File)localObject);
    ((DownloadTask)localObject).p = true;
    ((DownloadTask)localObject).n = true;
    ((DownloadTask)localObject).f = "apollo_res";
    ((DownloadTask)localObject).b = 1;
    ((DownloadTask)localObject).q = true;
    ((DownloadTask)localObject).r = true;
    ((DownloadTask)localObject).a(new ApolloSSOConfig.2(localSharedPreferences, paramInt, paramApolloSSOConfig));
    ThreadManager.executeOnNetWorkThread(new ApolloSSOConfig.3(paramAppRuntime, (DownloadTask)localObject));
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(ApolloClientUtil.a());
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateConfigsFromDb use:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    Object localObject2;
    Object localObject3;
    try
    {
      localObject1 = ApolloClientUtil.a((File)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!QLog.isColorLevel()) {
          break label1249;
        }
        QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, ApolloClientUtil.readFileSafety null");
        return false;
      }
      localObject2 = new JSONObject((String)localObject1).optJSONObject("data").optJSONArray("thunderConfig");
      this.a.clear();
      if (!QLog.isColorLevel()) {
        break label1251;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("updateConfigsFromDb, content:");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 1, ((StringBuilder)localObject3).toString());
    }
    catch (Exception localException3) {}
    int j = ((JSONArray)localObject2).length();
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      int i1;
      for (;;)
      {
        int m;
        int n;
        try
        {
          localObject6 = ((JSONArray)localObject2).getJSONObject(i);
          if (localObject6 == null) {
            break label1258;
          }
          i2 = ((JSONObject)localObject6).optInt("pageId");
          localObject1 = ((JSONObject)localObject6).optString("md5");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1258;
          }
          localThunderConfig = new ApolloSSOConfig.ThunderConfig();
          localThunderConfig.jdField_a_of_type_Int = i2;
          localThunderConfig.jdField_a_of_type_JavaLangString = ((String)localObject1);
          this.a.put(String.valueOf(i2), localThunderConfig);
          JSONArray localJSONArray = ((JSONObject)localObject6).optJSONArray("cmds");
          localObject1 = "valueType";
          localObject5 = "parameters";
          m = j;
          Object localObject4 = localObject2;
          int k = i;
          localObject3 = localObject1;
          if (localJSONArray != null)
          {
            n = localJSONArray.length();
            i1 = 0;
            m = j;
            localObject4 = localObject2;
            k = i;
            localObject3 = localObject1;
            if (i1 < n)
            {
              localObject3 = localJSONArray.optJSONObject(i1);
              if (localObject3 == null) {
                break label1268;
              }
              localObject4 = ((JSONObject)localObject3).optString("name");
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label1271;
              }
              localObject3 = ((JSONObject)localObject3).optJSONArray("parameters");
              if (localObject3 == null) {
                break label1271;
              }
              k = ((JSONArray)localObject3).length();
              boolean bool = QLog.isColorLevel();
              if (bool)
              {
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append("updateConfigsFromDb, cmdName:");
                ((StringBuilder)localObject7).append((String)localObject4);
                ((StringBuilder)localObject7).append(",parameterLength:");
                ((StringBuilder)localObject7).append(k);
                QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 1, ((StringBuilder)localObject7).toString());
              }
              localObject7 = new ArrayList();
              m = 0;
              if (m < k)
              {
                localObject8 = ((JSONArray)localObject3).optJSONObject(m);
                if (localObject8 == null) {
                  break label1274;
                }
                str1 = ((JSONObject)localObject8).optString("key");
                if (TextUtils.isEmpty(str1)) {
                  break label1274;
                }
                str2 = ((JSONObject)localObject8).optString("value");
                int i3 = ((JSONObject)localObject8).optInt((String)localObject1);
                localObject8 = new ApolloSSOConfig.CmdParameter(null);
                ((ApolloSSOConfig.CmdParameter)localObject8).jdField_a_of_type_JavaLangString = str1;
                ((ApolloSSOConfig.CmdParameter)localObject8).jdField_a_of_type_Int = i3;
                ((ApolloSSOConfig.CmdParameter)localObject8).b = str2;
                ((List)localObject7).add(localObject8);
                break label1274;
              }
              localObject3 = new ApolloSSOConfig.CmdConfig();
              ((ApolloSSOConfig.CmdConfig)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
              ((ApolloSSOConfig.CmdConfig)localObject3).jdField_a_of_type_Int = i2;
              ((ApolloSSOConfig.CmdConfig)localObject3).jdField_a_of_type_JavaUtilList.addAll((Collection)localObject7);
              localThunderConfig.jdField_a_of_type_JavaUtilList.add(localObject3);
              break label1283;
            }
          }
          localObject2 = localObject3;
          localJSONArray = ((JSONObject)localObject6).optJSONArray("cgis");
          j = m;
          localObject3 = localObject4;
          i1 = k;
          if (localJSONArray == null) {
            break label1319;
          }
          i = localJSONArray.length();
          n = 0;
          localObject1 = localObject5;
          j = m;
          localObject3 = localObject4;
          i1 = k;
          if (n >= i) {
            break label1319;
          }
          localObject5 = localJSONArray.optJSONObject(n);
          if (localObject5 == null) {
            break label1292;
          }
          str1 = ((JSONObject)localObject5).optString("url");
          if (TextUtils.isEmpty(str1)) {
            break label1292;
          }
          str2 = ((JSONObject)localObject5).optString("method");
          if (TextUtils.isEmpty(str2)) {
            break label1292;
          }
          localObject3 = new ApolloSSOConfig.CGIConfig();
          ((ApolloSSOConfig.CGIConfig)localObject3).jdField_a_of_type_JavaLangString = str1;
          ((ApolloSSOConfig.CGIConfig)localObject3).b = str2;
          localObject7 = ((JSONObject)localObject5).optJSONArray((String)localObject1);
          if (localObject7 == null) {
            break label1307;
          }
          i1 = ((JSONArray)localObject7).length();
          localObject6 = new ArrayList();
          if (!QLog.isColorLevel()) {
            break label1295;
          }
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("updateConfigsFromDb cgis url:");
          ((StringBuilder)localObject8).append(str1);
          ((StringBuilder)localObject8).append(" method:");
          ((StringBuilder)localObject8).append(str2);
          ((StringBuilder)localObject8).append(" parameterLength:");
          ((StringBuilder)localObject8).append(i1);
          QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, ((StringBuilder)localObject8).toString());
        }
        catch (Exception localException2)
        {
          Object localObject6;
          int i2;
          ApolloSSOConfig.ThunderConfig localThunderConfig;
          Object localObject5;
          Object localObject7;
          Object localObject8;
          String str1;
          String str2;
          break label1196;
        }
        if (j < i1)
        {
          localObject8 = ((JSONArray)localObject7).optJSONObject(j);
          if (localObject8 != null)
          {
            str1 = ((JSONObject)localObject8).optString("key");
            if (!TextUtils.isEmpty(str1))
            {
              str2 = ((JSONObject)localObject8).optString("value");
              i2 = ((JSONObject)localObject8).optInt((String)localObject2);
              localObject8 = new ApolloSSOConfig.CmdParameter(null);
              ((ApolloSSOConfig.CmdParameter)localObject8).jdField_a_of_type_JavaLangString = str1;
              ((ApolloSSOConfig.CmdParameter)localObject8).jdField_a_of_type_Int = i2;
              ((ApolloSSOConfig.CmdParameter)localObject8).b = str2;
              ((List)localObject6).add(localObject8);
            }
          }
        }
        else
        {
          ((ApolloSSOConfig.CGIConfig)localObject3).jdField_a_of_type_JavaUtilList.addAll((Collection)localObject6);
          localObject5 = ((JSONObject)localObject5).optJSONObject("headers");
          if (localObject5 != null)
          {
            localObject6 = ((JSONObject)localObject5).keys();
            if (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              ((ApolloSSOConfig.CGIConfig)localObject3).jdField_a_of_type_JavaUtilHashMap.put(localObject7, ((JSONObject)localObject5).optString((String)localObject7));
              continue;
            }
          }
          localThunderConfig.b.add(localObject3);
          break label1310;
          if (QLog.isColorLevel())
          {
            i = BaseApplicationImpl.getContext().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mCurrentConfigVersion:");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("mThunderConfigs:");
            try
            {
              ((StringBuilder)localObject1).append(this.a);
              QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, ((StringBuilder)localObject1).toString());
            }
            catch (Exception localException1)
            {
              break label1196;
            }
          }
          return true;
          label1196:
          if (QLog.isColorLevel()) {
            localException3.printStackTrace();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateConfigsFromDb error :");
          ((StringBuilder)localObject2).append(localException3.getMessage());
          QLog.e("[cmshow]apollo_client_ApolloSSOConfig", 1, ((StringBuilder)localObject2).toString());
          return false;
          label1249:
          return false;
          label1251:
          if (localObject2 != null) {
            break;
          }
          return false;
          label1258:
          localObject3 = localObject2;
          i1 = i;
          break label1319;
          for (;;)
          {
            label1268:
            break label1283;
            label1271:
            continue;
            label1274:
            m += 1;
            break;
          }
          label1283:
          i1 += 1;
          continue;
          label1292:
          break label1310;
          label1295:
          j = 0;
          continue;
        }
        j += 1;
        continue;
        label1307:
        continue;
        label1310:
        n += 1;
      }
      label1319:
      i = i1 + 1;
      localObject2 = localObject3;
    }
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (ApolloSSOConfig.ThunderConfig)this.a.get(paramString);
      if (paramString != null) {
        return paramString.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public List<ApolloSSOConfig.CGIConfig> a(String paramString)
  {
    paramString = (ApolloSSOConfig.ThunderConfig)this.a.get(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return null;
  }
  
  public Set<String> a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (ApolloSSOConfig.ThunderConfig)this.a.get(paramString);
      if (localObject != null)
      {
        paramString = new HashSet();
        localObject = ((ApolloSSOConfig.ThunderConfig)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloSSOConfig.CmdConfig localCmdConfig = (ApolloSSOConfig.CmdConfig)((Iterator)localObject).next();
          if ((localCmdConfig != null) && (!TextUtils.isEmpty(localCmdConfig.jdField_a_of_type_JavaLangString))) {
            paramString.add(localCmdConfig.jdField_a_of_type_JavaLangString);
          }
        }
        return paramString;
      }
    }
    return null;
  }
  
  public JSONObject a(String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (paramAppInterface == null) {
        return null;
      }
      paramString2 = (ApolloSSOConfig.ThunderConfig)this.a.get(paramString2);
      if (paramString2 != null)
      {
        paramString2 = paramString2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString2.hasNext())
        {
          ApolloSSOConfig.CmdConfig localCmdConfig = (ApolloSSOConfig.CmdConfig)paramString2.next();
          if ((localCmdConfig != null) && (paramString3.equals(localCmdConfig.jdField_a_of_type_JavaLangString))) {
            return localCmdConfig.a(paramString1, paramAppInterface);
          }
        }
      }
    }
    return null;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    Object localObject1 = paramAppInterface.getApplication().getSharedPreferences("sp_apollo_webView", 4);
    long l = ((SharedPreferences)localObject1).getLong("sp_key_sso_check_time", 0L);
    if (System.currentTimeMillis() - l > 1800000L)
    {
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject2 = paramAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("[cmshow]apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO account is null!");
        return;
      }
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("8.7.0.5295");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject2));
      int i = ((SharedPreferences)localObject1).getInt("sp_key_apollo_webView_config_version", 0);
      localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("apollo_thunder_json_v670");
      localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(205);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.add((MessageMicro)localObject2);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      localReqBody.rpt_msg_reqappinfo.set((List)localObject2);
      localObject1 = new NewIntent(paramAppInterface.getApp(), WebSSOAgentServlet.class);
      ((NewIntent)localObject1).putExtra("extra_cmd", "ClubContentUpdate.Req");
      ((NewIntent)localObject1).putExtra("extra_data", localReqBody.toByteArray());
      ((NewIntent)localObject1).putExtra("extra_callbackid", paramAppInterface.getCurrentAccountUin());
      ((NewIntent)localObject1).setObserver(new ApolloSSOConfig.1(this, paramAppInterface));
      paramAppInterface.startServlet((NewIntent)localObject1);
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("checkRequestSendSSO local ver: ");
      paramAppInterface.append(i);
      QLog.i("[cmshow]apollo_client_ApolloSSOConfig", 1, paramAppInterface.toString());
    }
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.a.containsKey(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (ApolloSSOConfig.ThunderConfig)this.a.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          ApolloSSOConfig.CmdConfig localCmdConfig = (ApolloSSOConfig.CmdConfig)paramString1.next();
          if ((localCmdConfig != null) && (paramString2.equals(localCmdConfig.jdField_a_of_type_JavaLangString))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig
 * JD-Core Version:    0.7.0.1
 */