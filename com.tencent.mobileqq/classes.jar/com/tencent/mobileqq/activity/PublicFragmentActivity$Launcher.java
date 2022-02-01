package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class PublicFragmentActivity$Launcher
{
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
  {
    a(paramContext, null, paramClass, paramClass1);
  }
  
  public static void a(Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(BaseApplicationImpl.getApplication(), paramClass);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    BaseApplicationImpl.getApplication().startActivity(localIntent);
  }
  
  public static void a(BaseFragment paramBaseFragment, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramBaseFragment.getBaseActivity(), paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramBaseFragment.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher
 * JD-Core Version:    0.7.0.1
 */