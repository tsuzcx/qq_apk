package com.tencent.mobileqq.apollo.game.process.data;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.game.CmIslandActivity;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer;
import com.tencent.mobileqq.apollo.game.process.audio.CmGameSoudPoolPlayer;
import com.tencent.mobileqq.apollo.game.process.audio.ICmGameAudioPlayer;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.res.api.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class CmGameLauncher
  implements Handler.Callback, OnApolloViewListener
{
  private long A;
  public WeakReference<Activity> a;
  public int b = 0;
  public int c;
  public long d;
  private int e;
  private WeakReferenceHandler f = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private ApolloSurfaceView g;
  private CmGameInitParams h;
  private StartCheckParam i;
  private boolean j;
  private CmGameSubProcessHandler k;
  private CmGameNetInfoHandler l;
  private ApolloGameRscVerify m;
  private ICmGameAudioPlayer n;
  private HashMap<Integer, ApolloFloatActivity> o = new HashMap();
  private CmGameSubRscHandler p;
  private DoraemonAPIManager q;
  private int r = 1;
  private CmGameNativeMethodHandler s;
  private BroadcastReceiver t = new CmGameLauncher.1(this);
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y = false;
  private IApolloSoLoader.OnCmSoLoadCompleteCallback z = new CmGameLauncher.5(this);
  
  public CmGameLauncher(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[CmGameLauncher], gameId:");
    localStringBuilder.append(paramInt);
    QLog.i("cmgame_process.CmGameLauncher", 1, localStringBuilder.toString());
    DeviceInfoUtil.A();
    this.e = paramInt;
    this.p = new CmGameSubRscHandler(paramInt);
  }
  
  private void n()
  {
    ThreadManagerV2.excute(new CmGameLauncher.2(this), 16, null, false);
  }
  
  private void o()
  {
    ThreadManagerV2.excute(new CmGameLauncher.3(this), 16, null, false);
  }
  
  private void p()
  {
    Activity localActivity = f();
    if (localActivity == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new CmGameLauncher.4(this, localActivity));
  }
  
  private void q()
  {
    if (!this.j)
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "game surface view is not ready.");
      return;
    }
    Object localObject1 = this.h;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((CmGameInitParams)localObject1).mGamePath)) && (FileUtils.fileExists(this.h.mGamePath)))
    {
      Object localObject2;
      if (this.g != null)
      {
        if (this.w)
        {
          QLog.w("cmgame_process.CmGameLauncher", 1, "has ready startGameEngine");
          return;
        }
        this.w = true;
        ApolloCmdChannel.getInstance().callbackFromRequest(this.g.getLuaState(), 0, "sc.init_global_var.local", CmGameUtil.a(this.h));
        this.g.setGameName(this.h.mGameName);
        this.g.onEnterGame(this.h.mGamePath);
        int i1 = this.h.mSrc;
        localObject2 = this.h.mGameName;
        localObject1 = this.i;
        if (localObject1 == null) {
          localObject1 = "-1";
        } else {
          localObject1 = String.valueOf(ApolloGameTool.b(((StartCheckParam)localObject1).extendJson));
        }
        VipUtils.a(null, "cmshow", "Apollo", "initialize_game", i1, 0, new String[] { localObject2, localObject1 });
        r();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "handleMessage onEnterGame");
        }
        localObject1 = this.m;
        if (localObject1 != null) {
          ((ApolloGameRscVerify)localObject1).a();
        }
        try
        {
          ApolloCmdChannel.getInstance().callbackFromRequest(this.g.getLuaState(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
        }
        catch (Exception localException)
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
        }
      }
      this.d = SystemClock.uptimeMillis();
      long l1 = this.d - this.A;
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_open_to_start_engine, duration=", Long.valueOf(l1), ", mStartGameEngineTs=", Long.valueOf(this.d), ", mOpenCmGameTs=", Long.valueOf(this.A), ", gameId=", this.h.mGameName });
      if (l1 > 0L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_gameId", this.h.mGameName);
        localObject2 = CmGameUtil.b();
        if (localObject2 != null) {
          StatisticCollector.getInstance(((AppInterface)localObject2).getApp()).collectPerformance(((AppInterface)localObject2).getCurrentAccountUin(), "cmgame_open_to_start_engine", true, l1, 0L, localHashMap, "", false);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "mGameParams error");
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[showImmersiveMode] show fullscreen.");
    }
    if ((this.a.get() != null) && ((this.a.get() instanceof BaseActivity)))
    {
      localObject = ((BaseActivity)this.a.get()).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if (localObject != null) {
          ((BaseChatPie)localObject).as();
        }
      }
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((ApolloSurfaceView)localObject).setSystemUiVisibility(this.b);
    }
  }
  
  public CmGameSubRscHandler a()
  {
    return this.p;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[closeWeb], taskId:", Integer.valueOf(paramInt) });
    }
    Object localObject = this.o;
    if (localObject != null)
    {
      if (((HashMap)localObject).size() == 0) {
        return;
      }
      try
      {
        localObject = (ApolloFloatActivity)this.o.remove(Integer.valueOf(paramInt));
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
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.j)
    {
      this.j = true;
      if (this.u)
      {
        this.f.sendEmptyMessage(200);
        this.u = false;
      }
      ApolloSurfaceView localApolloSurfaceView = this.g;
      if (localApolloSurfaceView != null) {
        localApolloSurfaceView.mIsGameReady = true;
      }
      this.l = new CmGameNetInfoHandler(this.e);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.l);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
    CmGameSubRscHandler localCmGameSubRscHandler = this.p;
    if (localCmGameSubRscHandler != null) {
      localCmGameSubRscHandler.a(paramActivity);
    }
  }
  
  public void a(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams != null) && (paramActivity != null))
    {
      this.A = SystemClock.uptimeMillis();
      this.h = paramCmGameInitParams;
      this.a = new WeakReference(paramActivity);
      this.f.sendEmptyMessage(204);
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
    this.a = new WeakReference(paramActivity);
    if (!ApolloSoLoaderImpl.isLibReady())
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, "engine is not ready.");
      ApolloSoLoaderImpl.removeLoadCallback(this.z);
      ApolloSoLoaderImpl.addLoadCallback(this.z);
      ApolloSoLoaderImpl.loadSo("CmGameLauncher");
      return;
    }
    ApolloSoLoaderImpl.removeLoadCallback(this.z);
    a(paramActivity);
    a(paramActivity);
    this.m = new ApolloGameRscVerify(this.e);
    if (this.g == null)
    {
      paramActivity = this.a;
      if (paramActivity == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContextRef=null");
        }
        return;
      }
      paramActivity = (Activity)paramActivity.get();
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
        boolean bool = CmGameUtil.b(this.e);
        QLog.d("cmgame_process.CmGameLauncher", 1, new Object[] { "[initGameUI] mGameId=", Integer.valueOf(this.e), ", isIsland=", Boolean.valueOf(bool), ", isTransparent=", Boolean.valueOf(true) });
        this.g = new ApolloSurfaceView(paramActivity, null, bool, paramBoolean, true);
        this.g.setGameId(this.e);
        this.g.init(this, 1);
        this.g.setFrameNum(60);
        this.b = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
        try
        {
          Object localObject;
          if ((paramActivity instanceof CmIslandActivity))
          {
            ((CmIslandActivity)paramActivity).a(this.g);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[initGameUI] launch from other activity, check it, activity=");
            ((StringBuilder)localObject).append(paramActivity);
            QLog.e("cmgame_process.CmGameLauncher", 1, ((StringBuilder)localObject).toString());
          }
          this.k = new CmGameSubProcessHandler(this.e, paramActivity);
          this.s = new CmGameNativeMethodHandler(this);
          paramActivity = ApolloCmdChannel.getInstance();
          if (paramActivity != null)
          {
            paramActivity.addRenderRunner(this.g);
            localObject = this.k;
            if (localObject != null) {
              paramActivity.removeCmdHandler((IRequestHandler)localObject);
            }
            paramActivity.addCmdHandler(this.k);
            paramActivity.addCmdHandler(this.s);
          }
        }
        catch (Exception paramActivity)
        {
          QLog.e("cmgame_process.CmGameLauncher", 2, paramActivity, new Object[0]);
          this.g = null;
          this.h = null;
          return;
        }
      }
    }
    if (this.g.getWorker() != null) {
      this.g.getWorker().g = this.e;
    }
    this.v = true;
    paramActivity = new StringBuilder();
    paramActivity.append("[initGameUI] gameId:");
    paramActivity.append(this.e);
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
    paramContext.registerReceiver(this.t, localIntentFilter);
    this.x = true;
  }
  
  public void a(StartCheckParam paramStartCheckParam)
  {
    this.i = paramStartCheckParam;
  }
  
  public void a(ApolloFloatActivity paramApolloFloatActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[setWebViewObj], taskId:", Integer.valueOf(paramInt), ",web:", paramApolloFloatActivity });
    }
    if (this.o == null) {
      this.o = new HashMap();
    }
    this.o.put(Integer.valueOf(paramInt), paramApolloFloatActivity);
  }
  
  public void a(String paramString) {}
  
  public void b()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.x)) {
      try
      {
        ((Activity)this.a.get()).unregisterReceiver(this.t);
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
  
  public void b(int paramInt)
  {
    if (this.n != null) {
      return;
    }
    if (paramInt == 0)
    {
      this.n = new ApolloGameMusicPlayer(this.e);
      return;
    }
    if (1 == paramInt) {
      this.n = new CmGameSoudPoolPlayer(this.e);
    }
  }
  
  public StartCheckParam c()
  {
    return this.i;
  }
  
  public CmGameInitParams d()
  {
    return this.h;
  }
  
  public ApolloSurfaceView e()
  {
    return this.g;
  }
  
  public Activity f()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public int g()
  {
    return this.e;
  }
  
  public ICmGameAudioPlayer h()
  {
    return this.n;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 200)
    {
      if (i1 != 202)
      {
        if (i1 != 204) {
          return false;
        }
        if (this.h == null) {
          return false;
        }
        if (!this.v)
        {
          paramMessage = this.a;
          if (paramMessage != null) {
            a((Activity)paramMessage.get(), this.h.mIsEnableMSAA);
          }
        }
        if ((this.h.mScreenMode == 0) && (Build.VERSION.SDK_INT >= 19))
        {
          this.b = ApolloGameTool.a();
          paramMessage = this.g;
          if (paramMessage != null) {
            paramMessage.uiOptions = this.b;
          }
        }
        if (this.j) {
          q();
        } else {
          this.u = true;
        }
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("openCmGame screenMode:");
          paramMessage.append(this.h.mScreenMode);
          QLog.d("cmgame_process.CmGameLauncher", 2, paramMessage.toString());
          return false;
        }
      }
      else
      {
        k();
        return false;
      }
    }
    else {
      q();
    }
    return false;
  }
  
  public void i()
  {
    if (this.g == null) {
      return;
    }
    ApolloGameStateMachine.a().a(3, "CmGame.onResume");
    ICmGameAudioPlayer localICmGameAudioPlayer = this.n;
    if (localICmGameAudioPlayer != null) {
      localICmGameAudioPlayer.b();
    }
    ApolloCmdChannel.getInstance().callbackFromRequest(this.g.getLuaState(), 0, "sc.game_maximize.local", "{}");
    ApolloCmdChannel.getInstance().callbackFromRequest(this.g.getLuaState(), 0, "sc.game_enter_foreground.local", "{}");
  }
  
  public void j()
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = this.n;
    if (localICmGameAudioPlayer != null) {
      localICmGameAudioPlayer.a();
    }
    if (this.g != null) {
      ApolloCmdChannel.getInstance().callbackFromRequest(this.g.getLuaState(), 0, "sc.game_enter_background.local", "{}");
    }
  }
  
  public void k()
  {
    b();
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.f.removeCallbacksAndMessages(null);
    Object localObject1 = this.n;
    if (localObject1 != null) {
      ((ICmGameAudioPlayer)localObject1).c();
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      l();
    }
    else
    {
      this.f.obtainMessage(202).sendToTarget();
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy in AsyncThread");
      }
    }
    this.j = false;
    this.w = false;
    this.h = null;
    localObject1 = this.l;
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
    Object localObject2 = this.m;
    if (localObject2 != null) {
      ((ApolloGameRscVerify)localObject2).e();
    }
    localObject2 = this.q;
    if (localObject2 != null) {
      ((DoraemonAPIManager)localObject2).b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy");
    }
  }
  
  public void l()
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[destroyGameView]");
    ApolloSurfaceView localApolloSurfaceView = this.g;
    if (localApolloSurfaceView != null)
    {
      localApolloSurfaceView.setOnDestroyCloseGame(true);
      if (this.g.getRenderImpl() != null) {
        this.g.getRenderImpl().c();
      }
      try
      {
        if (this.g.getParent() != null) {
          if ((this.g.getParent() instanceof ViewGroup))
          {
            ((ViewGroup)this.g.getParent()).removeView(this.g);
          }
          else
          {
            ((WindowManager)this.g.getContext().getSystemService("window")).removeView(this.g);
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
      this.g = null;
      this.a = null;
      this.j = false;
      this.h = null;
    }
    Object localObject1 = ApolloCmdChannel.getInstance();
    if (localObject1 != null)
    {
      Object localObject2 = this.g;
      if (localObject2 != null) {
        ((ApolloCmdChannel)localObject1).removeRenderRunner((IRenderRunner)localObject2);
      }
      localObject2 = this.k;
      if (localObject2 != null) {
        ((ApolloCmdChannel)localObject1).removeCmdHandler((IRequestHandler)localObject2);
      }
      localObject2 = this.s;
      if (localObject2 != null) {
        ((ApolloCmdChannel)localObject1).removeCmdHandler((IRequestHandler)localObject2);
      }
    }
    localObject1 = this.s;
    if (localObject1 != null) {
      ((CmGameNativeMethodHandler)localObject1).b();
    }
  }
  
  public boolean m()
  {
    return this.r == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher
 * JD-Core Version:    0.7.0.1
 */