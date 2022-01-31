package com.tencent.mobileqq.apollo.game;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Observable;
import java.util.Observer;
import ypt;
import ypu;
import ypv;
import ypw;

public class ApolloWebGameActivity
  extends BaseActivity
  implements Handler.Callback, Observer
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameStartChecker jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker;
  private CmGameLauncher jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private ypw jdField_a_of_type_Ypw;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.a(this, paramString, 0).a();
    }
    super.finish();
  }
  
  public void a(ApolloSurfaceView paramApolloSurfaceView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(10);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramApolloSurfaceView, localLayoutParams);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "setGameView ApolloSurfaceView:" + paramApolloSurfaceView);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "[doOnActivityResult], resultCode:" + paramInt2);
    }
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      ShareMsgHelper.a(this.app, str, i, localAbsStructMsg, null);
      VipUtils.a(this.app, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(i), 0, new String[] { Integer.toString(j) });
    }
    if ((paramInt2 == -1) && (paramIntent != null) && ((paramInt1 == 14006) || (paramInt1 == 14005)) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a().queueEvent(new ypv(this, paramInt1, paramInt2, paramIntent));
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ApolloGameStateMachine.a().a();
    ApolloGameStateMachine.a().addObserver(this);
    this.mNeedStatusTrans = false;
    super.getWindow().addFlags(67108864);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838596);
    paramBundle = new RelativeLayout.LayoutParams(AIOUtils.a(25.0F, super.getResources()), AIOUtils.a(25.0F, super.getResources()));
    paramBundle.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramBundle = (CmGameStartChecker.StartCheckParam)super.getIntent().getSerializableExtra("extra_startcheckparam");
    if ((paramBundle == null) || (paramBundle.game == null))
    {
      QLog.e("cmgame_process.ApolloWebGameActivity", 1, "[doOnCreate] no start param");
      finish();
      a("游戏启动错误，请稍后重试");
      return false;
    }
    paramBundle.requestCode = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher = CmGameUtil.a(paramBundle.game.gameId);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a(paramBundle);
    }
    paramBundle = CmGameUtil.a();
    this.jdField_a_of_type_Ypw = new ypw(this, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker = new CmGameStartChecker(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_a_of_type_Ypw);
    CmGameUtil.a(1, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnCreate");
    ApolloGameTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = true;
    ApolloGameStateMachine.a().deleteObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.d();
      CmGameUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null)) {
      CmGameUtil.a(4, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    }
    ApolloGameTimeReporter.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnDestroy");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null)) {
      CmGameUtil.a(3, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.c();
    }
    ApolloGameTimeReporter.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null)) {
      CmGameUtil.a(2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.b();
    }
    ApolloGameTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getWindow().getDecorView().setSystemUiVisibility(5894);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 17: 
      localObject = (String)paramMessage.obj;
      paramMessage = (Message)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramMessage = "启动失败，请稍后重试哦~";
      }
      a(paramMessage);
      return false;
    case 15: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      paramMessage = new ypt(this);
      localObject = new ypu(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, "次数不够", "游戏次数不够了", "取消", "查看详情", paramMessage, (DialogInterface.OnClickListener)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return false;
      }
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
        QLog.e("cmgame_process.ApolloWebGameActivity", 2, paramMessage.getMessage());
      }
      a("游戏次数不够了");
      paramMessage = new Intent(this, QQBrowserActivity.class);
      paramMessage.putExtra("url", ApolloConstant.O);
      startActivity(paramMessage);
      c(this);
    }
    return false;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bundle))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity
 * JD-Core Version:    0.7.0.1
 */