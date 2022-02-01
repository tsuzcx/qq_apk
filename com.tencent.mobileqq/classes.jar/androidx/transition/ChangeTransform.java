package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final Property<ChangeTransform.PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY;
  private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
  private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
  private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
  private static final String PROPNAME_PARENT = "android:changeTransform:parent";
  private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
  private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
  private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
  private static final Property<ChangeTransform.PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY;
  private static final String[] sTransitionProperties;
  private boolean mReparent = true;
  private Matrix mTempMatrix = new Matrix();
  boolean mUseOverlay = true;
  
  static
  {
    boolean bool = false;
    sTransitionProperties = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    NON_TRANSLATIONS_PROPERTY = new ChangeTransform.1([F.class, "nonTranslations");
    TRANSLATIONS_PROPERTY = new ChangeTransform.2(PointF.class, "translations");
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    }
    SUPPORTS_VIEW_REMOVAL_SUPPRESSION = bool;
  }
  
  public ChangeTransform() {}
  
  @SuppressLint({"RestrictedApi"})
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.CHANGE_TRANSFORM);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    this.mUseOverlay = TypedArrayUtils.getNamedBoolean(paramContext, paramAttributeSet, "reparentWithOverlay", 1, true);
    this.mReparent = TypedArrayUtils.getNamedBoolean(paramContext, paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramTransitionValues.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new ChangeTransform.Transforms(localView);
    paramTransitionValues.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject != null) && (!((Matrix)localObject).isIdentity())) {
      localObject = new Matrix((Matrix)localObject);
    } else {
      localObject = null;
    }
    paramTransitionValues.values.put("android:changeTransform:matrix", localObject);
    if (this.mReparent)
    {
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      ViewUtils.transformMatrixToGlobal(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramTransitionValues.values.put("android:changeTransform:parentMatrix", localObject);
      paramTransitionValues.values.put("android:changeTransform:intermediateMatrix", localView.getTag(R.id.transition_transform));
      paramTransitionValues.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(R.id.parent_matrix));
    }
  }
  
  private void createGhostView(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    View localView = paramTransitionValues2.view;
    Object localObject = new Matrix((Matrix)paramTransitionValues2.values.get("android:changeTransform:parentMatrix"));
    ViewUtils.transformMatrixToLocal(paramViewGroup, (Matrix)localObject);
    localObject = GhostViewUtils.addGhost(localView, paramViewGroup, (Matrix)localObject);
    if (localObject == null) {
      return;
    }
    ((GhostView)localObject).reserveEndViewTransition((ViewGroup)paramTransitionValues1.values.get("android:changeTransform:parent"), paramTransitionValues1.view);
    for (paramViewGroup = this; paramViewGroup.mParent != null; paramViewGroup = paramViewGroup.mParent) {}
    paramViewGroup.addListener(new ChangeTransform.GhostListener(localView, (GhostView)localObject));
    if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION)
    {
      if (paramTransitionValues1.view != paramTransitionValues2.view) {
        ViewUtils.setTransitionAlpha(paramTransitionValues1.view, 0.0F);
      }
      ViewUtils.setTransitionAlpha(localView, 1.0F);
    }
  }
  
  private ObjectAnimator createTransformAnimator(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2, boolean paramBoolean)
  {
    paramTransitionValues1 = (Matrix)paramTransitionValues1.values.get("android:changeTransform:matrix");
    Object localObject2 = (Matrix)paramTransitionValues2.values.get("android:changeTransform:matrix");
    Object localObject1 = paramTransitionValues1;
    if (paramTransitionValues1 == null) {
      localObject1 = MatrixUtils.IDENTITY_MATRIX;
    }
    paramTransitionValues1 = (TransitionValues)localObject2;
    if (localObject2 == null) {
      paramTransitionValues1 = MatrixUtils.IDENTITY_MATRIX;
    }
    if (((Matrix)localObject1).equals(paramTransitionValues1)) {
      return null;
    }
    localObject2 = (ChangeTransform.Transforms)paramTransitionValues2.values.get("android:changeTransform:transforms");
    paramTransitionValues2 = paramTransitionValues2.view;
    setIdentityTransforms(paramTransitionValues2);
    Object localObject3 = new float[9];
    ((Matrix)localObject1).getValues((float[])localObject3);
    float[] arrayOfFloat = new float[9];
    paramTransitionValues1.getValues(arrayOfFloat);
    localObject1 = new ChangeTransform.PathAnimatorMatrix(paramTransitionValues2, (float[])localObject3);
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][] { localObject3, arrayOfFloat });
    localObject3 = getPathMotion().getPath(localObject3[2], localObject3[5], arrayOfFloat[2], arrayOfFloat[5]);
    localObject3 = ObjectAnimator.ofPropertyValuesHolder(localObject1, new PropertyValuesHolder[] { localPropertyValuesHolder, PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, (Path)localObject3) });
    paramTransitionValues1 = new ChangeTransform.3(this, paramBoolean, paramTransitionValues1, paramTransitionValues2, (ChangeTransform.Transforms)localObject2, (ChangeTransform.PathAnimatorMatrix)localObject1);
    ((ObjectAnimator)localObject3).addListener(paramTransitionValues1);
    AnimatorUtils.addPauseListener((Animator)localObject3, paramTransitionValues1);
    return localObject3;
  }
  
  private boolean parentsMatch(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    if ((isValidTarget(paramViewGroup1)) && (isValidTarget(paramViewGroup2)))
    {
      paramViewGroup1 = getMatchedTransitionValues(paramViewGroup1, true);
      if ((paramViewGroup1 == null) || (paramViewGroup2 != paramViewGroup1.view)) {}
    }
    else
    {
      while (paramViewGroup1 == paramViewGroup2) {
        return true;
      }
    }
    return false;
  }
  
  static void setIdentityTransforms(View paramView)
  {
    setTransforms(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private void setMatricesForParent(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    Matrix localMatrix1 = (Matrix)paramTransitionValues2.values.get("android:changeTransform:parentMatrix");
    paramTransitionValues2.view.setTag(R.id.parent_matrix, localMatrix1);
    Matrix localMatrix2 = this.mTempMatrix;
    localMatrix2.reset();
    localMatrix1.invert(localMatrix2);
    localMatrix1 = (Matrix)paramTransitionValues1.values.get("android:changeTransform:matrix");
    paramTransitionValues2 = localMatrix1;
    if (localMatrix1 == null)
    {
      paramTransitionValues2 = new Matrix();
      paramTransitionValues1.values.put("android:changeTransform:matrix", paramTransitionValues2);
    }
    paramTransitionValues2.postConcat((Matrix)paramTransitionValues1.values.get("android:changeTransform:parentMatrix"));
    paramTransitionValues2.postConcat(localMatrix2);
  }
  
  static void setTransforms(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    ViewCompat.setTranslationZ(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
    if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
      ((ViewGroup)paramTransitionValues.view.getParent()).startViewTransition(paramTransitionValues.view);
    }
  }
  
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null) && (paramTransitionValues1.values.containsKey("android:changeTransform:parent")) && (paramTransitionValues2.values.containsKey("android:changeTransform:parent")))
    {
      ViewGroup localViewGroup = (ViewGroup)paramTransitionValues1.values.get("android:changeTransform:parent");
      Object localObject = (ViewGroup)paramTransitionValues2.values.get("android:changeTransform:parent");
      boolean bool;
      if ((this.mReparent) && (!parentsMatch(localViewGroup, (ViewGroup)localObject))) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = (Matrix)paramTransitionValues1.values.get("android:changeTransform:intermediateMatrix");
      if (localObject != null) {
        paramTransitionValues1.values.put("android:changeTransform:matrix", localObject);
      }
      localObject = (Matrix)paramTransitionValues1.values.get("android:changeTransform:intermediateParentMatrix");
      if (localObject != null) {
        paramTransitionValues1.values.put("android:changeTransform:parentMatrix", localObject);
      }
      if (bool) {
        setMatricesForParent(paramTransitionValues1, paramTransitionValues2);
      }
      localObject = createTransformAnimator(paramTransitionValues1, paramTransitionValues2, bool);
      if ((bool) && (localObject != null) && (this.mUseOverlay))
      {
        createGhostView(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
        return localObject;
      }
      if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
        localViewGroup.endViewTransition(paramTransitionValues1.view);
      }
      return localObject;
    }
    return null;
  }
  
  public boolean getReparent()
  {
    return this.mReparent;
  }
  
  public boolean getReparentWithOverlay()
  {
    return this.mUseOverlay;
  }
  
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
  
  public void setReparent(boolean paramBoolean)
  {
    this.mReparent = paramBoolean;
  }
  
  public void setReparentWithOverlay(boolean paramBoolean)
  {
    this.mUseOverlay = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */