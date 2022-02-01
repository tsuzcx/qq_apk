package com.tencent.mobileqq.apollo.game.process.data;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.ads.CmGameBannerAds;
import com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer;
import com.tencent.mobileqq.apollo.game.process.audio.CmAudioManager;
import com.tencent.mobileqq.apollo.game.process.audio.CmGameSoudPoolPlayer;
import com.tencent.mobileqq.apollo.game.process.audio.ICmGameAudioPlayer;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler;
import com.tencent.mobileqq.apollo.game.process.ui.NativeUIManager;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.mobileqq.apollo.res.api.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CmGameLauncher
  implements Handler.Callback, View.OnKeyListener, OnApolloViewListener
{
  public int a;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new CmGameLauncher.1(this);
  private DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  private CmGameBannerAds jdField_a_of_type_ComTencentMobileqqApolloGameProcessAdsCmGameBannerAds;
  private ICmGameAudioPlayer jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
  private CmGameAvHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler;
  private CmGameNativeMethodHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler;
  private CmGameSubProcessHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
  private CmGameLauncher.RedPacketInfo jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo;
  private CmGameNetInfoHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameNetInfoHandler;
  private CmGameOpenIdFinder jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameOpenIdFinder;
  private CmGameSubRscHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameSubRscHandler;
  private NativeUIManager jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager;
  private ApolloGameRscVerify jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify;
  private StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
  private IApolloRunnableTask jdField_a_of_type_ComTencentMobileqqApolloRenderIApolloRunnableTask = new CmGameLauncher.7(this);
  private IApolloSoLoader.OnCmSoLoadCompleteCallback jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloSoLoader$OnCmSoLoadCompleteCallback = new CmGameLauncher.5(this);
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public WeakReference<Activity> a;
  private HashMap<Integer, ApolloFloatActivity> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  private ICmGameAudioPlayer jdField_b_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
  private IApolloRunnableTask jdField_b_of_type_ComTencentMobileqqApolloRenderIApolloRunnableTask = new CmGameLauncher.8(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g = false;
  
  public CmGameLauncher(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[CmGameLauncher], gameId:");
    localStringBuilder.append(paramInt);
    QLog.i("cmgame_process.CmGameLauncher", 1, localStringBuilder.toString());
    DeviceInfoUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameOpenIdFinder = new CmGameOpenIdFinder(paramInt);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameSubRscHandler = new CmGameSubRscHandler(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAdsCmGameBannerAds = new CmGameBannerAds(paramInt);
  }
  
  private void b(StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (!TextUtils.isEmpty(paramStartCheckParam.extendJson))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramStartCheckParam.extendJson);
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo = new CmGameLauncher.RedPacketInfo();
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.g = localJSONObject.optString("payParam");
        paramStartCheckParam.gameTypeForRedPacket = localJSONObject.optInt("gameType", 0);
        paramStartCheckParam.redUrl = localJSONObject.optString("redUrl", "");
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.jdField_a_of_type_Int = localJSONObject.optInt("score", -1);
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.jdField_c_of_type_JavaLangString = localJSONObject.optString("baseUrl");
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.b = localJSONObject.optString("listId");
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
        if (CmGameUtil.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.jdField_a_of_type_Long = Long.parseLong(CmGameUtil.a().getCurrentAccountUin());
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.e = localJSONObject.optString("nickName", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.jdField_a_of_type_Long));
        if (QLog.isColorLevel())
        {
          paramStartCheckParam = new StringBuilder();
          paramStartCheckParam.append("[setRedPacketInfo] ");
          paramStartCheckParam.append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo.toString());
          QLog.d("cmgame_process.CmGameLauncher", 1, paramStartCheckParam.toString());
          return;
        }
      }
      catch (JSONException paramStartCheckParam)
      {
        paramStartCheckParam.printStackTrace();
      }
    }
  }
  
  private void f()
  {
    ThreadManagerV2.excute(new CmGameLauncher.2(this), 16, null, false);
  }
  
  private void g()
  {
    ThreadManagerV2.excute(new CmGameLauncher.3(this), 16, null, false);
  }
  
  private void h()
  {
    Activity localActivity = a();
    if (localActivity == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new CmGameLauncher.4(this, localActivity));
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "game surface view is not ready.");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((CmGameInitParams)localObject1).mGamePath)) && (FileUtils.fileExists(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mGamePath)))
    {
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView != null)
      {
        if (this.e)
        {
          QLog.w("cmgame_process.CmGameLauncher", 1, "has ready startGameEngine");
          return;
        }
        this.e = true;
        ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getLuaState(), 0, "sc.init_global_var.local", CmGameUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams));
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.setGameName(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mGameName);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.onEnterGame(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mGamePath);
        int i = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mSrc;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mGameName;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
        if (localObject1 == null) {
          localObject1 = "-1";
        } else {
          localObject1 = String.valueOf(ApolloGameTool.a(((StartCheckParam)localObject1).extendJson));
        }
        VipUtils.a(null, "cmshow", "Apollo", "initialize_game", i, 0, new String[] { localObject2, localObject1 });
        k();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "handleMessage onEnterGame");
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify;
        if (localObject1 != null) {
          ((ApolloGameRscVerify)localObject1).a();
        }
        try
        {
          if (a()) {
            ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getLuaState(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
          } else {
            ApolloCmdChannel.getInstance().callbackFromRequest(a(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
          }
        }
        catch (Exception localException)
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
        }
        j();
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      long l = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_open_to_start_engine, duration=", Long.valueOf(l), ", mStartGameEngineTs=", Long.valueOf(this.jdField_a_of_type_Long), ", mOpenCmGameTs=", Long.valueOf(this.jdField_b_of_type_Long), ", gameId=", this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mGameName });
      if (l > 0L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_gameId", this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mGameName);
        localObject2 = CmGameUtil.a();
        if (localObject2 != null) {
          StatisticCollector.getInstance(((AppInterface)localObject2).getApp()).collectPerformance(((AppInterface)localObject2).getCurrentAccountUin(), "cmgame_open_to_start_engine", true, l, 0L, localHashMap, "", false);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "mGameParams error");
    }
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.isWhiteUsr) {
      return;
    }
    try
    {
      if (BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0).getBoolean("game_storage_switch", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getRender();
        Object localObject = ApolloRender.getUserPath(this.jdField_c_of_type_Int);
        if (localObject != null)
        {
          localObject = new File((String)localObject);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[showImmersiveMode] show fullscreen.");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof BaseActivity)))
    {
      localObject = (ChatFragment)((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null) {
          ((BaseChatPie)localObject).N();
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
    if (localObject != null) {
      ((ApolloSurfaceView)localObject).setSystemUiVisibility(this.jdField_a_of_type_Int);
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Activity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public DoraemonAPIManager a(long paramLong, Activity paramActivity)
  {
    DoraemonAPIManager localDoraemonAPIManager = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
    if (localDoraemonAPIManager != null) {
      return localDoraemonAPIManager;
    }
    ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(paramActivity, 5, String.valueOf(paramLong));
    QLog.i("cmgame_process.CmGameLauncher", 1, "create API manager.");
    return this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  }
  
  public CmGameBannerAds a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAdsCmGameBannerAds;
  }
  
  public ICmGameAudioPlayer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
  }
  
  public CmGameInitParams a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
  }
  
  public CmGameLauncher.RedPacketInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher$RedPacketInfo;
  }
  
  public CmGameOpenIdFinder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameOpenIdFinder;
  }
  
  public CmGameSubRscHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameSubRscHandler;
  }
  
  public NativeUIManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager;
  }
  
  public StartCheckParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
  }
  
  public ApolloSurfaceView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
  }
  
  public void a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.f)) {
      try
      {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unRegisterScreenBroadcast error e=");
        localStringBuilder.append(localThrowable.toString());
        QLog.e("cmgame_process.CmGameLauncher", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[closeWeb], taskId:", Integer.valueOf(paramInt) });
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      if (((HashMap)localObject).size() == 0) {
        return;
      }
      try
      {
        localObject = (ApolloFloatActivity)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
        if (localObject != null)
        {
          if (((ApolloFloatActivity)localObject).isFinishing()) {
            return;
          }
          ((ApolloFloatActivity)localObject).finish();
          QLog.i("cmgame_process.CmGameLauncher", 1, "succeed to close web activity.");
          return;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[sendMsgToTargetG");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      if (((HashMap)localObject).size() == 0) {
        return;
      }
      try
      {
        localObject = (ApolloFloatActivity)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (((ApolloFloatActivity)localObject).mWebViewInstance != null)
        {
          paramString = new JSONObject(paramString);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("window.mqq && mqq.execEventCallback && mqq.execEventCallback(");
          localStringBuilder.append(Util.a("apolloGameWebMessage"));
          localStringBuilder.append(",");
          localStringBuilder.append(String.valueOf(paramString));
          localStringBuilder.append(",");
          localStringBuilder.append("");
          localStringBuilder.append(");");
          paramString = localStringBuilder.toString();
          ((ApolloFloatActivity)localObject).mWebViewInstance.callJs(paramString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, paramString, new Object[0]);
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    CmGameSubRscHandler localCmGameSubRscHandler = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameSubRscHandler;
    if (localCmGameSubRscHandler != null) {
      localCmGameSubRscHandler.a(paramActivity);
    }
  }
  
  public void a(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams != null) && (paramActivity != null))
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams = paramCmGameInitParams;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(204);
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("openCmGame params:");
        paramActivity.append(paramCmGameInitParams);
        QLog.d("cmgame_process.CmGameLauncher", 2, paramActivity.toString());
      }
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 2, "[openCmGame] parmas is null!");
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "[openCmGame] parmas is null!");
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    if (!ApolloSoLoaderImpl.isLibReady())
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, "engine is not ready.");
      ApolloSoLoaderImpl.removeLoadCallback(this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloSoLoader$OnCmSoLoadCompleteCallback);
      ApolloSoLoaderImpl.addLoadCallback(this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloSoLoader$OnCmSoLoadCompleteCallback);
      ApolloSoLoaderImpl.loadSo("CmGameLauncher");
      return;
    }
    ApolloSoLoaderImpl.removeLoadCallback(this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloSoLoader$OnCmSoLoadCompleteCallback);
    a(paramActivity);
    a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify = new ApolloGameRscVerify(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView == null)
    {
      paramActivity = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramActivity == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContextRef=null");
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager = new NativeUIManager((Context)paramActivity.get(), this.jdField_c_of_type_Int);
      }
      paramActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramActivity == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext=null");
        }
        return;
      }
      if (paramActivity.isFinishing())
      {
        QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext is isFinishing");
        return;
      }
      try
      {
        if (paramActivity.isDestroyed())
        {
          QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext not isDestroyed");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
        boolean bool = CmGameUtil.a(this.jdField_c_of_type_Int);
        QLog.d("cmgame_process.CmGameLauncher", 1, new Object[] { "[initGameUI] mGameId=", Integer.valueOf(this.jdField_c_of_type_Int), ", isIsland=", Boolean.valueOf(bool), ", isTransparent=", Boolean.valueOf(true) });
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView = new ApolloSurfaceView(paramActivity, null, bool, paramBoolean, true);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.setGameId(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.init(this, 1);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.setFrameNum(60);
        this.jdField_a_of_type_Int = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
        try
        {
          Object localObject;
          if ((paramActivity instanceof ApolloWebGameActivity))
          {
            ((ApolloWebGameActivity)paramActivity).a(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[initGameUI] launch from other activity, check it, activity=");
            ((StringBuilder)localObject).append(paramActivity);
            QLog.e("cmgame_process.CmGameLauncher", 1, ((StringBuilder)localObject).toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.setOnKeyListener(this);
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler = new CmGameSubProcessHandler(this.jdField_c_of_type_Int, paramActivity);
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler = new CmGameAvHandler(this.jdField_c_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler = new CmGameNativeMethodHandler(this);
          paramActivity = ApolloCmdChannel.getInstance();
          if (paramActivity != null)
          {
            paramActivity.addRenderRunner(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView);
            localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler;
            if (localObject != null) {
              paramActivity.removeCmdHandler((IRequestHandler)localObject);
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler;
            if (localObject != null) {
              paramActivity.removeCmdHandler((IRequestHandler)localObject);
            }
            paramActivity.addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler);
            paramActivity.addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler);
            paramActivity.addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler);
          }
        }
        catch (Exception paramActivity)
        {
          QLog.e("cmgame_process.CmGameLauncher", 2, paramActivity, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView = null;
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams = null;
          return;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getWorker() != null) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getWorker().b = this.jdField_c_of_type_Int;
    }
    this.jdField_d_of_type_Boolean = true;
    paramActivity = new StringBuilder();
    paramActivity.append("[initGameUI] gameId:");
    paramActivity.append(this.jdField_c_of_type_Int);
    QLog.i("cmgame_process.CmGameLauncher", 2, paramActivity.toString());
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.f = true;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    long l = paramBundle.getLong("ResultCode");
    paramBundle = (CmGameInitParams)paramBundle.getSerializable("CmGameInitParams");
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "onCmGameCheckGameRsp cmGameInitParams", paramBundle });
    }
    Activity localActivity = a();
    if ((l == 0L) && (paramBundle != null)) {
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 1, new Object[] { "onCmGameCheckGameRsp resultCode:", Long.valueOf(l) });
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  public void a(StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam = paramStartCheckParam;
    b(paramStartCheckParam);
  }
  
  public void a(ApolloFloatActivity paramApolloFloatActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[setWebViewObj], taskId:", Integer.valueOf(paramInt), ",web:", paramApolloFloatActivity });
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramApolloFloatActivity);
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler;
    if (localObject != null) {
      ((CmGameAvHandler)localObject).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView != null) {
      ApolloGameStateMachine.a().a(3, "CmGame.onResume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
      if (localObject != null) {
        ((ICmGameAudioPlayer)localObject).b();
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
      if (localObject != null) {
        ((ICmGameAudioPlayer)localObject).b();
      }
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getLuaState(), 0, "sc.game_maximize.local", "{}");
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_foreground.local", "{}");
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer == null) {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer = new ApolloGameMusicPlayer(this.jdField_c_of_type_Int);
      } else if (1 == paramInt) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer = new CmGameSoudPoolPlayer(this.jdField_c_of_type_Int);
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer == null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer = new CmAudioManager(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler;
    if (localObject != null) {
      ((CmGameAvHandler)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
    if (localObject != null) {
      ((ICmGameAudioPlayer)localObject).a();
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
    if (localObject != null) {
      ((ICmGameAudioPlayer)localObject).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView != null) {
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_background.local", "{}");
    }
  }
  
  public void d()
  {
    a();
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
    if (localObject1 != null) {
      ((ICmGameAudioPlayer)localObject1).c();
    }
    localObject1 = this.jdField_b_of_type_ComTencentMobileqqApolloGameProcessAudioICmGameAudioPlayer;
    if (localObject1 != null) {
      ((ICmGameAudioPlayer)localObject1).c();
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      e();
    }
    else
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(202).sendToTarget();
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy in AsyncThread");
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.e = false;
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameNetInfoHandler;
    if (localObject1 != null) {
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject1);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify;
    if (localObject2 != null) {
      ((ApolloGameRscVerify)localObject2).b();
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
    if (localObject2 != null) {
      ((DoraemonAPIManager)localObject2).b();
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager;
    if (localObject2 != null) {
      ((NativeUIManager)localObject2).a();
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAdsCmGameBannerAds;
    if (localObject2 != null) {
      ((CmGameBannerAds)localObject2).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy");
    }
  }
  
  public void e()
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[destroyGameView]");
    ApolloSurfaceView localApolloSurfaceView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
    if (localApolloSurfaceView != null)
    {
      localApolloSurfaceView.setOnDestroyCloseGame(true);
      if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getRenderImpl() != null) {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getRenderImpl().c();
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getParent() != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getParent() instanceof ViewGroup))
          {
            ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView);
          }
          else
          {
            ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getContext().getSystemService("window")).removeView(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView);
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameLauncher", 2, "destroyGameView windowManager.removeView(mApolloGameView)");
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView = null;
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams = null;
    }
    Object localObject1 = ApolloCmdChannel.getInstance();
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
      if (localObject2 != null) {
        ((ApolloCmdChannel)localObject1).removeRenderRunner((IRenderRunner)localObject2);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler;
      if (localObject2 != null) {
        ((ApolloCmdChannel)localObject1).removeCmdHandler((IRequestHandler)localObject2);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler;
      if (localObject2 != null) {
        ((ApolloCmdChannel)localObject1).removeCmdHandler((IRequestHandler)localObject2);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler;
      if (localObject2 != null) {
        ((ApolloCmdChannel)localObject1).removeCmdHandler((IRequestHandler)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAvHandler;
    if (localObject1 != null) {
      ((CmGameAvHandler)localObject1).c();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler;
    if (localObject1 != null) {
      ((CmGameNativeMethodHandler)localObject1).a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 200)
    {
      if (i != 202)
      {
        if (i != 204) {
          return false;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams == null) {
          return false;
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          paramMessage = this.jdField_a_of_type_JavaLangRefWeakReference;
          if (paramMessage != null) {
            a((Activity)paramMessage.get(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mIsEnableMSAA);
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mScreenMode == 0) && (Build.VERSION.SDK_INT >= 19))
        {
          this.jdField_a_of_type_Int = ApolloGameTool.a();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
          if (paramMessage != null) {
            paramMessage.uiOptions = this.jdField_a_of_type_Int;
          }
        }
        if (this.jdField_a_of_type_Boolean) {
          i();
        } else {
          this.jdField_c_of_type_Boolean = true;
        }
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("openCmGame screenMode:");
          paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams.mScreenMode);
          QLog.d("cmgame_process.CmGameLauncher", 2, paramMessage.toString());
          return false;
        }
      }
      else
      {
        d();
        return false;
      }
    }
    else {
      i();
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      QLog.i("cmgame_process.CmGameLauncher", 1, "[KEYCODE_BACK]");
      paramView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
      if (paramView != null)
      {
        paramView.runRenderTask(new CmGameLauncher.6(this));
        return true;
      }
    }
    return false;
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(200);
        this.jdField_c_of_type_Boolean = false;
      }
      ApolloSurfaceView localApolloSurfaceView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
      if (localApolloSurfaceView != null) {
        localApolloSurfaceView.mIsGameReady = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameNetInfoHandler = new CmGameNetInfoHandler(this.jdField_c_of_type_Int);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameNetInfoHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher
 * JD-Core Version:    0.7.0.1
 */