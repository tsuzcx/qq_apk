package com.tencent.mobileqq.activity;

import android.content.Intent;

public class PublicFragmentActivityForTool
  extends PublicFragmentActivity
{
  public String getModuleId()
  {
    String str2 = getIntent().getStringExtra("moduleId");
    String str1 = str2;
    if (str2 == null) {
      str1 = super.getModuleId();
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForTool
 * JD-Core Version:    0.7.0.1
 */