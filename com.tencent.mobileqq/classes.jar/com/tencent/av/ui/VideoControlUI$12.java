package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoControlUI$12
  extends ControlUIObserver
{
  VideoControlUI$12(VideoControlUI paramVideoControlUI, long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this);
      }
    }
    do
    {
      do
      {
        return;
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "onNotify_ScreenShot_Finish, flag[" + this.jdField_a_of_type_Long + "], _flag[" + paramLong + "], path[" + paramString + "], ret[" + paramBoolean + "], seq[" + this.b + "]");
      } while (this.jdField_a_of_type_Long != paramLong);
      if (paramBoolean) {
        ScreenShotHelper.a((Context)this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString, false);
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.12
 * JD-Core Version:    0.7.0.1
 */