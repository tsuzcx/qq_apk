package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;

class TimePickerView
  extends ConstraintLayout
  implements TimePickerControls
{
  private final Chip a;
  private final Chip b;
  private final ClockHandView c;
  private final ClockFaceView d;
  private final MaterialButtonToggleGroup e;
  private final View.OnClickListener f = new TimePickerView.1(this);
  private TimePickerView.OnPeriodChangeListener g;
  private TimePickerView.OnSelectionChange h;
  private TimePickerView.OnDoubleTapListener i;
  
  public TimePickerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimePickerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimePickerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.r, this);
    this.d = ((ClockFaceView)findViewById(R.id.m));
    this.e = ((MaterialButtonToggleGroup)findViewById(R.id.q));
    this.e.a(new TimePickerView.2(this));
    this.a = ((Chip)findViewById(R.id.v));
    this.b = ((Chip)findViewById(R.id.s));
    this.c = ((ClockHandView)findViewById(R.id.n));
    b();
    c();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b()
  {
    TimePickerView.4 local4 = new TimePickerView.4(this, new GestureDetector(getContext(), new TimePickerView.3(this)));
    this.a.setOnTouchListener(local4);
    this.b.setOnTouchListener(local4);
  }
  
  private void c()
  {
    this.a.setTag(R.id.aa, Integer.valueOf(12));
    this.b.setTag(R.id.aa, Integer.valueOf(10));
    this.a.setOnClickListener(this.f);
    this.b.setOnClickListener(this.f);
  }
  
  private void d()
  {
    if (this.e.getVisibility() == 0)
    {
      ConstraintSet localConstraintSet = new ConstraintSet();
      localConstraintSet.clone(this);
      int j = ViewCompat.getLayoutDirection(this);
      int k = 1;
      if (j == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        k = 2;
      }
      localConstraintSet.clear(R.id.l, k);
      localConstraintSet.applyTo(this);
    }
  }
  
  public void a()
  {
    this.e.setVisibility(0);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    this.c.a(paramFloat, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    Chip localChip = this.a;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localChip.setChecked(bool1);
    localChip = this.b;
    if (paramInt == 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localChip.setChecked(bool1);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 1) {
      paramInt1 = R.id.p;
    } else {
      paramInt1 = R.id.o;
    }
    this.e.a(paramInt1);
    Object localObject = getResources().getConfiguration().locale;
    String str = String.format((Locale)localObject, "%02d", new Object[] { Integer.valueOf(paramInt3) });
    localObject = String.format((Locale)localObject, "%02d", new Object[] { Integer.valueOf(paramInt2) });
    this.a.setText(str);
    this.b.setText((CharSequence)localObject);
  }
  
  public void a(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompat.setAccessibilityDelegate(this.b, paramAccessibilityDelegateCompat);
  }
  
  public void a(ClockHandView.OnActionUpListener paramOnActionUpListener)
  {
    this.c.a(paramOnActionUpListener);
  }
  
  public void a(ClockHandView.OnRotateListener paramOnRotateListener)
  {
    this.c.a(paramOnRotateListener);
  }
  
  void a(@Nullable TimePickerView.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.i = paramOnDoubleTapListener;
  }
  
  void a(TimePickerView.OnPeriodChangeListener paramOnPeriodChangeListener)
  {
    this.g = paramOnPeriodChangeListener;
  }
  
  void a(TimePickerView.OnSelectionChange paramOnSelectionChange)
  {
    this.h = paramOnSelectionChange;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, @StringRes int paramInt)
  {
    this.d.a(paramArrayOfString, paramInt);
  }
  
  public void b(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompat.setAccessibilityDelegate(this.a, paramAccessibilityDelegateCompat);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d();
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramView == this) && (paramInt == 0)) {
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerView
 * JD-Core Version:    0.7.0.1
 */