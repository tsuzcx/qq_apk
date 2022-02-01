package com.tencent.gdtad.api.motivevideo;

import acdv;
import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

final class GdtMotiveVideoFragment$1
  implements Runnable
{
  GdtMotiveVideoFragment$1(Activity paramActivity, Intent paramIntent, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    try
    {
      acdv localacdv = new acdv(this.jdField_a_of_type_AndroidAppActivity);
      localacdv.a(this.jdField_a_of_type_AndroidContentIntent);
      localacdv.a(this.jdField_a_of_type_AndroidOsResultReceiver);
      localacdv.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.i("GdtMotiveVideoFragment", 1, "GdtMotiveVideoDialog.show()", localException);
      GdtMotiveVideoFragment.a(this.jdField_a_of_type_AndroidOsResultReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */