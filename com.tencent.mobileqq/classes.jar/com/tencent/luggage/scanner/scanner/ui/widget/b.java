package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.o;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/luggage/scanner/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "darkCornerMask", "Landroid/widget/ImageView;", "flashSwitcher", "Lcom/tencent/luggage/scanner/scanner/ui/widget/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "", "isTitleTimerCancelled", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanTips", "Landroid/widget/TextView;", "scanTitle", "showTitle", "titleTimer", "Ljava/util/Timer;", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "animateShowScanTips", "cancelTitleAnimation", "cancelTitleTimer", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", "init", "initTitleTimer", "onFlashStatusChanged", "onPreviewReady", "isSwitchTab", "onScanSuccess", "onViewReady", "release", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanTips", "tips", "", "setScanTitle", "title", "setShowTitle", "showGalleryButton", "showScanTips", "startTitleAnimation", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends RelativeLayout
{
  public static final b.a a = new b.a(null);
  private TextView b;
  private TextView c;
  private ImageView d;
  private ScannerFlashSwitcher e;
  private View f;
  private View.OnClickListener g;
  private View.OnClickListener h;
  private Timer i;
  private boolean j;
  private boolean k;
  private boolean l = true;
  
  public b(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public b(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131625231, (ViewGroup)this);
    View localView = paramContext.findViewById(2131445288);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.scan_title)");
    this.b = ((TextView)localView);
    localView = paramContext.findViewById(2131445287);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.scan_tip_tv)");
    this.c = ((TextView)localView);
    localView = paramContext.findViewById(2131431577);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.dark_corner_mask)");
    this.d = ((ImageView)localView);
    localView = paramContext.findViewById(2131445293);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.scanner_flash_switcher)");
    this.e = ((ScannerFlashSwitcher)localView);
    paramContext = paramContext.findViewById(2131445524);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "view.findViewById(R.id.select_from_gallery)");
    this.f = paramContext;
    paramContext = this.f;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new b.c(this));
    paramContext = this.e;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("flashSwitcher");
    }
    paramContext.setOnClickListener((View.OnClickListener)new b.d(this));
  }
  
  private final void a(View paramView, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramView != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.setListener(null);
        if (localViewPropertyAnimator != null) {
          localViewPropertyAnimator.cancel();
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
  
  private final void d()
  {
    o.f("Luggage.ScanSharedMaskView", "alvinluo initTitleTimer");
    e();
    this.i = new Timer();
    Timer localTimer = this.i;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new b.e(this), 2000L);
    }
    this.j = false;
  }
  
  private final void d(boolean paramBoolean)
  {
    TextView localTextView = this.c;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localTextView.setVisibility(m);
  }
  
  private final void e()
  {
    this.j = true;
    Timer localTimer = this.i;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  private final void e(boolean paramBoolean)
  {
    View localView = this.f;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
    }
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localView.setVisibility(m);
  }
  
  private final void f()
  {
    o.d("Luggage.ScanSharedMaskView", "alvinluo cancelTitleAnimation");
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    e();
  }
  
  private final void f(boolean paramBoolean)
  {
    o.d("Luggage.ScanSharedMaskView", "alvinluo startTitleAnimation show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    float f2 = 1.0F;
    float f1;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    ((TextView)localObject).setAlpha(f1);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    ((TextView)localObject).setVisibility(0);
    if (paramBoolean) {
      f1 = f2;
    } else {
      f1 = 0.0F;
    }
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    ((TextView)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, getResources().getColor(2131165201));
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(f1);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
        if (localObject != null) {
          ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new b.f(this, paramBoolean));
        }
      }
    }
  }
  
  private final void g(boolean paramBoolean)
  {
    o.e("Luggage.ScanSharedMaskView", "alvinluo animateScanTips show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      return;
    }
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    if ((((TextView)localObject).getVisibility() == 0) && (paramBoolean)) {
      return;
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    if ((((TextView)localObject).getVisibility() != 0) && (!paramBoolean)) {
      return;
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    float f2 = 0.0F;
    float f1;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    ((TextView)localObject).setAlpha(f1);
    d(true);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      f1 = f2;
      if (paramBoolean) {
        f1 = 1.0F;
      }
      localObject = ((ViewPropertyAnimator)localObject).alpha(f1);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new b.b(this, paramBoolean));
          if (localObject != null) {
            ((ViewPropertyAnimator)localObject).start();
          }
        }
      }
    }
  }
  
  public void a()
  {
    o.d("Luggage.ScanSharedMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    TextView localTextView;
    if (!this.l)
    {
      d(this.k ^ true);
      localTextView = this.b;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
      }
      localTextView.setVisibility(8);
    }
    else
    {
      d(false);
      localTextView = this.b;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
      }
      if (localTextView.getVisibility() != 0)
      {
        localTextView = this.b;
        if (localTextView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
        }
        localTextView.setVisibility(8);
        localTextView = this.b;
        if (localTextView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
        }
        localTextView.setAlpha(1.0F);
        f();
        f(true);
      }
      else
      {
        localTextView = this.b;
        if (localTextView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
        }
        localTextView.setAlpha(1.0F);
        f();
        d();
      }
    }
    d(true);
    e(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Object localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
      }
      if (((View)localObject).getVisibility() == 0)
      {
        localObject = this.f;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
        }
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setListener(null);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)new LinearInterpolator());
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener(null);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
                  if (localObject != null) {
                    ((ViewPropertyAnimator)localObject).start();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    o.f("Luggage.ScanSharedMaskView", "alvinluo onScanSuccess");
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
    }
    localObject = ((View)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).setListener(null);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)new LinearInterpolator());
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setUpdateListener(null);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
    }
    f();
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    ((TextView)localObject).setVisibility(8);
    this.k = false;
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("flashSwitcher");
    }
    ((ScannerFlashSwitcher)localObject).setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    o.d("Luggage.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.k != paramBoolean)
    {
      this.k = paramBoolean;
      g(paramBoolean ^ true);
    }
  }
  
  public void c()
  {
    o.e("Luggage.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    e();
  }
  
  public void c(boolean paramBoolean)
  {
    o.f("Luggage.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(getAlpha()) });
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
  
  @NotNull
  public ScannerFlashSwitcher getFlashSwitcherView()
  {
    ScannerFlashSwitcher localScannerFlashSwitcher = this.e;
    if (localScannerFlashSwitcher == null) {
      Intrinsics.throwUninitializedPropertyAccessException("flashSwitcher");
    }
    return localScannerFlashSwitcher;
  }
  
  @NotNull
  public View getGalleryButton()
  {
    View localView = this.f;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
    }
    return localView;
  }
  
  @NotNull
  public TextView getScanTipsView()
  {
    TextView localTextView = this.c;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    return localTextView;
  }
  
  @NotNull
  public TextView getScanTitleView()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    return localTextView;
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    o.e("Luggage.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.k = paramBoolean;
  }
  
  public void setOnFlashSwitcherClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "onClickListener");
    this.h = paramOnClickListener;
  }
  
  public void setOnGalleryClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "onClickListener");
    this.g = paramOnClickListener;
    paramOnClickListener = this.f;
    if (paramOnClickListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
    }
    paramOnClickListener.setOnClickListener(this.g);
  }
  
  public void setScanTips(@Nullable String paramString)
  {
    TextView localTextView = this.c;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTips");
    }
    localTextView.setText((CharSequence)paramString);
  }
  
  public void setScanTitle(@Nullable String paramString)
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
    }
    localTextView.setText((CharSequence)paramString);
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */