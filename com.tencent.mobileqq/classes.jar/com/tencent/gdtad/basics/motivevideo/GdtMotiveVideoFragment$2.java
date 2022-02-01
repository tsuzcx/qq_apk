package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

final class GdtMotiveVideoFragment$2
  implements Runnable
{
  GdtMotiveVideoFragment$2(Activity paramActivity, Intent paramIntent, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    try
    {
      GdtMotiveVideoDialog localGdtMotiveVideoDialog = new GdtMotiveVideoDialog(this.a);
      localGdtMotiveVideoDialog.a(this.b);
      localGdtMotiveVideoDialog.a(this.c);
      localGdtMotiveVideoDialog.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.i("GdtMotiveVideoFragment", 1, "GdtMotiveVideoDialog.show()", localException);
      GdtMotiveVideoFragment.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */