package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import xwr;
import xwx;
import xwy;
import zmq;

public class BottomVideoInfoWidget$8$1
  implements Runnable
{
  public BottomVideoInfoWidget$8$1(xwx paramxwx) {}
  
  public void run()
  {
    Activity localActivity = this.a.jdField_a_of_type_Xwr.b();
    if (zmq.a().a(localActivity, new Bundle(), 467)) {
      xwr.a(this.a.jdField_a_of_type_Xwr, localActivity, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Xwr.l();
      return;
      xwr.a(this.a.jdField_a_of_type_Xwr, new xwy(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */