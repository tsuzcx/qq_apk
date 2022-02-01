package com.tencent.av.ui;

import com.tencent.av.app.GAudioUIObserver;
import com.tencent.qphone.base.util.QLog;

class VideoNetStateBar$1
  extends GAudioUIObserver
{
  VideoNetStateBar$1(VideoNetStateBar paramVideoNetStateBar) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.i();
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onEnterRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar.1
 * JD-Core Version:    0.7.0.1
 */