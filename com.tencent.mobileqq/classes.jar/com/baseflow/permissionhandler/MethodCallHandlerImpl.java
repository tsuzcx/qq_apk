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
  private Activity jdField_a_of_type_AndroidAppActivity;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final AppSettingsManager jdField_a_of_type_ComBaseflowPermissionhandlerAppSettingsManager;
  @Nullable
  private PermissionManager.ActivityRegistry jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$ActivityRegistry;
  @Nullable
  private PermissionManager.PermissionRegistry jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$PermissionRegistry;
  private final PermissionManager jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager;
  private final ServiceManager jdField_a_of_type_ComBaseflowPermissionhandlerServiceManager;
  
  MethodCallHandlerImpl(Context paramContext, AppSettingsManager paramAppSettingsManager, PermissionManager paramPermissionManager, ServiceManager paramServiceManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComBaseflowPermissionhandlerAppSettingsManager = paramAppSettingsManager;
    this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager = paramPermissionManager;
    this.jdField_a_of_type_ComBaseflowPermissionhandlerServiceManager = paramServiceManager;
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(@Nullable PermissionManager.ActivityRegistry paramActivityRegistry)
  {
    this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$ActivityRegistry = paramActivityRegistry;
  }
  
  public void a(@Nullable PermissionManager.PermissionRegistry paramPermissionRegistry)
  {
    this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$PermissionRegistry = paramPermissionRegistry;
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
            paramMethodCall = this.jdField_a_of_type_ComBaseflowPermissionhandlerAppSettingsManager;
            localObject = this.jdField_a_of_type_AndroidContentContext;
            paramResult.getClass();
            paramMethodCall.a((Context)localObject, new _..Lambda.TR2UE6xvkpeRG17hPoBKZeEIKug(paramResult), new _..Lambda.MethodCallHandlerImpl.Eq_JFI2oYuoDin3ZEKekEyA_Kdc(paramResult));
            return;
          }
          i = Integer.parseInt(paramMethodCall.arguments.toString());
          paramMethodCall = this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager;
          localObject = this.jdField_a_of_type_AndroidAppActivity;
          paramResult.getClass();
          paramMethodCall.a(i, (Activity)localObject, new _..Lambda.WNQCVwak_kfCyfzR026kfI0_xwI(paramResult), new _..Lambda.MethodCallHandlerImpl.srvZpHfJnKwaDTQpc3Kbx_XJu_k(paramResult));
          return;
        }
        paramMethodCall = (List)paramMethodCall.arguments();
        localObject = this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager;
        localActivity = this.jdField_a_of_type_AndroidAppActivity;
        PermissionManager.ActivityRegistry localActivityRegistry = this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$ActivityRegistry;
        PermissionManager.PermissionRegistry localPermissionRegistry = this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$PermissionRegistry;
        paramResult.getClass();
        ((PermissionManager)localObject).a(paramMethodCall, localActivity, localActivityRegistry, localPermissionRegistry, new _..Lambda.tkd1HTc7lzMA_RNRmpQPzCnzrNM(paramResult), new _..Lambda.MethodCallHandlerImpl.M_fJsohuhGTxNaajHVl4rDteOE4(paramResult));
        return;
      }
      i = Integer.parseInt(paramMethodCall.arguments.toString());
      paramMethodCall = this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager;
      localObject = this.jdField_a_of_type_AndroidContentContext;
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      paramResult.getClass();
      paramMethodCall.a(i, (Context)localObject, localActivity, new _..Lambda.dmmm8DBenCjBo3Fgt2Az2dG7ZxI(paramResult), new _..Lambda.MethodCallHandlerImpl.nBDkVfzRvSfmmA4LbPddaEjgddw(paramResult));
      return;
    }
    i = Integer.parseInt(paramMethodCall.arguments.toString());
    paramMethodCall = this.jdField_a_of_type_ComBaseflowPermissionhandlerServiceManager;
    localObject = this.jdField_a_of_type_AndroidContentContext;
    paramResult.getClass();
    paramMethodCall.a(i, (Context)localObject, new _..Lambda.kvb3eDz1QeqVBPF6VqNqPbsSWUA(paramResult), new _..Lambda.MethodCallHandlerImpl.jGtwiG_3jQ2lAp2Gyt9WGWiMz80(paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.MethodCallHandlerImpl
 * JD-Core Version:    0.7.0.1
 */