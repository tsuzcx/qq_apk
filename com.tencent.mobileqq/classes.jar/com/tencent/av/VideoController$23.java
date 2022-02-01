package com.tencent.av;

import bgnt;
import com.tencent.av.app.VideoAppInterface;
import ley;
import mqq.app.MobileQQ;

class VideoController$23
  implements Runnable
{
  VideoController$23(VideoController paramVideoController, int paramInt, long paramLong) {}
  
  public void run()
  {
    this.this$0.j = null;
    this.this$0.a().a("acceptGAudioChat", 0);
    boolean bool = bgnt.g(this.this$0.a.getApplication().getApplicationContext());
    VideoController localVideoController = this.this$0;
    int j = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (bool) {}
    for (int i = 69;; i = 68)
    {
      localVideoController.a(j, l, i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.23
 * JD-Core Version:    0.7.0.1
 */