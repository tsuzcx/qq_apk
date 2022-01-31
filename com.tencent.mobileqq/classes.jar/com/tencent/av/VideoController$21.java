package com.tencent.av;

import bdee;
import com.tencent.av.app.VideoAppInterface;
import lid;
import mqq.app.MobileQQ;

class VideoController$21
  implements Runnable
{
  VideoController$21(VideoController paramVideoController, int paramInt, long paramLong) {}
  
  public void run()
  {
    this.this$0.j = null;
    this.this$0.a().a("startGAudioChat.1", 0);
    boolean bool = bdee.g(this.this$0.a.getApplication().getApplicationContext());
    VideoController localVideoController = this.this$0;
    int j = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (bool) {}
    for (int i = 71;; i = 70)
    {
      localVideoController.a(j, l, i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.21
 * JD-Core Version:    0.7.0.1
 */