package com.tencent.mobileqq.activity;

import adxv;
import adxw;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import bcru;
import bcrv;
import bexd;
import bfjf;
import bhqp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements bhqp
{
  private adxw jdField_a_of_type_Adxw;
  public bcru a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<bcru> a;
  private String b;
  
  private void b()
  {
    Object localObject = getIntent();
    this.b = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    bcru localbcru = bcrv.a(this).a();
    if ((localbcru != null) && (this.b.equals(localbcru.b)))
    {
      this.jdField_a_of_type_Bcru = localbcru;
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("id");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label113;
      }
      this.jdField_a_of_type_JavaUtilArrayList = bcrv.a(this).a();
    }
    for (;;)
    {
      bfjf.a(bexd.a().a());
      a();
      return;
      this.jdField_a_of_type_Bcru = bcrv.a(this).a(this, this.b);
      break;
      label113:
      this.jdField_a_of_type_JavaUtilArrayList = bcrv.a(this).a(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = (bcru)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (((bcru)localObject).jdField_a_of_type_Bcru != null) {
          setTitle(((bcru)localObject).jdField_a_of_type_Bcru.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void c()
  {
    setContentBackgroundResource(2130838591);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131378240));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Adxw = new adxw(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Adxw);
  }
  
  public void a()
  {
    bcrv.a(BaseApplicationImpl.getContext()).a(this.b, new adxv(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131562733);
    setTitle(2131720976);
    b();
    c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bcru)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((paramAdapterView.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdapterView.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!paramAdapterView.b.equals("10015")) && (!paramAdapterView.b.equals("10017")))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.b);
      paramView.putExtra("troopGroupClassExt", this.b);
      startActivityForResult(paramView, 11);
      return;
    }
    bcrv.a(this).a(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.b);
    setResult(-1, paramView);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */