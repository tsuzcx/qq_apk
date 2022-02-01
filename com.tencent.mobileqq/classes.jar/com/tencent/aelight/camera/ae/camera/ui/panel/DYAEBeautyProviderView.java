package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$ItemClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "beautyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "controller", "Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;", "lifecycleOwner", "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "partManager", "Lcom/tencent/aelight/camera/ae/part/VideoStoryCapturePartManager;", "primaryBeautyListManager", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "alertClearDialog", "", "alertResetDialog", "clearSelection", "initViewModel", "onDestroy", "onItemClick", "item", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "position", "", "onProviderDismiss", "onProviderShow", "onResume", "reportDTClearEvent", "reportDTResetEvent", "setControllerAndManager", "updateBeautyList", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEBeautyProviderView
  extends FrameLayout
  implements DYAEEffectListHolder.ItemClickListener
{
  private AEPituCameraUnit a;
  private AECaptureController b;
  private VideoStoryCapturePartManager c;
  private AEBeautyProviderViewModel d;
  private final DYAEEffectListHolder e = new DYAEEffectListHolder(paramContext, (ViewGroup)this, (DYAEEffectListHolder.ItemClickListener)this);
  
  public DYAEBeautyProviderView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final void f()
  {
    AEPituCameraUnit localAEPituCameraUnit = this.a;
    if (localAEPituCameraUnit != null)
    {
      this.d = ((AEBeautyProviderViewModel)AEViewModelProviders.a((ViewModelStoreOwner)localAEPituCameraUnit).get(AEBeautyProviderViewModel.class));
      Object localObject = this.d;
      if (localObject != null)
      {
        localObject = ((AEBeautyProviderViewModel)localObject).a();
        if (localObject != null) {
          ((LiveData)localObject).observe((LifecycleOwner)localAEPituCameraUnit, (Observer)new DYAEBeautyProviderView.initViewModel..inlined.let.lambda.1(this));
        }
      }
      localObject = this.d;
      if (localObject != null)
      {
        localObject = ((AEBeautyProviderViewModel)localObject).e();
        if (localObject != null) {
          ((LiveData)localObject).observe((LifecycleOwner)localAEPituCameraUnit, (Observer)new DYAEBeautyProviderView.initViewModel..inlined.let.lambda.2(this));
        }
      }
      localObject = this.d;
      if (localObject != null)
      {
        localObject = ((AEBeautyProviderViewModel)localObject).g();
        if (localObject != null) {
          ((LiveData)localObject).observe((LifecycleOwner)localAEPituCameraUnit, (Observer)new DYAEBeautyProviderView.initViewModel..inlined.let.lambda.3(this));
        }
      }
      localObject = this.d;
      if (localObject != null)
      {
        localObject = ((AEBeautyProviderViewModel)localObject).j();
        if (localObject != null) {
          ((MutableLiveData)localObject).observe((LifecycleOwner)localAEPituCameraUnit, (Observer)new DYAEBeautyProviderView.initViewModel..inlined.let.lambda.4(this));
        }
      }
      localObject = this.d;
      if (localObject != null)
      {
        localObject = ((AEBeautyProviderViewModel)localObject).k();
        if (localObject != null) {
          ((MutableLiveData)localObject).observe((LifecycleOwner)localAEPituCameraUnit, (Observer)new DYAEBeautyProviderView.initViewModel..inlined.let.lambda.5(this));
        }
      }
    }
  }
  
  private final void g()
  {
    DYAEEffectListHolder.a(this.e, false, 1, null);
    this.e.b();
  }
  
  private final void h()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getContext(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(2064187438);
    localQQCustomDialog.setMessage((CharSequence)"");
    localQQCustomDialog.setNegativeButton(2064187417, (DialogInterface.OnClickListener)DYAEBeautyProviderView.alertClearDialog.1.a);
    localQQCustomDialog.setPositiveButton(2064187426, (DialogInterface.OnClickListener)new DYAEBeautyProviderView.alertClearDialog.2(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  private final void i()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getContext(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(2064187439);
    localQQCustomDialog.setMessage((CharSequence)"");
    localQQCustomDialog.setNegativeButton(2064187417, (DialogInterface.OnClickListener)DYAEBeautyProviderView.alertResetDialog.1.a);
    localQQCustomDialog.setPositiveButton(2064187426, (DialogInterface.OnClickListener)new DYAEBeautyProviderView.alertResetDialog.2(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  private final void j()
  {
    VideoReport.setElementId(this, "em_xsj_beauty_clear");
    VideoReport.setElementParams(this, (Map)FlashShowDtReportHelper.a().d());
    VideoReport.reportEvent("ev_xsj_camera_action", this, MapsKt.mapOf(TuplesKt.to("xsj_eid", "em_xsj_beauty_clear")));
  }
  
  private final void k()
  {
    VideoReport.setElementId(this, "em_xsj_beauty_reset");
    VideoReport.setElementParams(this, (Map)FlashShowDtReportHelper.a().d());
    VideoReport.reportEvent("ev_xsj_camera_action", this, MapsKt.mapOf(TuplesKt.to("xsj_eid", "em_xsj_beauty_reset")));
  }
  
  public final void a()
  {
    AEBeautyProviderViewModel localAEBeautyProviderViewModel = this.d;
    if (localAEBeautyProviderViewModel != null) {
      localAEBeautyProviderViewModel.d();
    }
    g();
  }
  
  public void a(@NotNull DYAEEffectItem paramDYAEEffectItem, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramDYAEEffectItem, "item");
    if (DYAEEffectItemExtKt.a(paramDYAEEffectItem))
    {
      h();
      return;
    }
    if ((paramDYAEEffectItem instanceof DYAEBeautyItem))
    {
      paramDYAEEffectItem = ((DYAEBeautyItem)paramDYAEEffectItem).g();
      if (paramDYAEEffectItem.k() == BeautyItem.RESET)
      {
        i();
        return;
      }
      Object localObject = this.d;
      if (localObject != null) {
        ((AEBeautyProviderViewModel)localObject).a(paramDYAEEffectItem);
      }
      localObject = paramDYAEEffectItem.b();
      paramInt = AEProviderViewModel.a.b(paramDYAEEffectItem);
      paramDYAEEffectItem = AEProviderViewModel.a.b(paramDYAEEffectItem);
      AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
      if (paramDYAEEffectItem != null)
      {
        paramDYAEEffectItem = paramDYAEEffectItem.b();
        if (paramDYAEEffectItem != null) {}
      }
      else
      {
        paramDYAEEffectItem = "";
      }
      localAEBaseDataReporter.a((String)localObject, paramDYAEEffectItem, paramInt);
    }
  }
  
  public final void b() {}
  
  public final void c()
  {
    g();
  }
  
  public final void d() {}
  
  public final void e()
  {
    this.e.a(null, false);
  }
  
  public final void setControllerAndManager(@NotNull AECaptureController paramAECaptureController, @NotNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    Intrinsics.checkParameterIsNotNull(paramAECaptureController, "controller");
    Intrinsics.checkParameterIsNotNull(paramVideoStoryCapturePartManager, "partManager");
    this.b = paramAECaptureController;
    this.c = paramVideoStoryCapturePartManager;
    this.a = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyProviderView
 * JD-Core Version:    0.7.0.1
 */