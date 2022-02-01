package com.dataline.activities;

import Override;
import amqd;
import amtj;
import amxn;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
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
  public amqd a;
  public LayoutInflater a;
  public XListView a;
  da jdField_a_of_type_Da;
  private dn jdField_a_of_type_Dn = new cy(this);
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public List<cz> b = new ArrayList();
  
  public PrinterSubOptionActivity()
  {
    this.jdField_a_of_type_Amqd = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Amqd.jdField_a_of_type_Dk != null)
    {
      int j = 0;
      int k = 0;
      this.b.clear();
      List localList = this.jdField_a_of_type_Amqd.jdField_a_of_type_Dk.a();
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_Amqd = ((amqd)this.app.getBusinessHandler(8));
    this.jdField_a_of_type_Amqd.jdField_a_of_type_Amxk.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131165437);
    setContentView(2131559059);
    setTitle(2131691251);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Da = new da(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131372947));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361807, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Da);
    if (!this.jdField_a_of_type_Amqd.jdField_a_of_type_Dk.a())
    {
      paramBundle = findViewById(2131366062);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(amtj.a(2131707535));
      ((TextView)findViewById(2131378961)).setText(getString(2131691243));
      ((TextView)findViewById(2131363685)).setText(getString(2131691242));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      setLeftViewName(2131690599);
      this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361807, "n/a");
      return true;
      a();
      this.jdField_a_of_type_Amqd.jdField_a_of_type_Dk.a(this.jdField_a_of_type_Dn);
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Amqd.jdField_a_of_type_Dk.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131691244);
    this.b.clear();
    a();
    amxn localamxn = (amxn)this.app.getBusinessHandler(74);
    this.jdField_a_of_type_Boolean = localamxn.a();
    localamxn.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */