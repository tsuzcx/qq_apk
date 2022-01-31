package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import ugn;
import ugt;
import ugu;
import vwm;

public class BottomVideoInfoWidget$8$1
  implements Runnable
{
  public BottomVideoInfoWidget$8$1(ugt paramugt) {}
  
  public void run()
  {
    Activity localActivity = this.a.jdField_a_of_type_Ugn.b();
    if (vwm.a().a(localActivity, new Bundle(), 467)) {
      ugn.a(this.a.jdField_a_of_type_Ugn, localActivity, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Ugn.l();
      return;
      ugn.a(this.a.jdField_a_of_type_Ugn, new ugu(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */