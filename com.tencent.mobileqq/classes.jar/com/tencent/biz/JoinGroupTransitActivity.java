package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import kld;
import kle;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private JoinGroupHandler jdField_a_of_type_ComTencentBizJoinGroupHandler;
  private String jdField_a_of_type_JavaLangString;
  private kle jdField_a_of_type_Kle;
  private String b = "";
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        finish();
      }
      this.jdField_a_of_type_Kle = new kle(this);
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      this.b = localJumpAction.a("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localJumpAction.a("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localJumpAction.a("subsource_id")).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler = new JoinGroupHandler(this, this.app, this.jdField_a_of_type_Int, this.b, new kld(this));
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler.a();
    this.jdField_a_of_type_Kle.sendEmptyMessage(0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */