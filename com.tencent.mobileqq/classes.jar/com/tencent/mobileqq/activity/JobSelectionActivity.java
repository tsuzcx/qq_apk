package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import tai;

public class JobSelectionActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private tai jdField_a_of_type_Tai;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970384);
    setTitle(2131433105);
    setLeftViewName(2131432425);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("param_id", -1);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("param_need_no_limit", false);
    this.b = getIntent().getBooleanExtra("param_from_consearch", false);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131364209));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Tai = new tai(this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Tai);
    return true;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = (paramInt + 1))
    {
      this.jdField_a_of_type_Tai.notifyDataSetChanged();
      if (this.b) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("param_id", this.jdField_a_of_type_Int);
      if (!this.b)
      {
        paramAdapterView.putExtra("param_tag", com.tencent.mobileqq.util.NearbyProfileUtil.e[this.jdField_a_of_type_Int]);
        paramAdapterView.putExtra("param_name", com.tencent.mobileqq.util.NearbyProfileUtil.d[this.jdField_a_of_type_Int]);
        paramAdapterView.putExtra("param_tag_bg", com.tencent.mobileqq.util.NearbyProfileUtil.b[this.jdField_a_of_type_Int]);
      }
      setResult(-1, paramAdapterView);
      finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity
 * JD-Core Version:    0.7.0.1
 */