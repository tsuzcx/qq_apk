package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class j
  extends b
{
  private String a = ResourceLoaderUtil.getString("hms_update_title");
  
  protected AlertDialog a()
  {
    int i = ResourceLoaderUtil.getStringId("hms_update_message_new");
    int j = ResourceLoaderUtil.getStringId("hms_install");
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(f(), g());
    localBuilder.setMessage(f().getString(i, new Object[] { this.a }));
    localBuilder.setPositiveButton(j, new j.1(this));
    localBuilder.setNegativeButton(ResourceLoaderUtil.getStringId("hms_cancel"), new j.2(this));
    return localBuilder.create();
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.j
 * JD-Core Version:    0.7.0.1
 */