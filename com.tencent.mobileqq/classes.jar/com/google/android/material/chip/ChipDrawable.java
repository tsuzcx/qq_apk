package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable
  extends MaterialShapeDrawable
  implements Drawable.Callback, TintAwareDrawable, TextDrawableHelper.TextDrawableDelegate
{
  private static final ShapeDrawable jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new OvalShape());
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842910 };
  private float jdField_a_of_type_Float;
  @ColorInt
  private int jdField_a_of_type_Int;
  @NonNull
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @Nullable
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private final Paint.FontMetrics jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = new Paint.FontMetrics();
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  @Nullable
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = PorterDuff.Mode.SRC_IN;
  @Nullable
  private PorterDuffColorFilter jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextUtils.TruncateAt jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  @Nullable
  private MotionSpec jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
  @NonNull
  private final TextDrawableHelper jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper;
  @Nullable
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  @NonNull
  private WeakReference<ChipDrawable.Delegate> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = -1.0F;
  @ColorInt
  private int jdField_b_of_type_Int;
  @Nullable
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  @Nullable
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  @Nullable
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private MotionSpec jdField_b_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
  @Nullable
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  private float jdField_c_of_type_Float;
  @ColorInt
  private int jdField_c_of_type_Int;
  @Nullable
  private ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  @Nullable
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  @ColorInt
  private int jdField_d_of_type_Int;
  @Nullable
  private ColorStateList jdField_d_of_type_AndroidContentResColorStateList;
  @Nullable
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  @ColorInt
  private int jdField_e_of_type_Int;
  @Nullable
  private ColorStateList jdField_e_of_type_AndroidContentResColorStateList;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  @ColorInt
  private int jdField_f_of_type_Int;
  @Nullable
  private ColorStateList jdField_f_of_type_AndroidContentResColorStateList;
  private boolean jdField_f_of_type_Boolean;
  private float jdField_g_of_type_Float;
  @ColorInt
  private int jdField_g_of_type_Int;
  @Nullable
  private ColorStateList jdField_g_of_type_AndroidContentResColorStateList;
  private boolean jdField_g_of_type_Boolean;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int = 255;
  @Nullable
  private ColorStateList jdField_h_of_type_AndroidContentResColorStateList;
  private boolean jdField_h_of_type_Boolean;
  private float jdField_i_of_type_Float;
  private int jdField_i_of_type_Int;
  @Nullable
  private ColorStateList jdField_i_of_type_AndroidContentResColorStateList;
  private boolean jdField_i_of_type_Boolean;
  private float j;
  private float k;
  private float l;
  private float m;
  
  private ChipDrawable(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper = new TextDrawableHelper(this);
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().density = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_AndroidGraphicsPaint = null;
    paramContext = this.jdField_b_of_type_AndroidGraphicsPaint;
    if (paramContext != null) {
      paramContext.setStyle(Paint.Style.STROKE);
    }
    setState(jdField_a_of_type_ArrayOfInt);
    a(jdField_a_of_type_ArrayOfInt);
    this.jdField_h_of_type_Boolean = true;
    if (RippleUtils.jdField_a_of_type_Boolean) {
      jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.setTint(-1);
    }
  }
  
  @Nullable
  private ColorFilter a()
  {
    ColorFilter localColorFilter = this.jdField_a_of_type_AndroidGraphicsColorFilter;
    if (localColorFilter != null) {
      return localColorFilter;
    }
    return this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter;
  }
  
  @NonNull
  public static ChipDrawable a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramContext = new ChipDrawable(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext.a(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  private void a(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, d(), d(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void a(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if ((i()) || (j()))
    {
      float f1 = this.jdField_f_of_type_Float + this.jdField_g_of_type_Float;
      float f2 = r();
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.left = (paramRect.left + f1);
        paramRectF.right = (paramRectF.left + f2);
      }
      else
      {
        paramRectF.right = (paramRect.right - f1);
        paramRectF.left = (paramRectF.right - f2);
      }
      f1 = s();
      paramRectF.top = (paramRect.exactCenterY() - f1 / 2.0F);
      paramRectF.bottom = (paramRectF.top + f1);
    }
  }
  
  private void a(@Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    TypedArray localTypedArray = ThemeEnforcement.a(this.jdField_a_of_type_AndroidContentContext, paramAttributeSet, R.styleable.j, paramInt1, paramInt2, new int[0]);
    this.jdField_i_of_type_Boolean = localTypedArray.hasValue(R.styleable.aN);
    i(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aA));
    a(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.an));
    a(localTypedArray.getDimension(R.styleable.av, 0.0F));
    if (localTypedArray.hasValue(R.styleable.ao)) {
      b(localTypedArray.getDimension(R.styleable.ao, 0.0F));
    }
    b(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.ay));
    c(localTypedArray.getDimension(R.styleable.az, 0.0F));
    c(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aM));
    a(localTypedArray.getText(R.styleable.ah));
    TextAppearance localTextAppearance = MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.ac);
    localTextAppearance.jdField_e_of_type_Float = localTypedArray.getDimension(R.styleable.ad, localTextAppearance.jdField_e_of_type_Float);
    a(localTextAppearance);
    paramInt1 = localTypedArray.getInt(R.styleable.af, 0);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          a(TextUtils.TruncateAt.END);
        }
      }
      else {
        a(TextUtils.TruncateAt.MIDDLE);
      }
    }
    else {
      a(TextUtils.TruncateAt.START);
    }
    b(localTypedArray.getBoolean(R.styleable.au, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)) {
      b(localTypedArray.getBoolean(R.styleable.ar, false));
    }
    a(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aq));
    if (localTypedArray.hasValue(R.styleable.at)) {
      d(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.at));
    }
    d(localTypedArray.getDimension(R.styleable.as, -1.0F));
    c(localTypedArray.getBoolean(R.styleable.aH, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)) {
      c(localTypedArray.getBoolean(R.styleable.aC, false));
    }
    b(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aB));
    e(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aG));
    e(localTypedArray.getDimension(R.styleable.aE, 0.0F));
    d(localTypedArray.getBoolean(R.styleable.ai, false));
    e(localTypedArray.getBoolean(R.styleable.am, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)) {
      e(localTypedArray.getBoolean(R.styleable.ak, false));
    }
    c(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aj));
    if (localTypedArray.hasValue(R.styleable.al)) {
      f(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.al));
    }
    a(MotionSpec.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aO));
    b(MotionSpec.a(this.jdField_a_of_type_AndroidContentContext, localTypedArray, R.styleable.aJ));
    f(localTypedArray.getDimension(R.styleable.ax, 0.0F));
    g(localTypedArray.getDimension(R.styleable.aL, 0.0F));
    h(localTypedArray.getDimension(R.styleable.aK, 0.0F));
    i(localTypedArray.getDimension(R.styleable.aQ, 0.0F));
    j(localTypedArray.getDimension(R.styleable.aP, 0.0F));
    k(localTypedArray.getDimension(R.styleable.aF, 0.0F));
    l(localTypedArray.getDimension(R.styleable.aD, 0.0F));
    m(localTypedArray.getDimension(R.styleable.ap, 0.0F));
    C(localTypedArray.getDimensionPixelSize(R.styleable.ag, 2147483647));
    localTypedArray.recycle();
  }
  
  private static boolean a(@Nullable ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  private static boolean a(@Nullable Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful());
  }
  
  private static boolean a(@Nullable TextAppearance paramTextAppearance)
  {
    return (paramTextAppearance != null) && (paramTextAppearance.jdField_a_of_type_AndroidContentResColorStateList != null) && (paramTextAppearance.jdField_a_of_type_AndroidContentResColorStateList.isStateful());
  }
  
  private static boolean a(@Nullable int[] paramArrayOfInt, @AttrRes int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int i1 = paramArrayOfInt.length;
    int n = 0;
    while (n < i1)
    {
      if (paramArrayOfInt[n] == paramInt) {
        return true;
      }
      n += 1;
    }
    return false;
  }
  
  private boolean a(@NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    Object localObject = this.jdField_a_of_type_AndroidContentResColorStateList;
    if (localObject != null) {
      n = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.jdField_a_of_type_Int);
    } else {
      n = 0;
    }
    int i1 = a(n);
    if (this.jdField_a_of_type_Int != i1)
    {
      this.jdField_a_of_type_Int = i1;
      bool1 = true;
    }
    localObject = this.jdField_b_of_type_AndroidContentResColorStateList;
    if (localObject != null) {
      n = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.jdField_b_of_type_Int);
    } else {
      n = 0;
    }
    int n = a(n);
    if (this.jdField_b_of_type_Int != n)
    {
      this.jdField_b_of_type_Int = n;
      bool1 = true;
    }
    int i2 = MaterialColors.a(i1, n);
    if (this.jdField_c_of_type_Int != i2) {
      n = 1;
    } else {
      n = 0;
    }
    if (b() == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((n | i1) != 0)
    {
      this.jdField_c_of_type_Int = i2;
      g(ColorStateList.valueOf(this.jdField_c_of_type_Int));
      bool1 = true;
    }
    localObject = this.jdField_c_of_type_AndroidContentResColorStateList;
    if (localObject != null) {
      n = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.jdField_d_of_type_Int);
    } else {
      n = 0;
    }
    if (this.jdField_d_of_type_Int != n)
    {
      this.jdField_d_of_type_Int = n;
      bool1 = true;
    }
    if ((this.jdField_i_of_type_AndroidContentResColorStateList != null) && (RippleUtils.a(paramArrayOfInt1))) {
      n = this.jdField_i_of_type_AndroidContentResColorStateList.getColorForState(paramArrayOfInt1, this.jdField_e_of_type_Int);
    } else {
      n = 0;
    }
    boolean bool2 = bool1;
    if (this.jdField_e_of_type_Int != n)
    {
      this.jdField_e_of_type_Int = n;
      bool2 = bool1;
      if (this.jdField_g_of_type_Boolean) {
        bool2 = true;
      }
    }
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a() != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().jdField_a_of_type_AndroidContentResColorStateList != null)) {
      n = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramArrayOfInt1, this.jdField_f_of_type_Int);
    } else {
      n = 0;
    }
    bool1 = bool2;
    if (this.jdField_f_of_type_Int != n)
    {
      this.jdField_f_of_type_Int = n;
      bool1 = true;
    }
    boolean bool3;
    if ((a(getState(), 16842912)) && (this.jdField_d_of_type_Boolean)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    bool2 = bool1;
    if (this.jdField_f_of_type_Boolean != bool3)
    {
      bool2 = bool1;
      if (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        float f1 = a();
        this.jdField_f_of_type_Boolean = bool3;
        if (f1 != a())
        {
          bool2 = true;
          n = 1;
          break label461;
        }
        bool2 = true;
      }
    }
    n = 0;
    label461:
    localObject = this.jdField_h_of_type_AndroidContentResColorStateList;
    if (localObject != null) {
      i1 = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.jdField_g_of_type_Int);
    } else {
      i1 = 0;
    }
    if (this.jdField_g_of_type_Int != i1)
    {
      this.jdField_g_of_type_Int = i1;
      this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = DrawableUtils.a(this, this.jdField_h_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
      bool2 = true;
    }
    bool1 = bool2;
    if (a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
      bool1 = bool2 | this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(paramArrayOfInt1);
    }
    bool2 = bool1;
    if (a(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable)) {
      bool2 = bool1 | this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setState(paramArrayOfInt1);
    }
    bool1 = bool2;
    if (a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable))
    {
      localObject = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
      System.arraycopy(paramArrayOfInt1, 0, localObject, 0, paramArrayOfInt1.length);
      System.arraycopy(paramArrayOfInt2, 0, localObject, paramArrayOfInt1.length, paramArrayOfInt2.length);
      bool1 = bool2 | this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState((int[])localObject);
    }
    bool2 = bool1;
    if (RippleUtils.jdField_a_of_type_Boolean)
    {
      bool2 = bool1;
      if (a(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable)) {
        bool2 = bool1 | this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(paramArrayOfInt2);
      }
    }
    if (bool2) {
      invalidateSelf();
    }
    if (n != 0) {
      b();
    }
    return bool2;
  }
  
  private void b(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(a());
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, d(), d(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void b(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      float f1 = this.jdField_f_of_type_Float + a() + this.jdField_i_of_type_Float;
      float f2 = this.m + b() + this.j;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.left = (paramRect.left + f1);
        paramRectF.right = (paramRect.right - f2);
      }
      else
      {
        paramRectF.left = (paramRect.left + f2);
        paramRectF.right = (paramRect.right - f1);
      }
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    }
  }
  
  private void c()
  {
    ColorStateList localColorStateList;
    if (this.jdField_g_of_type_Boolean) {
      localColorStateList = RippleUtils.b(this.jdField_d_of_type_AndroidContentResColorStateList);
    } else {
      localColorStateList = null;
    }
    this.jdField_i_of_type_AndroidContentResColorStateList = localColorStateList;
  }
  
  private void c(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if ((this.jdField_c_of_type_Float > 0.0F) && (!this.jdField_i_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      if (!this.jdField_i_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(a());
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect.left + this.jdField_c_of_type_Float / 2.0F, paramRect.top + this.jdField_c_of_type_Float / 2.0F, paramRect.right - this.jdField_c_of_type_Float / 2.0F, paramRect.bottom - this.jdField_c_of_type_Float / 2.0F);
      float f1 = this.jdField_b_of_type_Float - this.jdField_c_of_type_Float / 2.0F;
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void c(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (k())
    {
      float f1 = this.m + this.l;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.right = (paramRect.right - f1);
        paramRectF.left = (paramRectF.right - this.jdField_e_of_type_Float);
      }
      else
      {
        paramRectF.left = (paramRect.left + f1);
        paramRectF.right = (paramRectF.left + this.jdField_e_of_type_Float);
      }
      paramRectF.top = (paramRect.exactCenterY() - this.jdField_e_of_type_Float / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.jdField_e_of_type_Float);
    }
  }
  
  @TargetApi(21)
  private void d()
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = new RippleDrawable(RippleUtils.b(a()), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable);
  }
  
  private void d(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect);
    if (!this.jdField_i_of_type_Boolean)
    {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, d(), d(), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    a(new RectF(paramRect), this.jdField_a_of_type_AndroidGraphicsPath);
    super.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPath, a());
  }
  
  private void d(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.set(paramRect);
    if (k())
    {
      float f1 = this.m + this.l + this.jdField_e_of_type_Float + this.k + this.j;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.right = (paramRect.right - f1);
        return;
      }
      paramRectF.left = (paramRect.left + f1);
    }
  }
  
  private void d(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void e(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (i())
    {
      a(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
      paramCanvas.translate(f1, f2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.jdField_a_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void e(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (k())
    {
      float f1 = this.m + this.l + this.jdField_e_of_type_Float + this.k + this.j;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.right = paramRect.right;
        paramRectF.left = (paramRectF.right - f1);
      }
      else
      {
        paramRectF.left = paramRect.left;
        paramRectF.right = (paramRect.left + f1);
      }
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    }
  }
  
  private void e(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setCallback(this);
    DrawableCompat.setLayoutDirection(paramDrawable, DrawableCompat.getLayoutDirection(this));
    paramDrawable.setLevel(getLevel());
    paramDrawable.setVisible(isVisible(), false);
    if (paramDrawable == this.jdField_b_of_type_AndroidGraphicsDrawableDrawable)
    {
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(a());
      }
      DrawableCompat.setTintList(paramDrawable, this.jdField_f_of_type_AndroidContentResColorStateList);
      return;
    }
    if (paramDrawable.isStateful()) {
      paramDrawable.setState(getState());
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((paramDrawable == localDrawable) && (this.jdField_b_of_type_Boolean)) {
      DrawableCompat.setTintList(localDrawable, this.jdField_e_of_type_AndroidContentResColorStateList);
    }
  }
  
  private void f(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (j())
    {
      a(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
      paramCanvas.translate(f1, f2);
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.jdField_a_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height());
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void g(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      Object localObject = a(paramRect, this.jdField_a_of_type_AndroidGraphicsPointF);
      b(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a() != null)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().drawableState = getState();
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().setTextAlign((Paint.Align)localObject);
      int n = Math.round(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(a().toString()));
      int i2 = Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.width());
      int i1 = 0;
      if (n > i2) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        i1 = paramCanvas.save();
        paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      }
      localObject = this.jdField_a_of_type_JavaLangCharSequence;
      paramRect = (Rect)localObject;
      if (n != 0)
      {
        paramRect = (Rect)localObject;
        if (this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt != null) {
          paramRect = TextUtils.ellipsize((CharSequence)localObject, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(), this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt);
        }
      }
      paramCanvas.drawText(paramRect, 0, paramRect.length(), this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a());
      if (n != 0) {
        paramCanvas.restoreToCount(i1);
      }
    }
  }
  
  private void h(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (k())
    {
      c(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
      paramCanvas.translate(f1, f2);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.jdField_a_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height());
      if (RippleUtils.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getBounds());
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      else
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void i(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  private void i(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
    if (localPaint != null)
    {
      localPaint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
      paramCanvas.drawRect(paramRect, this.jdField_b_of_type_AndroidGraphicsPaint);
      if ((i()) || (j()))
      {
        a(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        paramCanvas.drawLine(paramRect.left, paramRect.exactCenterY(), paramRect.right, paramRect.exactCenterY(), this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      if (k())
      {
        c(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
      d(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
      e(paramRect, this.jdField_a_of_type_AndroidGraphicsRectF);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  private boolean i()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null);
  }
  
  private boolean j()
  {
    return (this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_f_of_type_Boolean);
  }
  
  private boolean k()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null);
  }
  
  private boolean l()
  {
    return (this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_d_of_type_Boolean);
  }
  
  private float r()
  {
    Drawable localDrawable;
    if (this.jdField_f_of_type_Boolean) {
      localDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    if ((this.jdField_d_of_type_Float <= 0.0F) && (localDrawable != null)) {
      return localDrawable.getIntrinsicWidth();
    }
    return this.jdField_d_of_type_Float;
  }
  
  private float s()
  {
    Drawable localDrawable;
    if (this.jdField_f_of_type_Boolean) {
      localDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    if ((this.jdField_d_of_type_Float <= 0.0F) && (localDrawable != null))
    {
      float f1 = (float)Math.ceil(ViewUtils.a(this.jdField_a_of_type_AndroidContentContext, 24));
      if (localDrawable.getIntrinsicHeight() <= f1) {
        return localDrawable.getIntrinsicHeight();
      }
      return f1;
    }
    return this.jdField_d_of_type_Float;
  }
  
  private float t()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().getFontMetrics(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics);
    return (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.descent + this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.ascent) / 2.0F;
  }
  
  public void A(@DimenRes int paramInt)
  {
    l(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void B(@DimenRes int paramInt)
  {
    m(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void C(@Px int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  float a()
  {
    if ((!i()) && (!j())) {
      return 0.0F;
    }
    return this.jdField_g_of_type_Float + r() + this.jdField_h_of_type_Float;
  }
  
  @Nullable
  public ColorStateList a()
  {
    return this.jdField_d_of_type_AndroidContentResColorStateList;
  }
  
  @NonNull
  Paint.Align a(@NonNull Rect paramRect, @NonNull PointF paramPointF)
  {
    paramPointF.set(0.0F, 0.0F);
    Paint.Align localAlign = Paint.Align.LEFT;
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      float f1 = this.jdField_f_of_type_Float + a() + this.jdField_i_of_type_Float;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramPointF.x = (paramRect.left + f1);
        localAlign = Paint.Align.LEFT;
      }
      else
      {
        paramPointF.x = (paramRect.right - f1);
        localAlign = Paint.Align.RIGHT;
      }
      paramPointF.y = (paramRect.centerY() - t());
    }
    return localAlign;
  }
  
  @Nullable
  public Drawable a()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  public TextUtils.TruncateAt a()
  {
    return this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  }
  
  @Nullable
  public TextAppearance a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a();
  }
  
  @Nullable
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public void a()
  {
    b();
    invalidateSelf();
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void a(@ColorRes int paramInt)
  {
    a(AppCompatResources.getColorStateList(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void a(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void a(@NonNull RectF paramRectF)
  {
    e(getBounds(), paramRectF);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = a();
    if (localDrawable != paramDrawable)
    {
      float f1 = a();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      float f2 = a();
      d(localDrawable);
      if (i()) {
        e(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public void a(@Nullable TextUtils.TruncateAt paramTruncateAt)
  {
    this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt = paramTruncateAt;
  }
  
  public void a(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec = paramMotionSpec;
  }
  
  public void a(@Nullable ChipDrawable.Delegate paramDelegate)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDelegate);
  }
  
  public void a(@Nullable TextAppearance paramTextAppearance)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(paramTextAppearance, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(@Nullable CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangCharSequence, (CharSequence)localObject))
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(true);
      invalidateSelf();
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
      c();
      onStateChange(getState());
    }
  }
  
  public boolean a()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public boolean a(@NonNull int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.jdField_b_of_type_ArrayOfInt, paramArrayOfInt))
    {
      this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt;
      if (k()) {
        return a(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  @NonNull
  public int[] a()
  {
    return this.jdField_b_of_type_ArrayOfInt;
  }
  
  float b()
  {
    if (k()) {
      return this.k + this.jdField_e_of_type_Float + this.l;
    }
    return 0.0F;
  }
  
  @Nullable
  public Drawable b()
  {
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  @Nullable
  public CharSequence b()
  {
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  protected void b()
  {
    ChipDrawable.Delegate localDelegate = (ChipDrawable.Delegate)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localDelegate != null) {
      localDelegate.a();
    }
  }
  
  @Deprecated
  public void b(float paramFloat)
  {
    if (this.jdField_b_of_type_Float != paramFloat)
    {
      this.jdField_b_of_type_Float = paramFloat;
      setShapeAppearanceModel(a().a(paramFloat));
    }
  }
  
  public void b(@DimenRes int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void b(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_c_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_c_of_type_AndroidContentResColorStateList = paramColorStateList;
      if (this.jdField_i_of_type_Boolean) {
        h(paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void b(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = b();
    if (localDrawable != paramDrawable)
    {
      float f1 = b();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (RippleUtils.jdField_a_of_type_Boolean) {
        d();
      }
      float f2 = b();
      d(localDrawable);
      if (k()) {
        e(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public void b(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialAnimationMotionSpec = paramMotionSpec;
  }
  
  public void b(@Nullable CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_JavaLangCharSequence != paramCharSequence)
    {
      this.jdField_b_of_type_JavaLangCharSequence = BidiFormatter.getInstance().unicodeWrap(paramCharSequence);
      invalidateSelf();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      boolean bool = i();
      this.jdField_a_of_type_Boolean = paramBoolean;
      paramBoolean = i();
      int n;
      if (bool != paramBoolean) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        if (paramBoolean) {
          e(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        } else {
          d(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        invalidateSelf();
        b();
      }
    }
  }
  
  public boolean b()
  {
    return a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public float c()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void c(float paramFloat)
  {
    if (this.jdField_c_of_type_Float != paramFloat)
    {
      this.jdField_c_of_type_Float = paramFloat;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat);
      if (this.jdField_i_of_type_Boolean) {
        super.n(paramFloat);
      }
      invalidateSelf();
    }
  }
  
  @Deprecated
  public void c(@DimenRes int paramInt)
  {
    b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void c(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_d_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_d_of_type_AndroidContentResColorStateList = paramColorStateList;
      c();
      onStateChange(getState());
    }
  }
  
  public void c(@Nullable Drawable paramDrawable)
  {
    if (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      float f1 = a();
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      float f2 = a();
      d(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
      e(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      boolean bool = k();
      this.jdField_c_of_type_Boolean = paramBoolean;
      paramBoolean = k();
      int n;
      if (bool != paramBoolean) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        if (paramBoolean) {
          e(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        } else {
          d(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        }
        invalidateSelf();
        b();
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public float d()
  {
    if (this.jdField_i_of_type_Boolean) {
      return n();
    }
    return this.jdField_b_of_type_Float;
  }
  
  public void d(float paramFloat)
  {
    if (this.jdField_d_of_type_Float != paramFloat)
    {
      float f1 = a();
      this.jdField_d_of_type_Float = paramFloat;
      paramFloat = a();
      invalidateSelf();
      if (f1 != paramFloat) {
        b();
      }
    }
  }
  
  public void d(@ColorRes int paramInt)
  {
    b(AppCompatResources.getColorStateList(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void d(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_e_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_e_of_type_AndroidContentResColorStateList = paramColorStateList;
      if (i()) {
        DrawableCompat.setTintList(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      float f1 = a();
      if ((!paramBoolean) && (this.jdField_f_of_type_Boolean)) {
        this.jdField_f_of_type_Boolean = false;
      }
      float f2 = a();
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (!localRect.isEmpty())
    {
      if (getAlpha() == 0) {
        return;
      }
      int n = 0;
      if (this.jdField_h_of_type_Int < 255) {
        n = CanvasCompat.a(paramCanvas, localRect.left, localRect.top, localRect.right, localRect.bottom, this.jdField_h_of_type_Int);
      }
      a(paramCanvas, localRect);
      b(paramCanvas, localRect);
      if (this.jdField_i_of_type_Boolean) {
        super.draw(paramCanvas);
      }
      c(paramCanvas, localRect);
      d(paramCanvas, localRect);
      e(paramCanvas, localRect);
      f(paramCanvas, localRect);
      if (this.jdField_h_of_type_Boolean) {
        g(paramCanvas, localRect);
      }
      h(paramCanvas, localRect);
      i(paramCanvas, localRect);
      if (this.jdField_h_of_type_Int < 255) {
        paramCanvas.restoreToCount(n);
      }
    }
  }
  
  public float e()
  {
    return this.jdField_f_of_type_Float;
  }
  
  public void e(float paramFloat)
  {
    if (this.jdField_e_of_type_Float != paramFloat)
    {
      this.jdField_e_of_type_Float = paramFloat;
      invalidateSelf();
      if (k()) {
        b();
      }
    }
  }
  
  public void e(@DimenRes int paramInt)
  {
    c(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void e(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_f_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_f_of_type_AndroidContentResColorStateList = paramColorStateList;
      if (k()) {
        DrawableCompat.setTintList(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean != paramBoolean)
    {
      boolean bool = j();
      this.jdField_e_of_type_Boolean = paramBoolean;
      paramBoolean = j();
      int n;
      if (bool != paramBoolean) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        if (paramBoolean) {
          e(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
        } else {
          d(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
        }
        invalidateSelf();
        b();
      }
    }
  }
  
  boolean e()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public float f()
  {
    return this.jdField_i_of_type_Float;
  }
  
  public void f(float paramFloat)
  {
    if (this.jdField_f_of_type_Float != paramFloat)
    {
      this.jdField_f_of_type_Float = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void f(@ColorRes int paramInt)
  {
    c(AppCompatResources.getColorStateList(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void f(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_g_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_g_of_type_AndroidContentResColorStateList = paramColorStateList;
      if (l()) {
        DrawableCompat.setTintList(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  void f(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public float g()
  {
    return this.j;
  }
  
  public void g(float paramFloat)
  {
    if (this.jdField_g_of_type_Float != paramFloat)
    {
      float f1 = a();
      this.jdField_g_of_type_Float = paramFloat;
      paramFloat = a();
      invalidateSelf();
      if (f1 != paramFloat) {
        b();
      }
    }
  }
  
  public void g(@StyleRes int paramInt)
  {
    a(new TextAppearance(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public int getAlpha()
  {
    return this.jdField_h_of_type_Int;
  }
  
  @Nullable
  public ColorFilter getColorFilter()
  {
    return this.jdField_a_of_type_AndroidGraphicsColorFilter;
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.jdField_a_of_type_Float;
  }
  
  public int getIntrinsicWidth()
  {
    return Math.min(Math.round(this.jdField_f_of_type_Float + a() + this.jdField_i_of_type_Float + this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(a().toString()) + this.j + b() + this.m), this.jdField_i_of_type_Int);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.jdField_i_of_type_Boolean)
    {
      super.getOutline(paramOutline);
      return;
    }
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, this.jdField_b_of_type_Float);
    } else {
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.jdField_b_of_type_Float);
    }
    paramOutline.setAlpha(getAlpha() / 255.0F);
  }
  
  public float h()
  {
    return this.m;
  }
  
  public void h(float paramFloat)
  {
    if (this.jdField_h_of_type_Float != paramFloat)
    {
      float f1 = a();
      this.jdField_h_of_type_Float = paramFloat;
      paramFloat = a();
      invalidateSelf();
      if (f1 != paramFloat) {
        b();
      }
    }
  }
  
  public void h(@BoolRes int paramInt)
  {
    b(this.jdField_a_of_type_AndroidContentContext.getResources().getBoolean(paramInt));
  }
  
  public void i(float paramFloat)
  {
    if (this.jdField_i_of_type_Float != paramFloat)
    {
      this.jdField_i_of_type_Float = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void i(@DrawableRes int paramInt)
  {
    a(AppCompatResources.getDrawable(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public boolean isStateful()
  {
    return (a(this.jdField_a_of_type_AndroidContentResColorStateList)) || (a(this.jdField_b_of_type_AndroidContentResColorStateList)) || (a(this.jdField_c_of_type_AndroidContentResColorStateList)) || ((this.jdField_g_of_type_Boolean) && (a(this.jdField_i_of_type_AndroidContentResColorStateList))) || (a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a())) || (l()) || (a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) || (a(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable)) || (a(this.jdField_h_of_type_AndroidContentResColorStateList));
  }
  
  public void j(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      this.j = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void j(@ColorRes int paramInt)
  {
    d(AppCompatResources.getColorStateList(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void k(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      invalidateSelf();
      if (k()) {
        b();
      }
    }
  }
  
  public void k(@DimenRes int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void l(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      this.l = paramFloat;
      invalidateSelf();
      if (k()) {
        b();
      }
    }
  }
  
  public void l(@DrawableRes int paramInt)
  {
    b(AppCompatResources.getDrawable(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void m(float paramFloat)
  {
    if (this.m != paramFloat)
    {
      this.m = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void m(@ColorRes int paramInt)
  {
    e(AppCompatResources.getColorStateList(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void n(@DimenRes int paramInt)
  {
    e(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void o(@BoolRes int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentContext.getResources().getBoolean(paramInt));
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (i()) {
      bool1 = bool2 | DrawableCompat.setLayoutDirection(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt);
    }
    bool2 = bool1;
    if (j()) {
      bool2 = bool1 | DrawableCompat.setLayoutDirection(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable, paramInt);
    }
    bool1 = bool2;
    if (k()) {
      bool1 = bool2 | DrawableCompat.setLayoutDirection(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (i()) {
      bool1 = bool2 | this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setLevel(paramInt);
    }
    bool2 = bool1;
    if (j()) {
      bool2 = bool1 | this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setLevel(paramInt);
    }
    bool1 = bool2;
    if (k()) {
      bool1 = bool2 | this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public boolean onStateChange(@NonNull int[] paramArrayOfInt)
  {
    if (this.jdField_i_of_type_Boolean) {
      super.onStateChange(paramArrayOfInt);
    }
    return a(paramArrayOfInt, a());
  }
  
  public void p(@BoolRes int paramInt)
  {
    e(this.jdField_a_of_type_AndroidContentContext.getResources().getBoolean(paramInt));
  }
  
  public void q(@DrawableRes int paramInt)
  {
    c(AppCompatResources.getDrawable(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void r(@ColorRes int paramInt)
  {
    f(AppCompatResources.getColorStateList(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void s(@AnimatorRes int paramInt)
  {
    a(MotionSpec.a(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.jdField_h_of_type_Int != paramInt)
    {
      this.jdField_h_of_type_Int = paramInt;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    if (this.jdField_a_of_type_AndroidGraphicsColorFilter != paramColorFilter)
    {
      this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_h_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_h_of_type_AndroidContentResColorStateList = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = DrawableUtils.a(this, this.jdField_h_of_type_AndroidContentResColorStateList, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (i()) {
      bool1 = bool2 | this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (j()) {
      bool2 = bool1 | this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (k()) {
      bool1 = bool2 | this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public void t(@AnimatorRes int paramInt)
  {
    b(MotionSpec.a(this.jdField_a_of_type_AndroidContentContext, paramInt));
  }
  
  public void u(@DimenRes int paramInt)
  {
    f(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public void v(@DimenRes int paramInt)
  {
    g(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void w(@DimenRes int paramInt)
  {
    h(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void x(@DimenRes int paramInt)
  {
    i(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void y(@DimenRes int paramInt)
  {
    j(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
  
  public void z(@DimenRes int paramInt)
  {
    k(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.chip.ChipDrawable
 * JD-Core Version:    0.7.0.1
 */