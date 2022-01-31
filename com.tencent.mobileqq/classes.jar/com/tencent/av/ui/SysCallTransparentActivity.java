package com.tencent.av.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import kcg;

public class SysCallTransparentActivity
  extends BaseActivity
{
  public int a;
  Handler a;
  public String a;
  public String b;
  public String c;
  
  public SysCallTransparentActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("pstn_guide_title");
    this.b = getIntent().getStringExtra("pstn_guide_content");
    this.c = getIntent().getStringExtra("pstn_guide_confirm");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("pstn_dialog_type", 3);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kcg(this), 300L);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.SysCallTransparentActivity
 * JD-Core Version:    0.7.0.1
 */