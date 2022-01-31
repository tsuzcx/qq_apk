package com.tencent.mobileqq.activity;

import adcb;
import adcc;
import adcd;
import aiab;
import akev;
import akez;
import akfa;
import alra;
import alww;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import aovj;
import avqr;
import azmj;
import bhqp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import nga;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements akez, akfa, bhqp
{
  char jdField_a_of_type_Char;
  private akev jdField_a_of_type_Akev;
  protected alww a;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new adcb(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avqr jdField_a_of_type_Avqr = new adcc(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_Alww = new adcd(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131561000, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      View localView = View.inflate(this, 2131560998, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377884));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693871);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Akev == null)
    {
      this.jdField_a_of_type_Akev = new akev(this.app, this, aiab.a().a(), this, this);
      this.jdField_a_of_type_Akev.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akev);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131693870);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + aiab.a().jdField_a_of_type_Boolean);
    }
    this.app.m();
    this.jdField_a_of_type_Akev.a(this.app.a().a());
    if (!aiab.a().jdField_a_of_type_Boolean) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public void a(aovj paramaovj) {}
  
  public boolean a(aovj paramaovj)
  {
    return (paramaovj != null) && (paramaovj.a != null);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    aiab.jdField_a_of_type_Int |= 0x1;
    this.jdField_a_of_type_Char = this.app.a().a().charAt(2);
    a();
    this.app.registObserver(this.jdField_a_of_type_Avqr);
    this.app.addObserver(this.jdField_a_of_type_Alww, true);
    azmj.b(this.app, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_Akev != null)
    {
      this.jdField_a_of_type_Akev.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_Akev = null;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Avqr);
    this.app.removeObserver(this.jdField_a_of_type_Alww);
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
    this.jdField_a_of_type_Akev.a(aiab.a().a());
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_Akev != null) {
      this.jdField_a_of_type_Akev.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */