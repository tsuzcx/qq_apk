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
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TimePickerView.1(this);
  private final MaterialButtonToggleGroup jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup;
  private final Chip jdField_a_of_type_ComGoogleAndroidMaterialChipChip;
  private final ClockFaceView jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockFaceView;
  private final ClockHandView jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView;
  private TimePickerView.OnDoubleTapListener jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView$OnDoubleTapListener;
  private TimePickerView.OnPeriodChangeListener jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView$OnPeriodChangeListener;
  private TimePickerView.OnSelectionChange jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView$OnSelectionChange;
  private final Chip b;
  
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockFaceView = ((ClockFaceView)findViewById(R.id.m));
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup = ((MaterialButtonToggleGroup)findViewById(R.id.q));
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup.a(new TimePickerView.2(this));
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip = ((Chip)findViewById(R.id.v));
    this.b = ((Chip)findViewById(R.id.s));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView = ((ClockHandView)findViewById(R.id.n));
    b();
    c();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b()
  {
    TimePickerView.4 local4 = new TimePickerView.4(this, new GestureDetector(getContext(), new TimePickerView.3(this)));
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setOnTouchListener(local4);
    this.b.setOnTouchListener(local4);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setTag(R.id.aa, Integer.valueOf(12));
    this.b.setTag(R.id.aa, Integer.valueOf(10));
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup.getVisibility() == 0)
    {
      ConstraintSet localConstraintSet = new ConstraintSet();
      localConstraintSet.clone(this);
      int i = ViewCompat.getLayoutDirection(this);
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        j = 2;
      }
      localConstraintSet.clear(R.id.l, j);
      localConstraintSet.applyTo(this);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup.setVisibility(0);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView.a(paramFloat, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    Chip localChip = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip;
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup.a(paramInt1);
    Object localObject = getResources().getConfiguration().locale;
    String str = String.format((Locale)localObject, "%02d", new Object[] { Integer.valueOf(paramInt3) });
    localObject = String.format((Locale)localObject, "%02d", new Object[] { Integer.valueOf(paramInt2) });
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setText(str);
    this.b.setText((CharSequence)localObject);
  }
  
  public void a(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompat.setAccessibilityDelegate(this.b, paramAccessibilityDelegateCompat);
  }
  
  public void a(ClockHandView.OnActionUpListener paramOnActionUpListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView.a(paramOnActionUpListener);
  }
  
  public void a(ClockHandView.OnRotateListener paramOnRotateListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView.a(paramOnRotateListener);
  }
  
  void a(@Nullable TimePickerView.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView$OnDoubleTapListener = paramOnDoubleTapListener;
  }
  
  void a(TimePickerView.OnPeriodChangeListener paramOnPeriodChangeListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView$OnPeriodChangeListener = paramOnPeriodChangeListener;
  }
  
  void a(TimePickerView.OnSelectionChange paramOnSelectionChange)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView$OnSelectionChange = paramOnSelectionChange;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView.a(paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, @StringRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockFaceView.a(paramArrayOfString, paramInt);
  }
  
  public void b(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip, paramAccessibilityDelegateCompat);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerView
 * JD-Core Version:    0.7.0.1
 */