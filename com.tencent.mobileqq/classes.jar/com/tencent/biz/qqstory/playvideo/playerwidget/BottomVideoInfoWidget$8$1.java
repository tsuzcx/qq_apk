package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import xmx;
import xnd;
import xne;
import zcf;

public class BottomVideoInfoWidget$8$1
  implements Runnable
{
  public BottomVideoInfoWidget$8$1(xnd paramxnd) {}
  
  public void run()
  {
    Activity localActivity = this.a.jdField_a_of_type_Xmx.b();
    if (zcf.a().a(localActivity, new Bundle(), 467)) {
      xmx.a(this.a.jdField_a_of_type_Xmx, localActivity, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Xmx.l();
      return;
      xmx.a(this.a.jdField_a_of_type_Xmx, new xne(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */