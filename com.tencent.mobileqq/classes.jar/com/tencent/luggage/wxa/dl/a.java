package com.tencent.luggage.wxa.dl;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import com.tencent.luggage.scanner.camera.f;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/view/BaseScanMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/luggage/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/luggage/scanner/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/luggage/scanner/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/luggage/scanner/qbar/ScanDecodeFrameData;)V", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", "scanCamera", "Lcom/tencent/luggage/scanner/camera/LuggageScanCamera;", "getScanCamera", "()Lcom/tencent/luggage/scanner/camera/LuggageScanCamera;", "setScanCamera", "(Lcom/tencent/luggage/scanner/camera/LuggageScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "attachActivity", "attachBackgroundView", "backgroundView", "attachFlashSwitcherView", "attachGalleryButton", "galleryButton", "attachScanCamera", "attachScanTipsView", "tipsView", "getTargetSuccessMarkView", "init", "onBackPressed", "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/luggage/scanner/view/ScanResultAnimationListener;", "onViewDestroy", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showScanTips", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public abstract class a
  extends RelativeLayout
  implements b
{
  public static final a.a b = new a.a(null);
  @Nullable
  private Activity a;
  @Nullable
  private TextView c;
  @Nullable
  private View d;
  @Nullable
  private View e;
  @Nullable
  private Rect f;
  @Nullable
  private Rect g;
  @Nullable
  private f h;
  private int i;
  private boolean j;
  private int k;
  private boolean l;
  @Nullable
  private com.tencent.luggage.scanner.qbar.e m;
  
  public a(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private final void a()
  {
    o.d("Luggage.BaseScanMaskView", "alvinluo init networkAvailable: %b", new Object[] { Boolean.valueOf(this.j) });
  }
  
  public void a(@Nullable Animator.AnimatorListener paramAnimatorListener)
  {
    o.e("Luggage.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.l = true;
  }
  
  public void a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    this.a = paramActivity;
  }
  
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "flashSwitcher");
    o.f("Luggage.BaseScanMaskView", "alvinluo attachFlashSwitcherView");
    this.d = paramView;
  }
  
  protected final void a(@Nullable View paramView, float paramFloat1, float paramFloat2, @Nullable Animator.AnimatorListener paramAnimatorListener)
  {
    o.f("Luggage.BaseScanMaskView", "alvinluo animateAlpha from: %f, to: %f, hashCode: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(hashCode()) });
    if (paramView != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.setListener(null);
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator = localViewPropertyAnimator.setUpdateListener(null);
          if (localViewPropertyAnimator != null) {
            localViewPropertyAnimator.cancel();
          }
        }
      }
    }
    if (paramView != null) {
      paramView.setAlpha(paramFloat1);
    }
    if (paramView != null)
    {
      paramView = paramView.animate();
      if (paramView != null)
      {
        paramView = paramView.alpha(paramFloat2);
        if (paramView != null)
        {
          paramView = paramView.setDuration(200L);
          if (paramView != null)
          {
            paramView = paramView.setInterpolator((TimeInterpolator)new LinearInterpolator());
            if (paramView != null)
            {
              paramView = paramView.setUpdateListener(null);
              if (paramView != null)
              {
                paramView = paramView.setListener(paramAnimatorListener);
                if (paramView != null) {
                  paramView.start();
                }
              }
            }
          }
        }
      }
    }
  }
  
  @CallSuper
  public void a(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "tipsView");
    this.c = paramTextView;
    TextView localTextView = this.c;
    if (localTextView != null)
    {
      if (localTextView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
        if (localLayoutParams != null)
        {
          paramTextView = localLayoutParams;
          if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            break label71;
          }
          ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin = (com.tencent.luggage.wxa.qx.a.e(getContext(), 120) + this.k);
          paramTextView = localLayoutParams;
          break label71;
        }
      }
      paramTextView = null;
      label71:
      localTextView.setLayoutParams(paramTextView);
    }
  }
  
  public void a(@Nullable f paramf)
  {
    this.h = paramf;
  }
  
  public void a(@NotNull Object paramObject, @Nullable e parame)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
  }
  
  @CallSuper
  public void a(boolean paramBoolean)
  {
    o.d("Luggage.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
  }
  
  public void b(@Nullable View paramView) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (getAlpha() == 0.0F) {
        a((View)this, 0.0F, 1.0F, null);
      }
    }
    else if (getAlpha() == 1.0F) {
      a((View)this, 1.0F, 0.0F, null);
    }
  }
  
  public void c() {}
  
  public void c(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "galleryButton");
    this.e = paramView;
    View localView = this.e;
    if (localView != null)
    {
      if (localView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        if (localLayoutParams != null)
        {
          paramView = localLayoutParams;
          if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            break label71;
          }
          ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin = (com.tencent.luggage.wxa.qx.a.e(getContext(), 32) + this.k);
          paramView = localLayoutParams;
          break label71;
        }
      }
      paramView = null;
      label71:
      localView.setLayoutParams(paramView);
    }
  }
  
  public void d() {}
  
  @CallSuper
  public void e()
  {
    o.d("Luggage.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.l = false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  @CallSuper
  public void g() {}
  
  @Nullable
  protected final Activity getActivity()
  {
    return this.a;
  }
  
  protected final boolean getCurrentNetworkAvailable()
  {
    return this.j;
  }
  
  @Nullable
  protected final View getFlashSwitcher()
  {
    return this.d;
  }
  
  @Nullable
  protected final com.tencent.luggage.scanner.qbar.e getFrameData()
  {
    return this.m;
  }
  
  protected final int getMBottomExtraHeight()
  {
    return this.k;
  }
  
  @Nullable
  protected final View getMGalleryButton()
  {
    return this.e;
  }
  
  @Nullable
  protected final Rect getMPreviewRect()
  {
    return this.f;
  }
  
  @Nullable
  protected final Rect getMScanRect()
  {
    return this.g;
  }
  
  protected final int getMScanSource()
  {
    return this.i;
  }
  
  @Nullable
  protected final f getScanCamera()
  {
    return this.h;
  }
  
  @Nullable
  protected final TextView getScanTips()
  {
    return this.c;
  }
  
  @Nullable
  public View getTargetSuccessMarkView()
  {
    return null;
  }
  
  protected final boolean h()
  {
    return this.l;
  }
  
  protected final void setActivity(@Nullable Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.k = paramInt;
  }
  
  protected final void setCurrentNetworkAvailable(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setDecodeSuccessFrameData(@Nullable com.tencent.luggage.scanner.qbar.e parame)
  {
    this.m = parame;
  }
  
  protected final void setFlashSwitcher(@Nullable View paramView)
  {
    this.d = paramView;
  }
  
  protected final void setFrameData(@Nullable com.tencent.luggage.scanner.qbar.e parame)
  {
    this.m = parame;
  }
  
  protected final void setMBottomExtraHeight(int paramInt)
  {
    this.k = paramInt;
  }
  
  protected final void setMGalleryButton(@Nullable View paramView)
  {
    this.e = paramView;
  }
  
  protected final void setMPreviewRect(@Nullable Rect paramRect)
  {
    this.f = paramRect;
  }
  
  protected final void setMScanRect(@Nullable Rect paramRect)
  {
    this.g = paramRect;
  }
  
  protected final void setMScanSource(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void setPreviewRect(@Nullable Rect paramRect)
  {
    this.f = paramRect;
    postInvalidate();
  }
  
  protected final void setScanCamera(@Nullable f paramf)
  {
    this.h = paramf;
  }
  
  public final void setScanRect(@Nullable Rect paramRect)
  {
    this.g = paramRect;
  }
  
  public void setScanSource(int paramInt)
  {
    this.i = paramInt;
  }
  
  protected final void setScanTips(@Nullable TextView paramTextView)
  {
    this.c = paramTextView;
  }
  
  protected final void setViewDestroy(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dl.a
 * JD-Core Version:    0.7.0.1
 */