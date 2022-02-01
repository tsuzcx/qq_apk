package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.QFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class QPublicFragmentActivity$Launcher
{
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends QPublicFragmentActivity> paramClass, Class<? extends QPublicBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends QPublicFragmentActivity> paramClass, Class<? extends QPublicBaseFragment> paramClass1)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Intent paramIntent, Class<? extends QPublicFragmentActivity> paramClass, Class<? extends QPublicBaseFragment> paramClass1)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(BaseApplication.context, paramClass);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    BaseApplication.context.startActivity(localIntent);
  }
  
  public static void a(QFragment paramQFragment, Intent paramIntent, Class<? extends QPublicFragmentActivity> paramClass, Class<? extends QPublicBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramQFragment.getActivity(), paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramQFragment.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher
 * JD-Core Version:    0.7.0.1
 */