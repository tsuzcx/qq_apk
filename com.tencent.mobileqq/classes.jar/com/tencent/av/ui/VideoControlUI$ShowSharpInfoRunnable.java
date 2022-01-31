package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lid;
import mwf;

class VideoControlUI$ShowSharpInfoRunnable
  implements Runnable
{
  VideoControlUI$ShowSharpInfoRunnable(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.f == null) || (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
      return;
    }
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    if (VideoLayerUIBase.a((lid)localObject1)) {}
    for (Object localObject2 = ((lid)localObject1).b;; localObject2 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a())
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "null";
      }
      localObject2 = localObject1;
      if (AudioHelper.b)
      {
        AVActivity localAVActivity = this.this$0.a();
        localObject2 = localObject1;
        if (localAVActivity != null)
        {
          localObject2 = localObject1;
          if (localAVActivity.a != null)
          {
            localObject2 = localAVActivity.a.a();
            localObject2 = (String)localObject1 + "\r\n" + (String)localObject2;
          }
        }
      }
      localObject1 = localObject2;
      try
      {
        localObject2 = (String)localObject2 + "\r\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + mwf.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a()).a();
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + "\r\n";
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label208:
        break label208;
      }
      this.this$0.f.setText((CharSequence)localObject1);
      QLog.w(this.this$0.d, 1, "ShowSharpInfo\n" + (String)localObject1);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ShowSharpInfoRunnable
 * JD-Core Version:    0.7.0.1
 */