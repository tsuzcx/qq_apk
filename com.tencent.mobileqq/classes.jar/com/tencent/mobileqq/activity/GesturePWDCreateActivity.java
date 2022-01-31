package com.tencent.mobileqq.activity;

import abhu;
import abhv;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import aquq;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.LockPatternView;
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
    setTitle(2131692994);
    setLeftButton(2131690596, new abhu(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367008));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131367007));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(new abhv(this));
    if (this.mDensity <= 1.0D)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      localLayoutParams.height = ((int)(this.mDensity * 240.0F));
      localLayoutParams.width = ((int)(this.mDensity * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367021);
    this.b = findViewById(2131367022);
    this.c = findViewById(2131367023);
    this.d = findViewById(2131367024);
    this.e = findViewById(2131367025);
    this.f = findViewById(2131367026);
    this.g = findViewById(2131367027);
    this.h = findViewById(2131367028);
    this.i = findViewById(2131367029);
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
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844407);
      if (this.jdField_a_of_type_ArrayOfInt[1] != 1) {
        break label204;
      }
      this.b.setBackgroundResource(2130844407);
      label55:
      if (this.jdField_a_of_type_ArrayOfInt[2] != 1) {
        break label216;
      }
      this.c.setBackgroundResource(2130844407);
      label74:
      if (this.jdField_a_of_type_ArrayOfInt[3] != 1) {
        break label228;
      }
      this.d.setBackgroundResource(2130844407);
      label93:
      if (this.jdField_a_of_type_ArrayOfInt[4] != 1) {
        break label240;
      }
      this.e.setBackgroundResource(2130844407);
      label112:
      if (this.jdField_a_of_type_ArrayOfInt[5] != 1) {
        break label252;
      }
      this.f.setBackgroundResource(2130844407);
      label131:
      if (this.jdField_a_of_type_ArrayOfInt[6] != 1) {
        break label264;
      }
      this.g.setBackgroundResource(2130844407);
      label151:
      if (this.jdField_a_of_type_ArrayOfInt[7] != 1) {
        break label276;
      }
      this.h.setBackgroundResource(2130844407);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ArrayOfInt[8] != 1) {
        break label288;
      }
      this.i.setBackgroundResource(2130844407);
      return;
      label192:
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844406);
      break;
      label204:
      this.b.setBackgroundResource(2130844406);
      break label55;
      label216:
      this.c.setBackgroundResource(2130844406);
      break label74;
      label228:
      this.d.setBackgroundResource(2130844406);
      break label93;
      label240:
      this.e.setBackgroundResource(2130844406);
      break label112;
      label252:
      this.f.setBackgroundResource(2130844406);
      break label131;
      label264:
      this.g.setBackgroundResource(2130844406);
      break label151;
      label276:
      this.h.setBackgroundResource(2130844406);
    }
    label288:
    this.i.setBackgroundResource(2130844406);
  }
  
  public void a(List<aquq> paramList)
  {
    c();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aquq localaquq = (aquq)paramList.next();
        if (localaquq != null)
        {
          int j = localaquq.a();
          j = localaquq.b() + j * 3;
          if ((j >= 0) && (j < this.jdField_a_of_type_ArrayOfInt.length)) {
            this.jdField_a_of_type_ArrayOfInt[j] = 1;
          }
        }
      }
    }
    d();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559115);
    a();
    b();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771990, 2130772001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity
 * JD-Core Version:    0.7.0.1
 */