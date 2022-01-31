package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameTimeReporter;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.sso.CmGameObserver;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;
import ysu;
import ysv;
import ysw;
import ysx;
import ysy;
import ysz;
import yta;
import ytb;
import ytc;

public class ApolloGameActivity
  extends FragmentActivity
  implements Handler.Callback, View.OnClickListener, URLDrawable.URLDrawableListener, Observer
{
  public static final String a;
  public static WeakReference a;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameStartChecker jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker;
  private ApolloGameView jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView;
  private CmGameLauncher jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher;
  private CmGameObserver jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver = new ysu(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private ytc jdField_a_of_type_Ytc;
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aI + "/QQ_Screenshot/cmshow_game_splash.png";
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (!ApolloEngine.a())
    {
      QLog.e("cmgame_process.ApolloGameActivity", 1, "fastLaunchGame engine not ready");
      return;
    }
    Intent localIntent = new Intent(paramActivity, ApolloGameActivity.class);
    localIntent.putExtra("extra_key_gameid", paramInt1);
    localIntent.putExtra("extra_key_extra_str", paramString2);
    localIntent.putExtra("extra_key_gameMode", paramInt2);
    localIntent.putExtra("extra_key_gameParam", paramString1);
    localIntent.putExtra("extra_key_fastLaunch", true);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null))
    {
      localObject1 = paramStartCheckParam.game.name;
      localObject2 = paramStartCheckParam.game.logoUrl;
      localObject3 = localObject1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362817));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362819));
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131362838);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362839);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362827));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      ((TextView)super.findViewById(2131362826)).setText((CharSequence)localObject3);
      localObject2 = (URLImageView)super.findViewById(2131362824);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        Resources localResources = super.getResources();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localResources.getDrawable(2130838068);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localResources.getDrawable(2130838068);
        ((URLImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362832));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362831));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131362829));
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localObject1 = super.findViewById(2131362828);
        if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null) || (!paramStartCheckParam.game.isFeatured)) {
          break label320;
        }
        ((View)localObject1).setVisibility(0);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362830));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        ((URLImageView)localObject2).setImageResource(2130838068);
        break;
        label320:
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = null;
      localObject3 = null;
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.a(this, paramString, 0).a();
    }
    super.finish();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) && (!b()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.viewMode == 1) {
        super.setRequestedOrientation(8);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.viewMode == 2)
    {
      super.setRequestedOrientation(0);
      return;
    }
    super.setRequestedOrientation(1);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.showAlertTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameActivity", 2, "checkShowMsgAlert mStartCheckParam == null || !mStartCheckParam.showAlertTips");
      }
    }
    while (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 2) {
      str = "游戏已经取消啦，自己去玩一局试试~";
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this, 0, null, str, 2131433016, 2131433015, null, new ytb(this));
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(str);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.ApolloGameActivity", 2, new Object[] { "checkShowMsgAlert msgText:", str });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 3) {
        str = "游戏已经开始啦，自己去玩一局试试~";
      } else if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 4) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 5) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 6) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 7) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 8)) {
        str = "游戏已经结束啦，自己去玩一局试试~";
      }
    }
  }
  
  public ApolloGameView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.mNeedStatusTrans = true;
    setImmersiveStatus(0);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(paramInt);
      this.mSystemBarComp.setStatusBarColor(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloGameActivity", 2, new Object[] { "[dismissLoadingPage] delayTime：", Long.valueOf(paramLong) });
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(21);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(21, paramLong);
  }
  
  public void a(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 3)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a(paramIntent);
    }
  }
  
  public void a(ApolloSurfaceView paramApolloSurfaceView)
  {
    ((FrameLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362818)).addView(paramApolloSurfaceView, new FrameLayout.LayoutParams(-1, -1));
    a(3000L);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 3);
  }
  
  @TargetApi(21)
  public void b()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Resources localResources = getResources();
      localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130838068);
      localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130838068);
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.logoUrl, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 1);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloGameActivity", 2, "[doOnActivityResult], resultCode:" + paramInt2);
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      do
      {
        return;
        if (paramIntent == null) {
          break;
        }
      } while (StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes")) == null);
      paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      VipUtils.a(null, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(i), 0, new String[] { Integer.toString(j) });
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) && (paramIntent != null))
      {
        i = paramIntent.getIntExtra("share_result_key", -1);
        if (i == 0) {}
        try
        {
          QQToast.a(getApplicationContext(), "已成功发送消息", 0).a();
          j = paramIntent.getIntExtra("uintype", -1);
          String str = paramIntent.getStringExtra("uin");
          j = ApolloGameUtil.a(CmGameUtil.a(), j, str);
          if (b()) {
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a(i, j, str);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("cmgame_process.ApolloGameActivity", 1, localThrowable, new Object[0]);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a(i, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, j);
        }
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a().queueEvent(new ysz(this, paramInt1, paramInt2, paramIntent));
        }
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      QLog.d("cmgame_process.ApolloGameActivity", 1, new Object[] { "[doOnConfigurationChanged] new orientation=", Integer.valueOf(paramConfiguration.orientation), ", mOrientation=", Integer.valueOf(this.jdField_b_of_type_Int) });
      if (this.jdField_b_of_type_Int != paramConfiguration.orientation)
      {
        this.jdField_b_of_type_Int = paramConfiguration.orientation;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(23);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(23, 500L);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ApolloGameStateMachine.a().a();
    ApolloGameStateMachine.a().addObserver(this);
    this.mNeedStatusTrans = false;
    super.getWindow().addFlags(67108864);
    super.doOnCreate(paramBundle);
    new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = ((CmGameStartChecker.StartCheckParam)super.getIntent().getSerializableExtra("extra_startcheckparam"));
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null))
    {
      QLog.e("cmgame_process.ApolloGameActivity", 1, "[doOnCreate] no start param");
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.requestCode = System.currentTimeMillis();
    QLog.i("cmgame_process.ApolloGameActivity", 1, "[doOnCreate] launch_cmgame mStartCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam + ", this:" + this);
    CmGameUtil.a(1, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    ApolloGameTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.viewMode == 1)
    {
      super.setRequestedOrientation(8);
      i = 0;
      if (i == 0) {
        break label545;
      }
      j = 1;
      label227:
      this.jdField_b_of_type_Int = j;
      if (i == 0) {
        break label550;
      }
    }
    label545:
    label550:
    for (int i = 2130968602;; i = 2130968603)
    {
      super.setContentView(i);
      a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      paramBundle = CmGameUtil.a();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker = new CmGameStartChecker(paramBundle);
      this.jdField_a_of_type_Ytc = new ytc(this, paramBundle);
      if (paramBundle != null)
      {
        paramBundle.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver);
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_a_of_type_Ytc);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) && (!a()))
        {
          paramBundle = CmGameUtil.a();
          if (paramBundle != null) {
            paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId, "android.aio");
          }
        }
      }
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
      paramBundle = new Bundle();
      paramBundle.putString("session_uin", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin);
      paramBundle.putSerializable("game_data", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game);
      paramBundle.putSerializable("game_init", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView = new ApolloGameView(getWindow(), paramBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.jdField_b_of_type_Boolean = true;
        if (this.mSystemBarComp != null)
        {
          this.mSystemBarComp.setStatusColor(-1);
          this.mSystemBarComp.setStatusBarColor(-1);
        }
        ThreadManager.post(new ysv(this), 8, null, false);
      }
      ThreadManager.post(new ysw(this), 8, null, true);
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.viewMode == 2)
      {
        super.setRequestedOrientation(0);
        i = 0;
        break;
      }
      super.setRequestedOrientation(1);
      i = 1;
      break;
      j = 2;
      break label227;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.i("cmgame_process.ApolloGameActivity", 1, "[doOnDestroy] this:" + this);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a(false);
    }
    AppInterface localAppInterface = CmGameUtil.a();
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver);
    }
    this.jdField_b_of_type_Boolean = true;
    ApolloGameStateMachine.a().deleteObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.d();
      CmGameUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null)) {
      CmGameUtil.a(4, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    }
    ApolloFragmentManager.a().a();
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    ApolloGameTimeReporter.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (3 == paramInt)
    {
      onBackEvent();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    c();
    super.doOnNewIntent(paramIntent);
    ApolloGameTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null)) {
      CmGameUtil.a(3, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(18);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.c();
    }
    ApolloGameTimeReporter.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  protected void doOnResume()
  {
    c();
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null)) {
      CmGameUtil.a(2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 500L);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.b();
    }
    ApolloGameTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19))
    {
      View localView = getWindow().getDecorView();
      if (!a()) {
        localView.setSystemUiVisibility(5894);
      }
    }
  }
  
  protected String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return false;
                  } while (!(paramMessage.obj instanceof String));
                  a((String)paramMessage.obj);
                  return false;
                  this.jdField_a_of_type_Int += 1;
                } while (this.jdField_a_of_type_Int >= 3);
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 500L);
                return false;
                localObject = (String)paramMessage.obj;
                paramMessage = (Message)localObject;
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  paramMessage = "启动失败，请稍后重试哦~";
                }
                if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                  this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
                }
                this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
              this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              return false;
              QLog.d("cmgame_process.ApolloGameActivity", 1, "[handleMessage] close game timeout, just finish");
              finish();
              return false;
              if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
                break;
              }
              QLog.d("cmgame_process.ApolloGameActivity", 1, "[handleMessage] remove loading rootView.");
              paramMessage = new AlphaAnimation(1.0F, 0.0F);
              paramMessage.setDuration(300L);
              paramMessage.setAnimationListener(new ysy(this));
              if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
                this.jdField_c_of_type_AndroidWidgetTextView.setText("100%");
              }
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(paramMessage);
            } while ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enableMenu));
            QLog.d("cmgame_process.ApolloGameActivity", 1, "[handleMessage] remove top menu");
            paramMessage = findViewById(2131362834);
          } while (paramMessage == null);
          paramMessage.setVisibility(8);
          return false;
          QLog.e("cmgame_process.ApolloGameActivity", 1, "[handleMessage] loading root is null");
          return false;
          this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%d%%", new Object[] { paramMessage.obj }));
        } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return false;
        QLog.d("cmgame_process.ApolloGameActivity", 1, "[handleMessage] MSG_RESET_TOP_MENU");
        paramMessage = super.findViewById(2131362834);
      } while ((paramMessage == null) || (paramMessage.getVisibility() != 0));
      localObject = (RelativeLayout.LayoutParams)paramMessage.getLayoutParams();
    } while (localObject == null);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    Resources localResources = super.getResources();
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)localResources.getDimension(2131558725));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)localResources.getDimension(2131558726));
    QLog.d("cmgame_process.ApolloGameActivity", 1, "[handleMessage] MSG_RESET_TOP_MENU reset");
    paramMessage.setLayoutParams((ViewGroup.LayoutParams)localObject);
    return false;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    QLog.i("cmgame_process.ApolloGameActivity", 1, "[onBackEvent]");
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a()))
    {
      QLog.d("cmgame_process.ApolloGameActivity", 1, "[onBackEvent] apollo game is running");
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.f();
      overridePendingTransition(0, 0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131362838: 
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a()) || ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())));
      int i;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (a()))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
          i = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
          if ((i != 0) && (i != 1) && (i != 7)) {
            break label280;
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438203, 0);
          label130:
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438201, 0);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438202, 0);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438205, 0);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new yta(this));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
          break label294;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        label210:
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null)) {
          break label299;
        }
      }
      label280:
      label294:
      label299:
      for (paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);; paramView = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "more_info", i, 0, new String[] { paramView });
        return;
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this, null));
        break;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438204, 0);
        break label130;
        i = 0;
        break label210;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a()))
    {
      QLog.d("cmgame_process.ApolloGameActivity", 1, "game not running, finish");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.d();
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.g();
    QLog.d("cmgame_process.ApolloGameActivity", 1, "notify game");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(20, 1000L);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  @TargetApi(21)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null)) {
      ThreadManager.executeOnSubThread(new ysx(this, paramURLDrawable));
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.requestWindowFeature(1);
    super.getWindow().setFormat(-3);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0) || (paramInt == 8)) {
      super.setRequestedOrientation(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity
 * JD-Core Version:    0.7.0.1
 */