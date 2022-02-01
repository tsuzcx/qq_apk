package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private static final int n = R.style.jdField_j_of_type_Int;
  float jdField_a_of_type_Float = 0.5F;
  int jdField_a_of_type_Int;
  @Nullable
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  @Nullable
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private final ViewDragHelper.Callback jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper$Callback = new BottomSheetBehavior.4(this);
  @Nullable
  ViewDragHelper jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper;
  private BottomSheetBehavior<V>.SettleRunnable jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$SettleRunnable = null;
  private MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  @Nullable
  WeakReference<V> jdField_a_of_type_JavaLangRefWeakReference;
  @NonNull
  private final ArrayList<BottomSheetBehavior.BottomSheetCallback> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @Nullable
  private Map<View, Integer> jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float = -1.0F;
  int jdField_b_of_type_Int;
  @Nullable
  WeakReference<View> jdField_b_of_type_JavaLangRefWeakReference;
  boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 4;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = true;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int m;
  private int o;
  private int p;
  private int q;
  private int r = -1;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_l_of_type_Int = paramContext.getResources().getDimensionPixelSize(R.dimen.af);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.h);
    this.jdField_f_of_type_Boolean = localTypedArray.hasValue(R.styleable.aa);
    boolean bool = localTypedArray.hasValue(R.styleable.Q);
    if (bool) {
      a(paramContext, paramAttributeSet, bool, MaterialResources.a(paramContext, localTypedArray, R.styleable.Q));
    } else {
      a(paramContext, paramAttributeSet, bool);
    }
    d();
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_b_of_type_Float = localTypedArray.getDimension(R.styleable.P, -1.0F);
    }
    paramAttributeSet = localTypedArray.peekValue(R.styleable.W);
    if ((paramAttributeSet != null) && (paramAttributeSet.data == -1)) {
      a(paramAttributeSet.data);
    } else {
      a(localTypedArray.getDimensionPixelSize(R.styleable.W, -1));
    }
    b(localTypedArray.getBoolean(R.styleable.V, false));
    e(localTypedArray.getBoolean(R.styleable.Z, false));
    a(localTypedArray.getBoolean(R.styleable.T, true));
    c(localTypedArray.getBoolean(R.styleable.Y, false));
    d(localTypedArray.getBoolean(R.styleable.R, true));
    c(localTypedArray.getInt(R.styleable.X, 0));
    a(localTypedArray.getFloat(R.styleable.U, 0.5F));
    paramAttributeSet = localTypedArray.peekValue(R.styleable.S);
    if ((paramAttributeSet != null) && (paramAttributeSet.type == 16)) {
      b(paramAttributeSet.data);
    } else {
      b(localTypedArray.getDimensionPixelOffset(R.styleable.S, 0));
    }
    localTypedArray.recycle();
    this.jdField_c_of_type_Float = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private float a()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker == null) {
      return 0.0F;
    }
    localVelocityTracker.computeCurrentVelocity(1000, this.jdField_c_of_type_Float);
    return this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(this.jdField_h_of_type_Int);
  }
  
  private int a(V paramV, @StringRes int paramInt1, int paramInt2)
  {
    return ViewCompat.addAccessibilityAction(paramV, paramV.getResources().getString(paramInt1), a(paramInt2));
  }
  
  private AccessibilityViewCommand a(int paramInt)
  {
    return new BottomSheetBehavior.5(this, paramInt);
  }
  
  @NonNull
  public static <V extends View> BottomSheetBehavior<V> a(@NonNull V paramV)
  {
    paramV = paramV.getLayoutParams();
    if ((paramV instanceof CoordinatorLayout.LayoutParams))
    {
      paramV = ((CoordinatorLayout.LayoutParams)paramV).getBehavior();
      if ((paramV instanceof BottomSheetBehavior)) {
        return (BottomSheetBehavior)paramV;
      }
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  private void a()
  {
    int i1 = c();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_Int = Math.max(this.jdField_g_of_type_Int - i1, this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_d_of_type_Int = (this.jdField_g_of_type_Int - i1);
  }
  
  private void a(@NonNull Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    a(paramContext, paramAttributeSet, paramBoolean, null);
  }
  
  private void a(@NonNull Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean, @Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = ShapeAppearanceModel.a(paramContext, paramAttributeSet, R.attr.jdField_f_of_type_Int, n).a();
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(paramContext);
      if ((paramBoolean) && (paramColorStateList != null))
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(paramColorStateList);
        return;
      }
      paramAttributeSet = new TypedValue();
      paramContext.getTheme().resolveAttribute(16842801, paramAttributeSet, true);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTint(paramAttributeSet.data);
    }
  }
  
  private void a(@NonNull View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!b()) && (!this.jdField_e_of_type_Boolean)) {
      ViewUtils.a(paramView, new BottomSheetBehavior.3(this));
    }
  }
  
  private void a(V paramV, AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat, int paramInt)
  {
    ViewCompat.replaceAccessibilityAction(paramV, paramAccessibilityActionCompat, null, a(paramInt));
  }
  
  private void a(@NonNull BottomSheetBehavior.SavedState paramSavedState)
  {
    int i1 = this.jdField_i_of_type_Int;
    if (i1 == 0) {
      return;
    }
    if ((i1 == -1) || ((i1 & 0x1) == 1)) {
      this.jdField_j_of_type_Int = paramSavedState.jdField_b_of_type_Int;
    }
    i1 = this.jdField_i_of_type_Int;
    if ((i1 == -1) || ((i1 & 0x2) == 2)) {
      this.jdField_c_of_type_Boolean = paramSavedState.jdField_a_of_type_Boolean;
    }
    i1 = this.jdField_i_of_type_Int;
    if ((i1 == -1) || ((i1 & 0x4) == 4)) {
      this.jdField_a_of_type_Boolean = paramSavedState.jdField_b_of_type_Boolean;
    }
    i1 = this.jdField_i_of_type_Int;
    if ((i1 == -1) || ((i1 & 0x8) == 8)) {
      this.jdField_i_of_type_Boolean = paramSavedState.jdField_c_of_type_Boolean;
    }
  }
  
  private void b()
  {
    this.jdField_c_of_type_Int = ((int)(this.jdField_g_of_type_Int * (1.0F - this.jdField_a_of_type_Float)));
  }
  
  private int c()
  {
    if (this.jdField_e_of_type_Boolean) {
      return Math.min(Math.max(this.jdField_k_of_type_Int, this.jdField_g_of_type_Int - this.jdField_f_of_type_Int * 9 / 16), this.p);
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      int i1 = this.m;
      if (i1 > 0) {
        return Math.max(this.jdField_j_of_type_Int, i1 + this.jdField_l_of_type_Int);
      }
    }
    return this.jdField_j_of_type_Int;
  }
  
  private void c()
  {
    this.jdField_h_of_type_Int = -1;
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new BottomSheetBehavior.2(this));
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ViewCompat.removeAccessibilityAction((View)localObject, 524288);
    ViewCompat.removeAccessibilityAction((View)localObject, 262144);
    ViewCompat.removeAccessibilityAction((View)localObject, 1048576);
    int i1 = this.r;
    if (i1 != -1) {
      ViewCompat.removeAccessibilityAction((View)localObject, i1);
    }
    int i2 = this.jdField_e_of_type_Int;
    i1 = 6;
    if (i2 != 6) {
      this.r = a((View)localObject, R.string.jdField_a_of_type_Int, 6);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Int != 5)) {
      a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
    }
    i2 = this.jdField_e_of_type_Int;
    if (i2 != 3)
    {
      if (i2 != 4)
      {
        if (i2 != 6) {
          return;
        }
        a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
      }
      if (this.jdField_c_of_type_Boolean) {
        i1 = 3;
      }
      a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i1);
      return;
    }
    if (this.jdField_c_of_type_Boolean) {
      i1 = 4;
    }
    a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i1);
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      a();
      if (this.jdField_e_of_type_Int == 4)
      {
        View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localView != null)
        {
          if (paramBoolean)
          {
            g(this.jdField_e_of_type_Int);
            return;
          }
          localView.requestLayout();
        }
      }
    }
  }
  
  private void g(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView == null) {
      return;
    }
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (ViewCompat.isAttachedToWindow(localView)))
    {
      localView.post(new BottomSheetBehavior.1(this, localView, paramInt));
      return;
    }
    a(localView, paramInt);
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = ((View)((WeakReference)localObject).get()).getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int i2 = ((CoordinatorLayout)localObject).getChildCount();
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean)) {
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = new HashMap(i2);
      } else {
        return;
      }
    }
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = ((CoordinatorLayout)localObject).getChildAt(i1);
      if (localView != this.jdField_a_of_type_JavaLangRefWeakReference.get()) {
        if (paramBoolean)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            this.jdField_a_of_type_JavaUtilMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          if (this.jdField_d_of_type_Boolean) {
            ViewCompat.setImportantForAccessibility(localView, 4);
          }
        }
        else if (this.jdField_d_of_type_Boolean)
        {
          Map localMap = this.jdField_a_of_type_JavaUtilMap;
          if ((localMap != null) && (localMap.containsKey(localView))) {
            ViewCompat.setImportantForAccessibility(localView, ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localView)).intValue());
          }
        }
      }
      i1 += 1;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilMap = null;
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sendAccessibilityEvent(8);
    }
  }
  
  private void h(int paramInt)
  {
    if (paramInt == 2) {
      return;
    }
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.jdField_h_of_type_Boolean != bool)
    {
      this.jdField_h_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable != null)
      {
        ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (localValueAnimator != null)
        {
          if (localValueAnimator.isRunning())
          {
            this.jdField_a_of_type_AndroidAnimationValueAnimator.reverse();
            return;
          }
          float f1;
          if (bool) {
            f1 = 0.0F;
          } else {
            f1 = 1.0F;
          }
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setFloatValues(new float[] { 1.0F - f1, f1 });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  @VisibleForTesting
  View a(View paramView)
  {
    if (ViewCompat.isNestedScrollingEnabled(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      int i2 = paramView.getChildCount();
      while (i1 < i2)
      {
        View localView = a(paramView.getChildAt(i1));
        if (localView != null) {
          return localView;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F))
    {
      this.jdField_a_of_type_Float = paramFloat;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        b();
      }
      return;
    }
    throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    int i1 = 1;
    if (paramInt == -1)
    {
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = true;
        paramInt = i1;
        break label63;
      }
    }
    else {
      if ((this.jdField_e_of_type_Boolean) || (this.jdField_j_of_type_Int != paramInt)) {
        break label47;
      }
    }
    paramInt = 0;
    break label63;
    label47:
    this.jdField_e_of_type_Boolean = false;
    this.jdField_j_of_type_Int = Math.max(0, paramInt);
    paramInt = i1;
    label63:
    if (paramInt != 0) {
      f(paramBoolean);
    }
  }
  
  void a(@NonNull View paramView, int paramInt)
  {
    int i1;
    if (paramInt == 4)
    {
      i1 = this.jdField_d_of_type_Int;
    }
    else if (paramInt == 6)
    {
      i1 = this.jdField_c_of_type_Int;
      if (this.jdField_c_of_type_Boolean)
      {
        int i2 = this.jdField_b_of_type_Int;
        if (i1 <= i2)
        {
          i1 = i2;
          paramInt = 3;
          break label84;
        }
      }
    }
    else if (paramInt == 3)
    {
      i1 = a();
    }
    else
    {
      if ((!this.jdField_a_of_type_Boolean) || (paramInt != 5)) {
        break label93;
      }
      i1 = this.jdField_g_of_type_Int;
    }
    label84:
    a(paramView, paramInt, i1, false);
    return;
    label93:
    paramView = new StringBuilder();
    paramView.append("Illegal state argument: ");
    paramView.append(paramInt);
    throw new IllegalArgumentException(paramView.toString());
  }
  
  void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper;
    if ((localObject != null) && (paramBoolean ? ((ViewDragHelper)localObject).settleCapturedViewAt(paramView.getLeft(), paramInt2) : ((ViewDragHelper)localObject).smoothSlideViewTo(paramView, paramView.getLeft(), paramInt2))) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      e(2);
      h(paramInt1);
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$SettleRunnable == null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$SettleRunnable = new BottomSheetBehavior.SettleRunnable(this, paramView, paramInt1);
      }
      if (!BottomSheetBehavior.SettleRunnable.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$SettleRunnable))
      {
        localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$SettleRunnable;
        ((BottomSheetBehavior.SettleRunnable)localObject).jdField_a_of_type_Int = paramInt1;
        ViewCompat.postOnAnimation(paramView, (Runnable)localObject);
        BottomSheetBehavior.SettleRunnable.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$SettleRunnable, true);
        return;
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$SettleRunnable.jdField_a_of_type_Int = paramInt1;
      return;
    }
    e(paramInt1);
  }
  
  public void a(@NonNull BottomSheetBehavior.BottomSheetCallback paramBottomSheetCallback)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramBottomSheetCallback)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramBottomSheetCallback);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      a();
    }
    int i1;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_e_of_type_Int == 6)) {
      i1 = 3;
    } else {
      i1 = this.jdField_e_of_type_Int;
    }
    e(i1);
    e();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(@NonNull View paramView, float paramFloat)
  {
    if (this.jdField_i_of_type_Boolean) {
      return true;
    }
    if (paramView.getTop() < this.jdField_d_of_type_Int) {
      return false;
    }
    int i1 = c();
    return Math.abs(paramView.getTop() + paramFloat * 0.1F - this.jdField_d_of_type_Int) / i1 > 0.5F;
  }
  
  public int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    throw new IllegalArgumentException("offset must be greater than or equal to 0");
  }
  
  public void b(@NonNull BottomSheetBehavior.BottomSheetCallback paramBottomSheetCallback)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramBottomSheetCallback);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((!paramBoolean) && (this.jdField_e_of_type_Int == 5)) {
        d(4);
      }
      e();
    }
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void c(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void d(int paramInt)
  {
    if (paramInt == this.jdField_e_of_type_Int) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((this.jdField_a_of_type_Boolean) && (paramInt == 5))) {
        this.jdField_e_of_type_Int = paramInt;
      }
      return;
    }
    g(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  void e(int paramInt)
  {
    if (this.jdField_e_of_type_Int == paramInt) {
      return;
    }
    this.jdField_e_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    int i1 = 0;
    if (paramInt == 3) {
      g(true);
    } else if ((paramInt == 6) || (paramInt == 5) || (paramInt == 4)) {
      g(false);
    }
    h(paramInt);
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((BottomSheetBehavior.BottomSheetCallback)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).a((View)localObject, paramInt);
      i1 += 1;
    }
    e();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  void f(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localView != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = this.jdField_d_of_type_Int;
      float f2;
      if ((paramInt <= i1) && (i1 != a()))
      {
        i1 = this.jdField_d_of_type_Int;
        f2 = i1 - paramInt;
        f1 = i1 - a();
      }
      else
      {
        i1 = this.jdField_d_of_type_Int;
        f2 = i1 - paramInt;
        f1 = this.jdField_g_of_type_Int - i1;
      }
      float f1 = f2 / f1;
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((BottomSheetBehavior.BottomSheetCallback)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(localView, f1);
        paramInt += 1;
      }
    }
  }
  
  public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    super.onAttachedToLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper = null;
  }
  
  public void onDetachedFromLayoutParams()
  {
    super.onDetachedFromLayoutParams();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper = null;
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    boolean bool1 = paramV.isShown();
    boolean bool2 = false;
    if ((bool1) && (this.jdField_j_of_type_Boolean))
    {
      int i1 = paramMotionEvent.getActionMasked();
      if (i1 == 0) {
        c();
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      Object localObject2 = null;
      if (i1 != 0)
      {
        if ((i1 == 1) || (i1 == 3))
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_h_of_type_Int = -1;
          if (this.jdField_k_of_type_Boolean)
          {
            this.jdField_k_of_type_Boolean = false;
            return false;
          }
        }
      }
      else
      {
        int i2 = (int)paramMotionEvent.getX();
        this.q = ((int)paramMotionEvent.getY());
        if (this.jdField_e_of_type_Int != 2)
        {
          localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
          if (localObject1 != null) {
            localObject1 = (View)((WeakReference)localObject1).get();
          } else {
            localObject1 = null;
          }
          if ((localObject1 != null) && (paramCoordinatorLayout.isPointInChildBounds((View)localObject1, i2, this.q)))
          {
            this.jdField_h_of_type_Int = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.jdField_b_of_type_Boolean = true;
          }
        }
        if ((this.jdField_h_of_type_Int == -1) && (!paramCoordinatorLayout.isPointInChildBounds(paramV, i2, this.q))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.jdField_k_of_type_Boolean = bool1;
      }
      if (!this.jdField_k_of_type_Boolean)
      {
        paramV = this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper;
        if ((paramV != null) && (paramV.shouldInterceptTouchEvent(paramMotionEvent))) {
          return true;
        }
      }
      Object localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
      paramV = localObject2;
      if (localObject1 != null) {
        paramV = (View)((WeakReference)localObject1).get();
      }
      bool1 = bool2;
      if (i1 == 2)
      {
        bool1 = bool2;
        if (paramV != null)
        {
          bool1 = bool2;
          if (!this.jdField_k_of_type_Boolean)
          {
            bool1 = bool2;
            if (this.jdField_e_of_type_Int != 1)
            {
              bool1 = bool2;
              if (!paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
              {
                bool1 = bool2;
                if (this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper != null)
                {
                  bool1 = bool2;
                  if (Math.abs(this.q - paramMotionEvent.getY()) > this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper.getTouchSlop()) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    this.jdField_k_of_type_Boolean = true;
    return false;
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    if ((ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      this.jdField_k_of_type_Int = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.jdField_j_of_type_Int);
      a(paramV);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramV);
      if (this.jdField_f_of_type_Boolean)
      {
        localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
        if (localMaterialShapeDrawable != null) {
          ViewCompat.setBackground(paramV, localMaterialShapeDrawable);
        }
      }
      MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
      if (localMaterialShapeDrawable != null)
      {
        float f2 = this.jdField_b_of_type_Float;
        float f1 = f2;
        if (f2 == -1.0F) {
          f1 = ViewCompat.getElevation(paramV);
        }
        localMaterialShapeDrawable.r(f1);
        boolean bool;
        if (this.jdField_e_of_type_Int == 3) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_h_of_type_Boolean = bool;
        localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
        if (this.jdField_h_of_type_Boolean) {
          f1 = 0.0F;
        } else {
          f1 = 1.0F;
        }
        localMaterialShapeDrawable.p(f1);
      }
      e();
      if (ViewCompat.getImportantForAccessibility(paramV) == 0) {
        ViewCompat.setImportantForAccessibility(paramV, 1);
      }
    }
    if (this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper == null) {
      this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper = ViewDragHelper.create(paramCoordinatorLayout, this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper$Callback);
    }
    int i1 = paramV.getTop();
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
    this.jdField_f_of_type_Int = paramCoordinatorLayout.getWidth();
    this.jdField_g_of_type_Int = paramCoordinatorLayout.getHeight();
    this.p = paramV.getHeight();
    this.jdField_b_of_type_Int = Math.max(0, this.jdField_g_of_type_Int - this.p);
    b();
    a();
    paramInt = this.jdField_e_of_type_Int;
    if (paramInt == 3)
    {
      ViewCompat.offsetTopAndBottom(paramV, a());
    }
    else if (paramInt == 6)
    {
      ViewCompat.offsetTopAndBottom(paramV, this.jdField_c_of_type_Int);
    }
    else if ((this.jdField_a_of_type_Boolean) && (paramInt == 5))
    {
      ViewCompat.offsetTopAndBottom(paramV, this.jdField_g_of_type_Int);
    }
    else
    {
      paramInt = this.jdField_e_of_type_Int;
      if (paramInt == 4) {
        ViewCompat.offsetTopAndBottom(paramV, this.jdField_d_of_type_Int);
      } else if ((paramInt == 1) || (paramInt == 2)) {
        ViewCompat.offsetTopAndBottom(paramV, i1 - paramV.getTop());
      }
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(a(paramV));
    return true;
  }
  
  public boolean onNestedPreFling(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localWeakReference != null)
    {
      bool1 = bool2;
      if (paramView == localWeakReference.get()) {
        if (this.jdField_e_of_type_Int == 3)
        {
          bool1 = bool2;
          if (!super.onNestedPreFling(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onNestedPreScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {
      return;
    }
    paramCoordinatorLayout = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout = (View)paramCoordinatorLayout.get();
    } else {
      paramCoordinatorLayout = null;
    }
    if (paramView != paramCoordinatorLayout) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt3 < a())
      {
        paramArrayOfInt[1] = (paramInt1 - a());
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        e(3);
      }
      else
      {
        if (!this.jdField_j_of_type_Boolean) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
        e(1);
      }
    }
    else if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)))
    {
      int i1 = this.jdField_d_of_type_Int;
      if ((paramInt3 > i1) && (!this.jdField_a_of_type_Boolean))
      {
        paramArrayOfInt[1] = (paramInt1 - i1);
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        e(4);
      }
      else
      {
        if (!this.jdField_j_of_type_Boolean) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
        e(1);
      }
    }
    f(paramV.getTop());
    this.o = paramInt2;
    this.jdField_l_of_type_Boolean = true;
  }
  
  public void onNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt) {}
  
  public void onRestoreInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull Parcelable paramParcelable)
  {
    paramParcelable = (BottomSheetBehavior.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramCoordinatorLayout, paramV, paramParcelable.getSuperState());
    a(paramParcelable);
    if ((paramParcelable.jdField_a_of_type_Int != 1) && (paramParcelable.jdField_a_of_type_Int != 2))
    {
      this.jdField_e_of_type_Int = paramParcelable.jdField_a_of_type_Int;
      return;
    }
    this.jdField_e_of_type_Int = 4;
  }
  
  @NonNull
  public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV)
  {
    return new BottomSheetBehavior.SavedState(super.onSaveInstanceState(paramCoordinatorLayout, paramV), this);
  }
  
  public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.o = 0;
    this.jdField_l_of_type_Boolean = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public void onStopNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt)
  {
    paramInt = paramV.getTop();
    int i2 = a();
    int i1 = 3;
    if (paramInt == i2)
    {
      e(3);
      return;
    }
    paramCoordinatorLayout = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((paramCoordinatorLayout != null) && (paramView == paramCoordinatorLayout.get()))
    {
      if (!this.jdField_l_of_type_Boolean) {
        return;
      }
      if (this.o > 0)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          paramInt = this.jdField_b_of_type_Int;
          break label354;
        }
        i2 = paramV.getTop();
        paramInt = this.jdField_c_of_type_Int;
        if (i2 <= paramInt)
        {
          paramInt = this.jdField_a_of_type_Int;
          break label354;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Boolean) && (a(paramV, a())))
        {
          paramInt = this.jdField_g_of_type_Int;
          i1 = 5;
          break label354;
        }
        if (this.o == 0)
        {
          paramInt = paramV.getTop();
          if (this.jdField_c_of_type_Boolean)
          {
            if (Math.abs(paramInt - this.jdField_b_of_type_Int) < Math.abs(paramInt - this.jdField_d_of_type_Int))
            {
              paramInt = this.jdField_b_of_type_Int;
              break label354;
            }
            paramInt = this.jdField_d_of_type_Int;
          }
          else
          {
            i2 = this.jdField_c_of_type_Int;
            if (paramInt < i2)
            {
              if (paramInt < Math.abs(paramInt - this.jdField_d_of_type_Int))
              {
                paramInt = this.jdField_a_of_type_Int;
                break label354;
              }
              paramInt = this.jdField_c_of_type_Int;
              break label338;
            }
            if (Math.abs(paramInt - i2) < Math.abs(paramInt - this.jdField_d_of_type_Int))
            {
              paramInt = this.jdField_c_of_type_Int;
              break label338;
            }
            paramInt = this.jdField_d_of_type_Int;
          }
        }
        else
        {
          if (!this.jdField_c_of_type_Boolean) {
            break label303;
          }
        }
      }
      for (paramInt = this.jdField_d_of_type_Int;; paramInt = this.jdField_d_of_type_Int)
      {
        i1 = 4;
        break;
        label303:
        paramInt = paramV.getTop();
        if (Math.abs(paramInt - this.jdField_c_of_type_Int) < Math.abs(paramInt - this.jdField_d_of_type_Int))
        {
          paramInt = this.jdField_c_of_type_Int;
          label338:
          i1 = 6;
          break;
        }
      }
      label354:
      a(paramV, i1, paramInt, false);
      this.jdField_l_of_type_Boolean = false;
    }
  }
  
  public boolean onTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if ((this.jdField_e_of_type_Int == 1) && (i1 == 0)) {
      return true;
    }
    paramCoordinatorLayout = this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
    }
    if (i1 == 0) {
      c();
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if ((this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper != null) && (i1 == 2) && (!this.jdField_k_of_type_Boolean) && (Math.abs(this.q - paramMotionEvent.getY()) > this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper.getTouchSlop())) {
      this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper.captureChildView(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    return this.jdField_k_of_type_Boolean ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */