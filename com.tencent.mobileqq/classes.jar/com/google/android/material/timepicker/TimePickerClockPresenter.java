package com.google.android.material.timepicker;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.R.string;

class TimePickerClockPresenter
  implements ClockHandView.OnActionUpListener, ClockHandView.OnRotateListener, TimePickerPresenter, TimePickerView.OnPeriodChangeListener, TimePickerView.OnSelectionChange
{
  private static final String[] a = { "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
  private static final String[] b = { "00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22" };
  private static final String[] c = { "00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" };
  private TimePickerView d;
  private TimeModel e;
  private float f;
  private float g;
  private boolean h = false;
  
  public TimePickerClockPresenter(TimePickerView paramTimePickerView, TimeModel paramTimeModel)
  {
    this.d = paramTimePickerView;
    this.e = paramTimeModel;
    a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.e.c != paramInt2) || (this.e.b != paramInt1))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramInt1 = 4;
      } else {
        paramInt1 = 1;
      }
      this.d.performHapticFeedback(paramInt1);
    }
  }
  
  private void a(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramArrayOfString[i] = TimeModel.a(this.d.getResources(), paramArrayOfString[i], paramString);
      i += 1;
    }
  }
  
  private String[] e()
  {
    if (this.e.a == 1) {
      return b;
    }
    return a;
  }
  
  private int f()
  {
    if (this.e.a == 1) {
      return 15;
    }
    return 30;
  }
  
  private void g()
  {
    this.d.a(this.e.e, this.e.a(), this.e.c);
  }
  
  private void h()
  {
    a(a, "%d");
    a(b, "%d");
    a(c, "%02d");
  }
  
  public void a()
  {
    if (this.e.a == 0) {
      this.d.a();
    }
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    h();
    b();
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if (this.h) {
      return;
    }
    int i = this.e.b;
    int j = this.e.c;
    int k = Math.round(paramFloat);
    if (this.e.d == 12)
    {
      this.e.b((k + 3) / 6);
      this.f = ((float)Math.floor(this.e.c * 6));
    }
    else
    {
      int m = f() / 2;
      this.e.a((k + m) / f());
      this.g = (this.e.a() * f());
    }
    if (!paramBoolean)
    {
      g();
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
    this.d.a(bool);
    this.e.d = paramInt;
    TimePickerView localTimePickerView = this.d;
    if (bool) {
      localObject = c;
    } else {
      localObject = e();
    }
    int i;
    if (bool) {
      i = R.string.l;
    } else {
      i = R.string.j;
    }
    localTimePickerView.a((String[])localObject, i);
    Object localObject = this.d;
    float f1;
    if (bool) {
      f1 = this.f;
    } else {
      f1 = this.g;
    }
    ((TimePickerView)localObject).a(f1, paramBoolean);
    this.d.a(paramInt);
    localObject = this.d;
    ((TimePickerView)localObject).a(new ClickActionDelegate(((TimePickerView)localObject).getContext(), R.string.i));
    localObject = this.d;
    ((TimePickerView)localObject).b(new ClickActionDelegate(((TimePickerView)localObject).getContext(), R.string.k));
  }
  
  public void b()
  {
    this.g = (this.e.a() * f());
    this.f = (this.e.c * 6);
    a(this.e.d, false);
    g();
  }
  
  public void b(float paramFloat, boolean paramBoolean)
  {
    this.h = true;
    int i = this.e.c;
    int j = this.e.b;
    if (this.e.d == 10)
    {
      this.d.a(this.g, false);
      if (!((AccessibilityManager)ContextCompat.getSystemService(this.d.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
        a(12, true);
      }
    }
    else
    {
      int k = Math.round(paramFloat);
      if (!paramBoolean)
      {
        k = (k + 15) / 30;
        this.e.b(k * 5);
        this.f = (this.e.c * 6);
      }
      this.d.a(this.f, paramBoolean);
    }
    this.h = false;
    g();
    a(j, i);
  }
  
  public void b(int paramInt)
  {
    this.e.c(paramInt);
  }
  
  public void c()
  {
    this.d.setVisibility(0);
  }
  
  public void d()
  {
    this.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerClockPresenter
 * JD-Core Version:    0.7.0.1
 */