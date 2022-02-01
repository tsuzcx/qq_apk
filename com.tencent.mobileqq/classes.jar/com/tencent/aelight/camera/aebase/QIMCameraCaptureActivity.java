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
  private static SparseIntArray b = new SparseIntArray();
  private IQIMCameraLifeCallback a;
  private int c;
  private boolean d;
  private View e;
  private int f = 0;
  private int g = 0;
  private boolean h = false;
  private boolean i = false;
  
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
    localObject = b(paramActivity, paramBundle);
    if (AECameraLauncher.a(paramBundle)) {
      ((Intent)localObject).addFlags(603979776);
    }
    paramActivity.startActivityForResult((Intent)localObject, paramInt);
    AELaunchRecorder.d().a("startActivityForResult");
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
    paramContext.startActivity(b(paramContext, paramBundle));
  }
  
  public static Intent b(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMCameraCaptureActivity", 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    int j = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if ((!AECameraEntry.l.b(j)) && (!AECameraEntry.k.b(j)))
    {
      if ((AECameraEntry.H.b(j)) || (AECameraEntry.I.b(j)))
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
  
  private void d()
  {
    if (!AECameraEntryManager.o(getIntent())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this, "small_world_base");
    VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("QIMCameraCaptureActivity"));
    QLog.i("QIMCameraCaptureActivity", 1, "reportDaTongRegister  subPage: QIMCameraCaptureActivity");
  }
  
  private boolean e()
  {
    if ((!AECameraEntryManager.o(getIntent())) && (AECameraEntryManager.a(getIntent()) != AECameraEntry.I.a()))
    {
      if (AECameraEntryManager.a(getIntent()) == AECameraEntry.a.a()) {
        return false;
      }
      if (b.indexOfKey(this.c) >= 0)
      {
        int k = b.get(this.c);
        localObject = b;
        int j = this.c;
        k += 1;
        ((SparseIntArray)localObject).put(j, k);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isRepeatLaunch key: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" value: ");
        ((StringBuilder)localObject).append(k);
        AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
        return true;
      }
      b.put(this.c, 1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isRepeatLaunch2 key: ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" value: ");
      ((StringBuilder)localObject).append(1);
      AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private void f()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    if (b.indexOfKey(this.c) >= 0)
    {
      int j = b.get(this.c);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decreaseFrom key: ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" value: ");
      localStringBuilder.append(j);
      AEQLog.a("QIMCameraCaptureActivity", localStringBuilder.toString());
      if (j <= 1)
      {
        b.delete(this.c);
        return;
      }
      b.put(this.c, j - 1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decreaseFrom2 key: ");
    localStringBuilder.append(this.c);
    AEQLog.a("QIMCameraCaptureActivity", localStringBuilder.toString());
    b.delete(this.c);
  }
  
  public void a(int paramInt)
  {
    finish();
  }
  
  public void b()
  {
    super.onBackPressed();
  }
  
  public void c() {}
  
  protected boolean cd_()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    IQIMCameraLifeCallback localIQIMCameraLifeCallback = this.a;
    if (localIQIMCameraLifeCallback != null) {
      localIQIMCameraLifeCallback.al();
    }
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  protected boolean isLatecyWaitRuntime()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.a.ak();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 51);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (CameraCompatibleList.e())
    {
      DisplayMetrics localDisplayMetrics = CaptureUtil.a(this);
      if ((localDisplayMetrics != null) && ((this.f != localDisplayMetrics.widthPixels) || (this.g != localDisplayMetrics.heightPixels)))
      {
        this.f = localDisplayMetrics.widthPixels;
        this.g = localDisplayMetrics.heightPixels;
        this.a.a(this.f, this.g);
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
    long l2 = getActivity().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onCreate] from startActivity to onCreate, time cost = ");
    ((StringBuilder)localObject).append(l1 - l2);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    this.c = AECameraEntryManager.a(getIntent());
    AELaunchRecorder.d().e();
    AELaunchRecorder.d().a("mainProcessLaunch", l2);
    AELaunchRecorder.d().a("activityOnCreateBegin", l1);
    AELaunchRecorder.d().a(l2);
    com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncControl.c = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (CameraCompatibleList.e()) {
      LiuHaiUtils.h(this);
    }
    LiuHaiUtils.f(this);
    LiuHaiUtils.enableNotch(this);
    localObject = CaptureUtil.a(this);
    if (localObject != null)
    {
      this.f = ((DisplayMetrics)localObject).widthPixels;
      this.g = ((DisplayMetrics)localObject).heightPixels;
    }
    this.y = true;
    this.z = false;
    super.onCreate(paramBundle);
    if (e())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("repeat launch from: ");
      paramBundle.append(this.c);
      AEQLog.d("QIMCameraCaptureActivity", paramBundle.toString());
      finish();
      return;
    }
    getActivity().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.OPEN_CAMERA"), "com.tencent.msg.permission.pushnotify");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate: 参数接收：");
    ((StringBuilder)localObject).append(getIntent().getExtras());
    AEQLog.b("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    int k = getIntent().getIntExtra("edit_video_type", 10002);
    int j = k;
    if (getIntent().getExtras() != null)
    {
      j = k;
      if (getIntent().getExtras().containsKey("VIDEO_STORY_FROM_TYPE"))
      {
        int m = getIntent().getExtras().getInt("VIDEO_STORY_FROM_TYPE");
        j = k;
        if (AECameraEntry.e.b(m)) {
          j = 10024;
        }
      }
    }
    AELaunchRecorder.d().a("buildCaptureUnit-begin");
    AEThemeUtil.a();
    this.a = QIMEffectCameraCaptureUnitBuilder.a(j, this, this);
    AELaunchRecorder.d().a("buildCaptureUnit-end");
    this.a.a(paramBundle);
    AELaunchRecorder.d().a("unitOnCreateView-begin");
    this.e = this.a.j();
    AELaunchRecorder.d().a("unitOnCreateView-end");
    setContentView(this.e);
    if ((!p()) && (!AECommonUtil.a(getActivity())))
    {
      ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, j), 16, null, true);
      d();
      AELaunchRecorder.d().a("activityOnCreateEnd");
      paramBundle = new StringBuilder();
      paramBundle.append("[onCreate] + END, time cost = ");
      paramBundle.append(System.currentTimeMillis() - l1);
      AEQLog.b("QIMCameraCaptureActivity", paramBundle.toString());
      return;
    }
    QQToast.makeText(this, HardCodeUtil.a(2131907444), 0).show();
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy from: ");
    ((StringBuilder)localObject).append(this.c);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    f();
    localObject = this.a;
    if (localObject != null)
    {
      ((IQIMCameraLifeCallback)localObject).m();
      MemoryClearManager.b().s = 0;
      localObject = (QIMPtvTemplateManager)QIMManager.a(3);
      QIMPtvTemplateManager.k = 0;
      ((QIMCaptureVarManager)QIMManager.a(13)).e(0);
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 51);
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
    }
    AELaunchRecorder.d().a(true);
    AELaunchRecorder.d().f();
    getActivity().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.CLOSE_CAMERA"), "com.tencent.msg.permission.pushnotify");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.a.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = this.a;
    if (localObject != null) {
      ((IQIMCameraLifeCallback)localObject).l();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPause from: ");
    ((StringBuilder)localObject).append(this.c);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    if (getActivity().isFinishing()) {
      f();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.h) {
      AELaunchRecorder.d().a("activityOnResumeBegin");
    }
    super.onResume();
    if ((Build.VERSION.SDK_INT >= 29) && (!AECameraEntryManager.g(this.c)) && (!AECameraEntryManager.p(getIntent()))) {
      NavigationBarUtil.a(getWindow());
    }
    this.a.k();
    ((QIMCaptureVarManager)QIMManager.a(13)).d(0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 51);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    if (!this.h) {
      AELaunchRecorder.d().a("activityOnResumeEnd");
    }
    this.h = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onResume] + END, time cost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AEQLog.b("QIMCameraCaptureActivity", localStringBuilder.toString());
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.a.b(paramBundle);
  }
  
  public void onStart()
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.i) {
      AELaunchRecorder.d().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStart] waitAppRuntime, cost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AEQLog.a("QIMCameraCaptureActivity", localStringBuilder.toString());
    super.onStart();
    this.a.ai();
    if (!this.i) {
      AELaunchRecorder.d().a("activityOnStartEnd");
    }
    this.i = true;
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
    ((StringBuilder)localObject).append(this.c);
    AEQLog.a("QIMCameraCaptureActivity", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((IQIMCameraLifeCallback)localObject).aj();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.a.e(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */