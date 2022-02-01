package com.tencent.hippy.qq.module.gamecenter;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.gamecenter.hippy.GamePAHippyBaseFragment;
import com.tencent.mobileqq.gamecenter.media.GameVideoManager;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="GamePubAccountModule")
public class GamePubAccountModule
  extends QQBaseModule
{
  static final String TAG = "GamePubAccountModule";
  
  public GamePubAccountModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void sendEvent(String paramString, HippyMap paramHippyMap)
  {
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  @HippyMethod(name="getGameListDataPreload")
  public void getGameListDataPreload(Promise paramPromise)
  {
    try
    {
      paramPromise = new HippyMap();
      QQGameHelper.b(System.currentTimeMillis());
      if (QQGameHelper.c() != null)
      {
        paramPromise.pushString("result", QQGameHelper.c());
        sendEvent("onGameListDataPreload", paramPromise);
        QQGameHelper.e("2");
      }
      if (QLog.isColorLevel()) {
        QLog.i("feedsPreload_GamePubAccountModule", 2, "getGameListDataPreload,vCost：" + (System.currentTimeMillis() - QQGameHelper.c()) + ",hippyMap:" + paramPromise);
      }
      return;
    }
    catch (Throwable paramPromise)
    {
      QLog.e("GamePubAccountModule", 2, paramPromise, new Object[0]);
    }
  }
  
  @HippyMethod(name="onHippyFirstScreen")
  public void onHippyFirstScreen(Promise paramPromise)
  {
    paramPromise = getFragment();
    long l = SystemClock.elapsedRealtime();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ((GamePAHippyBaseFragment)paramPromise).b(l);
    }
  }
  
  @HippyMethod(name="onHippyScrollBegin")
  public void onHippyScrollBegin(Promise paramPromise)
  {
    paramPromise = getFragment();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ((GamePAHippyBaseFragment)paramPromise).e();
    }
  }
  
  @HippyMethod(name="onHippyScrollEnd")
  public void onHippyScrollEnd(Promise paramPromise)
  {
    paramPromise = getFragment();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ((GamePAHippyBaseFragment)paramPromise).f();
    }
  }
  
  @HippyMethod(name="onHippyShow")
  public void onHippyShow(Promise paramPromise)
  {
    paramPromise = getFragment();
    long l = SystemClock.elapsedRealtime();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ((GamePAHippyBaseFragment)paramPromise).c(l);
    }
  }
  
  @HippyMethod(name="pauseVideo")
  public void pauseVideo(Promise paramPromise)
  {
    GameVideoManager.b(1);
  }
  
  @HippyMethod(name="playVideo")
  public void playVideo(Promise paramPromise)
  {
    GameVideoManager.b(2);
  }
  
  @HippyMethod(name="queryMoreMsg")
  public void queryMoreMsg(Promise paramPromise)
  {
    paramPromise = getFragment();
    if ((paramPromise != null) && (paramPromise.getActivity() != null)) {
      QQGameHelper.b(paramPromise.getActivity());
    }
  }
  
  @HippyMethod(name="report")
  public void report(String paramString, Promise paramPromise)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(paramString, 0);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.GamePubAccountModule
 * JD-Core Version:    0.7.0.1
 */