package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

class GdtMotiveVideoDialog$2
  implements IMotiveVideoView
{
  GdtMotiveVideoDialog$2(GdtMotiveVideoDialog paramGdtMotiveVideoDialog) {}
  
  public void a()
  {
    this.a.dismiss();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (GdtMotiveVideoDialog.d(this.a) == null)
    {
      QLog.i("GdtMotiveVideoDialog", 1, "mResultReceiver == null");
      return;
    }
    GdtMotiveVideoDialog.d(this.a).send(paramInt, paramIntent.getExtras());
  }
  
  public Activity b()
  {
    return GdtMotiveVideoDialog.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.2
 * JD-Core Version:    0.7.0.1
 */