package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.Shapeable;
import java.util.Map;

@RequiresApi(21)
public final class MaterialContainerTransform
  extends Transition
{
  private static final String a = "MaterialContainerTransform";
  private static final String[] b = { "materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance" };
  private static final MaterialContainerTransform.ProgressThresholdsGroup c = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.0F, 0.25F), new MaterialContainerTransform.ProgressThresholds(0.0F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.0F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.75F), null);
  private static final MaterialContainerTransform.ProgressThresholdsGroup d = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.6F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.0F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.3F, 0.9F), null);
  private static final MaterialContainerTransform.ProgressThresholdsGroup e = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.1F, 0.4F), new MaterialContainerTransform.ProgressThresholds(0.1F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.1F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.1F, 0.9F), null);
  private static final MaterialContainerTransform.ProgressThresholdsGroup f = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.6F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.2F, 0.9F), null);
  private boolean A;
  private float B;
  private float C;
  private boolean g;
  private boolean h;
  @IdRes
  private int i;
  @IdRes
  private int j;
  @IdRes
  private int k;
  @ColorInt
  private int l;
  @ColorInt
  private int m;
  @ColorInt
  private int n;
  @ColorInt
  private int o;
  private int p;
  private int q;
  private int r;
  @Nullable
  private View s;
  @Nullable
  private View t;
  @Nullable
  private ShapeAppearanceModel u;
  @Nullable
  private ShapeAppearanceModel v;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds w;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds x;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds y;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds z;
  
  public MaterialContainerTransform()
  {
    boolean bool = false;
    this.g = false;
    this.h = false;
    this.i = 16908290;
    this.j = -1;
    this.k = -1;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = 1375731712;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    }
    this.A = bool;
    this.B = -1.0F;
    this.C = -1.0F;
    setInterpolator(AnimationUtils.b);
  }
  
  private static float a(float paramFloat, View paramView)
  {
    if (paramFloat != -1.0F) {
      return paramFloat;
    }
    return ViewCompat.getElevation(paramView);
  }
  
  @StyleRes
  private static int a(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(new int[] { R.attr.af });
    int i1 = paramContext.getResourceId(0, -1);
    paramContext.recycle();
    return i1;
  }
  
  private static RectF a(View paramView1, @Nullable View paramView2, float paramFloat1, float paramFloat2)
  {
    if (paramView2 != null)
    {
      paramView1 = TransitionUtils.c(paramView2);
      paramView1.offset(paramFloat1, paramFloat2);
      return paramView1;
    }
    return new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
  }
  
  private static ShapeAppearanceModel a(@NonNull View paramView, @NonNull RectF paramRectF, @Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    return TransitionUtils.a(a(paramView, paramShapeAppearanceModel), paramRectF);
  }
  
  private static ShapeAppearanceModel a(@NonNull View paramView, @Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramShapeAppearanceModel != null) {
      return paramShapeAppearanceModel;
    }
    if ((paramView.getTag(R.id.R) instanceof ShapeAppearanceModel)) {
      return (ShapeAppearanceModel)paramView.getTag(R.id.R);
    }
    paramShapeAppearanceModel = paramView.getContext();
    int i1 = a(paramShapeAppearanceModel);
    if (i1 != -1) {
      return ShapeAppearanceModel.a(paramShapeAppearanceModel, i1, 0).a();
    }
    if ((paramView instanceof Shapeable)) {
      return ((Shapeable)paramView).getShapeAppearanceModel();
    }
    return ShapeAppearanceModel.a().a();
  }
  
  private MaterialContainerTransform.ProgressThresholdsGroup a(boolean paramBoolean, MaterialContainerTransform.ProgressThresholdsGroup paramProgressThresholdsGroup1, MaterialContainerTransform.ProgressThresholdsGroup paramProgressThresholdsGroup2)
  {
    if (!paramBoolean) {
      paramProgressThresholdsGroup1 = paramProgressThresholdsGroup2;
    }
    return new MaterialContainerTransform.ProgressThresholdsGroup((MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.w, MaterialContainerTransform.ProgressThresholdsGroup.a(paramProgressThresholdsGroup1)), (MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.x, MaterialContainerTransform.ProgressThresholdsGroup.b(paramProgressThresholdsGroup1)), (MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.y, MaterialContainerTransform.ProgressThresholdsGroup.c(paramProgressThresholdsGroup1)), (MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.z, MaterialContainerTransform.ProgressThresholdsGroup.d(paramProgressThresholdsGroup1)), null);
  }
  
  private static void a(@NonNull TransitionValues paramTransitionValues, @Nullable View paramView, @IdRes int paramInt, @Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != -1)
    {
      paramTransitionValues.view = TransitionUtils.a(paramTransitionValues.view, paramInt);
    }
    else if (paramView != null)
    {
      paramTransitionValues.view = paramView;
    }
    else if ((paramTransitionValues.view.getTag(R.id.R) instanceof View))
    {
      paramView = (View)paramTransitionValues.view.getTag(R.id.R);
      paramTransitionValues.view.setTag(R.id.R, null);
      paramTransitionValues.view = paramView;
    }
    View localView = paramTransitionValues.view;
    if ((ViewCompat.isLaidOut(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      if (localView.getParent() == null) {
        paramView = TransitionUtils.a(localView);
      } else {
        paramView = TransitionUtils.c(localView);
      }
      paramTransitionValues.values.put("materialContainerTransition:bounds", paramView);
      paramTransitionValues.values.put("materialContainerTransition:shapeAppearance", a(localView, paramView, paramShapeAppearanceModel));
    }
  }
  
  private boolean a(@NonNull RectF paramRectF1, @NonNull RectF paramRectF2)
  {
    int i1 = this.p;
    boolean bool = false;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2) {
          return false;
        }
        paramRectF1 = new StringBuilder();
        paramRectF1.append("Invalid transition direction: ");
        paramRectF1.append(this.p);
        throw new IllegalArgumentException(paramRectF1.toString());
      }
      return true;
    }
    if (TransitionUtils.a(paramRectF2) > TransitionUtils.a(paramRectF1)) {
      bool = true;
    }
    return bool;
  }
  
  private MaterialContainerTransform.ProgressThresholdsGroup b(boolean paramBoolean)
  {
    PathMotion localPathMotion = getPathMotion();
    if ((!(localPathMotion instanceof ArcMotion)) && (!(localPathMotion instanceof MaterialArcMotion))) {
      return a(paramBoolean, c, d);
    }
    return a(paramBoolean, e, f);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues, this.t, this.k, this.v);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues, this.s, this.j, this.u);
  }
  
  @Nullable
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues1 != null)
    {
      if (paramTransitionValues2 == null) {
        return null;
      }
      RectF localRectF1 = (RectF)paramTransitionValues1.values.get("materialContainerTransition:bounds");
      ShapeAppearanceModel localShapeAppearanceModel1 = (ShapeAppearanceModel)paramTransitionValues1.values.get("materialContainerTransition:shapeAppearance");
      if ((localRectF1 != null) && (localShapeAppearanceModel1 != null))
      {
        RectF localRectF2 = (RectF)paramTransitionValues2.values.get("materialContainerTransition:bounds");
        ShapeAppearanceModel localShapeAppearanceModel2 = (ShapeAppearanceModel)paramTransitionValues2.values.get("materialContainerTransition:shapeAppearance");
        if ((localRectF2 != null) && (localShapeAppearanceModel2 != null))
        {
          View localView = paramTransitionValues1.view;
          paramTransitionValues2 = paramTransitionValues2.view;
          if (paramTransitionValues2.getParent() != null) {
            paramViewGroup = paramTransitionValues2;
          } else {
            paramViewGroup = localView;
          }
          if (this.i == paramViewGroup.getId())
          {
            localObject = (View)paramViewGroup.getParent();
            paramTransitionValues1 = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject;
          }
          else
          {
            paramViewGroup = TransitionUtils.b(paramViewGroup, this.i);
            paramTransitionValues1 = null;
          }
          Object localObject = TransitionUtils.c(paramViewGroup);
          float f1 = -((RectF)localObject).left;
          float f2 = -((RectF)localObject).top;
          paramTransitionValues1 = a(paramViewGroup, paramTransitionValues1, f1, f2);
          localRectF1.offset(f1, f2);
          localRectF2.offset(f1, f2);
          boolean bool = a(localRectF1, localRectF2);
          localObject = new MaterialContainerTransform.TransitionDrawable(getPathMotion(), localView, localRectF1, localShapeAppearanceModel1, a(this.B, localView), paramTransitionValues2, localRectF2, localShapeAppearanceModel2, a(this.C, paramTransitionValues2), this.l, this.m, this.n, this.o, bool, this.A, FadeModeEvaluators.a(this.q, bool), FitModeEvaluators.a(this.r, bool, localRectF1, localRectF2), b(bool), this.g, null);
          ((MaterialContainerTransform.TransitionDrawable)localObject).setBounds(Math.round(paramTransitionValues1.left), Math.round(paramTransitionValues1.top), Math.round(paramTransitionValues1.right), Math.round(paramTransitionValues1.bottom));
          paramTransitionValues1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          paramTransitionValues1.addUpdateListener(new MaterialContainerTransform.1(this, (MaterialContainerTransform.TransitionDrawable)localObject));
          addListener(new MaterialContainerTransform.2(this, paramViewGroup, (MaterialContainerTransform.TransitionDrawable)localObject, localView, paramTransitionValues2));
          return paramTransitionValues1;
        }
        Log.w(a, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
      }
      Log.w(a, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    }
    return null;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransform
 * JD-Core Version:    0.7.0.1
 */