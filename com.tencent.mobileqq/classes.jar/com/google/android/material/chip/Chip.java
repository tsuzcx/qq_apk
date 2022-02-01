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
  private static final int a = R.style.y;
  private static final Rect b = new Rect();
  private static final int[] c = { 16842913 };
  private static final int[] d = { 16842911 };
  @Nullable
  private ChipDrawable e;
  @Nullable
  private InsetDrawable f;
  @Nullable
  private RippleDrawable g;
  @Nullable
  private View.OnClickListener h;
  @Nullable
  private CompoundButton.OnCheckedChangeListener i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o;
  @Dimension(unit=1)
  private int p;
  @NonNull
  private final Chip.ChipTouchHelper q;
  private final Rect r = new Rect();
  private final RectF s = new RectF();
  private final TextAppearanceFontCallback t = new Chip.1(this);
  
  public Chip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.k);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    a(paramAttributeSet);
    ChipDrawable localChipDrawable = ChipDrawable.a(paramContext, paramAttributeSet, paramInt, a);
    a(paramContext, paramAttributeSet, paramInt);
    setChipDrawable(localChipDrawable);
    localChipDrawable.r(ViewCompat.getElevation(this));
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.aI, paramInt, a, new int[0]);
    if (Build.VERSION.SDK_INT < 23) {
      setTextColor(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.aL));
    }
    boolean bool = paramAttributeSet.hasValue(R.styleable.bu);
    paramAttributeSet.recycle();
    this.q = new Chip.ChipTouchHelper(this, this);
    g();
    if (!bool) {
      i();
    }
    setChecked(this.j);
    setText(localChipDrawable.n());
    setEllipsize(localChipDrawable.p());
    o();
    if (!this.e.L())
    {
      setLines(1);
      setHorizontallyScrolling(true);
    }
    setGravity(8388627);
    h();
    if (e()) {
      setMinHeight(this.p);
    }
    this.o = ViewCompat.getLayoutDirection(this);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = new InsetDrawable(this.e, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.aI, paramInt, a, new int[0]);
    this.n = paramContext.getBoolean(R.styleable.bp, false);
    float f1 = (float)Math.ceil(ViewUtils.a(getContext(), 48));
    this.p = ((int)Math.ceil(paramContext.getDimension(R.styleable.bd, f1)));
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
  
  @SuppressLint({"PrivateApi"})
  private boolean a(@NonNull MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {
      try
      {
        paramMotionEvent = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
        paramMotionEvent.setAccessible(true);
        if (((Integer)paramMotionEvent.get(this.q)).intValue() != -2147483648)
        {
          paramMotionEvent = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
          paramMotionEvent.setAccessible(true);
          paramMotionEvent.invoke(this.q, new Object[] { Integer.valueOf(-2147483648) });
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
  
  private void b(@NonNull ChipDrawable paramChipDrawable)
  {
    paramChipDrawable.a(this);
  }
  
  private void g()
  {
    if ((n()) && (c()) && (this.h != null))
    {
      ViewCompat.setAccessibilityDelegate(this, this.q);
      return;
    }
    ViewCompat.setAccessibilityDelegate(this, null);
  }
  
  @NonNull
  private RectF getCloseIconTouchBounds()
  {
    this.s.setEmpty();
    if ((n()) && (this.h != null)) {
      this.e.a(this.s);
    }
    return this.s;
  }
  
  @NonNull
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    this.r.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.r;
  }
  
  @Nullable
  private TextAppearance getTextAppearance()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.o();
    }
    return null;
  }
  
  private void h()
  {
    if (!TextUtils.isEmpty(getText()))
    {
      Object localObject = this.e;
      if (localObject == null) {
        return;
      }
      int i3 = (int)(((ChipDrawable)localObject).K() + this.e.H() + this.e.d());
      int i4 = (int)(this.e.D() + this.e.G() + this.e.c());
      int i2 = i3;
      int i1 = i4;
      if (this.f != null)
      {
        localObject = new Rect();
        this.f.getPadding((Rect)localObject);
        i1 = i4 + ((Rect)localObject).left;
        i2 = i3 + ((Rect)localObject).right;
      }
      ViewCompat.setPaddingRelative(this, i1, getPaddingTop(), i2, getPaddingBottom());
    }
  }
  
  private void i()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new Chip.2(this));
    }
  }
  
  private void j()
  {
    if (RippleUtils.a)
    {
      l();
      return;
    }
    this.e.a(true);
    ViewCompat.setBackground(this, getBackgroundDrawable());
    h();
    k();
  }
  
  private void k()
  {
    if ((getBackgroundDrawable() == this.f) && (this.e.getCallback() == null)) {
      this.e.setCallback(this.f);
    }
  }
  
  private void l()
  {
    this.g = new RippleDrawable(RippleUtils.b(this.e.m()), getBackgroundDrawable(), null);
    this.e.a(false);
    ViewCompat.setBackground(this, this.g);
    h();
  }
  
  @NonNull
  private int[] m()
  {
    boolean bool = isEnabled();
    int i3 = 0;
    if (bool) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1 = i2;
    if (this.m) {
      i1 = i2 + 1;
    }
    int i2 = i1;
    if (this.l) {
      i2 = i1 + 1;
    }
    i1 = i2;
    if (this.k) {
      i1 = i2 + 1;
    }
    i2 = i1;
    if (isChecked()) {
      i2 = i1 + 1;
    }
    int[] arrayOfInt = new int[i2];
    i2 = i3;
    if (isEnabled())
    {
      arrayOfInt[0] = 16842910;
      i2 = 1;
    }
    i1 = i2;
    if (this.m)
    {
      arrayOfInt[i2] = 16842908;
      i1 = i2 + 1;
    }
    i2 = i1;
    if (this.l)
    {
      arrayOfInt[i1] = 16843623;
      i2 = i1 + 1;
    }
    i1 = i2;
    if (this.k)
    {
      arrayOfInt[i2] = 16842919;
      i1 = i2 + 1;
    }
    if (isChecked()) {
      arrayOfInt[i1] = 16842913;
    }
    return arrayOfInt;
  }
  
  private boolean n()
  {
    ChipDrawable localChipDrawable = this.e;
    return (localChipDrawable != null) && (localChipDrawable.u() != null);
  }
  
  private void o()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject = this.e;
    if (localObject != null) {
      localTextPaint.drawableState = ((ChipDrawable)localObject).getState();
    }
    localObject = getTextAppearance();
    if (localObject != null) {
      ((TextAppearance)localObject).b(getContext(), localTextPaint, this.t);
    }
  }
  
  private void p()
  {
    if (this.f != null)
    {
      this.f = null;
      setMinWidth(0);
      setMinHeight((int)getChipMinHeight());
      j();
    }
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      this.l = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (this.k != paramBoolean)
    {
      this.k = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void a()
  {
    a(this.p);
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  public boolean a(@Dimension int paramInt)
  {
    this.p = paramInt;
    boolean bool = e();
    int i2 = 0;
    if (!bool)
    {
      if (this.f != null)
      {
        p();
        return false;
      }
      j();
      return false;
    }
    int i3 = Math.max(0, paramInt - this.e.getIntrinsicHeight());
    int i1 = Math.max(0, paramInt - this.e.getIntrinsicWidth());
    if ((i1 <= 0) && (i3 <= 0))
    {
      if (this.f != null)
      {
        p();
        return false;
      }
      j();
      return false;
    }
    if (i1 > 0) {
      i1 /= 2;
    } else {
      i1 = 0;
    }
    if (i3 > 0) {
      i2 = i3 / 2;
    }
    if (this.f != null)
    {
      Rect localRect = new Rect();
      this.f.getPadding(localRect);
      if ((localRect.top == i2) && (localRect.bottom == i2) && (localRect.left == i1) && (localRect.right == i1))
      {
        j();
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
    a(i1, i2, i1, i2);
    j();
    return true;
  }
  
  @CallSuper
  public boolean b()
  {
    boolean bool = false;
    playSoundEffect(0);
    View.OnClickListener localOnClickListener = this.h;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this);
      bool = true;
    }
    this.q.sendEventForVirtualView(1, 1);
    return bool;
  }
  
  public boolean c()
  {
    ChipDrawable localChipDrawable = this.e;
    return (localChipDrawable != null) && (localChipDrawable.t());
  }
  
  public boolean d()
  {
    ChipDrawable localChipDrawable = this.e;
    return (localChipDrawable != null) && (localChipDrawable.y());
  }
  
  protected boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    return (a(paramMotionEvent)) || (this.q.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.q.dispatchKeyEvent(paramKeyEvent)) && (this.q.getKeyboardFocusedVirtualViewId() != -2147483648)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ChipDrawable localChipDrawable = this.e;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.e())) {
      bool = this.e.a(m());
    } else {
      bool = false;
    }
    if (bool) {
      invalidate();
    }
  }
  
  public boolean e()
  {
    return this.n;
  }
  
  @Nullable
  public Drawable getBackgroundDrawable()
  {
    InsetDrawable localInsetDrawable = this.f;
    Object localObject = localInsetDrawable;
    if (localInsetDrawable == null) {
      localObject = this.e;
    }
    return localObject;
  }
  
  @Nullable
  public Drawable getCheckedIcon()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.z();
    }
    return null;
  }
  
  @Nullable
  public ColorStateList getCheckedIconTint()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.A();
    }
    return null;
  }
  
  @Nullable
  public ColorStateList getChipBackgroundColor()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.h();
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    ChipDrawable localChipDrawable = this.e;
    float f1 = 0.0F;
    if (localChipDrawable != null) {
      f1 = Math.max(0.0F, localChipDrawable.j());
    }
    return f1;
  }
  
  public Drawable getChipDrawable()
  {
    return this.e;
  }
  
  public float getChipEndPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.K();
    }
    return 0.0F;
  }
  
  @Nullable
  public Drawable getChipIcon()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.q();
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.s();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getChipIconTint()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.r();
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.i();
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.D();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getChipStrokeColor()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.k();
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.l();
    }
    return 0.0F;
  }
  
  @Deprecated
  public CharSequence getChipText()
  {
    return getText();
  }
  
  @Nullable
  public Drawable getCloseIcon()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.u();
    }
    return null;
  }
  
  @Nullable
  public CharSequence getCloseIconContentDescription()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.x();
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.J();
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.w();
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.I();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getCloseIconTint()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.v();
    }
    return null;
  }
  
  @Nullable
  public TextUtils.TruncateAt getEllipsize()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.p();
    }
    return null;
  }
  
  public void getFocusedRect(@NonNull Rect paramRect)
  {
    if ((this.q.getKeyboardFocusedVirtualViewId() != 1) && (this.q.getAccessibilityFocusedVirtualViewId() != 1))
    {
      super.getFocusedRect(paramRect);
      return;
    }
    paramRect.set(getCloseIconTouchBoundsInt());
  }
  
  @Nullable
  public MotionSpec getHideMotionSpec()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.C();
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.F();
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.E();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getRippleColor()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.m();
    }
    return null;
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.e.getShapeAppearanceModel();
  }
  
  @Nullable
  public MotionSpec getShowMotionSpec()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.B();
    }
    return null;
  }
  
  public float getTextEndPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.H();
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      return localChipDrawable.G();
    }
    return 0.0F;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this, this.e);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, c);
    }
    if (d()) {
      mergeDrawableStates(arrayOfInt, d);
    }
    return arrayOfInt;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.q.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 7)
    {
      if (i1 == 10) {
        setCloseIconHovered(false);
      }
    }
    else {
      setCloseIconHovered(getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject;
    if ((!d()) && (!isClickable()))
    {
      paramAccessibilityNodeInfo.setClassName("android.view.View");
    }
    else
    {
      if (d()) {
        localObject = "android.widget.CompoundButton";
      } else {
        localObject = "android.widget.Button";
      }
      paramAccessibilityNodeInfo.setClassName((CharSequence)localObject);
    }
    paramAccessibilityNodeInfo.setCheckable(d());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    if ((getParent() instanceof ChipGroup))
    {
      localObject = (ChipGroup)getParent();
      paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
      int i1;
      if (((ChipGroup)localObject).b()) {
        i1 = ((ChipGroup)localObject).a(this);
      } else {
        i1 = -1;
      }
      paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(((ChipGroup)localObject).b(this), 1, i1, 1, false, isChecked()));
    }
  }
  
  @TargetApi(24)
  @Nullable
  public PointerIcon onResolvePointerIcon(@NonNull MotionEvent paramMotionEvent, int paramInt)
  {
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled())) {
      return PointerIcon.getSystemIcon(getContext(), 1002);
    }
    return null;
  }
  
  @TargetApi(17)
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if (this.o != paramInt)
    {
      this.o = paramInt;
      h();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool2 = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    boolean bool1 = false;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label108;
          }
        }
        else
        {
          if (!this.k) {
            break label108;
          }
          if (bool2) {
            break label103;
          }
          setCloseIconPressed(false);
          break label103;
        }
      }
      else if (this.k)
      {
        b();
        i1 = 1;
        break label85;
      }
      i1 = 0;
      label85:
      setCloseIconPressed(false);
      break label110;
    }
    else
    {
      if (!bool2) {
        break label108;
      }
      setCloseIconPressed(true);
    }
    label103:
    i1 = 1;
    break label110;
    label108:
    i1 = 0;
    label110:
    if ((i1 != 0) || (super.onTouchEvent(paramMotionEvent))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != this.g))
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
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != this.g))
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramBoolean);
    }
  }
  
  public void setCheckableResource(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.o(paramInt);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      this.j = paramBoolean;
      return;
    }
    if (((ChipDrawable)localObject).y())
    {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if (bool != paramBoolean)
      {
        localObject = this.i;
        if (localObject != null) {
          ((CompoundButton.OnCheckedChangeListener)localObject).onCheckedChanged(this, paramBoolean);
        }
      }
    }
  }
  
  public void setCheckedIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.e;
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.q(paramInt);
    }
  }
  
  public void setCheckedIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.f(paramColorStateList);
    }
  }
  
  public void setCheckedIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.r(paramInt);
    }
  }
  
  public void setCheckedIconVisible(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.p(paramInt);
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.e(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramInt);
    }
  }
  
  @Deprecated
  public void setChipCornerRadius(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramFloat);
    }
  }
  
  @Deprecated
  public void setChipCornerRadiusResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramInt);
    }
  }
  
  public void setChipDrawable(@NonNull ChipDrawable paramChipDrawable)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != paramChipDrawable)
    {
      a(localChipDrawable);
      this.e = paramChipDrawable;
      this.e.f(false);
      b(this.e);
      a(this.p);
    }
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.m(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.B(paramInt);
    }
  }
  
  public void setChipIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.e;
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.i(paramInt);
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.k(paramInt);
    }
  }
  
  public void setChipIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.j(paramInt);
    }
  }
  
  public void setChipIconVisible(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.h(paramInt);
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramInt);
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.f(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.u(paramInt);
    }
  }
  
  public void setChipStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.d(paramInt);
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramDrawable);
    }
    g();
  }
  
  public void setCloseIconContentDescription(@Nullable CharSequence paramCharSequence)
  {
    ChipDrawable localChipDrawable = this.e;
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.l(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.A(paramInt);
    }
  }
  
  public void setCloseIconResource(@DrawableRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.l(paramInt);
    }
    g();
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.e(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.n(paramInt);
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.k(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.z(paramInt);
    }
  }
  
  public void setCloseIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.e(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramBoolean);
    }
    g();
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.r(paramFloat);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.e == null) {
      return;
    }
    if (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)
    {
      super.setEllipsize(paramTruncateAt);
      ChipDrawable localChipDrawable = this.e;
      if (localChipDrawable != null) {
        localChipDrawable.a(paramTruncateAt);
      }
      return;
    }
    throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    this.n = paramBoolean;
    a(this.p);
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
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.b(paramMotionSpec);
    }
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.t(paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.h(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.w(paramInt);
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.g(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.v(paramInt);
    }
  }
  
  public void setLayoutDirection(int paramInt)
  {
    if (this.e == null) {
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
    ChipDrawable localChipDrawable = this.e;
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
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.i = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
    g();
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.c(paramColorStateList);
    }
    if (!this.e.a()) {
      l();
    }
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null)
    {
      localChipDrawable.f(paramInt);
      if (!this.e.a()) {
        l();
      }
    }
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.e.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramMotionSpec);
    }
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
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
    if (this.e == null) {
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.e.L()) {
      paramCharSequence = null;
    } else {
      paramCharSequence = (CharSequence)localObject;
    }
    super.setText(paramCharSequence, paramBufferType);
    paramCharSequence = this.e;
    if (paramCharSequence != null) {
      paramCharSequence.a((CharSequence)localObject);
    }
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.g(paramInt);
    }
    o();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    paramContext = this.e;
    if (paramContext != null) {
      paramContext.g(paramInt);
    }
    o();
  }
  
  public void setTextAppearance(@Nullable TextAppearance paramTextAppearance)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.a(paramTextAppearance);
    }
    o();
  }
  
  public void setTextAppearanceResource(@StyleRes int paramInt)
  {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.j(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.y(paramInt);
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.i(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.e;
    if (localChipDrawable != null) {
      localChipDrawable.x(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.chip.Chip
 * JD-Core Version:    0.7.0.1
 */