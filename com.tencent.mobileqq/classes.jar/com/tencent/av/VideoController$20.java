package com.tencent.av;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VideoController$20
  implements Runnable
{
  VideoController$20(VideoController paramVideoController, ArrayList paramArrayList, boolean paramBoolean) {}
  
  public void run()
  {
    String str1 = this.this$0.a(this.a);
    if (this.this$0.U.startVideoRecv(this.a, this.b) == 0)
    {
      String str2 = VideoController.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestGVideo failed. viewInfos = ");
      localStringBuilder.append(str1);
      QLog.e(str2, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.20
 * JD-Core Version:    0.7.0.1
 */