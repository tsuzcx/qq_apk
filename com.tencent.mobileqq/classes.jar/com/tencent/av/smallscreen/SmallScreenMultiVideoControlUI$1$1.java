package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import bdne;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class SmallScreenMultiVideoControlUI$1$1
  implements Runnable
{
  SmallScreenMultiVideoControlUI$1$1(SmallScreenMultiVideoControlUI.1 param1, long paramLong) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$1.a.a() == this.jdField_a_of_type_Long) && (!bdne.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$1.a.a.getApp().getApplicationContext()).getBoolean("kick_out_self", false))) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$1.a.d(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.1.1
 * JD-Core Version:    0.7.0.1
 */