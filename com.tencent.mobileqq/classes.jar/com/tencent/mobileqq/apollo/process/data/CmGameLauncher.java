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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameMusicPlayer;
import com.tencent.mobileqq.apollo.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import yxx;
import yxy;
import yxz;
import yya;
import yyb;
import yyc;

public class CmGameLauncher
  implements Handler.Callback, View.OnKeyListener, OnApolloViewListener
{
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new yxx(this);
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  private ApolloCmdChannel jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameAvHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler;
  private CmGameSubProcessHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler;
  private CmGameCommonShare jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private CmGameLauncher.RedPacketInfo jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo;
  private CmGameNetInfoHandler jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler;
  private CmGameOpenIdFinder jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameOpenIdFinder;
  private CmGameScreenRotate jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate;
  private ApolloGameMusicPlayer jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer;
  private ApolloGameRscVerify jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify;
  private ApolloSoLoader.OnCmSoLoadCompleteCallback jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloSoLoader$OnCmSoLoadCompleteCallback = new yxy(this);
  private ApolloPanel.GameMsgInfo jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new yya(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new yyb(this);
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private boolean c;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
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
    this.jdField_d_of_type_Int = paramInt;
    CmGameShareDataHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer = new ApolloGameMusicPlayer(CmGameUtil.a(), this.jdField_d_of_type_Int);
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
          break label645;
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
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameId(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(this, 1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setTouchMode(1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setFrameNum(60);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate = new CmGameScreenRotate(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      this.jdField_e_of_type_Int = localActivity.getWindow().getDecorView().getSystemUiVisibility();
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
        break label365;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mViewMode == 3)
    {
      label365:
      localLayoutParams.height = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      localLayoutParams.width = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
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
        b(this.jdField_a_of_type_Int);
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
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler = new CmGameSubProcessHandler(this.jdField_d_of_type_Int, localActivity);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler = new CmGameAvHandler(this.jdField_d_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler);
          label645:
          int i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker() != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker().jdField_b_of_type_Int = i;
          }
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare = new CmGameCommonShare(a(), CmGameUtil.a());
          if ((a() instanceof ApolloGameActivity)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare.a(((ApolloGameActivity)a()).a());
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare.a(this.jdField_d_of_type_Int);
          return;
          localLayoutParams.height = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          localLayoutParams.width = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          break;
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
  
  private void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (!TextUtils.isEmpty(paramStartCheckParam.extendJson))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramStartCheckParam.extendJson);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo = new CmGameLauncher.RedPacketInfo();
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.g = localJSONObject.optString("payParam");
      paramStartCheckParam.gameType = localJSONObject.optInt("gameType", 0);
      paramStartCheckParam.redUrl = localJSONObject.optString("redUrl", "");
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.jdField_a_of_type_Int = localJSONObject.optInt("score", -1);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.jdField_c_of_type_JavaLangString = localJSONObject.optString("baseUrl");
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.b = localJSONObject.optString("listId");
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
      if (CmGameUtil.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.jdField_a_of_type_Long = Long.parseLong(CmGameUtil.a().getCurrentAccountUin());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.e = localJSONObject.optString("nickName", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.jdField_a_of_type_Long));
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.h = localJSONObject.optString("uin", "");
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 1, "[setRedPacketInfo] " + this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo.toString());
      }
      return;
    }
    catch (JSONException paramStartCheckParam)
    {
      paramStartCheckParam.printStackTrace();
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
    return this.jdField_d_of_type_Int;
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
  
  public CmGameLauncher.RedPacketInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher$RedPacketInfo;
  }
  
  public CmGameOpenIdFinder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameOpenIdFinder;
  }
  
  public CmGameScreenRotate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate;
  }
  
  public ApolloGameMusicPlayer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer;
  }
  
  public ApolloPanel.GameMsgInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_e_of_type_Boolean)) {}
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
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[closeWeb], taskId:", Integer.valueOf(paramInt) });
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        ApolloFloatActivity localApolloFloatActivity = (ApolloFloatActivity)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
        if ((localApolloFloatActivity != null) && (!localApolloFloatActivity.isFinishing()))
        {
          localApolloFloatActivity.finish();
          QLog.i("cmgame_process.CmGameLauncher", 1, "succeed to close web activity.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject;
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1))
      {
        localObject = a();
        if ((localObject != null) && ((localObject instanceof ApolloGameActivity)) && (!((Activity)localObject).isFinishing()))
        {
          localObject = ((ApolloGameActivity)localObject).a();
          if (localObject != null) {
            ((ApolloGameView)localObject).a(paramInt1, this.jdField_d_of_type_Int, paramInt3, paramInt2);
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
      {
        localObject = new CmGameShareDataHandler.GameShareResult();
        ((CmGameShareDataHandler.GameShareResult)localObject).jdField_e_of_type_Int = paramInt1;
        ((CmGameShareDataHandler.GameShareResult)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
        ((CmGameShareDataHandler.GameShareResult)localObject).jdField_a_of_type_Int = this.jdField_d_of_type_Int;
        ((CmGameShareDataHandler.GameShareResult)localObject).jdField_d_of_type_Int = paramInt2;
        ((CmGameShareDataHandler.GameShareResult)localObject).jdField_c_of_type_Int = paramInt3;
        ((CmGameShareDataHandler.GameShareResult)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((CmGameShareDataHandler.GameShareResult)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult],gameShareResult:", localObject });
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("reqCode", this.jdField_c_of_type_Int);
        this.jdField_c_of_type_Int = 0;
        localJSONObject.put("ret", paramInt1);
        localJSONObject.put("gameId", this.jdField_d_of_type_Int);
        localJSONObject.put("aioType", paramInt3);
        localJSONObject.put("shareTo", paramInt2);
        if (!CmGameShareDataHandler.a().a((CmGameShareDataHandler.GameShareResult)localObject)) {
          break label429;
        }
        paramInt3 = 0;
        localJSONObject.put("isFirstTimeShare", paramInt3);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult] engine root:", localJSONObject.toString() });
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.share_game_to_friend_result.local", localJSONObject.toString());
        CmGameShareDataHandler.a().a((CmGameShareDataHandler.GameShareResult)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare.a())) {
        break label434;
      }
      paramInt3 = 1;
    }
    catch (Throwable paramString)
    {
      label349:
      QLog.e("cmgame_process.CmGameLauncher", 1, paramString, new Object[0]);
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", (String)localObject, 0, paramInt1, new String[] { String.valueOf(this.jdField_d_of_type_Int), paramString });
    return;
    label391:
    label420:
    label429:
    label434:
    label437:
    for (;;)
    {
      localObject = "sendShowOffButtonSuccessful";
      break label420;
      paramInt1 = 4;
      break label349;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label437;
        }
        localObject = "sendUniversialFrameShareButtonSuccessful";
        if (paramInt1 != 0) {
          break label391;
        }
        paramInt1 = paramInt2;
        break label349;
        paramInt3 = 1;
        break;
        paramInt3 = 0;
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
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
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify = new ApolloGameRscVerify(this.jdField_d_of_type_Int);
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
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
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
      this.jdField_d_of_type_Boolean = true;
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
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.c();
    }
    ApolloCmdChannel localApolloCmdChannel = CmGameUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      ApolloGameStateMachine.a().a(3, "CmGame.onResume");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (localApolloCmdChannel != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer.b();
      }
      if (localApolloCmdChannel != null)
      {
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_maximize.local", "{}");
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_foreground.local", "{}");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof ApolloGameActivity)))
    {
      ApolloGameActivity localApolloGameActivity = (ApolloGameActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (!localApolloGameActivity.a()) {
        localApolloGameActivity.getWindow().getDecorView().setSystemUiVisibility(paramInt);
      }
    }
  }
  
  public void b(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare = new CmGameCommonShare(a(), CmGameUtil.a());
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer.a();
    }
    ApolloCmdChannel localApolloCmdChannel = CmGameUtil.a();
    if ((localApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_background.local", "{}");
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(19);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare != null))
    {
      boolean bool = this.jdField_d_of_type_Boolean;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new yyc(this, paramString, bool));
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer.c();
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {
      e();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler != null) {}
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameRscVerify.b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare.a();
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
      b(this.jdField_e_of_type_Int);
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
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.a(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_minimize.local", "{}");
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_pack_up.local", "{}");
      }
    }
    CmGameToolCmdChannel.a("cs.make_room_min.local", "{}", false, null, this.jdField_d_of_type_Int);
    if ((CmGameUtil.a() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
      CmGameUtil.a(this.jdField_d_of_type_Int, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
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
    CmGameToolCmdChannel.a("cs.close_room.local", "{}", false, null, this.jdField_d_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 17: 
      do
      {
        return false;
      } while (!(paramMessage.obj instanceof CmGameInitParams));
      a((CmGameInitParams)paramMessage.obj);
      return false;
    case 16: 
      h();
      return false;
    case 18: 
      d();
      return false;
    }
    if ((paramMessage.obj instanceof String))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare.a(this.jdField_d_of_type_Int))) {
        break label138;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare.a((String)paramMessage.obj, this.jdField_d_of_type_Int, this.jdField_d_of_type_Boolean);
      this.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return false;
      label138:
      ApolloGameBasicEventUtil.a(this.jdField_d_of_type_Int, (String)paramMessage.obj, a());
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
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.runRenderTask(new yxz(this, paramView));
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
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler = new CmGameNetInfoHandler(this.jdField_d_of_type_Int);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameNetInfoHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher
 * JD-Core Version:    0.7.0.1
 */