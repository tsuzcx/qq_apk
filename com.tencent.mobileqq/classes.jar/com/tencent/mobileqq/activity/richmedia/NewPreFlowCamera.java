package com.tencent.mobileqq.activity.richmedia;

import alpo;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atdz;
import ayyy;
import ayzw;
import ayzy;
import azbx;
import azby;
import azgd;
import azgk;
import bdee;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import wcx;

public class NewPreFlowCamera
  extends BaseActivity
  implements View.OnClickListener, ayzw, ayzy, azby
{
  private int jdField_a_of_type_Int;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CameraPreviewNew jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew = null;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private wcx jdField_a_of_type_Wcx;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private volatile int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e = 10000;
  private int f;
  
  private void a(String paramString)
  {
    e();
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.1(this, paramString));
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.2(this, paramString));
  }
  
  private void d()
  {
    boolean bool = bdee.g(null);
    VideoEnvironment.a("NewPreFlowCamera", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707925), null);
      ShortVideoResourceManager.b(this.app, this);
      return;
    }
    b(alpo.a(2131707936));
  }
  
  private void e()
  {
    if (a())
    {
      int i = (this.jdField_c_of_type_Int + this.jdField_d_of_type_Int) / 2;
      b(alpo.a(2131707926) + i + "%");
      return;
    }
    b(alpo.a(2131707932) + this.jdField_c_of_type_Int + "%");
  }
  
  private void f()
  {
    if (a()) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Int > 100)) {
        a();
      }
    }
    while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    a();
  }
  
  public void G_()
  {
    b(alpo.a(2131707923));
    VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707930), null);
    ayyy.a(3, -1500);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "startNewFlow=====" + this.jdField_a_of_type_Int + "hasStartAct=" + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    Intent localIntent = getIntent();
    SessionInfo localSessionInfo2 = (SessionInfo)getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    SessionInfo localSessionInfo1 = localSessionInfo2;
    if (localSessionInfo2 == null)
    {
      localSessionInfo1 = new SessionInfo();
      localSessionInfo1.jdField_a_of_type_Int = 0;
    }
    localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo1);
    localIntent.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
    localIntent.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
    QLog.d("NewPreFlowCamera", 2, "ShortVideoUtils.loadShortVideoSo: loadBeginStatus=" + VideoEnvironment.a());
    ShortVideoUtils.a(this.app);
    boolean bool = ShortVideoUtils.a();
    QLog.d("NewPreFlowCamera", 2, "ShortVideoUtils.loadShortVideoSo: avCodecIsOK=" + bool);
    if (bool)
    {
      int i = VideoEnvironment.b();
      QLog.d("NewPreFlowCamera", 2, "is load AVCodec: versionCode=" + i);
      bool = azgk.a(this.app, BaseApplicationImpl.getContext());
      VideoEnvironment.a("NewPreFlowCamera", "startNewFlow startDownloadFilterSo=" + bool, null);
      localIntent.putExtra("edit_video_type", this.e);
      localIntent.putExtra("entrance_type", this.f);
      localIntent.putExtra("flow_camera_use_filter_function", bool);
      localIntent.putExtra("flow_camera_use_3dfilter_function", azgd.a("TKGLRenderer"));
      localIntent.putExtra("flow_camera_video_mode", true);
      localIntent.putExtra("flow_key_from_guide", this.jdField_c_of_type_Boolean);
      localIntent.putExtra("activity_start_time", SystemClock.elapsedRealtime());
      localIntent.setClass(this, NewFlowCameraActivity.class);
      if (this.e == 10002) {
        this.jdField_a_of_type_Wcx.a(localIntent);
      }
      if (this.e == 10004)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewPreFlowCamera", 2, "startActivityForResult[REQUEST_CODE_SHOOT_QUICKLY]=" + localIntent.getComponent().toString());
        }
        startActivityForResult(localIntent, 9010);
      }
    }
    else
    {
      b(alpo.a(2131707921));
      QLog.d("NewPreFlowCamera", 2, "ShortVideoUtils.loadShortVideoSo:AVCodec load error code=" + VideoEnvironment.a());
      return;
    }
    if (this.f == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewPreFlowCamera", 2, "QQStoryApiPlugin.gotoStoryTakeVideoActivity");
      }
      atdz.a(this);
      super.finish();
      return;
    }
    if (localIntent.getBooleanExtra("need_result", false))
    {
      startActivityForResult(localIntent, 12345);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "startActivity:" + localIntent.getComponent().toString());
    }
    startActivity(localIntent);
    super.finish();
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.5(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("NewPreFlowCamera", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707924) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(alpo.a(2131707922));
        ayyy.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707927), null);
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        paramInt1 = azgk.a(VideoEnvironment.a());
        if (paramInt1 == 2)
        {
          ShortVideoResourceManager.b(this.app, localArrayList, this);
          return;
        }
        if (paramInt1 == 1) {
          ShortVideoResourceManager.b(this.app, localArrayList, null);
        }
        this.jdField_b_of_type_Int = 100;
        this.jdField_b_of_type_Boolean = true;
        VideoEnvironment.a("NewPreFlowCamera", "onConfigResult| getFilterSoState != 2", null);
        return;
      }
      VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707931) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(alpo.a(2131707929));
      ayyy.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707919) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(alpo.a(2131707933));
    ayyy.a(1, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707935) + paramInt + "]", null);
        ShortVideoResourceManager.a(alpo.a(2131707937));
        ayyy.a(2, paramInt);
      }
    }
    else if (paramString1.startsWith("new_qq_android_native_short_filter_"))
    {
      if (paramInt == 0) {
        break label239;
      }
      VideoEnvironment.a("NewPreFlowCamera", alpo.a(2131707934) + paramInt + "]", null);
      ShortVideoResourceManager.a(alpo.a(2131707920));
      ayyy.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("NewPreFlowCamera", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      if (!isFinishing())
      {
        VideoEnvironment.a("NewPreFlowCamera", "[AVCodec]isFilterDownloaded=" + this.jdField_b_of_type_Boolean, null);
        f();
        break;
      }
      VideoEnvironment.a("NewPreFlowCamera", "isFinishing= true", null);
      break;
      label239:
      this.jdField_b_of_type_Int = 100;
      this.jdField_b_of_type_Boolean = true;
      if (!isFinishing())
      {
        VideoEnvironment.a("NewPreFlowCamera", "[Filter]isAvCodecDownloaded=" + this.jdField_a_of_type_Boolean, null);
        f();
      }
      else
      {
        VideoEnvironment.a("NewPreFlowCamera", "isFinishing= true", null);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
      a("doUserDownloadResourceAVCodec:");
      VideoEnvironment.a("NewPreFlowCamera", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_")) {
        this.jdField_b_of_type_Int = i;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.4(this, paramBoolean1, paramInt));
  }
  
  public void c()
  {
    this.jdField_d_of_type_Int = 0;
    azbx.a().a(true, this);
    boolean bool = azbx.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new NewPreFlowCamera.3(this));
      return;
    }
    this.jdField_d_of_type_Int = 101;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9010)
    {
      setResult(-1, paramIntent);
      finish();
      return;
    }
    if (paramInt1 == 12345)
    {
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_Int = 0;
    super.doOnCreate(paramBundle);
    if (this.app == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "NewPreFlowCamera-> app == null");
      finish();
      return false;
    }
    this.jdField_a_of_type_Wcx = new wcx(this.app);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("flow_key_from_guide", false);
    this.e = getIntent().getIntExtra("edit_video_type", 10000);
    this.f = getIntent().getIntExtra("entrance_type", 99);
    setContentView(2131560958);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375981));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366503));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131364906));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167192), 100, getResources().getColor(2131165332));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366597));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!VideoEnvironment.c(this.app))
    {
      QQToast.a(VideoEnvironment.a(), alpo.a(2131707928), 1).a();
      super.finish();
      return true;
    }
    boolean bool2;
    if (a())
    {
      c();
      bool2 = VideoEnvironment.e(this.app);
      if (azgk.a(this) == 2) {
        break label358;
      }
    }
    label358:
    for (boolean bool1 = true;; bool1 = false)
    {
      VideoEnvironment.a("NewPreFlowCamera", "checkAVCodecLoadIsOK loaded=" + bool2 + ",exists=" + bool1, null);
      if ((bool2) && (bool1)) {
        break label363;
      }
      ayyy.a(2);
      d();
      return true;
      this.jdField_d_of_type_Int = 101;
      break;
    }
    label363:
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      ShortVideoResourceManager.a(this.app, this);
      ShortVideoResourceManager.b(this.app, this);
    }
    azbx.a().a(false, this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366495);
    if (localView != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew = new CameraPreviewNew(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew.setCamera(this.jdField_c_of_type_Boolean);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew.setId(2131366495);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew, 0, localLayoutParams);
  }
  
  public void finish()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera
 * JD-Core Version:    0.7.0.1
 */