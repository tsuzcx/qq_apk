package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private TroopClassChoiceActivity.TroopClassChoiceAdapter jdField_a_of_type_ComTencentMobileqqActivityTroopClassChoiceActivity$TroopClassChoiceAdapter;
  GroupCatalogBean jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  ArrayList<GroupCatalogBean> jdField_a_of_type_JavaUtilArrayList;
  private String b;
  
  private void b()
  {
    Object localObject = getIntent();
    this.b = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(this).a();
    if ((localGroupCatalogBean != null) && (this.b.equals(localGroupCatalogBean.b))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean = localGroupCatalogBean;
    } else {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean = GroupCatalogTool.a(this).a(this, this.b);
    }
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("id");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this).a();
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this).a(this.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (GroupCatalogBean)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean != null) {
          setTitle(((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_JavaLangString);
        }
      }
    }
    CacheManager.a(CommonDataAdapter.a().a());
    a();
  }
  
  private void c()
  {
    setContentBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379131));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopClassChoiceActivity$TroopClassChoiceAdapter = new TroopClassChoiceActivity.TroopClassChoiceAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopClassChoiceActivity$TroopClassChoiceAdapter);
  }
  
  public void a()
  {
    GroupCatalogTool.a(BaseApplicationImpl.getContext()).a(this.b, new TroopClassChoiceActivity.GetClassChoiceCallBack(this));
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
    super.setContentView(2131562955);
    setTitle(2131719803);
    b();
    c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (GroupCatalogBean)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((paramAdapterView.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdapterView.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!paramAdapterView.b.equals("10015")) && (!paramAdapterView.b.equals("10017")))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.b);
      paramView.putExtra("troopGroupClassExt", this.b);
      startActivityForResult(paramView, 11);
      return;
    }
    GroupCatalogTool.a(this).a(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.b);
    setResult(-1, paramView);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */