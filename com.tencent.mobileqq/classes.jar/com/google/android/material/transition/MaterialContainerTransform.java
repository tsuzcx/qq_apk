package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.Shapeable;
import java.util.Map;

public final class MaterialContainerTransform
  extends Transition
{
  private static final MaterialContainerTransform.ProgressThresholdsGroup jdField_a_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.0F, 0.25F), new MaterialContainerTransform.ProgressThresholds(0.0F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.0F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.75F), null);
  private static final String jdField_a_of_type_JavaLangString = "MaterialContainerTransform";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance" };
  private static final MaterialContainerTransform.ProgressThresholdsGroup jdField_b_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.6F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.0F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.3F, 0.9F), null);
  private static final MaterialContainerTransform.ProgressThresholdsGroup jdField_c_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.1F, 0.4F), new MaterialContainerTransform.ProgressThresholds(0.1F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.1F, 1.0F), new MaterialContainerTransform.ProgressThresholds(0.1F, 0.9F), null);
  private static final MaterialContainerTransform.ProgressThresholdsGroup jdField_d_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup = new MaterialContainerTransform.ProgressThresholdsGroup(new MaterialContainerTransform.ProgressThresholds(0.6F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.0F, 0.9F), new MaterialContainerTransform.ProgressThresholds(0.2F, 0.9F), null);
  private float jdField_a_of_type_Float;
  @IdRes
  private int jdField_a_of_type_Int;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds jdField_a_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  @IdRes
  private int jdField_b_of_type_Int;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  @Nullable
  private ShapeAppearanceModel jdField_b_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds jdField_b_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds;
  private boolean jdField_b_of_type_Boolean;
  @IdRes
  private int jdField_c_of_type_Int;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds jdField_c_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds;
  private boolean jdField_c_of_type_Boolean;
  @ColorInt
  private int jdField_d_of_type_Int;
  @Nullable
  private MaterialContainerTransform.ProgressThresholds jdField_d_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds;
  @ColorInt
  private int e;
  @ColorInt
  private int f;
  @ColorInt
  private int g;
  private int h;
  private int i;
  private int j;
  
  public MaterialContainerTransform()
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 16908290;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.f = 0;
    this.g = 1375731712;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
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
    paramContext = paramContext.obtainStyledAttributes(new int[] { R.attr.U });
    int k = paramContext.getResourceId(0, -1);
    paramContext.recycle();
    return k;
  }
  
  private static RectF a(View paramView1, @Nullable View paramView2, float paramFloat1, float paramFloat2)
  {
    if (paramView2 != null)
    {
      paramView1 = TransitionUtils.b(paramView2);
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
    int k = a(paramShapeAppearanceModel);
    if (k != -1) {
      return ShapeAppearanceModel.a(paramShapeAppearanceModel, k, 0).a();
    }
    if ((paramView instanceof Shapeable)) {
      return ((Shapeable)paramView).a();
    }
    return ShapeAppearanceModel.a().a();
  }
  
  private MaterialContainerTransform.ProgressThresholdsGroup a(boolean paramBoolean)
  {
    PathMotion localPathMotion = getPathMotion();
    if ((!(localPathMotion instanceof ArcMotion)) && (!(localPathMotion instanceof MaterialArcMotion))) {
      return a(paramBoolean, jdField_a_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup, jdField_b_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup);
    }
    return a(paramBoolean, jdField_c_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup, jdField_d_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholdsGroup);
  }
  
  private MaterialContainerTransform.ProgressThresholdsGroup a(boolean paramBoolean, MaterialContainerTransform.ProgressThresholdsGroup paramProgressThresholdsGroup1, MaterialContainerTransform.ProgressThresholdsGroup paramProgressThresholdsGroup2)
  {
    if (!paramBoolean) {
      paramProgressThresholdsGroup1 = paramProgressThresholdsGroup2;
    }
    return new MaterialContainerTransform.ProgressThresholdsGroup((MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds, MaterialContainerTransform.ProgressThresholdsGroup.a(paramProgressThresholdsGroup1)), (MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.jdField_b_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds, MaterialContainerTransform.ProgressThresholdsGroup.b(paramProgressThresholdsGroup1)), (MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.jdField_c_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds, MaterialContainerTransform.ProgressThresholdsGroup.c(paramProgressThresholdsGroup1)), (MaterialContainerTransform.ProgressThresholds)TransitionUtils.a(this.jdField_d_of_type_ComGoogleAndroidMaterialTransitionMaterialContainerTransform$ProgressThresholds, MaterialContainerTransform.ProgressThresholdsGroup.d(paramProgressThresholdsGroup1)), null);
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
        paramView = TransitionUtils.b(localView);
      }
      paramTransitionValues.values.put("materialContainerTransition:bounds", paramView);
      paramTransitionValues.values.put("materialContainerTransition:shapeAppearance", a(localView, paramView, paramShapeAppearanceModel));
    }
  }
  
  private boolean a(@NonNull RectF paramRectF1, @NonNull RectF paramRectF2)
  {
    int k = this.h;
    boolean bool = false;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2) {
          return false;
        }
        paramRectF1 = new StringBuilder();
        paramRectF1.append("Invalid transition direction: ");
        paramRectF1.append(this.h);
        throw new IllegalArgumentException(paramRectF1.toString());
      }
      return true;
    }
    if (TransitionUtils.a(paramRectF2) > TransitionUtils.a(paramRectF1)) {
      bool = true;
    }
    return bool;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues, this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int, this.jdField_b_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
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
          if (this.jdField_a_of_type_Int == paramViewGroup.getId())
          {
            localObject = (View)paramViewGroup.getParent();
            paramTransitionValues1 = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject;
          }
          else
          {
            paramViewGroup = TransitionUtils.b(paramViewGroup, this.jdField_a_of_type_Int);
            paramTransitionValues1 = null;
          }
          Object localObject = TransitionUtils.b(paramViewGroup);
          float f1 = -((RectF)localObject).left;
          float f2 = -((RectF)localObject).top;
          paramTransitionValues1 = a(paramViewGroup, paramTransitionValues1, f1, f2);
          localRectF1.offset(f1, f2);
          localRectF2.offset(f1, f2);
          boolean bool = a(localRectF1, localRectF2);
          localObject = new MaterialContainerTransform.TransitionDrawable(getPathMotion(), localView, localRectF1, localShapeAppearanceModel1, a(this.jdField_a_of_type_Float, localView), paramTransitionValues2, localRectF2, localShapeAppearanceModel2, a(this.jdField_b_of_type_Float, paramTransitionValues2), this.jdField_d_of_type_Int, this.e, this.f, this.g, bool, this.jdField_c_of_type_Boolean, FadeModeEvaluators.a(this.i, bool), FitModeEvaluators.a(this.j, bool, localRectF1, localRectF2), a(bool), this.jdField_a_of_type_Boolean, null);
          ((MaterialContainerTransform.TransitionDrawable)localObject).setBounds(Math.round(paramTransitionValues1.left), Math.round(paramTransitionValues1.top), Math.round(paramTransitionValues1.right), Math.round(paramTransitionValues1.bottom));
          paramTransitionValues1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          paramTransitionValues1.addUpdateListener(new MaterialContainerTransform.1(this, (MaterialContainerTransform.TransitionDrawable)localObject));
          addListener(new MaterialContainerTransform.2(this, paramViewGroup, (MaterialContainerTransform.TransitionDrawable)localObject, localView, paramTransitionValues2));
          return paramTransitionValues1;
        }
        Log.w(jdField_a_of_type_JavaLangString, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
      }
      Log.w(jdField_a_of_type_JavaLangString, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    }
    return null;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.MaterialContainerTransform
 * JD-Core Version:    0.7.0.1
 */