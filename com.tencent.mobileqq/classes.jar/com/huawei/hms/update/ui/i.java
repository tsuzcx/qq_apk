package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
  extends a
{
  private void a(Intent paramIntent)
  {
    Object localObject = b().getPackageManager().queryIntentActivities(paramIntent, 65536);
    ArrayList localArrayList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localArrayList = new ArrayList();
      localArrayList.add("com.huawei.appmarket.tv");
      localArrayList.add("com.huawei.appmarket.car");
      localArrayList.add("com.huawei.appmarket");
      if (((List)localObject).size() != 1) {
        break label73;
      }
    }
    label73:
    ResolveInfo localResolveInfo;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = ((List)localObject).iterator();
      }
      localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
    } while (!localArrayList.contains(localResolveInfo.activityInfo.packageName));
    paramIntent.setPackage(localResolveInfo.activityInfo.packageName);
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
      if (SystemUtils.isTVDevice())
      {
        int i = new PackageManagerHelper(localActivity).getPackageVersionCode("com.hisilicon.android.hiRMService");
        HMSLog.i("HiappWizard", "version " + i);
        if (i == 1)
        {
          HMSLog.i("HiappWizard", "startActivity");
          localIntent.addFlags(268435456);
          a(localIntent);
          localActivity.startActivity(localIntent);
          return true;
        }
      }
      HMSLog.i("HiappWizard", "startActivityForResult");
      a(localIntent);
      localActivity.startActivityForResult(localIntent, getRequestCode());
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      HMSLog.e("HiappWizard", "can not open hiapp");
    }
    return false;
  }
  
  void a()
  {
    b(13, this.f);
  }
  
  public void a(b paramb)
  {
    HMSLog.i("HiappWizard", "Enter onCancel.");
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
      HMSLog.e("HiappWizard", "In showDialog, Failed to show the dialog." + paramClass.getMessage());
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
    HMSLog.i("HiappWizard", "Enter onDoWork.");
    if ((paramb instanceof j))
    {
      paramb.c();
      if (!d())
      {
        if (a(false)) {
          break label44;
        }
        b(8, this.f);
      }
    }
    return;
    label44:
    a(8, this.f);
  }
  
  public int getRequestCode()
  {
    return 2005;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {}
    do
    {
      return;
      this.f = 5;
      if ((this.c.isNeedConfirm()) && (!TextUtils.isEmpty(this.h)))
      {
        a(j.class);
        return;
      }
    } while (d());
    if (!a(false))
    {
      b(8, this.f);
      return;
    }
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
      } while (this.f != 5);
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
      HMSLog.i("HiappWizard", "In onKeyUp, Call finish.");
      paramKeyEvent = b();
    } while ((paramKeyEvent == null) || (paramKeyEvent.isFinishing()));
    paramKeyEvent.setResult(0, null);
    paramKeyEvent.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.i
 * JD-Core Version:    0.7.0.1
 */