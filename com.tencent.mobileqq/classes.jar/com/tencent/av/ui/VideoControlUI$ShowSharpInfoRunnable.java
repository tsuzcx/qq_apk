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
    if ((this.this$0.am != null) && (this.this$0.av != null))
    {
      if (this.this$0.al == null) {
        return;
      }
      localObject1 = this.this$0.am.k();
      if (VideoLayerUIBase.b((SessionInfo)localObject1)) {
        localObject1 = ((SessionInfo)localObject1).cf;
      } else {
        localObject1 = this.this$0.am.ae();
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
      localStringBuilder.append(SignalStrengthReport.a(this.this$0.am.i()).c());
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
    this.this$0.av.setText((CharSequence)localObject1);
    Object localObject2 = this.this$0.X;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowSharpInfo\n");
    localStringBuilder.append((String)localObject1);
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    this.this$0.al.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ShowSharpInfoRunnable
 * JD-Core Version:    0.7.0.1
 */