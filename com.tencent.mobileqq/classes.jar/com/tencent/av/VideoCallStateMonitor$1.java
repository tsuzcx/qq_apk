package com.tencent.av;

import axrn;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import lda;

public class VideoCallStateMonitor$1
  implements Runnable
{
  public VideoCallStateMonitor$1(lda paramlda, HashMap paramHashMap) {}
  
  public void run()
  {
    axrn.a(BaseApplication.getContext()).a(lda.a(this.this$0).getCurrentAccountUin(), "av_memory_details", true, 0L, 0L, this.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoCallStateMonitor.1
 * JD-Core Version:    0.7.0.1
 */