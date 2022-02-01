package com.tencent.aelight.camera.aeeditor;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.biz.circle.AECircleAutoTemplateMidPageFragment;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectIpcModule;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEEditorActivity
  extends PeakFragmentActivity
  implements LifecycleOwner, ViewModelStoreOwner
{
  private final LifecycleRegistry a = new LifecycleRegistry(this);
  private ViewModelStore b;
  private AEEditorModuleManager c;
  private List<AEEditorActivity.InitResult> d = new ArrayList();
  private List<String> e = new ArrayList();
  private List<String> f = new ArrayList();
  private boolean g;
  
  private void a(Lifecycle.Event paramEvent)
  {
    try
    {
      this.a.handleLifecycleEvent(paramEvent);
      return;
    }
    catch (Throwable paramEvent)
    {
      label9:
      break label9;
    }
    QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.d.add(new AEEditorActivity.InitResult(paramInt));
    }
  }
  
  private void b()
  {
    if (!AEKitForQQ.a())
    {
      this.d.add(new AEEditorActivity.InitResult(-1));
    }
    else
    {
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(FeatureManager.Features.LIGHT_SDK.init(), -8);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
    TAVCut.initTAVCut(getApplicationContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.n(), new AEEditorActivity.1(this));
  }
  
  private void c()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    String str;
    if (getIntent().getIntExtra("editorType", 0) == 0) {
      str = "pg_xsj_edit_pics";
    } else {
      str = "pg_xsj_edit_videos";
    }
    VideoReport.setPageId(this, str);
    VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("AEEditorActivity"));
    QLog.i("AEEditorActivity", 1, "reportDaTongRegister  subPage: AEEditorActivity");
  }
  
  private void d()
  {
    if (this.d.size() > 0)
    {
      localObject1 = new StringBuilder();
      Object localObject2 = this.d.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AEEditorActivity.InitResult localInitResult = (AEEditorActivity.InitResult)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localInitResult.toString());
        localStringBuilder.append("\n");
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkInitResult--");
      ((StringBuilder)localObject2).append((String)localObject1);
      AEQLog.d("AEEditorActivity", ((StringBuilder)localObject2).toString());
      return;
    }
    VideoThumbProviderManager.initLruCacheSize(3072);
    Object localObject1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2063925492);
    if ((localObject1 instanceof BitmapDrawable)) {
      VideoThumbProviderManager.getInstance().setDefaultBitmap(((BitmapDrawable)localObject1).getBitmap());
    } else if ((localObject1 instanceof SkinnableBitmapDrawable)) {
      VideoThumbProviderManager.getInstance().setDefaultBitmap(((SkinnableBitmapDrawable)localObject1).getBitmap());
    }
    e();
  }
  
  private void e()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getExtras() != null) {
      localBundle = getIntent().getExtras();
    }
    this.c = new AEEditorModuleManager(getSupportFragmentManager());
    this.c.a(localBundle);
  }
  
  private void f()
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("editorType", -1);
    int j = localIntent.getIntExtra("editorFrom", -1);
    if ((j != AECameraEntry.x.a()) && (j != AECameraEntry.z.a()))
    {
      if ((j != AECameraEntry.y.a()) && (j != AECameraEntry.A.a())) {
        AEBaseReportParam.a().n().v = AEBaseReportParam.a.longValue();
      } else if (i == 0) {
        AEBaseReportParam.a().n().v = AEBaseReportParam.d.longValue();
      } else if (i == 1) {
        AEBaseReportParam.a().n().v = AEBaseReportParam.e.longValue();
      } else {
        AEBaseReportParam.a().n().v = AEBaseReportParam.a.longValue();
      }
    }
    else if (i == 0) {
      AEBaseReportParam.a().n().v = AEBaseReportParam.b.longValue();
    } else if (i == 1) {
      AEBaseReportParam.a().n().v = AEBaseReportParam.c.longValue();
    } else {
      AEBaseReportParam.a().n().v = AEBaseReportParam.a.longValue();
    }
    AEBaseReportParam.a().n().d = AEBaseReportParam.a().S();
  }
  
  public AEEditorModuleManager a()
  {
    return this.c;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnActivityResult---requestCode=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", resultCode=");
    ((StringBuilder)localObject).append(paramInt2);
    AEQLog.b("AEEditorActivity", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((AEEditorModuleManager)localObject).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    AEEditorModuleManager localAEEditorModuleManager = this.c;
    if (localAEEditorModuleManager != null) {
      localAEEditorModuleManager.a(this, true);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    AEThemeUtil.a();
    this.g = AEThemeUtil.b();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    setImmersiveStatus(getResources().getColor(2063794180));
    try
    {
      super.doOnCreate(paramBundle);
    }
    catch (Exception paramBundle)
    {
      QLog.e("AEEditorActivity", 4, "super.doOnCreate(savedInstanceState) 失败");
      paramBundle.printStackTrace();
    }
    a(Lifecycle.Event.ON_CREATE);
    setContentView(2064056419);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramBundle = (FrameLayout)findViewById(2063991396);
      int i = getStatusBarHeight();
      paramBundle.setPadding(paramBundle.getPaddingLeft(), paramBundle.getPaddingTop() + i, paramBundle.getPaddingRight(), paramBundle.getPaddingBottom());
    }
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
    b();
    d();
    AEEditorEffectIpcModule.b();
    f();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    AEEditorEffectIpcModule.c();
    a(Lifecycle.Event.ON_DESTROY);
    VideoThumbProviderManager.getInstance().release(String.valueOf(hashCode()));
    if ((this.b != null) && (!isChangingConfigurations())) {
      this.b.clear();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject = getSupportFragmentManager().findFragmentById(2063990865);
    if (((localObject instanceof AEEditorVideoEditFragment)) || ((localObject instanceof AECircleAutoTemplateMidPageFragment)))
    {
      localObject = (AEEditorBaseFragment)localObject;
      Bundle localBundle = new Bundle();
      localBundle.putString("editor_video_template_id", paramIntent.getExtras().getString("editor_video_template_id"));
      localBundle.putSerializable("ae_album_selected_media_models", paramIntent.getExtras().getSerializable("ae_album_selected_media_models"));
      localBundle.putBoolean("ae_video_editor_entrance_mid_page", paramIntent.getExtras().getBoolean("ae_video_editor_entrance_mid_page"));
      localBundle.putSerializable("AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL", paramIntent.getExtras().getSerializable("AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL"));
      ((AEEditorBaseFragment)localObject).b().b(null, localBundle);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    a(Lifecycle.Event.ON_PAUSE);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(Lifecycle.Event.ON_RESUME);
    VideoThumbProviderManager.getInstance().resume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    a(Lifecycle.Event.ON_START);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    a(Lifecycle.Event.ON_STOP);
    VideoThumbProviderManager.getInstance().pause();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnWindowFocusChanged isFocused:");
    ((StringBuilder)localObject).append(paramBoolean);
    AEQLog.b("AEEditorActivity", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((AEEditorModuleManager)localObject).a(paramBoolean);
    }
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (this.b == null) {
        this.b = new ViewModelStore();
      }
      return this.b;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorActivity
 * JD-Core Version:    0.7.0.1
 */