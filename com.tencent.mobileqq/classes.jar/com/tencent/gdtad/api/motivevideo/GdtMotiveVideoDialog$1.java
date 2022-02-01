package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

class GdtMotiveVideoDialog$1
  implements IMotiveVideoView
{
  GdtMotiveVideoDialog$1(GdtMotiveVideoDialog paramGdtMotiveVideoDialog) {}
  
  public Activity a()
  {
    return GdtMotiveVideoDialog.a(this.a);
  }
  
  public void a()
  {
    this.a.dismiss();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (GdtMotiveVideoDialog.a(this.a) == null)
    {
      QLog.i("GdtMotiveVideoDialog", 1, "mResultReceiver == null");
      return;
    }
    GdtMotiveVideoDialog.a(this.a).send(paramInt, paramIntent.getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoDialog.1
 * JD-Core Version:    0.7.0.1
 */