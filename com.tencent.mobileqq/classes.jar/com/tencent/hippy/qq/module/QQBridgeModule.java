package com.tencent.hippy.qq.module;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import anvx;
import bheh;
import bhey;
import bhfn;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.events.QCircleOpenRewardAdEvent;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import pkh;
import sug;
import zfn;

public class QQBridgeModule
  extends BridgeModule
{
  private HashMap<String, Object> mCallbackMap = new HashMap();
  private int mEngineId = -1;
  private INetInfoHandler netInfoHandler;
  
  private void addPromise(String paramString, Promise paramPromise)
  {
    try
    {
      this.mCallbackMap.put(paramString, paramPromise);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramJSONObject);
      paramPromise.resolve(localHippyMap);
    }
  }
  
  private String getCallbackId(Promise paramPromise)
  {
    String str2 = "";
    String str1 = str2;
    if (paramPromise != null)
    {
      str1 = str2;
      if (paramPromise.isCallback())
      {
        str1 = paramPromise.getCallId();
        addPromise(str1, paramPromise);
      }
    }
    return str1;
  }
  
  private Fragment getFragment()
  {
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mEngineId);
    if (localHippyQQEngine == null) {
      return null;
    }
    return localHippyQQEngine.getFragment();
  }
  
  private Object getPromise(String paramString)
  {
    try
    {
      paramString = this.mCallbackMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void popBackImpl(String paramString)
  {
    Fragment localFragment = getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label37;
      }
      ((ViolaFragment)localFragment).doOnBackPressed();
    }
    for (;;)
    {
      invokeCallJS(paramString, null);
      return;
      label37:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  private void removePromise(String paramString)
  {
    try
    {
      this.mCallbackMap.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void setTitleImpl(JSONObject paramJSONObject, String paramString)
  {
    Fragment localFragment = getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
    {
      String str2 = paramJSONObject.optString("title");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramJSONObject.optString("text");
      }
      if (!TextUtils.isEmpty(str1))
      {
        ((ViolaFragment)localFragment).setTitle(str1);
        invokeCallJS(paramString, new JSONObject());
      }
    }
  }
  
  public void cancelUploadingVideo(JSONObject paramJSONObject, Promise paramPromise)
  {
    cancelUploadingVideo(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void chooseVideoAddToTopic(JSONObject paramJSONObject, Promise paramPromise)
  {
    chooseVideoAddToTopic(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void getALDConfig(JSONObject paramJSONObject, Promise paramPromise)
  {
    if ((!TextUtils.isEmpty(paramJSONObject.optString("key", ""))) && (paramJSONObject.has("id"))) {
      paramJSONObject = Aladdin.getConfig(paramJSONObject.optInt("id")).getString(paramJSONObject.optString("key", ""), "");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramJSONObject);
      doPromiseCallback(paramPromise, localJSONObject);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public void getCreateTopicPermission(JSONObject paramJSONObject, Promise paramPromise)
  {
    getCreateTopicPermission(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void getDeviceInfo(Promise paramPromise, boolean paramBoolean)
  {
    JSONObject localJSONObject = getDeviceInfo();
    if (paramBoolean)
    {
      invokeCallJS(paramPromise, localJSONObject);
      return;
    }
    doPromiseCallback(paramPromise, localJSONObject);
  }
  
  public void getGdtDeviceInfo(Promise paramPromise, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AdThreadManager.INSTANCE.post(new QQBridgeModule.2(this, paramJSONObject, paramBoolean, paramPromise), 4);
  }
  
  public void getMotiveAd(Promise paramPromise, JSONObject paramJSONObject)
  {
    getMotiveAd(getCallbackId(paramPromise), paramJSONObject);
  }
  
  public void getNetType(Promise paramPromise, boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNetType,netType:" + i);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", i);
      label54:
      if (paramBoolean) {
        invokeCallJS(paramPromise, localJSONObject);
      }
      for (;;)
      {
        vaNetworkChange(paramPromise);
        return;
        doPromiseCallback(paramPromise, localJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      break label54;
    }
  }
  
  public void getUploadVideoPermission(JSONObject paramJSONObject, Promise paramPromise)
  {
    getUploadVideoPermission(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void getUploadingVideoInfo(JSONObject paramJSONObject, Promise paramPromise)
  {
    getUploadingVideoInfo(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void getUserInfo(Promise paramPromise, boolean paramBoolean)
  {
    JSONObject localJSONObject = getUserInfo();
    if (paramBoolean)
    {
      invokeCallJS(paramPromise, localJSONObject);
      return;
    }
    doPromiseCallback(paramPromise, localJSONObject);
  }
  
  public void hasApp(String paramString, Promise paramPromise, boolean paramBoolean)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    boolean bool;
    if (("weishi://feed".equals(paramString)) || ("weishi".equals(paramString))) {
      bool = zfn.a(localBaseActivity);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        if (!bool) {
          break label123;
        }
        i = 1;
        paramString.put("result", i);
        if (!paramBoolean) {
          break label129;
        }
        invokeCallJS(paramPromise, paramString);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "hasApp error" + paramString.getMessage());
      return;
      bool = bhfn.a(localBaseActivity, paramString);
      continue;
      label123:
      int i = 0;
    }
    label129:
    doPromiseCallback(paramPromise, paramString);
  }
  
  public void invoke(JSONObject paramJSONObject, Promise paramPromise)
  {
    paramPromise = getCallbackId(paramPromise);
    String str1 = paramJSONObject.optString("ns");
    String str2 = paramJSONObject.optString("method");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      invokeErrorCallJS(paramPromise, anvx.a(2131700699));
      QLog.d(TAG, 1, "ns or method not exists");
    }
    Object localObject;
    for (;;)
    {
      return;
      localObject = getFragment();
      if (("readinjoy".equals(str1)) && ("showShareReadInJoyMenu".equals(str2)))
      {
        if ((paramJSONObject.optJSONObject("params") != null) && (localObject != null) && ((localObject instanceof ViolaFragment)))
        {
          showShareReadInJoyMenu(paramJSONObject.optJSONObject("params"), paramPromise, (Fragment)localObject);
          return;
        }
        invokeErrorCallJS(paramPromise, "fragment or params is null");
        return;
      }
      if ((!"schema".equals(str1)) || (!"jumpAction".equals(str2))) {
        break label343;
      }
      paramJSONObject = paramJSONObject.optJSONObject("params");
      if (paramJSONObject == null)
      {
        invokeErrorCallJS(paramPromise, "params is null");
        return;
      }
      if (!paramJSONObject.has("schema"))
      {
        invokeErrorCallJS(paramPromise, "schema is null");
        return;
      }
      if ((localObject == null) || (!(localObject instanceof ViolaFragment))) {
        break label334;
      }
      localObject = ((Fragment)localObject).getActivity();
      QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
      if ((localObject != null) && (localQQAppInterface != null)) {
        try
        {
          paramJSONObject = bhey.a(localQQAppInterface, (Context)localObject, paramJSONObject.getString("schema"));
          if (paramJSONObject != null)
          {
            paramJSONObject.b("viola");
            paramJSONObject.a();
            invokeCallJS(paramPromise, null);
            return;
          }
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          invokeErrorCallJS(paramPromise, "ns:" + str1 + anvx.a(2131700695) + str2 + anvx.a(2131700690));
          return;
        }
      }
    }
    invokeErrorCallJS(paramPromise, "activity or app is null");
    return;
    label334:
    invokeErrorCallJS(paramPromise, "fragment is null");
    return;
    label343:
    if (("ui".equals(str1)) && ("setNavBtn".equals(str2)))
    {
      if ((paramJSONObject.optJSONObject("params") != null) && (localObject != null) && ((localObject instanceof ViolaFragment)))
      {
        setNavBtnWithFragment(paramJSONObject.optJSONObject("params"), paramPromise, (Fragment)localObject);
        return;
      }
      invokeErrorCallJS(paramPromise, "fragment or params is null");
      return;
    }
    invoke(paramJSONObject, paramPromise);
  }
  
  public void invokeCallJS(Promise paramPromise, Object paramObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      paramObject = getSuccInvokeObj(paramObject);
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramObject);
      paramPromise.resolve(localHippyMap);
    }
  }
  
  public void invokeCallJS(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = getPromise(paramString);
      if ((localObject != null) && ((localObject instanceof Promise)))
      {
        invokeCallJS((Promise)localObject, paramObject);
        removePromise(paramString);
      }
    }
  }
  
  public void invokeErrorCallJS(Promise paramPromise, String paramString)
  {
    invokeJS(paramPromise, getFailInvokeObj(paramString));
  }
  
  public void invokeErrorCallJS(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject = getPromise(paramString1);
      if ((localObject != null) && ((localObject instanceof Promise)))
      {
        invokeErrorCallJS((Promise)localObject, paramString2);
        removePromise(paramString1);
      }
    }
  }
  
  public void invokeJS(Promise paramPromise, JSONObject paramJSONObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramJSONObject);
      paramPromise.resolve(localHippyMap);
    }
  }
  
  public void invokeJS(String paramString, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = getPromise(paramString);
      if ((localObject != null) && ((localObject instanceof Promise)))
      {
        invokeJS((Promise)localObject, paramJSONObject);
        removePromise(paramString);
      }
    }
  }
  
  public void isKindCard(Promise paramPromise) {}
  
  public void openAddVideoView(JSONObject paramJSONObject, Promise paramPromise)
  {
    openAddVideoView(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void openCreateTopicView(Promise paramPromise)
  {
    openCreateTopicView(getCallbackId(paramPromise));
  }
  
  public void openEditTopicView(JSONObject paramJSONObject, Promise paramPromise)
  {
    openEditTopicView(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void openRewardAd(JSONObject paramJSONObject, Promise paramPromise)
  {
    paramJSONObject = new QCircleOpenRewardAdEvent(paramJSONObject);
    SimpleEventBus.getInstance().dispatchEvent(paramJSONObject);
  }
  
  public void openTopicVideoComment(JSONObject paramJSONObject, Promise paramPromise)
  {
    getCallbackId(paramPromise);
  }
  
  public void openUserLevelDialog(JSONObject paramJSONObject, Promise paramPromise)
  {
    openLevelDialog(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void pauseUploadingVideo(JSONObject paramJSONObject, Promise paramPromise)
  {
    pauseUploadingVideo(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void popBack(String paramString)
  {
    HippyQQEngine.runTaskInUIThread(new QQBridgeModule.4(this, paramString));
  }
  
  public void resumeUploadingVideo(JSONObject paramJSONObject, Promise paramPromise)
  {
    resumeUploadingVideo(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void setEngineId(int paramInt)
  {
    this.mEngineId = paramInt;
  }
  
  protected void setNavBtn(JSONObject paramJSONObject, Promise paramPromise)
  {
    paramPromise = getCallbackId(paramPromise);
    Fragment localFragment = getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      setNavBtnWithFragment(paramJSONObject, paramPromise, localFragment);
    }
  }
  
  public void setTitle(JSONObject paramJSONObject, String paramString)
  {
    HippyQQEngine.runTaskInUIThread(new QQBridgeModule.3(this, paramJSONObject, paramString));
  }
  
  public void shareVideoWithFriend(JSONObject paramJSONObject, Promise paramPromise)
  {
    shareVideoWithFriend(paramJSONObject, getCallbackId(paramPromise));
  }
  
  public void vaNetworkChange(Promise paramPromise)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    if (localQQAppInterface == null) {}
    while (this.netInfoHandler != null) {
      return;
    }
    this.netInfoHandler = new QQBridgeModule.1(this, paramPromise);
    AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
  }
  
  public void videoPlayFeedback(JSONObject paramJSONObject, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do videoPlayFeedback start data: " + paramJSONObject.toString());
    }
    sug.a(null, paramJSONObject);
    if (getViolaInstance() != null) {
      paramJSONObject = new JSONObject();
    }
    try
    {
      paramJSONObject.put("success", 1);
      doPromiseCallback(paramPromise, paramJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBridgeModule
 * JD-Core Version:    0.7.0.1
 */