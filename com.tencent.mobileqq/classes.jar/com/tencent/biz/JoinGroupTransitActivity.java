package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bbds;
import bbej;
import com.tencent.mobileqq.app.BaseActivity;
import mvy;
import mwc;
import mwd;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private mvy jdField_a_of_type_Mvy;
  private mwd jdField_a_of_type_Mwd;
  private String b = "";
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        finish();
      }
      this.jdField_a_of_type_Mwd = new mwd(this);
      bbds localbbds = bbej.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      this.b = localbbds.b("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localbbds.b("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localbbds.b("subsource_id")).intValue();
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
    this.jdField_a_of_type_Mvy = new mvy(this, this.app, this.jdField_a_of_type_Int, this.b, new mwc(this));
    this.jdField_a_of_type_Mvy.a();
    this.jdField_a_of_type_Mwd.sendEmptyMessage(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Mvy.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */