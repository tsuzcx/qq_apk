package com.tencent.mobileqq.activity;

import Override;
import aeeh;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import bdla;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class JobSelectionActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private aeeh jdField_a_of_type_Aeeh;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = paramInt;
      if (paramInt >= anrz.c[0]) {
        i = paramInt + 2;
      }
      return i;
    }
    return paramInt + 1;
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
    super.setContentView(2131561181);
    setTitle(2131693398);
    setLeftViewName(2131690499);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("param_id", -1);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("param_need_no_limit", false);
    this.b = getIntent().getBooleanExtra("param_from_consearch", false);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370221));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Aeeh = new aeeh(this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aeeh);
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_Aeeh.notifyDataSetChanged();
    if (this.b) {
      bdla.b(this.app, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("param_id", this.jdField_a_of_type_Int);
    if (!this.b)
    {
      localIntent.putExtra("param_tag", bgzv.e[this.jdField_a_of_type_Int]);
      localIntent.putExtra("param_name", bgzv.d[this.jdField_a_of_type_Int]);
      localIntent.putExtra("param_tag_bg", bgzv.b[this.jdField_a_of_type_Int]);
    }
    setResult(-1, localIntent);
    finish();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity
 * JD-Core Version:    0.7.0.1
 */