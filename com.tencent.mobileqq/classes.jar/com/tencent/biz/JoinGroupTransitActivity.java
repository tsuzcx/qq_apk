package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bacn;
import bade;
import com.tencent.mobileqq.app.BaseActivity;
import mkz;
import mld;
import mle;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private mkz jdField_a_of_type_Mkz;
  private mle jdField_a_of_type_Mle;
  private String b = "";
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        finish();
      }
      this.jdField_a_of_type_Mle = new mle(this);
      bacn localbacn = bade.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      this.b = localbacn.b("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localbacn.b("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localbacn.b("subsource_id")).intValue();
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
    this.jdField_a_of_type_Mkz = new mkz(this, this.app, this.jdField_a_of_type_Int, this.b, new mld(this));
    this.jdField_a_of_type_Mkz.a();
    this.jdField_a_of_type_Mle.sendEmptyMessage(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Mkz.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */