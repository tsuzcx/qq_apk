package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.view.View.OnFocusChangeListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

class DropdownMenuEndIconDelegate
  extends EndIconDelegate
{
  private static final boolean jdField_a_of_type_Boolean;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private final TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new DropdownMenuEndIconDelegate.1(this);
  private final View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new DropdownMenuEndIconDelegate.2(this);
  @Nullable
  private AccessibilityManager jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager;
  private MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private final TextInputLayout.AccessibilityDelegate jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$AccessibilityDelegate = new DropdownMenuEndIconDelegate.3(this, this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout);
  private final TextInputLayout.OnEditTextAttachedListener jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEditTextAttachedListener = new DropdownMenuEndIconDelegate.4(this);
  @SuppressLint({"ClickableViewAccessibility"})
  private final TextInputLayout.OnEndIconChangedListener jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEndIconChangedListener = new DropdownMenuEndIconDelegate.5(this);
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
  }
  
  DropdownMenuEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private ValueAnimator a(int paramInt, float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.a);
    paramVarArgs.setDuration(paramInt);
    paramVarArgs.addUpdateListener(new DropdownMenuEndIconDelegate.10(this));
    return paramVarArgs;
  }
  
  private MaterialShapeDrawable a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    ShapeAppearanceModel localShapeAppearanceModel = ShapeAppearanceModel.a().b(paramFloat1).c(paramFloat1).e(paramFloat2).d(paramFloat2).a();
    MaterialShapeDrawable localMaterialShapeDrawable = MaterialShapeDrawable.a(this.jdField_a_of_type_AndroidContentContext, paramFloat3);
    localMaterialShapeDrawable.setShapeAppearanceModel(localShapeAppearanceModel);
    localMaterialShapeDrawable.a(0, paramInt, 0, paramInt);
    return localMaterialShapeDrawable;
  }
  
  private void a(@Nullable AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (paramAutoCompleteTextView == null) {
      return;
    }
    if (c()) {
      this.jdField_b_of_type_Boolean = false;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (jdField_a_of_type_Boolean)
      {
        b(this.c ^ true);
      }
      else
      {
        this.c ^= true;
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.toggle();
      }
      if (this.c)
      {
        paramAutoCompleteTextView.requestFocus();
        paramAutoCompleteTextView.showDropDown();
        return;
      }
      paramAutoCompleteTextView.dismissDropDown();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(@NonNull AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    int i = MaterialColors.a(paramAutoCompleteTextView, R.attr.n);
    MaterialShapeDrawable localMaterialShapeDrawable1 = new MaterialShapeDrawable(paramMaterialShapeDrawable.a());
    paramInt = MaterialColors.a(paramInt, i, 0.1F);
    localMaterialShapeDrawable1.g(new ColorStateList(paramArrayOfInt, new int[] { paramInt, 0 }));
    if (jdField_a_of_type_Boolean)
    {
      localMaterialShapeDrawable1.setTint(i);
      paramArrayOfInt = new ColorStateList(paramArrayOfInt, new int[] { paramInt, i });
      MaterialShapeDrawable localMaterialShapeDrawable2 = new MaterialShapeDrawable(paramMaterialShapeDrawable.a());
      localMaterialShapeDrawable2.setTint(-1);
      paramArrayOfInt = new LayerDrawable(new Drawable[] { new RippleDrawable(paramArrayOfInt, localMaterialShapeDrawable1, localMaterialShapeDrawable2), paramMaterialShapeDrawable });
    }
    else
    {
      paramArrayOfInt = new LayerDrawable(new Drawable[] { localMaterialShapeDrawable1, paramMaterialShapeDrawable });
    }
    ViewCompat.setBackground(paramAutoCompleteTextView, paramArrayOfInt);
  }
  
  @NonNull
  private static AutoCompleteTextView b(EditText paramEditText)
  {
    if ((paramEditText instanceof AutoCompleteTextView)) {
      return (AutoCompleteTextView)paramEditText;
    }
    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator = a(67, new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator = a(50, new float[] { 1.0F, 0.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new DropdownMenuEndIconDelegate.9(this));
  }
  
  private void b(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
      if (i == 2)
      {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable);
        return;
      }
      if (i == 1) {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable);
      }
    }
  }
  
  private void b(@NonNull AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.b();
    paramInt = MaterialColors.a(paramInt, i, 0.1F);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt;
    arrayOfInt[1] = i;
    if (jdField_a_of_type_Boolean)
    {
      ViewCompat.setBackground(paramAutoCompleteTextView, new RippleDrawable(new ColorStateList(paramArrayOfInt, arrayOfInt), paramMaterialShapeDrawable, paramMaterialShapeDrawable));
      return;
    }
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(paramMaterialShapeDrawable.a());
    localMaterialShapeDrawable.g(new ColorStateList(paramArrayOfInt, arrayOfInt));
    paramArrayOfInt = new LayerDrawable(new Drawable[] { paramMaterialShapeDrawable, localMaterialShapeDrawable });
    paramInt = ViewCompat.getPaddingStart(paramAutoCompleteTextView);
    i = paramAutoCompleteTextView.getPaddingTop();
    int j = ViewCompat.getPaddingEnd(paramAutoCompleteTextView);
    int k = paramAutoCompleteTextView.getPaddingBottom();
    ViewCompat.setBackground(paramAutoCompleteTextView, paramArrayOfInt);
    ViewCompat.setPaddingRelative(paramAutoCompleteTextView, paramInt, i, j, k);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private static boolean b(@NonNull EditText paramEditText)
  {
    return paramEditText.getKeyListener() != null;
  }
  
  private void c(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (b(paramAutoCompleteTextView)) {
      return;
    }
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
    int j = MaterialColors.a(paramAutoCompleteTextView, R.attr.colorControlHighlight);
    int[][] arrayOfInt = new int[2][];
    arrayOfInt[0] = { 16842919 };
    arrayOfInt[1] = new int[0];
    if (i == 2)
    {
      a(paramAutoCompleteTextView, j, arrayOfInt, localMaterialShapeDrawable);
      return;
    }
    if (i == 1) {
      b(paramAutoCompleteTextView, j, arrayOfInt, localMaterialShapeDrawable);
    }
  }
  
  private boolean c()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    return (l < 0L) || (l > 300L);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    paramAutoCompleteTextView.setOnTouchListener(new DropdownMenuEndIconDelegate.7(this, paramAutoCompleteTextView));
    paramAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    if (jdField_a_of_type_Boolean) {
      paramAutoCompleteTextView.setOnDismissListener(new DropdownMenuEndIconDelegate.8(this));
    }
  }
  
  void a()
  {
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(R.dimen.aj);
    float f2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(R.dimen.ac);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(R.dimen.ad);
    MaterialShapeDrawable localMaterialShapeDrawable1 = a(f1, f1, f2, i);
    MaterialShapeDrawable localMaterialShapeDrawable2 = a(0.0F, f1, f2, i);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = localMaterialShapeDrawable1;
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842922 }, localMaterialShapeDrawable1);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], localMaterialShapeDrawable2);
    if (jdField_a_of_type_Boolean) {
      i = R.drawable.e;
    } else {
      i = R.drawable.f;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.jdField_a_of_type_AndroidContentContext, i));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconContentDescription(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.getResources().getText(R.string.g));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconOnClickListener(new DropdownMenuEndIconDelegate.6(this));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEditTextAttachedListener);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEndIconChangedListener);
    b();
    this.jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager = ((AccessibilityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("accessibility"));
  }
  
  boolean a()
  {
    return true;
  }
  
  boolean a(int paramInt)
  {
    return paramInt != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */