package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.ae.camera.ui.ICaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEAbsBottomPanal;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "broadCastRunnable", "Ljava/lang/Runnable;", "isCloseAnimating", "", "isOpenAnimating", "isPanelOpened", "()Z", "mContentView", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialProviderView;", "mController", "Lcom/tencent/aelight/camera/ae/camera/ui/ICaptureController;", "mMaterialPanelListener", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;", "mVideoStoryCaptureManger", "Lcom/tencent/aelight/camera/ae/part/VideoStoryCapturePartManager;", "openedHeight", "getOpenedHeight", "()I", "translationY", "getTranslationY", "setTranslationY", "(I)V", "adjustIconContainerForSegment", "", "isSegmentShooting", "closeContainer", "withAnim", "closeDirectly", "callback", "closePanel", "withAnimation", "closeWithAnimation", "doOpenProviderView", "categoryName", "", "itemId", "openSpecific", "hasMaterialToShow", "hidePanel", "isContainerClosed", "isFavoriteMaterial", "info", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "loadView", "onClear", "onDestroy", "onFavoriteClickEvent", "onResume", "onStop", "openWithAnimation", "positionSpecificMaterialItem", "materialId", "setCaptureController", "controller", "setMaterialPanelListener", "listener", "setPartManager", "capturePartManager", "showBottomList", "showCaptureLayout", "updateNoneMaterialState", "AEMaterialPanelListener", "AEMaterialPanelListenerAdapter", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialPanel
  extends AEAbsBottomPanal
{
  public static final AEFlashShowMaterialPanel.Companion a = new AEFlashShowMaterialPanel.Companion(null);
  private int b = getOpenedHeight();
  private AEFlashShowMaterialProviderView c;
  private boolean d;
  private boolean e;
  private ICaptureController g;
  private VideoStoryCapturePartManager h;
  private AEFlashShowMaterialPanel.AEMaterialPanelListener i;
  private Runnable j;
  
  public AEFlashShowMaterialPanel(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AEFlashShowMaterialPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEFlashShowMaterialPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(Runnable paramRunnable)
  {
    i();
    AEFlashShowMaterialProviderView localAEFlashShowMaterialProviderView = this.c;
    if (localAEFlashShowMaterialProviderView != null) {
      localAEFlashShowMaterialProviderView.setVisibility(8);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  @TargetApi(12)
  private final void b(Runnable paramRunnable)
  {
    if (this.c == null) {
      a();
    }
    AEFlashShowMaterialPanel localAEFlashShowMaterialPanel = (AEFlashShowMaterialPanel)this;
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play((Animator)ObjectAnimator.ofFloat(localAEFlashShowMaterialPanel, "translationY", new float[] { localAEFlashShowMaterialPanel.b, 0.0F }));
    ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)new AEFlashShowMaterialPanel.openWithAnimation.1.1());
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a((View)localAEFlashShowMaterialPanel.c, 0.0F, 1.0F);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "alphaAnimation");
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new AEFlashShowMaterialPanel.openWithAnimation..inlined.run.lambda.1(localAEFlashShowMaterialPanel, paramRunnable));
    localAEFlashShowMaterialPanel.startAnimation((Animation)localObject);
    if ((getContext() instanceof Activity))
    {
      paramRunnable = getContext();
      if (paramRunnable != null)
      {
        if (AECameraEntryManager.o(((Activity)paramRunnable).getIntent())) {
          AEReportUtils.a(5, null);
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
    }
  }
  
  @RequiresApi(api=11)
  private final void c(Runnable paramRunnable)
  {
    AEQLog.a("AEFlashShowMaterialPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.b });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObjectAnimator);
    localAnimatorSet.addListener((Animator.AnimatorListener)new AEFlashShowMaterialPanel.closeWithAnimation.1(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a((View)this.c, 1.0F, 0.0F);
    Intrinsics.checkExpressionValueIsNotNull(paramRunnable, "alphaAnimation");
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener((Animation.AnimationListener)new AEFlashShowMaterialPanel.closeWithAnimation.2(this));
    startAnimation(paramRunnable);
  }
  
  private final int getOpenedHeight()
  {
    return UIUtils.a(getContext(), 336);
  }
  
  private final void i()
  {
    setTranslationY(getOpenedHeight());
    setVisibility(8);
  }
  
  private final void j()
  {
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.h;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.b(131075, new Object[0]);
    }
  }
  
  @TargetApi(11)
  public final void a()
  {
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getOpenedHeight();
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    this.c = new AEFlashShowMaterialProviderView((Context)localObject, this.i);
    addView((View)this.c);
  }
  
  public final void a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "materialId");
    AEFlashShowMaterialProviderView localAEFlashShowMaterialProviderView = this.c;
    if (localAEFlashShowMaterialProviderView != null) {
      localAEFlashShowMaterialProviderView.a(paramString1, paramString2);
    }
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean, @Nullable Runnable paramRunnable)
  {
    b(paramRunnable);
    if ((paramBoolean) && (paramString2 != null)) {
      a(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject1 = getContext();
      if (localObject1 != null)
      {
        Object localObject2 = (Activity)localObject1;
        if ((AECameraEntryManager.o(((Activity)localObject2).getIntent())) && (c()))
        {
          localObject1 = ThreadManager.getUIHandler();
          localObject2 = (Runnable)new AEFlashShowMaterialPanel.closeContainer.1((Activity)localObject2);
          this.j = ((Runnable)localObject2);
          ((MqqHandler)localObject1).postDelayed((Runnable)localObject2, 300L);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
    }
    a(paramBoolean, (Runnable)new AEFlashShowMaterialPanel.closeContainer.3(this));
  }
  
  public final void a(boolean paramBoolean, @Nullable Runnable paramRunnable)
  {
    if (!c()) {
      return;
    }
    if (paramBoolean) {
      c(paramRunnable);
    } else {
      a(paramRunnable);
    }
    paramRunnable = this.h;
    if (paramRunnable != null) {
      paramRunnable.b(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEFlashShowMaterialPanel", 2, "panel closed");
    }
  }
  
  public final boolean a(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((AEFlashShowMaterialProviderView)localObject).getManager();
      if (localObject != null) {
        return ((AEFlashShowMaterialManager)localObject).d(paramAEMaterialMetaData);
      }
    }
    return false;
  }
  
  public final void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEFlashShowMaterialPanel", 2, "onDestroy()");
    }
    AEFlashShowMaterialProviderView localAEFlashShowMaterialProviderView = this.c;
    if (localAEFlashShowMaterialProviderView != null) {
      localAEFlashShowMaterialProviderView.b();
    }
    this.c = ((AEFlashShowMaterialProviderView)null);
    if (this.j != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.j);
    }
  }
  
  public final boolean c()
  {
    int k = getVisibility();
    boolean bool2 = false;
    if (k == 8) {
      return false;
    }
    AEFlashShowMaterialProviderView localAEFlashShowMaterialProviderView = this.c;
    boolean bool1 = bool2;
    if (localAEFlashShowMaterialProviderView != null)
    {
      bool1 = bool2;
      if (localAEFlashShowMaterialProviderView != null)
      {
        bool1 = bool2;
        if (localAEFlashShowMaterialProviderView.getVisibility() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void d()
  {
    AEFlashShowMaterialProviderView localAEFlashShowMaterialProviderView = this.c;
    if (localAEFlashShowMaterialProviderView != null) {
      localAEFlashShowMaterialProviderView.a();
    }
  }
  
  public boolean e()
  {
    return c() ^ true;
  }
  
  public final void f()
  {
    AEMaterialMetaData localAEMaterialMetaData = AEFlashShowMaterialManager.a.b();
    if (localAEMaterialMetaData != null)
    {
      Object localObject;
      if (a(localAEMaterialMetaData))
      {
        localObject = this.c;
        if (localObject != null)
        {
          localObject = ((AEFlashShowMaterialProviderView)localObject).getManager();
          if (localObject != null) {
            ((AEFlashShowMaterialManager)localObject).c(localAEMaterialMetaData);
          }
        }
      }
      else
      {
        localObject = this.c;
        if (localObject != null)
        {
          localObject = ((AEFlashShowMaterialProviderView)localObject).getManager();
          if (localObject != null) {
            ((AEFlashShowMaterialManager)localObject).b(localAEMaterialMetaData);
          }
        }
      }
    }
  }
  
  public final void g()
  {
    AEFlashShowMaterialProviderView localAEFlashShowMaterialProviderView = this.c;
    if (localAEFlashShowMaterialProviderView != null) {
      localAEFlashShowMaterialProviderView.c();
    }
  }
  
  public final int getTranslationY()
  {
    return this.b;
  }
  
  public final void setCaptureController(@Nullable ICaptureController paramICaptureController)
  {
    this.g = paramICaptureController;
  }
  
  public final void setMaterialPanelListener(@Nullable AEFlashShowMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.i = paramAEMaterialPanelListener;
  }
  
  public final void setPartManager(@Nullable VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.h = paramVideoStoryCapturePartManager;
  }
  
  public final void setTranslationY(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialPanel
 * JD-Core Version:    0.7.0.1
 */