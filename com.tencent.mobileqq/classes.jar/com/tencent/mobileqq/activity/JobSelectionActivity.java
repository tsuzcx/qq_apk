package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class JobSelectionActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private ListView a;
  private JobSelectionActivity.Adapter b;
  private int c;
  private boolean d = false;
  private boolean e;
  
  int a(int paramInt)
  {
    int i;
    if (this.d)
    {
      i = paramInt;
      if (paramInt >= com.tencent.mobileqq.app.ConditionSearchManager.p[0]) {
        return paramInt + 2;
      }
    }
    else
    {
      i = paramInt + 1;
    }
    return i;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627475);
    setTitle(2131891059);
    setLeftViewName(2131887440);
    this.c = getIntent().getIntExtra("param_id", -1);
    this.d = getIntent().getBooleanExtra("param_need_no_limit", false);
    this.e = getIntent().getBooleanExtra("param_from_consearch", false);
    this.a = ((ListView)findViewById(2131437317));
    this.a.setOnItemClickListener(this);
    this.b = new JobSelectionActivity.Adapter(this, null);
    this.a.setAdapter(this.b);
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
    this.c = a(paramInt);
    this.b.notifyDataSetChanged();
    if (this.e)
    {
      localObject = this.app;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, localStringBuilder.toString(), "", "", "");
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("param_id", this.c);
    if (!this.e)
    {
      ((Intent)localObject).putExtra("param_tag", com.tencent.mobileqq.util.NearbyProfileUtil.f[this.c]);
      ((Intent)localObject).putExtra("param_name", com.tencent.mobileqq.util.NearbyProfileUtil.e[this.c]);
      ((Intent)localObject).putExtra("param_tag_bg", com.tencent.mobileqq.util.NearbyProfileUtil.g[this.c]);
    }
    setResult(-1, (Intent)localObject);
    finish();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity
 * JD-Core Version:    0.7.0.1
 */