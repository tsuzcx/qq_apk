package com.baseflow.permissionhandler;

import android.app.Activity;
import android.os.Build.VERSION;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import java.util.Map;

@VisibleForTesting
final class PermissionManager$RequestPermissionsListener
  implements PluginRegistry.RequestPermissionsResultListener
{
  final Activity a;
  boolean b = false;
  final PermissionManager.RequestPermissionsSuccessCallback c;
  final Map<Integer, Integer> d;
  
  @VisibleForTesting
  PermissionManager$RequestPermissionsListener(Activity paramActivity, Map<Integer, Integer> paramMap, PermissionManager.RequestPermissionsSuccessCallback paramRequestPermissionsSuccessCallback)
  {
    this.a = paramActivity;
    this.c = paramRequestPermissionsSuccessCallback;
    this.d = paramMap;
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = this.b;
    int i = 0;
    if (!bool)
    {
      if (paramInt != 24) {
        return false;
      }
      this.b = true;
      paramInt = i;
      while (paramInt < paramArrayOfString.length)
      {
        String str = paramArrayOfString[paramInt];
        int j = PermissionUtils.a(str);
        if (j != 20)
        {
          i = paramArrayOfInt[paramInt];
          Map localMap;
          if (j == 7)
          {
            if (!this.d.containsKey(Integer.valueOf(7))) {
              this.d.put(Integer.valueOf(7), Integer.valueOf(PermissionUtils.a(this.a, str, i)));
            }
            if (!this.d.containsKey(Integer.valueOf(14))) {
              localMap = this.d;
            }
          }
          else
          {
            for (Integer localInteger = Integer.valueOf(14);; localInteger = Integer.valueOf(j))
            {
              localMap.put(localInteger, Integer.valueOf(PermissionUtils.a(this.a, str, i)));
              break;
              if (j == 4)
              {
                i = PermissionUtils.a(this.a, str, i);
                if (this.d.containsKey(Integer.valueOf(4))) {
                  break;
                }
                localMap = this.d;
              }
              for (localInteger = Integer.valueOf(4);; localInteger = Integer.valueOf(j))
              {
                localMap.put(localInteger, Integer.valueOf(i));
                break label384;
                if (j != 3) {
                  break;
                }
                i = PermissionUtils.a(this.a, str, i);
                if ((Build.VERSION.SDK_INT < 29) && (!this.d.containsKey(Integer.valueOf(4)))) {
                  this.d.put(Integer.valueOf(4), Integer.valueOf(i));
                }
                if (!this.d.containsKey(Integer.valueOf(5))) {
                  this.d.put(Integer.valueOf(5), Integer.valueOf(i));
                }
                localMap = this.d;
              }
              if (this.d.containsKey(Integer.valueOf(j))) {
                break;
              }
              localMap = this.d;
            }
          }
          label384:
          PermissionUtils.a(this.a, j);
        }
        paramInt += 1;
      }
      this.c.a(this.d);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.PermissionManager.RequestPermissionsListener
 * JD-Core Version:    0.7.0.1
 */