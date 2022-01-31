package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import ugk;
import ugq;
import ugr;
import vwj;

public class BottomVideoInfoWidget$8$1
  implements Runnable
{
  public BottomVideoInfoWidget$8$1(ugq paramugq) {}
  
  public void run()
  {
    Activity localActivity = this.a.jdField_a_of_type_Ugk.b();
    if (vwj.a().a(localActivity, new Bundle(), 467)) {
      ugk.a(this.a.jdField_a_of_type_Ugk, localActivity, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Ugk.l();
      return;
      ugk.a(this.a.jdField_a_of_type_Ugk, new ugr(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */