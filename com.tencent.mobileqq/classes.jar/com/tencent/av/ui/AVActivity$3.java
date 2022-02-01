package com.tencent.av.ui;

import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVActivity$3
  implements Runnable
{
  AVActivity$3(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {
      return;
    }
    long l = AudioHelper.b();
    View localView = this.this$0.a(l);
    Object localObject = (RelativeLayout)this.this$0.findViewById(2131373442);
    if ((localView != null) && (((RelativeLayout)localObject).getVisibility() != 0))
    {
      localObject = this.this$0.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qav_UserGuide_for_more, 计划显示, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      localView.setAlpha(0.01F);
      localView.setVisibility(0);
      if (this.this$0.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.this$0.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(l);
      }
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.3.1(this, l), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.3
 * JD-Core Version:    0.7.0.1
 */