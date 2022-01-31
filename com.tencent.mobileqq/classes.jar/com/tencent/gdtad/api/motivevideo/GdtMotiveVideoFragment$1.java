package com.tencent.gdtad.api.motivevideo;

import aakp;
import aanp;
import android.app.Activity;
import android.content.Intent;

final class GdtMotiveVideoFragment$1
  implements Runnable
{
  GdtMotiveVideoFragment$1(Activity paramActivity, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      aakp localaakp = new aakp(this.jdField_a_of_type_AndroidAppActivity);
      localaakp.a(this.jdField_a_of_type_AndroidContentIntent);
      localaakp.show();
      return;
    }
    catch (Exception localException)
    {
      aanp.b("GdtMotiveVideoFragment", "dialog.show() err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */