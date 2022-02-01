package com.tencent.av.ui;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class VideoInviteUILock$1
  implements QavPanel.SlideAcceptListener
{
  VideoInviteUILock$1(VideoInviteUILock paramVideoInviteUILock, long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (VideoInviteUILock.a(this.b)) {
        return;
      }
      if (this.b.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        this.b.a("0X80051FE");
      } else if (this.b.a.g) {
        this.b.a("0X8004201");
      } else {
        this.b.a("0X8004205");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SlideAcceptListener, seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w("VideoInviteUILock", 1, localStringBuilder.toString());
      this.b.a.r = true;
      this.b.a.c(this.a);
      return;
    }
    if (this.b.a.g)
    {
      this.b.a("0X800439E");
      return;
    }
    this.b.a("0X80043FD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUILock.1
 * JD-Core Version:    0.7.0.1
 */