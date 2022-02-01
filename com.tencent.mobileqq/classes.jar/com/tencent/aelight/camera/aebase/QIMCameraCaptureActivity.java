package com.tencent.aelight.camera.aebase;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.aelight.camera.ae.CameraCompatibleList;
import com.tencent.aelight.camera.ae.IQIMCameraLifeCallback;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.aioeditor.AIOShortVideoUtil;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import com.tencent.util.LiuHaiUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends BaseActivity2
  implements ICameraEntrance, IQIMCameraContainer
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private IQIMCameraLifeCallback jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private int d = 0;
  
  public static Intent a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMCameraCaptureActivity", 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if ((!AECameraEntry.l.a(i)) && (!AECameraEntry.k.a(i)))
    {
      if ((AECameraEntry.H.a(i)) || (AECameraEntry.I.a(i)))
      {
        AEQLog.a("QIMCameraCaptureActivity", "set special launch flags case2");
        paramContext.setFlags(402653184);
      }
    }
    else
    {
      AEQLog.a("QIMCameraCaptureActivity", "set special launch flags case1");
      paramContext.setFlags(402653184);
    }
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("need_show_banner", false);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (AIOShortVideoUtil.a != 0L)
    {
      AIOShortVideoUtil.c = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(AIOShortVideoUtil.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", AIOShortVideoUtil.a);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", AIOShortVideoUtil.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", AIOShortVideoUtil.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = AECaptureContext.a();
    if (localObject != null) {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = "none";
    }
    paramBundle.putString("intent_key_uid_for_report", (String)localObject);
    localObject = a(paramActivity, paramBundle);
    if (AECameraLauncher.a(paramBundle)) {
      ((Intent)localObject).addFlags(603979776);
    }
    paramActivity.startActivityForResult((Intent)localObject, paramInt);
    AELaunchRecorder.a().a("startActivityForResult");
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = AECaptureContext.a();
    if (localObject != null) {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = "none";
    }
    paramBundle.putString("intent_key_uid_for_report", (String)localObject);
    paramContext.startActivity(a(paramContext, paramBundle));
  }
  
  private void c()
  {
    if (!AECameraEntryManager.k(getIntent())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(a());
    VideoReport.setPageId(this, "small_world_base");
    VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("QIMCameraCaptureActivity"));
    QLog.i("QIMCameraCaptureActivity", 1, "reportDaTongRegister  subPage: QIMCameraCaptureActivity");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int i = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decreaseFrom key: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" value: ");
      localStringBuilder.append(i);
      AEQLog.a("QIMCameraCaptureActivity", localStringBuilder.toString());
      if (i <= 1)
      {
        jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
        return;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, i - 1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decreaseFrom2 key: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    AEQLog.a("QIMCameraCaptureActivity", localStringBuilder.toString());
    jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
  }
  
  private boolean d()
  {
    if (!AECameraEntryManager.k(getIntent()))
    {
      if (AECameraEntryManager.a(getIntent()) == AECameraEntry.I.a()) {
        return false;
      }
      if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
      {
        int j = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
        localObject = jdField_a_of_type_AndroidUtilSparseIntArray;
        int i = this.jdField_a_of_type_Int;
        j += 1;
        ((SparseIntArray)localObject).put(i, j);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isRepeatLaunch key: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" value: ");
        ((StringBuilder)localObject).append(j);
        AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
        return true;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, 1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isRepeatLaunch2 key: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" value: ");
      ((StringBuilder)localObject).append(1);
      AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public Activity a()
  {
    return this;
  }
  
  public void a()
  {
    super.onBackPressed();
  }
  
  public void a(int paramInt)
  {
    finish();
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void finish()
  {
    super.finish();
    IQIMCameraLifeCallback localIQIMCameraLifeCallback = this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback;
    if (localIQIMCameraLifeCallback != null) {
      localIQIMCameraLifeCallback.K();
    }
  }
  
  protected boolean isLatecyWaitRuntime()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.i();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 51);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (CameraCompatibleList.e())
    {
      DisplayMetrics localDisplayMetrics = CaptureUtil.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_b_of_type_Int != localDisplayMetrics.widthPixels) || (this.d != localDisplayMetrics.heightPixels)))
      {
        this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
        this.d = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.a(this.jdField_b_of_type_Int, this.d);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onConfigurationChanged width:");
        localStringBuilder.append(localDisplayMetrics.widthPixels);
        localStringBuilder.append(", hight:");
        localStringBuilder.append(localDisplayMetrics.heightPixels);
        QLog.i("QIMCameraCaptureActivity", 2, localStringBuilder.toString());
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    setVolumeControlStream(3);
    if (!isLatecyWaitRuntime()) {
      AECaptureContext.a();
    }
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onCreate] from startActivity to onCreate, time cost = ");
    ((StringBuilder)localObject).append(l1 - l2);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Int = AECameraEntryManager.a(getIntent());
    AELaunchRecorder.a().d();
    AELaunchRecorder.a().a("mainProcessLaunch", l2);
    AELaunchRecorder.a().a("activityOnCreateBegin", l1);
    AELaunchRecorder.a().a(l2);
    com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncControl.c = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (CameraCompatibleList.e()) {
      LiuHaiUtils.c(this);
    }
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.c()) {
      LiuHaiUtils.b(this);
    }
    localObject = CaptureUtil.a(this);
    if (localObject != null)
    {
      this.jdField_b_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.d = ((DisplayMetrics)localObject).heightPixels;
    }
    this.i = true;
    this.j = false;
    super.onCreate(paramBundle);
    if (d())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("repeat launch from: ");
      paramBundle.append(this.jdField_a_of_type_Int);
      AEQLog.d("QIMCameraCaptureActivity", paramBundle.toString());
      finish();
      return;
    }
    a().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.OPEN_CAMERA"), "com.tencent.msg.permission.pushnotify");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate: 参数接收：");
    ((StringBuilder)localObject).append(getIntent().getExtras());
    AEQLog.b("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    int j = getIntent().getIntExtra("edit_video_type", 10002);
    int i = j;
    if (getIntent().getExtras() != null)
    {
      i = j;
      if (getIntent().getExtras().containsKey("VIDEO_STORY_FROM_TYPE"))
      {
        int k = getIntent().getExtras().getInt("VIDEO_STORY_FROM_TYPE");
        i = j;
        if (AECameraEntry.e.a(k)) {
          i = 10024;
        }
      }
    }
    AELaunchRecorder.a().a("buildCaptureUnit-begin");
    AEThemeUtil.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback = QIMEffectCameraCaptureUnitBuilder.a(i, this, this);
    AELaunchRecorder.a().a("buildCaptureUnit-end");
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.a(paramBundle);
    AELaunchRecorder.a().a("unitOnCreateView-begin");
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.a();
    AELaunchRecorder.a().a("unitOnCreateView-end");
    setContentView(this.jdField_a_of_type_AndroidViewView);
    if ((!c()) && (!AECommonUtil.a(a())))
    {
      ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
      c();
      AELaunchRecorder.a().a("activityOnCreateEnd");
      paramBundle = new StringBuilder();
      paramBundle.append("[onCreate] + END, time cost = ");
      paramBundle.append(System.currentTimeMillis() - l1);
      AEQLog.b("QIMCameraCaptureActivity", paramBundle.toString());
      return;
    }
    QQToast.a(this, HardCodeUtil.a(2131709723), 0).a();
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy from: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    d();
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback;
    if (localObject != null)
    {
      ((IQIMCameraLifeCallback)localObject).g();
      MemoryClearManager.a().j = 0;
      localObject = (QIMPtvTemplateManager)QIMManager.a(3);
      QIMPtvTemplateManager.jdField_a_of_type_Int = 0;
      ((QIMCaptureVarManager)QIMManager.a(13)).d(0);
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 51);
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
    }
    AELaunchRecorder.a().a(true);
    AELaunchRecorder.a().e();
    a().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.CLOSE_CAMERA"), "com.tencent.msg.permission.pushnotify");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback;
    if (localObject != null) {
      ((IQIMCameraLifeCallback)localObject).f();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPause from: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    if (a().isFinishing()) {
      d();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.jdField_b_of_type_Boolean) {
      AELaunchRecorder.a().a("activityOnResumeBegin");
    }
    super.onResume();
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.e();
    ((QIMCaptureVarManager)QIMManager.a(13)).c(0);
    if ((Build.VERSION.SDK_INT >= 29) && (!AECameraEntryManager.g(this.jdField_a_of_type_Int))) {
      NavigationBarUtil.a(getWindow());
    }
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 51);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    if (!this.jdField_b_of_type_Boolean) {
      AELaunchRecorder.a().a("activityOnResumeEnd");
    }
    this.jdField_b_of_type_Boolean = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onResume] + END, time cost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AEQLog.b("QIMCameraCaptureActivity", localStringBuilder.toString());
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.b(paramBundle);
  }
  
  public void onStart()
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.c) {
      AELaunchRecorder.a().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStart] waitAppRuntime, cost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AEQLog.a("QIMCameraCaptureActivity", localStringBuilder.toString());
    super.onStart();
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.I();
    if (!this.c) {
      AELaunchRecorder.a().a("activityOnStartEnd");
    }
    this.c = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStart] + END, time cost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AEQLog.b("QIMCameraCaptureActivity", localStringBuilder.toString());
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onStop from: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback;
    if (localObject != null) {
      ((IQIMCameraLifeCallback)localObject).J();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_ComTencentAelightCameraAeIQIMCameraLifeCallback.d(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */