package com.tencent.mobileqq.activity;

import abjj;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import axqy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class JobSelectionActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private abjj jdField_a_of_type_Abjj;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = paramInt;
      if (paramInt >= ajtw.c[0]) {
        i = paramInt + 2;
      }
      return i;
    }
    return paramInt + 1;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560799);
    setTitle(2131693686);
    setLeftViewName(2131690331);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("param_id", -1);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("param_need_no_limit", false);
    this.b = getIntent().getBooleanExtra("param_from_consearch", false);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369306));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Abjj = new abjj(this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Abjj);
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_Abjj.notifyDataSetChanged();
    if (this.b) {
      axqy.b(this.app, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
    }
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("param_id", this.jdField_a_of_type_Int);
    if (!this.b)
    {
      paramAdapterView.putExtra("param_tag", bazx.e[this.jdField_a_of_type_Int]);
      paramAdapterView.putExtra("param_name", bazx.d[this.jdField_a_of_type_Int]);
      paramAdapterView.putExtra("param_tag_bg", bazx.b[this.jdField_a_of_type_Int]);
    }
    setResult(-1, paramAdapterView);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity
 * JD-Core Version:    0.7.0.1
 */