package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

abstract class e$a
  extends b
{
  public AlertDialog a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(f(), g());
    localBuilder.setMessage(h());
    localBuilder.setPositiveButton(i(), new e.a.1(this));
    localBuilder.setNegativeButton(j(), new e.a.2(this));
    return localBuilder.create();
  }
  
  protected abstract int h();
  
  protected abstract int i();
  
  protected abstract int j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.e.a
 * JD-Core Version:    0.7.0.1
 */