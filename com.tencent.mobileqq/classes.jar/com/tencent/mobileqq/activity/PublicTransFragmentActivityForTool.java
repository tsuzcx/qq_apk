package com.tencent.mobileqq.activity;

import android.content.Intent;

public class PublicTransFragmentActivityForTool
  extends PublicTransFragmentActivity
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool
 * JD-Core Version:    0.7.0.1
 */