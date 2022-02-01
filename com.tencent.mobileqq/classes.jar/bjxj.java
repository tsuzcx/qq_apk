import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.2;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
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

public class bjxj
  extends QIPCModule
{
  private bjxj(String paramString)
  {
    super(paramString);
  }
  
  public static bjxj a()
  {
    return bjxm.a();
  }
  
  public static void a()
  {
    bjxj localbjxj = a();
    try
    {
      QMLog.i("MiniSDKClientQIPCModule", "register " + localbjxj);
      QIPCClientHelper.getInstance().register(localbjxj);
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
    ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.2(this, paramBaseRuntime, paramString));
  }
  
  private void a(BaseRuntime paramBaseRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, RequestEvent paramRequestEvent)
  {
    MiniAppCmdUtil.getInstance().sendArkMsg(null, paramString3, paramString2, paramString4, new bjxk(this, paramRequestEvent, paramBaseRuntime, paramString1, paramInt));
  }
  
  private void a(IJsService paramIJsService, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString2, paramString3, paramInt1, paramInt2, paramString4, new bjxl(this, paramString1, paramIJsService, paramInt3));
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
        paramInt = PageAction.obtain(paramBaseRuntime).getPageId();
      }
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService == null");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = null;
    BaseRuntime localBaseRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localBaseRuntime == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
      return;
    }
    Object localObject1;
    ShareState localShareState;
    try
    {
      IJsService localIJsService = localBaseRuntime.getJsService();
      if (localIJsService == null)
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
      localShareState = localBaseRuntime.getShareState();
      if (localShareState == null)
      {
        QLog.e("MiniSDKClientQIPCModule", 1, "shareState == null");
        return;
      }
      if (paramBoolean)
      {
        if ("requestFriendPayment".equals(localShareState.shareEvent)) {
          localObject2 = new JSONObject();
        }
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
      }
      localObject2 = ApiUtil.wrapCallbackFail(localShareState.shareEvent, null);
      if (localObject2 == null) {}
    }
    for (localObject2 = ((JSONObject)localObject2).toString();; localObject2 = "")
    {
      localObject1.evaluateCallbackJs(localShareState.shareCallbackId, (String)localObject2);
      a(localBaseRuntime, "share_fail");
      return;
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
    Object localObject1 = null;
    try
    {
      localObject2 = ((BaseRuntime)localObject2).getJsService();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService exception", localThrowable1);
      }
      bool = paramBundle.getBoolean("miniAppShareIsComplete", false);
      str1 = paramBundle.getString("miniAppShareEvent");
      str2 = paramBundle.getString("miniAppShareAppid");
      str3 = paramBundle.getString("miniAppShareTemplateId");
      j = paramBundle.getInt("miniAppShareCallbackId");
      k = paramBundle.getInt("miniAppShareAppType");
      if (!bool) {
        break label267;
      }
      m = paramBundle.getInt("uintype");
      if (m != 1) {
        break label257;
      }
      for (;;)
      {
        paramBundle = paramBundle.getString("uin");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder("doCreateUpdatableMsgCallback");
          localStringBuilder.append(", appid:").append(str2).append(", templateId:").append(str3).append(", from:").append(k).append(", scene:").append(i).append(", uin:").append(paramBundle);
          QLog.i("MiniSDKClientQIPCModule", 1, localStringBuilder.toString());
        }
        a(localObject1, str1, str2, str3, k, i, paramBundle, j);
        return;
        if (m == 0) {
          i = 1;
        }
      }
      paramBundle = new JSONObject();
    }
    if (localObject1 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "jsService == null");
      return;
    }
    try
    {
      boolean bool;
      String str1;
      String str2;
      String str3;
      int j;
      int k;
      int m;
      StringBuilder localStringBuilder;
      label257:
      label267:
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
 * Qualified Name:     bjxj
 * JD-Core Version:    0.7.0.1
 */