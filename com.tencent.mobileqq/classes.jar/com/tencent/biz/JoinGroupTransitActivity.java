package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bbeg;
import bbex;
import com.tencent.mobileqq.app.BaseActivity;
import mvv;
import mvz;
import mwa;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private mvv jdField_a_of_type_Mvv;
  private mwa jdField_a_of_type_Mwa;
  private String b = "";
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        finish();
      }
      this.jdField_a_of_type_Mwa = new mwa(this);
      bbeg localbbeg = bbex.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      this.b = localbbeg.b("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localbbeg.b("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localbbeg.b("subsource_id")).intValue();
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
    this.jdField_a_of_type_Mvv = new mvv(this, this.app, this.jdField_a_of_type_Int, this.b, new mvz(this));
    this.jdField_a_of_type_Mvv.a();
    this.jdField_a_of_type_Mwa.sendEmptyMessage(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Mvv.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */