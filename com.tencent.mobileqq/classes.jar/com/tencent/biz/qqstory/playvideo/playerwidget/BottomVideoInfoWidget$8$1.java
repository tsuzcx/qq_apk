package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import vzl;
import vzr;
import vzs;
import xpk;

public class BottomVideoInfoWidget$8$1
  implements Runnable
{
  public BottomVideoInfoWidget$8$1(vzr paramvzr) {}
  
  public void run()
  {
    Activity localActivity = this.a.jdField_a_of_type_Vzl.b();
    if (xpk.a().a(localActivity, new Bundle(), 467)) {
      vzl.a(this.a.jdField_a_of_type_Vzl, localActivity, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Vzl.l();
      return;
      vzl.a(this.a.jdField_a_of_type_Vzl, new vzs(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */