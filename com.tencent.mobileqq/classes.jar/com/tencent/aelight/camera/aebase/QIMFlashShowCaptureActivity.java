package com.tencent.aelight.camera.aebase;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.aioeditor.AIOShortVideoUtil;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import com.tencent.util.LiuHaiUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import mqq.app.MobileQQ;

@TargetApi(14)
public class QIMFlashShowCaptureActivity
  extends QPublicFragmentActivity
  implements ICameraEntrance, IQIMCameraContainer, SimpleEventReceiver
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
  
  public static Intent a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMFlashShowCaptureActivity", 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMFlashShowCaptureActivity.class);
    int j = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if ((!AECameraEntry.l.b(j)) && (!AECameraEntry.k.b(j)))
    {
      if ((AECameraEntry.H.b(j)) || (AECameraEntry.I.b(j)))
      {
        AEQLog.a("QIMFlashShowCaptureActivity", "set special launch flags case2");
        paramContext.setFlags(402653184);
      }
    }
    else
    {
      AEQLog.a("QIMFlashShowCaptureActivity", "set special launch flags case1");
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
    AELaunchRecorder.d().a("startActivityForResult");
  }
  
  private void c()
  {
    if (!AECameraEntryManager.o(getIntent())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(a());
    VideoReport.setPageId(this, "small_world_base");
    VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("QIMFlashShowCaptureActivity"));
    QLog.i("QIMFlashShowCaptureActivity", 1, "reportDaTongRegister  subPage: QIMFlashShowCaptureActivity");
  }
  
  private boolean d()
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
        AEQLog.a("QIMFlashShowCaptureActivity", ((StringBuilder)localObject).toString());
        return true;
      }
      b.put(this.c, 1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isRepeatLaunch2 key: ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" value: ");
      ((StringBuilder)localObject).append(1);
      AEQLog.a("QIMFlashShowCaptureActivity", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private void e()
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
      AEQLog.a("QIMFlashShowCaptureActivity", localStringBuilder.toString());
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
    AEQLog.a("QIMFlashShowCaptureActivity", localStringBuilder.toString());
    b.delete(this.c);
  }
  
  public QPublicFragmentActivity a()
  {
    return this;
  }
  
  public void a(int paramInt)
  {
    finish();
  }
  
  public void b()
  {
    super.onBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    AEQLog.b("QIMFlashShowCaptureActivity", "[onCreate] + BEGIN");
    setVolumeControlStream(3);
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onCreate] from startActivity to onCreate, time cost = ");
    ((StringBuilder)localObject).append(l1 - l2);
    AEQLog.a("QIMFlashShowCaptureActivity", ((StringBuilder)localObject).toString());
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
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    if (d())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("repeat launch from: ");
      paramBundle.append(this.c);
      AEQLog.d("QIMFlashShowCaptureActivity", paramBundle.toString());
      finish();
      return false;
    }
    a().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.OPEN_CAMERA"), "com.tencent.msg.permission.pushnotify");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate: 参数接收：");
    ((StringBuilder)localObject).append(getIntent().getExtras());
    AEQLog.b("QIMFlashShowCaptureActivity", ((StringBuilder)localObject).toString());
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
    AEEditorMusicHelper.a(this);
    this.a.a(paramBundle);
    AELaunchRecorder.d().a("unitOnCreateView-begin");
    this.e = this.a.j();
    AELaunchRecorder.d().a("unitOnCreateView-end");
    setContentView(this.e);
    if ((!isInMultiWindow()) && (!AECommonUtil.a(a())))
    {
      ThreadManagerV2.excute(new QIMFlashShowCaptureActivity.1(this, j), 16, null, true);
      c();
      AELaunchRecorder.d().a("activityOnCreateEnd");
      paramBundle = new StringBuilder();
      paramBundle.append("[onCreate] + END, time cost = ");
      paramBundle.append(System.currentTimeMillis() - l1);
      AEQLog.b("QIMFlashShowCaptureActivity", paramBundle.toString());
      SimpleEventBus.getInstance().registerReceiver(this);
      return true;
    }
    QQToast.makeText(this, HardCodeUtil.a(2131907444), 0).show();
    finish();
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
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkFinishActivityEvent.class);
    return localArrayList;
  }
  
  public void initNavigationBarColor() {}
  
  protected boolean isWrapContent()
  {
    return false;
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
        QLog.i("QIMFlashShowCaptureActivity", 2, localStringBuilder.toString());
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy from: ");
    ((StringBuilder)localObject).append(this.c);
    AEQLog.a("QIMFlashShowCaptureActivity", ((StringBuilder)localObject).toString());
    e();
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
    a().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.CLOSE_CAMERA"), "com.tencent.msg.permission.pushnotify");
    SimpleEventBus.getInstance().unRegisterReceiver(this);
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
    AEQLog.a("QIMFlashShowCaptureActivity", ((StringBuilder)localObject).toString());
    if (a().isFinishing()) {
      e();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkFinishActivityEvent)) {
      finish();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("QIMFlashShowCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.h) {
      AELaunchRecorder.d().a("activityOnResumeBegin");
    }
    super.onResume();
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
    AEQLog.b("QIMFlashShowCaptureActivity", localStringBuilder.toString());
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.a.b(paramBundle);
  }
  
  public void onStart()
  {
    AEQLog.b("QIMFlashShowCaptureActivity", "[onStart] + BEGIN");
    if (!this.i) {
      AELaunchRecorder.d().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    MobileQQ.sMobileQQ.waitAppRuntime(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStart] waitAppRuntime, cost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AEQLog.a("QIMFlashShowCaptureActivity", localStringBuilder.toString());
    super.onStart();
    this.a.ai();
    if (!this.i) {
      AELaunchRecorder.d().a("activityOnStartEnd");
    }
    this.i = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStart] + END, time cost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AEQLog.b("QIMFlashShowCaptureActivity", localStringBuilder.toString());
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onStop from: ");
    ((StringBuilder)localObject).append(this.c);
    AEQLog.a("QIMFlashShowCaptureActivity", ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMFlashShowCaptureActivity
 * JD-Core Version:    0.7.0.1
 */