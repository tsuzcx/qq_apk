package com.google.android.material.timepicker;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.R.string;

class TimePickerClockPresenter
  implements ClockHandView.OnActionUpListener, ClockHandView.OnRotateListener, TimePickerPresenter, TimePickerView.OnPeriodChangeListener, TimePickerView.OnSelectionChange
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22" };
  private static final String[] c = { "00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" };
  private float jdField_a_of_type_Float;
  private TimeModel jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel;
  private TimePickerView jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  
  public TimePickerClockPresenter(TimePickerView paramTimePickerView, TimeModel paramTimeModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView = paramTimePickerView;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel = paramTimeModel;
    a();
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.a == 1) {
      return 15;
    }
    return 30;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c != paramInt2) || (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.b != paramInt1))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramInt1 = 4;
      } else {
        paramInt1 = 1;
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.performHapticFeedback(paramInt1);
    }
  }
  
  private void a(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramArrayOfString[i] = TimeModel.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.getResources(), paramArrayOfString[i], paramString);
      i += 1;
    }
  }
  
  private String[] a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.a == 1) {
      return jdField_b_of_type_ArrayOfJavaLangString;
    }
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.e, this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.a(), this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c);
  }
  
  private void f()
  {
    a(jdField_a_of_type_ArrayOfJavaLangString, "%d");
    a(jdField_b_of_type_ArrayOfJavaLangString, "%d");
    a(c, "%02d");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.a == 0) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a();
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(this);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(this);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(this);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(this);
    f();
    b();
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.b;
    int j = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c;
    int k = Math.round(paramFloat);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d == 12)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.b((k + 3) / 6);
      this.jdField_a_of_type_Float = ((float)Math.floor(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c * 6));
    }
    else
    {
      int m = a() / 2;
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.a((k + m) / a());
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.a() * a());
    }
    if (!paramBoolean)
    {
      e();
      a(i, j);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    boolean bool;
    if (paramInt == 12) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(bool);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d = paramInt;
    TimePickerView localTimePickerView = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView;
    if (bool) {
      localObject = c;
    } else {
      localObject = a();
    }
    int i;
    if (bool) {
      i = R.string.l;
    } else {
      i = R.string.j;
    }
    localTimePickerView.a((String[])localObject, i);
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView;
    float f;
    if (bool) {
      f = this.jdField_a_of_type_Float;
    } else {
      f = this.jdField_b_of_type_Float;
    }
    ((TimePickerView)localObject).a(f, paramBoolean);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(paramInt);
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView;
    ((TimePickerView)localObject).a(new ClickActionDelegate(((TimePickerView)localObject).getContext(), R.string.i));
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView;
    ((TimePickerView)localObject).b(new ClickActionDelegate(((TimePickerView)localObject).getContext(), R.string.k));
  }
  
  public void b()
  {
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.a() * a());
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c * 6);
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d, false);
    e();
  }
  
  public void b(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c;
    int j = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.b;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d == 10)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(this.jdField_b_of_type_Float, false);
      if (!((AccessibilityManager)ContextCompat.getSystemService(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
        a(12, true);
      }
    }
    else
    {
      int k = Math.round(paramFloat);
      if (!paramBoolean)
      {
        k = (k + 15) / 30;
        this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.b(k * 5);
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c * 6);
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(this.jdField_a_of_type_Float, paramBoolean);
    }
    this.jdField_a_of_type_Boolean = false;
    e();
    a(j, i);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.c(paramInt);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.setVisibility(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerClockPresenter
 * JD-Core Version:    0.7.0.1
 */