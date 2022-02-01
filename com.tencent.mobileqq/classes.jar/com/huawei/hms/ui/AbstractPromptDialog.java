package com.huawei.hms.ui;

import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

public abstract class AbstractPromptDialog
  extends AbstractDialog
{
  protected String onGetNegativeButtonString(Context paramContext)
  {
    return null;
  }
  
  protected String onGetTitleString(Context paramContext)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramContext);
    }
    return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractPromptDialog
 * JD-Core Version:    0.7.0.1
 */