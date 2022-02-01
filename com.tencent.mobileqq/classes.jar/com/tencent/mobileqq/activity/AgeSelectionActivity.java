package com.tencent.mobileqq.activity;

import Override;
import adlk;
import adll;
import adqp;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import anni;
import aypy;
import bght;
import bgjw;
import bkho;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  adqp jdField_a_of_type_Adqp;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkho jdField_a_of_type_Bkho;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  public int c;
  public int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public static int a(String paramString)
  {
    return Arrays.asList(bght.c).indexOf(paramString);
  }
  
  private void a()
  {
    a(this.jdField_b_of_type_Int, this.c, this.d);
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.h);
    localIntent.putExtra("param_constellation_id", a(this.jdField_a_of_type_JavaLangString));
    localIntent.putExtra("param_constellation", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("param_year", (short)this.jdField_b_of_type_Int);
    localIntent.putExtra("param_month", (byte)this.c);
    localIntent.putExtra("param_day", (byte)this.d);
    setResult(-1, localIntent);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = (this.e - paramInt1);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, paramInt2, paramInt3);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, this.f, this.g);
    if (localCalendar1.after(localCalendar2)) {
      this.h -= 1;
    }
    if (this.h < 0) {
      this.h = 0;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.h + anni.a(2131698828));
    this.jdField_a_of_type_JavaLangString = bgjw.a(paramInt2, paramInt3);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  private boolean a()
  {
    return ("VAL_FROM_STATUS_MSG_TAB".equals(this.jdField_b_of_type_JavaLangString)) || ("VAL_FROM_STATUS_SETTING".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bkho == null)
    {
      this.jdField_a_of_type_Adqp = new adqp(getBaseContext(), this.jdField_a_of_type_Int, false);
      this.jdField_a_of_type_Bkho = bkho.c(this);
      this.jdField_a_of_type_Bkho.e(true);
      this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_Adqp.a(), null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bkho.findViewById(2131361980);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bkho.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_Adqp.a(new adll(this));
    }
    if (!this.jdField_a_of_type_Bkho.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bkho.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561005);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("param_launch_from");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362285));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364928));
    findViewById(2131362289).setOnClickListener(this);
    findViewById(2131364931).setOnClickListener(this);
    setTitle(anni.a(2131698825));
    setLeftViewName(2131690389);
    if (a()) {
      setRightButton(2131692257, new adlk(this));
    }
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.e = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    this.f = (this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
    this.g = this.jdField_a_of_type_JavaUtilCalendar.get(5);
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("doOnCreate date : %s-%s-%s ", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g) }));
    }
    this.jdField_a_of_type_Int = getIntent().getIntExtra("param_birthday", 0);
    this.jdField_b_of_type_Int = 2000;
    this.c = 1;
    this.d = 1;
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_b_of_type_Int = ((this.jdField_a_of_type_Int & 0xFFFF0000) >>> 16);
      this.c = ((this.jdField_a_of_type_Int & 0xFF00) >>> 8);
      this.d = (this.jdField_a_of_type_Int & 0xFF);
    }
    a(this.jdField_b_of_type_Int, this.c, this.d);
    b();
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (!a()) {
      a();
    }
    for (;;)
    {
      return super.onBackEvent();
      if ("VAL_FROM_STATUS_MSG_TAB".equals(this.jdField_b_of_type_JavaLangString)) {
        aypy.a("0X800AF46");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity
 * JD-Core Version:    0.7.0.1
 */