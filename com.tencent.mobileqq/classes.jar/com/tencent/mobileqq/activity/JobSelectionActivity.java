package com.tencent.mobileqq.activity;

import adaj;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import azmj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class JobSelectionActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private adaj jdField_a_of_type_Adaj;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = paramInt;
      if (paramInt >= allj.c[0]) {
        i = paramInt + 2;
      }
      return i;
    }
    return paramInt + 1;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560982);
    setTitle(2131693802);
    setLeftViewName(2131690382);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("param_id", -1);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("param_need_no_limit", false);
    this.b = getIntent().getBooleanExtra("param_from_consearch", false);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369541));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Adaj = new adaj(this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Adaj);
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_Adaj.notifyDataSetChanged();
    if (this.b) {
      azmj.b(this.app, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
    }
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("param_id", this.jdField_a_of_type_Int);
    if (!this.b)
    {
      paramAdapterView.putExtra("param_tag", bcyr.e[this.jdField_a_of_type_Int]);
      paramAdapterView.putExtra("param_name", bcyr.d[this.jdField_a_of_type_Int]);
      paramAdapterView.putExtra("param_tag_bg", bcyr.b[this.jdField_a_of_type_Int]);
    }
    setResult(-1, paramAdapterView);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity
 * JD-Core Version:    0.7.0.1
 */