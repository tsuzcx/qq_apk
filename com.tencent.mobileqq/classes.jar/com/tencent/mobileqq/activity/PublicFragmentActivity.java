package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class PublicFragmentActivity
  extends FragmentActivity
{
  private PublicBaseFragment a;
  
  private PublicBaseFragment a()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    a(this, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PublicFragmentActivity", 2, new Object[] { "creating fragment ", localObject });
    }
    try
    {
      localObject = (PublicBaseFragment)Class.forName((String)localObject).newInstance();
      ((PublicBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.common.app.BaseApplicationImpl.sPublicFragmentEscapedMsg = Log.getStackTraceString(localException);
      QLog.e("PublicFragmentActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Class paramClass, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(Activity paramActivity, Class paramClass, int paramInt)
  {
    a(paramActivity, null, paramClass, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class paramClass)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivity.class, paramClass);
  }
  
  public static void a(Context paramContext, Class paramClass)
  {
    a(paramContext, null, paramClass);
  }
  
  private static void a(Context paramContext, String paramString) {}
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {
      try
      {
        Object localObject2 = Class.forName("android.support.v4.app.FragmentManagerState");
        paramBundle = Class.forName("android.support.v4.app.FragmentState");
        if (((Class)localObject2).isInstance(localObject1))
        {
          localObject2 = ((Class)localObject2).getDeclaredField("mActive");
          if (!((Field)localObject2).isAccessible()) {
            ((Field)localObject2).setAccessible(true);
          }
          if (((Field)localObject2).getType().isArray())
          {
            localObject1 = ((Field)localObject2).get(localObject1);
            int j = Array.getLength(localObject1);
            int i = 0;
            while (i < j)
            {
              localObject2 = Array.get(localObject1, i);
              if ((localObject2 != null) && (paramBundle.isInstance(localObject2)))
              {
                Field localField = paramBundle.getDeclaredField("mArguments");
                if (!localField.isAccessible()) {
                  localField.setAccessible(true);
                }
                localObject2 = localField.get(localObject2);
                if ((localObject2 != null) && ((localObject2 instanceof Bundle))) {
                  ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
                }
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("PublicFragmentActivity", 2, "Patch error");
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.a = a();
    if (this.a == null)
    {
      finish();
      return false;
    }
    this.mNeedStatusTrans = this.a.a();
    this.mActNeedImmersive = this.a.b();
    this.a.a(this);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicFragmentActivity", 1, "Activity restored, set classloader.");
      }
      a(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2130968611);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131362861, this.a);
    paramBundle.commit();
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.a.a(paramIntent);
  }
  
  public void finish()
  {
    super.finish();
    if (this.a != null) {
      this.a.u_();
    }
  }
  
  public String getCIOPageName()
  {
    if (this.a != null) {
      return this.a.getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public boolean isSupportScreenShot()
  {
    return (this.a == null) || (this.a.i());
  }
  
  protected boolean isWrapContent()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return super.isWrapContent();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.a != null) {
      this.a.m();
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.a == null) {
      return super.onBackEvent();
    }
    return this.a.d();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.a != null) {
      this.a.l();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    if (this.a != null) {
      this.a.k();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    if (paramIntent.hasExtra("public_fragment_window_feature")) {
      requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.a != null) {
      str1 = str2 + "#" + this.a.getClass().getName() + "@" + Integer.toHexString(this.a.hashCode());
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (getIntent() == null);
      str1 = str2;
    } while (getIntent().getStringExtra("public_fragment_class") == null);
    return str2 + "#" + getIntent().getStringExtra("public_fragment_class");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */