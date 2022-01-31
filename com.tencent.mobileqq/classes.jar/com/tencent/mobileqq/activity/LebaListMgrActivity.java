package com.tencent.mobileqq.activity;

import abbg;
import abbh;
import abbi;
import afqa;
import aiat;
import aiax;
import aiay;
import ajqx;
import amnq;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import atdh;
import awqx;
import behi;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import msg;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements aiax, aiay, behi
{
  char jdField_a_of_type_Char;
  private aiat jdField_a_of_type_Aiat;
  protected ajqx a;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new abbg(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atdh jdField_a_of_type_Atdh = new abbh(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_Ajqx = new abbi(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131495240, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      View localView = View.inflate(this, 2131495238, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131311534));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131628113);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Aiat == null)
    {
      this.jdField_a_of_type_Aiat = new aiat(this.app, this, afqa.a().a(), this, this);
      this.jdField_a_of_type_Aiat.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aiat);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131628112);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + afqa.a().jdField_a_of_type_Boolean);
    }
    this.app.m();
    if (!afqa.a().jdField_a_of_type_Boolean) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public void a(amnq paramamnq) {}
  
  public boolean a(amnq paramamnq)
  {
    return (paramamnq != null) && (paramamnq.a != null);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    afqa.jdField_a_of_type_Int |= 0x1;
    this.jdField_a_of_type_Char = this.app.a().a().charAt(2);
    a();
    this.app.registObserver(this.jdField_a_of_type_Atdh);
    this.app.addObserver(this.jdField_a_of_type_Ajqx, true);
    awqx.b(this.app, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_Aiat != null)
    {
      this.jdField_a_of_type_Aiat.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_Aiat = null;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Atdh);
    this.app.removeObserver(this.jdField_a_of_type_Ajqx);
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
    this.jdField_a_of_type_Aiat.a(afqa.a().a());
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_Aiat != null) {
      this.jdField_a_of_type_Aiat.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */