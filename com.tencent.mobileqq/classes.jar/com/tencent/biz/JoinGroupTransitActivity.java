package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bddb;
import bdds;
import com.tencent.mobileqq.app.BaseActivity;
import myo;
import mys;
import myt;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private myo jdField_a_of_type_Myo;
  private myt jdField_a_of_type_Myt;
  private String b = "";
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        finish();
      }
      this.jdField_a_of_type_Myt = new myt(this);
      bddb localbddb = bdds.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      this.b = localbddb.b("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localbddb.b("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localbddb.b("subsource_id")).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    this.jdField_a_of_type_Myo = new myo(this, this.app, this.jdField_a_of_type_Int, this.b, new mys(this));
    this.jdField_a_of_type_Myo.a();
    this.jdField_a_of_type_Myt.sendEmptyMessage(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Myo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */