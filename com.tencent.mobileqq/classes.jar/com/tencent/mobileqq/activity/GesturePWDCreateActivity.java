package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.Cell;
import java.util.Iterator;
import java.util.List;
import stt;
import stu;

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
    setTitle(2131436040);
    setLeftButton(2131433015, new stt(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364703));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131364705));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(new stu(this));
    if (this.mDensity <= 1.0D)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      localLayoutParams.height = ((int)(this.mDensity * 240.0F));
      localLayoutParams.width = ((int)(this.mDensity * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364693);
    this.b = findViewById(2131364694);
    this.c = findViewById(2131364695);
    this.d = findViewById(2131364696);
    this.e = findViewById(2131364697);
    this.f = findViewById(2131364698);
    this.g = findViewById(2131364699);
    this.h = findViewById(2131364700);
    this.i = findViewById(2131364701);
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
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842565);
      if (this.jdField_a_of_type_ArrayOfInt[1] != 1) {
        break label204;
      }
      this.b.setBackgroundResource(2130842565);
      label55:
      if (this.jdField_a_of_type_ArrayOfInt[2] != 1) {
        break label216;
      }
      this.c.setBackgroundResource(2130842565);
      label74:
      if (this.jdField_a_of_type_ArrayOfInt[3] != 1) {
        break label228;
      }
      this.d.setBackgroundResource(2130842565);
      label93:
      if (this.jdField_a_of_type_ArrayOfInt[4] != 1) {
        break label240;
      }
      this.e.setBackgroundResource(2130842565);
      label112:
      if (this.jdField_a_of_type_ArrayOfInt[5] != 1) {
        break label252;
      }
      this.f.setBackgroundResource(2130842565);
      label131:
      if (this.jdField_a_of_type_ArrayOfInt[6] != 1) {
        break label264;
      }
      this.g.setBackgroundResource(2130842565);
      label151:
      if (this.jdField_a_of_type_ArrayOfInt[7] != 1) {
        break label276;
      }
      this.h.setBackgroundResource(2130842565);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ArrayOfInt[8] != 1) {
        break label288;
      }
      this.i.setBackgroundResource(2130842565);
      return;
      label192:
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842564);
      break;
      label204:
      this.b.setBackgroundResource(2130842564);
      break label55;
      label216:
      this.c.setBackgroundResource(2130842564);
      break label74;
      label228:
      this.d.setBackgroundResource(2130842564);
      break label93;
      label240:
      this.e.setBackgroundResource(2130842564);
      break label112;
      label252:
      this.f.setBackgroundResource(2130842564);
      break label131;
      label264:
      this.g.setBackgroundResource(2130842564);
      break label151;
      label276:
      this.h.setBackgroundResource(2130842564);
    }
    label288:
    this.i.setBackgroundResource(2130842564);
  }
  
  public void a(List paramList)
  {
    c();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.next();
        if (localCell != null)
        {
          int j = localCell.a();
          j = localCell.b() + j * 3;
          if ((j >= 0) && (j < this.jdField_a_of_type_ArrayOfInt.length)) {
            this.jdField_a_of_type_ArrayOfInt[j] = 1;
          }
        }
      }
    }
    d();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969008);
    a();
    b();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034131, 2131034135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity
 * JD-Core Version:    0.7.0.1
 */