package com.tencent.mobileqq.activity;

import Override;
import afca;
import afcb;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import bgss;
import bgst;
import bizw;
import bjmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private afcb jdField_a_of_type_Afcb;
  public bgss a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<bgss> a;
  private String b;
  
  private void b()
  {
    Object localObject = getIntent();
    this.b = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    bgss localbgss = bgst.a(this).a();
    if ((localbgss != null) && (this.b.equals(localbgss.b)))
    {
      this.jdField_a_of_type_Bgss = localbgss;
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("id");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label113;
      }
      this.jdField_a_of_type_JavaUtilArrayList = bgst.a(this).a();
    }
    for (;;)
    {
      bjmj.a(bizw.a().a());
      a();
      return;
      this.jdField_a_of_type_Bgss = bgst.a(this).a(this, this.b);
      break;
      label113:
      this.jdField_a_of_type_JavaUtilArrayList = bgst.a(this).a(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = (bgss)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (((bgss)localObject).jdField_a_of_type_Bgss != null) {
          setTitle(((bgss)localObject).jdField_a_of_type_Bgss.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void c()
  {
    setContentBackgroundResource(2130838911);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379379));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Afcb = new afcb(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afcb);
  }
  
  public void a()
  {
    bgst.a(BaseApplicationImpl.getContext()).a(this.b, new afca(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131562978);
    setTitle(2131719507);
    b();
    c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bgss)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((paramAdapterView.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdapterView.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!paramAdapterView.b.equals("10015")) && (!paramAdapterView.b.equals("10017")))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.b);
      paramView.putExtra("troopGroupClassExt", this.b);
      startActivityForResult(paramView, 11);
      return;
    }
    bgst.a(this).a(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.b);
    setResult(-1, paramView);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */