package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = R.style.q;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final SparseArray<EndIconDelegate> jdField_a_of_type_AndroidUtilSparseArray;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  @NonNull
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  @NonNull
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  @Nullable
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NonNull
  private final CheckableImageButton jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
  final CollapsingTextHelper jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper;
  @Nullable
  private MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  @NonNull
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private final IndicatorViewController jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private final LinkedHashSet<TextInputLayout.OnEditTextAttachedListener> jdField_a_of_type_JavaUtilLinkedHashSet;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @Nullable
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  private PorterDuff.Mode jdField_b_of_type_AndroidGraphicsPorterDuff$Mode;
  private final Rect jdField_b_of_type_AndroidGraphicsRect;
  @Nullable
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnLongClickListener jdField_b_of_type_AndroidViewView$OnLongClickListener;
  @NonNull
  private final FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  @NonNull
  private final LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @NonNull
  private final CheckableImageButton jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
  @Nullable
  private MaterialShapeDrawable jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> jdField_b_of_type_JavaUtilLinkedHashSet;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  @Nullable
  private ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnLongClickListener jdField_c_of_type_AndroidViewView$OnLongClickListener;
  @NonNull
  private final TextView jdField_c_of_type_AndroidWidgetTextView;
  @NonNull
  private final CheckableImageButton jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
  @Nullable
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ColorStateList jdField_d_of_type_AndroidContentResColorStateList;
  @NonNull
  private final TextView jdField_d_of_type_AndroidWidgetTextView;
  @Nullable
  private CharSequence jdField_d_of_type_JavaLangCharSequence;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private ColorStateList jdField_e_of_type_AndroidContentResColorStateList;
  private CharSequence jdField_e_of_type_JavaLangCharSequence;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int;
  private ColorStateList jdField_f_of_type_AndroidContentResColorStateList;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private ColorStateList jdField_g_of_type_AndroidContentResColorStateList;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private ColorStateList jdField_h_of_type_AndroidContentResColorStateList;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private ColorStateList jdField_i_of_type_AndroidContentResColorStateList;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  @ColorInt
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  @ColorInt
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private int o;
  private int p;
  @ColorInt
  private int q;
  @ColorInt
  private int r;
  @ColorInt
  private int s;
  @ColorInt
  private int t;
  @ColorInt
  private int u;
  @ColorInt
  private int v;
  @ColorInt
  private int w;
  @ColorInt
  private int x;
  
  public TextInputLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.S);
  }
  
  public TextInputLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {}
  
  private void A()
  {
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, this.jdField_f_of_type_Boolean, this.jdField_d_of_type_AndroidContentResColorStateList, this.jdField_g_of_type_Boolean, this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
  }
  
  private void B()
  {
    a(this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, this.jdField_h_of_type_Boolean, this.jdField_e_of_type_AndroidContentResColorStateList, this.jdField_i_of_type_Boolean, this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode);
  }
  
  private void C()
  {
    if (!o()) {
      return;
    }
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(localRectF, this.jdField_a_of_type_AndroidWidgetEditText.getWidth(), this.jdField_a_of_type_AndroidWidgetEditText.getGravity());
    a(localRectF);
    localRectF.offset(-getPaddingLeft(), -getPaddingTop());
    ((CutoutDrawable)this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable).a(localRectF);
  }
  
  private void D()
  {
    if (o()) {
      ((CutoutDrawable)this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable).a();
    }
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt + this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingLeft();
    paramInt = i1;
    if (this.jdField_c_of_type_JavaLangCharSequence != null)
    {
      paramInt = i1;
      if (!paramBoolean) {
        paramInt = i1 - this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() + this.jdField_c_of_type_AndroidWidgetTextView.getPaddingLeft();
      }
    }
    return paramInt;
  }
  
  private int a(@NonNull Rect paramRect, float paramFloat)
  {
    if (g()) {
      return (int)(paramRect.centerY() - paramFloat / 2.0F);
    }
    return paramRect.top + this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingTop();
  }
  
  private int a(@NonNull Rect paramRect1, @NonNull Rect paramRect2, float paramFloat)
  {
    if (g()) {
      return (int)(paramRect2.top + paramFloat);
    }
    return paramRect1.bottom - this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingBottom();
  }
  
  @NonNull
  private Rect a(@NonNull Rect paramRect)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      Rect localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      boolean bool;
      if (ViewCompat.getLayoutDirection(this) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localRect.bottom = paramRect.bottom;
      int i1 = this.jdField_g_of_type_Int;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          localRect.left = a(paramRect.left, bool);
          localRect.top = getPaddingTop();
          localRect.right = b(paramRect.right, bool);
          return localRect;
        }
        paramRect.left += this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft();
        paramRect.top -= d();
        paramRect.right -= this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight();
        return localRect;
      }
      localRect.left = a(paramRect.left, bool);
      paramRect.top += this.jdField_h_of_type_Int;
      localRect.right = b(paramRect.right, bool);
      return localRect;
    }
    throw new IllegalStateException();
  }
  
  private EndIconDelegate a()
  {
    EndIconDelegate localEndIconDelegate = (EndIconDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.o);
    if (localEndIconDelegate != null) {
      return localEndIconDelegate;
    }
    return (EndIconDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(0);
  }
  
  private static void a(@NonNull Context paramContext, @NonNull TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = R.string.jdField_c_of_type_Int;
    } else {
      i1 = R.string.jdField_b_of_type_Int;
    }
    paramTextView.setContentDescription(paramContext.getString(i1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramCanvas);
    }
  }
  
  private void a(@NonNull Rect paramRect)
  {
    if (this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable != null)
    {
      int i1 = paramRect.bottom;
      int i2 = this.jdField_k_of_type_Int;
      this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setBounds(paramRect.left, i1 - i2, paramRect.right, paramRect.bottom);
    }
  }
  
  private void a(@NonNull RectF paramRectF)
  {
    paramRectF.left -= this.jdField_f_of_type_Int;
    paramRectF.top -= this.jdField_f_of_type_Int;
    paramRectF.right += this.jdField_f_of_type_Int;
    paramRectF.bottom += this.jdField_f_of_type_Int;
  }
  
  private static void a(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, paramBoolean);
      }
      i1 += 1;
    }
  }
  
  private void a(EditText paramEditText)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null)
    {
      if ((this.o != 3) && (!(paramEditText instanceof TextInputEditText))) {
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
      }
      this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
      f();
      setTextInputAccessibilityDelegate(new TextInputLayout.AccessibilityDelegate(this));
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c(this.jdField_a_of_type_AndroidWidgetEditText.getTypeface());
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(this.jdField_a_of_type_AndroidWidgetEditText.getTextSize());
      int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getGravity();
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(i1 & 0xFFFFFF8F | 0x30);
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(i1);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TextInputLayout.1(this));
      if (this.jdField_g_of_type_AndroidContentResColorStateList == null) {
        this.jdField_g_of_type_AndroidContentResColorStateList = this.jdField_a_of_type_AndroidWidgetEditText.getHintTextColors();
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangCharSequence))
        {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidWidgetEditText.getHint();
          setHint(this.jdField_a_of_type_JavaLangCharSequence);
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(null);
        }
        this.jdField_e_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        a(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      }
      a();
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.d();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_b_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_b_of_type_AndroidWidgetFrameLayout.bringToFront();
      this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.bringToFront();
      z();
      s();
      u();
      if (!isEnabled()) {
        paramEditText.setEnabled(false);
      }
      a(false, true);
      return;
    }
    throw new IllegalArgumentException("We already have an EditText, can only have one");
  }
  
  private void a(CheckableImageButton paramCheckableImageButton, ColorStateList paramColorStateList)
  {
    Drawable localDrawable = paramCheckableImageButton.getDrawable();
    if ((paramCheckableImageButton.getDrawable() != null) && (paramColorStateList != null))
    {
      if (!paramColorStateList.isStateful()) {
        return;
      }
      int i1 = paramColorStateList.getColorForState(a(paramCheckableImageButton), paramColorStateList.getDefaultColor());
      paramColorStateList = DrawableCompat.wrap(localDrawable).mutate();
      DrawableCompat.setTintList(paramColorStateList, ColorStateList.valueOf(i1));
      paramCheckableImageButton.setImageDrawable(paramColorStateList);
    }
  }
  
  private static void a(@NonNull CheckableImageButton paramCheckableImageButton, @Nullable View.OnClickListener paramOnClickListener, @Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    paramCheckableImageButton.setOnClickListener(paramOnClickListener);
    b(paramCheckableImageButton, paramOnLongClickListener);
  }
  
  private static void a(@NonNull CheckableImageButton paramCheckableImageButton, @Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    paramCheckableImageButton.setOnLongClickListener(paramOnLongClickListener);
    b(paramCheckableImageButton, paramOnLongClickListener);
  }
  
  private void a(@NonNull CheckableImageButton paramCheckableImageButton, boolean paramBoolean1, ColorStateList paramColorStateList, boolean paramBoolean2, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable2 = paramCheckableImageButton.getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 != null) {
      if (!paramBoolean1)
      {
        localDrawable1 = localDrawable2;
        if (!paramBoolean2) {}
      }
      else
      {
        localDrawable2 = DrawableCompat.wrap(localDrawable2).mutate();
        if (paramBoolean1) {
          DrawableCompat.setTintList(localDrawable2, paramColorStateList);
        }
        localDrawable1 = localDrawable2;
        if (paramBoolean2)
        {
          DrawableCompat.setTintMode(localDrawable2, paramMode);
          localDrawable1 = localDrawable2;
        }
      }
    }
    if (paramCheckableImageButton.getDrawable() != localDrawable1) {
      paramCheckableImageButton.setImageDrawable(localDrawable1);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.jdField_e_of_type_JavaLangCharSequence))
    {
      this.jdField_e_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramCharSequence);
      if (!this.jdField_j_of_type_Boolean) {
        C();
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = isEnabled();
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    int i1;
    if ((localObject != null) && (!TextUtils.isEmpty(((EditText)localObject).getText()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    int i2;
    if ((localObject != null) && (((EditText)localObject).hasFocus())) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool2 = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.c();
    localObject = this.jdField_g_of_type_AndroidContentResColorStateList;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a((ColorStateList)localObject);
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(this.jdField_g_of_type_AndroidContentResColorStateList);
    }
    if (!bool1)
    {
      localObject = this.jdField_g_of_type_AndroidContentResColorStateList;
      int i3;
      if (localObject != null)
      {
        i3 = this.x;
        i3 = ((ColorStateList)localObject).getColorForState(new int[] { -16842910 }, i3);
      }
      else
      {
        i3 = this.x;
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(ColorStateList.valueOf(i3));
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(ColorStateList.valueOf(i3));
    }
    else if (bool2)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a());
    }
    else
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null)
        {
          this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(((TextView)localObject).getTextColors());
          break label259;
        }
      }
      if (i2 != 0)
      {
        localObject = this.jdField_h_of_type_AndroidContentResColorStateList;
        if (localObject != null) {
          this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a((ColorStateList)localObject);
        }
      }
    }
    label259:
    if ((i1 == 0) && (this.jdField_k_of_type_Boolean) && ((!isEnabled()) || (i2 == 0)))
    {
      if ((paramBoolean2) || (!this.jdField_j_of_type_Boolean)) {
        f(paramBoolean1);
      }
    }
    else if ((paramBoolean2) || (this.jdField_j_of_type_Boolean)) {
      d(paramBoolean1);
    }
  }
  
  private int[] a(CheckableImageButton paramCheckableImageButton)
  {
    int[] arrayOfInt = getDrawableState();
    paramCheckableImageButton = paramCheckableImageButton.getDrawableState();
    int i1 = arrayOfInt.length;
    arrayOfInt = Arrays.copyOf(arrayOfInt, arrayOfInt.length + paramCheckableImageButton.length);
    System.arraycopy(paramCheckableImageButton, 0, arrayOfInt, i1, paramCheckableImageButton.length);
    return arrayOfInt;
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt - this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingRight();
    paramInt = i1;
    if (this.jdField_c_of_type_JavaLangCharSequence != null)
    {
      paramInt = i1;
      if (paramBoolean) {
        paramInt = i1 + (this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() - this.jdField_c_of_type_AndroidWidgetTextView.getPaddingRight());
      }
    }
    return paramInt;
  }
  
  @NonNull
  private Rect b(@NonNull Rect paramRect)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      Rect localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      float f1 = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b();
      paramRect.left += this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingLeft();
      localRect.top = a(paramRect, f1);
      paramRect.right -= this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingRight();
      localRect.bottom = a(paramRect, localRect, f1);
      return localRect;
    }
    throw new IllegalStateException();
  }
  
  @Nullable
  private CheckableImageButton b()
  {
    if (this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getVisibility() == 0) {
      return this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
    }
    if ((k()) && (d())) {
      return this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt == 0) && (!this.jdField_j_of_type_Boolean))
    {
      n();
      return;
    }
    o();
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject = this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localObject != null)
    {
      localObject = ((MaterialShapeDrawable)localObject).getBounds();
      ((Rect)localObject).top = (((Rect)localObject).bottom - this.jdField_i_of_type_Int);
      this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.draw(paramCanvas);
    }
  }
  
  private static void b(@NonNull CheckableImageButton paramCheckableImageButton, @Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    boolean bool3 = ViewCompat.hasOnClickListeners(paramCheckableImageButton);
    boolean bool2 = false;
    int i1 = 1;
    boolean bool1;
    if (paramOnLongClickListener != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool3) || (bool1)) {
      bool2 = true;
    }
    paramCheckableImageButton.setFocusable(bool2);
    paramCheckableImageButton.setClickable(bool3);
    paramCheckableImageButton.setPressable(bool3);
    paramCheckableImageButton.setLongClickable(bool1);
    if (!bool2) {
      i1 = 2;
    }
    ViewCompat.setImportantForAccessibility(paramCheckableImageButton, i1);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = new AppCompatTextView(getContext());
      this.jdField_b_of_type_AndroidWidgetTextView.setId(R.id.ai);
      ViewCompat.setAccessibilityLiveRegion(this.jdField_b_of_type_AndroidWidgetTextView, 1);
      setPlaceholderTextAppearance(this.jdField_e_of_type_Int);
      setPlaceholderTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      p();
    }
    else
    {
      q();
      this.jdField_b_of_type_AndroidWidgetTextView = null;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.jdField_i_of_type_AndroidContentResColorStateList.getDefaultColor();
    int i2 = this.jdField_i_of_type_AndroidContentResColorStateList.getColorForState(new int[] { 16843623, 16842910 }, i1);
    int i3 = this.jdField_i_of_type_AndroidContentResColorStateList.getColorForState(new int[] { 16843518, 16842910 }, i1);
    if (paramBoolean1)
    {
      this.jdField_l_of_type_Int = i3;
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_l_of_type_Int = i2;
      return;
    }
    this.jdField_l_of_type_Int = i1;
  }
  
  private void c(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashSet.iterator();
    while (localIterator.hasNext()) {
      ((TextInputLayout.OnEndIconChangedListener)localIterator.next()).a(this, paramInt);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (c() != null))
    {
      Drawable localDrawable = DrawableCompat.wrap(c()).mutate();
      DrawableCompat.setTint(localDrawable, this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a());
      this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(localDrawable);
      return;
    }
    B();
  }
  
  private int d()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return 0;
    }
    int i1 = this.jdField_g_of_type_Int;
    if ((i1 != 0) && (i1 != 1)) {
      if (i1 != 2) {
        return 0;
      }
    }
    for (float f1 = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c() / 2.0F;; f1 = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c()) {
      return (int)f1;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((paramBoolean) && (this.jdField_l_of_type_Boolean)) {
      a(1.0F);
    } else {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(1.0F);
    }
    this.jdField_j_of_type_Boolean = false;
    if (o()) {
      C();
    }
    m();
    r();
    t();
  }
  
  private int e()
  {
    int i1 = this.jdField_m_of_type_Int;
    if (this.jdField_g_of_type_Int == 1) {
      i1 = MaterialColors.a(MaterialColors.a(this, R.attr.jdField_n_of_type_Int, 0), this.jdField_m_of_type_Int);
    }
    return i1;
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
    int i2 = 0;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((CheckableImageButton)localObject).setVisibility(i1);
    localObject = this.jdField_b_of_type_AndroidWidgetFrameLayout;
    int i1 = i2;
    if (paramBoolean) {
      i1 = 8;
    }
    ((FrameLayout)localObject).setVisibility(i1);
    u();
    if (!k()) {
      l();
    }
  }
  
  private void f()
  {
    g();
    h();
    e();
    i();
    j();
    if (this.jdField_g_of_type_Int != 0) {
      k();
    }
  }
  
  private void f(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((paramBoolean) && (this.jdField_l_of_type_Boolean)) {
      a(0.0F);
    } else {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(0.0F);
    }
    if ((o()) && (((CutoutDrawable)this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable).a())) {
      D();
    }
    this.jdField_j_of_type_Boolean = true;
    o();
    r();
    t();
  }
  
  private boolean f()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    return (localEditText != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable != null) && (localEditText.getBackground() == null) && (this.jdField_g_of_type_Int != 0);
  }
  
  private void g()
  {
    int i1 = this.jdField_g_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          if ((this.jdField_d_of_type_Boolean) && (!(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable instanceof CutoutDrawable))) {
            this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new CutoutDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
          } else {
            this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
          }
          this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = null;
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_g_of_type_Int);
        localStringBuilder.append(" is illegal; only @BoxBackgroundMode constants are supported.");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
      this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable();
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = null;
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = null;
  }
  
  private boolean g()
  {
    int i1 = this.jdField_g_of_type_Int;
    boolean bool = true;
    if (i1 == 1)
    {
      if (Build.VERSION.SDK_INT < 16) {
        return bool;
      }
      if (this.jdField_a_of_type_AndroidWidgetEditText.getMinLines() <= 1) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private void h()
  {
    if (f()) {
      ViewCompat.setBackground(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable);
    }
  }
  
  private boolean h()
  {
    return (this.jdField_g_of_type_Int == 2) && (i());
  }
  
  private void i()
  {
    if (this.jdField_g_of_type_Int == 1)
    {
      if (MaterialResources.b(getContext()))
      {
        this.jdField_h_of_type_Int = getResources().getDimensionPixelSize(R.dimen.B);
        return;
      }
      if (MaterialResources.a(getContext())) {
        this.jdField_h_of_type_Int = getResources().getDimensionPixelSize(R.dimen.A);
      }
    }
  }
  
  private boolean i()
  {
    return (this.jdField_i_of_type_Int > -1) && (this.jdField_l_of_type_Int != 0);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      if (this.jdField_g_of_type_Int != 1) {
        return;
      }
      EditText localEditText;
      if (MaterialResources.b(getContext()))
      {
        localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
        ViewCompat.setPaddingRelative(localEditText, ViewCompat.getPaddingStart(localEditText), getResources().getDimensionPixelSize(R.dimen.z), ViewCompat.getPaddingEnd(this.jdField_a_of_type_AndroidWidgetEditText), getResources().getDimensionPixelSize(R.dimen.y));
        return;
      }
      if (MaterialResources.a(getContext()))
      {
        localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
        ViewCompat.setPaddingRelative(localEditText, ViewCompat.getPaddingStart(localEditText), getResources().getDimensionPixelSize(R.dimen.x), ViewCompat.getPaddingEnd(this.jdField_a_of_type_AndroidWidgetEditText), getResources().getDimensionPixelSize(R.dimen.w));
      }
    }
  }
  
  private boolean j()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return false;
    }
    int i1 = Math.max(this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight());
    if (this.jdField_a_of_type_AndroidWidgetEditText.getMeasuredHeight() < i1)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setMinimumHeight(i1);
      return true;
    }
    return false;
  }
  
  private void k()
  {
    if (this.jdField_g_of_type_Int != 1)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      int i1 = d();
      if (i1 != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i1;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
      }
    }
  }
  
  private boolean k()
  {
    return this.o != 0;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      int i1;
      if (localEditText == null) {
        i1 = 0;
      } else {
        i1 = localEditText.getText().length();
      }
      a(i1);
    }
  }
  
  private boolean l()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return false;
    }
    int i1;
    Object localObject;
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (m())
    {
      i1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft();
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_n_of_type_Int != i1))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
        this.jdField_n_of_type_Int = i1;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_n_of_type_Int, 1);
      }
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText);
      localDrawable1 = localObject[0];
      localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable1 == localDrawable2) {
        break label175;
      }
      TextViewCompat.setCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText, localDrawable2, localObject[1], localObject[2], localObject[3]);
    }
    else
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label175;
      }
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText);
      TextViewCompat.setCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText, null, localObject[1], localObject[2], localObject[3]);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    boolean bool1 = true;
    break label177;
    label175:
    bool1 = false;
    label177:
    if (n())
    {
      int i2 = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight();
      localObject = b();
      i1 = i2;
      if (localObject != null) {
        i1 = i2 + ((View)localObject).getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams());
      }
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText);
      localDrawable1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if ((localDrawable1 != null) && (this.p != i1))
      {
        this.p = i1;
        localDrawable1.setBounds(0, 0, this.p, 1);
        TextViewCompat.setCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText, localObject[0], localObject[1], this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, localObject[3]);
      }
      for (;;)
      {
        return true;
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
          this.p = i1;
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.p, 1);
        }
        localDrawable1 = localObject[2];
        localDrawable2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        bool2 = bool1;
        if (localDrawable1 == localDrawable2) {
          break;
        }
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localObject[2];
        TextViewCompat.setCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText, localObject[0], localObject[1], localDrawable2, localObject[3]);
      }
    }
    boolean bool2 = bool1;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText);
      if (localObject[2] == this.jdField_b_of_type_AndroidGraphicsDrawableDrawable)
      {
        TextViewCompat.setCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetEditText, localObject[0], localObject[1], this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, localObject[3]);
        bool1 = true;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      bool2 = bool1;
    }
    return bool2;
  }
  
  private void m()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    int i1;
    if (localEditText == null) {
      i1 = 0;
    } else {
      i1 = localEditText.getText().length();
    }
    b(i1);
  }
  
  private boolean m()
  {
    return ((b() != null) || (this.jdField_c_of_type_JavaLangCharSequence != null)) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() > 0);
  }
  
  private void n()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (this.jdField_c_of_type_Boolean))
    {
      localTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.bringToFront();
    }
  }
  
  private boolean n()
  {
    return ((this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getVisibility() == 0) || ((k()) && (d())) || (this.jdField_d_of_type_JavaLangCharSequence != null)) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() > 0);
  }
  
  private void o()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (this.jdField_c_of_type_Boolean))
    {
      localTextView.setText(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  private boolean o()
  {
    return (this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangCharSequence)) && ((this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable instanceof CutoutDrawable));
  }
  
  private void p()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private boolean p()
  {
    return this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getVisibility() == 0;
  }
  
  private void q()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void r()
  {
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    int i1;
    if ((this.jdField_c_of_type_JavaLangCharSequence != null) && (!e())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localTextView.setVisibility(i1);
    l();
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    int i1;
    if (c()) {
      i1 = 0;
    } else {
      i1 = ViewCompat.getPaddingStart(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    ViewCompat.setPaddingRelative(this.jdField_c_of_type_AndroidWidgetTextView, i1, this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.F), this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingBottom());
  }
  
  private void t()
  {
    int i2 = this.jdField_d_of_type_AndroidWidgetTextView.getVisibility();
    Object localObject = this.jdField_d_of_type_JavaLangCharSequence;
    int i1 = 0;
    boolean bool;
    if ((localObject != null) && (!e())) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if (!bool) {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    if (i2 != this.jdField_d_of_type_AndroidWidgetTextView.getVisibility()) {
      a().a(bool);
    }
    l();
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    int i1;
    if ((!d()) && (!p())) {
      i1 = ViewCompat.getPaddingEnd(this.jdField_a_of_type_AndroidWidgetEditText);
    } else {
      i1 = 0;
    }
    ViewCompat.setPaddingRelative(this.jdField_d_of_type_AndroidWidgetTextView, getContext().getResources().getDimensionPixelSize(R.dimen.F), this.jdField_a_of_type_AndroidWidgetEditText.getPaddingTop(), i1, this.jdField_a_of_type_AndroidWidgetEditText.getPaddingBottom());
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      int i1;
      if (this.jdField_b_of_type_Boolean) {
        i1 = this.jdField_c_of_type_Int;
      } else {
        i1 = this.jdField_d_of_type_Int;
      }
      a((TextView)localObject, i1);
      if (!this.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_AndroidContentResColorStateList;
        if (localObject != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        }
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_c_of_type_AndroidContentResColorStateList;
        if (localObject != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        }
      }
    }
  }
  
  private void w()
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable == null) {
      return;
    }
    localMaterialShapeDrawable.setShapeAppearanceModel(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    if (h()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(this.jdField_i_of_type_Int, this.jdField_l_of_type_Int);
    }
    this.jdField_m_of_type_Int = e();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(ColorStateList.valueOf(this.jdField_m_of_type_Int));
    if (this.o == 3) {
      this.jdField_a_of_type_AndroidWidgetEditText.getBackground().invalidateSelf();
    }
    x();
    invalidate();
  }
  
  private void x()
  {
    if (this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable == null) {
      return;
    }
    if (i()) {
      this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(ColorStateList.valueOf(this.jdField_l_of_type_Int));
    }
    invalidate();
  }
  
  private void y()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      if (localEditText != null)
      {
        int i1 = localEditText.getGravity();
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(i1);
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingLeft(), this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingTop(), this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingRight(), this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingBottom());
      }
    }
  }
  
  private void z()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
    while (localIterator.hasNext()) {
      ((TextInputLayout.OnEditTextAttachedListener)localIterator.next()).a(this);
    }
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  @Nullable
  public Drawable a()
  {
    return this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getDrawable();
  }
  
  @Nullable
  public EditText a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  @NonNull
  CheckableImageButton a()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
  }
  
  @NonNull
  MaterialShapeDrawable a()
  {
    int i1 = this.jdField_g_of_type_Int;
    if ((i1 != 1) && (i1 != 2)) {
      throw new IllegalStateException();
    }
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  }
  
  @Nullable
  public CharSequence a()
  {
    if (this.jdField_d_of_type_Boolean) {
      return this.jdField_e_of_type_JavaLangCharSequence;
    }
    return null;
  }
  
  void a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject1 != null)
    {
      if (this.jdField_g_of_type_Int != 0) {
        return;
      }
      Object localObject2 = ((EditText)localObject1).getBackground();
      if (localObject2 == null) {
        return;
      }
      localObject1 = localObject2;
      if (DrawableUtils.canSafelyMutateDrawable((Drawable)localObject2)) {
        localObject1 = ((Drawable)localObject2).mutate();
      }
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.c())
      {
        ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a(), PorterDuff.Mode.SRC_IN));
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(((TextView)localObject2).getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
          return;
        }
      }
      DrawableCompat.clearColorFilter((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetEditText.refreshDrawableState();
    }
  }
  
  @VisibleForTesting
  void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.d() == paramFloat) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(AnimationUtils.b);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(167L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TextInputLayout.4(this));
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setFloatValues(new float[] { this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.d(), paramFloat });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  void a(int paramInt)
  {
    boolean bool2 = this.jdField_b_of_type_Boolean;
    int i1 = this.jdField_b_of_type_Int;
    if (i1 == -1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      this.jdField_b_of_type_Boolean = false;
    }
    else
    {
      boolean bool1;
      if (paramInt > i1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_b_of_type_Boolean = bool1;
      a(getContext(), this.jdField_a_of_type_AndroidWidgetTextView, paramInt, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
      if (bool2 != this.jdField_b_of_type_Boolean) {
        v();
      }
      BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localBidiFormatter.unicodeWrap(getContext().getString(R.string.jdField_d_of_type_Int, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_b_of_type_Int) })));
    }
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (bool2 != this.jdField_b_of_type_Boolean))
    {
      a(false);
      e();
      a();
    }
  }
  
  void a(@NonNull TextView paramTextView, @StyleRes int paramInt)
  {
    i1 = 1;
    try
    {
      TextViewCompat.setTextAppearance(paramTextView, paramInt);
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramInt = paramTextView.getTextColors().getDefaultColor();
        if (paramInt == -65281)
        {
          paramInt = i1;
          break label37;
        }
      }
      paramInt = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label37:
        paramInt = i1;
      }
    }
    if (paramInt != 0)
    {
      TextViewCompat.setTextAppearance(paramTextView, R.style.TextAppearance_AppCompat_Caption);
      paramTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.jdField_b_of_type_Int));
    }
  }
  
  public void a(@NonNull TextInputLayout.OnEditTextAttachedListener paramOnEditTextAttachedListener)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramOnEditTextAttachedListener);
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      paramOnEditTextAttachedListener.a(this);
    }
  }
  
  public void a(@NonNull TextInputLayout.OnEndIconChangedListener paramOnEndIconChangedListener)
  {
    this.jdField_b_of_type_JavaUtilLinkedHashSet.add(paramOnEndIconChangedListener);
  }
  
  void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void addView(@NonNull View paramView, int paramInt, @NonNull ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramLayoutParams);
      k();
      a((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public int b()
  {
    return this.jdField_m_of_type_Int;
  }
  
  @Nullable
  public Drawable b()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getDrawable();
  }
  
  @Nullable
  public CharSequence b()
  {
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    return null;
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, this.jdField_d_of_type_AndroidContentResColorStateList);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b();
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public Drawable c()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getDrawable();
  }
  
  @Nullable
  public CharSequence c()
  {
    return this.jdField_d_of_type_JavaLangCharSequence;
  }
  
  public void c()
  {
    a(this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, this.jdField_f_of_type_AndroidContentResColorStateList);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getVisibility() == 0;
  }
  
  @Nullable
  CharSequence d()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        return localTextView.getContentDescription();
      }
    }
    return null;
  }
  
  public void d()
  {
    a(this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, this.jdField_e_of_type_AndroidContentResColorStateList);
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_AndroidWidgetFrameLayout.getVisibility() == 0) && (this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getVisibility() == 0);
  }
  
  protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> paramSparseArray)
  {
    this.jdField_n_of_type_Boolean = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.jdField_n_of_type_Boolean = false;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.jdField_m_of_type_Boolean) {
      return;
    }
    boolean bool2 = true;
    this.jdField_m_of_type_Boolean = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    CollapsingTextHelper localCollapsingTextHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper;
    boolean bool1;
    if (localCollapsingTextHelper != null) {
      bool1 = localCollapsingTextHelper.a(arrayOfInt) | false;
    } else {
      bool1 = false;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      if ((!ViewCompat.isLaidOut(this)) || (!isEnabled())) {
        bool2 = false;
      }
      a(bool2);
    }
    a();
    e();
    if (bool1) {
      invalidate();
    }
    this.jdField_m_of_type_Boolean = false;
  }
  
  @Nullable
  public CharSequence e()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a()) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a();
    }
    return null;
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable != null)
    {
      if (this.jdField_g_of_type_Int == 0) {
        return;
      }
      boolean bool1 = isFocused();
      boolean bool4 = false;
      Object localObject;
      if (!bool1)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText;
        if ((localObject == null) || (!((EditText)localObject).hasFocus()))
        {
          bool1 = false;
          break label56;
        }
      }
      bool1 = true;
      label56:
      if (!isHovered())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText;
        if ((localObject == null) || (!((EditText)localObject).isHovered()))
        {
          bool2 = false;
          break label92;
        }
      }
      boolean bool2 = true;
      label92:
      if (!isEnabled())
      {
        this.jdField_l_of_type_Int = this.x;
      }
      else if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.c())
      {
        if (this.jdField_i_of_type_AndroidContentResColorStateList != null) {
          b(bool1, bool2);
        } else {
          this.jdField_l_of_type_Int = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a();
        }
      }
      else
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          if (localObject != null)
          {
            if (this.jdField_i_of_type_AndroidContentResColorStateList != null)
            {
              b(bool1, bool2);
              break label234;
            }
            this.jdField_l_of_type_Int = ((TextView)localObject).getCurrentTextColor();
            break label234;
          }
        }
        if (bool1) {
          this.jdField_l_of_type_Int = this.s;
        } else if (bool2) {
          this.jdField_l_of_type_Int = this.r;
        } else {
          this.jdField_l_of_type_Int = this.q;
        }
      }
      label234:
      boolean bool3 = bool4;
      if (a() != null)
      {
        bool3 = bool4;
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a())
        {
          bool3 = bool4;
          if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.c()) {
            bool3 = true;
          }
        }
      }
      e(bool3);
      c();
      b();
      d();
      if (a().a()) {
        c(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.c());
      }
      if ((bool1) && (isEnabled())) {
        this.jdField_i_of_type_Int = this.jdField_k_of_type_Int;
      } else {
        this.jdField_i_of_type_Int = this.jdField_j_of_type_Int;
      }
      if (this.jdField_g_of_type_Int == 1) {
        if (!isEnabled()) {
          this.jdField_m_of_type_Int = this.u;
        } else if ((bool2) && (!bool1)) {
          this.jdField_m_of_type_Int = this.w;
        } else if (bool1) {
          this.jdField_m_of_type_Int = this.v;
        } else {
          this.jdField_m_of_type_Int = this.t;
        }
      }
      w();
    }
  }
  
  @VisibleForTesting
  final boolean e()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  @Nullable
  public CharSequence f()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b()) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b();
    }
    return null;
  }
  
  @Nullable
  public CharSequence g()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getContentDescription();
  }
  
  public int getBaseline()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null) {
      return localEditText.getBaseline() + getPaddingTop() + d();
    }
    return super.getBaseline();
  }
  
  @Nullable
  public CharSequence h()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getContentDescription();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null)
    {
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      DescendantOffsetUtils.b(this, localEditText, localRect);
      a(localRect);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(this.jdField_a_of_type_AndroidWidgetEditText.getTextSize());
        paramInt1 = this.jdField_a_of_type_AndroidWidgetEditText.getGravity();
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(paramInt1 & 0xFFFFFF8F | 0x30);
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramInt1);
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(a(localRect));
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(b(localRect));
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b();
        if ((o()) && (!this.jdField_j_of_type_Boolean)) {
          C();
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    boolean bool1 = j();
    boolean bool2 = l();
    if ((bool1) || (bool2)) {
      this.jdField_a_of_type_AndroidWidgetEditText.post(new TextInputLayout.3(this));
    }
    y();
    s();
    u();
  }
  
  protected void onRestoreInstanceState(@Nullable Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof TextInputLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (TextInputLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setError(paramParcelable.jdField_a_of_type_JavaLangCharSequence);
    if (paramParcelable.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.post(new TextInputLayout.2(this));
    }
    setHint(paramParcelable.jdField_b_of_type_JavaLangCharSequence);
    setHelperText(paramParcelable.jdField_c_of_type_JavaLangCharSequence);
    setPlaceholderText(paramParcelable.jdField_d_of_type_JavaLangCharSequence);
    requestLayout();
  }
  
  @Nullable
  public Parcelable onSaveInstanceState()
  {
    TextInputLayout.SavedState localSavedState = new TextInputLayout.SavedState(super.onSaveInstanceState());
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.c()) {
      localSavedState.jdField_a_of_type_JavaLangCharSequence = e();
    }
    boolean bool;
    if ((k()) && (this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.isChecked())) {
      bool = true;
    } else {
      bool = false;
    }
    localSavedState.jdField_a_of_type_Boolean = bool;
    localSavedState.jdField_b_of_type_JavaLangCharSequence = a();
    localSavedState.jdField_c_of_type_JavaLangCharSequence = f();
    localSavedState.jdField_d_of_type_JavaLangCharSequence = b();
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(@ColorInt int paramInt)
  {
    if (this.jdField_m_of_type_Int != paramInt)
    {
      this.jdField_m_of_type_Int = paramInt;
      this.t = paramInt;
      this.v = paramInt;
      this.w = paramInt;
      w();
    }
  }
  
  public void setBoxBackgroundColorResource(@ColorRes int paramInt)
  {
    setBoxBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setBoxBackgroundColorStateList(@NonNull ColorStateList paramColorStateList)
  {
    this.t = paramColorStateList.getDefaultColor();
    this.jdField_m_of_type_Int = this.t;
    this.u = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
    this.v = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);
    this.w = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
    w();
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.jdField_g_of_type_Int) {
      return;
    }
    this.jdField_g_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      f();
    }
  }
  
  public void setBoxCornerRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if ((localMaterialShapeDrawable == null) || (localMaterialShapeDrawable.n() != paramFloat1) || (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.o() != paramFloat2) || (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.q() != paramFloat4) || (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.p() != paramFloat3))
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.b().b(paramFloat1).c(paramFloat2).d(paramFloat4).e(paramFloat3).a();
      w();
    }
  }
  
  public void setBoxCornerRadiiResources(@DimenRes int paramInt1, @DimenRes int paramInt2, @DimenRes int paramInt3, @DimenRes int paramInt4)
  {
    setBoxCornerRadii(getContext().getResources().getDimension(paramInt1), getContext().getResources().getDimension(paramInt2), getContext().getResources().getDimension(paramInt4), getContext().getResources().getDimension(paramInt3));
  }
  
  public void setBoxStrokeColor(@ColorInt int paramInt)
  {
    if (this.s != paramInt)
    {
      this.s = paramInt;
      e();
    }
  }
  
  public void setBoxStrokeColorStateList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.isStateful())
    {
      this.q = paramColorStateList.getDefaultColor();
      this.x = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
      this.r = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
      this.s = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);
    }
    else if (this.s != paramColorStateList.getDefaultColor())
    {
      this.s = paramColorStateList.getDefaultColor();
    }
    e();
  }
  
  public void setBoxStrokeErrorColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_i_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_i_of_type_AndroidContentResColorStateList = paramColorStateList;
      e();
    }
  }
  
  public void setBoxStrokeWidth(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
    e();
  }
  
  public void setBoxStrokeWidthFocused(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
    e();
  }
  
  public void setBoxStrokeWidthFocusedResource(@DimenRes int paramInt)
  {
    setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setBoxStrokeWidthResource(@DimenRes int paramInt)
  {
    setBoxStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new AppCompatTextView(getContext());
        this.jdField_a_of_type_AndroidWidgetTextView.setId(R.id.af);
        Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
        if (localTypeface != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(localTypeface);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a(this.jdField_a_of_type_AndroidWidgetTextView, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.au));
        v();
        l();
      }
      else
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b(this.jdField_a_of_type_AndroidWidgetTextView, 2);
        this.jdField_a_of_type_AndroidWidgetTextView = null;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      if (paramInt > 0) {
        this.jdField_b_of_type_Int = paramInt;
      } else {
        this.jdField_b_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Boolean) {
        l();
      }
    }
  }
  
  public void setCounterOverflowTextAppearance(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      v();
    }
  }
  
  public void setCounterOverflowTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_c_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_c_of_type_AndroidContentResColorStateList = paramColorStateList;
      v();
    }
  }
  
  public void setCounterTextAppearance(int paramInt)
  {
    if (this.jdField_d_of_type_Int != paramInt)
    {
      this.jdField_d_of_type_Int = paramInt;
      v();
    }
  }
  
  public void setCounterTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
      v();
    }
  }
  
  public void setDefaultHintTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_g_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_h_of_type_AndroidContentResColorStateList = paramColorStateList;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      a(false);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    a(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setEndIconActivated(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setActivated(paramBoolean);
  }
  
  public void setEndIconCheckable(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setCheckable(paramBoolean);
  }
  
  public void setEndIconContentDescription(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setEndIconContentDescription(localCharSequence);
  }
  
  public void setEndIconContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (h() != paramCharSequence) {
      this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setEndIconDrawable(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setEndIconDrawable(localDrawable);
  }
  
  public void setEndIconDrawable(@Nullable Drawable paramDrawable)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(paramDrawable);
    d();
  }
  
  public void setEndIconMode(int paramInt)
  {
    int i1 = this.o;
    this.o = paramInt;
    c(i1);
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    setEndIconVisible(bool);
    if (a().a(this.jdField_g_of_type_Int))
    {
      a().a();
      B();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The current box background mode ");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(" is not supported by the end icon mode ");
    localStringBuilder.append(paramInt);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void setEndIconOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    a(this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, paramOnClickListener, this.jdField_b_of_type_AndroidViewView$OnLongClickListener);
  }
  
  public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    a(this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, paramOnLongClickListener);
  }
  
  public void setEndIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_e_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_e_of_type_AndroidContentResColorStateList = paramColorStateList;
      this.jdField_h_of_type_Boolean = true;
      B();
    }
  }
  
  public void setEndIconTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      this.jdField_i_of_type_Boolean = true;
      B();
    }
  }
  
  public void setEndIconVisible(boolean paramBoolean)
  {
    if (d() != paramBoolean)
    {
      CheckableImageButton localCheckableImageButton = this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localCheckableImageButton.setVisibility(i1);
      u();
      l();
    }
  }
  
  public void setError(@Nullable CharSequence paramCharSequence)
  {
    if (!this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a())
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b(paramCharSequence);
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b();
  }
  
  public void setErrorContentDescription(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.c(paramCharSequence);
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a(paramBoolean);
  }
  
  public void setErrorIconDrawable(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setErrorIconDrawable(localDrawable);
    c();
  }
  
  public void setErrorIconDrawable(@Nullable Drawable paramDrawable)
  {
    this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(paramDrawable);
    boolean bool;
    if ((paramDrawable != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a())) {
      bool = true;
    } else {
      bool = false;
    }
    e(bool);
  }
  
  public void setErrorIconOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    a(this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, paramOnClickListener, this.jdField_c_of_type_AndroidViewView$OnLongClickListener);
  }
  
  public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    a(this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, paramOnLongClickListener);
  }
  
  public void setErrorIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_f_of_type_AndroidContentResColorStateList = paramColorStateList;
    Drawable localDrawable2 = this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 != null)
    {
      localDrawable1 = DrawableCompat.wrap(localDrawable2).mutate();
      DrawableCompat.setTintList(localDrawable1, paramColorStateList);
    }
    if (this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getDrawable() != localDrawable1) {
      this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(localDrawable1);
    }
  }
  
  public void setErrorIconTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    Drawable localDrawable2 = this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 != null)
    {
      localDrawable1 = DrawableCompat.wrap(localDrawable2).mutate();
      DrawableCompat.setTintMode(localDrawable1, paramMode);
    }
    if (this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.getDrawable() != localDrawable1) {
      this.jdField_c_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(localDrawable1);
    }
  }
  
  public void setErrorTextAppearance(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a(paramInt);
  }
  
  public void setErrorTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a(paramColorStateList);
  }
  
  public void setExpandedHintEnabled(boolean paramBoolean)
  {
    if (this.jdField_k_of_type_Boolean != paramBoolean)
    {
      this.jdField_k_of_type_Boolean = paramBoolean;
      a(false);
    }
  }
  
  public void setHelperText(@Nullable CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (b()) {
        setHelperTextEnabled(false);
      }
    }
    else
    {
      if (!b()) {
        setHelperTextEnabled(true);
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a(paramCharSequence);
    }
  }
  
  public void setHelperTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b(paramColorStateList);
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b(paramBoolean);
  }
  
  public void setHelperTextTextAppearance(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.b(paramInt);
  }
  
  public void setHint(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setHint(localCharSequence);
  }
  
  public void setHint(@Nullable CharSequence paramCharSequence)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      a(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getHint()))) {
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_e_of_type_JavaLangCharSequence);
        }
        a(null);
      }
      else
      {
        CharSequence localCharSequence = this.jdField_a_of_type_AndroidWidgetEditText.getHint();
        if (!TextUtils.isEmpty(localCharSequence))
        {
          if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangCharSequence)) {
            setHint(localCharSequence);
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(null);
        }
        this.jdField_e_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        k();
      }
    }
  }
  
  public void setHintTextAppearance(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c(paramInt);
    this.jdField_h_of_type_AndroidContentResColorStateList = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      a(false);
      k();
    }
  }
  
  public void setHintTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_h_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      if (this.jdField_g_of_type_AndroidContentResColorStateList == null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramColorStateList);
      }
      this.jdField_h_of_type_AndroidContentResColorStateList = paramColorStateList;
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        a(false);
      }
    }
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleContentDescription(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setPasswordVisibilityToggleContentDescription(localCharSequence);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setContentDescription(paramCharSequence);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleDrawable(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setPasswordVisibilityToggleDrawable(localDrawable);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleDrawable(@Nullable Drawable paramDrawable)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.o != 1))
    {
      setEndIconMode(1);
      return;
    }
    if (!paramBoolean) {
      setEndIconMode(0);
    }
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_e_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_h_of_type_Boolean = true;
    B();
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
    this.jdField_i_of_type_Boolean = true;
    B();
  }
  
  public void setPlaceholderText(@Nullable CharSequence paramCharSequence)
  {
    if ((this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(paramCharSequence)))
    {
      b(false);
    }
    else
    {
      if (!this.jdField_c_of_type_Boolean) {
        b(true);
      }
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    }
    m();
  }
  
  public void setPlaceholderTextAppearance(@StyleRes int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      TextViewCompat.setTextAppearance(localTextView, paramInt);
    }
  }
  
  public void setPlaceholderTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if ((localTextView != null) && (paramColorStateList != null)) {
        localTextView.setTextColor(paramColorStateList);
      }
    }
  }
  
  public void setPrefixText(@Nullable CharSequence paramCharSequence)
  {
    CharSequence localCharSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localCharSequence = null;
    } else {
      localCharSequence = paramCharSequence;
    }
    this.jdField_c_of_type_JavaLangCharSequence = localCharSequence;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    r();
  }
  
  public void setPrefixTextAppearance(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.jdField_c_of_type_AndroidWidgetTextView, paramInt);
  }
  
  public void setPrefixTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
  }
  
  public void setStartIconCheckable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setCheckable(paramBoolean);
  }
  
  public void setStartIconContentDescription(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setStartIconContentDescription(localCharSequence);
  }
  
  public void setStartIconContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (g() != paramCharSequence) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setStartIconDrawable(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStartIconDrawable(localDrawable);
  }
  
  public void setStartIconDrawable(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      setStartIconVisible(true);
      b();
      return;
    }
    setStartIconVisible(false);
    setStartIconOnClickListener(null);
    setStartIconOnLongClickListener(null);
    setStartIconContentDescription(null);
  }
  
  public void setStartIconOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, paramOnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
  }
  
  public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, paramOnLongClickListener);
  }
  
  public void setStartIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_d_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_d_of_type_AndroidContentResColorStateList = paramColorStateList;
      this.jdField_f_of_type_Boolean = true;
      A();
    }
  }
  
  public void setStartIconTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      this.jdField_g_of_type_Boolean = true;
      A();
    }
  }
  
  public void setStartIconVisible(boolean paramBoolean)
  {
    if (c() != paramBoolean)
    {
      CheckableImageButton localCheckableImageButton = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localCheckableImageButton.setVisibility(i1);
      s();
      l();
    }
  }
  
  public void setSuffixText(@Nullable CharSequence paramCharSequence)
  {
    CharSequence localCharSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localCharSequence = null;
    } else {
      localCharSequence = paramCharSequence;
    }
    this.jdField_d_of_type_JavaLangCharSequence = localCharSequence;
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    t();
  }
  
  public void setSuffixTextAppearance(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.jdField_d_of_type_AndroidWidgetTextView, paramInt);
  }
  
  public void setSuffixTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
  }
  
  public void setTextInputAccessibilityDelegate(@Nullable TextInputLayout.AccessibilityDelegate paramAccessibilityDelegate)
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null) {
      ViewCompat.setAccessibilityDelegate(localEditText, paramAccessibilityDelegate);
    }
  }
  
  public void setTypeface(@Nullable Typeface paramTypeface)
  {
    if (paramTypeface != this.jdField_a_of_type_AndroidGraphicsTypeface)
    {
      this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c(paramTypeface);
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController.a(paramTypeface);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setTypeface(paramTypeface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */