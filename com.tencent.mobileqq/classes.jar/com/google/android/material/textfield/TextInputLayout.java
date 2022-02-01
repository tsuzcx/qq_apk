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
  private static final int d = R.style.s;
  private boolean A;
  private CharSequence B;
  private boolean C;
  @Nullable
  private MaterialShapeDrawable D;
  @Nullable
  private MaterialShapeDrawable E;
  @NonNull
  private ShapeAppearanceModel F;
  private final int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  @ColorInt
  private int M;
  @ColorInt
  private int N;
  private final Rect O;
  private final Rect P;
  private final RectF Q;
  private Typeface R;
  @NonNull
  private final CheckableImageButton S;
  private ColorStateList T;
  private boolean U;
  private PorterDuff.Mode V;
  private boolean W;
  @Nullable
  private Drawable Z;
  EditText a;
  @ColorInt
  private int aA;
  @ColorInt
  private int aB;
  @ColorInt
  private int aC;
  private boolean aD;
  private boolean aE;
  private boolean aF;
  private ValueAnimator aG;
  private boolean aH;
  private boolean aI;
  private int aa;
  private View.OnLongClickListener ab;
  private final LinkedHashSet<TextInputLayout.OnEditTextAttachedListener> ac;
  private int ad;
  private final SparseArray<EndIconDelegate> ae;
  @NonNull
  private final CheckableImageButton af;
  private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> ag;
  private ColorStateList ah;
  private boolean ai;
  private PorterDuff.Mode aj;
  private boolean ak;
  @Nullable
  private Drawable al;
  private int am;
  private Drawable an;
  private View.OnLongClickListener ao;
  private View.OnLongClickListener ap;
  @NonNull
  private final CheckableImageButton aq;
  private ColorStateList ar;
  private ColorStateList as;
  private ColorStateList at;
  @ColorInt
  private int au;
  @ColorInt
  private int av;
  @ColorInt
  private int aw;
  private ColorStateList ax;
  @ColorInt
  private int ay;
  @ColorInt
  private int az;
  boolean b;
  final CollapsingTextHelper c;
  @NonNull
  private final FrameLayout e;
  @NonNull
  private final LinearLayout f;
  @NonNull
  private final LinearLayout g;
  @NonNull
  private final FrameLayout h;
  private CharSequence i;
  private final IndicatorViewController j;
  private int k;
  private boolean l;
  @Nullable
  private TextView m;
  private int n;
  private int o;
  private CharSequence p;
  private boolean q;
  private TextView r;
  @Nullable
  private ColorStateList s;
  private int t;
  @Nullable
  private ColorStateList u;
  @Nullable
  private ColorStateList v;
  @Nullable
  private CharSequence w;
  @NonNull
  private final TextView x;
  @Nullable
  private CharSequence y;
  @NonNull
  private final TextView z;
  
  public TextInputLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.ab);
  }
  
  public TextInputLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {}
  
  private void A()
  {
    if (this.a == null) {
      return;
    }
    int i1;
    if ((!g()) && (!V())) {
      i1 = ViewCompat.getPaddingEnd(this.a);
    } else {
      i1 = 0;
    }
    ViewCompat.setPaddingRelative(this.z, getContext().getResources().getDimensionPixelSize(R.dimen.F), this.a.getPaddingTop(), i1, this.a.getPaddingBottom());
  }
  
  private void B()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      int i1;
      if (this.l) {
        i1 = this.n;
      } else {
        i1 = this.o;
      }
      a((TextView)localObject, i1);
      if (!this.l)
      {
        localObject = this.u;
        if (localObject != null) {
          this.m.setTextColor((ColorStateList)localObject);
        }
      }
      if (this.l)
      {
        localObject = this.v;
        if (localObject != null) {
          this.m.setTextColor((ColorStateList)localObject);
        }
      }
    }
  }
  
  private int C()
  {
    if (!this.A) {
      return 0;
    }
    int i1 = this.H;
    if ((i1 != 0) && (i1 != 1)) {
      if (i1 != 2) {
        return 0;
      }
    }
    for (float f1 = this.c.c() / 2.0F;; f1 = this.c.c()) {
      return (int)f1;
    }
  }
  
  private boolean D()
  {
    int i1 = this.H;
    boolean bool = true;
    if (i1 == 1)
    {
      if (Build.VERSION.SDK_INT < 16) {
        return bool;
      }
      if (this.a.getMinLines() <= 1) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private int E()
  {
    int i1 = this.N;
    if (this.H == 1) {
      i1 = MaterialColors.a(MaterialColors.a(this, R.attr.t, 0), this.N);
    }
    return i1;
  }
  
  private void F()
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.D;
    if (localMaterialShapeDrawable == null) {
      return;
    }
    localMaterialShapeDrawable.setShapeAppearanceModel(this.F);
    if (H()) {
      this.D.a(this.J, this.M);
    }
    this.N = E();
    this.D.g(ColorStateList.valueOf(this.N));
    if (this.ad == 3) {
      this.a.getBackground().invalidateSelf();
    }
    G();
    invalidate();
  }
  
  private void G()
  {
    if (this.E == null) {
      return;
    }
    if (I()) {
      this.E.g(ColorStateList.valueOf(this.M));
    }
    invalidate();
  }
  
  private boolean H()
  {
    return (this.H == 2) && (I());
  }
  
  private boolean I()
  {
    return (this.J > -1) && (this.M != 0);
  }
  
  private boolean J()
  {
    if (this.a == null) {
      return false;
    }
    int i1 = Math.max(this.g.getMeasuredHeight(), this.f.getMeasuredHeight());
    if (this.a.getMeasuredHeight() < i1)
    {
      this.a.setMinimumHeight(i1);
      return true;
    }
    return false;
  }
  
  private void K()
  {
    if (this.r != null)
    {
      EditText localEditText = this.a;
      if (localEditText != null)
      {
        int i1 = localEditText.getGravity();
        this.r.setGravity(i1);
        this.r.setPadding(this.a.getCompoundPaddingLeft(), this.a.getCompoundPaddingTop(), this.a.getCompoundPaddingRight(), this.a.getCompoundPaddingBottom());
      }
    }
  }
  
  private void L()
  {
    Iterator localIterator = this.ac.iterator();
    while (localIterator.hasNext()) {
      ((TextInputLayout.OnEditTextAttachedListener)localIterator.next()).a(this);
    }
  }
  
  private void M()
  {
    a(this.S, this.U, this.T, this.W, this.V);
  }
  
  private boolean N()
  {
    return this.ad != 0;
  }
  
  private void O()
  {
    a(this.af, this.ai, this.ah, this.ak, this.aj);
  }
  
  private boolean P()
  {
    if (this.a == null) {
      return false;
    }
    int i1;
    Object localObject;
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (Q())
    {
      i1 = this.f.getMeasuredWidth() - this.a.getPaddingLeft();
      if ((this.Z == null) || (this.aa != i1))
      {
        this.Z = new ColorDrawable();
        this.aa = i1;
        this.Z.setBounds(0, 0, this.aa, 1);
      }
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.a);
      localDrawable1 = localObject[0];
      localDrawable2 = this.Z;
      if (localDrawable1 == localDrawable2) {
        break label175;
      }
      TextViewCompat.setCompoundDrawablesRelative(this.a, localDrawable2, localObject[1], localObject[2], localObject[3]);
    }
    else
    {
      if (this.Z == null) {
        break label175;
      }
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.a);
      TextViewCompat.setCompoundDrawablesRelative(this.a, null, localObject[1], localObject[2], localObject[3]);
      this.Z = null;
    }
    boolean bool1 = true;
    break label177;
    label175:
    bool1 = false;
    label177:
    if (R())
    {
      int i2 = this.z.getMeasuredWidth() - this.a.getPaddingRight();
      localObject = getEndIconToUpdateDummyDrawable();
      i1 = i2;
      if (localObject != null) {
        i1 = i2 + ((View)localObject).getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams());
      }
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.a);
      localDrawable1 = this.al;
      if ((localDrawable1 != null) && (this.am != i1))
      {
        this.am = i1;
        localDrawable1.setBounds(0, 0, this.am, 1);
        TextViewCompat.setCompoundDrawablesRelative(this.a, localObject[0], localObject[1], this.al, localObject[3]);
      }
      for (;;)
      {
        return true;
        if (this.al == null)
        {
          this.al = new ColorDrawable();
          this.am = i1;
          this.al.setBounds(0, 0, this.am, 1);
        }
        localDrawable1 = localObject[2];
        localDrawable2 = this.al;
        bool2 = bool1;
        if (localDrawable1 == localDrawable2) {
          break;
        }
        this.an = localObject[2];
        TextViewCompat.setCompoundDrawablesRelative(this.a, localObject[0], localObject[1], localDrawable2, localObject[3]);
      }
    }
    boolean bool2 = bool1;
    if (this.al != null)
    {
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.a);
      if (localObject[2] == this.al)
      {
        TextViewCompat.setCompoundDrawablesRelative(this.a, localObject[0], localObject[1], this.an, localObject[3]);
        bool1 = true;
      }
      this.al = null;
      bool2 = bool1;
    }
    return bool2;
  }
  
  private boolean Q()
  {
    return ((getStartIconDrawable() != null) || (this.w != null)) && (this.f.getMeasuredWidth() > 0);
  }
  
  private boolean R()
  {
    return ((this.aq.getVisibility() == 0) || ((N()) && (g())) || (this.y != null)) && (this.g.getMeasuredWidth() > 0);
  }
  
  private boolean S()
  {
    return (this.A) && (!TextUtils.isEmpty(this.B)) && ((this.D instanceof CutoutDrawable));
  }
  
  private void T()
  {
    if (!S()) {
      return;
    }
    RectF localRectF = this.Q;
    this.c.a(localRectF, this.a.getWidth(), this.a.getGravity());
    a(localRectF);
    localRectF.offset(-getPaddingLeft(), -getPaddingTop());
    ((CutoutDrawable)this.D).a(localRectF);
  }
  
  private void U()
  {
    if (S()) {
      ((CutoutDrawable)this.D).b();
    }
  }
  
  private boolean V()
  {
    return this.aq.getVisibility() == 0;
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt + this.a.getCompoundPaddingLeft();
    paramInt = i1;
    if (this.w != null)
    {
      paramInt = i1;
      if (!paramBoolean) {
        paramInt = i1 - this.x.getMeasuredWidth() + this.x.getPaddingLeft();
      }
    }
    return paramInt;
  }
  
  private int a(@NonNull Rect paramRect, float paramFloat)
  {
    if (D()) {
      return (int)(paramRect.centerY() - paramFloat / 2.0F);
    }
    return paramRect.top + this.a.getCompoundPaddingTop();
  }
  
  private int a(@NonNull Rect paramRect1, @NonNull Rect paramRect2, float paramFloat)
  {
    if (D()) {
      return (int)(paramRect2.top + paramFloat);
    }
    return paramRect1.bottom - this.a.getCompoundPaddingBottom();
  }
  
  @NonNull
  private Rect a(@NonNull Rect paramRect)
  {
    if (this.a != null)
    {
      Rect localRect = this.P;
      boolean bool;
      if (ViewCompat.getLayoutDirection(this) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localRect.bottom = paramRect.bottom;
      int i1 = this.H;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          localRect.left = a(paramRect.left, bool);
          localRect.top = getPaddingTop();
          localRect.right = b(paramRect.right, bool);
          return localRect;
        }
        paramRect.left += this.a.getPaddingLeft();
        paramRect.top -= C();
        paramRect.right -= this.a.getPaddingRight();
        return localRect;
      }
      localRect.left = a(paramRect.left, bool);
      paramRect.top += this.I;
      localRect.right = b(paramRect.right, bool);
      return localRect;
    }
    throw new IllegalStateException();
  }
  
  private static void a(@NonNull Context paramContext, @NonNull TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = R.string.c;
    } else {
      i1 = R.string.b;
    }
    paramTextView.setContentDescription(paramContext.getString(i1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if (this.A) {
      this.c.a(paramCanvas);
    }
  }
  
  private void a(@NonNull RectF paramRectF)
  {
    paramRectF.left -= this.G;
    paramRectF.top -= this.G;
    paramRectF.right += this.G;
    paramRectF.bottom += this.G;
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = isEnabled();
    Object localObject = this.a;
    int i1;
    if ((localObject != null) && (!TextUtils.isEmpty(((EditText)localObject).getText()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = this.a;
    int i2;
    if ((localObject != null) && (((EditText)localObject).hasFocus())) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool2 = this.j.g();
    localObject = this.as;
    if (localObject != null)
    {
      this.c.a((ColorStateList)localObject);
      this.c.b(this.as);
    }
    if (!bool1)
    {
      localObject = this.as;
      int i3;
      if (localObject != null)
      {
        i3 = this.aC;
        i3 = ((ColorStateList)localObject).getColorForState(new int[] { -16842910 }, i3);
      }
      else
      {
        i3 = this.aC;
      }
      this.c.a(ColorStateList.valueOf(i3));
      this.c.b(ColorStateList.valueOf(i3));
    }
    else if (bool2)
    {
      this.c.a(this.j.k());
    }
    else
    {
      if (this.l)
      {
        localObject = this.m;
        if (localObject != null)
        {
          this.c.a(((TextView)localObject).getTextColors());
          break label259;
        }
      }
      if (i2 != 0)
      {
        localObject = this.at;
        if (localObject != null) {
          this.c.a((ColorStateList)localObject);
        }
      }
    }
    label259:
    if ((i1 == 0) && (this.aE) && ((!isEnabled()) || (i2 == 0)))
    {
      if ((paramBoolean2) || (!this.aD)) {
        d(paramBoolean1);
      }
    }
    else if ((paramBoolean2) || (this.aD)) {
      c(paramBoolean1);
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
    int i1 = paramInt - this.a.getCompoundPaddingRight();
    paramInt = i1;
    if (this.w != null)
    {
      paramInt = i1;
      if (paramBoolean) {
        paramInt = i1 + (this.x.getMeasuredWidth() - this.x.getPaddingRight());
      }
    }
    return paramInt;
  }
  
  @NonNull
  private Rect b(@NonNull Rect paramRect)
  {
    if (this.a != null)
    {
      Rect localRect = this.P;
      float f1 = this.c.b();
      paramRect.left += this.a.getCompoundPaddingLeft();
      localRect.top = a(paramRect, f1);
      paramRect.right -= this.a.getCompoundPaddingRight();
      localRect.bottom = a(paramRect, localRect, f1);
      return localRect;
    }
    throw new IllegalStateException();
  }
  
  private void b(int paramInt)
  {
    if ((paramInt == 0) && (!this.aD))
    {
      t();
      return;
    }
    u();
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject = this.E;
    if (localObject != null)
    {
      localObject = ((MaterialShapeDrawable)localObject).getBounds();
      ((Rect)localObject).top = (((Rect)localObject).bottom - this.J);
      this.E.draw(paramCanvas);
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
    if ((paramBoolean) && (getEndIconDrawable() != null))
    {
      Drawable localDrawable = DrawableCompat.wrap(getEndIconDrawable()).mutate();
      DrawableCompat.setTint(localDrawable, this.j.j());
      this.af.setImageDrawable(localDrawable);
      return;
    }
    O();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.ax.getDefaultColor();
    int i2 = this.ax.getColorForState(new int[] { 16843623, 16842910 }, i1);
    int i3 = this.ax.getColorForState(new int[] { 16843518, 16842910 }, i1);
    if (paramBoolean1)
    {
      this.M = i3;
      return;
    }
    if (paramBoolean2)
    {
      this.M = i2;
      return;
    }
    this.M = i1;
  }
  
  private void c(int paramInt)
  {
    Iterator localIterator = this.ag.iterator();
    while (localIterator.hasNext()) {
      ((TextInputLayout.OnEndIconChangedListener)localIterator.next()).a(this, paramInt);
    }
  }
  
  private void c(@NonNull Rect paramRect)
  {
    if (this.E != null)
    {
      int i1 = paramRect.bottom;
      int i2 = this.L;
      this.E.setBounds(paramRect.left, i1 - i2, paramRect.right, paramRect.bottom);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.aG;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.aG.cancel();
    }
    if ((paramBoolean) && (this.aF)) {
      a(1.0F);
    } else {
      this.c.b(1.0F);
    }
    this.aD = false;
    if (S()) {
      T();
    }
    s();
    x();
    z();
  }
  
  private void d(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.aG;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.aG.cancel();
    }
    if ((paramBoolean) && (this.aF)) {
      a(0.0F);
    } else {
      this.c.b(0.0F);
    }
    if ((S()) && (((CutoutDrawable)this.D).a())) {
      U();
    }
    this.aD = true;
    u();
    x();
    z();
  }
  
  private EndIconDelegate getEndIconDelegate()
  {
    EndIconDelegate localEndIconDelegate = (EndIconDelegate)this.ae.get(this.ad);
    if (localEndIconDelegate != null) {
      return localEndIconDelegate;
    }
    return (EndIconDelegate)this.ae.get(0);
  }
  
  @Nullable
  private CheckableImageButton getEndIconToUpdateDummyDrawable()
  {
    if (this.aq.getVisibility() == 0) {
      return this.aq;
    }
    if ((N()) && (g())) {
      return this.af;
    }
    return null;
  }
  
  private void k()
  {
    l();
    m();
    i();
    o();
    p();
    if (this.H != 0) {
      q();
    }
  }
  
  private void l()
  {
    int i1 = this.H;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          if ((this.A) && (!(this.D instanceof CutoutDrawable))) {
            this.D = new CutoutDrawable(this.F);
          } else {
            this.D = new MaterialShapeDrawable(this.F);
          }
          this.E = null;
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.H);
        localStringBuilder.append(" is illegal; only @BoxBackgroundMode constants are supported.");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      this.D = new MaterialShapeDrawable(this.F);
      this.E = new MaterialShapeDrawable();
      return;
    }
    this.D = null;
    this.E = null;
  }
  
  private void m()
  {
    if (n()) {
      ViewCompat.setBackground(this.a, this.D);
    }
  }
  
  private boolean n()
  {
    EditText localEditText = this.a;
    return (localEditText != null) && (this.D != null) && (localEditText.getBackground() == null) && (this.H != 0);
  }
  
  private void o()
  {
    if (this.H == 1)
    {
      if (MaterialResources.b(getContext()))
      {
        this.I = getResources().getDimensionPixelSize(R.dimen.B);
        return;
      }
      if (MaterialResources.a(getContext())) {
        this.I = getResources().getDimensionPixelSize(R.dimen.A);
      }
    }
  }
  
  private void p()
  {
    if (this.a != null)
    {
      if (this.H != 1) {
        return;
      }
      EditText localEditText;
      if (MaterialResources.b(getContext()))
      {
        localEditText = this.a;
        ViewCompat.setPaddingRelative(localEditText, ViewCompat.getPaddingStart(localEditText), getResources().getDimensionPixelSize(R.dimen.z), ViewCompat.getPaddingEnd(this.a), getResources().getDimensionPixelSize(R.dimen.y));
        return;
      }
      if (MaterialResources.a(getContext()))
      {
        localEditText = this.a;
        ViewCompat.setPaddingRelative(localEditText, ViewCompat.getPaddingStart(localEditText), getResources().getDimensionPixelSize(R.dimen.x), ViewCompat.getPaddingEnd(this.a), getResources().getDimensionPixelSize(R.dimen.w));
      }
    }
  }
  
  private void q()
  {
    if (this.H != 1)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
      int i1 = C();
      if (i1 != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i1;
        this.e.requestLayout();
      }
    }
  }
  
  private void r()
  {
    if (this.m != null)
    {
      EditText localEditText = this.a;
      int i1;
      if (localEditText == null) {
        i1 = 0;
      } else {
        i1 = localEditText.getText().length();
      }
      a(i1);
    }
  }
  
  private void s()
  {
    EditText localEditText = this.a;
    int i1;
    if (localEditText == null) {
      i1 = 0;
    } else {
      i1 = localEditText.getText().length();
    }
    b(i1);
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.a == null)
    {
      if ((this.ad != 3) && (!(paramEditText instanceof TextInputEditText))) {
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
      }
      this.a = paramEditText;
      k();
      setTextInputAccessibilityDelegate(new TextInputLayout.AccessibilityDelegate(this));
      this.c.c(this.a.getTypeface());
      this.c.a(this.a.getTextSize());
      int i1 = this.a.getGravity();
      this.c.b(i1 & 0xFFFFFF8F | 0x30);
      this.c.a(i1);
      this.a.addTextChangedListener(new TextInputLayout.1(this));
      if (this.as == null) {
        this.as = this.a.getHintTextColors();
      }
      if (this.A)
      {
        if (TextUtils.isEmpty(this.B))
        {
          this.i = this.a.getHint();
          setHint(this.i);
          this.a.setHint(null);
        }
        this.C = true;
      }
      if (this.m != null) {
        a(this.a.getText().length());
      }
      c();
      this.j.d();
      this.f.bringToFront();
      this.g.bringToFront();
      this.h.bringToFront();
      this.aq.bringToFront();
      L();
      y();
      A();
      if (!isEnabled()) {
        paramEditText.setEnabled(false);
      }
      a(false, true);
      return;
    }
    throw new IllegalArgumentException("We already have an EditText, can only have one");
  }
  
  private void setErrorIconVisible(boolean paramBoolean)
  {
    Object localObject = this.aq;
    int i2 = 0;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((CheckableImageButton)localObject).setVisibility(i1);
    localObject = this.h;
    int i1 = i2;
    if (paramBoolean) {
      i1 = 8;
    }
    ((FrameLayout)localObject).setVisibility(i1);
    A();
    if (!N()) {
      P();
    }
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.B))
    {
      this.B = paramCharSequence;
      this.c.a(paramCharSequence);
      if (!this.aD) {
        T();
      }
    }
  }
  
  private void setPlaceholderTextEnabled(boolean paramBoolean)
  {
    if (this.q == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      this.r = new AppCompatTextView(getContext());
      this.r.setId(R.id.ai);
      ViewCompat.setAccessibilityLiveRegion(this.r, 1);
      setPlaceholderTextAppearance(this.t);
      setPlaceholderTextColor(this.s);
      v();
    }
    else
    {
      w();
      this.r = null;
    }
    this.q = paramBoolean;
  }
  
  private void t()
  {
    TextView localTextView = this.r;
    if ((localTextView != null) && (this.q))
    {
      localTextView.setText(this.p);
      this.r.setVisibility(0);
      this.r.bringToFront();
    }
  }
  
  private void u()
  {
    TextView localTextView = this.r;
    if ((localTextView != null) && (this.q))
    {
      localTextView.setText(null);
      this.r.setVisibility(4);
    }
  }
  
  private void v()
  {
    TextView localTextView = this.r;
    if (localTextView != null)
    {
      this.e.addView(localTextView);
      this.r.setVisibility(0);
    }
  }
  
  private void w()
  {
    TextView localTextView = this.r;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void x()
  {
    TextView localTextView = this.x;
    int i1;
    if ((this.w != null) && (!j())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localTextView.setVisibility(i1);
    P();
  }
  
  private void y()
  {
    if (this.a == null) {
      return;
    }
    int i1;
    if (d()) {
      i1 = 0;
    } else {
      i1 = ViewCompat.getPaddingStart(this.a);
    }
    ViewCompat.setPaddingRelative(this.x, i1, this.a.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.F), this.a.getCompoundPaddingBottom());
  }
  
  private void z()
  {
    int i2 = this.z.getVisibility();
    Object localObject = this.y;
    int i1 = 0;
    boolean bool;
    if ((localObject != null) && (!j())) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = this.z;
    if (!bool) {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    if (i2 != this.z.getVisibility()) {
      getEndIconDelegate().a(bool);
    }
    P();
  }
  
  @VisibleForTesting
  void a(float paramFloat)
  {
    if (this.c.j() == paramFloat) {
      return;
    }
    if (this.aG == null)
    {
      this.aG = new ValueAnimator();
      this.aG.setInterpolator(AnimationUtils.b);
      this.aG.setDuration(167L);
      this.aG.addUpdateListener(new TextInputLayout.4(this));
    }
    this.aG.setFloatValues(new float[] { this.c.j(), paramFloat });
    this.aG.start();
  }
  
  void a(int paramInt)
  {
    boolean bool2 = this.l;
    int i1 = this.k;
    if (i1 == -1)
    {
      this.m.setText(String.valueOf(paramInt));
      this.m.setContentDescription(null);
      this.l = false;
    }
    else
    {
      boolean bool1;
      if (paramInt > i1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.l = bool1;
      a(getContext(), this.m, paramInt, this.k, this.l);
      if (bool2 != this.l) {
        B();
      }
      BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
      this.m.setText(localBidiFormatter.unicodeWrap(getContext().getString(R.string.d, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.k) })));
    }
    if ((this.a != null) && (bool2 != this.l))
    {
      a(false);
      i();
      c();
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
      TextViewCompat.setTextAppearance(paramTextView, R.style.d);
      paramTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.b));
    }
  }
  
  public void a(@NonNull TextInputLayout.OnEditTextAttachedListener paramOnEditTextAttachedListener)
  {
    this.ac.add(paramOnEditTextAttachedListener);
    if (this.a != null) {
      paramOnEditTextAttachedListener.a(this);
    }
  }
  
  public void a(@NonNull TextInputLayout.OnEndIconChangedListener paramOnEndIconChangedListener)
  {
    this.ag.add(paramOnEndIconChangedListener);
  }
  
  void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean a()
  {
    return this.C;
  }
  
  public void addView(@NonNull View paramView, int paramInt, @NonNull ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.e.addView(paramView, localLayoutParams);
      this.e.setLayoutParams(paramLayoutParams);
      q();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean b()
  {
    return this.j.f();
  }
  
  void c()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (this.H != 0) {
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
      if (this.j.g())
      {
        ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.j.j(), PorterDuff.Mode.SRC_IN));
        return;
      }
      if (this.l)
      {
        localObject2 = this.m;
        if (localObject2 != null)
        {
          ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(((TextView)localObject2).getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
          return;
        }
      }
      DrawableCompat.clearColorFilter((Drawable)localObject1);
      this.a.refreshDrawableState();
    }
  }
  
  public boolean d()
  {
    return this.S.getVisibility() == 0;
  }
  
  protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> paramSparseArray)
  {
    this.aI = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.aI = false;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.aH) {
      return;
    }
    boolean bool2 = true;
    this.aH = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    CollapsingTextHelper localCollapsingTextHelper = this.c;
    boolean bool1;
    if (localCollapsingTextHelper != null) {
      bool1 = localCollapsingTextHelper.a(arrayOfInt) | false;
    } else {
      bool1 = false;
    }
    if (this.a != null)
    {
      if ((!ViewCompat.isLaidOut(this)) || (!isEnabled())) {
        bool2 = false;
      }
      a(bool2);
    }
    c();
    i();
    if (bool1) {
      invalidate();
    }
    this.aH = false;
  }
  
  public void e()
  {
    a(this.S, this.T);
  }
  
  public void f()
  {
    a(this.aq, this.ar);
  }
  
  public boolean g()
  {
    return (this.h.getVisibility() == 0) && (this.af.getVisibility() == 0);
  }
  
  public int getBaseline()
  {
    EditText localEditText = this.a;
    if (localEditText != null) {
      return localEditText.getBaseline() + getPaddingTop() + C();
    }
    return super.getBaseline();
  }
  
  @NonNull
  MaterialShapeDrawable getBoxBackground()
  {
    int i1 = this.H;
    if ((i1 != 1) && (i1 != 2)) {
      throw new IllegalStateException();
    }
    return this.D;
  }
  
  public int getBoxBackgroundColor()
  {
    return this.N;
  }
  
  public int getBoxBackgroundMode()
  {
    return this.H;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.D.ad();
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.D.ae();
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.D.ac();
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.D.ab();
  }
  
  public int getBoxStrokeColor()
  {
    return this.aw;
  }
  
  @Nullable
  public ColorStateList getBoxStrokeErrorColor()
  {
    return this.ax;
  }
  
  public int getBoxStrokeWidth()
  {
    return this.K;
  }
  
  public int getBoxStrokeWidthFocused()
  {
    return this.L;
  }
  
  public int getCounterMaxLength()
  {
    return this.k;
  }
  
  @Nullable
  CharSequence getCounterOverflowDescription()
  {
    if ((this.b) && (this.l))
    {
      TextView localTextView = this.m;
      if (localTextView != null) {
        return localTextView.getContentDescription();
      }
    }
    return null;
  }
  
  @Nullable
  public ColorStateList getCounterOverflowTextColor()
  {
    return this.u;
  }
  
  @Nullable
  public ColorStateList getCounterTextColor()
  {
    return this.u;
  }
  
  @Nullable
  public ColorStateList getDefaultHintTextColor()
  {
    return this.as;
  }
  
  @Nullable
  public EditText getEditText()
  {
    return this.a;
  }
  
  @Nullable
  public CharSequence getEndIconContentDescription()
  {
    return this.af.getContentDescription();
  }
  
  @Nullable
  public Drawable getEndIconDrawable()
  {
    return this.af.getDrawable();
  }
  
  public int getEndIconMode()
  {
    return this.ad;
  }
  
  @NonNull
  CheckableImageButton getEndIconView()
  {
    return this.af;
  }
  
  @Nullable
  public CharSequence getError()
  {
    if (this.j.e()) {
      return this.j.h();
    }
    return null;
  }
  
  @Nullable
  public CharSequence getErrorContentDescription()
  {
    return this.j.l();
  }
  
  @ColorInt
  public int getErrorCurrentTextColors()
  {
    return this.j.j();
  }
  
  @Nullable
  public Drawable getErrorIconDrawable()
  {
    return this.aq.getDrawable();
  }
  
  @VisibleForTesting
  final int getErrorTextCurrentColor()
  {
    return this.j.j();
  }
  
  @Nullable
  public CharSequence getHelperText()
  {
    if (this.j.f()) {
      return this.j.i();
    }
    return null;
  }
  
  @ColorInt
  public int getHelperTextCurrentTextColor()
  {
    return this.j.m();
  }
  
  @Nullable
  public CharSequence getHint()
  {
    if (this.A) {
      return this.B;
    }
    return null;
  }
  
  @VisibleForTesting
  final float getHintCollapsedTextHeight()
  {
    return this.c.c();
  }
  
  @VisibleForTesting
  final int getHintCurrentCollapsedTextColor()
  {
    return this.c.k();
  }
  
  @Nullable
  public ColorStateList getHintTextColor()
  {
    return this.at;
  }
  
  @Deprecated
  @Nullable
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.af.getContentDescription();
  }
  
  @Deprecated
  @Nullable
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.af.getDrawable();
  }
  
  @Nullable
  public CharSequence getPlaceholderText()
  {
    if (this.q) {
      return this.p;
    }
    return null;
  }
  
  @StyleRes
  public int getPlaceholderTextAppearance()
  {
    return this.t;
  }
  
  @Nullable
  public ColorStateList getPlaceholderTextColor()
  {
    return this.s;
  }
  
  @Nullable
  public CharSequence getPrefixText()
  {
    return this.w;
  }
  
  @Nullable
  public ColorStateList getPrefixTextColor()
  {
    return this.x.getTextColors();
  }
  
  @NonNull
  public TextView getPrefixTextView()
  {
    return this.x;
  }
  
  @Nullable
  public CharSequence getStartIconContentDescription()
  {
    return this.S.getContentDescription();
  }
  
  @Nullable
  public Drawable getStartIconDrawable()
  {
    return this.S.getDrawable();
  }
  
  @Nullable
  public CharSequence getSuffixText()
  {
    return this.y;
  }
  
  @Nullable
  public ColorStateList getSuffixTextColor()
  {
    return this.z.getTextColors();
  }
  
  @NonNull
  public TextView getSuffixTextView()
  {
    return this.z;
  }
  
  @Nullable
  public Typeface getTypeface()
  {
    return this.R;
  }
  
  public void h()
  {
    a(this.af, this.ah);
  }
  
  void i()
  {
    if (this.D != null)
    {
      if (this.H == 0) {
        return;
      }
      boolean bool1 = isFocused();
      boolean bool4 = false;
      Object localObject;
      if (!bool1)
      {
        localObject = this.a;
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
        localObject = this.a;
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
        this.M = this.aC;
      }
      else if (this.j.g())
      {
        if (this.ax != null) {
          b(bool1, bool2);
        } else {
          this.M = this.j.j();
        }
      }
      else
      {
        if (this.l)
        {
          localObject = this.m;
          if (localObject != null)
          {
            if (this.ax != null)
            {
              b(bool1, bool2);
              break label234;
            }
            this.M = ((TextView)localObject).getCurrentTextColor();
            break label234;
          }
        }
        if (bool1) {
          this.M = this.aw;
        } else if (bool2) {
          this.M = this.av;
        } else {
          this.M = this.au;
        }
      }
      label234:
      boolean bool3 = bool4;
      if (getErrorIconDrawable() != null)
      {
        bool3 = bool4;
        if (this.j.e())
        {
          bool3 = bool4;
          if (this.j.g()) {
            bool3 = true;
          }
        }
      }
      setErrorIconVisible(bool3);
      f();
      e();
      h();
      if (getEndIconDelegate().b()) {
        b(this.j.g());
      }
      if ((bool1) && (isEnabled())) {
        this.J = this.L;
      } else {
        this.J = this.K;
      }
      if (this.H == 1) {
        if (!isEnabled()) {
          this.N = this.az;
        } else if ((bool2) && (!bool1)) {
          this.N = this.aB;
        } else if (bool1) {
          this.N = this.aA;
        } else {
          this.N = this.ay;
        }
      }
      F();
    }
  }
  
  @VisibleForTesting
  final boolean j()
  {
    return this.aD;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    EditText localEditText = this.a;
    if (localEditText != null)
    {
      Rect localRect = this.O;
      DescendantOffsetUtils.b(this, localEditText, localRect);
      c(localRect);
      if (this.A)
      {
        this.c.a(this.a.getTextSize());
        paramInt1 = this.a.getGravity();
        this.c.b(paramInt1 & 0xFFFFFF8F | 0x30);
        this.c.a(paramInt1);
        this.c.b(a(localRect));
        this.c.a(b(localRect));
        this.c.l();
        if ((S()) && (!this.aD)) {
          T();
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    boolean bool1 = J();
    boolean bool2 = P();
    if ((bool1) || (bool2)) {
      this.a.post(new TextInputLayout.3(this));
    }
    K();
    y();
    A();
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
    setError(paramParcelable.a);
    if (paramParcelable.b) {
      this.af.post(new TextInputLayout.2(this));
    }
    setHint(paramParcelable.c);
    setHelperText(paramParcelable.d);
    setPlaceholderText(paramParcelable.e);
    requestLayout();
  }
  
  @Nullable
  public Parcelable onSaveInstanceState()
  {
    TextInputLayout.SavedState localSavedState = new TextInputLayout.SavedState(super.onSaveInstanceState());
    if (this.j.g()) {
      localSavedState.a = getError();
    }
    boolean bool;
    if ((N()) && (this.af.isChecked())) {
      bool = true;
    } else {
      bool = false;
    }
    localSavedState.b = bool;
    localSavedState.c = getHint();
    localSavedState.d = getHelperText();
    localSavedState.e = getPlaceholderText();
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(@ColorInt int paramInt)
  {
    if (this.N != paramInt)
    {
      this.N = paramInt;
      this.ay = paramInt;
      this.aA = paramInt;
      this.aB = paramInt;
      F();
    }
  }
  
  public void setBoxBackgroundColorResource(@ColorRes int paramInt)
  {
    setBoxBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setBoxBackgroundColorStateList(@NonNull ColorStateList paramColorStateList)
  {
    this.ay = paramColorStateList.getDefaultColor();
    this.N = this.ay;
    this.az = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
    this.aA = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);
    this.aB = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
    F();
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.H) {
      return;
    }
    this.H = paramInt;
    if (this.a != null) {
      k();
    }
  }
  
  public void setBoxCornerRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.D;
    if ((localMaterialShapeDrawable == null) || (localMaterialShapeDrawable.ab() != paramFloat1) || (this.D.ac() != paramFloat2) || (this.D.ae() != paramFloat4) || (this.D.ad() != paramFloat3))
    {
      this.F = this.F.n().b(paramFloat1).c(paramFloat2).d(paramFloat4).e(paramFloat3).a();
      F();
    }
  }
  
  public void setBoxCornerRadiiResources(@DimenRes int paramInt1, @DimenRes int paramInt2, @DimenRes int paramInt3, @DimenRes int paramInt4)
  {
    setBoxCornerRadii(getContext().getResources().getDimension(paramInt1), getContext().getResources().getDimension(paramInt2), getContext().getResources().getDimension(paramInt4), getContext().getResources().getDimension(paramInt3));
  }
  
  public void setBoxStrokeColor(@ColorInt int paramInt)
  {
    if (this.aw != paramInt)
    {
      this.aw = paramInt;
      i();
    }
  }
  
  public void setBoxStrokeColorStateList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.isStateful())
    {
      this.au = paramColorStateList.getDefaultColor();
      this.aC = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
      this.av = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
      this.aw = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);
    }
    else if (this.aw != paramColorStateList.getDefaultColor())
    {
      this.aw = paramColorStateList.getDefaultColor();
    }
    i();
  }
  
  public void setBoxStrokeErrorColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.ax != paramColorStateList)
    {
      this.ax = paramColorStateList;
      i();
    }
  }
  
  public void setBoxStrokeWidth(int paramInt)
  {
    this.K = paramInt;
    i();
  }
  
  public void setBoxStrokeWidthFocused(int paramInt)
  {
    this.L = paramInt;
    i();
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
    if (this.b != paramBoolean)
    {
      if (paramBoolean)
      {
        this.m = new AppCompatTextView(getContext());
        this.m.setId(R.id.af);
        Typeface localTypeface = this.R;
        if (localTypeface != null) {
          this.m.setTypeface(localTypeface);
        }
        this.m.setMaxLines(1);
        this.j.a(this.m, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)this.m.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.au));
        B();
        r();
      }
      else
      {
        this.j.b(this.m, 2);
        this.m = null;
      }
      this.b = paramBoolean;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.k != paramInt)
    {
      if (paramInt > 0) {
        this.k = paramInt;
      } else {
        this.k = -1;
      }
      if (this.b) {
        r();
      }
    }
  }
  
  public void setCounterOverflowTextAppearance(int paramInt)
  {
    if (this.n != paramInt)
    {
      this.n = paramInt;
      B();
    }
  }
  
  public void setCounterOverflowTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.v != paramColorStateList)
    {
      this.v = paramColorStateList;
      B();
    }
  }
  
  public void setCounterTextAppearance(int paramInt)
  {
    if (this.o != paramInt)
    {
      this.o = paramInt;
      B();
    }
  }
  
  public void setCounterTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.u != paramColorStateList)
    {
      this.u = paramColorStateList;
      B();
    }
  }
  
  public void setDefaultHintTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.as = paramColorStateList;
    this.at = paramColorStateList;
    if (this.a != null) {
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
    this.af.setActivated(paramBoolean);
  }
  
  public void setEndIconCheckable(boolean paramBoolean)
  {
    this.af.setCheckable(paramBoolean);
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
    if (getEndIconContentDescription() != paramCharSequence) {
      this.af.setContentDescription(paramCharSequence);
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
    this.af.setImageDrawable(paramDrawable);
    h();
  }
  
  public void setEndIconMode(int paramInt)
  {
    int i1 = this.ad;
    this.ad = paramInt;
    c(i1);
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    setEndIconVisible(bool);
    if (getEndIconDelegate().a(this.H))
    {
      getEndIconDelegate().a();
      O();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The current box background mode ");
    localStringBuilder.append(this.H);
    localStringBuilder.append(" is not supported by the end icon mode ");
    localStringBuilder.append(paramInt);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void setEndIconOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    a(this.af, paramOnClickListener, this.ao);
  }
  
  public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.ao = paramOnLongClickListener;
    a(this.af, paramOnLongClickListener);
  }
  
  public void setEndIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.ah != paramColorStateList)
    {
      this.ah = paramColorStateList;
      this.ai = true;
      O();
    }
  }
  
  public void setEndIconTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.aj != paramMode)
    {
      this.aj = paramMode;
      this.ak = true;
      O();
    }
  }
  
  public void setEndIconVisible(boolean paramBoolean)
  {
    if (g() != paramBoolean)
    {
      CheckableImageButton localCheckableImageButton = this.af;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localCheckableImageButton.setVisibility(i1);
      A();
      P();
    }
  }
  
  public void setError(@Nullable CharSequence paramCharSequence)
  {
    if (!this.j.e())
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.j.b(paramCharSequence);
      return;
    }
    this.j.b();
  }
  
  public void setErrorContentDescription(@Nullable CharSequence paramCharSequence)
  {
    this.j.c(paramCharSequence);
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    this.j.a(paramBoolean);
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
    f();
  }
  
  public void setErrorIconDrawable(@Nullable Drawable paramDrawable)
  {
    this.aq.setImageDrawable(paramDrawable);
    boolean bool;
    if ((paramDrawable != null) && (this.j.e())) {
      bool = true;
    } else {
      bool = false;
    }
    setErrorIconVisible(bool);
  }
  
  public void setErrorIconOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    a(this.aq, paramOnClickListener, this.ap);
  }
  
  public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.ap = paramOnLongClickListener;
    a(this.aq, paramOnLongClickListener);
  }
  
  public void setErrorIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.ar = paramColorStateList;
    Drawable localDrawable2 = this.aq.getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 != null)
    {
      localDrawable1 = DrawableCompat.wrap(localDrawable2).mutate();
      DrawableCompat.setTintList(localDrawable1, paramColorStateList);
    }
    if (this.aq.getDrawable() != localDrawable1) {
      this.aq.setImageDrawable(localDrawable1);
    }
  }
  
  public void setErrorIconTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    Drawable localDrawable2 = this.aq.getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 != null)
    {
      localDrawable1 = DrawableCompat.wrap(localDrawable2).mutate();
      DrawableCompat.setTintMode(localDrawable1, paramMode);
    }
    if (this.aq.getDrawable() != localDrawable1) {
      this.aq.setImageDrawable(localDrawable1);
    }
  }
  
  public void setErrorTextAppearance(@StyleRes int paramInt)
  {
    this.j.b(paramInt);
  }
  
  public void setErrorTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.j.a(paramColorStateList);
  }
  
  public void setExpandedHintEnabled(boolean paramBoolean)
  {
    if (this.aE != paramBoolean)
    {
      this.aE = paramBoolean;
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
      this.j.a(paramCharSequence);
    }
  }
  
  public void setHelperTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.j.b(paramColorStateList);
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    this.j.b(paramBoolean);
  }
  
  public void setHelperTextTextAppearance(@StyleRes int paramInt)
  {
    this.j.c(paramInt);
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
    if (this.A)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.aF = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.A)
    {
      this.A = paramBoolean;
      if (!this.A)
      {
        this.C = false;
        if ((!TextUtils.isEmpty(this.B)) && (TextUtils.isEmpty(this.a.getHint()))) {
          this.a.setHint(this.B);
        }
        setHintInternal(null);
      }
      else
      {
        CharSequence localCharSequence = this.a.getHint();
        if (!TextUtils.isEmpty(localCharSequence))
        {
          if (TextUtils.isEmpty(this.B)) {
            setHint(localCharSequence);
          }
          this.a.setHint(null);
        }
        this.C = true;
      }
      if (this.a != null) {
        q();
      }
    }
  }
  
  public void setHintTextAppearance(@StyleRes int paramInt)
  {
    this.c.c(paramInt);
    this.at = this.c.o();
    if (this.a != null)
    {
      a(false);
      q();
    }
  }
  
  public void setHintTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.at != paramColorStateList)
    {
      if (this.as == null) {
        this.c.a(paramColorStateList);
      }
      this.at = paramColorStateList;
      if (this.a != null) {
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
    this.af.setContentDescription(paramCharSequence);
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
    this.af.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.ad != 1))
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
    this.ah = paramColorStateList;
    this.ai = true;
    O();
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.aj = paramMode;
    this.ak = true;
    O();
  }
  
  public void setPlaceholderText(@Nullable CharSequence paramCharSequence)
  {
    if ((this.q) && (TextUtils.isEmpty(paramCharSequence)))
    {
      setPlaceholderTextEnabled(false);
    }
    else
    {
      if (!this.q) {
        setPlaceholderTextEnabled(true);
      }
      this.p = paramCharSequence;
    }
    s();
  }
  
  public void setPlaceholderTextAppearance(@StyleRes int paramInt)
  {
    this.t = paramInt;
    TextView localTextView = this.r;
    if (localTextView != null) {
      TextViewCompat.setTextAppearance(localTextView, paramInt);
    }
  }
  
  public void setPlaceholderTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.s != paramColorStateList)
    {
      this.s = paramColorStateList;
      TextView localTextView = this.r;
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
    this.w = localCharSequence;
    this.x.setText(paramCharSequence);
    x();
  }
  
  public void setPrefixTextAppearance(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.x, paramInt);
  }
  
  public void setPrefixTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.x.setTextColor(paramColorStateList);
  }
  
  public void setStartIconCheckable(boolean paramBoolean)
  {
    this.S.setCheckable(paramBoolean);
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
    if (getStartIconContentDescription() != paramCharSequence) {
      this.S.setContentDescription(paramCharSequence);
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
    this.S.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      setStartIconVisible(true);
      e();
      return;
    }
    setStartIconVisible(false);
    setStartIconOnClickListener(null);
    setStartIconOnLongClickListener(null);
    setStartIconContentDescription(null);
  }
  
  public void setStartIconOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    a(this.S, paramOnClickListener, this.ab);
  }
  
  public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.ab = paramOnLongClickListener;
    a(this.S, paramOnLongClickListener);
  }
  
  public void setStartIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.T != paramColorStateList)
    {
      this.T = paramColorStateList;
      this.U = true;
      M();
    }
  }
  
  public void setStartIconTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.V != paramMode)
    {
      this.V = paramMode;
      this.W = true;
      M();
    }
  }
  
  public void setStartIconVisible(boolean paramBoolean)
  {
    if (d() != paramBoolean)
    {
      CheckableImageButton localCheckableImageButton = this.S;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localCheckableImageButton.setVisibility(i1);
      y();
      P();
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
    this.y = localCharSequence;
    this.z.setText(paramCharSequence);
    z();
  }
  
  public void setSuffixTextAppearance(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.z, paramInt);
  }
  
  public void setSuffixTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.z.setTextColor(paramColorStateList);
  }
  
  public void setTextInputAccessibilityDelegate(@Nullable TextInputLayout.AccessibilityDelegate paramAccessibilityDelegate)
  {
    EditText localEditText = this.a;
    if (localEditText != null) {
      ViewCompat.setAccessibilityDelegate(localEditText, paramAccessibilityDelegate);
    }
  }
  
  public void setTypeface(@Nullable Typeface paramTypeface)
  {
    if (paramTypeface != this.R)
    {
      this.R = paramTypeface;
      this.c.c(paramTypeface);
      this.j.a(paramTypeface);
      TextView localTextView = this.m;
      if (localTextView != null) {
        localTextView.setTypeface(paramTypeface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */