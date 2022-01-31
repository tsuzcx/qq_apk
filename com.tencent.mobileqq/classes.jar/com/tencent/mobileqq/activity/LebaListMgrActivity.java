package com.tencent.mobileqq.activity;

import adgq;
import adgr;
import adgs;
import aieq;
import akjk;
import akjo;
import akjp;
import alvp;
import ambl;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import aozs;
import avva;
import azqs;
import bhuw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import nga;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements akjo, akjp, bhuw
{
  char jdField_a_of_type_Char;
  private akjk jdField_a_of_type_Akjk;
  protected ambl a;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new adgq(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avva jdField_a_of_type_Avva = new adgr(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_Ambl = new adgs(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131561018, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      View localView = View.inflate(this, 2131561016, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377938));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693873);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Akjk == null)
    {
      this.jdField_a_of_type_Akjk = new akjk(this.app, this, aieq.a().a(), this, this);
      this.jdField_a_of_type_Akjk.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akjk);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131693872);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + aieq.a().jdField_a_of_type_Boolean);
    }
    this.app.m();
    this.jdField_a_of_type_Akjk.a(this.app.a().a());
    if (!aieq.a().jdField_a_of_type_Boolean) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public void a(aozs paramaozs) {}
  
  public boolean a(aozs paramaozs)
  {
    return (paramaozs != null) && (paramaozs.a != null);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    aieq.jdField_a_of_type_Int |= 0x1;
    this.jdField_a_of_type_Char = this.app.a().a().charAt(2);
    a();
    this.app.registObserver(this.jdField_a_of_type_Avva);
    this.app.addObserver(this.jdField_a_of_type_Ambl, true);
    azqs.b(this.app, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_Akjk != null)
    {
      this.jdField_a_of_type_Akjk.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_Akjk = null;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Avva);
    this.app.removeObserver(this.jdField_a_of_type_Ambl);
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
    this.jdField_a_of_type_Akjk.a(aieq.a().a());
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_Akjk != null) {
      this.jdField_a_of_type_Akjk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */