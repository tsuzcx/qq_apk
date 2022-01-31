package com.tencent.mobileqq.activity;

import abju;
import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class PublicFragmentActivityForTool
  extends PublicFragmentActivity
{
  public static void b(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    abju.a(paramActivity, paramIntent, PublicFragmentActivityForTool.class, paramClass, paramInt);
  }
  
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