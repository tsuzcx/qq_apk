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
    Object localObject1;
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.g != null))
    {
      if (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        return;
      }
      localObject1 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      if (VideoLayerUIBase.a((SessionInfo)localObject1)) {
        localObject1 = ((SessionInfo)localObject1).v;
      } else {
        localObject1 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "null";
      }
      localObject1 = localObject2;
    }
    try
    {
      localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append((String)localObject2);
      localObject1 = localObject2;
      localStringBuilder.append("\r\n");
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append((String)localObject2);
      localObject1 = localObject2;
      localStringBuilder.append(SignalStrengthReport.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a()).a());
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append((String)localObject2);
      localObject1 = localObject2;
      localStringBuilder.append("\r\n");
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      label198:
      break label198;
    }
    this.this$0.g.setText((CharSequence)localObject1);
    Object localObject2 = this.this$0.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowSharpInfo\n");
    localStringBuilder.append((String)localObject1);
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ShowSharpInfoRunnable
 * JD-Core Version:    0.7.0.1
 */