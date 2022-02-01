package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import wyc;
import wyi;
import wyj;
import ynm;

public class BottomVideoInfoWidget$8$1
  implements Runnable
{
  public BottomVideoInfoWidget$8$1(wyi paramwyi) {}
  
  public void run()
  {
    Activity localActivity = this.a.jdField_a_of_type_Wyc.b();
    if (ynm.a().a(localActivity, new Bundle(), 467)) {
      wyc.a(this.a.jdField_a_of_type_Wyc, localActivity, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Wyc.l();
      return;
      wyc.a(this.a.jdField_a_of_type_Wyc, new wyj(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */