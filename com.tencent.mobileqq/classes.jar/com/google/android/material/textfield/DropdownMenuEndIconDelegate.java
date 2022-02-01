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
  private static final boolean d;
  private final TextWatcher e = new DropdownMenuEndIconDelegate.1(this);
  private final View.OnFocusChangeListener f = new DropdownMenuEndIconDelegate.2(this);
  private final TextInputLayout.AccessibilityDelegate g = new DropdownMenuEndIconDelegate.3(this, this.a);
  private final TextInputLayout.OnEditTextAttachedListener h = new DropdownMenuEndIconDelegate.4(this);
  @SuppressLint({"ClickableViewAccessibility"})
  private final TextInputLayout.OnEndIconChangedListener i = new DropdownMenuEndIconDelegate.5(this);
  private boolean j = false;
  private boolean k = false;
  private long l = 9223372036854775807L;
  private StateListDrawable m;
  private MaterialShapeDrawable n;
  @Nullable
  private AccessibilityManager o;
  private ValueAnimator p;
  private ValueAnimator q;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    d = bool;
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
    MaterialShapeDrawable localMaterialShapeDrawable = MaterialShapeDrawable.a(this.b, paramFloat3);
    localMaterialShapeDrawable.setShapeAppearanceModel(localShapeAppearanceModel);
    localMaterialShapeDrawable.a(0, paramInt, 0, paramInt);
    return localMaterialShapeDrawable;
  }
  
  private void a(@Nullable AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (paramAutoCompleteTextView == null) {
      return;
    }
    if (d()) {
      this.j = false;
    }
    if (!this.j)
    {
      if (d)
      {
        b(this.k ^ true);
      }
      else
      {
        this.k ^= true;
        this.c.toggle();
      }
      if (this.k)
      {
        paramAutoCompleteTextView.requestFocus();
        paramAutoCompleteTextView.showDropDown();
        return;
      }
      paramAutoCompleteTextView.dismissDropDown();
      return;
    }
    this.j = false;
  }
  
  private void a(@NonNull AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    int i1 = MaterialColors.a(paramAutoCompleteTextView, R.attr.t);
    MaterialShapeDrawable localMaterialShapeDrawable1 = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
    paramInt = MaterialColors.a(paramInt, i1, 0.1F);
    localMaterialShapeDrawable1.g(new ColorStateList(paramArrayOfInt, new int[] { paramInt, 0 }));
    if (d)
    {
      localMaterialShapeDrawable1.setTint(i1);
      paramArrayOfInt = new ColorStateList(paramArrayOfInt, new int[] { paramInt, i1 });
      MaterialShapeDrawable localMaterialShapeDrawable2 = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
      localMaterialShapeDrawable2.setTint(-1);
      paramArrayOfInt = new LayerDrawable(new Drawable[] { new RippleDrawable(paramArrayOfInt, localMaterialShapeDrawable1, localMaterialShapeDrawable2), paramMaterialShapeDrawable });
    }
    else
    {
      paramArrayOfInt = new LayerDrawable(new Drawable[] { localMaterialShapeDrawable1, paramMaterialShapeDrawable });
    }
    ViewCompat.setBackground(paramAutoCompleteTextView, paramArrayOfInt);
  }
  
  private void b(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (d)
    {
      int i1 = this.a.getBoxBackgroundMode();
      if (i1 == 2)
      {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable(this.n);
        return;
      }
      if (i1 == 1) {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable(this.m);
      }
    }
  }
  
  private void b(@NonNull AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    int i1 = this.a.getBoxBackgroundColor();
    paramInt = MaterialColors.a(paramInt, i1, 0.1F);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt;
    arrayOfInt[1] = i1;
    if (d)
    {
      ViewCompat.setBackground(paramAutoCompleteTextView, new RippleDrawable(new ColorStateList(paramArrayOfInt, arrayOfInt), paramMaterialShapeDrawable, paramMaterialShapeDrawable));
      return;
    }
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
    localMaterialShapeDrawable.g(new ColorStateList(paramArrayOfInt, arrayOfInt));
    paramArrayOfInt = new LayerDrawable(new Drawable[] { paramMaterialShapeDrawable, localMaterialShapeDrawable });
    paramInt = ViewCompat.getPaddingStart(paramAutoCompleteTextView);
    i1 = paramAutoCompleteTextView.getPaddingTop();
    int i2 = ViewCompat.getPaddingEnd(paramAutoCompleteTextView);
    int i3 = paramAutoCompleteTextView.getPaddingBottom();
    ViewCompat.setBackground(paramAutoCompleteTextView, paramArrayOfInt);
    ViewCompat.setPaddingRelative(paramAutoCompleteTextView, paramInt, i1, i2, i3);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.k != paramBoolean)
    {
      this.k = paramBoolean;
      this.q.cancel();
      this.p.start();
    }
  }
  
  @NonNull
  private static AutoCompleteTextView c(EditText paramEditText)
  {
    if ((paramEditText instanceof AutoCompleteTextView)) {
      return (AutoCompleteTextView)paramEditText;
    }
    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
  }
  
  private void c(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (d(paramAutoCompleteTextView)) {
      return;
    }
    int i1 = this.a.getBoxBackgroundMode();
    MaterialShapeDrawable localMaterialShapeDrawable = this.a.getBoxBackground();
    int i2 = MaterialColors.a(paramAutoCompleteTextView, R.attr.o);
    int[][] arrayOfInt = new int[2][];
    arrayOfInt[0] = { 16842919 };
    arrayOfInt[1] = new int[0];
    if (i1 == 2)
    {
      a(paramAutoCompleteTextView, i2, arrayOfInt, localMaterialShapeDrawable);
      return;
    }
    if (i1 == 1) {
      b(paramAutoCompleteTextView, i2, arrayOfInt, localMaterialShapeDrawable);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    paramAutoCompleteTextView.setOnTouchListener(new DropdownMenuEndIconDelegate.7(this, paramAutoCompleteTextView));
    paramAutoCompleteTextView.setOnFocusChangeListener(this.f);
    if (d) {
      paramAutoCompleteTextView.setOnDismissListener(new DropdownMenuEndIconDelegate.8(this));
    }
  }
  
  private boolean d()
  {
    long l1 = System.currentTimeMillis() - this.l;
    return (l1 < 0L) || (l1 > 300L);
  }
  
  private static boolean d(@NonNull EditText paramEditText)
  {
    return paramEditText.getKeyListener() != null;
  }
  
  private void e()
  {
    this.q = a(67, new float[] { 0.0F, 1.0F });
    this.p = a(50, new float[] { 1.0F, 0.0F });
    this.p.addListener(new DropdownMenuEndIconDelegate.9(this));
  }
  
  void a()
  {
    float f1 = this.b.getResources().getDimensionPixelOffset(R.dimen.aj);
    float f2 = this.b.getResources().getDimensionPixelOffset(R.dimen.ac);
    int i1 = this.b.getResources().getDimensionPixelOffset(R.dimen.ad);
    MaterialShapeDrawable localMaterialShapeDrawable1 = a(f1, f1, f2, i1);
    MaterialShapeDrawable localMaterialShapeDrawable2 = a(0.0F, f1, f2, i1);
    this.n = localMaterialShapeDrawable1;
    this.m = new StateListDrawable();
    this.m.addState(new int[] { 16842922 }, localMaterialShapeDrawable1);
    this.m.addState(new int[0], localMaterialShapeDrawable2);
    if (d) {
      i1 = R.drawable.e;
    } else {
      i1 = R.drawable.f;
    }
    this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, i1));
    this.a.setEndIconContentDescription(this.a.getResources().getText(R.string.g));
    this.a.setEndIconOnClickListener(new DropdownMenuEndIconDelegate.6(this));
    this.a.a(this.h);
    this.a.a(this.i);
    e();
    this.o = ((AccessibilityManager)this.b.getSystemService("accessibility"));
  }
  
  boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */