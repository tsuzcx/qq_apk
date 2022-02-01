package com.google.android.material.slider;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>>
  extends View
{
  static final int jdField_a_of_type_Int = R.style.H;
  private static final String jdField_a_of_type_JavaLangString = "BaseSlider";
  private float jdField_a_of_type_Float;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  @NonNull
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private final AccessibilityManager jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager;
  @NonNull
  private final MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable();
  private BaseSlider<S, L, T>.AccessibilityEventSender jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityEventSender;
  @NonNull
  private final BaseSlider.AccessibilityHelper jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityHelper;
  @NonNull
  private final BaseSlider.TooltipDrawableFactory jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$TooltipDrawableFactory;
  private LabelFormatter jdField_a_of_type_ComGoogleAndroidMaterialSliderLabelFormatter;
  private ArrayList<Float> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @NonNull
  private final List<TooltipDrawable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  @NonNull
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  @NonNull
  private final List<L> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  @NonNull
  private ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Paint jdField_c_of_type_AndroidGraphicsPaint;
  @NonNull
  private final List<T> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int;
  @NonNull
  private ColorStateList jdField_d_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Paint jdField_d_of_type_AndroidGraphicsPaint;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  @NonNull
  private ColorStateList jdField_e_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Paint jdField_e_of_type_AndroidGraphicsPaint;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  @NonNull
  private final Paint jdField_f_of_type_AndroidGraphicsPaint;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = -1;
  private int n = -1;
  private int o;
  private int p = 0;
  
  public BaseSlider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.H);
  }
  
  public BaseSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_f_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_f_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    a(paramContext.getResources());
    this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$TooltipDrawableFactory = new BaseSlider.1(this, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.D(2);
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityHelper = new BaseSlider.AccessibilityHelper(this);
    ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityHelper);
    this.jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
  }
  
  private double a(float paramFloat)
  {
    float f1 = this.jdField_d_of_type_Float;
    if (f1 > 0.0F)
    {
      int i1 = (int)((this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) / f1);
      double d1 = Math.round(paramFloat * i1);
      double d2 = i1;
      Double.isNaN(d1);
      Double.isNaN(d2);
      return d1 / d2;
    }
    return paramFloat;
  }
  
  private float a(float paramFloat)
  {
    float f1 = this.jdField_b_of_type_Float;
    paramFloat = (paramFloat - f1) / (this.jdField_c_of_type_Float - f1);
    if (c()) {
      return 1.0F - paramFloat;
    }
    return paramFloat;
  }
  
  private float a(int paramInt)
  {
    float f1 = f();
    float f2 = (this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) / f1;
    float f3 = paramInt;
    if (f2 <= f3) {
      return f1;
    }
    return Math.round(f2 / f3) * f1;
  }
  
  private float a(int paramInt, float paramFloat)
  {
    float f2 = this.jdField_d_of_type_Float;
    float f1 = 0.0F;
    if (f2 == 0.0F) {
      f1 = c();
    }
    f2 = f1;
    if (this.p == 0) {
      f2 = b(f1);
    }
    f1 = f2;
    if (c()) {
      f1 = -f2;
    }
    int i1 = paramInt + 1;
    if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      f2 = this.jdField_c_of_type_Float;
    } else {
      f2 = ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).floatValue() - f1;
    }
    paramInt -= 1;
    if (paramInt < 0) {
      f1 = this.jdField_b_of_type_Float;
    } else {
      f1 = ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).floatValue() + f1;
    }
    return MathUtils.clamp(paramFloat, f1, f2);
  }
  
  private static float a(ValueAnimator paramValueAnimator, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramValueAnimator != null)
    {
      f1 = paramFloat;
      if (paramValueAnimator.isRunning())
      {
        f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
        paramValueAnimator.cancel();
      }
    }
    return f1;
  }
  
  @ColorInt
  private int a(@NonNull ColorStateList paramColorStateList)
  {
    return paramColorStateList.getColorForState(getDrawableState(), paramColorStateList.getDefaultColor());
  }
  
  private static int a(float[] paramArrayOfFloat, float paramFloat)
  {
    return Math.round(paramFloat * (paramArrayOfFloat.length / 2 - 1));
  }
  
  private ValueAnimator a(boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    Object localObject;
    if (paramBoolean) {
      localObject = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    } else {
      localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    }
    float f3 = a((ValueAnimator)localObject, f1);
    float f1 = f2;
    if (paramBoolean) {
      f1 = 1.0F;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 });
    long l1;
    if (paramBoolean) {
      l1 = 83L;
    } else {
      l1 = 117L;
    }
    localValueAnimator.setDuration(l1);
    if (paramBoolean) {
      localObject = AnimationUtils.e;
    } else {
      localObject = AnimationUtils.c;
    }
    localValueAnimator.setInterpolator((TimeInterpolator)localObject);
    localValueAnimator.addUpdateListener(new BaseSlider.2(this));
    return localValueAnimator;
  }
  
  private Boolean a(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (paramInt != 61)
    {
      if (paramInt != 66)
      {
        if (paramInt != 81) {
          if (paramInt != 69) {
            if (paramInt == 70) {
              break label91;
            }
          }
        }
        switch (paramInt)
        {
        default: 
          return null;
        case 22: 
          b(1);
          return Boolean.valueOf(true);
        case 21: 
          b(-1);
          return Boolean.valueOf(true);
          a(-1);
          return Boolean.valueOf(true);
          label91:
          a(1);
          return Boolean.valueOf(true);
        }
      }
      this.m = this.n;
      postInvalidate();
      return Boolean.valueOf(true);
    }
    if (paramKeyEvent.hasNoModifiers()) {
      return Boolean.valueOf(a(1));
    }
    if (paramKeyEvent.isShiftPressed()) {
      return Boolean.valueOf(a(-1));
    }
    return Boolean.valueOf(false);
  }
  
  private Float a(int paramInt)
  {
    float f1;
    if (this.jdField_e_of_type_Boolean) {
      f1 = a(20);
    } else {
      f1 = f();
    }
    if (paramInt != 21)
    {
      if (paramInt != 22)
      {
        if (paramInt != 69)
        {
          if ((paramInt != 70) && (paramInt != 81)) {
            return null;
          }
          return Float.valueOf(f1);
        }
        return Float.valueOf(-f1);
      }
      float f2 = f1;
      if (c()) {
        f2 = -f1;
      }
      return Float.valueOf(f2);
    }
    if (!c()) {
      f1 = -f1;
    }
    return Float.valueOf(f1);
  }
  
  private String a(float paramFloat)
  {
    if (a()) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialSliderLabelFormatter.a(paramFloat);
    }
    String str;
    if ((int)paramFloat == paramFloat) {
      str = "%.0f";
    } else {
      str = "%.2f";
    }
    return String.format(str, new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void a()
  {
    int i1 = Math.max(this.j - this.jdField_d_of_type_Int, 0);
    this.h = (this.jdField_c_of_type_Int + i1);
    if (ViewCompat.isLaidOut(this)) {
      c(getWidth());
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.ar, paramInt, jdField_a_of_type_Int, new int[0]);
    this.jdField_b_of_type_Float = localTypedArray.getFloat(R.styleable.eo, 0.0F);
    this.jdField_c_of_type_Float = localTypedArray.getFloat(R.styleable.ep, 1.0F);
    setValues(new Float[] { Float.valueOf(this.jdField_b_of_type_Float) });
    this.jdField_d_of_type_Float = localTypedArray.getFloat(R.styleable.en, 0.0F);
    boolean bool = localTypedArray.hasValue(R.styleable.eD);
    if (bool) {
      paramInt = R.styleable.eD;
    } else {
      paramInt = R.styleable.eF;
    }
    int i1;
    if (bool) {
      i1 = R.styleable.eD;
    } else {
      i1 = R.styleable.eE;
    }
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.k);
    }
    setTrackInactiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, i1);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.h);
    }
    setTrackActiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, R.styleable.eu);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(paramAttributeSet);
    if (localTypedArray.hasValue(R.styleable.ex)) {
      setThumbStrokeColor(MaterialResources.a(paramContext, localTypedArray, R.styleable.ex));
    }
    setThumbStrokeWidth(localTypedArray.getDimension(R.styleable.ey, 0.0F));
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, R.styleable.eq);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.i);
    }
    setHaloTintList(paramAttributeSet);
    this.jdField_c_of_type_Boolean = localTypedArray.getBoolean(R.styleable.eC, true);
    bool = localTypedArray.hasValue(R.styleable.ez);
    if (bool) {
      paramInt = R.styleable.ez;
    } else {
      paramInt = R.styleable.eB;
    }
    if (bool) {
      i1 = R.styleable.ez;
    } else {
      i1 = R.styleable.eA;
    }
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.j);
    }
    setTickInactiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, i1);
    if (paramAttributeSet != null) {
      paramContext = paramAttributeSet;
    } else {
      paramContext = AppCompatResources.getColorStateList(paramContext, R.color.g);
    }
    setTickActiveTintList(paramContext);
    setThumbRadius(localTypedArray.getDimensionPixelSize(R.styleable.ew, 0));
    setHaloRadius(localTypedArray.getDimensionPixelSize(R.styleable.er, 0));
    setThumbElevation(localTypedArray.getDimension(R.styleable.ev, 0.0F));
    setTrackHeight(localTypedArray.getDimensionPixelSize(R.styleable.eG, 0));
    this.jdField_f_of_type_Int = localTypedArray.getInt(R.styleable.es, 0);
    if (!localTypedArray.getBoolean(R.styleable.em, true)) {
      setEnabled(false);
    }
    localTypedArray.recycle();
  }
  
  private void a(@NonNull Resources paramResources)
  {
    this.jdField_e_of_type_Int = paramResources.getDimensionPixelSize(R.dimen.ao);
    this.jdField_c_of_type_Int = paramResources.getDimensionPixelOffset(R.dimen.am);
    this.h = this.jdField_c_of_type_Int;
    this.jdField_d_of_type_Int = paramResources.getDimensionPixelSize(R.dimen.al);
    this.i = paramResources.getDimensionPixelOffset(R.dimen.an);
    this.l = paramResources.getDimensionPixelSize(R.dimen.ak);
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Float <= 0.0F) {
        return;
      }
      float[] arrayOfFloat = a();
      int i2 = a(this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat[0]);
      int i1 = a(this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat[1]);
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      i2 *= 2;
      paramCanvas.drawPoints(arrayOfFloat, 0, i2, this.jdField_e_of_type_AndroidGraphicsPaint);
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      i1 *= 2;
      paramCanvas.drawPoints(arrayOfFloat, i2, i1 - i2, this.jdField_f_of_type_AndroidGraphicsPaint);
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      paramCanvas.drawPoints(arrayOfFloat, i1, arrayOfFloat.length - i1, this.jdField_e_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void a(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = a();
    int i1 = this.h;
    float f2 = i1;
    float f3 = arrayOfFloat[1];
    float f1 = paramInt1;
    f2 += f3 * f1;
    if (f2 < i1 + paramInt1)
    {
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, i1 + paramInt1, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramInt1 = this.h;
    f1 = paramInt1 + arrayOfFloat[0] * f1;
    if (f1 > paramInt1)
    {
      f2 = paramInt1;
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, f1, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void a(TooltipDrawable paramTooltipDrawable)
  {
    paramTooltipDrawable.a(ViewUtils.a(this));
  }
  
  private void a(TooltipDrawable paramTooltipDrawable, float paramFloat)
  {
    paramTooltipDrawable.a(a(paramFloat));
    int i1 = this.h + (int)(a(paramFloat) * this.o) - paramTooltipDrawable.getIntrinsicWidth() / 2;
    int i2 = b() - (this.l + this.j);
    paramTooltipDrawable.setBounds(i1, i2 - paramTooltipDrawable.getIntrinsicHeight(), paramTooltipDrawable.getIntrinsicWidth() + i1, i2);
    Rect localRect = new Rect(paramTooltipDrawable.getBounds());
    DescendantOffsetUtils.a(ViewUtils.a(this), this, localRect);
    paramTooltipDrawable.setBounds(localRect);
    ViewUtils.b(this).a(paramTooltipDrawable);
  }
  
  private void a(@NonNull ArrayList<Float> paramArrayList)
  {
    if (!paramArrayList.isEmpty())
    {
      Collections.sort(paramArrayList);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == paramArrayList.size()) && (this.jdField_a_of_type_JavaUtilArrayList.equals(paramArrayList))) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      this.jdField_f_of_type_Boolean = true;
      this.n = 0;
      j();
      h();
      n();
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("At least one value must be set");
  }
  
  private boolean a(float paramFloat)
  {
    double d1 = new BigDecimal(Float.toString(paramFloat)).subtract(new BigDecimal(Float.toString(this.jdField_b_of_type_Float))).divide(new BigDecimal(Float.toString(this.jdField_d_of_type_Float)), MathContext.DECIMAL64).doubleValue();
    double d2 = Math.round(d1);
    Double.isNaN(d2);
    return Math.abs(d2 - d1) < 0.0001D;
  }
  
  private boolean a(int paramInt)
  {
    int i1 = this.n;
    this.n = ((int)MathUtils.clamp(i1 + paramInt, 0L, this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    paramInt = this.n;
    if (paramInt == i1) {
      return false;
    }
    if (this.m != -1) {
      this.m = paramInt;
    }
    j();
    postInvalidate();
    return true;
  }
  
  private boolean a(int paramInt, float paramFloat)
  {
    if (Math.abs(paramFloat - ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).floatValue()) < 0.0001D) {
      return false;
    }
    paramFloat = a(paramInt, paramFloat);
    this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, Float.valueOf(paramFloat));
    this.n = paramInt;
    d(paramInt);
    return true;
  }
  
  private float[] a()
  {
    float f2 = ((Float)Collections.max(a())).floatValue();
    float f1 = ((Float)Collections.min(a())).floatValue();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1) {
      f1 = this.jdField_b_of_type_Float;
    }
    f1 = a(f1);
    f2 = a(f2);
    if (c()) {
      return new float[] { f2, f1 };
    }
    return new float[] { f1, f2 };
  }
  
  private float b(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    paramFloat = (paramFloat - this.h) / this.o;
    float f1 = this.jdField_b_of_type_Float;
    return paramFloat * (f1 - this.jdField_c_of_type_Float) + f1;
  }
  
  private int b()
  {
    int i2 = this.i;
    int i3 = this.jdField_f_of_type_Int;
    int i1 = 0;
    if (i3 == 1) {
      i1 = ((TooltipDrawable)this.jdField_a_of_type_JavaUtilList.get(0)).getIntrinsicHeight();
    }
    return i2 + i1;
  }
  
  @NonNull
  private static TooltipDrawable b(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray)
  {
    return TooltipDrawable.a(paramContext, null, 0, paramTypedArray.getResourceId(R.styleable.et, R.style.L));
  }
  
  private void b()
  {
    float f1 = this.jdField_b_of_type_Float;
    if (f1 < this.jdField_c_of_type_Float) {
      return;
    }
    throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[] { Float.toString(f1), Float.toString(this.jdField_c_of_type_Float) }));
  }
  
  private void b(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = a();
    int i1 = this.h;
    float f1 = i1;
    float f2 = arrayOfFloat[1];
    float f3 = paramInt1;
    float f4 = i1;
    float f5 = arrayOfFloat[0];
    float f6 = paramInt2;
    paramCanvas.drawLine(f4 + f5 * f3, f6, f1 + f2 * f3, f6, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  private void b(TooltipDrawable paramTooltipDrawable)
  {
    ViewOverlayImpl localViewOverlayImpl = ViewUtils.b(this);
    if (localViewOverlayImpl != null)
    {
      localViewOverlayImpl.b(paramTooltipDrawable);
      paramTooltipDrawable.b(ViewUtils.a(this));
    }
  }
  
  private boolean b(float paramFloat)
  {
    return a(this.m, paramFloat);
  }
  
  private boolean b(int paramInt)
  {
    int i1 = paramInt;
    if (c()) {
      if (paramInt == -2147483648) {
        i1 = 2147483647;
      } else {
        i1 = -paramInt;
      }
    }
    return a(i1);
  }
  
  private float c(float paramFloat)
  {
    return a(paramFloat) * this.o + this.h;
  }
  
  private void c()
  {
    float f1 = this.jdField_c_of_type_Float;
    if (f1 > this.jdField_b_of_type_Float) {
      return;
    }
    throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[] { Float.toString(f1), Float.toString(this.jdField_b_of_type_Float) }));
  }
  
  private void c(int paramInt)
  {
    this.o = Math.max(paramInt - this.h * 2, 0);
    i();
  }
  
  private void c(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Float localFloat;
    if (!isEnabled())
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localFloat = (Float)localIterator.next();
        paramCanvas.drawCircle(this.h + a(localFloat.floatValue()) * paramInt1, paramInt2, this.j, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localFloat = (Float)localIterator.next();
      paramCanvas.save();
      int i1 = this.h;
      int i2 = (int)(a(localFloat.floatValue()) * paramInt1);
      int i3 = this.j;
      paramCanvas.translate(i1 + i2 - i3, paramInt2 - i3);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private float d()
  {
    float f2 = this.jdField_e_of_type_Float;
    float f1 = f2;
    if (c()) {
      f1 = 1.0F - f2;
    }
    f2 = this.jdField_c_of_type_Float;
    float f3 = this.jdField_b_of_type_Float;
    return f1 * (f2 - f3) + f3;
  }
  
  private void d()
  {
    if (this.jdField_d_of_type_Float > 0.0F)
    {
      if (a(this.jdField_c_of_type_Float)) {
        return;
      }
      throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(this.jdField_d_of_type_Float), Float.toString(this.jdField_b_of_type_Float), Float.toString(this.jdField_c_of_type_Float) }));
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseOnChangeListener)((Iterator)localObject).next()).a(this, ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).floatValue(), true);
    }
    localObject = this.jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager;
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled())) {
      f(paramInt);
    }
  }
  
  private void d(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (d())
    {
      paramInt1 = (int)(this.h + a(((Float)this.jdField_a_of_type_JavaUtilArrayList.get(this.n)).floatValue()) * paramInt1);
      if (Build.VERSION.SDK_INT < 28)
      {
        int i1 = this.k;
        paramCanvas.clipRect(paramInt1 - i1, paramInt2 - i1, paramInt1 + i1, i1 + paramInt2, Region.Op.UNION);
      }
      paramCanvas.drawCircle(paramInt1, paramInt2, this.k, this.jdField_d_of_type_AndroidGraphicsPaint);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_d_of_type_Boolean) || (Build.VERSION.SDK_INT < 21) || (!(getBackground() instanceof RippleDrawable));
  }
  
  private float e()
  {
    double d2 = a(this.jdField_e_of_type_Float);
    double d1 = d2;
    if (c()) {
      d1 = 1.0D - d2;
    }
    float f1 = this.jdField_c_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    d2 = f1 - f2;
    Double.isNaN(d2);
    double d3 = f2;
    Double.isNaN(d3);
    return (float)(d1 * d2 + d3);
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Float localFloat = (Float)localIterator.next();
      if ((localFloat.floatValue() >= this.jdField_b_of_type_Float) && (localFloat.floatValue() <= this.jdField_c_of_type_Float))
      {
        if ((this.jdField_d_of_type_Float > 0.0F) && (!a(localFloat.floatValue()))) {
          throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[] { Float.toString(localFloat.floatValue()), Float.toString(this.jdField_b_of_type_Float), Float.toString(this.jdField_d_of_type_Float), Float.toString(this.jdField_d_of_type_Float) }));
        }
      }
      else {
        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[] { Float.toString(localFloat.floatValue()), Float.toString(this.jdField_b_of_type_Float), Float.toString(this.jdField_c_of_type_Float) }));
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 66) {
            return;
          }
          b(-2147483648);
          return;
        }
        b(2147483647);
        return;
      }
      a(-2147483648);
      return;
    }
    a(2147483647);
  }
  
  private boolean e()
  {
    return b(e());
  }
  
  private float f()
  {
    float f2 = this.jdField_d_of_type_Float;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    return f1;
  }
  
  private void f()
  {
    float f1 = this.jdField_d_of_type_Float;
    if (f1 == 0.0F) {
      return;
    }
    if ((int)f1 != f1) {
      Log.w(jdField_a_of_type_JavaLangString, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "stepSize", Float.valueOf(f1) }));
    }
    f1 = this.jdField_b_of_type_Float;
    if ((int)f1 != f1) {
      Log.w(jdField_a_of_type_JavaLangString, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueFrom", Float.valueOf(f1) }));
    }
    f1 = this.jdField_c_of_type_Float;
    if ((int)f1 != f1) {
      Log.w(jdField_a_of_type_JavaLangString, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueTo", Float.valueOf(f1) }));
    }
  }
  
  private void f(int paramInt)
  {
    BaseSlider.AccessibilityEventSender localAccessibilityEventSender = this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityEventSender;
    if (localAccessibilityEventSender == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityEventSender = new BaseSlider.AccessibilityEventSender(this, null);
    } else {
      removeCallbacks(localAccessibilityEventSender);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityEventSender.a(paramInt);
    postDelayed(this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityEventSender, 200L);
  }
  
  private boolean f()
  {
    for (ViewParent localViewParent = getParent();; localViewParent = localViewParent.getParent())
    {
      boolean bool = localViewParent instanceof ViewGroup;
      int i1 = 0;
      if (!bool) {
        break;
      }
      ViewGroup localViewGroup = (ViewGroup)localViewParent;
      if ((localViewGroup.canScrollVertically(1)) || (localViewGroup.canScrollVertically(-1))) {
        i1 = 1;
      }
      if ((i1 != 0) && (localViewGroup.shouldDelayChildPressedState())) {
        return true;
      }
    }
    return false;
  }
  
  private void g()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      b();
      c();
      d();
      e();
      f();
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_JavaUtilList.size());
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        TooltipDrawable localTooltipDrawable = (TooltipDrawable)localIterator.next();
        if (ViewCompat.isAttachedToWindow(this)) {
          b(localTooltipDrawable);
        }
      }
      ((List)localObject).clear();
    }
    while (this.jdField_a_of_type_JavaUtilList.size() < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$TooltipDrawableFactory.a();
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      if (ViewCompat.isAttachedToWindow(this)) {
        a((TooltipDrawable)localObject);
      }
    }
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    int i1 = 1;
    if (i2 == 1) {
      i1 = 0;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TooltipDrawable)((Iterator)localObject).next()).n(i1);
    }
  }
  
  private void i()
  {
    if (this.jdField_d_of_type_Float <= 0.0F) {
      return;
    }
    g();
    int i2 = Math.min((int)((this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) / this.jdField_d_of_type_Float + 1.0F), this.o / (this.g * 2) + 1);
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    if ((arrayOfFloat == null) || (arrayOfFloat.length != i2 * 2)) {
      this.jdField_a_of_type_ArrayOfFloat = new float[i2 * 2];
    }
    float f1 = this.o / (i2 - 1);
    int i1 = 0;
    while (i1 < i2 * 2)
    {
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      arrayOfFloat[i1] = (this.h + i1 / 2 * f1);
      arrayOfFloat[(i1 + 1)] = b();
      i1 += 2;
    }
  }
  
  private void j()
  {
    if ((!d()) && (getMeasuredWidth() > 0))
    {
      Drawable localDrawable = getBackground();
      if ((localDrawable instanceof RippleDrawable))
      {
        int i1 = (int)(a(((Float)this.jdField_a_of_type_JavaUtilArrayList.get(this.n)).floatValue()) * this.o + this.h);
        int i2 = b();
        int i3 = this.k;
        DrawableCompat.setHotspotBounds(localDrawable, i1 - i3, i2 - i3, i1 + i3, i2 + i3);
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidAnimationValueAnimator = a(false);
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new BaseSlider.3(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void l()
  {
    if (this.jdField_f_of_type_Int == 2) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAnimationValueAnimator = a(true);
      this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    while ((i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) && (((Iterator)localObject).hasNext()))
    {
      if (i1 != this.n) {
        a((TooltipDrawable)((Iterator)localObject).next(), ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).floatValue());
      }
      i1 += 1;
    }
    if (((Iterator)localObject).hasNext())
    {
      a((TooltipDrawable)((Iterator)localObject).next(), ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(this.n)).floatValue());
      return;
    }
    localObject = new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g / 2.0F);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g / 2.0F);
  }
  
  private void n()
  {
    Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      BaseOnChangeListener localBaseOnChangeListener = (BaseOnChangeListener)localIterator1.next();
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator2.hasNext()) {
        localBaseOnChangeListener.a(this, ((Float)localIterator2.next()).floatValue(), false);
      }
    }
  }
  
  private void o()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseOnSliderTouchListener)localIterator.next()).a(this);
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseOnSliderTouchListener)localIterator.next()).b(this);
    }
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int a()
  {
    return this.m;
  }
  
  @NonNull
  List<Float> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  void a(int paramInt, Rect paramRect)
  {
    paramInt = this.h + (int)(a(((Float)a().get(paramInt)).floatValue()) * this.o);
    int i1 = b();
    int i2 = this.j;
    paramRect.set(paramInt - i2, i1 - i2, paramInt + i2, i1 + i2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialSliderLabelFormatter != null;
  }
  
  public float b()
  {
    return this.jdField_c_of_type_Float;
  }
  
  protected void b(int paramInt)
  {
    this.p = paramInt;
  }
  
  protected boolean b()
  {
    if (this.m != -1) {
      return true;
    }
    float f4 = d();
    float f5 = c(f4);
    this.m = 0;
    float f1 = Math.abs(((Float)this.jdField_a_of_type_JavaUtilArrayList.get(this.m)).floatValue() - f4);
    int i1 = 1;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      float f3 = Math.abs(((Float)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).floatValue() - f4);
      float f6 = c(((Float)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).floatValue());
      if (Float.compare(f3, f1) > 1) {
        break;
      }
      int i2;
      if (c() ? f6 - f5 > 0.0F : f6 - f5 < 0.0F) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (Float.compare(f3, f1) < 0)
      {
        this.m = i1;
      }
      else
      {
        f2 = f1;
        if (Float.compare(f3, f1) != 0) {
          break label228;
        }
        if (Math.abs(f6 - f5) < this.jdField_b_of_type_Int)
        {
          this.m = -1;
          return false;
        }
        f2 = f1;
        if (i2 == 0) {
          break label228;
        }
        this.m = i1;
      }
      float f2 = f3;
      label228:
      i1 += 1;
      f1 = f2;
    }
    return this.m != -1;
  }
  
  protected float c()
  {
    return 0.0F;
  }
  
  final boolean c()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  public boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityHelper.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_e_of_type_AndroidContentResColorStateList));
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_d_of_type_AndroidContentResColorStateList));
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_c_of_type_AndroidContentResColorStateList));
    this.jdField_f_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_b_of_type_AndroidContentResColorStateList));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TooltipDrawable localTooltipDrawable = (TooltipDrawable)localIterator.next();
      if (localTooltipDrawable.isStateful()) {
        localTooltipDrawable.setState(getDrawableState());
      }
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.isStateful()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setState(getDrawableState());
    }
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_a_of_type_AndroidContentResColorStateList));
    this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha(63);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((TooltipDrawable)localIterator.next());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityEventSender;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      b((TooltipDrawable)((Iterator)localObject).next());
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      g();
      i();
    }
    super.onDraw(paramCanvas);
    int i1 = b();
    a(paramCanvas, this.o, i1);
    if (((Float)Collections.max(a())).floatValue() > this.jdField_b_of_type_Float) {
      b(paramCanvas, this.o, i1);
    }
    a(paramCanvas);
    if (((this.jdField_b_of_type_Boolean) || (isFocused())) && (isEnabled()))
    {
      d(paramCanvas, this.o, i1);
      if (this.m != -1) {
        l();
      }
    }
    c(paramCanvas, this.o, i1);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      this.m = -1;
      k();
      this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityHelper.clearKeyboardFocusForVirtualView(this.n);
      return;
    }
    e(paramInt);
    this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityHelper.requestKeyboardFocusForVirtualView(this.n);
  }
  
  public boolean onKeyDown(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (!isEnabled()) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1) {
      this.m = 0;
    }
    if (this.m == -1)
    {
      localObject = a(paramInt, paramKeyEvent);
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    this.jdField_e_of_type_Boolean |= paramKeyEvent.isLongPress();
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      if (b(((Float)this.jdField_a_of_type_JavaUtilArrayList.get(this.m)).floatValue() + ((Float)localObject).floatValue()))
      {
        j();
        postInvalidate();
      }
      return true;
    }
    if (paramInt != 23) {
      if (paramInt != 61)
      {
        if (paramInt != 66) {
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return a(1);
        }
        if (paramKeyEvent.isShiftPressed()) {
          return a(-1);
        }
        return false;
      }
    }
    this.m = -1;
    k();
    postInvalidate();
    return true;
  }
  
  public boolean onKeyUp(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    this.jdField_e_of_type_Boolean = false;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_e_of_type_Int;
    int i2 = this.jdField_f_of_type_Int;
    paramInt2 = 0;
    if (i2 == 1) {
      paramInt2 = ((TooltipDrawable)this.jdField_a_of_type_JavaUtilList.get(0)).getIntrinsicHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i1 + paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (BaseSlider.SliderState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_b_of_type_Float = paramParcelable.jdField_a_of_type_Float;
    this.jdField_c_of_type_Float = paramParcelable.jdField_b_of_type_Float;
    a(paramParcelable.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_d_of_type_Float = paramParcelable.jdField_c_of_type_Float;
    if (paramParcelable.jdField_a_of_type_Boolean) {
      requestFocus();
    }
    n();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    BaseSlider.SliderState localSliderState = new BaseSlider.SliderState(super.onSaveInstanceState());
    localSliderState.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
    localSliderState.jdField_b_of_type_Float = this.jdField_c_of_type_Float;
    localSliderState.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    localSliderState.jdField_c_of_type_Float = this.jdField_d_of_type_Float;
    localSliderState.jdField_a_of_type_Boolean = hasFocus();
    return localSliderState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c(paramInt1);
    j();
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    this.jdField_e_of_type_Float = ((f1 - this.h) / this.o);
    this.jdField_e_of_type_Float = Math.max(0.0F, this.jdField_e_of_type_Float);
    this.jdField_e_of_type_Float = Math.min(1.0F, this.jdField_e_of_type_Float);
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          if (!this.jdField_b_of_type_Boolean)
          {
            if ((f()) && (Math.abs(f1 - this.jdField_a_of_type_Float) < this.jdField_b_of_type_Int)) {
              return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            o();
          }
          if (b())
          {
            this.jdField_b_of_type_Boolean = true;
            e();
            j();
            invalidate();
          }
        }
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
        MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
        if ((localMotionEvent != null) && (localMotionEvent.getActionMasked() == 0) && (Math.abs(this.jdField_a_of_type_AndroidViewMotionEvent.getX() - paramMotionEvent.getX()) <= this.jdField_b_of_type_Int) && (Math.abs(this.jdField_a_of_type_AndroidViewMotionEvent.getY() - paramMotionEvent.getY()) <= this.jdField_b_of_type_Int) && (b())) {
          o();
        }
        if (this.m != -1)
        {
          e();
          this.m = -1;
          p();
        }
        k();
        invalidate();
      }
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      if (!f())
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (b())
        {
          requestFocus();
          this.jdField_b_of_type_Boolean = true;
          e();
          j();
          invalidate();
          o();
        }
      }
    }
    setPressed(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    return true;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 2;
    }
    setLayerType(i1, null);
  }
  
  public void setFocusedThumbIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.n = paramInt;
      this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider$AccessibilityHelper.requestKeyboardFocusForVirtualView(this.n);
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("index out of range");
  }
  
  public void setHaloRadius(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (paramInt == this.k) {
      return;
    }
    this.k = paramInt;
    Drawable localDrawable = getBackground();
    if ((!d()) && ((localDrawable instanceof RippleDrawable)))
    {
      DrawableUtils.a((RippleDrawable)localDrawable, this.k);
      return;
    }
    postInvalidate();
  }
  
  public void setHaloRadiusResource(@DimenRes int paramInt)
  {
    setHaloRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setHaloTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.jdField_a_of_type_AndroidContentResColorStateList)) {
      return;
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    Drawable localDrawable = getBackground();
    if ((!d()) && ((localDrawable instanceof RippleDrawable)))
    {
      ((RippleDrawable)localDrawable).setColor(paramColorStateList);
      return;
    }
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(a(paramColorStateList));
    this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha(63);
    invalidate();
  }
  
  public void setLabelBehavior(int paramInt)
  {
    if (this.jdField_f_of_type_Int != paramInt)
    {
      this.jdField_f_of_type_Int = paramInt;
      requestLayout();
    }
  }
  
  public void setLabelFormatter(@Nullable LabelFormatter paramLabelFormatter)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialSliderLabelFormatter = paramLabelFormatter;
  }
  
  public void setStepSize(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      if (this.jdField_d_of_type_Float != paramFloat)
      {
        this.jdField_d_of_type_Float = paramFloat;
        this.jdField_f_of_type_Boolean = true;
        postInvalidate();
      }
      return;
    }
    throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(paramFloat), Float.toString(this.jdField_b_of_type_Float), Float.toString(this.jdField_c_of_type_Float) }));
  }
  
  public void setThumbElevation(float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.r(paramFloat);
  }
  
  public void setThumbElevationResource(@DimenRes int paramInt)
  {
    setThumbElevation(getResources().getDimension(paramInt));
  }
  
  public void setThumbRadius(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    this.j = paramInt;
    a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.a().a(0, this.j).a());
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    paramInt = this.j;
    localMaterialShapeDrawable.setBounds(0, 0, paramInt * 2, paramInt * 2);
    postInvalidate();
  }
  
  public void setThumbRadiusResource(@DimenRes int paramInt)
  {
    setThumbRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setThumbStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.h(paramColorStateList);
    postInvalidate();
  }
  
  public void setThumbStrokeColorResource(@ColorRes int paramInt)
  {
    if (paramInt != 0) {
      setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setThumbStrokeWidth(float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.n(paramFloat);
    postInvalidate();
  }
  
  public void setThumbStrokeWidthResource(@DimenRes int paramInt)
  {
    if (paramInt != 0) {
      setThumbStrokeWidth(getResources().getDimension(paramInt));
    }
  }
  
  public void setThumbTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.b())) {
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(paramColorStateList);
    invalidate();
  }
  
  public void setTickActiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.jdField_b_of_type_AndroidContentResColorStateList)) {
      return;
    }
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_f_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_b_of_type_AndroidContentResColorStateList));
    invalidate();
  }
  
  public void setTickInactiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.jdField_c_of_type_AndroidContentResColorStateList)) {
      return;
    }
    this.jdField_c_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_c_of_type_AndroidContentResColorStateList));
    invalidate();
  }
  
  public void setTickTintList(@NonNull ColorStateList paramColorStateList)
  {
    setTickInactiveTintList(paramColorStateList);
    setTickActiveTintList(paramColorStateList);
  }
  
  public void setTickVisible(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      postInvalidate();
    }
  }
  
  public void setTrackActiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.jdField_d_of_type_AndroidContentResColorStateList)) {
      return;
    }
    this.jdField_d_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_d_of_type_AndroidContentResColorStateList));
    invalidate();
  }
  
  public void setTrackHeight(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      m();
      postInvalidate();
    }
  }
  
  public void setTrackInactiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.jdField_e_of_type_AndroidContentResColorStateList)) {
      return;
    }
    this.jdField_e_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(a(this.jdField_e_of_type_AndroidContentResColorStateList));
    invalidate();
  }
  
  public void setTrackTintList(@NonNull ColorStateList paramColorStateList)
  {
    setTrackInactiveTintList(paramColorStateList);
    setTrackActiveTintList(paramColorStateList);
  }
  
  public void setValueFrom(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_f_of_type_Boolean = true;
    postInvalidate();
  }
  
  public void setValueTo(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
    this.jdField_f_of_type_Boolean = true;
    postInvalidate();
  }
  
  void setValues(@NonNull List<Float> paramList)
  {
    a(new ArrayList(paramList));
  }
  
  void setValues(@NonNull Float... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramVarArgs);
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider
 * JD-Core Version:    0.7.0.1
 */