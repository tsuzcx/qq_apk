package com.tencent.av.gaudio;

import com.tencent.av.utils.UITools;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class AVNotifyCenter$UpdateChattingTime
  implements Runnable
{
  WeakReference<AVNotifyCenter> a;
  
  public AVNotifyCenter$UpdateChattingTime(AVNotifyCenter paramAVNotifyCenter)
  {
    this.a = new WeakReference(paramAVNotifyCenter);
  }
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.a.get();
    if (localAVNotifyCenter == null) {
      return;
    }
    if (localAVNotifyCenter.a(String.valueOf(AVNotifyCenter.c(localAVNotifyCenter).h)))
    {
      localAVNotifyCenter.l = null;
      return;
    }
    if (localAVNotifyCenter.f != null) {
      localAVNotifyCenter.f.postDelayed(this, 2000L);
    }
    if (localAVNotifyCenter.n)
    {
      String str = UITools.a(localAVNotifyCenter.m);
      if (AVNotifyCenter.c(localAVNotifyCenter).c == 3)
      {
        localAVNotifyCenter.a(29, 0, Long.toString(AVNotifyCenter.c(localAVNotifyCenter).h), str);
        return;
      }
      localAVNotifyCenter.a(29, 0, AVNotifyCenter.c(localAVNotifyCenter).e, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.UpdateChattingTime
 * JD-Core Version:    0.7.0.1
 */