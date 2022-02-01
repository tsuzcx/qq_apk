import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.4;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.5;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bjei
  extends QIPCModule
{
  private bjei(String paramString)
  {
    super(paramString);
  }
  
  public static bjei a()
  {
    return bjen.a();
  }
  
  public static void a()
  {
    bjei localbjei = a();
    try
    {
      QMLog.i("MiniSDKClientQIPCModule", "register " + localbjei);
      QIPCClientHelper.getInstance().register(localbjei);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "register ipc module error.", localException);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("param_proc_badge_count");
      if (QMLog.isDebugEnabled()) {
        QMLog.d("MiniSDKClientQIPCModule", "count is " + i);
      }
      paramBundle = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
      if ((paramBundle == null) || (paramBundle.getPage() == null)) {
        QMLog.w("MiniSDKClientQIPCModule", "runtime or page is null");
      }
    }
    else
    {
      return;
    }
    paramBundle = paramBundle.getPage().getCapsuleButton();
    if (paramBundle == null)
    {
      QMLog.w("MiniSDKClientQIPCModule", "capsule button is null");
      return;
    }
    QMLog.i("MiniSDKClientQIPCModule", BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + i);
    paramBundle.setUnReadCount(i, true);
  }
  
  private void a(BaseRuntime paramBaseRuntime, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.5(this, paramBaseRuntime, paramString));
  }
  
  private void a(BaseRuntime paramBaseRuntime, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.4(this, paramBaseRuntime, paramString1, paramString2, paramInt, paramString3));
  }
  
  private void a(BaseRuntime paramBaseRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, RequestEvent paramRequestEvent)
  {
    a(paramString4, new bjej(this, paramBaseRuntime, paramString1, paramString2, paramString3, paramInt, paramRequestEvent));
  }
  
  private void a(IJsService paramIJsService, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString2, paramString3, paramInt1, paramInt2, paramString4, new bjem(this, paramString1, paramIJsService, paramInt3));
  }
  
  private void a(String paramString, CmdCallback paramCmdCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b(paramString, paramCmdCallback);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if ((!localJSONObject.has("metaData")) || (!localJSONObject.optJSONObject("metaData").has("detail")) || (!localJSONObject.optJSONObject("metaData").optJSONObject("detail").has("preview"))) {
        break label160;
      }
      String str = localJSONObject.optJSONObject("metaData").optJSONObject("detail").optString("preview");
      if (!URLUtil.isNetworkUrl(str))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("preview", str);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_upload_image", localBundle, new bjek(this, localJSONObject, paramCmdCallback));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "getReplaceJsonString error,", localThrowable);
      b(paramString, paramCmdCallback);
      return;
    }
    b(paramString, paramCmdCallback);
    return;
    label160:
    b(paramString, paramCmdCallback);
  }
  
  private void a(JSONObject paramJSONObject1, BaseRuntime paramBaseRuntime, int paramInt, String paramString, boolean paramBoolean, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject1.put("errMsg", paramString);
      paramJSONObject1.put("success", paramBoolean);
      if (paramBaseRuntime.getJsService() != null)
      {
        paramString = paramBaseRuntime.getJsService();
        paramJSONObject1 = paramJSONObject1.toString();
        if (paramBaseRuntime.isMiniGame())
        {
          paramInt = -1;
          paramString.evaluateSubscribeJS("onShareMessageToFriend", paramJSONObject1, paramInt);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("MiniSDKClientQIPCModule", 1, "callOnShareMessageToFriend error,", paramString);
        continue;
        paramInt = ActionBridge.PageActionBridge.getPageId(paramBaseRuntime);
      }
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService == null");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    BaseRuntime localBaseRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localBaseRuntime == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
      return;
    }
    ShareState localShareState = localBaseRuntime.getShareState();
    if (localShareState == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "shareState == null");
      return;
    }
    Object localObject1;
    try
    {
      if (localShareState.requestEvent != null) {}
      for (IJsService localIJsService = localShareState.requestEvent.jsService; localIJsService == null; localIJsService = localBaseRuntime.getJsService())
      {
        QLog.e("MiniSDKClientQIPCModule", 1, "jsService == null");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService exception", localThrowable);
        localObject1 = null;
      }
    }
    if (paramBoolean) {
      if (!"requestFriendPayment".equals(localShareState.shareEvent)) {
        break label279;
      }
    }
    label279:
    for (Object localObject2 = new JSONObject();; localObject2 = null)
    {
      try
      {
        ((JSONObject)localObject2).put("resultCode", 0);
        localObject2 = ApiUtil.wrapCallbackOk(localShareState.shareEvent, (JSONObject)localObject2);
        if (localObject2 != null)
        {
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1.evaluateCallbackJs(localShareState.shareCallbackId, (String)localObject2);
          QLog.i("MiniSDKClientQIPCModule", 1, "callback: " + (String)localObject2);
          a(localBaseRuntime, "share_success");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("MiniSDKClientQIPCModule", 1, "API_PAY_BY_FRIEND put resultCode error", localJSONException);
          continue;
          localObject2 = "";
        }
      }
      localObject2 = ApiUtil.wrapCallbackFail(localShareState.shareEvent, null);
      if (localObject2 != null) {}
      for (localObject2 = ((JSONObject)localObject2).toString();; localObject2 = "")
      {
        localObject1.evaluateCallbackJs(localShareState.shareCallbackId, (String)localObject2);
        a(localBaseRuntime, "share_fail");
        return;
      }
    }
  }
  
  public static void b()
  {
    QMLog.i("MiniSDKClientQIPCModule", "unregister");
    QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
  }
  
  private void b(Bundle paramBundle)
  {
    int i = 0;
    Object localObject2 = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localObject2 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
      return;
    }
    Object localObject3 = ((BaseRuntime)localObject2).getShareState();
    if (localObject3 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "onShareUpdatableMsgCallback shareState == null");
      return;
    }
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      try
      {
        if (((ShareState)localObject3).requestEvent == null) {
          break label92;
        }
        localObject2 = ((ShareState)localObject3).requestEvent.jsService;
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          label92:
          QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService exception", localThrowable1);
        }
        boolean bool = paramBundle.getBoolean("miniAppShareIsComplete", false);
        String str1 = paramBundle.getString("miniAppShareEvent");
        localObject3 = paramBundle.getString("miniAppShareAppid");
        String str2 = paramBundle.getString("miniAppShareTemplateId");
        j = paramBundle.getInt("miniAppShareCallbackId");
        int k = paramBundle.getInt("miniAppShareAppType");
        if (!bool) {
          break label317;
        }
        int m = paramBundle.getInt("uintype");
        if (m != 1) {
          break label307;
        }
        for (;;)
        {
          paramBundle = paramBundle.getString("uin");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder("doCreateUpdatableMsgCallback");
            localStringBuilder.append(", appid:").append((String)localObject3).append(", templateId:").append(str2).append(", from:").append(k).append(", scene:").append(i).append(", uin:").append(paramBundle);
            QLog.i("MiniSDKClientQIPCModule", 1, localStringBuilder.toString());
          }
          a(localObject1, str1, (String)localObject3, str2, k, i, paramBundle, j);
          return;
          if (m == 0) {
            i = 1;
          }
        }
        paramBundle = new JSONObject();
      }
      if (localObject1 != null) {
        break;
      }
      QLog.e("MiniSDKClientQIPCModule", 1, "jsService == null");
      return;
      localObject2 = ((BaseRuntime)localObject2).getJsService();
    }
    try
    {
      int j;
      label307:
      label317:
      paramBundle.put("retCode", 1);
      paramBundle.put("errMsg", "用户取消");
      localObject1.evaluateCallbackJs(j, paramBundle.toString());
      return;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
  
  private void b(BaseRuntime paramBaseRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, RequestEvent paramRequestEvent)
  {
    MiniAppCmdUtil.getInstance().sendArkMsg(null, paramString3, paramString2, paramString4, paramRequestEvent.event, new bjel(this, paramRequestEvent, paramBaseRuntime, paramString1, paramInt));
  }
  
  private void b(String paramString, CmdCallback paramCmdCallback)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("shareJson", paramString);
      paramCmdCallback.onCmdResult(true, localBundle);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    BaseRuntime localBaseRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localBaseRuntime == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
      return;
    }
    Object localObject2 = localBaseRuntime.getShareState();
    if (localObject2 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "shareState == null");
      return;
    }
    String str1 = ((ShareState)localObject2).shareEvent;
    Object localObject1 = ((ShareState)localObject2).shareOpenid;
    String str2 = ((ShareState)localObject2).shareAppid;
    String str3 = ((ShareState)localObject2).shareJson;
    int i = ((ShareState)localObject2).shareCallbackId;
    localObject2 = ((ShareState)localObject2).requestEvent;
    if (paramBoolean)
    {
      a(localBaseRuntime, str1, (String)localObject1, str2, str3, i, (RequestEvent)localObject2);
      return;
    }
    ((RequestEvent)localObject2).fail();
    localObject1 = new JSONObject();
    a((JSONObject)localObject1, localBaseRuntime, i, "cancel", false, ApiUtil.wrapCallbackFail(str1, (JSONObject)localObject1));
    a(localBaseRuntime, "shareMessageToFriend_fail");
    a(localBaseRuntime, "share_" + ((RequestEvent)localObject2).event, "fail", 3, "cancel");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniSDKClientQIPCModule", 2, "onCall main server action=" + paramString);
    }
    if ("action_sync_unreadcount".equals(paramString)) {
      a(paramBundle);
    }
    for (;;)
    {
      return null;
      if ("actionMiniShareSucCallback".equals(paramString)) {
        a(true);
      } else if ("actionMiniShareFailCallback".equals(paramString)) {
        a(false);
      } else if ("actionMiniDirectShareSucCallback".equals(paramString)) {
        b(true);
      } else if ("actionMiniDirectShareFailCallback".equals(paramString)) {
        b(false);
      } else if ((!"actionMiniReportEvent".equals(paramString)) && ("actionMiniCreateUpdatableMsgCallback".equals(paramString))) {
        b(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjei
 * JD-Core Version:    0.7.0.1
 */