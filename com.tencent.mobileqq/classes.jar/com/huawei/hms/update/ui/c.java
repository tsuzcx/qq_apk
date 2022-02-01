package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Iterator;
import java.util.List;

public class c
  extends a
{
  private void a(Intent paramIntent)
  {
    Object localObject = new Intent("com.apptouch.intent.action.update_hms");
    localObject = b().getPackageManager().queryIntentServices((Intent)localObject, 0);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = ((ResolveInfo)localIterator.next()).serviceInfo;
        } while (localObject == null);
        localObject = ((ServiceInfo)localObject).packageName;
      } while (TextUtils.isEmpty((CharSequence)localObject));
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramIntent.setPackage((String)localObject);
      }
      return;
      localObject = null;
    }
  }
  
  private boolean d()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    while (TextUtils.isEmpty(this.g)) {
      return false;
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.huawei.appmarket.intent.action.AppDetail");
      localIntent.putExtra("APP_PACKAGENAME", this.g);
      a(localIntent);
      localActivity.startActivityForResult(localIntent, getRequestCode());
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      HMSLog.e("AppTouchWizard", "can not open AppTouch detail page");
    }
    return false;
  }
  
  void a()
  {
    b(13, this.f);
  }
  
  public void a(b paramb)
  {
    HMSLog.i("AppTouchWizard", "Enter onCancel.");
    if ((paramb instanceof j)) {
      a();
    }
  }
  
  void a(Class<? extends b> paramClass)
  {
    c();
    try
    {
      paramClass = (b)paramClass.newInstance();
      if ((!TextUtils.isEmpty(this.h)) && ((paramClass instanceof j)))
      {
        this.h = ResourceLoaderUtil.getString("hms_update_title");
        ((j)paramClass).a(this.h);
      }
      paramClass.a(this);
      this.d = paramClass;
      return;
    }
    catch (InstantiationException paramClass)
    {
      HMSLog.e("AppTouchWizard", "In showDialog, Failed to show the dialog." + paramClass.getMessage());
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      break label61;
    }
    catch (IllegalStateException paramClass)
    {
      label61:
      break label61;
    }
  }
  
  public void b(b paramb)
  {
    HMSLog.i("AppTouchWizard", "Enter onDoWork.");
    if ((paramb instanceof j))
    {
      paramb.c();
      if (!d()) {
        a(8, this.f);
      }
    }
  }
  
  public int getRequestCode()
  {
    return 2007;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {}
    do
    {
      return;
      this.f = 7;
      if ((this.c.isNeedConfirm()) && (!TextUtils.isEmpty(this.h)))
      {
        a(j.class);
        return;
      }
    } while (d());
    a(8, this.f);
  }
  
  public void onBridgeActivityDestroy()
  {
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.e) && (this.b != null)) {
      bool1 = this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.f != 7);
      bool1 = bool2;
    } while (paramInt1 != getRequestCode());
    if (a(this.g, this.i)) {
      b(0, this.f);
    }
    for (;;)
    {
      return true;
      b(8, this.f);
    }
  }
  
  public void onBridgeConfigurationChanged()
  {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.e) && (this.b != null)) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
    }
    do
    {
      do
      {
        return;
      } while (4 != paramInt);
      HMSLog.i("AppTouchWizard", "In onKeyUp, Call finish.");
      paramKeyEvent = b();
    } while ((paramKeyEvent == null) || (paramKeyEvent.isFinishing()));
    paramKeyEvent.setResult(0, null);
    paramKeyEvent.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.c
 * JD-Core Version:    0.7.0.1
 */