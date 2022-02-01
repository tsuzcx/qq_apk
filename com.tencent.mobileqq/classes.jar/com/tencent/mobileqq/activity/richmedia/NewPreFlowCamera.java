package com.tencent.mobileqq.activity.richmedia;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.jsp.QQStoryApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.mobileqq.shortvideo.util.NativeSoLoader;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;

public class NewPreFlowCamera
  extends BaseActivity
  implements View.OnClickListener, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, GestureMgr.GestureStatusListener, AEResManager.AEDownloadCallBack
{
  private int jdField_a_of_type_Int = 0;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQStoryTakeVideoActivityLauncher jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoActivityLauncher;
  CameraPreviewNew jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew = null;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private volatile int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = 10000;
  private int f;
  
  private void a(String paramString)
  {
    d();
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
  
  private void c()
  {
    boolean bool = NetworkUtil.g(null);
    VideoEnvironment.LogDownLoad("NewPreFlowCamera", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("NewPreFlowCamera", HardCodeUtil.a(2131707528), null);
      ShortVideoResourceManager.b(this.app, this);
      return;
    }
    b(HardCodeUtil.a(2131707539));
  }
  
  private void d()
  {
    if (a())
    {
      int i = (this.jdField_c_of_type_Int + this.jdField_d_of_type_Int) / 2;
      b(HardCodeUtil.a(2131707529) + i + "%");
      return;
    }
    b(HardCodeUtil.a(2131707535) + this.jdField_c_of_type_Int + "%");
  }
  
  private void e()
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
    localIntent.putExtra("sv_config", ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SV658Cfg.name(), null));
    VideoEnvironment.loadAVCodecSo();
    boolean bool = ShortVideoUtils.isVideoSoLibLoaded();
    QLog.d("NewPreFlowCamera", 2, "ShortVideoUtils.loadShortVideoSo: avCodecIsOK=" + bool);
    if (bool)
    {
      int i = VideoEnvironment.getAVCodecVersion();
      QLog.d("NewPreFlowCamera", 2, "is load AVCodec: versionCode=" + i);
      bool = PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
      VideoEnvironment.LogDownLoad("NewPreFlowCamera", "startNewFlow startDownloadFilterSo=" + bool, null);
      localIntent.putExtra("edit_video_type", this.e);
      localIntent.putExtra("entrance_type", this.f);
      localIntent.putExtra("flow_camera_use_filter_function", bool);
      localIntent.putExtra("flow_camera_use_3dfilter_function", NativeSoLoader.a("TKGLRenderer"));
      localIntent.putExtra("flow_camera_video_mode", true);
      localIntent.putExtra("flow_key_from_guide", this.jdField_c_of_type_Boolean);
      localIntent.putExtra("activity_start_time", SystemClock.elapsedRealtime());
      localIntent.setClass(this, NewFlowCameraActivity.class);
      if (this.e == 10002) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoActivityLauncher.a(localIntent);
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
      b(HardCodeUtil.a(2131707524));
      return;
    }
    if (this.f == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewPreFlowCamera", 2, "QQStoryApiPlugin.gotoStoryTakeVideoActivity");
      }
      QQStoryApiPlugin.a(this);
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.4(this, paramBoolean1, paramInt));
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = 0;
    GestureMgr.a().a(true, this);
    boolean bool = GestureMgr.a().a();
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
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoActivityLauncher = new QQStoryTakeVideoActivityLauncher(this.app);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("flow_key_from_guide", false);
    this.e = getIntent().getIntExtra("edit_video_type", 10000);
    this.f = getIntent().getIntExtra("entrance_type", 99);
    setContentView(2131561256);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377356));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367159));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131365444));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167374), 100, getResources().getColor(2131165381));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367253));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!VideoEnvironment.supportShortVideoRecordAndPlay())
    {
      QQToast.a(VideoEnvironment.getContext(), HardCodeUtil.a(2131707531), 1).a();
      super.finish();
      return true;
    }
    if (a())
    {
      b();
      boolean bool1 = VideoEnvironment.checkAndLoadAVCodec();
      boolean bool2 = AEResUtil.b();
      VideoEnvironment.LogDownLoad("NewPreFlowCamera", "checkAVCodecLoadIsOK loaded=" + bool1 + ",exists=" + bool2, null);
      if ((bool1) && (bool2)) {
        break label344;
      }
      ShortVideoErrorReport.a(2);
      c();
    }
    for (;;)
    {
      return true;
      this.jdField_d_of_type_Int = 101;
      break;
      label344:
      a();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      ShortVideoResourceManager.b(this.app, this);
      AEResManager.a().a(this);
    }
    GestureMgr.a().a(false, this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367151);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew.setId(2131367151);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew, 0, localLayoutParams);
  }
  
  public void finish()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    super.finish();
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramAEResInfo != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString.equals(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString)))
    {
      if (paramInt != 0)
      {
        AEQLog.d("NewPreFlowCamera", "[onAEDownloadFinish] errorType :" + paramInt);
        VideoEnvironment.LogDownLoad("NewPreFlowCamera", HardCodeUtil.a(2131707537) + paramInt + "]", null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131707523));
        ShortVideoErrorReport.a(2, paramInt);
      }
    }
    else {
      return;
    }
    AEQLog.b("NewPreFlowCamera", "[onAEDownloadFinish] mFilterState 100");
    this.jdField_b_of_type_Int = 100;
    this.jdField_b_of_type_Boolean = true;
    if (!isFinishing())
    {
      AEQLog.b("NewPreFlowCamera", "[onAEDownloadFinish] isAvCodecDownloaded=" + this.jdField_a_of_type_Boolean);
      VideoEnvironment.LogDownLoad("NewPreFlowCamera", "[Filter]isAvCodecDownloaded=" + this.jdField_a_of_type_Boolean, null);
      e();
      return;
    }
    AEQLog.b("NewPreFlowCamera", "[onAEDownloadFinish] isFinishing= tru");
    VideoEnvironment.LogDownLoad("NewPreFlowCamera", "isFinishing= true", null);
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if ((paramAEResInfo != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString.equals(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = i;
    }
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    a("doUserDownloadResourceAVCodec:");
    StringBuilder localStringBuilder = new StringBuilder().append("name=");
    if (paramAEResInfo != null) {}
    for (paramAEResInfo = paramAEResInfo.jdField_b_of_type_JavaLangString;; paramAEResInfo = null)
    {
      VideoEnvironment.LogDownLoad("NewPreFlowCamera", paramAEResInfo + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
  
  public void onConfigResult(int paramInt1, int paramInt2) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label110;
      }
      VideoEnvironment.LogDownLoad("NewPreFlowCamera", HardCodeUtil.a(2131707538) + paramInt + "]", null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131707540));
      ShortVideoErrorReport.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("NewPreFlowCamera", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label110:
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      if (!isFinishing())
      {
        VideoEnvironment.LogDownLoad("NewPreFlowCamera", "[AVCodec]isFilterDownloaded=" + this.jdField_b_of_type_Boolean, null);
        e();
      }
      else
      {
        VideoEnvironment.LogDownLoad("NewPreFlowCamera", "isFinishing= true", null);
      }
    }
  }
  
  public void onNetWorkNone()
  {
    b(HardCodeUtil.a(2131707526));
    VideoEnvironment.LogDownLoad("NewPreFlowCamera", HardCodeUtil.a(2131707533), null);
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    a("doUserDownloadResourceAVCodec:");
    VideoEnvironment.LogDownLoad("NewPreFlowCamera", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera
 * JD-Core Version:    0.7.0.1
 */