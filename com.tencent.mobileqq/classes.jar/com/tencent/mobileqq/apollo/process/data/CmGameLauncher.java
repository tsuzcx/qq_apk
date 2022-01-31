package com.tencent.mobileqq.apollo.process.data;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import yoe;
import yof;
import yog;
import yoh;
import yoi;
import yoj;

public class CmGameLauncher
  implements Handler.Callback, View.OnKeyListener, OnApolloViewListener
{
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new yoe(this);
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  private ApolloCmdChannel jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameAvHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler;
  private CmGameSubProcessHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private CmGameNetInfoHandler jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler;
  private CmGameOpenIdFinder jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameOpenIdFinder;
  private CmGameScreenRotate jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate;
  private ApolloGameRscVerify jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify;
  private ApolloSoLoader.OnCmSoLoadCompleteCallback jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloSoLoader$OnCmSoLoadCompleteCallback = new yof(this);
  private ApolloPanel.GameMsgInfo jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new yoh(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Runnable jdField_b_of_type_JavaLangRunnable = new yoi(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public CmGameLauncher(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    QLog.i("cmgame_process.CmGameLauncher", 1, "[CmGameLauncher], gameId:" + paramInt);
    DeviceInfoUtil.a();
    CmGameManager localCmGameManager = CmGameUtil.a();
    if (localCmGameManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel = localCmGameManager.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.makesureHasInitObj();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo = new ApolloPanel.GameMsgInfo();
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameOpenIdFinder = new CmGameOpenIdFinder(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  @TargetApi(17)
  private void a(CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams == null) || (TextUtils.isEmpty(paramCmGameInitParams.mGamePath))) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame parmas is null or GamePath is null!");
    }
    Activity localActivity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
          break label644;
        }
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContextRef=null");
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext=null");
    return;
    if (localActivity.isFinishing())
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext is isFinishing");
      return;
    }
    WindowManager localWindowManager;
    DisplayMetrics localDisplayMetrics;
    WindowManager.LayoutParams localLayoutParams;
    try
    {
      if (localActivity.isDestroyed())
      {
        QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext not isDestroyed");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(localActivity, null, CmGameUtil.a(paramCmGameInitParams.mGameId));
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameId(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(this, 1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setTouchMode(1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setFrameNum(60);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate = new CmGameScreenRotate(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      this.jdField_c_of_type_Int = localActivity.getWindow().getDecorView().getSystemUiVisibility();
      localWindowManager = (WindowManager)localActivity.getSystemService("window");
      localDisplayMetrics = new DisplayMetrics();
      localActivity.getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      localLayoutParams = new WindowManager.LayoutParams(-2, -2);
      localLayoutParams.flags = 256;
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, "screenMode:" + paramCmGameInitParams.mScreenMode);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mViewMode == 2) {
        break label364;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mViewMode == 3)
    {
      label364:
      localLayoutParams.height = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      localLayoutParams.width = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      label400:
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 1, "game view " + localLayoutParams.width + " " + localLayoutParams.height);
      }
      localLayoutParams.type = 2;
      localLayoutParams.format = -2;
      this.jdField_a_of_type_Int = localActivity.getWindow().getDecorView().getSystemUiVisibility();
      if ((paramCmGameInitParams.mScreenMode == 0) && (Build.VERSION.SDK_INT >= 19))
      {
        this.jdField_a_of_type_Int = 5894;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.uiOptions = this.jdField_a_of_type_Int;
        a(this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      try
      {
        if ((localActivity instanceof ApolloGameActivity))
        {
          ((ApolloGameActivity)localActivity).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addRenderRunner(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setOnKeyListener(this);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler = new CmGameSubProcessHandler(this.jdField_b_of_type_Int, localActivity);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler = new CmGameAvHandler(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler);
          label644:
          int i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker() != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker().jdField_b_of_type_Int = i;
          }
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
          return;
          localLayoutParams.height = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          localLayoutParams.width = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          break label400;
        }
        if ((localActivity instanceof ApolloWebGameActivity))
        {
          ((ApolloWebGameActivity)localActivity).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          continue;
        }
        QLog.w("cmgame_process.CmGameLauncher", 1, "[checkApolloGame] launch from other activity, check it, activity=" + localActivity);
      }
      catch (Exception paramCmGameInitParams)
      {
        QLog.e("cmgame_process.CmGameLauncher", 2, paramCmGameInitParams, new Object[0]);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
        return;
      }
      localWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, localLayoutParams);
    }
  }
  
  private void h()
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.w("cmgame_process.CmGameLauncher", 1, "game surface view is not ready.");
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath)) && (FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameLauncher", 2, "mGameParams error");
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.init_global_var.local", CmGameUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameName(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.onEnterGame(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null)
    {
      i = -1;
      label135:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
        break label214;
      }
    }
    label214:
    for (String str = "-1";; str = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName)
    {
      VipUtils.a(null, "cmshow", "Apollo", "initialize_game", i, 0, new String[] { str });
      i();
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, "handleMessage onEnterGame");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify.a();
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mSrc;
      break label135;
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[showImmersiveMode] show fullscreen.");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity)))
    {
      Object localObject = (ChatFragment)((FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null) {
          ((BaseChatPie)localObject).ac();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setSystemUiVisibility(this.jdField_a_of_type_Int);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public ApolloSurfaceView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  }
  
  public CmGameStartChecker.StartCheckParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  }
  
  public CmGameInitParams a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  }
  
  public CmGameOpenIdFinder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameOpenIdFinder;
  }
  
  public CmGameScreenRotate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate;
  }
  
  public ApolloPanel.GameMsgInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_c_of_type_Boolean)) {}
    try
    {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "unRegisterScreenBroadcast error e=" + localThrowable.toString());
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof ApolloGameActivity)))
    {
      ApolloGameActivity localApolloGameActivity = (ApolloGameActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (!localApolloGameActivity.a()) {
        localApolloGameActivity.getWindow().getDecorView().setSystemUiVisibility(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult], aioType:", Integer.valueOf(paramInt2), ",gameId:", Integer.valueOf(this.jdField_b_of_type_Int), ",ret:", Integer.valueOf(paramInt1) });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
      {
        paramInt2 = ApolloGameUtil.a(CmGameUtil.a(), paramInt2, paramString);
        paramString = new JSONObject();
        paramString.put("ret", paramInt1);
        paramString.put("gameId", this.jdField_b_of_type_Int);
        paramString.put("aioType", paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, paramString.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.share_game_to_friend_result.local", paramString.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, paramString, new Object[0]);
    }
  }
  
  public void a(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams == null) || (paramActivity == null))
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "[openCmGame] parmas is null!");
      return;
    }
    if (!ApolloSoLoader.a())
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "engine is not ready.");
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
      ApolloSoLoader.b(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloSoLoader$OnCmSoLoadCompleteCallback);
      ApolloSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloSoLoader$OnCmSoLoadCompleteCallback);
      ApolloSoLoader.a("CmGameLauncher");
      return;
    }
    ApolloSoLoader.b(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloSoLoader$OnCmSoLoadCompleteCallback);
    try
    {
      paramCmGameInitParams.mGameId = Integer.parseInt(paramCmGameInitParams.mGameName);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      a(paramActivity);
      if (!FileUtils.a(paramCmGameInitParams.mGamePath))
      {
        QLog.w("cmgame_process.CmGameLauncher", 1, "[openCmGame] gamePath is null");
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, "gameId is invalid, gameName:" + paramCmGameInitParams.mGameName);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify = new ApolloGameRscVerify(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(17);
    paramActivity = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
    paramActivity.what = 17;
    paramActivity.obj = paramCmGameInitParams;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramActivity);
    QLog.i("cmgame_process.CmGameLauncher", 2, "[openCmGame] gamePath:" + paramCmGameInitParams.mGamePath);
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
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public void a(String paramString)
  {
    QLog.d("cmgame_process.CmGameLauncher", 1, "shareGameInMenu ");
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_share.local", "{}");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(19);
      Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(19);
      localMessage.obj = paramString;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, 1000L);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 1, "sendGameShareMsg reqData is empty");
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null)) || ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.c();
    }
    ApolloCmdChannel localApolloCmdChannel = CmGameUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      ApolloGameStateMachine.a().a(3, "CmGame.onResume");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (localApolloCmdChannel != null) && (localApolloCmdChannel != null))
    {
      localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_maximize.local", "{}");
      localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_foreground.local", "{}");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility() == 0) {
        localApolloCmdChannel.resumeGameMusic(this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRuntimeState(), 0, "sc.web_callback_game.local", paramString);
        return;
      }
      QLog.e("cmgame_process.CmGameLauncher", 1, "[sendMessageToGame] gameview null");
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 1, "[sendMessageToGame] channel null");
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.b();
    }
    ApolloCmdChannel localApolloCmdChannel = CmGameUtil.a();
    if ((localApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      localApolloCmdChannel.pauseGameMusic(this.jdField_b_of_type_Int);
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(19);
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManager.post(new yoj(this, paramString), 5, null, true);
    }
    QLog.d("cmgame_process.CmGameLauncher", 1, new Object[] { "handleShareMsgCallbackFromEngine mHadHandleShareMsg:", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "reqData:" + paramString);
    }
  }
  
  public void d()
  {
    a();
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      e();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
      ApolloCmdChannel localApolloCmdChannel = CmGameUtil.a();
      if (localApolloCmdChannel != null) {
        localApolloCmdChannel.pauseGameMusic(this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler != null) {}
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify.b();
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy");
        }
        return;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(18).sendToTarget();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy in AsyncThread");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  public void e()
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[destroyGameView]");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      a(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setOnDestroyCloseGame(true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().c();
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent() != null)
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent() instanceof ViewGroup)) {
          break label167;
        }
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeRenderRunner(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.d();
          }
        }
        return;
        label167:
        ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getContext().getSystemService("window")).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "destroyGameView windowManager.removeView(mApolloGameView)");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.pauseGameMusic(this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.a(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_minimize.local", "{}");
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_pack_up.local", "{}");
      }
    }
    CmGameToolCmdChannel.a("cs.make_room_min.local", "{}", false, null, this.jdField_b_of_type_Int);
    if ((CmGameUtil.a() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
      CmGameUtil.a(this.jdField_b_of_type_Int, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "onBackEvent");
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_close.local", "{}");
    }
    CmGameToolCmdChannel.a("cs.close_room.local", "{}", false, null, this.jdField_b_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof CmGameInitParams))
      {
        a((CmGameInitParams)paramMessage.obj);
        continue;
        h();
        continue;
        d();
        continue;
        if ((paramMessage.obj instanceof String)) {
          ApolloGameBasicEventUtil.a(this.jdField_b_of_type_Int, (String)paramMessage.obj, a());
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      QLog.i("cmgame_process.CmGameLauncher", 1, "[KEYCODE_BACK]");
      paramView = CmGameUtil.a();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.runRenderTask(new yog(this, paramView));
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
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsGameReady = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler = new CmGameNetInfoHandler(this.jdField_b_of_type_Int);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher
 * JD-Core Version:    0.7.0.1
 */