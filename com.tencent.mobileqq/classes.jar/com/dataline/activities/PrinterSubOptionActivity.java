package com.dataline.activities;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import anjx;
import anni;
import anrg;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cy;
import cz;
import da;
import dj;
import dk;
import dn;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public LayoutInflater a;
  public anjx a;
  public XListView a;
  da jdField_a_of_type_Da;
  private dn jdField_a_of_type_Dn = new cy(this);
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public List<cz> b = new ArrayList();
  
  public PrinterSubOptionActivity()
  {
    this.jdField_a_of_type_Anjx = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk != null)
    {
      int j = 0;
      int k = 0;
      this.b.clear();
      List localList = this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a();
      int i1 = localList.size();
      int i = 0;
      if (i < i1)
      {
        dj localdj = (dj)localList.get(i);
        int n;
        int m;
        if ((localdj.jdField_a_of_type_Int == 1) && (j == 0))
        {
          this.b.add(new cz(this, 1, 0L, "PC绑定的打印机"));
          n = 1;
          m = k;
        }
        for (;;)
        {
          this.b.add(new cz(this, 2, localdj.jdField_a_of_type_Long, localdj.jdField_a_of_type_JavaLangString));
          i += 1;
          k = m;
          j = n;
          break;
          m = k;
          n = j;
          if (localdj.jdField_a_of_type_Int == 2)
          {
            m = k;
            n = j;
            if (k == 0)
            {
              this.b.add(new cz(this, 1, 0L, "QQ物联打印机"));
              m = 1;
              n = j;
            }
          }
        }
      }
      this.jdField_a_of_type_Da.notifyDataSetChanged();
    }
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
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_Anjx = ((anjx)this.app.a(8));
    this.jdField_a_of_type_Anjx.jdField_a_of_type_Anrd.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131165431);
    setContentView(2131559052);
    setTitle(2131691209);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Da = new da(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131372863));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361807, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Da);
    if (!this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a())
    {
      paramBundle = findViewById(2131365986);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(anni.a(2131707194));
      ((TextView)findViewById(2131379028)).setText(getString(2131691201));
      ((TextView)findViewById(2131363629)).setText(getString(2131691200));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      setLeftViewName(2131690563);
      this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361807, "n/a");
      return true;
      a();
      this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a(this.jdField_a_of_type_Dn);
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131691202);
    this.b.clear();
    a();
    anrg localanrg = (anrg)this.app.a(74);
    this.jdField_a_of_type_Boolean = localanrg.a();
    localanrg.a();
  }
  
  public boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */