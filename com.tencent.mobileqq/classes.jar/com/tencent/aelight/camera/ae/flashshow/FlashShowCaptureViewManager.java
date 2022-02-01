package com.tencent.aelight.camera.ae.flashshow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.IQIMCameraLifeCallback;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.Style;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowChangeModeViewModel;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.OnTabSwitchListener;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModelFactory;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "cameraUnit", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;)V", "cameraLifeCallbackDelegate", "Lcom/tencent/aelight/camera/ae/IQIMCameraLifeCallback;", "getCameraLifeCallbackDelegate", "()Lcom/tencent/aelight/camera/ae/IQIMCameraLifeCallback;", "cameraLifeCallbackDelegate$delegate", "Lkotlin/Lazy;", "cameraUnitView", "Landroid/view/View;", "currentMode", "", "hasCameraUnitResumed", "", "hasCameraUnitViewCreated", "hasCameraViewShown", "mBottomPanelViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowBottomPanelViewModel;", "mCaptureViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowChangeModeViewModel;", "mMusicPlayerViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "mStateViewModel", "Lcom/tencent/aelight/camera/ae/part/AEVideoStoryStateViewModel;", "mSwitcherView", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout;", "mVibrator", "Landroid/os/Vibrator;", "getMVibrator", "()Landroid/os/Vibrator;", "mVibrator$delegate", "rootView", "createView", "parent", "Landroid/view/ViewGroup;", "initCameraUnitView", "", "initModeSwitchView", "initViewModel", "onCaptureViewHide", "onCaptureViewShow", "onViewHide", "onViewShow", "reportSwitchToCapturePhoto", "reportSwitchToCaptureVideo", "switchToMode", "mode", "vibrate", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowCaptureViewManager
{
  public static final FlashShowCaptureViewManager.Companion a = new FlashShowCaptureViewManager.Companion(null);
  private int b;
  private boolean c;
  private boolean d;
  private boolean e;
  private View f;
  private View g;
  private FlashShowSwitchLayout h;
  private AEFlashShowChangeModeViewModel i;
  private AEVideoStoryStateViewModel j;
  private AEFlashShowBottomPanelViewModel k;
  private AbsWinkMusicPlayerViewModel l;
  private final Lazy m;
  @NotNull
  private final Lazy n;
  private final FragmentActivity o;
  private final AEFlashShowCameraUnit p;
  
  public FlashShowCaptureViewManager(@NotNull FragmentActivity paramFragmentActivity, @NotNull AEFlashShowCameraUnit paramAEFlashShowCameraUnit)
  {
    this.o = paramFragmentActivity;
    this.p = paramAEFlashShowCameraUnit;
    this.b = 1;
    this.m = LazyKt.lazy((Function0)new FlashShowCaptureViewManager.mVibrator.2(this));
    this.n = LazyKt.lazy((Function0)new FlashShowCaptureViewManager.cameraLifeCallbackDelegate.2(this));
  }
  
  private final void a(int paramInt)
  {
    int i1 = this.b;
    if (paramInt == 2) {
      f();
    } else if (i1 == 2) {
      e();
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureViewModel");
      }
      ((AEFlashShowChangeModeViewModel)localObject).a().postValue(AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE);
      localObject = this.l;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMusicPlayerViewModel");
      }
      ((AbsWinkMusicPlayerViewModel)localObject).d();
    }
    else if (paramInt == 1)
    {
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureViewModel");
      }
      ((AEFlashShowChangeModeViewModel)localObject).a().postValue(AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE);
      localObject = this.l;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMusicPlayerViewModel");
      }
      ((AbsWinkMusicPlayerViewModel)localObject).c();
    }
    this.b = paramInt;
    paramInt = this.b;
    if (paramInt == 1)
    {
      j();
      return;
    }
    if (paramInt == 0) {
      i();
    }
  }
  
  private final void a(View paramView)
  {
    this.g = c().j();
    paramView = paramView.findViewById(2063990950);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "rootView.findViewById(R.id.camera_view_parent)");
    ((FrameLayout)paramView).addView(this.g, new ViewGroup.LayoutParams(-1, -1));
  }
  
  private final void b(View paramView)
  {
    this.h = ((FlashShowSwitchLayout)paramView.findViewById(2063990951));
    paramView = this.h;
    if (paramView != null) {
      paramView.setTabSwitchListener((FlashShowSwitchLayout.OnTabSwitchListener)new FlashShowCaptureViewManager.initModeSwitchView.1(this));
    }
    paramView = this.h;
    if (paramView != null) {
      FlashShowSwitchLayout.setCurrentItem$default(paramView, 1, false, 2, null);
    }
    paramView = this.h;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
  }
  
  private final Vibrator d()
  {
    return (Vibrator)this.m.getValue();
  }
  
  private final void e()
  {
    if (!this.d) {
      return;
    }
    if (!this.c)
    {
      this.c = true;
      c().ai();
      c().k();
      ThreadManager.getUIHandler().postDelayed((Runnable)new FlashShowCaptureViewManager.onCaptureViewShow.1(this), 500L);
      return;
    }
    if (this.e)
    {
      this.p.O();
      this.p.Q();
    }
  }
  
  private final void f()
  {
    if (this.e)
    {
      this.p.N();
      this.p.P();
    }
  }
  
  private final void g()
  {
    Object localObject = AEViewModelProviders.a((ViewModelStoreOwner)this.p).get(AEFlashShowChangeModeViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "AEViewModelProviders.of(…odeViewModel::class.java)");
    this.i = ((AEFlashShowChangeModeViewModel)localObject);
    localObject = AEViewModelProviders.a((ViewModelStoreOwner)this.p).get(AEVideoStoryStateViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "AEViewModelProviders.of(…ateViewModel::class.java)");
    this.j = ((AEVideoStoryStateViewModel)localObject);
    localObject = this.o.getSystemService("audio");
    if (localObject != null)
    {
      localObject = new MusicPlayerViewModelFactory((AudioManager)localObject, Scene.CAMERA);
      localObject = new ViewModelProvider((ViewModelStoreOwner)this.o, (ViewModelProvider.Factory)localObject).get(AbsWinkMusicPlayerViewModel.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProvider(activi…yerViewModel::class.java]");
      this.l = ((AbsWinkMusicPlayerViewModel)localObject);
      localObject = this.j;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mStateViewModel");
      }
      ((AEVideoStoryStateViewModel)localObject).a().observe((LifecycleOwner)this.p, (Observer)new FlashShowCaptureViewManager.initViewModel.1(this));
      localObject = AEViewModelProviders.a((ViewModelStoreOwner)this.p).get(AEFlashShowBottomPanelViewModel.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AEViewModelProviders.of(…nelViewModel::class.java)");
      this.k = ((AEFlashShowBottomPanelViewModel)localObject);
      localObject = this.k;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBottomPanelViewModel");
      }
      ((AEFlashShowBottomPanelViewModel)localObject).f().observe((LifecycleOwner)this.p, (Observer)new FlashShowCaptureViewManager.initViewModel.2(this));
      localObject = this.k;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBottomPanelViewModel");
      }
      ((AEFlashShowBottomPanelViewModel)localObject).e().observe((LifecycleOwner)this.p, (Observer)new FlashShowCaptureViewManager.initViewModel.3(this));
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureViewModel");
      }
      ((AEFlashShowChangeModeViewModel)localObject).b().observe((LifecycleOwner)this.p, (Observer)new FlashShowCaptureViewManager.initViewModel.4(this));
      localObject = this.j;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mStateViewModel");
      }
      ((AEVideoStoryStateViewModel)localObject).f().observe((LifecycleOwner)this.p, (Observer)new FlashShowCaptureViewManager.initViewModel.5(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
  }
  
  @SuppressLint({"MissingPermission"})
  private final void h()
  {
    ThreadManager.getUIHandler().post((Runnable)new FlashShowCaptureViewManager.vibrate.1(this));
  }
  
  private final void i()
  {
    FlashShowSwitchLayout localFlashShowSwitchLayout = this.h;
    if (localFlashShowSwitchLayout != null)
    {
      VideoReport.setElementId(localFlashShowSwitchLayout, "em_xsj_picture_tab");
      VideoReport.setElementParams(localFlashShowSwitchLayout, (Map)FlashShowDtReportHelper.a().d());
      VideoReport.reportEvent("dt_clck", localFlashShowSwitchLayout, null);
    }
  }
  
  private final void j()
  {
    FlashShowSwitchLayout localFlashShowSwitchLayout = this.h;
    if (localFlashShowSwitchLayout != null)
    {
      VideoReport.setElementId(localFlashShowSwitchLayout, "em_xsj_video_tab");
      VideoReport.setElementParams(localFlashShowSwitchLayout, (Map)FlashShowDtReportHelper.a().d());
      VideoReport.reportEvent("dt_clck", localFlashShowSwitchLayout, null);
    }
  }
  
  @NotNull
  public final View a(@Nullable ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from((Context)this.o).inflate(2064056468, paramViewGroup, false);
    this.f = paramViewGroup;
    g();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "view");
    a(paramViewGroup);
    b(paramViewGroup);
    return paramViewGroup;
  }
  
  public final void a()
  {
    if (this.b != 2) {
      e();
    }
  }
  
  public final void b()
  {
    if (this.b != 2) {
      f();
    }
  }
  
  @NotNull
  public final IQIMCameraLifeCallback c()
  {
    return (IQIMCameraLifeCallback)this.n.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager
 * JD-Core Version:    0.7.0.1
 */