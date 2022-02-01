package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.HashMap;
import java.util.Map;

public class ConnectionErrorMessages
{
  private static final Map<String, String> map = new HashMap();
  
  public static String getErrorDialogButtonMessage(Activity paramActivity, int paramInt)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return ResourceLoaderUtil.getString("hms_confirm");
      }
      return ResourceLoaderUtil.getString("hms_update");
    }
    return ResourceLoaderUtil.getString("hms_install");
  }
  
  public static String getErrorMessage(Activity paramActivity, int paramInt)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    String str = ResourceLoaderUtil.getString("hms_update_title");
    paramActivity = str;
    if (paramInt != 1)
    {
      paramActivity = str;
      if (paramInt != 2) {
        paramActivity = null;
      }
    }
    return paramActivity;
  }
  
  public static String getErrorTitle(Activity paramActivity, int paramInt)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 9)
          {
            paramActivity = new StringBuilder();
            paramActivity.append("Unexpected error code ");
            paramActivity.append(paramInt);
            HMSLog.e("HuaweiApiAvailability", paramActivity.toString());
            return null;
          }
          HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
          return null;
        }
        return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
      }
      return ResourceLoaderUtil.getString("hms_update_message");
    }
    return ResourceLoaderUtil.getString("hms_install_message");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.ConnectionErrorMessages
 * JD-Core Version:    0.7.0.1
 */