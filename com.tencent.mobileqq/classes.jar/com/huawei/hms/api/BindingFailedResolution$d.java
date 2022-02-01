package com.huawei.hms.api;

import android.content.Context;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

class BindingFailedResolution$d
  extends AbstractPromptDialog
{
  protected String onGetMessageString(Context paramContext)
  {
    return ResourceLoaderUtil.getString("hms_bindfaildlg_message", new Object[] { Util.getAppName(paramContext, null), Util.getAppName(paramContext, HMSPackageManager.getInstance(paramContext).getHMSPackageName()) });
  }
  
  protected String onGetPositiveButtonString(Context paramContext)
  {
    return ResourceLoaderUtil.getString("hms_confirm");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution.d
 * JD-Core Version:    0.7.0.1
 */