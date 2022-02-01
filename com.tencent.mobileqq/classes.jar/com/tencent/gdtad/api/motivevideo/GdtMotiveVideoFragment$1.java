package com.tencent.gdtad.api.motivevideo;

import acnw;
import acqy;
import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;

final class GdtMotiveVideoFragment$1
  implements Runnable
{
  GdtMotiveVideoFragment$1(Activity paramActivity, Intent paramIntent, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    try
    {
      acnw localacnw = new acnw(this.jdField_a_of_type_AndroidAppActivity);
      localacnw.a(this.jdField_a_of_type_AndroidContentIntent);
      localacnw.a(this.jdField_a_of_type_AndroidOsResultReceiver);
      localacnw.show();
      return;
    }
    catch (Exception localException)
    {
      acqy.b("GdtMotiveVideoFragment", "dialog.show() err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */