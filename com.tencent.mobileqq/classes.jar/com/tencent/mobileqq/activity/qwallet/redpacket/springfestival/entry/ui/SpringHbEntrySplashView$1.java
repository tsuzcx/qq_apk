package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import alij;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.qphone.base.util.QLog;

class SpringHbEntrySplashView$1
  implements Runnable
{
  SpringHbEntrySplashView$1(SpringHbEntrySplashView paramSpringHbEntrySplashView) {}
  
  public void run()
  {
    try
    {
      if (!SpringHbEntrySplashView.a(this.this$0))
      {
        if ((this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) && (this.this$0.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
          return;
        }
        this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.this$0.jdField_a_of_type_Alij.c(0);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_SpringBackRunnable", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntrySplashView.1
 * JD-Core Version:    0.7.0.1
 */