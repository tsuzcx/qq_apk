package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.hms.utils.ResourceLoaderUtil;

abstract class k$a
  extends b
{
  public AlertDialog a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(f(), g());
    localBuilder.setMessage(h());
    localBuilder.setPositiveButton(i(), new k.a.1(this));
    return localBuilder.create();
  }
  
  protected abstract int h();
  
  protected int i()
  {
    return ResourceLoaderUtil.getStringId("hms_confirm");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.k.a
 * JD-Core Version:    0.7.0.1
 */