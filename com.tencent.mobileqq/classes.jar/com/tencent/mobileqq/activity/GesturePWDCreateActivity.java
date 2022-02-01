package com.tencent.mobileqq.activity;

import Override;
import aesk;
import aesl;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import avor;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class GesturePWDCreateActivity
  extends IphoneTitleBarActivity
{
  public int a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public TextView a;
  public LockPatternView a;
  public String a;
  int[] jdField_a_of_type_ArrayOfInt = new int[9];
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  public GesturePWDCreateActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    c();
  }
  
  private void b()
  {
    setTitle(2131692637);
    setLeftButton(2131690580, new aesk(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367499));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131367498));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(new aesl(this));
    if (this.mDensity <= 1.0D)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      localLayoutParams.height = ((int)(this.mDensity * 240.0F));
      localLayoutParams.width = ((int)(this.mDensity * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367512);
    this.b = findViewById(2131367513);
    this.c = findViewById(2131367514);
    this.d = findViewById(2131367515);
    this.e = findViewById(2131367516);
    this.f = findViewById(2131367517);
    this.g = findViewById(2131367518);
    this.h = findViewById(2131367519);
    this.i = findViewById(2131367520);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = new int[9];
    }
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfInt[j] = 0;
      j += 1;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length == 9))
    {
      if (this.jdField_a_of_type_ArrayOfInt[0] != 1) {
        break label192;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845253);
      if (this.jdField_a_of_type_ArrayOfInt[1] != 1) {
        break label204;
      }
      this.b.setBackgroundResource(2130845253);
      label55:
      if (this.jdField_a_of_type_ArrayOfInt[2] != 1) {
        break label216;
      }
      this.c.setBackgroundResource(2130845253);
      label74:
      if (this.jdField_a_of_type_ArrayOfInt[3] != 1) {
        break label228;
      }
      this.d.setBackgroundResource(2130845253);
      label93:
      if (this.jdField_a_of_type_ArrayOfInt[4] != 1) {
        break label240;
      }
      this.e.setBackgroundResource(2130845253);
      label112:
      if (this.jdField_a_of_type_ArrayOfInt[5] != 1) {
        break label252;
      }
      this.f.setBackgroundResource(2130845253);
      label131:
      if (this.jdField_a_of_type_ArrayOfInt[6] != 1) {
        break label264;
      }
      this.g.setBackgroundResource(2130845253);
      label151:
      if (this.jdField_a_of_type_ArrayOfInt[7] != 1) {
        break label276;
      }
      this.h.setBackgroundResource(2130845253);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ArrayOfInt[8] != 1) {
        break label288;
      }
      this.i.setBackgroundResource(2130845253);
      return;
      label192:
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845252);
      break;
      label204:
      this.b.setBackgroundResource(2130845252);
      break label55;
      label216:
      this.c.setBackgroundResource(2130845252);
      break label74;
      label228:
      this.d.setBackgroundResource(2130845252);
      break label93;
      label240:
      this.e.setBackgroundResource(2130845252);
      break label112;
      label252:
      this.f.setBackgroundResource(2130845252);
      break label131;
      label264:
      this.g.setBackgroundResource(2130845252);
      break label151;
      label276:
      this.h.setBackgroundResource(2130845252);
    }
    label288:
    this.i.setBackgroundResource(2130845252);
  }
  
  public void a(List<avor> paramList)
  {
    c();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        avor localavor = (avor)paramList.next();
        if (localavor != null)
        {
          int j = localavor.a();
          j = localavor.b() + j * 3;
          if ((j >= 0) && (j < this.jdField_a_of_type_ArrayOfInt.length)) {
            this.jdField_a_of_type_ArrayOfInt[j] = 1;
          }
        }
      }
    }
    d();
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
    super.setContentView(2131559236);
    a();
    b();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771990, 2130772001);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity
 * JD-Core Version:    0.7.0.1
 */