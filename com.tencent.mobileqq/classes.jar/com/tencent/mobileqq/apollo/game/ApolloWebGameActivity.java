package com.tencent.mobileqq.apollo.game;

import Override;
import amsz;
import amtd;
import amte;
import amtf;
import amwn;
import amyo;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anka;
import anvx;
import bdof;
import bhdj;
import bhhn;
import bkys;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Observable;
import java.util.Observer;

public class ApolloWebGameActivity
  extends BaseActivity
  implements Handler.Callback, Observer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private amtf jdField_a_of_type_Amtf;
  private amyo jdField_a_of_type_Amyo;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bkys jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameStartChecker jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "[doOnActivityResult], resultCode:" + paramInt2);
    }
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      AbsStructMsg localAbsStructMsg = bdof.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      bhhn.a(this.app, str, i, localAbsStructMsg, null);
      VipUtils.a(this.app, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(i), 0, new String[] { Integer.toString(j) });
    }
    if ((paramInt2 == -1) && (paramIntent != null) && ((paramInt1 == 14006) || (paramInt1 == 14005)) && (this.jdField_a_of_type_Amyo != null) && (this.jdField_a_of_type_Amyo.a() != null)) {
      this.jdField_a_of_type_Amyo.a().runRenderTask(new ApolloWebGameActivity.3(this, paramInt1, paramInt2, paramIntent));
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      long l = DeviceInfoUtil.getPortraitWidth(true);
      if ((this.jdField_a_of_type_Long != l) && (this.jdField_a_of_type_Long != this.b))
      {
        QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[doOnConfigurationChanged] mLastScreenWidth:", Long.valueOf(l) });
        this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(18, 500L);
      }
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    ApolloGameStateMachine.a().a();
    ApolloGameStateMachine.a().addObserver(this);
    this.mNeedStatusTrans = false;
    super.getWindow().addFlags(67108864);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839466);
    paramBundle = new RelativeLayout.LayoutParams(AIOUtils.dp2px(25.0F, super.getResources()), AIOUtils.dp2px(25.0F, super.getResources()));
    paramBundle.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramBundle = (CmGameStartChecker.StartCheckParam)super.getIntent().getSerializableExtra("extra_startcheckparam");
    if (paramBundle == null)
    {
      QLog.e("cmgame_process.ApolloWebGameActivity", 1, "[doOnCreate] no start param");
      finish();
      a(anvx.a(2131700084));
      return false;
    }
    if (paramBundle.game == null) {
      QLog.i("cmgame_process.ApolloWebGameActivity", 1, "[doOnCreate] game is new, gameId:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
    }
    paramBundle.requestCode = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramBundle;
    int i = ApolloGameActivity.jdField_a_of_type_Int + 1;
    ApolloGameActivity.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Amyo = amwn.a(paramBundle.gameId, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Amyo != null) {
      this.jdField_a_of_type_Amyo.a(paramBundle);
    }
    paramBundle = amwn.a();
    this.jdField_a_of_type_Amtf = new amtf(this, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker = new CmGameStartChecker(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_a_of_type_Amtf);
    amwn.a(1, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnCreate");
    amsz.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    this.jdField_a_of_type_Long = DeviceInfoUtil.getPortraitWidth(true);
    this.b = DeviceInfoUtil.getPortraitHeight();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, new Object[] { "doOnCreate mLastScreenWidth:", Long.valueOf(this.jdField_a_of_type_Long), ",mLastScrrenHeight:", Long.valueOf(this.b) });
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      ApolloGameStateMachine.a().deleteObserver(this);
      if (this.jdField_a_of_type_Amyo != null)
      {
        this.jdField_a_of_type_Amyo.f();
        amwn.b(this.jdField_a_of_type_Amyo.a(), this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
        amwn.a(5, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
      }
      amsz.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnDestroy");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("cmgame_process.ApolloWebGameActivity", 1, localException, new Object[0]);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      amwn.a(3, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Amyo != null) {
      this.jdField_a_of_type_Amyo.e();
    }
    amsz.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      amwn.a(2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Amyo != null) {
      this.jdField_a_of_type_Amyo.d();
    }
    amsz.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
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
        paramMessage = anvx.a(2131700093);
      }
      a(paramMessage);
      return false;
    case 15: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return false;
    case 16: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
      {
        paramMessage = new amtd(this);
        localObject = new amte(this);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 0, anvx.a(2131700090), anvx.a(2131700091), anvx.a(2131700092), anvx.a(2131700088), paramMessage, (DialogInterface.OnClickListener)localObject);
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
        a(anvx.a(2131700089));
        paramMessage = new Intent(this, QQBrowserActivity.class);
        paramMessage.putExtra("url", anka.l);
        startActivity(paramMessage);
        c(this);
        return false;
      }
    }
    d(this);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bundle))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity
 * JD-Core Version:    0.7.0.1
 */