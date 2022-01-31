package com.tencent.mobileqq.apollo.game;

import aepi;
import akue;
import akui;
import akuj;
import akuk;
import akwd;
import akyg;
import aliu;
import alud;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
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
import azvd;
import bdgk;
import bdgm;
import bdjz;
import bdna;
import bhtd;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class ApolloWebGameActivity
  extends BaseActivity
  implements Handler.Callback, Observer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private akuk jdField_a_of_type_Akuk;
  private akyg jdField_a_of_type_Akyg;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bdjz jdField_a_of_type_Bdjz;
  private bhtd jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameStartChecker jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker;
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "[doOnActivityResult], resultCode:" + paramInt2);
    }
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      AbsStructMsg localAbsStructMsg = azvd.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      bdna.a(this.app, str, i, localAbsStructMsg, null);
      VipUtils.a(this.app, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(i), 0, new String[] { Integer.toString(j) });
    }
    if ((paramInt2 == -1) && (paramIntent != null) && ((paramInt1 == 14006) || (paramInt1 == 14005)) && (this.jdField_a_of_type_Akyg != null) && (this.jdField_a_of_type_Akyg.a() != null)) {
      this.jdField_a_of_type_Akyg.a().runRenderTask(new ApolloWebGameActivity.3(this, paramInt1, paramInt2, paramIntent));
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      long l = bdgk.a(true);
      if ((this.jdField_a_of_type_Long != l) && (this.jdField_a_of_type_Long != this.b))
      {
        QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[doOnConfigurationChanged] mLastScreenWidth:", Long.valueOf(l) });
        this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(18, 500L);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839225);
    paramBundle = new RelativeLayout.LayoutParams(aepi.a(25.0F, super.getResources()), aepi.a(25.0F, super.getResources()));
    paramBundle.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramBundle = (CmGameStartChecker.StartCheckParam)super.getIntent().getSerializableExtra("extra_startcheckparam");
    if (paramBundle == null)
    {
      QLog.e("cmgame_process.ApolloWebGameActivity", 1, "[doOnCreate] no start param");
      finish();
      a(alud.a(2131700966));
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
    this.jdField_a_of_type_Akyg = akwd.a(paramBundle.gameId, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Akyg != null) {
      this.jdField_a_of_type_Akyg.a(paramBundle);
    }
    paramBundle = akwd.a();
    this.jdField_a_of_type_Akuk = new akuk(this, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker = new CmGameStartChecker(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_a_of_type_Akuk);
    akwd.a(1, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnCreate");
    akue.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    this.jdField_a_of_type_Long = bdgk.a(true);
    this.b = bdgk.j();
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
      if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
        this.jdField_a_of_type_Bdjz.dismiss();
      }
      this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      ApolloGameStateMachine.a().deleteObserver(this);
      if (this.jdField_a_of_type_Akyg != null)
      {
        this.jdField_a_of_type_Akyg.f();
        akwd.b(this.jdField_a_of_type_Akyg.a(), this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
        akwd.a(5, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
      }
      akue.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
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
      akwd.a(3, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Akyg != null) {
      this.jdField_a_of_type_Akyg.e();
    }
    akue.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      akwd.a(2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Akyg != null) {
      this.jdField_a_of_type_Akyg.d();
    }
    akue.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
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
        paramMessage = alud.a(2131700975);
      }
      a(paramMessage);
      return false;
    case 15: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return false;
    case 16: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Bdjz == null)
      {
        paramMessage = new akui(this);
        localObject = new akuj(this);
      }
      try
      {
        this.jdField_a_of_type_Bdjz = bdgm.a(this, 0, alud.a(2131700972), alud.a(2131700973), alud.a(2131700974), alud.a(2131700970), paramMessage, (DialogInterface.OnClickListener)localObject);
        if (this.jdField_a_of_type_Bdjz != null)
        {
          this.jdField_a_of_type_Bdjz.show();
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
        a(alud.a(2131700971));
        paramMessage = new Intent(this, QQBrowserActivity.class);
        paramMessage.putExtra("url", aliu.Y);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity
 * JD-Core Version:    0.7.0.1
 */