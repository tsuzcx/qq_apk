package com.baseflow.permissionhandler;

import android.content.Intent;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import java.util.HashMap;

@VisibleForTesting
final class PermissionManager$ActivityResultListener
  implements PluginRegistry.ActivityResultListener
{
  boolean a = false;
  final PermissionManager.RequestPermissionsSuccessCallback b;
  
  @VisibleForTesting
  PermissionManager$ActivityResultListener(PermissionManager.RequestPermissionsSuccessCallback paramRequestPermissionsSuccessCallback)
  {
    this.b = paramRequestPermissionsSuccessCallback;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = this.a;
    int i = 0;
    if (!bool)
    {
      if (paramInt1 != 5672353) {
        return false;
      }
      this.a = true;
      paramInt1 = i;
      if (paramInt2 == -1) {
        paramInt1 = 1;
      }
      paramIntent = new HashMap();
      paramIntent.put(Integer.valueOf(16), Integer.valueOf(paramInt1));
      this.b.a(paramIntent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.PermissionManager.ActivityResultListener
 * JD-Core Version:    0.7.0.1
 */