package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class PublicFragmentActivity$Launcher
{
  public static void a(Activity paramActivity, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, paramClass1);
    localIntent.putExtra("public_fragment_class", paramClass2.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, paramClass1);
    localIntent.putExtra("public_fragment_class", paramClass2.getName());
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher
 * JD-Core Version:    0.7.0.1
 */