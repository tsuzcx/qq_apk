package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class ResolutionDelegate
  implements IBridgeActivityDelegate
{
  public static final String CALLBACK_METHOD = "CALLBACK_METHOD";
  private WeakReference<Activity> a;
  
  private BusResponseCallback a(String paramString)
  {
    return ForegroundBusResponseMgr.getInstance().get(paramString);
  }
  
  private void a()
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      localActivity.finish();
    }
  }
  
  private Activity b()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  public int getRequestCode()
  {
    return 1002;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
    Bundle localBundle = paramActivity.getIntent().getExtras();
    if (localBundle != null) {
      paramActivity.startActivityForResult((Intent)localBundle.getParcelable("resolution"), 1002);
    }
  }
  
  public void onBridgeActivityDestroy()
  {
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != getRequestCode()) {
      return false;
    }
    paramIntent = a("CALLBACK_METHOD");
    Activity localActivity = (Activity)this.a.get();
    paramInt1 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(localActivity, 30000000);
    if ((paramInt2 == -1) && (paramInt1 == 0)) {
      HMSLog.i("ResolutionDelegate", "Make service available success.");
    } else {
      paramIntent.innerError((Activity)this.a.get(), paramInt2, "Make service available failed.");
    }
    a();
    return true;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.ResolutionDelegate
 * JD-Core Version:    0.7.0.1
 */