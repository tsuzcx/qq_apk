package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty;
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior
  extends ExpandableTransformationBehavior
{
  private final Rect a = new Rect();
  private final RectF b = new RectF();
  private final RectF c = new RectF();
  private final int[] d = new int[2];
  private float e;
  private float f;
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private float a(@NonNull View paramView1, @NonNull View paramView2, @NonNull Positioning paramPositioning)
  {
    RectF localRectF1 = this.b;
    RectF localRectF2 = this.c;
    b(paramView1, localRectF1);
    a(paramView2, localRectF2);
    int i = paramPositioning.a & 0x7;
    float f1;
    float f2;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 5)
        {
          f1 = 0.0F;
          break label114;
        }
        f1 = localRectF2.right;
        f2 = localRectF1.right;
      }
      else
      {
        f1 = localRectF2.left;
        f2 = localRectF1.left;
      }
    }
    else
    {
      f1 = localRectF2.centerX();
      f2 = localRectF1.centerX();
    }
    f1 -= f2;
    label114:
    return f1 + paramPositioning.b;
  }
  
  private float a(@NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull MotionTiming paramMotionTiming, float paramFloat1, float paramFloat2)
  {
    long l1 = paramMotionTiming.a();
    long l2 = paramMotionTiming.b();
    paramFabTransformationSpec = paramFabTransformationSpec.a.b("expansion");
    float f1 = (float)(paramFabTransformationSpec.a() + paramFabTransformationSpec.b() + 17L - l1) / (float)l2;
    return AnimationUtils.a(paramFloat1, paramFloat2, paramMotionTiming.c().getInterpolation(f1));
  }
  
  @NonNull
  private Pair<MotionTiming, MotionTiming> a(float paramFloat1, float paramFloat2, boolean paramBoolean, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec)
  {
    Object localObject;
    MotionTiming localMotionTiming;
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F))
    {
      if (((paramBoolean) && (paramFloat2 < 0.0F)) || ((!paramBoolean) && (paramFloat2 > 0.0F)))
      {
        localObject = paramFabTransformationSpec.a.b("translationXCurveUpwards");
        localMotionTiming = paramFabTransformationSpec.a.b("translationYCurveUpwards");
        paramFabTransformationSpec = (FabTransformationBehavior.FabTransformationSpec)localObject;
        localObject = localMotionTiming;
      }
      else
      {
        localObject = paramFabTransformationSpec.a.b("translationXCurveDownwards");
        localMotionTiming = paramFabTransformationSpec.a.b("translationYCurveDownwards");
        paramFabTransformationSpec = (FabTransformationBehavior.FabTransformationSpec)localObject;
        localObject = localMotionTiming;
      }
    }
    else
    {
      localMotionTiming = paramFabTransformationSpec.a.b("translationXLinear");
      localObject = paramFabTransformationSpec.a.b("translationYLinear");
      paramFabTransformationSpec = localMotionTiming;
    }
    return new Pair(paramFabTransformationSpec, localObject);
  }
  
  @Nullable
  private ViewGroup a(@NonNull View paramView)
  {
    View localView = paramView.findViewById(R.id.P);
    if (localView != null) {
      return b(localView);
    }
    if ((!(paramView instanceof TransformationChildLayout)) && (!(paramView instanceof TransformationChildCard))) {
      return b(paramView);
    }
    return b(((ViewGroup)paramView).getChildAt(0));
  }
  
  private void a(View paramView, long paramLong, int paramInt1, int paramInt2, float paramFloat, @NonNull List<Animator> paramList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramLong > 0L))
    {
      paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      paramView.setStartDelay(0L);
      paramView.setDuration(paramLong);
      paramList.add(paramView);
    }
  }
  
  private void a(View paramView, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, float paramFloat, @NonNull List<Animator> paramList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramLong1 += paramLong2;
      if (paramLong1 < paramLong3)
      {
        paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
        paramView.setStartDelay(paramLong1);
        paramView.setDuration(paramLong3 - paramLong1);
        paramList.add(paramView);
      }
    }
  }
  
  private void a(@NonNull View paramView, RectF paramRectF)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = this.d;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private void a(@NonNull View paramView1, @NonNull View paramView2, boolean paramBoolean, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull List<Animator> paramList)
  {
    float f1 = a(paramView1, paramView2, paramFabTransformationSpec.b);
    float f2 = b(paramView1, paramView2, paramFabTransformationSpec.b);
    paramFabTransformationSpec = a(f1, f2, paramBoolean, paramFabTransformationSpec);
    paramView2 = (MotionTiming)paramFabTransformationSpec.first;
    paramFabTransformationSpec = (MotionTiming)paramFabTransformationSpec.second;
    Object localObject = View.TRANSLATION_X;
    if (!paramBoolean) {
      f1 = this.e;
    }
    localObject = ObjectAnimator.ofFloat(paramView1, (Property)localObject, new float[] { f1 });
    Property localProperty = View.TRANSLATION_Y;
    if (paramBoolean) {
      f1 = f2;
    } else {
      f1 = this.f;
    }
    paramView1 = ObjectAnimator.ofFloat(paramView1, localProperty, new float[] { f1 });
    paramView2.a((Animator)localObject);
    paramFabTransformationSpec.a(paramView1);
    paramList.add(localObject);
    paramList.add(paramView1);
  }
  
  private void a(@NonNull View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, float paramFloat1, float paramFloat2, @NonNull List<Animator> paramList, @NonNull List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof CircularRevealWidget)) {
      return;
    }
    CircularRevealWidget localCircularRevealWidget = (CircularRevealWidget)paramView2;
    float f2 = c(paramView1, paramView2, paramFabTransformationSpec.b);
    float f3 = d(paramView1, paramView2, paramFabTransformationSpec.b);
    ((FloatingActionButton)paramView1).a(this.a);
    float f1 = this.a.width() / 2.0F;
    MotionTiming localMotionTiming = paramFabTransformationSpec.a.b("expansion");
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        localCircularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(f2, f3, f1));
      }
      if (paramBoolean2) {
        f1 = localCircularRevealWidget.getRevealInfo().c;
      }
      paramView1 = CircularRevealCompat.a(localCircularRevealWidget, f2, f3, MathUtils.a(f2, f3, 0.0F, 0.0F, paramFloat1, paramFloat2));
      paramView1.addListener(new FabTransformationBehavior.4(this, localCircularRevealWidget));
      a(paramView2, localMotionTiming.a(), (int)f2, (int)f3, f1, paramList);
    }
    else
    {
      paramFloat1 = localCircularRevealWidget.getRevealInfo().c;
      paramView1 = CircularRevealCompat.a(localCircularRevealWidget, f2, f3, f1);
      long l = localMotionTiming.a();
      int i = (int)f2;
      int j = (int)f3;
      a(paramView2, l, i, j, paramFloat1, paramList);
      a(paramView2, localMotionTiming.a(), localMotionTiming.b(), paramFabTransformationSpec.a.a(), i, j, f1, paramList);
    }
    localMotionTiming.a(paramView1);
    paramList.add(paramView1);
    paramList1.add(CircularRevealCompat.a(localCircularRevealWidget));
  }
  
  @TargetApi(21)
  private void a(View paramView1, @NonNull View paramView2, boolean paramBoolean1, boolean paramBoolean2, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    float f1 = ViewCompat.getElevation(paramView2) - ViewCompat.getElevation(paramView1);
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setTranslationZ(-f1);
      }
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { -f1 });
    }
    paramFabTransformationSpec.a.b("elevation").a(paramView1);
    paramList.add(paramView1);
  }
  
  private void a(@NonNull View paramView1, @NonNull View paramView2, boolean paramBoolean1, boolean paramBoolean2, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull List<Animator> paramList, List<Animator.AnimatorListener> paramList1, @NonNull RectF paramRectF)
  {
    float f1 = a(paramView1, paramView2, paramFabTransformationSpec.b);
    float f2 = b(paramView1, paramView2, paramFabTransformationSpec.b);
    paramView1 = a(f1, f2, paramBoolean1, paramFabTransformationSpec);
    MotionTiming localMotionTiming1 = (MotionTiming)paramView1.first;
    MotionTiming localMotionTiming2 = (MotionTiming)paramView1.second;
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        paramView2.setTranslationX(-f1);
        paramView2.setTranslationY(-f2);
      }
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F });
      paramList1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      a(paramView2, paramFabTransformationSpec, localMotionTiming1, localMotionTiming2, -f1, -f2, 0.0F, 0.0F, paramRectF);
      paramView2 = paramList1;
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { -f1 });
      paramView2 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { -f2 });
    }
    localMotionTiming1.a(paramView1);
    localMotionTiming2.a(paramView2);
    paramList.add(paramView1);
    paramList.add(paramView2);
  }
  
  private void a(@NonNull View paramView, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull MotionTiming paramMotionTiming1, @NonNull MotionTiming paramMotionTiming2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NonNull RectF paramRectF)
  {
    paramFloat1 = a(paramFabTransformationSpec, paramMotionTiming1, paramFloat1, paramFloat3);
    paramFloat2 = a(paramFabTransformationSpec, paramMotionTiming2, paramFloat2, paramFloat4);
    paramMotionTiming1 = this.a;
    paramView.getWindowVisibleDisplayFrame(paramMotionTiming1);
    paramFabTransformationSpec = this.b;
    paramFabTransformationSpec.set(paramMotionTiming1);
    paramMotionTiming1 = this.c;
    a(paramView, paramMotionTiming1);
    paramMotionTiming1.offset(paramFloat1, paramFloat2);
    paramMotionTiming1.intersect(paramFabTransformationSpec);
    paramRectF.set(paramMotionTiming1);
  }
  
  private float b(@NonNull View paramView1, @NonNull View paramView2, @NonNull Positioning paramPositioning)
  {
    RectF localRectF1 = this.b;
    RectF localRectF2 = this.c;
    b(paramView1, localRectF1);
    a(paramView2, localRectF2);
    int i = paramPositioning.a & 0x70;
    float f1;
    float f2;
    if (i != 16)
    {
      if (i != 48)
      {
        if (i != 80)
        {
          f1 = 0.0F;
          break label117;
        }
        f1 = localRectF2.bottom;
        f2 = localRectF1.bottom;
      }
      else
      {
        f1 = localRectF2.top;
        f2 = localRectF1.top;
      }
    }
    else
    {
      f1 = localRectF2.centerY();
      f2 = localRectF1.centerY();
    }
    f1 -= f2;
    label117:
    return f1 + paramPositioning.c;
  }
  
  @Nullable
  private ViewGroup b(View paramView)
  {
    if ((paramView instanceof ViewGroup)) {
      return (ViewGroup)paramView;
    }
    return null;
  }
  
  private void b(@NonNull View paramView, @NonNull RectF paramRectF)
  {
    a(paramView, paramRectF);
    paramRectF.offset(this.e, this.f);
  }
  
  private void b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull List<Animator> paramList, @NonNull List<Animator.AnimatorListener> paramList1)
  {
    if ((paramView2 instanceof CircularRevealWidget))
    {
      if (!(paramView1 instanceof ImageView)) {
        return;
      }
      CircularRevealWidget localCircularRevealWidget = (CircularRevealWidget)paramView2;
      Drawable localDrawable = ((ImageView)paramView1).getDrawable();
      if (localDrawable == null) {
        return;
      }
      localDrawable.mutate();
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          localDrawable.setAlpha(255);
        }
        paramView1 = ObjectAnimator.ofInt(localDrawable, DrawableAlphaProperty.a, new int[] { 0 });
      }
      else
      {
        paramView1 = ObjectAnimator.ofInt(localDrawable, DrawableAlphaProperty.a, new int[] { 255 });
      }
      paramView1.addUpdateListener(new FabTransformationBehavior.2(this, paramView2));
      paramFabTransformationSpec.a.b("iconFade").a(paramView1);
      paramList.add(paramView1);
      paramList1.add(new FabTransformationBehavior.3(this, localCircularRevealWidget, localDrawable));
    }
  }
  
  private float c(@NonNull View paramView1, @NonNull View paramView2, @NonNull Positioning paramPositioning)
  {
    RectF localRectF1 = this.b;
    RectF localRectF2 = this.c;
    b(paramView1, localRectF1);
    a(paramView2, localRectF2);
    localRectF2.offset(-a(paramView1, paramView2, paramPositioning), 0.0F);
    return localRectF1.centerX() - localRectF2.left;
  }
  
  private int c(@NonNull View paramView)
  {
    ColorStateList localColorStateList = ViewCompat.getBackgroundTintList(paramView);
    if (localColorStateList != null) {
      return localColorStateList.getColorForState(paramView.getDrawableState(), localColorStateList.getDefaultColor());
    }
    return 0;
  }
  
  private void c(@NonNull View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof CircularRevealWidget)) {
      return;
    }
    paramView2 = (CircularRevealWidget)paramView2;
    int i = c(paramView1);
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setCircularRevealScrimColor(i);
      }
      paramView1 = ObjectAnimator.ofInt(paramView2, CircularRevealWidget.CircularRevealScrimColorProperty.a, new int[] { 0xFFFFFF & i });
    }
    else
    {
      paramView1 = ObjectAnimator.ofInt(paramView2, CircularRevealWidget.CircularRevealScrimColorProperty.a, new int[] { i });
    }
    paramView1.setEvaluator(ArgbEvaluatorCompat.a());
    paramFabTransformationSpec.a.b("color").a(paramView1);
    paramList.add(paramView1);
  }
  
  private float d(@NonNull View paramView1, @NonNull View paramView2, @NonNull Positioning paramPositioning)
  {
    RectF localRectF1 = this.b;
    RectF localRectF2 = this.c;
    b(paramView1, localRectF1);
    a(paramView2, localRectF2);
    localRectF2.offset(0.0F, -b(paramView1, paramView2, paramPositioning));
    return localRectF1.centerY() - localRectF2.top;
  }
  
  private void d(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, @NonNull FabTransformationBehavior.FabTransformationSpec paramFabTransformationSpec, @NonNull List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof ViewGroup)) {
      return;
    }
    if (((paramView2 instanceof CircularRevealWidget)) && (CircularRevealHelper.a == 0)) {
      return;
    }
    paramView1 = a(paramView2);
    if (paramView1 == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        ChildrenAlphaProperty.a.set(paramView1, Float.valueOf(0.0F));
      }
      paramView1 = ObjectAnimator.ofFloat(paramView1, ChildrenAlphaProperty.a, new float[] { 1.0F });
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView1, ChildrenAlphaProperty.a, new float[] { 0.0F });
    }
    paramFabTransformationSpec.a.b("contentFade").a(paramView1);
    paramList.add(paramView1);
  }
  
  protected abstract FabTransformationBehavior.FabTransformationSpec a(Context paramContext, boolean paramBoolean);
  
  @NonNull
  protected AnimatorSet b(@NonNull View paramView1, @NonNull View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramView2.getContext(), paramBoolean1);
    if (paramBoolean1)
    {
      this.e = paramView1.getTranslationX();
      this.f = paramView1.getTranslationY();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Build.VERSION.SDK_INT >= 21) {
      a(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationBehavior.FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    }
    RectF localRectF = this.b;
    a(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationBehavior.FabTransformationSpec)localObject, localArrayList1, localArrayList2, localRectF);
    float f1 = localRectF.width();
    float f2 = localRectF.height();
    a(paramView1, paramView2, paramBoolean1, (FabTransformationBehavior.FabTransformationSpec)localObject, localArrayList1);
    b(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationBehavior.FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    a(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationBehavior.FabTransformationSpec)localObject, f1, f2, localArrayList1, localArrayList2);
    c(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationBehavior.FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    d(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationBehavior.FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    localObject = new AnimatorSet();
    AnimatorSetCompat.a((AnimatorSet)localObject, localArrayList1);
    ((AnimatorSet)localObject).addListener(new FabTransformationBehavior.1(this, paramBoolean1, paramView2, paramView1));
    int i = 0;
    int j = localArrayList2.size();
    while (i < j)
    {
      ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)localArrayList2.get(i));
      i += 1;
    }
    return localObject;
  }
  
  @CallSuper
  public boolean layoutDependsOn(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2)
  {
    if (paramView1.getVisibility() != 8)
    {
      boolean bool3 = paramView2 instanceof FloatingActionButton;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
        if (i != 0)
        {
          bool1 = bool2;
          if (i != paramView1.getId()) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
  }
  
  @CallSuper
  public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.dodgeInsetEdges == 0) {
      paramLayoutParams.dodgeInsetEdges = 80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */