package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$ShowSharpInfoRunnable
  implements Runnable
{
  VideoControlUI$ShowSharpInfoRunnable(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.g == null) || (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
      return;
    }
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    if (VideoLayerUIBase.a((SessionInfo)localObject1)) {}
    for (localObject1 = ((SessionInfo)localObject1).b;; localObject1 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "null";
      }
      localObject1 = localObject2;
      try
      {
        localObject2 = (String)localObject2 + "\r\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + SignalStrengthReport.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a()).a();
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + "\r\n";
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label145:
        break label145;
      }
      this.this$0.g.setText((CharSequence)localObject1);
      QLog.w(this.this$0.d, 1, "ShowSharpInfo\n" + (String)localObject1);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ShowSharpInfoRunnable
 * JD-Core Version:    0.7.0.1
 */