package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.Cell;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class GesturePWDCreateActivity
  extends IphoneTitleBarActivity
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LockPatternView jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView;
  String jdField_a_of_type_JavaLangString = "";
  int[] jdField_a_of_type_ArrayOfInt = new int[9];
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    c();
  }
  
  private void b()
  {
    setTitle(2131692893);
    setLeftButton(2131690728, new GesturePWDCreateActivity.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367634));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131367633));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(new GesturePWDCreateActivity.2(this));
    if (this.mDensity <= 1.0D)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      localLayoutParams.height = ((int)(this.mDensity * 240.0F));
      localLayoutParams.width = ((int)(this.mDensity * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367647);
    this.b = findViewById(2131367648);
    this.c = findViewById(2131367649);
    this.d = findViewById(2131367650);
    this.e = findViewById(2131367651);
    this.f = findViewById(2131367652);
    this.g = findViewById(2131367653);
    this.h = findViewById(2131367654);
    this.i = findViewById(2131367655);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = new int[9];
    }
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (j >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[j] = 0;
      j += 1;
    }
  }
  
  private void d()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if ((arrayOfInt != null) && (arrayOfInt.length == 9))
    {
      if (arrayOfInt[0] == 1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845249);
      } else {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[1] == 1) {
        this.b.setBackgroundResource(2130845249);
      } else {
        this.b.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[2] == 1) {
        this.c.setBackgroundResource(2130845249);
      } else {
        this.c.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[3] == 1) {
        this.d.setBackgroundResource(2130845249);
      } else {
        this.d.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[4] == 1) {
        this.e.setBackgroundResource(2130845249);
      } else {
        this.e.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[5] == 1) {
        this.f.setBackgroundResource(2130845249);
      } else {
        this.f.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[6] == 1) {
        this.g.setBackgroundResource(2130845249);
      } else {
        this.g.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[7] == 1) {
        this.h.setBackgroundResource(2130845249);
      } else {
        this.h.setBackgroundResource(2130845248);
      }
      if (this.jdField_a_of_type_ArrayOfInt[8] == 1)
      {
        this.i.setBackgroundResource(2130845249);
        return;
      }
      this.i.setBackgroundResource(2130845248);
    }
  }
  
  void a(List<LockPatternView.Cell> paramList)
  {
    c();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (LockPatternView.Cell)paramList.next();
        if (localObject != null)
        {
          int j = ((LockPatternView.Cell)localObject).a() * 3 + ((LockPatternView.Cell)localObject).b();
          if (j >= 0)
          {
            localObject = this.jdField_a_of_type_ArrayOfInt;
            if (j < localObject.length) {
              localObject[j] = 1;
            }
          }
        }
      }
    }
    d();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559201);
    a();
    b();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772004, 2130772015);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity
 * JD-Core Version:    0.7.0.1
 */