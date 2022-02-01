package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class PermissionManager
{
  private boolean a = false;
  
  private int a(int paramInt, Context paramContext, @Nullable Activity paramActivity)
  {
    if (paramInt == 17) {
      return a(paramContext);
    }
    Object localObject = PermissionUtils.a(paramContext, paramInt);
    if (localObject == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("No android specific permissions needed for: ");
      paramContext.append(paramInt);
      Log.d("permissions_handler", paramContext.toString());
      return 1;
    }
    if (((List)localObject).size() == 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("No permissions found in manifest for: ");
      paramContext.append(paramInt);
      Log.d("permissions_handler", paramContext.toString());
      return 3;
    }
    int i;
    if (paramContext.getApplicationInfo().targetSdkVersion >= 23) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i != 0)
      {
        if (paramInt == 16)
        {
          paramActivity = paramContext.getPackageName();
          paramContext = (PowerManager)paramContext.getSystemService("power");
          if (Build.VERSION.SDK_INT >= 23)
          {
            if ((paramContext != null) && (paramContext.isIgnoringBatteryOptimizations(paramActivity))) {
              return 1;
            }
            return 0;
          }
          return 2;
        }
        int j = ContextCompat.checkSelfPermission(paramContext, str);
        if (j == -1)
        {
          if (!PermissionUtils.a(paramContext, str)) {
            return 3;
          }
          if ((Build.VERSION.SDK_INT >= 23) && (PermissionUtils.a(paramActivity, str))) {
            return 5;
          }
          return 0;
        }
        if (j != 0) {
          return 0;
        }
      }
    }
    return 1;
  }
  
  private int a(Context paramContext)
  {
    if (NotificationManagerCompat.from(paramContext).areNotificationsEnabled()) {
      return 1;
    }
    return 0;
  }
  
  void a(int paramInt, Activity paramActivity, PermissionManager.ShouldShowRequestPermissionRationaleSuccessCallback paramShouldShowRequestPermissionRationaleSuccessCallback, ErrorCallback paramErrorCallback)
  {
    if (paramActivity == null)
    {
      Log.d("permissions_handler", "Unable to detect current Activity.");
      paramErrorCallback.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
      return;
    }
    paramErrorCallback = PermissionUtils.a(paramActivity, paramInt);
    if (paramErrorCallback == null)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("No android specific permissions needed for: ");
      paramActivity.append(paramInt);
      Log.d("permissions_handler", paramActivity.toString());
      paramShouldShowRequestPermissionRationaleSuccessCallback.a(false);
      return;
    }
    if (paramErrorCallback.isEmpty())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("No permissions found in manifest for: ");
      paramActivity.append(paramInt);
      paramActivity.append(" no need to show request rationale");
      Log.d("permissions_handler", paramActivity.toString());
      paramShouldShowRequestPermissionRationaleSuccessCallback.a(false);
      return;
    }
    paramShouldShowRequestPermissionRationaleSuccessCallback.a(ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, (String)paramErrorCallback.get(0)));
  }
  
  void a(int paramInt, Context paramContext, Activity paramActivity, PermissionManager.CheckPermissionsSuccessCallback paramCheckPermissionsSuccessCallback, ErrorCallback paramErrorCallback)
  {
    paramCheckPermissionsSuccessCallback.a(a(paramInt, paramContext, paramActivity));
  }
  
  void a(List<Integer> paramList, Activity paramActivity, PermissionManager.ActivityRegistry paramActivityRegistry, PermissionManager.PermissionRegistry paramPermissionRegistry, PermissionManager.RequestPermissionsSuccessCallback paramRequestPermissionsSuccessCallback, ErrorCallback paramErrorCallback)
  {
    if (this.a) {}
    for (paramList = "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).";; paramList = "Unable to detect current Android Activity.")
    {
      paramErrorCallback.a("PermissionHandler.PermissionManager", paramList);
      return;
      if (paramActivity != null) {
        break;
      }
      Log.d("permissions_handler", "Unable to detect current Activity.");
    }
    paramErrorCallback = new HashMap();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i;
    Object localObject1;
    do
    {
      boolean bool = paramList.hasNext();
      i = 1;
      if (!bool) {
        break label300;
      }
      localObject1 = (Integer)paramList.next();
      if (a(((Integer)localObject1).intValue(), paramActivity, paramActivity) != 1) {
        break;
      }
    } while (paramErrorCallback.containsKey(localObject1));
    for (;;)
    {
      paramErrorCallback.put(localObject1, Integer.valueOf(i));
      break;
      Object localObject2 = PermissionUtils.a(paramActivity, ((Integer)localObject1).intValue());
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        if ((Build.VERSION.SDK_INT >= 23) && (((Integer)localObject1).intValue() == 16))
        {
          paramActivityRegistry.a(new PermissionManager.ActivityResultListener(paramRequestPermissionsSuccessCallback));
          localObject1 = paramActivity.getPackageName();
          localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("package:");
          localStringBuilder.append((String)localObject1);
          ((Intent)localObject2).setData(Uri.parse(localStringBuilder.toString()));
          paramActivity.startActivityForResult((Intent)localObject2, 5672353);
          break;
        }
        localArrayList.addAll((Collection)localObject2);
        break;
      }
      if (paramErrorCallback.containsKey(localObject1)) {
        break;
      }
      i = 3;
    }
    label300:
    paramList = (String[])localArrayList.toArray(new String[0]);
    if (localArrayList.size() > 0)
    {
      paramPermissionRegistry.a(new PermissionManager.RequestPermissionsListener(paramActivity, paramErrorCallback, new _..Lambda.PermissionManager.C1Lc2eGN38XZcT6FjxSuqfMM4XU(this, paramRequestPermissionsSuccessCallback)));
      this.a = true;
      ActivityCompat.requestPermissions(paramActivity, paramList, 24);
      return;
    }
    this.a = false;
    if (paramErrorCallback.size() > 0) {
      paramRequestPermissionsSuccessCallback.a(paramErrorCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.PermissionManager
 * JD-Core Version:    0.7.0.1
 */