package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Chip
  extends AppCompatCheckBox
  implements ChipDrawable.Delegate, Shapeable
{
  private static final int jdField_a_of_type_Int = R.style.w;
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842913 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 16842911 };
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  @Nullable
  private InsetDrawable jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable;
  @Nullable
  private RippleDrawable jdField_a_of_type_AndroidGraphicsDrawableRippleDrawable;
  @Nullable
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  @Nullable
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  @NonNull
  private final Chip.ChipTouchHelper jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper;
  @Nullable
  private ChipDrawable jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
  private final TextAppearanceFontCallback jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback = new Chip.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_b_of_type_Boolean;
  @Dimension(unit=1)
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public Chip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.h);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    a(paramAttributeSet);
    ChipDrawable localChipDrawable = ChipDrawable.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int);
    a(paramContext, paramAttributeSet, paramInt);
    setChipDrawable(localChipDrawable);
    localChipDrawable.r(ViewCompat.getElevation(this));
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.j, paramInt, jdField_a_of_type_Int, new int[0]);
    if (Build.VERSION.SDK_INT < 23) {
      setTextColor(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.ae));
    }
    boolean bool = paramAttributeSet.hasValue(R.styleable.aN);
    paramAttributeSet.recycle();
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper = new Chip.ChipTouchHelper(this, this);
    b();
    if (!bool) {
      d();
    }
    setChecked(this.jdField_a_of_type_Boolean);
    setText(localChipDrawable.a());
    setEllipsize(localChipDrawable.a());
    h();
    if (!this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.e())
    {
      setLines(1);
      setHorizontallyScrolling(true);
    }
    setGravity(8388627);
    c();
    if (d()) {
      setMinHeight(this.jdField_c_of_type_Int);
    }
    this.jdField_b_of_type_Int = ViewCompat.getLayoutDirection(this);
  }
  
  @NonNull
  private RectF a()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.setEmpty();
    if ((e()) && (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    }
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  @Nullable
  private TextAppearance a()
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      return localChipDrawable.a();
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable = new InsetDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.j, paramInt, jdField_a_of_type_Int, new int[0]);
    this.e = paramContext.getBoolean(R.styleable.aI, false);
    float f = (float)Math.ceil(ViewUtils.a(getContext(), 48));
    this.jdField_c_of_type_Int = ((int)Math.ceil(paramContext.getDimension(R.styleable.aw, f)));
    paramContext.recycle();
  }
  
  private void a(@Nullable AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null)
      {
        if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null)
        {
          if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null)
          {
            if ((paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1))
            {
              if (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
              }
              return;
            }
            throw new UnsupportedOperationException("Chip does not support multi-line text");
          }
          throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      }
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  private void a(@Nullable ChipDrawable paramChipDrawable)
  {
    if (paramChipDrawable != null) {
      paramChipDrawable.a(null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      refreshDrawableState();
    }
  }
  
  @SuppressLint({"PrivateApi"})
  private boolean a(@NonNull MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {
      try
      {
        paramMotionEvent = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
        paramMotionEvent.setAccessible(true);
        if (((Integer)paramMotionEvent.get(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper)).intValue() != -2147483648)
        {
          paramMotionEvent = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
          paramMotionEvent.setAccessible(true);
          paramMotionEvent.invoke(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper, new Object[] { Integer.valueOf(-2147483648) });
          return true;
        }
      }
      catch (NoSuchFieldException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (InvocationTargetException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (IllegalAccessException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (NoSuchMethodException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
      }
    }
    return false;
  }
  
  @NonNull
  private int[] a()
  {
    boolean bool = isEnabled();
    int k = 0;
    if (bool) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (this.d) {
      i = j + 1;
    }
    int j = i;
    if (this.jdField_c_of_type_Boolean) {
      j = i + 1;
    }
    i = j;
    if (this.jdField_b_of_type_Boolean) {
      i = j + 1;
    }
    j = i;
    if (isChecked()) {
      j = i + 1;
    }
    int[] arrayOfInt = new int[j];
    j = k;
    if (isEnabled())
    {
      arrayOfInt[0] = 16842910;
      j = 1;
    }
    i = j;
    if (this.d)
    {
      arrayOfInt[j] = 16842908;
      i = j + 1;
    }
    j = i;
    if (this.jdField_c_of_type_Boolean)
    {
      arrayOfInt[i] = 16843623;
      j = i + 1;
    }
    i = j;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt[j] = 16842919;
      i = j + 1;
    }
    if (isChecked()) {
      arrayOfInt[i] = 16842913;
    }
    return arrayOfInt;
  }
  
  @NonNull
  private Rect b()
  {
    RectF localRectF = a();
    this.jdField_b_of_type_AndroidGraphicsRect.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  private void b()
  {
    if ((e()) && (b()) && (this.jdField_a_of_type_AndroidViewView$OnClickListener != null))
    {
      ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper);
      return;
    }
    ViewCompat.setAccessibilityDelegate(this, null);
  }
  
  private void b(@NonNull ChipDrawable paramChipDrawable)
  {
    paramChipDrawable.a(this);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void c()
  {
    if (!TextUtils.isEmpty(getText()))
    {
      Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
      if (localObject == null) {
        return;
      }
      int k = (int)(((ChipDrawable)localObject).h() + this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.g() + this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.b());
      int m = (int)(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.e() + this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.f() + this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a());
      int j = k;
      int i = m;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable != null)
      {
        localObject = new Rect();
        this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable.getPadding((Rect)localObject);
        i = m + ((Rect)localObject).left;
        j = k + ((Rect)localObject).right;
      }
      ViewCompat.setPaddingRelative(this, i, getPaddingTop(), j, getPaddingBottom());
    }
  }
  
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new Chip.2(this));
    }
  }
  
  private void e()
  {
    if (RippleUtils.jdField_a_of_type_Boolean)
    {
      g();
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a(true);
    ViewCompat.setBackground(this, a());
    c();
    f();
  }
  
  private boolean e()
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    return (localChipDrawable != null) && (localChipDrawable.b() != null);
  }
  
  private void f()
  {
    if ((a() == this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable) && (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.getCallback() == null)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableRippleDrawable = new RippleDrawable(RippleUtils.b(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a()), a(), null);
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a(false);
    ViewCompat.setBackground(this, this.jdField_a_of_type_AndroidGraphicsDrawableRippleDrawable);
    c();
  }
  
  private void h()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localObject != null) {
      localTextPaint.drawableState = ((ChipDrawable)localObject).getState();
    }
    localObject = a();
    if (localObject != null) {
      ((TextAppearance)localObject).b(getContext(), localTextPaint, this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable = null;
      setMinWidth(0);
      setMinHeight((int)a());
      e();
    }
  }
  
  public float a()
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      return localChipDrawable.c();
    }
    return 0.0F;
  }
  
  @Nullable
  public Drawable a()
  {
    InsetDrawable localInsetDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable;
    Object localObject = localInsetDrawable;
    if (localInsetDrawable == null) {
      localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    }
    return localObject;
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a();
  }
  
  @Nullable
  public CharSequence a()
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      return localChipDrawable.b();
    }
    return null;
  }
  
  public void a()
  {
    a(this.jdField_c_of_type_Int);
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  void a(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  @CallSuper
  public boolean a()
  {
    boolean bool = false;
    playSoundEffect(0);
    View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this);
      bool = true;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper.sendEventForVirtualView(1, 1);
    return bool;
  }
  
  public boolean a(@Dimension int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    boolean bool = d();
    int j = 0;
    if (!bool)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable != null)
      {
        i();
        return false;
      }
      e();
      return false;
    }
    int k = Math.max(0, paramInt - this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.getIntrinsicHeight());
    int i = Math.max(0, paramInt - this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.getIntrinsicWidth());
    if ((i <= 0) && (k <= 0))
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable != null)
      {
        i();
        return false;
      }
      e();
      return false;
    }
    if (i > 0) {
      i /= 2;
    } else {
      i = 0;
    }
    if (k > 0) {
      j = k / 2;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable != null)
    {
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsDrawableInsetDrawable.getPadding(localRect);
      if ((localRect.top == j) && (localRect.bottom == j) && (localRect.left == i) && (localRect.right == i))
      {
        e();
        return true;
      }
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (getMinHeight() != paramInt) {
        setMinHeight(paramInt);
      }
      if (getMinWidth() != paramInt) {
        setMinWidth(paramInt);
      }
    }
    else
    {
      setMinHeight(paramInt);
      setMinWidth(paramInt);
    }
    a(i, j, i, j);
    e();
    return true;
  }
  
  public boolean b()
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    return (localChipDrawable != null) && (localChipDrawable.c());
  }
  
  public boolean c()
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    return (localChipDrawable != null) && (localChipDrawable.d());
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  protected boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    return (a(paramMotionEvent)) || (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper.dispatchKeyEvent(paramKeyEvent)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper.getKeyboardFocusedVirtualViewId() != -2147483648)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.b())) {
      bool = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a(a());
    } else {
      bool = false;
    }
    if (bool) {
      invalidate();
    }
  }
  
  @Nullable
  public TextUtils.TruncateAt getEllipsize()
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      return localChipDrawable.a();
    }
    return null;
  }
  
  public void getFocusedRect(@NonNull Rect paramRect)
  {
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper.getKeyboardFocusedVirtualViewId() != 1) && (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper.getAccessibilityFocusedVirtualViewId() != 1))
    {
      super.getFocusedRect(paramRect);
      return;
    }
    paramRect.set(b());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this, this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
    }
    if (c()) {
      mergeDrawableStates(arrayOfInt, jdField_b_of_type_ArrayOfInt);
    }
    return arrayOfInt;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip$ChipTouchHelper.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 7)
    {
      if (i == 10) {
        b(false);
      }
    }
    else {
      b(a().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject;
    if ((!c()) && (!isClickable()))
    {
      paramAccessibilityNodeInfo.setClassName("android.view.View");
    }
    else
    {
      if (c()) {
        localObject = "android.widget.CompoundButton";
      } else {
        localObject = "android.widget.Button";
      }
      paramAccessibilityNodeInfo.setClassName((CharSequence)localObject);
    }
    paramAccessibilityNodeInfo.setCheckable(c());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    if ((getParent() instanceof ChipGroup))
    {
      localObject = (ChipGroup)getParent();
      paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
      int i;
      if (((ChipGroup)localObject).a()) {
        i = ((ChipGroup)localObject).a(this);
      } else {
        i = -1;
      }
      paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(((ChipGroup)localObject).b(this), 1, i, 1, false, isChecked()));
    }
  }
  
  @TargetApi(24)
  @Nullable
  public PointerIcon onResolvePointerIcon(@NonNull MotionEvent paramMotionEvent, int paramInt)
  {
    if ((a().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled())) {
      return PointerIcon.getSystemIcon(getContext(), 1002);
    }
    return null;
  }
  
  @TargetApi(17)
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      c();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = a().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    boolean bool1 = false;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            break label108;
          }
        }
        else
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label108;
          }
          if (bool2) {
            break label103;
          }
          a(false);
          break label103;
        }
      }
      else if (this.jdField_b_of_type_Boolean)
      {
        a();
        i = 1;
        break label85;
      }
      i = 0;
      label85:
      a(false);
      break label110;
    }
    else
    {
      if (!bool2) {
        break label108;
      }
      a(true);
    }
    label103:
    i = 1;
    break label110;
    label108:
    i = 0;
    label110:
    if ((i != 0) || (super.onTouchEvent(paramMotionEvent))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if ((paramDrawable != a()) && (paramDrawable != this.jdField_a_of_type_AndroidGraphicsDrawableRippleDrawable))
    {
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
      return;
    }
    super.setBackground(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != a()) && (paramDrawable != this.jdField_a_of_type_AndroidGraphicsDrawableRippleDrawable))
    {
      Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramBoolean);
    }
  }
  
  public void setCheckableResource(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.o(paramInt);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localObject == null)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    if (((ChipDrawable)localObject).d())
    {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if (bool != paramBoolean)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
        if (localObject != null) {
          ((CompoundButton.OnCheckedChangeListener)localObject).onCheckedChanged(this, paramBoolean);
        }
      }
    }
  }
  
  public void setCheckedIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramDrawable);
    }
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    setCheckedIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(@BoolRes int paramInt)
  {
    setCheckedIconVisible(paramInt);
  }
  
  public void setCheckedIconResource(@DrawableRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.q(paramInt);
    }
  }
  
  public void setCheckedIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.f(paramColorStateList);
    }
  }
  
  public void setCheckedIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.r(paramInt);
    }
  }
  
  public void setCheckedIconVisible(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.p(paramInt);
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.e(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramInt);
    }
  }
  
  @Deprecated
  public void setChipCornerRadius(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramFloat);
    }
  }
  
  @Deprecated
  public void setChipCornerRadiusResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramInt);
    }
  }
  
  public void setChipDrawable(@NonNull ChipDrawable paramChipDrawable)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != paramChipDrawable)
    {
      a(localChipDrawable);
      this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable = paramChipDrawable;
      this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.f(false);
      b(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable);
      a(this.jdField_c_of_type_Int);
    }
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.m(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.B(paramInt);
    }
  }
  
  public void setChipIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramDrawable);
    }
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean)
  {
    setChipIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(@BoolRes int paramInt)
  {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(@DrawableRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.i(paramInt);
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.k(paramInt);
    }
  }
  
  public void setChipIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.j(paramInt);
    }
  }
  
  public void setChipIconVisible(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.h(paramInt);
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramInt);
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.f(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.u(paramInt);
    }
  }
  
  public void setChipStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramInt);
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.e(paramInt);
    }
  }
  
  @Deprecated
  public void setChipText(@Nullable CharSequence paramCharSequence)
  {
    setText(paramCharSequence);
  }
  
  @Deprecated
  public void setChipTextResource(@StringRes int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setCloseIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramDrawable);
    }
    b();
  }
  
  public void setCloseIconContentDescription(@Nullable CharSequence paramCharSequence)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramCharSequence);
    }
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    setCloseIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(@BoolRes int paramInt)
  {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.l(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.A(paramInt);
    }
  }
  
  public void setCloseIconResource(@DrawableRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.l(paramInt);
    }
    b();
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.e(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.n(paramInt);
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.k(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.z(paramInt);
    }
  }
  
  public void setCloseIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.e(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.m(paramInt);
    }
  }
  
  public void setCloseIconVisible(@BoolRes int paramInt)
  {
    setCloseIconVisible(getResources().getBoolean(paramInt));
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramBoolean);
    }
    b();
  }
  
  public void setCompoundDrawables(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelative(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.r(paramFloat);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable == null) {
      return;
    }
    if (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)
    {
      super.setEllipsize(paramTruncateAt);
      ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
      if (localChipDrawable != null) {
        localChipDrawable.a(paramTruncateAt);
      }
      return;
    }
    throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    this.e = paramBoolean;
    a(this.jdField_c_of_type_Int);
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt != 8388627)
    {
      Log.w("Chip", "Chip text must be vertically center and start aligned");
      return;
    }
    super.setGravity(paramInt);
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramMotionSpec);
    }
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.t(paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.h(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.w(paramInt);
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.g(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.v(paramInt);
    }
  }
  
  public void setLayoutDirection(int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      super.setLayoutDirection(paramInt);
    }
  }
  
  public void setLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMaxLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxWidth(@Px int paramInt)
  {
    super.setMaxWidth(paramInt);
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.C(paramInt);
    }
  }
  
  public void setMinLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMinLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    b();
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramColorStateList);
    }
    if (!this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a()) {
      g();
    }
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null)
    {
      localChipDrawable.f(paramInt);
      if (!this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.a()) {
        g();
      }
    }
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramMotionSpec);
    }
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.s(paramInt);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setSingleLine(paramBoolean);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable == null) {
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable.e()) {
      paramCharSequence = null;
    } else {
      paramCharSequence = (CharSequence)localObject;
    }
    super.setText(paramCharSequence, paramBufferType);
    paramCharSequence = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (paramCharSequence != null) {
      paramCharSequence.a((CharSequence)localObject);
    }
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.g(paramInt);
    }
    h();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    paramContext = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (paramContext != null) {
      paramContext.g(paramInt);
    }
    h();
  }
  
  public void setTextAppearance(@Nullable TextAppearance paramTextAppearance)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramTextAppearance);
    }
    h();
  }
  
  public void setTextAppearanceResource(@StyleRes int paramInt)
  {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.j(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.y(paramInt);
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.i(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.x(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.chip.Chip
 * JD-Core Version:    0.7.0.1
 */