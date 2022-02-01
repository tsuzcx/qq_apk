package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;
import com.tencent.mm.ui.f;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class YADatePicker$DatePickerSpinnerDelegate
  extends YADatePicker.AbstractDatePickerDelegate
{
  private final LinearLayout f;
  private final EditText g;
  private final EditText h;
  private final EditText i;
  private final CalendarView j;
  private final java.text.DateFormat k = new SimpleDateFormat("MM/dd/yyyy");
  private String[] l;
  private int m;
  public final NumberPicker mDaySpinner;
  public final NumberPicker mMonthSpinner;
  public final NumberPicker mYearSpinner;
  private Calendar n;
  private Calendar o;
  private Calendar p;
  private Calendar q;
  private boolean r = true;
  
  YADatePicker$DatePickerSpinnerDelegate(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramYADatePicker, paramContext);
    this.a = paramYADatePicker;
    this.b = paramContext;
    a(Locale.getDefault());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DatePicker, paramInt1, paramInt2);
    boolean bool1 = localTypedArray.getBoolean(R.styleable.DatePicker_spinnersShown, true);
    boolean bool2 = localTypedArray.getBoolean(R.styleable.DatePicker_calendarViewShown, true);
    paramInt1 = localTypedArray.getInt(R.styleable.DatePicker_startYear, 1900);
    paramInt2 = localTypedArray.getInt(R.styleable.DatePicker_endYear, 2100);
    paramYADatePicker = localTypedArray.getString(R.styleable.DatePicker_minDate);
    paramAttributeSet = localTypedArray.getString(R.styleable.DatePicker_maxDate);
    int i1 = localTypedArray.getResourceId(R.styleable.DatePicker_legacyLayout, 2131624674);
    localTypedArray.recycle();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(i1, this.a, true);
    paramContext = new YADatePicker.DatePickerSpinnerDelegate.1(this);
    this.f = ((LinearLayout)this.a.findViewById(2131440290));
    this.j = ((CalendarView)this.a.findViewById(2131430244));
    this.j.setOnDateChangeListener(new YADatePicker.DatePickerSpinnerDelegate.2(this));
    this.mDaySpinner = ((NumberPicker)this.a.findViewById(2131431631));
    this.mDaySpinner.setFormatter(new TwoDigitFormatter());
    this.mDaySpinner.setOnLongPressUpdateInterval(100L);
    this.mDaySpinner.setOnValueChangedListener(paramContext);
    this.g = NumberPickerUtil.getInputText(this.mDaySpinner);
    this.mMonthSpinner = ((NumberPicker)this.a.findViewById(2131438820));
    this.mMonthSpinner.setMinValue(0);
    this.mMonthSpinner.setMaxValue(this.m - 1);
    this.mMonthSpinner.setDisplayedValues(this.l);
    this.mMonthSpinner.setOnLongPressUpdateInterval(200L);
    this.mMonthSpinner.setOnValueChangedListener(paramContext);
    this.h = NumberPickerUtil.getInputText(this.mMonthSpinner);
    this.mYearSpinner = ((NumberPicker)this.a.findViewById(2131450356));
    this.mYearSpinner.setOnLongPressUpdateInterval(100L);
    this.mYearSpinner.setOnValueChangedListener(paramContext);
    this.i = NumberPickerUtil.getInputText(this.mYearSpinner);
    if ((!bool1) && (!bool2))
    {
      setSpinnersShown(true);
    }
    else
    {
      setSpinnersShown(bool1);
      setCalendarViewShown(bool2);
    }
    this.n.clear();
    if (!TextUtils.isEmpty(paramYADatePicker))
    {
      if (!a(paramYADatePicker, this.n)) {
        this.n.set(paramInt1, 0, 1);
      }
    }
    else {
      this.n.set(paramInt1, 0, 1);
    }
    setMinDate(this.n.getTimeInMillis());
    this.n.clear();
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (!a(paramAttributeSet, this.n)) {
        this.n.set(paramInt2, 11, 31);
      }
    }
    else {
      this.n.set(paramInt2, 11, 31);
    }
    setMaxDate(this.n.getTimeInMillis());
    this.q.setTimeInMillis(System.currentTimeMillis());
    init(this.q.get(1), this.q.get(2), this.q.get(5), null);
    b();
    f();
    if (this.a.getImportantForAccessibility() == 0) {
      this.a.setImportantForAccessibility(1);
    }
  }
  
  private Calendar a(Calendar paramCalendar, Locale paramLocale)
  {
    if (paramCalendar == null) {
      return Calendar.getInstance(paramLocale);
    }
    long l1 = paramCalendar.getTimeInMillis();
    paramCalendar = Calendar.getInstance(paramLocale);
    paramCalendar.setTimeInMillis(l1);
    return paramCalendar;
  }
  
  private void a(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1 - 1) {
      paramInt1 = 5;
    } else {
      paramInt1 = 6;
    }
    paramNumberPicker = NumberPickerUtil.getInputText(paramNumberPicker);
    if (paramNumberPicker != null) {
      paramNumberPicker.setImeOptions(paramInt1);
    }
  }
  
  private boolean a()
  {
    return Character.isDigit(this.l[0].charAt(0));
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = this.q;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localCalendar.get(1) == paramInt1)
    {
      bool1 = bool2;
      if (this.q.get(2) == paramInt3)
      {
        if (this.q.get(5) != paramInt2) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString, Calendar paramCalendar)
  {
    try
    {
      paramCalendar.setTime(this.k.parse(paramString));
      return true;
    }
    catch (ParseException paramCalendar)
    {
      label14:
      StringBuilder localStringBuilder;
      break label14;
    }
    paramCalendar = YADatePicker.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Date: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" not in format: ");
    localStringBuilder.append("MM/dd/yyyy");
    f.d(paramCalendar, localStringBuilder.toString(), new Object[0]);
    return false;
  }
  
  private void b()
  {
    this.f.removeAllViews();
    char[] arrayOfChar;
    if ((Build.VERSION.SDK_INT >= 17) && (this.a.getLayoutDirection() != 0))
    {
      arrayOfChar = android.text.format.DateFormat.getDateFormatOrder(this.a.getContext());
    }
    else
    {
      arrayOfChar = new char[3];
      char[] tmp50_48 = arrayOfChar;
      tmp50_48[0] = 121;
      char[] tmp56_50 = tmp50_48;
      tmp56_50[1] = 77;
      char[] tmp62_56 = tmp56_50;
      tmp62_56[2] = 100;
      tmp62_56;
    }
    int i2 = arrayOfChar.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfChar[i1];
      if (i3 != 77)
      {
        if (i3 != 100)
        {
          if (i3 == 121)
          {
            this.f.addView(this.mYearSpinner);
            a(this.mYearSpinner, i2, i1);
          }
          else
          {
            throw new IllegalArgumentException(Arrays.toString(arrayOfChar));
          }
        }
        else
        {
          this.f.addView(this.mDaySpinner);
          a(this.mDaySpinner, i2, i1);
        }
      }
      else
      {
        this.f.addView(this.mMonthSpinner);
        a(this.mMonthSpinner, i2, i1);
      }
      i1 += 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.q.set(paramInt1, paramInt2, paramInt3);
    if (this.q.before(this.o))
    {
      this.q.setTimeInMillis(this.o.getTimeInMillis());
      return;
    }
    if (this.q.after(this.p)) {
      this.q.setTimeInMillis(this.p.getTimeInMillis());
    }
  }
  
  private void c()
  {
    if (this.q.equals(this.o))
    {
      this.mDaySpinner.setMinValue(this.q.get(5));
      this.mDaySpinner.setMaxValue(this.q.getActualMaximum(5));
      this.mDaySpinner.setWrapSelectorWheel(false);
      this.mMonthSpinner.setDisplayedValues(null);
      this.mMonthSpinner.setMinValue(this.q.get(2));
      this.mMonthSpinner.setMaxValue(this.q.getActualMaximum(2));
      this.mMonthSpinner.setWrapSelectorWheel(false);
    }
    else if (this.q.equals(this.p))
    {
      this.mDaySpinner.setMinValue(this.q.getActualMinimum(5));
      this.mDaySpinner.setMaxValue(this.q.get(5));
      this.mDaySpinner.setWrapSelectorWheel(false);
      this.mMonthSpinner.setDisplayedValues(null);
      this.mMonthSpinner.setMinValue(this.q.getActualMinimum(2));
      this.mMonthSpinner.setMaxValue(this.q.get(2));
      this.mMonthSpinner.setWrapSelectorWheel(false);
    }
    else
    {
      this.mDaySpinner.setMinValue(1);
      this.mDaySpinner.setMaxValue(this.q.getActualMaximum(5));
      this.mDaySpinner.setWrapSelectorWheel(true);
      this.mMonthSpinner.setDisplayedValues(null);
      this.mMonthSpinner.setMinValue(0);
      this.mMonthSpinner.setMaxValue(11);
      this.mMonthSpinner.setWrapSelectorWheel(true);
    }
    String[] arrayOfString = (String[])Arrays.copyOfRange(this.l, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1);
    this.mMonthSpinner.setDisplayedValues(arrayOfString);
    this.mYearSpinner.setMinValue(this.o.get(1));
    this.mYearSpinner.setMaxValue(this.p.get(1));
    this.mYearSpinner.setWrapSelectorWheel(false);
    this.mYearSpinner.setValue(this.q.get(1));
    this.mMonthSpinner.setValue(this.q.get(2));
    this.mDaySpinner.setValue(this.q.get(5));
    if (a()) {
      this.h.setRawInputType(2);
    }
  }
  
  private void d()
  {
    this.j.setDate(this.q.getTimeInMillis(), false, false);
  }
  
  private void e()
  {
    this.a.sendAccessibilityEvent(4);
    if (this.d != null) {
      this.d.onDateChanged(this.a, getYear(), getMonth(), getDayOfMonth());
    }
  }
  
  private void f() {}
  
  private void g()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (localInputMethodManager.isActive(this.i))
      {
        this.i.clearFocus();
        localInputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this.h))
      {
        this.h.clearFocus();
        localInputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this.g))
      {
        this.g.clearFocus();
        localInputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
      }
    }
  }
  
  protected void a(Locale paramLocale)
  {
    super.a(paramLocale);
    this.n = a(this.n, paramLocale);
    this.o = a(this.o, paramLocale);
    this.p = a(this.p, paramLocale);
    this.q = a(this.q, paramLocale);
    this.m = (this.n.getActualMaximum(2) + 1);
    this.l = new DateFormatSymbols().getShortMonths();
    if (a())
    {
      this.l = new String[this.m];
      int i2;
      for (int i1 = 0; i1 < this.m; i1 = i2)
      {
        paramLocale = this.l;
        i2 = i1 + 1;
        paramLocale[i1] = String.format("%d", new Object[] { Integer.valueOf(i2) });
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  public CalendarView getCalendarView()
  {
    return this.j;
  }
  
  public boolean getCalendarViewShown()
  {
    return this.j.getVisibility() == 0;
  }
  
  public int getDayOfMonth()
  {
    return this.q.get(5);
  }
  
  public int getFirstDayOfWeek()
  {
    return this.j.getFirstDayOfWeek();
  }
  
  public Calendar getMaxDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.j.getMaxDate());
    return localCalendar;
  }
  
  public Calendar getMinDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.j.getMinDate());
    return localCalendar;
  }
  
  public int getMonth()
  {
    return this.q.get(2);
  }
  
  public boolean getSpinnersShown()
  {
    return this.f.isShown();
  }
  
  public int getYear()
  {
    return this.q.get(1);
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, YADatePicker.OnDateChangedListener paramOnDateChangedListener)
  {
    b(paramInt1, paramInt2, paramInt3);
    c();
    d();
    this.d = paramOnDateChangedListener;
  }
  
  public boolean isEnabled()
  {
    return this.r;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    a(paramConfiguration.locale);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    String str = DateUtils.formatDateTime(this.b, this.q.getTimeInMillis(), 20);
    paramAccessibilityEvent.getText().add(str);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (YADatePicker.SavedState)paramParcelable;
    b(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
    c();
    d();
  }
  
  public Parcelable onSaveInstanceState(Parcelable paramParcelable)
  {
    return new YADatePicker.SavedState(paramParcelable, getYear(), getMonth(), getDayOfMonth(), null);
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    CalendarView localCalendarView = this.j;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localCalendarView.setVisibility(i1);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mDaySpinner.setEnabled(paramBoolean);
    this.mMonthSpinner.setEnabled(paramBoolean);
    this.mYearSpinner.setEnabled(paramBoolean);
    this.j.setEnabled(paramBoolean);
    this.r = paramBoolean;
  }
  
  public void setFirstDayOfWeek(int paramInt)
  {
    this.j.setFirstDayOfWeek(paramInt);
  }
  
  public void setMaxDate(long paramLong)
  {
    this.n.setTimeInMillis(paramLong);
    if ((this.n.get(1) == this.p.get(1)) && (this.n.get(6) != this.p.get(6))) {
      return;
    }
    this.p.setTimeInMillis(paramLong);
    this.j.setMaxDate(paramLong);
    if (this.q.after(this.p))
    {
      this.q.setTimeInMillis(this.p.getTimeInMillis());
      d();
    }
    c();
  }
  
  public void setMinDate(long paramLong)
  {
    this.n.setTimeInMillis(paramLong);
    if ((this.n.get(1) == this.o.get(1)) && (this.n.get(6) != this.o.get(6))) {
      return;
    }
    this.o.setTimeInMillis(paramLong);
    this.j.setMinDate(paramLong);
    if (this.q.before(this.o))
    {
      this.q.setTimeInMillis(this.o.getTimeInMillis());
      d();
    }
    c();
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.f;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localLinearLayout.setVisibility(i1);
  }
  
  public void updateDate(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a(paramInt1, paramInt2, paramInt3)) {
      return;
    }
    b(paramInt1, paramInt2, paramInt3);
    c();
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerSpinnerDelegate
 * JD-Core Version:    0.7.0.1
 */