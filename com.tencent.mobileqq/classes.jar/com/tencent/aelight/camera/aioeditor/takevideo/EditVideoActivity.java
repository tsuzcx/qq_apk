package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.OnResourceDownloadListener;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.TextMap;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleClient;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.monitor.CaptureFreqMonitorItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements VideoFilterTools.OnResourceDownloadListener, EditVideoPartManager.IEditVideoPartManager, EditVideoUi
{
  public long a;
  private RelativeLayout a;
  protected EditVideoPartManager a;
  
  public EditVideoActivity()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  private void c()
  {
    if (LiuHaiUtils.f())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2064122347));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  private void d()
  {
    View localView1 = findViewById(2064122005);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131373992);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void e()
  {
    long l = getIntent().getLongExtra("stop_record_time", -1L);
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.g();
    int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c();
    if ((CaptureFreqMonitor.jdField_b_of_type_Boolean) && (l != -1L))
    {
      CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.b();
      CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int;
      CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a(0, l);
      CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a(1, this.jdField_a_of_type_Long);
    }
    int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.i();
    getIntent().putExtra("capture_operation_in", k);
    StoryReportor.b("edit_exp", k, 0, new String[] { StoryReportor.b(i), "", "", String.valueOf(j) });
  }
  
  private void f()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    SLog.a("EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 10240L)
    {
      SLog.d("EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(GlobalImageCache.a.size() / 1024) });
      ((TrimmableManager)SuperManager.a(26)).a(2);
      return;
    }
    ((TrimmableManager)SuperManager.a(26)).a(0);
  }
  
  private void g()
  {
    ThreadManager.excute(new EditVideoActivity.6(this), 16, null, true);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager = new EditVideoPartManager();
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 14) {
      PeakIpcModuleClient.a();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append("doOnActivityResult requestCode=");
    paramIntent.append(paramInt1);
    paramIntent.append(" resultCode=");
    paramIntent.append(paramInt2);
    SLog.c("EditVideoActivity", paramIntent.toString());
  }
  
  public void doOnBackPressed()
  {
    SLog.c("EditVideoActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f()) {
      super.doOnBackPressed();
    }
    d();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    LiuHaiUtils.a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    SvEffectSdkInitor.a();
    ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
    SLog.b("EditVideoActivity", "EditVideoActivity doOnCreate start");
    a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    g();
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    ThreadManager.getFileThreadHandler().post(new EditVideoActivity.1(this));
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.2(this));
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    SLog.d("EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {
      str1 = localEditVideoParams.a();
    } else {
      str1 = "can not find EditVideoParams";
    }
    if (!TextUtils.isEmpty(str1))
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131704042));
      paramBundle.append(str1);
      QQToast.a(this, paramBundle.toString(), 0).a();
      finish();
      return true;
    }
    String str1 = getIntent().getStringExtra("op_department");
    String str2 = getIntent().getStringExtra("op_type");
    SLog.d("EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), str1, str2 });
    LiuHaiUtils.a();
    LiuHaiUtils.c(this);
    LiuHaiUtils.d(this);
    if (LiuHaiUtils.f()) {
      LiuHaiUtils.enableNotch(this);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.r = true;
    setContentViewC(2064318631);
    a(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131703863), 0).a();
      finish();
      return true;
    }
    c();
    int i = getIntent().getIntExtra("edit_video_way", 0);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c(i);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(this, localEditVideoParams);
    paramBundle = (QIMCaptureVarManager)QIMManager.a(13);
    paramBundle.a(8);
    paramBundle.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c();
    FileUtils.a(QQStoryConstant.f);
    VideoEditReport.a = str1;
    VideoEditReport.b = str2;
    VideoEditReport.a("0X80076B5");
    StoryReportor.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
    LpReportInfo_pf00064.allReport(628, 1);
    SLog.b("EditVideoActivity", "EditVideoActivity doOnCreate end");
    sendBroadcast(new Intent("action_fire_get_config"));
    f();
    ((QIMCaptureVarManager)QIMManager.a(13)).d(1);
    b();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.3(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.d("EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.n();
    VideoEditReport.a = "";
    VideoEditReport.b = "";
    CaptureFreqMonitor.a.c();
    ((QIMCaptureVarManager)QIMManager.a(13)).d(1);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SLog.c("EditVideoActivity", "doOnPause");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.k();
    ThreadManagerV2.excute(new EditVideoActivity.5(this), 16, null, false);
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    SLog.c("EditVideoActivity", "doOnRestoreInstanceState");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramBundle);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SLog.c("EditVideoActivity", "doOnResume");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.j();
    ThreadManagerV2.excute(new EditVideoActivity.4(this), 16, null, false);
    ((QIMCaptureVarManager)QIMManager.a(13)).c(1);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(getWindow());
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    SLog.c("EditVideoActivity", "doOnSaveInstanceState");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(paramBundle);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SLog.c("EditVideoActivity", "doOnStart");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.i();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportEditViewExpose();
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setShootTime();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    SLog.c("EditVideoActivity", "doOnStop");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.l();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportEditView();
    AEQLog.b("EditVideoActivity", "【doOnStop】");
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.d(paramBoolean);
  }
  
  public void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    finish(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoActivity", 2, new Object[] { "finish, publishStoryFlag ", Boolean.valueOf(paramBoolean) });
    }
    ((IAECameraUnit)QRoute.api(IAECameraUnit.class)).setPublishStoryFlag(paramBoolean);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int != 3)
    {
      VideoFilterTools.a().a(null, this, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c());
      VideoFilterTools.a().a(null);
    }
    Intent localIntent = paramIntent;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_AndroidOsBundle.getBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
      String str = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      localIntent = paramIntent;
      if (paramBoolean)
      {
        localIntent = paramIntent;
        if (!TextUtils.isEmpty(str))
        {
          localIntent = paramIntent;
          if (paramIntent == null) {
            localIntent = new Intent();
          }
          localIntent.putExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", str);
        }
      }
    }
    paramIntent = localIntent;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.g())
    {
      paramIntent = localIntent;
      if (localIntent == null) {
        paramIntent = new Intent();
      }
      paramIntent.putExtra("key_edit_to_photo_list", true);
    }
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.z();
    f();
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart != null) {
      ThreadManager.getUIHandler().post(new EditVideoActivity.7(this));
    }
  }
  
  public Intent getPublishIntent(GenerateContext paramGenerateContext)
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent == null) {
      localIntent = new Intent();
    } else {
      localIntent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent;
    }
    localIntent.putExtra("widgetinfo", getIntent().getStringExtra("widgetinfo"));
    Object localObject1 = getIntent().getStringExtra("key_camera_material_name");
    localIntent.putExtra("key_camera_material_name", (String)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("AIO send video---takeSameName=");
    ((StringBuilder)localObject2).append((String)localObject1);
    AEQLog.b("EditVideoActivity", ((StringBuilder)localObject2).toString());
    localObject2 = null;
    localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a() != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a() != null) {
          localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a().a;
        }
      }
    }
    localObject2 = new JSONArray();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject1).next();
        if ((localTextItem.a != null) && (localTextItem.a.a() != null)) {
          ((JSONArray)localObject2).put(localTextItem.a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("EditVideoActivity getPublishIntent, content is: ");
      ((StringBuilder)localObject1).append(((JSONArray)localObject2).toString());
      QLog.i("DText", 2, ((StringBuilder)localObject1).toString());
    }
    localIntent.putExtra("dynamic_text", ((JSONArray)localObject2).toString());
    localIntent.putExtra(PublishParam.a, paramGenerateContext.a);
    return localIntent;
  }
  
  @NonNull
  public View getRootView()
  {
    return getWindow().getDecorView();
  }
  
  public void initNavigationBarColor() {}
  
  protected void onOutOfMemory()
  {
    super.onOutOfMemory();
    SLog.d("EditVideoActivity", "onOutOfMemory");
    f();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    SLog.d("EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    f();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */