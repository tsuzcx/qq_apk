package com.tencent.mobileqq.activity;

import aaij;
import aaik;
import ajya;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import bazx;
import bbbr;
import bfpc;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfpc jdField_a_of_type_Bfpc;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public static int a(String paramString)
  {
    return Arrays.asList(bazx.c).indexOf(paramString);
  }
  
  private void a()
  {
    this.j = (this.jdField_a_of_type_Int - (this.d + this.g));
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, this.h + 1, this.i + 1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, this.jdField_b_of_type_Int, this.c);
    if (localCalendar1.after(localCalendar2)) {
      this.j -= 1;
    }
    if (this.j < 0) {
      this.j = 0;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.j + ajya.a(2131700021));
    this.jdField_a_of_type_JavaLangString = bbbr.a(this.h + 1, this.i + 1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bfpc == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131560804, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new aaik(this, null));
      this.jdField_a_of_type_Bfpc = bfpc.c(this);
      this.jdField_a_of_type_Bfpc.d(true);
      this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bfpc.findViewById(2131361922);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bfpc.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new aaij(this));
    }
    if (!this.jdField_a_of_type_Bfpc.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.g);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.h);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.i);
    }
    try
    {
      this.jdField_a_of_type_Bfpc.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void c()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.d + this.g);
    localCalendar.set(2, this.h);
    localCalendar.set(5, this.i + 1);
    if (localCalendar.before(this.jdField_b_of_type_JavaUtilCalendar))
    {
      this.g = 0;
      this.h = (this.e - 1);
      this.i = (this.f - 1);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.g);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.h);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.i);
    }
    while (!localCalendar.after(this.jdField_a_of_type_JavaUtilCalendar)) {
      return;
    }
    this.g = (this.jdField_a_of_type_Int - this.d);
    this.h = (this.jdField_b_of_type_Int - 1);
    this.i = (this.c - 1);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.g);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.h);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.i);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560608);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362189));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364626));
    findViewById(2131362193).setOnClickListener(this);
    findViewById(2131364627).setOnClickListener(this);
    setTitle(ajya.a(2131700018));
    setLeftViewName(2131690331);
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
    this.c = this.jdField_a_of_type_JavaUtilCalendar.get(5);
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.jdField_b_of_type_JavaUtilCalendar.add(1, -120);
    this.jdField_b_of_type_JavaUtilCalendar.add(5, 1);
    this.d = this.jdField_b_of_type_JavaUtilCalendar.get(1);
    this.e = (this.jdField_b_of_type_JavaUtilCalendar.get(2) + 1);
    this.f = this.jdField_b_of_type_JavaUtilCalendar.get(5);
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("doOnCreate date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c) }));
    }
    int k = getIntent().getIntExtra("param_birthday", 0);
    if (k == 0)
    {
      this.g = (1990 - this.d);
      this.h = 0;
    }
    for (this.i = 0;; this.i = ((k & 0xFF) - 1))
    {
      a();
      b();
      return true;
      this.g = (((0xFFFF0000 & k) >>> 16) - this.d);
      this.h = (((0xFF00 & k) >>> 8) - 1);
    }
  }
  
  public boolean onBackEvent()
  {
    this.g = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.h = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
    this.i = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    a();
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.j);
    localIntent.putExtra("param_constellation_id", a(this.jdField_a_of_type_JavaLangString));
    localIntent.putExtra("param_constellation", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("param_year", (short)(this.g + this.d));
    localIntent.putExtra("param_month", (byte)(this.h + 1));
    localIntent.putExtra("param_day", (byte)(this.i + 1));
    setResult(-1, localIntent);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity
 * JD-Core Version:    0.7.0.1
 */