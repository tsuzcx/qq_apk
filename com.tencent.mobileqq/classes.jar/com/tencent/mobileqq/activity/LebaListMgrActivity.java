package com.tencent.mobileqq.activity;

import Override;
import adpl;
import adpm;
import adpn;
import ajek;
import aljq;
import alju;
import aljv;
import amux;
import amzt;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import aqmf;
import axkt;
import bcef;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import nru;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements alju, aljv, AdapterView.OnItemClickListener
{
  char jdField_a_of_type_Char;
  private aljq jdField_a_of_type_Aljq;
  protected amzt a;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new adpl(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axkt jdField_a_of_type_Axkt = new adpm(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_Amzt = new adpn(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131561141, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      View localView = View.inflate(this, 2131561139, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378707));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693306);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Aljq == null)
    {
      this.jdField_a_of_type_Aljq = new aljq(this.app, this, ajek.a().a(), this, this);
      this.jdField_a_of_type_Aljq.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aljq);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131693305);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + ajek.a().jdField_a_of_type_Boolean);
    }
    this.app.initLebaHelper();
    this.jdField_a_of_type_Aljq.a(this.app.getLebaHelper().a());
    if (!ajek.a().jdField_a_of_type_Boolean) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public void a(aqmf paramaqmf) {}
  
  public boolean a(aqmf paramaqmf)
  {
    return (paramaqmf != null) && (paramaqmf.a != null);
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
    ajek.jdField_a_of_type_Int |= 0x1;
    this.jdField_a_of_type_Char = this.app.getNowLiveManager().a().charAt(2);
    a();
    this.app.registObserver(this.jdField_a_of_type_Axkt);
    this.app.addObserver(this.jdField_a_of_type_Amzt, true);
    bcef.b(this.app, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_Aljq != null)
    {
      this.jdField_a_of_type_Aljq.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_Aljq = null;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Axkt);
    this.app.removeObserver(this.jdField_a_of_type_Amzt);
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
    this.jdField_a_of_type_Aljq.a(ajek.a().a());
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
    if (this.jdField_a_of_type_Aljq != null) {
      this.jdField_a_of_type_Aljq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */