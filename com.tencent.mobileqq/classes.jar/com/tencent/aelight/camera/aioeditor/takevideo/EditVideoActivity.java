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
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
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
  public long a = -1L;
  protected EditVideoPartManager b;
  private RelativeLayout c;
  
  private void b()
  {
    if (LiuHaiUtils.g())
    {
      this.c = ((RelativeLayout)findViewById(2063991220));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.h();
      this.c.setLayoutParams(localLayoutParams);
      this.c.setVisibility(0);
    }
  }
  
  private void e()
  {
    View localView1 = findViewById(2063990936);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131442058);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void f()
  {
    long l = getIntent().getLongExtra("stop_record_time", -1L);
    int i = this.b.T();
    int j = this.b.I.j();
    if ((CaptureFreqMonitor.d) && (l != -1L))
    {
      CaptureFreqMonitor.e.c();
      CaptureFreqMonitor.e.c = this.b.I.a;
      CaptureFreqMonitor.e.a(0, l);
      CaptureFreqMonitor.e.a(1, this.a);
    }
    int k = this.b.V();
    getIntent().putExtra("capture_operation_in", k);
    StoryReportor.b("edit_exp", k, 0, new String[] { StoryReportor.d(i), "", "", String.valueOf(j) });
  }
  
  private void g()
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
  
  private void h()
  {
    ThreadManager.excute(new EditVideoActivity.6(this), 16, null, true);
  }
  
  protected void a()
  {
    if (this.b == null) {
      this.b = new EditVideoPartManager();
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  @NonNull
  public Activity c()
  {
    return this;
  }
  
  protected void d()
  {
    if (this.b.I.h() == 14) {
      PeakIpcModuleClient.b();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.b.a(paramInt1, paramInt2, paramIntent);
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
    if (!this.b.x()) {
      super.doOnBackPressed();
    }
    e();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    LiuHaiUtils.d();
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
    h();
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
      paramBundle.append(HardCodeUtil.a(2131901967));
      paramBundle.append(str1);
      QQToast.makeText(this, paramBundle.toString(), 0).show();
      finish();
      return true;
    }
    String str1 = getIntent().getStringExtra("op_department");
    String str2 = getIntent().getStringExtra("op_type");
    SLog.d("EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), str1, str2 });
    AECameraDaTongHelper.a.a(this, "pg_ae_camera_video_save");
    LiuHaiUtils.d();
    LiuHaiUtils.h(this);
    LiuHaiUtils.i(this);
    if (LiuHaiUtils.g()) {
      LiuHaiUtils.enableNotch(this);
    }
    this.b.aa = true;
    setContentViewC(2064056495);
    a(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.makeText(this, HardCodeUtil.a(2131901809), 0).show();
      finish();
      return true;
    }
    b();
    int i = getIntent().getIntExtra("edit_video_way", 0);
    this.b.e(i);
    this.b.a(this, localEditVideoParams);
    paramBundle = (QIMCaptureVarManager)QIMManager.a(13);
    paramBundle.a(8);
    paramBundle.b(this.b.I.h());
    this.b.c();
    FileUtils.g(QQStoryConstant.g);
    VideoEditReport.a = str1;
    VideoEditReport.b = str2;
    VideoEditReport.a("0X80076B5");
    StoryReportor.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
    LpReportInfo_pf00064.allReport(628, 1);
    SLog.b("EditVideoActivity", "EditVideoActivity doOnCreate end");
    sendBroadcast(new Intent("action_fire_get_config"));
    g();
    ((QIMCaptureVarManager)QIMManager.a(13)).e(1);
    d();
    this.a = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.3(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.d("EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.b.w();
    VideoEditReport.a = "";
    VideoEditReport.b = "";
    CaptureFreqMonitor.c.d();
    ((QIMCaptureVarManager)QIMManager.a(13)).e(1);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SLog.c("EditVideoActivity", "doOnPause");
    this.b.t();
    ThreadManagerV2.excute(new EditVideoActivity.5(this), 16, null, false);
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    SLog.c("EditVideoActivity", "doOnRestoreInstanceState");
    this.b.a(paramBundle);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SLog.c("EditVideoActivity", "doOnResume");
    this.b.s();
    ThreadManagerV2.excute(new EditVideoActivity.4(this), 16, null, false);
    ((QIMCaptureVarManager)QIMManager.a(13)).d(1);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(getWindow());
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    SLog.c("EditVideoActivity", "doOnSaveInstanceState");
    this.b.b(paramBundle);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SLog.c("EditVideoActivity", "doOnStart");
    this.b.r();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportEditViewExpose();
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setShootTime();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    SLog.c("EditVideoActivity", "doOnStop");
    this.b.u();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportEditView();
    AEQLog.b("EditVideoActivity", "【doOnStop】");
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.b.d(paramBoolean);
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
    if (this.b.I.a != 3)
    {
      VideoFilterTools.a().a(null, this, this.b.y());
      VideoFilterTools.a().a(null);
    }
    Intent localIntent = paramIntent;
    if (this.b.I.d != null)
    {
      paramBoolean = this.b.I.d.getBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
      String str = this.b.I.d.getString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
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
    if (this.b.Y())
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
    this.b.O();
    g();
  }
  
  public Intent getPublishIntent(GenerateContext paramGenerateContext)
  {
    Intent localIntent;
    if (this.b.G == null) {
      localIntent = new Intent();
    } else {
      localIntent = this.b.G;
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
    if (this.b.O != null)
    {
      localObject1 = localObject2;
      if (this.b.O.b() != null)
      {
        localObject1 = localObject2;
        if (this.b.O.b().getTextLayer() != null) {
          localObject1 = this.b.O.b().getTextLayer().t;
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
        if ((localTextItem.c != null) && (localTextItem.c.i() != null)) {
          ((JSONArray)localObject2).put(localTextItem.c.i().toString());
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
    localIntent.putExtra(PublishParam.a, paramGenerateContext.m);
    return localIntent;
  }
  
  @NonNull
  public View getRootView()
  {
    return getWindow().getDecorView();
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.b.N != null) {
      ThreadManager.getUIHandler().post(new EditVideoActivity.7(this));
    }
  }
  
  public void initNavigationBarColor() {}
  
  protected void onOutOfMemory()
  {
    super.onOutOfMemory();
    SLog.d("EditVideoActivity", "onOutOfMemory");
    g();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    SLog.d("EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    g();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */