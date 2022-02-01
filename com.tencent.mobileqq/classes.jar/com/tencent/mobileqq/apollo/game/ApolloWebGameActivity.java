package com.tencent.mobileqq.apollo.game;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Observable;
import java.util.Observer;

public class ApolloWebGameActivity
  extends BaseActivity
  implements Handler.Callback, Observer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ApolloWebGameActivity.CmGameStartCheckListener jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebGameActivity$CmGameStartCheckListener;
  private CmGameStartChecker jdField_a_of_type_ComTencentMobileqqApolloGameCmGameStartChecker;
  private CmGameLauncher jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher;
  private StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
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
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramApolloSurfaceView, (ViewGroup.LayoutParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setGameView ApolloSurfaceViewImpl:");
    ((StringBuilder)localObject).append(paramApolloSurfaceView);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, ((StringBuilder)localObject).toString());
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[doOnActivityResult], resultCode:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      localObject = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localObject == null) {
        return;
      }
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      ShareMsgHelper.a(this.app, str, i, (AbsStructMsg)localObject, null);
      VipUtils.a(this.app, "cmshow", "Apollo", "share_url_succeed", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(i), 0, new String[] { Integer.toString(j) });
    }
    if ((paramInt2 == -1) && (paramIntent != null) && ((paramInt1 == 14006) || (paramInt1 == 14005)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher;
      if ((localObject != null) && (((CmGameLauncher)localObject).a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher.a().runRenderTask(new ApolloWebGameActivity.3(this, paramInt1, paramInt2, paramIntent));
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      long l1 = DeviceInfoUtil.a(true);
      long l2 = this.jdField_a_of_type_Long;
      if ((l2 != l1) && (l2 != this.b))
      {
        QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[doOnConfigurationChanged] mLastScreenWidth:", Long.valueOf(l1) });
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 500L);
      }
      this.jdField_a_of_type_Long = l1;
    }
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839401);
    paramBundle = new RelativeLayout.LayoutParams(AIOUtils.b(25.0F, super.getResources()), AIOUtils.b(25.0F, super.getResources()));
    paramBundle.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramBundle = (StartCheckParam)super.getIntent().getSerializableExtra("extra_startcheckparam");
    if (paramBundle == null)
    {
      QLog.e("cmgame_process.ApolloWebGameActivity", 1, "[doOnCreate] no start param");
      finish();
      a(HardCodeUtil.a(2131700803));
      return false;
    }
    if (paramBundle.game == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[doOnCreate] game is new, gameId:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId);
      QLog.i("cmgame_process.ApolloWebGameActivity", 1, ((StringBuilder)localObject).toString());
    }
    paramBundle.requestCode = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher = CmGameUtil.a(paramBundle.gameId, this.jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher;
    if (localObject != null) {
      ((CmGameLauncher)localObject).a(paramBundle);
    }
    paramBundle = CmGameUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebGameActivity$CmGameStartCheckListener = new ApolloWebGameActivity.CmGameStartCheckListener(this, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameStartChecker = new CmGameStartChecker(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam, this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebGameActivity$CmGameStartCheckListener);
    CmGameUtil.a(1, this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId, this.jdField_a_of_type_Int);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnCreate");
    ApolloGameTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
    this.jdField_a_of_type_Long = DeviceInfoUtil.a(true);
    this.b = DeviceInfoUtil.j();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, new Object[] { "doOnCreate mLastScreenWidth:", Long.valueOf(this.jdField_a_of_type_Long), ",mLastScrrenHeight:", Long.valueOf(this.b) });
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.ApolloWebGameActivity", 1, localException, new Object[0]);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = true;
    ApolloGameStateMachine.a().deleteObserver(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher;
    if (localObject != null)
    {
      ((CmGameLauncher)localObject).d();
      CmGameUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher.a(), this.jdField_a_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    if (localObject != null) {
      CmGameUtil.a(5, ((StartCheckParam)localObject).gameId, this.jdField_a_of_type_Int);
    }
    ApolloGameTimeReporter.b(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnDestroy");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    if (localObject != null) {
      CmGameUtil.a(3, ((StartCheckParam)localObject).gameId, this.jdField_a_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher;
    if (localObject != null) {
      ((CmGameLauncher)localObject).c();
    }
    ApolloGameTimeReporter.b(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    if (localObject != null) {
      CmGameUtil.a(2, ((StartCheckParam)localObject).gameId, this.jdField_a_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLauncher;
    if (localObject != null) {
      ((CmGameLauncher)localObject).b();
    }
    ApolloGameTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 19)) {
      return;
    }
    ApolloGameTool.a(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      break;
    case 18: 
      d(this);
      break;
    case 17: 
      localObject = (String)paramMessage.obj;
      paramMessage = (Message)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramMessage = HardCodeUtil.a(2131700812);
      }
      a(paramMessage);
      break;
    case 16: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
      {
        paramMessage = new ApolloWebGameActivity.1(this);
        localObject = new ApolloWebGameActivity.2(this);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, HardCodeUtil.a(2131700809), HardCodeUtil.a(2131700810), HardCodeUtil.a(2131700811), HardCodeUtil.a(2131700807), paramMessage, (DialogInterface.OnClickListener)localObject);
        }
        catch (Throwable paramMessage)
        {
          paramMessage.printStackTrace();
          QLog.e("cmgame_process.ApolloWebGameActivity", 2, paramMessage.getMessage());
        }
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (paramMessage != null)
      {
        paramMessage.show();
      }
      else
      {
        a(HardCodeUtil.a(2131700808));
        paramMessage = new Intent(this, QQBrowserActivity.class);
        paramMessage.putExtra("url", ApolloConstant.q);
        startActivity(paramMessage);
        c(this);
      }
      break;
    case 15: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity
 * JD-Core Version:    0.7.0.1
 */