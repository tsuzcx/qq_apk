package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  @NonNull
  static final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new BaseTransientBottomBar.1());
  private static final String jdField_a_of_type_JavaLangString;
  private static final boolean jdField_a_of_type_Boolean;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @NonNull
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  @Nullable
  private final AccessibilityManager jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager;
  private BaseTransientBottomBar.Behavior jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$Behavior;
  @NonNull
  protected final BaseTransientBottomBar.SnackbarBaseLayout a;
  @NonNull
  private final ContentViewCallback jdField_a_of_type_ComGoogleAndroidMaterialSnackbarContentViewCallback;
  @NonNull
  SnackbarManager.Callback jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$Callback;
  @RequiresApi(29)
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private List<BaseTransientBottomBar.BaseCallback<B>> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  
  static
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
    jdField_a_of_type_ArrayOfInt = new int[] { R.attr.J };
    jdField_a_of_type_JavaLangString = BaseTransientBottomBar.class.getSimpleName();
  }
  
  private int a()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] + this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getHeight();
  }
  
  private ValueAnimator a(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.a);
    paramVarArgs.addUpdateListener(new BaseTransientBottomBar.13(this));
    return paramVarArgs;
  }
  
  private void a(CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    BaseTransientBottomBar.Behavior localBehavior = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$Behavior;
    Object localObject = localBehavior;
    if (localBehavior == null) {
      localObject = a();
    }
    if ((localObject instanceof BaseTransientBottomBar.Behavior)) {
      BaseTransientBottomBar.Behavior.a((BaseTransientBottomBar.Behavior)localObject, this);
    }
    ((SwipeDismissBehavior)localObject).a(new BaseTransientBottomBar.9(this));
    paramLayoutParams.setBehavior((CoordinatorLayout.Behavior)localObject);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      paramLayoutParams.insetEdge = 80;
    }
  }
  
  @RequiresApi(17)
  private int b()
  {
    WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  private ValueAnimator b(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.d);
    paramVarArgs.addUpdateListener(new BaseTransientBottomBar.14(this));
    return paramVarArgs;
  }
  
  private int c()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return 0;
    }
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    localObject = new int[2];
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
    return localObject[1] + this.jdField_a_of_type_AndroidViewViewGroup.getHeight() - i;
  }
  
  private int d()
  {
    int j = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getLayoutParams();
    int i = j;
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      i = j + ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin;
    }
    return i;
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.a() == 1)
    {
      e(paramInt);
      return;
    }
    f(paramInt);
  }
  
  private boolean d()
  {
    return (this.d > 0) && (!this.jdField_b_of_type_Boolean) && (e());
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getLayoutParams();
    if (((localObject instanceof ViewGroup.MarginLayoutParams)) && (this.jdField_a_of_type_AndroidGraphicsRect != null))
    {
      int i;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        i = this.e;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (this.jdField_a_of_type_AndroidGraphicsRect.bottom + i);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_Int);
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.requestLayout();
      if ((Build.VERSION.SDK_INT >= 29) && (d()))
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    Log.w(jdField_a_of_type_JavaLangString, "Unable to update margins because layout params are not MarginLayoutParams");
  }
  
  private void e(int paramInt)
  {
    ValueAnimator localValueAnimator = a(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(75L);
    localValueAnimator.addListener(new BaseTransientBottomBar.12(this, paramInt));
    localValueAnimator.start();
  }
  
  private boolean e()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getLayoutParams();
    return ((localLayoutParams instanceof CoordinatorLayout.LayoutParams)) && ((((CoordinatorLayout.LayoutParams)localLayoutParams).getBehavior() instanceof SwipeDismissBehavior));
  }
  
  private void f()
  {
    if (b())
    {
      c();
      return;
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getParent() != null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.setVisibility(0);
    }
    d();
  }
  
  private void f(int paramInt)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, d() });
    localValueAnimator.setInterpolator(AnimationUtils.b);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new BaseTransientBottomBar.17(this, paramInt));
    localValueAnimator.addUpdateListener(new BaseTransientBottomBar.18(this));
    localValueAnimator.start();
  }
  
  private void g()
  {
    ValueAnimator localValueAnimator1 = a(new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator2 = b(new float[] { 0.8F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    localAnimatorSet.setDuration(150L);
    localAnimatorSet.addListener(new BaseTransientBottomBar.11(this));
    localAnimatorSet.start();
  }
  
  private void h()
  {
    int i = d();
    if (jdField_a_of_type_Boolean) {
      ViewCompat.offsetTopAndBottom(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout, i);
    } else {
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.setTranslationY(i);
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { i, 0 });
    localValueAnimator.setInterpolator(AnimationUtils.b);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new BaseTransientBottomBar.15(this));
    localValueAnimator.addUpdateListener(new BaseTransientBottomBar.16(this, i));
    localValueAnimator.start();
  }
  
  @NonNull
  protected SwipeDismissBehavior<? extends View> a()
  {
    return new BaseTransientBottomBar.Behavior();
  }
  
  public void a()
  {
    a(3);
  }
  
  protected void a(int paramInt)
  {
    SnackbarManager.a().a(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$Callback, paramInt);
  }
  
  public boolean a()
  {
    return SnackbarManager.a().a(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$Callback);
  }
  
  final void b()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.a(new BaseTransientBottomBar.7(this));
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getParent() == null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getLayoutParams();
      if ((localLayoutParams instanceof CoordinatorLayout.LayoutParams)) {
        a((CoordinatorLayout.LayoutParams)localLayoutParams);
      }
      this.e = c();
      e();
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout);
    }
    if (ViewCompat.isLaidOut(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout))
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.a(new BaseTransientBottomBar.8(this));
  }
  
  final void b(int paramInt)
  {
    if ((b()) && (this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getVisibility() == 0))
    {
      d(paramInt);
      return;
    }
    c(paramInt);
  }
  
  boolean b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager;
    if (localObject == null) {
      return true;
    }
    localObject = ((AccessibilityManager)localObject).getEnabledAccessibilityServiceList(1);
    return (localObject != null) && (((List)localObject).isEmpty());
  }
  
  void c()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.post(new BaseTransientBottomBar.10(this));
  }
  
  void c(int paramInt)
  {
    SnackbarManager.a().a(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$Callback);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ((BaseTransientBottomBar.BaseCallback)this.jdField_a_of_type_JavaUtilList.get(i)).a(this, paramInt);
        i -= 1;
      }
    }
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout.getParent();
    if ((localObject instanceof ViewGroup)) {
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$SnackbarBaseLayout);
    }
  }
  
  void d()
  {
    SnackbarManager.a().b(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$Callback);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((BaseTransientBottomBar.BaseCallback)this.jdField_a_of_type_JavaUtilList.get(i)).a(this);
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */