package com.tencent.gdtad.api.motivevideo;

import aape;
import aase;
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
      aape localaape = new aape(this.jdField_a_of_type_AndroidAppActivity);
      localaape.a(this.jdField_a_of_type_AndroidContentIntent);
      localaape.show();
      return;
    }
    catch (Exception localException)
    {
      aase.b("GdtMotiveVideoFragment", "dialog.show() err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */