package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.WadlBusinessServlet;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameNetServiceImpl
  implements IQQGameNetService
{
  private static final String TAG = "Wadl_QQGameNetServiceImpl";
  private CopyOnWriteArrayList<WeakReference<WadlCmdListener>> webssoListeners = new CopyOnWriteArrayList();
  
  private void notifyListeners(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notifyListeners cmd=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",ret=");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(",listeners size=");
    ((StringBuilder)localObject1).append(this.webssoListeners.size());
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.webssoListeners.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (WeakReference)((Iterator)localObject1).next();
      WadlCmdListener localWadlCmdListener = (WadlCmdListener)((WeakReference)localObject2).get();
      if (localWadlCmdListener != null)
      {
        localObject2 = localWadlCmdListener.getFilterCmds();
        if ((localObject2 == null) || (((HashSet)localObject2).contains(paramString)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("notifyListeners cmd=");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(",ret=");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append(",listener=");
          ((StringBuilder)localObject2).append(localWadlCmdListener);
          QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject2).toString());
          localWadlCmdListener.onCmdRsp(paramIntent, paramString, paramLong, paramJSONObject);
        }
      }
      else
      {
        this.webssoListeners.remove(localObject2);
      }
    }
  }
  
  public void addListener(WadlCmdListener paramWadlCmdListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addListener listener=");
    ((StringBuilder)localObject).append(paramWadlCmdListener);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (paramWadlCmdListener == null) {
      return;
    }
    localObject = this.webssoListeners.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WadlCmdListener localWadlCmdListener = (WadlCmdListener)((WeakReference)((Iterator)localObject).next()).get();
      if ((localWadlCmdListener != null) && (localWadlCmdListener == paramWadlCmdListener)) {
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addListener listener=");
    ((StringBuilder)localObject).append(paramWadlCmdListener);
    ((StringBuilder)localObject).append(" succ");
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    this.webssoListeners.add(new WeakReference(paramWadlCmdListener));
  }
  
  public void checkGameDownload(WadlParams paramWadlParams, Bundle paramBundle)
  {
    if (paramWadlParams == null) {
      return;
    }
    try
    {
      int i = QbSdk.getTbsVersion(MobileQQ.sMobileQQ);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkGameDownload tbsVersion=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",wadlParams=");
      ((StringBuilder)localObject).append(paramWadlParams);
      QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad_tag", paramWadlParams.n);
      localJSONObject.put("appid", paramWadlParams.a);
      localJSONObject.put("channel_id", paramWadlParams.c);
      localJSONObject.put("download_url", paramWadlParams.jdField_e_of_type_JavaLangString);
      localJSONObject.put("source_url", paramWadlParams.m);
      localJSONObject.put("refer", paramWadlParams.o);
      localJSONObject.put("version_code", String.valueOf(paramWadlParams.jdField_e_of_type_Int));
      localJSONObject.put("clientver", "8.7.0");
      localJSONObject.put("tbs_version", i);
      localJSONObject.put("net_type", NetworkUtil.getNetworkType(MobileQQ.sMobileQQ));
      ((JSONObject)localObject).put("req", localJSONObject);
      requestWebSso("12829", (JSONObject)localObject, paramBundle);
      return;
    }
    catch (Exception paramWadlParams)
    {
      QLog.e("Wadl_QQGameNetServiceImpl", 1, "checkGameDownload exception=", paramWadlParams);
    }
  }
  
  public void destroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy webssoListeners size=");
    localStringBuilder.append(this.webssoListeners.size());
    QLog.d("Wadl_QQGameNetServiceImpl", 1, localStringBuilder.toString());
    this.webssoListeners.clear();
  }
  
  public void getApkDownloadInfo(String paramString, ArrayList<String> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayList != null)
    {
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put((String)((Iterator)localObject).next());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getApkDownloadInfo channelId=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",appIds=");
    ((StringBuilder)localObject).append(localJSONArray);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", paramString);
      localJSONObject.put("v_appid", localJSONArray);
      ((JSONObject)localObject).put("req", localJSONObject);
      paramString = new Bundle();
      paramString.putStringArrayList("appids", paramArrayList);
      requestWebSso("13169", (JSONObject)localObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_QQGameNetServiceImpl", 1, "getApkDownloadInfo exception=", paramString);
    }
  }
  
  public void getAutoDownloadApk()
  {
    QLog.d("Wadl_QQGameNetServiceImpl", 1, "getAutoDownloadApk...");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("qq_version", AppSetting.f());
      localJSONObject1.put("req", localJSONObject2);
      requestWebSso("13625", localJSONObject1, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Wadl_QQGameNetServiceImpl", 1, "getAutoDownloadApk exception=", localException);
    }
  }
  
  public void getFloadWindowInfo(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getFloadWindowInfo appid=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", paramString);
        localJSONObject2.put("tt", 1);
        localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null)
        {
          localObject = ((AppRuntime)localObject).getAccount();
          localJSONObject2.put("uin", localObject);
          localJSONObject2.put("skey", GameCenterUtil.b());
          localJSONObject1.put("req", localJSONObject2);
          localObject = new Bundle();
          ((Bundle)localObject).putString("appid", paramString);
          requestWebSso("13126", localJSONObject1, (Bundle)localObject);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("Wadl_QQGameNetServiceImpl", 1, "getFloadWindowInfo exception=", paramString);
        return;
      }
      localObject = "";
    }
  }
  
  public void getGameRegisterInfo(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getGameRegisterInfo appId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("game_appid", paramString);
      localJSONObject.put("qq_plat", 1);
      localJSONObject.put("qq_version", "8.7.0.5295");
      ((JSONObject)localObject).put("req", localJSONObject);
      requestWebSso("12855", (JSONObject)localObject, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_QQGameNetServiceImpl", 1, "getGameRegisterInfo exception=", paramString);
    }
  }
  
  public void onRespWebSso(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("webssoCmdId");
    String str = "";
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    long l3 = -1L;
    long l2;
    long l1;
    if ((paramBoolean) && (paramArrayOfByte != null))
    {
      try
      {
        localObject2 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(paramArrayOfByte);
        l2 = ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get();
        l1 = l2;
        if (l2 != 0L) {
          break label221;
        }
        try
        {
          paramArrayOfByte = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).optJSONObject((String)localObject1);
          l1 = l2;
          if (paramArrayOfByte == null) {
            break label221;
          }
          paramArrayOfByte = paramArrayOfByte.optJSONObject("data");
          l1 = l2;
          if (paramArrayOfByte == null) {
            break label221;
          }
          paramArrayOfByte = paramArrayOfByte.optJSONObject("rsp");
          l1 = l2;
        }
        catch (Exception paramArrayOfByte)
        {
          l1 = l2;
        }
        localObject2 = new StringBuilder();
      }
      catch (Exception paramArrayOfByte)
      {
        l1 = -1L;
      }
      ((StringBuilder)localObject2).append("onRespWebSso cmdId=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",err:");
      ((StringBuilder)localObject2).append(paramArrayOfByte.getMessage());
      QLog.e("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject2).toString());
    }
    else
    {
      l1 = -1L;
    }
    label221:
    paramArrayOfByte = null;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onRespWebSso cmdId=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(",isSucc=");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(",ret=");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(",rspJson=");
    ((StringBuilder)localObject2).append(paramArrayOfByte);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject2).toString());
    if (!"12934".equals(localObject1))
    {
      if ("13325".equals(localObject1)) {
        return;
      }
      if (paramArrayOfByte == null) {
        paramArrayOfByte = new JSONObject();
      }
      if ("13136".equals(localObject1))
      {
        l2 = l3;
        if (paramBoolean)
        {
          l2 = paramArrayOfByte.optLong("version", -1L);
          str = paramArrayOfByte.optString("content");
        }
        ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).writeConfig(paramBoolean, str, l2);
      }
      else if (("12829".equals(localObject1)) && (l1 == 0L))
      {
        GameCenterSpUtils.a(paramIntent.getExtras().getString("appId"), paramArrayOfByte);
      }
      notifyListeners(paramIntent, (String)localObject1, l1, paramArrayOfByte);
    }
  }
  
  public void removeListener(WadlCmdListener paramWadlCmdListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addListener listener=");
    ((StringBuilder)localObject).append(paramWadlCmdListener);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (paramWadlCmdListener == null) {
      return;
    }
    localObject = this.webssoListeners.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WadlCmdListener localWadlCmdListener = (WadlCmdListener)((WeakReference)((Iterator)localObject).next()).get();
      if ((localWadlCmdListener != null) && (localWadlCmdListener == paramWadlCmdListener)) {
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addListener listener=");
    ((StringBuilder)localObject).append(paramWadlCmdListener);
    ((StringBuilder)localObject).append(" succ");
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    this.webssoListeners.add(new WeakReference(paramWadlCmdListener));
  }
  
  public void reportDownloadStart(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    QLog.d("Wadl_QQGameNetServiceImpl", 1, "reportDownloadStart...");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      if (paramJSONArray1 != null) {
        localJSONObject2.put("appid_list", paramJSONArray1);
      }
      if (paramJSONArray2 != null) {
        localJSONObject2.put("res_list", paramJSONArray2);
      }
      localJSONObject1.put("req", localJSONObject2);
      requestWebSso("12952", localJSONObject1, null);
      return;
    }
    catch (Exception paramJSONArray1)
    {
      QLog.e("Wadl_QQGameNetServiceImpl", 1, "reportDownloadStart exception=", paramJSONArray1);
    }
  }
  
  public void requestArk(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestArk appId=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",arkType=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      localJSONObject.put("ark_type", paramInt);
      ((JSONObject)localObject).put("req", localJSONObject);
      requestWebSso("13665", (JSONObject)localObject, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_QQGameNetServiceImpl", 1, "requestArk exception=", paramString);
    }
  }
  
  public void requestRedPoint(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestRedPoint sceneId=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scene_id", paramInt);
      localJSONObject.put("uin", GameCenterUtil.a());
      localJSONObject.put("tt", 1);
      ((JSONObject)localObject).put("req", localJSONObject);
      requestWebSso("13325", (JSONObject)localObject, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Wadl_QQGameNetServiceImpl", 1, "requestRedPoint exception=", localException);
    }
  }
  
  public void requestWebSso(String paramString, JSONObject paramJSONObject, Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestWebSso webssoCmd=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",reqData=");
    ((StringBuilder)localObject1).append(paramJSONObject);
    QLog.d("Wadl_QQGameNetServiceImpl", 1, ((StringBuilder)localObject1).toString());
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject1 == null) {
        return;
      }
      try
      {
        Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0.5295");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject2);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put(paramString, paramJSONObject);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject2).toString());
        localObject2 = new NewIntent(MobileQQ.sMobileQQ, WadlBusinessServlet.class);
        paramJSONObject = paramBundle;
        if (paramBundle == null) {
          paramJSONObject = new Bundle();
        }
        paramJSONObject.putInt("wadl_sso_type", 0);
        paramJSONObject.putString("webssoCmdId", paramString);
        paramJSONObject.putByteArray("webssoReq", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject2).putExtras(paramJSONObject);
        ((AppRuntime)localObject1).startServlet((NewIntent)localObject2);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("Wadl_QQGameNetServiceImpl", 1, "requestWebSso exception=", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameNetServiceImpl
 * JD-Core Version:    0.7.0.1
 */