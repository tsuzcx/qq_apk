package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.List;

final class MethodCallHandlerImpl
  implements MethodChannel.MethodCallHandler
{
  @Nullable
  private Activity a;
  @Nullable
  private PermissionManager.ActivityRegistry b;
  private final AppSettingsManager c;
  private final Context d;
  private final PermissionManager e;
  @Nullable
  private PermissionManager.PermissionRegistry f;
  private final ServiceManager g;
  
  MethodCallHandlerImpl(Context paramContext, AppSettingsManager paramAppSettingsManager, PermissionManager paramPermissionManager, ServiceManager paramServiceManager)
  {
    this.d = paramContext;
    this.c = paramAppSettingsManager;
    this.e = paramPermissionManager;
    this.g = paramServiceManager;
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a(@Nullable PermissionManager.ActivityRegistry paramActivityRegistry)
  {
    this.b = paramActivityRegistry;
  }
  
  public void a(@Nullable PermissionManager.PermissionRegistry paramPermissionRegistry)
  {
    this.f = paramPermissionRegistry;
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    Object localObject = paramMethodCall.method;
    switch (((String)localObject).hashCode())
    {
    default: 
      break;
    case 1669188213: 
      if (((String)localObject).equals("requestPermissions")) {
        i = 2;
      }
      break;
    case 347240634: 
      if (((String)localObject).equals("openAppSettings")) {
        i = 4;
      }
      break;
    case -576207927: 
      if (((String)localObject).equals("checkPermissionStatus")) {
        i = 1;
      }
      break;
    case -1017315255: 
      if (((String)localObject).equals("shouldShowRequestPermissionRationale")) {
        i = 3;
      }
      break;
    case -1544053025: 
      if (((String)localObject).equals("checkServiceStatus")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              paramResult.notImplemented();
              return;
            }
            paramMethodCall = this.c;
            localObject = this.d;
            paramResult.getClass();
            paramMethodCall.a((Context)localObject, new _..Lambda.TR2UE6xvkpeRG17hPoBKZeEIKug(paramResult), new _..Lambda.MethodCallHandlerImpl.lAKVN_rfsJIjtKSETVKc2ryD3Qk(paramResult));
            return;
          }
          i = Integer.parseInt(paramMethodCall.arguments.toString());
          paramMethodCall = this.e;
          localObject = this.a;
          paramResult.getClass();
          paramMethodCall.a(i, (Activity)localObject, new _..Lambda.WNQCVwak_kfCyfzR026kfI0_xwI(paramResult), new _..Lambda.MethodCallHandlerImpl.Eq_JFI2oYuoDin3ZEKekEyA_Kdc(paramResult));
          return;
        }
        paramMethodCall = (List)paramMethodCall.arguments();
        localObject = this.e;
        localActivity = this.a;
        PermissionManager.ActivityRegistry localActivityRegistry = this.b;
        PermissionManager.PermissionRegistry localPermissionRegistry = this.f;
        paramResult.getClass();
        ((PermissionManager)localObject).a(paramMethodCall, localActivity, localActivityRegistry, localPermissionRegistry, new _..Lambda.tkd1HTc7lzMA_RNRmpQPzCnzrNM(paramResult), new _..Lambda.MethodCallHandlerImpl.srvZpHfJnKwaDTQpc3Kbx_XJu_k(paramResult));
        return;
      }
      i = Integer.parseInt(paramMethodCall.arguments.toString());
      paramMethodCall = this.e;
      localObject = this.d;
      Activity localActivity = this.a;
      paramResult.getClass();
      paramMethodCall.a(i, (Context)localObject, localActivity, new _..Lambda.dmmm8DBenCjBo3Fgt2Az2dG7ZxI(paramResult), new _..Lambda.MethodCallHandlerImpl.M_fJsohuhGTxNaajHVl4rDteOE4(paramResult));
      return;
    }
    i = Integer.parseInt(paramMethodCall.arguments.toString());
    paramMethodCall = this.g;
    localObject = this.d;
    paramResult.getClass();
    paramMethodCall.a(i, (Context)localObject, new _..Lambda.kvb3eDz1QeqVBPF6VqNqPbsSWUA(paramResult), new _..Lambda.MethodCallHandlerImpl.nBDkVfzRvSfmmA4LbPddaEjgddw(paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.MethodCallHandlerImpl
 * JD-Core Version:    0.7.0.1
 */