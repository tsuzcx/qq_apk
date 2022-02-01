package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class BirthdayPickHelper
{
  BirthdayPickHelper.BirthdayChangeListener a;
  private IphonePickerView b;
  private int c;
  private int d;
  private int e;
  private Calendar f = Calendar.getInstance();
  private final int g;
  private final int h;
  private final int i;
  private Calendar j;
  private final int k;
  private final int l;
  private final int m;
  
  public BirthdayPickHelper(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.f.setTimeInMillis(System.currentTimeMillis());
    this.g = this.f.get(1);
    this.h = (this.f.get(2) + 1);
    this.i = this.f.get(5);
    this.j = Calendar.getInstance();
    this.j.setTimeInMillis(System.currentTimeMillis());
    this.j.add(1, -120);
    this.j.add(5, 1);
    this.k = this.j.get(1);
    this.l = (this.j.get(2) + 1);
    this.m = this.j.get(5);
    this.b = ((IphonePickerView)LayoutInflater.from(paramContext).inflate(2131627482, null));
    int n = this.g;
    int i1 = this.k;
    this.b.a(new BirthdayPickHelper.DateAdapter(this, n - i1 + 1));
    this.b.setPickListener(new BirthdayPickHelper.PickListener(this, null));
    this.b.setBackgroundColor(paramContext.getResources().getColor(2131168094));
    a(paramInt);
    if (paramBoolean) {
      this.b.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BirthdayPickHelper", 2, String.format("BirthdayPickHelper date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i) }));
    }
  }
  
  private int b(int paramInt)
  {
    return this.k + paramInt;
  }
  
  private void b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.k + this.c);
    localCalendar.set(2, this.d);
    localCalendar.set(5, this.e + 1);
    if (localCalendar.before(this.j))
    {
      this.c = 0;
      this.d = (this.l - 1);
      this.e = (this.m - 1);
      this.b.setSelection(0, this.c);
      this.b.setSelection(1, this.d);
      this.b.setSelection(2, this.e);
      return;
    }
    if (localCalendar.after(this.f))
    {
      this.c = (this.g - this.k);
      this.d = (this.h - 1);
      this.e = (this.i - 1);
      this.b.setSelection(0, this.c);
      this.b.setSelection(1, this.d);
      this.b.setSelection(2, this.e);
    }
  }
  
  private int c(int paramInt)
  {
    return paramInt + 1;
  }
  
  private int d(int paramInt)
  {
    return paramInt + 1;
  }
  
  public IphonePickerView a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    int i1;
    int n;
    if (paramInt <= 0)
    {
      i1 = 2000 - this.k;
      paramInt = 0;
      n = 0;
    }
    else
    {
      i1 = this.k;
      n = ((0xFF00 & paramInt) >>> 8) - 1;
      int i2 = (paramInt & 0xFF) - 1;
      i1 = ((0xFFFF0000 & paramInt) >>> 16) - i1;
      paramInt = i2;
    }
    this.c = i1;
    this.d = n;
    this.e = paramInt;
    this.b.setSelection(0, i1);
    this.b.setSelection(1, n);
    this.b.setSelection(2, paramInt);
  }
  
  public void a(BirthdayPickHelper.BirthdayChangeListener paramBirthdayChangeListener)
  {
    this.a = paramBirthdayChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BirthdayPickHelper
 * JD-Core Version:    0.7.0.1
 */