package com.tencent.av.ui;

import com.tencent.av.app.GAudioUIObserver;
import com.tencent.qphone.base.util.QLog;

class VideoNetStateBar$1
  extends GAudioUIObserver
{
  VideoNetStateBar$1(VideoNetStateBar paramVideoNetStateBar) {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc-->GroupID=");
      localStringBuilder.append(paramLong2);
      QLog.d("VideoNetStateBar", 2, localStringBuilder.toString());
    }
    this.b.i();
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoomSuc-->GroupID=");
      localStringBuilder.append(paramLong2);
      QLog.d("VideoNetStateBar", 2, localStringBuilder.toString());
    }
    this.b.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar.1
 * JD-Core Version:    0.7.0.1
 */