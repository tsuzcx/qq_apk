package com.tencent.hippy.qq.module;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IPlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.viola.api.InvokeCallJSCallback;
import com.tencent.mobileqq.kandian.biz.viola.module.BridgeModuleProxy;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.repo.account.api.IRIJUserLevelModule;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.event.QCircleOpenRewardAdEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QQBridgeModule
  extends BridgeModuleProxy
  implements InvokeCallJSCallback
{
  private static final String TAG = "QQBridgeModule";
  private HashMap<String, Object> mCallbackMap = new HashMap();
  private int mEngineId = -1;
  private INetInfoHandler netInfoHandler;
  
  public QQBridgeModule()
  {
    setInvokeCallJSCallback(this);
  }
  
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
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      String str = paramPromise.getCallId();
      addPromise(str, paramPromise);
      return str;
    }
    return "";
  }
  
  private QBaseFragment getFragment()
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
    QBaseFragment localQBaseFragment = getFragment();
    if (localQBaseFragment != null)
    {
      boolean bool = localQBaseFragment instanceof ViolaFragment;
      if (bool)
      {
        if (bool) {
          ((ViolaFragment)localQBaseFragment).doOnBackPressed();
        } else {
          localQBaseFragment.getQBaseActivity().doOnBackPressed();
        }
        invokeCallJS(paramString, null);
      }
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
    QBaseFragment localQBaseFragment = getFragment();
    if ((localQBaseFragment != null) && ((localQBaseFragment instanceof ViolaFragment)))
    {
      String str2 = paramJSONObject.optString("title");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramJSONObject.optString("text");
      }
      if (!TextUtils.isEmpty(str1))
      {
        ((ViolaFragment)localQBaseFragment).setTitle(str1);
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
  
  public void getAllowedStateOfOperationAction(JSONObject paramJSONObject, Promise paramPromise)
  {
    Object localObject1 = getViolaInstance();
    if (localObject1 != null) {
      localObject1 = ((ViolaInstance)localObject1).getActivity();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseActivity.sTopActivity;
    }
    boolean bool = ((IRIJUserLevelModule)QRoute.api(IRIJUserLevelModule.class)).doActionsByUserLevel((Context)localObject2, paramJSONObject.optInt("operType"), null);
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("isAllow", bool);
      doPromiseCallback(paramPromise, paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNetType,netType:");
      ((StringBuilder)localObject).append(i);
      QLog.d("QQBridgeModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", i);
      label65:
      if (paramBoolean) {
        invokeCallJS(paramPromise, localObject);
      } else {
        doPromiseCallback(paramPromise, (JSONObject)localObject);
      }
      vaNetworkChange(paramPromise);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label65;
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
    if ((!"weishi://feed".equals(paramString)) && (!"weishi".equals(paramString))) {
      bool = PackageUtil.a(localBaseActivity, paramString);
    } else {
      bool = WeishiGuideUtils.a(localBaseActivity);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        if (bool)
        {
          i = 1;
          paramString.put("result", i);
          if (paramBoolean)
          {
            invokeCallJS(paramPromise, paramString);
            return;
          }
          doPromiseCallback(paramPromise, paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          paramPromise = new StringBuilder();
          paramPromise.append("hasApp error");
          paramPromise.append(paramString.getMessage());
          QLog.e("QQBridgeModule", 2, paramPromise.toString());
        }
        return;
      }
      int i = 0;
    }
  }
  
  public void invoke(JSONObject paramJSONObject, Promise paramPromise)
  {
    paramPromise = getCallbackId(paramPromise);
    String str1 = paramJSONObject.optString("ns");
    String str2 = paramJSONObject.optString("method");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      Object localObject = getFragment();
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
      if (("schema".equals(str1)) && ("jumpAction".equals(str2)))
      {
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
        if ((localObject != null) && ((localObject instanceof ViolaFragment)))
        {
          localObject = ((QBaseFragment)localObject).getQBaseActivity();
          QQAppInterface localQQAppInterface = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
          if ((localObject != null) && (localQQAppInterface != null)) {
            try
            {
              paramJSONObject = JumpParser.a(localQQAppInterface, (Context)localObject, paramJSONObject.getString("schema"));
              if (paramJSONObject == null) {
                break label421;
              }
              paramJSONObject.b("viola");
              paramJSONObject.a();
              invokeCallJS(paramPromise, null);
              return;
            }
            catch (JSONException paramJSONObject)
            {
              paramJSONObject.printStackTrace();
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("ns:");
              paramJSONObject.append(str1);
              paramJSONObject.append(HardCodeUtil.a(2131701413));
              paramJSONObject.append(str2);
              paramJSONObject.append(HardCodeUtil.a(2131701408));
              invokeErrorCallJS(paramPromise, paramJSONObject.toString());
              return;
            }
          } else {
            invokeErrorCallJS(paramPromise, "activity or app is null");
          }
        }
        else
        {
          invokeErrorCallJS(paramPromise, "fragment is null");
        }
      }
      else
      {
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
      label421:
      return;
    }
    invokeErrorCallJS(paramPromise, HardCodeUtil.a(2131701417));
    QLog.d("QQBridgeModule", 1, "ns or method not exists");
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
    QBaseFragment localQBaseFragment = getFragment();
    if ((localQBaseFragment != null) && ((localQBaseFragment instanceof ViolaFragment))) {
      setNavBtnWithFragment(paramJSONObject, paramPromise, localQBaseFragment);
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
    QQAppInterface localQQAppInterface = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    if (this.netInfoHandler == null)
    {
      this.netInfoHandler = new QQBridgeModule.1(this, paramPromise);
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
    }
  }
  
  public void videoPlayFeedback(JSONObject paramJSONObject, Promise paramPromise)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("do videoPlayFeedback start data: ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("QQBridgeModule", 2, localStringBuilder.toString());
    }
    ((IPlayFeedbackHelper)QRoute.api(IPlayFeedbackHelper.class)).feedbackViolaCall(null, paramJSONObject);
    if (getViolaInstance() != null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("success", 1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      doPromiseCallback(paramPromise, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBridgeModule
 * JD-Core Version:    0.7.0.1
 */