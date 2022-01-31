package com.tencent.mobileqq.activity;

import ablc;
import abld;
import able;
import agca;
import ainm;
import ainq;
import ainr;
import ajzo;
import akfh;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import andx;
import atzl;
import axqw;
import bfpc;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import ndh;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements ainq, ainr, bfpc
{
  char jdField_a_of_type_Char;
  private ainm jdField_a_of_type_Ainm;
  protected akfh a;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new ablc(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atzl jdField_a_of_type_Atzl = new abld(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_Akfh = new able(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131560818, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      View localView = View.inflate(this, 2131560816, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377350));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693754);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Ainm == null)
    {
      this.jdField_a_of_type_Ainm = new ainm(this.app, this, agca.a().a(), this, this);
      this.jdField_a_of_type_Ainm.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ainm);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131693753);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + agca.a().jdField_a_of_type_Boolean);
    }
    this.app.m();
    this.jdField_a_of_type_Ainm.a(this.app.a().a());
    if (!agca.a().jdField_a_of_type_Boolean) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public void a(andx paramandx) {}
  
  public boolean a(andx paramandx)
  {
    return (paramandx != null) && (paramandx.a != null);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    agca.jdField_a_of_type_Int |= 0x1;
    this.jdField_a_of_type_Char = this.app.a().a().charAt(2);
    a();
    this.app.registObserver(this.jdField_a_of_type_Atzl);
    this.app.addObserver(this.jdField_a_of_type_Akfh, true);
    axqw.b(this.app, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_Ainm != null)
    {
      this.jdField_a_of_type_Ainm.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_Ainm = null;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Atzl);
    this.app.removeObserver(this.jdField_a_of_type_Akfh);
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
    this.jdField_a_of_type_Ainm.a(agca.a().a());
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_Ainm != null) {
      this.jdField_a_of_type_Ainm.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */