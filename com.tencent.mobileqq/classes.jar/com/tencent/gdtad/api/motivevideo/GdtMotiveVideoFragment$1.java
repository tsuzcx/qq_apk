package com.tencent.gdtad.api.motivevideo;

import acry;
import acvc;
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
      acry localacry = new acry(this.jdField_a_of_type_AndroidAppActivity);
      localacry.a(this.jdField_a_of_type_AndroidContentIntent);
      localacry.a(this.jdField_a_of_type_AndroidOsResultReceiver);
      localacry.show();
      return;
    }
    catch (Exception localException)
    {
      acvc.b("GdtMotiveVideoFragment", "dialog.show() err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */