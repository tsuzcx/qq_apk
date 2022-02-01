package com.tencent.av.smallscreen;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$1$1
  implements Runnable
{
  SmallScreenVideoController$1$1(SmallScreenVideoController.1 param1, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.c.this$0.s == null)
    {
      AVLog.printErrorLog("SmallScreenVideoController", "mVideoController is null");
      return;
    }
    Object localObject = this.c.this$0.s.k();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncReadDoubleGlassConfig Timer lCurrent=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", lLastTick=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", mCurrentVideoGlassWaitTime=");
      localStringBuilder.append(((SessionInfo)localObject).bT);
      localStringBuilder.append(", mCurrentDefaultTimeOutRule=");
      localStringBuilder.append(((SessionInfo)localObject).bU);
      localStringBuilder.append(", mCurrentVideoGlassSwitch=");
      localStringBuilder.append(this.c.this$0.d);
      QLog.d("SmallScreenVideoController", 1, localStringBuilder.toString());
      this.c.this$0.b(((SessionInfo)localObject).bU);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AsyncReadDoubleGlassConfig Timer lCurrent=");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", lLastTick=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", sessionInfo is null, mCurrentVideoGlassSwitch=");
    ((StringBuilder)localObject).append(this.c.this$0.d);
    AVLog.printErrorLog("SmallScreenVideoController", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1.1
 * JD-Core Version:    0.7.0.1
 */