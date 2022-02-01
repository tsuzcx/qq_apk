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
  final Activity jdField_a_of_type_AndroidAppActivity;
  final PermissionManager.RequestPermissionsSuccessCallback jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$RequestPermissionsSuccessCallback;
  final Map<Integer, Integer> jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  
  @VisibleForTesting
  PermissionManager$RequestPermissionsListener(Activity paramActivity, Map<Integer, Integer> paramMap, PermissionManager.RequestPermissionsSuccessCallback paramRequestPermissionsSuccessCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$RequestPermissionsSuccessCallback = paramRequestPermissionsSuccessCallback;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = 0;
    if (!bool)
    {
      if (paramInt != 24) {
        return false;
      }
      this.jdField_a_of_type_Boolean = true;
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
            if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(7))) {
              this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), Integer.valueOf(PermissionUtils.a(this.jdField_a_of_type_AndroidAppActivity, str, i)));
            }
            if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(14))) {
              localMap = this.jdField_a_of_type_JavaUtilMap;
            }
          }
          else
          {
            for (Integer localInteger = Integer.valueOf(14);; localInteger = Integer.valueOf(j))
            {
              localMap.put(localInteger, Integer.valueOf(PermissionUtils.a(this.jdField_a_of_type_AndroidAppActivity, str, i)));
              break;
              if (j == 4)
              {
                i = PermissionUtils.a(this.jdField_a_of_type_AndroidAppActivity, str, i);
                if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(4))) {
                  break;
                }
                localMap = this.jdField_a_of_type_JavaUtilMap;
              }
              for (localInteger = Integer.valueOf(4);; localInteger = Integer.valueOf(j))
              {
                localMap.put(localInteger, Integer.valueOf(i));
                break label384;
                if (j != 3) {
                  break;
                }
                i = PermissionUtils.a(this.jdField_a_of_type_AndroidAppActivity, str, i);
                if ((Build.VERSION.SDK_INT < 29) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(4)))) {
                  this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Integer.valueOf(i));
                }
                if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(5))) {
                  this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Integer.valueOf(i));
                }
                localMap = this.jdField_a_of_type_JavaUtilMap;
              }
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(j))) {
                break;
              }
              localMap = this.jdField_a_of_type_JavaUtilMap;
            }
          }
          label384:
          PermissionUtils.a(this.jdField_a_of_type_AndroidAppActivity, j);
        }
        paramInt += 1;
      }
      this.jdField_a_of_type_ComBaseflowPermissionhandlerPermissionManager$RequestPermissionsSuccessCallback.a(this.jdField_a_of_type_JavaUtilMap);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.PermissionManager.RequestPermissionsListener
 * JD-Core Version:    0.7.0.1
 */