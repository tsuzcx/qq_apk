package com.tencent.hippy.qq.update.sso;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.api.TabFile;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfReq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyUnissoHandler
  extends BusinessHandler
{
  public static final String CMD_HIPPY_REPORT = "GameCenterHippy.Report";
  public static final String CMD_TRPC_GAME_CENTER_HIPPY_CONFIG = "/v1/33";
  private static String TAG = "HippyUnissoHandler";
  public static final int WEBSSO_PLATFORM_ANDROID = 109;
  private AppInterface mApp;
  private WadlTrpcListener mTrpcListener = new HippyUnissoHandler.1(this);
  
  public HippyUnissoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.mApp = paramAppInterface;
  }
  
  private MobileConfReq createCheckPreloadReq(String paramString, int paramInt)
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    for (;;)
    {
      try
      {
        localMobileConfReq.configType.set(6);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("bundleName", paramString);
        i = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString);
        int j = 0;
        if (i <= 0) {
          break label263;
        }
        i = 1;
        ((JSONObject)localObject).put("isBundleExist", i);
        i = j;
        if (TabPreloadManager.getInstance().hasNewMessage(paramString)) {
          i = 1;
        }
        ((JSONObject)localObject).put("isHighPriority", i);
        ((JSONObject)localObject).put("scene", paramInt);
        localMobileConfReq.busiReq.set(((JSONObject)localObject).toString());
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("hippyUpdateAction-");
          paramString.append(TAG);
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[createCheckPreloadReq] jsonData: ");
          localStringBuilder.append(localObject);
          QLog.d(paramString, 2, localStringBuilder.toString());
          return localMobileConfReq;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hippyUpdateAction-");
        ((StringBuilder)localObject).append(TAG);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createCheckPreloadReq e:");
        localStringBuilder.append(paramString);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      return localMobileConfReq;
      label263:
      int i = 0;
    }
  }
  
  private CommonReq createCommonHippyReq(long paramLong1, long paramLong2)
  {
    CommonReq localCommonReq = new CommonReq();
    try
    {
      localCommonReq.cpuCoreCount.set(DeviceInfoUtil.b());
      localCommonReq.manufacturer.set(Build.BRAND);
      localCommonReq.model.set(Build.MODEL);
      localCommonReq.osVersionCode.set(Build.VERSION.SDK_INT);
      localCommonReq.qqVersion.set(DeviceInfoUtil.a(MobileQQ.getContext()));
      localCommonReq.totalMemory.set((int)(DeviceInfoUtil.a() / 1048576L));
      localCommonReq.lastPreDownloadTime.set(paramLong1);
      localCommonReq.lastUpdateTime.set(paramLong2);
      return localCommonReq;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippyUpdateAction-");
      ((StringBuilder)localObject).append(TAG);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createCommonHippyReq e:");
      localStringBuilder.append(localThrowable);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    return localCommonReq;
  }
  
  private MobileConfReq createHippyConfigReq()
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    try
    {
      localMobileConfReq.configType.set(1);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("qqGameCenterBundleVersion", UpdateSetting.getInstance().getModuleVersion("QQGameCenter"));
      localMobileConfReq.busiReq.set(localJSONObject.toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hippyUpdateAction-");
        ((StringBuilder)localObject).append(TAG);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[createPreloadConfigReq] hippyConfig: ");
        localStringBuilder.append(localJSONObject);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        return localMobileConfReq;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippyUpdateAction-");
      ((StringBuilder)localObject).append(TAG);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createHippyConfigReq e:");
      localStringBuilder.append(localThrowable);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    return localMobileConfReq;
  }
  
  private MobileConfReq createHippyUpdateReq(int paramInt1, Map<String, Integer> paramMap, int paramInt2)
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    try
    {
      localMobileConfReq.configType.set(2);
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("bundleName", str);
          localJSONObject.put("bundleVersion", paramMap.get(str));
          ((JSONArray)localObject2).put(localJSONObject);
        }
      }
      ((JSONObject)localObject1).put("bundleList", localObject2);
      ((JSONObject)localObject1).put("sdkVersion", "3.0");
      ((JSONObject)localObject1).put("channel", "10001");
      ((JSONObject)localObject1).put("guid", HippyQQUpdateManager.getGuid());
      ((JSONObject)localObject1).put("type", paramInt2);
      ((JSONObject)localObject1).put("source", paramInt1);
      localMobileConfReq.busiReq.set(((JSONObject)localObject1).toString());
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("hippyUpdateAction-");
        paramMap.append(TAG);
        paramMap = paramMap.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[createPreloadConfigReq] hippyBundleJson: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d(paramMap, 2, ((StringBuilder)localObject2).toString());
        return localMobileConfReq;
      }
    }
    catch (Throwable paramMap)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("hippyUpdateAction-");
      ((StringBuilder)localObject1).append(TAG);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createPreloadConfigReq e:");
      ((StringBuilder)localObject2).append(paramMap);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return localMobileConfReq;
  }
  
  private MobileConfReq createTabConfigReq(Map<String, String> paramMap)
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    try
    {
      localMobileConfReq.configType.set(3);
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((JSONObject)localObject2).put(str, paramMap.get(str));
        }
      }
      ((JSONObject)localObject1).put("tabFileMd5", localObject2);
      ((JSONObject)localObject1).put("source", 1);
      localMobileConfReq.busiReq.set(((JSONObject)localObject1).toString());
      return localMobileConfReq;
    }
    catch (Throwable paramMap)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("hippyUpdateAction-");
      ((StringBuilder)localObject1).append(TAG);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createTabConfigReq e:");
      ((StringBuilder)localObject2).append(paramMap);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return localMobileConfReq;
  }
  
  private MobileConfReq createTabPreloadConfigReq()
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    try
    {
      localMobileConfReq.configType.set(5);
      localMobileConfReq.busiReq.set("");
      return localMobileConfReq;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippyUpdateAction-");
      ((StringBuilder)localObject).append(TAG);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createTabPreloadConfigReq e:");
      localStringBuilder.append(localThrowable);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    return localMobileConfReq;
  }
  
  public static HippyUnissoHandler getInstance()
  {
    AppInterface localAppInterface = ((IHippyUtils)QRoute.api(IHippyUtils.class)).getAppInterface();
    if (localAppInterface != null) {
      return (HippyUnissoHandler)localAppInterface.getBusinessHandler(HippyUnissoHandler.class.getName());
    }
    return null;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("GameCenterHippy.Report");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return HippyUnissoObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = paramIntent.getStringExtra("cmd");
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = TAG;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[onReceive], cmd:");
      paramArrayOfByte.append(paramIntent);
      QLog.d(paramFromServiceMsg, 2, paramArrayOfByte.toString());
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void reportHippy(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0.5295");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("req", paramJSONObject);
      ((JSONObject)localObject).put("GameCenterHippy.Report", localJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramJSONObject = new NewIntent(this.mApp.getApp(), HippyUnissoServlet.class);
      paramJSONObject.putExtra("cmd", "GameCenterHippy.Report");
      paramJSONObject.putExtra("data", localUniSsoServerReq.toByteArray());
      this.mApp.startServlet(paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void requestHippyConfig(int paramInt1, String paramString, int paramInt2, long paramLong, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("hippyUpdateAction-");
      ((StringBuilder)localObject1).append(TAG);
      QLog.d(((StringBuilder)localObject1).toString(), 2, "[requestHippyConfig]");
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("hippyUpdateAction-");
      paramString.append(TAG);
      QLog.e(paramString.toString(), 1, "[requestHippyConfig] moduleName is empty, return.");
      return;
    }
    Object localObject2 = "";
    boolean bool;
    try
    {
      localObject3 = HippyUpdateManager.getInstance().getTabFilesConfig();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Map)localObject3).containsKey(paramString)) {
          localObject1 = ((TabFile)((Map)localObject3).get(paramString)).tabFileMd5;
        }
      }
      localObject2 = new HashMap();
      ((Map)localObject2).put(paramString, localObject1);
      localObject2 = createTabConfigReq((Map)localObject2);
      localObject3 = createHippyConfigReq();
      localObject1 = new HashMap();
      ((Map)localObject1).put(paramString, Integer.valueOf(paramInt2));
      localMobileConfReq = createHippyUpdateReq(paramInt1, (Map)localObject1, 2);
      localObject1 = null;
      if (paramBundle == null) {
        bool = false;
      } else {
        bool = paramBundle.getBoolean("isCheckPreload");
      }
    }
    catch (Exception paramString)
    {
      Object localObject3;
      MobileConfReq localMobileConfReq;
      paramBundle = new StringBuilder();
      paramBundle.append("hippyUpdateAction-");
      paramBundle.append(TAG);
      QLog.e(paramBundle.toString(), 1, paramString.toString());
      return;
    }
    for (paramInt1 = paramBundle.getInt("preloadSceneType");; paramInt1 = 0)
    {
      localObject1 = createCheckPreloadReq(paramString, paramInt1);
      do
      {
        paramString = new CommonMobileConfQueryReq();
        CommonReq localCommonReq = createCommonHippyReq(0L, paramLong);
        paramString.commonReq.set(localCommonReq);
        paramString.reqConfList.add(localMobileConfReq);
        paramString.reqConfList.add((MessageMicro)localObject3);
        paramString.reqConfList.add((MessageMicro)localObject2);
        if (localObject1 != null) {
          paramString.reqConfList.add((MessageMicro)localObject1);
        }
        paramString = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/33", false, paramString.toByteArray());
        localObject1 = new TrpcProxy.TrpcListReq();
        ((TrpcProxy.TrpcListReq)localObject1).list.add(paramString);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject1, paramBundle);
        return;
      } while (!bool);
      if (paramBundle != null) {
        break;
      }
    }
  }
  
  public void requestPreDownloadConfig(int paramInt, Map<String, Integer> paramMap, long paramLong, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippyUpdateAction-");
      ((StringBuilder)localObject).append(TAG);
      QLog.d(((StringBuilder)localObject).toString(), 2, "[requestPreDownloadConfig]");
    }
    try
    {
      localObject = createCommonHippyReq(paramLong, 0L);
      MobileConfReq localMobileConfReq1 = createHippyConfigReq();
      paramMap = createHippyUpdateReq(paramInt, paramMap, 1);
      MobileConfReq localMobileConfReq2 = createTabPreloadConfigReq();
      CommonMobileConfQueryReq localCommonMobileConfQueryReq = new CommonMobileConfQueryReq();
      localCommonMobileConfQueryReq.commonReq.set((MessageMicro)localObject);
      localCommonMobileConfQueryReq.reqConfList.add(localMobileConfReq1);
      localCommonMobileConfQueryReq.reqConfList.add(paramMap);
      localCommonMobileConfQueryReq.reqConfList.add(localMobileConfReq2);
      paramMap = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/33", false, localCommonMobileConfQueryReq.toByteArray());
      localObject = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject).list.add(paramMap);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject, paramBundle);
      return;
    }
    catch (Throwable paramMap)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("hippyUpdateAction-");
      paramBundle.append(TAG);
      QLog.e(paramBundle.toString(), 1, paramMap.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sso.HippyUnissoHandler
 * JD-Core Version:    0.7.0.1
 */