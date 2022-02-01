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
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class CmIslandActivity
  extends BaseActivity
  implements Handler.Callback
{
  private RelativeLayout a;
  private QQCustomDialog b;
  private ImageView c;
  private WeakReferenceHandler d = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean e;
  private CmGameStartChecker f;
  private StartCheckParam g;
  private CmIslandActivity.CmGameStartCheckListener h;
  private CmGameLauncher i;
  private int j;
  private long k;
  private long l;
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.makeText(this, paramString, 0).show();
    }
    super.finish();
  }
  
  public void a(ApolloSurfaceView paramApolloSurfaceView)
  {
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    this.a.addView(paramApolloSurfaceView, (ViewGroup.LayoutParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setGameView ApolloSurfaceViewImpl:");
    ((StringBuilder)localObject).append(paramApolloSurfaceView);
    QLog.d("cmgame_process.CmIslandActivity", 2, ((StringBuilder)localObject).toString());
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      long l1 = DeviceInfoUtil.a(true);
      long l2 = this.k;
      if ((l2 != l1) && (l2 != this.l))
      {
        QLog.d("cmgame_process.CmIslandActivity", 1, new Object[] { "[doOnConfigurationChanged] mLastScreenWidth:", Long.valueOf(l1) });
        this.d.sendEmptyMessageDelayed(18, 500L);
      }
      this.k = l1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ApolloGameStateMachine.a().c();
    this.mNeedStatusTrans = false;
    super.getWindow().addFlags(67108864);
    super.doOnCreate(paramBundle);
    this.a = new RelativeLayout(this);
    this.c = new ImageView(this);
    this.c.setImageResource(2130839585);
    paramBundle = new RelativeLayout.LayoutParams(ViewUtils.dip2px(25.0F), ViewUtils.dip2px(25.0F));
    paramBundle.addRule(13, -1);
    this.a.addView(this.c, paramBundle);
    setContentView(this.a);
    paramBundle = (StartCheckParam)super.getIntent().getSerializableExtra("extra_startcheckparam");
    if (paramBundle == null)
    {
      QLog.e("cmgame_process.CmIslandActivity", 1, "[doOnCreate] no start param");
      finish();
      a(HardCodeUtil.a(2131898829));
      return false;
    }
    if (paramBundle.game == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[doOnCreate] game is new, gameId:");
      ((StringBuilder)localObject).append(this.g.gameId);
      QLog.i("cmgame_process.CmIslandActivity", 1, ((StringBuilder)localObject).toString());
    }
    paramBundle.requestCode = System.currentTimeMillis();
    this.g = paramBundle;
    this.i = CmGameUtil.a(paramBundle.gameId, this.j);
    Object localObject = this.i;
    if (localObject != null) {
      ((CmGameLauncher)localObject).a(paramBundle);
    }
    paramBundle = CmGameUtil.b();
    this.h = new CmIslandActivity.CmGameStartCheckListener(this, paramBundle);
    this.f = new CmGameStartChecker(paramBundle);
    this.f.a(this.g, this.h);
    CmGameUtil.a(1, this.g.gameId, this.j);
    QLog.d("cmgame_process.CmIslandActivity", 2, "doOnCreate");
    ApolloGameTimeReporter.a(this.g);
    this.k = DeviceInfoUtil.a(true);
    this.l = DeviceInfoUtil.E();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmIslandActivity", 2, new Object[] { "doOnCreate mLastScreenWidth:", Long.valueOf(this.k), ",mLastScrrenHeight:", Long.valueOf(this.l) });
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.b != null) && (this.b.isShowing())) {
        this.b.dismiss();
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmIslandActivity", 1, localException, new Object[0]);
    }
    this.d.removeCallbacksAndMessages(null);
    this.e = true;
    Object localObject = this.i;
    if (localObject != null)
    {
      ((CmGameLauncher)localObject).k();
      CmGameUtil.b(this.i.g(), this.j);
    }
    localObject = this.g;
    if (localObject != null) {
      CmGameUtil.a(5, ((StartCheckParam)localObject).gameId, this.j);
    }
    ApolloGameTimeReporter.b(this.g);
    QLog.d("cmgame_process.CmIslandActivity", 2, "doOnDestroy");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = this.g;
    if (localObject != null) {
      CmGameUtil.a(3, ((StartCheckParam)localObject).gameId, this.j);
    }
    localObject = this.i;
    if (localObject != null) {
      ((CmGameLauncher)localObject).j();
    }
    ApolloGameTimeReporter.b(this.g);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject = this.g;
    if (localObject != null) {
      CmGameUtil.a(2, ((StartCheckParam)localObject).gameId, this.j);
    }
    localObject = this.i;
    if (localObject != null) {
      ((CmGameLauncher)localObject).i();
    }
    ApolloGameTimeReporter.a(this.g);
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
      i(this);
      break;
    case 17: 
      localObject = (String)paramMessage.obj;
      paramMessage = (Message)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramMessage = HardCodeUtil.a(2131898837);
      }
      a(paramMessage);
      break;
    case 16: 
      this.c.setVisibility(8);
      if (this.b == null)
      {
        paramMessage = new CmIslandActivity.1(this);
        localObject = new CmIslandActivity.2(this);
        try
        {
          this.b = DialogUtil.a(this, 0, HardCodeUtil.a(2131898835), HardCodeUtil.a(2131898836), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131898833), paramMessage, (DialogInterface.OnClickListener)localObject);
        }
        catch (Throwable paramMessage)
        {
          paramMessage.printStackTrace();
          QLog.e("cmgame_process.CmIslandActivity", 2, paramMessage.getMessage());
        }
      }
      paramMessage = this.b;
      if (paramMessage != null)
      {
        paramMessage.show();
      }
      else
      {
        a(HardCodeUtil.a(2131898834));
        paramMessage = new Intent(this, QQBrowserActivity.class);
        paramMessage.putExtra("url", ApolloConstant.y);
        startActivity(paramMessage);
        h(this);
      }
      break;
    case 15: 
      this.c.setVisibility(8);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmIslandActivity
 * JD-Core Version:    0.7.0.1
 */