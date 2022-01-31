package com.tencent.mobileqq.activity;

import acgl;
import acgm;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import bata;
import batb;
import bcyb;
import bdki;
import bfpt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements bfpt
{
  private acgm jdField_a_of_type_Acgm;
  public bata a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<bata> a;
  private String b;
  
  private void b()
  {
    Object localObject = getIntent();
    this.b = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    bata localbata = batb.a(this).a();
    if ((localbata != null) && (this.b.equals(localbata.b)))
    {
      this.jdField_a_of_type_Bata = localbata;
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("id");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label113;
      }
      this.jdField_a_of_type_JavaUtilArrayList = batb.a(this).a();
    }
    for (;;)
    {
      bdki.a(bcyb.a().a());
      a();
      return;
      this.jdField_a_of_type_Bata = batb.a(this).a(this, this.b);
      break;
      label113:
      this.jdField_a_of_type_JavaUtilArrayList = batb.a(this).a(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = (bata)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (((bata)localObject).jdField_a_of_type_Bata != null) {
          setTitle(((bata)localObject).jdField_a_of_type_Bata.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void c()
  {
    setContentBackgroundResource(2130838514);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377699));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Acgm = new acgm(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acgm);
  }
  
  public void a()
  {
    batb.a(BaseApplicationImpl.getContext()).a(this.b, new acgl(this));
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
    super.setContentView(2131562530);
    setTitle(2131720438);
    b();
    c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bata)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((paramAdapterView.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdapterView.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!paramAdapterView.b.equals("10015")) && (!paramAdapterView.b.equals("10017")))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.b);
      paramView.putExtra("troopGroupClassExt", this.b);
      startActivityForResult(paramView, 11);
      return;
    }
    batb.a(this).a(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.b);
    setResult(-1, paramView);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */