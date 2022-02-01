package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialResources;
import java.util.Arrays;

class ClockFaceView
  extends RadialViewGroup
  implements ClockHandView.OnRotateListener
{
  private final ClockHandView a;
  private final Rect b = new Rect();
  private final RectF c = new RectF();
  private final SparseArray<TextView> d = new SparseArray();
  private final AccessibilityDelegateCompat e;
  private final int[] f;
  private final float[] g = { 0.0F, 0.9F, 1.0F };
  private final int h;
  private String[] i;
  private float j;
  private final ColorStateList k;
  
  public ClockFaceView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClockFaceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.I);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public ClockFaceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bK, paramInt, R.style.L);
    Object localObject = getResources();
    this.k = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.bM);
    LayoutInflater.from(paramContext).inflate(R.layout.n, this, true);
    this.a = ((ClockHandView)findViewById(R.id.n));
    this.h = ((Resources)localObject).getDimensionPixelSize(R.dimen.u);
    localObject = this.k;
    paramInt = ((ColorStateList)localObject).getDefaultColor();
    paramInt = ((ColorStateList)localObject).getColorForState(new int[] { 16842913 }, paramInt);
    this.f = new int[] { paramInt, paramInt, this.k.getDefaultColor() };
    this.a.a(this);
    paramInt = AppCompatResources.getColorStateList(paramContext, R.color.l).getDefaultColor();
    paramContext = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.bL);
    if (paramContext != null) {
      paramInt = paramContext.getDefaultColor();
    }
    setBackgroundColor(paramInt);
    getViewTreeObserver().addOnPreDrawListener(new ClockFaceView.1(this));
    setFocusable(true);
    paramAttributeSet.recycle();
    this.e = new ClockFaceView.2(this);
    paramContext = new String[12];
    Arrays.fill(paramContext, "");
    a(paramContext, 0);
  }
  
  private RadialGradient a(RectF paramRectF1, RectF paramRectF2)
  {
    if (!RectF.intersects(paramRectF1, paramRectF2)) {
      return null;
    }
    return new RadialGradient(paramRectF1.centerX() - this.c.left, paramRectF1.centerY() - this.c.top, paramRectF1.width() * 0.5F, this.f, this.g, Shader.TileMode.CLAMP);
  }
  
  private void b(@StringRes int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    int n = this.d.size();
    int m = 0;
    while (m < Math.max(this.i.length, n))
    {
      TextView localTextView2 = (TextView)this.d.get(m);
      if (m >= this.i.length)
      {
        removeView(localTextView2);
        this.d.remove(m);
      }
      else
      {
        TextView localTextView1 = localTextView2;
        if (localTextView2 == null)
        {
          localTextView1 = (TextView)localLayoutInflater.inflate(R.layout.m, this, false);
          this.d.put(m, localTextView1);
          addView(localTextView1);
        }
        localTextView1.setVisibility(0);
        localTextView1.setText(this.i[m]);
        localTextView1.setTag(R.id.B, Integer.valueOf(m));
        ViewCompat.setAccessibilityDelegate(localTextView1, this.e);
        localTextView1.setTextColor(this.k);
        if (paramInt != 0) {
          localTextView1.setContentDescription(getResources().getString(paramInt, new Object[] { this.i[m] }));
        }
      }
      m += 1;
    }
  }
  
  private void c()
  {
    RectF localRectF = this.a.b();
    int m = 0;
    while (m < this.d.size())
    {
      TextView localTextView = (TextView)this.d.get(m);
      if (localTextView != null)
      {
        localTextView.getDrawingRect(this.b);
        this.b.offset(localTextView.getPaddingLeft(), localTextView.getPaddingTop());
        offsetDescendantRectToMyCoords(localTextView, this.b);
        this.c.set(this.b);
        RadialGradient localRadialGradient = a(localRectF, this.c);
        localTextView.getPaint().setShader(localRadialGradient);
        localTextView.invalidate();
      }
      m += 1;
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if (Math.abs(this.j - paramFloat) > 0.001F)
    {
      this.j = paramFloat;
      c();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != b())
    {
      super.a(paramInt);
      this.a.a(b());
    }
  }
  
  public void a(String[] paramArrayOfString, @StringRes int paramInt)
  {
    this.i = paramArrayOfString;
    b(paramInt);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.i.length, false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ClockFaceView
 * JD-Core Version:    0.7.0.1
 */