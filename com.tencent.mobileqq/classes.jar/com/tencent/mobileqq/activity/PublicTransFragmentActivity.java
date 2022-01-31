package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class PublicTransFragmentActivity
  extends PublicFragmentActivity
{
  public static void b(Activity paramActivity, Intent paramIntent, Class paramClass, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void b(Context paramContext, Intent paramIntent, Class paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicTransFragmentActivity
 * JD-Core Version:    0.7.0.1
 */