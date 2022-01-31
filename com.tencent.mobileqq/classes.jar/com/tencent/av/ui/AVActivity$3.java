package com.tencent.av.ui;

import android.os.Handler;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVActivity$3
  implements Runnable
{
  AVActivity$3(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    long l;
    View localView;
    do
    {
      return;
      l = AudioHelper.b();
      localView = this.this$0.a(l);
    } while (localView == null);
    QLog.w(this.this$0.b, 1, "qav_UserGuide_for_more, 计划显示, seq[" + l + "]");
    localView.setAlpha(0.01F);
    localView.setVisibility(0);
    if (this.this$0.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.this$0.jdField_a_of_type_ComTencentAvUiVideoControlUI.y(l);
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.3.1(this, l), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.3
 * JD-Core Version:    0.7.0.1
 */