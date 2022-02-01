package com.tencent.mobileqq.activity;

import Override;
import aewj;
import aewk;
import aewl;
import akgr;
import amow;
import ampa;
import ampb;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import aoaw;
import aoge;
import arsh;
import ayxl;
import bdll;
import bljm;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import nql;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements ampa, ampb, bljm
{
  char jdField_a_of_type_Char;
  private amow jdField_a_of_type_Amow;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new aewj(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected aoge a;
  private ayxl jdField_a_of_type_Ayxl = new aewk(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_Aoge = new aewl(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131561266, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      View localView = View.inflate(this, 2131561264, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378936));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693217);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Amow == null)
    {
      this.jdField_a_of_type_Amow = new amow(this.app, this, akgr.a().a(), this, this);
      this.jdField_a_of_type_Amow.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amow);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131693216);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + akgr.a().jdField_a_of_type_Boolean);
    }
    this.app.n();
    this.jdField_a_of_type_Amow.a(this.app.a().a());
    if (!akgr.a().jdField_a_of_type_Boolean) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public void a(arsh paramarsh) {}
  
  public boolean a(arsh paramarsh)
  {
    return (paramarsh != null) && (paramarsh.a != null);
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
    akgr.jdField_a_of_type_Int |= 0x1;
    this.jdField_a_of_type_Char = this.app.a().a().charAt(2);
    a();
    this.app.registObserver(this.jdField_a_of_type_Ayxl);
    this.app.addObserver(this.jdField_a_of_type_Aoge, true);
    bdll.b(this.app, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_Amow != null)
    {
      this.jdField_a_of_type_Amow.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_Amow = null;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Ayxl);
    this.app.removeObserver(this.jdField_a_of_type_Aoge);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Amow.a(akgr.a().a());
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_Amow != null) {
      this.jdField_a_of_type_Amow.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */