package com.dataline.core;

import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

final class DirectForwarder$2
  implements FMDialogUtil.FMDialogInterface
{
  DirectForwarder$2(AsyncTask paramAsyncTask, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void a()
  {
    this.a.execute(new Integer[] { Integer.valueOf(this.b) });
    FMDialogUtil.FMDialogInterface localFMDialogInterface = this.c;
    if (localFMDialogInterface != null) {
      localFMDialogInterface.a();
    }
  }
  
  public void b()
  {
    FMDialogUtil.FMDialogInterface localFMDialogInterface = this.c;
    if (localFMDialogInterface != null) {
      localFMDialogInterface.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.core.DirectForwarder.2
 * JD-Core Version:    0.7.0.1
 */