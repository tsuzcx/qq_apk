package androidx.core.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.AppOpsManagerCompat;

public final class PermissionChecker
{
  public static final int PERMISSION_DENIED = -1;
  public static final int PERMISSION_DENIED_APP_OP = -2;
  public static final int PERMISSION_GRANTED = 0;
  
  public static int checkCallingOrSelfPermission(@NonNull Context paramContext, @NonNull String paramString)
  {
    String str;
    if (Binder.getCallingPid() == Process.myPid()) {
      str = paramContext.getPackageName();
    } else {
      str = null;
    }
    return checkPermission(paramContext, paramString, Binder.getCallingPid(), Binder.getCallingUid(), str);
  }
  
  public static int checkCallingPermission(@NonNull Context paramContext, @NonNull String paramString1, @Nullable String paramString2)
  {
    if (Binder.getCallingPid() == Process.myPid()) {
      return -1;
    }
    return checkPermission(paramContext, paramString1, Binder.getCallingPid(), Binder.getCallingUid(), paramString2);
  }
  
  public static int checkPermission(@NonNull Context paramContext, @NonNull String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2)
  {
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1) {
      return -1;
    }
    String str = AppOpsManagerCompat.permissionToOp(paramString1);
    if (str == null) {
      return 0;
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
      if (paramString1 != null)
      {
        if (paramString1.length <= 0) {
          return -1;
        }
        paramString1 = paramString1[0];
      }
      else
      {
        return -1;
      }
    }
    if (AppOpsManagerCompat.noteProxyOpNoThrow(paramContext, str, paramString1) != 0) {
      return -2;
    }
    return 0;
  }
  
  public static int checkSelfPermission(@NonNull Context paramContext, @NonNull String paramString)
  {
    return checkPermission(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.PermissionChecker
 * JD-Core Version:    0.7.0.1
 */