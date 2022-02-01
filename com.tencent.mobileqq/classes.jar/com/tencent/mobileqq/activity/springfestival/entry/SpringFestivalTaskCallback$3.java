package com.tencent.mobileqq.activity.springfestival.entry;

import android.view.View;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.UICallBack;
import com.tencent.qphone.base.util.QLog;

class SpringFestivalTaskCallback$3
  implements SpringFestivalTaskCallback.BrushHBStateChangeListener
{
  SpringFestivalTaskCallback$3(SpringFestivalTaskCallback paramSpringFestivalTaskCallback) {}
  
  public void a()
  {
    this.a.a(true);
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onBrushHBActivityStart statusTitle.h = " + SpringFestivalTaskCallback.a(this.a).a().getHeight() + ",mUICallBack = " + this.a.a);
    }
  }
  
  public void b()
  {
    this.a.a(false);
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onBrushHBActivityFinish");
    }
  }
  
  public void c()
  {
    this.a.b(true);
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onShowSpringFestivalTopBanner statusTitle.h = " + SpringFestivalTaskCallback.a(this.a).a().getHeight() + ",mUICallBack = " + this.a.a);
    }
  }
  
  public void d()
  {
    this.a.b(false);
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onHideSpringFestivalTopBanner");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback.3
 * JD-Core Version:    0.7.0.1
 */