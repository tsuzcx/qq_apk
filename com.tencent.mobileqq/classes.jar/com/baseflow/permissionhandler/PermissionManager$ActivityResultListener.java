package com.baseflow.permissionhandler;

import android.content.Intent;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import java.util.HashMap;

@VisibleForTesting
final class PermissionManager$ActivityResultListener
  implements PluginRegistry.ActivityResultListener
{
  final PermissionManager.RequestPermissionsSuccessCallback jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$RequestPermissionsSuccessCallback;
  boolean jdField_a_of_type_Boolean = false;
  
  @VisibleForTesting
  PermissionManager$ActivityResultListener(PermissionManager.RequestPermissionsSuccessCallback paramRequestPermissionsSuccessCallback)
  {
    this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$RequestPermissionsSuccessCallback = paramRequestPermissionsSuccessCallback;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = 0;
    if (!bool)
    {
      if (paramInt1 != 5672353) {
        return false;
      }
      this.jdField_a_of_type_Boolean = true;
      paramInt1 = i;
      if (paramInt2 == -1) {
        paramInt1 = 1;
      }
      paramIntent = new HashMap();
      paramIntent.put(Integer.valueOf(16), Integer.valueOf(paramInt1));
      this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$RequestPermissionsSuccessCallback.a(paramIntent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.PermissionManager.ActivityResultListener
 * JD-Core Version:    0.7.0.1
 */