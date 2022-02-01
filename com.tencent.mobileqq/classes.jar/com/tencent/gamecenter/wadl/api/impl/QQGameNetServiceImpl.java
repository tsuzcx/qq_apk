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
  private static final String TAG = "QQGameNetServiceImpl";
  private CopyOnWriteArrayList<WeakReference<WadlCmdListener>> webssoListeners = new CopyOnWriteArrayList();
  
  private void notifyListeners(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listeners size=" + this.webssoListeners.size());
    }
    Iterator localIterator = this.webssoListeners.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      WadlCmdListener localWadlCmdListener = (WadlCmdListener)((WeakReference)localObject).get();
      if (localWadlCmdListener != null)
      {
        localObject = localWadlCmdListener.getFilterCmds();
        if ((localObject == null) || (((HashSet)localObject).contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQGameNetServiceImpl", 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listener=" + localWadlCmdListener);
          }
          localWadlCmdListener.onCmdRsp(paramIntent, paramString, paramLong, paramJSONObject);
        }
      }
      else
      {
        this.webssoListeners.remove(localObject);
      }
    }
  }
  
  public void addListener(WadlCmdListener paramWadlCmdListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 1, "addListener listener=" + paramWadlCmdListener);
    }
    if (paramWadlCmdListener == null) {
      return;
    }
    Iterator localIterator = this.webssoListeners.iterator();
    while (localIterator.hasNext())
    {
      WadlCmdListener localWadlCmdListener = (WadlCmdListener)((WeakReference)localIterator.next()).get();
      if ((localWadlCmdListener != null) && (localWadlCmdListener == paramWadlCmdListener)) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 1, "addListener listener=" + paramWadlCmdListener + " succ");
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("QQGameNetServiceImpl", 2, "checkGameDownload tbsVersion=" + i + ",wadlParams=" + paramWadlParams);
      }
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("ad_tag", paramWadlParams.n);
      localJSONObject2.put("appid", paramWadlParams.a);
      localJSONObject2.put("channel_id", paramWadlParams.c);
      localJSONObject2.put("download_url", paramWadlParams.jdField_e_of_type_JavaLangString);
      localJSONObject2.put("source_url", paramWadlParams.m);
      localJSONObject2.put("refer", paramWadlParams.o);
      localJSONObject2.put("version_code", String.valueOf(paramWadlParams.jdField_e_of_type_Int));
      localJSONObject2.put("clientver", "8.5.5");
      localJSONObject2.put("tbs_version", i);
      localJSONObject2.put("net_type", NetworkUtil.b(MobileQQ.sMobileQQ));
      localJSONObject1.put("req", localJSONObject2);
      requestWebSso("12829", localJSONObject1, paramBundle);
      return;
    }
    catch (Exception paramWadlParams)
    {
      QLog.e("QQGameNetServiceImpl", 1, "checkGameDownload exception=", paramWadlParams);
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "destroy webssoListeners size=" + this.webssoListeners.size());
    }
    this.webssoListeners.clear();
  }
  
  public void getApkDownloadInfo(String paramString, ArrayList<String> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject;
    if (paramArrayList != null)
    {
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put((String)((Iterator)localObject).next());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "getApkDownloadInfo channelId=" + paramString + ",appIds=" + localJSONArray);
    }
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
      QLog.e("QQGameNetServiceImpl", 1, "getApkDownloadInfo exception=", paramString);
    }
  }
  
  public void getAutoDownloadApk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "getAutoDownloadApk...");
    }
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
      QLog.e("QQGameNetServiceImpl", 1, "getAutoDownloadApk exception=", localException);
    }
  }
  
  public void getFloadWindowInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "getFloadWindowInfo appid=" + paramString);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString);
      localJSONObject2.put("tt", 1);
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
      {
        localJSONObject2.put("uin", localObject);
        localJSONObject2.put("skey", GameCenterUtil.b());
        localJSONObject1.put("req", localJSONObject2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("appid", paramString);
        requestWebSso("13126", localJSONObject1, (Bundle)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGameNetServiceImpl", 1, "getFloadWindowInfo exception=", paramString);
    }
  }
  
  public void getGameRegisterInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 1, "getGameRegisterInfo appId=" + paramString);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("game_appid", paramString);
      localJSONObject2.put("qq_plat", 1);
      localJSONObject2.put("qq_version", "8.5.5.5105");
      localJSONObject1.put("req", localJSONObject2);
      requestWebSso("12855", localJSONObject1, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGameNetServiceImpl", 1, "getGameRegisterInfo exception=", paramString);
    }
  }
  
  public void onRespWebSso(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramIntent == null) {}
    long l2;
    do
    {
      return;
      localObject3 = null;
      l2 = -1L;
      localObject1 = paramIntent.getStringExtra("webssoCmdId");
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = localObject3;
      l1 = l2;
      if (paramBoolean)
      {
        localObject1 = localObject3;
        l1 = l2;
        if (paramArrayOfByte != null) {
          l1 = l2;
        }
      }
      try
      {
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        l1 = l2;
        localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
        l1 = l2;
        l2 = localUniSsoServerRsp.ret.get();
        localObject1 = localObject3;
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = l2;
          paramArrayOfByte = new JSONObject(localUniSsoServerRsp.rspdata.get());
          localObject1 = localObject3;
          l1 = l2;
          if (paramArrayOfByte != null)
          {
            l1 = l2;
            paramArrayOfByte = paramArrayOfByte.optJSONObject((String)localObject2);
            localObject1 = localObject3;
            l1 = l2;
            if (paramArrayOfByte != null)
            {
              l1 = l2;
              paramArrayOfByte = paramArrayOfByte.optJSONObject("data");
              localObject1 = localObject3;
              l1 = l2;
              if (paramArrayOfByte != null)
              {
                l1 = l2;
                localObject1 = paramArrayOfByte.optJSONObject("rsp");
                l1 = l2;
              }
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("QQGameNetServiceImpl", 1, "onRespWebSso cmdId=" + (String)localObject2 + ",err:" + paramArrayOfByte.getMessage());
          localObject1 = localObject3;
          continue;
          if (("12829".equals(localObject2)) && (l1 == 0L))
          {
            GameCenterSpUtils.a(paramIntent.getExtras().getString("appId"), paramArrayOfByte);
            continue;
            localObject1 = "";
            continue;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGameNetServiceImpl", 2, "onRespWebSso cmdId=" + (String)localObject2 + ",isSucc=" + paramBoolean + ",ret=" + l1 + ",rspJson=" + localObject1);
      }
    } while (("12934".equals(localObject2)) || ("13325".equals(localObject2)));
    if (localObject1 == null)
    {
      paramArrayOfByte = new JSONObject();
      if ("13136".equals(localObject2))
      {
        l2 = -1L;
        if (!paramBoolean) {
          break label461;
        }
        l2 = paramArrayOfByte.optLong("version", -1L);
        localObject1 = paramArrayOfByte.optString("content");
        ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).writeConfig(paramBoolean, (String)localObject1, l2);
        notifyListeners(paramIntent, (String)localObject2, l1, paramArrayOfByte);
      }
    }
  }
  
  public void removeListener(WadlCmdListener paramWadlCmdListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 1, "addListener listener=" + paramWadlCmdListener);
    }
    if (paramWadlCmdListener == null) {
      return;
    }
    Iterator localIterator = this.webssoListeners.iterator();
    while (localIterator.hasNext())
    {
      WadlCmdListener localWadlCmdListener = (WadlCmdListener)((WeakReference)localIterator.next()).get();
      if ((localWadlCmdListener != null) && (localWadlCmdListener == paramWadlCmdListener)) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 1, "addListener listener=" + paramWadlCmdListener + " succ");
    }
    this.webssoListeners.add(new WeakReference(paramWadlCmdListener));
  }
  
  public void reportDownloadStart(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "reportDownloadStart...");
    }
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
      QLog.e("QQGameNetServiceImpl", 1, "reportDownloadStart exception=", paramJSONArray1);
    }
  }
  
  public void requestArk(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "requestArk appId=" + paramString + ",arkType=" + paramInt);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString);
      localJSONObject2.put("ark_type", paramInt);
      localJSONObject1.put("req", localJSONObject2);
      requestWebSso("13665", localJSONObject1, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGameNetServiceImpl", 1, "requestArk exception=", paramString);
    }
  }
  
  public void requestRedPoint(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 2, "requestRedPoint sceneId=" + paramInt);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("scene_id", paramInt);
      localJSONObject2.put("uin", GameCenterUtil.a());
      localJSONObject2.put("tt", 1);
      localJSONObject1.put("req", localJSONObject2);
      requestWebSso("13325", localJSONObject1, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQGameNetServiceImpl", 1, "requestRedPoint exception=", localException);
    }
  }
  
  public void requestWebSso(String paramString, JSONObject paramJSONObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameNetServiceImpl", 1, "requestWebSso webssoCmd=" + paramString + ",reqData=" + paramJSONObject);
    }
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    } while (localAppRuntime == null);
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put(paramString, paramJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(MobileQQ.sMobileQQ, WadlBusinessServlet.class);
      paramJSONObject = paramBundle;
      if (paramBundle == null) {
        paramJSONObject = new Bundle();
      }
      paramJSONObject.putInt("wadl_sso_type", 0);
      paramJSONObject.putString("webssoCmdId", paramString);
      paramJSONObject.putByteArray("webssoReq", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtras(paramJSONObject);
      localAppRuntime.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGameNetServiceImpl", 1, "requestWebSso exception=", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameNetServiceImpl
 * JD-Core Version:    0.7.0.1
 */